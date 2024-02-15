package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AttendanceDateVO;
import java.util.List;
import com.dt.platform.domain.hr.AttendanceDate;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-15 13:46:06
 * @sign 7DDE6E3B824031D6A9C313D7A9729479
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AttendanceDateVOMeta extends AttendanceDateMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 年份 , 类型: java.lang.String
	*/
	public static final String YEAR="year";
	
	/**
	 * 年份 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> YEAR_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,YEAR, java.lang.String.class, "年份", "年份", java.lang.String.class, null);
	
	/**
	 * 日期 , 类型: java.lang.String
	*/
	public static final String DATE_STR="dateStr";
	
	/**
	 * 日期 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> DATE_STR_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,DATE_STR, java.lang.String.class, "日期", "日期", java.lang.String.class, null);
	
	/**
	 * 周 , 类型: java.lang.String
	*/
	public static final String WEEK="week";
	
	/**
	 * 周 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> WEEK_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,WEEK, java.lang.String.class, "周", "周", java.lang.String.class, null);
	
	/**
	 * 法定假日 , 类型: java.lang.String
	*/
	public static final String STATUTORY_HOLIDAY="statutoryHoliday";
	
	/**
	 * 法定假日 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> STATUTORY_HOLIDAY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,STATUTORY_HOLIDAY, java.lang.String.class, "法定假日", "法定假日", java.lang.String.class, null);
	
	/**
	 * 节日 , 类型: java.lang.String
	*/
	public static final String HOLIDAY="holiday";
	
	/**
	 * 节日 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> HOLIDAY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,HOLIDAY, java.lang.String.class, "节日", "节日", java.lang.String.class, null);
	
	/**
	 * 考勤签到 , 类型: java.lang.String
	*/
	public static final String ATTENDANC_SIGN="attendancSign";
	
	/**
	 * 考勤签到 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> ATTENDANC_SIGN_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,ATTENDANC_SIGN, java.lang.String.class, "考勤签到", "考勤签到", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * confSDate , 类型: java.util.Date
	*/
	public static final String CONF_S_DATE="confSDate";
	
	/**
	 * confSDate , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.util.Date> CONF_S_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,CONF_S_DATE, java.util.Date.class, "confSDate", "confSDate", java.util.Date.class, null);
	
	/**
	 * confEDate , 类型: java.util.Date
	*/
	public static final String CONF_E_DATE="confEDate";
	
	/**
	 * confEDate , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.util.Date> CONF_E_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,CONF_E_DATE, java.util.Date.class, "confEDate", "confEDate", java.util.Date.class, null);
	
	/**
	 * confCreateDate , 类型: java.lang.String
	*/
	public static final String CONF_CREATE_DATE="confCreateDate";
	
	/**
	 * confCreateDate , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDateVO,java.lang.String> CONF_CREATE_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDateVO.class ,CONF_CREATE_DATE, java.lang.String.class, "confCreateDate", "confCreateDate", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , YEAR , DATE_STR , WEEK , STATUTORY_HOLIDAY , HOLIDAY , ATTENDANC_SIGN , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CONF_S_DATE , CONF_E_DATE , CONF_CREATE_DATE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AttendanceDateVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public AttendanceDateVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public AttendanceDateVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public AttendanceDateVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public AttendanceDateVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public AttendanceDateVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public AttendanceDateVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public AttendanceDateVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public AttendanceDateVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public AttendanceDateVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public AttendanceDateVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public AttendanceDateVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public AttendanceDateVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AttendanceDate setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 年份
		 * @param year 年份
		 * @return 当前对象
		*/
		public AttendanceDate setYear(String year) {
			super.change(YEAR,super.getYear(),year);
			super.setYear(year);
			return this;
		}
		
		/**
		 * 设置 日期
		 * @param dateStr 日期
		 * @return 当前对象
		*/
		public AttendanceDate setDateStr(String dateStr) {
			super.change(DATE_STR,super.getDateStr(),dateStr);
			super.setDateStr(dateStr);
			return this;
		}
		
		/**
		 * 设置 周
		 * @param week 周
		 * @return 当前对象
		*/
		public AttendanceDate setWeek(String week) {
			super.change(WEEK,super.getWeek(),week);
			super.setWeek(week);
			return this;
		}
		
		/**
		 * 设置 法定假日
		 * @param statutoryHoliday 法定假日
		 * @return 当前对象
		*/
		public AttendanceDate setStatutoryHoliday(String statutoryHoliday) {
			super.change(STATUTORY_HOLIDAY,super.getStatutoryHoliday(),statutoryHoliday);
			super.setStatutoryHoliday(statutoryHoliday);
			return this;
		}
		
		/**
		 * 设置 节日
		 * @param holiday 节日
		 * @return 当前对象
		*/
		public AttendanceDate setHoliday(String holiday) {
			super.change(HOLIDAY,super.getHoliday(),holiday);
			super.setHoliday(holiday);
			return this;
		}
		
		/**
		 * 设置 考勤签到
		 * @param attendancSign 考勤签到
		 * @return 当前对象
		*/
		public AttendanceDate setAttendancSign(String attendancSign) {
			super.change(ATTENDANC_SIGN,super.getAttendancSign(),attendancSign);
			super.setAttendancSign(attendancSign);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AttendanceDate setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AttendanceDate setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AttendanceDate setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AttendanceDate setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AttendanceDate setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AttendanceDate setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AttendanceDate setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AttendanceDate setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AttendanceDate setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 confSDate
		 * @param confSDate confSDate
		 * @return 当前对象
		*/
		public AttendanceDate setConfSDate(Date confSDate) {
			super.change(CONF_S_DATE,super.getConfSDate(),confSDate);
			super.setConfSDate(confSDate);
			return this;
		}
		
		/**
		 * 设置 confEDate
		 * @param confEDate confEDate
		 * @return 当前对象
		*/
		public AttendanceDate setConfEDate(Date confEDate) {
			super.change(CONF_E_DATE,super.getConfEDate(),confEDate);
			super.setConfEDate(confEDate);
			return this;
		}
		
		/**
		 * 设置 confCreateDate
		 * @param confCreateDate confCreateDate
		 * @return 当前对象
		*/
		public AttendanceDate setConfCreateDate(String confCreateDate) {
			super.change(CONF_CREATE_DATE,super.getConfCreateDate(),confCreateDate);
			super.setConfCreateDate(confCreateDate);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AttendanceDateVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AttendanceDateVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setWeek(this.getWeek());
			inst.setDateStr(this.getDateStr());
			inst.setYear(this.getYear());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setHoliday(this.getHoliday());
			inst.setVersion(this.getVersion());
			inst.setStatutoryHoliday(this.getStatutoryHoliday());
			inst.setAttendancSign(this.getAttendancSign());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setConfEDate(this.getConfEDate());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setConfSDate(this.getConfSDate());
				inst.setSearchValue(this.getSearchValue());
				inst.setConfCreateDate(this.getConfCreateDate());
			}
			inst.clearModifies();
			return inst;
		}

	}
}