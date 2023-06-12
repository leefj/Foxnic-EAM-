package com.dt.platform.domain.vehicle;

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
import com.dt.platform.domain.vehicle.meta.MaintenanceVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 车辆维修保养VO类型
 * <p>车辆维修保养 , 数据表 vehicle_maintenance 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 11:31:35
 * @sign C76821104A9AF29FAD03C069601CBA94
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "车辆维修保养VO类型 ; 车辆维修保养 , 数据表 vehicle_maintenance 的通用VO类型" , parent = Maintenance.class)
public class MaintenanceVO extends Maintenance {

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
	public MaintenanceVO setPageIndex(Integer pageIndex) {
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
	public MaintenanceVO setPageSize(Integer pageSize) {
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
	public MaintenanceVO setSearchField(String searchField) {
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
	public MaintenanceVO setFuzzyField(String fuzzyField) {
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
	public MaintenanceVO setSearchValue(String searchValue) {
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
	public MaintenanceVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public MaintenanceVO addDirtyField(String... dirtyField) {
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
	public MaintenanceVO setSortField(String sortField) {
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
	public MaintenanceVO setSortType(String sortType) {
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
	public MaintenanceVO setDataOrigin(String dataOrigin) {
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
	public MaintenanceVO setQueryLogic(String queryLogic) {
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
	public MaintenanceVO setRequestAction(String requestAction) {
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
	public MaintenanceVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public MaintenanceVO addId(String... id) {
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
	 * @return MaintenanceVO , 转换好的 MaintenanceVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MaintenanceVO , 转换好的 PoJo 对象
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
	public MaintenanceVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MaintenanceVO duplicate(boolean all) {
		com.dt.platform.domain.vehicle.meta.MaintenanceVOMeta.$$proxy$$ inst = new com.dt.platform.domain.vehicle.meta.MaintenanceVOMeta.$$proxy$$();
		inst.setProcId(this.getProcId());
		inst.setReportUserName(this.getReportUserName());
		inst.setType(this.getType());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setPictureId(this.getPictureId());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setReportUserId(this.getReportUserId());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setCost(this.getCost());
		inst.setRepairStatus(this.getRepairStatus());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setActualFinishDate(this.getActualFinishDate());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPlanFinishDate(this.getPlanFinishDate());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setMaintenanceDict(this.getMaintenanceDict());
			inst.setVehicleInfoList(this.getVehicleInfoList());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setOriginator(this.getOriginator());
			inst.setVehicleInfoIds(this.getVehicleInfoIds());
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
	public MaintenanceVO clone(boolean deep) {
		return EntityContext.clone(MaintenanceVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MaintenanceVO
	 * @param maintenanceMap 包含实体信息的 Map 对象
	 * @return MaintenanceVO , 转换好的的 Maintenance 对象
	*/
	@Transient
	public static MaintenanceVO createFrom(Map<String,Object> maintenanceMap) {
		if(maintenanceMap==null) return null;
		MaintenanceVO vo = create();
		EntityContext.copyProperties(vo,maintenanceMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 MaintenanceVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MaintenanceVO , 转换好的的 Maintenance 对象
	*/
	@Transient
	public static MaintenanceVO createFrom(Object pojo) {
		if(pojo==null) return null;
		MaintenanceVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 MaintenanceVO，等同于 new
	 * @return MaintenanceVO 对象
	*/
	@Transient
	public static MaintenanceVO create() {
		return new com.dt.platform.domain.vehicle.meta.MaintenanceVOMeta.$$proxy$$();
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
			this.setProcId(DataParser.parse(String.class, map.get(MaintenanceVOMeta.PROC_ID)));
			this.setReportUserName(DataParser.parse(String.class, map.get(MaintenanceVOMeta.REPORT_USER_NAME)));
			this.setType(DataParser.parse(String.class, map.get(MaintenanceVOMeta.TYPE)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(MaintenanceVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(MaintenanceVOMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(MaintenanceVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(MaintenanceVOMeta.BUSINESS_CODE)));
			this.setPictureId(DataParser.parse(String.class, map.get(MaintenanceVOMeta.PICTURE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MaintenanceVOMeta.UPDATE_BY)));
			this.setReportUserId(DataParser.parse(String.class, map.get(MaintenanceVOMeta.REPORT_USER_ID)));
			this.setId(DataParser.parse(String.class, map.get(MaintenanceVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(MaintenanceVOMeta.ORIGINATOR_ID)));
			this.setCost(DataParser.parse(BigDecimal.class, map.get(MaintenanceVOMeta.COST)));
			this.setRepairStatus(DataParser.parse(String.class, map.get(MaintenanceVOMeta.REPAIR_STATUS)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MaintenanceVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MaintenanceVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MaintenanceVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MaintenanceVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MaintenanceVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MaintenanceVOMeta.DELETE_TIME)));
			this.setActualFinishDate(DataParser.parse(Date.class, map.get(MaintenanceVOMeta.ACTUAL_FINISH_DATE)));
			this.setName(DataParser.parse(String.class, map.get(MaintenanceVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(MaintenanceVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MaintenanceVOMeta.DELETE_BY)));
			this.setPlanFinishDate(DataParser.parse(Date.class, map.get(MaintenanceVOMeta.PLAN_FINISH_DATE)));
			this.setStatus(DataParser.parse(String.class, map.get(MaintenanceVOMeta.STATUS)));
			// others
			this.setMaintenanceDict(DataParser.parse(DictItem.class, map.get(MaintenanceVOMeta.MAINTENANCE_DICT)));
			this.setSearchField(DataParser.parse(String.class, map.get(MaintenanceVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(MaintenanceVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(MaintenanceVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(MaintenanceVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(MaintenanceVOMeta.ORIGINATOR)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(MaintenanceVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(MaintenanceVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(MaintenanceVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(MaintenanceVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(MaintenanceVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(MaintenanceVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setProcId( (String)map.get(MaintenanceVOMeta.PROC_ID));
				this.setReportUserName( (String)map.get(MaintenanceVOMeta.REPORT_USER_NAME));
				this.setType( (String)map.get(MaintenanceVOMeta.TYPE));
				this.setSelectedCode( (String)map.get(MaintenanceVOMeta.SELECTED_CODE));
				this.setContent( (String)map.get(MaintenanceVOMeta.CONTENT));
				this.setBusinessDate( (Date)map.get(MaintenanceVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(MaintenanceVOMeta.BUSINESS_CODE));
				this.setPictureId( (String)map.get(MaintenanceVOMeta.PICTURE_ID));
				this.setUpdateBy( (String)map.get(MaintenanceVOMeta.UPDATE_BY));
				this.setReportUserId( (String)map.get(MaintenanceVOMeta.REPORT_USER_ID));
				this.setId( (String)map.get(MaintenanceVOMeta.ID));
				this.setOriginatorId( (String)map.get(MaintenanceVOMeta.ORIGINATOR_ID));
				this.setCost( (BigDecimal)map.get(MaintenanceVOMeta.COST));
				this.setRepairStatus( (String)map.get(MaintenanceVOMeta.REPAIR_STATUS));
				this.setUpdateTime( (Date)map.get(MaintenanceVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(MaintenanceVOMeta.VERSION));
				this.setCreateBy( (String)map.get(MaintenanceVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MaintenanceVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(MaintenanceVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(MaintenanceVOMeta.DELETE_TIME));
				this.setActualFinishDate( (Date)map.get(MaintenanceVOMeta.ACTUAL_FINISH_DATE));
				this.setName( (String)map.get(MaintenanceVOMeta.NAME));
				this.setTenantId( (String)map.get(MaintenanceVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(MaintenanceVOMeta.DELETE_BY));
				this.setPlanFinishDate( (Date)map.get(MaintenanceVOMeta.PLAN_FINISH_DATE));
				this.setStatus( (String)map.get(MaintenanceVOMeta.STATUS));
				// others
				this.setMaintenanceDict( (DictItem)map.get(MaintenanceVOMeta.MAINTENANCE_DICT));
				this.setSearchField( (String)map.get(MaintenanceVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(MaintenanceVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(MaintenanceVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(MaintenanceVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(MaintenanceVOMeta.ORIGINATOR));
				this.setPageIndex( (Integer)map.get(MaintenanceVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(MaintenanceVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(MaintenanceVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(MaintenanceVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(MaintenanceVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(MaintenanceVOMeta.SEARCH_VALUE));
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
			this.setProcId(DataParser.parse(String.class, r.getValue(MaintenanceVOMeta.PROC_ID)));
			this.setReportUserName(DataParser.parse(String.class, r.getValue(MaintenanceVOMeta.REPORT_USER_NAME)));
			this.setType(DataParser.parse(String.class, r.getValue(MaintenanceVOMeta.TYPE)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(MaintenanceVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(MaintenanceVOMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(MaintenanceVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(MaintenanceVOMeta.BUSINESS_CODE)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(MaintenanceVOMeta.PICTURE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MaintenanceVOMeta.UPDATE_BY)));
			this.setReportUserId(DataParser.parse(String.class, r.getValue(MaintenanceVOMeta.REPORT_USER_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(MaintenanceVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(MaintenanceVOMeta.ORIGINATOR_ID)));
			this.setCost(DataParser.parse(BigDecimal.class, r.getValue(MaintenanceVOMeta.COST)));
			this.setRepairStatus(DataParser.parse(String.class, r.getValue(MaintenanceVOMeta.REPAIR_STATUS)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MaintenanceVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MaintenanceVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MaintenanceVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MaintenanceVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MaintenanceVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MaintenanceVOMeta.DELETE_TIME)));
			this.setActualFinishDate(DataParser.parse(Date.class, r.getValue(MaintenanceVOMeta.ACTUAL_FINISH_DATE)));
			this.setName(DataParser.parse(String.class, r.getValue(MaintenanceVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(MaintenanceVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MaintenanceVOMeta.DELETE_BY)));
			this.setPlanFinishDate(DataParser.parse(Date.class, r.getValue(MaintenanceVOMeta.PLAN_FINISH_DATE)));
			this.setStatus(DataParser.parse(String.class, r.getValue(MaintenanceVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setProcId( (String)r.getValue(MaintenanceVOMeta.PROC_ID));
				this.setReportUserName( (String)r.getValue(MaintenanceVOMeta.REPORT_USER_NAME));
				this.setType( (String)r.getValue(MaintenanceVOMeta.TYPE));
				this.setSelectedCode( (String)r.getValue(MaintenanceVOMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(MaintenanceVOMeta.CONTENT));
				this.setBusinessDate( (Date)r.getValue(MaintenanceVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(MaintenanceVOMeta.BUSINESS_CODE));
				this.setPictureId( (String)r.getValue(MaintenanceVOMeta.PICTURE_ID));
				this.setUpdateBy( (String)r.getValue(MaintenanceVOMeta.UPDATE_BY));
				this.setReportUserId( (String)r.getValue(MaintenanceVOMeta.REPORT_USER_ID));
				this.setId( (String)r.getValue(MaintenanceVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(MaintenanceVOMeta.ORIGINATOR_ID));
				this.setCost( (BigDecimal)r.getValue(MaintenanceVOMeta.COST));
				this.setRepairStatus( (String)r.getValue(MaintenanceVOMeta.REPAIR_STATUS));
				this.setUpdateTime( (Date)r.getValue(MaintenanceVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(MaintenanceVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(MaintenanceVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MaintenanceVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(MaintenanceVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(MaintenanceVOMeta.DELETE_TIME));
				this.setActualFinishDate( (Date)r.getValue(MaintenanceVOMeta.ACTUAL_FINISH_DATE));
				this.setName( (String)r.getValue(MaintenanceVOMeta.NAME));
				this.setTenantId( (String)r.getValue(MaintenanceVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(MaintenanceVOMeta.DELETE_BY));
				this.setPlanFinishDate( (Date)r.getValue(MaintenanceVOMeta.PLAN_FINISH_DATE));
				this.setStatus( (String)r.getValue(MaintenanceVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}