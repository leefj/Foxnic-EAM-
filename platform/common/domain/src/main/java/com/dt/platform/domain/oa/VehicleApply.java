package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_VEHICLE_APPLY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.oa.meta.VehicleApplyMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 车辆申请
 * <p>车辆申请 , 数据表 oa_vehicle_apply 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 16:02:14
 * @sign 559D4C33E519F7E9CFA3CCEB27D26C7E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_vehicle_apply")
@ApiModel(description = "车辆申请 ; 车辆申请 , 数据表 oa_vehicle_apply 的PO类型")
public class VehicleApply extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_VEHICLE_APPLY.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号")
	private String businessCode;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态")
	private String status;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 部门：部门
	*/
	@ApiModelProperty(required = false,value="部门" , notes = "部门")
	private String orgId;
	
	/**
	 * 领用人：领用人
	*/
	@ApiModelProperty(required = false,value="领用人" , notes = "领用人")
	private String receiverId;
	
	/**
	 * 驾驶员：驾驶员
	*/
	@ApiModelProperty(required = false,value="驾驶员" , notes = "驾驶员")
	private String driver;
	
	/**
	 * 联系方式：联系方式
	*/
	@ApiModelProperty(required = false,value="联系方式" , notes = "联系方式")
	private String contact;
	
	/**
	 * 领用时间：领用时间
	*/
	@ApiModelProperty(required = false,value="领用时间" , notes = "领用时间")
	private Date collectionDate;
	
	/**
	 * 预计归还时间：预计归还时间
	*/
	@ApiModelProperty(required = false,value="预计归还时间" , notes = "预计归还时间")
	private Date planReturnDate;
	
	/**
	 * 实际归还时间：实际归还时间
	*/
	@ApiModelProperty(required = false,value="实际归还时间" , notes = "实际归还时间")
	private Date actReturnDate;
	
	/**
	 * 是否归还：是否归还
	*/
	@ApiModelProperty(required = false,value="是否归还" , notes = "是否归还")
	private String ifReturn;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String content;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attach;
	
	/**
	 * 车辆：车辆
	*/
	@ApiModelProperty(required = false,value="车辆" , notes = "车辆")
	private String vehicleId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 归还备注：归还备注
	*/
	@ApiModelProperty(required = false,value="归还备注" , notes = "归还备注")
	private String returnNotes;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
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
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
	/**
	 * 车辆：车辆
	*/
	@ApiModelProperty(required = false,value="车辆" , notes = "车辆")
	private VehicleInfo vehicleInfo;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 领用人：领用人
	*/
	@ApiModelProperty(required = false,value="领用人" , notes = "领用人")
	private Employee receiver;
	
	/**
	 * 使用公司/部门：使用公司/部门
	*/
	@ApiModelProperty(required = false,value="使用公司/部门" , notes = "使用公司/部门")
	private Organization useOrganization;
	
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
	public VehicleApply setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 业务编号<br>
	 * 业务编号
	 * @return 业务编号
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 业务编号
	 * @param businessCode 业务编号
	 * @return 当前对象
	*/
	public VehicleApply setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 办理状态<br>
	 * 办理状态
	 * @return 办理状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 办理状态
	 * @param status 办理状态
	 * @return 当前对象
	*/
	public VehicleApply setStatus(String status) {
		this.status=status;
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
	public VehicleApply setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 部门<br>
	 * 部门
	 * @return 部门
	*/
	public String getOrgId() {
		return orgId;
	}
	
	/**
	 * 设置 部门
	 * @param orgId 部门
	 * @return 当前对象
	*/
	public VehicleApply setOrgId(String orgId) {
		this.orgId=orgId;
		return this;
	}
	
	/**
	 * 获得 领用人<br>
	 * 领用人
	 * @return 领用人
	*/
	public String getReceiverId() {
		return receiverId;
	}
	
	/**
	 * 设置 领用人
	 * @param receiverId 领用人
	 * @return 当前对象
	*/
	public VehicleApply setReceiverId(String receiverId) {
		this.receiverId=receiverId;
		return this;
	}
	
	/**
	 * 获得 驾驶员<br>
	 * 驾驶员
	 * @return 驾驶员
	*/
	public String getDriver() {
		return driver;
	}
	
	/**
	 * 设置 驾驶员
	 * @param driver 驾驶员
	 * @return 当前对象
	*/
	public VehicleApply setDriver(String driver) {
		this.driver=driver;
		return this;
	}
	
	/**
	 * 获得 联系方式<br>
	 * 联系方式
	 * @return 联系方式
	*/
	public String getContact() {
		return contact;
	}
	
	/**
	 * 设置 联系方式
	 * @param contact 联系方式
	 * @return 当前对象
	*/
	public VehicleApply setContact(String contact) {
		this.contact=contact;
		return this;
	}
	
	/**
	 * 获得 领用时间<br>
	 * 领用时间
	 * @return 领用时间
	*/
	public Date getCollectionDate() {
		return collectionDate;
	}
	
	/**
	 * 设置 领用时间
	 * @param collectionDate 领用时间
	 * @return 当前对象
	*/
	public VehicleApply setCollectionDate(Date collectionDate) {
		this.collectionDate=collectionDate;
		return this;
	}
	
	/**
	 * 获得 预计归还时间<br>
	 * 预计归还时间
	 * @return 预计归还时间
	*/
	public Date getPlanReturnDate() {
		return planReturnDate;
	}
	
	/**
	 * 设置 预计归还时间
	 * @param planReturnDate 预计归还时间
	 * @return 当前对象
	*/
	public VehicleApply setPlanReturnDate(Date planReturnDate) {
		this.planReturnDate=planReturnDate;
		return this;
	}
	
	/**
	 * 获得 实际归还时间<br>
	 * 实际归还时间
	 * @return 实际归还时间
	*/
	public Date getActReturnDate() {
		return actReturnDate;
	}
	
	/**
	 * 设置 实际归还时间
	 * @param actReturnDate 实际归还时间
	 * @return 当前对象
	*/
	public VehicleApply setActReturnDate(Date actReturnDate) {
		this.actReturnDate=actReturnDate;
		return this;
	}
	
	/**
	 * 获得 是否归还<br>
	 * 是否归还
	 * @return 是否归还
	*/
	public String getIfReturn() {
		return ifReturn;
	}
	
	/**
	 * 设置 是否归还
	 * @param ifReturn 是否归还
	 * @return 当前对象
	*/
	public VehicleApply setIfReturn(String ifReturn) {
		this.ifReturn=ifReturn;
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
	public VehicleApply setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getAttach() {
		return attach;
	}
	
	/**
	 * 设置 附件
	 * @param attach 附件
	 * @return 当前对象
	*/
	public VehicleApply setAttach(String attach) {
		this.attach=attach;
		return this;
	}
	
	/**
	 * 获得 车辆<br>
	 * 车辆
	 * @return 车辆
	*/
	public String getVehicleId() {
		return vehicleId;
	}
	
	/**
	 * 设置 车辆
	 * @param vehicleId 车辆
	 * @return 当前对象
	*/
	public VehicleApply setVehicleId(String vehicleId) {
		this.vehicleId=vehicleId;
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
	public VehicleApply setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 归还备注<br>
	 * 归还备注
	 * @return 归还备注
	*/
	public String getReturnNotes() {
		return returnNotes;
	}
	
	/**
	 * 设置 归还备注
	 * @param returnNotes 归还备注
	 * @return 当前对象
	*/
	public VehicleApply setReturnNotes(String returnNotes) {
		this.returnNotes=returnNotes;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public String getOriginatorId() {
		return originatorId;
	}
	
	/**
	 * 设置 制单人
	 * @param originatorId 制单人
	 * @return 当前对象
	*/
	public VehicleApply setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
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
	public VehicleApply setCreateBy(String createBy) {
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
	public VehicleApply setCreateTime(Date createTime) {
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
	public VehicleApply setUpdateBy(String updateBy) {
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
	public VehicleApply setUpdateTime(Date updateTime) {
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
	public VehicleApply setDeleted(Integer deleted) {
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
	public VehicleApply setDeleted(Boolean deletedBool) {
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
	public VehicleApply setDeleteBy(String deleteBy) {
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
	public VehicleApply setDeleteTime(Date deleteTime) {
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
	public VehicleApply setVersion(Integer version) {
		this.version=version;
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
	public VehicleApply setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 选择<br>
	 * 选择
	 * @return 选择
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择
	 * @param selectedCode 选择
	 * @return 当前对象
	*/
	public VehicleApply setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 车辆<br>
	 * 车辆
	 * @return 车辆
	*/
	public VehicleInfo getVehicleInfo() {
		return vehicleInfo;
	}
	
	/**
	 * 设置 车辆
	 * @param vehicleInfo 车辆
	 * @return 当前对象
	*/
	public VehicleApply setVehicleInfo(VehicleInfo vehicleInfo) {
		this.vehicleInfo=vehicleInfo;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public Employee getOriginator() {
		return originator;
	}
	
	/**
	 * 设置 制单人
	 * @param originator 制单人
	 * @return 当前对象
	*/
	public VehicleApply setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 领用人<br>
	 * 领用人
	 * @return 领用人
	*/
	public Employee getReceiver() {
		return receiver;
	}
	
	/**
	 * 设置 领用人
	 * @param receiver 领用人
	 * @return 当前对象
	*/
	public VehicleApply setReceiver(Employee receiver) {
		this.receiver=receiver;
		return this;
	}
	
	/**
	 * 获得 使用公司/部门<br>
	 * 使用公司/部门
	 * @return 使用公司/部门
	*/
	public Organization getUseOrganization() {
		return useOrganization;
	}
	
	/**
	 * 设置 使用公司/部门
	 * @param useOrganization 使用公司/部门
	 * @return 当前对象
	*/
	public VehicleApply setUseOrganization(Organization useOrganization) {
		this.useOrganization=useOrganization;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return VehicleApply , 转换好的 VehicleApply 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return VehicleApply , 转换好的 PoJo 对象
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
	public VehicleApply clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public VehicleApply duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.VehicleApplyMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.VehicleApplyMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setReturnNotes(this.getReturnNotes());
		inst.setActReturnDate(this.getActReturnDate());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setOrgId(this.getOrgId());
		inst.setContent(this.getContent());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setReceiverId(this.getReceiverId());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setContact(this.getContact());
		inst.setId(this.getId());
		inst.setAttach(this.getAttach());
		inst.setVehicleId(this.getVehicleId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setPlanReturnDate(this.getPlanReturnDate());
		inst.setIfReturn(this.getIfReturn());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setCollectionDate(this.getCollectionDate());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setDriver(this.getDriver());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setUseOrganization(this.getUseOrganization());
			inst.setReceiver(this.getReceiver());
			inst.setVehicleInfo(this.getVehicleInfo());
			inst.setOriginator(this.getOriginator());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public VehicleApply clone(boolean deep) {
		return EntityContext.clone(VehicleApply.class,this,deep);
	}

	/**
	 * 将 Map 转换成 VehicleApply
	 * @param vehicleApplyMap 包含实体信息的 Map 对象
	 * @return VehicleApply , 转换好的的 VehicleApply 对象
	*/
	@Transient
	public static VehicleApply createFrom(Map<String,Object> vehicleApplyMap) {
		if(vehicleApplyMap==null) return null;
		VehicleApply po = create();
		EntityContext.copyProperties(po,vehicleApplyMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 VehicleApply
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return VehicleApply , 转换好的的 VehicleApply 对象
	*/
	@Transient
	public static VehicleApply createFrom(Object pojo) {
		if(pojo==null) return null;
		VehicleApply po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 VehicleApply，等同于 new
	 * @return VehicleApply 对象
	*/
	@Transient
	public static VehicleApply create() {
		return new com.dt.platform.domain.oa.meta.VehicleApplyMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(VehicleApplyMeta.NOTES)));
			this.setReturnNotes(DataParser.parse(String.class, map.get(VehicleApplyMeta.RETURN_NOTES)));
			this.setActReturnDate(DataParser.parse(Date.class, map.get(VehicleApplyMeta.ACT_RETURN_DATE)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(VehicleApplyMeta.SELECTED_CODE)));
			this.setOrgId(DataParser.parse(String.class, map.get(VehicleApplyMeta.ORG_ID)));
			this.setContent(DataParser.parse(String.class, map.get(VehicleApplyMeta.CONTENT)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(VehicleApplyMeta.BUSINESS_CODE)));
			this.setReceiverId(DataParser.parse(String.class, map.get(VehicleApplyMeta.RECEIVER_ID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(VehicleApplyMeta.UPDATE_BY)));
			this.setContact(DataParser.parse(String.class, map.get(VehicleApplyMeta.CONTACT)));
			this.setId(DataParser.parse(String.class, map.get(VehicleApplyMeta.ID)));
			this.setAttach(DataParser.parse(String.class, map.get(VehicleApplyMeta.ATTACH)));
			this.setVehicleId(DataParser.parse(String.class, map.get(VehicleApplyMeta.VEHICLE_ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(VehicleApplyMeta.ORIGINATOR_ID)));
			this.setPlanReturnDate(DataParser.parse(Date.class, map.get(VehicleApplyMeta.PLAN_RETURN_DATE)));
			this.setIfReturn(DataParser.parse(String.class, map.get(VehicleApplyMeta.IF_RETURN)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(VehicleApplyMeta.UPDATE_TIME)));
			this.setCollectionDate(DataParser.parse(Date.class, map.get(VehicleApplyMeta.COLLECTION_DATE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(VehicleApplyMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(VehicleApplyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(VehicleApplyMeta.DELETED)));
			this.setDriver(DataParser.parse(String.class, map.get(VehicleApplyMeta.DRIVER)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(VehicleApplyMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(VehicleApplyMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(VehicleApplyMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(VehicleApplyMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(VehicleApplyMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(VehicleApplyMeta.STATUS)));
			// others
			this.setUseOrganization(DataParser.parse(Organization.class, map.get(VehicleApplyMeta.USE_ORGANIZATION)));
			this.setReceiver(DataParser.parse(Employee.class, map.get(VehicleApplyMeta.RECEIVER)));
			this.setVehicleInfo(DataParser.parse(VehicleInfo.class, map.get(VehicleApplyMeta.VEHICLE_INFO)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(VehicleApplyMeta.ORIGINATOR)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(VehicleApplyMeta.NOTES));
				this.setReturnNotes( (String)map.get(VehicleApplyMeta.RETURN_NOTES));
				this.setActReturnDate( (Date)map.get(VehicleApplyMeta.ACT_RETURN_DATE));
				this.setSelectedCode( (String)map.get(VehicleApplyMeta.SELECTED_CODE));
				this.setOrgId( (String)map.get(VehicleApplyMeta.ORG_ID));
				this.setContent( (String)map.get(VehicleApplyMeta.CONTENT));
				this.setBusinessCode( (String)map.get(VehicleApplyMeta.BUSINESS_CODE));
				this.setReceiverId( (String)map.get(VehicleApplyMeta.RECEIVER_ID));
				this.setUpdateBy( (String)map.get(VehicleApplyMeta.UPDATE_BY));
				this.setContact( (String)map.get(VehicleApplyMeta.CONTACT));
				this.setId( (String)map.get(VehicleApplyMeta.ID));
				this.setAttach( (String)map.get(VehicleApplyMeta.ATTACH));
				this.setVehicleId( (String)map.get(VehicleApplyMeta.VEHICLE_ID));
				this.setOriginatorId( (String)map.get(VehicleApplyMeta.ORIGINATOR_ID));
				this.setPlanReturnDate( (Date)map.get(VehicleApplyMeta.PLAN_RETURN_DATE));
				this.setIfReturn( (String)map.get(VehicleApplyMeta.IF_RETURN));
				this.setUpdateTime( (Date)map.get(VehicleApplyMeta.UPDATE_TIME));
				this.setCollectionDate( (Date)map.get(VehicleApplyMeta.COLLECTION_DATE));
				this.setVersion( (Integer)map.get(VehicleApplyMeta.VERSION));
				this.setCreateBy( (String)map.get(VehicleApplyMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(VehicleApplyMeta.DELETED));
				this.setDriver( (String)map.get(VehicleApplyMeta.DRIVER));
				this.setCreateTime( (Date)map.get(VehicleApplyMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(VehicleApplyMeta.DELETE_TIME));
				this.setName( (String)map.get(VehicleApplyMeta.NAME));
				this.setTenantId( (String)map.get(VehicleApplyMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(VehicleApplyMeta.DELETE_BY));
				this.setStatus( (String)map.get(VehicleApplyMeta.STATUS));
				// others
				this.setUseOrganization( (Organization)map.get(VehicleApplyMeta.USE_ORGANIZATION));
				this.setReceiver( (Employee)map.get(VehicleApplyMeta.RECEIVER));
				this.setVehicleInfo( (VehicleInfo)map.get(VehicleApplyMeta.VEHICLE_INFO));
				this.setOriginator( (Employee)map.get(VehicleApplyMeta.ORIGINATOR));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.NOTES)));
			this.setReturnNotes(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.RETURN_NOTES)));
			this.setActReturnDate(DataParser.parse(Date.class, r.getValue(VehicleApplyMeta.ACT_RETURN_DATE)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.SELECTED_CODE)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.ORG_ID)));
			this.setContent(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.CONTENT)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.BUSINESS_CODE)));
			this.setReceiverId(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.RECEIVER_ID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.UPDATE_BY)));
			this.setContact(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.CONTACT)));
			this.setId(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.ATTACH)));
			this.setVehicleId(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.VEHICLE_ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.ORIGINATOR_ID)));
			this.setPlanReturnDate(DataParser.parse(Date.class, r.getValue(VehicleApplyMeta.PLAN_RETURN_DATE)));
			this.setIfReturn(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.IF_RETURN)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(VehicleApplyMeta.UPDATE_TIME)));
			this.setCollectionDate(DataParser.parse(Date.class, r.getValue(VehicleApplyMeta.COLLECTION_DATE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(VehicleApplyMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(VehicleApplyMeta.DELETED)));
			this.setDriver(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.DRIVER)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(VehicleApplyMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(VehicleApplyMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(VehicleApplyMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(VehicleApplyMeta.NOTES));
				this.setReturnNotes( (String)r.getValue(VehicleApplyMeta.RETURN_NOTES));
				this.setActReturnDate( (Date)r.getValue(VehicleApplyMeta.ACT_RETURN_DATE));
				this.setSelectedCode( (String)r.getValue(VehicleApplyMeta.SELECTED_CODE));
				this.setOrgId( (String)r.getValue(VehicleApplyMeta.ORG_ID));
				this.setContent( (String)r.getValue(VehicleApplyMeta.CONTENT));
				this.setBusinessCode( (String)r.getValue(VehicleApplyMeta.BUSINESS_CODE));
				this.setReceiverId( (String)r.getValue(VehicleApplyMeta.RECEIVER_ID));
				this.setUpdateBy( (String)r.getValue(VehicleApplyMeta.UPDATE_BY));
				this.setContact( (String)r.getValue(VehicleApplyMeta.CONTACT));
				this.setId( (String)r.getValue(VehicleApplyMeta.ID));
				this.setAttach( (String)r.getValue(VehicleApplyMeta.ATTACH));
				this.setVehicleId( (String)r.getValue(VehicleApplyMeta.VEHICLE_ID));
				this.setOriginatorId( (String)r.getValue(VehicleApplyMeta.ORIGINATOR_ID));
				this.setPlanReturnDate( (Date)r.getValue(VehicleApplyMeta.PLAN_RETURN_DATE));
				this.setIfReturn( (String)r.getValue(VehicleApplyMeta.IF_RETURN));
				this.setUpdateTime( (Date)r.getValue(VehicleApplyMeta.UPDATE_TIME));
				this.setCollectionDate( (Date)r.getValue(VehicleApplyMeta.COLLECTION_DATE));
				this.setVersion( (Integer)r.getValue(VehicleApplyMeta.VERSION));
				this.setCreateBy( (String)r.getValue(VehicleApplyMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(VehicleApplyMeta.DELETED));
				this.setDriver( (String)r.getValue(VehicleApplyMeta.DRIVER));
				this.setCreateTime( (Date)r.getValue(VehicleApplyMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(VehicleApplyMeta.DELETE_TIME));
				this.setName( (String)r.getValue(VehicleApplyMeta.NAME));
				this.setTenantId( (String)r.getValue(VehicleApplyMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(VehicleApplyMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(VehicleApplyMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}