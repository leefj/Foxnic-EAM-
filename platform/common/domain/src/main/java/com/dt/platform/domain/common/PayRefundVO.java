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
import com.dt.platform.domain.common.meta.PayRefundVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 退款订单VO类型
 * <p>退款订单 , 数据表 sys_pay_refund 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-04 16:15:46
 * @sign CB79F1A6933DB4CE3FACD0B0B0F57E02
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "退款订单VO类型 ; 退款订单 , 数据表 sys_pay_refund 的通用VO类型" , parent = PayRefund.class)
public class PayRefundVO extends PayRefund {

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
	public PayRefundVO setPageIndex(Integer pageIndex) {
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
	public PayRefundVO setPageSize(Integer pageSize) {
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
	public PayRefundVO setSearchField(String searchField) {
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
	public PayRefundVO setFuzzyField(String fuzzyField) {
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
	public PayRefundVO setSearchValue(String searchValue) {
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
	public PayRefundVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public PayRefundVO addDirtyField(String... dirtyField) {
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
	public PayRefundVO setSortField(String sortField) {
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
	public PayRefundVO setSortType(String sortType) {
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
	public PayRefundVO setDataOrigin(String dataOrigin) {
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
	public PayRefundVO setQueryLogic(String queryLogic) {
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
	public PayRefundVO setRequestAction(String requestAction) {
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
	public PayRefundVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public PayRefundVO addId(String... id) {
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
	 * @return PayRefundVO , 转换好的 PayRefundVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PayRefundVO , 转换好的 PoJo 对象
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
	public PayRefundVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PayRefundVO duplicate(boolean all) {
		com.dt.platform.domain.common.meta.PayRefundVOMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.PayRefundVOMeta.$$proxy$$();
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
			inst.setPayChannel(this.getPayChannel());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PayRefundVO clone(boolean deep) {
		return EntityContext.clone(PayRefundVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PayRefundVO
	 * @param payRefundMap 包含实体信息的 Map 对象
	 * @return PayRefundVO , 转换好的的 PayRefund 对象
	*/
	@Transient
	public static PayRefundVO createFrom(Map<String,Object> payRefundMap) {
		if(payRefundMap==null) return null;
		PayRefundVO vo = create();
		EntityContext.copyProperties(vo,payRefundMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 PayRefundVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PayRefundVO , 转换好的的 PayRefund 对象
	*/
	@Transient
	public static PayRefundVO createFrom(Object pojo) {
		if(pojo==null) return null;
		PayRefundVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 PayRefundVO，等同于 new
	 * @return PayRefundVO 对象
	*/
	@Transient
	public static PayRefundVO create() {
		return new com.dt.platform.domain.common.meta.PayRefundVOMeta.$$proxy$$();
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
			this.setReason(DataParser.parse(String.class, map.get(PayRefundVOMeta.REASON)));
			this.setOrderId(DataParser.parse(String.class, map.get(PayRefundVOMeta.ORDER_ID)));
			this.setNotifyStatus(DataParser.parse(String.class, map.get(PayRefundVOMeta.NOTIFY_STATUS)));
			this.setChannelRefundNo(DataParser.parse(String.class, map.get(PayRefundVOMeta.CHANNEL_REFUND_NO)));
			this.setChannelOrderNo(DataParser.parse(String.class, map.get(PayRefundVOMeta.CHANNEL_ORDER_NO)));
			this.setMerchantOrderId(DataParser.parse(String.class, map.get(PayRefundVOMeta.MERCHANT_ORDER_ID)));
			this.setType(DataParser.parse(String.class, map.get(PayRefundVOMeta.TYPE)));
			this.setPayAmount(DataParser.parse(Long.class, map.get(PayRefundVOMeta.PAY_AMOUNT)));
			this.setMerchantId(DataParser.parse(String.class, map.get(PayRefundVOMeta.MERCHANT_ID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PayRefundVOMeta.UPDATE_BY)));
			this.setAppId(DataParser.parse(String.class, map.get(PayRefundVOMeta.APP_ID)));
			this.setSuccessTime(DataParser.parse(Date.class, map.get(PayRefundVOMeta.SUCCESS_TIME)));
			this.setId(DataParser.parse(String.class, map.get(PayRefundVOMeta.ID)));
			this.setChannelId(DataParser.parse(String.class, map.get(PayRefundVOMeta.CHANNEL_ID)));
			this.setChannelCode(DataParser.parse(String.class, map.get(PayRefundVOMeta.CHANNEL_CODE)));
			this.setRefundAmount(DataParser.parse(Long.class, map.get(PayRefundVOMeta.REFUND_AMOUNT)));
			this.setChannelErrorMsg(DataParser.parse(String.class, map.get(PayRefundVOMeta.CHANNEL_ERROR_MSG)));
			this.setTradeNo(DataParser.parse(String.class, map.get(PayRefundVOMeta.TRADE_NO)));
			this.setMerchantRefundNo(DataParser.parse(String.class, map.get(PayRefundVOMeta.MERCHANT_REFUND_NO)));
			this.setNotifyTime(DataParser.parse(Date.class, map.get(PayRefundVOMeta.NOTIFY_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PayRefundVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PayRefundVOMeta.VERSION)));
			this.setChannelErrorCode(DataParser.parse(String.class, map.get(PayRefundVOMeta.CHANNEL_ERROR_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PayRefundVOMeta.CREATE_BY)));
			this.setExpireTime(DataParser.parse(Date.class, map.get(PayRefundVOMeta.EXPIRE_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PayRefundVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PayRefundVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PayRefundVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PayRefundVOMeta.TENANT_ID)));
			this.setNotifyUrl(DataParser.parse(String.class, map.get(PayRefundVOMeta.NOTIFY_URL)));
			this.setUserIp(DataParser.parse(String.class, map.get(PayRefundVOMeta.USER_IP)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PayRefundVOMeta.DELETE_BY)));
			this.setChannelExtras(DataParser.parse(String.class, map.get(PayRefundVOMeta.CHANNEL_EXTRAS)));
			this.setStatus(DataParser.parse(String.class, map.get(PayRefundVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(PayRefundVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(PayRefundVOMeta.REQUEST_ACTION)));
			this.setPayMerchant(DataParser.parse(PayMerchant.class, map.get(PayRefundVOMeta.PAY_MERCHANT)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(PayRefundVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(PayRefundVOMeta.PAGE_SIZE)));
			this.setPayOrder(DataParser.parse(PayOrder.class, map.get(PayRefundVOMeta.PAY_ORDER)));
			this.setPayApp(DataParser.parse(PayApp.class, map.get(PayRefundVOMeta.PAY_APP)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(PayRefundVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(PayRefundVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(PayRefundVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(PayRefundVOMeta.DATA_ORIGIN)));
			this.setPayChannel(DataParser.parse(PayChannel.class, map.get(PayRefundVOMeta.PAY_CHANNEL)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(PayRefundVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(PayRefundVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setReason( (String)map.get(PayRefundVOMeta.REASON));
				this.setOrderId( (String)map.get(PayRefundVOMeta.ORDER_ID));
				this.setNotifyStatus( (String)map.get(PayRefundVOMeta.NOTIFY_STATUS));
				this.setChannelRefundNo( (String)map.get(PayRefundVOMeta.CHANNEL_REFUND_NO));
				this.setChannelOrderNo( (String)map.get(PayRefundVOMeta.CHANNEL_ORDER_NO));
				this.setMerchantOrderId( (String)map.get(PayRefundVOMeta.MERCHANT_ORDER_ID));
				this.setType( (String)map.get(PayRefundVOMeta.TYPE));
				this.setPayAmount( (Long)map.get(PayRefundVOMeta.PAY_AMOUNT));
				this.setMerchantId( (String)map.get(PayRefundVOMeta.MERCHANT_ID));
				this.setUpdateBy( (String)map.get(PayRefundVOMeta.UPDATE_BY));
				this.setAppId( (String)map.get(PayRefundVOMeta.APP_ID));
				this.setSuccessTime( (Date)map.get(PayRefundVOMeta.SUCCESS_TIME));
				this.setId( (String)map.get(PayRefundVOMeta.ID));
				this.setChannelId( (String)map.get(PayRefundVOMeta.CHANNEL_ID));
				this.setChannelCode( (String)map.get(PayRefundVOMeta.CHANNEL_CODE));
				this.setRefundAmount( (Long)map.get(PayRefundVOMeta.REFUND_AMOUNT));
				this.setChannelErrorMsg( (String)map.get(PayRefundVOMeta.CHANNEL_ERROR_MSG));
				this.setTradeNo( (String)map.get(PayRefundVOMeta.TRADE_NO));
				this.setMerchantRefundNo( (String)map.get(PayRefundVOMeta.MERCHANT_REFUND_NO));
				this.setNotifyTime( (Date)map.get(PayRefundVOMeta.NOTIFY_TIME));
				this.setUpdateTime( (Date)map.get(PayRefundVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PayRefundVOMeta.VERSION));
				this.setChannelErrorCode( (String)map.get(PayRefundVOMeta.CHANNEL_ERROR_CODE));
				this.setCreateBy( (String)map.get(PayRefundVOMeta.CREATE_BY));
				this.setExpireTime( (Date)map.get(PayRefundVOMeta.EXPIRE_TIME));
				this.setDeleted( (Integer)map.get(PayRefundVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(PayRefundVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(PayRefundVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(PayRefundVOMeta.TENANT_ID));
				this.setNotifyUrl( (String)map.get(PayRefundVOMeta.NOTIFY_URL));
				this.setUserIp( (String)map.get(PayRefundVOMeta.USER_IP));
				this.setDeleteBy( (String)map.get(PayRefundVOMeta.DELETE_BY));
				this.setChannelExtras( (String)map.get(PayRefundVOMeta.CHANNEL_EXTRAS));
				this.setStatus( (String)map.get(PayRefundVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(PayRefundVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(PayRefundVOMeta.REQUEST_ACTION));
				this.setPayMerchant( (PayMerchant)map.get(PayRefundVOMeta.PAY_MERCHANT));
				this.setFuzzyField( (String)map.get(PayRefundVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(PayRefundVOMeta.PAGE_SIZE));
				this.setPayOrder( (PayOrder)map.get(PayRefundVOMeta.PAY_ORDER));
				this.setPayApp( (PayApp)map.get(PayRefundVOMeta.PAY_APP));
				this.setPageIndex( (Integer)map.get(PayRefundVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(PayRefundVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(PayRefundVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(PayRefundVOMeta.DATA_ORIGIN));
				this.setPayChannel( (PayChannel)map.get(PayRefundVOMeta.PAY_CHANNEL));
				this.setQueryLogic( (String)map.get(PayRefundVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(PayRefundVOMeta.SEARCH_VALUE));
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
			this.setReason(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.REASON)));
			this.setOrderId(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.ORDER_ID)));
			this.setNotifyStatus(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.NOTIFY_STATUS)));
			this.setChannelRefundNo(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.CHANNEL_REFUND_NO)));
			this.setChannelOrderNo(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.CHANNEL_ORDER_NO)));
			this.setMerchantOrderId(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.MERCHANT_ORDER_ID)));
			this.setType(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.TYPE)));
			this.setPayAmount(DataParser.parse(Long.class, r.getValue(PayRefundVOMeta.PAY_AMOUNT)));
			this.setMerchantId(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.MERCHANT_ID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.UPDATE_BY)));
			this.setAppId(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.APP_ID)));
			this.setSuccessTime(DataParser.parse(Date.class, r.getValue(PayRefundVOMeta.SUCCESS_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.ID)));
			this.setChannelId(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.CHANNEL_ID)));
			this.setChannelCode(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.CHANNEL_CODE)));
			this.setRefundAmount(DataParser.parse(Long.class, r.getValue(PayRefundVOMeta.REFUND_AMOUNT)));
			this.setChannelErrorMsg(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.CHANNEL_ERROR_MSG)));
			this.setTradeNo(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.TRADE_NO)));
			this.setMerchantRefundNo(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.MERCHANT_REFUND_NO)));
			this.setNotifyTime(DataParser.parse(Date.class, r.getValue(PayRefundVOMeta.NOTIFY_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PayRefundVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PayRefundVOMeta.VERSION)));
			this.setChannelErrorCode(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.CHANNEL_ERROR_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.CREATE_BY)));
			this.setExpireTime(DataParser.parse(Date.class, r.getValue(PayRefundVOMeta.EXPIRE_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PayRefundVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PayRefundVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PayRefundVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.TENANT_ID)));
			this.setNotifyUrl(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.NOTIFY_URL)));
			this.setUserIp(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.USER_IP)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.DELETE_BY)));
			this.setChannelExtras(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.CHANNEL_EXTRAS)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PayRefundVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setReason( (String)r.getValue(PayRefundVOMeta.REASON));
				this.setOrderId( (String)r.getValue(PayRefundVOMeta.ORDER_ID));
				this.setNotifyStatus( (String)r.getValue(PayRefundVOMeta.NOTIFY_STATUS));
				this.setChannelRefundNo( (String)r.getValue(PayRefundVOMeta.CHANNEL_REFUND_NO));
				this.setChannelOrderNo( (String)r.getValue(PayRefundVOMeta.CHANNEL_ORDER_NO));
				this.setMerchantOrderId( (String)r.getValue(PayRefundVOMeta.MERCHANT_ORDER_ID));
				this.setType( (String)r.getValue(PayRefundVOMeta.TYPE));
				this.setPayAmount( (Long)r.getValue(PayRefundVOMeta.PAY_AMOUNT));
				this.setMerchantId( (String)r.getValue(PayRefundVOMeta.MERCHANT_ID));
				this.setUpdateBy( (String)r.getValue(PayRefundVOMeta.UPDATE_BY));
				this.setAppId( (String)r.getValue(PayRefundVOMeta.APP_ID));
				this.setSuccessTime( (Date)r.getValue(PayRefundVOMeta.SUCCESS_TIME));
				this.setId( (String)r.getValue(PayRefundVOMeta.ID));
				this.setChannelId( (String)r.getValue(PayRefundVOMeta.CHANNEL_ID));
				this.setChannelCode( (String)r.getValue(PayRefundVOMeta.CHANNEL_CODE));
				this.setRefundAmount( (Long)r.getValue(PayRefundVOMeta.REFUND_AMOUNT));
				this.setChannelErrorMsg( (String)r.getValue(PayRefundVOMeta.CHANNEL_ERROR_MSG));
				this.setTradeNo( (String)r.getValue(PayRefundVOMeta.TRADE_NO));
				this.setMerchantRefundNo( (String)r.getValue(PayRefundVOMeta.MERCHANT_REFUND_NO));
				this.setNotifyTime( (Date)r.getValue(PayRefundVOMeta.NOTIFY_TIME));
				this.setUpdateTime( (Date)r.getValue(PayRefundVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PayRefundVOMeta.VERSION));
				this.setChannelErrorCode( (String)r.getValue(PayRefundVOMeta.CHANNEL_ERROR_CODE));
				this.setCreateBy( (String)r.getValue(PayRefundVOMeta.CREATE_BY));
				this.setExpireTime( (Date)r.getValue(PayRefundVOMeta.EXPIRE_TIME));
				this.setDeleted( (Integer)r.getValue(PayRefundVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PayRefundVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(PayRefundVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(PayRefundVOMeta.TENANT_ID));
				this.setNotifyUrl( (String)r.getValue(PayRefundVOMeta.NOTIFY_URL));
				this.setUserIp( (String)r.getValue(PayRefundVOMeta.USER_IP));
				this.setDeleteBy( (String)r.getValue(PayRefundVOMeta.DELETE_BY));
				this.setChannelExtras( (String)r.getValue(PayRefundVOMeta.CHANNEL_EXTRAS));
				this.setStatus( (String)r.getValue(PayRefundVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}