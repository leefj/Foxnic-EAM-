package com.dt.platform.eam.service.impl;


import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetStockGoodsInMeta;
import com.dt.platform.domain.eam.meta.RepairOrderActMeta;
import com.dt.platform.domain.eam.meta.RepairOrderMeta;
import com.dt.platform.eam.service.*;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.SQL;
import com.github.foxnic.sql.expr.Update;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * <p>
 * 维修工单 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-31 21:56:15
*/


@Service("EamRepairOrderActService")
public class RepairOrderActServiceImpl extends SuperService<RepairOrderAct> implements IRepairOrderActService {

	@Autowired
	private IAssetService assetService;

	@Autowired
	private IGoodsStockService goodsStockService;


	@Autowired
	private IRepairOrderService repairOrderService;

	@Autowired
	private IOperateService operateService;

	@Autowired
	private IAssetProcessRecordService assetProcessRecordService;

	@Autowired
	private IDeviceSpRcdService deviceSpRcdService;

	@Autowired
	private IRepairOrderProcessService repairOrderProcessService;
	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	private Result applyChange(String orderId,String status){
		RepairOrder billData=repairOrderService.getById(orderId);
		repairOrderService.join(billData, RepairOrderMeta.ASSET_LIST);
		//维修前状态
		dao.execute("update eam_asset_item a,eam_asset b set a.before_asset_status=b.asset_status where a.asset_id=b.id and a.handle_id=?",orderId);
		HashMap<String,Object> map=new HashMap<>();
		map.put("asset_status", status);
		HashMap<String,List<SQL>> resultMap=assetService.parseAssetChangeRecordWithChangeAsset(billData.getAssetList(),map,billData.getBusinessCode(),AssetOperateEnum.EAM_ASSET_REPAIR_ORDER_ACT.code(),"维修中");
		for(String key:resultMap.keySet()){
			List<SQL> sqls=resultMap.get(key);
			if(sqls.size()>0){
				dao.batchExecute(sqls);
			}
		}
		return ErrorDesc.success();
	}



	@Override
	public Result start(String id) {
		RepairOrderAct act=this.getById(id);
		String curUserId=SessionUser.getCurrent().getUser().getActivatedEmployeeId();
		String userId=act.getExecutorId();
		RepairOrder order=repairOrderService.getById(act.getOrderId());
		if(RepairOrderStatusEnum.WAIT_REPAIR.code().equals(order.getRepairStatus())){
			if(StringUtil.isBlank(userId)){
				if(dao.query("select 1 from eam_group_user where deleted=0 and group_id=? and user_id=?",act.getGroupId(),curUserId).size()==0){
					ErrorDesc.failureMessage("当前操作人没有在班组中，操作失败");
				}
				//根据班组
			}else{
				if(StringUtil.isBlank(act.getExecutorId())){
					act.setExecutorId(curUserId);
				}
//				if(!curUserId.equals(userId)){
//					ErrorDesc.failureMessage("当前操作人非工单指派人，操作失败");
//				}
			}
			act.setExecutorId(curUserId);
			act.setStartTime(new Date());
			Result r=super.update(act,SaveMode.NOT_NULL_FIELDS,false);
			if(!r.isSuccess()){
				return r;
			}
			repairOrderService.changeRepairOrderStatus(act.getOrderId(), RepairOrderActStatusEnum.REPAIRING.code());
			RepairOrderProcess rcd=new RepairOrderProcess();
			rcd.setRcdTime(new Date());
			rcd.setOrderId(act.getOrderId());
			rcd.setActId(act.getId());
			rcd.setUserId(SessionUser.getCurrent().getActivatedEmployeeId());
			rcd.setUserName(SessionUser.getCurrent().getRealName());
			rcd.setProcessContent("开始进行维修");
			repairOrderProcessService.insert(rcd,true);
			return applyChange(act.getOrderId(),AssetStatusEnum.REPAIR.code());

		}else{
			return ErrorDesc.failureMessage("当前订单状态异常,不能启动维修工作");
		}

	}

	private Result computeStockData(List<GoodsStock> goods){
		//不进行判断，直接进行库存减
		if(goods!=null&&goods.size()>0){
			for(int i=0;i<goods.size();i++){
				String rid=goods.get(i).getRealStockId();
				String value=goods.get(i).getStockInNumber()+"";
				String sql="update eam_goods_stock set stock_cur_number=stock_cur_number-"+value+" where id=?";
				this.dao.execute(sql,rid);
			}
		}
		return ErrorDesc.success();
	}

	@Override
	public Result finish(String id) {
		RepairOrderAct act=this.getById(id);
		String curUserId=SessionUser.getCurrent().getUser().getActivatedEmployeeId();
		String userId=act.getExecutorId();
		RepairOrder order=repairOrderService.getById(act.getOrderId());
		if(!RepairOrderActStatusEnum.REPAIRING.code().equals(order.getRepairStatus())){
			return ErrorDesc.failureMessage("当前订单状态异常,不能结束维修工作");
		}

		if(StringUtil.isBlank(userId)){
			if(dao.query("select 1 from eam_group_user where deleted=0 and group_id=? and user_id=?",act.getGroupId(),curUserId).size()==0){
				ErrorDesc.failureMessage("当前操作人没有在班组中，操作失败");
			}
			//根据班组
		}else{
			if(!curUserId.equals(userId)){
				ErrorDesc.failureMessage("当前操作人非工单指派人，操作失败");
			}
		}

		repairOrderService.changeRepairOrderStatus(act.getOrderId(),RepairOrderActStatusEnum.WAIT_ACCEPTANCE.code());
		act.setExecutorId(curUserId);
		act.setFinishTime(new Date());
		Result r= super.update(act,SaveMode.NOT_NULL_FIELDS,false);
		if(!r.isSuccess()){
			return r;
		}

		//库存减值
		GoodsStock qE=new GoodsStock();
		qE.setOwnerTmpId(id);
		List<GoodsStock> goodsList =goodsStockService.queryList(qE);
		computeStockData(goodsList);

		//备件
//		dao.fill(act).with(RepairOrderActMeta.REPAIR_ORDER_ACT_SP_LIST).execute();
//		List<RepairOrderActSp> spList=act.getRepairOrderActSpList();
//		if(spList!=null&&spList.size()>0){
//			for(int j=0;j<spList.size();j++){
//				DeviceSpRcd rcd=new DeviceSpRcd();
//				rcd.setSpId(spList.get(j).getSpId());
//				rcd.setSpCode((spList.get(j).getSpCode()));
//				rcd.setOperTime(new Date());
//				rcd.setOperId(SessionUser.getCurrent().getActivatedEmployeeId());
//				rcd.setContent("备件已备使用,维修工单编号:"+act.getBusinessCode());
//				deviceSpRcdService.insert(rcd,false);
//			}
//			//
//			String upsql="update eam_device_sp set status=?  where id in (select sp_id from eam_repair_order_act_sp where deleted=0 and act_id=? and selected_code='def')";
//			dao.execute(upsql,DeviceSpStatusEnum.USED.code(),act.getId());
//		}

		//维修操作完成，登记记录,这里默认只支持一个设备
		repairOrderService.join(order, RepairOrderMeta.ASSET_LIST);
		List<Asset> assetList=order.getAssetList();
		if(assetList!=null&&assetList.size()>0){
			HashMap<String,Object> map=new HashMap<>();
			for(Asset asset:assetList){
				AssetProcessRecord assetProcessRecord=new AssetProcessRecord();
				assetProcessRecord.setContent("资产维修操作完成");
				assetProcessRecord.setAssetId(asset.getId());
				assetProcessRecord.setBusinessCode(act.getBusinessCode());
				assetProcessRecord.setProcessType(AssetOperateEnum.EAM_ASSET_REPAIR_ORDER_ACT.code());
				assetProcessRecord.setProcessdTime(new Date());
				assetProcessRecordService.insert(assetProcessRecord);
				//修改维修状态
				List<Asset> list=new ArrayList<>();
				list.add(asset);
				Rcd rs=dao.queryRecord("select * from eam_asset_item where deleted=0 and crd='r' and handle_id=? and asset_id=?",act.getOrderId(),asset.getId());
				map.put("asset_status",rs.getString("before_asset_status"));
				HashMap<String,List<SQL>> resultMap=assetService.parseAssetChangeRecordWithChangeAsset(list,map,act.getBusinessCode(),AssetOperateEnum.EAM_ASSET_REPAIR_ORDER_ACT.code(),"维修结束");
				for(String key:resultMap.keySet()){
					List<SQL> sqls=resultMap.get(key);
					if(sqls.size()>0){
						dao.batchExecute(sqls);
					}
				}
			}
		}
		RepairOrderProcess rcd=new RepairOrderProcess();
		rcd.setRcdTime(new Date());
		rcd.setOrderId(act.getOrderId());
		rcd.setActId(act.getId());
		rcd.setUserId(SessionUser.getCurrent().getActivatedEmployeeId());
		rcd.setUserName(SessionUser.getCurrent().getRealName());
		rcd.setProcessContent("维修结束，待验收");
		repairOrderProcessService.insert(rcd,true);
		return ErrorDesc.success();


	}

	@Override
	public Result cancel(String id) {
		RepairOrderAct act=this.getById(id);
		RepairOrder order=repairOrderService.getById(act.getOrderId());
		if(		RepairOrderActStatusEnum.REPAIRING.code().equals(order.getRepairStatus())
				||RepairOrderActStatusEnum.WAIT_REPAIR.code().equals(order.getRepairStatus())
				||RepairOrderStatusEnum.DISPATCHED.code().equals(order.getRepairStatus())
				||RepairOrderStatusEnum.NOT_DISPATCH.code().equals(order.getRepairStatus())
		){
			repairOrderService.changeRepairOrderStatus(act.getOrderId(),RepairOrderStatusEnum.CANCEL.code());
		}else{
			return ErrorDesc.failureMessage("当前状态不能取消");
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
	 * @param repairOrderAct  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(RepairOrderAct repairOrderAct,boolean throwsException) {
		RepairOrder order=repairOrderService.getById(repairOrderAct.getOrderId());
		if (order == null) {
			return ErrorDesc.failureMessage("申请工单不存在,orderId:"+repairOrderAct.getOrderId());
		}
		if(!AssetHandleStatusEnum.COMPLETE.code().equals(order.getStatus())){
			return ErrorDesc.failureMessage("申请工单状态未完成,当前不可进行维修操作");
		}

		if(!RepairOrderStatusEnum.NOT_DISPATCH.code().equals(order.getRepairStatus())){
			return ErrorDesc.failureMessage("申请工单维修状态未完成,当前不可进行维修操作");
		}


		//制单人
		if(StringUtil.isBlank(repairOrderAct.getOriginatorId())){
			repairOrderAct.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}


		//编码
		if(StringUtil.isBlank(repairOrderAct.getBusinessCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_REPAIR_ORDER_ACT.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				repairOrderAct.setBusinessCode(codeResult.getData().toString());
			}
		}

		Result r=super.insert(repairOrderAct,throwsException);
		if(!r.isSuccess()){
			return r;
		}
		repairOrderService.changeRepairOrderStatus(repairOrderAct.getOrderId(),RepairOrderStatusEnum.WAIT_REPAIR.code());
		return ErrorDesc.success();
//		GoodsStock qE=new GoodsStock();
//		qE.setSelectedCode(repairOrderAct.getSelectedCode());
//		List<GoodsStock> list =goodsStockService.queryList(qE);
//
//		for(int i=0;i<list.size();i++){
//			list.get(i).setOwnerCode(repairOrderAct.getOwnerType());
//		}
//		repairOrderService.changeRepairOrderStatus(repairOrderAct.getOrderId(),RepairOrderStatusEnum.WAIT_REPAIR.code());
//		return goodsStockService.saveOwnerData(repairOrderAct.getId(),repairOrderAct.getOwnerType(),list);


	}



	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param repairOrderAct 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(RepairOrderAct repairOrderAct) {
		return this.insert(repairOrderAct,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param repairOrderActList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<RepairOrderAct> repairOrderActList) {
		return super.insertList(repairOrderActList);
	}

	
	/**
	 * 按主键删除 维修工单
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		RepairOrderAct repairOrderAct = new RepairOrderAct();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		repairOrderAct.setId(id);
		try {
			boolean suc = dao.deleteEntity(repairOrderAct);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 维修工单
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		RepairOrderAct repairOrderAct = new RepairOrderAct();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		repairOrderAct.setId(id);
		repairOrderAct.setDeleted(true);
		repairOrderAct.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		repairOrderAct.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(repairOrderAct,SaveMode.NOT_NULL_FIELDS);
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
	 * @param repairOrderAct 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(RepairOrderAct repairOrderAct , SaveMode mode) {
		return this.update(repairOrderAct,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param repairOrderAct 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(RepairOrderAct repairOrderAct , SaveMode mode,boolean throwsException) {


		RepairOrderAct sourceData=this.getById(repairOrderAct.getId());
		if(RepairOrderActStatusEnum.WAIT_REPAIR.code().equals(sourceData.getStatus())){
			//repairOrderAct.setStatus(RepairOrderActStatusEnum.REPAIRING.code());
		}
		Result r=super.update(repairOrderAct , mode , throwsException);

		if(r.isSuccess()){
			if(!StringUtil.isBlank(repairOrderAct.getSelectedCode())){
				dao.execute("delete from eam_repair_order_act_sp where act_id=? and selected_code='def'",repairOrderAct.getId(),repairOrderAct.getSelectedCode());
				dao.execute("update eam_repair_order_act_sp set selected_code='def' where act_id=? and selected_code=?",repairOrderAct.getId(),repairOrderAct.getSelectedCode());
			}
		 }

		GoodsStock qE=new GoodsStock();
		qE.setOwnerTmpId(repairOrderAct.getId());
		List<GoodsStock> list =goodsStockService.queryList(qE);
		for(int i=0;i<list.size();i++){
			list.get(i).setOwnerCode(repairOrderAct.getOwnerType());
		}
		return goodsStockService.saveOwnerData(repairOrderAct.getId(),repairOrderAct.getOwnerType(),list);

	}

	/**
	 * 更新实体集，事务内
	 * @param repairOrderActList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<RepairOrderAct> repairOrderActList , SaveMode mode) {
		return super.updateList(repairOrderActList , mode);
	}

	
	/**
	 * 按主键更新字段 维修工单
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


	@Override
	public RepairOrderAct getByOrderId(String orderId) {
		Rcd rs=dao.queryRecord("select * from eam_repair_order_act where order_id=?",orderId);
		return this.getById(rs.getString("id"));
	}
	/**
	 * 按主键获取 维修工单
	 *
	 * @param id 主键
	 * @return RepairOrderAct 数据对象
	 */
	public RepairOrderAct getById(String id) {
		RepairOrderAct sample = new RepairOrderAct();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<RepairOrderAct> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, RepairOrderAct> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, RepairOrderAct::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<RepairOrderAct> queryList(RepairOrderAct sample) {
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
	public PagedList<RepairOrderAct> queryPagedList(RepairOrderAct sample, int pageSize, int pageIndex) {
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
	public PagedList<RepairOrderAct> queryPagedList(RepairOrderAct sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param repairOrderAct 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(RepairOrderAct repairOrderAct) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(repairOrderAct, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(RepairOrderAct sample) {
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