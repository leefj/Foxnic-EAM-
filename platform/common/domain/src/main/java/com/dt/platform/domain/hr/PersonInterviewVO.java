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
import com.dt.platform.domain.hr.meta.PersonInterviewVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Organization;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 初选人员VO类型
 * <p>初选人员 , 数据表 hr_person_interview 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-20 13:28:40
 * @sign DD52D0570F0BB8012176C70596BE4ACA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "初选人员VO类型 ; 初选人员 , 数据表 hr_person_interview 的通用VO类型" , parent = PersonInterview.class)
public class PersonInterviewVO extends PersonInterview {

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
	public PersonInterviewVO setPageIndex(Integer pageIndex) {
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
	public PersonInterviewVO setPageSize(Integer pageSize) {
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
	public PersonInterviewVO setSearchField(String searchField) {
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
	public PersonInterviewVO setFuzzyField(String fuzzyField) {
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
	public PersonInterviewVO setSearchValue(String searchValue) {
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
	public PersonInterviewVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public PersonInterviewVO addDirtyField(String... dirtyField) {
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
	public PersonInterviewVO setSortField(String sortField) {
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
	public PersonInterviewVO setSortType(String sortType) {
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
	public PersonInterviewVO setDataOrigin(String dataOrigin) {
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
	public PersonInterviewVO setQueryLogic(String queryLogic) {
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
	public PersonInterviewVO setRequestAction(String requestAction) {
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
	public PersonInterviewVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public PersonInterviewVO addId(String... id) {
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
	 * @return PersonInterviewVO , 转换好的 PersonInterviewVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonInterviewVO , 转换好的 PoJo 对象
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
	public PersonInterviewVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonInterviewVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonInterviewVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonInterviewVOMeta.$$proxy$$();
		inst.setBirthday(this.getBirthday());
		inst.setNotes(this.getNotes());
		inst.setInterviewMethod(this.getInterviewMethod());
		inst.setEducationCode(this.getEducationCode());
		inst.setSource(this.getSource());
		inst.setOrgId(this.getOrgId());
		inst.setResult(this.getResult());
		inst.setMajor(this.getMajor());
		inst.setPos(this.getPos());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setGraduationSchool(this.getGraduationSchool());
		inst.setInterviewDate(this.getInterviewDate());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setInterviewId(this.getInterviewId());
		inst.setSexCode(this.getSexCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setContactInformation(this.getContactInformation());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		inst.setFileId(this.getFileId());
		if(all) {
			inst.setInterviewMethodDict(this.getInterviewMethodDict());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setSourceDict(this.getSourceDict());
			inst.setPageSize(this.getPageSize());
			inst.setEducationData(this.getEducationData());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setOrganization(this.getOrganization());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSexDict(this.getSexDict());
			inst.setInterview(this.getInterview());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonInterviewVO clone(boolean deep) {
		return EntityContext.clone(PersonInterviewVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonInterviewVO
	 * @param personInterviewMap 包含实体信息的 Map 对象
	 * @return PersonInterviewVO , 转换好的的 PersonInterview 对象
	*/
	@Transient
	public static PersonInterviewVO createFrom(Map<String,Object> personInterviewMap) {
		if(personInterviewMap==null) return null;
		PersonInterviewVO vo = create();
		EntityContext.copyProperties(vo,personInterviewMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 PersonInterviewVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonInterviewVO , 转换好的的 PersonInterview 对象
	*/
	@Transient
	public static PersonInterviewVO createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonInterviewVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 PersonInterviewVO，等同于 new
	 * @return PersonInterviewVO 对象
	*/
	@Transient
	public static PersonInterviewVO create() {
		return new com.dt.platform.domain.hr.meta.PersonInterviewVOMeta.$$proxy$$();
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
			this.setBirthday(DataParser.parse(Date.class, map.get(PersonInterviewVOMeta.BIRTHDAY)));
			this.setNotes(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.NOTES)));
			this.setInterviewMethod(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.INTERVIEW_METHOD)));
			this.setEducationCode(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.EDUCATION_CODE)));
			this.setSource(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.SOURCE)));
			this.setOrgId(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.ORG_ID)));
			this.setResult(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.RESULT)));
			this.setMajor(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.MAJOR)));
			this.setPos(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.POS)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.ID)));
			this.setGraduationSchool(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.GRADUATION_SCHOOL)));
			this.setInterviewDate(DataParser.parse(Date.class, map.get(PersonInterviewVOMeta.INTERVIEW_DATE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonInterviewVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonInterviewVOMeta.VERSION)));
			this.setInterviewId(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.INTERVIEW_ID)));
			this.setSexCode(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.SEX_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonInterviewVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonInterviewVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonInterviewVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.STATUS)));
			this.setFileId(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.FILE_ID)));
			// others
			this.setInterviewMethodDict(DataParser.parse(DictItem.class, map.get(PersonInterviewVOMeta.INTERVIEW_METHOD_DICT)));
			this.setSearchField(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.FUZZY_FIELD)));
			this.setSourceDict(DataParser.parse(DictItem.class, map.get(PersonInterviewVOMeta.SOURCE_DICT)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(PersonInterviewVOMeta.PAGE_SIZE)));
			this.setEducationData(DataParser.parse(DictItem.class, map.get(PersonInterviewVOMeta.EDUCATION_DATA)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(PersonInterviewVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.SORT_TYPE)));
			this.setOrganization(DataParser.parse(Organization.class, map.get(PersonInterviewVOMeta.ORGANIZATION)));
			this.setSortField(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.QUERY_LOGIC)));
			this.setSexDict(DataParser.parse(DictItem.class, map.get(PersonInterviewVOMeta.SEX_DICT)));
			this.setInterview(DataParser.parse(Interview.class, map.get(PersonInterviewVOMeta.INTERVIEW)));
			this.setSearchValue(DataParser.parse(String.class, map.get(PersonInterviewVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setBirthday( (Date)map.get(PersonInterviewVOMeta.BIRTHDAY));
				this.setNotes( (String)map.get(PersonInterviewVOMeta.NOTES));
				this.setInterviewMethod( (String)map.get(PersonInterviewVOMeta.INTERVIEW_METHOD));
				this.setEducationCode( (String)map.get(PersonInterviewVOMeta.EDUCATION_CODE));
				this.setSource( (String)map.get(PersonInterviewVOMeta.SOURCE));
				this.setOrgId( (String)map.get(PersonInterviewVOMeta.ORG_ID));
				this.setResult( (String)map.get(PersonInterviewVOMeta.RESULT));
				this.setMajor( (String)map.get(PersonInterviewVOMeta.MAJOR));
				this.setPos( (String)map.get(PersonInterviewVOMeta.POS));
				this.setUpdateBy( (String)map.get(PersonInterviewVOMeta.UPDATE_BY));
				this.setId( (String)map.get(PersonInterviewVOMeta.ID));
				this.setGraduationSchool( (String)map.get(PersonInterviewVOMeta.GRADUATION_SCHOOL));
				this.setInterviewDate( (Date)map.get(PersonInterviewVOMeta.INTERVIEW_DATE));
				this.setUpdateTime( (Date)map.get(PersonInterviewVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PersonInterviewVOMeta.VERSION));
				this.setInterviewId( (String)map.get(PersonInterviewVOMeta.INTERVIEW_ID));
				this.setSexCode( (String)map.get(PersonInterviewVOMeta.SEX_CODE));
				this.setCreateBy( (String)map.get(PersonInterviewVOMeta.CREATE_BY));
				this.setContactInformation( (String)map.get(PersonInterviewVOMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)map.get(PersonInterviewVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(PersonInterviewVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(PersonInterviewVOMeta.DELETE_TIME));
				this.setName( (String)map.get(PersonInterviewVOMeta.NAME));
				this.setTenantId( (String)map.get(PersonInterviewVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonInterviewVOMeta.DELETE_BY));
				this.setStatus( (String)map.get(PersonInterviewVOMeta.STATUS));
				this.setFileId( (String)map.get(PersonInterviewVOMeta.FILE_ID));
				// others
				this.setInterviewMethodDict( (DictItem)map.get(PersonInterviewVOMeta.INTERVIEW_METHOD_DICT));
				this.setSearchField( (String)map.get(PersonInterviewVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(PersonInterviewVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(PersonInterviewVOMeta.FUZZY_FIELD));
				this.setSourceDict( (DictItem)map.get(PersonInterviewVOMeta.SOURCE_DICT));
				this.setPageSize( (Integer)map.get(PersonInterviewVOMeta.PAGE_SIZE));
				this.setEducationData( (DictItem)map.get(PersonInterviewVOMeta.EDUCATION_DATA));
				this.setPageIndex( (Integer)map.get(PersonInterviewVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(PersonInterviewVOMeta.SORT_TYPE));
				this.setOrganization( (Organization)map.get(PersonInterviewVOMeta.ORGANIZATION));
				this.setSortField( (String)map.get(PersonInterviewVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(PersonInterviewVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(PersonInterviewVOMeta.QUERY_LOGIC));
				this.setSexDict( (DictItem)map.get(PersonInterviewVOMeta.SEX_DICT));
				this.setInterview( (Interview)map.get(PersonInterviewVOMeta.INTERVIEW));
				this.setSearchValue( (String)map.get(PersonInterviewVOMeta.SEARCH_VALUE));
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
			this.setBirthday(DataParser.parse(Date.class, r.getValue(PersonInterviewVOMeta.BIRTHDAY)));
			this.setNotes(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.NOTES)));
			this.setInterviewMethod(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.INTERVIEW_METHOD)));
			this.setEducationCode(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.EDUCATION_CODE)));
			this.setSource(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.SOURCE)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.ORG_ID)));
			this.setResult(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.RESULT)));
			this.setMajor(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.MAJOR)));
			this.setPos(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.POS)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.ID)));
			this.setGraduationSchool(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.GRADUATION_SCHOOL)));
			this.setInterviewDate(DataParser.parse(Date.class, r.getValue(PersonInterviewVOMeta.INTERVIEW_DATE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonInterviewVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonInterviewVOMeta.VERSION)));
			this.setInterviewId(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.INTERVIEW_ID)));
			this.setSexCode(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.SEX_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonInterviewVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonInterviewVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonInterviewVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.STATUS)));
			this.setFileId(DataParser.parse(String.class, r.getValue(PersonInterviewVOMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setBirthday( (Date)r.getValue(PersonInterviewVOMeta.BIRTHDAY));
				this.setNotes( (String)r.getValue(PersonInterviewVOMeta.NOTES));
				this.setInterviewMethod( (String)r.getValue(PersonInterviewVOMeta.INTERVIEW_METHOD));
				this.setEducationCode( (String)r.getValue(PersonInterviewVOMeta.EDUCATION_CODE));
				this.setSource( (String)r.getValue(PersonInterviewVOMeta.SOURCE));
				this.setOrgId( (String)r.getValue(PersonInterviewVOMeta.ORG_ID));
				this.setResult( (String)r.getValue(PersonInterviewVOMeta.RESULT));
				this.setMajor( (String)r.getValue(PersonInterviewVOMeta.MAJOR));
				this.setPos( (String)r.getValue(PersonInterviewVOMeta.POS));
				this.setUpdateBy( (String)r.getValue(PersonInterviewVOMeta.UPDATE_BY));
				this.setId( (String)r.getValue(PersonInterviewVOMeta.ID));
				this.setGraduationSchool( (String)r.getValue(PersonInterviewVOMeta.GRADUATION_SCHOOL));
				this.setInterviewDate( (Date)r.getValue(PersonInterviewVOMeta.INTERVIEW_DATE));
				this.setUpdateTime( (Date)r.getValue(PersonInterviewVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PersonInterviewVOMeta.VERSION));
				this.setInterviewId( (String)r.getValue(PersonInterviewVOMeta.INTERVIEW_ID));
				this.setSexCode( (String)r.getValue(PersonInterviewVOMeta.SEX_CODE));
				this.setCreateBy( (String)r.getValue(PersonInterviewVOMeta.CREATE_BY));
				this.setContactInformation( (String)r.getValue(PersonInterviewVOMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)r.getValue(PersonInterviewVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PersonInterviewVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(PersonInterviewVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(PersonInterviewVOMeta.NAME));
				this.setTenantId( (String)r.getValue(PersonInterviewVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonInterviewVOMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(PersonInterviewVOMeta.STATUS));
				this.setFileId( (String)r.getValue(PersonInterviewVOMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}