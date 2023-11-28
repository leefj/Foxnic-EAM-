package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_STOCK_IMPORT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Organization;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.StockImportMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 库存导入资产
 * <p>库存导入资产 , 数据表 eam_stock_import 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-11-28 21:41:17
 * @sign 6567C1F79AC5588F266C364206171935
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_stock_import")
@ApiModel(description = "库存导入资产 ; 库存导入资产 , 数据表 eam_stock_import 的PO类型")
public class StockImport extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_STOCK_IMPORT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "781993200737845248")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "hjk")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "wait")
	private String status;
	
	/**
	 * 库存单：库存单
	*/
	@ApiModelProperty(required = false,value="库存单" , notes = "库存单" , example = "781983904973193216")
	private String orderId;
	
	/**
	 * 订单编号：订单编号
	*/
	@ApiModelProperty(required = false,value="订单编号" , notes = "订单编号")
	private String orderCode;
	
	/**
	 * 订单名称：订单名称
	*/
	@ApiModelProperty(required = false,value="订单名称" , notes = "订单名称")
	private String orderName;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private String ownCompanyId;
	
	/**
	 * 所属组织：所属组织
	*/
	@ApiModelProperty(required = false,value="所属组织" , notes = "所属组织")
	private String useOrgId;
	
	/**
	 * 管理人：管理人
	*/
	@ApiModelProperty(required = false,value="管理人" , notes = "管理人")
	private String managerId;
	
	/**
	 * 使用人：使用人
	*/
	@ApiModelProperty(required = false,value="使用人" , notes = "使用人")
	private String useUserId;
	
	/**
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置")
	private String positionId;
	
	/**
	 * 采购日期：采购日期
	*/
	@ApiModelProperty(required = false,value="采购日期" , notes = "采购日期")
	private String purchaseDate;
	
	/**
	 * 资产备注：资产备注
	*/
	@ApiModelProperty(required = false,value="资产备注" , notes = "资产备注")
	private String assetNotes;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 操作人：操作人
	*/
	@ApiModelProperty(required = false,value="操作人" , notes = "操作人" , example = "E001")
	private String operUserId;
	
	/**
	 * 导入类型：导入类型
	*/
	@ApiModelProperty(required = false,value="导入类型" , notes = "导入类型")
	private String importToType;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-11-28 09:21:48")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-11-28 09:40:18")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "4")
	private Integer version;
	
	/**
	 * 操作人员：操作人员
	*/
	@ApiModelProperty(required = false,value="操作人员" , notes = "操作人员")
	private Employee operUser;
	
	/**
	 * stockGoodsOut：stockGoodsOut
	*/
	@ApiModelProperty(required = false,value="stockGoodsOut" , notes = "stockGoodsOut")
	private AssetStockGoodsOut stockGoodsOut;
	
	/**
	 * assetList：assetList
	*/
	@ApiModelProperty(required = false,value="assetList" , notes = "assetList")
	private List<Asset> assetList;
	
	/**
	 * selectedCode：selectedCode
	*/
	@ApiModelProperty(required = false,value="selectedCode" , notes = "selectedCode")
	private String selectedCode;
	
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
	 * 使用人员：使用人员
	*/
	@ApiModelProperty(required = false,value="使用人员" , notes = "使用人员")
	private Employee useUser;
	
	/**
	 * 管理人员：管理人员
	*/
	@ApiModelProperty(required = false,value="管理人员" , notes = "管理人员")
	private Employee manager;
	
	/**
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置")
	private Position position;
	
	/**
	 * 填充数据：填充数据
	*/
	@ApiModelProperty(required = false,value="填充数据" , notes = "填充数据")
	private String fill;
	
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
	public StockImport setId(String id) {
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
	public StockImport setName(String name) {
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
	public StockImport setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 库存单<br>
	 * 库存单
	 * @return 库存单
	*/
	public String getOrderId() {
		return orderId;
	}
	
	/**
	 * 设置 库存单
	 * @param orderId 库存单
	 * @return 当前对象
	*/
	public StockImport setOrderId(String orderId) {
		this.orderId=orderId;
		return this;
	}
	
	/**
	 * 获得 订单编号<br>
	 * 订单编号
	 * @return 订单编号
	*/
	public String getOrderCode() {
		return orderCode;
	}
	
	/**
	 * 设置 订单编号
	 * @param orderCode 订单编号
	 * @return 当前对象
	*/
	public StockImport setOrderCode(String orderCode) {
		this.orderCode=orderCode;
		return this;
	}
	
	/**
	 * 获得 订单名称<br>
	 * 订单名称
	 * @return 订单名称
	*/
	public String getOrderName() {
		return orderName;
	}
	
	/**
	 * 设置 订单名称
	 * @param orderName 订单名称
	 * @return 当前对象
	*/
	public StockImport setOrderName(String orderName) {
		this.orderName=orderName;
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
	public StockImport setOwnCompanyId(String ownCompanyId) {
		this.ownCompanyId=ownCompanyId;
		return this;
	}
	
	/**
	 * 获得 所属组织<br>
	 * 所属组织
	 * @return 所属组织
	*/
	public String getUseOrgId() {
		return useOrgId;
	}
	
	/**
	 * 设置 所属组织
	 * @param useOrgId 所属组织
	 * @return 当前对象
	*/
	public StockImport setUseOrgId(String useOrgId) {
		this.useOrgId=useOrgId;
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
	public StockImport setManagerId(String managerId) {
		this.managerId=managerId;
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
	public StockImport setUseUserId(String useUserId) {
		this.useUserId=useUserId;
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
	public StockImport setPositionId(String positionId) {
		this.positionId=positionId;
		return this;
	}
	
	/**
	 * 获得 采购日期<br>
	 * 采购日期
	 * @return 采购日期
	*/
	public String getPurchaseDate() {
		return purchaseDate;
	}
	
	/**
	 * 设置 采购日期
	 * @param purchaseDate 采购日期
	 * @return 当前对象
	*/
	public StockImport setPurchaseDate(String purchaseDate) {
		this.purchaseDate=purchaseDate;
		return this;
	}
	
	/**
	 * 获得 资产备注<br>
	 * 资产备注
	 * @return 资产备注
	*/
	public String getAssetNotes() {
		return assetNotes;
	}
	
	/**
	 * 设置 资产备注
	 * @param assetNotes 资产备注
	 * @return 当前对象
	*/
	public StockImport setAssetNotes(String assetNotes) {
		this.assetNotes=assetNotes;
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
	public StockImport setNotes(String notes) {
		this.notes=notes;
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
	public StockImport setOperUserId(String operUserId) {
		this.operUserId=operUserId;
		return this;
	}
	
	/**
	 * 获得 导入类型<br>
	 * 导入类型
	 * @return 导入类型
	*/
	public String getImportToType() {
		return importToType;
	}
	
	/**
	 * 设置 导入类型
	 * @param importToType 导入类型
	 * @return 当前对象
	*/
	public StockImport setImportToType(String importToType) {
		this.importToType=importToType;
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
	public StockImport setCreateBy(String createBy) {
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
	public StockImport setCreateTime(Date createTime) {
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
	public StockImport setUpdateBy(String updateBy) {
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
	public StockImport setUpdateTime(Date updateTime) {
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
	public StockImport setDeleted(Integer deleted) {
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
	public StockImport setDeleted(Boolean deletedBool) {
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
	public StockImport setDeleteBy(String deleteBy) {
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
	public StockImport setDeleteTime(Date deleteTime) {
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
	public StockImport setTenantId(String tenantId) {
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
	public StockImport setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 操作人员<br>
	 * 操作人员
	 * @return 操作人员
	*/
	public Employee getOperUser() {
		return operUser;
	}
	
	/**
	 * 设置 操作人员
	 * @param operUser 操作人员
	 * @return 当前对象
	*/
	public StockImport setOperUser(Employee operUser) {
		this.operUser=operUser;
		return this;
	}
	
	/**
	 * 获得 stockGoodsOut<br>
	 * stockGoodsOut
	 * @return stockGoodsOut
	*/
	public AssetStockGoodsOut getStockGoodsOut() {
		return stockGoodsOut;
	}
	
	/**
	 * 设置 stockGoodsOut
	 * @param stockGoodsOut stockGoodsOut
	 * @return 当前对象
	*/
	public StockImport setStockGoodsOut(AssetStockGoodsOut stockGoodsOut) {
		this.stockGoodsOut=stockGoodsOut;
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
	public StockImport setAssetList(List<Asset> assetList) {
		this.assetList=assetList;
		return this;
	}
	
	/**
	 * 添加 assetList
	 * @param asset assetList
	 * @return 当前对象
	*/
	public StockImport addAsset(Asset... asset) {
		if(this.assetList==null) assetList=new ArrayList<>();
		this.assetList.addAll(Arrays.asList(asset));
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
	public StockImport setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public StockImport setOwnerCompany(Organization ownerCompany) {
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
	public StockImport setUseOrganization(Organization useOrganization) {
		this.useOrganization=useOrganization;
		return this;
	}
	
	/**
	 * 获得 使用人员<br>
	 * 使用人员
	 * @return 使用人员
	*/
	public Employee getUseUser() {
		return useUser;
	}
	
	/**
	 * 设置 使用人员
	 * @param useUser 使用人员
	 * @return 当前对象
	*/
	public StockImport setUseUser(Employee useUser) {
		this.useUser=useUser;
		return this;
	}
	
	/**
	 * 获得 管理人员<br>
	 * 管理人员
	 * @return 管理人员
	*/
	public Employee getManager() {
		return manager;
	}
	
	/**
	 * 设置 管理人员
	 * @param manager 管理人员
	 * @return 当前对象
	*/
	public StockImport setManager(Employee manager) {
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
	public StockImport setPosition(Position position) {
		this.position=position;
		return this;
	}
	
	/**
	 * 获得 填充数据<br>
	 * 填充数据
	 * @return 填充数据
	*/
	public String getFill() {
		return fill;
	}
	
	/**
	 * 设置 填充数据
	 * @param fill 填充数据
	 * @return 当前对象
	*/
	public StockImport setFill(String fill) {
		this.fill=fill;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return StockImport , 转换好的 StockImport 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return StockImport , 转换好的 PoJo 对象
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
	public StockImport clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public StockImport duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.StockImportMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.StockImportMeta.$$proxy$$();
		inst.setOperUserId(this.getOperUserId());
		inst.setPurchaseDate(this.getPurchaseDate());
		inst.setNotes(this.getNotes());
		inst.setOrderId(this.getOrderId());
		inst.setAssetNotes(this.getAssetNotes());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setOrderName(this.getOrderName());
		inst.setImportToType(this.getImportToType());
		inst.setUseOrgId(this.getUseOrgId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setManagerId(this.getManagerId());
		inst.setVersion(this.getVersion());
		inst.setOwnCompanyId(this.getOwnCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPositionId(this.getPositionId());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setOrderCode(this.getOrderCode());
		inst.setUseUserId(this.getUseUserId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setOwnerCompany(this.getOwnerCompany());
			inst.setUseOrganization(this.getUseOrganization());
			inst.setStockGoodsOut(this.getStockGoodsOut());
			inst.setManager(this.getManager());
			inst.setPosition(this.getPosition());
			inst.setAssetList(this.getAssetList());
			inst.setUseUser(this.getUseUser());
			inst.setFill(this.getFill());
			inst.setOperUser(this.getOperUser());
			inst.setSelectedCode(this.getSelectedCode());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public StockImport clone(boolean deep) {
		return EntityContext.clone(StockImport.class,this,deep);
	}

	/**
	 * 将 Map 转换成 StockImport
	 * @param stockImportMap 包含实体信息的 Map 对象
	 * @return StockImport , 转换好的的 StockImport 对象
	*/
	@Transient
	public static StockImport createFrom(Map<String,Object> stockImportMap) {
		if(stockImportMap==null) return null;
		StockImport po = create();
		EntityContext.copyProperties(po,stockImportMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 StockImport
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return StockImport , 转换好的的 StockImport 对象
	*/
	@Transient
	public static StockImport createFrom(Object pojo) {
		if(pojo==null) return null;
		StockImport po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 StockImport，等同于 new
	 * @return StockImport 对象
	*/
	@Transient
	public static StockImport create() {
		return new com.dt.platform.domain.eam.meta.StockImportMeta.$$proxy$$();
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
			this.setOperUserId(DataParser.parse(String.class, map.get(StockImportMeta.OPER_USER_ID)));
			this.setPurchaseDate(DataParser.parse(String.class, map.get(StockImportMeta.PURCHASE_DATE)));
			this.setNotes(DataParser.parse(String.class, map.get(StockImportMeta.NOTES)));
			this.setOrderId(DataParser.parse(String.class, map.get(StockImportMeta.ORDER_ID)));
			this.setAssetNotes(DataParser.parse(String.class, map.get(StockImportMeta.ASSET_NOTES)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(StockImportMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(StockImportMeta.ID)));
			this.setOrderName(DataParser.parse(String.class, map.get(StockImportMeta.ORDER_NAME)));
			this.setImportToType(DataParser.parse(String.class, map.get(StockImportMeta.IMPORT_TO_TYPE)));
			this.setUseOrgId(DataParser.parse(String.class, map.get(StockImportMeta.USE_ORG_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(StockImportMeta.UPDATE_TIME)));
			this.setManagerId(DataParser.parse(String.class, map.get(StockImportMeta.MANAGER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(StockImportMeta.VERSION)));
			this.setOwnCompanyId(DataParser.parse(String.class, map.get(StockImportMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(StockImportMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(StockImportMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, map.get(StockImportMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(StockImportMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(StockImportMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(StockImportMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(StockImportMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(StockImportMeta.DELETE_BY)));
			this.setOrderCode(DataParser.parse(String.class, map.get(StockImportMeta.ORDER_CODE)));
			this.setUseUserId(DataParser.parse(String.class, map.get(StockImportMeta.USE_USER_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(StockImportMeta.STATUS)));
			// others
			this.setOwnerCompany(DataParser.parse(Organization.class, map.get(StockImportMeta.OWNER_COMPANY)));
			this.setUseOrganization(DataParser.parse(Organization.class, map.get(StockImportMeta.USE_ORGANIZATION)));
			this.setStockGoodsOut(DataParser.parse(AssetStockGoodsOut.class, map.get(StockImportMeta.STOCK_GOODS_OUT)));
			this.setManager(DataParser.parse(Employee.class, map.get(StockImportMeta.MANAGER)));
			this.setPosition(DataParser.parse(Position.class, map.get(StockImportMeta.POSITION)));
			this.setUseUser(DataParser.parse(Employee.class, map.get(StockImportMeta.USE_USER)));
			this.setFill(DataParser.parse(String.class, map.get(StockImportMeta.FILL)));
			this.setOperUser(DataParser.parse(Employee.class, map.get(StockImportMeta.OPER_USER)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(StockImportMeta.SELECTED_CODE)));
			return true;
		} else {
			try {
				this.setOperUserId( (String)map.get(StockImportMeta.OPER_USER_ID));
				this.setPurchaseDate( (String)map.get(StockImportMeta.PURCHASE_DATE));
				this.setNotes( (String)map.get(StockImportMeta.NOTES));
				this.setOrderId( (String)map.get(StockImportMeta.ORDER_ID));
				this.setAssetNotes( (String)map.get(StockImportMeta.ASSET_NOTES));
				this.setUpdateBy( (String)map.get(StockImportMeta.UPDATE_BY));
				this.setId( (String)map.get(StockImportMeta.ID));
				this.setOrderName( (String)map.get(StockImportMeta.ORDER_NAME));
				this.setImportToType( (String)map.get(StockImportMeta.IMPORT_TO_TYPE));
				this.setUseOrgId( (String)map.get(StockImportMeta.USE_ORG_ID));
				this.setUpdateTime( (Date)map.get(StockImportMeta.UPDATE_TIME));
				this.setManagerId( (String)map.get(StockImportMeta.MANAGER_ID));
				this.setVersion( (Integer)map.get(StockImportMeta.VERSION));
				this.setOwnCompanyId( (String)map.get(StockImportMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)map.get(StockImportMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(StockImportMeta.DELETED));
				this.setPositionId( (String)map.get(StockImportMeta.POSITION_ID));
				this.setCreateTime( (Date)map.get(StockImportMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(StockImportMeta.DELETE_TIME));
				this.setName( (String)map.get(StockImportMeta.NAME));
				this.setTenantId( (String)map.get(StockImportMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(StockImportMeta.DELETE_BY));
				this.setOrderCode( (String)map.get(StockImportMeta.ORDER_CODE));
				this.setUseUserId( (String)map.get(StockImportMeta.USE_USER_ID));
				this.setStatus( (String)map.get(StockImportMeta.STATUS));
				// others
				this.setOwnerCompany( (Organization)map.get(StockImportMeta.OWNER_COMPANY));
				this.setUseOrganization( (Organization)map.get(StockImportMeta.USE_ORGANIZATION));
				this.setStockGoodsOut( (AssetStockGoodsOut)map.get(StockImportMeta.STOCK_GOODS_OUT));
				this.setManager( (Employee)map.get(StockImportMeta.MANAGER));
				this.setPosition( (Position)map.get(StockImportMeta.POSITION));
				this.setUseUser( (Employee)map.get(StockImportMeta.USE_USER));
				this.setFill( (String)map.get(StockImportMeta.FILL));
				this.setOperUser( (Employee)map.get(StockImportMeta.OPER_USER));
				this.setSelectedCode( (String)map.get(StockImportMeta.SELECTED_CODE));
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
			this.setOperUserId(DataParser.parse(String.class, r.getValue(StockImportMeta.OPER_USER_ID)));
			this.setPurchaseDate(DataParser.parse(String.class, r.getValue(StockImportMeta.PURCHASE_DATE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(StockImportMeta.NOTES)));
			this.setOrderId(DataParser.parse(String.class, r.getValue(StockImportMeta.ORDER_ID)));
			this.setAssetNotes(DataParser.parse(String.class, r.getValue(StockImportMeta.ASSET_NOTES)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(StockImportMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(StockImportMeta.ID)));
			this.setOrderName(DataParser.parse(String.class, r.getValue(StockImportMeta.ORDER_NAME)));
			this.setImportToType(DataParser.parse(String.class, r.getValue(StockImportMeta.IMPORT_TO_TYPE)));
			this.setUseOrgId(DataParser.parse(String.class, r.getValue(StockImportMeta.USE_ORG_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(StockImportMeta.UPDATE_TIME)));
			this.setManagerId(DataParser.parse(String.class, r.getValue(StockImportMeta.MANAGER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(StockImportMeta.VERSION)));
			this.setOwnCompanyId(DataParser.parse(String.class, r.getValue(StockImportMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(StockImportMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(StockImportMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, r.getValue(StockImportMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(StockImportMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(StockImportMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(StockImportMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(StockImportMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(StockImportMeta.DELETE_BY)));
			this.setOrderCode(DataParser.parse(String.class, r.getValue(StockImportMeta.ORDER_CODE)));
			this.setUseUserId(DataParser.parse(String.class, r.getValue(StockImportMeta.USE_USER_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(StockImportMeta.STATUS)));
			return true;
		} else {
			try {
				this.setOperUserId( (String)r.getValue(StockImportMeta.OPER_USER_ID));
				this.setPurchaseDate( (String)r.getValue(StockImportMeta.PURCHASE_DATE));
				this.setNotes( (String)r.getValue(StockImportMeta.NOTES));
				this.setOrderId( (String)r.getValue(StockImportMeta.ORDER_ID));
				this.setAssetNotes( (String)r.getValue(StockImportMeta.ASSET_NOTES));
				this.setUpdateBy( (String)r.getValue(StockImportMeta.UPDATE_BY));
				this.setId( (String)r.getValue(StockImportMeta.ID));
				this.setOrderName( (String)r.getValue(StockImportMeta.ORDER_NAME));
				this.setImportToType( (String)r.getValue(StockImportMeta.IMPORT_TO_TYPE));
				this.setUseOrgId( (String)r.getValue(StockImportMeta.USE_ORG_ID));
				this.setUpdateTime( (Date)r.getValue(StockImportMeta.UPDATE_TIME));
				this.setManagerId( (String)r.getValue(StockImportMeta.MANAGER_ID));
				this.setVersion( (Integer)r.getValue(StockImportMeta.VERSION));
				this.setOwnCompanyId( (String)r.getValue(StockImportMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)r.getValue(StockImportMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(StockImportMeta.DELETED));
				this.setPositionId( (String)r.getValue(StockImportMeta.POSITION_ID));
				this.setCreateTime( (Date)r.getValue(StockImportMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(StockImportMeta.DELETE_TIME));
				this.setName( (String)r.getValue(StockImportMeta.NAME));
				this.setTenantId( (String)r.getValue(StockImportMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(StockImportMeta.DELETE_BY));
				this.setOrderCode( (String)r.getValue(StockImportMeta.ORDER_CODE));
				this.setUseUserId( (String)r.getValue(StockImportMeta.USE_USER_ID));
				this.setStatus( (String)r.getValue(StockImportMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}