package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_SALARY_DETAIL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.SalaryDetailMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 薪酬明细
 * <p>薪酬明细 , 数据表 hr_salary_detail 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 23:33:40
 * @sign 6CF50B2A9DF778FE90AC6A85A571AED8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_salary_detail")
@ApiModel(description = "薪酬明细 ; 薪酬明细 , 数据表 hr_salary_detail 的PO类型")
public class SalaryDetail extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_SALARY_DETAIL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员")
	private String personId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 基本工资：基本工资
	*/
	@ApiModelProperty(required = false,value="基本工资" , notes = "基本工资")
	private BigDecimal baseSalary;
	
	/**
	 * 岗位工资：岗位工资
	*/
	@ApiModelProperty(required = false,value="岗位工资" , notes = "岗位工资")
	private BigDecimal postSalary;
	
	/**
	 * 工龄工资：工龄工资
	*/
	@ApiModelProperty(required = false,value="工龄工资" , notes = "工龄工资")
	private BigDecimal workingYearsSalary;
	
	/**
	 * 固定补贴：固定补贴
	*/
	@ApiModelProperty(required = false,value="固定补贴" , notes = "固定补贴")
	private BigDecimal fixedSalary;
	
	/**
	 * 绩效补贴：绩效补贴
	*/
	@ApiModelProperty(required = false,value="绩效补贴" , notes = "绩效补贴")
	private BigDecimal achievementSalary;
	
	/**
	 * 加班补贴：加班补贴
	*/
	@ApiModelProperty(required = false,value="加班补贴" , notes = "加班补贴")
	private BigDecimal overtimeSalary;
	
	/**
	 * 高温补贴：高温补贴
	*/
	@ApiModelProperty(required = false,value="高温补贴" , notes = "高温补贴")
	private BigDecimal highTemperatureSalary;
	
	/**
	 * 其他补贴：其他补贴
	*/
	@ApiModelProperty(required = false,value="其他补贴" , notes = "其他补贴")
	private BigDecimal otherSalary;
	
	/**
	 * 通讯补贴：通讯补贴
	*/
	@ApiModelProperty(required = false,value="通讯补贴" , notes = "通讯补贴")
	private BigDecimal communicationSalary;
	
	/**
	 * 交通补贴：交通补贴
	*/
	@ApiModelProperty(required = false,value="交通补贴" , notes = "交通补贴")
	private BigDecimal trafficSalary;
	
	/**
	 * 住房补贴：住房补贴
	*/
	@ApiModelProperty(required = false,value="住房补贴" , notes = "住房补贴")
	private BigDecimal housingSalary;
	
	/**
	 * 提成工资：提成工资
	*/
	@ApiModelProperty(required = false,value="提成工资" , notes = "提成工资")
	private BigDecimal commissionSalary;
	
	/**
	 * 住房公积金基数：住房公积金基数
	*/
	@ApiModelProperty(required = false,value="住房公积金基数" , notes = "住房公积金基数")
	private BigDecimal welfareZfgjjBase;
	
	/**
	 * 住房公积金个人：住房公积金个人
	*/
	@ApiModelProperty(required = false,value="住房公积金个人" , notes = "住房公积金个人")
	private BigDecimal welfareZfgjjPerson;
	
	/**
	 * 住房公积金公司：住房公积金公司
	*/
	@ApiModelProperty(required = false,value="住房公积金公司" , notes = "住房公积金公司")
	private BigDecimal welfareZfgjjCompany;
	
	/**
	 * 养老保险基数：养老保险基数
	*/
	@ApiModelProperty(required = false,value="养老保险基数" , notes = "养老保险基数")
	private BigDecimal welfaerYlbxBase;
	
	/**
	 * 养老保险个人：养老保险个人
	*/
	@ApiModelProperty(required = false,value="养老保险个人" , notes = "养老保险个人")
	private BigDecimal welfaerYlbxPerson;
	
	/**
	 * 养老保险公司：养老保险公司
	*/
	@ApiModelProperty(required = false,value="养老保险公司" , notes = "养老保险公司")
	private BigDecimal welfaerYlbxCompany;
	
	/**
	 * 工伤保险基数：工伤保险基数
	*/
	@ApiModelProperty(required = false,value="工伤保险基数" , notes = "工伤保险基数")
	private BigDecimal welfaerGsbxBase;
	
	/**
	 * 工伤保险个人：工伤保险个人
	*/
	@ApiModelProperty(required = false,value="工伤保险个人" , notes = "工伤保险个人")
	private BigDecimal welfaerGsbxPerson;
	
	/**
	 * 工伤保险公司：工伤保险公司
	*/
	@ApiModelProperty(required = false,value="工伤保险公司" , notes = "工伤保险公司")
	private BigDecimal welfaerGsbxCompany;
	
	/**
	 * 医疗保险基数：医疗保险基数
	*/
	@ApiModelProperty(required = false,value="医疗保险基数" , notes = "医疗保险基数")
	private BigDecimal welfaerYrbxBase;
	
	/**
	 * 医疗保险个人：医疗保险个人
	*/
	@ApiModelProperty(required = false,value="医疗保险个人" , notes = "医疗保险个人")
	private BigDecimal welfaerYrbxPerson;
	
	/**
	 * 医疗保险公司：医疗保险公司
	*/
	@ApiModelProperty(required = false,value="医疗保险公司" , notes = "医疗保险公司")
	private BigDecimal welfaerYrbxCompany;
	
	/**
	 * 生育保险基数：生育保险基数
	*/
	@ApiModelProperty(required = false,value="生育保险基数" , notes = "生育保险基数")
	private BigDecimal welfaerSybxBase;
	
	/**
	 * 生育保险个人：生育保险个人
	*/
	@ApiModelProperty(required = false,value="生育保险个人" , notes = "生育保险个人")
	private BigDecimal welfaerSybxPerson;
	
	/**
	 * 生育保险公司：生育保险公司
	*/
	@ApiModelProperty(required = false,value="生育保险公司" , notes = "生育保险公司")
	private BigDecimal welfaerSybxCompany;
	
	/**
	 * 扣除考勤：扣除考勤
	*/
	@ApiModelProperty(required = false,value="扣除考勤" , notes = "扣除考勤")
	private BigDecimal deductKq;
	
	/**
	 * 扣除工会：扣除工会
	*/
	@ApiModelProperty(required = false,value="扣除工会" , notes = "扣除工会")
	private BigDecimal deductGh;
	
	/**
	 * 扣除其他：扣除其他
	*/
	@ApiModelProperty(required = false,value="扣除其他" , notes = "扣除其他")
	private BigDecimal deductOther;
	
	/**
	 * 子女教育：子女教育
	*/
	@ApiModelProperty(required = false,value="子女教育" , notes = "子女教育")
	private BigDecimal personalTaxZnjy;
	
	/**
	 * 继续教育：继续教育
	*/
	@ApiModelProperty(required = false,value="继续教育" , notes = "继续教育")
	private BigDecimal personalTaxJxjy;
	
	/**
	 * 大病医疗：大病医疗
	*/
	@ApiModelProperty(required = false,value="大病医疗" , notes = "大病医疗")
	private BigDecimal personalTaxDbyl;
	
	/**
	 * 住房贷款：住房贷款
	*/
	@ApiModelProperty(required = false,value="住房贷款" , notes = "住房贷款")
	private BigDecimal personalTaxZfdk;
	
	/**
	 * 住房租金：住房租金
	*/
	@ApiModelProperty(required = false,value="住房租金" , notes = "住房租金")
	private BigDecimal personalTaxZfzj;
	
	/**
	 * 赡养老人：赡养老人
	*/
	@ApiModelProperty(required = false,value="赡养老人" , notes = "赡养老人")
	private BigDecimal personalTaxSylr;
	
	/**
	 * 幼儿照护：幼儿照护
	*/
	@ApiModelProperty(required = false,value="幼儿照护" , notes = "幼儿照护")
	private BigDecimal personalTaxErzh;
	
	/**
	 * 月份：月份
	*/
	@ApiModelProperty(required = false,value="月份" , notes = "月份")
	private String actionMonth;
	
	/**
	 * 个人所得税：个人所得税
	*/
	@ApiModelProperty(required = false,value="个人所得税" , notes = "个人所得税")
	private BigDecimal individualTax;
	
	/**
	 * 合计金额：合计金额
	*/
	@ApiModelProperty(required = false,value="合计金额" , notes = "合计金额")
	private BigDecimal totalAmount;
	
	/**
	 * 应发金额：应发金额
	*/
	@ApiModelProperty(required = false,value="应发金额" , notes = "应发金额")
	private BigDecimal payAmount;
	
	/**
	 * 实发金额：实发金额
	*/
	@ApiModelProperty(required = false,value="实发金额" , notes = "实发金额")
	private BigDecimal issuedAmount;
	
	/**
	 * 抵扣基数：抵扣基数
	*/
	@ApiModelProperty(required = false,value="抵扣基数" , notes = "抵扣基数")
	private BigDecimal ptDkjs;
	
	/**
	 * 税率：税率
	*/
	@ApiModelProperty(required = false,value="税率" , notes = "税率")
	private BigDecimal ptSlPct;
	
	/**
	 * 个人所得税：个人所得税
	*/
	@ApiModelProperty(required = false,value="个人所得税" , notes = "个人所得税")
	private BigDecimal ptGrsds;
	
	/**
	 * 姓名：姓名
	*/
	@ApiModelProperty(required = false,value="姓名" , notes = "姓名")
	private String userName;
	
	/**
	 * 生效时间：生效时间
	*/
	@ApiModelProperty(required = false,value="生效时间" , notes = "生效时间")
	private Date effectTime;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public SalaryDetail setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 人员<br>
	 * 人员
	 * @return 人员
	*/
	public String getPersonId() {
		return personId;
	}
	
	/**
	 * 设置 人员
	 * @param personId 人员
	 * @return 当前对象
	*/
	public SalaryDetail setPersonId(String personId) {
		this.personId=personId;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public SalaryDetail setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 基本工资<br>
	 * 基本工资
	 * @return 基本工资
	*/
	public BigDecimal getBaseSalary() {
		return baseSalary;
	}
	
	/**
	 * 设置 基本工资
	 * @param baseSalary 基本工资
	 * @return 当前对象
	*/
	public SalaryDetail setBaseSalary(BigDecimal baseSalary) {
		this.baseSalary=baseSalary;
		return this;
	}
	
	/**
	 * 获得 岗位工资<br>
	 * 岗位工资
	 * @return 岗位工资
	*/
	public BigDecimal getPostSalary() {
		return postSalary;
	}
	
	/**
	 * 设置 岗位工资
	 * @param postSalary 岗位工资
	 * @return 当前对象
	*/
	public SalaryDetail setPostSalary(BigDecimal postSalary) {
		this.postSalary=postSalary;
		return this;
	}
	
	/**
	 * 获得 工龄工资<br>
	 * 工龄工资
	 * @return 工龄工资
	*/
	public BigDecimal getWorkingYearsSalary() {
		return workingYearsSalary;
	}
	
	/**
	 * 设置 工龄工资
	 * @param workingYearsSalary 工龄工资
	 * @return 当前对象
	*/
	public SalaryDetail setWorkingYearsSalary(BigDecimal workingYearsSalary) {
		this.workingYearsSalary=workingYearsSalary;
		return this;
	}
	
	/**
	 * 获得 固定补贴<br>
	 * 固定补贴
	 * @return 固定补贴
	*/
	public BigDecimal getFixedSalary() {
		return fixedSalary;
	}
	
	/**
	 * 设置 固定补贴
	 * @param fixedSalary 固定补贴
	 * @return 当前对象
	*/
	public SalaryDetail setFixedSalary(BigDecimal fixedSalary) {
		this.fixedSalary=fixedSalary;
		return this;
	}
	
	/**
	 * 获得 绩效补贴<br>
	 * 绩效补贴
	 * @return 绩效补贴
	*/
	public BigDecimal getAchievementSalary() {
		return achievementSalary;
	}
	
	/**
	 * 设置 绩效补贴
	 * @param achievementSalary 绩效补贴
	 * @return 当前对象
	*/
	public SalaryDetail setAchievementSalary(BigDecimal achievementSalary) {
		this.achievementSalary=achievementSalary;
		return this;
	}
	
	/**
	 * 获得 加班补贴<br>
	 * 加班补贴
	 * @return 加班补贴
	*/
	public BigDecimal getOvertimeSalary() {
		return overtimeSalary;
	}
	
	/**
	 * 设置 加班补贴
	 * @param overtimeSalary 加班补贴
	 * @return 当前对象
	*/
	public SalaryDetail setOvertimeSalary(BigDecimal overtimeSalary) {
		this.overtimeSalary=overtimeSalary;
		return this;
	}
	
	/**
	 * 获得 高温补贴<br>
	 * 高温补贴
	 * @return 高温补贴
	*/
	public BigDecimal getHighTemperatureSalary() {
		return highTemperatureSalary;
	}
	
	/**
	 * 设置 高温补贴
	 * @param highTemperatureSalary 高温补贴
	 * @return 当前对象
	*/
	public SalaryDetail setHighTemperatureSalary(BigDecimal highTemperatureSalary) {
		this.highTemperatureSalary=highTemperatureSalary;
		return this;
	}
	
	/**
	 * 获得 其他补贴<br>
	 * 其他补贴
	 * @return 其他补贴
	*/
	public BigDecimal getOtherSalary() {
		return otherSalary;
	}
	
	/**
	 * 设置 其他补贴
	 * @param otherSalary 其他补贴
	 * @return 当前对象
	*/
	public SalaryDetail setOtherSalary(BigDecimal otherSalary) {
		this.otherSalary=otherSalary;
		return this;
	}
	
	/**
	 * 获得 通讯补贴<br>
	 * 通讯补贴
	 * @return 通讯补贴
	*/
	public BigDecimal getCommunicationSalary() {
		return communicationSalary;
	}
	
	/**
	 * 设置 通讯补贴
	 * @param communicationSalary 通讯补贴
	 * @return 当前对象
	*/
	public SalaryDetail setCommunicationSalary(BigDecimal communicationSalary) {
		this.communicationSalary=communicationSalary;
		return this;
	}
	
	/**
	 * 获得 交通补贴<br>
	 * 交通补贴
	 * @return 交通补贴
	*/
	public BigDecimal getTrafficSalary() {
		return trafficSalary;
	}
	
	/**
	 * 设置 交通补贴
	 * @param trafficSalary 交通补贴
	 * @return 当前对象
	*/
	public SalaryDetail setTrafficSalary(BigDecimal trafficSalary) {
		this.trafficSalary=trafficSalary;
		return this;
	}
	
	/**
	 * 获得 住房补贴<br>
	 * 住房补贴
	 * @return 住房补贴
	*/
	public BigDecimal getHousingSalary() {
		return housingSalary;
	}
	
	/**
	 * 设置 住房补贴
	 * @param housingSalary 住房补贴
	 * @return 当前对象
	*/
	public SalaryDetail setHousingSalary(BigDecimal housingSalary) {
		this.housingSalary=housingSalary;
		return this;
	}
	
	/**
	 * 获得 提成工资<br>
	 * 提成工资
	 * @return 提成工资
	*/
	public BigDecimal getCommissionSalary() {
		return commissionSalary;
	}
	
	/**
	 * 设置 提成工资
	 * @param commissionSalary 提成工资
	 * @return 当前对象
	*/
	public SalaryDetail setCommissionSalary(BigDecimal commissionSalary) {
		this.commissionSalary=commissionSalary;
		return this;
	}
	
	/**
	 * 获得 住房公积金基数<br>
	 * 住房公积金基数
	 * @return 住房公积金基数
	*/
	public BigDecimal getWelfareZfgjjBase() {
		return welfareZfgjjBase;
	}
	
	/**
	 * 设置 住房公积金基数
	 * @param welfareZfgjjBase 住房公积金基数
	 * @return 当前对象
	*/
	public SalaryDetail setWelfareZfgjjBase(BigDecimal welfareZfgjjBase) {
		this.welfareZfgjjBase=welfareZfgjjBase;
		return this;
	}
	
	/**
	 * 获得 住房公积金个人<br>
	 * 住房公积金个人
	 * @return 住房公积金个人
	*/
	public BigDecimal getWelfareZfgjjPerson() {
		return welfareZfgjjPerson;
	}
	
	/**
	 * 设置 住房公积金个人
	 * @param welfareZfgjjPerson 住房公积金个人
	 * @return 当前对象
	*/
	public SalaryDetail setWelfareZfgjjPerson(BigDecimal welfareZfgjjPerson) {
		this.welfareZfgjjPerson=welfareZfgjjPerson;
		return this;
	}
	
	/**
	 * 获得 住房公积金公司<br>
	 * 住房公积金公司
	 * @return 住房公积金公司
	*/
	public BigDecimal getWelfareZfgjjCompany() {
		return welfareZfgjjCompany;
	}
	
	/**
	 * 设置 住房公积金公司
	 * @param welfareZfgjjCompany 住房公积金公司
	 * @return 当前对象
	*/
	public SalaryDetail setWelfareZfgjjCompany(BigDecimal welfareZfgjjCompany) {
		this.welfareZfgjjCompany=welfareZfgjjCompany;
		return this;
	}
	
	/**
	 * 获得 养老保险基数<br>
	 * 养老保险基数
	 * @return 养老保险基数
	*/
	public BigDecimal getWelfaerYlbxBase() {
		return welfaerYlbxBase;
	}
	
	/**
	 * 设置 养老保险基数
	 * @param welfaerYlbxBase 养老保险基数
	 * @return 当前对象
	*/
	public SalaryDetail setWelfaerYlbxBase(BigDecimal welfaerYlbxBase) {
		this.welfaerYlbxBase=welfaerYlbxBase;
		return this;
	}
	
	/**
	 * 获得 养老保险个人<br>
	 * 养老保险个人
	 * @return 养老保险个人
	*/
	public BigDecimal getWelfaerYlbxPerson() {
		return welfaerYlbxPerson;
	}
	
	/**
	 * 设置 养老保险个人
	 * @param welfaerYlbxPerson 养老保险个人
	 * @return 当前对象
	*/
	public SalaryDetail setWelfaerYlbxPerson(BigDecimal welfaerYlbxPerson) {
		this.welfaerYlbxPerson=welfaerYlbxPerson;
		return this;
	}
	
	/**
	 * 获得 养老保险公司<br>
	 * 养老保险公司
	 * @return 养老保险公司
	*/
	public BigDecimal getWelfaerYlbxCompany() {
		return welfaerYlbxCompany;
	}
	
	/**
	 * 设置 养老保险公司
	 * @param welfaerYlbxCompany 养老保险公司
	 * @return 当前对象
	*/
	public SalaryDetail setWelfaerYlbxCompany(BigDecimal welfaerYlbxCompany) {
		this.welfaerYlbxCompany=welfaerYlbxCompany;
		return this;
	}
	
	/**
	 * 获得 工伤保险基数<br>
	 * 工伤保险基数
	 * @return 工伤保险基数
	*/
	public BigDecimal getWelfaerGsbxBase() {
		return welfaerGsbxBase;
	}
	
	/**
	 * 设置 工伤保险基数
	 * @param welfaerGsbxBase 工伤保险基数
	 * @return 当前对象
	*/
	public SalaryDetail setWelfaerGsbxBase(BigDecimal welfaerGsbxBase) {
		this.welfaerGsbxBase=welfaerGsbxBase;
		return this;
	}
	
	/**
	 * 获得 工伤保险个人<br>
	 * 工伤保险个人
	 * @return 工伤保险个人
	*/
	public BigDecimal getWelfaerGsbxPerson() {
		return welfaerGsbxPerson;
	}
	
	/**
	 * 设置 工伤保险个人
	 * @param welfaerGsbxPerson 工伤保险个人
	 * @return 当前对象
	*/
	public SalaryDetail setWelfaerGsbxPerson(BigDecimal welfaerGsbxPerson) {
		this.welfaerGsbxPerson=welfaerGsbxPerson;
		return this;
	}
	
	/**
	 * 获得 工伤保险公司<br>
	 * 工伤保险公司
	 * @return 工伤保险公司
	*/
	public BigDecimal getWelfaerGsbxCompany() {
		return welfaerGsbxCompany;
	}
	
	/**
	 * 设置 工伤保险公司
	 * @param welfaerGsbxCompany 工伤保险公司
	 * @return 当前对象
	*/
	public SalaryDetail setWelfaerGsbxCompany(BigDecimal welfaerGsbxCompany) {
		this.welfaerGsbxCompany=welfaerGsbxCompany;
		return this;
	}
	
	/**
	 * 获得 医疗保险基数<br>
	 * 医疗保险基数
	 * @return 医疗保险基数
	*/
	public BigDecimal getWelfaerYrbxBase() {
		return welfaerYrbxBase;
	}
	
	/**
	 * 设置 医疗保险基数
	 * @param welfaerYrbxBase 医疗保险基数
	 * @return 当前对象
	*/
	public SalaryDetail setWelfaerYrbxBase(BigDecimal welfaerYrbxBase) {
		this.welfaerYrbxBase=welfaerYrbxBase;
		return this;
	}
	
	/**
	 * 获得 医疗保险个人<br>
	 * 医疗保险个人
	 * @return 医疗保险个人
	*/
	public BigDecimal getWelfaerYrbxPerson() {
		return welfaerYrbxPerson;
	}
	
	/**
	 * 设置 医疗保险个人
	 * @param welfaerYrbxPerson 医疗保险个人
	 * @return 当前对象
	*/
	public SalaryDetail setWelfaerYrbxPerson(BigDecimal welfaerYrbxPerson) {
		this.welfaerYrbxPerson=welfaerYrbxPerson;
		return this;
	}
	
	/**
	 * 获得 医疗保险公司<br>
	 * 医疗保险公司
	 * @return 医疗保险公司
	*/
	public BigDecimal getWelfaerYrbxCompany() {
		return welfaerYrbxCompany;
	}
	
	/**
	 * 设置 医疗保险公司
	 * @param welfaerYrbxCompany 医疗保险公司
	 * @return 当前对象
	*/
	public SalaryDetail setWelfaerYrbxCompany(BigDecimal welfaerYrbxCompany) {
		this.welfaerYrbxCompany=welfaerYrbxCompany;
		return this;
	}
	
	/**
	 * 获得 生育保险基数<br>
	 * 生育保险基数
	 * @return 生育保险基数
	*/
	public BigDecimal getWelfaerSybxBase() {
		return welfaerSybxBase;
	}
	
	/**
	 * 设置 生育保险基数
	 * @param welfaerSybxBase 生育保险基数
	 * @return 当前对象
	*/
	public SalaryDetail setWelfaerSybxBase(BigDecimal welfaerSybxBase) {
		this.welfaerSybxBase=welfaerSybxBase;
		return this;
	}
	
	/**
	 * 获得 生育保险个人<br>
	 * 生育保险个人
	 * @return 生育保险个人
	*/
	public BigDecimal getWelfaerSybxPerson() {
		return welfaerSybxPerson;
	}
	
	/**
	 * 设置 生育保险个人
	 * @param welfaerSybxPerson 生育保险个人
	 * @return 当前对象
	*/
	public SalaryDetail setWelfaerSybxPerson(BigDecimal welfaerSybxPerson) {
		this.welfaerSybxPerson=welfaerSybxPerson;
		return this;
	}
	
	/**
	 * 获得 生育保险公司<br>
	 * 生育保险公司
	 * @return 生育保险公司
	*/
	public BigDecimal getWelfaerSybxCompany() {
		return welfaerSybxCompany;
	}
	
	/**
	 * 设置 生育保险公司
	 * @param welfaerSybxCompany 生育保险公司
	 * @return 当前对象
	*/
	public SalaryDetail setWelfaerSybxCompany(BigDecimal welfaerSybxCompany) {
		this.welfaerSybxCompany=welfaerSybxCompany;
		return this;
	}
	
	/**
	 * 获得 扣除考勤<br>
	 * 扣除考勤
	 * @return 扣除考勤
	*/
	public BigDecimal getDeductKq() {
		return deductKq;
	}
	
	/**
	 * 设置 扣除考勤
	 * @param deductKq 扣除考勤
	 * @return 当前对象
	*/
	public SalaryDetail setDeductKq(BigDecimal deductKq) {
		this.deductKq=deductKq;
		return this;
	}
	
	/**
	 * 获得 扣除工会<br>
	 * 扣除工会
	 * @return 扣除工会
	*/
	public BigDecimal getDeductGh() {
		return deductGh;
	}
	
	/**
	 * 设置 扣除工会
	 * @param deductGh 扣除工会
	 * @return 当前对象
	*/
	public SalaryDetail setDeductGh(BigDecimal deductGh) {
		this.deductGh=deductGh;
		return this;
	}
	
	/**
	 * 获得 扣除其他<br>
	 * 扣除其他
	 * @return 扣除其他
	*/
	public BigDecimal getDeductOther() {
		return deductOther;
	}
	
	/**
	 * 设置 扣除其他
	 * @param deductOther 扣除其他
	 * @return 当前对象
	*/
	public SalaryDetail setDeductOther(BigDecimal deductOther) {
		this.deductOther=deductOther;
		return this;
	}
	
	/**
	 * 获得 子女教育<br>
	 * 子女教育
	 * @return 子女教育
	*/
	public BigDecimal getPersonalTaxZnjy() {
		return personalTaxZnjy;
	}
	
	/**
	 * 设置 子女教育
	 * @param personalTaxZnjy 子女教育
	 * @return 当前对象
	*/
	public SalaryDetail setPersonalTaxZnjy(BigDecimal personalTaxZnjy) {
		this.personalTaxZnjy=personalTaxZnjy;
		return this;
	}
	
	/**
	 * 获得 继续教育<br>
	 * 继续教育
	 * @return 继续教育
	*/
	public BigDecimal getPersonalTaxJxjy() {
		return personalTaxJxjy;
	}
	
	/**
	 * 设置 继续教育
	 * @param personalTaxJxjy 继续教育
	 * @return 当前对象
	*/
	public SalaryDetail setPersonalTaxJxjy(BigDecimal personalTaxJxjy) {
		this.personalTaxJxjy=personalTaxJxjy;
		return this;
	}
	
	/**
	 * 获得 大病医疗<br>
	 * 大病医疗
	 * @return 大病医疗
	*/
	public BigDecimal getPersonalTaxDbyl() {
		return personalTaxDbyl;
	}
	
	/**
	 * 设置 大病医疗
	 * @param personalTaxDbyl 大病医疗
	 * @return 当前对象
	*/
	public SalaryDetail setPersonalTaxDbyl(BigDecimal personalTaxDbyl) {
		this.personalTaxDbyl=personalTaxDbyl;
		return this;
	}
	
	/**
	 * 获得 住房贷款<br>
	 * 住房贷款
	 * @return 住房贷款
	*/
	public BigDecimal getPersonalTaxZfdk() {
		return personalTaxZfdk;
	}
	
	/**
	 * 设置 住房贷款
	 * @param personalTaxZfdk 住房贷款
	 * @return 当前对象
	*/
	public SalaryDetail setPersonalTaxZfdk(BigDecimal personalTaxZfdk) {
		this.personalTaxZfdk=personalTaxZfdk;
		return this;
	}
	
	/**
	 * 获得 住房租金<br>
	 * 住房租金
	 * @return 住房租金
	*/
	public BigDecimal getPersonalTaxZfzj() {
		return personalTaxZfzj;
	}
	
	/**
	 * 设置 住房租金
	 * @param personalTaxZfzj 住房租金
	 * @return 当前对象
	*/
	public SalaryDetail setPersonalTaxZfzj(BigDecimal personalTaxZfzj) {
		this.personalTaxZfzj=personalTaxZfzj;
		return this;
	}
	
	/**
	 * 获得 赡养老人<br>
	 * 赡养老人
	 * @return 赡养老人
	*/
	public BigDecimal getPersonalTaxSylr() {
		return personalTaxSylr;
	}
	
	/**
	 * 设置 赡养老人
	 * @param personalTaxSylr 赡养老人
	 * @return 当前对象
	*/
	public SalaryDetail setPersonalTaxSylr(BigDecimal personalTaxSylr) {
		this.personalTaxSylr=personalTaxSylr;
		return this;
	}
	
	/**
	 * 获得 幼儿照护<br>
	 * 幼儿照护
	 * @return 幼儿照护
	*/
	public BigDecimal getPersonalTaxErzh() {
		return personalTaxErzh;
	}
	
	/**
	 * 设置 幼儿照护
	 * @param personalTaxErzh 幼儿照护
	 * @return 当前对象
	*/
	public SalaryDetail setPersonalTaxErzh(BigDecimal personalTaxErzh) {
		this.personalTaxErzh=personalTaxErzh;
		return this;
	}
	
	/**
	 * 获得 月份<br>
	 * 月份
	 * @return 月份
	*/
	public String getActionMonth() {
		return actionMonth;
	}
	
	/**
	 * 设置 月份
	 * @param actionMonth 月份
	 * @return 当前对象
	*/
	public SalaryDetail setActionMonth(String actionMonth) {
		this.actionMonth=actionMonth;
		return this;
	}
	
	/**
	 * 获得 个人所得税<br>
	 * 个人所得税
	 * @return 个人所得税
	*/
	public BigDecimal getIndividualTax() {
		return individualTax;
	}
	
	/**
	 * 设置 个人所得税
	 * @param individualTax 个人所得税
	 * @return 当前对象
	*/
	public SalaryDetail setIndividualTax(BigDecimal individualTax) {
		this.individualTax=individualTax;
		return this;
	}
	
	/**
	 * 获得 合计金额<br>
	 * 合计金额
	 * @return 合计金额
	*/
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	
	/**
	 * 设置 合计金额
	 * @param totalAmount 合计金额
	 * @return 当前对象
	*/
	public SalaryDetail setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount=totalAmount;
		return this;
	}
	
	/**
	 * 获得 应发金额<br>
	 * 应发金额
	 * @return 应发金额
	*/
	public BigDecimal getPayAmount() {
		return payAmount;
	}
	
	/**
	 * 设置 应发金额
	 * @param payAmount 应发金额
	 * @return 当前对象
	*/
	public SalaryDetail setPayAmount(BigDecimal payAmount) {
		this.payAmount=payAmount;
		return this;
	}
	
	/**
	 * 获得 实发金额<br>
	 * 实发金额
	 * @return 实发金额
	*/
	public BigDecimal getIssuedAmount() {
		return issuedAmount;
	}
	
	/**
	 * 设置 实发金额
	 * @param issuedAmount 实发金额
	 * @return 当前对象
	*/
	public SalaryDetail setIssuedAmount(BigDecimal issuedAmount) {
		this.issuedAmount=issuedAmount;
		return this;
	}
	
	/**
	 * 获得 抵扣基数<br>
	 * 抵扣基数
	 * @return 抵扣基数
	*/
	public BigDecimal getPtDkjs() {
		return ptDkjs;
	}
	
	/**
	 * 设置 抵扣基数
	 * @param ptDkjs 抵扣基数
	 * @return 当前对象
	*/
	public SalaryDetail setPtDkjs(BigDecimal ptDkjs) {
		this.ptDkjs=ptDkjs;
		return this;
	}
	
	/**
	 * 获得 税率<br>
	 * 税率
	 * @return 税率
	*/
	public BigDecimal getPtSlPct() {
		return ptSlPct;
	}
	
	/**
	 * 设置 税率
	 * @param ptSlPct 税率
	 * @return 当前对象
	*/
	public SalaryDetail setPtSlPct(BigDecimal ptSlPct) {
		this.ptSlPct=ptSlPct;
		return this;
	}
	
	/**
	 * 获得 个人所得税<br>
	 * 个人所得税
	 * @return 个人所得税
	*/
	public BigDecimal getPtGrsds() {
		return ptGrsds;
	}
	
	/**
	 * 设置 个人所得税
	 * @param ptGrsds 个人所得税
	 * @return 当前对象
	*/
	public SalaryDetail setPtGrsds(BigDecimal ptGrsds) {
		this.ptGrsds=ptGrsds;
		return this;
	}
	
	/**
	 * 获得 姓名<br>
	 * 姓名
	 * @return 姓名
	*/
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 设置 姓名
	 * @param userName 姓名
	 * @return 当前对象
	*/
	public SalaryDetail setUserName(String userName) {
		this.userName=userName;
		return this;
	}
	
	/**
	 * 获得 生效时间<br>
	 * 生效时间
	 * @return 生效时间
	*/
	public Date getEffectTime() {
		return effectTime;
	}
	
	/**
	 * 设置 生效时间
	 * @param effectTime 生效时间
	 * @return 当前对象
	*/
	public SalaryDetail setEffectTime(Date effectTime) {
		this.effectTime=effectTime;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public SalaryDetail setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public SalaryDetail setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public SalaryDetail setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public SalaryDetail setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public SalaryDetail setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	@JsonProperty("deleted")
	public SalaryDetail setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public SalaryDetail setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public SalaryDetail setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public SalaryDetail setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public SalaryDetail setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 租户<br>
	 * 租户
	 * @return 租户
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户
	 * @param tenantId 租户
	 * @return 当前对象
	*/
	public SalaryDetail setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SalaryDetail , 转换好的 SalaryDetail 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SalaryDetail , 转换好的 PoJo 对象
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
	public SalaryDetail clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SalaryDetail duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.SalaryDetailMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.SalaryDetailMeta.$$proxy$$();
		inst.setHighTemperatureSalary(this.getHighTemperatureSalary());
		inst.setNotes(this.getNotes());
		inst.setWelfareZfgjjBase(this.getWelfareZfgjjBase());
		inst.setDeductKq(this.getDeductKq());
		inst.setWelfareZfgjjPerson(this.getWelfareZfgjjPerson());
		inst.setDeductGh(this.getDeductGh());
		inst.setActionMonth(this.getActionMonth());
		inst.setWelfaerYlbxCompany(this.getWelfaerYlbxCompany());
		inst.setPersonalTaxErzh(this.getPersonalTaxErzh());
		inst.setPersonalTaxJxjy(this.getPersonalTaxJxjy());
		inst.setPayAmount(this.getPayAmount());
		inst.setCommunicationSalary(this.getCommunicationSalary());
		inst.setPtDkjs(this.getPtDkjs());
		inst.setPtGrsds(this.getPtGrsds());
		inst.setFixedSalary(this.getFixedSalary());
		inst.setId(this.getId());
		inst.setTrafficSalary(this.getTrafficSalary());
		inst.setWelfaerYrbxCompany(this.getWelfaerYrbxCompany());
		inst.setIssuedAmount(this.getIssuedAmount());
		inst.setWelfaerSybxBase(this.getWelfaerSybxBase());
		inst.setWelfaerGsbxBase(this.getWelfaerGsbxBase());
		inst.setWelfaerSybxCompany(this.getWelfaerSybxCompany());
		inst.setWelfaerYrbxBase(this.getWelfaerYrbxBase());
		inst.setVersion(this.getVersion());
		inst.setTotalAmount(this.getTotalAmount());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setEffectTime(this.getEffectTime());
		inst.setOtherSalary(this.getOtherSalary());
		inst.setCommissionSalary(this.getCommissionSalary());
		inst.setStatus(this.getStatus());
		inst.setPersonalTaxZfdk(this.getPersonalTaxZfdk());
		inst.setWelfaerSybxPerson(this.getWelfaerSybxPerson());
		inst.setWelfaerYlbxBase(this.getWelfaerYlbxBase());
		inst.setBaseSalary(this.getBaseSalary());
		inst.setPersonalTaxSylr(this.getPersonalTaxSylr());
		inst.setPersonalTaxZnjy(this.getPersonalTaxZnjy());
		inst.setPtSlPct(this.getPtSlPct());
		inst.setWelfaerGsbxPerson(this.getWelfaerGsbxPerson());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setWelfaerYlbxPerson(this.getWelfaerYlbxPerson());
		inst.setWelfareZfgjjCompany(this.getWelfareZfgjjCompany());
		inst.setWelfaerGsbxCompany(this.getWelfaerGsbxCompany());
		inst.setIndividualTax(this.getIndividualTax());
		inst.setHousingSalary(this.getHousingSalary());
		inst.setWelfaerYrbxPerson(this.getWelfaerYrbxPerson());
		inst.setPersonalTaxZfzj(this.getPersonalTaxZfzj());
		inst.setWorkingYearsSalary(this.getWorkingYearsSalary());
		inst.setAchievementSalary(this.getAchievementSalary());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setPersonalTaxDbyl(this.getPersonalTaxDbyl());
		inst.setUserName(this.getUserName());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeductOther(this.getDeductOther());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setTenantId(this.getTenantId());
		inst.setPostSalary(this.getPostSalary());
		inst.setOvertimeSalary(this.getOvertimeSalary());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SalaryDetail clone(boolean deep) {
		return EntityContext.clone(SalaryDetail.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SalaryDetail
	 * @param salaryDetailMap 包含实体信息的 Map 对象
	 * @return SalaryDetail , 转换好的的 SalaryDetail 对象
	*/
	@Transient
	public static SalaryDetail createFrom(Map<String,Object> salaryDetailMap) {
		if(salaryDetailMap==null) return null;
		SalaryDetail po = create();
		EntityContext.copyProperties(po,salaryDetailMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 SalaryDetail
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SalaryDetail , 转换好的的 SalaryDetail 对象
	*/
	@Transient
	public static SalaryDetail createFrom(Object pojo) {
		if(pojo==null) return null;
		SalaryDetail po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 SalaryDetail，等同于 new
	 * @return SalaryDetail 对象
	*/
	@Transient
	public static SalaryDetail create() {
		return new com.dt.platform.domain.hr.meta.SalaryDetailMeta.$$proxy$$();
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
			this.setHighTemperatureSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.HIGH_TEMPERATURE_SALARY)));
			this.setNotes(DataParser.parse(String.class, map.get(SalaryDetailMeta.NOTES)));
			this.setWelfareZfgjjBase(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.WELFARE_ZFGJJ_BASE)));
			this.setDeductKq(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.DEDUCT_KQ)));
			this.setWelfareZfgjjPerson(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.WELFARE_ZFGJJ_PERSON)));
			this.setDeductGh(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.DEDUCT_GH)));
			this.setActionMonth(DataParser.parse(String.class, map.get(SalaryDetailMeta.ACTION_MONTH)));
			this.setWelfaerYlbxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.WELFAER_YLBX_COMPANY)));
			this.setPersonalTaxErzh(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.PERSONAL_TAX_ERZH)));
			this.setPersonalTaxJxjy(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.PERSONAL_TAX_JXJY)));
			this.setPayAmount(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.PAY_AMOUNT)));
			this.setCommunicationSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.COMMUNICATION_SALARY)));
			this.setPtDkjs(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.PT_DKJS)));
			this.setPtGrsds(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.PT_GRSDS)));
			this.setFixedSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.FIXED_SALARY)));
			this.setId(DataParser.parse(String.class, map.get(SalaryDetailMeta.ID)));
			this.setTrafficSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.TRAFFIC_SALARY)));
			this.setWelfaerYrbxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.WELFAER_YRBX_COMPANY)));
			this.setIssuedAmount(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.ISSUED_AMOUNT)));
			this.setWelfaerSybxBase(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.WELFAER_SYBX_BASE)));
			this.setWelfaerGsbxBase(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.WELFAER_GSBX_BASE)));
			this.setWelfaerSybxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.WELFAER_SYBX_COMPANY)));
			this.setWelfaerYrbxBase(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.WELFAER_YRBX_BASE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SalaryDetailMeta.VERSION)));
			this.setTotalAmount(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.TOTAL_AMOUNT)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SalaryDetailMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SalaryDetailMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(SalaryDetailMeta.PERSON_ID)));
			this.setEffectTime(DataParser.parse(Date.class, map.get(SalaryDetailMeta.EFFECT_TIME)));
			this.setOtherSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.OTHER_SALARY)));
			this.setCommissionSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.COMMISSION_SALARY)));
			this.setStatus(DataParser.parse(String.class, map.get(SalaryDetailMeta.STATUS)));
			this.setPersonalTaxZfdk(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.PERSONAL_TAX_ZFDK)));
			this.setWelfaerSybxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.WELFAER_SYBX_PERSON)));
			this.setWelfaerYlbxBase(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.WELFAER_YLBX_BASE)));
			this.setBaseSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.BASE_SALARY)));
			this.setPersonalTaxSylr(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.PERSONAL_TAX_SYLR)));
			this.setPersonalTaxZnjy(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.PERSONAL_TAX_ZNJY)));
			this.setPtSlPct(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.PT_SL_PCT)));
			this.setWelfaerGsbxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.WELFAER_GSBX_PERSON)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SalaryDetailMeta.UPDATE_BY)));
			this.setWelfaerYlbxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.WELFAER_YLBX_PERSON)));
			this.setWelfareZfgjjCompany(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.WELFARE_ZFGJJ_COMPANY)));
			this.setWelfaerGsbxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.WELFAER_GSBX_COMPANY)));
			this.setIndividualTax(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.INDIVIDUAL_TAX)));
			this.setHousingSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.HOUSING_SALARY)));
			this.setWelfaerYrbxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.WELFAER_YRBX_PERSON)));
			this.setPersonalTaxZfzj(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.PERSONAL_TAX_ZFZJ)));
			this.setWorkingYearsSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.WORKING_YEARS_SALARY)));
			this.setAchievementSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.ACHIEVEMENT_SALARY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SalaryDetailMeta.UPDATE_TIME)));
			this.setPersonalTaxDbyl(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.PERSONAL_TAX_DBYL)));
			this.setUserName(DataParser.parse(String.class, map.get(SalaryDetailMeta.USER_NAME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SalaryDetailMeta.CREATE_BY)));
			this.setDeductOther(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.DEDUCT_OTHER)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SalaryDetailMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SalaryDetailMeta.CREATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(SalaryDetailMeta.TENANT_ID)));
			this.setPostSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.POST_SALARY)));
			this.setOvertimeSalary(DataParser.parse(BigDecimal.class, map.get(SalaryDetailMeta.OVERTIME_SALARY)));
			// others
			return true;
		} else {
			try {
				this.setHighTemperatureSalary( (BigDecimal)map.get(SalaryDetailMeta.HIGH_TEMPERATURE_SALARY));
				this.setNotes( (String)map.get(SalaryDetailMeta.NOTES));
				this.setWelfareZfgjjBase( (BigDecimal)map.get(SalaryDetailMeta.WELFARE_ZFGJJ_BASE));
				this.setDeductKq( (BigDecimal)map.get(SalaryDetailMeta.DEDUCT_KQ));
				this.setWelfareZfgjjPerson( (BigDecimal)map.get(SalaryDetailMeta.WELFARE_ZFGJJ_PERSON));
				this.setDeductGh( (BigDecimal)map.get(SalaryDetailMeta.DEDUCT_GH));
				this.setActionMonth( (String)map.get(SalaryDetailMeta.ACTION_MONTH));
				this.setWelfaerYlbxCompany( (BigDecimal)map.get(SalaryDetailMeta.WELFAER_YLBX_COMPANY));
				this.setPersonalTaxErzh( (BigDecimal)map.get(SalaryDetailMeta.PERSONAL_TAX_ERZH));
				this.setPersonalTaxJxjy( (BigDecimal)map.get(SalaryDetailMeta.PERSONAL_TAX_JXJY));
				this.setPayAmount( (BigDecimal)map.get(SalaryDetailMeta.PAY_AMOUNT));
				this.setCommunicationSalary( (BigDecimal)map.get(SalaryDetailMeta.COMMUNICATION_SALARY));
				this.setPtDkjs( (BigDecimal)map.get(SalaryDetailMeta.PT_DKJS));
				this.setPtGrsds( (BigDecimal)map.get(SalaryDetailMeta.PT_GRSDS));
				this.setFixedSalary( (BigDecimal)map.get(SalaryDetailMeta.FIXED_SALARY));
				this.setId( (String)map.get(SalaryDetailMeta.ID));
				this.setTrafficSalary( (BigDecimal)map.get(SalaryDetailMeta.TRAFFIC_SALARY));
				this.setWelfaerYrbxCompany( (BigDecimal)map.get(SalaryDetailMeta.WELFAER_YRBX_COMPANY));
				this.setIssuedAmount( (BigDecimal)map.get(SalaryDetailMeta.ISSUED_AMOUNT));
				this.setWelfaerSybxBase( (BigDecimal)map.get(SalaryDetailMeta.WELFAER_SYBX_BASE));
				this.setWelfaerGsbxBase( (BigDecimal)map.get(SalaryDetailMeta.WELFAER_GSBX_BASE));
				this.setWelfaerSybxCompany( (BigDecimal)map.get(SalaryDetailMeta.WELFAER_SYBX_COMPANY));
				this.setWelfaerYrbxBase( (BigDecimal)map.get(SalaryDetailMeta.WELFAER_YRBX_BASE));
				this.setVersion( (Integer)map.get(SalaryDetailMeta.VERSION));
				this.setTotalAmount( (BigDecimal)map.get(SalaryDetailMeta.TOTAL_AMOUNT));
				this.setDeleteTime( (Date)map.get(SalaryDetailMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(SalaryDetailMeta.DELETE_BY));
				this.setPersonId( (String)map.get(SalaryDetailMeta.PERSON_ID));
				this.setEffectTime( (Date)map.get(SalaryDetailMeta.EFFECT_TIME));
				this.setOtherSalary( (BigDecimal)map.get(SalaryDetailMeta.OTHER_SALARY));
				this.setCommissionSalary( (BigDecimal)map.get(SalaryDetailMeta.COMMISSION_SALARY));
				this.setStatus( (String)map.get(SalaryDetailMeta.STATUS));
				this.setPersonalTaxZfdk( (BigDecimal)map.get(SalaryDetailMeta.PERSONAL_TAX_ZFDK));
				this.setWelfaerSybxPerson( (BigDecimal)map.get(SalaryDetailMeta.WELFAER_SYBX_PERSON));
				this.setWelfaerYlbxBase( (BigDecimal)map.get(SalaryDetailMeta.WELFAER_YLBX_BASE));
				this.setBaseSalary( (BigDecimal)map.get(SalaryDetailMeta.BASE_SALARY));
				this.setPersonalTaxSylr( (BigDecimal)map.get(SalaryDetailMeta.PERSONAL_TAX_SYLR));
				this.setPersonalTaxZnjy( (BigDecimal)map.get(SalaryDetailMeta.PERSONAL_TAX_ZNJY));
				this.setPtSlPct( (BigDecimal)map.get(SalaryDetailMeta.PT_SL_PCT));
				this.setWelfaerGsbxPerson( (BigDecimal)map.get(SalaryDetailMeta.WELFAER_GSBX_PERSON));
				this.setUpdateBy( (String)map.get(SalaryDetailMeta.UPDATE_BY));
				this.setWelfaerYlbxPerson( (BigDecimal)map.get(SalaryDetailMeta.WELFAER_YLBX_PERSON));
				this.setWelfareZfgjjCompany( (BigDecimal)map.get(SalaryDetailMeta.WELFARE_ZFGJJ_COMPANY));
				this.setWelfaerGsbxCompany( (BigDecimal)map.get(SalaryDetailMeta.WELFAER_GSBX_COMPANY));
				this.setIndividualTax( (BigDecimal)map.get(SalaryDetailMeta.INDIVIDUAL_TAX));
				this.setHousingSalary( (BigDecimal)map.get(SalaryDetailMeta.HOUSING_SALARY));
				this.setWelfaerYrbxPerson( (BigDecimal)map.get(SalaryDetailMeta.WELFAER_YRBX_PERSON));
				this.setPersonalTaxZfzj( (BigDecimal)map.get(SalaryDetailMeta.PERSONAL_TAX_ZFZJ));
				this.setWorkingYearsSalary( (BigDecimal)map.get(SalaryDetailMeta.WORKING_YEARS_SALARY));
				this.setAchievementSalary( (BigDecimal)map.get(SalaryDetailMeta.ACHIEVEMENT_SALARY));
				this.setUpdateTime( (Date)map.get(SalaryDetailMeta.UPDATE_TIME));
				this.setPersonalTaxDbyl( (BigDecimal)map.get(SalaryDetailMeta.PERSONAL_TAX_DBYL));
				this.setUserName( (String)map.get(SalaryDetailMeta.USER_NAME));
				this.setCreateBy( (String)map.get(SalaryDetailMeta.CREATE_BY));
				this.setDeductOther( (BigDecimal)map.get(SalaryDetailMeta.DEDUCT_OTHER));
				this.setDeleted( (Integer)map.get(SalaryDetailMeta.DELETED));
				this.setCreateTime( (Date)map.get(SalaryDetailMeta.CREATE_TIME));
				this.setTenantId( (String)map.get(SalaryDetailMeta.TENANT_ID));
				this.setPostSalary( (BigDecimal)map.get(SalaryDetailMeta.POST_SALARY));
				this.setOvertimeSalary( (BigDecimal)map.get(SalaryDetailMeta.OVERTIME_SALARY));
				// others
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
			this.setHighTemperatureSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.HIGH_TEMPERATURE_SALARY)));
			this.setNotes(DataParser.parse(String.class, r.getValue(SalaryDetailMeta.NOTES)));
			this.setWelfareZfgjjBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.WELFARE_ZFGJJ_BASE)));
			this.setDeductKq(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.DEDUCT_KQ)));
			this.setWelfareZfgjjPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.WELFARE_ZFGJJ_PERSON)));
			this.setDeductGh(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.DEDUCT_GH)));
			this.setActionMonth(DataParser.parse(String.class, r.getValue(SalaryDetailMeta.ACTION_MONTH)));
			this.setWelfaerYlbxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.WELFAER_YLBX_COMPANY)));
			this.setPersonalTaxErzh(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.PERSONAL_TAX_ERZH)));
			this.setPersonalTaxJxjy(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.PERSONAL_TAX_JXJY)));
			this.setPayAmount(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.PAY_AMOUNT)));
			this.setCommunicationSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.COMMUNICATION_SALARY)));
			this.setPtDkjs(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.PT_DKJS)));
			this.setPtGrsds(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.PT_GRSDS)));
			this.setFixedSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.FIXED_SALARY)));
			this.setId(DataParser.parse(String.class, r.getValue(SalaryDetailMeta.ID)));
			this.setTrafficSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.TRAFFIC_SALARY)));
			this.setWelfaerYrbxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.WELFAER_YRBX_COMPANY)));
			this.setIssuedAmount(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.ISSUED_AMOUNT)));
			this.setWelfaerSybxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.WELFAER_SYBX_BASE)));
			this.setWelfaerGsbxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.WELFAER_GSBX_BASE)));
			this.setWelfaerSybxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.WELFAER_SYBX_COMPANY)));
			this.setWelfaerYrbxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.WELFAER_YRBX_BASE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SalaryDetailMeta.VERSION)));
			this.setTotalAmount(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.TOTAL_AMOUNT)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SalaryDetailMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SalaryDetailMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(SalaryDetailMeta.PERSON_ID)));
			this.setEffectTime(DataParser.parse(Date.class, r.getValue(SalaryDetailMeta.EFFECT_TIME)));
			this.setOtherSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.OTHER_SALARY)));
			this.setCommissionSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.COMMISSION_SALARY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(SalaryDetailMeta.STATUS)));
			this.setPersonalTaxZfdk(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.PERSONAL_TAX_ZFDK)));
			this.setWelfaerSybxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.WELFAER_SYBX_PERSON)));
			this.setWelfaerYlbxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.WELFAER_YLBX_BASE)));
			this.setBaseSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.BASE_SALARY)));
			this.setPersonalTaxSylr(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.PERSONAL_TAX_SYLR)));
			this.setPersonalTaxZnjy(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.PERSONAL_TAX_ZNJY)));
			this.setPtSlPct(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.PT_SL_PCT)));
			this.setWelfaerGsbxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.WELFAER_GSBX_PERSON)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SalaryDetailMeta.UPDATE_BY)));
			this.setWelfaerYlbxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.WELFAER_YLBX_PERSON)));
			this.setWelfareZfgjjCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.WELFARE_ZFGJJ_COMPANY)));
			this.setWelfaerGsbxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.WELFAER_GSBX_COMPANY)));
			this.setIndividualTax(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.INDIVIDUAL_TAX)));
			this.setHousingSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.HOUSING_SALARY)));
			this.setWelfaerYrbxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.WELFAER_YRBX_PERSON)));
			this.setPersonalTaxZfzj(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.PERSONAL_TAX_ZFZJ)));
			this.setWorkingYearsSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.WORKING_YEARS_SALARY)));
			this.setAchievementSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.ACHIEVEMENT_SALARY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SalaryDetailMeta.UPDATE_TIME)));
			this.setPersonalTaxDbyl(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.PERSONAL_TAX_DBYL)));
			this.setUserName(DataParser.parse(String.class, r.getValue(SalaryDetailMeta.USER_NAME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SalaryDetailMeta.CREATE_BY)));
			this.setDeductOther(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.DEDUCT_OTHER)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SalaryDetailMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SalaryDetailMeta.CREATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SalaryDetailMeta.TENANT_ID)));
			this.setPostSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.POST_SALARY)));
			this.setOvertimeSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryDetailMeta.OVERTIME_SALARY)));
			return true;
		} else {
			try {
				this.setHighTemperatureSalary( (BigDecimal)r.getValue(SalaryDetailMeta.HIGH_TEMPERATURE_SALARY));
				this.setNotes( (String)r.getValue(SalaryDetailMeta.NOTES));
				this.setWelfareZfgjjBase( (BigDecimal)r.getValue(SalaryDetailMeta.WELFARE_ZFGJJ_BASE));
				this.setDeductKq( (BigDecimal)r.getValue(SalaryDetailMeta.DEDUCT_KQ));
				this.setWelfareZfgjjPerson( (BigDecimal)r.getValue(SalaryDetailMeta.WELFARE_ZFGJJ_PERSON));
				this.setDeductGh( (BigDecimal)r.getValue(SalaryDetailMeta.DEDUCT_GH));
				this.setActionMonth( (String)r.getValue(SalaryDetailMeta.ACTION_MONTH));
				this.setWelfaerYlbxCompany( (BigDecimal)r.getValue(SalaryDetailMeta.WELFAER_YLBX_COMPANY));
				this.setPersonalTaxErzh( (BigDecimal)r.getValue(SalaryDetailMeta.PERSONAL_TAX_ERZH));
				this.setPersonalTaxJxjy( (BigDecimal)r.getValue(SalaryDetailMeta.PERSONAL_TAX_JXJY));
				this.setPayAmount( (BigDecimal)r.getValue(SalaryDetailMeta.PAY_AMOUNT));
				this.setCommunicationSalary( (BigDecimal)r.getValue(SalaryDetailMeta.COMMUNICATION_SALARY));
				this.setPtDkjs( (BigDecimal)r.getValue(SalaryDetailMeta.PT_DKJS));
				this.setPtGrsds( (BigDecimal)r.getValue(SalaryDetailMeta.PT_GRSDS));
				this.setFixedSalary( (BigDecimal)r.getValue(SalaryDetailMeta.FIXED_SALARY));
				this.setId( (String)r.getValue(SalaryDetailMeta.ID));
				this.setTrafficSalary( (BigDecimal)r.getValue(SalaryDetailMeta.TRAFFIC_SALARY));
				this.setWelfaerYrbxCompany( (BigDecimal)r.getValue(SalaryDetailMeta.WELFAER_YRBX_COMPANY));
				this.setIssuedAmount( (BigDecimal)r.getValue(SalaryDetailMeta.ISSUED_AMOUNT));
				this.setWelfaerSybxBase( (BigDecimal)r.getValue(SalaryDetailMeta.WELFAER_SYBX_BASE));
				this.setWelfaerGsbxBase( (BigDecimal)r.getValue(SalaryDetailMeta.WELFAER_GSBX_BASE));
				this.setWelfaerSybxCompany( (BigDecimal)r.getValue(SalaryDetailMeta.WELFAER_SYBX_COMPANY));
				this.setWelfaerYrbxBase( (BigDecimal)r.getValue(SalaryDetailMeta.WELFAER_YRBX_BASE));
				this.setVersion( (Integer)r.getValue(SalaryDetailMeta.VERSION));
				this.setTotalAmount( (BigDecimal)r.getValue(SalaryDetailMeta.TOTAL_AMOUNT));
				this.setDeleteTime( (Date)r.getValue(SalaryDetailMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(SalaryDetailMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(SalaryDetailMeta.PERSON_ID));
				this.setEffectTime( (Date)r.getValue(SalaryDetailMeta.EFFECT_TIME));
				this.setOtherSalary( (BigDecimal)r.getValue(SalaryDetailMeta.OTHER_SALARY));
				this.setCommissionSalary( (BigDecimal)r.getValue(SalaryDetailMeta.COMMISSION_SALARY));
				this.setStatus( (String)r.getValue(SalaryDetailMeta.STATUS));
				this.setPersonalTaxZfdk( (BigDecimal)r.getValue(SalaryDetailMeta.PERSONAL_TAX_ZFDK));
				this.setWelfaerSybxPerson( (BigDecimal)r.getValue(SalaryDetailMeta.WELFAER_SYBX_PERSON));
				this.setWelfaerYlbxBase( (BigDecimal)r.getValue(SalaryDetailMeta.WELFAER_YLBX_BASE));
				this.setBaseSalary( (BigDecimal)r.getValue(SalaryDetailMeta.BASE_SALARY));
				this.setPersonalTaxSylr( (BigDecimal)r.getValue(SalaryDetailMeta.PERSONAL_TAX_SYLR));
				this.setPersonalTaxZnjy( (BigDecimal)r.getValue(SalaryDetailMeta.PERSONAL_TAX_ZNJY));
				this.setPtSlPct( (BigDecimal)r.getValue(SalaryDetailMeta.PT_SL_PCT));
				this.setWelfaerGsbxPerson( (BigDecimal)r.getValue(SalaryDetailMeta.WELFAER_GSBX_PERSON));
				this.setUpdateBy( (String)r.getValue(SalaryDetailMeta.UPDATE_BY));
				this.setWelfaerYlbxPerson( (BigDecimal)r.getValue(SalaryDetailMeta.WELFAER_YLBX_PERSON));
				this.setWelfareZfgjjCompany( (BigDecimal)r.getValue(SalaryDetailMeta.WELFARE_ZFGJJ_COMPANY));
				this.setWelfaerGsbxCompany( (BigDecimal)r.getValue(SalaryDetailMeta.WELFAER_GSBX_COMPANY));
				this.setIndividualTax( (BigDecimal)r.getValue(SalaryDetailMeta.INDIVIDUAL_TAX));
				this.setHousingSalary( (BigDecimal)r.getValue(SalaryDetailMeta.HOUSING_SALARY));
				this.setWelfaerYrbxPerson( (BigDecimal)r.getValue(SalaryDetailMeta.WELFAER_YRBX_PERSON));
				this.setPersonalTaxZfzj( (BigDecimal)r.getValue(SalaryDetailMeta.PERSONAL_TAX_ZFZJ));
				this.setWorkingYearsSalary( (BigDecimal)r.getValue(SalaryDetailMeta.WORKING_YEARS_SALARY));
				this.setAchievementSalary( (BigDecimal)r.getValue(SalaryDetailMeta.ACHIEVEMENT_SALARY));
				this.setUpdateTime( (Date)r.getValue(SalaryDetailMeta.UPDATE_TIME));
				this.setPersonalTaxDbyl( (BigDecimal)r.getValue(SalaryDetailMeta.PERSONAL_TAX_DBYL));
				this.setUserName( (String)r.getValue(SalaryDetailMeta.USER_NAME));
				this.setCreateBy( (String)r.getValue(SalaryDetailMeta.CREATE_BY));
				this.setDeductOther( (BigDecimal)r.getValue(SalaryDetailMeta.DEDUCT_OTHER));
				this.setDeleted( (Integer)r.getValue(SalaryDetailMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(SalaryDetailMeta.CREATE_TIME));
				this.setTenantId( (String)r.getValue(SalaryDetailMeta.TENANT_ID));
				this.setPostSalary( (BigDecimal)r.getValue(SalaryDetailMeta.POST_SALARY));
				this.setOvertimeSalary( (BigDecimal)r.getValue(SalaryDetailMeta.OVERTIME_SALARY));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}