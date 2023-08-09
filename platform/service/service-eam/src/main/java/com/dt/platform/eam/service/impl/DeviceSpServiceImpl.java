package com.dt.platform.eam.service.impl;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.constants.enums.eam.DeviceSpStatusEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.eam.service.IDeviceSpRcdService;
import com.dt.platform.eam.service.IGoodsStockService;
import com.dt.platform.eam.service.IRepairOrderActSpService;
import com.dt.platform.proxy.common.CodeModuleServiceProxy;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.sql.expr.SQL;
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
import com.dt.platform.eam.service.IDeviceSpService;
import org.github.foxnic.web.framework.dao.DBConfigs;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 备件清单服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-15 10:59:13
*/


@Service("EamDeviceSpService")

public class DeviceSpServiceImpl extends SuperService<DeviceSp> implements IDeviceSpService {

	@Autowired
	private IRepairOrderActSpService repairOrderActSpService;

	@Autowired
	private IDeviceSpService deviceSpService;

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
	private IDeviceSpRcdService deviceSpRcdService;



	@Override
	public Object generateId(Field field) {
		return IDGenerator.getSnowflakeIdString();
	}

	/**
	 * 添加，根据 throwsException 参数抛出异常或返回 Result 对象
	 *
	 * @param deviceSp  数据对象
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 结果 , 如果失败返回 false，成功返回 true
	 */
	@Override
	public Result insert(DeviceSp deviceSp,boolean throwsException) {
		//生成编码规则
		//编码
		deviceSp.setLocked("N");
		deviceSp.setStatus(DeviceSpStatusEnum.DRAFT.code());

		if(StringUtil.isBlank(deviceSp.getCode())){
			Result codeResult= CodeModuleServiceProxy.api().generateCode(CodeModuleEnum.COMMON_CODE.code());
			if(!codeResult.isSuccess()){
				return codeResult;
			}else{
				deviceSp.setCode(codeResult.getData().toString());
			}
		}

		Result r=super.insert(deviceSp,throwsException);

		return r;
	}


	@Override
	public Result saveByIds(String ownerId,String ownerType, String ids, String selectedCode) {


		if(StringUtil.isBlank(ids)){
			return ErrorDesc.failureMessage("ids 参数为空");
		}
		JSONArray idsArr=JSONArray.parseArray(ids);
		if(idsArr==null||idsArr.size()==0){
			return ErrorDesc.failureMessage("ids 参数为空");
		}
		if("eam_repair_act_sp".equals(ownerType)){
			for(int i=0;i<idsArr.size();i++){
				String id=idsArr.getString(i);
				DeviceSp sp=deviceSpService.getById(id);
				RepairOrderActSp actSp=new RepairOrderActSp();
				actSp.setSelectedCode(selectedCode);
				actSp.setActId(ownerId);
				actSp.setSpId(id);
				actSp.setSpSn(sp.getSn());
				actSp.setSpCode(sp.getCode());
				actSp.setSpName(sp.getName());
				actSp.setSpNotes(sp.getNotes());
				repairOrderActSpService.insert(actSp,true);
			}
		}else{
			return ErrorDesc.failureMessage("ownerType参数为空");
		}

		return ErrorDesc.success();
	}

	@Override
	public PagedList<DeviceSp> querySelectedPagedList(DeviceSpVO sample) {
		return null;
	}

	@Override
	public PagedList<DeviceSp> querySelectPagedList(DeviceSpVO sample) {

		String ownerId=sample.getOwnerId();
		String selectedCode=sample.getSelectedCode();
		String ownerType= sample.getOwnerType();
		sample.setOwnerId(null);
		sample.setOwnerType(null);
		sample.setSelectedCode(null);
		ConditionExpr expr=new ConditionExpr();

		if("eam_repair_act_sp".equals(ownerType)){
			expr.and("id not in (select sp_id from eam_repair_order_act_sp where deleted=0 and act_id=? and selected_code=?)",ownerId,selectedCode);
			expr.and("status in ('not_use') ");
		}else{
			expr.and( "1=1");
		}
		return super.queryPagedList(sample,expr,sample.getPageSize(),sample.getPageIndex());
	}

	@Override
	public Result batchSure(String ids) {

		String operUserId= SessionUser.getCurrent().getActivatedEmployeeId();
		if(StringUtil.isBlank(ids)){
			return ErrorDesc.failureMessage("ids不能为空");
		}
		JSONArray arr=JSONArray.parseArray(ids);
		if(arr==null||arr.size()==0){
			return ErrorDesc.failureMessage("ids不能为空");
		}
		List<DeviceSpRcd> rcdList=new ArrayList<>();
		List<SQL> sqlList=new ArrayList<>();
		for(int i=0;i<arr.size();i++){
			String spId=arr.getString(i);
			Rcd rs=dao.queryRecord("select * from eam_device_sp where id=? and status='draft'",spId);
			if(rs==null){
				return ErrorDesc.failureMessage("当前Id:"+spId+",状态不是草稿状态,不能进行确认操作");
			}
			Update ups=new Update("eam_device_sp");
			ups.set("status",DeviceSpStatusEnum.NOT_USE.code());
			ups.where().and("id=?",spId);
			sqlList.add(ups);

			DeviceSpRcd rcd=new DeviceSpRcd();
			rcd.setSpId(spId);
			rcd.setOperId(operUserId);
			rcd.setOperTime(new Date());
			rcd.setContent("当前确认资产入库");
			rcd.setSpCode(rs.getString("code"));
			rcdList.add(rcd);

		}

		dao.batchExecute(sqlList);
		deviceSpRcdService.insertList(rcdList);
		return ErrorDesc.success();

	}

	/**
	 * 添加，如果语句错误，则抛出异常
	 * @param deviceSp 数据对象
	 * @return 插入是否成功
	 * */
	@Override
	public Result insert(DeviceSp deviceSp) {
		return this.insert(deviceSp,true);
	}

	/**
	 * 批量插入实体，事务内
	 * @param deviceSpList 实体数据清单
	 * @return 插入是否成功
	 * */
	@Override
	public Result insertList(List<DeviceSp> deviceSpList) {
		return super.insertList(deviceSpList);
	}

	
	/**
	 * 按主键删除备件清单
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdPhysical(String id) {
		DeviceSp deviceSp = new DeviceSp();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		deviceSp.setId(id);
		try {
			boolean suc = dao.deleteEntity(deviceSp);
			return suc?ErrorDesc.success():ErrorDesc.failure();
		}
		catch(Exception e) {
			Result r= ErrorDesc.failure();
			r.extra().setException(e);
			return r;
		}
	}
	
	/**
	 * 按主键删除备件清单
	 *
	 * @param id 主键
	 * @return 删除是否成功
	 */
	public Result deleteByIdLogical(String id) {
		DeviceSp deviceSp = new DeviceSp();
		if(id==null) return ErrorDesc.failure().message("id 不允许为 null 。");
		deviceSp.setId(id);
		deviceSp.setDeleted(true);
		deviceSp.setDeleteBy((String)dao.getDBTreaty().getLoginUserId());
		deviceSp.setDeleteTime(new Date());
		try {
			boolean suc = dao.updateEntity(deviceSp,SaveMode.NOT_NULL_FIELDS);
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
	 * @param deviceSp 数据对象
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(DeviceSp deviceSp , SaveMode mode) {
		return this.update(deviceSp,mode,true);
	}

	/**
	 * 更新，根据 throwsException 参数抛出异常或返回 Result 对象
	 * @param deviceSp 数据对象
	 * @param mode 保存模式
	 * @param throwsException 是否抛出异常，如果不抛出异常，则返回一个失败的 Result 对象
	 * @return 保存是否成功
	 * */
	@Override
	public Result update(DeviceSp deviceSp , SaveMode mode,boolean throwsException) {
		Result r=super.update(deviceSp , mode , throwsException);
		return r;
	}

	/**
	 * 更新实体集，事务内
	 * @param deviceSpList 数据对象列表
	 * @param mode 保存模式
	 * @return 保存是否成功
	 * */
	@Override
	public Result updateList(List<DeviceSp> deviceSpList , SaveMode mode) {
		return super.updateList(deviceSpList , mode);
	}

	
	/**
	 * 按主键更新备件清单
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
	 * 按主键获取备件清单
	 *
	 * @param id 主键
	 * @return DeviceSp 数据对象
	 */
	public DeviceSp getById(String id) {
		DeviceSp sample = new DeviceSp();
		if(id==null) throw new IllegalArgumentException("id 不允许为 null ");
		sample.setId(id);
		return dao.queryEntity(sample);
	}

	/**
	 * 等价于 queryListByIds
	 * */
	@Override
	public List<DeviceSp> getByIds(List<String> ids) {
		return this.queryListByIds(ids);
	}

	@Override
	public List<DeviceSp> queryListByIds(List<String> ids) {
		return super.queryListByUKeys("id",ids);
	}

	@Override
	public Map<String, DeviceSp> queryMapByIds(List<String> ids) {
		return super.queryMapByUKeys("id",ids, DeviceSp::getId);
	}



	/**
	 * 查询实体集合，默认情况下，字符串使用模糊匹配，非字符串使用精确匹配
	 *
	 * @param sample  查询条件
	 * @return 查询结果
	 * */
	@Override
	public List<DeviceSp> queryList(DeviceSpVO sample) {
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
	public PagedList<DeviceSp> queryPagedList(DeviceSpVO sample, int pageSize, int pageIndex) {
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
	public PagedList<DeviceSp> queryPagedList(DeviceSp sample, ConditionExpr condition, int pageSize, int pageIndex) {
		return super.queryPagedList(sample, condition, pageSize, pageIndex);
	}

	/**
	 * 检查 实体 是否已经存在 , 判断 主键值不同，但指定字段的值相同的记录是否存在
	 *
	 * @param deviceSp 数据对象
	 * @return 判断结果
	 */
	public Boolean checkExists(DeviceSp deviceSp) {
		//TDOD 此处添加判断段的代码
		//boolean exists=super.checkExists(deviceSp, SYS_ROLE.NAME);
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