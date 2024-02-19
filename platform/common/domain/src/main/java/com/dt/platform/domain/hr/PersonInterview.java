package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_INTERVIEW;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Organization;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.PersonInterviewMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 初选人员
 * <p>初选人员 , 数据表 hr_person_interview 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-19 19:53:48
 * @sign BD0BAF61D78A2D0F06E9C32F68D61580
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_interview")
@ApiModel(description = "初选人员 ; 初选人员 , 数据表 hr_person_interview 的PO类型")
public class PersonInterview extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_INTERVIEW.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "812048953112526848")
	private String id;
	
	/**
	 * 面试：面试
	*/
	@ApiModelProperty(required = false,value="面试" , notes = "面试")
	private String interviewId;
	
	/**
	 * 面试结果：面试结果
	*/
	@ApiModelProperty(required = false,value="面试结果" , notes = "面试结果" , example = "access")
	private String status;
	
	/**
	 * 姓名：姓名
	*/
	@ApiModelProperty(required = false,value="姓名" , notes = "姓名" , example = "12")
	private String name;
	
	/**
	 * 性别：性别
	*/
	@ApiModelProperty(required = false,value="性别" , notes = "性别" , example = "F")
	private String sexCode;
	
	/**
	 * 出生日期：出生日期
	*/
	@ApiModelProperty(required = false,value="出生日期" , notes = "出生日期" , example = "2024-02-06 12:00:00")
	private Date birthday;
	
	/**
	 * 联系方式：联系方式
	*/
	@ApiModelProperty(required = false,value="联系方式" , notes = "联系方式" , example = "12")
	private String contactInformation;
	
	/**
	 * 学历：学历
	*/
	@ApiModelProperty(required = false,value="学历" , notes = "学历" , example = "本科")
	private String educationCode;
	
	/**
	 * 毕业院校：毕业院校
	*/
	@ApiModelProperty(required = false,value="毕业院校" , notes = "毕业院校" , example = "1212")
	private String graduationSchool;
	
	/**
	 * 所学专业：所学专业
	*/
	@ApiModelProperty(required = false,value="所学专业" , notes = "所学专业")
	private String major;
	
	/**
	 * 面试日期：面试日期
	*/
	@ApiModelProperty(required = false,value="面试日期" , notes = "面试日期" , example = "2024-02-08 12:00:00")
	private Date interviewDate;
	
	/**
	 * 面试方式：面试方式
	*/
	@ApiModelProperty(required = false,value="面试方式" , notes = "面试方式" , example = "scene")
	private String interviewMethod;
	
	/**
	 * 应聘岗位：应聘岗位
	*/
	@ApiModelProperty(required = false,value="应聘岗位" , notes = "应聘岗位" , example = "12")
	private String pos;
	
	/**
	 * 招聘部门：招聘部门
	*/
	@ApiModelProperty(required = false,value="招聘部门" , notes = "招聘部门" , example = "788871090188320766")
	private String orgId;
	
	/**
	 * 简历来源：简历来源
	*/
	@ApiModelProperty(required = false,value="简历来源" , notes = "简历来源" , example = "network")
	private String source;
	
	/**
	 * 面试结论：面试结论
	*/
	@ApiModelProperty(required = false,value="面试结论" , notes = "面试结论" , example = "12")
	private String result;
	
	/**
	 * 简历：简历
	*/
	@ApiModelProperty(required = false,value="简历" , notes = "简历")
	private String fileId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "1212")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-19 07:52:38")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-02-19 07:52:55")
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
	 * educationData：educationData
	*/
	@ApiModelProperty(required = false,value="educationData" , notes = "educationData")
	private DictItem educationData;
	
	/**
	 * sexDict：sexDict
	*/
	@ApiModelProperty(required = false,value="sexDict" , notes = "sexDict")
	private DictItem sexDict;
	
	/**
	 * interviewMethodDict：interviewMethodDict
	*/
	@ApiModelProperty(required = false,value="interviewMethodDict" , notes = "interviewMethodDict")
	private DictItem interviewMethodDict;
	
	/**
	 * sourceDict：sourceDict
	*/
	@ApiModelProperty(required = false,value="sourceDict" , notes = "sourceDict")
	private DictItem sourceDict;
	
	/**
	 * organization：organization
	*/
	@ApiModelProperty(required = false,value="organization" , notes = "organization")
	private Organization organization;
	
	/**
	 * interview：interview
	*/
	@ApiModelProperty(required = false,value="interview" , notes = "interview")
	private Interview interview;
	
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
	public PersonInterview setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 面试<br>
	 * 面试
	 * @return 面试
	*/
	public String getInterviewId() {
		return interviewId;
	}
	
	/**
	 * 设置 面试
	 * @param interviewId 面试
	 * @return 当前对象
	*/
	public PersonInterview setInterviewId(String interviewId) {
		this.interviewId=interviewId;
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
	public PersonInterview setStatus(String status) {
		this.status=status;
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
	public PersonInterview setName(String name) {
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
	public PersonInterview setSexCode(String sexCode) {
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
	public PersonInterview setBirthday(Date birthday) {
		this.birthday=birthday;
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
	public PersonInterview setContactInformation(String contactInformation) {
		this.contactInformation=contactInformation;
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
	public PersonInterview setEducationCode(String educationCode) {
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
	public PersonInterview setGraduationSchool(String graduationSchool) {
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
	public PersonInterview setMajor(String major) {
		this.major=major;
		return this;
	}
	
	/**
	 * 获得 面试日期<br>
	 * 面试日期
	 * @return 面试日期
	*/
	public Date getInterviewDate() {
		return interviewDate;
	}
	
	/**
	 * 设置 面试日期
	 * @param interviewDate 面试日期
	 * @return 当前对象
	*/
	public PersonInterview setInterviewDate(Date interviewDate) {
		this.interviewDate=interviewDate;
		return this;
	}
	
	/**
	 * 获得 面试方式<br>
	 * 面试方式
	 * @return 面试方式
	*/
	public String getInterviewMethod() {
		return interviewMethod;
	}
	
	/**
	 * 设置 面试方式
	 * @param interviewMethod 面试方式
	 * @return 当前对象
	*/
	public PersonInterview setInterviewMethod(String interviewMethod) {
		this.interviewMethod=interviewMethod;
		return this;
	}
	
	/**
	 * 获得 应聘岗位<br>
	 * 应聘岗位
	 * @return 应聘岗位
	*/
	public String getPos() {
		return pos;
	}
	
	/**
	 * 设置 应聘岗位
	 * @param pos 应聘岗位
	 * @return 当前对象
	*/
	public PersonInterview setPos(String pos) {
		this.pos=pos;
		return this;
	}
	
	/**
	 * 获得 招聘部门<br>
	 * 招聘部门
	 * @return 招聘部门
	*/
	public String getOrgId() {
		return orgId;
	}
	
	/**
	 * 设置 招聘部门
	 * @param orgId 招聘部门
	 * @return 当前对象
	*/
	public PersonInterview setOrgId(String orgId) {
		this.orgId=orgId;
		return this;
	}
	
	/**
	 * 获得 简历来源<br>
	 * 简历来源
	 * @return 简历来源
	*/
	public String getSource() {
		return source;
	}
	
	/**
	 * 设置 简历来源
	 * @param source 简历来源
	 * @return 当前对象
	*/
	public PersonInterview setSource(String source) {
		this.source=source;
		return this;
	}
	
	/**
	 * 获得 面试结论<br>
	 * 面试结论
	 * @return 面试结论
	*/
	public String getResult() {
		return result;
	}
	
	/**
	 * 设置 面试结论
	 * @param result 面试结论
	 * @return 当前对象
	*/
	public PersonInterview setResult(String result) {
		this.result=result;
		return this;
	}
	
	/**
	 * 获得 简历<br>
	 * 简历
	 * @return 简历
	*/
	public String getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 简历
	 * @param fileId 简历
	 * @return 当前对象
	*/
	public PersonInterview setFileId(String fileId) {
		this.fileId=fileId;
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
	public PersonInterview setNotes(String notes) {
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
	public PersonInterview setCreateBy(String createBy) {
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
	public PersonInterview setCreateTime(Date createTime) {
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
	public PersonInterview setUpdateBy(String updateBy) {
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
	public PersonInterview setUpdateTime(Date updateTime) {
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
	public PersonInterview setDeleted(Integer deleted) {
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
	public PersonInterview setDeleted(Boolean deletedBool) {
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
	public PersonInterview setDeleteBy(String deleteBy) {
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
	public PersonInterview setDeleteTime(Date deleteTime) {
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
	public PersonInterview setVersion(Integer version) {
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
	public PersonInterview setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public PersonInterview setEducationData(DictItem educationData) {
		this.educationData=educationData;
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
	public PersonInterview setSexDict(DictItem sexDict) {
		this.sexDict=sexDict;
		return this;
	}
	
	/**
	 * 获得 interviewMethodDict<br>
	 * interviewMethodDict
	 * @return interviewMethodDict
	*/
	public DictItem getInterviewMethodDict() {
		return interviewMethodDict;
	}
	
	/**
	 * 设置 interviewMethodDict
	 * @param interviewMethodDict interviewMethodDict
	 * @return 当前对象
	*/
	public PersonInterview setInterviewMethodDict(DictItem interviewMethodDict) {
		this.interviewMethodDict=interviewMethodDict;
		return this;
	}
	
	/**
	 * 获得 sourceDict<br>
	 * sourceDict
	 * @return sourceDict
	*/
	public DictItem getSourceDict() {
		return sourceDict;
	}
	
	/**
	 * 设置 sourceDict
	 * @param sourceDict sourceDict
	 * @return 当前对象
	*/
	public PersonInterview setSourceDict(DictItem sourceDict) {
		this.sourceDict=sourceDict;
		return this;
	}
	
	/**
	 * 获得 organization<br>
	 * organization
	 * @return organization
	*/
	public Organization getOrganization() {
		return organization;
	}
	
	/**
	 * 设置 organization
	 * @param organization organization
	 * @return 当前对象
	*/
	public PersonInterview setOrganization(Organization organization) {
		this.organization=organization;
		return this;
	}
	
	/**
	 * 获得 interview<br>
	 * interview
	 * @return interview
	*/
	public Interview getInterview() {
		return interview;
	}
	
	/**
	 * 设置 interview
	 * @param interview interview
	 * @return 当前对象
	*/
	public PersonInterview setInterview(Interview interview) {
		this.interview=interview;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonInterview , 转换好的 PersonInterview 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonInterview , 转换好的 PoJo 对象
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
	public PersonInterview clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonInterview duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonInterviewMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonInterviewMeta.$$proxy$$();
		inst.setBirthday(this.getBirthday());
		inst.setNotes(this.getNotes());
		inst.setInterviewMethod(this.getInterviewMethod());
		inst.setEducationCode(this.getEducationCode());
		inst.setSource(this.getSource());
		inst.setOrgId(this.getOrgId());
		inst.setResult(this.getResult());
		inst.setMajor(this.getMajor());
		inst.setPos(this.getPos());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setGraduationSchool(this.getGraduationSchool());
		inst.setInterviewDate(this.getInterviewDate());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setInterviewId(this.getInterviewId());
		inst.setSexCode(this.getSexCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setContactInformation(this.getContactInformation());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		inst.setFileId(this.getFileId());
		if(all) {
			inst.setInterviewMethodDict(this.getInterviewMethodDict());
			inst.setOrganization(this.getOrganization());
			inst.setSourceDict(this.getSourceDict());
			inst.setEducationData(this.getEducationData());
			inst.setSexDict(this.getSexDict());
			inst.setInterview(this.getInterview());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonInterview clone(boolean deep) {
		return EntityContext.clone(PersonInterview.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonInterview
	 * @param personInterviewMap 包含实体信息的 Map 对象
	 * @return PersonInterview , 转换好的的 PersonInterview 对象
	*/
	@Transient
	public static PersonInterview createFrom(Map<String,Object> personInterviewMap) {
		if(personInterviewMap==null) return null;
		PersonInterview po = create();
		EntityContext.copyProperties(po,personInterviewMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonInterview
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonInterview , 转换好的的 PersonInterview 对象
	*/
	@Transient
	public static PersonInterview createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonInterview po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonInterview，等同于 new
	 * @return PersonInterview 对象
	*/
	@Transient
	public static PersonInterview create() {
		return new com.dt.platform.domain.hr.meta.PersonInterviewMeta.$$proxy$$();
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
			this.setBirthday(DataParser.parse(Date.class, map.get(PersonInterviewMeta.BIRTHDAY)));
			this.setNotes(DataParser.parse(String.class, map.get(PersonInterviewMeta.NOTES)));
			this.setInterviewMethod(DataParser.parse(String.class, map.get(PersonInterviewMeta.INTERVIEW_METHOD)));
			this.setEducationCode(DataParser.parse(String.class, map.get(PersonInterviewMeta.EDUCATION_CODE)));
			this.setSource(DataParser.parse(String.class, map.get(PersonInterviewMeta.SOURCE)));
			this.setOrgId(DataParser.parse(String.class, map.get(PersonInterviewMeta.ORG_ID)));
			this.setResult(DataParser.parse(String.class, map.get(PersonInterviewMeta.RESULT)));
			this.setMajor(DataParser.parse(String.class, map.get(PersonInterviewMeta.MAJOR)));
			this.setPos(DataParser.parse(String.class, map.get(PersonInterviewMeta.POS)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonInterviewMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PersonInterviewMeta.ID)));
			this.setGraduationSchool(DataParser.parse(String.class, map.get(PersonInterviewMeta.GRADUATION_SCHOOL)));
			this.setInterviewDate(DataParser.parse(Date.class, map.get(PersonInterviewMeta.INTERVIEW_DATE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonInterviewMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonInterviewMeta.VERSION)));
			this.setInterviewId(DataParser.parse(String.class, map.get(PersonInterviewMeta.INTERVIEW_ID)));
			this.setSexCode(DataParser.parse(String.class, map.get(PersonInterviewMeta.SEX_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonInterviewMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, map.get(PersonInterviewMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonInterviewMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonInterviewMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonInterviewMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(PersonInterviewMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonInterviewMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonInterviewMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonInterviewMeta.STATUS)));
			this.setFileId(DataParser.parse(String.class, map.get(PersonInterviewMeta.FILE_ID)));
			// others
			this.setInterviewMethodDict(DataParser.parse(DictItem.class, map.get(PersonInterviewMeta.INTERVIEW_METHOD_DICT)));
			this.setOrganization(DataParser.parse(Organization.class, map.get(PersonInterviewMeta.ORGANIZATION)));
			this.setSourceDict(DataParser.parse(DictItem.class, map.get(PersonInterviewMeta.SOURCE_DICT)));
			this.setEducationData(DataParser.parse(DictItem.class, map.get(PersonInterviewMeta.EDUCATION_DATA)));
			this.setSexDict(DataParser.parse(DictItem.class, map.get(PersonInterviewMeta.SEX_DICT)));
			this.setInterview(DataParser.parse(Interview.class, map.get(PersonInterviewMeta.INTERVIEW)));
			return true;
		} else {
			try {
				this.setBirthday( (Date)map.get(PersonInterviewMeta.BIRTHDAY));
				this.setNotes( (String)map.get(PersonInterviewMeta.NOTES));
				this.setInterviewMethod( (String)map.get(PersonInterviewMeta.INTERVIEW_METHOD));
				this.setEducationCode( (String)map.get(PersonInterviewMeta.EDUCATION_CODE));
				this.setSource( (String)map.get(PersonInterviewMeta.SOURCE));
				this.setOrgId( (String)map.get(PersonInterviewMeta.ORG_ID));
				this.setResult( (String)map.get(PersonInterviewMeta.RESULT));
				this.setMajor( (String)map.get(PersonInterviewMeta.MAJOR));
				this.setPos( (String)map.get(PersonInterviewMeta.POS));
				this.setUpdateBy( (String)map.get(PersonInterviewMeta.UPDATE_BY));
				this.setId( (String)map.get(PersonInterviewMeta.ID));
				this.setGraduationSchool( (String)map.get(PersonInterviewMeta.GRADUATION_SCHOOL));
				this.setInterviewDate( (Date)map.get(PersonInterviewMeta.INTERVIEW_DATE));
				this.setUpdateTime( (Date)map.get(PersonInterviewMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PersonInterviewMeta.VERSION));
				this.setInterviewId( (String)map.get(PersonInterviewMeta.INTERVIEW_ID));
				this.setSexCode( (String)map.get(PersonInterviewMeta.SEX_CODE));
				this.setCreateBy( (String)map.get(PersonInterviewMeta.CREATE_BY));
				this.setContactInformation( (String)map.get(PersonInterviewMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)map.get(PersonInterviewMeta.DELETED));
				this.setCreateTime( (Date)map.get(PersonInterviewMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(PersonInterviewMeta.DELETE_TIME));
				this.setName( (String)map.get(PersonInterviewMeta.NAME));
				this.setTenantId( (String)map.get(PersonInterviewMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonInterviewMeta.DELETE_BY));
				this.setStatus( (String)map.get(PersonInterviewMeta.STATUS));
				this.setFileId( (String)map.get(PersonInterviewMeta.FILE_ID));
				// others
				this.setInterviewMethodDict( (DictItem)map.get(PersonInterviewMeta.INTERVIEW_METHOD_DICT));
				this.setOrganization( (Organization)map.get(PersonInterviewMeta.ORGANIZATION));
				this.setSourceDict( (DictItem)map.get(PersonInterviewMeta.SOURCE_DICT));
				this.setEducationData( (DictItem)map.get(PersonInterviewMeta.EDUCATION_DATA));
				this.setSexDict( (DictItem)map.get(PersonInterviewMeta.SEX_DICT));
				this.setInterview( (Interview)map.get(PersonInterviewMeta.INTERVIEW));
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
			this.setBirthday(DataParser.parse(Date.class, r.getValue(PersonInterviewMeta.BIRTHDAY)));
			this.setNotes(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.NOTES)));
			this.setInterviewMethod(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.INTERVIEW_METHOD)));
			this.setEducationCode(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.EDUCATION_CODE)));
			this.setSource(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.SOURCE)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.ORG_ID)));
			this.setResult(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.RESULT)));
			this.setMajor(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.MAJOR)));
			this.setPos(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.POS)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.ID)));
			this.setGraduationSchool(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.GRADUATION_SCHOOL)));
			this.setInterviewDate(DataParser.parse(Date.class, r.getValue(PersonInterviewMeta.INTERVIEW_DATE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonInterviewMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonInterviewMeta.VERSION)));
			this.setInterviewId(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.INTERVIEW_ID)));
			this.setSexCode(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.SEX_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonInterviewMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonInterviewMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonInterviewMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.STATUS)));
			this.setFileId(DataParser.parse(String.class, r.getValue(PersonInterviewMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setBirthday( (Date)r.getValue(PersonInterviewMeta.BIRTHDAY));
				this.setNotes( (String)r.getValue(PersonInterviewMeta.NOTES));
				this.setInterviewMethod( (String)r.getValue(PersonInterviewMeta.INTERVIEW_METHOD));
				this.setEducationCode( (String)r.getValue(PersonInterviewMeta.EDUCATION_CODE));
				this.setSource( (String)r.getValue(PersonInterviewMeta.SOURCE));
				this.setOrgId( (String)r.getValue(PersonInterviewMeta.ORG_ID));
				this.setResult( (String)r.getValue(PersonInterviewMeta.RESULT));
				this.setMajor( (String)r.getValue(PersonInterviewMeta.MAJOR));
				this.setPos( (String)r.getValue(PersonInterviewMeta.POS));
				this.setUpdateBy( (String)r.getValue(PersonInterviewMeta.UPDATE_BY));
				this.setId( (String)r.getValue(PersonInterviewMeta.ID));
				this.setGraduationSchool( (String)r.getValue(PersonInterviewMeta.GRADUATION_SCHOOL));
				this.setInterviewDate( (Date)r.getValue(PersonInterviewMeta.INTERVIEW_DATE));
				this.setUpdateTime( (Date)r.getValue(PersonInterviewMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PersonInterviewMeta.VERSION));
				this.setInterviewId( (String)r.getValue(PersonInterviewMeta.INTERVIEW_ID));
				this.setSexCode( (String)r.getValue(PersonInterviewMeta.SEX_CODE));
				this.setCreateBy( (String)r.getValue(PersonInterviewMeta.CREATE_BY));
				this.setContactInformation( (String)r.getValue(PersonInterviewMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)r.getValue(PersonInterviewMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PersonInterviewMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(PersonInterviewMeta.DELETE_TIME));
				this.setName( (String)r.getValue(PersonInterviewMeta.NAME));
				this.setTenantId( (String)r.getValue(PersonInterviewMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonInterviewMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(PersonInterviewMeta.STATUS));
				this.setFileId( (String)r.getValue(PersonInterviewMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}