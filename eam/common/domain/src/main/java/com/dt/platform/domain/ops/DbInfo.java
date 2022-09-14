package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_DB_INFO;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import java.util.List;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 数据库
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-13 20:38:43
 * @sign 9CC3FE897AC246245F83B2B18261244B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_db_info")
public class DbInfo extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_DB_INFO.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 主机：主机
	*/
	@ApiModelProperty(required = false,value="主机" , notes = "主机")
	private String hostId;
	
	/**
	 * 数据库类型：数据库类型
	*/
	@ApiModelProperty(required = false,value="数据库类型" , notes = "数据库类型")
	private String typeId;
	
	/**
	 * 数据库名：数据库名
	*/
	@ApiModelProperty(required = false,value="数据库名" , notes = "数据库名")
	private String name;
	
	/**
	 * 数据库状态：数据库状态
	*/
	@ApiModelProperty(required = false,value="数据库状态" , notes = "数据库状态")
	private String status;
	
	/**
	 * 备份状态：备份状态
	*/
	@ApiModelProperty(required = false,value="备份状态" , notes = "备份状态")
	private String backupStatus;
	
	/**
	 * 部署模式：部署模式
	*/
	@ApiModelProperty(required = false,value="部署模式" , notes = "部署模式")
	private String deployMode;
	
	/**
	 * 备份策略：备份策略
	*/
	@ApiModelProperty(required = false,value="备份策略" , notes = "备份策略")
	private String backupStrategy;
	
	/**
	 * 大小(M)：大小(M)
	*/
	@ApiModelProperty(required = false,value="大小(M)" , notes = "大小(M)")
	private BigDecimal dbSize;
	
	/**
	 * 日志模式：日志模式
	*/
	@ApiModelProperty(required = false,value="日志模式" , notes = "日志模式")
	private String logMethod;
	
	/**
	 * 管理员账户：管理员账户
	*/
	@ApiModelProperty(required = false,value="管理员账户" , notes = "管理员账户")
	private String adminUserList;
	
	/**
	 * 应用账户：应用账户
	*/
	@ApiModelProperty(required = false,value="应用账户" , notes = "应用账户")
	private String appUserList;
	
	/**
	 * 其他账户：其他账户
	*/
	@ApiModelProperty(required = false,value="其他账户" , notes = "其他账户")
	private String otherUserList;
	
	/**
	 * 凭证信息：凭证信息
	*/
	@ApiModelProperty(required = false,value="凭证信息" , notes = "凭证信息")
	private String voucherStr;
	
	/**
	 * 连接端口：连接端口
	*/
	@ApiModelProperty(required = false,value="连接端口" , notes = "连接端口")
	private String dbPort;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
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
	@ApiModelProperty(required = false,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	@Transient
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
	 * backupInfoList：backupInfoList
	*/
	@ApiModelProperty(required = false,value="backupInfoList" , notes = "backupInfoList")
	private List<DbBackupInfo> backupInfoList;
	
	/**
	 * backupInfoIds：backupInfoIds
	*/
	@ApiModelProperty(required = false,value="backupInfoIds" , notes = "backupInfoIds")
	private List<String> backupInfoIds;
	
	/**
	 * host：host
	*/
	@ApiModelProperty(required = false,value="host" , notes = "host")
	private Host host;
	
	/**
	 * type：type
	*/
	@ApiModelProperty(required = false,value="type" , notes = "type")
	private ServiceInfo type;
	
	/**
	 * deployModeDict：deployModeDict
	*/
	@ApiModelProperty(required = false,value="deployModeDict" , notes = "deployModeDict")
	private DictItem deployModeDict;
	
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
	public DbInfo setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 主机<br>
	 * 主机
	 * @return 主机
	*/
	public String getHostId() {
		return hostId;
	}
	
	/**
	 * 设置 主机
	 * @param hostId 主机
	 * @return 当前对象
	*/
	public DbInfo setHostId(String hostId) {
		this.hostId=hostId;
		return this;
	}
	
	/**
	 * 获得 数据库类型<br>
	 * 数据库类型
	 * @return 数据库类型
	*/
	public String getTypeId() {
		return typeId;
	}
	
	/**
	 * 设置 数据库类型
	 * @param typeId 数据库类型
	 * @return 当前对象
	*/
	public DbInfo setTypeId(String typeId) {
		this.typeId=typeId;
		return this;
	}
	
	/**
	 * 获得 数据库名<br>
	 * 数据库名
	 * @return 数据库名
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 数据库名
	 * @param name 数据库名
	 * @return 当前对象
	*/
	public DbInfo setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 数据库状态<br>
	 * 数据库状态
	 * @return 数据库状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 数据库状态
	 * @param status 数据库状态
	 * @return 当前对象
	*/
	public DbInfo setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 备份状态<br>
	 * 备份状态
	 * @return 备份状态
	*/
	public String getBackupStatus() {
		return backupStatus;
	}
	
	/**
	 * 设置 备份状态
	 * @param backupStatus 备份状态
	 * @return 当前对象
	*/
	public DbInfo setBackupStatus(String backupStatus) {
		this.backupStatus=backupStatus;
		return this;
	}
	
	/**
	 * 获得 部署模式<br>
	 * 部署模式
	 * @return 部署模式
	*/
	public String getDeployMode() {
		return deployMode;
	}
	
	/**
	 * 设置 部署模式
	 * @param deployMode 部署模式
	 * @return 当前对象
	*/
	public DbInfo setDeployMode(String deployMode) {
		this.deployMode=deployMode;
		return this;
	}
	
	/**
	 * 获得 备份策略<br>
	 * 备份策略
	 * @return 备份策略
	*/
	public String getBackupStrategy() {
		return backupStrategy;
	}
	
	/**
	 * 设置 备份策略
	 * @param backupStrategy 备份策略
	 * @return 当前对象
	*/
	public DbInfo setBackupStrategy(String backupStrategy) {
		this.backupStrategy=backupStrategy;
		return this;
	}
	
	/**
	 * 获得 大小(M)<br>
	 * 大小(M)
	 * @return 大小(M)
	*/
	public BigDecimal getDbSize() {
		return dbSize;
	}
	
	/**
	 * 设置 大小(M)
	 * @param dbSize 大小(M)
	 * @return 当前对象
	*/
	public DbInfo setDbSize(BigDecimal dbSize) {
		this.dbSize=dbSize;
		return this;
	}
	
	/**
	 * 获得 日志模式<br>
	 * 日志模式
	 * @return 日志模式
	*/
	public String getLogMethod() {
		return logMethod;
	}
	
	/**
	 * 设置 日志模式
	 * @param logMethod 日志模式
	 * @return 当前对象
	*/
	public DbInfo setLogMethod(String logMethod) {
		this.logMethod=logMethod;
		return this;
	}
	
	/**
	 * 获得 管理员账户<br>
	 * 管理员账户
	 * @return 管理员账户
	*/
	public String getAdminUserList() {
		return adminUserList;
	}
	
	/**
	 * 设置 管理员账户
	 * @param adminUserList 管理员账户
	 * @return 当前对象
	*/
	public DbInfo setAdminUserList(String adminUserList) {
		this.adminUserList=adminUserList;
		return this;
	}
	
	/**
	 * 获得 应用账户<br>
	 * 应用账户
	 * @return 应用账户
	*/
	public String getAppUserList() {
		return appUserList;
	}
	
	/**
	 * 设置 应用账户
	 * @param appUserList 应用账户
	 * @return 当前对象
	*/
	public DbInfo setAppUserList(String appUserList) {
		this.appUserList=appUserList;
		return this;
	}
	
	/**
	 * 获得 其他账户<br>
	 * 其他账户
	 * @return 其他账户
	*/
	public String getOtherUserList() {
		return otherUserList;
	}
	
	/**
	 * 设置 其他账户
	 * @param otherUserList 其他账户
	 * @return 当前对象
	*/
	public DbInfo setOtherUserList(String otherUserList) {
		this.otherUserList=otherUserList;
		return this;
	}
	
	/**
	 * 获得 凭证信息<br>
	 * 凭证信息
	 * @return 凭证信息
	*/
	public String getVoucherStr() {
		return voucherStr;
	}
	
	/**
	 * 设置 凭证信息
	 * @param voucherStr 凭证信息
	 * @return 当前对象
	*/
	public DbInfo setVoucherStr(String voucherStr) {
		this.voucherStr=voucherStr;
		return this;
	}
	
	/**
	 * 获得 连接端口<br>
	 * 连接端口
	 * @return 连接端口
	*/
	public String getDbPort() {
		return dbPort;
	}
	
	/**
	 * 设置 连接端口
	 * @param dbPort 连接端口
	 * @return 当前对象
	*/
	public DbInfo setDbPort(String dbPort) {
		this.dbPort=dbPort;
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
	public DbInfo setNotes(String notes) {
		this.notes=notes;
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
	public DbInfo setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public DbInfo setCreateBy(String createBy) {
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
	public DbInfo setCreateTime(Date createTime) {
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
	public DbInfo setUpdateBy(String updateBy) {
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
	public DbInfo setUpdateTime(Date updateTime) {
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
	public DbInfo setDeleted(Integer deleted) {
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
	public DbInfo setDeleted(Boolean deletedBool) {
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
	public DbInfo setDeleteBy(String deleteBy) {
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
	public DbInfo setDeleteTime(Date deleteTime) {
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
	public DbInfo setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 backupInfoList<br>
	 * backupInfoList
	 * @return backupInfoList
	*/
	public List<DbBackupInfo> getBackupInfoList() {
		return backupInfoList;
	}
	
	/**
	 * 设置 backupInfoList
	 * @param backupInfoList backupInfoList
	 * @return 当前对象
	*/
	public DbInfo setBackupInfoList(List<DbBackupInfo> backupInfoList) {
		this.backupInfoList=backupInfoList;
		return this;
	}
	
	/**
	 * 添加 backupInfoList
	 * @param backupInfo backupInfoList
	 * @return 当前对象
	*/
	public DbInfo addBackupInfo(DbBackupInfo... backupInfo) {
		if(this.backupInfoList==null) backupInfoList=new ArrayList<>();
		this.backupInfoList.addAll(Arrays.asList(backupInfo));
		return this;
	}
	
	/**
	 * 获得 backupInfoIds<br>
	 * backupInfoIds
	 * @return backupInfoIds
	*/
	public List<String> getBackupInfoIds() {
		return backupInfoIds;
	}
	
	/**
	 * 设置 backupInfoIds
	 * @param backupInfoIds backupInfoIds
	 * @return 当前对象
	*/
	public DbInfo setBackupInfoIds(List<String> backupInfoIds) {
		this.backupInfoIds=backupInfoIds;
		return this;
	}
	
	/**
	 * 添加 backupInfoIds
	 * @param backupInfoId backupInfoIds
	 * @return 当前对象
	*/
	public DbInfo addBackupInfoId(String... backupInfoId) {
		if(this.backupInfoIds==null) backupInfoIds=new ArrayList<>();
		this.backupInfoIds.addAll(Arrays.asList(backupInfoId));
		return this;
	}
	
	/**
	 * 获得 host<br>
	 * host
	 * @return host
	*/
	public Host getHost() {
		return host;
	}
	
	/**
	 * 设置 host
	 * @param host host
	 * @return 当前对象
	*/
	public DbInfo setHost(Host host) {
		this.host=host;
		return this;
	}
	
	/**
	 * 获得 type<br>
	 * type
	 * @return type
	*/
	public ServiceInfo getType() {
		return type;
	}
	
	/**
	 * 设置 type
	 * @param type type
	 * @return 当前对象
	*/
	public DbInfo setType(ServiceInfo type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 deployModeDict<br>
	 * deployModeDict
	 * @return deployModeDict
	*/
	public DictItem getDeployModeDict() {
		return deployModeDict;
	}
	
	/**
	 * 设置 deployModeDict
	 * @param deployModeDict deployModeDict
	 * @return 当前对象
	*/
	public DbInfo setDeployModeDict(DictItem deployModeDict) {
		this.deployModeDict=deployModeDict;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DbInfo , 转换好的 DbInfo 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbInfo , 转换好的 PoJo 对象
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
	public DbInfo clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DbInfo duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DbInfoMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DbInfoMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setLogMethod(this.getLogMethod());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setBackupStatus(this.getBackupStatus());
		inst.setBackupStrategy(this.getBackupStrategy());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setVoucherStr(this.getVoucherStr());
		inst.setId(this.getId());
		inst.setAdminUserList(this.getAdminUserList());
		inst.setAppUserList(this.getAppUserList());
		inst.setDeployMode(this.getDeployMode());
		inst.setOtherUserList(this.getOtherUserList());
		inst.setHostId(this.getHostId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setDbSize(this.getDbSize());
		inst.setDbPort(this.getDbPort());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setTypeId(this.getTypeId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setBackupInfoList(this.getBackupInfoList());
			inst.setHost(this.getHost());
			inst.setBackupInfoIds(this.getBackupInfoIds());
			inst.setDeployModeDict(this.getDeployModeDict());
			inst.setType(this.getType());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DbInfo clone(boolean deep) {
		return EntityContext.clone(DbInfo.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbInfo
	 * @param dbInfoMap 包含实体信息的 Map 对象
	 * @return DbInfo , 转换好的的 DbInfo 对象
	*/
	@Transient
	public static DbInfo createFrom(Map<String,Object> dbInfoMap) {
		if(dbInfoMap==null) return null;
		DbInfo po = create();
		EntityContext.copyProperties(po,dbInfoMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DbInfo
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbInfo , 转换好的的 DbInfo 对象
	*/
	@Transient
	public static DbInfo createFrom(Object pojo) {
		if(pojo==null) return null;
		DbInfo po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DbInfo，等同于 new
	 * @return DbInfo 对象
	*/
	@Transient
	public static DbInfo create() {
		return new com.dt.platform.domain.ops.meta.DbInfoMeta.$$proxy$$();
	}
}