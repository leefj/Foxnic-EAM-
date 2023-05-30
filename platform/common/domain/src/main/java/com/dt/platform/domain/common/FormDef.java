package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_FORM_DEF;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.FormDefMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 表单定义
 * <p>表单定义 , 数据表 sys_form_def 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-26 15:20:47
 * @sign 7B7953F1F2CB93F9CE34D5DF4FB1E0F0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_form_def")
@ApiModel(description = "表单定义 ; 表单定义 , 数据表 sys_form_def 的PO类型")
public class FormDef extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_FORM_DEF.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "713016385990557697")
	private String id;
	
	/**
	 * 表单：表单
	*/
	@ApiModelProperty(required = false,value="表单" , notes = "表单" , example = "712657630111203328")
	private String formId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "draft")
	private String status;
	
	/**
	 * 定义：定义
	*/
	@ApiModelProperty(required = false,value="定义" , notes = "定义")
	private String designerData;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "121212")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-05-22 01:12:34")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-05-22 09:33:37")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "1")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID" , example = "110588348101165911")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间" , example = "2023-05-22 09:33:37")
	private Date deleteTime;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = false,value="version" , notes = "version" , example = "2")
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
	public FormDef setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 表单<br>
	 * 表单
	 * @return 表单
	*/
	public String getFormId() {
		return formId;
	}
	
	/**
	 * 设置 表单
	 * @param formId 表单
	 * @return 当前对象
	*/
	public FormDef setFormId(String formId) {
		this.formId=formId;
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
	public FormDef setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 定义<br>
	 * 定义
	 * @return 定义
	*/
	public String getDesignerData() {
		return designerData;
	}
	
	/**
	 * 设置 定义
	 * @param designerData 定义
	 * @return 当前对象
	*/
	public FormDef setDesignerData(String designerData) {
		this.designerData=designerData;
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
	public FormDef setNotes(String notes) {
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
	public FormDef setCreateBy(String createBy) {
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
	public FormDef setCreateTime(Date createTime) {
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
	public FormDef setUpdateBy(String updateBy) {
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
	public FormDef setUpdateTime(Date updateTime) {
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
	public FormDef setDeleted(Integer deleted) {
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
	public FormDef setDeleted(Boolean deletedBool) {
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
	public FormDef setDeleteBy(String deleteBy) {
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
	public FormDef setDeleteTime(Date deleteTime) {
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
	public FormDef setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return FormDef , 转换好的 FormDef 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return FormDef , 转换好的 PoJo 对象
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
	public FormDef clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public FormDef duplicate(boolean all) {
		com.dt.platform.domain.common.meta.FormDefMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.FormDefMeta.$$proxy$$();
		inst.setFormId(this.getFormId());
		inst.setDesignerData(this.getDesignerData());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public FormDef clone(boolean deep) {
		return EntityContext.clone(FormDef.class,this,deep);
	}

	/**
	 * 将 Map 转换成 FormDef
	 * @param formDefMap 包含实体信息的 Map 对象
	 * @return FormDef , 转换好的的 FormDef 对象
	*/
	@Transient
	public static FormDef createFrom(Map<String,Object> formDefMap) {
		if(formDefMap==null) return null;
		FormDef po = create();
		EntityContext.copyProperties(po,formDefMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 FormDef
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return FormDef , 转换好的的 FormDef 对象
	*/
	@Transient
	public static FormDef createFrom(Object pojo) {
		if(pojo==null) return null;
		FormDef po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 FormDef，等同于 new
	 * @return FormDef 对象
	*/
	@Transient
	public static FormDef create() {
		return new com.dt.platform.domain.common.meta.FormDefMeta.$$proxy$$();
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
			this.setFormId(DataParser.parse(String.class, map.get(FormDefMeta.FORM_ID)));
			this.setDesignerData(DataParser.parse(String.class, map.get(FormDefMeta.DESIGNER_DATA)));
			this.setNotes(DataParser.parse(String.class, map.get(FormDefMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(FormDefMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(FormDefMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(FormDefMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(FormDefMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(FormDefMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(FormDefMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(FormDefMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(FormDefMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(FormDefMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(FormDefMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setFormId( (String)map.get(FormDefMeta.FORM_ID));
				this.setDesignerData( (String)map.get(FormDefMeta.DESIGNER_DATA));
				this.setNotes( (String)map.get(FormDefMeta.NOTES));
				this.setUpdateTime( (Date)map.get(FormDefMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(FormDefMeta.VERSION));
				this.setCreateBy( (String)map.get(FormDefMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(FormDefMeta.DELETED));
				this.setCreateTime( (Date)map.get(FormDefMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(FormDefMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(FormDefMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(FormDefMeta.DELETE_BY));
				this.setId( (String)map.get(FormDefMeta.ID));
				this.setStatus( (String)map.get(FormDefMeta.STATUS));
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
			this.setFormId(DataParser.parse(String.class, r.getValue(FormDefMeta.FORM_ID)));
			this.setDesignerData(DataParser.parse(String.class, r.getValue(FormDefMeta.DESIGNER_DATA)));
			this.setNotes(DataParser.parse(String.class, r.getValue(FormDefMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(FormDefMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(FormDefMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(FormDefMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(FormDefMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(FormDefMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(FormDefMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(FormDefMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(FormDefMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(FormDefMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(FormDefMeta.STATUS)));
			return true;
		} else {
			try {
				this.setFormId( (String)r.getValue(FormDefMeta.FORM_ID));
				this.setDesignerData( (String)r.getValue(FormDefMeta.DESIGNER_DATA));
				this.setNotes( (String)r.getValue(FormDefMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(FormDefMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(FormDefMeta.VERSION));
				this.setCreateBy( (String)r.getValue(FormDefMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(FormDefMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(FormDefMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(FormDefMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(FormDefMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(FormDefMeta.DELETE_BY));
				this.setId( (String)r.getValue(FormDefMeta.ID));
				this.setStatus( (String)r.getValue(FormDefMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}