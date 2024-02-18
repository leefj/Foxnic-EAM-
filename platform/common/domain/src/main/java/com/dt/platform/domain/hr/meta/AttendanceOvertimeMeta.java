package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AttendanceOvertime;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.hr.Person;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-16 20:54:15
 * @sign 24670E306472D8E54B6D48389E11BC0B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AttendanceOvertimeMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final String PERSON_ID="personId";
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.lang.String> PERSON_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,PERSON_ID, java.lang.String.class, "人员", "人员", java.lang.String.class, null);
	
	/**
	 * 加班日期 , 类型: java.util.Date
	*/
	public static final String ACTION_DATE="actionDate";
	
	/**
	 * 加班日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.util.Date> ACTION_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,ACTION_DATE, java.util.Date.class, "加班日期", "加班日期", java.util.Date.class, null);
	
	/**
	 * 加班类型 , 类型: java.lang.String
	*/
	public static final String ACTION_TYPE="actionType";
	
	/**
	 * 加班类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.lang.String> ACTION_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,ACTION_TYPE, java.lang.String.class, "加班类型", "加班类型", java.lang.String.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String ACTION_S_TIME="actionSTime";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.util.Date> ACTION_S_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,ACTION_S_TIME, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final String ACTION_E_TIME="actionETime";
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.util.Date> ACTION_E_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,ACTION_E_TIME, java.util.Date.class, "结束时间", "结束时间", java.util.Date.class, null);
	
	/**
	 * 加班小时 , 类型: java.math.BigDecimal
	*/
	public static final String ACTION_HOUR="actionHour";
	
	/**
	 * 加班小时 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.math.BigDecimal> ACTION_HOUR_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,ACTION_HOUR, java.math.BigDecimal.class, "加班小时", "加班小时", java.math.BigDecimal.class, null);
	
	/**
	 * 加班备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 加班备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,NOTES, java.lang.String.class, "加班备注", "加班备注", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String FILE_ID="fileId";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.lang.String> FILE_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,FILE_ID, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 批次号 , 类型: java.lang.String
	*/
	public static final String BATCH_CODE="batchCode";
	
	/**
	 * 批次号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.lang.String> BATCH_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,BATCH_CODE, java.lang.String.class, "批次号", "批次号", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * typeDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String TYPE_DICT="typeDict";
	
	/**
	 * typeDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,org.github.foxnic.web.domain.system.DictItem> TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "typeDict", "typeDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * person , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final String PERSON="person";
	
	/**
	 * person , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,com.dt.platform.domain.hr.Person> PERSON_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,PERSON, com.dt.platform.domain.hr.Person.class, "person", "person", com.dt.platform.domain.hr.Person.class, null);
	
	/**
	 * personJobNumber , 类型: java.lang.String
	*/
	public static final String PERSON_JOB_NUMBER="personJobNumber";
	
	/**
	 * personJobNumber , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.lang.String> PERSON_JOB_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,PERSON_JOB_NUMBER, java.lang.String.class, "personJobNumber", "personJobNumber", java.lang.String.class, null);
	
	/**
	 * sOrgId , 类型: java.lang.String
	*/
	public static final String S_ORG_ID="sOrgId";
	
	/**
	 * sOrgId , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceOvertime,java.lang.String> S_ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceOvertime.class ,S_ORG_ID, java.lang.String.class, "sOrgId", "sOrgId", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PERSON_ID , ACTION_DATE , ACTION_TYPE , ACTION_S_TIME , ACTION_E_TIME , ACTION_HOUR , NOTES , FILE_ID , BATCH_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , TYPE_DICT , PERSON , PERSON_JOB_NUMBER , S_ORG_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AttendanceOvertime {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AttendanceOvertime setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 人员
		 * @param personId 人员
		 * @return 当前对象
		*/
		public AttendanceOvertime setPersonId(String personId) {
			super.change(PERSON_ID,super.getPersonId(),personId);
			super.setPersonId(personId);
			return this;
		}
		
		/**
		 * 设置 加班日期
		 * @param actionDate 加班日期
		 * @return 当前对象
		*/
		public AttendanceOvertime setActionDate(Date actionDate) {
			super.change(ACTION_DATE,super.getActionDate(),actionDate);
			super.setActionDate(actionDate);
			return this;
		}
		
		/**
		 * 设置 加班类型
		 * @param actionType 加班类型
		 * @return 当前对象
		*/
		public AttendanceOvertime setActionType(String actionType) {
			super.change(ACTION_TYPE,super.getActionType(),actionType);
			super.setActionType(actionType);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param actionSTime 开始时间
		 * @return 当前对象
		*/
		public AttendanceOvertime setActionSTime(Date actionSTime) {
			super.change(ACTION_S_TIME,super.getActionSTime(),actionSTime);
			super.setActionSTime(actionSTime);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param actionETime 结束时间
		 * @return 当前对象
		*/
		public AttendanceOvertime setActionETime(Date actionETime) {
			super.change(ACTION_E_TIME,super.getActionETime(),actionETime);
			super.setActionETime(actionETime);
			return this;
		}
		
		/**
		 * 设置 加班小时
		 * @param actionHour 加班小时
		 * @return 当前对象
		*/
		public AttendanceOvertime setActionHour(BigDecimal actionHour) {
			super.change(ACTION_HOUR,super.getActionHour(),actionHour);
			super.setActionHour(actionHour);
			return this;
		}
		
		/**
		 * 设置 加班备注
		 * @param notes 加班备注
		 * @return 当前对象
		*/
		public AttendanceOvertime setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param fileId 附件
		 * @return 当前对象
		*/
		public AttendanceOvertime setFileId(String fileId) {
			super.change(FILE_ID,super.getFileId(),fileId);
			super.setFileId(fileId);
			return this;
		}
		
		/**
		 * 设置 批次号
		 * @param batchCode 批次号
		 * @return 当前对象
		*/
		public AttendanceOvertime setBatchCode(String batchCode) {
			super.change(BATCH_CODE,super.getBatchCode(),batchCode);
			super.setBatchCode(batchCode);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AttendanceOvertime setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AttendanceOvertime setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AttendanceOvertime setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AttendanceOvertime setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AttendanceOvertime setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AttendanceOvertime setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AttendanceOvertime setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AttendanceOvertime setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AttendanceOvertime setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 typeDict
		 * @param typeDict typeDict
		 * @return 当前对象
		*/
		public AttendanceOvertime setTypeDict(DictItem typeDict) {
			super.change(TYPE_DICT,super.getTypeDict(),typeDict);
			super.setTypeDict(typeDict);
			return this;
		}
		
		/**
		 * 设置 person
		 * @param person person
		 * @return 当前对象
		*/
		public AttendanceOvertime setPerson(Person person) {
			super.change(PERSON,super.getPerson(),person);
			super.setPerson(person);
			return this;
		}
		
		/**
		 * 设置 personJobNumber
		 * @param personJobNumber personJobNumber
		 * @return 当前对象
		*/
		public AttendanceOvertime setPersonJobNumber(String personJobNumber) {
			super.change(PERSON_JOB_NUMBER,super.getPersonJobNumber(),personJobNumber);
			super.setPersonJobNumber(personJobNumber);
			return this;
		}
		
		/**
		 * 设置 sOrgId
		 * @param sOrgId sOrgId
		 * @return 当前对象
		*/
		public AttendanceOvertime setSOrgId(String sOrgId) {
			super.change(S_ORG_ID,super.getSOrgId(),sOrgId);
			super.setSOrgId(sOrgId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AttendanceOvertime clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AttendanceOvertime duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setActionHour(this.getActionHour());
			inst.setNotes(this.getNotes());
			inst.setActionSTime(this.getActionSTime());
			inst.setBatchCode(this.getBatchCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setActionType(this.getActionType());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setActionETime(this.getActionETime());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setPersonId(this.getPersonId());
			inst.setId(this.getId());
			inst.setActionDate(this.getActionDate());
			inst.setFileId(this.getFileId());
			if(all) {
				inst.setPerson(this.getPerson());
				inst.setSOrgId(this.getSOrgId());
				inst.setTypeDict(this.getTypeDict());
				inst.setPersonJobNumber(this.getPersonJobNumber());
			}
			inst.clearModifies();
			return inst;
		}

	}
}