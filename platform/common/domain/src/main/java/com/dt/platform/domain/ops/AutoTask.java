package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_AUTO_TASK;
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
import com.dt.platform.domain.ops.meta.AutoTaskMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 批次作业
 * <p>批次作业 , 数据表 ops_auto_task 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-02 16:07:10
 * @sign DEF624F69A823DEE29662D14DE3CFBBA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_auto_task")
@ApiModel(description = "批次作业 ; 批次作业 , 数据表 ops_auto_task 的PO类型")
public class AutoTask extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_AUTO_TASK.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "T001_mysql")
	private String id;
	
	/**
	 * 所属：所属
	*/
	@ApiModelProperty(required = false,value="所属" , notes = "所属" , example = "task")
	private String ownerId;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "Linux部署mysql")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 运行状态：运行状态
	*/
	@ApiModelProperty(required = false,value="运行状态" , notes = "运行状态" , example = "finish")
	private String runStatus;
	
	/**
	 * 分组：分组
	*/
	@ApiModelProperty(required = false,value="分组" , notes = "分组")
	private String groupId;
	
	/**
	 * 批次：批次
	*/
	@ApiModelProperty(required = false,value="批次" , notes = "批次")
	private String batchId;
	
	/**
	 * 部署模版：部署模版
	*/
	@ApiModelProperty(required = false,value="部署模版" , notes = "部署模版" , example = "T001_mysql")
	private String actionId;
	
	/**
	 * 动作配置：动作配置
	*/
	@ApiModelProperty(required = false,value="动作配置" , notes = "动作配置" , example = "[]")
	private String confContent;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择" , example = "1693566914000")
	private String selectedCode;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-09-02 04:03:31")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "4")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-09-01 07:15:30")
	private Date createTime;
	
	/**
	 * group：group
	*/
	@ApiModelProperty(required = false,value="group" , notes = "group")
	private AutoGroup group;
	
	/**
	 * batch：batch
	*/
	@ApiModelProperty(required = false,value="batch" , notes = "batch")
	private AutoBatch batch;
	
	/**
	 * action：action
	*/
	@ApiModelProperty(required = false,value="action" , notes = "action")
	private AutoAction action;
	
	/**
	 * actionConfContent：actionConfContent
	*/
	@ApiModelProperty(required = false,value="actionConfContent" , notes = "actionConfContent")
	private String actionConfContent;
	
	/**
	 * actionExecuteContent：actionExecuteContent
	*/
	@ApiModelProperty(required = false,value="actionExecuteContent" , notes = "actionExecuteContent")
	private String actionExecuteContent;
	
	/**
	 * actionInfo：actionInfo
	*/
	@ApiModelProperty(required = false,value="actionInfo" , notes = "actionInfo")
	private String actionInfo;
	
	/**
	 * actionSupport：actionSupport
	*/
	@ApiModelProperty(required = false,value="actionSupport" , notes = "actionSupport")
	private String actionSupport;
	
	/**
	 * nodeList：nodeList
	*/
	@ApiModelProperty(required = false,value="nodeList" , notes = "nodeList")
	private List<AutoNode> nodeList;
	
	/**
	 * nodeIds：nodeIds
	*/
	@ApiModelProperty(required = false,value="nodeIds" , notes = "nodeIds")
	private List<String> nodeIds;
	
	/**
	 * tplDtl：tplDtl
	*/
	@ApiModelProperty(required = false,value="tplDtl" , notes = "tplDtl")
	private String tplDtl;
	
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
	public AutoTask setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 所属<br>
	 * 所属
	 * @return 所属
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 所属
	 * @param ownerId 所属
	 * @return 当前对象
	*/
	public AutoTask setOwnerId(String ownerId) {
		this.ownerId=ownerId;
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
	public AutoTask setName(String name) {
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
	public AutoTask setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 运行状态<br>
	 * 运行状态
	 * @return 运行状态
	*/
	public String getRunStatus() {
		return runStatus;
	}
	
	/**
	 * 设置 运行状态
	 * @param runStatus 运行状态
	 * @return 当前对象
	*/
	public AutoTask setRunStatus(String runStatus) {
		this.runStatus=runStatus;
		return this;
	}
	
	/**
	 * 获得 分组<br>
	 * 分组
	 * @return 分组
	*/
	public String getGroupId() {
		return groupId;
	}
	
	/**
	 * 设置 分组
	 * @param groupId 分组
	 * @return 当前对象
	*/
	public AutoTask setGroupId(String groupId) {
		this.groupId=groupId;
		return this;
	}
	
	/**
	 * 获得 批次<br>
	 * 批次
	 * @return 批次
	*/
	public String getBatchId() {
		return batchId;
	}
	
	/**
	 * 设置 批次
	 * @param batchId 批次
	 * @return 当前对象
	*/
	public AutoTask setBatchId(String batchId) {
		this.batchId=batchId;
		return this;
	}
	
	/**
	 * 获得 部署模版<br>
	 * 部署模版
	 * @return 部署模版
	*/
	public String getActionId() {
		return actionId;
	}
	
	/**
	 * 设置 部署模版
	 * @param actionId 部署模版
	 * @return 当前对象
	*/
	public AutoTask setActionId(String actionId) {
		this.actionId=actionId;
		return this;
	}
	
	/**
	 * 获得 动作配置<br>
	 * 动作配置
	 * @return 动作配置
	*/
	public String getConfContent() {
		return confContent;
	}
	
	/**
	 * 设置 动作配置
	 * @param confContent 动作配置
	 * @return 当前对象
	*/
	public AutoTask setConfContent(String confContent) {
		this.confContent=confContent;
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
	public AutoTask setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 选择<br>
	 * 选择
	 * @return 选择
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择
	 * @param selectedCode 选择
	 * @return 当前对象
	*/
	public AutoTask setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public AutoTask setUpdateBy(String updateBy) {
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
	public AutoTask setUpdateTime(Date updateTime) {
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
	public AutoTask setDeleted(Integer deleted) {
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
	public AutoTask setDeleted(Boolean deletedBool) {
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
	public AutoTask setDeleteBy(String deleteBy) {
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
	public AutoTask setDeleteTime(Date deleteTime) {
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
	public AutoTask setVersion(Integer version) {
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
	public AutoTask setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public AutoTask setCreateBy(String createBy) {
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
	public AutoTask setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 group<br>
	 * group
	 * @return group
	*/
	public AutoGroup getGroup() {
		return group;
	}
	
	/**
	 * 设置 group
	 * @param group group
	 * @return 当前对象
	*/
	public AutoTask setGroup(AutoGroup group) {
		this.group=group;
		return this;
	}
	
	/**
	 * 获得 batch<br>
	 * batch
	 * @return batch
	*/
	public AutoBatch getBatch() {
		return batch;
	}
	
	/**
	 * 设置 batch
	 * @param batch batch
	 * @return 当前对象
	*/
	public AutoTask setBatch(AutoBatch batch) {
		this.batch=batch;
		return this;
	}
	
	/**
	 * 获得 action<br>
	 * action
	 * @return action
	*/
	public AutoAction getAction() {
		return action;
	}
	
	/**
	 * 设置 action
	 * @param action action
	 * @return 当前对象
	*/
	public AutoTask setAction(AutoAction action) {
		this.action=action;
		return this;
	}
	
	/**
	 * 获得 actionConfContent<br>
	 * actionConfContent
	 * @return actionConfContent
	*/
	public String getActionConfContent() {
		return actionConfContent;
	}
	
	/**
	 * 设置 actionConfContent
	 * @param actionConfContent actionConfContent
	 * @return 当前对象
	*/
	public AutoTask setActionConfContent(String actionConfContent) {
		this.actionConfContent=actionConfContent;
		return this;
	}
	
	/**
	 * 获得 actionExecuteContent<br>
	 * actionExecuteContent
	 * @return actionExecuteContent
	*/
	public String getActionExecuteContent() {
		return actionExecuteContent;
	}
	
	/**
	 * 设置 actionExecuteContent
	 * @param actionExecuteContent actionExecuteContent
	 * @return 当前对象
	*/
	public AutoTask setActionExecuteContent(String actionExecuteContent) {
		this.actionExecuteContent=actionExecuteContent;
		return this;
	}
	
	/**
	 * 获得 actionInfo<br>
	 * actionInfo
	 * @return actionInfo
	*/
	public String getActionInfo() {
		return actionInfo;
	}
	
	/**
	 * 设置 actionInfo
	 * @param actionInfo actionInfo
	 * @return 当前对象
	*/
	public AutoTask setActionInfo(String actionInfo) {
		this.actionInfo=actionInfo;
		return this;
	}
	
	/**
	 * 获得 actionSupport<br>
	 * actionSupport
	 * @return actionSupport
	*/
	public String getActionSupport() {
		return actionSupport;
	}
	
	/**
	 * 设置 actionSupport
	 * @param actionSupport actionSupport
	 * @return 当前对象
	*/
	public AutoTask setActionSupport(String actionSupport) {
		this.actionSupport=actionSupport;
		return this;
	}
	
	/**
	 * 获得 nodeList<br>
	 * nodeList
	 * @return nodeList
	*/
	public List<AutoNode> getNodeList() {
		return nodeList;
	}
	
	/**
	 * 设置 nodeList
	 * @param nodeList nodeList
	 * @return 当前对象
	*/
	public AutoTask setNodeList(List<AutoNode> nodeList) {
		this.nodeList=nodeList;
		return this;
	}
	
	/**
	 * 添加 nodeList
	 * @param node nodeList
	 * @return 当前对象
	*/
	public AutoTask addNode(AutoNode... node) {
		if(this.nodeList==null) nodeList=new ArrayList<>();
		this.nodeList.addAll(Arrays.asList(node));
		return this;
	}
	
	/**
	 * 获得 nodeIds<br>
	 * nodeIds
	 * @return nodeIds
	*/
	public List<String> getNodeIds() {
		return nodeIds;
	}
	
	/**
	 * 设置 nodeIds
	 * @param nodeIds nodeIds
	 * @return 当前对象
	*/
	public AutoTask setNodeIds(List<String> nodeIds) {
		this.nodeIds=nodeIds;
		return this;
	}
	
	/**
	 * 添加 nodeIds
	 * @param nodeId nodeIds
	 * @return 当前对象
	*/
	public AutoTask addNodeId(String... nodeId) {
		if(this.nodeIds==null) nodeIds=new ArrayList<>();
		this.nodeIds.addAll(Arrays.asList(nodeId));
		return this;
	}
	
	/**
	 * 获得 tplDtl<br>
	 * tplDtl
	 * @return tplDtl
	*/
	public String getTplDtl() {
		return tplDtl;
	}
	
	/**
	 * 设置 tplDtl
	 * @param tplDtl tplDtl
	 * @return 当前对象
	*/
	public AutoTask setTplDtl(String tplDtl) {
		this.tplDtl=tplDtl;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AutoTask , 转换好的 AutoTask 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AutoTask , 转换好的 PoJo 对象
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
	public AutoTask clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AutoTask duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.AutoTaskMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.AutoTaskMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setGroupId(this.getGroupId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setOwnerId(this.getOwnerId());
		inst.setBatchId(this.getBatchId());
		inst.setConfContent(this.getConfContent());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCreateTime(this.getCreateTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setActionId(this.getActionId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setRunStatus(this.getRunStatus());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setNodeIds(this.getNodeIds());
			inst.setTplDtl(this.getTplDtl());
			inst.setBatch(this.getBatch());
			inst.setActionInfo(this.getActionInfo());
			inst.setActionSupport(this.getActionSupport());
			inst.setAction(this.getAction());
			inst.setActionExecuteContent(this.getActionExecuteContent());
			inst.setNodeList(this.getNodeList());
			inst.setGroup(this.getGroup());
			inst.setActionConfContent(this.getActionConfContent());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AutoTask clone(boolean deep) {
		return EntityContext.clone(AutoTask.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AutoTask
	 * @param autoTaskMap 包含实体信息的 Map 对象
	 * @return AutoTask , 转换好的的 AutoTask 对象
	*/
	@Transient
	public static AutoTask createFrom(Map<String,Object> autoTaskMap) {
		if(autoTaskMap==null) return null;
		AutoTask po = create();
		EntityContext.copyProperties(po,autoTaskMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AutoTask
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AutoTask , 转换好的的 AutoTask 对象
	*/
	@Transient
	public static AutoTask createFrom(Object pojo) {
		if(pojo==null) return null;
		AutoTask po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AutoTask，等同于 new
	 * @return AutoTask 对象
	*/
	@Transient
	public static AutoTask create() {
		return new com.dt.platform.domain.ops.meta.AutoTaskMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AutoTaskMeta.NOTES)));
			this.setGroupId(DataParser.parse(String.class, map.get(AutoTaskMeta.GROUP_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AutoTaskMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, map.get(AutoTaskMeta.OWNER_ID)));
			this.setBatchId(DataParser.parse(String.class, map.get(AutoTaskMeta.BATCH_ID)));
			this.setConfContent(DataParser.parse(String.class, map.get(AutoTaskMeta.CONF_CONTENT)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AutoTaskMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AutoTaskMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AutoTaskMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AutoTaskMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AutoTaskMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AutoTaskMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AutoTaskMeta.CREATE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AutoTaskMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AutoTaskMeta.TENANT_ID)));
			this.setActionId(DataParser.parse(String.class, map.get(AutoTaskMeta.ACTION_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AutoTaskMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AutoTaskMeta.ID)));
			this.setRunStatus(DataParser.parse(String.class, map.get(AutoTaskMeta.RUN_STATUS)));
			this.setStatus(DataParser.parse(String.class, map.get(AutoTaskMeta.STATUS)));
			// others
			this.setTplDtl(DataParser.parse(String.class, map.get(AutoTaskMeta.TPL_DTL)));
			this.setBatch(DataParser.parse(AutoBatch.class, map.get(AutoTaskMeta.BATCH)));
			this.setActionInfo(DataParser.parse(String.class, map.get(AutoTaskMeta.ACTION_INFO)));
			this.setActionSupport(DataParser.parse(String.class, map.get(AutoTaskMeta.ACTION_SUPPORT)));
			this.setAction(DataParser.parse(AutoAction.class, map.get(AutoTaskMeta.ACTION)));
			this.setActionExecuteContent(DataParser.parse(String.class, map.get(AutoTaskMeta.ACTION_EXECUTE_CONTENT)));
			this.setGroup(DataParser.parse(AutoGroup.class, map.get(AutoTaskMeta.GROUP)));
			this.setActionConfContent(DataParser.parse(String.class, map.get(AutoTaskMeta.ACTION_CONF_CONTENT)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AutoTaskMeta.NOTES));
				this.setGroupId( (String)map.get(AutoTaskMeta.GROUP_ID));
				this.setUpdateTime( (Date)map.get(AutoTaskMeta.UPDATE_TIME));
				this.setOwnerId( (String)map.get(AutoTaskMeta.OWNER_ID));
				this.setBatchId( (String)map.get(AutoTaskMeta.BATCH_ID));
				this.setConfContent( (String)map.get(AutoTaskMeta.CONF_CONTENT));
				this.setSelectedCode( (String)map.get(AutoTaskMeta.SELECTED_CODE));
				this.setVersion( (Integer)map.get(AutoTaskMeta.VERSION));
				this.setCreateBy( (String)map.get(AutoTaskMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AutoTaskMeta.DELETED));
				this.setUpdateBy( (String)map.get(AutoTaskMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AutoTaskMeta.DELETE_TIME));
				this.setCreateTime( (Date)map.get(AutoTaskMeta.CREATE_TIME));
				this.setName( (String)map.get(AutoTaskMeta.NAME));
				this.setTenantId( (String)map.get(AutoTaskMeta.TENANT_ID));
				this.setActionId( (String)map.get(AutoTaskMeta.ACTION_ID));
				this.setDeleteBy( (String)map.get(AutoTaskMeta.DELETE_BY));
				this.setId( (String)map.get(AutoTaskMeta.ID));
				this.setRunStatus( (String)map.get(AutoTaskMeta.RUN_STATUS));
				this.setStatus( (String)map.get(AutoTaskMeta.STATUS));
				// others
				this.setTplDtl( (String)map.get(AutoTaskMeta.TPL_DTL));
				this.setBatch( (AutoBatch)map.get(AutoTaskMeta.BATCH));
				this.setActionInfo( (String)map.get(AutoTaskMeta.ACTION_INFO));
				this.setActionSupport( (String)map.get(AutoTaskMeta.ACTION_SUPPORT));
				this.setAction( (AutoAction)map.get(AutoTaskMeta.ACTION));
				this.setActionExecuteContent( (String)map.get(AutoTaskMeta.ACTION_EXECUTE_CONTENT));
				this.setGroup( (AutoGroup)map.get(AutoTaskMeta.GROUP));
				this.setActionConfContent( (String)map.get(AutoTaskMeta.ACTION_CONF_CONTENT));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AutoTaskMeta.NOTES)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(AutoTaskMeta.GROUP_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AutoTaskMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(AutoTaskMeta.OWNER_ID)));
			this.setBatchId(DataParser.parse(String.class, r.getValue(AutoTaskMeta.BATCH_ID)));
			this.setConfContent(DataParser.parse(String.class, r.getValue(AutoTaskMeta.CONF_CONTENT)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AutoTaskMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AutoTaskMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AutoTaskMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AutoTaskMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AutoTaskMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AutoTaskMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AutoTaskMeta.CREATE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AutoTaskMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AutoTaskMeta.TENANT_ID)));
			this.setActionId(DataParser.parse(String.class, r.getValue(AutoTaskMeta.ACTION_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AutoTaskMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AutoTaskMeta.ID)));
			this.setRunStatus(DataParser.parse(String.class, r.getValue(AutoTaskMeta.RUN_STATUS)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AutoTaskMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AutoTaskMeta.NOTES));
				this.setGroupId( (String)r.getValue(AutoTaskMeta.GROUP_ID));
				this.setUpdateTime( (Date)r.getValue(AutoTaskMeta.UPDATE_TIME));
				this.setOwnerId( (String)r.getValue(AutoTaskMeta.OWNER_ID));
				this.setBatchId( (String)r.getValue(AutoTaskMeta.BATCH_ID));
				this.setConfContent( (String)r.getValue(AutoTaskMeta.CONF_CONTENT));
				this.setSelectedCode( (String)r.getValue(AutoTaskMeta.SELECTED_CODE));
				this.setVersion( (Integer)r.getValue(AutoTaskMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AutoTaskMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AutoTaskMeta.DELETED));
				this.setUpdateBy( (String)r.getValue(AutoTaskMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AutoTaskMeta.DELETE_TIME));
				this.setCreateTime( (Date)r.getValue(AutoTaskMeta.CREATE_TIME));
				this.setName( (String)r.getValue(AutoTaskMeta.NAME));
				this.setTenantId( (String)r.getValue(AutoTaskMeta.TENANT_ID));
				this.setActionId( (String)r.getValue(AutoTaskMeta.ACTION_ID));
				this.setDeleteBy( (String)r.getValue(AutoTaskMeta.DELETE_BY));
				this.setId( (String)r.getValue(AutoTaskMeta.ID));
				this.setRunStatus( (String)r.getValue(AutoTaskMeta.RUN_STATUS));
				this.setStatus( (String)r.getValue(AutoTaskMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}