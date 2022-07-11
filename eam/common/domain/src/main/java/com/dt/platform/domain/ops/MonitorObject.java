package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_MONITOR_OBJECT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 监控对象
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-10 09:04:00
 * @sign 3D8604B49BC7A3E3F5BA0BD0E53C2E9C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_object")
public class MonitorObject extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_OBJECT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 模型：模型
	*/
	@ApiModelProperty(required = false,value="模型" , notes = "模型")
	private String objectModelId;
	
	/**
	 * 分组：分组
	*/
	@ApiModelProperty(required = false,value="分组" , notes = "分组")
	private String groupCode;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * IP：IP
	*/
	@ApiModelProperty(required = false,value="IP" , notes = "IP")
	private String ip;
	
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
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本")
	private Integer version;
	
	/**
	 * group：group
	*/
	@ApiModelProperty(required = false,value="group" , notes = "group")
	private MonitorObjectGroup group;
	
	/**
	 * objectModel：objectModel
	*/
	@ApiModelProperty(required = false,value="objectModel" , notes = "objectModel")
	private MonitorObjectModel objectModel;
	
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
	public MonitorObject setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 模型<br>
	 * 模型
	 * @return 模型
	*/
	public String getObjectModelId() {
		return objectModelId;
	}
	
	/**
	 * 设置 模型
	 * @param objectModelId 模型
	 * @return 当前对象
	*/
	public MonitorObject setObjectModelId(String objectModelId) {
		this.objectModelId=objectModelId;
		return this;
	}
	
	/**
	 * 获得 分组<br>
	 * 分组
	 * @return 分组
	*/
	public String getGroupCode() {
		return groupCode;
	}
	
	/**
	 * 设置 分组
	 * @param groupCode 分组
	 * @return 当前对象
	*/
	public MonitorObject setGroupCode(String groupCode) {
		this.groupCode=groupCode;
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
	public MonitorObject setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 IP<br>
	 * IP
	 * @return IP
	*/
	public String getIp() {
		return ip;
	}
	
	/**
	 * 设置 IP
	 * @param ip IP
	 * @return 当前对象
	*/
	public MonitorObject setIp(String ip) {
		this.ip=ip;
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
	public MonitorObject setCreateBy(String createBy) {
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
	public MonitorObject setCreateTime(Date createTime) {
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
	public MonitorObject setUpdateBy(String updateBy) {
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
	public MonitorObject setUpdateTime(Date updateTime) {
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
	public MonitorObject setDeleted(Integer deleted) {
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
	public MonitorObject setDeleted(Boolean deletedBool) {
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
	public MonitorObject setDeleteBy(String deleteBy) {
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
	public MonitorObject setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 版本
	 * @param version 版本
	 * @return 当前对象
	*/
	public MonitorObject setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 group<br>
	 * group
	 * @return group
	*/
	public MonitorObjectGroup getGroup() {
		return group;
	}
	
	/**
	 * 设置 group
	 * @param group group
	 * @return 当前对象
	*/
	public MonitorObject setGroup(MonitorObjectGroup group) {
		this.group=group;
		return this;
	}
	
	/**
	 * 获得 objectModel<br>
	 * objectModel
	 * @return objectModel
	*/
	public MonitorObjectModel getObjectModel() {
		return objectModel;
	}
	
	/**
	 * 设置 objectModel
	 * @param objectModel objectModel
	 * @return 当前对象
	*/
	public MonitorObject setObjectModel(MonitorObjectModel objectModel) {
		this.objectModel=objectModel;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorObject , 转换好的 MonitorObject 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorObject , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 MonitorObject
	 * @param monitorObjectMap 包含实体信息的 Map 对象
	 * @return MonitorObject , 转换好的的 MonitorObject 对象
	*/
	@Transient
	public static MonitorObject createFrom(Map<String,Object> monitorObjectMap) {
		if(monitorObjectMap==null) return null;
		MonitorObject po = EntityContext.create(MonitorObject.class, monitorObjectMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorObject
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorObject , 转换好的的 MonitorObject 对象
	*/
	@Transient
	public static MonitorObject createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorObject po = EntityContext.create(MonitorObject.class,pojo);
		return po;
	}

	/**
	 * 创建一个 MonitorObject，等同于 new
	 * @return MonitorObject 对象
	*/
	@Transient
	public static MonitorObject create() {
		return EntityContext.create(MonitorObject.class);
	}
}