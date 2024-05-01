package com.dt.platform.eam.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.AssetImportStatusEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.PurchaseImportMeta;
import com.dt.platform.eam.service.IAssetProcessRecordService;
import com.dt.platform.eam.service.IAssetService;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.sql.expr.Update;
import org.github.foxnic.web.session.SessionUser;
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
import com.dt.platform.eam.service.IStockImportService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 库存导入资产服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-11-28 09:07:15
*/


@Service("EamStockImportService")

public class StockImportServiceImpl extends SuperService<StockImport> implements IStockImportService {

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
	private IAssetService assetService;

	@Autowired
	private IAssetProcessRecordService assetProcessRecordService;


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param stockImport  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(StockImport stockImport,boolean throwsException) {
	//	PurchaseApply apply=purchaseApplyService.getById(purchaseImport.getOrderId());
	//	stockImport.setOrderCode(apply.getBusinessCode());
//		stockImport.setOrderName(apply.getName());
		stockImport.setStatus(AssetImportStatusEnum.wait.code());
		stockImport.setOperUserId(SessionUser.getCurrent().getActivatedEmployeeId());
		Result r=super.insert(stockImport,throwsException);
		if(r.isSuccess()){
			//修改资产数据
			fill(stockImport);
		}
		return r;
	}

	@Override
	public Result fill(StockImport stockImport) {
		Update ups=new Update("eam_asset");
		if((!StringUtil.isBlank(stockImport.getUseOrgId()))){
			ups.set("use_organization_id",stockImport.getUseOrgId());
		}
		if((!StringUtil.isBlank(stockImport.getOwnCompanyId()))){
			ups.set("own_company_id",stockImport.getOwnCompanyId());
		}
		if((!StringUtil.isBlank(stockImport.getManagerId()))){
			ups.set("manager_id",stockImport.getManagerId());
		}
		if((!StringUtil.isBlank(stockImport.getUseUserId()))){
			ups.set("use_user_id",stockImport.getUseUserId());
		}
		if((!StringUtil.isBlank(stockImport.getPositionId()))){
			ups.set("position_id",stockImport.getPositionId());
		}
		if((!StringUtil.isBlank(stockImport.getAssetNotes()))&&stockImport.getAssetNotes().length()>5){
			ups.set("asset_notes",stockImport.getAssetNotes());
		}
		ups.set("deleted",0);

		//如果有id，根据ID进行更新
		if(StringUtil.isBlank(stockImport.getId())){
			ups.set("bill_id",stockImport.getSelectedCode());
			ups.where("bill_id=?",stockImport.getSelectedCode());
		}else{
			ups.set("bill_id",stockImport.getId());
			ups.where("bill_id=?",stockImport.getId());
		}
		dao.execute(ups);
		return ErrorDesc.success();
	}

	@Override
	public Result cancel(String id) {
		StockImport data=this.getById(id);
		if(AssetImportStatusEnum.wait.code().equals(data.getStatus())){
			data.setStatus(AssetImportStatusEnum.cancel.code());
			super.update(data,SaveMode.NOT_NULL_FIELDS,false);
		}else{
			return ErrorDesc.failureMessage("当前状态不允许此操作");
		}
		return ErrorDesc.success();
	}

	@Override
	public Result sure(String id) {
		StockImport stockImport=this.getById(id);
		if(AssetImportStatusEnum.wait.code().equals(stockImport.getStatus())){
			stockImport.setStatus(AssetImportStatusEnum.finish.code());
			super.update(stockImport,SaveMode.NOT_NULL_FIELDS,false);
			fill(stockImport);
			dao.execute("update eam_asset set status=?,owner_code=?,bill_id=? where bill_id=?","complete","asset",stockImport.getId(),stockImport.getId());
			dao.fill(stockImport).with(PurchaseImportMeta.ASSET_LIST).execute();
			List<Asset> list=stockImport.getAssetList();
			for(int i=0;i<list.size();i++){
				String codeRule= CodeModuleEnum.EAM_ASSET_CODE.code();
				Asset asset=list.get(i);
				JSONObject codeObject=new JSONObject();
				codeObject.put("ownOrgId",asset.getOwnCompanyId() );
				codeObject.put("useOrgId",asset.getUseOrganization());
				codeObject.put("categoryId",asset.getCategoryId());
				Result codeResult= assetService.generateAssetCode(codeRule,codeObject,"");
				dao.execute("update eam_asset set asset_code=? where id=?",codeResult.getData().toString(),asset.getId());
				AssetProcessRecord rcd=new AssetProcessRecord();
				rcd.setAssetId(asset.getId());
				rcd.setBusinessCode(stockImport.getId());
				rcd.setProcessdTime(new Date());
				rcd.setProcessType("eam_asset_insert");
				rcd.setContent("来自库存订单,订单编号:"+stockImport.getOrderName());
				String operUserId="sysinter";
				if(SessionUser.getCurrent()!=null){
					operUserId=SessionUser.getCurrent().getActivatedEmployeeId();
				}
				rcd.setProcessUserId(operUserId);
				assetProcessRecordService.insert(rcd,true);
			}
		}else{
			return ErrorDesc.failureMessage("当前状态不允许此操作");
		}
		return ErrorDesc.success();
	}

	@Override
	public Result loadAsset(String id) {
		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param stockImport 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(StockImport stockImport) {
		return this.insert(stockImport,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param stockImportList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<StockImport> stockImportList) {
		return super.insertList(stockImportList);
	}

	
	/**
	 * 按主键删除库存导入资产
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		StockImport stockImport = new StockImport();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		stockImport.setId(id);
		try {
			boolean suc = dao.deleteEntity(stockImport);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除库存导入资产
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		StockImport stockImport = new StockImport();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		stockImport.setId(id);
		stockImport.setDeleted(true);
		stockImport.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		stockImport.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(stockImport,SaveMode.NOT_NULL_FIELDS);
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
	 * @param stockImport 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(StockImport stockImport , SaveMode mode) {
		return this.update(stockImport,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param stockImport 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(StockImport stockImport , SaveMode mode,boolean throwsException) {
		Result r=super.update(stockImport , mode , throwsException);
		if(r.isSuccess()){
			fill(stockImport);
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param stockImportList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<StockImport> stockImportList , SaveMode mode) {
		return super.updateList(stockImportList , mode);
	}

	
	/**
	 * 按主键更新库存导入资产
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
	 * 按主键获取库存导入资产
	 *
	 * @param id 主键
	 * @return StockImport 数据对象
	 */
	public StockImport getById(String id) {
		StockImport sample = new StockImport();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<StockImport> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<StockImport> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, StockImport> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, StockImport::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<StockImport> queryList(StockImportVO sample) {
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
	public PagedList<StockImport> queryPagedList(StockImportVO sample, int pageSize, int pageIndex) {
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
	public PagedList<StockImport> queryPagedList(StockImport sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param stockImport 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(StockImport stockImport) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(stockImport, SYS_ROLE.NAME);
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