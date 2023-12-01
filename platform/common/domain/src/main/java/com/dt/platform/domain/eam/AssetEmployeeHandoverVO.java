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
import com.dt.platform.domain.eam.meta.AssetEmployeeHandoverVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.domain.hrm.Organization;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产交接VO类型
 * <p>资产交接 , 数据表 eam_asset_employee_handover 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-12-01 13:15:36
 * @sign F7CD68BC3821A76BC5EF3D4A9E71686A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "资产交接VO类型 ; 资产交接 , 数据表 eam_asset_employee_handover 的通用VO类型" , parent = AssetEmployeeHandover.class)
public class AssetEmployeeHandoverVO extends AssetEmployeeHandover {

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
	public AssetEmployeeHandoverVO setPageIndex(Integer pageIndex) {
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
	public AssetEmployeeHandoverVO setPageSize(Integer pageSize) {
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
	public AssetEmployeeHandoverVO setSearchField(String searchField) {
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
	public AssetEmployeeHandoverVO setFuzzyField(String fuzzyField) {
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
	public AssetEmployeeHandoverVO setSearchValue(String searchValue) {
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
	public AssetEmployeeHandoverVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetEmployeeHandoverVO addDirtyField(String... dirtyField) {
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
	public AssetEmployeeHandoverVO setSortField(String sortField) {
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
	public AssetEmployeeHandoverVO setSortType(String sortType) {
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
	public AssetEmployeeHandoverVO setDataOrigin(String dataOrigin) {
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
	public AssetEmployeeHandoverVO setQueryLogic(String queryLogic) {
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
	public AssetEmployeeHandoverVO setRequestAction(String requestAction) {
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
	public AssetEmployeeHandoverVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetEmployeeHandoverVO addId(String... id) {
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
	 * @return AssetEmployeeHandoverVO , 转换好的 AssetEmployeeHandoverVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetEmployeeHandoverVO , 转换好的 PoJo 对象
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
	public AssetEmployeeHandoverVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetEmployeeHandoverVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetEmployeeHandoverVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetEmployeeHandoverVOMeta.$$proxy$$();
		inst.setReceiveOrgId(this.getReceiveOrgId());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setOrgId(this.getOrgId());
		inst.setContent(this.getContent());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setReceiveUserId(this.getReceiveUserId());
		inst.setCreateBy(this.getCreateBy());
		inst.setRecordTime(this.getRecordTime());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setReceiverUser(this.getReceiverUser());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setAssetIds(this.getAssetIds());
			inst.setPageSize(this.getPageSize());
			inst.setHistoricProcessList(this.getHistoricProcessList());
			inst.setOriginator(this.getOriginator());
			inst.setAssetList(this.getAssetList());
			inst.setOriginatorUserName(this.getOriginatorUserName());
			inst.setCurrentProcessList(this.getCurrentProcessList());
			inst.setDefaultProcess(this.getDefaultProcess());
			inst.setReceiveOrganization(this.getReceiveOrganization());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setOrganization(this.getOrganization());
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
	public AssetEmployeeHandoverVO clone(boolean deep) {
		return EntityContext.clone(AssetEmployeeHandoverVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetEmployeeHandoverVO
	 * @param assetEmployeeHandoverMap 包含实体信息的 Map 对象
	 * @return AssetEmployeeHandoverVO , 转换好的的 AssetEmployeeHandover 对象
	*/
	@Transient
	public static AssetEmployeeHandoverVO createFrom(Map<String,Object> assetEmployeeHandoverMap) {
		if(assetEmployeeHandoverMap==null) return null;
		AssetEmployeeHandoverVO vo = create();
		EntityContext.copyProperties(vo,assetEmployeeHandoverMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetEmployeeHandoverVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetEmployeeHandoverVO , 转换好的的 AssetEmployeeHandover 对象
	*/
	@Transient
	public static AssetEmployeeHandoverVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetEmployeeHandoverVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetEmployeeHandoverVO，等同于 new
	 * @return AssetEmployeeHandoverVO 对象
	*/
	@Transient
	public static AssetEmployeeHandoverVO create() {
		return new com.dt.platform.domain.eam.meta.AssetEmployeeHandoverVOMeta.$$proxy$$();
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
			this.setReceiveOrgId(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.RECEIVE_ORG_ID)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetEmployeeHandoverVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetEmployeeHandoverVOMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.SELECTED_CODE)));
			this.setOrgId(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.ORG_ID)));
			this.setContent(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.CONTENT)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.BUSINESS_CODE)));
			this.setReceiveUserId(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.RECEIVE_USER_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, map.get(AssetEmployeeHandoverVOMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetEmployeeHandoverVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetEmployeeHandoverVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetEmployeeHandoverVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.ORIGINATOR_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.SEARCH_FIELD)));
			this.setReceiverUser(DataParser.parse(Employee.class, map.get(AssetEmployeeHandoverVOMeta.RECEIVER_USER)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetEmployeeHandoverVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetEmployeeHandoverVOMeta.ORIGINATOR)));
			this.setOriginatorUserName(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.ORIGINATOR_USER_NAME)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(AssetEmployeeHandoverVOMeta.DEFAULT_PROCESS)));
			this.setReceiveOrganization(DataParser.parse(Organization.class, map.get(AssetEmployeeHandoverVOMeta.RECEIVE_ORGANIZATION)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetEmployeeHandoverVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.SORT_TYPE)));
			this.setOrganization(DataParser.parse(Organization.class, map.get(AssetEmployeeHandoverVOMeta.ORGANIZATION)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetEmployeeHandoverVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setReceiveOrgId( (String)map.get(AssetEmployeeHandoverVOMeta.RECEIVE_ORG_ID));
				this.setNotes( (String)map.get(AssetEmployeeHandoverVOMeta.NOTES));
				this.setUpdateTime( (Date)map.get(AssetEmployeeHandoverVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetEmployeeHandoverVOMeta.VERSION));
				this.setSelectedCode( (String)map.get(AssetEmployeeHandoverVOMeta.SELECTED_CODE));
				this.setOrgId( (String)map.get(AssetEmployeeHandoverVOMeta.ORG_ID));
				this.setContent( (String)map.get(AssetEmployeeHandoverVOMeta.CONTENT));
				this.setBusinessCode( (String)map.get(AssetEmployeeHandoverVOMeta.BUSINESS_CODE));
				this.setReceiveUserId( (String)map.get(AssetEmployeeHandoverVOMeta.RECEIVE_USER_ID));
				this.setCreateBy( (String)map.get(AssetEmployeeHandoverVOMeta.CREATE_BY));
				this.setRecordTime( (Date)map.get(AssetEmployeeHandoverVOMeta.RECORD_TIME));
				this.setDeleted( (Integer)map.get(AssetEmployeeHandoverVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetEmployeeHandoverVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetEmployeeHandoverVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetEmployeeHandoverVOMeta.DELETE_TIME));
				this.setName( (String)map.get(AssetEmployeeHandoverVOMeta.NAME));
				this.setTenantId( (String)map.get(AssetEmployeeHandoverVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetEmployeeHandoverVOMeta.DELETE_BY));
				this.setId( (String)map.get(AssetEmployeeHandoverVOMeta.ID));
				this.setOriginatorId( (String)map.get(AssetEmployeeHandoverVOMeta.ORIGINATOR_ID));
				this.setStatus( (String)map.get(AssetEmployeeHandoverVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(AssetEmployeeHandoverVOMeta.SEARCH_FIELD));
				this.setReceiverUser( (Employee)map.get(AssetEmployeeHandoverVOMeta.RECEIVER_USER));
				this.setRequestAction( (String)map.get(AssetEmployeeHandoverVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(AssetEmployeeHandoverVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssetEmployeeHandoverVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(AssetEmployeeHandoverVOMeta.ORIGINATOR));
				this.setOriginatorUserName( (String)map.get(AssetEmployeeHandoverVOMeta.ORIGINATOR_USER_NAME));
				this.setDefaultProcess( (ProcessInstance)map.get(AssetEmployeeHandoverVOMeta.DEFAULT_PROCESS));
				this.setReceiveOrganization( (Organization)map.get(AssetEmployeeHandoverVOMeta.RECEIVE_ORGANIZATION));
				this.setPageIndex( (Integer)map.get(AssetEmployeeHandoverVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetEmployeeHandoverVOMeta.SORT_TYPE));
				this.setOrganization( (Organization)map.get(AssetEmployeeHandoverVOMeta.ORGANIZATION));
				this.setSortField( (String)map.get(AssetEmployeeHandoverVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(AssetEmployeeHandoverVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(AssetEmployeeHandoverVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(AssetEmployeeHandoverVOMeta.SEARCH_VALUE));
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
			this.setReceiveOrgId(DataParser.parse(String.class, r.getValue(AssetEmployeeHandoverVOMeta.RECEIVE_ORG_ID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetEmployeeHandoverVOMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetEmployeeHandoverVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetEmployeeHandoverVOMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetEmployeeHandoverVOMeta.SELECTED_CODE)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(AssetEmployeeHandoverVOMeta.ORG_ID)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetEmployeeHandoverVOMeta.CONTENT)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetEmployeeHandoverVOMeta.BUSINESS_CODE)));
			this.setReceiveUserId(DataParser.parse(String.class, r.getValue(AssetEmployeeHandoverVOMeta.RECEIVE_USER_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetEmployeeHandoverVOMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, r.getValue(AssetEmployeeHandoverVOMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetEmployeeHandoverVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetEmployeeHandoverVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetEmployeeHandoverVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetEmployeeHandoverVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetEmployeeHandoverVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetEmployeeHandoverVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetEmployeeHandoverVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetEmployeeHandoverVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetEmployeeHandoverVOMeta.ORIGINATOR_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetEmployeeHandoverVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setReceiveOrgId( (String)r.getValue(AssetEmployeeHandoverVOMeta.RECEIVE_ORG_ID));
				this.setNotes( (String)r.getValue(AssetEmployeeHandoverVOMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(AssetEmployeeHandoverVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetEmployeeHandoverVOMeta.VERSION));
				this.setSelectedCode( (String)r.getValue(AssetEmployeeHandoverVOMeta.SELECTED_CODE));
				this.setOrgId( (String)r.getValue(AssetEmployeeHandoverVOMeta.ORG_ID));
				this.setContent( (String)r.getValue(AssetEmployeeHandoverVOMeta.CONTENT));
				this.setBusinessCode( (String)r.getValue(AssetEmployeeHandoverVOMeta.BUSINESS_CODE));
				this.setReceiveUserId( (String)r.getValue(AssetEmployeeHandoverVOMeta.RECEIVE_USER_ID));
				this.setCreateBy( (String)r.getValue(AssetEmployeeHandoverVOMeta.CREATE_BY));
				this.setRecordTime( (Date)r.getValue(AssetEmployeeHandoverVOMeta.RECORD_TIME));
				this.setDeleted( (Integer)r.getValue(AssetEmployeeHandoverVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetEmployeeHandoverVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetEmployeeHandoverVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetEmployeeHandoverVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssetEmployeeHandoverVOMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetEmployeeHandoverVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetEmployeeHandoverVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetEmployeeHandoverVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetEmployeeHandoverVOMeta.ORIGINATOR_ID));
				this.setStatus( (String)r.getValue(AssetEmployeeHandoverVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}