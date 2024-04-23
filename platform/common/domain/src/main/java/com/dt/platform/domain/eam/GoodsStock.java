package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_GOODS_STOCK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.GoodsStockMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 库存物品
 * <p>库存物品 , 数据表 eam_goods_stock 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-23 18:19:06
 * @sign 011A3F63E7A9EA6CD3490022DB6E3DBE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_goods_stock")
@ApiModel(description = "库存物品 ; 库存物品 , 数据表 eam_goods_stock 的PO类型")
public class GoodsStock extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_GOODS_STOCK.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "737233568744341504")
	private String id;
	
	/**
	 * 所属：所属
	*/
	@ApiModelProperty(required = false,value="所属" , notes = "所属")
	private String ownerId;
	
	/**
	 * 所属：所属
	*/
	@ApiModelProperty(required = false,value="所属" , notes = "所属")
	private String ownerTmpId;
	
	/**
	 * 库存所属：库存所属
	*/
	@ApiModelProperty(required = false,value="库存所属" , notes = "库存所属" , example = "goods")
	private String ownerCode;
	
	/**
	 * 所属类型：所属类型
	*/
	@ApiModelProperty(required = false,value="所属类型" , notes = "所属类型")
	private String ownerType;
	
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
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String goodsStatus;
	
	/**
	 * 档案分类：档案分类
	*/
	@ApiModelProperty(required = false,value="档案分类" , notes = "档案分类" , example = "591603433010626560")
	private String categoryId;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private String assetCategoryId;
	
	/**
	 * 物品名称：物品名称
	*/
	@ApiModelProperty(required = false,value="物品名称" , notes = "物品名称" , example = "笔记本DELL")
	private String name;
	
	/**
	 * 规格型号：规格型号
	*/
	@ApiModelProperty(required = false,value="规格型号" , notes = "规格型号" , example = "720P")
	private String model;
	
	/**
	 * 物品编码：物品编码
	*/
	@ApiModelProperty(required = false,value="物品编码" , notes = "物品编码" , example = "BJB_001")
	private String code;
	
	/**
	 * 物品条码：物品条码
	*/
	@ApiModelProperty(required = false,value="物品条码" , notes = "物品条码" , example = "BJB_001")
	private String barCode;
	
	/**
	 * 厂商：厂商
	*/
	@ApiModelProperty(required = false,value="厂商" , notes = "厂商" , example = "471669992140570624")
	private String manufacturerId;
	
	/**
	 * 品牌商标：品牌商标
	*/
	@ApiModelProperty(required = false,value="品牌商标" , notes = "品牌商标" , example = "599501249284407296")
	private String brandId;
	
	/**
	 * 默认单价：默认单价
	*/
	@ApiModelProperty(required = false,value="默认单价" , notes = "默认单价" , example = "0.00")
	private BigDecimal unitPrice;
	
	/**
	 * 计量单位：计量单位
	*/
	@ApiModelProperty(required = false,value="计量单位" , notes = "计量单位" , example = "个")
	private String unit;
	
	/**
	 * 安全库存下限：安全库存下限
	*/
	@ApiModelProperty(required = false,value="安全库存下限" , notes = "安全库存下限" , example = "1")
	private BigDecimal stockMin;
	
	/**
	 * 安全库存上限：安全库存上限
	*/
	@ApiModelProperty(required = false,value="安全库存上限" , notes = "安全库存上限" , example = "500")
	private BigDecimal stockMax;
	
	/**
	 * 安全库存：安全库存
	*/
	@ApiModelProperty(required = false,value="安全库存" , notes = "安全库存" , example = "200")
	private BigDecimal stockSecurity;
	
	/**
	 * 物品图片：物品图片
	*/
	@ApiModelProperty(required = false,value="物品图片" , notes = "物品图片")
	private String pictureId;
	
	/**
	 * 保养建议：保养建议
	*/
	@ApiModelProperty(required = false,value="保养建议" , notes = "保养建议")
	private String maintenanceRecommendation;
	
	/**
	 * 巡检建议：巡检建议
	*/
	@ApiModelProperty(required = false,value="巡检建议" , notes = "巡检建议")
	private String inspectionRecommendation;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "档案备注")
	private String notes;
	
	/**
	 * 批次号：批次号
	*/
	@ApiModelProperty(required = false,value="批次号" , notes = "批次号")
	private String batchCode;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private String ownCompanyId;
	
	/**
	 * 使用组织：使用组织
	*/
	@ApiModelProperty(required = false,value="使用组织" , notes = "使用组织")
	private String useOrgId;
	
	/**
	 * 供应商：供应商
	*/
	@ApiModelProperty(required = false,value="供应商" , notes = "供应商")
	private String supplierName;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private String warehouseId;
	
	/**
	 * 库位：库位
	*/
	@ApiModelProperty(required = false,value="库位" , notes = "库位")
	private String positionId;
	
	/**
	 * 位置详请：位置详请
	*/
	@ApiModelProperty(required = false,value="位置详请" , notes = "位置详请")
	private String positionDetail;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "来源")
	private String sourceId;
	
	/**
	 * 物品：物品
	*/
	@ApiModelProperty(required = false,value="物品" , notes = "物品")
	private String goodsId;
	
	/**
	 * 入库数量：入库数量
	*/
	@ApiModelProperty(required = false,value="入库数量" , notes = "入库数量" , example = "0")
	private BigDecimal stockInNumber;
	
	/**
	 * 当前数量：当前数量
	*/
	@ApiModelProperty(required = false,value="当前数量" , notes = "当前数量" , example = "0")
	private BigDecimal stockCurNumber;
	
	/**
	 * 总金额：总金额
	*/
	@ApiModelProperty(required = false,value="总金额" , notes = "总金额" , example = "0.00")
	private BigDecimal amount;
	
	/**
	 * 管理人：管理人
	*/
	@ApiModelProperty(required = false,value="管理人" , notes = "管理人")
	private String managerId;
	
	/**
	 * 入库时间：入库时间
	*/
	@ApiModelProperty(required = false,value="入库时间" , notes = "入库时间")
	private Date storageDate;
	
	/**
	 * 库存数据：库存数据
	*/
	@ApiModelProperty(required = false,value="库存数据" , notes = "库存数据")
	private String realStockId;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
	/**
	 * 序列：序列
	*/
	@ApiModelProperty(required = false,value="序列" , notes = "序列")
	private String sn;
	
	/**
	 * 父级：父级
	*/
	@ApiModelProperty(required = false,value="父级" , notes = "父级")
	private String pid;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择" , example = "1702808701000")
	private String selectedCode;
	
	/**
	 * 操作类型：操作类型
	*/
	@ApiModelProperty(required = false,value="操作类型" , notes = "操作类型")
	private String interOperType;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-07-28 09:03:00")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-12-17 06:25:32")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "8")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * warehousePosition：warehousePosition
	*/
	@ApiModelProperty(required = false,value="warehousePosition" , notes = "warehousePosition")
	private WarehousePosition warehousePosition;
	
	/**
	 * warehouseByPosition：warehouseByPosition
	*/
	@ApiModelProperty(required = false,value="warehouseByPosition" , notes = "warehouseByPosition")
	private Warehouse warehouseByPosition;
	
	/**
	 * goodsByManufacturer：goodsByManufacturer
	*/
	@ApiModelProperty(required = false,value="goodsByManufacturer" , notes = "goodsByManufacturer")
	private Manufacturer goodsByManufacturer;
	
	/**
	 * goodsByBrand：goodsByBrand
	*/
	@ApiModelProperty(required = false,value="goodsByBrand" , notes = "goodsByBrand")
	private Brand goodsByBrand;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private Catalog category;
	
	/**
	 * 生产厂商：生产厂商
	*/
	@ApiModelProperty(required = false,value="生产厂商" , notes = "生产厂商")
	private Manufacturer manufacturer;
	
	/**
	 * 品牌：品牌
	*/
	@ApiModelProperty(required = false,value="品牌" , notes = "品牌")
	private Brand brand;
	
	/**
	 * 物品：物品
	*/
	@ApiModelProperty(required = false,value="物品" , notes = "物品")
	private GoodsStock goods;
	
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
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private Warehouse warehouse;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "来源")
	private DictItem source;
	
	/**
	 * 管理人：管理人
	*/
	@ApiModelProperty(required = false,value="管理人" , notes = "管理人")
	private Employee manager;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 库存数据：库存数据
	*/
	@ApiModelProperty(required = false,value="库存数据" , notes = "库存数据")
	private GoodsStock realGoods;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private String goodsModel;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String goodsName;
	
	/**
	 * 分类：分类
	*/
	@ApiModelProperty(required = false,value="分类" , notes = "分类")
	private String goodsCategoryName;
	
	/**
	 * 计算单位：计算单位
	*/
	@ApiModelProperty(required = false,value="计算单位" , notes = "计算单位")
	private String goodsUnit;
	
	/**
	 * 物品编码：物品编码
	*/
	@ApiModelProperty(required = false,value="物品编码" , notes = "物品编码")
	private String goodsCode;
	
	/**
	 * 物品条码：物品条码
	*/
	@ApiModelProperty(required = false,value="物品条码" , notes = "物品条码")
	private String goodsBarCode;
	
	/**
	 * 物品条码：物品条码
	*/
	@ApiModelProperty(required = false,value="物品条码" , notes = "物品条码")
	private String goodsStockMax;
	
	/**
	 * 物品条码：物品条码
	*/
	@ApiModelProperty(required = false,value="物品条码" , notes = "物品条码")
	private String goodsStockMin;
	
	/**
	 * 物品条码：物品条码
	*/
	@ApiModelProperty(required = false,value="物品条码" , notes = "物品条码")
	private String goodsStockSecurity;
	
	/**
	 * 库存备注：库存备注
	*/
	@ApiModelProperty(required = false,value="库存备注" , notes = "库存备注")
	private String goodsStockNotes;
	
	/**
	 * searchRelType：searchRelType
	*/
	@ApiModelProperty(required = false,value="searchRelType" , notes = "searchRelType")
	private String searchRelType;
	
	/**
	 * relatedAssetCount：relatedAssetCount
	*/
	@ApiModelProperty(required = false,value="relatedAssetCount" , notes = "relatedAssetCount")
	private Integer relatedAssetCount;
	
	/**
	 * relatedGoodsStockCount：relatedGoodsStockCount
	*/
	@ApiModelProperty(required = false,value="relatedGoodsStockCount" , notes = "relatedGoodsStockCount")
	private Integer relatedGoodsStockCount;
	
	/**
	 * relatedAssetList：relatedAssetList
	*/
	@ApiModelProperty(required = false,value="relatedAssetList" , notes = "relatedAssetList")
	private List<Asset> relatedAssetList;
	
	/**
	 * relatedGoodsStockList：relatedGoodsStockList
	*/
	@ApiModelProperty(required = false,value="relatedGoodsStockList" , notes = "relatedGoodsStockList")
	private List<GoodsStock> relatedGoodsStockList;
	
	/**
	 * parentGoodsStockList：parentGoodsStockList
	*/
	@ApiModelProperty(required = false,value="parentGoodsStockList" , notes = "parentGoodsStockList")
	private List<GoodsStock> parentGoodsStockList;
	
	/**
	 * parentGoodsStockIds：parentGoodsStockIds
	*/
	@ApiModelProperty(required = false,value="parentGoodsStockIds" , notes = "parentGoodsStockIds")
	private List<String> parentGoodsStockIds;
	
	/**
	 * subGoodsStockList：subGoodsStockList
	*/
	@ApiModelProperty(required = false,value="subGoodsStockList" , notes = "subGoodsStockList")
	private List<GoodsStock> subGoodsStockList;
	
	/**
	 * subGoodsStockIds：subGoodsStockIds
	*/
	@ApiModelProperty(required = false,value="subGoodsStockIds" , notes = "subGoodsStockIds")
	private List<String> subGoodsStockIds;
	
	/**
	 * goodsParentGoodsStockList：goodsParentGoodsStockList
	*/
	@ApiModelProperty(required = false,value="goodsParentGoodsStockList" , notes = "goodsParentGoodsStockList")
	private List<GoodsStock> goodsParentGoodsStockList;
	
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
	public GoodsStock setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 所属<br>
	 * 所属
	 * @return 所属
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 所属
	 * @param ownerId 所属
	 * @return 当前对象
	*/
	public GoodsStock setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 所属<br>
	 * 所属
	 * @return 所属
	*/
	public String getOwnerTmpId() {
		return ownerTmpId;
	}
	
	/**
	 * 设置 所属
	 * @param ownerTmpId 所属
	 * @return 当前对象
	*/
	public GoodsStock setOwnerTmpId(String ownerTmpId) {
		this.ownerTmpId=ownerTmpId;
		return this;
	}
	
	/**
	 * 获得 库存所属<br>
	 * 库存所属
	 * @return 库存所属
	*/
	public String getOwnerCode() {
		return ownerCode;
	}
	
	/**
	 * 设置 库存所属
	 * @param ownerCode 库存所属
	 * @return 当前对象
	*/
	public GoodsStock setOwnerCode(String ownerCode) {
		this.ownerCode=ownerCode;
		return this;
	}
	
	/**
	 * 获得 所属类型<br>
	 * 所属类型
	 * @return 所属类型
	*/
	public String getOwnerType() {
		return ownerType;
	}
	
	/**
	 * 设置 所属类型
	 * @param ownerType 所属类型
	 * @return 当前对象
	*/
	public GoodsStock setOwnerType(String ownerType) {
		this.ownerType=ownerType;
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
	public GoodsStock setBusinessCode(String businessCode) {
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
	public GoodsStock setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getGoodsStatus() {
		return goodsStatus;
	}
	
	/**
	 * 设置 状态
	 * @param goodsStatus 状态
	 * @return 当前对象
	*/
	public GoodsStock setGoodsStatus(String goodsStatus) {
		this.goodsStatus=goodsStatus;
		return this;
	}
	
	/**
	 * 获得 档案分类<br>
	 * 档案分类
	 * @return 档案分类
	*/
	public String getCategoryId() {
		return categoryId;
	}
	
	/**
	 * 设置 档案分类
	 * @param categoryId 档案分类
	 * @return 当前对象
	*/
	public GoodsStock setCategoryId(String categoryId) {
		this.categoryId=categoryId;
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public String getAssetCategoryId() {
		return assetCategoryId;
	}
	
	/**
	 * 设置 资产分类
	 * @param assetCategoryId 资产分类
	 * @return 当前对象
	*/
	public GoodsStock setAssetCategoryId(String assetCategoryId) {
		this.assetCategoryId=assetCategoryId;
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
	public GoodsStock setName(String name) {
		this.name=name;
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
	public GoodsStock setModel(String model) {
		this.model=model;
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
	public GoodsStock setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 物品条码<br>
	 * 物品条码
	 * @return 物品条码
	*/
	public String getBarCode() {
		return barCode;
	}
	
	/**
	 * 设置 物品条码
	 * @param barCode 物品条码
	 * @return 当前对象
	*/
	public GoodsStock setBarCode(String barCode) {
		this.barCode=barCode;
		return this;
	}
	
	/**
	 * 获得 厂商<br>
	 * 厂商
	 * @return 厂商
	*/
	public String getManufacturerId() {
		return manufacturerId;
	}
	
	/**
	 * 设置 厂商
	 * @param manufacturerId 厂商
	 * @return 当前对象
	*/
	public GoodsStock setManufacturerId(String manufacturerId) {
		this.manufacturerId=manufacturerId;
		return this;
	}
	
	/**
	 * 获得 品牌商标<br>
	 * 品牌商标
	 * @return 品牌商标
	*/
	public String getBrandId() {
		return brandId;
	}
	
	/**
	 * 设置 品牌商标
	 * @param brandId 品牌商标
	 * @return 当前对象
	*/
	public GoodsStock setBrandId(String brandId) {
		this.brandId=brandId;
		return this;
	}
	
	/**
	 * 获得 默认单价<br>
	 * 默认单价
	 * @return 默认单价
	*/
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	/**
	 * 设置 默认单价
	 * @param unitPrice 默认单价
	 * @return 当前对象
	*/
	public GoodsStock setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice=unitPrice;
		return this;
	}
	
	/**
	 * 获得 计量单位<br>
	 * 计量单位
	 * @return 计量单位
	*/
	public String getUnit() {
		return unit;
	}
	
	/**
	 * 设置 计量单位
	 * @param unit 计量单位
	 * @return 当前对象
	*/
	public GoodsStock setUnit(String unit) {
		this.unit=unit;
		return this;
	}
	
	/**
	 * 获得 安全库存下限<br>
	 * 安全库存下限
	 * @return 安全库存下限
	*/
	public BigDecimal getStockMin() {
		return stockMin;
	}
	
	/**
	 * 设置 安全库存下限
	 * @param stockMin 安全库存下限
	 * @return 当前对象
	*/
	public GoodsStock setStockMin(BigDecimal stockMin) {
		this.stockMin=stockMin;
		return this;
	}
	
	/**
	 * 获得 安全库存上限<br>
	 * 安全库存上限
	 * @return 安全库存上限
	*/
	public BigDecimal getStockMax() {
		return stockMax;
	}
	
	/**
	 * 设置 安全库存上限
	 * @param stockMax 安全库存上限
	 * @return 当前对象
	*/
	public GoodsStock setStockMax(BigDecimal stockMax) {
		this.stockMax=stockMax;
		return this;
	}
	
	/**
	 * 获得 安全库存<br>
	 * 安全库存
	 * @return 安全库存
	*/
	public BigDecimal getStockSecurity() {
		return stockSecurity;
	}
	
	/**
	 * 设置 安全库存
	 * @param stockSecurity 安全库存
	 * @return 当前对象
	*/
	public GoodsStock setStockSecurity(BigDecimal stockSecurity) {
		this.stockSecurity=stockSecurity;
		return this;
	}
	
	/**
	 * 获得 物品图片<br>
	 * 物品图片
	 * @return 物品图片
	*/
	public String getPictureId() {
		return pictureId;
	}
	
	/**
	 * 设置 物品图片
	 * @param pictureId 物品图片
	 * @return 当前对象
	*/
	public GoodsStock setPictureId(String pictureId) {
		this.pictureId=pictureId;
		return this;
	}
	
	/**
	 * 获得 保养建议<br>
	 * 保养建议
	 * @return 保养建议
	*/
	public String getMaintenanceRecommendation() {
		return maintenanceRecommendation;
	}
	
	/**
	 * 设置 保养建议
	 * @param maintenanceRecommendation 保养建议
	 * @return 当前对象
	*/
	public GoodsStock setMaintenanceRecommendation(String maintenanceRecommendation) {
		this.maintenanceRecommendation=maintenanceRecommendation;
		return this;
	}
	
	/**
	 * 获得 巡检建议<br>
	 * 巡检建议
	 * @return 巡检建议
	*/
	public String getInspectionRecommendation() {
		return inspectionRecommendation;
	}
	
	/**
	 * 设置 巡检建议
	 * @param inspectionRecommendation 巡检建议
	 * @return 当前对象
	*/
	public GoodsStock setInspectionRecommendation(String inspectionRecommendation) {
		this.inspectionRecommendation=inspectionRecommendation;
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
	public GoodsStock setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 批次号<br>
	 * 批次号
	 * @return 批次号
	*/
	public String getBatchCode() {
		return batchCode;
	}
	
	/**
	 * 设置 批次号
	 * @param batchCode 批次号
	 * @return 当前对象
	*/
	public GoodsStock setBatchCode(String batchCode) {
		this.batchCode=batchCode;
		return this;
	}
	
	/**
	 * 获得 所属公司<br>
	 * 所属公司
	 * @return 所属公司
	*/
	public String getOwnCompanyId() {
		return ownCompanyId;
	}
	
	/**
	 * 设置 所属公司
	 * @param ownCompanyId 所属公司
	 * @return 当前对象
	*/
	public GoodsStock setOwnCompanyId(String ownCompanyId) {
		this.ownCompanyId=ownCompanyId;
		return this;
	}
	
	/**
	 * 获得 使用组织<br>
	 * 使用组织
	 * @return 使用组织
	*/
	public String getUseOrgId() {
		return useOrgId;
	}
	
	/**
	 * 设置 使用组织
	 * @param useOrgId 使用组织
	 * @return 当前对象
	*/
	public GoodsStock setUseOrgId(String useOrgId) {
		this.useOrgId=useOrgId;
		return this;
	}
	
	/**
	 * 获得 供应商<br>
	 * 供应商
	 * @return 供应商
	*/
	public String getSupplierName() {
		return supplierName;
	}
	
	/**
	 * 设置 供应商
	 * @param supplierName 供应商
	 * @return 当前对象
	*/
	public GoodsStock setSupplierName(String supplierName) {
		this.supplierName=supplierName;
		return this;
	}
	
	/**
	 * 获得 仓库<br>
	 * 仓库
	 * @return 仓库
	*/
	public String getWarehouseId() {
		return warehouseId;
	}
	
	/**
	 * 设置 仓库
	 * @param warehouseId 仓库
	 * @return 当前对象
	*/
	public GoodsStock setWarehouseId(String warehouseId) {
		this.warehouseId=warehouseId;
		return this;
	}
	
	/**
	 * 获得 库位<br>
	 * 库位
	 * @return 库位
	*/
	public String getPositionId() {
		return positionId;
	}
	
	/**
	 * 设置 库位
	 * @param positionId 库位
	 * @return 当前对象
	*/
	public GoodsStock setPositionId(String positionId) {
		this.positionId=positionId;
		return this;
	}
	
	/**
	 * 获得 位置详请<br>
	 * 位置详请
	 * @return 位置详请
	*/
	public String getPositionDetail() {
		return positionDetail;
	}
	
	/**
	 * 设置 位置详请
	 * @param positionDetail 位置详请
	 * @return 当前对象
	*/
	public GoodsStock setPositionDetail(String positionDetail) {
		this.positionDetail=positionDetail;
		return this;
	}
	
	/**
	 * 获得 来源<br>
	 * 来源
	 * @return 来源
	*/
	public String getSourceId() {
		return sourceId;
	}
	
	/**
	 * 设置 来源
	 * @param sourceId 来源
	 * @return 当前对象
	*/
	public GoodsStock setSourceId(String sourceId) {
		this.sourceId=sourceId;
		return this;
	}
	
	/**
	 * 获得 物品<br>
	 * 物品
	 * @return 物品
	*/
	public String getGoodsId() {
		return goodsId;
	}
	
	/**
	 * 设置 物品
	 * @param goodsId 物品
	 * @return 当前对象
	*/
	public GoodsStock setGoodsId(String goodsId) {
		this.goodsId=goodsId;
		return this;
	}
	
	/**
	 * 获得 入库数量<br>
	 * 入库数量
	 * @return 入库数量
	*/
	public BigDecimal getStockInNumber() {
		return stockInNumber;
	}
	
	/**
	 * 设置 入库数量
	 * @param stockInNumber 入库数量
	 * @return 当前对象
	*/
	public GoodsStock setStockInNumber(BigDecimal stockInNumber) {
		this.stockInNumber=stockInNumber;
		return this;
	}
	
	/**
	 * 获得 当前数量<br>
	 * 当前数量
	 * @return 当前数量
	*/
	public BigDecimal getStockCurNumber() {
		return stockCurNumber;
	}
	
	/**
	 * 设置 当前数量
	 * @param stockCurNumber 当前数量
	 * @return 当前对象
	*/
	public GoodsStock setStockCurNumber(BigDecimal stockCurNumber) {
		this.stockCurNumber=stockCurNumber;
		return this;
	}
	
	/**
	 * 获得 总金额<br>
	 * 总金额
	 * @return 总金额
	*/
	public BigDecimal getAmount() {
		return amount;
	}
	
	/**
	 * 设置 总金额
	 * @param amount 总金额
	 * @return 当前对象
	*/
	public GoodsStock setAmount(BigDecimal amount) {
		this.amount=amount;
		return this;
	}
	
	/**
	 * 获得 管理人<br>
	 * 管理人
	 * @return 管理人
	*/
	public String getManagerId() {
		return managerId;
	}
	
	/**
	 * 设置 管理人
	 * @param managerId 管理人
	 * @return 当前对象
	*/
	public GoodsStock setManagerId(String managerId) {
		this.managerId=managerId;
		return this;
	}
	
	/**
	 * 获得 入库时间<br>
	 * 入库时间
	 * @return 入库时间
	*/
	public Date getStorageDate() {
		return storageDate;
	}
	
	/**
	 * 设置 入库时间
	 * @param storageDate 入库时间
	 * @return 当前对象
	*/
	public GoodsStock setStorageDate(Date storageDate) {
		this.storageDate=storageDate;
		return this;
	}
	
	/**
	 * 获得 库存数据<br>
	 * 库存数据
	 * @return 库存数据
	*/
	public String getRealStockId() {
		return realStockId;
	}
	
	/**
	 * 设置 库存数据
	 * @param realStockId 库存数据
	 * @return 当前对象
	*/
	public GoodsStock setRealStockId(String realStockId) {
		this.realStockId=realStockId;
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
	public GoodsStock setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
		return this;
	}
	
	/**
	 * 获得 序列<br>
	 * 序列
	 * @return 序列
	*/
	public String getSn() {
		return sn;
	}
	
	/**
	 * 设置 序列
	 * @param sn 序列
	 * @return 当前对象
	*/
	public GoodsStock setSn(String sn) {
		this.sn=sn;
		return this;
	}
	
	/**
	 * 获得 父级<br>
	 * 父级
	 * @return 父级
	*/
	public String getPid() {
		return pid;
	}
	
	/**
	 * 设置 父级
	 * @param pid 父级
	 * @return 当前对象
	*/
	public GoodsStock setPid(String pid) {
		this.pid=pid;
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
	public GoodsStock setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 操作类型<br>
	 * 操作类型
	 * @return 操作类型
	*/
	public String getInterOperType() {
		return interOperType;
	}
	
	/**
	 * 设置 操作类型
	 * @param interOperType 操作类型
	 * @return 当前对象
	*/
	public GoodsStock setInterOperType(String interOperType) {
		this.interOperType=interOperType;
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
	public GoodsStock setCreateBy(String createBy) {
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
	public GoodsStock setCreateTime(Date createTime) {
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
	public GoodsStock setUpdateBy(String updateBy) {
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
	public GoodsStock setUpdateTime(Date updateTime) {
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
	public GoodsStock setDeleted(Integer deleted) {
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
	public GoodsStock setDeleted(Boolean deletedBool) {
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
	public GoodsStock setDeleteBy(String deleteBy) {
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
	public GoodsStock setDeleteTime(Date deleteTime) {
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
	public GoodsStock setVersion(Integer version) {
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
	public GoodsStock setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 warehousePosition<br>
	 * warehousePosition
	 * @return warehousePosition
	*/
	public WarehousePosition getWarehousePosition() {
		return warehousePosition;
	}
	
	/**
	 * 设置 warehousePosition
	 * @param warehousePosition warehousePosition
	 * @return 当前对象
	*/
	public GoodsStock setWarehousePosition(WarehousePosition warehousePosition) {
		this.warehousePosition=warehousePosition;
		return this;
	}
	
	/**
	 * 获得 warehouseByPosition<br>
	 * warehouseByPosition
	 * @return warehouseByPosition
	*/
	public Warehouse getWarehouseByPosition() {
		return warehouseByPosition;
	}
	
	/**
	 * 设置 warehouseByPosition
	 * @param warehouseByPosition warehouseByPosition
	 * @return 当前对象
	*/
	public GoodsStock setWarehouseByPosition(Warehouse warehouseByPosition) {
		this.warehouseByPosition=warehouseByPosition;
		return this;
	}
	
	/**
	 * 获得 goodsByManufacturer<br>
	 * goodsByManufacturer
	 * @return goodsByManufacturer
	*/
	public Manufacturer getGoodsByManufacturer() {
		return goodsByManufacturer;
	}
	
	/**
	 * 设置 goodsByManufacturer
	 * @param goodsByManufacturer goodsByManufacturer
	 * @return 当前对象
	*/
	public GoodsStock setGoodsByManufacturer(Manufacturer goodsByManufacturer) {
		this.goodsByManufacturer=goodsByManufacturer;
		return this;
	}
	
	/**
	 * 获得 goodsByBrand<br>
	 * goodsByBrand
	 * @return goodsByBrand
	*/
	public Brand getGoodsByBrand() {
		return goodsByBrand;
	}
	
	/**
	 * 设置 goodsByBrand
	 * @param goodsByBrand goodsByBrand
	 * @return 当前对象
	*/
	public GoodsStock setGoodsByBrand(Brand goodsByBrand) {
		this.goodsByBrand=goodsByBrand;
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public Catalog getCategory() {
		return category;
	}
	
	/**
	 * 设置 资产分类
	 * @param category 资产分类
	 * @return 当前对象
	*/
	public GoodsStock setCategory(Catalog category) {
		this.category=category;
		return this;
	}
	
	/**
	 * 获得 生产厂商<br>
	 * 生产厂商
	 * @return 生产厂商
	*/
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	
	/**
	 * 设置 生产厂商
	 * @param manufacturer 生产厂商
	 * @return 当前对象
	*/
	public GoodsStock setManufacturer(Manufacturer manufacturer) {
		this.manufacturer=manufacturer;
		return this;
	}
	
	/**
	 * 获得 品牌<br>
	 * 品牌
	 * @return 品牌
	*/
	public Brand getBrand() {
		return brand;
	}
	
	/**
	 * 设置 品牌
	 * @param brand 品牌
	 * @return 当前对象
	*/
	public GoodsStock setBrand(Brand brand) {
		this.brand=brand;
		return this;
	}
	
	/**
	 * 获得 物品<br>
	 * 物品
	 * @return 物品
	*/
	public GoodsStock getGoods() {
		return goods;
	}
	
	/**
	 * 设置 物品
	 * @param goods 物品
	 * @return 当前对象
	*/
	public GoodsStock setGoods(GoodsStock goods) {
		this.goods=goods;
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
	public GoodsStock setOwnerCompany(Organization ownerCompany) {
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
	public GoodsStock setUseOrganization(Organization useOrganization) {
		this.useOrganization=useOrganization;
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
	public GoodsStock setWarehouse(Warehouse warehouse) {
		this.warehouse=warehouse;
		return this;
	}
	
	/**
	 * 获得 来源<br>
	 * 来源
	 * @return 来源
	*/
	public DictItem getSource() {
		return source;
	}
	
	/**
	 * 设置 来源
	 * @param source 来源
	 * @return 当前对象
	*/
	public GoodsStock setSource(DictItem source) {
		this.source=source;
		return this;
	}
	
	/**
	 * 获得 管理人<br>
	 * 管理人
	 * @return 管理人
	*/
	public Employee getManager() {
		return manager;
	}
	
	/**
	 * 设置 管理人
	 * @param manager 管理人
	 * @return 当前对象
	*/
	public GoodsStock setManager(Employee manager) {
		this.manager=manager;
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
	public GoodsStock setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 库存数据<br>
	 * 库存数据
	 * @return 库存数据
	*/
	public GoodsStock getRealGoods() {
		return realGoods;
	}
	
	/**
	 * 设置 库存数据
	 * @param realGoods 库存数据
	 * @return 当前对象
	*/
	public GoodsStock setRealGoods(GoodsStock realGoods) {
		this.realGoods=realGoods;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getGoodsModel() {
		return goodsModel;
	}
	
	/**
	 * 设置 类型
	 * @param goodsModel 类型
	 * @return 当前对象
	*/
	public GoodsStock setGoodsModel(String goodsModel) {
		this.goodsModel=goodsModel;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getGoodsName() {
		return goodsName;
	}
	
	/**
	 * 设置 名称
	 * @param goodsName 名称
	 * @return 当前对象
	*/
	public GoodsStock setGoodsName(String goodsName) {
		this.goodsName=goodsName;
		return this;
	}
	
	/**
	 * 获得 分类<br>
	 * 分类
	 * @return 分类
	*/
	public String getGoodsCategoryName() {
		return goodsCategoryName;
	}
	
	/**
	 * 设置 分类
	 * @param goodsCategoryName 分类
	 * @return 当前对象
	*/
	public GoodsStock setGoodsCategoryName(String goodsCategoryName) {
		this.goodsCategoryName=goodsCategoryName;
		return this;
	}
	
	/**
	 * 获得 计算单位<br>
	 * 计算单位
	 * @return 计算单位
	*/
	public String getGoodsUnit() {
		return goodsUnit;
	}
	
	/**
	 * 设置 计算单位
	 * @param goodsUnit 计算单位
	 * @return 当前对象
	*/
	public GoodsStock setGoodsUnit(String goodsUnit) {
		this.goodsUnit=goodsUnit;
		return this;
	}
	
	/**
	 * 获得 物品编码<br>
	 * 物品编码
	 * @return 物品编码
	*/
	public String getGoodsCode() {
		return goodsCode;
	}
	
	/**
	 * 设置 物品编码
	 * @param goodsCode 物品编码
	 * @return 当前对象
	*/
	public GoodsStock setGoodsCode(String goodsCode) {
		this.goodsCode=goodsCode;
		return this;
	}
	
	/**
	 * 获得 物品条码<br>
	 * 物品条码
	 * @return 物品条码
	*/
	public String getGoodsBarCode() {
		return goodsBarCode;
	}
	
	/**
	 * 设置 物品条码
	 * @param goodsBarCode 物品条码
	 * @return 当前对象
	*/
	public GoodsStock setGoodsBarCode(String goodsBarCode) {
		this.goodsBarCode=goodsBarCode;
		return this;
	}
	
	/**
	 * 获得 物品条码<br>
	 * 物品条码
	 * @return 物品条码
	*/
	public String getGoodsStockMax() {
		return goodsStockMax;
	}
	
	/**
	 * 设置 物品条码
	 * @param goodsStockMax 物品条码
	 * @return 当前对象
	*/
	public GoodsStock setGoodsStockMax(String goodsStockMax) {
		this.goodsStockMax=goodsStockMax;
		return this;
	}
	
	/**
	 * 获得 物品条码<br>
	 * 物品条码
	 * @return 物品条码
	*/
	public String getGoodsStockMin() {
		return goodsStockMin;
	}
	
	/**
	 * 设置 物品条码
	 * @param goodsStockMin 物品条码
	 * @return 当前对象
	*/
	public GoodsStock setGoodsStockMin(String goodsStockMin) {
		this.goodsStockMin=goodsStockMin;
		return this;
	}
	
	/**
	 * 获得 物品条码<br>
	 * 物品条码
	 * @return 物品条码
	*/
	public String getGoodsStockSecurity() {
		return goodsStockSecurity;
	}
	
	/**
	 * 设置 物品条码
	 * @param goodsStockSecurity 物品条码
	 * @return 当前对象
	*/
	public GoodsStock setGoodsStockSecurity(String goodsStockSecurity) {
		this.goodsStockSecurity=goodsStockSecurity;
		return this;
	}
	
	/**
	 * 获得 库存备注<br>
	 * 库存备注
	 * @return 库存备注
	*/
	public String getGoodsStockNotes() {
		return goodsStockNotes;
	}
	
	/**
	 * 设置 库存备注
	 * @param goodsStockNotes 库存备注
	 * @return 当前对象
	*/
	public GoodsStock setGoodsStockNotes(String goodsStockNotes) {
		this.goodsStockNotes=goodsStockNotes;
		return this;
	}
	
	/**
	 * 获得 searchRelType<br>
	 * searchRelType
	 * @return searchRelType
	*/
	public String getSearchRelType() {
		return searchRelType;
	}
	
	/**
	 * 设置 searchRelType
	 * @param searchRelType searchRelType
	 * @return 当前对象
	*/
	public GoodsStock setSearchRelType(String searchRelType) {
		this.searchRelType=searchRelType;
		return this;
	}
	
	/**
	 * 获得 relatedAssetCount<br>
	 * relatedAssetCount
	 * @return relatedAssetCount
	*/
	public Integer getRelatedAssetCount() {
		return relatedAssetCount;
	}
	
	/**
	 * 设置 relatedAssetCount
	 * @param relatedAssetCount relatedAssetCount
	 * @return 当前对象
	*/
	public GoodsStock setRelatedAssetCount(Integer relatedAssetCount) {
		this.relatedAssetCount=relatedAssetCount;
		return this;
	}
	
	/**
	 * 获得 relatedGoodsStockCount<br>
	 * relatedGoodsStockCount
	 * @return relatedGoodsStockCount
	*/
	public Integer getRelatedGoodsStockCount() {
		return relatedGoodsStockCount;
	}
	
	/**
	 * 设置 relatedGoodsStockCount
	 * @param relatedGoodsStockCount relatedGoodsStockCount
	 * @return 当前对象
	*/
	public GoodsStock setRelatedGoodsStockCount(Integer relatedGoodsStockCount) {
		this.relatedGoodsStockCount=relatedGoodsStockCount;
		return this;
	}
	
	/**
	 * 获得 relatedAssetList<br>
	 * relatedAssetList
	 * @return relatedAssetList
	*/
	public List<Asset> getRelatedAssetList() {
		return relatedAssetList;
	}
	
	/**
	 * 设置 relatedAssetList
	 * @param relatedAssetList relatedAssetList
	 * @return 当前对象
	*/
	public GoodsStock setRelatedAssetList(List<Asset> relatedAssetList) {
		this.relatedAssetList=relatedAssetList;
		return this;
	}
	
	/**
	 * 添加 relatedAssetList
	 * @param relatedAsset relatedAssetList
	 * @return 当前对象
	*/
	public GoodsStock addRelatedAsset(Asset... relatedAsset) {
		if(this.relatedAssetList==null) relatedAssetList=new ArrayList<>();
		this.relatedAssetList.addAll(Arrays.asList(relatedAsset));
		return this;
	}
	
	/**
	 * 获得 relatedGoodsStockList<br>
	 * relatedGoodsStockList
	 * @return relatedGoodsStockList
	*/
	public List<GoodsStock> getRelatedGoodsStockList() {
		return relatedGoodsStockList;
	}
	
	/**
	 * 设置 relatedGoodsStockList
	 * @param relatedGoodsStockList relatedGoodsStockList
	 * @return 当前对象
	*/
	public GoodsStock setRelatedGoodsStockList(List<GoodsStock> relatedGoodsStockList) {
		this.relatedGoodsStockList=relatedGoodsStockList;
		return this;
	}
	
	/**
	 * 添加 relatedGoodsStockList
	 * @param relatedGoodsStock relatedGoodsStockList
	 * @return 当前对象
	*/
	public GoodsStock addRelatedGoodsStock(GoodsStock... relatedGoodsStock) {
		if(this.relatedGoodsStockList==null) relatedGoodsStockList=new ArrayList<>();
		this.relatedGoodsStockList.addAll(Arrays.asList(relatedGoodsStock));
		return this;
	}
	
	/**
	 * 获得 parentGoodsStockList<br>
	 * parentGoodsStockList
	 * @return parentGoodsStockList
	*/
	public List<GoodsStock> getParentGoodsStockList() {
		return parentGoodsStockList;
	}
	
	/**
	 * 设置 parentGoodsStockList
	 * @param parentGoodsStockList parentGoodsStockList
	 * @return 当前对象
	*/
	public GoodsStock setParentGoodsStockList(List<GoodsStock> parentGoodsStockList) {
		this.parentGoodsStockList=parentGoodsStockList;
		return this;
	}
	
	/**
	 * 添加 parentGoodsStockList
	 * @param parentGoodsStock parentGoodsStockList
	 * @return 当前对象
	*/
	public GoodsStock addParentGoodsStock(GoodsStock... parentGoodsStock) {
		if(this.parentGoodsStockList==null) parentGoodsStockList=new ArrayList<>();
		this.parentGoodsStockList.addAll(Arrays.asList(parentGoodsStock));
		return this;
	}
	
	/**
	 * 获得 parentGoodsStockIds<br>
	 * parentGoodsStockIds
	 * @return parentGoodsStockIds
	*/
	public List<String> getParentGoodsStockIds() {
		return parentGoodsStockIds;
	}
	
	/**
	 * 设置 parentGoodsStockIds
	 * @param parentGoodsStockIds parentGoodsStockIds
	 * @return 当前对象
	*/
	public GoodsStock setParentGoodsStockIds(List<String> parentGoodsStockIds) {
		this.parentGoodsStockIds=parentGoodsStockIds;
		return this;
	}
	
	/**
	 * 添加 parentGoodsStockIds
	 * @param parentGoodsStockId parentGoodsStockIds
	 * @return 当前对象
	*/
	public GoodsStock addParentGoodsStockId(String... parentGoodsStockId) {
		if(this.parentGoodsStockIds==null) parentGoodsStockIds=new ArrayList<>();
		this.parentGoodsStockIds.addAll(Arrays.asList(parentGoodsStockId));
		return this;
	}
	
	/**
	 * 获得 subGoodsStockList<br>
	 * subGoodsStockList
	 * @return subGoodsStockList
	*/
	public List<GoodsStock> getSubGoodsStockList() {
		return subGoodsStockList;
	}
	
	/**
	 * 设置 subGoodsStockList
	 * @param subGoodsStockList subGoodsStockList
	 * @return 当前对象
	*/
	public GoodsStock setSubGoodsStockList(List<GoodsStock> subGoodsStockList) {
		this.subGoodsStockList=subGoodsStockList;
		return this;
	}
	
	/**
	 * 添加 subGoodsStockList
	 * @param subGoodsStock subGoodsStockList
	 * @return 当前对象
	*/
	public GoodsStock addSubGoodsStock(GoodsStock... subGoodsStock) {
		if(this.subGoodsStockList==null) subGoodsStockList=new ArrayList<>();
		this.subGoodsStockList.addAll(Arrays.asList(subGoodsStock));
		return this;
	}
	
	/**
	 * 获得 subGoodsStockIds<br>
	 * subGoodsStockIds
	 * @return subGoodsStockIds
	*/
	public List<String> getSubGoodsStockIds() {
		return subGoodsStockIds;
	}
	
	/**
	 * 设置 subGoodsStockIds
	 * @param subGoodsStockIds subGoodsStockIds
	 * @return 当前对象
	*/
	public GoodsStock setSubGoodsStockIds(List<String> subGoodsStockIds) {
		this.subGoodsStockIds=subGoodsStockIds;
		return this;
	}
	
	/**
	 * 添加 subGoodsStockIds
	 * @param subGoodsStockId subGoodsStockIds
	 * @return 当前对象
	*/
	public GoodsStock addSubGoodsStockId(String... subGoodsStockId) {
		if(this.subGoodsStockIds==null) subGoodsStockIds=new ArrayList<>();
		this.subGoodsStockIds.addAll(Arrays.asList(subGoodsStockId));
		return this;
	}
	
	/**
	 * 获得 goodsParentGoodsStockList<br>
	 * goodsParentGoodsStockList
	 * @return goodsParentGoodsStockList
	*/
	public List<GoodsStock> getGoodsParentGoodsStockList() {
		return goodsParentGoodsStockList;
	}
	
	/**
	 * 设置 goodsParentGoodsStockList
	 * @param goodsParentGoodsStockList goodsParentGoodsStockList
	 * @return 当前对象
	*/
	public GoodsStock setGoodsParentGoodsStockList(List<GoodsStock> goodsParentGoodsStockList) {
		this.goodsParentGoodsStockList=goodsParentGoodsStockList;
		return this;
	}
	
	/**
	 * 添加 goodsParentGoodsStockList
	 * @param goodsParentGoodsStock goodsParentGoodsStockList
	 * @return 当前对象
	*/
	public GoodsStock addGoodsParentGoodsStock(GoodsStock... goodsParentGoodsStock) {
		if(this.goodsParentGoodsStockList==null) goodsParentGoodsStockList=new ArrayList<>();
		this.goodsParentGoodsStockList.addAll(Arrays.asList(goodsParentGoodsStock));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return GoodsStock , 转换好的 GoodsStock 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return GoodsStock , 转换好的 PoJo 对象
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
	public GoodsStock clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public GoodsStock duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.GoodsStockMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.GoodsStockMeta.$$proxy$$();
		inst.setOwnerType(this.getOwnerType());
		inst.setSourceId(this.getSourceId());
		inst.setInterOperType(this.getInterOperType());
		inst.setNotes(this.getNotes());
		inst.setStockSecurity(this.getStockSecurity());
		inst.setOwnerTmpId(this.getOwnerTmpId());
		inst.setPid(this.getPid());
		inst.setOwnerId(this.getOwnerId());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setModel(this.getModel());
		inst.setId(this.getId());
		inst.setUnitPrice(this.getUnitPrice());
		inst.setMaintenanceRecommendation(this.getMaintenanceRecommendation());
		inst.setVersion(this.getVersion());
		inst.setBarCode(this.getBarCode());
		inst.setUnit(this.getUnit());
		inst.setOwnCompanyId(this.getOwnCompanyId());
		inst.setWarehouseId(this.getWarehouseId());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setBrandId(this.getBrandId());
		inst.setAssetCategoryId(this.getAssetCategoryId());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setInspectionRecommendation(this.getInspectionRecommendation());
		inst.setStatus(this.getStatus());
		inst.setCode(this.getCode());
		inst.setOwnerCode(this.getOwnerCode());
		inst.setGoodsId(this.getGoodsId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setStockMin(this.getStockMin());
		inst.setPictureId(this.getPictureId());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setSn(this.getSn());
		inst.setSupplierName(this.getSupplierName());
		inst.setStockInNumber(this.getStockInNumber());
		inst.setAmount(this.getAmount());
		inst.setStockMax(this.getStockMax());
		inst.setUseOrgId(this.getUseOrgId());
		inst.setBatchCode(this.getBatchCode());
		inst.setManufacturerId(this.getManufacturerId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setManagerId(this.getManagerId());
		inst.setStorageDate(this.getStorageDate());
		inst.setPositionDetail(this.getPositionDetail());
		inst.setStockCurNumber(this.getStockCurNumber());
		inst.setCreateBy(this.getCreateBy());
		inst.setRealStockId(this.getRealStockId());
		inst.setDeleted(this.getDeleted());
		inst.setGoodsStatus(this.getGoodsStatus());
		inst.setPositionId(this.getPositionId());
		inst.setCreateTime(this.getCreateTime());
		inst.setTenantId(this.getTenantId());
		inst.setCategoryId(this.getCategoryId());
		if(all) {
			inst.setOwnerCompany(this.getOwnerCompany());
			inst.setGoodsStockSecurity(this.getGoodsStockSecurity());
			inst.setRelatedAssetCount(this.getRelatedAssetCount());
			inst.setGoods(this.getGoods());
			inst.setParentGoodsStockList(this.getParentGoodsStockList());
			inst.setSource(this.getSource());
			inst.setOriginator(this.getOriginator());
			inst.setGoodsModel(this.getGoodsModel());
			inst.setParentGoodsStockIds(this.getParentGoodsStockIds());
			inst.setManufacturer(this.getManufacturer());
			inst.setGoodsBarCode(this.getGoodsBarCode());
			inst.setWarehouseByPosition(this.getWarehouseByPosition());
			inst.setSubGoodsStockIds(this.getSubGoodsStockIds());
			inst.setSubGoodsStockList(this.getSubGoodsStockList());
			inst.setGoodsUnit(this.getGoodsUnit());
			inst.setSearchRelType(this.getSearchRelType());
			inst.setBrand(this.getBrand());
			inst.setGoodsName(this.getGoodsName());
			inst.setGoodsStockMax(this.getGoodsStockMax());
			inst.setRelatedGoodsStockList(this.getRelatedGoodsStockList());
			inst.setManager(this.getManager());
			inst.setGoodsParentGoodsStockList(this.getGoodsParentGoodsStockList());
			inst.setRelatedGoodsStockCount(this.getRelatedGoodsStockCount());
			inst.setGoodsStockMin(this.getGoodsStockMin());
			inst.setWarehouse(this.getWarehouse());
			inst.setRealGoods(this.getRealGoods());
			inst.setWarehousePosition(this.getWarehousePosition());
			inst.setGoodsByBrand(this.getGoodsByBrand());
			inst.setUseOrganization(this.getUseOrganization());
			inst.setGoodsCategoryName(this.getGoodsCategoryName());
			inst.setGoodsStockNotes(this.getGoodsStockNotes());
			inst.setGoodsByManufacturer(this.getGoodsByManufacturer());
			inst.setRelatedAssetList(this.getRelatedAssetList());
			inst.setGoodsCode(this.getGoodsCode());
			inst.setCategory(this.getCategory());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public GoodsStock clone(boolean deep) {
		return EntityContext.clone(GoodsStock.class,this,deep);
	}

	/**
	 * 将 Map 转换成 GoodsStock
	 * @param goodsStockMap 包含实体信息的 Map 对象
	 * @return GoodsStock , 转换好的的 GoodsStock 对象
	*/
	@Transient
	public static GoodsStock createFrom(Map<String,Object> goodsStockMap) {
		if(goodsStockMap==null) return null;
		GoodsStock po = create();
		EntityContext.copyProperties(po,goodsStockMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 GoodsStock
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return GoodsStock , 转换好的的 GoodsStock 对象
	*/
	@Transient
	public static GoodsStock createFrom(Object pojo) {
		if(pojo==null) return null;
		GoodsStock po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 GoodsStock，等同于 new
	 * @return GoodsStock 对象
	*/
	@Transient
	public static GoodsStock create() {
		return new com.dt.platform.domain.eam.meta.GoodsStockMeta.$$proxy$$();
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
			this.setOwnerType(DataParser.parse(String.class, map.get(GoodsStockMeta.OWNER_TYPE)));
			this.setSourceId(DataParser.parse(String.class, map.get(GoodsStockMeta.SOURCE_ID)));
			this.setInterOperType(DataParser.parse(String.class, map.get(GoodsStockMeta.INTER_OPER_TYPE)));
			this.setNotes(DataParser.parse(String.class, map.get(GoodsStockMeta.NOTES)));
			this.setStockSecurity(DataParser.parse(BigDecimal.class, map.get(GoodsStockMeta.STOCK_SECURITY)));
			this.setOwnerTmpId(DataParser.parse(String.class, map.get(GoodsStockMeta.OWNER_TMP_ID)));
			this.setPid(DataParser.parse(String.class, map.get(GoodsStockMeta.PID)));
			this.setOwnerId(DataParser.parse(String.class, map.get(GoodsStockMeta.OWNER_ID)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(GoodsStockMeta.BUSINESS_CODE)));
			this.setModel(DataParser.parse(String.class, map.get(GoodsStockMeta.MODEL)));
			this.setId(DataParser.parse(String.class, map.get(GoodsStockMeta.ID)));
			this.setUnitPrice(DataParser.parse(BigDecimal.class, map.get(GoodsStockMeta.UNIT_PRICE)));
			this.setMaintenanceRecommendation(DataParser.parse(String.class, map.get(GoodsStockMeta.MAINTENANCE_RECOMMENDATION)));
			this.setVersion(DataParser.parse(Integer.class, map.get(GoodsStockMeta.VERSION)));
			this.setBarCode(DataParser.parse(String.class, map.get(GoodsStockMeta.BAR_CODE)));
			this.setUnit(DataParser.parse(String.class, map.get(GoodsStockMeta.UNIT)));
			this.setOwnCompanyId(DataParser.parse(String.class, map.get(GoodsStockMeta.OWN_COMPANY_ID)));
			this.setWarehouseId(DataParser.parse(String.class, map.get(GoodsStockMeta.WAREHOUSE_ID)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(GoodsStockMeta.DELETE_TIME)));
			this.setBrandId(DataParser.parse(String.class, map.get(GoodsStockMeta.BRAND_ID)));
			this.setAssetCategoryId(DataParser.parse(String.class, map.get(GoodsStockMeta.ASSET_CATEGORY_ID)));
			this.setName(DataParser.parse(String.class, map.get(GoodsStockMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(GoodsStockMeta.DELETE_BY)));
			this.setInspectionRecommendation(DataParser.parse(String.class, map.get(GoodsStockMeta.INSPECTION_RECOMMENDATION)));
			this.setStatus(DataParser.parse(String.class, map.get(GoodsStockMeta.STATUS)));
			this.setCode(DataParser.parse(String.class, map.get(GoodsStockMeta.CODE)));
			this.setOwnerCode(DataParser.parse(String.class, map.get(GoodsStockMeta.OWNER_CODE)));
			this.setGoodsId(DataParser.parse(String.class, map.get(GoodsStockMeta.GOODS_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(GoodsStockMeta.SELECTED_CODE)));
			this.setStockMin(DataParser.parse(BigDecimal.class, map.get(GoodsStockMeta.STOCK_MIN)));
			this.setPictureId(DataParser.parse(String.class, map.get(GoodsStockMeta.PICTURE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(GoodsStockMeta.UPDATE_BY)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(GoodsStockMeta.ORIGINATOR_ID)));
			this.setSn(DataParser.parse(String.class, map.get(GoodsStockMeta.SN)));
			this.setSupplierName(DataParser.parse(String.class, map.get(GoodsStockMeta.SUPPLIER_NAME)));
			this.setStockInNumber(DataParser.parse(BigDecimal.class, map.get(GoodsStockMeta.STOCK_IN_NUMBER)));
			this.setAmount(DataParser.parse(BigDecimal.class, map.get(GoodsStockMeta.AMOUNT)));
			this.setStockMax(DataParser.parse(BigDecimal.class, map.get(GoodsStockMeta.STOCK_MAX)));
			this.setUseOrgId(DataParser.parse(String.class, map.get(GoodsStockMeta.USE_ORG_ID)));
			this.setBatchCode(DataParser.parse(String.class, map.get(GoodsStockMeta.BATCH_CODE)));
			this.setManufacturerId(DataParser.parse(String.class, map.get(GoodsStockMeta.MANUFACTURER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(GoodsStockMeta.UPDATE_TIME)));
			this.setManagerId(DataParser.parse(String.class, map.get(GoodsStockMeta.MANAGER_ID)));
			this.setStorageDate(DataParser.parse(Date.class, map.get(GoodsStockMeta.STORAGE_DATE)));
			this.setPositionDetail(DataParser.parse(String.class, map.get(GoodsStockMeta.POSITION_DETAIL)));
			this.setStockCurNumber(DataParser.parse(BigDecimal.class, map.get(GoodsStockMeta.STOCK_CUR_NUMBER)));
			this.setCreateBy(DataParser.parse(String.class, map.get(GoodsStockMeta.CREATE_BY)));
			this.setRealStockId(DataParser.parse(String.class, map.get(GoodsStockMeta.REAL_STOCK_ID)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(GoodsStockMeta.DELETED)));
			this.setGoodsStatus(DataParser.parse(String.class, map.get(GoodsStockMeta.GOODS_STATUS)));
			this.setPositionId(DataParser.parse(String.class, map.get(GoodsStockMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(GoodsStockMeta.CREATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(GoodsStockMeta.TENANT_ID)));
			this.setCategoryId(DataParser.parse(String.class, map.get(GoodsStockMeta.CATEGORY_ID)));
			// others
			this.setOwnerCompany(DataParser.parse(Organization.class, map.get(GoodsStockMeta.OWNER_COMPANY)));
			this.setGoodsStockSecurity(DataParser.parse(String.class, map.get(GoodsStockMeta.GOODS_STOCK_SECURITY)));
			this.setRelatedAssetCount(DataParser.parse(Integer.class, map.get(GoodsStockMeta.RELATED_ASSET_COUNT)));
			this.setGoods(DataParser.parse(GoodsStock.class, map.get(GoodsStockMeta.GOODS)));
			this.setSource(DataParser.parse(DictItem.class, map.get(GoodsStockMeta.SOURCE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(GoodsStockMeta.ORIGINATOR)));
			this.setGoodsModel(DataParser.parse(String.class, map.get(GoodsStockMeta.GOODS_MODEL)));
			this.setManufacturer(DataParser.parse(Manufacturer.class, map.get(GoodsStockMeta.MANUFACTURER)));
			this.setGoodsBarCode(DataParser.parse(String.class, map.get(GoodsStockMeta.GOODS_BAR_CODE)));
			this.setWarehouseByPosition(DataParser.parse(Warehouse.class, map.get(GoodsStockMeta.WAREHOUSE_BY_POSITION)));
			this.setGoodsUnit(DataParser.parse(String.class, map.get(GoodsStockMeta.GOODS_UNIT)));
			this.setSearchRelType(DataParser.parse(String.class, map.get(GoodsStockMeta.SEARCH_REL_TYPE)));
			this.setBrand(DataParser.parse(Brand.class, map.get(GoodsStockMeta.BRAND)));
			this.setGoodsName(DataParser.parse(String.class, map.get(GoodsStockMeta.GOODS_NAME)));
			this.setGoodsStockMax(DataParser.parse(String.class, map.get(GoodsStockMeta.GOODS_STOCK_MAX)));
			this.setManager(DataParser.parse(Employee.class, map.get(GoodsStockMeta.MANAGER)));
			this.setRelatedGoodsStockCount(DataParser.parse(Integer.class, map.get(GoodsStockMeta.RELATED_GOODS_STOCK_COUNT)));
			this.setGoodsStockMin(DataParser.parse(String.class, map.get(GoodsStockMeta.GOODS_STOCK_MIN)));
			this.setWarehouse(DataParser.parse(Warehouse.class, map.get(GoodsStockMeta.WAREHOUSE)));
			this.setRealGoods(DataParser.parse(GoodsStock.class, map.get(GoodsStockMeta.REAL_GOODS)));
			this.setWarehousePosition(DataParser.parse(WarehousePosition.class, map.get(GoodsStockMeta.WAREHOUSE_POSITION)));
			this.setGoodsByBrand(DataParser.parse(Brand.class, map.get(GoodsStockMeta.GOODS_BY_BRAND)));
			this.setUseOrganization(DataParser.parse(Organization.class, map.get(GoodsStockMeta.USE_ORGANIZATION)));
			this.setGoodsCategoryName(DataParser.parse(String.class, map.get(GoodsStockMeta.GOODS_CATEGORY_NAME)));
			this.setGoodsStockNotes(DataParser.parse(String.class, map.get(GoodsStockMeta.GOODS_STOCK_NOTES)));
			this.setGoodsByManufacturer(DataParser.parse(Manufacturer.class, map.get(GoodsStockMeta.GOODS_BY_MANUFACTURER)));
			this.setGoodsCode(DataParser.parse(String.class, map.get(GoodsStockMeta.GOODS_CODE)));
			this.setCategory(DataParser.parse(Catalog.class, map.get(GoodsStockMeta.CATEGORY)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)map.get(GoodsStockMeta.OWNER_TYPE));
				this.setSourceId( (String)map.get(GoodsStockMeta.SOURCE_ID));
				this.setInterOperType( (String)map.get(GoodsStockMeta.INTER_OPER_TYPE));
				this.setNotes( (String)map.get(GoodsStockMeta.NOTES));
				this.setStockSecurity( (BigDecimal)map.get(GoodsStockMeta.STOCK_SECURITY));
				this.setOwnerTmpId( (String)map.get(GoodsStockMeta.OWNER_TMP_ID));
				this.setPid( (String)map.get(GoodsStockMeta.PID));
				this.setOwnerId( (String)map.get(GoodsStockMeta.OWNER_ID));
				this.setBusinessCode( (String)map.get(GoodsStockMeta.BUSINESS_CODE));
				this.setModel( (String)map.get(GoodsStockMeta.MODEL));
				this.setId( (String)map.get(GoodsStockMeta.ID));
				this.setUnitPrice( (BigDecimal)map.get(GoodsStockMeta.UNIT_PRICE));
				this.setMaintenanceRecommendation( (String)map.get(GoodsStockMeta.MAINTENANCE_RECOMMENDATION));
				this.setVersion( (Integer)map.get(GoodsStockMeta.VERSION));
				this.setBarCode( (String)map.get(GoodsStockMeta.BAR_CODE));
				this.setUnit( (String)map.get(GoodsStockMeta.UNIT));
				this.setOwnCompanyId( (String)map.get(GoodsStockMeta.OWN_COMPANY_ID));
				this.setWarehouseId( (String)map.get(GoodsStockMeta.WAREHOUSE_ID));
				this.setDeleteTime( (Date)map.get(GoodsStockMeta.DELETE_TIME));
				this.setBrandId( (String)map.get(GoodsStockMeta.BRAND_ID));
				this.setAssetCategoryId( (String)map.get(GoodsStockMeta.ASSET_CATEGORY_ID));
				this.setName( (String)map.get(GoodsStockMeta.NAME));
				this.setDeleteBy( (String)map.get(GoodsStockMeta.DELETE_BY));
				this.setInspectionRecommendation( (String)map.get(GoodsStockMeta.INSPECTION_RECOMMENDATION));
				this.setStatus( (String)map.get(GoodsStockMeta.STATUS));
				this.setCode( (String)map.get(GoodsStockMeta.CODE));
				this.setOwnerCode( (String)map.get(GoodsStockMeta.OWNER_CODE));
				this.setGoodsId( (String)map.get(GoodsStockMeta.GOODS_ID));
				this.setSelectedCode( (String)map.get(GoodsStockMeta.SELECTED_CODE));
				this.setStockMin( (BigDecimal)map.get(GoodsStockMeta.STOCK_MIN));
				this.setPictureId( (String)map.get(GoodsStockMeta.PICTURE_ID));
				this.setUpdateBy( (String)map.get(GoodsStockMeta.UPDATE_BY));
				this.setOriginatorId( (String)map.get(GoodsStockMeta.ORIGINATOR_ID));
				this.setSn( (String)map.get(GoodsStockMeta.SN));
				this.setSupplierName( (String)map.get(GoodsStockMeta.SUPPLIER_NAME));
				this.setStockInNumber( (BigDecimal)map.get(GoodsStockMeta.STOCK_IN_NUMBER));
				this.setAmount( (BigDecimal)map.get(GoodsStockMeta.AMOUNT));
				this.setStockMax( (BigDecimal)map.get(GoodsStockMeta.STOCK_MAX));
				this.setUseOrgId( (String)map.get(GoodsStockMeta.USE_ORG_ID));
				this.setBatchCode( (String)map.get(GoodsStockMeta.BATCH_CODE));
				this.setManufacturerId( (String)map.get(GoodsStockMeta.MANUFACTURER_ID));
				this.setUpdateTime( (Date)map.get(GoodsStockMeta.UPDATE_TIME));
				this.setManagerId( (String)map.get(GoodsStockMeta.MANAGER_ID));
				this.setStorageDate( (Date)map.get(GoodsStockMeta.STORAGE_DATE));
				this.setPositionDetail( (String)map.get(GoodsStockMeta.POSITION_DETAIL));
				this.setStockCurNumber( (BigDecimal)map.get(GoodsStockMeta.STOCK_CUR_NUMBER));
				this.setCreateBy( (String)map.get(GoodsStockMeta.CREATE_BY));
				this.setRealStockId( (String)map.get(GoodsStockMeta.REAL_STOCK_ID));
				this.setDeleted( (Integer)map.get(GoodsStockMeta.DELETED));
				this.setGoodsStatus( (String)map.get(GoodsStockMeta.GOODS_STATUS));
				this.setPositionId( (String)map.get(GoodsStockMeta.POSITION_ID));
				this.setCreateTime( (Date)map.get(GoodsStockMeta.CREATE_TIME));
				this.setTenantId( (String)map.get(GoodsStockMeta.TENANT_ID));
				this.setCategoryId( (String)map.get(GoodsStockMeta.CATEGORY_ID));
				// others
				this.setOwnerCompany( (Organization)map.get(GoodsStockMeta.OWNER_COMPANY));
				this.setGoodsStockSecurity( (String)map.get(GoodsStockMeta.GOODS_STOCK_SECURITY));
				this.setRelatedAssetCount( (Integer)map.get(GoodsStockMeta.RELATED_ASSET_COUNT));
				this.setGoods( (GoodsStock)map.get(GoodsStockMeta.GOODS));
				this.setSource( (DictItem)map.get(GoodsStockMeta.SOURCE));
				this.setOriginator( (Employee)map.get(GoodsStockMeta.ORIGINATOR));
				this.setGoodsModel( (String)map.get(GoodsStockMeta.GOODS_MODEL));
				this.setManufacturer( (Manufacturer)map.get(GoodsStockMeta.MANUFACTURER));
				this.setGoodsBarCode( (String)map.get(GoodsStockMeta.GOODS_BAR_CODE));
				this.setWarehouseByPosition( (Warehouse)map.get(GoodsStockMeta.WAREHOUSE_BY_POSITION));
				this.setGoodsUnit( (String)map.get(GoodsStockMeta.GOODS_UNIT));
				this.setSearchRelType( (String)map.get(GoodsStockMeta.SEARCH_REL_TYPE));
				this.setBrand( (Brand)map.get(GoodsStockMeta.BRAND));
				this.setGoodsName( (String)map.get(GoodsStockMeta.GOODS_NAME));
				this.setGoodsStockMax( (String)map.get(GoodsStockMeta.GOODS_STOCK_MAX));
				this.setManager( (Employee)map.get(GoodsStockMeta.MANAGER));
				this.setRelatedGoodsStockCount( (Integer)map.get(GoodsStockMeta.RELATED_GOODS_STOCK_COUNT));
				this.setGoodsStockMin( (String)map.get(GoodsStockMeta.GOODS_STOCK_MIN));
				this.setWarehouse( (Warehouse)map.get(GoodsStockMeta.WAREHOUSE));
				this.setRealGoods( (GoodsStock)map.get(GoodsStockMeta.REAL_GOODS));
				this.setWarehousePosition( (WarehousePosition)map.get(GoodsStockMeta.WAREHOUSE_POSITION));
				this.setGoodsByBrand( (Brand)map.get(GoodsStockMeta.GOODS_BY_BRAND));
				this.setUseOrganization( (Organization)map.get(GoodsStockMeta.USE_ORGANIZATION));
				this.setGoodsCategoryName( (String)map.get(GoodsStockMeta.GOODS_CATEGORY_NAME));
				this.setGoodsStockNotes( (String)map.get(GoodsStockMeta.GOODS_STOCK_NOTES));
				this.setGoodsByManufacturer( (Manufacturer)map.get(GoodsStockMeta.GOODS_BY_MANUFACTURER));
				this.setGoodsCode( (String)map.get(GoodsStockMeta.GOODS_CODE));
				this.setCategory( (Catalog)map.get(GoodsStockMeta.CATEGORY));
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
			this.setOwnerType(DataParser.parse(String.class, r.getValue(GoodsStockMeta.OWNER_TYPE)));
			this.setSourceId(DataParser.parse(String.class, r.getValue(GoodsStockMeta.SOURCE_ID)));
			this.setInterOperType(DataParser.parse(String.class, r.getValue(GoodsStockMeta.INTER_OPER_TYPE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(GoodsStockMeta.NOTES)));
			this.setStockSecurity(DataParser.parse(BigDecimal.class, r.getValue(GoodsStockMeta.STOCK_SECURITY)));
			this.setOwnerTmpId(DataParser.parse(String.class, r.getValue(GoodsStockMeta.OWNER_TMP_ID)));
			this.setPid(DataParser.parse(String.class, r.getValue(GoodsStockMeta.PID)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(GoodsStockMeta.OWNER_ID)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(GoodsStockMeta.BUSINESS_CODE)));
			this.setModel(DataParser.parse(String.class, r.getValue(GoodsStockMeta.MODEL)));
			this.setId(DataParser.parse(String.class, r.getValue(GoodsStockMeta.ID)));
			this.setUnitPrice(DataParser.parse(BigDecimal.class, r.getValue(GoodsStockMeta.UNIT_PRICE)));
			this.setMaintenanceRecommendation(DataParser.parse(String.class, r.getValue(GoodsStockMeta.MAINTENANCE_RECOMMENDATION)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(GoodsStockMeta.VERSION)));
			this.setBarCode(DataParser.parse(String.class, r.getValue(GoodsStockMeta.BAR_CODE)));
			this.setUnit(DataParser.parse(String.class, r.getValue(GoodsStockMeta.UNIT)));
			this.setOwnCompanyId(DataParser.parse(String.class, r.getValue(GoodsStockMeta.OWN_COMPANY_ID)));
			this.setWarehouseId(DataParser.parse(String.class, r.getValue(GoodsStockMeta.WAREHOUSE_ID)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(GoodsStockMeta.DELETE_TIME)));
			this.setBrandId(DataParser.parse(String.class, r.getValue(GoodsStockMeta.BRAND_ID)));
			this.setAssetCategoryId(DataParser.parse(String.class, r.getValue(GoodsStockMeta.ASSET_CATEGORY_ID)));
			this.setName(DataParser.parse(String.class, r.getValue(GoodsStockMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(GoodsStockMeta.DELETE_BY)));
			this.setInspectionRecommendation(DataParser.parse(String.class, r.getValue(GoodsStockMeta.INSPECTION_RECOMMENDATION)));
			this.setStatus(DataParser.parse(String.class, r.getValue(GoodsStockMeta.STATUS)));
			this.setCode(DataParser.parse(String.class, r.getValue(GoodsStockMeta.CODE)));
			this.setOwnerCode(DataParser.parse(String.class, r.getValue(GoodsStockMeta.OWNER_CODE)));
			this.setGoodsId(DataParser.parse(String.class, r.getValue(GoodsStockMeta.GOODS_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(GoodsStockMeta.SELECTED_CODE)));
			this.setStockMin(DataParser.parse(BigDecimal.class, r.getValue(GoodsStockMeta.STOCK_MIN)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(GoodsStockMeta.PICTURE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(GoodsStockMeta.UPDATE_BY)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(GoodsStockMeta.ORIGINATOR_ID)));
			this.setSn(DataParser.parse(String.class, r.getValue(GoodsStockMeta.SN)));
			this.setSupplierName(DataParser.parse(String.class, r.getValue(GoodsStockMeta.SUPPLIER_NAME)));
			this.setStockInNumber(DataParser.parse(BigDecimal.class, r.getValue(GoodsStockMeta.STOCK_IN_NUMBER)));
			this.setAmount(DataParser.parse(BigDecimal.class, r.getValue(GoodsStockMeta.AMOUNT)));
			this.setStockMax(DataParser.parse(BigDecimal.class, r.getValue(GoodsStockMeta.STOCK_MAX)));
			this.setUseOrgId(DataParser.parse(String.class, r.getValue(GoodsStockMeta.USE_ORG_ID)));
			this.setBatchCode(DataParser.parse(String.class, r.getValue(GoodsStockMeta.BATCH_CODE)));
			this.setManufacturerId(DataParser.parse(String.class, r.getValue(GoodsStockMeta.MANUFACTURER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(GoodsStockMeta.UPDATE_TIME)));
			this.setManagerId(DataParser.parse(String.class, r.getValue(GoodsStockMeta.MANAGER_ID)));
			this.setStorageDate(DataParser.parse(Date.class, r.getValue(GoodsStockMeta.STORAGE_DATE)));
			this.setPositionDetail(DataParser.parse(String.class, r.getValue(GoodsStockMeta.POSITION_DETAIL)));
			this.setStockCurNumber(DataParser.parse(BigDecimal.class, r.getValue(GoodsStockMeta.STOCK_CUR_NUMBER)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(GoodsStockMeta.CREATE_BY)));
			this.setRealStockId(DataParser.parse(String.class, r.getValue(GoodsStockMeta.REAL_STOCK_ID)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(GoodsStockMeta.DELETED)));
			this.setGoodsStatus(DataParser.parse(String.class, r.getValue(GoodsStockMeta.GOODS_STATUS)));
			this.setPositionId(DataParser.parse(String.class, r.getValue(GoodsStockMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(GoodsStockMeta.CREATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(GoodsStockMeta.TENANT_ID)));
			this.setCategoryId(DataParser.parse(String.class, r.getValue(GoodsStockMeta.CATEGORY_ID)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)r.getValue(GoodsStockMeta.OWNER_TYPE));
				this.setSourceId( (String)r.getValue(GoodsStockMeta.SOURCE_ID));
				this.setInterOperType( (String)r.getValue(GoodsStockMeta.INTER_OPER_TYPE));
				this.setNotes( (String)r.getValue(GoodsStockMeta.NOTES));
				this.setStockSecurity( (BigDecimal)r.getValue(GoodsStockMeta.STOCK_SECURITY));
				this.setOwnerTmpId( (String)r.getValue(GoodsStockMeta.OWNER_TMP_ID));
				this.setPid( (String)r.getValue(GoodsStockMeta.PID));
				this.setOwnerId( (String)r.getValue(GoodsStockMeta.OWNER_ID));
				this.setBusinessCode( (String)r.getValue(GoodsStockMeta.BUSINESS_CODE));
				this.setModel( (String)r.getValue(GoodsStockMeta.MODEL));
				this.setId( (String)r.getValue(GoodsStockMeta.ID));
				this.setUnitPrice( (BigDecimal)r.getValue(GoodsStockMeta.UNIT_PRICE));
				this.setMaintenanceRecommendation( (String)r.getValue(GoodsStockMeta.MAINTENANCE_RECOMMENDATION));
				this.setVersion( (Integer)r.getValue(GoodsStockMeta.VERSION));
				this.setBarCode( (String)r.getValue(GoodsStockMeta.BAR_CODE));
				this.setUnit( (String)r.getValue(GoodsStockMeta.UNIT));
				this.setOwnCompanyId( (String)r.getValue(GoodsStockMeta.OWN_COMPANY_ID));
				this.setWarehouseId( (String)r.getValue(GoodsStockMeta.WAREHOUSE_ID));
				this.setDeleteTime( (Date)r.getValue(GoodsStockMeta.DELETE_TIME));
				this.setBrandId( (String)r.getValue(GoodsStockMeta.BRAND_ID));
				this.setAssetCategoryId( (String)r.getValue(GoodsStockMeta.ASSET_CATEGORY_ID));
				this.setName( (String)r.getValue(GoodsStockMeta.NAME));
				this.setDeleteBy( (String)r.getValue(GoodsStockMeta.DELETE_BY));
				this.setInspectionRecommendation( (String)r.getValue(GoodsStockMeta.INSPECTION_RECOMMENDATION));
				this.setStatus( (String)r.getValue(GoodsStockMeta.STATUS));
				this.setCode( (String)r.getValue(GoodsStockMeta.CODE));
				this.setOwnerCode( (String)r.getValue(GoodsStockMeta.OWNER_CODE));
				this.setGoodsId( (String)r.getValue(GoodsStockMeta.GOODS_ID));
				this.setSelectedCode( (String)r.getValue(GoodsStockMeta.SELECTED_CODE));
				this.setStockMin( (BigDecimal)r.getValue(GoodsStockMeta.STOCK_MIN));
				this.setPictureId( (String)r.getValue(GoodsStockMeta.PICTURE_ID));
				this.setUpdateBy( (String)r.getValue(GoodsStockMeta.UPDATE_BY));
				this.setOriginatorId( (String)r.getValue(GoodsStockMeta.ORIGINATOR_ID));
				this.setSn( (String)r.getValue(GoodsStockMeta.SN));
				this.setSupplierName( (String)r.getValue(GoodsStockMeta.SUPPLIER_NAME));
				this.setStockInNumber( (BigDecimal)r.getValue(GoodsStockMeta.STOCK_IN_NUMBER));
				this.setAmount( (BigDecimal)r.getValue(GoodsStockMeta.AMOUNT));
				this.setStockMax( (BigDecimal)r.getValue(GoodsStockMeta.STOCK_MAX));
				this.setUseOrgId( (String)r.getValue(GoodsStockMeta.USE_ORG_ID));
				this.setBatchCode( (String)r.getValue(GoodsStockMeta.BATCH_CODE));
				this.setManufacturerId( (String)r.getValue(GoodsStockMeta.MANUFACTURER_ID));
				this.setUpdateTime( (Date)r.getValue(GoodsStockMeta.UPDATE_TIME));
				this.setManagerId( (String)r.getValue(GoodsStockMeta.MANAGER_ID));
				this.setStorageDate( (Date)r.getValue(GoodsStockMeta.STORAGE_DATE));
				this.setPositionDetail( (String)r.getValue(GoodsStockMeta.POSITION_DETAIL));
				this.setStockCurNumber( (BigDecimal)r.getValue(GoodsStockMeta.STOCK_CUR_NUMBER));
				this.setCreateBy( (String)r.getValue(GoodsStockMeta.CREATE_BY));
				this.setRealStockId( (String)r.getValue(GoodsStockMeta.REAL_STOCK_ID));
				this.setDeleted( (Integer)r.getValue(GoodsStockMeta.DELETED));
				this.setGoodsStatus( (String)r.getValue(GoodsStockMeta.GOODS_STATUS));
				this.setPositionId( (String)r.getValue(GoodsStockMeta.POSITION_ID));
				this.setCreateTime( (Date)r.getValue(GoodsStockMeta.CREATE_TIME));
				this.setTenantId( (String)r.getValue(GoodsStockMeta.TENANT_ID));
				this.setCategoryId( (String)r.getValue(GoodsStockMeta.CATEGORY_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}