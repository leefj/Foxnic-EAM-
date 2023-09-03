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
import com.dt.platform.domain.ops.meta.AutoTaskVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 批次作业VO类型
 * <p>批次作业 , 数据表 ops_auto_task 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-02 16:07:10
 * @sign 1FE4C9355EB6D4B16C164684B352787E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "批次作业VO类型 ; 批次作业 , 数据表 ops_auto_task 的通用VO类型" , parent = AutoTask.class)
public class AutoTaskVO extends AutoTask {

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
	public AutoTaskVO setPageIndex(Integer pageIndex) {
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
	public AutoTaskVO setPageSize(Integer pageSize) {
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
	public AutoTaskVO setSearchField(String searchField) {
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
	public AutoTaskVO setFuzzyField(String fuzzyField) {
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
	public AutoTaskVO setSearchValue(String searchValue) {
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
	public AutoTaskVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AutoTaskVO addDirtyField(String... dirtyField) {
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
	public AutoTaskVO setSortField(String sortField) {
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
	public AutoTaskVO setSortType(String sortType) {
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
	public AutoTaskVO setDataOrigin(String dataOrigin) {
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
	public AutoTaskVO setQueryLogic(String queryLogic) {
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
	public AutoTaskVO setRequestAction(String requestAction) {
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
	public AutoTaskVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AutoTaskVO addId(String... id) {
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
	 * @return AutoTaskVO , 转换好的 AutoTaskVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AutoTaskVO , 转换好的 PoJo 对象
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
	public AutoTaskVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AutoTaskVO duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.AutoTaskVOMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.AutoTaskVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setGroupId(this.getGroupId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setOwnerId(this.getOwnerId());
		inst.setBatchId(this.getBatchId());
		inst.setConfContent(this.getConfContent());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCreateTime(this.getCreateTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setActionId(this.getActionId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setRunStatus(this.getRunStatus());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setTplDtl(this.getTplDtl());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setBatch(this.getBatch());
			inst.setActionSupport(this.getActionSupport());
			inst.setPageSize(this.getPageSize());
			inst.setActionExecuteContent(this.getActionExecuteContent());
			inst.setNodeList(this.getNodeList());
			inst.setActionConfContent(this.getActionConfContent());
			inst.setNodeIds(this.getNodeIds());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setActionInfo(this.getActionInfo());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setAction(this.getAction());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSearchValue(this.getSearchValue());
			inst.setGroup(this.getGroup());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AutoTaskVO clone(boolean deep) {
		return EntityContext.clone(AutoTaskVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AutoTaskVO
	 * @param autoTaskMap 包含实体信息的 Map 对象
	 * @return AutoTaskVO , 转换好的的 AutoTask 对象
	*/
	@Transient
	public static AutoTaskVO createFrom(Map<String,Object> autoTaskMap) {
		if(autoTaskMap==null) return null;
		AutoTaskVO vo = create();
		EntityContext.copyProperties(vo,autoTaskMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AutoTaskVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AutoTaskVO , 转换好的的 AutoTask 对象
	*/
	@Transient
	public static AutoTaskVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AutoTaskVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AutoTaskVO，等同于 new
	 * @return AutoTaskVO 对象
	*/
	@Transient
	public static AutoTaskVO create() {
		return new com.dt.platform.domain.ops.meta.AutoTaskVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AutoTaskVOMeta.NOTES)));
			this.setGroupId(DataParser.parse(String.class, map.get(AutoTaskVOMeta.GROUP_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AutoTaskVOMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, map.get(AutoTaskVOMeta.OWNER_ID)));
			this.setBatchId(DataParser.parse(String.class, map.get(AutoTaskVOMeta.BATCH_ID)));
			this.setConfContent(DataParser.parse(String.class, map.get(AutoTaskVOMeta.CONF_CONTENT)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AutoTaskVOMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AutoTaskVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AutoTaskVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AutoTaskVOMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AutoTaskVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AutoTaskVOMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AutoTaskVOMeta.CREATE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AutoTaskVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AutoTaskVOMeta.TENANT_ID)));
			this.setActionId(DataParser.parse(String.class, map.get(AutoTaskVOMeta.ACTION_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AutoTaskVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AutoTaskVOMeta.ID)));
			this.setRunStatus(DataParser.parse(String.class, map.get(AutoTaskVOMeta.RUN_STATUS)));
			this.setStatus(DataParser.parse(String.class, map.get(AutoTaskVOMeta.STATUS)));
			// others
			this.setTplDtl(DataParser.parse(String.class, map.get(AutoTaskVOMeta.TPL_DTL)));
			this.setSearchField(DataParser.parse(String.class, map.get(AutoTaskVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AutoTaskVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AutoTaskVOMeta.FUZZY_FIELD)));
			this.setBatch(DataParser.parse(AutoBatch.class, map.get(AutoTaskVOMeta.BATCH)));
			this.setActionSupport(DataParser.parse(String.class, map.get(AutoTaskVOMeta.ACTION_SUPPORT)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AutoTaskVOMeta.PAGE_SIZE)));
			this.setActionExecuteContent(DataParser.parse(String.class, map.get(AutoTaskVOMeta.ACTION_EXECUTE_CONTENT)));
			this.setActionConfContent(DataParser.parse(String.class, map.get(AutoTaskVOMeta.ACTION_CONF_CONTENT)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AutoTaskVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AutoTaskVOMeta.SORT_TYPE)));
			this.setActionInfo(DataParser.parse(String.class, map.get(AutoTaskVOMeta.ACTION_INFO)));
			this.setSortField(DataParser.parse(String.class, map.get(AutoTaskVOMeta.SORT_FIELD)));
			this.setAction(DataParser.parse(AutoAction.class, map.get(AutoTaskVOMeta.ACTION)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AutoTaskVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AutoTaskVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AutoTaskVOMeta.SEARCH_VALUE)));
			this.setGroup(DataParser.parse(AutoGroup.class, map.get(AutoTaskVOMeta.GROUP)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AutoTaskVOMeta.NOTES));
				this.setGroupId( (String)map.get(AutoTaskVOMeta.GROUP_ID));
				this.setUpdateTime( (Date)map.get(AutoTaskVOMeta.UPDATE_TIME));
				this.setOwnerId( (String)map.get(AutoTaskVOMeta.OWNER_ID));
				this.setBatchId( (String)map.get(AutoTaskVOMeta.BATCH_ID));
				this.setConfContent( (String)map.get(AutoTaskVOMeta.CONF_CONTENT));
				this.setSelectedCode( (String)map.get(AutoTaskVOMeta.SELECTED_CODE));
				this.setVersion( (Integer)map.get(AutoTaskVOMeta.VERSION));
				this.setCreateBy( (String)map.get(AutoTaskVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AutoTaskVOMeta.DELETED));
				this.setUpdateBy( (String)map.get(AutoTaskVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AutoTaskVOMeta.DELETE_TIME));
				this.setCreateTime( (Date)map.get(AutoTaskVOMeta.CREATE_TIME));
				this.setName( (String)map.get(AutoTaskVOMeta.NAME));
				this.setTenantId( (String)map.get(AutoTaskVOMeta.TENANT_ID));
				this.setActionId( (String)map.get(AutoTaskVOMeta.ACTION_ID));
				this.setDeleteBy( (String)map.get(AutoTaskVOMeta.DELETE_BY));
				this.setId( (String)map.get(AutoTaskVOMeta.ID));
				this.setRunStatus( (String)map.get(AutoTaskVOMeta.RUN_STATUS));
				this.setStatus( (String)map.get(AutoTaskVOMeta.STATUS));
				// others
				this.setTplDtl( (String)map.get(AutoTaskVOMeta.TPL_DTL));
				this.setSearchField( (String)map.get(AutoTaskVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(AutoTaskVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(AutoTaskVOMeta.FUZZY_FIELD));
				this.setBatch( (AutoBatch)map.get(AutoTaskVOMeta.BATCH));
				this.setActionSupport( (String)map.get(AutoTaskVOMeta.ACTION_SUPPORT));
				this.setPageSize( (Integer)map.get(AutoTaskVOMeta.PAGE_SIZE));
				this.setActionExecuteContent( (String)map.get(AutoTaskVOMeta.ACTION_EXECUTE_CONTENT));
				this.setActionConfContent( (String)map.get(AutoTaskVOMeta.ACTION_CONF_CONTENT));
				this.setPageIndex( (Integer)map.get(AutoTaskVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AutoTaskVOMeta.SORT_TYPE));
				this.setActionInfo( (String)map.get(AutoTaskVOMeta.ACTION_INFO));
				this.setSortField( (String)map.get(AutoTaskVOMeta.SORT_FIELD));
				this.setAction( (AutoAction)map.get(AutoTaskVOMeta.ACTION));
				this.setDataOrigin( (String)map.get(AutoTaskVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(AutoTaskVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(AutoTaskVOMeta.SEARCH_VALUE));
				this.setGroup( (AutoGroup)map.get(AutoTaskVOMeta.GROUP));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AutoTaskVOMeta.NOTES)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(AutoTaskVOMeta.GROUP_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AutoTaskVOMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(AutoTaskVOMeta.OWNER_ID)));
			this.setBatchId(DataParser.parse(String.class, r.getValue(AutoTaskVOMeta.BATCH_ID)));
			this.setConfContent(DataParser.parse(String.class, r.getValue(AutoTaskVOMeta.CONF_CONTENT)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AutoTaskVOMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AutoTaskVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AutoTaskVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AutoTaskVOMeta.DELETED)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AutoTaskVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AutoTaskVOMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AutoTaskVOMeta.CREATE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AutoTaskVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AutoTaskVOMeta.TENANT_ID)));
			this.setActionId(DataParser.parse(String.class, r.getValue(AutoTaskVOMeta.ACTION_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AutoTaskVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AutoTaskVOMeta.ID)));
			this.setRunStatus(DataParser.parse(String.class, r.getValue(AutoTaskVOMeta.RUN_STATUS)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AutoTaskVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AutoTaskVOMeta.NOTES));
				this.setGroupId( (String)r.getValue(AutoTaskVOMeta.GROUP_ID));
				this.setUpdateTime( (Date)r.getValue(AutoTaskVOMeta.UPDATE_TIME));
				this.setOwnerId( (String)r.getValue(AutoTaskVOMeta.OWNER_ID));
				this.setBatchId( (String)r.getValue(AutoTaskVOMeta.BATCH_ID));
				this.setConfContent( (String)r.getValue(AutoTaskVOMeta.CONF_CONTENT));
				this.setSelectedCode( (String)r.getValue(AutoTaskVOMeta.SELECTED_CODE));
				this.setVersion( (Integer)r.getValue(AutoTaskVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AutoTaskVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AutoTaskVOMeta.DELETED));
				this.setUpdateBy( (String)r.getValue(AutoTaskVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AutoTaskVOMeta.DELETE_TIME));
				this.setCreateTime( (Date)r.getValue(AutoTaskVOMeta.CREATE_TIME));
				this.setName( (String)r.getValue(AutoTaskVOMeta.NAME));
				this.setTenantId( (String)r.getValue(AutoTaskVOMeta.TENANT_ID));
				this.setActionId( (String)r.getValue(AutoTaskVOMeta.ACTION_ID));
				this.setDeleteBy( (String)r.getValue(AutoTaskVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(AutoTaskVOMeta.ID));
				this.setRunStatus( (String)r.getValue(AutoTaskVOMeta.RUN_STATUS));
				this.setStatus( (String)r.getValue(AutoTaskVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}