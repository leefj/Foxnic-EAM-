package com.dt.platform.eam.service.impl;

import javax.annotation.Resource;

import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.InventoryMeta;
import com.dt.platform.domain.eam.meta.InventoryPlanMeta;
import com.dt.platform.domain.eam.meta.StockInventoryPlanMeta;
import com.dt.platform.domain.eam.meta.StockInventoryTaskMeta;
import com.dt.platform.eam.service.IStockInventoryTaskService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import org.github.foxnic.web.domain.hrm.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
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
import com.dt.platform.eam.service.IStockInventoryPlanService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 盘点计划2服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-04 07:52:49
*/


@Service("EamStockInventoryPlanService")

public class StockInventoryPlanServiceImpl extends SuperService<StockInventoryPlan> implements IStockInventoryPlanService {


	@Autowired
	private IStockInventoryTaskService stockInventoryTaskService;

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
	 * @param stockInventoryPlan  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(StockInventoryPlan stockInventoryPlan,boolean throwsException) {
		Result r=super.insert(stockInventoryPlan,throwsException);
		return r;
	}

	@Override
	public Result applyTpl(String id) {
		StockInventoryPlan sample = new StockInventoryPlan();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		StockInventoryPlan plan=dao.queryEntity(sample);
		if(!StatusEnableEnum.ENABLE.code().equals(plan.getStatus())){
			return ErrorDesc.failureMessage("当前状态无法应用模板!");
		}
		dao().fill(plan)
				.with(StockInventoryPlanMeta.INVENTORY_PLAN_TYPE)
				.with(StockInventoryPlanMeta.INVENTORY_TASK)
				.execute();

		if(plan.getInventoryTask()!=null&&plan.getInventoryTask().getId()!=null){
		}else{
			return ErrorDesc.failureMessage("未找到模板，无法应用!");
		}


		Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_INVENTORY.code());
		if(!codeResult.isSuccess()){
			return codeResult;
		}

		StockInventoryTask inventoryTpl=plan.getInventoryTask();
		inventoryTpl.setBusinessCode(codeResult.getData().toString());
		this.dao().fill(inventoryTpl)
				.with(StockInventoryTaskMeta.WAREHOUSE_LIST)
				.with(StockInventoryTaskMeta.INVENTORY_USER_LIST)
				.execute();
		inventoryTpl.setId(null);


		//处理仓库
		List<Warehouse> warehouseList=inventoryTpl.getWarehouseList();
		if(warehouseList!=null&&warehouseList.size()>0){
			List<String> warehouseIdList =new ArrayList<>();
			for(Warehouse c : warehouseList){
				warehouseIdList.add(c.getId());
			}
			inventoryTpl.setWarehouseIds(warehouseIdList);
		}

		//处理盘点人
		List<Employee> inventoryList=inventoryTpl.getInventoryUserList();
		if(inventoryList!=null&&inventoryList.size()>0){
			List<String> inventoryIdList =new ArrayList<>();
			for(Employee c : inventoryList){
				inventoryIdList.add(c.getId());
			}
			inventoryTpl.setInventoryUserIds(inventoryIdList);
		}

		stockInventoryTaskService.insert(inventoryTpl,true);
		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param stockInventoryPlan 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(StockInventoryPlan stockInventoryPlan) {
		return this.insert(stockInventoryPlan,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param stockInventoryPlanList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<StockInventoryPlan> stockInventoryPlanList) {
		return super.insertList(stockInventoryPlanList);
	}

	
	/**
	 * 按主键删除盘点计划2
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		StockInventoryPlan stockInventoryPlan = new StockInventoryPlan();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		stockInventoryPlan.setId(id);
		try {
			boolean suc = dao.deleteEntity(stockInventoryPlan);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除盘点计划2
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		StockInventoryPlan stockInventoryPlan = new StockInventoryPlan();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		stockInventoryPlan.setId(id);
		stockInventoryPlan.setDeleted(true);
		stockInventoryPlan.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		stockInventoryPlan.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(stockInventoryPlan,SaveMode.NOT_NULL_FIELDS);
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
	 * @param stockInventoryPlan 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(StockInventoryPlan stockInventoryPlan , SaveMode mode) {
		return this.update(stockInventoryPlan,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param stockInventoryPlan 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(StockInventoryPlan stockInventoryPlan , SaveMode mode,boolean throwsException) {
		Result r=super.update(stockInventoryPlan , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param stockInventoryPlanList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<StockInventoryPlan> stockInventoryPlanList , SaveMode mode) {
		return super.updateList(stockInventoryPlanList , mode);
	}

	
	/**
	 * 按主键更新盘点计划2
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
	 * 按主键获取盘点计划2
	 *
	 * @param id 主键
	 * @return StockInventoryPlan 数据对象
	 */
	public StockInventoryPlan getById(String id) {
		StockInventoryPlan sample = new StockInventoryPlan();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<StockInventoryPlan> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<StockInventoryPlan> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, StockInventoryPlan> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, StockInventoryPlan::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<StockInventoryPlan> queryList(StockInventoryPlanVO sample) {
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
	public PagedList<StockInventoryPlan> queryPagedList(StockInventoryPlanVO sample, int pageSize, int pageIndex) {
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
	public PagedList<StockInventoryPlan> queryPagedList(StockInventoryPlan sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param stockInventoryPlan 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(StockInventoryPlan stockInventoryPlan) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(stockInventoryPlan, SYS_ROLE.NAME);
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