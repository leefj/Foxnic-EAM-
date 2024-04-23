package com.dt.platform.eam.service.impl;

import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetStockGoodsInMeta;
import com.dt.platform.domain.eam.meta.AssetStockGoodsUseMeta;
import com.dt.platform.eam.service.*;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.api.error.CommonError;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.github.foxnic.web.framework.bpm.BpmEventAdaptor;
import org.github.foxnic.web.framework.bpm.BpmAssistant;
import com.github.foxnic.commons.log.Logger;
import javax.annotation.Resource;

import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;

import java.math.BigDecimal;
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

import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;
import com.dt.platform.eam.service.bpm.AssetStockGoodsUseBpmEventAdaptor;

/**
 * <p>
 * 库存领用服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-11-29 07:43:58
*/


@Service("EamAssetStockGoodsUseService")

public class AssetStockGoodsUseServiceImpl extends SuperService<AssetStockGoodsUse> implements IAssetStockGoodsUseService {

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
	 * @param assetStockGoodsUse  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(AssetStockGoodsUse assetStockGoodsUse,boolean throwsException) {
		String selectedCode=assetStockGoodsUse.getSelectedCode();
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
		}

		//制单人
		if(StringUtil.isBlank(assetStockGoodsUse.getOriginatorId())){
			assetStockGoodsUse.setOriginatorId(SessionUser.getCurrent().getUser().getActivatedEmployeeId());
		}

		//办理情况
		if(StringUtil.isBlank(assetStockGoodsUse.getStatus())){
			assetStockGoodsUse.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}



		//登记日期
		if(assetStockGoodsUse.getBusinessDate()==null){
			assetStockGoodsUse.setBusinessDate(new Date());
		}

		//编码
		String codeRule="";
		if(AssetStockGoodsTypeEnum.STOCK.code().equals(assetStockGoodsUse.getOwnerType())){
			codeRule= CodeModuleEnum.EAM_ASSET_STOCK_GOODS_OUT.code();
		}else if(AssetStockGoodsTypeEnum.CONSUMABLES.code().equals(assetStockGoodsUse.getOwnerType())){
			codeRule= CodeModuleEnum.EAM_ASSET_CONSUMABLES_GOODS_OUT.code();
		}else if(AssetStockGoodsTypeEnum.PART.code().equals(assetStockGoodsUse.getOwnerType())){
			codeRule= CodeModuleEnum.EAM_ASSET_PART_GOODS_OUT.code();
		}

		if(StringUtil.isBlank(assetStockGoodsUse.getBusinessCode())){
			if(!StringUtil.isBlank(codeRule)){
				if(!StringUtil.isBlank(codeRule)){
					Result codeResult= CodeModuleServiceProxy.api().generateCode(codeRule) ;
					if(!codeResult.isSuccess()){
						return codeResult;
					}else{
						assetStockGoodsUse.setBusinessCode(codeResult.getData().toString());
					}
				}
			}
		}
		Result r=super.insert(assetStockGoodsUse,throwsException);
		for(int i=0;i<list.size();i++){
			list.get(i).setBusinessCode(assetStockGoodsUse.getBusinessCode());
			list.get(i).setOwnerCode(assetStockGoodsUse.getOwnerType());
		}
		goodsStockService.saveOwnerData(assetStockGoodsUse.getId(),assetStockGoodsUse.getOwnerType(),list);
		return r;
	}


	@Override
	public Result operateResult(String id,String result,String status,String message) {
		if(AssetHandleConfirmOperationEnum.SUCCESS.code().equals(result)){
//			AssetStockGoodsUse data=this.getById(id);
//			System.out.println("data status"+data.getStatus());
//			if(status.equals(data.getStatus())){
//				//防止bpm 调用两次
//				return ErrorDesc.success();
//			}
			Result resRs=computeStockData(id);
			if(!resRs.isSuccess()){
				return resRs;
			}
			AssetStockGoodsUse bill=new AssetStockGoodsUse();
			bill.setId(id);
			bill.setStatus(status);
			this.dao.execute("update eam_goods_stock set status=? where owner_id=?",status,bill.getId());
			//后续需要加盘点

			return super.update(bill,SaveMode.NOT_NULL_FIELDS,false);
		}else if(AssetHandleConfirmOperationEnum.FAILED.code().equals(result)){
			return ErrorDesc.failureMessage(message);
		}else{
			return ErrorDesc.failureMessage("返回未知结果");
		}
	}

	@Override
	public Result computeStockData(String id){
		AssetStockGoodsUse bill=this.getById(id);
		this.dao().fill(bill)
				.with(AssetStockGoodsUseMeta.ASSET_STOCK_GOODS_LIST)
				.execute();
		String cUserId=SessionUser.getCurrent().getActivatedEmployeeId();
		String cUserName=SessionUser.getCurrent().getUser().getActivatedEmployeeName();
		//不进行判断，直接进行库存减
		List<GoodsStock> goods=bill.getAssetStockGoodsList();
		System.out.println("物品数量:"+goods.size());
		if(goods!=null&&goods.size()>0){
			System.out.println("开始扣库存");
			for(int i=0;i<goods.size();i++){
				String rid=goods.get(i).getRealStockId();
				String value=goods.get(i).getStockInNumber()+"";
				String sql="update eam_goods_stock set stock_cur_number=stock_cur_number-"+value+" where id=?";
				this.dao.execute(sql,rid);
				GoodsStockUsage goodsStockUsage=new GoodsStockUsage();
				goodsStockUsage.setOwnerId(rid);
				goodsStockUsage.setLabel("库存领用");
				goodsStockUsage.setOperUserId(cUserId);
				goodsStockUsage.setOperUserName(cUserName);
				goodsStockUsage.setRecTime(new Date());
				goodsStockUsage.setOper(AssetStockTypeEnum.USE.code());
				goodsStockUsage.setBillCode(bill.getBusinessCode());
				goodsStockUsage.setOperNumber(value);
				goodsStockUsage.setContent("领用完成");
				goodsStockUsageService.insert(goodsStockUsage,true);
			}
		}else{
			System.out.println("没有找到库存物品");
		}
		return ErrorDesc.success();
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param assetStockGoodsUse 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(AssetStockGoodsUse assetStockGoodsUse) {
		return this.insert(assetStockGoodsUse,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param assetStockGoodsUseList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetStockGoodsUse> assetStockGoodsUseList) {
		return super.insertList(assetStockGoodsUseList);
	}

	
	/**
	 * 按主键删除库存领用
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetStockGoodsUse assetStockGoodsUse = new AssetStockGoodsUse();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetStockGoodsUse.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetStockGoodsUse);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除库存领用
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetStockGoodsUse assetStockGoodsUse = new AssetStockGoodsUse();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetStockGoodsUse.setId(id);
		assetStockGoodsUse.setDeleted(true);
		assetStockGoodsUse.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetStockGoodsUse.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetStockGoodsUse,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetStockGoodsUse 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetStockGoodsUse assetStockGoodsUse , SaveMode mode) {
		return this.update(assetStockGoodsUse,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param assetStockGoodsUse 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(AssetStockGoodsUse assetStockGoodsUse , SaveMode mode,boolean throwsException) {
		AssetStockGoodsUse bill=getById(assetStockGoodsUse.getId());
		GoodsStock qE=new GoodsStock();
		qE.setOwnerTmpId(assetStockGoodsUse.getId());
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

		}
		Result r=super.update(assetStockGoodsUse , mode , throwsException);
		for(int i=0;i<list.size();i++){

			list.get(i).setBusinessCode(bill.getBusinessCode());
			list.get(i).setOwnerCode(assetStockGoodsUse.getOwnerType());
		}
		goodsStockService.saveOwnerData(assetStockGoodsUse.getId(),assetStockGoodsUse.getOwnerType(),list);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param assetStockGoodsUseList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetStockGoodsUse> assetStockGoodsUseList , SaveMode mode) {
		return super.updateList(assetStockGoodsUseList , mode);
	}

	
	/**
	 * 按主键更新库存领用
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
	 * 按主键获取库存领用
	 *
	 * @param id 主键
	 * @return AssetStockGoodsUse 数据对象
	 */
	public AssetStockGoodsUse getById(String id) {
		AssetStockGoodsUse sample = new AssetStockGoodsUse();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<AssetStockGoodsUse> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<AssetStockGoodsUse> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, AssetStockGoodsUse> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, AssetStockGoodsUse::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetStockGoodsUse> queryList(AssetStockGoodsUseVO sample) {
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
	public PagedList<AssetStockGoodsUse> queryPagedList(AssetStockGoodsUseVO sample, int pageSize, int pageIndex) {
		String dp= AssetOperateEnum.EAM_ASSET_STOCK_GOODS_USE.code();
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
	public PagedList<AssetStockGoodsUse> queryPagedList(AssetStockGoodsUse sample, ConditionExpr condition, int pageSize, int pageIndex) {

		String dp= AssetOperateEnum.EAM_ASSET_STOCK_GOODS_USE.code();
		return super.queryPagedList(sample, condition, pageSize, pageIndex,dp);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param assetStockGoodsUse 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AssetStockGoodsUse assetStockGoodsUse) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(assetStockGoodsUse, SYS_ROLE.NAME);
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




	/**
	 * 处理流程回调
	 * */
	public  BpmActionResult onProcessCallback(BpmEvent event) {
		try {
			if(event!=null&&event.getCurrentNode()!=null){
				System.out.println("onProcessCallback流程:"+event.getCurrentNode().getCamundaNodeId());
				System.out.println("event.getBillId:"+event.getBillId());
				if("END".equals(event.getCurrentNode().getCamundaNodeId())){
				}
			}
			if(event!=null&&event.getProcessInstance()!=null&&event.getProcessInstance().getTitle()!=null){
				dao.execute("update eam_asset_stock_goods_use set name=? where id=?",event.getProcessInstance().getTitle(),event.getBillId());
			}

			return(new AssetStockGoodsUseBpmEventAdaptor(this)).onProcessCallback(event);
		} catch (Throwable t) {
			Logger.exception("流程 "+event.getProcessInstance().getProcessDefinition().getName()+" , code = "+event.getProcessInstance().getProcessDefinition().getCode()+" , node = { name : "+event.getCurrentNode().getNodeName()+" , id : "+event.getCurrentNode().getCamundaNodeId()+"}  回调异常",t);
			BpmActionResult result = new BpmActionResult();
			result.success(false).code(CommonError.FAILURE).extra().setException(t);
			return result;
		}
	}

	@Override
	public void joinProcess(AssetStockGoodsUse assetStockGoodsUse) {
		this.joinProcess(Arrays.asList(assetStockGoodsUse));
	}

	@Override
	public void joinProcess(List<AssetStockGoodsUse> assetStockGoodsUseList) {
		BpmAssistant.joinProcess(assetStockGoodsUseList,IAssetStockGoodsUseService.FORM_DEFINITION_CODE);
	}

	@Override
	public void joinProcess(PagedList<AssetStockGoodsUse> assetStockGoodsUseList) {
		this.joinProcess(assetStockGoodsUseList.getList());
	}


}