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
import com.dt.platform.domain.hr.meta.SalaryActionVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 薪酬发放VO类型
 * <p>薪酬发放 , 数据表 hr_salary_action 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-28 11:51:19
 * @sign D2833AFDC8E870D34CD2E6393C7E0ED7
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "薪酬发放VO类型 ; 薪酬发放 , 数据表 hr_salary_action 的通用VO类型" , parent = SalaryAction.class)
public class SalaryActionVO extends SalaryAction {

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
	public SalaryActionVO setPageIndex(Integer pageIndex) {
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
	public SalaryActionVO setPageSize(Integer pageSize) {
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
	public SalaryActionVO setSearchField(String searchField) {
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
	public SalaryActionVO setFuzzyField(String fuzzyField) {
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
	public SalaryActionVO setSearchValue(String searchValue) {
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
	public SalaryActionVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public SalaryActionVO addDirtyField(String... dirtyField) {
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
	public SalaryActionVO setSortField(String sortField) {
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
	public SalaryActionVO setSortType(String sortType) {
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
	public SalaryActionVO setDataOrigin(String dataOrigin) {
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
	public SalaryActionVO setQueryLogic(String queryLogic) {
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
	public SalaryActionVO setRequestAction(String requestAction) {
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
	public SalaryActionVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public SalaryActionVO addId(String... id) {
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
	 * @return SalaryActionVO , 转换好的 SalaryActionVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SalaryActionVO , 转换好的 PoJo 对象
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
	public SalaryActionVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SalaryActionVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.SalaryActionVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.SalaryActionVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setStart(this.getStart());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setLabel(this.getLabel());
		inst.setActionMonth(this.getActionMonth());
		inst.setVersion(this.getVersion());
		inst.setWithTpl(this.getWithTpl());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setEnd(this.getEnd());
		inst.setId(this.getId());
		inst.setTplId(this.getTplId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setPersonList(this.getPersonList());
			inst.setSalaryMonth(this.getSalaryMonth());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setSalaryTpl(this.getSalaryTpl());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSalaryDetailList(this.getSalaryDetailList());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SalaryActionVO clone(boolean deep) {
		return EntityContext.clone(SalaryActionVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SalaryActionVO
	 * @param salaryActionMap 包含实体信息的 Map 对象
	 * @return SalaryActionVO , 转换好的的 SalaryAction 对象
	*/
	@Transient
	public static SalaryActionVO createFrom(Map<String,Object> salaryActionMap) {
		if(salaryActionMap==null) return null;
		SalaryActionVO vo = create();
		EntityContext.copyProperties(vo,salaryActionMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 SalaryActionVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SalaryActionVO , 转换好的的 SalaryAction 对象
	*/
	@Transient
	public static SalaryActionVO createFrom(Object pojo) {
		if(pojo==null) return null;
		SalaryActionVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 SalaryActionVO，等同于 new
	 * @return SalaryActionVO 对象
	*/
	@Transient
	public static SalaryActionVO create() {
		return new com.dt.platform.domain.hr.meta.SalaryActionVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(SalaryActionVOMeta.NOTES)));
			this.setStart(DataParser.parse(Date.class, map.get(SalaryActionVOMeta.START)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SalaryActionVOMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, map.get(SalaryActionVOMeta.LABEL)));
			this.setActionMonth(DataParser.parse(String.class, map.get(SalaryActionVOMeta.ACTION_MONTH)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SalaryActionVOMeta.VERSION)));
			this.setWithTpl(DataParser.parse(String.class, map.get(SalaryActionVOMeta.WITH_TPL)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SalaryActionVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SalaryActionVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SalaryActionVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SalaryActionVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SalaryActionVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(SalaryActionVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(SalaryActionVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SalaryActionVOMeta.DELETE_BY)));
			this.setEnd(DataParser.parse(Date.class, map.get(SalaryActionVOMeta.END)));
			this.setId(DataParser.parse(String.class, map.get(SalaryActionVOMeta.ID)));
			this.setTplId(DataParser.parse(String.class, map.get(SalaryActionVOMeta.TPL_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(SalaryActionVOMeta.STATUS)));
			// others
			this.setSalaryMonth(DataParser.parse(SalaryMonth.class, map.get(SalaryActionVOMeta.SALARY_MONTH)));
			this.setSearchField(DataParser.parse(String.class, map.get(SalaryActionVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(SalaryActionVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(SalaryActionVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(SalaryActionVOMeta.PAGE_SIZE)));
			this.setSalaryTpl(DataParser.parse(SalaryTpl.class, map.get(SalaryActionVOMeta.SALARY_TPL)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(SalaryActionVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(SalaryActionVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(SalaryActionVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(SalaryActionVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(SalaryActionVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(SalaryActionVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(SalaryActionVOMeta.NOTES));
				this.setStart( (Date)map.get(SalaryActionVOMeta.START));
				this.setUpdateTime( (Date)map.get(SalaryActionVOMeta.UPDATE_TIME));
				this.setLabel( (String)map.get(SalaryActionVOMeta.LABEL));
				this.setActionMonth( (String)map.get(SalaryActionVOMeta.ACTION_MONTH));
				this.setVersion( (Integer)map.get(SalaryActionVOMeta.VERSION));
				this.setWithTpl( (String)map.get(SalaryActionVOMeta.WITH_TPL));
				this.setCreateBy( (String)map.get(SalaryActionVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(SalaryActionVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(SalaryActionVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SalaryActionVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SalaryActionVOMeta.DELETE_TIME));
				this.setName( (String)map.get(SalaryActionVOMeta.NAME));
				this.setTenantId( (String)map.get(SalaryActionVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(SalaryActionVOMeta.DELETE_BY));
				this.setEnd( (Date)map.get(SalaryActionVOMeta.END));
				this.setId( (String)map.get(SalaryActionVOMeta.ID));
				this.setTplId( (String)map.get(SalaryActionVOMeta.TPL_ID));
				this.setStatus( (String)map.get(SalaryActionVOMeta.STATUS));
				// others
				this.setSalaryMonth( (SalaryMonth)map.get(SalaryActionVOMeta.SALARY_MONTH));
				this.setSearchField( (String)map.get(SalaryActionVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(SalaryActionVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(SalaryActionVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(SalaryActionVOMeta.PAGE_SIZE));
				this.setSalaryTpl( (SalaryTpl)map.get(SalaryActionVOMeta.SALARY_TPL));
				this.setPageIndex( (Integer)map.get(SalaryActionVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(SalaryActionVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(SalaryActionVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(SalaryActionVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(SalaryActionVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(SalaryActionVOMeta.SEARCH_VALUE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(SalaryActionVOMeta.NOTES)));
			this.setStart(DataParser.parse(Date.class, r.getValue(SalaryActionVOMeta.START)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SalaryActionVOMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, r.getValue(SalaryActionVOMeta.LABEL)));
			this.setActionMonth(DataParser.parse(String.class, r.getValue(SalaryActionVOMeta.ACTION_MONTH)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SalaryActionVOMeta.VERSION)));
			this.setWithTpl(DataParser.parse(String.class, r.getValue(SalaryActionVOMeta.WITH_TPL)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SalaryActionVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SalaryActionVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SalaryActionVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SalaryActionVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SalaryActionVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(SalaryActionVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SalaryActionVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SalaryActionVOMeta.DELETE_BY)));
			this.setEnd(DataParser.parse(Date.class, r.getValue(SalaryActionVOMeta.END)));
			this.setId(DataParser.parse(String.class, r.getValue(SalaryActionVOMeta.ID)));
			this.setTplId(DataParser.parse(String.class, r.getValue(SalaryActionVOMeta.TPL_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(SalaryActionVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(SalaryActionVOMeta.NOTES));
				this.setStart( (Date)r.getValue(SalaryActionVOMeta.START));
				this.setUpdateTime( (Date)r.getValue(SalaryActionVOMeta.UPDATE_TIME));
				this.setLabel( (String)r.getValue(SalaryActionVOMeta.LABEL));
				this.setActionMonth( (String)r.getValue(SalaryActionVOMeta.ACTION_MONTH));
				this.setVersion( (Integer)r.getValue(SalaryActionVOMeta.VERSION));
				this.setWithTpl( (String)r.getValue(SalaryActionVOMeta.WITH_TPL));
				this.setCreateBy( (String)r.getValue(SalaryActionVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(SalaryActionVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(SalaryActionVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SalaryActionVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SalaryActionVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(SalaryActionVOMeta.NAME));
				this.setTenantId( (String)r.getValue(SalaryActionVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(SalaryActionVOMeta.DELETE_BY));
				this.setEnd( (Date)r.getValue(SalaryActionVOMeta.END));
				this.setId( (String)r.getValue(SalaryActionVOMeta.ID));
				this.setTplId( (String)r.getValue(SalaryActionVOMeta.TPL_ID));
				this.setStatus( (String)r.getValue(SalaryActionVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}