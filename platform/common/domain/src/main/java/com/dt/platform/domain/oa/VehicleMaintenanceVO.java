package com.dt.platform.domain.oa;

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
import com.dt.platform.domain.oa.meta.VehicleMaintenanceVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 车辆维修保养VO类型
 * <p>车辆维修保养 , 数据表 oa_vehicle_maintenance 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 16:04:49
 * @sign 53A40A5E3DC21C11F48DC3C208F2BFD6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "车辆维修保养VO类型 ; 车辆维修保养 , 数据表 oa_vehicle_maintenance 的通用VO类型" , parent = VehicleMaintenance.class)
public class VehicleMaintenanceVO extends VehicleMaintenance {

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
	public VehicleMaintenanceVO setPageIndex(Integer pageIndex) {
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
	public VehicleMaintenanceVO setPageSize(Integer pageSize) {
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
	public VehicleMaintenanceVO setSearchField(String searchField) {
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
	public VehicleMaintenanceVO setFuzzyField(String fuzzyField) {
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
	public VehicleMaintenanceVO setSearchValue(String searchValue) {
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
	public VehicleMaintenanceVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public VehicleMaintenanceVO addDirtyField(String... dirtyField) {
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
	public VehicleMaintenanceVO setSortField(String sortField) {
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
	public VehicleMaintenanceVO setSortType(String sortType) {
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
	public VehicleMaintenanceVO setDataOrigin(String dataOrigin) {
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
	public VehicleMaintenanceVO setQueryLogic(String queryLogic) {
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
	public VehicleMaintenanceVO setRequestAction(String requestAction) {
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
	public VehicleMaintenanceVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public VehicleMaintenanceVO addId(String... id) {
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
	 * @return VehicleMaintenanceVO , 转换好的 VehicleMaintenanceVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return VehicleMaintenanceVO , 转换好的 PoJo 对象
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
	public VehicleMaintenanceVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public VehicleMaintenanceVO duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.VehicleMaintenanceVOMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.VehicleMaintenanceVOMeta.$$proxy$$();
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
		inst.setVehicleId(this.getVehicleId());
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
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setVehicleInfo(this.getVehicleInfo());
			inst.setPageSize(this.getPageSize());
			inst.setOriginator(this.getOriginator());
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
	public VehicleMaintenanceVO clone(boolean deep) {
		return EntityContext.clone(VehicleMaintenanceVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 VehicleMaintenanceVO
	 * @param vehicleMaintenanceMap 包含实体信息的 Map 对象
	 * @return VehicleMaintenanceVO , 转换好的的 VehicleMaintenance 对象
	*/
	@Transient
	public static VehicleMaintenanceVO createFrom(Map<String,Object> vehicleMaintenanceMap) {
		if(vehicleMaintenanceMap==null) return null;
		VehicleMaintenanceVO vo = create();
		EntityContext.copyProperties(vo,vehicleMaintenanceMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 VehicleMaintenanceVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return VehicleMaintenanceVO , 转换好的的 VehicleMaintenance 对象
	*/
	@Transient
	public static VehicleMaintenanceVO createFrom(Object pojo) {
		if(pojo==null) return null;
		VehicleMaintenanceVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 VehicleMaintenanceVO，等同于 new
	 * @return VehicleMaintenanceVO 对象
	*/
	@Transient
	public static VehicleMaintenanceVO create() {
		return new com.dt.platform.domain.oa.meta.VehicleMaintenanceVOMeta.$$proxy$$();
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
			this.setProcId(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.PROC_ID)));
			this.setReportUserName(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.REPORT_USER_NAME)));
			this.setType(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.TYPE)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(VehicleMaintenanceVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.BUSINESS_CODE)));
			this.setPictureId(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.PICTURE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.UPDATE_BY)));
			this.setReportUserId(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.REPORT_USER_ID)));
			this.setId(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.ID)));
			this.setVehicleId(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.VEHICLE_ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.ORIGINATOR_ID)));
			this.setCost(DataParser.parse(BigDecimal.class, map.get(VehicleMaintenanceVOMeta.COST)));
			this.setRepairStatus(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.REPAIR_STATUS)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(VehicleMaintenanceVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(VehicleMaintenanceVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(VehicleMaintenanceVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(VehicleMaintenanceVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(VehicleMaintenanceVOMeta.DELETE_TIME)));
			this.setActualFinishDate(DataParser.parse(Date.class, map.get(VehicleMaintenanceVOMeta.ACTUAL_FINISH_DATE)));
			this.setName(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.DELETE_BY)));
			this.setPlanFinishDate(DataParser.parse(Date.class, map.get(VehicleMaintenanceVOMeta.PLAN_FINISH_DATE)));
			this.setStatus(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.STATUS)));
			// others
			this.setMaintenanceDict(DataParser.parse(DictItem.class, map.get(VehicleMaintenanceVOMeta.MAINTENANCE_DICT)));
			this.setSearchField(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.FUZZY_FIELD)));
			this.setVehicleInfo(DataParser.parse(VehicleInfo.class, map.get(VehicleMaintenanceVOMeta.VEHICLE_INFO)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(VehicleMaintenanceVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(VehicleMaintenanceVOMeta.ORIGINATOR)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(VehicleMaintenanceVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(VehicleMaintenanceVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setProcId( (String)map.get(VehicleMaintenanceVOMeta.PROC_ID));
				this.setReportUserName( (String)map.get(VehicleMaintenanceVOMeta.REPORT_USER_NAME));
				this.setType( (String)map.get(VehicleMaintenanceVOMeta.TYPE));
				this.setSelectedCode( (String)map.get(VehicleMaintenanceVOMeta.SELECTED_CODE));
				this.setContent( (String)map.get(VehicleMaintenanceVOMeta.CONTENT));
				this.setBusinessDate( (Date)map.get(VehicleMaintenanceVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(VehicleMaintenanceVOMeta.BUSINESS_CODE));
				this.setPictureId( (String)map.get(VehicleMaintenanceVOMeta.PICTURE_ID));
				this.setUpdateBy( (String)map.get(VehicleMaintenanceVOMeta.UPDATE_BY));
				this.setReportUserId( (String)map.get(VehicleMaintenanceVOMeta.REPORT_USER_ID));
				this.setId( (String)map.get(VehicleMaintenanceVOMeta.ID));
				this.setVehicleId( (String)map.get(VehicleMaintenanceVOMeta.VEHICLE_ID));
				this.setOriginatorId( (String)map.get(VehicleMaintenanceVOMeta.ORIGINATOR_ID));
				this.setCost( (BigDecimal)map.get(VehicleMaintenanceVOMeta.COST));
				this.setRepairStatus( (String)map.get(VehicleMaintenanceVOMeta.REPAIR_STATUS));
				this.setUpdateTime( (Date)map.get(VehicleMaintenanceVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(VehicleMaintenanceVOMeta.VERSION));
				this.setCreateBy( (String)map.get(VehicleMaintenanceVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(VehicleMaintenanceVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(VehicleMaintenanceVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(VehicleMaintenanceVOMeta.DELETE_TIME));
				this.setActualFinishDate( (Date)map.get(VehicleMaintenanceVOMeta.ACTUAL_FINISH_DATE));
				this.setName( (String)map.get(VehicleMaintenanceVOMeta.NAME));
				this.setTenantId( (String)map.get(VehicleMaintenanceVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(VehicleMaintenanceVOMeta.DELETE_BY));
				this.setPlanFinishDate( (Date)map.get(VehicleMaintenanceVOMeta.PLAN_FINISH_DATE));
				this.setStatus( (String)map.get(VehicleMaintenanceVOMeta.STATUS));
				// others
				this.setMaintenanceDict( (DictItem)map.get(VehicleMaintenanceVOMeta.MAINTENANCE_DICT));
				this.setSearchField( (String)map.get(VehicleMaintenanceVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(VehicleMaintenanceVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(VehicleMaintenanceVOMeta.FUZZY_FIELD));
				this.setVehicleInfo( (VehicleInfo)map.get(VehicleMaintenanceVOMeta.VEHICLE_INFO));
				this.setPageSize( (Integer)map.get(VehicleMaintenanceVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(VehicleMaintenanceVOMeta.ORIGINATOR));
				this.setPageIndex( (Integer)map.get(VehicleMaintenanceVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(VehicleMaintenanceVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(VehicleMaintenanceVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(VehicleMaintenanceVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(VehicleMaintenanceVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(VehicleMaintenanceVOMeta.SEARCH_VALUE));
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
			this.setProcId(DataParser.parse(String.class, r.getValue(VehicleMaintenanceVOMeta.PROC_ID)));
			this.setReportUserName(DataParser.parse(String.class, r.getValue(VehicleMaintenanceVOMeta.REPORT_USER_NAME)));
			this.setType(DataParser.parse(String.class, r.getValue(VehicleMaintenanceVOMeta.TYPE)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(VehicleMaintenanceVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(VehicleMaintenanceVOMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(VehicleMaintenanceVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(VehicleMaintenanceVOMeta.BUSINESS_CODE)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(VehicleMaintenanceVOMeta.PICTURE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(VehicleMaintenanceVOMeta.UPDATE_BY)));
			this.setReportUserId(DataParser.parse(String.class, r.getValue(VehicleMaintenanceVOMeta.REPORT_USER_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(VehicleMaintenanceVOMeta.ID)));
			this.setVehicleId(DataParser.parse(String.class, r.getValue(VehicleMaintenanceVOMeta.VEHICLE_ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(VehicleMaintenanceVOMeta.ORIGINATOR_ID)));
			this.setCost(DataParser.parse(BigDecimal.class, r.getValue(VehicleMaintenanceVOMeta.COST)));
			this.setRepairStatus(DataParser.parse(String.class, r.getValue(VehicleMaintenanceVOMeta.REPAIR_STATUS)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(VehicleMaintenanceVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(VehicleMaintenanceVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(VehicleMaintenanceVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(VehicleMaintenanceVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(VehicleMaintenanceVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(VehicleMaintenanceVOMeta.DELETE_TIME)));
			this.setActualFinishDate(DataParser.parse(Date.class, r.getValue(VehicleMaintenanceVOMeta.ACTUAL_FINISH_DATE)));
			this.setName(DataParser.parse(String.class, r.getValue(VehicleMaintenanceVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(VehicleMaintenanceVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(VehicleMaintenanceVOMeta.DELETE_BY)));
			this.setPlanFinishDate(DataParser.parse(Date.class, r.getValue(VehicleMaintenanceVOMeta.PLAN_FINISH_DATE)));
			this.setStatus(DataParser.parse(String.class, r.getValue(VehicleMaintenanceVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setProcId( (String)r.getValue(VehicleMaintenanceVOMeta.PROC_ID));
				this.setReportUserName( (String)r.getValue(VehicleMaintenanceVOMeta.REPORT_USER_NAME));
				this.setType( (String)r.getValue(VehicleMaintenanceVOMeta.TYPE));
				this.setSelectedCode( (String)r.getValue(VehicleMaintenanceVOMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(VehicleMaintenanceVOMeta.CONTENT));
				this.setBusinessDate( (Date)r.getValue(VehicleMaintenanceVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(VehicleMaintenanceVOMeta.BUSINESS_CODE));
				this.setPictureId( (String)r.getValue(VehicleMaintenanceVOMeta.PICTURE_ID));
				this.setUpdateBy( (String)r.getValue(VehicleMaintenanceVOMeta.UPDATE_BY));
				this.setReportUserId( (String)r.getValue(VehicleMaintenanceVOMeta.REPORT_USER_ID));
				this.setId( (String)r.getValue(VehicleMaintenanceVOMeta.ID));
				this.setVehicleId( (String)r.getValue(VehicleMaintenanceVOMeta.VEHICLE_ID));
				this.setOriginatorId( (String)r.getValue(VehicleMaintenanceVOMeta.ORIGINATOR_ID));
				this.setCost( (BigDecimal)r.getValue(VehicleMaintenanceVOMeta.COST));
				this.setRepairStatus( (String)r.getValue(VehicleMaintenanceVOMeta.REPAIR_STATUS));
				this.setUpdateTime( (Date)r.getValue(VehicleMaintenanceVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(VehicleMaintenanceVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(VehicleMaintenanceVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(VehicleMaintenanceVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(VehicleMaintenanceVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(VehicleMaintenanceVOMeta.DELETE_TIME));
				this.setActualFinishDate( (Date)r.getValue(VehicleMaintenanceVOMeta.ACTUAL_FINISH_DATE));
				this.setName( (String)r.getValue(VehicleMaintenanceVOMeta.NAME));
				this.setTenantId( (String)r.getValue(VehicleMaintenanceVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(VehicleMaintenanceVOMeta.DELETE_BY));
				this.setPlanFinishDate( (Date)r.getValue(VehicleMaintenanceVOMeta.PLAN_FINISH_DATE));
				this.setStatus( (String)r.getValue(VehicleMaintenanceVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}