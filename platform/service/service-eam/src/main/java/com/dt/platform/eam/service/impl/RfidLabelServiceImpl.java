package com.dt.platform.eam.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.eam.RfidStatusEnum;
import com.dt.platform.domain.eam.AssetProcessRecord;
import com.dt.platform.eam.service.IAssetProcessRecordService;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.sql.expr.Update;
import org.checkerframework.checker.units.qual.A;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.commons.collection.MapUtil;
import java.util.Arrays;


import com.dt.platform.domain.eam.RfidLabel;
import com.dt.platform.domain.eam.RfidLabelVO;
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
import com.dt.platform.eam.service.IRfidLabelService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * RFID标签服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-23 18:16:25
*/


@Service("EamRfidLabelService")

public class RfidLabelServiceImpl extends SuperService<RfidLabel> implements IRfidLabelService {

	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	@Autowired
	private IAssetProcessRecordService assetProcessRecordService;

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
	 * @param rfidLabel  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(RfidLabel rfidLabel,boolean throwsException) {
		Result r=super.insert(rfidLabel,throwsException);
		return r;
	}

	@Override
	public Result<JSONArray> read(String parms) {
		Result<JSONArray> res=new Result<>();
		JSONArray data=new JSONArray();
		res.success(true);
		res.data(data);
		return res;
	}

	@Override
	public Result release(String id) {
		RfidLabel rfidLabel=this.getById(id);
		if(RfidStatusEnum.SUCCESS.code().equals(rfidLabel.getStatus())){
			return ErrorDesc.failureMessage("已进行发卡，请误重复操作");
		}
		if(StringUtil.isBlank(rfidLabel.getLabel())){
			return ErrorDesc.failureMessage("资产标签为空");
		}
		if(StringUtil.isBlank(rfidLabel.getAssetId())){
			return ErrorDesc.failureMessage("资产为空");
		}

		rfidLabel.setStatus(RfidStatusEnum.SUCCESS.code());
		rfidLabel.setOperTime(new Date());
		rfidLabel.setOperResult("操作成功");
		rfidLabel.setOperUserId(SessionUser.getCurrent().getActivatedEmployeeId());
		Result r=super.update(rfidLabel,SaveMode.NOT_NULL_FIELDS,false);
		if(r.isSuccess()){
			Update ups=new Update("eam_asset");
			ups.set("rfid",rfidLabel.getLabel());
			ups.where().and("id=?",rfidLabel.getAssetId());
			dao.execute(ups);
			//记录
			AssetProcessRecord record=new AssetProcessRecord();
			record.setAssetId(rfidLabel.getAssetId());
			record.setContent("RFID发卡,RFID卡标签:"+rfidLabel.getLabel());
			String operUserId="sys_async";
			if(SessionUser.getCurrent()!=null){
				operUserId=SessionUser.getCurrent().getActivatedEmployeeId();
			}
			record.setProcessUserId(operUserId);
			record.setProcessdTime(new Date());
			record.setBusinessCode(rfidLabel.getId());
			record.setProcessType(AssetOperateEnum.RFID_RELEASE.code());
			assetProcessRecordService.insert(record);
		}
		return r;
	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param rfidLabel 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(RfidLabel rfidLabel) {
		return this.insert(rfidLabel,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param rfidLabelList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<RfidLabel> rfidLabelList) {
		return super.insertList(rfidLabelList);
	}

	
	/**
	 * 按主键删除RFID标签
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		RfidLabel rfidLabel = new RfidLabel();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		rfidLabel.setId(id);
		try {
			boolean suc = dao.deleteEntity(rfidLabel);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除RFID标签
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		RfidLabel rfidLabel = new RfidLabel();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		rfidLabel.setId(id);
		rfidLabel.setDeleted(true);
		rfidLabel.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		rfidLabel.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(rfidLabel,SaveMode.NOT_NULL_FIELDS);
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
	 * @param rfidLabel 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(RfidLabel rfidLabel , SaveMode mode) {
		return this.update(rfidLabel,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param rfidLabel 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(RfidLabel rfidLabel , SaveMode mode,boolean throwsException) {
		Result r=super.update(rfidLabel , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param rfidLabelList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<RfidLabel> rfidLabelList , SaveMode mode) {
		return super.updateList(rfidLabelList , mode);
	}

	
	/**
	 * 按主键更新RFID标签
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
	 * 按主键获取RFID标签
	 *
	 * @param id 主键
	 * @return RfidLabel 数据对象
	 */
	public RfidLabel getById(String id) {
		RfidLabel sample = new RfidLabel();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<RfidLabel> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<RfidLabel> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, RfidLabel> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, RfidLabel::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<RfidLabel> queryList(RfidLabelVO sample) {
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
	public PagedList<RfidLabel> queryPagedList(RfidLabelVO sample, int pageSize, int pageIndex) {
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
	public PagedList<RfidLabel> queryPagedList(RfidLabel sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param rfidLabel 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(RfidLabel rfidLabel) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(rfidLabel, SYS_ROLE.NAME);
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


	@Override
	public ExcelWriter exportExcel(RfidLabel sample) {
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
	@Override
	public ExcelStructure buildExcelStructure(boolean isForExport) {
		return super.buildExcelStructure(isForExport);
	}



}