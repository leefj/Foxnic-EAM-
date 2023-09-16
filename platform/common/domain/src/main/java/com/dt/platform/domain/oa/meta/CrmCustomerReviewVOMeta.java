package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.CrmCustomerReviewVO;
import java.util.List;
import com.dt.platform.domain.oa.CrmCustomerReview;
import java.util.Date;
import com.dt.platform.domain.oa.CrmCustomer;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-16 22:52:01
 * @sign 617A13809FEEDE2E7577277E823FE046
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CrmCustomerReviewVOMeta extends CrmCustomerReviewMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 客户 , 类型: java.lang.String
	*/
	public static final String CUSTOMER_ID="customerId";
	
	/**
	 * 客户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> CUSTOMER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,CUSTOMER_ID, java.lang.String.class, "客户", "客户", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 回访人 , 类型: java.lang.String
	*/
	public static final String REVIEW_USER_ID="reviewUserId";
	
	/**
	 * 回访人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> REVIEW_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,REVIEW_USER_ID, java.lang.String.class, "回访人", "回访人", java.lang.String.class, null);
	
	/**
	 * 回访时间 , 类型: java.util.Date
	*/
	public static final String REVIEW_DATE="reviewDate";
	
	/**
	 * 回访时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.util.Date> REVIEW_DATE_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,REVIEW_DATE, java.util.Date.class, "回访时间", "回访时间", java.util.Date.class, null);
	
	/**
	 * 回访形式 , 类型: java.lang.String
	*/
	public static final String METHOD_ID="methodId";
	
	/**
	 * 回访形式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> METHOD_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,METHOD_ID, java.lang.String.class, "回访形式", "回访形式", java.lang.String.class, null);
	
	/**
	 * 客户满意度 , 类型: java.lang.String
	*/
	public static final String SATISFACTION_ID="satisfactionId";
	
	/**
	 * 客户满意度 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> SATISFACTION_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,SATISFACTION_ID, java.lang.String.class, "客户满意度", "客户满意度", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String FILE_ID="fileId";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> FILE_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,FILE_ID, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * crmCustomer , 类型: com.dt.platform.domain.oa.CrmCustomer
	*/
	public static final String CRM_CUSTOMER="crmCustomer";
	
	/**
	 * crmCustomer , 类型: com.dt.platform.domain.oa.CrmCustomer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,com.dt.platform.domain.oa.CrmCustomer> CRM_CUSTOMER_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,CRM_CUSTOMER, com.dt.platform.domain.oa.CrmCustomer.class, "crmCustomer", "crmCustomer", com.dt.platform.domain.oa.CrmCustomer.class, null);
	
	/**
	 * originator , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * originator , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "originator", "originator", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * reviewUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String REVIEW_USER="reviewUser";
	
	/**
	 * reviewUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,org.github.foxnic.web.domain.hrm.Employee> REVIEW_USER_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,REVIEW_USER, org.github.foxnic.web.domain.hrm.Employee.class, "reviewUser", "reviewUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * reviewMethod , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String REVIEW_METHOD="reviewMethod";
	
	/**
	 * reviewMethod , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,org.github.foxnic.web.domain.system.DictItem> REVIEW_METHOD_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,REVIEW_METHOD, org.github.foxnic.web.domain.system.DictItem.class, "reviewMethod", "reviewMethod", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * satisfaction , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String SATISFACTION="satisfaction";
	
	/**
	 * satisfaction , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerReviewVO,org.github.foxnic.web.domain.system.DictItem> SATISFACTION_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerReviewVO.class ,SATISFACTION, org.github.foxnic.web.domain.system.DictItem.class, "satisfaction", "satisfaction", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , CUSTOMER_ID , NAME , REVIEW_USER_ID , REVIEW_DATE , METHOD_ID , SATISFACTION_ID , FILE_ID , NOTES , ORIGINATOR_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , CRM_CUSTOMER , ORIGINATOR , REVIEW_USER , REVIEW_METHOD , SATISFACTION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.CrmCustomerReviewVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public CrmCustomerReviewVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public CrmCustomerReviewVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public CrmCustomerReviewVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public CrmCustomerReviewVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public CrmCustomerReviewVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public CrmCustomerReviewVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public CrmCustomerReviewVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public CrmCustomerReviewVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public CrmCustomerReviewVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public CrmCustomerReviewVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public CrmCustomerReviewVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public CrmCustomerReviewVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CrmCustomerReview setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 客户
		 * @param customerId 客户
		 * @return 当前对象
		*/
		public CrmCustomerReview setCustomerId(String customerId) {
			super.change(CUSTOMER_ID,super.getCustomerId(),customerId);
			super.setCustomerId(customerId);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public CrmCustomerReview setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 回访人
		 * @param reviewUserId 回访人
		 * @return 当前对象
		*/
		public CrmCustomerReview setReviewUserId(String reviewUserId) {
			super.change(REVIEW_USER_ID,super.getReviewUserId(),reviewUserId);
			super.setReviewUserId(reviewUserId);
			return this;
		}
		
		/**
		 * 设置 回访时间
		 * @param reviewDate 回访时间
		 * @return 当前对象
		*/
		public CrmCustomerReview setReviewDate(Date reviewDate) {
			super.change(REVIEW_DATE,super.getReviewDate(),reviewDate);
			super.setReviewDate(reviewDate);
			return this;
		}
		
		/**
		 * 设置 回访形式
		 * @param methodId 回访形式
		 * @return 当前对象
		*/
		public CrmCustomerReview setMethodId(String methodId) {
			super.change(METHOD_ID,super.getMethodId(),methodId);
			super.setMethodId(methodId);
			return this;
		}
		
		/**
		 * 设置 客户满意度
		 * @param satisfactionId 客户满意度
		 * @return 当前对象
		*/
		public CrmCustomerReview setSatisfactionId(String satisfactionId) {
			super.change(SATISFACTION_ID,super.getSatisfactionId(),satisfactionId);
			super.setSatisfactionId(satisfactionId);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param fileId 附件
		 * @return 当前对象
		*/
		public CrmCustomerReview setFileId(String fileId) {
			super.change(FILE_ID,super.getFileId(),fileId);
			super.setFileId(fileId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public CrmCustomerReview setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public CrmCustomerReview setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public CrmCustomerReview setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CrmCustomerReview setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CrmCustomerReview setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CrmCustomerReview setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CrmCustomerReview setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CrmCustomerReview setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CrmCustomerReview setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CrmCustomerReview setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public CrmCustomerReview setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 crmCustomer
		 * @param crmCustomer crmCustomer
		 * @return 当前对象
		*/
		public CrmCustomerReview setCrmCustomer(CrmCustomer crmCustomer) {
			super.change(CRM_CUSTOMER,super.getCrmCustomer(),crmCustomer);
			super.setCrmCustomer(crmCustomer);
			return this;
		}
		
		/**
		 * 设置 originator
		 * @param originator originator
		 * @return 当前对象
		*/
		public CrmCustomerReview setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 reviewUser
		 * @param reviewUser reviewUser
		 * @return 当前对象
		*/
		public CrmCustomerReview setReviewUser(Employee reviewUser) {
			super.change(REVIEW_USER,super.getReviewUser(),reviewUser);
			super.setReviewUser(reviewUser);
			return this;
		}
		
		/**
		 * 设置 reviewMethod
		 * @param reviewMethod reviewMethod
		 * @return 当前对象
		*/
		public CrmCustomerReview setReviewMethod(DictItem reviewMethod) {
			super.change(REVIEW_METHOD,super.getReviewMethod(),reviewMethod);
			super.setReviewMethod(reviewMethod);
			return this;
		}
		
		/**
		 * 设置 satisfaction
		 * @param satisfaction satisfaction
		 * @return 当前对象
		*/
		public CrmCustomerReview setSatisfaction(DictItem satisfaction) {
			super.change(SATISFACTION,super.getSatisfaction(),satisfaction);
			super.setSatisfaction(satisfaction);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CrmCustomerReviewVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CrmCustomerReviewVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setMethodId(this.getMethodId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setReviewUserId(this.getReviewUserId());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setReviewDate(this.getReviewDate());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setCustomerId(this.getCustomerId());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setSatisfactionId(this.getSatisfactionId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setOriginatorId(this.getOriginatorId());
			inst.setFileId(this.getFileId());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setOriginator(this.getOriginator());
				inst.setSatisfaction(this.getSatisfaction());
				inst.setReviewMethod(this.getReviewMethod());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setCrmCustomer(this.getCrmCustomer());
				inst.setReviewUser(this.getReviewUser());
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