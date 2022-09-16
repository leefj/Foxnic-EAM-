package com.dt.platform.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2022-09-16 16:23:57
 * @author 金杰 , maillank@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class HrTables {
	
	/**
	 * 人员信息
	*/
	public static class HR_PERSON extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 员工
		*/
		public static final DBField EMPLOY_ID = new DBField(DBDataType.STRING , "employ_id","employId","员工","员工",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField JOB_NUMBER = new DBField(DBDataType.STRING , "job_number","jobNumber","工号","工号",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","姓名","姓名",false,false,true);
		
		/**
		 * 性别
		*/
		public static final DBField SEX = new DBField(DBDataType.STRING , "sex","sex","性别","性别",false,false,true);
		
		/**
		 * 出生日期
		*/
		public static final DBField BIRTHDAY = new DBField(DBDataType.DATE , "birthday","birthday","出生日期","出生日期",false,false,true);
		
		/**
		 * 籍贯
		*/
		public static final DBField NATIVE_PLACE_CODE = new DBField(DBDataType.STRING , "native_place_code","nativePlaceCode","籍贯","籍贯",false,false,true);
		
		/**
		 * 民族
		*/
		public static final DBField NATION_CODE = new DBField(DBDataType.STRING , "nation_code","nationCode","民族","民族",false,false,true);
		
		/**
		 * 婚姻状况
		*/
		public static final DBField MARITAL_STATUS = new DBField(DBDataType.STRING , "marital_status","maritalStatus","婚姻状况","婚姻状况",false,false,true);
		
		/**
		 * 员工状态
		*/
		public static final DBField EMPLOYEE_STATUS = new DBField(DBDataType.STRING , "employee_status","employeeStatus","员工状态","员工状态",false,false,true);
		
		/**
		 * 身份证号
		*/
		public static final DBField IDENTITY_CARD = new DBField(DBDataType.STRING , "identity_card","identityCard","身份证号","身份证号",false,false,true);
		
		/**
		 * 联系方式
		*/
		public static final DBField CONTACT_INFORMATION = new DBField(DBDataType.STRING , "contact_information","contactInformation","联系方式","联系方式",false,false,true);
		
		/**
		 * 电子邮件
		*/
		public static final DBField EMAIL = new DBField(DBDataType.STRING , "email","email","电子邮件","电子邮件",false,false,true);
		
		/**
		 * 紧急联系人
		*/
		public static final DBField EMERGENCY_CONTACT = new DBField(DBDataType.STRING , "emergency_contact","emergencyContact","紧急联系人","紧急联系人",false,false,true);
		
		/**
		 * 紧急人电话
		*/
		public static final DBField EMERGENCY_CONTACT_NO = new DBField(DBDataType.STRING , "emergency_contact_no","emergencyContactNo","紧急人电话","紧急人电话",false,false,true);
		
		/**
		 * 家庭地址
		*/
		public static final DBField HOME_ADDRESS = new DBField(DBDataType.STRING , "home_address","homeAddress","家庭地址","家庭地址",false,false,true);
		
		/**
		 * 微信号
		*/
		public static final DBField WEIXIN_ID = new DBField(DBDataType.STRING , "weixin_id","weixinId","微信号","微信号",false,false,true);
		
		/**
		 * 学历
		*/
		public static final DBField EDUCATION_CODE = new DBField(DBDataType.STRING , "education_code","educationCode","学历","学历",false,false,true);
		
		/**
		 * 毕业院校
		*/
		public static final DBField GRADUATION_SCHOOL = new DBField(DBDataType.STRING , "graduation_school","graduationSchool","毕业院校","毕业院校",false,false,true);
		
		/**
		 * 所学专业
		*/
		public static final DBField MAJOR = new DBField(DBDataType.STRING , "major","major","所学专业","所学专业",false,false,true);
		
		/**
		 * 毕业时间
		*/
		public static final DBField GRADUATION_DATE = new DBField(DBDataType.DATE , "graduation_date","graduationDate","毕业时间","毕业时间",false,false,true);
		
		/**
		 * 所学外语
		*/
		public static final DBField FOREIGN_LANGUAGE = new DBField(DBDataType.STRING , "foreign_language","foreignLanguage","所学外语","所学外语",false,false,true);
		
		/**
		 * 外语证书
		*/
		public static final DBField FOREIGN_LANGUAGE_LEVEL = new DBField(DBDataType.STRING , "foreign_language_level","foreignLanguageLevel","外语证书","外语证书",false,false,true);
		
		/**
		 * 计算机能力
		*/
		public static final DBField COMPUTER_ABILITY = new DBField(DBDataType.STRING , "computer_ability","computerAbility","计算机能力","计算机能力",false,false,true);
		
		/**
		 * 计算机等级
		*/
		public static final DBField COMPUTER_LEVEL = new DBField(DBDataType.STRING , "computer_level","computerLevel","计算机等级","计算机等级",false,false,true);
		
		/**
		 * 政治面貌
		*/
		public static final DBField POLITIC_COUNTENANCE_CODE = new DBField(DBDataType.STRING , "politic_countenance_code","politicCountenanceCode","政治面貌","政治面貌",false,false,true);
		
		/**
		 * 入党时间
		*/
		public static final DBField JOIN_PART_DATE = new DBField(DBDataType.DATE , "join_part_date","joinPartDate","入党时间","入党时间",false,false,true);
		
		/**
		 * 血型
		*/
		public static final DBField BLOOD_TYPE = new DBField(DBDataType.STRING , "blood_type","bloodType","血型","血型",false,false,true);
		
		/**
		 * 身高
		*/
		public static final DBField BODY_HEIGHT = new DBField(DBDataType.INTEGER , "body_height","bodyHeight","身高","身高",false,false,true);
		
		/**
		 * 体重
		*/
		public static final DBField BODY_WEIGHT = new DBField(DBDataType.INTEGER , "body_weight","bodyWeight","体重","体重",false,false,true);
		
		/**
		 * 入职日期
		*/
		public static final DBField EMPLOYMENT_DATE = new DBField(DBDataType.DATE , "employment_date","employmentDate","入职日期","入职日期",false,false,true);
		
		/**
		 * 转正日期
		*/
		public static final DBField EMPLOYMENT_CONFIRM_DATE = new DBField(DBDataType.DATE , "employment_confirm_date","employmentConfirmDate","转正日期","转正日期",false,false,true);
		
		/**
		 * 初次日期
		*/
		public static final DBField FIRST_EMPLOYMENT_DATE = new DBField(DBDataType.DATE , "first_employment_date","firstEmploymentDate","初次日期","初次日期",false,false,true);
		
		/**
		 * 参加工作时间
		*/
		public static final DBField FIRST_WORK_DATE = new DBField(DBDataType.DATE , "first_work_date","firstWorkDate","参加工作时间","参加工作时间",false,false,true);
		
		/**
		 * 员工部门
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","员工部门","员工部门",false,false,true);
		
		/**
		 * 员工岗位
		*/
		public static final DBField POSITION_ID = new DBField(DBDataType.STRING , "position_id","positionId","员工岗位","员工岗位",false,false,true);
		
		/**
		 * 员工职称
		*/
		public static final DBField EMPLOYEE_TITLE_ID = new DBField(DBDataType.STRING , "employee_title_id","employeeTitleId","员工职称","员工职称",false,false,true);
		
		/**
		 * 员工职级
		*/
		public static final DBField RANK_CODE = new DBField(DBDataType.STRING , "rank_code","rankCode","员工职级","员工职级",false,false,true);
		
		/**
		 * 员工工种
		*/
		public static final DBField WORK_KIND_CODE = new DBField(DBDataType.STRING , "work_kind_code","workKindCode","员工工种","员工工种",false,false,true);
		
		/**
		 * 离职日期
		*/
		public static final DBField LEAVE_DATE = new DBField(DBDataType.DATE , "leave_date","leaveDate","离职日期","离职日期",false,false,true);
		
		/**
		 * 离职原因
		*/
		public static final DBField LEAVE_RESON = new DBField(DBDataType.STRING , "leave_reson","leaveReson","离职原因","离职原因",false,false,true);
		
		/**
		 * 工资卡开户行
		*/
		public static final DBField PAYROLL_CARD_BANK_CODE = new DBField(DBDataType.STRING , "payroll_card_bank_code","payrollCardBankCode","工资卡开户行","工资卡开户行",false,false,true);
		
		/**
		 * 工资卡帐号
		*/
		public static final DBField PAYROLL_CARD = new DBField(DBDataType.STRING , "payroll_card","payrollCard","工资卡帐号","工资卡帐号",false,false,true);
		
		/**
		 * 照片
		*/
		public static final DBField PERSON_PICTURE_ID = new DBField(DBDataType.STRING , "person_picture_id","personPictureId","照片","照片",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_PERSON() {
			this.init($NAME,"人员信息" , ID , EMPLOY_ID , JOB_NUMBER , NAME , SEX , BIRTHDAY , NATIVE_PLACE_CODE , NATION_CODE , MARITAL_STATUS , EMPLOYEE_STATUS , IDENTITY_CARD , CONTACT_INFORMATION , EMAIL , EMERGENCY_CONTACT , EMERGENCY_CONTACT_NO , HOME_ADDRESS , WEIXIN_ID , EDUCATION_CODE , GRADUATION_SCHOOL , MAJOR , GRADUATION_DATE , FOREIGN_LANGUAGE , FOREIGN_LANGUAGE_LEVEL , COMPUTER_ABILITY , COMPUTER_LEVEL , POLITIC_COUNTENANCE_CODE , JOIN_PART_DATE , BLOOD_TYPE , BODY_HEIGHT , BODY_WEIGHT , EMPLOYMENT_DATE , EMPLOYMENT_CONFIRM_DATE , FIRST_EMPLOYMENT_DATE , FIRST_WORK_DATE , ORG_ID , POSITION_ID , EMPLOYEE_TITLE_ID , RANK_CODE , WORK_KIND_CODE , LEAVE_DATE , LEAVE_RESON , PAYROLL_CARD_BANK_CODE , PAYROLL_CARD , PERSON_PICTURE_ID , FILE_ID , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON $TABLE=new HR_PERSON();
	}
	
	/**
	 * 人员简历
	*/
	public static class HR_PERSON_RESUME extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_resume";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 姓名
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","姓名","姓名",false,false,true);
		
		/**
		 * 学历
		*/
		public static final DBField EDUCATION_CODE = new DBField(DBDataType.STRING , "education_code","educationCode","学历","学历",false,false,true);
		
		/**
		 * 性别
		*/
		public static final DBField SEX = new DBField(DBDataType.STRING , "sex","sex","性别","性别",false,false,true);
		
		/**
		 * 生日
		*/
		public static final DBField BIRTHDAY = new DBField(DBDataType.DATE , "birthday","birthday","生日","生日",false,false,true);
		
		/**
		 * 学籍
		*/
		public static final DBField STUDENT_STATUS = new DBField(DBDataType.STRING , "student_status","studentStatus","学籍","学籍",false,false,true);
		
		/**
		 * 婚姻状况
		*/
		public static final DBField MARITAL_STATUS = new DBField(DBDataType.STRING , "marital_status","maritalStatus","婚姻状况","婚姻状况",false,false,true);
		
		/**
		 * 介绍
		*/
		public static final DBField INTRODUCE = new DBField(DBDataType.STRING , "introduce","introduce","介绍","介绍",false,false,false);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,false);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public HR_PERSON_RESUME() {
			this.init($NAME,"人员简历" , ID , NAME , EDUCATION_CODE , SEX , BIRTHDAY , STUDENT_STATUS , MARITAL_STATUS , INTRODUCE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HR_PERSON_RESUME $TABLE=new HR_PERSON_RESUME();
	}
}