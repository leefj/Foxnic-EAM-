package com.dt.platform.domain.mobile;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.MobileTables.APP_MODULE_GROUP;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.List;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 移动端模块分组
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-20 14:10:59
 * @sign 4BB9F0E5121149B8EDB7D64258E02477
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "app_module_group")
public class ModuleGroup extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =APP_MODULE_GROUP.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = true,value="类型" , notes = "类型")
	private String type;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签")
	private String label;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序")
	private Integer sort;
	
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
	 * ModuleInfo：ModuleInfo
	*/
	@ApiModelProperty(required = false,value="ModuleInfo" , notes = "ModuleInfo")
	private List<ModuleInfo> moduleInfoList;
	
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
	public ModuleGroup setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public ModuleGroup setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 标签<br>
	 * 标签
	 * @return 标签
	*/
	public String getLabel() {
		return label;
	}
	
	/**
	 * 设置 标签
	 * @param label 标签
	 * @return 当前对象
	*/
	public ModuleGroup setLabel(String label) {
		this.label=label;
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
	public ModuleGroup setStatus(String status) {
		this.status=status;
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
	public ModuleGroup setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 排序<br>
	 * 排序
	 * @return 排序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 排序
	 * @param sort 排序
	 * @return 当前对象
	*/
	public ModuleGroup setSort(Integer sort) {
		this.sort=sort;
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
	public ModuleGroup setCreateBy(String createBy) {
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
	public ModuleGroup setCreateTime(Date createTime) {
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
	public ModuleGroup setUpdateBy(String updateBy) {
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
	public ModuleGroup setUpdateTime(Date updateTime) {
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
	public ModuleGroup setDeleted(Integer deleted) {
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
	public ModuleGroup setDeleted(Boolean deletedBool) {
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
	public ModuleGroup setDeleteBy(String deleteBy) {
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
	public ModuleGroup setDeleteTime(Date deleteTime) {
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
	public ModuleGroup setVersion(Integer version) {
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
	public ModuleGroup setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 ModuleInfo<br>
	 * ModuleInfo
	 * @return ModuleInfo
	*/
	public List<ModuleInfo> getModuleInfoList() {
		return moduleInfoList;
	}
	
	/**
	 * 设置 ModuleInfo
	 * @param moduleInfoList ModuleInfo
	 * @return 当前对象
	*/
	public ModuleGroup setModuleInfoList(List<ModuleInfo> moduleInfoList) {
		this.moduleInfoList=moduleInfoList;
		return this;
	}
	
	/**
	 * 添加 ModuleInfo
	 * @param moduleInfo ModuleInfo
	 * @return 当前对象
	*/
	public ModuleGroup addModuleInfo(ModuleInfo... moduleInfo) {
		if(this.moduleInfoList==null) moduleInfoList=new ArrayList<>();
		this.moduleInfoList.addAll(Arrays.asList(moduleInfo));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ModuleGroup , 转换好的 ModuleGroup 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ModuleGroup , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 ModuleGroup
	 * @param moduleGroupMap 包含实体信息的 Map 对象
	 * @return ModuleGroup , 转换好的的 ModuleGroup 对象
	*/
	@Transient
	public static ModuleGroup createFrom(Map<String,Object> moduleGroupMap) {
		if(moduleGroupMap==null) return null;
		ModuleGroup po = EntityContext.create(ModuleGroup.class, moduleGroupMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 ModuleGroup
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ModuleGroup , 转换好的的 ModuleGroup 对象
	*/
	@Transient
	public static ModuleGroup createFrom(Object pojo) {
		if(pojo==null) return null;
		ModuleGroup po = EntityContext.create(ModuleGroup.class,pojo);
		return po;
	}

	/**
	 * 创建一个 ModuleGroup，等同于 new
	 * @return ModuleGroup 对象
	*/
	@Transient
	public static ModuleGroup create() {
		return EntityContext.create(ModuleGroup.class);
	}
}