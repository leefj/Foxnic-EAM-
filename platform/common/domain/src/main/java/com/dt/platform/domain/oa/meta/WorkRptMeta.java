package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.WorkRpt;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-26 10:12:26
 * @sign 268E3B42C561C5925C07964EC81743B5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class WorkRptMeta {
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String F_TIME="fTime";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,java.util.Date> F_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,F_TIME, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final String T_TIME="tTime";
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,java.util.Date> T_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,T_TIME, java.util.Date.class, "结束时间", "结束时间", java.util.Date.class, null);
	
	/**
	 * 本周 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 本周 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,CONTENT, java.lang.String.class, "本周", "本周", java.lang.String.class, null);
	
	/**
	 * 下周 , 类型: java.lang.String
	*/
	public static final String NEXT_CONTENT="nextContent";
	
	/**
	 * 下周 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,java.lang.String> NEXT_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,NEXT_CONTENT, java.lang.String.class, "下周", "下周", java.lang.String.class, null);
	
	/**
	 * 其他事项 , 类型: java.lang.String
	*/
	public static final String OTHER="other";
	
	/**
	 * 其他事项 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,java.lang.String> OTHER_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,OTHER, java.lang.String.class, "其他事项", "其他事项", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String FILE_ID="fileId";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,java.lang.String> FILE_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,FILE_ID, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 报告人 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 报告人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,USER_ID, java.lang.String.class, "报告人", "报告人", java.lang.String.class, null);
	
	/**
	 * 接收人 , 类型: java.lang.String
	*/
	public static final String RECEIVER_ID="receiverId";
	
	/**
	 * 接收人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,java.lang.String> RECEIVER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,RECEIVER_ID, java.lang.String.class, "接收人", "接收人", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * reportUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String REPORT_USER="reportUser";
	
	/**
	 * reportUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,org.github.foxnic.web.domain.hrm.Employee> REPORT_USER_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,REPORT_USER, org.github.foxnic.web.domain.hrm.Employee.class, "reportUser", "reportUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * receiver , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String RECEIVER="receiver";
	
	/**
	 * receiver , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.WorkRpt,org.github.foxnic.web.domain.hrm.Employee> RECEIVER_PROP = new BeanProperty(com.dt.platform.domain.oa.WorkRpt.class ,RECEIVER, org.github.foxnic.web.domain.hrm.Employee.class, "receiver", "receiver", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , F_TIME , T_TIME , CONTENT , NEXT_CONTENT , OTHER , FILE_ID , USER_ID , RECEIVER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , REPORT_USER , RECEIVER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.WorkRpt {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public WorkRpt setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param fTime 开始时间
		 * @return 当前对象
		*/
		public WorkRpt setFTime(Date fTime) {
			super.change(F_TIME,super.getFTime(),fTime);
			super.setFTime(fTime);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param tTime 结束时间
		 * @return 当前对象
		*/
		public WorkRpt setTTime(Date tTime) {
			super.change(T_TIME,super.getTTime(),tTime);
			super.setTTime(tTime);
			return this;
		}
		
		/**
		 * 设置 本周
		 * @param content 本周
		 * @return 当前对象
		*/
		public WorkRpt setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 下周
		 * @param nextContent 下周
		 * @return 当前对象
		*/
		public WorkRpt setNextContent(String nextContent) {
			super.change(NEXT_CONTENT,super.getNextContent(),nextContent);
			super.setNextContent(nextContent);
			return this;
		}
		
		/**
		 * 设置 其他事项
		 * @param other 其他事项
		 * @return 当前对象
		*/
		public WorkRpt setOther(String other) {
			super.change(OTHER,super.getOther(),other);
			super.setOther(other);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param fileId 附件
		 * @return 当前对象
		*/
		public WorkRpt setFileId(String fileId) {
			super.change(FILE_ID,super.getFileId(),fileId);
			super.setFileId(fileId);
			return this;
		}
		
		/**
		 * 设置 报告人
		 * @param userId 报告人
		 * @return 当前对象
		*/
		public WorkRpt setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 接收人
		 * @param receiverId 接收人
		 * @return 当前对象
		*/
		public WorkRpt setReceiverId(String receiverId) {
			super.change(RECEIVER_ID,super.getReceiverId(),receiverId);
			super.setReceiverId(receiverId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public WorkRpt setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public WorkRpt setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public WorkRpt setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public WorkRpt setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public WorkRpt setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public WorkRpt setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public WorkRpt setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public WorkRpt setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public WorkRpt setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 reportUser
		 * @param reportUser reportUser
		 * @return 当前对象
		*/
		public WorkRpt setReportUser(Employee reportUser) {
			super.change(REPORT_USER,super.getReportUser(),reportUser);
			super.setReportUser(reportUser);
			return this;
		}
		
		/**
		 * 设置 receiver
		 * @param receiver receiver
		 * @return 当前对象
		*/
		public WorkRpt setReceiver(Employee receiver) {
			super.change(RECEIVER,super.getReceiver(),receiver);
			super.setReceiver(receiver);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public WorkRpt clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public WorkRpt duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setOther(this.getOther());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setTTime(this.getTTime());
			inst.setNextContent(this.getNextContent());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setCreateBy(this.getCreateBy());
			inst.setReceiverId(this.getReceiverId());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setFTime(this.getFTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setFileId(this.getFileId());
			if(all) {
				inst.setReportUser(this.getReportUser());
				inst.setReceiver(this.getReceiver());
			}
			inst.clearModifies();
			return inst;
		}

	}
}