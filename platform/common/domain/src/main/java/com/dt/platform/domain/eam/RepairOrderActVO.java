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
import com.dt.platform.domain.eam.meta.RepairOrderActVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 维修工单VO类型
 * <p>维修工单 , 数据表 eam_repair_order_act 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-17 16:02:02
 * @sign 043A5ADD17EDB7D84197AA89DA40989D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "维修工单VO类型 ; 维修工单 , 数据表 eam_repair_order_act 的通用VO类型" , parent = RepairOrderAct.class)
public class RepairOrderActVO extends RepairOrderAct {

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
	public RepairOrderActVO setPageIndex(Integer pageIndex) {
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
	public RepairOrderActVO setPageSize(Integer pageSize) {
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
	public RepairOrderActVO setSearchField(String searchField) {
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
	public RepairOrderActVO setFuzzyField(String fuzzyField) {
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
	public RepairOrderActVO setSearchValue(String searchValue) {
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
	public RepairOrderActVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public RepairOrderActVO addDirtyField(String... dirtyField) {
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
	public RepairOrderActVO setSortField(String sortField) {
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
	public RepairOrderActVO setSortType(String sortType) {
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
	public RepairOrderActVO setDataOrigin(String dataOrigin) {
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
	public RepairOrderActVO setQueryLogic(String queryLogic) {
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
	public RepairOrderActVO setRequestAction(String requestAction) {
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
	public RepairOrderActVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public RepairOrderActVO addId(String... id) {
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
	 * @return RepairOrderActVO , 转换好的 RepairOrderActVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RepairOrderActVO , 转换好的 PoJo 对象
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
	public RepairOrderActVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public RepairOrderActVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.RepairOrderActVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.RepairOrderActVOMeta.$$proxy$$();
		inst.setFinishTime(this.getFinishTime());
		inst.setNotes(this.getNotes());
		inst.setOrderId(this.getOrderId());
		inst.setExecutorId(this.getExecutorId());
		inst.setGroupId(this.getGroupId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setWithAcceptance(this.getWithAcceptance());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPictureId(this.getPictureId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStartTime(this.getStartTime());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setRepairCost(this.getRepairCost());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setOriginator(this.getOriginator());
			inst.setOrderBusinessCode(this.getOrderBusinessCode());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setExecutor(this.getExecutor());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setRepairGroup(this.getRepairGroup());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setOrderRepairStatus(this.getOrderRepairStatus());
			inst.setSearchValue(this.getSearchValue());
			inst.setOrder(this.getOrder());
			inst.setOrderName(this.getOrderName());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public RepairOrderActVO clone(boolean deep) {
		return EntityContext.clone(RepairOrderActVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 RepairOrderActVO
	 * @param repairOrderActMap 包含实体信息的 Map 对象
	 * @return RepairOrderActVO , 转换好的的 RepairOrderAct 对象
	*/
	@Transient
	public static RepairOrderActVO createFrom(Map<String,Object> repairOrderActMap) {
		if(repairOrderActMap==null) return null;
		RepairOrderActVO vo = create();
		EntityContext.copyProperties(vo,repairOrderActMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 RepairOrderActVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RepairOrderActVO , 转换好的的 RepairOrderAct 对象
	*/
	@Transient
	public static RepairOrderActVO createFrom(Object pojo) {
		if(pojo==null) return null;
		RepairOrderActVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 RepairOrderActVO，等同于 new
	 * @return RepairOrderActVO 对象
	*/
	@Transient
	public static RepairOrderActVO create() {
		return new com.dt.platform.domain.eam.meta.RepairOrderActVOMeta.$$proxy$$();
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
			this.setFinishTime(DataParser.parse(Date.class, map.get(RepairOrderActVOMeta.FINISH_TIME)));
			this.setNotes(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.NOTES)));
			this.setOrderId(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.ORDER_ID)));
			this.setExecutorId(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.EXECUTOR_ID)));
			this.setGroupId(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.GROUP_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(RepairOrderActVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(RepairOrderActVOMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.SELECTED_CODE)));
			this.setWithAcceptance(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.WITH_ACCEPTANCE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(RepairOrderActVOMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.PICTURE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(RepairOrderActVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(RepairOrderActVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.DELETE_BY)));
			this.setStartTime(DataParser.parse(Date.class, map.get(RepairOrderActVOMeta.START_TIME)));
			this.setId(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.ORIGINATOR_ID)));
			this.setRepairCost(DataParser.parse(BigDecimal.class, map.get(RepairOrderActVOMeta.REPAIR_COST)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(RepairOrderActVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(RepairOrderActVOMeta.ORIGINATOR)));
			this.setOrderBusinessCode(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.ORDER_BUSINESS_CODE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(RepairOrderActVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.SORT_TYPE)));
			this.setExecutor(DataParser.parse(Employee.class, map.get(RepairOrderActVOMeta.EXECUTOR)));
			this.setSortField(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.DATA_ORIGIN)));
			this.setRepairGroup(DataParser.parse(RepairGroup.class, map.get(RepairOrderActVOMeta.REPAIR_GROUP)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.QUERY_LOGIC)));
			this.setOrderRepairStatus(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.ORDER_REPAIR_STATUS)));
			this.setSearchValue(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.SEARCH_VALUE)));
			this.setOrder(DataParser.parse(RepairOrder.class, map.get(RepairOrderActVOMeta.ORDER)));
			this.setOrderName(DataParser.parse(String.class, map.get(RepairOrderActVOMeta.ORDER_NAME)));
			return true;
		} else {
			try {
				this.setFinishTime( (Date)map.get(RepairOrderActVOMeta.FINISH_TIME));
				this.setNotes( (String)map.get(RepairOrderActVOMeta.NOTES));
				this.setOrderId( (String)map.get(RepairOrderActVOMeta.ORDER_ID));
				this.setExecutorId( (String)map.get(RepairOrderActVOMeta.EXECUTOR_ID));
				this.setGroupId( (String)map.get(RepairOrderActVOMeta.GROUP_ID));
				this.setUpdateTime( (Date)map.get(RepairOrderActVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(RepairOrderActVOMeta.VERSION));
				this.setSelectedCode( (String)map.get(RepairOrderActVOMeta.SELECTED_CODE));
				this.setWithAcceptance( (String)map.get(RepairOrderActVOMeta.WITH_ACCEPTANCE));
				this.setBusinessCode( (String)map.get(RepairOrderActVOMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(RepairOrderActVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(RepairOrderActVOMeta.DELETED));
				this.setPictureId( (String)map.get(RepairOrderActVOMeta.PICTURE_ID));
				this.setCreateTime( (Date)map.get(RepairOrderActVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(RepairOrderActVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(RepairOrderActVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(RepairOrderActVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(RepairOrderActVOMeta.DELETE_BY));
				this.setStartTime( (Date)map.get(RepairOrderActVOMeta.START_TIME));
				this.setId( (String)map.get(RepairOrderActVOMeta.ID));
				this.setOriginatorId( (String)map.get(RepairOrderActVOMeta.ORIGINATOR_ID));
				this.setRepairCost( (BigDecimal)map.get(RepairOrderActVOMeta.REPAIR_COST));
				// others
				this.setSearchField( (String)map.get(RepairOrderActVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(RepairOrderActVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(RepairOrderActVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(RepairOrderActVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(RepairOrderActVOMeta.ORIGINATOR));
				this.setOrderBusinessCode( (String)map.get(RepairOrderActVOMeta.ORDER_BUSINESS_CODE));
				this.setPageIndex( (Integer)map.get(RepairOrderActVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(RepairOrderActVOMeta.SORT_TYPE));
				this.setExecutor( (Employee)map.get(RepairOrderActVOMeta.EXECUTOR));
				this.setSortField( (String)map.get(RepairOrderActVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(RepairOrderActVOMeta.DATA_ORIGIN));
				this.setRepairGroup( (RepairGroup)map.get(RepairOrderActVOMeta.REPAIR_GROUP));
				this.setQueryLogic( (String)map.get(RepairOrderActVOMeta.QUERY_LOGIC));
				this.setOrderRepairStatus( (String)map.get(RepairOrderActVOMeta.ORDER_REPAIR_STATUS));
				this.setSearchValue( (String)map.get(RepairOrderActVOMeta.SEARCH_VALUE));
				this.setOrder( (RepairOrder)map.get(RepairOrderActVOMeta.ORDER));
				this.setOrderName( (String)map.get(RepairOrderActVOMeta.ORDER_NAME));
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
			this.setFinishTime(DataParser.parse(Date.class, r.getValue(RepairOrderActVOMeta.FINISH_TIME)));
			this.setNotes(DataParser.parse(String.class, r.getValue(RepairOrderActVOMeta.NOTES)));
			this.setOrderId(DataParser.parse(String.class, r.getValue(RepairOrderActVOMeta.ORDER_ID)));
			this.setExecutorId(DataParser.parse(String.class, r.getValue(RepairOrderActVOMeta.EXECUTOR_ID)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(RepairOrderActVOMeta.GROUP_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(RepairOrderActVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(RepairOrderActVOMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(RepairOrderActVOMeta.SELECTED_CODE)));
			this.setWithAcceptance(DataParser.parse(String.class, r.getValue(RepairOrderActVOMeta.WITH_ACCEPTANCE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(RepairOrderActVOMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(RepairOrderActVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(RepairOrderActVOMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(RepairOrderActVOMeta.PICTURE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(RepairOrderActVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(RepairOrderActVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(RepairOrderActVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(RepairOrderActVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(RepairOrderActVOMeta.DELETE_BY)));
			this.setStartTime(DataParser.parse(Date.class, r.getValue(RepairOrderActVOMeta.START_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(RepairOrderActVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(RepairOrderActVOMeta.ORIGINATOR_ID)));
			this.setRepairCost(DataParser.parse(BigDecimal.class, r.getValue(RepairOrderActVOMeta.REPAIR_COST)));
			return true;
		} else {
			try {
				this.setFinishTime( (Date)r.getValue(RepairOrderActVOMeta.FINISH_TIME));
				this.setNotes( (String)r.getValue(RepairOrderActVOMeta.NOTES));
				this.setOrderId( (String)r.getValue(RepairOrderActVOMeta.ORDER_ID));
				this.setExecutorId( (String)r.getValue(RepairOrderActVOMeta.EXECUTOR_ID));
				this.setGroupId( (String)r.getValue(RepairOrderActVOMeta.GROUP_ID));
				this.setUpdateTime( (Date)r.getValue(RepairOrderActVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(RepairOrderActVOMeta.VERSION));
				this.setSelectedCode( (String)r.getValue(RepairOrderActVOMeta.SELECTED_CODE));
				this.setWithAcceptance( (String)r.getValue(RepairOrderActVOMeta.WITH_ACCEPTANCE));
				this.setBusinessCode( (String)r.getValue(RepairOrderActVOMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(RepairOrderActVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(RepairOrderActVOMeta.DELETED));
				this.setPictureId( (String)r.getValue(RepairOrderActVOMeta.PICTURE_ID));
				this.setCreateTime( (Date)r.getValue(RepairOrderActVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(RepairOrderActVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(RepairOrderActVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(RepairOrderActVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(RepairOrderActVOMeta.DELETE_BY));
				this.setStartTime( (Date)r.getValue(RepairOrderActVOMeta.START_TIME));
				this.setId( (String)r.getValue(RepairOrderActVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(RepairOrderActVOMeta.ORIGINATOR_ID));
				this.setRepairCost( (BigDecimal)r.getValue(RepairOrderActVOMeta.REPAIR_COST));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}