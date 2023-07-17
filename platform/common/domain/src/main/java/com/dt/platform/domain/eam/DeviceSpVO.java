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
import com.dt.platform.domain.eam.meta.DeviceSpVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 备件清单VO类型
 * <p>备件清单 , 数据表 eam_device_sp 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-17 15:25:52
 * @sign 0E46684EB74B7A7BF47F509EDF3C83AE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "备件清单VO类型 ; 备件清单 , 数据表 eam_device_sp 的通用VO类型" , parent = DeviceSp.class)
public class DeviceSpVO extends DeviceSp {

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
	public DeviceSpVO setPageIndex(Integer pageIndex) {
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
	public DeviceSpVO setPageSize(Integer pageSize) {
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
	public DeviceSpVO setSearchField(String searchField) {
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
	public DeviceSpVO setFuzzyField(String fuzzyField) {
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
	public DeviceSpVO setSearchValue(String searchValue) {
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
	public DeviceSpVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public DeviceSpVO addDirtyField(String... dirtyField) {
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
	public DeviceSpVO setSortField(String sortField) {
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
	public DeviceSpVO setSortType(String sortType) {
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
	public DeviceSpVO setDataOrigin(String dataOrigin) {
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
	public DeviceSpVO setQueryLogic(String queryLogic) {
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
	public DeviceSpVO setRequestAction(String requestAction) {
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
	public DeviceSpVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public DeviceSpVO addId(String... id) {
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
	 * @return DeviceSpVO , 转换好的 DeviceSpVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DeviceSpVO , 转换好的 PoJo 对象
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
	public DeviceSpVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DeviceSpVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.DeviceSpVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.DeviceSpVOMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setType(this.getType());
		inst.setUsageRange(this.getUsageRange());
		inst.setPictureId(this.getPictureId());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setAdaptingDevice(this.getAdaptingDevice());
		inst.setSupplier(this.getSupplier());
		inst.setId(this.getId());
		inst.setSn(this.getSn());
		inst.setLocked(this.getLocked());
		inst.setLocId(this.getLocId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setInsertTime(this.getInsertTime());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setManagerUserId(this.getManagerUserId());
		inst.setSourceDesc(this.getSourceDesc());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setOwnerType(this.getOwnerType());
			inst.setDeviceSpType(this.getDeviceSpType());
			inst.setManager(this.getManager());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setUsage(this.getUsage());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setAssetList(this.getAssetList());
			inst.setDeviceAssociate(this.getDeviceAssociate());
			inst.setOwnerId(this.getOwnerId());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setPosition(this.getPosition());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DeviceSpVO clone(boolean deep) {
		return EntityContext.clone(DeviceSpVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DeviceSpVO
	 * @param deviceSpMap 包含实体信息的 Map 对象
	 * @return DeviceSpVO , 转换好的的 DeviceSp 对象
	*/
	@Transient
	public static DeviceSpVO createFrom(Map<String,Object> deviceSpMap) {
		if(deviceSpMap==null) return null;
		DeviceSpVO vo = create();
		EntityContext.copyProperties(vo,deviceSpMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 DeviceSpVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DeviceSpVO , 转换好的的 DeviceSp 对象
	*/
	@Transient
	public static DeviceSpVO createFrom(Object pojo) {
		if(pojo==null) return null;
		DeviceSpVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 DeviceSpVO，等同于 new
	 * @return DeviceSpVO 对象
	*/
	@Transient
	public static DeviceSpVO create() {
		return new com.dt.platform.domain.eam.meta.DeviceSpVOMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(DeviceSpVOMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(DeviceSpVOMeta.NOTES)));
			this.setType(DataParser.parse(String.class, map.get(DeviceSpVOMeta.TYPE)));
			this.setUsageRange(DataParser.parse(String.class, map.get(DeviceSpVOMeta.USAGE_RANGE)));
			this.setPictureId(DataParser.parse(String.class, map.get(DeviceSpVOMeta.PICTURE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DeviceSpVOMeta.UPDATE_BY)));
			this.setAdaptingDevice(DataParser.parse(String.class, map.get(DeviceSpVOMeta.ADAPTING_DEVICE)));
			this.setSupplier(DataParser.parse(String.class, map.get(DeviceSpVOMeta.SUPPLIER)));
			this.setId(DataParser.parse(String.class, map.get(DeviceSpVOMeta.ID)));
			this.setSn(DataParser.parse(String.class, map.get(DeviceSpVOMeta.SN)));
			this.setLocked(DataParser.parse(String.class, map.get(DeviceSpVOMeta.LOCKED)));
			this.setLocId(DataParser.parse(String.class, map.get(DeviceSpVOMeta.LOC_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DeviceSpVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DeviceSpVOMeta.VERSION)));
			this.setInsertTime(DataParser.parse(Date.class, map.get(DeviceSpVOMeta.INSERT_TIME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DeviceSpVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DeviceSpVOMeta.DELETED)));
			this.setManagerUserId(DataParser.parse(String.class, map.get(DeviceSpVOMeta.MANAGER_USER_ID)));
			this.setSourceDesc(DataParser.parse(String.class, map.get(DeviceSpVOMeta.SOURCE_DESC)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DeviceSpVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DeviceSpVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(DeviceSpVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(DeviceSpVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DeviceSpVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(DeviceSpVOMeta.STATUS)));
			// others
			this.setOwnerType(DataParser.parse(String.class, map.get(DeviceSpVOMeta.OWNER_TYPE)));
			this.setDeviceSpType(DataParser.parse(DeviceSpType.class, map.get(DeviceSpVOMeta.DEVICE_SP_TYPE)));
			this.setManager(DataParser.parse(Employee.class, map.get(DeviceSpVOMeta.MANAGER)));
			this.setSearchField(DataParser.parse(String.class, map.get(DeviceSpVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(DeviceSpVOMeta.REQUEST_ACTION)));
			this.setUsage(DataParser.parse(DictItem.class, map.get(DeviceSpVOMeta.USAGE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(DeviceSpVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(DeviceSpVOMeta.PAGE_SIZE)));
			this.setOwnerId(DataParser.parse(String.class, map.get(DeviceSpVOMeta.OWNER_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(DeviceSpVOMeta.SELECTED_CODE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(DeviceSpVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(DeviceSpVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(DeviceSpVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(DeviceSpVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(DeviceSpVOMeta.QUERY_LOGIC)));
			this.setPosition(DataParser.parse(Position.class, map.get(DeviceSpVOMeta.POSITION)));
			this.setSearchValue(DataParser.parse(String.class, map.get(DeviceSpVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(DeviceSpVOMeta.CODE));
				this.setNotes( (String)map.get(DeviceSpVOMeta.NOTES));
				this.setType( (String)map.get(DeviceSpVOMeta.TYPE));
				this.setUsageRange( (String)map.get(DeviceSpVOMeta.USAGE_RANGE));
				this.setPictureId( (String)map.get(DeviceSpVOMeta.PICTURE_ID));
				this.setUpdateBy( (String)map.get(DeviceSpVOMeta.UPDATE_BY));
				this.setAdaptingDevice( (String)map.get(DeviceSpVOMeta.ADAPTING_DEVICE));
				this.setSupplier( (String)map.get(DeviceSpVOMeta.SUPPLIER));
				this.setId( (String)map.get(DeviceSpVOMeta.ID));
				this.setSn( (String)map.get(DeviceSpVOMeta.SN));
				this.setLocked( (String)map.get(DeviceSpVOMeta.LOCKED));
				this.setLocId( (String)map.get(DeviceSpVOMeta.LOC_ID));
				this.setUpdateTime( (Date)map.get(DeviceSpVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(DeviceSpVOMeta.VERSION));
				this.setInsertTime( (Date)map.get(DeviceSpVOMeta.INSERT_TIME));
				this.setCreateBy( (String)map.get(DeviceSpVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DeviceSpVOMeta.DELETED));
				this.setManagerUserId( (String)map.get(DeviceSpVOMeta.MANAGER_USER_ID));
				this.setSourceDesc( (String)map.get(DeviceSpVOMeta.SOURCE_DESC));
				this.setCreateTime( (Date)map.get(DeviceSpVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(DeviceSpVOMeta.DELETE_TIME));
				this.setName( (String)map.get(DeviceSpVOMeta.NAME));
				this.setTenantId( (String)map.get(DeviceSpVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(DeviceSpVOMeta.DELETE_BY));
				this.setStatus( (String)map.get(DeviceSpVOMeta.STATUS));
				// others
				this.setOwnerType( (String)map.get(DeviceSpVOMeta.OWNER_TYPE));
				this.setDeviceSpType( (DeviceSpType)map.get(DeviceSpVOMeta.DEVICE_SP_TYPE));
				this.setManager( (Employee)map.get(DeviceSpVOMeta.MANAGER));
				this.setSearchField( (String)map.get(DeviceSpVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(DeviceSpVOMeta.REQUEST_ACTION));
				this.setUsage( (DictItem)map.get(DeviceSpVOMeta.USAGE));
				this.setFuzzyField( (String)map.get(DeviceSpVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(DeviceSpVOMeta.PAGE_SIZE));
				this.setOwnerId( (String)map.get(DeviceSpVOMeta.OWNER_ID));
				this.setSelectedCode( (String)map.get(DeviceSpVOMeta.SELECTED_CODE));
				this.setPageIndex( (Integer)map.get(DeviceSpVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(DeviceSpVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(DeviceSpVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(DeviceSpVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(DeviceSpVOMeta.QUERY_LOGIC));
				this.setPosition( (Position)map.get(DeviceSpVOMeta.POSITION));
				this.setSearchValue( (String)map.get(DeviceSpVOMeta.SEARCH_VALUE));
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
			this.setCode(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.NOTES)));
			this.setType(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.TYPE)));
			this.setUsageRange(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.USAGE_RANGE)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.PICTURE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.UPDATE_BY)));
			this.setAdaptingDevice(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.ADAPTING_DEVICE)));
			this.setSupplier(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.SUPPLIER)));
			this.setId(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.ID)));
			this.setSn(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.SN)));
			this.setLocked(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.LOCKED)));
			this.setLocId(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.LOC_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DeviceSpVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DeviceSpVOMeta.VERSION)));
			this.setInsertTime(DataParser.parse(Date.class, r.getValue(DeviceSpVOMeta.INSERT_TIME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DeviceSpVOMeta.DELETED)));
			this.setManagerUserId(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.MANAGER_USER_ID)));
			this.setSourceDesc(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.SOURCE_DESC)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DeviceSpVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DeviceSpVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(DeviceSpVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(DeviceSpVOMeta.CODE));
				this.setNotes( (String)r.getValue(DeviceSpVOMeta.NOTES));
				this.setType( (String)r.getValue(DeviceSpVOMeta.TYPE));
				this.setUsageRange( (String)r.getValue(DeviceSpVOMeta.USAGE_RANGE));
				this.setPictureId( (String)r.getValue(DeviceSpVOMeta.PICTURE_ID));
				this.setUpdateBy( (String)r.getValue(DeviceSpVOMeta.UPDATE_BY));
				this.setAdaptingDevice( (String)r.getValue(DeviceSpVOMeta.ADAPTING_DEVICE));
				this.setSupplier( (String)r.getValue(DeviceSpVOMeta.SUPPLIER));
				this.setId( (String)r.getValue(DeviceSpVOMeta.ID));
				this.setSn( (String)r.getValue(DeviceSpVOMeta.SN));
				this.setLocked( (String)r.getValue(DeviceSpVOMeta.LOCKED));
				this.setLocId( (String)r.getValue(DeviceSpVOMeta.LOC_ID));
				this.setUpdateTime( (Date)r.getValue(DeviceSpVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(DeviceSpVOMeta.VERSION));
				this.setInsertTime( (Date)r.getValue(DeviceSpVOMeta.INSERT_TIME));
				this.setCreateBy( (String)r.getValue(DeviceSpVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DeviceSpVOMeta.DELETED));
				this.setManagerUserId( (String)r.getValue(DeviceSpVOMeta.MANAGER_USER_ID));
				this.setSourceDesc( (String)r.getValue(DeviceSpVOMeta.SOURCE_DESC));
				this.setCreateTime( (Date)r.getValue(DeviceSpVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(DeviceSpVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(DeviceSpVOMeta.NAME));
				this.setTenantId( (String)r.getValue(DeviceSpVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(DeviceSpVOMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(DeviceSpVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}