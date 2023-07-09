package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.PayOrderExt;
import java.util.Date;
import com.dt.platform.domain.common.PayOrder;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 16:25:47
 * @sign 8774735780A0F4203A664B387D316217
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PayOrderExtMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderExt,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderExt.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 支付订单编号 , 类型: java.lang.String
	*/
	public static final String ORDER_ID="orderId";
	
	/**
	 * 支付订单编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderExt,java.lang.String> ORDER_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderExt.class ,ORDER_ID, java.lang.String.class, "支付订单编号", "支付订单编号", java.lang.String.class, null);
	
	/**
	 * 支付渠道的额外参数 , 类型: java.lang.String
	*/
	public static final String CHANNEL_EXTRAS="channelExtras";
	
	/**
	 * 支付渠道的额外参数 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderExt,java.lang.String> CHANNEL_EXTRAS_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderExt.class ,CHANNEL_EXTRAS, java.lang.String.class, "支付渠道的额外参数", "支付渠道的额外参数", java.lang.String.class, null);
	
	/**
	 * 支付渠道异步通知的内容 , 类型: java.lang.String
	*/
	public static final String CHANNEL_NOTIFY_DATA="channelNotifyData";
	
	/**
	 * 支付渠道异步通知的内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderExt,java.lang.String> CHANNEL_NOTIFY_DATA_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderExt.class ,CHANNEL_NOTIFY_DATA, java.lang.String.class, "支付渠道异步通知的内容", "支付渠道异步通知的内容", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderExt,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderExt.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderExt,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderExt.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderExt,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderExt.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderExt,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderExt.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderExt,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderExt.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderExt,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderExt.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderExt,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderExt.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderExt,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderExt.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderExt,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderExt.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * payOrder , 类型: com.dt.platform.domain.common.PayOrder
	*/
	public static final String PAY_ORDER="payOrder";
	
	/**
	 * payOrder , 类型: com.dt.platform.domain.common.PayOrder
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderExt,com.dt.platform.domain.common.PayOrder> PAY_ORDER_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderExt.class ,PAY_ORDER, com.dt.platform.domain.common.PayOrder.class, "payOrder", "payOrder", com.dt.platform.domain.common.PayOrder.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ORDER_ID , CHANNEL_EXTRAS , CHANNEL_NOTIFY_DATA , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PAY_ORDER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.PayOrderExt {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PayOrderExt setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 支付订单编号
		 * @param orderId 支付订单编号
		 * @return 当前对象
		*/
		public PayOrderExt setOrderId(String orderId) {
			super.change(ORDER_ID,super.getOrderId(),orderId);
			super.setOrderId(orderId);
			return this;
		}
		
		/**
		 * 设置 支付渠道的额外参数
		 * @param channelExtras 支付渠道的额外参数
		 * @return 当前对象
		*/
		public PayOrderExt setChannelExtras(String channelExtras) {
			super.change(CHANNEL_EXTRAS,super.getChannelExtras(),channelExtras);
			super.setChannelExtras(channelExtras);
			return this;
		}
		
		/**
		 * 设置 支付渠道异步通知的内容
		 * @param channelNotifyData 支付渠道异步通知的内容
		 * @return 当前对象
		*/
		public PayOrderExt setChannelNotifyData(String channelNotifyData) {
			super.change(CHANNEL_NOTIFY_DATA,super.getChannelNotifyData(),channelNotifyData);
			super.setChannelNotifyData(channelNotifyData);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PayOrderExt setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PayOrderExt setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PayOrderExt setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PayOrderExt setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PayOrderExt setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PayOrderExt setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PayOrderExt setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PayOrderExt setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PayOrderExt setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 payOrder
		 * @param payOrder payOrder
		 * @return 当前对象
		*/
		public PayOrderExt setPayOrder(PayOrder payOrder) {
			super.change(PAY_ORDER,super.getPayOrder(),payOrder);
			super.setPayOrder(payOrder);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PayOrderExt clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PayOrderExt duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setOrderId(this.getOrderId());
			inst.setChannelNotifyData(this.getChannelNotifyData());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setChannelExtras(this.getChannelExtras());
			inst.setId(this.getId());
			if(all) {
				inst.setPayOrder(this.getPayOrder());
			}
			inst.clearModifies();
			return inst;
		}

	}
}