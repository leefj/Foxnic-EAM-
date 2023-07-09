package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.PayApp;
import java.util.Date;
import com.dt.platform.domain.common.PayMerchant;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 11:38:06
 * @sign 2CFB687AF1FEA1AF17A2E2C7C9F2D55D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PayAppMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayApp,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayApp.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 应用编号 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 应用编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayApp,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.common.PayApp.class ,CODE, java.lang.String.class, "应用编号", "应用编号", java.lang.String.class, null);
	
	/**
	 * 应用名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 应用名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayApp,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.common.PayApp.class ,NAME, java.lang.String.class, "应用名称", "应用名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayApp,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.PayApp.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 支付结果回调 , 类型: java.lang.String
	*/
	public static final String PAY_NOTIFY_URL="payNotifyUrl";
	
	/**
	 * 支付结果回调 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayApp,java.lang.String> PAY_NOTIFY_URL_PROP = new BeanProperty(com.dt.platform.domain.common.PayApp.class ,PAY_NOTIFY_URL, java.lang.String.class, "支付结果回调", "支付结果回调", java.lang.String.class, null);
	
	/**
	 * 退款结果回调 , 类型: java.lang.String
	*/
	public static final String REFUND_NOTIFY_URL="refundNotifyUrl";
	
	/**
	 * 退款结果回调 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayApp,java.lang.String> REFUND_NOTIFY_URL_PROP = new BeanProperty(com.dt.platform.domain.common.PayApp.class ,REFUND_NOTIFY_URL, java.lang.String.class, "退款结果回调", "退款结果回调", java.lang.String.class, null);
	
	/**
	 * 商户 , 类型: java.lang.String
	*/
	public static final String MERCHANT_ID="merchantId";
	
	/**
	 * 商户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayApp,java.lang.String> MERCHANT_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayApp.class ,MERCHANT_ID, java.lang.String.class, "商户", "商户", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayApp,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.common.PayApp.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayApp,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayApp.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayApp,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayApp.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayApp,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayApp.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayApp,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayApp.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayApp,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.PayApp.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayApp,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.PayApp.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayApp,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.PayApp.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayApp,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.PayApp.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayApp,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.common.PayApp.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * payMerchant , 类型: com.dt.platform.domain.common.PayMerchant
	*/
	public static final String PAY_MERCHANT="payMerchant";
	
	/**
	 * payMerchant , 类型: com.dt.platform.domain.common.PayMerchant
	*/
	public static final BeanProperty<com.dt.platform.domain.common.PayApp,com.dt.platform.domain.common.PayMerchant> PAY_MERCHANT_PROP = new BeanProperty(com.dt.platform.domain.common.PayApp.class ,PAY_MERCHANT, com.dt.platform.domain.common.PayMerchant.class, "payMerchant", "payMerchant", com.dt.platform.domain.common.PayMerchant.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , NAME , STATUS , PAY_NOTIFY_URL , REFUND_NOTIFY_URL , MERCHANT_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PAY_MERCHANT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.PayApp {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PayApp setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 应用编号
		 * @param code 应用编号
		 * @return 当前对象
		*/
		public PayApp setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 应用名称
		 * @param name 应用名称
		 * @return 当前对象
		*/
		public PayApp setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public PayApp setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 支付结果回调
		 * @param payNotifyUrl 支付结果回调
		 * @return 当前对象
		*/
		public PayApp setPayNotifyUrl(String payNotifyUrl) {
			super.change(PAY_NOTIFY_URL,super.getPayNotifyUrl(),payNotifyUrl);
			super.setPayNotifyUrl(payNotifyUrl);
			return this;
		}
		
		/**
		 * 设置 退款结果回调
		 * @param refundNotifyUrl 退款结果回调
		 * @return 当前对象
		*/
		public PayApp setRefundNotifyUrl(String refundNotifyUrl) {
			super.change(REFUND_NOTIFY_URL,super.getRefundNotifyUrl(),refundNotifyUrl);
			super.setRefundNotifyUrl(refundNotifyUrl);
			return this;
		}
		
		/**
		 * 设置 商户
		 * @param merchantId 商户
		 * @return 当前对象
		*/
		public PayApp setMerchantId(String merchantId) {
			super.change(MERCHANT_ID,super.getMerchantId(),merchantId);
			super.setMerchantId(merchantId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public PayApp setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PayApp setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PayApp setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PayApp setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PayApp setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PayApp setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PayApp setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PayApp setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PayApp setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public PayApp setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 payMerchant
		 * @param payMerchant payMerchant
		 * @return 当前对象
		*/
		public PayApp setPayMerchant(PayMerchant payMerchant) {
			super.change(PAY_MERCHANT,super.getPayMerchant(),payMerchant);
			super.setPayMerchant(payMerchant);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PayApp clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PayApp duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCode(this.getCode());
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setRefundNotifyUrl(this.getRefundNotifyUrl());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setMerchantId(this.getMerchantId());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setPayNotifyUrl(this.getPayNotifyUrl());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setPayMerchant(this.getPayMerchant());
			}
			inst.clearModifies();
			return inst;
		}

	}
}