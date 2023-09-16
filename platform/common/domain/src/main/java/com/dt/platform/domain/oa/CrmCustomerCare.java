package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_CRM_CUSTOMER_CARE;
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
import com.dt.platform.domain.oa.meta.CrmCustomerCareMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 我的关注
 * <p>我的关注 , 数据表 oa_crm_customer_care 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-16 12:56:44
 * @sign F7441EBC05315E2F5BEE1CD2E14ACFFE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_crm_customer_care")
@ApiModel(description = "我的关注 ; 我的关注 , 数据表 oa_crm_customer_care 的PO类型")
public class CrmCustomerCare extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_CRM_CUSTOMER_CARE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 客户：客户
	*/
	@ApiModelProperty(required = false,value="客户" , notes = "客户")
	private String customerId;
	
	/**
	 * 用户：用户
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "用户")
	private String userId;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本")
	private Integer version;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
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
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
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
	public CrmCustomerCare setId(String id) {
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
	public CrmCustomerCare setCustomerId(String customerId) {
		this.customerId=customerId;
		return this;
	}
	
	/**
	 * 获得 用户<br>
	 * 用户
	 * @return 用户
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 用户
	 * @param userId 用户
	 * @return 当前对象
	*/
	public CrmCustomerCare setUserId(String userId) {
		this.userId=userId;
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
	public CrmCustomerCare setVersion(Integer version) {
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
	public CrmCustomerCare setCreateBy(String createBy) {
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
	public CrmCustomerCare setCreateTime(Date createTime) {
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
	public CrmCustomerCare setUpdateBy(String updateBy) {
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
	public CrmCustomerCare setUpdateTime(Date updateTime) {
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
	public CrmCustomerCare setDeleted(Integer deleted) {
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
	public CrmCustomerCare setDeleted(Boolean deletedBool) {
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
	public CrmCustomerCare setDeleteBy(String deleteBy) {
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
	public CrmCustomerCare setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public CrmCustomerCare setUser(Employee user) {
		this.user=user;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CrmCustomerCare , 转换好的 CrmCustomerCare 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CrmCustomerCare , 转换好的 PoJo 对象
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
	public CrmCustomerCare clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CrmCustomerCare duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.CrmCustomerCareMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.CrmCustomerCareMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCustomerId(this.getCustomerId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		if(all) {
			inst.setUser(this.getUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CrmCustomerCare clone(boolean deep) {
		return EntityContext.clone(CrmCustomerCare.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CrmCustomerCare
	 * @param crmCustomerCareMap 包含实体信息的 Map 对象
	 * @return CrmCustomerCare , 转换好的的 CrmCustomerCare 对象
	*/
	@Transient
	public static CrmCustomerCare createFrom(Map<String,Object> crmCustomerCareMap) {
		if(crmCustomerCareMap==null) return null;
		CrmCustomerCare po = create();
		EntityContext.copyProperties(po,crmCustomerCareMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CrmCustomerCare
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CrmCustomerCare , 转换好的的 CrmCustomerCare 对象
	*/
	@Transient
	public static CrmCustomerCare createFrom(Object pojo) {
		if(pojo==null) return null;
		CrmCustomerCare po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CrmCustomerCare，等同于 new
	 * @return CrmCustomerCare 对象
	*/
	@Transient
	public static CrmCustomerCare create() {
		return new com.dt.platform.domain.oa.meta.CrmCustomerCareMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(CrmCustomerCareMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CrmCustomerCareMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CrmCustomerCareMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CrmCustomerCareMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CrmCustomerCareMeta.DELETE_TIME)));
			this.setCustomerId(DataParser.parse(String.class, map.get(CrmCustomerCareMeta.CUSTOMER_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CrmCustomerCareMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CrmCustomerCareMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(CrmCustomerCareMeta.ID)));
			this.setUserId(DataParser.parse(String.class, map.get(CrmCustomerCareMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CrmCustomerCareMeta.VERSION)));
			// others
			this.setUser(DataParser.parse(Employee.class, map.get(CrmCustomerCareMeta.USER)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(CrmCustomerCareMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CrmCustomerCareMeta.DELETED));
				this.setCreateTime( (Date)map.get(CrmCustomerCareMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CrmCustomerCareMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CrmCustomerCareMeta.DELETE_TIME));
				this.setCustomerId( (String)map.get(CrmCustomerCareMeta.CUSTOMER_ID));
				this.setDeleteBy( (String)map.get(CrmCustomerCareMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(CrmCustomerCareMeta.UPDATE_TIME));
				this.setId( (String)map.get(CrmCustomerCareMeta.ID));
				this.setUserId( (String)map.get(CrmCustomerCareMeta.USER_ID));
				this.setVersion( (Integer)map.get(CrmCustomerCareMeta.VERSION));
				// others
				this.setUser( (Employee)map.get(CrmCustomerCareMeta.USER));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CrmCustomerCareMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CrmCustomerCareMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CrmCustomerCareMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CrmCustomerCareMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CrmCustomerCareMeta.DELETE_TIME)));
			this.setCustomerId(DataParser.parse(String.class, r.getValue(CrmCustomerCareMeta.CUSTOMER_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CrmCustomerCareMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CrmCustomerCareMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(CrmCustomerCareMeta.ID)));
			this.setUserId(DataParser.parse(String.class, r.getValue(CrmCustomerCareMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CrmCustomerCareMeta.VERSION)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(CrmCustomerCareMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CrmCustomerCareMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CrmCustomerCareMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CrmCustomerCareMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CrmCustomerCareMeta.DELETE_TIME));
				this.setCustomerId( (String)r.getValue(CrmCustomerCareMeta.CUSTOMER_ID));
				this.setDeleteBy( (String)r.getValue(CrmCustomerCareMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(CrmCustomerCareMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(CrmCustomerCareMeta.ID));
				this.setUserId( (String)r.getValue(CrmCustomerCareMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(CrmCustomerCareMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}