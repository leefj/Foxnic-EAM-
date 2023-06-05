package com.dt.platform.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2023-06-05 15:19:03
 * @author 金杰 , maillank@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class HrTables {
	
	/**
	 *  考核评级
	*/
	public static class HR_ASSESSMENT_GRADE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_assessment_grade";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ASSESSMENT_GRADE() {
			this.init($NAME," 考核评级" , ID , CODE , NAME , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ASSESSMENT_GRADE $TABLE=new HR_ASSESSMENT_GRADE();
	}
	
	/**
	 * 考勤汇总
	*/
	public static class HR_ATTENDANCE_DATA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_attendance_data";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","人员","人员",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField EMPLOYEE_NAME = new DBField(DBDataType.STRING , "employee_name","employeeName","姓名","姓名",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField EMPLOYEE_NUMBER = new DBField(DBDataType.STRING , "employee_number","employeeNumber","工号","工号",false,false,true);
		
		/**
		 * 考勤日期
		*/
		public static final DBField ATTENDANCE_DATE = new DBField(DBDataType.DATE , "attendance_date","attendanceDate","考勤日期","考勤日期",false,false,true);
		
		/**
		 * 上班打卡
		*/
		public static final DBField ON_WORK_TIME = new DBField(DBDataType.DATE , "on_work_time","onWorkTime","上班打卡","上班打卡",false,false,true);
		
		/**
		 * 上班打卡2
		*/
		public static final DBField ON_WORK_TIME2 = new DBField(DBDataType.DATE , "on_work_time2","onWorkTime2","上班打卡2","上班打卡2",false,false,true);
		
		/**
		 * 下班打卡
		*/
		public static final DBField OFF_WORK_TIME = new DBField(DBDataType.DATE , "off_work_time","offWorkTime","下班打卡","下班打卡",false,false,true);
		
		/**
		 * 下班打卡2
		*/
		public static final DBField OFF_WORK_TIME2 = new DBField(DBDataType.DATE , "off_work_time2","offWorkTime2","下班打卡2","下班打卡2",false,false,true);
		
		/**
		 * 早退
		*/
		public static final DBField LEAVE_EARLY = new DBField(DBDataType.INTEGER , "leave_early","leaveEarly","早退","早退",false,false,true);
		
		/**
		 * 晚退
		*/
		public static final DBField LEAVE_LATE = new DBField(DBDataType.INTEGER , "leave_late","leaveLate","晚退","晚退",false,false,true);
		
		/**
		 * 矿工
		*/
		public static final DBField SKIP_WORK = new DBField(DBDataType.INTEGER , "skip_work","skipWork","矿工","矿工",false,false,true);
		
		/**
		 * 正常
		*/
		public static final DBField NORMAL_WORK = new DBField(DBDataType.INTEGER , "normal_work","normalWork","正常","正常",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ATTENDANCE_DATA() {
			this.init($NAME,"考勤汇总" , ID , EMPLOYEE_ID , EMPLOYEE_NAME , EMPLOYEE_NUMBER , ATTENDANCE_DATE , ON_WORK_TIME , ON_WORK_TIME2 , OFF_WORK_TIME , OFF_WORK_TIME2 , LEAVE_EARLY , LEAVE_LATE , SKIP_WORK , NORMAL_WORK , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ATTENDANCE_DATA $TABLE=new HR_ATTENDANCE_DATA();
	}
	
	/**
	 * 考勤记录
	*/
	public static class HR_ATTENDANCE_RECORD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_attendance_record";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","人员","人员",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField EMPLOYEE_NAME = new DBField(DBDataType.STRING , "employee_name","employeeName","姓名","姓名",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField EMPLOYEE_NUMBER = new DBField(DBDataType.STRING , "employee_number","employeeNumber","工号","工号",false,false,true);
		
		/**
		 * 记录时间
		*/
		public static final DBField RCD_TIME = new DBField(DBDataType.DATE , "rcd_time","rcdTime","记录时间","记录时间",false,false,true);
		
		/**
		 * 来源
		*/
		public static final DBField SOURCE = new DBField(DBDataType.STRING , "source","source","来源","来源",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ATTENDANCE_RECORD() {
			this.init($NAME,"考勤记录" , ID , EMPLOYEE_ID , EMPLOYEE_NAME , EMPLOYEE_NUMBER , RCD_TIME , SOURCE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ATTENDANCE_RECORD $TABLE=new HR_ATTENDANCE_RECORD();
	}
	
	/**
	 * 考勤导入
	*/
	public static class HR_ATTENDANCE_RECORD_IMPORT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_attendance_record_import";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField SOURCE = new DBField(DBDataType.STRING , "source","source","人员","人员",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_ATTENDANCE_RECORD_IMPORT() {
			this.init($NAME,"考勤导入" , ID , SOURCE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_ATTENDANCE_RECORD_IMPORT $TABLE=new HR_ATTENDANCE_RECORD_IMPORT();
	}
	
	/**
	 * 人员出差
	*/
	public static class HR_BUSINESS_TRAVEL_DATA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_business_travel_data";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","人员","人员",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField EMPLOYEE_NAME = new DBField(DBDataType.STRING , "employee_name","employeeName","姓名","姓名",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField EMPLOYEE_NUMBER = new DBField(DBDataType.STRING , "employee_number","employeeNumber","工号","工号",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 时长
		*/
		public static final DBField DURATION = new DBField(DBDataType.DECIMAL , "duration","duration","时长","时长",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField S_TIME = new DBField(DBDataType.DATE , "s_time","sTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField E_TIME = new DBField(DBDataType.DATE , "e_time","eTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_BUSINESS_TRAVEL_DATA() {
			this.init($NAME,"人员出差" , ID , EMPLOYEE_ID , EMPLOYEE_NAME , EMPLOYEE_NUMBER , CONTENT , DURATION , S_TIME , E_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_BUSINESS_TRAVEL_DATA $TABLE=new HR_BUSINESS_TRAVEL_DATA();
	}
	
	/**
	 * 证书管理
	*/
	public static class HR_CERTIFICATE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_certificate";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 级别
		*/
		public static final DBField CERT_LEVEL = new DBField(DBDataType.STRING , "cert_level","certLevel","级别","级别",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.STRING , "sort","sort","排序","排序",false,false,true);
		
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
		
		public HR_CERTIFICATE() {
			this.init($NAME,"证书管理" , ID , TYPE , CERT_LEVEL , NAME , SORT , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_CERTIFICATE $TABLE=new HR_CERTIFICATE();
	}
	
	/**
	 * 证书级别
	*/
	public static class HR_CERTIFICATE_LEVEL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_certificate_level";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.STRING , "sort","sort","排序","排序",false,false,true);
		
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
		
		public HR_CERTIFICATE_LEVEL() {
			this.init($NAME,"证书级别" , ID , NAME , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_CERTIFICATE_LEVEL $TABLE=new HR_CERTIFICATE_LEVEL();
	}
	
	/**
	 * 证书类型
	*/
	public static class HR_CERTIFICATE_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_certificate_type";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.STRING , "sort","sort","排序","排序",false,false,true);
		
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
		
		public HR_CERTIFICATE_TYPE() {
			this.init($NAME,"证书类型" , ID , NAME , SORT , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_CERTIFICATE_TYPE $TABLE=new HR_CERTIFICATE_TYPE();
	}
	
	/**
	 * 合同签订方
	*/
	public static class HR_CONTRACT_ORG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_contract_org";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		
		public HR_CONTRACT_ORG() {
			this.init($NAME,"合同签订方" , ID , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_CONTRACT_ORG $TABLE=new HR_CONTRACT_ORG();
	}
	
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
		public static final DBField SEX_CODE = new DBField(DBDataType.STRING , "sex_code","sexCode","性别","性别",false,false,true);
		
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
		 * 员工标记
		*/
		public static final DBField EMPLOYEE_IDENTITY_STATUS = new DBField(DBDataType.STRING , "employee_identity_status","employeeIdentityStatus","员工标记","员工标记",false,false,true);
		
		/**
		 * 人员类型
		*/
		public static final DBField EMPLOYEE_TYPE_CODE = new DBField(DBDataType.STRING , "employee_type_code","employeeTypeCode","人员类型","人员类型",false,false,true);
		
		/**
		 * 身份证
		*/
		public static final DBField IDENTITY_CARD = new DBField(DBDataType.STRING , "identity_card","identityCard","身份证","身份证",false,false,true);
		
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
		public static final DBField POSITION_CODE = new DBField(DBDataType.STRING , "position_code","positionCode","员工岗位","员工岗位",false,false,true);
		
		/**
		 * 员工职称
		*/
		public static final DBField EMPLOYEE_TITLE_CODE = new DBField(DBDataType.STRING , "employee_title_code","employeeTitleCode","员工职称","员工职称",false,false,true);
		
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
		 * 薪酬模版
		*/
		public static final DBField SALARY_TPL_ID = new DBField(DBDataType.STRING , "salary_tpl_id","salaryTplId","薪酬模版","薪酬模版",false,false,true);
		
		/**
		 * 是否发放
		*/
		public static final DBField SALARY_PAY_OUT = new DBField(DBDataType.STRING , "salary_pay_out","salaryPayOut","是否发放","是否发放",false,false,true);
		
		/**
		 * 薪酬备注
		*/
		public static final DBField SALARY_NOTES = new DBField(DBDataType.STRING , "salary_notes","salaryNotes","薪酬备注","薪酬备注",false,false,true);
		
		/**
		 * 照片
		*/
		public static final DBField PERSON_PICTURE_ID = new DBField(DBDataType.STRING , "person_picture_id","personPictureId","照片","照片",false,false,true);
		
		/**
		 * 员工
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","员工","员工",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 合同周期
		*/
		public static final DBField CONTRACT_DURATION = new DBField(DBDataType.STRING , "contract_duration","contractDuration","合同周期","合同周期",false,false,true);
		
		/**
		 * 合同开始时间
		*/
		public static final DBField CONTRACT_START_DATE = new DBField(DBDataType.DATE , "contract_start_date","contractStartDate","合同开始时间","合同开始时间",false,false,true);
		
		/**
		 * 合同结束时间
		*/
		public static final DBField CONTRACT_FINISH_DATE = new DBField(DBDataType.DATE , "contract_finish_date","contractFinishDate","合同结束时间","合同结束时间",false,false,true);
		
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
			this.init($NAME,"人员信息" , ID , JOB_NUMBER , NAME , SEX_CODE , BIRTHDAY , NATIVE_PLACE_CODE , NATION_CODE , MARITAL_STATUS , EMPLOYEE_STATUS , EMPLOYEE_IDENTITY_STATUS , EMPLOYEE_TYPE_CODE , IDENTITY_CARD , CONTACT_INFORMATION , EMAIL , EMERGENCY_CONTACT , EMERGENCY_CONTACT_NO , HOME_ADDRESS , WEIXIN_ID , EDUCATION_CODE , GRADUATION_SCHOOL , MAJOR , GRADUATION_DATE , FOREIGN_LANGUAGE , FOREIGN_LANGUAGE_LEVEL , COMPUTER_ABILITY , COMPUTER_LEVEL , POLITIC_COUNTENANCE_CODE , JOIN_PART_DATE , BLOOD_TYPE , BODY_HEIGHT , BODY_WEIGHT , EMPLOYMENT_DATE , EMPLOYMENT_CONFIRM_DATE , FIRST_EMPLOYMENT_DATE , FIRST_WORK_DATE , ORG_ID , POSITION_CODE , EMPLOYEE_TITLE_CODE , RANK_CODE , WORK_KIND_CODE , LEAVE_DATE , LEAVE_RESON , PAYROLL_CARD_BANK_CODE , PAYROLL_CARD , SALARY_TPL_ID , SALARY_PAY_OUT , SALARY_NOTES , PERSON_PICTURE_ID , EMPLOYEE_ID , FILE_ID , CONTRACT_DURATION , CONTRACT_START_DATE , CONTRACT_FINISH_DATE , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON $TABLE=new HR_PERSON();
	}
	
	/**
	 * 人员证书
	*/
	public static class HR_PERSON_CERT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_cert";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 证书
		*/
		public static final DBField CERT_ID = new DBField(DBDataType.STRING , "cert_id","certId","证书","证书",false,false,true);
		
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
		
		public HR_PERSON_CERT() {
			this.init($NAME,"人员证书" , ID , PERSON_ID , CERT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_CERT $TABLE=new HR_PERSON_CERT();
	}
	
	/**
	 * 人员合同
	*/
	public static class HR_PERSON_CONTRACT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_contract";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 合同编号
		*/
		public static final DBField BUSINESS_CODE = new DBField(DBDataType.STRING , "business_code","businessCode","合同编号","合同编号",false,false,true);
		
		/**
		 * 合同类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","合同类型","合同类型",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 合同期限,月
		*/
		public static final DBField CONTRACT_DURATION = new DBField(DBDataType.DECIMAL , "contract_duration","contractDuration","合同期限","月",false,false,true);
		
		/**
		 * 合同年份
		*/
		public static final DBField CONTRACT_YEAR = new DBField(DBDataType.STRING , "contract_year","contractYear","合同年份","合同年份",false,false,true);
		
		/**
		 * 是否转正
		*/
		public static final DBField TRANSFER_TO_REGULAR = new DBField(DBDataType.STRING , "transfer_to_regular","transferToRegular","是否转正","是否转正",false,false,true);
		
		/**
		 * 签约方
		*/
		public static final DBField CONTRACT_PARTY_ID = new DBField(DBDataType.STRING , "contract_party_id","contractPartyId","签约方","签约方",false,false,true);
		
		/**
		 * 试用期工资
		*/
		public static final DBField PROBATION_SALARY = new DBField(DBDataType.DECIMAL , "probation_salary","probationSalary","试用期工资","试用期工资",false,false,true);
		
		/**
		 * 试用期生效时间
		*/
		public static final DBField PROBATION_START_DATE = new DBField(DBDataType.DATE , "probation_start_date","probationStartDate","试用期生效时间","试用期生效时间",false,false,true);
		
		/**
		 * 试用期到期时间
		*/
		public static final DBField PROBATION_FINISH_DATE = new DBField(DBDataType.DATE , "probation_finish_date","probationFinishDate","试用期到期时间","试用期到期时间",false,false,true);
		
		/**
		 * 生效时间
		*/
		public static final DBField CONTRACT_START_DATE = new DBField(DBDataType.DATE , "contract_start_date","contractStartDate","生效时间","生效时间",false,false,true);
		
		/**
		 * 到期时间
		*/
		public static final DBField CONTRACT_FINISH_DATE = new DBField(DBDataType.DATE , "contract_finish_date","contractFinishDate","到期时间","到期时间",false,false,true);
		
		/**
		 * 工资
		*/
		public static final DBField SALARY = new DBField(DBDataType.DECIMAL , "salary","salary","工资","工资",false,false,true);
		
		/**
		 * 合同内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","合同内容","合同内容",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 合同附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","合同附件","合同附件",false,false,true);
		
		/**
		 * 是否归档
		*/
		public static final DBField ARCH = new DBField(DBDataType.STRING , "arch","arch","是否归档","是否归档",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_PERSON_CONTRACT() {
			this.init($NAME,"人员合同" , ID , PERSON_ID , BUSINESS_CODE , TYPE , STATUS , CONTRACT_DURATION , CONTRACT_YEAR , TRANSFER_TO_REGULAR , CONTRACT_PARTY_ID , PROBATION_SALARY , PROBATION_START_DATE , PROBATION_FINISH_DATE , CONTRACT_START_DATE , CONTRACT_FINISH_DATE , SALARY , CONTENT , NOTES , FILE_ID , ARCH , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_CONTRACT $TABLE=new HR_PERSON_CONTRACT();
	}
	
	/**
	 * 人员档案
	*/
	public static class HR_PERSON_FILE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_file";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 档案编号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","档案编号","档案编号",false,false,true);
		
		/**
		 * 档案状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","档案状态","档案状态",false,false,true);
		
		/**
		 * 人员
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","人员","人员",false,false,true);
		
		/**
		 * 是否新建档
		*/
		public static final DBField IF_NEW = new DBField(DBDataType.STRING , "if_new","ifNew","是否新建档","是否新建档",false,false,true);
		
		/**
		 * 来源
		*/
		public static final DBField SOURCE = new DBField(DBDataType.STRING , "source","source","来源","来源",false,false,true);
		
		/**
		 * 档案保管地
		*/
		public static final DBField SAVE_LOC = new DBField(DBDataType.STRING , "save_loc","saveLoc","档案保管地","档案保管地",false,false,true);
		
		/**
		 * 参加工作时间
		*/
		public static final DBField WORK_START_DATE = new DBField(DBDataType.STRING , "work_start_date","workStartDate","参加工作时间","参加工作时间",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE = new DBField(DBDataType.STRING , "file","file","附件","附件",false,false,true);
		
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
		
		public HR_PERSON_FILE() {
			this.init($NAME,"人员档案" , ID , CODE , STATUS , USER_ID , IF_NEW , SOURCE , SAVE_LOC , WORK_START_DATE , FILE , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_FILE $TABLE=new HR_PERSON_FILE();
	}
	
	/**
	 * 管理单位
	*/
	public static class HR_PERSON_FILE_ORG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_file_org";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.STRING , "sort","sort","排序","排序",false,false,true);
		
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
		
		public HR_PERSON_FILE_ORG() {
			this.init($NAME,"管理单位" , ID , NAME , SORT , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PERSON_FILE_ORG $TABLE=new HR_PERSON_FILE_ORG();
	}
	
	/**
	 * 档案调出
	*/
	public static class HR_PERSON_FILE_OUT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_person_file_out";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 档案
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","档案","档案",false,false,true);
		
		/**
		 * 调出时间
		*/
		public static final DBField OUT_DATE = new DBField(DBDataType.STRING , "out_date","outDate","调出时间","调出时间",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		public HR_PERSON_FILE_OUT() {
			this.init($NAME,"档案调出" , ID , STATUS , FILE_ID , OUT_DATE , CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final HR_PERSON_FILE_OUT $TABLE=new HR_PERSON_FILE_OUT();
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
	
	/**
	 * 工作岗位
	*/
	public static class HR_POSITION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_position";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
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
		
		public HR_POSITION() {
			this.init($NAME,"工作岗位" , ID , NAME , TYPE , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_POSITION $TABLE=new HR_POSITION();
	}
	
	/**
	 * 岗位类型
	*/
	public static class HR_POSITION_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_position_type";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 岗位编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","岗位编码","岗位编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		
		public HR_POSITION_TYPE() {
			this.init($NAME,"岗位类型" , ID , CODE , NAME , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_POSITION_TYPE $TABLE=new HR_POSITION_TYPE();
	}
	
	/**
	 * 职业评级
	*/
	public static class HR_PROFESSIONAL_LEVEL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_professional_level";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 职级奖金
		*/
		public static final DBField BONUS = new DBField(DBDataType.DECIMAL , "bonus","bonus","职级奖金","职级奖金",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTE = new DBField(DBDataType.STRING , "note","note","备注","备注",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
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
		
		public HR_PROFESSIONAL_LEVEL() {
			this.init($NAME,"职业评级" , ID , CODE , NAME , BONUS , NOTE , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_PROFESSIONAL_LEVEL $TABLE=new HR_PROFESSIONAL_LEVEL();
	}
	
	/**
	 * 职级序列
	*/
	public static class HR_RANK extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_rank";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 职级序列
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","职级序列","职级序列",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
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
		
		public HR_RANK() {
			this.init($NAME,"职级序列" , ID , CODE , SORT , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_RANK $TABLE=new HR_RANK();
	}
	
	/**
	 * 招聘记录
	*/
	public static class HR_RECRUIT_PERSON_REC extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_recruit_person_rec";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 招聘说明
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","招聘说明","招聘说明",false,false,true);
		
		/**
		 * 岗位名称
		*/
		public static final DBField POST_ID = new DBField(DBDataType.STRING , "post_id","postId","岗位名称","岗位名称",false,false,true);
		
		/**
		 * 岗位名称
		*/
		public static final DBField POST_NAME = new DBField(DBDataType.STRING , "post_name","postName","岗位名称","岗位名称",false,false,true);
		
		/**
		 * 招聘要求
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","招聘要求","招聘要求",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField START_DATE = new DBField(DBDataType.DATE , "start_date","startDate","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField END_DATE = new DBField(DBDataType.DATE , "end_date","endDate","结束时间","结束时间",false,false,true);
		
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
		
		public HR_RECRUIT_PERSON_REC() {
			this.init($NAME,"招聘记录" , ID , NAME , POST_ID , POST_NAME , CONTENT , NOTES , START_DATE , END_DATE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_RECRUIT_PERSON_REC $TABLE=new HR_RECRUIT_PERSON_REC();
	}
	
	/**
	 * 招聘岗位
	*/
	public static class HR_RECRUIT_POST_REC extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_recruit_post_rec";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 招聘说明
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","招聘说明","招聘说明",false,false,true);
		
		/**
		 * 岗位名称
		*/
		public static final DBField POST_NAME = new DBField(DBDataType.STRING , "post_name","postName","岗位名称","岗位名称",false,false,true);
		
		/**
		 * 招聘要求
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","招聘要求","招聘要求",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		public HR_RECRUIT_POST_REC() {
			this.init($NAME,"招聘岗位" , ID , NAME , POST_NAME , CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_RECRUIT_POST_REC $TABLE=new HR_RECRUIT_POST_REC();
	}
	
	/**
	 * 招聘
	*/
	public static class HR_RECRUIT_RECORD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_recruit_record";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 招聘说明
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","招聘说明","招聘说明",false,false,true);
		
		/**
		 * 岗位名称
		*/
		public static final DBField POST_NAME = new DBField(DBDataType.STRING , "post_name","postName","岗位名称","岗位名称",false,false,true);
		
		/**
		 * 招聘要求
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","招聘要求","招聘要求",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		public HR_RECRUIT_RECORD() {
			this.init($NAME,"招聘" , ID , NAME , POST_NAME , CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_RECRUIT_RECORD $TABLE=new HR_RECRUIT_RECORD();
	}
	
	/**
	 * 人员薪酬
	*/
	public static class HR_SALARY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 基本工资
		*/
		public static final DBField BASE_SALARY = new DBField(DBDataType.DECIMAL , "base_salary","baseSalary","基本工资","基本工资",false,false,true);
		
		/**
		 * 岗位工资
		*/
		public static final DBField POST_SALARY = new DBField(DBDataType.DECIMAL , "post_salary","postSalary","岗位工资","岗位工资",false,false,true);
		
		/**
		 * 工龄工资
		*/
		public static final DBField WORKING_YEARS_SALARY = new DBField(DBDataType.DECIMAL , "working_years_salary","workingYearsSalary","工龄工资","工龄工资",false,false,true);
		
		/**
		 * 固定补贴
		*/
		public static final DBField FIXED_SALARY = new DBField(DBDataType.DECIMAL , "fixed_salary","fixedSalary","固定补贴","固定补贴",false,false,true);
		
		/**
		 * 绩效补贴
		*/
		public static final DBField ACHIEVEMENT_SALARY = new DBField(DBDataType.DECIMAL , "achievement_salary","achievementSalary","绩效补贴","绩效补贴",false,false,true);
		
		/**
		 * 加班补贴
		*/
		public static final DBField OVERTIME_SALARY = new DBField(DBDataType.DECIMAL , "overtime_salary","overtimeSalary","加班补贴","加班补贴",false,false,true);
		
		/**
		 * 其他补贴
		*/
		public static final DBField OTHER_SALARY = new DBField(DBDataType.DECIMAL , "other_salary","otherSalary","其他补贴","其他补贴",false,false,true);
		
		/**
		 * 通讯补贴
		*/
		public static final DBField COMMUNICATION_SALARY = new DBField(DBDataType.DECIMAL , "communication_salary","communicationSalary","通讯补贴","通讯补贴",false,false,true);
		
		/**
		 * 交通补贴
		*/
		public static final DBField TRAFFIC_SALARY = new DBField(DBDataType.DECIMAL , "traffic_salary","trafficSalary","交通补贴","交通补贴",false,false,true);
		
		/**
		 * 住房补贴
		*/
		public static final DBField HOUSING_SALARY = new DBField(DBDataType.DECIMAL , "housing_salary","housingSalary","住房补贴","住房补贴",false,false,true);
		
		/**
		 * 提成工资
		*/
		public static final DBField COMMISSION_SALARY = new DBField(DBDataType.DECIMAL , "commission_salary","commissionSalary","提成工资","提成工资",false,false,true);
		
		/**
		 * 高温补贴
		*/
		public static final DBField HIGH_TEMPERATURE_SALARY = new DBField(DBDataType.DECIMAL , "high_temperature_salary","highTemperatureSalary","高温补贴","高温补贴",false,false,true);
		
		/**
		 * 住房公积金基数
		*/
		public static final DBField WELFARE_ZFGJJ_BASE = new DBField(DBDataType.DECIMAL , "welfare_zfgjj_base","welfareZfgjjBase","住房公积金基数","住房公积金基数",false,false,true);
		
		/**
		 * 住房公积金个人
		*/
		public static final DBField WELFARE_ZFGJJ_PERSON = new DBField(DBDataType.DECIMAL , "welfare_zfgjj_person","welfareZfgjjPerson","住房公积金个人","住房公积金个人",false,false,true);
		
		/**
		 * 住房公积金公司
		*/
		public static final DBField WELFARE_ZFGJJ_COMPANY = new DBField(DBDataType.DECIMAL , "welfare_zfgjj_company","welfareZfgjjCompany","住房公积金公司","住房公积金公司",false,false,true);
		
		/**
		 * 养老保险基数
		*/
		public static final DBField WELFAER_YLBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_ylbx_base","welfaerYlbxBase","养老保险基数","养老保险基数",false,false,true);
		
		/**
		 * 养老保险个人
		*/
		public static final DBField WELFAER_YLBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_ylbx_person","welfaerYlbxPerson","养老保险个人","养老保险个人",false,false,true);
		
		/**
		 * 养老保险公司
		*/
		public static final DBField WELFAER_YLBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_ylbx_company","welfaerYlbxCompany","养老保险公司","养老保险公司",false,false,true);
		
		/**
		 * 工伤保险基数
		*/
		public static final DBField WELFAER_GSBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_gsbx_base","welfaerGsbxBase","工伤保险基数","工伤保险基数",false,false,true);
		
		/**
		 * 工伤保险个人
		*/
		public static final DBField WELFAER_GSBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_gsbx_person","welfaerGsbxPerson","工伤保险个人","工伤保险个人",false,false,true);
		
		/**
		 * 工伤保险公司
		*/
		public static final DBField WELFAER_GSBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_gsbx_company","welfaerGsbxCompany","工伤保险公司","工伤保险公司",false,false,true);
		
		/**
		 * 医疗保险基数
		*/
		public static final DBField WELFAER_YRBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_yrbx_base","welfaerYrbxBase","医疗保险基数","医疗保险基数",false,false,true);
		
		/**
		 * 医疗保险个人
		*/
		public static final DBField WELFAER_YRBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_yrbx_person","welfaerYrbxPerson","医疗保险个人","医疗保险个人",false,false,true);
		
		/**
		 * 医疗保险公司
		*/
		public static final DBField WELFAER_YRBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_yrbx_company","welfaerYrbxCompany","医疗保险公司","医疗保险公司",false,false,true);
		
		/**
		 * 生育保险基数
		*/
		public static final DBField WELFAER_SYBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_sybx_base","welfaerSybxBase","生育保险基数","生育保险基数",false,false,true);
		
		/**
		 * 生育保险个人
		*/
		public static final DBField WELFAER_SYBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_sybx_person","welfaerSybxPerson","生育保险个人","生育保险个人",false,false,true);
		
		/**
		 * 生育保险公司
		*/
		public static final DBField WELFAER_SYBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_sybx_company","welfaerSybxCompany","生育保险公司","生育保险公司",false,false,true);
		
		/**
		 * 失业保险基数
		*/
		public static final DBField WELFAER_SYEBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_syebx_base","welfaerSyebxBase","失业保险基数","失业保险基数",false,false,true);
		
		/**
		 * 失业保险个人
		*/
		public static final DBField WELFAER_SYEBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_syebx_person","welfaerSyebxPerson","失业保险个人","失业保险个人",false,false,true);
		
		/**
		 * 失业保险公司
		*/
		public static final DBField WELFAER_SYEBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_syebx_company","welfaerSyebxCompany","失业保险公司","失业保险公司",false,false,true);
		
		/**
		 * 个税抵扣
		*/
		public static final DBField DEDUCT_PERSONAL_TAX_RED = new DBField(DBDataType.DECIMAL , "deduct_personal_tax_red","deductPersonalTaxRed","个税抵扣","个税抵扣",false,false,true);
		
		/**
		 * 扣除考勤
		*/
		public static final DBField DEDUCT_KQ = new DBField(DBDataType.DECIMAL , "deduct_kq","deductKq","扣除考勤","扣除考勤",false,false,true);
		
		/**
		 * 扣除工会
		*/
		public static final DBField DEDUCT_GH = new DBField(DBDataType.DECIMAL , "deduct_gh","deductGh","扣除工会","扣除工会",false,false,true);
		
		/**
		 * 扣除其他
		*/
		public static final DBField DUDUCT_OTHER = new DBField(DBDataType.DECIMAL , "duduct_other","duductOther","扣除其他","扣除其他",false,false,true);
		
		/**
		 * 子女教育
		*/
		public static final DBField PERSONAL_TAX_ZNJY = new DBField(DBDataType.DECIMAL , "personal_tax_znjy","personalTaxZnjy","子女教育","子女教育",false,false,true);
		
		/**
		 * 继续教育
		*/
		public static final DBField PERSONAL_TAX_JXJY = new DBField(DBDataType.DECIMAL , "personal_tax_jxjy","personalTaxJxjy","继续教育","继续教育",false,false,true);
		
		/**
		 * 大病医疗
		*/
		public static final DBField PERSONAL_TAX_DBYL = new DBField(DBDataType.DECIMAL , "personal_tax_dbyl","personalTaxDbyl","大病医疗","大病医疗",false,false,true);
		
		/**
		 * 住房贷款
		*/
		public static final DBField PERSONAL_TAX_ZFDK = new DBField(DBDataType.DECIMAL , "personal_tax_zfdk","personalTaxZfdk","住房贷款","住房贷款",false,false,true);
		
		/**
		 * 住房租金
		*/
		public static final DBField PERSONAL_TAX_ZFZJ = new DBField(DBDataType.DECIMAL , "personal_tax_zfzj","personalTaxZfzj","住房租金","住房租金",false,false,true);
		
		/**
		 * 赡养老人
		*/
		public static final DBField PERSONAL_TAX_SYLR = new DBField(DBDataType.DECIMAL , "personal_tax_sylr","personalTaxSylr","赡养老人","赡养老人",false,false,true);
		
		/**
		 * 幼儿照护
		*/
		public static final DBField PERSONAL_TAX_ERZH = new DBField(DBDataType.DECIMAL , "personal_tax_erzh","personalTaxErzh","幼儿照护","幼儿照护",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_SALARY() {
			this.init($NAME,"人员薪酬" , ID , PERSON_ID , BASE_SALARY , POST_SALARY , WORKING_YEARS_SALARY , FIXED_SALARY , ACHIEVEMENT_SALARY , OVERTIME_SALARY , OTHER_SALARY , COMMUNICATION_SALARY , TRAFFIC_SALARY , HOUSING_SALARY , COMMISSION_SALARY , HIGH_TEMPERATURE_SALARY , WELFARE_ZFGJJ_BASE , WELFARE_ZFGJJ_PERSON , WELFARE_ZFGJJ_COMPANY , WELFAER_YLBX_BASE , WELFAER_YLBX_PERSON , WELFAER_YLBX_COMPANY , WELFAER_GSBX_BASE , WELFAER_GSBX_PERSON , WELFAER_GSBX_COMPANY , WELFAER_YRBX_BASE , WELFAER_YRBX_PERSON , WELFAER_YRBX_COMPANY , WELFAER_SYBX_BASE , WELFAER_SYBX_PERSON , WELFAER_SYBX_COMPANY , WELFAER_SYEBX_BASE , WELFAER_SYEBX_PERSON , WELFAER_SYEBX_COMPANY , DEDUCT_PERSONAL_TAX_RED , DEDUCT_KQ , DEDUCT_GH , DUDUCT_OTHER , PERSONAL_TAX_ZNJY , PERSONAL_TAX_JXJY , PERSONAL_TAX_DBYL , PERSONAL_TAX_ZFDK , PERSONAL_TAX_ZFZJ , PERSONAL_TAX_SYLR , PERSONAL_TAX_ERZH , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY $TABLE=new HR_SALARY();
	}
	
	/**
	 * 薪酬发放
	*/
	public static class HR_SALARY_ACTION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_action";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签","标签",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 月份
		*/
		public static final DBField ACTION_MONTH = new DBField(DBDataType.STRING , "action_month","actionMonth","月份","月份",false,false,true);
		
		/**
		 * 模版
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","模版","模版",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_SALARY_ACTION() {
			this.init($NAME,"薪酬发放" , ID , STATUS , LABEL , NAME , ACTION_MONTH , TPL_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_ACTION $TABLE=new HR_SALARY_ACTION();
	}
	
	/**
	 * 薪酬控制
	*/
	public static class HR_SALARY_CTL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_ctl";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编号","编号",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 是否参与
		*/
		public static final DBField VALUE_EN = new DBField(DBDataType.STRING , "value_en","valueEn","是否参与","是否参与",false,false,true);
		
		/**
		 * 字符串数值
		*/
		public static final DBField VALUE_STR = new DBField(DBDataType.STRING , "value_str","valueStr","字符串数值","字符串数值",false,false,true);
		
		/**
		 * 浮点数值
		*/
		public static final DBField VALUE_D = new DBField(DBDataType.DECIMAL , "value_d","valueD","浮点数值","浮点数值",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		public HR_SALARY_CTL() {
			this.init($NAME,"薪酬控制" , ID , CODE , NAME , TYPE , VALUE_EN , VALUE_STR , VALUE_D , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_CTL $TABLE=new HR_SALARY_CTL();
	}
	
	/**
	 * 薪酬明细
	*/
	public static class HR_SALARY_DETAIL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_detail";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 姓名
		*/
		public static final DBField USER_NAME = new DBField(DBDataType.STRING , "user_name","userName","姓名","姓名",false,false,true);
		
		/**
		 * 月份
		*/
		public static final DBField ACTION_MONTH = new DBField(DBDataType.STRING , "action_month","actionMonth","月份","月份",false,false,true);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField JOB_NUMBER = new DBField(DBDataType.STRING , "job_number","jobNumber","工号","工号",false,false,true);
		
		/**
		 * 银行
		*/
		public static final DBField BANK = new DBField(DBDataType.STRING , "bank","bank","银行","银行",false,false,true);
		
		/**
		 * 账户账户
		*/
		public static final DBField BANK_ACCOUNT = new DBField(DBDataType.STRING , "bank_account","bankAccount","账户账户","账户账户",false,false,true);
		
		/**
		 * 模版
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","模版","模版",false,false,true);
		
		/**
		 * 动作
		*/
		public static final DBField ACTION_ID = new DBField(DBDataType.STRING , "action_id","actionId","动作","动作",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 合计金额
		*/
		public static final DBField TOTAL_AMOUNT = new DBField(DBDataType.DECIMAL , "total_amount","totalAmount","合计金额","合计金额",false,false,true);
		
		/**
		 * 应发金额
		*/
		public static final DBField PAY_AMOUNT = new DBField(DBDataType.DECIMAL , "pay_amount","payAmount","应发金额","应发金额",false,false,true);
		
		/**
		 * 实发金额
		*/
		public static final DBField ISSUED_AMOUNT = new DBField(DBDataType.DECIMAL , "issued_amount","issuedAmount","实发金额","实发金额",false,false,true);
		
		/**
		 * 基本工资
		*/
		public static final DBField BASE_SALARY = new DBField(DBDataType.DECIMAL , "base_salary","baseSalary","基本工资","基本工资",false,false,true);
		
		/**
		 * 岗位工资
		*/
		public static final DBField POST_SALARY = new DBField(DBDataType.DECIMAL , "post_salary","postSalary","岗位工资","岗位工资",false,false,true);
		
		/**
		 * 工龄工资
		*/
		public static final DBField WORKING_YEARS_SALARY = new DBField(DBDataType.DECIMAL , "working_years_salary","workingYearsSalary","工龄工资","工龄工资",false,false,true);
		
		/**
		 * 固定补贴
		*/
		public static final DBField FIXED_SALARY = new DBField(DBDataType.DECIMAL , "fixed_salary","fixedSalary","固定补贴","固定补贴",false,false,true);
		
		/**
		 * 绩效补贴
		*/
		public static final DBField ACHIEVEMENT_SALARY = new DBField(DBDataType.DECIMAL , "achievement_salary","achievementSalary","绩效补贴","绩效补贴",false,false,true);
		
		/**
		 * 加班补贴
		*/
		public static final DBField OVERTIME_SALARY = new DBField(DBDataType.DECIMAL , "overtime_salary","overtimeSalary","加班补贴","加班补贴",false,false,true);
		
		/**
		 * 其他补贴
		*/
		public static final DBField OTHER_SALARY = new DBField(DBDataType.DECIMAL , "other_salary","otherSalary","其他补贴","其他补贴",false,false,true);
		
		/**
		 * 通讯补贴
		*/
		public static final DBField COMMUNICATION_SALARY = new DBField(DBDataType.DECIMAL , "communication_salary","communicationSalary","通讯补贴","通讯补贴",false,false,true);
		
		/**
		 * 交通补贴
		*/
		public static final DBField TRAFFIC_SALARY = new DBField(DBDataType.DECIMAL , "traffic_salary","trafficSalary","交通补贴","交通补贴",false,false,true);
		
		/**
		 * 住房补贴
		*/
		public static final DBField HOUSING_SALARY = new DBField(DBDataType.DECIMAL , "housing_salary","housingSalary","住房补贴","住房补贴",false,false,true);
		
		/**
		 * 提成工资
		*/
		public static final DBField COMMISSION_SALARY = new DBField(DBDataType.DECIMAL , "commission_salary","commissionSalary","提成工资","提成工资",false,false,true);
		
		/**
		 * 高温补贴
		*/
		public static final DBField HIGH_TEMPERATURE_SALARY = new DBField(DBDataType.DECIMAL , "high_temperature_salary","highTemperatureSalary","高温补贴","高温补贴",false,false,true);
		
		/**
		 * 住房公积金基数
		*/
		public static final DBField WELFARE_ZFGJJ_BASE = new DBField(DBDataType.DECIMAL , "welfare_zfgjj_base","welfareZfgjjBase","住房公积金基数","住房公积金基数",false,false,true);
		
		/**
		 * 住房公积金个人
		*/
		public static final DBField WELFARE_ZFGJJ_PERSON = new DBField(DBDataType.DECIMAL , "welfare_zfgjj_person","welfareZfgjjPerson","住房公积金个人","住房公积金个人",false,false,true);
		
		/**
		 * 住房公积金公司
		*/
		public static final DBField WELFARE_ZFGJJ_COMPANY = new DBField(DBDataType.DECIMAL , "welfare_zfgjj_company","welfareZfgjjCompany","住房公积金公司","住房公积金公司",false,false,true);
		
		/**
		 * 养老保险基数
		*/
		public static final DBField WELFAER_YLBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_ylbx_base","welfaerYlbxBase","养老保险基数","养老保险基数",false,false,true);
		
		/**
		 * 养老保险个人
		*/
		public static final DBField WELFAER_YLBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_ylbx_person","welfaerYlbxPerson","养老保险个人","养老保险个人",false,false,true);
		
		/**
		 * 养老保险公司
		*/
		public static final DBField WELFAER_YLBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_ylbx_company","welfaerYlbxCompany","养老保险公司","养老保险公司",false,false,true);
		
		/**
		 * 工伤保险基数
		*/
		public static final DBField WELFAER_GSBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_gsbx_base","welfaerGsbxBase","工伤保险基数","工伤保险基数",false,false,true);
		
		/**
		 * 工伤保险个人
		*/
		public static final DBField WELFAER_GSBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_gsbx_person","welfaerGsbxPerson","工伤保险个人","工伤保险个人",false,false,true);
		
		/**
		 * 工伤保险公司
		*/
		public static final DBField WELFAER_GSBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_gsbx_company","welfaerGsbxCompany","工伤保险公司","工伤保险公司",false,false,true);
		
		/**
		 * 医疗保险基数
		*/
		public static final DBField WELFAER_YRBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_yrbx_base","welfaerYrbxBase","医疗保险基数","医疗保险基数",false,false,true);
		
		/**
		 * 医疗保险个人
		*/
		public static final DBField WELFAER_YRBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_yrbx_person","welfaerYrbxPerson","医疗保险个人","医疗保险个人",false,false,true);
		
		/**
		 * 医疗保险公司
		*/
		public static final DBField WELFAER_YRBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_yrbx_company","welfaerYrbxCompany","医疗保险公司","医疗保险公司",false,false,true);
		
		/**
		 * 生育保险基数
		*/
		public static final DBField WELFAER_SYBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_sybx_base","welfaerSybxBase","生育保险基数","生育保险基数",false,false,true);
		
		/**
		 * 生育保险个人
		*/
		public static final DBField WELFAER_SYBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_sybx_person","welfaerSybxPerson","生育保险个人","生育保险个人",false,false,true);
		
		/**
		 * 生育保险公司
		*/
		public static final DBField WELFAER_SYBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_sybx_company","welfaerSybxCompany","生育保险公司","生育保险公司",false,false,true);
		
		/**
		 * 失业保险基数
		*/
		public static final DBField WELFAER_SYEBX_BASE = new DBField(DBDataType.DECIMAL , "welfaer_syebx_base","welfaerSyebxBase","失业保险基数","失业保险基数",false,false,true);
		
		/**
		 * 失业保险个人
		*/
		public static final DBField WELFAER_SYEBX_PERSON = new DBField(DBDataType.DECIMAL , "welfaer_syebx_person","welfaerSyebxPerson","失业保险个人","失业保险个人",false,false,true);
		
		/**
		 * 失业保险公司
		*/
		public static final DBField WELFAER_SYEBX_COMPANY = new DBField(DBDataType.DECIMAL , "welfaer_syebx_company","welfaerSyebxCompany","失业保险公司","失业保险公司",false,false,true);
		
		/**
		 * 扣除考勤
		*/
		public static final DBField DEDUCT_KQ = new DBField(DBDataType.DECIMAL , "deduct_kq","deductKq","扣除考勤","扣除考勤",false,false,true);
		
		/**
		 * 扣除工会
		*/
		public static final DBField DEDUCT_GH = new DBField(DBDataType.DECIMAL , "deduct_gh","deductGh","扣除工会","扣除工会",false,false,true);
		
		/**
		 * 扣除其他
		*/
		public static final DBField DEDUCT_OTHER = new DBField(DBDataType.DECIMAL , "deduct_other","deductOther","扣除其他","扣除其他",false,false,true);
		
		/**
		 * 个税抵扣
		*/
		public static final DBField DEDUCT_PERSONAL_TAX_RED = new DBField(DBDataType.DECIMAL , "deduct_personal_tax_red","deductPersonalTaxRed","个税抵扣","个税抵扣",false,false,true);
		
		/**
		 * 子女教育
		*/
		public static final DBField PERSONAL_TAX_ZNJY = new DBField(DBDataType.DECIMAL , "personal_tax_znjy","personalTaxZnjy","子女教育","子女教育",false,false,true);
		
		/**
		 * 继续教育
		*/
		public static final DBField PERSONAL_TAX_JXJY = new DBField(DBDataType.DECIMAL , "personal_tax_jxjy","personalTaxJxjy","继续教育","继续教育",false,false,true);
		
		/**
		 * 大病医疗
		*/
		public static final DBField PERSONAL_TAX_DBYL = new DBField(DBDataType.DECIMAL , "personal_tax_dbyl","personalTaxDbyl","大病医疗","大病医疗",false,false,true);
		
		/**
		 * 住房贷款
		*/
		public static final DBField PERSONAL_TAX_ZFDK = new DBField(DBDataType.DECIMAL , "personal_tax_zfdk","personalTaxZfdk","住房贷款","住房贷款",false,false,true);
		
		/**
		 * 住房租金
		*/
		public static final DBField PERSONAL_TAX_ZFZJ = new DBField(DBDataType.DECIMAL , "personal_tax_zfzj","personalTaxZfzj","住房租金","住房租金",false,false,true);
		
		/**
		 * 赡养老人
		*/
		public static final DBField PERSONAL_TAX_SYLR = new DBField(DBDataType.DECIMAL , "personal_tax_sylr","personalTaxSylr","赡养老人","赡养老人",false,false,true);
		
		/**
		 * 幼儿照护
		*/
		public static final DBField PERSONAL_TAX_ERZH = new DBField(DBDataType.DECIMAL , "personal_tax_erzh","personalTaxErzh","幼儿照护","幼儿照护",false,false,true);
		
		/**
		 * 个人所得税
		*/
		public static final DBField PT_GRSDS = new DBField(DBDataType.DECIMAL , "pt_grsds","ptGrsds","个人所得税","个人所得税",false,false,true);
		
		/**
		 * 抵扣基数
		*/
		public static final DBField PT_DKJS = new DBField(DBDataType.DECIMAL , "pt_dkjs","ptDkjs","抵扣基数","抵扣基数",false,false,true);
		
		/**
		 * 税率
		*/
		public static final DBField PT_SL_PCT = new DBField(DBDataType.DECIMAL , "pt_sl_pct","ptSlPct","税率","税率",false,false,true);
		
		/**
		 * 生效时间
		*/
		public static final DBField EFFECT_TIME = new DBField(DBDataType.DATE , "effect_time","effectTime","生效时间","生效时间",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 操作说明
		*/
		public static final DBField OPER_MSG = new DBField(DBDataType.STRING , "oper_msg","operMsg","操作说明","操作说明",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_SALARY_DETAIL() {
			this.init($NAME,"薪酬明细" , ID , USER_NAME , ACTION_MONTH , PERSON_ID , JOB_NUMBER , BANK , BANK_ACCOUNT , TPL_ID , ACTION_ID , STATUS , TOTAL_AMOUNT , PAY_AMOUNT , ISSUED_AMOUNT , BASE_SALARY , POST_SALARY , WORKING_YEARS_SALARY , FIXED_SALARY , ACHIEVEMENT_SALARY , OVERTIME_SALARY , OTHER_SALARY , COMMUNICATION_SALARY , TRAFFIC_SALARY , HOUSING_SALARY , COMMISSION_SALARY , HIGH_TEMPERATURE_SALARY , WELFARE_ZFGJJ_BASE , WELFARE_ZFGJJ_PERSON , WELFARE_ZFGJJ_COMPANY , WELFAER_YLBX_BASE , WELFAER_YLBX_PERSON , WELFAER_YLBX_COMPANY , WELFAER_GSBX_BASE , WELFAER_GSBX_PERSON , WELFAER_GSBX_COMPANY , WELFAER_YRBX_BASE , WELFAER_YRBX_PERSON , WELFAER_YRBX_COMPANY , WELFAER_SYBX_BASE , WELFAER_SYBX_PERSON , WELFAER_SYBX_COMPANY , WELFAER_SYEBX_BASE , WELFAER_SYEBX_PERSON , WELFAER_SYEBX_COMPANY , DEDUCT_KQ , DEDUCT_GH , DEDUCT_OTHER , DEDUCT_PERSONAL_TAX_RED , PERSONAL_TAX_ZNJY , PERSONAL_TAX_JXJY , PERSONAL_TAX_DBYL , PERSONAL_TAX_ZFDK , PERSONAL_TAX_ZFZJ , PERSONAL_TAX_SYLR , PERSONAL_TAX_ERZH , PT_GRSDS , PT_DKJS , PT_SL_PCT , EFFECT_TIME , NOTES , OPER_MSG , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_DETAIL $TABLE=new HR_SALARY_DETAIL();
	}
	
	/**
	 * 薪酬月份
	*/
	public static class HR_SALARY_MONTH extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_month";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_SALARY_MONTH() {
			this.init($NAME,"薪酬月份" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_MONTH $TABLE=new HR_SALARY_MONTH();
	}
	
	/**
	 * 薪酬税率
	*/
	public static class HR_SALARY_TAX_PCT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_tax_pct";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 最小
		*/
		public static final DBField MIN = new DBField(DBDataType.STRING , "min","min","最小","最小",false,false,true);
		
		/**
		 * 最小包含
		*/
		public static final DBField MIN_INCLUDE = new DBField(DBDataType.STRING , "min_include","minInclude","最小包含","最小包含",false,false,true);
		
		/**
		 * 最大
		*/
		public static final DBField MAX = new DBField(DBDataType.DECIMAL , "max","max","最大","最大",false,false,true);
		
		/**
		 * 最大包含
		*/
		public static final DBField MAX_INCLUDE = new DBField(DBDataType.STRING , "max_include","maxInclude","最大包含","最大包含",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 顺序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","顺序","顺序",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_SALARY_TAX_PCT() {
			this.init($NAME,"薪酬税率" , ID , NAME , MIN , MIN_INCLUDE , MAX , MAX_INCLUDE , NOTES , SORT , TENANT_ID);
		}
		public static final HR_SALARY_TAX_PCT $TABLE=new HR_SALARY_TAX_PCT();
	}
	
	/**
	 * 薪酬模版
	*/
	public static class HR_SALARY_TPL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_tpl";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编号","编号",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		public HR_SALARY_TPL() {
			this.init($NAME,"薪酬模版" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_TPL $TABLE=new HR_SALARY_TPL();
	}
	
	/**
	 * 薪酬人员
	*/
	public static class HR_SALARY_TPL_PERSON extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_salary_tpl_person";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 模版
		*/
		public static final DBField TPL_ID = new DBField(DBDataType.STRING , "tpl_id","tplId","模版","模版",false,false,true);
		
		/**
		 * 人员
		*/
		public static final DBField PERSON_ID = new DBField(DBDataType.STRING , "person_id","personId","人员","人员",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		public HR_SALARY_TPL_PERSON() {
			this.init($NAME,"薪酬人员" , ID , TPL_ID , PERSON_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_SALARY_TPL_PERSON $TABLE=new HR_SALARY_TPL_PERSON();
	}
	
	/**
	 * 人员休假
	*/
	public static class HR_VACATION_DATA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_vacation_data";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","人员","人员",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField EMPLOYEE_NAME = new DBField(DBDataType.STRING , "employee_name","employeeName","姓名","姓名",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField EMPLOYEE_NUMBER = new DBField(DBDataType.STRING , "employee_number","employeeNumber","工号","工号",false,false,true);
		
		/**
		 * 休假类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","休假类型","休假类型",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 时长
		*/
		public static final DBField DURATION = new DBField(DBDataType.DECIMAL , "duration","duration","时长","时长",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField S_TIME = new DBField(DBDataType.DATE , "s_time","sTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField E_TIME = new DBField(DBDataType.DATE , "e_time","eTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_VACATION_DATA() {
			this.init($NAME,"人员休假" , ID , EMPLOYEE_ID , EMPLOYEE_NAME , EMPLOYEE_NUMBER , TYPE , CONTENT , DURATION , S_TIME , E_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_VACATION_DATA $TABLE=new HR_VACATION_DATA();
	}
	
	/**
	 * 人员加班
	*/
	public static class HR_WORK_OVERTIME_DATA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "hr_work_overtime_data";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 人员
		*/
		public static final DBField EMPLOYEE_ID = new DBField(DBDataType.STRING , "employee_id","employeeId","人员","人员",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField EMPLOYEE_NAME = new DBField(DBDataType.STRING , "employee_name","employeeName","姓名","姓名",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField EMPLOYEE_NUMBER = new DBField(DBDataType.STRING , "employee_number","employeeNumber","工号","工号",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 加班时长
		*/
		public static final DBField DURATION = new DBField(DBDataType.DECIMAL , "duration","duration","加班时长","加班时长",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField S_TIME = new DBField(DBDataType.DATE , "s_time","sTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField E_TIME = new DBField(DBDataType.DATE , "e_time","eTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public HR_WORK_OVERTIME_DATA() {
			this.init($NAME,"人员加班" , ID , EMPLOYEE_ID , EMPLOYEE_NAME , EMPLOYEE_NUMBER , CONTENT , DURATION , S_TIME , E_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final HR_WORK_OVERTIME_DATA $TABLE=new HR_WORK_OVERTIME_DATA();
	}
}