package com.dt.platform.eam.service.impl;


import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.eam.AssetStockTypeEnum;
import com.dt.platform.constants.enums.eam.StockStatusSuccessFailedEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.PurchaseApplyMeta;
import com.dt.platform.domain.eam.meta.PurchaseOrderMeta;
import com.dt.platform.eam.service.IGoodsStockUsageService;
import com.dt.platform.eam.service.IPurchaseApplyService;
import com.dt.platform.eam.service.IPurchaseCheckService;
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
import com.github.foxnic.sql.expr.Insert;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 采购验收 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-14 21:25:25
*/


@Service("EamPurchaseCheckService")
public class PurchaseCheckServiceImpl extends SuperService<PurchaseCheck> implements IPurchaseCheckService {

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
	private IGoodsStockUsageService goodsStockUsageService;

	@Autowired
	private IPurchaseApplyService purchaseApplyService;

	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param purchaseCheck  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(PurchaseCheck purchaseCheck,boolean throwsException) {

		//制单人
		if(StringUtil.isBlank(purchaseCheck.getOriginatorId())){
			purchaseCheck.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//办理状态
		if(StringUtil.isBlank(purchaseCheck.getStatus())){
			purchaseCheck.setStatus(AssetHandleStatusEnum.COMPLETE.code());
		}


		//生成编码规则
		if(StringUtil.isBlank(purchaseCheck.getBusinessCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_PURCHASE_CHECK.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				purchaseCheck.setBusinessCode(codeResult.getData().toString());
			}
		}
		//是否入库
		String ifStock=purchaseCheck.getInsertPosition();
		if(YesNoEnum.YES.code().equals(ifStock)){
			String posId=purchaseCheck.getPositionId();
			if(StringUtil.isBlank(posId)){
				return ErrorDesc.failureMessage("请选择仓库库位置");
			}
			String purchaseId=purchaseCheck.getApplyId();
			PurchaseApply apply=purchaseApplyService.getById(purchaseId);
			dao.fill(apply).with(PurchaseApplyMeta.ORDER_LIST).execute();

			String tId=SessionUser.getCurrent().getActivatedTenantId();
			List<PurchaseOrder> list=apply.getOrderList();
			dao.fill(list).with(PurchaseOrderMeta.GOODS).execute();
			for(int i=0;i<list.size();i++){
				String gId="none";
				String goodsId=list.get(i).getGoodsId();
				GoodsStock goods=list.get(i).getGoods();
				String sql="select id,goods_id from eam_goods_stock where deleted=0 and owner_code=? and tenant_id=? and goods_id=? and position_id=?";
			   	Rcd rs=this.dao.queryRecord(sql,"real_stock",tId,goodsId,posId);
				if(rs==null){
					//新增,真实物品
					Insert ins=new Insert("eam_goods_stock");
					gId=IDGenerator.getSnowflakeIdString();
					ins.set("id",gId);
					ins.set("owner_code","real_stock");
					ins.set("owner_type","stock");
					ins.set("stock_cur_number",list.get(i).getPurchaseNumber());
					ins.set("tenant_id",tId);
					ins.set("position_id",posId);
					ins.set("goods_id",goodsId);
					ins.set("category_id",goods.getCategoryId());
					ins.set("notes","采购入库,采购单:"+purchaseCheck.getApplyId());
					this.dao.execute(ins);
					dao.execute("update eam_goods_stock a,eam_warehouse_position b set a.warehouse_id=b.warehouse_id where a.position_id=b.id and a.id=?",gId);
				}else{
					//增量修改物品数据
					gId=rs.getString("id");
					String updateSql="update eam_goods_stock set stock_cur_number=stock_cur_number+"+list.get(i).getPurchaseNumber()+" where id=?";
					this.dao.execute(updateSql,gId);
				}
				GoodsStockUsage goodsStockUsage=new GoodsStockUsage();
				goodsStockUsage.setOwnerId(gId);
				goodsStockUsage.setLabel("采购入库");
				goodsStockUsage.setOperUserId(SessionUser.getCurrent().getActivatedEmployeeId());
				goodsStockUsage.setOperUserName(SessionUser.getCurrent().getUser().getActivatedEmployeeName());
				goodsStockUsage.setRecTime(new Date());
				goodsStockUsage.setOper(AssetStockTypeEnum.IN.code());
				goodsStockUsage.setBillCode(purchaseCheck.getBusinessCode());
				goodsStockUsage.setOperNumber(list.get(i).getPurchaseNumber().toString());
				goodsStockUsage.setContent("采购入库完成");
				goodsStockUsageService.insert(goodsStockUsage,true);


			}
			purchaseCheck.setStockStatus(StockStatusSuccessFailedEnum.SUCCESS.code());
		}else{
			purchaseCheck.setStockStatus(StockStatusSuccessFailedEnum.NONE.code());
		}

		Result r=super.insert(purchaseCheck,throwsException);
		if(r.isSuccess()){
			Result r2=new Result();
			r2.success();
			r2.data(purchaseCheck.getId());
			return r2;
		}
		return r;


	}

	public Result computeStock(String id) {

		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param purchaseCheck 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(PurchaseCheck purchaseCheck) {
		return this.insert(purchaseCheck,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param purchaseCheckList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<PurchaseCheck> purchaseCheckList) {
		return super.insertList(purchaseCheckList);
	}

	
	/**
	 * 按主键删除 采购验收
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		PurchaseCheck purchaseCheck = new PurchaseCheck();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		purchaseCheck.setId(id);
		try {
			boolean suc = dao.deleteEntity(purchaseCheck);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 采购验收
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		PurchaseCheck purchaseCheck = new PurchaseCheck();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		purchaseCheck.setId(id);
		purchaseCheck.setDeleted(1);
		purchaseCheck.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		purchaseCheck.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(purchaseCheck,SaveMode.NOT_NULL_FIELDS);
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
	 * @param purchaseCheck 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(PurchaseCheck purchaseCheck , SaveMode mode) {
		return this.update(purchaseCheck,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param purchaseCheck 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(PurchaseCheck purchaseCheck , SaveMode mode,boolean throwsException) {
		Result r=super.update(purchaseCheck , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param purchaseCheckList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<PurchaseCheck> purchaseCheckList , SaveMode mode) {
		return super.updateList(purchaseCheckList , mode);
	}

	
	/**
	 * 按主键更新字段 采购验收
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
	 * 按主键获取 采购验收
	 *
	 * @param id 主键
	 * @return PurchaseCheck 数据对象
	 */
	public PurchaseCheck getById(String id) {
		PurchaseCheck sample = new PurchaseCheck();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<PurchaseCheck> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<PurchaseCheck> queryList(PurchaseCheck sample) {
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
	public PagedList<PurchaseCheck> queryPagedList(PurchaseCheck sample, int pageSize, int pageIndex) {
		String dp=AssetOperateEnum.EAM_ASSET_PURCHASE_CHECK.code();
		return super.queryPagedList(sample, pageSize, pageIndex,dp);
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
	public PagedList<PurchaseCheck> queryPagedList(PurchaseCheck sample, ConditionExpr condition, int pageSize, int pageIndex) {
		String dp=AssetOperateEnum.EAM_ASSET_PURCHASE_CHECK.code();
		return super.queryPagedList(sample, condition, pageSize, pageIndex,dp);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param purchaseCheck 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(PurchaseCheck purchaseCheck) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(purchaseCheck, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(PurchaseCheck sample) {
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
