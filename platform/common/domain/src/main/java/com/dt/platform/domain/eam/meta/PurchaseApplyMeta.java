package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.PurchaseApply;
import java.util.Date;
import com.dt.platform.domain.eam.Supplier;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import com.dt.platform.domain.eam.PurchaseOrder;
import java.util.List;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-07 21:23:31
 * @sign EB3E719E1569B7A0BA7D5B27D6DE69E6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PurchaseApplyMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,NAME, java.lang.String.class, "业务名称", "业务名称", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 申请状态 , 类型: java.lang.String
	*/
	public static final String APPLY_STATUS="applyStatus";
	
	/**
	 * 申请状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> APPLY_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,APPLY_STATUS, java.lang.String.class, "申请状态", "申请状态", java.lang.String.class, null);
	
	/**
	 * 申请部门 , 类型: java.lang.String
	*/
	public static final String APPLY_ORG_ID="applyOrgId";
	
	/**
	 * 申请部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> APPLY_ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,APPLY_ORG_ID, java.lang.String.class, "申请部门", "申请部门", java.lang.String.class, null);
	
	/**
	 * 采购人 , 类型: java.lang.String
	*/
	public static final String PURCHASE_USER_ID="purchaseUserId";
	
	/**
	 * 采购人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> PURCHASE_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,PURCHASE_USER_ID, java.lang.String.class, "采购人", "采购人", java.lang.String.class, null);
	
	/**
	 * 供应商 , 类型: java.lang.String
	*/
	public static final String SUPPLIER_ID="supplierId";
	
	/**
	 * 供应商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> SUPPLIER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,SUPPLIER_ID, java.lang.String.class, "供应商", "供应商", java.lang.String.class, null);
	
	/**
	 * 采购说明 , 类型: java.lang.String
	*/
	public static final String APPLY_CONTENT="applyContent";
	
	/**
	 * 采购说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> APPLY_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,APPLY_CONTENT, java.lang.String.class, "采购说明", "采购说明", java.lang.String.class, null);
	
	/**
	 * 采购日期 , 类型: java.lang.String
	*/
	public static final String APPLY_DATE="applyDate";
	
	/**
	 * 采购日期 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> APPLY_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,APPLY_DATE, java.lang.String.class, "采购日期", "采购日期", java.lang.String.class, null);
	
	/**
	 * 到货时间 , 类型: java.util.Date
	*/
	public static final String EXPECTED_ARRIVAL_DATE="expectedArrivalDate";
	
	/**
	 * 到货时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.util.Date> EXPECTED_ARRIVAL_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,EXPECTED_ARRIVAL_DATE, java.util.Date.class, "到货时间", "到货时间", java.util.Date.class, null);
	
	/**
	 * 验收单 , 类型: java.lang.String
	*/
	public static final String CHECK_ID="checkId";
	
	/**
	 * 验收单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> CHECK_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,CHECK_ID, java.lang.String.class, "验收单", "验收单", java.lang.String.class, null);
	
	/**
	 * 验收情况 , 类型: java.lang.String
	*/
	public static final String ASSET_CHECK="assetCheck";
	
	/**
	 * 验收情况 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> ASSET_CHECK_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,ASSET_CHECK, java.lang.String.class, "验收情况", "验收情况", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH="attach";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> ATTACH_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,ATTACH, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 变更类型 , 类型: java.lang.String
	*/
	public static final String CHS_TYPE="chsType";
	
	/**
	 * 变更类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> CHS_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,CHS_TYPE, java.lang.String.class, "变更类型", "变更类型", java.lang.String.class, null);
	
	/**
	 * 变更状态 , 类型: java.lang.String
	*/
	public static final String CHS_STATUS="chsStatus";
	
	/**
	 * 变更状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> CHS_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,CHS_STATUS, java.lang.String.class, "变更状态", "变更状态", java.lang.String.class, null);
	
	/**
	 * 变更版本号 , 类型: java.lang.String
	*/
	public static final String CHS_VERSION="chsVersion";
	
	/**
	 * 变更版本号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> CHS_VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,CHS_VERSION, java.lang.String.class, "变更版本号", "变更版本号", java.lang.String.class, null);
	
	/**
	 * 变更ID , 类型: java.lang.String
	*/
	public static final String CHANGE_INSTANCE_ID="changeInstanceId";
	
	/**
	 * 变更ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> CHANGE_INSTANCE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,CHANGE_INSTANCE_ID, java.lang.String.class, "变更ID", "变更ID", java.lang.String.class, null);
	
	/**
	 * 流程概要 , 类型: java.lang.String
	*/
	public static final String SUMMARY="summary";
	
	/**
	 * 流程概要 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> SUMMARY_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,SUMMARY, java.lang.String.class, "流程概要", "流程概要", java.lang.String.class, null);
	
	/**
	 * 最后审批人账户ID , 类型: java.lang.String
	*/
	public static final String LATEST_APPROVER_ID="latestApproverId";
	
	/**
	 * 最后审批人账户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> LATEST_APPROVER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,LATEST_APPROVER_ID, java.lang.String.class, "最后审批人账户ID", "最后审批人账户ID", java.lang.String.class, null);
	
	/**
	 * 最后审批人姓名 , 类型: java.lang.String
	*/
	public static final String LATEST_APPROVER_NAME="latestApproverName";
	
	/**
	 * 最后审批人姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> LATEST_APPROVER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,LATEST_APPROVER_NAME, java.lang.String.class, "最后审批人姓名", "最后审批人姓名", java.lang.String.class, null);
	
	/**
	 * 下一节点审批人 , 类型: java.lang.String
	*/
	public static final String NEXT_APPROVER_IDS="nextApproverIds";
	
	/**
	 * 下一节点审批人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> NEXT_APPROVER_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,NEXT_APPROVER_IDS, java.lang.String.class, "下一节点审批人", "下一节点审批人", java.lang.String.class, null);
	
	/**
	 * 下一个审批节点审批人姓名 , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final String NEXT_APPROVER_NAMES="nextApproverNames";
	
	/**
	 * 下一个审批节点审批人姓名 , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> NEXT_APPROVER_NAMES_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,NEXT_APPROVER_NAMES, java.lang.String.class, "下一个审批节点审批人姓名", "用逗号隔开", java.lang.String.class, null);
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final String APPROVAL_OPINION="approvalOpinion";
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> APPROVAL_OPINION_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,APPROVAL_OPINION, java.lang.String.class, "审批意见", "审批意见", java.lang.String.class, null);
	
	/**
	 * 供应商 , 类型: com.dt.platform.domain.eam.Supplier
	*/
	public static final String SUPPLIER="supplier";
	
	/**
	 * 供应商 , 类型: com.dt.platform.domain.eam.Supplier
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,com.dt.platform.domain.eam.Supplier> SUPPLIER_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,SUPPLIER, com.dt.platform.domain.eam.Supplier.class, "供应商", "供应商", com.dt.platform.domain.eam.Supplier.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 申请部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String APPLY_ORG="applyOrg";
	
	/**
	 * 申请部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,org.github.foxnic.web.domain.hrm.Organization> APPLY_ORG_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,APPLY_ORG, org.github.foxnic.web.domain.hrm.Organization.class, "申请部门", "申请部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 变更实例 , 类型: org.github.foxnic.web.domain.changes.ChangeInstance
	*/
	public static final String CHANGE_INSTANCE="changeInstance";
	
	/**
	 * 变更实例 , 类型: org.github.foxnic.web.domain.changes.ChangeInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,org.github.foxnic.web.domain.changes.ChangeInstance> CHANGE_INSTANCE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,CHANGE_INSTANCE, org.github.foxnic.web.domain.changes.ChangeInstance.class, "变更实例", "变更实例", org.github.foxnic.web.domain.changes.ChangeInstance.class, null);
	
	/**
	 * 采购清单 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.PurchaseOrder
	*/
	public static final String ORDER_LIST="orderList";
	
	/**
	 * 采购清单 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.PurchaseOrder
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,com.dt.platform.domain.eam.PurchaseOrder> ORDER_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,ORDER_LIST, java.util.List.class, "采购清单", "采购清单", com.dt.platform.domain.eam.PurchaseOrder.class, null);
	
	/**
	 * 清单列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ORDER_IDS="orderIds";
	
	/**
	 * 清单列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> ORDER_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,ORDER_IDS, java.util.List.class, "清单列表", "清单列表", java.lang.String.class, null);
	
	/**
	 * selectedCode , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * selectedCode , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,SELECTED_CODE, java.lang.String.class, "selectedCode", "selectedCode", java.lang.String.class, null);
	
	/**
	 * purchaseUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String PURCHASE_USER="purchaseUser";
	
	/**
	 * purchaseUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,org.github.foxnic.web.domain.hrm.Employee> PURCHASE_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,PURCHASE_USER, org.github.foxnic.web.domain.hrm.Employee.class, "purchaseUser", "purchaseUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String HISTORIC_PROCESS_LIST="historicProcessList";
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,org.github.foxnic.web.domain.bpm.ProcessInstance> HISTORIC_PROCESS_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,HISTORIC_PROCESS_LIST, java.util.List.class, "历史流程清单", "历史流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String CURRENT_PROCESS_LIST="currentProcessList";
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,org.github.foxnic.web.domain.bpm.ProcessInstance> CURRENT_PROCESS_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,CURRENT_PROCESS_LIST, java.util.List.class, "在批的流程清单", "在批的流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 默认流程 , 优先取在批的流程 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String DEFAULT_PROCESS="defaultProcess";
	
	/**
	 * 默认流程 , 优先取在批的流程 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseApply,org.github.foxnic.web.domain.bpm.ProcessInstance> DEFAULT_PROCESS_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseApply.class ,DEFAULT_PROCESS, org.github.foxnic.web.domain.bpm.ProcessInstance.class, "默认流程", "优先取在批的流程", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BUSINESS_CODE , PROC_ID , NAME , STATUS , APPLY_STATUS , APPLY_ORG_ID , PURCHASE_USER_ID , SUPPLIER_ID , APPLY_CONTENT , APPLY_DATE , EXPECTED_ARRIVAL_DATE , CHECK_ID , ASSET_CHECK , NOTES , ATTACH , ORIGINATOR_ID , CREATE_BY , UPDATE_BY , CREATE_TIME , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CHS_TYPE , CHS_STATUS , CHS_VERSION , CHANGE_INSTANCE_ID , SUMMARY , LATEST_APPROVER_ID , LATEST_APPROVER_NAME , NEXT_APPROVER_IDS , NEXT_APPROVER_NAMES , APPROVAL_OPINION , SUPPLIER , ORIGINATOR , APPLY_ORG , CHANGE_INSTANCE , ORDER_LIST , ORDER_IDS , SELECTED_CODE , PURCHASE_USER , HISTORIC_PROCESS_LIST , CURRENT_PROCESS_LIST , DEFAULT_PROCESS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.PurchaseApply {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PurchaseApply setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public PurchaseApply setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 流程
		 * @param procId 流程
		 * @return 当前对象
		*/
		public PurchaseApply setProcId(String procId) {
			super.change(PROC_ID,super.getProcId(),procId);
			super.setProcId(procId);
			return this;
		}
		
		/**
		 * 设置 业务名称
		 * @param name 业务名称
		 * @return 当前对象
		*/
		public PurchaseApply setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public PurchaseApply setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 申请状态
		 * @param applyStatus 申请状态
		 * @return 当前对象
		*/
		public PurchaseApply setApplyStatus(String applyStatus) {
			super.change(APPLY_STATUS,super.getApplyStatus(),applyStatus);
			super.setApplyStatus(applyStatus);
			return this;
		}
		
		/**
		 * 设置 申请部门
		 * @param applyOrgId 申请部门
		 * @return 当前对象
		*/
		public PurchaseApply setApplyOrgId(String applyOrgId) {
			super.change(APPLY_ORG_ID,super.getApplyOrgId(),applyOrgId);
			super.setApplyOrgId(applyOrgId);
			return this;
		}
		
		/**
		 * 设置 采购人
		 * @param purchaseUserId 采购人
		 * @return 当前对象
		*/
		public PurchaseApply setPurchaseUserId(String purchaseUserId) {
			super.change(PURCHASE_USER_ID,super.getPurchaseUserId(),purchaseUserId);
			super.setPurchaseUserId(purchaseUserId);
			return this;
		}
		
		/**
		 * 设置 供应商
		 * @param supplierId 供应商
		 * @return 当前对象
		*/
		public PurchaseApply setSupplierId(String supplierId) {
			super.change(SUPPLIER_ID,super.getSupplierId(),supplierId);
			super.setSupplierId(supplierId);
			return this;
		}
		
		/**
		 * 设置 采购说明
		 * @param applyContent 采购说明
		 * @return 当前对象
		*/
		public PurchaseApply setApplyContent(String applyContent) {
			super.change(APPLY_CONTENT,super.getApplyContent(),applyContent);
			super.setApplyContent(applyContent);
			return this;
		}
		
		/**
		 * 设置 采购日期
		 * @param applyDate 采购日期
		 * @return 当前对象
		*/
		public PurchaseApply setApplyDate(String applyDate) {
			super.change(APPLY_DATE,super.getApplyDate(),applyDate);
			super.setApplyDate(applyDate);
			return this;
		}
		
		/**
		 * 设置 到货时间
		 * @param expectedArrivalDate 到货时间
		 * @return 当前对象
		*/
		public PurchaseApply setExpectedArrivalDate(Date expectedArrivalDate) {
			super.change(EXPECTED_ARRIVAL_DATE,super.getExpectedArrivalDate(),expectedArrivalDate);
			super.setExpectedArrivalDate(expectedArrivalDate);
			return this;
		}
		
		/**
		 * 设置 验收单
		 * @param checkId 验收单
		 * @return 当前对象
		*/
		public PurchaseApply setCheckId(String checkId) {
			super.change(CHECK_ID,super.getCheckId(),checkId);
			super.setCheckId(checkId);
			return this;
		}
		
		/**
		 * 设置 验收情况
		 * @param assetCheck 验收情况
		 * @return 当前对象
		*/
		public PurchaseApply setAssetCheck(String assetCheck) {
			super.change(ASSET_CHECK,super.getAssetCheck(),assetCheck);
			super.setAssetCheck(assetCheck);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public PurchaseApply setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param attach 附件
		 * @return 当前对象
		*/
		public PurchaseApply setAttach(String attach) {
			super.change(ATTACH,super.getAttach(),attach);
			super.setAttach(attach);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public PurchaseApply setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PurchaseApply setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PurchaseApply setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PurchaseApply setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PurchaseApply setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PurchaseApply setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PurchaseApply setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PurchaseApply setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PurchaseApply setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PurchaseApply setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 变更类型
		 * @param chsType 变更类型
		 * @return 当前对象
		*/
		public PurchaseApply setChsType(String chsType) {
			super.change(CHS_TYPE,super.getChsType(),chsType);
			super.setChsType(chsType);
			return this;
		}
		
		/**
		 * 设置 变更状态
		 * @param chsStatus 变更状态
		 * @return 当前对象
		*/
		public PurchaseApply setChsStatus(String chsStatus) {
			super.change(CHS_STATUS,super.getChsStatus(),chsStatus);
			super.setChsStatus(chsStatus);
			return this;
		}
		
		/**
		 * 设置 变更版本号
		 * @param chsVersion 变更版本号
		 * @return 当前对象
		*/
		public PurchaseApply setChsVersion(String chsVersion) {
			super.change(CHS_VERSION,super.getChsVersion(),chsVersion);
			super.setChsVersion(chsVersion);
			return this;
		}
		
		/**
		 * 设置 变更ID
		 * @param changeInstanceId 变更ID
		 * @return 当前对象
		*/
		public PurchaseApply setChangeInstanceId(String changeInstanceId) {
			super.change(CHANGE_INSTANCE_ID,super.getChangeInstanceId(),changeInstanceId);
			super.setChangeInstanceId(changeInstanceId);
			return this;
		}
		
		/**
		 * 设置 流程概要
		 * @param summary 流程概要
		 * @return 当前对象
		*/
		public PurchaseApply setSummary(String summary) {
			super.change(SUMMARY,super.getSummary(),summary);
			super.setSummary(summary);
			return this;
		}
		
		/**
		 * 设置 最后审批人账户ID
		 * @param latestApproverId 最后审批人账户ID
		 * @return 当前对象
		*/
		public PurchaseApply setLatestApproverId(String latestApproverId) {
			super.change(LATEST_APPROVER_ID,super.getLatestApproverId(),latestApproverId);
			super.setLatestApproverId(latestApproverId);
			return this;
		}
		
		/**
		 * 设置 最后审批人姓名
		 * @param latestApproverName 最后审批人姓名
		 * @return 当前对象
		*/
		public PurchaseApply setLatestApproverName(String latestApproverName) {
			super.change(LATEST_APPROVER_NAME,super.getLatestApproverName(),latestApproverName);
			super.setLatestApproverName(latestApproverName);
			return this;
		}
		
		/**
		 * 设置 下一节点审批人
		 * @param nextApproverIds 下一节点审批人
		 * @return 当前对象
		*/
		public PurchaseApply setNextApproverIds(String nextApproverIds) {
			super.change(NEXT_APPROVER_IDS,super.getNextApproverIds(),nextApproverIds);
			super.setNextApproverIds(nextApproverIds);
			return this;
		}
		
		/**
		 * 设置 下一个审批节点审批人姓名
		 * @param nextApproverNames 下一个审批节点审批人姓名
		 * @return 当前对象
		*/
		public PurchaseApply setNextApproverNames(String nextApproverNames) {
			super.change(NEXT_APPROVER_NAMES,super.getNextApproverNames(),nextApproverNames);
			super.setNextApproverNames(nextApproverNames);
			return this;
		}
		
		/**
		 * 设置 审批意见
		 * @param approvalOpinion 审批意见
		 * @return 当前对象
		*/
		public PurchaseApply setApprovalOpinion(String approvalOpinion) {
			super.change(APPROVAL_OPINION,super.getApprovalOpinion(),approvalOpinion);
			super.setApprovalOpinion(approvalOpinion);
			return this;
		}
		
		/**
		 * 设置 供应商
		 * @param supplier 供应商
		 * @return 当前对象
		*/
		public PurchaseApply setSupplier(Supplier supplier) {
			super.change(SUPPLIER,super.getSupplier(),supplier);
			super.setSupplier(supplier);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public PurchaseApply setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 申请部门
		 * @param applyOrg 申请部门
		 * @return 当前对象
		*/
		public PurchaseApply setApplyOrg(Organization applyOrg) {
			super.change(APPLY_ORG,super.getApplyOrg(),applyOrg);
			super.setApplyOrg(applyOrg);
			return this;
		}
		
		/**
		 * 设置 变更实例
		 * @param changeInstance 变更实例
		 * @return 当前对象
		*/
		public PurchaseApply setChangeInstance(ChangeInstance changeInstance) {
			super.change(CHANGE_INSTANCE,super.getChangeInstance(),changeInstance);
			super.setChangeInstance(changeInstance);
			return this;
		}
		
		/**
		 * 设置 采购清单
		 * @param orderList 采购清单
		 * @return 当前对象
		*/
		public PurchaseApply setOrderList(List<PurchaseOrder> orderList) {
			super.change(ORDER_LIST,super.getOrderList(),orderList);
			super.setOrderList(orderList);
			return this;
		}
		
		/**
		 * 设置 清单列表
		 * @param orderIds 清单列表
		 * @return 当前对象
		*/
		public PurchaseApply setOrderIds(List<String> orderIds) {
			super.change(ORDER_IDS,super.getOrderIds(),orderIds);
			super.setOrderIds(orderIds);
			return this;
		}
		
		/**
		 * 设置 selectedCode
		 * @param selectedCode selectedCode
		 * @return 当前对象
		*/
		public PurchaseApply setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 purchaseUser
		 * @param purchaseUser purchaseUser
		 * @return 当前对象
		*/
		public PurchaseApply setPurchaseUser(Employee purchaseUser) {
			super.change(PURCHASE_USER,super.getPurchaseUser(),purchaseUser);
			super.setPurchaseUser(purchaseUser);
			return this;
		}
		
		/**
		 * 设置 历史流程清单
		 * @param historicProcessList 历史流程清单
		 * @return 当前对象
		*/
		public PurchaseApply setHistoricProcessList(List<ProcessInstance> historicProcessList) {
			super.change(HISTORIC_PROCESS_LIST,super.getHistoricProcessList(),historicProcessList);
			super.setHistoricProcessList(historicProcessList);
			return this;
		}
		
		/**
		 * 设置 在批的流程清单
		 * @param currentProcessList 在批的流程清单
		 * @return 当前对象
		*/
		public PurchaseApply setCurrentProcessList(List<ProcessInstance> currentProcessList) {
			super.change(CURRENT_PROCESS_LIST,super.getCurrentProcessList(),currentProcessList);
			super.setCurrentProcessList(currentProcessList);
			return this;
		}
		
		/**
		 * 设置 默认流程
		 * @param defaultProcess 默认流程
		 * @return 当前对象
		*/
		public PurchaseApply setDefaultProcess(ProcessInstance defaultProcess) {
			super.change(DEFAULT_PROCESS,super.getDefaultProcess(),defaultProcess);
			super.setDefaultProcess(defaultProcess);
			return this;
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
			$$proxy$$ inst=new $$proxy$$();
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

	}
}