package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_VEHICLE_INFO;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.oa.meta.VehicleInfoMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 车辆信息
 * <p>车辆信息 , 数据表 oa_vehicle_info 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 15:50:00
 * @sign 17097E5DDF79EE6A03B24F1BCBC6353A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_vehicle_info")
@ApiModel(description = "车辆信息 ; 车辆信息 , 数据表 oa_vehicle_info 的PO类型")
public class VehicleInfo extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_VEHICLE_INFO.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "719917196876185600")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "你可能")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "inuse")
	private String vehicleStatus;
	
	/**
	 * 车辆类型：车辆类型
	*/
	@ApiModelProperty(required = false,value="车辆类型" , notes = "车辆类型" , example = "jiaoche")
	private String type;
	
	/**
	 * 车牌号：车牌号
	*/
	@ApiModelProperty(required = false,value="车牌号" , notes = "车牌号" , example = "来看看")
	private String vehicleCode;
	
	/**
	 * 品牌型号：品牌型号
	*/
	@ApiModelProperty(required = false,value="品牌型号" , notes = "品牌型号" , example = "空间看")
	private String model;
	
	/**
	 * 登记人：登记人
	*/
	@ApiModelProperty(required = false,value="登记人" , notes = "登记人" , example = "你 ")
	private String registrant;
	
	/**
	 * 所属组织：所属组织
	*/
	@ApiModelProperty(required = false,value="所属组织" , notes = "所属组织")
	private String ownerOrgId;
	
	/**
	 * 使用人：使用人
	*/
	@ApiModelProperty(required = false,value="使用人" , notes = "使用人")
	private String manageUserId;
	
	/**
	 * 使用部门：使用部门
	*/
	@ApiModelProperty(required = false,value="使用部门" , notes = "使用部门")
	private String useOrgId;
	
	/**
	 * 使用人：使用人
	*/
	@ApiModelProperty(required = false,value="使用人" , notes = "使用人")
	private String useUserId;
	
	/**
	 * 颜色：颜色
	*/
	@ApiModelProperty(required = false,value="颜色" , notes = "颜色")
	private String color;
	
	/**
	 * 发动机号：发动机号
	*/
	@ApiModelProperty(required = false,value="发动机号" , notes = "发动机号" , example = "12345")
	private String engineNumber;
	
	/**
	 * 行驶证：行驶证
	*/
	@ApiModelProperty(required = false,value="行驶证" , notes = "行驶证")
	private String drivingLicense;
	
	/**
	 * 车架号：车架号
	*/
	@ApiModelProperty(required = false,value="车架号" , notes = "车架号")
	private String frameNumber;
	
	/**
	 * 公里数：公里数
	*/
	@ApiModelProperty(required = false,value="公里数" , notes = "公里数" , example = "0.00")
	private BigDecimal kilometers;
	
	/**
	 * 车船税：车船税
	*/
	@ApiModelProperty(required = false,value="车船税" , notes = "车船税" , example = "0.00")
	private BigDecimal carBoatTax;
	
	/**
	 * 抢险：元)
	*/
	@ApiModelProperty(required = false,value="抢险" , notes = "元)" , example = "0.00")
	private BigDecimal rescueMoney;
	
	/**
	 * 商业险：元)
	*/
	@ApiModelProperty(required = false,value="商业险" , notes = "元)" , example = "0.00")
	private BigDecimal commercialInsuranceMoney;
	
	/**
	 * 保险公司：保险公司
	*/
	@ApiModelProperty(required = false,value="保险公司" , notes = "保险公司" , example = "考虑空间")
	private String insuranceCompany;
	
	/**
	 * 上牌时间：上牌时间
	*/
	@ApiModelProperty(required = false,value="上牌时间" , notes = "上牌时间" , example = "2023-06-04 12:00:00")
	private Date licensingTime;
	
	/**
	 * 商业险到期：商业险到期
	*/
	@ApiModelProperty(required = false,value="商业险到期" , notes = "商业险到期" , example = "2023-06-26 12:00:00")
	private Date insuranceExpireDate;
	
	/**
	 * 抢险到期：抢险到期
	*/
	@ApiModelProperty(required = false,value="抢险到期" , notes = "抢险到期" , example = "2023-06-15 12:00:00")
	private Date rescueDueDate;
	
	/**
	 * 承载人数：承载人数
	*/
	@ApiModelProperty(required = false,value="承载人数" , notes = "承载人数" , example = "2")
	private Integer maximumPassengers;
	
	/**
	 * 报废时间：报废时间
	*/
	@ApiModelProperty(required = false,value="报废时间" , notes = "报废时间" , example = "2023-06-13 12:00:00")
	private Date scrapTime;
	
	/**
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置")
	private String positionId;
	
	/**
	 * 位置详情：位置详情
	*/
	@ApiModelProperty(required = false,value="位置详情" , notes = "位置详情" , example = "12121212")
	private String positionDetail;
	
	/**
	 * 图片：图片
	*/
	@ApiModelProperty(required = false,value="图片" , notes = "图片")
	private String pictures;
	
	/**
	 * 技术参数：技术参数
	*/
	@ApiModelProperty(required = false,value="技术参数" , notes = "技术参数" , example = "考虑你们")
	private String technicalParameter;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "空间")
	private String notes;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本" , example = "1")
	private Integer version;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-06-10 02:13:55")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private Organization ownerCompany;
	
	/**
	 * 使用公司/部门：使用公司/部门
	*/
	@ApiModelProperty(required = false,value="使用公司/部门" , notes = "使用公司/部门")
	private Organization useOrganization;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private DictItem vehicleTypeDict;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private DictItem vehicleStatusDict;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 使用人：使用人
	*/
	@ApiModelProperty(required = false,value="使用人" , notes = "使用人")
	private Employee useUser;
	
	/**
	 * vehicleInsuranceCompany：vehicleInsuranceCompany
	*/
	@ApiModelProperty(required = false,value="vehicleInsuranceCompany" , notes = "vehicleInsuranceCompany")
	private VehicleInsuranceCompany vehicleInsuranceCompany;
	
	/**
	 * 车辆列表：车辆列表
	*/
	@ApiModelProperty(required = false,value="车辆列表" , notes = "车辆列表")
	private String selectIds;
	
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
	public VehicleInfo setId(String id) {
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
	public VehicleInfo setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getVehicleStatus() {
		return vehicleStatus;
	}
	
	/**
	 * 设置 状态
	 * @param vehicleStatus 状态
	 * @return 当前对象
	*/
	public VehicleInfo setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus=vehicleStatus;
		return this;
	}
	
	/**
	 * 获得 车辆类型<br>
	 * 车辆类型
	 * @return 车辆类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 车辆类型
	 * @param type 车辆类型
	 * @return 当前对象
	*/
	public VehicleInfo setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 车牌号<br>
	 * 车牌号
	 * @return 车牌号
	*/
	public String getVehicleCode() {
		return vehicleCode;
	}
	
	/**
	 * 设置 车牌号
	 * @param vehicleCode 车牌号
	 * @return 当前对象
	*/
	public VehicleInfo setVehicleCode(String vehicleCode) {
		this.vehicleCode=vehicleCode;
		return this;
	}
	
	/**
	 * 获得 品牌型号<br>
	 * 品牌型号
	 * @return 品牌型号
	*/
	public String getModel() {
		return model;
	}
	
	/**
	 * 设置 品牌型号
	 * @param model 品牌型号
	 * @return 当前对象
	*/
	public VehicleInfo setModel(String model) {
		this.model=model;
		return this;
	}
	
	/**
	 * 获得 登记人<br>
	 * 登记人
	 * @return 登记人
	*/
	public String getRegistrant() {
		return registrant;
	}
	
	/**
	 * 设置 登记人
	 * @param registrant 登记人
	 * @return 当前对象
	*/
	public VehicleInfo setRegistrant(String registrant) {
		this.registrant=registrant;
		return this;
	}
	
	/**
	 * 获得 所属组织<br>
	 * 所属组织
	 * @return 所属组织
	*/
	public String getOwnerOrgId() {
		return ownerOrgId;
	}
	
	/**
	 * 设置 所属组织
	 * @param ownerOrgId 所属组织
	 * @return 当前对象
	*/
	public VehicleInfo setOwnerOrgId(String ownerOrgId) {
		this.ownerOrgId=ownerOrgId;
		return this;
	}
	
	/**
	 * 获得 使用人<br>
	 * 使用人
	 * @return 使用人
	*/
	public String getManageUserId() {
		return manageUserId;
	}
	
	/**
	 * 设置 使用人
	 * @param manageUserId 使用人
	 * @return 当前对象
	*/
	public VehicleInfo setManageUserId(String manageUserId) {
		this.manageUserId=manageUserId;
		return this;
	}
	
	/**
	 * 获得 使用部门<br>
	 * 使用部门
	 * @return 使用部门
	*/
	public String getUseOrgId() {
		return useOrgId;
	}
	
	/**
	 * 设置 使用部门
	 * @param useOrgId 使用部门
	 * @return 当前对象
	*/
	public VehicleInfo setUseOrgId(String useOrgId) {
		this.useOrgId=useOrgId;
		return this;
	}
	
	/**
	 * 获得 使用人<br>
	 * 使用人
	 * @return 使用人
	*/
	public String getUseUserId() {
		return useUserId;
	}
	
	/**
	 * 设置 使用人
	 * @param useUserId 使用人
	 * @return 当前对象
	*/
	public VehicleInfo setUseUserId(String useUserId) {
		this.useUserId=useUserId;
		return this;
	}
	
	/**
	 * 获得 颜色<br>
	 * 颜色
	 * @return 颜色
	*/
	public String getColor() {
		return color;
	}
	
	/**
	 * 设置 颜色
	 * @param color 颜色
	 * @return 当前对象
	*/
	public VehicleInfo setColor(String color) {
		this.color=color;
		return this;
	}
	
	/**
	 * 获得 发动机号<br>
	 * 发动机号
	 * @return 发动机号
	*/
	public String getEngineNumber() {
		return engineNumber;
	}
	
	/**
	 * 设置 发动机号
	 * @param engineNumber 发动机号
	 * @return 当前对象
	*/
	public VehicleInfo setEngineNumber(String engineNumber) {
		this.engineNumber=engineNumber;
		return this;
	}
	
	/**
	 * 获得 行驶证<br>
	 * 行驶证
	 * @return 行驶证
	*/
	public String getDrivingLicense() {
		return drivingLicense;
	}
	
	/**
	 * 设置 行驶证
	 * @param drivingLicense 行驶证
	 * @return 当前对象
	*/
	public VehicleInfo setDrivingLicense(String drivingLicense) {
		this.drivingLicense=drivingLicense;
		return this;
	}
	
	/**
	 * 获得 车架号<br>
	 * 车架号
	 * @return 车架号
	*/
	public String getFrameNumber() {
		return frameNumber;
	}
	
	/**
	 * 设置 车架号
	 * @param frameNumber 车架号
	 * @return 当前对象
	*/
	public VehicleInfo setFrameNumber(String frameNumber) {
		this.frameNumber=frameNumber;
		return this;
	}
	
	/**
	 * 获得 公里数<br>
	 * 公里数
	 * @return 公里数
	*/
	public BigDecimal getKilometers() {
		return kilometers;
	}
	
	/**
	 * 设置 公里数
	 * @param kilometers 公里数
	 * @return 当前对象
	*/
	public VehicleInfo setKilometers(BigDecimal kilometers) {
		this.kilometers=kilometers;
		return this;
	}
	
	/**
	 * 获得 车船税<br>
	 * 车船税
	 * @return 车船税
	*/
	public BigDecimal getCarBoatTax() {
		return carBoatTax;
	}
	
	/**
	 * 设置 车船税
	 * @param carBoatTax 车船税
	 * @return 当前对象
	*/
	public VehicleInfo setCarBoatTax(BigDecimal carBoatTax) {
		this.carBoatTax=carBoatTax;
		return this;
	}
	
	/**
	 * 获得 抢险<br>
	 * 元)
	 * @return 抢险
	*/
	public BigDecimal getRescueMoney() {
		return rescueMoney;
	}
	
	/**
	 * 设置 抢险
	 * @param rescueMoney 抢险
	 * @return 当前对象
	*/
	public VehicleInfo setRescueMoney(BigDecimal rescueMoney) {
		this.rescueMoney=rescueMoney;
		return this;
	}
	
	/**
	 * 获得 商业险<br>
	 * 元)
	 * @return 商业险
	*/
	public BigDecimal getCommercialInsuranceMoney() {
		return commercialInsuranceMoney;
	}
	
	/**
	 * 设置 商业险
	 * @param commercialInsuranceMoney 商业险
	 * @return 当前对象
	*/
	public VehicleInfo setCommercialInsuranceMoney(BigDecimal commercialInsuranceMoney) {
		this.commercialInsuranceMoney=commercialInsuranceMoney;
		return this;
	}
	
	/**
	 * 获得 保险公司<br>
	 * 保险公司
	 * @return 保险公司
	*/
	public String getInsuranceCompany() {
		return insuranceCompany;
	}
	
	/**
	 * 设置 保险公司
	 * @param insuranceCompany 保险公司
	 * @return 当前对象
	*/
	public VehicleInfo setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany=insuranceCompany;
		return this;
	}
	
	/**
	 * 获得 上牌时间<br>
	 * 上牌时间
	 * @return 上牌时间
	*/
	public Date getLicensingTime() {
		return licensingTime;
	}
	
	/**
	 * 设置 上牌时间
	 * @param licensingTime 上牌时间
	 * @return 当前对象
	*/
	public VehicleInfo setLicensingTime(Date licensingTime) {
		this.licensingTime=licensingTime;
		return this;
	}
	
	/**
	 * 获得 商业险到期<br>
	 * 商业险到期
	 * @return 商业险到期
	*/
	public Date getInsuranceExpireDate() {
		return insuranceExpireDate;
	}
	
	/**
	 * 设置 商业险到期
	 * @param insuranceExpireDate 商业险到期
	 * @return 当前对象
	*/
	public VehicleInfo setInsuranceExpireDate(Date insuranceExpireDate) {
		this.insuranceExpireDate=insuranceExpireDate;
		return this;
	}
	
	/**
	 * 获得 抢险到期<br>
	 * 抢险到期
	 * @return 抢险到期
	*/
	public Date getRescueDueDate() {
		return rescueDueDate;
	}
	
	/**
	 * 设置 抢险到期
	 * @param rescueDueDate 抢险到期
	 * @return 当前对象
	*/
	public VehicleInfo setRescueDueDate(Date rescueDueDate) {
		this.rescueDueDate=rescueDueDate;
		return this;
	}
	
	/**
	 * 获得 承载人数<br>
	 * 承载人数
	 * @return 承载人数
	*/
	public Integer getMaximumPassengers() {
		return maximumPassengers;
	}
	
	/**
	 * 设置 承载人数
	 * @param maximumPassengers 承载人数
	 * @return 当前对象
	*/
	public VehicleInfo setMaximumPassengers(Integer maximumPassengers) {
		this.maximumPassengers=maximumPassengers;
		return this;
	}
	
	/**
	 * 获得 报废时间<br>
	 * 报废时间
	 * @return 报废时间
	*/
	public Date getScrapTime() {
		return scrapTime;
	}
	
	/**
	 * 设置 报废时间
	 * @param scrapTime 报废时间
	 * @return 当前对象
	*/
	public VehicleInfo setScrapTime(Date scrapTime) {
		this.scrapTime=scrapTime;
		return this;
	}
	
	/**
	 * 获得 存放位置<br>
	 * 存放位置
	 * @return 存放位置
	*/
	public String getPositionId() {
		return positionId;
	}
	
	/**
	 * 设置 存放位置
	 * @param positionId 存放位置
	 * @return 当前对象
	*/
	public VehicleInfo setPositionId(String positionId) {
		this.positionId=positionId;
		return this;
	}
	
	/**
	 * 获得 位置详情<br>
	 * 位置详情
	 * @return 位置详情
	*/
	public String getPositionDetail() {
		return positionDetail;
	}
	
	/**
	 * 设置 位置详情
	 * @param positionDetail 位置详情
	 * @return 当前对象
	*/
	public VehicleInfo setPositionDetail(String positionDetail) {
		this.positionDetail=positionDetail;
		return this;
	}
	
	/**
	 * 获得 图片<br>
	 * 图片
	 * @return 图片
	*/
	public String getPictures() {
		return pictures;
	}
	
	/**
	 * 设置 图片
	 * @param pictures 图片
	 * @return 当前对象
	*/
	public VehicleInfo setPictures(String pictures) {
		this.pictures=pictures;
		return this;
	}
	
	/**
	 * 获得 技术参数<br>
	 * 技术参数
	 * @return 技术参数
	*/
	public String getTechnicalParameter() {
		return technicalParameter;
	}
	
	/**
	 * 设置 技术参数
	 * @param technicalParameter 技术参数
	 * @return 当前对象
	*/
	public VehicleInfo setTechnicalParameter(String technicalParameter) {
		this.technicalParameter=technicalParameter;
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
	public VehicleInfo setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
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
	public VehicleInfo setNotes(String notes) {
		this.notes=notes;
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
	public VehicleInfo setVersion(Integer version) {
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
	public VehicleInfo setCreateBy(String createBy) {
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
	public VehicleInfo setCreateTime(Date createTime) {
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
	public VehicleInfo setUpdateBy(String updateBy) {
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
	public VehicleInfo setUpdateTime(Date updateTime) {
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
	public VehicleInfo setDeleted(Integer deleted) {
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
	public VehicleInfo setDeleted(Boolean deletedBool) {
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
	public VehicleInfo setDeleteBy(String deleteBy) {
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
	public VehicleInfo setDeleteTime(Date deleteTime) {
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
	public VehicleInfo setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 所属公司<br>
	 * 所属公司
	 * @return 所属公司
	*/
	public Organization getOwnerCompany() {
		return ownerCompany;
	}
	
	/**
	 * 设置 所属公司
	 * @param ownerCompany 所属公司
	 * @return 当前对象
	*/
	public VehicleInfo setOwnerCompany(Organization ownerCompany) {
		this.ownerCompany=ownerCompany;
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
	public VehicleInfo setUseOrganization(Organization useOrganization) {
		this.useOrganization=useOrganization;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public DictItem getVehicleTypeDict() {
		return vehicleTypeDict;
	}
	
	/**
	 * 设置 类型
	 * @param vehicleTypeDict 类型
	 * @return 当前对象
	*/
	public VehicleInfo setVehicleTypeDict(DictItem vehicleTypeDict) {
		this.vehicleTypeDict=vehicleTypeDict;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public DictItem getVehicleStatusDict() {
		return vehicleStatusDict;
	}
	
	/**
	 * 设置 状态
	 * @param vehicleStatusDict 状态
	 * @return 当前对象
	*/
	public VehicleInfo setVehicleStatusDict(DictItem vehicleStatusDict) {
		this.vehicleStatusDict=vehicleStatusDict;
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
	public VehicleInfo setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 使用人<br>
	 * 使用人
	 * @return 使用人
	*/
	public Employee getUseUser() {
		return useUser;
	}
	
	/**
	 * 设置 使用人
	 * @param useUser 使用人
	 * @return 当前对象
	*/
	public VehicleInfo setUseUser(Employee useUser) {
		this.useUser=useUser;
		return this;
	}
	
	/**
	 * 获得 vehicleInsuranceCompany<br>
	 * vehicleInsuranceCompany
	 * @return vehicleInsuranceCompany
	*/
	public VehicleInsuranceCompany getVehicleInsuranceCompany() {
		return vehicleInsuranceCompany;
	}
	
	/**
	 * 设置 vehicleInsuranceCompany
	 * @param vehicleInsuranceCompany vehicleInsuranceCompany
	 * @return 当前对象
	*/
	public VehicleInfo setVehicleInsuranceCompany(VehicleInsuranceCompany vehicleInsuranceCompany) {
		this.vehicleInsuranceCompany=vehicleInsuranceCompany;
		return this;
	}
	
	/**
	 * 获得 车辆列表<br>
	 * 车辆列表
	 * @return 车辆列表
	*/
	public String getSelectIds() {
		return selectIds;
	}
	
	/**
	 * 设置 车辆列表
	 * @param selectIds 车辆列表
	 * @return 当前对象
	*/
	public VehicleInfo setSelectIds(String selectIds) {
		this.selectIds=selectIds;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return VehicleInfo , 转换好的 VehicleInfo 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return VehicleInfo , 转换好的 PoJo 对象
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
	public VehicleInfo clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public VehicleInfo duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.VehicleInfoMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.VehicleInfoMeta.$$proxy$$();
		inst.setRescueDueDate(this.getRescueDueDate());
		inst.setNotes(this.getNotes());
		inst.setColor(this.getColor());
		inst.setMaximumPassengers(this.getMaximumPassengers());
		inst.setRescueMoney(this.getRescueMoney());
		inst.setType(this.getType());
		inst.setManageUserId(this.getManageUserId());
		inst.setScrapTime(this.getScrapTime());
		inst.setPictures(this.getPictures());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setCommercialInsuranceMoney(this.getCommercialInsuranceMoney());
		inst.setModel(this.getModel());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setInsuranceCompany(this.getInsuranceCompany());
		inst.setFrameNumber(this.getFrameNumber());
		inst.setUseOrgId(this.getUseOrgId());
		inst.setEngineNumber(this.getEngineNumber());
		inst.setVehicleCode(this.getVehicleCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setInsuranceExpireDate(this.getInsuranceExpireDate());
		inst.setVersion(this.getVersion());
		inst.setPositionDetail(this.getPositionDetail());
		inst.setTechnicalParameter(this.getTechnicalParameter());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPositionId(this.getPositionId());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDrivingLicense(this.getDrivingLicense());
		inst.setKilometers(this.getKilometers());
		inst.setName(this.getName());
		inst.setLicensingTime(this.getLicensingTime());
		inst.setTenantId(this.getTenantId());
		inst.setOwnerOrgId(this.getOwnerOrgId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setRegistrant(this.getRegistrant());
		inst.setCarBoatTax(this.getCarBoatTax());
		inst.setUseUserId(this.getUseUserId());
		inst.setVehicleStatus(this.getVehicleStatus());
		if(all) {
			inst.setOwnerCompany(this.getOwnerCompany());
			inst.setUseOrganization(this.getUseOrganization());
			inst.setVehicleInsuranceCompany(this.getVehicleInsuranceCompany());
			inst.setVehicleTypeDict(this.getVehicleTypeDict());
			inst.setVehicleStatusDict(this.getVehicleStatusDict());
			inst.setOriginator(this.getOriginator());
			inst.setSelectIds(this.getSelectIds());
			inst.setUseUser(this.getUseUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public VehicleInfo clone(boolean deep) {
		return EntityContext.clone(VehicleInfo.class,this,deep);
	}

	/**
	 * 将 Map 转换成 VehicleInfo
	 * @param vehicleInfoMap 包含实体信息的 Map 对象
	 * @return VehicleInfo , 转换好的的 VehicleInfo 对象
	*/
	@Transient
	public static VehicleInfo createFrom(Map<String,Object> vehicleInfoMap) {
		if(vehicleInfoMap==null) return null;
		VehicleInfo po = create();
		EntityContext.copyProperties(po,vehicleInfoMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 VehicleInfo
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return VehicleInfo , 转换好的的 VehicleInfo 对象
	*/
	@Transient
	public static VehicleInfo createFrom(Object pojo) {
		if(pojo==null) return null;
		VehicleInfo po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 VehicleInfo，等同于 new
	 * @return VehicleInfo 对象
	*/
	@Transient
	public static VehicleInfo create() {
		return new com.dt.platform.domain.oa.meta.VehicleInfoMeta.$$proxy$$();
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
			this.setRescueDueDate(DataParser.parse(Date.class, map.get(VehicleInfoMeta.RESCUE_DUE_DATE)));
			this.setNotes(DataParser.parse(String.class, map.get(VehicleInfoMeta.NOTES)));
			this.setColor(DataParser.parse(String.class, map.get(VehicleInfoMeta.COLOR)));
			this.setMaximumPassengers(DataParser.parse(Integer.class, map.get(VehicleInfoMeta.MAXIMUM_PASSENGERS)));
			this.setRescueMoney(DataParser.parse(BigDecimal.class, map.get(VehicleInfoMeta.RESCUE_MONEY)));
			this.setType(DataParser.parse(String.class, map.get(VehicleInfoMeta.TYPE)));
			this.setManageUserId(DataParser.parse(String.class, map.get(VehicleInfoMeta.MANAGE_USER_ID)));
			this.setScrapTime(DataParser.parse(Date.class, map.get(VehicleInfoMeta.SCRAP_TIME)));
			this.setPictures(DataParser.parse(String.class, map.get(VehicleInfoMeta.PICTURES)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(VehicleInfoMeta.UPDATE_BY)));
			this.setCommercialInsuranceMoney(DataParser.parse(BigDecimal.class, map.get(VehicleInfoMeta.COMMERCIAL_INSURANCE_MONEY)));
			this.setModel(DataParser.parse(String.class, map.get(VehicleInfoMeta.MODEL)));
			this.setId(DataParser.parse(String.class, map.get(VehicleInfoMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(VehicleInfoMeta.ORIGINATOR_ID)));
			this.setInsuranceCompany(DataParser.parse(String.class, map.get(VehicleInfoMeta.INSURANCE_COMPANY)));
			this.setFrameNumber(DataParser.parse(String.class, map.get(VehicleInfoMeta.FRAME_NUMBER)));
			this.setUseOrgId(DataParser.parse(String.class, map.get(VehicleInfoMeta.USE_ORG_ID)));
			this.setEngineNumber(DataParser.parse(String.class, map.get(VehicleInfoMeta.ENGINE_NUMBER)));
			this.setVehicleCode(DataParser.parse(String.class, map.get(VehicleInfoMeta.VEHICLE_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(VehicleInfoMeta.UPDATE_TIME)));
			this.setInsuranceExpireDate(DataParser.parse(Date.class, map.get(VehicleInfoMeta.INSURANCE_EXPIRE_DATE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(VehicleInfoMeta.VERSION)));
			this.setPositionDetail(DataParser.parse(String.class, map.get(VehicleInfoMeta.POSITION_DETAIL)));
			this.setTechnicalParameter(DataParser.parse(String.class, map.get(VehicleInfoMeta.TECHNICAL_PARAMETER)));
			this.setCreateBy(DataParser.parse(String.class, map.get(VehicleInfoMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(VehicleInfoMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, map.get(VehicleInfoMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(VehicleInfoMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(VehicleInfoMeta.DELETE_TIME)));
			this.setDrivingLicense(DataParser.parse(String.class, map.get(VehicleInfoMeta.DRIVING_LICENSE)));
			this.setKilometers(DataParser.parse(BigDecimal.class, map.get(VehicleInfoMeta.KILOMETERS)));
			this.setName(DataParser.parse(String.class, map.get(VehicleInfoMeta.NAME)));
			this.setLicensingTime(DataParser.parse(Date.class, map.get(VehicleInfoMeta.LICENSING_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(VehicleInfoMeta.TENANT_ID)));
			this.setOwnerOrgId(DataParser.parse(String.class, map.get(VehicleInfoMeta.OWNER_ORG_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(VehicleInfoMeta.DELETE_BY)));
			this.setRegistrant(DataParser.parse(String.class, map.get(VehicleInfoMeta.REGISTRANT)));
			this.setCarBoatTax(DataParser.parse(BigDecimal.class, map.get(VehicleInfoMeta.CAR_BOAT_TAX)));
			this.setUseUserId(DataParser.parse(String.class, map.get(VehicleInfoMeta.USE_USER_ID)));
			this.setVehicleStatus(DataParser.parse(String.class, map.get(VehicleInfoMeta.VEHICLE_STATUS)));
			// others
			this.setOwnerCompany(DataParser.parse(Organization.class, map.get(VehicleInfoMeta.OWNER_COMPANY)));
			this.setUseOrganization(DataParser.parse(Organization.class, map.get(VehicleInfoMeta.USE_ORGANIZATION)));
			this.setVehicleInsuranceCompany(DataParser.parse(VehicleInsuranceCompany.class, map.get(VehicleInfoMeta.VEHICLE_INSURANCE_COMPANY)));
			this.setVehicleTypeDict(DataParser.parse(DictItem.class, map.get(VehicleInfoMeta.VEHICLE_TYPE_DICT)));
			this.setVehicleStatusDict(DataParser.parse(DictItem.class, map.get(VehicleInfoMeta.VEHICLE_STATUS_DICT)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(VehicleInfoMeta.ORIGINATOR)));
			this.setSelectIds(DataParser.parse(String.class, map.get(VehicleInfoMeta.SELECT_IDS)));
			this.setUseUser(DataParser.parse(Employee.class, map.get(VehicleInfoMeta.USE_USER)));
			return true;
		} else {
			try {
				this.setRescueDueDate( (Date)map.get(VehicleInfoMeta.RESCUE_DUE_DATE));
				this.setNotes( (String)map.get(VehicleInfoMeta.NOTES));
				this.setColor( (String)map.get(VehicleInfoMeta.COLOR));
				this.setMaximumPassengers( (Integer)map.get(VehicleInfoMeta.MAXIMUM_PASSENGERS));
				this.setRescueMoney( (BigDecimal)map.get(VehicleInfoMeta.RESCUE_MONEY));
				this.setType( (String)map.get(VehicleInfoMeta.TYPE));
				this.setManageUserId( (String)map.get(VehicleInfoMeta.MANAGE_USER_ID));
				this.setScrapTime( (Date)map.get(VehicleInfoMeta.SCRAP_TIME));
				this.setPictures( (String)map.get(VehicleInfoMeta.PICTURES));
				this.setUpdateBy( (String)map.get(VehicleInfoMeta.UPDATE_BY));
				this.setCommercialInsuranceMoney( (BigDecimal)map.get(VehicleInfoMeta.COMMERCIAL_INSURANCE_MONEY));
				this.setModel( (String)map.get(VehicleInfoMeta.MODEL));
				this.setId( (String)map.get(VehicleInfoMeta.ID));
				this.setOriginatorId( (String)map.get(VehicleInfoMeta.ORIGINATOR_ID));
				this.setInsuranceCompany( (String)map.get(VehicleInfoMeta.INSURANCE_COMPANY));
				this.setFrameNumber( (String)map.get(VehicleInfoMeta.FRAME_NUMBER));
				this.setUseOrgId( (String)map.get(VehicleInfoMeta.USE_ORG_ID));
				this.setEngineNumber( (String)map.get(VehicleInfoMeta.ENGINE_NUMBER));
				this.setVehicleCode( (String)map.get(VehicleInfoMeta.VEHICLE_CODE));
				this.setUpdateTime( (Date)map.get(VehicleInfoMeta.UPDATE_TIME));
				this.setInsuranceExpireDate( (Date)map.get(VehicleInfoMeta.INSURANCE_EXPIRE_DATE));
				this.setVersion( (Integer)map.get(VehicleInfoMeta.VERSION));
				this.setPositionDetail( (String)map.get(VehicleInfoMeta.POSITION_DETAIL));
				this.setTechnicalParameter( (String)map.get(VehicleInfoMeta.TECHNICAL_PARAMETER));
				this.setCreateBy( (String)map.get(VehicleInfoMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(VehicleInfoMeta.DELETED));
				this.setPositionId( (String)map.get(VehicleInfoMeta.POSITION_ID));
				this.setCreateTime( (Date)map.get(VehicleInfoMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(VehicleInfoMeta.DELETE_TIME));
				this.setDrivingLicense( (String)map.get(VehicleInfoMeta.DRIVING_LICENSE));
				this.setKilometers( (BigDecimal)map.get(VehicleInfoMeta.KILOMETERS));
				this.setName( (String)map.get(VehicleInfoMeta.NAME));
				this.setLicensingTime( (Date)map.get(VehicleInfoMeta.LICENSING_TIME));
				this.setTenantId( (String)map.get(VehicleInfoMeta.TENANT_ID));
				this.setOwnerOrgId( (String)map.get(VehicleInfoMeta.OWNER_ORG_ID));
				this.setDeleteBy( (String)map.get(VehicleInfoMeta.DELETE_BY));
				this.setRegistrant( (String)map.get(VehicleInfoMeta.REGISTRANT));
				this.setCarBoatTax( (BigDecimal)map.get(VehicleInfoMeta.CAR_BOAT_TAX));
				this.setUseUserId( (String)map.get(VehicleInfoMeta.USE_USER_ID));
				this.setVehicleStatus( (String)map.get(VehicleInfoMeta.VEHICLE_STATUS));
				// others
				this.setOwnerCompany( (Organization)map.get(VehicleInfoMeta.OWNER_COMPANY));
				this.setUseOrganization( (Organization)map.get(VehicleInfoMeta.USE_ORGANIZATION));
				this.setVehicleInsuranceCompany( (VehicleInsuranceCompany)map.get(VehicleInfoMeta.VEHICLE_INSURANCE_COMPANY));
				this.setVehicleTypeDict( (DictItem)map.get(VehicleInfoMeta.VEHICLE_TYPE_DICT));
				this.setVehicleStatusDict( (DictItem)map.get(VehicleInfoMeta.VEHICLE_STATUS_DICT));
				this.setOriginator( (Employee)map.get(VehicleInfoMeta.ORIGINATOR));
				this.setSelectIds( (String)map.get(VehicleInfoMeta.SELECT_IDS));
				this.setUseUser( (Employee)map.get(VehicleInfoMeta.USE_USER));
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
			this.setRescueDueDate(DataParser.parse(Date.class, r.getValue(VehicleInfoMeta.RESCUE_DUE_DATE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.NOTES)));
			this.setColor(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.COLOR)));
			this.setMaximumPassengers(DataParser.parse(Integer.class, r.getValue(VehicleInfoMeta.MAXIMUM_PASSENGERS)));
			this.setRescueMoney(DataParser.parse(BigDecimal.class, r.getValue(VehicleInfoMeta.RESCUE_MONEY)));
			this.setType(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.TYPE)));
			this.setManageUserId(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.MANAGE_USER_ID)));
			this.setScrapTime(DataParser.parse(Date.class, r.getValue(VehicleInfoMeta.SCRAP_TIME)));
			this.setPictures(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.PICTURES)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.UPDATE_BY)));
			this.setCommercialInsuranceMoney(DataParser.parse(BigDecimal.class, r.getValue(VehicleInfoMeta.COMMERCIAL_INSURANCE_MONEY)));
			this.setModel(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.MODEL)));
			this.setId(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.ORIGINATOR_ID)));
			this.setInsuranceCompany(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.INSURANCE_COMPANY)));
			this.setFrameNumber(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.FRAME_NUMBER)));
			this.setUseOrgId(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.USE_ORG_ID)));
			this.setEngineNumber(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.ENGINE_NUMBER)));
			this.setVehicleCode(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.VEHICLE_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(VehicleInfoMeta.UPDATE_TIME)));
			this.setInsuranceExpireDate(DataParser.parse(Date.class, r.getValue(VehicleInfoMeta.INSURANCE_EXPIRE_DATE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(VehicleInfoMeta.VERSION)));
			this.setPositionDetail(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.POSITION_DETAIL)));
			this.setTechnicalParameter(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.TECHNICAL_PARAMETER)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(VehicleInfoMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(VehicleInfoMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(VehicleInfoMeta.DELETE_TIME)));
			this.setDrivingLicense(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.DRIVING_LICENSE)));
			this.setKilometers(DataParser.parse(BigDecimal.class, r.getValue(VehicleInfoMeta.KILOMETERS)));
			this.setName(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.NAME)));
			this.setLicensingTime(DataParser.parse(Date.class, r.getValue(VehicleInfoMeta.LICENSING_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.TENANT_ID)));
			this.setOwnerOrgId(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.OWNER_ORG_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.DELETE_BY)));
			this.setRegistrant(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.REGISTRANT)));
			this.setCarBoatTax(DataParser.parse(BigDecimal.class, r.getValue(VehicleInfoMeta.CAR_BOAT_TAX)));
			this.setUseUserId(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.USE_USER_ID)));
			this.setVehicleStatus(DataParser.parse(String.class, r.getValue(VehicleInfoMeta.VEHICLE_STATUS)));
			return true;
		} else {
			try {
				this.setRescueDueDate( (Date)r.getValue(VehicleInfoMeta.RESCUE_DUE_DATE));
				this.setNotes( (String)r.getValue(VehicleInfoMeta.NOTES));
				this.setColor( (String)r.getValue(VehicleInfoMeta.COLOR));
				this.setMaximumPassengers( (Integer)r.getValue(VehicleInfoMeta.MAXIMUM_PASSENGERS));
				this.setRescueMoney( (BigDecimal)r.getValue(VehicleInfoMeta.RESCUE_MONEY));
				this.setType( (String)r.getValue(VehicleInfoMeta.TYPE));
				this.setManageUserId( (String)r.getValue(VehicleInfoMeta.MANAGE_USER_ID));
				this.setScrapTime( (Date)r.getValue(VehicleInfoMeta.SCRAP_TIME));
				this.setPictures( (String)r.getValue(VehicleInfoMeta.PICTURES));
				this.setUpdateBy( (String)r.getValue(VehicleInfoMeta.UPDATE_BY));
				this.setCommercialInsuranceMoney( (BigDecimal)r.getValue(VehicleInfoMeta.COMMERCIAL_INSURANCE_MONEY));
				this.setModel( (String)r.getValue(VehicleInfoMeta.MODEL));
				this.setId( (String)r.getValue(VehicleInfoMeta.ID));
				this.setOriginatorId( (String)r.getValue(VehicleInfoMeta.ORIGINATOR_ID));
				this.setInsuranceCompany( (String)r.getValue(VehicleInfoMeta.INSURANCE_COMPANY));
				this.setFrameNumber( (String)r.getValue(VehicleInfoMeta.FRAME_NUMBER));
				this.setUseOrgId( (String)r.getValue(VehicleInfoMeta.USE_ORG_ID));
				this.setEngineNumber( (String)r.getValue(VehicleInfoMeta.ENGINE_NUMBER));
				this.setVehicleCode( (String)r.getValue(VehicleInfoMeta.VEHICLE_CODE));
				this.setUpdateTime( (Date)r.getValue(VehicleInfoMeta.UPDATE_TIME));
				this.setInsuranceExpireDate( (Date)r.getValue(VehicleInfoMeta.INSURANCE_EXPIRE_DATE));
				this.setVersion( (Integer)r.getValue(VehicleInfoMeta.VERSION));
				this.setPositionDetail( (String)r.getValue(VehicleInfoMeta.POSITION_DETAIL));
				this.setTechnicalParameter( (String)r.getValue(VehicleInfoMeta.TECHNICAL_PARAMETER));
				this.setCreateBy( (String)r.getValue(VehicleInfoMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(VehicleInfoMeta.DELETED));
				this.setPositionId( (String)r.getValue(VehicleInfoMeta.POSITION_ID));
				this.setCreateTime( (Date)r.getValue(VehicleInfoMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(VehicleInfoMeta.DELETE_TIME));
				this.setDrivingLicense( (String)r.getValue(VehicleInfoMeta.DRIVING_LICENSE));
				this.setKilometers( (BigDecimal)r.getValue(VehicleInfoMeta.KILOMETERS));
				this.setName( (String)r.getValue(VehicleInfoMeta.NAME));
				this.setLicensingTime( (Date)r.getValue(VehicleInfoMeta.LICENSING_TIME));
				this.setTenantId( (String)r.getValue(VehicleInfoMeta.TENANT_ID));
				this.setOwnerOrgId( (String)r.getValue(VehicleInfoMeta.OWNER_ORG_ID));
				this.setDeleteBy( (String)r.getValue(VehicleInfoMeta.DELETE_BY));
				this.setRegistrant( (String)r.getValue(VehicleInfoMeta.REGISTRANT));
				this.setCarBoatTax( (BigDecimal)r.getValue(VehicleInfoMeta.CAR_BOAT_TAX));
				this.setUseUserId( (String)r.getValue(VehicleInfoMeta.USE_USER_ID));
				this.setVehicleStatus( (String)r.getValue(VehicleInfoMeta.VEHICLE_STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}