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
import com.dt.platform.domain.hr.meta.SalaryProjectCommissionRcdVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 项目提成记录VO类型
 * <p>项目提成记录 , 数据表 hr_salary_project_commission_rcd 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-01 20:32:22
 * @sign 80370B197A75C4C44985FEA4F3CABB29
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "项目提成记录VO类型 ; 项目提成记录 , 数据表 hr_salary_project_commission_rcd 的通用VO类型" , parent = SalaryProjectCommissionRcd.class)
public class SalaryProjectCommissionRcdVO extends SalaryProjectCommissionRcd {

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
	public SalaryProjectCommissionRcdVO setPageIndex(Integer pageIndex) {
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
	public SalaryProjectCommissionRcdVO setPageSize(Integer pageSize) {
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
	public SalaryProjectCommissionRcdVO setSearchField(String searchField) {
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
	public SalaryProjectCommissionRcdVO setFuzzyField(String fuzzyField) {
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
	public SalaryProjectCommissionRcdVO setSearchValue(String searchValue) {
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
	public SalaryProjectCommissionRcdVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public SalaryProjectCommissionRcdVO addDirtyField(String... dirtyField) {
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
	public SalaryProjectCommissionRcdVO setSortField(String sortField) {
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
	public SalaryProjectCommissionRcdVO setSortType(String sortType) {
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
	public SalaryProjectCommissionRcdVO setDataOrigin(String dataOrigin) {
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
	public SalaryProjectCommissionRcdVO setQueryLogic(String queryLogic) {
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
	public SalaryProjectCommissionRcdVO setRequestAction(String requestAction) {
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
	public SalaryProjectCommissionRcdVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public SalaryProjectCommissionRcdVO addId(String... id) {
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
	 * @return SalaryProjectCommissionRcdVO , 转换好的 SalaryProjectCommissionRcdVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SalaryProjectCommissionRcdVO , 转换好的 PoJo 对象
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
	public SalaryProjectCommissionRcdVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SalaryProjectCommissionRcdVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.SalaryProjectCommissionRcdVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.SalaryProjectCommissionRcdVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setBatchCode(this.getBatchCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setProjectCode(this.getProjectCode());
		inst.setFileIds(this.getFileIds());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setProjectCommissionRatio(this.getProjectCommissionRatio());
		inst.setRcdDate(this.getRcdDate());
		inst.setBusinessValue(this.getBusinessValue());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setId(this.getId());
		inst.setProjectName(this.getProjectName());
		inst.setCommissionSalary(this.getCommissionSalary());
		inst.setJobNumber(this.getJobNumber());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setProject(this.getProject());
			inst.setPageSize(this.getPageSize());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setPerson(this.getPerson());
			inst.setProjectCodeValue(this.getProjectCodeValue());
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
	public SalaryProjectCommissionRcdVO clone(boolean deep) {
		return EntityContext.clone(SalaryProjectCommissionRcdVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SalaryProjectCommissionRcdVO
	 * @param salaryProjectCommissionRcdMap 包含实体信息的 Map 对象
	 * @return SalaryProjectCommissionRcdVO , 转换好的的 SalaryProjectCommissionRcd 对象
	*/
	@Transient
	public static SalaryProjectCommissionRcdVO createFrom(Map<String,Object> salaryProjectCommissionRcdMap) {
		if(salaryProjectCommissionRcdMap==null) return null;
		SalaryProjectCommissionRcdVO vo = create();
		EntityContext.copyProperties(vo,salaryProjectCommissionRcdMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 SalaryProjectCommissionRcdVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SalaryProjectCommissionRcdVO , 转换好的的 SalaryProjectCommissionRcd 对象
	*/
	@Transient
	public static SalaryProjectCommissionRcdVO createFrom(Object pojo) {
		if(pojo==null) return null;
		SalaryProjectCommissionRcdVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 SalaryProjectCommissionRcdVO，等同于 new
	 * @return SalaryProjectCommissionRcdVO 对象
	*/
	@Transient
	public static SalaryProjectCommissionRcdVO create() {
		return new com.dt.platform.domain.hr.meta.SalaryProjectCommissionRcdVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.NOTES)));
			this.setBatchCode(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.BATCH_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SalaryProjectCommissionRcdVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SalaryProjectCommissionRcdVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SalaryProjectCommissionRcdVOMeta.DELETED)));
			this.setProjectCode(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.PROJECT_CODE)));
			this.setFileIds(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SalaryProjectCommissionRcdVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SalaryProjectCommissionRcdVOMeta.DELETE_TIME)));
			this.setProjectCommissionRatio(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.PROJECT_COMMISSION_RATIO)));
			this.setRcdDate(DataParser.parse(Date.class, map.get(SalaryProjectCommissionRcdVOMeta.RCD_DATE)));
			this.setBusinessValue(DataParser.parse(BigDecimal.class, map.get(SalaryProjectCommissionRcdVOMeta.BUSINESS_VALUE)));
			this.setTenantId(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.ID)));
			this.setProjectName(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.PROJECT_NAME)));
			this.setCommissionSalary(DataParser.parse(BigDecimal.class, map.get(SalaryProjectCommissionRcdVOMeta.COMMISSION_SALARY)));
			this.setJobNumber(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.JOB_NUMBER)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.FUZZY_FIELD)));
			this.setProject(DataParser.parse(SalaryProjectCommission.class, map.get(SalaryProjectCommissionRcdVOMeta.PROJECT)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(SalaryProjectCommissionRcdVOMeta.PAGE_SIZE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(SalaryProjectCommissionRcdVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.SORT_TYPE)));
			this.setPerson(DataParser.parse(Person.class, map.get(SalaryProjectCommissionRcdVOMeta.PERSON)));
			this.setProjectCodeValue(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.PROJECT_CODE_VALUE)));
			this.setSortField(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(SalaryProjectCommissionRcdVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(SalaryProjectCommissionRcdVOMeta.NOTES));
				this.setBatchCode( (String)map.get(SalaryProjectCommissionRcdVOMeta.BATCH_CODE));
				this.setUpdateTime( (Date)map.get(SalaryProjectCommissionRcdVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(SalaryProjectCommissionRcdVOMeta.VERSION));
				this.setCreateBy( (String)map.get(SalaryProjectCommissionRcdVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(SalaryProjectCommissionRcdVOMeta.DELETED));
				this.setProjectCode( (String)map.get(SalaryProjectCommissionRcdVOMeta.PROJECT_CODE));
				this.setFileIds( (String)map.get(SalaryProjectCommissionRcdVOMeta.FILE_IDS));
				this.setCreateTime( (Date)map.get(SalaryProjectCommissionRcdVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SalaryProjectCommissionRcdVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SalaryProjectCommissionRcdVOMeta.DELETE_TIME));
				this.setProjectCommissionRatio( (String)map.get(SalaryProjectCommissionRcdVOMeta.PROJECT_COMMISSION_RATIO));
				this.setRcdDate( (Date)map.get(SalaryProjectCommissionRcdVOMeta.RCD_DATE));
				this.setBusinessValue( (BigDecimal)map.get(SalaryProjectCommissionRcdVOMeta.BUSINESS_VALUE));
				this.setTenantId( (String)map.get(SalaryProjectCommissionRcdVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(SalaryProjectCommissionRcdVOMeta.DELETE_BY));
				this.setPersonId( (String)map.get(SalaryProjectCommissionRcdVOMeta.PERSON_ID));
				this.setId( (String)map.get(SalaryProjectCommissionRcdVOMeta.ID));
				this.setProjectName( (String)map.get(SalaryProjectCommissionRcdVOMeta.PROJECT_NAME));
				this.setCommissionSalary( (BigDecimal)map.get(SalaryProjectCommissionRcdVOMeta.COMMISSION_SALARY));
				this.setJobNumber( (String)map.get(SalaryProjectCommissionRcdVOMeta.JOB_NUMBER));
				// others
				this.setSearchField( (String)map.get(SalaryProjectCommissionRcdVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(SalaryProjectCommissionRcdVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(SalaryProjectCommissionRcdVOMeta.FUZZY_FIELD));
				this.setProject( (SalaryProjectCommission)map.get(SalaryProjectCommissionRcdVOMeta.PROJECT));
				this.setPageSize( (Integer)map.get(SalaryProjectCommissionRcdVOMeta.PAGE_SIZE));
				this.setPageIndex( (Integer)map.get(SalaryProjectCommissionRcdVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(SalaryProjectCommissionRcdVOMeta.SORT_TYPE));
				this.setPerson( (Person)map.get(SalaryProjectCommissionRcdVOMeta.PERSON));
				this.setProjectCodeValue( (String)map.get(SalaryProjectCommissionRcdVOMeta.PROJECT_CODE_VALUE));
				this.setSortField( (String)map.get(SalaryProjectCommissionRcdVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(SalaryProjectCommissionRcdVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(SalaryProjectCommissionRcdVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(SalaryProjectCommissionRcdVOMeta.SEARCH_VALUE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(SalaryProjectCommissionRcdVOMeta.NOTES)));
			this.setBatchCode(DataParser.parse(String.class, r.getValue(SalaryProjectCommissionRcdVOMeta.BATCH_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SalaryProjectCommissionRcdVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SalaryProjectCommissionRcdVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SalaryProjectCommissionRcdVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SalaryProjectCommissionRcdVOMeta.DELETED)));
			this.setProjectCode(DataParser.parse(String.class, r.getValue(SalaryProjectCommissionRcdVOMeta.PROJECT_CODE)));
			this.setFileIds(DataParser.parse(String.class, r.getValue(SalaryProjectCommissionRcdVOMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SalaryProjectCommissionRcdVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SalaryProjectCommissionRcdVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SalaryProjectCommissionRcdVOMeta.DELETE_TIME)));
			this.setProjectCommissionRatio(DataParser.parse(String.class, r.getValue(SalaryProjectCommissionRcdVOMeta.PROJECT_COMMISSION_RATIO)));
			this.setRcdDate(DataParser.parse(Date.class, r.getValue(SalaryProjectCommissionRcdVOMeta.RCD_DATE)));
			this.setBusinessValue(DataParser.parse(BigDecimal.class, r.getValue(SalaryProjectCommissionRcdVOMeta.BUSINESS_VALUE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SalaryProjectCommissionRcdVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SalaryProjectCommissionRcdVOMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(SalaryProjectCommissionRcdVOMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(SalaryProjectCommissionRcdVOMeta.ID)));
			this.setProjectName(DataParser.parse(String.class, r.getValue(SalaryProjectCommissionRcdVOMeta.PROJECT_NAME)));
			this.setCommissionSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryProjectCommissionRcdVOMeta.COMMISSION_SALARY)));
			this.setJobNumber(DataParser.parse(String.class, r.getValue(SalaryProjectCommissionRcdVOMeta.JOB_NUMBER)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(SalaryProjectCommissionRcdVOMeta.NOTES));
				this.setBatchCode( (String)r.getValue(SalaryProjectCommissionRcdVOMeta.BATCH_CODE));
				this.setUpdateTime( (Date)r.getValue(SalaryProjectCommissionRcdVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(SalaryProjectCommissionRcdVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(SalaryProjectCommissionRcdVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(SalaryProjectCommissionRcdVOMeta.DELETED));
				this.setProjectCode( (String)r.getValue(SalaryProjectCommissionRcdVOMeta.PROJECT_CODE));
				this.setFileIds( (String)r.getValue(SalaryProjectCommissionRcdVOMeta.FILE_IDS));
				this.setCreateTime( (Date)r.getValue(SalaryProjectCommissionRcdVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SalaryProjectCommissionRcdVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SalaryProjectCommissionRcdVOMeta.DELETE_TIME));
				this.setProjectCommissionRatio( (String)r.getValue(SalaryProjectCommissionRcdVOMeta.PROJECT_COMMISSION_RATIO));
				this.setRcdDate( (Date)r.getValue(SalaryProjectCommissionRcdVOMeta.RCD_DATE));
				this.setBusinessValue( (BigDecimal)r.getValue(SalaryProjectCommissionRcdVOMeta.BUSINESS_VALUE));
				this.setTenantId( (String)r.getValue(SalaryProjectCommissionRcdVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(SalaryProjectCommissionRcdVOMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(SalaryProjectCommissionRcdVOMeta.PERSON_ID));
				this.setId( (String)r.getValue(SalaryProjectCommissionRcdVOMeta.ID));
				this.setProjectName( (String)r.getValue(SalaryProjectCommissionRcdVOMeta.PROJECT_NAME));
				this.setCommissionSalary( (BigDecimal)r.getValue(SalaryProjectCommissionRcdVOMeta.COMMISSION_SALARY));
				this.setJobNumber( (String)r.getValue(SalaryProjectCommissionRcdVOMeta.JOB_NUMBER));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}