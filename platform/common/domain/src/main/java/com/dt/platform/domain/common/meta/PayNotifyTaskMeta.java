package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.PayNotifyTask;
import java.util.Date;
import com.dt.platform.domain.common.PayMerchant;
import com.dt.platform.domain.common.PayApp;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 14:01:10
 * @sign 7AB9212ADEF032250F56472BB5C7A7F2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PayNotifyTaskMeta {
	
	/**
	 * 任务编号 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 任务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,ID, java.lang.String.class, "任务编号", "任务编号", java.lang.String.class, null);
	
	/**
	 * 通知状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 通知状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,STATUS, java.lang.String.class, "通知状态", "通知状态", java.lang.String.class, null);
	
	/**
	 * 商户编号 , 类型: java.lang.String
	*/
	public static final String MERCHANT_ID="merchantId";
	
	/**
	 * 商户编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.lang.String> MERCHANT_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,MERCHANT_ID, java.lang.String.class, "商户编号", "商户编号", java.lang.String.class, null);
	
	/**
	 * 应用编号 , 类型: java.lang.String
	*/
	public static final String APP_ID="appId";
	
	/**
	 * 应用编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.lang.String> APP_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,APP_ID, java.lang.String.class, "应用编号", "应用编号", java.lang.String.class, null);
	
	/**
	 * 通知类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 通知类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,TYPE, java.lang.String.class, "通知类型", "通知类型", java.lang.String.class, null);
	
	/**
	 * 数据编号 , 类型: java.lang.String
	*/
	public static final String DATA_ID="dataId";
	
	/**
	 * 数据编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.lang.String> DATA_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,DATA_ID, java.lang.String.class, "数据编号", "数据编号", java.lang.String.class, null);
	
	/**
	 * 商户订单编号 , 类型: java.lang.String
	*/
	public static final String MERCHANT_ORDER_ID="merchantOrderId";
	
	/**
	 * 商户订单编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.lang.String> MERCHANT_ORDER_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,MERCHANT_ORDER_ID, java.lang.String.class, "商户订单编号", "商户订单编号", java.lang.String.class, null);
	
	/**
	 * 下一次通知时间 , 类型: java.util.Date
	*/
	public static final String NEXT_NOTIFY_TIME="nextNotifyTime";
	
	/**
	 * 下一次通知时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.util.Date> NEXT_NOTIFY_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,NEXT_NOTIFY_TIME, java.util.Date.class, "下一次通知时间", "下一次通知时间", java.util.Date.class, null);
	
	/**
	 * 最后一次执行时间 , 类型: java.util.Date
	*/
	public static final String LAST_EXECUTE_TIME="lastExecuteTime";
	
	/**
	 * 最后一次执行时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.util.Date> LAST_EXECUTE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,LAST_EXECUTE_TIME, java.util.Date.class, "最后一次执行时间", "最后一次执行时间", java.util.Date.class, null);
	
	/**
	 * 当前通知次数 , 类型: java.lang.Integer
	*/
	public static final String NOTIFY_TIMES="notifyTimes";
	
	/**
	 * 当前通知次数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.lang.Integer> NOTIFY_TIMES_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,NOTIFY_TIMES, java.lang.Integer.class, "当前通知次数", "当前通知次数", java.lang.Integer.class, null);
	
	/**
	 * 最大可通知次数 , 类型: java.lang.Integer
	*/
	public static final String MAX_NOTIFY_TIMES="maxNotifyTimes";
	
	/**
	 * 最大可通知次数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.lang.Integer> MAX_NOTIFY_TIMES_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,MAX_NOTIFY_TIMES, java.lang.Integer.class, "最大可通知次数", "最大可通知次数", java.lang.Integer.class, null);
	
	/**
	 * 异步通知地址 , 类型: java.lang.String
	*/
	public static final String NOTIFY_URL="notifyUrl";
	
	/**
	 * 异步通知地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.lang.String> NOTIFY_URL_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,NOTIFY_URL, java.lang.String.class, "异步通知地址", "异步通知地址", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * payMerchant , 类型: com.dt.platform.domain.common.PayMerchant
	*/
	public static final String PAY_MERCHANT="payMerchant";
	
	/**
	 * payMerchant , 类型: com.dt.platform.domain.common.PayMerchant
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,com.dt.platform.domain.common.PayMerchant> PAY_MERCHANT_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,PAY_MERCHANT, com.dt.platform.domain.common.PayMerchant.class, "payMerchant", "payMerchant", com.dt.platform.domain.common.PayMerchant.class, null);
	
	/**
	 * payApp , 类型: com.dt.platform.domain.common.PayApp
	*/
	public static final String PAY_APP="payApp";
	
	/**
	 * payApp , 类型: com.dt.platform.domain.common.PayApp
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayNotifyTask,com.dt.platform.domain.common.PayApp> PAY_APP_PROP = new BeanProperty(com.dt.platform.domain.common.PayNotifyTask.class ,PAY_APP, com.dt.platform.domain.common.PayApp.class, "payApp", "payApp", com.dt.platform.domain.common.PayApp.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , STATUS , MERCHANT_ID , APP_ID , TYPE , DATA_ID , MERCHANT_ORDER_ID , NEXT_NOTIFY_TIME , LAST_EXECUTE_TIME , NOTIFY_TIMES , MAX_NOTIFY_TIMES , NOTIFY_URL , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PAY_MERCHANT , PAY_APP };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.PayNotifyTask {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 任务编号
		 * @param id 任务编号
		 * @return 当前对象
		*/
		public PayNotifyTask setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 通知状态
		 * @param status 通知状态
		 * @return 当前对象
		*/
		public PayNotifyTask setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 商户编号
		 * @param merchantId 商户编号
		 * @return 当前对象
		*/
		public PayNotifyTask setMerchantId(String merchantId) {
			super.change(MERCHANT_ID,super.getMerchantId(),merchantId);
			super.setMerchantId(merchantId);
			return this;
		}
		
		/**
		 * 设置 应用编号
		 * @param appId 应用编号
		 * @return 当前对象
		*/
		public PayNotifyTask setAppId(String appId) {
			super.change(APP_ID,super.getAppId(),appId);
			super.setAppId(appId);
			return this;
		}
		
		/**
		 * 设置 通知类型
		 * @param type 通知类型
		 * @return 当前对象
		*/
		public PayNotifyTask setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 数据编号
		 * @param dataId 数据编号
		 * @return 当前对象
		*/
		public PayNotifyTask setDataId(String dataId) {
			super.change(DATA_ID,super.getDataId(),dataId);
			super.setDataId(dataId);
			return this;
		}
		
		/**
		 * 设置 商户订单编号
		 * @param merchantOrderId 商户订单编号
		 * @return 当前对象
		*/
		public PayNotifyTask setMerchantOrderId(String merchantOrderId) {
			super.change(MERCHANT_ORDER_ID,super.getMerchantOrderId(),merchantOrderId);
			super.setMerchantOrderId(merchantOrderId);
			return this;
		}
		
		/**
		 * 设置 下一次通知时间
		 * @param nextNotifyTime 下一次通知时间
		 * @return 当前对象
		*/
		public PayNotifyTask setNextNotifyTime(Date nextNotifyTime) {
			super.change(NEXT_NOTIFY_TIME,super.getNextNotifyTime(),nextNotifyTime);
			super.setNextNotifyTime(nextNotifyTime);
			return this;
		}
		
		/**
		 * 设置 最后一次执行时间
		 * @param lastExecuteTime 最后一次执行时间
		 * @return 当前对象
		*/
		public PayNotifyTask setLastExecuteTime(Date lastExecuteTime) {
			super.change(LAST_EXECUTE_TIME,super.getLastExecuteTime(),lastExecuteTime);
			super.setLastExecuteTime(lastExecuteTime);
			return this;
		}
		
		/**
		 * 设置 当前通知次数
		 * @param notifyTimes 当前通知次数
		 * @return 当前对象
		*/
		public PayNotifyTask setNotifyTimes(Integer notifyTimes) {
			super.change(NOTIFY_TIMES,super.getNotifyTimes(),notifyTimes);
			super.setNotifyTimes(notifyTimes);
			return this;
		}
		
		/**
		 * 设置 最大可通知次数
		 * @param maxNotifyTimes 最大可通知次数
		 * @return 当前对象
		*/
		public PayNotifyTask setMaxNotifyTimes(Integer maxNotifyTimes) {
			super.change(MAX_NOTIFY_TIMES,super.getMaxNotifyTimes(),maxNotifyTimes);
			super.setMaxNotifyTimes(maxNotifyTimes);
			return this;
		}
		
		/**
		 * 设置 异步通知地址
		 * @param notifyUrl 异步通知地址
		 * @return 当前对象
		*/
		public PayNotifyTask setNotifyUrl(String notifyUrl) {
			super.change(NOTIFY_URL,super.getNotifyUrl(),notifyUrl);
			super.setNotifyUrl(notifyUrl);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PayNotifyTask setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PayNotifyTask setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PayNotifyTask setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PayNotifyTask setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PayNotifyTask setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PayNotifyTask setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PayNotifyTask setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PayNotifyTask setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PayNotifyTask setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 payMerchant
		 * @param payMerchant payMerchant
		 * @return 当前对象
		*/
		public PayNotifyTask setPayMerchant(PayMerchant payMerchant) {
			super.change(PAY_MERCHANT,super.getPayMerchant(),payMerchant);
			super.setPayMerchant(payMerchant);
			return this;
		}
		
		/**
		 * 设置 payApp
		 * @param payApp payApp
		 * @return 当前对象
		*/
		public PayNotifyTask setPayApp(PayApp payApp) {
			super.change(PAY_APP,super.getPayApp(),payApp);
			super.setPayApp(payApp);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PayNotifyTask clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PayNotifyTask duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setUpdateTime(this.getUpdateTime());
			inst.setMerchantOrderId(this.getMerchantOrderId());
			inst.setType(this.getType());
			inst.setVersion(this.getVersion());
			inst.setNextNotifyTime(this.getNextNotifyTime());
			inst.setLastExecuteTime(this.getLastExecuteTime());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setDataId(this.getDataId());
			inst.setMerchantId(this.getMerchantId());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setAppId(this.getAppId());
			inst.setTenantId(this.getTenantId());
			inst.setNotifyUrl(this.getNotifyUrl());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setNotifyTimes(this.getNotifyTimes());
			inst.setMaxNotifyTimes(this.getMaxNotifyTimes());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setPayApp(this.getPayApp());
				inst.setPayMerchant(this.getPayMerchant());
			}
			inst.clearModifies();
			return inst;
		}

	}
}