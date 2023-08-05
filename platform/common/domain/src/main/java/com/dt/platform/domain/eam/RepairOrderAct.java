package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_REPAIR_ORDER_ACT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.RepairOrderActMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 维修工单
 * <p>维修工单 , 数据表 eam_repair_order_act 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-05 09:40:46
 * @sign DAA12D5846AE8990425608408282BF6C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_repair_order_act")
@ApiModel(description = "维修工单 ; 维修工单 , 数据表 eam_repair_order_act 的PO类型")
public class RepairOrderAct extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_REPAIR_ORDER_ACT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "740102041900154880")
	private String id;
	
	/**
	 * 申请单：申请单
	*/
	@ApiModelProperty(required = false,value="申请单" , notes = "申请单" , example = "740102006546366464")
	private String orderId;
	
	/**
	 * 订单编号：订单编号
	*/
	@ApiModelProperty(required = false,value="订单编号" , notes = "订单编号" , example = "ROD202301050701166")
	private String orderBusinessCode;
	
	/**
	 * 订单名称：订单名称
	*/
	@ApiModelProperty(required = false,value="订单名称" , notes = "订单名称" , example = "121212")
	private String orderName;
	
	/**
	 * 维修编号：维修编号
	*/
	@ApiModelProperty(required = false,value="维修编号" , notes = "维修编号" , example = "MOD202301050701796")
	private String businessCode;
	
	/**
	 * 维修班组：维修班组
	*/
	@ApiModelProperty(required = false,value="维修班组" , notes = "维修班组" , example = "698166168703205376")
	private String groupId;
	
	/**
	 * 维修人员：维修人员
	*/
	@ApiModelProperty(required = false,value="维修人员" , notes = "维修人员")
	private String executorId;
	
	/**
	 * 维修费用：维修费用
	*/
	@ApiModelProperty(required = false,value="维修费用" , notes = "维修费用" , example = "0.00")
	private BigDecimal repairCost;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间")
	private Date startTime;
	
	/**
	 * 完成时间：完成时间
	*/
	@ApiModelProperty(required = false,value="完成时间" , notes = "完成时间")
	private Date finishTime;
	
	/**
	 * 维修备注：维修备注
	*/
	@ApiModelProperty(required = false,value="维修备注" , notes = "维修备注" , example = "qwwq")
	private String notes;
	
	/**
	 * 图片：图片
	*/
	@ApiModelProperty(required = false,value="图片" , notes = "图片")
	private String pictureId;
	
	/**
	 * 制单人员：制单人员
	*/
	@ApiModelProperty(required = false,value="制单人员" , notes = "制单人员" , example = "E001")
	private String originatorId;
	
	/**
	 * 跟随验证：跟随验证
	*/
	@ApiModelProperty(required = false,value="跟随验证" , notes = "跟随验证")
	private String withAcceptance;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-08-05 07:01:17")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-08-05 07:07:36")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "2")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 选择数据：选择数据
	*/
	@ApiModelProperty(required = false,value="选择数据" , notes = "选择数据" , example = "1691190422000")
	private String selectedCode;
	
	/**
	 * repairOrderProcess：repairOrderProcess
	*/
	@ApiModelProperty(required = false,value="repairOrderProcess" , notes = "repairOrderProcess")
	private List<RepairOrderProcess> repairOrderProcess;
	
	/**
	 * RepairOrderActSpList：RepairOrderActSpList
	*/
	@ApiModelProperty(required = false,value="RepairOrderActSpList" , notes = "RepairOrderActSpList")
	private List<RepairOrderActSp> RepairOrderActSpList;
	
	/**
	 * idsList：idsList
	*/
	@ApiModelProperty(required = false,value="idsList" , notes = "idsList")
	private List<String> idsList;
	
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
	 * status：status
	*/
	@ApiModelProperty(required = false,value="status" , notes = "status")
	private String status;
	
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
	public RepairOrderAct setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 申请单<br>
	 * 申请单
	 * @return 申请单
	*/
	public String getOrderId() {
		return orderId;
	}
	
	/**
	 * 设置 申请单
	 * @param orderId 申请单
	 * @return 当前对象
	*/
	public RepairOrderAct setOrderId(String orderId) {
		this.orderId=orderId;
		return this;
	}
	
	/**
	 * 获得 订单编号<br>
	 * 订单编号
	 * @return 订单编号
	*/
	public String getOrderBusinessCode() {
		return orderBusinessCode;
	}
	
	/**
	 * 设置 订单编号
	 * @param orderBusinessCode 订单编号
	 * @return 当前对象
	*/
	public RepairOrderAct setOrderBusinessCode(String orderBusinessCode) {
		this.orderBusinessCode=orderBusinessCode;
		return this;
	}
	
	/**
	 * 获得 订单名称<br>
	 * 订单名称
	 * @return 订单名称
	*/
	public String getOrderName() {
		return orderName;
	}
	
	/**
	 * 设置 订单名称
	 * @param orderName 订单名称
	 * @return 当前对象
	*/
	public RepairOrderAct setOrderName(String orderName) {
		this.orderName=orderName;
		return this;
	}
	
	/**
	 * 获得 维修编号<br>
	 * 维修编号
	 * @return 维修编号
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 维修编号
	 * @param businessCode 维修编号
	 * @return 当前对象
	*/
	public RepairOrderAct setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
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
	public RepairOrderAct setGroupId(String groupId) {
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
	public RepairOrderAct setExecutorId(String executorId) {
		this.executorId=executorId;
		return this;
	}
	
	/**
	 * 获得 维修费用<br>
	 * 维修费用
	 * @return 维修费用
	*/
	public BigDecimal getRepairCost() {
		return repairCost;
	}
	
	/**
	 * 设置 维修费用
	 * @param repairCost 维修费用
	 * @return 当前对象
	*/
	public RepairOrderAct setRepairCost(BigDecimal repairCost) {
		this.repairCost=repairCost;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getStartTime() {
		return startTime;
	}
	
	/**
	 * 设置 开始时间
	 * @param startTime 开始时间
	 * @return 当前对象
	*/
	public RepairOrderAct setStartTime(Date startTime) {
		this.startTime=startTime;
		return this;
	}
	
	/**
	 * 获得 完成时间<br>
	 * 完成时间
	 * @return 完成时间
	*/
	public Date getFinishTime() {
		return finishTime;
	}
	
	/**
	 * 设置 完成时间
	 * @param finishTime 完成时间
	 * @return 当前对象
	*/
	public RepairOrderAct setFinishTime(Date finishTime) {
		this.finishTime=finishTime;
		return this;
	}
	
	/**
	 * 获得 维修备注<br>
	 * 维修备注
	 * @return 维修备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 维修备注
	 * @param notes 维修备注
	 * @return 当前对象
	*/
	public RepairOrderAct setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 图片<br>
	 * 图片
	 * @return 图片
	*/
	public String getPictureId() {
		return pictureId;
	}
	
	/**
	 * 设置 图片
	 * @param pictureId 图片
	 * @return 当前对象
	*/
	public RepairOrderAct setPictureId(String pictureId) {
		this.pictureId=pictureId;
		return this;
	}
	
	/**
	 * 获得 制单人员<br>
	 * 制单人员
	 * @return 制单人员
	*/
	public String getOriginatorId() {
		return originatorId;
	}
	
	/**
	 * 设置 制单人员
	 * @param originatorId 制单人员
	 * @return 当前对象
	*/
	public RepairOrderAct setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
		return this;
	}
	
	/**
	 * 获得 跟随验证<br>
	 * 跟随验证
	 * @return 跟随验证
	*/
	public String getWithAcceptance() {
		return withAcceptance;
	}
	
	/**
	 * 设置 跟随验证
	 * @param withAcceptance 跟随验证
	 * @return 当前对象
	*/
	public RepairOrderAct setWithAcceptance(String withAcceptance) {
		this.withAcceptance=withAcceptance;
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
	public RepairOrderAct setCreateBy(String createBy) {
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
	public RepairOrderAct setCreateTime(Date createTime) {
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
	public RepairOrderAct setUpdateBy(String updateBy) {
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
	public RepairOrderAct setUpdateTime(Date updateTime) {
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
	public RepairOrderAct setDeleted(Integer deleted) {
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
	public RepairOrderAct setDeleted(Boolean deletedBool) {
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
	public RepairOrderAct setDeleteBy(String deleteBy) {
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
	public RepairOrderAct setDeleteTime(Date deleteTime) {
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
	public RepairOrderAct setVersion(Integer version) {
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
	public RepairOrderAct setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 选择数据<br>
	 * 选择数据
	 * @return 选择数据
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择数据
	 * @param selectedCode 选择数据
	 * @return 当前对象
	*/
	public RepairOrderAct setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 repairOrderProcess<br>
	 * repairOrderProcess
	 * @return repairOrderProcess
	*/
	public List<RepairOrderProcess> getRepairOrderProcess() {
		return repairOrderProcess;
	}
	
	/**
	 * 设置 repairOrderProcess
	 * @param repairOrderProcess repairOrderProcess
	 * @return 当前对象
	*/
	public RepairOrderAct setRepairOrderProcess(List<RepairOrderProcess> repairOrderProcess) {
		this.repairOrderProcess=repairOrderProcess;
		return this;
	}
	
	/**
	 * 添加 repairOrderProcess
	 * @param repairOrderProce repairOrderProcess
	 * @return 当前对象
	*/
	public RepairOrderAct addRepairOrderProce(RepairOrderProcess... repairOrderProce) {
		if(this.repairOrderProcess==null) repairOrderProcess=new ArrayList<>();
		this.repairOrderProcess.addAll(Arrays.asList(repairOrderProce));
		return this;
	}
	
	/**
	 * 获得 RepairOrderActSpList<br>
	 * RepairOrderActSpList
	 * @return RepairOrderActSpList
	*/
	public List<RepairOrderActSp> getRepairOrderActSpList() {
		return RepairOrderActSpList;
	}
	
	/**
	 * 设置 RepairOrderActSpList
	 * @param RepairOrderActSpList RepairOrderActSpList
	 * @return 当前对象
	*/
	public RepairOrderAct setRepairOrderActSpList(List<RepairOrderActSp> RepairOrderActSpList) {
		this.RepairOrderActSpList=RepairOrderActSpList;
		return this;
	}
	
	/**
	 * 添加 RepairOrderActSpList
	 * @param RepairOrderActSp RepairOrderActSpList
	 * @return 当前对象
	*/
	public RepairOrderAct addRepairOrderActSp(RepairOrderActSp... RepairOrderActSp) {
		if(this.RepairOrderActSpList==null) RepairOrderActSpList=new ArrayList<>();
		this.RepairOrderActSpList.addAll(Arrays.asList(RepairOrderActSp));
		return this;
	}
	
	/**
	 * 获得 idsList<br>
	 * idsList
	 * @return idsList
	*/
	public List<String> getIdsList() {
		return idsList;
	}
	
	/**
	 * 设置 idsList
	 * @param idsList idsList
	 * @return 当前对象
	*/
	public RepairOrderAct setIdsList(List<String> idsList) {
		this.idsList=idsList;
		return this;
	}
	
	/**
	 * 添加 idsList
	 * @param ids idsList
	 * @return 当前对象
	*/
	public RepairOrderAct addIds(String... ids) {
		if(this.idsList==null) idsList=new ArrayList<>();
		this.idsList.addAll(Arrays.asList(ids));
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
	public RepairOrderAct setOrder(RepairOrder order) {
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
	public RepairOrderAct setOriginator(Employee originator) {
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
	public RepairOrderAct setExecutor(Employee executor) {
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
	public RepairOrderAct setRepairGroup(RepairGroup repairGroup) {
		this.repairGroup=repairGroup;
		return this;
	}
	
	/**
	 * 获得 status<br>
	 * status
	 * @return status
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 status
	 * @param status status
	 * @return 当前对象
	*/
	public RepairOrderAct setStatus(String status) {
		this.status=status;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return RepairOrderAct , 转换好的 RepairOrderAct 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RepairOrderAct , 转换好的 PoJo 对象
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
	public RepairOrderAct clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public RepairOrderAct duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.RepairOrderActMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.RepairOrderActMeta.$$proxy$$();
		inst.setFinishTime(this.getFinishTime());
		inst.setNotes(this.getNotes());
		inst.setOrderId(this.getOrderId());
		inst.setExecutorId(this.getExecutorId());
		inst.setGroupId(this.getGroupId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setOrderBusinessCode(this.getOrderBusinessCode());
		inst.setWithAcceptance(this.getWithAcceptance());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPictureId(this.getPictureId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStartTime(this.getStartTime());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setRepairCost(this.getRepairCost());
		inst.setOrderName(this.getOrderName());
		if(all) {
			inst.setRepairOrderActSpList(this.getRepairOrderActSpList());
			inst.setExecutor(this.getExecutor());
			inst.setRepairGroup(this.getRepairGroup());
			inst.setRepairOrderProcess(this.getRepairOrderProcess());
			inst.setOriginator(this.getOriginator());
			inst.setIdsList(this.getIdsList());
			inst.setOrder(this.getOrder());
			inst.setStatus(this.getStatus());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public RepairOrderAct clone(boolean deep) {
		return EntityContext.clone(RepairOrderAct.class,this,deep);
	}

	/**
	 * 将 Map 转换成 RepairOrderAct
	 * @param repairOrderActMap 包含实体信息的 Map 对象
	 * @return RepairOrderAct , 转换好的的 RepairOrderAct 对象
	*/
	@Transient
	public static RepairOrderAct createFrom(Map<String,Object> repairOrderActMap) {
		if(repairOrderActMap==null) return null;
		RepairOrderAct po = create();
		EntityContext.copyProperties(po,repairOrderActMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 RepairOrderAct
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RepairOrderAct , 转换好的的 RepairOrderAct 对象
	*/
	@Transient
	public static RepairOrderAct createFrom(Object pojo) {
		if(pojo==null) return null;
		RepairOrderAct po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 RepairOrderAct，等同于 new
	 * @return RepairOrderAct 对象
	*/
	@Transient
	public static RepairOrderAct create() {
		return new com.dt.platform.domain.eam.meta.RepairOrderActMeta.$$proxy$$();
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
			this.setFinishTime(DataParser.parse(Date.class, map.get(RepairOrderActMeta.FINISH_TIME)));
			this.setNotes(DataParser.parse(String.class, map.get(RepairOrderActMeta.NOTES)));
			this.setOrderId(DataParser.parse(String.class, map.get(RepairOrderActMeta.ORDER_ID)));
			this.setExecutorId(DataParser.parse(String.class, map.get(RepairOrderActMeta.EXECUTOR_ID)));
			this.setGroupId(DataParser.parse(String.class, map.get(RepairOrderActMeta.GROUP_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(RepairOrderActMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(RepairOrderActMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(RepairOrderActMeta.SELECTED_CODE)));
			this.setOrderBusinessCode(DataParser.parse(String.class, map.get(RepairOrderActMeta.ORDER_BUSINESS_CODE)));
			this.setWithAcceptance(DataParser.parse(String.class, map.get(RepairOrderActMeta.WITH_ACCEPTANCE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(RepairOrderActMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(RepairOrderActMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(RepairOrderActMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, map.get(RepairOrderActMeta.PICTURE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(RepairOrderActMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(RepairOrderActMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(RepairOrderActMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(RepairOrderActMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(RepairOrderActMeta.DELETE_BY)));
			this.setStartTime(DataParser.parse(Date.class, map.get(RepairOrderActMeta.START_TIME)));
			this.setId(DataParser.parse(String.class, map.get(RepairOrderActMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(RepairOrderActMeta.ORIGINATOR_ID)));
			this.setRepairCost(DataParser.parse(BigDecimal.class, map.get(RepairOrderActMeta.REPAIR_COST)));
			this.setOrderName(DataParser.parse(String.class, map.get(RepairOrderActMeta.ORDER_NAME)));
			// others
			this.setExecutor(DataParser.parse(Employee.class, map.get(RepairOrderActMeta.EXECUTOR)));
			this.setRepairGroup(DataParser.parse(RepairGroup.class, map.get(RepairOrderActMeta.REPAIR_GROUP)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(RepairOrderActMeta.ORIGINATOR)));
			this.setOrder(DataParser.parse(RepairOrder.class, map.get(RepairOrderActMeta.ORDER)));
			this.setStatus(DataParser.parse(String.class, map.get(RepairOrderActMeta.STATUS)));
			return true;
		} else {
			try {
				this.setFinishTime( (Date)map.get(RepairOrderActMeta.FINISH_TIME));
				this.setNotes( (String)map.get(RepairOrderActMeta.NOTES));
				this.setOrderId( (String)map.get(RepairOrderActMeta.ORDER_ID));
				this.setExecutorId( (String)map.get(RepairOrderActMeta.EXECUTOR_ID));
				this.setGroupId( (String)map.get(RepairOrderActMeta.GROUP_ID));
				this.setUpdateTime( (Date)map.get(RepairOrderActMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(RepairOrderActMeta.VERSION));
				this.setSelectedCode( (String)map.get(RepairOrderActMeta.SELECTED_CODE));
				this.setOrderBusinessCode( (String)map.get(RepairOrderActMeta.ORDER_BUSINESS_CODE));
				this.setWithAcceptance( (String)map.get(RepairOrderActMeta.WITH_ACCEPTANCE));
				this.setBusinessCode( (String)map.get(RepairOrderActMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(RepairOrderActMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(RepairOrderActMeta.DELETED));
				this.setPictureId( (String)map.get(RepairOrderActMeta.PICTURE_ID));
				this.setCreateTime( (Date)map.get(RepairOrderActMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(RepairOrderActMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(RepairOrderActMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(RepairOrderActMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(RepairOrderActMeta.DELETE_BY));
				this.setStartTime( (Date)map.get(RepairOrderActMeta.START_TIME));
				this.setId( (String)map.get(RepairOrderActMeta.ID));
				this.setOriginatorId( (String)map.get(RepairOrderActMeta.ORIGINATOR_ID));
				this.setRepairCost( (BigDecimal)map.get(RepairOrderActMeta.REPAIR_COST));
				this.setOrderName( (String)map.get(RepairOrderActMeta.ORDER_NAME));
				// others
				this.setExecutor( (Employee)map.get(RepairOrderActMeta.EXECUTOR));
				this.setRepairGroup( (RepairGroup)map.get(RepairOrderActMeta.REPAIR_GROUP));
				this.setOriginator( (Employee)map.get(RepairOrderActMeta.ORIGINATOR));
				this.setOrder( (RepairOrder)map.get(RepairOrderActMeta.ORDER));
				this.setStatus( (String)map.get(RepairOrderActMeta.STATUS));
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
			this.setFinishTime(DataParser.parse(Date.class, r.getValue(RepairOrderActMeta.FINISH_TIME)));
			this.setNotes(DataParser.parse(String.class, r.getValue(RepairOrderActMeta.NOTES)));
			this.setOrderId(DataParser.parse(String.class, r.getValue(RepairOrderActMeta.ORDER_ID)));
			this.setExecutorId(DataParser.parse(String.class, r.getValue(RepairOrderActMeta.EXECUTOR_ID)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(RepairOrderActMeta.GROUP_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(RepairOrderActMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(RepairOrderActMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(RepairOrderActMeta.SELECTED_CODE)));
			this.setOrderBusinessCode(DataParser.parse(String.class, r.getValue(RepairOrderActMeta.ORDER_BUSINESS_CODE)));
			this.setWithAcceptance(DataParser.parse(String.class, r.getValue(RepairOrderActMeta.WITH_ACCEPTANCE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(RepairOrderActMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(RepairOrderActMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(RepairOrderActMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(RepairOrderActMeta.PICTURE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(RepairOrderActMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(RepairOrderActMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(RepairOrderActMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(RepairOrderActMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(RepairOrderActMeta.DELETE_BY)));
			this.setStartTime(DataParser.parse(Date.class, r.getValue(RepairOrderActMeta.START_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(RepairOrderActMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(RepairOrderActMeta.ORIGINATOR_ID)));
			this.setRepairCost(DataParser.parse(BigDecimal.class, r.getValue(RepairOrderActMeta.REPAIR_COST)));
			this.setOrderName(DataParser.parse(String.class, r.getValue(RepairOrderActMeta.ORDER_NAME)));
			return true;
		} else {
			try {
				this.setFinishTime( (Date)r.getValue(RepairOrderActMeta.FINISH_TIME));
				this.setNotes( (String)r.getValue(RepairOrderActMeta.NOTES));
				this.setOrderId( (String)r.getValue(RepairOrderActMeta.ORDER_ID));
				this.setExecutorId( (String)r.getValue(RepairOrderActMeta.EXECUTOR_ID));
				this.setGroupId( (String)r.getValue(RepairOrderActMeta.GROUP_ID));
				this.setUpdateTime( (Date)r.getValue(RepairOrderActMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(RepairOrderActMeta.VERSION));
				this.setSelectedCode( (String)r.getValue(RepairOrderActMeta.SELECTED_CODE));
				this.setOrderBusinessCode( (String)r.getValue(RepairOrderActMeta.ORDER_BUSINESS_CODE));
				this.setWithAcceptance( (String)r.getValue(RepairOrderActMeta.WITH_ACCEPTANCE));
				this.setBusinessCode( (String)r.getValue(RepairOrderActMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(RepairOrderActMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(RepairOrderActMeta.DELETED));
				this.setPictureId( (String)r.getValue(RepairOrderActMeta.PICTURE_ID));
				this.setCreateTime( (Date)r.getValue(RepairOrderActMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(RepairOrderActMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(RepairOrderActMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(RepairOrderActMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(RepairOrderActMeta.DELETE_BY));
				this.setStartTime( (Date)r.getValue(RepairOrderActMeta.START_TIME));
				this.setId( (String)r.getValue(RepairOrderActMeta.ID));
				this.setOriginatorId( (String)r.getValue(RepairOrderActMeta.ORIGINATOR_ID));
				this.setRepairCost( (BigDecimal)r.getValue(RepairOrderActMeta.REPAIR_COST));
				this.setOrderName( (String)r.getValue(RepairOrderActMeta.ORDER_NAME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}