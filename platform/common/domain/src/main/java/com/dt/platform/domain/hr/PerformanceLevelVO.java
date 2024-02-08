package com.dt.platform.domain.hr;

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
import com.dt.platform.domain.hr.meta.PerformanceLevelVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考核等级VO类型
 * <p>考核等级 , 数据表 hr_performance_level 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-28 16:04:59
 * @sign 10D7CC355FAAC28C75499EA49C0A5E3A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "考核等级VO类型 ; 考核等级 , 数据表 hr_performance_level 的通用VO类型" , parent = PerformanceLevel.class)
public class PerformanceLevelVO extends PerformanceLevel {

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
	public PerformanceLevelVO setPageIndex(Integer pageIndex) {
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
	public PerformanceLevelVO setPageSize(Integer pageSize) {
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
	public PerformanceLevelVO setSearchField(String searchField) {
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
	public PerformanceLevelVO setFuzzyField(String fuzzyField) {
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
	public PerformanceLevelVO setSearchValue(String searchValue) {
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
	public PerformanceLevelVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public PerformanceLevelVO addDirtyField(String... dirtyField) {
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
	public PerformanceLevelVO setSortField(String sortField) {
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
	public PerformanceLevelVO setSortType(String sortType) {
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
	public PerformanceLevelVO setDataOrigin(String dataOrigin) {
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
	public PerformanceLevelVO setQueryLogic(String queryLogic) {
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
	public PerformanceLevelVO setRequestAction(String requestAction) {
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
	public PerformanceLevelVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public PerformanceLevelVO addId(String... id) {
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
	 * @return PerformanceLevelVO , 转换好的 PerformanceLevelVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PerformanceLevelVO , 转换好的 PoJo 对象
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
	public PerformanceLevelVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PerformanceLevelVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PerformanceLevelVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PerformanceLevelVOMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setLowerLimit(this.getLowerLimit());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpperLimit(this.getUpperLimit());
		inst.setId(this.getId());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setPageSize(this.getPageSize());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PerformanceLevelVO clone(boolean deep) {
		return EntityContext.clone(PerformanceLevelVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PerformanceLevelVO
	 * @param performanceLevelMap 包含实体信息的 Map 对象
	 * @return PerformanceLevelVO , 转换好的的 PerformanceLevel 对象
	*/
	@Transient
	public static PerformanceLevelVO createFrom(Map<String,Object> performanceLevelMap) {
		if(performanceLevelMap==null) return null;
		PerformanceLevelVO vo = create();
		EntityContext.copyProperties(vo,performanceLevelMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 PerformanceLevelVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PerformanceLevelVO , 转换好的的 PerformanceLevel 对象
	*/
	@Transient
	public static PerformanceLevelVO createFrom(Object pojo) {
		if(pojo==null) return null;
		PerformanceLevelVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 PerformanceLevelVO，等同于 new
	 * @return PerformanceLevelVO 对象
	*/
	@Transient
	public static PerformanceLevelVO create() {
		return new com.dt.platform.domain.hr.meta.PerformanceLevelVOMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(PerformanceLevelVOMeta.CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PerformanceLevelVOMeta.UPDATE_TIME)));
			this.setLowerLimit(DataParser.parse(String.class, map.get(PerformanceLevelVOMeta.LOWER_LIMIT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PerformanceLevelVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PerformanceLevelVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PerformanceLevelVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PerformanceLevelVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PerformanceLevelVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PerformanceLevelVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(PerformanceLevelVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PerformanceLevelVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PerformanceLevelVOMeta.DELETE_BY)));
			this.setUpperLimit(DataParser.parse(String.class, map.get(PerformanceLevelVOMeta.UPPER_LIMIT)));
			this.setId(DataParser.parse(String.class, map.get(PerformanceLevelVOMeta.ID)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(PerformanceLevelVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(PerformanceLevelVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(PerformanceLevelVOMeta.SORT_TYPE)));
			this.setRequestAction(DataParser.parse(String.class, map.get(PerformanceLevelVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(PerformanceLevelVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(PerformanceLevelVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(PerformanceLevelVOMeta.PAGE_SIZE)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(PerformanceLevelVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(PerformanceLevelVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(PerformanceLevelVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(PerformanceLevelVOMeta.CODE));
				this.setUpdateTime( (Date)map.get(PerformanceLevelVOMeta.UPDATE_TIME));
				this.setLowerLimit( (String)map.get(PerformanceLevelVOMeta.LOWER_LIMIT));
				this.setVersion( (Integer)map.get(PerformanceLevelVOMeta.VERSION));
				this.setCreateBy( (String)map.get(PerformanceLevelVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PerformanceLevelVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(PerformanceLevelVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PerformanceLevelVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PerformanceLevelVOMeta.DELETE_TIME));
				this.setName( (String)map.get(PerformanceLevelVOMeta.NAME));
				this.setTenantId( (String)map.get(PerformanceLevelVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PerformanceLevelVOMeta.DELETE_BY));
				this.setUpperLimit( (String)map.get(PerformanceLevelVOMeta.UPPER_LIMIT));
				this.setId( (String)map.get(PerformanceLevelVOMeta.ID));
				// others
				this.setSearchField( (String)map.get(PerformanceLevelVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(PerformanceLevelVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(PerformanceLevelVOMeta.SORT_TYPE));
				this.setRequestAction( (String)map.get(PerformanceLevelVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(PerformanceLevelVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(PerformanceLevelVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(PerformanceLevelVOMeta.PAGE_SIZE));
				this.setDataOrigin( (String)map.get(PerformanceLevelVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(PerformanceLevelVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(PerformanceLevelVOMeta.SEARCH_VALUE));
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
			this.setCode(DataParser.parse(String.class, r.getValue(PerformanceLevelVOMeta.CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PerformanceLevelVOMeta.UPDATE_TIME)));
			this.setLowerLimit(DataParser.parse(String.class, r.getValue(PerformanceLevelVOMeta.LOWER_LIMIT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PerformanceLevelVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PerformanceLevelVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PerformanceLevelVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PerformanceLevelVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PerformanceLevelVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PerformanceLevelVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(PerformanceLevelVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PerformanceLevelVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PerformanceLevelVOMeta.DELETE_BY)));
			this.setUpperLimit(DataParser.parse(String.class, r.getValue(PerformanceLevelVOMeta.UPPER_LIMIT)));
			this.setId(DataParser.parse(String.class, r.getValue(PerformanceLevelVOMeta.ID)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(PerformanceLevelVOMeta.CODE));
				this.setUpdateTime( (Date)r.getValue(PerformanceLevelVOMeta.UPDATE_TIME));
				this.setLowerLimit( (String)r.getValue(PerformanceLevelVOMeta.LOWER_LIMIT));
				this.setVersion( (Integer)r.getValue(PerformanceLevelVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(PerformanceLevelVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PerformanceLevelVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PerformanceLevelVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PerformanceLevelVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PerformanceLevelVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(PerformanceLevelVOMeta.NAME));
				this.setTenantId( (String)r.getValue(PerformanceLevelVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PerformanceLevelVOMeta.DELETE_BY));
				this.setUpperLimit( (String)r.getValue(PerformanceLevelVOMeta.UPPER_LIMIT));
				this.setId( (String)r.getValue(PerformanceLevelVOMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}