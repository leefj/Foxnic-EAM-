package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_DB_CHANGE_APPLY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.DbChangeApplyMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 数据库变更申请
 * <p>数据库变更申请 , 数据表 ops_db_change_apply 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-31 18:26:51
 * @sign DB23783845DC9F93D8B5E5A4848E0A8C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_db_change_apply")
@ApiModel(description = "数据库变更申请 ; 数据库变更申请 , 数据表 ops_db_change_apply 的PO类型")
public class DbChangeApply extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_DB_CHANGE_APPLY.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "826854976692158464")
	private String id;
	
	/**
	 * 工单编号：工单编号
	*/
	@ApiModelProperty(required = false,value="工单编号" , notes = "工单编号" , example = "host")
	private String itemCode;
	
	/**
	 * 关联工单：关联工单
	*/
	@ApiModelProperty(required = false,value="关联工单" , notes = "关联工单")
	private String itemName;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 数据库：数据库
	*/
	@ApiModelProperty(required = false,value="数据库" , notes = "数据库")
	private String dbFullName;
	
	/**
	 * 数据库：数据库
	*/
	@ApiModelProperty(required = false,value="数据库" , notes = "数据库" , example = "826842666317643776")
	private String dbId;
	
	/**
	 * 数据库IP：数据库IP
	*/
	@ApiModelProperty(required = false,value="数据库IP" , notes = "数据库IP")
	private String dbIp;
	
	/**
	 * 数据库：数据库
	*/
	@ApiModelProperty(required = false,value="数据库" , notes = "数据库")
	private String dbName;
	
	/**
	 * 端口：端口
	*/
	@ApiModelProperty(required = false,value="端口" , notes = "端口")
	private String dbPort;
	
	/**
	 * 数据库用户：数据库用户
	*/
	@ApiModelProperty(required = false,value="数据库用户" , notes = "数据库用户")
	private String dbUser;
	
	/**
	 * 原因：原因
	*/
	@ApiModelProperty(required = false,value="原因" , notes = "原因" , example = "21")
	private String content;
	
	/**
	 * SQL文本：SQL文本
	*/
	@ApiModelProperty(required = false,value="SQL文本" , notes = "SQL文本" , example = "1212")
	private String sqlArea;
	
	/**
	 * 验证结果：验证结果
	*/
	@ApiModelProperty(required = false,value="验证结果" , notes = "验证结果" , example = "none")
	private String checkResult;
	
	/**
	 * 回滚/备份：回滚/备份
	*/
	@ApiModelProperty(required = false,value="回滚/备份" , notes = "回滚/备份" , example = "none")
	private String rbResult;
	
	/**
	 * 推送工单：推送工单
	*/
	@ApiModelProperty(required = false,value="推送工单" , notes = "推送工单")
	private String pushOrderStatus;
	
	/**
	 * 返回信息：返回信息
	*/
	@ApiModelProperty(required = false,value="返回信息" , notes = "返回信息")
	private String pushResult;
	
	/**
	 * 工单编号：工单编号
	*/
	@ApiModelProperty(required = false,value="工单编号" , notes = "工单编号")
	private String orderId;
	
	/**
	 * 申请人：申请人
	*/
	@ApiModelProperty(required = false,value="申请人" , notes = "申请人")
	private String applyUserId;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 关联系统：关联系统
	*/
	@ApiModelProperty(required = false,value="关联系统" , notes = "关联系统")
	private String associatedSystem;
	
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
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-03-31 04:26:29")
	private Date createTime;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * dbInfoApply：dbInfoApply
	*/
	@ApiModelProperty(required = false,value="dbInfoApply" , notes = "dbInfoApply")
	private DbInfoApply dbInfoApply;
	
	/**
	 * applyUser：applyUser
	*/
	@ApiModelProperty(required = false,value="applyUser" , notes = "applyUser")
	private Employee applyUser;
	
	/**
	 * requestOrder：requestOrder
	*/
	@ApiModelProperty(required = false,value="requestOrder" , notes = "requestOrder")
	private DbApplyExecute requestOrder;
	
	/**
	 * buttonCheck：buttonCheck
	*/
	@ApiModelProperty(required = false,value="buttonCheck" , notes = "buttonCheck")
	private String buttonCheck;
	
	/**
	 * buttonCheckDetail：buttonCheckDetail
	*/
	@ApiModelProperty(required = false,value="buttonCheckDetail" , notes = "buttonCheckDetail")
	private String buttonCheckDetail;
	
	/**
	 * buttonRB：buttonRB
	*/
	@ApiModelProperty(required = false,value="buttonRB" , notes = "buttonRB")
	private String buttonRB;
	
	/**
	 * buttonRBDetail：buttonRBDetail
	*/
	@ApiModelProperty(required = false,value="buttonRBDetail" , notes = "buttonRBDetail")
	private String buttonRBDetail;
	
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
	public DbChangeApply setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 工单编号<br>
	 * 工单编号
	 * @return 工单编号
	*/
	public String getItemCode() {
		return itemCode;
	}
	
	/**
	 * 设置 工单编号
	 * @param itemCode 工单编号
	 * @return 当前对象
	*/
	public DbChangeApply setItemCode(String itemCode) {
		this.itemCode=itemCode;
		return this;
	}
	
	/**
	 * 获得 关联工单<br>
	 * 关联工单
	 * @return 关联工单
	*/
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * 设置 关联工单
	 * @param itemName 关联工单
	 * @return 当前对象
	*/
	public DbChangeApply setItemName(String itemName) {
		this.itemName=itemName;
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
	public DbChangeApply setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 数据库<br>
	 * 数据库
	 * @return 数据库
	*/
	public String getDbFullName() {
		return dbFullName;
	}
	
	/**
	 * 设置 数据库
	 * @param dbFullName 数据库
	 * @return 当前对象
	*/
	public DbChangeApply setDbFullName(String dbFullName) {
		this.dbFullName=dbFullName;
		return this;
	}
	
	/**
	 * 获得 数据库<br>
	 * 数据库
	 * @return 数据库
	*/
	public String getDbId() {
		return dbId;
	}
	
	/**
	 * 设置 数据库
	 * @param dbId 数据库
	 * @return 当前对象
	*/
	public DbChangeApply setDbId(String dbId) {
		this.dbId=dbId;
		return this;
	}
	
	/**
	 * 获得 数据库IP<br>
	 * 数据库IP
	 * @return 数据库IP
	*/
	public String getDbIp() {
		return dbIp;
	}
	
	/**
	 * 设置 数据库IP
	 * @param dbIp 数据库IP
	 * @return 当前对象
	*/
	public DbChangeApply setDbIp(String dbIp) {
		this.dbIp=dbIp;
		return this;
	}
	
	/**
	 * 获得 数据库<br>
	 * 数据库
	 * @return 数据库
	*/
	public String getDbName() {
		return dbName;
	}
	
	/**
	 * 设置 数据库
	 * @param dbName 数据库
	 * @return 当前对象
	*/
	public DbChangeApply setDbName(String dbName) {
		this.dbName=dbName;
		return this;
	}
	
	/**
	 * 获得 端口<br>
	 * 端口
	 * @return 端口
	*/
	public String getDbPort() {
		return dbPort;
	}
	
	/**
	 * 设置 端口
	 * @param dbPort 端口
	 * @return 当前对象
	*/
	public DbChangeApply setDbPort(String dbPort) {
		this.dbPort=dbPort;
		return this;
	}
	
	/**
	 * 获得 数据库用户<br>
	 * 数据库用户
	 * @return 数据库用户
	*/
	public String getDbUser() {
		return dbUser;
	}
	
	/**
	 * 设置 数据库用户
	 * @param dbUser 数据库用户
	 * @return 当前对象
	*/
	public DbChangeApply setDbUser(String dbUser) {
		this.dbUser=dbUser;
		return this;
	}
	
	/**
	 * 获得 原因<br>
	 * 原因
	 * @return 原因
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 原因
	 * @param content 原因
	 * @return 当前对象
	*/
	public DbChangeApply setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 SQL文本<br>
	 * SQL文本
	 * @return SQL文本
	*/
	public String getSqlArea() {
		return sqlArea;
	}
	
	/**
	 * 设置 SQL文本
	 * @param sqlArea SQL文本
	 * @return 当前对象
	*/
	public DbChangeApply setSqlArea(String sqlArea) {
		this.sqlArea=sqlArea;
		return this;
	}
	
	/**
	 * 获得 验证结果<br>
	 * 验证结果
	 * @return 验证结果
	*/
	public String getCheckResult() {
		return checkResult;
	}
	
	/**
	 * 设置 验证结果
	 * @param checkResult 验证结果
	 * @return 当前对象
	*/
	public DbChangeApply setCheckResult(String checkResult) {
		this.checkResult=checkResult;
		return this;
	}
	
	/**
	 * 获得 回滚/备份<br>
	 * 回滚/备份
	 * @return 回滚/备份
	*/
	public String getRbResult() {
		return rbResult;
	}
	
	/**
	 * 设置 回滚/备份
	 * @param rbResult 回滚/备份
	 * @return 当前对象
	*/
	public DbChangeApply setRbResult(String rbResult) {
		this.rbResult=rbResult;
		return this;
	}
	
	/**
	 * 获得 推送工单<br>
	 * 推送工单
	 * @return 推送工单
	*/
	public String getPushOrderStatus() {
		return pushOrderStatus;
	}
	
	/**
	 * 设置 推送工单
	 * @param pushOrderStatus 推送工单
	 * @return 当前对象
	*/
	public DbChangeApply setPushOrderStatus(String pushOrderStatus) {
		this.pushOrderStatus=pushOrderStatus;
		return this;
	}
	
	/**
	 * 获得 返回信息<br>
	 * 返回信息
	 * @return 返回信息
	*/
	public String getPushResult() {
		return pushResult;
	}
	
	/**
	 * 设置 返回信息
	 * @param pushResult 返回信息
	 * @return 当前对象
	*/
	public DbChangeApply setPushResult(String pushResult) {
		this.pushResult=pushResult;
		return this;
	}
	
	/**
	 * 获得 工单编号<br>
	 * 工单编号
	 * @return 工单编号
	*/
	public String getOrderId() {
		return orderId;
	}
	
	/**
	 * 设置 工单编号
	 * @param orderId 工单编号
	 * @return 当前对象
	*/
	public DbChangeApply setOrderId(String orderId) {
		this.orderId=orderId;
		return this;
	}
	
	/**
	 * 获得 申请人<br>
	 * 申请人
	 * @return 申请人
	*/
	public String getApplyUserId() {
		return applyUserId;
	}
	
	/**
	 * 设置 申请人
	 * @param applyUserId 申请人
	 * @return 当前对象
	*/
	public DbChangeApply setApplyUserId(String applyUserId) {
		this.applyUserId=applyUserId;
		return this;
	}
	
	/**
	 * 获得 选择<br>
	 * 选择
	 * @return 选择
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择
	 * @param selectedCode 选择
	 * @return 当前对象
	*/
	public DbChangeApply setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public DbChangeApply setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 关联系统<br>
	 * 关联系统
	 * @return 关联系统
	*/
	public String getAssociatedSystem() {
		return associatedSystem;
	}
	
	/**
	 * 设置 关联系统
	 * @param associatedSystem 关联系统
	 * @return 当前对象
	*/
	public DbChangeApply setAssociatedSystem(String associatedSystem) {
		this.associatedSystem=associatedSystem;
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
	public DbChangeApply setUpdateBy(String updateBy) {
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
	public DbChangeApply setUpdateTime(Date updateTime) {
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
	public DbChangeApply setDeleted(Integer deleted) {
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
	public DbChangeApply setDeleted(Boolean deletedBool) {
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
	public DbChangeApply setDeleteBy(String deleteBy) {
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
	public DbChangeApply setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public DbChangeApply setCreateBy(String createBy) {
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
	public DbChangeApply setCreateTime(Date createTime) {
		this.createTime=createTime;
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
	public DbChangeApply setVersion(Integer version) {
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
	public DbChangeApply setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 dbInfoApply<br>
	 * dbInfoApply
	 * @return dbInfoApply
	*/
	public DbInfoApply getDbInfoApply() {
		return dbInfoApply;
	}
	
	/**
	 * 设置 dbInfoApply
	 * @param dbInfoApply dbInfoApply
	 * @return 当前对象
	*/
	public DbChangeApply setDbInfoApply(DbInfoApply dbInfoApply) {
		this.dbInfoApply=dbInfoApply;
		return this;
	}
	
	/**
	 * 获得 applyUser<br>
	 * applyUser
	 * @return applyUser
	*/
	public Employee getApplyUser() {
		return applyUser;
	}
	
	/**
	 * 设置 applyUser
	 * @param applyUser applyUser
	 * @return 当前对象
	*/
	public DbChangeApply setApplyUser(Employee applyUser) {
		this.applyUser=applyUser;
		return this;
	}
	
	/**
	 * 获得 requestOrder<br>
	 * requestOrder
	 * @return requestOrder
	*/
	public DbApplyExecute getRequestOrder() {
		return requestOrder;
	}
	
	/**
	 * 设置 requestOrder
	 * @param requestOrder requestOrder
	 * @return 当前对象
	*/
	public DbChangeApply setRequestOrder(DbApplyExecute requestOrder) {
		this.requestOrder=requestOrder;
		return this;
	}
	
	/**
	 * 获得 buttonCheck<br>
	 * buttonCheck
	 * @return buttonCheck
	*/
	public String getButtonCheck() {
		return buttonCheck;
	}
	
	/**
	 * 设置 buttonCheck
	 * @param buttonCheck buttonCheck
	 * @return 当前对象
	*/
	public DbChangeApply setButtonCheck(String buttonCheck) {
		this.buttonCheck=buttonCheck;
		return this;
	}
	
	/**
	 * 获得 buttonCheckDetail<br>
	 * buttonCheckDetail
	 * @return buttonCheckDetail
	*/
	public String getButtonCheckDetail() {
		return buttonCheckDetail;
	}
	
	/**
	 * 设置 buttonCheckDetail
	 * @param buttonCheckDetail buttonCheckDetail
	 * @return 当前对象
	*/
	public DbChangeApply setButtonCheckDetail(String buttonCheckDetail) {
		this.buttonCheckDetail=buttonCheckDetail;
		return this;
	}
	
	/**
	 * 获得 buttonRB<br>
	 * buttonRB
	 * @return buttonRB
	*/
	public String getButtonRB() {
		return buttonRB;
	}
	
	/**
	 * 设置 buttonRB
	 * @param buttonRB buttonRB
	 * @return 当前对象
	*/
	public DbChangeApply setButtonRB(String buttonRB) {
		this.buttonRB=buttonRB;
		return this;
	}
	
	/**
	 * 获得 buttonRBDetail<br>
	 * buttonRBDetail
	 * @return buttonRBDetail
	*/
	public String getButtonRBDetail() {
		return buttonRBDetail;
	}
	
	/**
	 * 设置 buttonRBDetail
	 * @param buttonRBDetail buttonRBDetail
	 * @return 当前对象
	*/
	public DbChangeApply setButtonRBDetail(String buttonRBDetail) {
		this.buttonRBDetail=buttonRBDetail;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DbChangeApply , 转换好的 DbChangeApply 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbChangeApply , 转换好的 PoJo 对象
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
	public DbChangeApply clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DbChangeApply duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DbChangeApplyMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DbChangeApplyMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setOrderId(this.getOrderId());
		inst.setItemCode(this.getItemCode());
		inst.setDbName(this.getDbName());
		inst.setDbFullName(this.getDbFullName());
		inst.setCheckResult(this.getCheckResult());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setApplyUserId(this.getApplyUserId());
		inst.setItemName(this.getItemName());
		inst.setPushOrderStatus(this.getPushOrderStatus());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDbId(this.getDbId());
		inst.setDbUser(this.getDbUser());
		inst.setId(this.getId());
		inst.setPushResult(this.getPushResult());
		inst.setSqlArea(this.getSqlArea());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setDbIp(this.getDbIp());
		inst.setVersion(this.getVersion());
		inst.setDbPort(this.getDbPort());
		inst.setAssociatedSystem(this.getAssociatedSystem());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCreateTime(this.getCreateTime());
		inst.setRbResult(this.getRbResult());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setButtonRBDetail(this.getButtonRBDetail());
			inst.setApplyUser(this.getApplyUser());
			inst.setDbInfoApply(this.getDbInfoApply());
			inst.setRequestOrder(this.getRequestOrder());
			inst.setButtonCheck(this.getButtonCheck());
			inst.setButtonCheckDetail(this.getButtonCheckDetail());
			inst.setButtonRB(this.getButtonRB());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DbChangeApply clone(boolean deep) {
		return EntityContext.clone(DbChangeApply.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbChangeApply
	 * @param dbChangeApplyMap 包含实体信息的 Map 对象
	 * @return DbChangeApply , 转换好的的 DbChangeApply 对象
	*/
	@Transient
	public static DbChangeApply createFrom(Map<String,Object> dbChangeApplyMap) {
		if(dbChangeApplyMap==null) return null;
		DbChangeApply po = create();
		EntityContext.copyProperties(po,dbChangeApplyMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DbChangeApply
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbChangeApply , 转换好的的 DbChangeApply 对象
	*/
	@Transient
	public static DbChangeApply createFrom(Object pojo) {
		if(pojo==null) return null;
		DbChangeApply po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DbChangeApply，等同于 new
	 * @return DbChangeApply 对象
	*/
	@Transient
	public static DbChangeApply create() {
		return new com.dt.platform.domain.ops.meta.DbChangeApplyMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(DbChangeApplyMeta.NOTES)));
			this.setOrderId(DataParser.parse(String.class, map.get(DbChangeApplyMeta.ORDER_ID)));
			this.setItemCode(DataParser.parse(String.class, map.get(DbChangeApplyMeta.ITEM_CODE)));
			this.setDbName(DataParser.parse(String.class, map.get(DbChangeApplyMeta.DB_NAME)));
			this.setDbFullName(DataParser.parse(String.class, map.get(DbChangeApplyMeta.DB_FULL_NAME)));
			this.setCheckResult(DataParser.parse(String.class, map.get(DbChangeApplyMeta.CHECK_RESULT)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(DbChangeApplyMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(DbChangeApplyMeta.CONTENT)));
			this.setApplyUserId(DataParser.parse(String.class, map.get(DbChangeApplyMeta.APPLY_USER_ID)));
			this.setItemName(DataParser.parse(String.class, map.get(DbChangeApplyMeta.ITEM_NAME)));
			this.setPushOrderStatus(DataParser.parse(String.class, map.get(DbChangeApplyMeta.PUSH_ORDER_STATUS)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DbChangeApplyMeta.UPDATE_BY)));
			this.setDbId(DataParser.parse(String.class, map.get(DbChangeApplyMeta.DB_ID)));
			this.setDbUser(DataParser.parse(String.class, map.get(DbChangeApplyMeta.DB_USER)));
			this.setId(DataParser.parse(String.class, map.get(DbChangeApplyMeta.ID)));
			this.setPushResult(DataParser.parse(String.class, map.get(DbChangeApplyMeta.PUSH_RESULT)));
			this.setSqlArea(DataParser.parse(String.class, map.get(DbChangeApplyMeta.SQL_AREA)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DbChangeApplyMeta.UPDATE_TIME)));
			this.setDbIp(DataParser.parse(String.class, map.get(DbChangeApplyMeta.DB_IP)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DbChangeApplyMeta.VERSION)));
			this.setDbPort(DataParser.parse(String.class, map.get(DbChangeApplyMeta.DB_PORT)));
			this.setAssociatedSystem(DataParser.parse(String.class, map.get(DbChangeApplyMeta.ASSOCIATED_SYSTEM)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DbChangeApplyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DbChangeApplyMeta.DELETED)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DbChangeApplyMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DbChangeApplyMeta.CREATE_TIME)));
			this.setRbResult(DataParser.parse(String.class, map.get(DbChangeApplyMeta.RB_RESULT)));
			this.setTenantId(DataParser.parse(String.class, map.get(DbChangeApplyMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DbChangeApplyMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(DbChangeApplyMeta.STATUS)));
			// others
			this.setButtonRBDetail(DataParser.parse(String.class, map.get(DbChangeApplyMeta.BUTTON_RB_DETAIL)));
			this.setApplyUser(DataParser.parse(Employee.class, map.get(DbChangeApplyMeta.APPLY_USER)));
			this.setDbInfoApply(DataParser.parse(DbInfoApply.class, map.get(DbChangeApplyMeta.DB_INFO_APPLY)));
			this.setRequestOrder(DataParser.parse(DbApplyExecute.class, map.get(DbChangeApplyMeta.REQUEST_ORDER)));
			this.setButtonCheck(DataParser.parse(String.class, map.get(DbChangeApplyMeta.BUTTON_CHECK)));
			this.setButtonCheckDetail(DataParser.parse(String.class, map.get(DbChangeApplyMeta.BUTTON_CHECK_DETAIL)));
			this.setButtonRB(DataParser.parse(String.class, map.get(DbChangeApplyMeta.BUTTON_RB)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(DbChangeApplyMeta.NOTES));
				this.setOrderId( (String)map.get(DbChangeApplyMeta.ORDER_ID));
				this.setItemCode( (String)map.get(DbChangeApplyMeta.ITEM_CODE));
				this.setDbName( (String)map.get(DbChangeApplyMeta.DB_NAME));
				this.setDbFullName( (String)map.get(DbChangeApplyMeta.DB_FULL_NAME));
				this.setCheckResult( (String)map.get(DbChangeApplyMeta.CHECK_RESULT));
				this.setSelectedCode( (String)map.get(DbChangeApplyMeta.SELECTED_CODE));
				this.setContent( (String)map.get(DbChangeApplyMeta.CONTENT));
				this.setApplyUserId( (String)map.get(DbChangeApplyMeta.APPLY_USER_ID));
				this.setItemName( (String)map.get(DbChangeApplyMeta.ITEM_NAME));
				this.setPushOrderStatus( (String)map.get(DbChangeApplyMeta.PUSH_ORDER_STATUS));
				this.setUpdateBy( (String)map.get(DbChangeApplyMeta.UPDATE_BY));
				this.setDbId( (String)map.get(DbChangeApplyMeta.DB_ID));
				this.setDbUser( (String)map.get(DbChangeApplyMeta.DB_USER));
				this.setId( (String)map.get(DbChangeApplyMeta.ID));
				this.setPushResult( (String)map.get(DbChangeApplyMeta.PUSH_RESULT));
				this.setSqlArea( (String)map.get(DbChangeApplyMeta.SQL_AREA));
				this.setUpdateTime( (Date)map.get(DbChangeApplyMeta.UPDATE_TIME));
				this.setDbIp( (String)map.get(DbChangeApplyMeta.DB_IP));
				this.setVersion( (Integer)map.get(DbChangeApplyMeta.VERSION));
				this.setDbPort( (String)map.get(DbChangeApplyMeta.DB_PORT));
				this.setAssociatedSystem( (String)map.get(DbChangeApplyMeta.ASSOCIATED_SYSTEM));
				this.setCreateBy( (String)map.get(DbChangeApplyMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DbChangeApplyMeta.DELETED));
				this.setDeleteTime( (Date)map.get(DbChangeApplyMeta.DELETE_TIME));
				this.setCreateTime( (Date)map.get(DbChangeApplyMeta.CREATE_TIME));
				this.setRbResult( (String)map.get(DbChangeApplyMeta.RB_RESULT));
				this.setTenantId( (String)map.get(DbChangeApplyMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(DbChangeApplyMeta.DELETE_BY));
				this.setStatus( (String)map.get(DbChangeApplyMeta.STATUS));
				// others
				this.setButtonRBDetail( (String)map.get(DbChangeApplyMeta.BUTTON_RB_DETAIL));
				this.setApplyUser( (Employee)map.get(DbChangeApplyMeta.APPLY_USER));
				this.setDbInfoApply( (DbInfoApply)map.get(DbChangeApplyMeta.DB_INFO_APPLY));
				this.setRequestOrder( (DbApplyExecute)map.get(DbChangeApplyMeta.REQUEST_ORDER));
				this.setButtonCheck( (String)map.get(DbChangeApplyMeta.BUTTON_CHECK));
				this.setButtonCheckDetail( (String)map.get(DbChangeApplyMeta.BUTTON_CHECK_DETAIL));
				this.setButtonRB( (String)map.get(DbChangeApplyMeta.BUTTON_RB));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.NOTES)));
			this.setOrderId(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.ORDER_ID)));
			this.setItemCode(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.ITEM_CODE)));
			this.setDbName(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.DB_NAME)));
			this.setDbFullName(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.DB_FULL_NAME)));
			this.setCheckResult(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.CHECK_RESULT)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.CONTENT)));
			this.setApplyUserId(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.APPLY_USER_ID)));
			this.setItemName(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.ITEM_NAME)));
			this.setPushOrderStatus(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.PUSH_ORDER_STATUS)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.UPDATE_BY)));
			this.setDbId(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.DB_ID)));
			this.setDbUser(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.DB_USER)));
			this.setId(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.ID)));
			this.setPushResult(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.PUSH_RESULT)));
			this.setSqlArea(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.SQL_AREA)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DbChangeApplyMeta.UPDATE_TIME)));
			this.setDbIp(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.DB_IP)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DbChangeApplyMeta.VERSION)));
			this.setDbPort(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.DB_PORT)));
			this.setAssociatedSystem(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.ASSOCIATED_SYSTEM)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DbChangeApplyMeta.DELETED)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DbChangeApplyMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DbChangeApplyMeta.CREATE_TIME)));
			this.setRbResult(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.RB_RESULT)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(DbChangeApplyMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(DbChangeApplyMeta.NOTES));
				this.setOrderId( (String)r.getValue(DbChangeApplyMeta.ORDER_ID));
				this.setItemCode( (String)r.getValue(DbChangeApplyMeta.ITEM_CODE));
				this.setDbName( (String)r.getValue(DbChangeApplyMeta.DB_NAME));
				this.setDbFullName( (String)r.getValue(DbChangeApplyMeta.DB_FULL_NAME));
				this.setCheckResult( (String)r.getValue(DbChangeApplyMeta.CHECK_RESULT));
				this.setSelectedCode( (String)r.getValue(DbChangeApplyMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(DbChangeApplyMeta.CONTENT));
				this.setApplyUserId( (String)r.getValue(DbChangeApplyMeta.APPLY_USER_ID));
				this.setItemName( (String)r.getValue(DbChangeApplyMeta.ITEM_NAME));
				this.setPushOrderStatus( (String)r.getValue(DbChangeApplyMeta.PUSH_ORDER_STATUS));
				this.setUpdateBy( (String)r.getValue(DbChangeApplyMeta.UPDATE_BY));
				this.setDbId( (String)r.getValue(DbChangeApplyMeta.DB_ID));
				this.setDbUser( (String)r.getValue(DbChangeApplyMeta.DB_USER));
				this.setId( (String)r.getValue(DbChangeApplyMeta.ID));
				this.setPushResult( (String)r.getValue(DbChangeApplyMeta.PUSH_RESULT));
				this.setSqlArea( (String)r.getValue(DbChangeApplyMeta.SQL_AREA));
				this.setUpdateTime( (Date)r.getValue(DbChangeApplyMeta.UPDATE_TIME));
				this.setDbIp( (String)r.getValue(DbChangeApplyMeta.DB_IP));
				this.setVersion( (Integer)r.getValue(DbChangeApplyMeta.VERSION));
				this.setDbPort( (String)r.getValue(DbChangeApplyMeta.DB_PORT));
				this.setAssociatedSystem( (String)r.getValue(DbChangeApplyMeta.ASSOCIATED_SYSTEM));
				this.setCreateBy( (String)r.getValue(DbChangeApplyMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DbChangeApplyMeta.DELETED));
				this.setDeleteTime( (Date)r.getValue(DbChangeApplyMeta.DELETE_TIME));
				this.setCreateTime( (Date)r.getValue(DbChangeApplyMeta.CREATE_TIME));
				this.setRbResult( (String)r.getValue(DbChangeApplyMeta.RB_RESULT));
				this.setTenantId( (String)r.getValue(DbChangeApplyMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(DbChangeApplyMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(DbChangeApplyMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}