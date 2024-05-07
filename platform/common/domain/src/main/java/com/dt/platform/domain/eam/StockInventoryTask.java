package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_STOCK_INVENTORY_TASK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.pcm.Catalog;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.StockInventoryTaskMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 盘点任务2
 * <p>盘点任务2 , 数据表 eam_stock_inventory_task 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-06 16:10:12
 * @sign 63A8ECF92A3E3F3CE8CD272FA521493F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_stock_inventory_task")
@ApiModel(description = "盘点任务2 ; 盘点任务2 , 数据表 eam_stock_inventory_task 的PO类型")
public class StockInventoryTask extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_STOCK_INVENTORY_TASK.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "839057059126181888")
	private String id;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private String type;
	
	/**
	 * 业务编码：业务编码
	*/
	@ApiModelProperty(required = false,value="业务编码" , notes = "业务编码" , example = "12")
	private String businessCode;
	
	/**
	 * 业务状态：业务状态
	*/
	@ApiModelProperty(required = false,value="业务状态" , notes = "业务状态")
	private String status;
	
	/**
	 * 盘点名称：盘点名称
	*/
	@ApiModelProperty(required = false,value="盘点名称" , notes = "盘点名称" , example = "12")
	private String name;
	
	/**
	 * 盘点状态：盘点状态
	*/
	@ApiModelProperty(required = false,value="盘点状态" , notes = "盘点状态")
	private String inventoryStatus;
	
	/**
	 * 数据状态：数据状态
	*/
	@ApiModelProperty(required = false,value="数据状态" , notes = "数据状态")
	private String dataStatus;
	
	/**
	 * 盘点开始时间：盘点开始时间
	*/
	@ApiModelProperty(required = false,value="盘点开始时间" , notes = "盘点开始时间")
	private Date startTime;
	
	/**
	 * 盘点结束时间：盘点结束时间
	*/
	@ApiModelProperty(required = false,value="盘点结束时间" , notes = "盘点结束时间")
	private Date finishTime;
	
	/**
	 * 负责人：负责人
	*/
	@ApiModelProperty(required = false,value="负责人" , notes = "负责人" , example = "617107757929070592")
	private String directorId;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
	/**
	 * 业务日期：业务日期
	*/
	@ApiModelProperty(required = false,value="业务日期" , notes = "业务日期")
	private Date businessDate;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "121212")
	private String notes;
	
	/**
	 * 计划编号：计划编号
	*/
	@ApiModelProperty(required = false,value="计划编号" , notes = "计划编号")
	private String planId;
	
	/**
	 * 所属：所属
	*/
	@ApiModelProperty(required = false,value="所属" , notes = "所属" , example = "task")
	private String ownerCode;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-05-04 08:33:12")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-05-04 09:23:31")
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "7")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 盘点资产数据：盘点资产数据
	*/
	@ApiModelProperty(required = false,value="盘点资产数据" , notes = "盘点资产数据")
	private List<StockInventoryAsset> inventoryAssetInfoList;
	
	/**
	 * 待盘点：待盘点
	*/
	@ApiModelProperty(required = false,value="待盘点" , notes = "待盘点")
	private Integer inventoryAssetCountByNotCounted;
	
	/**
	 * 已盘点：已盘点
	*/
	@ApiModelProperty(required = false,value="已盘点" , notes = "已盘点")
	private Integer inventoryAssetCountByCounted;
	
	/**
	 * 盘亏：盘亏
	*/
	@ApiModelProperty(required = false,value="盘亏" , notes = "盘亏")
	private Integer inventoryAssetCountByLoss;
	
	/**
	 * 盘盈：盘盈
	*/
	@ApiModelProperty(required = false,value="盘盈" , notes = "盘盈")
	private Integer inventoryAssetCountBySurplus;
	
	/**
	 * 异常：异常
	*/
	@ApiModelProperty(required = false,value="异常" , notes = "异常")
	private Integer inventoryAssetCountByException;
	
	/**
	 * 盘点人员：盘点人员
	*/
	@ApiModelProperty(required = false,value="盘点人员" , notes = "盘点人员")
	private List<Employee> inventoryUserList;
	
	/**
	 * 盘点人员列表：盘点人员列表
	*/
	@ApiModelProperty(required = false,value="盘点人员列表" , notes = "盘点人员列表")
	private List<String> inventoryUserIds;
	
	/**
	 * director：director
	*/
	@ApiModelProperty(required = false,value="director" , notes = "director")
	private Employee director;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private List<Warehouse> warehouseList;
	
	/**
	 * 仓库Ids：仓库Ids
	*/
	@ApiModelProperty(required = false,value="仓库Ids" , notes = "仓库Ids")
	private List<String> warehouseIds;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private List<Catalog> categoryList;
	
	/**
	 * 资产分类Ids：资产分类Ids
	*/
	@ApiModelProperty(required = false,value="资产分类Ids" , notes = "资产分类Ids")
	private List<String> categoryIds;
	
	/**
	 * searchQuerySource：searchQuerySource
	*/
	@ApiModelProperty(required = false,value="searchQuerySource" , notes = "searchQuerySource")
	private String searchQuerySource;
	
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
	public StockInventoryTask setId(String id) {
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
	public StockInventoryTask setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 业务编码<br>
	 * 业务编码
	 * @return 业务编码
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 业务编码
	 * @param businessCode 业务编码
	 * @return 当前对象
	*/
	public StockInventoryTask setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 业务状态<br>
	 * 业务状态
	 * @return 业务状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 业务状态
	 * @param status 业务状态
	 * @return 当前对象
	*/
	public StockInventoryTask setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 盘点名称<br>
	 * 盘点名称
	 * @return 盘点名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 盘点名称
	 * @param name 盘点名称
	 * @return 当前对象
	*/
	public StockInventoryTask setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 盘点状态<br>
	 * 盘点状态
	 * @return 盘点状态
	*/
	public String getInventoryStatus() {
		return inventoryStatus;
	}
	
	/**
	 * 设置 盘点状态
	 * @param inventoryStatus 盘点状态
	 * @return 当前对象
	*/
	public StockInventoryTask setInventoryStatus(String inventoryStatus) {
		this.inventoryStatus=inventoryStatus;
		return this;
	}
	
	/**
	 * 获得 数据状态<br>
	 * 数据状态
	 * @return 数据状态
	*/
	public String getDataStatus() {
		return dataStatus;
	}
	
	/**
	 * 设置 数据状态
	 * @param dataStatus 数据状态
	 * @return 当前对象
	*/
	public StockInventoryTask setDataStatus(String dataStatus) {
		this.dataStatus=dataStatus;
		return this;
	}
	
	/**
	 * 获得 盘点开始时间<br>
	 * 盘点开始时间
	 * @return 盘点开始时间
	*/
	public Date getStartTime() {
		return startTime;
	}
	
	/**
	 * 设置 盘点开始时间
	 * @param startTime 盘点开始时间
	 * @return 当前对象
	*/
	public StockInventoryTask setStartTime(Date startTime) {
		this.startTime=startTime;
		return this;
	}
	
	/**
	 * 获得 盘点结束时间<br>
	 * 盘点结束时间
	 * @return 盘点结束时间
	*/
	public Date getFinishTime() {
		return finishTime;
	}
	
	/**
	 * 设置 盘点结束时间
	 * @param finishTime 盘点结束时间
	 * @return 当前对象
	*/
	public StockInventoryTask setFinishTime(Date finishTime) {
		this.finishTime=finishTime;
		return this;
	}
	
	/**
	 * 获得 负责人<br>
	 * 负责人
	 * @return 负责人
	*/
	public String getDirectorId() {
		return directorId;
	}
	
	/**
	 * 设置 负责人
	 * @param directorId 负责人
	 * @return 当前对象
	*/
	public StockInventoryTask setDirectorId(String directorId) {
		this.directorId=directorId;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public String getOriginatorId() {
		return originatorId;
	}
	
	/**
	 * 设置 制单人
	 * @param originatorId 制单人
	 * @return 当前对象
	*/
	public StockInventoryTask setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
		return this;
	}
	
	/**
	 * 获得 业务日期<br>
	 * 业务日期
	 * @return 业务日期
	*/
	public Date getBusinessDate() {
		return businessDate;
	}
	
	/**
	 * 设置 业务日期
	 * @param businessDate 业务日期
	 * @return 当前对象
	*/
	public StockInventoryTask setBusinessDate(Date businessDate) {
		this.businessDate=businessDate;
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
	public StockInventoryTask setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 计划编号<br>
	 * 计划编号
	 * @return 计划编号
	*/
	public String getPlanId() {
		return planId;
	}
	
	/**
	 * 设置 计划编号
	 * @param planId 计划编号
	 * @return 当前对象
	*/
	public StockInventoryTask setPlanId(String planId) {
		this.planId=planId;
		return this;
	}
	
	/**
	 * 获得 所属<br>
	 * 所属
	 * @return 所属
	*/
	public String getOwnerCode() {
		return ownerCode;
	}
	
	/**
	 * 设置 所属
	 * @param ownerCode 所属
	 * @return 当前对象
	*/
	public StockInventoryTask setOwnerCode(String ownerCode) {
		this.ownerCode=ownerCode;
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
	public StockInventoryTask setCreateBy(String createBy) {
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
	public StockInventoryTask setCreateTime(Date createTime) {
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
	public StockInventoryTask setUpdateBy(String updateBy) {
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
	public StockInventoryTask setUpdateTime(Date updateTime) {
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
	public StockInventoryTask setDeleted(Integer deleted) {
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
	public StockInventoryTask setDeleted(Boolean deletedBool) {
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
	public StockInventoryTask setDeleteBy(String deleteBy) {
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
	public StockInventoryTask setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public StockInventoryTask setVersion(Integer version) {
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
	public StockInventoryTask setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 盘点资产数据<br>
	 * 盘点资产数据
	 * @return 盘点资产数据
	*/
	public List<StockInventoryAsset> getInventoryAssetInfoList() {
		return inventoryAssetInfoList;
	}
	
	/**
	 * 设置 盘点资产数据
	 * @param inventoryAssetInfoList 盘点资产数据
	 * @return 当前对象
	*/
	public StockInventoryTask setInventoryAssetInfoList(List<StockInventoryAsset> inventoryAssetInfoList) {
		this.inventoryAssetInfoList=inventoryAssetInfoList;
		return this;
	}
	
	/**
	 * 添加 盘点资产数据
	 * @param inventoryAssetInfo 盘点资产数据
	 * @return 当前对象
	*/
	public StockInventoryTask addInventoryAssetInfo(StockInventoryAsset... inventoryAssetInfo) {
		if(this.inventoryAssetInfoList==null) inventoryAssetInfoList=new ArrayList<>();
		this.inventoryAssetInfoList.addAll(Arrays.asList(inventoryAssetInfo));
		return this;
	}
	
	/**
	 * 获得 待盘点<br>
	 * 待盘点
	 * @return 待盘点
	*/
	public Integer getInventoryAssetCountByNotCounted() {
		return inventoryAssetCountByNotCounted;
	}
	
	/**
	 * 设置 待盘点
	 * @param inventoryAssetCountByNotCounted 待盘点
	 * @return 当前对象
	*/
	public StockInventoryTask setInventoryAssetCountByNotCounted(Integer inventoryAssetCountByNotCounted) {
		this.inventoryAssetCountByNotCounted=inventoryAssetCountByNotCounted;
		return this;
	}
	
	/**
	 * 获得 已盘点<br>
	 * 已盘点
	 * @return 已盘点
	*/
	public Integer getInventoryAssetCountByCounted() {
		return inventoryAssetCountByCounted;
	}
	
	/**
	 * 设置 已盘点
	 * @param inventoryAssetCountByCounted 已盘点
	 * @return 当前对象
	*/
	public StockInventoryTask setInventoryAssetCountByCounted(Integer inventoryAssetCountByCounted) {
		this.inventoryAssetCountByCounted=inventoryAssetCountByCounted;
		return this;
	}
	
	/**
	 * 获得 盘亏<br>
	 * 盘亏
	 * @return 盘亏
	*/
	public Integer getInventoryAssetCountByLoss() {
		return inventoryAssetCountByLoss;
	}
	
	/**
	 * 设置 盘亏
	 * @param inventoryAssetCountByLoss 盘亏
	 * @return 当前对象
	*/
	public StockInventoryTask setInventoryAssetCountByLoss(Integer inventoryAssetCountByLoss) {
		this.inventoryAssetCountByLoss=inventoryAssetCountByLoss;
		return this;
	}
	
	/**
	 * 获得 盘盈<br>
	 * 盘盈
	 * @return 盘盈
	*/
	public Integer getInventoryAssetCountBySurplus() {
		return inventoryAssetCountBySurplus;
	}
	
	/**
	 * 设置 盘盈
	 * @param inventoryAssetCountBySurplus 盘盈
	 * @return 当前对象
	*/
	public StockInventoryTask setInventoryAssetCountBySurplus(Integer inventoryAssetCountBySurplus) {
		this.inventoryAssetCountBySurplus=inventoryAssetCountBySurplus;
		return this;
	}
	
	/**
	 * 获得 异常<br>
	 * 异常
	 * @return 异常
	*/
	public Integer getInventoryAssetCountByException() {
		return inventoryAssetCountByException;
	}
	
	/**
	 * 设置 异常
	 * @param inventoryAssetCountByException 异常
	 * @return 当前对象
	*/
	public StockInventoryTask setInventoryAssetCountByException(Integer inventoryAssetCountByException) {
		this.inventoryAssetCountByException=inventoryAssetCountByException;
		return this;
	}
	
	/**
	 * 获得 盘点人员<br>
	 * 盘点人员
	 * @return 盘点人员
	*/
	public List<Employee> getInventoryUserList() {
		return inventoryUserList;
	}
	
	/**
	 * 设置 盘点人员
	 * @param inventoryUserList 盘点人员
	 * @return 当前对象
	*/
	public StockInventoryTask setInventoryUserList(List<Employee> inventoryUserList) {
		this.inventoryUserList=inventoryUserList;
		return this;
	}
	
	/**
	 * 添加 盘点人员
	 * @param inventoryUser 盘点人员
	 * @return 当前对象
	*/
	public StockInventoryTask addInventoryUser(Employee... inventoryUser) {
		if(this.inventoryUserList==null) inventoryUserList=new ArrayList<>();
		this.inventoryUserList.addAll(Arrays.asList(inventoryUser));
		return this;
	}
	
	/**
	 * 获得 盘点人员列表<br>
	 * 盘点人员列表
	 * @return 盘点人员列表
	*/
	public List<String> getInventoryUserIds() {
		return inventoryUserIds;
	}
	
	/**
	 * 设置 盘点人员列表
	 * @param inventoryUserIds 盘点人员列表
	 * @return 当前对象
	*/
	public StockInventoryTask setInventoryUserIds(List<String> inventoryUserIds) {
		this.inventoryUserIds=inventoryUserIds;
		return this;
	}
	
	/**
	 * 添加 盘点人员列表
	 * @param inventoryUserId 盘点人员列表
	 * @return 当前对象
	*/
	public StockInventoryTask addInventoryUserId(String... inventoryUserId) {
		if(this.inventoryUserIds==null) inventoryUserIds=new ArrayList<>();
		this.inventoryUserIds.addAll(Arrays.asList(inventoryUserId));
		return this;
	}
	
	/**
	 * 获得 director<br>
	 * director
	 * @return director
	*/
	public Employee getDirector() {
		return director;
	}
	
	/**
	 * 设置 director
	 * @param director director
	 * @return 当前对象
	*/
	public StockInventoryTask setDirector(Employee director) {
		this.director=director;
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
	public StockInventoryTask setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 仓库<br>
	 * 仓库
	 * @return 仓库
	*/
	public List<Warehouse> getWarehouseList() {
		return warehouseList;
	}
	
	/**
	 * 设置 仓库
	 * @param warehouseList 仓库
	 * @return 当前对象
	*/
	public StockInventoryTask setWarehouseList(List<Warehouse> warehouseList) {
		this.warehouseList=warehouseList;
		return this;
	}
	
	/**
	 * 添加 仓库
	 * @param warehouse 仓库
	 * @return 当前对象
	*/
	public StockInventoryTask addWarehouse(Warehouse... warehouse) {
		if(this.warehouseList==null) warehouseList=new ArrayList<>();
		this.warehouseList.addAll(Arrays.asList(warehouse));
		return this;
	}
	
	/**
	 * 获得 仓库Ids<br>
	 * 仓库Ids
	 * @return 仓库Ids
	*/
	public List<String> getWarehouseIds() {
		return warehouseIds;
	}
	
	/**
	 * 设置 仓库Ids
	 * @param warehouseIds 仓库Ids
	 * @return 当前对象
	*/
	public StockInventoryTask setWarehouseIds(List<String> warehouseIds) {
		this.warehouseIds=warehouseIds;
		return this;
	}
	
	/**
	 * 添加 仓库Ids
	 * @param warehouseId 仓库Ids
	 * @return 当前对象
	*/
	public StockInventoryTask addWarehouseId(String... warehouseId) {
		if(this.warehouseIds==null) warehouseIds=new ArrayList<>();
		this.warehouseIds.addAll(Arrays.asList(warehouseId));
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public List<Catalog> getCategoryList() {
		return categoryList;
	}
	
	/**
	 * 设置 资产分类
	 * @param categoryList 资产分类
	 * @return 当前对象
	*/
	public StockInventoryTask setCategoryList(List<Catalog> categoryList) {
		this.categoryList=categoryList;
		return this;
	}
	
	/**
	 * 添加 资产分类
	 * @param category 资产分类
	 * @return 当前对象
	*/
	public StockInventoryTask addCategory(Catalog... category) {
		if(this.categoryList==null) categoryList=new ArrayList<>();
		this.categoryList.addAll(Arrays.asList(category));
		return this;
	}
	
	/**
	 * 获得 资产分类Ids<br>
	 * 资产分类Ids
	 * @return 资产分类Ids
	*/
	public List<String> getCategoryIds() {
		return categoryIds;
	}
	
	/**
	 * 设置 资产分类Ids
	 * @param categoryIds 资产分类Ids
	 * @return 当前对象
	*/
	public StockInventoryTask setCategoryIds(List<String> categoryIds) {
		this.categoryIds=categoryIds;
		return this;
	}
	
	/**
	 * 添加 资产分类Ids
	 * @param categoryId 资产分类Ids
	 * @return 当前对象
	*/
	public StockInventoryTask addCategoryId(String... categoryId) {
		if(this.categoryIds==null) categoryIds=new ArrayList<>();
		this.categoryIds.addAll(Arrays.asList(categoryId));
		return this;
	}
	
	/**
	 * 获得 searchQuerySource<br>
	 * searchQuerySource
	 * @return searchQuerySource
	*/
	public String getSearchQuerySource() {
		return searchQuerySource;
	}
	
	/**
	 * 设置 searchQuerySource
	 * @param searchQuerySource searchQuerySource
	 * @return 当前对象
	*/
	public StockInventoryTask setSearchQuerySource(String searchQuerySource) {
		this.searchQuerySource=searchQuerySource;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return StockInventoryTask , 转换好的 StockInventoryTask 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return StockInventoryTask , 转换好的 PoJo 对象
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
	public StockInventoryTask clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public StockInventoryTask duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.StockInventoryTaskMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.StockInventoryTaskMeta.$$proxy$$();
		inst.setFinishTime(this.getFinishTime());
		inst.setNotes(this.getNotes());
		inst.setDirectorId(this.getDirectorId());
		inst.setOwnerCode(this.getOwnerCode());
		inst.setInventoryStatus(this.getInventoryStatus());
		inst.setDataStatus(this.getDataStatus());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStartTime(this.getStartTime());
		inst.setPlanId(this.getPlanId());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setInventoryUserIds(this.getInventoryUserIds());
			inst.setWarehouseList(this.getWarehouseList());
			inst.setInventoryAssetCountByLoss(this.getInventoryAssetCountByLoss());
			inst.setDirector(this.getDirector());
			inst.setInventoryAssetCountByException(this.getInventoryAssetCountByException());
			inst.setSearchQuerySource(this.getSearchQuerySource());
			inst.setInventoryAssetCountByCounted(this.getInventoryAssetCountByCounted());
			inst.setOriginator(this.getOriginator());
			inst.setInventoryAssetInfoList(this.getInventoryAssetInfoList());
			inst.setInventoryAssetCountByNotCounted(this.getInventoryAssetCountByNotCounted());
			inst.setCategoryIds(this.getCategoryIds());
			inst.setInventoryAssetCountBySurplus(this.getInventoryAssetCountBySurplus());
			inst.setInventoryUserList(this.getInventoryUserList());
			inst.setCategoryList(this.getCategoryList());
			inst.setWarehouseIds(this.getWarehouseIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public StockInventoryTask clone(boolean deep) {
		return EntityContext.clone(StockInventoryTask.class,this,deep);
	}

	/**
	 * 将 Map 转换成 StockInventoryTask
	 * @param stockInventoryTaskMap 包含实体信息的 Map 对象
	 * @return StockInventoryTask , 转换好的的 StockInventoryTask 对象
	*/
	@Transient
	public static StockInventoryTask createFrom(Map<String,Object> stockInventoryTaskMap) {
		if(stockInventoryTaskMap==null) return null;
		StockInventoryTask po = create();
		EntityContext.copyProperties(po,stockInventoryTaskMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 StockInventoryTask
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return StockInventoryTask , 转换好的的 StockInventoryTask 对象
	*/
	@Transient
	public static StockInventoryTask createFrom(Object pojo) {
		if(pojo==null) return null;
		StockInventoryTask po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 StockInventoryTask，等同于 new
	 * @return StockInventoryTask 对象
	*/
	@Transient
	public static StockInventoryTask create() {
		return new com.dt.platform.domain.eam.meta.StockInventoryTaskMeta.$$proxy$$();
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
			this.setFinishTime(DataParser.parse(Date.class, map.get(StockInventoryTaskMeta.FINISH_TIME)));
			this.setNotes(DataParser.parse(String.class, map.get(StockInventoryTaskMeta.NOTES)));
			this.setDirectorId(DataParser.parse(String.class, map.get(StockInventoryTaskMeta.DIRECTOR_ID)));
			this.setOwnerCode(DataParser.parse(String.class, map.get(StockInventoryTaskMeta.OWNER_CODE)));
			this.setInventoryStatus(DataParser.parse(String.class, map.get(StockInventoryTaskMeta.INVENTORY_STATUS)));
			this.setDataStatus(DataParser.parse(String.class, map.get(StockInventoryTaskMeta.DATA_STATUS)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(StockInventoryTaskMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(StockInventoryTaskMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(StockInventoryTaskMeta.VERSION)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(StockInventoryTaskMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(StockInventoryTaskMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(StockInventoryTaskMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(StockInventoryTaskMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(StockInventoryTaskMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(StockInventoryTaskMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(StockInventoryTaskMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(StockInventoryTaskMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(StockInventoryTaskMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(StockInventoryTaskMeta.DELETE_BY)));
			this.setStartTime(DataParser.parse(Date.class, map.get(StockInventoryTaskMeta.START_TIME)));
			this.setPlanId(DataParser.parse(String.class, map.get(StockInventoryTaskMeta.PLAN_ID)));
			this.setId(DataParser.parse(String.class, map.get(StockInventoryTaskMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(StockInventoryTaskMeta.ORIGINATOR_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(StockInventoryTaskMeta.STATUS)));
			// others
			this.setInventoryAssetCountByLoss(DataParser.parse(Integer.class, map.get(StockInventoryTaskMeta.INVENTORY_ASSET_COUNT_BY_LOSS)));
			this.setDirector(DataParser.parse(Employee.class, map.get(StockInventoryTaskMeta.DIRECTOR)));
			this.setInventoryAssetCountByException(DataParser.parse(Integer.class, map.get(StockInventoryTaskMeta.INVENTORY_ASSET_COUNT_BY_EXCEPTION)));
			this.setSearchQuerySource(DataParser.parse(String.class, map.get(StockInventoryTaskMeta.SEARCH_QUERY_SOURCE)));
			this.setInventoryAssetCountByCounted(DataParser.parse(Integer.class, map.get(StockInventoryTaskMeta.INVENTORY_ASSET_COUNT_BY_COUNTED)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(StockInventoryTaskMeta.ORIGINATOR)));
			this.setInventoryAssetCountByNotCounted(DataParser.parse(Integer.class, map.get(StockInventoryTaskMeta.INVENTORY_ASSET_COUNT_BY_NOT_COUNTED)));
			this.setInventoryAssetCountBySurplus(DataParser.parse(Integer.class, map.get(StockInventoryTaskMeta.INVENTORY_ASSET_COUNT_BY_SURPLUS)));
			return true;
		} else {
			try {
				this.setFinishTime( (Date)map.get(StockInventoryTaskMeta.FINISH_TIME));
				this.setNotes( (String)map.get(StockInventoryTaskMeta.NOTES));
				this.setDirectorId( (String)map.get(StockInventoryTaskMeta.DIRECTOR_ID));
				this.setOwnerCode( (String)map.get(StockInventoryTaskMeta.OWNER_CODE));
				this.setInventoryStatus( (String)map.get(StockInventoryTaskMeta.INVENTORY_STATUS));
				this.setDataStatus( (String)map.get(StockInventoryTaskMeta.DATA_STATUS));
				this.setUpdateTime( (Date)map.get(StockInventoryTaskMeta.UPDATE_TIME));
				this.setType( (String)map.get(StockInventoryTaskMeta.TYPE));
				this.setVersion( (Integer)map.get(StockInventoryTaskMeta.VERSION));
				this.setBusinessDate( (Date)map.get(StockInventoryTaskMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(StockInventoryTaskMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(StockInventoryTaskMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(StockInventoryTaskMeta.DELETED));
				this.setCreateTime( (Date)map.get(StockInventoryTaskMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(StockInventoryTaskMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(StockInventoryTaskMeta.DELETE_TIME));
				this.setName( (String)map.get(StockInventoryTaskMeta.NAME));
				this.setTenantId( (String)map.get(StockInventoryTaskMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(StockInventoryTaskMeta.DELETE_BY));
				this.setStartTime( (Date)map.get(StockInventoryTaskMeta.START_TIME));
				this.setPlanId( (String)map.get(StockInventoryTaskMeta.PLAN_ID));
				this.setId( (String)map.get(StockInventoryTaskMeta.ID));
				this.setOriginatorId( (String)map.get(StockInventoryTaskMeta.ORIGINATOR_ID));
				this.setStatus( (String)map.get(StockInventoryTaskMeta.STATUS));
				// others
				this.setInventoryAssetCountByLoss( (Integer)map.get(StockInventoryTaskMeta.INVENTORY_ASSET_COUNT_BY_LOSS));
				this.setDirector( (Employee)map.get(StockInventoryTaskMeta.DIRECTOR));
				this.setInventoryAssetCountByException( (Integer)map.get(StockInventoryTaskMeta.INVENTORY_ASSET_COUNT_BY_EXCEPTION));
				this.setSearchQuerySource( (String)map.get(StockInventoryTaskMeta.SEARCH_QUERY_SOURCE));
				this.setInventoryAssetCountByCounted( (Integer)map.get(StockInventoryTaskMeta.INVENTORY_ASSET_COUNT_BY_COUNTED));
				this.setOriginator( (Employee)map.get(StockInventoryTaskMeta.ORIGINATOR));
				this.setInventoryAssetCountByNotCounted( (Integer)map.get(StockInventoryTaskMeta.INVENTORY_ASSET_COUNT_BY_NOT_COUNTED));
				this.setInventoryAssetCountBySurplus( (Integer)map.get(StockInventoryTaskMeta.INVENTORY_ASSET_COUNT_BY_SURPLUS));
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
			this.setFinishTime(DataParser.parse(Date.class, r.getValue(StockInventoryTaskMeta.FINISH_TIME)));
			this.setNotes(DataParser.parse(String.class, r.getValue(StockInventoryTaskMeta.NOTES)));
			this.setDirectorId(DataParser.parse(String.class, r.getValue(StockInventoryTaskMeta.DIRECTOR_ID)));
			this.setOwnerCode(DataParser.parse(String.class, r.getValue(StockInventoryTaskMeta.OWNER_CODE)));
			this.setInventoryStatus(DataParser.parse(String.class, r.getValue(StockInventoryTaskMeta.INVENTORY_STATUS)));
			this.setDataStatus(DataParser.parse(String.class, r.getValue(StockInventoryTaskMeta.DATA_STATUS)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(StockInventoryTaskMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(StockInventoryTaskMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(StockInventoryTaskMeta.VERSION)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(StockInventoryTaskMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(StockInventoryTaskMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(StockInventoryTaskMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(StockInventoryTaskMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(StockInventoryTaskMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(StockInventoryTaskMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(StockInventoryTaskMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(StockInventoryTaskMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(StockInventoryTaskMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(StockInventoryTaskMeta.DELETE_BY)));
			this.setStartTime(DataParser.parse(Date.class, r.getValue(StockInventoryTaskMeta.START_TIME)));
			this.setPlanId(DataParser.parse(String.class, r.getValue(StockInventoryTaskMeta.PLAN_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(StockInventoryTaskMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(StockInventoryTaskMeta.ORIGINATOR_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(StockInventoryTaskMeta.STATUS)));
			return true;
		} else {
			try {
				this.setFinishTime( (Date)r.getValue(StockInventoryTaskMeta.FINISH_TIME));
				this.setNotes( (String)r.getValue(StockInventoryTaskMeta.NOTES));
				this.setDirectorId( (String)r.getValue(StockInventoryTaskMeta.DIRECTOR_ID));
				this.setOwnerCode( (String)r.getValue(StockInventoryTaskMeta.OWNER_CODE));
				this.setInventoryStatus( (String)r.getValue(StockInventoryTaskMeta.INVENTORY_STATUS));
				this.setDataStatus( (String)r.getValue(StockInventoryTaskMeta.DATA_STATUS));
				this.setUpdateTime( (Date)r.getValue(StockInventoryTaskMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(StockInventoryTaskMeta.TYPE));
				this.setVersion( (Integer)r.getValue(StockInventoryTaskMeta.VERSION));
				this.setBusinessDate( (Date)r.getValue(StockInventoryTaskMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(StockInventoryTaskMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(StockInventoryTaskMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(StockInventoryTaskMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(StockInventoryTaskMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(StockInventoryTaskMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(StockInventoryTaskMeta.DELETE_TIME));
				this.setName( (String)r.getValue(StockInventoryTaskMeta.NAME));
				this.setTenantId( (String)r.getValue(StockInventoryTaskMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(StockInventoryTaskMeta.DELETE_BY));
				this.setStartTime( (Date)r.getValue(StockInventoryTaskMeta.START_TIME));
				this.setPlanId( (String)r.getValue(StockInventoryTaskMeta.PLAN_ID));
				this.setId( (String)r.getValue(StockInventoryTaskMeta.ID));
				this.setOriginatorId( (String)r.getValue(StockInventoryTaskMeta.ORIGINATOR_ID));
				this.setStatus( (String)r.getValue(StockInventoryTaskMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}