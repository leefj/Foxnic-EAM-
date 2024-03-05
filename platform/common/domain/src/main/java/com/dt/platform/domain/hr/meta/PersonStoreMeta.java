package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.PersonStore;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.system.DictItem;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-20 12:35:32
 * @sign 5480AD2FC58276D6DA91387A81ED2998
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PersonStoreMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,NAME, java.lang.String.class, "姓名", "姓名", java.lang.String.class, null);
	
	/**
	 * 性别 , 类型: java.lang.String
	*/
	public static final String SEX_CODE="sexCode";
	
	/**
	 * 性别 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> SEX_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,SEX_CODE, java.lang.String.class, "性别", "性别", java.lang.String.class, null);
	
	/**
	 * 出生日期 , 类型: java.util.Date
	*/
	public static final String BIRTHDAY="birthday";
	
	/**
	 * 出生日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.util.Date> BIRTHDAY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,BIRTHDAY, java.util.Date.class, "出生日期", "出生日期", java.util.Date.class, null);
	
	/**
	 * 籍贯 , 类型: java.lang.String
	*/
	public static final String NATIVE_PLACE_CODE="nativePlaceCode";
	
	/**
	 * 籍贯 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> NATIVE_PLACE_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,NATIVE_PLACE_CODE, java.lang.String.class, "籍贯", "籍贯", java.lang.String.class, null);
	
	/**
	 * 民族 , 类型: java.lang.String
	*/
	public static final String NATION_CODE="nationCode";
	
	/**
	 * 民族 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> NATION_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,NATION_CODE, java.lang.String.class, "民族", "民族", java.lang.String.class, null);
	
	/**
	 * 婚姻状况 , 类型: java.lang.String
	*/
	public static final String MARITAL_STATUS="maritalStatus";
	
	/**
	 * 婚姻状况 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> MARITAL_STATUS_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,MARITAL_STATUS, java.lang.String.class, "婚姻状况", "婚姻状况", java.lang.String.class, null);
	
	/**
	 * 身份证 , 类型: java.lang.String
	*/
	public static final String IDENTITY_CARD="identityCard";
	
	/**
	 * 身份证 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> IDENTITY_CARD_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,IDENTITY_CARD, java.lang.String.class, "身份证", "身份证", java.lang.String.class, null);
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final String CONTACT_INFORMATION="contactInformation";
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> CONTACT_INFORMATION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,CONTACT_INFORMATION, java.lang.String.class, "联系方式", "联系方式", java.lang.String.class, null);
	
	/**
	 * 电子邮件 , 类型: java.lang.String
	*/
	public static final String EMAIL="email";
	
	/**
	 * 电子邮件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> EMAIL_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,EMAIL, java.lang.String.class, "电子邮件", "电子邮件", java.lang.String.class, null);
	
	/**
	 * 学历 , 类型: java.lang.String
	*/
	public static final String EDUCATION_CODE="educationCode";
	
	/**
	 * 学历 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> EDUCATION_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,EDUCATION_CODE, java.lang.String.class, "学历", "学历", java.lang.String.class, null);
	
	/**
	 * 毕业院校 , 类型: java.lang.String
	*/
	public static final String GRADUATION_SCHOOL="graduationSchool";
	
	/**
	 * 毕业院校 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> GRADUATION_SCHOOL_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,GRADUATION_SCHOOL, java.lang.String.class, "毕业院校", "毕业院校", java.lang.String.class, null);
	
	/**
	 * 所学专业 , 类型: java.lang.String
	*/
	public static final String MAJOR="major";
	
	/**
	 * 所学专业 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> MAJOR_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,MAJOR, java.lang.String.class, "所学专业", "所学专业", java.lang.String.class, null);
	
	/**
	 * 毕业时间 , 类型: java.util.Date
	*/
	public static final String GRADUATION_DATE="graduationDate";
	
	/**
	 * 毕业时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.util.Date> GRADUATION_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,GRADUATION_DATE, java.util.Date.class, "毕业时间", "毕业时间", java.util.Date.class, null);
	
	/**
	 * 所学外语 , 类型: java.lang.String
	*/
	public static final String FOREIGN_LANGUAGE="foreignLanguage";
	
	/**
	 * 所学外语 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> FOREIGN_LANGUAGE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,FOREIGN_LANGUAGE, java.lang.String.class, "所学外语", "所学外语", java.lang.String.class, null);
	
	/**
	 * 外语证书 , 类型: java.lang.String
	*/
	public static final String FOREIGN_LANGUAGE_LEVEL="foreignLanguageLevel";
	
	/**
	 * 外语证书 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> FOREIGN_LANGUAGE_LEVEL_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,FOREIGN_LANGUAGE_LEVEL, java.lang.String.class, "外语证书", "外语证书", java.lang.String.class, null);
	
	/**
	 * 所获证书 , 类型: java.lang.String
	*/
	public static final String CERTIFICATE="certificate";
	
	/**
	 * 所获证书 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> CERTIFICATE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,CERTIFICATE, java.lang.String.class, "所获证书", "所获证书", java.lang.String.class, null);
	
	/**
	 * 计算机能力 , 类型: java.lang.String
	*/
	public static final String COMPUTER_ABILITY="computerAbility";
	
	/**
	 * 计算机能力 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> COMPUTER_ABILITY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,COMPUTER_ABILITY, java.lang.String.class, "计算机能力", "计算机能力", java.lang.String.class, null);
	
	/**
	 * 政治面貌 , 类型: java.lang.String
	*/
	public static final String POLITIC_COUNTENANCE_CODE="politicCountenanceCode";
	
	/**
	 * 政治面貌 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> POLITIC_COUNTENANCE_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,POLITIC_COUNTENANCE_CODE, java.lang.String.class, "政治面貌", "政治面貌", java.lang.String.class, null);
	
	/**
	 * 入党时间 , 类型: java.util.Date
	*/
	public static final String JOIN_PART_DATE="joinPartDate";
	
	/**
	 * 入党时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.util.Date> JOIN_PART_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,JOIN_PART_DATE, java.util.Date.class, "入党时间", "入党时间", java.util.Date.class, null);
	
	/**
	 * 参加工作时间 , 类型: java.util.Date
	*/
	public static final String FIRST_WORK_DATE="firstWorkDate";
	
	/**
	 * 参加工作时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.util.Date> FIRST_WORK_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,FIRST_WORK_DATE, java.util.Date.class, "参加工作时间", "参加工作时间", java.util.Date.class, null);
	
	/**
	 * 特长 , 类型: java.lang.String
	*/
	public static final String SPECIAL_SKILL="specialSkill";
	
	/**
	 * 特长 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> SPECIAL_SKILL_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,SPECIAL_SKILL, java.lang.String.class, "特长", "特长", java.lang.String.class, null);
	
	/**
	 * 对工作要求 , 类型: java.lang.String
	*/
	public static final String JOB_REQUIREMENT="jobRequirement";
	
	/**
	 * 对工作要求 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> JOB_REQUIREMENT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,JOB_REQUIREMENT, java.lang.String.class, "对工作要求", "对工作要求", java.lang.String.class, null);
	
	/**
	 * 目前月薪 , 类型: java.math.BigDecimal
	*/
	public static final String NOW_SALARY="nowSalary";
	
	/**
	 * 目前月薪 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.math.BigDecimal> NOW_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,NOW_SALARY, java.math.BigDecimal.class, "目前月薪", "目前月薪", java.math.BigDecimal.class, null);
	
	/**
	 * 期望月薪 , 类型: java.math.BigDecimal
	*/
	public static final String FOR_SALARY="forSalary";
	
	/**
	 * 期望月薪 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.math.BigDecimal> FOR_SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,FOR_SALARY, java.math.BigDecimal.class, "期望月薪", "期望月薪", java.math.BigDecimal.class, null);
	
	/**
	 * 招聘来源 , 类型: java.lang.String
	*/
	public static final String SOURCE="source";
	
	/**
	 * 招聘来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> SOURCE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,SOURCE, java.lang.String.class, "招聘来源", "招聘来源", java.lang.String.class, null);
	
	/**
	 * 评审结果 , 类型: java.lang.String
	*/
	public static final String REVIEW_RESULT="reviewResult";
	
	/**
	 * 评审结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> REVIEW_RESULT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,REVIEW_RESULT, java.lang.String.class, "评审结果", "评审结果", java.lang.String.class, null);
	
	/**
	 * 应聘岗位 , 类型: java.lang.String
	*/
	public static final String POSITION="position";
	
	/**
	 * 应聘岗位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> POSITION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,POSITION, java.lang.String.class, "应聘岗位", "应聘岗位", java.lang.String.class, null);
	
	/**
	 * 照片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 照片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,PICTURE_ID, java.lang.String.class, "照片", "照片", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String FILE_ID="fileId";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> FILE_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,FILE_ID, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTE="note";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> NOTE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,NOTE, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 归属 , 类型: java.lang.String
	*/
	public static final String OWNER_CODE="ownerCode";
	
	/**
	 * 归属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> OWNER_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,OWNER_CODE, java.lang.String.class, "归属", "归属", java.lang.String.class, null);
	
	/**
	 * 面试结果 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 面试结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,STATUS, java.lang.String.class, "面试结果", "面试结果", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * sexDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String SEX_DICT="sexDict";
	
	/**
	 * sexDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,org.github.foxnic.web.domain.system.DictItem> SEX_DICT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,SEX_DICT, org.github.foxnic.web.domain.system.DictItem.class, "sexDict", "sexDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * maritalStatusDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String MARITAL_STATUS_DICT="maritalStatusDict";
	
	/**
	 * maritalStatusDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,org.github.foxnic.web.domain.system.DictItem> MARITAL_STATUS_DICT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,MARITAL_STATUS_DICT, org.github.foxnic.web.domain.system.DictItem.class, "maritalStatusDict", "maritalStatusDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * educationData , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String EDUCATION_DATA="educationData";
	
	/**
	 * educationData , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,org.github.foxnic.web.domain.system.DictItem> EDUCATION_DATA_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,EDUCATION_DATA, org.github.foxnic.web.domain.system.DictItem.class, "educationData", "educationData", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * politicCountenanceData , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String POLITIC_COUNTENANCE_DATA="politicCountenanceData";
	
	/**
	 * politicCountenanceData , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonStore,org.github.foxnic.web.domain.system.DictItem> POLITIC_COUNTENANCE_DATA_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonStore.class ,POLITIC_COUNTENANCE_DATA, org.github.foxnic.web.domain.system.DictItem.class, "politicCountenanceData", "politicCountenanceData", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , SEX_CODE , BIRTHDAY , NATIVE_PLACE_CODE , NATION_CODE , MARITAL_STATUS , IDENTITY_CARD , CONTACT_INFORMATION , EMAIL , EDUCATION_CODE , GRADUATION_SCHOOL , MAJOR , GRADUATION_DATE , FOREIGN_LANGUAGE , FOREIGN_LANGUAGE_LEVEL , CERTIFICATE , COMPUTER_ABILITY , POLITIC_COUNTENANCE_CODE , JOIN_PART_DATE , FIRST_WORK_DATE , SPECIAL_SKILL , JOB_REQUIREMENT , NOW_SALARY , FOR_SALARY , SOURCE , REVIEW_RESULT , POSITION , PICTURE_ID , FILE_ID , NOTE , OWNER_CODE , STATUS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SEX_DICT , MARITAL_STATUS_DICT , EDUCATION_DATA , POLITIC_COUNTENANCE_DATA };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.PersonStore {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PersonStore setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 姓名
		 * @param name 姓名
		 * @return 当前对象
		*/
		public PersonStore setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 性别
		 * @param sexCode 性别
		 * @return 当前对象
		*/
		public PersonStore setSexCode(String sexCode) {
			super.change(SEX_CODE,super.getSexCode(),sexCode);
			super.setSexCode(sexCode);
			return this;
		}
		
		/**
		 * 设置 出生日期
		 * @param birthday 出生日期
		 * @return 当前对象
		*/
		public PersonStore setBirthday(Date birthday) {
			super.change(BIRTHDAY,super.getBirthday(),birthday);
			super.setBirthday(birthday);
			return this;
		}
		
		/**
		 * 设置 籍贯
		 * @param nativePlaceCode 籍贯
		 * @return 当前对象
		*/
		public PersonStore setNativePlaceCode(String nativePlaceCode) {
			super.change(NATIVE_PLACE_CODE,super.getNativePlaceCode(),nativePlaceCode);
			super.setNativePlaceCode(nativePlaceCode);
			return this;
		}
		
		/**
		 * 设置 民族
		 * @param nationCode 民族
		 * @return 当前对象
		*/
		public PersonStore setNationCode(String nationCode) {
			super.change(NATION_CODE,super.getNationCode(),nationCode);
			super.setNationCode(nationCode);
			return this;
		}
		
		/**
		 * 设置 婚姻状况
		 * @param maritalStatus 婚姻状况
		 * @return 当前对象
		*/
		public PersonStore setMaritalStatus(String maritalStatus) {
			super.change(MARITAL_STATUS,super.getMaritalStatus(),maritalStatus);
			super.setMaritalStatus(maritalStatus);
			return this;
		}
		
		/**
		 * 设置 身份证
		 * @param identityCard 身份证
		 * @return 当前对象
		*/
		public PersonStore setIdentityCard(String identityCard) {
			super.change(IDENTITY_CARD,super.getIdentityCard(),identityCard);
			super.setIdentityCard(identityCard);
			return this;
		}
		
		/**
		 * 设置 联系方式
		 * @param contactInformation 联系方式
		 * @return 当前对象
		*/
		public PersonStore setContactInformation(String contactInformation) {
			super.change(CONTACT_INFORMATION,super.getContactInformation(),contactInformation);
			super.setContactInformation(contactInformation);
			return this;
		}
		
		/**
		 * 设置 电子邮件
		 * @param email 电子邮件
		 * @return 当前对象
		*/
		public PersonStore setEmail(String email) {
			super.change(EMAIL,super.getEmail(),email);
			super.setEmail(email);
			return this;
		}
		
		/**
		 * 设置 学历
		 * @param educationCode 学历
		 * @return 当前对象
		*/
		public PersonStore setEducationCode(String educationCode) {
			super.change(EDUCATION_CODE,super.getEducationCode(),educationCode);
			super.setEducationCode(educationCode);
			return this;
		}
		
		/**
		 * 设置 毕业院校
		 * @param graduationSchool 毕业院校
		 * @return 当前对象
		*/
		public PersonStore setGraduationSchool(String graduationSchool) {
			super.change(GRADUATION_SCHOOL,super.getGraduationSchool(),graduationSchool);
			super.setGraduationSchool(graduationSchool);
			return this;
		}
		
		/**
		 * 设置 所学专业
		 * @param major 所学专业
		 * @return 当前对象
		*/
		public PersonStore setMajor(String major) {
			super.change(MAJOR,super.getMajor(),major);
			super.setMajor(major);
			return this;
		}
		
		/**
		 * 设置 毕业时间
		 * @param graduationDate 毕业时间
		 * @return 当前对象
		*/
		public PersonStore setGraduationDate(Date graduationDate) {
			super.change(GRADUATION_DATE,super.getGraduationDate(),graduationDate);
			super.setGraduationDate(graduationDate);
			return this;
		}
		
		/**
		 * 设置 所学外语
		 * @param foreignLanguage 所学外语
		 * @return 当前对象
		*/
		public PersonStore setForeignLanguage(String foreignLanguage) {
			super.change(FOREIGN_LANGUAGE,super.getForeignLanguage(),foreignLanguage);
			super.setForeignLanguage(foreignLanguage);
			return this;
		}
		
		/**
		 * 设置 外语证书
		 * @param foreignLanguageLevel 外语证书
		 * @return 当前对象
		*/
		public PersonStore setForeignLanguageLevel(String foreignLanguageLevel) {
			super.change(FOREIGN_LANGUAGE_LEVEL,super.getForeignLanguageLevel(),foreignLanguageLevel);
			super.setForeignLanguageLevel(foreignLanguageLevel);
			return this;
		}
		
		/**
		 * 设置 所获证书
		 * @param certificate 所获证书
		 * @return 当前对象
		*/
		public PersonStore setCertificate(String certificate) {
			super.change(CERTIFICATE,super.getCertificate(),certificate);
			super.setCertificate(certificate);
			return this;
		}
		
		/**
		 * 设置 计算机能力
		 * @param computerAbility 计算机能力
		 * @return 当前对象
		*/
		public PersonStore setComputerAbility(String computerAbility) {
			super.change(COMPUTER_ABILITY,super.getComputerAbility(),computerAbility);
			super.setComputerAbility(computerAbility);
			return this;
		}
		
		/**
		 * 设置 政治面貌
		 * @param politicCountenanceCode 政治面貌
		 * @return 当前对象
		*/
		public PersonStore setPoliticCountenanceCode(String politicCountenanceCode) {
			super.change(POLITIC_COUNTENANCE_CODE,super.getPoliticCountenanceCode(),politicCountenanceCode);
			super.setPoliticCountenanceCode(politicCountenanceCode);
			return this;
		}
		
		/**
		 * 设置 入党时间
		 * @param joinPartDate 入党时间
		 * @return 当前对象
		*/
		public PersonStore setJoinPartDate(Date joinPartDate) {
			super.change(JOIN_PART_DATE,super.getJoinPartDate(),joinPartDate);
			super.setJoinPartDate(joinPartDate);
			return this;
		}
		
		/**
		 * 设置 参加工作时间
		 * @param firstWorkDate 参加工作时间
		 * @return 当前对象
		*/
		public PersonStore setFirstWorkDate(Date firstWorkDate) {
			super.change(FIRST_WORK_DATE,super.getFirstWorkDate(),firstWorkDate);
			super.setFirstWorkDate(firstWorkDate);
			return this;
		}
		
		/**
		 * 设置 特长
		 * @param specialSkill 特长
		 * @return 当前对象
		*/
		public PersonStore setSpecialSkill(String specialSkill) {
			super.change(SPECIAL_SKILL,super.getSpecialSkill(),specialSkill);
			super.setSpecialSkill(specialSkill);
			return this;
		}
		
		/**
		 * 设置 对工作要求
		 * @param jobRequirement 对工作要求
		 * @return 当前对象
		*/
		public PersonStore setJobRequirement(String jobRequirement) {
			super.change(JOB_REQUIREMENT,super.getJobRequirement(),jobRequirement);
			super.setJobRequirement(jobRequirement);
			return this;
		}
		
		/**
		 * 设置 目前月薪
		 * @param nowSalary 目前月薪
		 * @return 当前对象
		*/
		public PersonStore setNowSalary(BigDecimal nowSalary) {
			super.change(NOW_SALARY,super.getNowSalary(),nowSalary);
			super.setNowSalary(nowSalary);
			return this;
		}
		
		/**
		 * 设置 期望月薪
		 * @param forSalary 期望月薪
		 * @return 当前对象
		*/
		public PersonStore setForSalary(BigDecimal forSalary) {
			super.change(FOR_SALARY,super.getForSalary(),forSalary);
			super.setForSalary(forSalary);
			return this;
		}
		
		/**
		 * 设置 招聘来源
		 * @param source 招聘来源
		 * @return 当前对象
		*/
		public PersonStore setSource(String source) {
			super.change(SOURCE,super.getSource(),source);
			super.setSource(source);
			return this;
		}
		
		/**
		 * 设置 评审结果
		 * @param reviewResult 评审结果
		 * @return 当前对象
		*/
		public PersonStore setReviewResult(String reviewResult) {
			super.change(REVIEW_RESULT,super.getReviewResult(),reviewResult);
			super.setReviewResult(reviewResult);
			return this;
		}
		
		/**
		 * 设置 应聘岗位
		 * @param position 应聘岗位
		 * @return 当前对象
		*/
		public PersonStore setPosition(String position) {
			super.change(POSITION,super.getPosition(),position);
			super.setPosition(position);
			return this;
		}
		
		/**
		 * 设置 照片
		 * @param pictureId 照片
		 * @return 当前对象
		*/
		public PersonStore setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param fileId 附件
		 * @return 当前对象
		*/
		public PersonStore setFileId(String fileId) {
			super.change(FILE_ID,super.getFileId(),fileId);
			super.setFileId(fileId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param note 备注
		 * @return 当前对象
		*/
		public PersonStore setNote(String note) {
			super.change(NOTE,super.getNote(),note);
			super.setNote(note);
			return this;
		}
		
		/**
		 * 设置 归属
		 * @param ownerCode 归属
		 * @return 当前对象
		*/
		public PersonStore setOwnerCode(String ownerCode) {
			super.change(OWNER_CODE,super.getOwnerCode(),ownerCode);
			super.setOwnerCode(ownerCode);
			return this;
		}
		
		/**
		 * 设置 面试结果
		 * @param status 面试结果
		 * @return 当前对象
		*/
		public PersonStore setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PersonStore setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PersonStore setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PersonStore setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PersonStore setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PersonStore setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PersonStore setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PersonStore setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PersonStore setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PersonStore setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 sexDict
		 * @param sexDict sexDict
		 * @return 当前对象
		*/
		public PersonStore setSexDict(DictItem sexDict) {
			super.change(SEX_DICT,super.getSexDict(),sexDict);
			super.setSexDict(sexDict);
			return this;
		}
		
		/**
		 * 设置 maritalStatusDict
		 * @param maritalStatusDict maritalStatusDict
		 * @return 当前对象
		*/
		public PersonStore setMaritalStatusDict(DictItem maritalStatusDict) {
			super.change(MARITAL_STATUS_DICT,super.getMaritalStatusDict(),maritalStatusDict);
			super.setMaritalStatusDict(maritalStatusDict);
			return this;
		}
		
		/**
		 * 设置 educationData
		 * @param educationData educationData
		 * @return 当前对象
		*/
		public PersonStore setEducationData(DictItem educationData) {
			super.change(EDUCATION_DATA,super.getEducationData(),educationData);
			super.setEducationData(educationData);
			return this;
		}
		
		/**
		 * 设置 politicCountenanceData
		 * @param politicCountenanceData politicCountenanceData
		 * @return 当前对象
		*/
		public PersonStore setPoliticCountenanceData(DictItem politicCountenanceData) {
			super.change(POLITIC_COUNTENANCE_DATA,super.getPoliticCountenanceData(),politicCountenanceData);
			super.setPoliticCountenanceData(politicCountenanceData);
			return this;
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
			$$proxy$$ inst=new $$proxy$$();
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

	}
}