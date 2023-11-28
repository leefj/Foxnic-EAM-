package com.dt.platform.eam.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.AssetImportStatusEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.PurchaseImportMeta;
import com.dt.platform.eam.service.IAssetProcessRecordService;
import com.dt.platform.eam.service.IAssetService;
import com.dt.platform.eam.service.IPurchaseApplyService;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.sql.expr.Update;
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
import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.dao.data.SaveMode;
import com.dt.platform.eam.service.IPurchaseImportService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 采购单导入服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-11-25 21:35:08
*/


@Service("EamPurchaseImportService")

public class PurchaseImportServiceImpl extends SuperService<PurchaseImport> implements IPurchaseImportService {

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
	private IPurchaseApplyService purchaseApplyService;


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
	 * @param purchaseImport  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(PurchaseImport purchaseImport,boolean throwsException) {

		PurchaseApply apply=purchaseApplyService.getById(purchaseImport.getOrderId());
		purchaseImport.setOrderCode(apply.getBusinessCode());
		purchaseImport.setOrderName(apply.getName());
		purchaseImport.setStatus(AssetImportStatusEnum.wait.code());
		purchaseImport.setOperUserId(SessionUser.getCurrent().getActivatedEmployeeId());
		Result r=super.insert(purchaseImport,throwsException);
		if(r.isSuccess()){
			//修改资产数据
			fill(purchaseImport);
		}
		return r;
	}



	@Override
	public Result fill(PurchaseImport purchaseImport) {
		Update ups=new Update("eam_asset");
		if((!StringUtil.isBlank(purchaseImport.getUseOrgId()))){
			ups.set("use_organization_id",purchaseImport.getUseOrgId());
		}
		if((!StringUtil.isBlank(purchaseImport.getOwnCompanyId()))){
			ups.set("own_company_id",purchaseImport.getOwnCompanyId());
		}
		if((!StringUtil.isBlank(purchaseImport.getManagerId()))){
			ups.set("manager_id",purchaseImport.getManagerId());
		}
		if((!StringUtil.isBlank(purchaseImport.getUseUserId()))){
			ups.set("use_user_id",purchaseImport.getUseUserId());
		}
		if((!StringUtil.isBlank(purchaseImport.getPositionId()))){
			ups.set("position_id",purchaseImport.getPositionId());
		}
		if((!StringUtil.isBlank(purchaseImport.getAssetNotes()))&&purchaseImport.getAssetNotes().length()>5){
			ups.set("asset_notes",purchaseImport.getAssetNotes());
		}
		ups.set("deleted",0);

		//如果有id，根据ID进行更新
		if(StringUtil.isBlank(purchaseImport.getId())){
			ups.set("bill_id",purchaseImport.getSelectedCode());
			ups.where("bill_id=?",purchaseImport.getSelectedCode());
		}else{
			ups.set("bill_id",purchaseImport.getId());
			ups.where("bill_id=?",purchaseImport.getId());
		}
		dao.execute(ups);
		return ErrorDesc.success();
	}

	@Override
	public Result cancel(String id) {
		PurchaseImport data=this.getById(id);
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
		PurchaseImport purchaseImport=this.getById(id);
		if(AssetImportStatusEnum.wait.code().equals(purchaseImport.getStatus())){
			purchaseImport.setStatus(AssetImportStatusEnum.finish.code());
			super.update(purchaseImport,SaveMode.NOT_NULL_FIELDS,false);
			fill(purchaseImport);
			dao.execute("update eam_asset set status=?,owner_code=?,bill_id=? where bill_id=?","complete","asset",purchaseImport.getId(),purchaseImport.getId());
			dao.fill(purchaseImport).with(PurchaseImportMeta.ASSET_LIST).execute();
			List<Asset> list=purchaseImport.getAssetList();
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
				rcd.setProcessUserId(SessionUser.getCurrent().getActivatedEmployeeId());
				rcd.setBusinessCode(purchaseImport.getId());
				rcd.setProcessdTime(new Date());
				rcd.setProcessType("eam_asset_insert");
				rcd.setContent("来自采购订单,订单编号:"+purchaseImport.getOrderName());
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
	 * @param purchaseImport 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(PurchaseImport purchaseImport) {
		return this.insert(purchaseImport,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param purchaseImportList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<PurchaseImport> purchaseImportList) {
		return super.insertList(purchaseImportList);
	}

	
	/**
	 * 按主键删除采购单导入
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		PurchaseImport purchaseImport = new PurchaseImport();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		purchaseImport.setId(id);
		try {
			boolean suc = dao.deleteEntity(purchaseImport);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除采购单导入
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		PurchaseImport purchaseImport = new PurchaseImport();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		purchaseImport.setId(id);
		purchaseImport.setDeleted(true);
		purchaseImport.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		purchaseImport.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(purchaseImport,SaveMode.NOT_NULL_FIELDS);
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
	 * @param purchaseImport 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(PurchaseImport purchaseImport , SaveMode mode) {
		return this.update(purchaseImport,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param purchaseImport 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(PurchaseImport purchaseImport , SaveMode mode,boolean throwsException) {
		Result r=super.update(purchaseImport , mode , throwsException);
		if(r.isSuccess()){
			fill(purchaseImport);
		}
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param purchaseImportList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<PurchaseImport> purchaseImportList , SaveMode mode) {
		return super.updateList(purchaseImportList , mode);
	}

	
	/**
	 * 按主键更新采购单导入
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
	 * 按主键获取采购单导入
	 *
	 * @param id 主键
	 * @return PurchaseImport 数据对象
	 */
	public PurchaseImport getById(String id) {
		PurchaseImport sample = new PurchaseImport();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<PurchaseImport> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<PurchaseImport> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, PurchaseImport> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, PurchaseImport::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<PurchaseImport> queryList(PurchaseImportVO sample) {
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
	public PagedList<PurchaseImport> queryPagedList(PurchaseImportVO sample, int pageSize, int pageIndex) {
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
	public PagedList<PurchaseImport> queryPagedList(PurchaseImport sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param purchaseImport 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(PurchaseImport purchaseImport) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(purchaseImport, SYS_ROLE.NAME);
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