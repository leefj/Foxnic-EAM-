package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_CRM_CUSTOMER_CONTACT;
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
import com.dt.platform.domain.oa.meta.CrmCustomerContactMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 联系人
 * <p>联系人 , 数据表 oa_crm_customer_contact 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-16 22:55:54
 * @sign 1CD16A5C1CAF8604AE44A5A34E77A569
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_crm_customer_contact")
@ApiModel(description = "联系人 ; 联系人 , 数据表 oa_crm_customer_contact 的PO类型")
public class CrmCustomerContact extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_CRM_CUSTOMER_CONTACT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "754655709462790144")
	private String id;
	
	/**
	 * 客户：客户
	*/
	@ApiModelProperty(required = false,value="客户" , notes = "客户" , example = "754655093655076864")
	private String customerId;
	
	/**
	 * 姓名：姓名
	*/
	@ApiModelProperty(required = false,value="姓名" , notes = "姓名" , example = "阿斯顿")
	private String name;
	
	/**
	 * 手机：手机
	*/
	@ApiModelProperty(required = false,value="手机" , notes = "手机" , example = "12")
	private String mobile;
	
	/**
	 * 邮箱：邮箱
	*/
	@ApiModelProperty(required = false,value="邮箱" , notes = "邮箱")
	private String mail;
	
	/**
	 * 微信：微信
	*/
	@ApiModelProperty(required = false,value="微信" , notes = "微信" , example = "12")
	private String wexin;
	
	/**
	 * 职位：职位
	*/
	@ApiModelProperty(required = false,value="职位" , notes = "职位" , example = "12")
	private String job;
	
	/**
	 * 性别：性别
	*/
	@ApiModelProperty(required = false,value="性别" , notes = "性别" , example = "male")
	private String sex;
	
	/**
	 * 地址：地址
	*/
	@ApiModelProperty(required = false,value="地址" , notes = "地址" , example = "12")
	private String address;
	
	/**
	 * 角色：角色
	*/
	@ApiModelProperty(required = false,value="角色" , notes = "角色" , example = "first_contact")
	private String role;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "1212")
	private String notes;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-09-14 10:52:22")
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
	public CrmCustomerContact setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 客户<br>
	 * 客户
	 * @return 客户
	*/
	public String getCustomerId() {
		return customerId;
	}
	
	/**
	 * 设置 客户
	 * @param customerId 客户
	 * @return 当前对象
	*/
	public CrmCustomerContact setCustomerId(String customerId) {
		this.customerId=customerId;
		return this;
	}
	
	/**
	 * 获得 姓名<br>
	 * 姓名
	 * @return 姓名
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 姓名
	 * @param name 姓名
	 * @return 当前对象
	*/
	public CrmCustomerContact setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 手机<br>
	 * 手机
	 * @return 手机
	*/
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * 设置 手机
	 * @param mobile 手机
	 * @return 当前对象
	*/
	public CrmCustomerContact setMobile(String mobile) {
		this.mobile=mobile;
		return this;
	}
	
	/**
	 * 获得 邮箱<br>
	 * 邮箱
	 * @return 邮箱
	*/
	public String getMail() {
		return mail;
	}
	
	/**
	 * 设置 邮箱
	 * @param mail 邮箱
	 * @return 当前对象
	*/
	public CrmCustomerContact setMail(String mail) {
		this.mail=mail;
		return this;
	}
	
	/**
	 * 获得 微信<br>
	 * 微信
	 * @return 微信
	*/
	public String getWexin() {
		return wexin;
	}
	
	/**
	 * 设置 微信
	 * @param wexin 微信
	 * @return 当前对象
	*/
	public CrmCustomerContact setWexin(String wexin) {
		this.wexin=wexin;
		return this;
	}
	
	/**
	 * 获得 职位<br>
	 * 职位
	 * @return 职位
	*/
	public String getJob() {
		return job;
	}
	
	/**
	 * 设置 职位
	 * @param job 职位
	 * @return 当前对象
	*/
	public CrmCustomerContact setJob(String job) {
		this.job=job;
		return this;
	}
	
	/**
	 * 获得 性别<br>
	 * 性别
	 * @return 性别
	*/
	public String getSex() {
		return sex;
	}
	
	/**
	 * 设置 性别
	 * @param sex 性别
	 * @return 当前对象
	*/
	public CrmCustomerContact setSex(String sex) {
		this.sex=sex;
		return this;
	}
	
	/**
	 * 获得 地址<br>
	 * 地址
	 * @return 地址
	*/
	public String getAddress() {
		return address;
	}
	
	/**
	 * 设置 地址
	 * @param address 地址
	 * @return 当前对象
	*/
	public CrmCustomerContact setAddress(String address) {
		this.address=address;
		return this;
	}
	
	/**
	 * 获得 角色<br>
	 * 角色
	 * @return 角色
	*/
	public String getRole() {
		return role;
	}
	
	/**
	 * 设置 角色
	 * @param role 角色
	 * @return 当前对象
	*/
	public CrmCustomerContact setRole(String role) {
		this.role=role;
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
	public CrmCustomerContact setNotes(String notes) {
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
	public CrmCustomerContact setOriginatorId(String originatorId) {
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
	public CrmCustomerContact setVersion(Integer version) {
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
	public CrmCustomerContact setCreateBy(String createBy) {
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
	public CrmCustomerContact setCreateTime(Date createTime) {
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
	public CrmCustomerContact setUpdateBy(String updateBy) {
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
	public CrmCustomerContact setUpdateTime(Date updateTime) {
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
	public CrmCustomerContact setDeleted(Integer deleted) {
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
	public CrmCustomerContact setDeleted(Boolean deletedBool) {
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
	public CrmCustomerContact setDeleteBy(String deleteBy) {
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
	public CrmCustomerContact setDeleteTime(Date deleteTime) {
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
	public CrmCustomerContact setTenantId(String tenantId) {
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
	public CrmCustomerContact setCrmCustomer(CrmCustomer crmCustomer) {
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
	public CrmCustomerContact setOriginator(Employee originator) {
		this.originator=originator;
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
	public CrmCustomerContact setSearchCustomerType(String searchCustomerType) {
		this.searchCustomerType=searchCustomerType;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CrmCustomerContact , 转换好的 CrmCustomerContact 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CrmCustomerContact , 转换好的 PoJo 对象
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
	public CrmCustomerContact clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CrmCustomerContact duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.CrmCustomerContactMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.CrmCustomerContactMeta.$$proxy$$();
		inst.setAddress(this.getAddress());
		inst.setRole(this.getRole());
		inst.setNotes(this.getNotes());
		inst.setMail(this.getMail());
		inst.setSex(this.getSex());
		inst.setMobile(this.getMobile());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setWexin(this.getWexin());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCustomerId(this.getCustomerId());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setJob(this.getJob());
		if(all) {
			inst.setCrmCustomer(this.getCrmCustomer());
			inst.setOriginator(this.getOriginator());
			inst.setSearchCustomerType(this.getSearchCustomerType());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CrmCustomerContact clone(boolean deep) {
		return EntityContext.clone(CrmCustomerContact.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CrmCustomerContact
	 * @param crmCustomerContactMap 包含实体信息的 Map 对象
	 * @return CrmCustomerContact , 转换好的的 CrmCustomerContact 对象
	*/
	@Transient
	public static CrmCustomerContact createFrom(Map<String,Object> crmCustomerContactMap) {
		if(crmCustomerContactMap==null) return null;
		CrmCustomerContact po = create();
		EntityContext.copyProperties(po,crmCustomerContactMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CrmCustomerContact
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CrmCustomerContact , 转换好的的 CrmCustomerContact 对象
	*/
	@Transient
	public static CrmCustomerContact createFrom(Object pojo) {
		if(pojo==null) return null;
		CrmCustomerContact po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CrmCustomerContact，等同于 new
	 * @return CrmCustomerContact 对象
	*/
	@Transient
	public static CrmCustomerContact create() {
		return new com.dt.platform.domain.oa.meta.CrmCustomerContactMeta.$$proxy$$();
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
			this.setAddress(DataParser.parse(String.class, map.get(CrmCustomerContactMeta.ADDRESS)));
			this.setRole(DataParser.parse(String.class, map.get(CrmCustomerContactMeta.ROLE)));
			this.setNotes(DataParser.parse(String.class, map.get(CrmCustomerContactMeta.NOTES)));
			this.setMail(DataParser.parse(String.class, map.get(CrmCustomerContactMeta.MAIL)));
			this.setSex(DataParser.parse(String.class, map.get(CrmCustomerContactMeta.SEX)));
			this.setMobile(DataParser.parse(String.class, map.get(CrmCustomerContactMeta.MOBILE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CrmCustomerContactMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CrmCustomerContactMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CrmCustomerContactMeta.CREATE_BY)));
			this.setWexin(DataParser.parse(String.class, map.get(CrmCustomerContactMeta.WEXIN)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CrmCustomerContactMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CrmCustomerContactMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CrmCustomerContactMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CrmCustomerContactMeta.DELETE_TIME)));
			this.setCustomerId(DataParser.parse(String.class, map.get(CrmCustomerContactMeta.CUSTOMER_ID)));
			this.setName(DataParser.parse(String.class, map.get(CrmCustomerContactMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(CrmCustomerContactMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CrmCustomerContactMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CrmCustomerContactMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(CrmCustomerContactMeta.ORIGINATOR_ID)));
			this.setJob(DataParser.parse(String.class, map.get(CrmCustomerContactMeta.JOB)));
			// others
			this.setCrmCustomer(DataParser.parse(CrmCustomer.class, map.get(CrmCustomerContactMeta.CRM_CUSTOMER)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(CrmCustomerContactMeta.ORIGINATOR)));
			this.setSearchCustomerType(DataParser.parse(String.class, map.get(CrmCustomerContactMeta.SEARCH_CUSTOMER_TYPE)));
			return true;
		} else {
			try {
				this.setAddress( (String)map.get(CrmCustomerContactMeta.ADDRESS));
				this.setRole( (String)map.get(CrmCustomerContactMeta.ROLE));
				this.setNotes( (String)map.get(CrmCustomerContactMeta.NOTES));
				this.setMail( (String)map.get(CrmCustomerContactMeta.MAIL));
				this.setSex( (String)map.get(CrmCustomerContactMeta.SEX));
				this.setMobile( (String)map.get(CrmCustomerContactMeta.MOBILE));
				this.setUpdateTime( (Date)map.get(CrmCustomerContactMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(CrmCustomerContactMeta.VERSION));
				this.setCreateBy( (String)map.get(CrmCustomerContactMeta.CREATE_BY));
				this.setWexin( (String)map.get(CrmCustomerContactMeta.WEXIN));
				this.setDeleted( (Integer)map.get(CrmCustomerContactMeta.DELETED));
				this.setCreateTime( (Date)map.get(CrmCustomerContactMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CrmCustomerContactMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CrmCustomerContactMeta.DELETE_TIME));
				this.setCustomerId( (String)map.get(CrmCustomerContactMeta.CUSTOMER_ID));
				this.setName( (String)map.get(CrmCustomerContactMeta.NAME));
				this.setTenantId( (String)map.get(CrmCustomerContactMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CrmCustomerContactMeta.DELETE_BY));
				this.setId( (String)map.get(CrmCustomerContactMeta.ID));
				this.setOriginatorId( (String)map.get(CrmCustomerContactMeta.ORIGINATOR_ID));
				this.setJob( (String)map.get(CrmCustomerContactMeta.JOB));
				// others
				this.setCrmCustomer( (CrmCustomer)map.get(CrmCustomerContactMeta.CRM_CUSTOMER));
				this.setOriginator( (Employee)map.get(CrmCustomerContactMeta.ORIGINATOR));
				this.setSearchCustomerType( (String)map.get(CrmCustomerContactMeta.SEARCH_CUSTOMER_TYPE));
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
			this.setAddress(DataParser.parse(String.class, r.getValue(CrmCustomerContactMeta.ADDRESS)));
			this.setRole(DataParser.parse(String.class, r.getValue(CrmCustomerContactMeta.ROLE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(CrmCustomerContactMeta.NOTES)));
			this.setMail(DataParser.parse(String.class, r.getValue(CrmCustomerContactMeta.MAIL)));
			this.setSex(DataParser.parse(String.class, r.getValue(CrmCustomerContactMeta.SEX)));
			this.setMobile(DataParser.parse(String.class, r.getValue(CrmCustomerContactMeta.MOBILE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CrmCustomerContactMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CrmCustomerContactMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CrmCustomerContactMeta.CREATE_BY)));
			this.setWexin(DataParser.parse(String.class, r.getValue(CrmCustomerContactMeta.WEXIN)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CrmCustomerContactMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CrmCustomerContactMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CrmCustomerContactMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CrmCustomerContactMeta.DELETE_TIME)));
			this.setCustomerId(DataParser.parse(String.class, r.getValue(CrmCustomerContactMeta.CUSTOMER_ID)));
			this.setName(DataParser.parse(String.class, r.getValue(CrmCustomerContactMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CrmCustomerContactMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CrmCustomerContactMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CrmCustomerContactMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(CrmCustomerContactMeta.ORIGINATOR_ID)));
			this.setJob(DataParser.parse(String.class, r.getValue(CrmCustomerContactMeta.JOB)));
			return true;
		} else {
			try {
				this.setAddress( (String)r.getValue(CrmCustomerContactMeta.ADDRESS));
				this.setRole( (String)r.getValue(CrmCustomerContactMeta.ROLE));
				this.setNotes( (String)r.getValue(CrmCustomerContactMeta.NOTES));
				this.setMail( (String)r.getValue(CrmCustomerContactMeta.MAIL));
				this.setSex( (String)r.getValue(CrmCustomerContactMeta.SEX));
				this.setMobile( (String)r.getValue(CrmCustomerContactMeta.MOBILE));
				this.setUpdateTime( (Date)r.getValue(CrmCustomerContactMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(CrmCustomerContactMeta.VERSION));
				this.setCreateBy( (String)r.getValue(CrmCustomerContactMeta.CREATE_BY));
				this.setWexin( (String)r.getValue(CrmCustomerContactMeta.WEXIN));
				this.setDeleted( (Integer)r.getValue(CrmCustomerContactMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CrmCustomerContactMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CrmCustomerContactMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CrmCustomerContactMeta.DELETE_TIME));
				this.setCustomerId( (String)r.getValue(CrmCustomerContactMeta.CUSTOMER_ID));
				this.setName( (String)r.getValue(CrmCustomerContactMeta.NAME));
				this.setTenantId( (String)r.getValue(CrmCustomerContactMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CrmCustomerContactMeta.DELETE_BY));
				this.setId( (String)r.getValue(CrmCustomerContactMeta.ID));
				this.setOriginatorId( (String)r.getValue(CrmCustomerContactMeta.ORIGINATOR_ID));
				this.setJob( (String)r.getValue(CrmCustomerContactMeta.JOB));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}