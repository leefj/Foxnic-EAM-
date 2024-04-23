package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.PurchaseCheck;
import java.util.Date;
import com.dt.platform.domain.eam.Supplier;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.PurchaseOrder;
import java.util.List;
import com.dt.platform.domain.eam.PurchaseApply;
import com.dt.platform.domain.eam.WarehousePosition;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-23 15:48:37
 * @sign 04A139769904BEE9762F84F31BF5AD71
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PurchaseCheckMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 采购申请 , 类型: java.lang.String
	*/
	public static final String APPLY_ID="applyId";
	
	/**
	 * 采购申请 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> APPLY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,APPLY_ID, java.lang.String.class, "采购申请", "采购申请", java.lang.String.class, null);
	
	/**
	 * 供应商 , 类型: java.lang.String
	*/
	public static final String SUPPLIER_ID="supplierId";
	
	/**
	 * 供应商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> SUPPLIER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,SUPPLIER_ID, java.lang.String.class, "供应商", "供应商", java.lang.String.class, null);
	
	/**
	 * 验收人 , 类型: java.lang.String
	*/
	public static final String CHECK_USER_ID="checkUserId";
	
	/**
	 * 验收人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> CHECK_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,CHECK_USER_ID, java.lang.String.class, "验收人", "验收人", java.lang.String.class, null);
	
	/**
	 * 验收人 , 类型: java.lang.String
	*/
	public static final String CHECK_USER_NAME="checkUserName";
	
	/**
	 * 验收人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> CHECK_USER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,CHECK_USER_NAME, java.lang.String.class, "验收人", "验收人", java.lang.String.class, null);
	
	/**
	 * 验收时间 , 类型: java.lang.String
	*/
	public static final String CHECK_DATE="checkDate";
	
	/**
	 * 验收时间 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> CHECK_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,CHECK_DATE, java.lang.String.class, "验收时间", "验收时间", java.lang.String.class, null);
	
	/**
	 * 验收信息 , 类型: java.lang.String
	*/
	public static final String CHECK_INFORMATION="checkInformation";
	
	/**
	 * 验收信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> CHECK_INFORMATION_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,CHECK_INFORMATION, java.lang.String.class, "验收信息", "验收信息", java.lang.String.class, null);
	
	/**
	 * 到货日期 , 类型: java.lang.String
	*/
	public static final String RECEIVE_DATE="receiveDate";
	
	/**
	 * 到货日期 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> RECEIVE_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,RECEIVE_DATE, java.lang.String.class, "到货日期", "到货日期", java.lang.String.class, null);
	
	/**
	 * 仓库库位 , 类型: java.lang.String
	*/
	public static final String POSITION_ID="positionId";
	
	/**
	 * 仓库库位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> POSITION_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,POSITION_ID, java.lang.String.class, "仓库库位", "仓库库位", java.lang.String.class, null);
	
	/**
	 * 是否入库 , 类型: java.lang.String
	*/
	public static final String INSERT_POSITION="insertPosition";
	
	/**
	 * 是否入库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> INSERT_POSITION_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,INSERT_POSITION, java.lang.String.class, "是否入库", "是否入库", java.lang.String.class, null);
	
	/**
	 * 入库状态 , 类型: java.lang.String
	*/
	public static final String STOCK_STATUS="stockStatus";
	
	/**
	 * 入库状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> STOCK_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,STOCK_STATUS, java.lang.String.class, "入库状态", "入库状态", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH="attach";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> ATTACH_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,ATTACH, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,SELECTED_CODE, java.lang.String.class, "选择数据", "选择数据", java.lang.String.class, null);
	
	/**
	 * 供应商 , 类型: com.dt.platform.domain.eam.Supplier
	*/
	public static final String SUPPLIER="supplier";
	
	/**
	 * 供应商 , 类型: com.dt.platform.domain.eam.Supplier
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,com.dt.platform.domain.eam.Supplier> SUPPLIER_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,SUPPLIER, com.dt.platform.domain.eam.Supplier.class, "供应商", "供应商", com.dt.platform.domain.eam.Supplier.class, null);
	
	/**
	 * 验收公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String CHECK_ORG="checkOrg";
	
	/**
	 * 验收公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,org.github.foxnic.web.domain.hrm.Organization> CHECK_ORG_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,CHECK_ORG, org.github.foxnic.web.domain.hrm.Organization.class, "验收公司/部门", "验收公司/部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * checkUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String CHECK_USER="checkUser";
	
	/**
	 * checkUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,org.github.foxnic.web.domain.hrm.Employee> CHECK_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,CHECK_USER, org.github.foxnic.web.domain.hrm.Employee.class, "checkUser", "checkUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 清单 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.PurchaseOrder
	*/
	public static final String ORDER_LIST="orderList";
	
	/**
	 * 清单 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.PurchaseOrder
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,com.dt.platform.domain.eam.PurchaseOrder> ORDER_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,ORDER_LIST, java.util.List.class, "清单", "清单", com.dt.platform.domain.eam.PurchaseOrder.class, null);
	
	/**
	 * 清单列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ORDER_IDS="orderIds";
	
	/**
	 * 清单列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> ORDER_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,ORDER_IDS, java.util.List.class, "清单列表", "清单列表", java.lang.String.class, null);
	
	/**
	 * 领用申请 , 类型: com.dt.platform.domain.eam.PurchaseApply
	*/
	public static final String PURCHASE_APPLY="purchaseApply";
	
	/**
	 * 领用申请 , 类型: com.dt.platform.domain.eam.PurchaseApply
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,com.dt.platform.domain.eam.PurchaseApply> PURCHASE_APPLY_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,PURCHASE_APPLY, com.dt.platform.domain.eam.PurchaseApply.class, "领用申请", "领用申请", com.dt.platform.domain.eam.PurchaseApply.class, null);
	
	/**
	 * applyCode , 类型: java.lang.String
	*/
	public static final String APPLY_CODE="applyCode";
	
	/**
	 * applyCode , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> APPLY_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,APPLY_CODE, java.lang.String.class, "applyCode", "applyCode", java.lang.String.class, null);
	
	/**
	 * applyName , 类型: java.lang.String
	*/
	public static final String APPLY_NAME="applyName";
	
	/**
	 * applyName , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,java.lang.String> APPLY_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,APPLY_NAME, java.lang.String.class, "applyName", "applyName", java.lang.String.class, null);
	
	/**
	 * warehousePosition , 类型: com.dt.platform.domain.eam.WarehousePosition
	*/
	public static final String WAREHOUSE_POSITION="warehousePosition";
	
	/**
	 * warehousePosition , 类型: com.dt.platform.domain.eam.WarehousePosition
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PurchaseCheck,com.dt.platform.domain.eam.WarehousePosition> WAREHOUSE_POSITION_PROP = new BeanProperty(com.dt.platform.domain.eam.PurchaseCheck.class ,WAREHOUSE_POSITION, com.dt.platform.domain.eam.WarehousePosition.class, "warehousePosition", "warehousePosition", com.dt.platform.domain.eam.WarehousePosition.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PROC_ID , STATUS , BUSINESS_CODE , NAME , APPLY_ID , SUPPLIER_ID , CHECK_USER_ID , CHECK_USER_NAME , CHECK_DATE , CHECK_INFORMATION , RECEIVE_DATE , POSITION_ID , INSERT_POSITION , STOCK_STATUS , ATTACH , NOTES , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , SUPPLIER , CHECK_ORG , ORIGINATOR , CHECK_USER , ORDER_LIST , ORDER_IDS , PURCHASE_APPLY , APPLY_CODE , APPLY_NAME , WAREHOUSE_POSITION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.PurchaseCheck {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PurchaseCheck setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 流程
		 * @param procId 流程
		 * @return 当前对象
		*/
		public PurchaseCheck setProcId(String procId) {
			super.change(PROC_ID,super.getProcId(),procId);
			super.setProcId(procId);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public PurchaseCheck setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public PurchaseCheck setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public PurchaseCheck setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 采购申请
		 * @param applyId 采购申请
		 * @return 当前对象
		*/
		public PurchaseCheck setApplyId(String applyId) {
			super.change(APPLY_ID,super.getApplyId(),applyId);
			super.setApplyId(applyId);
			return this;
		}
		
		/**
		 * 设置 供应商
		 * @param supplierId 供应商
		 * @return 当前对象
		*/
		public PurchaseCheck setSupplierId(String supplierId) {
			super.change(SUPPLIER_ID,super.getSupplierId(),supplierId);
			super.setSupplierId(supplierId);
			return this;
		}
		
		/**
		 * 设置 验收人
		 * @param checkUserId 验收人
		 * @return 当前对象
		*/
		public PurchaseCheck setCheckUserId(String checkUserId) {
			super.change(CHECK_USER_ID,super.getCheckUserId(),checkUserId);
			super.setCheckUserId(checkUserId);
			return this;
		}
		
		/**
		 * 设置 验收人
		 * @param checkUserName 验收人
		 * @return 当前对象
		*/
		public PurchaseCheck setCheckUserName(String checkUserName) {
			super.change(CHECK_USER_NAME,super.getCheckUserName(),checkUserName);
			super.setCheckUserName(checkUserName);
			return this;
		}
		
		/**
		 * 设置 验收时间
		 * @param checkDate 验收时间
		 * @return 当前对象
		*/
		public PurchaseCheck setCheckDate(String checkDate) {
			super.change(CHECK_DATE,super.getCheckDate(),checkDate);
			super.setCheckDate(checkDate);
			return this;
		}
		
		/**
		 * 设置 验收信息
		 * @param checkInformation 验收信息
		 * @return 当前对象
		*/
		public PurchaseCheck setCheckInformation(String checkInformation) {
			super.change(CHECK_INFORMATION,super.getCheckInformation(),checkInformation);
			super.setCheckInformation(checkInformation);
			return this;
		}
		
		/**
		 * 设置 到货日期
		 * @param receiveDate 到货日期
		 * @return 当前对象
		*/
		public PurchaseCheck setReceiveDate(String receiveDate) {
			super.change(RECEIVE_DATE,super.getReceiveDate(),receiveDate);
			super.setReceiveDate(receiveDate);
			return this;
		}
		
		/**
		 * 设置 仓库库位
		 * @param positionId 仓库库位
		 * @return 当前对象
		*/
		public PurchaseCheck setPositionId(String positionId) {
			super.change(POSITION_ID,super.getPositionId(),positionId);
			super.setPositionId(positionId);
			return this;
		}
		
		/**
		 * 设置 是否入库
		 * @param insertPosition 是否入库
		 * @return 当前对象
		*/
		public PurchaseCheck setInsertPosition(String insertPosition) {
			super.change(INSERT_POSITION,super.getInsertPosition(),insertPosition);
			super.setInsertPosition(insertPosition);
			return this;
		}
		
		/**
		 * 设置 入库状态
		 * @param stockStatus 入库状态
		 * @return 当前对象
		*/
		public PurchaseCheck setStockStatus(String stockStatus) {
			super.change(STOCK_STATUS,super.getStockStatus(),stockStatus);
			super.setStockStatus(stockStatus);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param attach 附件
		 * @return 当前对象
		*/
		public PurchaseCheck setAttach(String attach) {
			super.change(ATTACH,super.getAttach(),attach);
			super.setAttach(attach);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public PurchaseCheck setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public PurchaseCheck setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PurchaseCheck setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PurchaseCheck setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PurchaseCheck setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PurchaseCheck setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PurchaseCheck setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PurchaseCheck setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PurchaseCheck setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PurchaseCheck setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PurchaseCheck setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 选择数据
		 * @param selectedCode 选择数据
		 * @return 当前对象
		*/
		public PurchaseCheck setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 供应商
		 * @param supplier 供应商
		 * @return 当前对象
		*/
		public PurchaseCheck setSupplier(Supplier supplier) {
			super.change(SUPPLIER,super.getSupplier(),supplier);
			super.setSupplier(supplier);
			return this;
		}
		
		/**
		 * 设置 验收公司/部门
		 * @param checkOrg 验收公司/部门
		 * @return 当前对象
		*/
		public PurchaseCheck setCheckOrg(Organization checkOrg) {
			super.change(CHECK_ORG,super.getCheckOrg(),checkOrg);
			super.setCheckOrg(checkOrg);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public PurchaseCheck setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 checkUser
		 * @param checkUser checkUser
		 * @return 当前对象
		*/
		public PurchaseCheck setCheckUser(Employee checkUser) {
			super.change(CHECK_USER,super.getCheckUser(),checkUser);
			super.setCheckUser(checkUser);
			return this;
		}
		
		/**
		 * 设置 清单
		 * @param orderList 清单
		 * @return 当前对象
		*/
		public PurchaseCheck setOrderList(List<PurchaseOrder> orderList) {
			super.change(ORDER_LIST,super.getOrderList(),orderList);
			super.setOrderList(orderList);
			return this;
		}
		
		/**
		 * 设置 清单列表
		 * @param orderIds 清单列表
		 * @return 当前对象
		*/
		public PurchaseCheck setOrderIds(List<String> orderIds) {
			super.change(ORDER_IDS,super.getOrderIds(),orderIds);
			super.setOrderIds(orderIds);
			return this;
		}
		
		/**
		 * 设置 领用申请
		 * @param purchaseApply 领用申请
		 * @return 当前对象
		*/
		public PurchaseCheck setPurchaseApply(PurchaseApply purchaseApply) {
			super.change(PURCHASE_APPLY,super.getPurchaseApply(),purchaseApply);
			super.setPurchaseApply(purchaseApply);
			return this;
		}
		
		/**
		 * 设置 applyCode
		 * @param applyCode applyCode
		 * @return 当前对象
		*/
		public PurchaseCheck setApplyCode(String applyCode) {
			super.change(APPLY_CODE,super.getApplyCode(),applyCode);
			super.setApplyCode(applyCode);
			return this;
		}
		
		/**
		 * 设置 applyName
		 * @param applyName applyName
		 * @return 当前对象
		*/
		public PurchaseCheck setApplyName(String applyName) {
			super.change(APPLY_NAME,super.getApplyName(),applyName);
			super.setApplyName(applyName);
			return this;
		}
		
		/**
		 * 设置 warehousePosition
		 * @param warehousePosition warehousePosition
		 * @return 当前对象
		*/
		public PurchaseCheck setWarehousePosition(WarehousePosition warehousePosition) {
			super.change(WAREHOUSE_POSITION,super.getWarehousePosition(),warehousePosition);
			super.setWarehousePosition(warehousePosition);
			return this;
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
			$$proxy$$ inst=new $$proxy$$();
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

	}
}