package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.SchedulePlan;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-26 06:47:16
 * @sign 63DDF9775CC1BC19895B6DB05C9A4AD3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SchedulePlanMeta {
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,ID, java.lang.String.class, "ID", "ID", java.lang.String.class, null);
	
	/**
	 * 优先级 , 类型: java.lang.String
	*/
	public static final String RANK="rank";
	
	/**
	 * 优先级 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.lang.String> RANK_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,RANK, java.lang.String.class, "优先级", "优先级", java.lang.String.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String F_TIME="fTime";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.util.Date> F_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,F_TIME, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final String T_TIME="tTime";
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.util.Date> T_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,T_TIME, java.util.Date.class, "结束时间", "结束时间", java.util.Date.class, null);
	
	/**
	 * 提醒 , 类型: java.lang.String
	*/
	public static final String REMIND="remind";
	
	/**
	 * 提醒 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.lang.String> REMIND_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,REMIND, java.lang.String.class, "提醒", "提醒", java.lang.String.class, null);
	
	/**
	 * 提醒时间 , 类型: java.util.Date
	*/
	public static final String REMIND_TIME="remindTime";
	
	/**
	 * 提醒时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.util.Date> REMIND_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,REMIND_TIME, java.util.Date.class, "提醒时间", "提醒时间", java.util.Date.class, null);
	
	/**
	 * 日程内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 日程内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,CONTENT, java.lang.String.class, "日程内容", "日程内容", java.lang.String.class, null);
	
	/**
	 * 详细描述 , 类型: java.lang.String
	*/
	public static final String DETAIL="detail";
	
	/**
	 * 详细描述 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.lang.String> DETAIL_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,DETAIL, java.lang.String.class, "详细描述", "详细描述", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,USER_ID, java.lang.String.class, "用户", "用户", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * scheduleRemind , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String SCHEDULE_REMIND="scheduleRemind";
	
	/**
	 * scheduleRemind , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.SchedulePlan,org.github.foxnic.web.domain.system.DictItem> SCHEDULE_REMIND_PROP = new BeanProperty(com.dt.platform.domain.oa.SchedulePlan.class ,SCHEDULE_REMIND, org.github.foxnic.web.domain.system.DictItem.class, "scheduleRemind", "scheduleRemind", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , RANK , F_TIME , T_TIME , REMIND , REMIND_TIME , CONTENT , DETAIL , NOTES , USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SCHEDULE_REMIND };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.SchedulePlan {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 ID
		 * @param id ID
		 * @return 当前对象
		*/
		public SchedulePlan setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 优先级
		 * @param rank 优先级
		 * @return 当前对象
		*/
		public SchedulePlan setRank(String rank) {
			super.change(RANK,super.getRank(),rank);
			super.setRank(rank);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param fTime 开始时间
		 * @return 当前对象
		*/
		public SchedulePlan setFTime(Date fTime) {
			super.change(F_TIME,super.getFTime(),fTime);
			super.setFTime(fTime);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param tTime 结束时间
		 * @return 当前对象
		*/
		public SchedulePlan setTTime(Date tTime) {
			super.change(T_TIME,super.getTTime(),tTime);
			super.setTTime(tTime);
			return this;
		}
		
		/**
		 * 设置 提醒
		 * @param remind 提醒
		 * @return 当前对象
		*/
		public SchedulePlan setRemind(String remind) {
			super.change(REMIND,super.getRemind(),remind);
			super.setRemind(remind);
			return this;
		}
		
		/**
		 * 设置 提醒时间
		 * @param remindTime 提醒时间
		 * @return 当前对象
		*/
		public SchedulePlan setRemindTime(Date remindTime) {
			super.change(REMIND_TIME,super.getRemindTime(),remindTime);
			super.setRemindTime(remindTime);
			return this;
		}
		
		/**
		 * 设置 日程内容
		 * @param content 日程内容
		 * @return 当前对象
		*/
		public SchedulePlan setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 详细描述
		 * @param detail 详细描述
		 * @return 当前对象
		*/
		public SchedulePlan setDetail(String detail) {
			super.change(DETAIL,super.getDetail(),detail);
			super.setDetail(detail);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public SchedulePlan setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 用户
		 * @param userId 用户
		 * @return 当前对象
		*/
		public SchedulePlan setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SchedulePlan setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SchedulePlan setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SchedulePlan setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SchedulePlan setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SchedulePlan setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SchedulePlan setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SchedulePlan setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public SchedulePlan setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public SchedulePlan setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 scheduleRemind
		 * @param scheduleRemind scheduleRemind
		 * @return 当前对象
		*/
		public SchedulePlan setScheduleRemind(DictItem scheduleRemind) {
			super.change(SCHEDULE_REMIND,super.getScheduleRemind(),scheduleRemind);
			super.setScheduleRemind(scheduleRemind);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public SchedulePlan clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public SchedulePlan duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setTTime(this.getTTime());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setRemind(this.getRemind());
			inst.setRemindTime(this.getRemindTime());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setFTime(this.getFTime());
			inst.setTenantId(this.getTenantId());
			inst.setRank(this.getRank());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setDetail(this.getDetail());
			if(all) {
				inst.setScheduleRemind(this.getScheduleRemind());
			}
			inst.clearModifies();
			return inst;
		}

	}
}