package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_REPAIR_ORDER_TRANSFER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.RepairOrderTransferMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 工单转派
 * <p>工单转派 , 数据表 eam_repair_order_transfer 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-18 09:29:35
 * @sign 51AB7062A27618BCD8AF9780F10CFB07
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_repair_order_transfer")
@ApiModel(description = "工单转派 ; 工单转派 , 数据表 eam_repair_order_transfer 的PO类型")
public class RepairOrderTransfer extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_REPAIR_ORDER_TRANSFER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 维修工单：维修工单
	*/
	@ApiModelProperty(required = false,value="维修工单" , notes = "维修工单")
	private String orderActId;
	
	/**
	 * 申请工单：申请工单
	*/
	@ApiModelProperty(required = false,value="申请工单" , notes = "申请工单")
	private String orderId;
	
	/**
	 * 维修班组：维修班组
	*/
	@ApiModelProperty(required = false,value="维修班组" , notes = "维修班组")
	private String groupId;
	
	/**
	 * 维修人员：维修人员
	*/
	@ApiModelProperty(required = false,value="维修人员" , notes = "维修人员")
	private String executorId;
	
	/**
	 * 规则：规则
	*/
	@ApiModelProperty(required = false,value="规则" , notes = "规则")
	private String rule;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * 维修工单：维修工单
	*/
	@ApiModelProperty(required = false,value="维修工单" , notes = "维修工单")
	private RepairOrderAct orderAct;
	
	/**
	 * 维修申请：维修申请
	*/
	@ApiModelProperty(required = false,value="维修申请" , notes = "维修申请")
	private RepairOrder order;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 执行人：执行人
	*/
	@ApiModelProperty(required = false,value="执行人" , notes = "执行人")
	private Employee executor;
	
	/**
	 * 维修班组：维修班组
	*/
	@ApiModelProperty(required = false,value="维修班组" , notes = "维修班组")
	private RepairGroup repairGroup;
	
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
	public RepairOrderTransfer setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 维修工单<br>
	 * 维修工单
	 * @return 维修工单
	*/
	public String getOrderActId() {
		return orderActId;
	}
	
	/**
	 * 设置 维修工单
	 * @param orderActId 维修工单
	 * @return 当前对象
	*/
	public RepairOrderTransfer setOrderActId(String orderActId) {
		this.orderActId=orderActId;
		return this;
	}
	
	/**
	 * 获得 申请工单<br>
	 * 申请工单
	 * @return 申请工单
	*/
	public String getOrderId() {
		return orderId;
	}
	
	/**
	 * 设置 申请工单
	 * @param orderId 申请工单
	 * @return 当前对象
	*/
	public RepairOrderTransfer setOrderId(String orderId) {
		this.orderId=orderId;
		return this;
	}
	
	/**
	 * 获得 维修班组<br>
	 * 维修班组
	 * @return 维修班组
	*/
	public String getGroupId() {
		return groupId;
	}
	
	/**
	 * 设置 维修班组
	 * @param groupId 维修班组
	 * @return 当前对象
	*/
	public RepairOrderTransfer setGroupId(String groupId) {
		this.groupId=groupId;
		return this;
	}
	
	/**
	 * 获得 维修人员<br>
	 * 维修人员
	 * @return 维修人员
	*/
	public String getExecutorId() {
		return executorId;
	}
	
	/**
	 * 设置 维修人员
	 * @param executorId 维修人员
	 * @return 当前对象
	*/
	public RepairOrderTransfer setExecutorId(String executorId) {
		this.executorId=executorId;
		return this;
	}
	
	/**
	 * 获得 规则<br>
	 * 规则
	 * @return 规则
	*/
	public String getRule() {
		return rule;
	}
	
	/**
	 * 设置 规则
	 * @param rule 规则
	 * @return 当前对象
	*/
	public RepairOrderTransfer setRule(String rule) {
		this.rule=rule;
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
	public RepairOrderTransfer setNotes(String notes) {
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
	public RepairOrderTransfer setCreateBy(String createBy) {
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
	public RepairOrderTransfer setCreateTime(Date createTime) {
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
	public RepairOrderTransfer setUpdateBy(String updateBy) {
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
	public RepairOrderTransfer setUpdateTime(Date updateTime) {
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
	public RepairOrderTransfer setDeleted(Integer deleted) {
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
	public RepairOrderTransfer setDeleted(Boolean deletedBool) {
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
	public RepairOrderTransfer setDeleteBy(String deleteBy) {
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
	public RepairOrderTransfer setDeleteTime(Date deleteTime) {
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
	public RepairOrderTransfer setVersion(Integer version) {
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
	public RepairOrderTransfer setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 维修工单<br>
	 * 维修工单
	 * @return 维修工单
	*/
	public RepairOrderAct getOrderAct() {
		return orderAct;
	}
	
	/**
	 * 设置 维修工单
	 * @param orderAct 维修工单
	 * @return 当前对象
	*/
	public RepairOrderTransfer setOrderAct(RepairOrderAct orderAct) {
		this.orderAct=orderAct;
		return this;
	}
	
	/**
	 * 获得 维修申请<br>
	 * 维修申请
	 * @return 维修申请
	*/
	public RepairOrder getOrder() {
		return order;
	}
	
	/**
	 * 设置 维修申请
	 * @param order 维修申请
	 * @return 当前对象
	*/
	public RepairOrderTransfer setOrder(RepairOrder order) {
		this.order=order;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public Employee getOriginator() {
		return originator;
	}
	
	/**
	 * 设置 制单人
	 * @param originator 制单人
	 * @return 当前对象
	*/
	public RepairOrderTransfer setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 执行人<br>
	 * 执行人
	 * @return 执行人
	*/
	public Employee getExecutor() {
		return executor;
	}
	
	/**
	 * 设置 执行人
	 * @param executor 执行人
	 * @return 当前对象
	*/
	public RepairOrderTransfer setExecutor(Employee executor) {
		this.executor=executor;
		return this;
	}
	
	/**
	 * 获得 维修班组<br>
	 * 维修班组
	 * @return 维修班组
	*/
	public RepairGroup getRepairGroup() {
		return repairGroup;
	}
	
	/**
	 * 设置 维修班组
	 * @param repairGroup 维修班组
	 * @return 当前对象
	*/
	public RepairOrderTransfer setRepairGroup(RepairGroup repairGroup) {
		this.repairGroup=repairGroup;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return RepairOrderTransfer , 转换好的 RepairOrderTransfer 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RepairOrderTransfer , 转换好的 PoJo 对象
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
	public RepairOrderTransfer clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public RepairOrderTransfer duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.RepairOrderTransferMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.RepairOrderTransferMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setOrderId(this.getOrderId());
		inst.setExecutorId(this.getExecutorId());
		inst.setGroupId(this.getGroupId());
		inst.setRule(this.getRule());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setOrderActId(this.getOrderActId());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
			inst.setOrderAct(this.getOrderAct());
			inst.setExecutor(this.getExecutor());
			inst.setRepairGroup(this.getRepairGroup());
			inst.setOriginator(this.getOriginator());
			inst.setOrder(this.getOrder());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public RepairOrderTransfer clone(boolean deep) {
		return EntityContext.clone(RepairOrderTransfer.class,this,deep);
	}

	/**
	 * 将 Map 转换成 RepairOrderTransfer
	 * @param repairOrderTransferMap 包含实体信息的 Map 对象
	 * @return RepairOrderTransfer , 转换好的的 RepairOrderTransfer 对象
	*/
	@Transient
	public static RepairOrderTransfer createFrom(Map<String,Object> repairOrderTransferMap) {
		if(repairOrderTransferMap==null) return null;
		RepairOrderTransfer po = create();
		EntityContext.copyProperties(po,repairOrderTransferMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 RepairOrderTransfer
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RepairOrderTransfer , 转换好的的 RepairOrderTransfer 对象
	*/
	@Transient
	public static RepairOrderTransfer createFrom(Object pojo) {
		if(pojo==null) return null;
		RepairOrderTransfer po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 RepairOrderTransfer，等同于 new
	 * @return RepairOrderTransfer 对象
	*/
	@Transient
	public static RepairOrderTransfer create() {
		return new com.dt.platform.domain.eam.meta.RepairOrderTransferMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(RepairOrderTransferMeta.NOTES)));
			this.setOrderId(DataParser.parse(String.class, map.get(RepairOrderTransferMeta.ORDER_ID)));
			this.setExecutorId(DataParser.parse(String.class, map.get(RepairOrderTransferMeta.EXECUTOR_ID)));
			this.setGroupId(DataParser.parse(String.class, map.get(RepairOrderTransferMeta.GROUP_ID)));
			this.setRule(DataParser.parse(String.class, map.get(RepairOrderTransferMeta.RULE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(RepairOrderTransferMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(RepairOrderTransferMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(RepairOrderTransferMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(RepairOrderTransferMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(RepairOrderTransferMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(RepairOrderTransferMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(RepairOrderTransferMeta.DELETE_TIME)));
			this.setOrderActId(DataParser.parse(String.class, map.get(RepairOrderTransferMeta.ORDER_ACT_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(RepairOrderTransferMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(RepairOrderTransferMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(RepairOrderTransferMeta.ID)));
			// others
			this.setOrderAct(DataParser.parse(RepairOrderAct.class, map.get(RepairOrderTransferMeta.ORDER_ACT)));
			this.setExecutor(DataParser.parse(Employee.class, map.get(RepairOrderTransferMeta.EXECUTOR)));
			this.setRepairGroup(DataParser.parse(RepairGroup.class, map.get(RepairOrderTransferMeta.REPAIR_GROUP)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(RepairOrderTransferMeta.ORIGINATOR)));
			this.setOrder(DataParser.parse(RepairOrder.class, map.get(RepairOrderTransferMeta.ORDER)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(RepairOrderTransferMeta.NOTES));
				this.setOrderId( (String)map.get(RepairOrderTransferMeta.ORDER_ID));
				this.setExecutorId( (String)map.get(RepairOrderTransferMeta.EXECUTOR_ID));
				this.setGroupId( (String)map.get(RepairOrderTransferMeta.GROUP_ID));
				this.setRule( (String)map.get(RepairOrderTransferMeta.RULE));
				this.setUpdateTime( (Date)map.get(RepairOrderTransferMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(RepairOrderTransferMeta.VERSION));
				this.setCreateBy( (String)map.get(RepairOrderTransferMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(RepairOrderTransferMeta.DELETED));
				this.setCreateTime( (Date)map.get(RepairOrderTransferMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(RepairOrderTransferMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(RepairOrderTransferMeta.DELETE_TIME));
				this.setOrderActId( (String)map.get(RepairOrderTransferMeta.ORDER_ACT_ID));
				this.setTenantId( (String)map.get(RepairOrderTransferMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(RepairOrderTransferMeta.DELETE_BY));
				this.setId( (String)map.get(RepairOrderTransferMeta.ID));
				// others
				this.setOrderAct( (RepairOrderAct)map.get(RepairOrderTransferMeta.ORDER_ACT));
				this.setExecutor( (Employee)map.get(RepairOrderTransferMeta.EXECUTOR));
				this.setRepairGroup( (RepairGroup)map.get(RepairOrderTransferMeta.REPAIR_GROUP));
				this.setOriginator( (Employee)map.get(RepairOrderTransferMeta.ORIGINATOR));
				this.setOrder( (RepairOrder)map.get(RepairOrderTransferMeta.ORDER));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(RepairOrderTransferMeta.NOTES)));
			this.setOrderId(DataParser.parse(String.class, r.getValue(RepairOrderTransferMeta.ORDER_ID)));
			this.setExecutorId(DataParser.parse(String.class, r.getValue(RepairOrderTransferMeta.EXECUTOR_ID)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(RepairOrderTransferMeta.GROUP_ID)));
			this.setRule(DataParser.parse(String.class, r.getValue(RepairOrderTransferMeta.RULE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(RepairOrderTransferMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(RepairOrderTransferMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(RepairOrderTransferMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(RepairOrderTransferMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(RepairOrderTransferMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(RepairOrderTransferMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(RepairOrderTransferMeta.DELETE_TIME)));
			this.setOrderActId(DataParser.parse(String.class, r.getValue(RepairOrderTransferMeta.ORDER_ACT_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(RepairOrderTransferMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(RepairOrderTransferMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(RepairOrderTransferMeta.ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(RepairOrderTransferMeta.NOTES));
				this.setOrderId( (String)r.getValue(RepairOrderTransferMeta.ORDER_ID));
				this.setExecutorId( (String)r.getValue(RepairOrderTransferMeta.EXECUTOR_ID));
				this.setGroupId( (String)r.getValue(RepairOrderTransferMeta.GROUP_ID));
				this.setRule( (String)r.getValue(RepairOrderTransferMeta.RULE));
				this.setUpdateTime( (Date)r.getValue(RepairOrderTransferMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(RepairOrderTransferMeta.VERSION));
				this.setCreateBy( (String)r.getValue(RepairOrderTransferMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(RepairOrderTransferMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(RepairOrderTransferMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(RepairOrderTransferMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(RepairOrderTransferMeta.DELETE_TIME));
				this.setOrderActId( (String)r.getValue(RepairOrderTransferMeta.ORDER_ACT_ID));
				this.setTenantId( (String)r.getValue(RepairOrderTransferMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(RepairOrderTransferMeta.DELETE_BY));
				this.setId( (String)r.getValue(RepairOrderTransferMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}