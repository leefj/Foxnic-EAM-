package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INSPECTION_TASK_ABNORMAL;
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
import com.dt.platform.domain.eam.meta.InspectionTaskAbnormalMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 异常巡检任务单
 * <p>异常巡检任务单 , 数据表 eam_inspection_task_abnormal 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-04 08:45:39
 * @sign DCD6411B01262861B2848425288151C1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inspection_task_abnormal")
@ApiModel(description = "异常巡检任务单 ; 异常巡检任务单 , 数据表 eam_inspection_task_abnormal 的PO类型")
public class InspectionTaskAbnormal extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INSPECTION_TASK_ABNORMAL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "735263472920559616")
	private String id;
	
	/**
	 * 任务名称：任务名称
	*/
	@ApiModelProperty(required = false,value="任务名称" , notes = "任务名称" , example = "735262715634778112")
	private String taskId;
	
	/**
	 * 异常信息：异常信息
	*/
	@ApiModelProperty(required = false,value="异常信息" , notes = "异常信息" , example = "存在巡检点异常,请")
	private String taskAbnormalInfo;
	
	/**
	 * 处理状态：处理状态
	*/
	@ApiModelProperty(required = false,value="处理状态" , notes = "处理状态" , example = "processed")
	private String status;
	
	/**
	 * 处理人员：处理人员
	*/
	@ApiModelProperty(required = false,value="处理人员" , notes = "处理人员" , example = "E001")
	private String operId;
	
	/**
	 * 处理方式：处理方式
	*/
	@ApiModelProperty(required = false,value="处理方式" , notes = "处理方式" , example = "12")
	private String content;
	
	/**
	 * 处理时间：处理时间
	*/
	@ApiModelProperty(required = false,value="处理时间" , notes = "处理时间" , example = "2023-07-23 09:14:59")
	private Date operTime;
	
	/**
	 * 图片：图片
	*/
	@ApiModelProperty(required = false,value="图片" , notes = "图片")
	private String fileIds;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "1212")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-07-22 10:34:33")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-07-23 09:14:59")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "7")
	private Integer version;
	
	/**
	 * task：task
	*/
	@ApiModelProperty(required = false,value="task" , notes = "task")
	private InspectionTask task;
	
	/**
	 * operUser：operUser
	*/
	@ApiModelProperty(required = false,value="operUser" , notes = "operUser")
	private Employee operUser;
	
	/**
	 * taskCode：taskCode
	*/
	@ApiModelProperty(required = false,value="taskCode" , notes = "taskCode")
	private String taskCode;
	
	/**
	 * taskCreateTime：taskCreateTime
	*/
	@ApiModelProperty(required = false,value="taskCreateTime" , notes = "taskCreateTime")
	private String taskCreateTime;
	
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
	public InspectionTaskAbnormal setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 任务名称<br>
	 * 任务名称
	 * @return 任务名称
	*/
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 设置 任务名称
	 * @param taskId 任务名称
	 * @return 当前对象
	*/
	public InspectionTaskAbnormal setTaskId(String taskId) {
		this.taskId=taskId;
		return this;
	}
	
	/**
	 * 获得 异常信息<br>
	 * 异常信息
	 * @return 异常信息
	*/
	public String getTaskAbnormalInfo() {
		return taskAbnormalInfo;
	}
	
	/**
	 * 设置 异常信息
	 * @param taskAbnormalInfo 异常信息
	 * @return 当前对象
	*/
	public InspectionTaskAbnormal setTaskAbnormalInfo(String taskAbnormalInfo) {
		this.taskAbnormalInfo=taskAbnormalInfo;
		return this;
	}
	
	/**
	 * 获得 处理状态<br>
	 * 处理状态
	 * @return 处理状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 处理状态
	 * @param status 处理状态
	 * @return 当前对象
	*/
	public InspectionTaskAbnormal setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 处理人员<br>
	 * 处理人员
	 * @return 处理人员
	*/
	public String getOperId() {
		return operId;
	}
	
	/**
	 * 设置 处理人员
	 * @param operId 处理人员
	 * @return 当前对象
	*/
	public InspectionTaskAbnormal setOperId(String operId) {
		this.operId=operId;
		return this;
	}
	
	/**
	 * 获得 处理方式<br>
	 * 处理方式
	 * @return 处理方式
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 处理方式
	 * @param content 处理方式
	 * @return 当前对象
	*/
	public InspectionTaskAbnormal setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 处理时间<br>
	 * 处理时间
	 * @return 处理时间
	*/
	public Date getOperTime() {
		return operTime;
	}
	
	/**
	 * 设置 处理时间
	 * @param operTime 处理时间
	 * @return 当前对象
	*/
	public InspectionTaskAbnormal setOperTime(Date operTime) {
		this.operTime=operTime;
		return this;
	}
	
	/**
	 * 获得 图片<br>
	 * 图片
	 * @return 图片
	*/
	public String getFileIds() {
		return fileIds;
	}
	
	/**
	 * 设置 图片
	 * @param fileIds 图片
	 * @return 当前对象
	*/
	public InspectionTaskAbnormal setFileIds(String fileIds) {
		this.fileIds=fileIds;
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
	public InspectionTaskAbnormal setNotes(String notes) {
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
	public InspectionTaskAbnormal setCreateBy(String createBy) {
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
	public InspectionTaskAbnormal setCreateTime(Date createTime) {
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
	public InspectionTaskAbnormal setUpdateBy(String updateBy) {
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
	public InspectionTaskAbnormal setUpdateTime(Date updateTime) {
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
	public InspectionTaskAbnormal setDeleted(Integer deleted) {
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
	public InspectionTaskAbnormal setDeleted(Boolean deletedBool) {
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
	public InspectionTaskAbnormal setDeleteBy(String deleteBy) {
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
	public InspectionTaskAbnormal setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 租户<br>
	 * 租户
	 * @return 租户
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户
	 * @param tenantId 租户
	 * @return 当前对象
	*/
	public InspectionTaskAbnormal setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public InspectionTaskAbnormal setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 task<br>
	 * task
	 * @return task
	*/
	public InspectionTask getTask() {
		return task;
	}
	
	/**
	 * 设置 task
	 * @param task task
	 * @return 当前对象
	*/
	public InspectionTaskAbnormal setTask(InspectionTask task) {
		this.task=task;
		return this;
	}
	
	/**
	 * 获得 operUser<br>
	 * operUser
	 * @return operUser
	*/
	public Employee getOperUser() {
		return operUser;
	}
	
	/**
	 * 设置 operUser
	 * @param operUser operUser
	 * @return 当前对象
	*/
	public InspectionTaskAbnormal setOperUser(Employee operUser) {
		this.operUser=operUser;
		return this;
	}
	
	/**
	 * 获得 taskCode<br>
	 * taskCode
	 * @return taskCode
	*/
	public String getTaskCode() {
		return taskCode;
	}
	
	/**
	 * 设置 taskCode
	 * @param taskCode taskCode
	 * @return 当前对象
	*/
	public InspectionTaskAbnormal setTaskCode(String taskCode) {
		this.taskCode=taskCode;
		return this;
	}
	
	/**
	 * 获得 taskCreateTime<br>
	 * taskCreateTime
	 * @return taskCreateTime
	*/
	public String getTaskCreateTime() {
		return taskCreateTime;
	}
	
	/**
	 * 设置 taskCreateTime
	 * @param taskCreateTime taskCreateTime
	 * @return 当前对象
	*/
	public InspectionTaskAbnormal setTaskCreateTime(String taskCreateTime) {
		this.taskCreateTime=taskCreateTime;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InspectionTaskAbnormal , 转换好的 InspectionTaskAbnormal 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InspectionTaskAbnormal , 转换好的 PoJo 对象
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
	public InspectionTaskAbnormal clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InspectionTaskAbnormal duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.InspectionTaskAbnormalMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.InspectionTaskAbnormalMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setOperId(this.getOperId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setTaskAbnormalInfo(this.getTaskAbnormalInfo());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setFileIds(this.getFileIds());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTaskId(this.getTaskId());
		inst.setStatus(this.getStatus());
		inst.setOperTime(this.getOperTime());
		if(all) {
			inst.setTask(this.getTask());
			inst.setTaskCode(this.getTaskCode());
			inst.setTaskCreateTime(this.getTaskCreateTime());
			inst.setOperUser(this.getOperUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public InspectionTaskAbnormal clone(boolean deep) {
		return EntityContext.clone(InspectionTaskAbnormal.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InspectionTaskAbnormal
	 * @param inspectionTaskAbnormalMap 包含实体信息的 Map 对象
	 * @return InspectionTaskAbnormal , 转换好的的 InspectionTaskAbnormal 对象
	*/
	@Transient
	public static InspectionTaskAbnormal createFrom(Map<String,Object> inspectionTaskAbnormalMap) {
		if(inspectionTaskAbnormalMap==null) return null;
		InspectionTaskAbnormal po = create();
		EntityContext.copyProperties(po,inspectionTaskAbnormalMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 InspectionTaskAbnormal
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InspectionTaskAbnormal , 转换好的的 InspectionTaskAbnormal 对象
	*/
	@Transient
	public static InspectionTaskAbnormal createFrom(Object pojo) {
		if(pojo==null) return null;
		InspectionTaskAbnormal po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 InspectionTaskAbnormal，等同于 new
	 * @return InspectionTaskAbnormal 对象
	*/
	@Transient
	public static InspectionTaskAbnormal create() {
		return new com.dt.platform.domain.eam.meta.InspectionTaskAbnormalMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(InspectionTaskAbnormalMeta.NOTES)));
			this.setOperId(DataParser.parse(String.class, map.get(InspectionTaskAbnormalMeta.OPER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InspectionTaskAbnormalMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InspectionTaskAbnormalMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(InspectionTaskAbnormalMeta.CONTENT)));
			this.setTaskAbnormalInfo(DataParser.parse(String.class, map.get(InspectionTaskAbnormalMeta.TASK_ABNORMAL_INFO)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InspectionTaskAbnormalMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InspectionTaskAbnormalMeta.DELETED)));
			this.setFileIds(DataParser.parse(String.class, map.get(InspectionTaskAbnormalMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InspectionTaskAbnormalMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InspectionTaskAbnormalMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InspectionTaskAbnormalMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(InspectionTaskAbnormalMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InspectionTaskAbnormalMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(InspectionTaskAbnormalMeta.ID)));
			this.setTaskId(DataParser.parse(String.class, map.get(InspectionTaskAbnormalMeta.TASK_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(InspectionTaskAbnormalMeta.STATUS)));
			this.setOperTime(DataParser.parse(Date.class, map.get(InspectionTaskAbnormalMeta.OPER_TIME)));
			// others
			this.setTask(DataParser.parse(InspectionTask.class, map.get(InspectionTaskAbnormalMeta.TASK)));
			this.setTaskCode(DataParser.parse(String.class, map.get(InspectionTaskAbnormalMeta.TASK_CODE)));
			this.setTaskCreateTime(DataParser.parse(String.class, map.get(InspectionTaskAbnormalMeta.TASK_CREATE_TIME)));
			this.setOperUser(DataParser.parse(Employee.class, map.get(InspectionTaskAbnormalMeta.OPER_USER)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(InspectionTaskAbnormalMeta.NOTES));
				this.setOperId( (String)map.get(InspectionTaskAbnormalMeta.OPER_ID));
				this.setUpdateTime( (Date)map.get(InspectionTaskAbnormalMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(InspectionTaskAbnormalMeta.VERSION));
				this.setContent( (String)map.get(InspectionTaskAbnormalMeta.CONTENT));
				this.setTaskAbnormalInfo( (String)map.get(InspectionTaskAbnormalMeta.TASK_ABNORMAL_INFO));
				this.setCreateBy( (String)map.get(InspectionTaskAbnormalMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(InspectionTaskAbnormalMeta.DELETED));
				this.setFileIds( (String)map.get(InspectionTaskAbnormalMeta.FILE_IDS));
				this.setCreateTime( (Date)map.get(InspectionTaskAbnormalMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(InspectionTaskAbnormalMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(InspectionTaskAbnormalMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(InspectionTaskAbnormalMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(InspectionTaskAbnormalMeta.DELETE_BY));
				this.setId( (String)map.get(InspectionTaskAbnormalMeta.ID));
				this.setTaskId( (String)map.get(InspectionTaskAbnormalMeta.TASK_ID));
				this.setStatus( (String)map.get(InspectionTaskAbnormalMeta.STATUS));
				this.setOperTime( (Date)map.get(InspectionTaskAbnormalMeta.OPER_TIME));
				// others
				this.setTask( (InspectionTask)map.get(InspectionTaskAbnormalMeta.TASK));
				this.setTaskCode( (String)map.get(InspectionTaskAbnormalMeta.TASK_CODE));
				this.setTaskCreateTime( (String)map.get(InspectionTaskAbnormalMeta.TASK_CREATE_TIME));
				this.setOperUser( (Employee)map.get(InspectionTaskAbnormalMeta.OPER_USER));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(InspectionTaskAbnormalMeta.NOTES)));
			this.setOperId(DataParser.parse(String.class, r.getValue(InspectionTaskAbnormalMeta.OPER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InspectionTaskAbnormalMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InspectionTaskAbnormalMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(InspectionTaskAbnormalMeta.CONTENT)));
			this.setTaskAbnormalInfo(DataParser.parse(String.class, r.getValue(InspectionTaskAbnormalMeta.TASK_ABNORMAL_INFO)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InspectionTaskAbnormalMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InspectionTaskAbnormalMeta.DELETED)));
			this.setFileIds(DataParser.parse(String.class, r.getValue(InspectionTaskAbnormalMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InspectionTaskAbnormalMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InspectionTaskAbnormalMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InspectionTaskAbnormalMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(InspectionTaskAbnormalMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InspectionTaskAbnormalMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(InspectionTaskAbnormalMeta.ID)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(InspectionTaskAbnormalMeta.TASK_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(InspectionTaskAbnormalMeta.STATUS)));
			this.setOperTime(DataParser.parse(Date.class, r.getValue(InspectionTaskAbnormalMeta.OPER_TIME)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(InspectionTaskAbnormalMeta.NOTES));
				this.setOperId( (String)r.getValue(InspectionTaskAbnormalMeta.OPER_ID));
				this.setUpdateTime( (Date)r.getValue(InspectionTaskAbnormalMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(InspectionTaskAbnormalMeta.VERSION));
				this.setContent( (String)r.getValue(InspectionTaskAbnormalMeta.CONTENT));
				this.setTaskAbnormalInfo( (String)r.getValue(InspectionTaskAbnormalMeta.TASK_ABNORMAL_INFO));
				this.setCreateBy( (String)r.getValue(InspectionTaskAbnormalMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(InspectionTaskAbnormalMeta.DELETED));
				this.setFileIds( (String)r.getValue(InspectionTaskAbnormalMeta.FILE_IDS));
				this.setCreateTime( (Date)r.getValue(InspectionTaskAbnormalMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(InspectionTaskAbnormalMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(InspectionTaskAbnormalMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(InspectionTaskAbnormalMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(InspectionTaskAbnormalMeta.DELETE_BY));
				this.setId( (String)r.getValue(InspectionTaskAbnormalMeta.ID));
				this.setTaskId( (String)r.getValue(InspectionTaskAbnormalMeta.TASK_ID));
				this.setStatus( (String)r.getValue(InspectionTaskAbnormalMeta.STATUS));
				this.setOperTime( (Date)r.getValue(InspectionTaskAbnormalMeta.OPER_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}