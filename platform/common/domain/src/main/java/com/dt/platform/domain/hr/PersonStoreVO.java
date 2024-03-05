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
import com.dt.platform.domain.hr.meta.PersonStoreVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.system.DictItem;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 人员信息VO类型
 * <p>人员信息 , 数据表 hr_person_store 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-20 12:35:32
 * @sign 1B452D9CA8FD363D32FECD4CF80B0770
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "人员信息VO类型 ; 人员信息 , 数据表 hr_person_store 的通用VO类型" , parent = PersonStore.class)
public class PersonStoreVO extends PersonStore {

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
	public PersonStoreVO setPageIndex(Integer pageIndex) {
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
	public PersonStoreVO setPageSize(Integer pageSize) {
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
	public PersonStoreVO setSearchField(String searchField) {
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
	public PersonStoreVO setFuzzyField(String fuzzyField) {
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
	public PersonStoreVO setSearchValue(String searchValue) {
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
	public PersonStoreVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public PersonStoreVO addDirtyField(String... dirtyField) {
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
	public PersonStoreVO setSortField(String sortField) {
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
	public PersonStoreVO setSortType(String sortType) {
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
	public PersonStoreVO setDataOrigin(String dataOrigin) {
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
	public PersonStoreVO setQueryLogic(String queryLogic) {
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
	public PersonStoreVO setRequestAction(String requestAction) {
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
	public PersonStoreVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public PersonStoreVO addId(String... id) {
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
	 * @return PersonStoreVO , 转换好的 PersonStoreVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonStoreVO , 转换好的 PoJo 对象
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
	public PersonStoreVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonStoreVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonStoreVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonStoreVOMeta.$$proxy$$();
		inst.setBirthday(this.getBirthday());
		inst.setNote(this.getNote());
		inst.setReviewResult(this.getReviewResult());
		inst.setOwnerCode(this.getOwnerCode());
		inst.setCertificate(this.getCertificate());
		inst.setEducationCode(this.getEducationCode());
		inst.setSource(this.getSource());
		inst.setComputerAbility(this.getComputerAbility());
		inst.setNativePlaceCode(this.getNativePlaceCode());
		inst.setMajor(this.getMajor());
		inst.setPictureId(this.getPictureId());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setEmail(this.getEmail());
		inst.setNationCode(this.getNationCode());
		inst.setFirstWorkDate(this.getFirstWorkDate());
		inst.setForeignLanguageLevel(this.getForeignLanguageLevel());
		inst.setGraduationSchool(this.getGraduationSchool());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setIdentityCard(this.getIdentityCard());
		inst.setSpecialSkill(this.getSpecialSkill());
		inst.setForSalary(this.getForSalary());
		inst.setVersion(this.getVersion());
		inst.setJoinPartDate(this.getJoinPartDate());
		inst.setSexCode(this.getSexCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setContactInformation(this.getContactInformation());
		inst.setDeleted(this.getDeleted());
		inst.setGraduationDate(this.getGraduationDate());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setForeignLanguage(this.getForeignLanguage());
		inst.setTenantId(this.getTenantId());
		inst.setPoliticCountenanceCode(this.getPoliticCountenanceCode());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setNowSalary(this.getNowSalary());
		inst.setPosition(this.getPosition());
		inst.setMaritalStatus(this.getMaritalStatus());
		inst.setJobRequirement(this.getJobRequirement());
		inst.setFileId(this.getFileId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setPoliticCountenanceData(this.getPoliticCountenanceData());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setEducationData(this.getEducationData());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSexDict(this.getSexDict());
			inst.setSearchValue(this.getSearchValue());
			inst.setMaritalStatusDict(this.getMaritalStatusDict());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonStoreVO clone(boolean deep) {
		return EntityContext.clone(PersonStoreVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonStoreVO
	 * @param personStoreMap 包含实体信息的 Map 对象
	 * @return PersonStoreVO , 转换好的的 PersonStore 对象
	*/
	@Transient
	public static PersonStoreVO createFrom(Map<String,Object> personStoreMap) {
		if(personStoreMap==null) return null;
		PersonStoreVO vo = create();
		EntityContext.copyProperties(vo,personStoreMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 PersonStoreVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonStoreVO , 转换好的的 PersonStore 对象
	*/
	@Transient
	public static PersonStoreVO createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonStoreVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 PersonStoreVO，等同于 new
	 * @return PersonStoreVO 对象
	*/
	@Transient
	public static PersonStoreVO create() {
		return new com.dt.platform.domain.hr.meta.PersonStoreVOMeta.$$proxy$$();
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
			this.setBirthday(DataParser.parse(Date.class, map.get(PersonStoreVOMeta.BIRTHDAY)));
			this.setNote(DataParser.parse(String.class, map.get(PersonStoreVOMeta.NOTE)));
			this.setReviewResult(DataParser.parse(String.class, map.get(PersonStoreVOMeta.REVIEW_RESULT)));
			this.setOwnerCode(DataParser.parse(String.class, map.get(PersonStoreVOMeta.OWNER_CODE)));
			this.setCertificate(DataParser.parse(String.class, map.get(PersonStoreVOMeta.CERTIFICATE)));
			this.setEducationCode(DataParser.parse(String.class, map.get(PersonStoreVOMeta.EDUCATION_CODE)));
			this.setSource(DataParser.parse(String.class, map.get(PersonStoreVOMeta.SOURCE)));
			this.setComputerAbility(DataParser.parse(String.class, map.get(PersonStoreVOMeta.COMPUTER_ABILITY)));
			this.setNativePlaceCode(DataParser.parse(String.class, map.get(PersonStoreVOMeta.NATIVE_PLACE_CODE)));
			this.setMajor(DataParser.parse(String.class, map.get(PersonStoreVOMeta.MAJOR)));
			this.setPictureId(DataParser.parse(String.class, map.get(PersonStoreVOMeta.PICTURE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonStoreVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PersonStoreVOMeta.ID)));
			this.setEmail(DataParser.parse(String.class, map.get(PersonStoreVOMeta.EMAIL)));
			this.setNationCode(DataParser.parse(String.class, map.get(PersonStoreVOMeta.NATION_CODE)));
			this.setFirstWorkDate(DataParser.parse(Date.class, map.get(PersonStoreVOMeta.FIRST_WORK_DATE)));
			this.setForeignLanguageLevel(DataParser.parse(String.class, map.get(PersonStoreVOMeta.FOREIGN_LANGUAGE_LEVEL)));
			this.setGraduationSchool(DataParser.parse(String.class, map.get(PersonStoreVOMeta.GRADUATION_SCHOOL)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonStoreVOMeta.UPDATE_TIME)));
			this.setIdentityCard(DataParser.parse(String.class, map.get(PersonStoreVOMeta.IDENTITY_CARD)));
			this.setSpecialSkill(DataParser.parse(String.class, map.get(PersonStoreVOMeta.SPECIAL_SKILL)));
			this.setForSalary(DataParser.parse(BigDecimal.class, map.get(PersonStoreVOMeta.FOR_SALARY)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonStoreVOMeta.VERSION)));
			this.setJoinPartDate(DataParser.parse(Date.class, map.get(PersonStoreVOMeta.JOIN_PART_DATE)));
			this.setSexCode(DataParser.parse(String.class, map.get(PersonStoreVOMeta.SEX_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonStoreVOMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, map.get(PersonStoreVOMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonStoreVOMeta.DELETED)));
			this.setGraduationDate(DataParser.parse(Date.class, map.get(PersonStoreVOMeta.GRADUATION_DATE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonStoreVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonStoreVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(PersonStoreVOMeta.NAME)));
			this.setForeignLanguage(DataParser.parse(String.class, map.get(PersonStoreVOMeta.FOREIGN_LANGUAGE)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonStoreVOMeta.TENANT_ID)));
			this.setPoliticCountenanceCode(DataParser.parse(String.class, map.get(PersonStoreVOMeta.POLITIC_COUNTENANCE_CODE)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonStoreVOMeta.DELETE_BY)));
			this.setNowSalary(DataParser.parse(BigDecimal.class, map.get(PersonStoreVOMeta.NOW_SALARY)));
			this.setPosition(DataParser.parse(String.class, map.get(PersonStoreVOMeta.POSITION)));
			this.setMaritalStatus(DataParser.parse(String.class, map.get(PersonStoreVOMeta.MARITAL_STATUS)));
			this.setJobRequirement(DataParser.parse(String.class, map.get(PersonStoreVOMeta.JOB_REQUIREMENT)));
			this.setFileId(DataParser.parse(String.class, map.get(PersonStoreVOMeta.FILE_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonStoreVOMeta.STATUS)));
			// others
			this.setPoliticCountenanceData(DataParser.parse(DictItem.class, map.get(PersonStoreVOMeta.POLITIC_COUNTENANCE_DATA)));
			this.setSearchField(DataParser.parse(String.class, map.get(PersonStoreVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(PersonStoreVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(PersonStoreVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(PersonStoreVOMeta.PAGE_SIZE)));
			this.setEducationData(DataParser.parse(DictItem.class, map.get(PersonStoreVOMeta.EDUCATION_DATA)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(PersonStoreVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(PersonStoreVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(PersonStoreVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(PersonStoreVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(PersonStoreVOMeta.QUERY_LOGIC)));
			this.setSexDict(DataParser.parse(DictItem.class, map.get(PersonStoreVOMeta.SEX_DICT)));
			this.setSearchValue(DataParser.parse(String.class, map.get(PersonStoreVOMeta.SEARCH_VALUE)));
			this.setMaritalStatusDict(DataParser.parse(DictItem.class, map.get(PersonStoreVOMeta.MARITAL_STATUS_DICT)));
			return true;
		} else {
			try {
				this.setBirthday( (Date)map.get(PersonStoreVOMeta.BIRTHDAY));
				this.setNote( (String)map.get(PersonStoreVOMeta.NOTE));
				this.setReviewResult( (String)map.get(PersonStoreVOMeta.REVIEW_RESULT));
				this.setOwnerCode( (String)map.get(PersonStoreVOMeta.OWNER_CODE));
				this.setCertificate( (String)map.get(PersonStoreVOMeta.CERTIFICATE));
				this.setEducationCode( (String)map.get(PersonStoreVOMeta.EDUCATION_CODE));
				this.setSource( (String)map.get(PersonStoreVOMeta.SOURCE));
				this.setComputerAbility( (String)map.get(PersonStoreVOMeta.COMPUTER_ABILITY));
				this.setNativePlaceCode( (String)map.get(PersonStoreVOMeta.NATIVE_PLACE_CODE));
				this.setMajor( (String)map.get(PersonStoreVOMeta.MAJOR));
				this.setPictureId( (String)map.get(PersonStoreVOMeta.PICTURE_ID));
				this.setUpdateBy( (String)map.get(PersonStoreVOMeta.UPDATE_BY));
				this.setId( (String)map.get(PersonStoreVOMeta.ID));
				this.setEmail( (String)map.get(PersonStoreVOMeta.EMAIL));
				this.setNationCode( (String)map.get(PersonStoreVOMeta.NATION_CODE));
				this.setFirstWorkDate( (Date)map.get(PersonStoreVOMeta.FIRST_WORK_DATE));
				this.setForeignLanguageLevel( (String)map.get(PersonStoreVOMeta.FOREIGN_LANGUAGE_LEVEL));
				this.setGraduationSchool( (String)map.get(PersonStoreVOMeta.GRADUATION_SCHOOL));
				this.setUpdateTime( (Date)map.get(PersonStoreVOMeta.UPDATE_TIME));
				this.setIdentityCard( (String)map.get(PersonStoreVOMeta.IDENTITY_CARD));
				this.setSpecialSkill( (String)map.get(PersonStoreVOMeta.SPECIAL_SKILL));
				this.setForSalary( (BigDecimal)map.get(PersonStoreVOMeta.FOR_SALARY));
				this.setVersion( (Integer)map.get(PersonStoreVOMeta.VERSION));
				this.setJoinPartDate( (Date)map.get(PersonStoreVOMeta.JOIN_PART_DATE));
				this.setSexCode( (String)map.get(PersonStoreVOMeta.SEX_CODE));
				this.setCreateBy( (String)map.get(PersonStoreVOMeta.CREATE_BY));
				this.setContactInformation( (String)map.get(PersonStoreVOMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)map.get(PersonStoreVOMeta.DELETED));
				this.setGraduationDate( (Date)map.get(PersonStoreVOMeta.GRADUATION_DATE));
				this.setCreateTime( (Date)map.get(PersonStoreVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(PersonStoreVOMeta.DELETE_TIME));
				this.setName( (String)map.get(PersonStoreVOMeta.NAME));
				this.setForeignLanguage( (String)map.get(PersonStoreVOMeta.FOREIGN_LANGUAGE));
				this.setTenantId( (String)map.get(PersonStoreVOMeta.TENANT_ID));
				this.setPoliticCountenanceCode( (String)map.get(PersonStoreVOMeta.POLITIC_COUNTENANCE_CODE));
				this.setDeleteBy( (String)map.get(PersonStoreVOMeta.DELETE_BY));
				this.setNowSalary( (BigDecimal)map.get(PersonStoreVOMeta.NOW_SALARY));
				this.setPosition( (String)map.get(PersonStoreVOMeta.POSITION));
				this.setMaritalStatus( (String)map.get(PersonStoreVOMeta.MARITAL_STATUS));
				this.setJobRequirement( (String)map.get(PersonStoreVOMeta.JOB_REQUIREMENT));
				this.setFileId( (String)map.get(PersonStoreVOMeta.FILE_ID));
				this.setStatus( (String)map.get(PersonStoreVOMeta.STATUS));
				// others
				this.setPoliticCountenanceData( (DictItem)map.get(PersonStoreVOMeta.POLITIC_COUNTENANCE_DATA));
				this.setSearchField( (String)map.get(PersonStoreVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(PersonStoreVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(PersonStoreVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(PersonStoreVOMeta.PAGE_SIZE));
				this.setEducationData( (DictItem)map.get(PersonStoreVOMeta.EDUCATION_DATA));
				this.setPageIndex( (Integer)map.get(PersonStoreVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(PersonStoreVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(PersonStoreVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(PersonStoreVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(PersonStoreVOMeta.QUERY_LOGIC));
				this.setSexDict( (DictItem)map.get(PersonStoreVOMeta.SEX_DICT));
				this.setSearchValue( (String)map.get(PersonStoreVOMeta.SEARCH_VALUE));
				this.setMaritalStatusDict( (DictItem)map.get(PersonStoreVOMeta.MARITAL_STATUS_DICT));
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
			this.setBirthday(DataParser.parse(Date.class, r.getValue(PersonStoreVOMeta.BIRTHDAY)));
			this.setNote(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.NOTE)));
			this.setReviewResult(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.REVIEW_RESULT)));
			this.setOwnerCode(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.OWNER_CODE)));
			this.setCertificate(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.CERTIFICATE)));
			this.setEducationCode(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.EDUCATION_CODE)));
			this.setSource(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.SOURCE)));
			this.setComputerAbility(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.COMPUTER_ABILITY)));
			this.setNativePlaceCode(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.NATIVE_PLACE_CODE)));
			this.setMajor(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.MAJOR)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.PICTURE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.ID)));
			this.setEmail(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.EMAIL)));
			this.setNationCode(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.NATION_CODE)));
			this.setFirstWorkDate(DataParser.parse(Date.class, r.getValue(PersonStoreVOMeta.FIRST_WORK_DATE)));
			this.setForeignLanguageLevel(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.FOREIGN_LANGUAGE_LEVEL)));
			this.setGraduationSchool(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.GRADUATION_SCHOOL)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonStoreVOMeta.UPDATE_TIME)));
			this.setIdentityCard(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.IDENTITY_CARD)));
			this.setSpecialSkill(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.SPECIAL_SKILL)));
			this.setForSalary(DataParser.parse(BigDecimal.class, r.getValue(PersonStoreVOMeta.FOR_SALARY)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonStoreVOMeta.VERSION)));
			this.setJoinPartDate(DataParser.parse(Date.class, r.getValue(PersonStoreVOMeta.JOIN_PART_DATE)));
			this.setSexCode(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.SEX_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonStoreVOMeta.DELETED)));
			this.setGraduationDate(DataParser.parse(Date.class, r.getValue(PersonStoreVOMeta.GRADUATION_DATE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonStoreVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonStoreVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.NAME)));
			this.setForeignLanguage(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.FOREIGN_LANGUAGE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.TENANT_ID)));
			this.setPoliticCountenanceCode(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.POLITIC_COUNTENANCE_CODE)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.DELETE_BY)));
			this.setNowSalary(DataParser.parse(BigDecimal.class, r.getValue(PersonStoreVOMeta.NOW_SALARY)));
			this.setPosition(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.POSITION)));
			this.setMaritalStatus(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.MARITAL_STATUS)));
			this.setJobRequirement(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.JOB_REQUIREMENT)));
			this.setFileId(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.FILE_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonStoreVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setBirthday( (Date)r.getValue(PersonStoreVOMeta.BIRTHDAY));
				this.setNote( (String)r.getValue(PersonStoreVOMeta.NOTE));
				this.setReviewResult( (String)r.getValue(PersonStoreVOMeta.REVIEW_RESULT));
				this.setOwnerCode( (String)r.getValue(PersonStoreVOMeta.OWNER_CODE));
				this.setCertificate( (String)r.getValue(PersonStoreVOMeta.CERTIFICATE));
				this.setEducationCode( (String)r.getValue(PersonStoreVOMeta.EDUCATION_CODE));
				this.setSource( (String)r.getValue(PersonStoreVOMeta.SOURCE));
				this.setComputerAbility( (String)r.getValue(PersonStoreVOMeta.COMPUTER_ABILITY));
				this.setNativePlaceCode( (String)r.getValue(PersonStoreVOMeta.NATIVE_PLACE_CODE));
				this.setMajor( (String)r.getValue(PersonStoreVOMeta.MAJOR));
				this.setPictureId( (String)r.getValue(PersonStoreVOMeta.PICTURE_ID));
				this.setUpdateBy( (String)r.getValue(PersonStoreVOMeta.UPDATE_BY));
				this.setId( (String)r.getValue(PersonStoreVOMeta.ID));
				this.setEmail( (String)r.getValue(PersonStoreVOMeta.EMAIL));
				this.setNationCode( (String)r.getValue(PersonStoreVOMeta.NATION_CODE));
				this.setFirstWorkDate( (Date)r.getValue(PersonStoreVOMeta.FIRST_WORK_DATE));
				this.setForeignLanguageLevel( (String)r.getValue(PersonStoreVOMeta.FOREIGN_LANGUAGE_LEVEL));
				this.setGraduationSchool( (String)r.getValue(PersonStoreVOMeta.GRADUATION_SCHOOL));
				this.setUpdateTime( (Date)r.getValue(PersonStoreVOMeta.UPDATE_TIME));
				this.setIdentityCard( (String)r.getValue(PersonStoreVOMeta.IDENTITY_CARD));
				this.setSpecialSkill( (String)r.getValue(PersonStoreVOMeta.SPECIAL_SKILL));
				this.setForSalary( (BigDecimal)r.getValue(PersonStoreVOMeta.FOR_SALARY));
				this.setVersion( (Integer)r.getValue(PersonStoreVOMeta.VERSION));
				this.setJoinPartDate( (Date)r.getValue(PersonStoreVOMeta.JOIN_PART_DATE));
				this.setSexCode( (String)r.getValue(PersonStoreVOMeta.SEX_CODE));
				this.setCreateBy( (String)r.getValue(PersonStoreVOMeta.CREATE_BY));
				this.setContactInformation( (String)r.getValue(PersonStoreVOMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)r.getValue(PersonStoreVOMeta.DELETED));
				this.setGraduationDate( (Date)r.getValue(PersonStoreVOMeta.GRADUATION_DATE));
				this.setCreateTime( (Date)r.getValue(PersonStoreVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(PersonStoreVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(PersonStoreVOMeta.NAME));
				this.setForeignLanguage( (String)r.getValue(PersonStoreVOMeta.FOREIGN_LANGUAGE));
				this.setTenantId( (String)r.getValue(PersonStoreVOMeta.TENANT_ID));
				this.setPoliticCountenanceCode( (String)r.getValue(PersonStoreVOMeta.POLITIC_COUNTENANCE_CODE));
				this.setDeleteBy( (String)r.getValue(PersonStoreVOMeta.DELETE_BY));
				this.setNowSalary( (BigDecimal)r.getValue(PersonStoreVOMeta.NOW_SALARY));
				this.setPosition( (String)r.getValue(PersonStoreVOMeta.POSITION));
				this.setMaritalStatus( (String)r.getValue(PersonStoreVOMeta.MARITAL_STATUS));
				this.setJobRequirement( (String)r.getValue(PersonStoreVOMeta.JOB_REQUIREMENT));
				this.setFileId( (String)r.getValue(PersonStoreVOMeta.FILE_ID));
				this.setStatus( (String)r.getValue(PersonStoreVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}