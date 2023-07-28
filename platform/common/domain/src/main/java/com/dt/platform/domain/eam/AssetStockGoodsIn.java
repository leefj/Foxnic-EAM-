package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_STOCK_GOODS_IN;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetStockGoodsInMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 库存物品单
 * <p>库存物品单 , 数据表 eam_asset_stock_goods_in 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-28 15:04:03
 * @sign 061D0D02BD941206BDE42612D2D28924
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_stock_goods_in")
@ApiModel(description = "库存物品单 ; 库存物品单 , 数据表 eam_asset_stock_goods_in 的PO类型")
public class AssetStockGoodsIn extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_STOCK_GOODS_IN.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "732349571098738688")
	private String id;
	
	/**
	 * 库存所属：库存所属
	*/
	@ApiModelProperty(required = false,value="库存所属" , notes = "库存所属" , example = "part")
	private String ownerType;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号" , example = "PI202335142135708")
	private String businessCode;
	
	/**
	 * 流程：流程
	*/
	@ApiModelProperty(required = false,value="流程" , notes = "流程")
	private String procId;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态" , example = "complete")
	private String status;
	
	/**
	 * 单据名称：单据名称
	*/
	@ApiModelProperty(required = false,value="单据名称" , notes = "单据名称" , example = "新建北京")
	private String name;
	
	/**
	 * 批次号：批次号
	*/
	@ApiModelProperty(required = false,value="批次号" , notes = "批次号" , example = "12121")
	private String batchCode;
	
	/**
	 * 入库类型：入库类型
	*/
	@ApiModelProperty(required = false,value="入库类型" , notes = "入库类型" , example = "normal")
	private String stockType;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库" , example = "582427523481075712")
	private String warehouseId;
	
	/**
	 * 管理人：管理人
	*/
	@ApiModelProperty(required = false,value="管理人" , notes = "管理人")
	private String managerId;
	
	/**
	 * 接收人：接收人
	*/
	@ApiModelProperty(required = false,value="接收人" , notes = "接收人" , example = "12")
	private String receiverUserName;
	
	/**
	 * 总金额：总金额
	*/
	@ApiModelProperty(required = false,value="总金额" , notes = "总金额")
	private BigDecimal amount;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private String ownCompanyId;
	
	/**
	 * 供应商：供应商
	*/
	@ApiModelProperty(required = false,value="供应商" , notes = "供应商" , example = "1212")
	private String supplierName;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "来源" , example = "donation")
	private String sourceId;
	
	/**
	 * 购置日期：购置日期
	*/
	@ApiModelProperty(required = false,value="购置日期" , notes = "购置日期" , example = "2023-07-18 12:00:00")
	private Date purchaseDate;
	
	/**
	 * 业务日期：业务日期
	*/
	@ApiModelProperty(required = false,value="业务日期" , notes = "业务日期" , example = "2023-07-13 12:00:00")
	private Date businessDate;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attachId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "1212")
	private String notes;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-07-14 09:35:44")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-07-14 09:36:23")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "2")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 选择数据：选择数据
	*/
	@ApiModelProperty(required = false,value="选择数据" , notes = "选择数据" , example = "1689341698000")
	private String selectedCode;
	
	/**
	 * 变更类型：变更类型
	*/
	@ApiModelProperty(required = false,value="变更类型" , notes = "变更类型")
	private String chsType;
	
	/**
	 * 变更状态：变更状态
	*/
	@ApiModelProperty(required = false,value="变更状态" , notes = "变更状态")
	private String chsStatus;
	
	/**
	 * 变更版本号：变更版本号
	*/
	@ApiModelProperty(required = false,value="变更版本号" , notes = "变更版本号")
	private String chsVersion;
	
	/**
	 * 变更ID：变更ID
	*/
	@ApiModelProperty(required = false,value="变更ID" , notes = "变更ID")
	private String changeInstanceId;
	
	/**
	 * 流程概要：流程概要
	*/
	@ApiModelProperty(required = false,value="流程概要" , notes = "流程概要")
	private String summary;
	
	/**
	 * 最后审批人账户ID：最后审批人账户ID
	*/
	@ApiModelProperty(required = false,value="最后审批人账户ID" , notes = "最后审批人账户ID")
	private String latestApproverId;
	
	/**
	 * 最后审批人姓名：最后审批人姓名
	*/
	@ApiModelProperty(required = false,value="最后审批人姓名" , notes = "最后审批人姓名")
	private String latestApproverName;
	
	/**
	 * 下一节点审批人：下一节点审批人
	*/
	@ApiModelProperty(required = false,value="下一节点审批人" , notes = "下一节点审批人")
	private String nextApproverIds;
	
	/**
	 * 下一个审批节点审批人姓名：用逗号隔开
	*/
	@ApiModelProperty(required = false,value="下一个审批节点审批人姓名" , notes = "用逗号隔开")
	private String nextApproverNames;
	
	/**
	 * 审批意见：审批意见
	*/
	@ApiModelProperty(required = false,value="审批意见" , notes = "审批意见")
	private String approvalOpinion;
	
	/**
	 * 物品：物品
	*/
	@ApiModelProperty(required = false,value="物品" , notes = "物品")
	private List<GoodsStock> goodsList;
	
	/**
	 * 物品：物品
	*/
	@ApiModelProperty(required = false,value="物品" , notes = "物品")
	private List<String> goodsIds;
	
	/**
	 * 入库类型：入库类型
	*/
	@ApiModelProperty(required = false,value="入库类型" , notes = "入库类型")
	private DictItem stockTypeDict;
	
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
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 管理人：管理人
	*/
	@ApiModelProperty(required = false,value="管理人" , notes = "管理人")
	private Employee manager;
	
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
	public AssetStockGoodsIn setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 库存所属<br>
	 * 库存所属
	 * @return 库存所属
	*/
	public String getOwnerType() {
		return ownerType;
	}
	
	/**
	 * 设置 库存所属
	 * @param ownerType 库存所属
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setOwnerType(String ownerType) {
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
	public AssetStockGoodsIn setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
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
	public AssetStockGoodsIn setProcId(String procId) {
		this.procId=procId;
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
	public AssetStockGoodsIn setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 单据名称<br>
	 * 单据名称
	 * @return 单据名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 单据名称
	 * @param name 单据名称
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setName(String name) {
		this.name=name;
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
	public AssetStockGoodsIn setBatchCode(String batchCode) {
		this.batchCode=batchCode;
		return this;
	}
	
	/**
	 * 获得 入库类型<br>
	 * 入库类型
	 * @return 入库类型
	*/
	public String getStockType() {
		return stockType;
	}
	
	/**
	 * 设置 入库类型
	 * @param stockType 入库类型
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setStockType(String stockType) {
		this.stockType=stockType;
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
	public AssetStockGoodsIn setWarehouseId(String warehouseId) {
		this.warehouseId=warehouseId;
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
	public AssetStockGoodsIn setManagerId(String managerId) {
		this.managerId=managerId;
		return this;
	}
	
	/**
	 * 获得 接收人<br>
	 * 接收人
	 * @return 接收人
	*/
	public String getReceiverUserName() {
		return receiverUserName;
	}
	
	/**
	 * 设置 接收人
	 * @param receiverUserName 接收人
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setReceiverUserName(String receiverUserName) {
		this.receiverUserName=receiverUserName;
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
	public AssetStockGoodsIn setAmount(BigDecimal amount) {
		this.amount=amount;
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
	public AssetStockGoodsIn setOwnCompanyId(String ownCompanyId) {
		this.ownCompanyId=ownCompanyId;
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
	public AssetStockGoodsIn setSupplierName(String supplierName) {
		this.supplierName=supplierName;
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
	public AssetStockGoodsIn setSourceId(String sourceId) {
		this.sourceId=sourceId;
		return this;
	}
	
	/**
	 * 获得 购置日期<br>
	 * 购置日期
	 * @return 购置日期
	*/
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	
	/**
	 * 设置 购置日期
	 * @param purchaseDate 购置日期
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setPurchaseDate(Date purchaseDate) {
		this.purchaseDate=purchaseDate;
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
	public AssetStockGoodsIn setBusinessDate(Date businessDate) {
		this.businessDate=businessDate;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getAttachId() {
		return attachId;
	}
	
	/**
	 * 设置 附件
	 * @param attachId 附件
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setAttachId(String attachId) {
		this.attachId=attachId;
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
	public AssetStockGoodsIn setNotes(String notes) {
		this.notes=notes;
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
	public AssetStockGoodsIn setOriginatorId(String originatorId) {
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
	public AssetStockGoodsIn setCreateBy(String createBy) {
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
	public AssetStockGoodsIn setCreateTime(Date createTime) {
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
	public AssetStockGoodsIn setUpdateBy(String updateBy) {
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
	public AssetStockGoodsIn setUpdateTime(Date updateTime) {
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
	public AssetStockGoodsIn setDeleted(Integer deleted) {
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
	public AssetStockGoodsIn setDeleted(Boolean deletedBool) {
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
	public AssetStockGoodsIn setDeleteBy(String deleteBy) {
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
	public AssetStockGoodsIn setDeleteTime(Date deleteTime) {
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
	public AssetStockGoodsIn setVersion(Integer version) {
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
	public AssetStockGoodsIn setTenantId(String tenantId) {
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
	public AssetStockGoodsIn setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 变更类型<br>
	 * 变更类型
	 * @return 变更类型
	*/
	public String getChsType() {
		return chsType;
	}
	
	/**
	 * 设置 变更类型
	 * @param chsType 变更类型
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setChsType(String chsType) {
		this.chsType=chsType;
		return this;
	}
	
	/**
	 * 获得 变更状态<br>
	 * 变更状态
	 * @return 变更状态
	*/
	public String getChsStatus() {
		return chsStatus;
	}
	
	/**
	 * 设置 变更状态
	 * @param chsStatus 变更状态
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setChsStatus(String chsStatus) {
		this.chsStatus=chsStatus;
		return this;
	}
	
	/**
	 * 获得 变更版本号<br>
	 * 变更版本号
	 * @return 变更版本号
	*/
	public String getChsVersion() {
		return chsVersion;
	}
	
	/**
	 * 设置 变更版本号
	 * @param chsVersion 变更版本号
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setChsVersion(String chsVersion) {
		this.chsVersion=chsVersion;
		return this;
	}
	
	/**
	 * 获得 变更ID<br>
	 * 变更ID
	 * @return 变更ID
	*/
	public String getChangeInstanceId() {
		return changeInstanceId;
	}
	
	/**
	 * 设置 变更ID
	 * @param changeInstanceId 变更ID
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setChangeInstanceId(String changeInstanceId) {
		this.changeInstanceId=changeInstanceId;
		return this;
	}
	
	/**
	 * 获得 流程概要<br>
	 * 流程概要
	 * @return 流程概要
	*/
	public String getSummary() {
		return summary;
	}
	
	/**
	 * 设置 流程概要
	 * @param summary 流程概要
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setSummary(String summary) {
		this.summary=summary;
		return this;
	}
	
	/**
	 * 获得 最后审批人账户ID<br>
	 * 最后审批人账户ID
	 * @return 最后审批人账户ID
	*/
	public String getLatestApproverId() {
		return latestApproverId;
	}
	
	/**
	 * 设置 最后审批人账户ID
	 * @param latestApproverId 最后审批人账户ID
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setLatestApproverId(String latestApproverId) {
		this.latestApproverId=latestApproverId;
		return this;
	}
	
	/**
	 * 获得 最后审批人姓名<br>
	 * 最后审批人姓名
	 * @return 最后审批人姓名
	*/
	public String getLatestApproverName() {
		return latestApproverName;
	}
	
	/**
	 * 设置 最后审批人姓名
	 * @param latestApproverName 最后审批人姓名
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setLatestApproverName(String latestApproverName) {
		this.latestApproverName=latestApproverName;
		return this;
	}
	
	/**
	 * 获得 下一节点审批人<br>
	 * 下一节点审批人
	 * @return 下一节点审批人
	*/
	public String getNextApproverIds() {
		return nextApproverIds;
	}
	
	/**
	 * 设置 下一节点审批人
	 * @param nextApproverIds 下一节点审批人
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setNextApproverIds(String nextApproverIds) {
		this.nextApproverIds=nextApproverIds;
		return this;
	}
	
	/**
	 * 获得 下一个审批节点审批人姓名<br>
	 * 用逗号隔开
	 * @return 下一个审批节点审批人姓名
	*/
	public String getNextApproverNames() {
		return nextApproverNames;
	}
	
	/**
	 * 设置 下一个审批节点审批人姓名
	 * @param nextApproverNames 下一个审批节点审批人姓名
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setNextApproverNames(String nextApproverNames) {
		this.nextApproverNames=nextApproverNames;
		return this;
	}
	
	/**
	 * 获得 审批意见<br>
	 * 审批意见
	 * @return 审批意见
	*/
	public String getApprovalOpinion() {
		return approvalOpinion;
	}
	
	/**
	 * 设置 审批意见
	 * @param approvalOpinion 审批意见
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion=approvalOpinion;
		return this;
	}
	
	/**
	 * 获得 物品<br>
	 * 物品
	 * @return 物品
	*/
	public List<GoodsStock> getGoodsList() {
		return goodsList;
	}
	
	/**
	 * 设置 物品
	 * @param goodsList 物品
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setGoodsList(List<GoodsStock> goodsList) {
		this.goodsList=goodsList;
		return this;
	}
	
	/**
	 * 添加 物品
	 * @param goods 物品
	 * @return 当前对象
	*/
	public AssetStockGoodsIn addGoods(GoodsStock... goods) {
		if(this.goodsList==null) goodsList=new ArrayList<>();
		this.goodsList.addAll(Arrays.asList(goods));
		return this;
	}
	
	/**
	 * 获得 物品<br>
	 * 物品
	 * @return 物品
	*/
	public List<String> getGoodsIds() {
		return goodsIds;
	}
	
	/**
	 * 设置 物品
	 * @param goodsIds 物品
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setGoodsIds(List<String> goodsIds) {
		this.goodsIds=goodsIds;
		return this;
	}
	
	/**
	 * 添加 物品
	 * @param goodsId 物品
	 * @return 当前对象
	*/
	public AssetStockGoodsIn addGoodsId(String... goodsId) {
		if(this.goodsIds==null) goodsIds=new ArrayList<>();
		this.goodsIds.addAll(Arrays.asList(goodsId));
		return this;
	}
	
	/**
	 * 获得 入库类型<br>
	 * 入库类型
	 * @return 入库类型
	*/
	public DictItem getStockTypeDict() {
		return stockTypeDict;
	}
	
	/**
	 * 设置 入库类型
	 * @param stockTypeDict 入库类型
	 * @return 当前对象
	*/
	public AssetStockGoodsIn setStockTypeDict(DictItem stockTypeDict) {
		this.stockTypeDict=stockTypeDict;
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
	public AssetStockGoodsIn setOwnerCompany(Organization ownerCompany) {
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
	public AssetStockGoodsIn setUseOrganization(Organization useOrganization) {
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
	public AssetStockGoodsIn setWarehouse(Warehouse warehouse) {
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
	public AssetStockGoodsIn setSource(DictItem source) {
		this.source=source;
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
	public AssetStockGoodsIn setOriginator(Employee originator) {
		this.originator=originator;
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
	public AssetStockGoodsIn setManager(Employee manager) {
		this.manager=manager;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetStockGoodsIn , 转换好的 AssetStockGoodsIn 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetStockGoodsIn , 转换好的 PoJo 对象
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
	public AssetStockGoodsIn clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetStockGoodsIn duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetStockGoodsInMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetStockGoodsInMeta.$$proxy$$();
		inst.setOwnerType(this.getOwnerType());
		inst.setSourceId(this.getSourceId());
		inst.setPurchaseDate(this.getPurchaseDate());
		inst.setChsVersion(this.getChsVersion());
		inst.setNotes(this.getNotes());
		inst.setProcId(this.getProcId());
		inst.setLatestApproverName(this.getLatestApproverName());
		inst.setChangeInstanceId(this.getChangeInstanceId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setNextApproverIds(this.getNextApproverIds());
		inst.setApprovalOpinion(this.getApprovalOpinion());
		inst.setChsStatus(this.getChsStatus());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setAttachId(this.getAttachId());
		inst.setSupplierName(this.getSupplierName());
		inst.setSummary(this.getSummary());
		inst.setNextApproverNames(this.getNextApproverNames());
		inst.setAmount(this.getAmount());
		inst.setLatestApproverId(this.getLatestApproverId());
		inst.setStockType(this.getStockType());
		inst.setBatchCode(this.getBatchCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setManagerId(this.getManagerId());
		inst.setVersion(this.getVersion());
		inst.setReceiverUserName(this.getReceiverUserName());
		inst.setOwnCompanyId(this.getOwnCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setWarehouseId(this.getWarehouseId());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setChsType(this.getChsType());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setOwnerCompany(this.getOwnerCompany());
			inst.setUseOrganization(this.getUseOrganization());
			inst.setManager(this.getManager());
			inst.setGoodsList(this.getGoodsList());
			inst.setSource(this.getSource());
			inst.setOriginator(this.getOriginator());
			inst.setWarehouse(this.getWarehouse());
			inst.setStockTypeDict(this.getStockTypeDict());
			inst.setGoodsIds(this.getGoodsIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetStockGoodsIn clone(boolean deep) {
		return EntityContext.clone(AssetStockGoodsIn.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetStockGoodsIn
	 * @param assetStockGoodsInMap 包含实体信息的 Map 对象
	 * @return AssetStockGoodsIn , 转换好的的 AssetStockGoodsIn 对象
	*/
	@Transient
	public static AssetStockGoodsIn createFrom(Map<String,Object> assetStockGoodsInMap) {
		if(assetStockGoodsInMap==null) return null;
		AssetStockGoodsIn po = create();
		EntityContext.copyProperties(po,assetStockGoodsInMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetStockGoodsIn
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetStockGoodsIn , 转换好的的 AssetStockGoodsIn 对象
	*/
	@Transient
	public static AssetStockGoodsIn createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetStockGoodsIn po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetStockGoodsIn，等同于 new
	 * @return AssetStockGoodsIn 对象
	*/
	@Transient
	public static AssetStockGoodsIn create() {
		return new com.dt.platform.domain.eam.meta.AssetStockGoodsInMeta.$$proxy$$();
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
			this.setOwnerType(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.OWNER_TYPE)));
			this.setSourceId(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.SOURCE_ID)));
			this.setPurchaseDate(DataParser.parse(Date.class, map.get(AssetStockGoodsInMeta.PURCHASE_DATE)));
			this.setChsVersion(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.CHS_VERSION)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.NOTES)));
			this.setProcId(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.CHANGE_INSTANCE_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.SELECTED_CODE)));
			this.setNextApproverIds(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.APPROVAL_OPINION)));
			this.setChsStatus(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.CHS_STATUS)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(AssetStockGoodsInMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.ORIGINATOR_ID)));
			this.setAttachId(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.ATTACH_ID)));
			this.setSupplierName(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.SUPPLIER_NAME)));
			this.setSummary(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.NEXT_APPROVER_NAMES)));
			this.setAmount(DataParser.parse(BigDecimal.class, map.get(AssetStockGoodsInMeta.AMOUNT)));
			this.setLatestApproverId(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.LATEST_APPROVER_ID)));
			this.setStockType(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.STOCK_TYPE)));
			this.setBatchCode(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.BATCH_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetStockGoodsInMeta.UPDATE_TIME)));
			this.setManagerId(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.MANAGER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetStockGoodsInMeta.VERSION)));
			this.setReceiverUserName(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.RECEIVER_USER_NAME)));
			this.setOwnCompanyId(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetStockGoodsInMeta.DELETED)));
			this.setWarehouseId(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.WAREHOUSE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetStockGoodsInMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetStockGoodsInMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetStockGoodsInMeta.STATUS)));
			// others
			this.setOwnerCompany(DataParser.parse(Organization.class, map.get(AssetStockGoodsInMeta.OWNER_COMPANY)));
			this.setUseOrganization(DataParser.parse(Organization.class, map.get(AssetStockGoodsInMeta.USE_ORGANIZATION)));
			this.setManager(DataParser.parse(Employee.class, map.get(AssetStockGoodsInMeta.MANAGER)));
			this.setSource(DataParser.parse(DictItem.class, map.get(AssetStockGoodsInMeta.SOURCE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetStockGoodsInMeta.ORIGINATOR)));
			this.setWarehouse(DataParser.parse(Warehouse.class, map.get(AssetStockGoodsInMeta.WAREHOUSE)));
			this.setStockTypeDict(DataParser.parse(DictItem.class, map.get(AssetStockGoodsInMeta.STOCK_TYPE_DICT)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)map.get(AssetStockGoodsInMeta.OWNER_TYPE));
				this.setSourceId( (String)map.get(AssetStockGoodsInMeta.SOURCE_ID));
				this.setPurchaseDate( (Date)map.get(AssetStockGoodsInMeta.PURCHASE_DATE));
				this.setChsVersion( (String)map.get(AssetStockGoodsInMeta.CHS_VERSION));
				this.setNotes( (String)map.get(AssetStockGoodsInMeta.NOTES));
				this.setProcId( (String)map.get(AssetStockGoodsInMeta.PROC_ID));
				this.setLatestApproverName( (String)map.get(AssetStockGoodsInMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)map.get(AssetStockGoodsInMeta.CHANGE_INSTANCE_ID));
				this.setSelectedCode( (String)map.get(AssetStockGoodsInMeta.SELECTED_CODE));
				this.setNextApproverIds( (String)map.get(AssetStockGoodsInMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)map.get(AssetStockGoodsInMeta.APPROVAL_OPINION));
				this.setChsStatus( (String)map.get(AssetStockGoodsInMeta.CHS_STATUS));
				this.setBusinessDate( (Date)map.get(AssetStockGoodsInMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(AssetStockGoodsInMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)map.get(AssetStockGoodsInMeta.UPDATE_BY));
				this.setId( (String)map.get(AssetStockGoodsInMeta.ID));
				this.setOriginatorId( (String)map.get(AssetStockGoodsInMeta.ORIGINATOR_ID));
				this.setAttachId( (String)map.get(AssetStockGoodsInMeta.ATTACH_ID));
				this.setSupplierName( (String)map.get(AssetStockGoodsInMeta.SUPPLIER_NAME));
				this.setSummary( (String)map.get(AssetStockGoodsInMeta.SUMMARY));
				this.setNextApproverNames( (String)map.get(AssetStockGoodsInMeta.NEXT_APPROVER_NAMES));
				this.setAmount( (BigDecimal)map.get(AssetStockGoodsInMeta.AMOUNT));
				this.setLatestApproverId( (String)map.get(AssetStockGoodsInMeta.LATEST_APPROVER_ID));
				this.setStockType( (String)map.get(AssetStockGoodsInMeta.STOCK_TYPE));
				this.setBatchCode( (String)map.get(AssetStockGoodsInMeta.BATCH_CODE));
				this.setUpdateTime( (Date)map.get(AssetStockGoodsInMeta.UPDATE_TIME));
				this.setManagerId( (String)map.get(AssetStockGoodsInMeta.MANAGER_ID));
				this.setVersion( (Integer)map.get(AssetStockGoodsInMeta.VERSION));
				this.setReceiverUserName( (String)map.get(AssetStockGoodsInMeta.RECEIVER_USER_NAME));
				this.setOwnCompanyId( (String)map.get(AssetStockGoodsInMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)map.get(AssetStockGoodsInMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetStockGoodsInMeta.DELETED));
				this.setWarehouseId( (String)map.get(AssetStockGoodsInMeta.WAREHOUSE_ID));
				this.setCreateTime( (Date)map.get(AssetStockGoodsInMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetStockGoodsInMeta.DELETE_TIME));
				this.setChsType( (String)map.get(AssetStockGoodsInMeta.CHS_TYPE));
				this.setName( (String)map.get(AssetStockGoodsInMeta.NAME));
				this.setTenantId( (String)map.get(AssetStockGoodsInMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetStockGoodsInMeta.DELETE_BY));
				this.setStatus( (String)map.get(AssetStockGoodsInMeta.STATUS));
				// others
				this.setOwnerCompany( (Organization)map.get(AssetStockGoodsInMeta.OWNER_COMPANY));
				this.setUseOrganization( (Organization)map.get(AssetStockGoodsInMeta.USE_ORGANIZATION));
				this.setManager( (Employee)map.get(AssetStockGoodsInMeta.MANAGER));
				this.setSource( (DictItem)map.get(AssetStockGoodsInMeta.SOURCE));
				this.setOriginator( (Employee)map.get(AssetStockGoodsInMeta.ORIGINATOR));
				this.setWarehouse( (Warehouse)map.get(AssetStockGoodsInMeta.WAREHOUSE));
				this.setStockTypeDict( (DictItem)map.get(AssetStockGoodsInMeta.STOCK_TYPE_DICT));
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
			this.setOwnerType(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.OWNER_TYPE)));
			this.setSourceId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.SOURCE_ID)));
			this.setPurchaseDate(DataParser.parse(Date.class, r.getValue(AssetStockGoodsInMeta.PURCHASE_DATE)));
			this.setChsVersion(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.CHS_VERSION)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.NOTES)));
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.CHANGE_INSTANCE_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.SELECTED_CODE)));
			this.setNextApproverIds(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.APPROVAL_OPINION)));
			this.setChsStatus(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.CHS_STATUS)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(AssetStockGoodsInMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.ORIGINATOR_ID)));
			this.setAttachId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.ATTACH_ID)));
			this.setSupplierName(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.SUPPLIER_NAME)));
			this.setSummary(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.NEXT_APPROVER_NAMES)));
			this.setAmount(DataParser.parse(BigDecimal.class, r.getValue(AssetStockGoodsInMeta.AMOUNT)));
			this.setLatestApproverId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.LATEST_APPROVER_ID)));
			this.setStockType(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.STOCK_TYPE)));
			this.setBatchCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.BATCH_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsInMeta.UPDATE_TIME)));
			this.setManagerId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.MANAGER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetStockGoodsInMeta.VERSION)));
			this.setReceiverUserName(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.RECEIVER_USER_NAME)));
			this.setOwnCompanyId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetStockGoodsInMeta.DELETED)));
			this.setWarehouseId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.WAREHOUSE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsInMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsInMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetStockGoodsInMeta.STATUS)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)r.getValue(AssetStockGoodsInMeta.OWNER_TYPE));
				this.setSourceId( (String)r.getValue(AssetStockGoodsInMeta.SOURCE_ID));
				this.setPurchaseDate( (Date)r.getValue(AssetStockGoodsInMeta.PURCHASE_DATE));
				this.setChsVersion( (String)r.getValue(AssetStockGoodsInMeta.CHS_VERSION));
				this.setNotes( (String)r.getValue(AssetStockGoodsInMeta.NOTES));
				this.setProcId( (String)r.getValue(AssetStockGoodsInMeta.PROC_ID));
				this.setLatestApproverName( (String)r.getValue(AssetStockGoodsInMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)r.getValue(AssetStockGoodsInMeta.CHANGE_INSTANCE_ID));
				this.setSelectedCode( (String)r.getValue(AssetStockGoodsInMeta.SELECTED_CODE));
				this.setNextApproverIds( (String)r.getValue(AssetStockGoodsInMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)r.getValue(AssetStockGoodsInMeta.APPROVAL_OPINION));
				this.setChsStatus( (String)r.getValue(AssetStockGoodsInMeta.CHS_STATUS));
				this.setBusinessDate( (Date)r.getValue(AssetStockGoodsInMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(AssetStockGoodsInMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)r.getValue(AssetStockGoodsInMeta.UPDATE_BY));
				this.setId( (String)r.getValue(AssetStockGoodsInMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetStockGoodsInMeta.ORIGINATOR_ID));
				this.setAttachId( (String)r.getValue(AssetStockGoodsInMeta.ATTACH_ID));
				this.setSupplierName( (String)r.getValue(AssetStockGoodsInMeta.SUPPLIER_NAME));
				this.setSummary( (String)r.getValue(AssetStockGoodsInMeta.SUMMARY));
				this.setNextApproverNames( (String)r.getValue(AssetStockGoodsInMeta.NEXT_APPROVER_NAMES));
				this.setAmount( (BigDecimal)r.getValue(AssetStockGoodsInMeta.AMOUNT));
				this.setLatestApproverId( (String)r.getValue(AssetStockGoodsInMeta.LATEST_APPROVER_ID));
				this.setStockType( (String)r.getValue(AssetStockGoodsInMeta.STOCK_TYPE));
				this.setBatchCode( (String)r.getValue(AssetStockGoodsInMeta.BATCH_CODE));
				this.setUpdateTime( (Date)r.getValue(AssetStockGoodsInMeta.UPDATE_TIME));
				this.setManagerId( (String)r.getValue(AssetStockGoodsInMeta.MANAGER_ID));
				this.setVersion( (Integer)r.getValue(AssetStockGoodsInMeta.VERSION));
				this.setReceiverUserName( (String)r.getValue(AssetStockGoodsInMeta.RECEIVER_USER_NAME));
				this.setOwnCompanyId( (String)r.getValue(AssetStockGoodsInMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)r.getValue(AssetStockGoodsInMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetStockGoodsInMeta.DELETED));
				this.setWarehouseId( (String)r.getValue(AssetStockGoodsInMeta.WAREHOUSE_ID));
				this.setCreateTime( (Date)r.getValue(AssetStockGoodsInMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetStockGoodsInMeta.DELETE_TIME));
				this.setChsType( (String)r.getValue(AssetStockGoodsInMeta.CHS_TYPE));
				this.setName( (String)r.getValue(AssetStockGoodsInMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetStockGoodsInMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetStockGoodsInMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(AssetStockGoodsInMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}