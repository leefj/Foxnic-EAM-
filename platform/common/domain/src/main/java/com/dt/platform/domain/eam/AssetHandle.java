package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_HANDLE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetHandleMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产处置
 * <p>资产处置 , 数据表 eam_asset_handle 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-30 14:22:53
 * @sign A62C49E2B2338B3F78FB53F5C43F0B4B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_handle")
@ApiModel(description = "资产处置 ; 资产处置 , 数据表 eam_asset_handle 的PO类型")
public class AssetHandle extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_HANDLE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 流程：流程
	*/
	@ApiModelProperty(required = false,value="流程" , notes = "流程")
	private String procId;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号")
	private String businessCode;
	
	/**
	 * 业务名称：业务名称
	*/
	@ApiModelProperty(required = false,value="业务名称" , notes = "业务名称")
	private String name;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态")
	private String status;
	
	/**
	 * 处置类型：处置类型
	*/
	@ApiModelProperty(required = false,value="处置类型" , notes = "处置类型")
	private String type;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String content;
	
	/**
	 * 处理日期：处理日期
	*/
	@ApiModelProperty(required = false,value="处理日期" , notes = "处理日期")
	private Date planFinishDate;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String fileId;
	
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
	 * 选择数据：选择数据
	*/
	@ApiModelProperty(required = false,value="选择数据" , notes = "选择数据")
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
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private List<Asset> assetList;
	
	/**
	 * 资产列表：资产列表
	*/
	@ApiModelProperty(required = false,value="资产列表" , notes = "资产列表")
	private List<String> assetIds;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * assetHandleType：assetHandleType
	*/
	@ApiModelProperty(required = false,value="assetHandleType" , notes = "assetHandleType")
	private AssetHandleType assetHandleType;
	
	/**
	 * 历史流程清单：历史流程清单
	*/
	@ApiModelProperty(required = false,value="历史流程清单" , notes = "历史流程清单")
	private List<ProcessInstance> historicProcessList;
	
	/**
	 * 在批的流程清单：在批的流程清单
	*/
	@ApiModelProperty(required = false,value="在批的流程清单" , notes = "在批的流程清单")
	private List<ProcessInstance> currentProcessList;
	
	/**
	 * 默认流程：优先取在批的流程
	*/
	@ApiModelProperty(required = false,value="默认流程" , notes = "优先取在批的流程")
	private ProcessInstance defaultProcess;
	
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
	public AssetHandle setId(String id) {
		this.id=id;
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
	public AssetHandle setProcId(String procId) {
		this.procId=procId;
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
	public AssetHandle setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
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
	public AssetHandle setName(String name) {
		this.name=name;
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
	public AssetHandle setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 处置类型<br>
	 * 处置类型
	 * @return 处置类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 处置类型
	 * @param type 处置类型
	 * @return 当前对象
	*/
	public AssetHandle setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 内容
	 * @param content 内容
	 * @return 当前对象
	*/
	public AssetHandle setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 处理日期<br>
	 * 处理日期
	 * @return 处理日期
	*/
	public Date getPlanFinishDate() {
		return planFinishDate;
	}
	
	/**
	 * 设置 处理日期
	 * @param planFinishDate 处理日期
	 * @return 当前对象
	*/
	public AssetHandle setPlanFinishDate(Date planFinishDate) {
		this.planFinishDate=planFinishDate;
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
	public AssetHandle setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 附件
	 * @param fileId 附件
	 * @return 当前对象
	*/
	public AssetHandle setFileId(String fileId) {
		this.fileId=fileId;
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
	public AssetHandle setNotes(String notes) {
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
	public AssetHandle setCreateBy(String createBy) {
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
	public AssetHandle setCreateTime(Date createTime) {
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
	public AssetHandle setUpdateBy(String updateBy) {
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
	public AssetHandle setUpdateTime(Date updateTime) {
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
	public AssetHandle setDeleted(Integer deleted) {
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
	public AssetHandle setDeleted(Boolean deletedBool) {
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
	public AssetHandle setDeleteBy(String deleteBy) {
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
	public AssetHandle setDeleteTime(Date deleteTime) {
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
	public AssetHandle setVersion(Integer version) {
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
	public AssetHandle setTenantId(String tenantId) {
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
	public AssetHandle setSelectedCode(String selectedCode) {
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
	public AssetHandle setChsType(String chsType) {
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
	public AssetHandle setChsStatus(String chsStatus) {
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
	public AssetHandle setChsVersion(String chsVersion) {
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
	public AssetHandle setChangeInstanceId(String changeInstanceId) {
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
	public AssetHandle setSummary(String summary) {
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
	public AssetHandle setLatestApproverId(String latestApproverId) {
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
	public AssetHandle setLatestApproverName(String latestApproverName) {
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
	public AssetHandle setNextApproverIds(String nextApproverIds) {
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
	public AssetHandle setNextApproverNames(String nextApproverNames) {
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
	public AssetHandle setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion=approvalOpinion;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public List<Asset> getAssetList() {
		return assetList;
	}
	
	/**
	 * 设置 资产
	 * @param assetList 资产
	 * @return 当前对象
	*/
	public AssetHandle setAssetList(List<Asset> assetList) {
		this.assetList=assetList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public AssetHandle addAsset(Asset... asset) {
		if(this.assetList==null) assetList=new ArrayList<>();
		this.assetList.addAll(Arrays.asList(asset));
		return this;
	}
	
	/**
	 * 获得 资产列表<br>
	 * 资产列表
	 * @return 资产列表
	*/
	public List<String> getAssetIds() {
		return assetIds;
	}
	
	/**
	 * 设置 资产列表
	 * @param assetIds 资产列表
	 * @return 当前对象
	*/
	public AssetHandle setAssetIds(List<String> assetIds) {
		this.assetIds=assetIds;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetId 资产列表
	 * @return 当前对象
	*/
	public AssetHandle addAssetId(String... assetId) {
		if(this.assetIds==null) assetIds=new ArrayList<>();
		this.assetIds.addAll(Arrays.asList(assetId));
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
	public AssetHandle setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 assetHandleType<br>
	 * assetHandleType
	 * @return assetHandleType
	*/
	public AssetHandleType getAssetHandleType() {
		return assetHandleType;
	}
	
	/**
	 * 设置 assetHandleType
	 * @param assetHandleType assetHandleType
	 * @return 当前对象
	*/
	public AssetHandle setAssetHandleType(AssetHandleType assetHandleType) {
		this.assetHandleType=assetHandleType;
		return this;
	}
	
	/**
	 * 获得 历史流程清单<br>
	 * 历史流程清单
	 * @return 历史流程清单
	*/
	public List<ProcessInstance> getHistoricProcessList() {
		return historicProcessList;
	}
	
	/**
	 * 设置 历史流程清单
	 * @param historicProcessList 历史流程清单
	 * @return 当前对象
	*/
	public AssetHandle setHistoricProcessList(List<ProcessInstance> historicProcessList) {
		this.historicProcessList=historicProcessList;
		return this;
	}
	
	/**
	 * 添加 历史流程清单
	 * @param historicProcess 历史流程清单
	 * @return 当前对象
	*/
	public AssetHandle addHistoricProcess(ProcessInstance... historicProcess) {
		if(this.historicProcessList==null) historicProcessList=new ArrayList<>();
		this.historicProcessList.addAll(Arrays.asList(historicProcess));
		return this;
	}
	
	/**
	 * 获得 在批的流程清单<br>
	 * 在批的流程清单
	 * @return 在批的流程清单
	*/
	public List<ProcessInstance> getCurrentProcessList() {
		return currentProcessList;
	}
	
	/**
	 * 设置 在批的流程清单
	 * @param currentProcessList 在批的流程清单
	 * @return 当前对象
	*/
	public AssetHandle setCurrentProcessList(List<ProcessInstance> currentProcessList) {
		this.currentProcessList=currentProcessList;
		return this;
	}
	
	/**
	 * 添加 在批的流程清单
	 * @param currentProcess 在批的流程清单
	 * @return 当前对象
	*/
	public AssetHandle addCurrentProcess(ProcessInstance... currentProcess) {
		if(this.currentProcessList==null) currentProcessList=new ArrayList<>();
		this.currentProcessList.addAll(Arrays.asList(currentProcess));
		return this;
	}
	
	/**
	 * 获得 默认流程<br>
	 * 优先取在批的流程
	 * @return 默认流程
	*/
	public ProcessInstance getDefaultProcess() {
		return defaultProcess;
	}
	
	/**
	 * 设置 默认流程
	 * @param defaultProcess 默认流程
	 * @return 当前对象
	*/
	public AssetHandle setDefaultProcess(ProcessInstance defaultProcess) {
		this.defaultProcess=defaultProcess;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetHandle , 转换好的 AssetHandle 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetHandle , 转换好的 PoJo 对象
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
	public AssetHandle clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetHandle duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetHandleMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetHandleMeta.$$proxy$$();
		inst.setChsVersion(this.getChsVersion());
		inst.setNotes(this.getNotes());
		inst.setProcId(this.getProcId());
		inst.setLatestApproverName(this.getLatestApproverName());
		inst.setChangeInstanceId(this.getChangeInstanceId());
		inst.setType(this.getType());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setNextApproverIds(this.getNextApproverIds());
		inst.setApprovalOpinion(this.getApprovalOpinion());
		inst.setChsStatus(this.getChsStatus());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setSummary(this.getSummary());
		inst.setNextApproverNames(this.getNextApproverNames());
		inst.setLatestApproverId(this.getLatestApproverId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setChsType(this.getChsType());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPlanFinishDate(this.getPlanFinishDate());
		inst.setStatus(this.getStatus());
		inst.setFileId(this.getFileId());
		if(all) {
			inst.setAssetHandleType(this.getAssetHandleType());
			inst.setAssetIds(this.getAssetIds());
			inst.setHistoricProcessList(this.getHistoricProcessList());
			inst.setOriginator(this.getOriginator());
			inst.setAssetList(this.getAssetList());
			inst.setCurrentProcessList(this.getCurrentProcessList());
			inst.setDefaultProcess(this.getDefaultProcess());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetHandle clone(boolean deep) {
		return EntityContext.clone(AssetHandle.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetHandle
	 * @param assetHandleMap 包含实体信息的 Map 对象
	 * @return AssetHandle , 转换好的的 AssetHandle 对象
	*/
	@Transient
	public static AssetHandle createFrom(Map<String,Object> assetHandleMap) {
		if(assetHandleMap==null) return null;
		AssetHandle po = create();
		EntityContext.copyProperties(po,assetHandleMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetHandle
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetHandle , 转换好的的 AssetHandle 对象
	*/
	@Transient
	public static AssetHandle createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetHandle po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetHandle，等同于 new
	 * @return AssetHandle 对象
	*/
	@Transient
	public static AssetHandle create() {
		return new com.dt.platform.domain.eam.meta.AssetHandleMeta.$$proxy$$();
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
			this.setChsVersion(DataParser.parse(String.class, map.get(AssetHandleMeta.CHS_VERSION)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetHandleMeta.NOTES)));
			this.setProcId(DataParser.parse(String.class, map.get(AssetHandleMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, map.get(AssetHandleMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, map.get(AssetHandleMeta.CHANGE_INSTANCE_ID)));
			this.setType(DataParser.parse(String.class, map.get(AssetHandleMeta.TYPE)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetHandleMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(AssetHandleMeta.CONTENT)));
			this.setNextApproverIds(DataParser.parse(String.class, map.get(AssetHandleMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, map.get(AssetHandleMeta.APPROVAL_OPINION)));
			this.setChsStatus(DataParser.parse(String.class, map.get(AssetHandleMeta.CHS_STATUS)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetHandleMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetHandleMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetHandleMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetHandleMeta.ORIGINATOR_ID)));
			this.setSummary(DataParser.parse(String.class, map.get(AssetHandleMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, map.get(AssetHandleMeta.NEXT_APPROVER_NAMES)));
			this.setLatestApproverId(DataParser.parse(String.class, map.get(AssetHandleMeta.LATEST_APPROVER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetHandleMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetHandleMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetHandleMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetHandleMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetHandleMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetHandleMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, map.get(AssetHandleMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, map.get(AssetHandleMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetHandleMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetHandleMeta.DELETE_BY)));
			this.setPlanFinishDate(DataParser.parse(Date.class, map.get(AssetHandleMeta.PLAN_FINISH_DATE)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetHandleMeta.STATUS)));
			this.setFileId(DataParser.parse(String.class, map.get(AssetHandleMeta.FILE_ID)));
			// others
			this.setAssetHandleType(DataParser.parse(AssetHandleType.class, map.get(AssetHandleMeta.ASSET_HANDLE_TYPE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetHandleMeta.ORIGINATOR)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(AssetHandleMeta.DEFAULT_PROCESS)));
			return true;
		} else {
			try {
				this.setChsVersion( (String)map.get(AssetHandleMeta.CHS_VERSION));
				this.setNotes( (String)map.get(AssetHandleMeta.NOTES));
				this.setProcId( (String)map.get(AssetHandleMeta.PROC_ID));
				this.setLatestApproverName( (String)map.get(AssetHandleMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)map.get(AssetHandleMeta.CHANGE_INSTANCE_ID));
				this.setType( (String)map.get(AssetHandleMeta.TYPE));
				this.setSelectedCode( (String)map.get(AssetHandleMeta.SELECTED_CODE));
				this.setContent( (String)map.get(AssetHandleMeta.CONTENT));
				this.setNextApproverIds( (String)map.get(AssetHandleMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)map.get(AssetHandleMeta.APPROVAL_OPINION));
				this.setChsStatus( (String)map.get(AssetHandleMeta.CHS_STATUS));
				this.setBusinessCode( (String)map.get(AssetHandleMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)map.get(AssetHandleMeta.UPDATE_BY));
				this.setId( (String)map.get(AssetHandleMeta.ID));
				this.setOriginatorId( (String)map.get(AssetHandleMeta.ORIGINATOR_ID));
				this.setSummary( (String)map.get(AssetHandleMeta.SUMMARY));
				this.setNextApproverNames( (String)map.get(AssetHandleMeta.NEXT_APPROVER_NAMES));
				this.setLatestApproverId( (String)map.get(AssetHandleMeta.LATEST_APPROVER_ID));
				this.setUpdateTime( (Date)map.get(AssetHandleMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetHandleMeta.VERSION));
				this.setCreateBy( (String)map.get(AssetHandleMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetHandleMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetHandleMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetHandleMeta.DELETE_TIME));
				this.setChsType( (String)map.get(AssetHandleMeta.CHS_TYPE));
				this.setName( (String)map.get(AssetHandleMeta.NAME));
				this.setTenantId( (String)map.get(AssetHandleMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetHandleMeta.DELETE_BY));
				this.setPlanFinishDate( (Date)map.get(AssetHandleMeta.PLAN_FINISH_DATE));
				this.setStatus( (String)map.get(AssetHandleMeta.STATUS));
				this.setFileId( (String)map.get(AssetHandleMeta.FILE_ID));
				// others
				this.setAssetHandleType( (AssetHandleType)map.get(AssetHandleMeta.ASSET_HANDLE_TYPE));
				this.setOriginator( (Employee)map.get(AssetHandleMeta.ORIGINATOR));
				this.setDefaultProcess( (ProcessInstance)map.get(AssetHandleMeta.DEFAULT_PROCESS));
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
			this.setChsVersion(DataParser.parse(String.class, r.getValue(AssetHandleMeta.CHS_VERSION)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetHandleMeta.NOTES)));
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetHandleMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, r.getValue(AssetHandleMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, r.getValue(AssetHandleMeta.CHANGE_INSTANCE_ID)));
			this.setType(DataParser.parse(String.class, r.getValue(AssetHandleMeta.TYPE)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetHandleMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetHandleMeta.CONTENT)));
			this.setNextApproverIds(DataParser.parse(String.class, r.getValue(AssetHandleMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, r.getValue(AssetHandleMeta.APPROVAL_OPINION)));
			this.setChsStatus(DataParser.parse(String.class, r.getValue(AssetHandleMeta.CHS_STATUS)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetHandleMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetHandleMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetHandleMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetHandleMeta.ORIGINATOR_ID)));
			this.setSummary(DataParser.parse(String.class, r.getValue(AssetHandleMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, r.getValue(AssetHandleMeta.NEXT_APPROVER_NAMES)));
			this.setLatestApproverId(DataParser.parse(String.class, r.getValue(AssetHandleMeta.LATEST_APPROVER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetHandleMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetHandleMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetHandleMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetHandleMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetHandleMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetHandleMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, r.getValue(AssetHandleMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetHandleMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetHandleMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetHandleMeta.DELETE_BY)));
			this.setPlanFinishDate(DataParser.parse(Date.class, r.getValue(AssetHandleMeta.PLAN_FINISH_DATE)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetHandleMeta.STATUS)));
			this.setFileId(DataParser.parse(String.class, r.getValue(AssetHandleMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setChsVersion( (String)r.getValue(AssetHandleMeta.CHS_VERSION));
				this.setNotes( (String)r.getValue(AssetHandleMeta.NOTES));
				this.setProcId( (String)r.getValue(AssetHandleMeta.PROC_ID));
				this.setLatestApproverName( (String)r.getValue(AssetHandleMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)r.getValue(AssetHandleMeta.CHANGE_INSTANCE_ID));
				this.setType( (String)r.getValue(AssetHandleMeta.TYPE));
				this.setSelectedCode( (String)r.getValue(AssetHandleMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(AssetHandleMeta.CONTENT));
				this.setNextApproverIds( (String)r.getValue(AssetHandleMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)r.getValue(AssetHandleMeta.APPROVAL_OPINION));
				this.setChsStatus( (String)r.getValue(AssetHandleMeta.CHS_STATUS));
				this.setBusinessCode( (String)r.getValue(AssetHandleMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)r.getValue(AssetHandleMeta.UPDATE_BY));
				this.setId( (String)r.getValue(AssetHandleMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetHandleMeta.ORIGINATOR_ID));
				this.setSummary( (String)r.getValue(AssetHandleMeta.SUMMARY));
				this.setNextApproverNames( (String)r.getValue(AssetHandleMeta.NEXT_APPROVER_NAMES));
				this.setLatestApproverId( (String)r.getValue(AssetHandleMeta.LATEST_APPROVER_ID));
				this.setUpdateTime( (Date)r.getValue(AssetHandleMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetHandleMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AssetHandleMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetHandleMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetHandleMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetHandleMeta.DELETE_TIME));
				this.setChsType( (String)r.getValue(AssetHandleMeta.CHS_TYPE));
				this.setName( (String)r.getValue(AssetHandleMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetHandleMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetHandleMeta.DELETE_BY));
				this.setPlanFinishDate( (Date)r.getValue(AssetHandleMeta.PLAN_FINISH_DATE));
				this.setStatus( (String)r.getValue(AssetHandleMeta.STATUS));
				this.setFileId( (String)r.getValue(AssetHandleMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}