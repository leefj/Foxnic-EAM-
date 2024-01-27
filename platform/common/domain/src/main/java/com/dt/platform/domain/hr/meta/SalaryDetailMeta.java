package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.SalaryDetail;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.hr.SalaryTpl;
import com.dt.platform.domain.hr.SalaryAction;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.Salary;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-28 01:39:17
 * @sign 3F1647D88666EDFB2E2FED9F8D82210F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SalaryDetailMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final String USER_NAME="userName";
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.String> USER_NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,USER_NAME, java.lang.String.class, "姓名", "姓名", java.lang.String.class, null);
	
	/**
	 * 月份 , 类型: java.lang.String
	*/
	public static final String ACTION_MONTH="actionMonth";
	
	/**
	 * 月份 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.String> ACTION_MONTH_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,ACTION_MONTH, java.lang.String.class, "月份", "月份", java.lang.String.class, null);
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final String PERSON_ID="personId";
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.String> PERSON_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,PERSON_ID, java.lang.String.class, "人员", "人员", java.lang.String.class, null);
	
	/**
	 * 工号 , 类型: java.lang.String
	*/
	public static final String JOB_NUMBER="jobNumber";
	
	/**
	 * 工号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.String> JOB_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,JOB_NUMBER, java.lang.String.class, "工号", "工号", java.lang.String.class, null);
	
	/**
	 * 银行名称 , 类型: java.lang.String
	*/
	public static final String BANK="bank";
	
	/**
	 * 银行名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.String> BANK_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,BANK, java.lang.String.class, "银行名称", "银行名称", java.lang.String.class, null);
	
	/**
	 * 银行账户 , 类型: java.lang.String
	*/
	public static final String BANK_ACCOUNT="bankAccount";
	
	/**
	 * 银行账户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.String> BANK_ACCOUNT_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,BANK_ACCOUNT, java.lang.String.class, "银行账户", "银行账户", java.lang.String.class, null);
	
	/**
	 * 模版 , 类型: java.lang.String
	*/
	public static final String TPL_ID="tplId";
	
	/**
	 * 模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.String> TPL_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,TPL_ID, java.lang.String.class, "模版", "模版", java.lang.String.class, null);
	
	/**
	 * 动作 , 类型: java.lang.String
	*/
	public static final String ACTION_ID="actionId";
	
	/**
	 * 动作 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.String> ACTION_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,ACTION_ID, java.lang.String.class, "动作", "动作", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 工资 , 类型: java.math.BigDecimal
	*/
	public static final String TOTAL_AMOUNT="totalAmount";
	
	/**
	 * 工资 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> TOTAL_AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,TOTAL_AMOUNT, java.math.BigDecimal.class, "工资", "工资", java.math.BigDecimal.class, null);
	
	/**
	 * 应发金额 , 类型: java.math.BigDecimal
	*/
	public static final String PAY_AMOUNT="payAmount";
	
	/**
	 * 应发金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> PAY_AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,PAY_AMOUNT, java.math.BigDecimal.class, "应发金额", "应发金额", java.math.BigDecimal.class, null);
	
	/**
	 * 实发金额 , 员工 , 类型: java.math.BigDecimal
	*/
	public static final String ISSUED_AMOUNT="issuedAmount";
	
	/**
	 * 实发金额 , 员工 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> ISSUED_AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,ISSUED_AMOUNT, java.math.BigDecimal.class, "实发金额", "员工", java.math.BigDecimal.class, null);
	
	/**
	 * 基本工资 , 类型: java.math.BigDecimal
	*/
	public static final String BASE_SALARY="baseSalary";
	
	/**
	 * 基本工资 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> BASE_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,BASE_SALARY, java.math.BigDecimal.class, "基本工资", "基本工资", java.math.BigDecimal.class, null);
	
	/**
	 * 岗位工资 , 类型: java.math.BigDecimal
	*/
	public static final String POST_SALARY="postSalary";
	
	/**
	 * 岗位工资 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> POST_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,POST_SALARY, java.math.BigDecimal.class, "岗位工资", "岗位工资", java.math.BigDecimal.class, null);
	
	/**
	 * 工龄工资 , 类型: java.math.BigDecimal
	*/
	public static final String WORKING_YEARS_SALARY="workingYearsSalary";
	
	/**
	 * 工龄工资 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WORKING_YEARS_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WORKING_YEARS_SALARY, java.math.BigDecimal.class, "工龄工资", "工龄工资", java.math.BigDecimal.class, null);
	
	/**
	 * 固定补贴 , 类型: java.math.BigDecimal
	*/
	public static final String FIXED_SALARY="fixedSalary";
	
	/**
	 * 固定补贴 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> FIXED_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,FIXED_SALARY, java.math.BigDecimal.class, "固定补贴", "固定补贴", java.math.BigDecimal.class, null);
	
	/**
	 * 绩效补贴 , 类型: java.math.BigDecimal
	*/
	public static final String ACHIEVEMENT_SALARY="achievementSalary";
	
	/**
	 * 绩效补贴 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> ACHIEVEMENT_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,ACHIEVEMENT_SALARY, java.math.BigDecimal.class, "绩效补贴", "绩效补贴", java.math.BigDecimal.class, null);
	
	/**
	 * 加班补贴 , 类型: java.math.BigDecimal
	*/
	public static final String OVERTIME_SALARY="overtimeSalary";
	
	/**
	 * 加班补贴 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> OVERTIME_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,OVERTIME_SALARY, java.math.BigDecimal.class, "加班补贴", "加班补贴", java.math.BigDecimal.class, null);
	
	/**
	 * 通讯补贴 , 类型: java.math.BigDecimal
	*/
	public static final String COMMUNICATION_SALARY="communicationSalary";
	
	/**
	 * 通讯补贴 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> COMMUNICATION_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,COMMUNICATION_SALARY, java.math.BigDecimal.class, "通讯补贴", "通讯补贴", java.math.BigDecimal.class, null);
	
	/**
	 * 交通补贴 , 类型: java.math.BigDecimal
	*/
	public static final String TRAFFIC_SALARY="trafficSalary";
	
	/**
	 * 交通补贴 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> TRAFFIC_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,TRAFFIC_SALARY, java.math.BigDecimal.class, "交通补贴", "交通补贴", java.math.BigDecimal.class, null);
	
	/**
	 * 住房补贴 , 类型: java.math.BigDecimal
	*/
	public static final String HOUSING_SALARY="housingSalary";
	
	/**
	 * 住房补贴 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> HOUSING_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,HOUSING_SALARY, java.math.BigDecimal.class, "住房补贴", "住房补贴", java.math.BigDecimal.class, null);
	
	/**
	 * 高温补贴 , 类型: java.math.BigDecimal
	*/
	public static final String HIGH_TEMPERATURE_SALARY="highTemperatureSalary";
	
	/**
	 * 高温补贴 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> HIGH_TEMPERATURE_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,HIGH_TEMPERATURE_SALARY, java.math.BigDecimal.class, "高温补贴", "高温补贴", java.math.BigDecimal.class, null);
	
	/**
	 * 其他补贴 , 类型: java.math.BigDecimal
	*/
	public static final String OTHER_SALARY="otherSalary";
	
	/**
	 * 其他补贴 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> OTHER_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,OTHER_SALARY, java.math.BigDecimal.class, "其他补贴", "其他补贴", java.math.BigDecimal.class, null);
	
	/**
	 * 提成工资 , 类型: java.math.BigDecimal
	*/
	public static final String COMMISSION_SALARY="commissionSalary";
	
	/**
	 * 提成工资 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> COMMISSION_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,COMMISSION_SALARY, java.math.BigDecimal.class, "提成工资", "提成工资", java.math.BigDecimal.class, null);
	
	/**
	 * 处罚金额 , 类型: java.math.BigDecimal
	*/
	public static final String PUNISH_SALARY="punishSalary";
	
	/**
	 * 处罚金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> PUNISH_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,PUNISH_SALARY, java.math.BigDecimal.class, "处罚金额", "处罚金额", java.math.BigDecimal.class, null);
	
	/**
	 * 每日工资 , 类型: java.math.BigDecimal
	*/
	public static final String DAY_SALARY="daySalary";
	
	/**
	 * 每日工资 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> DAY_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,DAY_SALARY, java.math.BigDecimal.class, "每日工资", "每日工资", java.math.BigDecimal.class, null);
	
	/**
	 * 扣除考勤 , 类型: java.math.BigDecimal
	*/
	public static final String DEDUCT_KQ="deductKq";
	
	/**
	 * 扣除考勤 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> DEDUCT_KQ_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,DEDUCT_KQ, java.math.BigDecimal.class, "扣除考勤", "扣除考勤", java.math.BigDecimal.class, null);
	
	/**
	 * 扣除工会 , 类型: java.math.BigDecimal
	*/
	public static final String DEDUCT_GH="deductGh";
	
	/**
	 * 扣除工会 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> DEDUCT_GH_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,DEDUCT_GH, java.math.BigDecimal.class, "扣除工会", "扣除工会", java.math.BigDecimal.class, null);
	
	/**
	 * 扣除其他 , 类型: java.math.BigDecimal
	*/
	public static final String DEDUCT_OTHER="deductOther";
	
	/**
	 * 扣除其他 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> DEDUCT_OTHER_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,DEDUCT_OTHER, java.math.BigDecimal.class, "扣除其他", "扣除其他", java.math.BigDecimal.class, null);
	
	/**
	 * 个税抵扣 , 类型: java.math.BigDecimal
	*/
	public static final String DEDUCT_PERSONAL_TAX_RED="deductPersonalTaxRed";
	
	/**
	 * 个税抵扣 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> DEDUCT_PERSONAL_TAX_RED_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,DEDUCT_PERSONAL_TAX_RED, java.math.BigDecimal.class, "个税抵扣", "个税抵扣", java.math.BigDecimal.class, null);
	
	/**
	 * 个人所得税 , 类型: java.math.BigDecimal
	*/
	public static final String PT_GRSDS="ptGrsds";
	
	/**
	 * 个人所得税 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> PT_GRSDS_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,PT_GRSDS, java.math.BigDecimal.class, "个人所得税", "个人所得税", java.math.BigDecimal.class, null);
	
	/**
	 * 抵扣基数 , 类型: java.math.BigDecimal
	*/
	public static final String PT_DKJS="ptDkjs";
	
	/**
	 * 抵扣基数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> PT_DKJS_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,PT_DKJS, java.math.BigDecimal.class, "抵扣基数", "抵扣基数", java.math.BigDecimal.class, null);
	
	/**
	 * 加班时长 , 类型: java.math.BigDecimal
	*/
	public static final String WORK_OVERTIME_H_CNT="workOvertimeHCnt";
	
	/**
	 * 加班时长 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WORK_OVERTIME_H_CNT_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WORK_OVERTIME_H_CNT, java.math.BigDecimal.class, "加班时长", "加班时长", java.math.BigDecimal.class, null);
	
	/**
	 * 迟到次数 , 类型: java.math.BigDecimal
	*/
	public static final String LATE_CNT="lateCnt";
	
	/**
	 * 迟到次数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> LATE_CNT_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,LATE_CNT, java.math.BigDecimal.class, "迟到次数", "迟到次数", java.math.BigDecimal.class, null);
	
	/**
	 * 事假天数 , 类型: java.math.BigDecimal
	*/
	public static final String PERSONAL_LEAVE_CNT="personalLeaveCnt";
	
	/**
	 * 事假天数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> PERSONAL_LEAVE_CNT_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,PERSONAL_LEAVE_CNT, java.math.BigDecimal.class, "事假天数", "事假天数", java.math.BigDecimal.class, null);
	
	/**
	 * 工作天数 , 类型: java.math.BigDecimal
	*/
	public static final String WORK_DAY_CNT="workDayCnt";
	
	/**
	 * 工作天数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WORK_DAY_CNT_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WORK_DAY_CNT, java.math.BigDecimal.class, "工作天数", "工作天数", java.math.BigDecimal.class, null);
	
	/**
	 * 税率 , 类型: java.math.BigDecimal
	*/
	public static final String PT_SL_PCT="ptSlPct";
	
	/**
	 * 税率 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> PT_SL_PCT_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,PT_SL_PCT, java.math.BigDecimal.class, "税率", "税率", java.math.BigDecimal.class, null);
	
	/**
	 * 住房公积金基数 , 类型: java.math.BigDecimal
	*/
	public static final String WELFARE_ZFGJJ_BASE="welfareZfgjjBase";
	
	/**
	 * 住房公积金基数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFARE_ZFGJJ_BASE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFARE_ZFGJJ_BASE, java.math.BigDecimal.class, "住房公积金基数", "住房公积金基数", java.math.BigDecimal.class, null);
	
	/**
	 * 住房公积金个人 , 类型: java.math.BigDecimal
	*/
	public static final String WELFARE_ZFGJJ_PERSON="welfareZfgjjPerson";
	
	/**
	 * 住房公积金个人 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFARE_ZFGJJ_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFARE_ZFGJJ_PERSON, java.math.BigDecimal.class, "住房公积金个人", "住房公积金个人", java.math.BigDecimal.class, null);
	
	/**
	 * 住房公积金公司 , 类型: java.math.BigDecimal
	*/
	public static final String WELFARE_ZFGJJ_COMPANY="welfareZfgjjCompany";
	
	/**
	 * 住房公积金公司 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFARE_ZFGJJ_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFARE_ZFGJJ_COMPANY, java.math.BigDecimal.class, "住房公积金公司", "住房公积金公司", java.math.BigDecimal.class, null);
	
	/**
	 * 住房缴费 , 类型: java.math.BigDecimal
	*/
	public static final String WELFARE_ZFGJJ_VALUE="welfareZfgjjValue";
	
	/**
	 * 住房缴费 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFARE_ZFGJJ_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFARE_ZFGJJ_VALUE, java.math.BigDecimal.class, "住房缴费", "住房缴费", java.math.BigDecimal.class, null);
	
	/**
	 * 养老保险基数 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_YLBX_BASE="welfaerYlbxBase";
	
	/**
	 * 养老保险基数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_YLBX_BASE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_YLBX_BASE, java.math.BigDecimal.class, "养老保险基数", "养老保险基数", java.math.BigDecimal.class, null);
	
	/**
	 * 养老保险个人 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_YLBX_PERSON="welfaerYlbxPerson";
	
	/**
	 * 养老保险个人 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_YLBX_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_YLBX_PERSON, java.math.BigDecimal.class, "养老保险个人", "养老保险个人", java.math.BigDecimal.class, null);
	
	/**
	 * 养老保险公司 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_YLBX_COMPANY="welfaerYlbxCompany";
	
	/**
	 * 养老保险公司 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_YLBX_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_YLBX_COMPANY, java.math.BigDecimal.class, "养老保险公司", "养老保险公司", java.math.BigDecimal.class, null);
	
	/**
	 * 养老缴费 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_YLBX_VALUE="welfaerYlbxValue";
	
	/**
	 * 养老缴费 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_YLBX_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_YLBX_VALUE, java.math.BigDecimal.class, "养老缴费", "养老缴费", java.math.BigDecimal.class, null);
	
	/**
	 * 工伤保险基数 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_GSBX_BASE="welfaerGsbxBase";
	
	/**
	 * 工伤保险基数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_GSBX_BASE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_GSBX_BASE, java.math.BigDecimal.class, "工伤保险基数", "工伤保险基数", java.math.BigDecimal.class, null);
	
	/**
	 * 工伤保险个人 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_GSBX_PERSON="welfaerGsbxPerson";
	
	/**
	 * 工伤保险个人 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_GSBX_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_GSBX_PERSON, java.math.BigDecimal.class, "工伤保险个人", "工伤保险个人", java.math.BigDecimal.class, null);
	
	/**
	 * 工伤保险公司 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_GSBX_COMPANY="welfaerGsbxCompany";
	
	/**
	 * 工伤保险公司 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_GSBX_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_GSBX_COMPANY, java.math.BigDecimal.class, "工伤保险公司", "工伤保险公司", java.math.BigDecimal.class, null);
	
	/**
	 * 工伤缴费 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_GSBX_VALUE="welfaerGsbxValue";
	
	/**
	 * 工伤缴费 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_GSBX_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_GSBX_VALUE, java.math.BigDecimal.class, "工伤缴费", "工伤缴费", java.math.BigDecimal.class, null);
	
	/**
	 * 医疗保险基数 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_YRBX_BASE="welfaerYrbxBase";
	
	/**
	 * 医疗保险基数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_YRBX_BASE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_YRBX_BASE, java.math.BigDecimal.class, "医疗保险基数", "医疗保险基数", java.math.BigDecimal.class, null);
	
	/**
	 * 医疗保险个人 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_YRBX_PERSON="welfaerYrbxPerson";
	
	/**
	 * 医疗保险个人 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_YRBX_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_YRBX_PERSON, java.math.BigDecimal.class, "医疗保险个人", "医疗保险个人", java.math.BigDecimal.class, null);
	
	/**
	 * 医疗保险公司 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_YRBX_COMPANY="welfaerYrbxCompany";
	
	/**
	 * 医疗保险公司 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_YRBX_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_YRBX_COMPANY, java.math.BigDecimal.class, "医疗保险公司", "医疗保险公司", java.math.BigDecimal.class, null);
	
	/**
	 * 医疗缴费 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_YRBX_VALUE="welfaerYrbxValue";
	
	/**
	 * 医疗缴费 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_YRBX_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_YRBX_VALUE, java.math.BigDecimal.class, "医疗缴费", "医疗缴费", java.math.BigDecimal.class, null);
	
	/**
	 * 生育保险基数 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_SYBX_BASE="welfaerSybxBase";
	
	/**
	 * 生育保险基数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_SYBX_BASE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_SYBX_BASE, java.math.BigDecimal.class, "生育保险基数", "生育保险基数", java.math.BigDecimal.class, null);
	
	/**
	 * 生育保险个人 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_SYBX_PERSON="welfaerSybxPerson";
	
	/**
	 * 生育保险个人 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_SYBX_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_SYBX_PERSON, java.math.BigDecimal.class, "生育保险个人", "生育保险个人", java.math.BigDecimal.class, null);
	
	/**
	 * 生育保险公司 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_SYBX_COMPANY="welfaerSybxCompany";
	
	/**
	 * 生育保险公司 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_SYBX_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_SYBX_COMPANY, java.math.BigDecimal.class, "生育保险公司", "生育保险公司", java.math.BigDecimal.class, null);
	
	/**
	 * 生育缴费 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_SYBX_VALUE="welfaerSybxValue";
	
	/**
	 * 生育缴费 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_SYBX_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_SYBX_VALUE, java.math.BigDecimal.class, "生育缴费", "生育缴费", java.math.BigDecimal.class, null);
	
	/**
	 * 失业保险基数 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_SYEBX_BASE="welfaerSyebxBase";
	
	/**
	 * 失业保险基数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_SYEBX_BASE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_SYEBX_BASE, java.math.BigDecimal.class, "失业保险基数", "失业保险基数", java.math.BigDecimal.class, null);
	
	/**
	 * 失业保险个人 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_SYEBX_PERSON="welfaerSyebxPerson";
	
	/**
	 * 失业保险个人 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_SYEBX_PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_SYEBX_PERSON, java.math.BigDecimal.class, "失业保险个人", "失业保险个人", java.math.BigDecimal.class, null);
	
	/**
	 * 失业保险公司 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_SYEBX_COMPANY="welfaerSyebxCompany";
	
	/**
	 * 失业保险公司 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_SYEBX_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_SYEBX_COMPANY, java.math.BigDecimal.class, "失业保险公司", "失业保险公司", java.math.BigDecimal.class, null);
	
	/**
	 * 失业缴费 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_SYEBX_VALUE="welfaerSyebxValue";
	
	/**
	 * 失业缴费 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_SYEBX_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_SYEBX_VALUE, java.math.BigDecimal.class, "失业缴费", "失业缴费", java.math.BigDecimal.class, null);
	
	/**
	 * 个人缴费总计 , 类型: java.math.BigDecimal
	*/
	public static final String WELFAER_PERSON_VALUE_TOTAL="welfaerPersonValueTotal";
	
	/**
	 * 个人缴费总计 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> WELFAER_PERSON_VALUE_TOTAL_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,WELFAER_PERSON_VALUE_TOTAL, java.math.BigDecimal.class, "个人缴费总计", "个人缴费总计", java.math.BigDecimal.class, null);
	
	/**
	 * 子女教育 , 类型: java.math.BigDecimal
	*/
	public static final String PERSONAL_TAX_ZNJY="personalTaxZnjy";
	
	/**
	 * 子女教育 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> PERSONAL_TAX_ZNJY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,PERSONAL_TAX_ZNJY, java.math.BigDecimal.class, "子女教育", "子女教育", java.math.BigDecimal.class, null);
	
	/**
	 * 继续教育 , 类型: java.math.BigDecimal
	*/
	public static final String PERSONAL_TAX_JXJY="personalTaxJxjy";
	
	/**
	 * 继续教育 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> PERSONAL_TAX_JXJY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,PERSONAL_TAX_JXJY, java.math.BigDecimal.class, "继续教育", "继续教育", java.math.BigDecimal.class, null);
	
	/**
	 * 大病医疗 , 类型: java.math.BigDecimal
	*/
	public static final String PERSONAL_TAX_DBYL="personalTaxDbyl";
	
	/**
	 * 大病医疗 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> PERSONAL_TAX_DBYL_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,PERSONAL_TAX_DBYL, java.math.BigDecimal.class, "大病医疗", "大病医疗", java.math.BigDecimal.class, null);
	
	/**
	 * 住房贷款 , 类型: java.math.BigDecimal
	*/
	public static final String PERSONAL_TAX_ZFDK="personalTaxZfdk";
	
	/**
	 * 住房贷款 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> PERSONAL_TAX_ZFDK_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,PERSONAL_TAX_ZFDK, java.math.BigDecimal.class, "住房贷款", "住房贷款", java.math.BigDecimal.class, null);
	
	/**
	 * 住房租金 , 类型: java.math.BigDecimal
	*/
	public static final String PERSONAL_TAX_ZFZJ="personalTaxZfzj";
	
	/**
	 * 住房租金 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> PERSONAL_TAX_ZFZJ_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,PERSONAL_TAX_ZFZJ, java.math.BigDecimal.class, "住房租金", "住房租金", java.math.BigDecimal.class, null);
	
	/**
	 * 赡养老人 , 类型: java.math.BigDecimal
	*/
	public static final String PERSONAL_TAX_SYLR="personalTaxSylr";
	
	/**
	 * 赡养老人 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> PERSONAL_TAX_SYLR_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,PERSONAL_TAX_SYLR, java.math.BigDecimal.class, "赡养老人", "赡养老人", java.math.BigDecimal.class, null);
	
	/**
	 * 幼儿照护 , 类型: java.math.BigDecimal
	*/
	public static final String PERSONAL_TAX_ERZH="personalTaxErzh";
	
	/**
	 * 幼儿照护 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> PERSONAL_TAX_ERZH_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,PERSONAL_TAX_ERZH, java.math.BigDecimal.class, "幼儿照护", "幼儿照护", java.math.BigDecimal.class, null);
	
	/**
	 * 专项扣除总计 , 类型: java.math.BigDecimal
	*/
	public static final String PERSONAL_TAX_TOTAL="personalTaxTotal";
	
	/**
	 * 专项扣除总计 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.math.BigDecimal> PERSONAL_TAX_TOTAL_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,PERSONAL_TAX_TOTAL, java.math.BigDecimal.class, "专项扣除总计", "专项扣除总计", java.math.BigDecimal.class, null);
	
	/**
	 * 生效时间 , 类型: java.util.Date
	*/
	public static final String EFFECT_TIME="effectTime";
	
	/**
	 * 生效时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.util.Date> EFFECT_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,EFFECT_TIME, java.util.Date.class, "生效时间", "生效时间", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 操作说明 , 类型: java.lang.String
	*/
	public static final String OPER_MSG="operMsg";
	
	/**
	 * 操作说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.String> OPER_MSG_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,OPER_MSG, java.lang.String.class, "操作说明", "操作说明", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * salaryTpl , 类型: com.dt.platform.domain.hr.SalaryTpl
	*/
	public static final String SALARY_TPL="salaryTpl";
	
	/**
	 * salaryTpl , 类型: com.dt.platform.domain.hr.SalaryTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,com.dt.platform.domain.hr.SalaryTpl> SALARY_TPL_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,SALARY_TPL, com.dt.platform.domain.hr.SalaryTpl.class, "salaryTpl", "salaryTpl", com.dt.platform.domain.hr.SalaryTpl.class, null);
	
	/**
	 * salaryAction , 类型: com.dt.platform.domain.hr.SalaryAction
	*/
	public static final String SALARY_ACTION="salaryAction";
	
	/**
	 * salaryAction , 类型: com.dt.platform.domain.hr.SalaryAction
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,com.dt.platform.domain.hr.SalaryAction> SALARY_ACTION_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,SALARY_ACTION, com.dt.platform.domain.hr.SalaryAction.class, "salaryAction", "salaryAction", com.dt.platform.domain.hr.SalaryAction.class, null);
	
	/**
	 * extBank , 类型: java.lang.String
	*/
	public static final String EXT_BANK="extBank";
	
	/**
	 * extBank , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.String> EXT_BANK_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,EXT_BANK, java.lang.String.class, "extBank", "extBank", java.lang.String.class, null);
	
	/**
	 * extBankAccount , 类型: java.lang.String
	*/
	public static final String EXT_BANK_ACCOUNT="extBankAccount";
	
	/**
	 * extBankAccount , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,java.lang.String> EXT_BANK_ACCOUNT_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,EXT_BANK_ACCOUNT, java.lang.String.class, "extBankAccount", "extBankAccount", java.lang.String.class, null);
	
	/**
	 * person , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final String PERSON="person";
	
	/**
	 * person , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,com.dt.platform.domain.hr.Person> PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,PERSON, com.dt.platform.domain.hr.Person.class, "person", "person", com.dt.platform.domain.hr.Person.class, null);
	
	/**
	 * personSalary , 类型: com.dt.platform.domain.hr.Salary
	*/
	public static final String PERSON_SALARY="personSalary";
	
	/**
	 * personSalary , 类型: com.dt.platform.domain.hr.Salary
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryDetail,com.dt.platform.domain.hr.Salary> PERSON_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryDetail.class ,PERSON_SALARY, com.dt.platform.domain.hr.Salary.class, "personSalary", "personSalary", com.dt.platform.domain.hr.Salary.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , USER_NAME , ACTION_MONTH , PERSON_ID , JOB_NUMBER , BANK , BANK_ACCOUNT , TPL_ID , ACTION_ID , STATUS , TOTAL_AMOUNT , PAY_AMOUNT , ISSUED_AMOUNT , BASE_SALARY , POST_SALARY , WORKING_YEARS_SALARY , FIXED_SALARY , ACHIEVEMENT_SALARY , OVERTIME_SALARY , COMMUNICATION_SALARY , TRAFFIC_SALARY , HOUSING_SALARY , HIGH_TEMPERATURE_SALARY , OTHER_SALARY , COMMISSION_SALARY , PUNISH_SALARY , DAY_SALARY , DEDUCT_KQ , DEDUCT_GH , DEDUCT_OTHER , DEDUCT_PERSONAL_TAX_RED , PT_GRSDS , PT_DKJS , WORK_OVERTIME_H_CNT , LATE_CNT , PERSONAL_LEAVE_CNT , WORK_DAY_CNT , PT_SL_PCT , WELFARE_ZFGJJ_BASE , WELFARE_ZFGJJ_PERSON , WELFARE_ZFGJJ_COMPANY , WELFARE_ZFGJJ_VALUE , WELFAER_YLBX_BASE , WELFAER_YLBX_PERSON , WELFAER_YLBX_COMPANY , WELFAER_YLBX_VALUE , WELFAER_GSBX_BASE , WELFAER_GSBX_PERSON , WELFAER_GSBX_COMPANY , WELFAER_GSBX_VALUE , WELFAER_YRBX_BASE , WELFAER_YRBX_PERSON , WELFAER_YRBX_COMPANY , WELFAER_YRBX_VALUE , WELFAER_SYBX_BASE , WELFAER_SYBX_PERSON , WELFAER_SYBX_COMPANY , WELFAER_SYBX_VALUE , WELFAER_SYEBX_BASE , WELFAER_SYEBX_PERSON , WELFAER_SYEBX_COMPANY , WELFAER_SYEBX_VALUE , WELFAER_PERSON_VALUE_TOTAL , PERSONAL_TAX_ZNJY , PERSONAL_TAX_JXJY , PERSONAL_TAX_DBYL , PERSONAL_TAX_ZFDK , PERSONAL_TAX_ZFZJ , PERSONAL_TAX_SYLR , PERSONAL_TAX_ERZH , PERSONAL_TAX_TOTAL , EFFECT_TIME , NOTES , OPER_MSG , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SALARY_TPL , SALARY_ACTION , EXT_BANK , EXT_BANK_ACCOUNT , PERSON , PERSON_SALARY };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.SalaryDetail {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public SalaryDetail setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 姓名
		 * @param userName 姓名
		 * @return 当前对象
		*/
		public SalaryDetail setUserName(String userName) {
			super.change(USER_NAME,super.getUserName(),userName);
			super.setUserName(userName);
			return this;
		}
		
		/**
		 * 设置 月份
		 * @param actionMonth 月份
		 * @return 当前对象
		*/
		public SalaryDetail setActionMonth(String actionMonth) {
			super.change(ACTION_MONTH,super.getActionMonth(),actionMonth);
			super.setActionMonth(actionMonth);
			return this;
		}
		
		/**
		 * 设置 人员
		 * @param personId 人员
		 * @return 当前对象
		*/
		public SalaryDetail setPersonId(String personId) {
			super.change(PERSON_ID,super.getPersonId(),personId);
			super.setPersonId(personId);
			return this;
		}
		
		/**
		 * 设置 工号
		 * @param jobNumber 工号
		 * @return 当前对象
		*/
		public SalaryDetail setJobNumber(String jobNumber) {
			super.change(JOB_NUMBER,super.getJobNumber(),jobNumber);
			super.setJobNumber(jobNumber);
			return this;
		}
		
		/**
		 * 设置 银行名称
		 * @param bank 银行名称
		 * @return 当前对象
		*/
		public SalaryDetail setBank(String bank) {
			super.change(BANK,super.getBank(),bank);
			super.setBank(bank);
			return this;
		}
		
		/**
		 * 设置 银行账户
		 * @param bankAccount 银行账户
		 * @return 当前对象
		*/
		public SalaryDetail setBankAccount(String bankAccount) {
			super.change(BANK_ACCOUNT,super.getBankAccount(),bankAccount);
			super.setBankAccount(bankAccount);
			return this;
		}
		
		/**
		 * 设置 模版
		 * @param tplId 模版
		 * @return 当前对象
		*/
		public SalaryDetail setTplId(String tplId) {
			super.change(TPL_ID,super.getTplId(),tplId);
			super.setTplId(tplId);
			return this;
		}
		
		/**
		 * 设置 动作
		 * @param actionId 动作
		 * @return 当前对象
		*/
		public SalaryDetail setActionId(String actionId) {
			super.change(ACTION_ID,super.getActionId(),actionId);
			super.setActionId(actionId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public SalaryDetail setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 工资
		 * @param totalAmount 工资
		 * @return 当前对象
		*/
		public SalaryDetail setTotalAmount(BigDecimal totalAmount) {
			super.change(TOTAL_AMOUNT,super.getTotalAmount(),totalAmount);
			super.setTotalAmount(totalAmount);
			return this;
		}
		
		/**
		 * 设置 应发金额
		 * @param payAmount 应发金额
		 * @return 当前对象
		*/
		public SalaryDetail setPayAmount(BigDecimal payAmount) {
			super.change(PAY_AMOUNT,super.getPayAmount(),payAmount);
			super.setPayAmount(payAmount);
			return this;
		}
		
		/**
		 * 设置 实发金额
		 * @param issuedAmount 实发金额
		 * @return 当前对象
		*/
		public SalaryDetail setIssuedAmount(BigDecimal issuedAmount) {
			super.change(ISSUED_AMOUNT,super.getIssuedAmount(),issuedAmount);
			super.setIssuedAmount(issuedAmount);
			return this;
		}
		
		/**
		 * 设置 基本工资
		 * @param baseSalary 基本工资
		 * @return 当前对象
		*/
		public SalaryDetail setBaseSalary(BigDecimal baseSalary) {
			super.change(BASE_SALARY,super.getBaseSalary(),baseSalary);
			super.setBaseSalary(baseSalary);
			return this;
		}
		
		/**
		 * 设置 岗位工资
		 * @param postSalary 岗位工资
		 * @return 当前对象
		*/
		public SalaryDetail setPostSalary(BigDecimal postSalary) {
			super.change(POST_SALARY,super.getPostSalary(),postSalary);
			super.setPostSalary(postSalary);
			return this;
		}
		
		/**
		 * 设置 工龄工资
		 * @param workingYearsSalary 工龄工资
		 * @return 当前对象
		*/
		public SalaryDetail setWorkingYearsSalary(BigDecimal workingYearsSalary) {
			super.change(WORKING_YEARS_SALARY,super.getWorkingYearsSalary(),workingYearsSalary);
			super.setWorkingYearsSalary(workingYearsSalary);
			return this;
		}
		
		/**
		 * 设置 固定补贴
		 * @param fixedSalary 固定补贴
		 * @return 当前对象
		*/
		public SalaryDetail setFixedSalary(BigDecimal fixedSalary) {
			super.change(FIXED_SALARY,super.getFixedSalary(),fixedSalary);
			super.setFixedSalary(fixedSalary);
			return this;
		}
		
		/**
		 * 设置 绩效补贴
		 * @param achievementSalary 绩效补贴
		 * @return 当前对象
		*/
		public SalaryDetail setAchievementSalary(BigDecimal achievementSalary) {
			super.change(ACHIEVEMENT_SALARY,super.getAchievementSalary(),achievementSalary);
			super.setAchievementSalary(achievementSalary);
			return this;
		}
		
		/**
		 * 设置 加班补贴
		 * @param overtimeSalary 加班补贴
		 * @return 当前对象
		*/
		public SalaryDetail setOvertimeSalary(BigDecimal overtimeSalary) {
			super.change(OVERTIME_SALARY,super.getOvertimeSalary(),overtimeSalary);
			super.setOvertimeSalary(overtimeSalary);
			return this;
		}
		
		/**
		 * 设置 通讯补贴
		 * @param communicationSalary 通讯补贴
		 * @return 当前对象
		*/
		public SalaryDetail setCommunicationSalary(BigDecimal communicationSalary) {
			super.change(COMMUNICATION_SALARY,super.getCommunicationSalary(),communicationSalary);
			super.setCommunicationSalary(communicationSalary);
			return this;
		}
		
		/**
		 * 设置 交通补贴
		 * @param trafficSalary 交通补贴
		 * @return 当前对象
		*/
		public SalaryDetail setTrafficSalary(BigDecimal trafficSalary) {
			super.change(TRAFFIC_SALARY,super.getTrafficSalary(),trafficSalary);
			super.setTrafficSalary(trafficSalary);
			return this;
		}
		
		/**
		 * 设置 住房补贴
		 * @param housingSalary 住房补贴
		 * @return 当前对象
		*/
		public SalaryDetail setHousingSalary(BigDecimal housingSalary) {
			super.change(HOUSING_SALARY,super.getHousingSalary(),housingSalary);
			super.setHousingSalary(housingSalary);
			return this;
		}
		
		/**
		 * 设置 高温补贴
		 * @param highTemperatureSalary 高温补贴
		 * @return 当前对象
		*/
		public SalaryDetail setHighTemperatureSalary(BigDecimal highTemperatureSalary) {
			super.change(HIGH_TEMPERATURE_SALARY,super.getHighTemperatureSalary(),highTemperatureSalary);
			super.setHighTemperatureSalary(highTemperatureSalary);
			return this;
		}
		
		/**
		 * 设置 其他补贴
		 * @param otherSalary 其他补贴
		 * @return 当前对象
		*/
		public SalaryDetail setOtherSalary(BigDecimal otherSalary) {
			super.change(OTHER_SALARY,super.getOtherSalary(),otherSalary);
			super.setOtherSalary(otherSalary);
			return this;
		}
		
		/**
		 * 设置 提成工资
		 * @param commissionSalary 提成工资
		 * @return 当前对象
		*/
		public SalaryDetail setCommissionSalary(BigDecimal commissionSalary) {
			super.change(COMMISSION_SALARY,super.getCommissionSalary(),commissionSalary);
			super.setCommissionSalary(commissionSalary);
			return this;
		}
		
		/**
		 * 设置 处罚金额
		 * @param punishSalary 处罚金额
		 * @return 当前对象
		*/
		public SalaryDetail setPunishSalary(BigDecimal punishSalary) {
			super.change(PUNISH_SALARY,super.getPunishSalary(),punishSalary);
			super.setPunishSalary(punishSalary);
			return this;
		}
		
		/**
		 * 设置 每日工资
		 * @param daySalary 每日工资
		 * @return 当前对象
		*/
		public SalaryDetail setDaySalary(BigDecimal daySalary) {
			super.change(DAY_SALARY,super.getDaySalary(),daySalary);
			super.setDaySalary(daySalary);
			return this;
		}
		
		/**
		 * 设置 扣除考勤
		 * @param deductKq 扣除考勤
		 * @return 当前对象
		*/
		public SalaryDetail setDeductKq(BigDecimal deductKq) {
			super.change(DEDUCT_KQ,super.getDeductKq(),deductKq);
			super.setDeductKq(deductKq);
			return this;
		}
		
		/**
		 * 设置 扣除工会
		 * @param deductGh 扣除工会
		 * @return 当前对象
		*/
		public SalaryDetail setDeductGh(BigDecimal deductGh) {
			super.change(DEDUCT_GH,super.getDeductGh(),deductGh);
			super.setDeductGh(deductGh);
			return this;
		}
		
		/**
		 * 设置 扣除其他
		 * @param deductOther 扣除其他
		 * @return 当前对象
		*/
		public SalaryDetail setDeductOther(BigDecimal deductOther) {
			super.change(DEDUCT_OTHER,super.getDeductOther(),deductOther);
			super.setDeductOther(deductOther);
			return this;
		}
		
		/**
		 * 设置 个税抵扣
		 * @param deductPersonalTaxRed 个税抵扣
		 * @return 当前对象
		*/
		public SalaryDetail setDeductPersonalTaxRed(BigDecimal deductPersonalTaxRed) {
			super.change(DEDUCT_PERSONAL_TAX_RED,super.getDeductPersonalTaxRed(),deductPersonalTaxRed);
			super.setDeductPersonalTaxRed(deductPersonalTaxRed);
			return this;
		}
		
		/**
		 * 设置 个人所得税
		 * @param ptGrsds 个人所得税
		 * @return 当前对象
		*/
		public SalaryDetail setPtGrsds(BigDecimal ptGrsds) {
			super.change(PT_GRSDS,super.getPtGrsds(),ptGrsds);
			super.setPtGrsds(ptGrsds);
			return this;
		}
		
		/**
		 * 设置 抵扣基数
		 * @param ptDkjs 抵扣基数
		 * @return 当前对象
		*/
		public SalaryDetail setPtDkjs(BigDecimal ptDkjs) {
			super.change(PT_DKJS,super.getPtDkjs(),ptDkjs);
			super.setPtDkjs(ptDkjs);
			return this;
		}
		
		/**
		 * 设置 加班时长
		 * @param workOvertimeHCnt 加班时长
		 * @return 当前对象
		*/
		public SalaryDetail setWorkOvertimeHCnt(BigDecimal workOvertimeHCnt) {
			super.change(WORK_OVERTIME_H_CNT,super.getWorkOvertimeHCnt(),workOvertimeHCnt);
			super.setWorkOvertimeHCnt(workOvertimeHCnt);
			return this;
		}
		
		/**
		 * 设置 迟到次数
		 * @param lateCnt 迟到次数
		 * @return 当前对象
		*/
		public SalaryDetail setLateCnt(BigDecimal lateCnt) {
			super.change(LATE_CNT,super.getLateCnt(),lateCnt);
			super.setLateCnt(lateCnt);
			return this;
		}
		
		/**
		 * 设置 事假天数
		 * @param personalLeaveCnt 事假天数
		 * @return 当前对象
		*/
		public SalaryDetail setPersonalLeaveCnt(BigDecimal personalLeaveCnt) {
			super.change(PERSONAL_LEAVE_CNT,super.getPersonalLeaveCnt(),personalLeaveCnt);
			super.setPersonalLeaveCnt(personalLeaveCnt);
			return this;
		}
		
		/**
		 * 设置 工作天数
		 * @param workDayCnt 工作天数
		 * @return 当前对象
		*/
		public SalaryDetail setWorkDayCnt(BigDecimal workDayCnt) {
			super.change(WORK_DAY_CNT,super.getWorkDayCnt(),workDayCnt);
			super.setWorkDayCnt(workDayCnt);
			return this;
		}
		
		/**
		 * 设置 税率
		 * @param ptSlPct 税率
		 * @return 当前对象
		*/
		public SalaryDetail setPtSlPct(BigDecimal ptSlPct) {
			super.change(PT_SL_PCT,super.getPtSlPct(),ptSlPct);
			super.setPtSlPct(ptSlPct);
			return this;
		}
		
		/**
		 * 设置 住房公积金基数
		 * @param welfareZfgjjBase 住房公积金基数
		 * @return 当前对象
		*/
		public SalaryDetail setWelfareZfgjjBase(BigDecimal welfareZfgjjBase) {
			super.change(WELFARE_ZFGJJ_BASE,super.getWelfareZfgjjBase(),welfareZfgjjBase);
			super.setWelfareZfgjjBase(welfareZfgjjBase);
			return this;
		}
		
		/**
		 * 设置 住房公积金个人
		 * @param welfareZfgjjPerson 住房公积金个人
		 * @return 当前对象
		*/
		public SalaryDetail setWelfareZfgjjPerson(BigDecimal welfareZfgjjPerson) {
			super.change(WELFARE_ZFGJJ_PERSON,super.getWelfareZfgjjPerson(),welfareZfgjjPerson);
			super.setWelfareZfgjjPerson(welfareZfgjjPerson);
			return this;
		}
		
		/**
		 * 设置 住房公积金公司
		 * @param welfareZfgjjCompany 住房公积金公司
		 * @return 当前对象
		*/
		public SalaryDetail setWelfareZfgjjCompany(BigDecimal welfareZfgjjCompany) {
			super.change(WELFARE_ZFGJJ_COMPANY,super.getWelfareZfgjjCompany(),welfareZfgjjCompany);
			super.setWelfareZfgjjCompany(welfareZfgjjCompany);
			return this;
		}
		
		/**
		 * 设置 住房缴费
		 * @param welfareZfgjjValue 住房缴费
		 * @return 当前对象
		*/
		public SalaryDetail setWelfareZfgjjValue(BigDecimal welfareZfgjjValue) {
			super.change(WELFARE_ZFGJJ_VALUE,super.getWelfareZfgjjValue(),welfareZfgjjValue);
			super.setWelfareZfgjjValue(welfareZfgjjValue);
			return this;
		}
		
		/**
		 * 设置 养老保险基数
		 * @param welfaerYlbxBase 养老保险基数
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerYlbxBase(BigDecimal welfaerYlbxBase) {
			super.change(WELFAER_YLBX_BASE,super.getWelfaerYlbxBase(),welfaerYlbxBase);
			super.setWelfaerYlbxBase(welfaerYlbxBase);
			return this;
		}
		
		/**
		 * 设置 养老保险个人
		 * @param welfaerYlbxPerson 养老保险个人
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerYlbxPerson(BigDecimal welfaerYlbxPerson) {
			super.change(WELFAER_YLBX_PERSON,super.getWelfaerYlbxPerson(),welfaerYlbxPerson);
			super.setWelfaerYlbxPerson(welfaerYlbxPerson);
			return this;
		}
		
		/**
		 * 设置 养老保险公司
		 * @param welfaerYlbxCompany 养老保险公司
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerYlbxCompany(BigDecimal welfaerYlbxCompany) {
			super.change(WELFAER_YLBX_COMPANY,super.getWelfaerYlbxCompany(),welfaerYlbxCompany);
			super.setWelfaerYlbxCompany(welfaerYlbxCompany);
			return this;
		}
		
		/**
		 * 设置 养老缴费
		 * @param welfaerYlbxValue 养老缴费
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerYlbxValue(BigDecimal welfaerYlbxValue) {
			super.change(WELFAER_YLBX_VALUE,super.getWelfaerYlbxValue(),welfaerYlbxValue);
			super.setWelfaerYlbxValue(welfaerYlbxValue);
			return this;
		}
		
		/**
		 * 设置 工伤保险基数
		 * @param welfaerGsbxBase 工伤保险基数
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerGsbxBase(BigDecimal welfaerGsbxBase) {
			super.change(WELFAER_GSBX_BASE,super.getWelfaerGsbxBase(),welfaerGsbxBase);
			super.setWelfaerGsbxBase(welfaerGsbxBase);
			return this;
		}
		
		/**
		 * 设置 工伤保险个人
		 * @param welfaerGsbxPerson 工伤保险个人
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerGsbxPerson(BigDecimal welfaerGsbxPerson) {
			super.change(WELFAER_GSBX_PERSON,super.getWelfaerGsbxPerson(),welfaerGsbxPerson);
			super.setWelfaerGsbxPerson(welfaerGsbxPerson);
			return this;
		}
		
		/**
		 * 设置 工伤保险公司
		 * @param welfaerGsbxCompany 工伤保险公司
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerGsbxCompany(BigDecimal welfaerGsbxCompany) {
			super.change(WELFAER_GSBX_COMPANY,super.getWelfaerGsbxCompany(),welfaerGsbxCompany);
			super.setWelfaerGsbxCompany(welfaerGsbxCompany);
			return this;
		}
		
		/**
		 * 设置 工伤缴费
		 * @param welfaerGsbxValue 工伤缴费
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerGsbxValue(BigDecimal welfaerGsbxValue) {
			super.change(WELFAER_GSBX_VALUE,super.getWelfaerGsbxValue(),welfaerGsbxValue);
			super.setWelfaerGsbxValue(welfaerGsbxValue);
			return this;
		}
		
		/**
		 * 设置 医疗保险基数
		 * @param welfaerYrbxBase 医疗保险基数
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerYrbxBase(BigDecimal welfaerYrbxBase) {
			super.change(WELFAER_YRBX_BASE,super.getWelfaerYrbxBase(),welfaerYrbxBase);
			super.setWelfaerYrbxBase(welfaerYrbxBase);
			return this;
		}
		
		/**
		 * 设置 医疗保险个人
		 * @param welfaerYrbxPerson 医疗保险个人
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerYrbxPerson(BigDecimal welfaerYrbxPerson) {
			super.change(WELFAER_YRBX_PERSON,super.getWelfaerYrbxPerson(),welfaerYrbxPerson);
			super.setWelfaerYrbxPerson(welfaerYrbxPerson);
			return this;
		}
		
		/**
		 * 设置 医疗保险公司
		 * @param welfaerYrbxCompany 医疗保险公司
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerYrbxCompany(BigDecimal welfaerYrbxCompany) {
			super.change(WELFAER_YRBX_COMPANY,super.getWelfaerYrbxCompany(),welfaerYrbxCompany);
			super.setWelfaerYrbxCompany(welfaerYrbxCompany);
			return this;
		}
		
		/**
		 * 设置 医疗缴费
		 * @param welfaerYrbxValue 医疗缴费
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerYrbxValue(BigDecimal welfaerYrbxValue) {
			super.change(WELFAER_YRBX_VALUE,super.getWelfaerYrbxValue(),welfaerYrbxValue);
			super.setWelfaerYrbxValue(welfaerYrbxValue);
			return this;
		}
		
		/**
		 * 设置 生育保险基数
		 * @param welfaerSybxBase 生育保险基数
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerSybxBase(BigDecimal welfaerSybxBase) {
			super.change(WELFAER_SYBX_BASE,super.getWelfaerSybxBase(),welfaerSybxBase);
			super.setWelfaerSybxBase(welfaerSybxBase);
			return this;
		}
		
		/**
		 * 设置 生育保险个人
		 * @param welfaerSybxPerson 生育保险个人
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerSybxPerson(BigDecimal welfaerSybxPerson) {
			super.change(WELFAER_SYBX_PERSON,super.getWelfaerSybxPerson(),welfaerSybxPerson);
			super.setWelfaerSybxPerson(welfaerSybxPerson);
			return this;
		}
		
		/**
		 * 设置 生育保险公司
		 * @param welfaerSybxCompany 生育保险公司
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerSybxCompany(BigDecimal welfaerSybxCompany) {
			super.change(WELFAER_SYBX_COMPANY,super.getWelfaerSybxCompany(),welfaerSybxCompany);
			super.setWelfaerSybxCompany(welfaerSybxCompany);
			return this;
		}
		
		/**
		 * 设置 生育缴费
		 * @param welfaerSybxValue 生育缴费
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerSybxValue(BigDecimal welfaerSybxValue) {
			super.change(WELFAER_SYBX_VALUE,super.getWelfaerSybxValue(),welfaerSybxValue);
			super.setWelfaerSybxValue(welfaerSybxValue);
			return this;
		}
		
		/**
		 * 设置 失业保险基数
		 * @param welfaerSyebxBase 失业保险基数
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerSyebxBase(BigDecimal welfaerSyebxBase) {
			super.change(WELFAER_SYEBX_BASE,super.getWelfaerSyebxBase(),welfaerSyebxBase);
			super.setWelfaerSyebxBase(welfaerSyebxBase);
			return this;
		}
		
		/**
		 * 设置 失业保险个人
		 * @param welfaerSyebxPerson 失业保险个人
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerSyebxPerson(BigDecimal welfaerSyebxPerson) {
			super.change(WELFAER_SYEBX_PERSON,super.getWelfaerSyebxPerson(),welfaerSyebxPerson);
			super.setWelfaerSyebxPerson(welfaerSyebxPerson);
			return this;
		}
		
		/**
		 * 设置 失业保险公司
		 * @param welfaerSyebxCompany 失业保险公司
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerSyebxCompany(BigDecimal welfaerSyebxCompany) {
			super.change(WELFAER_SYEBX_COMPANY,super.getWelfaerSyebxCompany(),welfaerSyebxCompany);
			super.setWelfaerSyebxCompany(welfaerSyebxCompany);
			return this;
		}
		
		/**
		 * 设置 失业缴费
		 * @param welfaerSyebxValue 失业缴费
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerSyebxValue(BigDecimal welfaerSyebxValue) {
			super.change(WELFAER_SYEBX_VALUE,super.getWelfaerSyebxValue(),welfaerSyebxValue);
			super.setWelfaerSyebxValue(welfaerSyebxValue);
			return this;
		}
		
		/**
		 * 设置 个人缴费总计
		 * @param welfaerPersonValueTotal 个人缴费总计
		 * @return 当前对象
		*/
		public SalaryDetail setWelfaerPersonValueTotal(BigDecimal welfaerPersonValueTotal) {
			super.change(WELFAER_PERSON_VALUE_TOTAL,super.getWelfaerPersonValueTotal(),welfaerPersonValueTotal);
			super.setWelfaerPersonValueTotal(welfaerPersonValueTotal);
			return this;
		}
		
		/**
		 * 设置 子女教育
		 * @param personalTaxZnjy 子女教育
		 * @return 当前对象
		*/
		public SalaryDetail setPersonalTaxZnjy(BigDecimal personalTaxZnjy) {
			super.change(PERSONAL_TAX_ZNJY,super.getPersonalTaxZnjy(),personalTaxZnjy);
			super.setPersonalTaxZnjy(personalTaxZnjy);
			return this;
		}
		
		/**
		 * 设置 继续教育
		 * @param personalTaxJxjy 继续教育
		 * @return 当前对象
		*/
		public SalaryDetail setPersonalTaxJxjy(BigDecimal personalTaxJxjy) {
			super.change(PERSONAL_TAX_JXJY,super.getPersonalTaxJxjy(),personalTaxJxjy);
			super.setPersonalTaxJxjy(personalTaxJxjy);
			return this;
		}
		
		/**
		 * 设置 大病医疗
		 * @param personalTaxDbyl 大病医疗
		 * @return 当前对象
		*/
		public SalaryDetail setPersonalTaxDbyl(BigDecimal personalTaxDbyl) {
			super.change(PERSONAL_TAX_DBYL,super.getPersonalTaxDbyl(),personalTaxDbyl);
			super.setPersonalTaxDbyl(personalTaxDbyl);
			return this;
		}
		
		/**
		 * 设置 住房贷款
		 * @param personalTaxZfdk 住房贷款
		 * @return 当前对象
		*/
		public SalaryDetail setPersonalTaxZfdk(BigDecimal personalTaxZfdk) {
			super.change(PERSONAL_TAX_ZFDK,super.getPersonalTaxZfdk(),personalTaxZfdk);
			super.setPersonalTaxZfdk(personalTaxZfdk);
			return this;
		}
		
		/**
		 * 设置 住房租金
		 * @param personalTaxZfzj 住房租金
		 * @return 当前对象
		*/
		public SalaryDetail setPersonalTaxZfzj(BigDecimal personalTaxZfzj) {
			super.change(PERSONAL_TAX_ZFZJ,super.getPersonalTaxZfzj(),personalTaxZfzj);
			super.setPersonalTaxZfzj(personalTaxZfzj);
			return this;
		}
		
		/**
		 * 设置 赡养老人
		 * @param personalTaxSylr 赡养老人
		 * @return 当前对象
		*/
		public SalaryDetail setPersonalTaxSylr(BigDecimal personalTaxSylr) {
			super.change(PERSONAL_TAX_SYLR,super.getPersonalTaxSylr(),personalTaxSylr);
			super.setPersonalTaxSylr(personalTaxSylr);
			return this;
		}
		
		/**
		 * 设置 幼儿照护
		 * @param personalTaxErzh 幼儿照护
		 * @return 当前对象
		*/
		public SalaryDetail setPersonalTaxErzh(BigDecimal personalTaxErzh) {
			super.change(PERSONAL_TAX_ERZH,super.getPersonalTaxErzh(),personalTaxErzh);
			super.setPersonalTaxErzh(personalTaxErzh);
			return this;
		}
		
		/**
		 * 设置 专项扣除总计
		 * @param personalTaxTotal 专项扣除总计
		 * @return 当前对象
		*/
		public SalaryDetail setPersonalTaxTotal(BigDecimal personalTaxTotal) {
			super.change(PERSONAL_TAX_TOTAL,super.getPersonalTaxTotal(),personalTaxTotal);
			super.setPersonalTaxTotal(personalTaxTotal);
			return this;
		}
		
		/**
		 * 设置 生效时间
		 * @param effectTime 生效时间
		 * @return 当前对象
		*/
		public SalaryDetail setEffectTime(Date effectTime) {
			super.change(EFFECT_TIME,super.getEffectTime(),effectTime);
			super.setEffectTime(effectTime);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public SalaryDetail setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 操作说明
		 * @param operMsg 操作说明
		 * @return 当前对象
		*/
		public SalaryDetail setOperMsg(String operMsg) {
			super.change(OPER_MSG,super.getOperMsg(),operMsg);
			super.setOperMsg(operMsg);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SalaryDetail setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SalaryDetail setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SalaryDetail setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SalaryDetail setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SalaryDetail setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SalaryDetail setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SalaryDetail setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public SalaryDetail setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public SalaryDetail setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 salaryTpl
		 * @param salaryTpl salaryTpl
		 * @return 当前对象
		*/
		public SalaryDetail setSalaryTpl(SalaryTpl salaryTpl) {
			super.change(SALARY_TPL,super.getSalaryTpl(),salaryTpl);
			super.setSalaryTpl(salaryTpl);
			return this;
		}
		
		/**
		 * 设置 salaryAction
		 * @param salaryAction salaryAction
		 * @return 当前对象
		*/
		public SalaryDetail setSalaryAction(SalaryAction salaryAction) {
			super.change(SALARY_ACTION,super.getSalaryAction(),salaryAction);
			super.setSalaryAction(salaryAction);
			return this;
		}
		
		/**
		 * 设置 extBank
		 * @param extBank extBank
		 * @return 当前对象
		*/
		public SalaryDetail setExtBank(String extBank) {
			super.change(EXT_BANK,super.getExtBank(),extBank);
			super.setExtBank(extBank);
			return this;
		}
		
		/**
		 * 设置 extBankAccount
		 * @param extBankAccount extBankAccount
		 * @return 当前对象
		*/
		public SalaryDetail setExtBankAccount(String extBankAccount) {
			super.change(EXT_BANK_ACCOUNT,super.getExtBankAccount(),extBankAccount);
			super.setExtBankAccount(extBankAccount);
			return this;
		}
		
		/**
		 * 设置 person
		 * @param person person
		 * @return 当前对象
		*/
		public SalaryDetail setPerson(Person person) {
			super.change(PERSON,super.getPerson(),person);
			super.setPerson(person);
			return this;
		}
		
		/**
		 * 设置 personSalary
		 * @param personSalary personSalary
		 * @return 当前对象
		*/
		public SalaryDetail setPersonSalary(Salary personSalary) {
			super.change(PERSON_SALARY,super.getPersonSalary(),personSalary);
			super.setPersonSalary(personSalary);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public SalaryDetail clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public SalaryDetail duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setHighTemperatureSalary(this.getHighTemperatureSalary());
			inst.setPersonalTaxTotal(this.getPersonalTaxTotal());
			inst.setWorkOvertimeHCnt(this.getWorkOvertimeHCnt());
			inst.setNotes(this.getNotes());
			inst.setWelfareZfgjjBase(this.getWelfareZfgjjBase());
			inst.setDeductKq(this.getDeductKq());
			inst.setWelfaerPersonValueTotal(this.getWelfaerPersonValueTotal());
			inst.setDeductGh(this.getDeductGh());
			inst.setWelfareZfgjjPerson(this.getWelfareZfgjjPerson());
			inst.setActionMonth(this.getActionMonth());
			inst.setDaySalary(this.getDaySalary());
			inst.setWelfaerYlbxCompany(this.getWelfaerYlbxCompany());
			inst.setPersonalTaxErzh(this.getPersonalTaxErzh());
			inst.setBank(this.getBank());
			inst.setPersonalTaxJxjy(this.getPersonalTaxJxjy());
			inst.setPayAmount(this.getPayAmount());
			inst.setCommunicationSalary(this.getCommunicationSalary());
			inst.setPtDkjs(this.getPtDkjs());
			inst.setWelfaerSyebxValue(this.getWelfaerSyebxValue());
			inst.setPtGrsds(this.getPtGrsds());
			inst.setFixedSalary(this.getFixedSalary());
			inst.setId(this.getId());
			inst.setWelfaerYlbxValue(this.getWelfaerYlbxValue());
			inst.setTrafficSalary(this.getTrafficSalary());
			inst.setWelfareZfgjjValue(this.getWelfareZfgjjValue());
			inst.setWelfaerYrbxCompany(this.getWelfaerYrbxCompany());
			inst.setBankAccount(this.getBankAccount());
			inst.setIssuedAmount(this.getIssuedAmount());
			inst.setWelfaerSybxBase(this.getWelfaerSybxBase());
			inst.setWelfaerGsbxBase(this.getWelfaerGsbxBase());
			inst.setWelfaerSybxCompany(this.getWelfaerSybxCompany());
			inst.setWelfaerYrbxBase(this.getWelfaerYrbxBase());
			inst.setWelfaerSyebxBase(this.getWelfaerSyebxBase());
			inst.setVersion(this.getVersion());
			inst.setTotalAmount(this.getTotalAmount());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setActionId(this.getActionId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setPersonId(this.getPersonId());
			inst.setEffectTime(this.getEffectTime());
			inst.setTplId(this.getTplId());
			inst.setOtherSalary(this.getOtherSalary());
			inst.setDeductPersonalTaxRed(this.getDeductPersonalTaxRed());
			inst.setCommissionSalary(this.getCommissionSalary());
			inst.setJobNumber(this.getJobNumber());
			inst.setWelfaerGsbxValue(this.getWelfaerGsbxValue());
			inst.setStatus(this.getStatus());
			inst.setPersonalTaxZfdk(this.getPersonalTaxZfdk());
			inst.setWelfaerSyebxPerson(this.getWelfaerSyebxPerson());
			inst.setWelfaerSybxPerson(this.getWelfaerSybxPerson());
			inst.setPunishSalary(this.getPunishSalary());
			inst.setWelfaerYlbxBase(this.getWelfaerYlbxBase());
			inst.setBaseSalary(this.getBaseSalary());
			inst.setPersonalTaxSylr(this.getPersonalTaxSylr());
			inst.setPersonalTaxZnjy(this.getPersonalTaxZnjy());
			inst.setPtSlPct(this.getPtSlPct());
			inst.setWelfaerGsbxPerson(this.getWelfaerGsbxPerson());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setWelfaerYlbxPerson(this.getWelfaerYlbxPerson());
			inst.setWelfaerYrbxValue(this.getWelfaerYrbxValue());
			inst.setWelfareZfgjjCompany(this.getWelfareZfgjjCompany());
			inst.setLateCnt(this.getLateCnt());
			inst.setWelfaerGsbxCompany(this.getWelfaerGsbxCompany());
			inst.setWelfaerSyebxCompany(this.getWelfaerSyebxCompany());
			inst.setHousingSalary(this.getHousingSalary());
			inst.setWelfaerYrbxPerson(this.getWelfaerYrbxPerson());
			inst.setOperMsg(this.getOperMsg());
			inst.setPersonalTaxZfzj(this.getPersonalTaxZfzj());
			inst.setWorkingYearsSalary(this.getWorkingYearsSalary());
			inst.setAchievementSalary(this.getAchievementSalary());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setPersonalTaxDbyl(this.getPersonalTaxDbyl());
			inst.setUserName(this.getUserName());
			inst.setPersonalLeaveCnt(this.getPersonalLeaveCnt());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeductOther(this.getDeductOther());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setWorkDayCnt(this.getWorkDayCnt());
			inst.setTenantId(this.getTenantId());
			inst.setPostSalary(this.getPostSalary());
			inst.setOvertimeSalary(this.getOvertimeSalary());
			inst.setWelfaerSybxValue(this.getWelfaerSybxValue());
			if(all) {
				inst.setExtBank(this.getExtBank());
				inst.setSalaryTpl(this.getSalaryTpl());
				inst.setExtBankAccount(this.getExtBankAccount());
				inst.setPerson(this.getPerson());
				inst.setSalaryAction(this.getSalaryAction());
				inst.setPersonSalary(this.getPersonSalary());
			}
			inst.clearModifies();
			return inst;
		}

	}
}