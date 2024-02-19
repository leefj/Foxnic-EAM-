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
import com.dt.platform.domain.hr.meta.RecruitmentPlanApplyVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 招聘计划申请VO类型
 * <p>招聘计划申请 , 数据表 hr_recruitment_plan_apply 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-19 15:58:49
 * @sign 5F2EC5CF074A5A803B4F65F206FCE151
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "招聘计划申请VO类型 ; 招聘计划申请 , 数据表 hr_recruitment_plan_apply 的通用VO类型" , parent = RecruitmentPlanApply.class)
public class RecruitmentPlanApplyVO extends RecruitmentPlanApply {

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
	public RecruitmentPlanApplyVO setPageIndex(Integer pageIndex) {
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
	public RecruitmentPlanApplyVO setPageSize(Integer pageSize) {
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
	public RecruitmentPlanApplyVO setSearchField(String searchField) {
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
	public RecruitmentPlanApplyVO setFuzzyField(String fuzzyField) {
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
	public RecruitmentPlanApplyVO setSearchValue(String searchValue) {
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
	public RecruitmentPlanApplyVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public RecruitmentPlanApplyVO addDirtyField(String... dirtyField) {
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
	public RecruitmentPlanApplyVO setSortField(String sortField) {
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
	public RecruitmentPlanApplyVO setSortType(String sortType) {
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
	public RecruitmentPlanApplyVO setDataOrigin(String dataOrigin) {
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
	public RecruitmentPlanApplyVO setQueryLogic(String queryLogic) {
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
	public RecruitmentPlanApplyVO setRequestAction(String requestAction) {
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
	public RecruitmentPlanApplyVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public RecruitmentPlanApplyVO addId(String... id) {
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
	 * @return RecruitmentPlanApplyVO , 转换好的 RecruitmentPlanApplyVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RecruitmentPlanApplyVO , 转换好的 PoJo 对象
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
	public RecruitmentPlanApplyVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public RecruitmentPlanApplyVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.RecruitmentPlanApplyVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.RecruitmentPlanApplyVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setWorkContent(this.getWorkContent());
		inst.setTitle(this.getTitle());
		inst.setSalary(this.getSalary());
		inst.setPersonNumber(this.getPersonNumber());
		inst.setOrgId(this.getOrgId());
		inst.setApplyUserId(this.getApplyUserId());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setPos(this.getPos());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setSdate(this.getSdate());
		inst.setMethod(this.getMethod());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setEdate(this.getEdate());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setProcessCode(this.getProcessCode());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		inst.setJobRequirement(this.getJobRequirement());
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
	public RecruitmentPlanApplyVO clone(boolean deep) {
		return EntityContext.clone(RecruitmentPlanApplyVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 RecruitmentPlanApplyVO
	 * @param recruitmentPlanApplyMap 包含实体信息的 Map 对象
	 * @return RecruitmentPlanApplyVO , 转换好的的 RecruitmentPlanApply 对象
	*/
	@Transient
	public static RecruitmentPlanApplyVO createFrom(Map<String,Object> recruitmentPlanApplyMap) {
		if(recruitmentPlanApplyMap==null) return null;
		RecruitmentPlanApplyVO vo = create();
		EntityContext.copyProperties(vo,recruitmentPlanApplyMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 RecruitmentPlanApplyVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RecruitmentPlanApplyVO , 转换好的的 RecruitmentPlanApply 对象
	*/
	@Transient
	public static RecruitmentPlanApplyVO createFrom(Object pojo) {
		if(pojo==null) return null;
		RecruitmentPlanApplyVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 RecruitmentPlanApplyVO，等同于 new
	 * @return RecruitmentPlanApplyVO 对象
	*/
	@Transient
	public static RecruitmentPlanApplyVO create() {
		return new com.dt.platform.domain.hr.meta.RecruitmentPlanApplyVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.NOTES)));
			this.setWorkContent(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.WORK_CONTENT)));
			this.setTitle(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.TITLE)));
			this.setSalary(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.SALARY)));
			this.setPersonNumber(DataParser.parse(Integer.class, map.get(RecruitmentPlanApplyVOMeta.PERSON_NUMBER)));
			this.setOrgId(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.ORG_ID)));
			this.setApplyUserId(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.APPLY_USER_ID)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.BUSINESS_CODE)));
			this.setPos(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.POS)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.ID)));
			this.setSdate(DataParser.parse(Date.class, map.get(RecruitmentPlanApplyVOMeta.SDATE)));
			this.setMethod(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.METHOD)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(RecruitmentPlanApplyVOMeta.UPDATE_TIME)));
			this.setEdate(DataParser.parse(Date.class, map.get(RecruitmentPlanApplyVOMeta.EDATE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(RecruitmentPlanApplyVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(RecruitmentPlanApplyVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(RecruitmentPlanApplyVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(RecruitmentPlanApplyVOMeta.DELETE_TIME)));
			this.setProcessCode(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.PROCESS_CODE)));
			this.setTenantId(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.STATUS)));
			this.setJobRequirement(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.JOB_REQUIREMENT)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(RecruitmentPlanApplyVOMeta.PAGE_SIZE)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(RecruitmentPlanApplyVOMeta.DEFAULT_PROCESS)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(RecruitmentPlanApplyVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.SORT_TYPE)));
			this.setPerson(DataParser.parse(Employee.class, map.get(RecruitmentPlanApplyVOMeta.PERSON)));
			this.setOrganization(DataParser.parse(Organization.class, map.get(RecruitmentPlanApplyVOMeta.ORGANIZATION)));
			this.setSortField(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(RecruitmentPlanApplyVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(RecruitmentPlanApplyVOMeta.NOTES));
				this.setWorkContent( (String)map.get(RecruitmentPlanApplyVOMeta.WORK_CONTENT));
				this.setTitle( (String)map.get(RecruitmentPlanApplyVOMeta.TITLE));
				this.setSalary( (String)map.get(RecruitmentPlanApplyVOMeta.SALARY));
				this.setPersonNumber( (Integer)map.get(RecruitmentPlanApplyVOMeta.PERSON_NUMBER));
				this.setOrgId( (String)map.get(RecruitmentPlanApplyVOMeta.ORG_ID));
				this.setApplyUserId( (String)map.get(RecruitmentPlanApplyVOMeta.APPLY_USER_ID));
				this.setBusinessCode( (String)map.get(RecruitmentPlanApplyVOMeta.BUSINESS_CODE));
				this.setPos( (String)map.get(RecruitmentPlanApplyVOMeta.POS));
				this.setUpdateBy( (String)map.get(RecruitmentPlanApplyVOMeta.UPDATE_BY));
				this.setId( (String)map.get(RecruitmentPlanApplyVOMeta.ID));
				this.setSdate( (Date)map.get(RecruitmentPlanApplyVOMeta.SDATE));
				this.setMethod( (String)map.get(RecruitmentPlanApplyVOMeta.METHOD));
				this.setUpdateTime( (Date)map.get(RecruitmentPlanApplyVOMeta.UPDATE_TIME));
				this.setEdate( (Date)map.get(RecruitmentPlanApplyVOMeta.EDATE));
				this.setVersion( (Integer)map.get(RecruitmentPlanApplyVOMeta.VERSION));
				this.setCreateBy( (String)map.get(RecruitmentPlanApplyVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(RecruitmentPlanApplyVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(RecruitmentPlanApplyVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(RecruitmentPlanApplyVOMeta.DELETE_TIME));
				this.setProcessCode( (String)map.get(RecruitmentPlanApplyVOMeta.PROCESS_CODE));
				this.setTenantId( (String)map.get(RecruitmentPlanApplyVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(RecruitmentPlanApplyVOMeta.DELETE_BY));
				this.setStatus( (String)map.get(RecruitmentPlanApplyVOMeta.STATUS));
				this.setJobRequirement( (String)map.get(RecruitmentPlanApplyVOMeta.JOB_REQUIREMENT));
				// others
				this.setSearchField( (String)map.get(RecruitmentPlanApplyVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(RecruitmentPlanApplyVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(RecruitmentPlanApplyVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(RecruitmentPlanApplyVOMeta.PAGE_SIZE));
				this.setDefaultProcess( (ProcessInstance)map.get(RecruitmentPlanApplyVOMeta.DEFAULT_PROCESS));
				this.setPageIndex( (Integer)map.get(RecruitmentPlanApplyVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(RecruitmentPlanApplyVOMeta.SORT_TYPE));
				this.setPerson( (Employee)map.get(RecruitmentPlanApplyVOMeta.PERSON));
				this.setOrganization( (Organization)map.get(RecruitmentPlanApplyVOMeta.ORGANIZATION));
				this.setSortField( (String)map.get(RecruitmentPlanApplyVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(RecruitmentPlanApplyVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(RecruitmentPlanApplyVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(RecruitmentPlanApplyVOMeta.SEARCH_VALUE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(RecruitmentPlanApplyVOMeta.NOTES)));
			this.setWorkContent(DataParser.parse(String.class, r.getValue(RecruitmentPlanApplyVOMeta.WORK_CONTENT)));
			this.setTitle(DataParser.parse(String.class, r.getValue(RecruitmentPlanApplyVOMeta.TITLE)));
			this.setSalary(DataParser.parse(String.class, r.getValue(RecruitmentPlanApplyVOMeta.SALARY)));
			this.setPersonNumber(DataParser.parse(Integer.class, r.getValue(RecruitmentPlanApplyVOMeta.PERSON_NUMBER)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(RecruitmentPlanApplyVOMeta.ORG_ID)));
			this.setApplyUserId(DataParser.parse(String.class, r.getValue(RecruitmentPlanApplyVOMeta.APPLY_USER_ID)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(RecruitmentPlanApplyVOMeta.BUSINESS_CODE)));
			this.setPos(DataParser.parse(String.class, r.getValue(RecruitmentPlanApplyVOMeta.POS)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(RecruitmentPlanApplyVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(RecruitmentPlanApplyVOMeta.ID)));
			this.setSdate(DataParser.parse(Date.class, r.getValue(RecruitmentPlanApplyVOMeta.SDATE)));
			this.setMethod(DataParser.parse(String.class, r.getValue(RecruitmentPlanApplyVOMeta.METHOD)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(RecruitmentPlanApplyVOMeta.UPDATE_TIME)));
			this.setEdate(DataParser.parse(Date.class, r.getValue(RecruitmentPlanApplyVOMeta.EDATE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(RecruitmentPlanApplyVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(RecruitmentPlanApplyVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(RecruitmentPlanApplyVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(RecruitmentPlanApplyVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(RecruitmentPlanApplyVOMeta.DELETE_TIME)));
			this.setProcessCode(DataParser.parse(String.class, r.getValue(RecruitmentPlanApplyVOMeta.PROCESS_CODE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(RecruitmentPlanApplyVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(RecruitmentPlanApplyVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(RecruitmentPlanApplyVOMeta.STATUS)));
			this.setJobRequirement(DataParser.parse(String.class, r.getValue(RecruitmentPlanApplyVOMeta.JOB_REQUIREMENT)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(RecruitmentPlanApplyVOMeta.NOTES));
				this.setWorkContent( (String)r.getValue(RecruitmentPlanApplyVOMeta.WORK_CONTENT));
				this.setTitle( (String)r.getValue(RecruitmentPlanApplyVOMeta.TITLE));
				this.setSalary( (String)r.getValue(RecruitmentPlanApplyVOMeta.SALARY));
				this.setPersonNumber( (Integer)r.getValue(RecruitmentPlanApplyVOMeta.PERSON_NUMBER));
				this.setOrgId( (String)r.getValue(RecruitmentPlanApplyVOMeta.ORG_ID));
				this.setApplyUserId( (String)r.getValue(RecruitmentPlanApplyVOMeta.APPLY_USER_ID));
				this.setBusinessCode( (String)r.getValue(RecruitmentPlanApplyVOMeta.BUSINESS_CODE));
				this.setPos( (String)r.getValue(RecruitmentPlanApplyVOMeta.POS));
				this.setUpdateBy( (String)r.getValue(RecruitmentPlanApplyVOMeta.UPDATE_BY));
				this.setId( (String)r.getValue(RecruitmentPlanApplyVOMeta.ID));
				this.setSdate( (Date)r.getValue(RecruitmentPlanApplyVOMeta.SDATE));
				this.setMethod( (String)r.getValue(RecruitmentPlanApplyVOMeta.METHOD));
				this.setUpdateTime( (Date)r.getValue(RecruitmentPlanApplyVOMeta.UPDATE_TIME));
				this.setEdate( (Date)r.getValue(RecruitmentPlanApplyVOMeta.EDATE));
				this.setVersion( (Integer)r.getValue(RecruitmentPlanApplyVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(RecruitmentPlanApplyVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(RecruitmentPlanApplyVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(RecruitmentPlanApplyVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(RecruitmentPlanApplyVOMeta.DELETE_TIME));
				this.setProcessCode( (String)r.getValue(RecruitmentPlanApplyVOMeta.PROCESS_CODE));
				this.setTenantId( (String)r.getValue(RecruitmentPlanApplyVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(RecruitmentPlanApplyVOMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(RecruitmentPlanApplyVOMeta.STATUS));
				this.setJobRequirement( (String)r.getValue(RecruitmentPlanApplyVOMeta.JOB_REQUIREMENT));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}