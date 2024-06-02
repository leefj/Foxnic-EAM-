package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_MONITOR_ALERT_LOG;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.MonitorAlertLogMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 告警日志
 * <p>告警日志 , 数据表 ops_monitor_alert_log 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-01 23:36:27
 * @sign CCF23258E52C6A2E6181ABB5EC2E334E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_alert_log")
@ApiModel(description = "告警日志 ; 告警日志 , 数据表 ops_monitor_alert_log 的PO类型")
public class MonitorAlertLog extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_ALERT_LOG.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "12")
	private String id;
	
	/**
	 * 用户：用户
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "用户")
	private String userId;
	
	/**
	 * 通知方式：通知方式
	*/
	@ApiModelProperty(required = false,value="通知方式" , notes = "通知方式")
	private String alertMethod;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String msg;
	
	/**
	 * 记录时间：记录时间
	*/
	@ApiModelProperty(required = false,value="记录时间" , notes = "记录时间")
	private Date rcdTime;
	
	/**
	 * 通知结果：通知结果
	*/
	@ApiModelProperty(required = false,value="通知结果" , notes = "通知结果")
	private String actionResultStatus;
	
	/**
	 * 结果明细：结果明细
	*/
	@ApiModelProperty(required = false,value="结果明细" , notes = "结果明细")
	private String actionResult;
	
	/**
	 * 告警事件：告警事件
	*/
	@ApiModelProperty(required = false,value="告警事件" , notes = "告警事件")
	private String alertId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本" , example = "1")
	private Integer version;
	
	/**
	 * monitorAlertMethod：monitorAlertMethod
	*/
	@ApiModelProperty(required = false,value="monitorAlertMethod" , notes = "monitorAlertMethod")
	private MonitorAlertMethod monitorAlertMethod;
	
	/**
	 * sendUser：sendUser
	*/
	@ApiModelProperty(required = false,value="sendUser" , notes = "sendUser")
	private Employee sendUser;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public MonitorAlertLog setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 用户<br>
	 * 用户
	 * @return 用户
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 用户
	 * @param userId 用户
	 * @return 当前对象
	*/
	public MonitorAlertLog setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 通知方式<br>
	 * 通知方式
	 * @return 通知方式
	*/
	public String getAlertMethod() {
		return alertMethod;
	}
	
	/**
	 * 设置 通知方式
	 * @param alertMethod 通知方式
	 * @return 当前对象
	*/
	public MonitorAlertLog setAlertMethod(String alertMethod) {
		this.alertMethod=alertMethod;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getMsg() {
		return msg;
	}
	
	/**
	 * 设置 内容
	 * @param msg 内容
	 * @return 当前对象
	*/
	public MonitorAlertLog setMsg(String msg) {
		this.msg=msg;
		return this;
	}
	
	/**
	 * 获得 记录时间<br>
	 * 记录时间
	 * @return 记录时间
	*/
	public Date getRcdTime() {
		return rcdTime;
	}
	
	/**
	 * 设置 记录时间
	 * @param rcdTime 记录时间
	 * @return 当前对象
	*/
	public MonitorAlertLog setRcdTime(Date rcdTime) {
		this.rcdTime=rcdTime;
		return this;
	}
	
	/**
	 * 获得 通知结果<br>
	 * 通知结果
	 * @return 通知结果
	*/
	public String getActionResultStatus() {
		return actionResultStatus;
	}
	
	/**
	 * 设置 通知结果
	 * @param actionResultStatus 通知结果
	 * @return 当前对象
	*/
	public MonitorAlertLog setActionResultStatus(String actionResultStatus) {
		this.actionResultStatus=actionResultStatus;
		return this;
	}
	
	/**
	 * 获得 结果明细<br>
	 * 结果明细
	 * @return 结果明细
	*/
	public String getActionResult() {
		return actionResult;
	}
	
	/**
	 * 设置 结果明细
	 * @param actionResult 结果明细
	 * @return 当前对象
	*/
	public MonitorAlertLog setActionResult(String actionResult) {
		this.actionResult=actionResult;
		return this;
	}
	
	/**
	 * 获得 告警事件<br>
	 * 告警事件
	 * @return 告警事件
	*/
	public String getAlertId() {
		return alertId;
	}
	
	/**
	 * 设置 告警事件
	 * @param alertId 告警事件
	 * @return 当前对象
	*/
	public MonitorAlertLog setAlertId(String alertId) {
		this.alertId=alertId;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public MonitorAlertLog setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public MonitorAlertLog setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public MonitorAlertLog setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public MonitorAlertLog setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public MonitorAlertLog setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	@JsonProperty("deleted")
	public MonitorAlertLog setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public MonitorAlertLog setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public MonitorAlertLog setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public MonitorAlertLog setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 版本
	 * @param version 版本
	 * @return 当前对象
	*/
	public MonitorAlertLog setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 monitorAlertMethod<br>
	 * monitorAlertMethod
	 * @return monitorAlertMethod
	*/
	public MonitorAlertMethod getMonitorAlertMethod() {
		return monitorAlertMethod;
	}
	
	/**
	 * 设置 monitorAlertMethod
	 * @param monitorAlertMethod monitorAlertMethod
	 * @return 当前对象
	*/
	public MonitorAlertLog setMonitorAlertMethod(MonitorAlertMethod monitorAlertMethod) {
		this.monitorAlertMethod=monitorAlertMethod;
		return this;
	}
	
	/**
	 * 获得 sendUser<br>
	 * sendUser
	 * @return sendUser
	*/
	public Employee getSendUser() {
		return sendUser;
	}
	
	/**
	 * 设置 sendUser
	 * @param sendUser sendUser
	 * @return 当前对象
	*/
	public MonitorAlertLog setSendUser(Employee sendUser) {
		this.sendUser=sendUser;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorAlertLog , 转换好的 MonitorAlertLog 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorAlertLog , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MonitorAlertLog clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MonitorAlertLog duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.MonitorAlertLogMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.MonitorAlertLogMeta.$$proxy$$();
		inst.setMsg(this.getMsg());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setActionResult(this.getActionResult());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setActionResultStatus(this.getActionResultStatus());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setAlertMethod(this.getAlertMethod());
		inst.setAlertId(this.getAlertId());
		inst.setRcdTime(this.getRcdTime());
		if(all) {
			inst.setMonitorAlertMethod(this.getMonitorAlertMethod());
			inst.setSendUser(this.getSendUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MonitorAlertLog clone(boolean deep) {
		return EntityContext.clone(MonitorAlertLog.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MonitorAlertLog
	 * @param monitorAlertLogMap 包含实体信息的 Map 对象
	 * @return MonitorAlertLog , 转换好的的 MonitorAlertLog 对象
	*/
	@Transient
	public static MonitorAlertLog createFrom(Map<String,Object> monitorAlertLogMap) {
		if(monitorAlertLogMap==null) return null;
		MonitorAlertLog po = create();
		EntityContext.copyProperties(po,monitorAlertLogMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorAlertLog
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorAlertLog , 转换好的的 MonitorAlertLog 对象
	*/
	@Transient
	public static MonitorAlertLog createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorAlertLog po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 MonitorAlertLog，等同于 new
	 * @return MonitorAlertLog 对象
	*/
	@Transient
	public static MonitorAlertLog create() {
		return new com.dt.platform.domain.ops.meta.MonitorAlertLogMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setMsg(DataParser.parse(String.class, map.get(MonitorAlertLogMeta.MSG)));
			this.setNotes(DataParser.parse(String.class, map.get(MonitorAlertLogMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MonitorAlertLogMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(MonitorAlertLogMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MonitorAlertLogMeta.VERSION)));
			this.setActionResult(DataParser.parse(String.class, map.get(MonitorAlertLogMeta.ACTION_RESULT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MonitorAlertLogMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MonitorAlertLogMeta.DELETED)));
			this.setActionResultStatus(DataParser.parse(String.class, map.get(MonitorAlertLogMeta.ACTION_RESULT_STATUS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MonitorAlertLogMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MonitorAlertLogMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MonitorAlertLogMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MonitorAlertLogMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(MonitorAlertLogMeta.ID)));
			this.setAlertMethod(DataParser.parse(String.class, map.get(MonitorAlertLogMeta.ALERT_METHOD)));
			this.setAlertId(DataParser.parse(String.class, map.get(MonitorAlertLogMeta.ALERT_ID)));
			this.setRcdTime(DataParser.parse(Date.class, map.get(MonitorAlertLogMeta.RCD_TIME)));
			// others
			this.setMonitorAlertMethod(DataParser.parse(MonitorAlertMethod.class, map.get(MonitorAlertLogMeta.MONITOR_ALERT_METHOD)));
			this.setSendUser(DataParser.parse(Employee.class, map.get(MonitorAlertLogMeta.SEND_USER)));
			return true;
		} else {
			try {
				this.setMsg( (String)map.get(MonitorAlertLogMeta.MSG));
				this.setNotes( (String)map.get(MonitorAlertLogMeta.NOTES));
				this.setUpdateTime( (Date)map.get(MonitorAlertLogMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(MonitorAlertLogMeta.USER_ID));
				this.setVersion( (Integer)map.get(MonitorAlertLogMeta.VERSION));
				this.setActionResult( (String)map.get(MonitorAlertLogMeta.ACTION_RESULT));
				this.setCreateBy( (String)map.get(MonitorAlertLogMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MonitorAlertLogMeta.DELETED));
				this.setActionResultStatus( (String)map.get(MonitorAlertLogMeta.ACTION_RESULT_STATUS));
				this.setCreateTime( (Date)map.get(MonitorAlertLogMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(MonitorAlertLogMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(MonitorAlertLogMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(MonitorAlertLogMeta.DELETE_BY));
				this.setId( (String)map.get(MonitorAlertLogMeta.ID));
				this.setAlertMethod( (String)map.get(MonitorAlertLogMeta.ALERT_METHOD));
				this.setAlertId( (String)map.get(MonitorAlertLogMeta.ALERT_ID));
				this.setRcdTime( (Date)map.get(MonitorAlertLogMeta.RCD_TIME));
				// others
				this.setMonitorAlertMethod( (MonitorAlertMethod)map.get(MonitorAlertLogMeta.MONITOR_ALERT_METHOD));
				this.setSendUser( (Employee)map.get(MonitorAlertLogMeta.SEND_USER));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setMsg(DataParser.parse(String.class, r.getValue(MonitorAlertLogMeta.MSG)));
			this.setNotes(DataParser.parse(String.class, r.getValue(MonitorAlertLogMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MonitorAlertLogMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(MonitorAlertLogMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MonitorAlertLogMeta.VERSION)));
			this.setActionResult(DataParser.parse(String.class, r.getValue(MonitorAlertLogMeta.ACTION_RESULT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MonitorAlertLogMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MonitorAlertLogMeta.DELETED)));
			this.setActionResultStatus(DataParser.parse(String.class, r.getValue(MonitorAlertLogMeta.ACTION_RESULT_STATUS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MonitorAlertLogMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MonitorAlertLogMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MonitorAlertLogMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MonitorAlertLogMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(MonitorAlertLogMeta.ID)));
			this.setAlertMethod(DataParser.parse(String.class, r.getValue(MonitorAlertLogMeta.ALERT_METHOD)));
			this.setAlertId(DataParser.parse(String.class, r.getValue(MonitorAlertLogMeta.ALERT_ID)));
			this.setRcdTime(DataParser.parse(Date.class, r.getValue(MonitorAlertLogMeta.RCD_TIME)));
			return true;
		} else {
			try {
				this.setMsg( (String)r.getValue(MonitorAlertLogMeta.MSG));
				this.setNotes( (String)r.getValue(MonitorAlertLogMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(MonitorAlertLogMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(MonitorAlertLogMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(MonitorAlertLogMeta.VERSION));
				this.setActionResult( (String)r.getValue(MonitorAlertLogMeta.ACTION_RESULT));
				this.setCreateBy( (String)r.getValue(MonitorAlertLogMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MonitorAlertLogMeta.DELETED));
				this.setActionResultStatus( (String)r.getValue(MonitorAlertLogMeta.ACTION_RESULT_STATUS));
				this.setCreateTime( (Date)r.getValue(MonitorAlertLogMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(MonitorAlertLogMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(MonitorAlertLogMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(MonitorAlertLogMeta.DELETE_BY));
				this.setId( (String)r.getValue(MonitorAlertLogMeta.ID));
				this.setAlertMethod( (String)r.getValue(MonitorAlertLogMeta.ALERT_METHOD));
				this.setAlertId( (String)r.getValue(MonitorAlertLogMeta.ALERT_ID));
				this.setRcdTime( (Date)r.getValue(MonitorAlertLogMeta.RCD_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}