package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_CRM_CUSTOMER_LEADS;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.oa.meta.CrmCustomerLeadsMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 线索
 * <p>线索 , 数据表 oa_crm_customer_leads 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-16 20:35:14
 * @sign 625D12EAE52CAF81B8FAA14AC483249D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_crm_customer_leads")
@ApiModel(description = "线索 ; 线索 , 数据表 oa_crm_customer_leads 的PO类型")
public class CrmCustomerLeads extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_CRM_CUSTOMER_LEADS.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "754655419074347008")
	private String id;
	
	/**
	 * 客户名称：客户名称
	*/
	@ApiModelProperty(required = false,value="客户名称" , notes = "客户名称" , example = "12")
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
	 * 客户来源：客户来源
	*/
	@ApiModelProperty(required = false,value="客户来源" , notes = "客户来源" , example = "754282314632003585")
	private String sourceId;
	
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
	 * 所在行业：所在行业
	*/
	@ApiModelProperty(required = false,value="所在行业" , notes = "所在行业" , example = "754282104157634561")
	private String industryId;
	
	/**
	 * 网址：网址
	*/
	@ApiModelProperty(required = false,value="网址" , notes = "网址" , example = "12")
	private String website;
	
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
	 * 客户地址：客户地址
	*/
	@ApiModelProperty(required = false,value="客户地址" , notes = "客户地址" , example = "12")
	private String address;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "1212")
	private String notes;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-09-14 10:51:13")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * crmCustomer：crmCustomer
	*/
	@ApiModelProperty(required = false,value="crmCustomer" , notes = "crmCustomer")
	private CrmCustomer crmCustomer;
	
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
	public CrmCustomerLeads setId(String id) {
		this.id=id;
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
	public CrmCustomerLeads setName(String name) {
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
	public CrmCustomerLeads setLevel(String level) {
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
	public CrmCustomerLeads setOwnerId(String ownerId) {
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
	public CrmCustomerLeads setIntentionalState(String intentionalState) {
		this.intentionalState=intentionalState;
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
	public CrmCustomerLeads setSourceId(String sourceId) {
		this.sourceId=sourceId;
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
	public CrmCustomerLeads setContacts(String contacts) {
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
	public CrmCustomerLeads setContactInfo(String contactInfo) {
		this.contactInfo=contactInfo;
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
	public CrmCustomerLeads setIndustryId(String industryId) {
		this.industryId=industryId;
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
	public CrmCustomerLeads setWebsite(String website) {
		this.website=website;
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
	public CrmCustomerLeads setRecentFollowTime(Date recentFollowTime) {
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
	public CrmCustomerLeads setNextFollowTime(Date nextFollowTime) {
		this.nextFollowTime=nextFollowTime;
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
	public CrmCustomerLeads setAddress(String address) {
		this.address=address;
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
	public CrmCustomerLeads setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
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
	public CrmCustomerLeads setNotes(String notes) {
		this.notes=notes;
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
	public CrmCustomerLeads setVersion(Integer version) {
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
	public CrmCustomerLeads setCreateBy(String createBy) {
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
	public CrmCustomerLeads setCreateTime(Date createTime) {
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
	public CrmCustomerLeads setUpdateBy(String updateBy) {
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
	public CrmCustomerLeads setUpdateTime(Date updateTime) {
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
	public CrmCustomerLeads setDeleted(Integer deleted) {
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
	public CrmCustomerLeads setDeleted(Boolean deletedBool) {
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
	public CrmCustomerLeads setDeleteBy(String deleteBy) {
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
	public CrmCustomerLeads setDeleteTime(Date deleteTime) {
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
	public CrmCustomerLeads setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 crmCustomer<br>
	 * crmCustomer
	 * @return crmCustomer
	*/
	public CrmCustomer getCrmCustomer() {
		return crmCustomer;
	}
	
	/**
	 * 设置 crmCustomer
	 * @param crmCustomer crmCustomer
	 * @return 当前对象
	*/
	public CrmCustomerLeads setCrmCustomer(CrmCustomer crmCustomer) {
		this.crmCustomer=crmCustomer;
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
	public CrmCustomerLeads setOriginator(Employee originator) {
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
	public CrmCustomerLeads setOwner(Employee owner) {
		this.owner=owner;
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
	public CrmCustomerLeads setCrmCustomerIndustry(CrmCustomerIndustry crmCustomerIndustry) {
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
	public CrmCustomerLeads setCrmCustomerIntentional(CrmCustomerIntentional crmCustomerIntentional) {
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
	public CrmCustomerLeads setCrmCustomerLevel(CrmCustomerLevel crmCustomerLevel) {
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
	public CrmCustomerLeads setCrmCustomerSource(CrmCustomerSource crmCustomerSource) {
		this.crmCustomerSource=crmCustomerSource;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CrmCustomerLeads , 转换好的 CrmCustomerLeads 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CrmCustomerLeads , 转换好的 PoJo 对象
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
	public CrmCustomerLeads clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CrmCustomerLeads duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.CrmCustomerLeadsMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.CrmCustomerLeadsMeta.$$proxy$$();
		inst.setSourceId(this.getSourceId());
		inst.setWebsite(this.getWebsite());
		inst.setAddress(this.getAddress());
		inst.setNotes(this.getNotes());
		inst.setContactInfo(this.getContactInfo());
		inst.setLevel(this.getLevel());
		inst.setIntentionalState(this.getIntentionalState());
		inst.setRecentFollowTime(this.getRecentFollowTime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setOwnerId(this.getOwnerId());
		inst.setVersion(this.getVersion());
		inst.setIndustryId(this.getIndustryId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setNextFollowTime(this.getNextFollowTime());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setContacts(this.getContacts());
		if(all) {
			inst.setOwner(this.getOwner());
			inst.setCrmCustomerIndustry(this.getCrmCustomerIndustry());
			inst.setCrmCustomer(this.getCrmCustomer());
			inst.setCrmCustomerIntentional(this.getCrmCustomerIntentional());
			inst.setOriginator(this.getOriginator());
			inst.setCrmCustomerLevel(this.getCrmCustomerLevel());
			inst.setCrmCustomerSource(this.getCrmCustomerSource());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CrmCustomerLeads clone(boolean deep) {
		return EntityContext.clone(CrmCustomerLeads.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CrmCustomerLeads
	 * @param crmCustomerLeadsMap 包含实体信息的 Map 对象
	 * @return CrmCustomerLeads , 转换好的的 CrmCustomerLeads 对象
	*/
	@Transient
	public static CrmCustomerLeads createFrom(Map<String,Object> crmCustomerLeadsMap) {
		if(crmCustomerLeadsMap==null) return null;
		CrmCustomerLeads po = create();
		EntityContext.copyProperties(po,crmCustomerLeadsMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CrmCustomerLeads
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CrmCustomerLeads , 转换好的的 CrmCustomerLeads 对象
	*/
	@Transient
	public static CrmCustomerLeads createFrom(Object pojo) {
		if(pojo==null) return null;
		CrmCustomerLeads po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CrmCustomerLeads，等同于 new
	 * @return CrmCustomerLeads 对象
	*/
	@Transient
	public static CrmCustomerLeads create() {
		return new com.dt.platform.domain.oa.meta.CrmCustomerLeadsMeta.$$proxy$$();
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
			this.setSourceId(DataParser.parse(String.class, map.get(CrmCustomerLeadsMeta.SOURCE_ID)));
			this.setWebsite(DataParser.parse(String.class, map.get(CrmCustomerLeadsMeta.WEBSITE)));
			this.setAddress(DataParser.parse(String.class, map.get(CrmCustomerLeadsMeta.ADDRESS)));
			this.setNotes(DataParser.parse(String.class, map.get(CrmCustomerLeadsMeta.NOTES)));
			this.setContactInfo(DataParser.parse(String.class, map.get(CrmCustomerLeadsMeta.CONTACT_INFO)));
			this.setLevel(DataParser.parse(String.class, map.get(CrmCustomerLeadsMeta.LEVEL)));
			this.setIntentionalState(DataParser.parse(String.class, map.get(CrmCustomerLeadsMeta.INTENTIONAL_STATE)));
			this.setRecentFollowTime(DataParser.parse(Date.class, map.get(CrmCustomerLeadsMeta.RECENT_FOLLOW_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CrmCustomerLeadsMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, map.get(CrmCustomerLeadsMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CrmCustomerLeadsMeta.VERSION)));
			this.setIndustryId(DataParser.parse(String.class, map.get(CrmCustomerLeadsMeta.INDUSTRY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CrmCustomerLeadsMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CrmCustomerLeadsMeta.DELETED)));
			this.setNextFollowTime(DataParser.parse(Date.class, map.get(CrmCustomerLeadsMeta.NEXT_FOLLOW_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CrmCustomerLeadsMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CrmCustomerLeadsMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CrmCustomerLeadsMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(CrmCustomerLeadsMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(CrmCustomerLeadsMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CrmCustomerLeadsMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CrmCustomerLeadsMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(CrmCustomerLeadsMeta.ORIGINATOR_ID)));
			this.setContacts(DataParser.parse(String.class, map.get(CrmCustomerLeadsMeta.CONTACTS)));
			// others
			this.setOwner(DataParser.parse(Employee.class, map.get(CrmCustomerLeadsMeta.OWNER)));
			this.setCrmCustomerIndustry(DataParser.parse(CrmCustomerIndustry.class, map.get(CrmCustomerLeadsMeta.CRM_CUSTOMER_INDUSTRY)));
			this.setCrmCustomer(DataParser.parse(CrmCustomer.class, map.get(CrmCustomerLeadsMeta.CRM_CUSTOMER)));
			this.setCrmCustomerIntentional(DataParser.parse(CrmCustomerIntentional.class, map.get(CrmCustomerLeadsMeta.CRM_CUSTOMER_INTENTIONAL)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(CrmCustomerLeadsMeta.ORIGINATOR)));
			this.setCrmCustomerLevel(DataParser.parse(CrmCustomerLevel.class, map.get(CrmCustomerLeadsMeta.CRM_CUSTOMER_LEVEL)));
			this.setCrmCustomerSource(DataParser.parse(CrmCustomerSource.class, map.get(CrmCustomerLeadsMeta.CRM_CUSTOMER_SOURCE)));
			return true;
		} else {
			try {
				this.setSourceId( (String)map.get(CrmCustomerLeadsMeta.SOURCE_ID));
				this.setWebsite( (String)map.get(CrmCustomerLeadsMeta.WEBSITE));
				this.setAddress( (String)map.get(CrmCustomerLeadsMeta.ADDRESS));
				this.setNotes( (String)map.get(CrmCustomerLeadsMeta.NOTES));
				this.setContactInfo( (String)map.get(CrmCustomerLeadsMeta.CONTACT_INFO));
				this.setLevel( (String)map.get(CrmCustomerLeadsMeta.LEVEL));
				this.setIntentionalState( (String)map.get(CrmCustomerLeadsMeta.INTENTIONAL_STATE));
				this.setRecentFollowTime( (Date)map.get(CrmCustomerLeadsMeta.RECENT_FOLLOW_TIME));
				this.setUpdateTime( (Date)map.get(CrmCustomerLeadsMeta.UPDATE_TIME));
				this.setOwnerId( (String)map.get(CrmCustomerLeadsMeta.OWNER_ID));
				this.setVersion( (Integer)map.get(CrmCustomerLeadsMeta.VERSION));
				this.setIndustryId( (String)map.get(CrmCustomerLeadsMeta.INDUSTRY_ID));
				this.setCreateBy( (String)map.get(CrmCustomerLeadsMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CrmCustomerLeadsMeta.DELETED));
				this.setNextFollowTime( (Date)map.get(CrmCustomerLeadsMeta.NEXT_FOLLOW_TIME));
				this.setCreateTime( (Date)map.get(CrmCustomerLeadsMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CrmCustomerLeadsMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CrmCustomerLeadsMeta.DELETE_TIME));
				this.setName( (String)map.get(CrmCustomerLeadsMeta.NAME));
				this.setTenantId( (String)map.get(CrmCustomerLeadsMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CrmCustomerLeadsMeta.DELETE_BY));
				this.setId( (String)map.get(CrmCustomerLeadsMeta.ID));
				this.setOriginatorId( (String)map.get(CrmCustomerLeadsMeta.ORIGINATOR_ID));
				this.setContacts( (String)map.get(CrmCustomerLeadsMeta.CONTACTS));
				// others
				this.setOwner( (Employee)map.get(CrmCustomerLeadsMeta.OWNER));
				this.setCrmCustomerIndustry( (CrmCustomerIndustry)map.get(CrmCustomerLeadsMeta.CRM_CUSTOMER_INDUSTRY));
				this.setCrmCustomer( (CrmCustomer)map.get(CrmCustomerLeadsMeta.CRM_CUSTOMER));
				this.setCrmCustomerIntentional( (CrmCustomerIntentional)map.get(CrmCustomerLeadsMeta.CRM_CUSTOMER_INTENTIONAL));
				this.setOriginator( (Employee)map.get(CrmCustomerLeadsMeta.ORIGINATOR));
				this.setCrmCustomerLevel( (CrmCustomerLevel)map.get(CrmCustomerLeadsMeta.CRM_CUSTOMER_LEVEL));
				this.setCrmCustomerSource( (CrmCustomerSource)map.get(CrmCustomerLeadsMeta.CRM_CUSTOMER_SOURCE));
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
			this.setSourceId(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsMeta.SOURCE_ID)));
			this.setWebsite(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsMeta.WEBSITE)));
			this.setAddress(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsMeta.ADDRESS)));
			this.setNotes(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsMeta.NOTES)));
			this.setContactInfo(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsMeta.CONTACT_INFO)));
			this.setLevel(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsMeta.LEVEL)));
			this.setIntentionalState(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsMeta.INTENTIONAL_STATE)));
			this.setRecentFollowTime(DataParser.parse(Date.class, r.getValue(CrmCustomerLeadsMeta.RECENT_FOLLOW_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CrmCustomerLeadsMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CrmCustomerLeadsMeta.VERSION)));
			this.setIndustryId(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsMeta.INDUSTRY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CrmCustomerLeadsMeta.DELETED)));
			this.setNextFollowTime(DataParser.parse(Date.class, r.getValue(CrmCustomerLeadsMeta.NEXT_FOLLOW_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CrmCustomerLeadsMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CrmCustomerLeadsMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsMeta.ORIGINATOR_ID)));
			this.setContacts(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsMeta.CONTACTS)));
			return true;
		} else {
			try {
				this.setSourceId( (String)r.getValue(CrmCustomerLeadsMeta.SOURCE_ID));
				this.setWebsite( (String)r.getValue(CrmCustomerLeadsMeta.WEBSITE));
				this.setAddress( (String)r.getValue(CrmCustomerLeadsMeta.ADDRESS));
				this.setNotes( (String)r.getValue(CrmCustomerLeadsMeta.NOTES));
				this.setContactInfo( (String)r.getValue(CrmCustomerLeadsMeta.CONTACT_INFO));
				this.setLevel( (String)r.getValue(CrmCustomerLeadsMeta.LEVEL));
				this.setIntentionalState( (String)r.getValue(CrmCustomerLeadsMeta.INTENTIONAL_STATE));
				this.setRecentFollowTime( (Date)r.getValue(CrmCustomerLeadsMeta.RECENT_FOLLOW_TIME));
				this.setUpdateTime( (Date)r.getValue(CrmCustomerLeadsMeta.UPDATE_TIME));
				this.setOwnerId( (String)r.getValue(CrmCustomerLeadsMeta.OWNER_ID));
				this.setVersion( (Integer)r.getValue(CrmCustomerLeadsMeta.VERSION));
				this.setIndustryId( (String)r.getValue(CrmCustomerLeadsMeta.INDUSTRY_ID));
				this.setCreateBy( (String)r.getValue(CrmCustomerLeadsMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CrmCustomerLeadsMeta.DELETED));
				this.setNextFollowTime( (Date)r.getValue(CrmCustomerLeadsMeta.NEXT_FOLLOW_TIME));
				this.setCreateTime( (Date)r.getValue(CrmCustomerLeadsMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CrmCustomerLeadsMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CrmCustomerLeadsMeta.DELETE_TIME));
				this.setName( (String)r.getValue(CrmCustomerLeadsMeta.NAME));
				this.setTenantId( (String)r.getValue(CrmCustomerLeadsMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CrmCustomerLeadsMeta.DELETE_BY));
				this.setId( (String)r.getValue(CrmCustomerLeadsMeta.ID));
				this.setOriginatorId( (String)r.getValue(CrmCustomerLeadsMeta.ORIGINATOR_ID));
				this.setContacts( (String)r.getValue(CrmCustomerLeadsMeta.CONTACTS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}