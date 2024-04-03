package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.DbChangeApply;
import java.util.Date;
import com.dt.platform.domain.ops.DbInfoApply;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.ops.DbApplyExecute;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-31 22:50:13
 * @sign A14E771AED8D459BE454C6E666FF653C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DbChangeApplyMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 关联工单 , 类型: java.lang.String
	*/
	public static final String ITEM_CODE="itemCode";
	
	/**
	 * 关联工单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> ITEM_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,ITEM_CODE, java.lang.String.class, "关联工单", "关联工单", java.lang.String.class, null);
	
	/**
	 * 关联工单 , 类型: java.lang.String
	*/
	public static final String ITEM_NAME="itemName";
	
	/**
	 * 关联工单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> ITEM_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,ITEM_NAME, java.lang.String.class, "关联工单", "关联工单", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final String DB_FULL_NAME="dbFullName";
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> DB_FULL_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,DB_FULL_NAME, java.lang.String.class, "数据库", "数据库", java.lang.String.class, null);
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final String DB_ID="dbId";
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> DB_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,DB_ID, java.lang.String.class, "数据库", "数据库", java.lang.String.class, null);
	
	/**
	 * 数据库IP , 类型: java.lang.String
	*/
	public static final String DB_IP="dbIp";
	
	/**
	 * 数据库IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> DB_IP_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,DB_IP, java.lang.String.class, "数据库IP", "数据库IP", java.lang.String.class, null);
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final String DB_NAME="dbName";
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> DB_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,DB_NAME, java.lang.String.class, "数据库", "数据库", java.lang.String.class, null);
	
	/**
	 * 端口 , 类型: java.lang.String
	*/
	public static final String DB_PORT="dbPort";
	
	/**
	 * 端口 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> DB_PORT_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,DB_PORT, java.lang.String.class, "端口", "端口", java.lang.String.class, null);
	
	/**
	 * 数据库用户 , 类型: java.lang.String
	*/
	public static final String DB_USER="dbUser";
	
	/**
	 * 数据库用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> DB_USER_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,DB_USER, java.lang.String.class, "数据库用户", "数据库用户", java.lang.String.class, null);
	
	/**
	 * 原因 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 原因 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,CONTENT, java.lang.String.class, "原因", "原因", java.lang.String.class, null);
	
	/**
	 * SQL文本 , 类型: java.lang.String
	*/
	public static final String SQL_AREA="sqlArea";
	
	/**
	 * SQL文本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> SQL_AREA_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,SQL_AREA, java.lang.String.class, "SQL文本", "SQL文本", java.lang.String.class, null);
	
	/**
	 * 验证结果 , 类型: java.lang.String
	*/
	public static final String CHECK_RESULT="checkResult";
	
	/**
	 * 验证结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> CHECK_RESULT_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,CHECK_RESULT, java.lang.String.class, "验证结果", "验证结果", java.lang.String.class, null);
	
	/**
	 * 回滚/备份 , 类型: java.lang.String
	*/
	public static final String RB_RESULT="rbResult";
	
	/**
	 * 回滚/备份 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> RB_RESULT_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,RB_RESULT, java.lang.String.class, "回滚/备份", "回滚/备份", java.lang.String.class, null);
	
	/**
	 * 推送工单 , 类型: java.lang.String
	*/
	public static final String PUSH_ORDER_STATUS="pushOrderStatus";
	
	/**
	 * 推送工单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> PUSH_ORDER_STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,PUSH_ORDER_STATUS, java.lang.String.class, "推送工单", "推送工单", java.lang.String.class, null);
	
	/**
	 * 返回信息 , 类型: java.lang.String
	*/
	public static final String PUSH_RESULT="pushResult";
	
	/**
	 * 返回信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> PUSH_RESULT_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,PUSH_RESULT, java.lang.String.class, "返回信息", "返回信息", java.lang.String.class, null);
	
	/**
	 * 工单编号 , 类型: java.lang.String
	*/
	public static final String ORDER_ID="orderId";
	
	/**
	 * 工单编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> ORDER_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,ORDER_ID, java.lang.String.class, "工单编号", "工单编号", java.lang.String.class, null);
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final String APPLY_USER_ID="applyUserId";
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> APPLY_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,APPLY_USER_ID, java.lang.String.class, "申请人", "申请人", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 关联系统 , 类型: java.lang.String
	*/
	public static final String ASSOCIATED_SYSTEM="associatedSystem";
	
	/**
	 * 关联系统 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> ASSOCIATED_SYSTEM_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,ASSOCIATED_SYSTEM, java.lang.String.class, "关联系统", "关联系统", java.lang.String.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * dbInfoApply , 类型: com.dt.platform.domain.ops.DbInfoApply
	*/
	public static final String DB_INFO_APPLY="dbInfoApply";
	
	/**
	 * dbInfoApply , 类型: com.dt.platform.domain.ops.DbInfoApply
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,com.dt.platform.domain.ops.DbInfoApply> DB_INFO_APPLY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,DB_INFO_APPLY, com.dt.platform.domain.ops.DbInfoApply.class, "dbInfoApply", "dbInfoApply", com.dt.platform.domain.ops.DbInfoApply.class, null);
	
	/**
	 * applyUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String APPLY_USER="applyUser";
	
	/**
	 * applyUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,org.github.foxnic.web.domain.hrm.Employee> APPLY_USER_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,APPLY_USER, org.github.foxnic.web.domain.hrm.Employee.class, "applyUser", "applyUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * requestOrder , 类型: com.dt.platform.domain.ops.DbApplyExecute
	*/
	public static final String REQUEST_ORDER="requestOrder";
	
	/**
	 * requestOrder , 类型: com.dt.platform.domain.ops.DbApplyExecute
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,com.dt.platform.domain.ops.DbApplyExecute> REQUEST_ORDER_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,REQUEST_ORDER, com.dt.platform.domain.ops.DbApplyExecute.class, "requestOrder", "requestOrder", com.dt.platform.domain.ops.DbApplyExecute.class, null);
	
	/**
	 * buttonCheck , 类型: java.lang.String
	*/
	public static final String BUTTON_CHECK="buttonCheck";
	
	/**
	 * buttonCheck , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> BUTTON_CHECK_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,BUTTON_CHECK, java.lang.String.class, "buttonCheck", "buttonCheck", java.lang.String.class, null);
	
	/**
	 * buttonCheckDetail , 类型: java.lang.String
	*/
	public static final String BUTTON_CHECK_DETAIL="buttonCheckDetail";
	
	/**
	 * buttonCheckDetail , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> BUTTON_CHECK_DETAIL_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,BUTTON_CHECK_DETAIL, java.lang.String.class, "buttonCheckDetail", "buttonCheckDetail", java.lang.String.class, null);
	
	/**
	 * buttonRB , 类型: java.lang.String
	*/
	public static final String BUTTON_RB="buttonRB";
	
	/**
	 * buttonRB , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> BUTTON_RB_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,BUTTON_RB, java.lang.String.class, "buttonRB", "buttonRB", java.lang.String.class, null);
	
	/**
	 * buttonRBDetail , 类型: java.lang.String
	*/
	public static final String BUTTON_RB_DETAIL="buttonRBDetail";
	
	/**
	 * buttonRBDetail , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbChangeApply,java.lang.String> BUTTON_RB_DETAIL_PROP = new BeanProperty(com.dt.platform.domain.ops.DbChangeApply.class ,BUTTON_RB_DETAIL, java.lang.String.class, "buttonRBDetail", "buttonRBDetail", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ITEM_CODE , ITEM_NAME , STATUS , DB_FULL_NAME , DB_ID , DB_IP , DB_NAME , DB_PORT , DB_USER , CONTENT , SQL_AREA , CHECK_RESULT , RB_RESULT , PUSH_ORDER_STATUS , PUSH_RESULT , ORDER_ID , APPLY_USER_ID , SELECTED_CODE , NOTES , ASSOCIATED_SYSTEM , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , CREATE_BY , CREATE_TIME , VERSION , TENANT_ID , DB_INFO_APPLY , APPLY_USER , REQUEST_ORDER , BUTTON_CHECK , BUTTON_CHECK_DETAIL , BUTTON_RB , BUTTON_RB_DETAIL };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.DbChangeApply {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public DbChangeApply setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 关联工单
		 * @param itemCode 关联工单
		 * @return 当前对象
		*/
		public DbChangeApply setItemCode(String itemCode) {
			super.change(ITEM_CODE,super.getItemCode(),itemCode);
			super.setItemCode(itemCode);
			return this;
		}
		
		/**
		 * 设置 关联工单
		 * @param itemName 关联工单
		 * @return 当前对象
		*/
		public DbChangeApply setItemName(String itemName) {
			super.change(ITEM_NAME,super.getItemName(),itemName);
			super.setItemName(itemName);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public DbChangeApply setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 数据库
		 * @param dbFullName 数据库
		 * @return 当前对象
		*/
		public DbChangeApply setDbFullName(String dbFullName) {
			super.change(DB_FULL_NAME,super.getDbFullName(),dbFullName);
			super.setDbFullName(dbFullName);
			return this;
		}
		
		/**
		 * 设置 数据库
		 * @param dbId 数据库
		 * @return 当前对象
		*/
		public DbChangeApply setDbId(String dbId) {
			super.change(DB_ID,super.getDbId(),dbId);
			super.setDbId(dbId);
			return this;
		}
		
		/**
		 * 设置 数据库IP
		 * @param dbIp 数据库IP
		 * @return 当前对象
		*/
		public DbChangeApply setDbIp(String dbIp) {
			super.change(DB_IP,super.getDbIp(),dbIp);
			super.setDbIp(dbIp);
			return this;
		}
		
		/**
		 * 设置 数据库
		 * @param dbName 数据库
		 * @return 当前对象
		*/
		public DbChangeApply setDbName(String dbName) {
			super.change(DB_NAME,super.getDbName(),dbName);
			super.setDbName(dbName);
			return this;
		}
		
		/**
		 * 设置 端口
		 * @param dbPort 端口
		 * @return 当前对象
		*/
		public DbChangeApply setDbPort(String dbPort) {
			super.change(DB_PORT,super.getDbPort(),dbPort);
			super.setDbPort(dbPort);
			return this;
		}
		
		/**
		 * 设置 数据库用户
		 * @param dbUser 数据库用户
		 * @return 当前对象
		*/
		public DbChangeApply setDbUser(String dbUser) {
			super.change(DB_USER,super.getDbUser(),dbUser);
			super.setDbUser(dbUser);
			return this;
		}
		
		/**
		 * 设置 原因
		 * @param content 原因
		 * @return 当前对象
		*/
		public DbChangeApply setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 SQL文本
		 * @param sqlArea SQL文本
		 * @return 当前对象
		*/
		public DbChangeApply setSqlArea(String sqlArea) {
			super.change(SQL_AREA,super.getSqlArea(),sqlArea);
			super.setSqlArea(sqlArea);
			return this;
		}
		
		/**
		 * 设置 验证结果
		 * @param checkResult 验证结果
		 * @return 当前对象
		*/
		public DbChangeApply setCheckResult(String checkResult) {
			super.change(CHECK_RESULT,super.getCheckResult(),checkResult);
			super.setCheckResult(checkResult);
			return this;
		}
		
		/**
		 * 设置 回滚/备份
		 * @param rbResult 回滚/备份
		 * @return 当前对象
		*/
		public DbChangeApply setRbResult(String rbResult) {
			super.change(RB_RESULT,super.getRbResult(),rbResult);
			super.setRbResult(rbResult);
			return this;
		}
		
		/**
		 * 设置 推送工单
		 * @param pushOrderStatus 推送工单
		 * @return 当前对象
		*/
		public DbChangeApply setPushOrderStatus(String pushOrderStatus) {
			super.change(PUSH_ORDER_STATUS,super.getPushOrderStatus(),pushOrderStatus);
			super.setPushOrderStatus(pushOrderStatus);
			return this;
		}
		
		/**
		 * 设置 返回信息
		 * @param pushResult 返回信息
		 * @return 当前对象
		*/
		public DbChangeApply setPushResult(String pushResult) {
			super.change(PUSH_RESULT,super.getPushResult(),pushResult);
			super.setPushResult(pushResult);
			return this;
		}
		
		/**
		 * 设置 工单编号
		 * @param orderId 工单编号
		 * @return 当前对象
		*/
		public DbChangeApply setOrderId(String orderId) {
			super.change(ORDER_ID,super.getOrderId(),orderId);
			super.setOrderId(orderId);
			return this;
		}
		
		/**
		 * 设置 申请人
		 * @param applyUserId 申请人
		 * @return 当前对象
		*/
		public DbChangeApply setApplyUserId(String applyUserId) {
			super.change(APPLY_USER_ID,super.getApplyUserId(),applyUserId);
			super.setApplyUserId(applyUserId);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public DbChangeApply setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public DbChangeApply setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 关联系统
		 * @param associatedSystem 关联系统
		 * @return 当前对象
		*/
		public DbChangeApply setAssociatedSystem(String associatedSystem) {
			super.change(ASSOCIATED_SYSTEM,super.getAssociatedSystem(),associatedSystem);
			super.setAssociatedSystem(associatedSystem);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public DbChangeApply setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public DbChangeApply setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public DbChangeApply setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public DbChangeApply setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public DbChangeApply setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public DbChangeApply setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public DbChangeApply setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public DbChangeApply setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public DbChangeApply setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 dbInfoApply
		 * @param dbInfoApply dbInfoApply
		 * @return 当前对象
		*/
		public DbChangeApply setDbInfoApply(DbInfoApply dbInfoApply) {
			super.change(DB_INFO_APPLY,super.getDbInfoApply(),dbInfoApply);
			super.setDbInfoApply(dbInfoApply);
			return this;
		}
		
		/**
		 * 设置 applyUser
		 * @param applyUser applyUser
		 * @return 当前对象
		*/
		public DbChangeApply setApplyUser(Employee applyUser) {
			super.change(APPLY_USER,super.getApplyUser(),applyUser);
			super.setApplyUser(applyUser);
			return this;
		}
		
		/**
		 * 设置 requestOrder
		 * @param requestOrder requestOrder
		 * @return 当前对象
		*/
		public DbChangeApply setRequestOrder(DbApplyExecute requestOrder) {
			super.change(REQUEST_ORDER,super.getRequestOrder(),requestOrder);
			super.setRequestOrder(requestOrder);
			return this;
		}
		
		/**
		 * 设置 buttonCheck
		 * @param buttonCheck buttonCheck
		 * @return 当前对象
		*/
		public DbChangeApply setButtonCheck(String buttonCheck) {
			super.change(BUTTON_CHECK,super.getButtonCheck(),buttonCheck);
			super.setButtonCheck(buttonCheck);
			return this;
		}
		
		/**
		 * 设置 buttonCheckDetail
		 * @param buttonCheckDetail buttonCheckDetail
		 * @return 当前对象
		*/
		public DbChangeApply setButtonCheckDetail(String buttonCheckDetail) {
			super.change(BUTTON_CHECK_DETAIL,super.getButtonCheckDetail(),buttonCheckDetail);
			super.setButtonCheckDetail(buttonCheckDetail);
			return this;
		}
		
		/**
		 * 设置 buttonRB
		 * @param buttonRB buttonRB
		 * @return 当前对象
		*/
		public DbChangeApply setButtonRB(String buttonRB) {
			super.change(BUTTON_RB,super.getButtonRB(),buttonRB);
			super.setButtonRB(buttonRB);
			return this;
		}
		
		/**
		 * 设置 buttonRBDetail
		 * @param buttonRBDetail buttonRBDetail
		 * @return 当前对象
		*/
		public DbChangeApply setButtonRBDetail(String buttonRBDetail) {
			super.change(BUTTON_RB_DETAIL,super.getButtonRBDetail(),buttonRBDetail);
			super.setButtonRBDetail(buttonRBDetail);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public DbChangeApply clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public DbChangeApply duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setOrderId(this.getOrderId());
			inst.setItemCode(this.getItemCode());
			inst.setDbName(this.getDbName());
			inst.setDbFullName(this.getDbFullName());
			inst.setCheckResult(this.getCheckResult());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setContent(this.getContent());
			inst.setApplyUserId(this.getApplyUserId());
			inst.setItemName(this.getItemName());
			inst.setPushOrderStatus(this.getPushOrderStatus());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDbId(this.getDbId());
			inst.setDbUser(this.getDbUser());
			inst.setId(this.getId());
			inst.setPushResult(this.getPushResult());
			inst.setSqlArea(this.getSqlArea());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setDbIp(this.getDbIp());
			inst.setVersion(this.getVersion());
			inst.setDbPort(this.getDbPort());
			inst.setAssociatedSystem(this.getAssociatedSystem());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setCreateTime(this.getCreateTime());
			inst.setRbResult(this.getRbResult());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setButtonRBDetail(this.getButtonRBDetail());
				inst.setApplyUser(this.getApplyUser());
				inst.setDbInfoApply(this.getDbInfoApply());
				inst.setRequestOrder(this.getRequestOrder());
				inst.setButtonCheck(this.getButtonCheck());
				inst.setButtonCheckDetail(this.getButtonCheckDetail());
				inst.setButtonRB(this.getButtonRB());
			}
			inst.clearModifies();
			return inst;
		}

	}
}