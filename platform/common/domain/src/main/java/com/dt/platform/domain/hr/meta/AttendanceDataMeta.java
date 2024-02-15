package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AttendanceData;
import java.util.Date;
import com.dt.platform.domain.hr.Person;
import com.dt.platform.domain.hr.AttendanceTpl;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-15 15:15:15
 * @sign 6965955D9B44788B65ED8107099861BB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AttendanceDataMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final String PERSON_ID="personId";
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.lang.String> PERSON_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,PERSON_ID, java.lang.String.class, "人员", "人员", java.lang.String.class, null);
	
	/**
	 * 考勤模版 , 类型: java.lang.String
	*/
	public static final String ATTENDANCE_TPL_CODE="attendanceTplCode";
	
	/**
	 * 考勤模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.lang.String> ATTENDANCE_TPL_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,ATTENDANCE_TPL_CODE, java.lang.String.class, "考勤模版", "考勤模版", java.lang.String.class, null);
	
	/**
	 * 工号 , 类型: java.lang.String
	*/
	public static final String JOB_NUMBER="jobNumber";
	
	/**
	 * 工号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.lang.String> JOB_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,JOB_NUMBER, java.lang.String.class, "工号", "工号", java.lang.String.class, null);
	
	/**
	 * 考勤日期 , 类型: java.util.Date
	*/
	public static final String ATTENDANCE_DATE="attendanceDate";
	
	/**
	 * 考勤日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.util.Date> ATTENDANCE_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,ATTENDANCE_DATE, java.util.Date.class, "考勤日期", "考勤日期", java.util.Date.class, null);
	
	/**
	 * 上班打卡 , 类型: java.util.Date
	*/
	public static final String ON_WORK_TIME="onWorkTime";
	
	/**
	 * 上班打卡 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.util.Date> ON_WORK_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,ON_WORK_TIME, java.util.Date.class, "上班打卡", "上班打卡", java.util.Date.class, null);
	
	/**
	 * 最早打卡 , 类型: java.util.Date
	*/
	public static final String ON_WORK_TIME2="onWorkTime2";
	
	/**
	 * 最早打卡 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.util.Date> ON_WORK_TIME2_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,ON_WORK_TIME2, java.util.Date.class, "最早打卡", "最早打卡", java.util.Date.class, null);
	
	/**
	 * 下班打卡 , 类型: java.util.Date
	*/
	public static final String OFF_WORK_TIME="offWorkTime";
	
	/**
	 * 下班打卡 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.util.Date> OFF_WORK_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,OFF_WORK_TIME, java.util.Date.class, "下班打卡", "下班打卡", java.util.Date.class, null);
	
	/**
	 * 最晚打卡 , 类型: java.util.Date
	*/
	public static final String OFF_WORK_TIME2="offWorkTime2";
	
	/**
	 * 最晚打卡 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.util.Date> OFF_WORK_TIME2_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,OFF_WORK_TIME2, java.util.Date.class, "最晚打卡", "最晚打卡", java.util.Date.class, null);
	
	/**
	 * 早退 , 类型: java.lang.String
	*/
	public static final String LEAVE_EARLY="leaveEarly";
	
	/**
	 * 早退 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.lang.String> LEAVE_EARLY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,LEAVE_EARLY, java.lang.String.class, "早退", "早退", java.lang.String.class, null);
	
	/**
	 * 晚退 , 类型: java.lang.String
	*/
	public static final String LEAVE_LATE="leaveLate";
	
	/**
	 * 晚退 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.lang.String> LEAVE_LATE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,LEAVE_LATE, java.lang.String.class, "晚退", "晚退", java.lang.String.class, null);
	
	/**
	 * 矿工 , 类型: java.lang.String
	*/
	public static final String SKIP_WORK="skipWork";
	
	/**
	 * 矿工 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.lang.String> SKIP_WORK_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,SKIP_WORK, java.lang.String.class, "矿工", "矿工", java.lang.String.class, null);
	
	/**
	 * 补签 , 类型: java.lang.String
	*/
	public static final String BQ="bq";
	
	/**
	 * 补签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.lang.String> BQ_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,BQ, java.lang.String.class, "补签", "补签", java.lang.String.class, null);
	
	/**
	 * 请假 , 类型: java.lang.String
	*/
	public static final String QJ="qj";
	
	/**
	 * 请假 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.lang.String> QJ_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,QJ, java.lang.String.class, "请假", "请假", java.lang.String.class, null);
	
	/**
	 * 出差 , 类型: java.lang.String
	*/
	public static final String CC="cc";
	
	/**
	 * 出差 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.lang.String> CC_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,CC, java.lang.String.class, "出差", "出差", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * person , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final String PERSON="person";
	
	/**
	 * person , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,com.dt.platform.domain.hr.Person> PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,PERSON, com.dt.platform.domain.hr.Person.class, "person", "person", com.dt.platform.domain.hr.Person.class, null);
	
	/**
	 * attendanceTpl , 类型: com.dt.platform.domain.hr.AttendanceTpl
	*/
	public static final String ATTENDANCE_TPL="attendanceTpl";
	
	/**
	 * attendanceTpl , 类型: com.dt.platform.domain.hr.AttendanceTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,com.dt.platform.domain.hr.AttendanceTpl> ATTENDANCE_TPL_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,ATTENDANCE_TPL, com.dt.platform.domain.hr.AttendanceTpl.class, "attendanceTpl", "attendanceTpl", com.dt.platform.domain.hr.AttendanceTpl.class, null);
	
	/**
	 * personJobName , 类型: java.lang.String
	*/
	public static final String PERSON_JOB_NAME="personJobName";
	
	/**
	 * personJobName , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceData,java.lang.String> PERSON_JOB_NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceData.class ,PERSON_JOB_NAME, java.lang.String.class, "personJobName", "personJobName", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PERSON_ID , ATTENDANCE_TPL_CODE , JOB_NUMBER , ATTENDANCE_DATE , ON_WORK_TIME , ON_WORK_TIME2 , OFF_WORK_TIME , OFF_WORK_TIME2 , LEAVE_EARLY , LEAVE_LATE , SKIP_WORK , BQ , QJ , CC , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PERSON , ATTENDANCE_TPL , PERSON_JOB_NAME };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AttendanceData {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AttendanceData setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 人员
		 * @param personId 人员
		 * @return 当前对象
		*/
		public AttendanceData setPersonId(String personId) {
			super.change(PERSON_ID,super.getPersonId(),personId);
			super.setPersonId(personId);
			return this;
		}
		
		/**
		 * 设置 考勤模版
		 * @param attendanceTplCode 考勤模版
		 * @return 当前对象
		*/
		public AttendanceData setAttendanceTplCode(String attendanceTplCode) {
			super.change(ATTENDANCE_TPL_CODE,super.getAttendanceTplCode(),attendanceTplCode);
			super.setAttendanceTplCode(attendanceTplCode);
			return this;
		}
		
		/**
		 * 设置 工号
		 * @param jobNumber 工号
		 * @return 当前对象
		*/
		public AttendanceData setJobNumber(String jobNumber) {
			super.change(JOB_NUMBER,super.getJobNumber(),jobNumber);
			super.setJobNumber(jobNumber);
			return this;
		}
		
		/**
		 * 设置 考勤日期
		 * @param attendanceDate 考勤日期
		 * @return 当前对象
		*/
		public AttendanceData setAttendanceDate(Date attendanceDate) {
			super.change(ATTENDANCE_DATE,super.getAttendanceDate(),attendanceDate);
			super.setAttendanceDate(attendanceDate);
			return this;
		}
		
		/**
		 * 设置 上班打卡
		 * @param onWorkTime 上班打卡
		 * @return 当前对象
		*/
		public AttendanceData setOnWorkTime(Date onWorkTime) {
			super.change(ON_WORK_TIME,super.getOnWorkTime(),onWorkTime);
			super.setOnWorkTime(onWorkTime);
			return this;
		}
		
		/**
		 * 设置 最早打卡
		 * @param onWorkTime2 最早打卡
		 * @return 当前对象
		*/
		public AttendanceData setOnWorkTime2(Date onWorkTime2) {
			super.change(ON_WORK_TIME2,super.getOnWorkTime2(),onWorkTime2);
			super.setOnWorkTime2(onWorkTime2);
			return this;
		}
		
		/**
		 * 设置 下班打卡
		 * @param offWorkTime 下班打卡
		 * @return 当前对象
		*/
		public AttendanceData setOffWorkTime(Date offWorkTime) {
			super.change(OFF_WORK_TIME,super.getOffWorkTime(),offWorkTime);
			super.setOffWorkTime(offWorkTime);
			return this;
		}
		
		/**
		 * 设置 最晚打卡
		 * @param offWorkTime2 最晚打卡
		 * @return 当前对象
		*/
		public AttendanceData setOffWorkTime2(Date offWorkTime2) {
			super.change(OFF_WORK_TIME2,super.getOffWorkTime2(),offWorkTime2);
			super.setOffWorkTime2(offWorkTime2);
			return this;
		}
		
		/**
		 * 设置 早退
		 * @param leaveEarly 早退
		 * @return 当前对象
		*/
		public AttendanceData setLeaveEarly(String leaveEarly) {
			super.change(LEAVE_EARLY,super.getLeaveEarly(),leaveEarly);
			super.setLeaveEarly(leaveEarly);
			return this;
		}
		
		/**
		 * 设置 晚退
		 * @param leaveLate 晚退
		 * @return 当前对象
		*/
		public AttendanceData setLeaveLate(String leaveLate) {
			super.change(LEAVE_LATE,super.getLeaveLate(),leaveLate);
			super.setLeaveLate(leaveLate);
			return this;
		}
		
		/**
		 * 设置 矿工
		 * @param skipWork 矿工
		 * @return 当前对象
		*/
		public AttendanceData setSkipWork(String skipWork) {
			super.change(SKIP_WORK,super.getSkipWork(),skipWork);
			super.setSkipWork(skipWork);
			return this;
		}
		
		/**
		 * 设置 补签
		 * @param bq 补签
		 * @return 当前对象
		*/
		public AttendanceData setBq(String bq) {
			super.change(BQ,super.getBq(),bq);
			super.setBq(bq);
			return this;
		}
		
		/**
		 * 设置 请假
		 * @param qj 请假
		 * @return 当前对象
		*/
		public AttendanceData setQj(String qj) {
			super.change(QJ,super.getQj(),qj);
			super.setQj(qj);
			return this;
		}
		
		/**
		 * 设置 出差
		 * @param cc 出差
		 * @return 当前对象
		*/
		public AttendanceData setCc(String cc) {
			super.change(CC,super.getCc(),cc);
			super.setCc(cc);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AttendanceData setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AttendanceData setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AttendanceData setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AttendanceData setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AttendanceData setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AttendanceData setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AttendanceData setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AttendanceData setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AttendanceData setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AttendanceData setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 person
		 * @param person person
		 * @return 当前对象
		*/
		public AttendanceData setPerson(Person person) {
			super.change(PERSON,super.getPerson(),person);
			super.setPerson(person);
			return this;
		}
		
		/**
		 * 设置 attendanceTpl
		 * @param attendanceTpl attendanceTpl
		 * @return 当前对象
		*/
		public AttendanceData setAttendanceTpl(AttendanceTpl attendanceTpl) {
			super.change(ATTENDANCE_TPL,super.getAttendanceTpl(),attendanceTpl);
			super.setAttendanceTpl(attendanceTpl);
			return this;
		}
		
		/**
		 * 设置 personJobName
		 * @param personJobName personJobName
		 * @return 当前对象
		*/
		public AttendanceData setPersonJobName(String personJobName) {
			super.change(PERSON_JOB_NAME,super.getPersonJobName(),personJobName);
			super.setPersonJobName(personJobName);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AttendanceData clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AttendanceData duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setAttendanceTplCode(this.getAttendanceTplCode());
			inst.setBq(this.getBq());
			inst.setOnWorkTime(this.getOnWorkTime());
			inst.setSkipWork(this.getSkipWork());
			inst.setOffWorkTime(this.getOffWorkTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setQj(this.getQj());
			inst.setId(this.getId());
			inst.setOnWorkTime2(this.getOnWorkTime2());
			inst.setCc(this.getCc());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setLeaveEarly(this.getLeaveEarly());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setPersonId(this.getPersonId());
			inst.setLeaveLate(this.getLeaveLate());
			inst.setAttendanceDate(this.getAttendanceDate());
			inst.setJobNumber(this.getJobNumber());
			inst.setOffWorkTime2(this.getOffWorkTime2());
			if(all) {
				inst.setPerson(this.getPerson());
				inst.setAttendanceTpl(this.getAttendanceTpl());
				inst.setPersonJobName(this.getPersonJobName());
			}
			inst.clearModifies();
			return inst;
		}

	}
}