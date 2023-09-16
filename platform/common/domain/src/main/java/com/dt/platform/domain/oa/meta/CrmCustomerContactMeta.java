package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.CrmCustomerContact;
import java.util.Date;
import com.dt.platform.domain.oa.CrmCustomer;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-16 22:55:54
 * @sign 1CD16A5C1CAF8604AE44A5A34E77A569
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CrmCustomerContactMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 客户 , 类型: java.lang.String
	*/
	public static final String CUSTOMER_ID="customerId";
	
	/**
	 * 客户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.String> CUSTOMER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,CUSTOMER_ID, java.lang.String.class, "客户", "客户", java.lang.String.class, null);
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,NAME, java.lang.String.class, "姓名", "姓名", java.lang.String.class, null);
	
	/**
	 * 手机 , 类型: java.lang.String
	*/
	public static final String MOBILE="mobile";
	
	/**
	 * 手机 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.String> MOBILE_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,MOBILE, java.lang.String.class, "手机", "手机", java.lang.String.class, null);
	
	/**
	 * 邮箱 , 类型: java.lang.String
	*/
	public static final String MAIL="mail";
	
	/**
	 * 邮箱 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.String> MAIL_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,MAIL, java.lang.String.class, "邮箱", "邮箱", java.lang.String.class, null);
	
	/**
	 * 微信 , 类型: java.lang.String
	*/
	public static final String WEXIN="wexin";
	
	/**
	 * 微信 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.String> WEXIN_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,WEXIN, java.lang.String.class, "微信", "微信", java.lang.String.class, null);
	
	/**
	 * 职位 , 类型: java.lang.String
	*/
	public static final String JOB="job";
	
	/**
	 * 职位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.String> JOB_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,JOB, java.lang.String.class, "职位", "职位", java.lang.String.class, null);
	
	/**
	 * 性别 , 类型: java.lang.String
	*/
	public static final String SEX="sex";
	
	/**
	 * 性别 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.String> SEX_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,SEX, java.lang.String.class, "性别", "性别", java.lang.String.class, null);
	
	/**
	 * 地址 , 类型: java.lang.String
	*/
	public static final String ADDRESS="address";
	
	/**
	 * 地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.String> ADDRESS_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,ADDRESS, java.lang.String.class, "地址", "地址", java.lang.String.class, null);
	
	/**
	 * 角色 , 类型: java.lang.String
	*/
	public static final String ROLE="role";
	
	/**
	 * 角色 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.String> ROLE_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,ROLE, java.lang.String.class, "角色", "角色", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * crmCustomer , 类型: com.dt.platform.domain.oa.CrmCustomer
	*/
	public static final String CRM_CUSTOMER="crmCustomer";
	
	/**
	 * crmCustomer , 类型: com.dt.platform.domain.oa.CrmCustomer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,com.dt.platform.domain.oa.CrmCustomer> CRM_CUSTOMER_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,CRM_CUSTOMER, com.dt.platform.domain.oa.CrmCustomer.class, "crmCustomer", "crmCustomer", com.dt.platform.domain.oa.CrmCustomer.class, null);
	
	/**
	 * originator , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * originator , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "originator", "originator", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * searchCustomerType , 类型: java.lang.String
	*/
	public static final String SEARCH_CUSTOMER_TYPE="searchCustomerType";
	
	/**
	 * searchCustomerType , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.CrmCustomerContact,java.lang.String> SEARCH_CUSTOMER_TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.CrmCustomerContact.class ,SEARCH_CUSTOMER_TYPE, java.lang.String.class, "searchCustomerType", "searchCustomerType", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CUSTOMER_ID , NAME , MOBILE , MAIL , WEXIN , JOB , SEX , ADDRESS , ROLE , NOTES , ORIGINATOR_ID , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , CRM_CUSTOMER , ORIGINATOR , SEARCH_CUSTOMER_TYPE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.CrmCustomerContact {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CrmCustomerContact setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 客户
		 * @param customerId 客户
		 * @return 当前对象
		*/
		public CrmCustomerContact setCustomerId(String customerId) {
			super.change(CUSTOMER_ID,super.getCustomerId(),customerId);
			super.setCustomerId(customerId);
			return this;
		}
		
		/**
		 * 设置 姓名
		 * @param name 姓名
		 * @return 当前对象
		*/
		public CrmCustomerContact setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 手机
		 * @param mobile 手机
		 * @return 当前对象
		*/
		public CrmCustomerContact setMobile(String mobile) {
			super.change(MOBILE,super.getMobile(),mobile);
			super.setMobile(mobile);
			return this;
		}
		
		/**
		 * 设置 邮箱
		 * @param mail 邮箱
		 * @return 当前对象
		*/
		public CrmCustomerContact setMail(String mail) {
			super.change(MAIL,super.getMail(),mail);
			super.setMail(mail);
			return this;
		}
		
		/**
		 * 设置 微信
		 * @param wexin 微信
		 * @return 当前对象
		*/
		public CrmCustomerContact setWexin(String wexin) {
			super.change(WEXIN,super.getWexin(),wexin);
			super.setWexin(wexin);
			return this;
		}
		
		/**
		 * 设置 职位
		 * @param job 职位
		 * @return 当前对象
		*/
		public CrmCustomerContact setJob(String job) {
			super.change(JOB,super.getJob(),job);
			super.setJob(job);
			return this;
		}
		
		/**
		 * 设置 性别
		 * @param sex 性别
		 * @return 当前对象
		*/
		public CrmCustomerContact setSex(String sex) {
			super.change(SEX,super.getSex(),sex);
			super.setSex(sex);
			return this;
		}
		
		/**
		 * 设置 地址
		 * @param address 地址
		 * @return 当前对象
		*/
		public CrmCustomerContact setAddress(String address) {
			super.change(ADDRESS,super.getAddress(),address);
			super.setAddress(address);
			return this;
		}
		
		/**
		 * 设置 角色
		 * @param role 角色
		 * @return 当前对象
		*/
		public CrmCustomerContact setRole(String role) {
			super.change(ROLE,super.getRole(),role);
			super.setRole(role);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public CrmCustomerContact setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public CrmCustomerContact setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public CrmCustomerContact setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CrmCustomerContact setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CrmCustomerContact setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CrmCustomerContact setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CrmCustomerContact setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CrmCustomerContact setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CrmCustomerContact setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CrmCustomerContact setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public CrmCustomerContact setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 crmCustomer
		 * @param crmCustomer crmCustomer
		 * @return 当前对象
		*/
		public CrmCustomerContact setCrmCustomer(CrmCustomer crmCustomer) {
			super.change(CRM_CUSTOMER,super.getCrmCustomer(),crmCustomer);
			super.setCrmCustomer(crmCustomer);
			return this;
		}
		
		/**
		 * 设置 originator
		 * @param originator originator
		 * @return 当前对象
		*/
		public CrmCustomerContact setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 searchCustomerType
		 * @param searchCustomerType searchCustomerType
		 * @return 当前对象
		*/
		public CrmCustomerContact setSearchCustomerType(String searchCustomerType) {
			super.change(SEARCH_CUSTOMER_TYPE,super.getSearchCustomerType(),searchCustomerType);
			super.setSearchCustomerType(searchCustomerType);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CrmCustomerContact clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CrmCustomerContact duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setAddress(this.getAddress());
			inst.setRole(this.getRole());
			inst.setNotes(this.getNotes());
			inst.setMail(this.getMail());
			inst.setSex(this.getSex());
			inst.setMobile(this.getMobile());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setWexin(this.getWexin());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setCustomerId(this.getCustomerId());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setOriginatorId(this.getOriginatorId());
			inst.setJob(this.getJob());
			if(all) {
				inst.setCrmCustomer(this.getCrmCustomer());
				inst.setOriginator(this.getOriginator());
				inst.setSearchCustomerType(this.getSearchCustomerType());
			}
			inst.clearModifies();
			return inst;
		}

	}
}