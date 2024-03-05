package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AttendanceDate;
import java.util.Date;
import com.dt.platform.domain.hr.AttendanceTpl;
import java.util.List;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-27 16:27:27
 * @sign E7ACEF21127D06093406E3E5B17D616E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AttendanceDateMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 年份 , 类型: java.lang.String
	*/
	public static final String YEAR="year";
	
	/**
	 * 年份 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.lang.String> YEAR_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,YEAR, java.lang.String.class, "年份", "年份", java.lang.String.class, null);
	
	/**
	 * 日期 , 类型: java.lang.String
	*/
	public static final String DATE_STR="dateStr";
	
	/**
	 * 日期 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.lang.String> DATE_STR_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,DATE_STR, java.lang.String.class, "日期", "日期", java.lang.String.class, null);
	
	/**
	 * 周 , 类型: java.lang.String
	*/
	public static final String WEEK="week";
	
	/**
	 * 周 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.lang.String> WEEK_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,WEEK, java.lang.String.class, "周", "周", java.lang.String.class, null);
	
	/**
	 * 法定假日 , 类型: java.lang.String
	*/
	public static final String STATUTORY_HOLIDAY="statutoryHoliday";
	
	/**
	 * 法定假日 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.lang.String> STATUTORY_HOLIDAY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,STATUTORY_HOLIDAY, java.lang.String.class, "法定假日", "法定假日", java.lang.String.class, null);
	
	/**
	 * 节日 , 类型: java.lang.String
	*/
	public static final String HOLIDAY="holiday";
	
	/**
	 * 节日 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.lang.String> HOLIDAY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,HOLIDAY, java.lang.String.class, "节日", "节日", java.lang.String.class, null);
	
	/**
	 * 考勤签到 , 类型: java.lang.String
	*/
	public static final String ATTENDANC_SIGN="attendancSign";
	
	/**
	 * 考勤签到 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.lang.String> ATTENDANC_SIGN_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,ATTENDANC_SIGN, java.lang.String.class, "考勤签到", "考勤签到", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * confSDate , 类型: java.util.Date
	*/
	public static final String CONF_S_DATE="confSDate";
	
	/**
	 * confSDate , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.util.Date> CONF_S_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,CONF_S_DATE, java.util.Date.class, "confSDate", "confSDate", java.util.Date.class, null);
	
	/**
	 * confEDate , 类型: java.util.Date
	*/
	public static final String CONF_E_DATE="confEDate";
	
	/**
	 * confEDate , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.util.Date> CONF_E_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,CONF_E_DATE, java.util.Date.class, "confEDate", "confEDate", java.util.Date.class, null);
	
	/**
	 * confCreateDate , 类型: java.lang.String
	*/
	public static final String CONF_CREATE_DATE="confCreateDate";
	
	/**
	 * confCreateDate , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.lang.String> CONF_CREATE_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,CONF_CREATE_DATE, java.lang.String.class, "confCreateDate", "confCreateDate", java.lang.String.class, null);
	
	/**
	 * attendanceTplList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AttendanceTpl
	*/
	public static final String ATTENDANCE_TPL_LIST="attendanceTplList";
	
	/**
	 * attendanceTplList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AttendanceTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,com.dt.platform.domain.hr.AttendanceTpl> ATTENDANCE_TPL_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,ATTENDANCE_TPL_LIST, java.util.List.class, "attendanceTplList", "attendanceTplList", com.dt.platform.domain.hr.AttendanceTpl.class, null);
	
	/**
	 * attendanceTplIdsList , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ATTENDANCE_TPL_IDS_LIST="attendanceTplIdsList";
	
	/**
	 * attendanceTplIdsList , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.lang.String> ATTENDANCE_TPL_IDS_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,ATTENDANCE_TPL_IDS_LIST, java.util.List.class, "attendanceTplIdsList", "attendanceTplIdsList", java.lang.String.class, null);
	
	/**
	 * attendanceTplList2 , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AttendanceTpl
	*/
	public static final String ATTENDANCE_TPL_LIST2="attendanceTplList2";
	
	/**
	 * attendanceTplList2 , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AttendanceTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,com.dt.platform.domain.hr.AttendanceTpl> ATTENDANCE_TPL_LIST2_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,ATTENDANCE_TPL_LIST2, java.util.List.class, "attendanceTplList2", "attendanceTplList2", com.dt.platform.domain.hr.AttendanceTpl.class, null);
	
	/**
	 * attendanceTplIdsList2 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ATTENDANCE_TPL_IDS_LIST2="attendanceTplIdsList2";
	
	/**
	 * attendanceTplIdsList2 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.lang.String> ATTENDANCE_TPL_IDS_LIST2_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,ATTENDANCE_TPL_IDS_LIST2, java.util.List.class, "attendanceTplIdsList2", "attendanceTplIdsList2", java.lang.String.class, null);
	
	/**
	 * attendanceTplList3 , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AttendanceTpl
	*/
	public static final String ATTENDANCE_TPL_LIST3="attendanceTplList3";
	
	/**
	 * attendanceTplList3 , 集合类型: LIST , 类型: com.dt.platform.domain.hr.AttendanceTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,com.dt.platform.domain.hr.AttendanceTpl> ATTENDANCE_TPL_LIST3_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,ATTENDANCE_TPL_LIST3, java.util.List.class, "attendanceTplList3", "attendanceTplList3", com.dt.platform.domain.hr.AttendanceTpl.class, null);
	
	/**
	 * attendanceTplIdsList3 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ATTENDANCE_TPL_IDS_LIST3="attendanceTplIdsList3";
	
	/**
	 * attendanceTplIdsList3 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceDate,java.lang.String> ATTENDANCE_TPL_IDS_LIST3_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceDate.class ,ATTENDANCE_TPL_IDS_LIST3, java.util.List.class, "attendanceTplIdsList3", "attendanceTplIdsList3", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , YEAR , DATE_STR , WEEK , STATUTORY_HOLIDAY , HOLIDAY , ATTENDANC_SIGN , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CONF_S_DATE , CONF_E_DATE , CONF_CREATE_DATE , ATTENDANCE_TPL_LIST , ATTENDANCE_TPL_IDS_LIST , ATTENDANCE_TPL_LIST2 , ATTENDANCE_TPL_IDS_LIST2 , ATTENDANCE_TPL_LIST3 , ATTENDANCE_TPL_IDS_LIST3 };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AttendanceDate {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AttendanceDate setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 年份
		 * @param year 年份
		 * @return 当前对象
		*/
		public AttendanceDate setYear(String year) {
			super.change(YEAR,super.getYear(),year);
			super.setYear(year);
			return this;
		}
		
		/**
		 * 设置 日期
		 * @param dateStr 日期
		 * @return 当前对象
		*/
		public AttendanceDate setDateStr(String dateStr) {
			super.change(DATE_STR,super.getDateStr(),dateStr);
			super.setDateStr(dateStr);
			return this;
		}
		
		/**
		 * 设置 周
		 * @param week 周
		 * @return 当前对象
		*/
		public AttendanceDate setWeek(String week) {
			super.change(WEEK,super.getWeek(),week);
			super.setWeek(week);
			return this;
		}
		
		/**
		 * 设置 法定假日
		 * @param statutoryHoliday 法定假日
		 * @return 当前对象
		*/
		public AttendanceDate setStatutoryHoliday(String statutoryHoliday) {
			super.change(STATUTORY_HOLIDAY,super.getStatutoryHoliday(),statutoryHoliday);
			super.setStatutoryHoliday(statutoryHoliday);
			return this;
		}
		
		/**
		 * 设置 节日
		 * @param holiday 节日
		 * @return 当前对象
		*/
		public AttendanceDate setHoliday(String holiday) {
			super.change(HOLIDAY,super.getHoliday(),holiday);
			super.setHoliday(holiday);
			return this;
		}
		
		/**
		 * 设置 考勤签到
		 * @param attendancSign 考勤签到
		 * @return 当前对象
		*/
		public AttendanceDate setAttendancSign(String attendancSign) {
			super.change(ATTENDANC_SIGN,super.getAttendancSign(),attendancSign);
			super.setAttendancSign(attendancSign);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AttendanceDate setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AttendanceDate setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AttendanceDate setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AttendanceDate setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AttendanceDate setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AttendanceDate setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AttendanceDate setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AttendanceDate setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AttendanceDate setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 confSDate
		 * @param confSDate confSDate
		 * @return 当前对象
		*/
		public AttendanceDate setConfSDate(Date confSDate) {
			super.change(CONF_S_DATE,super.getConfSDate(),confSDate);
			super.setConfSDate(confSDate);
			return this;
		}
		
		/**
		 * 设置 confEDate
		 * @param confEDate confEDate
		 * @return 当前对象
		*/
		public AttendanceDate setConfEDate(Date confEDate) {
			super.change(CONF_E_DATE,super.getConfEDate(),confEDate);
			super.setConfEDate(confEDate);
			return this;
		}
		
		/**
		 * 设置 confCreateDate
		 * @param confCreateDate confCreateDate
		 * @return 当前对象
		*/
		public AttendanceDate setConfCreateDate(String confCreateDate) {
			super.change(CONF_CREATE_DATE,super.getConfCreateDate(),confCreateDate);
			super.setConfCreateDate(confCreateDate);
			return this;
		}
		
		/**
		 * 设置 attendanceTplList
		 * @param attendanceTplList attendanceTplList
		 * @return 当前对象
		*/
		public AttendanceDate setAttendanceTplList(List<AttendanceTpl> attendanceTplList) {
			super.change(ATTENDANCE_TPL_LIST,super.getAttendanceTplList(),attendanceTplList);
			super.setAttendanceTplList(attendanceTplList);
			return this;
		}
		
		/**
		 * 设置 attendanceTplIdsList
		 * @param attendanceTplIdsList attendanceTplIdsList
		 * @return 当前对象
		*/
		public AttendanceDate setAttendanceTplIdsList(List<String> attendanceTplIdsList) {
			super.change(ATTENDANCE_TPL_IDS_LIST,super.getAttendanceTplIdsList(),attendanceTplIdsList);
			super.setAttendanceTplIdsList(attendanceTplIdsList);
			return this;
		}
		
		/**
		 * 设置 attendanceTplList2
		 * @param attendanceTplList2 attendanceTplList2
		 * @return 当前对象
		*/
		public AttendanceDate setAttendanceTplList2(List<AttendanceTpl> attendanceTplList2) {
			super.change(ATTENDANCE_TPL_LIST2,super.getAttendanceTplList2(),attendanceTplList2);
			super.setAttendanceTplList2(attendanceTplList2);
			return this;
		}
		
		/**
		 * 设置 attendanceTplIdsList2
		 * @param attendanceTplIdsList2 attendanceTplIdsList2
		 * @return 当前对象
		*/
		public AttendanceDate setAttendanceTplIdsList2(List<String> attendanceTplIdsList2) {
			super.change(ATTENDANCE_TPL_IDS_LIST2,super.getAttendanceTplIdsList2(),attendanceTplIdsList2);
			super.setAttendanceTplIdsList2(attendanceTplIdsList2);
			return this;
		}
		
		/**
		 * 设置 attendanceTplList3
		 * @param attendanceTplList3 attendanceTplList3
		 * @return 当前对象
		*/
		public AttendanceDate setAttendanceTplList3(List<AttendanceTpl> attendanceTplList3) {
			super.change(ATTENDANCE_TPL_LIST3,super.getAttendanceTplList3(),attendanceTplList3);
			super.setAttendanceTplList3(attendanceTplList3);
			return this;
		}
		
		/**
		 * 设置 attendanceTplIdsList3
		 * @param attendanceTplIdsList3 attendanceTplIdsList3
		 * @return 当前对象
		*/
		public AttendanceDate setAttendanceTplIdsList3(List<String> attendanceTplIdsList3) {
			super.change(ATTENDANCE_TPL_IDS_LIST3,super.getAttendanceTplIdsList3(),attendanceTplIdsList3);
			super.setAttendanceTplIdsList3(attendanceTplIdsList3);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AttendanceDate clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AttendanceDate duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setWeek(this.getWeek());
			inst.setDateStr(this.getDateStr());
			inst.setYear(this.getYear());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setHoliday(this.getHoliday());
			inst.setVersion(this.getVersion());
			inst.setStatutoryHoliday(this.getStatutoryHoliday());
			inst.setAttendancSign(this.getAttendancSign());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			if(all) {
				inst.setAttendanceTplIdsList3(this.getAttendanceTplIdsList3());
				inst.setAttendanceTplList(this.getAttendanceTplList());
				inst.setAttendanceTplIdsList(this.getAttendanceTplIdsList());
				inst.setAttendanceTplIdsList2(this.getAttendanceTplIdsList2());
				inst.setAttendanceTplList3(this.getAttendanceTplList3());
				inst.setConfSDate(this.getConfSDate());
				inst.setAttendanceTplList2(this.getAttendanceTplList2());
				inst.setConfEDate(this.getConfEDate());
				inst.setConfCreateDate(this.getConfCreateDate());
			}
			inst.clearModifies();
			return inst;
		}

	}
}