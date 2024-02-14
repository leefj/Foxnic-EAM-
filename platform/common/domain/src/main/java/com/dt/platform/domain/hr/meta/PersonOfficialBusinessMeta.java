package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.PersonOfficialBusiness;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import java.util.List;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-14 12:58:00
 * @sign F42AD5D7D23945DD6F80A9510C01F382
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PersonOfficialBusinessMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,BUSINESS_CODE, java.lang.String.class, "编号", "编号", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 申请人员 , 类型: java.lang.String
	*/
	public static final String PERSON_ID="personId";
	
	/**
	 * 申请人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.lang.String> PERSON_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,PERSON_ID, java.lang.String.class, "申请人员", "申请人员", java.lang.String.class, null);
	
	/**
	 * 出差日期 , 类型: java.util.Date
	*/
	public static final String LEAVE_DATE="leaveDate";
	
	/**
	 * 出差日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.util.Date> LEAVE_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,LEAVE_DATE, java.util.Date.class, "出差日期", "出差日期", java.util.Date.class, null);
	
	/**
	 * 原因 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 原因 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,CONTENT, java.lang.String.class, "原因", "原因", java.lang.String.class, null);
	
	/**
	 * 地点 , 类型: java.lang.String
	*/
	public static final String LOCATION="location";
	
	/**
	 * 地点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.lang.String> LOCATION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,LOCATION, java.lang.String.class, "地点", "地点", java.lang.String.class, null);
	
	/**
	 * 天数 , 类型: java.math.BigDecimal
	*/
	public static final String DAYS="days";
	
	/**
	 * 天数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.math.BigDecimal> DAYS_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,DAYS, java.math.BigDecimal.class, "天数", "天数", java.math.BigDecimal.class, null);
	
	/**
	 * 申请费用 , 类型: java.math.BigDecimal
	*/
	public static final String MONEY="money";
	
	/**
	 * 申请费用 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.math.BigDecimal> MONEY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,MONEY, java.math.BigDecimal.class, "申请费用", "申请费用", java.math.BigDecimal.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * person , 类型: org.github.foxnic.web.domain.hrm.Person
	*/
	public static final String PERSON="person";
	
	/**
	 * person , 类型: org.github.foxnic.web.domain.hrm.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,org.github.foxnic.web.domain.hrm.Person> PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,PERSON, org.github.foxnic.web.domain.hrm.Person.class, "person", "person", org.github.foxnic.web.domain.hrm.Person.class, null);
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String HISTORIC_PROCESS_LIST="historicProcessList";
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,org.github.foxnic.web.domain.bpm.ProcessInstance> HISTORIC_PROCESS_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,HISTORIC_PROCESS_LIST, java.util.List.class, "历史流程清单", "历史流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String CURRENT_PROCESS_LIST="currentProcessList";
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,org.github.foxnic.web.domain.bpm.ProcessInstance> CURRENT_PROCESS_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,CURRENT_PROCESS_LIST, java.util.List.class, "在批的流程清单", "在批的流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 默认流程 , 优先取在批的流程 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String DEFAULT_PROCESS="defaultProcess";
	
	/**
	 * 默认流程 , 优先取在批的流程 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonOfficialBusiness,org.github.foxnic.web.domain.bpm.ProcessInstance> DEFAULT_PROCESS_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonOfficialBusiness.class ,DEFAULT_PROCESS, org.github.foxnic.web.domain.bpm.ProcessInstance.class, "默认流程", "优先取在批的流程", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BUSINESS_CODE , STATUS , PERSON_ID , LEAVE_DATE , CONTENT , LOCATION , DAYS , MONEY , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PERSON , HISTORIC_PROCESS_LIST , CURRENT_PROCESS_LIST , DEFAULT_PROCESS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.PersonOfficialBusiness {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编号
		 * @param businessCode 编号
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 申请人员
		 * @param personId 申请人员
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setPersonId(String personId) {
			super.change(PERSON_ID,super.getPersonId(),personId);
			super.setPersonId(personId);
			return this;
		}
		
		/**
		 * 设置 出差日期
		 * @param leaveDate 出差日期
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setLeaveDate(Date leaveDate) {
			super.change(LEAVE_DATE,super.getLeaveDate(),leaveDate);
			super.setLeaveDate(leaveDate);
			return this;
		}
		
		/**
		 * 设置 原因
		 * @param content 原因
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 地点
		 * @param location 地点
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setLocation(String location) {
			super.change(LOCATION,super.getLocation(),location);
			super.setLocation(location);
			return this;
		}
		
		/**
		 * 设置 天数
		 * @param days 天数
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setDays(BigDecimal days) {
			super.change(DAYS,super.getDays(),days);
			super.setDays(days);
			return this;
		}
		
		/**
		 * 设置 申请费用
		 * @param money 申请费用
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setMoney(BigDecimal money) {
			super.change(MONEY,super.getMoney(),money);
			super.setMoney(money);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 person
		 * @param person person
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setPerson(Person person) {
			super.change(PERSON,super.getPerson(),person);
			super.setPerson(person);
			return this;
		}
		
		/**
		 * 设置 历史流程清单
		 * @param historicProcessList 历史流程清单
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setHistoricProcessList(List<ProcessInstance> historicProcessList) {
			super.change(HISTORIC_PROCESS_LIST,super.getHistoricProcessList(),historicProcessList);
			super.setHistoricProcessList(historicProcessList);
			return this;
		}
		
		/**
		 * 设置 在批的流程清单
		 * @param currentProcessList 在批的流程清单
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setCurrentProcessList(List<ProcessInstance> currentProcessList) {
			super.change(CURRENT_PROCESS_LIST,super.getCurrentProcessList(),currentProcessList);
			super.setCurrentProcessList(currentProcessList);
			return this;
		}
		
		/**
		 * 设置 默认流程
		 * @param defaultProcess 默认流程
		 * @return 当前对象
		*/
		public PersonOfficialBusiness setDefaultProcess(ProcessInstance defaultProcess) {
			super.change(DEFAULT_PROCESS,super.getDefaultProcess(),defaultProcess);
			super.setDefaultProcess(defaultProcess);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PersonOfficialBusiness clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PersonOfficialBusiness duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setBusinessCode(this.getBusinessCode());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setMoney(this.getMoney());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setLeaveDate(this.getLeaveDate());
			inst.setTenantId(this.getTenantId());
			inst.setDays(this.getDays());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setPersonId(this.getPersonId());
			inst.setLocation(this.getLocation());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setPerson(this.getPerson());
				inst.setHistoricProcessList(this.getHistoricProcessList());
				inst.setCurrentProcessList(this.getCurrentProcessList());
				inst.setDefaultProcess(this.getDefaultProcess());
			}
			inst.clearModifies();
			return inst;
		}

	}
}