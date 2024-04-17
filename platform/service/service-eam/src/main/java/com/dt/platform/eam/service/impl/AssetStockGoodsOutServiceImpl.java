package com.dt.platform.eam.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.*;
import com.dt.platform.eam.service.*;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.commons.reflect.EnumUtil;
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
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 库存出库 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-22 20:46:11
*/


@Service("EamAssetStockGoodsOutService")
public class AssetStockGoodsOutServiceImpl extends SuperService<AssetStockGoodsOut> implements IAssetStockGoodsOutService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	@Autowired
	private IOperateService operateService;

	@Autowired
	private IGoodsStockService goodsStockService;

	@Autowired
	private IDeviceSpService deviceSpService;


	@Autowired
	private IAssetService assetService;

	@Autowired
	private IGoodsStockUsageService goodsStockUsageService;


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param assetStockGoodsOut  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AssetStockGoodsOut assetStockGoodsOut,boolean throwsException) {
		String selectedCode=assetStockGoodsOut.getSelectedCode();
		GoodsStock qE=new GoodsStock();
		qE.setSelectedCode(selectedCode);
		List<GoodsStock> list =goodsStockService.queryList(qE);
		if(list.size()==0){
			return ErrorDesc.failureMessage("请选择物品");
		}
		for(int i=0;i<list.size();i++){
			if(list.get(i).getStockInNumber().compareTo(new BigDecimal("0"))==1){
				Logger.info("check ok");
			}else{
				return ErrorDesc.failureMessage("编号:"+list.get(i).getId()+",当前数量必须大于0");
			}
//			if(list.get(i).getWarehouseId().equals(assetStockGoodsOut.getWarehouseId())){
//				Logger.info("check ok");
//			}else{
//				return ErrorDesc.failureMessage("出库物品所在仓库需和本次出库仓库保持一致");
//			}
		}


		//制单人
		if(StringUtil.isBlank(assetStockGoodsOut.getOriginatorId())){
			assetStockGoodsOut.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//办理情况
		if(StringUtil.isBlank(assetStockGoodsOut.getStatus())){
			assetStockGoodsOut.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}



		//登记日期
		if(assetStockGoodsOut.getBusinessDate()==null){
			assetStockGoodsOut.setBusinessDate(new Date());
		}

		//编码
		String codeRule="";
		if(AssetStockGoodsTypeEnum.STOCK.code().equals(assetStockGoodsOut.getOwnerType())){
			codeRule= CodeModuleEnum.EAM_ASSET_STOCK_GOODS_OUT.code();
		}else if(AssetStockGoodsTypeEnum.CONSUMABLES.code().equals(assetStockGoodsOut.getOwnerType())){
			codeRule= CodeModuleEnum.EAM_ASSET_CONSUMABLES_GOODS_OUT.code();
		}else if(AssetStockGoodsTypeEnum.PART.code().equals(assetStockGoodsOut.getOwnerType())){
			codeRule= CodeModuleEnum.EAM_ASSET_PART_GOODS_OUT.code();
		}

		if(StringUtil.isBlank(assetStockGoodsOut.getBusinessCode())){
			if(!StringUtil.isBlank(codeRule)){
				if(!StringUtil.isBlank(codeRule)){
					Result codeResult= CodeModuleServiceProxy.api().generateCode(codeRule) ;
					if(!codeResult.isSuccess()){
						return codeResult;
					}else{
						assetStockGoodsOut.setBusinessCode(codeResult.getData().toString());
					}
				}
			}
		}
		Result r=super.insert(assetStockGoodsOut,throwsException);
		for(int i=0;i<list.size();i++){
		//	list.get(i).setWarehouseId(assetStockGoodsOut.getWarehouseId());
			list.get(i).setBusinessCode(assetStockGoodsOut.getBusinessCode());
			list.get(i).setOwnerCode(assetStockGoodsOut.getOwnerType());
		}
		goodsStockService.saveOwnerData(assetStockGoodsOut.getId(),assetStockGoodsOut.getOwnerType(),list);
		return r;
	}



	@Override
	public Map<String, Object> getBill(String id) {

		AssetStockGoodsOut data=getById(id);
		this.dao().fill(data)
				.with("useOwnCompany")
				.with("useOrganization")
				.with("originator")
				.with("useUser")
				.with(AssetStockGoodsOutMeta.WAREHOUSE)
				.with(AssetStockGoodsOutMeta.STOCK_TYPE_DICT)
				.execute();
		this.dao().join(data.getUseUser(), Person.class);
		this.dao().join(data.getOriginator(),Person.class);

		GoodsStockVO vo=new GoodsStockVO();
		vo.setPageIndex(1);
		vo.setPageSize(1000);
		vo.setOwnerTmpId(id);
		PagedList<GoodsStock> list=goodsStockService.queryPagedListBySelected(vo,"","reset");
		goodsStockService.dao().fill(list)
				.with("ownerCompany")
				.with("useOrganization")
				.with("manager")
				.with("originator")
				.with(GoodsStockMeta.CATEGORY)
				.with(GoodsStockMeta.GOODS)
				.with(GoodsStockMeta.SOURCE)
				.with(GoodsStockMeta.WAREHOUSE)
				.with(GoodsMeta.CATEGORY)
				.with(GoodsStockMeta.BRAND)
				.with(GoodsMeta.MANUFACTURER)
				.execute();
		data.setGoodsList(list.getList());

		Map<String, Object> map= BeanUtil.toMap(data);
		if(data.getStatus()!=null){
			CodeTextEnum en= EnumUtil.parseByCode(AssetHandleStatusEnum.class,data.getStatus());
			map.put("statusName", en==null?data.getStatus():en.text());
		}
		return map;

	}



	/**
	 * 操作
	 * @param id  ID
	 * @param result 结果
	 * @return
	 * */
	private Result operateResult(String id,String result,String status,String message) {
		if(AssetHandleConfirmOperationEnum.SUCCESS.code().equals(result)){

			Result comRs= computeStockData(id);
			if(!comRs.isSuccess()){
				return comRs;
			}
			dao.execute("update eam_goods_stock a,eam_warehouse_position b set a.status=?,a.warehouse_id=b.warehouse_id where a.position_id=b.id and a.owner_id=? ",status,id);
			//后续需要加盘点
			AssetStockGoodsOut bill=new AssetStockGoodsOut();
			bill.setId(id);
			bill.setStatus(status);
			return super.update(bill,SaveMode.NOT_NULL_FIELDS,false);
		}else if(AssetHandleConfirmOperationEnum.FAILED.code().equals(result)){
			return ErrorDesc.failureMessage(message);
		}else{
			return ErrorDesc.failureMessage("返回未知结果");
		}
	}

	private Result computeStockData(String id){
		AssetStockGoodsOut bill=this.getById(id);
		this.dao().fill(bill)
				.with(AssetStockGoodsInMeta.GOODS_LIST)
				.execute();

		String cUserId=SessionUser.getCurrent().getActivatedEmployeeId();
		String cUserName=SessionUser.getCurrent().getUser().getActivatedEmployeeName();
		//不进行判断，直接进行库存减
		List<GoodsStock> goods=bill.getGoodsList();
		if(goods!=null&&goods.size()>0){
			for(int i=0;i<goods.size();i++){
				String rid=goods.get(i).getRealStockId();
				String value=goods.get(i).getStockInNumber()+"";
				String sql="update eam_goods_stock set stock_cur_number=stock_cur_number-"+value+" where id=?";
				this.dao.execute(sql,rid);
				GoodsStockUsage goodsStockUsage=new GoodsStockUsage();
				goodsStockUsage.setOwnerId(rid);
				goodsStockUsage.setLabel("出库");
				goodsStockUsage.setOperUserId(cUserId);
				goodsStockUsage.setOperUserName(cUserName);
				goodsStockUsage.setRecTime(new Date());
				goodsStockUsage.setOper(AssetStockTypeEnum.OUT.code());
				goodsStockUsage.setBillCode(bill.getBusinessCode());
				goodsStockUsage.setOperNumber(value);
				goodsStockUsage.setContent("出库完成");
				goodsStockUsageService.insert(goodsStockUsage,true);

			}
		}
		return ErrorDesc.success();
	}


	@Override
	public Result confirmOperation(String id) {
		AssetStockGoodsOut billData=getById(id);
		if(AssetHandleStatusEnum.INCOMPLETE.code().equals(billData.getStatus())){
			String operCode="";
			if(AssetStockGoodsTypeEnum.STOCK.code().equals(billData.getOwnerType())){
				operCode= AssetOperateEnum.EAM_ASSET_STOCK_GOODS_OUT.code();
			}else if(AssetStockGoodsTypeEnum.CONSUMABLES.code().equals(billData.getOwnerType())){
				operCode=AssetOperateEnum.EAM_ASSET_CONSUMABLES_GOODS_OUT.code();
			}else if(AssetStockGoodsTypeEnum.PART.code().equals(billData.getOwnerType())){
				operCode=AssetOperateEnum.EAM_ASSET_PART_GOODS_OUT.code();
			}

			if(operateService.approvalRequired(operCode) ) {
				return ErrorDesc.failureMessage("当前单据需要审批,请送审");
			}else{
				return operateResult(id,AssetHandleConfirmOperationEnum.SUCCESS.code(),AssetHandleStatusEnum.COMPLETE.code(),"操作成功");
			}
		}else{
			return ErrorDesc.failureMessage("当前状态为:"+billData.getStatus()+",不能进行该操作");
		}

	}


	@Override
	public Result selectImportItem(String id, String importType, String billId) {
		if(StringUtil.isBlank(id)){
			return ErrorDesc.failureMessage("请选择库存单");
		}
		JSONArray idsArr= JSONArray.parseArray(id);
		if(idsArr==null&&idsArr.size()==0){
			return ErrorDesc.failureMessage("请选择库存单");
		}
		if(AssetImportSourceTypeEnum.STOCK.code().equals(importType)){
			return importToAsset(idsArr.getString(0),billId);
		}
		return ErrorDesc.success();

	}

	private Result importToAsset(String id,String billId){
		AssetStockGoodsOut out=this.getById(id);
		this.dao.fill(out).with(AssetStockGoodsOutMeta.GOODS_LIST).execute();
		List<GoodsStock> list=out.getGoodsList();
		if(list.size()==0){
			return ErrorDesc.failureMessage("未找到物品");
		}
		dao.execute("delete from eam_asset where bill_id=?",billId);
		for(int i=0;i<list.size();i++){
			String goodsId=list.get(i).getGoodsId();
			GoodsStock gs=goodsStockService.getById(goodsId);
			if(gs==null){
				continue;
			}
			for(int j=0;j<list.get(i).getStockCurNumber().intValue();j++){
				Asset asset=new Asset();
				asset.setAssetCode("自动配置");
				asset.setOwnerCode(AssetOwnerCodeEnum.ASSET_IMPORT.code());
				asset.setName(gs.getName());
				asset.setModel(gs.getModel());
				asset.setBillId(billId);
				asset.setPurchaseDate(new Date());
				asset.setUnit(gs.getUnit());
				asset.setGoodsId(gs.getId());
				asset.setCreateTime(new Date());
				asset.setManufacturerId(gs.getManufacturerId());
				asset.setAssetStatus(AssetStatusEnum.IDLE.code());
				asset.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
				asset.setSourceId("purchase");
				asset.setCategoryId(gs.getCategoryId());
				assetService.insert(asset);
			}
		}
		return ErrorDesc.success();
	}

	@Override
	public Result fillToSpPperation(String id) {
		//如果是备件，将出库数据到备件清单中
		AssetStockGoodsOut billData=getById(id);
		if(!"complete".equals(billData.getStatus())){
			return ErrorDesc.failureMessage("当前单据状态未完成");
		}

		if(!"part".equals(billData.getOwnerType())){
			return ErrorDesc.failureMessage("当前不是备件单据");
		}

		if("yes".equals(billData.getToBook())){
			return ErrorDesc.failureMessage("当前单据数据已导入到备件清单,不需要重复操作");
		}

		if(AssetStockGoodsTypeEnum.PART.code().equals(billData.getOwnerType())){
			goodsStockService.dao().fill(billData).with(AssetStockGoodsOutMeta.GOODS_LIST).execute();;
			List<GoodsStock> goods=billData.getGoodsList();
			JSONArray spIds=new JSONArray();
			for(int i=0;i<goods.size();i++){
				GoodsStock good=goods.get(i);
				GoodsStock rGood=goodsStockService.getById(good.getGoodsId());
				for(int j=0;j<good.getStockInNumber().intValue();j++){
					DeviceSp sp=new DeviceSp();
					sp.setWarehouseId(good.getWarehouseId());
					sp.setName(rGood.getName());
					sp.setGoodId(rGood.getId());
					sp.setModel(rGood.getModel());
					sp.setSn(rGood.getSn());
					sp.setNotes(rGood.getNotes());
					sp.setInsertTime(new Date());
					sp.setSourceDesc("来源为库存备件出库,单据号:"+billData.getBusinessCode());
					deviceSpService.insert(sp);
					spIds.add(sp.getId());
				}
			}
			deviceSpService.batchSure(spIds.toJSONString());
		}
		String updateSql="update eam_asset_stock_goods_out set to_book=? where id=?";
		dao.execute(updateSql,"yes",id);
		return ErrorDesc.success();
	}


	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param assetStockGoodsOut 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetStockGoodsOut assetStockGoodsOut) {
		return this.insert(assetStockGoodsOut,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param assetStockGoodsOutList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetStockGoodsOut> assetStockGoodsOutList) {
		return super.insertList(assetStockGoodsOutList);
	}

	
	/**
	 * 按主键删除 库存出库
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetStockGoodsOut assetStockGoodsOut = new AssetStockGoodsOut();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetStockGoodsOut.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetStockGoodsOut);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 库存出库
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetStockGoodsOut assetStockGoodsOut = new AssetStockGoodsOut();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetStockGoodsOut.setId(id);
		assetStockGoodsOut.setDeleted(1);
		assetStockGoodsOut.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetStockGoodsOut.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetStockGoodsOut,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetStockGoodsOut 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetStockGoodsOut assetStockGoodsOut , SaveMode mode) {
		return this.update(assetStockGoodsOut,mode,true);
	}


	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param assetStockGoodsOut 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetStockGoodsOut assetStockGoodsOut , SaveMode mode,boolean throwsException) {
		AssetStockGoodsOut bill=this.getById(assetStockGoodsOut.getId());
		GoodsStock qE=new GoodsStock();
		qE.setOwnerTmpId(assetStockGoodsOut.getId());
		List<GoodsStock> list =goodsStockService.queryList(qE);
		if(list.size()==0){
			return ErrorDesc.failureMessage("请选择物品");
		}
		for(int i=0;i<list.size();i++){
			if(list.get(i).getStockInNumber().compareTo(new BigDecimal("0"))==1){
				Logger.info("check ok");
			}else{
				return ErrorDesc.failureMessage("编号:"+list.get(i).getId()+",当前数量必须大于0");
			}
//			if(list.get(i).getWarehouseId().equals(assetStockGoodsOut.getWarehouseId())){
//				Logger.info("check ok");
//			}else{
//				return ErrorDesc.failureMessage("出库物品所在仓库需和本次出库仓库保持一致");
//			}
		}


		Result r=super.update(assetStockGoodsOut , mode , throwsException);
		for(int i=0;i<list.size();i++){
			list.get(i).setBusinessCode(bill.getBusinessCode());
			list.get(i).setOwnerCode(assetStockGoodsOut.getOwnerType());
		}
		goodsStockService.saveOwnerData(assetStockGoodsOut.getId(),assetStockGoodsOut.getOwnerType(),list);
		return r;

	}

	/**
	 * 更新实体集，事务内
	 * @param assetStockGoodsOutList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetStockGoodsOut> assetStockGoodsOutList , SaveMode mode) {
		return super.updateList(assetStockGoodsOutList , mode);
	}

	
	/**
	 * 按主键更新字段 库存出库
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
	 * 按主键获取 库存出库
	 *
	 * @param id 主键
	 * @return AssetStockGoodsOut 数据对象
	 */
	public AssetStockGoodsOut getById(String id) {
		AssetStockGoodsOut sample = new AssetStockGoodsOut();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<AssetStockGoodsOut> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetStockGoodsOut> queryList(AssetStockGoodsOut sample) {
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
	public PagedList<AssetStockGoodsOut> queryPagedList(AssetStockGoodsOut sample, int pageSize, int pageIndex) {
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
	public PagedList<AssetStockGoodsOut> queryPagedList(AssetStockGoodsOut sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param assetStockGoodsOut 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AssetStockGoodsOut assetStockGoodsOut) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(assetStockGoodsOut, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(AssetStockGoodsOut sample) {
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
