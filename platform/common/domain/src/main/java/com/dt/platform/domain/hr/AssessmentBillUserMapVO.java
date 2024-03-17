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
import com.dt.platform.domain.hr.meta.AssessmentBillUserMapVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 人员映射VO类型
 * <p>人员映射 , 数据表 hr_assessment_bill_user_map 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-16 19:51:39
 * @sign B486CF9E3D70862C082CD0236C42FB8A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "人员映射VO类型 ; 人员映射 , 数据表 hr_assessment_bill_user_map 的通用VO类型" , parent = AssessmentBillUserMap.class)
public class AssessmentBillUserMapVO extends AssessmentBillUserMap {

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
	public AssessmentBillUserMapVO setPageIndex(Integer pageIndex) {
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
	public AssessmentBillUserMapVO setPageSize(Integer pageSize) {
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
	public AssessmentBillUserMapVO setSearchField(String searchField) {
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
	public AssessmentBillUserMapVO setFuzzyField(String fuzzyField) {
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
	public AssessmentBillUserMapVO setSearchValue(String searchValue) {
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
	public AssessmentBillUserMapVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssessmentBillUserMapVO addDirtyField(String... dirtyField) {
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
	public AssessmentBillUserMapVO setSortField(String sortField) {
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
	public AssessmentBillUserMapVO setSortType(String sortType) {
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
	public AssessmentBillUserMapVO setDataOrigin(String dataOrigin) {
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
	public AssessmentBillUserMapVO setQueryLogic(String queryLogic) {
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
	public AssessmentBillUserMapVO setRequestAction(String requestAction) {
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
	public AssessmentBillUserMapVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssessmentBillUserMapVO addId(String... id) {
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
	 * @return AssessmentBillUserMapVO , 转换好的 AssessmentBillUserMapVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssessmentBillUserMapVO , 转换好的 PoJo 对象
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
	public AssessmentBillUserMapVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssessmentBillUserMapVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AssessmentBillUserMapVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AssessmentBillUserMapVOMeta.$$proxy$$();
		inst.setHrUserId(this.getHrUserId());
		inst.setSelfScore(this.getSelfScore());
		inst.setSecondLeaderScore(this.getSecondLeaderScore());
		inst.setSecondLeaderId(this.getSecondLeaderId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setMessage(this.getMessage());
		inst.setVersion(this.getVersion());
		inst.setOrgId(this.getOrgId());
		inst.setLeaderId(this.getLeaderId());
		inst.setAssesseeId(this.getAssesseeId());
		inst.setResult(this.getResult());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setIsConfirm(this.getIsConfirm());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setBillId(this.getBillId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setSameScore(this.getSameScore());
		inst.setStatus(this.getStatus());
		inst.setLeaderScore(this.getLeaderScore());
		if(all) {
			inst.setAssesseeUser(this.getAssesseeUser());
			inst.setSelfScorePaper(this.getSelfScorePaper());
			inst.setSameUserNeedCount(this.getSameUserNeedCount());
			inst.setSearchField(this.getSearchField());
			inst.setSameUserFinishCount(this.getSameUserFinishCount());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setIncompleteSecondLeaderPaperCount(this.getIncompleteSecondLeaderPaperCount());
			inst.setPageSize(this.getPageSize());
			inst.setSecondLeaderUserRel(this.getSecondLeaderUserRel());
			inst.setLeaderUserIdRel(this.getLeaderUserIdRel());
			inst.setSameScoreValue(this.getSameScoreValue());
			inst.setHrUser(this.getHrUser());
			inst.setSameUserIdsRel(this.getSameUserIdsRel());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setSecondLeaderScorePaper(this.getSecondLeaderScorePaper());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setSameUserIds(this.getSameUserIds());
			inst.setAssessmentBillTaskList(this.getAssessmentBillTaskList());
			inst.setLeaderScoreValue(this.getLeaderScoreValue());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setIncompleteSamePaperCount(this.getIncompleteSamePaperCount());
			inst.setLeaderScorePaper(this.getLeaderScorePaper());
			inst.setSecondLeaderScoreValue(this.getSecondLeaderScoreValue());
			inst.setSameUserList(this.getSameUserList());
			inst.setSameUserAvgScoreValue(this.getSameUserAvgScoreValue());
			inst.setRequestAction(this.getRequestAction());
			inst.setSecondLeaderUser(this.getSecondLeaderUser());
			inst.setSOrgId(this.getSOrgId());
			inst.setLeaderUserRel(this.getLeaderUserRel());
			inst.setSecondLeaderUserIdRel(this.getSecondLeaderUserIdRel());
			inst.setSameScorePaperList(this.getSameScorePaperList());
			inst.setIncompleteLeaderPaperCount(this.getIncompleteLeaderPaperCount());
			inst.setLeaderUser(this.getLeaderUser());
			inst.setSameUserListRel(this.getSameUserListRel());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setIncompleteSelfPaperCount(this.getIncompleteSelfPaperCount());
			inst.setIncompletePaper(this.getIncompletePaper());
			inst.setIds(this.getIds());
			inst.setAssessmentTask(this.getAssessmentTask());
			inst.setSelfScoreValue(this.getSelfScoreValue());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssessmentBillUserMapVO clone(boolean deep) {
		return EntityContext.clone(AssessmentBillUserMapVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssessmentBillUserMapVO
	 * @param assessmentBillUserMapMap 包含实体信息的 Map 对象
	 * @return AssessmentBillUserMapVO , 转换好的的 AssessmentBillUserMap 对象
	*/
	@Transient
	public static AssessmentBillUserMapVO createFrom(Map<String,Object> assessmentBillUserMapMap) {
		if(assessmentBillUserMapMap==null) return null;
		AssessmentBillUserMapVO vo = create();
		EntityContext.copyProperties(vo,assessmentBillUserMapMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssessmentBillUserMapVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssessmentBillUserMapVO , 转换好的的 AssessmentBillUserMap 对象
	*/
	@Transient
	public static AssessmentBillUserMapVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssessmentBillUserMapVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssessmentBillUserMapVO，等同于 new
	 * @return AssessmentBillUserMapVO 对象
	*/
	@Transient
	public static AssessmentBillUserMapVO create() {
		return new com.dt.platform.domain.hr.meta.AssessmentBillUserMapVOMeta.$$proxy$$();
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
			this.setHrUserId(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.HR_USER_ID)));
			this.setSelfScore(DataParser.parse(BigDecimal.class, map.get(AssessmentBillUserMapVOMeta.SELF_SCORE)));
			this.setSecondLeaderScore(DataParser.parse(BigDecimal.class, map.get(AssessmentBillUserMapVOMeta.SECOND_LEADER_SCORE)));
			this.setSecondLeaderId(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.SECOND_LEADER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentBillUserMapVOMeta.UPDATE_TIME)));
			this.setMessage(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.MESSAGE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssessmentBillUserMapVOMeta.VERSION)));
			this.setOrgId(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.ORG_ID)));
			this.setLeaderId(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.LEADER_ID)));
			this.setAssesseeId(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.ASSESSEE_ID)));
			this.setResult(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.RESULT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssessmentBillUserMapVOMeta.DELETED)));
			this.setIsConfirm(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.IS_CONFIRM)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssessmentBillUserMapVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssessmentBillUserMapVOMeta.DELETE_TIME)));
			this.setBillId(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.BILL_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.ID)));
			this.setSameScore(DataParser.parse(BigDecimal.class, map.get(AssessmentBillUserMapVOMeta.SAME_SCORE)));
			this.setStatus(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.STATUS)));
			this.setLeaderScore(DataParser.parse(BigDecimal.class, map.get(AssessmentBillUserMapVOMeta.LEADER_SCORE)));
			// others
			this.setAssesseeUser(DataParser.parse(Employee.class, map.get(AssessmentBillUserMapVOMeta.ASSESSEE_USER)));
			this.setSelfScorePaper(DataParser.parse(AssessmentBillTaskPaper.class, map.get(AssessmentBillUserMapVOMeta.SELF_SCORE_PAPER)));
			this.setSameUserNeedCount(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.SAME_USER_NEED_COUNT)));
			this.setSearchField(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.SEARCH_FIELD)));
			this.setSameUserFinishCount(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.SAME_USER_FINISH_COUNT)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.FUZZY_FIELD)));
			this.setIncompleteSecondLeaderPaperCount(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.INCOMPLETE_SECOND_LEADER_PAPER_COUNT)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssessmentBillUserMapVOMeta.PAGE_SIZE)));
			this.setSecondLeaderUserRel(DataParser.parse(Employee.class, map.get(AssessmentBillUserMapVOMeta.SECOND_LEADER_USER_REL)));
			this.setLeaderUserIdRel(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.LEADER_USER_ID_REL)));
			this.setSameScoreValue(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.SAME_SCORE_VALUE)));
			this.setHrUser(DataParser.parse(Employee.class, map.get(AssessmentBillUserMapVOMeta.HR_USER)));
			this.setSortField(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.SORT_FIELD)));
			this.setSecondLeaderScorePaper(DataParser.parse(AssessmentBillTaskPaper.class, map.get(AssessmentBillUserMapVOMeta.SECOND_LEADER_SCORE_PAPER)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.DATA_ORIGIN)));
			this.setAssessmentBillTaskList(DataParser.parse(AssessmentBillTask.class, map.get(AssessmentBillUserMapVOMeta.ASSESSMENT_BILL_TASK_LIST)));
			this.setLeaderScoreValue(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.LEADER_SCORE_VALUE)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.QUERY_LOGIC)));
			this.setIncompleteSamePaperCount(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.INCOMPLETE_SAME_PAPER_COUNT)));
			this.setLeaderScorePaper(DataParser.parse(AssessmentBillTaskPaper.class, map.get(AssessmentBillUserMapVOMeta.LEADER_SCORE_PAPER)));
			this.setSecondLeaderScoreValue(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.SECOND_LEADER_SCORE_VALUE)));
			this.setSameUserAvgScoreValue(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.SAME_USER_AVG_SCORE_VALUE)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.REQUEST_ACTION)));
			this.setSecondLeaderUser(DataParser.parse(Employee.class, map.get(AssessmentBillUserMapVOMeta.SECOND_LEADER_USER)));
			this.setSOrgId(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.S_ORG_ID)));
			this.setLeaderUserRel(DataParser.parse(Employee.class, map.get(AssessmentBillUserMapVOMeta.LEADER_USER_REL)));
			this.setSecondLeaderUserIdRel(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.SECOND_LEADER_USER_ID_REL)));
			this.setSameScorePaperList(DataParser.parse(AssessmentBillTaskPaper.class, map.get(AssessmentBillUserMapVOMeta.SAME_SCORE_PAPER_LIST)));
			this.setIncompleteLeaderPaperCount(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.INCOMPLETE_LEADER_PAPER_COUNT)));
			this.setLeaderUser(DataParser.parse(Employee.class, map.get(AssessmentBillUserMapVOMeta.LEADER_USER)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssessmentBillUserMapVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.SORT_TYPE)));
			this.setIncompleteSelfPaperCount(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.INCOMPLETE_SELF_PAPER_COUNT)));
			this.setAssessmentTask(DataParser.parse(AssessmentTask.class, map.get(AssessmentBillUserMapVOMeta.ASSESSMENT_TASK)));
			this.setSelfScoreValue(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.SELF_SCORE_VALUE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssessmentBillUserMapVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setHrUserId( (String)map.get(AssessmentBillUserMapVOMeta.HR_USER_ID));
				this.setSelfScore( (BigDecimal)map.get(AssessmentBillUserMapVOMeta.SELF_SCORE));
				this.setSecondLeaderScore( (BigDecimal)map.get(AssessmentBillUserMapVOMeta.SECOND_LEADER_SCORE));
				this.setSecondLeaderId( (String)map.get(AssessmentBillUserMapVOMeta.SECOND_LEADER_ID));
				this.setUpdateTime( (Date)map.get(AssessmentBillUserMapVOMeta.UPDATE_TIME));
				this.setMessage( (String)map.get(AssessmentBillUserMapVOMeta.MESSAGE));
				this.setVersion( (Integer)map.get(AssessmentBillUserMapVOMeta.VERSION));
				this.setOrgId( (String)map.get(AssessmentBillUserMapVOMeta.ORG_ID));
				this.setLeaderId( (String)map.get(AssessmentBillUserMapVOMeta.LEADER_ID));
				this.setAssesseeId( (String)map.get(AssessmentBillUserMapVOMeta.ASSESSEE_ID));
				this.setResult( (String)map.get(AssessmentBillUserMapVOMeta.RESULT));
				this.setCreateBy( (String)map.get(AssessmentBillUserMapVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssessmentBillUserMapVOMeta.DELETED));
				this.setIsConfirm( (String)map.get(AssessmentBillUserMapVOMeta.IS_CONFIRM));
				this.setCreateTime( (Date)map.get(AssessmentBillUserMapVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssessmentBillUserMapVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssessmentBillUserMapVOMeta.DELETE_TIME));
				this.setBillId( (String)map.get(AssessmentBillUserMapVOMeta.BILL_ID));
				this.setDeleteBy( (String)map.get(AssessmentBillUserMapVOMeta.DELETE_BY));
				this.setId( (String)map.get(AssessmentBillUserMapVOMeta.ID));
				this.setSameScore( (BigDecimal)map.get(AssessmentBillUserMapVOMeta.SAME_SCORE));
				this.setStatus( (String)map.get(AssessmentBillUserMapVOMeta.STATUS));
				this.setLeaderScore( (BigDecimal)map.get(AssessmentBillUserMapVOMeta.LEADER_SCORE));
				// others
				this.setAssesseeUser( (Employee)map.get(AssessmentBillUserMapVOMeta.ASSESSEE_USER));
				this.setSelfScorePaper( (AssessmentBillTaskPaper)map.get(AssessmentBillUserMapVOMeta.SELF_SCORE_PAPER));
				this.setSameUserNeedCount( (String)map.get(AssessmentBillUserMapVOMeta.SAME_USER_NEED_COUNT));
				this.setSearchField( (String)map.get(AssessmentBillUserMapVOMeta.SEARCH_FIELD));
				this.setSameUserFinishCount( (String)map.get(AssessmentBillUserMapVOMeta.SAME_USER_FINISH_COUNT));
				this.setFuzzyField( (String)map.get(AssessmentBillUserMapVOMeta.FUZZY_FIELD));
				this.setIncompleteSecondLeaderPaperCount( (String)map.get(AssessmentBillUserMapVOMeta.INCOMPLETE_SECOND_LEADER_PAPER_COUNT));
				this.setPageSize( (Integer)map.get(AssessmentBillUserMapVOMeta.PAGE_SIZE));
				this.setSecondLeaderUserRel( (Employee)map.get(AssessmentBillUserMapVOMeta.SECOND_LEADER_USER_REL));
				this.setLeaderUserIdRel( (String)map.get(AssessmentBillUserMapVOMeta.LEADER_USER_ID_REL));
				this.setSameScoreValue( (String)map.get(AssessmentBillUserMapVOMeta.SAME_SCORE_VALUE));
				this.setHrUser( (Employee)map.get(AssessmentBillUserMapVOMeta.HR_USER));
				this.setSortField( (String)map.get(AssessmentBillUserMapVOMeta.SORT_FIELD));
				this.setSecondLeaderScorePaper( (AssessmentBillTaskPaper)map.get(AssessmentBillUserMapVOMeta.SECOND_LEADER_SCORE_PAPER));
				this.setDataOrigin( (String)map.get(AssessmentBillUserMapVOMeta.DATA_ORIGIN));
				this.setAssessmentBillTaskList( (AssessmentBillTask)map.get(AssessmentBillUserMapVOMeta.ASSESSMENT_BILL_TASK_LIST));
				this.setLeaderScoreValue( (String)map.get(AssessmentBillUserMapVOMeta.LEADER_SCORE_VALUE));
				this.setQueryLogic( (String)map.get(AssessmentBillUserMapVOMeta.QUERY_LOGIC));
				this.setIncompleteSamePaperCount( (String)map.get(AssessmentBillUserMapVOMeta.INCOMPLETE_SAME_PAPER_COUNT));
				this.setLeaderScorePaper( (AssessmentBillTaskPaper)map.get(AssessmentBillUserMapVOMeta.LEADER_SCORE_PAPER));
				this.setSecondLeaderScoreValue( (String)map.get(AssessmentBillUserMapVOMeta.SECOND_LEADER_SCORE_VALUE));
				this.setSameUserAvgScoreValue( (String)map.get(AssessmentBillUserMapVOMeta.SAME_USER_AVG_SCORE_VALUE));
				this.setRequestAction( (String)map.get(AssessmentBillUserMapVOMeta.REQUEST_ACTION));
				this.setSecondLeaderUser( (Employee)map.get(AssessmentBillUserMapVOMeta.SECOND_LEADER_USER));
				this.setSOrgId( (String)map.get(AssessmentBillUserMapVOMeta.S_ORG_ID));
				this.setLeaderUserRel( (Employee)map.get(AssessmentBillUserMapVOMeta.LEADER_USER_REL));
				this.setSecondLeaderUserIdRel( (String)map.get(AssessmentBillUserMapVOMeta.SECOND_LEADER_USER_ID_REL));
				this.setSameScorePaperList( (AssessmentBillTaskPaper)map.get(AssessmentBillUserMapVOMeta.SAME_SCORE_PAPER_LIST));
				this.setIncompleteLeaderPaperCount( (String)map.get(AssessmentBillUserMapVOMeta.INCOMPLETE_LEADER_PAPER_COUNT));
				this.setLeaderUser( (Employee)map.get(AssessmentBillUserMapVOMeta.LEADER_USER));
				this.setPageIndex( (Integer)map.get(AssessmentBillUserMapVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssessmentBillUserMapVOMeta.SORT_TYPE));
				this.setIncompleteSelfPaperCount( (String)map.get(AssessmentBillUserMapVOMeta.INCOMPLETE_SELF_PAPER_COUNT));
				this.setAssessmentTask( (AssessmentTask)map.get(AssessmentBillUserMapVOMeta.ASSESSMENT_TASK));
				this.setSelfScoreValue( (String)map.get(AssessmentBillUserMapVOMeta.SELF_SCORE_VALUE));
				this.setSearchValue( (String)map.get(AssessmentBillUserMapVOMeta.SEARCH_VALUE));
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
			this.setHrUserId(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapVOMeta.HR_USER_ID)));
			this.setSelfScore(DataParser.parse(BigDecimal.class, r.getValue(AssessmentBillUserMapVOMeta.SELF_SCORE)));
			this.setSecondLeaderScore(DataParser.parse(BigDecimal.class, r.getValue(AssessmentBillUserMapVOMeta.SECOND_LEADER_SCORE)));
			this.setSecondLeaderId(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapVOMeta.SECOND_LEADER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentBillUserMapVOMeta.UPDATE_TIME)));
			this.setMessage(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapVOMeta.MESSAGE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssessmentBillUserMapVOMeta.VERSION)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapVOMeta.ORG_ID)));
			this.setLeaderId(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapVOMeta.LEADER_ID)));
			this.setAssesseeId(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapVOMeta.ASSESSEE_ID)));
			this.setResult(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapVOMeta.RESULT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssessmentBillUserMapVOMeta.DELETED)));
			this.setIsConfirm(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapVOMeta.IS_CONFIRM)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssessmentBillUserMapVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssessmentBillUserMapVOMeta.DELETE_TIME)));
			this.setBillId(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapVOMeta.BILL_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapVOMeta.ID)));
			this.setSameScore(DataParser.parse(BigDecimal.class, r.getValue(AssessmentBillUserMapVOMeta.SAME_SCORE)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapVOMeta.STATUS)));
			this.setLeaderScore(DataParser.parse(BigDecimal.class, r.getValue(AssessmentBillUserMapVOMeta.LEADER_SCORE)));
			return true;
		} else {
			try {
				this.setHrUserId( (String)r.getValue(AssessmentBillUserMapVOMeta.HR_USER_ID));
				this.setSelfScore( (BigDecimal)r.getValue(AssessmentBillUserMapVOMeta.SELF_SCORE));
				this.setSecondLeaderScore( (BigDecimal)r.getValue(AssessmentBillUserMapVOMeta.SECOND_LEADER_SCORE));
				this.setSecondLeaderId( (String)r.getValue(AssessmentBillUserMapVOMeta.SECOND_LEADER_ID));
				this.setUpdateTime( (Date)r.getValue(AssessmentBillUserMapVOMeta.UPDATE_TIME));
				this.setMessage( (String)r.getValue(AssessmentBillUserMapVOMeta.MESSAGE));
				this.setVersion( (Integer)r.getValue(AssessmentBillUserMapVOMeta.VERSION));
				this.setOrgId( (String)r.getValue(AssessmentBillUserMapVOMeta.ORG_ID));
				this.setLeaderId( (String)r.getValue(AssessmentBillUserMapVOMeta.LEADER_ID));
				this.setAssesseeId( (String)r.getValue(AssessmentBillUserMapVOMeta.ASSESSEE_ID));
				this.setResult( (String)r.getValue(AssessmentBillUserMapVOMeta.RESULT));
				this.setCreateBy( (String)r.getValue(AssessmentBillUserMapVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssessmentBillUserMapVOMeta.DELETED));
				this.setIsConfirm( (String)r.getValue(AssessmentBillUserMapVOMeta.IS_CONFIRM));
				this.setCreateTime( (Date)r.getValue(AssessmentBillUserMapVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssessmentBillUserMapVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssessmentBillUserMapVOMeta.DELETE_TIME));
				this.setBillId( (String)r.getValue(AssessmentBillUserMapVOMeta.BILL_ID));
				this.setDeleteBy( (String)r.getValue(AssessmentBillUserMapVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssessmentBillUserMapVOMeta.ID));
				this.setSameScore( (BigDecimal)r.getValue(AssessmentBillUserMapVOMeta.SAME_SCORE));
				this.setStatus( (String)r.getValue(AssessmentBillUserMapVOMeta.STATUS));
				this.setLeaderScore( (BigDecimal)r.getValue(AssessmentBillUserMapVOMeta.LEADER_SCORE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}