package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_STOCK_GOODS_TRANFER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
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
import com.dt.platform.domain.eam.meta.AssetStockGoodsTranferMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 库存调拨
 * <p>库存调拨 , 数据表 eam_asset_stock_goods_tranfer 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-17 20:30:49
 * @sign AD83EEEC1C397E69A9D294695E3F3A66
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_stock_goods_tranfer")
@ApiModel(description = "库存调拨 ; 库存调拨 , 数据表 eam_asset_stock_goods_tranfer 的PO类型")
public class AssetStockGoodsTranfer extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_STOCK_GOODS_TRANFER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "789144717626441728")
	private String id;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号" , example = "PTR202359181459919")
	private String businessCode;
	
	/**
	 * 流程：流程
	*/
	@ApiModelProperty(required = false,value="流程" , notes = "流程")
	private String procId;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态" , example = "complete")
	private String status;
	
	/**
	 * 库存所属：库存所属
	*/
	@ApiModelProperty(required = false,value="库存所属" , notes = "库存所属" , example = "part")
	private String ownerType;
	
	/**
	 * 业务名称：业务名称
	*/
	@ApiModelProperty(required = false,value="业务名称" , notes = "业务名称" , example = "1212")
	private String name;
	
	/**
	 * 调出仓库：调出仓库
	*/
	@ApiModelProperty(required = false,value="调出仓库" , notes = "调出仓库" , example = "582427523481075712")
	private String warehouseOutId;
	
	/**
	 * 调入仓库：调入仓库
	*/
	@ApiModelProperty(required = false,value="调入仓库" , notes = "调入仓库" , example = "582427523481075712")
	private String warehouseInId;
	
	/**
	 * 调入库位：调入库位
	*/
	@ApiModelProperty(required = false,value="调入库位" , notes = "调入库位")
	private String positionInId;
	
	/**
	 * 转移说明：转移说明
	*/
	@ApiModelProperty(required = false,value="转移说明" , notes = "转移说明" , example = "121212")
	private String content;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人" , example = "E001")
	private String originatorId;
	
	/**
	 * 业务日期：业务日期
	*/
	@ApiModelProperty(required = false,value="业务日期" , notes = "业务日期" , example = "2023-12-18 12:00:00")
	private Date businessDate;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attachId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-12-18 02:59:22")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-12-18 02:59:28")
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
	@ApiModelProperty(required = false,value="选择数据" , notes = "选择数据" , example = "1702882751000")
	private String selectedCode;
	
	/**
	 * 变更类型：变更类型
	*/
	@ApiModelProperty(required = false,value="变更类型" , notes = "变更类型")
	private String chsType;
	
	/**
	 * 变更状态：变更状态
	*/
	@ApiModelProperty(required = false,value="变更状态" , notes = "变更状态")
	private String chsStatus;
	
	/**
	 * 变更版本号：变更版本号
	*/
	@ApiModelProperty(required = false,value="变更版本号" , notes = "变更版本号")
	private String chsVersion;
	
	/**
	 * 变更ID：变更ID
	*/
	@ApiModelProperty(required = false,value="变更ID" , notes = "变更ID")
	private String changeInstanceId;
	
	/**
	 * 流程概要：流程概要
	*/
	@ApiModelProperty(required = false,value="流程概要" , notes = "流程概要")
	private String summary;
	
	/**
	 * 最后审批人账户ID：最后审批人账户ID
	*/
	@ApiModelProperty(required = false,value="最后审批人账户ID" , notes = "最后审批人账户ID")
	private String latestApproverId;
	
	/**
	 * 最后审批人姓名：最后审批人姓名
	*/
	@ApiModelProperty(required = false,value="最后审批人姓名" , notes = "最后审批人姓名")
	private String latestApproverName;
	
	/**
	 * 下一节点审批人：下一节点审批人
	*/
	@ApiModelProperty(required = false,value="下一节点审批人" , notes = "下一节点审批人")
	private String nextApproverIds;
	
	/**
	 * 下一个审批节点审批人姓名：用逗号隔开
	*/
	@ApiModelProperty(required = false,value="下一个审批节点审批人姓名" , notes = "用逗号隔开")
	private String nextApproverNames;
	
	/**
	 * 审批意见：审批意见
	*/
	@ApiModelProperty(required = false,value="审批意见" , notes = "审批意见")
	private String approvalOpinion;
	
	/**
	 * 物品：物品
	*/
	@ApiModelProperty(required = false,value="物品" , notes = "物品")
	private List<GoodsStock> goodsList;
	
	/**
	 * 物品：物品
	*/
	@ApiModelProperty(required = false,value="物品" , notes = "物品")
	private List<String> goodsIds;
	
	/**
	 * 调出仓库：调出仓库
	*/
	@ApiModelProperty(required = false,value="调出仓库" , notes = "调出仓库")
	private Warehouse warehouseOut;
	
	/**
	 * 调入仓库：调入仓库
	*/
	@ApiModelProperty(required = false,value="调入仓库" , notes = "调入仓库")
	private Warehouse warehouseIn;
	
	/**
	 * 调入仓位：调入仓位
	*/
	@ApiModelProperty(required = false,value="调入仓位" , notes = "调入仓位")
	private WarehousePosition warehousePosition;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
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
	public AssetStockGoodsTranfer setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 业务编号<br>
	 * 业务编号
	 * @return 业务编号
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 业务编号
	 * @param businessCode 业务编号
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 流程<br>
	 * 流程
	 * @return 流程
	*/
	public String getProcId() {
		return procId;
	}
	
	/**
	 * 设置 流程
	 * @param procId 流程
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setProcId(String procId) {
		this.procId=procId;
		return this;
	}
	
	/**
	 * 获得 办理状态<br>
	 * 办理状态
	 * @return 办理状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 办理状态
	 * @param status 办理状态
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 库存所属<br>
	 * 库存所属
	 * @return 库存所属
	*/
	public String getOwnerType() {
		return ownerType;
	}
	
	/**
	 * 设置 库存所属
	 * @param ownerType 库存所属
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setOwnerType(String ownerType) {
		this.ownerType=ownerType;
		return this;
	}
	
	/**
	 * 获得 业务名称<br>
	 * 业务名称
	 * @return 业务名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 业务名称
	 * @param name 业务名称
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 调出仓库<br>
	 * 调出仓库
	 * @return 调出仓库
	*/
	public String getWarehouseOutId() {
		return warehouseOutId;
	}
	
	/**
	 * 设置 调出仓库
	 * @param warehouseOutId 调出仓库
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setWarehouseOutId(String warehouseOutId) {
		this.warehouseOutId=warehouseOutId;
		return this;
	}
	
	/**
	 * 获得 调入仓库<br>
	 * 调入仓库
	 * @return 调入仓库
	*/
	public String getWarehouseInId() {
		return warehouseInId;
	}
	
	/**
	 * 设置 调入仓库
	 * @param warehouseInId 调入仓库
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setWarehouseInId(String warehouseInId) {
		this.warehouseInId=warehouseInId;
		return this;
	}
	
	/**
	 * 获得 调入库位<br>
	 * 调入库位
	 * @return 调入库位
	*/
	public String getPositionInId() {
		return positionInId;
	}
	
	/**
	 * 设置 调入库位
	 * @param positionInId 调入库位
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setPositionInId(String positionInId) {
		this.positionInId=positionInId;
		return this;
	}
	
	/**
	 * 获得 转移说明<br>
	 * 转移说明
	 * @return 转移说明
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 转移说明
	 * @param content 转移说明
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setContent(String content) {
		this.content=content;
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
	public AssetStockGoodsTranfer setOriginatorId(String originatorId) {
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
	public AssetStockGoodsTranfer setBusinessDate(Date businessDate) {
		this.businessDate=businessDate;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getAttachId() {
		return attachId;
	}
	
	/**
	 * 设置 附件
	 * @param attachId 附件
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setAttachId(String attachId) {
		this.attachId=attachId;
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
	public AssetStockGoodsTranfer setCreateBy(String createBy) {
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
	public AssetStockGoodsTranfer setCreateTime(Date createTime) {
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
	public AssetStockGoodsTranfer setUpdateBy(String updateBy) {
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
	public AssetStockGoodsTranfer setUpdateTime(Date updateTime) {
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
	public AssetStockGoodsTranfer setDeleted(Integer deleted) {
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
	public AssetStockGoodsTranfer setDeleted(Boolean deletedBool) {
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
	public AssetStockGoodsTranfer setDeleteBy(String deleteBy) {
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
	public AssetStockGoodsTranfer setDeleteTime(Date deleteTime) {
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
	public AssetStockGoodsTranfer setVersion(Integer version) {
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
	public AssetStockGoodsTranfer setTenantId(String tenantId) {
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
	public AssetStockGoodsTranfer setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 变更类型<br>
	 * 变更类型
	 * @return 变更类型
	*/
	public String getChsType() {
		return chsType;
	}
	
	/**
	 * 设置 变更类型
	 * @param chsType 变更类型
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setChsType(String chsType) {
		this.chsType=chsType;
		return this;
	}
	
	/**
	 * 获得 变更状态<br>
	 * 变更状态
	 * @return 变更状态
	*/
	public String getChsStatus() {
		return chsStatus;
	}
	
	/**
	 * 设置 变更状态
	 * @param chsStatus 变更状态
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setChsStatus(String chsStatus) {
		this.chsStatus=chsStatus;
		return this;
	}
	
	/**
	 * 获得 变更版本号<br>
	 * 变更版本号
	 * @return 变更版本号
	*/
	public String getChsVersion() {
		return chsVersion;
	}
	
	/**
	 * 设置 变更版本号
	 * @param chsVersion 变更版本号
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setChsVersion(String chsVersion) {
		this.chsVersion=chsVersion;
		return this;
	}
	
	/**
	 * 获得 变更ID<br>
	 * 变更ID
	 * @return 变更ID
	*/
	public String getChangeInstanceId() {
		return changeInstanceId;
	}
	
	/**
	 * 设置 变更ID
	 * @param changeInstanceId 变更ID
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setChangeInstanceId(String changeInstanceId) {
		this.changeInstanceId=changeInstanceId;
		return this;
	}
	
	/**
	 * 获得 流程概要<br>
	 * 流程概要
	 * @return 流程概要
	*/
	public String getSummary() {
		return summary;
	}
	
	/**
	 * 设置 流程概要
	 * @param summary 流程概要
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setSummary(String summary) {
		this.summary=summary;
		return this;
	}
	
	/**
	 * 获得 最后审批人账户ID<br>
	 * 最后审批人账户ID
	 * @return 最后审批人账户ID
	*/
	public String getLatestApproverId() {
		return latestApproverId;
	}
	
	/**
	 * 设置 最后审批人账户ID
	 * @param latestApproverId 最后审批人账户ID
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setLatestApproverId(String latestApproverId) {
		this.latestApproverId=latestApproverId;
		return this;
	}
	
	/**
	 * 获得 最后审批人姓名<br>
	 * 最后审批人姓名
	 * @return 最后审批人姓名
	*/
	public String getLatestApproverName() {
		return latestApproverName;
	}
	
	/**
	 * 设置 最后审批人姓名
	 * @param latestApproverName 最后审批人姓名
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setLatestApproverName(String latestApproverName) {
		this.latestApproverName=latestApproverName;
		return this;
	}
	
	/**
	 * 获得 下一节点审批人<br>
	 * 下一节点审批人
	 * @return 下一节点审批人
	*/
	public String getNextApproverIds() {
		return nextApproverIds;
	}
	
	/**
	 * 设置 下一节点审批人
	 * @param nextApproverIds 下一节点审批人
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setNextApproverIds(String nextApproverIds) {
		this.nextApproverIds=nextApproverIds;
		return this;
	}
	
	/**
	 * 获得 下一个审批节点审批人姓名<br>
	 * 用逗号隔开
	 * @return 下一个审批节点审批人姓名
	*/
	public String getNextApproverNames() {
		return nextApproverNames;
	}
	
	/**
	 * 设置 下一个审批节点审批人姓名
	 * @param nextApproverNames 下一个审批节点审批人姓名
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setNextApproverNames(String nextApproverNames) {
		this.nextApproverNames=nextApproverNames;
		return this;
	}
	
	/**
	 * 获得 审批意见<br>
	 * 审批意见
	 * @return 审批意见
	*/
	public String getApprovalOpinion() {
		return approvalOpinion;
	}
	
	/**
	 * 设置 审批意见
	 * @param approvalOpinion 审批意见
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion=approvalOpinion;
		return this;
	}
	
	/**
	 * 获得 物品<br>
	 * 物品
	 * @return 物品
	*/
	public List<GoodsStock> getGoodsList() {
		return goodsList;
	}
	
	/**
	 * 设置 物品
	 * @param goodsList 物品
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setGoodsList(List<GoodsStock> goodsList) {
		this.goodsList=goodsList;
		return this;
	}
	
	/**
	 * 添加 物品
	 * @param goods 物品
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer addGoods(GoodsStock... goods) {
		if(this.goodsList==null) goodsList=new ArrayList<>();
		this.goodsList.addAll(Arrays.asList(goods));
		return this;
	}
	
	/**
	 * 获得 物品<br>
	 * 物品
	 * @return 物品
	*/
	public List<String> getGoodsIds() {
		return goodsIds;
	}
	
	/**
	 * 设置 物品
	 * @param goodsIds 物品
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setGoodsIds(List<String> goodsIds) {
		this.goodsIds=goodsIds;
		return this;
	}
	
	/**
	 * 添加 物品
	 * @param goodsId 物品
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer addGoodsId(String... goodsId) {
		if(this.goodsIds==null) goodsIds=new ArrayList<>();
		this.goodsIds.addAll(Arrays.asList(goodsId));
		return this;
	}
	
	/**
	 * 获得 调出仓库<br>
	 * 调出仓库
	 * @return 调出仓库
	*/
	public Warehouse getWarehouseOut() {
		return warehouseOut;
	}
	
	/**
	 * 设置 调出仓库
	 * @param warehouseOut 调出仓库
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setWarehouseOut(Warehouse warehouseOut) {
		this.warehouseOut=warehouseOut;
		return this;
	}
	
	/**
	 * 获得 调入仓库<br>
	 * 调入仓库
	 * @return 调入仓库
	*/
	public Warehouse getWarehouseIn() {
		return warehouseIn;
	}
	
	/**
	 * 设置 调入仓库
	 * @param warehouseIn 调入仓库
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setWarehouseIn(Warehouse warehouseIn) {
		this.warehouseIn=warehouseIn;
		return this;
	}
	
	/**
	 * 获得 调入仓位<br>
	 * 调入仓位
	 * @return 调入仓位
	*/
	public WarehousePosition getWarehousePosition() {
		return warehousePosition;
	}
	
	/**
	 * 设置 调入仓位
	 * @param warehousePosition 调入仓位
	 * @return 当前对象
	*/
	public AssetStockGoodsTranfer setWarehousePosition(WarehousePosition warehousePosition) {
		this.warehousePosition=warehousePosition;
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
	public AssetStockGoodsTranfer setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetStockGoodsTranfer , 转换好的 AssetStockGoodsTranfer 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetStockGoodsTranfer , 转换好的 PoJo 对象
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
	public AssetStockGoodsTranfer clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetStockGoodsTranfer duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetStockGoodsTranferMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetStockGoodsTranferMeta.$$proxy$$();
		inst.setOwnerType(this.getOwnerType());
		inst.setChsVersion(this.getChsVersion());
		inst.setProcId(this.getProcId());
		inst.setLatestApproverName(this.getLatestApproverName());
		inst.setChangeInstanceId(this.getChangeInstanceId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setNextApproverIds(this.getNextApproverIds());
		inst.setApprovalOpinion(this.getApprovalOpinion());
		inst.setWarehouseOutId(this.getWarehouseOutId());
		inst.setChsStatus(this.getChsStatus());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setAttachId(this.getAttachId());
		inst.setSummary(this.getSummary());
		inst.setNextApproverNames(this.getNextApproverNames());
		inst.setWarehouseInId(this.getWarehouseInId());
		inst.setLatestApproverId(this.getLatestApproverId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setPositionInId(this.getPositionInId());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setChsType(this.getChsType());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setWarehouseOut(this.getWarehouseOut());
			inst.setWarehouseIn(this.getWarehouseIn());
			inst.setGoodsList(this.getGoodsList());
			inst.setOriginator(this.getOriginator());
			inst.setWarehousePosition(this.getWarehousePosition());
			inst.setGoodsIds(this.getGoodsIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetStockGoodsTranfer clone(boolean deep) {
		return EntityContext.clone(AssetStockGoodsTranfer.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetStockGoodsTranfer
	 * @param assetStockGoodsTranferMap 包含实体信息的 Map 对象
	 * @return AssetStockGoodsTranfer , 转换好的的 AssetStockGoodsTranfer 对象
	*/
	@Transient
	public static AssetStockGoodsTranfer createFrom(Map<String,Object> assetStockGoodsTranferMap) {
		if(assetStockGoodsTranferMap==null) return null;
		AssetStockGoodsTranfer po = create();
		EntityContext.copyProperties(po,assetStockGoodsTranferMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetStockGoodsTranfer
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetStockGoodsTranfer , 转换好的的 AssetStockGoodsTranfer 对象
	*/
	@Transient
	public static AssetStockGoodsTranfer createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetStockGoodsTranfer po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetStockGoodsTranfer，等同于 new
	 * @return AssetStockGoodsTranfer 对象
	*/
	@Transient
	public static AssetStockGoodsTranfer create() {
		return new com.dt.platform.domain.eam.meta.AssetStockGoodsTranferMeta.$$proxy$$();
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
			this.setOwnerType(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.OWNER_TYPE)));
			this.setChsVersion(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.CHS_VERSION)));
			this.setProcId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.CHANGE_INSTANCE_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.CONTENT)));
			this.setNextApproverIds(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.APPROVAL_OPINION)));
			this.setWarehouseOutId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.WAREHOUSE_OUT_ID)));
			this.setChsStatus(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.CHS_STATUS)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(AssetStockGoodsTranferMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.ORIGINATOR_ID)));
			this.setAttachId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.ATTACH_ID)));
			this.setSummary(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.NEXT_APPROVER_NAMES)));
			this.setWarehouseInId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.WAREHOUSE_IN_ID)));
			this.setLatestApproverId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.LATEST_APPROVER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetStockGoodsTranferMeta.UPDATE_TIME)));
			this.setPositionInId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.POSITION_IN_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetStockGoodsTranferMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetStockGoodsTranferMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetStockGoodsTranferMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetStockGoodsTranferMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetStockGoodsTranferMeta.STATUS)));
			// others
			this.setWarehouseOut(DataParser.parse(Warehouse.class, map.get(AssetStockGoodsTranferMeta.WAREHOUSE_OUT)));
			this.setWarehouseIn(DataParser.parse(Warehouse.class, map.get(AssetStockGoodsTranferMeta.WAREHOUSE_IN)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetStockGoodsTranferMeta.ORIGINATOR)));
			this.setWarehousePosition(DataParser.parse(WarehousePosition.class, map.get(AssetStockGoodsTranferMeta.WAREHOUSE_POSITION)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)map.get(AssetStockGoodsTranferMeta.OWNER_TYPE));
				this.setChsVersion( (String)map.get(AssetStockGoodsTranferMeta.CHS_VERSION));
				this.setProcId( (String)map.get(AssetStockGoodsTranferMeta.PROC_ID));
				this.setLatestApproverName( (String)map.get(AssetStockGoodsTranferMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)map.get(AssetStockGoodsTranferMeta.CHANGE_INSTANCE_ID));
				this.setSelectedCode( (String)map.get(AssetStockGoodsTranferMeta.SELECTED_CODE));
				this.setContent( (String)map.get(AssetStockGoodsTranferMeta.CONTENT));
				this.setNextApproverIds( (String)map.get(AssetStockGoodsTranferMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)map.get(AssetStockGoodsTranferMeta.APPROVAL_OPINION));
				this.setWarehouseOutId( (String)map.get(AssetStockGoodsTranferMeta.WAREHOUSE_OUT_ID));
				this.setChsStatus( (String)map.get(AssetStockGoodsTranferMeta.CHS_STATUS));
				this.setBusinessDate( (Date)map.get(AssetStockGoodsTranferMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(AssetStockGoodsTranferMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)map.get(AssetStockGoodsTranferMeta.UPDATE_BY));
				this.setId( (String)map.get(AssetStockGoodsTranferMeta.ID));
				this.setOriginatorId( (String)map.get(AssetStockGoodsTranferMeta.ORIGINATOR_ID));
				this.setAttachId( (String)map.get(AssetStockGoodsTranferMeta.ATTACH_ID));
				this.setSummary( (String)map.get(AssetStockGoodsTranferMeta.SUMMARY));
				this.setNextApproverNames( (String)map.get(AssetStockGoodsTranferMeta.NEXT_APPROVER_NAMES));
				this.setWarehouseInId( (String)map.get(AssetStockGoodsTranferMeta.WAREHOUSE_IN_ID));
				this.setLatestApproverId( (String)map.get(AssetStockGoodsTranferMeta.LATEST_APPROVER_ID));
				this.setUpdateTime( (Date)map.get(AssetStockGoodsTranferMeta.UPDATE_TIME));
				this.setPositionInId( (String)map.get(AssetStockGoodsTranferMeta.POSITION_IN_ID));
				this.setVersion( (Integer)map.get(AssetStockGoodsTranferMeta.VERSION));
				this.setCreateBy( (String)map.get(AssetStockGoodsTranferMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetStockGoodsTranferMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetStockGoodsTranferMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetStockGoodsTranferMeta.DELETE_TIME));
				this.setChsType( (String)map.get(AssetStockGoodsTranferMeta.CHS_TYPE));
				this.setName( (String)map.get(AssetStockGoodsTranferMeta.NAME));
				this.setTenantId( (String)map.get(AssetStockGoodsTranferMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetStockGoodsTranferMeta.DELETE_BY));
				this.setStatus( (String)map.get(AssetStockGoodsTranferMeta.STATUS));
				// others
				this.setWarehouseOut( (Warehouse)map.get(AssetStockGoodsTranferMeta.WAREHOUSE_OUT));
				this.setWarehouseIn( (Warehouse)map.get(AssetStockGoodsTranferMeta.WAREHOUSE_IN));
				this.setOriginator( (Employee)map.get(AssetStockGoodsTranferMeta.ORIGINATOR));
				this.setWarehousePosition( (WarehousePosition)map.get(AssetStockGoodsTranferMeta.WAREHOUSE_POSITION));
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
			this.setOwnerType(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.OWNER_TYPE)));
			this.setChsVersion(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.CHS_VERSION)));
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.CHANGE_INSTANCE_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.CONTENT)));
			this.setNextApproverIds(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.APPROVAL_OPINION)));
			this.setWarehouseOutId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.WAREHOUSE_OUT_ID)));
			this.setChsStatus(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.CHS_STATUS)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(AssetStockGoodsTranferMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.ORIGINATOR_ID)));
			this.setAttachId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.ATTACH_ID)));
			this.setSummary(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.NEXT_APPROVER_NAMES)));
			this.setWarehouseInId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.WAREHOUSE_IN_ID)));
			this.setLatestApproverId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.LATEST_APPROVER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsTranferMeta.UPDATE_TIME)));
			this.setPositionInId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.POSITION_IN_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetStockGoodsTranferMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetStockGoodsTranferMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsTranferMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsTranferMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferMeta.STATUS)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)r.getValue(AssetStockGoodsTranferMeta.OWNER_TYPE));
				this.setChsVersion( (String)r.getValue(AssetStockGoodsTranferMeta.CHS_VERSION));
				this.setProcId( (String)r.getValue(AssetStockGoodsTranferMeta.PROC_ID));
				this.setLatestApproverName( (String)r.getValue(AssetStockGoodsTranferMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)r.getValue(AssetStockGoodsTranferMeta.CHANGE_INSTANCE_ID));
				this.setSelectedCode( (String)r.getValue(AssetStockGoodsTranferMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(AssetStockGoodsTranferMeta.CONTENT));
				this.setNextApproverIds( (String)r.getValue(AssetStockGoodsTranferMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)r.getValue(AssetStockGoodsTranferMeta.APPROVAL_OPINION));
				this.setWarehouseOutId( (String)r.getValue(AssetStockGoodsTranferMeta.WAREHOUSE_OUT_ID));
				this.setChsStatus( (String)r.getValue(AssetStockGoodsTranferMeta.CHS_STATUS));
				this.setBusinessDate( (Date)r.getValue(AssetStockGoodsTranferMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(AssetStockGoodsTranferMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)r.getValue(AssetStockGoodsTranferMeta.UPDATE_BY));
				this.setId( (String)r.getValue(AssetStockGoodsTranferMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetStockGoodsTranferMeta.ORIGINATOR_ID));
				this.setAttachId( (String)r.getValue(AssetStockGoodsTranferMeta.ATTACH_ID));
				this.setSummary( (String)r.getValue(AssetStockGoodsTranferMeta.SUMMARY));
				this.setNextApproverNames( (String)r.getValue(AssetStockGoodsTranferMeta.NEXT_APPROVER_NAMES));
				this.setWarehouseInId( (String)r.getValue(AssetStockGoodsTranferMeta.WAREHOUSE_IN_ID));
				this.setLatestApproverId( (String)r.getValue(AssetStockGoodsTranferMeta.LATEST_APPROVER_ID));
				this.setUpdateTime( (Date)r.getValue(AssetStockGoodsTranferMeta.UPDATE_TIME));
				this.setPositionInId( (String)r.getValue(AssetStockGoodsTranferMeta.POSITION_IN_ID));
				this.setVersion( (Integer)r.getValue(AssetStockGoodsTranferMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AssetStockGoodsTranferMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetStockGoodsTranferMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetStockGoodsTranferMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetStockGoodsTranferMeta.DELETE_TIME));
				this.setChsType( (String)r.getValue(AssetStockGoodsTranferMeta.CHS_TYPE));
				this.setName( (String)r.getValue(AssetStockGoodsTranferMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetStockGoodsTranferMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetStockGoodsTranferMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(AssetStockGoodsTranferMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}