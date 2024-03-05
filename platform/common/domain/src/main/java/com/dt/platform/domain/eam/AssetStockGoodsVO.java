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
import com.dt.platform.domain.eam.meta.AssetStockGoodsVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 库存物品单VO类型
 * <p>库存物品单 , 数据表 eam_asset_stock_goods 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-21 09:53:04
 * @sign 1B4640E34E7518F60C6081FC6D88A13C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "库存物品单VO类型 ; 库存物品单 , 数据表 eam_asset_stock_goods 的通用VO类型" , parent = AssetStockGoods.class)
public class AssetStockGoodsVO extends AssetStockGoods {

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
	public AssetStockGoodsVO setPageIndex(Integer pageIndex) {
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
	public AssetStockGoodsVO setPageSize(Integer pageSize) {
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
	public AssetStockGoodsVO setSearchField(String searchField) {
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
	public AssetStockGoodsVO setFuzzyField(String fuzzyField) {
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
	public AssetStockGoodsVO setSearchValue(String searchValue) {
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
	public AssetStockGoodsVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetStockGoodsVO addDirtyField(String... dirtyField) {
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
	public AssetStockGoodsVO setSortField(String sortField) {
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
	public AssetStockGoodsVO setSortType(String sortType) {
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
	public AssetStockGoodsVO setDataOrigin(String dataOrigin) {
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
	public AssetStockGoodsVO setQueryLogic(String queryLogic) {
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
	public AssetStockGoodsVO setRequestAction(String requestAction) {
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
	public AssetStockGoodsVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetStockGoodsVO addId(String... id) {
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
	 * @return AssetStockGoodsVO , 转换好的 AssetStockGoodsVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetStockGoodsVO , 转换好的 PoJo 对象
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
	public AssetStockGoodsVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetStockGoodsVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetStockGoodsVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetStockGoodsVOMeta.$$proxy$$();
		inst.setOwnerType(this.getOwnerType());
		inst.setSourceId(this.getSourceId());
		inst.setSupplierId(this.getSupplierId());
		inst.setNotes(this.getNotes());
		inst.setOwnerCode(this.getOwnerCode());
		inst.setGoodsId(this.getGoodsId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setUnitPrice(this.getUnitPrice());
		inst.setStockInNumber(this.getStockInNumber());
		inst.setAmount(this.getAmount());
		inst.setStockType(this.getStockType());
		inst.setUseOrgId(this.getUseOrgId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setStockBatchCode(this.getStockBatchCode());
		inst.setVersion(this.getVersion());
		inst.setStockCurNumber(this.getStockCurNumber());
		inst.setOwnCompanyId(this.getOwnCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setWarehouseId(this.getWarehouseId());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		if(all) {
			inst.setOwnerCompany(this.getOwnerCompany());
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setGoods(this.getGoods());
			inst.setPageSize(this.getPageSize());
			inst.setOriginator(this.getOriginator());
			inst.setSource(this.getSource());
			inst.setGoodsModel(this.getGoodsModel());
			inst.setGoodsBarCode(this.getGoodsBarCode());
			inst.setSupplier(this.getSupplier());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setGoodsUnit(this.getGoodsUnit());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setGoodsName(this.getGoodsName());
			inst.setRequestAction(this.getRequestAction());
			inst.setWarehouse(this.getWarehouse());
			inst.setUseOrganization(this.getUseOrganization());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setGoodsCategoryName(this.getGoodsCategoryName());
			inst.setIds(this.getIds());
			inst.setGoodsCode(this.getGoodsCode());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetStockGoodsVO clone(boolean deep) {
		return EntityContext.clone(AssetStockGoodsVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetStockGoodsVO
	 * @param assetStockGoodsMap 包含实体信息的 Map 对象
	 * @return AssetStockGoodsVO , 转换好的的 AssetStockGoods 对象
	*/
	@Transient
	public static AssetStockGoodsVO createFrom(Map<String,Object> assetStockGoodsMap) {
		if(assetStockGoodsMap==null) return null;
		AssetStockGoodsVO vo = create();
		EntityContext.copyProperties(vo,assetStockGoodsMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetStockGoodsVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetStockGoodsVO , 转换好的的 AssetStockGoods 对象
	*/
	@Transient
	public static AssetStockGoodsVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetStockGoodsVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetStockGoodsVO，等同于 new
	 * @return AssetStockGoodsVO 对象
	*/
	@Transient
	public static AssetStockGoodsVO create() {
		return new com.dt.platform.domain.eam.meta.AssetStockGoodsVOMeta.$$proxy$$();
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
			this.setOwnerType(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.OWNER_TYPE)));
			this.setSourceId(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.SOURCE_ID)));
			this.setSupplierId(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.SUPPLIER_ID)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.NOTES)));
			this.setOwnerCode(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.OWNER_CODE)));
			this.setGoodsId(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.GOODS_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.SELECTED_CODE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.ORIGINATOR_ID)));
			this.setUnitPrice(DataParser.parse(BigDecimal.class, map.get(AssetStockGoodsVOMeta.UNIT_PRICE)));
			this.setStockInNumber(DataParser.parse(BigDecimal.class, map.get(AssetStockGoodsVOMeta.STOCK_IN_NUMBER)));
			this.setAmount(DataParser.parse(BigDecimal.class, map.get(AssetStockGoodsVOMeta.AMOUNT)));
			this.setStockType(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.STOCK_TYPE)));
			this.setUseOrgId(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.USE_ORG_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetStockGoodsVOMeta.UPDATE_TIME)));
			this.setStockBatchCode(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.STOCK_BATCH_CODE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetStockGoodsVOMeta.VERSION)));
			this.setStockCurNumber(DataParser.parse(BigDecimal.class, map.get(AssetStockGoodsVOMeta.STOCK_CUR_NUMBER)));
			this.setOwnCompanyId(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetStockGoodsVOMeta.DELETED)));
			this.setWarehouseId(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.WAREHOUSE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetStockGoodsVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetStockGoodsVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.DELETE_BY)));
			// others
			this.setOwnerCompany(DataParser.parse(Organization.class, map.get(AssetStockGoodsVOMeta.OWNER_COMPANY)));
			this.setSearchField(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.FUZZY_FIELD)));
			this.setGoods(DataParser.parse(GoodsStock.class, map.get(AssetStockGoodsVOMeta.GOODS)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetStockGoodsVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetStockGoodsVOMeta.ORIGINATOR)));
			this.setSource(DataParser.parse(DictItem.class, map.get(AssetStockGoodsVOMeta.SOURCE)));
			this.setGoodsModel(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.GOODS_MODEL)));
			this.setGoodsBarCode(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.GOODS_BAR_CODE)));
			this.setSupplier(DataParser.parse(Supplier.class, map.get(AssetStockGoodsVOMeta.SUPPLIER)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.DATA_ORIGIN)));
			this.setGoodsUnit(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.GOODS_UNIT)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.QUERY_LOGIC)));
			this.setGoodsName(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.GOODS_NAME)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.REQUEST_ACTION)));
			this.setWarehouse(DataParser.parse(Warehouse.class, map.get(AssetStockGoodsVOMeta.WAREHOUSE)));
			this.setUseOrganization(DataParser.parse(Organization.class, map.get(AssetStockGoodsVOMeta.USE_ORGANIZATION)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetStockGoodsVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.SORT_TYPE)));
			this.setGoodsCategoryName(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.GOODS_CATEGORY_NAME)));
			this.setGoodsCode(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.GOODS_CODE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetStockGoodsVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)map.get(AssetStockGoodsVOMeta.OWNER_TYPE));
				this.setSourceId( (String)map.get(AssetStockGoodsVOMeta.SOURCE_ID));
				this.setSupplierId( (String)map.get(AssetStockGoodsVOMeta.SUPPLIER_ID));
				this.setNotes( (String)map.get(AssetStockGoodsVOMeta.NOTES));
				this.setOwnerCode( (String)map.get(AssetStockGoodsVOMeta.OWNER_CODE));
				this.setGoodsId( (String)map.get(AssetStockGoodsVOMeta.GOODS_ID));
				this.setSelectedCode( (String)map.get(AssetStockGoodsVOMeta.SELECTED_CODE));
				this.setBusinessCode( (String)map.get(AssetStockGoodsVOMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)map.get(AssetStockGoodsVOMeta.UPDATE_BY));
				this.setId( (String)map.get(AssetStockGoodsVOMeta.ID));
				this.setOriginatorId( (String)map.get(AssetStockGoodsVOMeta.ORIGINATOR_ID));
				this.setUnitPrice( (BigDecimal)map.get(AssetStockGoodsVOMeta.UNIT_PRICE));
				this.setStockInNumber( (BigDecimal)map.get(AssetStockGoodsVOMeta.STOCK_IN_NUMBER));
				this.setAmount( (BigDecimal)map.get(AssetStockGoodsVOMeta.AMOUNT));
				this.setStockType( (String)map.get(AssetStockGoodsVOMeta.STOCK_TYPE));
				this.setUseOrgId( (String)map.get(AssetStockGoodsVOMeta.USE_ORG_ID));
				this.setUpdateTime( (Date)map.get(AssetStockGoodsVOMeta.UPDATE_TIME));
				this.setStockBatchCode( (String)map.get(AssetStockGoodsVOMeta.STOCK_BATCH_CODE));
				this.setVersion( (Integer)map.get(AssetStockGoodsVOMeta.VERSION));
				this.setStockCurNumber( (BigDecimal)map.get(AssetStockGoodsVOMeta.STOCK_CUR_NUMBER));
				this.setOwnCompanyId( (String)map.get(AssetStockGoodsVOMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)map.get(AssetStockGoodsVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetStockGoodsVOMeta.DELETED));
				this.setWarehouseId( (String)map.get(AssetStockGoodsVOMeta.WAREHOUSE_ID));
				this.setCreateTime( (Date)map.get(AssetStockGoodsVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetStockGoodsVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(AssetStockGoodsVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetStockGoodsVOMeta.DELETE_BY));
				// others
				this.setOwnerCompany( (Organization)map.get(AssetStockGoodsVOMeta.OWNER_COMPANY));
				this.setSearchField( (String)map.get(AssetStockGoodsVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(AssetStockGoodsVOMeta.FUZZY_FIELD));
				this.setGoods( (GoodsStock)map.get(AssetStockGoodsVOMeta.GOODS));
				this.setPageSize( (Integer)map.get(AssetStockGoodsVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(AssetStockGoodsVOMeta.ORIGINATOR));
				this.setSource( (DictItem)map.get(AssetStockGoodsVOMeta.SOURCE));
				this.setGoodsModel( (String)map.get(AssetStockGoodsVOMeta.GOODS_MODEL));
				this.setGoodsBarCode( (String)map.get(AssetStockGoodsVOMeta.GOODS_BAR_CODE));
				this.setSupplier( (Supplier)map.get(AssetStockGoodsVOMeta.SUPPLIER));
				this.setSortField( (String)map.get(AssetStockGoodsVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(AssetStockGoodsVOMeta.DATA_ORIGIN));
				this.setGoodsUnit( (String)map.get(AssetStockGoodsVOMeta.GOODS_UNIT));
				this.setQueryLogic( (String)map.get(AssetStockGoodsVOMeta.QUERY_LOGIC));
				this.setGoodsName( (String)map.get(AssetStockGoodsVOMeta.GOODS_NAME));
				this.setRequestAction( (String)map.get(AssetStockGoodsVOMeta.REQUEST_ACTION));
				this.setWarehouse( (Warehouse)map.get(AssetStockGoodsVOMeta.WAREHOUSE));
				this.setUseOrganization( (Organization)map.get(AssetStockGoodsVOMeta.USE_ORGANIZATION));
				this.setPageIndex( (Integer)map.get(AssetStockGoodsVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetStockGoodsVOMeta.SORT_TYPE));
				this.setGoodsCategoryName( (String)map.get(AssetStockGoodsVOMeta.GOODS_CATEGORY_NAME));
				this.setGoodsCode( (String)map.get(AssetStockGoodsVOMeta.GOODS_CODE));
				this.setSearchValue( (String)map.get(AssetStockGoodsVOMeta.SEARCH_VALUE));
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
			this.setOwnerType(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.OWNER_TYPE)));
			this.setSourceId(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.SOURCE_ID)));
			this.setSupplierId(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.SUPPLIER_ID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.NOTES)));
			this.setOwnerCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.OWNER_CODE)));
			this.setGoodsId(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.GOODS_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.SELECTED_CODE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.ORIGINATOR_ID)));
			this.setUnitPrice(DataParser.parse(BigDecimal.class, r.getValue(AssetStockGoodsVOMeta.UNIT_PRICE)));
			this.setStockInNumber(DataParser.parse(BigDecimal.class, r.getValue(AssetStockGoodsVOMeta.STOCK_IN_NUMBER)));
			this.setAmount(DataParser.parse(BigDecimal.class, r.getValue(AssetStockGoodsVOMeta.AMOUNT)));
			this.setStockType(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.STOCK_TYPE)));
			this.setUseOrgId(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.USE_ORG_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsVOMeta.UPDATE_TIME)));
			this.setStockBatchCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.STOCK_BATCH_CODE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetStockGoodsVOMeta.VERSION)));
			this.setStockCurNumber(DataParser.parse(BigDecimal.class, r.getValue(AssetStockGoodsVOMeta.STOCK_CUR_NUMBER)));
			this.setOwnCompanyId(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetStockGoodsVOMeta.DELETED)));
			this.setWarehouseId(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.WAREHOUSE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsVOMeta.DELETE_BY)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)r.getValue(AssetStockGoodsVOMeta.OWNER_TYPE));
				this.setSourceId( (String)r.getValue(AssetStockGoodsVOMeta.SOURCE_ID));
				this.setSupplierId( (String)r.getValue(AssetStockGoodsVOMeta.SUPPLIER_ID));
				this.setNotes( (String)r.getValue(AssetStockGoodsVOMeta.NOTES));
				this.setOwnerCode( (String)r.getValue(AssetStockGoodsVOMeta.OWNER_CODE));
				this.setGoodsId( (String)r.getValue(AssetStockGoodsVOMeta.GOODS_ID));
				this.setSelectedCode( (String)r.getValue(AssetStockGoodsVOMeta.SELECTED_CODE));
				this.setBusinessCode( (String)r.getValue(AssetStockGoodsVOMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)r.getValue(AssetStockGoodsVOMeta.UPDATE_BY));
				this.setId( (String)r.getValue(AssetStockGoodsVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetStockGoodsVOMeta.ORIGINATOR_ID));
				this.setUnitPrice( (BigDecimal)r.getValue(AssetStockGoodsVOMeta.UNIT_PRICE));
				this.setStockInNumber( (BigDecimal)r.getValue(AssetStockGoodsVOMeta.STOCK_IN_NUMBER));
				this.setAmount( (BigDecimal)r.getValue(AssetStockGoodsVOMeta.AMOUNT));
				this.setStockType( (String)r.getValue(AssetStockGoodsVOMeta.STOCK_TYPE));
				this.setUseOrgId( (String)r.getValue(AssetStockGoodsVOMeta.USE_ORG_ID));
				this.setUpdateTime( (Date)r.getValue(AssetStockGoodsVOMeta.UPDATE_TIME));
				this.setStockBatchCode( (String)r.getValue(AssetStockGoodsVOMeta.STOCK_BATCH_CODE));
				this.setVersion( (Integer)r.getValue(AssetStockGoodsVOMeta.VERSION));
				this.setStockCurNumber( (BigDecimal)r.getValue(AssetStockGoodsVOMeta.STOCK_CUR_NUMBER));
				this.setOwnCompanyId( (String)r.getValue(AssetStockGoodsVOMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)r.getValue(AssetStockGoodsVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetStockGoodsVOMeta.DELETED));
				this.setWarehouseId( (String)r.getValue(AssetStockGoodsVOMeta.WAREHOUSE_ID));
				this.setCreateTime( (Date)r.getValue(AssetStockGoodsVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetStockGoodsVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(AssetStockGoodsVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetStockGoodsVOMeta.DELETE_BY));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}