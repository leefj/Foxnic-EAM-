package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_SCREEN;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.ScreenMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 大屏
 * <p>大屏 , 数据表 sys_screen 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-06 19:36:27
 * @sign 89E85E717DCA87E70822D815E2481AEC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_screen")
@ApiModel(description = "大屏 ; 大屏 , 数据表 sys_screen 的PO类型")
public class Screen extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_SCREEN.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "716023070585782272")
	private String id;
	
	/**
	 * 编号：编号
	*/
	@ApiModelProperty(required = false,value="编号" , notes = "编号" , example = "bigscreen")
	private String code;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "大屏")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 大屏定义：大屏定义
	*/
	@ApiModelProperty(required = false,value="大屏定义" , notes = "大屏定义")
	private String jsonData;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-05-30 08:20:03")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-05-31 06:57:31")
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
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间" , example = "2023-05-31 06:57:31")
	private Date deleteTime;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = false,value="version" , notes = "version" , example = "3")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
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
	public Screen setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编号<br>
	 * 编号
	 * @return 编号
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编号
	 * @param code 编号
	 * @return 当前对象
	*/
	public Screen setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public Screen setName(String name) {
		this.name=name;
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
	public Screen setStatus(String status) {
		this.status=status;
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
	public Screen setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 大屏定义<br>
	 * 大屏定义
	 * @return 大屏定义
	*/
	public String getJsonData() {
		return jsonData;
	}
	
	/**
	 * 设置 大屏定义
	 * @param jsonData 大屏定义
	 * @return 当前对象
	*/
	public Screen setJsonData(String jsonData) {
		this.jsonData=jsonData;
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
	public Screen setCreateBy(String createBy) {
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
	public Screen setCreateTime(Date createTime) {
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
	public Screen setUpdateBy(String updateBy) {
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
	public Screen setUpdateTime(Date updateTime) {
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
	public Screen setDeleted(Integer deleted) {
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
	public Screen setDeleted(Boolean deletedBool) {
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
	public Screen setDeleteBy(String deleteBy) {
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
	public Screen setDeleteTime(Date deleteTime) {
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
	public Screen setVersion(Integer version) {
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
	public Screen setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Screen , 转换好的 Screen 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Screen , 转换好的 PoJo 对象
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
	public Screen clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Screen duplicate(boolean all) {
		com.dt.platform.domain.common.meta.ScreenMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.ScreenMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setJsonData(this.getJsonData());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
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
	public Screen clone(boolean deep) {
		return EntityContext.clone(Screen.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Screen
	 * @param screenMap 包含实体信息的 Map 对象
	 * @return Screen , 转换好的的 Screen 对象
	*/
	@Transient
	public static Screen createFrom(Map<String,Object> screenMap) {
		if(screenMap==null) return null;
		Screen po = create();
		EntityContext.copyProperties(po,screenMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Screen
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Screen , 转换好的的 Screen 对象
	*/
	@Transient
	public static Screen createFrom(Object pojo) {
		if(pojo==null) return null;
		Screen po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Screen，等同于 new
	 * @return Screen 对象
	*/
	@Transient
	public static Screen create() {
		return new com.dt.platform.domain.common.meta.ScreenMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(ScreenMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(ScreenMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ScreenMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ScreenMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ScreenMeta.CREATE_BY)));
			this.setJsonData(DataParser.parse(String.class, map.get(ScreenMeta.JSON_DATA)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ScreenMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ScreenMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ScreenMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ScreenMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(ScreenMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ScreenMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ScreenMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ScreenMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(ScreenMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setCode( (String)map.get(ScreenMeta.CODE));
				this.setNotes( (String)map.get(ScreenMeta.NOTES));
				this.setUpdateTime( (Date)map.get(ScreenMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(ScreenMeta.VERSION));
				this.setCreateBy( (String)map.get(ScreenMeta.CREATE_BY));
				this.setJsonData( (String)map.get(ScreenMeta.JSON_DATA));
				this.setDeleted( (Integer)map.get(ScreenMeta.DELETED));
				this.setCreateTime( (Date)map.get(ScreenMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ScreenMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ScreenMeta.DELETE_TIME));
				this.setName( (String)map.get(ScreenMeta.NAME));
				this.setTenantId( (String)map.get(ScreenMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ScreenMeta.DELETE_BY));
				this.setId( (String)map.get(ScreenMeta.ID));
				this.setStatus( (String)map.get(ScreenMeta.STATUS));
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
			this.setCode(DataParser.parse(String.class, r.getValue(ScreenMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(ScreenMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ScreenMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ScreenMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ScreenMeta.CREATE_BY)));
			this.setJsonData(DataParser.parse(String.class, r.getValue(ScreenMeta.JSON_DATA)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ScreenMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ScreenMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ScreenMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ScreenMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(ScreenMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ScreenMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ScreenMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ScreenMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(ScreenMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(ScreenMeta.CODE));
				this.setNotes( (String)r.getValue(ScreenMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(ScreenMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(ScreenMeta.VERSION));
				this.setCreateBy( (String)r.getValue(ScreenMeta.CREATE_BY));
				this.setJsonData( (String)r.getValue(ScreenMeta.JSON_DATA));
				this.setDeleted( (Integer)r.getValue(ScreenMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ScreenMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ScreenMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ScreenMeta.DELETE_TIME));
				this.setName( (String)r.getValue(ScreenMeta.NAME));
				this.setTenantId( (String)r.getValue(ScreenMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ScreenMeta.DELETE_BY));
				this.setId( (String)r.getValue(ScreenMeta.ID));
				this.setStatus( (String)r.getValue(ScreenMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}