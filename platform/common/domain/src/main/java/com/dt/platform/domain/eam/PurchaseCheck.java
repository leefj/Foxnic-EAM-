package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_PURCHASE_CHECK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.PurchaseCheckMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 采购验收
 * <p>采购验收 , 数据表 eam_purchase_check 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-23 15:48:37
 * @sign 04A139769904BEE9762F84F31BF5AD71
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_purchase_check")
@ApiModel(description = "采购验收 ; 采购验收 , 数据表 eam_purchase_check 的PO类型")
public class PurchaseCheck extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_PURCHASE_CHECK.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "835157011669712896")
	private String id;
	
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
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号" , example = "AC202415231415818")
	private String businessCode;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 采购申请：采购申请
	*/
	@ApiModelProperty(required = false,value="采购申请" , notes = "采购申请" , example = "835153891807985664")
	private String applyId;
	
	/**
	 * 供应商：供应商
	*/
	@ApiModelProperty(required = false,value="供应商" , notes = "供应商")
	private String supplierId;
	
	/**
	 * 验收人：验收人
	*/
	@ApiModelProperty(required = false,value="验收人" , notes = "验收人")
	private String checkUserId;
	
	/**
	 * 验收人：验收人
	*/
	@ApiModelProperty(required = false,value="验收人" , notes = "验收人" , example = "12")
	private String checkUserName;
	
	/**
	 * 验收时间：验收时间
	*/
	@ApiModelProperty(required = false,value="验收时间" , notes = "验收时间" , example = "2024-04-01")
	private String checkDate;
	
	/**
	 * 验收信息：验收信息
	*/
	@ApiModelProperty(required = false,value="验收信息" , notes = "验收信息" , example = "12")
	private String checkInformation;
	
	/**
	 * 到货日期：到货日期
	*/
	@ApiModelProperty(required = false,value="到货日期" , notes = "到货日期" , example = "2024-04-09")
	private String receiveDate;
	
	/**
	 * 仓库库位：仓库库位
	*/
	@ApiModelProperty(required = false,value="仓库库位" , notes = "仓库库位" , example = "832938111762694145")
	private String positionId;
	
	/**
	 * 是否入库：是否入库
	*/
	@ApiModelProperty(required = false,value="是否入库" , notes = "是否入库" , example = "no")
	private String insertPosition;
	
	/**
	 * 入库状态：入库状态
	*/
	@ApiModelProperty(required = false,value="入库状态" , notes = "入库状态")
	private String stockStatus;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attach;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-04-23 02:15:48")
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
	@ApiModelProperty(required = false,value="选择数据" , notes = "选择数据")
	private String selectedCode;
	
	/**
	 * 供应商：供应商
	*/
	@ApiModelProperty(required = false,value="供应商" , notes = "供应商")
	private Supplier supplier;
	
	/**
	 * 验收公司/部门：验收公司/部门
	*/
	@ApiModelProperty(required = false,value="验收公司/部门" , notes = "验收公司/部门")
	private Organization checkOrg;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * checkUser：checkUser
	*/
	@ApiModelProperty(required = false,value="checkUser" , notes = "checkUser")
	private Employee checkUser;
	
	/**
	 * 清单：清单
	*/
	@ApiModelProperty(required = false,value="清单" , notes = "清单")
	private List<PurchaseOrder> orderList;
	
	/**
	 * 清单列表：清单列表
	*/
	@ApiModelProperty(required = false,value="清单列表" , notes = "清单列表")
	private List<String> orderIds;
	
	/**
	 * 领用申请：领用申请
	*/
	@ApiModelProperty(required = false,value="领用申请" , notes = "领用申请")
	private PurchaseApply purchaseApply;
	
	/**
	 * applyCode：applyCode
	*/
	@ApiModelProperty(required = false,value="applyCode" , notes = "applyCode")
	private String applyCode;
	
	/**
	 * applyName：applyName
	*/
	@ApiModelProperty(required = false,value="applyName" , notes = "applyName")
	private String applyName;
	
	/**
	 * warehousePosition：warehousePosition
	*/
	@ApiModelProperty(required = false,value="warehousePosition" , notes = "warehousePosition")
	private WarehousePosition warehousePosition;
	
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
	public PurchaseCheck setId(String id) {
		this.id=id;
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
	public PurchaseCheck setProcId(String procId) {
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
	public PurchaseCheck setStatus(String status) {
		this.status=status;
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
	public PurchaseCheck setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
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
	public PurchaseCheck setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 采购申请<br>
	 * 采购申请
	 * @return 采购申请
	*/
	public String getApplyId() {
		return applyId;
	}
	
	/**
	 * 设置 采购申请
	 * @param applyId 采购申请
	 * @return 当前对象
	*/
	public PurchaseCheck setApplyId(String applyId) {
		this.applyId=applyId;
		return this;
	}
	
	/**
	 * 获得 供应商<br>
	 * 供应商
	 * @return 供应商
	*/
	public String getSupplierId() {
		return supplierId;
	}
	
	/**
	 * 设置 供应商
	 * @param supplierId 供应商
	 * @return 当前对象
	*/
	public PurchaseCheck setSupplierId(String supplierId) {
		this.supplierId=supplierId;
		return this;
	}
	
	/**
	 * 获得 验收人<br>
	 * 验收人
	 * @return 验收人
	*/
	public String getCheckUserId() {
		return checkUserId;
	}
	
	/**
	 * 设置 验收人
	 * @param checkUserId 验收人
	 * @return 当前对象
	*/
	public PurchaseCheck setCheckUserId(String checkUserId) {
		this.checkUserId=checkUserId;
		return this;
	}
	
	/**
	 * 获得 验收人<br>
	 * 验收人
	 * @return 验收人
	*/
	public String getCheckUserName() {
		return checkUserName;
	}
	
	/**
	 * 设置 验收人
	 * @param checkUserName 验收人
	 * @return 当前对象
	*/
	public PurchaseCheck setCheckUserName(String checkUserName) {
		this.checkUserName=checkUserName;
		return this;
	}
	
	/**
	 * 获得 验收时间<br>
	 * 验收时间
	 * @return 验收时间
	*/
	public String getCheckDate() {
		return checkDate;
	}
	
	/**
	 * 设置 验收时间
	 * @param checkDate 验收时间
	 * @return 当前对象
	*/
	public PurchaseCheck setCheckDate(String checkDate) {
		this.checkDate=checkDate;
		return this;
	}
	
	/**
	 * 获得 验收信息<br>
	 * 验收信息
	 * @return 验收信息
	*/
	public String getCheckInformation() {
		return checkInformation;
	}
	
	/**
	 * 设置 验收信息
	 * @param checkInformation 验收信息
	 * @return 当前对象
	*/
	public PurchaseCheck setCheckInformation(String checkInformation) {
		this.checkInformation=checkInformation;
		return this;
	}
	
	/**
	 * 获得 到货日期<br>
	 * 到货日期
	 * @return 到货日期
	*/
	public String getReceiveDate() {
		return receiveDate;
	}
	
	/**
	 * 设置 到货日期
	 * @param receiveDate 到货日期
	 * @return 当前对象
	*/
	public PurchaseCheck setReceiveDate(String receiveDate) {
		this.receiveDate=receiveDate;
		return this;
	}
	
	/**
	 * 获得 仓库库位<br>
	 * 仓库库位
	 * @return 仓库库位
	*/
	public String getPositionId() {
		return positionId;
	}
	
	/**
	 * 设置 仓库库位
	 * @param positionId 仓库库位
	 * @return 当前对象
	*/
	public PurchaseCheck setPositionId(String positionId) {
		this.positionId=positionId;
		return this;
	}
	
	/**
	 * 获得 是否入库<br>
	 * 是否入库
	 * @return 是否入库
	*/
	public String getInsertPosition() {
		return insertPosition;
	}
	
	/**
	 * 设置 是否入库
	 * @param insertPosition 是否入库
	 * @return 当前对象
	*/
	public PurchaseCheck setInsertPosition(String insertPosition) {
		this.insertPosition=insertPosition;
		return this;
	}
	
	/**
	 * 获得 入库状态<br>
	 * 入库状态
	 * @return 入库状态
	*/
	public String getStockStatus() {
		return stockStatus;
	}
	
	/**
	 * 设置 入库状态
	 * @param stockStatus 入库状态
	 * @return 当前对象
	*/
	public PurchaseCheck setStockStatus(String stockStatus) {
		this.stockStatus=stockStatus;
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
	public PurchaseCheck setAttach(String attach) {
		this.attach=attach;
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
	public PurchaseCheck setNotes(String notes) {
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
	public PurchaseCheck setOriginatorId(String originatorId) {
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
	public PurchaseCheck setCreateBy(String createBy) {
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
	public PurchaseCheck setCreateTime(Date createTime) {
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
	public PurchaseCheck setUpdateBy(String updateBy) {
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
	public PurchaseCheck setUpdateTime(Date updateTime) {
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
	public PurchaseCheck setDeleted(Integer deleted) {
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
	public PurchaseCheck setDeleted(Boolean deletedBool) {
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
	public PurchaseCheck setDeleteBy(String deleteBy) {
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
	public PurchaseCheck setDeleteTime(Date deleteTime) {
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
	public PurchaseCheck setVersion(Integer version) {
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
	public PurchaseCheck setTenantId(String tenantId) {
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
	public PurchaseCheck setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 供应商<br>
	 * 供应商
	 * @return 供应商
	*/
	public Supplier getSupplier() {
		return supplier;
	}
	
	/**
	 * 设置 供应商
	 * @param supplier 供应商
	 * @return 当前对象
	*/
	public PurchaseCheck setSupplier(Supplier supplier) {
		this.supplier=supplier;
		return this;
	}
	
	/**
	 * 获得 验收公司/部门<br>
	 * 验收公司/部门
	 * @return 验收公司/部门
	*/
	public Organization getCheckOrg() {
		return checkOrg;
	}
	
	/**
	 * 设置 验收公司/部门
	 * @param checkOrg 验收公司/部门
	 * @return 当前对象
	*/
	public PurchaseCheck setCheckOrg(Organization checkOrg) {
		this.checkOrg=checkOrg;
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
	public PurchaseCheck setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 checkUser<br>
	 * checkUser
	 * @return checkUser
	*/
	public Employee getCheckUser() {
		return checkUser;
	}
	
	/**
	 * 设置 checkUser
	 * @param checkUser checkUser
	 * @return 当前对象
	*/
	public PurchaseCheck setCheckUser(Employee checkUser) {
		this.checkUser=checkUser;
		return this;
	}
	
	/**
	 * 获得 清单<br>
	 * 清单
	 * @return 清单
	*/
	public List<PurchaseOrder> getOrderList() {
		return orderList;
	}
	
	/**
	 * 设置 清单
	 * @param orderList 清单
	 * @return 当前对象
	*/
	public PurchaseCheck setOrderList(List<PurchaseOrder> orderList) {
		this.orderList=orderList;
		return this;
	}
	
	/**
	 * 添加 清单
	 * @param order 清单
	 * @return 当前对象
	*/
	public PurchaseCheck addOrder(PurchaseOrder... order) {
		if(this.orderList==null) orderList=new ArrayList<>();
		this.orderList.addAll(Arrays.asList(order));
		return this;
	}
	
	/**
	 * 获得 清单列表<br>
	 * 清单列表
	 * @return 清单列表
	*/
	public List<String> getOrderIds() {
		return orderIds;
	}
	
	/**
	 * 设置 清单列表
	 * @param orderIds 清单列表
	 * @return 当前对象
	*/
	public PurchaseCheck setOrderIds(List<String> orderIds) {
		this.orderIds=orderIds;
		return this;
	}
	
	/**
	 * 添加 清单列表
	 * @param orderId 清单列表
	 * @return 当前对象
	*/
	public PurchaseCheck addOrderId(String... orderId) {
		if(this.orderIds==null) orderIds=new ArrayList<>();
		this.orderIds.addAll(Arrays.asList(orderId));
		return this;
	}
	
	/**
	 * 获得 领用申请<br>
	 * 领用申请
	 * @return 领用申请
	*/
	public PurchaseApply getPurchaseApply() {
		return purchaseApply;
	}
	
	/**
	 * 设置 领用申请
	 * @param purchaseApply 领用申请
	 * @return 当前对象
	*/
	public PurchaseCheck setPurchaseApply(PurchaseApply purchaseApply) {
		this.purchaseApply=purchaseApply;
		return this;
	}
	
	/**
	 * 获得 applyCode<br>
	 * applyCode
	 * @return applyCode
	*/
	public String getApplyCode() {
		return applyCode;
	}
	
	/**
	 * 设置 applyCode
	 * @param applyCode applyCode
	 * @return 当前对象
	*/
	public PurchaseCheck setApplyCode(String applyCode) {
		this.applyCode=applyCode;
		return this;
	}
	
	/**
	 * 获得 applyName<br>
	 * applyName
	 * @return applyName
	*/
	public String getApplyName() {
		return applyName;
	}
	
	/**
	 * 设置 applyName
	 * @param applyName applyName
	 * @return 当前对象
	*/
	public PurchaseCheck setApplyName(String applyName) {
		this.applyName=applyName;
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
	public PurchaseCheck setWarehousePosition(WarehousePosition warehousePosition) {
		this.warehousePosition=warehousePosition;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PurchaseCheck , 转换好的 PurchaseCheck 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PurchaseCheck , 转换好的 PoJo 对象
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
	public PurchaseCheck clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PurchaseCheck duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.PurchaseCheckMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.PurchaseCheckMeta.$$proxy$$();
		inst.setSupplierId(this.getSupplierId());
		inst.setNotes(this.getNotes());
		inst.setProcId(this.getProcId());
		inst.setCheckUserId(this.getCheckUserId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setApplyId(this.getApplyId());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setCheckUserName(this.getCheckUserName());
		inst.setStockStatus(this.getStockStatus());
		inst.setId(this.getId());
		inst.setAttach(this.getAttach());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setReceiveDate(this.getReceiveDate());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setCheckDate(this.getCheckDate());
		inst.setInsertPosition(this.getInsertPosition());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPositionId(this.getPositionId());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setCheckInformation(this.getCheckInformation());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setCheckUser(this.getCheckUser());
			inst.setPurchaseApply(this.getPurchaseApply());
			inst.setCheckOrg(this.getCheckOrg());
			inst.setSupplier(this.getSupplier());
			inst.setOrderList(this.getOrderList());
			inst.setOriginator(this.getOriginator());
			inst.setOrderIds(this.getOrderIds());
			inst.setApplyCode(this.getApplyCode());
			inst.setApplyName(this.getApplyName());
			inst.setWarehousePosition(this.getWarehousePosition());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PurchaseCheck clone(boolean deep) {
		return EntityContext.clone(PurchaseCheck.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PurchaseCheck
	 * @param purchaseCheckMap 包含实体信息的 Map 对象
	 * @return PurchaseCheck , 转换好的的 PurchaseCheck 对象
	*/
	@Transient
	public static PurchaseCheck createFrom(Map<String,Object> purchaseCheckMap) {
		if(purchaseCheckMap==null) return null;
		PurchaseCheck po = create();
		EntityContext.copyProperties(po,purchaseCheckMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PurchaseCheck
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PurchaseCheck , 转换好的的 PurchaseCheck 对象
	*/
	@Transient
	public static PurchaseCheck createFrom(Object pojo) {
		if(pojo==null) return null;
		PurchaseCheck po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PurchaseCheck，等同于 new
	 * @return PurchaseCheck 对象
	*/
	@Transient
	public static PurchaseCheck create() {
		return new com.dt.platform.domain.eam.meta.PurchaseCheckMeta.$$proxy$$();
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
			this.setSupplierId(DataParser.parse(String.class, map.get(PurchaseCheckMeta.SUPPLIER_ID)));
			this.setNotes(DataParser.parse(String.class, map.get(PurchaseCheckMeta.NOTES)));
			this.setProcId(DataParser.parse(String.class, map.get(PurchaseCheckMeta.PROC_ID)));
			this.setCheckUserId(DataParser.parse(String.class, map.get(PurchaseCheckMeta.CHECK_USER_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(PurchaseCheckMeta.SELECTED_CODE)));
			this.setApplyId(DataParser.parse(String.class, map.get(PurchaseCheckMeta.APPLY_ID)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(PurchaseCheckMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PurchaseCheckMeta.UPDATE_BY)));
			this.setCheckUserName(DataParser.parse(String.class, map.get(PurchaseCheckMeta.CHECK_USER_NAME)));
			this.setStockStatus(DataParser.parse(String.class, map.get(PurchaseCheckMeta.STOCK_STATUS)));
			this.setId(DataParser.parse(String.class, map.get(PurchaseCheckMeta.ID)));
			this.setAttach(DataParser.parse(String.class, map.get(PurchaseCheckMeta.ATTACH)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(PurchaseCheckMeta.ORIGINATOR_ID)));
			this.setReceiveDate(DataParser.parse(String.class, map.get(PurchaseCheckMeta.RECEIVE_DATE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PurchaseCheckMeta.UPDATE_TIME)));
			this.setCheckDate(DataParser.parse(String.class, map.get(PurchaseCheckMeta.CHECK_DATE)));
			this.setInsertPosition(DataParser.parse(String.class, map.get(PurchaseCheckMeta.INSERT_POSITION)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PurchaseCheckMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PurchaseCheckMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PurchaseCheckMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, map.get(PurchaseCheckMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PurchaseCheckMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PurchaseCheckMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(PurchaseCheckMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PurchaseCheckMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PurchaseCheckMeta.DELETE_BY)));
			this.setCheckInformation(DataParser.parse(String.class, map.get(PurchaseCheckMeta.CHECK_INFORMATION)));
			this.setStatus(DataParser.parse(String.class, map.get(PurchaseCheckMeta.STATUS)));
			// others
			this.setCheckUser(DataParser.parse(Employee.class, map.get(PurchaseCheckMeta.CHECK_USER)));
			this.setPurchaseApply(DataParser.parse(PurchaseApply.class, map.get(PurchaseCheckMeta.PURCHASE_APPLY)));
			this.setCheckOrg(DataParser.parse(Organization.class, map.get(PurchaseCheckMeta.CHECK_ORG)));
			this.setSupplier(DataParser.parse(Supplier.class, map.get(PurchaseCheckMeta.SUPPLIER)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(PurchaseCheckMeta.ORIGINATOR)));
			this.setApplyCode(DataParser.parse(String.class, map.get(PurchaseCheckMeta.APPLY_CODE)));
			this.setApplyName(DataParser.parse(String.class, map.get(PurchaseCheckMeta.APPLY_NAME)));
			this.setWarehousePosition(DataParser.parse(WarehousePosition.class, map.get(PurchaseCheckMeta.WAREHOUSE_POSITION)));
			return true;
		} else {
			try {
				this.setSupplierId( (String)map.get(PurchaseCheckMeta.SUPPLIER_ID));
				this.setNotes( (String)map.get(PurchaseCheckMeta.NOTES));
				this.setProcId( (String)map.get(PurchaseCheckMeta.PROC_ID));
				this.setCheckUserId( (String)map.get(PurchaseCheckMeta.CHECK_USER_ID));
				this.setSelectedCode( (String)map.get(PurchaseCheckMeta.SELECTED_CODE));
				this.setApplyId( (String)map.get(PurchaseCheckMeta.APPLY_ID));
				this.setBusinessCode( (String)map.get(PurchaseCheckMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)map.get(PurchaseCheckMeta.UPDATE_BY));
				this.setCheckUserName( (String)map.get(PurchaseCheckMeta.CHECK_USER_NAME));
				this.setStockStatus( (String)map.get(PurchaseCheckMeta.STOCK_STATUS));
				this.setId( (String)map.get(PurchaseCheckMeta.ID));
				this.setAttach( (String)map.get(PurchaseCheckMeta.ATTACH));
				this.setOriginatorId( (String)map.get(PurchaseCheckMeta.ORIGINATOR_ID));
				this.setReceiveDate( (String)map.get(PurchaseCheckMeta.RECEIVE_DATE));
				this.setUpdateTime( (Date)map.get(PurchaseCheckMeta.UPDATE_TIME));
				this.setCheckDate( (String)map.get(PurchaseCheckMeta.CHECK_DATE));
				this.setInsertPosition( (String)map.get(PurchaseCheckMeta.INSERT_POSITION));
				this.setVersion( (Integer)map.get(PurchaseCheckMeta.VERSION));
				this.setCreateBy( (String)map.get(PurchaseCheckMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PurchaseCheckMeta.DELETED));
				this.setPositionId( (String)map.get(PurchaseCheckMeta.POSITION_ID));
				this.setCreateTime( (Date)map.get(PurchaseCheckMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(PurchaseCheckMeta.DELETE_TIME));
				this.setName( (String)map.get(PurchaseCheckMeta.NAME));
				this.setTenantId( (String)map.get(PurchaseCheckMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PurchaseCheckMeta.DELETE_BY));
				this.setCheckInformation( (String)map.get(PurchaseCheckMeta.CHECK_INFORMATION));
				this.setStatus( (String)map.get(PurchaseCheckMeta.STATUS));
				// others
				this.setCheckUser( (Employee)map.get(PurchaseCheckMeta.CHECK_USER));
				this.setPurchaseApply( (PurchaseApply)map.get(PurchaseCheckMeta.PURCHASE_APPLY));
				this.setCheckOrg( (Organization)map.get(PurchaseCheckMeta.CHECK_ORG));
				this.setSupplier( (Supplier)map.get(PurchaseCheckMeta.SUPPLIER));
				this.setOriginator( (Employee)map.get(PurchaseCheckMeta.ORIGINATOR));
				this.setApplyCode( (String)map.get(PurchaseCheckMeta.APPLY_CODE));
				this.setApplyName( (String)map.get(PurchaseCheckMeta.APPLY_NAME));
				this.setWarehousePosition( (WarehousePosition)map.get(PurchaseCheckMeta.WAREHOUSE_POSITION));
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
			this.setSupplierId(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.SUPPLIER_ID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.NOTES)));
			this.setProcId(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.PROC_ID)));
			this.setCheckUserId(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.CHECK_USER_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.SELECTED_CODE)));
			this.setApplyId(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.APPLY_ID)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.UPDATE_BY)));
			this.setCheckUserName(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.CHECK_USER_NAME)));
			this.setStockStatus(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.STOCK_STATUS)));
			this.setId(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.ATTACH)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.ORIGINATOR_ID)));
			this.setReceiveDate(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.RECEIVE_DATE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PurchaseCheckMeta.UPDATE_TIME)));
			this.setCheckDate(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.CHECK_DATE)));
			this.setInsertPosition(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.INSERT_POSITION)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PurchaseCheckMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PurchaseCheckMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PurchaseCheckMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PurchaseCheckMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.DELETE_BY)));
			this.setCheckInformation(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.CHECK_INFORMATION)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PurchaseCheckMeta.STATUS)));
			return true;
		} else {
			try {
				this.setSupplierId( (String)r.getValue(PurchaseCheckMeta.SUPPLIER_ID));
				this.setNotes( (String)r.getValue(PurchaseCheckMeta.NOTES));
				this.setProcId( (String)r.getValue(PurchaseCheckMeta.PROC_ID));
				this.setCheckUserId( (String)r.getValue(PurchaseCheckMeta.CHECK_USER_ID));
				this.setSelectedCode( (String)r.getValue(PurchaseCheckMeta.SELECTED_CODE));
				this.setApplyId( (String)r.getValue(PurchaseCheckMeta.APPLY_ID));
				this.setBusinessCode( (String)r.getValue(PurchaseCheckMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)r.getValue(PurchaseCheckMeta.UPDATE_BY));
				this.setCheckUserName( (String)r.getValue(PurchaseCheckMeta.CHECK_USER_NAME));
				this.setStockStatus( (String)r.getValue(PurchaseCheckMeta.STOCK_STATUS));
				this.setId( (String)r.getValue(PurchaseCheckMeta.ID));
				this.setAttach( (String)r.getValue(PurchaseCheckMeta.ATTACH));
				this.setOriginatorId( (String)r.getValue(PurchaseCheckMeta.ORIGINATOR_ID));
				this.setReceiveDate( (String)r.getValue(PurchaseCheckMeta.RECEIVE_DATE));
				this.setUpdateTime( (Date)r.getValue(PurchaseCheckMeta.UPDATE_TIME));
				this.setCheckDate( (String)r.getValue(PurchaseCheckMeta.CHECK_DATE));
				this.setInsertPosition( (String)r.getValue(PurchaseCheckMeta.INSERT_POSITION));
				this.setVersion( (Integer)r.getValue(PurchaseCheckMeta.VERSION));
				this.setCreateBy( (String)r.getValue(PurchaseCheckMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PurchaseCheckMeta.DELETED));
				this.setPositionId( (String)r.getValue(PurchaseCheckMeta.POSITION_ID));
				this.setCreateTime( (Date)r.getValue(PurchaseCheckMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(PurchaseCheckMeta.DELETE_TIME));
				this.setName( (String)r.getValue(PurchaseCheckMeta.NAME));
				this.setTenantId( (String)r.getValue(PurchaseCheckMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PurchaseCheckMeta.DELETE_BY));
				this.setCheckInformation( (String)r.getValue(PurchaseCheckMeta.CHECK_INFORMATION));
				this.setStatus( (String)r.getValue(PurchaseCheckMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}