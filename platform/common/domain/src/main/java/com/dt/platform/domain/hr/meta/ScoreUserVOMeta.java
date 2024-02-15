package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.ScoreUserVO;
import java.util.List;
import com.dt.platform.domain.hr.ScoreUser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Person;
import com.dt.platform.domain.hr.ScoreTpl;
import com.dt.platform.domain.hr.EvaluationRelation;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-14 17:36:10
 * @sign B6CBA58B0D762036C409A32BBEEB44A8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ScoreUserVOMeta extends ScoreUserMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final String INST_ID="instId";
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> INST_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,INST_ID, java.lang.String.class, "任务", "任务", java.lang.String.class, null);
	
	/**
	 * 部门 , 类型: java.lang.String
	*/
	public static final String ORG_ID="orgId";
	
	/**
	 * 部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,ORG_ID, java.lang.String.class, "部门", "部门", java.lang.String.class, null);
	
	/**
	 * 关系 , 类型: java.lang.String
	*/
	public static final String RELATIONSHIP="relationship";
	
	/**
	 * 关系 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> RELATIONSHIP_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,RELATIONSHIP, java.lang.String.class, "关系", "关系", java.lang.String.class, null);
	
	/**
	 * 考评卷 , 类型: java.lang.String
	*/
	public static final String TPL_ID="tplId";
	
	/**
	 * 考评卷 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> TPL_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,TPL_ID, java.lang.String.class, "考评卷", "考评卷", java.lang.String.class, null);
	
	/**
	 * 评价人 , 类型: java.lang.String
	*/
	public static final String RATER_ID="raterId";
	
	/**
	 * 评价人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> RATER_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,RATER_ID, java.lang.String.class, "评价人", "评价人", java.lang.String.class, null);
	
	/**
	 * 被评价人 , 类型: java.lang.String
	*/
	public static final String RATED_ID="ratedId";
	
	/**
	 * 被评价人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> RATED_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,RATED_ID, java.lang.String.class, "被评价人", "被评价人", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * organization , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String ORGANIZATION="organization";
	
	/**
	 * organization , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,org.github.foxnic.web.domain.hrm.Organization> ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "organization", "organization", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * raterUser , 类型: org.github.foxnic.web.domain.hrm.Person
	*/
	public static final String RATER_USER="raterUser";
	
	/**
	 * raterUser , 类型: org.github.foxnic.web.domain.hrm.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,org.github.foxnic.web.domain.hrm.Person> RATER_USER_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,RATER_USER, org.github.foxnic.web.domain.hrm.Person.class, "raterUser", "raterUser", org.github.foxnic.web.domain.hrm.Person.class, null);
	
	/**
	 * ratedUser , 类型: org.github.foxnic.web.domain.hrm.Person
	*/
	public static final String RATED_USER="ratedUser";
	
	/**
	 * ratedUser , 类型: org.github.foxnic.web.domain.hrm.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,org.github.foxnic.web.domain.hrm.Person> RATED_USER_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,RATED_USER, org.github.foxnic.web.domain.hrm.Person.class, "ratedUser", "ratedUser", org.github.foxnic.web.domain.hrm.Person.class, null);
	
	/**
	 * scoreTpl , 类型: com.dt.platform.domain.hr.ScoreTpl
	*/
	public static final String SCORE_TPL="scoreTpl";
	
	/**
	 * scoreTpl , 类型: com.dt.platform.domain.hr.ScoreTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,com.dt.platform.domain.hr.ScoreTpl> SCORE_TPL_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,SCORE_TPL, com.dt.platform.domain.hr.ScoreTpl.class, "scoreTpl", "scoreTpl", com.dt.platform.domain.hr.ScoreTpl.class, null);
	
	/**
	 * evaluationRelation , 类型: com.dt.platform.domain.hr.EvaluationRelation
	*/
	public static final String EVALUATION_RELATION="evaluationRelation";
	
	/**
	 * evaluationRelation , 类型: com.dt.platform.domain.hr.EvaluationRelation
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.ScoreUserVO,com.dt.platform.domain.hr.EvaluationRelation> EVALUATION_RELATION_PROP = new BeanProperty(com.dt.platform.domain.hr.ScoreUserVO.class ,EVALUATION_RELATION, com.dt.platform.domain.hr.EvaluationRelation.class, "evaluationRelation", "evaluationRelation", com.dt.platform.domain.hr.EvaluationRelation.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , INST_ID , ORG_ID , RELATIONSHIP , TPL_ID , RATER_ID , RATED_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , ORGANIZATION , RATER_USER , RATED_USER , SCORE_TPL , EVALUATION_RELATION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.ScoreUserVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public ScoreUserVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public ScoreUserVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public ScoreUserVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public ScoreUserVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public ScoreUserVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public ScoreUserVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public ScoreUserVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public ScoreUserVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public ScoreUserVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public ScoreUserVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public ScoreUserVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public ScoreUserVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ScoreUser setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 任务
		 * @param instId 任务
		 * @return 当前对象
		*/
		public ScoreUser setInstId(String instId) {
			super.change(INST_ID,super.getInstId(),instId);
			super.setInstId(instId);
			return this;
		}
		
		/**
		 * 设置 部门
		 * @param orgId 部门
		 * @return 当前对象
		*/
		public ScoreUser setOrgId(String orgId) {
			super.change(ORG_ID,super.getOrgId(),orgId);
			super.setOrgId(orgId);
			return this;
		}
		
		/**
		 * 设置 关系
		 * @param relationship 关系
		 * @return 当前对象
		*/
		public ScoreUser setRelationship(String relationship) {
			super.change(RELATIONSHIP,super.getRelationship(),relationship);
			super.setRelationship(relationship);
			return this;
		}
		
		/**
		 * 设置 考评卷
		 * @param tplId 考评卷
		 * @return 当前对象
		*/
		public ScoreUser setTplId(String tplId) {
			super.change(TPL_ID,super.getTplId(),tplId);
			super.setTplId(tplId);
			return this;
		}
		
		/**
		 * 设置 评价人
		 * @param raterId 评价人
		 * @return 当前对象
		*/
		public ScoreUser setRaterId(String raterId) {
			super.change(RATER_ID,super.getRaterId(),raterId);
			super.setRaterId(raterId);
			return this;
		}
		
		/**
		 * 设置 被评价人
		 * @param ratedId 被评价人
		 * @return 当前对象
		*/
		public ScoreUser setRatedId(String ratedId) {
			super.change(RATED_ID,super.getRatedId(),ratedId);
			super.setRatedId(ratedId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public ScoreUser setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ScoreUser setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ScoreUser setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ScoreUser setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ScoreUser setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ScoreUser setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ScoreUser setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ScoreUser setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public ScoreUser setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 organization
		 * @param organization organization
		 * @return 当前对象
		*/
		public ScoreUser setOrganization(Organization organization) {
			super.change(ORGANIZATION,super.getOrganization(),organization);
			super.setOrganization(organization);
			return this;
		}
		
		/**
		 * 设置 raterUser
		 * @param raterUser raterUser
		 * @return 当前对象
		*/
		public ScoreUser setRaterUser(Person raterUser) {
			super.change(RATER_USER,super.getRaterUser(),raterUser);
			super.setRaterUser(raterUser);
			return this;
		}
		
		/**
		 * 设置 ratedUser
		 * @param ratedUser ratedUser
		 * @return 当前对象
		*/
		public ScoreUser setRatedUser(Person ratedUser) {
			super.change(RATED_USER,super.getRatedUser(),ratedUser);
			super.setRatedUser(ratedUser);
			return this;
		}
		
		/**
		 * 设置 scoreTpl
		 * @param scoreTpl scoreTpl
		 * @return 当前对象
		*/
		public ScoreUser setScoreTpl(ScoreTpl scoreTpl) {
			super.change(SCORE_TPL,super.getScoreTpl(),scoreTpl);
			super.setScoreTpl(scoreTpl);
			return this;
		}
		
		/**
		 * 设置 evaluationRelation
		 * @param evaluationRelation evaluationRelation
		 * @return 当前对象
		*/
		public ScoreUser setEvaluationRelation(EvaluationRelation evaluationRelation) {
			super.change(EVALUATION_RELATION,super.getEvaluationRelation(),evaluationRelation);
			super.setEvaluationRelation(evaluationRelation);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public ScoreUserVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ScoreUserVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setRatedId(this.getRatedId());
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setOrgId(this.getOrgId());
			inst.setInstId(this.getInstId());
			inst.setCreateBy(this.getCreateBy());
			inst.setRaterId(this.getRaterId());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setRelationship(this.getRelationship());
			inst.setTplId(this.getTplId());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setRatedUser(this.getRatedUser());
				inst.setScoreTpl(this.getScoreTpl());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setEvaluationRelation(this.getEvaluationRelation());
				inst.setOrganization(this.getOrganization());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setRaterUser(this.getRaterUser());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}