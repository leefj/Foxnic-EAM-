package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_TRAINING_INSTRUCTOR;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.TrainingInstructorMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 培训讲师
 * <p>培训讲师 , 数据表 hr_training_instructor 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-17 17:15:31
 * @sign 8F99E412F7BAFFA79B688F881EA20763
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_training_instructor")
@ApiModel(description = "培训讲师 ; 培训讲师 , 数据表 hr_training_instructor 的PO类型")
public class TrainingInstructor extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_TRAINING_INSTRUCTOR.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 工作单位：工作单位
	*/
	@ApiModelProperty(required = false,value="工作单位" , notes = "工作单位")
	private String orgId;
	
	/**
	 * 姓名：姓名
	*/
	@ApiModelProperty(required = false,value="姓名" , notes = "姓名")
	private String name;
	
	/**
	 * 社会头衔：社会头衔
	*/
	@ApiModelProperty(required = false,value="社会头衔" , notes = "社会头衔")
	private String title;
	
	/**
	 * 联系方式：联系方式
	*/
	@ApiModelProperty(required = false,value="联系方式" , notes = "联系方式")
	private String contactInformation;
	
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
	 * trainingInstitution：trainingInstitution
	*/
	@ApiModelProperty(required = false,value="trainingInstitution" , notes = "trainingInstitution")
	private TrainingInstitution trainingInstitution;
	
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
	public TrainingInstructor setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 工作单位<br>
	 * 工作单位
	 * @return 工作单位
	*/
	public String getOrgId() {
		return orgId;
	}
	
	/**
	 * 设置 工作单位
	 * @param orgId 工作单位
	 * @return 当前对象
	*/
	public TrainingInstructor setOrgId(String orgId) {
		this.orgId=orgId;
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
	public TrainingInstructor setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 社会头衔<br>
	 * 社会头衔
	 * @return 社会头衔
	*/
	public String getTitle() {
		return title;
	}
	
	/**
	 * 设置 社会头衔
	 * @param title 社会头衔
	 * @return 当前对象
	*/
	public TrainingInstructor setTitle(String title) {
		this.title=title;
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
	public TrainingInstructor setContactInformation(String contactInformation) {
		this.contactInformation=contactInformation;
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
	public TrainingInstructor setNotes(String notes) {
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
	public TrainingInstructor setFileId(String fileId) {
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
	public TrainingInstructor setCreateBy(String createBy) {
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
	public TrainingInstructor setCreateTime(Date createTime) {
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
	public TrainingInstructor setUpdateBy(String updateBy) {
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
	public TrainingInstructor setUpdateTime(Date updateTime) {
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
	public TrainingInstructor setDeleted(Integer deleted) {
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
	public TrainingInstructor setDeleted(Boolean deletedBool) {
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
	public TrainingInstructor setDeleteBy(String deleteBy) {
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
	public TrainingInstructor setDeleteTime(Date deleteTime) {
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
	public TrainingInstructor setVersion(Integer version) {
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
	public TrainingInstructor setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 trainingInstitution<br>
	 * trainingInstitution
	 * @return trainingInstitution
	*/
	public TrainingInstitution getTrainingInstitution() {
		return trainingInstitution;
	}
	
	/**
	 * 设置 trainingInstitution
	 * @param trainingInstitution trainingInstitution
	 * @return 当前对象
	*/
	public TrainingInstructor setTrainingInstitution(TrainingInstitution trainingInstitution) {
		this.trainingInstitution=trainingInstitution;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return TrainingInstructor , 转换好的 TrainingInstructor 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return TrainingInstructor , 转换好的 PoJo 对象
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
	public TrainingInstructor clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public TrainingInstructor duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.TrainingInstructorMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.TrainingInstructorMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setTitle(this.getTitle());
		inst.setVersion(this.getVersion());
		inst.setOrgId(this.getOrgId());
		inst.setCreateBy(this.getCreateBy());
		inst.setContactInformation(this.getContactInformation());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setFileId(this.getFileId());
		if(all) {
			inst.setTrainingInstitution(this.getTrainingInstitution());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public TrainingInstructor clone(boolean deep) {
		return EntityContext.clone(TrainingInstructor.class,this,deep);
	}

	/**
	 * 将 Map 转换成 TrainingInstructor
	 * @param trainingInstructorMap 包含实体信息的 Map 对象
	 * @return TrainingInstructor , 转换好的的 TrainingInstructor 对象
	*/
	@Transient
	public static TrainingInstructor createFrom(Map<String,Object> trainingInstructorMap) {
		if(trainingInstructorMap==null) return null;
		TrainingInstructor po = create();
		EntityContext.copyProperties(po,trainingInstructorMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 TrainingInstructor
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return TrainingInstructor , 转换好的的 TrainingInstructor 对象
	*/
	@Transient
	public static TrainingInstructor createFrom(Object pojo) {
		if(pojo==null) return null;
		TrainingInstructor po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 TrainingInstructor，等同于 new
	 * @return TrainingInstructor 对象
	*/
	@Transient
	public static TrainingInstructor create() {
		return new com.dt.platform.domain.hr.meta.TrainingInstructorMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(TrainingInstructorMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(TrainingInstructorMeta.UPDATE_TIME)));
			this.setTitle(DataParser.parse(String.class, map.get(TrainingInstructorMeta.TITLE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(TrainingInstructorMeta.VERSION)));
			this.setOrgId(DataParser.parse(String.class, map.get(TrainingInstructorMeta.ORG_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(TrainingInstructorMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, map.get(TrainingInstructorMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(TrainingInstructorMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(TrainingInstructorMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(TrainingInstructorMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(TrainingInstructorMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(TrainingInstructorMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(TrainingInstructorMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(TrainingInstructorMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(TrainingInstructorMeta.ID)));
			this.setFileId(DataParser.parse(String.class, map.get(TrainingInstructorMeta.FILE_ID)));
			// others
			this.setTrainingInstitution(DataParser.parse(TrainingInstitution.class, map.get(TrainingInstructorMeta.TRAINING_INSTITUTION)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(TrainingInstructorMeta.NOTES));
				this.setUpdateTime( (Date)map.get(TrainingInstructorMeta.UPDATE_TIME));
				this.setTitle( (String)map.get(TrainingInstructorMeta.TITLE));
				this.setVersion( (Integer)map.get(TrainingInstructorMeta.VERSION));
				this.setOrgId( (String)map.get(TrainingInstructorMeta.ORG_ID));
				this.setCreateBy( (String)map.get(TrainingInstructorMeta.CREATE_BY));
				this.setContactInformation( (String)map.get(TrainingInstructorMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)map.get(TrainingInstructorMeta.DELETED));
				this.setCreateTime( (Date)map.get(TrainingInstructorMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(TrainingInstructorMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(TrainingInstructorMeta.DELETE_TIME));
				this.setName( (String)map.get(TrainingInstructorMeta.NAME));
				this.setTenantId( (String)map.get(TrainingInstructorMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(TrainingInstructorMeta.DELETE_BY));
				this.setId( (String)map.get(TrainingInstructorMeta.ID));
				this.setFileId( (String)map.get(TrainingInstructorMeta.FILE_ID));
				// others
				this.setTrainingInstitution( (TrainingInstitution)map.get(TrainingInstructorMeta.TRAINING_INSTITUTION));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(TrainingInstructorMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(TrainingInstructorMeta.UPDATE_TIME)));
			this.setTitle(DataParser.parse(String.class, r.getValue(TrainingInstructorMeta.TITLE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(TrainingInstructorMeta.VERSION)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(TrainingInstructorMeta.ORG_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(TrainingInstructorMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, r.getValue(TrainingInstructorMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(TrainingInstructorMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(TrainingInstructorMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(TrainingInstructorMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(TrainingInstructorMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(TrainingInstructorMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(TrainingInstructorMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(TrainingInstructorMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(TrainingInstructorMeta.ID)));
			this.setFileId(DataParser.parse(String.class, r.getValue(TrainingInstructorMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(TrainingInstructorMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(TrainingInstructorMeta.UPDATE_TIME));
				this.setTitle( (String)r.getValue(TrainingInstructorMeta.TITLE));
				this.setVersion( (Integer)r.getValue(TrainingInstructorMeta.VERSION));
				this.setOrgId( (String)r.getValue(TrainingInstructorMeta.ORG_ID));
				this.setCreateBy( (String)r.getValue(TrainingInstructorMeta.CREATE_BY));
				this.setContactInformation( (String)r.getValue(TrainingInstructorMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)r.getValue(TrainingInstructorMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(TrainingInstructorMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(TrainingInstructorMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(TrainingInstructorMeta.DELETE_TIME));
				this.setName( (String)r.getValue(TrainingInstructorMeta.NAME));
				this.setTenantId( (String)r.getValue(TrainingInstructorMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(TrainingInstructorMeta.DELETE_BY));
				this.setId( (String)r.getValue(TrainingInstructorMeta.ID));
				this.setFileId( (String)r.getValue(TrainingInstructorMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}