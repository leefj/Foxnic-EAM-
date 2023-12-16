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
import com.dt.platform.domain.eam.meta.GoodsStockVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.pcm.Catalog;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 库存物品VO类型
 * <p>库存物品 , 数据表 eam_goods_stock 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-12-16 22:49:59
 * @sign 87176F150B412C151E8EC61D5D9C451A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "库存物品VO类型 ; 库存物品 , 数据表 eam_goods_stock 的通用VO类型" , parent = GoodsStock.class)
public class GoodsStockVO extends GoodsStock {

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
	 * 数据来源：前端指定不同的来源，后端可按来源执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "前端指定不同的来源，后端可按来源执行不同的逻辑")
	private String dataOrigin;
	
	/**
	 * 查询逻辑：默认and，可指定 or 
	*/
	@ApiModelProperty(required = false,value="查询逻辑" , notes = "默认and，可指定 or ")
	private String queryLogic;
	
	/**
	 * 请求动作：前端指定不同的Action，后端可Action执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="请求动作" , notes = "前端指定不同的Action，后端可Action执行不同的逻辑")
	private String requestAction;
	
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
	public GoodsStockVO setPageIndex(Integer pageIndex) {
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
	public GoodsStockVO setPageSize(Integer pageSize) {
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
	public GoodsStockVO setSearchField(String searchField) {
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
	public GoodsStockVO setFuzzyField(String fuzzyField) {
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
	public GoodsStockVO setSearchValue(String searchValue) {
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
	public GoodsStockVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public GoodsStockVO addDirtyField(String... dirtyField) {
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
	public GoodsStockVO setSortField(String sortField) {
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
	public GoodsStockVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 前端指定不同的来源，后端可按来源执行不同的逻辑
	 * @return 数据来源
	*/
	public String getDataOrigin() {
		return dataOrigin;
	}
	
	/**
	 * 设置 数据来源
	 * @param dataOrigin 数据来源
	 * @return 当前对象
	*/
	public GoodsStockVO setDataOrigin(String dataOrigin) {
		this.dataOrigin=dataOrigin;
		return this;
	}
	
	/**
	 * 获得 查询逻辑<br>
	 * 默认and，可指定 or 
	 * @return 查询逻辑
	*/
	public String getQueryLogic() {
		return queryLogic;
	}
	
	/**
	 * 设置 查询逻辑
	 * @param queryLogic 查询逻辑
	 * @return 当前对象
	*/
	public GoodsStockVO setQueryLogic(String queryLogic) {
		this.queryLogic=queryLogic;
		return this;
	}
	
	/**
	 * 获得 请求动作<br>
	 * 前端指定不同的Action，后端可Action执行不同的逻辑
	 * @return 请求动作
	*/
	public String getRequestAction() {
		return requestAction;
	}
	
	/**
	 * 设置 请求动作
	 * @param requestAction 请求动作
	 * @return 当前对象
	*/
	public GoodsStockVO setRequestAction(String requestAction) {
		this.requestAction=requestAction;
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
	public GoodsStockVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public GoodsStockVO addId(String... id) {
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
	 * @return GoodsStockVO , 转换好的 GoodsStockVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return GoodsStockVO , 转换好的 PoJo 对象
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
	public GoodsStockVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public GoodsStockVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.GoodsStockVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.GoodsStockVOMeta.$$proxy$$();
		inst.setOwnerType(this.getOwnerType());
		inst.setSourceId(this.getSourceId());
		inst.setInterOperType(this.getInterOperType());
		inst.setNotes(this.getNotes());
		inst.setStockSecurity(this.getStockSecurity());
		inst.setOwnerTmpId(this.getOwnerTmpId());
		inst.setPid(this.getPid());
		inst.setOwnerId(this.getOwnerId());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setModel(this.getModel());
		inst.setId(this.getId());
		inst.setUnitPrice(this.getUnitPrice());
		inst.setVersion(this.getVersion());
		inst.setBarCode(this.getBarCode());
		inst.setUnit(this.getUnit());
		inst.setOwnCompanyId(this.getOwnCompanyId());
		inst.setWarehouseId(this.getWarehouseId());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setBrandId(this.getBrandId());
		inst.setAssetCategoryId(this.getAssetCategoryId());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		inst.setCode(this.getCode());
		inst.setOwnerCode(this.getOwnerCode());
		inst.setGoodsId(this.getGoodsId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setStockMin(this.getStockMin());
		inst.setPictureId(this.getPictureId());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setSupplierName(this.getSupplierName());
		inst.setStockInNumber(this.getStockInNumber());
		inst.setAmount(this.getAmount());
		inst.setStockMax(this.getStockMax());
		inst.setUseOrgId(this.getUseOrgId());
		inst.setBatchCode(this.getBatchCode());
		inst.setManufacturerId(this.getManufacturerId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setManagerId(this.getManagerId());
		inst.setStorageDate(this.getStorageDate());
		inst.setStockCurNumber(this.getStockCurNumber());
		inst.setCreateBy(this.getCreateBy());
		inst.setRealStockId(this.getRealStockId());
		inst.setDeleted(this.getDeleted());
		inst.setGoodsStatus(this.getGoodsStatus());
		inst.setCreateTime(this.getCreateTime());
		inst.setTenantId(this.getTenantId());
		inst.setCategoryId(this.getCategoryId());
		if(all) {
			inst.setOwnerCompany(this.getOwnerCompany());
			inst.setGoodsStockSecurity(this.getGoodsStockSecurity());
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setGoods(this.getGoods());
			inst.setPageSize(this.getPageSize());
			inst.setSource(this.getSource());
			inst.setOriginator(this.getOriginator());
			inst.setGoodsModel(this.getGoodsModel());
			inst.setManufacturer(this.getManufacturer());
			inst.setGoodsBarCode(this.getGoodsBarCode());
			inst.setSubGoodsStockList(this.getSubGoodsStockList());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setGoodsUnit(this.getGoodsUnit());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setBrand(this.getBrand());
			inst.setGoodsName(this.getGoodsName());
			inst.setGoodsStockMax(this.getGoodsStockMax());
			inst.setManager(this.getManager());
			inst.setRequestAction(this.getRequestAction());
			inst.setGoodsStockMin(this.getGoodsStockMin());
			inst.setParentGoodsStock(this.getParentGoodsStock());
			inst.setWarehouse(this.getWarehouse());
			inst.setRealGoods(this.getRealGoods());
			inst.setUseOrganization(this.getUseOrganization());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setGoodsCategoryName(this.getGoodsCategoryName());
			inst.setGoodsStockNotes(this.getGoodsStockNotes());
			inst.setIds(this.getIds());
			inst.setGoodsCode(this.getGoodsCode());
			inst.setCategory(this.getCategory());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public GoodsStockVO clone(boolean deep) {
		return EntityContext.clone(GoodsStockVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 GoodsStockVO
	 * @param goodsStockMap 包含实体信息的 Map 对象
	 * @return GoodsStockVO , 转换好的的 GoodsStock 对象
	*/
	@Transient
	public static GoodsStockVO createFrom(Map<String,Object> goodsStockMap) {
		if(goodsStockMap==null) return null;
		GoodsStockVO vo = create();
		EntityContext.copyProperties(vo,goodsStockMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 GoodsStockVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return GoodsStockVO , 转换好的的 GoodsStock 对象
	*/
	@Transient
	public static GoodsStockVO createFrom(Object pojo) {
		if(pojo==null) return null;
		GoodsStockVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 GoodsStockVO，等同于 new
	 * @return GoodsStockVO 对象
	*/
	@Transient
	public static GoodsStockVO create() {
		return new com.dt.platform.domain.eam.meta.GoodsStockVOMeta.$$proxy$$();
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
			this.setOwnerType(DataParser.parse(String.class, map.get(GoodsStockVOMeta.OWNER_TYPE)));
			this.setSourceId(DataParser.parse(String.class, map.get(GoodsStockVOMeta.SOURCE_ID)));
			this.setInterOperType(DataParser.parse(String.class, map.get(GoodsStockVOMeta.INTER_OPER_TYPE)));
			this.setNotes(DataParser.parse(String.class, map.get(GoodsStockVOMeta.NOTES)));
			this.setStockSecurity(DataParser.parse(BigDecimal.class, map.get(GoodsStockVOMeta.STOCK_SECURITY)));
			this.setOwnerTmpId(DataParser.parse(String.class, map.get(GoodsStockVOMeta.OWNER_TMP_ID)));
			this.setPid(DataParser.parse(String.class, map.get(GoodsStockVOMeta.PID)));
			this.setOwnerId(DataParser.parse(String.class, map.get(GoodsStockVOMeta.OWNER_ID)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(GoodsStockVOMeta.BUSINESS_CODE)));
			this.setModel(DataParser.parse(String.class, map.get(GoodsStockVOMeta.MODEL)));
			this.setId(DataParser.parse(String.class, map.get(GoodsStockVOMeta.ID)));
			this.setUnitPrice(DataParser.parse(BigDecimal.class, map.get(GoodsStockVOMeta.UNIT_PRICE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(GoodsStockVOMeta.VERSION)));
			this.setBarCode(DataParser.parse(String.class, map.get(GoodsStockVOMeta.BAR_CODE)));
			this.setUnit(DataParser.parse(String.class, map.get(GoodsStockVOMeta.UNIT)));
			this.setOwnCompanyId(DataParser.parse(String.class, map.get(GoodsStockVOMeta.OWN_COMPANY_ID)));
			this.setWarehouseId(DataParser.parse(String.class, map.get(GoodsStockVOMeta.WAREHOUSE_ID)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(GoodsStockVOMeta.DELETE_TIME)));
			this.setBrandId(DataParser.parse(String.class, map.get(GoodsStockVOMeta.BRAND_ID)));
			this.setAssetCategoryId(DataParser.parse(String.class, map.get(GoodsStockVOMeta.ASSET_CATEGORY_ID)));
			this.setName(DataParser.parse(String.class, map.get(GoodsStockVOMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(GoodsStockVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(GoodsStockVOMeta.STATUS)));
			this.setCode(DataParser.parse(String.class, map.get(GoodsStockVOMeta.CODE)));
			this.setOwnerCode(DataParser.parse(String.class, map.get(GoodsStockVOMeta.OWNER_CODE)));
			this.setGoodsId(DataParser.parse(String.class, map.get(GoodsStockVOMeta.GOODS_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(GoodsStockVOMeta.SELECTED_CODE)));
			this.setStockMin(DataParser.parse(BigDecimal.class, map.get(GoodsStockVOMeta.STOCK_MIN)));
			this.setPictureId(DataParser.parse(String.class, map.get(GoodsStockVOMeta.PICTURE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(GoodsStockVOMeta.UPDATE_BY)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(GoodsStockVOMeta.ORIGINATOR_ID)));
			this.setSupplierName(DataParser.parse(String.class, map.get(GoodsStockVOMeta.SUPPLIER_NAME)));
			this.setStockInNumber(DataParser.parse(BigDecimal.class, map.get(GoodsStockVOMeta.STOCK_IN_NUMBER)));
			this.setAmount(DataParser.parse(BigDecimal.class, map.get(GoodsStockVOMeta.AMOUNT)));
			this.setStockMax(DataParser.parse(BigDecimal.class, map.get(GoodsStockVOMeta.STOCK_MAX)));
			this.setUseOrgId(DataParser.parse(String.class, map.get(GoodsStockVOMeta.USE_ORG_ID)));
			this.setBatchCode(DataParser.parse(String.class, map.get(GoodsStockVOMeta.BATCH_CODE)));
			this.setManufacturerId(DataParser.parse(String.class, map.get(GoodsStockVOMeta.MANUFACTURER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(GoodsStockVOMeta.UPDATE_TIME)));
			this.setManagerId(DataParser.parse(String.class, map.get(GoodsStockVOMeta.MANAGER_ID)));
			this.setStorageDate(DataParser.parse(Date.class, map.get(GoodsStockVOMeta.STORAGE_DATE)));
			this.setStockCurNumber(DataParser.parse(BigDecimal.class, map.get(GoodsStockVOMeta.STOCK_CUR_NUMBER)));
			this.setCreateBy(DataParser.parse(String.class, map.get(GoodsStockVOMeta.CREATE_BY)));
			this.setRealStockId(DataParser.parse(String.class, map.get(GoodsStockVOMeta.REAL_STOCK_ID)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(GoodsStockVOMeta.DELETED)));
			this.setGoodsStatus(DataParser.parse(String.class, map.get(GoodsStockVOMeta.GOODS_STATUS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(GoodsStockVOMeta.CREATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(GoodsStockVOMeta.TENANT_ID)));
			this.setCategoryId(DataParser.parse(String.class, map.get(GoodsStockVOMeta.CATEGORY_ID)));
			// others
			this.setOwnerCompany(DataParser.parse(Organization.class, map.get(GoodsStockVOMeta.OWNER_COMPANY)));
			this.setGoodsStockSecurity(DataParser.parse(String.class, map.get(GoodsStockVOMeta.GOODS_STOCK_SECURITY)));
			this.setSearchField(DataParser.parse(String.class, map.get(GoodsStockVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(GoodsStockVOMeta.FUZZY_FIELD)));
			this.setGoods(DataParser.parse(GoodsStock.class, map.get(GoodsStockVOMeta.GOODS)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(GoodsStockVOMeta.PAGE_SIZE)));
			this.setSource(DataParser.parse(DictItem.class, map.get(GoodsStockVOMeta.SOURCE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(GoodsStockVOMeta.ORIGINATOR)));
			this.setGoodsModel(DataParser.parse(String.class, map.get(GoodsStockVOMeta.GOODS_MODEL)));
			this.setManufacturer(DataParser.parse(Manufacturer.class, map.get(GoodsStockVOMeta.MANUFACTURER)));
			this.setGoodsBarCode(DataParser.parse(String.class, map.get(GoodsStockVOMeta.GOODS_BAR_CODE)));
			this.setSortField(DataParser.parse(String.class, map.get(GoodsStockVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(GoodsStockVOMeta.DATA_ORIGIN)));
			this.setGoodsUnit(DataParser.parse(String.class, map.get(GoodsStockVOMeta.GOODS_UNIT)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(GoodsStockVOMeta.QUERY_LOGIC)));
			this.setBrand(DataParser.parse(Brand.class, map.get(GoodsStockVOMeta.BRAND)));
			this.setGoodsName(DataParser.parse(String.class, map.get(GoodsStockVOMeta.GOODS_NAME)));
			this.setGoodsStockMax(DataParser.parse(String.class, map.get(GoodsStockVOMeta.GOODS_STOCK_MAX)));
			this.setManager(DataParser.parse(Employee.class, map.get(GoodsStockVOMeta.MANAGER)));
			this.setRequestAction(DataParser.parse(String.class, map.get(GoodsStockVOMeta.REQUEST_ACTION)));
			this.setGoodsStockMin(DataParser.parse(String.class, map.get(GoodsStockVOMeta.GOODS_STOCK_MIN)));
			this.setParentGoodsStock(DataParser.parse(GoodsStock.class, map.get(GoodsStockVOMeta.PARENT_GOODS_STOCK)));
			this.setWarehouse(DataParser.parse(Warehouse.class, map.get(GoodsStockVOMeta.WAREHOUSE)));
			this.setRealGoods(DataParser.parse(GoodsStock.class, map.get(GoodsStockVOMeta.REAL_GOODS)));
			this.setUseOrganization(DataParser.parse(Organization.class, map.get(GoodsStockVOMeta.USE_ORGANIZATION)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(GoodsStockVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(GoodsStockVOMeta.SORT_TYPE)));
			this.setGoodsCategoryName(DataParser.parse(String.class, map.get(GoodsStockVOMeta.GOODS_CATEGORY_NAME)));
			this.setGoodsStockNotes(DataParser.parse(String.class, map.get(GoodsStockVOMeta.GOODS_STOCK_NOTES)));
			this.setGoodsCode(DataParser.parse(String.class, map.get(GoodsStockVOMeta.GOODS_CODE)));
			this.setCategory(DataParser.parse(Catalog.class, map.get(GoodsStockVOMeta.CATEGORY)));
			this.setSearchValue(DataParser.parse(String.class, map.get(GoodsStockVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)map.get(GoodsStockVOMeta.OWNER_TYPE));
				this.setSourceId( (String)map.get(GoodsStockVOMeta.SOURCE_ID));
				this.setInterOperType( (String)map.get(GoodsStockVOMeta.INTER_OPER_TYPE));
				this.setNotes( (String)map.get(GoodsStockVOMeta.NOTES));
				this.setStockSecurity( (BigDecimal)map.get(GoodsStockVOMeta.STOCK_SECURITY));
				this.setOwnerTmpId( (String)map.get(GoodsStockVOMeta.OWNER_TMP_ID));
				this.setPid( (String)map.get(GoodsStockVOMeta.PID));
				this.setOwnerId( (String)map.get(GoodsStockVOMeta.OWNER_ID));
				this.setBusinessCode( (String)map.get(GoodsStockVOMeta.BUSINESS_CODE));
				this.setModel( (String)map.get(GoodsStockVOMeta.MODEL));
				this.setId( (String)map.get(GoodsStockVOMeta.ID));
				this.setUnitPrice( (BigDecimal)map.get(GoodsStockVOMeta.UNIT_PRICE));
				this.setVersion( (Integer)map.get(GoodsStockVOMeta.VERSION));
				this.setBarCode( (String)map.get(GoodsStockVOMeta.BAR_CODE));
				this.setUnit( (String)map.get(GoodsStockVOMeta.UNIT));
				this.setOwnCompanyId( (String)map.get(GoodsStockVOMeta.OWN_COMPANY_ID));
				this.setWarehouseId( (String)map.get(GoodsStockVOMeta.WAREHOUSE_ID));
				this.setDeleteTime( (Date)map.get(GoodsStockVOMeta.DELETE_TIME));
				this.setBrandId( (String)map.get(GoodsStockVOMeta.BRAND_ID));
				this.setAssetCategoryId( (String)map.get(GoodsStockVOMeta.ASSET_CATEGORY_ID));
				this.setName( (String)map.get(GoodsStockVOMeta.NAME));
				this.setDeleteBy( (String)map.get(GoodsStockVOMeta.DELETE_BY));
				this.setStatus( (String)map.get(GoodsStockVOMeta.STATUS));
				this.setCode( (String)map.get(GoodsStockVOMeta.CODE));
				this.setOwnerCode( (String)map.get(GoodsStockVOMeta.OWNER_CODE));
				this.setGoodsId( (String)map.get(GoodsStockVOMeta.GOODS_ID));
				this.setSelectedCode( (String)map.get(GoodsStockVOMeta.SELECTED_CODE));
				this.setStockMin( (BigDecimal)map.get(GoodsStockVOMeta.STOCK_MIN));
				this.setPictureId( (String)map.get(GoodsStockVOMeta.PICTURE_ID));
				this.setUpdateBy( (String)map.get(GoodsStockVOMeta.UPDATE_BY));
				this.setOriginatorId( (String)map.get(GoodsStockVOMeta.ORIGINATOR_ID));
				this.setSupplierName( (String)map.get(GoodsStockVOMeta.SUPPLIER_NAME));
				this.setStockInNumber( (BigDecimal)map.get(GoodsStockVOMeta.STOCK_IN_NUMBER));
				this.setAmount( (BigDecimal)map.get(GoodsStockVOMeta.AMOUNT));
				this.setStockMax( (BigDecimal)map.get(GoodsStockVOMeta.STOCK_MAX));
				this.setUseOrgId( (String)map.get(GoodsStockVOMeta.USE_ORG_ID));
				this.setBatchCode( (String)map.get(GoodsStockVOMeta.BATCH_CODE));
				this.setManufacturerId( (String)map.get(GoodsStockVOMeta.MANUFACTURER_ID));
				this.setUpdateTime( (Date)map.get(GoodsStockVOMeta.UPDATE_TIME));
				this.setManagerId( (String)map.get(GoodsStockVOMeta.MANAGER_ID));
				this.setStorageDate( (Date)map.get(GoodsStockVOMeta.STORAGE_DATE));
				this.setStockCurNumber( (BigDecimal)map.get(GoodsStockVOMeta.STOCK_CUR_NUMBER));
				this.setCreateBy( (String)map.get(GoodsStockVOMeta.CREATE_BY));
				this.setRealStockId( (String)map.get(GoodsStockVOMeta.REAL_STOCK_ID));
				this.setDeleted( (Integer)map.get(GoodsStockVOMeta.DELETED));
				this.setGoodsStatus( (String)map.get(GoodsStockVOMeta.GOODS_STATUS));
				this.setCreateTime( (Date)map.get(GoodsStockVOMeta.CREATE_TIME));
				this.setTenantId( (String)map.get(GoodsStockVOMeta.TENANT_ID));
				this.setCategoryId( (String)map.get(GoodsStockVOMeta.CATEGORY_ID));
				// others
				this.setOwnerCompany( (Organization)map.get(GoodsStockVOMeta.OWNER_COMPANY));
				this.setGoodsStockSecurity( (String)map.get(GoodsStockVOMeta.GOODS_STOCK_SECURITY));
				this.setSearchField( (String)map.get(GoodsStockVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(GoodsStockVOMeta.FUZZY_FIELD));
				this.setGoods( (GoodsStock)map.get(GoodsStockVOMeta.GOODS));
				this.setPageSize( (Integer)map.get(GoodsStockVOMeta.PAGE_SIZE));
				this.setSource( (DictItem)map.get(GoodsStockVOMeta.SOURCE));
				this.setOriginator( (Employee)map.get(GoodsStockVOMeta.ORIGINATOR));
				this.setGoodsModel( (String)map.get(GoodsStockVOMeta.GOODS_MODEL));
				this.setManufacturer( (Manufacturer)map.get(GoodsStockVOMeta.MANUFACTURER));
				this.setGoodsBarCode( (String)map.get(GoodsStockVOMeta.GOODS_BAR_CODE));
				this.setSortField( (String)map.get(GoodsStockVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(GoodsStockVOMeta.DATA_ORIGIN));
				this.setGoodsUnit( (String)map.get(GoodsStockVOMeta.GOODS_UNIT));
				this.setQueryLogic( (String)map.get(GoodsStockVOMeta.QUERY_LOGIC));
				this.setBrand( (Brand)map.get(GoodsStockVOMeta.BRAND));
				this.setGoodsName( (String)map.get(GoodsStockVOMeta.GOODS_NAME));
				this.setGoodsStockMax( (String)map.get(GoodsStockVOMeta.GOODS_STOCK_MAX));
				this.setManager( (Employee)map.get(GoodsStockVOMeta.MANAGER));
				this.setRequestAction( (String)map.get(GoodsStockVOMeta.REQUEST_ACTION));
				this.setGoodsStockMin( (String)map.get(GoodsStockVOMeta.GOODS_STOCK_MIN));
				this.setParentGoodsStock( (GoodsStock)map.get(GoodsStockVOMeta.PARENT_GOODS_STOCK));
				this.setWarehouse( (Warehouse)map.get(GoodsStockVOMeta.WAREHOUSE));
				this.setRealGoods( (GoodsStock)map.get(GoodsStockVOMeta.REAL_GOODS));
				this.setUseOrganization( (Organization)map.get(GoodsStockVOMeta.USE_ORGANIZATION));
				this.setPageIndex( (Integer)map.get(GoodsStockVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(GoodsStockVOMeta.SORT_TYPE));
				this.setGoodsCategoryName( (String)map.get(GoodsStockVOMeta.GOODS_CATEGORY_NAME));
				this.setGoodsStockNotes( (String)map.get(GoodsStockVOMeta.GOODS_STOCK_NOTES));
				this.setGoodsCode( (String)map.get(GoodsStockVOMeta.GOODS_CODE));
				this.setCategory( (Catalog)map.get(GoodsStockVOMeta.CATEGORY));
				this.setSearchValue( (String)map.get(GoodsStockVOMeta.SEARCH_VALUE));
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
			this.setOwnerType(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.OWNER_TYPE)));
			this.setSourceId(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.SOURCE_ID)));
			this.setInterOperType(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.INTER_OPER_TYPE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.NOTES)));
			this.setStockSecurity(DataParser.parse(BigDecimal.class, r.getValue(GoodsStockVOMeta.STOCK_SECURITY)));
			this.setOwnerTmpId(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.OWNER_TMP_ID)));
			this.setPid(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.PID)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.OWNER_ID)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.BUSINESS_CODE)));
			this.setModel(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.MODEL)));
			this.setId(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.ID)));
			this.setUnitPrice(DataParser.parse(BigDecimal.class, r.getValue(GoodsStockVOMeta.UNIT_PRICE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(GoodsStockVOMeta.VERSION)));
			this.setBarCode(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.BAR_CODE)));
			this.setUnit(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.UNIT)));
			this.setOwnCompanyId(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.OWN_COMPANY_ID)));
			this.setWarehouseId(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.WAREHOUSE_ID)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(GoodsStockVOMeta.DELETE_TIME)));
			this.setBrandId(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.BRAND_ID)));
			this.setAssetCategoryId(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.ASSET_CATEGORY_ID)));
			this.setName(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.STATUS)));
			this.setCode(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.CODE)));
			this.setOwnerCode(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.OWNER_CODE)));
			this.setGoodsId(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.GOODS_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.SELECTED_CODE)));
			this.setStockMin(DataParser.parse(BigDecimal.class, r.getValue(GoodsStockVOMeta.STOCK_MIN)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.PICTURE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.UPDATE_BY)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.ORIGINATOR_ID)));
			this.setSupplierName(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.SUPPLIER_NAME)));
			this.setStockInNumber(DataParser.parse(BigDecimal.class, r.getValue(GoodsStockVOMeta.STOCK_IN_NUMBER)));
			this.setAmount(DataParser.parse(BigDecimal.class, r.getValue(GoodsStockVOMeta.AMOUNT)));
			this.setStockMax(DataParser.parse(BigDecimal.class, r.getValue(GoodsStockVOMeta.STOCK_MAX)));
			this.setUseOrgId(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.USE_ORG_ID)));
			this.setBatchCode(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.BATCH_CODE)));
			this.setManufacturerId(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.MANUFACTURER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(GoodsStockVOMeta.UPDATE_TIME)));
			this.setManagerId(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.MANAGER_ID)));
			this.setStorageDate(DataParser.parse(Date.class, r.getValue(GoodsStockVOMeta.STORAGE_DATE)));
			this.setStockCurNumber(DataParser.parse(BigDecimal.class, r.getValue(GoodsStockVOMeta.STOCK_CUR_NUMBER)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.CREATE_BY)));
			this.setRealStockId(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.REAL_STOCK_ID)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(GoodsStockVOMeta.DELETED)));
			this.setGoodsStatus(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.GOODS_STATUS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(GoodsStockVOMeta.CREATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.TENANT_ID)));
			this.setCategoryId(DataParser.parse(String.class, r.getValue(GoodsStockVOMeta.CATEGORY_ID)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)r.getValue(GoodsStockVOMeta.OWNER_TYPE));
				this.setSourceId( (String)r.getValue(GoodsStockVOMeta.SOURCE_ID));
				this.setInterOperType( (String)r.getValue(GoodsStockVOMeta.INTER_OPER_TYPE));
				this.setNotes( (String)r.getValue(GoodsStockVOMeta.NOTES));
				this.setStockSecurity( (BigDecimal)r.getValue(GoodsStockVOMeta.STOCK_SECURITY));
				this.setOwnerTmpId( (String)r.getValue(GoodsStockVOMeta.OWNER_TMP_ID));
				this.setPid( (String)r.getValue(GoodsStockVOMeta.PID));
				this.setOwnerId( (String)r.getValue(GoodsStockVOMeta.OWNER_ID));
				this.setBusinessCode( (String)r.getValue(GoodsStockVOMeta.BUSINESS_CODE));
				this.setModel( (String)r.getValue(GoodsStockVOMeta.MODEL));
				this.setId( (String)r.getValue(GoodsStockVOMeta.ID));
				this.setUnitPrice( (BigDecimal)r.getValue(GoodsStockVOMeta.UNIT_PRICE));
				this.setVersion( (Integer)r.getValue(GoodsStockVOMeta.VERSION));
				this.setBarCode( (String)r.getValue(GoodsStockVOMeta.BAR_CODE));
				this.setUnit( (String)r.getValue(GoodsStockVOMeta.UNIT));
				this.setOwnCompanyId( (String)r.getValue(GoodsStockVOMeta.OWN_COMPANY_ID));
				this.setWarehouseId( (String)r.getValue(GoodsStockVOMeta.WAREHOUSE_ID));
				this.setDeleteTime( (Date)r.getValue(GoodsStockVOMeta.DELETE_TIME));
				this.setBrandId( (String)r.getValue(GoodsStockVOMeta.BRAND_ID));
				this.setAssetCategoryId( (String)r.getValue(GoodsStockVOMeta.ASSET_CATEGORY_ID));
				this.setName( (String)r.getValue(GoodsStockVOMeta.NAME));
				this.setDeleteBy( (String)r.getValue(GoodsStockVOMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(GoodsStockVOMeta.STATUS));
				this.setCode( (String)r.getValue(GoodsStockVOMeta.CODE));
				this.setOwnerCode( (String)r.getValue(GoodsStockVOMeta.OWNER_CODE));
				this.setGoodsId( (String)r.getValue(GoodsStockVOMeta.GOODS_ID));
				this.setSelectedCode( (String)r.getValue(GoodsStockVOMeta.SELECTED_CODE));
				this.setStockMin( (BigDecimal)r.getValue(GoodsStockVOMeta.STOCK_MIN));
				this.setPictureId( (String)r.getValue(GoodsStockVOMeta.PICTURE_ID));
				this.setUpdateBy( (String)r.getValue(GoodsStockVOMeta.UPDATE_BY));
				this.setOriginatorId( (String)r.getValue(GoodsStockVOMeta.ORIGINATOR_ID));
				this.setSupplierName( (String)r.getValue(GoodsStockVOMeta.SUPPLIER_NAME));
				this.setStockInNumber( (BigDecimal)r.getValue(GoodsStockVOMeta.STOCK_IN_NUMBER));
				this.setAmount( (BigDecimal)r.getValue(GoodsStockVOMeta.AMOUNT));
				this.setStockMax( (BigDecimal)r.getValue(GoodsStockVOMeta.STOCK_MAX));
				this.setUseOrgId( (String)r.getValue(GoodsStockVOMeta.USE_ORG_ID));
				this.setBatchCode( (String)r.getValue(GoodsStockVOMeta.BATCH_CODE));
				this.setManufacturerId( (String)r.getValue(GoodsStockVOMeta.MANUFACTURER_ID));
				this.setUpdateTime( (Date)r.getValue(GoodsStockVOMeta.UPDATE_TIME));
				this.setManagerId( (String)r.getValue(GoodsStockVOMeta.MANAGER_ID));
				this.setStorageDate( (Date)r.getValue(GoodsStockVOMeta.STORAGE_DATE));
				this.setStockCurNumber( (BigDecimal)r.getValue(GoodsStockVOMeta.STOCK_CUR_NUMBER));
				this.setCreateBy( (String)r.getValue(GoodsStockVOMeta.CREATE_BY));
				this.setRealStockId( (String)r.getValue(GoodsStockVOMeta.REAL_STOCK_ID));
				this.setDeleted( (Integer)r.getValue(GoodsStockVOMeta.DELETED));
				this.setGoodsStatus( (String)r.getValue(GoodsStockVOMeta.GOODS_STATUS));
				this.setCreateTime( (Date)r.getValue(GoodsStockVOMeta.CREATE_TIME));
				this.setTenantId( (String)r.getValue(GoodsStockVOMeta.TENANT_ID));
				this.setCategoryId( (String)r.getValue(GoodsStockVOMeta.CATEGORY_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}