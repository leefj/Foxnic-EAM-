package com.dt.platform.eam.service.impl;


import com.alibaba.fastjson.JSON;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.InspectionPlanMeta;
import com.dt.platform.domain.eam.meta.InspectionPointOwnerMeta;
import com.dt.platform.eam.service.*;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.meta.DBField;
import org.checkerframework.checker.units.qual.C;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.quartz.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dt.platform.eam.service.ICheckSelectService;
import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 巡检计划 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-11 08:12:42
*/


@Service("EamInspectionPlanService")
public class InspectionPlanServiceImpl extends SuperService<InspectionPlan> implements IInspectionPlanService {

	@Autowired
	private ICheckSelectService checkSelectService;

	@Autowired
	private IInspectionPointService inspectionPointService;

	@Autowired
	private IInspectionTaskPointService inspectionTaskPointService;

	@Autowired
	private IPlanExecuteLogService planExecuteLogService;

	@Autowired
	private IInspectionTaskService inspectionTaskService;
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
	public Result start(String id) {
		InspectionPlan plan=this.getById(id);
		if(EamPlanStatusEnum.STOP.code().equals(plan.getPlanStatus())){
			plan.setPlanStatus(EamPlanStatusEnum.ACTING.code());
			super.update(plan,SaveMode.NOT_NULL_FIELDS,false);
		}else{
			return ErrorDesc.failureMessage("当前状态操作异常!");
		}
		return ErrorDesc.success();
	}

	@Override
	public Result stop(String id) {
		InspectionPlan plan=this.getById(id);
		if(EamPlanStatusEnum.ACTING.code().equals(plan.getPlanStatus())){
			plan.setPlanStatus(EamPlanStatusEnum.STOP.code());
			super.update(plan,SaveMode.NOT_NULL_FIELDS,false);
		}else{
			return ErrorDesc.failureMessage("当前状态操作异常!");
		}
		return ErrorDesc.success();
	}

	@Override
	public Result execute() {
		InspectionPlan plan=new InspectionPlan();
		plan.setPlanStatus(EamPlanStatusEnum.ACTING.code());
		List<InspectionPlan> planList=this.queryList(plan);
		dao.fill(planList).with(InspectionPlanMeta.ACTION_CRONTAB).execute();
		for(int i=0;i<planList.size();i++){
			executePlan(planList.get(i));
		}
		return ErrorDesc.success();
	}

	private Result executePlan(InspectionPlan plan){

		ActionCrontab cron=plan.getActionCrontab();
		if(StringUtil.isBlank(cron)){
			Logger.info("当前crontab为空，plan:"+plan.getId());
			return ErrorDesc.failure("当前crontab为空");
		}

		// 理论上只有一个待执行的日志
		PlanExecuteLog log = this.getOrCreateLog(plan);
		// 如果 long 是 null 大概率是 cron 表达式错误
		if(log==null){
			Logger.info("log is null，plan:"+plan.getId());
			return ErrorDesc.failure("log is null");
		}
		// 如果预期的执行时间已经超过当前，就执行
		if(log.getExecuteTime().getTime()<=(new Date()).getTime()) {
			// 设置为已执行，意味着执行失败就跳过，下一次继续执行
			log.setExecuted(1);
			try {
				// 执行
				//Result execResult = this.createTask(plan.getId(), "auto");
				Result execResult = this.createTask(plan.getId());
				// 失败时记录失败原因
				if (!execResult.success()) {
					log.setErrors(JSON.toJSONString(execResult));
				}
			} catch (Exception e) {
				// 记录异常堆栈
				log.setErrors(StringUtil.toString(e));
			}
			planExecuteLogService.updateDirtyFields(log);
			// 为下一次执行做准备，同时使界面上也能看到下次执行时间
			this.getOrCreateLog(plan);
		}

		return ErrorDesc.success();
	}


	private Date getNextExecuteTime(InspectionPlan plan) {
		Date next=null;
		try {
			CronExpression cronExpression = new CronExpression(plan.getActionCrontab().getCrontab());
			next=cronExpression.getNextValidTimeAfter(new Date());
		} catch (Exception e) {
			Logger.exception("cron "+plan.getActionCrontab().getCrontab()+" error",e);
		}
		return next;
	}

	private PlanExecuteLog getOrCreateLog(InspectionPlan plan) {
		// 获得计划的下一个执行时间点
		Date next=getNextExecuteTime(plan);
		// 如果表达式异常就执行下一个计划
		if(next==null) return null;
		// 更新下一个计划时间
		plan.setNextTime(next);
		InspectionPlan newPlan=new InspectionPlan();
		newPlan.setId(plan.getId());
		newPlan.setNextTime(next);
		super.update(newPlan,SaveMode.NOT_NULL_FIELDS,true);

		// 查询未执行的日志
		List<PlanExecuteLog> logs=planExecuteLogService.queryList(new ConditionExpr("plan_id=? and executed!=1",plan.getId()));
		PlanExecuteLog log = null;
		// 如果没有未执行的日志就新建一个
		if(logs==null || logs.isEmpty()) {
			log=new PlanExecuteLog();
			log.setPlanId(plan.getId());
			log.setExecuteTime(plan.getNextTime());
			log.setExecuted(0);
			planExecuteLogService.insert(log);
			logs=planExecuteLogService.queryList(new ConditionExpr("plan_id=? and executed!=1",plan.getId()));
			// 并发执行可能存在这种情况，判断的一下
			if(logs==null || logs.isEmpty()) {
				return null;
			}
		}
		log=logs.get(0);
		return log;
	}


	@Override
	public Result createTask(String id) {
		InspectionPlan plan=this.getById(id);
		String status=plan.getPlanStatus();
		if(EamPlanStatusEnum.ACTING.code().equals(status)){
			Logger.info("########## plan execute ###########");
			Logger.info("########## plan id:"+plan.getId()+" ###########");
			Logger.info("########## plan code:"+plan.getPlanCode()+" ###########");
			Logger.info("########## plan name:"+plan.getName()+" ###########");
			Logger.info("########## plan trigger end ###########");
			this.dao().fill(plan)
					.with(InspectionPlanMeta.INSPECTION_POINT_LIST)
					.with(InspectionPlanMeta.INSPECTION_POINT_OWNER_LIST)
					.execute();
			List<InspectionPointOwner> pointOwnerList=plan.getInspectionPointOwnerList();
			List<InspectionPoint> pointList=plan.getInspectionPointList();

			if(pointList==null&&pointList.size()==0){
				return ErrorDesc.failureMessage("当前巡检计划未设置巡检点");
			}

			SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
			String sf=f.format(new Date());

			//按照计划生成任务单
			InspectionTask task=new InspectionTask();
			String taskId=IDGenerator.getSnowflakeIdString();
			task.setId(taskId);
			task.setPlanId(plan.getId());
			task.setPlanName(plan.getName()+"-"+sf);
			task.setPlanStartTime(new Date());
			task.setPlanCode(plan.getPlanCode());
			task.setPlanNotes(plan.getNotes());
			task.setPlanInspectionMethod(plan.getInspectionMethod());
			task.setPlanCompletionTime(plan.getCompletionTime());
			task.setGroupId(plan.getGroupId());
			task.setTaskStatus(InspectionTaskStatusEnum.WAIT.code());
			inspectionTaskService.insert(task,false);

			this.dao().fill(pointOwnerList).with(InspectionPointOwnerMeta.CHECK_ITEM_LIST).
					with(InspectionPointOwnerMeta.INSPECTION_POINT).execute();

			//生成巡检点
			for(int i=0;i<pointList.size();i++){
				InspectionPointOwner pointOwner=pointOwnerList.get(i);
				String selectedCode=pointOwner.getSelectedCode();
				if(!StringUtil.isBlank(selectedCode)){
					continue;
				}
				InspectionPoint point=pointOwner.getInspectionPoint();
				List<CheckItem> itemList=pointOwner.getCheckItemList();
				if(StatusEnableEnum.DISABLE.code().equals(point.getStatus())){
					Logger.info("本次任务:"+taskId+",巡检点未启用,巡检点:"+point.getId());
					continue;
				}
				InspectionTaskPoint taskPoint=new InspectionTaskPoint();
				taskPoint.setTaskId(taskId);
				taskPoint.setPointStatus(InspectionTaskPointStatusEnum.WAIT.code());
				taskPoint.setPointId(point.getId());
				taskPoint.setPointCode(point.getCode());
				taskPoint.setPointName(point.getName());
				taskPoint.setPointContent(point.getContent());
				taskPoint.setPointRouteId(point.getRouteId());
				taskPoint.setPointRfid(point.getRfid());
				taskPoint.setPointPosId(point.getPosId());
				taskPoint.setPointPos(point.getPos());
				taskPoint.setPointPosLatitude(point.getPosLatitude());
				taskPoint.setPointPosLongitude(point.getPosLongitude());
				taskPoint.setNotes(point.getNotes());
				taskPoint.setSort(pointOwner.getSort());
				inspectionTaskPointService.insert(taskPoint,true);

				//插入检查项目
				if(itemList!=null&&itemList.size()>0){
					for(int j=0;j<itemList.size();j++){
						CheckItem item=itemList.get(j);
						if(StatusEnableEnum.ENABLE.code().equals(item.getStatus())){
							CheckSelect checkSelect=new CheckSelect();
							checkSelect.setPointId(point.getId());
							checkSelect.setTaskPointId(taskPoint.getId());
							checkSelect.setTaskId(task.getId());
							checkSelect.setItemId(item.getId());
							checkSelect.setItemCode(item.getCode());
							checkSelect.setItemName(item.getName());
							checkSelect.setIfCheck(CheckIfCheckEnum.NO.code());
							checkSelect.setItemDesc(item.getCheckDesc());
							checkSelect.setType(item.getType());
							checkSelect.setConfig(item.getConfig());
							checkSelect.setConfigDefValue(item.getDefValue());
							checkSelect.setResultMetaData(item.getDefValue());
							checkSelect.setSort(j);
							checkSelectService.insert(checkSelect,true);
						}else{
							Logger.info("任务:"+task.getId()+",巡检点:"+taskPoint.getId()+",当前检查项未启用:"+item.getId());
						}

					}
				}
			}
		}else{
			return ErrorDesc.failureMessage("当前巡检计划状态不能生成巡检任务");
		}
		return ErrorDesc.success();
	}


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param inspectionPlan  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(InspectionPlan inspectionPlan,boolean throwsException) {

		String selectedCode=inspectionPlan.getSelectedCode();

		if(StringUtil.isBlank(inspectionPlan.getStatus())){
			inspectionPlan.setStatus(EamPlanStatusEnum.STOP.code());
		}

		//生成编码规则
		//编码
		if(StringUtil.isBlank(inspectionPlan.getPlanCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_INSPECTION_PLAN.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				inspectionPlan.setPlanCode(codeResult.getData().toString());
			}
		}
		Result r=super.insert(inspectionPlan,throwsException);
		if(r.isSuccess()){
			dao.execute("update eam_inspection_point_owner set selected_code=?,owner_id=? where owner_id=? and selected_code=?","",inspectionPlan.getId(),selectedCode,selectedCode);
		}
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param inspectionPlan 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(InspectionPlan inspectionPlan) {
		return this.insert(inspectionPlan,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param inspectionPlanList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<InspectionPlan> inspectionPlanList) {
		return super.insertList(inspectionPlanList);
	}

	
	/**
	 * 按主键删除 巡检计划
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		InspectionPlan inspectionPlan = new InspectionPlan();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		inspectionPlan.setId(id);
		try {
			boolean suc = dao.deleteEntity(inspectionPlan);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 巡检计划
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		InspectionPlan inspectionPlan = new InspectionPlan();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		inspectionPlan.setId(id);
		inspectionPlan.setDeleted(true);
		inspectionPlan.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		inspectionPlan.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(inspectionPlan,SaveMode.NOT_NULL_FIELDS);
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
	 * @param inspectionPlan 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(InspectionPlan inspectionPlan , SaveMode mode) {
		return this.update(inspectionPlan,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param inspectionPlan 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(InspectionPlan inspectionPlan , SaveMode mode,boolean throwsException) {
		String selectedCode=inspectionPlan.getSelectedCode();
		Result r=super.update(inspectionPlan , mode , throwsException);
		if(r.isSuccess()){
			dao.execute("delete from eam_inspection_point_owner where owner_id=? and (selected_code ='' or selected_code is null)",inspectionPlan.getId(),selectedCode);
			dao.execute("update eam_inspection_point_owner set selected_code='' where owner_id=? and selected_code=?",inspectionPlan.getId(),selectedCode);
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param inspectionPlanList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<InspectionPlan> inspectionPlanList , SaveMode mode) {
		return super.updateList(inspectionPlanList , mode);
	}

	
	/**
	 * 按主键更新字段 巡检计划
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
	 * 按主键获取 巡检计划
	 *
	 * @param id 主键
	 * @return InspectionPlan 数据对象
	 */
	public InspectionPlan getById(String id) {
		InspectionPlan sample = new InspectionPlan();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<InspectionPlan> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, InspectionPlan> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, InspectionPlan::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<InspectionPlan> queryList(InspectionPlan sample) {
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
	public PagedList<InspectionPlan> queryPagedList(InspectionPlan sample, int pageSize, int pageIndex) {
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
	public PagedList<InspectionPlan> queryPagedList(InspectionPlan sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param inspectionPlan 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(InspectionPlan inspectionPlan) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(inspectionPlan, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(InspectionPlan sample) {
		return super.exportExcel(sample);
	}

	@Override
	public ExcelWriter exportExcelTemplate() {
		return super.exportExcelTemplate();
	}

	@Override
	public List<ValidateResult> importExcel(InputStream input,int sheetIndex,boolean batch) {
		return super.importExcel(input,sheetIndex,batch);
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

	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}


}