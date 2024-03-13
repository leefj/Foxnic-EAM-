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
import com.dt.platform.domain.hr.meta.AssessmentBillTaskPaperVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考核试卷VO类型
 * <p>考核试卷 , 数据表 hr_assessment_bill_task_paper 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-13 13:59:39
 * @sign D0F5C41AA1F86419B8A151B1F24FE9AC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "考核试卷VO类型 ; 考核试卷 , 数据表 hr_assessment_bill_task_paper 的通用VO类型" , parent = AssessmentBillTaskPaper.class)
public class AssessmentBillTaskPaperVO extends AssessmentBillTaskPaper {

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
	public AssessmentBillTaskPaperVO setPageIndex(Integer pageIndex) {
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
	public AssessmentBillTaskPaperVO setPageSize(Integer pageSize) {
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
	public AssessmentBillTaskPaperVO setSearchField(String searchField) {
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
	public AssessmentBillTaskPaperVO setFuzzyField(String fuzzyField) {
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
	public AssessmentBillTaskPaperVO setSearchValue(String searchValue) {
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
	public AssessmentBillTaskPaperVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssessmentBillTaskPaperVO addDirtyField(String... dirtyField) {
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
	public AssessmentBillTaskPaperVO setSortField(String sortField) {
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
	public AssessmentBillTaskPaperVO setSortType(String sortType) {
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
	public AssessmentBillTaskPaperVO setDataOrigin(String dataOrigin) {
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
	public AssessmentBillTaskPaperVO setQueryLogic(String queryLogic) {
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
	public AssessmentBillTaskPaperVO setRequestAction(String requestAction) {
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
	public AssessmentBillTaskPaperVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssessmentBillTaskPaperVO addId(String... id) {
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
	 * @return AssessmentBillTaskPaperVO , 转换好的 AssessmentBillTaskPaperVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssessmentBillTaskPaperVO , 转换好的 PoJo 对象
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
	public AssessmentBillTaskPaperVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssessmentBillTaskPaperVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AssessmentBillTaskPaperVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AssessmentBillTaskPaperVOMeta.$$proxy$$();
		inst.setEvaluateContent(this.getEvaluateContent());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setAssesseeId(this.getAssesseeId());
		inst.setBillTaskDtlId(this.getBillTaskDtlId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setBillTaskId(this.getBillTaskId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssessorId(this.getAssessorId());
		inst.setBillId(this.getBillId());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setScoreValue(this.getScoreValue());
		if(all) {
			inst.setSameUserAvgScoreValue(this.getSameUserAvgScoreValue());
			inst.setSameUserNeedCount(this.getSameUserNeedCount());
			inst.setSearchField(this.getSearchField());
			inst.setAssessee(this.getAssessee());
			inst.setSameUserFinishCount(this.getSameUserFinishCount());
			inst.setRequestAction(this.getRequestAction());
			inst.setAssessor(this.getAssessor());
			inst.setIfHrConfirm(this.getIfHrConfirm());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setAssessmentIndicatorValueList(this.getAssessmentIndicatorValueList());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setAssessmentBillTaskDtl(this.getAssessmentBillTaskDtl());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setLeaderScoreValue(this.getLeaderScoreValue());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSelfScoreValue(this.getSelfScoreValue());
			inst.setSearchValue(this.getSearchValue());
			inst.setSecondLeaderScoreValue(this.getSecondLeaderScoreValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssessmentBillTaskPaperVO clone(boolean deep) {
		return EntityContext.clone(AssessmentBillTaskPaperVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssessmentBillTaskPaperVO
	 * @param assessmentBillTaskPaperMap 包含实体信息的 Map 对象
	 * @return AssessmentBillTaskPaperVO , 转换好的的 AssessmentBillTaskPaper 对象
	*/
	@Transient
	public static AssessmentBillTaskPaperVO createFrom(Map<String,Object> assessmentBillTaskPaperMap) {
		if(assessmentBillTaskPaperMap==null) return null;
		AssessmentBillTaskPaperVO vo = create();
		EntityContext.copyProperties(vo,assessmentBillTaskPaperMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssessmentBillTaskPaperVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssessmentBillTaskPaperVO , 转换好的的 AssessmentBillTaskPaper 对象
	*/
	@Transient
	public static AssessmentBillTaskPaperVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssessmentBillTaskPaperVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssessmentBillTaskPaperVO，等同于 new
	 * @return AssessmentBillTaskPaperVO 对象
	*/
	@Transient
	public static AssessmentBillTaskPaperVO create() {
		return new com.dt.platform.domain.hr.meta.AssessmentBillTaskPaperVOMeta.$$proxy$$();
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
			this.setEvaluateContent(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.EVALUATE_CONTENT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentBillTaskPaperVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssessmentBillTaskPaperVOMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.CONTENT)));
			this.setAssesseeId(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.ASSESSEE_ID)));
			this.setBillTaskDtlId(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.BILL_TASK_DTL_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssessmentBillTaskPaperVOMeta.DELETED)));
			this.setBillTaskId(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.BILL_TASK_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssessmentBillTaskPaperVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssessmentBillTaskPaperVOMeta.DELETE_TIME)));
			this.setAssessorId(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.ASSESSOR_ID)));
			this.setBillId(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.BILL_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.ID)));
			this.setScoreValue(DataParser.parse(BigDecimal.class, map.get(AssessmentBillTaskPaperVOMeta.SCORE_VALUE)));
			// others
			this.setSameUserAvgScoreValue(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.SAME_USER_AVG_SCORE_VALUE)));
			this.setSameUserNeedCount(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.SAME_USER_NEED_COUNT)));
			this.setSearchField(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.SEARCH_FIELD)));
			this.setAssessee(DataParser.parse(Employee.class, map.get(AssessmentBillTaskPaperVOMeta.ASSESSEE)));
			this.setSameUserFinishCount(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.SAME_USER_FINISH_COUNT)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.REQUEST_ACTION)));
			this.setAssessor(DataParser.parse(Employee.class, map.get(AssessmentBillTaskPaperVOMeta.ASSESSOR)));
			this.setIfHrConfirm(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.IF_HR_CONFIRM)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssessmentBillTaskPaperVOMeta.PAGE_SIZE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssessmentBillTaskPaperVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.SORT_TYPE)));
			this.setAssessmentBillTaskDtl(DataParser.parse(AssessmentBillTaskDtl.class, map.get(AssessmentBillTaskPaperVOMeta.ASSESSMENT_BILL_TASK_DTL)));
			this.setSortField(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.DATA_ORIGIN)));
			this.setLeaderScoreValue(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.LEADER_SCORE_VALUE)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.QUERY_LOGIC)));
			this.setSelfScoreValue(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.SELF_SCORE_VALUE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.SEARCH_VALUE)));
			this.setSecondLeaderScoreValue(DataParser.parse(String.class, map.get(AssessmentBillTaskPaperVOMeta.SECOND_LEADER_SCORE_VALUE)));
			return true;
		} else {
			try {
				this.setEvaluateContent( (String)map.get(AssessmentBillTaskPaperVOMeta.EVALUATE_CONTENT));
				this.setUpdateTime( (Date)map.get(AssessmentBillTaskPaperVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssessmentBillTaskPaperVOMeta.VERSION));
				this.setContent( (String)map.get(AssessmentBillTaskPaperVOMeta.CONTENT));
				this.setAssesseeId( (String)map.get(AssessmentBillTaskPaperVOMeta.ASSESSEE_ID));
				this.setBillTaskDtlId( (String)map.get(AssessmentBillTaskPaperVOMeta.BILL_TASK_DTL_ID));
				this.setCreateBy( (String)map.get(AssessmentBillTaskPaperVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssessmentBillTaskPaperVOMeta.DELETED));
				this.setBillTaskId( (String)map.get(AssessmentBillTaskPaperVOMeta.BILL_TASK_ID));
				this.setCreateTime( (Date)map.get(AssessmentBillTaskPaperVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssessmentBillTaskPaperVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssessmentBillTaskPaperVOMeta.DELETE_TIME));
				this.setAssessorId( (String)map.get(AssessmentBillTaskPaperVOMeta.ASSESSOR_ID));
				this.setBillId( (String)map.get(AssessmentBillTaskPaperVOMeta.BILL_ID));
				this.setTenantId( (String)map.get(AssessmentBillTaskPaperVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssessmentBillTaskPaperVOMeta.DELETE_BY));
				this.setId( (String)map.get(AssessmentBillTaskPaperVOMeta.ID));
				this.setScoreValue( (BigDecimal)map.get(AssessmentBillTaskPaperVOMeta.SCORE_VALUE));
				// others
				this.setSameUserAvgScoreValue( (String)map.get(AssessmentBillTaskPaperVOMeta.SAME_USER_AVG_SCORE_VALUE));
				this.setSameUserNeedCount( (String)map.get(AssessmentBillTaskPaperVOMeta.SAME_USER_NEED_COUNT));
				this.setSearchField( (String)map.get(AssessmentBillTaskPaperVOMeta.SEARCH_FIELD));
				this.setAssessee( (Employee)map.get(AssessmentBillTaskPaperVOMeta.ASSESSEE));
				this.setSameUserFinishCount( (String)map.get(AssessmentBillTaskPaperVOMeta.SAME_USER_FINISH_COUNT));
				this.setRequestAction( (String)map.get(AssessmentBillTaskPaperVOMeta.REQUEST_ACTION));
				this.setAssessor( (Employee)map.get(AssessmentBillTaskPaperVOMeta.ASSESSOR));
				this.setIfHrConfirm( (String)map.get(AssessmentBillTaskPaperVOMeta.IF_HR_CONFIRM));
				this.setFuzzyField( (String)map.get(AssessmentBillTaskPaperVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssessmentBillTaskPaperVOMeta.PAGE_SIZE));
				this.setPageIndex( (Integer)map.get(AssessmentBillTaskPaperVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssessmentBillTaskPaperVOMeta.SORT_TYPE));
				this.setAssessmentBillTaskDtl( (AssessmentBillTaskDtl)map.get(AssessmentBillTaskPaperVOMeta.ASSESSMENT_BILL_TASK_DTL));
				this.setSortField( (String)map.get(AssessmentBillTaskPaperVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(AssessmentBillTaskPaperVOMeta.DATA_ORIGIN));
				this.setLeaderScoreValue( (String)map.get(AssessmentBillTaskPaperVOMeta.LEADER_SCORE_VALUE));
				this.setQueryLogic( (String)map.get(AssessmentBillTaskPaperVOMeta.QUERY_LOGIC));
				this.setSelfScoreValue( (String)map.get(AssessmentBillTaskPaperVOMeta.SELF_SCORE_VALUE));
				this.setSearchValue( (String)map.get(AssessmentBillTaskPaperVOMeta.SEARCH_VALUE));
				this.setSecondLeaderScoreValue( (String)map.get(AssessmentBillTaskPaperVOMeta.SECOND_LEADER_SCORE_VALUE));
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
			this.setEvaluateContent(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperVOMeta.EVALUATE_CONTENT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentBillTaskPaperVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssessmentBillTaskPaperVOMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperVOMeta.CONTENT)));
			this.setAssesseeId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperVOMeta.ASSESSEE_ID)));
			this.setBillTaskDtlId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperVOMeta.BILL_TASK_DTL_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssessmentBillTaskPaperVOMeta.DELETED)));
			this.setBillTaskId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperVOMeta.BILL_TASK_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssessmentBillTaskPaperVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssessmentBillTaskPaperVOMeta.DELETE_TIME)));
			this.setAssessorId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperVOMeta.ASSESSOR_ID)));
			this.setBillId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperVOMeta.BILL_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskPaperVOMeta.ID)));
			this.setScoreValue(DataParser.parse(BigDecimal.class, r.getValue(AssessmentBillTaskPaperVOMeta.SCORE_VALUE)));
			return true;
		} else {
			try {
				this.setEvaluateContent( (String)r.getValue(AssessmentBillTaskPaperVOMeta.EVALUATE_CONTENT));
				this.setUpdateTime( (Date)r.getValue(AssessmentBillTaskPaperVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssessmentBillTaskPaperVOMeta.VERSION));
				this.setContent( (String)r.getValue(AssessmentBillTaskPaperVOMeta.CONTENT));
				this.setAssesseeId( (String)r.getValue(AssessmentBillTaskPaperVOMeta.ASSESSEE_ID));
				this.setBillTaskDtlId( (String)r.getValue(AssessmentBillTaskPaperVOMeta.BILL_TASK_DTL_ID));
				this.setCreateBy( (String)r.getValue(AssessmentBillTaskPaperVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssessmentBillTaskPaperVOMeta.DELETED));
				this.setBillTaskId( (String)r.getValue(AssessmentBillTaskPaperVOMeta.BILL_TASK_ID));
				this.setCreateTime( (Date)r.getValue(AssessmentBillTaskPaperVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssessmentBillTaskPaperVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssessmentBillTaskPaperVOMeta.DELETE_TIME));
				this.setAssessorId( (String)r.getValue(AssessmentBillTaskPaperVOMeta.ASSESSOR_ID));
				this.setBillId( (String)r.getValue(AssessmentBillTaskPaperVOMeta.BILL_ID));
				this.setTenantId( (String)r.getValue(AssessmentBillTaskPaperVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssessmentBillTaskPaperVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssessmentBillTaskPaperVOMeta.ID));
				this.setScoreValue( (BigDecimal)r.getValue(AssessmentBillTaskPaperVOMeta.SCORE_VALUE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}