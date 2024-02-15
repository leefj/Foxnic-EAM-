package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_SCORE_TASK_ORG;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.ScoreTaskOrgMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 任务部门
 * <p>任务部门 , 数据表 hr_score_task_org 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-14 17:20:59
 * @sign A3A29CA5DB90509A266F6089967A2BFE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_score_task_org")
@ApiModel(description = "任务部门 ; 任务部门 , 数据表 hr_score_task_org 的PO类型")
public class ScoreTaskOrg extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_SCORE_TASK_ORG.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 任务：任务
	*/
	@ApiModelProperty(required = false,value="任务" , notes = "任务")
	private String configId;
	
	/**
	 * 关系：关系
	*/
	@ApiModelProperty(required = false,value="关系" , notes = "关系")
	private String relationship;
	
	/**
	 * 包含部门：包含部门
	*/
	@ApiModelProperty(required = false,value="包含部门" , notes = "包含部门")
	private String orgInclude;
	
	/**
	 * 排除部门：排除部门
	*/
	@ApiModelProperty(required = false,value="排除部门" , notes = "排除部门")
	private String orgExclude;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	public ScoreTaskOrg setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 任务<br>
	 * 任务
	 * @return 任务
	*/
	public String getConfigId() {
		return configId;
	}
	
	/**
	 * 设置 任务
	 * @param configId 任务
	 * @return 当前对象
	*/
	public ScoreTaskOrg setConfigId(String configId) {
		this.configId=configId;
		return this;
	}
	
	/**
	 * 获得 关系<br>
	 * 关系
	 * @return 关系
	*/
	public String getRelationship() {
		return relationship;
	}
	
	/**
	 * 设置 关系
	 * @param relationship 关系
	 * @return 当前对象
	*/
	public ScoreTaskOrg setRelationship(String relationship) {
		this.relationship=relationship;
		return this;
	}
	
	/**
	 * 获得 包含部门<br>
	 * 包含部门
	 * @return 包含部门
	*/
	public String getOrgInclude() {
		return orgInclude;
	}
	
	/**
	 * 设置 包含部门
	 * @param orgInclude 包含部门
	 * @return 当前对象
	*/
	public ScoreTaskOrg setOrgInclude(String orgInclude) {
		this.orgInclude=orgInclude;
		return this;
	}
	
	/**
	 * 获得 排除部门<br>
	 * 排除部门
	 * @return 排除部门
	*/
	public String getOrgExclude() {
		return orgExclude;
	}
	
	/**
	 * 设置 排除部门
	 * @param orgExclude 排除部门
	 * @return 当前对象
	*/
	public ScoreTaskOrg setOrgExclude(String orgExclude) {
		this.orgExclude=orgExclude;
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
	public ScoreTaskOrg setNotes(String notes) {
		this.notes=notes;
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
	public ScoreTaskOrg setCreateBy(String createBy) {
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
	public ScoreTaskOrg setCreateTime(Date createTime) {
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
	public ScoreTaskOrg setUpdateBy(String updateBy) {
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
	public ScoreTaskOrg setUpdateTime(Date updateTime) {
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
	public ScoreTaskOrg setDeleted(Integer deleted) {
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
	public ScoreTaskOrg setDeleted(Boolean deletedBool) {
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
	public ScoreTaskOrg setDeleteBy(String deleteBy) {
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
	public ScoreTaskOrg setDeleteTime(Date deleteTime) {
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
	public ScoreTaskOrg setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ScoreTaskOrg , 转换好的 ScoreTaskOrg 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ScoreTaskOrg , 转换好的 PoJo 对象
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
	public ScoreTaskOrg clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ScoreTaskOrg duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.ScoreTaskOrgMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.ScoreTaskOrgMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setOrgInclude(this.getOrgInclude());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setOrgExclude(this.getOrgExclude());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setConfigId(this.getConfigId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setRelationship(this.getRelationship());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ScoreTaskOrg clone(boolean deep) {
		return EntityContext.clone(ScoreTaskOrg.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ScoreTaskOrg
	 * @param scoreTaskOrgMap 包含实体信息的 Map 对象
	 * @return ScoreTaskOrg , 转换好的的 ScoreTaskOrg 对象
	*/
	@Transient
	public static ScoreTaskOrg createFrom(Map<String,Object> scoreTaskOrgMap) {
		if(scoreTaskOrgMap==null) return null;
		ScoreTaskOrg po = create();
		EntityContext.copyProperties(po,scoreTaskOrgMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ScoreTaskOrg
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ScoreTaskOrg , 转换好的的 ScoreTaskOrg 对象
	*/
	@Transient
	public static ScoreTaskOrg createFrom(Object pojo) {
		if(pojo==null) return null;
		ScoreTaskOrg po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ScoreTaskOrg，等同于 new
	 * @return ScoreTaskOrg 对象
	*/
	@Transient
	public static ScoreTaskOrg create() {
		return new com.dt.platform.domain.hr.meta.ScoreTaskOrgMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(ScoreTaskOrgMeta.NOTES)));
			this.setOrgInclude(DataParser.parse(String.class, map.get(ScoreTaskOrgMeta.ORG_INCLUDE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ScoreTaskOrgMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ScoreTaskOrgMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ScoreTaskOrgMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ScoreTaskOrgMeta.DELETED)));
			this.setOrgExclude(DataParser.parse(String.class, map.get(ScoreTaskOrgMeta.ORG_EXCLUDE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ScoreTaskOrgMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ScoreTaskOrgMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ScoreTaskOrgMeta.DELETE_TIME)));
			this.setConfigId(DataParser.parse(String.class, map.get(ScoreTaskOrgMeta.CONFIG_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ScoreTaskOrgMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ScoreTaskOrgMeta.ID)));
			this.setRelationship(DataParser.parse(String.class, map.get(ScoreTaskOrgMeta.RELATIONSHIP)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(ScoreTaskOrgMeta.NOTES));
				this.setOrgInclude( (String)map.get(ScoreTaskOrgMeta.ORG_INCLUDE));
				this.setUpdateTime( (Date)map.get(ScoreTaskOrgMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(ScoreTaskOrgMeta.VERSION));
				this.setCreateBy( (String)map.get(ScoreTaskOrgMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ScoreTaskOrgMeta.DELETED));
				this.setOrgExclude( (String)map.get(ScoreTaskOrgMeta.ORG_EXCLUDE));
				this.setCreateTime( (Date)map.get(ScoreTaskOrgMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ScoreTaskOrgMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ScoreTaskOrgMeta.DELETE_TIME));
				this.setConfigId( (String)map.get(ScoreTaskOrgMeta.CONFIG_ID));
				this.setDeleteBy( (String)map.get(ScoreTaskOrgMeta.DELETE_BY));
				this.setId( (String)map.get(ScoreTaskOrgMeta.ID));
				this.setRelationship( (String)map.get(ScoreTaskOrgMeta.RELATIONSHIP));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(ScoreTaskOrgMeta.NOTES)));
			this.setOrgInclude(DataParser.parse(String.class, r.getValue(ScoreTaskOrgMeta.ORG_INCLUDE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ScoreTaskOrgMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ScoreTaskOrgMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ScoreTaskOrgMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ScoreTaskOrgMeta.DELETED)));
			this.setOrgExclude(DataParser.parse(String.class, r.getValue(ScoreTaskOrgMeta.ORG_EXCLUDE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ScoreTaskOrgMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ScoreTaskOrgMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ScoreTaskOrgMeta.DELETE_TIME)));
			this.setConfigId(DataParser.parse(String.class, r.getValue(ScoreTaskOrgMeta.CONFIG_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ScoreTaskOrgMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ScoreTaskOrgMeta.ID)));
			this.setRelationship(DataParser.parse(String.class, r.getValue(ScoreTaskOrgMeta.RELATIONSHIP)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(ScoreTaskOrgMeta.NOTES));
				this.setOrgInclude( (String)r.getValue(ScoreTaskOrgMeta.ORG_INCLUDE));
				this.setUpdateTime( (Date)r.getValue(ScoreTaskOrgMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(ScoreTaskOrgMeta.VERSION));
				this.setCreateBy( (String)r.getValue(ScoreTaskOrgMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ScoreTaskOrgMeta.DELETED));
				this.setOrgExclude( (String)r.getValue(ScoreTaskOrgMeta.ORG_EXCLUDE));
				this.setCreateTime( (Date)r.getValue(ScoreTaskOrgMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ScoreTaskOrgMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ScoreTaskOrgMeta.DELETE_TIME));
				this.setConfigId( (String)r.getValue(ScoreTaskOrgMeta.CONFIG_ID));
				this.setDeleteBy( (String)r.getValue(ScoreTaskOrgMeta.DELETE_BY));
				this.setId( (String)r.getValue(ScoreTaskOrgMeta.ID));
				this.setRelationship( (String)r.getValue(ScoreTaskOrgMeta.RELATIONSHIP));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}