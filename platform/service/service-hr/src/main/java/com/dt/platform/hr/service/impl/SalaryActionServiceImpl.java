package com.dt.platform.hr.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.dt.platform.constants.enums.common.StatusYNEnum;
import com.dt.platform.constants.enums.hr.SalaryActionStatusEnum;
import com.dt.platform.constants.enums.hr.SalaryControllerParameterEnum;
import com.dt.platform.constants.enums.hr.SalaryPersonDetailStatusEnum;
import com.dt.platform.domain.hr.*;
import com.dt.platform.domain.hr.meta.PersonMeta;
import com.dt.platform.domain.hr.meta.SalaryActionMeta;
import com.dt.platform.hr.service.ISalaryCtlService;
import com.dt.platform.hr.service.ISalaryDetailService;
import com.github.foxnic.commons.lang.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;

import java.math.BigDecimal;
import java.util.Arrays;


import java.util.List;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import java.lang.reflect.Field;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.excel.ExcelStructure;
import java.io.InputStream;
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.meta.DBColumnMeta;
import com.github.foxnic.sql.expr.Select;
import java.util.ArrayList;
import com.dt.platform.hr.service.ISalaryActionService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

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
	private ISalaryCtlService salaryCtlService;

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
			return ErrorDesc.failureMessage("当前状态无法生成数据");
		}
		this.dao().fill(act).with(SalaryActionMeta.PERSON_LIST).with(SalaryActionMeta.SALARY_TPL)
				.with(SalaryActionMeta.SALARY_MONTH).execute();

		List<Person> personList=act.getPersonList();
		this.dao().fill(personList).with(PersonMeta.SALARY).with(PersonMeta.BANK).execute();
		if(personList==null||personList.size()==0){
			return ErrorDesc.failureMessage("当前没有需要发薪酬的人员");
		}
		dao.execute("delete from hr_salary_detail where action_id=?",id);
		//开始填充薪酬基本数据
		for(Person person:personList){
			Result r=this.createPersonData(person,act);
			if(!r.isSuccess()){
				return r;
			}
		}
		this.dao.execute("update hr_salary_action set status=? where id=?",SalaryActionStatusEnum.WAIT.code(),id);
		return ErrorDesc.success();
	}

	public Result createPersonData(Person person,SalaryAction act){
		Salary salary=person.getSalary();
		SalaryDetail detail=new SalaryDetail();
		detail.setTplId(act.getTplId());
		detail.setActionId(act.getId());
		detail.setPersonId(person.getId());
		detail.setActionMonth(act.getActionMonth());

		detail.setUserName(person.getName());
		detail.setJobNumber(person.getJobNumber());

		//处理银行卡
		if(person.getBank()==null){
			detail.setStatus(SalaryPersonDetailStatusEnum.ABNORMAL.code());
			detail.setOperMsg("没有获得银行卡账户信息");
			return ErrorDesc.success();

		}else{
			detail.setStatus(SalaryPersonDetailStatusEnum.INVALID.code());
			detail.setBank(person.getBank().getLabel());
			detail.setBankAccount(person.getPayrollCard());
			if(StringUtil.isBlank(detail.getBankAccount()) ||detail.getBankAccount().length()<10){
				detail.setStatus(SalaryPersonDetailStatusEnum.ABNORMAL.code());
				detail.setOperMsg("没有获得银行卡账户信息");
				return ErrorDesc.success();
			}
		}

		//处理薪酬
		if(salary==null){
			detail.setStatus(SalaryPersonDetailStatusEnum.ABNORMAL.code());
			detail.setOperMsg("没有获得人员薪酬信息");
			return ErrorDesc.success();
		}else{
			detail.setStatus(SalaryPersonDetailStatusEnum.INVALID.code());
		}


		//填充薪酬数据
		detail.setBaseSalary(salary.getBaseSalary());
		detail.setPostSalary(salary.getPostSalary());
		detail.setWorkingYearsSalary(salary.getWorkingYearsSalary());
		detail.setFixedSalary(salary.getFixedSalary());
		detail.setAchievementSalary(salary.getAchievementSalary());
		detail.setOvertimeSalary(salary.getOvertimeSalary());
		detail.setOtherSalary(salary.getOtherSalary());
		detail.setCommunicationSalary(salary.getCommunicationSalary());
		detail.setTrafficSalary(salary.getTrafficSalary());
		detail.setHousingSalary(salary.getHousingSalary());
		detail.setCommissionSalary(salary.getCommissionSalary());
		detail.setWelfaerGsbxBase(salary.getWelfaerGsbxBase());
		detail.setWorkingYearsSalary(salary.getWorkingYearsSalary());
		detail.setWelfaerGsbxCompany(salary.getWelfaerGsbxCompany());
		detail.setWelfaerGsbxPerson(salary.getWelfaerGsbxPerson());
		detail.setWelfaerSybxBase(salary.getWelfaerSybxBase());
		detail.setWelfaerSybxCompany(salary.getWelfaerSybxCompany());
		detail.setWelfaerSybxPerson(salary.getWelfaerSybxPerson());
		detail.setWelfaerSyebxBase(salary.getWelfaerSyebxBase());
		detail.setWelfaerSyebxCompany(salary.getWelfaerSyebxCompany());
		detail.setWelfaerSyebxPerson(salary.getWelfaerSyebxPerson());
		detail.setWelfaerYlbxBase(salary.getWelfaerSyebxPerson());
		detail.setWelfaerYlbxCompany(salary.getWelfaerYlbxCompany());
		detail.setWelfaerYlbxPerson (salary.getWelfaerYlbxPerson());
		detail.setWelfaerYrbxBase (salary.getWelfaerYrbxBase());
		detail.setWelfaerYrbxCompany(salary.getWelfaerYrbxCompany());
		detail.setWelfaerYrbxPerson(salary.getWelfaerYrbxPerson());
		detail.setWelfareZfgjjBase(salary.getWelfareZfgjjBase());
		detail.setWelfareZfgjjCompany(salary.getWelfareZfgjjCompany());
		detail.setWelfareZfgjjPerson(salary.getWelfareZfgjjPerson());
		detail.setPersonalTaxDbyl(salary.getPersonalTaxDbyl());
		detail.setPersonalTaxErzh(salary.getPersonalTaxErzh());
		detail.setPersonalTaxJxjy(salary.getPersonalTaxJxjy());
		detail.setPersonalTaxSylr(salary.getPersonalTaxSylr());
		detail.setPersonalTaxZfdk(salary.getPersonalTaxZfdk());
		detail.setPersonalTaxZfzj(salary.getPersonalTaxZfzj());
		detail.setPersonalTaxZnjy(salary.getPersonalTaxZnjy());


		////////////抵扣基数
		SalaryCtl parDkjs=salaryCtlService.getById(SalaryControllerParameterEnum.SALARY_PT_DKJS.code());
		if(parDkjs==null){
			return ErrorDesc.failureMessage("未获得抵扣基数");
		}else{
			detail.setPtDkjs(parDkjs.getValueD());
		}

		////////////高温补贴
		SalaryCtl parGwbt=salaryCtlService.getById(SalaryControllerParameterEnum.HIGH_TEMPERATURE_SALARY.code());
		detail.setHighTemperatureSalary(new BigDecimal("0.00"));
		if(parGwbt==null){
			return ErrorDesc.failureMessage("高温补贴未设置");
		}else{
			//是否参与高温补贴
			if(StatusYNEnum.YES.code().equals(parGwbt.getValueEn())){
				String monthStr=parGwbt.getValueStr();
				JSONArray monthArr=JSONArray.parseArray(monthStr);
				//当前月份是否是高温
				String[] curArr=act.getActionMonth().split("-");
				if(curArr.length!=2 ||monthArr==null){
					return ErrorDesc.failureMessage("获取月份失败");
				}
				String curMonth=curArr[1];
				if(monthArr.contains(curMonth)){
					detail.setHighTemperatureSalary(parGwbt.getValueD());
				}
			}
		}

		////////////计算税率
		//税率
		BigDecimal salaryForTaxPct=new BigDecimal("0.00");


		//抵扣 7项
		BigDecimal salaryForPersonalTax=new BigDecimal("0.00");
		salaryForPersonalTax.add(detail.getPersonalTaxDbyl())
				.add(detail.getPersonalTaxErzh())
				.add(detail.getPersonalTaxJxjy())
				.add(detail.getPersonalTaxSylr())
				.add(detail.getPersonalTaxZfzj())
				.add(detail.getPersonalTaxZnjy());

		//福利
		BigDecimal SalaryForWelfear=new BigDecimal("0.00");



		//应付工资
		BigDecimal SalaryForTotalAmount=new BigDecimal("0.00");
		SalaryForTotalAmount.add(detail.getBaseSalary())
				.add(detail.getPostSalary())
				.add(detail.getWorkingYearsSalary())
				.add(detail.getFixedSalary())
				.add(detail.getAchievementSalary())
				.add(detail.getOvertimeSalary())
				.add(detail.getOtherSalary())
				.add(detail.getCommunicationSalary())
				.add(detail.getTrafficSalary())
				.add(detail.getHousingSalary())
				.add(detail.getCommissionSalary())
				.add(detail.getHighTemperatureSalary());


		//实发工资
		BigDecimal SalaryForIssuedAmount=new BigDecimal("0.00");

		salaryDetailService.insert(detail,false);
		return ErrorDesc.success();
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