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
import com.dt.platform.domain.ops.meta.MonitorNodeVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 节点VO类型
 * <p>节点 , 数据表 ops_monitor_node 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-03 10:10:21
 * @sign 05DF7270C512DCD4908D3A955CF15039
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "节点VO类型 ; 节点 , 数据表 ops_monitor_node 的通用VO类型" , parent = MonitorNode.class)
public class MonitorNodeVO extends MonitorNode {

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
	public MonitorNodeVO setPageIndex(Integer pageIndex) {
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
	public MonitorNodeVO setPageSize(Integer pageSize) {
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
	public MonitorNodeVO setSearchField(String searchField) {
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
	public MonitorNodeVO setFuzzyField(String fuzzyField) {
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
	public MonitorNodeVO setSearchValue(String searchValue) {
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
	public MonitorNodeVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public MonitorNodeVO addDirtyField(String... dirtyField) {
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
	public MonitorNodeVO setSortField(String sortField) {
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
	public MonitorNodeVO setSortType(String sortType) {
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
	public MonitorNodeVO setDataOrigin(String dataOrigin) {
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
	public MonitorNodeVO setQueryLogic(String queryLogic) {
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
	public MonitorNodeVO setRequestAction(String requestAction) {
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
	public MonitorNodeVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public MonitorNodeVO addId(String... id) {
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
	 * @return MonitorNodeVO , 转换好的 MonitorNodeVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorNodeVO , 转换好的 PoJo 对象
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
	public MonitorNodeVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MonitorNodeVO duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.MonitorNodeVOMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.MonitorNodeVOMeta.$$proxy$$();
		inst.setNodeName(this.getNodeName());
		inst.setNotes(this.getNotes());
		inst.setGroupId(this.getGroupId());
		inst.setNodeIp(this.getNodeIp());
		inst.setPid(this.getPid());
		inst.setType(this.getType());
		inst.setSshVoucherId(this.getSshVoucherId());
		inst.setImpiPort(this.getImpiPort());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setSshPort(this.getSshPort());
		inst.setSnmpCommunity(this.getSnmpCommunity());
		inst.setJmxPort(this.getJmxPort());
		inst.setSnmpVersion(this.getSnmpVersion());
		inst.setVar(this.getVar());
		inst.setNodeEnabled(this.getNodeEnabled());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setNodeType(this.getNodeType());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setNodeNameShow(this.getNodeNameShow());
		inst.setJdbcUrl(this.getJdbcUrl());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setSubType(this.getSubType());
		inst.setZabbixAgentPort(this.getZabbixAgentPort());
		inst.setSnmpPort(this.getSnmpPort());
		inst.setAgentPort(this.getAgentPort());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setMonitorNodeValueList(this.getMonitorNodeValueList());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setMonitorNodeType(this.getMonitorNodeType());
			inst.setPageSize(this.getPageSize());
			inst.setMonitorNodeGroup(this.getMonitorNodeGroup());
			inst.setMonitorTplList(this.getMonitorTplList());
			inst.setSshVoucher(this.getSshVoucher());
			inst.setMonitorTplIds(this.getMonitorTplIds());
			inst.setMonitorNodeSubType(this.getMonitorNodeSubType());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setCalIndicatorTplCode(this.getCalIndicatorTplCode());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSearchValue(this.getSearchValue());
			inst.setMonitorNodeDb(this.getMonitorNodeDb());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MonitorNodeVO clone(boolean deep) {
		return EntityContext.clone(MonitorNodeVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MonitorNodeVO
	 * @param monitorNodeMap 包含实体信息的 Map 对象
	 * @return MonitorNodeVO , 转换好的的 MonitorNode 对象
	*/
	@Transient
	public static MonitorNodeVO createFrom(Map<String,Object> monitorNodeMap) {
		if(monitorNodeMap==null) return null;
		MonitorNodeVO vo = create();
		EntityContext.copyProperties(vo,monitorNodeMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 MonitorNodeVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorNodeVO , 转换好的的 MonitorNode 对象
	*/
	@Transient
	public static MonitorNodeVO createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorNodeVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 MonitorNodeVO，等同于 new
	 * @return MonitorNodeVO 对象
	*/
	@Transient
	public static MonitorNodeVO create() {
		return new com.dt.platform.domain.ops.meta.MonitorNodeVOMeta.$$proxy$$();
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
			this.setNodeName(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.NODE_NAME)));
			this.setNotes(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.NOTES)));
			this.setGroupId(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.GROUP_ID)));
			this.setNodeIp(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.NODE_IP)));
			this.setPid(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.PID)));
			this.setType(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.TYPE)));
			this.setSshVoucherId(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.SSH_VOUCHER_ID)));
			this.setImpiPort(DataParser.parse(Integer.class, map.get(MonitorNodeVOMeta.IMPI_PORT)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.ID)));
			this.setSshPort(DataParser.parse(Integer.class, map.get(MonitorNodeVOMeta.SSH_PORT)));
			this.setSnmpCommunity(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.SNMP_COMMUNITY)));
			this.setJmxPort(DataParser.parse(Integer.class, map.get(MonitorNodeVOMeta.JMX_PORT)));
			this.setSnmpVersion(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.SNMP_VERSION)));
			this.setVar(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.VAR)));
			this.setNodeEnabled(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.NODE_ENABLED)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MonitorNodeVOMeta.UPDATE_TIME)));
			this.setNodeType(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.NODE_TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MonitorNodeVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MonitorNodeVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MonitorNodeVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MonitorNodeVOMeta.DELETE_TIME)));
			this.setNodeNameShow(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.NODE_NAME_SHOW)));
			this.setJdbcUrl(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.JDBC_URL)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.DELETE_BY)));
			this.setSubType(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.SUB_TYPE)));
			this.setZabbixAgentPort(DataParser.parse(Integer.class, map.get(MonitorNodeVOMeta.ZABBIX_AGENT_PORT)));
			this.setSnmpPort(DataParser.parse(Integer.class, map.get(MonitorNodeVOMeta.SNMP_PORT)));
			this.setAgentPort(DataParser.parse(Integer.class, map.get(MonitorNodeVOMeta.AGENT_PORT)));
			this.setStatus(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.FUZZY_FIELD)));
			this.setMonitorNodeType(DataParser.parse(MonitorNodeType.class, map.get(MonitorNodeVOMeta.MONITOR_NODE_TYPE)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(MonitorNodeVOMeta.PAGE_SIZE)));
			this.setMonitorNodeGroup(DataParser.parse(MonitorNodeGroup.class, map.get(MonitorNodeVOMeta.MONITOR_NODE_GROUP)));
			this.setSshVoucher(DataParser.parse(MonitorVoucher.class, map.get(MonitorNodeVOMeta.SSH_VOUCHER)));
			this.setMonitorNodeSubType(DataParser.parse(MonitorNodeSubtype.class, map.get(MonitorNodeVOMeta.MONITOR_NODE_SUB_TYPE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(MonitorNodeVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.SORT_TYPE)));
			this.setCalIndicatorTplCode(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.CAL_INDICATOR_TPL_CODE)));
			this.setSortField(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(MonitorNodeVOMeta.SEARCH_VALUE)));
			this.setMonitorNodeDb(DataParser.parse(MonitorNodeDb.class, map.get(MonitorNodeVOMeta.MONITOR_NODE_DB)));
			return true;
		} else {
			try {
				this.setNodeName( (String)map.get(MonitorNodeVOMeta.NODE_NAME));
				this.setNotes( (String)map.get(MonitorNodeVOMeta.NOTES));
				this.setGroupId( (String)map.get(MonitorNodeVOMeta.GROUP_ID));
				this.setNodeIp( (String)map.get(MonitorNodeVOMeta.NODE_IP));
				this.setPid( (String)map.get(MonitorNodeVOMeta.PID));
				this.setType( (String)map.get(MonitorNodeVOMeta.TYPE));
				this.setSshVoucherId( (String)map.get(MonitorNodeVOMeta.SSH_VOUCHER_ID));
				this.setImpiPort( (Integer)map.get(MonitorNodeVOMeta.IMPI_PORT));
				this.setUpdateBy( (String)map.get(MonitorNodeVOMeta.UPDATE_BY));
				this.setId( (String)map.get(MonitorNodeVOMeta.ID));
				this.setSshPort( (Integer)map.get(MonitorNodeVOMeta.SSH_PORT));
				this.setSnmpCommunity( (String)map.get(MonitorNodeVOMeta.SNMP_COMMUNITY));
				this.setJmxPort( (Integer)map.get(MonitorNodeVOMeta.JMX_PORT));
				this.setSnmpVersion( (String)map.get(MonitorNodeVOMeta.SNMP_VERSION));
				this.setVar( (String)map.get(MonitorNodeVOMeta.VAR));
				this.setNodeEnabled( (String)map.get(MonitorNodeVOMeta.NODE_ENABLED));
				this.setUpdateTime( (Date)map.get(MonitorNodeVOMeta.UPDATE_TIME));
				this.setNodeType( (String)map.get(MonitorNodeVOMeta.NODE_TYPE));
				this.setVersion( (Integer)map.get(MonitorNodeVOMeta.VERSION));
				this.setCreateBy( (String)map.get(MonitorNodeVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MonitorNodeVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(MonitorNodeVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(MonitorNodeVOMeta.DELETE_TIME));
				this.setNodeNameShow( (String)map.get(MonitorNodeVOMeta.NODE_NAME_SHOW));
				this.setJdbcUrl( (String)map.get(MonitorNodeVOMeta.JDBC_URL));
				this.setDeleteBy( (String)map.get(MonitorNodeVOMeta.DELETE_BY));
				this.setSubType( (String)map.get(MonitorNodeVOMeta.SUB_TYPE));
				this.setZabbixAgentPort( (Integer)map.get(MonitorNodeVOMeta.ZABBIX_AGENT_PORT));
				this.setSnmpPort( (Integer)map.get(MonitorNodeVOMeta.SNMP_PORT));
				this.setAgentPort( (Integer)map.get(MonitorNodeVOMeta.AGENT_PORT));
				this.setStatus( (String)map.get(MonitorNodeVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(MonitorNodeVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(MonitorNodeVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(MonitorNodeVOMeta.FUZZY_FIELD));
				this.setMonitorNodeType( (MonitorNodeType)map.get(MonitorNodeVOMeta.MONITOR_NODE_TYPE));
				this.setPageSize( (Integer)map.get(MonitorNodeVOMeta.PAGE_SIZE));
				this.setMonitorNodeGroup( (MonitorNodeGroup)map.get(MonitorNodeVOMeta.MONITOR_NODE_GROUP));
				this.setSshVoucher( (MonitorVoucher)map.get(MonitorNodeVOMeta.SSH_VOUCHER));
				this.setMonitorNodeSubType( (MonitorNodeSubtype)map.get(MonitorNodeVOMeta.MONITOR_NODE_SUB_TYPE));
				this.setPageIndex( (Integer)map.get(MonitorNodeVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(MonitorNodeVOMeta.SORT_TYPE));
				this.setCalIndicatorTplCode( (String)map.get(MonitorNodeVOMeta.CAL_INDICATOR_TPL_CODE));
				this.setSortField( (String)map.get(MonitorNodeVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(MonitorNodeVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(MonitorNodeVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(MonitorNodeVOMeta.SEARCH_VALUE));
				this.setMonitorNodeDb( (MonitorNodeDb)map.get(MonitorNodeVOMeta.MONITOR_NODE_DB));
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
			this.setNodeName(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.NODE_NAME)));
			this.setNotes(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.NOTES)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.GROUP_ID)));
			this.setNodeIp(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.NODE_IP)));
			this.setPid(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.PID)));
			this.setType(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.TYPE)));
			this.setSshVoucherId(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.SSH_VOUCHER_ID)));
			this.setImpiPort(DataParser.parse(Integer.class, r.getValue(MonitorNodeVOMeta.IMPI_PORT)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.ID)));
			this.setSshPort(DataParser.parse(Integer.class, r.getValue(MonitorNodeVOMeta.SSH_PORT)));
			this.setSnmpCommunity(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.SNMP_COMMUNITY)));
			this.setJmxPort(DataParser.parse(Integer.class, r.getValue(MonitorNodeVOMeta.JMX_PORT)));
			this.setSnmpVersion(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.SNMP_VERSION)));
			this.setVar(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.VAR)));
			this.setNodeEnabled(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.NODE_ENABLED)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MonitorNodeVOMeta.UPDATE_TIME)));
			this.setNodeType(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.NODE_TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MonitorNodeVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MonitorNodeVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MonitorNodeVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MonitorNodeVOMeta.DELETE_TIME)));
			this.setNodeNameShow(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.NODE_NAME_SHOW)));
			this.setJdbcUrl(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.JDBC_URL)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.DELETE_BY)));
			this.setSubType(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.SUB_TYPE)));
			this.setZabbixAgentPort(DataParser.parse(Integer.class, r.getValue(MonitorNodeVOMeta.ZABBIX_AGENT_PORT)));
			this.setSnmpPort(DataParser.parse(Integer.class, r.getValue(MonitorNodeVOMeta.SNMP_PORT)));
			this.setAgentPort(DataParser.parse(Integer.class, r.getValue(MonitorNodeVOMeta.AGENT_PORT)));
			this.setStatus(DataParser.parse(String.class, r.getValue(MonitorNodeVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNodeName( (String)r.getValue(MonitorNodeVOMeta.NODE_NAME));
				this.setNotes( (String)r.getValue(MonitorNodeVOMeta.NOTES));
				this.setGroupId( (String)r.getValue(MonitorNodeVOMeta.GROUP_ID));
				this.setNodeIp( (String)r.getValue(MonitorNodeVOMeta.NODE_IP));
				this.setPid( (String)r.getValue(MonitorNodeVOMeta.PID));
				this.setType( (String)r.getValue(MonitorNodeVOMeta.TYPE));
				this.setSshVoucherId( (String)r.getValue(MonitorNodeVOMeta.SSH_VOUCHER_ID));
				this.setImpiPort( (Integer)r.getValue(MonitorNodeVOMeta.IMPI_PORT));
				this.setUpdateBy( (String)r.getValue(MonitorNodeVOMeta.UPDATE_BY));
				this.setId( (String)r.getValue(MonitorNodeVOMeta.ID));
				this.setSshPort( (Integer)r.getValue(MonitorNodeVOMeta.SSH_PORT));
				this.setSnmpCommunity( (String)r.getValue(MonitorNodeVOMeta.SNMP_COMMUNITY));
				this.setJmxPort( (Integer)r.getValue(MonitorNodeVOMeta.JMX_PORT));
				this.setSnmpVersion( (String)r.getValue(MonitorNodeVOMeta.SNMP_VERSION));
				this.setVar( (String)r.getValue(MonitorNodeVOMeta.VAR));
				this.setNodeEnabled( (String)r.getValue(MonitorNodeVOMeta.NODE_ENABLED));
				this.setUpdateTime( (Date)r.getValue(MonitorNodeVOMeta.UPDATE_TIME));
				this.setNodeType( (String)r.getValue(MonitorNodeVOMeta.NODE_TYPE));
				this.setVersion( (Integer)r.getValue(MonitorNodeVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(MonitorNodeVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MonitorNodeVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(MonitorNodeVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(MonitorNodeVOMeta.DELETE_TIME));
				this.setNodeNameShow( (String)r.getValue(MonitorNodeVOMeta.NODE_NAME_SHOW));
				this.setJdbcUrl( (String)r.getValue(MonitorNodeVOMeta.JDBC_URL));
				this.setDeleteBy( (String)r.getValue(MonitorNodeVOMeta.DELETE_BY));
				this.setSubType( (String)r.getValue(MonitorNodeVOMeta.SUB_TYPE));
				this.setZabbixAgentPort( (Integer)r.getValue(MonitorNodeVOMeta.ZABBIX_AGENT_PORT));
				this.setSnmpPort( (Integer)r.getValue(MonitorNodeVOMeta.SNMP_PORT));
				this.setAgentPort( (Integer)r.getValue(MonitorNodeVOMeta.AGENT_PORT));
				this.setStatus( (String)r.getValue(MonitorNodeVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}