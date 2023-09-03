package com.dt.platform.domain.ops;

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
import com.dt.platform.domain.ops.meta.AutoTaskMLogVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 执行日志VO类型
 * <p>执行日志 , 数据表 ops_auto_task_m_log 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-02 16:05:42
 * @sign 35AA6901273D9B2457406E05D0FDE445
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "执行日志VO类型 ; 执行日志 , 数据表 ops_auto_task_m_log 的通用VO类型" , parent = AutoTaskMLog.class)
public class AutoTaskMLogVO extends AutoTaskMLog {

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
	public AutoTaskMLogVO setPageIndex(Integer pageIndex) {
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
	public AutoTaskMLogVO setPageSize(Integer pageSize) {
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
	public AutoTaskMLogVO setSearchField(String searchField) {
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
	public AutoTaskMLogVO setFuzzyField(String fuzzyField) {
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
	public AutoTaskMLogVO setSearchValue(String searchValue) {
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
	public AutoTaskMLogVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AutoTaskMLogVO addDirtyField(String... dirtyField) {
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
	public AutoTaskMLogVO setSortField(String sortField) {
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
	public AutoTaskMLogVO setSortType(String sortType) {
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
	public AutoTaskMLogVO setDataOrigin(String dataOrigin) {
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
	public AutoTaskMLogVO setQueryLogic(String queryLogic) {
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
	public AutoTaskMLogVO setRequestAction(String requestAction) {
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
	public AutoTaskMLogVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AutoTaskMLogVO addId(String... id) {
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
	 * @return AutoTaskMLogVO , 转换好的 AutoTaskMLogVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AutoTaskMLogVO , 转换好的 PoJo 对象
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
	public AutoTaskMLogVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AutoTaskMLogVO duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.AutoTaskMLogVOMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.AutoTaskMLogVOMeta.$$proxy$$();
		inst.setStime(this.getStime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCreateTime(this.getCreateTime());
		inst.setEtime(this.getEtime());
		inst.setActionId(this.getActionId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTaskId(this.getTaskId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setTask(this.getTask());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setLogList(this.getLogList());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setAction(this.getAction());
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
	public AutoTaskMLogVO clone(boolean deep) {
		return EntityContext.clone(AutoTaskMLogVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AutoTaskMLogVO
	 * @param autoTaskMLogMap 包含实体信息的 Map 对象
	 * @return AutoTaskMLogVO , 转换好的的 AutoTaskMLog 对象
	*/
	@Transient
	public static AutoTaskMLogVO createFrom(Map<String,Object> autoTaskMLogMap) {
		if(autoTaskMLogMap==null) return null;
		AutoTaskMLogVO vo = create();
		EntityContext.copyProperties(vo,autoTaskMLogMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AutoTaskMLogVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AutoTaskMLogVO , 转换好的的 AutoTaskMLog 对象
	*/
	@Transient
	public static AutoTaskMLogVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AutoTaskMLogVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AutoTaskMLogVO，等同于 new
	 * @return AutoTaskMLogVO 对象
	*/
	@Transient
	public static AutoTaskMLogVO create() {
		return new com.dt.platform.domain.ops.meta.AutoTaskMLogVOMeta.$$proxy$$();
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
			this.setStime(DataParser.parse(Date.class, map.get(AutoTaskMLogVOMeta.STIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AutoTaskMLogVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AutoTaskMLogVOMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(AutoTaskMLogVOMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AutoTaskMLogVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AutoTaskMLogVOMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AutoTaskMLogVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AutoTaskMLogVOMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AutoTaskMLogVOMeta.CREATE_TIME)));
			this.setEtime(DataParser.parse(Date.class, map.get(AutoTaskMLogVOMeta.ETIME)));
			this.setActionId(DataParser.parse(String.class, map.get(AutoTaskMLogVOMeta.ACTION_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AutoTaskMLogVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AutoTaskMLogVOMeta.ID)));
			this.setTaskId(DataParser.parse(String.class, map.get(AutoTaskMLogVOMeta.TASK_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AutoTaskMLogVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AutoTaskMLogVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AutoTaskMLogVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AutoTaskMLogVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AutoTaskMLogVOMeta.PAGE_SIZE)));
			this.setTask(DataParser.parse(AutoTask.class, map.get(AutoTaskMLogVOMeta.TASK)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AutoTaskMLogVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AutoTaskMLogVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(AutoTaskMLogVOMeta.SORT_FIELD)));
			this.setAction(DataParser.parse(AutoAction.class, map.get(AutoTaskMLogVOMeta.ACTION)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AutoTaskMLogVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AutoTaskMLogVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AutoTaskMLogVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setStime( (Date)map.get(AutoTaskMLogVOMeta.STIME));
				this.setUpdateTime( (Date)map.get(AutoTaskMLogVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AutoTaskMLogVOMeta.VERSION));
				this.setContent( (String)map.get(AutoTaskMLogVOMeta.CONTENT));
				this.setCreateBy( (String)map.get(AutoTaskMLogVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AutoTaskMLogVOMeta.DELETED));
				this.setUpdateBy( (String)map.get(AutoTaskMLogVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AutoTaskMLogVOMeta.DELETE_TIME));
				this.setCreateTime( (Date)map.get(AutoTaskMLogVOMeta.CREATE_TIME));
				this.setEtime( (Date)map.get(AutoTaskMLogVOMeta.ETIME));
				this.setActionId( (String)map.get(AutoTaskMLogVOMeta.ACTION_ID));
				this.setDeleteBy( (String)map.get(AutoTaskMLogVOMeta.DELETE_BY));
				this.setId( (String)map.get(AutoTaskMLogVOMeta.ID));
				this.setTaskId( (String)map.get(AutoTaskMLogVOMeta.TASK_ID));
				this.setStatus( (String)map.get(AutoTaskMLogVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(AutoTaskMLogVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(AutoTaskMLogVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(AutoTaskMLogVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AutoTaskMLogVOMeta.PAGE_SIZE));
				this.setTask( (AutoTask)map.get(AutoTaskMLogVOMeta.TASK));
				this.setPageIndex( (Integer)map.get(AutoTaskMLogVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AutoTaskMLogVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(AutoTaskMLogVOMeta.SORT_FIELD));
				this.setAction( (AutoAction)map.get(AutoTaskMLogVOMeta.ACTION));
				this.setDataOrigin( (String)map.get(AutoTaskMLogVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(AutoTaskMLogVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(AutoTaskMLogVOMeta.SEARCH_VALUE));
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
			this.setStime(DataParser.parse(Date.class, r.getValue(AutoTaskMLogVOMeta.STIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AutoTaskMLogVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AutoTaskMLogVOMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(AutoTaskMLogVOMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AutoTaskMLogVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AutoTaskMLogVOMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AutoTaskMLogVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AutoTaskMLogVOMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AutoTaskMLogVOMeta.CREATE_TIME)));
			this.setEtime(DataParser.parse(Date.class, r.getValue(AutoTaskMLogVOMeta.ETIME)));
			this.setActionId(DataParser.parse(String.class, r.getValue(AutoTaskMLogVOMeta.ACTION_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AutoTaskMLogVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AutoTaskMLogVOMeta.ID)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(AutoTaskMLogVOMeta.TASK_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AutoTaskMLogVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setStime( (Date)r.getValue(AutoTaskMLogVOMeta.STIME));
				this.setUpdateTime( (Date)r.getValue(AutoTaskMLogVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AutoTaskMLogVOMeta.VERSION));
				this.setContent( (String)r.getValue(AutoTaskMLogVOMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(AutoTaskMLogVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AutoTaskMLogVOMeta.DELETED));
				this.setUpdateBy( (String)r.getValue(AutoTaskMLogVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AutoTaskMLogVOMeta.DELETE_TIME));
				this.setCreateTime( (Date)r.getValue(AutoTaskMLogVOMeta.CREATE_TIME));
				this.setEtime( (Date)r.getValue(AutoTaskMLogVOMeta.ETIME));
				this.setActionId( (String)r.getValue(AutoTaskMLogVOMeta.ACTION_ID));
				this.setDeleteBy( (String)r.getValue(AutoTaskMLogVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(AutoTaskMLogVOMeta.ID));
				this.setTaskId( (String)r.getValue(AutoTaskMLogVOMeta.TASK_ID));
				this.setStatus( (String)r.getValue(AutoTaskMLogVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}