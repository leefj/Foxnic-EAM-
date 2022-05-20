package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INSPECTION_TASK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 巡检任务
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-27 07:23:26
 * @sign FBD3B2BE964F792E15DBC8062D4771F9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inspection_task")
public class InspectionTask extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INSPECTION_TASK.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 巡检计划：巡检计划
	*/
	@ApiModelProperty(required = false,value="巡检计划" , notes = "巡检计划")
	private String planId;
	
	/**
	 * 执行结果：执行结果
	*/
	@ApiModelProperty(required = false,value="执行结果" , notes = "执行结果")
	private String resultStatus;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间")
	private Date startTime;
	
	/**
	 * 完成时间：完成时间
	*/
	@ApiModelProperty(required = false,value="完成时间" , notes = "完成时间")
	private Date completeTime;
	
	/**
	 * 应开始时间：应开始时间
	*/
	@ApiModelProperty(required = false,value="应开始时间" , notes = "应开始时间")
	private Date planTime;
	
	/**
	 * 任务反馈：任务反馈
	*/
	@ApiModelProperty(required = false,value="任务反馈" , notes = "任务反馈")
	private String content;
	
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
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 计划：计划
	*/
	@ApiModelProperty(required = false,value="计划" , notes = "计划")
	private InspectionPlan inspectionPlan;
	
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
	public InspectionTask setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public InspectionTask setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 巡检计划<br>
	 * 巡检计划
	 * @return 巡检计划
	*/
	public String getPlanId() {
		return planId;
	}
	
	/**
	 * 设置 巡检计划
	 * @param planId 巡检计划
	 * @return 当前对象
	*/
	public InspectionTask setPlanId(String planId) {
		this.planId=planId;
		return this;
	}
	
	/**
	 * 获得 执行结果<br>
	 * 执行结果
	 * @return 执行结果
	*/
	public String getResultStatus() {
		return resultStatus;
	}
	
	/**
	 * 设置 执行结果
	 * @param resultStatus 执行结果
	 * @return 当前对象
	*/
	public InspectionTask setResultStatus(String resultStatus) {
		this.resultStatus=resultStatus;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getStartTime() {
		return startTime;
	}
	
	/**
	 * 设置 开始时间
	 * @param startTime 开始时间
	 * @return 当前对象
	*/
	public InspectionTask setStartTime(Date startTime) {
		this.startTime=startTime;
		return this;
	}
	
	/**
	 * 获得 完成时间<br>
	 * 完成时间
	 * @return 完成时间
	*/
	public Date getCompleteTime() {
		return completeTime;
	}
	
	/**
	 * 设置 完成时间
	 * @param completeTime 完成时间
	 * @return 当前对象
	*/
	public InspectionTask setCompleteTime(Date completeTime) {
		this.completeTime=completeTime;
		return this;
	}
	
	/**
	 * 获得 应开始时间<br>
	 * 应开始时间
	 * @return 应开始时间
	*/
	public Date getPlanTime() {
		return planTime;
	}
	
	/**
	 * 设置 应开始时间
	 * @param planTime 应开始时间
	 * @return 当前对象
	*/
	public InspectionTask setPlanTime(Date planTime) {
		this.planTime=planTime;
		return this;
	}
	
	/**
	 * 获得 任务反馈<br>
	 * 任务反馈
	 * @return 任务反馈
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 任务反馈
	 * @param content 任务反馈
	 * @return 当前对象
	*/
	public InspectionTask setContent(String content) {
		this.content=content;
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
	public InspectionTask setNotes(String notes) {
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
	public InspectionTask setCreateBy(String createBy) {
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
	public InspectionTask setCreateTime(Date createTime) {
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
	public InspectionTask setUpdateBy(String updateBy) {
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
	public InspectionTask setUpdateTime(Date updateTime) {
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
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	public InspectionTask setDeleted(Integer deleted) {
		this.deleted=deleted;
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
	public InspectionTask setDeleteBy(String deleteBy) {
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
	public InspectionTask setDeleteTime(Date deleteTime) {
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
	public InspectionTask setTenantId(String tenantId) {
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
	public InspectionTask setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 计划<br>
	 * 计划
	 * @return 计划
	*/
	public InspectionPlan getInspectionPlan() {
		return inspectionPlan;
	}
	
	/**
	 * 设置 计划
	 * @param inspectionPlan 计划
	 * @return 当前对象
	*/
	public InspectionTask setInspectionPlan(InspectionPlan inspectionPlan) {
		this.inspectionPlan=inspectionPlan;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InspectionTask , 转换好的 InspectionTask 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InspectionTask , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 InspectionTask
	 * @param inspectionTaskMap 包含实体信息的 Map 对象
	 * @return InspectionTask , 转换好的的 InspectionTask 对象
	*/
	@Transient
	public static InspectionTask createFrom(Map<String,Object> inspectionTaskMap) {
		if(inspectionTaskMap==null) return null;
		InspectionTask po = EntityContext.create(InspectionTask.class, inspectionTaskMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 InspectionTask
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InspectionTask , 转换好的的 InspectionTask 对象
	*/
	@Transient
	public static InspectionTask createFrom(Object pojo) {
		if(pojo==null) return null;
		InspectionTask po = EntityContext.create(InspectionTask.class,pojo);
		return po;
	}

	/**
	 * 创建一个 InspectionTask，等同于 new
	 * @return InspectionTask 对象
	*/
	@Transient
	public static InspectionTask create() {
		return EntityContext.create(InspectionTask.class);
	}
}