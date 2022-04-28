package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INSPECTION_GROUP;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 巡检班组
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-27 21:27:38
 * @sign 57773E7F8A23D1501BBA61FE2A473AC3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inspection_group")
public class InspectionGroup extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INSPECTION_GROUP.$TABLE;
	
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
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 负责人：负责人
	*/
	@ApiModelProperty(required = false,value="负责人" , notes = "负责人")
	private String leaderId;
	
	/**
	 * 成员：成员
	*/
	@ApiModelProperty(required = false,value="成员" , notes = "成员")
	private String operUser;
	
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
	 * 负责人：负责人
	*/
	@ApiModelProperty(required = false,value="负责人" , notes = "负责人")
	private Employee leader;
	
	/**
	 * 巡检人：巡检人
	*/
	@ApiModelProperty(required = false,value="巡检人" , notes = "巡检人")
	private List<Employee> inspectorList;
	
	/**
	 * 巡检人：巡检人
	*/
	@ApiModelProperty(required = false,value="巡检人" , notes = "巡检人")
	private List<String> inspectorIds;
	
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
	public InspectionGroup setId(String id) {
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
	public InspectionGroup setName(String name) {
		this.name=name;
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
	public InspectionGroup setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 负责人<br>
	 * 负责人
	 * @return 负责人
	*/
	public String getLeaderId() {
		return leaderId;
	}
	
	/**
	 * 设置 负责人
	 * @param leaderId 负责人
	 * @return 当前对象
	*/
	public InspectionGroup setLeaderId(String leaderId) {
		this.leaderId=leaderId;
		return this;
	}
	
	/**
	 * 获得 成员<br>
	 * 成员
	 * @return 成员
	*/
	public String getOperUser() {
		return operUser;
	}
	
	/**
	 * 设置 成员
	 * @param operUser 成员
	 * @return 当前对象
	*/
	public InspectionGroup setOperUser(String operUser) {
		this.operUser=operUser;
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
	public InspectionGroup setNotes(String notes) {
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
	public InspectionGroup setCreateBy(String createBy) {
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
	public InspectionGroup setCreateTime(Date createTime) {
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
	public InspectionGroup setUpdateBy(String updateBy) {
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
	public InspectionGroup setUpdateTime(Date updateTime) {
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
	public InspectionGroup setDeleted(Integer deleted) {
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
	public InspectionGroup setDeleteBy(String deleteBy) {
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
	public InspectionGroup setDeleteTime(Date deleteTime) {
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
	public InspectionGroup setTenantId(String tenantId) {
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
	public InspectionGroup setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 负责人<br>
	 * 负责人
	 * @return 负责人
	*/
	public Employee getLeader() {
		return leader;
	}
	
	/**
	 * 设置 负责人
	 * @param leader 负责人
	 * @return 当前对象
	*/
	public InspectionGroup setLeader(Employee leader) {
		this.leader=leader;
		return this;
	}
	
	/**
	 * 获得 巡检人<br>
	 * 巡检人
	 * @return 巡检人
	*/
	public List<Employee> getInspectorList() {
		return inspectorList;
	}
	
	/**
	 * 设置 巡检人
	 * @param inspectorList 巡检人
	 * @return 当前对象
	*/
	public InspectionGroup setInspectorList(List<Employee> inspectorList) {
		this.inspectorList=inspectorList;
		return this;
	}
	
	/**
	 * 添加 巡检人
	 * @param inspector 巡检人
	 * @return 当前对象
	*/
	public InspectionGroup addInspector(Employee inspector) {
		if(this.inspectorList==null) inspectorList=new ArrayList<>();
		this.inspectorList.add(inspector);
		return this;
	}
	
	/**
	 * 获得 巡检人<br>
	 * 巡检人
	 * @return 巡检人
	*/
	public List<String> getInspectorIds() {
		return inspectorIds;
	}
	
	/**
	 * 设置 巡检人
	 * @param inspectorIds 巡检人
	 * @return 当前对象
	*/
	public InspectionGroup setInspectorIds(List<String> inspectorIds) {
		this.inspectorIds=inspectorIds;
		return this;
	}
	
	/**
	 * 添加 巡检人
	 * @param inspectorId 巡检人
	 * @return 当前对象
	*/
	public InspectionGroup addInspectorId(String inspectorId) {
		if(this.inspectorIds==null) inspectorIds=new ArrayList<>();
		this.inspectorIds.add(inspectorId);
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InspectionGroup , 转换好的 InspectionGroup 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InspectionGroup , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 InspectionGroup
	 * @param inspectionGroupMap 包含实体信息的 Map 对象
	 * @return InspectionGroup , 转换好的的 InspectionGroup 对象
	*/
	@Transient
	public static InspectionGroup createFrom(Map<String,Object> inspectionGroupMap) {
		if(inspectionGroupMap==null) return null;
		InspectionGroup po = EntityContext.create(InspectionGroup.class, inspectionGroupMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 InspectionGroup
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InspectionGroup , 转换好的的 InspectionGroup 对象
	*/
	@Transient
	public static InspectionGroup createFrom(Object pojo) {
		if(pojo==null) return null;
		InspectionGroup po = EntityContext.create(InspectionGroup.class,pojo);
		return po;
	}

	/**
	 * 创建一个 InspectionGroup，等同于 new
	 * @return InspectionGroup 对象
	*/
	@Transient
	public static InspectionGroup create() {
		return EntityContext.create(InspectionGroup.class);
	}
}