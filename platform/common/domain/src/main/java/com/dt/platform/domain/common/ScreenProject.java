package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_SCREEN_PROJECT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.ScreenProjectMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 项目
 * <p>项目 , 数据表 sys_screen_project 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-30 14:12:23
 * @sign 8477214B8D5778CB57F7B802BBA161CF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_screen_project")
@ApiModel(description = "项目 ; 项目 , 数据表 sys_screen_project 的PO类型")
public class ScreenProject extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_SCREEN_PROJECT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 项目：项目
	*/
	@ApiModelProperty(required = false,value="项目" , notes = "项目")
	private String projectName;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String state;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String indexImage;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String remarks;
	
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
	@ApiModelProperty(required = false,value="version" , notes = "version")
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
	public ScreenProject setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 项目<br>
	 * 项目
	 * @return 项目
	*/
	public String getProjectName() {
		return projectName;
	}
	
	/**
	 * 设置 项目
	 * @param projectName 项目
	 * @return 当前对象
	*/
	public ScreenProject setProjectName(String projectName) {
		this.projectName=projectName;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getState() {
		return state;
	}
	
	/**
	 * 设置 状态
	 * @param state 状态
	 * @return 当前对象
	*/
	public ScreenProject setState(String state) {
		this.state=state;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getIndexImage() {
		return indexImage;
	}
	
	/**
	 * 设置 备注
	 * @param indexImage 备注
	 * @return 当前对象
	*/
	public ScreenProject setIndexImage(String indexImage) {
		this.indexImage=indexImage;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getRemarks() {
		return remarks;
	}
	
	/**
	 * 设置 备注
	 * @param remarks 备注
	 * @return 当前对象
	*/
	public ScreenProject setRemarks(String remarks) {
		this.remarks=remarks;
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
	public ScreenProject setCreateBy(String createBy) {
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
	public ScreenProject setCreateTime(Date createTime) {
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
	public ScreenProject setUpdateBy(String updateBy) {
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
	public ScreenProject setUpdateTime(Date updateTime) {
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
	public ScreenProject setDeleted(Integer deleted) {
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
	public ScreenProject setDeleted(Boolean deletedBool) {
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
	public ScreenProject setDeleteBy(String deleteBy) {
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
	public ScreenProject setDeleteTime(Date deleteTime) {
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
	public ScreenProject setVersion(Integer version) {
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
	public ScreenProject setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ScreenProject , 转换好的 ScreenProject 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ScreenProject , 转换好的 PoJo 对象
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
	public ScreenProject clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ScreenProject duplicate(boolean all) {
		com.dt.platform.domain.common.meta.ScreenProjectMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.ScreenProjectMeta.$$proxy$$();
		inst.setIndexImage(this.getIndexImage());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setState(this.getState());
		inst.setProjectName(this.getProjectName());
		inst.setRemarks(this.getRemarks());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ScreenProject clone(boolean deep) {
		return EntityContext.clone(ScreenProject.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ScreenProject
	 * @param screenProjectMap 包含实体信息的 Map 对象
	 * @return ScreenProject , 转换好的的 ScreenProject 对象
	*/
	@Transient
	public static ScreenProject createFrom(Map<String,Object> screenProjectMap) {
		if(screenProjectMap==null) return null;
		ScreenProject po = create();
		EntityContext.copyProperties(po,screenProjectMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ScreenProject
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ScreenProject , 转换好的的 ScreenProject 对象
	*/
	@Transient
	public static ScreenProject createFrom(Object pojo) {
		if(pojo==null) return null;
		ScreenProject po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ScreenProject，等同于 new
	 * @return ScreenProject 对象
	*/
	@Transient
	public static ScreenProject create() {
		return new com.dt.platform.domain.common.meta.ScreenProjectMeta.$$proxy$$();
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
			this.setIndexImage(DataParser.parse(String.class, map.get(ScreenProjectMeta.INDEX_IMAGE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ScreenProjectMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ScreenProjectMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ScreenProjectMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ScreenProjectMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ScreenProjectMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ScreenProjectMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ScreenProjectMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ScreenProjectMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ScreenProjectMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ScreenProjectMeta.ID)));
			this.setState(DataParser.parse(String.class, map.get(ScreenProjectMeta.STATE)));
			this.setProjectName(DataParser.parse(String.class, map.get(ScreenProjectMeta.PROJECT_NAME)));
			this.setRemarks(DataParser.parse(String.class, map.get(ScreenProjectMeta.REMARKS)));
			// others
			return true;
		} else {
			try {
				this.setIndexImage( (String)map.get(ScreenProjectMeta.INDEX_IMAGE));
				this.setUpdateTime( (Date)map.get(ScreenProjectMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(ScreenProjectMeta.VERSION));
				this.setCreateBy( (String)map.get(ScreenProjectMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ScreenProjectMeta.DELETED));
				this.setCreateTime( (Date)map.get(ScreenProjectMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ScreenProjectMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ScreenProjectMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(ScreenProjectMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ScreenProjectMeta.DELETE_BY));
				this.setId( (String)map.get(ScreenProjectMeta.ID));
				this.setState( (String)map.get(ScreenProjectMeta.STATE));
				this.setProjectName( (String)map.get(ScreenProjectMeta.PROJECT_NAME));
				this.setRemarks( (String)map.get(ScreenProjectMeta.REMARKS));
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
			this.setIndexImage(DataParser.parse(String.class, r.getValue(ScreenProjectMeta.INDEX_IMAGE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ScreenProjectMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ScreenProjectMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ScreenProjectMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ScreenProjectMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ScreenProjectMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ScreenProjectMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ScreenProjectMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ScreenProjectMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ScreenProjectMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ScreenProjectMeta.ID)));
			this.setState(DataParser.parse(String.class, r.getValue(ScreenProjectMeta.STATE)));
			this.setProjectName(DataParser.parse(String.class, r.getValue(ScreenProjectMeta.PROJECT_NAME)));
			this.setRemarks(DataParser.parse(String.class, r.getValue(ScreenProjectMeta.REMARKS)));
			return true;
		} else {
			try {
				this.setIndexImage( (String)r.getValue(ScreenProjectMeta.INDEX_IMAGE));
				this.setUpdateTime( (Date)r.getValue(ScreenProjectMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(ScreenProjectMeta.VERSION));
				this.setCreateBy( (String)r.getValue(ScreenProjectMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ScreenProjectMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ScreenProjectMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ScreenProjectMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ScreenProjectMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(ScreenProjectMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ScreenProjectMeta.DELETE_BY));
				this.setId( (String)r.getValue(ScreenProjectMeta.ID));
				this.setState( (String)r.getValue(ScreenProjectMeta.STATE));
				this.setProjectName( (String)r.getValue(ScreenProjectMeta.PROJECT_NAME));
				this.setRemarks( (String)r.getValue(ScreenProjectMeta.REMARKS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}