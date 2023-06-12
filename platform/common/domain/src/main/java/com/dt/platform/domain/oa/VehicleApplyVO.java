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
import com.dt.platform.domain.oa.meta.VehicleApplyVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 车辆申请VO类型
 * <p>车辆申请 , 数据表 oa_vehicle_apply 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 16:02:14
 * @sign C335B1EA92ACB125927B229F499A1FC5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "车辆申请VO类型 ; 车辆申请 , 数据表 oa_vehicle_apply 的通用VO类型" , parent = VehicleApply.class)
public class VehicleApplyVO extends VehicleApply {

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
	public VehicleApplyVO setPageIndex(Integer pageIndex) {
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
	public VehicleApplyVO setPageSize(Integer pageSize) {
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
	public VehicleApplyVO setSearchField(String searchField) {
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
	public VehicleApplyVO setFuzzyField(String fuzzyField) {
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
	public VehicleApplyVO setSearchValue(String searchValue) {
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
	public VehicleApplyVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public VehicleApplyVO addDirtyField(String... dirtyField) {
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
	public VehicleApplyVO setSortField(String sortField) {
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
	public VehicleApplyVO setSortType(String sortType) {
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
	public VehicleApplyVO setDataOrigin(String dataOrigin) {
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
	public VehicleApplyVO setQueryLogic(String queryLogic) {
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
	public VehicleApplyVO setRequestAction(String requestAction) {
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
	public VehicleApplyVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public VehicleApplyVO addId(String... id) {
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
	 * @return VehicleApplyVO , 转换好的 VehicleApplyVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return VehicleApplyVO , 转换好的 PoJo 对象
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
	public VehicleApplyVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public VehicleApplyVO duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.VehicleApplyVOMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.VehicleApplyVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setReturnNotes(this.getReturnNotes());
		inst.setActReturnDate(this.getActReturnDate());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setOrgId(this.getOrgId());
		inst.setContent(this.getContent());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setReceiverId(this.getReceiverId());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setContact(this.getContact());
		inst.setId(this.getId());
		inst.setAttach(this.getAttach());
		inst.setVehicleId(this.getVehicleId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setPlanReturnDate(this.getPlanReturnDate());
		inst.setIfReturn(this.getIfReturn());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setCollectionDate(this.getCollectionDate());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setDriver(this.getDriver());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setReceiver(this.getReceiver());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setVehicleInfo(this.getVehicleInfo());
			inst.setPageSize(this.getPageSize());
			inst.setOriginator(this.getOriginator());
			inst.setUseOrganization(this.getUseOrganization());
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
	public VehicleApplyVO clone(boolean deep) {
		return EntityContext.clone(VehicleApplyVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 VehicleApplyVO
	 * @param vehicleApplyMap 包含实体信息的 Map 对象
	 * @return VehicleApplyVO , 转换好的的 VehicleApply 对象
	*/
	@Transient
	public static VehicleApplyVO createFrom(Map<String,Object> vehicleApplyMap) {
		if(vehicleApplyMap==null) return null;
		VehicleApplyVO vo = create();
		EntityContext.copyProperties(vo,vehicleApplyMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 VehicleApplyVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return VehicleApplyVO , 转换好的的 VehicleApply 对象
	*/
	@Transient
	public static VehicleApplyVO createFrom(Object pojo) {
		if(pojo==null) return null;
		VehicleApplyVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 VehicleApplyVO，等同于 new
	 * @return VehicleApplyVO 对象
	*/
	@Transient
	public static VehicleApplyVO create() {
		return new com.dt.platform.domain.oa.meta.VehicleApplyVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.NOTES)));
			this.setReturnNotes(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.RETURN_NOTES)));
			this.setActReturnDate(DataParser.parse(Date.class, map.get(VehicleApplyVOMeta.ACT_RETURN_DATE)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.SELECTED_CODE)));
			this.setOrgId(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.ORG_ID)));
			this.setContent(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.CONTENT)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.BUSINESS_CODE)));
			this.setReceiverId(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.RECEIVER_ID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.UPDATE_BY)));
			this.setContact(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.CONTACT)));
			this.setId(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.ID)));
			this.setAttach(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.ATTACH)));
			this.setVehicleId(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.VEHICLE_ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.ORIGINATOR_ID)));
			this.setPlanReturnDate(DataParser.parse(Date.class, map.get(VehicleApplyVOMeta.PLAN_RETURN_DATE)));
			this.setIfReturn(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.IF_RETURN)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(VehicleApplyVOMeta.UPDATE_TIME)));
			this.setCollectionDate(DataParser.parse(Date.class, map.get(VehicleApplyVOMeta.COLLECTION_DATE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(VehicleApplyVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(VehicleApplyVOMeta.DELETED)));
			this.setDriver(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.DRIVER)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(VehicleApplyVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(VehicleApplyVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.STATUS)));
			// others
			this.setReceiver(DataParser.parse(Employee.class, map.get(VehicleApplyVOMeta.RECEIVER)));
			this.setSearchField(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.FUZZY_FIELD)));
			this.setVehicleInfo(DataParser.parse(VehicleInfo.class, map.get(VehicleApplyVOMeta.VEHICLE_INFO)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(VehicleApplyVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(VehicleApplyVOMeta.ORIGINATOR)));
			this.setUseOrganization(DataParser.parse(Organization.class, map.get(VehicleApplyVOMeta.USE_ORGANIZATION)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(VehicleApplyVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(VehicleApplyVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(VehicleApplyVOMeta.NOTES));
				this.setReturnNotes( (String)map.get(VehicleApplyVOMeta.RETURN_NOTES));
				this.setActReturnDate( (Date)map.get(VehicleApplyVOMeta.ACT_RETURN_DATE));
				this.setSelectedCode( (String)map.get(VehicleApplyVOMeta.SELECTED_CODE));
				this.setOrgId( (String)map.get(VehicleApplyVOMeta.ORG_ID));
				this.setContent( (String)map.get(VehicleApplyVOMeta.CONTENT));
				this.setBusinessCode( (String)map.get(VehicleApplyVOMeta.BUSINESS_CODE));
				this.setReceiverId( (String)map.get(VehicleApplyVOMeta.RECEIVER_ID));
				this.setUpdateBy( (String)map.get(VehicleApplyVOMeta.UPDATE_BY));
				this.setContact( (String)map.get(VehicleApplyVOMeta.CONTACT));
				this.setId( (String)map.get(VehicleApplyVOMeta.ID));
				this.setAttach( (String)map.get(VehicleApplyVOMeta.ATTACH));
				this.setVehicleId( (String)map.get(VehicleApplyVOMeta.VEHICLE_ID));
				this.setOriginatorId( (String)map.get(VehicleApplyVOMeta.ORIGINATOR_ID));
				this.setPlanReturnDate( (Date)map.get(VehicleApplyVOMeta.PLAN_RETURN_DATE));
				this.setIfReturn( (String)map.get(VehicleApplyVOMeta.IF_RETURN));
				this.setUpdateTime( (Date)map.get(VehicleApplyVOMeta.UPDATE_TIME));
				this.setCollectionDate( (Date)map.get(VehicleApplyVOMeta.COLLECTION_DATE));
				this.setVersion( (Integer)map.get(VehicleApplyVOMeta.VERSION));
				this.setCreateBy( (String)map.get(VehicleApplyVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(VehicleApplyVOMeta.DELETED));
				this.setDriver( (String)map.get(VehicleApplyVOMeta.DRIVER));
				this.setCreateTime( (Date)map.get(VehicleApplyVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(VehicleApplyVOMeta.DELETE_TIME));
				this.setName( (String)map.get(VehicleApplyVOMeta.NAME));
				this.setTenantId( (String)map.get(VehicleApplyVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(VehicleApplyVOMeta.DELETE_BY));
				this.setStatus( (String)map.get(VehicleApplyVOMeta.STATUS));
				// others
				this.setReceiver( (Employee)map.get(VehicleApplyVOMeta.RECEIVER));
				this.setSearchField( (String)map.get(VehicleApplyVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(VehicleApplyVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(VehicleApplyVOMeta.FUZZY_FIELD));
				this.setVehicleInfo( (VehicleInfo)map.get(VehicleApplyVOMeta.VEHICLE_INFO));
				this.setPageSize( (Integer)map.get(VehicleApplyVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(VehicleApplyVOMeta.ORIGINATOR));
				this.setUseOrganization( (Organization)map.get(VehicleApplyVOMeta.USE_ORGANIZATION));
				this.setPageIndex( (Integer)map.get(VehicleApplyVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(VehicleApplyVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(VehicleApplyVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(VehicleApplyVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(VehicleApplyVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(VehicleApplyVOMeta.SEARCH_VALUE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.NOTES)));
			this.setReturnNotes(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.RETURN_NOTES)));
			this.setActReturnDate(DataParser.parse(Date.class, r.getValue(VehicleApplyVOMeta.ACT_RETURN_DATE)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.SELECTED_CODE)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.ORG_ID)));
			this.setContent(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.CONTENT)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.BUSINESS_CODE)));
			this.setReceiverId(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.RECEIVER_ID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.UPDATE_BY)));
			this.setContact(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.CONTACT)));
			this.setId(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.ATTACH)));
			this.setVehicleId(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.VEHICLE_ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.ORIGINATOR_ID)));
			this.setPlanReturnDate(DataParser.parse(Date.class, r.getValue(VehicleApplyVOMeta.PLAN_RETURN_DATE)));
			this.setIfReturn(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.IF_RETURN)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(VehicleApplyVOMeta.UPDATE_TIME)));
			this.setCollectionDate(DataParser.parse(Date.class, r.getValue(VehicleApplyVOMeta.COLLECTION_DATE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(VehicleApplyVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(VehicleApplyVOMeta.DELETED)));
			this.setDriver(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.DRIVER)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(VehicleApplyVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(VehicleApplyVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(VehicleApplyVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(VehicleApplyVOMeta.NOTES));
				this.setReturnNotes( (String)r.getValue(VehicleApplyVOMeta.RETURN_NOTES));
				this.setActReturnDate( (Date)r.getValue(VehicleApplyVOMeta.ACT_RETURN_DATE));
				this.setSelectedCode( (String)r.getValue(VehicleApplyVOMeta.SELECTED_CODE));
				this.setOrgId( (String)r.getValue(VehicleApplyVOMeta.ORG_ID));
				this.setContent( (String)r.getValue(VehicleApplyVOMeta.CONTENT));
				this.setBusinessCode( (String)r.getValue(VehicleApplyVOMeta.BUSINESS_CODE));
				this.setReceiverId( (String)r.getValue(VehicleApplyVOMeta.RECEIVER_ID));
				this.setUpdateBy( (String)r.getValue(VehicleApplyVOMeta.UPDATE_BY));
				this.setContact( (String)r.getValue(VehicleApplyVOMeta.CONTACT));
				this.setId( (String)r.getValue(VehicleApplyVOMeta.ID));
				this.setAttach( (String)r.getValue(VehicleApplyVOMeta.ATTACH));
				this.setVehicleId( (String)r.getValue(VehicleApplyVOMeta.VEHICLE_ID));
				this.setOriginatorId( (String)r.getValue(VehicleApplyVOMeta.ORIGINATOR_ID));
				this.setPlanReturnDate( (Date)r.getValue(VehicleApplyVOMeta.PLAN_RETURN_DATE));
				this.setIfReturn( (String)r.getValue(VehicleApplyVOMeta.IF_RETURN));
				this.setUpdateTime( (Date)r.getValue(VehicleApplyVOMeta.UPDATE_TIME));
				this.setCollectionDate( (Date)r.getValue(VehicleApplyVOMeta.COLLECTION_DATE));
				this.setVersion( (Integer)r.getValue(VehicleApplyVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(VehicleApplyVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(VehicleApplyVOMeta.DELETED));
				this.setDriver( (String)r.getValue(VehicleApplyVOMeta.DRIVER));
				this.setCreateTime( (Date)r.getValue(VehicleApplyVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(VehicleApplyVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(VehicleApplyVOMeta.NAME));
				this.setTenantId( (String)r.getValue(VehicleApplyVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(VehicleApplyVOMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(VehicleApplyVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}