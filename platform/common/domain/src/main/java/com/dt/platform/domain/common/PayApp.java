package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_PAY_APP;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.PayAppMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 应用
 * <p>应用 , 数据表 sys_pay_app 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 11:38:06
 * @sign 2CFB687AF1FEA1AF17A2E2C7C9F2D55D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_pay_app")
@ApiModel(description = "应用 ; 应用 , 数据表 sys_pay_app 的PO类型")
public class PayApp extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_PAY_APP.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 应用编号：应用编号
	*/
	@ApiModelProperty(required = false,value="应用编号" , notes = "应用编号")
	private String code;
	
	/**
	 * 应用名称：应用名称
	*/
	@ApiModelProperty(required = false,value="应用名称" , notes = "应用名称")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 支付结果回调：支付结果回调
	*/
	@ApiModelProperty(required = false,value="支付结果回调" , notes = "支付结果回调")
	private String payNotifyUrl;
	
	/**
	 * 退款结果回调：退款结果回调
	*/
	@ApiModelProperty(required = false,value="退款结果回调" , notes = "退款结果回调")
	private String refundNotifyUrl;
	
	/**
	 * 商户：商户
	*/
	@ApiModelProperty(required = false,value="商户" , notes = "商户")
	private String merchantId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	public PayApp setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 应用编号<br>
	 * 应用编号
	 * @return 应用编号
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 应用编号
	 * @param code 应用编号
	 * @return 当前对象
	*/
	public PayApp setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 应用名称<br>
	 * 应用名称
	 * @return 应用名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 应用名称
	 * @param name 应用名称
	 * @return 当前对象
	*/
	public PayApp setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public PayApp setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 支付结果回调<br>
	 * 支付结果回调
	 * @return 支付结果回调
	*/
	public String getPayNotifyUrl() {
		return payNotifyUrl;
	}
	
	/**
	 * 设置 支付结果回调
	 * @param payNotifyUrl 支付结果回调
	 * @return 当前对象
	*/
	public PayApp setPayNotifyUrl(String payNotifyUrl) {
		this.payNotifyUrl=payNotifyUrl;
		return this;
	}
	
	/**
	 * 获得 退款结果回调<br>
	 * 退款结果回调
	 * @return 退款结果回调
	*/
	public String getRefundNotifyUrl() {
		return refundNotifyUrl;
	}
	
	/**
	 * 设置 退款结果回调
	 * @param refundNotifyUrl 退款结果回调
	 * @return 当前对象
	*/
	public PayApp setRefundNotifyUrl(String refundNotifyUrl) {
		this.refundNotifyUrl=refundNotifyUrl;
		return this;
	}
	
	/**
	 * 获得 商户<br>
	 * 商户
	 * @return 商户
	*/
	public String getMerchantId() {
		return merchantId;
	}
	
	/**
	 * 设置 商户
	 * @param merchantId 商户
	 * @return 当前对象
	*/
	public PayApp setMerchantId(String merchantId) {
		this.merchantId=merchantId;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public PayApp setNotes(String notes) {
		this.notes=notes;
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
	public PayApp setCreateBy(String createBy) {
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
	public PayApp setCreateTime(Date createTime) {
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
	public PayApp setUpdateBy(String updateBy) {
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
	public PayApp setUpdateTime(Date updateTime) {
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
	public PayApp setDeleted(Integer deleted) {
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
	public PayApp setDeleted(Boolean deletedBool) {
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
	public PayApp setDeleteBy(String deleteBy) {
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
	public PayApp setDeleteTime(Date deleteTime) {
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
	public PayApp setVersion(Integer version) {
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
	public PayApp setTenantId(String tenantId) {
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
	public PayApp setPayMerchant(PayMerchant payMerchant) {
		this.payMerchant=payMerchant;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PayApp , 转换好的 PayApp 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PayApp , 转换好的 PoJo 对象
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
	public PayApp clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PayApp duplicate(boolean all) {
		com.dt.platform.domain.common.meta.PayAppMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.PayAppMeta.$$proxy$$();
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

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PayApp clone(boolean deep) {
		return EntityContext.clone(PayApp.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PayApp
	 * @param payAppMap 包含实体信息的 Map 对象
	 * @return PayApp , 转换好的的 PayApp 对象
	*/
	@Transient
	public static PayApp createFrom(Map<String,Object> payAppMap) {
		if(payAppMap==null) return null;
		PayApp po = create();
		EntityContext.copyProperties(po,payAppMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PayApp
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PayApp , 转换好的的 PayApp 对象
	*/
	@Transient
	public static PayApp createFrom(Object pojo) {
		if(pojo==null) return null;
		PayApp po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PayApp，等同于 new
	 * @return PayApp 对象
	*/
	@Transient
	public static PayApp create() {
		return new com.dt.platform.domain.common.meta.PayAppMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(PayAppMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(PayAppMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PayAppMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PayAppMeta.VERSION)));
			this.setRefundNotifyUrl(DataParser.parse(String.class, map.get(PayAppMeta.REFUND_NOTIFY_URL)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PayAppMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PayAppMeta.DELETED)));
			this.setMerchantId(DataParser.parse(String.class, map.get(PayAppMeta.MERCHANT_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PayAppMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PayAppMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PayAppMeta.DELETE_TIME)));
			this.setPayNotifyUrl(DataParser.parse(String.class, map.get(PayAppMeta.PAY_NOTIFY_URL)));
			this.setName(DataParser.parse(String.class, map.get(PayAppMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PayAppMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PayAppMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PayAppMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(PayAppMeta.STATUS)));
			// others
			this.setPayMerchant(DataParser.parse(PayMerchant.class, map.get(PayAppMeta.PAY_MERCHANT)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(PayAppMeta.CODE));
				this.setNotes( (String)map.get(PayAppMeta.NOTES));
				this.setUpdateTime( (Date)map.get(PayAppMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PayAppMeta.VERSION));
				this.setRefundNotifyUrl( (String)map.get(PayAppMeta.REFUND_NOTIFY_URL));
				this.setCreateBy( (String)map.get(PayAppMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PayAppMeta.DELETED));
				this.setMerchantId( (String)map.get(PayAppMeta.MERCHANT_ID));
				this.setCreateTime( (Date)map.get(PayAppMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PayAppMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PayAppMeta.DELETE_TIME));
				this.setPayNotifyUrl( (String)map.get(PayAppMeta.PAY_NOTIFY_URL));
				this.setName( (String)map.get(PayAppMeta.NAME));
				this.setTenantId( (String)map.get(PayAppMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PayAppMeta.DELETE_BY));
				this.setId( (String)map.get(PayAppMeta.ID));
				this.setStatus( (String)map.get(PayAppMeta.STATUS));
				// others
				this.setPayMerchant( (PayMerchant)map.get(PayAppMeta.PAY_MERCHANT));
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
			this.setCode(DataParser.parse(String.class, r.getValue(PayAppMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(PayAppMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PayAppMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PayAppMeta.VERSION)));
			this.setRefundNotifyUrl(DataParser.parse(String.class, r.getValue(PayAppMeta.REFUND_NOTIFY_URL)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PayAppMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PayAppMeta.DELETED)));
			this.setMerchantId(DataParser.parse(String.class, r.getValue(PayAppMeta.MERCHANT_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PayAppMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PayAppMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PayAppMeta.DELETE_TIME)));
			this.setPayNotifyUrl(DataParser.parse(String.class, r.getValue(PayAppMeta.PAY_NOTIFY_URL)));
			this.setName(DataParser.parse(String.class, r.getValue(PayAppMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PayAppMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PayAppMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PayAppMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PayAppMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(PayAppMeta.CODE));
				this.setNotes( (String)r.getValue(PayAppMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(PayAppMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PayAppMeta.VERSION));
				this.setRefundNotifyUrl( (String)r.getValue(PayAppMeta.REFUND_NOTIFY_URL));
				this.setCreateBy( (String)r.getValue(PayAppMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PayAppMeta.DELETED));
				this.setMerchantId( (String)r.getValue(PayAppMeta.MERCHANT_ID));
				this.setCreateTime( (Date)r.getValue(PayAppMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PayAppMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PayAppMeta.DELETE_TIME));
				this.setPayNotifyUrl( (String)r.getValue(PayAppMeta.PAY_NOTIFY_URL));
				this.setName( (String)r.getValue(PayAppMeta.NAME));
				this.setTenantId( (String)r.getValue(PayAppMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PayAppMeta.DELETE_BY));
				this.setId( (String)r.getValue(PayAppMeta.ID));
				this.setStatus( (String)r.getValue(PayAppMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}