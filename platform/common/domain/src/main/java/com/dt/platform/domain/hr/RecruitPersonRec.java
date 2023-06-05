package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_RECRUIT_PERSON_REC;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.RecruitPersonRecMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 招聘记录
 * <p>招聘记录 , 数据表 hr_recruit_person_rec 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-05 15:38:55
 * @sign CF088D16C72462761F80ECE83C60E21B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_recruit_person_rec")
@ApiModel(description = "招聘记录 ; 招聘记录 , 数据表 hr_recruit_person_rec 的PO类型")
public class RecruitPersonRec extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_RECRUIT_PERSON_REC.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 招聘说明：招聘说明
	*/
	@ApiModelProperty(required = false,value="招聘说明" , notes = "招聘说明")
	private String name;
	
	/**
	 * 岗位名称：岗位名称
	*/
	@ApiModelProperty(required = false,value="岗位名称" , notes = "岗位名称")
	private String postId;
	
	/**
	 * 岗位名称：岗位名称
	*/
	@ApiModelProperty(required = false,value="岗位名称" , notes = "岗位名称")
	private String postName;
	
	/**
	 * 招聘要求：招聘要求
	*/
	@ApiModelProperty(required = false,value="招聘要求" , notes = "招聘要求")
	private String content;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间")
	private Date startDate;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间")
	private Date endDate;
	
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * recruitPostRec：recruitPostRec
	*/
	@ApiModelProperty(required = false,value="recruitPostRec" , notes = "recruitPostRec")
	private RecruitPostRec recruitPostRec;
	
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
	public RecruitPersonRec setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 招聘说明<br>
	 * 招聘说明
	 * @return 招聘说明
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 招聘说明
	 * @param name 招聘说明
	 * @return 当前对象
	*/
	public RecruitPersonRec setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 岗位名称<br>
	 * 岗位名称
	 * @return 岗位名称
	*/
	public String getPostId() {
		return postId;
	}
	
	/**
	 * 设置 岗位名称
	 * @param postId 岗位名称
	 * @return 当前对象
	*/
	public RecruitPersonRec setPostId(String postId) {
		this.postId=postId;
		return this;
	}
	
	/**
	 * 获得 岗位名称<br>
	 * 岗位名称
	 * @return 岗位名称
	*/
	public String getPostName() {
		return postName;
	}
	
	/**
	 * 设置 岗位名称
	 * @param postName 岗位名称
	 * @return 当前对象
	*/
	public RecruitPersonRec setPostName(String postName) {
		this.postName=postName;
		return this;
	}
	
	/**
	 * 获得 招聘要求<br>
	 * 招聘要求
	 * @return 招聘要求
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 招聘要求
	 * @param content 招聘要求
	 * @return 当前对象
	*/
	public RecruitPersonRec setContent(String content) {
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
	public RecruitPersonRec setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * 设置 开始时间
	 * @param startDate 开始时间
	 * @return 当前对象
	*/
	public RecruitPersonRec setStartDate(Date startDate) {
		this.startDate=startDate;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * 设置 结束时间
	 * @param endDate 结束时间
	 * @return 当前对象
	*/
	public RecruitPersonRec setEndDate(Date endDate) {
		this.endDate=endDate;
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
	public RecruitPersonRec setCreateBy(String createBy) {
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
	public RecruitPersonRec setCreateTime(Date createTime) {
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
	public RecruitPersonRec setUpdateBy(String updateBy) {
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
	public RecruitPersonRec setUpdateTime(Date updateTime) {
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
	public RecruitPersonRec setDeleted(Integer deleted) {
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
	public RecruitPersonRec setDeleted(Boolean deletedBool) {
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
	public RecruitPersonRec setDeleteBy(String deleteBy) {
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
	public RecruitPersonRec setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public RecruitPersonRec setVersion(Integer version) {
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
	public RecruitPersonRec setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 recruitPostRec<br>
	 * recruitPostRec
	 * @return recruitPostRec
	*/
	public RecruitPostRec getRecruitPostRec() {
		return recruitPostRec;
	}
	
	/**
	 * 设置 recruitPostRec
	 * @param recruitPostRec recruitPostRec
	 * @return 当前对象
	*/
	public RecruitPersonRec setRecruitPostRec(RecruitPostRec recruitPostRec) {
		this.recruitPostRec=recruitPostRec;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return RecruitPersonRec , 转换好的 RecruitPersonRec 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RecruitPersonRec , 转换好的 PoJo 对象
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
	public RecruitPersonRec clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public RecruitPersonRec duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.RecruitPersonRecMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.RecruitPersonRecMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setEndDate(this.getEndDate());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setPostId(this.getPostId());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setPostName(this.getPostName());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStartDate(this.getStartDate());
		if(all) {
			inst.setRecruitPostRec(this.getRecruitPostRec());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public RecruitPersonRec clone(boolean deep) {
		return EntityContext.clone(RecruitPersonRec.class,this,deep);
	}

	/**
	 * 将 Map 转换成 RecruitPersonRec
	 * @param recruitPersonRecMap 包含实体信息的 Map 对象
	 * @return RecruitPersonRec , 转换好的的 RecruitPersonRec 对象
	*/
	@Transient
	public static RecruitPersonRec createFrom(Map<String,Object> recruitPersonRecMap) {
		if(recruitPersonRecMap==null) return null;
		RecruitPersonRec po = create();
		EntityContext.copyProperties(po,recruitPersonRecMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 RecruitPersonRec
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RecruitPersonRec , 转换好的的 RecruitPersonRec 对象
	*/
	@Transient
	public static RecruitPersonRec createFrom(Object pojo) {
		if(pojo==null) return null;
		RecruitPersonRec po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 RecruitPersonRec，等同于 new
	 * @return RecruitPersonRec 对象
	*/
	@Transient
	public static RecruitPersonRec create() {
		return new com.dt.platform.domain.hr.meta.RecruitPersonRecMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(RecruitPersonRecMeta.NOTES)));
			this.setEndDate(DataParser.parse(Date.class, map.get(RecruitPersonRecMeta.END_DATE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(RecruitPersonRecMeta.UPDATE_TIME)));
			this.setPostId(DataParser.parse(String.class, map.get(RecruitPersonRecMeta.POST_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(RecruitPersonRecMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(RecruitPersonRecMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(RecruitPersonRecMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(RecruitPersonRecMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(RecruitPersonRecMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(RecruitPersonRecMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(RecruitPersonRecMeta.DELETE_TIME)));
			this.setPostName(DataParser.parse(String.class, map.get(RecruitPersonRecMeta.POST_NAME)));
			this.setName(DataParser.parse(String.class, map.get(RecruitPersonRecMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(RecruitPersonRecMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(RecruitPersonRecMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(RecruitPersonRecMeta.ID)));
			this.setStartDate(DataParser.parse(Date.class, map.get(RecruitPersonRecMeta.START_DATE)));
			// others
			this.setRecruitPostRec(DataParser.parse(RecruitPostRec.class, map.get(RecruitPersonRecMeta.RECRUIT_POST_REC)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(RecruitPersonRecMeta.NOTES));
				this.setEndDate( (Date)map.get(RecruitPersonRecMeta.END_DATE));
				this.setUpdateTime( (Date)map.get(RecruitPersonRecMeta.UPDATE_TIME));
				this.setPostId( (String)map.get(RecruitPersonRecMeta.POST_ID));
				this.setVersion( (Integer)map.get(RecruitPersonRecMeta.VERSION));
				this.setContent( (String)map.get(RecruitPersonRecMeta.CONTENT));
				this.setCreateBy( (String)map.get(RecruitPersonRecMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(RecruitPersonRecMeta.DELETED));
				this.setCreateTime( (Date)map.get(RecruitPersonRecMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(RecruitPersonRecMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(RecruitPersonRecMeta.DELETE_TIME));
				this.setPostName( (String)map.get(RecruitPersonRecMeta.POST_NAME));
				this.setName( (String)map.get(RecruitPersonRecMeta.NAME));
				this.setTenantId( (String)map.get(RecruitPersonRecMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(RecruitPersonRecMeta.DELETE_BY));
				this.setId( (String)map.get(RecruitPersonRecMeta.ID));
				this.setStartDate( (Date)map.get(RecruitPersonRecMeta.START_DATE));
				// others
				this.setRecruitPostRec( (RecruitPostRec)map.get(RecruitPersonRecMeta.RECRUIT_POST_REC));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(RecruitPersonRecMeta.NOTES)));
			this.setEndDate(DataParser.parse(Date.class, r.getValue(RecruitPersonRecMeta.END_DATE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(RecruitPersonRecMeta.UPDATE_TIME)));
			this.setPostId(DataParser.parse(String.class, r.getValue(RecruitPersonRecMeta.POST_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(RecruitPersonRecMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(RecruitPersonRecMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(RecruitPersonRecMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(RecruitPersonRecMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(RecruitPersonRecMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(RecruitPersonRecMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(RecruitPersonRecMeta.DELETE_TIME)));
			this.setPostName(DataParser.parse(String.class, r.getValue(RecruitPersonRecMeta.POST_NAME)));
			this.setName(DataParser.parse(String.class, r.getValue(RecruitPersonRecMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(RecruitPersonRecMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(RecruitPersonRecMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(RecruitPersonRecMeta.ID)));
			this.setStartDate(DataParser.parse(Date.class, r.getValue(RecruitPersonRecMeta.START_DATE)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(RecruitPersonRecMeta.NOTES));
				this.setEndDate( (Date)r.getValue(RecruitPersonRecMeta.END_DATE));
				this.setUpdateTime( (Date)r.getValue(RecruitPersonRecMeta.UPDATE_TIME));
				this.setPostId( (String)r.getValue(RecruitPersonRecMeta.POST_ID));
				this.setVersion( (Integer)r.getValue(RecruitPersonRecMeta.VERSION));
				this.setContent( (String)r.getValue(RecruitPersonRecMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(RecruitPersonRecMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(RecruitPersonRecMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(RecruitPersonRecMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(RecruitPersonRecMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(RecruitPersonRecMeta.DELETE_TIME));
				this.setPostName( (String)r.getValue(RecruitPersonRecMeta.POST_NAME));
				this.setName( (String)r.getValue(RecruitPersonRecMeta.NAME));
				this.setTenantId( (String)r.getValue(RecruitPersonRecMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(RecruitPersonRecMeta.DELETE_BY));
				this.setId( (String)r.getValue(RecruitPersonRecMeta.ID));
				this.setStartDate( (Date)r.getValue(RecruitPersonRecMeta.START_DATE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}