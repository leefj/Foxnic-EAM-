package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_DEVICE_SP;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.DeviceSpMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 备件清单
 * <p>备件清单 , 数据表 eam_device_sp 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-28 19:35:23
 * @sign BB787D04C60AD42747ADA65ABAE4D8CE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_device_sp")
@ApiModel(description = "备件清单 ; 备件清单 , 数据表 eam_device_sp 的PO类型")
public class DeviceSp extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_DEVICE_SP.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "732559269756403712")
	private String id;
	
	/**
	 * 备件编号：备件编号
	*/
	@ApiModelProperty(required = false,value="备件编号" , notes = "备件编号" , example = "12")
	private String code;
	
	/**
	 * 物品档案：物品档案
	*/
	@ApiModelProperty(required = false,value="物品档案" , notes = "物品档案")
	private String goodId;
	
	/**
	 * 备件类型：备件类型
	*/
	@ApiModelProperty(required = false,value="备件类型" , notes = "备件类型" , example = "732552973493731329")
	private String type;
	
	/**
	 * 备件状态：备件状态
	*/
	@ApiModelProperty(required = false,value="备件状态" , notes = "备件状态")
	private String status;
	
	/**
	 * 备件名称：备件名称
	*/
	@ApiModelProperty(required = false,value="备件名称" , notes = "备件名称" , example = "12")
	private String name;
	
	/**
	 * 所在仓库：所在仓库
	*/
	@ApiModelProperty(required = false,value="所在仓库" , notes = "所在仓库")
	private String warehouseId;
	
	/**
	 * 规格型号：规格型号
	*/
	@ApiModelProperty(required = false,value="规格型号" , notes = "规格型号")
	private String model;
	
	/**
	 * 备件序列：备件序列
	*/
	@ApiModelProperty(required = false,value="备件序列" , notes = "备件序列" , example = "12")
	private String sn;
	
	/**
	 * 使用场景：使用场景
	*/
	@ApiModelProperty(required = false,value="使用场景" , notes = "使用场景")
	private String usageRange;
	
	/**
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置" , example = "616018653535535104")
	private String locId;
	
	/**
	 * 适配信息：适配信息
	*/
	@ApiModelProperty(required = false,value="适配信息" , notes = "适配信息")
	private String adaptingDevice;
	
	/**
	 * 来源描述：来源描述
	*/
	@ApiModelProperty(required = false,value="来源描述" , notes = "来源描述" , example = "1")
	private String sourceDesc;
	
	/**
	 * 供应厂商：供应厂商
	*/
	@ApiModelProperty(required = false,value="供应厂商" , notes = "供应厂商")
	private String supplier;
	
	/**
	 * 保管人员：保管人员
	*/
	@ApiModelProperty(required = false,value="保管人员" , notes = "保管人员" , example = "581798649571311616")
	private String managerUserId;
	
	/**
	 * 入库时间：入库时间
	*/
	@ApiModelProperty(required = false,value="入库时间" , notes = "入库时间" , example = "2023-07-14 12:00:00")
	private Date insertTime;
	
	/**
	 * 图片：图片
	*/
	@ApiModelProperty(required = false,value="图片" , notes = "图片")
	private String pictureId;
	
	/**
	 * 数量：数量
	*/
	@ApiModelProperty(required = false,value="数量" , notes = "数量")
	private Integer spNumber;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "1212")
	private String notes;
	
	/**
	 * 是否锁定：是否锁定
	*/
	@ApiModelProperty(required = false,value="是否锁定" , notes = "是否锁定")
	private String locked;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-07-15 11:29:00")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-07-17 08:48:41")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "1")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID" , example = "110588348101165911")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间" , example = "2023-07-17 08:48:41")
	private Date deleteTime;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "2")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * goods：goods
	*/
	@ApiModelProperty(required = false,value="goods" , notes = "goods")
	private Goods goods;
	
	/**
	 * deviceSpType：deviceSpType
	*/
	@ApiModelProperty(required = false,value="deviceSpType" , notes = "deviceSpType")
	private DeviceSpType deviceSpType;
	
	/**
	 * manager：manager
	*/
	@ApiModelProperty(required = false,value="manager" , notes = "manager")
	private Employee manager;
	
	/**
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置")
	private Position position;
	
	/**
	 * usage：usage
	*/
	@ApiModelProperty(required = false,value="usage" , notes = "usage")
	private DictItem usage;
	
	/**
	 * assetList：assetList
	*/
	@ApiModelProperty(required = false,value="assetList" , notes = "assetList")
	private List<Asset> assetList;
	
	/**
	 * deviceAssociate：deviceAssociate
	*/
	@ApiModelProperty(required = false,value="deviceAssociate" , notes = "deviceAssociate")
	private List<DeviceAssociate> deviceAssociate;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private Warehouse warehouse;
	
	/**
	 * ownerType：ownerType
	*/
	@ApiModelProperty(required = false,value="ownerType" , notes = "ownerType")
	private String ownerType;
	
	/**
	 * selectedCode：selectedCode
	*/
	@ApiModelProperty(required = false,value="selectedCode" , notes = "selectedCode")
	private String selectedCode;
	
	/**
	 * ownerId：ownerId
	*/
	@ApiModelProperty(required = false,value="ownerId" , notes = "ownerId")
	private String ownerId;
	
	/**
	 * psCategoryId：psCategoryId
	*/
	@ApiModelProperty(required = false,value="psCategoryId" , notes = "psCategoryId")
	private String psCategoryId;
	
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
	public DeviceSp setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 备件编号<br>
	 * 备件编号
	 * @return 备件编号
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 备件编号
	 * @param code 备件编号
	 * @return 当前对象
	*/
	public DeviceSp setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 物品档案<br>
	 * 物品档案
	 * @return 物品档案
	*/
	public String getGoodId() {
		return goodId;
	}
	
	/**
	 * 设置 物品档案
	 * @param goodId 物品档案
	 * @return 当前对象
	*/
	public DeviceSp setGoodId(String goodId) {
		this.goodId=goodId;
		return this;
	}
	
	/**
	 * 获得 备件类型<br>
	 * 备件类型
	 * @return 备件类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 备件类型
	 * @param type 备件类型
	 * @return 当前对象
	*/
	public DeviceSp setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 备件状态<br>
	 * 备件状态
	 * @return 备件状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 备件状态
	 * @param status 备件状态
	 * @return 当前对象
	*/
	public DeviceSp setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 备件名称<br>
	 * 备件名称
	 * @return 备件名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 备件名称
	 * @param name 备件名称
	 * @return 当前对象
	*/
	public DeviceSp setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 所在仓库<br>
	 * 所在仓库
	 * @return 所在仓库
	*/
	public String getWarehouseId() {
		return warehouseId;
	}
	
	/**
	 * 设置 所在仓库
	 * @param warehouseId 所在仓库
	 * @return 当前对象
	*/
	public DeviceSp setWarehouseId(String warehouseId) {
		this.warehouseId=warehouseId;
		return this;
	}
	
	/**
	 * 获得 规格型号<br>
	 * 规格型号
	 * @return 规格型号
	*/
	public String getModel() {
		return model;
	}
	
	/**
	 * 设置 规格型号
	 * @param model 规格型号
	 * @return 当前对象
	*/
	public DeviceSp setModel(String model) {
		this.model=model;
		return this;
	}
	
	/**
	 * 获得 备件序列<br>
	 * 备件序列
	 * @return 备件序列
	*/
	public String getSn() {
		return sn;
	}
	
	/**
	 * 设置 备件序列
	 * @param sn 备件序列
	 * @return 当前对象
	*/
	public DeviceSp setSn(String sn) {
		this.sn=sn;
		return this;
	}
	
	/**
	 * 获得 使用场景<br>
	 * 使用场景
	 * @return 使用场景
	*/
	public String getUsageRange() {
		return usageRange;
	}
	
	/**
	 * 设置 使用场景
	 * @param usageRange 使用场景
	 * @return 当前对象
	*/
	public DeviceSp setUsageRange(String usageRange) {
		this.usageRange=usageRange;
		return this;
	}
	
	/**
	 * 获得 存放位置<br>
	 * 存放位置
	 * @return 存放位置
	*/
	public String getLocId() {
		return locId;
	}
	
	/**
	 * 设置 存放位置
	 * @param locId 存放位置
	 * @return 当前对象
	*/
	public DeviceSp setLocId(String locId) {
		this.locId=locId;
		return this;
	}
	
	/**
	 * 获得 适配信息<br>
	 * 适配信息
	 * @return 适配信息
	*/
	public String getAdaptingDevice() {
		return adaptingDevice;
	}
	
	/**
	 * 设置 适配信息
	 * @param adaptingDevice 适配信息
	 * @return 当前对象
	*/
	public DeviceSp setAdaptingDevice(String adaptingDevice) {
		this.adaptingDevice=adaptingDevice;
		return this;
	}
	
	/**
	 * 获得 来源描述<br>
	 * 来源描述
	 * @return 来源描述
	*/
	public String getSourceDesc() {
		return sourceDesc;
	}
	
	/**
	 * 设置 来源描述
	 * @param sourceDesc 来源描述
	 * @return 当前对象
	*/
	public DeviceSp setSourceDesc(String sourceDesc) {
		this.sourceDesc=sourceDesc;
		return this;
	}
	
	/**
	 * 获得 供应厂商<br>
	 * 供应厂商
	 * @return 供应厂商
	*/
	public String getSupplier() {
		return supplier;
	}
	
	/**
	 * 设置 供应厂商
	 * @param supplier 供应厂商
	 * @return 当前对象
	*/
	public DeviceSp setSupplier(String supplier) {
		this.supplier=supplier;
		return this;
	}
	
	/**
	 * 获得 保管人员<br>
	 * 保管人员
	 * @return 保管人员
	*/
	public String getManagerUserId() {
		return managerUserId;
	}
	
	/**
	 * 设置 保管人员
	 * @param managerUserId 保管人员
	 * @return 当前对象
	*/
	public DeviceSp setManagerUserId(String managerUserId) {
		this.managerUserId=managerUserId;
		return this;
	}
	
	/**
	 * 获得 入库时间<br>
	 * 入库时间
	 * @return 入库时间
	*/
	public Date getInsertTime() {
		return insertTime;
	}
	
	/**
	 * 设置 入库时间
	 * @param insertTime 入库时间
	 * @return 当前对象
	*/
	public DeviceSp setInsertTime(Date insertTime) {
		this.insertTime=insertTime;
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
	public DeviceSp setPictureId(String pictureId) {
		this.pictureId=pictureId;
		return this;
	}
	
	/**
	 * 获得 数量<br>
	 * 数量
	 * @return 数量
	*/
	public Integer getSpNumber() {
		return spNumber;
	}
	
	/**
	 * 设置 数量
	 * @param spNumber 数量
	 * @return 当前对象
	*/
	public DeviceSp setSpNumber(Integer spNumber) {
		this.spNumber=spNumber;
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
	public DeviceSp setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 是否锁定<br>
	 * 是否锁定
	 * @return 是否锁定
	*/
	public String getLocked() {
		return locked;
	}
	
	/**
	 * 设置 是否锁定
	 * @param locked 是否锁定
	 * @return 当前对象
	*/
	public DeviceSp setLocked(String locked) {
		this.locked=locked;
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
	public DeviceSp setCreateBy(String createBy) {
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
	public DeviceSp setCreateTime(Date createTime) {
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
	public DeviceSp setUpdateBy(String updateBy) {
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
	public DeviceSp setUpdateTime(Date updateTime) {
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
	public DeviceSp setDeleted(Integer deleted) {
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
	public DeviceSp setDeleted(Boolean deletedBool) {
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
	public DeviceSp setDeleteBy(String deleteBy) {
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
	public DeviceSp setDeleteTime(Date deleteTime) {
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
	public DeviceSp setVersion(Integer version) {
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
	public DeviceSp setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 goods<br>
	 * goods
	 * @return goods
	*/
	public Goods getGoods() {
		return goods;
	}
	
	/**
	 * 设置 goods
	 * @param goods goods
	 * @return 当前对象
	*/
	public DeviceSp setGoods(Goods goods) {
		this.goods=goods;
		return this;
	}
	
	/**
	 * 获得 deviceSpType<br>
	 * deviceSpType
	 * @return deviceSpType
	*/
	public DeviceSpType getDeviceSpType() {
		return deviceSpType;
	}
	
	/**
	 * 设置 deviceSpType
	 * @param deviceSpType deviceSpType
	 * @return 当前对象
	*/
	public DeviceSp setDeviceSpType(DeviceSpType deviceSpType) {
		this.deviceSpType=deviceSpType;
		return this;
	}
	
	/**
	 * 获得 manager<br>
	 * manager
	 * @return manager
	*/
	public Employee getManager() {
		return manager;
	}
	
	/**
	 * 设置 manager
	 * @param manager manager
	 * @return 当前对象
	*/
	public DeviceSp setManager(Employee manager) {
		this.manager=manager;
		return this;
	}
	
	/**
	 * 获得 存放位置<br>
	 * 存放位置
	 * @return 存放位置
	*/
	public Position getPosition() {
		return position;
	}
	
	/**
	 * 设置 存放位置
	 * @param position 存放位置
	 * @return 当前对象
	*/
	public DeviceSp setPosition(Position position) {
		this.position=position;
		return this;
	}
	
	/**
	 * 获得 usage<br>
	 * usage
	 * @return usage
	*/
	public DictItem getUsage() {
		return usage;
	}
	
	/**
	 * 设置 usage
	 * @param usage usage
	 * @return 当前对象
	*/
	public DeviceSp setUsage(DictItem usage) {
		this.usage=usage;
		return this;
	}
	
	/**
	 * 获得 assetList<br>
	 * assetList
	 * @return assetList
	*/
	public List<Asset> getAssetList() {
		return assetList;
	}
	
	/**
	 * 设置 assetList
	 * @param assetList assetList
	 * @return 当前对象
	*/
	public DeviceSp setAssetList(List<Asset> assetList) {
		this.assetList=assetList;
		return this;
	}
	
	/**
	 * 添加 assetList
	 * @param asset assetList
	 * @return 当前对象
	*/
	public DeviceSp addAsset(Asset... asset) {
		if(this.assetList==null) assetList=new ArrayList<>();
		this.assetList.addAll(Arrays.asList(asset));
		return this;
	}
	
	/**
	 * 获得 deviceAssociate<br>
	 * deviceAssociate
	 * @return deviceAssociate
	*/
	public List<DeviceAssociate> getDeviceAssociate() {
		return deviceAssociate;
	}
	
	/**
	 * 设置 deviceAssociate
	 * @param deviceAssociate deviceAssociate
	 * @return 当前对象
	*/
	public DeviceSp setDeviceAssociate(List<DeviceAssociate> deviceAssociate) {
		this.deviceAssociate=deviceAssociate;
		return this;
	}
	
	/**
	 * 添加 deviceAssociate
	 * @param entity deviceAssociate
	 * @return 当前对象
	*/
	public DeviceSp addDeviceAssociate(DeviceAssociate... entity) {
		if(this.deviceAssociate==null) deviceAssociate=new ArrayList<>();
		this.deviceAssociate.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 仓库<br>
	 * 仓库
	 * @return 仓库
	*/
	public Warehouse getWarehouse() {
		return warehouse;
	}
	
	/**
	 * 设置 仓库
	 * @param warehouse 仓库
	 * @return 当前对象
	*/
	public DeviceSp setWarehouse(Warehouse warehouse) {
		this.warehouse=warehouse;
		return this;
	}
	
	/**
	 * 获得 ownerType<br>
	 * ownerType
	 * @return ownerType
	*/
	public String getOwnerType() {
		return ownerType;
	}
	
	/**
	 * 设置 ownerType
	 * @param ownerType ownerType
	 * @return 当前对象
	*/
	public DeviceSp setOwnerType(String ownerType) {
		this.ownerType=ownerType;
		return this;
	}
	
	/**
	 * 获得 selectedCode<br>
	 * selectedCode
	 * @return selectedCode
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 selectedCode
	 * @param selectedCode selectedCode
	 * @return 当前对象
	*/
	public DeviceSp setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 ownerId<br>
	 * ownerId
	 * @return ownerId
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 ownerId
	 * @param ownerId ownerId
	 * @return 当前对象
	*/
	public DeviceSp setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 psCategoryId<br>
	 * psCategoryId
	 * @return psCategoryId
	*/
	public String getPsCategoryId() {
		return psCategoryId;
	}
	
	/**
	 * 设置 psCategoryId
	 * @param psCategoryId psCategoryId
	 * @return 当前对象
	*/
	public DeviceSp setPsCategoryId(String psCategoryId) {
		this.psCategoryId=psCategoryId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DeviceSp , 转换好的 DeviceSp 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DeviceSp , 转换好的 PoJo 对象
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
	public DeviceSp clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DeviceSp duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.DeviceSpMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.DeviceSpMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setType(this.getType());
		inst.setUsageRange(this.getUsageRange());
		inst.setPictureId(this.getPictureId());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setAdaptingDevice(this.getAdaptingDevice());
		inst.setSupplier(this.getSupplier());
		inst.setSpNumber(this.getSpNumber());
		inst.setModel(this.getModel());
		inst.setId(this.getId());
		inst.setSn(this.getSn());
		inst.setLocked(this.getLocked());
		inst.setLocId(this.getLocId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setGoodId(this.getGoodId());
		inst.setVersion(this.getVersion());
		inst.setInsertTime(this.getInsertTime());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setManagerUserId(this.getManagerUserId());
		inst.setWarehouseId(this.getWarehouseId());
		inst.setSourceDesc(this.getSourceDesc());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setOwnerType(this.getOwnerType());
			inst.setPsCategoryId(this.getPsCategoryId());
			inst.setDeviceSpType(this.getDeviceSpType());
			inst.setManager(this.getManager());
			inst.setUsage(this.getUsage());
			inst.setGoods(this.getGoods());
			inst.setPosition(this.getPosition());
			inst.setAssetList(this.getAssetList());
			inst.setDeviceAssociate(this.getDeviceAssociate());
			inst.setWarehouse(this.getWarehouse());
			inst.setOwnerId(this.getOwnerId());
			inst.setSelectedCode(this.getSelectedCode());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DeviceSp clone(boolean deep) {
		return EntityContext.clone(DeviceSp.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DeviceSp
	 * @param deviceSpMap 包含实体信息的 Map 对象
	 * @return DeviceSp , 转换好的的 DeviceSp 对象
	*/
	@Transient
	public static DeviceSp createFrom(Map<String,Object> deviceSpMap) {
		if(deviceSpMap==null) return null;
		DeviceSp po = create();
		EntityContext.copyProperties(po,deviceSpMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DeviceSp
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DeviceSp , 转换好的的 DeviceSp 对象
	*/
	@Transient
	public static DeviceSp createFrom(Object pojo) {
		if(pojo==null) return null;
		DeviceSp po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DeviceSp，等同于 new
	 * @return DeviceSp 对象
	*/
	@Transient
	public static DeviceSp create() {
		return new com.dt.platform.domain.eam.meta.DeviceSpMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(DeviceSpMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(DeviceSpMeta.NOTES)));
			this.setType(DataParser.parse(String.class, map.get(DeviceSpMeta.TYPE)));
			this.setUsageRange(DataParser.parse(String.class, map.get(DeviceSpMeta.USAGE_RANGE)));
			this.setPictureId(DataParser.parse(String.class, map.get(DeviceSpMeta.PICTURE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DeviceSpMeta.UPDATE_BY)));
			this.setAdaptingDevice(DataParser.parse(String.class, map.get(DeviceSpMeta.ADAPTING_DEVICE)));
			this.setSupplier(DataParser.parse(String.class, map.get(DeviceSpMeta.SUPPLIER)));
			this.setSpNumber(DataParser.parse(Integer.class, map.get(DeviceSpMeta.SP_NUMBER)));
			this.setModel(DataParser.parse(String.class, map.get(DeviceSpMeta.MODEL)));
			this.setId(DataParser.parse(String.class, map.get(DeviceSpMeta.ID)));
			this.setSn(DataParser.parse(String.class, map.get(DeviceSpMeta.SN)));
			this.setLocked(DataParser.parse(String.class, map.get(DeviceSpMeta.LOCKED)));
			this.setLocId(DataParser.parse(String.class, map.get(DeviceSpMeta.LOC_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DeviceSpMeta.UPDATE_TIME)));
			this.setGoodId(DataParser.parse(String.class, map.get(DeviceSpMeta.GOOD_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DeviceSpMeta.VERSION)));
			this.setInsertTime(DataParser.parse(Date.class, map.get(DeviceSpMeta.INSERT_TIME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DeviceSpMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DeviceSpMeta.DELETED)));
			this.setManagerUserId(DataParser.parse(String.class, map.get(DeviceSpMeta.MANAGER_USER_ID)));
			this.setWarehouseId(DataParser.parse(String.class, map.get(DeviceSpMeta.WAREHOUSE_ID)));
			this.setSourceDesc(DataParser.parse(String.class, map.get(DeviceSpMeta.SOURCE_DESC)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DeviceSpMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DeviceSpMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(DeviceSpMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(DeviceSpMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DeviceSpMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(DeviceSpMeta.STATUS)));
			// others
			this.setOwnerType(DataParser.parse(String.class, map.get(DeviceSpMeta.OWNER_TYPE)));
			this.setPsCategoryId(DataParser.parse(String.class, map.get(DeviceSpMeta.PS_CATEGORY_ID)));
			this.setDeviceSpType(DataParser.parse(DeviceSpType.class, map.get(DeviceSpMeta.DEVICE_SP_TYPE)));
			this.setManager(DataParser.parse(Employee.class, map.get(DeviceSpMeta.MANAGER)));
			this.setUsage(DataParser.parse(DictItem.class, map.get(DeviceSpMeta.USAGE)));
			this.setGoods(DataParser.parse(Goods.class, map.get(DeviceSpMeta.GOODS)));
			this.setPosition(DataParser.parse(Position.class, map.get(DeviceSpMeta.POSITION)));
			this.setWarehouse(DataParser.parse(Warehouse.class, map.get(DeviceSpMeta.WAREHOUSE)));
			this.setOwnerId(DataParser.parse(String.class, map.get(DeviceSpMeta.OWNER_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(DeviceSpMeta.SELECTED_CODE)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(DeviceSpMeta.CODE));
				this.setNotes( (String)map.get(DeviceSpMeta.NOTES));
				this.setType( (String)map.get(DeviceSpMeta.TYPE));
				this.setUsageRange( (String)map.get(DeviceSpMeta.USAGE_RANGE));
				this.setPictureId( (String)map.get(DeviceSpMeta.PICTURE_ID));
				this.setUpdateBy( (String)map.get(DeviceSpMeta.UPDATE_BY));
				this.setAdaptingDevice( (String)map.get(DeviceSpMeta.ADAPTING_DEVICE));
				this.setSupplier( (String)map.get(DeviceSpMeta.SUPPLIER));
				this.setSpNumber( (Integer)map.get(DeviceSpMeta.SP_NUMBER));
				this.setModel( (String)map.get(DeviceSpMeta.MODEL));
				this.setId( (String)map.get(DeviceSpMeta.ID));
				this.setSn( (String)map.get(DeviceSpMeta.SN));
				this.setLocked( (String)map.get(DeviceSpMeta.LOCKED));
				this.setLocId( (String)map.get(DeviceSpMeta.LOC_ID));
				this.setUpdateTime( (Date)map.get(DeviceSpMeta.UPDATE_TIME));
				this.setGoodId( (String)map.get(DeviceSpMeta.GOOD_ID));
				this.setVersion( (Integer)map.get(DeviceSpMeta.VERSION));
				this.setInsertTime( (Date)map.get(DeviceSpMeta.INSERT_TIME));
				this.setCreateBy( (String)map.get(DeviceSpMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DeviceSpMeta.DELETED));
				this.setManagerUserId( (String)map.get(DeviceSpMeta.MANAGER_USER_ID));
				this.setWarehouseId( (String)map.get(DeviceSpMeta.WAREHOUSE_ID));
				this.setSourceDesc( (String)map.get(DeviceSpMeta.SOURCE_DESC));
				this.setCreateTime( (Date)map.get(DeviceSpMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(DeviceSpMeta.DELETE_TIME));
				this.setName( (String)map.get(DeviceSpMeta.NAME));
				this.setTenantId( (String)map.get(DeviceSpMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(DeviceSpMeta.DELETE_BY));
				this.setStatus( (String)map.get(DeviceSpMeta.STATUS));
				// others
				this.setOwnerType( (String)map.get(DeviceSpMeta.OWNER_TYPE));
				this.setPsCategoryId( (String)map.get(DeviceSpMeta.PS_CATEGORY_ID));
				this.setDeviceSpType( (DeviceSpType)map.get(DeviceSpMeta.DEVICE_SP_TYPE));
				this.setManager( (Employee)map.get(DeviceSpMeta.MANAGER));
				this.setUsage( (DictItem)map.get(DeviceSpMeta.USAGE));
				this.setGoods( (Goods)map.get(DeviceSpMeta.GOODS));
				this.setPosition( (Position)map.get(DeviceSpMeta.POSITION));
				this.setWarehouse( (Warehouse)map.get(DeviceSpMeta.WAREHOUSE));
				this.setOwnerId( (String)map.get(DeviceSpMeta.OWNER_ID));
				this.setSelectedCode( (String)map.get(DeviceSpMeta.SELECTED_CODE));
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
			this.setCode(DataParser.parse(String.class, r.getValue(DeviceSpMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(DeviceSpMeta.NOTES)));
			this.setType(DataParser.parse(String.class, r.getValue(DeviceSpMeta.TYPE)));
			this.setUsageRange(DataParser.parse(String.class, r.getValue(DeviceSpMeta.USAGE_RANGE)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(DeviceSpMeta.PICTURE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DeviceSpMeta.UPDATE_BY)));
			this.setAdaptingDevice(DataParser.parse(String.class, r.getValue(DeviceSpMeta.ADAPTING_DEVICE)));
			this.setSupplier(DataParser.parse(String.class, r.getValue(DeviceSpMeta.SUPPLIER)));
			this.setSpNumber(DataParser.parse(Integer.class, r.getValue(DeviceSpMeta.SP_NUMBER)));
			this.setModel(DataParser.parse(String.class, r.getValue(DeviceSpMeta.MODEL)));
			this.setId(DataParser.parse(String.class, r.getValue(DeviceSpMeta.ID)));
			this.setSn(DataParser.parse(String.class, r.getValue(DeviceSpMeta.SN)));
			this.setLocked(DataParser.parse(String.class, r.getValue(DeviceSpMeta.LOCKED)));
			this.setLocId(DataParser.parse(String.class, r.getValue(DeviceSpMeta.LOC_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DeviceSpMeta.UPDATE_TIME)));
			this.setGoodId(DataParser.parse(String.class, r.getValue(DeviceSpMeta.GOOD_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DeviceSpMeta.VERSION)));
			this.setInsertTime(DataParser.parse(Date.class, r.getValue(DeviceSpMeta.INSERT_TIME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DeviceSpMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DeviceSpMeta.DELETED)));
			this.setManagerUserId(DataParser.parse(String.class, r.getValue(DeviceSpMeta.MANAGER_USER_ID)));
			this.setWarehouseId(DataParser.parse(String.class, r.getValue(DeviceSpMeta.WAREHOUSE_ID)));
			this.setSourceDesc(DataParser.parse(String.class, r.getValue(DeviceSpMeta.SOURCE_DESC)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DeviceSpMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DeviceSpMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(DeviceSpMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(DeviceSpMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DeviceSpMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(DeviceSpMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(DeviceSpMeta.CODE));
				this.setNotes( (String)r.getValue(DeviceSpMeta.NOTES));
				this.setType( (String)r.getValue(DeviceSpMeta.TYPE));
				this.setUsageRange( (String)r.getValue(DeviceSpMeta.USAGE_RANGE));
				this.setPictureId( (String)r.getValue(DeviceSpMeta.PICTURE_ID));
				this.setUpdateBy( (String)r.getValue(DeviceSpMeta.UPDATE_BY));
				this.setAdaptingDevice( (String)r.getValue(DeviceSpMeta.ADAPTING_DEVICE));
				this.setSupplier( (String)r.getValue(DeviceSpMeta.SUPPLIER));
				this.setSpNumber( (Integer)r.getValue(DeviceSpMeta.SP_NUMBER));
				this.setModel( (String)r.getValue(DeviceSpMeta.MODEL));
				this.setId( (String)r.getValue(DeviceSpMeta.ID));
				this.setSn( (String)r.getValue(DeviceSpMeta.SN));
				this.setLocked( (String)r.getValue(DeviceSpMeta.LOCKED));
				this.setLocId( (String)r.getValue(DeviceSpMeta.LOC_ID));
				this.setUpdateTime( (Date)r.getValue(DeviceSpMeta.UPDATE_TIME));
				this.setGoodId( (String)r.getValue(DeviceSpMeta.GOOD_ID));
				this.setVersion( (Integer)r.getValue(DeviceSpMeta.VERSION));
				this.setInsertTime( (Date)r.getValue(DeviceSpMeta.INSERT_TIME));
				this.setCreateBy( (String)r.getValue(DeviceSpMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DeviceSpMeta.DELETED));
				this.setManagerUserId( (String)r.getValue(DeviceSpMeta.MANAGER_USER_ID));
				this.setWarehouseId( (String)r.getValue(DeviceSpMeta.WAREHOUSE_ID));
				this.setSourceDesc( (String)r.getValue(DeviceSpMeta.SOURCE_DESC));
				this.setCreateTime( (Date)r.getValue(DeviceSpMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(DeviceSpMeta.DELETE_TIME));
				this.setName( (String)r.getValue(DeviceSpMeta.NAME));
				this.setTenantId( (String)r.getValue(DeviceSpMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(DeviceSpMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(DeviceSpMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}