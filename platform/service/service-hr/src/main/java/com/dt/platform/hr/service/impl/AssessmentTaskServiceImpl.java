package com.dt.platform.hr.service.impl;

import javax.annotation.Resource;

import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.common.StatusSuccessFailedEnum;
import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.constants.enums.hr.AssessmentBillConfirmStatusEnum;
import com.dt.platform.constants.enums.hr.AssessmentBillStatusEnum;
import com.dt.platform.domain.hr.AssessmentBill;
import com.dt.platform.domain.hr.AssessmentBillUserMap;
import com.dt.platform.domain.hr.meta.AssessmentBillUserMapMeta;
import com.dt.platform.domain.hr.meta.AssessmentTaskMeta;
import com.dt.platform.hr.service.IAssessmentBillService;
import com.dt.platform.hr.service.IAssessmentBillUserMapService;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.sql.expr.Insert;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.EmployeeVO;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.util.Arrays;


import com.dt.platform.domain.hr.AssessmentTask;
import com.dt.platform.domain.hr.AssessmentTaskVO;
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
import com.dt.platform.hr.service.IAssessmentTaskService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 考核任务服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-09 16:34:53
*/


@Service("HrAssessmentTaskService")

public class AssessmentTaskServiceImpl extends SuperService<AssessmentTask> implements IAssessmentTaskService {

	@Autowired
	private IAssessmentBillService assessmentBillService;


	@Autowired
	private IAssessmentBillUserMapService assessmentBillUserMapService;
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
	 * @param assessmentTask  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AssessmentTask assessmentTask,boolean throwsException) {
		Result r=super.insert(assessmentTask,throwsException);

		if(r.isSuccess()){
			dao.execute("update hr_assessment_indicator set assessment_id=? where assessment_id=?",assessmentTask.getId(),assessmentTask.getSelectedCode());
			List<String> posIds=assessmentTask.getPositionIds();
			if(posIds!=null){
				for(int i=0;i<posIds.size();i++){
					Insert ins=new Insert("sys_mapping_owner");
					ins.set("id",IDGenerator.getSnowflakeIdString());
					ins.set("owner_id",assessmentTask.getId());
					ins.set("selected_code",posIds.get(i));
					ins.set("owner","pos");
					dao.execute(ins);
				}
			}
			List<String> orgIds=assessmentTask.getOrganizationIds();
			if(posIds!=null){
				for(int i=0;i<orgIds.size();i++){
					Insert ins=new Insert("sys_mapping_owner");
					ins.set("id",IDGenerator.getSnowflakeIdString());
					ins.set("owner_id",assessmentTask.getId());
					ins.set("selected_code",orgIds.get(i));
					ins.set("owner","org");
					dao.execute(ins);
				}
			}
			List<String> personIds=assessmentTask.getPersonIds();
			if(personIds!=null){
				for(int i=0;i<personIds.size();i++){
					Insert ins=new Insert("sys_mapping_owner");
					ins.set("id",IDGenerator.getSnowflakeIdString());
					ins.set("owner_id",assessmentTask.getId());
					ins.set("selected_code",personIds.get(i));
					ins.set("owner","person");
					dao.execute(ins);
				}
			}
			List<String> exPersonIds=assessmentTask.getPersonIds();
			if(exPersonIds!=null){
				for(int i=0;i<personIds.size();i++){
					Insert ins=new Insert("sys_mapping_owner");
					ins.set("id",IDGenerator.getSnowflakeIdString());
					ins.set("owner_id",assessmentTask.getId());
					ins.set("selected_code",exPersonIds.get(i));
					ins.set("owner","experson");
					dao.execute(ins);
				}
			}
		}
		return r;
	}


	@Override
	public Result createTask(String taskId,String billIdValue) {
		AssessmentTask assessmentTask=this.getById(taskId);
		String billId="";
		if(StringUtil.isBlank(billIdValue)){
			 billId=IDGenerator.getSnowflakeIdString();
		}else{
			billId=billIdValue;
		}

		EmployeeVO employeeVO=new EmployeeVO();
		employeeVO.setStatus("active");
		Result<List<Employee>> listRes= EmployeeServiceProxy.api().queryList(employeeVO);
		if(!listRes.isSuccess()){
			return listRes;
		}
		List<Employee> list=listRes.data();
		if(list==null||list.size()==0){
			return ErrorDesc.failureMessage("当前没有匹配的人员");
		}
		String sureCode="";
		if(YesNoEnum.YES.code().equals(assessmentTask.getHasHrConfirm())){
			sureCode=AssessmentBillConfirmStatusEnum.NO_SURE.code();
		}else{
			sureCode=AssessmentBillConfirmStatusEnum.NO_NEED.code();
		}

		List<AssessmentBillUserMap> userMapList=new ArrayList<>();
		for(Employee employee:list){
			AssessmentBillUserMap userMap=new AssessmentBillUserMap();
			userMap.setAssesseeId(employee.getId());
			userMap.setStatus(StatusEnableEnum.ENABLE.code());
			userMap.setIsConfirm(sureCode);
			userMap.setBillId(billId);
			//userMap.setOwnerId(taskId);
			userMap.setHrUserId(assessmentTask.getHrUserId());
			userMapList.add(userMap);
		}
		Result createDataRes=createUserMapData(userMapList,assessmentTask,billId);
		if(!createDataRes.isSuccess()){
			return createDataRes;
		}

		//插入任务
		if(StringUtil.isBlank(billIdValue)){
			AssessmentBill bill=new AssessmentBill();
			bill.setId(billId);
			bill.setTaskName(assessmentTask.getName());
			bill.setStatus(AssessmentBillStatusEnum.WAIT.code());
			bill.setStime(new Date());
			bill.setIsShow(YesNoEnum.no.code());
			bill.setEtime(new Date());
			bill.setTaskId(taskId);
			assessmentBillService.insert(bill,false);
		}else{
			AssessmentBill bill=new AssessmentBill();
			bill.setId(billId);
			bill.setStatus(AssessmentBillStatusEnum.WAIT.code());
			assessmentBillService.update(bill,SaveMode.NOT_NULL_FIELDS,false);
		}
		return ErrorDesc.success();
	}




	@Override
	public Result createUserMapData(List<AssessmentBillUserMap> userMapList,AssessmentTask assessmentTask,String billId){
		dao.fill(userMapList)
				.with(AssessmentBillUserMapMeta.LEADER_USER_REL)
				.execute();

		for(AssessmentBillUserMap user:userMapList){
			//fill 数据
			if(!StringUtil.isBlank(user.getLeaderUserRel())){
				user.setLeaderId(user.getLeaderUserRel().getId());
			}
			//assessmentBillUserMapService.insert(user,false);

		}

		//上一级的上一级，需要分开获取
		//找同事，也需要先获取上一级领导信息
		dao.fill(userMapList)
				.with(AssessmentBillUserMapMeta.SECOND_LEADER_USER_REL)
				.with(AssessmentBillUserMapMeta.SAME_USER_LIST_REL)
				.execute();

		for(AssessmentBillUserMap user:userMapList){
			user.setBillId(billId);
			user.setStatus(StatusEnableEnum.ENABLE.code());
			//user.setOwnerId(assessmentTask.getId());
			user.setHrUserId(assessmentTask.getHrUserId());

			if(!StringUtil.isBlank(user.getSecondLeaderUserRel())){
				user.setSecondLeaderId(user.getSecondLeaderUserRel().getId());
			}
			//同时
			List<Employee> sameUserList=user.getSameUserListRel();
			List<String> sameUserIds=new ArrayList<>();
			if (sameUserList!=null&&sameUserList.size()>0){
				for(int i=0;i<sameUserList.size();i++){
					//互评里，排除自己
					if(sameUserList.get(i).getId().equals(user.getAssesseeId())){
						continue;
					}
					sameUserIds.add(sameUserList.get(i).getId());
				}
				user.setSameUserIds(sameUserIds);
			}
			user.setResult(StatusSuccessFailedEnum.SUCCESS.code());
			//assessmentBillUserMapService.update(user,SaveMode.NOT_NULL_FIELDS,false);
			assessmentBillUserMapService.insert(user,false);
		}

		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param assessmentTask 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssessmentTask assessmentTask) {
		return this.insert(assessmentTask,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param assessmentTaskList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssessmentTask> assessmentTaskList) {
		return super.insertList(assessmentTaskList);
	}

	
	/**
	 * 按主键删除考核任务
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssessmentTask assessmentTask = new AssessmentTask();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assessmentTask.setId(id);
		try {
			boolean suc = dao.deleteEntity(assessmentTask);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除考核任务
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssessmentTask assessmentTask = new AssessmentTask();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assessmentTask.setId(id);
		assessmentTask.setDeleted(true);
		assessmentTask.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assessmentTask.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assessmentTask,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assessmentTask 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssessmentTask assessmentTask , SaveMode mode) {
		return this.update(assessmentTask,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param assessmentTask 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssessmentTask assessmentTask , SaveMode mode,boolean throwsException) {
		Result r=super.update(assessmentTask , mode , throwsException);
		if(r.isSuccess()){
			dao.execute("delete from sys_mapping_owner where owner_id=?",assessmentTask.getId());
			List<String> posIds=assessmentTask.getPositionIds();
			if(posIds!=null){
				for(int i=0;i<posIds.size();i++){
					Insert ins=new Insert("sys_mapping_owner");
					ins.set("id",IDGenerator.getSnowflakeIdString());
					ins.set("owner_id",assessmentTask.getId());
					ins.set("selected_code",posIds.get(i));
					ins.set("owner","pos");
					dao.execute(ins);
				}
			}
			List<String> orgIds=assessmentTask.getOrganizationIds();
			if(orgIds!=null){
				for(int i=0;i<orgIds.size();i++){
					Insert ins=new Insert("sys_mapping_owner");
					ins.set("id",IDGenerator.getSnowflakeIdString());
					ins.set("owner_id",assessmentTask.getId());
					ins.set("selected_code",orgIds.get(i));
					ins.set("owner","org");
					dao.execute(ins);
				}
			}
			List<String> personIds=assessmentTask.getPersonIds();
			if(personIds!=null){
				for(int i=0;i<personIds.size();i++){
					Insert ins=new Insert("sys_mapping_owner");
					ins.set("id",IDGenerator.getSnowflakeIdString());
					ins.set("owner_id",assessmentTask.getId());
					ins.set("selected_code",personIds.get(i));
					ins.set("owner","person");
					dao.execute(ins);
				}
			}
			List<String> exPersonIds=assessmentTask.getPersonIds();
			if(exPersonIds!=null){
				for(int i=0;i<personIds.size();i++){
					Insert ins=new Insert("sys_mapping_owner");
					ins.set("id",IDGenerator.getSnowflakeIdString());
					ins.set("owner_id",assessmentTask.getId());
					ins.set("selected_code",exPersonIds.get(i));
					ins.set("owner","experson");
					dao.execute(ins);
				}
			}
		}

		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param assessmentTaskList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssessmentTask> assessmentTaskList , SaveMode mode) {
		return super.updateList(assessmentTaskList , mode);
	}

	
	/**
	 * 按主键更新考核任务
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
	 * 按主键获取考核任务
	 *
	 * @param id 主键
	 * @return AssessmentTask 数据对象
	 */
	public AssessmentTask getById(String id) {
		AssessmentTask sample = new AssessmentTask();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<AssessmentTask> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<AssessmentTask> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, AssessmentTask> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, AssessmentTask::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssessmentTask> queryList(AssessmentTaskVO sample) {
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
	public PagedList<AssessmentTask> queryPagedList(AssessmentTaskVO sample, int pageSize, int pageIndex) {
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
	public PagedList<AssessmentTask> queryPagedList(AssessmentTask sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param assessmentTask 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AssessmentTask assessmentTask) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(assessmentTask, SYS_ROLE.NAME);
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