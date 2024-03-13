package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INSPECTION_TASK_POINT_OPER;
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
import com.dt.platform.domain.eam.meta.InspectionTaskPointOperMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 巡检点批量操作
 * <p>巡检点批量操作 , 数据表 eam_inspection_task_point_oper 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-10 14:18:27
 * @sign E3E5DF4735C56797BDEB4C9E7E90E333
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inspection_task_point_oper")
@ApiModel(description = "巡检点批量操作 ; 巡检点批量操作 , 数据表 eam_inspection_task_point_oper 的PO类型")
public class InspectionTaskPointOper extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INSPECTION_TASK_POINT_OPER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 任务：任务
	*/
	@ApiModelProperty(required = false,value="任务" , notes = "任务")
	private String taskId;
	
	/**
	 * 巡检状态：巡检状态
	*/
	@ApiModelProperty(required = false,value="巡检状态" , notes = "巡检状态")
	private String isPointStatus;
	
	/**
	 * 巡检状态：巡检状态
	*/
	@ApiModelProperty(required = false,value="巡检状态" , notes = "巡检状态")
	private String pointStatus;
	
	/**
	 * 处理动作：处理动作
	*/
	@ApiModelProperty(required = false,value="处理动作" , notes = "处理动作")
	private String isActionLabel;
	
	/**
	 * 处理动作：处理动作
	*/
	@ApiModelProperty(required = false,value="处理动作" , notes = "处理动作")
	private String actionLabel;
	
	/**
	 * 巡检人：巡检人
	*/
	@ApiModelProperty(required = false,value="巡检人" , notes = "巡检人")
	private String isInspectorId;
	
	/**
	 * 巡检人：巡检人
	*/
	@ApiModelProperty(required = false,value="巡检人" , notes = "巡检人")
	private String inspectorId;
	
	/**
	 * 巡检结果：巡检结果
	*/
	@ApiModelProperty(required = false,value="巡检结果" , notes = "巡检结果")
	private String isContent;
	
	/**
	 * 巡检结果：巡检结果
	*/
	@ApiModelProperty(required = false,value="巡检结果" , notes = "巡检结果")
	private String content;
	
	/**
	 * 操作人：操作人
	*/
	@ApiModelProperty(required = false,value="操作人" , notes = "操作人")
	private String operUserId;
	
	/**
	 * 操作时间：操作时间
	*/
	@ApiModelProperty(required = false,value="操作时间" , notes = "操作时间")
	private Date operTime;
	
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
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
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
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 巡检人：巡检人
	*/
	@ApiModelProperty(required = false,value="巡检人" , notes = "巡检人")
	private Employee inspector;
	
	/**
	 * 操作人：操作人
	*/
	@ApiModelProperty(required = false,value="操作人" , notes = "操作人")
	private Employee operUser;
	
	/**
	 * inspectionProcessAction：inspectionProcessAction
	*/
	@ApiModelProperty(required = false,value="inspectionProcessAction" , notes = "inspectionProcessAction")
	private InspectionProcessAction inspectionProcessAction;
	
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
	public InspectionTaskPointOper setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 任务<br>
	 * 任务
	 * @return 任务
	*/
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 设置 任务
	 * @param taskId 任务
	 * @return 当前对象
	*/
	public InspectionTaskPointOper setTaskId(String taskId) {
		this.taskId=taskId;
		return this;
	}
	
	/**
	 * 获得 巡检状态<br>
	 * 巡检状态
	 * @return 巡检状态
	*/
	public String getIsPointStatus() {
		return isPointStatus;
	}
	
	/**
	 * 设置 巡检状态
	 * @param isPointStatus 巡检状态
	 * @return 当前对象
	*/
	public InspectionTaskPointOper setIsPointStatus(String isPointStatus) {
		this.isPointStatus=isPointStatus;
		return this;
	}
	
	/**
	 * 获得 巡检状态<br>
	 * 巡检状态
	 * @return 巡检状态
	*/
	public String getPointStatus() {
		return pointStatus;
	}
	
	/**
	 * 设置 巡检状态
	 * @param pointStatus 巡检状态
	 * @return 当前对象
	*/
	public InspectionTaskPointOper setPointStatus(String pointStatus) {
		this.pointStatus=pointStatus;
		return this;
	}
	
	/**
	 * 获得 处理动作<br>
	 * 处理动作
	 * @return 处理动作
	*/
	public String getIsActionLabel() {
		return isActionLabel;
	}
	
	/**
	 * 设置 处理动作
	 * @param isActionLabel 处理动作
	 * @return 当前对象
	*/
	public InspectionTaskPointOper setIsActionLabel(String isActionLabel) {
		this.isActionLabel=isActionLabel;
		return this;
	}
	
	/**
	 * 获得 处理动作<br>
	 * 处理动作
	 * @return 处理动作
	*/
	public String getActionLabel() {
		return actionLabel;
	}
	
	/**
	 * 设置 处理动作
	 * @param actionLabel 处理动作
	 * @return 当前对象
	*/
	public InspectionTaskPointOper setActionLabel(String actionLabel) {
		this.actionLabel=actionLabel;
		return this;
	}
	
	/**
	 * 获得 巡检人<br>
	 * 巡检人
	 * @return 巡检人
	*/
	public String getIsInspectorId() {
		return isInspectorId;
	}
	
	/**
	 * 设置 巡检人
	 * @param isInspectorId 巡检人
	 * @return 当前对象
	*/
	public InspectionTaskPointOper setIsInspectorId(String isInspectorId) {
		this.isInspectorId=isInspectorId;
		return this;
	}
	
	/**
	 * 获得 巡检人<br>
	 * 巡检人
	 * @return 巡检人
	*/
	public String getInspectorId() {
		return inspectorId;
	}
	
	/**
	 * 设置 巡检人
	 * @param inspectorId 巡检人
	 * @return 当前对象
	*/
	public InspectionTaskPointOper setInspectorId(String inspectorId) {
		this.inspectorId=inspectorId;
		return this;
	}
	
	/**
	 * 获得 巡检结果<br>
	 * 巡检结果
	 * @return 巡检结果
	*/
	public String getIsContent() {
		return isContent;
	}
	
	/**
	 * 设置 巡检结果
	 * @param isContent 巡检结果
	 * @return 当前对象
	*/
	public InspectionTaskPointOper setIsContent(String isContent) {
		this.isContent=isContent;
		return this;
	}
	
	/**
	 * 获得 巡检结果<br>
	 * 巡检结果
	 * @return 巡检结果
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 巡检结果
	 * @param content 巡检结果
	 * @return 当前对象
	*/
	public InspectionTaskPointOper setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 操作人<br>
	 * 操作人
	 * @return 操作人
	*/
	public String getOperUserId() {
		return operUserId;
	}
	
	/**
	 * 设置 操作人
	 * @param operUserId 操作人
	 * @return 当前对象
	*/
	public InspectionTaskPointOper setOperUserId(String operUserId) {
		this.operUserId=operUserId;
		return this;
	}
	
	/**
	 * 获得 操作时间<br>
	 * 操作时间
	 * @return 操作时间
	*/
	public Date getOperTime() {
		return operTime;
	}
	
	/**
	 * 设置 操作时间
	 * @param operTime 操作时间
	 * @return 当前对象
	*/
	public InspectionTaskPointOper setOperTime(Date operTime) {
		this.operTime=operTime;
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
	public InspectionTaskPointOper setNotes(String notes) {
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
	public InspectionTaskPointOper setCreateBy(String createBy) {
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
	public InspectionTaskPointOper setCreateTime(Date createTime) {
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
	public InspectionTaskPointOper setUpdateBy(String updateBy) {
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
	public InspectionTaskPointOper setUpdateTime(Date updateTime) {
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
	public InspectionTaskPointOper setDeleted(Integer deleted) {
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
	public InspectionTaskPointOper setDeleted(Boolean deletedBool) {
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
	public InspectionTaskPointOper setDeleteBy(String deleteBy) {
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
	public InspectionTaskPointOper setDeleteTime(Date deleteTime) {
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
	public InspectionTaskPointOper setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 巡检人<br>
	 * 巡检人
	 * @return 巡检人
	*/
	public Employee getInspector() {
		return inspector;
	}
	
	/**
	 * 设置 巡检人
	 * @param inspector 巡检人
	 * @return 当前对象
	*/
	public InspectionTaskPointOper setInspector(Employee inspector) {
		this.inspector=inspector;
		return this;
	}
	
	/**
	 * 获得 操作人<br>
	 * 操作人
	 * @return 操作人
	*/
	public Employee getOperUser() {
		return operUser;
	}
	
	/**
	 * 设置 操作人
	 * @param operUser 操作人
	 * @return 当前对象
	*/
	public InspectionTaskPointOper setOperUser(Employee operUser) {
		this.operUser=operUser;
		return this;
	}
	
	/**
	 * 获得 inspectionProcessAction<br>
	 * inspectionProcessAction
	 * @return inspectionProcessAction
	*/
	public InspectionProcessAction getInspectionProcessAction() {
		return inspectionProcessAction;
	}
	
	/**
	 * 设置 inspectionProcessAction
	 * @param inspectionProcessAction inspectionProcessAction
	 * @return 当前对象
	*/
	public InspectionTaskPointOper setInspectionProcessAction(InspectionProcessAction inspectionProcessAction) {
		this.inspectionProcessAction=inspectionProcessAction;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InspectionTaskPointOper , 转换好的 InspectionTaskPointOper 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InspectionTaskPointOper , 转换好的 PoJo 对象
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
	public InspectionTaskPointOper clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InspectionTaskPointOper duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.InspectionTaskPointOperMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.InspectionTaskPointOperMeta.$$proxy$$();
		inst.setOperUserId(this.getOperUserId());
		inst.setNotes(this.getNotes());
		inst.setIsInspectorId(this.getIsInspectorId());
		inst.setIsContent(this.getIsContent());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setIsPointStatus(this.getIsPointStatus());
		inst.setInspectorId(this.getInspectorId());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setActionLabel(this.getActionLabel());
		inst.setIsActionLabel(this.getIsActionLabel());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setPointStatus(this.getPointStatus());
		inst.setTaskId(this.getTaskId());
		inst.setOperTime(this.getOperTime());
		if(all) {
			inst.setInspectionProcessAction(this.getInspectionProcessAction());
			inst.setInspector(this.getInspector());
			inst.setOperUser(this.getOperUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public InspectionTaskPointOper clone(boolean deep) {
		return EntityContext.clone(InspectionTaskPointOper.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InspectionTaskPointOper
	 * @param inspectionTaskPointOperMap 包含实体信息的 Map 对象
	 * @return InspectionTaskPointOper , 转换好的的 InspectionTaskPointOper 对象
	*/
	@Transient
	public static InspectionTaskPointOper createFrom(Map<String,Object> inspectionTaskPointOperMap) {
		if(inspectionTaskPointOperMap==null) return null;
		InspectionTaskPointOper po = create();
		EntityContext.copyProperties(po,inspectionTaskPointOperMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 InspectionTaskPointOper
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InspectionTaskPointOper , 转换好的的 InspectionTaskPointOper 对象
	*/
	@Transient
	public static InspectionTaskPointOper createFrom(Object pojo) {
		if(pojo==null) return null;
		InspectionTaskPointOper po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 InspectionTaskPointOper，等同于 new
	 * @return InspectionTaskPointOper 对象
	*/
	@Transient
	public static InspectionTaskPointOper create() {
		return new com.dt.platform.domain.eam.meta.InspectionTaskPointOperMeta.$$proxy$$();
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
			this.setOperUserId(DataParser.parse(String.class, map.get(InspectionTaskPointOperMeta.OPER_USER_ID)));
			this.setNotes(DataParser.parse(String.class, map.get(InspectionTaskPointOperMeta.NOTES)));
			this.setIsInspectorId(DataParser.parse(String.class, map.get(InspectionTaskPointOperMeta.IS_INSPECTOR_ID)));
			this.setIsContent(DataParser.parse(String.class, map.get(InspectionTaskPointOperMeta.IS_CONTENT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InspectionTaskPointOperMeta.UPDATE_TIME)));
			this.setIsPointStatus(DataParser.parse(String.class, map.get(InspectionTaskPointOperMeta.IS_POINT_STATUS)));
			this.setInspectorId(DataParser.parse(String.class, map.get(InspectionTaskPointOperMeta.INSPECTOR_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InspectionTaskPointOperMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(InspectionTaskPointOperMeta.CONTENT)));
			this.setActionLabel(DataParser.parse(String.class, map.get(InspectionTaskPointOperMeta.ACTION_LABEL)));
			this.setIsActionLabel(DataParser.parse(String.class, map.get(InspectionTaskPointOperMeta.IS_ACTION_LABEL)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InspectionTaskPointOperMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InspectionTaskPointOperMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InspectionTaskPointOperMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InspectionTaskPointOperMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InspectionTaskPointOperMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InspectionTaskPointOperMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(InspectionTaskPointOperMeta.ID)));
			this.setPointStatus(DataParser.parse(String.class, map.get(InspectionTaskPointOperMeta.POINT_STATUS)));
			this.setTaskId(DataParser.parse(String.class, map.get(InspectionTaskPointOperMeta.TASK_ID)));
			this.setOperTime(DataParser.parse(Date.class, map.get(InspectionTaskPointOperMeta.OPER_TIME)));
			// others
			this.setInspectionProcessAction(DataParser.parse(InspectionProcessAction.class, map.get(InspectionTaskPointOperMeta.INSPECTION_PROCESS_ACTION)));
			this.setInspector(DataParser.parse(Employee.class, map.get(InspectionTaskPointOperMeta.INSPECTOR)));
			this.setOperUser(DataParser.parse(Employee.class, map.get(InspectionTaskPointOperMeta.OPER_USER)));
			return true;
		} else {
			try {
				this.setOperUserId( (String)map.get(InspectionTaskPointOperMeta.OPER_USER_ID));
				this.setNotes( (String)map.get(InspectionTaskPointOperMeta.NOTES));
				this.setIsInspectorId( (String)map.get(InspectionTaskPointOperMeta.IS_INSPECTOR_ID));
				this.setIsContent( (String)map.get(InspectionTaskPointOperMeta.IS_CONTENT));
				this.setUpdateTime( (Date)map.get(InspectionTaskPointOperMeta.UPDATE_TIME));
				this.setIsPointStatus( (String)map.get(InspectionTaskPointOperMeta.IS_POINT_STATUS));
				this.setInspectorId( (String)map.get(InspectionTaskPointOperMeta.INSPECTOR_ID));
				this.setVersion( (Integer)map.get(InspectionTaskPointOperMeta.VERSION));
				this.setContent( (String)map.get(InspectionTaskPointOperMeta.CONTENT));
				this.setActionLabel( (String)map.get(InspectionTaskPointOperMeta.ACTION_LABEL));
				this.setIsActionLabel( (String)map.get(InspectionTaskPointOperMeta.IS_ACTION_LABEL));
				this.setCreateBy( (String)map.get(InspectionTaskPointOperMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(InspectionTaskPointOperMeta.DELETED));
				this.setCreateTime( (Date)map.get(InspectionTaskPointOperMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(InspectionTaskPointOperMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(InspectionTaskPointOperMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(InspectionTaskPointOperMeta.DELETE_BY));
				this.setId( (String)map.get(InspectionTaskPointOperMeta.ID));
				this.setPointStatus( (String)map.get(InspectionTaskPointOperMeta.POINT_STATUS));
				this.setTaskId( (String)map.get(InspectionTaskPointOperMeta.TASK_ID));
				this.setOperTime( (Date)map.get(InspectionTaskPointOperMeta.OPER_TIME));
				// others
				this.setInspectionProcessAction( (InspectionProcessAction)map.get(InspectionTaskPointOperMeta.INSPECTION_PROCESS_ACTION));
				this.setInspector( (Employee)map.get(InspectionTaskPointOperMeta.INSPECTOR));
				this.setOperUser( (Employee)map.get(InspectionTaskPointOperMeta.OPER_USER));
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
			this.setOperUserId(DataParser.parse(String.class, r.getValue(InspectionTaskPointOperMeta.OPER_USER_ID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(InspectionTaskPointOperMeta.NOTES)));
			this.setIsInspectorId(DataParser.parse(String.class, r.getValue(InspectionTaskPointOperMeta.IS_INSPECTOR_ID)));
			this.setIsContent(DataParser.parse(String.class, r.getValue(InspectionTaskPointOperMeta.IS_CONTENT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InspectionTaskPointOperMeta.UPDATE_TIME)));
			this.setIsPointStatus(DataParser.parse(String.class, r.getValue(InspectionTaskPointOperMeta.IS_POINT_STATUS)));
			this.setInspectorId(DataParser.parse(String.class, r.getValue(InspectionTaskPointOperMeta.INSPECTOR_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InspectionTaskPointOperMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(InspectionTaskPointOperMeta.CONTENT)));
			this.setActionLabel(DataParser.parse(String.class, r.getValue(InspectionTaskPointOperMeta.ACTION_LABEL)));
			this.setIsActionLabel(DataParser.parse(String.class, r.getValue(InspectionTaskPointOperMeta.IS_ACTION_LABEL)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InspectionTaskPointOperMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InspectionTaskPointOperMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InspectionTaskPointOperMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InspectionTaskPointOperMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InspectionTaskPointOperMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InspectionTaskPointOperMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(InspectionTaskPointOperMeta.ID)));
			this.setPointStatus(DataParser.parse(String.class, r.getValue(InspectionTaskPointOperMeta.POINT_STATUS)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(InspectionTaskPointOperMeta.TASK_ID)));
			this.setOperTime(DataParser.parse(Date.class, r.getValue(InspectionTaskPointOperMeta.OPER_TIME)));
			return true;
		} else {
			try {
				this.setOperUserId( (String)r.getValue(InspectionTaskPointOperMeta.OPER_USER_ID));
				this.setNotes( (String)r.getValue(InspectionTaskPointOperMeta.NOTES));
				this.setIsInspectorId( (String)r.getValue(InspectionTaskPointOperMeta.IS_INSPECTOR_ID));
				this.setIsContent( (String)r.getValue(InspectionTaskPointOperMeta.IS_CONTENT));
				this.setUpdateTime( (Date)r.getValue(InspectionTaskPointOperMeta.UPDATE_TIME));
				this.setIsPointStatus( (String)r.getValue(InspectionTaskPointOperMeta.IS_POINT_STATUS));
				this.setInspectorId( (String)r.getValue(InspectionTaskPointOperMeta.INSPECTOR_ID));
				this.setVersion( (Integer)r.getValue(InspectionTaskPointOperMeta.VERSION));
				this.setContent( (String)r.getValue(InspectionTaskPointOperMeta.CONTENT));
				this.setActionLabel( (String)r.getValue(InspectionTaskPointOperMeta.ACTION_LABEL));
				this.setIsActionLabel( (String)r.getValue(InspectionTaskPointOperMeta.IS_ACTION_LABEL));
				this.setCreateBy( (String)r.getValue(InspectionTaskPointOperMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(InspectionTaskPointOperMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(InspectionTaskPointOperMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(InspectionTaskPointOperMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(InspectionTaskPointOperMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(InspectionTaskPointOperMeta.DELETE_BY));
				this.setId( (String)r.getValue(InspectionTaskPointOperMeta.ID));
				this.setPointStatus( (String)r.getValue(InspectionTaskPointOperMeta.POINT_STATUS));
				this.setTaskId( (String)r.getValue(InspectionTaskPointOperMeta.TASK_ID));
				this.setOperTime( (Date)r.getValue(InspectionTaskPointOperMeta.OPER_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}