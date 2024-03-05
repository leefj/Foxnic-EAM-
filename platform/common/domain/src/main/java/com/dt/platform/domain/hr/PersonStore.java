package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_STORE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.PersonStoreMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 人员信息
 * <p>人员信息 , 数据表 hr_person_store 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-20 12:35:32
 * @sign 5480AD2FC58276D6DA91387A81ED2998
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_store")
@ApiModel(description = "人员信息 ; 人员信息 , 数据表 hr_person_store 的PO类型")
public class PersonStore extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_STORE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "812049443456024576")
	private String id;
	
	/**
	 * 姓名：姓名
	*/
	@ApiModelProperty(required = false,value="姓名" , notes = "姓名" , example = "12")
	private String name;
	
	/**
	 * 性别：性别
	*/
	@ApiModelProperty(required = false,value="性别" , notes = "性别" , example = "M")
	private String sexCode;
	
	/**
	 * 出生日期：出生日期
	*/
	@ApiModelProperty(required = false,value="出生日期" , notes = "出生日期")
	private Date birthday;
	
	/**
	 * 籍贯：籍贯
	*/
	@ApiModelProperty(required = false,value="籍贯" , notes = "籍贯" , example = "12")
	private String nativePlaceCode;
	
	/**
	 * 民族：民族
	*/
	@ApiModelProperty(required = false,value="民族" , notes = "民族" , example = "12")
	private String nationCode;
	
	/**
	 * 婚姻状况：婚姻状况
	*/
	@ApiModelProperty(required = false,value="婚姻状况" , notes = "婚姻状况")
	private String maritalStatus;
	
	/**
	 * 身份证：身份证
	*/
	@ApiModelProperty(required = false,value="身份证" , notes = "身份证" , example = "12")
	private String identityCard;
	
	/**
	 * 联系方式：联系方式
	*/
	@ApiModelProperty(required = false,value="联系方式" , notes = "联系方式" , example = "12")
	private String contactInformation;
	
	/**
	 * 电子邮件：电子邮件
	*/
	@ApiModelProperty(required = false,value="电子邮件" , notes = "电子邮件" , example = "12")
	private String email;
	
	/**
	 * 学历：学历
	*/
	@ApiModelProperty(required = false,value="学历" , notes = "学历" , example = "junior_college")
	private String educationCode;
	
	/**
	 * 毕业院校：毕业院校
	*/
	@ApiModelProperty(required = false,value="毕业院校" , notes = "毕业院校" , example = "12")
	private String graduationSchool;
	
	/**
	 * 所学专业：所学专业
	*/
	@ApiModelProperty(required = false,value="所学专业" , notes = "所学专业" , example = "12")
	private String major;
	
	/**
	 * 毕业时间：毕业时间
	*/
	@ApiModelProperty(required = false,value="毕业时间" , notes = "毕业时间" , example = "2024-02-16 12:00:00")
	private Date graduationDate;
	
	/**
	 * 所学外语：所学外语
	*/
	@ApiModelProperty(required = false,value="所学外语" , notes = "所学外语" , example = "12")
	private String foreignLanguage;
	
	/**
	 * 外语证书：外语证书
	*/
	@ApiModelProperty(required = false,value="外语证书" , notes = "外语证书" , example = "12")
	private String foreignLanguageLevel;
	
	/**
	 * 所获证书：所获证书
	*/
	@ApiModelProperty(required = false,value="所获证书" , notes = "所获证书")
	private String certificate;
	
	/**
	 * 计算机能力：计算机能力
	*/
	@ApiModelProperty(required = false,value="计算机能力" , notes = "计算机能力" , example = "12")
	private String computerAbility;
	
	/**
	 * 政治面貌：政治面貌
	*/
	@ApiModelProperty(required = false,value="政治面貌" , notes = "政治面貌")
	private String politicCountenanceCode;
	
	/**
	 * 入党时间：入党时间
	*/
	@ApiModelProperty(required = false,value="入党时间" , notes = "入党时间" , example = "2024-02-23 12:00:00")
	private Date joinPartDate;
	
	/**
	 * 参加工作时间：参加工作时间
	*/
	@ApiModelProperty(required = false,value="参加工作时间" , notes = "参加工作时间")
	private Date firstWorkDate;
	
	/**
	 * 特长：特长
	*/
	@ApiModelProperty(required = false,value="特长" , notes = "特长" , example = "12")
	private String specialSkill;
	
	/**
	 * 对工作要求：对工作要求
	*/
	@ApiModelProperty(required = false,value="对工作要求" , notes = "对工作要求" , example = "12")
	private String jobRequirement;
	
	/**
	 * 目前月薪：目前月薪
	*/
	@ApiModelProperty(required = false,value="目前月薪" , notes = "目前月薪" , example = "12.00")
	private BigDecimal nowSalary;
	
	/**
	 * 期望月薪：期望月薪
	*/
	@ApiModelProperty(required = false,value="期望月薪" , notes = "期望月薪" , example = "12.00")
	private BigDecimal forSalary;
	
	/**
	 * 招聘来源：招聘来源
	*/
	@ApiModelProperty(required = false,value="招聘来源" , notes = "招聘来源" , example = "12")
	private String source;
	
	/**
	 * 评审结果：评审结果
	*/
	@ApiModelProperty(required = false,value="评审结果" , notes = "评审结果" , example = "12")
	private String reviewResult;
	
	/**
	 * 应聘岗位：应聘岗位
	*/
	@ApiModelProperty(required = false,value="应聘岗位" , notes = "应聘岗位")
	private String position;
	
	/**
	 * 照片：照片
	*/
	@ApiModelProperty(required = false,value="照片" , notes = "照片")
	private String pictureId;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String fileId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String note;
	
	/**
	 * 归属：归属
	*/
	@ApiModelProperty(required = false,value="归属" , notes = "归属")
	private String ownerCode;
	
	/**
	 * 面试结果：面试结果
	*/
	@ApiModelProperty(required = false,value="面试结果" , notes = "面试结果" , example = "bad")
	private String status;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-19 07:54:34")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-02-19 07:54:47")
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "2")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * sexDict：sexDict
	*/
	@ApiModelProperty(required = false,value="sexDict" , notes = "sexDict")
	private DictItem sexDict;
	
	/**
	 * maritalStatusDict：maritalStatusDict
	*/
	@ApiModelProperty(required = false,value="maritalStatusDict" , notes = "maritalStatusDict")
	private DictItem maritalStatusDict;
	
	/**
	 * educationData：educationData
	*/
	@ApiModelProperty(required = false,value="educationData" , notes = "educationData")
	private DictItem educationData;
	
	/**
	 * politicCountenanceData：politicCountenanceData
	*/
	@ApiModelProperty(required = false,value="politicCountenanceData" , notes = "politicCountenanceData")
	private DictItem politicCountenanceData;
	
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
	public PersonStore setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 姓名<br>
	 * 姓名
	 * @return 姓名
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 姓名
	 * @param name 姓名
	 * @return 当前对象
	*/
	public PersonStore setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 性别<br>
	 * 性别
	 * @return 性别
	*/
	public String getSexCode() {
		return sexCode;
	}
	
	/**
	 * 设置 性别
	 * @param sexCode 性别
	 * @return 当前对象
	*/
	public PersonStore setSexCode(String sexCode) {
		this.sexCode=sexCode;
		return this;
	}
	
	/**
	 * 获得 出生日期<br>
	 * 出生日期
	 * @return 出生日期
	*/
	public Date getBirthday() {
		return birthday;
	}
	
	/**
	 * 设置 出生日期
	 * @param birthday 出生日期
	 * @return 当前对象
	*/
	public PersonStore setBirthday(Date birthday) {
		this.birthday=birthday;
		return this;
	}
	
	/**
	 * 获得 籍贯<br>
	 * 籍贯
	 * @return 籍贯
	*/
	public String getNativePlaceCode() {
		return nativePlaceCode;
	}
	
	/**
	 * 设置 籍贯
	 * @param nativePlaceCode 籍贯
	 * @return 当前对象
	*/
	public PersonStore setNativePlaceCode(String nativePlaceCode) {
		this.nativePlaceCode=nativePlaceCode;
		return this;
	}
	
	/**
	 * 获得 民族<br>
	 * 民族
	 * @return 民族
	*/
	public String getNationCode() {
		return nationCode;
	}
	
	/**
	 * 设置 民族
	 * @param nationCode 民族
	 * @return 当前对象
	*/
	public PersonStore setNationCode(String nationCode) {
		this.nationCode=nationCode;
		return this;
	}
	
	/**
	 * 获得 婚姻状况<br>
	 * 婚姻状况
	 * @return 婚姻状况
	*/
	public String getMaritalStatus() {
		return maritalStatus;
	}
	
	/**
	 * 设置 婚姻状况
	 * @param maritalStatus 婚姻状况
	 * @return 当前对象
	*/
	public PersonStore setMaritalStatus(String maritalStatus) {
		this.maritalStatus=maritalStatus;
		return this;
	}
	
	/**
	 * 获得 身份证<br>
	 * 身份证
	 * @return 身份证
	*/
	public String getIdentityCard() {
		return identityCard;
	}
	
	/**
	 * 设置 身份证
	 * @param identityCard 身份证
	 * @return 当前对象
	*/
	public PersonStore setIdentityCard(String identityCard) {
		this.identityCard=identityCard;
		return this;
	}
	
	/**
	 * 获得 联系方式<br>
	 * 联系方式
	 * @return 联系方式
	*/
	public String getContactInformation() {
		return contactInformation;
	}
	
	/**
	 * 设置 联系方式
	 * @param contactInformation 联系方式
	 * @return 当前对象
	*/
	public PersonStore setContactInformation(String contactInformation) {
		this.contactInformation=contactInformation;
		return this;
	}
	
	/**
	 * 获得 电子邮件<br>
	 * 电子邮件
	 * @return 电子邮件
	*/
	public String getEmail() {
		return email;
	}
	
	/**
	 * 设置 电子邮件
	 * @param email 电子邮件
	 * @return 当前对象
	*/
	public PersonStore setEmail(String email) {
		this.email=email;
		return this;
	}
	
	/**
	 * 获得 学历<br>
	 * 学历
	 * @return 学历
	*/
	public String getEducationCode() {
		return educationCode;
	}
	
	/**
	 * 设置 学历
	 * @param educationCode 学历
	 * @return 当前对象
	*/
	public PersonStore setEducationCode(String educationCode) {
		this.educationCode=educationCode;
		return this;
	}
	
	/**
	 * 获得 毕业院校<br>
	 * 毕业院校
	 * @return 毕业院校
	*/
	public String getGraduationSchool() {
		return graduationSchool;
	}
	
	/**
	 * 设置 毕业院校
	 * @param graduationSchool 毕业院校
	 * @return 当前对象
	*/
	public PersonStore setGraduationSchool(String graduationSchool) {
		this.graduationSchool=graduationSchool;
		return this;
	}
	
	/**
	 * 获得 所学专业<br>
	 * 所学专业
	 * @return 所学专业
	*/
	public String getMajor() {
		return major;
	}
	
	/**
	 * 设置 所学专业
	 * @param major 所学专业
	 * @return 当前对象
	*/
	public PersonStore setMajor(String major) {
		this.major=major;
		return this;
	}
	
	/**
	 * 获得 毕业时间<br>
	 * 毕业时间
	 * @return 毕业时间
	*/
	public Date getGraduationDate() {
		return graduationDate;
	}
	
	/**
	 * 设置 毕业时间
	 * @param graduationDate 毕业时间
	 * @return 当前对象
	*/
	public PersonStore setGraduationDate(Date graduationDate) {
		this.graduationDate=graduationDate;
		return this;
	}
	
	/**
	 * 获得 所学外语<br>
	 * 所学外语
	 * @return 所学外语
	*/
	public String getForeignLanguage() {
		return foreignLanguage;
	}
	
	/**
	 * 设置 所学外语
	 * @param foreignLanguage 所学外语
	 * @return 当前对象
	*/
	public PersonStore setForeignLanguage(String foreignLanguage) {
		this.foreignLanguage=foreignLanguage;
		return this;
	}
	
	/**
	 * 获得 外语证书<br>
	 * 外语证书
	 * @return 外语证书
	*/
	public String getForeignLanguageLevel() {
		return foreignLanguageLevel;
	}
	
	/**
	 * 设置 外语证书
	 * @param foreignLanguageLevel 外语证书
	 * @return 当前对象
	*/
	public PersonStore setForeignLanguageLevel(String foreignLanguageLevel) {
		this.foreignLanguageLevel=foreignLanguageLevel;
		return this;
	}
	
	/**
	 * 获得 所获证书<br>
	 * 所获证书
	 * @return 所获证书
	*/
	public String getCertificate() {
		return certificate;
	}
	
	/**
	 * 设置 所获证书
	 * @param certificate 所获证书
	 * @return 当前对象
	*/
	public PersonStore setCertificate(String certificate) {
		this.certificate=certificate;
		return this;
	}
	
	/**
	 * 获得 计算机能力<br>
	 * 计算机能力
	 * @return 计算机能力
	*/
	public String getComputerAbility() {
		return computerAbility;
	}
	
	/**
	 * 设置 计算机能力
	 * @param computerAbility 计算机能力
	 * @return 当前对象
	*/
	public PersonStore setComputerAbility(String computerAbility) {
		this.computerAbility=computerAbility;
		return this;
	}
	
	/**
	 * 获得 政治面貌<br>
	 * 政治面貌
	 * @return 政治面貌
	*/
	public String getPoliticCountenanceCode() {
		return politicCountenanceCode;
	}
	
	/**
	 * 设置 政治面貌
	 * @param politicCountenanceCode 政治面貌
	 * @return 当前对象
	*/
	public PersonStore setPoliticCountenanceCode(String politicCountenanceCode) {
		this.politicCountenanceCode=politicCountenanceCode;
		return this;
	}
	
	/**
	 * 获得 入党时间<br>
	 * 入党时间
	 * @return 入党时间
	*/
	public Date getJoinPartDate() {
		return joinPartDate;
	}
	
	/**
	 * 设置 入党时间
	 * @param joinPartDate 入党时间
	 * @return 当前对象
	*/
	public PersonStore setJoinPartDate(Date joinPartDate) {
		this.joinPartDate=joinPartDate;
		return this;
	}
	
	/**
	 * 获得 参加工作时间<br>
	 * 参加工作时间
	 * @return 参加工作时间
	*/
	public Date getFirstWorkDate() {
		return firstWorkDate;
	}
	
	/**
	 * 设置 参加工作时间
	 * @param firstWorkDate 参加工作时间
	 * @return 当前对象
	*/
	public PersonStore setFirstWorkDate(Date firstWorkDate) {
		this.firstWorkDate=firstWorkDate;
		return this;
	}
	
	/**
	 * 获得 特长<br>
	 * 特长
	 * @return 特长
	*/
	public String getSpecialSkill() {
		return specialSkill;
	}
	
	/**
	 * 设置 特长
	 * @param specialSkill 特长
	 * @return 当前对象
	*/
	public PersonStore setSpecialSkill(String specialSkill) {
		this.specialSkill=specialSkill;
		return this;
	}
	
	/**
	 * 获得 对工作要求<br>
	 * 对工作要求
	 * @return 对工作要求
	*/
	public String getJobRequirement() {
		return jobRequirement;
	}
	
	/**
	 * 设置 对工作要求
	 * @param jobRequirement 对工作要求
	 * @return 当前对象
	*/
	public PersonStore setJobRequirement(String jobRequirement) {
		this.jobRequirement=jobRequirement;
		return this;
	}
	
	/**
	 * 获得 目前月薪<br>
	 * 目前月薪
	 * @return 目前月薪
	*/
	public BigDecimal getNowSalary() {
		return nowSalary;
	}
	
	/**
	 * 设置 目前月薪
	 * @param nowSalary 目前月薪
	 * @return 当前对象
	*/
	public PersonStore setNowSalary(BigDecimal nowSalary) {
		this.nowSalary=nowSalary;
		return this;
	}
	
	/**
	 * 获得 期望月薪<br>
	 * 期望月薪
	 * @return 期望月薪
	*/
	public BigDecimal getForSalary() {
		return forSalary;
	}
	
	/**
	 * 设置 期望月薪
	 * @param forSalary 期望月薪
	 * @return 当前对象
	*/
	public PersonStore setForSalary(BigDecimal forSalary) {
		this.forSalary=forSalary;
		return this;
	}
	
	/**
	 * 获得 招聘来源<br>
	 * 招聘来源
	 * @return 招聘来源
	*/
	public String getSource() {
		return source;
	}
	
	/**
	 * 设置 招聘来源
	 * @param source 招聘来源
	 * @return 当前对象
	*/
	public PersonStore setSource(String source) {
		this.source=source;
		return this;
	}
	
	/**
	 * 获得 评审结果<br>
	 * 评审结果
	 * @return 评审结果
	*/
	public String getReviewResult() {
		return reviewResult;
	}
	
	/**
	 * 设置 评审结果
	 * @param reviewResult 评审结果
	 * @return 当前对象
	*/
	public PersonStore setReviewResult(String reviewResult) {
		this.reviewResult=reviewResult;
		return this;
	}
	
	/**
	 * 获得 应聘岗位<br>
	 * 应聘岗位
	 * @return 应聘岗位
	*/
	public String getPosition() {
		return position;
	}
	
	/**
	 * 设置 应聘岗位
	 * @param position 应聘岗位
	 * @return 当前对象
	*/
	public PersonStore setPosition(String position) {
		this.position=position;
		return this;
	}
	
	/**
	 * 获得 照片<br>
	 * 照片
	 * @return 照片
	*/
	public String getPictureId() {
		return pictureId;
	}
	
	/**
	 * 设置 照片
	 * @param pictureId 照片
	 * @return 当前对象
	*/
	public PersonStore setPictureId(String pictureId) {
		this.pictureId=pictureId;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 附件
	 * @param fileId 附件
	 * @return 当前对象
	*/
	public PersonStore setFileId(String fileId) {
		this.fileId=fileId;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNote() {
		return note;
	}
	
	/**
	 * 设置 备注
	 * @param note 备注
	 * @return 当前对象
	*/
	public PersonStore setNote(String note) {
		this.note=note;
		return this;
	}
	
	/**
	 * 获得 归属<br>
	 * 归属
	 * @return 归属
	*/
	public String getOwnerCode() {
		return ownerCode;
	}
	
	/**
	 * 设置 归属
	 * @param ownerCode 归属
	 * @return 当前对象
	*/
	public PersonStore setOwnerCode(String ownerCode) {
		this.ownerCode=ownerCode;
		return this;
	}
	
	/**
	 * 获得 面试结果<br>
	 * 面试结果
	 * @return 面试结果
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 面试结果
	 * @param status 面试结果
	 * @return 当前对象
	*/
	public PersonStore setStatus(String status) {
		this.status=status;
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
	public PersonStore setCreateBy(String createBy) {
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
	public PersonStore setCreateTime(Date createTime) {
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
	public PersonStore setUpdateBy(String updateBy) {
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
	public PersonStore setUpdateTime(Date updateTime) {
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
	public PersonStore setDeleted(Integer deleted) {
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
	public PersonStore setDeleted(Boolean deletedBool) {
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
	public PersonStore setDeleteBy(String deleteBy) {
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
	public PersonStore setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public PersonStore setVersion(Integer version) {
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
	public PersonStore setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 sexDict<br>
	 * sexDict
	 * @return sexDict
	*/
	public DictItem getSexDict() {
		return sexDict;
	}
	
	/**
	 * 设置 sexDict
	 * @param sexDict sexDict
	 * @return 当前对象
	*/
	public PersonStore setSexDict(DictItem sexDict) {
		this.sexDict=sexDict;
		return this;
	}
	
	/**
	 * 获得 maritalStatusDict<br>
	 * maritalStatusDict
	 * @return maritalStatusDict
	*/
	public DictItem getMaritalStatusDict() {
		return maritalStatusDict;
	}
	
	/**
	 * 设置 maritalStatusDict
	 * @param maritalStatusDict maritalStatusDict
	 * @return 当前对象
	*/
	public PersonStore setMaritalStatusDict(DictItem maritalStatusDict) {
		this.maritalStatusDict=maritalStatusDict;
		return this;
	}
	
	/**
	 * 获得 educationData<br>
	 * educationData
	 * @return educationData
	*/
	public DictItem getEducationData() {
		return educationData;
	}
	
	/**
	 * 设置 educationData
	 * @param educationData educationData
	 * @return 当前对象
	*/
	public PersonStore setEducationData(DictItem educationData) {
		this.educationData=educationData;
		return this;
	}
	
	/**
	 * 获得 politicCountenanceData<br>
	 * politicCountenanceData
	 * @return politicCountenanceData
	*/
	public DictItem getPoliticCountenanceData() {
		return politicCountenanceData;
	}
	
	/**
	 * 设置 politicCountenanceData
	 * @param politicCountenanceData politicCountenanceData
	 * @return 当前对象
	*/
	public PersonStore setPoliticCountenanceData(DictItem politicCountenanceData) {
		this.politicCountenanceData=politicCountenanceData;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonStore , 转换好的 PersonStore 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonStore , 转换好的 PoJo 对象
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
	public PersonStore clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonStore duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonStoreMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonStoreMeta.$$proxy$$();
		inst.setBirthday(this.getBirthday());
		inst.setNote(this.getNote());
		inst.setReviewResult(this.getReviewResult());
		inst.setOwnerCode(this.getOwnerCode());
		inst.setCertificate(this.getCertificate());
		inst.setEducationCode(this.getEducationCode());
		inst.setSource(this.getSource());
		inst.setComputerAbility(this.getComputerAbility());
		inst.setNativePlaceCode(this.getNativePlaceCode());
		inst.setMajor(this.getMajor());
		inst.setPictureId(this.getPictureId());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setEmail(this.getEmail());
		inst.setNationCode(this.getNationCode());
		inst.setFirstWorkDate(this.getFirstWorkDate());
		inst.setForeignLanguageLevel(this.getForeignLanguageLevel());
		inst.setGraduationSchool(this.getGraduationSchool());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setIdentityCard(this.getIdentityCard());
		inst.setSpecialSkill(this.getSpecialSkill());
		inst.setForSalary(this.getForSalary());
		inst.setVersion(this.getVersion());
		inst.setJoinPartDate(this.getJoinPartDate());
		inst.setSexCode(this.getSexCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setContactInformation(this.getContactInformation());
		inst.setDeleted(this.getDeleted());
		inst.setGraduationDate(this.getGraduationDate());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setForeignLanguage(this.getForeignLanguage());
		inst.setTenantId(this.getTenantId());
		inst.setPoliticCountenanceCode(this.getPoliticCountenanceCode());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setNowSalary(this.getNowSalary());
		inst.setPosition(this.getPosition());
		inst.setMaritalStatus(this.getMaritalStatus());
		inst.setJobRequirement(this.getJobRequirement());
		inst.setFileId(this.getFileId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setPoliticCountenanceData(this.getPoliticCountenanceData());
			inst.setSexDict(this.getSexDict());
			inst.setEducationData(this.getEducationData());
			inst.setMaritalStatusDict(this.getMaritalStatusDict());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonStore clone(boolean deep) {
		return EntityContext.clone(PersonStore.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonStore
	 * @param personStoreMap 包含实体信息的 Map 对象
	 * @return PersonStore , 转换好的的 PersonStore 对象
	*/
	@Transient
	public static PersonStore createFrom(Map<String,Object> personStoreMap) {
		if(personStoreMap==null) return null;
		PersonStore po = create();
		EntityContext.copyProperties(po,personStoreMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonStore
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonStore , 转换好的的 PersonStore 对象
	*/
	@Transient
	public static PersonStore createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonStore po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonStore，等同于 new
	 * @return PersonStore 对象
	*/
	@Transient
	public static PersonStore create() {
		return new com.dt.platform.domain.hr.meta.PersonStoreMeta.$$proxy$$();
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
			this.setBirthday(DataParser.parse(Date.class, map.get(PersonStoreMeta.BIRTHDAY)));
			this.setNote(DataParser.parse(String.class, map.get(PersonStoreMeta.NOTE)));
			this.setReviewResult(DataParser.parse(String.class, map.get(PersonStoreMeta.REVIEW_RESULT)));
			this.setOwnerCode(DataParser.parse(String.class, map.get(PersonStoreMeta.OWNER_CODE)));
			this.setCertificate(DataParser.parse(String.class, map.get(PersonStoreMeta.CERTIFICATE)));
			this.setEducationCode(DataParser.parse(String.class, map.get(PersonStoreMeta.EDUCATION_CODE)));
			this.setSource(DataParser.parse(String.class, map.get(PersonStoreMeta.SOURCE)));
			this.setComputerAbility(DataParser.parse(String.class, map.get(PersonStoreMeta.COMPUTER_ABILITY)));
			this.setNativePlaceCode(DataParser.parse(String.class, map.get(PersonStoreMeta.NATIVE_PLACE_CODE)));
			this.setMajor(DataParser.parse(String.class, map.get(PersonStoreMeta.MAJOR)));
			this.setPictureId(DataParser.parse(String.class, map.get(PersonStoreMeta.PICTURE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonStoreMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PersonStoreMeta.ID)));
			this.setEmail(DataParser.parse(String.class, map.get(PersonStoreMeta.EMAIL)));
			this.setNationCode(DataParser.parse(String.class, map.get(PersonStoreMeta.NATION_CODE)));
			this.setFirstWorkDate(DataParser.parse(Date.class, map.get(PersonStoreMeta.FIRST_WORK_DATE)));
			this.setForeignLanguageLevel(DataParser.parse(String.class, map.get(PersonStoreMeta.FOREIGN_LANGUAGE_LEVEL)));
			this.setGraduationSchool(DataParser.parse(String.class, map.get(PersonStoreMeta.GRADUATION_SCHOOL)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonStoreMeta.UPDATE_TIME)));
			this.setIdentityCard(DataParser.parse(String.class, map.get(PersonStoreMeta.IDENTITY_CARD)));
			this.setSpecialSkill(DataParser.parse(String.class, map.get(PersonStoreMeta.SPECIAL_SKILL)));
			this.setForSalary(DataParser.parse(BigDecimal.class, map.get(PersonStoreMeta.FOR_SALARY)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonStoreMeta.VERSION)));
			this.setJoinPartDate(DataParser.parse(Date.class, map.get(PersonStoreMeta.JOIN_PART_DATE)));
			this.setSexCode(DataParser.parse(String.class, map.get(PersonStoreMeta.SEX_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonStoreMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, map.get(PersonStoreMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonStoreMeta.DELETED)));
			this.setGraduationDate(DataParser.parse(Date.class, map.get(PersonStoreMeta.GRADUATION_DATE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonStoreMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonStoreMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(PersonStoreMeta.NAME)));
			this.setForeignLanguage(DataParser.parse(String.class, map.get(PersonStoreMeta.FOREIGN_LANGUAGE)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonStoreMeta.TENANT_ID)));
			this.setPoliticCountenanceCode(DataParser.parse(String.class, map.get(PersonStoreMeta.POLITIC_COUNTENANCE_CODE)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonStoreMeta.DELETE_BY)));
			this.setNowSalary(DataParser.parse(BigDecimal.class, map.get(PersonStoreMeta.NOW_SALARY)));
			this.setPosition(DataParser.parse(String.class, map.get(PersonStoreMeta.POSITION)));
			this.setMaritalStatus(DataParser.parse(String.class, map.get(PersonStoreMeta.MARITAL_STATUS)));
			this.setJobRequirement(DataParser.parse(String.class, map.get(PersonStoreMeta.JOB_REQUIREMENT)));
			this.setFileId(DataParser.parse(String.class, map.get(PersonStoreMeta.FILE_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonStoreMeta.STATUS)));
			// others
			this.setPoliticCountenanceData(DataParser.parse(DictItem.class, map.get(PersonStoreMeta.POLITIC_COUNTENANCE_DATA)));
			this.setSexDict(DataParser.parse(DictItem.class, map.get(PersonStoreMeta.SEX_DICT)));
			this.setEducationData(DataParser.parse(DictItem.class, map.get(PersonStoreMeta.EDUCATION_DATA)));
			this.setMaritalStatusDict(DataParser.parse(DictItem.class, map.get(PersonStoreMeta.MARITAL_STATUS_DICT)));
			return true;
		} else {
			try {
				this.setBirthday( (Date)map.get(PersonStoreMeta.BIRTHDAY));
				this.setNote( (String)map.get(PersonStoreMeta.NOTE));
				this.setReviewResult( (String)map.get(PersonStoreMeta.REVIEW_RESULT));
				this.setOwnerCode( (String)map.get(PersonStoreMeta.OWNER_CODE));
				this.setCertificate( (String)map.get(PersonStoreMeta.CERTIFICATE));
				this.setEducationCode( (String)map.get(PersonStoreMeta.EDUCATION_CODE));
				this.setSource( (String)map.get(PersonStoreMeta.SOURCE));
				this.setComputerAbility( (String)map.get(PersonStoreMeta.COMPUTER_ABILITY));
				this.setNativePlaceCode( (String)map.get(PersonStoreMeta.NATIVE_PLACE_CODE));
				this.setMajor( (String)map.get(PersonStoreMeta.MAJOR));
				this.setPictureId( (String)map.get(PersonStoreMeta.PICTURE_ID));
				this.setUpdateBy( (String)map.get(PersonStoreMeta.UPDATE_BY));
				this.setId( (String)map.get(PersonStoreMeta.ID));
				this.setEmail( (String)map.get(PersonStoreMeta.EMAIL));
				this.setNationCode( (String)map.get(PersonStoreMeta.NATION_CODE));
				this.setFirstWorkDate( (Date)map.get(PersonStoreMeta.FIRST_WORK_DATE));
				this.setForeignLanguageLevel( (String)map.get(PersonStoreMeta.FOREIGN_LANGUAGE_LEVEL));
				this.setGraduationSchool( (String)map.get(PersonStoreMeta.GRADUATION_SCHOOL));
				this.setUpdateTime( (Date)map.get(PersonStoreMeta.UPDATE_TIME));
				this.setIdentityCard( (String)map.get(PersonStoreMeta.IDENTITY_CARD));
				this.setSpecialSkill( (String)map.get(PersonStoreMeta.SPECIAL_SKILL));
				this.setForSalary( (BigDecimal)map.get(PersonStoreMeta.FOR_SALARY));
				this.setVersion( (Integer)map.get(PersonStoreMeta.VERSION));
				this.setJoinPartDate( (Date)map.get(PersonStoreMeta.JOIN_PART_DATE));
				this.setSexCode( (String)map.get(PersonStoreMeta.SEX_CODE));
				this.setCreateBy( (String)map.get(PersonStoreMeta.CREATE_BY));
				this.setContactInformation( (String)map.get(PersonStoreMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)map.get(PersonStoreMeta.DELETED));
				this.setGraduationDate( (Date)map.get(PersonStoreMeta.GRADUATION_DATE));
				this.setCreateTime( (Date)map.get(PersonStoreMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(PersonStoreMeta.DELETE_TIME));
				this.setName( (String)map.get(PersonStoreMeta.NAME));
				this.setForeignLanguage( (String)map.get(PersonStoreMeta.FOREIGN_LANGUAGE));
				this.setTenantId( (String)map.get(PersonStoreMeta.TENANT_ID));
				this.setPoliticCountenanceCode( (String)map.get(PersonStoreMeta.POLITIC_COUNTENANCE_CODE));
				this.setDeleteBy( (String)map.get(PersonStoreMeta.DELETE_BY));
				this.setNowSalary( (BigDecimal)map.get(PersonStoreMeta.NOW_SALARY));
				this.setPosition( (String)map.get(PersonStoreMeta.POSITION));
				this.setMaritalStatus( (String)map.get(PersonStoreMeta.MARITAL_STATUS));
				this.setJobRequirement( (String)map.get(PersonStoreMeta.JOB_REQUIREMENT));
				this.setFileId( (String)map.get(PersonStoreMeta.FILE_ID));
				this.setStatus( (String)map.get(PersonStoreMeta.STATUS));
				// others
				this.setPoliticCountenanceData( (DictItem)map.get(PersonStoreMeta.POLITIC_COUNTENANCE_DATA));
				this.setSexDict( (DictItem)map.get(PersonStoreMeta.SEX_DICT));
				this.setEducationData( (DictItem)map.get(PersonStoreMeta.EDUCATION_DATA));
				this.setMaritalStatusDict( (DictItem)map.get(PersonStoreMeta.MARITAL_STATUS_DICT));
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
			this.setBirthday(DataParser.parse(Date.class, r.getValue(PersonStoreMeta.BIRTHDAY)));
			this.setNote(DataParser.parse(String.class, r.getValue(PersonStoreMeta.NOTE)));
			this.setReviewResult(DataParser.parse(String.class, r.getValue(PersonStoreMeta.REVIEW_RESULT)));
			this.setOwnerCode(DataParser.parse(String.class, r.getValue(PersonStoreMeta.OWNER_CODE)));
			this.setCertificate(DataParser.parse(String.class, r.getValue(PersonStoreMeta.CERTIFICATE)));
			this.setEducationCode(DataParser.parse(String.class, r.getValue(PersonStoreMeta.EDUCATION_CODE)));
			this.setSource(DataParser.parse(String.class, r.getValue(PersonStoreMeta.SOURCE)));
			this.setComputerAbility(DataParser.parse(String.class, r.getValue(PersonStoreMeta.COMPUTER_ABILITY)));
			this.setNativePlaceCode(DataParser.parse(String.class, r.getValue(PersonStoreMeta.NATIVE_PLACE_CODE)));
			this.setMajor(DataParser.parse(String.class, r.getValue(PersonStoreMeta.MAJOR)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(PersonStoreMeta.PICTURE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonStoreMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonStoreMeta.ID)));
			this.setEmail(DataParser.parse(String.class, r.getValue(PersonStoreMeta.EMAIL)));
			this.setNationCode(DataParser.parse(String.class, r.getValue(PersonStoreMeta.NATION_CODE)));
			this.setFirstWorkDate(DataParser.parse(Date.class, r.getValue(PersonStoreMeta.FIRST_WORK_DATE)));
			this.setForeignLanguageLevel(DataParser.parse(String.class, r.getValue(PersonStoreMeta.FOREIGN_LANGUAGE_LEVEL)));
			this.setGraduationSchool(DataParser.parse(String.class, r.getValue(PersonStoreMeta.GRADUATION_SCHOOL)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonStoreMeta.UPDATE_TIME)));
			this.setIdentityCard(DataParser.parse(String.class, r.getValue(PersonStoreMeta.IDENTITY_CARD)));
			this.setSpecialSkill(DataParser.parse(String.class, r.getValue(PersonStoreMeta.SPECIAL_SKILL)));
			this.setForSalary(DataParser.parse(BigDecimal.class, r.getValue(PersonStoreMeta.FOR_SALARY)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonStoreMeta.VERSION)));
			this.setJoinPartDate(DataParser.parse(Date.class, r.getValue(PersonStoreMeta.JOIN_PART_DATE)));
			this.setSexCode(DataParser.parse(String.class, r.getValue(PersonStoreMeta.SEX_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonStoreMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, r.getValue(PersonStoreMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonStoreMeta.DELETED)));
			this.setGraduationDate(DataParser.parse(Date.class, r.getValue(PersonStoreMeta.GRADUATION_DATE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonStoreMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonStoreMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(PersonStoreMeta.NAME)));
			this.setForeignLanguage(DataParser.parse(String.class, r.getValue(PersonStoreMeta.FOREIGN_LANGUAGE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonStoreMeta.TENANT_ID)));
			this.setPoliticCountenanceCode(DataParser.parse(String.class, r.getValue(PersonStoreMeta.POLITIC_COUNTENANCE_CODE)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonStoreMeta.DELETE_BY)));
			this.setNowSalary(DataParser.parse(BigDecimal.class, r.getValue(PersonStoreMeta.NOW_SALARY)));
			this.setPosition(DataParser.parse(String.class, r.getValue(PersonStoreMeta.POSITION)));
			this.setMaritalStatus(DataParser.parse(String.class, r.getValue(PersonStoreMeta.MARITAL_STATUS)));
			this.setJobRequirement(DataParser.parse(String.class, r.getValue(PersonStoreMeta.JOB_REQUIREMENT)));
			this.setFileId(DataParser.parse(String.class, r.getValue(PersonStoreMeta.FILE_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonStoreMeta.STATUS)));
			return true;
		} else {
			try {
				this.setBirthday( (Date)r.getValue(PersonStoreMeta.BIRTHDAY));
				this.setNote( (String)r.getValue(PersonStoreMeta.NOTE));
				this.setReviewResult( (String)r.getValue(PersonStoreMeta.REVIEW_RESULT));
				this.setOwnerCode( (String)r.getValue(PersonStoreMeta.OWNER_CODE));
				this.setCertificate( (String)r.getValue(PersonStoreMeta.CERTIFICATE));
				this.setEducationCode( (String)r.getValue(PersonStoreMeta.EDUCATION_CODE));
				this.setSource( (String)r.getValue(PersonStoreMeta.SOURCE));
				this.setComputerAbility( (String)r.getValue(PersonStoreMeta.COMPUTER_ABILITY));
				this.setNativePlaceCode( (String)r.getValue(PersonStoreMeta.NATIVE_PLACE_CODE));
				this.setMajor( (String)r.getValue(PersonStoreMeta.MAJOR));
				this.setPictureId( (String)r.getValue(PersonStoreMeta.PICTURE_ID));
				this.setUpdateBy( (String)r.getValue(PersonStoreMeta.UPDATE_BY));
				this.setId( (String)r.getValue(PersonStoreMeta.ID));
				this.setEmail( (String)r.getValue(PersonStoreMeta.EMAIL));
				this.setNationCode( (String)r.getValue(PersonStoreMeta.NATION_CODE));
				this.setFirstWorkDate( (Date)r.getValue(PersonStoreMeta.FIRST_WORK_DATE));
				this.setForeignLanguageLevel( (String)r.getValue(PersonStoreMeta.FOREIGN_LANGUAGE_LEVEL));
				this.setGraduationSchool( (String)r.getValue(PersonStoreMeta.GRADUATION_SCHOOL));
				this.setUpdateTime( (Date)r.getValue(PersonStoreMeta.UPDATE_TIME));
				this.setIdentityCard( (String)r.getValue(PersonStoreMeta.IDENTITY_CARD));
				this.setSpecialSkill( (String)r.getValue(PersonStoreMeta.SPECIAL_SKILL));
				this.setForSalary( (BigDecimal)r.getValue(PersonStoreMeta.FOR_SALARY));
				this.setVersion( (Integer)r.getValue(PersonStoreMeta.VERSION));
				this.setJoinPartDate( (Date)r.getValue(PersonStoreMeta.JOIN_PART_DATE));
				this.setSexCode( (String)r.getValue(PersonStoreMeta.SEX_CODE));
				this.setCreateBy( (String)r.getValue(PersonStoreMeta.CREATE_BY));
				this.setContactInformation( (String)r.getValue(PersonStoreMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)r.getValue(PersonStoreMeta.DELETED));
				this.setGraduationDate( (Date)r.getValue(PersonStoreMeta.GRADUATION_DATE));
				this.setCreateTime( (Date)r.getValue(PersonStoreMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(PersonStoreMeta.DELETE_TIME));
				this.setName( (String)r.getValue(PersonStoreMeta.NAME));
				this.setForeignLanguage( (String)r.getValue(PersonStoreMeta.FOREIGN_LANGUAGE));
				this.setTenantId( (String)r.getValue(PersonStoreMeta.TENANT_ID));
				this.setPoliticCountenanceCode( (String)r.getValue(PersonStoreMeta.POLITIC_COUNTENANCE_CODE));
				this.setDeleteBy( (String)r.getValue(PersonStoreMeta.DELETE_BY));
				this.setNowSalary( (BigDecimal)r.getValue(PersonStoreMeta.NOW_SALARY));
				this.setPosition( (String)r.getValue(PersonStoreMeta.POSITION));
				this.setMaritalStatus( (String)r.getValue(PersonStoreMeta.MARITAL_STATUS));
				this.setJobRequirement( (String)r.getValue(PersonStoreMeta.JOB_REQUIREMENT));
				this.setFileId( (String)r.getValue(PersonStoreMeta.FILE_ID));
				this.setStatus( (String)r.getValue(PersonStoreMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}