package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.UserImport;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-18 19:13:37
 * @sign 84BE70F1845818A44944D2C8D95F5379
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class UserImportMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 导入批次 , 类型: java.lang.String
	*/
	public static final String ACTION_CODE="actionCode";
	
	/**
	 * 导入批次 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> ACTION_CODE_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,ACTION_CODE, java.lang.String.class, "导入批次", "导入批次", java.lang.String.class, null);
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final String ACTION_OPER_TIME="actionOperTime";
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.util.Date> ACTION_OPER_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,ACTION_OPER_TIME, java.util.Date.class, "操作时间", "操作时间", java.util.Date.class, null);
	
	/**
	 * 导入状态 , 类型: java.lang.String
	*/
	public static final String ACTION_STATUS="actionStatus";
	
	/**
	 * 导入状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> ACTION_STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,ACTION_STATUS, java.lang.String.class, "导入状态", "导入状态", java.lang.String.class, null);
	
	/**
	 * 导入结果 , 类型: java.lang.String
	*/
	public static final String ACTION_MSG="actionMsg";
	
	/**
	 * 导入结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> ACTION_MSG_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,ACTION_MSG, java.lang.String.class, "导入结果", "导入结果", java.lang.String.class, null);
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final String USER_NAME="userName";
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> USER_NAME_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,USER_NAME, java.lang.String.class, "姓名", "姓名", java.lang.String.class, null);
	
	/**
	 * 工号 , 类型: java.lang.String
	*/
	public static final String BADGE="badge";
	
	/**
	 * 工号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> BADGE_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,BADGE, java.lang.String.class, "工号", "工号", java.lang.String.class, null);
	
	/**
	 * 性别 , 类型: java.lang.String
	*/
	public static final String SEX="sex";
	
	/**
	 * 性别 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> SEX_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,SEX, java.lang.String.class, "性别", "性别", java.lang.String.class, null);
	
	/**
	 * 性别编码 , 类型: java.lang.String
	*/
	public static final String SEX_CODE="sexCode";
	
	/**
	 * 性别编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> SEX_CODE_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,SEX_CODE, java.lang.String.class, "性别编码", "性别编码", java.lang.String.class, null);
	
	/**
	 * 手机号 , 类型: java.lang.String
	*/
	public static final String PHONE="phone";
	
	/**
	 * 手机号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> PHONE_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,PHONE, java.lang.String.class, "手机号", "手机号", java.lang.String.class, null);
	
	/**
	 * 组织 , 类型: java.lang.String
	*/
	public static final String COMPANY_NAME="companyName";
	
	/**
	 * 组织 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> COMPANY_NAME_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,COMPANY_NAME, java.lang.String.class, "组织", "组织", java.lang.String.class, null);
	
	/**
	 * 组织ID , 类型: java.lang.String
	*/
	public static final String COMPANY_ID="companyId";
	
	/**
	 * 组织ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> COMPANY_ID_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,COMPANY_ID, java.lang.String.class, "组织ID", "组织ID", java.lang.String.class, null);
	
	/**
	 * 主岗 , 类型: java.lang.String
	*/
	public static final String MASTER_POST="masterPost";
	
	/**
	 * 主岗 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> MASTER_POST_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,MASTER_POST, java.lang.String.class, "主岗", "主岗", java.lang.String.class, null);
	
	/**
	 * 主岗ID , 类型: java.lang.String
	*/
	public static final String MASTER_POST_ID="masterPostId";
	
	/**
	 * 主岗ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> MASTER_POST_ID_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,MASTER_POST_ID, java.lang.String.class, "主岗ID", "主岗ID", java.lang.String.class, null);
	
	/**
	 * 身份证 , 类型: java.lang.String
	*/
	public static final String ID_CARD="idCard";
	
	/**
	 * 身份证 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> ID_CARD_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,ID_CARD, java.lang.String.class, "身份证", "身份证", java.lang.String.class, null);
	
	/**
	 * 状态 , 字典代码：employee_status , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 字典代码：employee_status , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,STATUS, java.lang.String.class, "状态", "字典代码：employee_status", java.lang.String.class, null);
	
	/**
	 * 状态编码 , 类型: java.lang.String
	*/
	public static final String STATUS_CODE="statusCode";
	
	/**
	 * 状态编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> STATUS_CODE_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,STATUS_CODE, java.lang.String.class, "状态编码", "状态编码", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImport,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.UserImport.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ACTION_CODE , ACTION_OPER_TIME , ACTION_STATUS , ACTION_MSG , USER_NAME , BADGE , SEX , SEX_CODE , PHONE , COMPANY_NAME , COMPANY_ID , MASTER_POST , MASTER_POST_ID , ID_CARD , STATUS , STATUS_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.UserImport {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public UserImport setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 导入批次
		 * @param actionCode 导入批次
		 * @return 当前对象
		*/
		public UserImport setActionCode(String actionCode) {
			super.change(ACTION_CODE,super.getActionCode(),actionCode);
			super.setActionCode(actionCode);
			return this;
		}
		
		/**
		 * 设置 操作时间
		 * @param actionOperTime 操作时间
		 * @return 当前对象
		*/
		public UserImport setActionOperTime(Date actionOperTime) {
			super.change(ACTION_OPER_TIME,super.getActionOperTime(),actionOperTime);
			super.setActionOperTime(actionOperTime);
			return this;
		}
		
		/**
		 * 设置 导入状态
		 * @param actionStatus 导入状态
		 * @return 当前对象
		*/
		public UserImport setActionStatus(String actionStatus) {
			super.change(ACTION_STATUS,super.getActionStatus(),actionStatus);
			super.setActionStatus(actionStatus);
			return this;
		}
		
		/**
		 * 设置 导入结果
		 * @param actionMsg 导入结果
		 * @return 当前对象
		*/
		public UserImport setActionMsg(String actionMsg) {
			super.change(ACTION_MSG,super.getActionMsg(),actionMsg);
			super.setActionMsg(actionMsg);
			return this;
		}
		
		/**
		 * 设置 姓名
		 * @param userName 姓名
		 * @return 当前对象
		*/
		public UserImport setUserName(String userName) {
			super.change(USER_NAME,super.getUserName(),userName);
			super.setUserName(userName);
			return this;
		}
		
		/**
		 * 设置 工号
		 * @param badge 工号
		 * @return 当前对象
		*/
		public UserImport setBadge(String badge) {
			super.change(BADGE,super.getBadge(),badge);
			super.setBadge(badge);
			return this;
		}
		
		/**
		 * 设置 性别
		 * @param sex 性别
		 * @return 当前对象
		*/
		public UserImport setSex(String sex) {
			super.change(SEX,super.getSex(),sex);
			super.setSex(sex);
			return this;
		}
		
		/**
		 * 设置 性别编码
		 * @param sexCode 性别编码
		 * @return 当前对象
		*/
		public UserImport setSexCode(String sexCode) {
			super.change(SEX_CODE,super.getSexCode(),sexCode);
			super.setSexCode(sexCode);
			return this;
		}
		
		/**
		 * 设置 手机号
		 * @param phone 手机号
		 * @return 当前对象
		*/
		public UserImport setPhone(String phone) {
			super.change(PHONE,super.getPhone(),phone);
			super.setPhone(phone);
			return this;
		}
		
		/**
		 * 设置 组织
		 * @param companyName 组织
		 * @return 当前对象
		*/
		public UserImport setCompanyName(String companyName) {
			super.change(COMPANY_NAME,super.getCompanyName(),companyName);
			super.setCompanyName(companyName);
			return this;
		}
		
		/**
		 * 设置 组织ID
		 * @param companyId 组织ID
		 * @return 当前对象
		*/
		public UserImport setCompanyId(String companyId) {
			super.change(COMPANY_ID,super.getCompanyId(),companyId);
			super.setCompanyId(companyId);
			return this;
		}
		
		/**
		 * 设置 主岗
		 * @param masterPost 主岗
		 * @return 当前对象
		*/
		public UserImport setMasterPost(String masterPost) {
			super.change(MASTER_POST,super.getMasterPost(),masterPost);
			super.setMasterPost(masterPost);
			return this;
		}
		
		/**
		 * 设置 主岗ID
		 * @param masterPostId 主岗ID
		 * @return 当前对象
		*/
		public UserImport setMasterPostId(String masterPostId) {
			super.change(MASTER_POST_ID,super.getMasterPostId(),masterPostId);
			super.setMasterPostId(masterPostId);
			return this;
		}
		
		/**
		 * 设置 身份证
		 * @param idCard 身份证
		 * @return 当前对象
		*/
		public UserImport setIdCard(String idCard) {
			super.change(ID_CARD,super.getIdCard(),idCard);
			super.setIdCard(idCard);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public UserImport setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 状态编码
		 * @param statusCode 状态编码
		 * @return 当前对象
		*/
		public UserImport setStatusCode(String statusCode) {
			super.change(STATUS_CODE,super.getStatusCode(),statusCode);
			super.setStatusCode(statusCode);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public UserImport setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public UserImport setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public UserImport setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public UserImport setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public UserImport setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public UserImport setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public UserImport setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public UserImport setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public UserImport clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public UserImport duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setIdCard(this.getIdCard());
			inst.setCompanyName(this.getCompanyName());
			inst.setMasterPost(this.getMasterPost());
			inst.setActionStatus(this.getActionStatus());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setActionCode(this.getActionCode());
			inst.setId(this.getId());
			inst.setMasterPostId(this.getMasterPostId());
			inst.setSex(this.getSex());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setUserName(this.getUserName());
			inst.setVersion(this.getVersion());
			inst.setActionOperTime(this.getActionOperTime());
			inst.setBadge(this.getBadge());
			inst.setSexCode(this.getSexCode());
			inst.setCompanyId(this.getCompanyId());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setPhone(this.getPhone());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setActionMsg(this.getActionMsg());
			inst.setStatus(this.getStatus());
			inst.setStatusCode(this.getStatusCode());
			inst.clearModifies();
			return inst;
		}

	}
}