package com.dt.platform.eam.service.impl;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.common.YesNoEnum;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.eam.AssetOwnerCodeEnum;
import com.dt.platform.constants.enums.eam.AssetStatusEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetHandleMeta;
import com.dt.platform.domain.eam.meta.AssetScrapMeta;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;
import com.dt.platform.eam.service.bpm.AssetHandleBpmEventAdaptor;

/**
 * <p>
 * 资产处置服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-30 12:55:52
*/


@Service("EamAssetHandleService")

public class AssetHandleServiceImpl extends SuperService<AssetHandle> implements IAssetHandleService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	@Autowired
	private AssetItemServiceImpl assetItemService;

	@Autowired
	private IAssetSelectedDataService assetSelectedDataService;

	@Autowired
	private IOperateService operateService;

	@Autowired
	private IAssetService assetService;
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

	/**
     * AssetItemServiceImpl
     */

	@Autowired
	private IAssetProcessRecordService assetProcessRecordService;


	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param assetHandle  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	@Transactional
	public Result insert(AssetHandle assetHandle,boolean throwsException) {


		if(assetHandle.getAssetIds()==null||assetHandle.getAssetIds().size()==0){
			String assetSelectedCode=assetHandle.getSelectedCode();
			ConditionExpr condition=new ConditionExpr();
			condition.andIn("asset_selected_code",assetSelectedCode==null?"":assetSelectedCode);
			List<String> list=assetSelectedDataService.queryValues(EAMTables.EAM_ASSET_SELECTED_DATA.ASSET_ID,String.class,condition);
			assetHandle.setAssetIds(list);
		}

		//校验数据资产
		if(assetHandle.getAssetIds().size()==0){
			return ErrorDesc.failure().message("请选择资产");
		}


		Result ckResult=assetService.checkAssetDataForBusinessAction(AssetOperateEnum.EAM_ASSET_HANDLE.code(),assetHandle.getAssetIds());
		if(!ckResult.isSuccess()){
			return ckResult;
		}

		//办理状态
		if(StringUtil.isBlank(assetHandle.getStatus())){
			assetHandle.setStatus(AssetHandleStatusEnum.INCOMPLETE.code());
		}

		//生成编码规则
		if(StringUtil.isBlank(assetHandle.getBusinessCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(AssetOperateEnum.EAM_ASSET_HANDLE.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				assetHandle.setBusinessCode(codeResult.getData().toString());
			}
		}

		Result r=super.insert(assetHandle,throwsException);
		if (r.isSuccess()){
			//保存资产数据
			List<AssetItem> saveList=new ArrayList<AssetItem>();
			for(int i=0;i<assetHandle.getAssetIds().size();i++){
				AssetItem asset=new AssetItem();
				asset.setId(IDGenerator.getSnowflakeIdString());
				asset.setHandleId(assetHandle.getId());
				asset.setAssetId(assetHandle.getAssetIds().get(i));
				saveList.add(asset);
			}
			Result batchInsertReuslt= assetItemService.insertList(saveList);
			if(!batchInsertReuslt.isSuccess()){
				return batchInsertReuslt;
			}
		}
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param assetHandle 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	@Transactional
	public Result insert(AssetHandle assetHandle) {
		return this.insert(assetHandle,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param assetHandleList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<AssetHandle> assetHandleList) {
		return super.insertList(assetHandleList);
	}

	
	/**
	 * 按主键删除资产处置
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		AssetHandle assetHandle = new AssetHandle();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetHandle.setId(id);
		try {
			boolean suc = dao.deleteEntity(assetHandle);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除资产处置
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		AssetHandle assetHandle = new AssetHandle();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		assetHandle.setId(id);
		assetHandle.setDeleted(true);
		assetHandle.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		assetHandle.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(assetHandle,SaveMode.NOT_NULL_FIELDS);
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
	 * @param assetHandle 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(AssetHandle assetHandle , SaveMode mode) {
		return this.update(assetHandle,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param assetHandle 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	@Transactional
	public Result update(AssetHandle assetHandle , SaveMode mode,boolean throwsException) {
		Result verifyResult=verifyBillData(assetHandle.getId());
		if(!verifyResult.isSuccess())return verifyResult;
		Result r=super.update(assetHandle , mode , throwsException);
		if(r.success()){
			//保存表单数据
			dao.execute("update eam_asset_item set crd='r' where crd='c' and handle_id=?",assetHandle.getId());
			dao.execute("delete from eam_asset_item where crd ='d'  and  handle_id=?",assetHandle.getId());
		}
		return r;
	}

	private Result verifyBillData(String id){
		ConditionExpr itemRecordCondition=new ConditionExpr();
		itemRecordCondition.andIn("handle_id",id);
		itemRecordCondition.andIn("crd","c","r");
		List<String> ckDatalist=assetItemService.queryValues(EAMTables.EAM_ASSET_ITEM.ASSET_ID,String.class,itemRecordCondition);
		if(ckDatalist.size()==0){
			return ErrorDesc.failure().message("请选择资产");
		}
		return assetService.checkAssetDataForBusinessAction(CodeModuleEnum.EAM_ASSET_HANDLE.code(),ckDatalist);
	}

	/**
	 * 更新实体集，事务内
	 * @param assetHandleList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<AssetHandle> assetHandleList , SaveMode mode) {
		return super.updateList(assetHandleList , mode);
	}

	
	/**
	 * 按主键更新资产处置
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
	 * 按主键获取资产处置
	 *
	 * @param id 主键
	 * @return AssetHandle 数据对象
	 */
	public AssetHandle getById(String id) {
		AssetHandle sample = new AssetHandle();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<AssetHandle> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<AssetHandle> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, AssetHandle> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, AssetHandle::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<AssetHandle> queryList(AssetHandleVO sample) {
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
	public PagedList<AssetHandle> queryPagedList(AssetHandleVO sample, int pageSize, int pageIndex) {
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
	public PagedList<AssetHandle> queryPagedList(AssetHandle sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param assetHandle 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(AssetHandle assetHandle) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(assetHandle, SYS_ROLE.NAME);
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
			if("END".equals(event.getNodeId())){
				String billId=event.getBillId();
				AssetHandle assetHandle= this.getById(billId);
				this.dao().fill(assetHandle)
						.with(AssetHandleMeta.ASSET_HANDLE_TYPE)
						.with(AssetHandleMeta.ASSET_LIST)
						.execute();

				AssetHandleType handleType=assetHandle.getAssetHandleType();
				String cleanValue=AssetOwnerCodeEnum.ASSET_CLEAN_OUT.code();
				String rcdStr="";
				if(YesNoEnum.YES.code().equals(handleType.getCleanStatus())){
					cleanValue=AssetOwnerCodeEnum.ASSET_CLEAN_OUT.code();
					rcdStr=",同时完成清理";
				}else{
					cleanValue=AssetOwnerCodeEnum.ASSET.code();
				}
				this.dao().execute("update eam_asset_handle set status=? where id=?", AssetHandleStatusEnum.COMPLETE.code(),billId);
				this.dao().execute("update eam_asset_item a,eam_asset b set b.clean_time=now(),b.clean_out_type=?,b.handle_id=?,b.owner_code=?,asset_status=? where a.asset_id=b.id and a.deleted=0 and a.handle_id=? and a.crd in ('r','d')",AssetOperateEnum.EAM_ASSET_HANDLE.code(),billId,cleanValue,handleType.getHandleStatus(),billId);
				List<Asset> list=assetHandle.getAssetList();
				for (Asset asset : list) {
					AssetProcessRecord rcd=new AssetProcessRecord();
					rcd.setAssetId(asset.getId());
					rcd.setProcessType(AssetOperateEnum.EAM_ASSET_HANDLE.code());
					rcd.setProcessdTime(new Date());
					rcd.setContent("资产完成处置"+rcdStr);
					rcd.setBusinessCode(assetHandle.getBusinessCode());
					rcd.setProcessUserId(assetHandle.getOriginatorId());
					assetProcessRecordService.insert(rcd,false);
				}
			}
			if(event!=null&&event.getProcessInstance()!=null&&event.getProcessInstance().getTitle()!=null){
				dao.execute("update eam_asset_handle set name=? where id=?",event.getProcessInstance().getTitle(),event.getBillId());
			}
			return(new AssetHandleBpmEventAdaptor(this)).onProcessCallback(event);
		} catch (Throwable t) {
			Logger.exception("流程 "+event.getProcessInstance().getProcessDefinition().getName()+" , code = "+event.getProcessInstance().getProcessDefinition().getCode()+" , node = { name : "+event.getCurrentNode().getNodeName()+" , id : "+event.getCurrentNode().getCamundaNodeId()+"}  回调异常",t);
			BpmActionResult result = new BpmActionResult();
			result.success(false).code(CommonError.FAILURE).extra().setException(t);
			return result;
		}
	}

	@Override
	public void joinProcess(AssetHandle assetHandle) {
		this.joinProcess(Arrays.asList(assetHandle));
	}

	@Override
	public void joinProcess(List<AssetHandle> assetHandleList) {
		BpmAssistant.joinProcess(assetHandleList,IAssetHandleService.FORM_DEFINITION_CODE);
	}

	@Override
	public void joinProcess(PagedList<AssetHandle> assetHandleList) {
		this.joinProcess(assetHandleList.getList());
	}


}