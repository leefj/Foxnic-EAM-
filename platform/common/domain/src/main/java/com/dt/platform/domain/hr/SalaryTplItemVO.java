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
import com.dt.platform.domain.hr.meta.SalaryTplItemVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 计算项目VO类型
 * <p>计算项目 , 数据表 hr_salary_tpl_item 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-27 21:03:55
 * @sign BF0A4B51A4CD7294AEF107586B523788
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "计算项目VO类型 ; 计算项目 , 数据表 hr_salary_tpl_item 的通用VO类型" , parent = SalaryTplItem.class)
public class SalaryTplItemVO extends SalaryTplItem {

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
	public SalaryTplItemVO setPageIndex(Integer pageIndex) {
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
	public SalaryTplItemVO setPageSize(Integer pageSize) {
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
	public SalaryTplItemVO setSearchField(String searchField) {
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
	public SalaryTplItemVO setFuzzyField(String fuzzyField) {
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
	public SalaryTplItemVO setSearchValue(String searchValue) {
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
	public SalaryTplItemVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public SalaryTplItemVO addDirtyField(String... dirtyField) {
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
	public SalaryTplItemVO setSortField(String sortField) {
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
	public SalaryTplItemVO setSortType(String sortType) {
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
	public SalaryTplItemVO setDataOrigin(String dataOrigin) {
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
	public SalaryTplItemVO setQueryLogic(String queryLogic) {
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
	public SalaryTplItemVO setRequestAction(String requestAction) {
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
	public SalaryTplItemVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public SalaryTplItemVO addId(String... id) {
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
	 * @return SalaryTplItemVO , 转换好的 SalaryTplItemVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SalaryTplItemVO , 转换好的 PoJo 对象
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
	public SalaryTplItemVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SalaryTplItemVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.SalaryTplItemVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.SalaryTplItemVOMeta.$$proxy$$();
		inst.setExpressionValue(this.getExpressionValue());
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setVersion(this.getVersion());
		inst.setExpressionShow(this.getExpressionShow());
		inst.setCreateBy(this.getCreateBy());
		inst.setIncludeExpression(this.getIncludeExpression());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTplId(this.getTplId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setSalaryColumnCode(this.getSalaryColumnCode());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setSalaryColumn(this.getSalaryColumn());
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
	public SalaryTplItemVO clone(boolean deep) {
		return EntityContext.clone(SalaryTplItemVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SalaryTplItemVO
	 * @param salaryTplItemMap 包含实体信息的 Map 对象
	 * @return SalaryTplItemVO , 转换好的的 SalaryTplItem 对象
	*/
	@Transient
	public static SalaryTplItemVO createFrom(Map<String,Object> salaryTplItemMap) {
		if(salaryTplItemMap==null) return null;
		SalaryTplItemVO vo = create();
		EntityContext.copyProperties(vo,salaryTplItemMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 SalaryTplItemVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SalaryTplItemVO , 转换好的的 SalaryTplItem 对象
	*/
	@Transient
	public static SalaryTplItemVO createFrom(Object pojo) {
		if(pojo==null) return null;
		SalaryTplItemVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 SalaryTplItemVO，等同于 new
	 * @return SalaryTplItemVO 对象
	*/
	@Transient
	public static SalaryTplItemVO create() {
		return new com.dt.platform.domain.hr.meta.SalaryTplItemVOMeta.$$proxy$$();
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
			this.setExpressionValue(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.EXPRESSION_VALUE)));
			this.setCode(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SalaryTplItemVOMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(SalaryTplItemVOMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SalaryTplItemVOMeta.VERSION)));
			this.setExpressionShow(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.EXPRESSION_SHOW)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.CREATE_BY)));
			this.setIncludeExpression(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.INCLUDE_EXPRESSION)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SalaryTplItemVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SalaryTplItemVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SalaryTplItemVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.ID)));
			this.setTplId(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.TPL_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(SalaryTplItemVOMeta.PAGE_SIZE)));
			this.setSalaryColumnCode(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.SALARY_COLUMN_CODE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(SalaryTplItemVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.DATA_ORIGIN)));
			this.setSalaryColumn(DataParser.parse(SalaryColumn.class, map.get(SalaryTplItemVOMeta.SALARY_COLUMN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(SalaryTplItemVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setExpressionValue( (String)map.get(SalaryTplItemVOMeta.EXPRESSION_VALUE));
				this.setCode( (String)map.get(SalaryTplItemVOMeta.CODE));
				this.setNotes( (String)map.get(SalaryTplItemVOMeta.NOTES));
				this.setUpdateTime( (Date)map.get(SalaryTplItemVOMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(SalaryTplItemVOMeta.SORT));
				this.setVersion( (Integer)map.get(SalaryTplItemVOMeta.VERSION));
				this.setExpressionShow( (String)map.get(SalaryTplItemVOMeta.EXPRESSION_SHOW));
				this.setCreateBy( (String)map.get(SalaryTplItemVOMeta.CREATE_BY));
				this.setIncludeExpression( (String)map.get(SalaryTplItemVOMeta.INCLUDE_EXPRESSION));
				this.setDeleted( (Integer)map.get(SalaryTplItemVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(SalaryTplItemVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SalaryTplItemVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SalaryTplItemVOMeta.DELETE_TIME));
				this.setName( (String)map.get(SalaryTplItemVOMeta.NAME));
				this.setTenantId( (String)map.get(SalaryTplItemVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(SalaryTplItemVOMeta.DELETE_BY));
				this.setId( (String)map.get(SalaryTplItemVOMeta.ID));
				this.setTplId( (String)map.get(SalaryTplItemVOMeta.TPL_ID));
				this.setStatus( (String)map.get(SalaryTplItemVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(SalaryTplItemVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(SalaryTplItemVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(SalaryTplItemVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(SalaryTplItemVOMeta.PAGE_SIZE));
				this.setSalaryColumnCode( (String)map.get(SalaryTplItemVOMeta.SALARY_COLUMN_CODE));
				this.setPageIndex( (Integer)map.get(SalaryTplItemVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(SalaryTplItemVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(SalaryTplItemVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(SalaryTplItemVOMeta.DATA_ORIGIN));
				this.setSalaryColumn( (SalaryColumn)map.get(SalaryTplItemVOMeta.SALARY_COLUMN));
				this.setQueryLogic( (String)map.get(SalaryTplItemVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(SalaryTplItemVOMeta.SEARCH_VALUE));
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
			this.setExpressionValue(DataParser.parse(String.class, r.getValue(SalaryTplItemVOMeta.EXPRESSION_VALUE)));
			this.setCode(DataParser.parse(String.class, r.getValue(SalaryTplItemVOMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(SalaryTplItemVOMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SalaryTplItemVOMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(SalaryTplItemVOMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SalaryTplItemVOMeta.VERSION)));
			this.setExpressionShow(DataParser.parse(String.class, r.getValue(SalaryTplItemVOMeta.EXPRESSION_SHOW)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SalaryTplItemVOMeta.CREATE_BY)));
			this.setIncludeExpression(DataParser.parse(String.class, r.getValue(SalaryTplItemVOMeta.INCLUDE_EXPRESSION)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SalaryTplItemVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SalaryTplItemVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SalaryTplItemVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SalaryTplItemVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(SalaryTplItemVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SalaryTplItemVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SalaryTplItemVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(SalaryTplItemVOMeta.ID)));
			this.setTplId(DataParser.parse(String.class, r.getValue(SalaryTplItemVOMeta.TPL_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(SalaryTplItemVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setExpressionValue( (String)r.getValue(SalaryTplItemVOMeta.EXPRESSION_VALUE));
				this.setCode( (String)r.getValue(SalaryTplItemVOMeta.CODE));
				this.setNotes( (String)r.getValue(SalaryTplItemVOMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(SalaryTplItemVOMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(SalaryTplItemVOMeta.SORT));
				this.setVersion( (Integer)r.getValue(SalaryTplItemVOMeta.VERSION));
				this.setExpressionShow( (String)r.getValue(SalaryTplItemVOMeta.EXPRESSION_SHOW));
				this.setCreateBy( (String)r.getValue(SalaryTplItemVOMeta.CREATE_BY));
				this.setIncludeExpression( (String)r.getValue(SalaryTplItemVOMeta.INCLUDE_EXPRESSION));
				this.setDeleted( (Integer)r.getValue(SalaryTplItemVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(SalaryTplItemVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SalaryTplItemVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SalaryTplItemVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(SalaryTplItemVOMeta.NAME));
				this.setTenantId( (String)r.getValue(SalaryTplItemVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(SalaryTplItemVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(SalaryTplItemVOMeta.ID));
				this.setTplId( (String)r.getValue(SalaryTplItemVOMeta.TPL_ID));
				this.setStatus( (String)r.getValue(SalaryTplItemVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}