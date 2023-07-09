package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_PAY_REFUND;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.PayRefundMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 退款订单
 * <p>退款订单 , 数据表 sys_pay_refund 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 16:15:46
 * @sign ED8955D8A6CA7B8757035F727832E94C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_pay_refund")
@ApiModel(description = "退款订单 ; 退款订单 , 数据表 sys_pay_refund 的PO类型")
public class PayRefund extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_PAY_REFUND.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 退款状态：退款状态
	*/
	@ApiModelProperty(required = true,value="退款状态" , notes = "退款状态")
	private String status;
	
	/**
	 * 商户编号：商户编号
	*/
	@ApiModelProperty(required = true,value="商户编号" , notes = "商户编号")
	private String merchantId;
	
	/**
	 * 应用编号：应用编号
	*/
	@ApiModelProperty(required = true,value="应用编号" , notes = "应用编号")
	private String appId;
	
	/**
	 * 渠道编号：渠道编号
	*/
	@ApiModelProperty(required = true,value="渠道编号" , notes = "渠道编号")
	private String channelId;
	
	/**
	 * 渠道编码：渠道编码
	*/
	@ApiModelProperty(required = true,value="渠道编码" , notes = "渠道编码")
	private String channelCode;
	
	/**
	 * 支付订单：pay_order 表id
	*/
	@ApiModelProperty(required = true,value="支付订单" , notes = "pay_order 表id")
	private String orderId;
	
	/**
	 * 交易订单：pay_extension 表no 字段
	*/
	@ApiModelProperty(required = true,value="交易订单" , notes = "pay_extension 表no 字段")
	private String tradeNo;
	
	/**
	 * 商户订单编号：商户系统生成）
	*/
	@ApiModelProperty(required = true,value="商户订单编号" , notes = "商户系统生成）")
	private String merchantOrderId;
	
	/**
	 * 商户退款订单号：商户系统生成）
	*/
	@ApiModelProperty(required = true,value="商户退款订单号" , notes = "商户系统生成）")
	private String merchantRefundNo;
	
	/**
	 * 异步通知商户地址：异步通知商户地址
	*/
	@ApiModelProperty(required = true,value="异步通知商户地址" , notes = "异步通知商户地址")
	private String notifyUrl;
	
	/**
	 * 回调状态：通知商户退款结果的
	*/
	@ApiModelProperty(required = true,value="回调状态" , notes = "通知商户退款结果的")
	private String notifyStatus;
	
	/**
	 * 退款类型：部分退款，全部退款)
	*/
	@ApiModelProperty(required = true,value="退款类型" , notes = "部分退款，全部退款)")
	private String type;
	
	/**
	 * 支付金额：单位分
	*/
	@ApiModelProperty(required = true,value="支付金额" , notes = "单位分")
	private Long payAmount;
	
	/**
	 * 退款金额：单位分
	*/
	@ApiModelProperty(required = true,value="退款金额" , notes = "单位分")
	private Long refundAmount;
	
	/**
	 * 退款原因：退款原因
	*/
	@ApiModelProperty(required = true,value="退款原因" , notes = "退款原因")
	private String reason;
	
	/**
	 * 用户：IP
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "IP")
	private String userIp;
	
	/**
	 * 渠道订单号：pay_order 中的channel_order_no 对应
	*/
	@ApiModelProperty(required = true,value="渠道订单号" , notes = "pay_order 中的channel_order_no 对应")
	private String channelOrderNo;
	
	/**
	 * 渠道退款单号：渠道返回
	*/
	@ApiModelProperty(required = false,value="渠道退款单号" , notes = "渠道返回")
	private String channelRefundNo;
	
	/**
	 * 渠道调用报错时：错误码
	*/
	@ApiModelProperty(required = false,value="渠道调用报错时" , notes = "错误码")
	private String channelErrorCode;
	
	/**
	 * 渠道调用报错时：错误信息
	*/
	@ApiModelProperty(required = false,value="渠道调用报错时" , notes = "错误信息")
	private String channelErrorMsg;
	
	/**
	 * 支付渠道的额外参数：支付渠道的额外参数
	*/
	@ApiModelProperty(required = false,value="支付渠道的额外参数" , notes = "支付渠道的额外参数")
	private String channelExtras;
	
	/**
	 * 退款失效时间：退款失效时间
	*/
	@ApiModelProperty(required = false,value="退款失效时间" , notes = "退款失效时间")
	private Date expireTime;
	
	/**
	 * 退款成功时间：退款成功时间
	*/
	@ApiModelProperty(required = false,value="退款成功时间" , notes = "退款成功时间")
	private Date successTime;
	
	/**
	 * 退款通知时间：退款通知时间
	*/
	@ApiModelProperty(required = false,value="退款通知时间" , notes = "退款通知时间")
	private Date notifyTime;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * payMerchant：payMerchant
	*/
	@ApiModelProperty(required = false,value="payMerchant" , notes = "payMerchant")
	private PayMerchant payMerchant;
	
	/**
	 * payApp：payApp
	*/
	@ApiModelProperty(required = false,value="payApp" , notes = "payApp")
	private PayApp payApp;
	
	/**
	 * payChannel：payChannel
	*/
	@ApiModelProperty(required = false,value="payChannel" , notes = "payChannel")
	private PayChannel payChannel;
	
	/**
	 * payOrder：payOrder
	*/
	@ApiModelProperty(required = false,value="payOrder" , notes = "payOrder")
	private PayOrder payOrder;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public PayRefund setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 退款状态<br>
	 * 退款状态
	 * @return 退款状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 退款状态
	 * @param status 退款状态
	 * @return 当前对象
	*/
	public PayRefund setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 商户编号<br>
	 * 商户编号
	 * @return 商户编号
	*/
	public String getMerchantId() {
		return merchantId;
	}
	
	/**
	 * 设置 商户编号
	 * @param merchantId 商户编号
	 * @return 当前对象
	*/
	public PayRefund setMerchantId(String merchantId) {
		this.merchantId=merchantId;
		return this;
	}
	
	/**
	 * 获得 应用编号<br>
	 * 应用编号
	 * @return 应用编号
	*/
	public String getAppId() {
		return appId;
	}
	
	/**
	 * 设置 应用编号
	 * @param appId 应用编号
	 * @return 当前对象
	*/
	public PayRefund setAppId(String appId) {
		this.appId=appId;
		return this;
	}
	
	/**
	 * 获得 渠道编号<br>
	 * 渠道编号
	 * @return 渠道编号
	*/
	public String getChannelId() {
		return channelId;
	}
	
	/**
	 * 设置 渠道编号
	 * @param channelId 渠道编号
	 * @return 当前对象
	*/
	public PayRefund setChannelId(String channelId) {
		this.channelId=channelId;
		return this;
	}
	
	/**
	 * 获得 渠道编码<br>
	 * 渠道编码
	 * @return 渠道编码
	*/
	public String getChannelCode() {
		return channelCode;
	}
	
	/**
	 * 设置 渠道编码
	 * @param channelCode 渠道编码
	 * @return 当前对象
	*/
	public PayRefund setChannelCode(String channelCode) {
		this.channelCode=channelCode;
		return this;
	}
	
	/**
	 * 获得 支付订单<br>
	 * pay_order 表id
	 * @return 支付订单
	*/
	public String getOrderId() {
		return orderId;
	}
	
	/**
	 * 设置 支付订单
	 * @param orderId 支付订单
	 * @return 当前对象
	*/
	public PayRefund setOrderId(String orderId) {
		this.orderId=orderId;
		return this;
	}
	
	/**
	 * 获得 交易订单<br>
	 * pay_extension 表no 字段
	 * @return 交易订单
	*/
	public String getTradeNo() {
		return tradeNo;
	}
	
	/**
	 * 设置 交易订单
	 * @param tradeNo 交易订单
	 * @return 当前对象
	*/
	public PayRefund setTradeNo(String tradeNo) {
		this.tradeNo=tradeNo;
		return this;
	}
	
	/**
	 * 获得 商户订单编号<br>
	 * 商户系统生成）
	 * @return 商户订单编号
	*/
	public String getMerchantOrderId() {
		return merchantOrderId;
	}
	
	/**
	 * 设置 商户订单编号
	 * @param merchantOrderId 商户订单编号
	 * @return 当前对象
	*/
	public PayRefund setMerchantOrderId(String merchantOrderId) {
		this.merchantOrderId=merchantOrderId;
		return this;
	}
	
	/**
	 * 获得 商户退款订单号<br>
	 * 商户系统生成）
	 * @return 商户退款订单号
	*/
	public String getMerchantRefundNo() {
		return merchantRefundNo;
	}
	
	/**
	 * 设置 商户退款订单号
	 * @param merchantRefundNo 商户退款订单号
	 * @return 当前对象
	*/
	public PayRefund setMerchantRefundNo(String merchantRefundNo) {
		this.merchantRefundNo=merchantRefundNo;
		return this;
	}
	
	/**
	 * 获得 异步通知商户地址<br>
	 * 异步通知商户地址
	 * @return 异步通知商户地址
	*/
	public String getNotifyUrl() {
		return notifyUrl;
	}
	
	/**
	 * 设置 异步通知商户地址
	 * @param notifyUrl 异步通知商户地址
	 * @return 当前对象
	*/
	public PayRefund setNotifyUrl(String notifyUrl) {
		this.notifyUrl=notifyUrl;
		return this;
	}
	
	/**
	 * 获得 回调状态<br>
	 * 通知商户退款结果的
	 * @return 回调状态
	*/
	public String getNotifyStatus() {
		return notifyStatus;
	}
	
	/**
	 * 设置 回调状态
	 * @param notifyStatus 回调状态
	 * @return 当前对象
	*/
	public PayRefund setNotifyStatus(String notifyStatus) {
		this.notifyStatus=notifyStatus;
		return this;
	}
	
	/**
	 * 获得 退款类型<br>
	 * 部分退款，全部退款)
	 * @return 退款类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 退款类型
	 * @param type 退款类型
	 * @return 当前对象
	*/
	public PayRefund setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 支付金额<br>
	 * 单位分
	 * @return 支付金额
	*/
	public Long getPayAmount() {
		return payAmount;
	}
	
	/**
	 * 设置 支付金额
	 * @param payAmount 支付金额
	 * @return 当前对象
	*/
	public PayRefund setPayAmount(Long payAmount) {
		this.payAmount=payAmount;
		return this;
	}
	
	/**
	 * 获得 退款金额<br>
	 * 单位分
	 * @return 退款金额
	*/
	public Long getRefundAmount() {
		return refundAmount;
	}
	
	/**
	 * 设置 退款金额
	 * @param refundAmount 退款金额
	 * @return 当前对象
	*/
	public PayRefund setRefundAmount(Long refundAmount) {
		this.refundAmount=refundAmount;
		return this;
	}
	
	/**
	 * 获得 退款原因<br>
	 * 退款原因
	 * @return 退款原因
	*/
	public String getReason() {
		return reason;
	}
	
	/**
	 * 设置 退款原因
	 * @param reason 退款原因
	 * @return 当前对象
	*/
	public PayRefund setReason(String reason) {
		this.reason=reason;
		return this;
	}
	
	/**
	 * 获得 用户<br>
	 * IP
	 * @return 用户
	*/
	public String getUserIp() {
		return userIp;
	}
	
	/**
	 * 设置 用户
	 * @param userIp 用户
	 * @return 当前对象
	*/
	public PayRefund setUserIp(String userIp) {
		this.userIp=userIp;
		return this;
	}
	
	/**
	 * 获得 渠道订单号<br>
	 * pay_order 中的channel_order_no 对应
	 * @return 渠道订单号
	*/
	public String getChannelOrderNo() {
		return channelOrderNo;
	}
	
	/**
	 * 设置 渠道订单号
	 * @param channelOrderNo 渠道订单号
	 * @return 当前对象
	*/
	public PayRefund setChannelOrderNo(String channelOrderNo) {
		this.channelOrderNo=channelOrderNo;
		return this;
	}
	
	/**
	 * 获得 渠道退款单号<br>
	 * 渠道返回
	 * @return 渠道退款单号
	*/
	public String getChannelRefundNo() {
		return channelRefundNo;
	}
	
	/**
	 * 设置 渠道退款单号
	 * @param channelRefundNo 渠道退款单号
	 * @return 当前对象
	*/
	public PayRefund setChannelRefundNo(String channelRefundNo) {
		this.channelRefundNo=channelRefundNo;
		return this;
	}
	
	/**
	 * 获得 渠道调用报错时<br>
	 * 错误码
	 * @return 渠道调用报错时
	*/
	public String getChannelErrorCode() {
		return channelErrorCode;
	}
	
	/**
	 * 设置 渠道调用报错时
	 * @param channelErrorCode 渠道调用报错时
	 * @return 当前对象
	*/
	public PayRefund setChannelErrorCode(String channelErrorCode) {
		this.channelErrorCode=channelErrorCode;
		return this;
	}
	
	/**
	 * 获得 渠道调用报错时<br>
	 * 错误信息
	 * @return 渠道调用报错时
	*/
	public String getChannelErrorMsg() {
		return channelErrorMsg;
	}
	
	/**
	 * 设置 渠道调用报错时
	 * @param channelErrorMsg 渠道调用报错时
	 * @return 当前对象
	*/
	public PayRefund setChannelErrorMsg(String channelErrorMsg) {
		this.channelErrorMsg=channelErrorMsg;
		return this;
	}
	
	/**
	 * 获得 支付渠道的额外参数<br>
	 * 支付渠道的额外参数
	 * @return 支付渠道的额外参数
	*/
	public String getChannelExtras() {
		return channelExtras;
	}
	
	/**
	 * 设置 支付渠道的额外参数
	 * @param channelExtras 支付渠道的额外参数
	 * @return 当前对象
	*/
	public PayRefund setChannelExtras(String channelExtras) {
		this.channelExtras=channelExtras;
		return this;
	}
	
	/**
	 * 获得 退款失效时间<br>
	 * 退款失效时间
	 * @return 退款失效时间
	*/
	public Date getExpireTime() {
		return expireTime;
	}
	
	/**
	 * 设置 退款失效时间
	 * @param expireTime 退款失效时间
	 * @return 当前对象
	*/
	public PayRefund setExpireTime(Date expireTime) {
		this.expireTime=expireTime;
		return this;
	}
	
	/**
	 * 获得 退款成功时间<br>
	 * 退款成功时间
	 * @return 退款成功时间
	*/
	public Date getSuccessTime() {
		return successTime;
	}
	
	/**
	 * 设置 退款成功时间
	 * @param successTime 退款成功时间
	 * @return 当前对象
	*/
	public PayRefund setSuccessTime(Date successTime) {
		this.successTime=successTime;
		return this;
	}
	
	/**
	 * 获得 退款通知时间<br>
	 * 退款通知时间
	 * @return 退款通知时间
	*/
	public Date getNotifyTime() {
		return notifyTime;
	}
	
	/**
	 * 设置 退款通知时间
	 * @param notifyTime 退款通知时间
	 * @return 当前对象
	*/
	public PayRefund setNotifyTime(Date notifyTime) {
		this.notifyTime=notifyTime;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public PayRefund setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public PayRefund setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public PayRefund setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public PayRefund setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	@JsonProperty("deleted")
	public PayRefund setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public PayRefund setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public PayRefund setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public PayRefund setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public PayRefund setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 租户<br>
	 * 租户
	 * @return 租户
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户
	 * @param tenantId 租户
	 * @return 当前对象
	*/
	public PayRefund setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 payMerchant<br>
	 * payMerchant
	 * @return payMerchant
	*/
	public PayMerchant getPayMerchant() {
		return payMerchant;
	}
	
	/**
	 * 设置 payMerchant
	 * @param payMerchant payMerchant
	 * @return 当前对象
	*/
	public PayRefund setPayMerchant(PayMerchant payMerchant) {
		this.payMerchant=payMerchant;
		return this;
	}
	
	/**
	 * 获得 payApp<br>
	 * payApp
	 * @return payApp
	*/
	public PayApp getPayApp() {
		return payApp;
	}
	
	/**
	 * 设置 payApp
	 * @param payApp payApp
	 * @return 当前对象
	*/
	public PayRefund setPayApp(PayApp payApp) {
		this.payApp=payApp;
		return this;
	}
	
	/**
	 * 获得 payChannel<br>
	 * payChannel
	 * @return payChannel
	*/
	public PayChannel getPayChannel() {
		return payChannel;
	}
	
	/**
	 * 设置 payChannel
	 * @param payChannel payChannel
	 * @return 当前对象
	*/
	public PayRefund setPayChannel(PayChannel payChannel) {
		this.payChannel=payChannel;
		return this;
	}
	
	/**
	 * 获得 payOrder<br>
	 * payOrder
	 * @return payOrder
	*/
	public PayOrder getPayOrder() {
		return payOrder;
	}
	
	/**
	 * 设置 payOrder
	 * @param payOrder payOrder
	 * @return 当前对象
	*/
	public PayRefund setPayOrder(PayOrder payOrder) {
		this.payOrder=payOrder;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PayRefund , 转换好的 PayRefund 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PayRefund , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
		com.dt.platform.domain.common.meta.PayRefundMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.PayRefundMeta.$$proxy$$();
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

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PayRefund clone(boolean deep) {
		return EntityContext.clone(PayRefund.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PayRefund
	 * @param payRefundMap 包含实体信息的 Map 对象
	 * @return PayRefund , 转换好的的 PayRefund 对象
	*/
	@Transient
	public static PayRefund createFrom(Map<String,Object> payRefundMap) {
		if(payRefundMap==null) return null;
		PayRefund po = create();
		EntityContext.copyProperties(po,payRefundMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PayRefund
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PayRefund , 转换好的的 PayRefund 对象
	*/
	@Transient
	public static PayRefund createFrom(Object pojo) {
		if(pojo==null) return null;
		PayRefund po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PayRefund，等同于 new
	 * @return PayRefund 对象
	*/
	@Transient
	public static PayRefund create() {
		return new com.dt.platform.domain.common.meta.PayRefundMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setReason(DataParser.parse(String.class, map.get(PayRefundMeta.REASON)));
			this.setOrderId(DataParser.parse(String.class, map.get(PayRefundMeta.ORDER_ID)));
			this.setNotifyStatus(DataParser.parse(String.class, map.get(PayRefundMeta.NOTIFY_STATUS)));
			this.setChannelRefundNo(DataParser.parse(String.class, map.get(PayRefundMeta.CHANNEL_REFUND_NO)));
			this.setChannelOrderNo(DataParser.parse(String.class, map.get(PayRefundMeta.CHANNEL_ORDER_NO)));
			this.setMerchantOrderId(DataParser.parse(String.class, map.get(PayRefundMeta.MERCHANT_ORDER_ID)));
			this.setType(DataParser.parse(String.class, map.get(PayRefundMeta.TYPE)));
			this.setPayAmount(DataParser.parse(Long.class, map.get(PayRefundMeta.PAY_AMOUNT)));
			this.setMerchantId(DataParser.parse(String.class, map.get(PayRefundMeta.MERCHANT_ID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PayRefundMeta.UPDATE_BY)));
			this.setAppId(DataParser.parse(String.class, map.get(PayRefundMeta.APP_ID)));
			this.setSuccessTime(DataParser.parse(Date.class, map.get(PayRefundMeta.SUCCESS_TIME)));
			this.setId(DataParser.parse(String.class, map.get(PayRefundMeta.ID)));
			this.setChannelId(DataParser.parse(String.class, map.get(PayRefundMeta.CHANNEL_ID)));
			this.setChannelCode(DataParser.parse(String.class, map.get(PayRefundMeta.CHANNEL_CODE)));
			this.setRefundAmount(DataParser.parse(Long.class, map.get(PayRefundMeta.REFUND_AMOUNT)));
			this.setChannelErrorMsg(DataParser.parse(String.class, map.get(PayRefundMeta.CHANNEL_ERROR_MSG)));
			this.setTradeNo(DataParser.parse(String.class, map.get(PayRefundMeta.TRADE_NO)));
			this.setMerchantRefundNo(DataParser.parse(String.class, map.get(PayRefundMeta.MERCHANT_REFUND_NO)));
			this.setNotifyTime(DataParser.parse(Date.class, map.get(PayRefundMeta.NOTIFY_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PayRefundMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PayRefundMeta.VERSION)));
			this.setChannelErrorCode(DataParser.parse(String.class, map.get(PayRefundMeta.CHANNEL_ERROR_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PayRefundMeta.CREATE_BY)));
			this.setExpireTime(DataParser.parse(Date.class, map.get(PayRefundMeta.EXPIRE_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PayRefundMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PayRefundMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PayRefundMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PayRefundMeta.TENANT_ID)));
			this.setNotifyUrl(DataParser.parse(String.class, map.get(PayRefundMeta.NOTIFY_URL)));
			this.setUserIp(DataParser.parse(String.class, map.get(PayRefundMeta.USER_IP)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PayRefundMeta.DELETE_BY)));
			this.setChannelExtras(DataParser.parse(String.class, map.get(PayRefundMeta.CHANNEL_EXTRAS)));
			this.setStatus(DataParser.parse(String.class, map.get(PayRefundMeta.STATUS)));
			// others
			this.setPayApp(DataParser.parse(PayApp.class, map.get(PayRefundMeta.PAY_APP)));
			this.setPayMerchant(DataParser.parse(PayMerchant.class, map.get(PayRefundMeta.PAY_MERCHANT)));
			this.setPayChannel(DataParser.parse(PayChannel.class, map.get(PayRefundMeta.PAY_CHANNEL)));
			this.setPayOrder(DataParser.parse(PayOrder.class, map.get(PayRefundMeta.PAY_ORDER)));
			return true;
		} else {
			try {
				this.setReason( (String)map.get(PayRefundMeta.REASON));
				this.setOrderId( (String)map.get(PayRefundMeta.ORDER_ID));
				this.setNotifyStatus( (String)map.get(PayRefundMeta.NOTIFY_STATUS));
				this.setChannelRefundNo( (String)map.get(PayRefundMeta.CHANNEL_REFUND_NO));
				this.setChannelOrderNo( (String)map.get(PayRefundMeta.CHANNEL_ORDER_NO));
				this.setMerchantOrderId( (String)map.get(PayRefundMeta.MERCHANT_ORDER_ID));
				this.setType( (String)map.get(PayRefundMeta.TYPE));
				this.setPayAmount( (Long)map.get(PayRefundMeta.PAY_AMOUNT));
				this.setMerchantId( (String)map.get(PayRefundMeta.MERCHANT_ID));
				this.setUpdateBy( (String)map.get(PayRefundMeta.UPDATE_BY));
				this.setAppId( (String)map.get(PayRefundMeta.APP_ID));
				this.setSuccessTime( (Date)map.get(PayRefundMeta.SUCCESS_TIME));
				this.setId( (String)map.get(PayRefundMeta.ID));
				this.setChannelId( (String)map.get(PayRefundMeta.CHANNEL_ID));
				this.setChannelCode( (String)map.get(PayRefundMeta.CHANNEL_CODE));
				this.setRefundAmount( (Long)map.get(PayRefundMeta.REFUND_AMOUNT));
				this.setChannelErrorMsg( (String)map.get(PayRefundMeta.CHANNEL_ERROR_MSG));
				this.setTradeNo( (String)map.get(PayRefundMeta.TRADE_NO));
				this.setMerchantRefundNo( (String)map.get(PayRefundMeta.MERCHANT_REFUND_NO));
				this.setNotifyTime( (Date)map.get(PayRefundMeta.NOTIFY_TIME));
				this.setUpdateTime( (Date)map.get(PayRefundMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PayRefundMeta.VERSION));
				this.setChannelErrorCode( (String)map.get(PayRefundMeta.CHANNEL_ERROR_CODE));
				this.setCreateBy( (String)map.get(PayRefundMeta.CREATE_BY));
				this.setExpireTime( (Date)map.get(PayRefundMeta.EXPIRE_TIME));
				this.setDeleted( (Integer)map.get(PayRefundMeta.DELETED));
				this.setCreateTime( (Date)map.get(PayRefundMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(PayRefundMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(PayRefundMeta.TENANT_ID));
				this.setNotifyUrl( (String)map.get(PayRefundMeta.NOTIFY_URL));
				this.setUserIp( (String)map.get(PayRefundMeta.USER_IP));
				this.setDeleteBy( (String)map.get(PayRefundMeta.DELETE_BY));
				this.setChannelExtras( (String)map.get(PayRefundMeta.CHANNEL_EXTRAS));
				this.setStatus( (String)map.get(PayRefundMeta.STATUS));
				// others
				this.setPayApp( (PayApp)map.get(PayRefundMeta.PAY_APP));
				this.setPayMerchant( (PayMerchant)map.get(PayRefundMeta.PAY_MERCHANT));
				this.setPayChannel( (PayChannel)map.get(PayRefundMeta.PAY_CHANNEL));
				this.setPayOrder( (PayOrder)map.get(PayRefundMeta.PAY_ORDER));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setReason(DataParser.parse(String.class, r.getValue(PayRefundMeta.REASON)));
			this.setOrderId(DataParser.parse(String.class, r.getValue(PayRefundMeta.ORDER_ID)));
			this.setNotifyStatus(DataParser.parse(String.class, r.getValue(PayRefundMeta.NOTIFY_STATUS)));
			this.setChannelRefundNo(DataParser.parse(String.class, r.getValue(PayRefundMeta.CHANNEL_REFUND_NO)));
			this.setChannelOrderNo(DataParser.parse(String.class, r.getValue(PayRefundMeta.CHANNEL_ORDER_NO)));
			this.setMerchantOrderId(DataParser.parse(String.class, r.getValue(PayRefundMeta.MERCHANT_ORDER_ID)));
			this.setType(DataParser.parse(String.class, r.getValue(PayRefundMeta.TYPE)));
			this.setPayAmount(DataParser.parse(Long.class, r.getValue(PayRefundMeta.PAY_AMOUNT)));
			this.setMerchantId(DataParser.parse(String.class, r.getValue(PayRefundMeta.MERCHANT_ID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PayRefundMeta.UPDATE_BY)));
			this.setAppId(DataParser.parse(String.class, r.getValue(PayRefundMeta.APP_ID)));
			this.setSuccessTime(DataParser.parse(Date.class, r.getValue(PayRefundMeta.SUCCESS_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(PayRefundMeta.ID)));
			this.setChannelId(DataParser.parse(String.class, r.getValue(PayRefundMeta.CHANNEL_ID)));
			this.setChannelCode(DataParser.parse(String.class, r.getValue(PayRefundMeta.CHANNEL_CODE)));
			this.setRefundAmount(DataParser.parse(Long.class, r.getValue(PayRefundMeta.REFUND_AMOUNT)));
			this.setChannelErrorMsg(DataParser.parse(String.class, r.getValue(PayRefundMeta.CHANNEL_ERROR_MSG)));
			this.setTradeNo(DataParser.parse(String.class, r.getValue(PayRefundMeta.TRADE_NO)));
			this.setMerchantRefundNo(DataParser.parse(String.class, r.getValue(PayRefundMeta.MERCHANT_REFUND_NO)));
			this.setNotifyTime(DataParser.parse(Date.class, r.getValue(PayRefundMeta.NOTIFY_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PayRefundMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PayRefundMeta.VERSION)));
			this.setChannelErrorCode(DataParser.parse(String.class, r.getValue(PayRefundMeta.CHANNEL_ERROR_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PayRefundMeta.CREATE_BY)));
			this.setExpireTime(DataParser.parse(Date.class, r.getValue(PayRefundMeta.EXPIRE_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PayRefundMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PayRefundMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PayRefundMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PayRefundMeta.TENANT_ID)));
			this.setNotifyUrl(DataParser.parse(String.class, r.getValue(PayRefundMeta.NOTIFY_URL)));
			this.setUserIp(DataParser.parse(String.class, r.getValue(PayRefundMeta.USER_IP)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PayRefundMeta.DELETE_BY)));
			this.setChannelExtras(DataParser.parse(String.class, r.getValue(PayRefundMeta.CHANNEL_EXTRAS)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PayRefundMeta.STATUS)));
			return true;
		} else {
			try {
				this.setReason( (String)r.getValue(PayRefundMeta.REASON));
				this.setOrderId( (String)r.getValue(PayRefundMeta.ORDER_ID));
				this.setNotifyStatus( (String)r.getValue(PayRefundMeta.NOTIFY_STATUS));
				this.setChannelRefundNo( (String)r.getValue(PayRefundMeta.CHANNEL_REFUND_NO));
				this.setChannelOrderNo( (String)r.getValue(PayRefundMeta.CHANNEL_ORDER_NO));
				this.setMerchantOrderId( (String)r.getValue(PayRefundMeta.MERCHANT_ORDER_ID));
				this.setType( (String)r.getValue(PayRefundMeta.TYPE));
				this.setPayAmount( (Long)r.getValue(PayRefundMeta.PAY_AMOUNT));
				this.setMerchantId( (String)r.getValue(PayRefundMeta.MERCHANT_ID));
				this.setUpdateBy( (String)r.getValue(PayRefundMeta.UPDATE_BY));
				this.setAppId( (String)r.getValue(PayRefundMeta.APP_ID));
				this.setSuccessTime( (Date)r.getValue(PayRefundMeta.SUCCESS_TIME));
				this.setId( (String)r.getValue(PayRefundMeta.ID));
				this.setChannelId( (String)r.getValue(PayRefundMeta.CHANNEL_ID));
				this.setChannelCode( (String)r.getValue(PayRefundMeta.CHANNEL_CODE));
				this.setRefundAmount( (Long)r.getValue(PayRefundMeta.REFUND_AMOUNT));
				this.setChannelErrorMsg( (String)r.getValue(PayRefundMeta.CHANNEL_ERROR_MSG));
				this.setTradeNo( (String)r.getValue(PayRefundMeta.TRADE_NO));
				this.setMerchantRefundNo( (String)r.getValue(PayRefundMeta.MERCHANT_REFUND_NO));
				this.setNotifyTime( (Date)r.getValue(PayRefundMeta.NOTIFY_TIME));
				this.setUpdateTime( (Date)r.getValue(PayRefundMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PayRefundMeta.VERSION));
				this.setChannelErrorCode( (String)r.getValue(PayRefundMeta.CHANNEL_ERROR_CODE));
				this.setCreateBy( (String)r.getValue(PayRefundMeta.CREATE_BY));
				this.setExpireTime( (Date)r.getValue(PayRefundMeta.EXPIRE_TIME));
				this.setDeleted( (Integer)r.getValue(PayRefundMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PayRefundMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(PayRefundMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(PayRefundMeta.TENANT_ID));
				this.setNotifyUrl( (String)r.getValue(PayRefundMeta.NOTIFY_URL));
				this.setUserIp( (String)r.getValue(PayRefundMeta.USER_IP));
				this.setDeleteBy( (String)r.getValue(PayRefundMeta.DELETE_BY));
				this.setChannelExtras( (String)r.getValue(PayRefundMeta.CHANNEL_EXTRAS));
				this.setStatus( (String)r.getValue(PayRefundMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}