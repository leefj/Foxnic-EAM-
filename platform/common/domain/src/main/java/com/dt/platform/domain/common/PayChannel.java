package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_PAY_CHANNEL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.PayChannelMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 支付渠道
 * <p>支付渠道 , 数据表 sys_pay_channel 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 11:37:37
 * @sign 498255D925432C82029673E56C959BAD
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_pay_channel")
@ApiModel(description = "支付渠道 ; 支付渠道 , 数据表 sys_pay_channel 的PO类型")
public class PayChannel extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_PAY_CHANNEL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 商户：商户
	*/
	@ApiModelProperty(required = false,value="商户" , notes = "商户")
	private String merchantId;
	
	/**
	 * 应用：应用
	*/
	@ApiModelProperty(required = false,value="应用" , notes = "应用")
	private String appId;
	
	/**
	 * 渠道编码：渠道编码
	*/
	@ApiModelProperty(required = false,value="渠道编码" , notes = "渠道编码")
	private String code;
	
	/**
	 * 渠道名称：渠道名称
	*/
	@ApiModelProperty(required = false,value="渠道名称" , notes = "渠道名称")
	private String name;
	
	/**
	 * 渠道费率：渠道费率
	*/
	@ApiModelProperty(required = false,value="渠道费率" , notes = "渠道费率")
	private BigDecimal feeRate;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 配置：配置
	*/
	@ApiModelProperty(required = false,value="配置" , notes = "配置")
	private String config;
	
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
	 * payApp：payApp
	*/
	@ApiModelProperty(required = false,value="payApp" , notes = "payApp")
	private PayApp payApp;
	
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
	public PayChannel setId(String id) {
		this.id=id;
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
	public PayChannel setMerchantId(String merchantId) {
		this.merchantId=merchantId;
		return this;
	}
	
	/**
	 * 获得 应用<br>
	 * 应用
	 * @return 应用
	*/
	public String getAppId() {
		return appId;
	}
	
	/**
	 * 设置 应用
	 * @param appId 应用
	 * @return 当前对象
	*/
	public PayChannel setAppId(String appId) {
		this.appId=appId;
		return this;
	}
	
	/**
	 * 获得 渠道编码<br>
	 * 渠道编码
	 * @return 渠道编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 渠道编码
	 * @param code 渠道编码
	 * @return 当前对象
	*/
	public PayChannel setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 渠道名称<br>
	 * 渠道名称
	 * @return 渠道名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 渠道名称
	 * @param name 渠道名称
	 * @return 当前对象
	*/
	public PayChannel setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 渠道费率<br>
	 * 渠道费率
	 * @return 渠道费率
	*/
	public BigDecimal getFeeRate() {
		return feeRate;
	}
	
	/**
	 * 设置 渠道费率
	 * @param feeRate 渠道费率
	 * @return 当前对象
	*/
	public PayChannel setFeeRate(BigDecimal feeRate) {
		this.feeRate=feeRate;
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
	public PayChannel setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 配置<br>
	 * 配置
	 * @return 配置
	*/
	public String getConfig() {
		return config;
	}
	
	/**
	 * 设置 配置
	 * @param config 配置
	 * @return 当前对象
	*/
	public PayChannel setConfig(String config) {
		this.config=config;
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
	public PayChannel setNotes(String notes) {
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
	public PayChannel setCreateBy(String createBy) {
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
	public PayChannel setCreateTime(Date createTime) {
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
	public PayChannel setUpdateBy(String updateBy) {
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
	public PayChannel setUpdateTime(Date updateTime) {
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
	public PayChannel setDeleted(Integer deleted) {
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
	public PayChannel setDeleted(Boolean deletedBool) {
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
	public PayChannel setDeleteBy(String deleteBy) {
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
	public PayChannel setDeleteTime(Date deleteTime) {
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
	public PayChannel setVersion(Integer version) {
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
	public PayChannel setTenantId(String tenantId) {
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
	public PayChannel setPayMerchant(PayMerchant payMerchant) {
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
	public PayChannel setPayApp(PayApp payApp) {
		this.payApp=payApp;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PayChannel , 转换好的 PayChannel 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PayChannel , 转换好的 PoJo 对象
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
	public PayChannel clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PayChannel duplicate(boolean all) {
		com.dt.platform.domain.common.meta.PayChannelMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.PayChannelMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setFeeRate(this.getFeeRate());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setMerchantId(this.getMerchantId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAppId(this.getAppId());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setConfig(this.getConfig());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setPayApp(this.getPayApp());
			inst.setPayMerchant(this.getPayMerchant());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PayChannel clone(boolean deep) {
		return EntityContext.clone(PayChannel.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PayChannel
	 * @param payChannelMap 包含实体信息的 Map 对象
	 * @return PayChannel , 转换好的的 PayChannel 对象
	*/
	@Transient
	public static PayChannel createFrom(Map<String,Object> payChannelMap) {
		if(payChannelMap==null) return null;
		PayChannel po = create();
		EntityContext.copyProperties(po,payChannelMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PayChannel
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PayChannel , 转换好的的 PayChannel 对象
	*/
	@Transient
	public static PayChannel createFrom(Object pojo) {
		if(pojo==null) return null;
		PayChannel po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PayChannel，等同于 new
	 * @return PayChannel 对象
	*/
	@Transient
	public static PayChannel create() {
		return new com.dt.platform.domain.common.meta.PayChannelMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(PayChannelMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(PayChannelMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PayChannelMeta.UPDATE_TIME)));
			this.setFeeRate(DataParser.parse(BigDecimal.class, map.get(PayChannelMeta.FEE_RATE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PayChannelMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PayChannelMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PayChannelMeta.DELETED)));
			this.setMerchantId(DataParser.parse(String.class, map.get(PayChannelMeta.MERCHANT_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PayChannelMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PayChannelMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PayChannelMeta.DELETE_TIME)));
			this.setAppId(DataParser.parse(String.class, map.get(PayChannelMeta.APP_ID)));
			this.setName(DataParser.parse(String.class, map.get(PayChannelMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PayChannelMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PayChannelMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PayChannelMeta.ID)));
			this.setConfig(DataParser.parse(String.class, map.get(PayChannelMeta.CONFIG)));
			this.setStatus(DataParser.parse(String.class, map.get(PayChannelMeta.STATUS)));
			// others
			this.setPayApp(DataParser.parse(PayApp.class, map.get(PayChannelMeta.PAY_APP)));
			this.setPayMerchant(DataParser.parse(PayMerchant.class, map.get(PayChannelMeta.PAY_MERCHANT)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(PayChannelMeta.CODE));
				this.setNotes( (String)map.get(PayChannelMeta.NOTES));
				this.setUpdateTime( (Date)map.get(PayChannelMeta.UPDATE_TIME));
				this.setFeeRate( (BigDecimal)map.get(PayChannelMeta.FEE_RATE));
				this.setVersion( (Integer)map.get(PayChannelMeta.VERSION));
				this.setCreateBy( (String)map.get(PayChannelMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PayChannelMeta.DELETED));
				this.setMerchantId( (String)map.get(PayChannelMeta.MERCHANT_ID));
				this.setCreateTime( (Date)map.get(PayChannelMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PayChannelMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PayChannelMeta.DELETE_TIME));
				this.setAppId( (String)map.get(PayChannelMeta.APP_ID));
				this.setName( (String)map.get(PayChannelMeta.NAME));
				this.setTenantId( (String)map.get(PayChannelMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PayChannelMeta.DELETE_BY));
				this.setId( (String)map.get(PayChannelMeta.ID));
				this.setConfig( (String)map.get(PayChannelMeta.CONFIG));
				this.setStatus( (String)map.get(PayChannelMeta.STATUS));
				// others
				this.setPayApp( (PayApp)map.get(PayChannelMeta.PAY_APP));
				this.setPayMerchant( (PayMerchant)map.get(PayChannelMeta.PAY_MERCHANT));
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
			this.setCode(DataParser.parse(String.class, r.getValue(PayChannelMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(PayChannelMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PayChannelMeta.UPDATE_TIME)));
			this.setFeeRate(DataParser.parse(BigDecimal.class, r.getValue(PayChannelMeta.FEE_RATE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PayChannelMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PayChannelMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PayChannelMeta.DELETED)));
			this.setMerchantId(DataParser.parse(String.class, r.getValue(PayChannelMeta.MERCHANT_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PayChannelMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PayChannelMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PayChannelMeta.DELETE_TIME)));
			this.setAppId(DataParser.parse(String.class, r.getValue(PayChannelMeta.APP_ID)));
			this.setName(DataParser.parse(String.class, r.getValue(PayChannelMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PayChannelMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PayChannelMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PayChannelMeta.ID)));
			this.setConfig(DataParser.parse(String.class, r.getValue(PayChannelMeta.CONFIG)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PayChannelMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(PayChannelMeta.CODE));
				this.setNotes( (String)r.getValue(PayChannelMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(PayChannelMeta.UPDATE_TIME));
				this.setFeeRate( (BigDecimal)r.getValue(PayChannelMeta.FEE_RATE));
				this.setVersion( (Integer)r.getValue(PayChannelMeta.VERSION));
				this.setCreateBy( (String)r.getValue(PayChannelMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PayChannelMeta.DELETED));
				this.setMerchantId( (String)r.getValue(PayChannelMeta.MERCHANT_ID));
				this.setCreateTime( (Date)r.getValue(PayChannelMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PayChannelMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PayChannelMeta.DELETE_TIME));
				this.setAppId( (String)r.getValue(PayChannelMeta.APP_ID));
				this.setName( (String)r.getValue(PayChannelMeta.NAME));
				this.setTenantId( (String)r.getValue(PayChannelMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PayChannelMeta.DELETE_BY));
				this.setId( (String)r.getValue(PayChannelMeta.ID));
				this.setConfig( (String)r.getValue(PayChannelMeta.CONFIG));
				this.setStatus( (String)r.getValue(PayChannelMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}