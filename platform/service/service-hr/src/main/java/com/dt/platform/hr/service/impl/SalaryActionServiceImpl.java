package com.dt.platform.hr.service.impl;

import javax.annotation.Resource;
import javax.persistence.criteria.Order;

import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.constants.enums.hr.SalaryActionStatusEnum;
import com.dt.platform.constants.enums.hr.SalaryPersonDetailStatusEnum;
import com.dt.platform.domain.hr.*;
import com.dt.platform.domain.hr.meta.PersonMeta;
import com.dt.platform.domain.hr.meta.SalaryActionMeta;
import com.dt.platform.domain.hr.meta.SalaryDetailMeta;
import com.dt.platform.hr.service.*;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.sql.expr.OrderBy;
import org.apache.commons.jexl3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.math.BigDecimal;
import java.util.*;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import java.lang.reflect.Field;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import org.github.foxnic.web.framework.dao.DBConfigs;

/**
 * <p>
 * 薪酬发放服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-04 15:19:31
*/


@Service("HrSalaryActionService")

public class SalaryActionServiceImpl extends SuperService<SalaryAction> implements ISalaryActionService {


	@Autowired
	private ISalaryDetailService salaryDetailService;

	@Autowired
	private ISalaryTplService salaryTplService;

	@Autowired
	private ISalaryIncomeTaxService salaryIncomeTaxService;

	@Autowired
	private ISalaryCtlService salaryCtlService;


	@Autowired
	private ISalaryTplItemService salaryTplItemService;
	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }



	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param salaryAction  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(SalaryAction salaryAction,boolean throwsException) {
		salaryAction.setStatus(SalaryActionStatusEnum.DRAFT.code());
		Result r=super.insert(salaryAction,throwsException);
		return r;
	}

	@Override
	public Result createData(String id) {
		SalaryAction act=this.getById(id);
		this.dao.execute("update hr_salary_action set status=? where id=?",SalaryActionStatusEnum.ACTING.code(),id);
		if(act.getStatus().equals(SalaryActionStatusEnum.FINISH.code())){
			return ErrorDesc.failureMessage ("当前状态无法生成数据");
		}
		this.dao().fill(act).with(SalaryActionMeta.PERSON_LIST).with(SalaryActionMeta.SALARY_TPL)
				.with(SalaryActionMeta.SALARY_MONTH).execute();


		if(StringUtil.isBlank(act.getSalaryTpl())){
			return ErrorDesc.failureMessage ("未配置薪酬模版");
		}

		SalaryTpl tpl=act.getSalaryTpl();
		SalaryTplItem itemQuery=new SalaryTplItem();
		itemQuery.setStatus("enable");
		itemQuery.setTplId(tpl.getId());
		OrderBy orderBy=new OrderBy();
		orderBy.desc("sort");
		List<SalaryTplItem> validItemList=salaryTplItemService.queryList(itemQuery,orderBy);
		if(validItemList.size()==0){
			return ErrorDesc.failureMessage ("薪酬模版未配置计算公式");
		}else{
			act.getSalaryTpl().setValidSalaryTplItem(validItemList);
		}

		List<Person> personList=act.getPersonList();
		this.dao().fill(personList).with(PersonMeta.SALARY).with(PersonMeta.BANK).execute();

		if(personList==null||personList.size()==0){
			return ErrorDesc.failureMessage("当前没有需要发薪酬的人员");
		}
		dao.execute("delete from hr_salary_detail where action_id=?",id);

		//开始填充薪酬基本数据
		for(Person person:personList){
			if(StatusYNEnum.YES.code().equals(person.getSalaryPayOut())){
				Result r=this.createPersonData(person,act);
				if(!r.isSuccess()){
					return r;
				}
			}else{
				Logger.info("当前账户发放薪酬禁用，用户ID:"+person.getId()+",姓名:"+person.getName());
			}
		}
		this.dao.execute("update hr_salary_action set status=? where id=?",SalaryActionStatusEnum.WAIT.code(),id);
		return ErrorDesc.success();
	}





	@Override
	public Result calculate(String id){
		SalaryAction act=this.getById(id);
		this.dao().fill(act).with(SalaryActionMeta.SALARY_DETAIL_LIST).with(SalaryActionMeta.SALARY_TPL).execute();

		//获取人员信息，人员薪酬信息
		List<SalaryDetail> detailList=act.getSalaryDetailList();
		this.dao().fill(detailList).with(SalaryDetailMeta.PERSON).with(SalaryDetailMeta.PERSON_SALARY).execute();

		//填充模版
		SalaryTpl tpl=act.getSalaryTpl();
		String curMonth=act.getActionMonth().split("-")[1];
		tpl.setConfCurMonth(curMonth);
		fillTpl(tpl);

		//开始计算
		for(int i=0;i<detailList.size();i++){
			SalaryDetail salary=detailList.get(i);
			Result r=calculatePerson(salary,tpl);
			if(!r.isSuccess()){
				return r;
			}
		}
		return ErrorDesc.success();
	}

	@Override
	public Result fillTpl(SalaryTpl tpl){
		//填充模版信息
		SalaryTplItem itemQuery=new SalaryTplItem();
		itemQuery.setStatus("enable");
		itemQuery.setTplId(tpl.getId());
		OrderBy orderBy=new OrderBy();
		orderBy.asc("sort");
		List<SalaryTplItem> validItemList=salaryTplItemService.queryList(itemQuery,orderBy);
		if(validItemList.size()==0){
			return ErrorDesc.failureMessage ("薪酬模版未配置计算公式");
		}else{
			tpl.setValidSalaryTplItem(validItemList);
		}
		//初始化参数///
		//是否高温月
		SalaryCtl ctl=new SalaryCtl();
		String highTemperatureMonthStr=dao.queryRecord("select * from hr_salary_ctl where code='high_temperature_month'").getString("value_str");
		String curMonth=tpl.getConfCurMonth();
		if(highTemperatureMonthStr.indexOf(curMonth)>0){
			ctl.setIsHighTemperatureMonth("1");
		}else{
			ctl.setIsHighTemperatureMonth("0");
		}
		ctl.setWelfaerGsbxPerson(dao.queryRecord("select * from hr_salary_ctl where code='welfaer_gsbx_person'").getBigDecimal("value_d"));
		ctl.setWelfaerSybxPerson(dao.queryRecord("select * from hr_salary_ctl where code='welfaer_sybx_person'").getBigDecimal("value_d"));
		ctl.setWelfaerYlbxPerson(dao.queryRecord("select * from hr_salary_ctl where code='welfaer_yrbx_person'").getBigDecimal("value_d"));
		ctl.setWelfaerSyebxPerson(dao.queryRecord("select * from hr_salary_ctl where code='welfaer_syebx_person'").getBigDecimal("value_d"));
		ctl.setWelfaerYlbxPerson(dao.queryRecord("select * from hr_salary_ctl where code='welfaer_ylbx_person'").getBigDecimal("value_d"));
		ctl.setWelfareZfgjjPerson(dao.queryRecord("select * from hr_salary_ctl where code='welfare_zfgjj_person'").getBigDecimal("value_d"));
		ctl.setNonConversionRatio(dao.queryRecord("select * from hr_salary_ctl where code='non_conversion_ratio'").getBigDecimal("value_d"));
		tpl.setSalaryCtl(ctl);
		//获得所得税信息
		SalaryIncomeTax taxQuery=new SalaryIncomeTax();
		OrderBy taxOrderBy=new OrderBy();
		taxOrderBy.asc("end");
		tpl.setSalaryIncomeTaxList(salaryIncomeTaxService.queryList(taxQuery,taxOrderBy));
		return ErrorDesc.success();
	}

	/*
	* salary to fill list:person,personSalary
	* tpl to fill list:incomeTax,salaryCtl
	* */
	@Override
	public Result calculatePerson(SalaryDetail salary,SalaryTpl tpl){

		Logger.info("开始计算薪酬，人员:"+salary.getUserName()+",工号:"+salary.getJobNumber());
		Result r=calRuleContent(salary,tpl);
		if(!r.isSuccess()){
			salary.setStatus(SalaryPersonDetailStatusEnum.ABNORMAL.code());
			salary.setOperMsg(r.getMessage());
			salaryDetailService.update(salary,SaveMode.NOT_NULL_FIELDS,false);
			return r;
		}
		salary.setOperMsg("计算完成");
		salary.setStatus(SalaryPersonDetailStatusEnum.CAL_FINISH.code());
		salaryDetailService.update(salary,SaveMode.NOT_NULL_FIELDS,false);
		return ErrorDesc.success();
	}


	public Result createPersonData(Person person,SalaryAction act){
		if(person.getSalary()==null){
			this.dao().fill(person).with(PersonMeta.SALARY).execute();
		}
		if(person.getBank()==null){
			this.dao().fill(person).with(PersonMeta.BANK).execute();
		}
		Salary salary=person.getSalary();
		dao.execute("delete from hr_salary_detail where action_id=? and person_id=?",act.getId(),person.getId());
		SalaryDetail detailTmp=new SalaryDetail();
		detailTmp.setTplId(act.getTplId());
		detailTmp.setActionId(act.getId());
		detailTmp.setPersonId(person.getId());
		detailTmp.setActionMonth(act.getActionMonth());
		detailTmp.setUserName(person.getName());
		detailTmp.setJobNumber(person.getJobNumber());
		salaryDetailService.insert(detailTmp,true);
		SalaryDetail detail=salaryDetailService.getById(detailTmp.getId());
		//处理银行卡
		if(person.getBank()==null){
			detail.setStatus(SalaryPersonDetailStatusEnum.ABNORMAL.code());
			detail.setOperMsg("没有获得银行卡账户信息");
			salaryDetailService.update(detail,SaveMode.NOT_NULL_FIELDS,true);
			return ErrorDesc.success();
		}else{
			detail.setStatus(SalaryPersonDetailStatusEnum.NOT_PROCESS.code());
			detail.setBank(person.getBank().getLabel());
			detail.setBankAccount(person.getPayrollCard());
			if(StringUtil.isBlank(detail.getBankAccount()) ||detail.getBankAccount().length()<6){
				detail.setStatus(SalaryPersonDetailStatusEnum.ABNORMAL.code());
				detail.setOperMsg("银行卡账户信息错误");
				salaryDetailService.update(detail,SaveMode.NOT_NULL_FIELDS,true);
				return ErrorDesc.success();
			}
		}
		//处理薪酬
		if(salary==null){
			detail.setStatus(SalaryPersonDetailStatusEnum.ABNORMAL.code());
			detail.setOperMsg("没有获得人员薪酬信息");
			salaryDetailService.update(detail,SaveMode.NOT_NULL_FIELDS,true);
			return ErrorDesc.success();
		}else{
			detail.setStatus(SalaryPersonDetailStatusEnum.NOT_PROCESS.code());
		}
		detail.setCreateTime(new Date());
		detail.setUpdateTime(new Date());
		salaryDetailService.update(detail,SaveMode.NOT_NULL_FIELDS,true);
		return ErrorDesc.success();
	}

	public Result calRuleContent(SalaryDetail salary,SalaryTpl tpl){

		List<SalaryTplItem> items=tpl.getValidSalaryTplItem();
		Person person=salary.getPerson();
		Salary personSalary=salary.getPersonSalary();
		for(int i=0;i<items.size();i++){
			SalaryTplItem item=items.get(i);
			String express=item.getExpressionValue();
			if("ontrial".equals(person.getEmployeeTypeCode())&&"baseSalary".equals(item.getCode())){
				express="("+express+"*"+tpl.getConfNonConversionRatio().toString()+")";
			}
			if("practice".equals(person.getEmployeeTypeCode())&&"baseSalary".equals(item.getCode())){
				express="("+express+"*"+tpl.getConfNonConversionRatio().toString()+")";
			}
			Logger.info("计算开始,人员:"+salary.getUserName()+",工号:"+salary.getJobNumber()+",code:"+item.getCode()+",expr:"+express);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("curSalary", salary);
			//person info
			map.put("person", person);
			map.put("salary", personSalary);
			//tpl info
			map.put("parameter", tpl.getSalaryCtl());
			map.put("incomeTax", tpl.getSalaryIncomeTaxList());
			Logger.info(person.getName()+",表达式:"+express);
			if(StringUtil.isBlank(express)){
				Logger.info("计算开始,人员:"+salary.getUserName()+",工号:"+salary.getJobNumber()+",code:"+item.getCode()+",expr:"+express+",报错表达式为空");
				return ErrorDesc.failureMessage(express+",计算表达式为空");
			}
			Result<Object> r=calculationValue(express,map);
			if(!r.isSuccess()){
				return r;
			}
			Object result = r.getData().toString();
			BigDecimal bResult = new BigDecimal(result.toString()).setScale(2,BigDecimal.ROUND_HALF_UP);
			Logger.info("计算开始,人员:"+salary.getUserName()+",工号:"+salary.getJobNumber()+",code:"+item.getCode()+",expr:"+express+",结果:"+bResult);
			BeanUtil.setFieldValue(salary,item.getCode(),bResult);
		}
		return ErrorDesc.success();
	}

	private Result<Object> calculationValue(String jexlExp, Map<String, Object> map){
		JexlBuilder jb=new JexlBuilder();
		Map<String, Object> funcs =new HashMap<>();
		funcs.put("cF",new SalaryUtilService());
		jb.namespaces(funcs);
		JexlEngine jexl =jb.create();
		JexlExpression expression = jexl.createExpression(jexlExp);
		JexlContext jc = new MapContext();
		for (String key : map.keySet()) {
			jc.set(key, map.get(key));
		}
		Object r=null;
		try {
			r=expression.evaluate(jc);
		}catch (org.apache.commons.jexl3.JexlException e){
			ErrorDesc.failureMessage(e.getMessage());
		}
		if(StringUtil.isBlank(r)){
			return ErrorDesc.failureMessage("结果为null,表达式:"+expression);
		}
		return ErrorDesc.success().data(r);
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param salaryAction 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(SalaryAction salaryAction) {
		return this.insert(salaryAction,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param salaryActionList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<SalaryAction> salaryActionList) {
		return super.insertList(salaryActionList);
	}

	/**
	 * 按主键删除薪酬发放
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		SalaryAction salaryAction = new SalaryAction();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		salaryAction.setId(id);
		try {
			boolean suc = dao.deleteEntity(salaryAction);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除薪酬发放
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		SalaryAction salaryAction = new SalaryAction();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		salaryAction.setId(id);
		salaryAction.setDeleted(true);
		salaryAction.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		salaryAction.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(salaryAction,SaveMode.NOT_NULL_FIELDS);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}

	/**
	 * 更新，如果执行错误，则抛出异常
	 * @param salaryAction 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(SalaryAction salaryAction , SaveMode mode) {
		return this.update(salaryAction,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param salaryAction 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(SalaryAction salaryAction , SaveMode mode,boolean throwsException) {
		Result r=super.update(salaryAction , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param salaryActionList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<SalaryAction> salaryActionList , SaveMode mode) {
		return super.updateList(salaryActionList , mode);
	}

	
	/**
	 * 按主键更新薪酬发放
	 *
	 * @param id 主键
	 * @return 是否更新成功
	 */
	public boolean update(DBField field,Object value , String id) {
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		if(!field.table().name().equals(this.table())) throw new IllegalArgumentException("更新的数据表["+field.table().name()+"]与服务对应的数据表["+this.table()+"]不一致");
		int suc=dao.update(field.table().name()).set(field.name(), value).where().and("id = ? ",id).top().execute();
		return suc>0;
	}

	
	/**
	 * 按主键获取薪酬发放
	 *
	 * @param id 主键
	 * @return SalaryAction 数据对象
	 */
	public SalaryAction getById(String id) {
		SalaryAction sample = new SalaryAction();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<SalaryAction> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<SalaryAction> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, SalaryAction> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, SalaryAction::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<SalaryAction> queryList(SalaryActionVO sample) {
		return super.queryList(sample);
	}


	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<SalaryAction> queryPagedList(SalaryActionVO sample, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, pageSize, pageIndex);
	}

	/**
	 * 分页查询实体集，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @param condition 其它条件
	 * @param pageSize 分页条数
	 * @param pageIndex 页码
	 * @return 查询结果
	 * */
	@Override
	public PagedList<SalaryAction> queryPagedList(SalaryAction sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param salaryAction 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(SalaryAction salaryAction) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(salaryAction, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	/**
	 * 批量检查引用
	 * @param ids  检查这些ID是否又被外部表引用
	 * */
	@Override
	public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
		// 默认无业务逻辑，返回此行；有业务逻辑需要校验时，请修改并使用已注释的行代码！！！
		return MapUtil.asMap(ids,new ReferCause(false));
		// return super.hasRefers(FoxnicWeb.BPM_PROCESS_INSTANCE.FORM_DEFINITION_ID,ids);
	}





}