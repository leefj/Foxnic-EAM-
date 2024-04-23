package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_STOCK_GOODS_ADJUST;
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
import com.dt.platform.domain.eam.meta.AssetStockGoodsAdjustMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 库存调整
 * <p>库存调整 , 数据表 eam_asset_stock_goods_adjust 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-23 11:19:34
 * @sign 4C05AFB2F1D6C612E7D5894367E160C2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_stock_goods_adjust")
@ApiModel(description = "库存调整 ; 库存调整 , 数据表 eam_asset_stock_goods_adjust 的PO类型")
public class AssetStockGoodsAdjust extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_STOCK_GOODS_ADJUST.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "789144539146223616")
	private String id;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号" , example = "PAD202358181458633")
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
	@ApiModelProperty(required = false,value="业务名称" , notes = "业务名称" , example = "12")
	private String name;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private String warehouseId;
	
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
	 * 调整说明：调整说明
	*/
	@ApiModelProperty(required = false,value="调整说明" , notes = "调整说明" , example = "1212")
	private String content;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-12-18 02:58:40")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-12-18 02:58:50")
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
	@ApiModelProperty(required = false,value="选择数据" , notes = "选择数据" , example = "1702882703000")
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
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private Warehouse warehouse;
	
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
	public AssetStockGoodsAdjust setId(String id) {
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
	public AssetStockGoodsAdjust setBusinessCode(String businessCode) {
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
	public AssetStockGoodsAdjust setProcId(String procId) {
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
	public AssetStockGoodsAdjust setStatus(String status) {
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
	public AssetStockGoodsAdjust setOwnerType(String ownerType) {
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
	public AssetStockGoodsAdjust setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 仓库<br>
	 * 仓库
	 * @return 仓库
	*/
	public String getWarehouseId() {
		return warehouseId;
	}
	
	/**
	 * 设置 仓库
	 * @param warehouseId 仓库
	 * @return 当前对象
	*/
	public AssetStockGoodsAdjust setWarehouseId(String warehouseId) {
		this.warehouseId=warehouseId;
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
	public AssetStockGoodsAdjust setOriginatorId(String originatorId) {
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
	public AssetStockGoodsAdjust setBusinessDate(Date businessDate) {
		this.businessDate=businessDate;
		return this;
	}
	
	/**
	 * 获得 调整说明<br>
	 * 调整说明
	 * @return 调整说明
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 调整说明
	 * @param content 调整说明
	 * @return 当前对象
	*/
	public AssetStockGoodsAdjust setContent(String content) {
		this.content=content;
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
	public AssetStockGoodsAdjust setAttachId(String attachId) {
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
	public AssetStockGoodsAdjust setCreateBy(String createBy) {
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
	public AssetStockGoodsAdjust setCreateTime(Date createTime) {
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
	public AssetStockGoodsAdjust setUpdateBy(String updateBy) {
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
	public AssetStockGoodsAdjust setUpdateTime(Date updateTime) {
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
	public AssetStockGoodsAdjust setDeleted(Integer deleted) {
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
	public AssetStockGoodsAdjust setDeleted(Boolean deletedBool) {
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
	public AssetStockGoodsAdjust setDeleteBy(String deleteBy) {
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
	public AssetStockGoodsAdjust setDeleteTime(Date deleteTime) {
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
	public AssetStockGoodsAdjust setVersion(Integer version) {
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
	public AssetStockGoodsAdjust setTenantId(String tenantId) {
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
	public AssetStockGoodsAdjust setSelectedCode(String selectedCode) {
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
	public AssetStockGoodsAdjust setChsType(String chsType) {
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
	public AssetStockGoodsAdjust setChsStatus(String chsStatus) {
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
	public AssetStockGoodsAdjust setChsVersion(String chsVersion) {
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
	public AssetStockGoodsAdjust setChangeInstanceId(String changeInstanceId) {
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
	public AssetStockGoodsAdjust setSummary(String summary) {
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
	public AssetStockGoodsAdjust setLatestApproverId(String latestApproverId) {
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
	public AssetStockGoodsAdjust setLatestApproverName(String latestApproverName) {
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
	public AssetStockGoodsAdjust setNextApproverIds(String nextApproverIds) {
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
	public AssetStockGoodsAdjust setNextApproverNames(String nextApproverNames) {
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
	public AssetStockGoodsAdjust setApprovalOpinion(String approvalOpinion) {
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
	public AssetStockGoodsAdjust setGoodsList(List<GoodsStock> goodsList) {
		this.goodsList=goodsList;
		return this;
	}
	
	/**
	 * 添加 物品
	 * @param goods 物品
	 * @return 当前对象
	*/
	public AssetStockGoodsAdjust addGoods(GoodsStock... goods) {
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
	public AssetStockGoodsAdjust setGoodsIds(List<String> goodsIds) {
		this.goodsIds=goodsIds;
		return this;
	}
	
	/**
	 * 添加 物品
	 * @param goodsId 物品
	 * @return 当前对象
	*/
	public AssetStockGoodsAdjust addGoodsId(String... goodsId) {
		if(this.goodsIds==null) goodsIds=new ArrayList<>();
		this.goodsIds.addAll(Arrays.asList(goodsId));
		return this;
	}
	
	/**
	 * 获得 仓库<br>
	 * 仓库
	 * @return 仓库
	*/
	public Warehouse getWarehouse() {
		return warehouse;
	}
	
	/**
	 * 设置 仓库
	 * @param warehouse 仓库
	 * @return 当前对象
	*/
	public AssetStockGoodsAdjust setWarehouse(Warehouse warehouse) {
		this.warehouse=warehouse;
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
	public AssetStockGoodsAdjust setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetStockGoodsAdjust , 转换好的 AssetStockGoodsAdjust 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetStockGoodsAdjust , 转换好的 PoJo 对象
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
	public AssetStockGoodsAdjust clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetStockGoodsAdjust duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetStockGoodsAdjustMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetStockGoodsAdjustMeta.$$proxy$$();
		inst.setOwnerType(this.getOwnerType());
		inst.setChsVersion(this.getChsVersion());
		inst.setProcId(this.getProcId());
		inst.setLatestApproverName(this.getLatestApproverName());
		inst.setChangeInstanceId(this.getChangeInstanceId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setNextApproverIds(this.getNextApproverIds());
		inst.setApprovalOpinion(this.getApprovalOpinion());
		inst.setChsStatus(this.getChsStatus());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setAttachId(this.getAttachId());
		inst.setSummary(this.getSummary());
		inst.setNextApproverNames(this.getNextApproverNames());
		inst.setLatestApproverId(this.getLatestApproverId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setWarehouseId(this.getWarehouseId());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setChsType(this.getChsType());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setGoodsList(this.getGoodsList());
			inst.setOriginator(this.getOriginator());
			inst.setWarehouse(this.getWarehouse());
			inst.setGoodsIds(this.getGoodsIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetStockGoodsAdjust clone(boolean deep) {
		return EntityContext.clone(AssetStockGoodsAdjust.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetStockGoodsAdjust
	 * @param assetStockGoodsAdjustMap 包含实体信息的 Map 对象
	 * @return AssetStockGoodsAdjust , 转换好的的 AssetStockGoodsAdjust 对象
	*/
	@Transient
	public static AssetStockGoodsAdjust createFrom(Map<String,Object> assetStockGoodsAdjustMap) {
		if(assetStockGoodsAdjustMap==null) return null;
		AssetStockGoodsAdjust po = create();
		EntityContext.copyProperties(po,assetStockGoodsAdjustMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetStockGoodsAdjust
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetStockGoodsAdjust , 转换好的的 AssetStockGoodsAdjust 对象
	*/
	@Transient
	public static AssetStockGoodsAdjust createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetStockGoodsAdjust po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetStockGoodsAdjust，等同于 new
	 * @return AssetStockGoodsAdjust 对象
	*/
	@Transient
	public static AssetStockGoodsAdjust create() {
		return new com.dt.platform.domain.eam.meta.AssetStockGoodsAdjustMeta.$$proxy$$();
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
			this.setOwnerType(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.OWNER_TYPE)));
			this.setChsVersion(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.CHS_VERSION)));
			this.setProcId(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.CHANGE_INSTANCE_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.CONTENT)));
			this.setNextApproverIds(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.APPROVAL_OPINION)));
			this.setChsStatus(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.CHS_STATUS)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(AssetStockGoodsAdjustMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.ORIGINATOR_ID)));
			this.setAttachId(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.ATTACH_ID)));
			this.setSummary(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.NEXT_APPROVER_NAMES)));
			this.setLatestApproverId(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.LATEST_APPROVER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetStockGoodsAdjustMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetStockGoodsAdjustMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetStockGoodsAdjustMeta.DELETED)));
			this.setWarehouseId(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.WAREHOUSE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetStockGoodsAdjustMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetStockGoodsAdjustMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetStockGoodsAdjustMeta.STATUS)));
			// others
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetStockGoodsAdjustMeta.ORIGINATOR)));
			this.setWarehouse(DataParser.parse(Warehouse.class, map.get(AssetStockGoodsAdjustMeta.WAREHOUSE)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)map.get(AssetStockGoodsAdjustMeta.OWNER_TYPE));
				this.setChsVersion( (String)map.get(AssetStockGoodsAdjustMeta.CHS_VERSION));
				this.setProcId( (String)map.get(AssetStockGoodsAdjustMeta.PROC_ID));
				this.setLatestApproverName( (String)map.get(AssetStockGoodsAdjustMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)map.get(AssetStockGoodsAdjustMeta.CHANGE_INSTANCE_ID));
				this.setSelectedCode( (String)map.get(AssetStockGoodsAdjustMeta.SELECTED_CODE));
				this.setContent( (String)map.get(AssetStockGoodsAdjustMeta.CONTENT));
				this.setNextApproverIds( (String)map.get(AssetStockGoodsAdjustMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)map.get(AssetStockGoodsAdjustMeta.APPROVAL_OPINION));
				this.setChsStatus( (String)map.get(AssetStockGoodsAdjustMeta.CHS_STATUS));
				this.setBusinessDate( (Date)map.get(AssetStockGoodsAdjustMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(AssetStockGoodsAdjustMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)map.get(AssetStockGoodsAdjustMeta.UPDATE_BY));
				this.setId( (String)map.get(AssetStockGoodsAdjustMeta.ID));
				this.setOriginatorId( (String)map.get(AssetStockGoodsAdjustMeta.ORIGINATOR_ID));
				this.setAttachId( (String)map.get(AssetStockGoodsAdjustMeta.ATTACH_ID));
				this.setSummary( (String)map.get(AssetStockGoodsAdjustMeta.SUMMARY));
				this.setNextApproverNames( (String)map.get(AssetStockGoodsAdjustMeta.NEXT_APPROVER_NAMES));
				this.setLatestApproverId( (String)map.get(AssetStockGoodsAdjustMeta.LATEST_APPROVER_ID));
				this.setUpdateTime( (Date)map.get(AssetStockGoodsAdjustMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetStockGoodsAdjustMeta.VERSION));
				this.setCreateBy( (String)map.get(AssetStockGoodsAdjustMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetStockGoodsAdjustMeta.DELETED));
				this.setWarehouseId( (String)map.get(AssetStockGoodsAdjustMeta.WAREHOUSE_ID));
				this.setCreateTime( (Date)map.get(AssetStockGoodsAdjustMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetStockGoodsAdjustMeta.DELETE_TIME));
				this.setChsType( (String)map.get(AssetStockGoodsAdjustMeta.CHS_TYPE));
				this.setName( (String)map.get(AssetStockGoodsAdjustMeta.NAME));
				this.setTenantId( (String)map.get(AssetStockGoodsAdjustMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetStockGoodsAdjustMeta.DELETE_BY));
				this.setStatus( (String)map.get(AssetStockGoodsAdjustMeta.STATUS));
				// others
				this.setOriginator( (Employee)map.get(AssetStockGoodsAdjustMeta.ORIGINATOR));
				this.setWarehouse( (Warehouse)map.get(AssetStockGoodsAdjustMeta.WAREHOUSE));
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
			this.setOwnerType(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.OWNER_TYPE)));
			this.setChsVersion(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.CHS_VERSION)));
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.CHANGE_INSTANCE_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.CONTENT)));
			this.setNextApproverIds(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.APPROVAL_OPINION)));
			this.setChsStatus(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.CHS_STATUS)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(AssetStockGoodsAdjustMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.ORIGINATOR_ID)));
			this.setAttachId(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.ATTACH_ID)));
			this.setSummary(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.NEXT_APPROVER_NAMES)));
			this.setLatestApproverId(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.LATEST_APPROVER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsAdjustMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetStockGoodsAdjustMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetStockGoodsAdjustMeta.DELETED)));
			this.setWarehouseId(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.WAREHOUSE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsAdjustMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsAdjustMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetStockGoodsAdjustMeta.STATUS)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)r.getValue(AssetStockGoodsAdjustMeta.OWNER_TYPE));
				this.setChsVersion( (String)r.getValue(AssetStockGoodsAdjustMeta.CHS_VERSION));
				this.setProcId( (String)r.getValue(AssetStockGoodsAdjustMeta.PROC_ID));
				this.setLatestApproverName( (String)r.getValue(AssetStockGoodsAdjustMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)r.getValue(AssetStockGoodsAdjustMeta.CHANGE_INSTANCE_ID));
				this.setSelectedCode( (String)r.getValue(AssetStockGoodsAdjustMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(AssetStockGoodsAdjustMeta.CONTENT));
				this.setNextApproverIds( (String)r.getValue(AssetStockGoodsAdjustMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)r.getValue(AssetStockGoodsAdjustMeta.APPROVAL_OPINION));
				this.setChsStatus( (String)r.getValue(AssetStockGoodsAdjustMeta.CHS_STATUS));
				this.setBusinessDate( (Date)r.getValue(AssetStockGoodsAdjustMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(AssetStockGoodsAdjustMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)r.getValue(AssetStockGoodsAdjustMeta.UPDATE_BY));
				this.setId( (String)r.getValue(AssetStockGoodsAdjustMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetStockGoodsAdjustMeta.ORIGINATOR_ID));
				this.setAttachId( (String)r.getValue(AssetStockGoodsAdjustMeta.ATTACH_ID));
				this.setSummary( (String)r.getValue(AssetStockGoodsAdjustMeta.SUMMARY));
				this.setNextApproverNames( (String)r.getValue(AssetStockGoodsAdjustMeta.NEXT_APPROVER_NAMES));
				this.setLatestApproverId( (String)r.getValue(AssetStockGoodsAdjustMeta.LATEST_APPROVER_ID));
				this.setUpdateTime( (Date)r.getValue(AssetStockGoodsAdjustMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetStockGoodsAdjustMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AssetStockGoodsAdjustMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetStockGoodsAdjustMeta.DELETED));
				this.setWarehouseId( (String)r.getValue(AssetStockGoodsAdjustMeta.WAREHOUSE_ID));
				this.setCreateTime( (Date)r.getValue(AssetStockGoodsAdjustMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetStockGoodsAdjustMeta.DELETE_TIME));
				this.setChsType( (String)r.getValue(AssetStockGoodsAdjustMeta.CHS_TYPE));
				this.setName( (String)r.getValue(AssetStockGoodsAdjustMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetStockGoodsAdjustMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetStockGoodsAdjustMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(AssetStockGoodsAdjustMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}