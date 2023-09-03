package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_AUTO_TASK_LOG;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.AutoTaskLogMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 明细日志
 * <p>明细日志 , 数据表 ops_auto_task_log 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-02 18:13:23
 * @sign 28214DEF024BE9F8C42A648E1B1CD600
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_auto_task_log")
@ApiModel(description = "明细日志 ; 明细日志 , 数据表 ops_auto_task_log 的PO类型")
public class AutoTaskLog extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_AUTO_TASK_LOG.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "749696072762261504")
	private String id;
	
	/**
	 * 作业：作业
	*/
	@ApiModelProperty(required = false,value="作业" , notes = "作业" , example = "749696046161985536")
	private String taskId;
	
	/**
	 * 日志：日志
	*/
	@ApiModelProperty(required = false,value="日志" , notes = "日志" , example = "749696071613022208")
	private String mLogId;
	
	/**
	 * 动作：动作
	*/
	@ApiModelProperty(required = false,value="动作" , notes = "动作" , example = "614741291334369280")
	private String actionId;
	
	/**
	 * IP：IP
	*/
	@ApiModelProperty(required = false,value="IP" , notes = "IP" , example = "121.43.103.102")
	private String nodeIp;
	
	/**
	 * 节点：节点
	*/
	@ApiModelProperty(required = false,value="节点" , notes = "节点" , example = "749695855304376320")
	private String nodeId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "success")
	private String status;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间" , example = "2023-08-31 06:24:32")
	private Date stime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间" , example = "2023-08-31 06:24:33")
	private Date etime;
	
	/**
	 * 记录结果：记录结果
	*/
	@ApiModelProperty(required = false,value="记录结果" , notes = "记录结果" , example = "操作完成")
	private String recordContent;
	
	/**
	 * 内容明细：内容明细
	*/
	@ApiModelProperty(required = false,value="内容明细" , notes = "内容明细" , example = "success!  Thu Aug 31 18:24:33 CST 2023")
	private String contentDetail;
	
	/**
	 * 记录时间：记录时间
	*/
	@ApiModelProperty(required = false,value="记录时间" , notes = "记录时间" , example = "2023-08-31 06:24:32")
	private Date recordTime;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-08-31 06:24:33")
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "2")
	private Integer version;
	
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
	 * task：task
	*/
	@ApiModelProperty(required = false,value="task" , notes = "task")
	private AutoTask task;
	
	/**
	 * action：action
	*/
	@ApiModelProperty(required = false,value="action" , notes = "action")
	private AutoAction action;
	
	/**
	 * node：node
	*/
	@ApiModelProperty(required = false,value="node" , notes = "node")
	private AutoNode node;
	
	/**
	 * mLog：mLog
	*/
	@ApiModelProperty(required = false,value="mLog" , notes = "mLog")
	private AutoTaskMLog mLog;
	
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
	public AutoTaskLog setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 作业<br>
	 * 作业
	 * @return 作业
	*/
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 设置 作业
	 * @param taskId 作业
	 * @return 当前对象
	*/
	public AutoTaskLog setTaskId(String taskId) {
		this.taskId=taskId;
		return this;
	}
	
	/**
	 * 获得 日志<br>
	 * 日志
	 * @return 日志
	*/
	public String getMLogId() {
		return mLogId;
	}
	
	/**
	 * 设置 日志
	 * @param mLogId 日志
	 * @return 当前对象
	*/
	public AutoTaskLog setMLogId(String mLogId) {
		this.mLogId=mLogId;
		return this;
	}
	
	/**
	 * 获得 动作<br>
	 * 动作
	 * @return 动作
	*/
	public String getActionId() {
		return actionId;
	}
	
	/**
	 * 设置 动作
	 * @param actionId 动作
	 * @return 当前对象
	*/
	public AutoTaskLog setActionId(String actionId) {
		this.actionId=actionId;
		return this;
	}
	
	/**
	 * 获得 IP<br>
	 * IP
	 * @return IP
	*/
	public String getNodeIp() {
		return nodeIp;
	}
	
	/**
	 * 设置 IP
	 * @param nodeIp IP
	 * @return 当前对象
	*/
	public AutoTaskLog setNodeIp(String nodeIp) {
		this.nodeIp=nodeIp;
		return this;
	}
	
	/**
	 * 获得 节点<br>
	 * 节点
	 * @return 节点
	*/
	public String getNodeId() {
		return nodeId;
	}
	
	/**
	 * 设置 节点
	 * @param nodeId 节点
	 * @return 当前对象
	*/
	public AutoTaskLog setNodeId(String nodeId) {
		this.nodeId=nodeId;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public AutoTaskLog setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getStime() {
		return stime;
	}
	
	/**
	 * 设置 开始时间
	 * @param stime 开始时间
	 * @return 当前对象
	*/
	public AutoTaskLog setStime(Date stime) {
		this.stime=stime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getEtime() {
		return etime;
	}
	
	/**
	 * 设置 结束时间
	 * @param etime 结束时间
	 * @return 当前对象
	*/
	public AutoTaskLog setEtime(Date etime) {
		this.etime=etime;
		return this;
	}
	
	/**
	 * 获得 记录结果<br>
	 * 记录结果
	 * @return 记录结果
	*/
	public String getRecordContent() {
		return recordContent;
	}
	
	/**
	 * 设置 记录结果
	 * @param recordContent 记录结果
	 * @return 当前对象
	*/
	public AutoTaskLog setRecordContent(String recordContent) {
		this.recordContent=recordContent;
		return this;
	}
	
	/**
	 * 获得 内容明细<br>
	 * 内容明细
	 * @return 内容明细
	*/
	public String getContentDetail() {
		return contentDetail;
	}
	
	/**
	 * 设置 内容明细
	 * @param contentDetail 内容明细
	 * @return 当前对象
	*/
	public AutoTaskLog setContentDetail(String contentDetail) {
		this.contentDetail=contentDetail;
		return this;
	}
	
	/**
	 * 获得 记录时间<br>
	 * 记录时间
	 * @return 记录时间
	*/
	public Date getRecordTime() {
		return recordTime;
	}
	
	/**
	 * 设置 记录时间
	 * @param recordTime 记录时间
	 * @return 当前对象
	*/
	public AutoTaskLog setRecordTime(Date recordTime) {
		this.recordTime=recordTime;
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
	public AutoTaskLog setNotes(String notes) {
		this.notes=notes;
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
	public AutoTaskLog setUpdateBy(String updateBy) {
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
	public AutoTaskLog setUpdateTime(Date updateTime) {
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
	public AutoTaskLog setDeleted(Integer deleted) {
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
	public AutoTaskLog setDeleted(Boolean deletedBool) {
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
	public AutoTaskLog setDeleteBy(String deleteBy) {
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
	public AutoTaskLog setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public AutoTaskLog setVersion(Integer version) {
		this.version=version;
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
	public AutoTaskLog setCreateBy(String createBy) {
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
	public AutoTaskLog setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 task<br>
	 * task
	 * @return task
	*/
	public AutoTask getTask() {
		return task;
	}
	
	/**
	 * 设置 task
	 * @param task task
	 * @return 当前对象
	*/
	public AutoTaskLog setTask(AutoTask task) {
		this.task=task;
		return this;
	}
	
	/**
	 * 获得 action<br>
	 * action
	 * @return action
	*/
	public AutoAction getAction() {
		return action;
	}
	
	/**
	 * 设置 action
	 * @param action action
	 * @return 当前对象
	*/
	public AutoTaskLog setAction(AutoAction action) {
		this.action=action;
		return this;
	}
	
	/**
	 * 获得 node<br>
	 * node
	 * @return node
	*/
	public AutoNode getNode() {
		return node;
	}
	
	/**
	 * 设置 node
	 * @param node node
	 * @return 当前对象
	*/
	public AutoTaskLog setNode(AutoNode node) {
		this.node=node;
		return this;
	}
	
	/**
	 * 获得 mLog<br>
	 * mLog
	 * @return mLog
	*/
	public AutoTaskMLog getMLog() {
		return mLog;
	}
	
	/**
	 * 设置 mLog
	 * @param mLog mLog
	 * @return 当前对象
	*/
	public AutoTaskLog setMLog(AutoTaskMLog mLog) {
		this.mLog=mLog;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AutoTaskLog , 转换好的 AutoTaskLog 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AutoTaskLog , 转换好的 PoJo 对象
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
	public AutoTaskLog clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AutoTaskLog duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.AutoTaskLogMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.AutoTaskLogMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setNodeIp(this.getNodeIp());
		inst.setStime(this.getStime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setContentDetail(this.getContentDetail());
		inst.setVersion(this.getVersion());
		inst.setMLogId(this.getMLogId());
		inst.setCreateBy(this.getCreateBy());
		inst.setRecordTime(this.getRecordTime());
		inst.setDeleted(this.getDeleted());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCreateTime(this.getCreateTime());
		inst.setEtime(this.getEtime());
		inst.setActionId(this.getActionId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setNodeId(this.getNodeId());
		inst.setTaskId(this.getTaskId());
		inst.setStatus(this.getStatus());
		inst.setRecordContent(this.getRecordContent());
		if(all) {
			inst.setNode(this.getNode());
			inst.setTask(this.getTask());
			inst.setMLog(this.getMLog());
			inst.setAction(this.getAction());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AutoTaskLog clone(boolean deep) {
		return EntityContext.clone(AutoTaskLog.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AutoTaskLog
	 * @param autoTaskLogMap 包含实体信息的 Map 对象
	 * @return AutoTaskLog , 转换好的的 AutoTaskLog 对象
	*/
	@Transient
	public static AutoTaskLog createFrom(Map<String,Object> autoTaskLogMap) {
		if(autoTaskLogMap==null) return null;
		AutoTaskLog po = create();
		EntityContext.copyProperties(po,autoTaskLogMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AutoTaskLog
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AutoTaskLog , 转换好的的 AutoTaskLog 对象
	*/
	@Transient
	public static AutoTaskLog createFrom(Object pojo) {
		if(pojo==null) return null;
		AutoTaskLog po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AutoTaskLog，等同于 new
	 * @return AutoTaskLog 对象
	*/
	@Transient
	public static AutoTaskLog create() {
		return new com.dt.platform.domain.ops.meta.AutoTaskLogMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AutoTaskLogMeta.NOTES)));
			this.setNodeIp(DataParser.parse(String.class, map.get(AutoTaskLogMeta.NODE_IP)));
			this.setStime(DataParser.parse(Date.class, map.get(AutoTaskLogMeta.STIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AutoTaskLogMeta.UPDATE_TIME)));
			this.setContentDetail(DataParser.parse(String.class, map.get(AutoTaskLogMeta.CONTENT_DETAIL)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AutoTaskLogMeta.VERSION)));
			this.setMLogId(DataParser.parse(String.class, map.get(AutoTaskLogMeta.M_LOG_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AutoTaskLogMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, map.get(AutoTaskLogMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AutoTaskLogMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AutoTaskLogMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AutoTaskLogMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AutoTaskLogMeta.CREATE_TIME)));
			this.setEtime(DataParser.parse(Date.class, map.get(AutoTaskLogMeta.ETIME)));
			this.setActionId(DataParser.parse(String.class, map.get(AutoTaskLogMeta.ACTION_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AutoTaskLogMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AutoTaskLogMeta.ID)));
			this.setNodeId(DataParser.parse(String.class, map.get(AutoTaskLogMeta.NODE_ID)));
			this.setTaskId(DataParser.parse(String.class, map.get(AutoTaskLogMeta.TASK_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AutoTaskLogMeta.STATUS)));
			this.setRecordContent(DataParser.parse(String.class, map.get(AutoTaskLogMeta.RECORD_CONTENT)));
			// others
			this.setNode(DataParser.parse(AutoNode.class, map.get(AutoTaskLogMeta.NODE)));
			this.setTask(DataParser.parse(AutoTask.class, map.get(AutoTaskLogMeta.TASK)));
			this.setMLog(DataParser.parse(AutoTaskMLog.class, map.get(AutoTaskLogMeta.M_LOG)));
			this.setAction(DataParser.parse(AutoAction.class, map.get(AutoTaskLogMeta.ACTION)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AutoTaskLogMeta.NOTES));
				this.setNodeIp( (String)map.get(AutoTaskLogMeta.NODE_IP));
				this.setStime( (Date)map.get(AutoTaskLogMeta.STIME));
				this.setUpdateTime( (Date)map.get(AutoTaskLogMeta.UPDATE_TIME));
				this.setContentDetail( (String)map.get(AutoTaskLogMeta.CONTENT_DETAIL));
				this.setVersion( (Integer)map.get(AutoTaskLogMeta.VERSION));
				this.setMLogId( (String)map.get(AutoTaskLogMeta.M_LOG_ID));
				this.setCreateBy( (String)map.get(AutoTaskLogMeta.CREATE_BY));
				this.setRecordTime( (Date)map.get(AutoTaskLogMeta.RECORD_TIME));
				this.setDeleted( (Integer)map.get(AutoTaskLogMeta.DELETED));
				this.setUpdateBy( (String)map.get(AutoTaskLogMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AutoTaskLogMeta.DELETE_TIME));
				this.setCreateTime( (Date)map.get(AutoTaskLogMeta.CREATE_TIME));
				this.setEtime( (Date)map.get(AutoTaskLogMeta.ETIME));
				this.setActionId( (String)map.get(AutoTaskLogMeta.ACTION_ID));
				this.setDeleteBy( (String)map.get(AutoTaskLogMeta.DELETE_BY));
				this.setId( (String)map.get(AutoTaskLogMeta.ID));
				this.setNodeId( (String)map.get(AutoTaskLogMeta.NODE_ID));
				this.setTaskId( (String)map.get(AutoTaskLogMeta.TASK_ID));
				this.setStatus( (String)map.get(AutoTaskLogMeta.STATUS));
				this.setRecordContent( (String)map.get(AutoTaskLogMeta.RECORD_CONTENT));
				// others
				this.setNode( (AutoNode)map.get(AutoTaskLogMeta.NODE));
				this.setTask( (AutoTask)map.get(AutoTaskLogMeta.TASK));
				this.setMLog( (AutoTaskMLog)map.get(AutoTaskLogMeta.M_LOG));
				this.setAction( (AutoAction)map.get(AutoTaskLogMeta.ACTION));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AutoTaskLogMeta.NOTES)));
			this.setNodeIp(DataParser.parse(String.class, r.getValue(AutoTaskLogMeta.NODE_IP)));
			this.setStime(DataParser.parse(Date.class, r.getValue(AutoTaskLogMeta.STIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AutoTaskLogMeta.UPDATE_TIME)));
			this.setContentDetail(DataParser.parse(String.class, r.getValue(AutoTaskLogMeta.CONTENT_DETAIL)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AutoTaskLogMeta.VERSION)));
			this.setMLogId(DataParser.parse(String.class, r.getValue(AutoTaskLogMeta.M_LOG_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AutoTaskLogMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, r.getValue(AutoTaskLogMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AutoTaskLogMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AutoTaskLogMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AutoTaskLogMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AutoTaskLogMeta.CREATE_TIME)));
			this.setEtime(DataParser.parse(Date.class, r.getValue(AutoTaskLogMeta.ETIME)));
			this.setActionId(DataParser.parse(String.class, r.getValue(AutoTaskLogMeta.ACTION_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AutoTaskLogMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AutoTaskLogMeta.ID)));
			this.setNodeId(DataParser.parse(String.class, r.getValue(AutoTaskLogMeta.NODE_ID)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(AutoTaskLogMeta.TASK_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AutoTaskLogMeta.STATUS)));
			this.setRecordContent(DataParser.parse(String.class, r.getValue(AutoTaskLogMeta.RECORD_CONTENT)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AutoTaskLogMeta.NOTES));
				this.setNodeIp( (String)r.getValue(AutoTaskLogMeta.NODE_IP));
				this.setStime( (Date)r.getValue(AutoTaskLogMeta.STIME));
				this.setUpdateTime( (Date)r.getValue(AutoTaskLogMeta.UPDATE_TIME));
				this.setContentDetail( (String)r.getValue(AutoTaskLogMeta.CONTENT_DETAIL));
				this.setVersion( (Integer)r.getValue(AutoTaskLogMeta.VERSION));
				this.setMLogId( (String)r.getValue(AutoTaskLogMeta.M_LOG_ID));
				this.setCreateBy( (String)r.getValue(AutoTaskLogMeta.CREATE_BY));
				this.setRecordTime( (Date)r.getValue(AutoTaskLogMeta.RECORD_TIME));
				this.setDeleted( (Integer)r.getValue(AutoTaskLogMeta.DELETED));
				this.setUpdateBy( (String)r.getValue(AutoTaskLogMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AutoTaskLogMeta.DELETE_TIME));
				this.setCreateTime( (Date)r.getValue(AutoTaskLogMeta.CREATE_TIME));
				this.setEtime( (Date)r.getValue(AutoTaskLogMeta.ETIME));
				this.setActionId( (String)r.getValue(AutoTaskLogMeta.ACTION_ID));
				this.setDeleteBy( (String)r.getValue(AutoTaskLogMeta.DELETE_BY));
				this.setId( (String)r.getValue(AutoTaskLogMeta.ID));
				this.setNodeId( (String)r.getValue(AutoTaskLogMeta.NODE_ID));
				this.setTaskId( (String)r.getValue(AutoTaskLogMeta.TASK_ID));
				this.setStatus( (String)r.getValue(AutoTaskLogMeta.STATUS));
				this.setRecordContent( (String)r.getValue(AutoTaskLogMeta.RECORD_CONTENT));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}