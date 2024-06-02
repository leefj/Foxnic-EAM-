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
import com.dt.platform.domain.ops.meta.MonitorAlertVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 监控告警VO类型
 * <p>监控告警 , 数据表 ops_monitor_alert 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-06-01 23:51:34
 * @sign B8316D1F4E7A66EBCB7702AF11988742
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "监控告警VO类型 ; 监控告警 , 数据表 ops_monitor_alert 的通用VO类型" , parent = MonitorAlert.class)
public class MonitorAlertVO extends MonitorAlert {

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
	public MonitorAlertVO setPageIndex(Integer pageIndex) {
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
	public MonitorAlertVO setPageSize(Integer pageSize) {
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
	public MonitorAlertVO setSearchField(String searchField) {
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
	public MonitorAlertVO setFuzzyField(String fuzzyField) {
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
	public MonitorAlertVO setSearchValue(String searchValue) {
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
	public MonitorAlertVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public MonitorAlertVO addDirtyField(String... dirtyField) {
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
	public MonitorAlertVO setSortField(String sortField) {
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
	public MonitorAlertVO setSortType(String sortType) {
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
	public MonitorAlertVO setDataOrigin(String dataOrigin) {
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
	public MonitorAlertVO setQueryLogic(String queryLogic) {
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
	public MonitorAlertVO setRequestAction(String requestAction) {
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
	public MonitorAlertVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public MonitorAlertVO addId(String... id) {
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
	 * @return MonitorAlertVO , 转换好的 MonitorAlertVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorAlertVO , 转换好的 PoJo 对象
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
	public MonitorAlertVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MonitorAlertVO duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.MonitorAlertVOMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.MonitorAlertVOMeta.$$proxy$$();
		inst.setProcessMessage(this.getProcessMessage());
		inst.setNotes(this.getNotes());
		inst.setWarnLevel(this.getWarnLevel());
		inst.setTriggerName(this.getTriggerName());
		inst.setTriggerId(this.getTriggerId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setHandledTime(this.getHandledTime());
		inst.setWarnTime(this.getWarnTime());
		inst.setMonitorTplCode(this.getMonitorTplCode());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTriggerRuleDesc(this.getTriggerRuleDesc());
		inst.setNodeShowName(this.getNodeShowName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setWarnLevelName(this.getWarnLevelName());
		inst.setNodeId(this.getNodeId());
		inst.setAlertValue(this.getAlertValue());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setMonitorTplTrigger(this.getMonitorTplTrigger());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setTpl(this.getTpl());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setUser(this.getUser());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MonitorAlertVO clone(boolean deep) {
		return EntityContext.clone(MonitorAlertVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MonitorAlertVO
	 * @param monitorAlertMap 包含实体信息的 Map 对象
	 * @return MonitorAlertVO , 转换好的的 MonitorAlert 对象
	*/
	@Transient
	public static MonitorAlertVO createFrom(Map<String,Object> monitorAlertMap) {
		if(monitorAlertMap==null) return null;
		MonitorAlertVO vo = create();
		EntityContext.copyProperties(vo,monitorAlertMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 MonitorAlertVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorAlertVO , 转换好的的 MonitorAlert 对象
	*/
	@Transient
	public static MonitorAlertVO createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorAlertVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 MonitorAlertVO，等同于 new
	 * @return MonitorAlertVO 对象
	*/
	@Transient
	public static MonitorAlertVO create() {
		return new com.dt.platform.domain.ops.meta.MonitorAlertVOMeta.$$proxy$$();
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
			this.setProcessMessage(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.PROCESS_MESSAGE)));
			this.setNotes(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.NOTES)));
			this.setWarnLevel(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.WARN_LEVEL)));
			this.setTriggerName(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.TRIGGER_NAME)));
			this.setTriggerId(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.TRIGGER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MonitorAlertVOMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MonitorAlertVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MonitorAlertVOMeta.DELETED)));
			this.setHandledTime(DataParser.parse(Date.class, map.get(MonitorAlertVOMeta.HANDLED_TIME)));
			this.setWarnTime(DataParser.parse(Date.class, map.get(MonitorAlertVOMeta.WARN_TIME)));
			this.setMonitorTplCode(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.MONITOR_TPL_CODE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MonitorAlertVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MonitorAlertVOMeta.DELETE_TIME)));
			this.setTriggerRuleDesc(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.TRIGGER_RULE_DESC)));
			this.setNodeShowName(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.NODE_SHOW_NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.ID)));
			this.setWarnLevelName(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.WARN_LEVEL_NAME)));
			this.setNodeId(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.NODE_ID)));
			this.setAlertValue(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.ALERT_VALUE)));
			this.setStatus(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(MonitorAlertVOMeta.PAGE_SIZE)));
			this.setTpl(DataParser.parse(MonitorTpl.class, map.get(MonitorAlertVOMeta.TPL)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(MonitorAlertVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.QUERY_LOGIC)));
			this.setUser(DataParser.parse(Employee.class, map.get(MonitorAlertVOMeta.USER)));
			this.setSearchValue(DataParser.parse(String.class, map.get(MonitorAlertVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setProcessMessage( (String)map.get(MonitorAlertVOMeta.PROCESS_MESSAGE));
				this.setNotes( (String)map.get(MonitorAlertVOMeta.NOTES));
				this.setWarnLevel( (String)map.get(MonitorAlertVOMeta.WARN_LEVEL));
				this.setTriggerName( (String)map.get(MonitorAlertVOMeta.TRIGGER_NAME));
				this.setTriggerId( (String)map.get(MonitorAlertVOMeta.TRIGGER_ID));
				this.setUpdateTime( (Date)map.get(MonitorAlertVOMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(MonitorAlertVOMeta.USER_ID));
				this.setVersion( (Integer)map.get(MonitorAlertVOMeta.VERSION));
				this.setCreateBy( (String)map.get(MonitorAlertVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MonitorAlertVOMeta.DELETED));
				this.setHandledTime( (Date)map.get(MonitorAlertVOMeta.HANDLED_TIME));
				this.setWarnTime( (Date)map.get(MonitorAlertVOMeta.WARN_TIME));
				this.setMonitorTplCode( (String)map.get(MonitorAlertVOMeta.MONITOR_TPL_CODE));
				this.setCreateTime( (Date)map.get(MonitorAlertVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(MonitorAlertVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(MonitorAlertVOMeta.DELETE_TIME));
				this.setTriggerRuleDesc( (String)map.get(MonitorAlertVOMeta.TRIGGER_RULE_DESC));
				this.setNodeShowName( (String)map.get(MonitorAlertVOMeta.NODE_SHOW_NAME));
				this.setDeleteBy( (String)map.get(MonitorAlertVOMeta.DELETE_BY));
				this.setId( (String)map.get(MonitorAlertVOMeta.ID));
				this.setWarnLevelName( (String)map.get(MonitorAlertVOMeta.WARN_LEVEL_NAME));
				this.setNodeId( (String)map.get(MonitorAlertVOMeta.NODE_ID));
				this.setAlertValue( (String)map.get(MonitorAlertVOMeta.ALERT_VALUE));
				this.setStatus( (String)map.get(MonitorAlertVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(MonitorAlertVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(MonitorAlertVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(MonitorAlertVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(MonitorAlertVOMeta.PAGE_SIZE));
				this.setTpl( (MonitorTpl)map.get(MonitorAlertVOMeta.TPL));
				this.setPageIndex( (Integer)map.get(MonitorAlertVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(MonitorAlertVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(MonitorAlertVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(MonitorAlertVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(MonitorAlertVOMeta.QUERY_LOGIC));
				this.setUser( (Employee)map.get(MonitorAlertVOMeta.USER));
				this.setSearchValue( (String)map.get(MonitorAlertVOMeta.SEARCH_VALUE));
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
			this.setProcessMessage(DataParser.parse(String.class, r.getValue(MonitorAlertVOMeta.PROCESS_MESSAGE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(MonitorAlertVOMeta.NOTES)));
			this.setWarnLevel(DataParser.parse(String.class, r.getValue(MonitorAlertVOMeta.WARN_LEVEL)));
			this.setTriggerName(DataParser.parse(String.class, r.getValue(MonitorAlertVOMeta.TRIGGER_NAME)));
			this.setTriggerId(DataParser.parse(String.class, r.getValue(MonitorAlertVOMeta.TRIGGER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MonitorAlertVOMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(MonitorAlertVOMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MonitorAlertVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MonitorAlertVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MonitorAlertVOMeta.DELETED)));
			this.setHandledTime(DataParser.parse(Date.class, r.getValue(MonitorAlertVOMeta.HANDLED_TIME)));
			this.setWarnTime(DataParser.parse(Date.class, r.getValue(MonitorAlertVOMeta.WARN_TIME)));
			this.setMonitorTplCode(DataParser.parse(String.class, r.getValue(MonitorAlertVOMeta.MONITOR_TPL_CODE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MonitorAlertVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MonitorAlertVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MonitorAlertVOMeta.DELETE_TIME)));
			this.setTriggerRuleDesc(DataParser.parse(String.class, r.getValue(MonitorAlertVOMeta.TRIGGER_RULE_DESC)));
			this.setNodeShowName(DataParser.parse(String.class, r.getValue(MonitorAlertVOMeta.NODE_SHOW_NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MonitorAlertVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(MonitorAlertVOMeta.ID)));
			this.setWarnLevelName(DataParser.parse(String.class, r.getValue(MonitorAlertVOMeta.WARN_LEVEL_NAME)));
			this.setNodeId(DataParser.parse(String.class, r.getValue(MonitorAlertVOMeta.NODE_ID)));
			this.setAlertValue(DataParser.parse(String.class, r.getValue(MonitorAlertVOMeta.ALERT_VALUE)));
			this.setStatus(DataParser.parse(String.class, r.getValue(MonitorAlertVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setProcessMessage( (String)r.getValue(MonitorAlertVOMeta.PROCESS_MESSAGE));
				this.setNotes( (String)r.getValue(MonitorAlertVOMeta.NOTES));
				this.setWarnLevel( (String)r.getValue(MonitorAlertVOMeta.WARN_LEVEL));
				this.setTriggerName( (String)r.getValue(MonitorAlertVOMeta.TRIGGER_NAME));
				this.setTriggerId( (String)r.getValue(MonitorAlertVOMeta.TRIGGER_ID));
				this.setUpdateTime( (Date)r.getValue(MonitorAlertVOMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(MonitorAlertVOMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(MonitorAlertVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(MonitorAlertVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MonitorAlertVOMeta.DELETED));
				this.setHandledTime( (Date)r.getValue(MonitorAlertVOMeta.HANDLED_TIME));
				this.setWarnTime( (Date)r.getValue(MonitorAlertVOMeta.WARN_TIME));
				this.setMonitorTplCode( (String)r.getValue(MonitorAlertVOMeta.MONITOR_TPL_CODE));
				this.setCreateTime( (Date)r.getValue(MonitorAlertVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(MonitorAlertVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(MonitorAlertVOMeta.DELETE_TIME));
				this.setTriggerRuleDesc( (String)r.getValue(MonitorAlertVOMeta.TRIGGER_RULE_DESC));
				this.setNodeShowName( (String)r.getValue(MonitorAlertVOMeta.NODE_SHOW_NAME));
				this.setDeleteBy( (String)r.getValue(MonitorAlertVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(MonitorAlertVOMeta.ID));
				this.setWarnLevelName( (String)r.getValue(MonitorAlertVOMeta.WARN_LEVEL_NAME));
				this.setNodeId( (String)r.getValue(MonitorAlertVOMeta.NODE_ID));
				this.setAlertValue( (String)r.getValue(MonitorAlertVOMeta.ALERT_VALUE));
				this.setStatus( (String)r.getValue(MonitorAlertVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}