package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_AUTO_NODE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.AutoNodeMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 节点
 * <p>节点 , 数据表 ops_auto_node 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-01 15:21:45
 * @sign AE76F5869794E4D5BE3112241EDABCE8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_auto_node")
@ApiModel(description = "节点 ; 节点 , 数据表 ops_auto_node 的PO类型")
public class AutoNode extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_AUTO_NODE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "749695855304376320")
	private String id;
	
	/**
	 * 归属：归属
	*/
	@ApiModelProperty(required = false,value="归属" , notes = "归属" , example = "none")
	private String ownerCode;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "121.43.103.102_1")
	private String name;
	
	/**
	 * 分组：分组
	*/
	@ApiModelProperty(required = false,value="分组" , notes = "分组" , example = "749694127301459968")
	private String groupId;
	
	/**
	 * 节点类型：节点类型
	*/
	@ApiModelProperty(required = false,value="节点类型" , notes = "节点类型" , example = "host")
	private String type;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * IP：IP
	*/
	@ApiModelProperty(required = false,value="IP" , notes = "IP" , example = "121.43.103.102")
	private String ip;
	
	/**
	 * 端口：端口
	*/
	@ApiModelProperty(required = false,value="端口" , notes = "端口" , example = "22")
	private Integer port;
	
	/**
	 * 认证方式：认证方式
	*/
	@ApiModelProperty(required = false,value="认证方式" , notes = "认证方式" , example = "voucher")
	private String authenticationMethod;
	
	/**
	 * 凭证：凭证
	*/
	@ApiModelProperty(required = false,value="凭证" , notes = "凭证")
	private String voucherId;
	
	/**
	 * 账户：账户
	*/
	@ApiModelProperty(required = false,value="账户" , notes = "账户" , example = "root")
	private String userName;
	
	/**
	 * 密码：密码
	*/
	@ApiModelProperty(required = false,value="密码" , notes = "密码" , example = "******")
	private String password;
	
	/**
	 * 公钥：公钥
	*/
	@ApiModelProperty(required = false,value="公钥" , notes = "公钥")
	private String pubKey;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-09-01 06:50:52")
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "2")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
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
	 * typeDict：typeDict
	*/
	@ApiModelProperty(required = false,value="typeDict" , notes = "typeDict")
	private DictItem typeDict;
	
	/**
	 * group：group
	*/
	@ApiModelProperty(required = false,value="group" , notes = "group")
	private AutoGroup group;
	
	/**
	 * voucher：voucher
	*/
	@ApiModelProperty(required = false,value="voucher" , notes = "voucher")
	private AutoVoucher voucher;
	
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
	public AutoNode setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 归属<br>
	 * 归属
	 * @return 归属
	*/
	public String getOwnerCode() {
		return ownerCode;
	}
	
	/**
	 * 设置 归属
	 * @param ownerCode 归属
	 * @return 当前对象
	*/
	public AutoNode setOwnerCode(String ownerCode) {
		this.ownerCode=ownerCode;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public AutoNode setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 分组<br>
	 * 分组
	 * @return 分组
	*/
	public String getGroupId() {
		return groupId;
	}
	
	/**
	 * 设置 分组
	 * @param groupId 分组
	 * @return 当前对象
	*/
	public AutoNode setGroupId(String groupId) {
		this.groupId=groupId;
		return this;
	}
	
	/**
	 * 获得 节点类型<br>
	 * 节点类型
	 * @return 节点类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 节点类型
	 * @param type 节点类型
	 * @return 当前对象
	*/
	public AutoNode setType(String type) {
		this.type=type;
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
	public AutoNode setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 IP<br>
	 * IP
	 * @return IP
	*/
	public String getIp() {
		return ip;
	}
	
	/**
	 * 设置 IP
	 * @param ip IP
	 * @return 当前对象
	*/
	public AutoNode setIp(String ip) {
		this.ip=ip;
		return this;
	}
	
	/**
	 * 获得 端口<br>
	 * 端口
	 * @return 端口
	*/
	public Integer getPort() {
		return port;
	}
	
	/**
	 * 设置 端口
	 * @param port 端口
	 * @return 当前对象
	*/
	public AutoNode setPort(Integer port) {
		this.port=port;
		return this;
	}
	
	/**
	 * 获得 认证方式<br>
	 * 认证方式
	 * @return 认证方式
	*/
	public String getAuthenticationMethod() {
		return authenticationMethod;
	}
	
	/**
	 * 设置 认证方式
	 * @param authenticationMethod 认证方式
	 * @return 当前对象
	*/
	public AutoNode setAuthenticationMethod(String authenticationMethod) {
		this.authenticationMethod=authenticationMethod;
		return this;
	}
	
	/**
	 * 获得 凭证<br>
	 * 凭证
	 * @return 凭证
	*/
	public String getVoucherId() {
		return voucherId;
	}
	
	/**
	 * 设置 凭证
	 * @param voucherId 凭证
	 * @return 当前对象
	*/
	public AutoNode setVoucherId(String voucherId) {
		this.voucherId=voucherId;
		return this;
	}
	
	/**
	 * 获得 账户<br>
	 * 账户
	 * @return 账户
	*/
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 设置 账户
	 * @param userName 账户
	 * @return 当前对象
	*/
	public AutoNode setUserName(String userName) {
		this.userName=userName;
		return this;
	}
	
	/**
	 * 获得 密码<br>
	 * 密码
	 * @return 密码
	*/
	public String getPassword() {
		return password;
	}
	
	/**
	 * 设置 密码
	 * @param password 密码
	 * @return 当前对象
	*/
	public AutoNode setPassword(String password) {
		this.password=password;
		return this;
	}
	
	/**
	 * 获得 公钥<br>
	 * 公钥
	 * @return 公钥
	*/
	public String getPubKey() {
		return pubKey;
	}
	
	/**
	 * 设置 公钥
	 * @param pubKey 公钥
	 * @return 当前对象
	*/
	public AutoNode setPubKey(String pubKey) {
		this.pubKey=pubKey;
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
	public AutoNode setNotes(String notes) {
		this.notes=notes;
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
	public AutoNode setUpdateBy(String updateBy) {
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
	public AutoNode setUpdateTime(Date updateTime) {
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
	public AutoNode setDeleted(Integer deleted) {
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
	public AutoNode setDeleted(Boolean deletedBool) {
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
	public AutoNode setDeleteBy(String deleteBy) {
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
	public AutoNode setDeleteTime(Date deleteTime) {
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
	public AutoNode setVersion(Integer version) {
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
	public AutoNode setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public AutoNode setCreateBy(String createBy) {
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
	public AutoNode setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 typeDict<br>
	 * typeDict
	 * @return typeDict
	*/
	public DictItem getTypeDict() {
		return typeDict;
	}
	
	/**
	 * 设置 typeDict
	 * @param typeDict typeDict
	 * @return 当前对象
	*/
	public AutoNode setTypeDict(DictItem typeDict) {
		this.typeDict=typeDict;
		return this;
	}
	
	/**
	 * 获得 group<br>
	 * group
	 * @return group
	*/
	public AutoGroup getGroup() {
		return group;
	}
	
	/**
	 * 设置 group
	 * @param group group
	 * @return 当前对象
	*/
	public AutoNode setGroup(AutoGroup group) {
		this.group=group;
		return this;
	}
	
	/**
	 * 获得 voucher<br>
	 * voucher
	 * @return voucher
	*/
	public AutoVoucher getVoucher() {
		return voucher;
	}
	
	/**
	 * 设置 voucher
	 * @param voucher voucher
	 * @return 当前对象
	*/
	public AutoNode setVoucher(AutoVoucher voucher) {
		this.voucher=voucher;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AutoNode , 转换好的 AutoNode 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AutoNode , 转换好的 PoJo 对象
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
	public AutoNode clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AutoNode duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.AutoNodeMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.AutoNodeMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setOwnerCode(this.getOwnerCode());
		inst.setGroupId(this.getGroupId());
		inst.setIp(this.getIp());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setType(this.getType());
		inst.setUserName(this.getUserName());
		inst.setVersion(this.getVersion());
		inst.setPassword(this.getPassword());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPort(this.getPort());
		inst.setAuthenticationMethod(this.getAuthenticationMethod());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCreateTime(this.getCreateTime());
		inst.setVoucherId(this.getVoucherId());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		inst.setPubKey(this.getPubKey());
		if(all) {
			inst.setVoucher(this.getVoucher());
			inst.setTypeDict(this.getTypeDict());
			inst.setGroup(this.getGroup());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AutoNode clone(boolean deep) {
		return EntityContext.clone(AutoNode.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AutoNode
	 * @param autoNodeMap 包含实体信息的 Map 对象
	 * @return AutoNode , 转换好的的 AutoNode 对象
	*/
	@Transient
	public static AutoNode createFrom(Map<String,Object> autoNodeMap) {
		if(autoNodeMap==null) return null;
		AutoNode po = create();
		EntityContext.copyProperties(po,autoNodeMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AutoNode
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AutoNode , 转换好的的 AutoNode 对象
	*/
	@Transient
	public static AutoNode createFrom(Object pojo) {
		if(pojo==null) return null;
		AutoNode po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AutoNode，等同于 new
	 * @return AutoNode 对象
	*/
	@Transient
	public static AutoNode create() {
		return new com.dt.platform.domain.ops.meta.AutoNodeMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AutoNodeMeta.NOTES)));
			this.setOwnerCode(DataParser.parse(String.class, map.get(AutoNodeMeta.OWNER_CODE)));
			this.setGroupId(DataParser.parse(String.class, map.get(AutoNodeMeta.GROUP_ID)));
			this.setIp(DataParser.parse(String.class, map.get(AutoNodeMeta.IP)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AutoNodeMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(AutoNodeMeta.TYPE)));
			this.setUserName(DataParser.parse(String.class, map.get(AutoNodeMeta.USER_NAME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AutoNodeMeta.VERSION)));
			this.setPassword(DataParser.parse(String.class, map.get(AutoNodeMeta.PASSWORD)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AutoNodeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AutoNodeMeta.DELETED)));
			this.setPort(DataParser.parse(Integer.class, map.get(AutoNodeMeta.PORT)));
			this.setAuthenticationMethod(DataParser.parse(String.class, map.get(AutoNodeMeta.AUTHENTICATION_METHOD)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AutoNodeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AutoNodeMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AutoNodeMeta.CREATE_TIME)));
			this.setVoucherId(DataParser.parse(String.class, map.get(AutoNodeMeta.VOUCHER_ID)));
			this.setName(DataParser.parse(String.class, map.get(AutoNodeMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AutoNodeMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AutoNodeMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AutoNodeMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AutoNodeMeta.STATUS)));
			this.setPubKey(DataParser.parse(String.class, map.get(AutoNodeMeta.PUB_KEY)));
			// others
			this.setVoucher(DataParser.parse(AutoVoucher.class, map.get(AutoNodeMeta.VOUCHER)));
			this.setTypeDict(DataParser.parse(DictItem.class, map.get(AutoNodeMeta.TYPE_DICT)));
			this.setGroup(DataParser.parse(AutoGroup.class, map.get(AutoNodeMeta.GROUP)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AutoNodeMeta.NOTES));
				this.setOwnerCode( (String)map.get(AutoNodeMeta.OWNER_CODE));
				this.setGroupId( (String)map.get(AutoNodeMeta.GROUP_ID));
				this.setIp( (String)map.get(AutoNodeMeta.IP));
				this.setUpdateTime( (Date)map.get(AutoNodeMeta.UPDATE_TIME));
				this.setType( (String)map.get(AutoNodeMeta.TYPE));
				this.setUserName( (String)map.get(AutoNodeMeta.USER_NAME));
				this.setVersion( (Integer)map.get(AutoNodeMeta.VERSION));
				this.setPassword( (String)map.get(AutoNodeMeta.PASSWORD));
				this.setCreateBy( (String)map.get(AutoNodeMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AutoNodeMeta.DELETED));
				this.setPort( (Integer)map.get(AutoNodeMeta.PORT));
				this.setAuthenticationMethod( (String)map.get(AutoNodeMeta.AUTHENTICATION_METHOD));
				this.setUpdateBy( (String)map.get(AutoNodeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AutoNodeMeta.DELETE_TIME));
				this.setCreateTime( (Date)map.get(AutoNodeMeta.CREATE_TIME));
				this.setVoucherId( (String)map.get(AutoNodeMeta.VOUCHER_ID));
				this.setName( (String)map.get(AutoNodeMeta.NAME));
				this.setTenantId( (String)map.get(AutoNodeMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AutoNodeMeta.DELETE_BY));
				this.setId( (String)map.get(AutoNodeMeta.ID));
				this.setStatus( (String)map.get(AutoNodeMeta.STATUS));
				this.setPubKey( (String)map.get(AutoNodeMeta.PUB_KEY));
				// others
				this.setVoucher( (AutoVoucher)map.get(AutoNodeMeta.VOUCHER));
				this.setTypeDict( (DictItem)map.get(AutoNodeMeta.TYPE_DICT));
				this.setGroup( (AutoGroup)map.get(AutoNodeMeta.GROUP));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AutoNodeMeta.NOTES)));
			this.setOwnerCode(DataParser.parse(String.class, r.getValue(AutoNodeMeta.OWNER_CODE)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(AutoNodeMeta.GROUP_ID)));
			this.setIp(DataParser.parse(String.class, r.getValue(AutoNodeMeta.IP)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AutoNodeMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(AutoNodeMeta.TYPE)));
			this.setUserName(DataParser.parse(String.class, r.getValue(AutoNodeMeta.USER_NAME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AutoNodeMeta.VERSION)));
			this.setPassword(DataParser.parse(String.class, r.getValue(AutoNodeMeta.PASSWORD)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AutoNodeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AutoNodeMeta.DELETED)));
			this.setPort(DataParser.parse(Integer.class, r.getValue(AutoNodeMeta.PORT)));
			this.setAuthenticationMethod(DataParser.parse(String.class, r.getValue(AutoNodeMeta.AUTHENTICATION_METHOD)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AutoNodeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AutoNodeMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AutoNodeMeta.CREATE_TIME)));
			this.setVoucherId(DataParser.parse(String.class, r.getValue(AutoNodeMeta.VOUCHER_ID)));
			this.setName(DataParser.parse(String.class, r.getValue(AutoNodeMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AutoNodeMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AutoNodeMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AutoNodeMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AutoNodeMeta.STATUS)));
			this.setPubKey(DataParser.parse(String.class, r.getValue(AutoNodeMeta.PUB_KEY)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AutoNodeMeta.NOTES));
				this.setOwnerCode( (String)r.getValue(AutoNodeMeta.OWNER_CODE));
				this.setGroupId( (String)r.getValue(AutoNodeMeta.GROUP_ID));
				this.setIp( (String)r.getValue(AutoNodeMeta.IP));
				this.setUpdateTime( (Date)r.getValue(AutoNodeMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(AutoNodeMeta.TYPE));
				this.setUserName( (String)r.getValue(AutoNodeMeta.USER_NAME));
				this.setVersion( (Integer)r.getValue(AutoNodeMeta.VERSION));
				this.setPassword( (String)r.getValue(AutoNodeMeta.PASSWORD));
				this.setCreateBy( (String)r.getValue(AutoNodeMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AutoNodeMeta.DELETED));
				this.setPort( (Integer)r.getValue(AutoNodeMeta.PORT));
				this.setAuthenticationMethod( (String)r.getValue(AutoNodeMeta.AUTHENTICATION_METHOD));
				this.setUpdateBy( (String)r.getValue(AutoNodeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AutoNodeMeta.DELETE_TIME));
				this.setCreateTime( (Date)r.getValue(AutoNodeMeta.CREATE_TIME));
				this.setVoucherId( (String)r.getValue(AutoNodeMeta.VOUCHER_ID));
				this.setName( (String)r.getValue(AutoNodeMeta.NAME));
				this.setTenantId( (String)r.getValue(AutoNodeMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AutoNodeMeta.DELETE_BY));
				this.setId( (String)r.getValue(AutoNodeMeta.ID));
				this.setStatus( (String)r.getValue(AutoNodeMeta.STATUS));
				this.setPubKey( (String)r.getValue(AutoNodeMeta.PUB_KEY));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}