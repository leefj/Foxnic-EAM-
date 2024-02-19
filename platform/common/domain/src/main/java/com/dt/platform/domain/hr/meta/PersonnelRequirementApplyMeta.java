package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.PersonnelRequirementApply;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import java.util.List;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-19 20:04:44
 * @sign BFFB80796D482941808242EB2F84FF3E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PersonnelRequirementApplyMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 流程编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 流程编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,BUSINESS_CODE, java.lang.String.class, "流程编号", "流程编号", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 征集主题 , 类型: java.lang.String
	*/
	public static final String TITLE="title";
	
	/**
	 * 征集主题 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.String> TITLE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,TITLE, java.lang.String.class, "征集主题", "征集主题", java.lang.String.class, null);
	
	/**
	 * 需求部门 , 类型: java.lang.String
	*/
	public static final String ORG_ID="orgId";
	
	/**
	 * 需求部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.String> ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,ORG_ID, java.lang.String.class, "需求部门", "需求部门", java.lang.String.class, null);
	
	/**
	 * 薪酬范围 , 类型: java.lang.String
	*/
	public static final String SALARY="salary";
	
	/**
	 * 薪酬范围 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.String> SALARY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,SALARY, java.lang.String.class, "薪酬范围", "薪酬范围", java.lang.String.class, null);
	
	/**
	 * 需求岗位 , 类型: java.lang.String
	*/
	public static final String POS="pos";
	
	/**
	 * 需求岗位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.String> POS_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,POS, java.lang.String.class, "需求岗位", "需求岗位", java.lang.String.class, null);
	
	/**
	 * 需求人数 , 类型: java.lang.Integer
	*/
	public static final String PERSON_NUMBER="personNumber";
	
	/**
	 * 需求人数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.Integer> PERSON_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,PERSON_NUMBER, java.lang.Integer.class, "需求人数", "需求人数", java.lang.Integer.class, null);
	
	/**
	 * 招聘方式 , 类型: java.lang.String
	*/
	public static final String METHOD="method";
	
	/**
	 * 招聘方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.String> METHOD_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,METHOD, java.lang.String.class, "招聘方式", "招聘方式", java.lang.String.class, null);
	
	/**
	 * 开始日期 , 类型: java.util.Date
	*/
	public static final String SDATE="sdate";
	
	/**
	 * 开始日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.util.Date> SDATE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,SDATE, java.util.Date.class, "开始日期", "开始日期", java.util.Date.class, null);
	
	/**
	 * 结束日期 , 类型: java.util.Date
	*/
	public static final String EDATE="edate";
	
	/**
	 * 结束日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.util.Date> EDATE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,EDATE, java.util.Date.class, "结束日期", "结束日期", java.util.Date.class, null);
	
	/**
	 * 岗位要求 , 类型: java.lang.String
	*/
	public static final String JOB_REQUIREMENT="jobRequirement";
	
	/**
	 * 岗位要求 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.String> JOB_REQUIREMENT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,JOB_REQUIREMENT, java.lang.String.class, "岗位要求", "岗位要求", java.lang.String.class, null);
	
	/**
	 * 工作内容 , 类型: java.lang.String
	*/
	public static final String WORK_CONTENT="workContent";
	
	/**
	 * 工作内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.String> WORK_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,WORK_CONTENT, java.lang.String.class, "工作内容", "工作内容", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final String APPLY_USER_ID="applyUserId";
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.String> APPLY_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,APPLY_USER_ID, java.lang.String.class, "申请人", "申请人", java.lang.String.class, null);
	
	/**
	 * 选择流程 , 类型: java.lang.String
	*/
	public static final String PROCESS_CODE="processCode";
	
	/**
	 * 选择流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.String> PROCESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,PROCESS_CODE, java.lang.String.class, "选择流程", "选择流程", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * organization , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String ORGANIZATION="organization";
	
	/**
	 * organization , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,org.github.foxnic.web.domain.hrm.Organization> ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "organization", "organization", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * person , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String PERSON="person";
	
	/**
	 * person , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,org.github.foxnic.web.domain.hrm.Employee> PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,PERSON, org.github.foxnic.web.domain.hrm.Employee.class, "person", "person", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String HISTORIC_PROCESS_LIST="historicProcessList";
	
	/**
	 * 历史流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,org.github.foxnic.web.domain.bpm.ProcessInstance> HISTORIC_PROCESS_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,HISTORIC_PROCESS_LIST, java.util.List.class, "历史流程清单", "历史流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String CURRENT_PROCESS_LIST="currentProcessList";
	
	/**
	 * 在批的流程清单 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,org.github.foxnic.web.domain.bpm.ProcessInstance> CURRENT_PROCESS_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,CURRENT_PROCESS_LIST, java.util.List.class, "在批的流程清单", "在批的流程清单", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 默认流程 , 优先取在批的流程 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final String DEFAULT_PROCESS="defaultProcess";
	
	/**
	 * 默认流程 , 优先取在批的流程 , 类型: org.github.foxnic.web.domain.bpm.ProcessInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonnelRequirementApply,org.github.foxnic.web.domain.bpm.ProcessInstance> DEFAULT_PROCESS_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonnelRequirementApply.class ,DEFAULT_PROCESS, org.github.foxnic.web.domain.bpm.ProcessInstance.class, "默认流程", "优先取在批的流程", org.github.foxnic.web.domain.bpm.ProcessInstance.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BUSINESS_CODE , STATUS , TITLE , ORG_ID , SALARY , POS , PERSON_NUMBER , METHOD , SDATE , EDATE , JOB_REQUIREMENT , WORK_CONTENT , NOTES , APPLY_USER_ID , PROCESS_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ORGANIZATION , PERSON , HISTORIC_PROCESS_LIST , CURRENT_PROCESS_LIST , DEFAULT_PROCESS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.PersonnelRequirementApply {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 流程编号
		 * @param businessCode 流程编号
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 征集主题
		 * @param title 征集主题
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setTitle(String title) {
			super.change(TITLE,super.getTitle(),title);
			super.setTitle(title);
			return this;
		}
		
		/**
		 * 设置 需求部门
		 * @param orgId 需求部门
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setOrgId(String orgId) {
			super.change(ORG_ID,super.getOrgId(),orgId);
			super.setOrgId(orgId);
			return this;
		}
		
		/**
		 * 设置 薪酬范围
		 * @param salary 薪酬范围
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setSalary(String salary) {
			super.change(SALARY,super.getSalary(),salary);
			super.setSalary(salary);
			return this;
		}
		
		/**
		 * 设置 需求岗位
		 * @param pos 需求岗位
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setPos(String pos) {
			super.change(POS,super.getPos(),pos);
			super.setPos(pos);
			return this;
		}
		
		/**
		 * 设置 需求人数
		 * @param personNumber 需求人数
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setPersonNumber(Integer personNumber) {
			super.change(PERSON_NUMBER,super.getPersonNumber(),personNumber);
			super.setPersonNumber(personNumber);
			return this;
		}
		
		/**
		 * 设置 招聘方式
		 * @param method 招聘方式
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setMethod(String method) {
			super.change(METHOD,super.getMethod(),method);
			super.setMethod(method);
			return this;
		}
		
		/**
		 * 设置 开始日期
		 * @param sdate 开始日期
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setSdate(Date sdate) {
			super.change(SDATE,super.getSdate(),sdate);
			super.setSdate(sdate);
			return this;
		}
		
		/**
		 * 设置 结束日期
		 * @param edate 结束日期
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setEdate(Date edate) {
			super.change(EDATE,super.getEdate(),edate);
			super.setEdate(edate);
			return this;
		}
		
		/**
		 * 设置 岗位要求
		 * @param jobRequirement 岗位要求
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setJobRequirement(String jobRequirement) {
			super.change(JOB_REQUIREMENT,super.getJobRequirement(),jobRequirement);
			super.setJobRequirement(jobRequirement);
			return this;
		}
		
		/**
		 * 设置 工作内容
		 * @param workContent 工作内容
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setWorkContent(String workContent) {
			super.change(WORK_CONTENT,super.getWorkContent(),workContent);
			super.setWorkContent(workContent);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 申请人
		 * @param applyUserId 申请人
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setApplyUserId(String applyUserId) {
			super.change(APPLY_USER_ID,super.getApplyUserId(),applyUserId);
			super.setApplyUserId(applyUserId);
			return this;
		}
		
		/**
		 * 设置 选择流程
		 * @param processCode 选择流程
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setProcessCode(String processCode) {
			super.change(PROCESS_CODE,super.getProcessCode(),processCode);
			super.setProcessCode(processCode);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 organization
		 * @param organization organization
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setOrganization(Organization organization) {
			super.change(ORGANIZATION,super.getOrganization(),organization);
			super.setOrganization(organization);
			return this;
		}
		
		/**
		 * 设置 person
		 * @param person person
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setPerson(Employee person) {
			super.change(PERSON,super.getPerson(),person);
			super.setPerson(person);
			return this;
		}
		
		/**
		 * 设置 历史流程清单
		 * @param historicProcessList 历史流程清单
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setHistoricProcessList(List<ProcessInstance> historicProcessList) {
			super.change(HISTORIC_PROCESS_LIST,super.getHistoricProcessList(),historicProcessList);
			super.setHistoricProcessList(historicProcessList);
			return this;
		}
		
		/**
		 * 设置 在批的流程清单
		 * @param currentProcessList 在批的流程清单
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setCurrentProcessList(List<ProcessInstance> currentProcessList) {
			super.change(CURRENT_PROCESS_LIST,super.getCurrentProcessList(),currentProcessList);
			super.setCurrentProcessList(currentProcessList);
			return this;
		}
		
		/**
		 * 设置 默认流程
		 * @param defaultProcess 默认流程
		 * @return 当前对象
		*/
		public PersonnelRequirementApply setDefaultProcess(ProcessInstance defaultProcess) {
			super.change(DEFAULT_PROCESS,super.getDefaultProcess(),defaultProcess);
			super.setDefaultProcess(defaultProcess);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PersonnelRequirementApply clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PersonnelRequirementApply duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setWorkContent(this.getWorkContent());
			inst.setTitle(this.getTitle());
			inst.setSalary(this.getSalary());
			inst.setPersonNumber(this.getPersonNumber());
			inst.setOrgId(this.getOrgId());
			inst.setApplyUserId(this.getApplyUserId());
			inst.setBusinessCode(this.getBusinessCode());
			inst.setPos(this.getPos());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setId(this.getId());
			inst.setSdate(this.getSdate());
			inst.setMethod(this.getMethod());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setEdate(this.getEdate());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setProcessCode(this.getProcessCode());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setStatus(this.getStatus());
			inst.setJobRequirement(this.getJobRequirement());
			if(all) {
				inst.setPerson(this.getPerson());
				inst.setOrganization(this.getOrganization());
				inst.setHistoricProcessList(this.getHistoricProcessList());
				inst.setCurrentProcessList(this.getCurrentProcessList());
				inst.setDefaultProcess(this.getDefaultProcess());
			}
			inst.clearModifies();
			return inst;
		}

	}
}