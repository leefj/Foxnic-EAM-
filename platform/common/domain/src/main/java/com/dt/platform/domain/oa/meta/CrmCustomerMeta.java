package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.CrmCustomer;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.oa.CrmCustomerLeader;
import java.util.List;
import com.dt.platform.domain.oa.CrmCustomerBusiness;
import com.dt.platform.domain.oa.CrmCustomerContact;
import com.dt.platform.domain.oa.CrmCustomerReview;
import com.dt.platform.domain.oa.CrmCustomerRecord;
import com.dt.platform.domain.oa.CrmCustomerFollow;
import com.dt.platform.domain.oa.CrmCustomerIndustry;
import com.dt.platform.domain.oa.CrmCustomerIntentional;
import com.dt.platform.domain.oa.CrmCustomerLevel;
import com.dt.platform.domain.oa.CrmCustomerSource;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-16 20:34:49
 * @sign 14C2002AEA05D7635F2AA8E945AEAB2C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CrmCustomerMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 客户编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 客户编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,CODE, java.lang.String.class, "客户编码", "客户编码", java.lang.String.class, null);
	
	/**
	 * 客户名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 客户名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,NAME, java.lang.String.class, "客户名称", "客户名称", java.lang.String.class, null);
	
	/**
	 * 客户等级 , 类型: java.lang.String
	*/
	public static final String LEVEL="level";
	
	/**
	 * 客户等级 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> LEVEL_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,LEVEL, java.lang.String.class, "客户等级", "客户等级", java.lang.String.class, null);
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final String OWNER_ID="ownerId";
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> OWNER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,OWNER_ID, java.lang.String.class, "负责人", "负责人", java.lang.String.class, null);
	
	/**
	 * 意向状态 , 类型: java.lang.String
	*/
	public static final String INTENTIONAL_STATE="intentionalState";
	
	/**
	 * 意向状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> INTENTIONAL_STATE_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,INTENTIONAL_STATE, java.lang.String.class, "意向状态", "意向状态", java.lang.String.class, null);
	
	/**
	 * 联系人 , 类型: java.lang.String
	*/
	public static final String CONTACTS="contacts";
	
	/**
	 * 联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> CONTACTS_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,CONTACTS, java.lang.String.class, "联系人", "联系人", java.lang.String.class, null);
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final String CONTACT_INFO="contactInfo";
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> CONTACT_INFO_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,CONTACT_INFO, java.lang.String.class, "联系方式", "联系方式", java.lang.String.class, null);
	
	/**
	 * 网址 , 类型: java.lang.String
	*/
	public static final String WEBSITE="website";
	
	/**
	 * 网址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> WEBSITE_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,WEBSITE, java.lang.String.class, "网址", "网址", java.lang.String.class, null);
	
	/**
	 * 所在行业 , 类型: java.lang.String
	*/
	public static final String INDUSTRY_ID="industryId";
	
	/**
	 * 所在行业 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> INDUSTRY_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,INDUSTRY_ID, java.lang.String.class, "所在行业", "所在行业", java.lang.String.class, null);
	
	/**
	 * 客户介绍 , 类型: java.lang.String
	*/
	public static final String PROFILE="profile";
	
	/**
	 * 客户介绍 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> PROFILE_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,PROFILE, java.lang.String.class, "客户介绍", "客户介绍", java.lang.String.class, null);
	
	/**
	 * 客户来源 , 类型: java.lang.String
	*/
	public static final String SOURCE_ID="sourceId";
	
	/**
	 * 客户来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> SOURCE_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,SOURCE_ID, java.lang.String.class, "客户来源", "客户来源", java.lang.String.class, null);
	
	/**
	 * 客户地址 , 类型: java.lang.String
	*/
	public static final String ADDRESS="address";
	
	/**
	 * 客户地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> ADDRESS_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,ADDRESS, java.lang.String.class, "客户地址", "客户地址", java.lang.String.class, null);
	
	/**
	 * 最近跟进 , 类型: java.util.Date
	*/
	public static final String RECENT_FOLLOW_TIME="recentFollowTime";
	
	/**
	 * 最近跟进 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.util.Date> RECENT_FOLLOW_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,RECENT_FOLLOW_TIME, java.util.Date.class, "最近跟进", "最近跟进", java.util.Date.class, null);
	
	/**
	 * 下次跟进 , 类型: java.util.Date
	*/
	public static final String NEXT_FOLLOW_TIME="nextFollowTime";
	
	/**
	 * 下次跟进 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.util.Date> NEXT_FOLLOW_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,NEXT_FOLLOW_TIME, java.util.Date.class, "下次跟进", "下次跟进", java.util.Date.class, null);
	
	/**
	 * 成交状态 , 类型: java.lang.String
	*/
	public static final String TRANSACTION_STATUS="transactionStatus";
	
	/**
	 * 成交状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> TRANSACTION_STATUS_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,TRANSACTION_STATUS, java.lang.String.class, "成交状态", "成交状态", java.lang.String.class, null);
	
	/**
	 * 是否锁定 , lcoked|unlock , 类型: java.lang.String
	*/
	public static final String LOCKED="locked";
	
	/**
	 * 是否锁定 , lcoked|unlock , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> LOCKED_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,LOCKED, java.lang.String.class, "是否锁定", "lcoked|unlock", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 客户位置 , 类型: java.lang.String
	*/
	public static final String ROLE_POS="rolePos";
	
	/**
	 * 客户位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> ROLE_POS_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,ROLE_POS, java.lang.String.class, "客户位置", "客户位置", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * originator , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * originator , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "originator", "originator", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * owner , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String OWNER="owner";
	
	/**
	 * owner , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,org.github.foxnic.web.domain.hrm.Employee> OWNER_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,OWNER, org.github.foxnic.web.domain.hrm.Employee.class, "owner", "owner", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * crmCustomerLeaderList , 集合类型: LIST , 类型: com.dt.platform.domain.oa.CrmCustomerLeader
	*/
	public static final String CRM_CUSTOMER_LEADER_LIST="crmCustomerLeaderList";
	
	/**
	 * crmCustomerLeaderList , 集合类型: LIST , 类型: com.dt.platform.domain.oa.CrmCustomerLeader
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,com.dt.platform.domain.oa.CrmCustomerLeader> CRM_CUSTOMER_LEADER_LIST_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,CRM_CUSTOMER_LEADER_LIST, java.util.List.class, "crmCustomerLeaderList", "crmCustomerLeaderList", com.dt.platform.domain.oa.CrmCustomerLeader.class, null);
	
	/**
	 * crmCustomerBusinessList , crmCustomerLeaderList , 集合类型: LIST , 类型: com.dt.platform.domain.oa.CrmCustomerBusiness
	*/
	public static final String CRM_CUSTOMER_BUSINESS_LIST="crmCustomerBusinessList";
	
	/**
	 * crmCustomerBusinessList , crmCustomerLeaderList , 集合类型: LIST , 类型: com.dt.platform.domain.oa.CrmCustomerBusiness
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,com.dt.platform.domain.oa.CrmCustomerBusiness> CRM_CUSTOMER_BUSINESS_LIST_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,CRM_CUSTOMER_BUSINESS_LIST, java.util.List.class, "crmCustomerBusinessList", "crmCustomerLeaderList", com.dt.platform.domain.oa.CrmCustomerBusiness.class, null);
	
	/**
	 * crmCustomerContactList , crmCustomerLeaderList , 集合类型: LIST , 类型: com.dt.platform.domain.oa.CrmCustomerContact
	*/
	public static final String CRM_CUSTOMER_CONTACT_LIST="crmCustomerContactList";
	
	/**
	 * crmCustomerContactList , crmCustomerLeaderList , 集合类型: LIST , 类型: com.dt.platform.domain.oa.CrmCustomerContact
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,com.dt.platform.domain.oa.CrmCustomerContact> CRM_CUSTOMER_CONTACT_LIST_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,CRM_CUSTOMER_CONTACT_LIST, java.util.List.class, "crmCustomerContactList", "crmCustomerLeaderList", com.dt.platform.domain.oa.CrmCustomerContact.class, null);
	
	/**
	 * crmCustomerReviewList , 集合类型: LIST , 类型: com.dt.platform.domain.oa.CrmCustomerReview
	*/
	public static final String CRM_CUSTOMER_REVIEW_LIST="crmCustomerReviewList";
	
	/**
	 * crmCustomerReviewList , 集合类型: LIST , 类型: com.dt.platform.domain.oa.CrmCustomerReview
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,com.dt.platform.domain.oa.CrmCustomerReview> CRM_CUSTOMER_REVIEW_LIST_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,CRM_CUSTOMER_REVIEW_LIST, java.util.List.class, "crmCustomerReviewList", "crmCustomerReviewList", com.dt.platform.domain.oa.CrmCustomerReview.class, null);
	
	/**
	 * crmCustomerRecordList , 集合类型: LIST , 类型: com.dt.platform.domain.oa.CrmCustomerRecord
	*/
	public static final String CRM_CUSTOMER_RECORD_LIST="crmCustomerRecordList";
	
	/**
	 * crmCustomerRecordList , 集合类型: LIST , 类型: com.dt.platform.domain.oa.CrmCustomerRecord
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,com.dt.platform.domain.oa.CrmCustomerRecord> CRM_CUSTOMER_RECORD_LIST_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,CRM_CUSTOMER_RECORD_LIST, java.util.List.class, "crmCustomerRecordList", "crmCustomerRecordList", com.dt.platform.domain.oa.CrmCustomerRecord.class, null);
	
	/**
	 * crmCustomerFollowList , crmCustomerRecordList , 集合类型: LIST , 类型: com.dt.platform.domain.oa.CrmCustomerFollow
	*/
	public static final String CRM_CUSTOMER_FOLLOW_LIST="crmCustomerFollowList";
	
	/**
	 * crmCustomerFollowList , crmCustomerRecordList , 集合类型: LIST , 类型: com.dt.platform.domain.oa.CrmCustomerFollow
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,com.dt.platform.domain.oa.CrmCustomerFollow> CRM_CUSTOMER_FOLLOW_LIST_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,CRM_CUSTOMER_FOLLOW_LIST, java.util.List.class, "crmCustomerFollowList", "crmCustomerRecordList", com.dt.platform.domain.oa.CrmCustomerFollow.class, null);
	
	/**
	 * crmFirstCustomerContact , 类型: com.dt.platform.domain.oa.CrmCustomerContact
	*/
	public static final String CRM_FIRST_CUSTOMER_CONTACT="crmFirstCustomerContact";
	
	/**
	 * crmFirstCustomerContact , 类型: com.dt.platform.domain.oa.CrmCustomerContact
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,com.dt.platform.domain.oa.CrmCustomerContact> CRM_FIRST_CUSTOMER_CONTACT_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,CRM_FIRST_CUSTOMER_CONTACT, com.dt.platform.domain.oa.CrmCustomerContact.class, "crmFirstCustomerContact", "crmFirstCustomerContact", com.dt.platform.domain.oa.CrmCustomerContact.class, null);
	
	/**
	 * crmCustomerIndustry , 类型: com.dt.platform.domain.oa.CrmCustomerIndustry
	*/
	public static final String CRM_CUSTOMER_INDUSTRY="crmCustomerIndustry";
	
	/**
	 * crmCustomerIndustry , 类型: com.dt.platform.domain.oa.CrmCustomerIndustry
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,com.dt.platform.domain.oa.CrmCustomerIndustry> CRM_CUSTOMER_INDUSTRY_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,CRM_CUSTOMER_INDUSTRY, com.dt.platform.domain.oa.CrmCustomerIndustry.class, "crmCustomerIndustry", "crmCustomerIndustry", com.dt.platform.domain.oa.CrmCustomerIndustry.class, null);
	
	/**
	 * crmCustomerIntentional , 类型: com.dt.platform.domain.oa.CrmCustomerIntentional
	*/
	public static final String CRM_CUSTOMER_INTENTIONAL="crmCustomerIntentional";
	
	/**
	 * crmCustomerIntentional , 类型: com.dt.platform.domain.oa.CrmCustomerIntentional
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,com.dt.platform.domain.oa.CrmCustomerIntentional> CRM_CUSTOMER_INTENTIONAL_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,CRM_CUSTOMER_INTENTIONAL, com.dt.platform.domain.oa.CrmCustomerIntentional.class, "crmCustomerIntentional", "crmCustomerIntentional", com.dt.platform.domain.oa.CrmCustomerIntentional.class, null);
	
	/**
	 * crmCustomerLevel , 类型: com.dt.platform.domain.oa.CrmCustomerLevel
	*/
	public static final String CRM_CUSTOMER_LEVEL="crmCustomerLevel";
	
	/**
	 * crmCustomerLevel , 类型: com.dt.platform.domain.oa.CrmCustomerLevel
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,com.dt.platform.domain.oa.CrmCustomerLevel> CRM_CUSTOMER_LEVEL_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,CRM_CUSTOMER_LEVEL, com.dt.platform.domain.oa.CrmCustomerLevel.class, "crmCustomerLevel", "crmCustomerLevel", com.dt.platform.domain.oa.CrmCustomerLevel.class, null);
	
	/**
	 * crmCustomerSource , 类型: com.dt.platform.domain.oa.CrmCustomerSource
	*/
	public static final String CRM_CUSTOMER_SOURCE="crmCustomerSource";
	
	/**
	 * crmCustomerSource , 类型: com.dt.platform.domain.oa.CrmCustomerSource
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,com.dt.platform.domain.oa.CrmCustomerSource> CRM_CUSTOMER_SOURCE_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,CRM_CUSTOMER_SOURCE, com.dt.platform.domain.oa.CrmCustomerSource.class, "crmCustomerSource", "crmCustomerSource", com.dt.platform.domain.oa.CrmCustomerSource.class, null);
	
	/**
	 * searchCustomerType , 类型: java.lang.String
	*/
	public static final String SEARCH_CUSTOMER_TYPE="searchCustomerType";
	
	/**
	 * searchCustomerType , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomer,java.lang.String> SEARCH_CUSTOMER_TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomer.class ,SEARCH_CUSTOMER_TYPE, java.lang.String.class, "searchCustomerType", "searchCustomerType", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , NAME , LEVEL , OWNER_ID , INTENTIONAL_STATE , CONTACTS , CONTACT_INFO , WEBSITE , INDUSTRY_ID , PROFILE , SOURCE_ID , ADDRESS , RECENT_FOLLOW_TIME , NEXT_FOLLOW_TIME , TRANSACTION_STATUS , LOCKED , NOTES , ROLE_POS , ORIGINATOR_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , ORIGINATOR , OWNER , CRM_CUSTOMER_LEADER_LIST , CRM_CUSTOMER_BUSINESS_LIST , CRM_CUSTOMER_CONTACT_LIST , CRM_CUSTOMER_REVIEW_LIST , CRM_CUSTOMER_RECORD_LIST , CRM_CUSTOMER_FOLLOW_LIST , CRM_FIRST_CUSTOMER_CONTACT , CRM_CUSTOMER_INDUSTRY , CRM_CUSTOMER_INTENTIONAL , CRM_CUSTOMER_LEVEL , CRM_CUSTOMER_SOURCE , SEARCH_CUSTOMER_TYPE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.CrmCustomer {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CrmCustomer setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 客户编码
		 * @param code 客户编码
		 * @return 当前对象
		*/
		public CrmCustomer setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 客户名称
		 * @param name 客户名称
		 * @return 当前对象
		*/
		public CrmCustomer setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 客户等级
		 * @param level 客户等级
		 * @return 当前对象
		*/
		public CrmCustomer setLevel(String level) {
			super.change(LEVEL,super.getLevel(),level);
			super.setLevel(level);
			return this;
		}
		
		/**
		 * 设置 负责人
		 * @param ownerId 负责人
		 * @return 当前对象
		*/
		public CrmCustomer setOwnerId(String ownerId) {
			super.change(OWNER_ID,super.getOwnerId(),ownerId);
			super.setOwnerId(ownerId);
			return this;
		}
		
		/**
		 * 设置 意向状态
		 * @param intentionalState 意向状态
		 * @return 当前对象
		*/
		public CrmCustomer setIntentionalState(String intentionalState) {
			super.change(INTENTIONAL_STATE,super.getIntentionalState(),intentionalState);
			super.setIntentionalState(intentionalState);
			return this;
		}
		
		/**
		 * 设置 联系人
		 * @param contacts 联系人
		 * @return 当前对象
		*/
		public CrmCustomer setContacts(String contacts) {
			super.change(CONTACTS,super.getContacts(),contacts);
			super.setContacts(contacts);
			return this;
		}
		
		/**
		 * 设置 联系方式
		 * @param contactInfo 联系方式
		 * @return 当前对象
		*/
		public CrmCustomer setContactInfo(String contactInfo) {
			super.change(CONTACT_INFO,super.getContactInfo(),contactInfo);
			super.setContactInfo(contactInfo);
			return this;
		}
		
		/**
		 * 设置 网址
		 * @param website 网址
		 * @return 当前对象
		*/
		public CrmCustomer setWebsite(String website) {
			super.change(WEBSITE,super.getWebsite(),website);
			super.setWebsite(website);
			return this;
		}
		
		/**
		 * 设置 所在行业
		 * @param industryId 所在行业
		 * @return 当前对象
		*/
		public CrmCustomer setIndustryId(String industryId) {
			super.change(INDUSTRY_ID,super.getIndustryId(),industryId);
			super.setIndustryId(industryId);
			return this;
		}
		
		/**
		 * 设置 客户介绍
		 * @param profile 客户介绍
		 * @return 当前对象
		*/
		public CrmCustomer setProfile(String profile) {
			super.change(PROFILE,super.getProfile(),profile);
			super.setProfile(profile);
			return this;
		}
		
		/**
		 * 设置 客户来源
		 * @param sourceId 客户来源
		 * @return 当前对象
		*/
		public CrmCustomer setSourceId(String sourceId) {
			super.change(SOURCE_ID,super.getSourceId(),sourceId);
			super.setSourceId(sourceId);
			return this;
		}
		
		/**
		 * 设置 客户地址
		 * @param address 客户地址
		 * @return 当前对象
		*/
		public CrmCustomer setAddress(String address) {
			super.change(ADDRESS,super.getAddress(),address);
			super.setAddress(address);
			return this;
		}
		
		/**
		 * 设置 最近跟进
		 * @param recentFollowTime 最近跟进
		 * @return 当前对象
		*/
		public CrmCustomer setRecentFollowTime(Date recentFollowTime) {
			super.change(RECENT_FOLLOW_TIME,super.getRecentFollowTime(),recentFollowTime);
			super.setRecentFollowTime(recentFollowTime);
			return this;
		}
		
		/**
		 * 设置 下次跟进
		 * @param nextFollowTime 下次跟进
		 * @return 当前对象
		*/
		public CrmCustomer setNextFollowTime(Date nextFollowTime) {
			super.change(NEXT_FOLLOW_TIME,super.getNextFollowTime(),nextFollowTime);
			super.setNextFollowTime(nextFollowTime);
			return this;
		}
		
		/**
		 * 设置 成交状态
		 * @param transactionStatus 成交状态
		 * @return 当前对象
		*/
		public CrmCustomer setTransactionStatus(String transactionStatus) {
			super.change(TRANSACTION_STATUS,super.getTransactionStatus(),transactionStatus);
			super.setTransactionStatus(transactionStatus);
			return this;
		}
		
		/**
		 * 设置 是否锁定
		 * @param locked 是否锁定
		 * @return 当前对象
		*/
		public CrmCustomer setLocked(String locked) {
			super.change(LOCKED,super.getLocked(),locked);
			super.setLocked(locked);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public CrmCustomer setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 客户位置
		 * @param rolePos 客户位置
		 * @return 当前对象
		*/
		public CrmCustomer setRolePos(String rolePos) {
			super.change(ROLE_POS,super.getRolePos(),rolePos);
			super.setRolePos(rolePos);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public CrmCustomer setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public CrmCustomer setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CrmCustomer setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CrmCustomer setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CrmCustomer setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CrmCustomer setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CrmCustomer setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CrmCustomer setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CrmCustomer setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public CrmCustomer setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 originator
		 * @param originator originator
		 * @return 当前对象
		*/
		public CrmCustomer setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 owner
		 * @param owner owner
		 * @return 当前对象
		*/
		public CrmCustomer setOwner(Employee owner) {
			super.change(OWNER,super.getOwner(),owner);
			super.setOwner(owner);
			return this;
		}
		
		/**
		 * 设置 crmCustomerLeaderList
		 * @param crmCustomerLeaderList crmCustomerLeaderList
		 * @return 当前对象
		*/
		public CrmCustomer setCrmCustomerLeaderList(List<CrmCustomerLeader> crmCustomerLeaderList) {
			super.change(CRM_CUSTOMER_LEADER_LIST,super.getCrmCustomerLeaderList(),crmCustomerLeaderList);
			super.setCrmCustomerLeaderList(crmCustomerLeaderList);
			return this;
		}
		
		/**
		 * 设置 crmCustomerBusinessList
		 * @param crmCustomerBusinessList crmCustomerBusinessList
		 * @return 当前对象
		*/
		public CrmCustomer setCrmCustomerBusinessList(List<CrmCustomerBusiness> crmCustomerBusinessList) {
			super.change(CRM_CUSTOMER_BUSINESS_LIST,super.getCrmCustomerBusinessList(),crmCustomerBusinessList);
			super.setCrmCustomerBusinessList(crmCustomerBusinessList);
			return this;
		}
		
		/**
		 * 设置 crmCustomerContactList
		 * @param crmCustomerContactList crmCustomerContactList
		 * @return 当前对象
		*/
		public CrmCustomer setCrmCustomerContactList(List<CrmCustomerContact> crmCustomerContactList) {
			super.change(CRM_CUSTOMER_CONTACT_LIST,super.getCrmCustomerContactList(),crmCustomerContactList);
			super.setCrmCustomerContactList(crmCustomerContactList);
			return this;
		}
		
		/**
		 * 设置 crmCustomerReviewList
		 * @param crmCustomerReviewList crmCustomerReviewList
		 * @return 当前对象
		*/
		public CrmCustomer setCrmCustomerReviewList(List<CrmCustomerReview> crmCustomerReviewList) {
			super.change(CRM_CUSTOMER_REVIEW_LIST,super.getCrmCustomerReviewList(),crmCustomerReviewList);
			super.setCrmCustomerReviewList(crmCustomerReviewList);
			return this;
		}
		
		/**
		 * 设置 crmCustomerRecordList
		 * @param crmCustomerRecordList crmCustomerRecordList
		 * @return 当前对象
		*/
		public CrmCustomer setCrmCustomerRecordList(List<CrmCustomerRecord> crmCustomerRecordList) {
			super.change(CRM_CUSTOMER_RECORD_LIST,super.getCrmCustomerRecordList(),crmCustomerRecordList);
			super.setCrmCustomerRecordList(crmCustomerRecordList);
			return this;
		}
		
		/**
		 * 设置 crmCustomerFollowList
		 * @param crmCustomerFollowList crmCustomerFollowList
		 * @return 当前对象
		*/
		public CrmCustomer setCrmCustomerFollowList(List<CrmCustomerFollow> crmCustomerFollowList) {
			super.change(CRM_CUSTOMER_FOLLOW_LIST,super.getCrmCustomerFollowList(),crmCustomerFollowList);
			super.setCrmCustomerFollowList(crmCustomerFollowList);
			return this;
		}
		
		/**
		 * 设置 crmFirstCustomerContact
		 * @param crmFirstCustomerContact crmFirstCustomerContact
		 * @return 当前对象
		*/
		public CrmCustomer setCrmFirstCustomerContact(CrmCustomerContact crmFirstCustomerContact) {
			super.change(CRM_FIRST_CUSTOMER_CONTACT,super.getCrmFirstCustomerContact(),crmFirstCustomerContact);
			super.setCrmFirstCustomerContact(crmFirstCustomerContact);
			return this;
		}
		
		/**
		 * 设置 crmCustomerIndustry
		 * @param crmCustomerIndustry crmCustomerIndustry
		 * @return 当前对象
		*/
		public CrmCustomer setCrmCustomerIndustry(CrmCustomerIndustry crmCustomerIndustry) {
			super.change(CRM_CUSTOMER_INDUSTRY,super.getCrmCustomerIndustry(),crmCustomerIndustry);
			super.setCrmCustomerIndustry(crmCustomerIndustry);
			return this;
		}
		
		/**
		 * 设置 crmCustomerIntentional
		 * @param crmCustomerIntentional crmCustomerIntentional
		 * @return 当前对象
		*/
		public CrmCustomer setCrmCustomerIntentional(CrmCustomerIntentional crmCustomerIntentional) {
			super.change(CRM_CUSTOMER_INTENTIONAL,super.getCrmCustomerIntentional(),crmCustomerIntentional);
			super.setCrmCustomerIntentional(crmCustomerIntentional);
			return this;
		}
		
		/**
		 * 设置 crmCustomerLevel
		 * @param crmCustomerLevel crmCustomerLevel
		 * @return 当前对象
		*/
		public CrmCustomer setCrmCustomerLevel(CrmCustomerLevel crmCustomerLevel) {
			super.change(CRM_CUSTOMER_LEVEL,super.getCrmCustomerLevel(),crmCustomerLevel);
			super.setCrmCustomerLevel(crmCustomerLevel);
			return this;
		}
		
		/**
		 * 设置 crmCustomerSource
		 * @param crmCustomerSource crmCustomerSource
		 * @return 当前对象
		*/
		public CrmCustomer setCrmCustomerSource(CrmCustomerSource crmCustomerSource) {
			super.change(CRM_CUSTOMER_SOURCE,super.getCrmCustomerSource(),crmCustomerSource);
			super.setCrmCustomerSource(crmCustomerSource);
			return this;
		}
		
		/**
		 * 设置 searchCustomerType
		 * @param searchCustomerType searchCustomerType
		 * @return 当前对象
		*/
		public CrmCustomer setSearchCustomerType(String searchCustomerType) {
			super.change(SEARCH_CUSTOMER_TYPE,super.getSearchCustomerType(),searchCustomerType);
			super.setSearchCustomerType(searchCustomerType);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CrmCustomer clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CrmCustomer duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setSourceId(this.getSourceId());
			inst.setCode(this.getCode());
			inst.setNotes(this.getNotes());
			inst.setContactInfo(this.getContactInfo());
			inst.setOwnerId(this.getOwnerId());
			inst.setIndustryId(this.getIndustryId());
			inst.setNextFollowTime(this.getNextFollowTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setId(this.getId());
			inst.setOriginatorId(this.getOriginatorId());
			inst.setLocked(this.getLocked());
			inst.setWebsite(this.getWebsite());
			inst.setAddress(this.getAddress());
			inst.setLevel(this.getLevel());
			inst.setIntentionalState(this.getIntentionalState());
			inst.setTransactionStatus(this.getTransactionStatus());
			inst.setProfile(this.getProfile());
			inst.setRecentFollowTime(this.getRecentFollowTime());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setRolePos(this.getRolePos());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setContacts(this.getContacts());
			if(all) {
				inst.setOwner(this.getOwner());
				inst.setCrmCustomerReviewList(this.getCrmCustomerReviewList());
				inst.setOriginator(this.getOriginator());
				inst.setCrmCustomerSource(this.getCrmCustomerSource());
				inst.setCrmCustomerRecordList(this.getCrmCustomerRecordList());
				inst.setCrmCustomerFollowList(this.getCrmCustomerFollowList());
				inst.setCrmCustomerBusinessList(this.getCrmCustomerBusinessList());
				inst.setCrmCustomerIndustry(this.getCrmCustomerIndustry());
				inst.setCrmFirstCustomerContact(this.getCrmFirstCustomerContact());
				inst.setCrmCustomerIntentional(this.getCrmCustomerIntentional());
				inst.setCrmCustomerLevel(this.getCrmCustomerLevel());
				inst.setSearchCustomerType(this.getSearchCustomerType());
				inst.setCrmCustomerContactList(this.getCrmCustomerContactList());
				inst.setCrmCustomerLeaderList(this.getCrmCustomerLeaderList());
			}
			inst.clearModifies();
			return inst;
		}

	}
}