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
import com.dt.platform.domain.oa.meta.CrmCustomerLeadsVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 线索VO类型
 * <p>线索 , 数据表 oa_crm_customer_leads 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-16 20:35:14
 * @sign 8230526D2B410302D9567131B0092D9C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "线索VO类型 ; 线索 , 数据表 oa_crm_customer_leads 的通用VO类型" , parent = CrmCustomerLeads.class)
public class CrmCustomerLeadsVO extends CrmCustomerLeads {

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
	public CrmCustomerLeadsVO setPageIndex(Integer pageIndex) {
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
	public CrmCustomerLeadsVO setPageSize(Integer pageSize) {
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
	public CrmCustomerLeadsVO setSearchField(String searchField) {
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
	public CrmCustomerLeadsVO setFuzzyField(String fuzzyField) {
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
	public CrmCustomerLeadsVO setSearchValue(String searchValue) {
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
	public CrmCustomerLeadsVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public CrmCustomerLeadsVO addDirtyField(String... dirtyField) {
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
	public CrmCustomerLeadsVO setSortField(String sortField) {
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
	public CrmCustomerLeadsVO setSortType(String sortType) {
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
	public CrmCustomerLeadsVO setDataOrigin(String dataOrigin) {
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
	public CrmCustomerLeadsVO setQueryLogic(String queryLogic) {
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
	public CrmCustomerLeadsVO setRequestAction(String requestAction) {
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
	public CrmCustomerLeadsVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public CrmCustomerLeadsVO addId(String... id) {
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
	 * @return CrmCustomerLeadsVO , 转换好的 CrmCustomerLeadsVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CrmCustomerLeadsVO , 转换好的 PoJo 对象
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
	public CrmCustomerLeadsVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CrmCustomerLeadsVO duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.CrmCustomerLeadsVOMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.CrmCustomerLeadsVOMeta.$$proxy$$();
		inst.setSourceId(this.getSourceId());
		inst.setWebsite(this.getWebsite());
		inst.setAddress(this.getAddress());
		inst.setNotes(this.getNotes());
		inst.setContactInfo(this.getContactInfo());
		inst.setLevel(this.getLevel());
		inst.setIntentionalState(this.getIntentionalState());
		inst.setRecentFollowTime(this.getRecentFollowTime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setOwnerId(this.getOwnerId());
		inst.setVersion(this.getVersion());
		inst.setIndustryId(this.getIndustryId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setNextFollowTime(this.getNextFollowTime());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setContacts(this.getContacts());
		if(all) {
			inst.setOwner(this.getOwner());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setOriginator(this.getOriginator());
			inst.setCrmCustomerSource(this.getCrmCustomerSource());
			inst.setCrmCustomerIndustry(this.getCrmCustomerIndustry());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setCrmCustomer(this.getCrmCustomer());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setCrmCustomerIntentional(this.getCrmCustomerIntentional());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setCrmCustomerLevel(this.getCrmCustomerLevel());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CrmCustomerLeadsVO clone(boolean deep) {
		return EntityContext.clone(CrmCustomerLeadsVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CrmCustomerLeadsVO
	 * @param crmCustomerLeadsMap 包含实体信息的 Map 对象
	 * @return CrmCustomerLeadsVO , 转换好的的 CrmCustomerLeads 对象
	*/
	@Transient
	public static CrmCustomerLeadsVO createFrom(Map<String,Object> crmCustomerLeadsMap) {
		if(crmCustomerLeadsMap==null) return null;
		CrmCustomerLeadsVO vo = create();
		EntityContext.copyProperties(vo,crmCustomerLeadsMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 CrmCustomerLeadsVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CrmCustomerLeadsVO , 转换好的的 CrmCustomerLeads 对象
	*/
	@Transient
	public static CrmCustomerLeadsVO createFrom(Object pojo) {
		if(pojo==null) return null;
		CrmCustomerLeadsVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 CrmCustomerLeadsVO，等同于 new
	 * @return CrmCustomerLeadsVO 对象
	*/
	@Transient
	public static CrmCustomerLeadsVO create() {
		return new com.dt.platform.domain.oa.meta.CrmCustomerLeadsVOMeta.$$proxy$$();
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
			this.setSourceId(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.SOURCE_ID)));
			this.setWebsite(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.WEBSITE)));
			this.setAddress(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.ADDRESS)));
			this.setNotes(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.NOTES)));
			this.setContactInfo(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.CONTACT_INFO)));
			this.setLevel(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.LEVEL)));
			this.setIntentionalState(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.INTENTIONAL_STATE)));
			this.setRecentFollowTime(DataParser.parse(Date.class, map.get(CrmCustomerLeadsVOMeta.RECENT_FOLLOW_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CrmCustomerLeadsVOMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CrmCustomerLeadsVOMeta.VERSION)));
			this.setIndustryId(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.INDUSTRY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CrmCustomerLeadsVOMeta.DELETED)));
			this.setNextFollowTime(DataParser.parse(Date.class, map.get(CrmCustomerLeadsVOMeta.NEXT_FOLLOW_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CrmCustomerLeadsVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CrmCustomerLeadsVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.ORIGINATOR_ID)));
			this.setContacts(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.CONTACTS)));
			// others
			this.setOwner(DataParser.parse(Employee.class, map.get(CrmCustomerLeadsVOMeta.OWNER)));
			this.setSearchField(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(CrmCustomerLeadsVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(CrmCustomerLeadsVOMeta.ORIGINATOR)));
			this.setCrmCustomerSource(DataParser.parse(CrmCustomerSource.class, map.get(CrmCustomerLeadsVOMeta.CRM_CUSTOMER_SOURCE)));
			this.setCrmCustomerIndustry(DataParser.parse(CrmCustomerIndustry.class, map.get(CrmCustomerLeadsVOMeta.CRM_CUSTOMER_INDUSTRY)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(CrmCustomerLeadsVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.SORT_TYPE)));
			this.setCrmCustomer(DataParser.parse(CrmCustomer.class, map.get(CrmCustomerLeadsVOMeta.CRM_CUSTOMER)));
			this.setSortField(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.DATA_ORIGIN)));
			this.setCrmCustomerIntentional(DataParser.parse(CrmCustomerIntentional.class, map.get(CrmCustomerLeadsVOMeta.CRM_CUSTOMER_INTENTIONAL)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.QUERY_LOGIC)));
			this.setCrmCustomerLevel(DataParser.parse(CrmCustomerLevel.class, map.get(CrmCustomerLeadsVOMeta.CRM_CUSTOMER_LEVEL)));
			this.setSearchValue(DataParser.parse(String.class, map.get(CrmCustomerLeadsVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setSourceId( (String)map.get(CrmCustomerLeadsVOMeta.SOURCE_ID));
				this.setWebsite( (String)map.get(CrmCustomerLeadsVOMeta.WEBSITE));
				this.setAddress( (String)map.get(CrmCustomerLeadsVOMeta.ADDRESS));
				this.setNotes( (String)map.get(CrmCustomerLeadsVOMeta.NOTES));
				this.setContactInfo( (String)map.get(CrmCustomerLeadsVOMeta.CONTACT_INFO));
				this.setLevel( (String)map.get(CrmCustomerLeadsVOMeta.LEVEL));
				this.setIntentionalState( (String)map.get(CrmCustomerLeadsVOMeta.INTENTIONAL_STATE));
				this.setRecentFollowTime( (Date)map.get(CrmCustomerLeadsVOMeta.RECENT_FOLLOW_TIME));
				this.setUpdateTime( (Date)map.get(CrmCustomerLeadsVOMeta.UPDATE_TIME));
				this.setOwnerId( (String)map.get(CrmCustomerLeadsVOMeta.OWNER_ID));
				this.setVersion( (Integer)map.get(CrmCustomerLeadsVOMeta.VERSION));
				this.setIndustryId( (String)map.get(CrmCustomerLeadsVOMeta.INDUSTRY_ID));
				this.setCreateBy( (String)map.get(CrmCustomerLeadsVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CrmCustomerLeadsVOMeta.DELETED));
				this.setNextFollowTime( (Date)map.get(CrmCustomerLeadsVOMeta.NEXT_FOLLOW_TIME));
				this.setCreateTime( (Date)map.get(CrmCustomerLeadsVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CrmCustomerLeadsVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CrmCustomerLeadsVOMeta.DELETE_TIME));
				this.setName( (String)map.get(CrmCustomerLeadsVOMeta.NAME));
				this.setTenantId( (String)map.get(CrmCustomerLeadsVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CrmCustomerLeadsVOMeta.DELETE_BY));
				this.setId( (String)map.get(CrmCustomerLeadsVOMeta.ID));
				this.setOriginatorId( (String)map.get(CrmCustomerLeadsVOMeta.ORIGINATOR_ID));
				this.setContacts( (String)map.get(CrmCustomerLeadsVOMeta.CONTACTS));
				// others
				this.setOwner( (Employee)map.get(CrmCustomerLeadsVOMeta.OWNER));
				this.setSearchField( (String)map.get(CrmCustomerLeadsVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(CrmCustomerLeadsVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(CrmCustomerLeadsVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(CrmCustomerLeadsVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(CrmCustomerLeadsVOMeta.ORIGINATOR));
				this.setCrmCustomerSource( (CrmCustomerSource)map.get(CrmCustomerLeadsVOMeta.CRM_CUSTOMER_SOURCE));
				this.setCrmCustomerIndustry( (CrmCustomerIndustry)map.get(CrmCustomerLeadsVOMeta.CRM_CUSTOMER_INDUSTRY));
				this.setPageIndex( (Integer)map.get(CrmCustomerLeadsVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(CrmCustomerLeadsVOMeta.SORT_TYPE));
				this.setCrmCustomer( (CrmCustomer)map.get(CrmCustomerLeadsVOMeta.CRM_CUSTOMER));
				this.setSortField( (String)map.get(CrmCustomerLeadsVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(CrmCustomerLeadsVOMeta.DATA_ORIGIN));
				this.setCrmCustomerIntentional( (CrmCustomerIntentional)map.get(CrmCustomerLeadsVOMeta.CRM_CUSTOMER_INTENTIONAL));
				this.setQueryLogic( (String)map.get(CrmCustomerLeadsVOMeta.QUERY_LOGIC));
				this.setCrmCustomerLevel( (CrmCustomerLevel)map.get(CrmCustomerLeadsVOMeta.CRM_CUSTOMER_LEVEL));
				this.setSearchValue( (String)map.get(CrmCustomerLeadsVOMeta.SEARCH_VALUE));
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
			this.setSourceId(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsVOMeta.SOURCE_ID)));
			this.setWebsite(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsVOMeta.WEBSITE)));
			this.setAddress(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsVOMeta.ADDRESS)));
			this.setNotes(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsVOMeta.NOTES)));
			this.setContactInfo(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsVOMeta.CONTACT_INFO)));
			this.setLevel(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsVOMeta.LEVEL)));
			this.setIntentionalState(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsVOMeta.INTENTIONAL_STATE)));
			this.setRecentFollowTime(DataParser.parse(Date.class, r.getValue(CrmCustomerLeadsVOMeta.RECENT_FOLLOW_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CrmCustomerLeadsVOMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsVOMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CrmCustomerLeadsVOMeta.VERSION)));
			this.setIndustryId(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsVOMeta.INDUSTRY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CrmCustomerLeadsVOMeta.DELETED)));
			this.setNextFollowTime(DataParser.parse(Date.class, r.getValue(CrmCustomerLeadsVOMeta.NEXT_FOLLOW_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CrmCustomerLeadsVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CrmCustomerLeadsVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsVOMeta.ORIGINATOR_ID)));
			this.setContacts(DataParser.parse(String.class, r.getValue(CrmCustomerLeadsVOMeta.CONTACTS)));
			return true;
		} else {
			try {
				this.setSourceId( (String)r.getValue(CrmCustomerLeadsVOMeta.SOURCE_ID));
				this.setWebsite( (String)r.getValue(CrmCustomerLeadsVOMeta.WEBSITE));
				this.setAddress( (String)r.getValue(CrmCustomerLeadsVOMeta.ADDRESS));
				this.setNotes( (String)r.getValue(CrmCustomerLeadsVOMeta.NOTES));
				this.setContactInfo( (String)r.getValue(CrmCustomerLeadsVOMeta.CONTACT_INFO));
				this.setLevel( (String)r.getValue(CrmCustomerLeadsVOMeta.LEVEL));
				this.setIntentionalState( (String)r.getValue(CrmCustomerLeadsVOMeta.INTENTIONAL_STATE));
				this.setRecentFollowTime( (Date)r.getValue(CrmCustomerLeadsVOMeta.RECENT_FOLLOW_TIME));
				this.setUpdateTime( (Date)r.getValue(CrmCustomerLeadsVOMeta.UPDATE_TIME));
				this.setOwnerId( (String)r.getValue(CrmCustomerLeadsVOMeta.OWNER_ID));
				this.setVersion( (Integer)r.getValue(CrmCustomerLeadsVOMeta.VERSION));
				this.setIndustryId( (String)r.getValue(CrmCustomerLeadsVOMeta.INDUSTRY_ID));
				this.setCreateBy( (String)r.getValue(CrmCustomerLeadsVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CrmCustomerLeadsVOMeta.DELETED));
				this.setNextFollowTime( (Date)r.getValue(CrmCustomerLeadsVOMeta.NEXT_FOLLOW_TIME));
				this.setCreateTime( (Date)r.getValue(CrmCustomerLeadsVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CrmCustomerLeadsVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CrmCustomerLeadsVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(CrmCustomerLeadsVOMeta.NAME));
				this.setTenantId( (String)r.getValue(CrmCustomerLeadsVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CrmCustomerLeadsVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(CrmCustomerLeadsVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(CrmCustomerLeadsVOMeta.ORIGINATOR_ID));
				this.setContacts( (String)r.getValue(CrmCustomerLeadsVOMeta.CONTACTS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}