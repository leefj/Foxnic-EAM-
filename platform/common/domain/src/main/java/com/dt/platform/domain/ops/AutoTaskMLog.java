package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_AUTO_TASK_M_LOG;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.AutoTaskMLogMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 执行日志
 * <p>执行日志 , 数据表 ops_auto_task_m_log 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-02 16:05:42
 * @sign BDDCD47B78AD2990D452CBA1619FFAEF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_auto_task_m_log")
@ApiModel(description = "执行日志 ; 执行日志 , 数据表 ops_auto_task_m_log 的PO类型")
public class AutoTaskMLog extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_AUTO_TASK_M_LOG.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "749696071613022208")
	private String id;
	
	/**
	 * 作业：作业
	*/
	@ApiModelProperty(required = false,value="作业" , notes = "作业" , example = "749696046161985536")
	private String taskId;
	
	/**
	 * 动作：动作
	*/
	@ApiModelProperty(required = false,value="动作" , notes = "动作" , example = "614741291334369280")
	private String actionId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "success")
	private String status;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容" , example = "节点数量:1 失败节点数量:0 ")
	private String content;
	
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
	 * logList：logList
	*/
	@ApiModelProperty(required = false,value="logList" , notes = "logList")
	private List<AutoTaskLog> logList;
	
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
	public AutoTaskMLog setId(String id) {
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
	public AutoTaskMLog setTaskId(String taskId) {
		this.taskId=taskId;
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
	public AutoTaskMLog setActionId(String actionId) {
		this.actionId=actionId;
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
	public AutoTaskMLog setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 内容
	 * @param content 内容
	 * @return 当前对象
	*/
	public AutoTaskMLog setContent(String content) {
		this.content=content;
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
	public AutoTaskMLog setStime(Date stime) {
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
	public AutoTaskMLog setEtime(Date etime) {
		this.etime=etime;
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
	public AutoTaskMLog setUpdateBy(String updateBy) {
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
	public AutoTaskMLog setUpdateTime(Date updateTime) {
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
	public AutoTaskMLog setDeleted(Integer deleted) {
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
	public AutoTaskMLog setDeleted(Boolean deletedBool) {
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
	public AutoTaskMLog setDeleteBy(String deleteBy) {
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
	public AutoTaskMLog setDeleteTime(Date deleteTime) {
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
	public AutoTaskMLog setVersion(Integer version) {
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
	public AutoTaskMLog setCreateBy(String createBy) {
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
	public AutoTaskMLog setCreateTime(Date createTime) {
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
	public AutoTaskMLog setTask(AutoTask task) {
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
	public AutoTaskMLog setAction(AutoAction action) {
		this.action=action;
		return this;
	}
	
	/**
	 * 获得 logList<br>
	 * logList
	 * @return logList
	*/
	public List<AutoTaskLog> getLogList() {
		return logList;
	}
	
	/**
	 * 设置 logList
	 * @param logList logList
	 * @return 当前对象
	*/
	public AutoTaskMLog setLogList(List<AutoTaskLog> logList) {
		this.logList=logList;
		return this;
	}
	
	/**
	 * 添加 logList
	 * @param log logList
	 * @return 当前对象
	*/
	public AutoTaskMLog addLog(AutoTaskLog... log) {
		if(this.logList==null) logList=new ArrayList<>();
		this.logList.addAll(Arrays.asList(log));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AutoTaskMLog , 转换好的 AutoTaskMLog 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AutoTaskMLog , 转换好的 PoJo 对象
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
	public AutoTaskMLog clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AutoTaskMLog duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.AutoTaskMLogMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.AutoTaskMLogMeta.$$proxy$$();
		inst.setStime(this.getStime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCreateTime(this.getCreateTime());
		inst.setEtime(this.getEtime());
		inst.setActionId(this.getActionId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTaskId(this.getTaskId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setTask(this.getTask());
			inst.setLogList(this.getLogList());
			inst.setAction(this.getAction());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AutoTaskMLog clone(boolean deep) {
		return EntityContext.clone(AutoTaskMLog.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AutoTaskMLog
	 * @param autoTaskMLogMap 包含实体信息的 Map 对象
	 * @return AutoTaskMLog , 转换好的的 AutoTaskMLog 对象
	*/
	@Transient
	public static AutoTaskMLog createFrom(Map<String,Object> autoTaskMLogMap) {
		if(autoTaskMLogMap==null) return null;
		AutoTaskMLog po = create();
		EntityContext.copyProperties(po,autoTaskMLogMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AutoTaskMLog
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AutoTaskMLog , 转换好的的 AutoTaskMLog 对象
	*/
	@Transient
	public static AutoTaskMLog createFrom(Object pojo) {
		if(pojo==null) return null;
		AutoTaskMLog po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AutoTaskMLog，等同于 new
	 * @return AutoTaskMLog 对象
	*/
	@Transient
	public static AutoTaskMLog create() {
		return new com.dt.platform.domain.ops.meta.AutoTaskMLogMeta.$$proxy$$();
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
			this.setStime(DataParser.parse(Date.class, map.get(AutoTaskMLogMeta.STIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AutoTaskMLogMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AutoTaskMLogMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(AutoTaskMLogMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AutoTaskMLogMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AutoTaskMLogMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AutoTaskMLogMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AutoTaskMLogMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AutoTaskMLogMeta.CREATE_TIME)));
			this.setEtime(DataParser.parse(Date.class, map.get(AutoTaskMLogMeta.ETIME)));
			this.setActionId(DataParser.parse(String.class, map.get(AutoTaskMLogMeta.ACTION_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AutoTaskMLogMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AutoTaskMLogMeta.ID)));
			this.setTaskId(DataParser.parse(String.class, map.get(AutoTaskMLogMeta.TASK_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AutoTaskMLogMeta.STATUS)));
			// others
			this.setTask(DataParser.parse(AutoTask.class, map.get(AutoTaskMLogMeta.TASK)));
			this.setAction(DataParser.parse(AutoAction.class, map.get(AutoTaskMLogMeta.ACTION)));
			return true;
		} else {
			try {
				this.setStime( (Date)map.get(AutoTaskMLogMeta.STIME));
				this.setUpdateTime( (Date)map.get(AutoTaskMLogMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AutoTaskMLogMeta.VERSION));
				this.setContent( (String)map.get(AutoTaskMLogMeta.CONTENT));
				this.setCreateBy( (String)map.get(AutoTaskMLogMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AutoTaskMLogMeta.DELETED));
				this.setUpdateBy( (String)map.get(AutoTaskMLogMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AutoTaskMLogMeta.DELETE_TIME));
				this.setCreateTime( (Date)map.get(AutoTaskMLogMeta.CREATE_TIME));
				this.setEtime( (Date)map.get(AutoTaskMLogMeta.ETIME));
				this.setActionId( (String)map.get(AutoTaskMLogMeta.ACTION_ID));
				this.setDeleteBy( (String)map.get(AutoTaskMLogMeta.DELETE_BY));
				this.setId( (String)map.get(AutoTaskMLogMeta.ID));
				this.setTaskId( (String)map.get(AutoTaskMLogMeta.TASK_ID));
				this.setStatus( (String)map.get(AutoTaskMLogMeta.STATUS));
				// others
				this.setTask( (AutoTask)map.get(AutoTaskMLogMeta.TASK));
				this.setAction( (AutoAction)map.get(AutoTaskMLogMeta.ACTION));
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
			this.setStime(DataParser.parse(Date.class, r.getValue(AutoTaskMLogMeta.STIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AutoTaskMLogMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AutoTaskMLogMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(AutoTaskMLogMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AutoTaskMLogMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AutoTaskMLogMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AutoTaskMLogMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AutoTaskMLogMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AutoTaskMLogMeta.CREATE_TIME)));
			this.setEtime(DataParser.parse(Date.class, r.getValue(AutoTaskMLogMeta.ETIME)));
			this.setActionId(DataParser.parse(String.class, r.getValue(AutoTaskMLogMeta.ACTION_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AutoTaskMLogMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AutoTaskMLogMeta.ID)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(AutoTaskMLogMeta.TASK_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AutoTaskMLogMeta.STATUS)));
			return true;
		} else {
			try {
				this.setStime( (Date)r.getValue(AutoTaskMLogMeta.STIME));
				this.setUpdateTime( (Date)r.getValue(AutoTaskMLogMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AutoTaskMLogMeta.VERSION));
				this.setContent( (String)r.getValue(AutoTaskMLogMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(AutoTaskMLogMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AutoTaskMLogMeta.DELETED));
				this.setUpdateBy( (String)r.getValue(AutoTaskMLogMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AutoTaskMLogMeta.DELETE_TIME));
				this.setCreateTime( (Date)r.getValue(AutoTaskMLogMeta.CREATE_TIME));
				this.setEtime( (Date)r.getValue(AutoTaskMLogMeta.ETIME));
				this.setActionId( (String)r.getValue(AutoTaskMLogMeta.ACTION_ID));
				this.setDeleteBy( (String)r.getValue(AutoTaskMLogMeta.DELETE_BY));
				this.setId( (String)r.getValue(AutoTaskMLogMeta.ID));
				this.setTaskId( (String)r.getValue(AutoTaskMLogMeta.TASK_ID));
				this.setStatus( (String)r.getValue(AutoTaskMLogMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}