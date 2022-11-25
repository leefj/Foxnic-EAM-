package com.dt.platform.eam.service.impl;


import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetDepreciationDetailMeta;
import com.dt.platform.domain.eam.meta.AssetDepreciationOperMeta;
import com.dt.platform.eam.service.*;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.dt.platform.proxy.eam.AssetServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.lang.StringUtil;
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
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 折旧操作 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-05-03 14:47:45
*/


@Service("EamAssetDepreciationOperService")
public class AssetDepreciationOperServiceImpl extends SuperService<AssetDepreciationOper> implements IAssetDepreciationOperService {



	@Autowired
	AssetDepreciationCalculationFactory assetDepreciationCalculationFactory;

	@Autowired
	IAssetDepreciationService assetDepreciationService;

	private String getDepreciationCodeByOperId(){

		return "";
	}

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
	private IAssetDepreciationDetailService assetDepreciationDetailService;

	@Autowired
	private IAssetProcessRecordService assetProcessRecordService;


	@Autowired
	private IAssetService assetService;

	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}



	@Override
	public Result rollback(String id) {
		return ErrorDesc.success();
	}

	private IAssetDepreciationCalculationService getAssetDepreciationCalculationService(String code){
		AssetDepreciationCodeEnum codeEnum = null;
		if(AssetDepreciationCodeEnum.MONTHLY.code().equals(code)){
			codeEnum = AssetDepreciationCodeEnum.MONTHLY;
		}
		if(AssetDepreciationCodeEnum.TEST.code().equals(code)){
			codeEnum = AssetDepreciationCodeEnum.TEST;
		}
		return assetDepreciationCalculationFactory.getService(codeEnum);
	}

	@Override
	public Result start(String id) {
	 	String code=getDepreciationCodeByOperId();
		IAssetDepreciationCalculationService assetDepreciationCalculationService=this.getAssetDepreciationCalculationService(code);
		if(assetDepreciationCalculationService==null){
			return ErrorDesc.failureMessage("当前方案未实现,方案编码:"+code);
		}
		return assetDepreciationCalculationService.fillAssetData(id);
	}

	@Override
	public Result execute(String id) {
		String code=getDepreciationCodeByOperId();
		IAssetDepreciationCalculationService assetDepreciationCalculationService=this.getAssetDepreciationCalculationService(code);
		if(assetDepreciationCalculationService==null){
			return ErrorDesc.failureMessage("当前方案未实现,方案编码:"+code);
		}
		return assetDepreciationCalculationService.calculation(id);

//		AssetDepreciationOper bill=this.getById(id);
//		if(!AssetDepreciationStatusEnum.ACTING.code().equals(bill.getStatus())){
//			return ErrorDesc.failureMessage("当前状态,不可进行本操作");
//		}else{
//		}
//		AssetDepreciationDetailVO assetDepreciationDetail=new AssetDepreciationDetailVO();
//		assetDepreciationDetail.setOperId(id);
//		List<AssetDepreciationDetail> list=assetDepreciationDetailService.queryList(assetDepreciationDetail);
//		if(list.size()==0){
//			return ErrorDesc.failureMessage("没有资产数据需要折旧");
//		}
//		for(AssetDepreciationDetail assetDetail:list){
//			calculateDepreciation(assetDetail);
//			assetDepreciationDetailService.save(assetDetail,SaveMode.NOT_NULL_FIELDS,false);
//		}
//		AssetDepreciationOper ups=new AssetDepreciationOper();
//		ups.setId(id);
//		ups.setExecutionStartTime(new Date());
//		ups.setStatus(AssetDepreciationStatusEnum.ACTING.code());
//		super.save(ups,SaveMode.NOT_NULL_FIELDS,true);
//		return ErrorDesc.success();
	}

	private boolean calculateDepreciation(AssetDepreciationDetail assetDetail){

		//测试数据
		String method=assetDetail.getDepreciationMethod();
		String result="";
		String resultDetail="正常";
		BigDecimal afterPrice=new BigDecimal("0");
		assetDepreciationDetailService.dao().fill(assetDetail)
				.with(AssetDepreciationDetailMeta.ASSET)
				.execute();
		Asset sourceAsset=assetDetail.getAsset();

		//判断
//		Date purchaseDate=assetDetail.getPurchaseDate();
//		BigDecimal residualRate= assetDetail.getResidualRate();
//		BigDecimal serviceLife=assetDetail.getServiceLife();
//		BigDecimal beforePrice=assetDetail.getBeforePrice();
//		BigDecimal purchaseUnitPrice=assetDetail.getPurchaseUnitPrice();
//
//		if(purchaseDate==null||serviceLife==null||residualRate==null||beforePrice==null||purchaseUnitPrice==null){
//			result=AssetDetailDepreciationResultEnum.VALIDATION_FAILED.code();
//			resultDetail="采购日期、资产周期、采购价格、当前净值、残值率中有数据为空";
//			assetDetail.setResultDetail(resultDetail);
//			assetDetail.setResult(result);
//			return false;
//		}

		//小于0,大于100
//		if(residualRate.compareTo(new BigDecimal("0.00")) ==-1||residualRate.compareTo(new BigDecimal("100"))==1 ){
//			result=AssetDetailDepreciationResultEnum.VALIDATION_FAILED.code();
//			resultDetail="残值率为0到100之间";
//			assetDetail.setResultDetail(resultDetail);
//			assetDetail.setResult(result);
//			return false;
//		}

//		if(!(serviceLife.compareTo(new BigDecimal("0.0"))==1)){
//			result=AssetDetailDepreciationResultEnum.VALIDATION_FAILED.code();
//			resultDetail="使用周期不能为0";
//			assetDetail.setResultDetail(resultDetail);
//			assetDetail.setResult(result);
//			return false;
//		}

		//每月的折旧价=(采购价格-采购价格*残值率 )/12/5年限
		//serviceLifeYear=serviceLife/12  月份/12
		//monthDepreciationPrice= (purchaseUnitPrice-purchaseUnitPrice*residualRate/100)/12/serviceLifeYear
//		BigDecimal serviceLifeYear=serviceLife.divide(new BigDecimal("12.0"),2,BigDecimal.ROUND_HALF_DOWN).setScale(0,BigDecimal.ROUND_UP);
//		BigDecimal residualPrice= (purchaseUnitPrice.multiply(residualRate)).divide(new BigDecimal("100.0"));
//		BigDecimal purchaseUnitPricesSubtractResidualPrice=purchaseUnitPrice.subtract(residualPrice);
//		BigDecimal serviceLifeMonth=serviceLifeYear.multiply(new BigDecimal("12.00"));
//		System.out.println("beforePrice:"+beforePrice.toString());
//		System.out.println("purchaseUnitPrice:"+purchaseUnitPrice.toString());
//		System.out.println("residualPrice:"+residualPrice.toString());
//		System.out.println("serviceLife:"+serviceLife.toString());
//		System.out.println("serviceLifeYear:"+serviceLifeYear.toString());
//		System.out.println("serviceLifeMonth:"+serviceLifeMonth.toString());
//		BigDecimal monthDepreciationPrice=purchaseUnitPricesSubtractResidualPrice.divide(serviceLifeMonth,2,BigDecimal.ROUND_HALF_DOWN).setScale(2,BigDecimal.ROUND_HALF_DOWN);
//		afterPrice=beforePrice.subtract(monthDepreciationPrice);
//		if(residualRate.compareTo(new BigDecimal("0.00"))==-1){
//			result=AssetDetailDepreciationResultEnum.VALIDATION_FAILED.code();
//			resultDetail="净值为负数";
//		}
		//获取target 记录
//		System.out.println("sourceAsset,"+sourceAsset);
//		BigDecimal targetPrice=new BigDecimal("0");
//		sourceAsset.setId(null);
//		sourceAsset.setOwnerCode(AssetOwnerCodeEnum.ASSET_DEPRECIATION_DATA.code());
//		sourceAsset.setNavPrice(targetPrice);
//		assetService.insert(sourceAsset);

		//保存target 记录
//		AssetDepreciationDetail ups=new AssetDepreciationDetail();
//		ups.setId(assetDetail.getId());
//		ups.setDetailIdTarget(sourceAsset.getId());
//		//	ups.setAfterPrice(targetPrice);
//		ups.setResult(result);
//		ups.setResultDetail(resultDetail);
		if(StringUtil.isBlank(result)){
			result=AssetDetailDepreciationResultEnum.VALIDATION_SUCCESS.code();
		}
		assetDetail.setResultDetail(resultDetail);
		assetDetail.setResult(result);
//		assetDetail.setAfterPrice(afterPrice);
//		assetDetail.setDepreciationPrice(monthDepreciationPrice);
		return true;
	//	assetDetail.setDetailIdTarget(sourceAsset.getId());
	}




	@Override
	public Result syncData(String id) {
		AssetDepreciationOper bill=this.getById(id);

		if(AssetDepreciationStatusEnum.ACTING.code().equals(bill.getStatus())){
		}else{
			return ErrorDesc.failureMessage("当前状态,不可进行本操作");
		}

		AssetDepreciationDetailVO assetDepreciationDetail=new AssetDepreciationDetailVO();
		assetDepreciationDetail.setOperId(id);
		List<AssetDepreciationDetail> list=assetDepreciationDetailService.queryList(assetDepreciationDetail);
		if(list.size()==0){
			return ErrorDesc.failureMessage("没有资产数据需要折旧");
		}

		if(dao.queryRecord("select count(1) cnt from eam_asset_depreciation_detail where deleted=0 and oper_id=? and result<>'validation_success'",id).getInteger("cnt")>0){
			return ErrorDesc.failureMessage("有资产未通过验证");
		}
//
//		for(AssetDepreciationDetail assetDetail:list){
//			Asset ups=new Asset();
//			ups.setNavPrice(assetDetail.getAfterPrice());
//			ups.setId(assetDetail.getAssetId());
//			assetService.save(ups,SaveMode.NOT_NULL_FIELDS,false);
//
//			AssetProcessRecord ar=new AssetProcessRecord();
//			ar.setAssetId(assetDetail.getAssetId());
//			ar.setBusinessCode(bill.getBusinessCode());
//			ar.setProcessType(AssetOperateEnum.EAM_ASSET_DEPRECIATION_OPER.code());
//			ar.setProcessdTime(new Date());
//			ar.setContent("【资产净值】由"+assetDetail.getBeforePrice()+"折旧为"+assetDetail.getAfterPrice());
//			assetProcessRecordService.insert(ar,false);
//		}

		AssetDepreciationOper ups=new AssetDepreciationOper();
		ups.setId(id);
		ups.setExecutionEndTime(new Date());
		ups.setStatus(AssetDepreciationStatusEnum.COMPLETE.code());
		super.save(ups,SaveMode.NOT_NULL_FIELDS,true);
		return ErrorDesc.success();
	}


	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param assetDepreciationOper  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AssetDepreciationOper assetDepreciationOper,boolean throwsException) {

		//制单人
		if(StringUtil.isBlank(assetDepreciationOper.getOriginatorId())){
			assetDepreciationOper.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//办理情况
		if(StringUtil.isBlank(assetDepreciationOper.getStatus())){
			assetDepreciationOper.setStatus(AssetDepreciationStatusEnum.NOT_START.code());
		}

		if(StringUtil.isBlank(assetDepreciationOper.getDepreciationId())){
			ErrorDesc.failureMessage("未选择具体执行的折旧方案");
		}
		AssetDepreciation assetDepreciation= assetDepreciationService.getById(assetDepreciationOper.getDepreciationId());
		assetDepreciationOper.setDepreciationCode(assetDepreciation.getCode());

		//登记日期
		if(assetDepreciationOper.getBusinessDate()==null){
			assetDepreciationOper.setBusinessDate(new Date());
		}

		if(StringUtil.isBlank(assetDepreciationOper.getBusinessCode())){
			Result codeResult=CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_DEPRECIATION_OPER.code()) ;
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				assetDepreciationOper.setBusinessCode(codeResult.getData().toString());
			}
		}


		Result r=super.insert(assetDepreciationOper,throwsException);

		return r;
	}


	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param assetDepreciationOper 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetDepreciationOper assetDepreciationOper) {
		return this.insert(assetDepreciationOper,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param assetDepreciationOperList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetDepreciationOper> assetDepreciationOperList) {
		return super.insertList(assetDepreciationOperList);
	}

	
	/**
	 * 按主键删除 折旧操作
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetDepreciationOper assetDepreciationOper = new AssetDepreciationOper();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetDepreciationOper.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetDepreciationOper);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除 折旧操作
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetDepreciationOper assetDepreciationOper = new AssetDepreciationOper();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetDepreciationOper.setId(id);
		assetDepreciationOper.setDeleted(1);
		assetDepreciationOper.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetDepreciationOper.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetDepreciationOper,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetDepreciationOper 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetDepreciationOper assetDepreciationOper , SaveMode mode) {
		return this.update(assetDepreciationOper,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param assetDepreciationOper 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetDepreciationOper assetDepreciationOper , SaveMode mode,boolean throwsException) {
		Result r=super.update(assetDepreciationOper , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param assetDepreciationOperList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetDepreciationOper> assetDepreciationOperList , SaveMode mode) {
		return super.updateList(assetDepreciationOperList , mode);
	}

	
	/**
	 * 按主键更新字段 折旧操作
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
	 * 按主键获取 折旧操作
	 *
	 * @param id 主键
	 * @return AssetDepreciationOper 数据对象
	 */
	public AssetDepreciationOper getById(String id) {
		AssetDepreciationOper sample = new AssetDepreciationOper();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	@Override
	public List<AssetDepreciationOper> getByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetDepreciationOper> queryList(AssetDepreciationOper sample) {
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
	public PagedList<AssetDepreciationOper> queryPagedList(AssetDepreciationOper sample, int pageSize, int pageIndex) {
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
	public PagedList<AssetDepreciationOper> queryPagedList(AssetDepreciationOper sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param assetDepreciationOper 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AssetDepreciationOper assetDepreciationOper) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(assetDepreciationOper, SYS_ROLE.NAME);
		//return exists;
		return false;
	}

	@Override
	public ExcelWriter exportExcel(AssetDepreciationOper sample) {
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
