package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_INVOKE_LOG;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Timestamp;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.InvokeLogMeta;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 调用统计日志
 * <p>调用统计日志 , 数据表 sys_invoke_log 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-06 19:46:01
 * @sign 8CD465D96897228D1E205056FEFD3483
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_invoke_log")
@ApiModel(description = "调用统计日志 ; 调用统计日志 , 数据表 sys_invoke_log 的PO类型")
public class InvokeLog extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_INVOKE_LOG.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(required = true,value="ID" , notes = "ID" , example = "715147669177106432")
	private Long id;
	
	/**
	 * 应用名称：应用名称
	*/
	@ApiModelProperty(required = false,value="应用名称" , notes = "应用名称" , example = "service-all")
	private String application;
	
	/**
	 * 主机名称：主机名称
	*/
	@ApiModelProperty(required = false,value="主机名称" , notes = "主机名称" , example = "MB.local")
	private String hostName;
	
	/**
	 * 目标名称：目标名称
	*/
	@ApiModelProperty(required = false,value="目标名称" , notes = "目标名称")
	private String subject;
	
	/**
	 * 请求的URI：请求的URI
	*/
	@ApiModelProperty(required = false,value="请求的URI" , notes = "请求的URI" , example = "/assets/css/login-ext.css")
	private String uri;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型" , example = "other")
	private String type;
	
	/**
	 * UserAgent：UserAgent
	*/
	@ApiModelProperty(required = false,value="UserAgent" , notes = "UserAgent" , example = "MAC_OS_X-CHROME11")
	private String userAgent;
	
	/**
	 * 客户端IP：客户端IP
	*/
	@ApiModelProperty(required = false,value="客户端IP" , notes = "客户端IP" , example = "127.0.0.1")
	private String clientIp;
	
	/**
	 * token值：token值
	*/
	@ApiModelProperty(required = false,value="token值" , notes = "token值")
	private String token;
	
	/**
	 * 会话ID：会话ID
	*/
	@ApiModelProperty(required = false,value="会话ID" , notes = "会话ID" , example = "WGfPSHKFcuJ--RFdeEbDcZVw-ULQPV7TBQCS-0kZ")
	private String sessionId;
	
	/**
	 * 用户ID：用户ID
	*/
	@ApiModelProperty(required = false,value="用户ID" , notes = "用户ID")
	private String userId;
	
	/**
	 * 用户姓名：用户姓名
	*/
	@ApiModelProperty(required = false,value="用户姓名" , notes = "用户姓名")
	private String userName;
	
	/**
	 * 日志跟踪ID：日志跟踪ID
	*/
	@ApiModelProperty(required = false,value="日志跟踪ID" , notes = "日志跟踪ID" , example = "715147669202272256")
	private String tid;
	
	/**
	 * 请求参数：请求参数
	*/
	@ApiModelProperty(required = false,value="请求参数" , notes = "请求参数" , example = "20230528102105")
	private String parameter;
	
	/**
	 * 响应数据：响应数据
	*/
	@ApiModelProperty(required = false,value="响应数据" , notes = "响应数据")
	private String response;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间" , example = "2023-05-28 10:21:31.139")
	private Timestamp startTime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间")
	private Timestamp endTime;
	
	/**
	 * 异常信息：异常信息
	*/
	@ApiModelProperty(required = false,value="异常信息" , notes = "异常信息")
	private String exception;
	
	/**
	 * 请求类型：请求类型
	*/
	@ApiModelProperty(required = false,value="请求类型" , notes = "请求类型" , example = "GET")
	private String httpMethod;
	
	/**
	 * 获得 ID<br>
	 * ID
	 * @return ID
	*/
	public Long getId() {
		return id;
	}
	
	/**
	 * 设置 ID
	 * @param id ID
	 * @return 当前对象
	*/
	public InvokeLog setId(Long id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 应用名称<br>
	 * 应用名称
	 * @return 应用名称
	*/
	public String getApplication() {
		return application;
	}
	
	/**
	 * 设置 应用名称
	 * @param application 应用名称
	 * @return 当前对象
	*/
	public InvokeLog setApplication(String application) {
		this.application=application;
		return this;
	}
	
	/**
	 * 获得 主机名称<br>
	 * 主机名称
	 * @return 主机名称
	*/
	public String getHostName() {
		return hostName;
	}
	
	/**
	 * 设置 主机名称
	 * @param hostName 主机名称
	 * @return 当前对象
	*/
	public InvokeLog setHostName(String hostName) {
		this.hostName=hostName;
		return this;
	}
	
	/**
	 * 获得 目标名称<br>
	 * 目标名称
	 * @return 目标名称
	*/
	public String getSubject() {
		return subject;
	}
	
	/**
	 * 设置 目标名称
	 * @param subject 目标名称
	 * @return 当前对象
	*/
	public InvokeLog setSubject(String subject) {
		this.subject=subject;
		return this;
	}
	
	/**
	 * 获得 请求的URI<br>
	 * 请求的URI
	 * @return 请求的URI
	*/
	public String getUri() {
		return uri;
	}
	
	/**
	 * 设置 请求的URI
	 * @param uri 请求的URI
	 * @return 当前对象
	*/
	public InvokeLog setUri(String uri) {
		this.uri=uri;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public InvokeLog setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 UserAgent<br>
	 * UserAgent
	 * @return UserAgent
	*/
	public String getUserAgent() {
		return userAgent;
	}
	
	/**
	 * 设置 UserAgent
	 * @param userAgent UserAgent
	 * @return 当前对象
	*/
	public InvokeLog setUserAgent(String userAgent) {
		this.userAgent=userAgent;
		return this;
	}
	
	/**
	 * 获得 客户端IP<br>
	 * 客户端IP
	 * @return 客户端IP
	*/
	public String getClientIp() {
		return clientIp;
	}
	
	/**
	 * 设置 客户端IP
	 * @param clientIp 客户端IP
	 * @return 当前对象
	*/
	public InvokeLog setClientIp(String clientIp) {
		this.clientIp=clientIp;
		return this;
	}
	
	/**
	 * 获得 token值<br>
	 * token值
	 * @return token值
	*/
	public String getToken() {
		return token;
	}
	
	/**
	 * 设置 token值
	 * @param token token值
	 * @return 当前对象
	*/
	public InvokeLog setToken(String token) {
		this.token=token;
		return this;
	}
	
	/**
	 * 获得 会话ID<br>
	 * 会话ID
	 * @return 会话ID
	*/
	public String getSessionId() {
		return sessionId;
	}
	
	/**
	 * 设置 会话ID
	 * @param sessionId 会话ID
	 * @return 当前对象
	*/
	public InvokeLog setSessionId(String sessionId) {
		this.sessionId=sessionId;
		return this;
	}
	
	/**
	 * 获得 用户ID<br>
	 * 用户ID
	 * @return 用户ID
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 用户ID
	 * @param userId 用户ID
	 * @return 当前对象
	*/
	public InvokeLog setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 用户姓名<br>
	 * 用户姓名
	 * @return 用户姓名
	*/
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 设置 用户姓名
	 * @param userName 用户姓名
	 * @return 当前对象
	*/
	public InvokeLog setUserName(String userName) {
		this.userName=userName;
		return this;
	}
	
	/**
	 * 获得 日志跟踪ID<br>
	 * 日志跟踪ID
	 * @return 日志跟踪ID
	*/
	public String getTid() {
		return tid;
	}
	
	/**
	 * 设置 日志跟踪ID
	 * @param tid 日志跟踪ID
	 * @return 当前对象
	*/
	public InvokeLog setTid(String tid) {
		this.tid=tid;
		return this;
	}
	
	/**
	 * 获得 请求参数<br>
	 * 请求参数
	 * @return 请求参数
	*/
	public String getParameter() {
		return parameter;
	}
	
	/**
	 * 设置 请求参数
	 * @param parameter 请求参数
	 * @return 当前对象
	*/
	public InvokeLog setParameter(String parameter) {
		this.parameter=parameter;
		return this;
	}
	
	/**
	 * 获得 响应数据<br>
	 * 响应数据
	 * @return 响应数据
	*/
	public String getResponse() {
		return response;
	}
	
	/**
	 * 设置 响应数据
	 * @param response 响应数据
	 * @return 当前对象
	*/
	public InvokeLog setResponse(String response) {
		this.response=response;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Timestamp getStartTime() {
		return startTime;
	}
	
	/**
	 * 设置 开始时间
	 * @param startTime 开始时间
	 * @return 当前对象
	*/
	public InvokeLog setStartTime(Timestamp startTime) {
		this.startTime=startTime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Timestamp getEndTime() {
		return endTime;
	}
	
	/**
	 * 设置 结束时间
	 * @param endTime 结束时间
	 * @return 当前对象
	*/
	public InvokeLog setEndTime(Timestamp endTime) {
		this.endTime=endTime;
		return this;
	}
	
	/**
	 * 获得 异常信息<br>
	 * 异常信息
	 * @return 异常信息
	*/
	public String getException() {
		return exception;
	}
	
	/**
	 * 设置 异常信息
	 * @param exception 异常信息
	 * @return 当前对象
	*/
	public InvokeLog setException(String exception) {
		this.exception=exception;
		return this;
	}
	
	/**
	 * 获得 请求类型<br>
	 * 请求类型
	 * @return 请求类型
	*/
	public String getHttpMethod() {
		return httpMethod;
	}
	
	/**
	 * 设置 请求类型
	 * @param httpMethod 请求类型
	 * @return 当前对象
	*/
	public InvokeLog setHttpMethod(String httpMethod) {
		this.httpMethod=httpMethod;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InvokeLog , 转换好的 InvokeLog 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InvokeLog , 转换好的 PoJo 对象
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
	public InvokeLog clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InvokeLog duplicate(boolean all) {
		com.dt.platform.domain.common.meta.InvokeLogMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.InvokeLogMeta.$$proxy$$();
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
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public InvokeLog clone(boolean deep) {
		return EntityContext.clone(InvokeLog.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InvokeLog
	 * @param invokeLogMap 包含实体信息的 Map 对象
	 * @return InvokeLog , 转换好的的 InvokeLog 对象
	*/
	@Transient
	public static InvokeLog createFrom(Map<String,Object> invokeLogMap) {
		if(invokeLogMap==null) return null;
		InvokeLog po = create();
		EntityContext.copyProperties(po,invokeLogMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 InvokeLog
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InvokeLog , 转换好的的 InvokeLog 对象
	*/
	@Transient
	public static InvokeLog createFrom(Object pojo) {
		if(pojo==null) return null;
		InvokeLog po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 InvokeLog，等同于 new
	 * @return InvokeLog 对象
	*/
	@Transient
	public static InvokeLog create() {
		return new com.dt.platform.domain.common.meta.InvokeLogMeta.$$proxy$$();
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
			this.setException(DataParser.parse(String.class, map.get(InvokeLogMeta.EXCEPTION)));
			this.setHostName(DataParser.parse(String.class, map.get(InvokeLogMeta.HOST_NAME)));
			this.setSubject(DataParser.parse(String.class, map.get(InvokeLogMeta.SUBJECT)));
			this.setUserAgent(DataParser.parse(String.class, map.get(InvokeLogMeta.USER_AGENT)));
			this.setSessionId(DataParser.parse(String.class, map.get(InvokeLogMeta.SESSION_ID)));
			this.setType(DataParser.parse(String.class, map.get(InvokeLogMeta.TYPE)));
			this.setUserName(DataParser.parse(String.class, map.get(InvokeLogMeta.USER_NAME)));
			this.setHttpMethod(DataParser.parse(String.class, map.get(InvokeLogMeta.HTTP_METHOD)));
			this.setUri(DataParser.parse(String.class, map.get(InvokeLogMeta.URI)));
			this.setUserId(DataParser.parse(String.class, map.get(InvokeLogMeta.USER_ID)));
			this.setTid(DataParser.parse(String.class, map.get(InvokeLogMeta.TID)));
			this.setToken(DataParser.parse(String.class, map.get(InvokeLogMeta.TOKEN)));
			this.setApplication(DataParser.parse(String.class, map.get(InvokeLogMeta.APPLICATION)));
			this.setResponse(DataParser.parse(String.class, map.get(InvokeLogMeta.RESPONSE)));
			this.setClientIp(DataParser.parse(String.class, map.get(InvokeLogMeta.CLIENT_IP)));
			this.setParameter(DataParser.parse(String.class, map.get(InvokeLogMeta.PARAMETER)));
			this.setStartTime(DataParser.parse(Timestamp.class, map.get(InvokeLogMeta.START_TIME)));
			this.setId(DataParser.parse(Long.class, map.get(InvokeLogMeta.ID)));
			this.setEndTime(DataParser.parse(Timestamp.class, map.get(InvokeLogMeta.END_TIME)));
			// others
			return true;
		} else {
			try {
				this.setException( (String)map.get(InvokeLogMeta.EXCEPTION));
				this.setHostName( (String)map.get(InvokeLogMeta.HOST_NAME));
				this.setSubject( (String)map.get(InvokeLogMeta.SUBJECT));
				this.setUserAgent( (String)map.get(InvokeLogMeta.USER_AGENT));
				this.setSessionId( (String)map.get(InvokeLogMeta.SESSION_ID));
				this.setType( (String)map.get(InvokeLogMeta.TYPE));
				this.setUserName( (String)map.get(InvokeLogMeta.USER_NAME));
				this.setHttpMethod( (String)map.get(InvokeLogMeta.HTTP_METHOD));
				this.setUri( (String)map.get(InvokeLogMeta.URI));
				this.setUserId( (String)map.get(InvokeLogMeta.USER_ID));
				this.setTid( (String)map.get(InvokeLogMeta.TID));
				this.setToken( (String)map.get(InvokeLogMeta.TOKEN));
				this.setApplication( (String)map.get(InvokeLogMeta.APPLICATION));
				this.setResponse( (String)map.get(InvokeLogMeta.RESPONSE));
				this.setClientIp( (String)map.get(InvokeLogMeta.CLIENT_IP));
				this.setParameter( (String)map.get(InvokeLogMeta.PARAMETER));
				this.setStartTime( (Timestamp)map.get(InvokeLogMeta.START_TIME));
				this.setId( (Long)map.get(InvokeLogMeta.ID));
				this.setEndTime( (Timestamp)map.get(InvokeLogMeta.END_TIME));
				// others
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
			this.setException(DataParser.parse(String.class, r.getValue(InvokeLogMeta.EXCEPTION)));
			this.setHostName(DataParser.parse(String.class, r.getValue(InvokeLogMeta.HOST_NAME)));
			this.setSubject(DataParser.parse(String.class, r.getValue(InvokeLogMeta.SUBJECT)));
			this.setUserAgent(DataParser.parse(String.class, r.getValue(InvokeLogMeta.USER_AGENT)));
			this.setSessionId(DataParser.parse(String.class, r.getValue(InvokeLogMeta.SESSION_ID)));
			this.setType(DataParser.parse(String.class, r.getValue(InvokeLogMeta.TYPE)));
			this.setUserName(DataParser.parse(String.class, r.getValue(InvokeLogMeta.USER_NAME)));
			this.setHttpMethod(DataParser.parse(String.class, r.getValue(InvokeLogMeta.HTTP_METHOD)));
			this.setUri(DataParser.parse(String.class, r.getValue(InvokeLogMeta.URI)));
			this.setUserId(DataParser.parse(String.class, r.getValue(InvokeLogMeta.USER_ID)));
			this.setTid(DataParser.parse(String.class, r.getValue(InvokeLogMeta.TID)));
			this.setToken(DataParser.parse(String.class, r.getValue(InvokeLogMeta.TOKEN)));
			this.setApplication(DataParser.parse(String.class, r.getValue(InvokeLogMeta.APPLICATION)));
			this.setResponse(DataParser.parse(String.class, r.getValue(InvokeLogMeta.RESPONSE)));
			this.setClientIp(DataParser.parse(String.class, r.getValue(InvokeLogMeta.CLIENT_IP)));
			this.setParameter(DataParser.parse(String.class, r.getValue(InvokeLogMeta.PARAMETER)));
			this.setStartTime(DataParser.parse(Timestamp.class, r.getValue(InvokeLogMeta.START_TIME)));
			this.setId(DataParser.parse(Long.class, r.getValue(InvokeLogMeta.ID)));
			this.setEndTime(DataParser.parse(Timestamp.class, r.getValue(InvokeLogMeta.END_TIME)));
			return true;
		} else {
			try {
				this.setException( (String)r.getValue(InvokeLogMeta.EXCEPTION));
				this.setHostName( (String)r.getValue(InvokeLogMeta.HOST_NAME));
				this.setSubject( (String)r.getValue(InvokeLogMeta.SUBJECT));
				this.setUserAgent( (String)r.getValue(InvokeLogMeta.USER_AGENT));
				this.setSessionId( (String)r.getValue(InvokeLogMeta.SESSION_ID));
				this.setType( (String)r.getValue(InvokeLogMeta.TYPE));
				this.setUserName( (String)r.getValue(InvokeLogMeta.USER_NAME));
				this.setHttpMethod( (String)r.getValue(InvokeLogMeta.HTTP_METHOD));
				this.setUri( (String)r.getValue(InvokeLogMeta.URI));
				this.setUserId( (String)r.getValue(InvokeLogMeta.USER_ID));
				this.setTid( (String)r.getValue(InvokeLogMeta.TID));
				this.setToken( (String)r.getValue(InvokeLogMeta.TOKEN));
				this.setApplication( (String)r.getValue(InvokeLogMeta.APPLICATION));
				this.setResponse( (String)r.getValue(InvokeLogMeta.RESPONSE));
				this.setClientIp( (String)r.getValue(InvokeLogMeta.CLIENT_IP));
				this.setParameter( (String)r.getValue(InvokeLogMeta.PARAMETER));
				this.setStartTime( (Timestamp)r.getValue(InvokeLogMeta.START_TIME));
				this.setId( (Long)r.getValue(InvokeLogMeta.ID));
				this.setEndTime( (Timestamp)r.getValue(InvokeLogMeta.END_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}