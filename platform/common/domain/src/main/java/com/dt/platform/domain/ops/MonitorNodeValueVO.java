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
import com.dt.platform.domain.ops.meta.MonitorNodeValueVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.math.BigDecimal;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 节点数值VO类型
 * <p>节点数值 , 数据表 ops_monitor_node_value 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-02 18:25:18
 * @sign 42564E52908A2C6E7221BF02C210266E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "节点数值VO类型 ; 节点数值 , 数据表 ops_monitor_node_value 的通用VO类型" , parent = MonitorNodeValue.class)
public class MonitorNodeValueVO extends MonitorNodeValue {

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
	public MonitorNodeValueVO setPageIndex(Integer pageIndex) {
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
	public MonitorNodeValueVO setPageSize(Integer pageSize) {
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
	public MonitorNodeValueVO setSearchField(String searchField) {
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
	public MonitorNodeValueVO setFuzzyField(String fuzzyField) {
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
	public MonitorNodeValueVO setSearchValue(String searchValue) {
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
	public MonitorNodeValueVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public MonitorNodeValueVO addDirtyField(String... dirtyField) {
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
	public MonitorNodeValueVO setSortField(String sortField) {
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
	public MonitorNodeValueVO setSortType(String sortType) {
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
	public MonitorNodeValueVO setDataOrigin(String dataOrigin) {
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
	public MonitorNodeValueVO setQueryLogic(String queryLogic) {
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
	public MonitorNodeValueVO setRequestAction(String requestAction) {
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
	public MonitorNodeValueVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public MonitorNodeValueVO addId(String... id) {
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
	 * @return MonitorNodeValueVO , 转换好的 MonitorNodeValueVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorNodeValueVO , 转换好的 PoJo 对象
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
	public MonitorNodeValueVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MonitorNodeValueVO duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.MonitorNodeValueVOMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.MonitorNodeValueVOMeta.$$proxy$$();
		inst.setPMemorySize(this.getPMemorySize());
		inst.setOsLoad15(this.getOsLoad15());
		inst.setOsLoad(this.getOsLoad());
		inst.setCpuFree(this.getCpuFree());
		inst.setHostname(this.getHostname());
		inst.setDbConnectNumber(this.getDbConnectNumber());
		inst.setMonitorTplCode(this.getMonitorTplCode());
		inst.setListCode3(this.getListCode3());
		inst.setListCode2(this.getListCode2());
		inst.setId(this.getId());
		inst.setListCode1(this.getListCode1());
		inst.setOsVerion(this.getOsVerion());
		inst.setInfo(this.getInfo());
		inst.setValueBstr1(this.getValueBstr1());
		inst.setOsDatetime(this.getOsDatetime());
		inst.setCpuIdle(this.getCpuIdle());
		inst.setNodeVersion(this.getNodeVersion());
		inst.setVersion(this.getVersion());
		inst.setDbSize(this.getDbSize());
		inst.setVMemorySize(this.getVMemorySize());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setBoottime(this.getBoottime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setNodeId(this.getNodeId());
		inst.setNetworkFlowDown(this.getNetworkFlowDown());
		inst.setListLabel2(this.getListLabel2());
		inst.setListValueStr3(this.getListValueStr3());
		inst.setCode3(this.getCode3());
		inst.setListLabel3(this.getListLabel3());
		inst.setListValueStr2(this.getListValueStr2());
		inst.setCode2(this.getCode2());
		inst.setCode1(this.getCode1());
		inst.setCpuUsed(this.getCpuUsed());
		inst.setListValueInt1(this.getListValueInt1());
		inst.setValueNumber2(this.getValueNumber2());
		inst.setListValueStr1(this.getListValueStr1());
		inst.setListValueInt2(this.getListValueInt2());
		inst.setValueNumber3(this.getValueNumber3());
		inst.setListLabel1(this.getListLabel1());
		inst.setListValueInt3(this.getListValueInt3());
		inst.setIsConnected(this.getIsConnected());
		inst.setValueNumber1(this.getValueNumber1());
		inst.setUid(this.getUid());
		inst.setCpuUser(this.getCpuUser());
		inst.setProcessCnt(this.getProcessCnt());
		inst.setCpuSys(this.getCpuSys());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setNetworkFlowUp(this.getNetworkFlowUp());
		inst.setDbStatus(this.getDbStatus());
		inst.setPMemoryUsed(this.getPMemoryUsed());
		inst.setCpuNumber(this.getCpuNumber());
		inst.setValueInt3(this.getValueInt3());
		inst.setValueInt2(this.getValueInt2());
		inst.setValueInt1(this.getValueInt1());
		inst.setListValueNumber2(this.getListValueNumber2());
		inst.setListValueNumber3(this.getListValueNumber3());
		inst.setListValueNumber1(this.getListValueNumber1());
		inst.setIndicatorCode(this.getIndicatorCode());
		inst.setValueStr3(this.getValueStr3());
		inst.setValueStr2(this.getValueStr2());
		inst.setValueStr1(this.getValueStr1());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setResultMessage(this.getResultMessage());
		inst.setLabel1(this.getLabel1());
		inst.setLabel2(this.getLabel2());
		inst.setLabel3(this.getLabel3());
		inst.setResultStatus(this.getResultStatus());
		inst.setCreateBy(this.getCreateBy());
		inst.setRecordTime(this.getRecordTime());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setOsLoad5(this.getOsLoad5());
		inst.setVMemoryUsed(this.getVMemoryUsed());
		inst.setArch(this.getArch());
		inst.setCpuWait(this.getCpuWait());
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
	public MonitorNodeValueVO clone(boolean deep) {
		return EntityContext.clone(MonitorNodeValueVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MonitorNodeValueVO
	 * @param monitorNodeValueMap 包含实体信息的 Map 对象
	 * @return MonitorNodeValueVO , 转换好的的 MonitorNodeValue 对象
	*/
	@Transient
	public static MonitorNodeValueVO createFrom(Map<String,Object> monitorNodeValueMap) {
		if(monitorNodeValueMap==null) return null;
		MonitorNodeValueVO vo = create();
		EntityContext.copyProperties(vo,monitorNodeValueMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 MonitorNodeValueVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorNodeValueVO , 转换好的的 MonitorNodeValue 对象
	*/
	@Transient
	public static MonitorNodeValueVO createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorNodeValueVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 MonitorNodeValueVO，等同于 new
	 * @return MonitorNodeValueVO 对象
	*/
	@Transient
	public static MonitorNodeValueVO create() {
		return new com.dt.platform.domain.ops.meta.MonitorNodeValueVOMeta.$$proxy$$();
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
			this.setPMemorySize(DataParser.parse(Long.class, map.get(MonitorNodeValueVOMeta.P_MEMORY_SIZE)));
			this.setOsLoad15(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.OS_LOAD15)));
			this.setOsLoad(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.OS_LOAD)));
			this.setCpuFree(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.CPU_FREE)));
			this.setHostname(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.HOSTNAME)));
			this.setDbConnectNumber(DataParser.parse(Integer.class, map.get(MonitorNodeValueVOMeta.DB_CONNECT_NUMBER)));
			this.setMonitorTplCode(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.MONITOR_TPL_CODE)));
			this.setListCode3(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.LIST_CODE3)));
			this.setListCode2(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.LIST_CODE2)));
			this.setId(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.ID)));
			this.setListCode1(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.LIST_CODE1)));
			this.setOsVerion(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.OS_VERION)));
			this.setInfo(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.INFO)));
			this.setValueBstr1(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.VALUE_BSTR1)));
			this.setOsDatetime(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.OS_DATETIME)));
			this.setCpuIdle(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.CPU_IDLE)));
			this.setNodeVersion(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.NODE_VERSION)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MonitorNodeValueVOMeta.VERSION)));
			this.setDbSize(DataParser.parse(Long.class, map.get(MonitorNodeValueVOMeta.DB_SIZE)));
			this.setVMemorySize(DataParser.parse(Long.class, map.get(MonitorNodeValueVOMeta.V_MEMORY_SIZE)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MonitorNodeValueVOMeta.DELETE_TIME)));
			this.setBoottime(DataParser.parse(Date.class, map.get(MonitorNodeValueVOMeta.BOOTTIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.DELETE_BY)));
			this.setNodeId(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.NODE_ID)));
			this.setNetworkFlowDown(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.NETWORK_FLOW_DOWN)));
			this.setListLabel2(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.LIST_LABEL2)));
			this.setListValueStr3(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.LIST_VALUE_STR3)));
			this.setCode3(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.CODE3)));
			this.setListLabel3(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.LIST_LABEL3)));
			this.setListValueStr2(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.LIST_VALUE_STR2)));
			this.setCode2(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.CODE2)));
			this.setCode1(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.CODE1)));
			this.setCpuUsed(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.CPU_USED)));
			this.setListValueInt1(DataParser.parse(Long.class, map.get(MonitorNodeValueVOMeta.LIST_VALUE_INT1)));
			this.setValueNumber2(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.VALUE_NUMBER2)));
			this.setListValueStr1(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.LIST_VALUE_STR1)));
			this.setListValueInt2(DataParser.parse(Long.class, map.get(MonitorNodeValueVOMeta.LIST_VALUE_INT2)));
			this.setValueNumber3(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.VALUE_NUMBER3)));
			this.setListLabel1(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.LIST_LABEL1)));
			this.setListValueInt3(DataParser.parse(Long.class, map.get(MonitorNodeValueVOMeta.LIST_VALUE_INT3)));
			this.setIsConnected(DataParser.parse(Integer.class, map.get(MonitorNodeValueVOMeta.IS_CONNECTED)));
			this.setValueNumber1(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.VALUE_NUMBER1)));
			this.setUid(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.UID)));
			this.setCpuUser(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.CPU_USER)));
			this.setProcessCnt(DataParser.parse(Integer.class, map.get(MonitorNodeValueVOMeta.PROCESS_CNT)));
			this.setCpuSys(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.CPU_SYS)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.UPDATE_BY)));
			this.setNetworkFlowUp(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.NETWORK_FLOW_UP)));
			this.setDbStatus(DataParser.parse(Integer.class, map.get(MonitorNodeValueVOMeta.DB_STATUS)));
			this.setPMemoryUsed(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.P_MEMORY_USED)));
			this.setCpuNumber(DataParser.parse(Integer.class, map.get(MonitorNodeValueVOMeta.CPU_NUMBER)));
			this.setValueInt3(DataParser.parse(Long.class, map.get(MonitorNodeValueVOMeta.VALUE_INT3)));
			this.setValueInt2(DataParser.parse(Long.class, map.get(MonitorNodeValueVOMeta.VALUE_INT2)));
			this.setValueInt1(DataParser.parse(Long.class, map.get(MonitorNodeValueVOMeta.VALUE_INT1)));
			this.setListValueNumber2(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.LIST_VALUE_NUMBER2)));
			this.setListValueNumber3(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.LIST_VALUE_NUMBER3)));
			this.setListValueNumber1(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.LIST_VALUE_NUMBER1)));
			this.setIndicatorCode(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.INDICATOR_CODE)));
			this.setValueStr3(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.VALUE_STR3)));
			this.setValueStr2(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.VALUE_STR2)));
			this.setValueStr1(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.VALUE_STR1)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MonitorNodeValueVOMeta.UPDATE_TIME)));
			this.setResultMessage(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.RESULT_MESSAGE)));
			this.setLabel1(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.LABEL1)));
			this.setLabel2(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.LABEL2)));
			this.setLabel3(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.LABEL3)));
			this.setResultStatus(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.RESULT_STATUS)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, map.get(MonitorNodeValueVOMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MonitorNodeValueVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MonitorNodeValueVOMeta.CREATE_TIME)));
			this.setOsLoad5(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.OS_LOAD5)));
			this.setVMemoryUsed(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.V_MEMORY_USED)));
			this.setArch(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.ARCH)));
			this.setCpuWait(DataParser.parse(BigDecimal.class, map.get(MonitorNodeValueVOMeta.CPU_WAIT)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(MonitorNodeValueVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.SORT_TYPE)));
			this.setRequestAction(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(MonitorNodeValueVOMeta.PAGE_SIZE)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(MonitorNodeValueVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setPMemorySize( (Long)map.get(MonitorNodeValueVOMeta.P_MEMORY_SIZE));
				this.setOsLoad15( (BigDecimal)map.get(MonitorNodeValueVOMeta.OS_LOAD15));
				this.setOsLoad( (BigDecimal)map.get(MonitorNodeValueVOMeta.OS_LOAD));
				this.setCpuFree( (BigDecimal)map.get(MonitorNodeValueVOMeta.CPU_FREE));
				this.setHostname( (String)map.get(MonitorNodeValueVOMeta.HOSTNAME));
				this.setDbConnectNumber( (Integer)map.get(MonitorNodeValueVOMeta.DB_CONNECT_NUMBER));
				this.setMonitorTplCode( (String)map.get(MonitorNodeValueVOMeta.MONITOR_TPL_CODE));
				this.setListCode3( (String)map.get(MonitorNodeValueVOMeta.LIST_CODE3));
				this.setListCode2( (String)map.get(MonitorNodeValueVOMeta.LIST_CODE2));
				this.setId( (String)map.get(MonitorNodeValueVOMeta.ID));
				this.setListCode1( (String)map.get(MonitorNodeValueVOMeta.LIST_CODE1));
				this.setOsVerion( (String)map.get(MonitorNodeValueVOMeta.OS_VERION));
				this.setInfo( (String)map.get(MonitorNodeValueVOMeta.INFO));
				this.setValueBstr1( (String)map.get(MonitorNodeValueVOMeta.VALUE_BSTR1));
				this.setOsDatetime( (String)map.get(MonitorNodeValueVOMeta.OS_DATETIME));
				this.setCpuIdle( (BigDecimal)map.get(MonitorNodeValueVOMeta.CPU_IDLE));
				this.setNodeVersion( (String)map.get(MonitorNodeValueVOMeta.NODE_VERSION));
				this.setVersion( (Integer)map.get(MonitorNodeValueVOMeta.VERSION));
				this.setDbSize( (Long)map.get(MonitorNodeValueVOMeta.DB_SIZE));
				this.setVMemorySize( (Long)map.get(MonitorNodeValueVOMeta.V_MEMORY_SIZE));
				this.setDeleteTime( (Date)map.get(MonitorNodeValueVOMeta.DELETE_TIME));
				this.setBoottime( (Date)map.get(MonitorNodeValueVOMeta.BOOTTIME));
				this.setDeleteBy( (String)map.get(MonitorNodeValueVOMeta.DELETE_BY));
				this.setNodeId( (String)map.get(MonitorNodeValueVOMeta.NODE_ID));
				this.setNetworkFlowDown( (BigDecimal)map.get(MonitorNodeValueVOMeta.NETWORK_FLOW_DOWN));
				this.setListLabel2( (String)map.get(MonitorNodeValueVOMeta.LIST_LABEL2));
				this.setListValueStr3( (String)map.get(MonitorNodeValueVOMeta.LIST_VALUE_STR3));
				this.setCode3( (String)map.get(MonitorNodeValueVOMeta.CODE3));
				this.setListLabel3( (String)map.get(MonitorNodeValueVOMeta.LIST_LABEL3));
				this.setListValueStr2( (String)map.get(MonitorNodeValueVOMeta.LIST_VALUE_STR2));
				this.setCode2( (String)map.get(MonitorNodeValueVOMeta.CODE2));
				this.setCode1( (String)map.get(MonitorNodeValueVOMeta.CODE1));
				this.setCpuUsed( (BigDecimal)map.get(MonitorNodeValueVOMeta.CPU_USED));
				this.setListValueInt1( (Long)map.get(MonitorNodeValueVOMeta.LIST_VALUE_INT1));
				this.setValueNumber2( (BigDecimal)map.get(MonitorNodeValueVOMeta.VALUE_NUMBER2));
				this.setListValueStr1( (String)map.get(MonitorNodeValueVOMeta.LIST_VALUE_STR1));
				this.setListValueInt2( (Long)map.get(MonitorNodeValueVOMeta.LIST_VALUE_INT2));
				this.setValueNumber3( (BigDecimal)map.get(MonitorNodeValueVOMeta.VALUE_NUMBER3));
				this.setListLabel1( (String)map.get(MonitorNodeValueVOMeta.LIST_LABEL1));
				this.setListValueInt3( (Long)map.get(MonitorNodeValueVOMeta.LIST_VALUE_INT3));
				this.setIsConnected( (Integer)map.get(MonitorNodeValueVOMeta.IS_CONNECTED));
				this.setValueNumber1( (BigDecimal)map.get(MonitorNodeValueVOMeta.VALUE_NUMBER1));
				this.setUid( (String)map.get(MonitorNodeValueVOMeta.UID));
				this.setCpuUser( (BigDecimal)map.get(MonitorNodeValueVOMeta.CPU_USER));
				this.setProcessCnt( (Integer)map.get(MonitorNodeValueVOMeta.PROCESS_CNT));
				this.setCpuSys( (BigDecimal)map.get(MonitorNodeValueVOMeta.CPU_SYS));
				this.setUpdateBy( (String)map.get(MonitorNodeValueVOMeta.UPDATE_BY));
				this.setNetworkFlowUp( (BigDecimal)map.get(MonitorNodeValueVOMeta.NETWORK_FLOW_UP));
				this.setDbStatus( (Integer)map.get(MonitorNodeValueVOMeta.DB_STATUS));
				this.setPMemoryUsed( (BigDecimal)map.get(MonitorNodeValueVOMeta.P_MEMORY_USED));
				this.setCpuNumber( (Integer)map.get(MonitorNodeValueVOMeta.CPU_NUMBER));
				this.setValueInt3( (Long)map.get(MonitorNodeValueVOMeta.VALUE_INT3));
				this.setValueInt2( (Long)map.get(MonitorNodeValueVOMeta.VALUE_INT2));
				this.setValueInt1( (Long)map.get(MonitorNodeValueVOMeta.VALUE_INT1));
				this.setListValueNumber2( (BigDecimal)map.get(MonitorNodeValueVOMeta.LIST_VALUE_NUMBER2));
				this.setListValueNumber3( (BigDecimal)map.get(MonitorNodeValueVOMeta.LIST_VALUE_NUMBER3));
				this.setListValueNumber1( (BigDecimal)map.get(MonitorNodeValueVOMeta.LIST_VALUE_NUMBER1));
				this.setIndicatorCode( (String)map.get(MonitorNodeValueVOMeta.INDICATOR_CODE));
				this.setValueStr3( (String)map.get(MonitorNodeValueVOMeta.VALUE_STR3));
				this.setValueStr2( (String)map.get(MonitorNodeValueVOMeta.VALUE_STR2));
				this.setValueStr1( (String)map.get(MonitorNodeValueVOMeta.VALUE_STR1));
				this.setUpdateTime( (Date)map.get(MonitorNodeValueVOMeta.UPDATE_TIME));
				this.setResultMessage( (String)map.get(MonitorNodeValueVOMeta.RESULT_MESSAGE));
				this.setLabel1( (String)map.get(MonitorNodeValueVOMeta.LABEL1));
				this.setLabel2( (String)map.get(MonitorNodeValueVOMeta.LABEL2));
				this.setLabel3( (String)map.get(MonitorNodeValueVOMeta.LABEL3));
				this.setResultStatus( (String)map.get(MonitorNodeValueVOMeta.RESULT_STATUS));
				this.setCreateBy( (String)map.get(MonitorNodeValueVOMeta.CREATE_BY));
				this.setRecordTime( (Date)map.get(MonitorNodeValueVOMeta.RECORD_TIME));
				this.setDeleted( (Integer)map.get(MonitorNodeValueVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(MonitorNodeValueVOMeta.CREATE_TIME));
				this.setOsLoad5( (BigDecimal)map.get(MonitorNodeValueVOMeta.OS_LOAD5));
				this.setVMemoryUsed( (BigDecimal)map.get(MonitorNodeValueVOMeta.V_MEMORY_USED));
				this.setArch( (String)map.get(MonitorNodeValueVOMeta.ARCH));
				this.setCpuWait( (BigDecimal)map.get(MonitorNodeValueVOMeta.CPU_WAIT));
				// others
				this.setSearchField( (String)map.get(MonitorNodeValueVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(MonitorNodeValueVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(MonitorNodeValueVOMeta.SORT_TYPE));
				this.setRequestAction( (String)map.get(MonitorNodeValueVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(MonitorNodeValueVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(MonitorNodeValueVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(MonitorNodeValueVOMeta.PAGE_SIZE));
				this.setDataOrigin( (String)map.get(MonitorNodeValueVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(MonitorNodeValueVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(MonitorNodeValueVOMeta.SEARCH_VALUE));
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
			this.setPMemorySize(DataParser.parse(Long.class, r.getValue(MonitorNodeValueVOMeta.P_MEMORY_SIZE)));
			this.setOsLoad15(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.OS_LOAD15)));
			this.setOsLoad(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.OS_LOAD)));
			this.setCpuFree(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.CPU_FREE)));
			this.setHostname(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.HOSTNAME)));
			this.setDbConnectNumber(DataParser.parse(Integer.class, r.getValue(MonitorNodeValueVOMeta.DB_CONNECT_NUMBER)));
			this.setMonitorTplCode(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.MONITOR_TPL_CODE)));
			this.setListCode3(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.LIST_CODE3)));
			this.setListCode2(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.LIST_CODE2)));
			this.setId(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.ID)));
			this.setListCode1(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.LIST_CODE1)));
			this.setOsVerion(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.OS_VERION)));
			this.setInfo(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.INFO)));
			this.setValueBstr1(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.VALUE_BSTR1)));
			this.setOsDatetime(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.OS_DATETIME)));
			this.setCpuIdle(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.CPU_IDLE)));
			this.setNodeVersion(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.NODE_VERSION)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MonitorNodeValueVOMeta.VERSION)));
			this.setDbSize(DataParser.parse(Long.class, r.getValue(MonitorNodeValueVOMeta.DB_SIZE)));
			this.setVMemorySize(DataParser.parse(Long.class, r.getValue(MonitorNodeValueVOMeta.V_MEMORY_SIZE)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MonitorNodeValueVOMeta.DELETE_TIME)));
			this.setBoottime(DataParser.parse(Date.class, r.getValue(MonitorNodeValueVOMeta.BOOTTIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.DELETE_BY)));
			this.setNodeId(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.NODE_ID)));
			this.setNetworkFlowDown(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.NETWORK_FLOW_DOWN)));
			this.setListLabel2(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.LIST_LABEL2)));
			this.setListValueStr3(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.LIST_VALUE_STR3)));
			this.setCode3(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.CODE3)));
			this.setListLabel3(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.LIST_LABEL3)));
			this.setListValueStr2(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.LIST_VALUE_STR2)));
			this.setCode2(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.CODE2)));
			this.setCode1(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.CODE1)));
			this.setCpuUsed(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.CPU_USED)));
			this.setListValueInt1(DataParser.parse(Long.class, r.getValue(MonitorNodeValueVOMeta.LIST_VALUE_INT1)));
			this.setValueNumber2(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.VALUE_NUMBER2)));
			this.setListValueStr1(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.LIST_VALUE_STR1)));
			this.setListValueInt2(DataParser.parse(Long.class, r.getValue(MonitorNodeValueVOMeta.LIST_VALUE_INT2)));
			this.setValueNumber3(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.VALUE_NUMBER3)));
			this.setListLabel1(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.LIST_LABEL1)));
			this.setListValueInt3(DataParser.parse(Long.class, r.getValue(MonitorNodeValueVOMeta.LIST_VALUE_INT3)));
			this.setIsConnected(DataParser.parse(Integer.class, r.getValue(MonitorNodeValueVOMeta.IS_CONNECTED)));
			this.setValueNumber1(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.VALUE_NUMBER1)));
			this.setUid(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.UID)));
			this.setCpuUser(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.CPU_USER)));
			this.setProcessCnt(DataParser.parse(Integer.class, r.getValue(MonitorNodeValueVOMeta.PROCESS_CNT)));
			this.setCpuSys(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.CPU_SYS)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.UPDATE_BY)));
			this.setNetworkFlowUp(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.NETWORK_FLOW_UP)));
			this.setDbStatus(DataParser.parse(Integer.class, r.getValue(MonitorNodeValueVOMeta.DB_STATUS)));
			this.setPMemoryUsed(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.P_MEMORY_USED)));
			this.setCpuNumber(DataParser.parse(Integer.class, r.getValue(MonitorNodeValueVOMeta.CPU_NUMBER)));
			this.setValueInt3(DataParser.parse(Long.class, r.getValue(MonitorNodeValueVOMeta.VALUE_INT3)));
			this.setValueInt2(DataParser.parse(Long.class, r.getValue(MonitorNodeValueVOMeta.VALUE_INT2)));
			this.setValueInt1(DataParser.parse(Long.class, r.getValue(MonitorNodeValueVOMeta.VALUE_INT1)));
			this.setListValueNumber2(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.LIST_VALUE_NUMBER2)));
			this.setListValueNumber3(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.LIST_VALUE_NUMBER3)));
			this.setListValueNumber1(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.LIST_VALUE_NUMBER1)));
			this.setIndicatorCode(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.INDICATOR_CODE)));
			this.setValueStr3(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.VALUE_STR3)));
			this.setValueStr2(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.VALUE_STR2)));
			this.setValueStr1(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.VALUE_STR1)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MonitorNodeValueVOMeta.UPDATE_TIME)));
			this.setResultMessage(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.RESULT_MESSAGE)));
			this.setLabel1(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.LABEL1)));
			this.setLabel2(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.LABEL2)));
			this.setLabel3(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.LABEL3)));
			this.setResultStatus(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.RESULT_STATUS)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, r.getValue(MonitorNodeValueVOMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MonitorNodeValueVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MonitorNodeValueVOMeta.CREATE_TIME)));
			this.setOsLoad5(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.OS_LOAD5)));
			this.setVMemoryUsed(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.V_MEMORY_USED)));
			this.setArch(DataParser.parse(String.class, r.getValue(MonitorNodeValueVOMeta.ARCH)));
			this.setCpuWait(DataParser.parse(BigDecimal.class, r.getValue(MonitorNodeValueVOMeta.CPU_WAIT)));
			return true;
		} else {
			try {
				this.setPMemorySize( (Long)r.getValue(MonitorNodeValueVOMeta.P_MEMORY_SIZE));
				this.setOsLoad15( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.OS_LOAD15));
				this.setOsLoad( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.OS_LOAD));
				this.setCpuFree( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.CPU_FREE));
				this.setHostname( (String)r.getValue(MonitorNodeValueVOMeta.HOSTNAME));
				this.setDbConnectNumber( (Integer)r.getValue(MonitorNodeValueVOMeta.DB_CONNECT_NUMBER));
				this.setMonitorTplCode( (String)r.getValue(MonitorNodeValueVOMeta.MONITOR_TPL_CODE));
				this.setListCode3( (String)r.getValue(MonitorNodeValueVOMeta.LIST_CODE3));
				this.setListCode2( (String)r.getValue(MonitorNodeValueVOMeta.LIST_CODE2));
				this.setId( (String)r.getValue(MonitorNodeValueVOMeta.ID));
				this.setListCode1( (String)r.getValue(MonitorNodeValueVOMeta.LIST_CODE1));
				this.setOsVerion( (String)r.getValue(MonitorNodeValueVOMeta.OS_VERION));
				this.setInfo( (String)r.getValue(MonitorNodeValueVOMeta.INFO));
				this.setValueBstr1( (String)r.getValue(MonitorNodeValueVOMeta.VALUE_BSTR1));
				this.setOsDatetime( (String)r.getValue(MonitorNodeValueVOMeta.OS_DATETIME));
				this.setCpuIdle( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.CPU_IDLE));
				this.setNodeVersion( (String)r.getValue(MonitorNodeValueVOMeta.NODE_VERSION));
				this.setVersion( (Integer)r.getValue(MonitorNodeValueVOMeta.VERSION));
				this.setDbSize( (Long)r.getValue(MonitorNodeValueVOMeta.DB_SIZE));
				this.setVMemorySize( (Long)r.getValue(MonitorNodeValueVOMeta.V_MEMORY_SIZE));
				this.setDeleteTime( (Date)r.getValue(MonitorNodeValueVOMeta.DELETE_TIME));
				this.setBoottime( (Date)r.getValue(MonitorNodeValueVOMeta.BOOTTIME));
				this.setDeleteBy( (String)r.getValue(MonitorNodeValueVOMeta.DELETE_BY));
				this.setNodeId( (String)r.getValue(MonitorNodeValueVOMeta.NODE_ID));
				this.setNetworkFlowDown( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.NETWORK_FLOW_DOWN));
				this.setListLabel2( (String)r.getValue(MonitorNodeValueVOMeta.LIST_LABEL2));
				this.setListValueStr3( (String)r.getValue(MonitorNodeValueVOMeta.LIST_VALUE_STR3));
				this.setCode3( (String)r.getValue(MonitorNodeValueVOMeta.CODE3));
				this.setListLabel3( (String)r.getValue(MonitorNodeValueVOMeta.LIST_LABEL3));
				this.setListValueStr2( (String)r.getValue(MonitorNodeValueVOMeta.LIST_VALUE_STR2));
				this.setCode2( (String)r.getValue(MonitorNodeValueVOMeta.CODE2));
				this.setCode1( (String)r.getValue(MonitorNodeValueVOMeta.CODE1));
				this.setCpuUsed( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.CPU_USED));
				this.setListValueInt1( (Long)r.getValue(MonitorNodeValueVOMeta.LIST_VALUE_INT1));
				this.setValueNumber2( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.VALUE_NUMBER2));
				this.setListValueStr1( (String)r.getValue(MonitorNodeValueVOMeta.LIST_VALUE_STR1));
				this.setListValueInt2( (Long)r.getValue(MonitorNodeValueVOMeta.LIST_VALUE_INT2));
				this.setValueNumber3( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.VALUE_NUMBER3));
				this.setListLabel1( (String)r.getValue(MonitorNodeValueVOMeta.LIST_LABEL1));
				this.setListValueInt3( (Long)r.getValue(MonitorNodeValueVOMeta.LIST_VALUE_INT3));
				this.setIsConnected( (Integer)r.getValue(MonitorNodeValueVOMeta.IS_CONNECTED));
				this.setValueNumber1( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.VALUE_NUMBER1));
				this.setUid( (String)r.getValue(MonitorNodeValueVOMeta.UID));
				this.setCpuUser( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.CPU_USER));
				this.setProcessCnt( (Integer)r.getValue(MonitorNodeValueVOMeta.PROCESS_CNT));
				this.setCpuSys( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.CPU_SYS));
				this.setUpdateBy( (String)r.getValue(MonitorNodeValueVOMeta.UPDATE_BY));
				this.setNetworkFlowUp( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.NETWORK_FLOW_UP));
				this.setDbStatus( (Integer)r.getValue(MonitorNodeValueVOMeta.DB_STATUS));
				this.setPMemoryUsed( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.P_MEMORY_USED));
				this.setCpuNumber( (Integer)r.getValue(MonitorNodeValueVOMeta.CPU_NUMBER));
				this.setValueInt3( (Long)r.getValue(MonitorNodeValueVOMeta.VALUE_INT3));
				this.setValueInt2( (Long)r.getValue(MonitorNodeValueVOMeta.VALUE_INT2));
				this.setValueInt1( (Long)r.getValue(MonitorNodeValueVOMeta.VALUE_INT1));
				this.setListValueNumber2( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.LIST_VALUE_NUMBER2));
				this.setListValueNumber3( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.LIST_VALUE_NUMBER3));
				this.setListValueNumber1( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.LIST_VALUE_NUMBER1));
				this.setIndicatorCode( (String)r.getValue(MonitorNodeValueVOMeta.INDICATOR_CODE));
				this.setValueStr3( (String)r.getValue(MonitorNodeValueVOMeta.VALUE_STR3));
				this.setValueStr2( (String)r.getValue(MonitorNodeValueVOMeta.VALUE_STR2));
				this.setValueStr1( (String)r.getValue(MonitorNodeValueVOMeta.VALUE_STR1));
				this.setUpdateTime( (Date)r.getValue(MonitorNodeValueVOMeta.UPDATE_TIME));
				this.setResultMessage( (String)r.getValue(MonitorNodeValueVOMeta.RESULT_MESSAGE));
				this.setLabel1( (String)r.getValue(MonitorNodeValueVOMeta.LABEL1));
				this.setLabel2( (String)r.getValue(MonitorNodeValueVOMeta.LABEL2));
				this.setLabel3( (String)r.getValue(MonitorNodeValueVOMeta.LABEL3));
				this.setResultStatus( (String)r.getValue(MonitorNodeValueVOMeta.RESULT_STATUS));
				this.setCreateBy( (String)r.getValue(MonitorNodeValueVOMeta.CREATE_BY));
				this.setRecordTime( (Date)r.getValue(MonitorNodeValueVOMeta.RECORD_TIME));
				this.setDeleted( (Integer)r.getValue(MonitorNodeValueVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(MonitorNodeValueVOMeta.CREATE_TIME));
				this.setOsLoad5( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.OS_LOAD5));
				this.setVMemoryUsed( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.V_MEMORY_USED));
				this.setArch( (String)r.getValue(MonitorNodeValueVOMeta.ARCH));
				this.setCpuWait( (BigDecimal)r.getValue(MonitorNodeValueVOMeta.CPU_WAIT));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}