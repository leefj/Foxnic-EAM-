package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.UserImportVO;
import java.util.List;
import com.dt.platform.domain.common.UserImport;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-18 19:13:37
 * @sign 108675BC94CD650688663AB2624DE715
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class UserImportVOMeta extends UserImportMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 导入批次 , 类型: java.lang.String
	*/
	public static final String ACTION_CODE="actionCode";
	
	/**
	 * 导入批次 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> ACTION_CODE_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,ACTION_CODE, java.lang.String.class, "导入批次", "导入批次", java.lang.String.class, null);
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final String ACTION_OPER_TIME="actionOperTime";
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.util.Date> ACTION_OPER_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,ACTION_OPER_TIME, java.util.Date.class, "操作时间", "操作时间", java.util.Date.class, null);
	
	/**
	 * 导入状态 , 类型: java.lang.String
	*/
	public static final String ACTION_STATUS="actionStatus";
	
	/**
	 * 导入状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> ACTION_STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,ACTION_STATUS, java.lang.String.class, "导入状态", "导入状态", java.lang.String.class, null);
	
	/**
	 * 导入结果 , 类型: java.lang.String
	*/
	public static final String ACTION_MSG="actionMsg";
	
	/**
	 * 导入结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> ACTION_MSG_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,ACTION_MSG, java.lang.String.class, "导入结果", "导入结果", java.lang.String.class, null);
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final String USER_NAME="userName";
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> USER_NAME_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,USER_NAME, java.lang.String.class, "姓名", "姓名", java.lang.String.class, null);
	
	/**
	 * 工号 , 类型: java.lang.String
	*/
	public static final String BADGE="badge";
	
	/**
	 * 工号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> BADGE_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,BADGE, java.lang.String.class, "工号", "工号", java.lang.String.class, null);
	
	/**
	 * 性别 , 类型: java.lang.String
	*/
	public static final String SEX="sex";
	
	/**
	 * 性别 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> SEX_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,SEX, java.lang.String.class, "性别", "性别", java.lang.String.class, null);
	
	/**
	 * 性别编码 , 类型: java.lang.String
	*/
	public static final String SEX_CODE="sexCode";
	
	/**
	 * 性别编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> SEX_CODE_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,SEX_CODE, java.lang.String.class, "性别编码", "性别编码", java.lang.String.class, null);
	
	/**
	 * 手机号 , 类型: java.lang.String
	*/
	public static final String PHONE="phone";
	
	/**
	 * 手机号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> PHONE_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,PHONE, java.lang.String.class, "手机号", "手机号", java.lang.String.class, null);
	
	/**
	 * 组织 , 类型: java.lang.String
	*/
	public static final String COMPANY_NAME="companyName";
	
	/**
	 * 组织 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> COMPANY_NAME_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,COMPANY_NAME, java.lang.String.class, "组织", "组织", java.lang.String.class, null);
	
	/**
	 * 组织ID , 类型: java.lang.String
	*/
	public static final String COMPANY_ID="companyId";
	
	/**
	 * 组织ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> COMPANY_ID_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,COMPANY_ID, java.lang.String.class, "组织ID", "组织ID", java.lang.String.class, null);
	
	/**
	 * 主岗 , 类型: java.lang.String
	*/
	public static final String MASTER_POST="masterPost";
	
	/**
	 * 主岗 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> MASTER_POST_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,MASTER_POST, java.lang.String.class, "主岗", "主岗", java.lang.String.class, null);
	
	/**
	 * 主岗ID , 类型: java.lang.String
	*/
	public static final String MASTER_POST_ID="masterPostId";
	
	/**
	 * 主岗ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> MASTER_POST_ID_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,MASTER_POST_ID, java.lang.String.class, "主岗ID", "主岗ID", java.lang.String.class, null);
	
	/**
	 * 身份证 , 类型: java.lang.String
	*/
	public static final String ID_CARD="idCard";
	
	/**
	 * 身份证 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> ID_CARD_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,ID_CARD, java.lang.String.class, "身份证", "身份证", java.lang.String.class, null);
	
	/**
	 * 状态 , 字典代码：employee_status , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 字典代码：employee_status , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,STATUS, java.lang.String.class, "状态", "字典代码：employee_status", java.lang.String.class, null);
	
	/**
	 * 状态编码 , 类型: java.lang.String
	*/
	public static final String STATUS_CODE="statusCode";
	
	/**
	 * 状态编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> STATUS_CODE_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,STATUS_CODE, java.lang.String.class, "状态编码", "状态编码", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.UserImportVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.UserImportVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , ACTION_CODE , ACTION_OPER_TIME , ACTION_STATUS , ACTION_MSG , USER_NAME , BADGE , SEX , SEX_CODE , PHONE , COMPANY_NAME , COMPANY_ID , MASTER_POST , MASTER_POST_ID , ID_CARD , STATUS , STATUS_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.UserImportVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public UserImportVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public UserImportVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public UserImportVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public UserImportVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public UserImportVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public UserImportVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public UserImportVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public UserImportVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public UserImportVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public UserImportVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public UserImportVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public UserImportVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public UserImport setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 导入批次
		 * @param actionCode 导入批次
		 * @return 当前对象
		*/
		public UserImport setActionCode(String actionCode) {
			super.change(ACTION_CODE,super.getActionCode(),actionCode);
			super.setActionCode(actionCode);
			return this;
		}
		
		/**
		 * 设置 操作时间
		 * @param actionOperTime 操作时间
		 * @return 当前对象
		*/
		public UserImport setActionOperTime(Date actionOperTime) {
			super.change(ACTION_OPER_TIME,super.getActionOperTime(),actionOperTime);
			super.setActionOperTime(actionOperTime);
			return this;
		}
		
		/**
		 * 设置 导入状态
		 * @param actionStatus 导入状态
		 * @return 当前对象
		*/
		public UserImport setActionStatus(String actionStatus) {
			super.change(ACTION_STATUS,super.getActionStatus(),actionStatus);
			super.setActionStatus(actionStatus);
			return this;
		}
		
		/**
		 * 设置 导入结果
		 * @param actionMsg 导入结果
		 * @return 当前对象
		*/
		public UserImport setActionMsg(String actionMsg) {
			super.change(ACTION_MSG,super.getActionMsg(),actionMsg);
			super.setActionMsg(actionMsg);
			return this;
		}
		
		/**
		 * 设置 姓名
		 * @param userName 姓名
		 * @return 当前对象
		*/
		public UserImport setUserName(String userName) {
			super.change(USER_NAME,super.getUserName(),userName);
			super.setUserName(userName);
			return this;
		}
		
		/**
		 * 设置 工号
		 * @param badge 工号
		 * @return 当前对象
		*/
		public UserImport setBadge(String badge) {
			super.change(BADGE,super.getBadge(),badge);
			super.setBadge(badge);
			return this;
		}
		
		/**
		 * 设置 性别
		 * @param sex 性别
		 * @return 当前对象
		*/
		public UserImport setSex(String sex) {
			super.change(SEX,super.getSex(),sex);
			super.setSex(sex);
			return this;
		}
		
		/**
		 * 设置 性别编码
		 * @param sexCode 性别编码
		 * @return 当前对象
		*/
		public UserImport setSexCode(String sexCode) {
			super.change(SEX_CODE,super.getSexCode(),sexCode);
			super.setSexCode(sexCode);
			return this;
		}
		
		/**
		 * 设置 手机号
		 * @param phone 手机号
		 * @return 当前对象
		*/
		public UserImport setPhone(String phone) {
			super.change(PHONE,super.getPhone(),phone);
			super.setPhone(phone);
			return this;
		}
		
		/**
		 * 设置 组织
		 * @param companyName 组织
		 * @return 当前对象
		*/
		public UserImport setCompanyName(String companyName) {
			super.change(COMPANY_NAME,super.getCompanyName(),companyName);
			super.setCompanyName(companyName);
			return this;
		}
		
		/**
		 * 设置 组织ID
		 * @param companyId 组织ID
		 * @return 当前对象
		*/
		public UserImport setCompanyId(String companyId) {
			super.change(COMPANY_ID,super.getCompanyId(),companyId);
			super.setCompanyId(companyId);
			return this;
		}
		
		/**
		 * 设置 主岗
		 * @param masterPost 主岗
		 * @return 当前对象
		*/
		public UserImport setMasterPost(String masterPost) {
			super.change(MASTER_POST,super.getMasterPost(),masterPost);
			super.setMasterPost(masterPost);
			return this;
		}
		
		/**
		 * 设置 主岗ID
		 * @param masterPostId 主岗ID
		 * @return 当前对象
		*/
		public UserImport setMasterPostId(String masterPostId) {
			super.change(MASTER_POST_ID,super.getMasterPostId(),masterPostId);
			super.setMasterPostId(masterPostId);
			return this;
		}
		
		/**
		 * 设置 身份证
		 * @param idCard 身份证
		 * @return 当前对象
		*/
		public UserImport setIdCard(String idCard) {
			super.change(ID_CARD,super.getIdCard(),idCard);
			super.setIdCard(idCard);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public UserImport setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 状态编码
		 * @param statusCode 状态编码
		 * @return 当前对象
		*/
		public UserImport setStatusCode(String statusCode) {
			super.change(STATUS_CODE,super.getStatusCode(),statusCode);
			super.setStatusCode(statusCode);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public UserImport setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public UserImport setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public UserImport setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public UserImport setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public UserImport setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public UserImport setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public UserImport setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public UserImport setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public UserImportVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public UserImportVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setIdCard(this.getIdCard());
			inst.setCompanyName(this.getCompanyName());
			inst.setMasterPost(this.getMasterPost());
			inst.setActionStatus(this.getActionStatus());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setActionCode(this.getActionCode());
			inst.setId(this.getId());
			inst.setMasterPostId(this.getMasterPostId());
			inst.setSex(this.getSex());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setUserName(this.getUserName());
			inst.setVersion(this.getVersion());
			inst.setActionOperTime(this.getActionOperTime());
			inst.setBadge(this.getBadge());
			inst.setSexCode(this.getSexCode());
			inst.setCompanyId(this.getCompanyId());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setPhone(this.getPhone());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setActionMsg(this.getActionMsg());
			inst.setStatus(this.getStatus());
			inst.setStatusCode(this.getStatusCode());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setPageSize(this.getPageSize());
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