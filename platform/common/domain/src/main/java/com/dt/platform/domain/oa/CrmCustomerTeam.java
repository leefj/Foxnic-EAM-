package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_CRM_CUSTOMER_TEAM;
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
import com.dt.platform.domain.oa.meta.CrmCustomerTeamMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 团队成员
 * <p>团队成员 , 数据表 oa_crm_customer_team 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-16 23:00:43
 * @sign 3172D6A406A28236F90250EC68CA6276
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_crm_customer_team")
@ApiModel(description = "团队成员 ; 团队成员 , 数据表 oa_crm_customer_team 的PO类型")
public class CrmCustomerTeam extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_CRM_CUSTOMER_TEAM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "755339248625778688")
	private String id;
	
	/**
	 * 客户：客户
	*/
	@ApiModelProperty(required = false,value="客户" , notes = "客户" , example = "755320799597953025")
	private String customerId;
	
	/**
	 * 成员：成员
	*/
	@ApiModelProperty(required = false,value="成员" , notes = "成员" , example = "581798649571311616")
	private String userId;
	
	/**
	 * 团队角色：团队角色
	*/
	@ApiModelProperty(required = false,value="团队角色" , notes = "团队角色" , example = "member")
	private String userRole;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-09-16 08:08:30")
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
	 * user：user
	*/
	@ApiModelProperty(required = false,value="user" , notes = "user")
	private Employee user;
	
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
	public CrmCustomerTeam setId(String id) {
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
	public CrmCustomerTeam setCustomerId(String customerId) {
		this.customerId=customerId;
		return this;
	}
	
	/**
	 * 获得 成员<br>
	 * 成员
	 * @return 成员
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 成员
	 * @param userId 成员
	 * @return 当前对象
	*/
	public CrmCustomerTeam setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 团队角色<br>
	 * 团队角色
	 * @return 团队角色
	*/
	public String getUserRole() {
		return userRole;
	}
	
	/**
	 * 设置 团队角色
	 * @param userRole 团队角色
	 * @return 当前对象
	*/
	public CrmCustomerTeam setUserRole(String userRole) {
		this.userRole=userRole;
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
	public CrmCustomerTeam setNotes(String notes) {
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
	public CrmCustomerTeam setVersion(Integer version) {
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
	public CrmCustomerTeam setCreateBy(String createBy) {
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
	public CrmCustomerTeam setCreateTime(Date createTime) {
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
	public CrmCustomerTeam setUpdateBy(String updateBy) {
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
	public CrmCustomerTeam setUpdateTime(Date updateTime) {
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
	public CrmCustomerTeam setDeleted(Integer deleted) {
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
	public CrmCustomerTeam setDeleted(Boolean deletedBool) {
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
	public CrmCustomerTeam setDeleteBy(String deleteBy) {
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
	public CrmCustomerTeam setDeleteTime(Date deleteTime) {
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
	public CrmCustomerTeam setTenantId(String tenantId) {
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
	public CrmCustomerTeam setCrmCustomer(CrmCustomer crmCustomer) {
		this.crmCustomer=crmCustomer;
		return this;
	}
	
	/**
	 * 获得 user<br>
	 * user
	 * @return user
	*/
	public Employee getUser() {
		return user;
	}
	
	/**
	 * 设置 user
	 * @param user user
	 * @return 当前对象
	*/
	public CrmCustomerTeam setUser(Employee user) {
		this.user=user;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CrmCustomerTeam , 转换好的 CrmCustomerTeam 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CrmCustomerTeam , 转换好的 PoJo 对象
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
	public CrmCustomerTeam clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CrmCustomerTeam duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.CrmCustomerTeamMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.CrmCustomerTeamMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCustomerId(this.getCustomerId());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setUserRole(this.getUserRole());
		if(all) {
			inst.setCrmCustomer(this.getCrmCustomer());
			inst.setUser(this.getUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CrmCustomerTeam clone(boolean deep) {
		return EntityContext.clone(CrmCustomerTeam.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CrmCustomerTeam
	 * @param crmCustomerTeamMap 包含实体信息的 Map 对象
	 * @return CrmCustomerTeam , 转换好的的 CrmCustomerTeam 对象
	*/
	@Transient
	public static CrmCustomerTeam createFrom(Map<String,Object> crmCustomerTeamMap) {
		if(crmCustomerTeamMap==null) return null;
		CrmCustomerTeam po = create();
		EntityContext.copyProperties(po,crmCustomerTeamMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CrmCustomerTeam
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CrmCustomerTeam , 转换好的的 CrmCustomerTeam 对象
	*/
	@Transient
	public static CrmCustomerTeam createFrom(Object pojo) {
		if(pojo==null) return null;
		CrmCustomerTeam po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CrmCustomerTeam，等同于 new
	 * @return CrmCustomerTeam 对象
	*/
	@Transient
	public static CrmCustomerTeam create() {
		return new com.dt.platform.domain.oa.meta.CrmCustomerTeamMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(CrmCustomerTeamMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CrmCustomerTeamMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(CrmCustomerTeamMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CrmCustomerTeamMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CrmCustomerTeamMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CrmCustomerTeamMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CrmCustomerTeamMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CrmCustomerTeamMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CrmCustomerTeamMeta.DELETE_TIME)));
			this.setCustomerId(DataParser.parse(String.class, map.get(CrmCustomerTeamMeta.CUSTOMER_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(CrmCustomerTeamMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CrmCustomerTeamMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CrmCustomerTeamMeta.ID)));
			this.setUserRole(DataParser.parse(String.class, map.get(CrmCustomerTeamMeta.USER_ROLE)));
			// others
			this.setCrmCustomer(DataParser.parse(CrmCustomer.class, map.get(CrmCustomerTeamMeta.CRM_CUSTOMER)));
			this.setUser(DataParser.parse(Employee.class, map.get(CrmCustomerTeamMeta.USER)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(CrmCustomerTeamMeta.NOTES));
				this.setUpdateTime( (Date)map.get(CrmCustomerTeamMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(CrmCustomerTeamMeta.USER_ID));
				this.setVersion( (Integer)map.get(CrmCustomerTeamMeta.VERSION));
				this.setCreateBy( (String)map.get(CrmCustomerTeamMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CrmCustomerTeamMeta.DELETED));
				this.setCreateTime( (Date)map.get(CrmCustomerTeamMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CrmCustomerTeamMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CrmCustomerTeamMeta.DELETE_TIME));
				this.setCustomerId( (String)map.get(CrmCustomerTeamMeta.CUSTOMER_ID));
				this.setTenantId( (String)map.get(CrmCustomerTeamMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CrmCustomerTeamMeta.DELETE_BY));
				this.setId( (String)map.get(CrmCustomerTeamMeta.ID));
				this.setUserRole( (String)map.get(CrmCustomerTeamMeta.USER_ROLE));
				// others
				this.setCrmCustomer( (CrmCustomer)map.get(CrmCustomerTeamMeta.CRM_CUSTOMER));
				this.setUser( (Employee)map.get(CrmCustomerTeamMeta.USER));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(CrmCustomerTeamMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CrmCustomerTeamMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(CrmCustomerTeamMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CrmCustomerTeamMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CrmCustomerTeamMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CrmCustomerTeamMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CrmCustomerTeamMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CrmCustomerTeamMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CrmCustomerTeamMeta.DELETE_TIME)));
			this.setCustomerId(DataParser.parse(String.class, r.getValue(CrmCustomerTeamMeta.CUSTOMER_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CrmCustomerTeamMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CrmCustomerTeamMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CrmCustomerTeamMeta.ID)));
			this.setUserRole(DataParser.parse(String.class, r.getValue(CrmCustomerTeamMeta.USER_ROLE)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(CrmCustomerTeamMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(CrmCustomerTeamMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(CrmCustomerTeamMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(CrmCustomerTeamMeta.VERSION));
				this.setCreateBy( (String)r.getValue(CrmCustomerTeamMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CrmCustomerTeamMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CrmCustomerTeamMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CrmCustomerTeamMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CrmCustomerTeamMeta.DELETE_TIME));
				this.setCustomerId( (String)r.getValue(CrmCustomerTeamMeta.CUSTOMER_ID));
				this.setTenantId( (String)r.getValue(CrmCustomerTeamMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CrmCustomerTeamMeta.DELETE_BY));
				this.setId( (String)r.getValue(CrmCustomerTeamMeta.ID));
				this.setUserRole( (String)r.getValue(CrmCustomerTeamMeta.USER_ROLE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}