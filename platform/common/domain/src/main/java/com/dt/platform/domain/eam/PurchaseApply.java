package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_PURCHASE_APPLY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import java.util.List;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.PurchaseApplyMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 采购申请
 * <p>采购申请 , 数据表 eam_purchase_apply 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-07 21:23:31
 * @sign EB3E719E1569B7A0BA7D5B27D6DE69E6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_purchase_apply")
@ApiModel(description = "采购申请 ; 采购申请 , 数据表 eam_purchase_apply 的PO类型")
public class PurchaseApply extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_PURCHASE_APPLY.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "740974426849280000")
	private String id;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号" , example = "APA202347071647263")
	private String businessCode;
	
	/**
	 * 流程：流程
	*/
	@ApiModelProperty(required = false,value="流程" , notes = "流程")
	private String procId;
	
	/**
	 * 业务名称：业务名称
	*/
	@ApiModelProperty(required = false,value="业务名称" , notes = "业务名称" , example = "1212")
	private String name;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态" , example = "complete")
	private String status;
	
	/**
	 * 申请状态：申请状态
	*/
	@ApiModelProperty(required = false,value="申请状态" , notes = "申请状态")
	private String applyStatus;
	
	/**
	 * 申请部门：申请部门
	*/
	@ApiModelProperty(required = false,value="申请部门" , notes = "申请部门" , example = "2")
	private String applyOrgId;
	
	/**
	 * 采购人：采购人
	*/
	@ApiModelProperty(required = false,value="采购人" , notes = "采购人")
	private String purchaseUserId;
	
	/**
	 * 供应商：供应商
	*/
	@ApiModelProperty(required = false,value="供应商" , notes = "供应商")
	private String supplierId;
	
	/**
	 * 采购说明：采购说明
	*/
	@ApiModelProperty(required = false,value="采购说明" , notes = "采购说明" , example = "121212")
	private String applyContent;
	
	/**
	 * 采购日期：采购日期
	*/
	@ApiModelProperty(required = false,value="采购日期" , notes = "采购日期" , example = "2023-08-07")
	private String applyDate;
	
	/**
	 * 到货时间：到货时间
	*/
	@ApiModelProperty(required = false,value="到货时间" , notes = "到货时间")
	private Date expectedArrivalDate;
	
	/**
	 * 验收单：验收单
	*/
	@ApiModelProperty(required = false,value="验收单" , notes = "验收单")
	private String checkId;
	
	/**
	 * 验收情况：验收情况
	*/
	@ApiModelProperty(required = false,value="验收情况" , notes = "验收情况" , example = "not_check")
	private String assetCheck;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attach;
	
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
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-08-07 04:47:50")
	private Date createTime;
	
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
	 * 供应商：供应商
	*/
	@ApiModelProperty(required = false,value="供应商" , notes = "供应商")
	private Supplier supplier;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 申请部门：申请部门
	*/
	@ApiModelProperty(required = false,value="申请部门" , notes = "申请部门")
	private Organization applyOrg;
	
	/**
	 * 变更实例：变更实例
	*/
	@ApiModelProperty(required = false,value="变更实例" , notes = "变更实例")
	private ChangeInstance changeInstance;
	
	/**
	 * 采购清单：采购清单
	*/
	@ApiModelProperty(required = false,value="采购清单" , notes = "采购清单")
	private List<PurchaseOrder> orderList;
	
	/**
	 * 清单列表：清单列表
	*/
	@ApiModelProperty(required = false,value="清单列表" , notes = "清单列表")
	private List<String> orderIds;
	
	/**
	 * selectedCode：selectedCode
	*/
	@ApiModelProperty(required = false,value="selectedCode" , notes = "selectedCode")
	private String selectedCode;
	
	/**
	 * purchaseUser：purchaseUser
	*/
	@ApiModelProperty(required = false,value="purchaseUser" , notes = "purchaseUser")
	private Employee purchaseUser;
	
	/**
	 * 历史流程清单：历史流程清单
	*/
	@ApiModelProperty(required = false,value="历史流程清单" , notes = "历史流程清单")
	private List<ProcessInstance> historicProcessList;
	
	/**
	 * 在批的流程清单：在批的流程清单
	*/
	@ApiModelProperty(required = false,value="在批的流程清单" , notes = "在批的流程清单")
	private List<ProcessInstance> currentProcessList;
	
	/**
	 * 默认流程：优先取在批的流程
	*/
	@ApiModelProperty(required = false,value="默认流程" , notes = "优先取在批的流程")
	private ProcessInstance defaultProcess;
	
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
	public PurchaseApply setId(String id) {
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
	public PurchaseApply setBusinessCode(String businessCode) {
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
	public PurchaseApply setProcId(String procId) {
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
	public PurchaseApply setName(String name) {
		this.name=name;
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
	public PurchaseApply setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 申请状态<br>
	 * 申请状态
	 * @return 申请状态
	*/
	public String getApplyStatus() {
		return applyStatus;
	}
	
	/**
	 * 设置 申请状态
	 * @param applyStatus 申请状态
	 * @return 当前对象
	*/
	public PurchaseApply setApplyStatus(String applyStatus) {
		this.applyStatus=applyStatus;
		return this;
	}
	
	/**
	 * 获得 申请部门<br>
	 * 申请部门
	 * @return 申请部门
	*/
	public String getApplyOrgId() {
		return applyOrgId;
	}
	
	/**
	 * 设置 申请部门
	 * @param applyOrgId 申请部门
	 * @return 当前对象
	*/
	public PurchaseApply setApplyOrgId(String applyOrgId) {
		this.applyOrgId=applyOrgId;
		return this;
	}
	
	/**
	 * 获得 采购人<br>
	 * 采购人
	 * @return 采购人
	*/
	public String getPurchaseUserId() {
		return purchaseUserId;
	}
	
	/**
	 * 设置 采购人
	 * @param purchaseUserId 采购人
	 * @return 当前对象
	*/
	public PurchaseApply setPurchaseUserId(String purchaseUserId) {
		this.purchaseUserId=purchaseUserId;
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
	public PurchaseApply setSupplierId(String supplierId) {
		this.supplierId=supplierId;
		return this;
	}
	
	/**
	 * 获得 采购说明<br>
	 * 采购说明
	 * @return 采购说明
	*/
	public String getApplyContent() {
		return applyContent;
	}
	
	/**
	 * 设置 采购说明
	 * @param applyContent 采购说明
	 * @return 当前对象
	*/
	public PurchaseApply setApplyContent(String applyContent) {
		this.applyContent=applyContent;
		return this;
	}
	
	/**
	 * 获得 采购日期<br>
	 * 采购日期
	 * @return 采购日期
	*/
	public String getApplyDate() {
		return applyDate;
	}
	
	/**
	 * 设置 采购日期
	 * @param applyDate 采购日期
	 * @return 当前对象
	*/
	public PurchaseApply setApplyDate(String applyDate) {
		this.applyDate=applyDate;
		return this;
	}
	
	/**
	 * 获得 到货时间<br>
	 * 到货时间
	 * @return 到货时间
	*/
	public Date getExpectedArrivalDate() {
		return expectedArrivalDate;
	}
	
	/**
	 * 设置 到货时间
	 * @param expectedArrivalDate 到货时间
	 * @return 当前对象
	*/
	public PurchaseApply setExpectedArrivalDate(Date expectedArrivalDate) {
		this.expectedArrivalDate=expectedArrivalDate;
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
	public PurchaseApply setCheckId(String checkId) {
		this.checkId=checkId;
		return this;
	}
	
	/**
	 * 获得 验收情况<br>
	 * 验收情况
	 * @return 验收情况
	*/
	public String getAssetCheck() {
		return assetCheck;
	}
	
	/**
	 * 设置 验收情况
	 * @param assetCheck 验收情况
	 * @return 当前对象
	*/
	public PurchaseApply setAssetCheck(String assetCheck) {
		this.assetCheck=assetCheck;
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
	public PurchaseApply setNotes(String notes) {
		this.notes=notes;
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
	public PurchaseApply setAttach(String attach) {
		this.attach=attach;
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
	public PurchaseApply setOriginatorId(String originatorId) {
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
	public PurchaseApply setCreateBy(String createBy) {
		this.createBy=createBy;
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
	public PurchaseApply setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
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
	public PurchaseApply setCreateTime(Date createTime) {
		this.createTime=createTime;
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
	public PurchaseApply setUpdateTime(Date updateTime) {
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
	public PurchaseApply setDeleted(Integer deleted) {
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
	public PurchaseApply setDeleted(Boolean deletedBool) {
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
	public PurchaseApply setDeleteBy(String deleteBy) {
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
	public PurchaseApply setDeleteTime(Date deleteTime) {
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
	public PurchaseApply setVersion(Integer version) {
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
	public PurchaseApply setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public PurchaseApply setChsType(String chsType) {
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
	public PurchaseApply setChsStatus(String chsStatus) {
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
	public PurchaseApply setChsVersion(String chsVersion) {
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
	public PurchaseApply setChangeInstanceId(String changeInstanceId) {
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
	public PurchaseApply setSummary(String summary) {
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
	public PurchaseApply setLatestApproverId(String latestApproverId) {
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
	public PurchaseApply setLatestApproverName(String latestApproverName) {
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
	public PurchaseApply setNextApproverIds(String nextApproverIds) {
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
	public PurchaseApply setNextApproverNames(String nextApproverNames) {
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
	public PurchaseApply setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion=approvalOpinion;
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
	public PurchaseApply setSupplier(Supplier supplier) {
		this.supplier=supplier;
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
	public PurchaseApply setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 申请部门<br>
	 * 申请部门
	 * @return 申请部门
	*/
	public Organization getApplyOrg() {
		return applyOrg;
	}
	
	/**
	 * 设置 申请部门
	 * @param applyOrg 申请部门
	 * @return 当前对象
	*/
	public PurchaseApply setApplyOrg(Organization applyOrg) {
		this.applyOrg=applyOrg;
		return this;
	}
	
	/**
	 * 获得 变更实例<br>
	 * 变更实例
	 * @return 变更实例
	*/
	public ChangeInstance getChangeInstance() {
		return changeInstance;
	}
	
	/**
	 * 设置 变更实例
	 * @param changeInstance 变更实例
	 * @return 当前对象
	*/
	public PurchaseApply setChangeInstance(ChangeInstance changeInstance) {
		this.changeInstance=changeInstance;
		return this;
	}
	
	/**
	 * 获得 采购清单<br>
	 * 采购清单
	 * @return 采购清单
	*/
	public List<PurchaseOrder> getOrderList() {
		return orderList;
	}
	
	/**
	 * 设置 采购清单
	 * @param orderList 采购清单
	 * @return 当前对象
	*/
	public PurchaseApply setOrderList(List<PurchaseOrder> orderList) {
		this.orderList=orderList;
		return this;
	}
	
	/**
	 * 添加 采购清单
	 * @param order 采购清单
	 * @return 当前对象
	*/
	public PurchaseApply addOrder(PurchaseOrder... order) {
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
	public PurchaseApply setOrderIds(List<String> orderIds) {
		this.orderIds=orderIds;
		return this;
	}
	
	/**
	 * 添加 清单列表
	 * @param orderId 清单列表
	 * @return 当前对象
	*/
	public PurchaseApply addOrderId(String... orderId) {
		if(this.orderIds==null) orderIds=new ArrayList<>();
		this.orderIds.addAll(Arrays.asList(orderId));
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
	public PurchaseApply setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 purchaseUser<br>
	 * purchaseUser
	 * @return purchaseUser
	*/
	public Employee getPurchaseUser() {
		return purchaseUser;
	}
	
	/**
	 * 设置 purchaseUser
	 * @param purchaseUser purchaseUser
	 * @return 当前对象
	*/
	public PurchaseApply setPurchaseUser(Employee purchaseUser) {
		this.purchaseUser=purchaseUser;
		return this;
	}
	
	/**
	 * 获得 历史流程清单<br>
	 * 历史流程清单
	 * @return 历史流程清单
	*/
	public List<ProcessInstance> getHistoricProcessList() {
		return historicProcessList;
	}
	
	/**
	 * 设置 历史流程清单
	 * @param historicProcessList 历史流程清单
	 * @return 当前对象
	*/
	public PurchaseApply setHistoricProcessList(List<ProcessInstance> historicProcessList) {
		this.historicProcessList=historicProcessList;
		return this;
	}
	
	/**
	 * 添加 历史流程清单
	 * @param historicProcess 历史流程清单
	 * @return 当前对象
	*/
	public PurchaseApply addHistoricProcess(ProcessInstance... historicProcess) {
		if(this.historicProcessList==null) historicProcessList=new ArrayList<>();
		this.historicProcessList.addAll(Arrays.asList(historicProcess));
		return this;
	}
	
	/**
	 * 获得 在批的流程清单<br>
	 * 在批的流程清单
	 * @return 在批的流程清单
	*/
	public List<ProcessInstance> getCurrentProcessList() {
		return currentProcessList;
	}
	
	/**
	 * 设置 在批的流程清单
	 * @param currentProcessList 在批的流程清单
	 * @return 当前对象
	*/
	public PurchaseApply setCurrentProcessList(List<ProcessInstance> currentProcessList) {
		this.currentProcessList=currentProcessList;
		return this;
	}
	
	/**
	 * 添加 在批的流程清单
	 * @param currentProcess 在批的流程清单
	 * @return 当前对象
	*/
	public PurchaseApply addCurrentProcess(ProcessInstance... currentProcess) {
		if(this.currentProcessList==null) currentProcessList=new ArrayList<>();
		this.currentProcessList.addAll(Arrays.asList(currentProcess));
		return this;
	}
	
	/**
	 * 获得 默认流程<br>
	 * 优先取在批的流程
	 * @return 默认流程
	*/
	public ProcessInstance getDefaultProcess() {
		return defaultProcess;
	}
	
	/**
	 * 设置 默认流程
	 * @param defaultProcess 默认流程
	 * @return 当前对象
	*/
	public PurchaseApply setDefaultProcess(ProcessInstance defaultProcess) {
		this.defaultProcess=defaultProcess;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PurchaseApply , 转换好的 PurchaseApply 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PurchaseApply , 转换好的 PoJo 对象
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
	public PurchaseApply clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PurchaseApply duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.PurchaseApplyMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.PurchaseApplyMeta.$$proxy$$();
		inst.setChsVersion(this.getChsVersion());
		inst.setSupplierId(this.getSupplierId());
		inst.setNotes(this.getNotes());
		inst.setProcId(this.getProcId());
		inst.setLatestApproverName(this.getLatestApproverName());
		inst.setChangeInstanceId(this.getChangeInstanceId());
		inst.setNextApproverIds(this.getNextApproverIds());
		inst.setApprovalOpinion(this.getApprovalOpinion());
		inst.setChsStatus(this.getChsStatus());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setExpectedArrivalDate(this.getExpectedArrivalDate());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setApplyContent(this.getApplyContent());
		inst.setAssetCheck(this.getAssetCheck());
		inst.setId(this.getId());
		inst.setAttach(this.getAttach());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setPurchaseUserId(this.getPurchaseUserId());
		inst.setSummary(this.getSummary());
		inst.setNextApproverNames(this.getNextApproverNames());
		inst.setApplyOrgId(this.getApplyOrgId());
		inst.setLatestApproverId(this.getLatestApproverId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setChsType(this.getChsType());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setApplyDate(this.getApplyDate());
		inst.setApplyStatus(this.getApplyStatus());
		inst.setCheckId(this.getCheckId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setApplyOrg(this.getApplyOrg());
			inst.setChangeInstance(this.getChangeInstance());
			inst.setSupplier(this.getSupplier());
			inst.setPurchaseUser(this.getPurchaseUser());
			inst.setOrderList(this.getOrderList());
			inst.setHistoricProcessList(this.getHistoricProcessList());
			inst.setOriginator(this.getOriginator());
			inst.setOrderIds(this.getOrderIds());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setCurrentProcessList(this.getCurrentProcessList());
			inst.setDefaultProcess(this.getDefaultProcess());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PurchaseApply clone(boolean deep) {
		return EntityContext.clone(PurchaseApply.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PurchaseApply
	 * @param purchaseApplyMap 包含实体信息的 Map 对象
	 * @return PurchaseApply , 转换好的的 PurchaseApply 对象
	*/
	@Transient
	public static PurchaseApply createFrom(Map<String,Object> purchaseApplyMap) {
		if(purchaseApplyMap==null) return null;
		PurchaseApply po = create();
		EntityContext.copyProperties(po,purchaseApplyMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PurchaseApply
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PurchaseApply , 转换好的的 PurchaseApply 对象
	*/
	@Transient
	public static PurchaseApply createFrom(Object pojo) {
		if(pojo==null) return null;
		PurchaseApply po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PurchaseApply，等同于 new
	 * @return PurchaseApply 对象
	*/
	@Transient
	public static PurchaseApply create() {
		return new com.dt.platform.domain.eam.meta.PurchaseApplyMeta.$$proxy$$();
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
			this.setChsVersion(DataParser.parse(String.class, map.get(PurchaseApplyMeta.CHS_VERSION)));
			this.setSupplierId(DataParser.parse(String.class, map.get(PurchaseApplyMeta.SUPPLIER_ID)));
			this.setNotes(DataParser.parse(String.class, map.get(PurchaseApplyMeta.NOTES)));
			this.setProcId(DataParser.parse(String.class, map.get(PurchaseApplyMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, map.get(PurchaseApplyMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, map.get(PurchaseApplyMeta.CHANGE_INSTANCE_ID)));
			this.setNextApproverIds(DataParser.parse(String.class, map.get(PurchaseApplyMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, map.get(PurchaseApplyMeta.APPROVAL_OPINION)));
			this.setChsStatus(DataParser.parse(String.class, map.get(PurchaseApplyMeta.CHS_STATUS)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(PurchaseApplyMeta.BUSINESS_CODE)));
			this.setExpectedArrivalDate(DataParser.parse(Date.class, map.get(PurchaseApplyMeta.EXPECTED_ARRIVAL_DATE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PurchaseApplyMeta.UPDATE_BY)));
			this.setApplyContent(DataParser.parse(String.class, map.get(PurchaseApplyMeta.APPLY_CONTENT)));
			this.setAssetCheck(DataParser.parse(String.class, map.get(PurchaseApplyMeta.ASSET_CHECK)));
			this.setId(DataParser.parse(String.class, map.get(PurchaseApplyMeta.ID)));
			this.setAttach(DataParser.parse(String.class, map.get(PurchaseApplyMeta.ATTACH)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(PurchaseApplyMeta.ORIGINATOR_ID)));
			this.setPurchaseUserId(DataParser.parse(String.class, map.get(PurchaseApplyMeta.PURCHASE_USER_ID)));
			this.setSummary(DataParser.parse(String.class, map.get(PurchaseApplyMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, map.get(PurchaseApplyMeta.NEXT_APPROVER_NAMES)));
			this.setApplyOrgId(DataParser.parse(String.class, map.get(PurchaseApplyMeta.APPLY_ORG_ID)));
			this.setLatestApproverId(DataParser.parse(String.class, map.get(PurchaseApplyMeta.LATEST_APPROVER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PurchaseApplyMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PurchaseApplyMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PurchaseApplyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PurchaseApplyMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PurchaseApplyMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PurchaseApplyMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, map.get(PurchaseApplyMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, map.get(PurchaseApplyMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PurchaseApplyMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PurchaseApplyMeta.DELETE_BY)));
			this.setApplyDate(DataParser.parse(String.class, map.get(PurchaseApplyMeta.APPLY_DATE)));
			this.setApplyStatus(DataParser.parse(String.class, map.get(PurchaseApplyMeta.APPLY_STATUS)));
			this.setCheckId(DataParser.parse(String.class, map.get(PurchaseApplyMeta.CHECK_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(PurchaseApplyMeta.STATUS)));
			// others
			this.setApplyOrg(DataParser.parse(Organization.class, map.get(PurchaseApplyMeta.APPLY_ORG)));
			this.setChangeInstance(DataParser.parse(ChangeInstance.class, map.get(PurchaseApplyMeta.CHANGE_INSTANCE)));
			this.setSupplier(DataParser.parse(Supplier.class, map.get(PurchaseApplyMeta.SUPPLIER)));
			this.setPurchaseUser(DataParser.parse(Employee.class, map.get(PurchaseApplyMeta.PURCHASE_USER)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(PurchaseApplyMeta.ORIGINATOR)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(PurchaseApplyMeta.SELECTED_CODE)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(PurchaseApplyMeta.DEFAULT_PROCESS)));
			return true;
		} else {
			try {
				this.setChsVersion( (String)map.get(PurchaseApplyMeta.CHS_VERSION));
				this.setSupplierId( (String)map.get(PurchaseApplyMeta.SUPPLIER_ID));
				this.setNotes( (String)map.get(PurchaseApplyMeta.NOTES));
				this.setProcId( (String)map.get(PurchaseApplyMeta.PROC_ID));
				this.setLatestApproverName( (String)map.get(PurchaseApplyMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)map.get(PurchaseApplyMeta.CHANGE_INSTANCE_ID));
				this.setNextApproverIds( (String)map.get(PurchaseApplyMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)map.get(PurchaseApplyMeta.APPROVAL_OPINION));
				this.setChsStatus( (String)map.get(PurchaseApplyMeta.CHS_STATUS));
				this.setBusinessCode( (String)map.get(PurchaseApplyMeta.BUSINESS_CODE));
				this.setExpectedArrivalDate( (Date)map.get(PurchaseApplyMeta.EXPECTED_ARRIVAL_DATE));
				this.setUpdateBy( (String)map.get(PurchaseApplyMeta.UPDATE_BY));
				this.setApplyContent( (String)map.get(PurchaseApplyMeta.APPLY_CONTENT));
				this.setAssetCheck( (String)map.get(PurchaseApplyMeta.ASSET_CHECK));
				this.setId( (String)map.get(PurchaseApplyMeta.ID));
				this.setAttach( (String)map.get(PurchaseApplyMeta.ATTACH));
				this.setOriginatorId( (String)map.get(PurchaseApplyMeta.ORIGINATOR_ID));
				this.setPurchaseUserId( (String)map.get(PurchaseApplyMeta.PURCHASE_USER_ID));
				this.setSummary( (String)map.get(PurchaseApplyMeta.SUMMARY));
				this.setNextApproverNames( (String)map.get(PurchaseApplyMeta.NEXT_APPROVER_NAMES));
				this.setApplyOrgId( (String)map.get(PurchaseApplyMeta.APPLY_ORG_ID));
				this.setLatestApproverId( (String)map.get(PurchaseApplyMeta.LATEST_APPROVER_ID));
				this.setUpdateTime( (Date)map.get(PurchaseApplyMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PurchaseApplyMeta.VERSION));
				this.setCreateBy( (String)map.get(PurchaseApplyMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PurchaseApplyMeta.DELETED));
				this.setCreateTime( (Date)map.get(PurchaseApplyMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(PurchaseApplyMeta.DELETE_TIME));
				this.setChsType( (String)map.get(PurchaseApplyMeta.CHS_TYPE));
				this.setName( (String)map.get(PurchaseApplyMeta.NAME));
				this.setTenantId( (String)map.get(PurchaseApplyMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PurchaseApplyMeta.DELETE_BY));
				this.setApplyDate( (String)map.get(PurchaseApplyMeta.APPLY_DATE));
				this.setApplyStatus( (String)map.get(PurchaseApplyMeta.APPLY_STATUS));
				this.setCheckId( (String)map.get(PurchaseApplyMeta.CHECK_ID));
				this.setStatus( (String)map.get(PurchaseApplyMeta.STATUS));
				// others
				this.setApplyOrg( (Organization)map.get(PurchaseApplyMeta.APPLY_ORG));
				this.setChangeInstance( (ChangeInstance)map.get(PurchaseApplyMeta.CHANGE_INSTANCE));
				this.setSupplier( (Supplier)map.get(PurchaseApplyMeta.SUPPLIER));
				this.setPurchaseUser( (Employee)map.get(PurchaseApplyMeta.PURCHASE_USER));
				this.setOriginator( (Employee)map.get(PurchaseApplyMeta.ORIGINATOR));
				this.setSelectedCode( (String)map.get(PurchaseApplyMeta.SELECTED_CODE));
				this.setDefaultProcess( (ProcessInstance)map.get(PurchaseApplyMeta.DEFAULT_PROCESS));
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
			this.setChsVersion(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.CHS_VERSION)));
			this.setSupplierId(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.SUPPLIER_ID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.NOTES)));
			this.setProcId(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.CHANGE_INSTANCE_ID)));
			this.setNextApproverIds(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.APPROVAL_OPINION)));
			this.setChsStatus(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.CHS_STATUS)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.BUSINESS_CODE)));
			this.setExpectedArrivalDate(DataParser.parse(Date.class, r.getValue(PurchaseApplyMeta.EXPECTED_ARRIVAL_DATE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.UPDATE_BY)));
			this.setApplyContent(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.APPLY_CONTENT)));
			this.setAssetCheck(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.ASSET_CHECK)));
			this.setId(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.ATTACH)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.ORIGINATOR_ID)));
			this.setPurchaseUserId(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.PURCHASE_USER_ID)));
			this.setSummary(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.NEXT_APPROVER_NAMES)));
			this.setApplyOrgId(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.APPLY_ORG_ID)));
			this.setLatestApproverId(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.LATEST_APPROVER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PurchaseApplyMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PurchaseApplyMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PurchaseApplyMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PurchaseApplyMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PurchaseApplyMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.DELETE_BY)));
			this.setApplyDate(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.APPLY_DATE)));
			this.setApplyStatus(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.APPLY_STATUS)));
			this.setCheckId(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.CHECK_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PurchaseApplyMeta.STATUS)));
			return true;
		} else {
			try {
				this.setChsVersion( (String)r.getValue(PurchaseApplyMeta.CHS_VERSION));
				this.setSupplierId( (String)r.getValue(PurchaseApplyMeta.SUPPLIER_ID));
				this.setNotes( (String)r.getValue(PurchaseApplyMeta.NOTES));
				this.setProcId( (String)r.getValue(PurchaseApplyMeta.PROC_ID));
				this.setLatestApproverName( (String)r.getValue(PurchaseApplyMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)r.getValue(PurchaseApplyMeta.CHANGE_INSTANCE_ID));
				this.setNextApproverIds( (String)r.getValue(PurchaseApplyMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)r.getValue(PurchaseApplyMeta.APPROVAL_OPINION));
				this.setChsStatus( (String)r.getValue(PurchaseApplyMeta.CHS_STATUS));
				this.setBusinessCode( (String)r.getValue(PurchaseApplyMeta.BUSINESS_CODE));
				this.setExpectedArrivalDate( (Date)r.getValue(PurchaseApplyMeta.EXPECTED_ARRIVAL_DATE));
				this.setUpdateBy( (String)r.getValue(PurchaseApplyMeta.UPDATE_BY));
				this.setApplyContent( (String)r.getValue(PurchaseApplyMeta.APPLY_CONTENT));
				this.setAssetCheck( (String)r.getValue(PurchaseApplyMeta.ASSET_CHECK));
				this.setId( (String)r.getValue(PurchaseApplyMeta.ID));
				this.setAttach( (String)r.getValue(PurchaseApplyMeta.ATTACH));
				this.setOriginatorId( (String)r.getValue(PurchaseApplyMeta.ORIGINATOR_ID));
				this.setPurchaseUserId( (String)r.getValue(PurchaseApplyMeta.PURCHASE_USER_ID));
				this.setSummary( (String)r.getValue(PurchaseApplyMeta.SUMMARY));
				this.setNextApproverNames( (String)r.getValue(PurchaseApplyMeta.NEXT_APPROVER_NAMES));
				this.setApplyOrgId( (String)r.getValue(PurchaseApplyMeta.APPLY_ORG_ID));
				this.setLatestApproverId( (String)r.getValue(PurchaseApplyMeta.LATEST_APPROVER_ID));
				this.setUpdateTime( (Date)r.getValue(PurchaseApplyMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PurchaseApplyMeta.VERSION));
				this.setCreateBy( (String)r.getValue(PurchaseApplyMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PurchaseApplyMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PurchaseApplyMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(PurchaseApplyMeta.DELETE_TIME));
				this.setChsType( (String)r.getValue(PurchaseApplyMeta.CHS_TYPE));
				this.setName( (String)r.getValue(PurchaseApplyMeta.NAME));
				this.setTenantId( (String)r.getValue(PurchaseApplyMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PurchaseApplyMeta.DELETE_BY));
				this.setApplyDate( (String)r.getValue(PurchaseApplyMeta.APPLY_DATE));
				this.setApplyStatus( (String)r.getValue(PurchaseApplyMeta.APPLY_STATUS));
				this.setCheckId( (String)r.getValue(PurchaseApplyMeta.CHECK_ID));
				this.setStatus( (String)r.getValue(PurchaseApplyMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}