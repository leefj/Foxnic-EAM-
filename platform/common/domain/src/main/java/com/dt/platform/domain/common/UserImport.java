package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_USER_IMPORT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.UserImportMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 员工导入
 * <p>员工导入 , 数据表 sys_user_import 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-18 19:13:37
 * @sign 84BE70F1845818A44944D2C8D95F5379
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_user_import")
@ApiModel(description = "员工导入 ; 员工导入 , 数据表 sys_user_import 的PO类型")
public class UserImport extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_USER_IMPORT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "722865457169694720")
	private String id;
	
	/**
	 * 导入批次：导入批次
	*/
	@ApiModelProperty(required = false,value="导入批次" , notes = "导入批次" , example = "2023-06-18 05:29:15")
	private String actionCode;
	
	/**
	 * 操作时间：操作时间
	*/
	@ApiModelProperty(required = false,value="操作时间" , notes = "操作时间")
	private Date actionOperTime;
	
	/**
	 * 导入状态：导入状态
	*/
	@ApiModelProperty(required = false,value="导入状态" , notes = "导入状态" , example = "wait")
	private String actionStatus;
	
	/**
	 * 导入结果：导入结果
	*/
	@ApiModelProperty(required = false,value="导入结果" , notes = "导入结果")
	private String actionMsg;
	
	/**
	 * 姓名：姓名
	*/
	@ApiModelProperty(required = false,value="姓名" , notes = "姓名" , example = "往往")
	private String userName;
	
	/**
	 * 工号：工号
	*/
	@ApiModelProperty(required = false,value="工号" , notes = "工号" , example = "000001")
	private String badge;
	
	/**
	 * 性别：性别
	*/
	@ApiModelProperty(required = false,value="性别" , notes = "性别")
	private String sex;
	
	/**
	 * 性别编码：性别编码
	*/
	@ApiModelProperty(required = false,value="性别编码" , notes = "性别编码")
	private String sexCode;
	
	/**
	 * 手机号：手机号
	*/
	@ApiModelProperty(required = false,value="手机号" , notes = "手机号" , example = "15728001235")
	private String phone;
	
	/**
	 * 组织：组织
	*/
	@ApiModelProperty(required = false,value="组织" , notes = "组织" , example = "测试")
	private String companyName;
	
	/**
	 * 组织ID：组织ID
	*/
	@ApiModelProperty(required = false,value="组织ID" , notes = "组织ID")
	private String companyId;
	
	/**
	 * 主岗：主岗
	*/
	@ApiModelProperty(required = false,value="主岗" , notes = "主岗" , example = "员工")
	private String masterPost;
	
	/**
	 * 主岗ID：主岗ID
	*/
	@ApiModelProperty(required = false,value="主岗ID" , notes = "主岗ID")
	private String masterPostId;
	
	/**
	 * 身份证：身份证
	*/
	@ApiModelProperty(required = false,value="身份证" , notes = "身份证" , example = "330227198709066474")
	private String idCard;
	
	/**
	 * 状态：字典代码：employee_status
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "字典代码：employee_status" , example = "在业")
	private String status;
	
	/**
	 * 状态编码：状态编码
	*/
	@ApiModelProperty(required = false,value="状态编码" , notes = "状态编码")
	private String statusCode;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-06-18 05:29:15")
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
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "1")
	private Integer version;
	
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
	public UserImport setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 导入批次<br>
	 * 导入批次
	 * @return 导入批次
	*/
	public String getActionCode() {
		return actionCode;
	}
	
	/**
	 * 设置 导入批次
	 * @param actionCode 导入批次
	 * @return 当前对象
	*/
	public UserImport setActionCode(String actionCode) {
		this.actionCode=actionCode;
		return this;
	}
	
	/**
	 * 获得 操作时间<br>
	 * 操作时间
	 * @return 操作时间
	*/
	public Date getActionOperTime() {
		return actionOperTime;
	}
	
	/**
	 * 设置 操作时间
	 * @param actionOperTime 操作时间
	 * @return 当前对象
	*/
	public UserImport setActionOperTime(Date actionOperTime) {
		this.actionOperTime=actionOperTime;
		return this;
	}
	
	/**
	 * 获得 导入状态<br>
	 * 导入状态
	 * @return 导入状态
	*/
	public String getActionStatus() {
		return actionStatus;
	}
	
	/**
	 * 设置 导入状态
	 * @param actionStatus 导入状态
	 * @return 当前对象
	*/
	public UserImport setActionStatus(String actionStatus) {
		this.actionStatus=actionStatus;
		return this;
	}
	
	/**
	 * 获得 导入结果<br>
	 * 导入结果
	 * @return 导入结果
	*/
	public String getActionMsg() {
		return actionMsg;
	}
	
	/**
	 * 设置 导入结果
	 * @param actionMsg 导入结果
	 * @return 当前对象
	*/
	public UserImport setActionMsg(String actionMsg) {
		this.actionMsg=actionMsg;
		return this;
	}
	
	/**
	 * 获得 姓名<br>
	 * 姓名
	 * @return 姓名
	*/
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 设置 姓名
	 * @param userName 姓名
	 * @return 当前对象
	*/
	public UserImport setUserName(String userName) {
		this.userName=userName;
		return this;
	}
	
	/**
	 * 获得 工号<br>
	 * 工号
	 * @return 工号
	*/
	public String getBadge() {
		return badge;
	}
	
	/**
	 * 设置 工号
	 * @param badge 工号
	 * @return 当前对象
	*/
	public UserImport setBadge(String badge) {
		this.badge=badge;
		return this;
	}
	
	/**
	 * 获得 性别<br>
	 * 性别
	 * @return 性别
	*/
	public String getSex() {
		return sex;
	}
	
	/**
	 * 设置 性别
	 * @param sex 性别
	 * @return 当前对象
	*/
	public UserImport setSex(String sex) {
		this.sex=sex;
		return this;
	}
	
	/**
	 * 获得 性别编码<br>
	 * 性别编码
	 * @return 性别编码
	*/
	public String getSexCode() {
		return sexCode;
	}
	
	/**
	 * 设置 性别编码
	 * @param sexCode 性别编码
	 * @return 当前对象
	*/
	public UserImport setSexCode(String sexCode) {
		this.sexCode=sexCode;
		return this;
	}
	
	/**
	 * 获得 手机号<br>
	 * 手机号
	 * @return 手机号
	*/
	public String getPhone() {
		return phone;
	}
	
	/**
	 * 设置 手机号
	 * @param phone 手机号
	 * @return 当前对象
	*/
	public UserImport setPhone(String phone) {
		this.phone=phone;
		return this;
	}
	
	/**
	 * 获得 组织<br>
	 * 组织
	 * @return 组织
	*/
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * 设置 组织
	 * @param companyName 组织
	 * @return 当前对象
	*/
	public UserImport setCompanyName(String companyName) {
		this.companyName=companyName;
		return this;
	}
	
	/**
	 * 获得 组织ID<br>
	 * 组织ID
	 * @return 组织ID
	*/
	public String getCompanyId() {
		return companyId;
	}
	
	/**
	 * 设置 组织ID
	 * @param companyId 组织ID
	 * @return 当前对象
	*/
	public UserImport setCompanyId(String companyId) {
		this.companyId=companyId;
		return this;
	}
	
	/**
	 * 获得 主岗<br>
	 * 主岗
	 * @return 主岗
	*/
	public String getMasterPost() {
		return masterPost;
	}
	
	/**
	 * 设置 主岗
	 * @param masterPost 主岗
	 * @return 当前对象
	*/
	public UserImport setMasterPost(String masterPost) {
		this.masterPost=masterPost;
		return this;
	}
	
	/**
	 * 获得 主岗ID<br>
	 * 主岗ID
	 * @return 主岗ID
	*/
	public String getMasterPostId() {
		return masterPostId;
	}
	
	/**
	 * 设置 主岗ID
	 * @param masterPostId 主岗ID
	 * @return 当前对象
	*/
	public UserImport setMasterPostId(String masterPostId) {
		this.masterPostId=masterPostId;
		return this;
	}
	
	/**
	 * 获得 身份证<br>
	 * 身份证
	 * @return 身份证
	*/
	public String getIdCard() {
		return idCard;
	}
	
	/**
	 * 设置 身份证
	 * @param idCard 身份证
	 * @return 当前对象
	*/
	public UserImport setIdCard(String idCard) {
		this.idCard=idCard;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 字典代码：employee_status
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
	public UserImport setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 状态编码<br>
	 * 状态编码
	 * @return 状态编码
	*/
	public String getStatusCode() {
		return statusCode;
	}
	
	/**
	 * 设置 状态编码
	 * @param statusCode 状态编码
	 * @return 当前对象
	*/
	public UserImport setStatusCode(String statusCode) {
		this.statusCode=statusCode;
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
	public UserImport setCreateBy(String createBy) {
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
	public UserImport setCreateTime(Date createTime) {
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
	public UserImport setUpdateBy(String updateBy) {
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
	public UserImport setUpdateTime(Date updateTime) {
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
	public UserImport setDeleted(Integer deleted) {
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
	public UserImport setDeleted(Boolean deletedBool) {
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
	public UserImport setDeleteBy(String deleteBy) {
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
	public UserImport setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public UserImport setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return UserImport , 转换好的 UserImport 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return UserImport , 转换好的 PoJo 对象
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
	public UserImport clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public UserImport duplicate(boolean all) {
		com.dt.platform.domain.common.meta.UserImportMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.UserImportMeta.$$proxy$$();
		inst.setIdCard(this.getIdCard());
		inst.setCompanyName(this.getCompanyName());
		inst.setMasterPost(this.getMasterPost());
		inst.setActionStatus(this.getActionStatus());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setActionCode(this.getActionCode());
		inst.setId(this.getId());
		inst.setMasterPostId(this.getMasterPostId());
		inst.setSex(this.getSex());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserName(this.getUserName());
		inst.setVersion(this.getVersion());
		inst.setActionOperTime(this.getActionOperTime());
		inst.setBadge(this.getBadge());
		inst.setSexCode(this.getSexCode());
		inst.setCompanyId(this.getCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPhone(this.getPhone());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setActionMsg(this.getActionMsg());
		inst.setStatus(this.getStatus());
		inst.setStatusCode(this.getStatusCode());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public UserImport clone(boolean deep) {
		return EntityContext.clone(UserImport.class,this,deep);
	}

	/**
	 * 将 Map 转换成 UserImport
	 * @param userImportMap 包含实体信息的 Map 对象
	 * @return UserImport , 转换好的的 UserImport 对象
	*/
	@Transient
	public static UserImport createFrom(Map<String,Object> userImportMap) {
		if(userImportMap==null) return null;
		UserImport po = create();
		EntityContext.copyProperties(po,userImportMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 UserImport
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return UserImport , 转换好的的 UserImport 对象
	*/
	@Transient
	public static UserImport createFrom(Object pojo) {
		if(pojo==null) return null;
		UserImport po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 UserImport，等同于 new
	 * @return UserImport 对象
	*/
	@Transient
	public static UserImport create() {
		return new com.dt.platform.domain.common.meta.UserImportMeta.$$proxy$$();
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
			this.setIdCard(DataParser.parse(String.class, map.get(UserImportMeta.ID_CARD)));
			this.setCompanyName(DataParser.parse(String.class, map.get(UserImportMeta.COMPANY_NAME)));
			this.setMasterPost(DataParser.parse(String.class, map.get(UserImportMeta.MASTER_POST)));
			this.setActionStatus(DataParser.parse(String.class, map.get(UserImportMeta.ACTION_STATUS)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(UserImportMeta.UPDATE_BY)));
			this.setActionCode(DataParser.parse(String.class, map.get(UserImportMeta.ACTION_CODE)));
			this.setId(DataParser.parse(String.class, map.get(UserImportMeta.ID)));
			this.setMasterPostId(DataParser.parse(String.class, map.get(UserImportMeta.MASTER_POST_ID)));
			this.setSex(DataParser.parse(String.class, map.get(UserImportMeta.SEX)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(UserImportMeta.UPDATE_TIME)));
			this.setUserName(DataParser.parse(String.class, map.get(UserImportMeta.USER_NAME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(UserImportMeta.VERSION)));
			this.setActionOperTime(DataParser.parse(Date.class, map.get(UserImportMeta.ACTION_OPER_TIME)));
			this.setBadge(DataParser.parse(String.class, map.get(UserImportMeta.BADGE)));
			this.setSexCode(DataParser.parse(String.class, map.get(UserImportMeta.SEX_CODE)));
			this.setCompanyId(DataParser.parse(String.class, map.get(UserImportMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(UserImportMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(UserImportMeta.DELETED)));
			this.setPhone(DataParser.parse(String.class, map.get(UserImportMeta.PHONE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(UserImportMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(UserImportMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(UserImportMeta.DELETE_BY)));
			this.setActionMsg(DataParser.parse(String.class, map.get(UserImportMeta.ACTION_MSG)));
			this.setStatus(DataParser.parse(String.class, map.get(UserImportMeta.STATUS)));
			this.setStatusCode(DataParser.parse(String.class, map.get(UserImportMeta.STATUS_CODE)));
			// others
			return true;
		} else {
			try {
				this.setIdCard( (String)map.get(UserImportMeta.ID_CARD));
				this.setCompanyName( (String)map.get(UserImportMeta.COMPANY_NAME));
				this.setMasterPost( (String)map.get(UserImportMeta.MASTER_POST));
				this.setActionStatus( (String)map.get(UserImportMeta.ACTION_STATUS));
				this.setUpdateBy( (String)map.get(UserImportMeta.UPDATE_BY));
				this.setActionCode( (String)map.get(UserImportMeta.ACTION_CODE));
				this.setId( (String)map.get(UserImportMeta.ID));
				this.setMasterPostId( (String)map.get(UserImportMeta.MASTER_POST_ID));
				this.setSex( (String)map.get(UserImportMeta.SEX));
				this.setUpdateTime( (Date)map.get(UserImportMeta.UPDATE_TIME));
				this.setUserName( (String)map.get(UserImportMeta.USER_NAME));
				this.setVersion( (Integer)map.get(UserImportMeta.VERSION));
				this.setActionOperTime( (Date)map.get(UserImportMeta.ACTION_OPER_TIME));
				this.setBadge( (String)map.get(UserImportMeta.BADGE));
				this.setSexCode( (String)map.get(UserImportMeta.SEX_CODE));
				this.setCompanyId( (String)map.get(UserImportMeta.COMPANY_ID));
				this.setCreateBy( (String)map.get(UserImportMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(UserImportMeta.DELETED));
				this.setPhone( (String)map.get(UserImportMeta.PHONE));
				this.setCreateTime( (Date)map.get(UserImportMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(UserImportMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(UserImportMeta.DELETE_BY));
				this.setActionMsg( (String)map.get(UserImportMeta.ACTION_MSG));
				this.setStatus( (String)map.get(UserImportMeta.STATUS));
				this.setStatusCode( (String)map.get(UserImportMeta.STATUS_CODE));
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
			this.setIdCard(DataParser.parse(String.class, r.getValue(UserImportMeta.ID_CARD)));
			this.setCompanyName(DataParser.parse(String.class, r.getValue(UserImportMeta.COMPANY_NAME)));
			this.setMasterPost(DataParser.parse(String.class, r.getValue(UserImportMeta.MASTER_POST)));
			this.setActionStatus(DataParser.parse(String.class, r.getValue(UserImportMeta.ACTION_STATUS)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(UserImportMeta.UPDATE_BY)));
			this.setActionCode(DataParser.parse(String.class, r.getValue(UserImportMeta.ACTION_CODE)));
			this.setId(DataParser.parse(String.class, r.getValue(UserImportMeta.ID)));
			this.setMasterPostId(DataParser.parse(String.class, r.getValue(UserImportMeta.MASTER_POST_ID)));
			this.setSex(DataParser.parse(String.class, r.getValue(UserImportMeta.SEX)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(UserImportMeta.UPDATE_TIME)));
			this.setUserName(DataParser.parse(String.class, r.getValue(UserImportMeta.USER_NAME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(UserImportMeta.VERSION)));
			this.setActionOperTime(DataParser.parse(Date.class, r.getValue(UserImportMeta.ACTION_OPER_TIME)));
			this.setBadge(DataParser.parse(String.class, r.getValue(UserImportMeta.BADGE)));
			this.setSexCode(DataParser.parse(String.class, r.getValue(UserImportMeta.SEX_CODE)));
			this.setCompanyId(DataParser.parse(String.class, r.getValue(UserImportMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(UserImportMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(UserImportMeta.DELETED)));
			this.setPhone(DataParser.parse(String.class, r.getValue(UserImportMeta.PHONE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(UserImportMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(UserImportMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(UserImportMeta.DELETE_BY)));
			this.setActionMsg(DataParser.parse(String.class, r.getValue(UserImportMeta.ACTION_MSG)));
			this.setStatus(DataParser.parse(String.class, r.getValue(UserImportMeta.STATUS)));
			this.setStatusCode(DataParser.parse(String.class, r.getValue(UserImportMeta.STATUS_CODE)));
			return true;
		} else {
			try {
				this.setIdCard( (String)r.getValue(UserImportMeta.ID_CARD));
				this.setCompanyName( (String)r.getValue(UserImportMeta.COMPANY_NAME));
				this.setMasterPost( (String)r.getValue(UserImportMeta.MASTER_POST));
				this.setActionStatus( (String)r.getValue(UserImportMeta.ACTION_STATUS));
				this.setUpdateBy( (String)r.getValue(UserImportMeta.UPDATE_BY));
				this.setActionCode( (String)r.getValue(UserImportMeta.ACTION_CODE));
				this.setId( (String)r.getValue(UserImportMeta.ID));
				this.setMasterPostId( (String)r.getValue(UserImportMeta.MASTER_POST_ID));
				this.setSex( (String)r.getValue(UserImportMeta.SEX));
				this.setUpdateTime( (Date)r.getValue(UserImportMeta.UPDATE_TIME));
				this.setUserName( (String)r.getValue(UserImportMeta.USER_NAME));
				this.setVersion( (Integer)r.getValue(UserImportMeta.VERSION));
				this.setActionOperTime( (Date)r.getValue(UserImportMeta.ACTION_OPER_TIME));
				this.setBadge( (String)r.getValue(UserImportMeta.BADGE));
				this.setSexCode( (String)r.getValue(UserImportMeta.SEX_CODE));
				this.setCompanyId( (String)r.getValue(UserImportMeta.COMPANY_ID));
				this.setCreateBy( (String)r.getValue(UserImportMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(UserImportMeta.DELETED));
				this.setPhone( (String)r.getValue(UserImportMeta.PHONE));
				this.setCreateTime( (Date)r.getValue(UserImportMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(UserImportMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(UserImportMeta.DELETE_BY));
				this.setActionMsg( (String)r.getValue(UserImportMeta.ACTION_MSG));
				this.setStatus( (String)r.getValue(UserImportMeta.STATUS));
				this.setStatusCode( (String)r.getValue(UserImportMeta.STATUS_CODE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}