package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_SALARY;
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
import com.dt.platform.domain.hr.meta.SalaryMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 人员薪酬
 * <p>人员薪酬 , 数据表 hr_salary 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-05 10:21:24
 * @sign 89F9A56F2E376CF28C30FC861D442E55
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_salary")
@ApiModel(description = "人员薪酬 ; 人员薪酬 , 数据表 hr_salary 的PO类型")
public class Salary extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_SALARY.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "717749920269860864")
	private String id;
	
	/**
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员" , example = "717723409223516161")
	private String personId;
	
	/**
	 * 基本工资：基本工资
	*/
	@ApiModelProperty(required = false,value="基本工资" , notes = "基本工资" , example = "5000.00")
	private BigDecimal baseSalary;
	
	/**
	 * 岗位工资：岗位工资
	*/
	@ApiModelProperty(required = false,value="岗位工资" , notes = "岗位工资" , example = "0.00")
	private BigDecimal postSalary;
	
	/**
	 * 工龄工资：工龄工资
	*/
	@ApiModelProperty(required = false,value="工龄工资" , notes = "工龄工资" , example = "0.00")
	private BigDecimal workingYearsSalary;
	
	/**
	 * 固定补贴：固定补贴
	*/
	@ApiModelProperty(required = false,value="固定补贴" , notes = "固定补贴" , example = "0.00")
	private BigDecimal fixedSalary;
	
	/**
	 * 绩效补贴：绩效补贴
	*/
	@ApiModelProperty(required = false,value="绩效补贴" , notes = "绩效补贴" , example = "0.00")
	private BigDecimal achievementSalary;
	
	/**
	 * 加班补贴：加班补贴
	*/
	@ApiModelProperty(required = false,value="加班补贴" , notes = "加班补贴" , example = "0.00")
	private BigDecimal overtimeSalary;
	
	/**
	 * 其他补贴：其他补贴
	*/
	@ApiModelProperty(required = false,value="其他补贴" , notes = "其他补贴" , example = "0.00")
	private BigDecimal otherSalary;
	
	/**
	 * 通讯补贴：通讯补贴
	*/
	@ApiModelProperty(required = false,value="通讯补贴" , notes = "通讯补贴" , example = "0.00")
	private BigDecimal communicationSalary;
	
	/**
	 * 交通补贴：交通补贴
	*/
	@ApiModelProperty(required = false,value="交通补贴" , notes = "交通补贴" , example = "0.00")
	private BigDecimal trafficSalary;
	
	/**
	 * 住房补贴：住房补贴
	*/
	@ApiModelProperty(required = false,value="住房补贴" , notes = "住房补贴" , example = "0.00")
	private BigDecimal housingSalary;
	
	/**
	 * 提成工资：提成工资
	*/
	@ApiModelProperty(required = false,value="提成工资" , notes = "提成工资" , example = "0.00")
	private BigDecimal commissionSalary;
	
	/**
	 * 高温补贴：高温补贴
	*/
	@ApiModelProperty(required = false,value="高温补贴" , notes = "高温补贴" , example = "0.00")
	private BigDecimal highTemperatureSalary;
	
	/**
	 * 住房公积金基数：住房公积金基数
	*/
	@ApiModelProperty(required = false,value="住房公积金基数" , notes = "住房公积金基数" , example = "15320.00")
	private BigDecimal welfareZfgjjBase;
	
	/**
	 * 住房公积金个人：住房公积金个人
	*/
	@ApiModelProperty(required = false,value="住房公积金个人" , notes = "住房公积金个人" , example = "0.00")
	private BigDecimal welfareZfgjjPerson;
	
	/**
	 * 住房公积金公司：住房公积金公司
	*/
	@ApiModelProperty(required = false,value="住房公积金公司" , notes = "住房公积金公司" , example = "0.00")
	private BigDecimal welfareZfgjjCompany;
	
	/**
	 * 养老保险基数：养老保险基数
	*/
	@ApiModelProperty(required = false,value="养老保险基数" , notes = "养老保险基数" , example = "15320.00")
	private BigDecimal welfaerYlbxBase;
	
	/**
	 * 养老保险个人：养老保险个人
	*/
	@ApiModelProperty(required = false,value="养老保险个人" , notes = "养老保险个人" , example = "0.00")
	private BigDecimal welfaerYlbxPerson;
	
	/**
	 * 养老保险公司：养老保险公司
	*/
	@ApiModelProperty(required = false,value="养老保险公司" , notes = "养老保险公司" , example = "0.00")
	private BigDecimal welfaerYlbxCompany;
	
	/**
	 * 工伤保险基数：工伤保险基数
	*/
	@ApiModelProperty(required = false,value="工伤保险基数" , notes = "工伤保险基数" , example = "15320.00")
	private BigDecimal welfaerGsbxBase;
	
	/**
	 * 工伤保险个人：工伤保险个人
	*/
	@ApiModelProperty(required = false,value="工伤保险个人" , notes = "工伤保险个人" , example = "0.00")
	private BigDecimal welfaerGsbxPerson;
	
	/**
	 * 工伤保险公司：工伤保险公司
	*/
	@ApiModelProperty(required = false,value="工伤保险公司" , notes = "工伤保险公司" , example = "0.00")
	private BigDecimal welfaerGsbxCompany;
	
	/**
	 * 医疗保险基数：医疗保险基数
	*/
	@ApiModelProperty(required = false,value="医疗保险基数" , notes = "医疗保险基数" , example = "15320.00")
	private BigDecimal welfaerYrbxBase;
	
	/**
	 * 医疗保险个人：医疗保险个人
	*/
	@ApiModelProperty(required = false,value="医疗保险个人" , notes = "医疗保险个人" , example = "0.00")
	private BigDecimal welfaerYrbxPerson;
	
	/**
	 * 医疗保险公司：医疗保险公司
	*/
	@ApiModelProperty(required = false,value="医疗保险公司" , notes = "医疗保险公司" , example = "0.00")
	private BigDecimal welfaerYrbxCompany;
	
	/**
	 * 生育保险基数：生育保险基数
	*/
	@ApiModelProperty(required = false,value="生育保险基数" , notes = "生育保险基数" , example = "15320.00")
	private BigDecimal welfaerSybxBase;
	
	/**
	 * 生育保险个人：生育保险个人
	*/
	@ApiModelProperty(required = false,value="生育保险个人" , notes = "生育保险个人" , example = "0.00")
	private BigDecimal welfaerSybxPerson;
	
	/**
	 * 生育保险公司：生育保险公司
	*/
	@ApiModelProperty(required = false,value="生育保险公司" , notes = "生育保险公司" , example = "0.00")
	private BigDecimal welfaerSybxCompany;
	
	/**
	 * 失业保险基数：失业保险基数
	*/
	@ApiModelProperty(required = false,value="失业保险基数" , notes = "失业保险基数" , example = "15320.00")
	private BigDecimal welfaerSyebxBase;
	
	/**
	 * 失业保险个人：失业保险个人
	*/
	@ApiModelProperty(required = false,value="失业保险个人" , notes = "失业保险个人" , example = "0.00")
	private BigDecimal welfaerSyebxPerson;
	
	/**
	 * 失业保险公司：失业保险公司
	*/
	@ApiModelProperty(required = false,value="失业保险公司" , notes = "失业保险公司" , example = "0.00")
	private BigDecimal welfaerSyebxCompany;
	
	/**
	 * 个税抵扣：个税抵扣
	*/
	@ApiModelProperty(required = false,value="个税抵扣" , notes = "个税抵扣" , example = "0.00")
	private BigDecimal deductPersonalTaxRed;
	
	/**
	 * 扣除考勤：扣除考勤
	*/
	@ApiModelProperty(required = false,value="扣除考勤" , notes = "扣除考勤" , example = "0.00")
	private BigDecimal deductKq;
	
	/**
	 * 扣除工会：扣除工会
	*/
	@ApiModelProperty(required = false,value="扣除工会" , notes = "扣除工会" , example = "0.00")
	private BigDecimal deductGh;
	
	/**
	 * 扣除其他：扣除其他
	*/
	@ApiModelProperty(required = false,value="扣除其他" , notes = "扣除其他" , example = "0.00")
	private BigDecimal duductOther;
	
	/**
	 * 子女教育：子女教育
	*/
	@ApiModelProperty(required = false,value="子女教育" , notes = "子女教育" , example = "0.00")
	private BigDecimal personalTaxZnjy;
	
	/**
	 * 继续教育：继续教育
	*/
	@ApiModelProperty(required = false,value="继续教育" , notes = "继续教育" , example = "0.00")
	private BigDecimal personalTaxJxjy;
	
	/**
	 * 大病医疗：大病医疗
	*/
	@ApiModelProperty(required = false,value="大病医疗" , notes = "大病医疗" , example = "2000.00")
	private BigDecimal personalTaxDbyl;
	
	/**
	 * 住房贷款：住房贷款
	*/
	@ApiModelProperty(required = false,value="住房贷款" , notes = "住房贷款" , example = "0.00")
	private BigDecimal personalTaxZfdk;
	
	/**
	 * 住房租金：住房租金
	*/
	@ApiModelProperty(required = false,value="住房租金" , notes = "住房租金" , example = "0.00")
	private BigDecimal personalTaxZfzj;
	
	/**
	 * 赡养老人：赡养老人
	*/
	@ApiModelProperty(required = false,value="赡养老人" , notes = "赡养老人" , example = "0.00")
	private BigDecimal personalTaxSylr;
	
	/**
	 * 幼儿照护：幼儿照护
	*/
	@ApiModelProperty(required = false,value="幼儿照护" , notes = "幼儿照护" , example = "0.00")
	private BigDecimal personalTaxErzh;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-06-04 02:41:56")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-06-04 03:33:18")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "4")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * person：person
	*/
	@ApiModelProperty(required = false,value="person" , notes = "person")
	private Person person;
	
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
	public Salary setId(String id) {
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
	public Salary setPersonId(String personId) {
		this.personId=personId;
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
	public Salary setBaseSalary(BigDecimal baseSalary) {
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
	public Salary setPostSalary(BigDecimal postSalary) {
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
	public Salary setWorkingYearsSalary(BigDecimal workingYearsSalary) {
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
	public Salary setFixedSalary(BigDecimal fixedSalary) {
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
	public Salary setAchievementSalary(BigDecimal achievementSalary) {
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
	public Salary setOvertimeSalary(BigDecimal overtimeSalary) {
		this.overtimeSalary=overtimeSalary;
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
	public Salary setOtherSalary(BigDecimal otherSalary) {
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
	public Salary setCommunicationSalary(BigDecimal communicationSalary) {
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
	public Salary setTrafficSalary(BigDecimal trafficSalary) {
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
	public Salary setHousingSalary(BigDecimal housingSalary) {
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
	public Salary setCommissionSalary(BigDecimal commissionSalary) {
		this.commissionSalary=commissionSalary;
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
	public Salary setHighTemperatureSalary(BigDecimal highTemperatureSalary) {
		this.highTemperatureSalary=highTemperatureSalary;
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
	public Salary setWelfareZfgjjBase(BigDecimal welfareZfgjjBase) {
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
	public Salary setWelfareZfgjjPerson(BigDecimal welfareZfgjjPerson) {
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
	public Salary setWelfareZfgjjCompany(BigDecimal welfareZfgjjCompany) {
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
	public Salary setWelfaerYlbxBase(BigDecimal welfaerYlbxBase) {
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
	public Salary setWelfaerYlbxPerson(BigDecimal welfaerYlbxPerson) {
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
	public Salary setWelfaerYlbxCompany(BigDecimal welfaerYlbxCompany) {
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
	public Salary setWelfaerGsbxBase(BigDecimal welfaerGsbxBase) {
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
	public Salary setWelfaerGsbxPerson(BigDecimal welfaerGsbxPerson) {
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
	public Salary setWelfaerGsbxCompany(BigDecimal welfaerGsbxCompany) {
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
	public Salary setWelfaerYrbxBase(BigDecimal welfaerYrbxBase) {
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
	public Salary setWelfaerYrbxPerson(BigDecimal welfaerYrbxPerson) {
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
	public Salary setWelfaerYrbxCompany(BigDecimal welfaerYrbxCompany) {
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
	public Salary setWelfaerSybxBase(BigDecimal welfaerSybxBase) {
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
	public Salary setWelfaerSybxPerson(BigDecimal welfaerSybxPerson) {
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
	public Salary setWelfaerSybxCompany(BigDecimal welfaerSybxCompany) {
		this.welfaerSybxCompany=welfaerSybxCompany;
		return this;
	}
	
	/**
	 * 获得 失业保险基数<br>
	 * 失业保险基数
	 * @return 失业保险基数
	*/
	public BigDecimal getWelfaerSyebxBase() {
		return welfaerSyebxBase;
	}
	
	/**
	 * 设置 失业保险基数
	 * @param welfaerSyebxBase 失业保险基数
	 * @return 当前对象
	*/
	public Salary setWelfaerSyebxBase(BigDecimal welfaerSyebxBase) {
		this.welfaerSyebxBase=welfaerSyebxBase;
		return this;
	}
	
	/**
	 * 获得 失业保险个人<br>
	 * 失业保险个人
	 * @return 失业保险个人
	*/
	public BigDecimal getWelfaerSyebxPerson() {
		return welfaerSyebxPerson;
	}
	
	/**
	 * 设置 失业保险个人
	 * @param welfaerSyebxPerson 失业保险个人
	 * @return 当前对象
	*/
	public Salary setWelfaerSyebxPerson(BigDecimal welfaerSyebxPerson) {
		this.welfaerSyebxPerson=welfaerSyebxPerson;
		return this;
	}
	
	/**
	 * 获得 失业保险公司<br>
	 * 失业保险公司
	 * @return 失业保险公司
	*/
	public BigDecimal getWelfaerSyebxCompany() {
		return welfaerSyebxCompany;
	}
	
	/**
	 * 设置 失业保险公司
	 * @param welfaerSyebxCompany 失业保险公司
	 * @return 当前对象
	*/
	public Salary setWelfaerSyebxCompany(BigDecimal welfaerSyebxCompany) {
		this.welfaerSyebxCompany=welfaerSyebxCompany;
		return this;
	}
	
	/**
	 * 获得 个税抵扣<br>
	 * 个税抵扣
	 * @return 个税抵扣
	*/
	public BigDecimal getDeductPersonalTaxRed() {
		return deductPersonalTaxRed;
	}
	
	/**
	 * 设置 个税抵扣
	 * @param deductPersonalTaxRed 个税抵扣
	 * @return 当前对象
	*/
	public Salary setDeductPersonalTaxRed(BigDecimal deductPersonalTaxRed) {
		this.deductPersonalTaxRed=deductPersonalTaxRed;
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
	public Salary setDeductKq(BigDecimal deductKq) {
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
	public Salary setDeductGh(BigDecimal deductGh) {
		this.deductGh=deductGh;
		return this;
	}
	
	/**
	 * 获得 扣除其他<br>
	 * 扣除其他
	 * @return 扣除其他
	*/
	public BigDecimal getDuductOther() {
		return duductOther;
	}
	
	/**
	 * 设置 扣除其他
	 * @param duductOther 扣除其他
	 * @return 当前对象
	*/
	public Salary setDuductOther(BigDecimal duductOther) {
		this.duductOther=duductOther;
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
	public Salary setPersonalTaxZnjy(BigDecimal personalTaxZnjy) {
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
	public Salary setPersonalTaxJxjy(BigDecimal personalTaxJxjy) {
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
	public Salary setPersonalTaxDbyl(BigDecimal personalTaxDbyl) {
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
	public Salary setPersonalTaxZfdk(BigDecimal personalTaxZfdk) {
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
	public Salary setPersonalTaxZfzj(BigDecimal personalTaxZfzj) {
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
	public Salary setPersonalTaxSylr(BigDecimal personalTaxSylr) {
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
	public Salary setPersonalTaxErzh(BigDecimal personalTaxErzh) {
		this.personalTaxErzh=personalTaxErzh;
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
	public Salary setCreateBy(String createBy) {
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
	public Salary setCreateTime(Date createTime) {
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
	public Salary setUpdateBy(String updateBy) {
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
	public Salary setUpdateTime(Date updateTime) {
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
	public Salary setDeleted(Integer deleted) {
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
	public Salary setDeleted(Boolean deletedBool) {
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
	public Salary setDeleteBy(String deleteBy) {
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
	public Salary setDeleteTime(Date deleteTime) {
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
	public Salary setVersion(Integer version) {
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
	public Salary setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 person<br>
	 * person
	 * @return person
	*/
	public Person getPerson() {
		return person;
	}
	
	/**
	 * 设置 person
	 * @param person person
	 * @return 当前对象
	*/
	public Salary setPerson(Person person) {
		this.person=person;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Salary , 转换好的 Salary 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Salary , 转换好的 PoJo 对象
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
	public Salary clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Salary duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.SalaryMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.SalaryMeta.$$proxy$$();
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
			inst.setPerson(this.getPerson());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Salary clone(boolean deep) {
		return EntityContext.clone(Salary.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Salary
	 * @param salaryMap 包含实体信息的 Map 对象
	 * @return Salary , 转换好的的 Salary 对象
	*/
	@Transient
	public static Salary createFrom(Map<String,Object> salaryMap) {
		if(salaryMap==null) return null;
		Salary po = create();
		EntityContext.copyProperties(po,salaryMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Salary
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Salary , 转换好的的 Salary 对象
	*/
	@Transient
	public static Salary createFrom(Object pojo) {
		if(pojo==null) return null;
		Salary po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Salary，等同于 new
	 * @return Salary 对象
	*/
	@Transient
	public static Salary create() {
		return new com.dt.platform.domain.hr.meta.SalaryMeta.$$proxy$$();
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
			this.setHighTemperatureSalary(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.HIGH_TEMPERATURE_SALARY)));
			this.setWelfareZfgjjBase(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WELFARE_ZFGJJ_BASE)));
			this.setDeductKq(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.DEDUCT_KQ)));
			this.setWelfareZfgjjPerson(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WELFARE_ZFGJJ_PERSON)));
			this.setDeductGh(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.DEDUCT_GH)));
			this.setWelfaerYlbxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WELFAER_YLBX_COMPANY)));
			this.setPersonalTaxErzh(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.PERSONAL_TAX_ERZH)));
			this.setPersonalTaxJxjy(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.PERSONAL_TAX_JXJY)));
			this.setCommunicationSalary(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.COMMUNICATION_SALARY)));
			this.setFixedSalary(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.FIXED_SALARY)));
			this.setId(DataParser.parse(String.class, map.get(SalaryMeta.ID)));
			this.setTrafficSalary(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.TRAFFIC_SALARY)));
			this.setWelfaerYrbxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WELFAER_YRBX_COMPANY)));
			this.setWelfaerSybxBase(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WELFAER_SYBX_BASE)));
			this.setWelfaerGsbxBase(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WELFAER_GSBX_BASE)));
			this.setWelfaerSybxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WELFAER_SYBX_COMPANY)));
			this.setWelfaerYrbxBase(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WELFAER_YRBX_BASE)));
			this.setWelfaerSyebxBase(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WELFAER_SYEBX_BASE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SalaryMeta.VERSION)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SalaryMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SalaryMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(SalaryMeta.PERSON_ID)));
			this.setOtherSalary(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.OTHER_SALARY)));
			this.setDeductPersonalTaxRed(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.DEDUCT_PERSONAL_TAX_RED)));
			this.setCommissionSalary(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.COMMISSION_SALARY)));
			this.setPersonalTaxZfdk(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.PERSONAL_TAX_ZFDK)));
			this.setWelfaerSyebxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WELFAER_SYEBX_PERSON)));
			this.setWelfaerSybxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WELFAER_SYBX_PERSON)));
			this.setWelfaerYlbxBase(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WELFAER_YLBX_BASE)));
			this.setBaseSalary(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.BASE_SALARY)));
			this.setPersonalTaxSylr(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.PERSONAL_TAX_SYLR)));
			this.setPersonalTaxZnjy(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.PERSONAL_TAX_ZNJY)));
			this.setWelfaerGsbxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WELFAER_GSBX_PERSON)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SalaryMeta.UPDATE_BY)));
			this.setWelfaerYlbxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WELFAER_YLBX_PERSON)));
			this.setWelfareZfgjjCompany(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WELFARE_ZFGJJ_COMPANY)));
			this.setWelfaerGsbxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WELFAER_GSBX_COMPANY)));
			this.setWelfaerSyebxCompany(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WELFAER_SYEBX_COMPANY)));
			this.setHousingSalary(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.HOUSING_SALARY)));
			this.setWelfaerYrbxPerson(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WELFAER_YRBX_PERSON)));
			this.setPersonalTaxZfzj(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.PERSONAL_TAX_ZFZJ)));
			this.setWorkingYearsSalary(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.WORKING_YEARS_SALARY)));
			this.setAchievementSalary(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.ACHIEVEMENT_SALARY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SalaryMeta.UPDATE_TIME)));
			this.setDuductOther(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.DUDUCT_OTHER)));
			this.setPersonalTaxDbyl(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.PERSONAL_TAX_DBYL)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SalaryMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SalaryMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SalaryMeta.CREATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(SalaryMeta.TENANT_ID)));
			this.setPostSalary(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.POST_SALARY)));
			this.setOvertimeSalary(DataParser.parse(BigDecimal.class, map.get(SalaryMeta.OVERTIME_SALARY)));
			// others
			this.setPerson(DataParser.parse(Person.class, map.get(SalaryMeta.PERSON)));
			return true;
		} else {
			try {
				this.setHighTemperatureSalary( (BigDecimal)map.get(SalaryMeta.HIGH_TEMPERATURE_SALARY));
				this.setWelfareZfgjjBase( (BigDecimal)map.get(SalaryMeta.WELFARE_ZFGJJ_BASE));
				this.setDeductKq( (BigDecimal)map.get(SalaryMeta.DEDUCT_KQ));
				this.setWelfareZfgjjPerson( (BigDecimal)map.get(SalaryMeta.WELFARE_ZFGJJ_PERSON));
				this.setDeductGh( (BigDecimal)map.get(SalaryMeta.DEDUCT_GH));
				this.setWelfaerYlbxCompany( (BigDecimal)map.get(SalaryMeta.WELFAER_YLBX_COMPANY));
				this.setPersonalTaxErzh( (BigDecimal)map.get(SalaryMeta.PERSONAL_TAX_ERZH));
				this.setPersonalTaxJxjy( (BigDecimal)map.get(SalaryMeta.PERSONAL_TAX_JXJY));
				this.setCommunicationSalary( (BigDecimal)map.get(SalaryMeta.COMMUNICATION_SALARY));
				this.setFixedSalary( (BigDecimal)map.get(SalaryMeta.FIXED_SALARY));
				this.setId( (String)map.get(SalaryMeta.ID));
				this.setTrafficSalary( (BigDecimal)map.get(SalaryMeta.TRAFFIC_SALARY));
				this.setWelfaerYrbxCompany( (BigDecimal)map.get(SalaryMeta.WELFAER_YRBX_COMPANY));
				this.setWelfaerSybxBase( (BigDecimal)map.get(SalaryMeta.WELFAER_SYBX_BASE));
				this.setWelfaerGsbxBase( (BigDecimal)map.get(SalaryMeta.WELFAER_GSBX_BASE));
				this.setWelfaerSybxCompany( (BigDecimal)map.get(SalaryMeta.WELFAER_SYBX_COMPANY));
				this.setWelfaerYrbxBase( (BigDecimal)map.get(SalaryMeta.WELFAER_YRBX_BASE));
				this.setWelfaerSyebxBase( (BigDecimal)map.get(SalaryMeta.WELFAER_SYEBX_BASE));
				this.setVersion( (Integer)map.get(SalaryMeta.VERSION));
				this.setDeleteTime( (Date)map.get(SalaryMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(SalaryMeta.DELETE_BY));
				this.setPersonId( (String)map.get(SalaryMeta.PERSON_ID));
				this.setOtherSalary( (BigDecimal)map.get(SalaryMeta.OTHER_SALARY));
				this.setDeductPersonalTaxRed( (BigDecimal)map.get(SalaryMeta.DEDUCT_PERSONAL_TAX_RED));
				this.setCommissionSalary( (BigDecimal)map.get(SalaryMeta.COMMISSION_SALARY));
				this.setPersonalTaxZfdk( (BigDecimal)map.get(SalaryMeta.PERSONAL_TAX_ZFDK));
				this.setWelfaerSyebxPerson( (BigDecimal)map.get(SalaryMeta.WELFAER_SYEBX_PERSON));
				this.setWelfaerSybxPerson( (BigDecimal)map.get(SalaryMeta.WELFAER_SYBX_PERSON));
				this.setWelfaerYlbxBase( (BigDecimal)map.get(SalaryMeta.WELFAER_YLBX_BASE));
				this.setBaseSalary( (BigDecimal)map.get(SalaryMeta.BASE_SALARY));
				this.setPersonalTaxSylr( (BigDecimal)map.get(SalaryMeta.PERSONAL_TAX_SYLR));
				this.setPersonalTaxZnjy( (BigDecimal)map.get(SalaryMeta.PERSONAL_TAX_ZNJY));
				this.setWelfaerGsbxPerson( (BigDecimal)map.get(SalaryMeta.WELFAER_GSBX_PERSON));
				this.setUpdateBy( (String)map.get(SalaryMeta.UPDATE_BY));
				this.setWelfaerYlbxPerson( (BigDecimal)map.get(SalaryMeta.WELFAER_YLBX_PERSON));
				this.setWelfareZfgjjCompany( (BigDecimal)map.get(SalaryMeta.WELFARE_ZFGJJ_COMPANY));
				this.setWelfaerGsbxCompany( (BigDecimal)map.get(SalaryMeta.WELFAER_GSBX_COMPANY));
				this.setWelfaerSyebxCompany( (BigDecimal)map.get(SalaryMeta.WELFAER_SYEBX_COMPANY));
				this.setHousingSalary( (BigDecimal)map.get(SalaryMeta.HOUSING_SALARY));
				this.setWelfaerYrbxPerson( (BigDecimal)map.get(SalaryMeta.WELFAER_YRBX_PERSON));
				this.setPersonalTaxZfzj( (BigDecimal)map.get(SalaryMeta.PERSONAL_TAX_ZFZJ));
				this.setWorkingYearsSalary( (BigDecimal)map.get(SalaryMeta.WORKING_YEARS_SALARY));
				this.setAchievementSalary( (BigDecimal)map.get(SalaryMeta.ACHIEVEMENT_SALARY));
				this.setUpdateTime( (Date)map.get(SalaryMeta.UPDATE_TIME));
				this.setDuductOther( (BigDecimal)map.get(SalaryMeta.DUDUCT_OTHER));
				this.setPersonalTaxDbyl( (BigDecimal)map.get(SalaryMeta.PERSONAL_TAX_DBYL));
				this.setCreateBy( (String)map.get(SalaryMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(SalaryMeta.DELETED));
				this.setCreateTime( (Date)map.get(SalaryMeta.CREATE_TIME));
				this.setTenantId( (String)map.get(SalaryMeta.TENANT_ID));
				this.setPostSalary( (BigDecimal)map.get(SalaryMeta.POST_SALARY));
				this.setOvertimeSalary( (BigDecimal)map.get(SalaryMeta.OVERTIME_SALARY));
				// others
				this.setPerson( (Person)map.get(SalaryMeta.PERSON));
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
			this.setHighTemperatureSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.HIGH_TEMPERATURE_SALARY)));
			this.setWelfareZfgjjBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WELFARE_ZFGJJ_BASE)));
			this.setDeductKq(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.DEDUCT_KQ)));
			this.setWelfareZfgjjPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WELFARE_ZFGJJ_PERSON)));
			this.setDeductGh(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.DEDUCT_GH)));
			this.setWelfaerYlbxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WELFAER_YLBX_COMPANY)));
			this.setPersonalTaxErzh(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.PERSONAL_TAX_ERZH)));
			this.setPersonalTaxJxjy(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.PERSONAL_TAX_JXJY)));
			this.setCommunicationSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.COMMUNICATION_SALARY)));
			this.setFixedSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.FIXED_SALARY)));
			this.setId(DataParser.parse(String.class, r.getValue(SalaryMeta.ID)));
			this.setTrafficSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.TRAFFIC_SALARY)));
			this.setWelfaerYrbxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WELFAER_YRBX_COMPANY)));
			this.setWelfaerSybxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WELFAER_SYBX_BASE)));
			this.setWelfaerGsbxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WELFAER_GSBX_BASE)));
			this.setWelfaerSybxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WELFAER_SYBX_COMPANY)));
			this.setWelfaerYrbxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WELFAER_YRBX_BASE)));
			this.setWelfaerSyebxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WELFAER_SYEBX_BASE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SalaryMeta.VERSION)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SalaryMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SalaryMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(SalaryMeta.PERSON_ID)));
			this.setOtherSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.OTHER_SALARY)));
			this.setDeductPersonalTaxRed(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.DEDUCT_PERSONAL_TAX_RED)));
			this.setCommissionSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.COMMISSION_SALARY)));
			this.setPersonalTaxZfdk(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.PERSONAL_TAX_ZFDK)));
			this.setWelfaerSyebxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WELFAER_SYEBX_PERSON)));
			this.setWelfaerSybxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WELFAER_SYBX_PERSON)));
			this.setWelfaerYlbxBase(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WELFAER_YLBX_BASE)));
			this.setBaseSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.BASE_SALARY)));
			this.setPersonalTaxSylr(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.PERSONAL_TAX_SYLR)));
			this.setPersonalTaxZnjy(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.PERSONAL_TAX_ZNJY)));
			this.setWelfaerGsbxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WELFAER_GSBX_PERSON)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SalaryMeta.UPDATE_BY)));
			this.setWelfaerYlbxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WELFAER_YLBX_PERSON)));
			this.setWelfareZfgjjCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WELFARE_ZFGJJ_COMPANY)));
			this.setWelfaerGsbxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WELFAER_GSBX_COMPANY)));
			this.setWelfaerSyebxCompany(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WELFAER_SYEBX_COMPANY)));
			this.setHousingSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.HOUSING_SALARY)));
			this.setWelfaerYrbxPerson(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WELFAER_YRBX_PERSON)));
			this.setPersonalTaxZfzj(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.PERSONAL_TAX_ZFZJ)));
			this.setWorkingYearsSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.WORKING_YEARS_SALARY)));
			this.setAchievementSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.ACHIEVEMENT_SALARY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SalaryMeta.UPDATE_TIME)));
			this.setDuductOther(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.DUDUCT_OTHER)));
			this.setPersonalTaxDbyl(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.PERSONAL_TAX_DBYL)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SalaryMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SalaryMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SalaryMeta.CREATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SalaryMeta.TENANT_ID)));
			this.setPostSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.POST_SALARY)));
			this.setOvertimeSalary(DataParser.parse(BigDecimal.class, r.getValue(SalaryMeta.OVERTIME_SALARY)));
			return true;
		} else {
			try {
				this.setHighTemperatureSalary( (BigDecimal)r.getValue(SalaryMeta.HIGH_TEMPERATURE_SALARY));
				this.setWelfareZfgjjBase( (BigDecimal)r.getValue(SalaryMeta.WELFARE_ZFGJJ_BASE));
				this.setDeductKq( (BigDecimal)r.getValue(SalaryMeta.DEDUCT_KQ));
				this.setWelfareZfgjjPerson( (BigDecimal)r.getValue(SalaryMeta.WELFARE_ZFGJJ_PERSON));
				this.setDeductGh( (BigDecimal)r.getValue(SalaryMeta.DEDUCT_GH));
				this.setWelfaerYlbxCompany( (BigDecimal)r.getValue(SalaryMeta.WELFAER_YLBX_COMPANY));
				this.setPersonalTaxErzh( (BigDecimal)r.getValue(SalaryMeta.PERSONAL_TAX_ERZH));
				this.setPersonalTaxJxjy( (BigDecimal)r.getValue(SalaryMeta.PERSONAL_TAX_JXJY));
				this.setCommunicationSalary( (BigDecimal)r.getValue(SalaryMeta.COMMUNICATION_SALARY));
				this.setFixedSalary( (BigDecimal)r.getValue(SalaryMeta.FIXED_SALARY));
				this.setId( (String)r.getValue(SalaryMeta.ID));
				this.setTrafficSalary( (BigDecimal)r.getValue(SalaryMeta.TRAFFIC_SALARY));
				this.setWelfaerYrbxCompany( (BigDecimal)r.getValue(SalaryMeta.WELFAER_YRBX_COMPANY));
				this.setWelfaerSybxBase( (BigDecimal)r.getValue(SalaryMeta.WELFAER_SYBX_BASE));
				this.setWelfaerGsbxBase( (BigDecimal)r.getValue(SalaryMeta.WELFAER_GSBX_BASE));
				this.setWelfaerSybxCompany( (BigDecimal)r.getValue(SalaryMeta.WELFAER_SYBX_COMPANY));
				this.setWelfaerYrbxBase( (BigDecimal)r.getValue(SalaryMeta.WELFAER_YRBX_BASE));
				this.setWelfaerSyebxBase( (BigDecimal)r.getValue(SalaryMeta.WELFAER_SYEBX_BASE));
				this.setVersion( (Integer)r.getValue(SalaryMeta.VERSION));
				this.setDeleteTime( (Date)r.getValue(SalaryMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(SalaryMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(SalaryMeta.PERSON_ID));
				this.setOtherSalary( (BigDecimal)r.getValue(SalaryMeta.OTHER_SALARY));
				this.setDeductPersonalTaxRed( (BigDecimal)r.getValue(SalaryMeta.DEDUCT_PERSONAL_TAX_RED));
				this.setCommissionSalary( (BigDecimal)r.getValue(SalaryMeta.COMMISSION_SALARY));
				this.setPersonalTaxZfdk( (BigDecimal)r.getValue(SalaryMeta.PERSONAL_TAX_ZFDK));
				this.setWelfaerSyebxPerson( (BigDecimal)r.getValue(SalaryMeta.WELFAER_SYEBX_PERSON));
				this.setWelfaerSybxPerson( (BigDecimal)r.getValue(SalaryMeta.WELFAER_SYBX_PERSON));
				this.setWelfaerYlbxBase( (BigDecimal)r.getValue(SalaryMeta.WELFAER_YLBX_BASE));
				this.setBaseSalary( (BigDecimal)r.getValue(SalaryMeta.BASE_SALARY));
				this.setPersonalTaxSylr( (BigDecimal)r.getValue(SalaryMeta.PERSONAL_TAX_SYLR));
				this.setPersonalTaxZnjy( (BigDecimal)r.getValue(SalaryMeta.PERSONAL_TAX_ZNJY));
				this.setWelfaerGsbxPerson( (BigDecimal)r.getValue(SalaryMeta.WELFAER_GSBX_PERSON));
				this.setUpdateBy( (String)r.getValue(SalaryMeta.UPDATE_BY));
				this.setWelfaerYlbxPerson( (BigDecimal)r.getValue(SalaryMeta.WELFAER_YLBX_PERSON));
				this.setWelfareZfgjjCompany( (BigDecimal)r.getValue(SalaryMeta.WELFARE_ZFGJJ_COMPANY));
				this.setWelfaerGsbxCompany( (BigDecimal)r.getValue(SalaryMeta.WELFAER_GSBX_COMPANY));
				this.setWelfaerSyebxCompany( (BigDecimal)r.getValue(SalaryMeta.WELFAER_SYEBX_COMPANY));
				this.setHousingSalary( (BigDecimal)r.getValue(SalaryMeta.HOUSING_SALARY));
				this.setWelfaerYrbxPerson( (BigDecimal)r.getValue(SalaryMeta.WELFAER_YRBX_PERSON));
				this.setPersonalTaxZfzj( (BigDecimal)r.getValue(SalaryMeta.PERSONAL_TAX_ZFZJ));
				this.setWorkingYearsSalary( (BigDecimal)r.getValue(SalaryMeta.WORKING_YEARS_SALARY));
				this.setAchievementSalary( (BigDecimal)r.getValue(SalaryMeta.ACHIEVEMENT_SALARY));
				this.setUpdateTime( (Date)r.getValue(SalaryMeta.UPDATE_TIME));
				this.setDuductOther( (BigDecimal)r.getValue(SalaryMeta.DUDUCT_OTHER));
				this.setPersonalTaxDbyl( (BigDecimal)r.getValue(SalaryMeta.PERSONAL_TAX_DBYL));
				this.setCreateBy( (String)r.getValue(SalaryMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(SalaryMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(SalaryMeta.CREATE_TIME));
				this.setTenantId( (String)r.getValue(SalaryMeta.TENANT_ID));
				this.setPostSalary( (BigDecimal)r.getValue(SalaryMeta.POST_SALARY));
				this.setOvertimeSalary( (BigDecimal)r.getValue(SalaryMeta.OVERTIME_SALARY));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}