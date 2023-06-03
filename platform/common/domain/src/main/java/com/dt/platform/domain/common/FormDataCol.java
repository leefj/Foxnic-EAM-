package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_FORM_DATA_COL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.FormDataColMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 数据字段
 * <p>数据字段 , 数据表 sys_form_data_col 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 06:53:45
 * @sign 7005BA904B65C8E06F8C9EB10356C3C8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_form_data_col")
@ApiModel(description = "数据字段 ; 数据字段 , 数据表 sys_form_data_col 的PO类型")
public class FormDataCol extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_FORM_DATA_COL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "d1")
	private String id;
	
	/**
	 * 字段：字段
	*/
	@ApiModelProperty(required = false,value="字段" , notes = "字段" , example = "d1")
	private String col;
	
	/**
	 * 字段类型：字段类型
	*/
	@ApiModelProperty(required = false,value="字段类型" , notes = "字段类型" , example = "datetime")
	private String colType;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
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
	 * version：version
	*/
	@ApiModelProperty(required = false,value="version" , notes = "version" , example = "1")
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
	public FormDataCol setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 字段<br>
	 * 字段
	 * @return 字段
	*/
	public String getCol() {
		return col;
	}
	
	/**
	 * 设置 字段
	 * @param col 字段
	 * @return 当前对象
	*/
	public FormDataCol setCol(String col) {
		this.col=col;
		return this;
	}
	
	/**
	 * 获得 字段类型<br>
	 * 字段类型
	 * @return 字段类型
	*/
	public String getColType() {
		return colType;
	}
	
	/**
	 * 设置 字段类型
	 * @param colType 字段类型
	 * @return 当前对象
	*/
	public FormDataCol setColType(String colType) {
		this.colType=colType;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public FormDataCol setStatus(String status) {
		this.status=status;
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
	public FormDataCol setCreateBy(String createBy) {
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
	public FormDataCol setCreateTime(Date createTime) {
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
	public FormDataCol setUpdateBy(String updateBy) {
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
	public FormDataCol setUpdateTime(Date updateTime) {
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
	public FormDataCol setDeleted(Integer deleted) {
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
	public FormDataCol setDeleted(Boolean deletedBool) {
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
	public FormDataCol setDeleteBy(String deleteBy) {
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
	public FormDataCol setDeleteTime(Date deleteTime) {
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
	public FormDataCol setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return FormDataCol , 转换好的 FormDataCol 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return FormDataCol , 转换好的 PoJo 对象
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
	public FormDataCol clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public FormDataCol duplicate(boolean all) {
		com.dt.platform.domain.common.meta.FormDataColMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.FormDataColMeta.$$proxy$$();
		inst.setCol(this.getCol());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setColType(this.getColType());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setVersion(this.getVersion());
		inst.setStatus(this.getStatus());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public FormDataCol clone(boolean deep) {
		return EntityContext.clone(FormDataCol.class,this,deep);
	}

	/**
	 * 将 Map 转换成 FormDataCol
	 * @param formDataColMap 包含实体信息的 Map 对象
	 * @return FormDataCol , 转换好的的 FormDataCol 对象
	*/
	@Transient
	public static FormDataCol createFrom(Map<String,Object> formDataColMap) {
		if(formDataColMap==null) return null;
		FormDataCol po = create();
		EntityContext.copyProperties(po,formDataColMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 FormDataCol
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return FormDataCol , 转换好的的 FormDataCol 对象
	*/
	@Transient
	public static FormDataCol createFrom(Object pojo) {
		if(pojo==null) return null;
		FormDataCol po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 FormDataCol，等同于 new
	 * @return FormDataCol 对象
	*/
	@Transient
	public static FormDataCol create() {
		return new com.dt.platform.domain.common.meta.FormDataColMeta.$$proxy$$();
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
			this.setCol(DataParser.parse(String.class, map.get(FormDataColMeta.COL)));
			this.setCreateBy(DataParser.parse(String.class, map.get(FormDataColMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(FormDataColMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(FormDataColMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(FormDataColMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(FormDataColMeta.DELETE_TIME)));
			this.setColType(DataParser.parse(String.class, map.get(FormDataColMeta.COL_TYPE)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(FormDataColMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(FormDataColMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(FormDataColMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(FormDataColMeta.VERSION)));
			this.setStatus(DataParser.parse(String.class, map.get(FormDataColMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setCol( (String)map.get(FormDataColMeta.COL));
				this.setCreateBy( (String)map.get(FormDataColMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(FormDataColMeta.DELETED));
				this.setCreateTime( (Date)map.get(FormDataColMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(FormDataColMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(FormDataColMeta.DELETE_TIME));
				this.setColType( (String)map.get(FormDataColMeta.COL_TYPE));
				this.setDeleteBy( (String)map.get(FormDataColMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(FormDataColMeta.UPDATE_TIME));
				this.setId( (String)map.get(FormDataColMeta.ID));
				this.setVersion( (Integer)map.get(FormDataColMeta.VERSION));
				this.setStatus( (String)map.get(FormDataColMeta.STATUS));
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
			this.setCol(DataParser.parse(String.class, r.getValue(FormDataColMeta.COL)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(FormDataColMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(FormDataColMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(FormDataColMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(FormDataColMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(FormDataColMeta.DELETE_TIME)));
			this.setColType(DataParser.parse(String.class, r.getValue(FormDataColMeta.COL_TYPE)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(FormDataColMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(FormDataColMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(FormDataColMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(FormDataColMeta.VERSION)));
			this.setStatus(DataParser.parse(String.class, r.getValue(FormDataColMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCol( (String)r.getValue(FormDataColMeta.COL));
				this.setCreateBy( (String)r.getValue(FormDataColMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(FormDataColMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(FormDataColMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(FormDataColMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(FormDataColMeta.DELETE_TIME));
				this.setColType( (String)r.getValue(FormDataColMeta.COL_TYPE));
				this.setDeleteBy( (String)r.getValue(FormDataColMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(FormDataColMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(FormDataColMeta.ID));
				this.setVersion( (Integer)r.getValue(FormDataColMeta.VERSION));
				this.setStatus( (String)r.getValue(FormDataColMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}