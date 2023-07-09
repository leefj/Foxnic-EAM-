package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.PayNotifyLog;
import java.util.Date;
import com.dt.platform.domain.common.PayNotifyTask;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 16:30:01
 * @sign FBE0B7689F246562B5ED5503546E8D1E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PayNotifyLogMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyLog,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyLog.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 通知状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 通知状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyLog,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyLog.class ,STATUS, java.lang.String.class, "通知状态", "通知状态", java.lang.String.class, null);
	
	/**
	 * 通知任务编号 , 类型: java.lang.String
	*/
	public static final String TASK_ID="taskId";
	
	/**
	 * 通知任务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyLog,java.lang.String> TASK_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyLog.class ,TASK_ID, java.lang.String.class, "通知任务编号", "通知任务编号", java.lang.String.class, null);
	
	/**
	 * 第几次被通知 , 类型: java.lang.Integer
	*/
	public static final String NOTIFY_TIMES="notifyTimes";
	
	/**
	 * 第几次被通知 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyLog,java.lang.Integer> NOTIFY_TIMES_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyLog.class ,NOTIFY_TIMES, java.lang.Integer.class, "第几次被通知", "第几次被通知", java.lang.Integer.class, null);
	
	/**
	 * 请求参数 , 类型: java.lang.String
	*/
	public static final String RESPONSE="response";
	
	/**
	 * 请求参数 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyLog,java.lang.String> RESPONSE_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyLog.class ,RESPONSE, java.lang.String.class, "请求参数", "请求参数", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyLog,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyLog.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyLog,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyLog.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyLog,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyLog.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyLog,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyLog.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyLog,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyLog.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyLog,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyLog.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyLog,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyLog.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyLog,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyLog.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyLog,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyLog.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * payNotifyTask , 类型: com.dt.platform.domain.common.PayNotifyTask
	*/
	public static final String PAY_NOTIFY_TASK="payNotifyTask";
	
	/**
	 * payNotifyTask , 类型: com.dt.platform.domain.common.PayNotifyTask
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyLog,com.dt.platform.domain.common.PayNotifyTask> PAY_NOTIFY_TASK_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyLog.class ,PAY_NOTIFY_TASK, com.dt.platform.domain.common.PayNotifyTask.class, "payNotifyTask", "payNotifyTask", com.dt.platform.domain.common.PayNotifyTask.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , STATUS , TASK_ID , NOTIFY_TIMES , RESPONSE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PAY_NOTIFY_TASK };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.PayNotifyLog {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PayNotifyLog setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 通知状态
		 * @param status 通知状态
		 * @return 当前对象
		*/
		public PayNotifyLog setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 通知任务编号
		 * @param taskId 通知任务编号
		 * @return 当前对象
		*/
		public PayNotifyLog setTaskId(String taskId) {
			super.change(TASK_ID,super.getTaskId(),taskId);
			super.setTaskId(taskId);
			return this;
		}
		
		/**
		 * 设置 第几次被通知
		 * @param notifyTimes 第几次被通知
		 * @return 当前对象
		*/
		public PayNotifyLog setNotifyTimes(Integer notifyTimes) {
			super.change(NOTIFY_TIMES,super.getNotifyTimes(),notifyTimes);
			super.setNotifyTimes(notifyTimes);
			return this;
		}
		
		/**
		 * 设置 请求参数
		 * @param response 请求参数
		 * @return 当前对象
		*/
		public PayNotifyLog setResponse(String response) {
			super.change(RESPONSE,super.getResponse(),response);
			super.setResponse(response);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PayNotifyLog setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PayNotifyLog setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PayNotifyLog setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PayNotifyLog setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PayNotifyLog setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PayNotifyLog setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PayNotifyLog setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PayNotifyLog setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PayNotifyLog setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 payNotifyTask
		 * @param payNotifyTask payNotifyTask
		 * @return 当前对象
		*/
		public PayNotifyLog setPayNotifyTask(PayNotifyTask payNotifyTask) {
			super.change(PAY_NOTIFY_TASK,super.getPayNotifyTask(),payNotifyTask);
			super.setPayNotifyTask(payNotifyTask);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PayNotifyLog clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PayNotifyLog duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setResponse(this.getResponse());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setNotifyTimes(this.getNotifyTimes());
			inst.setTaskId(this.getTaskId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setPayNotifyTask(this.getPayNotifyTask());
			}
			inst.clearModifies();
			return inst;
		}

	}
}