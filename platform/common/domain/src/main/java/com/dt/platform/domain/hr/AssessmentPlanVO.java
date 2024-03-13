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
import com.dt.platform.domain.hr.meta.AssessmentPlanVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考核计划VO类型
 * <p>考核计划 , 数据表 hr_assessment_plan 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-10 15:10:35
 * @sign 6C64A7624E90FE86529E9455D952E103
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "考核计划VO类型 ; 考核计划 , 数据表 hr_assessment_plan 的通用VO类型" , parent = AssessmentPlan.class)
public class AssessmentPlanVO extends AssessmentPlan {

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
	public AssessmentPlanVO setPageIndex(Integer pageIndex) {
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
	public AssessmentPlanVO setPageSize(Integer pageSize) {
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
	public AssessmentPlanVO setSearchField(String searchField) {
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
	public AssessmentPlanVO setFuzzyField(String fuzzyField) {
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
	public AssessmentPlanVO setSearchValue(String searchValue) {
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
	public AssessmentPlanVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssessmentPlanVO addDirtyField(String... dirtyField) {
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
	public AssessmentPlanVO setSortField(String sortField) {
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
	public AssessmentPlanVO setSortType(String sortType) {
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
	public AssessmentPlanVO setDataOrigin(String dataOrigin) {
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
	public AssessmentPlanVO setQueryLogic(String queryLogic) {
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
	public AssessmentPlanVO setRequestAction(String requestAction) {
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
	public AssessmentPlanVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssessmentPlanVO addId(String... id) {
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
	 * @return AssessmentPlanVO , 转换好的 AssessmentPlanVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssessmentPlanVO , 转换好的 PoJo 对象
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
	public AssessmentPlanVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssessmentPlanVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AssessmentPlanVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AssessmentPlanVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setMethod(this.getMethod());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setAssessorSecondId(this.getAssessorSecondId());
		inst.setCycle(this.getCycle());
		inst.setVersion(this.getVersion());
		inst.setAssesseeId(this.getAssesseeId());
		inst.setPosId(this.getPosId());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssessorId(this.getAssessorId());
		inst.setName(this.getName());
		inst.setTotalWeight(this.getTotalWeight());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTplId(this.getTplId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setAssesseeUser(this.getAssesseeUser());
			inst.setAssessorUser(this.getAssessorUser());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setHistoricProcessList(this.getHistoricProcessList());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setCurrentProcessList(this.getCurrentProcessList());
			inst.setDefaultProcess(this.getDefaultProcess());
			inst.setAssessmentIndicatorList(this.getAssessmentIndicatorList());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setAssessmentTpl(this.getAssessmentTpl());
			inst.setButtonAction(this.getButtonAction());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssessmentPlanVO clone(boolean deep) {
		return EntityContext.clone(AssessmentPlanVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssessmentPlanVO
	 * @param assessmentPlanMap 包含实体信息的 Map 对象
	 * @return AssessmentPlanVO , 转换好的的 AssessmentPlan 对象
	*/
	@Transient
	public static AssessmentPlanVO createFrom(Map<String,Object> assessmentPlanMap) {
		if(assessmentPlanMap==null) return null;
		AssessmentPlanVO vo = create();
		EntityContext.copyProperties(vo,assessmentPlanMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssessmentPlanVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssessmentPlanVO , 转换好的的 AssessmentPlan 对象
	*/
	@Transient
	public static AssessmentPlanVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssessmentPlanVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssessmentPlanVO，等同于 new
	 * @return AssessmentPlanVO 对象
	*/
	@Transient
	public static AssessmentPlanVO create() {
		return new com.dt.platform.domain.hr.meta.AssessmentPlanVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.NOTES)));
			this.setMethod(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.METHOD)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentPlanVOMeta.UPDATE_TIME)));
			this.setAssessorSecondId(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.ASSESSOR_SECOND_ID)));
			this.setCycle(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.CYCLE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssessmentPlanVOMeta.VERSION)));
			this.setAssesseeId(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.ASSESSEE_ID)));
			this.setPosId(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.POS_ID)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssessmentPlanVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssessmentPlanVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssessmentPlanVOMeta.DELETE_TIME)));
			this.setAssessorId(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.ASSESSOR_ID)));
			this.setName(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.NAME)));
			this.setTotalWeight(DataParser.parse(BigDecimal.class, map.get(AssessmentPlanVOMeta.TOTAL_WEIGHT)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.ID)));
			this.setTplId(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.TPL_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.STATUS)));
			// others
			this.setAssesseeUser(DataParser.parse(Person.class, map.get(AssessmentPlanVOMeta.ASSESSEE_USER)));
			this.setAssessorUser(DataParser.parse(Person.class, map.get(AssessmentPlanVOMeta.ASSESSOR_USER)));
			this.setSearchField(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssessmentPlanVOMeta.PAGE_SIZE)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.SELECTED_CODE)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(AssessmentPlanVOMeta.DEFAULT_PROCESS)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssessmentPlanVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.QUERY_LOGIC)));
			this.setAssessmentTpl(DataParser.parse(AssessmentTpl.class, map.get(AssessmentPlanVOMeta.ASSESSMENT_TPL)));
			this.setButtonAction(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.BUTTON_ACTION)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssessmentPlanVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AssessmentPlanVOMeta.NOTES));
				this.setMethod( (String)map.get(AssessmentPlanVOMeta.METHOD));
				this.setUpdateTime( (Date)map.get(AssessmentPlanVOMeta.UPDATE_TIME));
				this.setAssessorSecondId( (String)map.get(AssessmentPlanVOMeta.ASSESSOR_SECOND_ID));
				this.setCycle( (String)map.get(AssessmentPlanVOMeta.CYCLE));
				this.setVersion( (Integer)map.get(AssessmentPlanVOMeta.VERSION));
				this.setAssesseeId( (String)map.get(AssessmentPlanVOMeta.ASSESSEE_ID));
				this.setPosId( (String)map.get(AssessmentPlanVOMeta.POS_ID));
				this.setBusinessCode( (String)map.get(AssessmentPlanVOMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(AssessmentPlanVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssessmentPlanVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssessmentPlanVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssessmentPlanVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssessmentPlanVOMeta.DELETE_TIME));
				this.setAssessorId( (String)map.get(AssessmentPlanVOMeta.ASSESSOR_ID));
				this.setName( (String)map.get(AssessmentPlanVOMeta.NAME));
				this.setTotalWeight( (BigDecimal)map.get(AssessmentPlanVOMeta.TOTAL_WEIGHT));
				this.setTenantId( (String)map.get(AssessmentPlanVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssessmentPlanVOMeta.DELETE_BY));
				this.setId( (String)map.get(AssessmentPlanVOMeta.ID));
				this.setTplId( (String)map.get(AssessmentPlanVOMeta.TPL_ID));
				this.setStatus( (String)map.get(AssessmentPlanVOMeta.STATUS));
				// others
				this.setAssesseeUser( (Person)map.get(AssessmentPlanVOMeta.ASSESSEE_USER));
				this.setAssessorUser( (Person)map.get(AssessmentPlanVOMeta.ASSESSOR_USER));
				this.setSearchField( (String)map.get(AssessmentPlanVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(AssessmentPlanVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(AssessmentPlanVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssessmentPlanVOMeta.PAGE_SIZE));
				this.setSelectedCode( (String)map.get(AssessmentPlanVOMeta.SELECTED_CODE));
				this.setDefaultProcess( (ProcessInstance)map.get(AssessmentPlanVOMeta.DEFAULT_PROCESS));
				this.setPageIndex( (Integer)map.get(AssessmentPlanVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssessmentPlanVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(AssessmentPlanVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(AssessmentPlanVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(AssessmentPlanVOMeta.QUERY_LOGIC));
				this.setAssessmentTpl( (AssessmentTpl)map.get(AssessmentPlanVOMeta.ASSESSMENT_TPL));
				this.setButtonAction( (String)map.get(AssessmentPlanVOMeta.BUTTON_ACTION));
				this.setSearchValue( (String)map.get(AssessmentPlanVOMeta.SEARCH_VALUE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AssessmentPlanVOMeta.NOTES)));
			this.setMethod(DataParser.parse(String.class, r.getValue(AssessmentPlanVOMeta.METHOD)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentPlanVOMeta.UPDATE_TIME)));
			this.setAssessorSecondId(DataParser.parse(String.class, r.getValue(AssessmentPlanVOMeta.ASSESSOR_SECOND_ID)));
			this.setCycle(DataParser.parse(String.class, r.getValue(AssessmentPlanVOMeta.CYCLE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssessmentPlanVOMeta.VERSION)));
			this.setAssesseeId(DataParser.parse(String.class, r.getValue(AssessmentPlanVOMeta.ASSESSEE_ID)));
			this.setPosId(DataParser.parse(String.class, r.getValue(AssessmentPlanVOMeta.POS_ID)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssessmentPlanVOMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssessmentPlanVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssessmentPlanVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssessmentPlanVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssessmentPlanVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssessmentPlanVOMeta.DELETE_TIME)));
			this.setAssessorId(DataParser.parse(String.class, r.getValue(AssessmentPlanVOMeta.ASSESSOR_ID)));
			this.setName(DataParser.parse(String.class, r.getValue(AssessmentPlanVOMeta.NAME)));
			this.setTotalWeight(DataParser.parse(BigDecimal.class, r.getValue(AssessmentPlanVOMeta.TOTAL_WEIGHT)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssessmentPlanVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssessmentPlanVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssessmentPlanVOMeta.ID)));
			this.setTplId(DataParser.parse(String.class, r.getValue(AssessmentPlanVOMeta.TPL_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssessmentPlanVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AssessmentPlanVOMeta.NOTES));
				this.setMethod( (String)r.getValue(AssessmentPlanVOMeta.METHOD));
				this.setUpdateTime( (Date)r.getValue(AssessmentPlanVOMeta.UPDATE_TIME));
				this.setAssessorSecondId( (String)r.getValue(AssessmentPlanVOMeta.ASSESSOR_SECOND_ID));
				this.setCycle( (String)r.getValue(AssessmentPlanVOMeta.CYCLE));
				this.setVersion( (Integer)r.getValue(AssessmentPlanVOMeta.VERSION));
				this.setAssesseeId( (String)r.getValue(AssessmentPlanVOMeta.ASSESSEE_ID));
				this.setPosId( (String)r.getValue(AssessmentPlanVOMeta.POS_ID));
				this.setBusinessCode( (String)r.getValue(AssessmentPlanVOMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(AssessmentPlanVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssessmentPlanVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssessmentPlanVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssessmentPlanVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssessmentPlanVOMeta.DELETE_TIME));
				this.setAssessorId( (String)r.getValue(AssessmentPlanVOMeta.ASSESSOR_ID));
				this.setName( (String)r.getValue(AssessmentPlanVOMeta.NAME));
				this.setTotalWeight( (BigDecimal)r.getValue(AssessmentPlanVOMeta.TOTAL_WEIGHT));
				this.setTenantId( (String)r.getValue(AssessmentPlanVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssessmentPlanVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssessmentPlanVOMeta.ID));
				this.setTplId( (String)r.getValue(AssessmentPlanVOMeta.TPL_ID));
				this.setStatus( (String)r.getValue(AssessmentPlanVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}