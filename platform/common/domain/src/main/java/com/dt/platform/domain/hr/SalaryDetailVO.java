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
import com.dt.platform.domain.hr.meta.SalaryDetailVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.math.BigDecimal;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 薪酬明细VO类型
 * <p>薪酬明细 , 数据表 hr_salary_detail 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-05 13:06:01
 * @sign D3B310DBE8753898C4401D627A0D58FF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "薪酬明细VO类型 ; 薪酬明细 , 数据表 hr_salary_detail 的通用VO类型" , parent = SalaryDetail.class)
public class SalaryDetailVO extends SalaryDetail {

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
	public SalaryDetailVO setPageIndex(Integer pageIndex) {
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
	public SalaryDetailVO setPageSize(Integer pageSize) {
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
	public SalaryDetailVO setSearchField(String searchField) {
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
	public SalaryDetailVO setFuzzyField(String fuzzyField) {
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
	public SalaryDetailVO setSearchValue(String searchValue) {
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
	public SalaryDetailVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public SalaryDetailVO addDirtyField(String... dirtyField) {
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
	public SalaryDetailVO setSortField(String sortField) {
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
	public SalaryDetailVO setSortType(String sortType) {
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
	public SalaryDetailVO setDataOrigin(String dataOrigin) {
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
	public SalaryDetailVO setQueryLogic(String queryLogic) {
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
	public SalaryDetailVO setRequestAction(String requestAction) {
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
	public SalaryDetailVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public SalaryDetailVO addId(String... id) {
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
	 * @return SalaryDetailVO , 转换好的 SalaryDetailVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SalaryDetailVO , 转换好的 PoJo 对象
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
	public SalaryDetailVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SalaryDetailVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.SalaryDetailVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.SalaryDetailVOMeta.$$proxy$$();
		inst.setHighTemperatureSalary(this.getHighTemperatureSalary());
		inst.setNotes(this.getNotes());
		inst.setWelfareZfgjjBase(this.getWelfareZfgjjBase());
		inst.setDeductKq(this.getDeductKq());
		inst.setWelfareZfgjjPerson(this.getWelfareZfgjjPerson());
		inst.setDeductGh(this.getDeductGh());
		inst.setActionMonth(this.getActionMonth());
		inst.setWelfaerYlbxCompany(this.getWelfaerYlbxCompany());
		inst.setPersonalTaxErzh(this.getPersonalTaxErzh());
		inst.setBank(this.getBank());
		inst.setPersonalTaxJxjy(this.getPersonalTaxJxjy());
		inst.setPayAmount(this.getPayAmount());
		inst.setCommunicationSalary(this.getCommunicationSalary());
		inst.setPtDkjs(this.getPtDkjs());
		inst.setPtGrsds(this.getPtGrsds());
		inst.setFixedSalary(this.getFixedSalary());
		inst.setId(this.getId());
		inst.setTrafficSalary(this.getTrafficSalary());
		inst.setWelfaerYrbxCompany(this.getWelfaerYrbxCompany());
		inst.setBankAccount(this.getBankAccount());
		inst.setIssuedAmount(this.getIssuedAmount());
		inst.setWelfaerSybxBase(this.getWelfaerSybxBase());
		inst.setWelfaerGsbxBase(this.getWelfaerGsbxBase());
		inst.setWelfaerSybxCompany(this.getWelfaerSybxCompany());
		inst.setWelfaerYrbxBase(this.getWelfaerYrbxBase());
		inst.setWelfaerSyebxBase(this.getWelfaerSyebxBase());
		inst.setVersion(this.getVersion());
		inst.setTotalAmount(this.getTotalAmount());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setActionId(this.getActionId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setEffectTime(this.getEffectTime());
		inst.setTplId(this.getTplId());
		inst.setOtherSalary(this.getOtherSalary());
		inst.setDeductPersonalTaxRed(this.getDeductPersonalTaxRed());
		inst.setCommissionSalary(this.getCommissionSalary());
		inst.setJobNumber(this.getJobNumber());
		inst.setStatus(this.getStatus());
		inst.setPersonalTaxZfdk(this.getPersonalTaxZfdk());
		inst.setWelfaerSyebxPerson(this.getWelfaerSyebxPerson());
		inst.setWelfaerSybxPerson(this.getWelfaerSybxPerson());
		inst.setWelfaerYlbxBase(this.getWelfaerYlbxBase());
		inst.setBaseSalary(this.getBaseSalary());
		inst.setPersonalTaxSylr(this.getPersonalTaxSylr());
		inst.setPersonalTaxZnjy(this.getPersonalTaxZnjy());
		inst.setPtSlPct(this.getPtSlPct());
		inst.setWelfaerGsbxPerson(this.getWelfaerGsbxPerson());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setWelfaerYlbxPerson(this.getWelfaerYlbxPerson());
		inst.setWelfareZfgjjCompany(this.getWelfareZfgjjCompany());
		inst.setWelfaerGsbxCompany(this.getWelfaerGsbxCompany());
		inst.setWelfaerSyebxCompany(this.getWelfaerSyebxCompany());
		inst.setHousingSalary(this.getHousingSalary());
		inst.setWelfaerYrbxPerson(this.getWelfaerYrbxPerson());
		inst.setOperMsg(this.getOperMsg());
		inst.setPersonalTaxZfzj(this.getPersonalTaxZfzj());
		inst.setWorkingYearsSalary(this.getWorkingYearsSalary());
		inst.setAchievementSalary(this.getAchievementSalary());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setPersonalTaxDbyl(this.getPersonalTaxDbyl());
		inst.setUserName(this.getUserName());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeductOther(this.getDeductOther());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setTenantId(this.getTenantId());
		inst.setPostSalary(this.getPostSalary());
		inst.setOvertimeSalary(this.getOvertimeSalary());
		if(all) {
			inst.setExtBank(this.getExtBank());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setSalaryAction(this.getSalaryAction());
			inst.setSalaryTpl(this.getSalaryTpl());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setExtBankAccount(this.getExtBankAccount());
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
	public SalaryDetailVO clone(boolean deep) {
		return EntityContext.clone(SalaryDetailVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SalaryDetailVO
	 * @param salaryDetailMap 包含实体信息的 Map 对象
	 * @return SalaryDetailVO , 转换好的的 SalaryDetail 对象
	*/
	@Transient
	public static SalaryDetailVO createFrom(Map<String,Object> salaryDetailMap) {
		if(salaryDetailMap==null) return null;
		SalaryDetailVO vo = create();
		EntityContext.copyProperties(vo,salaryDetailMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 SalaryDetailVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SalaryDetailVO , 转换好的的 SalaryDetail 对象
	*/
	@Transient
	public static SalaryDetailVO createFrom(Object pojo) {
		if(pojo==null) return null;
		SalaryDetailVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 SalaryDetailVO，等同于 new
	 * @return SalaryDetailVO 对象
	*/
	@Transient
	public static SalaryDetailVO create() {
		return new com.dt.platform.domain.hr.meta.SalaryDetailVOMeta.$$proxy$$();
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
			this.setHighTemperatureSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.HIGH_TEMPERATURE_SALARY)));
			this.setNotes(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.NOTES)));
			this.setWelfareZfgjjBase(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WELFARE_ZFGJJ_BASE)));
			this.setDeductKq(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.DEDUCT_KQ)));
			this.setWelfareZfgjjPerson(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WELFARE_ZFGJJ_PERSON)));
			this.setDeductGh(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.DEDUCT_GH)));
			this.setActionMonth(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.ACTION_MONTH)));
			this.setWelfaerYlbxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WELFAER_YLBX_COMPANY)));
			this.setPersonalTaxErzh(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.PERSONAL_TAX_ERZH)));
			this.setBank(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.BANK)));
			this.setPersonalTaxJxjy(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.PERSONAL_TAX_JXJY)));
			this.setPayAmount(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.PAY_AMOUNT)));
			this.setCommunicationSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.COMMUNICATION_SALARY)));
			this.setPtDkjs(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.PT_DKJS)));
			this.setPtGrsds(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.PT_GRSDS)));
			this.setFixedSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.FIXED_SALARY)));
			this.setId(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.ID)));
			this.setTrafficSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.TRAFFIC_SALARY)));
			this.setWelfaerYrbxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WELFAER_YRBX_COMPANY)));
			this.setBankAccount(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.BANK_ACCOUNT)));
			this.setIssuedAmount(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.ISSUED_AMOUNT)));
			this.setWelfaerSybxBase(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WELFAER_SYBX_BASE)));
			this.setWelfaerGsbxBase(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WELFAER_GSBX_BASE)));
			this.setWelfaerSybxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WELFAER_SYBX_COMPANY)));
			this.setWelfaerYrbxBase(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WELFAER_YRBX_BASE)));
			this.setWelfaerSyebxBase(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WELFAER_SYEBX_BASE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SalaryDetailVOMeta.VERSION)));
			this.setTotalAmount(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.TOTAL_AMOUNT)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SalaryDetailVOMeta.DELETE_TIME)));
			this.setActionId(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.ACTION_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.PERSON_ID)));
			this.setEffectTime(DataParser.parse(Date.class, map.get(SalaryDetailVOMeta.EFFECT_TIME)));
			this.setTplId(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.TPL_ID)));
			this.setOtherSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.OTHER_SALARY)));
			this.setDeductPersonalTaxRed(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.DEDUCT_PERSONAL_TAX_RED)));
			this.setCommissionSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.COMMISSION_SALARY)));
			this.setJobNumber(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.JOB_NUMBER)));
			this.setStatus(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.STATUS)));
			this.setPersonalTaxZfdk(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.PERSONAL_TAX_ZFDK)));
			this.setWelfaerSyebxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WELFAER_SYEBX_PERSON)));
			this.setWelfaerSybxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WELFAER_SYBX_PERSON)));
			this.setWelfaerYlbxBase(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WELFAER_YLBX_BASE)));
			this.setBaseSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.BASE_SALARY)));
			this.setPersonalTaxSylr(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.PERSONAL_TAX_SYLR)));
			this.setPersonalTaxZnjy(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.PERSONAL_TAX_ZNJY)));
			this.setPtSlPct(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.PT_SL_PCT)));
			this.setWelfaerGsbxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WELFAER_GSBX_PERSON)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.UPDATE_BY)));
			this.setWelfaerYlbxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WELFAER_YLBX_PERSON)));
			this.setWelfareZfgjjCompany(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WELFARE_ZFGJJ_COMPANY)));
			this.setWelfaerGsbxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WELFAER_GSBX_COMPANY)));
			this.setWelfaerSyebxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WELFAER_SYEBX_COMPANY)));
			this.setHousingSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.HOUSING_SALARY)));
			this.setWelfaerYrbxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WELFAER_YRBX_PERSON)));
			this.setOperMsg(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.OPER_MSG)));
			this.setPersonalTaxZfzj(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.PERSONAL_TAX_ZFZJ)));
			this.setWorkingYearsSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.WORKING_YEARS_SALARY)));
			this.setAchievementSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.ACHIEVEMENT_SALARY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SalaryDetailVOMeta.UPDATE_TIME)));
			this.setPersonalTaxDbyl(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.PERSONAL_TAX_DBYL)));
			this.setUserName(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.USER_NAME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.CREATE_BY)));
			this.setDeductOther(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.DEDUCT_OTHER)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SalaryDetailVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SalaryDetailVOMeta.CREATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.TENANT_ID)));
			this.setPostSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.POST_SALARY)));
			this.setOvertimeSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailVOMeta.OVERTIME_SALARY)));
			// others
			this.setExtBank(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.EXT_BANK)));
			this.setSearchField(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(SalaryDetailVOMeta.PAGE_SIZE)));
			this.setSalaryAction(DataParser.parse(SalaryAction.class, map.get(SalaryDetailVOMeta.SALARY_ACTION)));
			this.setSalaryTpl(DataParser.parse(SalaryTpl.class, map.get(SalaryDetailVOMeta.SALARY_TPL)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(SalaryDetailVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.SORT_TYPE)));
			this.setExtBankAccount(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.EXT_BANK_ACCOUNT)));
			this.setPerson(DataParser.parse(Person.class, map.get(SalaryDetailVOMeta.PERSON)));
			this.setSortField(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(SalaryDetailVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setHighTemperatureSalary( (BigDecimal)map.get(SalaryDetailVOMeta.HIGH_TEMPERATURE_SALARY));
				this.setNotes( (String)map.get(SalaryDetailVOMeta.NOTES));
				this.setWelfareZfgjjBase( (BigDecimal)map.get(SalaryDetailVOMeta.WELFARE_ZFGJJ_BASE));
				this.setDeductKq( (BigDecimal)map.get(SalaryDetailVOMeta.DEDUCT_KQ));
				this.setWelfareZfgjjPerson( (BigDecimal)map.get(SalaryDetailVOMeta.WELFARE_ZFGJJ_PERSON));
				this.setDeductGh( (BigDecimal)map.get(SalaryDetailVOMeta.DEDUCT_GH));
				this.setActionMonth( (String)map.get(SalaryDetailVOMeta.ACTION_MONTH));
				this.setWelfaerYlbxCompany( (BigDecimal)map.get(SalaryDetailVOMeta.WELFAER_YLBX_COMPANY));
				this.setPersonalTaxErzh( (BigDecimal)map.get(SalaryDetailVOMeta.PERSONAL_TAX_ERZH));
				this.setBank( (String)map.get(SalaryDetailVOMeta.BANK));
				this.setPersonalTaxJxjy( (BigDecimal)map.get(SalaryDetailVOMeta.PERSONAL_TAX_JXJY));
				this.setPayAmount( (BigDecimal)map.get(SalaryDetailVOMeta.PAY_AMOUNT));
				this.setCommunicationSalary( (BigDecimal)map.get(SalaryDetailVOMeta.COMMUNICATION_SALARY));
				this.setPtDkjs( (BigDecimal)map.get(SalaryDetailVOMeta.PT_DKJS));
				this.setPtGrsds( (BigDecimal)map.get(SalaryDetailVOMeta.PT_GRSDS));
				this.setFixedSalary( (BigDecimal)map.get(SalaryDetailVOMeta.FIXED_SALARY));
				this.setId( (String)map.get(SalaryDetailVOMeta.ID));
				this.setTrafficSalary( (BigDecimal)map.get(SalaryDetailVOMeta.TRAFFIC_SALARY));
				this.setWelfaerYrbxCompany( (BigDecimal)map.get(SalaryDetailVOMeta.WELFAER_YRBX_COMPANY));
				this.setBankAccount( (String)map.get(SalaryDetailVOMeta.BANK_ACCOUNT));
				this.setIssuedAmount( (BigDecimal)map.get(SalaryDetailVOMeta.ISSUED_AMOUNT));
				this.setWelfaerSybxBase( (BigDecimal)map.get(SalaryDetailVOMeta.WELFAER_SYBX_BASE));
				this.setWelfaerGsbxBase( (BigDecimal)map.get(SalaryDetailVOMeta.WELFAER_GSBX_BASE));
				this.setWelfaerSybxCompany( (BigDecimal)map.get(SalaryDetailVOMeta.WELFAER_SYBX_COMPANY));
				this.setWelfaerYrbxBase( (BigDecimal)map.get(SalaryDetailVOMeta.WELFAER_YRBX_BASE));
				this.setWelfaerSyebxBase( (BigDecimal)map.get(SalaryDetailVOMeta.WELFAER_SYEBX_BASE));
				this.setVersion( (Integer)map.get(SalaryDetailVOMeta.VERSION));
				this.setTotalAmount( (BigDecimal)map.get(SalaryDetailVOMeta.TOTAL_AMOUNT));
				this.setDeleteTime( (Date)map.get(SalaryDetailVOMeta.DELETE_TIME));
				this.setActionId( (String)map.get(SalaryDetailVOMeta.ACTION_ID));
				this.setDeleteBy( (String)map.get(SalaryDetailVOMeta.DELETE_BY));
				this.setPersonId( (String)map.get(SalaryDetailVOMeta.PERSON_ID));
				this.setEffectTime( (Date)map.get(SalaryDetailVOMeta.EFFECT_TIME));
				this.setTplId( (String)map.get(SalaryDetailVOMeta.TPL_ID));
				this.setOtherSalary( (BigDecimal)map.get(SalaryDetailVOMeta.OTHER_SALARY));
				this.setDeductPersonalTaxRed( (BigDecimal)map.get(SalaryDetailVOMeta.DEDUCT_PERSONAL_TAX_RED));
				this.setCommissionSalary( (BigDecimal)map.get(SalaryDetailVOMeta.COMMISSION_SALARY));
				this.setJobNumber( (String)map.get(SalaryDetailVOMeta.JOB_NUMBER));
				this.setStatus( (String)map.get(SalaryDetailVOMeta.STATUS));
				this.setPersonalTaxZfdk( (BigDecimal)map.get(SalaryDetailVOMeta.PERSONAL_TAX_ZFDK));
				this.setWelfaerSyebxPerson( (BigDecimal)map.get(SalaryDetailVOMeta.WELFAER_SYEBX_PERSON));
				this.setWelfaerSybxPerson( (BigDecimal)map.get(SalaryDetailVOMeta.WELFAER_SYBX_PERSON));
				this.setWelfaerYlbxBase( (BigDecimal)map.get(SalaryDetailVOMeta.WELFAER_YLBX_BASE));
				this.setBaseSalary( (BigDecimal)map.get(SalaryDetailVOMeta.BASE_SALARY));
				this.setPersonalTaxSylr( (BigDecimal)map.get(SalaryDetailVOMeta.PERSONAL_TAX_SYLR));
				this.setPersonalTaxZnjy( (BigDecimal)map.get(SalaryDetailVOMeta.PERSONAL_TAX_ZNJY));
				this.setPtSlPct( (BigDecimal)map.get(SalaryDetailVOMeta.PT_SL_PCT));
				this.setWelfaerGsbxPerson( (BigDecimal)map.get(SalaryDetailVOMeta.WELFAER_GSBX_PERSON));
				this.setUpdateBy( (String)map.get(SalaryDetailVOMeta.UPDATE_BY));
				this.setWelfaerYlbxPerson( (BigDecimal)map.get(SalaryDetailVOMeta.WELFAER_YLBX_PERSON));
				this.setWelfareZfgjjCompany( (BigDecimal)map.get(SalaryDetailVOMeta.WELFARE_ZFGJJ_COMPANY));
				this.setWelfaerGsbxCompany( (BigDecimal)map.get(SalaryDetailVOMeta.WELFAER_GSBX_COMPANY));
				this.setWelfaerSyebxCompany( (BigDecimal)map.get(SalaryDetailVOMeta.WELFAER_SYEBX_COMPANY));
				this.setHousingSalary( (BigDecimal)map.get(SalaryDetailVOMeta.HOUSING_SALARY));
				this.setWelfaerYrbxPerson( (BigDecimal)map.get(SalaryDetailVOMeta.WELFAER_YRBX_PERSON));
				this.setOperMsg( (String)map.get(SalaryDetailVOMeta.OPER_MSG));
				this.setPersonalTaxZfzj( (BigDecimal)map.get(SalaryDetailVOMeta.PERSONAL_TAX_ZFZJ));
				this.setWorkingYearsSalary( (BigDecimal)map.get(SalaryDetailVOMeta.WORKING_YEARS_SALARY));
				this.setAchievementSalary( (BigDecimal)map.get(SalaryDetailVOMeta.ACHIEVEMENT_SALARY));
				this.setUpdateTime( (Date)map.get(SalaryDetailVOMeta.UPDATE_TIME));
				this.setPersonalTaxDbyl( (BigDecimal)map.get(SalaryDetailVOMeta.PERSONAL_TAX_DBYL));
				this.setUserName( (String)map.get(SalaryDetailVOMeta.USER_NAME));
				this.setCreateBy( (String)map.get(SalaryDetailVOMeta.CREATE_BY));
				this.setDeductOther( (BigDecimal)map.get(SalaryDetailVOMeta.DEDUCT_OTHER));
				this.setDeleted( (Integer)map.get(SalaryDetailVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(SalaryDetailVOMeta.CREATE_TIME));
				this.setTenantId( (String)map.get(SalaryDetailVOMeta.TENANT_ID));
				this.setPostSalary( (BigDecimal)map.get(SalaryDetailVOMeta.POST_SALARY));
				this.setOvertimeSalary( (BigDecimal)map.get(SalaryDetailVOMeta.OVERTIME_SALARY));
				// others
				this.setExtBank( (String)map.get(SalaryDetailVOMeta.EXT_BANK));
				this.setSearchField( (String)map.get(SalaryDetailVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(SalaryDetailVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(SalaryDetailVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(SalaryDetailVOMeta.PAGE_SIZE));
				this.setSalaryAction( (SalaryAction)map.get(SalaryDetailVOMeta.SALARY_ACTION));
				this.setSalaryTpl( (SalaryTpl)map.get(SalaryDetailVOMeta.SALARY_TPL));
				this.setPageIndex( (Integer)map.get(SalaryDetailVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(SalaryDetailVOMeta.SORT_TYPE));
				this.setExtBankAccount( (String)map.get(SalaryDetailVOMeta.EXT_BANK_ACCOUNT));
				this.setPerson( (Person)map.get(SalaryDetailVOMeta.PERSON));
				this.setSortField( (String)map.get(SalaryDetailVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(SalaryDetailVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(SalaryDetailVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(SalaryDetailVOMeta.SEARCH_VALUE));
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
			this.setHighTemperatureSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.HIGH_TEMPERATURE_SALARY)));
			this.setNotes(DataParser.parse(String.class, r.getValue(SalaryDetailVOMeta.NOTES)));
			this.setWelfareZfgjjBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WELFARE_ZFGJJ_BASE)));
			this.setDeductKq(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.DEDUCT_KQ)));
			this.setWelfareZfgjjPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WELFARE_ZFGJJ_PERSON)));
			this.setDeductGh(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.DEDUCT_GH)));
			this.setActionMonth(DataParser.parse(String.class, r.getValue(SalaryDetailVOMeta.ACTION_MONTH)));
			this.setWelfaerYlbxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WELFAER_YLBX_COMPANY)));
			this.setPersonalTaxErzh(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.PERSONAL_TAX_ERZH)));
			this.setBank(DataParser.parse(String.class, r.getValue(SalaryDetailVOMeta.BANK)));
			this.setPersonalTaxJxjy(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.PERSONAL_TAX_JXJY)));
			this.setPayAmount(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.PAY_AMOUNT)));
			this.setCommunicationSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.COMMUNICATION_SALARY)));
			this.setPtDkjs(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.PT_DKJS)));
			this.setPtGrsds(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.PT_GRSDS)));
			this.setFixedSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.FIXED_SALARY)));
			this.setId(DataParser.parse(String.class, r.getValue(SalaryDetailVOMeta.ID)));
			this.setTrafficSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.TRAFFIC_SALARY)));
			this.setWelfaerYrbxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WELFAER_YRBX_COMPANY)));
			this.setBankAccount(DataParser.parse(String.class, r.getValue(SalaryDetailVOMeta.BANK_ACCOUNT)));
			this.setIssuedAmount(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.ISSUED_AMOUNT)));
			this.setWelfaerSybxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WELFAER_SYBX_BASE)));
			this.setWelfaerGsbxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WELFAER_GSBX_BASE)));
			this.setWelfaerSybxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WELFAER_SYBX_COMPANY)));
			this.setWelfaerYrbxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WELFAER_YRBX_BASE)));
			this.setWelfaerSyebxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WELFAER_SYEBX_BASE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SalaryDetailVOMeta.VERSION)));
			this.setTotalAmount(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.TOTAL_AMOUNT)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SalaryDetailVOMeta.DELETE_TIME)));
			this.setActionId(DataParser.parse(String.class, r.getValue(SalaryDetailVOMeta.ACTION_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SalaryDetailVOMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(SalaryDetailVOMeta.PERSON_ID)));
			this.setEffectTime(DataParser.parse(Date.class, r.getValue(SalaryDetailVOMeta.EFFECT_TIME)));
			this.setTplId(DataParser.parse(String.class, r.getValue(SalaryDetailVOMeta.TPL_ID)));
			this.setOtherSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.OTHER_SALARY)));
			this.setDeductPersonalTaxRed(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.DEDUCT_PERSONAL_TAX_RED)));
			this.setCommissionSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.COMMISSION_SALARY)));
			this.setJobNumber(DataParser.parse(String.class, r.getValue(SalaryDetailVOMeta.JOB_NUMBER)));
			this.setStatus(DataParser.parse(String.class, r.getValue(SalaryDetailVOMeta.STATUS)));
			this.setPersonalTaxZfdk(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.PERSONAL_TAX_ZFDK)));
			this.setWelfaerSyebxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WELFAER_SYEBX_PERSON)));
			this.setWelfaerSybxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WELFAER_SYBX_PERSON)));
			this.setWelfaerYlbxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WELFAER_YLBX_BASE)));
			this.setBaseSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.BASE_SALARY)));
			this.setPersonalTaxSylr(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.PERSONAL_TAX_SYLR)));
			this.setPersonalTaxZnjy(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.PERSONAL_TAX_ZNJY)));
			this.setPtSlPct(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.PT_SL_PCT)));
			this.setWelfaerGsbxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WELFAER_GSBX_PERSON)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SalaryDetailVOMeta.UPDATE_BY)));
			this.setWelfaerYlbxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WELFAER_YLBX_PERSON)));
			this.setWelfareZfgjjCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WELFARE_ZFGJJ_COMPANY)));
			this.setWelfaerGsbxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WELFAER_GSBX_COMPANY)));
			this.setWelfaerSyebxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WELFAER_SYEBX_COMPANY)));
			this.setHousingSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.HOUSING_SALARY)));
			this.setWelfaerYrbxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WELFAER_YRBX_PERSON)));
			this.setOperMsg(DataParser.parse(String.class, r.getValue(SalaryDetailVOMeta.OPER_MSG)));
			this.setPersonalTaxZfzj(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.PERSONAL_TAX_ZFZJ)));
			this.setWorkingYearsSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.WORKING_YEARS_SALARY)));
			this.setAchievementSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.ACHIEVEMENT_SALARY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SalaryDetailVOMeta.UPDATE_TIME)));
			this.setPersonalTaxDbyl(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.PERSONAL_TAX_DBYL)));
			this.setUserName(DataParser.parse(String.class, r.getValue(SalaryDetailVOMeta.USER_NAME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SalaryDetailVOMeta.CREATE_BY)));
			this.setDeductOther(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.DEDUCT_OTHER)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SalaryDetailVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SalaryDetailVOMeta.CREATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SalaryDetailVOMeta.TENANT_ID)));
			this.setPostSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.POST_SALARY)));
			this.setOvertimeSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailVOMeta.OVERTIME_SALARY)));
			return true;
		} else {
			try {
				this.setHighTemperatureSalary( (BigDecimal)r.getValue(SalaryDetailVOMeta.HIGH_TEMPERATURE_SALARY));
				this.setNotes( (String)r.getValue(SalaryDetailVOMeta.NOTES));
				this.setWelfareZfgjjBase( (BigDecimal)r.getValue(SalaryDetailVOMeta.WELFARE_ZFGJJ_BASE));
				this.setDeductKq( (BigDecimal)r.getValue(SalaryDetailVOMeta.DEDUCT_KQ));
				this.setWelfareZfgjjPerson( (BigDecimal)r.getValue(SalaryDetailVOMeta.WELFARE_ZFGJJ_PERSON));
				this.setDeductGh( (BigDecimal)r.getValue(SalaryDetailVOMeta.DEDUCT_GH));
				this.setActionMonth( (String)r.getValue(SalaryDetailVOMeta.ACTION_MONTH));
				this.setWelfaerYlbxCompany( (BigDecimal)r.getValue(SalaryDetailVOMeta.WELFAER_YLBX_COMPANY));
				this.setPersonalTaxErzh( (BigDecimal)r.getValue(SalaryDetailVOMeta.PERSONAL_TAX_ERZH));
				this.setBank( (String)r.getValue(SalaryDetailVOMeta.BANK));
				this.setPersonalTaxJxjy( (BigDecimal)r.getValue(SalaryDetailVOMeta.PERSONAL_TAX_JXJY));
				this.setPayAmount( (BigDecimal)r.getValue(SalaryDetailVOMeta.PAY_AMOUNT));
				this.setCommunicationSalary( (BigDecimal)r.getValue(SalaryDetailVOMeta.COMMUNICATION_SALARY));
				this.setPtDkjs( (BigDecimal)r.getValue(SalaryDetailVOMeta.PT_DKJS));
				this.setPtGrsds( (BigDecimal)r.getValue(SalaryDetailVOMeta.PT_GRSDS));
				this.setFixedSalary( (BigDecimal)r.getValue(SalaryDetailVOMeta.FIXED_SALARY));
				this.setId( (String)r.getValue(SalaryDetailVOMeta.ID));
				this.setTrafficSalary( (BigDecimal)r.getValue(SalaryDetailVOMeta.TRAFFIC_SALARY));
				this.setWelfaerYrbxCompany( (BigDecimal)r.getValue(SalaryDetailVOMeta.WELFAER_YRBX_COMPANY));
				this.setBankAccount( (String)r.getValue(SalaryDetailVOMeta.BANK_ACCOUNT));
				this.setIssuedAmount( (BigDecimal)r.getValue(SalaryDetailVOMeta.ISSUED_AMOUNT));
				this.setWelfaerSybxBase( (BigDecimal)r.getValue(SalaryDetailVOMeta.WELFAER_SYBX_BASE));
				this.setWelfaerGsbxBase( (BigDecimal)r.getValue(SalaryDetailVOMeta.WELFAER_GSBX_BASE));
				this.setWelfaerSybxCompany( (BigDecimal)r.getValue(SalaryDetailVOMeta.WELFAER_SYBX_COMPANY));
				this.setWelfaerYrbxBase( (BigDecimal)r.getValue(SalaryDetailVOMeta.WELFAER_YRBX_BASE));
				this.setWelfaerSyebxBase( (BigDecimal)r.getValue(SalaryDetailVOMeta.WELFAER_SYEBX_BASE));
				this.setVersion( (Integer)r.getValue(SalaryDetailVOMeta.VERSION));
				this.setTotalAmount( (BigDecimal)r.getValue(SalaryDetailVOMeta.TOTAL_AMOUNT));
				this.setDeleteTime( (Date)r.getValue(SalaryDetailVOMeta.DELETE_TIME));
				this.setActionId( (String)r.getValue(SalaryDetailVOMeta.ACTION_ID));
				this.setDeleteBy( (String)r.getValue(SalaryDetailVOMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(SalaryDetailVOMeta.PERSON_ID));
				this.setEffectTime( (Date)r.getValue(SalaryDetailVOMeta.EFFECT_TIME));
				this.setTplId( (String)r.getValue(SalaryDetailVOMeta.TPL_ID));
				this.setOtherSalary( (BigDecimal)r.getValue(SalaryDetailVOMeta.OTHER_SALARY));
				this.setDeductPersonalTaxRed( (BigDecimal)r.getValue(SalaryDetailVOMeta.DEDUCT_PERSONAL_TAX_RED));
				this.setCommissionSalary( (BigDecimal)r.getValue(SalaryDetailVOMeta.COMMISSION_SALARY));
				this.setJobNumber( (String)r.getValue(SalaryDetailVOMeta.JOB_NUMBER));
				this.setStatus( (String)r.getValue(SalaryDetailVOMeta.STATUS));
				this.setPersonalTaxZfdk( (BigDecimal)r.getValue(SalaryDetailVOMeta.PERSONAL_TAX_ZFDK));
				this.setWelfaerSyebxPerson( (BigDecimal)r.getValue(SalaryDetailVOMeta.WELFAER_SYEBX_PERSON));
				this.setWelfaerSybxPerson( (BigDecimal)r.getValue(SalaryDetailVOMeta.WELFAER_SYBX_PERSON));
				this.setWelfaerYlbxBase( (BigDecimal)r.getValue(SalaryDetailVOMeta.WELFAER_YLBX_BASE));
				this.setBaseSalary( (BigDecimal)r.getValue(SalaryDetailVOMeta.BASE_SALARY));
				this.setPersonalTaxSylr( (BigDecimal)r.getValue(SalaryDetailVOMeta.PERSONAL_TAX_SYLR));
				this.setPersonalTaxZnjy( (BigDecimal)r.getValue(SalaryDetailVOMeta.PERSONAL_TAX_ZNJY));
				this.setPtSlPct( (BigDecimal)r.getValue(SalaryDetailVOMeta.PT_SL_PCT));
				this.setWelfaerGsbxPerson( (BigDecimal)r.getValue(SalaryDetailVOMeta.WELFAER_GSBX_PERSON));
				this.setUpdateBy( (String)r.getValue(SalaryDetailVOMeta.UPDATE_BY));
				this.setWelfaerYlbxPerson( (BigDecimal)r.getValue(SalaryDetailVOMeta.WELFAER_YLBX_PERSON));
				this.setWelfareZfgjjCompany( (BigDecimal)r.getValue(SalaryDetailVOMeta.WELFARE_ZFGJJ_COMPANY));
				this.setWelfaerGsbxCompany( (BigDecimal)r.getValue(SalaryDetailVOMeta.WELFAER_GSBX_COMPANY));
				this.setWelfaerSyebxCompany( (BigDecimal)r.getValue(SalaryDetailVOMeta.WELFAER_SYEBX_COMPANY));
				this.setHousingSalary( (BigDecimal)r.getValue(SalaryDetailVOMeta.HOUSING_SALARY));
				this.setWelfaerYrbxPerson( (BigDecimal)r.getValue(SalaryDetailVOMeta.WELFAER_YRBX_PERSON));
				this.setOperMsg( (String)r.getValue(SalaryDetailVOMeta.OPER_MSG));
				this.setPersonalTaxZfzj( (BigDecimal)r.getValue(SalaryDetailVOMeta.PERSONAL_TAX_ZFZJ));
				this.setWorkingYearsSalary( (BigDecimal)r.getValue(SalaryDetailVOMeta.WORKING_YEARS_SALARY));
				this.setAchievementSalary( (BigDecimal)r.getValue(SalaryDetailVOMeta.ACHIEVEMENT_SALARY));
				this.setUpdateTime( (Date)r.getValue(SalaryDetailVOMeta.UPDATE_TIME));
				this.setPersonalTaxDbyl( (BigDecimal)r.getValue(SalaryDetailVOMeta.PERSONAL_TAX_DBYL));
				this.setUserName( (String)r.getValue(SalaryDetailVOMeta.USER_NAME));
				this.setCreateBy( (String)r.getValue(SalaryDetailVOMeta.CREATE_BY));
				this.setDeductOther( (BigDecimal)r.getValue(SalaryDetailVOMeta.DEDUCT_OTHER));
				this.setDeleted( (Integer)r.getValue(SalaryDetailVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(SalaryDetailVOMeta.CREATE_TIME));
				this.setTenantId( (String)r.getValue(SalaryDetailVOMeta.TENANT_ID));
				this.setPostSalary( (BigDecimal)r.getValue(SalaryDetailVOMeta.POST_SALARY));
				this.setOvertimeSalary( (BigDecimal)r.getValue(SalaryDetailVOMeta.OVERTIME_SALARY));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}