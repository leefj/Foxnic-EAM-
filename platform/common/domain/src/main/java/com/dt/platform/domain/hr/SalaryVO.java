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
import com.dt.platform.domain.hr.meta.SalaryVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.math.BigDecimal;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 人员薪酬VO类型
 * <p>人员薪酬 , 数据表 hr_salary 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-06 17:58:38
 * @sign E138E7272BF556128C11A273377D877E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "人员薪酬VO类型 ; 人员薪酬 , 数据表 hr_salary 的通用VO类型" , parent = Salary.class)
public class SalaryVO extends Salary {

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
	public SalaryVO setPageIndex(Integer pageIndex) {
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
	public SalaryVO setPageSize(Integer pageSize) {
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
	public SalaryVO setSearchField(String searchField) {
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
	public SalaryVO setFuzzyField(String fuzzyField) {
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
	public SalaryVO setSearchValue(String searchValue) {
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
	public SalaryVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public SalaryVO addDirtyField(String... dirtyField) {
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
	public SalaryVO setSortField(String sortField) {
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
	public SalaryVO setSortType(String sortType) {
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
	public SalaryVO setDataOrigin(String dataOrigin) {
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
	public SalaryVO setQueryLogic(String queryLogic) {
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
	public SalaryVO setRequestAction(String requestAction) {
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
	public SalaryVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public SalaryVO addId(String... id) {
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
	 * @return SalaryVO , 转换好的 SalaryVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SalaryVO , 转换好的 PoJo 对象
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
	public SalaryVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SalaryVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.SalaryVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.SalaryVOMeta.$$proxy$$();
		inst.setHighTemperatureSalary(this.getHighTemperatureSalary());
		inst.setNotes(this.getNotes());
		inst.setWelfareZfgjjBase(this.getWelfareZfgjjBase());
		inst.setDeductKq(this.getDeductKq());
		inst.setWelfareZfgjjPerson(this.getWelfareZfgjjPerson());
		inst.setDeductGh(this.getDeductGh());
		inst.setWelfaerYlbxCompany(this.getWelfaerYlbxCompany());
		inst.setPersonalTaxErzh(this.getPersonalTaxErzh());
		inst.setPersonalTaxJxjy(this.getPersonalTaxJxjy());
		inst.setCommunicationSalary(this.getCommunicationSalary());
		inst.setFixedSalary(this.getFixedSalary());
		inst.setId(this.getId());
		inst.setTrafficSalary(this.getTrafficSalary());
		inst.setWelfaerYrbxCompany(this.getWelfaerYrbxCompany());
		inst.setWelfaerSybxBase(this.getWelfaerSybxBase());
		inst.setWelfaerGsbxBase(this.getWelfaerGsbxBase());
		inst.setWelfaerSybxCompany(this.getWelfaerSybxCompany());
		inst.setWelfaerYrbxBase(this.getWelfaerYrbxBase());
		inst.setWelfaerSyebxBase(this.getWelfaerSyebxBase());
		inst.setVersion(this.getVersion());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setOtherSalary(this.getOtherSalary());
		inst.setDeductPersonalTaxRed(this.getDeductPersonalTaxRed());
		inst.setCommissionSalary(this.getCommissionSalary());
		inst.setPersonalTaxZfdk(this.getPersonalTaxZfdk());
		inst.setWelfaerSyebxPerson(this.getWelfaerSyebxPerson());
		inst.setWelfaerSybxPerson(this.getWelfaerSybxPerson());
		inst.setWelfaerYlbxBase(this.getWelfaerYlbxBase());
		inst.setBaseSalary(this.getBaseSalary());
		inst.setPersonalTaxSylr(this.getPersonalTaxSylr());
		inst.setPersonalTaxZnjy(this.getPersonalTaxZnjy());
		inst.setWelfaerGsbxPerson(this.getWelfaerGsbxPerson());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setWelfaerYlbxPerson(this.getWelfaerYlbxPerson());
		inst.setWelfareZfgjjCompany(this.getWelfareZfgjjCompany());
		inst.setWelfaerGsbxCompany(this.getWelfaerGsbxCompany());
		inst.setWelfaerSyebxCompany(this.getWelfaerSyebxCompany());
		inst.setHousingSalary(this.getHousingSalary());
		inst.setWelfaerYrbxPerson(this.getWelfaerYrbxPerson());
		inst.setPersonalTaxZfzj(this.getPersonalTaxZfzj());
		inst.setWorkingYearsSalary(this.getWorkingYearsSalary());
		inst.setAchievementSalary(this.getAchievementSalary());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setDuductOther(this.getDuductOther());
		inst.setPersonalTaxDbyl(this.getPersonalTaxDbyl());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setTenantId(this.getTenantId());
		inst.setPostSalary(this.getPostSalary());
		inst.setOvertimeSalary(this.getOvertimeSalary());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setPerson(this.getPerson());
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
	public SalaryVO clone(boolean deep) {
		return EntityContext.clone(SalaryVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SalaryVO
	 * @param salaryMap 包含实体信息的 Map 对象
	 * @return SalaryVO , 转换好的的 Salary 对象
	*/
	@Transient
	public static SalaryVO createFrom(Map<String,Object> salaryMap) {
		if(salaryMap==null) return null;
		SalaryVO vo = create();
		EntityContext.copyProperties(vo,salaryMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 SalaryVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SalaryVO , 转换好的的 Salary 对象
	*/
	@Transient
	public static SalaryVO createFrom(Object pojo) {
		if(pojo==null) return null;
		SalaryVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 SalaryVO，等同于 new
	 * @return SalaryVO 对象
	*/
	@Transient
	public static SalaryVO create() {
		return new com.dt.platform.domain.hr.meta.SalaryVOMeta.$$proxy$$();
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
			this.setHighTemperatureSalary(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.HIGH_TEMPERATURE_SALARY)));
			this.setNotes(DataParser.parse(String.class, map.get(SalaryVOMeta.NOTES)));
			this.setWelfareZfgjjBase(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WELFARE_ZFGJJ_BASE)));
			this.setDeductKq(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.DEDUCT_KQ)));
			this.setWelfareZfgjjPerson(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WELFARE_ZFGJJ_PERSON)));
			this.setDeductGh(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.DEDUCT_GH)));
			this.setWelfaerYlbxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WELFAER_YLBX_COMPANY)));
			this.setPersonalTaxErzh(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.PERSONAL_TAX_ERZH)));
			this.setPersonalTaxJxjy(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.PERSONAL_TAX_JXJY)));
			this.setCommunicationSalary(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.COMMUNICATION_SALARY)));
			this.setFixedSalary(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.FIXED_SALARY)));
			this.setId(DataParser.parse(String.class, map.get(SalaryVOMeta.ID)));
			this.setTrafficSalary(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.TRAFFIC_SALARY)));
			this.setWelfaerYrbxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WELFAER_YRBX_COMPANY)));
			this.setWelfaerSybxBase(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WELFAER_SYBX_BASE)));
			this.setWelfaerGsbxBase(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WELFAER_GSBX_BASE)));
			this.setWelfaerSybxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WELFAER_SYBX_COMPANY)));
			this.setWelfaerYrbxBase(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WELFAER_YRBX_BASE)));
			this.setWelfaerSyebxBase(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WELFAER_SYEBX_BASE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SalaryVOMeta.VERSION)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SalaryVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SalaryVOMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(SalaryVOMeta.PERSON_ID)));
			this.setOtherSalary(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.OTHER_SALARY)));
			this.setDeductPersonalTaxRed(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.DEDUCT_PERSONAL_TAX_RED)));
			this.setCommissionSalary(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.COMMISSION_SALARY)));
			this.setPersonalTaxZfdk(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.PERSONAL_TAX_ZFDK)));
			this.setWelfaerSyebxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WELFAER_SYEBX_PERSON)));
			this.setWelfaerSybxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WELFAER_SYBX_PERSON)));
			this.setWelfaerYlbxBase(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WELFAER_YLBX_BASE)));
			this.setBaseSalary(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.BASE_SALARY)));
			this.setPersonalTaxSylr(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.PERSONAL_TAX_SYLR)));
			this.setPersonalTaxZnjy(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.PERSONAL_TAX_ZNJY)));
			this.setWelfaerGsbxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WELFAER_GSBX_PERSON)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SalaryVOMeta.UPDATE_BY)));
			this.setWelfaerYlbxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WELFAER_YLBX_PERSON)));
			this.setWelfareZfgjjCompany(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WELFARE_ZFGJJ_COMPANY)));
			this.setWelfaerGsbxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WELFAER_GSBX_COMPANY)));
			this.setWelfaerSyebxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WELFAER_SYEBX_COMPANY)));
			this.setHousingSalary(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.HOUSING_SALARY)));
			this.setWelfaerYrbxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WELFAER_YRBX_PERSON)));
			this.setPersonalTaxZfzj(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.PERSONAL_TAX_ZFZJ)));
			this.setWorkingYearsSalary(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.WORKING_YEARS_SALARY)));
			this.setAchievementSalary(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.ACHIEVEMENT_SALARY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SalaryVOMeta.UPDATE_TIME)));
			this.setDuductOther(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.DUDUCT_OTHER)));
			this.setPersonalTaxDbyl(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.PERSONAL_TAX_DBYL)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SalaryVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SalaryVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SalaryVOMeta.CREATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(SalaryVOMeta.TENANT_ID)));
			this.setPostSalary(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.POST_SALARY)));
			this.setOvertimeSalary(DataParser.parse(BigDecimal.class, map.get(SalaryVOMeta.OVERTIME_SALARY)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(SalaryVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(SalaryVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(SalaryVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(SalaryVOMeta.PAGE_SIZE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(SalaryVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(SalaryVOMeta.SORT_TYPE)));
			this.setPerson(DataParser.parse(Person.class, map.get(SalaryVOMeta.PERSON)));
			this.setSortField(DataParser.parse(String.class, map.get(SalaryVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(SalaryVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(SalaryVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(SalaryVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setHighTemperatureSalary( (BigDecimal)map.get(SalaryVOMeta.HIGH_TEMPERATURE_SALARY));
				this.setNotes( (String)map.get(SalaryVOMeta.NOTES));
				this.setWelfareZfgjjBase( (BigDecimal)map.get(SalaryVOMeta.WELFARE_ZFGJJ_BASE));
				this.setDeductKq( (BigDecimal)map.get(SalaryVOMeta.DEDUCT_KQ));
				this.setWelfareZfgjjPerson( (BigDecimal)map.get(SalaryVOMeta.WELFARE_ZFGJJ_PERSON));
				this.setDeductGh( (BigDecimal)map.get(SalaryVOMeta.DEDUCT_GH));
				this.setWelfaerYlbxCompany( (BigDecimal)map.get(SalaryVOMeta.WELFAER_YLBX_COMPANY));
				this.setPersonalTaxErzh( (BigDecimal)map.get(SalaryVOMeta.PERSONAL_TAX_ERZH));
				this.setPersonalTaxJxjy( (BigDecimal)map.get(SalaryVOMeta.PERSONAL_TAX_JXJY));
				this.setCommunicationSalary( (BigDecimal)map.get(SalaryVOMeta.COMMUNICATION_SALARY));
				this.setFixedSalary( (BigDecimal)map.get(SalaryVOMeta.FIXED_SALARY));
				this.setId( (String)map.get(SalaryVOMeta.ID));
				this.setTrafficSalary( (BigDecimal)map.get(SalaryVOMeta.TRAFFIC_SALARY));
				this.setWelfaerYrbxCompany( (BigDecimal)map.get(SalaryVOMeta.WELFAER_YRBX_COMPANY));
				this.setWelfaerSybxBase( (BigDecimal)map.get(SalaryVOMeta.WELFAER_SYBX_BASE));
				this.setWelfaerGsbxBase( (BigDecimal)map.get(SalaryVOMeta.WELFAER_GSBX_BASE));
				this.setWelfaerSybxCompany( (BigDecimal)map.get(SalaryVOMeta.WELFAER_SYBX_COMPANY));
				this.setWelfaerYrbxBase( (BigDecimal)map.get(SalaryVOMeta.WELFAER_YRBX_BASE));
				this.setWelfaerSyebxBase( (BigDecimal)map.get(SalaryVOMeta.WELFAER_SYEBX_BASE));
				this.setVersion( (Integer)map.get(SalaryVOMeta.VERSION));
				this.setDeleteTime( (Date)map.get(SalaryVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(SalaryVOMeta.DELETE_BY));
				this.setPersonId( (String)map.get(SalaryVOMeta.PERSON_ID));
				this.setOtherSalary( (BigDecimal)map.get(SalaryVOMeta.OTHER_SALARY));
				this.setDeductPersonalTaxRed( (BigDecimal)map.get(SalaryVOMeta.DEDUCT_PERSONAL_TAX_RED));
				this.setCommissionSalary( (BigDecimal)map.get(SalaryVOMeta.COMMISSION_SALARY));
				this.setPersonalTaxZfdk( (BigDecimal)map.get(SalaryVOMeta.PERSONAL_TAX_ZFDK));
				this.setWelfaerSyebxPerson( (BigDecimal)map.get(SalaryVOMeta.WELFAER_SYEBX_PERSON));
				this.setWelfaerSybxPerson( (BigDecimal)map.get(SalaryVOMeta.WELFAER_SYBX_PERSON));
				this.setWelfaerYlbxBase( (BigDecimal)map.get(SalaryVOMeta.WELFAER_YLBX_BASE));
				this.setBaseSalary( (BigDecimal)map.get(SalaryVOMeta.BASE_SALARY));
				this.setPersonalTaxSylr( (BigDecimal)map.get(SalaryVOMeta.PERSONAL_TAX_SYLR));
				this.setPersonalTaxZnjy( (BigDecimal)map.get(SalaryVOMeta.PERSONAL_TAX_ZNJY));
				this.setWelfaerGsbxPerson( (BigDecimal)map.get(SalaryVOMeta.WELFAER_GSBX_PERSON));
				this.setUpdateBy( (String)map.get(SalaryVOMeta.UPDATE_BY));
				this.setWelfaerYlbxPerson( (BigDecimal)map.get(SalaryVOMeta.WELFAER_YLBX_PERSON));
				this.setWelfareZfgjjCompany( (BigDecimal)map.get(SalaryVOMeta.WELFARE_ZFGJJ_COMPANY));
				this.setWelfaerGsbxCompany( (BigDecimal)map.get(SalaryVOMeta.WELFAER_GSBX_COMPANY));
				this.setWelfaerSyebxCompany( (BigDecimal)map.get(SalaryVOMeta.WELFAER_SYEBX_COMPANY));
				this.setHousingSalary( (BigDecimal)map.get(SalaryVOMeta.HOUSING_SALARY));
				this.setWelfaerYrbxPerson( (BigDecimal)map.get(SalaryVOMeta.WELFAER_YRBX_PERSON));
				this.setPersonalTaxZfzj( (BigDecimal)map.get(SalaryVOMeta.PERSONAL_TAX_ZFZJ));
				this.setWorkingYearsSalary( (BigDecimal)map.get(SalaryVOMeta.WORKING_YEARS_SALARY));
				this.setAchievementSalary( (BigDecimal)map.get(SalaryVOMeta.ACHIEVEMENT_SALARY));
				this.setUpdateTime( (Date)map.get(SalaryVOMeta.UPDATE_TIME));
				this.setDuductOther( (BigDecimal)map.get(SalaryVOMeta.DUDUCT_OTHER));
				this.setPersonalTaxDbyl( (BigDecimal)map.get(SalaryVOMeta.PERSONAL_TAX_DBYL));
				this.setCreateBy( (String)map.get(SalaryVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(SalaryVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(SalaryVOMeta.CREATE_TIME));
				this.setTenantId( (String)map.get(SalaryVOMeta.TENANT_ID));
				this.setPostSalary( (BigDecimal)map.get(SalaryVOMeta.POST_SALARY));
				this.setOvertimeSalary( (BigDecimal)map.get(SalaryVOMeta.OVERTIME_SALARY));
				// others
				this.setSearchField( (String)map.get(SalaryVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(SalaryVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(SalaryVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(SalaryVOMeta.PAGE_SIZE));
				this.setPageIndex( (Integer)map.get(SalaryVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(SalaryVOMeta.SORT_TYPE));
				this.setPerson( (Person)map.get(SalaryVOMeta.PERSON));
				this.setSortField( (String)map.get(SalaryVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(SalaryVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(SalaryVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(SalaryVOMeta.SEARCH_VALUE));
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
			this.setHighTemperatureSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.HIGH_TEMPERATURE_SALARY)));
			this.setNotes(DataParser.parse(String.class, r.getValue(SalaryVOMeta.NOTES)));
			this.setWelfareZfgjjBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WELFARE_ZFGJJ_BASE)));
			this.setDeductKq(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.DEDUCT_KQ)));
			this.setWelfareZfgjjPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WELFARE_ZFGJJ_PERSON)));
			this.setDeductGh(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.DEDUCT_GH)));
			this.setWelfaerYlbxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WELFAER_YLBX_COMPANY)));
			this.setPersonalTaxErzh(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.PERSONAL_TAX_ERZH)));
			this.setPersonalTaxJxjy(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.PERSONAL_TAX_JXJY)));
			this.setCommunicationSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.COMMUNICATION_SALARY)));
			this.setFixedSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.FIXED_SALARY)));
			this.setId(DataParser.parse(String.class, r.getValue(SalaryVOMeta.ID)));
			this.setTrafficSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.TRAFFIC_SALARY)));
			this.setWelfaerYrbxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WELFAER_YRBX_COMPANY)));
			this.setWelfaerSybxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WELFAER_SYBX_BASE)));
			this.setWelfaerGsbxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WELFAER_GSBX_BASE)));
			this.setWelfaerSybxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WELFAER_SYBX_COMPANY)));
			this.setWelfaerYrbxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WELFAER_YRBX_BASE)));
			this.setWelfaerSyebxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WELFAER_SYEBX_BASE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SalaryVOMeta.VERSION)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SalaryVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SalaryVOMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(SalaryVOMeta.PERSON_ID)));
			this.setOtherSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.OTHER_SALARY)));
			this.setDeductPersonalTaxRed(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.DEDUCT_PERSONAL_TAX_RED)));
			this.setCommissionSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.COMMISSION_SALARY)));
			this.setPersonalTaxZfdk(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.PERSONAL_TAX_ZFDK)));
			this.setWelfaerSyebxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WELFAER_SYEBX_PERSON)));
			this.setWelfaerSybxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WELFAER_SYBX_PERSON)));
			this.setWelfaerYlbxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WELFAER_YLBX_BASE)));
			this.setBaseSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.BASE_SALARY)));
			this.setPersonalTaxSylr(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.PERSONAL_TAX_SYLR)));
			this.setPersonalTaxZnjy(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.PERSONAL_TAX_ZNJY)));
			this.setWelfaerGsbxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WELFAER_GSBX_PERSON)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SalaryVOMeta.UPDATE_BY)));
			this.setWelfaerYlbxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WELFAER_YLBX_PERSON)));
			this.setWelfareZfgjjCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WELFARE_ZFGJJ_COMPANY)));
			this.setWelfaerGsbxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WELFAER_GSBX_COMPANY)));
			this.setWelfaerSyebxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WELFAER_SYEBX_COMPANY)));
			this.setHousingSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.HOUSING_SALARY)));
			this.setWelfaerYrbxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WELFAER_YRBX_PERSON)));
			this.setPersonalTaxZfzj(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.PERSONAL_TAX_ZFZJ)));
			this.setWorkingYearsSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.WORKING_YEARS_SALARY)));
			this.setAchievementSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.ACHIEVEMENT_SALARY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SalaryVOMeta.UPDATE_TIME)));
			this.setDuductOther(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.DUDUCT_OTHER)));
			this.setPersonalTaxDbyl(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.PERSONAL_TAX_DBYL)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SalaryVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SalaryVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SalaryVOMeta.CREATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SalaryVOMeta.TENANT_ID)));
			this.setPostSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.POST_SALARY)));
			this.setOvertimeSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryVOMeta.OVERTIME_SALARY)));
			return true;
		} else {
			try {
				this.setHighTemperatureSalary( (BigDecimal)r.getValue(SalaryVOMeta.HIGH_TEMPERATURE_SALARY));
				this.setNotes( (String)r.getValue(SalaryVOMeta.NOTES));
				this.setWelfareZfgjjBase( (BigDecimal)r.getValue(SalaryVOMeta.WELFARE_ZFGJJ_BASE));
				this.setDeductKq( (BigDecimal)r.getValue(SalaryVOMeta.DEDUCT_KQ));
				this.setWelfareZfgjjPerson( (BigDecimal)r.getValue(SalaryVOMeta.WELFARE_ZFGJJ_PERSON));
				this.setDeductGh( (BigDecimal)r.getValue(SalaryVOMeta.DEDUCT_GH));
				this.setWelfaerYlbxCompany( (BigDecimal)r.getValue(SalaryVOMeta.WELFAER_YLBX_COMPANY));
				this.setPersonalTaxErzh( (BigDecimal)r.getValue(SalaryVOMeta.PERSONAL_TAX_ERZH));
				this.setPersonalTaxJxjy( (BigDecimal)r.getValue(SalaryVOMeta.PERSONAL_TAX_JXJY));
				this.setCommunicationSalary( (BigDecimal)r.getValue(SalaryVOMeta.COMMUNICATION_SALARY));
				this.setFixedSalary( (BigDecimal)r.getValue(SalaryVOMeta.FIXED_SALARY));
				this.setId( (String)r.getValue(SalaryVOMeta.ID));
				this.setTrafficSalary( (BigDecimal)r.getValue(SalaryVOMeta.TRAFFIC_SALARY));
				this.setWelfaerYrbxCompany( (BigDecimal)r.getValue(SalaryVOMeta.WELFAER_YRBX_COMPANY));
				this.setWelfaerSybxBase( (BigDecimal)r.getValue(SalaryVOMeta.WELFAER_SYBX_BASE));
				this.setWelfaerGsbxBase( (BigDecimal)r.getValue(SalaryVOMeta.WELFAER_GSBX_BASE));
				this.setWelfaerSybxCompany( (BigDecimal)r.getValue(SalaryVOMeta.WELFAER_SYBX_COMPANY));
				this.setWelfaerYrbxBase( (BigDecimal)r.getValue(SalaryVOMeta.WELFAER_YRBX_BASE));
				this.setWelfaerSyebxBase( (BigDecimal)r.getValue(SalaryVOMeta.WELFAER_SYEBX_BASE));
				this.setVersion( (Integer)r.getValue(SalaryVOMeta.VERSION));
				this.setDeleteTime( (Date)r.getValue(SalaryVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(SalaryVOMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(SalaryVOMeta.PERSON_ID));
				this.setOtherSalary( (BigDecimal)r.getValue(SalaryVOMeta.OTHER_SALARY));
				this.setDeductPersonalTaxRed( (BigDecimal)r.getValue(SalaryVOMeta.DEDUCT_PERSONAL_TAX_RED));
				this.setCommissionSalary( (BigDecimal)r.getValue(SalaryVOMeta.COMMISSION_SALARY));
				this.setPersonalTaxZfdk( (BigDecimal)r.getValue(SalaryVOMeta.PERSONAL_TAX_ZFDK));
				this.setWelfaerSyebxPerson( (BigDecimal)r.getValue(SalaryVOMeta.WELFAER_SYEBX_PERSON));
				this.setWelfaerSybxPerson( (BigDecimal)r.getValue(SalaryVOMeta.WELFAER_SYBX_PERSON));
				this.setWelfaerYlbxBase( (BigDecimal)r.getValue(SalaryVOMeta.WELFAER_YLBX_BASE));
				this.setBaseSalary( (BigDecimal)r.getValue(SalaryVOMeta.BASE_SALARY));
				this.setPersonalTaxSylr( (BigDecimal)r.getValue(SalaryVOMeta.PERSONAL_TAX_SYLR));
				this.setPersonalTaxZnjy( (BigDecimal)r.getValue(SalaryVOMeta.PERSONAL_TAX_ZNJY));
				this.setWelfaerGsbxPerson( (BigDecimal)r.getValue(SalaryVOMeta.WELFAER_GSBX_PERSON));
				this.setUpdateBy( (String)r.getValue(SalaryVOMeta.UPDATE_BY));
				this.setWelfaerYlbxPerson( (BigDecimal)r.getValue(SalaryVOMeta.WELFAER_YLBX_PERSON));
				this.setWelfareZfgjjCompany( (BigDecimal)r.getValue(SalaryVOMeta.WELFARE_ZFGJJ_COMPANY));
				this.setWelfaerGsbxCompany( (BigDecimal)r.getValue(SalaryVOMeta.WELFAER_GSBX_COMPANY));
				this.setWelfaerSyebxCompany( (BigDecimal)r.getValue(SalaryVOMeta.WELFAER_SYEBX_COMPANY));
				this.setHousingSalary( (BigDecimal)r.getValue(SalaryVOMeta.HOUSING_SALARY));
				this.setWelfaerYrbxPerson( (BigDecimal)r.getValue(SalaryVOMeta.WELFAER_YRBX_PERSON));
				this.setPersonalTaxZfzj( (BigDecimal)r.getValue(SalaryVOMeta.PERSONAL_TAX_ZFZJ));
				this.setWorkingYearsSalary( (BigDecimal)r.getValue(SalaryVOMeta.WORKING_YEARS_SALARY));
				this.setAchievementSalary( (BigDecimal)r.getValue(SalaryVOMeta.ACHIEVEMENT_SALARY));
				this.setUpdateTime( (Date)r.getValue(SalaryVOMeta.UPDATE_TIME));
				this.setDuductOther( (BigDecimal)r.getValue(SalaryVOMeta.DUDUCT_OTHER));
				this.setPersonalTaxDbyl( (BigDecimal)r.getValue(SalaryVOMeta.PERSONAL_TAX_DBYL));
				this.setCreateBy( (String)r.getValue(SalaryVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(SalaryVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(SalaryVOMeta.CREATE_TIME));
				this.setTenantId( (String)r.getValue(SalaryVOMeta.TENANT_ID));
				this.setPostSalary( (BigDecimal)r.getValue(SalaryVOMeta.POST_SALARY));
				this.setOvertimeSalary( (BigDecimal)r.getValue(SalaryVOMeta.OVERTIME_SALARY));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}