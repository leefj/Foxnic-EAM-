package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AttendanceDataVO;
import java.util.List;
import com.dt.platform.domain.hr.AttendanceData;
import java.util.Date;
import java.math.BigDecimal;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.AttendanceTpl;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-25 21:45:45
 * @sign 2B94EE770E339D33D2C0FCE396EAEEC3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AttendanceDataVOMeta extends AttendanceDataMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final String PERSON_ID="personId";
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> PERSON_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,PERSON_ID, java.lang.String.class, "人员", "人员", java.lang.String.class, null);
	
	/**
	 * 考勤组 , 类型: java.lang.String
	*/
	public static final String ATTENDANCE_TPL_CODE="attendanceTplCode";
	
	/**
	 * 考勤组 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> ATTENDANCE_TPL_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,ATTENDANCE_TPL_CODE, java.lang.String.class, "考勤组", "考勤组", java.lang.String.class, null);
	
	/**
	 * 是否工作日 , 类型: java.lang.String
	*/
	public static final String IS_WORK_DAY="isWorkDay";
	
	/**
	 * 是否工作日 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> IS_WORK_DAY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,IS_WORK_DAY, java.lang.String.class, "是否工作日", "是否工作日", java.lang.String.class, null);
	
	/**
	 * 考勤日期 , 类型: java.util.Date
	*/
	public static final String ATTENDANCE_DATE="attendanceDate";
	
	/**
	 * 考勤日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.util.Date> ATTENDANCE_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,ATTENDANCE_DATE, java.util.Date.class, "考勤日期", "考勤日期", java.util.Date.class, null);
	
	/**
	 * 考勤日期 , 类型: java.lang.String
	*/
	public static final String ATTENDANCE_DATE_STR="attendanceDateStr";
	
	/**
	 * 考勤日期 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> ATTENDANCE_DATE_STR_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,ATTENDANCE_DATE_STR, java.lang.String.class, "考勤日期", "考勤日期", java.lang.String.class, null);
	
	/**
	 * 结果 , 类型: java.lang.String
	*/
	public static final String RESULT="result";
	
	/**
	 * 结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> RESULT_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,RESULT, java.lang.String.class, "结果", "结果", java.lang.String.class, null);
	
	/**
	 * 上班天数 , 类型: java.math.BigDecimal
	*/
	public static final String NORMAL_DAY="normalDay";
	
	/**
	 * 上班天数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.math.BigDecimal> NORMAL_DAY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,NORMAL_DAY, java.math.BigDecimal.class, "上班天数", "上班天数", java.math.BigDecimal.class, null);
	
	/**
	 * 应上班天数 , 类型: java.math.BigDecimal
	*/
	public static final String NEED_DAY="needDay";
	
	/**
	 * 应上班天数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.math.BigDecimal> NEED_DAY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,NEED_DAY, java.math.BigDecimal.class, "应上班天数", "应上班天数", java.math.BigDecimal.class, null);
	
	/**
	 * 上班打卡 , 类型: java.util.Date
	*/
	public static final String ON_WORK_TIME="onWorkTime";
	
	/**
	 * 上班打卡 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.util.Date> ON_WORK_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,ON_WORK_TIME, java.util.Date.class, "上班打卡", "上班打卡", java.util.Date.class, null);
	
	/**
	 * 最早打卡 , 类型: java.util.Date
	*/
	public static final String ON_WORK_TIME2="onWorkTime2";
	
	/**
	 * 最早打卡 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.util.Date> ON_WORK_TIME2_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,ON_WORK_TIME2, java.util.Date.class, "最早打卡", "最早打卡", java.util.Date.class, null);
	
	/**
	 * 下班打卡 , 类型: java.util.Date
	*/
	public static final String OFF_WORK_TIME="offWorkTime";
	
	/**
	 * 下班打卡 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.util.Date> OFF_WORK_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,OFF_WORK_TIME, java.util.Date.class, "下班打卡", "下班打卡", java.util.Date.class, null);
	
	/**
	 * 最晚打卡 , 类型: java.util.Date
	*/
	public static final String OFF_WORK_TIME2="offWorkTime2";
	
	/**
	 * 最晚打卡 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.util.Date> OFF_WORK_TIME2_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,OFF_WORK_TIME2, java.util.Date.class, "最晚打卡", "最晚打卡", java.util.Date.class, null);
	
	/**
	 * 迟到 , 次) , 类型: java.lang.Integer
	*/
	public static final String LEAVE_EARLY="leaveEarly";
	
	/**
	 * 迟到 , 次) , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.Integer> LEAVE_EARLY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,LEAVE_EARLY, java.lang.Integer.class, "迟到", "次)", java.lang.Integer.class, null);
	
	/**
	 * 迟到 , 分) , 类型: java.math.BigDecimal
	*/
	public static final String LEAVE_EARLY_TIME="leaveEarlyTime";
	
	/**
	 * 迟到 , 分) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.math.BigDecimal> LEAVE_EARLY_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,LEAVE_EARLY_TIME, java.math.BigDecimal.class, "迟到", "分)", java.math.BigDecimal.class, null);
	
	/**
	 * 早退 , 次) , 类型: java.lang.Integer
	*/
	public static final String LEAVE_LATE="leaveLate";
	
	/**
	 * 早退 , 次) , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.Integer> LEAVE_LATE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,LEAVE_LATE, java.lang.Integer.class, "早退", "次)", java.lang.Integer.class, null);
	
	/**
	 * 早退 , 分) , 类型: java.math.BigDecimal
	*/
	public static final String LEAVE_LATE_TIME="leaveLateTime";
	
	/**
	 * 早退 , 分) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.math.BigDecimal> LEAVE_LATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,LEAVE_LATE_TIME, java.math.BigDecimal.class, "早退", "分)", java.math.BigDecimal.class, null);
	
	/**
	 * 上班缺卡 , 次) , 类型: java.lang.Integer
	*/
	public static final String LOSS_EARLY="lossEarly";
	
	/**
	 * 上班缺卡 , 次) , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.Integer> LOSS_EARLY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,LOSS_EARLY, java.lang.Integer.class, "上班缺卡", "次)", java.lang.Integer.class, null);
	
	/**
	 * 下班却卡 , 次) , 类型: java.lang.Integer
	*/
	public static final String LOSS_LATE="lossLate";
	
	/**
	 * 下班却卡 , 次) , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.Integer> LOSS_LATE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,LOSS_LATE, java.lang.Integer.class, "下班却卡", "次)", java.lang.Integer.class, null);
	
	/**
	 * 缺卡处理 , 次) , 类型: java.lang.Integer
	*/
	public static final String LOSS_PROCESS="lossProcess";
	
	/**
	 * 缺卡处理 , 次) , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.Integer> LOSS_PROCESS_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,LOSS_PROCESS, java.lang.Integer.class, "缺卡处理", "次)", java.lang.Integer.class, null);
	
	/**
	 * 工作日加班 , 小时) , 类型: java.math.BigDecimal
	*/
	public static final String JB_GZR="jbGzr";
	
	/**
	 * 工作日加班 , 小时) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.math.BigDecimal> JB_GZR_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,JB_GZR, java.math.BigDecimal.class, "工作日加班", "小时)", java.math.BigDecimal.class, null);
	
	/**
	 * 休息日加班 , 小时) , 类型: java.math.BigDecimal
	*/
	public static final String JB_XXR="jbXxr";
	
	/**
	 * 休息日加班 , 小时) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.math.BigDecimal> JB_XXR_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,JB_XXR, java.math.BigDecimal.class, "休息日加班", "小时)", java.math.BigDecimal.class, null);
	
	/**
	 * 节假日加班 , 小时) , 类型: java.math.BigDecimal
	*/
	public static final String JB_JJR="jbJjr";
	
	/**
	 * 节假日加班 , 小时) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.math.BigDecimal> JB_JJR_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,JB_JJR, java.math.BigDecimal.class, "节假日加班", "小时)", java.math.BigDecimal.class, null);
	
	/**
	 * 出差 , 天) , 类型: java.math.BigDecimal
	*/
	public static final String CC="cc";
	
	/**
	 * 出差 , 天) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.math.BigDecimal> CC_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,CC, java.math.BigDecimal.class, "出差", "天)", java.math.BigDecimal.class, null);
	
	/**
	 * 年假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final String QJ_NJ="qjNj";
	
	/**
	 * 年假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.math.BigDecimal> QJ_NJ_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,QJ_NJ, java.math.BigDecimal.class, "年假", "天)", java.math.BigDecimal.class, null);
	
	/**
	 * 工伤假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final String QJ_GSJ="qjGsj";
	
	/**
	 * 工伤假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.math.BigDecimal> QJ_GSJ_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,QJ_GSJ, java.math.BigDecimal.class, "工伤假", "天)", java.math.BigDecimal.class, null);
	
	/**
	 * 产假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final String QJ_CJ="qjCj";
	
	/**
	 * 产假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.math.BigDecimal> QJ_CJ_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,QJ_CJ, java.math.BigDecimal.class, "产假", "天)", java.math.BigDecimal.class, null);
	
	/**
	 * 婚假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final String QJ_HJ="qjHj";
	
	/**
	 * 婚假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.math.BigDecimal> QJ_HJ_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,QJ_HJ, java.math.BigDecimal.class, "婚假", "天)", java.math.BigDecimal.class, null);
	
	/**
	 * 病假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final String QJ_BJ="qjBj";
	
	/**
	 * 病假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.math.BigDecimal> QJ_BJ_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,QJ_BJ, java.math.BigDecimal.class, "病假", "天)", java.math.BigDecimal.class, null);
	
	/**
	 * 事假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final String QJ_SJ="qjSj";
	
	/**
	 * 事假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.math.BigDecimal> QJ_SJ_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,QJ_SJ, java.math.BigDecimal.class, "事假", "天)", java.math.BigDecimal.class, null);
	
	/**
	 * 调休假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final String QJ_TXJ="qjTxj";
	
	/**
	 * 调休假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.math.BigDecimal> QJ_TXJ_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,QJ_TXJ, java.math.BigDecimal.class, "调休假", "天)", java.math.BigDecimal.class, null);
	
	/**
	 * 哺乳假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final String QJ_PLJ="qjPlj";
	
	/**
	 * 哺乳假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.math.BigDecimal> QJ_PLJ_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,QJ_PLJ, java.math.BigDecimal.class, "哺乳假", "天)", java.math.BigDecimal.class, null);
	
	/**
	 * 批次号 , 类型: java.lang.String
	*/
	public static final String BATCH_CODE="batchCode";
	
	/**
	 * 批次号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> BATCH_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,BATCH_CODE, java.lang.String.class, "批次号", "批次号", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 关联 , 类型: java.lang.String
	*/
	public static final String REL_ID="relId";
	
	/**
	 * 关联 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> REL_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,REL_ID, java.lang.String.class, "关联", "关联", java.lang.String.class, null);
	
	/**
	 * 说明 , 类型: java.lang.String
	*/
	public static final String DAY_INFO="dayInfo";
	
	/**
	 * 说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> DAY_INFO_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,DAY_INFO, java.lang.String.class, "说明", "说明", java.lang.String.class, null);
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final String RCD_TIME="rcdTime";
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.util.Date> RCD_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,RCD_TIME, java.util.Date.class, "记录时间", "记录时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * person , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final String PERSON="person";
	
	/**
	 * person , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,com.dt.platform.domain.hr.Person> PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,PERSON, com.dt.platform.domain.hr.Person.class, "person", "person", com.dt.platform.domain.hr.Person.class, null);
	
	/**
	 * attendanceTpl , 类型: com.dt.platform.domain.hr.AttendanceTpl
	*/
	public static final String ATTENDANCE_TPL="attendanceTpl";
	
	/**
	 * attendanceTpl , 类型: com.dt.platform.domain.hr.AttendanceTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,com.dt.platform.domain.hr.AttendanceTpl> ATTENDANCE_TPL_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,ATTENDANCE_TPL, com.dt.platform.domain.hr.AttendanceTpl.class, "attendanceTpl", "attendanceTpl", com.dt.platform.domain.hr.AttendanceTpl.class, null);
	
	/**
	 * personJobName , 类型: java.lang.String
	*/
	public static final String PERSON_JOB_NAME="personJobName";
	
	/**
	 * personJobName , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> PERSON_JOB_NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,PERSON_JOB_NAME, java.lang.String.class, "personJobName", "personJobName", java.lang.String.class, null);
	
	/**
	 * sJobNumber , 类型: java.lang.String
	*/
	public static final String S_JOB_NUMBER="sJobNumber";
	
	/**
	 * sJobNumber , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> S_JOB_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,S_JOB_NUMBER, java.lang.String.class, "sJobNumber", "sJobNumber", java.lang.String.class, null);
	
	/**
	 * rq , 类型: java.lang.String
	*/
	public static final String RQ="rq";
	
	/**
	 * rq , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> RQ_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,RQ, java.lang.String.class, "rq", "rq", java.lang.String.class, null);
	
	/**
	 * days , 类型: java.lang.String
	*/
	public static final String DAYS="days";
	
	/**
	 * days , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDataVO,java.lang.String> DAYS_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDataVO.class ,DAYS, java.lang.String.class, "days", "days", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , PERSON_ID , ATTENDANCE_TPL_CODE , IS_WORK_DAY , ATTENDANCE_DATE , ATTENDANCE_DATE_STR , RESULT , NORMAL_DAY , NEED_DAY , ON_WORK_TIME , ON_WORK_TIME2 , OFF_WORK_TIME , OFF_WORK_TIME2 , LEAVE_EARLY , LEAVE_EARLY_TIME , LEAVE_LATE , LEAVE_LATE_TIME , LOSS_EARLY , LOSS_LATE , LOSS_PROCESS , JB_GZR , JB_XXR , JB_JJR , CC , QJ_NJ , QJ_GSJ , QJ_CJ , QJ_HJ , QJ_BJ , QJ_SJ , QJ_TXJ , QJ_PLJ , BATCH_CODE , NOTES , REL_ID , DAY_INFO , RCD_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PERSON , ATTENDANCE_TPL , PERSON_JOB_NAME , S_JOB_NUMBER , RQ , DAYS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AttendanceDataVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public AttendanceDataVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public AttendanceDataVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public AttendanceDataVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public AttendanceDataVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public AttendanceDataVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public AttendanceDataVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public AttendanceDataVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public AttendanceDataVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public AttendanceDataVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public AttendanceDataVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public AttendanceDataVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public AttendanceDataVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AttendanceData setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 人员
		 * @param personId 人员
		 * @return 当前对象
		*/
		public AttendanceData setPersonId(String personId) {
			super.change(PERSON_ID,super.getPersonId(),personId);
			super.setPersonId(personId);
			return this;
		}
		
		/**
		 * 设置 考勤组
		 * @param attendanceTplCode 考勤组
		 * @return 当前对象
		*/
		public AttendanceData setAttendanceTplCode(String attendanceTplCode) {
			super.change(ATTENDANCE_TPL_CODE,super.getAttendanceTplCode(),attendanceTplCode);
			super.setAttendanceTplCode(attendanceTplCode);
			return this;
		}
		
		/**
		 * 设置 是否工作日
		 * @param isWorkDay 是否工作日
		 * @return 当前对象
		*/
		public AttendanceData setIsWorkDay(String isWorkDay) {
			super.change(IS_WORK_DAY,super.getIsWorkDay(),isWorkDay);
			super.setIsWorkDay(isWorkDay);
			return this;
		}
		
		/**
		 * 设置 考勤日期
		 * @param attendanceDate 考勤日期
		 * @return 当前对象
		*/
		public AttendanceData setAttendanceDate(Date attendanceDate) {
			super.change(ATTENDANCE_DATE,super.getAttendanceDate(),attendanceDate);
			super.setAttendanceDate(attendanceDate);
			return this;
		}
		
		/**
		 * 设置 考勤日期
		 * @param attendanceDateStr 考勤日期
		 * @return 当前对象
		*/
		public AttendanceData setAttendanceDateStr(String attendanceDateStr) {
			super.change(ATTENDANCE_DATE_STR,super.getAttendanceDateStr(),attendanceDateStr);
			super.setAttendanceDateStr(attendanceDateStr);
			return this;
		}
		
		/**
		 * 设置 结果
		 * @param result 结果
		 * @return 当前对象
		*/
		public AttendanceData setResult(String result) {
			super.change(RESULT,super.getResult(),result);
			super.setResult(result);
			return this;
		}
		
		/**
		 * 设置 上班天数
		 * @param normalDay 上班天数
		 * @return 当前对象
		*/
		public AttendanceData setNormalDay(BigDecimal normalDay) {
			super.change(NORMAL_DAY,super.getNormalDay(),normalDay);
			super.setNormalDay(normalDay);
			return this;
		}
		
		/**
		 * 设置 应上班天数
		 * @param needDay 应上班天数
		 * @return 当前对象
		*/
		public AttendanceData setNeedDay(BigDecimal needDay) {
			super.change(NEED_DAY,super.getNeedDay(),needDay);
			super.setNeedDay(needDay);
			return this;
		}
		
		/**
		 * 设置 上班打卡
		 * @param onWorkTime 上班打卡
		 * @return 当前对象
		*/
		public AttendanceData setOnWorkTime(Date onWorkTime) {
			super.change(ON_WORK_TIME,super.getOnWorkTime(),onWorkTime);
			super.setOnWorkTime(onWorkTime);
			return this;
		}
		
		/**
		 * 设置 最早打卡
		 * @param onWorkTime2 最早打卡
		 * @return 当前对象
		*/
		public AttendanceData setOnWorkTime2(Date onWorkTime2) {
			super.change(ON_WORK_TIME2,super.getOnWorkTime2(),onWorkTime2);
			super.setOnWorkTime2(onWorkTime2);
			return this;
		}
		
		/**
		 * 设置 下班打卡
		 * @param offWorkTime 下班打卡
		 * @return 当前对象
		*/
		public AttendanceData setOffWorkTime(Date offWorkTime) {
			super.change(OFF_WORK_TIME,super.getOffWorkTime(),offWorkTime);
			super.setOffWorkTime(offWorkTime);
			return this;
		}
		
		/**
		 * 设置 最晚打卡
		 * @param offWorkTime2 最晚打卡
		 * @return 当前对象
		*/
		public AttendanceData setOffWorkTime2(Date offWorkTime2) {
			super.change(OFF_WORK_TIME2,super.getOffWorkTime2(),offWorkTime2);
			super.setOffWorkTime2(offWorkTime2);
			return this;
		}
		
		/**
		 * 设置 迟到
		 * @param leaveEarly 迟到
		 * @return 当前对象
		*/
		public AttendanceData setLeaveEarly(Integer leaveEarly) {
			super.change(LEAVE_EARLY,super.getLeaveEarly(),leaveEarly);
			super.setLeaveEarly(leaveEarly);
			return this;
		}
		
		/**
		 * 设置 迟到
		 * @param leaveEarlyTime 迟到
		 * @return 当前对象
		*/
		public AttendanceData setLeaveEarlyTime(BigDecimal leaveEarlyTime) {
			super.change(LEAVE_EARLY_TIME,super.getLeaveEarlyTime(),leaveEarlyTime);
			super.setLeaveEarlyTime(leaveEarlyTime);
			return this;
		}
		
		/**
		 * 设置 早退
		 * @param leaveLate 早退
		 * @return 当前对象
		*/
		public AttendanceData setLeaveLate(Integer leaveLate) {
			super.change(LEAVE_LATE,super.getLeaveLate(),leaveLate);
			super.setLeaveLate(leaveLate);
			return this;
		}
		
		/**
		 * 设置 早退
		 * @param leaveLateTime 早退
		 * @return 当前对象
		*/
		public AttendanceData setLeaveLateTime(BigDecimal leaveLateTime) {
			super.change(LEAVE_LATE_TIME,super.getLeaveLateTime(),leaveLateTime);
			super.setLeaveLateTime(leaveLateTime);
			return this;
		}
		
		/**
		 * 设置 上班缺卡
		 * @param lossEarly 上班缺卡
		 * @return 当前对象
		*/
		public AttendanceData setLossEarly(Integer lossEarly) {
			super.change(LOSS_EARLY,super.getLossEarly(),lossEarly);
			super.setLossEarly(lossEarly);
			return this;
		}
		
		/**
		 * 设置 下班却卡
		 * @param lossLate 下班却卡
		 * @return 当前对象
		*/
		public AttendanceData setLossLate(Integer lossLate) {
			super.change(LOSS_LATE,super.getLossLate(),lossLate);
			super.setLossLate(lossLate);
			return this;
		}
		
		/**
		 * 设置 缺卡处理
		 * @param lossProcess 缺卡处理
		 * @return 当前对象
		*/
		public AttendanceData setLossProcess(Integer lossProcess) {
			super.change(LOSS_PROCESS,super.getLossProcess(),lossProcess);
			super.setLossProcess(lossProcess);
			return this;
		}
		
		/**
		 * 设置 工作日加班
		 * @param jbGzr 工作日加班
		 * @return 当前对象
		*/
		public AttendanceData setJbGzr(BigDecimal jbGzr) {
			super.change(JB_GZR,super.getJbGzr(),jbGzr);
			super.setJbGzr(jbGzr);
			return this;
		}
		
		/**
		 * 设置 休息日加班
		 * @param jbXxr 休息日加班
		 * @return 当前对象
		*/
		public AttendanceData setJbXxr(BigDecimal jbXxr) {
			super.change(JB_XXR,super.getJbXxr(),jbXxr);
			super.setJbXxr(jbXxr);
			return this;
		}
		
		/**
		 * 设置 节假日加班
		 * @param jbJjr 节假日加班
		 * @return 当前对象
		*/
		public AttendanceData setJbJjr(BigDecimal jbJjr) {
			super.change(JB_JJR,super.getJbJjr(),jbJjr);
			super.setJbJjr(jbJjr);
			return this;
		}
		
		/**
		 * 设置 出差
		 * @param cc 出差
		 * @return 当前对象
		*/
		public AttendanceData setCc(BigDecimal cc) {
			super.change(CC,super.getCc(),cc);
			super.setCc(cc);
			return this;
		}
		
		/**
		 * 设置 年假
		 * @param qjNj 年假
		 * @return 当前对象
		*/
		public AttendanceData setQjNj(BigDecimal qjNj) {
			super.change(QJ_NJ,super.getQjNj(),qjNj);
			super.setQjNj(qjNj);
			return this;
		}
		
		/**
		 * 设置 工伤假
		 * @param qjGsj 工伤假
		 * @return 当前对象
		*/
		public AttendanceData setQjGsj(BigDecimal qjGsj) {
			super.change(QJ_GSJ,super.getQjGsj(),qjGsj);
			super.setQjGsj(qjGsj);
			return this;
		}
		
		/**
		 * 设置 产假
		 * @param qjCj 产假
		 * @return 当前对象
		*/
		public AttendanceData setQjCj(BigDecimal qjCj) {
			super.change(QJ_CJ,super.getQjCj(),qjCj);
			super.setQjCj(qjCj);
			return this;
		}
		
		/**
		 * 设置 婚假
		 * @param qjHj 婚假
		 * @return 当前对象
		*/
		public AttendanceData setQjHj(BigDecimal qjHj) {
			super.change(QJ_HJ,super.getQjHj(),qjHj);
			super.setQjHj(qjHj);
			return this;
		}
		
		/**
		 * 设置 病假
		 * @param qjBj 病假
		 * @return 当前对象
		*/
		public AttendanceData setQjBj(BigDecimal qjBj) {
			super.change(QJ_BJ,super.getQjBj(),qjBj);
			super.setQjBj(qjBj);
			return this;
		}
		
		/**
		 * 设置 事假
		 * @param qjSj 事假
		 * @return 当前对象
		*/
		public AttendanceData setQjSj(BigDecimal qjSj) {
			super.change(QJ_SJ,super.getQjSj(),qjSj);
			super.setQjSj(qjSj);
			return this;
		}
		
		/**
		 * 设置 调休假
		 * @param qjTxj 调休假
		 * @return 当前对象
		*/
		public AttendanceData setQjTxj(BigDecimal qjTxj) {
			super.change(QJ_TXJ,super.getQjTxj(),qjTxj);
			super.setQjTxj(qjTxj);
			return this;
		}
		
		/**
		 * 设置 哺乳假
		 * @param qjPlj 哺乳假
		 * @return 当前对象
		*/
		public AttendanceData setQjPlj(BigDecimal qjPlj) {
			super.change(QJ_PLJ,super.getQjPlj(),qjPlj);
			super.setQjPlj(qjPlj);
			return this;
		}
		
		/**
		 * 设置 批次号
		 * @param batchCode 批次号
		 * @return 当前对象
		*/
		public AttendanceData setBatchCode(String batchCode) {
			super.change(BATCH_CODE,super.getBatchCode(),batchCode);
			super.setBatchCode(batchCode);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AttendanceData setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 关联
		 * @param relId 关联
		 * @return 当前对象
		*/
		public AttendanceData setRelId(String relId) {
			super.change(REL_ID,super.getRelId(),relId);
			super.setRelId(relId);
			return this;
		}
		
		/**
		 * 设置 说明
		 * @param dayInfo 说明
		 * @return 当前对象
		*/
		public AttendanceData setDayInfo(String dayInfo) {
			super.change(DAY_INFO,super.getDayInfo(),dayInfo);
			super.setDayInfo(dayInfo);
			return this;
		}
		
		/**
		 * 设置 记录时间
		 * @param rcdTime 记录时间
		 * @return 当前对象
		*/
		public AttendanceData setRcdTime(Date rcdTime) {
			super.change(RCD_TIME,super.getRcdTime(),rcdTime);
			super.setRcdTime(rcdTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AttendanceData setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AttendanceData setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AttendanceData setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AttendanceData setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AttendanceData setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AttendanceData setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AttendanceData setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AttendanceData setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AttendanceData setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 person
		 * @param person person
		 * @return 当前对象
		*/
		public AttendanceData setPerson(Person person) {
			super.change(PERSON,super.getPerson(),person);
			super.setPerson(person);
			return this;
		}
		
		/**
		 * 设置 attendanceTpl
		 * @param attendanceTpl attendanceTpl
		 * @return 当前对象
		*/
		public AttendanceData setAttendanceTpl(AttendanceTpl attendanceTpl) {
			super.change(ATTENDANCE_TPL,super.getAttendanceTpl(),attendanceTpl);
			super.setAttendanceTpl(attendanceTpl);
			return this;
		}
		
		/**
		 * 设置 personJobName
		 * @param personJobName personJobName
		 * @return 当前对象
		*/
		public AttendanceData setPersonJobName(String personJobName) {
			super.change(PERSON_JOB_NAME,super.getPersonJobName(),personJobName);
			super.setPersonJobName(personJobName);
			return this;
		}
		
		/**
		 * 设置 sJobNumber
		 * @param sJobNumber sJobNumber
		 * @return 当前对象
		*/
		public AttendanceData setSJobNumber(String sJobNumber) {
			super.change(S_JOB_NUMBER,super.getSJobNumber(),sJobNumber);
			super.setSJobNumber(sJobNumber);
			return this;
		}
		
		/**
		 * 设置 rq
		 * @param rq rq
		 * @return 当前对象
		*/
		public AttendanceData setRq(String rq) {
			super.change(RQ,super.getRq(),rq);
			super.setRq(rq);
			return this;
		}
		
		/**
		 * 设置 days
		 * @param days days
		 * @return 当前对象
		*/
		public AttendanceData setDays(String days) {
			super.change(DAYS,super.getDays(),days);
			super.setDays(days);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AttendanceDataVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AttendanceDataVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setQjNj(this.getQjNj());
			inst.setNotes(this.getNotes());
			inst.setJbGzr(this.getJbGzr());
			inst.setLeaveEarlyTime(this.getLeaveEarlyTime());
			inst.setAttendanceTplCode(this.getAttendanceTplCode());
			inst.setQjGsj(this.getQjGsj());
			inst.setQjHj(this.getQjHj());
			inst.setResult(this.getResult());
			inst.setOnWorkTime(this.getOnWorkTime());
			inst.setOffWorkTime(this.getOffWorkTime());
			inst.setQjCj(this.getQjCj());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setIsWorkDay(this.getIsWorkDay());
			inst.setJbXxr(this.getJbXxr());
			inst.setJbJjr(this.getJbJjr());
			inst.setId(this.getId());
			inst.setOnWorkTime2(this.getOnWorkTime2());
			inst.setRcdTime(this.getRcdTime());
			inst.setCc(this.getCc());
			inst.setLossLate(this.getLossLate());
			inst.setRelId(this.getRelId());
			inst.setNeedDay(this.getNeedDay());
			inst.setQjSj(this.getQjSj());
			inst.setQjTxj(this.getQjTxj());
			inst.setLossEarly(this.getLossEarly());
			inst.setBatchCode(this.getBatchCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setDayInfo(this.getDayInfo());
			inst.setNormalDay(this.getNormalDay());
			inst.setLeaveEarly(this.getLeaveEarly());
			inst.setAttendanceDateStr(this.getAttendanceDateStr());
			inst.setVersion(this.getVersion());
			inst.setLossProcess(this.getLossProcess());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setQjBj(this.getQjBj());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setLeaveLateTime(this.getLeaveLateTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setPersonId(this.getPersonId());
			inst.setLeaveLate(this.getLeaveLate());
			inst.setQjPlj(this.getQjPlj());
			inst.setAttendanceDate(this.getAttendanceDate());
			inst.setOffWorkTime2(this.getOffWorkTime2());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setPerson(this.getPerson());
				inst.setAttendanceTpl(this.getAttendanceTpl());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setDays(this.getDays());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setSJobNumber(this.getSJobNumber());
				inst.setSearchValue(this.getSearchValue());
				inst.setPersonJobName(this.getPersonJobName());
				inst.setRq(this.getRq());
			}
			inst.clearModifies();
			return inst;
		}

	}
}