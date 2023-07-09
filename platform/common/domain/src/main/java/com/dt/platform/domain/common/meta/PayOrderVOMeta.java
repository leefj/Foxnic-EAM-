package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.PayOrderVO;
import java.util.List;
import com.dt.platform.domain.common.PayOrder;
import java.util.Date;
import java.math.BigDecimal;
import com.dt.platform.domain.common.PayChannel;
import com.dt.platform.domain.common.PayApp;
import com.dt.platform.domain.common.PayMerchant;
import com.dt.platform.domain.common.PayOrderExt;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 15:51:25
 * @sign 37A42F07B097BDFDF46B0A2E579694A4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PayOrderVOMeta extends PayOrderMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 支付状态 , 类型: java.lang.Integer
	*/
	public static final String STATUS="status";
	
	/**
	 * 支付状态 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.Integer> STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,STATUS, java.lang.Integer.class, "支付状态", "支付状态", java.lang.Integer.class, null);
	
	/**
	 * 交易单号 , 类型: java.lang.String
	*/
	public static final String TRADE_NO="tradeNo";
	
	/**
	 * 交易单号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> TRADE_NO_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,TRADE_NO, java.lang.String.class, "交易单号", "交易单号", java.lang.String.class, null);
	
	/**
	 * 商户编号 , 类型: java.lang.String
	*/
	public static final String MERCHANT_ID="merchantId";
	
	/**
	 * 商户编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> MERCHANT_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,MERCHANT_ID, java.lang.String.class, "商户编号", "商户编号", java.lang.String.class, null);
	
	/**
	 * 应用编号 , 类型: java.lang.String
	*/
	public static final String APP_ID="appId";
	
	/**
	 * 应用编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> APP_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,APP_ID, java.lang.String.class, "应用编号", "应用编号", java.lang.String.class, null);
	
	/**
	 * 商户订单 , 类型: java.lang.String
	*/
	public static final String MERCHANT_ORDER_ID="merchantOrderId";
	
	/**
	 * 商户订单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> MERCHANT_ORDER_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,MERCHANT_ORDER_ID, java.lang.String.class, "商户订单", "商户订单", java.lang.String.class, null);
	
	/**
	 * 商品标题 , 类型: java.lang.String
	*/
	public static final String SUBJECT="subject";
	
	/**
	 * 商品标题 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> SUBJECT_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,SUBJECT, java.lang.String.class, "商品标题", "商品标题", java.lang.String.class, null);
	
	/**
	 * 商品描述 , 类型: java.lang.String
	*/
	public static final String BODY="body";
	
	/**
	 * 商品描述 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> BODY_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,BODY, java.lang.String.class, "商品描述", "商品描述", java.lang.String.class, null);
	
	/**
	 * 异步通知地址 , 类型: java.lang.String
	*/
	public static final String NOTIFY_URL="notifyUrl";
	
	/**
	 * 异步通知地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> NOTIFY_URL_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,NOTIFY_URL, java.lang.String.class, "异步通知地址", "异步通知地址", java.lang.String.class, null);
	
	/**
	 * 回调状态 , 通知商户支付结果的 , 类型: java.lang.String
	*/
	public static final String NOTIFY_STATUS="notifyStatus";
	
	/**
	 * 回调状态 , 通知商户支付结果的 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> NOTIFY_STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,NOTIFY_STATUS, java.lang.String.class, "回调状态", "通知商户支付结果的", java.lang.String.class, null);
	
	/**
	 * 支付金额 , 单位：分 , 类型: java.lang.Long
	*/
	public static final String AMOUNT="amount";
	
	/**
	 * 支付金额 , 单位：分 , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.Long> AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,AMOUNT, java.lang.Long.class, "支付金额", "单位：分", java.lang.Long.class, null);
	
	/**
	 * 用户 , IP , 类型: java.lang.String
	*/
	public static final String USER_IP="userIp";
	
	/**
	 * 用户 , IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> USER_IP_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,USER_IP, java.lang.String.class, "用户", "IP", java.lang.String.class, null);
	
	/**
	 * 订单失效时间 , 类型: java.util.Date
	*/
	public static final String EXPIRE_TIME="expireTime";
	
	/**
	 * 订单失效时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.util.Date> EXPIRE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,EXPIRE_TIME, java.util.Date.class, "订单失效时间", "订单失效时间", java.util.Date.class, null);
	
	/**
	 * 订单支付成功时间 , 类型: java.util.Date
	*/
	public static final String SUCCESS_TIME="successTime";
	
	/**
	 * 订单支付成功时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.util.Date> SUCCESS_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,SUCCESS_TIME, java.util.Date.class, "订单支付成功时间", "订单支付成功时间", java.util.Date.class, null);
	
	/**
	 * 订单支付通知时间 , 类型: java.util.Date
	*/
	public static final String NOTIFY_TIME="notifyTime";
	
	/**
	 * 订单支付通知时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.util.Date> NOTIFY_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,NOTIFY_TIME, java.util.Date.class, "订单支付通知时间", "订单支付通知时间", java.util.Date.class, null);
	
	/**
	 * 支付成功的订单拓展单编号 , 类型: java.lang.String
	*/
	public static final String SUCCESS_EXTENSION_ID="successExtensionId";
	
	/**
	 * 支付成功的订单拓展单编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> SUCCESS_EXTENSION_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,SUCCESS_EXTENSION_ID, java.lang.String.class, "支付成功的订单拓展单编号", "支付成功的订单拓展单编号", java.lang.String.class, null);
	
	/**
	 * 退款状态 , 类型: java.lang.String
	*/
	public static final String REFUND_STATUS="refundStatus";
	
	/**
	 * 退款状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> REFUND_STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,REFUND_STATUS, java.lang.String.class, "退款状态", "退款状态", java.lang.String.class, null);
	
	/**
	 * 退款次数 , 类型: java.lang.Integer
	*/
	public static final String REFUND_TIMES="refundTimes";
	
	/**
	 * 退款次数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.Integer> REFUND_TIMES_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,REFUND_TIMES, java.lang.Integer.class, "退款次数", "退款次数", java.lang.Integer.class, null);
	
	/**
	 * 退款总金额 , 单位：分 , 类型: java.lang.Long
	*/
	public static final String REFUND_AMOUNT="refundAmount";
	
	/**
	 * 退款总金额 , 单位：分 , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.Long> REFUND_AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,REFUND_AMOUNT, java.lang.Long.class, "退款总金额", "单位：分", java.lang.Long.class, null);
	
	/**
	 * 渠道编号 , 类型: java.lang.String
	*/
	public static final String CHANNEL_ID="channelId";
	
	/**
	 * 渠道编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> CHANNEL_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,CHANNEL_ID, java.lang.String.class, "渠道编号", "渠道编号", java.lang.String.class, null);
	
	/**
	 * 渠道编码 , 类型: java.lang.String
	*/
	public static final String CHANNEL_CODE="channelCode";
	
	/**
	 * 渠道编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> CHANNEL_CODE_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,CHANNEL_CODE, java.lang.String.class, "渠道编码", "渠道编码", java.lang.String.class, null);
	
	/**
	 * 渠道用户 , 类型: java.lang.String
	*/
	public static final String CHANNEL_USER_ID="channelUserId";
	
	/**
	 * 渠道用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> CHANNEL_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,CHANNEL_USER_ID, java.lang.String.class, "渠道用户", "渠道用户", java.lang.String.class, null);
	
	/**
	 * 渠道手续费 , 单位：百分比 , 类型: java.math.BigDecimal
	*/
	public static final String CHANNEL_FEE_RATE="channelFeeRate";
	
	/**
	 * 渠道手续费 , 单位：百分比 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.math.BigDecimal> CHANNEL_FEE_RATE_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,CHANNEL_FEE_RATE, java.math.BigDecimal.class, "渠道手续费", "单位：百分比", java.math.BigDecimal.class, null);
	
	/**
	 * 渠道手续金额 , 单位：分 , 类型: java.lang.Long
	*/
	public static final String CHANNEL_FEE_AMOUNT="channelFeeAmount";
	
	/**
	 * 渠道手续金额 , 单位：分 , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.Long> CHANNEL_FEE_AMOUNT_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,CHANNEL_FEE_AMOUNT, java.lang.Long.class, "渠道手续金额", "单位：分", java.lang.Long.class, null);
	
	/**
	 * 渠道订单 , 类型: java.lang.String
	*/
	public static final String CHANNEL_ORDER_NO="channelOrderNo";
	
	/**
	 * 渠道订单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> CHANNEL_ORDER_NO_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,CHANNEL_ORDER_NO, java.lang.String.class, "渠道订单", "渠道订单", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * payChannel , 类型: com.dt.platform.domain.common.PayChannel
	*/
	public static final String PAY_CHANNEL="payChannel";
	
	/**
	 * payChannel , 类型: com.dt.platform.domain.common.PayChannel
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,com.dt.platform.domain.common.PayChannel> PAY_CHANNEL_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,PAY_CHANNEL, com.dt.platform.domain.common.PayChannel.class, "payChannel", "payChannel", com.dt.platform.domain.common.PayChannel.class, null);
	
	/**
	 * payApp , 类型: com.dt.platform.domain.common.PayApp
	*/
	public static final String PAY_APP="payApp";
	
	/**
	 * payApp , 类型: com.dt.platform.domain.common.PayApp
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,com.dt.platform.domain.common.PayApp> PAY_APP_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,PAY_APP, com.dt.platform.domain.common.PayApp.class, "payApp", "payApp", com.dt.platform.domain.common.PayApp.class, null);
	
	/**
	 * payMerchant , 类型: com.dt.platform.domain.common.PayMerchant
	*/
	public static final String PAY_MERCHANT="payMerchant";
	
	/**
	 * payMerchant , 类型: com.dt.platform.domain.common.PayMerchant
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,com.dt.platform.domain.common.PayMerchant> PAY_MERCHANT_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,PAY_MERCHANT, com.dt.platform.domain.common.PayMerchant.class, "payMerchant", "payMerchant", com.dt.platform.domain.common.PayMerchant.class, null);
	
	/**
	 * payOrderExt , 类型: com.dt.platform.domain.common.PayOrderExt
	*/
	public static final String PAY_ORDER_EXT="payOrderExt";
	
	/**
	 * payOrderExt , 类型: com.dt.platform.domain.common.PayOrderExt
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayOrderVO,com.dt.platform.domain.common.PayOrderExt> PAY_ORDER_EXT_PROP = new BeanProperty(com.dt.platform.domain.common.PayOrderVO.class ,PAY_ORDER_EXT, com.dt.platform.domain.common.PayOrderExt.class, "payOrderExt", "payOrderExt", com.dt.platform.domain.common.PayOrderExt.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , STATUS , TRADE_NO , MERCHANT_ID , APP_ID , MERCHANT_ORDER_ID , SUBJECT , BODY , NOTIFY_URL , NOTIFY_STATUS , AMOUNT , USER_IP , EXPIRE_TIME , SUCCESS_TIME , NOTIFY_TIME , SUCCESS_EXTENSION_ID , REFUND_STATUS , REFUND_TIMES , REFUND_AMOUNT , CHANNEL_ID , CHANNEL_CODE , CHANNEL_USER_ID , CHANNEL_FEE_RATE , CHANNEL_FEE_AMOUNT , CHANNEL_ORDER_NO , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PAY_CHANNEL , PAY_APP , PAY_MERCHANT , PAY_ORDER_EXT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.PayOrderVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public PayOrderVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public PayOrderVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public PayOrderVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public PayOrderVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public PayOrderVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public PayOrderVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public PayOrderVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public PayOrderVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public PayOrderVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public PayOrderVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public PayOrderVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public PayOrderVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PayOrder setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 支付状态
		 * @param status 支付状态
		 * @return 当前对象
		*/
		public PayOrder setStatus(Integer status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 交易单号
		 * @param tradeNo 交易单号
		 * @return 当前对象
		*/
		public PayOrder setTradeNo(String tradeNo) {
			super.change(TRADE_NO,super.getTradeNo(),tradeNo);
			super.setTradeNo(tradeNo);
			return this;
		}
		
		/**
		 * 设置 商户编号
		 * @param merchantId 商户编号
		 * @return 当前对象
		*/
		public PayOrder setMerchantId(String merchantId) {
			super.change(MERCHANT_ID,super.getMerchantId(),merchantId);
			super.setMerchantId(merchantId);
			return this;
		}
		
		/**
		 * 设置 应用编号
		 * @param appId 应用编号
		 * @return 当前对象
		*/
		public PayOrder setAppId(String appId) {
			super.change(APP_ID,super.getAppId(),appId);
			super.setAppId(appId);
			return this;
		}
		
		/**
		 * 设置 商户订单
		 * @param merchantOrderId 商户订单
		 * @return 当前对象
		*/
		public PayOrder setMerchantOrderId(String merchantOrderId) {
			super.change(MERCHANT_ORDER_ID,super.getMerchantOrderId(),merchantOrderId);
			super.setMerchantOrderId(merchantOrderId);
			return this;
		}
		
		/**
		 * 设置 商品标题
		 * @param subject 商品标题
		 * @return 当前对象
		*/
		public PayOrder setSubject(String subject) {
			super.change(SUBJECT,super.getSubject(),subject);
			super.setSubject(subject);
			return this;
		}
		
		/**
		 * 设置 商品描述
		 * @param body 商品描述
		 * @return 当前对象
		*/
		public PayOrder setBody(String body) {
			super.change(BODY,super.getBody(),body);
			super.setBody(body);
			return this;
		}
		
		/**
		 * 设置 异步通知地址
		 * @param notifyUrl 异步通知地址
		 * @return 当前对象
		*/
		public PayOrder setNotifyUrl(String notifyUrl) {
			super.change(NOTIFY_URL,super.getNotifyUrl(),notifyUrl);
			super.setNotifyUrl(notifyUrl);
			return this;
		}
		
		/**
		 * 设置 回调状态
		 * @param notifyStatus 回调状态
		 * @return 当前对象
		*/
		public PayOrder setNotifyStatus(String notifyStatus) {
			super.change(NOTIFY_STATUS,super.getNotifyStatus(),notifyStatus);
			super.setNotifyStatus(notifyStatus);
			return this;
		}
		
		/**
		 * 设置 支付金额
		 * @param amount 支付金额
		 * @return 当前对象
		*/
		public PayOrder setAmount(Long amount) {
			super.change(AMOUNT,super.getAmount(),amount);
			super.setAmount(amount);
			return this;
		}
		
		/**
		 * 设置 用户
		 * @param userIp 用户
		 * @return 当前对象
		*/
		public PayOrder setUserIp(String userIp) {
			super.change(USER_IP,super.getUserIp(),userIp);
			super.setUserIp(userIp);
			return this;
		}
		
		/**
		 * 设置 订单失效时间
		 * @param expireTime 订单失效时间
		 * @return 当前对象
		*/
		public PayOrder setExpireTime(Date expireTime) {
			super.change(EXPIRE_TIME,super.getExpireTime(),expireTime);
			super.setExpireTime(expireTime);
			return this;
		}
		
		/**
		 * 设置 订单支付成功时间
		 * @param successTime 订单支付成功时间
		 * @return 当前对象
		*/
		public PayOrder setSuccessTime(Date successTime) {
			super.change(SUCCESS_TIME,super.getSuccessTime(),successTime);
			super.setSuccessTime(successTime);
			return this;
		}
		
		/**
		 * 设置 订单支付通知时间
		 * @param notifyTime 订单支付通知时间
		 * @return 当前对象
		*/
		public PayOrder setNotifyTime(Date notifyTime) {
			super.change(NOTIFY_TIME,super.getNotifyTime(),notifyTime);
			super.setNotifyTime(notifyTime);
			return this;
		}
		
		/**
		 * 设置 支付成功的订单拓展单编号
		 * @param successExtensionId 支付成功的订单拓展单编号
		 * @return 当前对象
		*/
		public PayOrder setSuccessExtensionId(String successExtensionId) {
			super.change(SUCCESS_EXTENSION_ID,super.getSuccessExtensionId(),successExtensionId);
			super.setSuccessExtensionId(successExtensionId);
			return this;
		}
		
		/**
		 * 设置 退款状态
		 * @param refundStatus 退款状态
		 * @return 当前对象
		*/
		public PayOrder setRefundStatus(String refundStatus) {
			super.change(REFUND_STATUS,super.getRefundStatus(),refundStatus);
			super.setRefundStatus(refundStatus);
			return this;
		}
		
		/**
		 * 设置 退款次数
		 * @param refundTimes 退款次数
		 * @return 当前对象
		*/
		public PayOrder setRefundTimes(Integer refundTimes) {
			super.change(REFUND_TIMES,super.getRefundTimes(),refundTimes);
			super.setRefundTimes(refundTimes);
			return this;
		}
		
		/**
		 * 设置 退款总金额
		 * @param refundAmount 退款总金额
		 * @return 当前对象
		*/
		public PayOrder setRefundAmount(Long refundAmount) {
			super.change(REFUND_AMOUNT,super.getRefundAmount(),refundAmount);
			super.setRefundAmount(refundAmount);
			return this;
		}
		
		/**
		 * 设置 渠道编号
		 * @param channelId 渠道编号
		 * @return 当前对象
		*/
		public PayOrder setChannelId(String channelId) {
			super.change(CHANNEL_ID,super.getChannelId(),channelId);
			super.setChannelId(channelId);
			return this;
		}
		
		/**
		 * 设置 渠道编码
		 * @param channelCode 渠道编码
		 * @return 当前对象
		*/
		public PayOrder setChannelCode(String channelCode) {
			super.change(CHANNEL_CODE,super.getChannelCode(),channelCode);
			super.setChannelCode(channelCode);
			return this;
		}
		
		/**
		 * 设置 渠道用户
		 * @param channelUserId 渠道用户
		 * @return 当前对象
		*/
		public PayOrder setChannelUserId(String channelUserId) {
			super.change(CHANNEL_USER_ID,super.getChannelUserId(),channelUserId);
			super.setChannelUserId(channelUserId);
			return this;
		}
		
		/**
		 * 设置 渠道手续费
		 * @param channelFeeRate 渠道手续费
		 * @return 当前对象
		*/
		public PayOrder setChannelFeeRate(BigDecimal channelFeeRate) {
			super.change(CHANNEL_FEE_RATE,super.getChannelFeeRate(),channelFeeRate);
			super.setChannelFeeRate(channelFeeRate);
			return this;
		}
		
		/**
		 * 设置 渠道手续金额
		 * @param channelFeeAmount 渠道手续金额
		 * @return 当前对象
		*/
		public PayOrder setChannelFeeAmount(Long channelFeeAmount) {
			super.change(CHANNEL_FEE_AMOUNT,super.getChannelFeeAmount(),channelFeeAmount);
			super.setChannelFeeAmount(channelFeeAmount);
			return this;
		}
		
		/**
		 * 设置 渠道订单
		 * @param channelOrderNo 渠道订单
		 * @return 当前对象
		*/
		public PayOrder setChannelOrderNo(String channelOrderNo) {
			super.change(CHANNEL_ORDER_NO,super.getChannelOrderNo(),channelOrderNo);
			super.setChannelOrderNo(channelOrderNo);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PayOrder setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PayOrder setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PayOrder setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PayOrder setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PayOrder setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PayOrder setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PayOrder setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PayOrder setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PayOrder setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 payChannel
		 * @param payChannel payChannel
		 * @return 当前对象
		*/
		public PayOrder setPayChannel(PayChannel payChannel) {
			super.change(PAY_CHANNEL,super.getPayChannel(),payChannel);
			super.setPayChannel(payChannel);
			return this;
		}
		
		/**
		 * 设置 payApp
		 * @param payApp payApp
		 * @return 当前对象
		*/
		public PayOrder setPayApp(PayApp payApp) {
			super.change(PAY_APP,super.getPayApp(),payApp);
			super.setPayApp(payApp);
			return this;
		}
		
		/**
		 * 设置 payMerchant
		 * @param payMerchant payMerchant
		 * @return 当前对象
		*/
		public PayOrder setPayMerchant(PayMerchant payMerchant) {
			super.change(PAY_MERCHANT,super.getPayMerchant(),payMerchant);
			super.setPayMerchant(payMerchant);
			return this;
		}
		
		/**
		 * 设置 payOrderExt
		 * @param payOrderExt payOrderExt
		 * @return 当前对象
		*/
		public PayOrder setPayOrderExt(PayOrderExt payOrderExt) {
			super.change(PAY_ORDER_EXT,super.getPayOrderExt(),payOrderExt);
			super.setPayOrderExt(payOrderExt);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PayOrderVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PayOrderVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setSubject(this.getSubject());
			inst.setNotifyStatus(this.getNotifyStatus());
			inst.setRefundStatus(this.getRefundStatus());
			inst.setChannelOrderNo(this.getChannelOrderNo());
			inst.setMerchantOrderId(this.getMerchantOrderId());
			inst.setBody(this.getBody());
			inst.setRefundTimes(this.getRefundTimes());
			inst.setChannelFeeAmount(this.getChannelFeeAmount());
			inst.setMerchantId(this.getMerchantId());
			inst.setChannelUserId(this.getChannelUserId());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setAppId(this.getAppId());
			inst.setSuccessTime(this.getSuccessTime());
			inst.setId(this.getId());
			inst.setChannelId(this.getChannelId());
			inst.setSuccessExtensionId(this.getSuccessExtensionId());
			inst.setRefundAmount(this.getRefundAmount());
			inst.setChannelCode(this.getChannelCode());
			inst.setAmount(this.getAmount());
			inst.setTradeNo(this.getTradeNo());
			inst.setNotifyTime(this.getNotifyTime());
			inst.setChannelFeeRate(this.getChannelFeeRate());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setExpireTime(this.getExpireTime());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setNotifyUrl(this.getNotifyUrl());
			inst.setUserIp(this.getUserIp());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setPayMerchant(this.getPayMerchant());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
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
				inst.setPayOrderExt(this.getPayOrderExt());
			}
			inst.clearModifies();
			return inst;
		}

	}
}