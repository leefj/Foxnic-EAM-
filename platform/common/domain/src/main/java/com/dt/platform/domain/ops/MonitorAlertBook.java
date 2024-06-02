package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_MONITOR_ALERT_BOOK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.system.BusiRole;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.MonitorAlertBookMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 告警订阅
 * <p>告警订阅 , 数据表 ops_monitor_alert_book 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-02 14:21:56
 * @sign 1ACF8BAD6D4E20FA076C8F1A33FCAD10
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_alert_book")
@ApiModel(description = "告警订阅 ; 告警订阅 , 数据表 ops_monitor_alert_book 的PO类型")
public class MonitorAlertBook extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_ALERT_BOOK.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "849233044161167360")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "系统")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 全部对象：全部对象
	*/
	@ApiModelProperty(required = false,value="全部对象" , notes = "全部对象" , example = "yes")
	private String monitorIsAll;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-06-01 10:28:56")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-06-01 09:57:33")
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
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本" , example = "4")
	private Integer version;
	
	/**
	 * 人员群组：人员群组
	*/
	@ApiModelProperty(required = false,value="人员群组" , notes = "人员群组")
	private List<BusiRole> userGroupList;
	
	/**
	 * 人员群组：人员群组
	*/
	@ApiModelProperty(required = false,value="人员群组" , notes = "人员群组")
	private List<String> userGroupIds;
	
	/**
	 * userGroupUserList：userGroupUserList
	*/
	@ApiModelProperty(required = false,value="userGroupUserList" , notes = "userGroupUserList")
	private List<Employee> userGroupUserList;
	
	/**
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员")
	private List<Employee> userList;
	
	/**
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员")
	private List<String> userIds;
	
	/**
	 * nodeGroupList：nodeGroupList
	*/
	@ApiModelProperty(required = false,value="nodeGroupList" , notes = "nodeGroupList")
	private List<MonitorNodeGroup> nodeGroupList;
	
	/**
	 * nodeGroupIds：nodeGroupIds
	*/
	@ApiModelProperty(required = false,value="nodeGroupIds" , notes = "nodeGroupIds")
	private List<String> nodeGroupIds;
	
	/**
	 * nodeList：nodeList
	*/
	@ApiModelProperty(required = false,value="nodeList" , notes = "nodeList")
	private List<MonitorNode> nodeList;
	
	/**
	 * nodeIds：nodeIds
	*/
	@ApiModelProperty(required = false,value="nodeIds" , notes = "nodeIds")
	private List<String> nodeIds;
	
	/**
	 * levelList：levelList
	*/
	@ApiModelProperty(required = false,value="levelList" , notes = "levelList")
	private List<DictItem> levelList;
	
	/**
	 * levelIds：levelIds
	*/
	@ApiModelProperty(required = false,value="levelIds" , notes = "levelIds")
	private List<String> levelIds;
	
	/**
	 * alertMethodList：alertMethodList
	*/
	@ApiModelProperty(required = false,value="alertMethodList" , notes = "alertMethodList")
	private List<MonitorAlertMethod> alertMethodList;
	
	/**
	 * alertMethodIds：alertMethodIds
	*/
	@ApiModelProperty(required = false,value="alertMethodIds" , notes = "alertMethodIds")
	private List<String> alertMethodIds;
	
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
	public MonitorAlertBook setId(String id) {
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
	public MonitorAlertBook setName(String name) {
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
	public MonitorAlertBook setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 全部对象<br>
	 * 全部对象
	 * @return 全部对象
	*/
	public String getMonitorIsAll() {
		return monitorIsAll;
	}
	
	/**
	 * 设置 全部对象
	 * @param monitorIsAll 全部对象
	 * @return 当前对象
	*/
	public MonitorAlertBook setMonitorIsAll(String monitorIsAll) {
		this.monitorIsAll=monitorIsAll;
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
	public MonitorAlertBook setNotes(String notes) {
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
	public MonitorAlertBook setCreateBy(String createBy) {
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
	public MonitorAlertBook setCreateTime(Date createTime) {
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
	public MonitorAlertBook setUpdateBy(String updateBy) {
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
	public MonitorAlertBook setUpdateTime(Date updateTime) {
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
	public MonitorAlertBook setDeleted(Integer deleted) {
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
	public MonitorAlertBook setDeleted(Boolean deletedBool) {
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
	public MonitorAlertBook setDeleteBy(String deleteBy) {
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
	public MonitorAlertBook setDeleteTime(Date deleteTime) {
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
	public MonitorAlertBook setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 人员群组<br>
	 * 人员群组
	 * @return 人员群组
	*/
	public List<BusiRole> getUserGroupList() {
		return userGroupList;
	}
	
	/**
	 * 设置 人员群组
	 * @param userGroupList 人员群组
	 * @return 当前对象
	*/
	public MonitorAlertBook setUserGroupList(List<BusiRole> userGroupList) {
		this.userGroupList=userGroupList;
		return this;
	}
	
	/**
	 * 添加 人员群组
	 * @param userGroup 人员群组
	 * @return 当前对象
	*/
	public MonitorAlertBook addUserGroup(BusiRole... userGroup) {
		if(this.userGroupList==null) userGroupList=new ArrayList<>();
		this.userGroupList.addAll(Arrays.asList(userGroup));
		return this;
	}
	
	/**
	 * 获得 人员群组<br>
	 * 人员群组
	 * @return 人员群组
	*/
	public List<String> getUserGroupIds() {
		return userGroupIds;
	}
	
	/**
	 * 设置 人员群组
	 * @param userGroupIds 人员群组
	 * @return 当前对象
	*/
	public MonitorAlertBook setUserGroupIds(List<String> userGroupIds) {
		this.userGroupIds=userGroupIds;
		return this;
	}
	
	/**
	 * 添加 人员群组
	 * @param userGroupId 人员群组
	 * @return 当前对象
	*/
	public MonitorAlertBook addUserGroupId(String... userGroupId) {
		if(this.userGroupIds==null) userGroupIds=new ArrayList<>();
		this.userGroupIds.addAll(Arrays.asList(userGroupId));
		return this;
	}
	
	/**
	 * 获得 userGroupUserList<br>
	 * userGroupUserList
	 * @return userGroupUserList
	*/
	public List<Employee> getUserGroupUserList() {
		return userGroupUserList;
	}
	
	/**
	 * 设置 userGroupUserList
	 * @param userGroupUserList userGroupUserList
	 * @return 当前对象
	*/
	public MonitorAlertBook setUserGroupUserList(List<Employee> userGroupUserList) {
		this.userGroupUserList=userGroupUserList;
		return this;
	}
	
	/**
	 * 添加 userGroupUserList
	 * @param userGroupUser userGroupUserList
	 * @return 当前对象
	*/
	public MonitorAlertBook addUserGroupUser(Employee... userGroupUser) {
		if(this.userGroupUserList==null) userGroupUserList=new ArrayList<>();
		this.userGroupUserList.addAll(Arrays.asList(userGroupUser));
		return this;
	}
	
	/**
	 * 获得 人员<br>
	 * 人员
	 * @return 人员
	*/
	public List<Employee> getUserList() {
		return userList;
	}
	
	/**
	 * 设置 人员
	 * @param userList 人员
	 * @return 当前对象
	*/
	public MonitorAlertBook setUserList(List<Employee> userList) {
		this.userList=userList;
		return this;
	}
	
	/**
	 * 添加 人员
	 * @param user 人员
	 * @return 当前对象
	*/
	public MonitorAlertBook addUser(Employee... user) {
		if(this.userList==null) userList=new ArrayList<>();
		this.userList.addAll(Arrays.asList(user));
		return this;
	}
	
	/**
	 * 获得 人员<br>
	 * 人员
	 * @return 人员
	*/
	public List<String> getUserIds() {
		return userIds;
	}
	
	/**
	 * 设置 人员
	 * @param userIds 人员
	 * @return 当前对象
	*/
	public MonitorAlertBook setUserIds(List<String> userIds) {
		this.userIds=userIds;
		return this;
	}
	
	/**
	 * 添加 人员
	 * @param userId 人员
	 * @return 当前对象
	*/
	public MonitorAlertBook addUserId(String... userId) {
		if(this.userIds==null) userIds=new ArrayList<>();
		this.userIds.addAll(Arrays.asList(userId));
		return this;
	}
	
	/**
	 * 获得 nodeGroupList<br>
	 * nodeGroupList
	 * @return nodeGroupList
	*/
	public List<MonitorNodeGroup> getNodeGroupList() {
		return nodeGroupList;
	}
	
	/**
	 * 设置 nodeGroupList
	 * @param nodeGroupList nodeGroupList
	 * @return 当前对象
	*/
	public MonitorAlertBook setNodeGroupList(List<MonitorNodeGroup> nodeGroupList) {
		this.nodeGroupList=nodeGroupList;
		return this;
	}
	
	/**
	 * 添加 nodeGroupList
	 * @param nodeGroup nodeGroupList
	 * @return 当前对象
	*/
	public MonitorAlertBook addNodeGroup(MonitorNodeGroup... nodeGroup) {
		if(this.nodeGroupList==null) nodeGroupList=new ArrayList<>();
		this.nodeGroupList.addAll(Arrays.asList(nodeGroup));
		return this;
	}
	
	/**
	 * 获得 nodeGroupIds<br>
	 * nodeGroupIds
	 * @return nodeGroupIds
	*/
	public List<String> getNodeGroupIds() {
		return nodeGroupIds;
	}
	
	/**
	 * 设置 nodeGroupIds
	 * @param nodeGroupIds nodeGroupIds
	 * @return 当前对象
	*/
	public MonitorAlertBook setNodeGroupIds(List<String> nodeGroupIds) {
		this.nodeGroupIds=nodeGroupIds;
		return this;
	}
	
	/**
	 * 添加 nodeGroupIds
	 * @param nodeGroupId nodeGroupIds
	 * @return 当前对象
	*/
	public MonitorAlertBook addNodeGroupId(String... nodeGroupId) {
		if(this.nodeGroupIds==null) nodeGroupIds=new ArrayList<>();
		this.nodeGroupIds.addAll(Arrays.asList(nodeGroupId));
		return this;
	}
	
	/**
	 * 获得 nodeList<br>
	 * nodeList
	 * @return nodeList
	*/
	public List<MonitorNode> getNodeList() {
		return nodeList;
	}
	
	/**
	 * 设置 nodeList
	 * @param nodeList nodeList
	 * @return 当前对象
	*/
	public MonitorAlertBook setNodeList(List<MonitorNode> nodeList) {
		this.nodeList=nodeList;
		return this;
	}
	
	/**
	 * 添加 nodeList
	 * @param node nodeList
	 * @return 当前对象
	*/
	public MonitorAlertBook addNode(MonitorNode... node) {
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
	public MonitorAlertBook setNodeIds(List<String> nodeIds) {
		this.nodeIds=nodeIds;
		return this;
	}
	
	/**
	 * 添加 nodeIds
	 * @param nodeId nodeIds
	 * @return 当前对象
	*/
	public MonitorAlertBook addNodeId(String... nodeId) {
		if(this.nodeIds==null) nodeIds=new ArrayList<>();
		this.nodeIds.addAll(Arrays.asList(nodeId));
		return this;
	}
	
	/**
	 * 获得 levelList<br>
	 * levelList
	 * @return levelList
	*/
	public List<DictItem> getLevelList() {
		return levelList;
	}
	
	/**
	 * 设置 levelList
	 * @param levelList levelList
	 * @return 当前对象
	*/
	public MonitorAlertBook setLevelList(List<DictItem> levelList) {
		this.levelList=levelList;
		return this;
	}
	
	/**
	 * 添加 levelList
	 * @param level levelList
	 * @return 当前对象
	*/
	public MonitorAlertBook addLevel(DictItem... level) {
		if(this.levelList==null) levelList=new ArrayList<>();
		this.levelList.addAll(Arrays.asList(level));
		return this;
	}
	
	/**
	 * 获得 levelIds<br>
	 * levelIds
	 * @return levelIds
	*/
	public List<String> getLevelIds() {
		return levelIds;
	}
	
	/**
	 * 设置 levelIds
	 * @param levelIds levelIds
	 * @return 当前对象
	*/
	public MonitorAlertBook setLevelIds(List<String> levelIds) {
		this.levelIds=levelIds;
		return this;
	}
	
	/**
	 * 添加 levelIds
	 * @param levelId levelIds
	 * @return 当前对象
	*/
	public MonitorAlertBook addLevelId(String... levelId) {
		if(this.levelIds==null) levelIds=new ArrayList<>();
		this.levelIds.addAll(Arrays.asList(levelId));
		return this;
	}
	
	/**
	 * 获得 alertMethodList<br>
	 * alertMethodList
	 * @return alertMethodList
	*/
	public List<MonitorAlertMethod> getAlertMethodList() {
		return alertMethodList;
	}
	
	/**
	 * 设置 alertMethodList
	 * @param alertMethodList alertMethodList
	 * @return 当前对象
	*/
	public MonitorAlertBook setAlertMethodList(List<MonitorAlertMethod> alertMethodList) {
		this.alertMethodList=alertMethodList;
		return this;
	}
	
	/**
	 * 添加 alertMethodList
	 * @param alertMethod alertMethodList
	 * @return 当前对象
	*/
	public MonitorAlertBook addAlertMethod(MonitorAlertMethod... alertMethod) {
		if(this.alertMethodList==null) alertMethodList=new ArrayList<>();
		this.alertMethodList.addAll(Arrays.asList(alertMethod));
		return this;
	}
	
	/**
	 * 获得 alertMethodIds<br>
	 * alertMethodIds
	 * @return alertMethodIds
	*/
	public List<String> getAlertMethodIds() {
		return alertMethodIds;
	}
	
	/**
	 * 设置 alertMethodIds
	 * @param alertMethodIds alertMethodIds
	 * @return 当前对象
	*/
	public MonitorAlertBook setAlertMethodIds(List<String> alertMethodIds) {
		this.alertMethodIds=alertMethodIds;
		return this;
	}
	
	/**
	 * 添加 alertMethodIds
	 * @param alertMethodId alertMethodIds
	 * @return 当前对象
	*/
	public MonitorAlertBook addAlertMethodId(String... alertMethodId) {
		if(this.alertMethodIds==null) alertMethodIds=new ArrayList<>();
		this.alertMethodIds.addAll(Arrays.asList(alertMethodId));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorAlertBook , 转换好的 MonitorAlertBook 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorAlertBook , 转换好的 PoJo 对象
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
	public MonitorAlertBook clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MonitorAlertBook duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.MonitorAlertBookMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.MonitorAlertBookMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setMonitorIsAll(this.getMonitorIsAll());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setAlertMethodList(this.getAlertMethodList());
			inst.setLevelIds(this.getLevelIds());
			inst.setLevelList(this.getLevelList());
			inst.setUserGroupIds(this.getUserGroupIds());
			inst.setNodeGroupIds(this.getNodeGroupIds());
			inst.setNodeList(this.getNodeList());
			inst.setNodeIds(this.getNodeIds());
			inst.setUserGroupUserList(this.getUserGroupUserList());
			inst.setUserList(this.getUserList());
			inst.setUserIds(this.getUserIds());
			inst.setNodeGroupList(this.getNodeGroupList());
			inst.setUserGroupList(this.getUserGroupList());
			inst.setAlertMethodIds(this.getAlertMethodIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MonitorAlertBook clone(boolean deep) {
		return EntityContext.clone(MonitorAlertBook.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MonitorAlertBook
	 * @param monitorAlertBookMap 包含实体信息的 Map 对象
	 * @return MonitorAlertBook , 转换好的的 MonitorAlertBook 对象
	*/
	@Transient
	public static MonitorAlertBook createFrom(Map<String,Object> monitorAlertBookMap) {
		if(monitorAlertBookMap==null) return null;
		MonitorAlertBook po = create();
		EntityContext.copyProperties(po,monitorAlertBookMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorAlertBook
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorAlertBook , 转换好的的 MonitorAlertBook 对象
	*/
	@Transient
	public static MonitorAlertBook createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorAlertBook po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 MonitorAlertBook，等同于 new
	 * @return MonitorAlertBook 对象
	*/
	@Transient
	public static MonitorAlertBook create() {
		return new com.dt.platform.domain.ops.meta.MonitorAlertBookMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(MonitorAlertBookMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MonitorAlertBookMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MonitorAlertBookMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MonitorAlertBookMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MonitorAlertBookMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MonitorAlertBookMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MonitorAlertBookMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MonitorAlertBookMeta.DELETE_TIME)));
			this.setMonitorIsAll(DataParser.parse(String.class, map.get(MonitorAlertBookMeta.MONITOR_IS_ALL)));
			this.setName(DataParser.parse(String.class, map.get(MonitorAlertBookMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MonitorAlertBookMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(MonitorAlertBookMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(MonitorAlertBookMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(MonitorAlertBookMeta.NOTES));
				this.setUpdateTime( (Date)map.get(MonitorAlertBookMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(MonitorAlertBookMeta.VERSION));
				this.setCreateBy( (String)map.get(MonitorAlertBookMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MonitorAlertBookMeta.DELETED));
				this.setCreateTime( (Date)map.get(MonitorAlertBookMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(MonitorAlertBookMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(MonitorAlertBookMeta.DELETE_TIME));
				this.setMonitorIsAll( (String)map.get(MonitorAlertBookMeta.MONITOR_IS_ALL));
				this.setName( (String)map.get(MonitorAlertBookMeta.NAME));
				this.setDeleteBy( (String)map.get(MonitorAlertBookMeta.DELETE_BY));
				this.setId( (String)map.get(MonitorAlertBookMeta.ID));
				this.setStatus( (String)map.get(MonitorAlertBookMeta.STATUS));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(MonitorAlertBookMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MonitorAlertBookMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MonitorAlertBookMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MonitorAlertBookMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MonitorAlertBookMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MonitorAlertBookMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MonitorAlertBookMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MonitorAlertBookMeta.DELETE_TIME)));
			this.setMonitorIsAll(DataParser.parse(String.class, r.getValue(MonitorAlertBookMeta.MONITOR_IS_ALL)));
			this.setName(DataParser.parse(String.class, r.getValue(MonitorAlertBookMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MonitorAlertBookMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(MonitorAlertBookMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(MonitorAlertBookMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(MonitorAlertBookMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(MonitorAlertBookMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(MonitorAlertBookMeta.VERSION));
				this.setCreateBy( (String)r.getValue(MonitorAlertBookMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MonitorAlertBookMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(MonitorAlertBookMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(MonitorAlertBookMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(MonitorAlertBookMeta.DELETE_TIME));
				this.setMonitorIsAll( (String)r.getValue(MonitorAlertBookMeta.MONITOR_IS_ALL));
				this.setName( (String)r.getValue(MonitorAlertBookMeta.NAME));
				this.setDeleteBy( (String)r.getValue(MonitorAlertBookMeta.DELETE_BY));
				this.setId( (String)r.getValue(MonitorAlertBookMeta.ID));
				this.setStatus( (String)r.getValue(MonitorAlertBookMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}