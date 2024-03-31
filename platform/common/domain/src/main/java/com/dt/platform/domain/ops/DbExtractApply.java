package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_DB_EXTRACT_APPLY;
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
import com.dt.platform.domain.ops.meta.DbExtractApplyMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 数据库提取申请
 * <p>数据库提取申请 , 数据表 ops_db_extract_apply 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-31 18:45:09
 * @sign F586A7460DDDE757DDF6E057774F2663
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_db_extract_apply")
@ApiModel(description = "数据库提取申请 ; 数据库提取申请 , 数据表 ops_db_extract_apply 的PO类型")
public class DbExtractApply extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_DB_EXTRACT_APPLY.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 工单编号：工单编号
	*/
	@ApiModelProperty(required = false,value="工单编号" , notes = "工单编号")
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
	@ApiModelProperty(required = false,value="数据库" , notes = "数据库")
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
	@ApiModelProperty(required = false,value="原因" , notes = "原因")
	private String content;
	
	/**
	 * SQL文本1：SQL文本1
	*/
	@ApiModelProperty(required = false,value="SQL文本1" , notes = "SQL文本1")
	private String sqlArea;
	
	/**
	 * SQL文本2：SQL文本2
	*/
	@ApiModelProperty(required = false,value="SQL文本2" , notes = "SQL文本2")
	private String sqlArea2;
	
	/**
	 * SQL文本3：SQL文本3
	*/
	@ApiModelProperty(required = false,value="SQL文本3" , notes = "SQL文本3")
	private String sqlArea3;
	
	/**
	 * SQL文本4：SQL文本4
	*/
	@ApiModelProperty(required = false,value="SQL文本4" , notes = "SQL文本4")
	private String sqlArea4;
	
	/**
	 * SQL文本5：SQL文本5
	*/
	@ApiModelProperty(required = false,value="SQL文本5" , notes = "SQL文本5")
	private String sqlArea5;
	
	/**
	 * 验证结果：验证结果
	*/
	@ApiModelProperty(required = false,value="验证结果" , notes = "验证结果")
	private String checkResult;
	
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
	public DbExtractApply setId(String id) {
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
	public DbExtractApply setItemCode(String itemCode) {
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
	public DbExtractApply setItemName(String itemName) {
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
	public DbExtractApply setStatus(String status) {
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
	public DbExtractApply setDbFullName(String dbFullName) {
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
	public DbExtractApply setDbId(String dbId) {
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
	public DbExtractApply setDbIp(String dbIp) {
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
	public DbExtractApply setDbName(String dbName) {
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
	public DbExtractApply setDbPort(String dbPort) {
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
	public DbExtractApply setDbUser(String dbUser) {
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
	public DbExtractApply setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 SQL文本1<br>
	 * SQL文本1
	 * @return SQL文本1
	*/
	public String getSqlArea() {
		return sqlArea;
	}
	
	/**
	 * 设置 SQL文本1
	 * @param sqlArea SQL文本1
	 * @return 当前对象
	*/
	public DbExtractApply setSqlArea(String sqlArea) {
		this.sqlArea=sqlArea;
		return this;
	}
	
	/**
	 * 获得 SQL文本2<br>
	 * SQL文本2
	 * @return SQL文本2
	*/
	public String getSqlArea2() {
		return sqlArea2;
	}
	
	/**
	 * 设置 SQL文本2
	 * @param sqlArea2 SQL文本2
	 * @return 当前对象
	*/
	public DbExtractApply setSqlArea2(String sqlArea2) {
		this.sqlArea2=sqlArea2;
		return this;
	}
	
	/**
	 * 获得 SQL文本3<br>
	 * SQL文本3
	 * @return SQL文本3
	*/
	public String getSqlArea3() {
		return sqlArea3;
	}
	
	/**
	 * 设置 SQL文本3
	 * @param sqlArea3 SQL文本3
	 * @return 当前对象
	*/
	public DbExtractApply setSqlArea3(String sqlArea3) {
		this.sqlArea3=sqlArea3;
		return this;
	}
	
	/**
	 * 获得 SQL文本4<br>
	 * SQL文本4
	 * @return SQL文本4
	*/
	public String getSqlArea4() {
		return sqlArea4;
	}
	
	/**
	 * 设置 SQL文本4
	 * @param sqlArea4 SQL文本4
	 * @return 当前对象
	*/
	public DbExtractApply setSqlArea4(String sqlArea4) {
		this.sqlArea4=sqlArea4;
		return this;
	}
	
	/**
	 * 获得 SQL文本5<br>
	 * SQL文本5
	 * @return SQL文本5
	*/
	public String getSqlArea5() {
		return sqlArea5;
	}
	
	/**
	 * 设置 SQL文本5
	 * @param sqlArea5 SQL文本5
	 * @return 当前对象
	*/
	public DbExtractApply setSqlArea5(String sqlArea5) {
		this.sqlArea5=sqlArea5;
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
	public DbExtractApply setCheckResult(String checkResult) {
		this.checkResult=checkResult;
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
	public DbExtractApply setPushOrderStatus(String pushOrderStatus) {
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
	public DbExtractApply setPushResult(String pushResult) {
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
	public DbExtractApply setOrderId(String orderId) {
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
	public DbExtractApply setApplyUserId(String applyUserId) {
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
	public DbExtractApply setSelectedCode(String selectedCode) {
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
	public DbExtractApply setNotes(String notes) {
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
	public DbExtractApply setAssociatedSystem(String associatedSystem) {
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
	public DbExtractApply setUpdateBy(String updateBy) {
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
	public DbExtractApply setUpdateTime(Date updateTime) {
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
	public DbExtractApply setDeleted(Integer deleted) {
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
	public DbExtractApply setDeleted(Boolean deletedBool) {
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
	public DbExtractApply setDeleteBy(String deleteBy) {
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
	public DbExtractApply setDeleteTime(Date deleteTime) {
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
	public DbExtractApply setCreateBy(String createBy) {
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
	public DbExtractApply setCreateTime(Date createTime) {
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
	public DbExtractApply setVersion(Integer version) {
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
	public DbExtractApply setTenantId(String tenantId) {
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
	public DbExtractApply setDbInfoApply(DbInfoApply dbInfoApply) {
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
	public DbExtractApply setApplyUser(Employee applyUser) {
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
	public DbExtractApply setRequestOrder(DbApplyExecute requestOrder) {
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
	public DbExtractApply setButtonCheck(String buttonCheck) {
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
	public DbExtractApply setButtonCheckDetail(String buttonCheckDetail) {
		this.buttonCheckDetail=buttonCheckDetail;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DbExtractApply , 转换好的 DbExtractApply 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbExtractApply , 转换好的 PoJo 对象
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
	public DbExtractApply clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DbExtractApply duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DbExtractApplyMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DbExtractApplyMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setSqlArea3(this.getSqlArea3());
		inst.setSqlArea4(this.getSqlArea4());
		inst.setOrderId(this.getOrderId());
		inst.setSqlArea5(this.getSqlArea5());
		inst.setItemCode(this.getItemCode());
		inst.setDbName(this.getDbName());
		inst.setDbFullName(this.getDbFullName());
		inst.setSqlArea2(this.getSqlArea2());
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
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setApplyUser(this.getApplyUser());
			inst.setDbInfoApply(this.getDbInfoApply());
			inst.setRequestOrder(this.getRequestOrder());
			inst.setButtonCheck(this.getButtonCheck());
			inst.setButtonCheckDetail(this.getButtonCheckDetail());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DbExtractApply clone(boolean deep) {
		return EntityContext.clone(DbExtractApply.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbExtractApply
	 * @param dbExtractApplyMap 包含实体信息的 Map 对象
	 * @return DbExtractApply , 转换好的的 DbExtractApply 对象
	*/
	@Transient
	public static DbExtractApply createFrom(Map<String,Object> dbExtractApplyMap) {
		if(dbExtractApplyMap==null) return null;
		DbExtractApply po = create();
		EntityContext.copyProperties(po,dbExtractApplyMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DbExtractApply
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbExtractApply , 转换好的的 DbExtractApply 对象
	*/
	@Transient
	public static DbExtractApply createFrom(Object pojo) {
		if(pojo==null) return null;
		DbExtractApply po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DbExtractApply，等同于 new
	 * @return DbExtractApply 对象
	*/
	@Transient
	public static DbExtractApply create() {
		return new com.dt.platform.domain.ops.meta.DbExtractApplyMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(DbExtractApplyMeta.NOTES)));
			this.setSqlArea3(DataParser.parse(String.class, map.get(DbExtractApplyMeta.SQL_AREA3)));
			this.setSqlArea4(DataParser.parse(String.class, map.get(DbExtractApplyMeta.SQL_AREA4)));
			this.setOrderId(DataParser.parse(String.class, map.get(DbExtractApplyMeta.ORDER_ID)));
			this.setSqlArea5(DataParser.parse(String.class, map.get(DbExtractApplyMeta.SQL_AREA5)));
			this.setItemCode(DataParser.parse(String.class, map.get(DbExtractApplyMeta.ITEM_CODE)));
			this.setDbName(DataParser.parse(String.class, map.get(DbExtractApplyMeta.DB_NAME)));
			this.setDbFullName(DataParser.parse(String.class, map.get(DbExtractApplyMeta.DB_FULL_NAME)));
			this.setSqlArea2(DataParser.parse(String.class, map.get(DbExtractApplyMeta.SQL_AREA2)));
			this.setCheckResult(DataParser.parse(String.class, map.get(DbExtractApplyMeta.CHECK_RESULT)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(DbExtractApplyMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(DbExtractApplyMeta.CONTENT)));
			this.setApplyUserId(DataParser.parse(String.class, map.get(DbExtractApplyMeta.APPLY_USER_ID)));
			this.setItemName(DataParser.parse(String.class, map.get(DbExtractApplyMeta.ITEM_NAME)));
			this.setPushOrderStatus(DataParser.parse(String.class, map.get(DbExtractApplyMeta.PUSH_ORDER_STATUS)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DbExtractApplyMeta.UPDATE_BY)));
			this.setDbId(DataParser.parse(String.class, map.get(DbExtractApplyMeta.DB_ID)));
			this.setDbUser(DataParser.parse(String.class, map.get(DbExtractApplyMeta.DB_USER)));
			this.setId(DataParser.parse(String.class, map.get(DbExtractApplyMeta.ID)));
			this.setPushResult(DataParser.parse(String.class, map.get(DbExtractApplyMeta.PUSH_RESULT)));
			this.setSqlArea(DataParser.parse(String.class, map.get(DbExtractApplyMeta.SQL_AREA)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DbExtractApplyMeta.UPDATE_TIME)));
			this.setDbIp(DataParser.parse(String.class, map.get(DbExtractApplyMeta.DB_IP)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DbExtractApplyMeta.VERSION)));
			this.setDbPort(DataParser.parse(String.class, map.get(DbExtractApplyMeta.DB_PORT)));
			this.setAssociatedSystem(DataParser.parse(String.class, map.get(DbExtractApplyMeta.ASSOCIATED_SYSTEM)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DbExtractApplyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DbExtractApplyMeta.DELETED)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DbExtractApplyMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DbExtractApplyMeta.CREATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(DbExtractApplyMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DbExtractApplyMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(DbExtractApplyMeta.STATUS)));
			// others
			this.setApplyUser(DataParser.parse(Employee.class, map.get(DbExtractApplyMeta.APPLY_USER)));
			this.setDbInfoApply(DataParser.parse(DbInfoApply.class, map.get(DbExtractApplyMeta.DB_INFO_APPLY)));
			this.setRequestOrder(DataParser.parse(DbApplyExecute.class, map.get(DbExtractApplyMeta.REQUEST_ORDER)));
			this.setButtonCheck(DataParser.parse(String.class, map.get(DbExtractApplyMeta.BUTTON_CHECK)));
			this.setButtonCheckDetail(DataParser.parse(String.class, map.get(DbExtractApplyMeta.BUTTON_CHECK_DETAIL)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(DbExtractApplyMeta.NOTES));
				this.setSqlArea3( (String)map.get(DbExtractApplyMeta.SQL_AREA3));
				this.setSqlArea4( (String)map.get(DbExtractApplyMeta.SQL_AREA4));
				this.setOrderId( (String)map.get(DbExtractApplyMeta.ORDER_ID));
				this.setSqlArea5( (String)map.get(DbExtractApplyMeta.SQL_AREA5));
				this.setItemCode( (String)map.get(DbExtractApplyMeta.ITEM_CODE));
				this.setDbName( (String)map.get(DbExtractApplyMeta.DB_NAME));
				this.setDbFullName( (String)map.get(DbExtractApplyMeta.DB_FULL_NAME));
				this.setSqlArea2( (String)map.get(DbExtractApplyMeta.SQL_AREA2));
				this.setCheckResult( (String)map.get(DbExtractApplyMeta.CHECK_RESULT));
				this.setSelectedCode( (String)map.get(DbExtractApplyMeta.SELECTED_CODE));
				this.setContent( (String)map.get(DbExtractApplyMeta.CONTENT));
				this.setApplyUserId( (String)map.get(DbExtractApplyMeta.APPLY_USER_ID));
				this.setItemName( (String)map.get(DbExtractApplyMeta.ITEM_NAME));
				this.setPushOrderStatus( (String)map.get(DbExtractApplyMeta.PUSH_ORDER_STATUS));
				this.setUpdateBy( (String)map.get(DbExtractApplyMeta.UPDATE_BY));
				this.setDbId( (String)map.get(DbExtractApplyMeta.DB_ID));
				this.setDbUser( (String)map.get(DbExtractApplyMeta.DB_USER));
				this.setId( (String)map.get(DbExtractApplyMeta.ID));
				this.setPushResult( (String)map.get(DbExtractApplyMeta.PUSH_RESULT));
				this.setSqlArea( (String)map.get(DbExtractApplyMeta.SQL_AREA));
				this.setUpdateTime( (Date)map.get(DbExtractApplyMeta.UPDATE_TIME));
				this.setDbIp( (String)map.get(DbExtractApplyMeta.DB_IP));
				this.setVersion( (Integer)map.get(DbExtractApplyMeta.VERSION));
				this.setDbPort( (String)map.get(DbExtractApplyMeta.DB_PORT));
				this.setAssociatedSystem( (String)map.get(DbExtractApplyMeta.ASSOCIATED_SYSTEM));
				this.setCreateBy( (String)map.get(DbExtractApplyMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DbExtractApplyMeta.DELETED));
				this.setDeleteTime( (Date)map.get(DbExtractApplyMeta.DELETE_TIME));
				this.setCreateTime( (Date)map.get(DbExtractApplyMeta.CREATE_TIME));
				this.setTenantId( (String)map.get(DbExtractApplyMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(DbExtractApplyMeta.DELETE_BY));
				this.setStatus( (String)map.get(DbExtractApplyMeta.STATUS));
				// others
				this.setApplyUser( (Employee)map.get(DbExtractApplyMeta.APPLY_USER));
				this.setDbInfoApply( (DbInfoApply)map.get(DbExtractApplyMeta.DB_INFO_APPLY));
				this.setRequestOrder( (DbApplyExecute)map.get(DbExtractApplyMeta.REQUEST_ORDER));
				this.setButtonCheck( (String)map.get(DbExtractApplyMeta.BUTTON_CHECK));
				this.setButtonCheckDetail( (String)map.get(DbExtractApplyMeta.BUTTON_CHECK_DETAIL));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.NOTES)));
			this.setSqlArea3(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.SQL_AREA3)));
			this.setSqlArea4(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.SQL_AREA4)));
			this.setOrderId(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.ORDER_ID)));
			this.setSqlArea5(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.SQL_AREA5)));
			this.setItemCode(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.ITEM_CODE)));
			this.setDbName(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.DB_NAME)));
			this.setDbFullName(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.DB_FULL_NAME)));
			this.setSqlArea2(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.SQL_AREA2)));
			this.setCheckResult(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.CHECK_RESULT)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.CONTENT)));
			this.setApplyUserId(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.APPLY_USER_ID)));
			this.setItemName(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.ITEM_NAME)));
			this.setPushOrderStatus(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.PUSH_ORDER_STATUS)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.UPDATE_BY)));
			this.setDbId(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.DB_ID)));
			this.setDbUser(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.DB_USER)));
			this.setId(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.ID)));
			this.setPushResult(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.PUSH_RESULT)));
			this.setSqlArea(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.SQL_AREA)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DbExtractApplyMeta.UPDATE_TIME)));
			this.setDbIp(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.DB_IP)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DbExtractApplyMeta.VERSION)));
			this.setDbPort(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.DB_PORT)));
			this.setAssociatedSystem(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.ASSOCIATED_SYSTEM)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DbExtractApplyMeta.DELETED)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DbExtractApplyMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DbExtractApplyMeta.CREATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(DbExtractApplyMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(DbExtractApplyMeta.NOTES));
				this.setSqlArea3( (String)r.getValue(DbExtractApplyMeta.SQL_AREA3));
				this.setSqlArea4( (String)r.getValue(DbExtractApplyMeta.SQL_AREA4));
				this.setOrderId( (String)r.getValue(DbExtractApplyMeta.ORDER_ID));
				this.setSqlArea5( (String)r.getValue(DbExtractApplyMeta.SQL_AREA5));
				this.setItemCode( (String)r.getValue(DbExtractApplyMeta.ITEM_CODE));
				this.setDbName( (String)r.getValue(DbExtractApplyMeta.DB_NAME));
				this.setDbFullName( (String)r.getValue(DbExtractApplyMeta.DB_FULL_NAME));
				this.setSqlArea2( (String)r.getValue(DbExtractApplyMeta.SQL_AREA2));
				this.setCheckResult( (String)r.getValue(DbExtractApplyMeta.CHECK_RESULT));
				this.setSelectedCode( (String)r.getValue(DbExtractApplyMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(DbExtractApplyMeta.CONTENT));
				this.setApplyUserId( (String)r.getValue(DbExtractApplyMeta.APPLY_USER_ID));
				this.setItemName( (String)r.getValue(DbExtractApplyMeta.ITEM_NAME));
				this.setPushOrderStatus( (String)r.getValue(DbExtractApplyMeta.PUSH_ORDER_STATUS));
				this.setUpdateBy( (String)r.getValue(DbExtractApplyMeta.UPDATE_BY));
				this.setDbId( (String)r.getValue(DbExtractApplyMeta.DB_ID));
				this.setDbUser( (String)r.getValue(DbExtractApplyMeta.DB_USER));
				this.setId( (String)r.getValue(DbExtractApplyMeta.ID));
				this.setPushResult( (String)r.getValue(DbExtractApplyMeta.PUSH_RESULT));
				this.setSqlArea( (String)r.getValue(DbExtractApplyMeta.SQL_AREA));
				this.setUpdateTime( (Date)r.getValue(DbExtractApplyMeta.UPDATE_TIME));
				this.setDbIp( (String)r.getValue(DbExtractApplyMeta.DB_IP));
				this.setVersion( (Integer)r.getValue(DbExtractApplyMeta.VERSION));
				this.setDbPort( (String)r.getValue(DbExtractApplyMeta.DB_PORT));
				this.setAssociatedSystem( (String)r.getValue(DbExtractApplyMeta.ASSOCIATED_SYSTEM));
				this.setCreateBy( (String)r.getValue(DbExtractApplyMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DbExtractApplyMeta.DELETED));
				this.setDeleteTime( (Date)r.getValue(DbExtractApplyMeta.DELETE_TIME));
				this.setCreateTime( (Date)r.getValue(DbExtractApplyMeta.CREATE_TIME));
				this.setTenantId( (String)r.getValue(DbExtractApplyMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(DbExtractApplyMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(DbExtractApplyMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}