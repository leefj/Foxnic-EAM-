package com.dt.platform.hr.service.impl;

import javax.annotation.Resource;

import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.constants.enums.hr.AssessmentBillStatusEnum;
import com.dt.platform.constants.enums.hr.AssessmentBillTaskDtlRelationshipEnum;
import com.dt.platform.constants.enums.hr.AssessmentBillTaskDtlStatusEnum;
import com.dt.platform.domain.hr.*;
import com.dt.platform.domain.hr.meta.AssessmentBillMeta;
import com.dt.platform.domain.hr.meta.AssessmentBillTaskMeta;
import com.dt.platform.domain.hr.meta.AssessmentTaskMeta;
import com.dt.platform.hr.service.*;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.sql.expr.In;
import com.github.foxnic.sql.expr.Insert;
import org.github.foxnic.web.domain.hrm.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;

import java.util.*;


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

import org.github.foxnic.web.framework.dao.DBConfigs;

import java.util.stream.Collectors;

/**
 * <p>
 * 考核单据服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-08 20:54:09
*/


@Service("HrAssessmentBillService")

public class AssessmentBillServiceImpl extends SuperService<AssessmentBill> implements IAssessmentBillService {

	@Autowired
	private IAssessmentTaskService assessmentTaskService;

	@Autowired
	private IAssessmentBillTaskService assessmentBillTaskService;

	@Autowired
	private IAssessmentBillTaskDtlService assessmentBillTaskDtlService;

	@Autowired
	private IAssessmentBillTaskPaperService assessmentBillTaskPaperService;

	@Autowired
	private IAssessmentIndicatorValueService assessmentIndicatorValueService;
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
	 * @param assessmentBill  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AssessmentBill assessmentBill,boolean throwsException) {
		Result r=super.insert(assessmentBill,throwsException);
		return r;
	}

	@Override



	public Result cancel(String id) {
		AssessmentBill assessmentBill=this.getById(id);
		if(AssessmentBillStatusEnum.WAIT.code().equals(assessmentBill.getStatus())
				||AssessmentBillStatusEnum.ACTING.code().equals(assessmentBill.getStatus())
		){
			dao.execute("update hr_assessment_bill set status=? where id=?",AssessmentBillStatusEnum.CANCEL.code(),id);

		}else{
			return ErrorDesc.failureMessage("当前状态不能重新生成数据");
		}
		return ErrorDesc.success();
	}



	//下发任务
	@Override
	public Result release(String id) {
		AssessmentBill assessmentBill=this.getById(id);
        dao.fill(assessmentBill).with(AssessmentBillMeta.ASSESSMENT_TASK).execute();


        //下发的时候生成临时数据，主要保存主表数，
		AssessmentTask dataTask=assessmentBill.getAssessmentTask();
		dataTask.setId(null);
		dataTask.setOwner("data");
		assessmentTaskService.insert(dataTask,false);
		dao.execute("update hr_assessment_bill set task_data_id=? where id=?",dataTask.getId(),id);
		assessmentBill.setTaskDataId(dataTask.getId());
		dao.fill(assessmentBill).with(AssessmentBillMeta.ASSESSMENT_DATA_TASK).execute();
		List<String> userList=new ArrayList<>();

		//处理自评
		RcdSet zpRs=dao.query("select distinct assessee_id user_id from hr_assessment_bill_user_map where deleted=0 and status='enable' and bill_id=?",id);
		List<String> zpList=zpRs.getValueList("user_id",String.class);
		if (YesNoEnum.YES.code().equals(assessmentBill.getAssessmentDataTask().getHasSelfAssessment())){
			userList.addAll(zpList);
		}

		//处理互评
		RcdSet hpRs=dao.query("select distinct selected_code user_id from sys_mapping_owner a,hr_assessment_bill_user_map b where a.owner_id=b.id and a.deleted=0  and b.status='enable' and a.owner='same_user' and b.bill_id=?",id);
		List<String> hpList=hpRs.getValueList("user_id",String.class);
		if (YesNoEnum.YES.code().equals(assessmentBill.getAssessmentDataTask().getHasSameAssessment())){
			userList.addAll(hpList);
		}

		//直接领导
		RcdSet leaderRs=dao.query("select distinct leader_id user_id from hr_assessment_bill_user_map where deleted=0 and status='enable' and bill_id=? and leader_id is not null",id);
		List<String> leaderList=leaderRs.getValueList("user_id",String.class);
		if (YesNoEnum.YES.code().equals(assessmentBill.getAssessmentDataTask().getHasSameAssessment())){
			userList.addAll(leaderList);
		}

		//处理上上级别领导
		RcdSet secondleaderRs=dao.query("select distinct second_leader_id from hr_assessment_bill_user_map where deleted=0 and status='enable' and bill_id=? and second_leader_id is not null",id);
		List<String> secondleaderList=secondleaderRs.getValueList("user_id",String.class);
		userList.addAll(secondleaderList);
		if (YesNoEnum.YES.code().equals(assessmentBill.getAssessmentDataTask().getHasSameAssessment())){
			userList.addAll(secondleaderList);
		}
		List<String> userListUniq = userList.stream().distinct().collect(Collectors.toList());

		if(userListUniq.size()==0){
			return ErrorDesc.failureMessage("当前无用户需要生成");
		}

		dao.execute("update hr_assessment_bill_task set deleted=1 where bill_id=?",id);

		//生成考核单
		List<AssessmentBillTask> billTaskList=new ArrayList<>();
		for(int i=0;i<userListUniq.size();i++){
			String userId=userListUniq.get(i);
			AssessmentBillTask billTask=new AssessmentBillTask();
			billTask.setBillId(id);
			billTask.setRcdTime(new Date());
			billTask.setAssessorId(userId);
			assessmentBillTaskService.insert(billTask,false);
			billTaskList.add(billTask);
		}

		//关联数据
		dao.fill(billTaskList).with(AssessmentBillTaskMeta.WITH_LEADER_LIST)
				.with(AssessmentBillTaskMeta.WITH_SECOND_LEADER_LIST)
				.with(AssessmentBillTaskMeta.WITH_SAME_USER_LIST)
				.execute();

		for(int i=0;i<billTaskList.size();i++){
			Result r=createUserBillTaskDtl(assessmentBill,billTaskList.get(i), zpList, hpList,leaderList,secondleaderList);
		}
		return ErrorDesc.success();
	}


	//assessor_id 考核人
	public Result createUserBillTaskDtl(AssessmentBill bill,AssessmentBillTask assessmentBillTask,List<String> zpList,List<String> hpList,List<String> leaderList,List<String> secondleaderList){
		//如果存在，则删除

		//dao.execute("update hr_assessment_bill_task set deleted=1 where bill_id=? and assessor_id=?",bill.getId(),assessmentBillTask.getAssessorId());
		String ifSelf=bill.getAssessmentDataTask().getHasSelfAssessment();
		String ifLeader=bill.getAssessmentDataTask().getHasLeaderAssessment();
		String ifSameUser=bill.getAssessmentDataTask().getHasSameAssessment();
		String ifSecondLeader=bill.getAssessmentDataTask().getHasSecondLeaderAssessment();

		String billTaskId=assessmentBillTask.getId();
		List<AssessmentBillTaskDtl> dtlList=new ArrayList<>();
		//如果存在4个明细，则插入
		if (YesNoEnum.YES.code().equals(ifSelf)){
			//自评
			if(zpList.contains(assessmentBillTask.getAssessorId())){
				AssessmentBillTaskDtl billTaskDtl=new AssessmentBillTaskDtl();
				billTaskDtl.setBillTaskId(billTaskId);
				billTaskDtl.setStatus(AssessmentBillTaskDtlStatusEnum.WAIT.code());
				billTaskDtl.setRcdTime(new Date());
				billTaskDtl.setRelationship(AssessmentBillTaskDtlRelationshipEnum.SELF.code());
				dtlList.add(billTaskDtl);
			}
		}
		if(YesNoEnum.YES.code().equals(ifLeader)){
			if(leaderList.contains(assessmentBillTask.getAssessorId())) {
				AssessmentBillTaskDtl billTaskDtl = new AssessmentBillTaskDtl();
				billTaskDtl.setBillTaskId(billTaskId);
				billTaskDtl.setStatus(AssessmentBillTaskDtlStatusEnum.WAIT.code());
				billTaskDtl.setRcdTime(new Date());
				billTaskDtl.setRelationship(AssessmentBillTaskDtlRelationshipEnum.LEADER.code());
				dtlList.add(billTaskDtl);
			}
		}
		if (YesNoEnum.YES.code().equals(ifSameUser)){
			if(hpList.contains(assessmentBillTask.getAssessorId())) {
				AssessmentBillTaskDtl billTaskDtl = new AssessmentBillTaskDtl();
				billTaskDtl.setBillTaskId(billTaskId);
				billTaskDtl.setStatus(AssessmentBillTaskDtlStatusEnum.WAIT.code());
				billTaskDtl.setRcdTime(new Date());
				billTaskDtl.setRelationship(AssessmentBillTaskDtlRelationshipEnum.SAMEUSER.code());
				dtlList.add(billTaskDtl);
			}
		}

		if (YesNoEnum.YES.code().equals(ifSecondLeader)){
			if(secondleaderList.contains(assessmentBillTask.getAssessorId())) {
				AssessmentBillTaskDtl billTaskDtl=new AssessmentBillTaskDtl();
				billTaskDtl.setBillTaskId(billTaskId);
				billTaskDtl.setStatus(AssessmentBillTaskDtlStatusEnum.WAIT.code());
				billTaskDtl.setRcdTime(new Date());
				billTaskDtl.setRelationship(AssessmentBillTaskDtlRelationshipEnum.SECONDLEADER.code());
				dtlList.add(billTaskDtl);
			}
		}
		if(dtlList.size()>0){
			assessmentBillTaskDtlService.insertList(dtlList);
		}

		//生成paper数据，在任务首次生成，此处不生成
		return ErrorDesc.success();
	}


	@Override
	public Result createPaperDataAll(String id) {
		AssessmentBill bill=this.getById(id);
		dao.fill(bill).with(AssessmentBillMeta.ASSESSMENT_BILL_TASK_LIST).execute();
		List<AssessmentBillTask> list=bill.getAssessmentBillTaskList();
		dao.fill(list).with(AssessmentBillTaskMeta.ASSESSMENT_TASK)
				.with(AssessmentBillTaskMeta.ASSESSMENT_BILL_TASK_DTL_LIST)
				.with(AssessmentBillTaskMeta.WITH_SAME_USER_LIST)
				.with(AssessmentBillTaskMeta.WITH_LEADER_LIST)
				.with(AssessmentBillTaskMeta.WITH_SECOND_LEADER_LIST)
				.with(AssessmentBillTaskMeta.ASSESSOR)
				.execute();
		List<AssessmentTask> indList=CollectorUtil.collectList(list, AssessmentBillTask::getAssessmentTask);
		dao.fill(indList).with(AssessmentTaskMeta.ASSESSMENT_INDICATOR_LIST)
				.execute();

		for(int i=0;i<list.size();i++){
			Result r=createPaperData(list.get(i));
			if(r.isSuccess()){
				Logger.info("生成评分表成功,billTask:"+list.get(i).getId());
			}
		}
		return ErrorDesc.success();
	}

	public Result createPaperData(AssessmentBillTask assessmentBillTask){
		dao.execute("update hr_assessment_bill_task_paper set deleted=1 where bill_task_id=?",assessmentBillTask.getId());
		AssessmentTask assessmentTask=assessmentBillTask.getAssessmentTask();
		if(assessmentTask==null){
			dao.fill(assessmentBillTask).with(AssessmentBillTaskMeta.ASSESSMENT_TASK).execute();
			assessmentTask=assessmentBillTask.getAssessmentTask();
		}

		List<AssessmentIndicator> indicatorList=assessmentTask.getAssessmentIndicatorList();
		if(indicatorList==null){
			dao.fill(assessmentTask).with(AssessmentTaskMeta.ASSESSMENT_INDICATOR_LIST).execute();
			indicatorList=assessmentTask.getAssessmentIndicatorList();
		}

		List<AssessmentBillTaskDtl> taskDtlList= assessmentBillTask.getAssessmentBillTaskDtlList();
		if(taskDtlList==null){
			dao.fill(assessmentBillTask).with(AssessmentBillTaskMeta.ASSESSMENT_BILL_TASK_DTL_LIST).execute();
			taskDtlList=assessmentBillTask.getAssessmentBillTaskDtlList();
		}

		List<AssessmentBillTaskPaper> paperList=new ArrayList<>();
		List<String> paperIdsList=new ArrayList<>();
		for(int i=0;i<taskDtlList.size();i++){
			AssessmentBillTaskDtl dtl=taskDtlList.get(i);
			List<Employee> users=null;
			if(AssessmentBillTaskDtlRelationshipEnum.SELF.code().equals(dtl.getRelationship())){
				users=new ArrayList<>();
				Employee user=assessmentBillTask.getAssessor();
				if(users==null){
					dao.fill(assessmentBillTask).with(AssessmentBillTaskMeta.ASSESSOR).execute();
					if(AssessmentBillTaskMeta.ASSESSOR!=null){
						users.add(user);
					}
				}else{
					users.add(user);
				}

				if(users!=null&&users.size()>0){
					List<String> userIdsList=CollectorUtil.collectList(users, Employee::getId);
					List<String> userIdsUniq = userIdsList.stream().distinct().collect(Collectors.toList());
					for(int j=0;j<userIdsUniq.size();j++){
						String paperId=IDGenerator.getSnowflakeIdString();
						AssessmentBillTaskPaper paper=new AssessmentBillTaskPaper();
						paper.setId(paperId);
						paper.setBillTaskDtlId(dtl.getId());
						paper.setBillTaskId(assessmentBillTask.getId());
						paper.setBillId(assessmentBillTask.getBillId());
						paper.setAssesseeId(userIdsUniq.get(i));
						paper.setAssessorId(assessmentBillTask.getAssessorId());
						paperIdsList.add(paperId);
						paperList.add(paper);
					}
				}

			}else if(AssessmentBillTaskDtlRelationshipEnum.LEADER.code().equals(dtl.getRelationship())){
				users=assessmentBillTask.getWithLeaderList();
				if(users==null){
					dao.fill(assessmentBillTask).with(AssessmentBillTaskMeta.WITH_LEADER_LIST).execute();
					users=assessmentBillTask.getWithLeaderList();
				}
				if(users!=null&&users.size()>0){
					List<String> userIdsList=CollectorUtil.collectList(users, Employee::getId);
					List<String> userIdsUniq = userIdsList.stream().distinct().collect(Collectors.toList());
					for(int j=0;j<userIdsUniq.size();j++){
						String paperId=IDGenerator.getSnowflakeIdString();
						AssessmentBillTaskPaper paper=new AssessmentBillTaskPaper();
						paper.setId(paperId);
						paper.setBillTaskDtlId(dtl.getId());
						paper.setBillTaskId(assessmentBillTask.getId());
						paper.setBillId(assessmentBillTask.getBillId());
						paper.setAssesseeId(userIdsUniq.get(i));
						paper.setAssessorId(assessmentBillTask.getAssessorId());
						paperIdsList.add(paperId);
						paperList.add(paper);
					}
				}
			}else if(AssessmentBillTaskDtlRelationshipEnum.SECONDLEADER.code().equals(dtl.getRelationship())){
				 users=assessmentBillTask.getWithSecondLeaderList();
				if(users==null){
					dao.fill(assessmentBillTask).with(AssessmentBillTaskMeta.WITH_SECOND_LEADER_LIST).execute();
					users=assessmentBillTask.getWithSecondLeaderList();
				}

				if(users!=null&&users.size()>0){
					List<String> userIdsList=CollectorUtil.collectList(users, Employee::getId);
					List<String> userIdsUniq = userIdsList.stream().distinct().collect(Collectors.toList());
					for(int j=0;j<userIdsUniq.size();j++){
						String paperId=IDGenerator.getSnowflakeIdString();
						AssessmentBillTaskPaper paper=new AssessmentBillTaskPaper();
						paper.setId(paperId);
						paper.setBillTaskDtlId(dtl.getId());
						paper.setBillTaskId(assessmentBillTask.getId());
						paper.setBillId(assessmentBillTask.getBillId());
						paper.setAssesseeId(userIdsUniq.get(i));
						paper.setAssessorId(assessmentBillTask.getAssessorId());
						paperIdsList.add(paperId);
						paperList.add(paper);
					}
				}
			}else if(AssessmentBillTaskDtlRelationshipEnum.SAMEUSER.code().equals(dtl.getRelationship())){
				 users=assessmentBillTask.getWithSameUserList();
				if(users==null){
					dao.fill(assessmentBillTask).with(AssessmentBillTaskMeta.WITH_SAME_USER_LIST).execute();
					users=assessmentBillTask.getWithSameUserList();
				}

				if(users!=null&&users.size()>0){
					List<String> userIdsList=CollectorUtil.collectList(users, Employee::getId);
					List<String> userIdsUniq = userIdsList.stream().distinct().collect(Collectors.toList());
					for(int j=0;j<userIdsUniq.size();j++){
						String paperId=IDGenerator.getSnowflakeIdString();
						AssessmentBillTaskPaper paper=new AssessmentBillTaskPaper();
						paper.setId(paperId);
						paper.setBillTaskDtlId(dtl.getId());
						paper.setBillTaskId(assessmentBillTask.getId());
						paper.setBillId(assessmentBillTask.getBillId());
						paper.setAssesseeId(userIdsUniq.get(i));
						paper.setAssessorId(assessmentBillTask.getAssessorId());
						paperIdsList.add(paperId);
						paperList.add(paper);
					}
				}
			}

		}
		if(paperList.size()>0){
			List<AssessmentIndicatorValue> valueList=new ArrayList<>();
			//插入所有试卷
			for(int k=0;k<indicatorList.size();k++){
				for(int kk=0;kk<paperIdsList.size();kk++){
					AssessmentIndicatorValue value=new AssessmentIndicatorValue();
					value.setTaskPaperId(paperIdsList.get(kk));
					value.setIndicatorId(indicatorList.get(k).getId());
					value.setSn(indicatorList.get(k).getSn());
					valueList.add(value);
				}
			}
			if(valueList.size()>0){
				assessmentIndicatorValueService.insertList(valueList);
			}
			assessmentBillTaskPaperService.insertList(paperList);
		}


		return ErrorDesc.success();
	}


	@Override
	public Result reset(String id) {
		AssessmentBill assessmentBill=this.getById(id);
		if(AssessmentBillStatusEnum.WAIT.code().equals(assessmentBill.getStatus())
				||AssessmentBillStatusEnum.ACTING.code().equals(assessmentBill.getStatus())
				||AssessmentBillStatusEnum.CANCEL.code().equals(assessmentBill.getStatus())){
			dao.execute("update hr_assessment_bill_task set deleted=1 where bill_id=?",id);
			dao.execute("update hr_assessment_bill_user_map set deleted=1 where bill_id=?",id);
		}else{
			return ErrorDesc.failureMessage("当前状态不能重新生成数据");
		}

		Result r=assessmentTaskService.createTask(assessmentBill.getTaskId(),id);
		return r;
	}

	@Override
	public Result copy(String id) {
		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param assessmentBill 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssessmentBill assessmentBill) {
		return this.insert(assessmentBill,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param assessmentBillList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssessmentBill> assessmentBillList) {
		return super.insertList(assessmentBillList);
	}

	
	/**
	 * 按主键删除考核单据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssessmentBill assessmentBill = new AssessmentBill();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assessmentBill.setId(id);
		try {
			boolean suc = dao.deleteEntity(assessmentBill);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除考核单据
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssessmentBill assessmentBill = new AssessmentBill();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assessmentBill.setId(id);
		assessmentBill.setDeleted(true);
		assessmentBill.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assessmentBill.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assessmentBill,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assessmentBill 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssessmentBill assessmentBill , SaveMode mode) {
		return this.update(assessmentBill,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param assessmentBill 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssessmentBill assessmentBill , SaveMode mode,boolean throwsException) {
		Result r=super.update(assessmentBill , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param assessmentBillList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssessmentBill> assessmentBillList , SaveMode mode) {
		return super.updateList(assessmentBillList , mode);
	}

	
	/**
	 * 按主键更新考核单据
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
	 * 按主键获取考核单据
	 *
	 * @param id 主键
	 * @return AssessmentBill 数据对象
	 */
	public AssessmentBill getById(String id) {
		AssessmentBill sample = new AssessmentBill();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<AssessmentBill> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<AssessmentBill> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, AssessmentBill> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, AssessmentBill::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssessmentBill> queryList(AssessmentBillVO sample) {
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
	public PagedList<AssessmentBill> queryPagedList(AssessmentBillVO sample, int pageSize, int pageIndex) {
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
	public PagedList<AssessmentBill> queryPagedList(AssessmentBill sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param assessmentBill 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AssessmentBill assessmentBill) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(assessmentBill, SYS_ROLE.NAME);
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