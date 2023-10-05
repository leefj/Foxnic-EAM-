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
import com.dt.platform.domain.ops.meta.MonitorTplIndicatorVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 模版指标VO类型
 * <p>模版指标 , 数据表 ops_monitor_tpl_indicator 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-05 20:26:38
 * @sign A30CF0E8E3F7E78C68BEB54048A66F1B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "模版指标VO类型 ; 模版指标 , 数据表 ops_monitor_tpl_indicator 的通用VO类型" , parent = MonitorTplIndicator.class)
public class MonitorTplIndicatorVO extends MonitorTplIndicator {

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
	public MonitorTplIndicatorVO setPageIndex(Integer pageIndex) {
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
	public MonitorTplIndicatorVO setPageSize(Integer pageSize) {
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
	public MonitorTplIndicatorVO setSearchField(String searchField) {
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
	public MonitorTplIndicatorVO setFuzzyField(String fuzzyField) {
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
	public MonitorTplIndicatorVO setSearchValue(String searchValue) {
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
	public MonitorTplIndicatorVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public MonitorTplIndicatorVO addDirtyField(String... dirtyField) {
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
	public MonitorTplIndicatorVO setSortField(String sortField) {
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
	public MonitorTplIndicatorVO setSortType(String sortType) {
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
	public MonitorTplIndicatorVO setDataOrigin(String dataOrigin) {
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
	public MonitorTplIndicatorVO setQueryLogic(String queryLogic) {
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
	public MonitorTplIndicatorVO setRequestAction(String requestAction) {
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
	public MonitorTplIndicatorVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public MonitorTplIndicatorVO addId(String... id) {
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
	 * @return MonitorTplIndicatorVO , 转换好的 MonitorTplIndicatorVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorTplIndicatorVO , 转换好的 PoJo 对象
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
	public MonitorTplIndicatorVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MonitorTplIndicatorVO duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.MonitorTplIndicatorVOMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.MonitorTplIndicatorVOMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setDataKeepDay(this.getDataKeepDay());
		inst.setNotes(this.getNotes());
		inst.setMonitorMethod(this.getMonitorMethod());
		inst.setMonitorTplCode(this.getMonitorTplCode());
		inst.setIndicatorType(this.getIndicatorType());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setValueColumn(this.getValueColumn());
		inst.setId(this.getId());
		inst.setIntervalTime(this.getIntervalTime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setLabel(this.getLabel());
		inst.setValueColumnMap(this.getValueColumnMap());
		inst.setVersion(this.getVersion());
		inst.setCommand(this.getCommand());
		inst.setTimeOut(this.getTimeOut());
		inst.setValueColumnType(this.getValueColumnType());
		inst.setRowColType(this.getRowColType());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCommandValue(this.getCommandValue());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setIndicatorVariable(this.getIndicatorVariable());
		inst.setSnmpOid(this.getSnmpOid());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setValueColumnName(this.getValueColumnName());
		inst.setItemSort(this.getItemSort());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setTpl(this.getTpl());
			inst.setMonitorIndicatorType(this.getMonitorIndicatorType());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
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
	public MonitorTplIndicatorVO clone(boolean deep) {
		return EntityContext.clone(MonitorTplIndicatorVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MonitorTplIndicatorVO
	 * @param monitorTplIndicatorMap 包含实体信息的 Map 对象
	 * @return MonitorTplIndicatorVO , 转换好的的 MonitorTplIndicator 对象
	*/
	@Transient
	public static MonitorTplIndicatorVO createFrom(Map<String,Object> monitorTplIndicatorMap) {
		if(monitorTplIndicatorMap==null) return null;
		MonitorTplIndicatorVO vo = create();
		EntityContext.copyProperties(vo,monitorTplIndicatorMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 MonitorTplIndicatorVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorTplIndicatorVO , 转换好的的 MonitorTplIndicator 对象
	*/
	@Transient
	public static MonitorTplIndicatorVO createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorTplIndicatorVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 MonitorTplIndicatorVO，等同于 new
	 * @return MonitorTplIndicatorVO 对象
	*/
	@Transient
	public static MonitorTplIndicatorVO create() {
		return new com.dt.platform.domain.ops.meta.MonitorTplIndicatorVOMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.CODE)));
			this.setDataKeepDay(DataParser.parse(Integer.class, map.get(MonitorTplIndicatorVOMeta.DATA_KEEP_DAY)));
			this.setNotes(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.NOTES)));
			this.setMonitorMethod(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.MONITOR_METHOD)));
			this.setMonitorTplCode(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.MONITOR_TPL_CODE)));
			this.setIndicatorType(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.INDICATOR_TYPE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.UPDATE_BY)));
			this.setValueColumn(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.VALUE_COLUMN)));
			this.setId(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.ID)));
			this.setIntervalTime(DataParser.parse(Integer.class, map.get(MonitorTplIndicatorVOMeta.INTERVAL_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MonitorTplIndicatorVOMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.LABEL)));
			this.setValueColumnMap(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.VALUE_COLUMN_MAP)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MonitorTplIndicatorVOMeta.VERSION)));
			this.setCommand(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.COMMAND)));
			this.setTimeOut(DataParser.parse(Integer.class, map.get(MonitorTplIndicatorVOMeta.TIME_OUT)));
			this.setValueColumnType(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.VALUE_COLUMN_TYPE)));
			this.setRowColType(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.ROW_COL_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MonitorTplIndicatorVOMeta.DELETED)));
			this.setCommandValue(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.COMMAND_VALUE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MonitorTplIndicatorVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MonitorTplIndicatorVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.NAME)));
			this.setIndicatorVariable(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.INDICATOR_VARIABLE)));
			this.setSnmpOid(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.SNMP_OID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.DELETE_BY)));
			this.setValueColumnName(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.VALUE_COLUMN_NAME)));
			this.setItemSort(DataParser.parse(Integer.class, map.get(MonitorTplIndicatorVOMeta.ITEM_SORT)));
			this.setStatus(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(MonitorTplIndicatorVOMeta.PAGE_SIZE)));
			this.setTpl(DataParser.parse(MonitorTpl.class, map.get(MonitorTplIndicatorVOMeta.TPL)));
			this.setMonitorIndicatorType(DataParser.parse(MonitorTplIndicatorType.class, map.get(MonitorTplIndicatorVOMeta.MONITOR_INDICATOR_TYPE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(MonitorTplIndicatorVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(MonitorTplIndicatorVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(MonitorTplIndicatorVOMeta.CODE));
				this.setDataKeepDay( (Integer)map.get(MonitorTplIndicatorVOMeta.DATA_KEEP_DAY));
				this.setNotes( (String)map.get(MonitorTplIndicatorVOMeta.NOTES));
				this.setMonitorMethod( (String)map.get(MonitorTplIndicatorVOMeta.MONITOR_METHOD));
				this.setMonitorTplCode( (String)map.get(MonitorTplIndicatorVOMeta.MONITOR_TPL_CODE));
				this.setIndicatorType( (String)map.get(MonitorTplIndicatorVOMeta.INDICATOR_TYPE));
				this.setUpdateBy( (String)map.get(MonitorTplIndicatorVOMeta.UPDATE_BY));
				this.setValueColumn( (String)map.get(MonitorTplIndicatorVOMeta.VALUE_COLUMN));
				this.setId( (String)map.get(MonitorTplIndicatorVOMeta.ID));
				this.setIntervalTime( (Integer)map.get(MonitorTplIndicatorVOMeta.INTERVAL_TIME));
				this.setUpdateTime( (Date)map.get(MonitorTplIndicatorVOMeta.UPDATE_TIME));
				this.setLabel( (String)map.get(MonitorTplIndicatorVOMeta.LABEL));
				this.setValueColumnMap( (String)map.get(MonitorTplIndicatorVOMeta.VALUE_COLUMN_MAP));
				this.setVersion( (Integer)map.get(MonitorTplIndicatorVOMeta.VERSION));
				this.setCommand( (String)map.get(MonitorTplIndicatorVOMeta.COMMAND));
				this.setTimeOut( (Integer)map.get(MonitorTplIndicatorVOMeta.TIME_OUT));
				this.setValueColumnType( (String)map.get(MonitorTplIndicatorVOMeta.VALUE_COLUMN_TYPE));
				this.setRowColType( (String)map.get(MonitorTplIndicatorVOMeta.ROW_COL_TYPE));
				this.setCreateBy( (String)map.get(MonitorTplIndicatorVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MonitorTplIndicatorVOMeta.DELETED));
				this.setCommandValue( (String)map.get(MonitorTplIndicatorVOMeta.COMMAND_VALUE));
				this.setCreateTime( (Date)map.get(MonitorTplIndicatorVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(MonitorTplIndicatorVOMeta.DELETE_TIME));
				this.setName( (String)map.get(MonitorTplIndicatorVOMeta.NAME));
				this.setIndicatorVariable( (String)map.get(MonitorTplIndicatorVOMeta.INDICATOR_VARIABLE));
				this.setSnmpOid( (String)map.get(MonitorTplIndicatorVOMeta.SNMP_OID));
				this.setDeleteBy( (String)map.get(MonitorTplIndicatorVOMeta.DELETE_BY));
				this.setValueColumnName( (String)map.get(MonitorTplIndicatorVOMeta.VALUE_COLUMN_NAME));
				this.setItemSort( (Integer)map.get(MonitorTplIndicatorVOMeta.ITEM_SORT));
				this.setStatus( (String)map.get(MonitorTplIndicatorVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(MonitorTplIndicatorVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(MonitorTplIndicatorVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(MonitorTplIndicatorVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(MonitorTplIndicatorVOMeta.PAGE_SIZE));
				this.setTpl( (MonitorTpl)map.get(MonitorTplIndicatorVOMeta.TPL));
				this.setMonitorIndicatorType( (MonitorTplIndicatorType)map.get(MonitorTplIndicatorVOMeta.MONITOR_INDICATOR_TYPE));
				this.setPageIndex( (Integer)map.get(MonitorTplIndicatorVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(MonitorTplIndicatorVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(MonitorTplIndicatorVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(MonitorTplIndicatorVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(MonitorTplIndicatorVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(MonitorTplIndicatorVOMeta.SEARCH_VALUE));
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
			this.setCode(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.CODE)));
			this.setDataKeepDay(DataParser.parse(Integer.class, r.getValue(MonitorTplIndicatorVOMeta.DATA_KEEP_DAY)));
			this.setNotes(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.NOTES)));
			this.setMonitorMethod(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.MONITOR_METHOD)));
			this.setMonitorTplCode(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.MONITOR_TPL_CODE)));
			this.setIndicatorType(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.INDICATOR_TYPE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.UPDATE_BY)));
			this.setValueColumn(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.VALUE_COLUMN)));
			this.setId(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.ID)));
			this.setIntervalTime(DataParser.parse(Integer.class, r.getValue(MonitorTplIndicatorVOMeta.INTERVAL_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MonitorTplIndicatorVOMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.LABEL)));
			this.setValueColumnMap(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.VALUE_COLUMN_MAP)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MonitorTplIndicatorVOMeta.VERSION)));
			this.setCommand(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.COMMAND)));
			this.setTimeOut(DataParser.parse(Integer.class, r.getValue(MonitorTplIndicatorVOMeta.TIME_OUT)));
			this.setValueColumnType(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.VALUE_COLUMN_TYPE)));
			this.setRowColType(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.ROW_COL_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MonitorTplIndicatorVOMeta.DELETED)));
			this.setCommandValue(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.COMMAND_VALUE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MonitorTplIndicatorVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MonitorTplIndicatorVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.NAME)));
			this.setIndicatorVariable(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.INDICATOR_VARIABLE)));
			this.setSnmpOid(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.SNMP_OID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.DELETE_BY)));
			this.setValueColumnName(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.VALUE_COLUMN_NAME)));
			this.setItemSort(DataParser.parse(Integer.class, r.getValue(MonitorTplIndicatorVOMeta.ITEM_SORT)));
			this.setStatus(DataParser.parse(String.class, r.getValue(MonitorTplIndicatorVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(MonitorTplIndicatorVOMeta.CODE));
				this.setDataKeepDay( (Integer)r.getValue(MonitorTplIndicatorVOMeta.DATA_KEEP_DAY));
				this.setNotes( (String)r.getValue(MonitorTplIndicatorVOMeta.NOTES));
				this.setMonitorMethod( (String)r.getValue(MonitorTplIndicatorVOMeta.MONITOR_METHOD));
				this.setMonitorTplCode( (String)r.getValue(MonitorTplIndicatorVOMeta.MONITOR_TPL_CODE));
				this.setIndicatorType( (String)r.getValue(MonitorTplIndicatorVOMeta.INDICATOR_TYPE));
				this.setUpdateBy( (String)r.getValue(MonitorTplIndicatorVOMeta.UPDATE_BY));
				this.setValueColumn( (String)r.getValue(MonitorTplIndicatorVOMeta.VALUE_COLUMN));
				this.setId( (String)r.getValue(MonitorTplIndicatorVOMeta.ID));
				this.setIntervalTime( (Integer)r.getValue(MonitorTplIndicatorVOMeta.INTERVAL_TIME));
				this.setUpdateTime( (Date)r.getValue(MonitorTplIndicatorVOMeta.UPDATE_TIME));
				this.setLabel( (String)r.getValue(MonitorTplIndicatorVOMeta.LABEL));
				this.setValueColumnMap( (String)r.getValue(MonitorTplIndicatorVOMeta.VALUE_COLUMN_MAP));
				this.setVersion( (Integer)r.getValue(MonitorTplIndicatorVOMeta.VERSION));
				this.setCommand( (String)r.getValue(MonitorTplIndicatorVOMeta.COMMAND));
				this.setTimeOut( (Integer)r.getValue(MonitorTplIndicatorVOMeta.TIME_OUT));
				this.setValueColumnType( (String)r.getValue(MonitorTplIndicatorVOMeta.VALUE_COLUMN_TYPE));
				this.setRowColType( (String)r.getValue(MonitorTplIndicatorVOMeta.ROW_COL_TYPE));
				this.setCreateBy( (String)r.getValue(MonitorTplIndicatorVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MonitorTplIndicatorVOMeta.DELETED));
				this.setCommandValue( (String)r.getValue(MonitorTplIndicatorVOMeta.COMMAND_VALUE));
				this.setCreateTime( (Date)r.getValue(MonitorTplIndicatorVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(MonitorTplIndicatorVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(MonitorTplIndicatorVOMeta.NAME));
				this.setIndicatorVariable( (String)r.getValue(MonitorTplIndicatorVOMeta.INDICATOR_VARIABLE));
				this.setSnmpOid( (String)r.getValue(MonitorTplIndicatorVOMeta.SNMP_OID));
				this.setDeleteBy( (String)r.getValue(MonitorTplIndicatorVOMeta.DELETE_BY));
				this.setValueColumnName( (String)r.getValue(MonitorTplIndicatorVOMeta.VALUE_COLUMN_NAME));
				this.setItemSort( (Integer)r.getValue(MonitorTplIndicatorVOMeta.ITEM_SORT));
				this.setStatus( (String)r.getValue(MonitorTplIndicatorVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}