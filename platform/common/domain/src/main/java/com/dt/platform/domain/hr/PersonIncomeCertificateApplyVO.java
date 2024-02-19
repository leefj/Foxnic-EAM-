package com.dt.platform.domain.hr;

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
import com.dt.platform.domain.hr.meta.PersonIncomeCertificateApplyVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 收入证明申请VO类型
 * <p>收入证明申请 , 数据表 hr_person_income_certificate_apply 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-19 20:14:36
 * @sign 2A5F4EF1FFEC3D62D29458EA41555887
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "收入证明申请VO类型 ; 收入证明申请 , 数据表 hr_person_income_certificate_apply 的通用VO类型" , parent = PersonIncomeCertificateApply.class)
public class PersonIncomeCertificateApplyVO extends PersonIncomeCertificateApply {

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
	public PersonIncomeCertificateApplyVO setPageIndex(Integer pageIndex) {
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
	public PersonIncomeCertificateApplyVO setPageSize(Integer pageSize) {
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
	public PersonIncomeCertificateApplyVO setSearchField(String searchField) {
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
	public PersonIncomeCertificateApplyVO setFuzzyField(String fuzzyField) {
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
	public PersonIncomeCertificateApplyVO setSearchValue(String searchValue) {
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
	public PersonIncomeCertificateApplyVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public PersonIncomeCertificateApplyVO addDirtyField(String... dirtyField) {
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
	public PersonIncomeCertificateApplyVO setSortField(String sortField) {
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
	public PersonIncomeCertificateApplyVO setSortType(String sortType) {
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
	public PersonIncomeCertificateApplyVO setDataOrigin(String dataOrigin) {
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
	public PersonIncomeCertificateApplyVO setQueryLogic(String queryLogic) {
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
	public PersonIncomeCertificateApplyVO setRequestAction(String requestAction) {
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
	public PersonIncomeCertificateApplyVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public PersonIncomeCertificateApplyVO addId(String... id) {
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
	 * @return PersonIncomeCertificateApplyVO , 转换好的 PersonIncomeCertificateApplyVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonIncomeCertificateApplyVO , 转换好的 PoJo 对象
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
	public PersonIncomeCertificateApplyVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonIncomeCertificateApplyVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonIncomeCertificateApplyVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonIncomeCertificateApplyVOMeta.$$proxy$$();
		inst.setNote(this.getNote());
		inst.setPeriod(this.getPeriod());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setOrgId(this.getOrgId());
		inst.setContent(this.getContent());
		inst.setConfirmDate(this.getConfirmDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setId(this.getId());
		inst.setCard(this.getCard());
		inst.setStatus(this.getStatus());
		inst.setFileId(this.getFileId());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setHistoricProcessList(this.getHistoricProcessList());
			inst.setCurrentProcessList(this.getCurrentProcessList());
			inst.setDefaultProcess(this.getDefaultProcess());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setPerson(this.getPerson());
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
	public PersonIncomeCertificateApplyVO clone(boolean deep) {
		return EntityContext.clone(PersonIncomeCertificateApplyVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonIncomeCertificateApplyVO
	 * @param personIncomeCertificateApplyMap 包含实体信息的 Map 对象
	 * @return PersonIncomeCertificateApplyVO , 转换好的的 PersonIncomeCertificateApply 对象
	*/
	@Transient
	public static PersonIncomeCertificateApplyVO createFrom(Map<String,Object> personIncomeCertificateApplyMap) {
		if(personIncomeCertificateApplyMap==null) return null;
		PersonIncomeCertificateApplyVO vo = create();
		EntityContext.copyProperties(vo,personIncomeCertificateApplyMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 PersonIncomeCertificateApplyVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonIncomeCertificateApplyVO , 转换好的的 PersonIncomeCertificateApply 对象
	*/
	@Transient
	public static PersonIncomeCertificateApplyVO createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonIncomeCertificateApplyVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 PersonIncomeCertificateApplyVO，等同于 new
	 * @return PersonIncomeCertificateApplyVO 对象
	*/
	@Transient
	public static PersonIncomeCertificateApplyVO create() {
		return new com.dt.platform.domain.hr.meta.PersonIncomeCertificateApplyVOMeta.$$proxy$$();
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
			this.setNote(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.NOTE)));
			this.setPeriod(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.PERIOD)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonIncomeCertificateApplyVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonIncomeCertificateApplyVOMeta.VERSION)));
			this.setOrgId(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.ORG_ID)));
			this.setContent(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.CONTENT)));
			this.setConfirmDate(DataParser.parse(Date.class, map.get(PersonIncomeCertificateApplyVOMeta.CONFIRM_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonIncomeCertificateApplyVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonIncomeCertificateApplyVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonIncomeCertificateApplyVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.ID)));
			this.setCard(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.CARD)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.STATUS)));
			this.setFileId(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.FILE_ID)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(PersonIncomeCertificateApplyVOMeta.PAGE_SIZE)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(PersonIncomeCertificateApplyVOMeta.DEFAULT_PROCESS)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(PersonIncomeCertificateApplyVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.SORT_TYPE)));
			this.setPerson(DataParser.parse(Employee.class, map.get(PersonIncomeCertificateApplyVOMeta.PERSON)));
			this.setOrganization(DataParser.parse(Organization.class, map.get(PersonIncomeCertificateApplyVOMeta.ORGANIZATION)));
			this.setSortField(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNote( (String)map.get(PersonIncomeCertificateApplyVOMeta.NOTE));
				this.setPeriod( (String)map.get(PersonIncomeCertificateApplyVOMeta.PERIOD));
				this.setUpdateTime( (Date)map.get(PersonIncomeCertificateApplyVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PersonIncomeCertificateApplyVOMeta.VERSION));
				this.setOrgId( (String)map.get(PersonIncomeCertificateApplyVOMeta.ORG_ID));
				this.setContent( (String)map.get(PersonIncomeCertificateApplyVOMeta.CONTENT));
				this.setConfirmDate( (Date)map.get(PersonIncomeCertificateApplyVOMeta.CONFIRM_DATE));
				this.setBusinessCode( (String)map.get(PersonIncomeCertificateApplyVOMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(PersonIncomeCertificateApplyVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonIncomeCertificateApplyVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(PersonIncomeCertificateApplyVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonIncomeCertificateApplyVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonIncomeCertificateApplyVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(PersonIncomeCertificateApplyVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonIncomeCertificateApplyVOMeta.DELETE_BY));
				this.setPersonId( (String)map.get(PersonIncomeCertificateApplyVOMeta.PERSON_ID));
				this.setId( (String)map.get(PersonIncomeCertificateApplyVOMeta.ID));
				this.setCard( (String)map.get(PersonIncomeCertificateApplyVOMeta.CARD));
				this.setStatus( (String)map.get(PersonIncomeCertificateApplyVOMeta.STATUS));
				this.setFileId( (String)map.get(PersonIncomeCertificateApplyVOMeta.FILE_ID));
				// others
				this.setSearchField( (String)map.get(PersonIncomeCertificateApplyVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(PersonIncomeCertificateApplyVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(PersonIncomeCertificateApplyVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(PersonIncomeCertificateApplyVOMeta.PAGE_SIZE));
				this.setDefaultProcess( (ProcessInstance)map.get(PersonIncomeCertificateApplyVOMeta.DEFAULT_PROCESS));
				this.setPageIndex( (Integer)map.get(PersonIncomeCertificateApplyVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(PersonIncomeCertificateApplyVOMeta.SORT_TYPE));
				this.setPerson( (Employee)map.get(PersonIncomeCertificateApplyVOMeta.PERSON));
				this.setOrganization( (Organization)map.get(PersonIncomeCertificateApplyVOMeta.ORGANIZATION));
				this.setSortField( (String)map.get(PersonIncomeCertificateApplyVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(PersonIncomeCertificateApplyVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(PersonIncomeCertificateApplyVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(PersonIncomeCertificateApplyVOMeta.SEARCH_VALUE));
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
			this.setNote(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyVOMeta.NOTE)));
			this.setPeriod(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyVOMeta.PERIOD)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonIncomeCertificateApplyVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonIncomeCertificateApplyVOMeta.VERSION)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyVOMeta.ORG_ID)));
			this.setContent(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyVOMeta.CONTENT)));
			this.setConfirmDate(DataParser.parse(Date.class, r.getValue(PersonIncomeCertificateApplyVOMeta.CONFIRM_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyVOMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonIncomeCertificateApplyVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonIncomeCertificateApplyVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonIncomeCertificateApplyVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyVOMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyVOMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyVOMeta.ID)));
			this.setCard(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyVOMeta.CARD)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyVOMeta.STATUS)));
			this.setFileId(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyVOMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setNote( (String)r.getValue(PersonIncomeCertificateApplyVOMeta.NOTE));
				this.setPeriod( (String)r.getValue(PersonIncomeCertificateApplyVOMeta.PERIOD));
				this.setUpdateTime( (Date)r.getValue(PersonIncomeCertificateApplyVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PersonIncomeCertificateApplyVOMeta.VERSION));
				this.setOrgId( (String)r.getValue(PersonIncomeCertificateApplyVOMeta.ORG_ID));
				this.setContent( (String)r.getValue(PersonIncomeCertificateApplyVOMeta.CONTENT));
				this.setConfirmDate( (Date)r.getValue(PersonIncomeCertificateApplyVOMeta.CONFIRM_DATE));
				this.setBusinessCode( (String)r.getValue(PersonIncomeCertificateApplyVOMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(PersonIncomeCertificateApplyVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonIncomeCertificateApplyVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PersonIncomeCertificateApplyVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonIncomeCertificateApplyVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonIncomeCertificateApplyVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(PersonIncomeCertificateApplyVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonIncomeCertificateApplyVOMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(PersonIncomeCertificateApplyVOMeta.PERSON_ID));
				this.setId( (String)r.getValue(PersonIncomeCertificateApplyVOMeta.ID));
				this.setCard( (String)r.getValue(PersonIncomeCertificateApplyVOMeta.CARD));
				this.setStatus( (String)r.getValue(PersonIncomeCertificateApplyVOMeta.STATUS));
				this.setFileId( (String)r.getValue(PersonIncomeCertificateApplyVOMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}