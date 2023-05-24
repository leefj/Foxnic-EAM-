package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_FORM_DATA;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.FormDataMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 表单数据
 * <p>表单数据 , 数据表 sys_form_data 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-23 07:24:00
 * @sign CFFF25961D434ECC5E299F6538C6FF6A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_form_data")
@ApiModel(description = "表单数据 ; 表单数据 , 数据表 sys_form_data 的PO类型")
public class FormData extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_FORM_DATA.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 业务归属：业务归属
	*/
	@ApiModelProperty(required = false,value="业务归属" , notes = "业务归属")
	private String ownerId;
	
	/**
	 * 表单定义：表单定义
	*/
	@ApiModelProperty(required = false,value="表单定义" , notes = "表单定义")
	private String defId;
	
	/**
	 * 表单：表单
	*/
	@ApiModelProperty(required = false,value="表单" , notes = "表单")
	private String formId;
	
	/**
	 * 设计：设计
	*/
	@ApiModelProperty(required = false,value="设计" , notes = "设计")
	private String designerData;
	
	/**
	 * 数据：数据
	*/
	@ApiModelProperty(required = false,value="数据" , notes = "数据")
	private String data;
	
	/**
	 * 表单状态：表单状态
	*/
	@ApiModelProperty(required = false,value="表单状态" , notes = "表单状态")
	private String formStatus;
	
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
	public FormData setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 业务归属<br>
	 * 业务归属
	 * @return 业务归属
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 业务归属
	 * @param ownerId 业务归属
	 * @return 当前对象
	*/
	public FormData setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 表单定义<br>
	 * 表单定义
	 * @return 表单定义
	*/
	public String getDefId() {
		return defId;
	}
	
	/**
	 * 设置 表单定义
	 * @param defId 表单定义
	 * @return 当前对象
	*/
	public FormData setDefId(String defId) {
		this.defId=defId;
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
	public FormData setFormId(String formId) {
		this.formId=formId;
		return this;
	}
	
	/**
	 * 获得 设计<br>
	 * 设计
	 * @return 设计
	*/
	public String getDesignerData() {
		return designerData;
	}
	
	/**
	 * 设置 设计
	 * @param designerData 设计
	 * @return 当前对象
	*/
	public FormData setDesignerData(String designerData) {
		this.designerData=designerData;
		return this;
	}
	
	/**
	 * 获得 数据<br>
	 * 数据
	 * @return 数据
	*/
	public String getData() {
		return data;
	}
	
	/**
	 * 设置 数据
	 * @param data 数据
	 * @return 当前对象
	*/
	public FormData setData(String data) {
		this.data=data;
		return this;
	}
	
	/**
	 * 获得 表单状态<br>
	 * 表单状态
	 * @return 表单状态
	*/
	public String getFormStatus() {
		return formStatus;
	}
	
	/**
	 * 设置 表单状态
	 * @param formStatus 表单状态
	 * @return 当前对象
	*/
	public FormData setFormStatus(String formStatus) {
		this.formStatus=formStatus;
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
	public FormData setCreateBy(String createBy) {
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
	public FormData setCreateTime(Date createTime) {
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
	public FormData setUpdateBy(String updateBy) {
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
	public FormData setUpdateTime(Date updateTime) {
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
	public FormData setDeleted(Integer deleted) {
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
	public FormData setDeleted(Boolean deletedBool) {
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
	public FormData setDeleteBy(String deleteBy) {
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
	public FormData setDeleteTime(Date deleteTime) {
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
	public FormData setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return FormData , 转换好的 FormData 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return FormData , 转换好的 PoJo 对象
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
	public FormData clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public FormData duplicate(boolean all) {
		com.dt.platform.domain.common.meta.FormDataMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.FormDataMeta.$$proxy$$();
		inst.setFormId(this.getFormId());
		inst.setDesignerData(this.getDesignerData());
		inst.setData(this.getData());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setOwnerId(this.getOwnerId());
		inst.setVersion(this.getVersion());
		inst.setDefId(this.getDefId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setFormStatus(this.getFormStatus());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public FormData clone(boolean deep) {
		return EntityContext.clone(FormData.class,this,deep);
	}

	/**
	 * 将 Map 转换成 FormData
	 * @param formDataMap 包含实体信息的 Map 对象
	 * @return FormData , 转换好的的 FormData 对象
	*/
	@Transient
	public static FormData createFrom(Map<String,Object> formDataMap) {
		if(formDataMap==null) return null;
		FormData po = create();
		EntityContext.copyProperties(po,formDataMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 FormData
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return FormData , 转换好的的 FormData 对象
	*/
	@Transient
	public static FormData createFrom(Object pojo) {
		if(pojo==null) return null;
		FormData po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 FormData，等同于 new
	 * @return FormData 对象
	*/
	@Transient
	public static FormData create() {
		return new com.dt.platform.domain.common.meta.FormDataMeta.$$proxy$$();
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
			this.setFormId(DataParser.parse(String.class, map.get(FormDataMeta.FORM_ID)));
			this.setDesignerData(DataParser.parse(String.class, map.get(FormDataMeta.DESIGNER_DATA)));
			this.setData(DataParser.parse(String.class, map.get(FormDataMeta.DATA)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(FormDataMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, map.get(FormDataMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(FormDataMeta.VERSION)));
			this.setDefId(DataParser.parse(String.class, map.get(FormDataMeta.DEF_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(FormDataMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(FormDataMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(FormDataMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(FormDataMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(FormDataMeta.DELETE_TIME)));
			this.setFormStatus(DataParser.parse(String.class, map.get(FormDataMeta.FORM_STATUS)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(FormDataMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(FormDataMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setFormId( (String)map.get(FormDataMeta.FORM_ID));
				this.setDesignerData( (String)map.get(FormDataMeta.DESIGNER_DATA));
				this.setData( (String)map.get(FormDataMeta.DATA));
				this.setUpdateTime( (Date)map.get(FormDataMeta.UPDATE_TIME));
				this.setOwnerId( (String)map.get(FormDataMeta.OWNER_ID));
				this.setVersion( (Integer)map.get(FormDataMeta.VERSION));
				this.setDefId( (String)map.get(FormDataMeta.DEF_ID));
				this.setCreateBy( (String)map.get(FormDataMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(FormDataMeta.DELETED));
				this.setCreateTime( (Date)map.get(FormDataMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(FormDataMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(FormDataMeta.DELETE_TIME));
				this.setFormStatus( (String)map.get(FormDataMeta.FORM_STATUS));
				this.setDeleteBy( (String)map.get(FormDataMeta.DELETE_BY));
				this.setId( (String)map.get(FormDataMeta.ID));
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
			this.setFormId(DataParser.parse(String.class, r.getValue(FormDataMeta.FORM_ID)));
			this.setDesignerData(DataParser.parse(String.class, r.getValue(FormDataMeta.DESIGNER_DATA)));
			this.setData(DataParser.parse(String.class, r.getValue(FormDataMeta.DATA)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(FormDataMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(FormDataMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(FormDataMeta.VERSION)));
			this.setDefId(DataParser.parse(String.class, r.getValue(FormDataMeta.DEF_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(FormDataMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(FormDataMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(FormDataMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(FormDataMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(FormDataMeta.DELETE_TIME)));
			this.setFormStatus(DataParser.parse(String.class, r.getValue(FormDataMeta.FORM_STATUS)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(FormDataMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(FormDataMeta.ID)));
			return true;
		} else {
			try {
				this.setFormId( (String)r.getValue(FormDataMeta.FORM_ID));
				this.setDesignerData( (String)r.getValue(FormDataMeta.DESIGNER_DATA));
				this.setData( (String)r.getValue(FormDataMeta.DATA));
				this.setUpdateTime( (Date)r.getValue(FormDataMeta.UPDATE_TIME));
				this.setOwnerId( (String)r.getValue(FormDataMeta.OWNER_ID));
				this.setVersion( (Integer)r.getValue(FormDataMeta.VERSION));
				this.setDefId( (String)r.getValue(FormDataMeta.DEF_ID));
				this.setCreateBy( (String)r.getValue(FormDataMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(FormDataMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(FormDataMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(FormDataMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(FormDataMeta.DELETE_TIME));
				this.setFormStatus( (String)r.getValue(FormDataMeta.FORM_STATUS));
				this.setDeleteBy( (String)r.getValue(FormDataMeta.DELETE_BY));
				this.setId( (String)r.getValue(FormDataMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}