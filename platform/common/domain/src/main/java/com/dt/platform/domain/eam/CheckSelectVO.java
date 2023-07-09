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
import com.dt.platform.domain.eam.meta.CheckSelectVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 检查项选择VO类型
 * <p>检查项选择 , 数据表 eam_check_select 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-07 10:52:29
 * @sign 987CDBE40DBCCEE90BD74F7569F3C3CA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "检查项选择VO类型 ; 检查项选择 , 数据表 eam_check_select 的通用VO类型" , parent = CheckSelect.class)
public class CheckSelectVO extends CheckSelect {

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
	public CheckSelectVO setPageIndex(Integer pageIndex) {
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
	public CheckSelectVO setPageSize(Integer pageSize) {
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
	public CheckSelectVO setSearchField(String searchField) {
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
	public CheckSelectVO setFuzzyField(String fuzzyField) {
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
	public CheckSelectVO setSearchValue(String searchValue) {
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
	public CheckSelectVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public CheckSelectVO addDirtyField(String... dirtyField) {
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
	public CheckSelectVO setSortField(String sortField) {
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
	public CheckSelectVO setSortType(String sortType) {
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
	public CheckSelectVO setDataOrigin(String dataOrigin) {
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
	public CheckSelectVO setQueryLogic(String queryLogic) {
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
	public CheckSelectVO setRequestAction(String requestAction) {
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
	public CheckSelectVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public CheckSelectVO addId(String... id) {
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
	 * @return CheckSelectVO , 转换好的 CheckSelectVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CheckSelectVO , 转换好的 PoJo 对象
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
	public CheckSelectVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CheckSelectVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.CheckSelectVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.CheckSelectVOMeta.$$proxy$$();
		inst.setConfigDefValue(this.getConfigDefValue());
		inst.setItemCode(this.getItemCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setType(this.getType());
		inst.setItemDesc(this.getItemDesc());
		inst.setVersion(this.getVersion());
		inst.setTaskPointId(this.getTaskPointId());
		inst.setResult(this.getResult());
		inst.setItemId(this.getItemId());
		inst.setItemName(this.getItemName());
		inst.setCreateBy(this.getCreateBy());
		inst.setResultMetaData(this.getResultMetaData());
		inst.setDeleted(this.getDeleted());
		inst.setPointId(this.getPointId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setIfCheck(this.getIfCheck());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setConfig(this.getConfig());
		inst.setTaskId(this.getTaskId());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setCheckItem(this.getCheckItem());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setInspectionTaskPoint(this.getInspectionTaskPoint());
			inst.setPageSize(this.getPageSize());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSearchValue(this.getSearchValue());
			inst.setInspectionPoint(this.getInspectionPoint());
			inst.setInspectionTask(this.getInspectionTask());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CheckSelectVO clone(boolean deep) {
		return EntityContext.clone(CheckSelectVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CheckSelectVO
	 * @param checkSelectMap 包含实体信息的 Map 对象
	 * @return CheckSelectVO , 转换好的的 CheckSelect 对象
	*/
	@Transient
	public static CheckSelectVO createFrom(Map<String,Object> checkSelectMap) {
		if(checkSelectMap==null) return null;
		CheckSelectVO vo = create();
		EntityContext.copyProperties(vo,checkSelectMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 CheckSelectVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CheckSelectVO , 转换好的的 CheckSelect 对象
	*/
	@Transient
	public static CheckSelectVO createFrom(Object pojo) {
		if(pojo==null) return null;
		CheckSelectVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 CheckSelectVO，等同于 new
	 * @return CheckSelectVO 对象
	*/
	@Transient
	public static CheckSelectVO create() {
		return new com.dt.platform.domain.eam.meta.CheckSelectVOMeta.$$proxy$$();
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
			this.setConfigDefValue(DataParser.parse(String.class, map.get(CheckSelectVOMeta.CONFIG_DEF_VALUE)));
			this.setItemCode(DataParser.parse(String.class, map.get(CheckSelectVOMeta.ITEM_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CheckSelectVOMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(CheckSelectVOMeta.SORT)));
			this.setType(DataParser.parse(String.class, map.get(CheckSelectVOMeta.TYPE)));
			this.setItemDesc(DataParser.parse(String.class, map.get(CheckSelectVOMeta.ITEM_DESC)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CheckSelectVOMeta.VERSION)));
			this.setTaskPointId(DataParser.parse(String.class, map.get(CheckSelectVOMeta.TASK_POINT_ID)));
			this.setResult(DataParser.parse(String.class, map.get(CheckSelectVOMeta.RESULT)));
			this.setItemId(DataParser.parse(String.class, map.get(CheckSelectVOMeta.ITEM_ID)));
			this.setItemName(DataParser.parse(String.class, map.get(CheckSelectVOMeta.ITEM_NAME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CheckSelectVOMeta.CREATE_BY)));
			this.setResultMetaData(DataParser.parse(String.class, map.get(CheckSelectVOMeta.RESULT_META_DATA)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CheckSelectVOMeta.DELETED)));
			this.setPointId(DataParser.parse(String.class, map.get(CheckSelectVOMeta.POINT_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CheckSelectVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CheckSelectVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CheckSelectVOMeta.DELETE_TIME)));
			this.setIfCheck(DataParser.parse(String.class, map.get(CheckSelectVOMeta.IF_CHECK)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CheckSelectVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CheckSelectVOMeta.ID)));
			this.setConfig(DataParser.parse(String.class, map.get(CheckSelectVOMeta.CONFIG)));
			this.setTaskId(DataParser.parse(String.class, map.get(CheckSelectVOMeta.TASK_ID)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(CheckSelectVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(CheckSelectVOMeta.REQUEST_ACTION)));
			this.setCheckItem(DataParser.parse(CheckItem.class, map.get(CheckSelectVOMeta.CHECK_ITEM)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(CheckSelectVOMeta.FUZZY_FIELD)));
			this.setInspectionTaskPoint(DataParser.parse(InspectionTaskPoint.class, map.get(CheckSelectVOMeta.INSPECTION_TASK_POINT)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(CheckSelectVOMeta.PAGE_SIZE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(CheckSelectVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(CheckSelectVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(CheckSelectVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(CheckSelectVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(CheckSelectVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(CheckSelectVOMeta.SEARCH_VALUE)));
			this.setInspectionPoint(DataParser.parse(InspectionPoint.class, map.get(CheckSelectVOMeta.INSPECTION_POINT)));
			this.setInspectionTask(DataParser.parse(InspectionTask.class, map.get(CheckSelectVOMeta.INSPECTION_TASK)));
			return true;
		} else {
			try {
				this.setConfigDefValue( (String)map.get(CheckSelectVOMeta.CONFIG_DEF_VALUE));
				this.setItemCode( (String)map.get(CheckSelectVOMeta.ITEM_CODE));
				this.setUpdateTime( (Date)map.get(CheckSelectVOMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(CheckSelectVOMeta.SORT));
				this.setType( (String)map.get(CheckSelectVOMeta.TYPE));
				this.setItemDesc( (String)map.get(CheckSelectVOMeta.ITEM_DESC));
				this.setVersion( (Integer)map.get(CheckSelectVOMeta.VERSION));
				this.setTaskPointId( (String)map.get(CheckSelectVOMeta.TASK_POINT_ID));
				this.setResult( (String)map.get(CheckSelectVOMeta.RESULT));
				this.setItemId( (String)map.get(CheckSelectVOMeta.ITEM_ID));
				this.setItemName( (String)map.get(CheckSelectVOMeta.ITEM_NAME));
				this.setCreateBy( (String)map.get(CheckSelectVOMeta.CREATE_BY));
				this.setResultMetaData( (String)map.get(CheckSelectVOMeta.RESULT_META_DATA));
				this.setDeleted( (Integer)map.get(CheckSelectVOMeta.DELETED));
				this.setPointId( (String)map.get(CheckSelectVOMeta.POINT_ID));
				this.setCreateTime( (Date)map.get(CheckSelectVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CheckSelectVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CheckSelectVOMeta.DELETE_TIME));
				this.setIfCheck( (String)map.get(CheckSelectVOMeta.IF_CHECK));
				this.setDeleteBy( (String)map.get(CheckSelectVOMeta.DELETE_BY));
				this.setId( (String)map.get(CheckSelectVOMeta.ID));
				this.setConfig( (String)map.get(CheckSelectVOMeta.CONFIG));
				this.setTaskId( (String)map.get(CheckSelectVOMeta.TASK_ID));
				// others
				this.setSearchField( (String)map.get(CheckSelectVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(CheckSelectVOMeta.REQUEST_ACTION));
				this.setCheckItem( (CheckItem)map.get(CheckSelectVOMeta.CHECK_ITEM));
				this.setFuzzyField( (String)map.get(CheckSelectVOMeta.FUZZY_FIELD));
				this.setInspectionTaskPoint( (InspectionTaskPoint)map.get(CheckSelectVOMeta.INSPECTION_TASK_POINT));
				this.setPageSize( (Integer)map.get(CheckSelectVOMeta.PAGE_SIZE));
				this.setPageIndex( (Integer)map.get(CheckSelectVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(CheckSelectVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(CheckSelectVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(CheckSelectVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(CheckSelectVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(CheckSelectVOMeta.SEARCH_VALUE));
				this.setInspectionPoint( (InspectionPoint)map.get(CheckSelectVOMeta.INSPECTION_POINT));
				this.setInspectionTask( (InspectionTask)map.get(CheckSelectVOMeta.INSPECTION_TASK));
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
			this.setConfigDefValue(DataParser.parse(String.class, r.getValue(CheckSelectVOMeta.CONFIG_DEF_VALUE)));
			this.setItemCode(DataParser.parse(String.class, r.getValue(CheckSelectVOMeta.ITEM_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CheckSelectVOMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(CheckSelectVOMeta.SORT)));
			this.setType(DataParser.parse(String.class, r.getValue(CheckSelectVOMeta.TYPE)));
			this.setItemDesc(DataParser.parse(String.class, r.getValue(CheckSelectVOMeta.ITEM_DESC)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CheckSelectVOMeta.VERSION)));
			this.setTaskPointId(DataParser.parse(String.class, r.getValue(CheckSelectVOMeta.TASK_POINT_ID)));
			this.setResult(DataParser.parse(String.class, r.getValue(CheckSelectVOMeta.RESULT)));
			this.setItemId(DataParser.parse(String.class, r.getValue(CheckSelectVOMeta.ITEM_ID)));
			this.setItemName(DataParser.parse(String.class, r.getValue(CheckSelectVOMeta.ITEM_NAME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CheckSelectVOMeta.CREATE_BY)));
			this.setResultMetaData(DataParser.parse(String.class, r.getValue(CheckSelectVOMeta.RESULT_META_DATA)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CheckSelectVOMeta.DELETED)));
			this.setPointId(DataParser.parse(String.class, r.getValue(CheckSelectVOMeta.POINT_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CheckSelectVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CheckSelectVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CheckSelectVOMeta.DELETE_TIME)));
			this.setIfCheck(DataParser.parse(String.class, r.getValue(CheckSelectVOMeta.IF_CHECK)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CheckSelectVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CheckSelectVOMeta.ID)));
			this.setConfig(DataParser.parse(String.class, r.getValue(CheckSelectVOMeta.CONFIG)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(CheckSelectVOMeta.TASK_ID)));
			return true;
		} else {
			try {
				this.setConfigDefValue( (String)r.getValue(CheckSelectVOMeta.CONFIG_DEF_VALUE));
				this.setItemCode( (String)r.getValue(CheckSelectVOMeta.ITEM_CODE));
				this.setUpdateTime( (Date)r.getValue(CheckSelectVOMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(CheckSelectVOMeta.SORT));
				this.setType( (String)r.getValue(CheckSelectVOMeta.TYPE));
				this.setItemDesc( (String)r.getValue(CheckSelectVOMeta.ITEM_DESC));
				this.setVersion( (Integer)r.getValue(CheckSelectVOMeta.VERSION));
				this.setTaskPointId( (String)r.getValue(CheckSelectVOMeta.TASK_POINT_ID));
				this.setResult( (String)r.getValue(CheckSelectVOMeta.RESULT));
				this.setItemId( (String)r.getValue(CheckSelectVOMeta.ITEM_ID));
				this.setItemName( (String)r.getValue(CheckSelectVOMeta.ITEM_NAME));
				this.setCreateBy( (String)r.getValue(CheckSelectVOMeta.CREATE_BY));
				this.setResultMetaData( (String)r.getValue(CheckSelectVOMeta.RESULT_META_DATA));
				this.setDeleted( (Integer)r.getValue(CheckSelectVOMeta.DELETED));
				this.setPointId( (String)r.getValue(CheckSelectVOMeta.POINT_ID));
				this.setCreateTime( (Date)r.getValue(CheckSelectVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CheckSelectVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CheckSelectVOMeta.DELETE_TIME));
				this.setIfCheck( (String)r.getValue(CheckSelectVOMeta.IF_CHECK));
				this.setDeleteBy( (String)r.getValue(CheckSelectVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(CheckSelectVOMeta.ID));
				this.setConfig( (String)r.getValue(CheckSelectVOMeta.CONFIG));
				this.setTaskId( (String)r.getValue(CheckSelectVOMeta.TASK_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}