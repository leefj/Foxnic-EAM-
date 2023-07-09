package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.PayRefund;
import java.util.Date;
import com.dt.platform.domain.common.PayMerchant;
import com.dt.platform.domain.common.PayApp;
import com.dt.platform.domain.common.PayChannel;
import com.dt.platform.domain.common.PayOrder;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 16:15:46
 * @sign ED8955D8A6CA7B8757035F727832E94C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PayRefundMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 退款状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 退款状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,STATUS, java.lang.String.class, "退款状态", "退款状态", java.lang.String.class, null);
	
	/**
	 * 商户编号 , 类型: java.lang.String
	*/
	public static final String MERCHANT_ID="merchantId";
	
	/**
	 * 商户编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> MERCHANT_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,MERCHANT_ID, java.lang.String.class, "商户编号", "商户编号", java.lang.String.class, null);
	
	/**
	 * 应用编号 , 类型: java.lang.String
	*/
	public static final String APP_ID="appId";
	
	/**
	 * 应用编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> APP_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,APP_ID, java.lang.String.class, "应用编号", "应用编号", java.lang.String.class, null);
	
	/**
	 * 渠道编号 , 类型: java.lang.String
	*/
	public static final String CHANNEL_ID="channelId";
	
	/**
	 * 渠道编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> CHANNEL_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,CHANNEL_ID, java.lang.String.class, "渠道编号", "渠道编号", java.lang.String.class, null);
	
	/**
	 * 渠道编码 , 类型: java.lang.String
	*/
	public static final String CHANNEL_CODE="channelCode";
	
	/**
	 * 渠道编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> CHANNEL_CODE_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,CHANNEL_CODE, java.lang.String.class, "渠道编码", "渠道编码", java.lang.String.class, null);
	
	/**
	 * 支付订单 , pay_order 表id , 类型: java.lang.String
	*/
	public static final String ORDER_ID="orderId";
	
	/**
	 * 支付订单 , pay_order 表id , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> ORDER_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,ORDER_ID, java.lang.String.class, "支付订单", "pay_order 表id", java.lang.String.class, null);
	
	/**
	 * 交易订单 , pay_extension 表no 字段 , 类型: java.lang.String
	*/
	public static final String TRADE_NO="tradeNo";
	
	/**
	 * 交易订单 , pay_extension 表no 字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> TRADE_NO_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,TRADE_NO, java.lang.String.class, "交易订单", "pay_extension 表no 字段", java.lang.String.class, null);
	
	/**
	 * 商户订单编号 , 商户系统生成） , 类型: java.lang.String
	*/
	public static final String MERCHANT_ORDER_ID="merchantOrderId";
	
	/**
	 * 商户订单编号 , 商户系统生成） , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> MERCHANT_ORDER_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,MERCHANT_ORDER_ID, java.lang.String.class, "商户订单编号", "商户系统生成）", java.lang.String.class, null);
	
	/**
	 * 商户退款订单号 , 商户系统生成） , 类型: java.lang.String
	*/
	public static final String MERCHANT_REFUND_NO="merchantRefundNo";
	
	/**
	 * 商户退款订单号 , 商户系统生成） , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> MERCHANT_REFUND_NO_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,MERCHANT_REFUND_NO, java.lang.String.class, "商户退款订单号", "商户系统生成）", java.lang.String.class, null);
	
	/**
	 * 异步通知商户地址 , 类型: java.lang.String
	*/
	public static final String NOTIFY_URL="notifyUrl";
	
	/**
	 * 异步通知商户地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> NOTIFY_URL_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,NOTIFY_URL, java.lang.String.class, "异步通知商户地址", "异步通知商户地址", java.lang.String.class, null);
	
	/**
	 * 回调状态 , 通知商户退款结果的 , 类型: java.lang.String
	*/
	public static final String NOTIFY_STATUS="notifyStatus";
	
	/**
	 * 回调状态 , 通知商户退款结果的 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> NOTIFY_STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,NOTIFY_STATUS, java.lang.String.class, "回调状态", "通知商户退款结果的", java.lang.String.class, null);
	
	/**
	 * 退款类型 , 部分退款，全部退款) , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 退款类型 , 部分退款，全部退款) , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,TYPE, java.lang.String.class, "退款类型", "部分退款，全部退款)", java.lang.String.class, null);
	
	/**
	 * 支付金额 , 单位分 , 类型: java.lang.Long
	*/
	public static final String PAY_AMOUNT="payAmount";
	
	/**
	 * 支付金额 , 单位分 , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.Long> PAY_AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,PAY_AMOUNT, java.lang.Long.class, "支付金额", "单位分", java.lang.Long.class, null);
	
	/**
	 * 退款金额 , 单位分 , 类型: java.lang.Long
	*/
	public static final String REFUND_AMOUNT="refundAmount";
	
	/**
	 * 退款金额 , 单位分 , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.Long> REFUND_AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,REFUND_AMOUNT, java.lang.Long.class, "退款金额", "单位分", java.lang.Long.class, null);
	
	/**
	 * 退款原因 , 类型: java.lang.String
	*/
	public static final String REASON="reason";
	
	/**
	 * 退款原因 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> REASON_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,REASON, java.lang.String.class, "退款原因", "退款原因", java.lang.String.class, null);
	
	/**
	 * 用户 , IP , 类型: java.lang.String
	*/
	public static final String USER_IP="userIp";
	
	/**
	 * 用户 , IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> USER_IP_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,USER_IP, java.lang.String.class, "用户", "IP", java.lang.String.class, null);
	
	/**
	 * 渠道订单号 , pay_order 中的channel_order_no 对应 , 类型: java.lang.String
	*/
	public static final String CHANNEL_ORDER_NO="channelOrderNo";
	
	/**
	 * 渠道订单号 , pay_order 中的channel_order_no 对应 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> CHANNEL_ORDER_NO_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,CHANNEL_ORDER_NO, java.lang.String.class, "渠道订单号", "pay_order 中的channel_order_no 对应", java.lang.String.class, null);
	
	/**
	 * 渠道退款单号 , 渠道返回 , 类型: java.lang.String
	*/
	public static final String CHANNEL_REFUND_NO="channelRefundNo";
	
	/**
	 * 渠道退款单号 , 渠道返回 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> CHANNEL_REFUND_NO_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,CHANNEL_REFUND_NO, java.lang.String.class, "渠道退款单号", "渠道返回", java.lang.String.class, null);
	
	/**
	 * 渠道调用报错时 , 错误码 , 类型: java.lang.String
	*/
	public static final String CHANNEL_ERROR_CODE="channelErrorCode";
	
	/**
	 * 渠道调用报错时 , 错误码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> CHANNEL_ERROR_CODE_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,CHANNEL_ERROR_CODE, java.lang.String.class, "渠道调用报错时", "错误码", java.lang.String.class, null);
	
	/**
	 * 渠道调用报错时 , 错误信息 , 类型: java.lang.String
	*/
	public static final String CHANNEL_ERROR_MSG="channelErrorMsg";
	
	/**
	 * 渠道调用报错时 , 错误信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> CHANNEL_ERROR_MSG_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,CHANNEL_ERROR_MSG, java.lang.String.class, "渠道调用报错时", "错误信息", java.lang.String.class, null);
	
	/**
	 * 支付渠道的额外参数 , 类型: java.lang.String
	*/
	public static final String CHANNEL_EXTRAS="channelExtras";
	
	/**
	 * 支付渠道的额外参数 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> CHANNEL_EXTRAS_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,CHANNEL_EXTRAS, java.lang.String.class, "支付渠道的额外参数", "支付渠道的额外参数", java.lang.String.class, null);
	
	/**
	 * 退款失效时间 , 类型: java.util.Date
	*/
	public static final String EXPIRE_TIME="expireTime";
	
	/**
	 * 退款失效时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.util.Date> EXPIRE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,EXPIRE_TIME, java.util.Date.class, "退款失效时间", "退款失效时间", java.util.Date.class, null);
	
	/**
	 * 退款成功时间 , 类型: java.util.Date
	*/
	public static final String SUCCESS_TIME="successTime";
	
	/**
	 * 退款成功时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.util.Date> SUCCESS_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,SUCCESS_TIME, java.util.Date.class, "退款成功时间", "退款成功时间", java.util.Date.class, null);
	
	/**
	 * 退款通知时间 , 类型: java.util.Date
	*/
	public static final String NOTIFY_TIME="notifyTime";
	
	/**
	 * 退款通知时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.util.Date> NOTIFY_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,NOTIFY_TIME, java.util.Date.class, "退款通知时间", "退款通知时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * payMerchant , 类型: com.dt.platform.domain.common.PayMerchant
	*/
	public static final String PAY_MERCHANT="payMerchant";
	
	/**
	 * payMerchant , 类型: com.dt.platform.domain.common.PayMerchant
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,com.dt.platform.domain.common.PayMerchant> PAY_MERCHANT_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,PAY_MERCHANT, com.dt.platform.domain.common.PayMerchant.class, "payMerchant", "payMerchant", com.dt.platform.domain.common.PayMerchant.class, null);
	
	/**
	 * payApp , 类型: com.dt.platform.domain.common.PayApp
	*/
	public static final String PAY_APP="payApp";
	
	/**
	 * payApp , 类型: com.dt.platform.domain.common.PayApp
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,com.dt.platform.domain.common.PayApp> PAY_APP_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,PAY_APP, com.dt.platform.domain.common.PayApp.class, "payApp", "payApp", com.dt.platform.domain.common.PayApp.class, null);
	
	/**
	 * payChannel , 类型: com.dt.platform.domain.common.PayChannel
	*/
	public static final String PAY_CHANNEL="payChannel";
	
	/**
	 * payChannel , 类型: com.dt.platform.domain.common.PayChannel
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,com.dt.platform.domain.common.PayChannel> PAY_CHANNEL_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,PAY_CHANNEL, com.dt.platform.domain.common.PayChannel.class, "payChannel", "payChannel", com.dt.platform.domain.common.PayChannel.class, null);
	
	/**
	 * payOrder , 类型: com.dt.platform.domain.common.PayOrder
	*/
	public static final String PAY_ORDER="payOrder";
	
	/**
	 * payOrder , 类型: com.dt.platform.domain.common.PayOrder
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefund,com.dt.platform.domain.common.PayOrder> PAY_ORDER_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefund.class ,PAY_ORDER, com.dt.platform.domain.common.PayOrder.class, "payOrder", "payOrder", com.dt.platform.domain.common.PayOrder.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , STATUS , MERCHANT_ID , APP_ID , CHANNEL_ID , CHANNEL_CODE , ORDER_ID , TRADE_NO , MERCHANT_ORDER_ID , MERCHANT_REFUND_NO , NOTIFY_URL , NOTIFY_STATUS , TYPE , PAY_AMOUNT , REFUND_AMOUNT , REASON , USER_IP , CHANNEL_ORDER_NO , CHANNEL_REFUND_NO , CHANNEL_ERROR_CODE , CHANNEL_ERROR_MSG , CHANNEL_EXTRAS , EXPIRE_TIME , SUCCESS_TIME , NOTIFY_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PAY_MERCHANT , PAY_APP , PAY_CHANNEL , PAY_ORDER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.PayRefund {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PayRefund setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 退款状态
		 * @param status 退款状态
		 * @return 当前对象
		*/
		public PayRefund setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 商户编号
		 * @param merchantId 商户编号
		 * @return 当前对象
		*/
		public PayRefund setMerchantId(String merchantId) {
			super.change(MERCHANT_ID,super.getMerchantId(),merchantId);
			super.setMerchantId(merchantId);
			return this;
		}
		
		/**
		 * 设置 应用编号
		 * @param appId 应用编号
		 * @return 当前对象
		*/
		public PayRefund setAppId(String appId) {
			super.change(APP_ID,super.getAppId(),appId);
			super.setAppId(appId);
			return this;
		}
		
		/**
		 * 设置 渠道编号
		 * @param channelId 渠道编号
		 * @return 当前对象
		*/
		public PayRefund setChannelId(String channelId) {
			super.change(CHANNEL_ID,super.getChannelId(),channelId);
			super.setChannelId(channelId);
			return this;
		}
		
		/**
		 * 设置 渠道编码
		 * @param channelCode 渠道编码
		 * @return 当前对象
		*/
		public PayRefund setChannelCode(String channelCode) {
			super.change(CHANNEL_CODE,super.getChannelCode(),channelCode);
			super.setChannelCode(channelCode);
			return this;
		}
		
		/**
		 * 设置 支付订单
		 * @param orderId 支付订单
		 * @return 当前对象
		*/
		public PayRefund setOrderId(String orderId) {
			super.change(ORDER_ID,super.getOrderId(),orderId);
			super.setOrderId(orderId);
			return this;
		}
		
		/**
		 * 设置 交易订单
		 * @param tradeNo 交易订单
		 * @return 当前对象
		*/
		public PayRefund setTradeNo(String tradeNo) {
			super.change(TRADE_NO,super.getTradeNo(),tradeNo);
			super.setTradeNo(tradeNo);
			return this;
		}
		
		/**
		 * 设置 商户订单编号
		 * @param merchantOrderId 商户订单编号
		 * @return 当前对象
		*/
		public PayRefund setMerchantOrderId(String merchantOrderId) {
			super.change(MERCHANT_ORDER_ID,super.getMerchantOrderId(),merchantOrderId);
			super.setMerchantOrderId(merchantOrderId);
			return this;
		}
		
		/**
		 * 设置 商户退款订单号
		 * @param merchantRefundNo 商户退款订单号
		 * @return 当前对象
		*/
		public PayRefund setMerchantRefundNo(String merchantRefundNo) {
			super.change(MERCHANT_REFUND_NO,super.getMerchantRefundNo(),merchantRefundNo);
			super.setMerchantRefundNo(merchantRefundNo);
			return this;
		}
		
		/**
		 * 设置 异步通知商户地址
		 * @param notifyUrl 异步通知商户地址
		 * @return 当前对象
		*/
		public PayRefund setNotifyUrl(String notifyUrl) {
			super.change(NOTIFY_URL,super.getNotifyUrl(),notifyUrl);
			super.setNotifyUrl(notifyUrl);
			return this;
		}
		
		/**
		 * 设置 回调状态
		 * @param notifyStatus 回调状态
		 * @return 当前对象
		*/
		public PayRefund setNotifyStatus(String notifyStatus) {
			super.change(NOTIFY_STATUS,super.getNotifyStatus(),notifyStatus);
			super.setNotifyStatus(notifyStatus);
			return this;
		}
		
		/**
		 * 设置 退款类型
		 * @param type 退款类型
		 * @return 当前对象
		*/
		public PayRefund setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 支付金额
		 * @param payAmount 支付金额
		 * @return 当前对象
		*/
		public PayRefund setPayAmount(Long payAmount) {
			super.change(PAY_AMOUNT,super.getPayAmount(),payAmount);
			super.setPayAmount(payAmount);
			return this;
		}
		
		/**
		 * 设置 退款金额
		 * @param refundAmount 退款金额
		 * @return 当前对象
		*/
		public PayRefund setRefundAmount(Long refundAmount) {
			super.change(REFUND_AMOUNT,super.getRefundAmount(),refundAmount);
			super.setRefundAmount(refundAmount);
			return this;
		}
		
		/**
		 * 设置 退款原因
		 * @param reason 退款原因
		 * @return 当前对象
		*/
		public PayRefund setReason(String reason) {
			super.change(REASON,super.getReason(),reason);
			super.setReason(reason);
			return this;
		}
		
		/**
		 * 设置 用户
		 * @param userIp 用户
		 * @return 当前对象
		*/
		public PayRefund setUserIp(String userIp) {
			super.change(USER_IP,super.getUserIp(),userIp);
			super.setUserIp(userIp);
			return this;
		}
		
		/**
		 * 设置 渠道订单号
		 * @param channelOrderNo 渠道订单号
		 * @return 当前对象
		*/
		public PayRefund setChannelOrderNo(String channelOrderNo) {
			super.change(CHANNEL_ORDER_NO,super.getChannelOrderNo(),channelOrderNo);
			super.setChannelOrderNo(channelOrderNo);
			return this;
		}
		
		/**
		 * 设置 渠道退款单号
		 * @param channelRefundNo 渠道退款单号
		 * @return 当前对象
		*/
		public PayRefund setChannelRefundNo(String channelRefundNo) {
			super.change(CHANNEL_REFUND_NO,super.getChannelRefundNo(),channelRefundNo);
			super.setChannelRefundNo(channelRefundNo);
			return this;
		}
		
		/**
		 * 设置 渠道调用报错时
		 * @param channelErrorCode 渠道调用报错时
		 * @return 当前对象
		*/
		public PayRefund setChannelErrorCode(String channelErrorCode) {
			super.change(CHANNEL_ERROR_CODE,super.getChannelErrorCode(),channelErrorCode);
			super.setChannelErrorCode(channelErrorCode);
			return this;
		}
		
		/**
		 * 设置 渠道调用报错时
		 * @param channelErrorMsg 渠道调用报错时
		 * @return 当前对象
		*/
		public PayRefund setChannelErrorMsg(String channelErrorMsg) {
			super.change(CHANNEL_ERROR_MSG,super.getChannelErrorMsg(),channelErrorMsg);
			super.setChannelErrorMsg(channelErrorMsg);
			return this;
		}
		
		/**
		 * 设置 支付渠道的额外参数
		 * @param channelExtras 支付渠道的额外参数
		 * @return 当前对象
		*/
		public PayRefund setChannelExtras(String channelExtras) {
			super.change(CHANNEL_EXTRAS,super.getChannelExtras(),channelExtras);
			super.setChannelExtras(channelExtras);
			return this;
		}
		
		/**
		 * 设置 退款失效时间
		 * @param expireTime 退款失效时间
		 * @return 当前对象
		*/
		public PayRefund setExpireTime(Date expireTime) {
			super.change(EXPIRE_TIME,super.getExpireTime(),expireTime);
			super.setExpireTime(expireTime);
			return this;
		}
		
		/**
		 * 设置 退款成功时间
		 * @param successTime 退款成功时间
		 * @return 当前对象
		*/
		public PayRefund setSuccessTime(Date successTime) {
			super.change(SUCCESS_TIME,super.getSuccessTime(),successTime);
			super.setSuccessTime(successTime);
			return this;
		}
		
		/**
		 * 设置 退款通知时间
		 * @param notifyTime 退款通知时间
		 * @return 当前对象
		*/
		public PayRefund setNotifyTime(Date notifyTime) {
			super.change(NOTIFY_TIME,super.getNotifyTime(),notifyTime);
			super.setNotifyTime(notifyTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PayRefund setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PayRefund setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PayRefund setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PayRefund setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PayRefund setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PayRefund setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PayRefund setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PayRefund setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PayRefund setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 payMerchant
		 * @param payMerchant payMerchant
		 * @return 当前对象
		*/
		public PayRefund setPayMerchant(PayMerchant payMerchant) {
			super.change(PAY_MERCHANT,super.getPayMerchant(),payMerchant);
			super.setPayMerchant(payMerchant);
			return this;
		}
		
		/**
		 * 设置 payApp
		 * @param payApp payApp
		 * @return 当前对象
		*/
		public PayRefund setPayApp(PayApp payApp) {
			super.change(PAY_APP,super.getPayApp(),payApp);
			super.setPayApp(payApp);
			return this;
		}
		
		/**
		 * 设置 payChannel
		 * @param payChannel payChannel
		 * @return 当前对象
		*/
		public PayRefund setPayChannel(PayChannel payChannel) {
			super.change(PAY_CHANNEL,super.getPayChannel(),payChannel);
			super.setPayChannel(payChannel);
			return this;
		}
		
		/**
		 * 设置 payOrder
		 * @param payOrder payOrder
		 * @return 当前对象
		*/
		public PayRefund setPayOrder(PayOrder payOrder) {
			super.change(PAY_ORDER,super.getPayOrder(),payOrder);
			super.setPayOrder(payOrder);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PayRefund clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PayRefund duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setReason(this.getReason());
			inst.setOrderId(this.getOrderId());
			inst.setNotifyStatus(this.getNotifyStatus());
			inst.setChannelRefundNo(this.getChannelRefundNo());
			inst.setChannelOrderNo(this.getChannelOrderNo());
			inst.setMerchantOrderId(this.getMerchantOrderId());
			inst.setType(this.getType());
			inst.setPayAmount(this.getPayAmount());
			inst.setMerchantId(this.getMerchantId());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setAppId(this.getAppId());
			inst.setSuccessTime(this.getSuccessTime());
			inst.setId(this.getId());
			inst.setChannelId(this.getChannelId());
			inst.setChannelCode(this.getChannelCode());
			inst.setRefundAmount(this.getRefundAmount());
			inst.setChannelErrorMsg(this.getChannelErrorMsg());
			inst.setTradeNo(this.getTradeNo());
			inst.setMerchantRefundNo(this.getMerchantRefundNo());
			inst.setNotifyTime(this.getNotifyTime());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setChannelErrorCode(this.getChannelErrorCode());
			inst.setCreateBy(this.getCreateBy());
			inst.setExpireTime(this.getExpireTime());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setNotifyUrl(this.getNotifyUrl());
			inst.setUserIp(this.getUserIp());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setChannelExtras(this.getChannelExtras());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setPayApp(this.getPayApp());
				inst.setPayMerchant(this.getPayMerchant());
				inst.setPayChannel(this.getPayChannel());
				inst.setPayOrder(this.getPayOrder());
			}
			inst.clearModifies();
			return inst;
		}

	}
}