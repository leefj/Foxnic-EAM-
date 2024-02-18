package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_TRAINING_INSTITUTION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.TrainingInstitutionMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 培训机构
 * <p>培训机构 , 数据表 hr_training_institution 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-17 17:16:23
 * @sign 3F774516F7AF9B1B9EB724CD887A62DD
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_training_institution")
@ApiModel(description = "培训机构 ; 培训机构 , 数据表 hr_training_institution 的PO类型")
public class TrainingInstitution extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_TRAINING_INSTITUTION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 机构名称：机构名称
	*/
	@ApiModelProperty(required = false,value="机构名称" , notes = "机构名称")
	private String name;
	
	/**
	 * 联系人：联系人
	*/
	@ApiModelProperty(required = false,value="联系人" , notes = "联系人")
	private String contact;
	
	/**
	 * 联系方式：联系方式
	*/
	@ApiModelProperty(required = false,value="联系方式" , notes = "联系方式")
	private String contactInformation;
	
	/**
	 * 机构介绍：机构介绍
	*/
	@ApiModelProperty(required = false,value="机构介绍" , notes = "机构介绍")
	private String profile;
	
	/**
	 * 网址：网址
	*/
	@ApiModelProperty(required = false,value="网址" , notes = "网址")
	private String website;
	
	/**
	 * 培训经历：培训经历
	*/
	@ApiModelProperty(required = false,value="培训经历" , notes = "培训经历")
	private String content;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String fileId;
	
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
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
	public TrainingInstitution setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 机构名称<br>
	 * 机构名称
	 * @return 机构名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 机构名称
	 * @param name 机构名称
	 * @return 当前对象
	*/
	public TrainingInstitution setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 联系人<br>
	 * 联系人
	 * @return 联系人
	*/
	public String getContact() {
		return contact;
	}
	
	/**
	 * 设置 联系人
	 * @param contact 联系人
	 * @return 当前对象
	*/
	public TrainingInstitution setContact(String contact) {
		this.contact=contact;
		return this;
	}
	
	/**
	 * 获得 联系方式<br>
	 * 联系方式
	 * @return 联系方式
	*/
	public String getContactInformation() {
		return contactInformation;
	}
	
	/**
	 * 设置 联系方式
	 * @param contactInformation 联系方式
	 * @return 当前对象
	*/
	public TrainingInstitution setContactInformation(String contactInformation) {
		this.contactInformation=contactInformation;
		return this;
	}
	
	/**
	 * 获得 机构介绍<br>
	 * 机构介绍
	 * @return 机构介绍
	*/
	public String getProfile() {
		return profile;
	}
	
	/**
	 * 设置 机构介绍
	 * @param profile 机构介绍
	 * @return 当前对象
	*/
	public TrainingInstitution setProfile(String profile) {
		this.profile=profile;
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
	public TrainingInstitution setWebsite(String website) {
		this.website=website;
		return this;
	}
	
	/**
	 * 获得 培训经历<br>
	 * 培训经历
	 * @return 培训经历
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 培训经历
	 * @param content 培训经历
	 * @return 当前对象
	*/
	public TrainingInstitution setContent(String content) {
		this.content=content;
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
	public TrainingInstitution setNotes(String notes) {
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
	public TrainingInstitution setFileId(String fileId) {
		this.fileId=fileId;
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
	public TrainingInstitution setCreateBy(String createBy) {
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
	public TrainingInstitution setCreateTime(Date createTime) {
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
	public TrainingInstitution setUpdateBy(String updateBy) {
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
	public TrainingInstitution setUpdateTime(Date updateTime) {
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
	public TrainingInstitution setDeleted(Integer deleted) {
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
	public TrainingInstitution setDeleted(Boolean deletedBool) {
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
	public TrainingInstitution setDeleteBy(String deleteBy) {
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
	public TrainingInstitution setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public TrainingInstitution setVersion(Integer version) {
		this.version=version;
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
	public TrainingInstitution setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return TrainingInstitution , 转换好的 TrainingInstitution 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return TrainingInstitution , 转换好的 PoJo 对象
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
	public TrainingInstitution clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public TrainingInstitution duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.TrainingInstitutionMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.TrainingInstitutionMeta.$$proxy$$();
		inst.setWebsite(this.getWebsite());
		inst.setNotes(this.getNotes());
		inst.setProfile(this.getProfile());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setContactInformation(this.getContactInformation());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setContact(this.getContact());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setFileId(this.getFileId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public TrainingInstitution clone(boolean deep) {
		return EntityContext.clone(TrainingInstitution.class,this,deep);
	}

	/**
	 * 将 Map 转换成 TrainingInstitution
	 * @param trainingInstitutionMap 包含实体信息的 Map 对象
	 * @return TrainingInstitution , 转换好的的 TrainingInstitution 对象
	*/
	@Transient
	public static TrainingInstitution createFrom(Map<String,Object> trainingInstitutionMap) {
		if(trainingInstitutionMap==null) return null;
		TrainingInstitution po = create();
		EntityContext.copyProperties(po,trainingInstitutionMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 TrainingInstitution
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return TrainingInstitution , 转换好的的 TrainingInstitution 对象
	*/
	@Transient
	public static TrainingInstitution createFrom(Object pojo) {
		if(pojo==null) return null;
		TrainingInstitution po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 TrainingInstitution，等同于 new
	 * @return TrainingInstitution 对象
	*/
	@Transient
	public static TrainingInstitution create() {
		return new com.dt.platform.domain.hr.meta.TrainingInstitutionMeta.$$proxy$$();
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
			this.setWebsite(DataParser.parse(String.class, map.get(TrainingInstitutionMeta.WEBSITE)));
			this.setNotes(DataParser.parse(String.class, map.get(TrainingInstitutionMeta.NOTES)));
			this.setProfile(DataParser.parse(String.class, map.get(TrainingInstitutionMeta.PROFILE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(TrainingInstitutionMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(TrainingInstitutionMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(TrainingInstitutionMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(TrainingInstitutionMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, map.get(TrainingInstitutionMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(TrainingInstitutionMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(TrainingInstitutionMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(TrainingInstitutionMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(TrainingInstitutionMeta.DELETE_TIME)));
			this.setContact(DataParser.parse(String.class, map.get(TrainingInstitutionMeta.CONTACT)));
			this.setName(DataParser.parse(String.class, map.get(TrainingInstitutionMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(TrainingInstitutionMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(TrainingInstitutionMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(TrainingInstitutionMeta.ID)));
			this.setFileId(DataParser.parse(String.class, map.get(TrainingInstitutionMeta.FILE_ID)));
			// others
			return true;
		} else {
			try {
				this.setWebsite( (String)map.get(TrainingInstitutionMeta.WEBSITE));
				this.setNotes( (String)map.get(TrainingInstitutionMeta.NOTES));
				this.setProfile( (String)map.get(TrainingInstitutionMeta.PROFILE));
				this.setUpdateTime( (Date)map.get(TrainingInstitutionMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(TrainingInstitutionMeta.VERSION));
				this.setContent( (String)map.get(TrainingInstitutionMeta.CONTENT));
				this.setCreateBy( (String)map.get(TrainingInstitutionMeta.CREATE_BY));
				this.setContactInformation( (String)map.get(TrainingInstitutionMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)map.get(TrainingInstitutionMeta.DELETED));
				this.setCreateTime( (Date)map.get(TrainingInstitutionMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(TrainingInstitutionMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(TrainingInstitutionMeta.DELETE_TIME));
				this.setContact( (String)map.get(TrainingInstitutionMeta.CONTACT));
				this.setName( (String)map.get(TrainingInstitutionMeta.NAME));
				this.setTenantId( (String)map.get(TrainingInstitutionMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(TrainingInstitutionMeta.DELETE_BY));
				this.setId( (String)map.get(TrainingInstitutionMeta.ID));
				this.setFileId( (String)map.get(TrainingInstitutionMeta.FILE_ID));
				// others
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
			this.setWebsite(DataParser.parse(String.class, r.getValue(TrainingInstitutionMeta.WEBSITE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(TrainingInstitutionMeta.NOTES)));
			this.setProfile(DataParser.parse(String.class, r.getValue(TrainingInstitutionMeta.PROFILE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(TrainingInstitutionMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(TrainingInstitutionMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(TrainingInstitutionMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(TrainingInstitutionMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, r.getValue(TrainingInstitutionMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(TrainingInstitutionMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(TrainingInstitutionMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(TrainingInstitutionMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(TrainingInstitutionMeta.DELETE_TIME)));
			this.setContact(DataParser.parse(String.class, r.getValue(TrainingInstitutionMeta.CONTACT)));
			this.setName(DataParser.parse(String.class, r.getValue(TrainingInstitutionMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(TrainingInstitutionMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(TrainingInstitutionMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(TrainingInstitutionMeta.ID)));
			this.setFileId(DataParser.parse(String.class, r.getValue(TrainingInstitutionMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setWebsite( (String)r.getValue(TrainingInstitutionMeta.WEBSITE));
				this.setNotes( (String)r.getValue(TrainingInstitutionMeta.NOTES));
				this.setProfile( (String)r.getValue(TrainingInstitutionMeta.PROFILE));
				this.setUpdateTime( (Date)r.getValue(TrainingInstitutionMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(TrainingInstitutionMeta.VERSION));
				this.setContent( (String)r.getValue(TrainingInstitutionMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(TrainingInstitutionMeta.CREATE_BY));
				this.setContactInformation( (String)r.getValue(TrainingInstitutionMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)r.getValue(TrainingInstitutionMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(TrainingInstitutionMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(TrainingInstitutionMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(TrainingInstitutionMeta.DELETE_TIME));
				this.setContact( (String)r.getValue(TrainingInstitutionMeta.CONTACT));
				this.setName( (String)r.getValue(TrainingInstitutionMeta.NAME));
				this.setTenantId( (String)r.getValue(TrainingInstitutionMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(TrainingInstitutionMeta.DELETE_BY));
				this.setId( (String)r.getValue(TrainingInstitutionMeta.ID));
				this.setFileId( (String)r.getValue(TrainingInstitutionMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}