package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AttendanceYearDay;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.hrm.Person;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 23:07:05
 * @sign 6A0999DC271A6DC40ACDBF48B10A5D56
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AttendanceYearDayMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceYearDay,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceYearDay.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final String PERSON_ID="personId";
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceYearDay,java.lang.String> PERSON_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceYearDay.class ,PERSON_ID, java.lang.String.class, "人员", "人员", java.lang.String.class, null);
	
	/**
	 * 开始日期 , 类型: java.util.Date
	*/
	public static final String SDATE="sdate";
	
	/**
	 * 开始日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceYearDay,java.util.Date> SDATE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceYearDay.class ,SDATE, java.util.Date.class, "开始日期", "开始日期", java.util.Date.class, null);
	
	/**
	 * 结束日期 , 类型: java.lang.String
	*/
	public static final String EDATE="edate";
	
	/**
	 * 结束日期 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceYearDay,java.lang.String> EDATE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceYearDay.class ,EDATE, java.lang.String.class, "结束日期", "结束日期", java.lang.String.class, null);
	
	/**
	 * 本周期 , 类型: java.math.BigDecimal
	*/
	public static final String DAYS="days";
	
	/**
	 * 本周期 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceYearDay,java.math.BigDecimal> DAYS_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceYearDay.class ,DAYS, java.math.BigDecimal.class, "本周期", "本周期", java.math.BigDecimal.class, null);
	
	/**
	 * 上一周期 , 类型: java.math.BigDecimal
	*/
	public static final String LAST_DAYS="lastDays";
	
	/**
	 * 上一周期 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceYearDay,java.math.BigDecimal> LAST_DAYS_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceYearDay.class ,LAST_DAYS, java.math.BigDecimal.class, "上一周期", "上一周期", java.math.BigDecimal.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceYearDay,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceYearDay.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 批次号 , 类型: java.lang.String
	*/
	public static final String BATCH_CODE="batchCode";
	
	/**
	 * 批次号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceYearDay,java.lang.String> BATCH_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceYearDay.class ,BATCH_CODE, java.lang.String.class, "批次号", "批次号", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceYearDay,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceYearDay.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceYearDay,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceYearDay.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceYearDay,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceYearDay.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceYearDay,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceYearDay.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceYearDay,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceYearDay.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceYearDay,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceYearDay.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceYearDay,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceYearDay.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceYearDay,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceYearDay.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceYearDay,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceYearDay.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * person , 类型: org.github.foxnic.web.domain.hrm.Person
	*/
	public static final String PERSON="person";
	
	/**
	 * person , 类型: org.github.foxnic.web.domain.hrm.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceYearDay,org.github.foxnic.web.domain.hrm.Person> PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceYearDay.class ,PERSON, org.github.foxnic.web.domain.hrm.Person.class, "person", "person", org.github.foxnic.web.domain.hrm.Person.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PERSON_ID , SDATE , EDATE , DAYS , LAST_DAYS , NOTES , BATCH_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PERSON };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AttendanceYearDay {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AttendanceYearDay setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 人员
		 * @param personId 人员
		 * @return 当前对象
		*/
		public AttendanceYearDay setPersonId(String personId) {
			super.change(PERSON_ID,super.getPersonId(),personId);
			super.setPersonId(personId);
			return this;
		}
		
		/**
		 * 设置 开始日期
		 * @param sdate 开始日期
		 * @return 当前对象
		*/
		public AttendanceYearDay setSdate(Date sdate) {
			super.change(SDATE,super.getSdate(),sdate);
			super.setSdate(sdate);
			return this;
		}
		
		/**
		 * 设置 结束日期
		 * @param edate 结束日期
		 * @return 当前对象
		*/
		public AttendanceYearDay setEdate(String edate) {
			super.change(EDATE,super.getEdate(),edate);
			super.setEdate(edate);
			return this;
		}
		
		/**
		 * 设置 本周期
		 * @param days 本周期
		 * @return 当前对象
		*/
		public AttendanceYearDay setDays(BigDecimal days) {
			super.change(DAYS,super.getDays(),days);
			super.setDays(days);
			return this;
		}
		
		/**
		 * 设置 上一周期
		 * @param lastDays 上一周期
		 * @return 当前对象
		*/
		public AttendanceYearDay setLastDays(BigDecimal lastDays) {
			super.change(LAST_DAYS,super.getLastDays(),lastDays);
			super.setLastDays(lastDays);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AttendanceYearDay setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 批次号
		 * @param batchCode 批次号
		 * @return 当前对象
		*/
		public AttendanceYearDay setBatchCode(String batchCode) {
			super.change(BATCH_CODE,super.getBatchCode(),batchCode);
			super.setBatchCode(batchCode);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AttendanceYearDay setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AttendanceYearDay setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AttendanceYearDay setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AttendanceYearDay setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AttendanceYearDay setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AttendanceYearDay setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AttendanceYearDay setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AttendanceYearDay setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AttendanceYearDay setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 person
		 * @param person person
		 * @return 当前对象
		*/
		public AttendanceYearDay setPerson(Person person) {
			super.change(PERSON,super.getPerson(),person);
			super.setPerson(person);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AttendanceYearDay clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AttendanceYearDay duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setSdate(this.getSdate());
			inst.setNotes(this.getNotes());
			inst.setBatchCode(this.getBatchCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setEdate(this.getEdate());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setLastDays(this.getLastDays());
			inst.setTenantId(this.getTenantId());
			inst.setDays(this.getDays());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setPersonId(this.getPersonId());
			inst.setId(this.getId());
			if(all) {
				inst.setPerson(this.getPerson());
			}
			inst.clearModifies();
			return inst;
		}

	}
}