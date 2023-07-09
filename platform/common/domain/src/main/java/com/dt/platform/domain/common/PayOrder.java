package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_PAY_ORDER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.PayOrderMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 支付订单
 * <p>支付订单 , 数据表 sys_pay_order 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 15:51:25
 * @sign 0D71A05F0DD83C55D3C59734C97743A8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_pay_order")
@ApiModel(description = "支付订单 ; 支付订单 , 数据表 sys_pay_order 的PO类型")
public class PayOrder extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_PAY_ORDER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 支付状态：支付状态
	*/
	@ApiModelProperty(required = true,value="支付状态" , notes = "支付状态")
	private Integer status;
	
	/**
	 * 交易单号：交易单号
	*/
	@ApiModelProperty(required = false,value="交易单号" , notes = "交易单号")
	private String tradeNo;
	
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
	 * 商户订单：商户订单
	*/
	@ApiModelProperty(required = true,value="商户订单" , notes = "商户订单")
	private String merchantOrderId;
	
	/**
	 * 商品标题：商品标题
	*/
	@ApiModelProperty(required = true,value="商品标题" , notes = "商品标题")
	private String subject;
	
	/**
	 * 商品描述：商品描述
	*/
	@ApiModelProperty(required = true,value="商品描述" , notes = "商品描述")
	private String body;
	
	/**
	 * 异步通知地址：异步通知地址
	*/
	@ApiModelProperty(required = true,value="异步通知地址" , notes = "异步通知地址")
	private String notifyUrl;
	
	/**
	 * 回调状态：通知商户支付结果的
	*/
	@ApiModelProperty(required = true,value="回调状态" , notes = "通知商户支付结果的")
	private String notifyStatus;
	
	/**
	 * 支付金额：单位：分
	*/
	@ApiModelProperty(required = true,value="支付金额" , notes = "单位：分")
	private Long amount;
	
	/**
	 * 用户：IP
	*/
	@ApiModelProperty(required = true,value="用户" , notes = "IP")
	private String userIp;
	
	/**
	 * 订单失效时间：订单失效时间
	*/
	@ApiModelProperty(required = true,value="订单失效时间" , notes = "订单失效时间")
	private Date expireTime;
	
	/**
	 * 订单支付成功时间：订单支付成功时间
	*/
	@ApiModelProperty(required = false,value="订单支付成功时间" , notes = "订单支付成功时间")
	private Date successTime;
	
	/**
	 * 订单支付通知时间：订单支付通知时间
	*/
	@ApiModelProperty(required = false,value="订单支付通知时间" , notes = "订单支付通知时间")
	private Date notifyTime;
	
	/**
	 * 支付成功的订单拓展单编号：支付成功的订单拓展单编号
	*/
	@ApiModelProperty(required = false,value="支付成功的订单拓展单编号" , notes = "支付成功的订单拓展单编号")
	private String successExtensionId;
	
	/**
	 * 退款状态：退款状态
	*/
	@ApiModelProperty(required = true,value="退款状态" , notes = "退款状态")
	private String refundStatus;
	
	/**
	 * 退款次数：退款次数
	*/
	@ApiModelProperty(required = true,value="退款次数" , notes = "退款次数")
	private Integer refundTimes;
	
	/**
	 * 退款总金额：单位：分
	*/
	@ApiModelProperty(required = true,value="退款总金额" , notes = "单位：分")
	private Long refundAmount;
	
	/**
	 * 渠道编号：渠道编号
	*/
	@ApiModelProperty(required = false,value="渠道编号" , notes = "渠道编号")
	private String channelId;
	
	/**
	 * 渠道编码：渠道编码
	*/
	@ApiModelProperty(required = false,value="渠道编码" , notes = "渠道编码")
	private String channelCode;
	
	/**
	 * 渠道用户：渠道用户
	*/
	@ApiModelProperty(required = false,value="渠道用户" , notes = "渠道用户")
	private String channelUserId;
	
	/**
	 * 渠道手续费：单位：百分比
	*/
	@ApiModelProperty(required = false,value="渠道手续费" , notes = "单位：百分比")
	private BigDecimal channelFeeRate;
	
	/**
	 * 渠道手续金额：单位：分
	*/
	@ApiModelProperty(required = false,value="渠道手续金额" , notes = "单位：分")
	private Long channelFeeAmount;
	
	/**
	 * 渠道订单：渠道订单
	*/
	@ApiModelProperty(required = false,value="渠道订单" , notes = "渠道订单")
	private String channelOrderNo;
	
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
	 * payChannel：payChannel
	*/
	@ApiModelProperty(required = false,value="payChannel" , notes = "payChannel")
	private PayChannel payChannel;
	
	/**
	 * payApp：payApp
	*/
	@ApiModelProperty(required = false,value="payApp" , notes = "payApp")
	private PayApp payApp;
	
	/**
	 * payMerchant：payMerchant
	*/
	@ApiModelProperty(required = false,value="payMerchant" , notes = "payMerchant")
	private PayMerchant payMerchant;
	
	/**
	 * payOrderExt：payOrderExt
	*/
	@ApiModelProperty(required = false,value="payOrderExt" , notes = "payOrderExt")
	private PayOrderExt payOrderExt;
	
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
	public PayOrder setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 支付状态<br>
	 * 支付状态
	 * @return 支付状态
	*/
	public Integer getStatus() {
		return status;
	}
	
	/**
	 * 设置 支付状态
	 * @param status 支付状态
	 * @return 当前对象
	*/
	public PayOrder setStatus(Integer status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 交易单号<br>
	 * 交易单号
	 * @return 交易单号
	*/
	public String getTradeNo() {
		return tradeNo;
	}
	
	/**
	 * 设置 交易单号
	 * @param tradeNo 交易单号
	 * @return 当前对象
	*/
	public PayOrder setTradeNo(String tradeNo) {
		this.tradeNo=tradeNo;
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
	public PayOrder setMerchantId(String merchantId) {
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
	public PayOrder setAppId(String appId) {
		this.appId=appId;
		return this;
	}
	
	/**
	 * 获得 商户订单<br>
	 * 商户订单
	 * @return 商户订单
	*/
	public String getMerchantOrderId() {
		return merchantOrderId;
	}
	
	/**
	 * 设置 商户订单
	 * @param merchantOrderId 商户订单
	 * @return 当前对象
	*/
	public PayOrder setMerchantOrderId(String merchantOrderId) {
		this.merchantOrderId=merchantOrderId;
		return this;
	}
	
	/**
	 * 获得 商品标题<br>
	 * 商品标题
	 * @return 商品标题
	*/
	public String getSubject() {
		return subject;
	}
	
	/**
	 * 设置 商品标题
	 * @param subject 商品标题
	 * @return 当前对象
	*/
	public PayOrder setSubject(String subject) {
		this.subject=subject;
		return this;
	}
	
	/**
	 * 获得 商品描述<br>
	 * 商品描述
	 * @return 商品描述
	*/
	public String getBody() {
		return body;
	}
	
	/**
	 * 设置 商品描述
	 * @param body 商品描述
	 * @return 当前对象
	*/
	public PayOrder setBody(String body) {
		this.body=body;
		return this;
	}
	
	/**
	 * 获得 异步通知地址<br>
	 * 异步通知地址
	 * @return 异步通知地址
	*/
	public String getNotifyUrl() {
		return notifyUrl;
	}
	
	/**
	 * 设置 异步通知地址
	 * @param notifyUrl 异步通知地址
	 * @return 当前对象
	*/
	public PayOrder setNotifyUrl(String notifyUrl) {
		this.notifyUrl=notifyUrl;
		return this;
	}
	
	/**
	 * 获得 回调状态<br>
	 * 通知商户支付结果的
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
	public PayOrder setNotifyStatus(String notifyStatus) {
		this.notifyStatus=notifyStatus;
		return this;
	}
	
	/**
	 * 获得 支付金额<br>
	 * 单位：分
	 * @return 支付金额
	*/
	public Long getAmount() {
		return amount;
	}
	
	/**
	 * 设置 支付金额
	 * @param amount 支付金额
	 * @return 当前对象
	*/
	public PayOrder setAmount(Long amount) {
		this.amount=amount;
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
	public PayOrder setUserIp(String userIp) {
		this.userIp=userIp;
		return this;
	}
	
	/**
	 * 获得 订单失效时间<br>
	 * 订单失效时间
	 * @return 订单失效时间
	*/
	public Date getExpireTime() {
		return expireTime;
	}
	
	/**
	 * 设置 订单失效时间
	 * @param expireTime 订单失效时间
	 * @return 当前对象
	*/
	public PayOrder setExpireTime(Date expireTime) {
		this.expireTime=expireTime;
		return this;
	}
	
	/**
	 * 获得 订单支付成功时间<br>
	 * 订单支付成功时间
	 * @return 订单支付成功时间
	*/
	public Date getSuccessTime() {
		return successTime;
	}
	
	/**
	 * 设置 订单支付成功时间
	 * @param successTime 订单支付成功时间
	 * @return 当前对象
	*/
	public PayOrder setSuccessTime(Date successTime) {
		this.successTime=successTime;
		return this;
	}
	
	/**
	 * 获得 订单支付通知时间<br>
	 * 订单支付通知时间
	 * @return 订单支付通知时间
	*/
	public Date getNotifyTime() {
		return notifyTime;
	}
	
	/**
	 * 设置 订单支付通知时间
	 * @param notifyTime 订单支付通知时间
	 * @return 当前对象
	*/
	public PayOrder setNotifyTime(Date notifyTime) {
		this.notifyTime=notifyTime;
		return this;
	}
	
	/**
	 * 获得 支付成功的订单拓展单编号<br>
	 * 支付成功的订单拓展单编号
	 * @return 支付成功的订单拓展单编号
	*/
	public String getSuccessExtensionId() {
		return successExtensionId;
	}
	
	/**
	 * 设置 支付成功的订单拓展单编号
	 * @param successExtensionId 支付成功的订单拓展单编号
	 * @return 当前对象
	*/
	public PayOrder setSuccessExtensionId(String successExtensionId) {
		this.successExtensionId=successExtensionId;
		return this;
	}
	
	/**
	 * 获得 退款状态<br>
	 * 退款状态
	 * @return 退款状态
	*/
	public String getRefundStatus() {
		return refundStatus;
	}
	
	/**
	 * 设置 退款状态
	 * @param refundStatus 退款状态
	 * @return 当前对象
	*/
	public PayOrder setRefundStatus(String refundStatus) {
		this.refundStatus=refundStatus;
		return this;
	}
	
	/**
	 * 获得 退款次数<br>
	 * 退款次数
	 * @return 退款次数
	*/
	public Integer getRefundTimes() {
		return refundTimes;
	}
	
	/**
	 * 设置 退款次数
	 * @param refundTimes 退款次数
	 * @return 当前对象
	*/
	public PayOrder setRefundTimes(Integer refundTimes) {
		this.refundTimes=refundTimes;
		return this;
	}
	
	/**
	 * 获得 退款总金额<br>
	 * 单位：分
	 * @return 退款总金额
	*/
	public Long getRefundAmount() {
		return refundAmount;
	}
	
	/**
	 * 设置 退款总金额
	 * @param refundAmount 退款总金额
	 * @return 当前对象
	*/
	public PayOrder setRefundAmount(Long refundAmount) {
		this.refundAmount=refundAmount;
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
	public PayOrder setChannelId(String channelId) {
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
	public PayOrder setChannelCode(String channelCode) {
		this.channelCode=channelCode;
		return this;
	}
	
	/**
	 * 获得 渠道用户<br>
	 * 渠道用户
	 * @return 渠道用户
	*/
	public String getChannelUserId() {
		return channelUserId;
	}
	
	/**
	 * 设置 渠道用户
	 * @param channelUserId 渠道用户
	 * @return 当前对象
	*/
	public PayOrder setChannelUserId(String channelUserId) {
		this.channelUserId=channelUserId;
		return this;
	}
	
	/**
	 * 获得 渠道手续费<br>
	 * 单位：百分比
	 * @return 渠道手续费
	*/
	public BigDecimal getChannelFeeRate() {
		return channelFeeRate;
	}
	
	/**
	 * 设置 渠道手续费
	 * @param channelFeeRate 渠道手续费
	 * @return 当前对象
	*/
	public PayOrder setChannelFeeRate(BigDecimal channelFeeRate) {
		this.channelFeeRate=channelFeeRate;
		return this;
	}
	
	/**
	 * 获得 渠道手续金额<br>
	 * 单位：分
	 * @return 渠道手续金额
	*/
	public Long getChannelFeeAmount() {
		return channelFeeAmount;
	}
	
	/**
	 * 设置 渠道手续金额
	 * @param channelFeeAmount 渠道手续金额
	 * @return 当前对象
	*/
	public PayOrder setChannelFeeAmount(Long channelFeeAmount) {
		this.channelFeeAmount=channelFeeAmount;
		return this;
	}
	
	/**
	 * 获得 渠道订单<br>
	 * 渠道订单
	 * @return 渠道订单
	*/
	public String getChannelOrderNo() {
		return channelOrderNo;
	}
	
	/**
	 * 设置 渠道订单
	 * @param channelOrderNo 渠道订单
	 * @return 当前对象
	*/
	public PayOrder setChannelOrderNo(String channelOrderNo) {
		this.channelOrderNo=channelOrderNo;
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
	public PayOrder setCreateBy(String createBy) {
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
	public PayOrder setCreateTime(Date createTime) {
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
	public PayOrder setUpdateBy(String updateBy) {
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
	public PayOrder setUpdateTime(Date updateTime) {
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
	public PayOrder setDeleted(Integer deleted) {
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
	public PayOrder setDeleted(Boolean deletedBool) {
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
	public PayOrder setDeleteBy(String deleteBy) {
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
	public PayOrder setDeleteTime(Date deleteTime) {
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
	public PayOrder setVersion(Integer version) {
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
	public PayOrder setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public PayOrder setPayChannel(PayChannel payChannel) {
		this.payChannel=payChannel;
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
	public PayOrder setPayApp(PayApp payApp) {
		this.payApp=payApp;
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
	public PayOrder setPayMerchant(PayMerchant payMerchant) {
		this.payMerchant=payMerchant;
		return this;
	}
	
	/**
	 * 获得 payOrderExt<br>
	 * payOrderExt
	 * @return payOrderExt
	*/
	public PayOrderExt getPayOrderExt() {
		return payOrderExt;
	}
	
	/**
	 * 设置 payOrderExt
	 * @param payOrderExt payOrderExt
	 * @return 当前对象
	*/
	public PayOrder setPayOrderExt(PayOrderExt payOrderExt) {
		this.payOrderExt=payOrderExt;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PayOrder , 转换好的 PayOrder 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PayOrder , 转换好的 PoJo 对象
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
	public PayOrder clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PayOrder duplicate(boolean all) {
		com.dt.platform.domain.common.meta.PayOrderMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.PayOrderMeta.$$proxy$$();
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
			inst.setPayApp(this.getPayApp());
			inst.setPayMerchant(this.getPayMerchant());
			inst.setPayChannel(this.getPayChannel());
			inst.setPayOrderExt(this.getPayOrderExt());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PayOrder clone(boolean deep) {
		return EntityContext.clone(PayOrder.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PayOrder
	 * @param payOrderMap 包含实体信息的 Map 对象
	 * @return PayOrder , 转换好的的 PayOrder 对象
	*/
	@Transient
	public static PayOrder createFrom(Map<String,Object> payOrderMap) {
		if(payOrderMap==null) return null;
		PayOrder po = create();
		EntityContext.copyProperties(po,payOrderMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PayOrder
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PayOrder , 转换好的的 PayOrder 对象
	*/
	@Transient
	public static PayOrder createFrom(Object pojo) {
		if(pojo==null) return null;
		PayOrder po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PayOrder，等同于 new
	 * @return PayOrder 对象
	*/
	@Transient
	public static PayOrder create() {
		return new com.dt.platform.domain.common.meta.PayOrderMeta.$$proxy$$();
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
			this.setSubject(DataParser.parse(String.class, map.get(PayOrderMeta.SUBJECT)));
			this.setNotifyStatus(DataParser.parse(String.class, map.get(PayOrderMeta.NOTIFY_STATUS)));
			this.setRefundStatus(DataParser.parse(String.class, map.get(PayOrderMeta.REFUND_STATUS)));
			this.setChannelOrderNo(DataParser.parse(String.class, map.get(PayOrderMeta.CHANNEL_ORDER_NO)));
			this.setMerchantOrderId(DataParser.parse(String.class, map.get(PayOrderMeta.MERCHANT_ORDER_ID)));
			this.setBody(DataParser.parse(String.class, map.get(PayOrderMeta.BODY)));
			this.setRefundTimes(DataParser.parse(Integer.class, map.get(PayOrderMeta.REFUND_TIMES)));
			this.setChannelFeeAmount(DataParser.parse(Long.class, map.get(PayOrderMeta.CHANNEL_FEE_AMOUNT)));
			this.setMerchantId(DataParser.parse(String.class, map.get(PayOrderMeta.MERCHANT_ID)));
			this.setChannelUserId(DataParser.parse(String.class, map.get(PayOrderMeta.CHANNEL_USER_ID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PayOrderMeta.UPDATE_BY)));
			this.setAppId(DataParser.parse(String.class, map.get(PayOrderMeta.APP_ID)));
			this.setSuccessTime(DataParser.parse(Date.class, map.get(PayOrderMeta.SUCCESS_TIME)));
			this.setId(DataParser.parse(String.class, map.get(PayOrderMeta.ID)));
			this.setChannelId(DataParser.parse(String.class, map.get(PayOrderMeta.CHANNEL_ID)));
			this.setSuccessExtensionId(DataParser.parse(String.class, map.get(PayOrderMeta.SUCCESS_EXTENSION_ID)));
			this.setRefundAmount(DataParser.parse(Long.class, map.get(PayOrderMeta.REFUND_AMOUNT)));
			this.setChannelCode(DataParser.parse(String.class, map.get(PayOrderMeta.CHANNEL_CODE)));
			this.setAmount(DataParser.parse(Long.class, map.get(PayOrderMeta.AMOUNT)));
			this.setTradeNo(DataParser.parse(String.class, map.get(PayOrderMeta.TRADE_NO)));
			this.setNotifyTime(DataParser.parse(Date.class, map.get(PayOrderMeta.NOTIFY_TIME)));
			this.setChannelFeeRate(DataParser.parse(BigDecimal.class, map.get(PayOrderMeta.CHANNEL_FEE_RATE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PayOrderMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PayOrderMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PayOrderMeta.CREATE_BY)));
			this.setExpireTime(DataParser.parse(Date.class, map.get(PayOrderMeta.EXPIRE_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PayOrderMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PayOrderMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PayOrderMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PayOrderMeta.TENANT_ID)));
			this.setNotifyUrl(DataParser.parse(String.class, map.get(PayOrderMeta.NOTIFY_URL)));
			this.setUserIp(DataParser.parse(String.class, map.get(PayOrderMeta.USER_IP)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PayOrderMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(Integer.class, map.get(PayOrderMeta.STATUS)));
			// others
			this.setPayApp(DataParser.parse(PayApp.class, map.get(PayOrderMeta.PAY_APP)));
			this.setPayMerchant(DataParser.parse(PayMerchant.class, map.get(PayOrderMeta.PAY_MERCHANT)));
			this.setPayChannel(DataParser.parse(PayChannel.class, map.get(PayOrderMeta.PAY_CHANNEL)));
			this.setPayOrderExt(DataParser.parse(PayOrderExt.class, map.get(PayOrderMeta.PAY_ORDER_EXT)));
			return true;
		} else {
			try {
				this.setSubject( (String)map.get(PayOrderMeta.SUBJECT));
				this.setNotifyStatus( (String)map.get(PayOrderMeta.NOTIFY_STATUS));
				this.setRefundStatus( (String)map.get(PayOrderMeta.REFUND_STATUS));
				this.setChannelOrderNo( (String)map.get(PayOrderMeta.CHANNEL_ORDER_NO));
				this.setMerchantOrderId( (String)map.get(PayOrderMeta.MERCHANT_ORDER_ID));
				this.setBody( (String)map.get(PayOrderMeta.BODY));
				this.setRefundTimes( (Integer)map.get(PayOrderMeta.REFUND_TIMES));
				this.setChannelFeeAmount( (Long)map.get(PayOrderMeta.CHANNEL_FEE_AMOUNT));
				this.setMerchantId( (String)map.get(PayOrderMeta.MERCHANT_ID));
				this.setChannelUserId( (String)map.get(PayOrderMeta.CHANNEL_USER_ID));
				this.setUpdateBy( (String)map.get(PayOrderMeta.UPDATE_BY));
				this.setAppId( (String)map.get(PayOrderMeta.APP_ID));
				this.setSuccessTime( (Date)map.get(PayOrderMeta.SUCCESS_TIME));
				this.setId( (String)map.get(PayOrderMeta.ID));
				this.setChannelId( (String)map.get(PayOrderMeta.CHANNEL_ID));
				this.setSuccessExtensionId( (String)map.get(PayOrderMeta.SUCCESS_EXTENSION_ID));
				this.setRefundAmount( (Long)map.get(PayOrderMeta.REFUND_AMOUNT));
				this.setChannelCode( (String)map.get(PayOrderMeta.CHANNEL_CODE));
				this.setAmount( (Long)map.get(PayOrderMeta.AMOUNT));
				this.setTradeNo( (String)map.get(PayOrderMeta.TRADE_NO));
				this.setNotifyTime( (Date)map.get(PayOrderMeta.NOTIFY_TIME));
				this.setChannelFeeRate( (BigDecimal)map.get(PayOrderMeta.CHANNEL_FEE_RATE));
				this.setUpdateTime( (Date)map.get(PayOrderMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PayOrderMeta.VERSION));
				this.setCreateBy( (String)map.get(PayOrderMeta.CREATE_BY));
				this.setExpireTime( (Date)map.get(PayOrderMeta.EXPIRE_TIME));
				this.setDeleted( (Integer)map.get(PayOrderMeta.DELETED));
				this.setCreateTime( (Date)map.get(PayOrderMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(PayOrderMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(PayOrderMeta.TENANT_ID));
				this.setNotifyUrl( (String)map.get(PayOrderMeta.NOTIFY_URL));
				this.setUserIp( (String)map.get(PayOrderMeta.USER_IP));
				this.setDeleteBy( (String)map.get(PayOrderMeta.DELETE_BY));
				this.setStatus( (Integer)map.get(PayOrderMeta.STATUS));
				// others
				this.setPayApp( (PayApp)map.get(PayOrderMeta.PAY_APP));
				this.setPayMerchant( (PayMerchant)map.get(PayOrderMeta.PAY_MERCHANT));
				this.setPayChannel( (PayChannel)map.get(PayOrderMeta.PAY_CHANNEL));
				this.setPayOrderExt( (PayOrderExt)map.get(PayOrderMeta.PAY_ORDER_EXT));
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
			this.setSubject(DataParser.parse(String.class, r.getValue(PayOrderMeta.SUBJECT)));
			this.setNotifyStatus(DataParser.parse(String.class, r.getValue(PayOrderMeta.NOTIFY_STATUS)));
			this.setRefundStatus(DataParser.parse(String.class, r.getValue(PayOrderMeta.REFUND_STATUS)));
			this.setChannelOrderNo(DataParser.parse(String.class, r.getValue(PayOrderMeta.CHANNEL_ORDER_NO)));
			this.setMerchantOrderId(DataParser.parse(String.class, r.getValue(PayOrderMeta.MERCHANT_ORDER_ID)));
			this.setBody(DataParser.parse(String.class, r.getValue(PayOrderMeta.BODY)));
			this.setRefundTimes(DataParser.parse(Integer.class, r.getValue(PayOrderMeta.REFUND_TIMES)));
			this.setChannelFeeAmount(DataParser.parse(Long.class, r.getValue(PayOrderMeta.CHANNEL_FEE_AMOUNT)));
			this.setMerchantId(DataParser.parse(String.class, r.getValue(PayOrderMeta.MERCHANT_ID)));
			this.setChannelUserId(DataParser.parse(String.class, r.getValue(PayOrderMeta.CHANNEL_USER_ID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PayOrderMeta.UPDATE_BY)));
			this.setAppId(DataParser.parse(String.class, r.getValue(PayOrderMeta.APP_ID)));
			this.setSuccessTime(DataParser.parse(Date.class, r.getValue(PayOrderMeta.SUCCESS_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(PayOrderMeta.ID)));
			this.setChannelId(DataParser.parse(String.class, r.getValue(PayOrderMeta.CHANNEL_ID)));
			this.setSuccessExtensionId(DataParser.parse(String.class, r.getValue(PayOrderMeta.SUCCESS_EXTENSION_ID)));
			this.setRefundAmount(DataParser.parse(Long.class, r.getValue(PayOrderMeta.REFUND_AMOUNT)));
			this.setChannelCode(DataParser.parse(String.class, r.getValue(PayOrderMeta.CHANNEL_CODE)));
			this.setAmount(DataParser.parse(Long.class, r.getValue(PayOrderMeta.AMOUNT)));
			this.setTradeNo(DataParser.parse(String.class, r.getValue(PayOrderMeta.TRADE_NO)));
			this.setNotifyTime(DataParser.parse(Date.class, r.getValue(PayOrderMeta.NOTIFY_TIME)));
			this.setChannelFeeRate(DataParser.parse(BigDecimal.class, r.getValue(PayOrderMeta.CHANNEL_FEE_RATE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PayOrderMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PayOrderMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PayOrderMeta.CREATE_BY)));
			this.setExpireTime(DataParser.parse(Date.class, r.getValue(PayOrderMeta.EXPIRE_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PayOrderMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PayOrderMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PayOrderMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PayOrderMeta.TENANT_ID)));
			this.setNotifyUrl(DataParser.parse(String.class, r.getValue(PayOrderMeta.NOTIFY_URL)));
			this.setUserIp(DataParser.parse(String.class, r.getValue(PayOrderMeta.USER_IP)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PayOrderMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(Integer.class, r.getValue(PayOrderMeta.STATUS)));
			return true;
		} else {
			try {
				this.setSubject( (String)r.getValue(PayOrderMeta.SUBJECT));
				this.setNotifyStatus( (String)r.getValue(PayOrderMeta.NOTIFY_STATUS));
				this.setRefundStatus( (String)r.getValue(PayOrderMeta.REFUND_STATUS));
				this.setChannelOrderNo( (String)r.getValue(PayOrderMeta.CHANNEL_ORDER_NO));
				this.setMerchantOrderId( (String)r.getValue(PayOrderMeta.MERCHANT_ORDER_ID));
				this.setBody( (String)r.getValue(PayOrderMeta.BODY));
				this.setRefundTimes( (Integer)r.getValue(PayOrderMeta.REFUND_TIMES));
				this.setChannelFeeAmount( (Long)r.getValue(PayOrderMeta.CHANNEL_FEE_AMOUNT));
				this.setMerchantId( (String)r.getValue(PayOrderMeta.MERCHANT_ID));
				this.setChannelUserId( (String)r.getValue(PayOrderMeta.CHANNEL_USER_ID));
				this.setUpdateBy( (String)r.getValue(PayOrderMeta.UPDATE_BY));
				this.setAppId( (String)r.getValue(PayOrderMeta.APP_ID));
				this.setSuccessTime( (Date)r.getValue(PayOrderMeta.SUCCESS_TIME));
				this.setId( (String)r.getValue(PayOrderMeta.ID));
				this.setChannelId( (String)r.getValue(PayOrderMeta.CHANNEL_ID));
				this.setSuccessExtensionId( (String)r.getValue(PayOrderMeta.SUCCESS_EXTENSION_ID));
				this.setRefundAmount( (Long)r.getValue(PayOrderMeta.REFUND_AMOUNT));
				this.setChannelCode( (String)r.getValue(PayOrderMeta.CHANNEL_CODE));
				this.setAmount( (Long)r.getValue(PayOrderMeta.AMOUNT));
				this.setTradeNo( (String)r.getValue(PayOrderMeta.TRADE_NO));
				this.setNotifyTime( (Date)r.getValue(PayOrderMeta.NOTIFY_TIME));
				this.setChannelFeeRate( (BigDecimal)r.getValue(PayOrderMeta.CHANNEL_FEE_RATE));
				this.setUpdateTime( (Date)r.getValue(PayOrderMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PayOrderMeta.VERSION));
				this.setCreateBy( (String)r.getValue(PayOrderMeta.CREATE_BY));
				this.setExpireTime( (Date)r.getValue(PayOrderMeta.EXPIRE_TIME));
				this.setDeleted( (Integer)r.getValue(PayOrderMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PayOrderMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(PayOrderMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(PayOrderMeta.TENANT_ID));
				this.setNotifyUrl( (String)r.getValue(PayOrderMeta.NOTIFY_URL));
				this.setUserIp( (String)r.getValue(PayOrderMeta.USER_IP));
				this.setDeleteBy( (String)r.getValue(PayOrderMeta.DELETE_BY));
				this.setStatus( (Integer)r.getValue(PayOrderMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}