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
import com.dt.platform.domain.oa.meta.CrmCustomerVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 客户VO类型
 * <p>客户 , 数据表 oa_crm_customer 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-16 20:34:49
 * @sign A42C4365DD225C0C357D36DB82A861E9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "客户VO类型 ; 客户 , 数据表 oa_crm_customer 的通用VO类型" , parent = CrmCustomer.class)
public class CrmCustomerVO extends CrmCustomer {

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
	public CrmCustomerVO setPageIndex(Integer pageIndex) {
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
	public CrmCustomerVO setPageSize(Integer pageSize) {
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
	public CrmCustomerVO setSearchField(String searchField) {
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
	public CrmCustomerVO setFuzzyField(String fuzzyField) {
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
	public CrmCustomerVO setSearchValue(String searchValue) {
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
	public CrmCustomerVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public CrmCustomerVO addDirtyField(String... dirtyField) {
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
	public CrmCustomerVO setSortField(String sortField) {
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
	public CrmCustomerVO setSortType(String sortType) {
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
	public CrmCustomerVO setDataOrigin(String dataOrigin) {
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
	public CrmCustomerVO setQueryLogic(String queryLogic) {
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
	public CrmCustomerVO setRequestAction(String requestAction) {
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
	public CrmCustomerVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public CrmCustomerVO addId(String... id) {
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
	 * @return CrmCustomerVO , 转换好的 CrmCustomerVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CrmCustomerVO , 转换好的 PoJo 对象
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
	public CrmCustomerVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CrmCustomerVO duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.CrmCustomerVOMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.CrmCustomerVOMeta.$$proxy$$();
		inst.setSourceId(this.getSourceId());
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setContactInfo(this.getContactInfo());
		inst.setOwnerId(this.getOwnerId());
		inst.setIndustryId(this.getIndustryId());
		inst.setNextFollowTime(this.getNextFollowTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setLocked(this.getLocked());
		inst.setWebsite(this.getWebsite());
		inst.setAddress(this.getAddress());
		inst.setLevel(this.getLevel());
		inst.setIntentionalState(this.getIntentionalState());
		inst.setTransactionStatus(this.getTransactionStatus());
		inst.setProfile(this.getProfile());
		inst.setRecentFollowTime(this.getRecentFollowTime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setRolePos(this.getRolePos());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setContacts(this.getContacts());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setOriginator(this.getOriginator());
			inst.setCrmCustomerRecordList(this.getCrmCustomerRecordList());
			inst.setCrmCustomerFollowList(this.getCrmCustomerFollowList());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setCrmCustomerIntentional(this.getCrmCustomerIntentional());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setCrmCustomerLevel(this.getCrmCustomerLevel());
			inst.setOwner(this.getOwner());
			inst.setCrmCustomerReviewList(this.getCrmCustomerReviewList());
			inst.setRequestAction(this.getRequestAction());
			inst.setCrmCustomerSource(this.getCrmCustomerSource());
			inst.setCrmCustomerBusinessList(this.getCrmCustomerBusinessList());
			inst.setCrmCustomerIndustry(this.getCrmCustomerIndustry());
			inst.setCrmFirstCustomerContact(this.getCrmFirstCustomerContact());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setIds(this.getIds());
			inst.setSearchCustomerType(this.getSearchCustomerType());
			inst.setSearchValue(this.getSearchValue());
			inst.setCrmCustomerContactList(this.getCrmCustomerContactList());
			inst.setCrmCustomerLeaderList(this.getCrmCustomerLeaderList());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CrmCustomerVO clone(boolean deep) {
		return EntityContext.clone(CrmCustomerVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CrmCustomerVO
	 * @param crmCustomerMap 包含实体信息的 Map 对象
	 * @return CrmCustomerVO , 转换好的的 CrmCustomer 对象
	*/
	@Transient
	public static CrmCustomerVO createFrom(Map<String,Object> crmCustomerMap) {
		if(crmCustomerMap==null) return null;
		CrmCustomerVO vo = create();
		EntityContext.copyProperties(vo,crmCustomerMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 CrmCustomerVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CrmCustomerVO , 转换好的的 CrmCustomer 对象
	*/
	@Transient
	public static CrmCustomerVO createFrom(Object pojo) {
		if(pojo==null) return null;
		CrmCustomerVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 CrmCustomerVO，等同于 new
	 * @return CrmCustomerVO 对象
	*/
	@Transient
	public static CrmCustomerVO create() {
		return new com.dt.platform.domain.oa.meta.CrmCustomerVOMeta.$$proxy$$();
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
			this.setSourceId(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.SOURCE_ID)));
			this.setCode(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.NOTES)));
			this.setContactInfo(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.CONTACT_INFO)));
			this.setOwnerId(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.OWNER_ID)));
			this.setIndustryId(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.INDUSTRY_ID)));
			this.setNextFollowTime(DataParser.parse(Date.class, map.get(CrmCustomerVOMeta.NEXT_FOLLOW_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.ORIGINATOR_ID)));
			this.setLocked(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.LOCKED)));
			this.setWebsite(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.WEBSITE)));
			this.setAddress(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.ADDRESS)));
			this.setLevel(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.LEVEL)));
			this.setIntentionalState(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.INTENTIONAL_STATE)));
			this.setTransactionStatus(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.TRANSACTION_STATUS)));
			this.setProfile(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.PROFILE)));
			this.setRecentFollowTime(DataParser.parse(Date.class, map.get(CrmCustomerVOMeta.RECENT_FOLLOW_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CrmCustomerVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CrmCustomerVOMeta.VERSION)));
			this.setRolePos(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.ROLE_POS)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CrmCustomerVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CrmCustomerVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CrmCustomerVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.DELETE_BY)));
			this.setContacts(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.CONTACTS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(CrmCustomerVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(CrmCustomerVOMeta.ORIGINATOR)));
			this.setSortField(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.DATA_ORIGIN)));
			this.setCrmCustomerIntentional(DataParser.parse(CrmCustomerIntentional.class, map.get(CrmCustomerVOMeta.CRM_CUSTOMER_INTENTIONAL)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.QUERY_LOGIC)));
			this.setCrmCustomerLevel(DataParser.parse(CrmCustomerLevel.class, map.get(CrmCustomerVOMeta.CRM_CUSTOMER_LEVEL)));
			this.setOwner(DataParser.parse(Employee.class, map.get(CrmCustomerVOMeta.OWNER)));
			this.setRequestAction(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.REQUEST_ACTION)));
			this.setCrmCustomerSource(DataParser.parse(CrmCustomerSource.class, map.get(CrmCustomerVOMeta.CRM_CUSTOMER_SOURCE)));
			this.setCrmCustomerIndustry(DataParser.parse(CrmCustomerIndustry.class, map.get(CrmCustomerVOMeta.CRM_CUSTOMER_INDUSTRY)));
			this.setCrmFirstCustomerContact(DataParser.parse(CrmCustomerContact.class, map.get(CrmCustomerVOMeta.CRM_FIRST_CUSTOMER_CONTACT)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(CrmCustomerVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.SORT_TYPE)));
			this.setSearchCustomerType(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.SEARCH_CUSTOMER_TYPE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(CrmCustomerVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setSourceId( (String)map.get(CrmCustomerVOMeta.SOURCE_ID));
				this.setCode( (String)map.get(CrmCustomerVOMeta.CODE));
				this.setNotes( (String)map.get(CrmCustomerVOMeta.NOTES));
				this.setContactInfo( (String)map.get(CrmCustomerVOMeta.CONTACT_INFO));
				this.setOwnerId( (String)map.get(CrmCustomerVOMeta.OWNER_ID));
				this.setIndustryId( (String)map.get(CrmCustomerVOMeta.INDUSTRY_ID));
				this.setNextFollowTime( (Date)map.get(CrmCustomerVOMeta.NEXT_FOLLOW_TIME));
				this.setUpdateBy( (String)map.get(CrmCustomerVOMeta.UPDATE_BY));
				this.setId( (String)map.get(CrmCustomerVOMeta.ID));
				this.setOriginatorId( (String)map.get(CrmCustomerVOMeta.ORIGINATOR_ID));
				this.setLocked( (String)map.get(CrmCustomerVOMeta.LOCKED));
				this.setWebsite( (String)map.get(CrmCustomerVOMeta.WEBSITE));
				this.setAddress( (String)map.get(CrmCustomerVOMeta.ADDRESS));
				this.setLevel( (String)map.get(CrmCustomerVOMeta.LEVEL));
				this.setIntentionalState( (String)map.get(CrmCustomerVOMeta.INTENTIONAL_STATE));
				this.setTransactionStatus( (String)map.get(CrmCustomerVOMeta.TRANSACTION_STATUS));
				this.setProfile( (String)map.get(CrmCustomerVOMeta.PROFILE));
				this.setRecentFollowTime( (Date)map.get(CrmCustomerVOMeta.RECENT_FOLLOW_TIME));
				this.setUpdateTime( (Date)map.get(CrmCustomerVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(CrmCustomerVOMeta.VERSION));
				this.setRolePos( (String)map.get(CrmCustomerVOMeta.ROLE_POS));
				this.setCreateBy( (String)map.get(CrmCustomerVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CrmCustomerVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(CrmCustomerVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(CrmCustomerVOMeta.DELETE_TIME));
				this.setName( (String)map.get(CrmCustomerVOMeta.NAME));
				this.setTenantId( (String)map.get(CrmCustomerVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CrmCustomerVOMeta.DELETE_BY));
				this.setContacts( (String)map.get(CrmCustomerVOMeta.CONTACTS));
				// others
				this.setSearchField( (String)map.get(CrmCustomerVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(CrmCustomerVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(CrmCustomerVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(CrmCustomerVOMeta.ORIGINATOR));
				this.setSortField( (String)map.get(CrmCustomerVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(CrmCustomerVOMeta.DATA_ORIGIN));
				this.setCrmCustomerIntentional( (CrmCustomerIntentional)map.get(CrmCustomerVOMeta.CRM_CUSTOMER_INTENTIONAL));
				this.setQueryLogic( (String)map.get(CrmCustomerVOMeta.QUERY_LOGIC));
				this.setCrmCustomerLevel( (CrmCustomerLevel)map.get(CrmCustomerVOMeta.CRM_CUSTOMER_LEVEL));
				this.setOwner( (Employee)map.get(CrmCustomerVOMeta.OWNER));
				this.setRequestAction( (String)map.get(CrmCustomerVOMeta.REQUEST_ACTION));
				this.setCrmCustomerSource( (CrmCustomerSource)map.get(CrmCustomerVOMeta.CRM_CUSTOMER_SOURCE));
				this.setCrmCustomerIndustry( (CrmCustomerIndustry)map.get(CrmCustomerVOMeta.CRM_CUSTOMER_INDUSTRY));
				this.setCrmFirstCustomerContact( (CrmCustomerContact)map.get(CrmCustomerVOMeta.CRM_FIRST_CUSTOMER_CONTACT));
				this.setPageIndex( (Integer)map.get(CrmCustomerVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(CrmCustomerVOMeta.SORT_TYPE));
				this.setSearchCustomerType( (String)map.get(CrmCustomerVOMeta.SEARCH_CUSTOMER_TYPE));
				this.setSearchValue( (String)map.get(CrmCustomerVOMeta.SEARCH_VALUE));
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
			this.setSourceId(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.SOURCE_ID)));
			this.setCode(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.NOTES)));
			this.setContactInfo(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.CONTACT_INFO)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.OWNER_ID)));
			this.setIndustryId(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.INDUSTRY_ID)));
			this.setNextFollowTime(DataParser.parse(Date.class, r.getValue(CrmCustomerVOMeta.NEXT_FOLLOW_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.ORIGINATOR_ID)));
			this.setLocked(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.LOCKED)));
			this.setWebsite(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.WEBSITE)));
			this.setAddress(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.ADDRESS)));
			this.setLevel(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.LEVEL)));
			this.setIntentionalState(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.INTENTIONAL_STATE)));
			this.setTransactionStatus(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.TRANSACTION_STATUS)));
			this.setProfile(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.PROFILE)));
			this.setRecentFollowTime(DataParser.parse(Date.class, r.getValue(CrmCustomerVOMeta.RECENT_FOLLOW_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CrmCustomerVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CrmCustomerVOMeta.VERSION)));
			this.setRolePos(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.ROLE_POS)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CrmCustomerVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CrmCustomerVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CrmCustomerVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.DELETE_BY)));
			this.setContacts(DataParser.parse(String.class, r.getValue(CrmCustomerVOMeta.CONTACTS)));
			return true;
		} else {
			try {
				this.setSourceId( (String)r.getValue(CrmCustomerVOMeta.SOURCE_ID));
				this.setCode( (String)r.getValue(CrmCustomerVOMeta.CODE));
				this.setNotes( (String)r.getValue(CrmCustomerVOMeta.NOTES));
				this.setContactInfo( (String)r.getValue(CrmCustomerVOMeta.CONTACT_INFO));
				this.setOwnerId( (String)r.getValue(CrmCustomerVOMeta.OWNER_ID));
				this.setIndustryId( (String)r.getValue(CrmCustomerVOMeta.INDUSTRY_ID));
				this.setNextFollowTime( (Date)r.getValue(CrmCustomerVOMeta.NEXT_FOLLOW_TIME));
				this.setUpdateBy( (String)r.getValue(CrmCustomerVOMeta.UPDATE_BY));
				this.setId( (String)r.getValue(CrmCustomerVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(CrmCustomerVOMeta.ORIGINATOR_ID));
				this.setLocked( (String)r.getValue(CrmCustomerVOMeta.LOCKED));
				this.setWebsite( (String)r.getValue(CrmCustomerVOMeta.WEBSITE));
				this.setAddress( (String)r.getValue(CrmCustomerVOMeta.ADDRESS));
				this.setLevel( (String)r.getValue(CrmCustomerVOMeta.LEVEL));
				this.setIntentionalState( (String)r.getValue(CrmCustomerVOMeta.INTENTIONAL_STATE));
				this.setTransactionStatus( (String)r.getValue(CrmCustomerVOMeta.TRANSACTION_STATUS));
				this.setProfile( (String)r.getValue(CrmCustomerVOMeta.PROFILE));
				this.setRecentFollowTime( (Date)r.getValue(CrmCustomerVOMeta.RECENT_FOLLOW_TIME));
				this.setUpdateTime( (Date)r.getValue(CrmCustomerVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(CrmCustomerVOMeta.VERSION));
				this.setRolePos( (String)r.getValue(CrmCustomerVOMeta.ROLE_POS));
				this.setCreateBy( (String)r.getValue(CrmCustomerVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CrmCustomerVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CrmCustomerVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(CrmCustomerVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(CrmCustomerVOMeta.NAME));
				this.setTenantId( (String)r.getValue(CrmCustomerVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CrmCustomerVOMeta.DELETE_BY));
				this.setContacts( (String)r.getValue(CrmCustomerVOMeta.CONTACTS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}