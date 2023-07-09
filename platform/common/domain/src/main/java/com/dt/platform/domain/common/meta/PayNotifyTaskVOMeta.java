package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.PayNotifyTaskVO;
import java.util.List;
import com.dt.platform.domain.common.PayNotifyTask;
import java.util.Date;
import com.dt.platform.domain.common.PayMerchant;
import com.dt.platform.domain.common.PayApp;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 14:01:10
 * @sign 98F696B7022C65EDD4E72DD50E0B3C21
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PayNotifyTaskVOMeta extends PayNotifyTaskMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 任务编号 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 任务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,ID, java.lang.String.class, "任务编号", "任务编号", java.lang.String.class, null);
	
	/**
	 * 通知状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 通知状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,STATUS, java.lang.String.class, "通知状态", "通知状态", java.lang.String.class, null);
	
	/**
	 * 商户编号 , 类型: java.lang.String
	*/
	public static final String MERCHANT_ID="merchantId";
	
	/**
	 * 商户编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> MERCHANT_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,MERCHANT_ID, java.lang.String.class, "商户编号", "商户编号", java.lang.String.class, null);
	
	/**
	 * 应用编号 , 类型: java.lang.String
	*/
	public static final String APP_ID="appId";
	
	/**
	 * 应用编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> APP_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,APP_ID, java.lang.String.class, "应用编号", "应用编号", java.lang.String.class, null);
	
	/**
	 * 通知类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 通知类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,TYPE, java.lang.String.class, "通知类型", "通知类型", java.lang.String.class, null);
	
	/**
	 * 数据编号 , 类型: java.lang.String
	*/
	public static final String DATA_ID="dataId";
	
	/**
	 * 数据编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> DATA_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,DATA_ID, java.lang.String.class, "数据编号", "数据编号", java.lang.String.class, null);
	
	/**
	 * 商户订单编号 , 类型: java.lang.String
	*/
	public static final String MERCHANT_ORDER_ID="merchantOrderId";
	
	/**
	 * 商户订单编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> MERCHANT_ORDER_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,MERCHANT_ORDER_ID, java.lang.String.class, "商户订单编号", "商户订单编号", java.lang.String.class, null);
	
	/**
	 * 下一次通知时间 , 类型: java.util.Date
	*/
	public static final String NEXT_NOTIFY_TIME="nextNotifyTime";
	
	/**
	 * 下一次通知时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.util.Date> NEXT_NOTIFY_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,NEXT_NOTIFY_TIME, java.util.Date.class, "下一次通知时间", "下一次通知时间", java.util.Date.class, null);
	
	/**
	 * 最后一次执行时间 , 类型: java.util.Date
	*/
	public static final String LAST_EXECUTE_TIME="lastExecuteTime";
	
	/**
	 * 最后一次执行时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.util.Date> LAST_EXECUTE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,LAST_EXECUTE_TIME, java.util.Date.class, "最后一次执行时间", "最后一次执行时间", java.util.Date.class, null);
	
	/**
	 * 当前通知次数 , 类型: java.lang.Integer
	*/
	public static final String NOTIFY_TIMES="notifyTimes";
	
	/**
	 * 当前通知次数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.Integer> NOTIFY_TIMES_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,NOTIFY_TIMES, java.lang.Integer.class, "当前通知次数", "当前通知次数", java.lang.Integer.class, null);
	
	/**
	 * 最大可通知次数 , 类型: java.lang.Integer
	*/
	public static final String MAX_NOTIFY_TIMES="maxNotifyTimes";
	
	/**
	 * 最大可通知次数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.Integer> MAX_NOTIFY_TIMES_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,MAX_NOTIFY_TIMES, java.lang.Integer.class, "最大可通知次数", "最大可通知次数", java.lang.Integer.class, null);
	
	/**
	 * 异步通知地址 , 类型: java.lang.String
	*/
	public static final String NOTIFY_URL="notifyUrl";
	
	/**
	 * 异步通知地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> NOTIFY_URL_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,NOTIFY_URL, java.lang.String.class, "异步通知地址", "异步通知地址", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * payMerchant , 类型: com.dt.platform.domain.common.PayMerchant
	*/
	public static final String PAY_MERCHANT="payMerchant";
	
	/**
	 * payMerchant , 类型: com.dt.platform.domain.common.PayMerchant
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,com.dt.platform.domain.common.PayMerchant> PAY_MERCHANT_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,PAY_MERCHANT, com.dt.platform.domain.common.PayMerchant.class, "payMerchant", "payMerchant", com.dt.platform.domain.common.PayMerchant.class, null);
	
	/**
	 * payApp , 类型: com.dt.platform.domain.common.PayApp
	*/
	public static final String PAY_APP="payApp";
	
	/**
	 * payApp , 类型: com.dt.platform.domain.common.PayApp
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTaskVO,com.dt.platform.domain.common.PayApp> PAY_APP_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTaskVO.class ,PAY_APP, com.dt.platform.domain.common.PayApp.class, "payApp", "payApp", com.dt.platform.domain.common.PayApp.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , STATUS , MERCHANT_ID , APP_ID , TYPE , DATA_ID , MERCHANT_ORDER_ID , NEXT_NOTIFY_TIME , LAST_EXECUTE_TIME , NOTIFY_TIMES , MAX_NOTIFY_TIMES , NOTIFY_URL , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PAY_MERCHANT , PAY_APP };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.PayNotifyTaskVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public PayNotifyTaskVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public PayNotifyTaskVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public PayNotifyTaskVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public PayNotifyTaskVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public PayNotifyTaskVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public PayNotifyTaskVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public PayNotifyTaskVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public PayNotifyTaskVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public PayNotifyTaskVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public PayNotifyTaskVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public PayNotifyTaskVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public PayNotifyTaskVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 任务编号
		 * @param id 任务编号
		 * @return 当前对象
		*/
		public PayNotifyTask setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 通知状态
		 * @param status 通知状态
		 * @return 当前对象
		*/
		public PayNotifyTask setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 商户编号
		 * @param merchantId 商户编号
		 * @return 当前对象
		*/
		public PayNotifyTask setMerchantId(String merchantId) {
			super.change(MERCHANT_ID,super.getMerchantId(),merchantId);
			super.setMerchantId(merchantId);
			return this;
		}
		
		/**
		 * 设置 应用编号
		 * @param appId 应用编号
		 * @return 当前对象
		*/
		public PayNotifyTask setAppId(String appId) {
			super.change(APP_ID,super.getAppId(),appId);
			super.setAppId(appId);
			return this;
		}
		
		/**
		 * 设置 通知类型
		 * @param type 通知类型
		 * @return 当前对象
		*/
		public PayNotifyTask setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 数据编号
		 * @param dataId 数据编号
		 * @return 当前对象
		*/
		public PayNotifyTask setDataId(String dataId) {
			super.change(DATA_ID,super.getDataId(),dataId);
			super.setDataId(dataId);
			return this;
		}
		
		/**
		 * 设置 商户订单编号
		 * @param merchantOrderId 商户订单编号
		 * @return 当前对象
		*/
		public PayNotifyTask setMerchantOrderId(String merchantOrderId) {
			super.change(MERCHANT_ORDER_ID,super.getMerchantOrderId(),merchantOrderId);
			super.setMerchantOrderId(merchantOrderId);
			return this;
		}
		
		/**
		 * 设置 下一次通知时间
		 * @param nextNotifyTime 下一次通知时间
		 * @return 当前对象
		*/
		public PayNotifyTask setNextNotifyTime(Date nextNotifyTime) {
			super.change(NEXT_NOTIFY_TIME,super.getNextNotifyTime(),nextNotifyTime);
			super.setNextNotifyTime(nextNotifyTime);
			return this;
		}
		
		/**
		 * 设置 最后一次执行时间
		 * @param lastExecuteTime 最后一次执行时间
		 * @return 当前对象
		*/
		public PayNotifyTask setLastExecuteTime(Date lastExecuteTime) {
			super.change(LAST_EXECUTE_TIME,super.getLastExecuteTime(),lastExecuteTime);
			super.setLastExecuteTime(lastExecuteTime);
			return this;
		}
		
		/**
		 * 设置 当前通知次数
		 * @param notifyTimes 当前通知次数
		 * @return 当前对象
		*/
		public PayNotifyTask setNotifyTimes(Integer notifyTimes) {
			super.change(NOTIFY_TIMES,super.getNotifyTimes(),notifyTimes);
			super.setNotifyTimes(notifyTimes);
			return this;
		}
		
		/**
		 * 设置 最大可通知次数
		 * @param maxNotifyTimes 最大可通知次数
		 * @return 当前对象
		*/
		public PayNotifyTask setMaxNotifyTimes(Integer maxNotifyTimes) {
			super.change(MAX_NOTIFY_TIMES,super.getMaxNotifyTimes(),maxNotifyTimes);
			super.setMaxNotifyTimes(maxNotifyTimes);
			return this;
		}
		
		/**
		 * 设置 异步通知地址
		 * @param notifyUrl 异步通知地址
		 * @return 当前对象
		*/
		public PayNotifyTask setNotifyUrl(String notifyUrl) {
			super.change(NOTIFY_URL,super.getNotifyUrl(),notifyUrl);
			super.setNotifyUrl(notifyUrl);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PayNotifyTask setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PayNotifyTask setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PayNotifyTask setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PayNotifyTask setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PayNotifyTask setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PayNotifyTask setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PayNotifyTask setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PayNotifyTask setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PayNotifyTask setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 payMerchant
		 * @param payMerchant payMerchant
		 * @return 当前对象
		*/
		public PayNotifyTask setPayMerchant(PayMerchant payMerchant) {
			super.change(PAY_MERCHANT,super.getPayMerchant(),payMerchant);
			super.setPayMerchant(payMerchant);
			return this;
		}
		
		/**
		 * 设置 payApp
		 * @param payApp payApp
		 * @return 当前对象
		*/
		public PayNotifyTask setPayApp(PayApp payApp) {
			super.change(PAY_APP,super.getPayApp(),payApp);
			super.setPayApp(payApp);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PayNotifyTaskVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PayNotifyTaskVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setUpdateTime(this.getUpdateTime());
			inst.setMerchantOrderId(this.getMerchantOrderId());
			inst.setType(this.getType());
			inst.setVersion(this.getVersion());
			inst.setNextNotifyTime(this.getNextNotifyTime());
			inst.setLastExecuteTime(this.getLastExecuteTime());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setDataId(this.getDataId());
			inst.setMerchantId(this.getMerchantId());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setAppId(this.getAppId());
			inst.setTenantId(this.getTenantId());
			inst.setNotifyUrl(this.getNotifyUrl());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setNotifyTimes(this.getNotifyTimes());
			inst.setMaxNotifyTimes(this.getMaxNotifyTimes());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setPayMerchant(this.getPayMerchant());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setPayApp(this.getPayApp());
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