package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_SCREEN_DS_API;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.ScreenDsApiMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * API
 * <p>API , 数据表 sys_screen_ds_api 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-29 11:17:36
 * @sign CE8D5CAEAF44D53154AE5DE4D6B8D6B7
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_screen_ds_api")
@ApiModel(description = "API ; API , 数据表 sys_screen_ds_api 的PO类型")
public class ScreenDsApi extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_SCREEN_DS_API.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "770562453690908672")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "api_test1")
	private String name;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码" , example = "api_test1")
	private String code;
	
	/**
	 * 地址：地址
	*/
	@ApiModelProperty(required = false,value="地址" , notes = "地址" , example = "测试")
	private String url;
	
	/**
	 * 请求方式：请求方式
	*/
	@ApiModelProperty(required = false,value="请求方式" , notes = "请求方式" , example = "post")
	private String reqType;
	
	/**
	 * 参数：参数
	*/
	@ApiModelProperty(required = false,value="参数" , notes = "参数")
	private String param;
	
	/**
	 * 请求头：请求头
	*/
	@ApiModelProperty(required = false,value="请求头" , notes = "请求头")
	private String header;
	
	/**
	 * 请求体：请求体
	*/
	@ApiModelProperty(required = false,value="请求体" , notes = "请求体")
	private String body;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-10-28 08:20:05")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-10-28 08:35:00")
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
	@ApiModelProperty(required = false,value="version" , notes = "version" , example = "2")
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
	public ScreenDsApi setId(String id) {
		this.id=id;
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
	public ScreenDsApi setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编码
	 * @param code 编码
	 * @return 当前对象
	*/
	public ScreenDsApi setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 地址<br>
	 * 地址
	 * @return 地址
	*/
	public String getUrl() {
		return url;
	}
	
	/**
	 * 设置 地址
	 * @param url 地址
	 * @return 当前对象
	*/
	public ScreenDsApi setUrl(String url) {
		this.url=url;
		return this;
	}
	
	/**
	 * 获得 请求方式<br>
	 * 请求方式
	 * @return 请求方式
	*/
	public String getReqType() {
		return reqType;
	}
	
	/**
	 * 设置 请求方式
	 * @param reqType 请求方式
	 * @return 当前对象
	*/
	public ScreenDsApi setReqType(String reqType) {
		this.reqType=reqType;
		return this;
	}
	
	/**
	 * 获得 参数<br>
	 * 参数
	 * @return 参数
	*/
	public String getParam() {
		return param;
	}
	
	/**
	 * 设置 参数
	 * @param param 参数
	 * @return 当前对象
	*/
	public ScreenDsApi setParam(String param) {
		this.param=param;
		return this;
	}
	
	/**
	 * 获得 请求头<br>
	 * 请求头
	 * @return 请求头
	*/
	public String getHeader() {
		return header;
	}
	
	/**
	 * 设置 请求头
	 * @param header 请求头
	 * @return 当前对象
	*/
	public ScreenDsApi setHeader(String header) {
		this.header=header;
		return this;
	}
	
	/**
	 * 获得 请求体<br>
	 * 请求体
	 * @return 请求体
	*/
	public String getBody() {
		return body;
	}
	
	/**
	 * 设置 请求体
	 * @param body 请求体
	 * @return 当前对象
	*/
	public ScreenDsApi setBody(String body) {
		this.body=body;
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
	public ScreenDsApi setNotes(String notes) {
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
	public ScreenDsApi setCreateBy(String createBy) {
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
	public ScreenDsApi setCreateTime(Date createTime) {
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
	public ScreenDsApi setUpdateBy(String updateBy) {
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
	public ScreenDsApi setUpdateTime(Date updateTime) {
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
	public ScreenDsApi setDeleted(Integer deleted) {
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
	public ScreenDsApi setDeleted(Boolean deletedBool) {
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
	public ScreenDsApi setDeleteBy(String deleteBy) {
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
	public ScreenDsApi setDeleteTime(Date deleteTime) {
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
	public ScreenDsApi setVersion(Integer version) {
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
	public ScreenDsApi setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ScreenDsApi , 转换好的 ScreenDsApi 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ScreenDsApi , 转换好的 PoJo 对象
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
	public ScreenDsApi clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ScreenDsApi duplicate(boolean all) {
		com.dt.platform.domain.common.meta.ScreenDsApiMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.ScreenDsApiMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setBody(this.getBody());
		inst.setVersion(this.getVersion());
		inst.setUrl(this.getUrl());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setParam(this.getParam());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setReqType(this.getReqType());
		inst.setTenantId(this.getTenantId());
		inst.setHeader(this.getHeader());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ScreenDsApi clone(boolean deep) {
		return EntityContext.clone(ScreenDsApi.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ScreenDsApi
	 * @param screenDsApiMap 包含实体信息的 Map 对象
	 * @return ScreenDsApi , 转换好的的 ScreenDsApi 对象
	*/
	@Transient
	public static ScreenDsApi createFrom(Map<String,Object> screenDsApiMap) {
		if(screenDsApiMap==null) return null;
		ScreenDsApi po = create();
		EntityContext.copyProperties(po,screenDsApiMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ScreenDsApi
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ScreenDsApi , 转换好的的 ScreenDsApi 对象
	*/
	@Transient
	public static ScreenDsApi createFrom(Object pojo) {
		if(pojo==null) return null;
		ScreenDsApi po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ScreenDsApi，等同于 new
	 * @return ScreenDsApi 对象
	*/
	@Transient
	public static ScreenDsApi create() {
		return new com.dt.platform.domain.common.meta.ScreenDsApiMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(ScreenDsApiMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(ScreenDsApiMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ScreenDsApiMeta.UPDATE_TIME)));
			this.setBody(DataParser.parse(String.class, map.get(ScreenDsApiMeta.BODY)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ScreenDsApiMeta.VERSION)));
			this.setUrl(DataParser.parse(String.class, map.get(ScreenDsApiMeta.URL)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ScreenDsApiMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ScreenDsApiMeta.DELETED)));
			this.setParam(DataParser.parse(String.class, map.get(ScreenDsApiMeta.PARAM)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ScreenDsApiMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ScreenDsApiMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ScreenDsApiMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(ScreenDsApiMeta.NAME)));
			this.setReqType(DataParser.parse(String.class, map.get(ScreenDsApiMeta.REQ_TYPE)));
			this.setTenantId(DataParser.parse(String.class, map.get(ScreenDsApiMeta.TENANT_ID)));
			this.setHeader(DataParser.parse(String.class, map.get(ScreenDsApiMeta.HEADER)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ScreenDsApiMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ScreenDsApiMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setCode( (String)map.get(ScreenDsApiMeta.CODE));
				this.setNotes( (String)map.get(ScreenDsApiMeta.NOTES));
				this.setUpdateTime( (Date)map.get(ScreenDsApiMeta.UPDATE_TIME));
				this.setBody( (String)map.get(ScreenDsApiMeta.BODY));
				this.setVersion( (Integer)map.get(ScreenDsApiMeta.VERSION));
				this.setUrl( (String)map.get(ScreenDsApiMeta.URL));
				this.setCreateBy( (String)map.get(ScreenDsApiMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ScreenDsApiMeta.DELETED));
				this.setParam( (String)map.get(ScreenDsApiMeta.PARAM));
				this.setCreateTime( (Date)map.get(ScreenDsApiMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ScreenDsApiMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ScreenDsApiMeta.DELETE_TIME));
				this.setName( (String)map.get(ScreenDsApiMeta.NAME));
				this.setReqType( (String)map.get(ScreenDsApiMeta.REQ_TYPE));
				this.setTenantId( (String)map.get(ScreenDsApiMeta.TENANT_ID));
				this.setHeader( (String)map.get(ScreenDsApiMeta.HEADER));
				this.setDeleteBy( (String)map.get(ScreenDsApiMeta.DELETE_BY));
				this.setId( (String)map.get(ScreenDsApiMeta.ID));
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
			this.setCode(DataParser.parse(String.class, r.getValue(ScreenDsApiMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(ScreenDsApiMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ScreenDsApiMeta.UPDATE_TIME)));
			this.setBody(DataParser.parse(String.class, r.getValue(ScreenDsApiMeta.BODY)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ScreenDsApiMeta.VERSION)));
			this.setUrl(DataParser.parse(String.class, r.getValue(ScreenDsApiMeta.URL)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ScreenDsApiMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ScreenDsApiMeta.DELETED)));
			this.setParam(DataParser.parse(String.class, r.getValue(ScreenDsApiMeta.PARAM)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ScreenDsApiMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ScreenDsApiMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ScreenDsApiMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(ScreenDsApiMeta.NAME)));
			this.setReqType(DataParser.parse(String.class, r.getValue(ScreenDsApiMeta.REQ_TYPE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ScreenDsApiMeta.TENANT_ID)));
			this.setHeader(DataParser.parse(String.class, r.getValue(ScreenDsApiMeta.HEADER)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ScreenDsApiMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ScreenDsApiMeta.ID)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(ScreenDsApiMeta.CODE));
				this.setNotes( (String)r.getValue(ScreenDsApiMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(ScreenDsApiMeta.UPDATE_TIME));
				this.setBody( (String)r.getValue(ScreenDsApiMeta.BODY));
				this.setVersion( (Integer)r.getValue(ScreenDsApiMeta.VERSION));
				this.setUrl( (String)r.getValue(ScreenDsApiMeta.URL));
				this.setCreateBy( (String)r.getValue(ScreenDsApiMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ScreenDsApiMeta.DELETED));
				this.setParam( (String)r.getValue(ScreenDsApiMeta.PARAM));
				this.setCreateTime( (Date)r.getValue(ScreenDsApiMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ScreenDsApiMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ScreenDsApiMeta.DELETE_TIME));
				this.setName( (String)r.getValue(ScreenDsApiMeta.NAME));
				this.setReqType( (String)r.getValue(ScreenDsApiMeta.REQ_TYPE));
				this.setTenantId( (String)r.getValue(ScreenDsApiMeta.TENANT_ID));
				this.setHeader( (String)r.getValue(ScreenDsApiMeta.HEADER));
				this.setDeleteBy( (String)r.getValue(ScreenDsApiMeta.DELETE_BY));
				this.setId( (String)r.getValue(ScreenDsApiMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}