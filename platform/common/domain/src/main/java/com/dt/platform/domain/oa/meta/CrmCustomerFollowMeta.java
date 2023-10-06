package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.CrmCustomerFollow;
import java.util.Date;
import com.dt.platform.domain.oa.CrmCustomer;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-16 22:51:41
 * @sign 20D8907C4019DE799BC4FC514BCEC8AB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CrmCustomerFollowMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerFollow,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerFollow.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 客户 , 类型: java.lang.String
	*/
	public static final String CUSTOMER_ID="customerId";
	
	/**
	 * 客户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerFollow,java.lang.String> CUSTOMER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerFollow.class ,CUSTOMER_ID, java.lang.String.class, "客户", "客户", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerFollow,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerFollow.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final String REC_TIME="recTime";
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerFollow,java.util.Date> REC_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerFollow.class ,REC_TIME, java.util.Date.class, "记录时间", "记录时间", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerFollow,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerFollow.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String FILE_ID="fileId";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerFollow,java.lang.String> FILE_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerFollow.class ,FILE_ID, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerFollow,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerFollow.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerFollow,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerFollow.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerFollow,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerFollow.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerFollow,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerFollow.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerFollow,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerFollow.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerFollow,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerFollow.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerFollow,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerFollow.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerFollow,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerFollow.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerFollow,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerFollow.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerFollow,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerFollow.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * crmCustomer , 类型: com.dt.platform.domain.oa.CrmCustomer
	*/
	public static final String CRM_CUSTOMER="crmCustomer";
	
	/**
	 * crmCustomer , 类型: com.dt.platform.domain.oa.CrmCustomer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerFollow,com.dt.platform.domain.oa.CrmCustomer> CRM_CUSTOMER_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerFollow.class ,CRM_CUSTOMER, com.dt.platform.domain.oa.CrmCustomer.class, "crmCustomer", "crmCustomer", com.dt.platform.domain.oa.CrmCustomer.class, null);
	
	/**
	 * originator , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * originator , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerFollow,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerFollow.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "originator", "originator", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CUSTOMER_ID , CONTENT , REC_TIME , NOTES , FILE_ID , ORIGINATOR_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , CRM_CUSTOMER , ORIGINATOR };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.CrmCustomerFollow {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CrmCustomerFollow setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 客户
		 * @param customerId 客户
		 * @return 当前对象
		*/
		public CrmCustomerFollow setCustomerId(String customerId) {
			super.change(CUSTOMER_ID,super.getCustomerId(),customerId);
			super.setCustomerId(customerId);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public CrmCustomerFollow setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 记录时间
		 * @param recTime 记录时间
		 * @return 当前对象
		*/
		public CrmCustomerFollow setRecTime(Date recTime) {
			super.change(REC_TIME,super.getRecTime(),recTime);
			super.setRecTime(recTime);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public CrmCustomerFollow setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param fileId 附件
		 * @return 当前对象
		*/
		public CrmCustomerFollow setFileId(String fileId) {
			super.change(FILE_ID,super.getFileId(),fileId);
			super.setFileId(fileId);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public CrmCustomerFollow setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public CrmCustomerFollow setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CrmCustomerFollow setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CrmCustomerFollow setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CrmCustomerFollow setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CrmCustomerFollow setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CrmCustomerFollow setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CrmCustomerFollow setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CrmCustomerFollow setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public CrmCustomerFollow setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 crmCustomer
		 * @param crmCustomer crmCustomer
		 * @return 当前对象
		*/
		public CrmCustomerFollow setCrmCustomer(CrmCustomer crmCustomer) {
			super.change(CRM_CUSTOMER,super.getCrmCustomer(),crmCustomer);
			super.setCrmCustomer(crmCustomer);
			return this;
		}
		
		/**
		 * 设置 originator
		 * @param originator originator
		 * @return 当前对象
		*/
		public CrmCustomerFollow setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CrmCustomerFollow clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CrmCustomerFollow duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setRecTime(this.getRecTime());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setCustomerId(this.getCustomerId());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setOriginatorId(this.getOriginatorId());
			inst.setFileId(this.getFileId());
			if(all) {
				inst.setCrmCustomer(this.getCrmCustomer());
				inst.setOriginator(this.getOriginator());
			}
			inst.clearModifies();
			return inst;
		}

	}
}