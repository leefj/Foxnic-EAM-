package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.CCustRepairApply;
import java.util.Date;
import com.dt.platform.domain.eam.CCustRepiarItem;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-01 16:32:43
 * @sign 89AD2CA1B55F1BDC6E5A6FDA70757A32
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CCustRepairApplyMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 报修标题 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 报修标题 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,NAME, java.lang.String.class, "报修标题", "报修标题", java.lang.String.class, null);
	
	/**
	 * 预期日期 , 类型: java.util.Date
	*/
	public static final String PLAN_FINISH_DATE="planFinishDate";
	
	/**
	 * 预期日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.util.Date> PLAN_FINISH_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,PLAN_FINISH_DATE, java.util.Date.class, "预期日期", "预期日期", java.util.Date.class, null);
	
	/**
	 * 报修内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 报修内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,CONTENT, java.lang.String.class, "报修内容", "报修内容", java.lang.String.class, null);
	
	/**
	 * 发起人 , 类型: java.lang.String
	*/
	public static final String REPORT_USER_NAME="reportUserName";
	
	/**
	 * 发起人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.lang.String> REPORT_USER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,REPORT_USER_NAME, java.lang.String.class, "发起人", "发起人", java.lang.String.class, null);
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final String CONTACT="contact";
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.lang.String> CONTACT_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,CONTACT, java.lang.String.class, "联系方式", "联系方式", java.lang.String.class, null);
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,PICTURE_ID, java.lang.String.class, "图片", "图片", java.lang.String.class, null);
	
	/**
	 * 处理人 , 类型: java.lang.String
	*/
	public static final String PROCESS_USER_ID="processUserId";
	
	/**
	 * 处理人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.lang.String> PROCESS_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,PROCESS_USER_ID, java.lang.String.class, "处理人", "处理人", java.lang.String.class, null);
	
	/**
	 * 发起时间 , 类型: java.util.Date
	*/
	public static final String START_DATE="startDate";
	
	/**
	 * 发起时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.util.Date> START_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,START_DATE, java.util.Date.class, "发起时间", "发起时间", java.util.Date.class, null);
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final String FINISH_DATE="finishDate";
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.util.Date> FINISH_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,FINISH_DATE, java.util.Date.class, "结束时间", "结束时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * repiarItemData , 集合类型: LIST , 类型: com.dt.platform.domain.eam.CCustRepiarItem
	*/
	public static final String REPIAR_ITEM_DATA="repiarItemData";
	
	/**
	 * repiarItemData , 集合类型: LIST , 类型: com.dt.platform.domain.eam.CCustRepiarItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,com.dt.platform.domain.eam.CCustRepiarItem> REPIAR_ITEM_DATA_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,REPIAR_ITEM_DATA, java.util.List.class, "repiarItemData", "repiarItemData", com.dt.platform.domain.eam.CCustRepiarItem.class, null);
	
	/**
	 * 处理人 , 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String PROCESS_USER="processUser";
	
	/**
	 * 处理人 , 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepairApply,org.github.foxnic.web.domain.hrm.Employee> PROCESS_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepairApply.class ,PROCESS_USER, org.github.foxnic.web.domain.hrm.Employee.class, "处理人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BUSINESS_CODE , STATUS , NAME , PLAN_FINISH_DATE , CONTENT , REPORT_USER_NAME , CONTACT , PICTURE_ID , PROCESS_USER_ID , START_DATE , FINISH_DATE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , REPIAR_ITEM_DATA , PROCESS_USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.CCustRepairApply {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CCustRepairApply setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public CCustRepairApply setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public CCustRepairApply setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 报修标题
		 * @param name 报修标题
		 * @return 当前对象
		*/
		public CCustRepairApply setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 预期日期
		 * @param planFinishDate 预期日期
		 * @return 当前对象
		*/
		public CCustRepairApply setPlanFinishDate(Date planFinishDate) {
			super.change(PLAN_FINISH_DATE,super.getPlanFinishDate(),planFinishDate);
			super.setPlanFinishDate(planFinishDate);
			return this;
		}
		
		/**
		 * 设置 报修内容
		 * @param content 报修内容
		 * @return 当前对象
		*/
		public CCustRepairApply setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 发起人
		 * @param reportUserName 发起人
		 * @return 当前对象
		*/
		public CCustRepairApply setReportUserName(String reportUserName) {
			super.change(REPORT_USER_NAME,super.getReportUserName(),reportUserName);
			super.setReportUserName(reportUserName);
			return this;
		}
		
		/**
		 * 设置 联系方式
		 * @param contact 联系方式
		 * @return 当前对象
		*/
		public CCustRepairApply setContact(String contact) {
			super.change(CONTACT,super.getContact(),contact);
			super.setContact(contact);
			return this;
		}
		
		/**
		 * 设置 图片
		 * @param pictureId 图片
		 * @return 当前对象
		*/
		public CCustRepairApply setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 处理人
		 * @param processUserId 处理人
		 * @return 当前对象
		*/
		public CCustRepairApply setProcessUserId(String processUserId) {
			super.change(PROCESS_USER_ID,super.getProcessUserId(),processUserId);
			super.setProcessUserId(processUserId);
			return this;
		}
		
		/**
		 * 设置 发起时间
		 * @param startDate 发起时间
		 * @return 当前对象
		*/
		public CCustRepairApply setStartDate(Date startDate) {
			super.change(START_DATE,super.getStartDate(),startDate);
			super.setStartDate(startDate);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param finishDate 结束时间
		 * @return 当前对象
		*/
		public CCustRepairApply setFinishDate(Date finishDate) {
			super.change(FINISH_DATE,super.getFinishDate(),finishDate);
			super.setFinishDate(finishDate);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CCustRepairApply setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CCustRepairApply setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CCustRepairApply setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CCustRepairApply setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CCustRepairApply setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CCustRepairApply setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CCustRepairApply setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public CCustRepairApply setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 repiarItemData
		 * @param repiarItemData repiarItemData
		 * @return 当前对象
		*/
		public CCustRepairApply setRepiarItemData(List<CCustRepiarItem> repiarItemData) {
			super.change(REPIAR_ITEM_DATA,super.getRepiarItemData(),repiarItemData);
			super.setRepiarItemData(repiarItemData);
			return this;
		}
		
		/**
		 * 设置 处理人
		 * @param processUser 处理人
		 * @return 当前对象
		*/
		public CCustRepairApply setProcessUser(Employee processUser) {
			super.change(PROCESS_USER,super.getProcessUser(),processUser);
			super.setProcessUser(processUser);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CCustRepairApply clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CCustRepairApply duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setReportUserName(this.getReportUserName());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setBusinessCode(this.getBusinessCode());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setPictureId(this.getPictureId());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setContact(this.getContact());
			inst.setProcessUserId(this.getProcessUserId());
			inst.setName(this.getName());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setPlanFinishDate(this.getPlanFinishDate());
			inst.setFinishDate(this.getFinishDate());
			inst.setId(this.getId());
			inst.setStartDate(this.getStartDate());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setRepiarItemData(this.getRepiarItemData());
				inst.setProcessUser(this.getProcessUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}