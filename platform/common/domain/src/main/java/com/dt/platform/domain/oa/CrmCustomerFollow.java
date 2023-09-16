package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_CRM_CUSTOMER_FOLLOW;
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
import com.dt.platform.domain.oa.meta.CrmCustomerFollowMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 跟进记录
 * <p>跟进记录 , 数据表 oa_crm_customer_follow 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-16 22:51:41
 * @sign 20D8907C4019DE799BC4FC514BCEC8AB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_crm_customer_follow")
@ApiModel(description = "跟进记录 ; 跟进记录 , 数据表 oa_crm_customer_follow 的PO类型")
public class CrmCustomerFollow extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_CRM_CUSTOMER_FOLLOW.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "755460504167645184")
	private String id;
	
	/**
	 * 客户：客户
	*/
	@ApiModelProperty(required = false,value="客户" , notes = "客户")
	private String customerId;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容" , example = "dfa")
	private String content;
	
	/**
	 * 记录时间：记录时间
	*/
	@ApiModelProperty(required = false,value="记录时间" , notes = "记录时间")
	private Date recTime;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "sadf")
	private String notes;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String fileId;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-09-16 04:10:20")
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
	public CrmCustomerFollow setId(String id) {
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
	public CrmCustomerFollow setCustomerId(String customerId) {
		this.customerId=customerId;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 内容
	 * @param content 内容
	 * @return 当前对象
	*/
	public CrmCustomerFollow setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 记录时间<br>
	 * 记录时间
	 * @return 记录时间
	*/
	public Date getRecTime() {
		return recTime;
	}
	
	/**
	 * 设置 记录时间
	 * @param recTime 记录时间
	 * @return 当前对象
	*/
	public CrmCustomerFollow setRecTime(Date recTime) {
		this.recTime=recTime;
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
	public CrmCustomerFollow setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 附件
	 * @param fileId 附件
	 * @return 当前对象
	*/
	public CrmCustomerFollow setFileId(String fileId) {
		this.fileId=fileId;
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
	public CrmCustomerFollow setOriginatorId(String originatorId) {
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
	public CrmCustomerFollow setVersion(Integer version) {
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
	public CrmCustomerFollow setCreateBy(String createBy) {
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
	public CrmCustomerFollow setCreateTime(Date createTime) {
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
	public CrmCustomerFollow setUpdateBy(String updateBy) {
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
	public CrmCustomerFollow setUpdateTime(Date updateTime) {
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
	public CrmCustomerFollow setDeleted(Integer deleted) {
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
	public CrmCustomerFollow setDeleted(Boolean deletedBool) {
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
	public CrmCustomerFollow setDeleteBy(String deleteBy) {
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
	public CrmCustomerFollow setDeleteTime(Date deleteTime) {
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
	public CrmCustomerFollow setTenantId(String tenantId) {
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
	public CrmCustomerFollow setCrmCustomer(CrmCustomer crmCustomer) {
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
	public CrmCustomerFollow setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CrmCustomerFollow , 转换好的 CrmCustomerFollow 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CrmCustomerFollow , 转换好的 PoJo 对象
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
	public CrmCustomerFollow clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CrmCustomerFollow duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.CrmCustomerFollowMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.CrmCustomerFollowMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setRecTime(this.getRecTime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCustomerId(this.getCustomerId());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setFileId(this.getFileId());
		if(all) {
			inst.setCrmCustomer(this.getCrmCustomer());
			inst.setOriginator(this.getOriginator());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CrmCustomerFollow clone(boolean deep) {
		return EntityContext.clone(CrmCustomerFollow.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CrmCustomerFollow
	 * @param crmCustomerFollowMap 包含实体信息的 Map 对象
	 * @return CrmCustomerFollow , 转换好的的 CrmCustomerFollow 对象
	*/
	@Transient
	public static CrmCustomerFollow createFrom(Map<String,Object> crmCustomerFollowMap) {
		if(crmCustomerFollowMap==null) return null;
		CrmCustomerFollow po = create();
		EntityContext.copyProperties(po,crmCustomerFollowMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CrmCustomerFollow
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CrmCustomerFollow , 转换好的的 CrmCustomerFollow 对象
	*/
	@Transient
	public static CrmCustomerFollow createFrom(Object pojo) {
		if(pojo==null) return null;
		CrmCustomerFollow po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CrmCustomerFollow，等同于 new
	 * @return CrmCustomerFollow 对象
	*/
	@Transient
	public static CrmCustomerFollow create() {
		return new com.dt.platform.domain.oa.meta.CrmCustomerFollowMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(CrmCustomerFollowMeta.NOTES)));
			this.setRecTime(DataParser.parse(Date.class, map.get(CrmCustomerFollowMeta.REC_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CrmCustomerFollowMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CrmCustomerFollowMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(CrmCustomerFollowMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CrmCustomerFollowMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CrmCustomerFollowMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CrmCustomerFollowMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CrmCustomerFollowMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CrmCustomerFollowMeta.DELETE_TIME)));
			this.setCustomerId(DataParser.parse(String.class, map.get(CrmCustomerFollowMeta.CUSTOMER_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(CrmCustomerFollowMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CrmCustomerFollowMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CrmCustomerFollowMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(CrmCustomerFollowMeta.ORIGINATOR_ID)));
			this.setFileId(DataParser.parse(String.class, map.get(CrmCustomerFollowMeta.FILE_ID)));
			// others
			this.setCrmCustomer(DataParser.parse(CrmCustomer.class, map.get(CrmCustomerFollowMeta.CRM_CUSTOMER)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(CrmCustomerFollowMeta.ORIGINATOR)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(CrmCustomerFollowMeta.NOTES));
				this.setRecTime( (Date)map.get(CrmCustomerFollowMeta.REC_TIME));
				this.setUpdateTime( (Date)map.get(CrmCustomerFollowMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(CrmCustomerFollowMeta.VERSION));
				this.setContent( (String)map.get(CrmCustomerFollowMeta.CONTENT));
				this.setCreateBy( (String)map.get(CrmCustomerFollowMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CrmCustomerFollowMeta.DELETED));
				this.setCreateTime( (Date)map.get(CrmCustomerFollowMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CrmCustomerFollowMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CrmCustomerFollowMeta.DELETE_TIME));
				this.setCustomerId( (String)map.get(CrmCustomerFollowMeta.CUSTOMER_ID));
				this.setTenantId( (String)map.get(CrmCustomerFollowMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CrmCustomerFollowMeta.DELETE_BY));
				this.setId( (String)map.get(CrmCustomerFollowMeta.ID));
				this.setOriginatorId( (String)map.get(CrmCustomerFollowMeta.ORIGINATOR_ID));
				this.setFileId( (String)map.get(CrmCustomerFollowMeta.FILE_ID));
				// others
				this.setCrmCustomer( (CrmCustomer)map.get(CrmCustomerFollowMeta.CRM_CUSTOMER));
				this.setOriginator( (Employee)map.get(CrmCustomerFollowMeta.ORIGINATOR));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(CrmCustomerFollowMeta.NOTES)));
			this.setRecTime(DataParser.parse(Date.class, r.getValue(CrmCustomerFollowMeta.REC_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CrmCustomerFollowMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CrmCustomerFollowMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(CrmCustomerFollowMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CrmCustomerFollowMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CrmCustomerFollowMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CrmCustomerFollowMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CrmCustomerFollowMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CrmCustomerFollowMeta.DELETE_TIME)));
			this.setCustomerId(DataParser.parse(String.class, r.getValue(CrmCustomerFollowMeta.CUSTOMER_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CrmCustomerFollowMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CrmCustomerFollowMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CrmCustomerFollowMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(CrmCustomerFollowMeta.ORIGINATOR_ID)));
			this.setFileId(DataParser.parse(String.class, r.getValue(CrmCustomerFollowMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(CrmCustomerFollowMeta.NOTES));
				this.setRecTime( (Date)r.getValue(CrmCustomerFollowMeta.REC_TIME));
				this.setUpdateTime( (Date)r.getValue(CrmCustomerFollowMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(CrmCustomerFollowMeta.VERSION));
				this.setContent( (String)r.getValue(CrmCustomerFollowMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(CrmCustomerFollowMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CrmCustomerFollowMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CrmCustomerFollowMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CrmCustomerFollowMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CrmCustomerFollowMeta.DELETE_TIME));
				this.setCustomerId( (String)r.getValue(CrmCustomerFollowMeta.CUSTOMER_ID));
				this.setTenantId( (String)r.getValue(CrmCustomerFollowMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CrmCustomerFollowMeta.DELETE_BY));
				this.setId( (String)r.getValue(CrmCustomerFollowMeta.ID));
				this.setOriginatorId( (String)r.getValue(CrmCustomerFollowMeta.ORIGINATOR_ID));
				this.setFileId( (String)r.getValue(CrmCustomerFollowMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}