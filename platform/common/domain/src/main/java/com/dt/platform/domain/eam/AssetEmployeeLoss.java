package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_EMPLOYEE_LOSS;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetEmployeeLossMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产报失
 * <p>资产报失 , 数据表 eam_asset_employee_loss 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-12-01 13:15:50
 * @sign C41124A18EE14025F05C7D351031B05B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_employee_loss")
@ApiModel(description = "资产报失 ; 资产报失 , 数据表 eam_asset_employee_loss 的PO类型")
public class AssetEmployeeLoss extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_EMPLOYEE_LOSS.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "710492704835895296")
	private String id;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号" , example = "EO202305151405361")
	private String businessCode;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态" , example = "cancel")
	private String status;
	
	/**
	 * 业务名称：业务名称
	*/
	@ApiModelProperty(required = false,value="业务名称" , notes = "业务名称" , example = "121212")
	private String name;
	
	/**
	 * 报失原因：报失原因
	*/
	@ApiModelProperty(required = false,value="报失原因" , notes = "报失原因" , example = "adfadfsdf")
	private String content;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人" , example = "E001")
	private String originatorId;
	
	/**
	 * 记录时间：记录时间
	*/
	@ApiModelProperty(required = false,value="记录时间" , notes = "记录时间")
	private Date recordTime;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-05-15 02:04:21")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-05-16 02:49:44")
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
	@ApiModelProperty(required = false,value="选择数据" , notes = "选择数据" , example = "1684219777000")
	private String selectedCode;
	
	/**
	 * 申请部门：申请部门
	*/
	@ApiModelProperty(required = false,value="申请部门" , notes = "申请部门" , example = "500994919175819264")
	private String orgId;
	
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
	 * 使用公司/部门：使用公司/部门
	*/
	@ApiModelProperty(required = false,value="使用公司/部门" , notes = "使用公司/部门")
	private Organization organization;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 申请人：申请人
	*/
	@ApiModelProperty(required = false,value="申请人" , notes = "申请人")
	private String originatorUserName;
	
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
	public AssetEmployeeLoss setId(String id) {
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
	public AssetEmployeeLoss setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
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
	public AssetEmployeeLoss setStatus(String status) {
		this.status=status;
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
	public AssetEmployeeLoss setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 报失原因<br>
	 * 报失原因
	 * @return 报失原因
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 报失原因
	 * @param content 报失原因
	 * @return 当前对象
	*/
	public AssetEmployeeLoss setContent(String content) {
		this.content=content;
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
	public AssetEmployeeLoss setNotes(String notes) {
		this.notes=notes;
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
	public AssetEmployeeLoss setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
		return this;
	}
	
	/**
	 * 获得 记录时间<br>
	 * 记录时间
	 * @return 记录时间
	*/
	public Date getRecordTime() {
		return recordTime;
	}
	
	/**
	 * 设置 记录时间
	 * @param recordTime 记录时间
	 * @return 当前对象
	*/
	public AssetEmployeeLoss setRecordTime(Date recordTime) {
		this.recordTime=recordTime;
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
	public AssetEmployeeLoss setCreateBy(String createBy) {
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
	public AssetEmployeeLoss setCreateTime(Date createTime) {
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
	public AssetEmployeeLoss setUpdateBy(String updateBy) {
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
	public AssetEmployeeLoss setUpdateTime(Date updateTime) {
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
	public AssetEmployeeLoss setDeleted(Integer deleted) {
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
	public AssetEmployeeLoss setDeleted(Boolean deletedBool) {
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
	public AssetEmployeeLoss setDeleteBy(String deleteBy) {
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
	public AssetEmployeeLoss setDeleteTime(Date deleteTime) {
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
	public AssetEmployeeLoss setVersion(Integer version) {
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
	public AssetEmployeeLoss setTenantId(String tenantId) {
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
	public AssetEmployeeLoss setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 申请部门<br>
	 * 申请部门
	 * @return 申请部门
	*/
	public String getOrgId() {
		return orgId;
	}
	
	/**
	 * 设置 申请部门
	 * @param orgId 申请部门
	 * @return 当前对象
	*/
	public AssetEmployeeLoss setOrgId(String orgId) {
		this.orgId=orgId;
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
	public AssetEmployeeLoss setAssetList(List<Asset> assetList) {
		this.assetList=assetList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public AssetEmployeeLoss addAsset(Asset... asset) {
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
	public AssetEmployeeLoss setAssetIds(List<String> assetIds) {
		this.assetIds=assetIds;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetId 资产列表
	 * @return 当前对象
	*/
	public AssetEmployeeLoss addAssetId(String... assetId) {
		if(this.assetIds==null) assetIds=new ArrayList<>();
		this.assetIds.addAll(Arrays.asList(assetId));
		return this;
	}
	
	/**
	 * 获得 使用公司/部门<br>
	 * 使用公司/部门
	 * @return 使用公司/部门
	*/
	public Organization getOrganization() {
		return organization;
	}
	
	/**
	 * 设置 使用公司/部门
	 * @param organization 使用公司/部门
	 * @return 当前对象
	*/
	public AssetEmployeeLoss setOrganization(Organization organization) {
		this.organization=organization;
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
	public AssetEmployeeLoss setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 申请人<br>
	 * 申请人
	 * @return 申请人
	*/
	public String getOriginatorUserName() {
		return originatorUserName;
	}
	
	/**
	 * 设置 申请人
	 * @param originatorUserName 申请人
	 * @return 当前对象
	*/
	public AssetEmployeeLoss setOriginatorUserName(String originatorUserName) {
		this.originatorUserName=originatorUserName;
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
	public AssetEmployeeLoss setHistoricProcessList(List<ProcessInstance> historicProcessList) {
		this.historicProcessList=historicProcessList;
		return this;
	}
	
	/**
	 * 添加 历史流程清单
	 * @param historicProcess 历史流程清单
	 * @return 当前对象
	*/
	public AssetEmployeeLoss addHistoricProcess(ProcessInstance... historicProcess) {
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
	public AssetEmployeeLoss setCurrentProcessList(List<ProcessInstance> currentProcessList) {
		this.currentProcessList=currentProcessList;
		return this;
	}
	
	/**
	 * 添加 在批的流程清单
	 * @param currentProcess 在批的流程清单
	 * @return 当前对象
	*/
	public AssetEmployeeLoss addCurrentProcess(ProcessInstance... currentProcess) {
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
	public AssetEmployeeLoss setDefaultProcess(ProcessInstance defaultProcess) {
		this.defaultProcess=defaultProcess;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetEmployeeLoss , 转换好的 AssetEmployeeLoss 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetEmployeeLoss , 转换好的 PoJo 对象
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
	public AssetEmployeeLoss clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetEmployeeLoss duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetEmployeeLossMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetEmployeeLossMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setOrgId(this.getOrgId());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setRecordTime(this.getRecordTime());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setOrganization(this.getOrganization());
			inst.setAssetIds(this.getAssetIds());
			inst.setHistoricProcessList(this.getHistoricProcessList());
			inst.setOriginator(this.getOriginator());
			inst.setAssetList(this.getAssetList());
			inst.setOriginatorUserName(this.getOriginatorUserName());
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
	public AssetEmployeeLoss clone(boolean deep) {
		return EntityContext.clone(AssetEmployeeLoss.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetEmployeeLoss
	 * @param assetEmployeeLossMap 包含实体信息的 Map 对象
	 * @return AssetEmployeeLoss , 转换好的的 AssetEmployeeLoss 对象
	*/
	@Transient
	public static AssetEmployeeLoss createFrom(Map<String,Object> assetEmployeeLossMap) {
		if(assetEmployeeLossMap==null) return null;
		AssetEmployeeLoss po = create();
		EntityContext.copyProperties(po,assetEmployeeLossMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetEmployeeLoss
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetEmployeeLoss , 转换好的的 AssetEmployeeLoss 对象
	*/
	@Transient
	public static AssetEmployeeLoss createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetEmployeeLoss po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetEmployeeLoss，等同于 new
	 * @return AssetEmployeeLoss 对象
	*/
	@Transient
	public static AssetEmployeeLoss create() {
		return new com.dt.platform.domain.eam.meta.AssetEmployeeLossMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AssetEmployeeLossMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetEmployeeLossMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetEmployeeLossMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetEmployeeLossMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(AssetEmployeeLossMeta.CONTENT)));
			this.setOrgId(DataParser.parse(String.class, map.get(AssetEmployeeLossMeta.ORG_ID)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetEmployeeLossMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetEmployeeLossMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, map.get(AssetEmployeeLossMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetEmployeeLossMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetEmployeeLossMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetEmployeeLossMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetEmployeeLossMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssetEmployeeLossMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetEmployeeLossMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetEmployeeLossMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetEmployeeLossMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetEmployeeLossMeta.ORIGINATOR_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetEmployeeLossMeta.STATUS)));
			// others
			this.setOrganization(DataParser.parse(Organization.class, map.get(AssetEmployeeLossMeta.ORGANIZATION)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetEmployeeLossMeta.ORIGINATOR)));
			this.setOriginatorUserName(DataParser.parse(String.class, map.get(AssetEmployeeLossMeta.ORIGINATOR_USER_NAME)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(AssetEmployeeLossMeta.DEFAULT_PROCESS)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AssetEmployeeLossMeta.NOTES));
				this.setUpdateTime( (Date)map.get(AssetEmployeeLossMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetEmployeeLossMeta.VERSION));
				this.setSelectedCode( (String)map.get(AssetEmployeeLossMeta.SELECTED_CODE));
				this.setContent( (String)map.get(AssetEmployeeLossMeta.CONTENT));
				this.setOrgId( (String)map.get(AssetEmployeeLossMeta.ORG_ID));
				this.setBusinessCode( (String)map.get(AssetEmployeeLossMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(AssetEmployeeLossMeta.CREATE_BY));
				this.setRecordTime( (Date)map.get(AssetEmployeeLossMeta.RECORD_TIME));
				this.setDeleted( (Integer)map.get(AssetEmployeeLossMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetEmployeeLossMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetEmployeeLossMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetEmployeeLossMeta.DELETE_TIME));
				this.setName( (String)map.get(AssetEmployeeLossMeta.NAME));
				this.setTenantId( (String)map.get(AssetEmployeeLossMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetEmployeeLossMeta.DELETE_BY));
				this.setId( (String)map.get(AssetEmployeeLossMeta.ID));
				this.setOriginatorId( (String)map.get(AssetEmployeeLossMeta.ORIGINATOR_ID));
				this.setStatus( (String)map.get(AssetEmployeeLossMeta.STATUS));
				// others
				this.setOrganization( (Organization)map.get(AssetEmployeeLossMeta.ORGANIZATION));
				this.setOriginator( (Employee)map.get(AssetEmployeeLossMeta.ORIGINATOR));
				this.setOriginatorUserName( (String)map.get(AssetEmployeeLossMeta.ORIGINATOR_USER_NAME));
				this.setDefaultProcess( (ProcessInstance)map.get(AssetEmployeeLossMeta.DEFAULT_PROCESS));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetEmployeeLossMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetEmployeeLossMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetEmployeeLossMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetEmployeeLossMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetEmployeeLossMeta.CONTENT)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(AssetEmployeeLossMeta.ORG_ID)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetEmployeeLossMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetEmployeeLossMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, r.getValue(AssetEmployeeLossMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetEmployeeLossMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetEmployeeLossMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetEmployeeLossMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetEmployeeLossMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetEmployeeLossMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetEmployeeLossMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetEmployeeLossMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetEmployeeLossMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetEmployeeLossMeta.ORIGINATOR_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetEmployeeLossMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AssetEmployeeLossMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(AssetEmployeeLossMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetEmployeeLossMeta.VERSION));
				this.setSelectedCode( (String)r.getValue(AssetEmployeeLossMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(AssetEmployeeLossMeta.CONTENT));
				this.setOrgId( (String)r.getValue(AssetEmployeeLossMeta.ORG_ID));
				this.setBusinessCode( (String)r.getValue(AssetEmployeeLossMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(AssetEmployeeLossMeta.CREATE_BY));
				this.setRecordTime( (Date)r.getValue(AssetEmployeeLossMeta.RECORD_TIME));
				this.setDeleted( (Integer)r.getValue(AssetEmployeeLossMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetEmployeeLossMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetEmployeeLossMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetEmployeeLossMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssetEmployeeLossMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetEmployeeLossMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetEmployeeLossMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetEmployeeLossMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetEmployeeLossMeta.ORIGINATOR_ID));
				this.setStatus( (String)r.getValue(AssetEmployeeLossMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}