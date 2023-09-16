package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_CRM_CUSTOMER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.oa.meta.CrmCustomerMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 客户
 * <p>客户 , 数据表 oa_crm_customer 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-16 20:34:49
 * @sign 14C2002AEA05D7635F2AA8E945AEAB2C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_crm_customer")
@ApiModel(description = "客户 ; 客户 , 数据表 oa_crm_customer 的PO类型")
public class CrmCustomer extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_CRM_CUSTOMER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "754655093655076864")
	private String id;
	
	/**
	 * 客户编码：客户编码
	*/
	@ApiModelProperty(required = false,value="客户编码" , notes = "客户编码")
	private String code;
	
	/**
	 * 客户名称：客户名称
	*/
	@ApiModelProperty(required = false,value="客户名称" , notes = "客户名称" , example = "1212")
	private String name;
	
	/**
	 * 客户等级：客户等级
	*/
	@ApiModelProperty(required = false,value="客户等级" , notes = "客户等级" , example = "754282729792602112")
	private String level;
	
	/**
	 * 负责人：负责人
	*/
	@ApiModelProperty(required = false,value="负责人" , notes = "负责人")
	private String ownerId;
	
	/**
	 * 意向状态：意向状态
	*/
	@ApiModelProperty(required = false,value="意向状态" , notes = "意向状态" , example = "754291688482013184")
	private String intentionalState;
	
	/**
	 * 联系人：联系人
	*/
	@ApiModelProperty(required = false,value="联系人" , notes = "联系人")
	private String contacts;
	
	/**
	 * 联系方式：联系方式
	*/
	@ApiModelProperty(required = false,value="联系方式" , notes = "联系方式")
	private String contactInfo;
	
	/**
	 * 网址：网址
	*/
	@ApiModelProperty(required = false,value="网址" , notes = "网址" , example = "12")
	private String website;
	
	/**
	 * 所在行业：所在行业
	*/
	@ApiModelProperty(required = false,value="所在行业" , notes = "所在行业" , example = "754282104157634561")
	private String industryId;
	
	/**
	 * 客户介绍：客户介绍
	*/
	@ApiModelProperty(required = false,value="客户介绍" , notes = "客户介绍" , example = "12")
	private String profile;
	
	/**
	 * 客户来源：客户来源
	*/
	@ApiModelProperty(required = false,value="客户来源" , notes = "客户来源" , example = "754282314632003585")
	private String sourceId;
	
	/**
	 * 客户地址：客户地址
	*/
	@ApiModelProperty(required = false,value="客户地址" , notes = "客户地址" , example = "12")
	private String address;
	
	/**
	 * 最近跟进：最近跟进
	*/
	@ApiModelProperty(required = false,value="最近跟进" , notes = "最近跟进")
	private Date recentFollowTime;
	
	/**
	 * 下次跟进：下次跟进
	*/
	@ApiModelProperty(required = false,value="下次跟进" , notes = "下次跟进")
	private Date nextFollowTime;
	
	/**
	 * 成交状态：成交状态
	*/
	@ApiModelProperty(required = false,value="成交状态" , notes = "成交状态")
	private String transactionStatus;
	
	/**
	 * 是否锁定：lcoked|unlock
	*/
	@ApiModelProperty(required = false,value="是否锁定" , notes = "lcoked|unlock")
	private String locked;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "1212")
	private String notes;
	
	/**
	 * 客户位置：客户位置
	*/
	@ApiModelProperty(required = false,value="客户位置" , notes = "客户位置" , example = "invalid")
	private String rolePos;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本" , example = "1")
	private Integer version;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-09-14 10:49:55")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-09-15 08:59:49")
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
	 * originator：originator
	*/
	@ApiModelProperty(required = false,value="originator" , notes = "originator")
	private Employee originator;
	
	/**
	 * owner：owner
	*/
	@ApiModelProperty(required = false,value="owner" , notes = "owner")
	private Employee owner;
	
	/**
	 * crmCustomerLeaderList：crmCustomerLeaderList
	*/
	@ApiModelProperty(required = false,value="crmCustomerLeaderList" , notes = "crmCustomerLeaderList")
	private List<CrmCustomerLeader> crmCustomerLeaderList;
	
	/**
	 * crmCustomerBusinessList：crmCustomerLeaderList
	*/
	@ApiModelProperty(required = false,value="crmCustomerBusinessList" , notes = "crmCustomerLeaderList")
	private List<CrmCustomerBusiness> crmCustomerBusinessList;
	
	/**
	 * crmCustomerContactList：crmCustomerLeaderList
	*/
	@ApiModelProperty(required = false,value="crmCustomerContactList" , notes = "crmCustomerLeaderList")
	private List<CrmCustomerContact> crmCustomerContactList;
	
	/**
	 * crmCustomerReviewList：crmCustomerReviewList
	*/
	@ApiModelProperty(required = false,value="crmCustomerReviewList" , notes = "crmCustomerReviewList")
	private List<CrmCustomerReview> crmCustomerReviewList;
	
	/**
	 * crmCustomerRecordList：crmCustomerRecordList
	*/
	@ApiModelProperty(required = false,value="crmCustomerRecordList" , notes = "crmCustomerRecordList")
	private List<CrmCustomerRecord> crmCustomerRecordList;
	
	/**
	 * crmCustomerFollowList：crmCustomerRecordList
	*/
	@ApiModelProperty(required = false,value="crmCustomerFollowList" , notes = "crmCustomerRecordList")
	private List<CrmCustomerFollow> crmCustomerFollowList;
	
	/**
	 * crmFirstCustomerContact：crmFirstCustomerContact
	*/
	@ApiModelProperty(required = false,value="crmFirstCustomerContact" , notes = "crmFirstCustomerContact")
	private CrmCustomerContact crmFirstCustomerContact;
	
	/**
	 * crmCustomerIndustry：crmCustomerIndustry
	*/
	@ApiModelProperty(required = false,value="crmCustomerIndustry" , notes = "crmCustomerIndustry")
	private CrmCustomerIndustry crmCustomerIndustry;
	
	/**
	 * crmCustomerIntentional：crmCustomerIntentional
	*/
	@ApiModelProperty(required = false,value="crmCustomerIntentional" , notes = "crmCustomerIntentional")
	private CrmCustomerIntentional crmCustomerIntentional;
	
	/**
	 * crmCustomerLevel：crmCustomerLevel
	*/
	@ApiModelProperty(required = false,value="crmCustomerLevel" , notes = "crmCustomerLevel")
	private CrmCustomerLevel crmCustomerLevel;
	
	/**
	 * crmCustomerSource：crmCustomerSource
	*/
	@ApiModelProperty(required = false,value="crmCustomerSource" , notes = "crmCustomerSource")
	private CrmCustomerSource crmCustomerSource;
	
	/**
	 * searchCustomerType：searchCustomerType
	*/
	@ApiModelProperty(required = false,value="searchCustomerType" , notes = "searchCustomerType")
	private String searchCustomerType;
	
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
	public CrmCustomer setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 客户编码<br>
	 * 客户编码
	 * @return 客户编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 客户编码
	 * @param code 客户编码
	 * @return 当前对象
	*/
	public CrmCustomer setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 客户名称<br>
	 * 客户名称
	 * @return 客户名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 客户名称
	 * @param name 客户名称
	 * @return 当前对象
	*/
	public CrmCustomer setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 客户等级<br>
	 * 客户等级
	 * @return 客户等级
	*/
	public String getLevel() {
		return level;
	}
	
	/**
	 * 设置 客户等级
	 * @param level 客户等级
	 * @return 当前对象
	*/
	public CrmCustomer setLevel(String level) {
		this.level=level;
		return this;
	}
	
	/**
	 * 获得 负责人<br>
	 * 负责人
	 * @return 负责人
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 负责人
	 * @param ownerId 负责人
	 * @return 当前对象
	*/
	public CrmCustomer setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 意向状态<br>
	 * 意向状态
	 * @return 意向状态
	*/
	public String getIntentionalState() {
		return intentionalState;
	}
	
	/**
	 * 设置 意向状态
	 * @param intentionalState 意向状态
	 * @return 当前对象
	*/
	public CrmCustomer setIntentionalState(String intentionalState) {
		this.intentionalState=intentionalState;
		return this;
	}
	
	/**
	 * 获得 联系人<br>
	 * 联系人
	 * @return 联系人
	*/
	public String getContacts() {
		return contacts;
	}
	
	/**
	 * 设置 联系人
	 * @param contacts 联系人
	 * @return 当前对象
	*/
	public CrmCustomer setContacts(String contacts) {
		this.contacts=contacts;
		return this;
	}
	
	/**
	 * 获得 联系方式<br>
	 * 联系方式
	 * @return 联系方式
	*/
	public String getContactInfo() {
		return contactInfo;
	}
	
	/**
	 * 设置 联系方式
	 * @param contactInfo 联系方式
	 * @return 当前对象
	*/
	public CrmCustomer setContactInfo(String contactInfo) {
		this.contactInfo=contactInfo;
		return this;
	}
	
	/**
	 * 获得 网址<br>
	 * 网址
	 * @return 网址
	*/
	public String getWebsite() {
		return website;
	}
	
	/**
	 * 设置 网址
	 * @param website 网址
	 * @return 当前对象
	*/
	public CrmCustomer setWebsite(String website) {
		this.website=website;
		return this;
	}
	
	/**
	 * 获得 所在行业<br>
	 * 所在行业
	 * @return 所在行业
	*/
	public String getIndustryId() {
		return industryId;
	}
	
	/**
	 * 设置 所在行业
	 * @param industryId 所在行业
	 * @return 当前对象
	*/
	public CrmCustomer setIndustryId(String industryId) {
		this.industryId=industryId;
		return this;
	}
	
	/**
	 * 获得 客户介绍<br>
	 * 客户介绍
	 * @return 客户介绍
	*/
	public String getProfile() {
		return profile;
	}
	
	/**
	 * 设置 客户介绍
	 * @param profile 客户介绍
	 * @return 当前对象
	*/
	public CrmCustomer setProfile(String profile) {
		this.profile=profile;
		return this;
	}
	
	/**
	 * 获得 客户来源<br>
	 * 客户来源
	 * @return 客户来源
	*/
	public String getSourceId() {
		return sourceId;
	}
	
	/**
	 * 设置 客户来源
	 * @param sourceId 客户来源
	 * @return 当前对象
	*/
	public CrmCustomer setSourceId(String sourceId) {
		this.sourceId=sourceId;
		return this;
	}
	
	/**
	 * 获得 客户地址<br>
	 * 客户地址
	 * @return 客户地址
	*/
	public String getAddress() {
		return address;
	}
	
	/**
	 * 设置 客户地址
	 * @param address 客户地址
	 * @return 当前对象
	*/
	public CrmCustomer setAddress(String address) {
		this.address=address;
		return this;
	}
	
	/**
	 * 获得 最近跟进<br>
	 * 最近跟进
	 * @return 最近跟进
	*/
	public Date getRecentFollowTime() {
		return recentFollowTime;
	}
	
	/**
	 * 设置 最近跟进
	 * @param recentFollowTime 最近跟进
	 * @return 当前对象
	*/
	public CrmCustomer setRecentFollowTime(Date recentFollowTime) {
		this.recentFollowTime=recentFollowTime;
		return this;
	}
	
	/**
	 * 获得 下次跟进<br>
	 * 下次跟进
	 * @return 下次跟进
	*/
	public Date getNextFollowTime() {
		return nextFollowTime;
	}
	
	/**
	 * 设置 下次跟进
	 * @param nextFollowTime 下次跟进
	 * @return 当前对象
	*/
	public CrmCustomer setNextFollowTime(Date nextFollowTime) {
		this.nextFollowTime=nextFollowTime;
		return this;
	}
	
	/**
	 * 获得 成交状态<br>
	 * 成交状态
	 * @return 成交状态
	*/
	public String getTransactionStatus() {
		return transactionStatus;
	}
	
	/**
	 * 设置 成交状态
	 * @param transactionStatus 成交状态
	 * @return 当前对象
	*/
	public CrmCustomer setTransactionStatus(String transactionStatus) {
		this.transactionStatus=transactionStatus;
		return this;
	}
	
	/**
	 * 获得 是否锁定<br>
	 * lcoked|unlock
	 * @return 是否锁定
	*/
	public String getLocked() {
		return locked;
	}
	
	/**
	 * 设置 是否锁定
	 * @param locked 是否锁定
	 * @return 当前对象
	*/
	public CrmCustomer setLocked(String locked) {
		this.locked=locked;
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
	public CrmCustomer setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 客户位置<br>
	 * 客户位置
	 * @return 客户位置
	*/
	public String getRolePos() {
		return rolePos;
	}
	
	/**
	 * 设置 客户位置
	 * @param rolePos 客户位置
	 * @return 当前对象
	*/
	public CrmCustomer setRolePos(String rolePos) {
		this.rolePos=rolePos;
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
	public CrmCustomer setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 版本
	 * @param version 版本
	 * @return 当前对象
	*/
	public CrmCustomer setVersion(Integer version) {
		this.version=version;
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
	public CrmCustomer setCreateBy(String createBy) {
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
	public CrmCustomer setCreateTime(Date createTime) {
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
	public CrmCustomer setUpdateBy(String updateBy) {
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
	public CrmCustomer setUpdateTime(Date updateTime) {
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
	public CrmCustomer setDeleted(Integer deleted) {
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
	public CrmCustomer setDeleted(Boolean deletedBool) {
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
	public CrmCustomer setDeleteBy(String deleteBy) {
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
	public CrmCustomer setDeleteTime(Date deleteTime) {
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
	public CrmCustomer setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 originator<br>
	 * originator
	 * @return originator
	*/
	public Employee getOriginator() {
		return originator;
	}
	
	/**
	 * 设置 originator
	 * @param originator originator
	 * @return 当前对象
	*/
	public CrmCustomer setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 owner<br>
	 * owner
	 * @return owner
	*/
	public Employee getOwner() {
		return owner;
	}
	
	/**
	 * 设置 owner
	 * @param owner owner
	 * @return 当前对象
	*/
	public CrmCustomer setOwner(Employee owner) {
		this.owner=owner;
		return this;
	}
	
	/**
	 * 获得 crmCustomerLeaderList<br>
	 * crmCustomerLeaderList
	 * @return crmCustomerLeaderList
	*/
	public List<CrmCustomerLeader> getCrmCustomerLeaderList() {
		return crmCustomerLeaderList;
	}
	
	/**
	 * 设置 crmCustomerLeaderList
	 * @param crmCustomerLeaderList crmCustomerLeaderList
	 * @return 当前对象
	*/
	public CrmCustomer setCrmCustomerLeaderList(List<CrmCustomerLeader> crmCustomerLeaderList) {
		this.crmCustomerLeaderList=crmCustomerLeaderList;
		return this;
	}
	
	/**
	 * 添加 crmCustomerLeaderList
	 * @param crmCustomerLeader crmCustomerLeaderList
	 * @return 当前对象
	*/
	public CrmCustomer addCrmCustomerLeader(CrmCustomerLeader... crmCustomerLeader) {
		if(this.crmCustomerLeaderList==null) crmCustomerLeaderList=new ArrayList<>();
		this.crmCustomerLeaderList.addAll(Arrays.asList(crmCustomerLeader));
		return this;
	}
	
	/**
	 * 获得 crmCustomerBusinessList<br>
	 * crmCustomerLeaderList
	 * @return crmCustomerBusinessList
	*/
	public List<CrmCustomerBusiness> getCrmCustomerBusinessList() {
		return crmCustomerBusinessList;
	}
	
	/**
	 * 设置 crmCustomerBusinessList
	 * @param crmCustomerBusinessList crmCustomerBusinessList
	 * @return 当前对象
	*/
	public CrmCustomer setCrmCustomerBusinessList(List<CrmCustomerBusiness> crmCustomerBusinessList) {
		this.crmCustomerBusinessList=crmCustomerBusinessList;
		return this;
	}
	
	/**
	 * 添加 crmCustomerBusinessList
	 * @param crmCustomerBusiness crmCustomerBusinessList
	 * @return 当前对象
	*/
	public CrmCustomer addCrmCustomerBusiness(CrmCustomerBusiness... crmCustomerBusiness) {
		if(this.crmCustomerBusinessList==null) crmCustomerBusinessList=new ArrayList<>();
		this.crmCustomerBusinessList.addAll(Arrays.asList(crmCustomerBusiness));
		return this;
	}
	
	/**
	 * 获得 crmCustomerContactList<br>
	 * crmCustomerLeaderList
	 * @return crmCustomerContactList
	*/
	public List<CrmCustomerContact> getCrmCustomerContactList() {
		return crmCustomerContactList;
	}
	
	/**
	 * 设置 crmCustomerContactList
	 * @param crmCustomerContactList crmCustomerContactList
	 * @return 当前对象
	*/
	public CrmCustomer setCrmCustomerContactList(List<CrmCustomerContact> crmCustomerContactList) {
		this.crmCustomerContactList=crmCustomerContactList;
		return this;
	}
	
	/**
	 * 添加 crmCustomerContactList
	 * @param crmCustomerContact crmCustomerContactList
	 * @return 当前对象
	*/
	public CrmCustomer addCrmCustomerContact(CrmCustomerContact... crmCustomerContact) {
		if(this.crmCustomerContactList==null) crmCustomerContactList=new ArrayList<>();
		this.crmCustomerContactList.addAll(Arrays.asList(crmCustomerContact));
		return this;
	}
	
	/**
	 * 获得 crmCustomerReviewList<br>
	 * crmCustomerReviewList
	 * @return crmCustomerReviewList
	*/
	public List<CrmCustomerReview> getCrmCustomerReviewList() {
		return crmCustomerReviewList;
	}
	
	/**
	 * 设置 crmCustomerReviewList
	 * @param crmCustomerReviewList crmCustomerReviewList
	 * @return 当前对象
	*/
	public CrmCustomer setCrmCustomerReviewList(List<CrmCustomerReview> crmCustomerReviewList) {
		this.crmCustomerReviewList=crmCustomerReviewList;
		return this;
	}
	
	/**
	 * 添加 crmCustomerReviewList
	 * @param crmCustomerReview crmCustomerReviewList
	 * @return 当前对象
	*/
	public CrmCustomer addCrmCustomerReview(CrmCustomerReview... crmCustomerReview) {
		if(this.crmCustomerReviewList==null) crmCustomerReviewList=new ArrayList<>();
		this.crmCustomerReviewList.addAll(Arrays.asList(crmCustomerReview));
		return this;
	}
	
	/**
	 * 获得 crmCustomerRecordList<br>
	 * crmCustomerRecordList
	 * @return crmCustomerRecordList
	*/
	public List<CrmCustomerRecord> getCrmCustomerRecordList() {
		return crmCustomerRecordList;
	}
	
	/**
	 * 设置 crmCustomerRecordList
	 * @param crmCustomerRecordList crmCustomerRecordList
	 * @return 当前对象
	*/
	public CrmCustomer setCrmCustomerRecordList(List<CrmCustomerRecord> crmCustomerRecordList) {
		this.crmCustomerRecordList=crmCustomerRecordList;
		return this;
	}
	
	/**
	 * 添加 crmCustomerRecordList
	 * @param crmCustomerRecord crmCustomerRecordList
	 * @return 当前对象
	*/
	public CrmCustomer addCrmCustomerRecord(CrmCustomerRecord... crmCustomerRecord) {
		if(this.crmCustomerRecordList==null) crmCustomerRecordList=new ArrayList<>();
		this.crmCustomerRecordList.addAll(Arrays.asList(crmCustomerRecord));
		return this;
	}
	
	/**
	 * 获得 crmCustomerFollowList<br>
	 * crmCustomerRecordList
	 * @return crmCustomerFollowList
	*/
	public List<CrmCustomerFollow> getCrmCustomerFollowList() {
		return crmCustomerFollowList;
	}
	
	/**
	 * 设置 crmCustomerFollowList
	 * @param crmCustomerFollowList crmCustomerFollowList
	 * @return 当前对象
	*/
	public CrmCustomer setCrmCustomerFollowList(List<CrmCustomerFollow> crmCustomerFollowList) {
		this.crmCustomerFollowList=crmCustomerFollowList;
		return this;
	}
	
	/**
	 * 添加 crmCustomerFollowList
	 * @param crmCustomerFollow crmCustomerFollowList
	 * @return 当前对象
	*/
	public CrmCustomer addCrmCustomerFollow(CrmCustomerFollow... crmCustomerFollow) {
		if(this.crmCustomerFollowList==null) crmCustomerFollowList=new ArrayList<>();
		this.crmCustomerFollowList.addAll(Arrays.asList(crmCustomerFollow));
		return this;
	}
	
	/**
	 * 获得 crmFirstCustomerContact<br>
	 * crmFirstCustomerContact
	 * @return crmFirstCustomerContact
	*/
	public CrmCustomerContact getCrmFirstCustomerContact() {
		return crmFirstCustomerContact;
	}
	
	/**
	 * 设置 crmFirstCustomerContact
	 * @param crmFirstCustomerContact crmFirstCustomerContact
	 * @return 当前对象
	*/
	public CrmCustomer setCrmFirstCustomerContact(CrmCustomerContact crmFirstCustomerContact) {
		this.crmFirstCustomerContact=crmFirstCustomerContact;
		return this;
	}
	
	/**
	 * 获得 crmCustomerIndustry<br>
	 * crmCustomerIndustry
	 * @return crmCustomerIndustry
	*/
	public CrmCustomerIndustry getCrmCustomerIndustry() {
		return crmCustomerIndustry;
	}
	
	/**
	 * 设置 crmCustomerIndustry
	 * @param crmCustomerIndustry crmCustomerIndustry
	 * @return 当前对象
	*/
	public CrmCustomer setCrmCustomerIndustry(CrmCustomerIndustry crmCustomerIndustry) {
		this.crmCustomerIndustry=crmCustomerIndustry;
		return this;
	}
	
	/**
	 * 获得 crmCustomerIntentional<br>
	 * crmCustomerIntentional
	 * @return crmCustomerIntentional
	*/
	public CrmCustomerIntentional getCrmCustomerIntentional() {
		return crmCustomerIntentional;
	}
	
	/**
	 * 设置 crmCustomerIntentional
	 * @param crmCustomerIntentional crmCustomerIntentional
	 * @return 当前对象
	*/
	public CrmCustomer setCrmCustomerIntentional(CrmCustomerIntentional crmCustomerIntentional) {
		this.crmCustomerIntentional=crmCustomerIntentional;
		return this;
	}
	
	/**
	 * 获得 crmCustomerLevel<br>
	 * crmCustomerLevel
	 * @return crmCustomerLevel
	*/
	public CrmCustomerLevel getCrmCustomerLevel() {
		return crmCustomerLevel;
	}
	
	/**
	 * 设置 crmCustomerLevel
	 * @param crmCustomerLevel crmCustomerLevel
	 * @return 当前对象
	*/
	public CrmCustomer setCrmCustomerLevel(CrmCustomerLevel crmCustomerLevel) {
		this.crmCustomerLevel=crmCustomerLevel;
		return this;
	}
	
	/**
	 * 获得 crmCustomerSource<br>
	 * crmCustomerSource
	 * @return crmCustomerSource
	*/
	public CrmCustomerSource getCrmCustomerSource() {
		return crmCustomerSource;
	}
	
	/**
	 * 设置 crmCustomerSource
	 * @param crmCustomerSource crmCustomerSource
	 * @return 当前对象
	*/
	public CrmCustomer setCrmCustomerSource(CrmCustomerSource crmCustomerSource) {
		this.crmCustomerSource=crmCustomerSource;
		return this;
	}
	
	/**
	 * 获得 searchCustomerType<br>
	 * searchCustomerType
	 * @return searchCustomerType
	*/
	public String getSearchCustomerType() {
		return searchCustomerType;
	}
	
	/**
	 * 设置 searchCustomerType
	 * @param searchCustomerType searchCustomerType
	 * @return 当前对象
	*/
	public CrmCustomer setSearchCustomerType(String searchCustomerType) {
		this.searchCustomerType=searchCustomerType;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CrmCustomer , 转换好的 CrmCustomer 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CrmCustomer , 转换好的 PoJo 对象
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
	public CrmCustomer clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CrmCustomer duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.CrmCustomerMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.CrmCustomerMeta.$$proxy$$();
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

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CrmCustomer clone(boolean deep) {
		return EntityContext.clone(CrmCustomer.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CrmCustomer
	 * @param crmCustomerMap 包含实体信息的 Map 对象
	 * @return CrmCustomer , 转换好的的 CrmCustomer 对象
	*/
	@Transient
	public static CrmCustomer createFrom(Map<String,Object> crmCustomerMap) {
		if(crmCustomerMap==null) return null;
		CrmCustomer po = create();
		EntityContext.copyProperties(po,crmCustomerMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CrmCustomer
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CrmCustomer , 转换好的的 CrmCustomer 对象
	*/
	@Transient
	public static CrmCustomer createFrom(Object pojo) {
		if(pojo==null) return null;
		CrmCustomer po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CrmCustomer，等同于 new
	 * @return CrmCustomer 对象
	*/
	@Transient
	public static CrmCustomer create() {
		return new com.dt.platform.domain.oa.meta.CrmCustomerMeta.$$proxy$$();
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
			this.setSourceId(DataParser.parse(String.class, map.get(CrmCustomerMeta.SOURCE_ID)));
			this.setCode(DataParser.parse(String.class, map.get(CrmCustomerMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(CrmCustomerMeta.NOTES)));
			this.setContactInfo(DataParser.parse(String.class, map.get(CrmCustomerMeta.CONTACT_INFO)));
			this.setOwnerId(DataParser.parse(String.class, map.get(CrmCustomerMeta.OWNER_ID)));
			this.setIndustryId(DataParser.parse(String.class, map.get(CrmCustomerMeta.INDUSTRY_ID)));
			this.setNextFollowTime(DataParser.parse(Date.class, map.get(CrmCustomerMeta.NEXT_FOLLOW_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CrmCustomerMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CrmCustomerMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(CrmCustomerMeta.ORIGINATOR_ID)));
			this.setLocked(DataParser.parse(String.class, map.get(CrmCustomerMeta.LOCKED)));
			this.setWebsite(DataParser.parse(String.class, map.get(CrmCustomerMeta.WEBSITE)));
			this.setAddress(DataParser.parse(String.class, map.get(CrmCustomerMeta.ADDRESS)));
			this.setLevel(DataParser.parse(String.class, map.get(CrmCustomerMeta.LEVEL)));
			this.setIntentionalState(DataParser.parse(String.class, map.get(CrmCustomerMeta.INTENTIONAL_STATE)));
			this.setTransactionStatus(DataParser.parse(String.class, map.get(CrmCustomerMeta.TRANSACTION_STATUS)));
			this.setProfile(DataParser.parse(String.class, map.get(CrmCustomerMeta.PROFILE)));
			this.setRecentFollowTime(DataParser.parse(Date.class, map.get(CrmCustomerMeta.RECENT_FOLLOW_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CrmCustomerMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CrmCustomerMeta.VERSION)));
			this.setRolePos(DataParser.parse(String.class, map.get(CrmCustomerMeta.ROLE_POS)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CrmCustomerMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CrmCustomerMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CrmCustomerMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CrmCustomerMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(CrmCustomerMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(CrmCustomerMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CrmCustomerMeta.DELETE_BY)));
			this.setContacts(DataParser.parse(String.class, map.get(CrmCustomerMeta.CONTACTS)));
			// others
			this.setOwner(DataParser.parse(Employee.class, map.get(CrmCustomerMeta.OWNER)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(CrmCustomerMeta.ORIGINATOR)));
			this.setCrmCustomerSource(DataParser.parse(CrmCustomerSource.class, map.get(CrmCustomerMeta.CRM_CUSTOMER_SOURCE)));
			this.setCrmCustomerIndustry(DataParser.parse(CrmCustomerIndustry.class, map.get(CrmCustomerMeta.CRM_CUSTOMER_INDUSTRY)));
			this.setCrmFirstCustomerContact(DataParser.parse(CrmCustomerContact.class, map.get(CrmCustomerMeta.CRM_FIRST_CUSTOMER_CONTACT)));
			this.setCrmCustomerIntentional(DataParser.parse(CrmCustomerIntentional.class, map.get(CrmCustomerMeta.CRM_CUSTOMER_INTENTIONAL)));
			this.setCrmCustomerLevel(DataParser.parse(CrmCustomerLevel.class, map.get(CrmCustomerMeta.CRM_CUSTOMER_LEVEL)));
			this.setSearchCustomerType(DataParser.parse(String.class, map.get(CrmCustomerMeta.SEARCH_CUSTOMER_TYPE)));
			return true;
		} else {
			try {
				this.setSourceId( (String)map.get(CrmCustomerMeta.SOURCE_ID));
				this.setCode( (String)map.get(CrmCustomerMeta.CODE));
				this.setNotes( (String)map.get(CrmCustomerMeta.NOTES));
				this.setContactInfo( (String)map.get(CrmCustomerMeta.CONTACT_INFO));
				this.setOwnerId( (String)map.get(CrmCustomerMeta.OWNER_ID));
				this.setIndustryId( (String)map.get(CrmCustomerMeta.INDUSTRY_ID));
				this.setNextFollowTime( (Date)map.get(CrmCustomerMeta.NEXT_FOLLOW_TIME));
				this.setUpdateBy( (String)map.get(CrmCustomerMeta.UPDATE_BY));
				this.setId( (String)map.get(CrmCustomerMeta.ID));
				this.setOriginatorId( (String)map.get(CrmCustomerMeta.ORIGINATOR_ID));
				this.setLocked( (String)map.get(CrmCustomerMeta.LOCKED));
				this.setWebsite( (String)map.get(CrmCustomerMeta.WEBSITE));
				this.setAddress( (String)map.get(CrmCustomerMeta.ADDRESS));
				this.setLevel( (String)map.get(CrmCustomerMeta.LEVEL));
				this.setIntentionalState( (String)map.get(CrmCustomerMeta.INTENTIONAL_STATE));
				this.setTransactionStatus( (String)map.get(CrmCustomerMeta.TRANSACTION_STATUS));
				this.setProfile( (String)map.get(CrmCustomerMeta.PROFILE));
				this.setRecentFollowTime( (Date)map.get(CrmCustomerMeta.RECENT_FOLLOW_TIME));
				this.setUpdateTime( (Date)map.get(CrmCustomerMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(CrmCustomerMeta.VERSION));
				this.setRolePos( (String)map.get(CrmCustomerMeta.ROLE_POS));
				this.setCreateBy( (String)map.get(CrmCustomerMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CrmCustomerMeta.DELETED));
				this.setCreateTime( (Date)map.get(CrmCustomerMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(CrmCustomerMeta.DELETE_TIME));
				this.setName( (String)map.get(CrmCustomerMeta.NAME));
				this.setTenantId( (String)map.get(CrmCustomerMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CrmCustomerMeta.DELETE_BY));
				this.setContacts( (String)map.get(CrmCustomerMeta.CONTACTS));
				// others
				this.setOwner( (Employee)map.get(CrmCustomerMeta.OWNER));
				this.setOriginator( (Employee)map.get(CrmCustomerMeta.ORIGINATOR));
				this.setCrmCustomerSource( (CrmCustomerSource)map.get(CrmCustomerMeta.CRM_CUSTOMER_SOURCE));
				this.setCrmCustomerIndustry( (CrmCustomerIndustry)map.get(CrmCustomerMeta.CRM_CUSTOMER_INDUSTRY));
				this.setCrmFirstCustomerContact( (CrmCustomerContact)map.get(CrmCustomerMeta.CRM_FIRST_CUSTOMER_CONTACT));
				this.setCrmCustomerIntentional( (CrmCustomerIntentional)map.get(CrmCustomerMeta.CRM_CUSTOMER_INTENTIONAL));
				this.setCrmCustomerLevel( (CrmCustomerLevel)map.get(CrmCustomerMeta.CRM_CUSTOMER_LEVEL));
				this.setSearchCustomerType( (String)map.get(CrmCustomerMeta.SEARCH_CUSTOMER_TYPE));
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
			this.setSourceId(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.SOURCE_ID)));
			this.setCode(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.NOTES)));
			this.setContactInfo(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.CONTACT_INFO)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.OWNER_ID)));
			this.setIndustryId(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.INDUSTRY_ID)));
			this.setNextFollowTime(DataParser.parse(Date.class, r.getValue(CrmCustomerMeta.NEXT_FOLLOW_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.ORIGINATOR_ID)));
			this.setLocked(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.LOCKED)));
			this.setWebsite(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.WEBSITE)));
			this.setAddress(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.ADDRESS)));
			this.setLevel(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.LEVEL)));
			this.setIntentionalState(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.INTENTIONAL_STATE)));
			this.setTransactionStatus(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.TRANSACTION_STATUS)));
			this.setProfile(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.PROFILE)));
			this.setRecentFollowTime(DataParser.parse(Date.class, r.getValue(CrmCustomerMeta.RECENT_FOLLOW_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CrmCustomerMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CrmCustomerMeta.VERSION)));
			this.setRolePos(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.ROLE_POS)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CrmCustomerMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CrmCustomerMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CrmCustomerMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.DELETE_BY)));
			this.setContacts(DataParser.parse(String.class, r.getValue(CrmCustomerMeta.CONTACTS)));
			return true;
		} else {
			try {
				this.setSourceId( (String)r.getValue(CrmCustomerMeta.SOURCE_ID));
				this.setCode( (String)r.getValue(CrmCustomerMeta.CODE));
				this.setNotes( (String)r.getValue(CrmCustomerMeta.NOTES));
				this.setContactInfo( (String)r.getValue(CrmCustomerMeta.CONTACT_INFO));
				this.setOwnerId( (String)r.getValue(CrmCustomerMeta.OWNER_ID));
				this.setIndustryId( (String)r.getValue(CrmCustomerMeta.INDUSTRY_ID));
				this.setNextFollowTime( (Date)r.getValue(CrmCustomerMeta.NEXT_FOLLOW_TIME));
				this.setUpdateBy( (String)r.getValue(CrmCustomerMeta.UPDATE_BY));
				this.setId( (String)r.getValue(CrmCustomerMeta.ID));
				this.setOriginatorId( (String)r.getValue(CrmCustomerMeta.ORIGINATOR_ID));
				this.setLocked( (String)r.getValue(CrmCustomerMeta.LOCKED));
				this.setWebsite( (String)r.getValue(CrmCustomerMeta.WEBSITE));
				this.setAddress( (String)r.getValue(CrmCustomerMeta.ADDRESS));
				this.setLevel( (String)r.getValue(CrmCustomerMeta.LEVEL));
				this.setIntentionalState( (String)r.getValue(CrmCustomerMeta.INTENTIONAL_STATE));
				this.setTransactionStatus( (String)r.getValue(CrmCustomerMeta.TRANSACTION_STATUS));
				this.setProfile( (String)r.getValue(CrmCustomerMeta.PROFILE));
				this.setRecentFollowTime( (Date)r.getValue(CrmCustomerMeta.RECENT_FOLLOW_TIME));
				this.setUpdateTime( (Date)r.getValue(CrmCustomerMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(CrmCustomerMeta.VERSION));
				this.setRolePos( (String)r.getValue(CrmCustomerMeta.ROLE_POS));
				this.setCreateBy( (String)r.getValue(CrmCustomerMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CrmCustomerMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CrmCustomerMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(CrmCustomerMeta.DELETE_TIME));
				this.setName( (String)r.getValue(CrmCustomerMeta.NAME));
				this.setTenantId( (String)r.getValue(CrmCustomerMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CrmCustomerMeta.DELETE_BY));
				this.setContacts( (String)r.getValue(CrmCustomerMeta.CONTACTS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}