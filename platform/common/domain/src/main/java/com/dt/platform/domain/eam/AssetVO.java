package com.dt.platform.domain.eam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.github.foxnic.api.model.CompositeParameter;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import java.util.Map;



/**
 * 资产VO类型
 * <p>资产 , 数据表 eam_asset 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-25 20:25:32
 * @sign C05127D02CE5B4FBBB8CDA17B7C59FAA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "资产VO类型 ; 资产 , 数据表 eam_asset 的通用VO类型" , parent = Asset.class)
public class AssetVO extends Asset {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 页码
	*/
	@ApiModelProperty(required = false,value="页码" , notes = "")
	private Integer pageIndex;
	
	/**
	 * 分页大小
	*/
	@ApiModelProperty(required = false,value="分页大小" , notes = "")
	private Integer pageSize;
	
	/**
	 * 搜索字段
	*/
	@ApiModelProperty(required = false,value="搜索字段" , notes = "")
	private String searchField;
	
	/**
	 * 模糊搜索字段
	*/
	@ApiModelProperty(required = false,value="模糊搜索字段" , notes = "")
	private String fuzzyField;
	
	/**
	 * 搜索的值
	*/
	@ApiModelProperty(required = false,value="搜索的值" , notes = "")
	private String searchValue;
	
	/**
	 * 已修改字段
	*/
	@ApiModelProperty(required = false,value="已修改字段" , notes = "")
	private List<String> dirtyFields;
	
	/**
	 * 排序字段
	*/
	@ApiModelProperty(required = false,value="排序字段" , notes = "")
	private String sortField;
	
	/**
	 * 排序方式
	*/
	@ApiModelProperty(required = false,value="排序方式" , notes = "")
	private String sortType;
	
	/**
	 * 主键清单：用于接收批量主键参数
	*/
	@ApiModelProperty(required = false,value="主键清单" , notes = "用于接收批量主键参数")
	private List<String> ids;
	
	/**
	 * 获得 页码<br>
	 * @return 页码
	*/
	public Integer getPageIndex() {
		return pageIndex;
	}
	
	/**
	 * 设置 页码
	 * @param pageIndex 页码
	 * @return 当前对象
	*/
	public AssetVO setPageIndex(Integer pageIndex) {
		this.pageIndex=pageIndex;
		return this;
	}
	
	/**
	 * 获得 分页大小<br>
	 * @return 分页大小
	*/
	public Integer getPageSize() {
		return pageSize;
	}
	
	/**
	 * 设置 分页大小
	 * @param pageSize 分页大小
	 * @return 当前对象
	*/
	public AssetVO setPageSize(Integer pageSize) {
		this.pageSize=pageSize;
		return this;
	}
	
	/**
	 * 获得 搜索字段<br>
	 * @return 搜索字段
	*/
	public String getSearchField() {
		return searchField;
	}
	
	/**
	 * 设置 搜索字段
	 * @param searchField 搜索字段
	 * @return 当前对象
	*/
	public AssetVO setSearchField(String searchField) {
		this.searchField=searchField;
		return this;
	}
	
	/**
	 * 获得 模糊搜索字段<br>
	 * @return 模糊搜索字段
	*/
	public String getFuzzyField() {
		return fuzzyField;
	}
	
	/**
	 * 设置 模糊搜索字段
	 * @param fuzzyField 模糊搜索字段
	 * @return 当前对象
	*/
	public AssetVO setFuzzyField(String fuzzyField) {
		this.fuzzyField=fuzzyField;
		return this;
	}
	
	/**
	 * 获得 搜索的值<br>
	 * @return 搜索的值
	*/
	public String getSearchValue() {
		return searchValue;
	}
	
	/**
	 * 设置 搜索的值
	 * @param searchValue 搜索的值
	 * @return 当前对象
	*/
	public AssetVO setSearchValue(String searchValue) {
		this.searchValue=searchValue;
		return this;
	}
	
	/**
	 * 获得 已修改字段<br>
	 * @return 已修改字段
	*/
	public List<String> getDirtyFields() {
		return dirtyFields;
	}
	
	/**
	 * 设置 已修改字段
	 * @param dirtyFields 已修改字段
	 * @return 当前对象
	*/
	public AssetVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetVO addDirtyField(String... dirtyField) {
		if(this.dirtyFields==null) dirtyFields=new ArrayList<>();
		this.dirtyFields.addAll(Arrays.asList(dirtyField));
		return this;
	}
	
	/**
	 * 获得 排序字段<br>
	 * @return 排序字段
	*/
	public String getSortField() {
		return sortField;
	}
	
	/**
	 * 设置 排序字段
	 * @param sortField 排序字段
	 * @return 当前对象
	*/
	public AssetVO setSortField(String sortField) {
		this.sortField=sortField;
		return this;
	}
	
	/**
	 * 获得 排序方式<br>
	 * @return 排序方式
	*/
	public String getSortType() {
		return sortType;
	}
	
	/**
	 * 设置 排序方式
	 * @param sortType 排序方式
	 * @return 当前对象
	*/
	public AssetVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 主键清单<br>
	 * 用于接收批量主键参数
	 * @return 主键清单
	*/
	public List<String> getIds() {
		return ids;
	}
	
	/**
	 * 设置 主键清单
	 * @param ids 主键清单
	 * @return 当前对象
	*/
	public AssetVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	@Transient
	private transient CompositeParameter $compositeParameter;
	/**
	 * 获得解析后的复合查询参数
	 */
	@Transient
	public CompositeParameter getCompositeParameter() {
		if($compositeParameter!=null) return  $compositeParameter;
		$compositeParameter=new CompositeParameter(this.getSearchValue(),BeanUtil.toMap(this));
		return  $compositeParameter;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetVO , 转换好的 AssetVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetVO , 转换好的 PoJo 对象
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
	public AssetVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetVOMeta.$$proxy$$();
		inst.setEquipmentCode(this.getEquipmentCode());
		inst.setPurchaseUnitPrice(this.getPurchaseUnitPrice());
		inst.setApprovalOpinion(this.getApprovalOpinion());
		inst.setMaintenanceStatus(this.getMaintenanceStatus());
		inst.setNavPrice(this.getNavPrice());
		inst.setLabel4(this.getLabel4());
		inst.setLabel5(this.getLabel5());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setAssetNumber(this.getAssetNumber());
		inst.setModel(this.getModel());
		inst.setId(this.getId());
		inst.setEquipmentEnvironmentCode(this.getEquipmentEnvironmentCode());
		inst.setDirector(this.getDirector());
		inst.setMonthDepreciationPrice(this.getMonthDepreciationPrice());
		inst.setVersion(this.getVersion());
		inst.setSafetyLevelCode(this.getSafetyLevelCode());
		inst.setMaintainerId(this.getMaintainerId());
		inst.setMaintenanceNotes(this.getMaintenanceNotes());
		inst.setEntryTime(this.getEntryTime());
		inst.setManageIp(this.getManageIp());
		inst.setWarehouseId(this.getWarehouseId());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setFinancialNotes(this.getFinancialNotes());
		inst.setStatus(this.getStatus());
		inst.setPurchaseDate(this.getPurchaseDate());
		inst.setOwnerCode(this.getOwnerCode());
		inst.setRemainNumber(this.getRemainNumber());
		inst.setGoodsId(this.getGoodsId());
		inst.setChangeInstanceId(this.getChangeInstanceId());
		inst.setEquipmentConf(this.getEquipmentConf());
		inst.setAssetNotes(this.getAssetNotes());
		inst.setOriginalUnitPrice(this.getOriginalUnitPrice());
		inst.setPictureId(this.getPictureId());
		inst.setTotalAmountPrice(this.getTotalAmountPrice());
		inst.setServiceLife(this.getServiceLife());
		inst.setAttach(this.getAttach());
		inst.setMaintainerName(this.getMaintainerName());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setCleanOut(this.getCleanOut());
		inst.setRackId(this.getRackId());
		inst.setDisplay(this.getDisplay());
		inst.setManufacturerId(this.getManufacturerId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setCategoryCode(this.getCategoryCode());
		inst.setManagerId(this.getManagerId());
		inst.setAccumulatedDepreciation(this.getAccumulatedDepreciation());
		inst.setLabel2(this.getLabel2());
		inst.setLabel3(this.getLabel3());
		inst.setAssetSelectedData(this.getAssetSelectedData());
		inst.setDeleted(this.getDeleted());
		inst.setPositionId(this.getPositionId());
		inst.setCreateTime(this.getCreateTime());
		inst.setTenantId(this.getTenantId());
		inst.setRfid(this.getRfid());
		inst.setMaintenanceStartDate(this.getMaintenanceStartDate());
		inst.setLastVerificationDate(this.getLastVerificationDate());
		inst.setUseUserId(this.getUseUserId());
		inst.setContacts(this.getContacts());
		inst.setSourceId(this.getSourceId());
		inst.setProcId(this.getProcId());
		inst.setFinancialCategoryId(this.getFinancialCategoryId());
		inst.setEquipmentIp(this.getEquipmentIp());
		inst.setMaintenanceEndDate(this.getMaintenanceEndDate());
		inst.setNextApproverNames(this.getNextApproverNames());
		inst.setAssetCode(this.getAssetCode());
		inst.setSerialNumber(this.getSerialNumber());
		inst.setLatestApproverId(this.getLatestApproverId());
		inst.setGoodsStockId(this.getGoodsStockId());
		inst.setTaxAmountRate(this.getTaxAmountRate());
		inst.setCurrentYearDepreciation(this.getCurrentYearDepreciation());
		inst.setUseOrganizationId(this.getUseOrganizationId());
		inst.setEquipmentLabel(this.getEquipmentLabel());
		inst.setUnit(this.getUnit());
		inst.setOwnCompanyId(this.getOwnCompanyId());
		inst.setBillId(this.getBillId());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setFinancialCode(this.getFinancialCode());
		inst.setRackUpNumber(this.getRackUpNumber());
		inst.setResidualsRate(this.getResidualsRate());
		inst.setAssetStatus(this.getAssetStatus());
		inst.setChsVersion(this.getChsVersion());
		inst.setSupplierId(this.getSupplierId());
		inst.setPurpose(this.getPurpose());
		inst.setResidualsPrice(this.getResidualsPrice());
		inst.setInternalControlLabel(this.getInternalControlLabel());
		inst.setLatestApproverName(this.getLatestApproverName());
		inst.setNextApproverIds(this.getNextApproverIds());
		inst.setChsStatus(this.getChsStatus());
		inst.setProductionDate(this.getProductionDate());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setRegisterDate(this.getRegisterDate());
		inst.setSummary(this.getSummary());
		inst.setEquipmentSerialNumber(this.getEquipmentSerialNumber());
		inst.setBatchCode(this.getBatchCode());
		inst.setEquipmentCpu(this.getEquipmentCpu());
		inst.setEquipmentMemory(this.getEquipmentMemory());
		inst.setLabel(this.getLabel());
		inst.setEquipmentStatus(this.getEquipmentStatus());
		inst.setPositionDetail(this.getPositionDetail());
		inst.setDepreciationYear(this.getDepreciationYear());
		inst.setCreateBy(this.getCreateBy());
		inst.setContactInformation(this.getContactInformation());
		inst.setTaxAmountPrice(this.getTaxAmountPrice());
		inst.setRegionId(this.getRegionId());
		inst.setChsType(this.getChsType());
		inst.setRackDownNumber(this.getRackDownNumber());
		inst.setCategoryId(this.getCategoryId());
		if(all) {
			inst.setOwnerCompany(this.getOwnerCompany());
			inst.setSafetyLevel(this.getSafetyLevel());
			inst.setSearchField(this.getSearchField());
			inst.setCategoryFinance(this.getCategoryFinance());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setGoods(this.getGoods());
			inst.setPageSize(this.getPageSize());
			inst.setOriginator(this.getOriginator());
			inst.setSource(this.getSource());
			inst.setManufacturer(this.getManufacturer());
			inst.setCatalogAttribute(this.getCatalogAttribute());
			inst.setSupplier(this.getSupplier());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setUseUser(this.getUseUser());
			inst.setEquipmentEnvironment(this.getEquipmentEnvironment());
			inst.setAssetCycleStatus(this.getAssetCycleStatus());
			inst.setRack(this.getRack());
			inst.setManager(this.getManager());
			inst.setWarehouse(this.getWarehouse());
			inst.setPcmData(this.getPcmData());
			inst.setGoodsStock(this.getGoodsStock());
			inst.setUseOrganization(this.getUseOrganization());
			inst.setChangeInstance(this.getChangeInstance());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setExtData(this.getExtData());
			inst.setMaintnainer(this.getMaintnainer());
			inst.setAssetMaintenanceStatus(this.getAssetMaintenanceStatus());
			inst.setIds(this.getIds());
			inst.setPosition(this.getPosition());
			inst.setCategory(this.getCategory());
			inst.setRegion(this.getRegion());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetVO clone(boolean deep) {
		return EntityContext.clone(AssetVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetVO
	 * @param assetMap 包含实体信息的 Map 对象
	 * @return AssetVO , 转换好的的 Asset 对象
	*/
	@Transient
	public static AssetVO createFrom(Map<String,Object> assetMap) {
		if(assetMap==null) return null;
		AssetVO vo = create();
		EntityContext.copyProperties(vo,assetMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetVO , 转换好的的 Asset 对象
	*/
	@Transient
	public static AssetVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetVO，等同于 new
	 * @return AssetVO 对象
	*/
	@Transient
	public static AssetVO create() {
		return new com.dt.platform.domain.eam.meta.AssetVOMeta.$$proxy$$();
	}
}