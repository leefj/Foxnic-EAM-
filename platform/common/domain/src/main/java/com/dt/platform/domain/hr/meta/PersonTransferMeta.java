package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.PersonTransfer;
import java.util.Date;
import com.dt.platform.domain.hr.Position;
import org.github.foxnic.web.domain.hrm.Organization;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-22 09:34:44
 * @sign 2FCC16686528C5A673918EB2D934955E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PersonTransferMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,BUSINESS_CODE, java.lang.String.class, "编号", "编号", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 调动日期 , 类型: java.util.Date
	*/
	public static final String TRANSFER_DATE="transferDate";
	
	/**
	 * 调动日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.util.Date> TRANSFER_DATE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,TRANSFER_DATE, java.util.Date.class, "调动日期", "调动日期", java.util.Date.class, null);
	
	/**
	 * 原因 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 原因 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,CONTENT, java.lang.String.class, "原因", "原因", java.lang.String.class, null);
	
	/**
	 * 部门 , 类型: java.lang.String
	*/
	public static final String ORG_ID="orgId";
	
	/**
	 * 部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.lang.String> ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,ORG_ID, java.lang.String.class, "部门", "部门", java.lang.String.class, null);
	
	/**
	 * 岗位 , 类型: java.lang.String
	*/
	public static final String POSITION_CODE="positionCode";
	
	/**
	 * 岗位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.lang.String> POSITION_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,POSITION_CODE, java.lang.String.class, "岗位", "岗位", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String FILE_IDS="fileIds";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.lang.String> FILE_IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,FILE_IDS, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTE="note";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.lang.String> NOTE_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,NOTE, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 操作人 , 类型: java.lang.String
	*/
	public static final String OPER_USER_ID="operUserId";
	
	/**
	 * 操作人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.lang.String> OPER_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,OPER_USER_ID, java.lang.String.class, "操作人", "操作人", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * position , 类型: com.dt.platform.domain.hr.Position
	*/
	public static final String POSITION="position";
	
	/**
	 * position , 类型: com.dt.platform.domain.hr.Position
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,com.dt.platform.domain.hr.Position> POSITION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,POSITION, com.dt.platform.domain.hr.Position.class, "position", "position", com.dt.platform.domain.hr.Position.class, null);
	
	/**
	 * 所在部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String ORGANIZATION="organization";
	
	/**
	 * 所在部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.PersonTransfer,org.github.foxnic.web.domain.hrm.Organization> ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.hr.PersonTransfer.class ,ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "所在部门", "所在部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BUSINESS_CODE , STATUS , TRANSFER_DATE , CONTENT , ORG_ID , POSITION_CODE , FILE_IDS , NOTE , OPER_USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , POSITION , ORGANIZATION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.PersonTransfer {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PersonTransfer setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编号
		 * @param businessCode 编号
		 * @return 当前对象
		*/
		public PersonTransfer setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public PersonTransfer setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 调动日期
		 * @param transferDate 调动日期
		 * @return 当前对象
		*/
		public PersonTransfer setTransferDate(Date transferDate) {
			super.change(TRANSFER_DATE,super.getTransferDate(),transferDate);
			super.setTransferDate(transferDate);
			return this;
		}
		
		/**
		 * 设置 原因
		 * @param content 原因
		 * @return 当前对象
		*/
		public PersonTransfer setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 部门
		 * @param orgId 部门
		 * @return 当前对象
		*/
		public PersonTransfer setOrgId(String orgId) {
			super.change(ORG_ID,super.getOrgId(),orgId);
			super.setOrgId(orgId);
			return this;
		}
		
		/**
		 * 设置 岗位
		 * @param positionCode 岗位
		 * @return 当前对象
		*/
		public PersonTransfer setPositionCode(String positionCode) {
			super.change(POSITION_CODE,super.getPositionCode(),positionCode);
			super.setPositionCode(positionCode);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param fileIds 附件
		 * @return 当前对象
		*/
		public PersonTransfer setFileIds(String fileIds) {
			super.change(FILE_IDS,super.getFileIds(),fileIds);
			super.setFileIds(fileIds);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param note 备注
		 * @return 当前对象
		*/
		public PersonTransfer setNote(String note) {
			super.change(NOTE,super.getNote(),note);
			super.setNote(note);
			return this;
		}
		
		/**
		 * 设置 操作人
		 * @param operUserId 操作人
		 * @return 当前对象
		*/
		public PersonTransfer setOperUserId(String operUserId) {
			super.change(OPER_USER_ID,super.getOperUserId(),operUserId);
			super.setOperUserId(operUserId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PersonTransfer setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PersonTransfer setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PersonTransfer setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PersonTransfer setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PersonTransfer setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PersonTransfer setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PersonTransfer setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PersonTransfer setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PersonTransfer setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 position
		 * @param position position
		 * @return 当前对象
		*/
		public PersonTransfer setPosition(Position position) {
			super.change(POSITION,super.getPosition(),position);
			super.setPosition(position);
			return this;
		}
		
		/**
		 * 设置 所在部门
		 * @param organization 所在部门
		 * @return 当前对象
		*/
		public PersonTransfer setOrganization(Organization organization) {
			super.change(ORGANIZATION,super.getOrganization(),organization);
			super.setOrganization(organization);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PersonTransfer clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PersonTransfer duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNote(this.getNote());
			inst.setOperUserId(this.getOperUserId());
			inst.setPositionCode(this.getPositionCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setTransferDate(this.getTransferDate());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setOrgId(this.getOrgId());
			inst.setBusinessCode(this.getBusinessCode());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setFileIds(this.getFileIds());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setOrganization(this.getOrganization());
				inst.setPosition(this.getPosition());
			}
			inst.clearModifies();
			return inst;
		}

	}
}