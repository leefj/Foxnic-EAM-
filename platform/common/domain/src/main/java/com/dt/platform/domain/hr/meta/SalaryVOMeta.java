package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.SalaryVO;
import java.util.List;
import com.dt.platform.domain.hr.Salary;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.hr.Person;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-05 10:21:24
 * @sign E138E7272BF556128C11A273377D877E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SalaryVOMeta extends SalaryMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final String PERSON_ID="personId";
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.String> PERSON_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,PERSON_ID, java.lang.String.class, "人员", "人员", java.lang.String.class, null);
	
	/**
	 * 基本工资 , 类型: java.math.BigDecimal
	*/
	public static final String BASE_SALARY="baseSalary";
	
	/**
	 * 基本工资 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> BASE_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,BASE_SALARY, java.math.BigDecimal.class, "基本工资", "基本工资", java.math.BigDecimal.class, null);
	
	/**
	 * 岗位工资 , 类型: java.math.BigDecimal
	*/
	public static final String POST_SALARY="postSalary";
	
	/**
	 * 岗位工资 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> POST_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,POST_SALARY, java.math.BigDecimal.class, "岗位工资", "岗位工资", java.math.BigDecimal.class, null);
	
	/**
	 * 工龄工资 , 类型: java.math.BigDecimal
	*/
	public static final String WORKING_YEARS_SALARY="workingYearsSalary";
	
	/**
	 * 工龄工资 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WORKING_YEARS_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WORKING_YEARS_SALARY, java.math.BigDecimal.class, "工龄工资", "工龄工资", java.math.BigDecimal.class, null);
	
	/**
	 * 固定补贴 , 类型: java.math.BigDecimal
	*/
	public static final String FIXED_SALARY="fixedSalary";
	
	/**
	 * 固定补贴 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> FIXED_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,FIXED_SALARY, java.math.BigDecimal.class, "固定补贴", "固定补贴", java.math.BigDecimal.class, null);
	
	/**
	 * 绩效补贴 , 类型: java.math.BigDecimal
	*/
	public static final String ACHIEVEMENT_SALARY="achievementSalary";
	
	/**
	 * 绩效补贴 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> ACHIEVEMENT_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,ACHIEVEMENT_SALARY, java.math.BigDecimal.class, "绩效补贴", "绩效补贴", java.math.BigDecimal.class, null);
	
	/**
	 * 加班补贴 , 类型: java.math.BigDecimal
	*/
	public static final String OVERTIME_SALARY="overtimeSalary";
	
	/**
	 * 加班补贴 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> OVERTIME_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,OVERTIME_SALARY, java.math.BigDecimal.class, "加班补贴", "加班补贴", java.math.BigDecimal.class, null);
	
	/**
	 * 其他补贴 , 类型: java.math.BigDecimal
	*/
	public static final String OTHER_SALARY="otherSalary";
	
	/**
	 * 其他补贴 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> OTHER_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,OTHER_SALARY, java.math.BigDecimal.class, "其他补贴", "其他补贴", java.math.BigDecimal.class, null);
	
	/**
	 * 通讯补贴 , 类型: java.math.BigDecimal
	*/
	public static final String COMMUNICATION_SALARY="communicationSalary";
	
	/**
	 * 通讯补贴 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> COMMUNICATION_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,COMMUNICATION_SALARY, java.math.BigDecimal.class, "通讯补贴", "通讯补贴", java.math.BigDecimal.class, null);
	
	/**
	 * 交通补贴 , 类型: java.math.BigDecimal
	*/
	public static final String TRAFFIC_SALARY="trafficSalary";
	
	/**
	 * 交通补贴 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> TRAFFIC_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,TRAFFIC_SALARY, java.math.BigDecimal.class, "交通补贴", "交通补贴", java.math.BigDecimal.class, null);
	
	/**
	 * 住房补贴 , 类型: java.math.BigDecimal
	*/
	public static final String HOUSING_SALARY="housingSalary";
	
	/**
	 * 住房补贴 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> HOUSING_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,HOUSING_SALARY, java.math.BigDecimal.class, "住房补贴", "住房补贴", java.math.BigDecimal.class, null);
	
	/**
	 * 提成工资 , 类型: java.math.BigDecimal
	*/
	public static final String COMMISSION_SALARY="commissionSalary";
	
	/**
	 * 提成工资 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> COMMISSION_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,COMMISSION_SALARY, java.math.BigDecimal.class, "提成工资", "提成工资", java.math.BigDecimal.class, null);
	
	/**
	 * 高温补贴 , 类型: java.math.BigDecimal
	*/
	public static final String HIGH_TEMPERATURE_SALARY="highTemperatureSalary";
	
	/**
	 * 高温补贴 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> HIGH_TEMPERATURE_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,HIGH_TEMPERATURE_SALARY, java.math.BigDecimal.class, "高温补贴", "高温补贴", java.math.BigDecimal.class, null);
	
	/**
	 * 住房公积金基数 , 类型: java.math.BigDecimal
	*/
	public static final String WELFARE_ZFGJJ_BASE="welfareZfgjjBase";
	
	/**
	 * 住房公积金基数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WELFARE_ZFGJJ_BASE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WELFARE_ZFGJJ_BASE, java.math.BigDecimal.class, "住房公积金基数", "住房公积金基数", java.math.BigDecimal.class, null);
	
	/**
	 * 住房公积金个人 , 类型: java.math.BigDecimal
	*/
	public static final String WELFARE_ZFGJJ_PERSON="welfareZfgjjPerson";
	
	/**
	 * 住房公积金个人 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WELFARE_ZFGJJ_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WELFARE_ZFGJJ_PERSON, java.math.BigDecimal.class, "住房公积金个人", "住房公积金个人", java.math.BigDecimal.class, null);
	
	/**
	 * 住房公积金公司 , 类型: java.math.BigDecimal
	*/
	public static final String WELFARE_ZFGJJ_COMPANY="welfareZfgjjCompany";
	
	/**
	 * 住房公积金公司 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WELFARE_ZFGJJ_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WELFARE_ZFGJJ_COMPANY, java.math.BigDecimal.class, "住房公积金公司", "住房公积金公司", java.math.BigDecimal.class, null);
	
	/**
	 * 养老保险基数 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_YLBX_BASE="welfaerYlbxBase";
	
	/**
	 * 养老保险基数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WELFAER_YLBX_BASE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WELFAER_YLBX_BASE, java.math.BigDecimal.class, "养老保险基数", "养老保险基数", java.math.BigDecimal.class, null);
	
	/**
	 * 养老保险个人 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_YLBX_PERSON="welfaerYlbxPerson";
	
	/**
	 * 养老保险个人 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WELFAER_YLBX_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WELFAER_YLBX_PERSON, java.math.BigDecimal.class, "养老保险个人", "养老保险个人", java.math.BigDecimal.class, null);
	
	/**
	 * 养老保险公司 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_YLBX_COMPANY="welfaerYlbxCompany";
	
	/**
	 * 养老保险公司 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WELFAER_YLBX_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WELFAER_YLBX_COMPANY, java.math.BigDecimal.class, "养老保险公司", "养老保险公司", java.math.BigDecimal.class, null);
	
	/**
	 * 工伤保险基数 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_GSBX_BASE="welfaerGsbxBase";
	
	/**
	 * 工伤保险基数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WELFAER_GSBX_BASE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WELFAER_GSBX_BASE, java.math.BigDecimal.class, "工伤保险基数", "工伤保险基数", java.math.BigDecimal.class, null);
	
	/**
	 * 工伤保险个人 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_GSBX_PERSON="welfaerGsbxPerson";
	
	/**
	 * 工伤保险个人 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WELFAER_GSBX_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WELFAER_GSBX_PERSON, java.math.BigDecimal.class, "工伤保险个人", "工伤保险个人", java.math.BigDecimal.class, null);
	
	/**
	 * 工伤保险公司 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_GSBX_COMPANY="welfaerGsbxCompany";
	
	/**
	 * 工伤保险公司 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WELFAER_GSBX_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WELFAER_GSBX_COMPANY, java.math.BigDecimal.class, "工伤保险公司", "工伤保险公司", java.math.BigDecimal.class, null);
	
	/**
	 * 医疗保险基数 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_YRBX_BASE="welfaerYrbxBase";
	
	/**
	 * 医疗保险基数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WELFAER_YRBX_BASE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WELFAER_YRBX_BASE, java.math.BigDecimal.class, "医疗保险基数", "医疗保险基数", java.math.BigDecimal.class, null);
	
	/**
	 * 医疗保险个人 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_YRBX_PERSON="welfaerYrbxPerson";
	
	/**
	 * 医疗保险个人 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WELFAER_YRBX_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WELFAER_YRBX_PERSON, java.math.BigDecimal.class, "医疗保险个人", "医疗保险个人", java.math.BigDecimal.class, null);
	
	/**
	 * 医疗保险公司 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_YRBX_COMPANY="welfaerYrbxCompany";
	
	/**
	 * 医疗保险公司 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WELFAER_YRBX_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WELFAER_YRBX_COMPANY, java.math.BigDecimal.class, "医疗保险公司", "医疗保险公司", java.math.BigDecimal.class, null);
	
	/**
	 * 生育保险基数 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_SYBX_BASE="welfaerSybxBase";
	
	/**
	 * 生育保险基数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WELFAER_SYBX_BASE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WELFAER_SYBX_BASE, java.math.BigDecimal.class, "生育保险基数", "生育保险基数", java.math.BigDecimal.class, null);
	
	/**
	 * 生育保险个人 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_SYBX_PERSON="welfaerSybxPerson";
	
	/**
	 * 生育保险个人 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WELFAER_SYBX_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WELFAER_SYBX_PERSON, java.math.BigDecimal.class, "生育保险个人", "生育保险个人", java.math.BigDecimal.class, null);
	
	/**
	 * 生育保险公司 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_SYBX_COMPANY="welfaerSybxCompany";
	
	/**
	 * 生育保险公司 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WELFAER_SYBX_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WELFAER_SYBX_COMPANY, java.math.BigDecimal.class, "生育保险公司", "生育保险公司", java.math.BigDecimal.class, null);
	
	/**
	 * 失业保险基数 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_SYEBX_BASE="welfaerSyebxBase";
	
	/**
	 * 失业保险基数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WELFAER_SYEBX_BASE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WELFAER_SYEBX_BASE, java.math.BigDecimal.class, "失业保险基数", "失业保险基数", java.math.BigDecimal.class, null);
	
	/**
	 * 失业保险个人 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_SYEBX_PERSON="welfaerSyebxPerson";
	
	/**
	 * 失业保险个人 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WELFAER_SYEBX_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WELFAER_SYEBX_PERSON, java.math.BigDecimal.class, "失业保险个人", "失业保险个人", java.math.BigDecimal.class, null);
	
	/**
	 * 失业保险公司 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_SYEBX_COMPANY="welfaerSyebxCompany";
	
	/**
	 * 失业保险公司 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> WELFAER_SYEBX_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,WELFAER_SYEBX_COMPANY, java.math.BigDecimal.class, "失业保险公司", "失业保险公司", java.math.BigDecimal.class, null);
	
	/**
	 * 个税抵扣 , 类型: java.math.BigDecimal
	*/
	public static final String DEDUCT_PERSONAL_TAX_RED="deductPersonalTaxRed";
	
	/**
	 * 个税抵扣 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> DEDUCT_PERSONAL_TAX_RED_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,DEDUCT_PERSONAL_TAX_RED, java.math.BigDecimal.class, "个税抵扣", "个税抵扣", java.math.BigDecimal.class, null);
	
	/**
	 * 扣除考勤 , 类型: java.math.BigDecimal
	*/
	public static final String DEDUCT_KQ="deductKq";
	
	/**
	 * 扣除考勤 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> DEDUCT_KQ_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,DEDUCT_KQ, java.math.BigDecimal.class, "扣除考勤", "扣除考勤", java.math.BigDecimal.class, null);
	
	/**
	 * 扣除工会 , 类型: java.math.BigDecimal
	*/
	public static final String DEDUCT_GH="deductGh";
	
	/**
	 * 扣除工会 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> DEDUCT_GH_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,DEDUCT_GH, java.math.BigDecimal.class, "扣除工会", "扣除工会", java.math.BigDecimal.class, null);
	
	/**
	 * 扣除其他 , 类型: java.math.BigDecimal
	*/
	public static final String DUDUCT_OTHER="duductOther";
	
	/**
	 * 扣除其他 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> DUDUCT_OTHER_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,DUDUCT_OTHER, java.math.BigDecimal.class, "扣除其他", "扣除其他", java.math.BigDecimal.class, null);
	
	/**
	 * 子女教育 , 类型: java.math.BigDecimal
	*/
	public static final String PERSONAL_TAX_ZNJY="personalTaxZnjy";
	
	/**
	 * 子女教育 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> PERSONAL_TAX_ZNJY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,PERSONAL_TAX_ZNJY, java.math.BigDecimal.class, "子女教育", "子女教育", java.math.BigDecimal.class, null);
	
	/**
	 * 继续教育 , 类型: java.math.BigDecimal
	*/
	public static final String PERSONAL_TAX_JXJY="personalTaxJxjy";
	
	/**
	 * 继续教育 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> PERSONAL_TAX_JXJY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,PERSONAL_TAX_JXJY, java.math.BigDecimal.class, "继续教育", "继续教育", java.math.BigDecimal.class, null);
	
	/**
	 * 大病医疗 , 类型: java.math.BigDecimal
	*/
	public static final String PERSONAL_TAX_DBYL="personalTaxDbyl";
	
	/**
	 * 大病医疗 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> PERSONAL_TAX_DBYL_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,PERSONAL_TAX_DBYL, java.math.BigDecimal.class, "大病医疗", "大病医疗", java.math.BigDecimal.class, null);
	
	/**
	 * 住房贷款 , 类型: java.math.BigDecimal
	*/
	public static final String PERSONAL_TAX_ZFDK="personalTaxZfdk";
	
	/**
	 * 住房贷款 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> PERSONAL_TAX_ZFDK_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,PERSONAL_TAX_ZFDK, java.math.BigDecimal.class, "住房贷款", "住房贷款", java.math.BigDecimal.class, null);
	
	/**
	 * 住房租金 , 类型: java.math.BigDecimal
	*/
	public static final String PERSONAL_TAX_ZFZJ="personalTaxZfzj";
	
	/**
	 * 住房租金 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> PERSONAL_TAX_ZFZJ_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,PERSONAL_TAX_ZFZJ, java.math.BigDecimal.class, "住房租金", "住房租金", java.math.BigDecimal.class, null);
	
	/**
	 * 赡养老人 , 类型: java.math.BigDecimal
	*/
	public static final String PERSONAL_TAX_SYLR="personalTaxSylr";
	
	/**
	 * 赡养老人 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> PERSONAL_TAX_SYLR_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,PERSONAL_TAX_SYLR, java.math.BigDecimal.class, "赡养老人", "赡养老人", java.math.BigDecimal.class, null);
	
	/**
	 * 幼儿照护 , 类型: java.math.BigDecimal
	*/
	public static final String PERSONAL_TAX_ERZH="personalTaxErzh";
	
	/**
	 * 幼儿照护 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.math.BigDecimal> PERSONAL_TAX_ERZH_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,PERSONAL_TAX_ERZH, java.math.BigDecimal.class, "幼儿照护", "幼儿照护", java.math.BigDecimal.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * person , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final String PERSON="person";
	
	/**
	 * person , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryVO,com.dt.platform.domain.hr.Person> PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryVO.class ,PERSON, com.dt.platform.domain.hr.Person.class, "person", "person", com.dt.platform.domain.hr.Person.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , PERSON_ID , BASE_SALARY , POST_SALARY , WORKING_YEARS_SALARY , FIXED_SALARY , ACHIEVEMENT_SALARY , OVERTIME_SALARY , OTHER_SALARY , COMMUNICATION_SALARY , TRAFFIC_SALARY , HOUSING_SALARY , COMMISSION_SALARY , HIGH_TEMPERATURE_SALARY , WELFARE_ZFGJJ_BASE , WELFARE_ZFGJJ_PERSON , WELFARE_ZFGJJ_COMPANY , WELFAER_YLBX_BASE , WELFAER_YLBX_PERSON , WELFAER_YLBX_COMPANY , WELFAER_GSBX_BASE , WELFAER_GSBX_PERSON , WELFAER_GSBX_COMPANY , WELFAER_YRBX_BASE , WELFAER_YRBX_PERSON , WELFAER_YRBX_COMPANY , WELFAER_SYBX_BASE , WELFAER_SYBX_PERSON , WELFAER_SYBX_COMPANY , WELFAER_SYEBX_BASE , WELFAER_SYEBX_PERSON , WELFAER_SYEBX_COMPANY , DEDUCT_PERSONAL_TAX_RED , DEDUCT_KQ , DEDUCT_GH , DUDUCT_OTHER , PERSONAL_TAX_ZNJY , PERSONAL_TAX_JXJY , PERSONAL_TAX_DBYL , PERSONAL_TAX_ZFDK , PERSONAL_TAX_ZFZJ , PERSONAL_TAX_SYLR , PERSONAL_TAX_ERZH , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PERSON };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.SalaryVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public SalaryVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public SalaryVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public SalaryVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public SalaryVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public SalaryVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public SalaryVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public SalaryVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public SalaryVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public SalaryVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public SalaryVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public SalaryVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public SalaryVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Salary setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 人员
		 * @param personId 人员
		 * @return 当前对象
		*/
		public Salary setPersonId(String personId) {
			super.change(PERSON_ID,super.getPersonId(),personId);
			super.setPersonId(personId);
			return this;
		}
		
		/**
		 * 设置 基本工资
		 * @param baseSalary 基本工资
		 * @return 当前对象
		*/
		public Salary setBaseSalary(BigDecimal baseSalary) {
			super.change(BASE_SALARY,super.getBaseSalary(),baseSalary);
			super.setBaseSalary(baseSalary);
			return this;
		}
		
		/**
		 * 设置 岗位工资
		 * @param postSalary 岗位工资
		 * @return 当前对象
		*/
		public Salary setPostSalary(BigDecimal postSalary) {
			super.change(POST_SALARY,super.getPostSalary(),postSalary);
			super.setPostSalary(postSalary);
			return this;
		}
		
		/**
		 * 设置 工龄工资
		 * @param workingYearsSalary 工龄工资
		 * @return 当前对象
		*/
		public Salary setWorkingYearsSalary(BigDecimal workingYearsSalary) {
			super.change(WORKING_YEARS_SALARY,super.getWorkingYearsSalary(),workingYearsSalary);
			super.setWorkingYearsSalary(workingYearsSalary);
			return this;
		}
		
		/**
		 * 设置 固定补贴
		 * @param fixedSalary 固定补贴
		 * @return 当前对象
		*/
		public Salary setFixedSalary(BigDecimal fixedSalary) {
			super.change(FIXED_SALARY,super.getFixedSalary(),fixedSalary);
			super.setFixedSalary(fixedSalary);
			return this;
		}
		
		/**
		 * 设置 绩效补贴
		 * @param achievementSalary 绩效补贴
		 * @return 当前对象
		*/
		public Salary setAchievementSalary(BigDecimal achievementSalary) {
			super.change(ACHIEVEMENT_SALARY,super.getAchievementSalary(),achievementSalary);
			super.setAchievementSalary(achievementSalary);
			return this;
		}
		
		/**
		 * 设置 加班补贴
		 * @param overtimeSalary 加班补贴
		 * @return 当前对象
		*/
		public Salary setOvertimeSalary(BigDecimal overtimeSalary) {
			super.change(OVERTIME_SALARY,super.getOvertimeSalary(),overtimeSalary);
			super.setOvertimeSalary(overtimeSalary);
			return this;
		}
		
		/**
		 * 设置 其他补贴
		 * @param otherSalary 其他补贴
		 * @return 当前对象
		*/
		public Salary setOtherSalary(BigDecimal otherSalary) {
			super.change(OTHER_SALARY,super.getOtherSalary(),otherSalary);
			super.setOtherSalary(otherSalary);
			return this;
		}
		
		/**
		 * 设置 通讯补贴
		 * @param communicationSalary 通讯补贴
		 * @return 当前对象
		*/
		public Salary setCommunicationSalary(BigDecimal communicationSalary) {
			super.change(COMMUNICATION_SALARY,super.getCommunicationSalary(),communicationSalary);
			super.setCommunicationSalary(communicationSalary);
			return this;
		}
		
		/**
		 * 设置 交通补贴
		 * @param trafficSalary 交通补贴
		 * @return 当前对象
		*/
		public Salary setTrafficSalary(BigDecimal trafficSalary) {
			super.change(TRAFFIC_SALARY,super.getTrafficSalary(),trafficSalary);
			super.setTrafficSalary(trafficSalary);
			return this;
		}
		
		/**
		 * 设置 住房补贴
		 * @param housingSalary 住房补贴
		 * @return 当前对象
		*/
		public Salary setHousingSalary(BigDecimal housingSalary) {
			super.change(HOUSING_SALARY,super.getHousingSalary(),housingSalary);
			super.setHousingSalary(housingSalary);
			return this;
		}
		
		/**
		 * 设置 提成工资
		 * @param commissionSalary 提成工资
		 * @return 当前对象
		*/
		public Salary setCommissionSalary(BigDecimal commissionSalary) {
			super.change(COMMISSION_SALARY,super.getCommissionSalary(),commissionSalary);
			super.setCommissionSalary(commissionSalary);
			return this;
		}
		
		/**
		 * 设置 高温补贴
		 * @param highTemperatureSalary 高温补贴
		 * @return 当前对象
		*/
		public Salary setHighTemperatureSalary(BigDecimal highTemperatureSalary) {
			super.change(HIGH_TEMPERATURE_SALARY,super.getHighTemperatureSalary(),highTemperatureSalary);
			super.setHighTemperatureSalary(highTemperatureSalary);
			return this;
		}
		
		/**
		 * 设置 住房公积金基数
		 * @param welfareZfgjjBase 住房公积金基数
		 * @return 当前对象
		*/
		public Salary setWelfareZfgjjBase(BigDecimal welfareZfgjjBase) {
			super.change(WELFARE_ZFGJJ_BASE,super.getWelfareZfgjjBase(),welfareZfgjjBase);
			super.setWelfareZfgjjBase(welfareZfgjjBase);
			return this;
		}
		
		/**
		 * 设置 住房公积金个人
		 * @param welfareZfgjjPerson 住房公积金个人
		 * @return 当前对象
		*/
		public Salary setWelfareZfgjjPerson(BigDecimal welfareZfgjjPerson) {
			super.change(WELFARE_ZFGJJ_PERSON,super.getWelfareZfgjjPerson(),welfareZfgjjPerson);
			super.setWelfareZfgjjPerson(welfareZfgjjPerson);
			return this;
		}
		
		/**
		 * 设置 住房公积金公司
		 * @param welfareZfgjjCompany 住房公积金公司
		 * @return 当前对象
		*/
		public Salary setWelfareZfgjjCompany(BigDecimal welfareZfgjjCompany) {
			super.change(WELFARE_ZFGJJ_COMPANY,super.getWelfareZfgjjCompany(),welfareZfgjjCompany);
			super.setWelfareZfgjjCompany(welfareZfgjjCompany);
			return this;
		}
		
		/**
		 * 设置 养老保险基数
		 * @param welfaerYlbxBase 养老保险基数
		 * @return 当前对象
		*/
		public Salary setWelfaerYlbxBase(BigDecimal welfaerYlbxBase) {
			super.change(WELFAER_YLBX_BASE,super.getWelfaerYlbxBase(),welfaerYlbxBase);
			super.setWelfaerYlbxBase(welfaerYlbxBase);
			return this;
		}
		
		/**
		 * 设置 养老保险个人
		 * @param welfaerYlbxPerson 养老保险个人
		 * @return 当前对象
		*/
		public Salary setWelfaerYlbxPerson(BigDecimal welfaerYlbxPerson) {
			super.change(WELFAER_YLBX_PERSON,super.getWelfaerYlbxPerson(),welfaerYlbxPerson);
			super.setWelfaerYlbxPerson(welfaerYlbxPerson);
			return this;
		}
		
		/**
		 * 设置 养老保险公司
		 * @param welfaerYlbxCompany 养老保险公司
		 * @return 当前对象
		*/
		public Salary setWelfaerYlbxCompany(BigDecimal welfaerYlbxCompany) {
			super.change(WELFAER_YLBX_COMPANY,super.getWelfaerYlbxCompany(),welfaerYlbxCompany);
			super.setWelfaerYlbxCompany(welfaerYlbxCompany);
			return this;
		}
		
		/**
		 * 设置 工伤保险基数
		 * @param welfaerGsbxBase 工伤保险基数
		 * @return 当前对象
		*/
		public Salary setWelfaerGsbxBase(BigDecimal welfaerGsbxBase) {
			super.change(WELFAER_GSBX_BASE,super.getWelfaerGsbxBase(),welfaerGsbxBase);
			super.setWelfaerGsbxBase(welfaerGsbxBase);
			return this;
		}
		
		/**
		 * 设置 工伤保险个人
		 * @param welfaerGsbxPerson 工伤保险个人
		 * @return 当前对象
		*/
		public Salary setWelfaerGsbxPerson(BigDecimal welfaerGsbxPerson) {
			super.change(WELFAER_GSBX_PERSON,super.getWelfaerGsbxPerson(),welfaerGsbxPerson);
			super.setWelfaerGsbxPerson(welfaerGsbxPerson);
			return this;
		}
		
		/**
		 * 设置 工伤保险公司
		 * @param welfaerGsbxCompany 工伤保险公司
		 * @return 当前对象
		*/
		public Salary setWelfaerGsbxCompany(BigDecimal welfaerGsbxCompany) {
			super.change(WELFAER_GSBX_COMPANY,super.getWelfaerGsbxCompany(),welfaerGsbxCompany);
			super.setWelfaerGsbxCompany(welfaerGsbxCompany);
			return this;
		}
		
		/**
		 * 设置 医疗保险基数
		 * @param welfaerYrbxBase 医疗保险基数
		 * @return 当前对象
		*/
		public Salary setWelfaerYrbxBase(BigDecimal welfaerYrbxBase) {
			super.change(WELFAER_YRBX_BASE,super.getWelfaerYrbxBase(),welfaerYrbxBase);
			super.setWelfaerYrbxBase(welfaerYrbxBase);
			return this;
		}
		
		/**
		 * 设置 医疗保险个人
		 * @param welfaerYrbxPerson 医疗保险个人
		 * @return 当前对象
		*/
		public Salary setWelfaerYrbxPerson(BigDecimal welfaerYrbxPerson) {
			super.change(WELFAER_YRBX_PERSON,super.getWelfaerYrbxPerson(),welfaerYrbxPerson);
			super.setWelfaerYrbxPerson(welfaerYrbxPerson);
			return this;
		}
		
		/**
		 * 设置 医疗保险公司
		 * @param welfaerYrbxCompany 医疗保险公司
		 * @return 当前对象
		*/
		public Salary setWelfaerYrbxCompany(BigDecimal welfaerYrbxCompany) {
			super.change(WELFAER_YRBX_COMPANY,super.getWelfaerYrbxCompany(),welfaerYrbxCompany);
			super.setWelfaerYrbxCompany(welfaerYrbxCompany);
			return this;
		}
		
		/**
		 * 设置 生育保险基数
		 * @param welfaerSybxBase 生育保险基数
		 * @return 当前对象
		*/
		public Salary setWelfaerSybxBase(BigDecimal welfaerSybxBase) {
			super.change(WELFAER_SYBX_BASE,super.getWelfaerSybxBase(),welfaerSybxBase);
			super.setWelfaerSybxBase(welfaerSybxBase);
			return this;
		}
		
		/**
		 * 设置 生育保险个人
		 * @param welfaerSybxPerson 生育保险个人
		 * @return 当前对象
		*/
		public Salary setWelfaerSybxPerson(BigDecimal welfaerSybxPerson) {
			super.change(WELFAER_SYBX_PERSON,super.getWelfaerSybxPerson(),welfaerSybxPerson);
			super.setWelfaerSybxPerson(welfaerSybxPerson);
			return this;
		}
		
		/**
		 * 设置 生育保险公司
		 * @param welfaerSybxCompany 生育保险公司
		 * @return 当前对象
		*/
		public Salary setWelfaerSybxCompany(BigDecimal welfaerSybxCompany) {
			super.change(WELFAER_SYBX_COMPANY,super.getWelfaerSybxCompany(),welfaerSybxCompany);
			super.setWelfaerSybxCompany(welfaerSybxCompany);
			return this;
		}
		
		/**
		 * 设置 失业保险基数
		 * @param welfaerSyebxBase 失业保险基数
		 * @return 当前对象
		*/
		public Salary setWelfaerSyebxBase(BigDecimal welfaerSyebxBase) {
			super.change(WELFAER_SYEBX_BASE,super.getWelfaerSyebxBase(),welfaerSyebxBase);
			super.setWelfaerSyebxBase(welfaerSyebxBase);
			return this;
		}
		
		/**
		 * 设置 失业保险个人
		 * @param welfaerSyebxPerson 失业保险个人
		 * @return 当前对象
		*/
		public Salary setWelfaerSyebxPerson(BigDecimal welfaerSyebxPerson) {
			super.change(WELFAER_SYEBX_PERSON,super.getWelfaerSyebxPerson(),welfaerSyebxPerson);
			super.setWelfaerSyebxPerson(welfaerSyebxPerson);
			return this;
		}
		
		/**
		 * 设置 失业保险公司
		 * @param welfaerSyebxCompany 失业保险公司
		 * @return 当前对象
		*/
		public Salary setWelfaerSyebxCompany(BigDecimal welfaerSyebxCompany) {
			super.change(WELFAER_SYEBX_COMPANY,super.getWelfaerSyebxCompany(),welfaerSyebxCompany);
			super.setWelfaerSyebxCompany(welfaerSyebxCompany);
			return this;
		}
		
		/**
		 * 设置 个税抵扣
		 * @param deductPersonalTaxRed 个税抵扣
		 * @return 当前对象
		*/
		public Salary setDeductPersonalTaxRed(BigDecimal deductPersonalTaxRed) {
			super.change(DEDUCT_PERSONAL_TAX_RED,super.getDeductPersonalTaxRed(),deductPersonalTaxRed);
			super.setDeductPersonalTaxRed(deductPersonalTaxRed);
			return this;
		}
		
		/**
		 * 设置 扣除考勤
		 * @param deductKq 扣除考勤
		 * @return 当前对象
		*/
		public Salary setDeductKq(BigDecimal deductKq) {
			super.change(DEDUCT_KQ,super.getDeductKq(),deductKq);
			super.setDeductKq(deductKq);
			return this;
		}
		
		/**
		 * 设置 扣除工会
		 * @param deductGh 扣除工会
		 * @return 当前对象
		*/
		public Salary setDeductGh(BigDecimal deductGh) {
			super.change(DEDUCT_GH,super.getDeductGh(),deductGh);
			super.setDeductGh(deductGh);
			return this;
		}
		
		/**
		 * 设置 扣除其他
		 * @param duductOther 扣除其他
		 * @return 当前对象
		*/
		public Salary setDuductOther(BigDecimal duductOther) {
			super.change(DUDUCT_OTHER,super.getDuductOther(),duductOther);
			super.setDuductOther(duductOther);
			return this;
		}
		
		/**
		 * 设置 子女教育
		 * @param personalTaxZnjy 子女教育
		 * @return 当前对象
		*/
		public Salary setPersonalTaxZnjy(BigDecimal personalTaxZnjy) {
			super.change(PERSONAL_TAX_ZNJY,super.getPersonalTaxZnjy(),personalTaxZnjy);
			super.setPersonalTaxZnjy(personalTaxZnjy);
			return this;
		}
		
		/**
		 * 设置 继续教育
		 * @param personalTaxJxjy 继续教育
		 * @return 当前对象
		*/
		public Salary setPersonalTaxJxjy(BigDecimal personalTaxJxjy) {
			super.change(PERSONAL_TAX_JXJY,super.getPersonalTaxJxjy(),personalTaxJxjy);
			super.setPersonalTaxJxjy(personalTaxJxjy);
			return this;
		}
		
		/**
		 * 设置 大病医疗
		 * @param personalTaxDbyl 大病医疗
		 * @return 当前对象
		*/
		public Salary setPersonalTaxDbyl(BigDecimal personalTaxDbyl) {
			super.change(PERSONAL_TAX_DBYL,super.getPersonalTaxDbyl(),personalTaxDbyl);
			super.setPersonalTaxDbyl(personalTaxDbyl);
			return this;
		}
		
		/**
		 * 设置 住房贷款
		 * @param personalTaxZfdk 住房贷款
		 * @return 当前对象
		*/
		public Salary setPersonalTaxZfdk(BigDecimal personalTaxZfdk) {
			super.change(PERSONAL_TAX_ZFDK,super.getPersonalTaxZfdk(),personalTaxZfdk);
			super.setPersonalTaxZfdk(personalTaxZfdk);
			return this;
		}
		
		/**
		 * 设置 住房租金
		 * @param personalTaxZfzj 住房租金
		 * @return 当前对象
		*/
		public Salary setPersonalTaxZfzj(BigDecimal personalTaxZfzj) {
			super.change(PERSONAL_TAX_ZFZJ,super.getPersonalTaxZfzj(),personalTaxZfzj);
			super.setPersonalTaxZfzj(personalTaxZfzj);
			return this;
		}
		
		/**
		 * 设置 赡养老人
		 * @param personalTaxSylr 赡养老人
		 * @return 当前对象
		*/
		public Salary setPersonalTaxSylr(BigDecimal personalTaxSylr) {
			super.change(PERSONAL_TAX_SYLR,super.getPersonalTaxSylr(),personalTaxSylr);
			super.setPersonalTaxSylr(personalTaxSylr);
			return this;
		}
		
		/**
		 * 设置 幼儿照护
		 * @param personalTaxErzh 幼儿照护
		 * @return 当前对象
		*/
		public Salary setPersonalTaxErzh(BigDecimal personalTaxErzh) {
			super.change(PERSONAL_TAX_ERZH,super.getPersonalTaxErzh(),personalTaxErzh);
			super.setPersonalTaxErzh(personalTaxErzh);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Salary setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Salary setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Salary setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Salary setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Salary setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Salary setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Salary setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Salary setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Salary setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 person
		 * @param person person
		 * @return 当前对象
		*/
		public Salary setPerson(Person person) {
			super.change(PERSON,super.getPerson(),person);
			super.setPerson(person);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public SalaryVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public SalaryVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setHighTemperatureSalary(this.getHighTemperatureSalary());
			inst.setWelfareZfgjjBase(this.getWelfareZfgjjBase());
			inst.setDeductKq(this.getDeductKq());
			inst.setWelfareZfgjjPerson(this.getWelfareZfgjjPerson());
			inst.setDeductGh(this.getDeductGh());
			inst.setWelfaerYlbxCompany(this.getWelfaerYlbxCompany());
			inst.setPersonalTaxErzh(this.getPersonalTaxErzh());
			inst.setPersonalTaxJxjy(this.getPersonalTaxJxjy());
			inst.setCommunicationSalary(this.getCommunicationSalary());
			inst.setFixedSalary(this.getFixedSalary());
			inst.setId(this.getId());
			inst.setTrafficSalary(this.getTrafficSalary());
			inst.setWelfaerYrbxCompany(this.getWelfaerYrbxCompany());
			inst.setWelfaerSybxBase(this.getWelfaerSybxBase());
			inst.setWelfaerGsbxBase(this.getWelfaerGsbxBase());
			inst.setWelfaerSybxCompany(this.getWelfaerSybxCompany());
			inst.setWelfaerYrbxBase(this.getWelfaerYrbxBase());
			inst.setWelfaerSyebxBase(this.getWelfaerSyebxBase());
			inst.setVersion(this.getVersion());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setPersonId(this.getPersonId());
			inst.setOtherSalary(this.getOtherSalary());
			inst.setDeductPersonalTaxRed(this.getDeductPersonalTaxRed());
			inst.setCommissionSalary(this.getCommissionSalary());
			inst.setPersonalTaxZfdk(this.getPersonalTaxZfdk());
			inst.setWelfaerSyebxPerson(this.getWelfaerSyebxPerson());
			inst.setWelfaerSybxPerson(this.getWelfaerSybxPerson());
			inst.setWelfaerYlbxBase(this.getWelfaerYlbxBase());
			inst.setBaseSalary(this.getBaseSalary());
			inst.setPersonalTaxSylr(this.getPersonalTaxSylr());
			inst.setPersonalTaxZnjy(this.getPersonalTaxZnjy());
			inst.setWelfaerGsbxPerson(this.getWelfaerGsbxPerson());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setWelfaerYlbxPerson(this.getWelfaerYlbxPerson());
			inst.setWelfareZfgjjCompany(this.getWelfareZfgjjCompany());
			inst.setWelfaerGsbxCompany(this.getWelfaerGsbxCompany());
			inst.setWelfaerSyebxCompany(this.getWelfaerSyebxCompany());
			inst.setHousingSalary(this.getHousingSalary());
			inst.setWelfaerYrbxPerson(this.getWelfaerYrbxPerson());
			inst.setPersonalTaxZfzj(this.getPersonalTaxZfzj());
			inst.setWorkingYearsSalary(this.getWorkingYearsSalary());
			inst.setAchievementSalary(this.getAchievementSalary());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setDuductOther(this.getDuductOther());
			inst.setPersonalTaxDbyl(this.getPersonalTaxDbyl());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setTenantId(this.getTenantId());
			inst.setPostSalary(this.getPostSalary());
			inst.setOvertimeSalary(this.getOvertimeSalary());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setPerson(this.getPerson());
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