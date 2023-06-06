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
import com.dt.platform.domain.common.meta.InvokeLogVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.sql.Timestamp;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 调用统计日志VO类型
 * <p>调用统计日志 , 数据表 sys_invoke_log 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-06 19:46:01
 * @sign FD1A033162DE3433E30EA820DDB67269
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "调用统计日志VO类型 ; 调用统计日志 , 数据表 sys_invoke_log 的通用VO类型" , parent = InvokeLog.class)
public class InvokeLogVO extends InvokeLog {

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
	private List<Long> ids;
	
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
	public InvokeLogVO setPageIndex(Integer pageIndex) {
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
	public InvokeLogVO setPageSize(Integer pageSize) {
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
	public InvokeLogVO setSearchField(String searchField) {
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
	public InvokeLogVO setFuzzyField(String fuzzyField) {
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
	public InvokeLogVO setSearchValue(String searchValue) {
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
	public InvokeLogVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public InvokeLogVO addDirtyField(String... dirtyField) {
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
	public InvokeLogVO setSortField(String sortField) {
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
	public InvokeLogVO setSortType(String sortType) {
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
	public InvokeLogVO setDataOrigin(String dataOrigin) {
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
	public InvokeLogVO setQueryLogic(String queryLogic) {
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
	public InvokeLogVO setRequestAction(String requestAction) {
		this.requestAction=requestAction;
		return this;
	}
	
	/**
	 * 获得 主键清单<br>
	 * 用于接收批量主键参数
	 * @return 主键清单
	*/
	public List<Long> getIds() {
		return ids;
	}
	
	/**
	 * 设置 主键清单
	 * @param ids 主键清单
	 * @return 当前对象
	*/
	public InvokeLogVO setIds(List<Long> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public InvokeLogVO addId(Long... id) {
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
	 * @return InvokeLogVO , 转换好的 InvokeLogVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InvokeLogVO , 转换好的 PoJo 对象
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
	public InvokeLogVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InvokeLogVO duplicate(boolean all) {
		com.dt.platform.domain.common.meta.InvokeLogVOMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.InvokeLogVOMeta.$$proxy$$();
		inst.setException(this.getException());
		inst.setHostName(this.getHostName());
		inst.setSubject(this.getSubject());
		inst.setUserAgent(this.getUserAgent());
		inst.setSessionId(this.getSessionId());
		inst.setType(this.getType());
		inst.setUserName(this.getUserName());
		inst.setHttpMethod(this.getHttpMethod());
		inst.setUri(this.getUri());
		inst.setUserId(this.getUserId());
		inst.setTid(this.getTid());
		inst.setToken(this.getToken());
		inst.setApplication(this.getApplication());
		inst.setResponse(this.getResponse());
		inst.setClientIp(this.getClientIp());
		inst.setParameter(this.getParameter());
		inst.setStartTime(this.getStartTime());
		inst.setId(this.getId());
		inst.setEndTime(this.getEndTime());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setPageSize(this.getPageSize());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
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
	public InvokeLogVO clone(boolean deep) {
		return EntityContext.clone(InvokeLogVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InvokeLogVO
	 * @param invokeLogMap 包含实体信息的 Map 对象
	 * @return InvokeLogVO , 转换好的的 InvokeLog 对象
	*/
	@Transient
	public static InvokeLogVO createFrom(Map<String,Object> invokeLogMap) {
		if(invokeLogMap==null) return null;
		InvokeLogVO vo = create();
		EntityContext.copyProperties(vo,invokeLogMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 InvokeLogVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InvokeLogVO , 转换好的的 InvokeLog 对象
	*/
	@Transient
	public static InvokeLogVO createFrom(Object pojo) {
		if(pojo==null) return null;
		InvokeLogVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 InvokeLogVO，等同于 new
	 * @return InvokeLogVO 对象
	*/
	@Transient
	public static InvokeLogVO create() {
		return new com.dt.platform.domain.common.meta.InvokeLogVOMeta.$$proxy$$();
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
			this.setException(DataParser.parse(String.class, map.get(InvokeLogVOMeta.EXCEPTION)));
			this.setHostName(DataParser.parse(String.class, map.get(InvokeLogVOMeta.HOST_NAME)));
			this.setSubject(DataParser.parse(String.class, map.get(InvokeLogVOMeta.SUBJECT)));
			this.setUserAgent(DataParser.parse(String.class, map.get(InvokeLogVOMeta.USER_AGENT)));
			this.setSessionId(DataParser.parse(String.class, map.get(InvokeLogVOMeta.SESSION_ID)));
			this.setType(DataParser.parse(String.class, map.get(InvokeLogVOMeta.TYPE)));
			this.setUserName(DataParser.parse(String.class, map.get(InvokeLogVOMeta.USER_NAME)));
			this.setHttpMethod(DataParser.parse(String.class, map.get(InvokeLogVOMeta.HTTP_METHOD)));
			this.setUri(DataParser.parse(String.class, map.get(InvokeLogVOMeta.URI)));
			this.setUserId(DataParser.parse(String.class, map.get(InvokeLogVOMeta.USER_ID)));
			this.setTid(DataParser.parse(String.class, map.get(InvokeLogVOMeta.TID)));
			this.setToken(DataParser.parse(String.class, map.get(InvokeLogVOMeta.TOKEN)));
			this.setApplication(DataParser.parse(String.class, map.get(InvokeLogVOMeta.APPLICATION)));
			this.setResponse(DataParser.parse(String.class, map.get(InvokeLogVOMeta.RESPONSE)));
			this.setClientIp(DataParser.parse(String.class, map.get(InvokeLogVOMeta.CLIENT_IP)));
			this.setParameter(DataParser.parse(String.class, map.get(InvokeLogVOMeta.PARAMETER)));
			this.setStartTime(DataParser.parse(Timestamp.class, map.get(InvokeLogVOMeta.START_TIME)));
			this.setId(DataParser.parse(Long.class, map.get(InvokeLogVOMeta.ID)));
			this.setEndTime(DataParser.parse(Timestamp.class, map.get(InvokeLogVOMeta.END_TIME)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(InvokeLogVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(InvokeLogVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(InvokeLogVOMeta.SORT_TYPE)));
			this.setRequestAction(DataParser.parse(String.class, map.get(InvokeLogVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(InvokeLogVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(InvokeLogVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(InvokeLogVOMeta.PAGE_SIZE)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(InvokeLogVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(InvokeLogVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(InvokeLogVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setException( (String)map.get(InvokeLogVOMeta.EXCEPTION));
				this.setHostName( (String)map.get(InvokeLogVOMeta.HOST_NAME));
				this.setSubject( (String)map.get(InvokeLogVOMeta.SUBJECT));
				this.setUserAgent( (String)map.get(InvokeLogVOMeta.USER_AGENT));
				this.setSessionId( (String)map.get(InvokeLogVOMeta.SESSION_ID));
				this.setType( (String)map.get(InvokeLogVOMeta.TYPE));
				this.setUserName( (String)map.get(InvokeLogVOMeta.USER_NAME));
				this.setHttpMethod( (String)map.get(InvokeLogVOMeta.HTTP_METHOD));
				this.setUri( (String)map.get(InvokeLogVOMeta.URI));
				this.setUserId( (String)map.get(InvokeLogVOMeta.USER_ID));
				this.setTid( (String)map.get(InvokeLogVOMeta.TID));
				this.setToken( (String)map.get(InvokeLogVOMeta.TOKEN));
				this.setApplication( (String)map.get(InvokeLogVOMeta.APPLICATION));
				this.setResponse( (String)map.get(InvokeLogVOMeta.RESPONSE));
				this.setClientIp( (String)map.get(InvokeLogVOMeta.CLIENT_IP));
				this.setParameter( (String)map.get(InvokeLogVOMeta.PARAMETER));
				this.setStartTime( (Timestamp)map.get(InvokeLogVOMeta.START_TIME));
				this.setId( (Long)map.get(InvokeLogVOMeta.ID));
				this.setEndTime( (Timestamp)map.get(InvokeLogVOMeta.END_TIME));
				// others
				this.setSearchField( (String)map.get(InvokeLogVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(InvokeLogVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(InvokeLogVOMeta.SORT_TYPE));
				this.setRequestAction( (String)map.get(InvokeLogVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(InvokeLogVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(InvokeLogVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(InvokeLogVOMeta.PAGE_SIZE));
				this.setDataOrigin( (String)map.get(InvokeLogVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(InvokeLogVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(InvokeLogVOMeta.SEARCH_VALUE));
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
			this.setException(DataParser.parse(String.class, r.getValue(InvokeLogVOMeta.EXCEPTION)));
			this.setHostName(DataParser.parse(String.class, r.getValue(InvokeLogVOMeta.HOST_NAME)));
			this.setSubject(DataParser.parse(String.class, r.getValue(InvokeLogVOMeta.SUBJECT)));
			this.setUserAgent(DataParser.parse(String.class, r.getValue(InvokeLogVOMeta.USER_AGENT)));
			this.setSessionId(DataParser.parse(String.class, r.getValue(InvokeLogVOMeta.SESSION_ID)));
			this.setType(DataParser.parse(String.class, r.getValue(InvokeLogVOMeta.TYPE)));
			this.setUserName(DataParser.parse(String.class, r.getValue(InvokeLogVOMeta.USER_NAME)));
			this.setHttpMethod(DataParser.parse(String.class, r.getValue(InvokeLogVOMeta.HTTP_METHOD)));
			this.setUri(DataParser.parse(String.class, r.getValue(InvokeLogVOMeta.URI)));
			this.setUserId(DataParser.parse(String.class, r.getValue(InvokeLogVOMeta.USER_ID)));
			this.setTid(DataParser.parse(String.class, r.getValue(InvokeLogVOMeta.TID)));
			this.setToken(DataParser.parse(String.class, r.getValue(InvokeLogVOMeta.TOKEN)));
			this.setApplication(DataParser.parse(String.class, r.getValue(InvokeLogVOMeta.APPLICATION)));
			this.setResponse(DataParser.parse(String.class, r.getValue(InvokeLogVOMeta.RESPONSE)));
			this.setClientIp(DataParser.parse(String.class, r.getValue(InvokeLogVOMeta.CLIENT_IP)));
			this.setParameter(DataParser.parse(String.class, r.getValue(InvokeLogVOMeta.PARAMETER)));
			this.setStartTime(DataParser.parse(Timestamp.class, r.getValue(InvokeLogVOMeta.START_TIME)));
			this.setId(DataParser.parse(Long.class, r.getValue(InvokeLogVOMeta.ID)));
			this.setEndTime(DataParser.parse(Timestamp.class, r.getValue(InvokeLogVOMeta.END_TIME)));
			return true;
		} else {
			try {
				this.setException( (String)r.getValue(InvokeLogVOMeta.EXCEPTION));
				this.setHostName( (String)r.getValue(InvokeLogVOMeta.HOST_NAME));
				this.setSubject( (String)r.getValue(InvokeLogVOMeta.SUBJECT));
				this.setUserAgent( (String)r.getValue(InvokeLogVOMeta.USER_AGENT));
				this.setSessionId( (String)r.getValue(InvokeLogVOMeta.SESSION_ID));
				this.setType( (String)r.getValue(InvokeLogVOMeta.TYPE));
				this.setUserName( (String)r.getValue(InvokeLogVOMeta.USER_NAME));
				this.setHttpMethod( (String)r.getValue(InvokeLogVOMeta.HTTP_METHOD));
				this.setUri( (String)r.getValue(InvokeLogVOMeta.URI));
				this.setUserId( (String)r.getValue(InvokeLogVOMeta.USER_ID));
				this.setTid( (String)r.getValue(InvokeLogVOMeta.TID));
				this.setToken( (String)r.getValue(InvokeLogVOMeta.TOKEN));
				this.setApplication( (String)r.getValue(InvokeLogVOMeta.APPLICATION));
				this.setResponse( (String)r.getValue(InvokeLogVOMeta.RESPONSE));
				this.setClientIp( (String)r.getValue(InvokeLogVOMeta.CLIENT_IP));
				this.setParameter( (String)r.getValue(InvokeLogVOMeta.PARAMETER));
				this.setStartTime( (Timestamp)r.getValue(InvokeLogVOMeta.START_TIME));
				this.setId( (Long)r.getValue(InvokeLogVOMeta.ID));
				this.setEndTime( (Timestamp)r.getValue(InvokeLogVOMeta.END_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}