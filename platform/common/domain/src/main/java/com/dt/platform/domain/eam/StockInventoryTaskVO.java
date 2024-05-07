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
import com.dt.platform.domain.eam.meta.StockInventoryTaskVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 盘点任务2VO类型
 * <p>盘点任务2 , 数据表 eam_stock_inventory_task 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-06 16:10:12
 * @sign CBA1C5C32949B6A8C943CFFEC83BA13C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "盘点任务2VO类型 ; 盘点任务2 , 数据表 eam_stock_inventory_task 的通用VO类型" , parent = StockInventoryTask.class)
public class StockInventoryTaskVO extends StockInventoryTask {

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
	public StockInventoryTaskVO setPageIndex(Integer pageIndex) {
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
	public StockInventoryTaskVO setPageSize(Integer pageSize) {
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
	public StockInventoryTaskVO setSearchField(String searchField) {
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
	public StockInventoryTaskVO setFuzzyField(String fuzzyField) {
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
	public StockInventoryTaskVO setSearchValue(String searchValue) {
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
	public StockInventoryTaskVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public StockInventoryTaskVO addDirtyField(String... dirtyField) {
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
	public StockInventoryTaskVO setSortField(String sortField) {
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
	public StockInventoryTaskVO setSortType(String sortType) {
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
	public StockInventoryTaskVO setDataOrigin(String dataOrigin) {
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
	public StockInventoryTaskVO setQueryLogic(String queryLogic) {
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
	public StockInventoryTaskVO setRequestAction(String requestAction) {
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
	public StockInventoryTaskVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public StockInventoryTaskVO addId(String... id) {
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
	 * @return StockInventoryTaskVO , 转换好的 StockInventoryTaskVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return StockInventoryTaskVO , 转换好的 PoJo 对象
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
	public StockInventoryTaskVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public StockInventoryTaskVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.StockInventoryTaskVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.StockInventoryTaskVOMeta.$$proxy$$();
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
			inst.setSearchField(this.getSearchField());
			inst.setInventoryAssetCountByLoss(this.getInventoryAssetCountByLoss());
			inst.setInventoryAssetCountByException(this.getInventoryAssetCountByException());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setInventoryAssetCountByCounted(this.getInventoryAssetCountByCounted());
			inst.setOriginator(this.getOriginator());
			inst.setInventoryAssetInfoList(this.getInventoryAssetInfoList());
			inst.setInventoryAssetCountByNotCounted(this.getInventoryAssetCountByNotCounted());
			inst.setInventoryAssetCountBySurplus(this.getInventoryAssetCountBySurplus());
			inst.setCategoryList(this.getCategoryList());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setWarehouseIds(this.getWarehouseIds());
			inst.setWarehouseList(this.getWarehouseList());
			inst.setRequestAction(this.getRequestAction());
			inst.setDirector(this.getDirector());
			inst.setSearchQuerySource(this.getSearchQuerySource());
			inst.setCategoryIds(this.getCategoryIds());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setInventoryUserList(this.getInventoryUserList());
			inst.setIds(this.getIds());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public StockInventoryTaskVO clone(boolean deep) {
		return EntityContext.clone(StockInventoryTaskVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 StockInventoryTaskVO
	 * @param stockInventoryTaskMap 包含实体信息的 Map 对象
	 * @return StockInventoryTaskVO , 转换好的的 StockInventoryTask 对象
	*/
	@Transient
	public static StockInventoryTaskVO createFrom(Map<String,Object> stockInventoryTaskMap) {
		if(stockInventoryTaskMap==null) return null;
		StockInventoryTaskVO vo = create();
		EntityContext.copyProperties(vo,stockInventoryTaskMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 StockInventoryTaskVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return StockInventoryTaskVO , 转换好的的 StockInventoryTask 对象
	*/
	@Transient
	public static StockInventoryTaskVO createFrom(Object pojo) {
		if(pojo==null) return null;
		StockInventoryTaskVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 StockInventoryTaskVO，等同于 new
	 * @return StockInventoryTaskVO 对象
	*/
	@Transient
	public static StockInventoryTaskVO create() {
		return new com.dt.platform.domain.eam.meta.StockInventoryTaskVOMeta.$$proxy$$();
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
			this.setFinishTime(DataParser.parse(Date.class, map.get(StockInventoryTaskVOMeta.FINISH_TIME)));
			this.setNotes(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.NOTES)));
			this.setDirectorId(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.DIRECTOR_ID)));
			this.setOwnerCode(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.OWNER_CODE)));
			this.setInventoryStatus(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.INVENTORY_STATUS)));
			this.setDataStatus(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.DATA_STATUS)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(StockInventoryTaskVOMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(StockInventoryTaskVOMeta.VERSION)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(StockInventoryTaskVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(StockInventoryTaskVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(StockInventoryTaskVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(StockInventoryTaskVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.DELETE_BY)));
			this.setStartTime(DataParser.parse(Date.class, map.get(StockInventoryTaskVOMeta.START_TIME)));
			this.setPlanId(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.PLAN_ID)));
			this.setId(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.ORIGINATOR_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.SEARCH_FIELD)));
			this.setInventoryAssetCountByLoss(DataParser.parse(Integer.class, map.get(StockInventoryTaskVOMeta.INVENTORY_ASSET_COUNT_BY_LOSS)));
			this.setInventoryAssetCountByException(DataParser.parse(Integer.class, map.get(StockInventoryTaskVOMeta.INVENTORY_ASSET_COUNT_BY_EXCEPTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(StockInventoryTaskVOMeta.PAGE_SIZE)));
			this.setInventoryAssetCountByCounted(DataParser.parse(Integer.class, map.get(StockInventoryTaskVOMeta.INVENTORY_ASSET_COUNT_BY_COUNTED)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(StockInventoryTaskVOMeta.ORIGINATOR)));
			this.setInventoryAssetCountByNotCounted(DataParser.parse(Integer.class, map.get(StockInventoryTaskVOMeta.INVENTORY_ASSET_COUNT_BY_NOT_COUNTED)));
			this.setInventoryAssetCountBySurplus(DataParser.parse(Integer.class, map.get(StockInventoryTaskVOMeta.INVENTORY_ASSET_COUNT_BY_SURPLUS)));
			this.setSortField(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.QUERY_LOGIC)));
			this.setRequestAction(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.REQUEST_ACTION)));
			this.setDirector(DataParser.parse(Employee.class, map.get(StockInventoryTaskVOMeta.DIRECTOR)));
			this.setSearchQuerySource(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.SEARCH_QUERY_SOURCE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(StockInventoryTaskVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.SORT_TYPE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(StockInventoryTaskVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setFinishTime( (Date)map.get(StockInventoryTaskVOMeta.FINISH_TIME));
				this.setNotes( (String)map.get(StockInventoryTaskVOMeta.NOTES));
				this.setDirectorId( (String)map.get(StockInventoryTaskVOMeta.DIRECTOR_ID));
				this.setOwnerCode( (String)map.get(StockInventoryTaskVOMeta.OWNER_CODE));
				this.setInventoryStatus( (String)map.get(StockInventoryTaskVOMeta.INVENTORY_STATUS));
				this.setDataStatus( (String)map.get(StockInventoryTaskVOMeta.DATA_STATUS));
				this.setUpdateTime( (Date)map.get(StockInventoryTaskVOMeta.UPDATE_TIME));
				this.setType( (String)map.get(StockInventoryTaskVOMeta.TYPE));
				this.setVersion( (Integer)map.get(StockInventoryTaskVOMeta.VERSION));
				this.setBusinessDate( (Date)map.get(StockInventoryTaskVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(StockInventoryTaskVOMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(StockInventoryTaskVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(StockInventoryTaskVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(StockInventoryTaskVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(StockInventoryTaskVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(StockInventoryTaskVOMeta.DELETE_TIME));
				this.setName( (String)map.get(StockInventoryTaskVOMeta.NAME));
				this.setTenantId( (String)map.get(StockInventoryTaskVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(StockInventoryTaskVOMeta.DELETE_BY));
				this.setStartTime( (Date)map.get(StockInventoryTaskVOMeta.START_TIME));
				this.setPlanId( (String)map.get(StockInventoryTaskVOMeta.PLAN_ID));
				this.setId( (String)map.get(StockInventoryTaskVOMeta.ID));
				this.setOriginatorId( (String)map.get(StockInventoryTaskVOMeta.ORIGINATOR_ID));
				this.setStatus( (String)map.get(StockInventoryTaskVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(StockInventoryTaskVOMeta.SEARCH_FIELD));
				this.setInventoryAssetCountByLoss( (Integer)map.get(StockInventoryTaskVOMeta.INVENTORY_ASSET_COUNT_BY_LOSS));
				this.setInventoryAssetCountByException( (Integer)map.get(StockInventoryTaskVOMeta.INVENTORY_ASSET_COUNT_BY_EXCEPTION));
				this.setFuzzyField( (String)map.get(StockInventoryTaskVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(StockInventoryTaskVOMeta.PAGE_SIZE));
				this.setInventoryAssetCountByCounted( (Integer)map.get(StockInventoryTaskVOMeta.INVENTORY_ASSET_COUNT_BY_COUNTED));
				this.setOriginator( (Employee)map.get(StockInventoryTaskVOMeta.ORIGINATOR));
				this.setInventoryAssetCountByNotCounted( (Integer)map.get(StockInventoryTaskVOMeta.INVENTORY_ASSET_COUNT_BY_NOT_COUNTED));
				this.setInventoryAssetCountBySurplus( (Integer)map.get(StockInventoryTaskVOMeta.INVENTORY_ASSET_COUNT_BY_SURPLUS));
				this.setSortField( (String)map.get(StockInventoryTaskVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(StockInventoryTaskVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(StockInventoryTaskVOMeta.QUERY_LOGIC));
				this.setRequestAction( (String)map.get(StockInventoryTaskVOMeta.REQUEST_ACTION));
				this.setDirector( (Employee)map.get(StockInventoryTaskVOMeta.DIRECTOR));
				this.setSearchQuerySource( (String)map.get(StockInventoryTaskVOMeta.SEARCH_QUERY_SOURCE));
				this.setPageIndex( (Integer)map.get(StockInventoryTaskVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(StockInventoryTaskVOMeta.SORT_TYPE));
				this.setSearchValue( (String)map.get(StockInventoryTaskVOMeta.SEARCH_VALUE));
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
			this.setFinishTime(DataParser.parse(Date.class, r.getValue(StockInventoryTaskVOMeta.FINISH_TIME)));
			this.setNotes(DataParser.parse(String.class, r.getValue(StockInventoryTaskVOMeta.NOTES)));
			this.setDirectorId(DataParser.parse(String.class, r.getValue(StockInventoryTaskVOMeta.DIRECTOR_ID)));
			this.setOwnerCode(DataParser.parse(String.class, r.getValue(StockInventoryTaskVOMeta.OWNER_CODE)));
			this.setInventoryStatus(DataParser.parse(String.class, r.getValue(StockInventoryTaskVOMeta.INVENTORY_STATUS)));
			this.setDataStatus(DataParser.parse(String.class, r.getValue(StockInventoryTaskVOMeta.DATA_STATUS)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(StockInventoryTaskVOMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(StockInventoryTaskVOMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(StockInventoryTaskVOMeta.VERSION)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(StockInventoryTaskVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(StockInventoryTaskVOMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(StockInventoryTaskVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(StockInventoryTaskVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(StockInventoryTaskVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(StockInventoryTaskVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(StockInventoryTaskVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(StockInventoryTaskVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(StockInventoryTaskVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(StockInventoryTaskVOMeta.DELETE_BY)));
			this.setStartTime(DataParser.parse(Date.class, r.getValue(StockInventoryTaskVOMeta.START_TIME)));
			this.setPlanId(DataParser.parse(String.class, r.getValue(StockInventoryTaskVOMeta.PLAN_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(StockInventoryTaskVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(StockInventoryTaskVOMeta.ORIGINATOR_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(StockInventoryTaskVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setFinishTime( (Date)r.getValue(StockInventoryTaskVOMeta.FINISH_TIME));
				this.setNotes( (String)r.getValue(StockInventoryTaskVOMeta.NOTES));
				this.setDirectorId( (String)r.getValue(StockInventoryTaskVOMeta.DIRECTOR_ID));
				this.setOwnerCode( (String)r.getValue(StockInventoryTaskVOMeta.OWNER_CODE));
				this.setInventoryStatus( (String)r.getValue(StockInventoryTaskVOMeta.INVENTORY_STATUS));
				this.setDataStatus( (String)r.getValue(StockInventoryTaskVOMeta.DATA_STATUS));
				this.setUpdateTime( (Date)r.getValue(StockInventoryTaskVOMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(StockInventoryTaskVOMeta.TYPE));
				this.setVersion( (Integer)r.getValue(StockInventoryTaskVOMeta.VERSION));
				this.setBusinessDate( (Date)r.getValue(StockInventoryTaskVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(StockInventoryTaskVOMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(StockInventoryTaskVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(StockInventoryTaskVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(StockInventoryTaskVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(StockInventoryTaskVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(StockInventoryTaskVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(StockInventoryTaskVOMeta.NAME));
				this.setTenantId( (String)r.getValue(StockInventoryTaskVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(StockInventoryTaskVOMeta.DELETE_BY));
				this.setStartTime( (Date)r.getValue(StockInventoryTaskVOMeta.START_TIME));
				this.setPlanId( (String)r.getValue(StockInventoryTaskVOMeta.PLAN_ID));
				this.setId( (String)r.getValue(StockInventoryTaskVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(StockInventoryTaskVOMeta.ORIGINATOR_ID));
				this.setStatus( (String)r.getValue(StockInventoryTaskVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}