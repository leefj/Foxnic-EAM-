package com.dt.platform.eam.service.impl;

import javax.annotation.Resource;

import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.StockInventoryAssetMeta;
import com.dt.platform.domain.eam.meta.StockInventoryTaskMeta;
import com.dt.platform.eam.service.IGoodsStockService;
import com.dt.platform.eam.service.IGoodsStockUsageService;
import com.dt.platform.eam.service.IStockInventoryAssetService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.sql.expr.Insert;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;


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
import com.dt.platform.eam.service.IStockInventoryTaskService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 盘点任务2服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-04 08:33:48
*/


@Service("EamStockInventoryTaskService")

public class StockInventoryTaskServiceImpl extends SuperService<StockInventoryTask> implements IStockInventoryTaskService {


	@Autowired
	private IGoodsStockUsageService goodsStockUsageService;



	@Autowired
	private IGoodsStockService goodsStockService;


	@Autowired
	private IStockInventoryAssetService stockInventoryAssetService;

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
	 * @param stockInventoryTask  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(StockInventoryTask stockInventoryTask,boolean throwsException) {

		if(StringUtil.isBlank(stockInventoryTask.getType())){
			stockInventoryTask.setType(AssetOwnerCodeEnum.ASSET.code());
		}

		if(StringUtil.isBlank(stockInventoryTask.getBusinessCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_INVENTORY.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				stockInventoryTask.setBusinessCode(codeResult.getData().toString());
			}
		}

		if(StringUtil.isBlank(stockInventoryTask.getStatus())){
			stockInventoryTask.setStatus(AssetHandleStatusEnum.COMPLETE.code());
		}

		if(StringUtil.isBlank(stockInventoryTask.getInventoryStatus())){
			stockInventoryTask.setInventoryStatus(AssetInventoryActionStatusEnum.NOT_START.code());
		}

		if(StringUtil.isBlank(stockInventoryTask.getDataStatus())){
			stockInventoryTask.setDataStatus(AssetInventoryDataStatusEnum.NOT_SYNC.code());
		}

		if(StringUtil.isBlank(stockInventoryTask.getOriginatorId())){
			stockInventoryTask.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}
		if(StringUtil.isBlank(stockInventoryTask.getBusinessDate())){
			stockInventoryTask.setBusinessDate(new Date());
		}


		Result r=super.insert(stockInventoryTask,throwsException);
		if(r.isSuccess()){
			dao.execute("delete from eam_inventory_warehouse where inventory_id=?",stockInventoryTask.getId());
			if(stockInventoryTask.getWarehouseIds()!=null){
				for(int i=0;i<stockInventoryTask.getWarehouseIds().size();i++){
					Insert ins=new Insert("eam_inventory_warehouse");
					ins.set("id",IDGenerator.getSnowflakeIdString());
					ins.set("inventory_id",stockInventoryTask.getId());
					ins.set("value",stockInventoryTask.getWarehouseIds().get(i));
					dao.execute(ins);
				}
			}
			dao.execute("delete from eam_inventory_user where inventory_id=?",stockInventoryTask.getId());
			if(stockInventoryTask.getInventoryUserIds()!=null){
				for(int i=0;i<stockInventoryTask.getInventoryUserIds().size();i++){
					Insert ins=new Insert("eam_inventory_user");
					ins.set("id",IDGenerator.getSnowflakeIdString());
					ins.set("inventory_id",stockInventoryTask.getId());
					ins.set("user_id",stockInventoryTask.getInventoryUserIds().get(i));
					dao.execute(ins);
				}
			}

		} else{
			return r;
		}
		return r;
	}

	@Override
	public Result start(String id) {
		StockInventoryTask inventory=this.getById(id);
		if(AssetInventoryActionStatusEnum.NOT_START.code().equals(inventory.getInventoryStatus())
		){
			Result r=createAssetRecord(inventory);
			if(!r.success()){
				return r;
			}
			inventory.setInventoryStatus(AssetInventoryActionStatusEnum.ACTING.code());
			inventory.setStartTime(new Date());
			return super.update(inventory,SaveMode.NOT_NULL_FIELDS);
		}else{
			return ErrorDesc.failure().message("当前盘点状态，不允许该操作!");
		}
	}

	public Result createAssetRecord(StockInventoryTask task) {
		dao.fill(task).with(StockInventoryTaskMeta.WAREHOUSE_LIST).execute();
		List<Warehouse> warehouseList=task.getWarehouseList();
		ConditionExpr expr=new ConditionExpr();
		expr.and("owner_code in ('real_stock','real_part')");
		expr.and("owner_type in ('stock','part')");
	 	if(warehouseList.size()>0){
			expr.andIn("warehouse_id",warehouseList.stream().map(w->w.getId()).collect(Collectors.toList()));
		}
		List<GoodsStock> list=goodsStockService.queryList(expr);
		for(GoodsStock s:list){
			StockInventoryAsset asset=new StockInventoryAsset();
			asset.setTaskId(task.getId());
			asset.setAssetId(s.getId());
			asset.setInventoryStatus(AssetInventoryDetailStatusEnum.NOT_COUNTED.code());
			stockInventoryAssetService.insert(asset,false);
		}
		return ErrorDesc.success();
	}


	@Override
	public Result finish(String id) {

		StockInventoryAsset q=new StockInventoryAsset();
		q.setTaskId(id);
		q.setInventoryStatus(AssetInventoryDetailStatusEnum.NOT_COUNTED.code());
		if(stockInventoryAssetService.queryList(q).size()>0){
			return ErrorDesc.failure().message("资产未盘点完，不能进行结束操作!");
		}
		StockInventoryTask inventory=this.getById(id);
		if(AssetInventoryActionStatusEnum.ACTING.code().equals(inventory.getInventoryStatus())){
			inventory.setInventoryStatus(AssetInventoryActionStatusEnum.FINISH.code());
			inventory.setFinishTime(new Date());
			return super.update(inventory,SaveMode.NOT_NULL_FIELDS);
		}else{
			return ErrorDesc.failureMessage("当前盘点状态，不允许该操作!");
		}

	}

	@Override
	public Result cancel(String id) {
		StockInventoryTask inventory=this.getById(id);
		if(AssetInventoryActionStatusEnum.NOT_START.code().equals(inventory.getInventoryStatus())){
			inventory.setInventoryStatus(AssetInventoryActionStatusEnum.CANCEL.code());
			return super.update(inventory,SaveMode.NOT_NULL_FIELDS);
		}else{
			return ErrorDesc.failure().message("当前盘点状态，不允许该操作!");
		}
	}

	@Override
	public Result dataSync(String id) {
		StockInventoryTask inventory=this.getById(id);
		if(AssetInventoryActionStatusEnum.FINISH.code().equals(inventory.getInventoryStatus())
				&&AssetInventoryDataStatusEnum.NOT_SYNC.code().equals(inventory.getDataStatus())) {
			StockInventoryAsset q=new StockInventoryAsset();
			q.setTaskId(id);
			List<StockInventoryAsset> inventoryAssetList=stockInventoryAssetService.queryList(q);
			dao.fill(inventoryAssetList).with(StockInventoryAssetMeta.OPER_USER).execute();
			List<Employee> oUserList = CollectorUtil.collectList(inventoryAssetList, StockInventoryAsset::getOperUser);
			dao().join(oUserList, Person.class);
			//目前只支持，库存物品，数量的盘点，暂时不支持，其他属性修改
			//只支持盘赢，盘亏进行数量调整，当前不支持其他操作
			if(inventoryAssetList.size()>0){
				for(int i=0;i<inventoryAssetList.size();i++){
					StockInventoryAsset asset=inventoryAssetList.get(i);
					GoodsStockUsage usage=new GoodsStockUsage();
					usage.setLabel("盘点");
					usage.setBillCode(inventory.getBusinessCode());
					usage.setRecTime(new Date());
					usage.setOperNumber(asset.getAssetNumber()+"");
					usage.setOwnerId(asset.getAssetId());
					String ct="";
					if( AssetInventoryDetailStatusEnum.COUNTED.code().equals(asset.getInventoryStatus())){
						ct="已盘点，正常，备注信息:"+asset.getInventoryNotes();
					}else if( AssetInventoryDetailStatusEnum.LOSS.code().equals(asset.getInventoryStatus())){
						ct="已盘点，盘亏，备注信息:"+asset.getInventoryNotes();
						dao.execute("update eam_goods_stock set stock_cur_number=stock_cur_number-"+asset.getAssetNumber()+" where id=?",asset.getAssetId());
					}else if( AssetInventoryDetailStatusEnum.SURPLUS.code().equals(asset.getInventoryStatus())){
						ct="已盘点，盘赢，备注信息:"+asset.getInventoryNotes();
						dao.execute("update eam_goods_stock set stock_cur_number=stock_cur_number+"+asset.getAssetNumber()+" where id=?",asset.getAssetId());
					}else if( AssetInventoryDetailStatusEnum.EXCEPTION.code().equals(asset.getInventoryStatus())){
						ct="已盘点，其他异常，备注信息:"+asset.getInventoryNotes();
					}
					usage.setContent(ct);
					usage.setOperUserId(asset.getOperId());
					if(asset.getOperUser()!=null){
						usage.setOperUserName(asset.getOperUser().getName());
					}
					goodsStockUsageService.insert(usage,false);
				}
			}
			//追加的盘赢数据
//			dao.execute("update eam_asset set owner_code='asset' where owner_code='inventory_asset' and id in (select asset_id from eam_inventory_asset where deleted=0 and source='asset_plus' and inventory_id=?)",id);
//			//更新核对时间
			dao.execute("update eam_stock_inventory_task set data_status='"+AssetInventoryDataStatusEnum.SYNC.code()+"' where id=?",id);
		}else{
			return ErrorDesc.failure().message("当前盘点状态，不允许该操作!");
		}


		return ErrorDesc.success();

	}

	@Override
	public Result inventoryAsset(StockInventoryAssetVO asset) {

		String userId= SessionUser.getCurrent().getUser().getActivatedEmployeeId();
		asset.setOperTime(new Date());
		asset.setOperId(userId);
		stockInventoryAssetService.update(asset,SaveMode.NOT_NULL_FIELDS,false);
		return ErrorDesc.success();

	}

	@Override
	public Result assetPlusData(String id) {
		return null;
	}

	@Override
	public Result queryAssetByInventory(String id) {
		return null;
	}

	@Override
	public Result downloadAsset(String id) {
		return null;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param stockInventoryTask 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(StockInventoryTask stockInventoryTask) {
		return this.insert(stockInventoryTask,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param stockInventoryTaskList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<StockInventoryTask> stockInventoryTaskList) {
		return super.insertList(stockInventoryTaskList);
	}

	
	/**
	 * 按主键删除盘点任务2
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		StockInventoryTask stockInventoryTask = new StockInventoryTask();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		stockInventoryTask.setId(id);
		try {
			boolean suc = dao.deleteEntity(stockInventoryTask);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除盘点任务2
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		StockInventoryTask stockInventoryTask = new StockInventoryTask();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		stockInventoryTask.setId(id);
		stockInventoryTask.setDeleted(true);
		stockInventoryTask.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		stockInventoryTask.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(stockInventoryTask,SaveMode.NOT_NULL_FIELDS);
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
	 * @param stockInventoryTask 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(StockInventoryTask stockInventoryTask , SaveMode mode) {
		return this.update(stockInventoryTask,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param stockInventoryTask 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(StockInventoryTask stockInventoryTask , SaveMode mode,boolean throwsException) {
		Result r=super.update(stockInventoryTask , mode , throwsException);
		if(r.isSuccess()){
			dao.execute("delete from eam_inventory_warehouse where inventory_id=?",stockInventoryTask.getId());
			if(stockInventoryTask.getWarehouseIds()!=null){
				for(int i=0;i<stockInventoryTask.getWarehouseIds().size();i++){
					Insert ins=new Insert("eam_inventory_warehouse");
					ins.set("id",IDGenerator.getSnowflakeIdString());
					ins.set("inventory_id",stockInventoryTask.getId());
					ins.set("value",stockInventoryTask.getWarehouseIds().get(i));
					dao.execute(ins);
				}
			}
			dao.execute("delete from eam_inventory_user where inventory_id=?",stockInventoryTask.getId());
			if(stockInventoryTask.getInventoryUserIds()!=null){
				for(int i=0;i<stockInventoryTask.getInventoryUserIds().size();i++){
					Insert ins=new Insert("eam_inventory_user");
					ins.set("id",IDGenerator.getSnowflakeIdString());
					ins.set("inventory_id",stockInventoryTask.getId());
					ins.set("user_id",stockInventoryTask.getInventoryUserIds().get(i));
					dao.execute(ins);
				}
			}

		} else{
			return r;
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param stockInventoryTaskList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<StockInventoryTask> stockInventoryTaskList , SaveMode mode) {
		return super.updateList(stockInventoryTaskList , mode);
	}

	
	/**
	 * 按主键更新盘点任务2
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
	 * 按主键获取盘点任务2
	 *
	 * @param id 主键
	 * @return StockInventoryTask 数据对象
	 */
	public StockInventoryTask getById(String id) {
		StockInventoryTask sample = new StockInventoryTask();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<StockInventoryTask> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<StockInventoryTask> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, StockInventoryTask> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, StockInventoryTask::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<StockInventoryTask> queryList(StockInventoryTaskVO sample) {
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
	public PagedList<StockInventoryTask> queryPagedList(StockInventoryTaskVO sample, int pageSize, int pageIndex) {
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
	public PagedList<StockInventoryTask> queryPagedList(StockInventoryTask sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param stockInventoryTask 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(StockInventoryTask stockInventoryTask) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(stockInventoryTask, SYS_ROLE.NAME);
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