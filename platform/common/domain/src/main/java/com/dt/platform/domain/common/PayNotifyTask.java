package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_PAY_NOTIFY_TASK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.PayNotifyTaskMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 任务通知
 * <p>任务通知 , 数据表 sys_pay_notify_task 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 14:01:10
 * @sign 7AB9212ADEF032250F56472BB5C7A7F2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_pay_notify_task")
@ApiModel(description = "任务通知 ; 任务通知 , 数据表 sys_pay_notify_task 的PO类型")
public class PayNotifyTask extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_PAY_NOTIFY_TASK.$TABLE;
	
	/**
	 * 任务编号：任务编号
	*/
	@Id
	@ApiModelProperty(required = true,value="任务编号" , notes = "任务编号")
	private String id;
	
	/**
	 * 通知状态：通知状态
	*/
	@ApiModelProperty(required = true,value="通知状态" , notes = "通知状态")
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
	 * 通知类型：通知类型
	*/
	@ApiModelProperty(required = true,value="通知类型" , notes = "通知类型")
	private String type;
	
	/**
	 * 数据编号：数据编号
	*/
	@ApiModelProperty(required = true,value="数据编号" , notes = "数据编号")
	private String dataId;
	
	/**
	 * 商户订单编号：商户订单编号
	*/
	@ApiModelProperty(required = true,value="商户订单编号" , notes = "商户订单编号")
	private String merchantOrderId;
	
	/**
	 * 下一次通知时间：下一次通知时间
	*/
	@ApiModelProperty(required = true,value="下一次通知时间" , notes = "下一次通知时间")
	private Date nextNotifyTime;
	
	/**
	 * 最后一次执行时间：最后一次执行时间
	*/
	@ApiModelProperty(required = true,value="最后一次执行时间" , notes = "最后一次执行时间")
	private Date lastExecuteTime;
	
	/**
	 * 当前通知次数：当前通知次数
	*/
	@ApiModelProperty(required = true,value="当前通知次数" , notes = "当前通知次数")
	private Integer notifyTimes;
	
	/**
	 * 最大可通知次数：最大可通知次数
	*/
	@ApiModelProperty(required = true,value="最大可通知次数" , notes = "最大可通知次数")
	private Integer maxNotifyTimes;
	
	/**
	 * 异步通知地址：异步通知地址
	*/
	@ApiModelProperty(required = true,value="异步通知地址" , notes = "异步通知地址")
	private String notifyUrl;
	
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
	 * 获得 任务编号<br>
	 * 任务编号
	 * @return 任务编号
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 任务编号
	 * @param id 任务编号
	 * @return 当前对象
	*/
	public PayNotifyTask setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 通知状态<br>
	 * 通知状态
	 * @return 通知状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 通知状态
	 * @param status 通知状态
	 * @return 当前对象
	*/
	public PayNotifyTask setStatus(String status) {
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
	public PayNotifyTask setMerchantId(String merchantId) {
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
	public PayNotifyTask setAppId(String appId) {
		this.appId=appId;
		return this;
	}
	
	/**
	 * 获得 通知类型<br>
	 * 通知类型
	 * @return 通知类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 通知类型
	 * @param type 通知类型
	 * @return 当前对象
	*/
	public PayNotifyTask setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 数据编号<br>
	 * 数据编号
	 * @return 数据编号
	*/
	public String getDataId() {
		return dataId;
	}
	
	/**
	 * 设置 数据编号
	 * @param dataId 数据编号
	 * @return 当前对象
	*/
	public PayNotifyTask setDataId(String dataId) {
		this.dataId=dataId;
		return this;
	}
	
	/**
	 * 获得 商户订单编号<br>
	 * 商户订单编号
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
	public PayNotifyTask setMerchantOrderId(String merchantOrderId) {
		this.merchantOrderId=merchantOrderId;
		return this;
	}
	
	/**
	 * 获得 下一次通知时间<br>
	 * 下一次通知时间
	 * @return 下一次通知时间
	*/
	public Date getNextNotifyTime() {
		return nextNotifyTime;
	}
	
	/**
	 * 设置 下一次通知时间
	 * @param nextNotifyTime 下一次通知时间
	 * @return 当前对象
	*/
	public PayNotifyTask setNextNotifyTime(Date nextNotifyTime) {
		this.nextNotifyTime=nextNotifyTime;
		return this;
	}
	
	/**
	 * 获得 最后一次执行时间<br>
	 * 最后一次执行时间
	 * @return 最后一次执行时间
	*/
	public Date getLastExecuteTime() {
		return lastExecuteTime;
	}
	
	/**
	 * 设置 最后一次执行时间
	 * @param lastExecuteTime 最后一次执行时间
	 * @return 当前对象
	*/
	public PayNotifyTask setLastExecuteTime(Date lastExecuteTime) {
		this.lastExecuteTime=lastExecuteTime;
		return this;
	}
	
	/**
	 * 获得 当前通知次数<br>
	 * 当前通知次数
	 * @return 当前通知次数
	*/
	public Integer getNotifyTimes() {
		return notifyTimes;
	}
	
	/**
	 * 设置 当前通知次数
	 * @param notifyTimes 当前通知次数
	 * @return 当前对象
	*/
	public PayNotifyTask setNotifyTimes(Integer notifyTimes) {
		this.notifyTimes=notifyTimes;
		return this;
	}
	
	/**
	 * 获得 最大可通知次数<br>
	 * 最大可通知次数
	 * @return 最大可通知次数
	*/
	public Integer getMaxNotifyTimes() {
		return maxNotifyTimes;
	}
	
	/**
	 * 设置 最大可通知次数
	 * @param maxNotifyTimes 最大可通知次数
	 * @return 当前对象
	*/
	public PayNotifyTask setMaxNotifyTimes(Integer maxNotifyTimes) {
		this.maxNotifyTimes=maxNotifyTimes;
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
	public PayNotifyTask setNotifyUrl(String notifyUrl) {
		this.notifyUrl=notifyUrl;
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
	public PayNotifyTask setCreateBy(String createBy) {
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
	public PayNotifyTask setCreateTime(Date createTime) {
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
	public PayNotifyTask setUpdateBy(String updateBy) {
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
	public PayNotifyTask setUpdateTime(Date updateTime) {
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
	public PayNotifyTask setDeleted(Integer deleted) {
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
	public PayNotifyTask setDeleted(Boolean deletedBool) {
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
	public PayNotifyTask setDeleteBy(String deleteBy) {
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
	public PayNotifyTask setDeleteTime(Date deleteTime) {
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
	public PayNotifyTask setVersion(Integer version) {
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
	public PayNotifyTask setTenantId(String tenantId) {
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
	public PayNotifyTask setPayMerchant(PayMerchant payMerchant) {
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
	public PayNotifyTask setPayApp(PayApp payApp) {
		this.payApp=payApp;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PayNotifyTask , 转换好的 PayNotifyTask 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PayNotifyTask , 转换好的 PoJo 对象
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
	public PayNotifyTask clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PayNotifyTask duplicate(boolean all) {
		com.dt.platform.domain.common.meta.PayNotifyTaskMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.PayNotifyTaskMeta.$$proxy$$();
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

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PayNotifyTask clone(boolean deep) {
		return EntityContext.clone(PayNotifyTask.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PayNotifyTask
	 * @param payNotifyTaskMap 包含实体信息的 Map 对象
	 * @return PayNotifyTask , 转换好的的 PayNotifyTask 对象
	*/
	@Transient
	public static PayNotifyTask createFrom(Map<String,Object> payNotifyTaskMap) {
		if(payNotifyTaskMap==null) return null;
		PayNotifyTask po = create();
		EntityContext.copyProperties(po,payNotifyTaskMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PayNotifyTask
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PayNotifyTask , 转换好的的 PayNotifyTask 对象
	*/
	@Transient
	public static PayNotifyTask createFrom(Object pojo) {
		if(pojo==null) return null;
		PayNotifyTask po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PayNotifyTask，等同于 new
	 * @return PayNotifyTask 对象
	*/
	@Transient
	public static PayNotifyTask create() {
		return new com.dt.platform.domain.common.meta.PayNotifyTaskMeta.$$proxy$$();
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
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PayNotifyTaskMeta.UPDATE_TIME)));
			this.setMerchantOrderId(DataParser.parse(String.class, map.get(PayNotifyTaskMeta.MERCHANT_ORDER_ID)));
			this.setType(DataParser.parse(String.class, map.get(PayNotifyTaskMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PayNotifyTaskMeta.VERSION)));
			this.setNextNotifyTime(DataParser.parse(Date.class, map.get(PayNotifyTaskMeta.NEXT_NOTIFY_TIME)));
			this.setLastExecuteTime(DataParser.parse(Date.class, map.get(PayNotifyTaskMeta.LAST_EXECUTE_TIME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PayNotifyTaskMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PayNotifyTaskMeta.DELETED)));
			this.setDataId(DataParser.parse(String.class, map.get(PayNotifyTaskMeta.DATA_ID)));
			this.setMerchantId(DataParser.parse(String.class, map.get(PayNotifyTaskMeta.MERCHANT_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PayNotifyTaskMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PayNotifyTaskMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PayNotifyTaskMeta.DELETE_TIME)));
			this.setAppId(DataParser.parse(String.class, map.get(PayNotifyTaskMeta.APP_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(PayNotifyTaskMeta.TENANT_ID)));
			this.setNotifyUrl(DataParser.parse(String.class, map.get(PayNotifyTaskMeta.NOTIFY_URL)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PayNotifyTaskMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PayNotifyTaskMeta.ID)));
			this.setNotifyTimes(DataParser.parse(Integer.class, map.get(PayNotifyTaskMeta.NOTIFY_TIMES)));
			this.setMaxNotifyTimes(DataParser.parse(Integer.class, map.get(PayNotifyTaskMeta.MAX_NOTIFY_TIMES)));
			this.setStatus(DataParser.parse(String.class, map.get(PayNotifyTaskMeta.STATUS)));
			// others
			this.setPayApp(DataParser.parse(PayApp.class, map.get(PayNotifyTaskMeta.PAY_APP)));
			this.setPayMerchant(DataParser.parse(PayMerchant.class, map.get(PayNotifyTaskMeta.PAY_MERCHANT)));
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)map.get(PayNotifyTaskMeta.UPDATE_TIME));
				this.setMerchantOrderId( (String)map.get(PayNotifyTaskMeta.MERCHANT_ORDER_ID));
				this.setType( (String)map.get(PayNotifyTaskMeta.TYPE));
				this.setVersion( (Integer)map.get(PayNotifyTaskMeta.VERSION));
				this.setNextNotifyTime( (Date)map.get(PayNotifyTaskMeta.NEXT_NOTIFY_TIME));
				this.setLastExecuteTime( (Date)map.get(PayNotifyTaskMeta.LAST_EXECUTE_TIME));
				this.setCreateBy( (String)map.get(PayNotifyTaskMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PayNotifyTaskMeta.DELETED));
				this.setDataId( (String)map.get(PayNotifyTaskMeta.DATA_ID));
				this.setMerchantId( (String)map.get(PayNotifyTaskMeta.MERCHANT_ID));
				this.setCreateTime( (Date)map.get(PayNotifyTaskMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PayNotifyTaskMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PayNotifyTaskMeta.DELETE_TIME));
				this.setAppId( (String)map.get(PayNotifyTaskMeta.APP_ID));
				this.setTenantId( (String)map.get(PayNotifyTaskMeta.TENANT_ID));
				this.setNotifyUrl( (String)map.get(PayNotifyTaskMeta.NOTIFY_URL));
				this.setDeleteBy( (String)map.get(PayNotifyTaskMeta.DELETE_BY));
				this.setId( (String)map.get(PayNotifyTaskMeta.ID));
				this.setNotifyTimes( (Integer)map.get(PayNotifyTaskMeta.NOTIFY_TIMES));
				this.setMaxNotifyTimes( (Integer)map.get(PayNotifyTaskMeta.MAX_NOTIFY_TIMES));
				this.setStatus( (String)map.get(PayNotifyTaskMeta.STATUS));
				// others
				this.setPayApp( (PayApp)map.get(PayNotifyTaskMeta.PAY_APP));
				this.setPayMerchant( (PayMerchant)map.get(PayNotifyTaskMeta.PAY_MERCHANT));
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
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PayNotifyTaskMeta.UPDATE_TIME)));
			this.setMerchantOrderId(DataParser.parse(String.class, r.getValue(PayNotifyTaskMeta.MERCHANT_ORDER_ID)));
			this.setType(DataParser.parse(String.class, r.getValue(PayNotifyTaskMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PayNotifyTaskMeta.VERSION)));
			this.setNextNotifyTime(DataParser.parse(Date.class, r.getValue(PayNotifyTaskMeta.NEXT_NOTIFY_TIME)));
			this.setLastExecuteTime(DataParser.parse(Date.class, r.getValue(PayNotifyTaskMeta.LAST_EXECUTE_TIME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PayNotifyTaskMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PayNotifyTaskMeta.DELETED)));
			this.setDataId(DataParser.parse(String.class, r.getValue(PayNotifyTaskMeta.DATA_ID)));
			this.setMerchantId(DataParser.parse(String.class, r.getValue(PayNotifyTaskMeta.MERCHANT_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PayNotifyTaskMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PayNotifyTaskMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PayNotifyTaskMeta.DELETE_TIME)));
			this.setAppId(DataParser.parse(String.class, r.getValue(PayNotifyTaskMeta.APP_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PayNotifyTaskMeta.TENANT_ID)));
			this.setNotifyUrl(DataParser.parse(String.class, r.getValue(PayNotifyTaskMeta.NOTIFY_URL)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PayNotifyTaskMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PayNotifyTaskMeta.ID)));
			this.setNotifyTimes(DataParser.parse(Integer.class, r.getValue(PayNotifyTaskMeta.NOTIFY_TIMES)));
			this.setMaxNotifyTimes(DataParser.parse(Integer.class, r.getValue(PayNotifyTaskMeta.MAX_NOTIFY_TIMES)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PayNotifyTaskMeta.STATUS)));
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)r.getValue(PayNotifyTaskMeta.UPDATE_TIME));
				this.setMerchantOrderId( (String)r.getValue(PayNotifyTaskMeta.MERCHANT_ORDER_ID));
				this.setType( (String)r.getValue(PayNotifyTaskMeta.TYPE));
				this.setVersion( (Integer)r.getValue(PayNotifyTaskMeta.VERSION));
				this.setNextNotifyTime( (Date)r.getValue(PayNotifyTaskMeta.NEXT_NOTIFY_TIME));
				this.setLastExecuteTime( (Date)r.getValue(PayNotifyTaskMeta.LAST_EXECUTE_TIME));
				this.setCreateBy( (String)r.getValue(PayNotifyTaskMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PayNotifyTaskMeta.DELETED));
				this.setDataId( (String)r.getValue(PayNotifyTaskMeta.DATA_ID));
				this.setMerchantId( (String)r.getValue(PayNotifyTaskMeta.MERCHANT_ID));
				this.setCreateTime( (Date)r.getValue(PayNotifyTaskMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PayNotifyTaskMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PayNotifyTaskMeta.DELETE_TIME));
				this.setAppId( (String)r.getValue(PayNotifyTaskMeta.APP_ID));
				this.setTenantId( (String)r.getValue(PayNotifyTaskMeta.TENANT_ID));
				this.setNotifyUrl( (String)r.getValue(PayNotifyTaskMeta.NOTIFY_URL));
				this.setDeleteBy( (String)r.getValue(PayNotifyTaskMeta.DELETE_BY));
				this.setId( (String)r.getValue(PayNotifyTaskMeta.ID));
				this.setNotifyTimes( (Integer)r.getValue(PayNotifyTaskMeta.NOTIFY_TIMES));
				this.setMaxNotifyTimes( (Integer)r.getValue(PayNotifyTaskMeta.MAX_NOTIFY_TIMES));
				this.setStatus( (String)r.getValue(PayNotifyTaskMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}