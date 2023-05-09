package com.dt.platform.domain.vehicle;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_VEHICLE_MAINTENANCE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.vehicle.meta.LeMaintenanceMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 车辆维修保养
 * <p>车辆维修保养 , 数据表 oa_vehicle_maintenance 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-09 12:43:09
 * @sign FE199AF8C35BE9FE00BABA679D045883
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_vehicle_maintenance")
@ApiModel(description = "车辆维修保养 ; 车辆维修保养 , 数据表 oa_vehicle_maintenance 的PO类型")
public class LeMaintenance extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_VEHICLE_MAINTENANCE.$TABLE;
	
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
	 * 流程：流程
	*/
	@ApiModelProperty(required = false,value="流程" , notes = "流程")
	private String procId;
	
	/**
	 * 业务名称：业务名称
	*/
	@ApiModelProperty(required = false,value="业务名称" , notes = "业务名称")
	private String name;
	
	/**
	 * 维修状态：维修状态
	*/
	@ApiModelProperty(required = false,value="维修状态" , notes = "维修状态")
	private String repairStatus;
	
	/**
	 * 报修类型：报修类型
	*/
	@ApiModelProperty(required = false,value="报修类型" , notes = "报修类型")
	private String type;
	
	/**
	 * 计划完成日期：计划完成日期
	*/
	@ApiModelProperty(required = false,value="计划完成日期" , notes = "计划完成日期")
	private Date planFinishDate;
	
	/**
	 * 实际完成日期：实际完成日期
	*/
	@ApiModelProperty(required = false,value="实际完成日期" , notes = "实际完成日期")
	private Date actualFinishDate;
	
	/**
	 * 费用：费用
	*/
	@ApiModelProperty(required = false,value="费用" , notes = "费用")
	private BigDecimal cost;
	
	/**
	 * 报修内容：报修内容
	*/
	@ApiModelProperty(required = false,value="报修内容" , notes = "报修内容")
	private String content;
	
	/**
	 * 报修人：报修人
	*/
	@ApiModelProperty(required = false,value="报修人" , notes = "报修人")
	private String reportUserId;
	
	/**
	 * 报修人：报修人
	*/
	@ApiModelProperty(required = false,value="报修人" , notes = "报修人")
	private String reportUserName;
	
	/**
	 * 图片：图片
	*/
	@ApiModelProperty(required = false,value="图片" , notes = "图片")
	private String pictureId;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
	/**
	 * 业务日期：业务日期
	*/
	@ApiModelProperty(required = false,value="业务日期" , notes = "业务日期")
	private Date businessDate;
	
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * 选择数据：选择数据
	*/
	@ApiModelProperty(required = false,value="选择数据" , notes = "选择数据")
	private String selectedCode;
	
	/**
	 * 车辆：车辆
	*/
	@ApiModelProperty(required = false,value="车辆" , notes = "车辆")
	private List<Info> vehicleInfoList;
	
	/**
	 * 车辆列表：车辆列表
	*/
	@ApiModelProperty(required = false,value="车辆列表" , notes = "车辆列表")
	private List<String> vehicleInfoIds;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 报修类型：报修类型
	*/
	@ApiModelProperty(required = false,value="报修类型" , notes = "报修类型")
	private DictItem maintenanceDict;
	
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
	public LeMaintenance setId(String id) {
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
	public LeMaintenance setBusinessCode(String businessCode) {
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
	public LeMaintenance setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 流程<br>
	 * 流程
	 * @return 流程
	*/
	public String getProcId() {
		return procId;
	}
	
	/**
	 * 设置 流程
	 * @param procId 流程
	 * @return 当前对象
	*/
	public LeMaintenance setProcId(String procId) {
		this.procId=procId;
		return this;
	}
	
	/**
	 * 获得 业务名称<br>
	 * 业务名称
	 * @return 业务名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 业务名称
	 * @param name 业务名称
	 * @return 当前对象
	*/
	public LeMaintenance setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 维修状态<br>
	 * 维修状态
	 * @return 维修状态
	*/
	public String getRepairStatus() {
		return repairStatus;
	}
	
	/**
	 * 设置 维修状态
	 * @param repairStatus 维修状态
	 * @return 当前对象
	*/
	public LeMaintenance setRepairStatus(String repairStatus) {
		this.repairStatus=repairStatus;
		return this;
	}
	
	/**
	 * 获得 报修类型<br>
	 * 报修类型
	 * @return 报修类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 报修类型
	 * @param type 报修类型
	 * @return 当前对象
	*/
	public LeMaintenance setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 计划完成日期<br>
	 * 计划完成日期
	 * @return 计划完成日期
	*/
	public Date getPlanFinishDate() {
		return planFinishDate;
	}
	
	/**
	 * 设置 计划完成日期
	 * @param planFinishDate 计划完成日期
	 * @return 当前对象
	*/
	public LeMaintenance setPlanFinishDate(Date planFinishDate) {
		this.planFinishDate=planFinishDate;
		return this;
	}
	
	/**
	 * 获得 实际完成日期<br>
	 * 实际完成日期
	 * @return 实际完成日期
	*/
	public Date getActualFinishDate() {
		return actualFinishDate;
	}
	
	/**
	 * 设置 实际完成日期
	 * @param actualFinishDate 实际完成日期
	 * @return 当前对象
	*/
	public LeMaintenance setActualFinishDate(Date actualFinishDate) {
		this.actualFinishDate=actualFinishDate;
		return this;
	}
	
	/**
	 * 获得 费用<br>
	 * 费用
	 * @return 费用
	*/
	public BigDecimal getCost() {
		return cost;
	}
	
	/**
	 * 设置 费用
	 * @param cost 费用
	 * @return 当前对象
	*/
	public LeMaintenance setCost(BigDecimal cost) {
		this.cost=cost;
		return this;
	}
	
	/**
	 * 获得 报修内容<br>
	 * 报修内容
	 * @return 报修内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 报修内容
	 * @param content 报修内容
	 * @return 当前对象
	*/
	public LeMaintenance setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 报修人<br>
	 * 报修人
	 * @return 报修人
	*/
	public String getReportUserId() {
		return reportUserId;
	}
	
	/**
	 * 设置 报修人
	 * @param reportUserId 报修人
	 * @return 当前对象
	*/
	public LeMaintenance setReportUserId(String reportUserId) {
		this.reportUserId=reportUserId;
		return this;
	}
	
	/**
	 * 获得 报修人<br>
	 * 报修人
	 * @return 报修人
	*/
	public String getReportUserName() {
		return reportUserName;
	}
	
	/**
	 * 设置 报修人
	 * @param reportUserName 报修人
	 * @return 当前对象
	*/
	public LeMaintenance setReportUserName(String reportUserName) {
		this.reportUserName=reportUserName;
		return this;
	}
	
	/**
	 * 获得 图片<br>
	 * 图片
	 * @return 图片
	*/
	public String getPictureId() {
		return pictureId;
	}
	
	/**
	 * 设置 图片
	 * @param pictureId 图片
	 * @return 当前对象
	*/
	public LeMaintenance setPictureId(String pictureId) {
		this.pictureId=pictureId;
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
	public LeMaintenance setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
		return this;
	}
	
	/**
	 * 获得 业务日期<br>
	 * 业务日期
	 * @return 业务日期
	*/
	public Date getBusinessDate() {
		return businessDate;
	}
	
	/**
	 * 设置 业务日期
	 * @param businessDate 业务日期
	 * @return 当前对象
	*/
	public LeMaintenance setBusinessDate(Date businessDate) {
		this.businessDate=businessDate;
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
	public LeMaintenance setCreateBy(String createBy) {
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
	public LeMaintenance setCreateTime(Date createTime) {
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
	public LeMaintenance setUpdateBy(String updateBy) {
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
	public LeMaintenance setUpdateTime(Date updateTime) {
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
	public LeMaintenance setDeleted(Integer deleted) {
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
	public LeMaintenance setDeleted(Boolean deletedBool) {
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
	public LeMaintenance setDeleteBy(String deleteBy) {
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
	public LeMaintenance setDeleteTime(Date deleteTime) {
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
	public LeMaintenance setVersion(Integer version) {
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
	public LeMaintenance setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 选择数据<br>
	 * 选择数据
	 * @return 选择数据
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择数据
	 * @param selectedCode 选择数据
	 * @return 当前对象
	*/
	public LeMaintenance setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 车辆<br>
	 * 车辆
	 * @return 车辆
	*/
	public List<Info> getVehicleInfoList() {
		return vehicleInfoList;
	}
	
	/**
	 * 设置 车辆
	 * @param vehicleInfoList 车辆
	 * @return 当前对象
	*/
	public LeMaintenance setVehicleInfoList(List<Info> vehicleInfoList) {
		this.vehicleInfoList=vehicleInfoList;
		return this;
	}
	
	/**
	 * 添加 车辆
	 * @param vehicleInfo 车辆
	 * @return 当前对象
	*/
	public LeMaintenance addVehicleInfo(Info... vehicleInfo) {
		if(this.vehicleInfoList==null) vehicleInfoList=new ArrayList<>();
		this.vehicleInfoList.addAll(Arrays.asList(vehicleInfo));
		return this;
	}
	
	/**
	 * 获得 车辆列表<br>
	 * 车辆列表
	 * @return 车辆列表
	*/
	public List<String> getVehicleInfoIds() {
		return vehicleInfoIds;
	}
	
	/**
	 * 设置 车辆列表
	 * @param vehicleInfoIds 车辆列表
	 * @return 当前对象
	*/
	public LeMaintenance setVehicleInfoIds(List<String> vehicleInfoIds) {
		this.vehicleInfoIds=vehicleInfoIds;
		return this;
	}
	
	/**
	 * 添加 车辆列表
	 * @param vehicleInfoId 车辆列表
	 * @return 当前对象
	*/
	public LeMaintenance addVehicleInfoId(String... vehicleInfoId) {
		if(this.vehicleInfoIds==null) vehicleInfoIds=new ArrayList<>();
		this.vehicleInfoIds.addAll(Arrays.asList(vehicleInfoId));
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
	public LeMaintenance setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 报修类型<br>
	 * 报修类型
	 * @return 报修类型
	*/
	public DictItem getMaintenanceDict() {
		return maintenanceDict;
	}
	
	/**
	 * 设置 报修类型
	 * @param maintenanceDict 报修类型
	 * @return 当前对象
	*/
	public LeMaintenance setMaintenanceDict(DictItem maintenanceDict) {
		this.maintenanceDict=maintenanceDict;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return LeMaintenance , 转换好的 LeMaintenance 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return LeMaintenance , 转换好的 PoJo 对象
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
	public LeMaintenance clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public LeMaintenance duplicate(boolean all) {
		com.dt.platform.domain.vehicle.meta.LeMaintenanceMeta.$$proxy$$ inst = new com.dt.platform.domain.vehicle.meta.LeMaintenanceMeta.$$proxy$$();
		inst.setProcId(this.getProcId());
		inst.setReportUserName(this.getReportUserName());
		inst.setType(this.getType());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setPictureId(this.getPictureId());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setReportUserId(this.getReportUserId());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setCost(this.getCost());
		inst.setRepairStatus(this.getRepairStatus());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setActualFinishDate(this.getActualFinishDate());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPlanFinishDate(this.getPlanFinishDate());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setVehicleInfoIds(this.getVehicleInfoIds());
			inst.setMaintenanceDict(this.getMaintenanceDict());
			inst.setVehicleInfoList(this.getVehicleInfoList());
			inst.setOriginator(this.getOriginator());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public LeMaintenance clone(boolean deep) {
		return EntityContext.clone(LeMaintenance.class,this,deep);
	}

	/**
	 * 将 Map 转换成 LeMaintenance
	 * @param leMaintenanceMap 包含实体信息的 Map 对象
	 * @return LeMaintenance , 转换好的的 LeMaintenance 对象
	*/
	@Transient
	public static LeMaintenance createFrom(Map<String,Object> leMaintenanceMap) {
		if(leMaintenanceMap==null) return null;
		LeMaintenance po = create();
		EntityContext.copyProperties(po,leMaintenanceMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 LeMaintenance
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return LeMaintenance , 转换好的的 LeMaintenance 对象
	*/
	@Transient
	public static LeMaintenance createFrom(Object pojo) {
		if(pojo==null) return null;
		LeMaintenance po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 LeMaintenance，等同于 new
	 * @return LeMaintenance 对象
	*/
	@Transient
	public static LeMaintenance create() {
		return new com.dt.platform.domain.vehicle.meta.LeMaintenanceMeta.$$proxy$$();
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
			this.setProcId(DataParser.parse(String.class, map.get(LeMaintenanceMeta.PROC_ID)));
			this.setReportUserName(DataParser.parse(String.class, map.get(LeMaintenanceMeta.REPORT_USER_NAME)));
			this.setType(DataParser.parse(String.class, map.get(LeMaintenanceMeta.TYPE)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(LeMaintenanceMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(LeMaintenanceMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(LeMaintenanceMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(LeMaintenanceMeta.BUSINESS_CODE)));
			this.setPictureId(DataParser.parse(String.class, map.get(LeMaintenanceMeta.PICTURE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(LeMaintenanceMeta.UPDATE_BY)));
			this.setReportUserId(DataParser.parse(String.class, map.get(LeMaintenanceMeta.REPORT_USER_ID)));
			this.setId(DataParser.parse(String.class, map.get(LeMaintenanceMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(LeMaintenanceMeta.ORIGINATOR_ID)));
			this.setCost(DataParser.parse(BigDecimal.class, map.get(LeMaintenanceMeta.COST)));
			this.setRepairStatus(DataParser.parse(String.class, map.get(LeMaintenanceMeta.REPAIR_STATUS)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(LeMaintenanceMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(LeMaintenanceMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(LeMaintenanceMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(LeMaintenanceMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(LeMaintenanceMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(LeMaintenanceMeta.DELETE_TIME)));
			this.setActualFinishDate(DataParser.parse(Date.class, map.get(LeMaintenanceMeta.ACTUAL_FINISH_DATE)));
			this.setName(DataParser.parse(String.class, map.get(LeMaintenanceMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(LeMaintenanceMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(LeMaintenanceMeta.DELETE_BY)));
			this.setPlanFinishDate(DataParser.parse(Date.class, map.get(LeMaintenanceMeta.PLAN_FINISH_DATE)));
			this.setStatus(DataParser.parse(String.class, map.get(LeMaintenanceMeta.STATUS)));
			// others
			this.setMaintenanceDict(DataParser.parse(DictItem.class, map.get(LeMaintenanceMeta.MAINTENANCE_DICT)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(LeMaintenanceMeta.ORIGINATOR)));
			return true;
		} else {
			try {
				this.setProcId( (String)map.get(LeMaintenanceMeta.PROC_ID));
				this.setReportUserName( (String)map.get(LeMaintenanceMeta.REPORT_USER_NAME));
				this.setType( (String)map.get(LeMaintenanceMeta.TYPE));
				this.setSelectedCode( (String)map.get(LeMaintenanceMeta.SELECTED_CODE));
				this.setContent( (String)map.get(LeMaintenanceMeta.CONTENT));
				this.setBusinessDate( (Date)map.get(LeMaintenanceMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(LeMaintenanceMeta.BUSINESS_CODE));
				this.setPictureId( (String)map.get(LeMaintenanceMeta.PICTURE_ID));
				this.setUpdateBy( (String)map.get(LeMaintenanceMeta.UPDATE_BY));
				this.setReportUserId( (String)map.get(LeMaintenanceMeta.REPORT_USER_ID));
				this.setId( (String)map.get(LeMaintenanceMeta.ID));
				this.setOriginatorId( (String)map.get(LeMaintenanceMeta.ORIGINATOR_ID));
				this.setCost( (BigDecimal)map.get(LeMaintenanceMeta.COST));
				this.setRepairStatus( (String)map.get(LeMaintenanceMeta.REPAIR_STATUS));
				this.setUpdateTime( (Date)map.get(LeMaintenanceMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(LeMaintenanceMeta.VERSION));
				this.setCreateBy( (String)map.get(LeMaintenanceMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(LeMaintenanceMeta.DELETED));
				this.setCreateTime( (Date)map.get(LeMaintenanceMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(LeMaintenanceMeta.DELETE_TIME));
				this.setActualFinishDate( (Date)map.get(LeMaintenanceMeta.ACTUAL_FINISH_DATE));
				this.setName( (String)map.get(LeMaintenanceMeta.NAME));
				this.setTenantId( (String)map.get(LeMaintenanceMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(LeMaintenanceMeta.DELETE_BY));
				this.setPlanFinishDate( (Date)map.get(LeMaintenanceMeta.PLAN_FINISH_DATE));
				this.setStatus( (String)map.get(LeMaintenanceMeta.STATUS));
				// others
				this.setMaintenanceDict( (DictItem)map.get(LeMaintenanceMeta.MAINTENANCE_DICT));
				this.setOriginator( (Employee)map.get(LeMaintenanceMeta.ORIGINATOR));
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
			this.setProcId(DataParser.parse(String.class, r.getValue(LeMaintenanceMeta.PROC_ID)));
			this.setReportUserName(DataParser.parse(String.class, r.getValue(LeMaintenanceMeta.REPORT_USER_NAME)));
			this.setType(DataParser.parse(String.class, r.getValue(LeMaintenanceMeta.TYPE)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(LeMaintenanceMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(LeMaintenanceMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(LeMaintenanceMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(LeMaintenanceMeta.BUSINESS_CODE)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(LeMaintenanceMeta.PICTURE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(LeMaintenanceMeta.UPDATE_BY)));
			this.setReportUserId(DataParser.parse(String.class, r.getValue(LeMaintenanceMeta.REPORT_USER_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(LeMaintenanceMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(LeMaintenanceMeta.ORIGINATOR_ID)));
			this.setCost(DataParser.parse(BigDecimal.class, r.getValue(LeMaintenanceMeta.COST)));
			this.setRepairStatus(DataParser.parse(String.class, r.getValue(LeMaintenanceMeta.REPAIR_STATUS)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(LeMaintenanceMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(LeMaintenanceMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(LeMaintenanceMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(LeMaintenanceMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(LeMaintenanceMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(LeMaintenanceMeta.DELETE_TIME)));
			this.setActualFinishDate(DataParser.parse(Date.class, r.getValue(LeMaintenanceMeta.ACTUAL_FINISH_DATE)));
			this.setName(DataParser.parse(String.class, r.getValue(LeMaintenanceMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(LeMaintenanceMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(LeMaintenanceMeta.DELETE_BY)));
			this.setPlanFinishDate(DataParser.parse(Date.class, r.getValue(LeMaintenanceMeta.PLAN_FINISH_DATE)));
			this.setStatus(DataParser.parse(String.class, r.getValue(LeMaintenanceMeta.STATUS)));
			return true;
		} else {
			try {
				this.setProcId( (String)r.getValue(LeMaintenanceMeta.PROC_ID));
				this.setReportUserName( (String)r.getValue(LeMaintenanceMeta.REPORT_USER_NAME));
				this.setType( (String)r.getValue(LeMaintenanceMeta.TYPE));
				this.setSelectedCode( (String)r.getValue(LeMaintenanceMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(LeMaintenanceMeta.CONTENT));
				this.setBusinessDate( (Date)r.getValue(LeMaintenanceMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(LeMaintenanceMeta.BUSINESS_CODE));
				this.setPictureId( (String)r.getValue(LeMaintenanceMeta.PICTURE_ID));
				this.setUpdateBy( (String)r.getValue(LeMaintenanceMeta.UPDATE_BY));
				this.setReportUserId( (String)r.getValue(LeMaintenanceMeta.REPORT_USER_ID));
				this.setId( (String)r.getValue(LeMaintenanceMeta.ID));
				this.setOriginatorId( (String)r.getValue(LeMaintenanceMeta.ORIGINATOR_ID));
				this.setCost( (BigDecimal)r.getValue(LeMaintenanceMeta.COST));
				this.setRepairStatus( (String)r.getValue(LeMaintenanceMeta.REPAIR_STATUS));
				this.setUpdateTime( (Date)r.getValue(LeMaintenanceMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(LeMaintenanceMeta.VERSION));
				this.setCreateBy( (String)r.getValue(LeMaintenanceMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(LeMaintenanceMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(LeMaintenanceMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(LeMaintenanceMeta.DELETE_TIME));
				this.setActualFinishDate( (Date)r.getValue(LeMaintenanceMeta.ACTUAL_FINISH_DATE));
				this.setName( (String)r.getValue(LeMaintenanceMeta.NAME));
				this.setTenantId( (String)r.getValue(LeMaintenanceMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(LeMaintenanceMeta.DELETE_BY));
				this.setPlanFinishDate( (Date)r.getValue(LeMaintenanceMeta.PLAN_FINISH_DATE));
				this.setStatus( (String)r.getValue(LeMaintenanceMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}