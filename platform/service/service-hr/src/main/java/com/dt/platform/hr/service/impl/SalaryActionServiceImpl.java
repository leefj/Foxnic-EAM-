package com.dt.platform.hr.service.impl;

import javax.annotation.Resource;
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
		List<SalaryDetail> detailList=act.getSalaryDetailList();

		this.dao().fill(detailList).with(SalaryDetailMeta.PERSON).with(SalaryDetailMeta.PERSON_SALARY).execute();
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
			tpl.setValidSalaryTplItem(validItemList);
		}
		Rcd rs=dao.queryRecord("select * from hr_salary_column where col_code='nonConversionRatio'");
		if(rs==null){
			tpl.setConfNonConversionRatio(new BigDecimal("1"));
		}else{
			tpl.setConfNonConversionRatio(rs.getBigDecimal("col_value"));
		}
		for(int i=0;i<detailList.size();i++){
			SalaryDetail salary=detailList.get(i);
			Logger.info("开始计算薪酬，人员:"+salary.getUserName()+",工号:"+salary.getJobNumber());
			Result r=calRuleContent(salary,tpl);
			if(!r.isSuccess()){
				salary.setStatus(SalaryPersonDetailStatusEnum.ABNORMAL.code());
				salary.setOperMsg(r.getMessage());
				salaryDetailService.update(salary,SaveMode.NOT_NULL_FIELDS,false);
				return r;
			}
			salary.setStatus(SalaryPersonDetailStatusEnum.CAL_FINISH.code());
			salaryDetailService.update(salary,SaveMode.NOT_NULL_FIELDS,false);
		}

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
//		//开始循环获取数据
//		List<SalaryTplItem> itemList=act.getSalaryTpl().getValidSalaryTplItem();
//		for(int i=0;i<itemList.size();i++){
//			SalaryTplItem item=itemList.get(i);
//			Result res=calRuleContent(person,detail,item);
//			if(!res.isSuccess()){
//				return res;
//			}
//		}

//		//填充薪酬数据
//		detail.setBaseSalary(salary.getBaseSalary());
//		detail.setPostSalary(salary.getPostSalary());
//		detail.setWorkingYearsSalary(salary.getWorkingYearsSalary());
//		detail.setFixedSalary(salary.getFixedSalary());
//		detail.setAchievementSalary(salary.getAchievementSalary());
//		detail.setOvertimeSalary(salary.getOvertimeSalary());
//		detail.setOtherSalary(salary.getOtherSalary());
//		detail.setCommunicationSalary(salary.getCommunicationSalary());
//		detail.setTrafficSalary(salary.getTrafficSalary());
//		detail.setHousingSalary(salary.getHousingSalary());
//		detail.setCommissionSalary(salary.getCommissionSalary());
//		detail.setWelfaerGsbxBase(salary.getWelfaerGsbxBase());
//		detail.setWorkingYearsSalary(salary.getWorkingYearsSalary());
//		detail.setWelfaerGsbxCompany(salary.getWelfaerGsbxCompany());
//		detail.setWelfaerGsbxPerson(salary.getWelfaerGsbxPerson());
//		detail.setWelfaerSybxBase(salary.getWelfaerSybxBase());
//		detail.setWelfaerSybxCompany(salary.getWelfaerSybxCompany());
//		detail.setWelfaerSybxPerson(salary.getWelfaerSybxPerson());
//		detail.setWelfaerSyebxBase(salary.getWelfaerSyebxBase());
//		detail.setWelfaerSyebxCompany(salary.getWelfaerSyebxCompany());
//		detail.setWelfaerSyebxPerson(salary.getWelfaerSyebxPerson());
//		detail.setWelfaerYlbxBase(salary.getWelfaerSyebxPerson());
//		detail.setWelfaerYlbxCompany(salary.getWelfaerYlbxCompany());
//		detail.setWelfaerYlbxPerson (salary.getWelfaerYlbxPerson());
//		detail.setWelfaerYrbxBase (salary.getWelfaerYrbxBase());
//		detail.setWelfaerYrbxCompany(salary.getWelfaerYrbxCompany());
//		detail.setWelfaerYrbxPerson(salary.getWelfaerYrbxPerson());
//		detail.setWelfareZfgjjBase(salary.getWelfareZfgjjBase());
//		detail.setWelfareZfgjjCompany(salary.getWelfareZfgjjCompany());
//		detail.setWelfareZfgjjPerson(salary.getWelfareZfgjjPerson());
//		detail.setPersonalTaxDbyl(salary.getPersonalTaxDbyl());
//		detail.setPersonalTaxErzh(salary.getPersonalTaxErzh());
//		detail.setPersonalTaxJxjy(salary.getPersonalTaxJxjy());
//		detail.setPersonalTaxSylr(salary.getPersonalTaxSylr());
//		detail.setPersonalTaxZfdk(salary.getPersonalTaxZfdk());
//		detail.setPersonalTaxZfzj(salary.getPersonalTaxZfzj());
//		detail.setPersonalTaxZnjy(salary.getPersonalTaxZnjy());
//
//
//
//		////////////抵扣基数
//		SalaryCtl parDkjs=salaryCtlService.getById(SalaryControllerParameterEnum.SALARY_PT_DKJS.code());
//		if(parDkjs==null){
//			return ErrorDesc.failureMessage("未获得抵扣基数");
//		}else{
//			detail.setPtDkjs(parDkjs.getValueD());
//		}
//
//		////////////高温补贴
//		SalaryCtl parGwbt=salaryCtlService.getById(SalaryControllerParameterEnum.HIGH_TEMPERATURE_SALARY.code());
//		detail.setHighTemperatureSalary(new BigDecimal("0.00"));
//		if(parGwbt==null){
//			return ErrorDesc.failureMessage("高温补贴未设置");
//		}else{
//			//是否参与高温补贴
//			if(StatusYNEnum.YES.code().equals(parGwbt.getValueEn())){
//				String monthStr=parGwbt.getValueStr();
//				JSONArray monthArr=JSONArray.parseArray(monthStr);
//				//当前月份是否是高温
//				String[] curArr=act.getActionMonth().split("-");
//				if(curArr.length!=2 ||monthArr==null){
//					return ErrorDesc.failureMessage("获取月份失败");
//				}
//				String curMonth=curArr[1];
//				if(monthArr.contains(curMonth)){
//					detail.setHighTemperatureSalary(parGwbt.getValueD());
//				}
//			}
//		}
//
//		//此处计算动态薪酬，例如绩效、考勤、加班、奖励、惩处，提成等、略
//
//
//
//
//		//月收入,税前 所有工资+补贴
//		System.out.println("detail.getDeductGh()"+detail.getDeductGh());
//		BigDecimal salaryForTotalAmount=new BigDecimal("0.00").add(detail.getBaseSalary())
//				.add(detail.getPostSalary())
//				.add(detail.getWorkingYearsSalary())
//				.add(detail.getFixedSalary())
//				.add(detail.getAchievementSalary())
//				.add(detail.getOvertimeSalary())
//				.add(detail.getOtherSalary())
//				.add(detail.getCommunicationSalary())
//				.add(detail.getTrafficSalary())
//				.add(detail.getHousingSalary())
//				.add(detail.getCommissionSalary())
//				.add(detail.getHighTemperatureSalary())
//				.subtract(detail.getDeductGh())
//				.subtract(detail.getDeductKq())
//				.subtract(detail.getDeductOther())
//				.subtract(detail.getDeductPersonalTaxRed());
//		//抵扣 7项
//		BigDecimal salaryForPersonalTaxTotal=new BigDecimal("0.00").add(detail.getPersonalTaxDbyl())
//				.add(detail.getPersonalTaxErzh())
//				.add(detail.getPersonalTaxJxjy())
//				.add(detail.getPersonalTaxSylr())
//				.add(detail.getPersonalTaxZfzj())
//				.add(detail.getPersonalTaxZnjy())
//				.add(detail.getPersonalTaxSylr());
//
//		//所有五险一金个人部分汇总
//		BigDecimal welfaerPersonTotalAmount=new BigDecimal("0.00").add(detail.getPersonalTaxDbyl())
//				.add(detail.getWelfaerGsbxPerson())
//				.add(detail.getWelfaerSybxPerson())
//				.add(detail.getWelfaerSyebxPerson())
//				.add(detail.getWelfaerYlbxPerson())
//				.add(detail.getWelfaerYrbxPerson())
//				.add(detail.getWelfaerYlbxPerson());
//
//
//		//税率,速算扣除数
//		BigDecimal salaryForTaxPct=new BigDecimal("3.00");
//		BigDecimal salaryForTaxDiv=new BigDecimal("0.00");
//		//1 b1>b2, 0 b1=b2,-1 b1<b2
//		//包括36000
//		//<=36000
//		if(salaryForTotalAmount.compareTo(new BigDecimal("36000.00"))==-1||salaryForTotalAmount.compareTo(new BigDecimal("36000.00"))==0){
//			 salaryForTaxPct=new BigDecimal("3.00");
//			 salaryForTaxDiv=new BigDecimal("0.00");
//		}else if(salaryForTotalAmount.compareTo(new BigDecimal("36000.00"))==1 && (  salaryForTotalAmount.compareTo(new BigDecimal("144000.00"))==0 || salaryForTotalAmount.compareTo(new BigDecimal("144000.00"))==-1) ){
//			//>360000 && <=144000
//			salaryForTaxPct=new BigDecimal("10.00");
//			salaryForTaxDiv=new BigDecimal("2520.00");
//		}else if(salaryForTotalAmount.compareTo(new BigDecimal("144000.00"))==1 && (  salaryForTotalAmount.compareTo(new BigDecimal("300000.00"))==0 || salaryForTotalAmount.compareTo(new BigDecimal("300000.00"))==-1) ){
//			//>144000 && <=300000
//			salaryForTaxPct=new BigDecimal("20.00");
//			salaryForTaxDiv=new BigDecimal("16920.00");
//		}else if(salaryForTotalAmount.compareTo(new BigDecimal("300000.00"))==1 && (  salaryForTotalAmount.compareTo(new BigDecimal("420000.00"))==0 || salaryForTotalAmount.compareTo(new BigDecimal("420000.00"))==-1) ){
//			//>300000 && <=420000
//			salaryForTaxPct=new BigDecimal("25.00");
//			salaryForTaxDiv=new BigDecimal("31920.00");
//		}else if(salaryForTotalAmount.compareTo(new BigDecimal("420000.00"))==1 && (  salaryForTotalAmount.compareTo(new BigDecimal("660000.00"))==0 || salaryForTotalAmount.compareTo(new BigDecimal("660000.00"))==-1) ){
//			//>420000 && <=660000
//			salaryForTaxPct=new BigDecimal("30.00");
//			salaryForTaxDiv=new BigDecimal("52920.00");
//		}else if(salaryForTotalAmount.compareTo(new BigDecimal("660000.00"))==1 && (  salaryForTotalAmount.compareTo(new BigDecimal("960000.00"))==0 || salaryForTotalAmount.compareTo(new BigDecimal("960000.00"))==-1) ){
//			//>660000 && <=960000
//			salaryForTaxPct=new BigDecimal("35.00");
//			salaryForTaxDiv=new BigDecimal("85920.00");
//		}else if(salaryForTotalAmount.compareTo(new BigDecimal("660000.00"))==1 ){
//			//>960000
//			salaryForTaxPct=new BigDecimal("45.00");
//			salaryForTaxDiv=new BigDecimal("181920.00");
//		}
//
//		//个税：(月收入-五险一金(个人)-起征点(5000)-依法确定其他扣除-专项附加)*税率-速算扣除数
//		BigDecimal salaryForPersonTaxValue=new BigDecimal("0.00");
//		BigDecimal salaryForTaxT1=new BigDecimal("0.00").add(salaryForTotalAmount).subtract(welfaerPersonTotalAmount).subtract(new BigDecimal("5000.00"));
//		//1 b1>b2, 0 b1=b2,-1 b1<b2
//		if(salaryForTaxT1.compareTo(new BigDecimal("0.00")) ==1){
//			BigDecimal salaryForTaxT2=salaryForTaxT1.subtract(salaryForPersonalTaxTotal);
//			if(salaryForTaxT2.compareTo(new BigDecimal("0.00")) ==1){
//				//需要计算
//				BigDecimal salaryForTaxT3=salaryForTaxT2.multiply(salaryForTaxPct).divide(new BigDecimal("100.00"));
//				BigDecimal salaryForTaxT4=salaryForTaxT3.subtract(salaryForTaxDiv);
//				if(salaryForTaxT4.compareTo(new BigDecimal("0.00"))==1){
//					salaryForPersonTaxValue=new BigDecimal("0.00").add(salaryForTaxT4);
//				}
//			}
//		}
//
//		//实发工资
//		BigDecimal salaryForIssuedAmount=new BigDecimal("0.00").add(salaryForTotalAmount).subtract(welfaerPersonTotalAmount).subtract(salaryForPersonTaxValue);
//		detail.setPtGrsds(salaryForPersonTaxValue);
//		detail.setPtDkjs(new BigDecimal("5000.00"));
//		detail.setPtSlPct(salaryForTaxPct);
//		detail.setTotalAmount(salaryForTotalAmount);
//		detail.setPayAmount(salaryForTotalAmount);
//		detail.setIssuedAmount(salaryForIssuedAmount);
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
			map.put("person", person);
			map.put("curSalary", salary);
			map.put("salary", personSalary);
			Logger.info(person.getName()+",表达式:"+express);
			if(StringUtil.isBlank(express)){
				Logger.info("计算开始,人员:"+salary.getUserName()+",工号:"+salary.getJobNumber()+",code:"+item.getCode()+",expr:"+express+",报错表达式为空");
				return ErrorDesc.failureMessage(express+",计算表达式为空");
			}
			Object result = calculationValue(express,map);
			BigDecimal bResult = new BigDecimal(result.toString()).setScale(2,BigDecimal.ROUND_HALF_UP);
			Logger.info("计算开始,人员:"+salary.getUserName()+",工号:"+salary.getJobNumber()+",code:"+item.getCode()+",expr:"+express+",结果:"+bResult);
			BeanUtil.setFieldValue(salary,item.getCode(),bResult);
		}
		return ErrorDesc.success();
	}

	private String calculationValue(String jexlExp, Map<String, Object> map){
		JexlBuilder jb=new JexlBuilder();
		Map<String, Object> funcs =new HashMap<>();
		funcs.put("commonFunction",new SalaryUtilService());
		jb.namespaces(funcs);
		JexlEngine jexl =jb.create();
		JexlExpression expression = jexl.createExpression(jexlExp);
		JexlContext jc = new MapContext();
		for (String key : map.keySet()) {
			jc.set(key, map.get(key));
		}
		Object r=expression.evaluate(jc);
		if (null ==r) {
			return "";
		}
		return r.toString();
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