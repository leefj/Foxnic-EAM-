package com.dt.platform.domain.hr;

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



/**
 * 人员信息
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-17 07:13:41
 * @sign 0D48095740FD04B69DB3F28C0F155746
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PersonVO extends Person {

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
	public PersonVO setPageIndex(Integer pageIndex) {
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
	public PersonVO setPageSize(Integer pageSize) {
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
	public PersonVO setSearchField(String searchField) {
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
	public PersonVO setFuzzyField(String fuzzyField) {
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
	public PersonVO setSearchValue(String searchValue) {
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
	public PersonVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public PersonVO addDirtyField(String... dirtyField) {
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
	public PersonVO setSortField(String sortField) {
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
	public PersonVO setSortType(String sortType) {
		this.sortType=sortType;
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
	public PersonVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public PersonVO addId(String... id) {
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
	 * @return PersonVO , 转换好的 PersonVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonVO , 转换好的 PoJo 对象
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
	public PersonVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonVOMeta.$$proxy$$();
		inst.setRankCode(this.getRankCode());
		inst.setEmergencyContactNo(this.getEmergencyContactNo());
		inst.setEmploymentConfirmDate(this.getEmploymentConfirmDate());
		inst.setNativePlaceCode(this.getNativePlaceCode());
		inst.setMajor(this.getMajor());
		inst.setComputerLevel(this.getComputerLevel());
		inst.setWorkKindCode(this.getWorkKindCode());
		inst.setId(this.getId());
		inst.setPayrollCardBankCode(this.getPayrollCardBankCode());
		inst.setHomeAddress(this.getHomeAddress());
		inst.setEmployeeTitleCode(this.getEmployeeTitleCode());
		inst.setForeignLanguageLevel(this.getForeignLanguageLevel());
		inst.setEmergencyContact(this.getEmergencyContact());
		inst.setGraduationSchool(this.getGraduationSchool());
		inst.setEmploymentDate(this.getEmploymentDate());
		inst.setIdentityCard(this.getIdentityCard());
		inst.setVersion(this.getVersion());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setForeignLanguage(this.getForeignLanguage());
		inst.setFirstEmploymentDate(this.getFirstEmploymentDate());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setJobNumber(this.getJobNumber());
		inst.setMaritalStatus(this.getMaritalStatus());
		inst.setFileId(this.getFileId());
		inst.setBirthday(this.getBirthday());
		inst.setNote(this.getNote());
		inst.setBodyHeight(this.getBodyHeight());
		inst.setPositionCode(this.getPositionCode());
		inst.setEducationCode(this.getEducationCode());
		inst.setComputerAbility(this.getComputerAbility());
		inst.setBloodType(this.getBloodType());
		inst.setEmployeeStatus(this.getEmployeeStatus());
		inst.setOrgId(this.getOrgId());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setPersonPictureId(this.getPersonPictureId());
		inst.setEmail(this.getEmail());
		inst.setNationCode(this.getNationCode());
		inst.setFirstWorkDate(this.getFirstWorkDate());
		inst.setPayrollCard(this.getPayrollCard());
		inst.setWeixinId(this.getWeixinId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setEmployId(this.getEmployId());
		inst.setJoinPartDate(this.getJoinPartDate());
		inst.setLeaveReson(this.getLeaveReson());
		inst.setSexCode(this.getSexCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setContactInformation(this.getContactInformation());
		inst.setDeleted(this.getDeleted());
		inst.setGraduationDate(this.getGraduationDate());
		inst.setCreateTime(this.getCreateTime());
		inst.setEmployeeTypeCode(this.getEmployeeTypeCode());
		inst.setLeaveDate(this.getLeaveDate());
		inst.setTenantId(this.getTenantId());
		inst.setPoliticCountenanceCode(this.getPoliticCountenanceCode());
		inst.setBodyWeight(this.getBodyWeight());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setPageSize(this.getPageSize());
			inst.setIds(this.getIds());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonVO clone(boolean deep) {
		return EntityContext.clone(PersonVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonVO
	 * @param personMap 包含实体信息的 Map 对象
	 * @return PersonVO , 转换好的的 Person 对象
	*/
	@Transient
	public static PersonVO createFrom(Map<String,Object> personMap) {
		if(personMap==null) return null;
		PersonVO vo = create();
		EntityContext.copyProperties(vo,personMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 PersonVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonVO , 转换好的的 Person 对象
	*/
	@Transient
	public static PersonVO createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 PersonVO，等同于 new
	 * @return PersonVO 对象
	*/
	@Transient
	public static PersonVO create() {
		return new com.dt.platform.domain.hr.meta.PersonVOMeta.$$proxy$$();
	}
}