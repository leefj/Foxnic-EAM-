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
import com.dt.platform.domain.oa.meta.VehicleInfoVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 车辆信息VO类型
 * <p>车辆信息 , 数据表 oa_vehicle_info 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-10 15:50:00
 * @sign 7513339456463B0B4DDBEE2A307F932F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "车辆信息VO类型 ; 车辆信息 , 数据表 oa_vehicle_info 的通用VO类型" , parent = VehicleInfo.class)
public class VehicleInfoVO extends VehicleInfo {

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
	public VehicleInfoVO setPageIndex(Integer pageIndex) {
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
	public VehicleInfoVO setPageSize(Integer pageSize) {
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
	public VehicleInfoVO setSearchField(String searchField) {
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
	public VehicleInfoVO setFuzzyField(String fuzzyField) {
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
	public VehicleInfoVO setSearchValue(String searchValue) {
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
	public VehicleInfoVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public VehicleInfoVO addDirtyField(String... dirtyField) {
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
	public VehicleInfoVO setSortField(String sortField) {
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
	public VehicleInfoVO setSortType(String sortType) {
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
	public VehicleInfoVO setDataOrigin(String dataOrigin) {
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
	public VehicleInfoVO setQueryLogic(String queryLogic) {
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
	public VehicleInfoVO setRequestAction(String requestAction) {
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
	public VehicleInfoVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public VehicleInfoVO addId(String... id) {
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
	 * @return VehicleInfoVO , 转换好的 VehicleInfoVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return VehicleInfoVO , 转换好的 PoJo 对象
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
	public VehicleInfoVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public VehicleInfoVO duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.VehicleInfoVOMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.VehicleInfoVOMeta.$$proxy$$();
		inst.setRescueDueDate(this.getRescueDueDate());
		inst.setNotes(this.getNotes());
		inst.setColor(this.getColor());
		inst.setMaximumPassengers(this.getMaximumPassengers());
		inst.setRescueMoney(this.getRescueMoney());
		inst.setType(this.getType());
		inst.setManageUserId(this.getManageUserId());
		inst.setScrapTime(this.getScrapTime());
		inst.setPictures(this.getPictures());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setCommercialInsuranceMoney(this.getCommercialInsuranceMoney());
		inst.setModel(this.getModel());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setInsuranceCompany(this.getInsuranceCompany());
		inst.setFrameNumber(this.getFrameNumber());
		inst.setUseOrgId(this.getUseOrgId());
		inst.setEngineNumber(this.getEngineNumber());
		inst.setVehicleCode(this.getVehicleCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setInsuranceExpireDate(this.getInsuranceExpireDate());
		inst.setVersion(this.getVersion());
		inst.setPositionDetail(this.getPositionDetail());
		inst.setTechnicalParameter(this.getTechnicalParameter());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPositionId(this.getPositionId());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDrivingLicense(this.getDrivingLicense());
		inst.setKilometers(this.getKilometers());
		inst.setName(this.getName());
		inst.setLicensingTime(this.getLicensingTime());
		inst.setTenantId(this.getTenantId());
		inst.setOwnerOrgId(this.getOwnerOrgId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setRegistrant(this.getRegistrant());
		inst.setCarBoatTax(this.getCarBoatTax());
		inst.setUseUserId(this.getUseUserId());
		inst.setVehicleStatus(this.getVehicleStatus());
		if(all) {
			inst.setOwnerCompany(this.getOwnerCompany());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setVehicleStatusDict(this.getVehicleStatusDict());
			inst.setOriginator(this.getOriginator());
			inst.setSelectIds(this.getSelectIds());
			inst.setUseOrganization(this.getUseOrganization());
			inst.setVehicleInsuranceCompany(this.getVehicleInsuranceCompany());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setVehicleTypeDict(this.getVehicleTypeDict());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setUseUser(this.getUseUser());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public VehicleInfoVO clone(boolean deep) {
		return EntityContext.clone(VehicleInfoVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 VehicleInfoVO
	 * @param vehicleInfoMap 包含实体信息的 Map 对象
	 * @return VehicleInfoVO , 转换好的的 VehicleInfo 对象
	*/
	@Transient
	public static VehicleInfoVO createFrom(Map<String,Object> vehicleInfoMap) {
		if(vehicleInfoMap==null) return null;
		VehicleInfoVO vo = create();
		EntityContext.copyProperties(vo,vehicleInfoMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 VehicleInfoVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return VehicleInfoVO , 转换好的的 VehicleInfo 对象
	*/
	@Transient
	public static VehicleInfoVO createFrom(Object pojo) {
		if(pojo==null) return null;
		VehicleInfoVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 VehicleInfoVO，等同于 new
	 * @return VehicleInfoVO 对象
	*/
	@Transient
	public static VehicleInfoVO create() {
		return new com.dt.platform.domain.oa.meta.VehicleInfoVOMeta.$$proxy$$();
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
			this.setRescueDueDate(DataParser.parse(Date.class, map.get(VehicleInfoVOMeta.RESCUE_DUE_DATE)));
			this.setNotes(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.NOTES)));
			this.setColor(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.COLOR)));
			this.setMaximumPassengers(DataParser.parse(Integer.class, map.get(VehicleInfoVOMeta.MAXIMUM_PASSENGERS)));
			this.setRescueMoney(DataParser.parse(BigDecimal.class, map.get(VehicleInfoVOMeta.RESCUE_MONEY)));
			this.setType(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.TYPE)));
			this.setManageUserId(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.MANAGE_USER_ID)));
			this.setScrapTime(DataParser.parse(Date.class, map.get(VehicleInfoVOMeta.SCRAP_TIME)));
			this.setPictures(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.PICTURES)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.UPDATE_BY)));
			this.setCommercialInsuranceMoney(DataParser.parse(BigDecimal.class, map.get(VehicleInfoVOMeta.COMMERCIAL_INSURANCE_MONEY)));
			this.setModel(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.MODEL)));
			this.setId(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.ORIGINATOR_ID)));
			this.setInsuranceCompany(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.INSURANCE_COMPANY)));
			this.setFrameNumber(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.FRAME_NUMBER)));
			this.setUseOrgId(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.USE_ORG_ID)));
			this.setEngineNumber(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.ENGINE_NUMBER)));
			this.setVehicleCode(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.VEHICLE_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(VehicleInfoVOMeta.UPDATE_TIME)));
			this.setInsuranceExpireDate(DataParser.parse(Date.class, map.get(VehicleInfoVOMeta.INSURANCE_EXPIRE_DATE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(VehicleInfoVOMeta.VERSION)));
			this.setPositionDetail(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.POSITION_DETAIL)));
			this.setTechnicalParameter(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.TECHNICAL_PARAMETER)));
			this.setCreateBy(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(VehicleInfoVOMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(VehicleInfoVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(VehicleInfoVOMeta.DELETE_TIME)));
			this.setDrivingLicense(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.DRIVING_LICENSE)));
			this.setKilometers(DataParser.parse(BigDecimal.class, map.get(VehicleInfoVOMeta.KILOMETERS)));
			this.setName(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.NAME)));
			this.setLicensingTime(DataParser.parse(Date.class, map.get(VehicleInfoVOMeta.LICENSING_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.TENANT_ID)));
			this.setOwnerOrgId(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.OWNER_ORG_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.DELETE_BY)));
			this.setRegistrant(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.REGISTRANT)));
			this.setCarBoatTax(DataParser.parse(BigDecimal.class, map.get(VehicleInfoVOMeta.CAR_BOAT_TAX)));
			this.setUseUserId(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.USE_USER_ID)));
			this.setVehicleStatus(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.VEHICLE_STATUS)));
			// others
			this.setOwnerCompany(DataParser.parse(Organization.class, map.get(VehicleInfoVOMeta.OWNER_COMPANY)));
			this.setSearchField(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(VehicleInfoVOMeta.PAGE_SIZE)));
			this.setVehicleStatusDict(DataParser.parse(DictItem.class, map.get(VehicleInfoVOMeta.VEHICLE_STATUS_DICT)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(VehicleInfoVOMeta.ORIGINATOR)));
			this.setSelectIds(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.SELECT_IDS)));
			this.setUseOrganization(DataParser.parse(Organization.class, map.get(VehicleInfoVOMeta.USE_ORGANIZATION)));
			this.setVehicleInsuranceCompany(DataParser.parse(VehicleInsuranceCompany.class, map.get(VehicleInfoVOMeta.VEHICLE_INSURANCE_COMPANY)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(VehicleInfoVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.SORT_TYPE)));
			this.setVehicleTypeDict(DataParser.parse(DictItem.class, map.get(VehicleInfoVOMeta.VEHICLE_TYPE_DICT)));
			this.setSortField(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.QUERY_LOGIC)));
			this.setUseUser(DataParser.parse(Employee.class, map.get(VehicleInfoVOMeta.USE_USER)));
			this.setSearchValue(DataParser.parse(String.class, map.get(VehicleInfoVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setRescueDueDate( (Date)map.get(VehicleInfoVOMeta.RESCUE_DUE_DATE));
				this.setNotes( (String)map.get(VehicleInfoVOMeta.NOTES));
				this.setColor( (String)map.get(VehicleInfoVOMeta.COLOR));
				this.setMaximumPassengers( (Integer)map.get(VehicleInfoVOMeta.MAXIMUM_PASSENGERS));
				this.setRescueMoney( (BigDecimal)map.get(VehicleInfoVOMeta.RESCUE_MONEY));
				this.setType( (String)map.get(VehicleInfoVOMeta.TYPE));
				this.setManageUserId( (String)map.get(VehicleInfoVOMeta.MANAGE_USER_ID));
				this.setScrapTime( (Date)map.get(VehicleInfoVOMeta.SCRAP_TIME));
				this.setPictures( (String)map.get(VehicleInfoVOMeta.PICTURES));
				this.setUpdateBy( (String)map.get(VehicleInfoVOMeta.UPDATE_BY));
				this.setCommercialInsuranceMoney( (BigDecimal)map.get(VehicleInfoVOMeta.COMMERCIAL_INSURANCE_MONEY));
				this.setModel( (String)map.get(VehicleInfoVOMeta.MODEL));
				this.setId( (String)map.get(VehicleInfoVOMeta.ID));
				this.setOriginatorId( (String)map.get(VehicleInfoVOMeta.ORIGINATOR_ID));
				this.setInsuranceCompany( (String)map.get(VehicleInfoVOMeta.INSURANCE_COMPANY));
				this.setFrameNumber( (String)map.get(VehicleInfoVOMeta.FRAME_NUMBER));
				this.setUseOrgId( (String)map.get(VehicleInfoVOMeta.USE_ORG_ID));
				this.setEngineNumber( (String)map.get(VehicleInfoVOMeta.ENGINE_NUMBER));
				this.setVehicleCode( (String)map.get(VehicleInfoVOMeta.VEHICLE_CODE));
				this.setUpdateTime( (Date)map.get(VehicleInfoVOMeta.UPDATE_TIME));
				this.setInsuranceExpireDate( (Date)map.get(VehicleInfoVOMeta.INSURANCE_EXPIRE_DATE));
				this.setVersion( (Integer)map.get(VehicleInfoVOMeta.VERSION));
				this.setPositionDetail( (String)map.get(VehicleInfoVOMeta.POSITION_DETAIL));
				this.setTechnicalParameter( (String)map.get(VehicleInfoVOMeta.TECHNICAL_PARAMETER));
				this.setCreateBy( (String)map.get(VehicleInfoVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(VehicleInfoVOMeta.DELETED));
				this.setPositionId( (String)map.get(VehicleInfoVOMeta.POSITION_ID));
				this.setCreateTime( (Date)map.get(VehicleInfoVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(VehicleInfoVOMeta.DELETE_TIME));
				this.setDrivingLicense( (String)map.get(VehicleInfoVOMeta.DRIVING_LICENSE));
				this.setKilometers( (BigDecimal)map.get(VehicleInfoVOMeta.KILOMETERS));
				this.setName( (String)map.get(VehicleInfoVOMeta.NAME));
				this.setLicensingTime( (Date)map.get(VehicleInfoVOMeta.LICENSING_TIME));
				this.setTenantId( (String)map.get(VehicleInfoVOMeta.TENANT_ID));
				this.setOwnerOrgId( (String)map.get(VehicleInfoVOMeta.OWNER_ORG_ID));
				this.setDeleteBy( (String)map.get(VehicleInfoVOMeta.DELETE_BY));
				this.setRegistrant( (String)map.get(VehicleInfoVOMeta.REGISTRANT));
				this.setCarBoatTax( (BigDecimal)map.get(VehicleInfoVOMeta.CAR_BOAT_TAX));
				this.setUseUserId( (String)map.get(VehicleInfoVOMeta.USE_USER_ID));
				this.setVehicleStatus( (String)map.get(VehicleInfoVOMeta.VEHICLE_STATUS));
				// others
				this.setOwnerCompany( (Organization)map.get(VehicleInfoVOMeta.OWNER_COMPANY));
				this.setSearchField( (String)map.get(VehicleInfoVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(VehicleInfoVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(VehicleInfoVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(VehicleInfoVOMeta.PAGE_SIZE));
				this.setVehicleStatusDict( (DictItem)map.get(VehicleInfoVOMeta.VEHICLE_STATUS_DICT));
				this.setOriginator( (Employee)map.get(VehicleInfoVOMeta.ORIGINATOR));
				this.setSelectIds( (String)map.get(VehicleInfoVOMeta.SELECT_IDS));
				this.setUseOrganization( (Organization)map.get(VehicleInfoVOMeta.USE_ORGANIZATION));
				this.setVehicleInsuranceCompany( (VehicleInsuranceCompany)map.get(VehicleInfoVOMeta.VEHICLE_INSURANCE_COMPANY));
				this.setPageIndex( (Integer)map.get(VehicleInfoVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(VehicleInfoVOMeta.SORT_TYPE));
				this.setVehicleTypeDict( (DictItem)map.get(VehicleInfoVOMeta.VEHICLE_TYPE_DICT));
				this.setSortField( (String)map.get(VehicleInfoVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(VehicleInfoVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(VehicleInfoVOMeta.QUERY_LOGIC));
				this.setUseUser( (Employee)map.get(VehicleInfoVOMeta.USE_USER));
				this.setSearchValue( (String)map.get(VehicleInfoVOMeta.SEARCH_VALUE));
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
			this.setRescueDueDate(DataParser.parse(Date.class, r.getValue(VehicleInfoVOMeta.RESCUE_DUE_DATE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.NOTES)));
			this.setColor(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.COLOR)));
			this.setMaximumPassengers(DataParser.parse(Integer.class, r.getValue(VehicleInfoVOMeta.MAXIMUM_PASSENGERS)));
			this.setRescueMoney(DataParser.parse(BigDecimal.class, r.getValue(VehicleInfoVOMeta.RESCUE_MONEY)));
			this.setType(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.TYPE)));
			this.setManageUserId(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.MANAGE_USER_ID)));
			this.setScrapTime(DataParser.parse(Date.class, r.getValue(VehicleInfoVOMeta.SCRAP_TIME)));
			this.setPictures(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.PICTURES)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.UPDATE_BY)));
			this.setCommercialInsuranceMoney(DataParser.parse(BigDecimal.class, r.getValue(VehicleInfoVOMeta.COMMERCIAL_INSURANCE_MONEY)));
			this.setModel(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.MODEL)));
			this.setId(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.ORIGINATOR_ID)));
			this.setInsuranceCompany(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.INSURANCE_COMPANY)));
			this.setFrameNumber(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.FRAME_NUMBER)));
			this.setUseOrgId(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.USE_ORG_ID)));
			this.setEngineNumber(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.ENGINE_NUMBER)));
			this.setVehicleCode(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.VEHICLE_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(VehicleInfoVOMeta.UPDATE_TIME)));
			this.setInsuranceExpireDate(DataParser.parse(Date.class, r.getValue(VehicleInfoVOMeta.INSURANCE_EXPIRE_DATE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(VehicleInfoVOMeta.VERSION)));
			this.setPositionDetail(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.POSITION_DETAIL)));
			this.setTechnicalParameter(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.TECHNICAL_PARAMETER)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(VehicleInfoVOMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(VehicleInfoVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(VehicleInfoVOMeta.DELETE_TIME)));
			this.setDrivingLicense(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.DRIVING_LICENSE)));
			this.setKilometers(DataParser.parse(BigDecimal.class, r.getValue(VehicleInfoVOMeta.KILOMETERS)));
			this.setName(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.NAME)));
			this.setLicensingTime(DataParser.parse(Date.class, r.getValue(VehicleInfoVOMeta.LICENSING_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.TENANT_ID)));
			this.setOwnerOrgId(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.OWNER_ORG_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.DELETE_BY)));
			this.setRegistrant(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.REGISTRANT)));
			this.setCarBoatTax(DataParser.parse(BigDecimal.class, r.getValue(VehicleInfoVOMeta.CAR_BOAT_TAX)));
			this.setUseUserId(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.USE_USER_ID)));
			this.setVehicleStatus(DataParser.parse(String.class, r.getValue(VehicleInfoVOMeta.VEHICLE_STATUS)));
			return true;
		} else {
			try {
				this.setRescueDueDate( (Date)r.getValue(VehicleInfoVOMeta.RESCUE_DUE_DATE));
				this.setNotes( (String)r.getValue(VehicleInfoVOMeta.NOTES));
				this.setColor( (String)r.getValue(VehicleInfoVOMeta.COLOR));
				this.setMaximumPassengers( (Integer)r.getValue(VehicleInfoVOMeta.MAXIMUM_PASSENGERS));
				this.setRescueMoney( (BigDecimal)r.getValue(VehicleInfoVOMeta.RESCUE_MONEY));
				this.setType( (String)r.getValue(VehicleInfoVOMeta.TYPE));
				this.setManageUserId( (String)r.getValue(VehicleInfoVOMeta.MANAGE_USER_ID));
				this.setScrapTime( (Date)r.getValue(VehicleInfoVOMeta.SCRAP_TIME));
				this.setPictures( (String)r.getValue(VehicleInfoVOMeta.PICTURES));
				this.setUpdateBy( (String)r.getValue(VehicleInfoVOMeta.UPDATE_BY));
				this.setCommercialInsuranceMoney( (BigDecimal)r.getValue(VehicleInfoVOMeta.COMMERCIAL_INSURANCE_MONEY));
				this.setModel( (String)r.getValue(VehicleInfoVOMeta.MODEL));
				this.setId( (String)r.getValue(VehicleInfoVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(VehicleInfoVOMeta.ORIGINATOR_ID));
				this.setInsuranceCompany( (String)r.getValue(VehicleInfoVOMeta.INSURANCE_COMPANY));
				this.setFrameNumber( (String)r.getValue(VehicleInfoVOMeta.FRAME_NUMBER));
				this.setUseOrgId( (String)r.getValue(VehicleInfoVOMeta.USE_ORG_ID));
				this.setEngineNumber( (String)r.getValue(VehicleInfoVOMeta.ENGINE_NUMBER));
				this.setVehicleCode( (String)r.getValue(VehicleInfoVOMeta.VEHICLE_CODE));
				this.setUpdateTime( (Date)r.getValue(VehicleInfoVOMeta.UPDATE_TIME));
				this.setInsuranceExpireDate( (Date)r.getValue(VehicleInfoVOMeta.INSURANCE_EXPIRE_DATE));
				this.setVersion( (Integer)r.getValue(VehicleInfoVOMeta.VERSION));
				this.setPositionDetail( (String)r.getValue(VehicleInfoVOMeta.POSITION_DETAIL));
				this.setTechnicalParameter( (String)r.getValue(VehicleInfoVOMeta.TECHNICAL_PARAMETER));
				this.setCreateBy( (String)r.getValue(VehicleInfoVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(VehicleInfoVOMeta.DELETED));
				this.setPositionId( (String)r.getValue(VehicleInfoVOMeta.POSITION_ID));
				this.setCreateTime( (Date)r.getValue(VehicleInfoVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(VehicleInfoVOMeta.DELETE_TIME));
				this.setDrivingLicense( (String)r.getValue(VehicleInfoVOMeta.DRIVING_LICENSE));
				this.setKilometers( (BigDecimal)r.getValue(VehicleInfoVOMeta.KILOMETERS));
				this.setName( (String)r.getValue(VehicleInfoVOMeta.NAME));
				this.setLicensingTime( (Date)r.getValue(VehicleInfoVOMeta.LICENSING_TIME));
				this.setTenantId( (String)r.getValue(VehicleInfoVOMeta.TENANT_ID));
				this.setOwnerOrgId( (String)r.getValue(VehicleInfoVOMeta.OWNER_ORG_ID));
				this.setDeleteBy( (String)r.getValue(VehicleInfoVOMeta.DELETE_BY));
				this.setRegistrant( (String)r.getValue(VehicleInfoVOMeta.REGISTRANT));
				this.setCarBoatTax( (BigDecimal)r.getValue(VehicleInfoVOMeta.CAR_BOAT_TAX));
				this.setUseUserId( (String)r.getValue(VehicleInfoVOMeta.USE_USER_ID));
				this.setVehicleStatus( (String)r.getValue(VehicleInfoVOMeta.VEHICLE_STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}