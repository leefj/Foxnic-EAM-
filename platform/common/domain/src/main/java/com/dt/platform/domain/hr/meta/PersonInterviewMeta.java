package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.PersonInterview;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Organization;
import com.dt.platform.domain.hr.Interview;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-20 13:28:40
 * @sign BD0BAF61D78A2D0F06E9C32F68D61580
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PersonInterviewMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 面试 , 类型: java.lang.String
	*/
	public static final String INTERVIEW_ID="interviewId";
	
	/**
	 * 面试 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> INTERVIEW_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,INTERVIEW_ID, java.lang.String.class, "面试", "面试", java.lang.String.class, null);
	
	/**
	 * 面试结果 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 面试结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,STATUS, java.lang.String.class, "面试结果", "面试结果", java.lang.String.class, null);
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,NAME, java.lang.String.class, "姓名", "姓名", java.lang.String.class, null);
	
	/**
	 * 性别 , 类型: java.lang.String
	*/
	public static final String SEX_CODE="sexCode";
	
	/**
	 * 性别 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> SEX_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,SEX_CODE, java.lang.String.class, "性别", "性别", java.lang.String.class, null);
	
	/**
	 * 出生日期 , 类型: java.util.Date
	*/
	public static final String BIRTHDAY="birthday";
	
	/**
	 * 出生日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.util.Date> BIRTHDAY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,BIRTHDAY, java.util.Date.class, "出生日期", "出生日期", java.util.Date.class, null);
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final String CONTACT_INFORMATION="contactInformation";
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> CONTACT_INFORMATION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,CONTACT_INFORMATION, java.lang.String.class, "联系方式", "联系方式", java.lang.String.class, null);
	
	/**
	 * 学历 , 类型: java.lang.String
	*/
	public static final String EDUCATION_CODE="educationCode";
	
	/**
	 * 学历 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> EDUCATION_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,EDUCATION_CODE, java.lang.String.class, "学历", "学历", java.lang.String.class, null);
	
	/**
	 * 毕业院校 , 类型: java.lang.String
	*/
	public static final String GRADUATION_SCHOOL="graduationSchool";
	
	/**
	 * 毕业院校 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> GRADUATION_SCHOOL_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,GRADUATION_SCHOOL, java.lang.String.class, "毕业院校", "毕业院校", java.lang.String.class, null);
	
	/**
	 * 所学专业 , 类型: java.lang.String
	*/
	public static final String MAJOR="major";
	
	/**
	 * 所学专业 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> MAJOR_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,MAJOR, java.lang.String.class, "所学专业", "所学专业", java.lang.String.class, null);
	
	/**
	 * 面试日期 , 类型: java.util.Date
	*/
	public static final String INTERVIEW_DATE="interviewDate";
	
	/**
	 * 面试日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.util.Date> INTERVIEW_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,INTERVIEW_DATE, java.util.Date.class, "面试日期", "面试日期", java.util.Date.class, null);
	
	/**
	 * 面试方式 , 类型: java.lang.String
	*/
	public static final String INTERVIEW_METHOD="interviewMethod";
	
	/**
	 * 面试方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> INTERVIEW_METHOD_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,INTERVIEW_METHOD, java.lang.String.class, "面试方式", "面试方式", java.lang.String.class, null);
	
	/**
	 * 应聘岗位 , 类型: java.lang.String
	*/
	public static final String POS="pos";
	
	/**
	 * 应聘岗位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> POS_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,POS, java.lang.String.class, "应聘岗位", "应聘岗位", java.lang.String.class, null);
	
	/**
	 * 招聘部门 , 类型: java.lang.String
	*/
	public static final String ORG_ID="orgId";
	
	/**
	 * 招聘部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,ORG_ID, java.lang.String.class, "招聘部门", "招聘部门", java.lang.String.class, null);
	
	/**
	 * 简历来源 , 类型: java.lang.String
	*/
	public static final String SOURCE="source";
	
	/**
	 * 简历来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> SOURCE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,SOURCE, java.lang.String.class, "简历来源", "简历来源", java.lang.String.class, null);
	
	/**
	 * 面试结论 , 类型: java.lang.String
	*/
	public static final String RESULT="result";
	
	/**
	 * 面试结论 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> RESULT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,RESULT, java.lang.String.class, "面试结论", "面试结论", java.lang.String.class, null);
	
	/**
	 * 简历 , 类型: java.lang.String
	*/
	public static final String FILE_ID="fileId";
	
	/**
	 * 简历 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> FILE_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,FILE_ID, java.lang.String.class, "简历", "简历", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * educationData , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String EDUCATION_DATA="educationData";
	
	/**
	 * educationData , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,org.github.foxnic.web.domain.system.DictItem> EDUCATION_DATA_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,EDUCATION_DATA, org.github.foxnic.web.domain.system.DictItem.class, "educationData", "educationData", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * sexDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String SEX_DICT="sexDict";
	
	/**
	 * sexDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,org.github.foxnic.web.domain.system.DictItem> SEX_DICT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,SEX_DICT, org.github.foxnic.web.domain.system.DictItem.class, "sexDict", "sexDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * interviewMethodDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String INTERVIEW_METHOD_DICT="interviewMethodDict";
	
	/**
	 * interviewMethodDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,org.github.foxnic.web.domain.system.DictItem> INTERVIEW_METHOD_DICT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,INTERVIEW_METHOD_DICT, org.github.foxnic.web.domain.system.DictItem.class, "interviewMethodDict", "interviewMethodDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * sourceDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String SOURCE_DICT="sourceDict";
	
	/**
	 * sourceDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,org.github.foxnic.web.domain.system.DictItem> SOURCE_DICT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,SOURCE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "sourceDict", "sourceDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * organization , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String ORGANIZATION="organization";
	
	/**
	 * organization , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,org.github.foxnic.web.domain.hrm.Organization> ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "organization", "organization", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * interview , 类型: com.dt.platform.domain.hr.Interview
	*/
	public static final String INTERVIEW="interview";
	
	/**
	 * interview , 类型: com.dt.platform.domain.hr.Interview
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonInterview,com.dt.platform.domain.hr.Interview> INTERVIEW_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonInterview.class ,INTERVIEW, com.dt.platform.domain.hr.Interview.class, "interview", "interview", com.dt.platform.domain.hr.Interview.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , INTERVIEW_ID , STATUS , NAME , SEX_CODE , BIRTHDAY , CONTACT_INFORMATION , EDUCATION_CODE , GRADUATION_SCHOOL , MAJOR , INTERVIEW_DATE , INTERVIEW_METHOD , POS , ORG_ID , SOURCE , RESULT , FILE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , EDUCATION_DATA , SEX_DICT , INTERVIEW_METHOD_DICT , SOURCE_DICT , ORGANIZATION , INTERVIEW };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.PersonInterview {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PersonInterview setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 面试
		 * @param interviewId 面试
		 * @return 当前对象
		*/
		public PersonInterview setInterviewId(String interviewId) {
			super.change(INTERVIEW_ID,super.getInterviewId(),interviewId);
			super.setInterviewId(interviewId);
			return this;
		}
		
		/**
		 * 设置 面试结果
		 * @param status 面试结果
		 * @return 当前对象
		*/
		public PersonInterview setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 姓名
		 * @param name 姓名
		 * @return 当前对象
		*/
		public PersonInterview setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 性别
		 * @param sexCode 性别
		 * @return 当前对象
		*/
		public PersonInterview setSexCode(String sexCode) {
			super.change(SEX_CODE,super.getSexCode(),sexCode);
			super.setSexCode(sexCode);
			return this;
		}
		
		/**
		 * 设置 出生日期
		 * @param birthday 出生日期
		 * @return 当前对象
		*/
		public PersonInterview setBirthday(Date birthday) {
			super.change(BIRTHDAY,super.getBirthday(),birthday);
			super.setBirthday(birthday);
			return this;
		}
		
		/**
		 * 设置 联系方式
		 * @param contactInformation 联系方式
		 * @return 当前对象
		*/
		public PersonInterview setContactInformation(String contactInformation) {
			super.change(CONTACT_INFORMATION,super.getContactInformation(),contactInformation);
			super.setContactInformation(contactInformation);
			return this;
		}
		
		/**
		 * 设置 学历
		 * @param educationCode 学历
		 * @return 当前对象
		*/
		public PersonInterview setEducationCode(String educationCode) {
			super.change(EDUCATION_CODE,super.getEducationCode(),educationCode);
			super.setEducationCode(educationCode);
			return this;
		}
		
		/**
		 * 设置 毕业院校
		 * @param graduationSchool 毕业院校
		 * @return 当前对象
		*/
		public PersonInterview setGraduationSchool(String graduationSchool) {
			super.change(GRADUATION_SCHOOL,super.getGraduationSchool(),graduationSchool);
			super.setGraduationSchool(graduationSchool);
			return this;
		}
		
		/**
		 * 设置 所学专业
		 * @param major 所学专业
		 * @return 当前对象
		*/
		public PersonInterview setMajor(String major) {
			super.change(MAJOR,super.getMajor(),major);
			super.setMajor(major);
			return this;
		}
		
		/**
		 * 设置 面试日期
		 * @param interviewDate 面试日期
		 * @return 当前对象
		*/
		public PersonInterview setInterviewDate(Date interviewDate) {
			super.change(INTERVIEW_DATE,super.getInterviewDate(),interviewDate);
			super.setInterviewDate(interviewDate);
			return this;
		}
		
		/**
		 * 设置 面试方式
		 * @param interviewMethod 面试方式
		 * @return 当前对象
		*/
		public PersonInterview setInterviewMethod(String interviewMethod) {
			super.change(INTERVIEW_METHOD,super.getInterviewMethod(),interviewMethod);
			super.setInterviewMethod(interviewMethod);
			return this;
		}
		
		/**
		 * 设置 应聘岗位
		 * @param pos 应聘岗位
		 * @return 当前对象
		*/
		public PersonInterview setPos(String pos) {
			super.change(POS,super.getPos(),pos);
			super.setPos(pos);
			return this;
		}
		
		/**
		 * 设置 招聘部门
		 * @param orgId 招聘部门
		 * @return 当前对象
		*/
		public PersonInterview setOrgId(String orgId) {
			super.change(ORG_ID,super.getOrgId(),orgId);
			super.setOrgId(orgId);
			return this;
		}
		
		/**
		 * 设置 简历来源
		 * @param source 简历来源
		 * @return 当前对象
		*/
		public PersonInterview setSource(String source) {
			super.change(SOURCE,super.getSource(),source);
			super.setSource(source);
			return this;
		}
		
		/**
		 * 设置 面试结论
		 * @param result 面试结论
		 * @return 当前对象
		*/
		public PersonInterview setResult(String result) {
			super.change(RESULT,super.getResult(),result);
			super.setResult(result);
			return this;
		}
		
		/**
		 * 设置 简历
		 * @param fileId 简历
		 * @return 当前对象
		*/
		public PersonInterview setFileId(String fileId) {
			super.change(FILE_ID,super.getFileId(),fileId);
			super.setFileId(fileId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public PersonInterview setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PersonInterview setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PersonInterview setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PersonInterview setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PersonInterview setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PersonInterview setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PersonInterview setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PersonInterview setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PersonInterview setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PersonInterview setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 educationData
		 * @param educationData educationData
		 * @return 当前对象
		*/
		public PersonInterview setEducationData(DictItem educationData) {
			super.change(EDUCATION_DATA,super.getEducationData(),educationData);
			super.setEducationData(educationData);
			return this;
		}
		
		/**
		 * 设置 sexDict
		 * @param sexDict sexDict
		 * @return 当前对象
		*/
		public PersonInterview setSexDict(DictItem sexDict) {
			super.change(SEX_DICT,super.getSexDict(),sexDict);
			super.setSexDict(sexDict);
			return this;
		}
		
		/**
		 * 设置 interviewMethodDict
		 * @param interviewMethodDict interviewMethodDict
		 * @return 当前对象
		*/
		public PersonInterview setInterviewMethodDict(DictItem interviewMethodDict) {
			super.change(INTERVIEW_METHOD_DICT,super.getInterviewMethodDict(),interviewMethodDict);
			super.setInterviewMethodDict(interviewMethodDict);
			return this;
		}
		
		/**
		 * 设置 sourceDict
		 * @param sourceDict sourceDict
		 * @return 当前对象
		*/
		public PersonInterview setSourceDict(DictItem sourceDict) {
			super.change(SOURCE_DICT,super.getSourceDict(),sourceDict);
			super.setSourceDict(sourceDict);
			return this;
		}
		
		/**
		 * 设置 organization
		 * @param organization organization
		 * @return 当前对象
		*/
		public PersonInterview setOrganization(Organization organization) {
			super.change(ORGANIZATION,super.getOrganization(),organization);
			super.setOrganization(organization);
			return this;
		}
		
		/**
		 * 设置 interview
		 * @param interview interview
		 * @return 当前对象
		*/
		public PersonInterview setInterview(Interview interview) {
			super.change(INTERVIEW,super.getInterview(),interview);
			super.setInterview(interview);
			return this;
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
			$$proxy$$ inst=new $$proxy$$();
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

	}
}