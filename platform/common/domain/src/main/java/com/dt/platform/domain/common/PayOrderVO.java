package com.dt.platform.domain.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.github.foxnic.api.model.CompositeParameter;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import java.util.Map;
import com.dt.platform.domain.common.meta.PayOrderVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 支付订单VO类型
 * <p>支付订单 , 数据表 sys_pay_order 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 15:51:25
 * @sign 37A42F07B097BDFDF46B0A2E579694A4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "支付订单VO类型 ; 支付订单 , 数据表 sys_pay_order 的通用VO类型" , parent = PayOrder.class)
public class PayOrderVO extends PayOrder {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 页码
	*/
	@ApiModelProperty(required = false,value="页码" , notes = "")
	private Integer pageIndex;
	
	/**
	 * 分页大小
	*/
	@ApiModelProperty(required = false,value="分页大小" , notes = "")
	private Integer pageSize;
	
	/**
	 * 搜索字段
	*/
	@ApiModelProperty(required = false,value="搜索字段" , notes = "")
	private String searchField;
	
	/**
	 * 模糊搜索字段
	*/
	@ApiModelProperty(required = false,value="模糊搜索字段" , notes = "")
	private String fuzzyField;
	
	/**
	 * 搜索的值
	*/
	@ApiModelProperty(required = false,value="搜索的值" , notes = "")
	private String searchValue;
	
	/**
	 * 已修改字段
	*/
	@ApiModelProperty(required = false,value="已修改字段" , notes = "")
	private List<String> dirtyFields;
	
	/**
	 * 排序字段
	*/
	@ApiModelProperty(required = false,value="排序字段" , notes = "")
	private String sortField;
	
	/**
	 * 排序方式
	*/
	@ApiModelProperty(required = false,value="排序方式" , notes = "")
	private String sortType;
	
	/**
	 * 数据来源：前端指定不同的来源，后端可按来源执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "前端指定不同的来源，后端可按来源执行不同的逻辑")
	private String dataOrigin;
	
	/**
	 * 查询逻辑：默认and，可指定 or 
	*/
	@ApiModelProperty(required = false,value="查询逻辑" , notes = "默认and，可指定 or ")
	private String queryLogic;
	
	/**
	 * 请求动作：前端指定不同的Action，后端可Action执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="请求动作" , notes = "前端指定不同的Action，后端可Action执行不同的逻辑")
	private String requestAction;
	
	/**
	 * 主键清单：用于接收批量主键参数
	*/
	@ApiModelProperty(required = false,value="主键清单" , notes = "用于接收批量主键参数")
	private List<String> ids;
	
	/**
	 * 获得 页码<br>
	 * @return 页码
	*/
	public Integer getPageIndex() {
		return pageIndex;
	}
	
	/**
	 * 设置 页码
	 * @param pageIndex 页码
	 * @return 当前对象
	*/
	public PayOrderVO setPageIndex(Integer pageIndex) {
		this.pageIndex=pageIndex;
		return this;
	}
	
	/**
	 * 获得 分页大小<br>
	 * @return 分页大小
	*/
	public Integer getPageSize() {
		return pageSize;
	}
	
	/**
	 * 设置 分页大小
	 * @param pageSize 分页大小
	 * @return 当前对象
	*/
	public PayOrderVO setPageSize(Integer pageSize) {
		this.pageSize=pageSize;
		return this;
	}
	
	/**
	 * 获得 搜索字段<br>
	 * @return 搜索字段
	*/
	public String getSearchField() {
		return searchField;
	}
	
	/**
	 * 设置 搜索字段
	 * @param searchField 搜索字段
	 * @return 当前对象
	*/
	public PayOrderVO setSearchField(String searchField) {
		this.searchField=searchField;
		return this;
	}
	
	/**
	 * 获得 模糊搜索字段<br>
	 * @return 模糊搜索字段
	*/
	public String getFuzzyField() {
		return fuzzyField;
	}
	
	/**
	 * 设置 模糊搜索字段
	 * @param fuzzyField 模糊搜索字段
	 * @return 当前对象
	*/
	public PayOrderVO setFuzzyField(String fuzzyField) {
		this.fuzzyField=fuzzyField;
		return this;
	}
	
	/**
	 * 获得 搜索的值<br>
	 * @return 搜索的值
	*/
	public String getSearchValue() {
		return searchValue;
	}
	
	/**
	 * 设置 搜索的值
	 * @param searchValue 搜索的值
	 * @return 当前对象
	*/
	public PayOrderVO setSearchValue(String searchValue) {
		this.searchValue=searchValue;
		return this;
	}
	
	/**
	 * 获得 已修改字段<br>
	 * @return 已修改字段
	*/
	public List<String> getDirtyFields() {
		return dirtyFields;
	}
	
	/**
	 * 设置 已修改字段
	 * @param dirtyFields 已修改字段
	 * @return 当前对象
	*/
	public PayOrderVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public PayOrderVO addDirtyField(String... dirtyField) {
		if(this.dirtyFields==null) dirtyFields=new ArrayList<>();
		this.dirtyFields.addAll(Arrays.asList(dirtyField));
		return this;
	}
	
	/**
	 * 获得 排序字段<br>
	 * @return 排序字段
	*/
	public String getSortField() {
		return sortField;
	}
	
	/**
	 * 设置 排序字段
	 * @param sortField 排序字段
	 * @return 当前对象
	*/
	public PayOrderVO setSortField(String sortField) {
		this.sortField=sortField;
		return this;
	}
	
	/**
	 * 获得 排序方式<br>
	 * @return 排序方式
	*/
	public String getSortType() {
		return sortType;
	}
	
	/**
	 * 设置 排序方式
	 * @param sortType 排序方式
	 * @return 当前对象
	*/
	public PayOrderVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 前端指定不同的来源，后端可按来源执行不同的逻辑
	 * @return 数据来源
	*/
	public String getDataOrigin() {
		return dataOrigin;
	}
	
	/**
	 * 设置 数据来源
	 * @param dataOrigin 数据来源
	 * @return 当前对象
	*/
	public PayOrderVO setDataOrigin(String dataOrigin) {
		this.dataOrigin=dataOrigin;
		return this;
	}
	
	/**
	 * 获得 查询逻辑<br>
	 * 默认and，可指定 or 
	 * @return 查询逻辑
	*/
	public String getQueryLogic() {
		return queryLogic;
	}
	
	/**
	 * 设置 查询逻辑
	 * @param queryLogic 查询逻辑
	 * @return 当前对象
	*/
	public PayOrderVO setQueryLogic(String queryLogic) {
		this.queryLogic=queryLogic;
		return this;
	}
	
	/**
	 * 获得 请求动作<br>
	 * 前端指定不同的Action，后端可Action执行不同的逻辑
	 * @return 请求动作
	*/
	public String getRequestAction() {
		return requestAction;
	}
	
	/**
	 * 设置 请求动作
	 * @param requestAction 请求动作
	 * @return 当前对象
	*/
	public PayOrderVO setRequestAction(String requestAction) {
		this.requestAction=requestAction;
		return this;
	}
	
	/**
	 * 获得 主键清单<br>
	 * 用于接收批量主键参数
	 * @return 主键清单
	*/
	public List<String> getIds() {
		return ids;
	}
	
	/**
	 * 设置 主键清单
	 * @param ids 主键清单
	 * @return 当前对象
	*/
	public PayOrderVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public PayOrderVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	@Transient
	private transient CompositeParameter $compositeParameter;
	/**
	 * 获得解析后的复合查询参数
	 */
	@Transient
	public CompositeParameter getCompositeParameter() {
		if($compositeParameter!=null) return  $compositeParameter;
		$compositeParameter=new CompositeParameter(this.getSearchValue(),BeanUtil.toMap(this));
		return  $compositeParameter;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PayOrderVO , 转换好的 PayOrderVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PayOrderVO , 转换好的 PoJo 对象
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
	public PayOrderVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PayOrderVO duplicate(boolean all) {
		com.dt.platform.domain.common.meta.PayOrderVOMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.PayOrderVOMeta.$$proxy$$();
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
			inst.setPayChannel(this.getPayChannel());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setPayOrderExt(this.getPayOrderExt());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PayOrderVO clone(boolean deep) {
		return EntityContext.clone(PayOrderVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PayOrderVO
	 * @param payOrderMap 包含实体信息的 Map 对象
	 * @return PayOrderVO , 转换好的的 PayOrder 对象
	*/
	@Transient
	public static PayOrderVO createFrom(Map<String,Object> payOrderMap) {
		if(payOrderMap==null) return null;
		PayOrderVO vo = create();
		EntityContext.copyProperties(vo,payOrderMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 PayOrderVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PayOrderVO , 转换好的的 PayOrder 对象
	*/
	@Transient
	public static PayOrderVO createFrom(Object pojo) {
		if(pojo==null) return null;
		PayOrderVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 PayOrderVO，等同于 new
	 * @return PayOrderVO 对象
	*/
	@Transient
	public static PayOrderVO create() {
		return new com.dt.platform.domain.common.meta.PayOrderVOMeta.$$proxy$$();
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
			this.setSubject(DataParser.parse(String.class, map.get(PayOrderVOMeta.SUBJECT)));
			this.setNotifyStatus(DataParser.parse(String.class, map.get(PayOrderVOMeta.NOTIFY_STATUS)));
			this.setRefundStatus(DataParser.parse(String.class, map.get(PayOrderVOMeta.REFUND_STATUS)));
			this.setChannelOrderNo(DataParser.parse(String.class, map.get(PayOrderVOMeta.CHANNEL_ORDER_NO)));
			this.setMerchantOrderId(DataParser.parse(String.class, map.get(PayOrderVOMeta.MERCHANT_ORDER_ID)));
			this.setBody(DataParser.parse(String.class, map.get(PayOrderVOMeta.BODY)));
			this.setRefundTimes(DataParser.parse(Integer.class, map.get(PayOrderVOMeta.REFUND_TIMES)));
			this.setChannelFeeAmount(DataParser.parse(Long.class, map.get(PayOrderVOMeta.CHANNEL_FEE_AMOUNT)));
			this.setMerchantId(DataParser.parse(String.class, map.get(PayOrderVOMeta.MERCHANT_ID)));
			this.setChannelUserId(DataParser.parse(String.class, map.get(PayOrderVOMeta.CHANNEL_USER_ID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PayOrderVOMeta.UPDATE_BY)));
			this.setAppId(DataParser.parse(String.class, map.get(PayOrderVOMeta.APP_ID)));
			this.setSuccessTime(DataParser.parse(Date.class, map.get(PayOrderVOMeta.SUCCESS_TIME)));
			this.setId(DataParser.parse(String.class, map.get(PayOrderVOMeta.ID)));
			this.setChannelId(DataParser.parse(String.class, map.get(PayOrderVOMeta.CHANNEL_ID)));
			this.setSuccessExtensionId(DataParser.parse(String.class, map.get(PayOrderVOMeta.SUCCESS_EXTENSION_ID)));
			this.setRefundAmount(DataParser.parse(Long.class, map.get(PayOrderVOMeta.REFUND_AMOUNT)));
			this.setChannelCode(DataParser.parse(String.class, map.get(PayOrderVOMeta.CHANNEL_CODE)));
			this.setAmount(DataParser.parse(Long.class, map.get(PayOrderVOMeta.AMOUNT)));
			this.setTradeNo(DataParser.parse(String.class, map.get(PayOrderVOMeta.TRADE_NO)));
			this.setNotifyTime(DataParser.parse(Date.class, map.get(PayOrderVOMeta.NOTIFY_TIME)));
			this.setChannelFeeRate(DataParser.parse(BigDecimal.class, map.get(PayOrderVOMeta.CHANNEL_FEE_RATE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PayOrderVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PayOrderVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PayOrderVOMeta.CREATE_BY)));
			this.setExpireTime(DataParser.parse(Date.class, map.get(PayOrderVOMeta.EXPIRE_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PayOrderVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PayOrderVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PayOrderVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PayOrderVOMeta.TENANT_ID)));
			this.setNotifyUrl(DataParser.parse(String.class, map.get(PayOrderVOMeta.NOTIFY_URL)));
			this.setUserIp(DataParser.parse(String.class, map.get(PayOrderVOMeta.USER_IP)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PayOrderVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(Integer.class, map.get(PayOrderVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(PayOrderVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(PayOrderVOMeta.REQUEST_ACTION)));
			this.setPayMerchant(DataParser.parse(PayMerchant.class, map.get(PayOrderVOMeta.PAY_MERCHANT)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(PayOrderVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(PayOrderVOMeta.PAGE_SIZE)));
			this.setPayApp(DataParser.parse(PayApp.class, map.get(PayOrderVOMeta.PAY_APP)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(PayOrderVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(PayOrderVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(PayOrderVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(PayOrderVOMeta.DATA_ORIGIN)));
			this.setPayChannel(DataParser.parse(PayChannel.class, map.get(PayOrderVOMeta.PAY_CHANNEL)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(PayOrderVOMeta.QUERY_LOGIC)));
			this.setPayOrderExt(DataParser.parse(PayOrderExt.class, map.get(PayOrderVOMeta.PAY_ORDER_EXT)));
			this.setSearchValue(DataParser.parse(String.class, map.get(PayOrderVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setSubject( (String)map.get(PayOrderVOMeta.SUBJECT));
				this.setNotifyStatus( (String)map.get(PayOrderVOMeta.NOTIFY_STATUS));
				this.setRefundStatus( (String)map.get(PayOrderVOMeta.REFUND_STATUS));
				this.setChannelOrderNo( (String)map.get(PayOrderVOMeta.CHANNEL_ORDER_NO));
				this.setMerchantOrderId( (String)map.get(PayOrderVOMeta.MERCHANT_ORDER_ID));
				this.setBody( (String)map.get(PayOrderVOMeta.BODY));
				this.setRefundTimes( (Integer)map.get(PayOrderVOMeta.REFUND_TIMES));
				this.setChannelFeeAmount( (Long)map.get(PayOrderVOMeta.CHANNEL_FEE_AMOUNT));
				this.setMerchantId( (String)map.get(PayOrderVOMeta.MERCHANT_ID));
				this.setChannelUserId( (String)map.get(PayOrderVOMeta.CHANNEL_USER_ID));
				this.setUpdateBy( (String)map.get(PayOrderVOMeta.UPDATE_BY));
				this.setAppId( (String)map.get(PayOrderVOMeta.APP_ID));
				this.setSuccessTime( (Date)map.get(PayOrderVOMeta.SUCCESS_TIME));
				this.setId( (String)map.get(PayOrderVOMeta.ID));
				this.setChannelId( (String)map.get(PayOrderVOMeta.CHANNEL_ID));
				this.setSuccessExtensionId( (String)map.get(PayOrderVOMeta.SUCCESS_EXTENSION_ID));
				this.setRefundAmount( (Long)map.get(PayOrderVOMeta.REFUND_AMOUNT));
				this.setChannelCode( (String)map.get(PayOrderVOMeta.CHANNEL_CODE));
				this.setAmount( (Long)map.get(PayOrderVOMeta.AMOUNT));
				this.setTradeNo( (String)map.get(PayOrderVOMeta.TRADE_NO));
				this.setNotifyTime( (Date)map.get(PayOrderVOMeta.NOTIFY_TIME));
				this.setChannelFeeRate( (BigDecimal)map.get(PayOrderVOMeta.CHANNEL_FEE_RATE));
				this.setUpdateTime( (Date)map.get(PayOrderVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PayOrderVOMeta.VERSION));
				this.setCreateBy( (String)map.get(PayOrderVOMeta.CREATE_BY));
				this.setExpireTime( (Date)map.get(PayOrderVOMeta.EXPIRE_TIME));
				this.setDeleted( (Integer)map.get(PayOrderVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(PayOrderVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(PayOrderVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(PayOrderVOMeta.TENANT_ID));
				this.setNotifyUrl( (String)map.get(PayOrderVOMeta.NOTIFY_URL));
				this.setUserIp( (String)map.get(PayOrderVOMeta.USER_IP));
				this.setDeleteBy( (String)map.get(PayOrderVOMeta.DELETE_BY));
				this.setStatus( (Integer)map.get(PayOrderVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(PayOrderVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(PayOrderVOMeta.REQUEST_ACTION));
				this.setPayMerchant( (PayMerchant)map.get(PayOrderVOMeta.PAY_MERCHANT));
				this.setFuzzyField( (String)map.get(PayOrderVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(PayOrderVOMeta.PAGE_SIZE));
				this.setPayApp( (PayApp)map.get(PayOrderVOMeta.PAY_APP));
				this.setPageIndex( (Integer)map.get(PayOrderVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(PayOrderVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(PayOrderVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(PayOrderVOMeta.DATA_ORIGIN));
				this.setPayChannel( (PayChannel)map.get(PayOrderVOMeta.PAY_CHANNEL));
				this.setQueryLogic( (String)map.get(PayOrderVOMeta.QUERY_LOGIC));
				this.setPayOrderExt( (PayOrderExt)map.get(PayOrderVOMeta.PAY_ORDER_EXT));
				this.setSearchValue( (String)map.get(PayOrderVOMeta.SEARCH_VALUE));
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
			this.setSubject(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.SUBJECT)));
			this.setNotifyStatus(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.NOTIFY_STATUS)));
			this.setRefundStatus(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.REFUND_STATUS)));
			this.setChannelOrderNo(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.CHANNEL_ORDER_NO)));
			this.setMerchantOrderId(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.MERCHANT_ORDER_ID)));
			this.setBody(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.BODY)));
			this.setRefundTimes(DataParser.parse(Integer.class, r.getValue(PayOrderVOMeta.REFUND_TIMES)));
			this.setChannelFeeAmount(DataParser.parse(Long.class, r.getValue(PayOrderVOMeta.CHANNEL_FEE_AMOUNT)));
			this.setMerchantId(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.MERCHANT_ID)));
			this.setChannelUserId(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.CHANNEL_USER_ID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.UPDATE_BY)));
			this.setAppId(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.APP_ID)));
			this.setSuccessTime(DataParser.parse(Date.class, r.getValue(PayOrderVOMeta.SUCCESS_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.ID)));
			this.setChannelId(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.CHANNEL_ID)));
			this.setSuccessExtensionId(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.SUCCESS_EXTENSION_ID)));
			this.setRefundAmount(DataParser.parse(Long.class, r.getValue(PayOrderVOMeta.REFUND_AMOUNT)));
			this.setChannelCode(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.CHANNEL_CODE)));
			this.setAmount(DataParser.parse(Long.class, r.getValue(PayOrderVOMeta.AMOUNT)));
			this.setTradeNo(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.TRADE_NO)));
			this.setNotifyTime(DataParser.parse(Date.class, r.getValue(PayOrderVOMeta.NOTIFY_TIME)));
			this.setChannelFeeRate(DataParser.parse(BigDecimal.class, r.getValue(PayOrderVOMeta.CHANNEL_FEE_RATE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PayOrderVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PayOrderVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.CREATE_BY)));
			this.setExpireTime(DataParser.parse(Date.class, r.getValue(PayOrderVOMeta.EXPIRE_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PayOrderVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PayOrderVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PayOrderVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.TENANT_ID)));
			this.setNotifyUrl(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.NOTIFY_URL)));
			this.setUserIp(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.USER_IP)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PayOrderVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(Integer.class, r.getValue(PayOrderVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setSubject( (String)r.getValue(PayOrderVOMeta.SUBJECT));
				this.setNotifyStatus( (String)r.getValue(PayOrderVOMeta.NOTIFY_STATUS));
				this.setRefundStatus( (String)r.getValue(PayOrderVOMeta.REFUND_STATUS));
				this.setChannelOrderNo( (String)r.getValue(PayOrderVOMeta.CHANNEL_ORDER_NO));
				this.setMerchantOrderId( (String)r.getValue(PayOrderVOMeta.MERCHANT_ORDER_ID));
				this.setBody( (String)r.getValue(PayOrderVOMeta.BODY));
				this.setRefundTimes( (Integer)r.getValue(PayOrderVOMeta.REFUND_TIMES));
				this.setChannelFeeAmount( (Long)r.getValue(PayOrderVOMeta.CHANNEL_FEE_AMOUNT));
				this.setMerchantId( (String)r.getValue(PayOrderVOMeta.MERCHANT_ID));
				this.setChannelUserId( (String)r.getValue(PayOrderVOMeta.CHANNEL_USER_ID));
				this.setUpdateBy( (String)r.getValue(PayOrderVOMeta.UPDATE_BY));
				this.setAppId( (String)r.getValue(PayOrderVOMeta.APP_ID));
				this.setSuccessTime( (Date)r.getValue(PayOrderVOMeta.SUCCESS_TIME));
				this.setId( (String)r.getValue(PayOrderVOMeta.ID));
				this.setChannelId( (String)r.getValue(PayOrderVOMeta.CHANNEL_ID));
				this.setSuccessExtensionId( (String)r.getValue(PayOrderVOMeta.SUCCESS_EXTENSION_ID));
				this.setRefundAmount( (Long)r.getValue(PayOrderVOMeta.REFUND_AMOUNT));
				this.setChannelCode( (String)r.getValue(PayOrderVOMeta.CHANNEL_CODE));
				this.setAmount( (Long)r.getValue(PayOrderVOMeta.AMOUNT));
				this.setTradeNo( (String)r.getValue(PayOrderVOMeta.TRADE_NO));
				this.setNotifyTime( (Date)r.getValue(PayOrderVOMeta.NOTIFY_TIME));
				this.setChannelFeeRate( (BigDecimal)r.getValue(PayOrderVOMeta.CHANNEL_FEE_RATE));
				this.setUpdateTime( (Date)r.getValue(PayOrderVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PayOrderVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(PayOrderVOMeta.CREATE_BY));
				this.setExpireTime( (Date)r.getValue(PayOrderVOMeta.EXPIRE_TIME));
				this.setDeleted( (Integer)r.getValue(PayOrderVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PayOrderVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(PayOrderVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(PayOrderVOMeta.TENANT_ID));
				this.setNotifyUrl( (String)r.getValue(PayOrderVOMeta.NOTIFY_URL));
				this.setUserIp( (String)r.getValue(PayOrderVOMeta.USER_IP));
				this.setDeleteBy( (String)r.getValue(PayOrderVOMeta.DELETE_BY));
				this.setStatus( (Integer)r.getValue(PayOrderVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}