package com.dt.platform.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2023-10-02 12:22:39
 * @author 金杰 , maillank@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class OaTables {
	
	/**
	 * 横幅
	*/
	public static class OA_BANNER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_banner";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","图片","图片",false,false,true);
		
		/**
		 * 地址
		*/
		public static final DBField URL = new DBField(DBDataType.STRING , "url","url","地址","地址",false,false,true);
		
		/**
		 * 顺序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","顺序","顺序",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_BANNER() {
			this.init($NAME,"横幅" , ID , NAME , STATUS , PICTURE_ID , URL , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OA_BANNER $TABLE=new OA_BANNER();
	}
	
	/**
	 * 客户
	*/
	public static class OA_CRM_CUSTOMER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_crm_customer";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 客户编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","客户编码","客户编码",false,false,true);
		
		/**
		 * 客户名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","客户名称","客户名称",false,false,true);
		
		/**
		 * 客户等级
		*/
		public static final DBField LEVEL = new DBField(DBDataType.STRING , "level","level","客户等级","客户等级",false,false,true);
		
		/**
		 * 负责人
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","负责人","负责人",false,false,true);
		
		/**
		 * 意向状态
		*/
		public static final DBField INTENTIONAL_STATE = new DBField(DBDataType.STRING , "intentional_state","intentionalState","意向状态","意向状态",false,false,true);
		
		/**
		 * 联系人
		*/
		public static final DBField CONTACTS = new DBField(DBDataType.STRING , "contacts","contacts","联系人","联系人",false,false,true);
		
		/**
		 * 联系方式
		*/
		public static final DBField CONTACT_INFO = new DBField(DBDataType.STRING , "contact_info","contactInfo","联系方式","联系方式",false,false,true);
		
		/**
		 * 网址
		*/
		public static final DBField WEBSITE = new DBField(DBDataType.STRING , "website","website","网址","网址",false,false,true);
		
		/**
		 * 所在行业
		*/
		public static final DBField INDUSTRY_ID = new DBField(DBDataType.STRING , "industry_id","industryId","所在行业","所在行业",false,false,true);
		
		/**
		 * 客户介绍
		*/
		public static final DBField PROFILE = new DBField(DBDataType.STRING , "profile","profile","客户介绍","客户介绍",false,false,true);
		
		/**
		 * 客户来源
		*/
		public static final DBField SOURCE_ID = new DBField(DBDataType.STRING , "source_id","sourceId","客户来源","客户来源",false,false,true);
		
		/**
		 * 客户地址
		*/
		public static final DBField ADDRESS = new DBField(DBDataType.STRING , "address","address","客户地址","客户地址",false,false,true);
		
		/**
		 * 最近跟进
		*/
		public static final DBField RECENT_FOLLOW_TIME = new DBField(DBDataType.DATE , "recent_follow_time","recentFollowTime","最近跟进","最近跟进",false,false,true);
		
		/**
		 * 下次跟进
		*/
		public static final DBField NEXT_FOLLOW_TIME = new DBField(DBDataType.DATE , "next_follow_time","nextFollowTime","下次跟进","下次跟进",false,false,true);
		
		/**
		 * 成交状态
		*/
		public static final DBField TRANSACTION_STATUS = new DBField(DBDataType.STRING , "transaction_status","transactionStatus","成交状态","成交状态",false,false,true);
		
		/**
		 * 是否锁定,lcoked|unlock
		*/
		public static final DBField LOCKED = new DBField(DBDataType.STRING , "locked","locked","是否锁定","lcoked|unlock",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 客户位置
		*/
		public static final DBField ROLE_POS = new DBField(DBDataType.STRING , "role_pos","rolePos","客户位置","客户位置",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_CRM_CUSTOMER() {
			this.init($NAME,"客户" , ID , CODE , NAME , LEVEL , OWNER_ID , INTENTIONAL_STATE , CONTACTS , CONTACT_INFO , WEBSITE , INDUSTRY_ID , PROFILE , SOURCE_ID , ADDRESS , RECENT_FOLLOW_TIME , NEXT_FOLLOW_TIME , TRANSACTION_STATUS , LOCKED , NOTES , ROLE_POS , ORIGINATOR_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_CRM_CUSTOMER $TABLE=new OA_CRM_CUSTOMER();
	}
	
	/**
	 * 商机
	*/
	public static class OA_CRM_CUSTOMER_BUSINESS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_crm_customer_business";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 客户
		*/
		public static final DBField CUSTOMER_ID = new DBField(DBDataType.STRING , "customer_id","customerId","客户","客户",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 价格
		*/
		public static final DBField AMOUNT = new DBField(DBDataType.DECIMAL , "amount","amount","价格","价格",false,false,true);
		
		/**
		 * 商机阶段
		*/
		public static final DBField STAGE = new DBField(DBDataType.STRING , "stage","stage","商机阶段","商机阶段",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 操作人员
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","操作人员","操作人员",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_CRM_CUSTOMER_BUSINESS() {
			this.init($NAME,"商机" , ID , CUSTOMER_ID , CONTENT , AMOUNT , STAGE , FILE_ID , NOTES , VERSION , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_CRM_CUSTOMER_BUSINESS $TABLE=new OA_CRM_CUSTOMER_BUSINESS();
	}
	
	/**
	 * 我的关注
	*/
	public static class OA_CRM_CUSTOMER_CARE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_crm_customer_care";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 客户
		*/
		public static final DBField CUSTOMER_ID = new DBField(DBDataType.STRING , "customer_id","customerId","客户","客户",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","用户","用户",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		public OA_CRM_CUSTOMER_CARE() {
			this.init($NAME,"我的关注" , ID , CUSTOMER_ID , USER_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME);
		}
		public static final OA_CRM_CUSTOMER_CARE $TABLE=new OA_CRM_CUSTOMER_CARE();
	}
	
	/**
	 * 联系人
	*/
	public static class OA_CRM_CUSTOMER_CONTACT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_crm_customer_contact";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 客户
		*/
		public static final DBField CUSTOMER_ID = new DBField(DBDataType.STRING , "customer_id","customerId","客户","客户",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","姓名","姓名",false,false,true);
		
		/**
		 * 手机
		*/
		public static final DBField MOBILE = new DBField(DBDataType.STRING , "mobile","mobile","手机","手机",false,false,true);
		
		/**
		 * 邮箱
		*/
		public static final DBField MAIL = new DBField(DBDataType.STRING , "mail","mail","邮箱","邮箱",false,false,true);
		
		/**
		 * 微信
		*/
		public static final DBField WEXIN = new DBField(DBDataType.STRING , "wexin","wexin","微信","微信",false,false,true);
		
		/**
		 * 职位
		*/
		public static final DBField JOB = new DBField(DBDataType.STRING , "job","job","职位","职位",false,false,true);
		
		/**
		 * 性别
		*/
		public static final DBField SEX = new DBField(DBDataType.STRING , "sex","sex","性别","性别",false,false,true);
		
		/**
		 * 地址
		*/
		public static final DBField ADDRESS = new DBField(DBDataType.STRING , "address","address","地址","地址",false,false,true);
		
		/**
		 * 角色
		*/
		public static final DBField ROLE = new DBField(DBDataType.STRING , "role","role","角色","角色",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 操作人员
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","操作人员","操作人员",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_CRM_CUSTOMER_CONTACT() {
			this.init($NAME,"联系人" , ID , CUSTOMER_ID , NAME , MOBILE , MAIL , WEXIN , JOB , SEX , ADDRESS , ROLE , NOTES , ORIGINATOR_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_CRM_CUSTOMER_CONTACT $TABLE=new OA_CRM_CUSTOMER_CONTACT();
	}
	
	/**
	 * 跟进记录
	*/
	public static class OA_CRM_CUSTOMER_FOLLOW extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_crm_customer_follow";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 客户
		*/
		public static final DBField CUSTOMER_ID = new DBField(DBDataType.STRING , "customer_id","customerId","客户","客户",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 记录时间
		*/
		public static final DBField REC_TIME = new DBField(DBDataType.DATE , "rec_time","recTime","记录时间","记录时间",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 操作人员
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","操作人员","操作人员",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_CRM_CUSTOMER_FOLLOW() {
			this.init($NAME,"跟进记录" , ID , CUSTOMER_ID , CONTENT , REC_TIME , NOTES , FILE_ID , ORIGINATOR_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_CRM_CUSTOMER_FOLLOW $TABLE=new OA_CRM_CUSTOMER_FOLLOW();
	}
	
	/**
	 * 客户行业
	*/
	public static class OA_CRM_CUSTOMER_INDUSTRY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_crm_customer_industry";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_CRM_CUSTOMER_INDUSTRY() {
			this.init($NAME,"客户行业" , ID , NAME , NOTES , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_CRM_CUSTOMER_INDUSTRY $TABLE=new OA_CRM_CUSTOMER_INDUSTRY();
	}
	
	/**
	 * 客户意向
	*/
	public static class OA_CRM_CUSTOMER_INTENTIONAL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_crm_customer_intentional";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_CRM_CUSTOMER_INTENTIONAL() {
			this.init($NAME,"客户意向" , ID , NAME , NOTES , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_CRM_CUSTOMER_INTENTIONAL $TABLE=new OA_CRM_CUSTOMER_INTENTIONAL();
	}
	
	/**
	 * 共享成员
	*/
	public static class OA_CRM_CUSTOMER_LEADER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_crm_customer_leader";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 客户
		*/
		public static final DBField CUSTOMER_IDS = new DBField(DBDataType.STRING , "customer_ids","customerIds","客户","客户",false,false,true);
		
		/**
		 * 负责人
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","负责人","负责人",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_CRM_CUSTOMER_LEADER() {
			this.init($NAME,"共享成员" , ID , CUSTOMER_IDS , USER_ID , NOTES , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_CRM_CUSTOMER_LEADER $TABLE=new OA_CRM_CUSTOMER_LEADER();
	}
	
	/**
	 * 线索
	*/
	public static class OA_CRM_CUSTOMER_LEADS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_crm_customer_leads";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 客户名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","客户名称","客户名称",false,false,true);
		
		/**
		 * 客户等级
		*/
		public static final DBField LEVEL = new DBField(DBDataType.STRING , "level","level","客户等级","客户等级",false,false,true);
		
		/**
		 * 负责人
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","负责人","负责人",false,false,true);
		
		/**
		 * 意向状态
		*/
		public static final DBField INTENTIONAL_STATE = new DBField(DBDataType.STRING , "intentional_state","intentionalState","意向状态","意向状态",false,false,true);
		
		/**
		 * 客户来源
		*/
		public static final DBField SOURCE_ID = new DBField(DBDataType.STRING , "source_id","sourceId","客户来源","客户来源",false,false,true);
		
		/**
		 * 联系人
		*/
		public static final DBField CONTACTS = new DBField(DBDataType.STRING , "contacts","contacts","联系人","联系人",false,false,true);
		
		/**
		 * 联系方式
		*/
		public static final DBField CONTACT_INFO = new DBField(DBDataType.STRING , "contact_info","contactInfo","联系方式","联系方式",false,false,true);
		
		/**
		 * 所在行业
		*/
		public static final DBField INDUSTRY_ID = new DBField(DBDataType.STRING , "industry_id","industryId","所在行业","所在行业",false,false,true);
		
		/**
		 * 网址
		*/
		public static final DBField WEBSITE = new DBField(DBDataType.STRING , "website","website","网址","网址",false,false,true);
		
		/**
		 * 最近跟进
		*/
		public static final DBField RECENT_FOLLOW_TIME = new DBField(DBDataType.DATE , "recent_follow_time","recentFollowTime","最近跟进","最近跟进",false,false,true);
		
		/**
		 * 下次跟进
		*/
		public static final DBField NEXT_FOLLOW_TIME = new DBField(DBDataType.DATE , "next_follow_time","nextFollowTime","下次跟进","下次跟进",false,false,true);
		
		/**
		 * 客户地址
		*/
		public static final DBField ADDRESS = new DBField(DBDataType.STRING , "address","address","客户地址","客户地址",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_CRM_CUSTOMER_LEADS() {
			this.init($NAME,"线索" , ID , NAME , LEVEL , OWNER_ID , INTENTIONAL_STATE , SOURCE_ID , CONTACTS , CONTACT_INFO , INDUSTRY_ID , WEBSITE , RECENT_FOLLOW_TIME , NEXT_FOLLOW_TIME , ADDRESS , ORIGINATOR_ID , NOTES , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_CRM_CUSTOMER_LEADS $TABLE=new OA_CRM_CUSTOMER_LEADS();
	}
	
	/**
	 * 客户等级
	*/
	public static class OA_CRM_CUSTOMER_LEVEL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_crm_customer_level";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_CRM_CUSTOMER_LEVEL() {
			this.init($NAME,"客户等级" , ID , NAME , NOTES , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_CRM_CUSTOMER_LEVEL $TABLE=new OA_CRM_CUSTOMER_LEVEL();
	}
	
	/**
	 * 历史记录
	*/
	public static class OA_CRM_CUSTOMER_RECORD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_crm_customer_record";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 客户
		*/
		public static final DBField CUSTOMER_ID = new DBField(DBDataType.STRING , "customer_id","customerId","客户","客户",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 记录时间
		*/
		public static final DBField RCD_TIME = new DBField(DBDataType.DATE , "rcd_time","rcdTime","记录时间","记录时间",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 操作人员
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","操作人员","操作人员",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		public OA_CRM_CUSTOMER_RECORD() {
			this.init($NAME,"历史记录" , ID , CUSTOMER_ID , CONTENT , RCD_TIME , NOTES , ORIGINATOR_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME);
		}
		public static final OA_CRM_CUSTOMER_RECORD $TABLE=new OA_CRM_CUSTOMER_RECORD();
	}
	
	/**
	 * 回访
	*/
	public static class OA_CRM_CUSTOMER_REVIEW extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_crm_customer_review";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 客户
		*/
		public static final DBField CUSTOMER_ID = new DBField(DBDataType.STRING , "customer_id","customerId","客户","客户",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 回访人
		*/
		public static final DBField REVIEW_USER_ID = new DBField(DBDataType.STRING , "review_user_id","reviewUserId","回访人","回访人",false,false,true);
		
		/**
		 * 回访时间
		*/
		public static final DBField REVIEW_DATE = new DBField(DBDataType.DATE , "review_date","reviewDate","回访时间","回访时间",false,false,true);
		
		/**
		 * 回访形式
		*/
		public static final DBField METHOD_ID = new DBField(DBDataType.STRING , "method_id","methodId","回访形式","回访形式",false,false,true);
		
		/**
		 * 客户满意度
		*/
		public static final DBField SATISFACTION_ID = new DBField(DBDataType.STRING , "satisfaction_id","satisfactionId","客户满意度","客户满意度",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 操作人员
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","操作人员","操作人员",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_CRM_CUSTOMER_REVIEW() {
			this.init($NAME,"回访" , ID , CUSTOMER_ID , NAME , REVIEW_USER_ID , REVIEW_DATE , METHOD_ID , SATISFACTION_ID , FILE_ID , NOTES , ORIGINATOR_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_CRM_CUSTOMER_REVIEW $TABLE=new OA_CRM_CUSTOMER_REVIEW();
	}
	
	/**
	 * 客户来源
	*/
	public static class OA_CRM_CUSTOMER_SOURCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_crm_customer_source";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_CRM_CUSTOMER_SOURCE() {
			this.init($NAME,"客户来源" , ID , NAME , NOTES , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_CRM_CUSTOMER_SOURCE $TABLE=new OA_CRM_CUSTOMER_SOURCE();
	}
	
	/**
	 * 团队成员
	*/
	public static class OA_CRM_CUSTOMER_TEAM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_crm_customer_team";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 客户
		*/
		public static final DBField CUSTOMER_ID = new DBField(DBDataType.STRING , "customer_id","customerId","客户","客户",false,false,true);
		
		/**
		 * 成员
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","成员","成员",false,false,true);
		
		/**
		 * 团队角色
		*/
		public static final DBField USER_ROLE = new DBField(DBDataType.STRING , "user_role","userRole","团队角色","团队角色",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_CRM_CUSTOMER_TEAM() {
			this.init($NAME,"团队成员" , ID , CUSTOMER_ID , USER_ID , USER_ROLE , NOTES , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_CRM_CUSTOMER_TEAM $TABLE=new OA_CRM_CUSTOMER_TEAM();
	}
	
	/**
	 * 常用下载
	*/
	public static class OA_DOWNLOAD_FILE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_download_file";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 文件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","文件","文件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 下载次数
		*/
		public static final DBField DOWNLOAD_COUNT = new DBField(DBDataType.INTEGER , "download_count","downloadCount","下载次数","下载次数",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_DOWNLOAD_FILE() {
			this.init($NAME,"常用下载" , ID , NAME , STATUS , FILE_ID , NOTES , DOWNLOAD_COUNT , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OA_DOWNLOAD_FILE $TABLE=new OA_DOWNLOAD_FILE();
	}
	
	/**
	 * 下载日志
	*/
	public static class OA_DOWNLOAD_LOG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_download_log";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 文件
		*/
		public static final DBField REC_ID = new DBField(DBDataType.STRING , "rec_id","recId","文件","文件",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","用户","用户",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public OA_DOWNLOAD_LOG() {
			this.init($NAME,"下载日志" , ID , REC_ID , USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OA_DOWNLOAD_LOG $TABLE=new OA_DOWNLOAD_LOG();
	}
	
	/**
	 * 会议室
	*/
	public static class OA_MEETING_ROOM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_meeting_room";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 容纳人数
		*/
		public static final DBField PERSON_NUMBER = new DBField(DBDataType.INTEGER , "person_number","personNumber","容纳人数","容纳人数",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 位置
		*/
		public static final DBField POSITION_ID = new DBField(DBDataType.STRING , "position_id","positionId","位置","位置",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_MEETING_ROOM() {
			this.init($NAME,"会议室" , ID , NAME , PERSON_NUMBER , STATUS , POSITION_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OA_MEETING_ROOM $TABLE=new OA_MEETING_ROOM();
	}
	
	/**
	 * 会议室预定
	*/
	public static class OA_MEETING_ROOM_BOOK_RCD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_meeting_room_book_rcd";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 用途
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","用途","用途",false,false,true);
		
		/**
		 * 会议室
		*/
		public static final DBField ROOM_ID = new DBField(DBDataType.STRING , "room_id","roomId","会议室","会议室",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 预定部门
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","预定部门","预定部门",false,false,true);
		
		/**
		 * 预定人
		*/
		public static final DBField BOOKER_ID = new DBField(DBDataType.STRING , "booker_id","bookerId","预定人","预定人",false,false,true);
		
		/**
		 * 联系方式
		*/
		public static final DBField CONTACT_INFORMATION = new DBField(DBDataType.STRING , "contact_information","contactInformation","联系方式","联系方式",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField START_TIME = new DBField(DBDataType.DATE , "start_time","startTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField END_TIME = new DBField(DBDataType.DATE , "end_time","endTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 发起人
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","发起人","发起人",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_MEETING_ROOM_BOOK_RCD() {
			this.init($NAME,"会议室预定" , ID , NAME , ROOM_ID , STATUS , ORG_ID , BOOKER_ID , CONTACT_INFORMATION , START_TIME , END_TIME , NOTES , USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OA_MEETING_ROOM_BOOK_RCD $TABLE=new OA_MEETING_ROOM_BOOK_RCD();
	}
	
	/**
	 * 会议室位置
	*/
	public static class OA_MEETING_ROOM_POSITION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_meeting_room_position";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.DECIMAL , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_MEETING_ROOM_POSITION() {
			this.init($NAME,"会议室位置" , ID , NAME , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OA_MEETING_ROOM_POSITION $TABLE=new OA_MEETING_ROOM_POSITION();
	}
	
	/**
	 * 文件
	*/
	public static class OA_NETDISK_FILE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_netdisk_file";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 文件
		*/
		public static final DBField ORIGIN_FILE_ID = new DBField(DBDataType.STRING , "origin_file_id","originFileId","文件","文件",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField FILE_NAME = new DBField(DBDataType.STRING , "file_name","fileName","名称","名称",false,false,true);
		
		/**
		 * 大小
		*/
		public static final DBField FILE_SIZE = new DBField(DBDataType.STRING , "file_size","fileSize","大小","大小",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField FILE_TYPE = new DBField(DBDataType.STRING , "file_type","fileType","类型","类型",false,false,true);
		
		/**
		 * 是否收藏
		*/
		public static final DBField IS_FAVOURITE = new DBField(DBDataType.STRING , "is_favourite","isFavourite","是否收藏","是否收藏",false,false,true);
		
		/**
		 * 回收站
		*/
		public static final DBField IN_RECYCLE = new DBField(DBDataType.STRING , "in_recycle","inRecycle","回收站","回收站",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","用户","用户",false,false,true);
		
		/**
		 * 文件夹
		*/
		public static final DBField FOLDER_ID = new DBField(DBDataType.STRING , "folder_id","folderId","文件夹","文件夹",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		public OA_NETDISK_FILE() {
			this.init($NAME,"文件" , ID , ORIGIN_FILE_ID , FILE_NAME , FILE_SIZE , FILE_TYPE , IS_FAVOURITE , IN_RECYCLE , USER_ID , FOLDER_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME);
		}
		public static final OA_NETDISK_FILE $TABLE=new OA_NETDISK_FILE();
	}
	
	/**
	 * 文件夹
	*/
	public static class OA_NETDISK_FOLDER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_netdisk_folder";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","用户","用户",false,false,true);
		
		/**
		 * 是否收藏
		*/
		public static final DBField IS_FAVOURITE = new DBField(DBDataType.STRING , "is_favourite","isFavourite","是否收藏","是否收藏",false,false,true);
		
		/**
		 * 回收站
		*/
		public static final DBField IN_RECYCLE = new DBField(DBDataType.STRING , "in_recycle","inRecycle","回收站","回收站",false,false,true);
		
		/**
		 * 父级
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","父级","父级",false,false,true);
		
		/**
		 * 文件路径
		*/
		public static final DBField HIERARCHY = new DBField(DBDataType.STRING , "hierarchy","hierarchy","文件路径","文件路径",false,false,true);
		
		/**
		 * 路径全名
		*/
		public static final DBField HIERARCHY_NAME = new DBField(DBDataType.STRING , "hierarchy_name","hierarchyName","路径全名","路径全名",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_NETDISK_FOLDER() {
			this.init($NAME,"文件夹" , ID , NAME , USER_ID , IS_FAVOURITE , IN_RECYCLE , PARENT_ID , HIERARCHY , HIERARCHY_NAME , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_NETDISK_FOLDER $TABLE=new OA_NETDISK_FOLDER();
	}
	
	/**
	 * 文件菜单
	*/
	public static class OA_NETDISK_MENU extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_netdisk_menu";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 图标
		*/
		public static final DBField ICON_CODE = new DBField(DBDataType.STRING , "icon_code","iconCode","图标","图标",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 是否显示,Y|N
		*/
		public static final DBField SHOW_VALUE = new DBField(DBDataType.STRING , "show_value","showValue","是否显示","Y|N",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT_VALUE = new DBField(DBDataType.INTEGER , "sort_value","sortValue","排序","排序",false,false,true);
		
		/**
		 * 上一级
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","上一级","上一级",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_NETDISK_MENU() {
			this.init($NAME,"文件菜单" , ID , CODE , NAME , ICON_CODE , TYPE , SHOW_VALUE , SORT_VALUE , PARENT_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_NETDISK_MENU $TABLE=new OA_NETDISK_MENU();
	}
	
	/**
	 * 我的收藏(未使用)
	*/
	public static class OA_NETDISK_MY_FAVORITE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_netdisk_my_favorite";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 用户
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","用户","用户",false,false,true);
		
		/**
		 * 文件
		*/
		public static final DBField FD_ID = new DBField(DBDataType.STRING , "fd_id","fdId","文件","文件",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField FD_TYPE = new DBField(DBDataType.STRING , "fd_type","fdType","类型","类型",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_NETDISK_MY_FAVORITE() {
			this.init($NAME,"我的收藏(未使用)" , ID , USER_ID , FD_ID , FD_TYPE , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_NETDISK_MY_FAVORITE $TABLE=new OA_NETDISK_MY_FAVORITE();
	}
	
	/**
	 * 我的分享
	*/
	public static class OA_NETDISK_MY_SHARE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_netdisk_my_share";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 用户
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","用户","用户",false,false,true);
		
		/**
		 * 文件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","文件","文件",false,false,true);
		
		/**
		 * 链接
		*/
		public static final DBField FILE_URL = new DBField(DBDataType.STRING , "file_url","fileUrl","链接","链接",false,false,true);
		
		/**
		 * 文件
		*/
		public static final DBField FD_ID = new DBField(DBDataType.STRING , "fd_id","fdId","文件","文件",false,false,true);
		
		/**
		 * 文件类型
		*/
		public static final DBField FD_TYPE = new DBField(DBDataType.STRING , "fd_type","fdType","文件类型","文件类型",false,false,true);
		
		/**
		 * 过期时间
		*/
		public static final DBField EXPIRATION_TIME = new DBField(DBDataType.DATE , "expiration_time","expirationTime","过期时间","过期时间",false,false,true);
		
		/**
		 * 过期方式
		*/
		public static final DBField EXPIRATION_METHOD = new DBField(DBDataType.STRING , "expiration_method","expirationMethod","过期方式","过期方式",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 状态,valid|expired|delete
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","valid|expired|delete",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_NETDISK_MY_SHARE() {
			this.init($NAME,"我的分享" , ID , USER_ID , FILE_ID , FILE_URL , FD_ID , FD_TYPE , EXPIRATION_TIME , EXPIRATION_METHOD , TYPE , STATUS , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_NETDISK_MY_SHARE $TABLE=new OA_NETDISK_MY_SHARE();
	}
	
	/**
	 * 操作记录
	*/
	public static class OA_NETDISK_OPER_RECORD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_netdisk_oper_record";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 对象
		*/
		public static final DBField FD_ID = new DBField(DBDataType.STRING , "fd_id","fdId","对象","对象",false,false,true);
		
		/**
		 * 对象类型
		*/
		public static final DBField FD_TYPE = new DBField(DBDataType.STRING , "fd_type","fdType","对象类型","对象类型",false,false,true);
		
		/**
		 * 操作内容
		*/
		public static final DBField OPER_CONTENT = new DBField(DBDataType.STRING , "oper_content","operContent","操作内容","操作内容",false,false,true);
		
		/**
		 * 操作人
		*/
		public static final DBField OPER_USER_ID = new DBField(DBDataType.STRING , "oper_user_id","operUserId","操作人","操作人",false,false,true);
		
		/**
		 * 操作时间
		*/
		public static final DBField OPER_TIME = new DBField(DBDataType.DATE , "oper_time","operTime","操作时间","操作时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_NETDISK_OPER_RECORD() {
			this.init($NAME,"操作记录" , ID , FD_ID , FD_TYPE , OPER_CONTENT , OPER_USER_ID , OPER_TIME , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_NETDISK_OPER_RECORD $TABLE=new OA_NETDISK_OPER_RECORD();
	}
	
	/**
	 * 源文件
	*/
	public static class OA_NETDISK_ORIGIN_FILE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_netdisk_origin_file";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 文件名称
		*/
		public static final DBField FILE_NAME = new DBField(DBDataType.STRING , "file_name","fileName","文件名称","文件名称",false,false,true);
		
		/**
		 * 大小
		*/
		public static final DBField FILE_SIZE = new DBField(DBDataType.LONG , "file_size","fileSize","大小","大小",false,false,true);
		
		/**
		 * 路径
		*/
		public static final DBField LOCATION = new DBField(DBDataType.STRING , "location","location","路径","路径",false,false,true);
		
		/**
		 * 媒体类型
		*/
		public static final DBField MEDIA_TYPE = new DBField(DBDataType.STRING , "media_type","mediaType","媒体类型","媒体类型",false,false,true);
		
		/**
		 * 文件类型
		*/
		public static final DBField FILE_TYPE = new DBField(DBDataType.STRING , "file_type","fileType","文件类型","文件类型",false,false,true);
		
		/**
		 * 扩展类型,jpg,png
		*/
		public static final DBField EXT_VALUE = new DBField(DBDataType.STRING , "ext_value","extValue","扩展类型","jpg,png",false,false,true);
		
		/**
		 * 存储类型
		*/
		public static final DBField STORAGE_TYPE = new DBField(DBDataType.STRING , "storage_type","storageType","存储类型","存储类型",false,false,true);
		
		/**
		 * 是否加密,Y|N
		*/
		public static final DBField ENCRYPTED = new DBField(DBDataType.STRING , "encrypted","encrypted","是否加密","Y|N",false,false,true);
		
		/**
		 * 所属用户
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","所属用户","所属用户",false,false,true);
		
		/**
		 * 存储地址
		*/
		public static final DBField STORAGE_STORE_ID = new DBField(DBDataType.STRING , "storage_store_id","storageStoreId","存储地址","存储地址",false,false,true);
		
		/**
		 * 下载地址
		*/
		public static final DBField DOWNLOAD_URL = new DBField(DBDataType.STRING , "download_url","downloadUrl","下载地址","下载地址",false,false,true);
		
		/**
		 * 下载次数
		*/
		public static final DBField DOWNLOAD_COUNT = new DBField(DBDataType.LONG , "download_count","downloadCount","下载次数","下载次数",false,false,true);
		
		/**
		 * 引用次数
		*/
		public static final DBField REFERENCE_COUNT = new DBField(DBDataType.INTEGER , "reference_count","referenceCount","引用次数","引用次数",false,false,true);
		
		/**
		 * 上次访问时间
		*/
		public static final DBField LAST_VISIT_TIME = new DBField(DBDataType.DATE , "last_visit_time","lastVisitTime","上次访问时间","上次访问时间",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * MD5
		*/
		public static final DBField MD5_VALUE = new DBField(DBDataType.STRING , "md5_value","md5Value","MD5","MD5",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_NETDISK_ORIGIN_FILE() {
			this.init($NAME,"源文件" , ID , FILE_NAME , FILE_SIZE , LOCATION , MEDIA_TYPE , FILE_TYPE , EXT_VALUE , STORAGE_TYPE , ENCRYPTED , USER_ID , STORAGE_STORE_ID , DOWNLOAD_URL , DOWNLOAD_COUNT , REFERENCE_COUNT , LAST_VISIT_TIME , NOTES , MD5_VALUE , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_NETDISK_ORIGIN_FILE $TABLE=new OA_NETDISK_ORIGIN_FILE();
	}
	
	/**
	 * 回收站
	*/
	public static class OA_NETDISK_RECYCLE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_netdisk_recycle";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * FD
		*/
		public static final DBField FD_ID = new DBField(DBDataType.STRING , "fd_id","fdId","FD","FD",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField FD_TYPE = new DBField(DBDataType.STRING , "fd_type","fdType","类型","类型",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DEL_TIME = new DBField(DBDataType.DATE , "del_time","delTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","用户","用户",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_NETDISK_RECYCLE() {
			this.init($NAME,"回收站" , ID , FD_ID , FD_TYPE , DEL_TIME , USER_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_NETDISK_RECYCLE $TABLE=new OA_NETDISK_RECYCLE();
	}
	
	/**
	 * 资源限制
	*/
	public static class OA_NETDISK_RESOURCE_LIMIT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_netdisk_resource_limit";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 用户
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","用户","用户",false,false,true);
		
		/**
		 * 最大容量（M）
		*/
		public static final DBField CAPACITY_SIZE_M = new DBField(DBDataType.LONG , "capacity_size_m","capacitySizeM","最大容量","M）",false,false,true);
		
		/**
		 * 当前容量（B）
		*/
		public static final DBField CURRENT_SIZE_B = new DBField(DBDataType.LONG , "current_size_b","currentSizeB","当前容量","B）",false,false,true);
		
		/**
		 * 上传大小（M）
		*/
		public static final DBField UPLOAD_MAX_SIZE_M = new DBField(DBDataType.LONG , "upload_max_size_m","uploadMaxSizeM","上传大小","M）",false,false,true);
		
		/**
		 * 文件类型
		*/
		public static final DBField UPLOAD_FILE_TYPE = new DBField(DBDataType.STRING , "upload_file_type","uploadFileType","文件类型","文件类型",false,false,true);
		
		/**
		 * 视频播放
		*/
		public static final DBField PLAY_VIDEO_VALID = new DBField(DBDataType.STRING , "play_video_valid","playVideoValid","视频播放","视频播放",false,false,true);
		
		/**
		 * 音频播放
		*/
		public static final DBField PLAY_MUSIC_VALID = new DBField(DBDataType.STRING , "play_music_valid","playMusicValid","音频播放","音频播放",false,false,true);
		
		/**
		 * 图片预览
		*/
		public static final DBField VIEW_PHOTO_VALID = new DBField(DBDataType.STRING , "view_photo_valid","viewPhotoValid","图片预览","图片预览",false,false,true);
		
		/**
		 * 文档预览
		*/
		public static final DBField VIEW_DOC_VALID = new DBField(DBDataType.STRING , "view_doc_valid","viewDocValid","文档预览","文档预览",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_NETDISK_RESOURCE_LIMIT() {
			this.init($NAME,"资源限制" , ID , USER_ID , CAPACITY_SIZE_M , CURRENT_SIZE_B , UPLOAD_MAX_SIZE_M , UPLOAD_FILE_TYPE , PLAY_VIDEO_VALID , PLAY_MUSIC_VALID , VIEW_PHOTO_VALID , VIEW_DOC_VALID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_NETDISK_RESOURCE_LIMIT $TABLE=new OA_NETDISK_RESOURCE_LIMIT();
	}
	
	/**
	 * 分享给我
	*/
	public static class OA_NETDISK_SHARE_ME extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_netdisk_share_me";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 文件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","文件","文件",false,false,true);
		
		/**
		 * 文件
		*/
		public static final DBField FD_ID = new DBField(DBDataType.STRING , "fd_id","fdId","文件","文件",false,false,true);
		
		/**
		 * 文件类型
		*/
		public static final DBField FD_TYPE = new DBField(DBDataType.STRING , "fd_type","fdType","文件类型","文件类型",false,false,true);
		
		/**
		 * 分享
		*/
		public static final DBField SHARE_ID = new DBField(DBDataType.STRING , "share_id","shareId","分享","分享",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","用户","用户",false,false,true);
		
		/**
		 * 所属
		*/
		public static final DBField OWNER_USER_ID = new DBField(DBDataType.STRING , "owner_user_id","ownerUserId","所属","所属",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_NETDISK_SHARE_ME() {
			this.init($NAME,"分享给我" , ID , FILE_ID , FD_ID , FD_TYPE , SHARE_ID , USER_ID , OWNER_USER_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_NETDISK_SHARE_ME $TABLE=new OA_NETDISK_SHARE_ME();
	}
	
	/**
	 * 存储方式
	*/
	public static class OA_NETDISK_STORAGE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_netdisk_storage";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态,valid|invalid
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","valid|invalid",false,false,true);
		
		/**
		 * 是否加密,Y|N
		*/
		public static final DBField ENCRYPTED = new DBField(DBDataType.STRING , "encrypted","encrypted","是否加密","Y|N",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_NETDISK_STORAGE() {
			this.init($NAME,"存储方式" , ID , CODE , NAME , STATUS , ENCRYPTED , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_NETDISK_STORAGE $TABLE=new OA_NETDISK_STORAGE();
	}
	
	/**
	 * 虚拟文件
	*/
	public static class OA_NETDISK_VIRTUAL_FD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_netdisk_virtual_fd";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 文件
		*/
		public static final DBField FD_ID = new DBField(DBDataType.STRING , "fd_id","fdId","文件","文件",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField FD_NAME = new DBField(DBDataType.STRING , "fd_name","fdName","名称","名称",false,false,true);
		
		/**
		 * 大小
		*/
		public static final DBField FD_SIZE = new DBField(DBDataType.STRING , "fd_size","fdSize","大小","大小",false,false,true);
		
		/**
		 * 文件类型
		*/
		public static final DBField FD_FILE_TYPE = new DBField(DBDataType.STRING , "fd_file_type","fdFileType","文件类型","文件类型",false,false,true);
		
		/**
		 * 路径编号
		*/
		public static final DBField FD_HIERARCHY = new DBField(DBDataType.STRING , "fd_hierarchy","fdHierarchy","路径编号","路径编号",false,false,true);
		
		/**
		 * 路径名称
		*/
		public static final DBField FD_HIERARCHY_NAME = new DBField(DBDataType.STRING , "fd_hierarchy_name","fdHierarchyName","路径名称","路径名称",false,false,true);
		
		/**
		 * 是否收藏
		*/
		public static final DBField IS_FAVOURITE = new DBField(DBDataType.STRING , "is_favourite","isFavourite","是否收藏","是否收藏",false,false,true);
		
		/**
		 * 文件夹
		*/
		public static final DBField FOLDER_ID = new DBField(DBDataType.STRING , "folder_id","folderId","文件夹","文件夹",false,false,true);
		
		/**
		 * fd类型
		*/
		public static final DBField FD_TYPE = new DBField(DBDataType.STRING , "fd_type","fdType","fd类型","fd类型",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","用户","用户",false,false,true);
		
		/**
		 * 父节点
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","父节点","父节点",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		public OA_NETDISK_VIRTUAL_FD() {
			this.init($NAME,"虚拟文件" , ID , FD_ID , FD_NAME , FD_SIZE , FD_FILE_TYPE , FD_HIERARCHY , FD_HIERARCHY_NAME , IS_FAVOURITE , FOLDER_ID , FD_TYPE , USER_ID , PARENT_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME);
		}
		public static final OA_NETDISK_VIRTUAL_FD $TABLE=new OA_NETDISK_VIRTUAL_FD();
	}
	
	/**
	 * 通知公告
	*/
	public static class OA_NOTICE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_notice";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 文号
		*/
		public static final DBField NUMBER = new DBField(DBDataType.STRING , "number","number","文号","文号",false,false,true);
		
		/**
		 * 标题
		*/
		public static final DBField TITLE = new DBField(DBDataType.STRING , "title","title","标题","标题",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 分类
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","分类","分类",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 是否置顶
		*/
		public static final DBField IFTOP = new DBField(DBDataType.STRING , "iftop","iftop","是否置顶","是否置顶",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
		/**
		 * 可见范围
		*/
		public static final DBField VISUAL_RANGE = new DBField(DBDataType.STRING , "visual_range","visualRange","可见范围","可见范围",false,false,true);
		
		/**
		 * 发布人
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","发布人","发布人",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_NOTICE() {
			this.init($NAME,"通知公告" , ID , NUMBER , TITLE , STATUS , TYPE , CONTENT , IFTOP , ATTACH , VISUAL_RANGE , USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OA_NOTICE $TABLE=new OA_NOTICE();
	}
	
	/**
	 * 通知公告权限
	*/
	public static class OA_NOTICE_PRIV extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_notice_priv";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 公告
		*/
		public static final DBField NOTICE_ID = new DBField(DBDataType.STRING , "notice_id","noticeId","公告","公告",false,false,true);
		
		/**
		 * 组织
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","组织","组织",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public OA_NOTICE_PRIV() {
			this.init($NAME,"通知公告权限" , ID , NOTICE_ID , ORG_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OA_NOTICE_PRIV $TABLE=new OA_NOTICE_PRIV();
	}
	
	/**
	 * 门户
	*/
	public static class OA_PORTAL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_portal";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_PORTAL() {
			this.init($NAME,"门户" , ID , NAME , NOTES , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_PORTAL $TABLE=new OA_PORTAL();
	}
	
	/**
	 * 会议室
	*/
	public static class OA_ROOM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_room";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","名称","名称",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 所属部门
		*/
		public static final DBField BELONG_ORG_ID = new DBField(DBDataType.STRING , "belong_org_id","belongOrgId","所属部门","所属部门",false,false,true);
		
		/**
		 * 管理人员
		*/
		public static final DBField MANAGE_USER_ID = new DBField(DBDataType.STRING , "manage_user_id","manageUserId","管理人员","管理人员",false,false,true);
		
		/**
		 * 联系电话
		*/
		public static final DBField CONTACT = new DBField(DBDataType.STRING , "contact","contact","联系电话","联系电话",false,false,true);
		
		/**
		 * 容量(人)
		*/
		public static final DBField MAX_PEOPLE = new DBField(DBDataType.INTEGER , "max_people","maxPeople","容量","人)",false,false,true);
		
		/**
		 * 位置
		*/
		public static final DBField POSITION_ID = new DBField(DBDataType.STRING , "position_id","positionId","位置","位置",false,false,true);
		
		/**
		 * 用途
		*/
		public static final DBField USAGE_INFO = new DBField(DBDataType.STRING , "usage_info","usageInfo","用途","用途",false,false,true);
		
		/**
		 * 图片
		*/
		public static final DBField PICTURES = new DBField(DBDataType.STRING , "pictures","pictures","图片","图片",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_ROOM() {
			this.init($NAME,"会议室" , ID , NAME , STATUS , TYPE , BELONG_ORG_ID , MANAGE_USER_ID , CONTACT , MAX_PEOPLE , POSITION_ID , USAGE_INFO , PICTURES , ORIGINATOR_ID , NOTES , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_ROOM $TABLE=new OA_ROOM();
	}
	
	/**
	 * 会议申请
	*/
	public static class OA_ROOM_APPLY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_room_apply";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 部门
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","部门","部门",false,false,true);
		
		/**
		 * 申请人
		*/
		public static final DBField APPLY_USER_ID = new DBField(DBDataType.STRING , "apply_user_id","applyUserId","申请人","申请人",false,false,true);
		
		/**
		 * 联系方式
		*/
		public static final DBField CONTACT = new DBField(DBDataType.STRING , "contact","contact","联系方式","联系方式",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField STIME = new DBField(DBDataType.DATE , "stime","stime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField ETIME = new DBField(DBDataType.DATE , "etime","etime","结束时间","结束时间",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		 * 选择
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择","选择",false,false,true);
		
		public OA_ROOM_APPLY() {
			this.init($NAME,"会议申请" , ID , BUSINESS_CODE , NAME , STATUS , ORG_ID , APPLY_USER_ID , CONTACT , STIME , ETIME , CONTENT , ATTACH , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final OA_ROOM_APPLY $TABLE=new OA_ROOM_APPLY();
	}
	
	/**
	 * 会议室位置
	*/
	public static class OA_ROOM_POSITION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_room_position";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 父节点
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","父节点","父节点",false,false,true);
		
		/**
		 * 节点路径
		*/
		public static final DBField HIERARCHY = new DBField(DBDataType.STRING , "hierarchy","hierarchy","节点路径","节点路径",false,false,true);
		
		/**
		 * 路径名称
		*/
		public static final DBField HIERARCHY_NAME = new DBField(DBDataType.STRING , "hierarchy_name","hierarchyName","路径名称","路径名称",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_ROOM_POSITION() {
			this.init($NAME,"会议室位置" , ID , CODE , NAME , PARENT_ID , HIERARCHY , HIERARCHY_NAME , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OA_ROOM_POSITION $TABLE=new OA_ROOM_POSITION();
	}
	
	/**
	 * 使用记录
	*/
	public static class OA_ROOM_RECORD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_room_record";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 单据
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","单据","单据",false,false,true);
		
		/**
		 * 使用类型
		*/
		public static final DBField BUSINESS_TYPE = new DBField(DBDataType.STRING , "business_type","businessType","使用类型","使用类型",false,false,true);
		
		/**
		 * 车辆
		*/
		public static final DBField ROOM_ID = new DBField(DBDataType.STRING , "room_id","roomId","车辆","车辆",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField STIME = new DBField(DBDataType.DATE , "stime","stime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField ETIME = new DBField(DBDataType.DATE , "etime","etime","结束时间","结束时间",false,false,true);
		
		/**
		 * 使用说明
		*/
		public static final DBField INFO = new DBField(DBDataType.STRING , "info","info","使用说明","使用说明",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_ROOM_RECORD() {
			this.init($NAME,"使用记录" , ID , BUSINESS_CODE , BUSINESS_TYPE , ROOM_ID , STIME , ETIME , INFO , ORIGINATOR_ID , NOTES , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_ROOM_RECORD $TABLE=new OA_ROOM_RECORD();
	}
	
	/**
	 * 日程安排
	*/
	public static class OA_SCHEDULE_PLAN extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_schedule_plan";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 优先级
		*/
		public static final DBField RANK = new DBField(DBDataType.STRING , "rank","rank","优先级","优先级",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField F_TIME = new DBField(DBDataType.DATE , "f_time","fTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField T_TIME = new DBField(DBDataType.DATE , "t_time","tTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 提醒
		*/
		public static final DBField REMIND = new DBField(DBDataType.STRING , "remind","remind","提醒","提醒",false,false,true);
		
		/**
		 * 提醒时间
		*/
		public static final DBField REMIND_TIME = new DBField(DBDataType.DATE , "remind_time","remindTime","提醒时间","提醒时间",false,false,true);
		
		/**
		 * 日程内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","日程内容","日程内容",false,false,true);
		
		/**
		 * 全天
		*/
		public static final DBField FULL_DAY = new DBField(DBDataType.STRING , "full_day","fullDay","全天","全天",false,false,true);
		
		/**
		 * 详细描述
		*/
		public static final DBField DETAIL = new DBField(DBDataType.STRING , "detail","detail","详细描述","详细描述",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","用户","用户",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_SCHEDULE_PLAN() {
			this.init($NAME,"日程安排" , ID , RANK , F_TIME , T_TIME , REMIND , REMIND_TIME , CONTENT , FULL_DAY , DETAIL , NOTES , USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OA_SCHEDULE_PLAN $TABLE=new OA_SCHEDULE_PLAN();
	}
	
	/**
	 * 外部系统
	*/
	public static class OA_SYSTEM_INFORMATION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_system_information";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 分类
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","分类","分类",false,false,true);
		
		/**
		 * 地址
		*/
		public static final DBField URL = new DBField(DBDataType.STRING , "url","url","地址","地址",false,false,true);
		
		/**
		 * 图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","图片","图片",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_SYSTEM_INFORMATION() {
			this.init($NAME,"外部系统" , ID , NAME , STATUS , TYPE , URL , PICTURE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OA_SYSTEM_INFORMATION $TABLE=new OA_SYSTEM_INFORMATION();
	}
	
	/**
	 * 车辆保险公司
	*/
	public static class OA_TEST extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_test";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_TEST() {
			this.init($NAME,"车辆保险公司" , ID , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OA_TEST $TABLE=new OA_TEST();
	}
	
	/**
	 * 车辆数据
	*/
	public static class OA_VEHICLE_A_SELECT_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_vehicle_a_select_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 处理
		*/
		public static final DBField HANDLE_ID = new DBField(DBDataType.STRING , "handle_id","handleId","处理","处理",false,false,true);
		
		/**
		 * 车辆
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","车辆","车辆",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public OA_VEHICLE_A_SELECT_ITEM() {
			this.init($NAME,"车辆数据" , ID , HANDLE_ID , ASSET_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OA_VEHICLE_A_SELECT_ITEM $TABLE=new OA_VEHICLE_A_SELECT_ITEM();
	}
	
	/**
	 * 车辆申请
	*/
	public static class OA_VEHICLE_APPLY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_vehicle_apply";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 部门
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","部门","部门",false,false,true);
		
		/**
		 * 领用人
		*/
		public static final DBField RECEIVER_ID = new DBField(DBDataType.STRING , "receiver_id","receiverId","领用人","领用人",false,false,true);
		
		/**
		 * 驾驶员
		*/
		public static final DBField DRIVER = new DBField(DBDataType.STRING , "driver","driver","驾驶员","驾驶员",false,false,true);
		
		/**
		 * 联系方式
		*/
		public static final DBField CONTACT = new DBField(DBDataType.STRING , "contact","contact","联系方式","联系方式",false,false,true);
		
		/**
		 * 领用时间
		*/
		public static final DBField COLLECTION_DATE = new DBField(DBDataType.DATE , "collection_date","collectionDate","领用时间","领用时间",false,false,true);
		
		/**
		 * 预计归还时间
		*/
		public static final DBField PLAN_RETURN_DATE = new DBField(DBDataType.DATE , "plan_return_date","planReturnDate","预计归还时间","预计归还时间",false,false,true);
		
		/**
		 * 实际归还时间
		*/
		public static final DBField ACT_RETURN_DATE = new DBField(DBDataType.DATE , "act_return_date","actReturnDate","实际归还时间","实际归还时间",false,false,true);
		
		/**
		 * 是否归还
		*/
		public static final DBField IF_RETURN = new DBField(DBDataType.STRING , "if_return","ifReturn","是否归还","是否归还",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
		/**
		 * 车辆
		*/
		public static final DBField VEHICLE_ID = new DBField(DBDataType.STRING , "vehicle_id","vehicleId","车辆","车辆",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 归还备注
		*/
		public static final DBField RETURN_NOTES = new DBField(DBDataType.STRING , "return_notes","returnNotes","归还备注","归还备注",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		 * 选择
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择","选择",false,false,true);
		
		public OA_VEHICLE_APPLY() {
			this.init($NAME,"车辆申请" , ID , BUSINESS_CODE , STATUS , NAME , ORG_ID , RECEIVER_ID , DRIVER , CONTACT , COLLECTION_DATE , PLAN_RETURN_DATE , ACT_RETURN_DATE , IF_RETURN , CONTENT , ATTACH , VEHICLE_ID , NOTES , RETURN_NOTES , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final OA_VEHICLE_APPLY $TABLE=new OA_VEHICLE_APPLY();
	}
	
	/**
	 * 车辆司机
	*/
	public static class OA_VEHICLE_DRIVER_SEL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_vehicle_driver_sel";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 车辆
		*/
		public static final DBField VEHICLE_ID = new DBField(DBDataType.STRING , "vehicle_id","vehicleId","车辆","车辆",false,false,true);
		
		/**
		 * 司机
		*/
		public static final DBField DRIVER_ID = new DBField(DBDataType.STRING , "driver_id","driverId","司机","司机",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_VEHICLE_DRIVER_SEL() {
			this.init($NAME,"车辆司机" , ID , VEHICLE_ID , DRIVER_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_VEHICLE_DRIVER_SEL $TABLE=new OA_VEHICLE_DRIVER_SEL();
	}
	
	/**
	 * 车辆信息
	*/
	public static class OA_VEHICLE_INFO extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_vehicle_info";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField VEHICLE_STATUS = new DBField(DBDataType.STRING , "vehicle_status","vehicleStatus","状态","状态",false,false,true);
		
		/**
		 * 车辆类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","车辆类型","车辆类型",false,false,true);
		
		/**
		 * 车牌号
		*/
		public static final DBField VEHICLE_CODE = new DBField(DBDataType.STRING , "vehicle_code","vehicleCode","车牌号","车牌号",false,false,true);
		
		/**
		 * 品牌型号
		*/
		public static final DBField MODEL = new DBField(DBDataType.STRING , "model","model","品牌型号","品牌型号",false,false,true);
		
		/**
		 * 登记人
		*/
		public static final DBField REGISTRANT = new DBField(DBDataType.STRING , "registrant","registrant","登记人","登记人",false,false,true);
		
		/**
		 * 所属组织
		*/
		public static final DBField OWNER_ORG_ID = new DBField(DBDataType.STRING , "owner_org_id","ownerOrgId","所属组织","所属组织",false,false,true);
		
		/**
		 * 使用人
		*/
		public static final DBField MANAGE_USER_ID = new DBField(DBDataType.STRING , "manage_user_id","manageUserId","使用人","使用人",false,false,true);
		
		/**
		 * 使用部门
		*/
		public static final DBField USE_ORG_ID = new DBField(DBDataType.STRING , "use_org_id","useOrgId","使用部门","使用部门",false,false,true);
		
		/**
		 * 使用人
		*/
		public static final DBField USE_USER_ID = new DBField(DBDataType.STRING , "use_user_id","useUserId","使用人","使用人",false,false,true);
		
		/**
		 * 颜色
		*/
		public static final DBField COLOR = new DBField(DBDataType.STRING , "color","color","颜色","颜色",false,false,true);
		
		/**
		 * 发动机号
		*/
		public static final DBField ENGINE_NUMBER = new DBField(DBDataType.STRING , "engine_number","engineNumber","发动机号","发动机号",false,false,true);
		
		/**
		 * 行驶证
		*/
		public static final DBField DRIVING_LICENSE = new DBField(DBDataType.STRING , "driving_license","drivingLicense","行驶证","行驶证",false,false,true);
		
		/**
		 * 车架号
		*/
		public static final DBField FRAME_NUMBER = new DBField(DBDataType.STRING , "frame_number","frameNumber","车架号","车架号",false,false,true);
		
		/**
		 * 公里数
		*/
		public static final DBField KILOMETERS = new DBField(DBDataType.DECIMAL , "kilometers","kilometers","公里数","公里数",false,false,true);
		
		/**
		 * 车船税
		*/
		public static final DBField CAR_BOAT_TAX = new DBField(DBDataType.DECIMAL , "car_boat_tax","carBoatTax","车船税","车船税",false,false,true);
		
		/**
		 * 抢险(元)
		*/
		public static final DBField RESCUE_MONEY = new DBField(DBDataType.DECIMAL , "rescue_money","rescueMoney","抢险","元)",false,false,true);
		
		/**
		 * 商业险(元)
		*/
		public static final DBField COMMERCIAL_INSURANCE_MONEY = new DBField(DBDataType.DECIMAL , "commercial_insurance_money","commercialInsuranceMoney","商业险","元)",false,false,true);
		
		/**
		 * 保险公司
		*/
		public static final DBField INSURANCE_COMPANY = new DBField(DBDataType.STRING , "insurance_company","insuranceCompany","保险公司","保险公司",false,false,true);
		
		/**
		 * 上牌时间
		*/
		public static final DBField LICENSING_TIME = new DBField(DBDataType.DATE , "licensing_time","licensingTime","上牌时间","上牌时间",false,false,true);
		
		/**
		 * 商业险到期
		*/
		public static final DBField INSURANCE_EXPIRE_DATE = new DBField(DBDataType.DATE , "insurance_expire_date","insuranceExpireDate","商业险到期","商业险到期",false,false,true);
		
		/**
		 * 抢险到期
		*/
		public static final DBField RESCUE_DUE_DATE = new DBField(DBDataType.DATE , "rescue_due_date","rescueDueDate","抢险到期","抢险到期",false,false,true);
		
		/**
		 * 承载人数
		*/
		public static final DBField MAXIMUM_PASSENGERS = new DBField(DBDataType.INTEGER , "maximum_passengers","maximumPassengers","承载人数","承载人数",false,false,true);
		
		/**
		 * 报废时间
		*/
		public static final DBField SCRAP_TIME = new DBField(DBDataType.DATE , "scrap_time","scrapTime","报废时间","报废时间",false,false,true);
		
		/**
		 * 存放位置
		*/
		public static final DBField POSITION_ID = new DBField(DBDataType.STRING , "position_id","positionId","存放位置","存放位置",false,false,true);
		
		/**
		 * 位置详情
		*/
		public static final DBField POSITION_DETAIL = new DBField(DBDataType.STRING , "position_detail","positionDetail","位置详情","位置详情",false,false,true);
		
		/**
		 * 图片
		*/
		public static final DBField PICTURES = new DBField(DBDataType.STRING , "pictures","pictures","图片","图片",false,false,true);
		
		/**
		 * 技术参数
		*/
		public static final DBField TECHNICAL_PARAMETER = new DBField(DBDataType.STRING , "technical_parameter","technicalParameter","技术参数","技术参数",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_VEHICLE_INFO() {
			this.init($NAME,"车辆信息" , ID , NAME , VEHICLE_STATUS , TYPE , VEHICLE_CODE , MODEL , REGISTRANT , OWNER_ORG_ID , MANAGE_USER_ID , USE_ORG_ID , USE_USER_ID , COLOR , ENGINE_NUMBER , DRIVING_LICENSE , FRAME_NUMBER , KILOMETERS , CAR_BOAT_TAX , RESCUE_MONEY , COMMERCIAL_INSURANCE_MONEY , INSURANCE_COMPANY , LICENSING_TIME , INSURANCE_EXPIRE_DATE , RESCUE_DUE_DATE , MAXIMUM_PASSENGERS , SCRAP_TIME , POSITION_ID , POSITION_DETAIL , PICTURES , TECHNICAL_PARAMETER , ORIGINATOR_ID , NOTES , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_VEHICLE_INFO $TABLE=new OA_VEHICLE_INFO();
	}
	
	/**
	 * 车辆保险公司
	*/
	public static class OA_VEHICLE_INSURANCE_COM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_vehicle_insurance_com";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_VEHICLE_INSURANCE_COM() {
			this.init($NAME,"车辆保险公司" , ID , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OA_VEHICLE_INSURANCE_COM $TABLE=new OA_VEHICLE_INSURANCE_COM();
	}
	
	/**
	 * 车辆保险公司
	*/
	public static class OA_VEHICLE_INSURANCE_COMPANY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_vehicle_insurance_company";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_VEHICLE_INSURANCE_COMPANY() {
			this.init($NAME,"车辆保险公司" , ID , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OA_VEHICLE_INSURANCE_COMPANY $TABLE=new OA_VEHICLE_INSURANCE_COMPANY();
	}
	
	/**
	 * 车辆保险记录
	*/
	public static class OA_VEHICLE_INSURANCE_RECORD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_vehicle_insurance_record";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 保险公司
		*/
		public static final DBField COMPANY_ID = new DBField(DBDataType.STRING , "company_id","companyId","保险公司","保险公司",false,false,true);
		
		/**
		 * 保险公司
		*/
		public static final DBField COMPANY_NAME = new DBField(DBDataType.STRING , "company_name","companyName","保险公司","保险公司",false,false,true);
		
		/**
		 * 保险类型
		*/
		public static final DBField INSURANCE_TYPE = new DBField(DBDataType.STRING , "insurance_type","insuranceType","保险类型","保险类型",false,false,true);
		
		/**
		 * 费用
		*/
		public static final DBField COST = new DBField(DBDataType.DECIMAL , "cost","cost","费用","费用",false,false,true);
		
		/**
		 * 处理人
		*/
		public static final DBField HANDLER_NAME = new DBField(DBDataType.STRING , "handler_name","handlerName","处理人","处理人",false,false,true);
		
		/**
		 * 联系方式
		*/
		public static final DBField HANDLER_CONTACT = new DBField(DBDataType.STRING , "handler_contact","handlerContact","联系方式","联系方式",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_VEHICLE_INSURANCE_RECORD() {
			this.init($NAME,"车辆保险记录" , ID , NAME , COMPANY_ID , COMPANY_NAME , INSURANCE_TYPE , COST , HANDLER_NAME , HANDLER_CONTACT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OA_VEHICLE_INSURANCE_RECORD $TABLE=new OA_VEHICLE_INSURANCE_RECORD();
	}
	
	/**
	 * 车辆数据
	*/
	public static class OA_VEHICLE_M_SELECT_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_vehicle_m_select_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 处理
		*/
		public static final DBField HANDLE_ID = new DBField(DBDataType.STRING , "handle_id","handleId","处理","处理",false,false,true);
		
		/**
		 * 车辆
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","车辆","车辆",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public OA_VEHICLE_M_SELECT_ITEM() {
			this.init($NAME,"车辆数据" , ID , HANDLE_ID , ASSET_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OA_VEHICLE_M_SELECT_ITEM $TABLE=new OA_VEHICLE_M_SELECT_ITEM();
	}
	
	/**
	 * 车辆维修保养
	*/
	public static class OA_VEHICLE_MAINTENANCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_vehicle_maintenance";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","业务编号","业务编号",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 流程
		*/
		public static final DBField PROC_ID = new DBField(DBDataType.STRING , "proc_id","procId","流程","流程",false,false,true);
		
		/**
		 * 业务名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","业务名称","业务名称",false,false,true);
		
		/**
		 * 维修状态
		*/
		public static final DBField REPAIR_STATUS = new DBField(DBDataType.STRING , "repair_status","repairStatus","维修状态","维修状态",false,false,true);
		
		/**
		 * 报修类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","报修类型","报修类型",false,false,true);
		
		/**
		 * 计划完成日期
		*/
		public static final DBField PLAN_FINISH_DATE = new DBField(DBDataType.DATE , "plan_finish_date","planFinishDate","计划完成日期","计划完成日期",false,false,true);
		
		/**
		 * 实际完成日期
		*/
		public static final DBField ACTUAL_FINISH_DATE = new DBField(DBDataType.DATE , "actual_finish_date","actualFinishDate","实际完成日期","实际完成日期",false,false,true);
		
		/**
		 * 费用
		*/
		public static final DBField COST = new DBField(DBDataType.DECIMAL , "cost","cost","费用","费用",false,false,true);
		
		/**
		 * 报修内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","报修内容","报修内容",false,false,true);
		
		/**
		 * 报修人
		*/
		public static final DBField REPORT_USER_ID = new DBField(DBDataType.STRING , "report_user_id","reportUserId","报修人","报修人",false,false,true);
		
		/**
		 * 报修人
		*/
		public static final DBField REPORT_USER_NAME = new DBField(DBDataType.STRING , "report_user_name","reportUserName","报修人","报修人",false,false,true);
		
		/**
		 * 图片
		*/
		public static final DBField PICTURE_ID = new DBField(DBDataType.STRING , "picture_id","pictureId","图片","图片",false,false,true);
		
		/**
		 * 车辆
		*/
		public static final DBField VEHICLE_ID = new DBField(DBDataType.STRING , "vehicle_id","vehicleId","车辆","车辆",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 业务日期
		*/
		public static final DBField BUSINESS_DATE = new DBField(DBDataType.DATE , "business_date","businessDate","业务日期","业务日期",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		 * 选择数据
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择数据","选择数据",false,false,true);
		
		public OA_VEHICLE_MAINTENANCE() {
			this.init($NAME,"车辆维修保养" , ID , BUSINESS_CODE , STATUS , PROC_ID , NAME , REPAIR_STATUS , TYPE , PLAN_FINISH_DATE , ACTUAL_FINISH_DATE , COST , CONTENT , REPORT_USER_ID , REPORT_USER_NAME , PICTURE_ID , VEHICLE_ID , ORIGINATOR_ID , BUSINESS_DATE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE);
		}
		public static final OA_VEHICLE_MAINTENANCE $TABLE=new OA_VEHICLE_MAINTENANCE();
	}
	
	/**
	 * 车辆位置
	*/
	public static class OA_VEHICLE_POSITION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_vehicle_position";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 父节点
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","父节点","父节点",false,false,true);
		
		/**
		 * 节点路径
		*/
		public static final DBField HIERARCHY = new DBField(DBDataType.STRING , "hierarchy","hierarchy","节点路径","节点路径",false,false,true);
		
		/**
		 * 路径名称
		*/
		public static final DBField HIERARCHY_NAME = new DBField(DBDataType.STRING , "hierarchy_name","hierarchyName","路径名称","路径名称",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_VEHICLE_POSITION() {
			this.init($NAME,"车辆位置" , ID , CODE , NAME , PARENT_ID , HIERARCHY , HIERARCHY_NAME , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OA_VEHICLE_POSITION $TABLE=new OA_VEHICLE_POSITION();
	}
	
	/**
	 * 使用记录
	*/
	public static class OA_VEHICLE_RECORD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_vehicle_record";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 单据
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","单据","单据",false,false,true);
		
		/**
		 * 使用类型
		*/
		public static final DBField BUSINESS_TYPE = new DBField(DBDataType.STRING , "business_type","businessType","使用类型","使用类型",false,false,true);
		
		/**
		 * 车辆
		*/
		public static final DBField VEHICLE_ID = new DBField(DBDataType.STRING , "vehicle_id","vehicleId","车辆","车辆",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField STIME = new DBField(DBDataType.DATE , "stime","stime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField ETIME = new DBField(DBDataType.DATE , "etime","etime","结束时间","结束时间",false,false,true);
		
		/**
		 * 使用说明
		*/
		public static final DBField INFO = new DBField(DBDataType.STRING , "info","info","使用说明","使用说明",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_VEHICLE_RECORD() {
			this.init($NAME,"使用记录" , ID , BUSINESS_CODE , BUSINESS_TYPE , VEHICLE_ID , STIME , ETIME , INFO , ORIGINATOR_ID , NOTES , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_VEHICLE_RECORD $TABLE=new OA_VEHICLE_RECORD();
	}
	
	/**
	 * 车辆数据
	*/
	public static class OA_VEHICLE_SELECT_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_vehicle_select_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 处理
		*/
		public static final DBField HANDLE_ID = new DBField(DBDataType.STRING , "handle_id","handleId","处理","处理",false,false,true);
		
		/**
		 * 车辆
		*/
		public static final DBField ASSET_ID = new DBField(DBDataType.STRING , "asset_id","assetId","车辆","车辆",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public OA_VEHICLE_SELECT_ITEM() {
			this.init($NAME,"车辆数据" , ID , HANDLE_ID , ASSET_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final OA_VEHICLE_SELECT_ITEM $TABLE=new OA_VEHICLE_SELECT_ITEM();
	}
	
	/**
	 * 工作计划
	*/
	public static class OA_WORK_PLAN extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_work_plan";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 日期
		*/
		public static final DBField RCD = new DBField(DBDataType.DATE , "rcd","rcd","日期","日期",false,false,true);
		
		/**
		 * 日期描述
		*/
		public static final DBField WEEK_DESC = new DBField(DBDataType.STRING , "week_desc","weekDesc","日期描述","日期描述",false,false,true);
		
		/**
		 * 工作内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","工作内容","工作内容",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_WORK_PLAN() {
			this.init($NAME,"工作计划" , ID , RCD , WEEK_DESC , CONTENT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OA_WORK_PLAN $TABLE=new OA_WORK_PLAN();
	}
	
	/**
	 * 工作记录
	*/
	public static class OA_WORK_RCD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_work_rcd";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 员工
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","员工","员工",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField F_TIME = new DBField(DBDataType.DATE , "f_time","fTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField T_TIME = new DBField(DBDataType.DATE , "t_time","tTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 说明
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","说明","说明",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_WORK_RCD() {
			this.init($NAME,"工作记录" , ID , USER_ID , F_TIME , T_TIME , FILE_ID , CONTENT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OA_WORK_RCD $TABLE=new OA_WORK_RCD();
	}
	
	/**
	 * 工作报告
	*/
	public static class OA_WORK_RPT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_work_rpt";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","ID","ID",true,false,false);
		
		/**
		 * 开始时间
		*/
		public static final DBField F_TIME = new DBField(DBDataType.DATE , "f_time","fTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField T_TIME = new DBField(DBDataType.DATE , "t_time","tTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 本周
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","本周","本周",false,false,true);
		
		/**
		 * 下周
		*/
		public static final DBField NEXT_CONTENT = new DBField(DBDataType.STRING , "next_content","nextContent","下周","下周",false,false,true);
		
		/**
		 * 其他事项
		*/
		public static final DBField OTHER = new DBField(DBDataType.STRING , "other","other","其他事项","其他事项",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 报告人
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","报告人","报告人",false,false,true);
		
		/**
		 * 接收人
		*/
		public static final DBField RECEIVER_ID = new DBField(DBDataType.STRING , "receiver_id","receiverId","接收人","接收人",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_WORK_RPT() {
			this.init($NAME,"工作报告" , ID , F_TIME , T_TIME , CONTENT , NEXT_CONTENT , OTHER , FILE_ID , USER_ID , RECEIVER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final OA_WORK_RPT $TABLE=new OA_WORK_RPT();
	}
}