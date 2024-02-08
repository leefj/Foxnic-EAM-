package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.PersonAttendanceRec;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.hr.Person;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-02 08:44:35
 * @sign E07BA41EDC20AF96F24134C87FB663BF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PersonAttendanceRecMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 员工 , 类型: java.lang.String
	*/
	public static final String EMPLOYEE_ID="employeeId";
	
	/**
	 * 员工 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.lang.String> EMPLOYEE_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,EMPLOYEE_ID, java.lang.String.class, "员工", "员工", java.lang.String.class, null);
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final String PERSON_ID="personId";
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.lang.String> PERSON_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,PERSON_ID, java.lang.String.class, "人员", "人员", java.lang.String.class, null);
	
	/**
	 * 工号 , 类型: java.lang.String
	*/
	public static final String JOB_NUMBER="jobNumber";
	
	/**
	 * 工号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.lang.String> JOB_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,JOB_NUMBER, java.lang.String.class, "工号", "工号", java.lang.String.class, null);
	
	/**
	 * 加班 , 小时) , 类型: java.math.BigDecimal
	*/
	public static final String JB_CNT="jbCnt";
	
	/**
	 * 加班 , 小时) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.math.BigDecimal> JB_CNT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,JB_CNT, java.math.BigDecimal.class, "加班", "小时)", java.math.BigDecimal.class, null);
	
	/**
	 * 年假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final String NJ_CNT="njCnt";
	
	/**
	 * 年假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.math.BigDecimal> NJ_CNT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,NJ_CNT, java.math.BigDecimal.class, "年假", "天)", java.math.BigDecimal.class, null);
	
	/**
	 * 事假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final String SJ_CNT="sjCnt";
	
	/**
	 * 事假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.math.BigDecimal> SJ_CNT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,SJ_CNT, java.math.BigDecimal.class, "事假", "天)", java.math.BigDecimal.class, null);
	
	/**
	 * 病假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final String BJ_CNT="bjCnt";
	
	/**
	 * 病假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.math.BigDecimal> BJ_CNT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,BJ_CNT, java.math.BigDecimal.class, "病假", "天)", java.math.BigDecimal.class, null);
	
	/**
	 * 出差 , 天) , 类型: java.math.BigDecimal
	*/
	public static final String CC_CNT="ccCnt";
	
	/**
	 * 出差 , 天) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.math.BigDecimal> CC_CNT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,CC_CNT, java.math.BigDecimal.class, "出差", "天)", java.math.BigDecimal.class, null);
	
	/**
	 * 其他假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final String OTHER_CNT="otherCnt";
	
	/**
	 * 其他假 , 天) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.math.BigDecimal> OTHER_CNT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,OTHER_CNT, java.math.BigDecimal.class, "其他假", "天)", java.math.BigDecimal.class, null);
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final String REC_TIME="recTime";
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.util.Date> REC_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,REC_TIME, java.util.Date.class, "记录时间", "记录时间", java.util.Date.class, null);
	
	/**
	 * 批次号 , 类型: java.lang.String
	*/
	public static final String BATCH_CODE="batchCode";
	
	/**
	 * 批次号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.lang.String> BATCH_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,BATCH_CODE, java.lang.String.class, "批次号", "批次号", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final String SOURCE="source";
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.lang.String> SOURCE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,SOURCE, java.lang.String.class, "来源", "来源", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * person , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final String PERSON="person";
	
	/**
	 * person , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,com.dt.platform.domain.hr.Person> PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,PERSON, com.dt.platform.domain.hr.Person.class, "person", "person", com.dt.platform.domain.hr.Person.class, null);
	
	/**
	 * employee , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String EMPLOYEE="employee";
	
	/**
	 * employee , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonAttendanceRec,org.github.foxnic.web.domain.hrm.Employee> EMPLOYEE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonAttendanceRec.class ,EMPLOYEE, org.github.foxnic.web.domain.hrm.Employee.class, "employee", "employee", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , EMPLOYEE_ID , PERSON_ID , JOB_NUMBER , JB_CNT , NJ_CNT , SJ_CNT , BJ_CNT , CC_CNT , OTHER_CNT , REC_TIME , BATCH_CODE , NOTES , SOURCE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PERSON , EMPLOYEE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.PersonAttendanceRec {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PersonAttendanceRec setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 员工
		 * @param employeeId 员工
		 * @return 当前对象
		*/
		public PersonAttendanceRec setEmployeeId(String employeeId) {
			super.change(EMPLOYEE_ID,super.getEmployeeId(),employeeId);
			super.setEmployeeId(employeeId);
			return this;
		}
		
		/**
		 * 设置 人员
		 * @param personId 人员
		 * @return 当前对象
		*/
		public PersonAttendanceRec setPersonId(String personId) {
			super.change(PERSON_ID,super.getPersonId(),personId);
			super.setPersonId(personId);
			return this;
		}
		
		/**
		 * 设置 工号
		 * @param jobNumber 工号
		 * @return 当前对象
		*/
		public PersonAttendanceRec setJobNumber(String jobNumber) {
			super.change(JOB_NUMBER,super.getJobNumber(),jobNumber);
			super.setJobNumber(jobNumber);
			return this;
		}
		
		/**
		 * 设置 加班
		 * @param jbCnt 加班
		 * @return 当前对象
		*/
		public PersonAttendanceRec setJbCnt(BigDecimal jbCnt) {
			super.change(JB_CNT,super.getJbCnt(),jbCnt);
			super.setJbCnt(jbCnt);
			return this;
		}
		
		/**
		 * 设置 年假
		 * @param njCnt 年假
		 * @return 当前对象
		*/
		public PersonAttendanceRec setNjCnt(BigDecimal njCnt) {
			super.change(NJ_CNT,super.getNjCnt(),njCnt);
			super.setNjCnt(njCnt);
			return this;
		}
		
		/**
		 * 设置 事假
		 * @param sjCnt 事假
		 * @return 当前对象
		*/
		public PersonAttendanceRec setSjCnt(BigDecimal sjCnt) {
			super.change(SJ_CNT,super.getSjCnt(),sjCnt);
			super.setSjCnt(sjCnt);
			return this;
		}
		
		/**
		 * 设置 病假
		 * @param bjCnt 病假
		 * @return 当前对象
		*/
		public PersonAttendanceRec setBjCnt(BigDecimal bjCnt) {
			super.change(BJ_CNT,super.getBjCnt(),bjCnt);
			super.setBjCnt(bjCnt);
			return this;
		}
		
		/**
		 * 设置 出差
		 * @param ccCnt 出差
		 * @return 当前对象
		*/
		public PersonAttendanceRec setCcCnt(BigDecimal ccCnt) {
			super.change(CC_CNT,super.getCcCnt(),ccCnt);
			super.setCcCnt(ccCnt);
			return this;
		}
		
		/**
		 * 设置 其他假
		 * @param otherCnt 其他假
		 * @return 当前对象
		*/
		public PersonAttendanceRec setOtherCnt(BigDecimal otherCnt) {
			super.change(OTHER_CNT,super.getOtherCnt(),otherCnt);
			super.setOtherCnt(otherCnt);
			return this;
		}
		
		/**
		 * 设置 记录时间
		 * @param recTime 记录时间
		 * @return 当前对象
		*/
		public PersonAttendanceRec setRecTime(Date recTime) {
			super.change(REC_TIME,super.getRecTime(),recTime);
			super.setRecTime(recTime);
			return this;
		}
		
		/**
		 * 设置 批次号
		 * @param batchCode 批次号
		 * @return 当前对象
		*/
		public PersonAttendanceRec setBatchCode(String batchCode) {
			super.change(BATCH_CODE,super.getBatchCode(),batchCode);
			super.setBatchCode(batchCode);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public PersonAttendanceRec setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param source 来源
		 * @return 当前对象
		*/
		public PersonAttendanceRec setSource(String source) {
			super.change(SOURCE,super.getSource(),source);
			super.setSource(source);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PersonAttendanceRec setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PersonAttendanceRec setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PersonAttendanceRec setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PersonAttendanceRec setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PersonAttendanceRec setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PersonAttendanceRec setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PersonAttendanceRec setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public PersonAttendanceRec setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PersonAttendanceRec setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 person
		 * @param person person
		 * @return 当前对象
		*/
		public PersonAttendanceRec setPerson(Person person) {
			super.change(PERSON,super.getPerson(),person);
			super.setPerson(person);
			return this;
		}
		
		/**
		 * 设置 employee
		 * @param employee employee
		 * @return 当前对象
		*/
		public PersonAttendanceRec setEmployee(Employee employee) {
			super.change(EMPLOYEE,super.getEmployee(),employee);
			super.setEmployee(employee);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PersonAttendanceRec clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PersonAttendanceRec duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setRecTime(this.getRecTime());
			inst.setBatchCode(this.getBatchCode());
			inst.setCcCnt(this.getCcCnt());
			inst.setOtherCnt(this.getOtherCnt());
			inst.setEmployeeId(this.getEmployeeId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setSource(this.getSource());
			inst.setVersion(this.getVersion());
			inst.setJbCnt(this.getJbCnt());
			inst.setNjCnt(this.getNjCnt());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setSjCnt(this.getSjCnt());
			inst.setBjCnt(this.getBjCnt());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setPersonId(this.getPersonId());
			inst.setId(this.getId());
			inst.setJobNumber(this.getJobNumber());
			if(all) {
				inst.setPerson(this.getPerson());
				inst.setEmployee(this.getEmployee());
			}
			inst.clearModifies();
			return inst;
		}

	}
}