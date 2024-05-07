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
import com.dt.platform.domain.eam.meta.StockInventoryAssetVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 库存资产VO类型
 * <p>库存资产 , 数据表 eam_stock_inventory_asset 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-06 09:57:49
 * @sign 122BA0D299360FE1BF7BF7CF5A5B94D8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "库存资产VO类型 ; 库存资产 , 数据表 eam_stock_inventory_asset 的通用VO类型" , parent = StockInventoryAsset.class)
public class StockInventoryAssetVO extends StockInventoryAsset {

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
	public StockInventoryAssetVO setPageIndex(Integer pageIndex) {
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
	public StockInventoryAssetVO setPageSize(Integer pageSize) {
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
	public StockInventoryAssetVO setSearchField(String searchField) {
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
	public StockInventoryAssetVO setFuzzyField(String fuzzyField) {
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
	public StockInventoryAssetVO setSearchValue(String searchValue) {
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
	public StockInventoryAssetVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public StockInventoryAssetVO addDirtyField(String... dirtyField) {
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
	public StockInventoryAssetVO setSortField(String sortField) {
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
	public StockInventoryAssetVO setSortType(String sortType) {
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
	public StockInventoryAssetVO setDataOrigin(String dataOrigin) {
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
	public StockInventoryAssetVO setQueryLogic(String queryLogic) {
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
	public StockInventoryAssetVO setRequestAction(String requestAction) {
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
	public StockInventoryAssetVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public StockInventoryAssetVO addId(String... id) {
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
	 * @return StockInventoryAssetVO , 转换好的 StockInventoryAssetVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return StockInventoryAssetVO , 转换好的 PoJo 对象
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
	public StockInventoryAssetVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public StockInventoryAssetVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.StockInventoryAssetVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.StockInventoryAssetVOMeta.$$proxy$$();
		inst.setInventoryStatus(this.getInventoryStatus());
		inst.setOperId(this.getOperId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setInventoryNotes(this.getInventoryNotes());
		inst.setCreateBy(this.getCreateBy());
		inst.setAssetNumber(this.getAssetNumber());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssetId(this.getAssetId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTaskId(this.getTaskId());
		inst.setOperTime(this.getOperTime());
		if(all) {
			inst.setWithWarehouse(this.getWithWarehouse());
			inst.setSearchField(this.getSearchField());
			inst.setWithModel(this.getWithModel());
			inst.setRequestAction(this.getRequestAction());
			inst.setWithManufacturer(this.getWithManufacturer());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setWithGoodsStockType(this.getWithGoodsStockType());
			inst.setWithBrand(this.getWithBrand());
			inst.setWithNumber(this.getWithNumber());
			inst.setWithPosition(this.getWithPosition());
			inst.setGoodsStockAsset(this.getGoodsStockAsset());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setWithCode(this.getWithCode());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setWithName(this.getWithName());
			inst.setOperUser(this.getOperUser());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public StockInventoryAssetVO clone(boolean deep) {
		return EntityContext.clone(StockInventoryAssetVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 StockInventoryAssetVO
	 * @param stockInventoryAssetMap 包含实体信息的 Map 对象
	 * @return StockInventoryAssetVO , 转换好的的 StockInventoryAsset 对象
	*/
	@Transient
	public static StockInventoryAssetVO createFrom(Map<String,Object> stockInventoryAssetMap) {
		if(stockInventoryAssetMap==null) return null;
		StockInventoryAssetVO vo = create();
		EntityContext.copyProperties(vo,stockInventoryAssetMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 StockInventoryAssetVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return StockInventoryAssetVO , 转换好的的 StockInventoryAsset 对象
	*/
	@Transient
	public static StockInventoryAssetVO createFrom(Object pojo) {
		if(pojo==null) return null;
		StockInventoryAssetVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 StockInventoryAssetVO，等同于 new
	 * @return StockInventoryAssetVO 对象
	*/
	@Transient
	public static StockInventoryAssetVO create() {
		return new com.dt.platform.domain.eam.meta.StockInventoryAssetVOMeta.$$proxy$$();
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
			this.setInventoryStatus(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.INVENTORY_STATUS)));
			this.setOperId(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.OPER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(StockInventoryAssetVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(StockInventoryAssetVOMeta.VERSION)));
			this.setInventoryNotes(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.INVENTORY_NOTES)));
			this.setCreateBy(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.CREATE_BY)));
			this.setAssetNumber(DataParser.parse(Integer.class, map.get(StockInventoryAssetVOMeta.ASSET_NUMBER)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(StockInventoryAssetVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(StockInventoryAssetVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(StockInventoryAssetVOMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.ASSET_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.ID)));
			this.setTaskId(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.TASK_ID)));
			this.setOperTime(DataParser.parse(Date.class, map.get(StockInventoryAssetVOMeta.OPER_TIME)));
			// others
			this.setWithWarehouse(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.WITH_WAREHOUSE)));
			this.setSearchField(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.SEARCH_FIELD)));
			this.setWithModel(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.WITH_MODEL)));
			this.setRequestAction(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.REQUEST_ACTION)));
			this.setWithManufacturer(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.WITH_MANUFACTURER)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(StockInventoryAssetVOMeta.PAGE_SIZE)));
			this.setWithGoodsStockType(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.WITH_GOODS_STOCK_TYPE)));
			this.setWithBrand(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.WITH_BRAND)));
			this.setWithNumber(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.WITH_NUMBER)));
			this.setWithPosition(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.WITH_POSITION)));
			this.setGoodsStockAsset(DataParser.parse(GoodsStock.class, map.get(StockInventoryAssetVOMeta.GOODS_STOCK_ASSET)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(StockInventoryAssetVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.SORT_TYPE)));
			this.setWithCode(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.WITH_CODE)));
			this.setSortField(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.QUERY_LOGIC)));
			this.setWithName(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.WITH_NAME)));
			this.setOperUser(DataParser.parse(Employee.class, map.get(StockInventoryAssetVOMeta.OPER_USER)));
			this.setSearchValue(DataParser.parse(String.class, map.get(StockInventoryAssetVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setInventoryStatus( (String)map.get(StockInventoryAssetVOMeta.INVENTORY_STATUS));
				this.setOperId( (String)map.get(StockInventoryAssetVOMeta.OPER_ID));
				this.setUpdateTime( (Date)map.get(StockInventoryAssetVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(StockInventoryAssetVOMeta.VERSION));
				this.setInventoryNotes( (String)map.get(StockInventoryAssetVOMeta.INVENTORY_NOTES));
				this.setCreateBy( (String)map.get(StockInventoryAssetVOMeta.CREATE_BY));
				this.setAssetNumber( (Integer)map.get(StockInventoryAssetVOMeta.ASSET_NUMBER));
				this.setDeleted( (Integer)map.get(StockInventoryAssetVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(StockInventoryAssetVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(StockInventoryAssetVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(StockInventoryAssetVOMeta.DELETE_TIME));
				this.setAssetId( (String)map.get(StockInventoryAssetVOMeta.ASSET_ID));
				this.setDeleteBy( (String)map.get(StockInventoryAssetVOMeta.DELETE_BY));
				this.setId( (String)map.get(StockInventoryAssetVOMeta.ID));
				this.setTaskId( (String)map.get(StockInventoryAssetVOMeta.TASK_ID));
				this.setOperTime( (Date)map.get(StockInventoryAssetVOMeta.OPER_TIME));
				// others
				this.setWithWarehouse( (String)map.get(StockInventoryAssetVOMeta.WITH_WAREHOUSE));
				this.setSearchField( (String)map.get(StockInventoryAssetVOMeta.SEARCH_FIELD));
				this.setWithModel( (String)map.get(StockInventoryAssetVOMeta.WITH_MODEL));
				this.setRequestAction( (String)map.get(StockInventoryAssetVOMeta.REQUEST_ACTION));
				this.setWithManufacturer( (String)map.get(StockInventoryAssetVOMeta.WITH_MANUFACTURER));
				this.setFuzzyField( (String)map.get(StockInventoryAssetVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(StockInventoryAssetVOMeta.PAGE_SIZE));
				this.setWithGoodsStockType( (String)map.get(StockInventoryAssetVOMeta.WITH_GOODS_STOCK_TYPE));
				this.setWithBrand( (String)map.get(StockInventoryAssetVOMeta.WITH_BRAND));
				this.setWithNumber( (String)map.get(StockInventoryAssetVOMeta.WITH_NUMBER));
				this.setWithPosition( (String)map.get(StockInventoryAssetVOMeta.WITH_POSITION));
				this.setGoodsStockAsset( (GoodsStock)map.get(StockInventoryAssetVOMeta.GOODS_STOCK_ASSET));
				this.setPageIndex( (Integer)map.get(StockInventoryAssetVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(StockInventoryAssetVOMeta.SORT_TYPE));
				this.setWithCode( (String)map.get(StockInventoryAssetVOMeta.WITH_CODE));
				this.setSortField( (String)map.get(StockInventoryAssetVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(StockInventoryAssetVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(StockInventoryAssetVOMeta.QUERY_LOGIC));
				this.setWithName( (String)map.get(StockInventoryAssetVOMeta.WITH_NAME));
				this.setOperUser( (Employee)map.get(StockInventoryAssetVOMeta.OPER_USER));
				this.setSearchValue( (String)map.get(StockInventoryAssetVOMeta.SEARCH_VALUE));
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
			this.setInventoryStatus(DataParser.parse(String.class, r.getValue(StockInventoryAssetVOMeta.INVENTORY_STATUS)));
			this.setOperId(DataParser.parse(String.class, r.getValue(StockInventoryAssetVOMeta.OPER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(StockInventoryAssetVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(StockInventoryAssetVOMeta.VERSION)));
			this.setInventoryNotes(DataParser.parse(String.class, r.getValue(StockInventoryAssetVOMeta.INVENTORY_NOTES)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(StockInventoryAssetVOMeta.CREATE_BY)));
			this.setAssetNumber(DataParser.parse(Integer.class, r.getValue(StockInventoryAssetVOMeta.ASSET_NUMBER)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(StockInventoryAssetVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(StockInventoryAssetVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(StockInventoryAssetVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(StockInventoryAssetVOMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(StockInventoryAssetVOMeta.ASSET_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(StockInventoryAssetVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(StockInventoryAssetVOMeta.ID)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(StockInventoryAssetVOMeta.TASK_ID)));
			this.setOperTime(DataParser.parse(Date.class, r.getValue(StockInventoryAssetVOMeta.OPER_TIME)));
			return true;
		} else {
			try {
				this.setInventoryStatus( (String)r.getValue(StockInventoryAssetVOMeta.INVENTORY_STATUS));
				this.setOperId( (String)r.getValue(StockInventoryAssetVOMeta.OPER_ID));
				this.setUpdateTime( (Date)r.getValue(StockInventoryAssetVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(StockInventoryAssetVOMeta.VERSION));
				this.setInventoryNotes( (String)r.getValue(StockInventoryAssetVOMeta.INVENTORY_NOTES));
				this.setCreateBy( (String)r.getValue(StockInventoryAssetVOMeta.CREATE_BY));
				this.setAssetNumber( (Integer)r.getValue(StockInventoryAssetVOMeta.ASSET_NUMBER));
				this.setDeleted( (Integer)r.getValue(StockInventoryAssetVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(StockInventoryAssetVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(StockInventoryAssetVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(StockInventoryAssetVOMeta.DELETE_TIME));
				this.setAssetId( (String)r.getValue(StockInventoryAssetVOMeta.ASSET_ID));
				this.setDeleteBy( (String)r.getValue(StockInventoryAssetVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(StockInventoryAssetVOMeta.ID));
				this.setTaskId( (String)r.getValue(StockInventoryAssetVOMeta.TASK_ID));
				this.setOperTime( (Date)r.getValue(StockInventoryAssetVOMeta.OPER_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}