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
import com.dt.platform.domain.hr.meta.AssessmentTaskVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考核任务VO类型
 * <p>考核任务 , 数据表 hr_assessment_task 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-14 07:22:53
 * @sign 216B4531EC5B295012D06E8F075C75F2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "考核任务VO类型 ; 考核任务 , 数据表 hr_assessment_task 的通用VO类型" , parent = AssessmentTask.class)
public class AssessmentTaskVO extends AssessmentTask {

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
	public AssessmentTaskVO setPageIndex(Integer pageIndex) {
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
	public AssessmentTaskVO setPageSize(Integer pageSize) {
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
	public AssessmentTaskVO setSearchField(String searchField) {
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
	public AssessmentTaskVO setFuzzyField(String fuzzyField) {
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
	public AssessmentTaskVO setSearchValue(String searchValue) {
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
	public AssessmentTaskVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssessmentTaskVO addDirtyField(String... dirtyField) {
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
	public AssessmentTaskVO setSortField(String sortField) {
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
	public AssessmentTaskVO setSortType(String sortType) {
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
	public AssessmentTaskVO setDataOrigin(String dataOrigin) {
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
	public AssessmentTaskVO setQueryLogic(String queryLogic) {
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
	public AssessmentTaskVO setRequestAction(String requestAction) {
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
	public AssessmentTaskVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssessmentTaskVO addId(String... id) {
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
	 * @return AssessmentTaskVO , 转换好的 AssessmentTaskVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssessmentTaskVO , 转换好的 PoJo 对象
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
	public AssessmentTaskVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssessmentTaskVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AssessmentTaskVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AssessmentTaskVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setLeaderWeigth(this.getLeaderWeigth());
		inst.setSource(this.getSource());
		inst.setType(this.getType());
		inst.setCycle(this.getCycle());
		inst.setSecondWeight(this.getSecondWeight());
		inst.setHasSelfAssessment(this.getHasSelfAssessment());
		inst.setHasLeaderAssessment(this.getHasLeaderAssessment());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setIsAllPerson(this.getIsAllPerson());
		inst.setOwner(this.getOwner());
		inst.setHrUserId(this.getHrUserId());
		inst.setSelfWeigth(this.getSelfWeigth());
		inst.setHasHrConfirm(this.getHasHrConfirm());
		inst.setHasSecondLeaderAssessment(this.getHasSecondLeaderAssessment());
		inst.setHasSameAssessment(this.getHasSameAssessment());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setAssessmenMethod(this.getAssessmenMethod());
		inst.setSameWeigth(this.getSameWeigth());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTotalWeight(this.getTotalWeight());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setTplId(this.getTplId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setPositionIds(this.getPositionIds());
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setOrganizationList(this.getOrganizationList());
			inst.setPageSize(this.getPageSize());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setHrUser(this.getHrUser());
			inst.setAssessmentIndicatorList(this.getAssessmentIndicatorList());
			inst.setOrganizationIds(this.getOrganizationIds());
			inst.setExcludePersonIds(this.getExcludePersonIds());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setExcludePersonList(this.getExcludePersonList());
			inst.setPositionList(this.getPositionList());
			inst.setPersonList(this.getPersonList());
			inst.setRequestAction(this.getRequestAction());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setTypeDict(this.getTypeDict());
			inst.setPersonIds(this.getPersonIds());
			inst.setIds(this.getIds());
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
	public AssessmentTaskVO clone(boolean deep) {
		return EntityContext.clone(AssessmentTaskVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssessmentTaskVO
	 * @param assessmentTaskMap 包含实体信息的 Map 对象
	 * @return AssessmentTaskVO , 转换好的的 AssessmentTask 对象
	*/
	@Transient
	public static AssessmentTaskVO createFrom(Map<String,Object> assessmentTaskMap) {
		if(assessmentTaskMap==null) return null;
		AssessmentTaskVO vo = create();
		EntityContext.copyProperties(vo,assessmentTaskMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssessmentTaskVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssessmentTaskVO , 转换好的的 AssessmentTask 对象
	*/
	@Transient
	public static AssessmentTaskVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssessmentTaskVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssessmentTaskVO，等同于 new
	 * @return AssessmentTaskVO 对象
	*/
	@Transient
	public static AssessmentTaskVO create() {
		return new com.dt.platform.domain.hr.meta.AssessmentTaskVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.NOTES)));
			this.setLeaderWeigth(DataParser.parse(Integer.class, map.get(AssessmentTaskVOMeta.LEADER_WEIGTH)));
			this.setSource(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.SOURCE)));
			this.setType(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.TYPE)));
			this.setCycle(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.CYCLE)));
			this.setSecondWeight(DataParser.parse(Integer.class, map.get(AssessmentTaskVOMeta.SECOND_WEIGHT)));
			this.setHasSelfAssessment(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.HAS_SELF_ASSESSMENT)));
			this.setHasLeaderAssessment(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.HAS_LEADER_ASSESSMENT)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.ID)));
			this.setIsAllPerson(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.IS_ALL_PERSON)));
			this.setOwner(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.OWNER)));
			this.setHrUserId(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.HR_USER_ID)));
			this.setSelfWeigth(DataParser.parse(Integer.class, map.get(AssessmentTaskVOMeta.SELF_WEIGTH)));
			this.setHasHrConfirm(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.HAS_HR_CONFIRM)));
			this.setHasSecondLeaderAssessment(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.HAS_SECOND_LEADER_ASSESSMENT)));
			this.setHasSameAssessment(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.HAS_SAME_ASSESSMENT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentTaskVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssessmentTaskVOMeta.VERSION)));
			this.setAssessmenMethod(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.ASSESSMEN_METHOD)));
			this.setSameWeigth(DataParser.parse(Integer.class, map.get(AssessmentTaskVOMeta.SAME_WEIGTH)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssessmentTaskVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssessmentTaskVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssessmentTaskVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.NAME)));
			this.setTotalWeight(DataParser.parse(BigDecimal.class, map.get(AssessmentTaskVOMeta.TOTAL_WEIGHT)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.DELETE_BY)));
			this.setTplId(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.TPL_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssessmentTaskVOMeta.PAGE_SIZE)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.SELECTED_CODE)));
			this.setHrUser(DataParser.parse(Employee.class, map.get(AssessmentTaskVOMeta.HR_USER)));
			this.setSortField(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.QUERY_LOGIC)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.REQUEST_ACTION)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssessmentTaskVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.SORT_TYPE)));
			this.setTypeDict(DataParser.parse(DictItem.class, map.get(AssessmentTaskVOMeta.TYPE_DICT)));
			this.setAssessmentTpl(DataParser.parse(AssessmentTpl.class, map.get(AssessmentTaskVOMeta.ASSESSMENT_TPL)));
			this.setButtonAction(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.BUTTON_ACTION)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssessmentTaskVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AssessmentTaskVOMeta.NOTES));
				this.setLeaderWeigth( (Integer)map.get(AssessmentTaskVOMeta.LEADER_WEIGTH));
				this.setSource( (String)map.get(AssessmentTaskVOMeta.SOURCE));
				this.setType( (String)map.get(AssessmentTaskVOMeta.TYPE));
				this.setCycle( (String)map.get(AssessmentTaskVOMeta.CYCLE));
				this.setSecondWeight( (Integer)map.get(AssessmentTaskVOMeta.SECOND_WEIGHT));
				this.setHasSelfAssessment( (String)map.get(AssessmentTaskVOMeta.HAS_SELF_ASSESSMENT));
				this.setHasLeaderAssessment( (String)map.get(AssessmentTaskVOMeta.HAS_LEADER_ASSESSMENT));
				this.setUpdateBy( (String)map.get(AssessmentTaskVOMeta.UPDATE_BY));
				this.setId( (String)map.get(AssessmentTaskVOMeta.ID));
				this.setIsAllPerson( (String)map.get(AssessmentTaskVOMeta.IS_ALL_PERSON));
				this.setOwner( (String)map.get(AssessmentTaskVOMeta.OWNER));
				this.setHrUserId( (String)map.get(AssessmentTaskVOMeta.HR_USER_ID));
				this.setSelfWeigth( (Integer)map.get(AssessmentTaskVOMeta.SELF_WEIGTH));
				this.setHasHrConfirm( (String)map.get(AssessmentTaskVOMeta.HAS_HR_CONFIRM));
				this.setHasSecondLeaderAssessment( (String)map.get(AssessmentTaskVOMeta.HAS_SECOND_LEADER_ASSESSMENT));
				this.setHasSameAssessment( (String)map.get(AssessmentTaskVOMeta.HAS_SAME_ASSESSMENT));
				this.setUpdateTime( (Date)map.get(AssessmentTaskVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssessmentTaskVOMeta.VERSION));
				this.setAssessmenMethod( (String)map.get(AssessmentTaskVOMeta.ASSESSMEN_METHOD));
				this.setSameWeigth( (Integer)map.get(AssessmentTaskVOMeta.SAME_WEIGTH));
				this.setCreateBy( (String)map.get(AssessmentTaskVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssessmentTaskVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssessmentTaskVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssessmentTaskVOMeta.DELETE_TIME));
				this.setName( (String)map.get(AssessmentTaskVOMeta.NAME));
				this.setTotalWeight( (BigDecimal)map.get(AssessmentTaskVOMeta.TOTAL_WEIGHT));
				this.setTenantId( (String)map.get(AssessmentTaskVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssessmentTaskVOMeta.DELETE_BY));
				this.setTplId( (String)map.get(AssessmentTaskVOMeta.TPL_ID));
				this.setStatus( (String)map.get(AssessmentTaskVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(AssessmentTaskVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(AssessmentTaskVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssessmentTaskVOMeta.PAGE_SIZE));
				this.setSelectedCode( (String)map.get(AssessmentTaskVOMeta.SELECTED_CODE));
				this.setHrUser( (Employee)map.get(AssessmentTaskVOMeta.HR_USER));
				this.setSortField( (String)map.get(AssessmentTaskVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(AssessmentTaskVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(AssessmentTaskVOMeta.QUERY_LOGIC));
				this.setRequestAction( (String)map.get(AssessmentTaskVOMeta.REQUEST_ACTION));
				this.setPageIndex( (Integer)map.get(AssessmentTaskVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssessmentTaskVOMeta.SORT_TYPE));
				this.setTypeDict( (DictItem)map.get(AssessmentTaskVOMeta.TYPE_DICT));
				this.setAssessmentTpl( (AssessmentTpl)map.get(AssessmentTaskVOMeta.ASSESSMENT_TPL));
				this.setButtonAction( (String)map.get(AssessmentTaskVOMeta.BUTTON_ACTION));
				this.setSearchValue( (String)map.get(AssessmentTaskVOMeta.SEARCH_VALUE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.NOTES)));
			this.setLeaderWeigth(DataParser.parse(Integer.class, r.getValue(AssessmentTaskVOMeta.LEADER_WEIGTH)));
			this.setSource(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.SOURCE)));
			this.setType(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.TYPE)));
			this.setCycle(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.CYCLE)));
			this.setSecondWeight(DataParser.parse(Integer.class, r.getValue(AssessmentTaskVOMeta.SECOND_WEIGHT)));
			this.setHasSelfAssessment(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.HAS_SELF_ASSESSMENT)));
			this.setHasLeaderAssessment(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.HAS_LEADER_ASSESSMENT)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.ID)));
			this.setIsAllPerson(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.IS_ALL_PERSON)));
			this.setOwner(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.OWNER)));
			this.setHrUserId(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.HR_USER_ID)));
			this.setSelfWeigth(DataParser.parse(Integer.class, r.getValue(AssessmentTaskVOMeta.SELF_WEIGTH)));
			this.setHasHrConfirm(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.HAS_HR_CONFIRM)));
			this.setHasSecondLeaderAssessment(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.HAS_SECOND_LEADER_ASSESSMENT)));
			this.setHasSameAssessment(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.HAS_SAME_ASSESSMENT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentTaskVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssessmentTaskVOMeta.VERSION)));
			this.setAssessmenMethod(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.ASSESSMEN_METHOD)));
			this.setSameWeigth(DataParser.parse(Integer.class, r.getValue(AssessmentTaskVOMeta.SAME_WEIGTH)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssessmentTaskVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssessmentTaskVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssessmentTaskVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.NAME)));
			this.setTotalWeight(DataParser.parse(BigDecimal.class, r.getValue(AssessmentTaskVOMeta.TOTAL_WEIGHT)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.DELETE_BY)));
			this.setTplId(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.TPL_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssessmentTaskVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AssessmentTaskVOMeta.NOTES));
				this.setLeaderWeigth( (Integer)r.getValue(AssessmentTaskVOMeta.LEADER_WEIGTH));
				this.setSource( (String)r.getValue(AssessmentTaskVOMeta.SOURCE));
				this.setType( (String)r.getValue(AssessmentTaskVOMeta.TYPE));
				this.setCycle( (String)r.getValue(AssessmentTaskVOMeta.CYCLE));
				this.setSecondWeight( (Integer)r.getValue(AssessmentTaskVOMeta.SECOND_WEIGHT));
				this.setHasSelfAssessment( (String)r.getValue(AssessmentTaskVOMeta.HAS_SELF_ASSESSMENT));
				this.setHasLeaderAssessment( (String)r.getValue(AssessmentTaskVOMeta.HAS_LEADER_ASSESSMENT));
				this.setUpdateBy( (String)r.getValue(AssessmentTaskVOMeta.UPDATE_BY));
				this.setId( (String)r.getValue(AssessmentTaskVOMeta.ID));
				this.setIsAllPerson( (String)r.getValue(AssessmentTaskVOMeta.IS_ALL_PERSON));
				this.setOwner( (String)r.getValue(AssessmentTaskVOMeta.OWNER));
				this.setHrUserId( (String)r.getValue(AssessmentTaskVOMeta.HR_USER_ID));
				this.setSelfWeigth( (Integer)r.getValue(AssessmentTaskVOMeta.SELF_WEIGTH));
				this.setHasHrConfirm( (String)r.getValue(AssessmentTaskVOMeta.HAS_HR_CONFIRM));
				this.setHasSecondLeaderAssessment( (String)r.getValue(AssessmentTaskVOMeta.HAS_SECOND_LEADER_ASSESSMENT));
				this.setHasSameAssessment( (String)r.getValue(AssessmentTaskVOMeta.HAS_SAME_ASSESSMENT));
				this.setUpdateTime( (Date)r.getValue(AssessmentTaskVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssessmentTaskVOMeta.VERSION));
				this.setAssessmenMethod( (String)r.getValue(AssessmentTaskVOMeta.ASSESSMEN_METHOD));
				this.setSameWeigth( (Integer)r.getValue(AssessmentTaskVOMeta.SAME_WEIGTH));
				this.setCreateBy( (String)r.getValue(AssessmentTaskVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssessmentTaskVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssessmentTaskVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssessmentTaskVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssessmentTaskVOMeta.NAME));
				this.setTotalWeight( (BigDecimal)r.getValue(AssessmentTaskVOMeta.TOTAL_WEIGHT));
				this.setTenantId( (String)r.getValue(AssessmentTaskVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssessmentTaskVOMeta.DELETE_BY));
				this.setTplId( (String)r.getValue(AssessmentTaskVOMeta.TPL_ID));
				this.setStatus( (String)r.getValue(AssessmentTaskVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}