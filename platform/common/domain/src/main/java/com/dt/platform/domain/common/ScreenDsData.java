package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_SCREEN_DS_DATA;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.ScreenDsDataMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 数据源
 * <p>数据源 , 数据表 sys_screen_ds_data 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-28 08:24:17
 * @sign 442090C9207A5B3B74888904CF39AE44
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_screen_ds_data")
@ApiModel(description = "数据源 ; 数据源 , 数据表 sys_screen_ds_data 的PO类型")
public class ScreenDsData extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_SCREEN_DS_DATA.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "770563169868316672")
	private String id;
	
	/**
	 * 编号：编号
	*/
	@ApiModelProperty(required = false,value="编号" , notes = "编号" , example = "12")
	private String code;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "12")
	private String name;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "来源" , example = "db")
	private String sourceCode;
	
	/**
	 * 分类：分类
	*/
	@ApiModelProperty(required = false,value="分类" , notes = "分类" , example = "770554981517361152")
	private String categoryId;
	
	/**
	 * 数据库：数据库
	*/
	@ApiModelProperty(required = false,value="数据库" , notes = "数据库" , example = "770562406039420928")
	private String dsCode;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容" , example = "a d f")
	private String ctText;
	
	/**
	 * 转换脚本：转换脚本
	*/
	@ApiModelProperty(required = false,value="转换脚本" , notes = "转换脚本" , example = "艾弗森")
	private String resultAction;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-10-28 08:22:56")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * screenDsCategory：screenDsCategory
	*/
	@ApiModelProperty(required = false,value="screenDsCategory" , notes = "screenDsCategory")
	private ScreenDsCategory screenDsCategory;
	
	/**
	 * screenDsDb：screenDsDb
	*/
	@ApiModelProperty(required = false,value="screenDsDb" , notes = "screenDsDb")
	private ScreenDsDb screenDsDb;
	
	/**
	 * screenDsApi：screenDsApi
	*/
	@ApiModelProperty(required = false,value="screenDsApi" , notes = "screenDsApi")
	private List<ScreenDsApi> screenDsApi;
	
	/**
	 * screenDsApiIds：screenDsApiIds
	*/
	@ApiModelProperty(required = false,value="screenDsApiIds" , notes = "screenDsApiIds")
	private List<String> screenDsApiIds;
	
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
	public ScreenDsData setId(String id) {
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
	public ScreenDsData setCode(String code) {
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
	public ScreenDsData setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 来源<br>
	 * 来源
	 * @return 来源
	*/
	public String getSourceCode() {
		return sourceCode;
	}
	
	/**
	 * 设置 来源
	 * @param sourceCode 来源
	 * @return 当前对象
	*/
	public ScreenDsData setSourceCode(String sourceCode) {
		this.sourceCode=sourceCode;
		return this;
	}
	
	/**
	 * 获得 分类<br>
	 * 分类
	 * @return 分类
	*/
	public String getCategoryId() {
		return categoryId;
	}
	
	/**
	 * 设置 分类
	 * @param categoryId 分类
	 * @return 当前对象
	*/
	public ScreenDsData setCategoryId(String categoryId) {
		this.categoryId=categoryId;
		return this;
	}
	
	/**
	 * 获得 数据库<br>
	 * 数据库
	 * @return 数据库
	*/
	public String getDsCode() {
		return dsCode;
	}
	
	/**
	 * 设置 数据库
	 * @param dsCode 数据库
	 * @return 当前对象
	*/
	public ScreenDsData setDsCode(String dsCode) {
		this.dsCode=dsCode;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getCtText() {
		return ctText;
	}
	
	/**
	 * 设置 内容
	 * @param ctText 内容
	 * @return 当前对象
	*/
	public ScreenDsData setCtText(String ctText) {
		this.ctText=ctText;
		return this;
	}
	
	/**
	 * 获得 转换脚本<br>
	 * 转换脚本
	 * @return 转换脚本
	*/
	public String getResultAction() {
		return resultAction;
	}
	
	/**
	 * 设置 转换脚本
	 * @param resultAction 转换脚本
	 * @return 当前对象
	*/
	public ScreenDsData setResultAction(String resultAction) {
		this.resultAction=resultAction;
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
	public ScreenDsData setNotes(String notes) {
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
	public ScreenDsData setCreateBy(String createBy) {
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
	public ScreenDsData setCreateTime(Date createTime) {
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
	public ScreenDsData setUpdateBy(String updateBy) {
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
	public ScreenDsData setUpdateTime(Date updateTime) {
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
	public ScreenDsData setDeleted(Integer deleted) {
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
	public ScreenDsData setDeleted(Boolean deletedBool) {
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
	public ScreenDsData setDeleteBy(String deleteBy) {
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
	public ScreenDsData setDeleteTime(Date deleteTime) {
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
	public ScreenDsData setVersion(Integer version) {
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
	public ScreenDsData setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 screenDsCategory<br>
	 * screenDsCategory
	 * @return screenDsCategory
	*/
	public ScreenDsCategory getScreenDsCategory() {
		return screenDsCategory;
	}
	
	/**
	 * 设置 screenDsCategory
	 * @param screenDsCategory screenDsCategory
	 * @return 当前对象
	*/
	public ScreenDsData setScreenDsCategory(ScreenDsCategory screenDsCategory) {
		this.screenDsCategory=screenDsCategory;
		return this;
	}
	
	/**
	 * 获得 screenDsDb<br>
	 * screenDsDb
	 * @return screenDsDb
	*/
	public ScreenDsDb getScreenDsDb() {
		return screenDsDb;
	}
	
	/**
	 * 设置 screenDsDb
	 * @param screenDsDb screenDsDb
	 * @return 当前对象
	*/
	public ScreenDsData setScreenDsDb(ScreenDsDb screenDsDb) {
		this.screenDsDb=screenDsDb;
		return this;
	}
	
	/**
	 * 获得 screenDsApi<br>
	 * screenDsApi
	 * @return screenDsApi
	*/
	public List<ScreenDsApi> getScreenDsApi() {
		return screenDsApi;
	}
	
	/**
	 * 设置 screenDsApi
	 * @param screenDsApi screenDsApi
	 * @return 当前对象
	*/
	public ScreenDsData setScreenDsApi(List<ScreenDsApi> screenDsApi) {
		this.screenDsApi=screenDsApi;
		return this;
	}
	
	/**
	 * 添加 screenDsApi
	 * @param entity screenDsApi
	 * @return 当前对象
	*/
	public ScreenDsData addScreenDsApi(ScreenDsApi... entity) {
		if(this.screenDsApi==null) screenDsApi=new ArrayList<>();
		this.screenDsApi.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 screenDsApiIds<br>
	 * screenDsApiIds
	 * @return screenDsApiIds
	*/
	public List<String> getScreenDsApiIds() {
		return screenDsApiIds;
	}
	
	/**
	 * 设置 screenDsApiIds
	 * @param screenDsApiIds screenDsApiIds
	 * @return 当前对象
	*/
	public ScreenDsData setScreenDsApiIds(List<String> screenDsApiIds) {
		this.screenDsApiIds=screenDsApiIds;
		return this;
	}
	
	/**
	 * 添加 screenDsApiIds
	 * @param screenDsApiId screenDsApiIds
	 * @return 当前对象
	*/
	public ScreenDsData addScreenDsApiId(String... screenDsApiId) {
		if(this.screenDsApiIds==null) screenDsApiIds=new ArrayList<>();
		this.screenDsApiIds.addAll(Arrays.asList(screenDsApiId));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ScreenDsData , 转换好的 ScreenDsData 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ScreenDsData , 转换好的 PoJo 对象
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
	public ScreenDsData clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ScreenDsData duplicate(boolean all) {
		com.dt.platform.domain.common.meta.ScreenDsDataMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.ScreenDsDataMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setCtText(this.getCtText());
		inst.setDsCode(this.getDsCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setSourceCode(this.getSourceCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setResultAction(this.getResultAction());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setCategoryId(this.getCategoryId());
		if(all) {
			inst.setScreenDsDb(this.getScreenDsDb());
			inst.setScreenDsCategory(this.getScreenDsCategory());
			inst.setScreenDsApi(this.getScreenDsApi());
			inst.setScreenDsApiIds(this.getScreenDsApiIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ScreenDsData clone(boolean deep) {
		return EntityContext.clone(ScreenDsData.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ScreenDsData
	 * @param screenDsDataMap 包含实体信息的 Map 对象
	 * @return ScreenDsData , 转换好的的 ScreenDsData 对象
	*/
	@Transient
	public static ScreenDsData createFrom(Map<String,Object> screenDsDataMap) {
		if(screenDsDataMap==null) return null;
		ScreenDsData po = create();
		EntityContext.copyProperties(po,screenDsDataMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ScreenDsData
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ScreenDsData , 转换好的的 ScreenDsData 对象
	*/
	@Transient
	public static ScreenDsData createFrom(Object pojo) {
		if(pojo==null) return null;
		ScreenDsData po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ScreenDsData，等同于 new
	 * @return ScreenDsData 对象
	*/
	@Transient
	public static ScreenDsData create() {
		return new com.dt.platform.domain.common.meta.ScreenDsDataMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(ScreenDsDataMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(ScreenDsDataMeta.NOTES)));
			this.setCtText(DataParser.parse(String.class, map.get(ScreenDsDataMeta.CT_TEXT)));
			this.setDsCode(DataParser.parse(String.class, map.get(ScreenDsDataMeta.DS_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ScreenDsDataMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ScreenDsDataMeta.VERSION)));
			this.setSourceCode(DataParser.parse(String.class, map.get(ScreenDsDataMeta.SOURCE_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ScreenDsDataMeta.CREATE_BY)));
			this.setResultAction(DataParser.parse(String.class, map.get(ScreenDsDataMeta.RESULT_ACTION)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ScreenDsDataMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ScreenDsDataMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ScreenDsDataMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ScreenDsDataMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(ScreenDsDataMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ScreenDsDataMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ScreenDsDataMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ScreenDsDataMeta.ID)));
			this.setCategoryId(DataParser.parse(String.class, map.get(ScreenDsDataMeta.CATEGORY_ID)));
			// others
			this.setScreenDsDb(DataParser.parse(ScreenDsDb.class, map.get(ScreenDsDataMeta.SCREEN_DS_DB)));
			this.setScreenDsCategory(DataParser.parse(ScreenDsCategory.class, map.get(ScreenDsDataMeta.SCREEN_DS_CATEGORY)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(ScreenDsDataMeta.CODE));
				this.setNotes( (String)map.get(ScreenDsDataMeta.NOTES));
				this.setCtText( (String)map.get(ScreenDsDataMeta.CT_TEXT));
				this.setDsCode( (String)map.get(ScreenDsDataMeta.DS_CODE));
				this.setUpdateTime( (Date)map.get(ScreenDsDataMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(ScreenDsDataMeta.VERSION));
				this.setSourceCode( (String)map.get(ScreenDsDataMeta.SOURCE_CODE));
				this.setCreateBy( (String)map.get(ScreenDsDataMeta.CREATE_BY));
				this.setResultAction( (String)map.get(ScreenDsDataMeta.RESULT_ACTION));
				this.setDeleted( (Integer)map.get(ScreenDsDataMeta.DELETED));
				this.setCreateTime( (Date)map.get(ScreenDsDataMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ScreenDsDataMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ScreenDsDataMeta.DELETE_TIME));
				this.setName( (String)map.get(ScreenDsDataMeta.NAME));
				this.setTenantId( (String)map.get(ScreenDsDataMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ScreenDsDataMeta.DELETE_BY));
				this.setId( (String)map.get(ScreenDsDataMeta.ID));
				this.setCategoryId( (String)map.get(ScreenDsDataMeta.CATEGORY_ID));
				// others
				this.setScreenDsDb( (ScreenDsDb)map.get(ScreenDsDataMeta.SCREEN_DS_DB));
				this.setScreenDsCategory( (ScreenDsCategory)map.get(ScreenDsDataMeta.SCREEN_DS_CATEGORY));
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
			this.setCode(DataParser.parse(String.class, r.getValue(ScreenDsDataMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(ScreenDsDataMeta.NOTES)));
			this.setCtText(DataParser.parse(String.class, r.getValue(ScreenDsDataMeta.CT_TEXT)));
			this.setDsCode(DataParser.parse(String.class, r.getValue(ScreenDsDataMeta.DS_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ScreenDsDataMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ScreenDsDataMeta.VERSION)));
			this.setSourceCode(DataParser.parse(String.class, r.getValue(ScreenDsDataMeta.SOURCE_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ScreenDsDataMeta.CREATE_BY)));
			this.setResultAction(DataParser.parse(String.class, r.getValue(ScreenDsDataMeta.RESULT_ACTION)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ScreenDsDataMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ScreenDsDataMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ScreenDsDataMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ScreenDsDataMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(ScreenDsDataMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ScreenDsDataMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ScreenDsDataMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ScreenDsDataMeta.ID)));
			this.setCategoryId(DataParser.parse(String.class, r.getValue(ScreenDsDataMeta.CATEGORY_ID)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(ScreenDsDataMeta.CODE));
				this.setNotes( (String)r.getValue(ScreenDsDataMeta.NOTES));
				this.setCtText( (String)r.getValue(ScreenDsDataMeta.CT_TEXT));
				this.setDsCode( (String)r.getValue(ScreenDsDataMeta.DS_CODE));
				this.setUpdateTime( (Date)r.getValue(ScreenDsDataMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(ScreenDsDataMeta.VERSION));
				this.setSourceCode( (String)r.getValue(ScreenDsDataMeta.SOURCE_CODE));
				this.setCreateBy( (String)r.getValue(ScreenDsDataMeta.CREATE_BY));
				this.setResultAction( (String)r.getValue(ScreenDsDataMeta.RESULT_ACTION));
				this.setDeleted( (Integer)r.getValue(ScreenDsDataMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ScreenDsDataMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ScreenDsDataMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ScreenDsDataMeta.DELETE_TIME));
				this.setName( (String)r.getValue(ScreenDsDataMeta.NAME));
				this.setTenantId( (String)r.getValue(ScreenDsDataMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ScreenDsDataMeta.DELETE_BY));
				this.setId( (String)r.getValue(ScreenDsDataMeta.ID));
				this.setCategoryId( (String)r.getValue(ScreenDsDataMeta.CATEGORY_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}