package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_PURCHASE_ORDER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.PurchaseOrderMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 采购清单
 * <p>采购清单 , 数据表 eam_purchase_order 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-07 23:12:23
 * @sign 5FFB889BAB1497C1CF36C72B3B76E1D2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_purchase_order")
@ApiModel(description = "采购清单 ; 采购清单 , 数据表 eam_purchase_order 的PO类型")
public class PurchaseOrder extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_PURCHASE_ORDER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "740992291878993920")
	private String id;
	
	/**
	 * 业务编码：业务编码
	*/
	@ApiModelProperty(required = false,value="业务编码" , notes = "业务编码" , example = "POD202358071758425")
	private String businessCode;
	
	/**
	 * 物品编码：物品编码
	*/
	@ApiModelProperty(required = false,value="物品编码" , notes = "物品编码")
	private String code;
	
	/**
	 * 物品名称：物品名称
	*/
	@ApiModelProperty(required = false,value="物品名称" , notes = "物品名称" , example = "1")
	private String name;
	
	/**
	 * 物品档案：物品档案
	*/
	@ApiModelProperty(required = false,value="物品档案" , notes = "物品档案")
	private String goodsId;
	
	/**
	 * 物品类型：物品类型
	*/
	@ApiModelProperty(required = false,value="物品类型" , notes = "物品类型")
	private String goodsType;
	
	/**
	 * 存放类型：存放类型
	*/
	@ApiModelProperty(required = false,value="存放类型" , notes = "存放类型")
	private String storageType;
	
	/**
	 * 采购数量：采购数量
	*/
	@ApiModelProperty(required = false,value="采购数量" , notes = "采购数量" , example = "1")
	private Integer purchaseNumber;
	
	/**
	 * 采购单价：采购单价
	*/
	@ApiModelProperty(required = false,value="采购单价" , notes = "采购单价" , example = "111.00")
	private BigDecimal unitPrice;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 采购单：采购单
	*/
	@ApiModelProperty(required = false,value="采购单" , notes = "采购单" , example = "740992252024717312")
	private String applyId;
	
	/**
	 * 验收单：验收单
	*/
	@ApiModelProperty(required = false,value="验收单" , notes = "验收单")
	private String checkId;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人" , example = "E001")
	private String originatorId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-08-07 05:58:38")
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 选择数据：选择数据
	*/
	@ApiModelProperty(required = false,value="选择数据" , notes = "选择数据" , example = "1691402328000")
	private String selectedCode;
	
	/**
	 * 购买申请：购买申请
	*/
	@ApiModelProperty(required = false,value="购买申请" , notes = "购买申请")
	private Employee purchaseApply;
	
	/**
	 * 验收单：验收单
	*/
	@ApiModelProperty(required = false,value="验收单" , notes = "验收单")
	private Employee purchaseCheck;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * goods：goods
	*/
	@ApiModelProperty(required = false,value="goods" , notes = "goods")
	private GoodsStock goods;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private List<Asset> assetList;
	
	/**
	 * 资产列表：资产列表
	*/
	@ApiModelProperty(required = false,value="资产列表" , notes = "资产列表")
	private List<String> assetIds;
	
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
	public PurchaseOrder setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 业务编码<br>
	 * 业务编码
	 * @return 业务编码
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 业务编码
	 * @param businessCode 业务编码
	 * @return 当前对象
	*/
	public PurchaseOrder setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 物品编码<br>
	 * 物品编码
	 * @return 物品编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 物品编码
	 * @param code 物品编码
	 * @return 当前对象
	*/
	public PurchaseOrder setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 物品名称<br>
	 * 物品名称
	 * @return 物品名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 物品名称
	 * @param name 物品名称
	 * @return 当前对象
	*/
	public PurchaseOrder setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 物品档案<br>
	 * 物品档案
	 * @return 物品档案
	*/
	public String getGoodsId() {
		return goodsId;
	}
	
	/**
	 * 设置 物品档案
	 * @param goodsId 物品档案
	 * @return 当前对象
	*/
	public PurchaseOrder setGoodsId(String goodsId) {
		this.goodsId=goodsId;
		return this;
	}
	
	/**
	 * 获得 物品类型<br>
	 * 物品类型
	 * @return 物品类型
	*/
	public String getGoodsType() {
		return goodsType;
	}
	
	/**
	 * 设置 物品类型
	 * @param goodsType 物品类型
	 * @return 当前对象
	*/
	public PurchaseOrder setGoodsType(String goodsType) {
		this.goodsType=goodsType;
		return this;
	}
	
	/**
	 * 获得 存放类型<br>
	 * 存放类型
	 * @return 存放类型
	*/
	public String getStorageType() {
		return storageType;
	}
	
	/**
	 * 设置 存放类型
	 * @param storageType 存放类型
	 * @return 当前对象
	*/
	public PurchaseOrder setStorageType(String storageType) {
		this.storageType=storageType;
		return this;
	}
	
	/**
	 * 获得 采购数量<br>
	 * 采购数量
	 * @return 采购数量
	*/
	public Integer getPurchaseNumber() {
		return purchaseNumber;
	}
	
	/**
	 * 设置 采购数量
	 * @param purchaseNumber 采购数量
	 * @return 当前对象
	*/
	public PurchaseOrder setPurchaseNumber(Integer purchaseNumber) {
		this.purchaseNumber=purchaseNumber;
		return this;
	}
	
	/**
	 * 获得 采购单价<br>
	 * 采购单价
	 * @return 采购单价
	*/
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	/**
	 * 设置 采购单价
	 * @param unitPrice 采购单价
	 * @return 当前对象
	*/
	public PurchaseOrder setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice=unitPrice;
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
	public PurchaseOrder setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 采购单<br>
	 * 采购单
	 * @return 采购单
	*/
	public String getApplyId() {
		return applyId;
	}
	
	/**
	 * 设置 采购单
	 * @param applyId 采购单
	 * @return 当前对象
	*/
	public PurchaseOrder setApplyId(String applyId) {
		this.applyId=applyId;
		return this;
	}
	
	/**
	 * 获得 验收单<br>
	 * 验收单
	 * @return 验收单
	*/
	public String getCheckId() {
		return checkId;
	}
	
	/**
	 * 设置 验收单
	 * @param checkId 验收单
	 * @return 当前对象
	*/
	public PurchaseOrder setCheckId(String checkId) {
		this.checkId=checkId;
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
	public PurchaseOrder setOriginatorId(String originatorId) {
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
	public PurchaseOrder setCreateBy(String createBy) {
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
	public PurchaseOrder setCreateTime(Date createTime) {
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
	public PurchaseOrder setUpdateBy(String updateBy) {
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
	public PurchaseOrder setUpdateTime(Date updateTime) {
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
	public PurchaseOrder setDeleted(Integer deleted) {
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
	public PurchaseOrder setDeleted(Boolean deletedBool) {
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
	public PurchaseOrder setDeleteBy(String deleteBy) {
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
	public PurchaseOrder setDeleteTime(Date deleteTime) {
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
	public PurchaseOrder setVersion(Integer version) {
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
	public PurchaseOrder setTenantId(String tenantId) {
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
	public PurchaseOrder setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 购买申请<br>
	 * 购买申请
	 * @return 购买申请
	*/
	public Employee getPurchaseApply() {
		return purchaseApply;
	}
	
	/**
	 * 设置 购买申请
	 * @param purchaseApply 购买申请
	 * @return 当前对象
	*/
	public PurchaseOrder setPurchaseApply(Employee purchaseApply) {
		this.purchaseApply=purchaseApply;
		return this;
	}
	
	/**
	 * 获得 验收单<br>
	 * 验收单
	 * @return 验收单
	*/
	public Employee getPurchaseCheck() {
		return purchaseCheck;
	}
	
	/**
	 * 设置 验收单
	 * @param purchaseCheck 验收单
	 * @return 当前对象
	*/
	public PurchaseOrder setPurchaseCheck(Employee purchaseCheck) {
		this.purchaseCheck=purchaseCheck;
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
	public PurchaseOrder setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 goods<br>
	 * goods
	 * @return goods
	*/
	public GoodsStock getGoods() {
		return goods;
	}
	
	/**
	 * 设置 goods
	 * @param goods goods
	 * @return 当前对象
	*/
	public PurchaseOrder setGoods(GoodsStock goods) {
		this.goods=goods;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public List<Asset> getAssetList() {
		return assetList;
	}
	
	/**
	 * 设置 资产
	 * @param assetList 资产
	 * @return 当前对象
	*/
	public PurchaseOrder setAssetList(List<Asset> assetList) {
		this.assetList=assetList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public PurchaseOrder addAsset(Asset... asset) {
		if(this.assetList==null) assetList=new ArrayList<>();
		this.assetList.addAll(Arrays.asList(asset));
		return this;
	}
	
	/**
	 * 获得 资产列表<br>
	 * 资产列表
	 * @return 资产列表
	*/
	public List<String> getAssetIds() {
		return assetIds;
	}
	
	/**
	 * 设置 资产列表
	 * @param assetIds 资产列表
	 * @return 当前对象
	*/
	public PurchaseOrder setAssetIds(List<String> assetIds) {
		this.assetIds=assetIds;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetId 资产列表
	 * @return 当前对象
	*/
	public PurchaseOrder addAssetId(String... assetId) {
		if(this.assetIds==null) assetIds=new ArrayList<>();
		this.assetIds.addAll(Arrays.asList(assetId));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PurchaseOrder , 转换好的 PurchaseOrder 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PurchaseOrder , 转换好的 PoJo 对象
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
	public PurchaseOrder clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PurchaseOrder duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.PurchaseOrderMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.PurchaseOrderMeta.$$proxy$$();
		inst.setUnitPrice(this.getUnitPrice());
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setGoodsId(this.getGoodsId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setGoodsType(this.getGoodsType());
		inst.setApplyId(this.getApplyId());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setStorageType(this.getStorageType());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setCheckId(this.getCheckId());
		inst.setPurchaseNumber(this.getPurchaseNumber());
		if(all) {
			inst.setPurchaseCheck(this.getPurchaseCheck());
			inst.setPurchaseApply(this.getPurchaseApply());
			inst.setGoods(this.getGoods());
			inst.setAssetIds(this.getAssetIds());
			inst.setOriginator(this.getOriginator());
			inst.setAssetList(this.getAssetList());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PurchaseOrder clone(boolean deep) {
		return EntityContext.clone(PurchaseOrder.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PurchaseOrder
	 * @param purchaseOrderMap 包含实体信息的 Map 对象
	 * @return PurchaseOrder , 转换好的的 PurchaseOrder 对象
	*/
	@Transient
	public static PurchaseOrder createFrom(Map<String,Object> purchaseOrderMap) {
		if(purchaseOrderMap==null) return null;
		PurchaseOrder po = create();
		EntityContext.copyProperties(po,purchaseOrderMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PurchaseOrder
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PurchaseOrder , 转换好的的 PurchaseOrder 对象
	*/
	@Transient
	public static PurchaseOrder createFrom(Object pojo) {
		if(pojo==null) return null;
		PurchaseOrder po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PurchaseOrder，等同于 new
	 * @return PurchaseOrder 对象
	*/
	@Transient
	public static PurchaseOrder create() {
		return new com.dt.platform.domain.eam.meta.PurchaseOrderMeta.$$proxy$$();
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
			this.setUnitPrice(DataParser.parse(BigDecimal.class, map.get(PurchaseOrderMeta.UNIT_PRICE)));
			this.setCode(DataParser.parse(String.class, map.get(PurchaseOrderMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(PurchaseOrderMeta.NOTES)));
			this.setGoodsId(DataParser.parse(String.class, map.get(PurchaseOrderMeta.GOODS_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PurchaseOrderMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PurchaseOrderMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(PurchaseOrderMeta.SELECTED_CODE)));
			this.setGoodsType(DataParser.parse(String.class, map.get(PurchaseOrderMeta.GOODS_TYPE)));
			this.setApplyId(DataParser.parse(String.class, map.get(PurchaseOrderMeta.APPLY_ID)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(PurchaseOrderMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PurchaseOrderMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PurchaseOrderMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PurchaseOrderMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PurchaseOrderMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PurchaseOrderMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(PurchaseOrderMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PurchaseOrderMeta.TENANT_ID)));
			this.setStorageType(DataParser.parse(String.class, map.get(PurchaseOrderMeta.STORAGE_TYPE)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PurchaseOrderMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PurchaseOrderMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(PurchaseOrderMeta.ORIGINATOR_ID)));
			this.setCheckId(DataParser.parse(String.class, map.get(PurchaseOrderMeta.CHECK_ID)));
			this.setPurchaseNumber(DataParser.parse(Integer.class, map.get(PurchaseOrderMeta.PURCHASE_NUMBER)));
			// others
			this.setPurchaseCheck(DataParser.parse(Employee.class, map.get(PurchaseOrderMeta.PURCHASE_CHECK)));
			this.setPurchaseApply(DataParser.parse(Employee.class, map.get(PurchaseOrderMeta.PURCHASE_APPLY)));
			this.setGoods(DataParser.parse(GoodsStock.class, map.get(PurchaseOrderMeta.GOODS)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(PurchaseOrderMeta.ORIGINATOR)));
			return true;
		} else {
			try {
				this.setUnitPrice( (BigDecimal)map.get(PurchaseOrderMeta.UNIT_PRICE));
				this.setCode( (String)map.get(PurchaseOrderMeta.CODE));
				this.setNotes( (String)map.get(PurchaseOrderMeta.NOTES));
				this.setGoodsId( (String)map.get(PurchaseOrderMeta.GOODS_ID));
				this.setUpdateTime( (Date)map.get(PurchaseOrderMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PurchaseOrderMeta.VERSION));
				this.setSelectedCode( (String)map.get(PurchaseOrderMeta.SELECTED_CODE));
				this.setGoodsType( (String)map.get(PurchaseOrderMeta.GOODS_TYPE));
				this.setApplyId( (String)map.get(PurchaseOrderMeta.APPLY_ID));
				this.setBusinessCode( (String)map.get(PurchaseOrderMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(PurchaseOrderMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PurchaseOrderMeta.DELETED));
				this.setCreateTime( (Date)map.get(PurchaseOrderMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PurchaseOrderMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PurchaseOrderMeta.DELETE_TIME));
				this.setName( (String)map.get(PurchaseOrderMeta.NAME));
				this.setTenantId( (String)map.get(PurchaseOrderMeta.TENANT_ID));
				this.setStorageType( (String)map.get(PurchaseOrderMeta.STORAGE_TYPE));
				this.setDeleteBy( (String)map.get(PurchaseOrderMeta.DELETE_BY));
				this.setId( (String)map.get(PurchaseOrderMeta.ID));
				this.setOriginatorId( (String)map.get(PurchaseOrderMeta.ORIGINATOR_ID));
				this.setCheckId( (String)map.get(PurchaseOrderMeta.CHECK_ID));
				this.setPurchaseNumber( (Integer)map.get(PurchaseOrderMeta.PURCHASE_NUMBER));
				// others
				this.setPurchaseCheck( (Employee)map.get(PurchaseOrderMeta.PURCHASE_CHECK));
				this.setPurchaseApply( (Employee)map.get(PurchaseOrderMeta.PURCHASE_APPLY));
				this.setGoods( (GoodsStock)map.get(PurchaseOrderMeta.GOODS));
				this.setOriginator( (Employee)map.get(PurchaseOrderMeta.ORIGINATOR));
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
			this.setUnitPrice(DataParser.parse(BigDecimal.class, r.getValue(PurchaseOrderMeta.UNIT_PRICE)));
			this.setCode(DataParser.parse(String.class, r.getValue(PurchaseOrderMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(PurchaseOrderMeta.NOTES)));
			this.setGoodsId(DataParser.parse(String.class, r.getValue(PurchaseOrderMeta.GOODS_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PurchaseOrderMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PurchaseOrderMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(PurchaseOrderMeta.SELECTED_CODE)));
			this.setGoodsType(DataParser.parse(String.class, r.getValue(PurchaseOrderMeta.GOODS_TYPE)));
			this.setApplyId(DataParser.parse(String.class, r.getValue(PurchaseOrderMeta.APPLY_ID)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(PurchaseOrderMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PurchaseOrderMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PurchaseOrderMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PurchaseOrderMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PurchaseOrderMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PurchaseOrderMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(PurchaseOrderMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PurchaseOrderMeta.TENANT_ID)));
			this.setStorageType(DataParser.parse(String.class, r.getValue(PurchaseOrderMeta.STORAGE_TYPE)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PurchaseOrderMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PurchaseOrderMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(PurchaseOrderMeta.ORIGINATOR_ID)));
			this.setCheckId(DataParser.parse(String.class, r.getValue(PurchaseOrderMeta.CHECK_ID)));
			this.setPurchaseNumber(DataParser.parse(Integer.class, r.getValue(PurchaseOrderMeta.PURCHASE_NUMBER)));
			return true;
		} else {
			try {
				this.setUnitPrice( (BigDecimal)r.getValue(PurchaseOrderMeta.UNIT_PRICE));
				this.setCode( (String)r.getValue(PurchaseOrderMeta.CODE));
				this.setNotes( (String)r.getValue(PurchaseOrderMeta.NOTES));
				this.setGoodsId( (String)r.getValue(PurchaseOrderMeta.GOODS_ID));
				this.setUpdateTime( (Date)r.getValue(PurchaseOrderMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PurchaseOrderMeta.VERSION));
				this.setSelectedCode( (String)r.getValue(PurchaseOrderMeta.SELECTED_CODE));
				this.setGoodsType( (String)r.getValue(PurchaseOrderMeta.GOODS_TYPE));
				this.setApplyId( (String)r.getValue(PurchaseOrderMeta.APPLY_ID));
				this.setBusinessCode( (String)r.getValue(PurchaseOrderMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(PurchaseOrderMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PurchaseOrderMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PurchaseOrderMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PurchaseOrderMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PurchaseOrderMeta.DELETE_TIME));
				this.setName( (String)r.getValue(PurchaseOrderMeta.NAME));
				this.setTenantId( (String)r.getValue(PurchaseOrderMeta.TENANT_ID));
				this.setStorageType( (String)r.getValue(PurchaseOrderMeta.STORAGE_TYPE));
				this.setDeleteBy( (String)r.getValue(PurchaseOrderMeta.DELETE_BY));
				this.setId( (String)r.getValue(PurchaseOrderMeta.ID));
				this.setOriginatorId( (String)r.getValue(PurchaseOrderMeta.ORIGINATOR_ID));
				this.setCheckId( (String)r.getValue(PurchaseOrderMeta.CHECK_ID));
				this.setPurchaseNumber( (Integer)r.getValue(PurchaseOrderMeta.PURCHASE_NUMBER));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}