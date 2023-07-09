package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.PayRefundVO;
import java.util.List;
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
 * @sign CB79F1A6933DB4CE3FACD0B0B0F57E02
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PayRefundVOMeta extends PayRefundMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 退款状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 退款状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,STATUS, java.lang.String.class, "退款状态", "退款状态", java.lang.String.class, null);
	
	/**
	 * 商户编号 , 类型: java.lang.String
	*/
	public static final String MERCHANT_ID="merchantId";
	
	/**
	 * 商户编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> MERCHANT_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,MERCHANT_ID, java.lang.String.class, "商户编号", "商户编号", java.lang.String.class, null);
	
	/**
	 * 应用编号 , 类型: java.lang.String
	*/
	public static final String APP_ID="appId";
	
	/**
	 * 应用编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> APP_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,APP_ID, java.lang.String.class, "应用编号", "应用编号", java.lang.String.class, null);
	
	/**
	 * 渠道编号 , 类型: java.lang.String
	*/
	public static final String CHANNEL_ID="channelId";
	
	/**
	 * 渠道编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> CHANNEL_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,CHANNEL_ID, java.lang.String.class, "渠道编号", "渠道编号", java.lang.String.class, null);
	
	/**
	 * 渠道编码 , 类型: java.lang.String
	*/
	public static final String CHANNEL_CODE="channelCode";
	
	/**
	 * 渠道编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> CHANNEL_CODE_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,CHANNEL_CODE, java.lang.String.class, "渠道编码", "渠道编码", java.lang.String.class, null);
	
	/**
	 * 支付订单 , pay_order 表id , 类型: java.lang.String
	*/
	public static final String ORDER_ID="orderId";
	
	/**
	 * 支付订单 , pay_order 表id , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> ORDER_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,ORDER_ID, java.lang.String.class, "支付订单", "pay_order 表id", java.lang.String.class, null);
	
	/**
	 * 交易订单 , pay_extension 表no 字段 , 类型: java.lang.String
	*/
	public static final String TRADE_NO="tradeNo";
	
	/**
	 * 交易订单 , pay_extension 表no 字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> TRADE_NO_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,TRADE_NO, java.lang.String.class, "交易订单", "pay_extension 表no 字段", java.lang.String.class, null);
	
	/**
	 * 商户订单编号 , 商户系统生成） , 类型: java.lang.String
	*/
	public static final String MERCHANT_ORDER_ID="merchantOrderId";
	
	/**
	 * 商户订单编号 , 商户系统生成） , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> MERCHANT_ORDER_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,MERCHANT_ORDER_ID, java.lang.String.class, "商户订单编号", "商户系统生成）", java.lang.String.class, null);
	
	/**
	 * 商户退款订单号 , 商户系统生成） , 类型: java.lang.String
	*/
	public static final String MERCHANT_REFUND_NO="merchantRefundNo";
	
	/**
	 * 商户退款订单号 , 商户系统生成） , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> MERCHANT_REFUND_NO_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,MERCHANT_REFUND_NO, java.lang.String.class, "商户退款订单号", "商户系统生成）", java.lang.String.class, null);
	
	/**
	 * 异步通知商户地址 , 类型: java.lang.String
	*/
	public static final String NOTIFY_URL="notifyUrl";
	
	/**
	 * 异步通知商户地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> NOTIFY_URL_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,NOTIFY_URL, java.lang.String.class, "异步通知商户地址", "异步通知商户地址", java.lang.String.class, null);
	
	/**
	 * 回调状态 , 通知商户退款结果的 , 类型: java.lang.String
	*/
	public static final String NOTIFY_STATUS="notifyStatus";
	
	/**
	 * 回调状态 , 通知商户退款结果的 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> NOTIFY_STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,NOTIFY_STATUS, java.lang.String.class, "回调状态", "通知商户退款结果的", java.lang.String.class, null);
	
	/**
	 * 退款类型 , 部分退款，全部退款) , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 退款类型 , 部分退款，全部退款) , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,TYPE, java.lang.String.class, "退款类型", "部分退款，全部退款)", java.lang.String.class, null);
	
	/**
	 * 支付金额 , 单位分 , 类型: java.lang.Long
	*/
	public static final String PAY_AMOUNT="payAmount";
	
	/**
	 * 支付金额 , 单位分 , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.Long> PAY_AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,PAY_AMOUNT, java.lang.Long.class, "支付金额", "单位分", java.lang.Long.class, null);
	
	/**
	 * 退款金额 , 单位分 , 类型: java.lang.Long
	*/
	public static final String REFUND_AMOUNT="refundAmount";
	
	/**
	 * 退款金额 , 单位分 , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.Long> REFUND_AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,REFUND_AMOUNT, java.lang.Long.class, "退款金额", "单位分", java.lang.Long.class, null);
	
	/**
	 * 退款原因 , 类型: java.lang.String
	*/
	public static final String REASON="reason";
	
	/**
	 * 退款原因 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> REASON_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,REASON, java.lang.String.class, "退款原因", "退款原因", java.lang.String.class, null);
	
	/**
	 * 用户 , IP , 类型: java.lang.String
	*/
	public static final String USER_IP="userIp";
	
	/**
	 * 用户 , IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> USER_IP_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,USER_IP, java.lang.String.class, "用户", "IP", java.lang.String.class, null);
	
	/**
	 * 渠道订单号 , pay_order 中的channel_order_no 对应 , 类型: java.lang.String
	*/
	public static final String CHANNEL_ORDER_NO="channelOrderNo";
	
	/**
	 * 渠道订单号 , pay_order 中的channel_order_no 对应 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> CHANNEL_ORDER_NO_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,CHANNEL_ORDER_NO, java.lang.String.class, "渠道订单号", "pay_order 中的channel_order_no 对应", java.lang.String.class, null);
	
	/**
	 * 渠道退款单号 , 渠道返回 , 类型: java.lang.String
	*/
	public static final String CHANNEL_REFUND_NO="channelRefundNo";
	
	/**
	 * 渠道退款单号 , 渠道返回 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> CHANNEL_REFUND_NO_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,CHANNEL_REFUND_NO, java.lang.String.class, "渠道退款单号", "渠道返回", java.lang.String.class, null);
	
	/**
	 * 渠道调用报错时 , 错误码 , 类型: java.lang.String
	*/
	public static final String CHANNEL_ERROR_CODE="channelErrorCode";
	
	/**
	 * 渠道调用报错时 , 错误码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> CHANNEL_ERROR_CODE_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,CHANNEL_ERROR_CODE, java.lang.String.class, "渠道调用报错时", "错误码", java.lang.String.class, null);
	
	/**
	 * 渠道调用报错时 , 错误信息 , 类型: java.lang.String
	*/
	public static final String CHANNEL_ERROR_MSG="channelErrorMsg";
	
	/**
	 * 渠道调用报错时 , 错误信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> CHANNEL_ERROR_MSG_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,CHANNEL_ERROR_MSG, java.lang.String.class, "渠道调用报错时", "错误信息", java.lang.String.class, null);
	
	/**
	 * 支付渠道的额外参数 , 类型: java.lang.String
	*/
	public static final String CHANNEL_EXTRAS="channelExtras";
	
	/**
	 * 支付渠道的额外参数 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> CHANNEL_EXTRAS_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,CHANNEL_EXTRAS, java.lang.String.class, "支付渠道的额外参数", "支付渠道的额外参数", java.lang.String.class, null);
	
	/**
	 * 退款失效时间 , 类型: java.util.Date
	*/
	public static final String EXPIRE_TIME="expireTime";
	
	/**
	 * 退款失效时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.util.Date> EXPIRE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,EXPIRE_TIME, java.util.Date.class, "退款失效时间", "退款失效时间", java.util.Date.class, null);
	
	/**
	 * 退款成功时间 , 类型: java.util.Date
	*/
	public static final String SUCCESS_TIME="successTime";
	
	/**
	 * 退款成功时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.util.Date> SUCCESS_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,SUCCESS_TIME, java.util.Date.class, "退款成功时间", "退款成功时间", java.util.Date.class, null);
	
	/**
	 * 退款通知时间 , 类型: java.util.Date
	*/
	public static final String NOTIFY_TIME="notifyTime";
	
	/**
	 * 退款通知时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.util.Date> NOTIFY_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,NOTIFY_TIME, java.util.Date.class, "退款通知时间", "退款通知时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * payMerchant , 类型: com.dt.platform.domain.common.PayMerchant
	*/
	public static final String PAY_MERCHANT="payMerchant";
	
	/**
	 * payMerchant , 类型: com.dt.platform.domain.common.PayMerchant
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,com.dt.platform.domain.common.PayMerchant> PAY_MERCHANT_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,PAY_MERCHANT, com.dt.platform.domain.common.PayMerchant.class, "payMerchant", "payMerchant", com.dt.platform.domain.common.PayMerchant.class, null);
	
	/**
	 * payApp , 类型: com.dt.platform.domain.common.PayApp
	*/
	public static final String PAY_APP="payApp";
	
	/**
	 * payApp , 类型: com.dt.platform.domain.common.PayApp
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,com.dt.platform.domain.common.PayApp> PAY_APP_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,PAY_APP, com.dt.platform.domain.common.PayApp.class, "payApp", "payApp", com.dt.platform.domain.common.PayApp.class, null);
	
	/**
	 * payChannel , 类型: com.dt.platform.domain.common.PayChannel
	*/
	public static final String PAY_CHANNEL="payChannel";
	
	/**
	 * payChannel , 类型: com.dt.platform.domain.common.PayChannel
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,com.dt.platform.domain.common.PayChannel> PAY_CHANNEL_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,PAY_CHANNEL, com.dt.platform.domain.common.PayChannel.class, "payChannel", "payChannel", com.dt.platform.domain.common.PayChannel.class, null);
	
	/**
	 * payOrder , 类型: com.dt.platform.domain.common.PayOrder
	*/
	public static final String PAY_ORDER="payOrder";
	
	/**
	 * payOrder , 类型: com.dt.platform.domain.common.PayOrder
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayRefundVO,com.dt.platform.domain.common.PayOrder> PAY_ORDER_PROP = new BeanProperty(com.dt.platform.domain.common.PayRefundVO.class ,PAY_ORDER, com.dt.platform.domain.common.PayOrder.class, "payOrder", "payOrder", com.dt.platform.domain.common.PayOrder.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , STATUS , MERCHANT_ID , APP_ID , CHANNEL_ID , CHANNEL_CODE , ORDER_ID , TRADE_NO , MERCHANT_ORDER_ID , MERCHANT_REFUND_NO , NOTIFY_URL , NOTIFY_STATUS , TYPE , PAY_AMOUNT , REFUND_AMOUNT , REASON , USER_IP , CHANNEL_ORDER_NO , CHANNEL_REFUND_NO , CHANNEL_ERROR_CODE , CHANNEL_ERROR_MSG , CHANNEL_EXTRAS , EXPIRE_TIME , SUCCESS_TIME , NOTIFY_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PAY_MERCHANT , PAY_APP , PAY_CHANNEL , PAY_ORDER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.PayRefundVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public PayRefundVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public PayRefundVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public PayRefundVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public PayRefundVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public PayRefundVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public PayRefundVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public PayRefundVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public PayRefundVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public PayRefundVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public PayRefundVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public PayRefundVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public PayRefundVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
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
		public PayRefundVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PayRefundVO duplicate(boolean all) {
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
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setPayMerchant(this.getPayMerchant());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setPayOrder(this.getPayOrder());
				inst.setPayApp(this.getPayApp());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setPayChannel(this.getPayChannel());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}