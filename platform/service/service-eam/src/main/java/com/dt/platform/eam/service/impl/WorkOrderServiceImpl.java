package com.dt.platform.eam.service.impl;

import javax.annotation.Resource;

import com.dt.platform.constants.enums.eam.WorkOrderStatusEnum;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.util.Arrays;


import com.dt.platform.domain.eam.WorkOrder;
import com.dt.platform.domain.eam.WorkOrderVO;
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
import com.dt.platform.eam.service.IWorkOrderService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 问题工单服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-13 20:51:40
*/


@Service("EamWorkOrderService")

public class WorkOrderServiceImpl extends SuperService<WorkOrder> implements IWorkOrderService {

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
	 * @param workOrder  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(WorkOrder workOrder,boolean throwsException) {
		workOrder.setStatus(WorkOrderStatusEnum.WAIT.code());
		workOrder.setRcdTime(new Date());
		workOrder.setRcdUserId(SessionUser.getCurrent().getActivatedEmployeeId());
		Result r=super.insert(workOrder,throwsException);
		return r;
	}

	@Override
	public Result cancel(String id) {
		WorkOrder order=this.getById(id);
		if(WorkOrderStatusEnum.WAIT.code().equals(order.getStatus())
			||WorkOrderStatusEnum.ACTING.code().equals(order.getStatus())){
			order.setStatus(WorkOrderStatusEnum.CANCEL.code());
			super.update(order,SaveMode.NOT_NULL_FIELDS,false);
		}else{
			ErrorDesc.failureMessage("当前状态不能更新");
		}
		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param workOrder 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(WorkOrder workOrder) {
		return this.insert(workOrder,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param workOrderList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<WorkOrder> workOrderList) {
		return super.insertList(workOrderList);
	}

	
	/**
	 * 按主键删除问题工单
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		WorkOrder workOrder = new WorkOrder();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		workOrder.setId(id);
		try {
			boolean suc = dao.deleteEntity(workOrder);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除问题工单
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		WorkOrder workOrder = new WorkOrder();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		workOrder.setId(id);
		workOrder.setDeleted(true);
		workOrder.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		workOrder.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(workOrder,SaveMode.NOT_NULL_FIELDS);
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
	 * @param workOrder 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(WorkOrder workOrder , SaveMode mode) {
		return this.update(workOrder,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param workOrder 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(WorkOrder workOrder , SaveMode mode,boolean throwsException) {
		Result r=super.update(workOrder , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param workOrderList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<WorkOrder> workOrderList , SaveMode mode) {
		return super.updateList(workOrderList , mode);
	}

	
	/**
	 * 按主键更新问题工单
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
	 * 按主键获取问题工单
	 *
	 * @param id 主键
	 * @return WorkOrder 数据对象
	 */
	public WorkOrder getById(String id) {
		WorkOrder sample = new WorkOrder();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<WorkOrder> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<WorkOrder> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, WorkOrder> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, WorkOrder::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<WorkOrder> queryList(WorkOrderVO sample) {
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
	public PagedList<WorkOrder> queryPagedList(WorkOrderVO sample, int pageSize, int pageIndex) {
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
	public PagedList<WorkOrder> queryPagedList(WorkOrder sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param workOrder 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(WorkOrder workOrder) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(workOrder, SYS_ROLE.NAME);
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