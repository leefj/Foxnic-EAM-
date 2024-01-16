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
import com.dt.platform.domain.hr.meta.PersonSocialRelationVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 社会关系VO类型
 * <p>社会关系 , 数据表 hr_person_social_relation 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-16 12:47:26
 * @sign 323A8CB89250BD47856698ED55DA6E27
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "社会关系VO类型 ; 社会关系 , 数据表 hr_person_social_relation 的通用VO类型" , parent = PersonSocialRelation.class)
public class PersonSocialRelationVO extends PersonSocialRelation {

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
	public PersonSocialRelationVO setPageIndex(Integer pageIndex) {
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
	public PersonSocialRelationVO setPageSize(Integer pageSize) {
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
	public PersonSocialRelationVO setSearchField(String searchField) {
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
	public PersonSocialRelationVO setFuzzyField(String fuzzyField) {
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
	public PersonSocialRelationVO setSearchValue(String searchValue) {
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
	public PersonSocialRelationVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public PersonSocialRelationVO addDirtyField(String... dirtyField) {
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
	public PersonSocialRelationVO setSortField(String sortField) {
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
	public PersonSocialRelationVO setSortType(String sortType) {
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
	public PersonSocialRelationVO setDataOrigin(String dataOrigin) {
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
	public PersonSocialRelationVO setQueryLogic(String queryLogic) {
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
	public PersonSocialRelationVO setRequestAction(String requestAction) {
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
	public PersonSocialRelationVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public PersonSocialRelationVO addId(String... id) {
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
	 * @return PersonSocialRelationVO , 转换好的 PersonSocialRelationVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonSocialRelationVO , 转换好的 PoJo 对象
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
	public PersonSocialRelationVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonSocialRelationVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonSocialRelationVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonSocialRelationVOMeta.$$proxy$$();
		inst.setRelId(this.getRelId());
		inst.setNotes(this.getNotes());
		inst.setEmergencyContact(this.getEmergencyContact());
		inst.setEmployeeId(this.getEmployeeId());
		inst.setRelType(this.getRelType());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setConcat(this.getConcat());
		inst.setVersion(this.getVersion());
		inst.setWorkCompany(this.getWorkCompany());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setRel(this.getRel());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setRole(this.getRole());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setSocialRelationType(this.getSocialRelationType());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setPerson(this.getPerson());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSocialRelation(this.getSocialRelation());
			inst.setUser(this.getUser());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonSocialRelationVO clone(boolean deep) {
		return EntityContext.clone(PersonSocialRelationVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonSocialRelationVO
	 * @param personSocialRelationMap 包含实体信息的 Map 对象
	 * @return PersonSocialRelationVO , 转换好的的 PersonSocialRelation 对象
	*/
	@Transient
	public static PersonSocialRelationVO createFrom(Map<String,Object> personSocialRelationMap) {
		if(personSocialRelationMap==null) return null;
		PersonSocialRelationVO vo = create();
		EntityContext.copyProperties(vo,personSocialRelationMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 PersonSocialRelationVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonSocialRelationVO , 转换好的的 PersonSocialRelation 对象
	*/
	@Transient
	public static PersonSocialRelationVO createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonSocialRelationVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 PersonSocialRelationVO，等同于 new
	 * @return PersonSocialRelationVO 对象
	*/
	@Transient
	public static PersonSocialRelationVO create() {
		return new com.dt.platform.domain.hr.meta.PersonSocialRelationVOMeta.$$proxy$$();
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
			this.setRelId(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.REL_ID)));
			this.setNotes(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.NOTES)));
			this.setEmergencyContact(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.EMERGENCY_CONTACT)));
			this.setEmployeeId(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.EMPLOYEE_ID)));
			this.setRelType(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.REL_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonSocialRelationVOMeta.UPDATE_TIME)));
			this.setConcat(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.CONCAT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonSocialRelationVOMeta.VERSION)));
			this.setWorkCompany(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.WORK_COMPANY)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonSocialRelationVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonSocialRelationVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonSocialRelationVOMeta.DELETE_TIME)));
			this.setRel(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.REL)));
			this.setName(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.STATUS)));
			// others
			this.setRole(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.ROLE)));
			this.setSearchField(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(PersonSocialRelationVOMeta.PAGE_SIZE)));
			this.setSocialRelationType(DataParser.parse(DictItem.class, map.get(PersonSocialRelationVOMeta.SOCIAL_RELATION_TYPE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(PersonSocialRelationVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.SORT_TYPE)));
			this.setPerson(DataParser.parse(Employee.class, map.get(PersonSocialRelationVOMeta.PERSON)));
			this.setSortField(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.QUERY_LOGIC)));
			this.setSocialRelation(DataParser.parse(DictItem.class, map.get(PersonSocialRelationVOMeta.SOCIAL_RELATION)));
			this.setUser(DataParser.parse(Person.class, map.get(PersonSocialRelationVOMeta.USER)));
			this.setSearchValue(DataParser.parse(String.class, map.get(PersonSocialRelationVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setRelId( (String)map.get(PersonSocialRelationVOMeta.REL_ID));
				this.setNotes( (String)map.get(PersonSocialRelationVOMeta.NOTES));
				this.setEmergencyContact( (String)map.get(PersonSocialRelationVOMeta.EMERGENCY_CONTACT));
				this.setEmployeeId( (String)map.get(PersonSocialRelationVOMeta.EMPLOYEE_ID));
				this.setRelType( (String)map.get(PersonSocialRelationVOMeta.REL_TYPE));
				this.setUpdateTime( (Date)map.get(PersonSocialRelationVOMeta.UPDATE_TIME));
				this.setConcat( (String)map.get(PersonSocialRelationVOMeta.CONCAT));
				this.setVersion( (Integer)map.get(PersonSocialRelationVOMeta.VERSION));
				this.setWorkCompany( (String)map.get(PersonSocialRelationVOMeta.WORK_COMPANY));
				this.setCreateBy( (String)map.get(PersonSocialRelationVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonSocialRelationVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(PersonSocialRelationVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonSocialRelationVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonSocialRelationVOMeta.DELETE_TIME));
				this.setRel( (String)map.get(PersonSocialRelationVOMeta.REL));
				this.setName( (String)map.get(PersonSocialRelationVOMeta.NAME));
				this.setTenantId( (String)map.get(PersonSocialRelationVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonSocialRelationVOMeta.DELETE_BY));
				this.setPersonId( (String)map.get(PersonSocialRelationVOMeta.PERSON_ID));
				this.setId( (String)map.get(PersonSocialRelationVOMeta.ID));
				this.setStatus( (String)map.get(PersonSocialRelationVOMeta.STATUS));
				// others
				this.setRole( (String)map.get(PersonSocialRelationVOMeta.ROLE));
				this.setSearchField( (String)map.get(PersonSocialRelationVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(PersonSocialRelationVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(PersonSocialRelationVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(PersonSocialRelationVOMeta.PAGE_SIZE));
				this.setSocialRelationType( (DictItem)map.get(PersonSocialRelationVOMeta.SOCIAL_RELATION_TYPE));
				this.setPageIndex( (Integer)map.get(PersonSocialRelationVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(PersonSocialRelationVOMeta.SORT_TYPE));
				this.setPerson( (Employee)map.get(PersonSocialRelationVOMeta.PERSON));
				this.setSortField( (String)map.get(PersonSocialRelationVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(PersonSocialRelationVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(PersonSocialRelationVOMeta.QUERY_LOGIC));
				this.setSocialRelation( (DictItem)map.get(PersonSocialRelationVOMeta.SOCIAL_RELATION));
				this.setUser( (Person)map.get(PersonSocialRelationVOMeta.USER));
				this.setSearchValue( (String)map.get(PersonSocialRelationVOMeta.SEARCH_VALUE));
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
			this.setRelId(DataParser.parse(String.class, r.getValue(PersonSocialRelationVOMeta.REL_ID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(PersonSocialRelationVOMeta.NOTES)));
			this.setEmergencyContact(DataParser.parse(String.class, r.getValue(PersonSocialRelationVOMeta.EMERGENCY_CONTACT)));
			this.setEmployeeId(DataParser.parse(String.class, r.getValue(PersonSocialRelationVOMeta.EMPLOYEE_ID)));
			this.setRelType(DataParser.parse(String.class, r.getValue(PersonSocialRelationVOMeta.REL_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonSocialRelationVOMeta.UPDATE_TIME)));
			this.setConcat(DataParser.parse(String.class, r.getValue(PersonSocialRelationVOMeta.CONCAT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonSocialRelationVOMeta.VERSION)));
			this.setWorkCompany(DataParser.parse(String.class, r.getValue(PersonSocialRelationVOMeta.WORK_COMPANY)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonSocialRelationVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonSocialRelationVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonSocialRelationVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonSocialRelationVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonSocialRelationVOMeta.DELETE_TIME)));
			this.setRel(DataParser.parse(String.class, r.getValue(PersonSocialRelationVOMeta.REL)));
			this.setName(DataParser.parse(String.class, r.getValue(PersonSocialRelationVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonSocialRelationVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonSocialRelationVOMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(PersonSocialRelationVOMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonSocialRelationVOMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonSocialRelationVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setRelId( (String)r.getValue(PersonSocialRelationVOMeta.REL_ID));
				this.setNotes( (String)r.getValue(PersonSocialRelationVOMeta.NOTES));
				this.setEmergencyContact( (String)r.getValue(PersonSocialRelationVOMeta.EMERGENCY_CONTACT));
				this.setEmployeeId( (String)r.getValue(PersonSocialRelationVOMeta.EMPLOYEE_ID));
				this.setRelType( (String)r.getValue(PersonSocialRelationVOMeta.REL_TYPE));
				this.setUpdateTime( (Date)r.getValue(PersonSocialRelationVOMeta.UPDATE_TIME));
				this.setConcat( (String)r.getValue(PersonSocialRelationVOMeta.CONCAT));
				this.setVersion( (Integer)r.getValue(PersonSocialRelationVOMeta.VERSION));
				this.setWorkCompany( (String)r.getValue(PersonSocialRelationVOMeta.WORK_COMPANY));
				this.setCreateBy( (String)r.getValue(PersonSocialRelationVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonSocialRelationVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PersonSocialRelationVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonSocialRelationVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonSocialRelationVOMeta.DELETE_TIME));
				this.setRel( (String)r.getValue(PersonSocialRelationVOMeta.REL));
				this.setName( (String)r.getValue(PersonSocialRelationVOMeta.NAME));
				this.setTenantId( (String)r.getValue(PersonSocialRelationVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonSocialRelationVOMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(PersonSocialRelationVOMeta.PERSON_ID));
				this.setId( (String)r.getValue(PersonSocialRelationVOMeta.ID));
				this.setStatus( (String)r.getValue(PersonSocialRelationVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}