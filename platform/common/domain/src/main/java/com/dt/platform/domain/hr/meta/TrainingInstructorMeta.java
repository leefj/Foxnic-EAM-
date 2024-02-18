package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.TrainingInstructor;
import java.util.Date;
import com.dt.platform.domain.hr.TrainingInstitution;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-17 17:15:31
 * @sign 8F99E412F7BAFFA79B688F881EA20763
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TrainingInstructorMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.TrainingInstructor,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.TrainingInstructor.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 工作单位 , 类型: java.lang.String
	*/
	public static final String ORG_ID="orgId";
	
	/**
	 * 工作单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.TrainingInstructor,java.lang.String> ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.TrainingInstructor.class ,ORG_ID, java.lang.String.class, "工作单位", "工作单位", java.lang.String.class, null);
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.TrainingInstructor,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.TrainingInstructor.class ,NAME, java.lang.String.class, "姓名", "姓名", java.lang.String.class, null);
	
	/**
	 * 社会头衔 , 类型: java.lang.String
	*/
	public static final String TITLE="title";
	
	/**
	 * 社会头衔 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.TrainingInstructor,java.lang.String> TITLE_PROP = new BeanProperty(com.dt.platform.domain.hr.TrainingInstructor.class ,TITLE, java.lang.String.class, "社会头衔", "社会头衔", java.lang.String.class, null);
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final String CONTACT_INFORMATION="contactInformation";
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.TrainingInstructor,java.lang.String> CONTACT_INFORMATION_PROP = new BeanProperty(com.dt.platform.domain.hr.TrainingInstructor.class ,CONTACT_INFORMATION, java.lang.String.class, "联系方式", "联系方式", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.TrainingInstructor,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.TrainingInstructor.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String FILE_ID="fileId";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.TrainingInstructor,java.lang.String> FILE_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.TrainingInstructor.class ,FILE_ID, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.TrainingInstructor,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.TrainingInstructor.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.TrainingInstructor,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.TrainingInstructor.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.TrainingInstructor,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.TrainingInstructor.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.TrainingInstructor,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.TrainingInstructor.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.TrainingInstructor,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.TrainingInstructor.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.TrainingInstructor,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.TrainingInstructor.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.TrainingInstructor,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.TrainingInstructor.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.TrainingInstructor,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.TrainingInstructor.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.TrainingInstructor,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.TrainingInstructor.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * trainingInstitution , 类型: com.dt.platform.domain.hr.TrainingInstitution
	*/
	public static final String TRAINING_INSTITUTION="trainingInstitution";
	
	/**
	 * trainingInstitution , 类型: com.dt.platform.domain.hr.TrainingInstitution
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.TrainingInstructor,com.dt.platform.domain.hr.TrainingInstitution> TRAINING_INSTITUTION_PROP = new BeanProperty(com.dt.platform.domain.hr.TrainingInstructor.class ,TRAINING_INSTITUTION, com.dt.platform.domain.hr.TrainingInstitution.class, "trainingInstitution", "trainingInstitution", com.dt.platform.domain.hr.TrainingInstitution.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ORG_ID , NAME , TITLE , CONTACT_INFORMATION , NOTES , FILE_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , TRAINING_INSTITUTION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.TrainingInstructor {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public TrainingInstructor setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 工作单位
		 * @param orgId 工作单位
		 * @return 当前对象
		*/
		public TrainingInstructor setOrgId(String orgId) {
			super.change(ORG_ID,super.getOrgId(),orgId);
			super.setOrgId(orgId);
			return this;
		}
		
		/**
		 * 设置 姓名
		 * @param name 姓名
		 * @return 当前对象
		*/
		public TrainingInstructor setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 社会头衔
		 * @param title 社会头衔
		 * @return 当前对象
		*/
		public TrainingInstructor setTitle(String title) {
			super.change(TITLE,super.getTitle(),title);
			super.setTitle(title);
			return this;
		}
		
		/**
		 * 设置 联系方式
		 * @param contactInformation 联系方式
		 * @return 当前对象
		*/
		public TrainingInstructor setContactInformation(String contactInformation) {
			super.change(CONTACT_INFORMATION,super.getContactInformation(),contactInformation);
			super.setContactInformation(contactInformation);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public TrainingInstructor setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param fileId 附件
		 * @return 当前对象
		*/
		public TrainingInstructor setFileId(String fileId) {
			super.change(FILE_ID,super.getFileId(),fileId);
			super.setFileId(fileId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public TrainingInstructor setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public TrainingInstructor setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public TrainingInstructor setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public TrainingInstructor setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public TrainingInstructor setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public TrainingInstructor setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public TrainingInstructor setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public TrainingInstructor setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public TrainingInstructor setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 trainingInstitution
		 * @param trainingInstitution trainingInstitution
		 * @return 当前对象
		*/
		public TrainingInstructor setTrainingInstitution(TrainingInstitution trainingInstitution) {
			super.change(TRAINING_INSTITUTION,super.getTrainingInstitution(),trainingInstitution);
			super.setTrainingInstitution(trainingInstitution);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public TrainingInstructor clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public TrainingInstructor duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setTitle(this.getTitle());
			inst.setVersion(this.getVersion());
			inst.setOrgId(this.getOrgId());
			inst.setCreateBy(this.getCreateBy());
			inst.setContactInformation(this.getContactInformation());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setFileId(this.getFileId());
			if(all) {
				inst.setTrainingInstitution(this.getTrainingInstitution());
			}
			inst.clearModifies();
			return inst;
		}

	}
}