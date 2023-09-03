package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_AUTO_ACTION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.AutoActionMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 执行任务
 * <p>执行任务 , 数据表 ops_auto_action 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-01 18:56:10
 * @sign DF160C96F8ED551F82DA1137068B63F5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_auto_action")
@ApiModel(description = "执行任务 ; 执行任务 , 数据表 ops_auto_action 的PO类型")
public class AutoAction extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_AUTO_ACTION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "613756265390145536")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "测试1")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型" , example = "host")
	private String type;
	
	/**
	 * 模版版本：模版版本
	*/
	@ApiModelProperty(required = false,value="模版版本" , notes = "模版版本")
	private String tplVersion;
	
	/**
	 * 场景：场景
	*/
	@ApiModelProperty(required = false,value="场景" , notes = "场景")
	private String support;
	
	/**
	 * 说明：说明
	*/
	@ApiModelProperty(required = false,value="说明" , notes = "说明")
	private String info;
	
	/**
	 * 介质状态：介质状态
	*/
	@ApiModelProperty(required = false,value="介质状态" , notes = "介质状态")
	private String fileStatus;
	
	/**
	 * 节点数量：节点数量
	*/
	@ApiModelProperty(required = false,value="节点数量" , notes = "节点数量")
	private String nodeNumberType;
	
	/**
	 * 配置内容：配置内容
	*/
	@ApiModelProperty(required = false,value="配置内容" , notes = "配置内容" , example = "12")
	private String confContent;
	
	/**
	 * 配置例子：配置例子
	*/
	@ApiModelProperty(required = false,value="配置例子" , notes = "配置例子")
	private String exampleConfContent;
	
	/**
	 * 执行内容：执行内容
	*/
	@ApiModelProperty(required = false,value="执行内容" , notes = "执行内容" , example = "12")
	private String executeContent;
	
	/**
	 * 执行工具：执行工具
	*/
	@ApiModelProperty(required = false,value="执行工具" , notes = "执行工具" , example = "ops_tool")
	private String executeTool;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "12")
	private String notes;
	
	/**
	 * 创建人：创建人
	*/
	@ApiModelProperty(required = false,value="创建人" , notes = "创建人")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-08-21 03:40:47")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "2")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * autoActionScriptList：autoActionScriptList
	*/
	@ApiModelProperty(required = false,value="autoActionScriptList" , notes = "autoActionScriptList")
	private List<AutoActionScript> autoActionScriptList;
	
	/**
	 * autoActionScriptIds：autoActionScriptIds
	*/
	@ApiModelProperty(required = false,value="autoActionScriptIds" , notes = "autoActionScriptIds")
	private List<String> autoActionScriptIds;
	
	/**
	 * autoActionFileList：autoActionFileList
	*/
	@ApiModelProperty(required = false,value="autoActionFileList" , notes = "autoActionFileList")
	private List<AutoActionFile> autoActionFileList;
	
	/**
	 * autoActionFileIds：autoActionFileIds
	*/
	@ApiModelProperty(required = false,value="autoActionFileIds" , notes = "autoActionFileIds")
	private List<String> autoActionFileIds;
	
	/**
	 * typeDict：typeDict
	*/
	@ApiModelProperty(required = false,value="typeDict" , notes = "typeDict")
	private DictItem typeDict;
	
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
	public AutoAction setId(String id) {
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
	public AutoAction setName(String name) {
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
	public AutoAction setStatus(String status) {
		this.status=status;
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
	public AutoAction setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 模版版本<br>
	 * 模版版本
	 * @return 模版版本
	*/
	public String getTplVersion() {
		return tplVersion;
	}
	
	/**
	 * 设置 模版版本
	 * @param tplVersion 模版版本
	 * @return 当前对象
	*/
	public AutoAction setTplVersion(String tplVersion) {
		this.tplVersion=tplVersion;
		return this;
	}
	
	/**
	 * 获得 场景<br>
	 * 场景
	 * @return 场景
	*/
	public String getSupport() {
		return support;
	}
	
	/**
	 * 设置 场景
	 * @param support 场景
	 * @return 当前对象
	*/
	public AutoAction setSupport(String support) {
		this.support=support;
		return this;
	}
	
	/**
	 * 获得 说明<br>
	 * 说明
	 * @return 说明
	*/
	public String getInfo() {
		return info;
	}
	
	/**
	 * 设置 说明
	 * @param info 说明
	 * @return 当前对象
	*/
	public AutoAction setInfo(String info) {
		this.info=info;
		return this;
	}
	
	/**
	 * 获得 介质状态<br>
	 * 介质状态
	 * @return 介质状态
	*/
	public String getFileStatus() {
		return fileStatus;
	}
	
	/**
	 * 设置 介质状态
	 * @param fileStatus 介质状态
	 * @return 当前对象
	*/
	public AutoAction setFileStatus(String fileStatus) {
		this.fileStatus=fileStatus;
		return this;
	}
	
	/**
	 * 获得 节点数量<br>
	 * 节点数量
	 * @return 节点数量
	*/
	public String getNodeNumberType() {
		return nodeNumberType;
	}
	
	/**
	 * 设置 节点数量
	 * @param nodeNumberType 节点数量
	 * @return 当前对象
	*/
	public AutoAction setNodeNumberType(String nodeNumberType) {
		this.nodeNumberType=nodeNumberType;
		return this;
	}
	
	/**
	 * 获得 配置内容<br>
	 * 配置内容
	 * @return 配置内容
	*/
	public String getConfContent() {
		return confContent;
	}
	
	/**
	 * 设置 配置内容
	 * @param confContent 配置内容
	 * @return 当前对象
	*/
	public AutoAction setConfContent(String confContent) {
		this.confContent=confContent;
		return this;
	}
	
	/**
	 * 获得 配置例子<br>
	 * 配置例子
	 * @return 配置例子
	*/
	public String getExampleConfContent() {
		return exampleConfContent;
	}
	
	/**
	 * 设置 配置例子
	 * @param exampleConfContent 配置例子
	 * @return 当前对象
	*/
	public AutoAction setExampleConfContent(String exampleConfContent) {
		this.exampleConfContent=exampleConfContent;
		return this;
	}
	
	/**
	 * 获得 执行内容<br>
	 * 执行内容
	 * @return 执行内容
	*/
	public String getExecuteContent() {
		return executeContent;
	}
	
	/**
	 * 设置 执行内容
	 * @param executeContent 执行内容
	 * @return 当前对象
	*/
	public AutoAction setExecuteContent(String executeContent) {
		this.executeContent=executeContent;
		return this;
	}
	
	/**
	 * 获得 执行工具<br>
	 * 执行工具
	 * @return 执行工具
	*/
	public String getExecuteTool() {
		return executeTool;
	}
	
	/**
	 * 设置 执行工具
	 * @param executeTool 执行工具
	 * @return 当前对象
	*/
	public AutoAction setExecuteTool(String executeTool) {
		this.executeTool=executeTool;
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
	public AutoAction setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 创建人<br>
	 * 创建人
	 * @return 创建人
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人
	 * @param createBy 创建人
	 * @return 当前对象
	*/
	public AutoAction setCreateBy(String createBy) {
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
	public AutoAction setCreateTime(Date createTime) {
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
	public AutoAction setUpdateBy(String updateBy) {
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
	public AutoAction setUpdateTime(Date updateTime) {
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
	public AutoAction setDeleted(Integer deleted) {
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
	public AutoAction setDeleted(Boolean deletedBool) {
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
	public AutoAction setDeleteBy(String deleteBy) {
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
	public AutoAction setDeleteTime(Date deleteTime) {
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
	public AutoAction setVersion(Integer version) {
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
	public AutoAction setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 autoActionScriptList<br>
	 * autoActionScriptList
	 * @return autoActionScriptList
	*/
	public List<AutoActionScript> getAutoActionScriptList() {
		return autoActionScriptList;
	}
	
	/**
	 * 设置 autoActionScriptList
	 * @param autoActionScriptList autoActionScriptList
	 * @return 当前对象
	*/
	public AutoAction setAutoActionScriptList(List<AutoActionScript> autoActionScriptList) {
		this.autoActionScriptList=autoActionScriptList;
		return this;
	}
	
	/**
	 * 添加 autoActionScriptList
	 * @param autoActionScript autoActionScriptList
	 * @return 当前对象
	*/
	public AutoAction addAutoActionScript(AutoActionScript... autoActionScript) {
		if(this.autoActionScriptList==null) autoActionScriptList=new ArrayList<>();
		this.autoActionScriptList.addAll(Arrays.asList(autoActionScript));
		return this;
	}
	
	/**
	 * 获得 autoActionScriptIds<br>
	 * autoActionScriptIds
	 * @return autoActionScriptIds
	*/
	public List<String> getAutoActionScriptIds() {
		return autoActionScriptIds;
	}
	
	/**
	 * 设置 autoActionScriptIds
	 * @param autoActionScriptIds autoActionScriptIds
	 * @return 当前对象
	*/
	public AutoAction setAutoActionScriptIds(List<String> autoActionScriptIds) {
		this.autoActionScriptIds=autoActionScriptIds;
		return this;
	}
	
	/**
	 * 添加 autoActionScriptIds
	 * @param autoActionScriptId autoActionScriptIds
	 * @return 当前对象
	*/
	public AutoAction addAutoActionScriptId(String... autoActionScriptId) {
		if(this.autoActionScriptIds==null) autoActionScriptIds=new ArrayList<>();
		this.autoActionScriptIds.addAll(Arrays.asList(autoActionScriptId));
		return this;
	}
	
	/**
	 * 获得 autoActionFileList<br>
	 * autoActionFileList
	 * @return autoActionFileList
	*/
	public List<AutoActionFile> getAutoActionFileList() {
		return autoActionFileList;
	}
	
	/**
	 * 设置 autoActionFileList
	 * @param autoActionFileList autoActionFileList
	 * @return 当前对象
	*/
	public AutoAction setAutoActionFileList(List<AutoActionFile> autoActionFileList) {
		this.autoActionFileList=autoActionFileList;
		return this;
	}
	
	/**
	 * 添加 autoActionFileList
	 * @param autoActionFile autoActionFileList
	 * @return 当前对象
	*/
	public AutoAction addAutoActionFile(AutoActionFile... autoActionFile) {
		if(this.autoActionFileList==null) autoActionFileList=new ArrayList<>();
		this.autoActionFileList.addAll(Arrays.asList(autoActionFile));
		return this;
	}
	
	/**
	 * 获得 autoActionFileIds<br>
	 * autoActionFileIds
	 * @return autoActionFileIds
	*/
	public List<String> getAutoActionFileIds() {
		return autoActionFileIds;
	}
	
	/**
	 * 设置 autoActionFileIds
	 * @param autoActionFileIds autoActionFileIds
	 * @return 当前对象
	*/
	public AutoAction setAutoActionFileIds(List<String> autoActionFileIds) {
		this.autoActionFileIds=autoActionFileIds;
		return this;
	}
	
	/**
	 * 添加 autoActionFileIds
	 * @param autoActionFileId autoActionFileIds
	 * @return 当前对象
	*/
	public AutoAction addAutoActionFileId(String... autoActionFileId) {
		if(this.autoActionFileIds==null) autoActionFileIds=new ArrayList<>();
		this.autoActionFileIds.addAll(Arrays.asList(autoActionFileId));
		return this;
	}
	
	/**
	 * 获得 typeDict<br>
	 * typeDict
	 * @return typeDict
	*/
	public DictItem getTypeDict() {
		return typeDict;
	}
	
	/**
	 * 设置 typeDict
	 * @param typeDict typeDict
	 * @return 当前对象
	*/
	public AutoAction setTypeDict(DictItem typeDict) {
		this.typeDict=typeDict;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AutoAction , 转换好的 AutoAction 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AutoAction , 转换好的 PoJo 对象
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
	public AutoAction clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AutoAction duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.AutoActionMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.AutoActionMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setNodeNumberType(this.getNodeNumberType());
		inst.setExecuteContent(this.getExecuteContent());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setType(this.getType());
		inst.setTplVersion(this.getTplVersion());
		inst.setConfContent(this.getConfContent());
		inst.setExampleConfContent(this.getExampleConfContent());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setExecuteTool(this.getExecuteTool());
		inst.setDeleted(this.getDeleted());
		inst.setFileStatus(this.getFileStatus());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setSupport(this.getSupport());
		inst.setStatus(this.getStatus());
		inst.setInfo(this.getInfo());
		if(all) {
			inst.setAutoActionScriptList(this.getAutoActionScriptList());
			inst.setAutoActionScriptIds(this.getAutoActionScriptIds());
			inst.setAutoActionFileIds(this.getAutoActionFileIds());
			inst.setAutoActionFileList(this.getAutoActionFileList());
			inst.setTypeDict(this.getTypeDict());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AutoAction clone(boolean deep) {
		return EntityContext.clone(AutoAction.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AutoAction
	 * @param autoActionMap 包含实体信息的 Map 对象
	 * @return AutoAction , 转换好的的 AutoAction 对象
	*/
	@Transient
	public static AutoAction createFrom(Map<String,Object> autoActionMap) {
		if(autoActionMap==null) return null;
		AutoAction po = create();
		EntityContext.copyProperties(po,autoActionMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AutoAction
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AutoAction , 转换好的的 AutoAction 对象
	*/
	@Transient
	public static AutoAction createFrom(Object pojo) {
		if(pojo==null) return null;
		AutoAction po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AutoAction，等同于 new
	 * @return AutoAction 对象
	*/
	@Transient
	public static AutoAction create() {
		return new com.dt.platform.domain.ops.meta.AutoActionMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AutoActionMeta.NOTES)));
			this.setNodeNumberType(DataParser.parse(String.class, map.get(AutoActionMeta.NODE_NUMBER_TYPE)));
			this.setExecuteContent(DataParser.parse(String.class, map.get(AutoActionMeta.EXECUTE_CONTENT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AutoActionMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(AutoActionMeta.TYPE)));
			this.setTplVersion(DataParser.parse(String.class, map.get(AutoActionMeta.TPL_VERSION)));
			this.setConfContent(DataParser.parse(String.class, map.get(AutoActionMeta.CONF_CONTENT)));
			this.setExampleConfContent(DataParser.parse(String.class, map.get(AutoActionMeta.EXAMPLE_CONF_CONTENT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AutoActionMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AutoActionMeta.CREATE_BY)));
			this.setExecuteTool(DataParser.parse(String.class, map.get(AutoActionMeta.EXECUTE_TOOL)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AutoActionMeta.DELETED)));
			this.setFileStatus(DataParser.parse(String.class, map.get(AutoActionMeta.FILE_STATUS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AutoActionMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AutoActionMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AutoActionMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AutoActionMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AutoActionMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AutoActionMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AutoActionMeta.ID)));
			this.setSupport(DataParser.parse(String.class, map.get(AutoActionMeta.SUPPORT)));
			this.setStatus(DataParser.parse(String.class, map.get(AutoActionMeta.STATUS)));
			this.setInfo(DataParser.parse(String.class, map.get(AutoActionMeta.INFO)));
			// others
			this.setTypeDict(DataParser.parse(DictItem.class, map.get(AutoActionMeta.TYPE_DICT)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AutoActionMeta.NOTES));
				this.setNodeNumberType( (String)map.get(AutoActionMeta.NODE_NUMBER_TYPE));
				this.setExecuteContent( (String)map.get(AutoActionMeta.EXECUTE_CONTENT));
				this.setUpdateTime( (Date)map.get(AutoActionMeta.UPDATE_TIME));
				this.setType( (String)map.get(AutoActionMeta.TYPE));
				this.setTplVersion( (String)map.get(AutoActionMeta.TPL_VERSION));
				this.setConfContent( (String)map.get(AutoActionMeta.CONF_CONTENT));
				this.setExampleConfContent( (String)map.get(AutoActionMeta.EXAMPLE_CONF_CONTENT));
				this.setVersion( (Integer)map.get(AutoActionMeta.VERSION));
				this.setCreateBy( (String)map.get(AutoActionMeta.CREATE_BY));
				this.setExecuteTool( (String)map.get(AutoActionMeta.EXECUTE_TOOL));
				this.setDeleted( (Integer)map.get(AutoActionMeta.DELETED));
				this.setFileStatus( (String)map.get(AutoActionMeta.FILE_STATUS));
				this.setCreateTime( (Date)map.get(AutoActionMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AutoActionMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AutoActionMeta.DELETE_TIME));
				this.setName( (String)map.get(AutoActionMeta.NAME));
				this.setTenantId( (String)map.get(AutoActionMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AutoActionMeta.DELETE_BY));
				this.setId( (String)map.get(AutoActionMeta.ID));
				this.setSupport( (String)map.get(AutoActionMeta.SUPPORT));
				this.setStatus( (String)map.get(AutoActionMeta.STATUS));
				this.setInfo( (String)map.get(AutoActionMeta.INFO));
				// others
				this.setTypeDict( (DictItem)map.get(AutoActionMeta.TYPE_DICT));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AutoActionMeta.NOTES)));
			this.setNodeNumberType(DataParser.parse(String.class, r.getValue(AutoActionMeta.NODE_NUMBER_TYPE)));
			this.setExecuteContent(DataParser.parse(String.class, r.getValue(AutoActionMeta.EXECUTE_CONTENT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AutoActionMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(AutoActionMeta.TYPE)));
			this.setTplVersion(DataParser.parse(String.class, r.getValue(AutoActionMeta.TPL_VERSION)));
			this.setConfContent(DataParser.parse(String.class, r.getValue(AutoActionMeta.CONF_CONTENT)));
			this.setExampleConfContent(DataParser.parse(String.class, r.getValue(AutoActionMeta.EXAMPLE_CONF_CONTENT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AutoActionMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AutoActionMeta.CREATE_BY)));
			this.setExecuteTool(DataParser.parse(String.class, r.getValue(AutoActionMeta.EXECUTE_TOOL)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AutoActionMeta.DELETED)));
			this.setFileStatus(DataParser.parse(String.class, r.getValue(AutoActionMeta.FILE_STATUS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AutoActionMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AutoActionMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AutoActionMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AutoActionMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AutoActionMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AutoActionMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AutoActionMeta.ID)));
			this.setSupport(DataParser.parse(String.class, r.getValue(AutoActionMeta.SUPPORT)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AutoActionMeta.STATUS)));
			this.setInfo(DataParser.parse(String.class, r.getValue(AutoActionMeta.INFO)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AutoActionMeta.NOTES));
				this.setNodeNumberType( (String)r.getValue(AutoActionMeta.NODE_NUMBER_TYPE));
				this.setExecuteContent( (String)r.getValue(AutoActionMeta.EXECUTE_CONTENT));
				this.setUpdateTime( (Date)r.getValue(AutoActionMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(AutoActionMeta.TYPE));
				this.setTplVersion( (String)r.getValue(AutoActionMeta.TPL_VERSION));
				this.setConfContent( (String)r.getValue(AutoActionMeta.CONF_CONTENT));
				this.setExampleConfContent( (String)r.getValue(AutoActionMeta.EXAMPLE_CONF_CONTENT));
				this.setVersion( (Integer)r.getValue(AutoActionMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AutoActionMeta.CREATE_BY));
				this.setExecuteTool( (String)r.getValue(AutoActionMeta.EXECUTE_TOOL));
				this.setDeleted( (Integer)r.getValue(AutoActionMeta.DELETED));
				this.setFileStatus( (String)r.getValue(AutoActionMeta.FILE_STATUS));
				this.setCreateTime( (Date)r.getValue(AutoActionMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AutoActionMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AutoActionMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AutoActionMeta.NAME));
				this.setTenantId( (String)r.getValue(AutoActionMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AutoActionMeta.DELETE_BY));
				this.setId( (String)r.getValue(AutoActionMeta.ID));
				this.setSupport( (String)r.getValue(AutoActionMeta.SUPPORT));
				this.setStatus( (String)r.getValue(AutoActionMeta.STATUS));
				this.setInfo( (String)r.getValue(AutoActionMeta.INFO));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}