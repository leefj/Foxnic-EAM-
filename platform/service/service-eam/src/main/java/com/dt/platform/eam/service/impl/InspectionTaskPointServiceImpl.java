package com.dt.platform.eam.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.eam.CheckItemTypeEnum;
import com.dt.platform.constants.enums.eam.InspectionTaskPointStatusEnum;
import com.dt.platform.constants.enums.eam.InspectionTaskStatusEnum;
import com.dt.platform.domain.eam.CheckItem;
import com.dt.platform.domain.eam.CheckSelect;
import com.dt.platform.domain.eam.InspectionTask;
import com.dt.platform.domain.eam.InspectionTaskPoint;
import com.dt.platform.domain.eam.meta.InspectionTaskPointMeta;
import com.dt.platform.eam.service.ICheckSelectService;
import com.dt.platform.eam.service.IInspectionTaskPointService;
import com.dt.platform.eam.service.IInspectionTaskService;
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
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.meta.DBField;
import com.mysql.jdbc.log.Log;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 巡检点 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-12 21:07:10
*/


@Service("EamInspectionTaskPointService")
public class InspectionTaskPointServiceImpl extends SuperService<InspectionTaskPoint> implements IInspectionTaskPointService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	@Autowired
	private IInspectionTaskService inspectionTaskService;


	@Autowired
	private ICheckSelectService checkSelectService;

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
	 * @param inspectionTaskPoint  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(InspectionTaskPoint inspectionTaskPoint,boolean throwsException) {
		Result r=super.insert(inspectionTaskPoint,throwsException);
		return r;
	}

	@Override
	public PagedList<InspectionTaskPoint> queryNonePointPagedList(InspectionTaskPoint sample, int pageSize, int pageIndex) {

		ConditionExpr expr=new ConditionExpr();
		OrderBy orderBy=new OrderBy();
		orderBy.desc("create_time");
		sample.setPointStatus("none");
		sample.setSelectedCode("def");
		return super.queryPagedList(sample,orderBy,pageSize,pageIndex);
	}

	@Override
	public Result finish(String id, String pointStatus, String content, String imageId,String itemData) {
		//判断是否可以进行巡检
		String cUserId=SessionUser.getCurrent().getActivatedEmployeeId();
		String sql="select count(1) cnt from eam_inspection_task_point a,eam_inspection_task b,eam_inspection_group c,eam_inspection_group_user d \n" +
				"where a.id=? and a.task_id=b.id and b.group_id=c.id and c.id=d.group_id and d.user_id=?";
		if(dao.queryRecord(sql,id,cUserId).getInteger("cnt")>0){
			Logger.info("巡检操作权限匹配正确");
		}else{
			return ErrorDesc.failureMessage("本巡检任务的巡检组中未找到当前用户，无法进行巡检的操作");
		}

		InspectionTaskPoint sourceTaskPoint=this.getById(id);

		String taskId=sourceTaskPoint.getTaskId();
		InspectionTask task=inspectionTaskService.getById(taskId);
		if(InspectionTaskStatusEnum.ACTING.code().equals(task.getTaskStatus())){
			System.out.println("可以进行巡检");
		}else if(InspectionTaskStatusEnum.WAIT.code().equals(task.getTaskStatus())){
			//更新巡检状态
			InspectionTask taskUps=new InspectionTask();
			taskUps.setTaskStatus(InspectionTaskStatusEnum.ACTING.code());
			taskUps.setId(taskId);
			taskUps.setActStartTime(new Date());
			inspectionTaskService.update(taskUps,SaveMode.NOT_NULL_FIELDS,false);
		}else{
			return ErrorDesc.failureMessage("当前巡检任务状态不能进行巡检操作");
		}


		dao.fill(sourceTaskPoint).with(InspectionTaskPointMeta.CHECK_SELECT_LIST).execute();
		List<CheckSelect> itemList=sourceTaskPoint.getCheckSelectList();
		Logger.info("巡检点:"+id+",巡检项:"+itemList.size());
		if(itemList!=null&&itemList.size()>0&&!StringUtil.isBlank(itemData)){
			JSONObject itemsObj=JSONObject.parseObject(itemData);
			if(itemsObj!=null){
				for(int j=0;j<itemList.size();j++){
					CheckSelect checkSelect=itemList.get(j);
					if(itemsObj.containsKey(checkSelect.getId())){
						JSONObject obj=itemsObj.getJSONObject(checkSelect.getId());
						if(CheckItemTypeEnum.INPUT.code().equals(checkSelect.getType())){
							checkSelect.setIfCheck("yes");
							checkSelect.setResultMetaData(obj.getString("value"));
							checkSelect.setResult(obj.getString("value"));
						}else if(CheckItemTypeEnum.NUMBER_RANGE.code().equals(checkSelect.getType())){
							checkSelect.setIfCheck("yes");
							checkSelect.setResultMetaData(obj.getString("value"));
							checkSelect.setResult(obj.getString("value"));
						}else if(CheckItemTypeEnum.RADIOBOX.code().equals(checkSelect.getType())){
							checkSelect.setIfCheck("yes");
							checkSelect.setResultMetaData(obj.getString("value"));
							JSONArray arr=JSONArray.parseArray(checkSelect.getConfig());
							checkSelect.setResult(obj.getString("value"));
							for(int k=0;k<arr.size();k++){
								if(obj.getString("value").equals( arr.getJSONObject(k).getString("code"))){
									checkSelect.setResult(arr.getJSONObject(k).getString("label"));
									break;
								}
							}
						}
						Result rcdR=checkSelectService.update(checkSelect,SaveMode.NOT_NULL_FIELDS,true);
					}else{
						Logger.info("巡检点:"+id+",当前key没有数据,key:"+checkSelect.getId());
					}
				}
			}
		}
		InspectionTaskPoint taskPoint=new InspectionTaskPoint();
		taskPoint.setId(id);
		taskPoint.setImageId(imageId);
		taskPoint.setOperTime(new Date());
		taskPoint.setPointStatus(pointStatus);
		taskPoint.setOperId(SessionUser.getCurrent().getActivatedEmployeeId());
		taskPoint.setContent(content);
		Result r=this.update(taskPoint,SaveMode.NOT_NULL_FIELDS,true);
		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param inspectionTaskPoint 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(InspectionTaskPoint inspectionTaskPoint) {
		return this.insert(inspectionTaskPoint,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param inspectionTaskPointList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<InspectionTaskPoint> inspectionTaskPointList) {
		return super.insertList(inspectionTaskPointList);
	}

	
	/**
	 * 按主键删除 巡检点
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		InspectionTaskPoint inspectionTaskPoint = new InspectionTaskPoint();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		inspectionTaskPoint.setId(id);
		try {
			boolean suc = dao.deleteEntity(inspectionTaskPoint);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 巡检点
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		InspectionTaskPoint inspectionTaskPoint = new InspectionTaskPoint();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		inspectionTaskPoint.setId(id);
		inspectionTaskPoint.setDeleted(true);
		inspectionTaskPoint.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		inspectionTaskPoint.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(inspectionTaskPoint,SaveMode.NOT_NULL_FIELDS);
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
	 * @param inspectionTaskPoint 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(InspectionTaskPoint inspectionTaskPoint , SaveMode mode) {
		return this.update(inspectionTaskPoint,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param inspectionTaskPoint 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(InspectionTaskPoint inspectionTaskPoint , SaveMode mode,boolean throwsException) {
		Result r=super.update(inspectionTaskPoint , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param inspectionTaskPointList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<InspectionTaskPoint> inspectionTaskPointList , SaveMode mode) {
		return super.updateList(inspectionTaskPointList , mode);
	}

	
	/**
	 * 按主键更新字段 巡检点
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
	 * 按主键获取 巡检点
	 *
	 * @param id 主键
	 * @return InspectionTaskPoint 数据对象
	 */
	public InspectionTaskPoint getById(String id) {
		InspectionTaskPoint sample = new InspectionTaskPoint();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<InspectionTaskPoint> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, InspectionTaskPoint> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, InspectionTaskPoint::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<InspectionTaskPoint> queryList(InspectionTaskPoint sample) {
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
	public PagedList<InspectionTaskPoint> queryPagedList(InspectionTaskPoint sample, int pageSize, int pageIndex) {
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
	public PagedList<InspectionTaskPoint> queryPagedList(InspectionTaskPoint sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param inspectionTaskPoint 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(InspectionTaskPoint inspectionTaskPoint) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(inspectionTaskPoint, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(InspectionTaskPoint sample) {
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