package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.RecruitPersonRecVO;
import java.util.List;
import com.dt.platform.domain.hr.RecruitPersonRec;
import java.util.Date;
import com.dt.platform.domain.hr.RecruitPostRec;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-06 09:29:48
 * @sign A2C55CF7E737022BF22F2A90103AE8EC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class RecruitPersonRecVOMeta extends RecruitPersonRecMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 招聘说明 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 招聘说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,NAME, java.lang.String.class, "招聘说明", "招聘说明", java.lang.String.class, null);
	
	/**
	 * 岗位名称 , 类型: java.lang.String
	*/
	public static final String POST_ID="postId";
	
	/**
	 * 岗位名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> POST_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,POST_ID, java.lang.String.class, "岗位名称", "岗位名称", java.lang.String.class, null);
	
	/**
	 * 岗位名称 , 类型: java.lang.String
	*/
	public static final String POST_NAME="postName";
	
	/**
	 * 岗位名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> POST_NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,POST_NAME, java.lang.String.class, "岗位名称", "岗位名称", java.lang.String.class, null);
	
	/**
	 * 招聘要求 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 招聘要求 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,CONTENT, java.lang.String.class, "招聘要求", "招聘要求", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String START_DATE="startDate";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.util.Date> START_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,START_DATE, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final String END_DATE="endDate";
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.util.Date> END_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,END_DATE, java.util.Date.class, "结束时间", "结束时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * recruitPostRec , 类型: com.dt.platform.domain.hr.RecruitPostRec
	*/
	public static final String RECRUIT_POST_REC="recruitPostRec";
	
	/**
	 * recruitPostRec , 类型: com.dt.platform.domain.hr.RecruitPostRec
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.RecruitPersonRecVO,com.dt.platform.domain.hr.RecruitPostRec> RECRUIT_POST_REC_PROP = new BeanProperty(com.dt.platform.domain.hr.RecruitPersonRecVO.class ,RECRUIT_POST_REC, com.dt.platform.domain.hr.RecruitPostRec.class, "recruitPostRec", "recruitPostRec", com.dt.platform.domain.hr.RecruitPostRec.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , NAME , POST_ID , POST_NAME , CONTENT , NOTES , START_DATE , END_DATE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , RECRUIT_POST_REC };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.RecruitPersonRecVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public RecruitPersonRecVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public RecruitPersonRecVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public RecruitPersonRecVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public RecruitPersonRecVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public RecruitPersonRecVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public RecruitPersonRecVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public RecruitPersonRecVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public RecruitPersonRecVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public RecruitPersonRecVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public RecruitPersonRecVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public RecruitPersonRecVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public RecruitPersonRecVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public RecruitPersonRec setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 招聘说明
		 * @param name 招聘说明
		 * @return 当前对象
		*/
		public RecruitPersonRec setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 岗位名称
		 * @param postId 岗位名称
		 * @return 当前对象
		*/
		public RecruitPersonRec setPostId(String postId) {
			super.change(POST_ID,super.getPostId(),postId);
			super.setPostId(postId);
			return this;
		}
		
		/**
		 * 设置 岗位名称
		 * @param postName 岗位名称
		 * @return 当前对象
		*/
		public RecruitPersonRec setPostName(String postName) {
			super.change(POST_NAME,super.getPostName(),postName);
			super.setPostName(postName);
			return this;
		}
		
		/**
		 * 设置 招聘要求
		 * @param content 招聘要求
		 * @return 当前对象
		*/
		public RecruitPersonRec setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public RecruitPersonRec setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param startDate 开始时间
		 * @return 当前对象
		*/
		public RecruitPersonRec setStartDate(Date startDate) {
			super.change(START_DATE,super.getStartDate(),startDate);
			super.setStartDate(startDate);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param endDate 结束时间
		 * @return 当前对象
		*/
		public RecruitPersonRec setEndDate(Date endDate) {
			super.change(END_DATE,super.getEndDate(),endDate);
			super.setEndDate(endDate);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public RecruitPersonRec setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public RecruitPersonRec setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public RecruitPersonRec setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public RecruitPersonRec setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public RecruitPersonRec setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public RecruitPersonRec setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public RecruitPersonRec setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public RecruitPersonRec setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public RecruitPersonRec setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 recruitPostRec
		 * @param recruitPostRec recruitPostRec
		 * @return 当前对象
		*/
		public RecruitPersonRec setRecruitPostRec(RecruitPostRec recruitPostRec) {
			super.change(RECRUIT_POST_REC,super.getRecruitPostRec(),recruitPostRec);
			super.setRecruitPostRec(recruitPostRec);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public RecruitPersonRecVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public RecruitPersonRecVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setEndDate(this.getEndDate());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setPostId(this.getPostId());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setPostName(this.getPostName());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setStartDate(this.getStartDate());
			if(all) {
				inst.setRecruitPostRec(this.getRecruitPostRec());
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
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

	}
}