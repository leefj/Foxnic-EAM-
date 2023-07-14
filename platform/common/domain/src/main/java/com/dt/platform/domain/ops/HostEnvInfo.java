package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_HOST_ENV_INFO;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.HostEnvInfoMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 主机环境
 * <p>主机环境 , 数据表 ops_host_env_info 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-14 20:34:43
 * @sign 08D9D909E436CF7047501E3063967A97
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_host_env_info")
@ApiModel(description = "主机环境 ; 主机环境 , 数据表 ops_host_env_info 的PO类型")
public class HostEnvInfo extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_HOST_ENV_INFO.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "732138067581730816")
	private String id;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签" , example = "other")
	private String label;
	
	/**
	 * 信息系统：信息系统
	*/
	@ApiModelProperty(required = false,value="信息系统" , notes = "信息系统" , example = "732137971578306560")
	private String systemId;
	
	/**
	 * 主机名称：主机名称
	*/
	@ApiModelProperty(required = false,value="主机名称" , notes = "主机名称" , example = "A数据库")
	private String hostname;
	
	/**
	 * 物理IP：物理IP
	*/
	@ApiModelProperty(required = false,value="物理IP" , notes = "物理IP" , example = "1212")
	private String ip;
	
	/**
	 * IPv6：IPv6
	*/
	@ApiModelProperty(required = false,value="IPv6" , notes = "IPv6")
	private String ipv6;
	
	/**
	 * VIP：VIP
	*/
	@ApiModelProperty(required = false,value="VIP" , notes = "VIP" , example = "12")
	private String vip;
	
	/**
	 * 描述：描述
	*/
	@ApiModelProperty(required = false,value="描述" , notes = "描述" , example = "12")
	private String hostDesc;
	
	/**
	 * 凭证：凭证
	*/
	@ApiModelProperty(required = false,value="凭证" , notes = "凭证" , example = "12")
	private String voucher;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "1212121212")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-07-14 07:35:18")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-07-14 07:39:17")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = false,value="是否已删除" , notes = "是否已删除" , example = "0")
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
	 * ciphertextBoxData：ciphertextBoxData
	*/
	@ApiModelProperty(required = false,value="ciphertextBoxData" , notes = "ciphertextBoxData")
	private CiphertextBoxData ciphertextBoxData;
	
	/**
	 * 信息系统：信息系统
	*/
	@ApiModelProperty(required = false,value="信息系统" , notes = "信息系统")
	private InformationSystem infoSystem;
	
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
	public HostEnvInfo setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 标签<br>
	 * 标签
	 * @return 标签
	*/
	public String getLabel() {
		return label;
	}
	
	/**
	 * 设置 标签
	 * @param label 标签
	 * @return 当前对象
	*/
	public HostEnvInfo setLabel(String label) {
		this.label=label;
		return this;
	}
	
	/**
	 * 获得 信息系统<br>
	 * 信息系统
	 * @return 信息系统
	*/
	public String getSystemId() {
		return systemId;
	}
	
	/**
	 * 设置 信息系统
	 * @param systemId 信息系统
	 * @return 当前对象
	*/
	public HostEnvInfo setSystemId(String systemId) {
		this.systemId=systemId;
		return this;
	}
	
	/**
	 * 获得 主机名称<br>
	 * 主机名称
	 * @return 主机名称
	*/
	public String getHostname() {
		return hostname;
	}
	
	/**
	 * 设置 主机名称
	 * @param hostname 主机名称
	 * @return 当前对象
	*/
	public HostEnvInfo setHostname(String hostname) {
		this.hostname=hostname;
		return this;
	}
	
	/**
	 * 获得 物理IP<br>
	 * 物理IP
	 * @return 物理IP
	*/
	public String getIp() {
		return ip;
	}
	
	/**
	 * 设置 物理IP
	 * @param ip 物理IP
	 * @return 当前对象
	*/
	public HostEnvInfo setIp(String ip) {
		this.ip=ip;
		return this;
	}
	
	/**
	 * 获得 IPv6<br>
	 * IPv6
	 * @return IPv6
	*/
	public String getIpv6() {
		return ipv6;
	}
	
	/**
	 * 设置 IPv6
	 * @param ipv6 IPv6
	 * @return 当前对象
	*/
	public HostEnvInfo setIpv6(String ipv6) {
		this.ipv6=ipv6;
		return this;
	}
	
	/**
	 * 获得 VIP<br>
	 * VIP
	 * @return VIP
	*/
	public String getVip() {
		return vip;
	}
	
	/**
	 * 设置 VIP
	 * @param vip VIP
	 * @return 当前对象
	*/
	public HostEnvInfo setVip(String vip) {
		this.vip=vip;
		return this;
	}
	
	/**
	 * 获得 描述<br>
	 * 描述
	 * @return 描述
	*/
	public String getHostDesc() {
		return hostDesc;
	}
	
	/**
	 * 设置 描述
	 * @param hostDesc 描述
	 * @return 当前对象
	*/
	public HostEnvInfo setHostDesc(String hostDesc) {
		this.hostDesc=hostDesc;
		return this;
	}
	
	/**
	 * 获得 凭证<br>
	 * 凭证
	 * @return 凭证
	*/
	public String getVoucher() {
		return voucher;
	}
	
	/**
	 * 设置 凭证
	 * @param voucher 凭证
	 * @return 当前对象
	*/
	public HostEnvInfo setVoucher(String voucher) {
		this.voucher=voucher;
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
	public HostEnvInfo setNotes(String notes) {
		this.notes=notes;
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
	public HostEnvInfo setCreateBy(String createBy) {
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
	public HostEnvInfo setCreateTime(Date createTime) {
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
	public HostEnvInfo setUpdateBy(String updateBy) {
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
	public HostEnvInfo setUpdateTime(Date updateTime) {
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
	public HostEnvInfo setDeleted(Integer deleted) {
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
	public HostEnvInfo setDeleted(Boolean deletedBool) {
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
	public HostEnvInfo setDeleteBy(String deleteBy) {
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
	public HostEnvInfo setDeleteTime(Date deleteTime) {
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
	public HostEnvInfo setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 ciphertextBoxData<br>
	 * ciphertextBoxData
	 * @return ciphertextBoxData
	*/
	public CiphertextBoxData getCiphertextBoxData() {
		return ciphertextBoxData;
	}
	
	/**
	 * 设置 ciphertextBoxData
	 * @param ciphertextBoxData ciphertextBoxData
	 * @return 当前对象
	*/
	public HostEnvInfo setCiphertextBoxData(CiphertextBoxData ciphertextBoxData) {
		this.ciphertextBoxData=ciphertextBoxData;
		return this;
	}
	
	/**
	 * 获得 信息系统<br>
	 * 信息系统
	 * @return 信息系统
	*/
	public InformationSystem getInfoSystem() {
		return infoSystem;
	}
	
	/**
	 * 设置 信息系统
	 * @param infoSystem 信息系统
	 * @return 当前对象
	*/
	public HostEnvInfo setInfoSystem(InformationSystem infoSystem) {
		this.infoSystem=infoSystem;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return HostEnvInfo , 转换好的 HostEnvInfo 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return HostEnvInfo , 转换好的 PoJo 对象
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
	public HostEnvInfo clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public HostEnvInfo duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.HostEnvInfoMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.HostEnvInfoMeta.$$proxy$$();
		inst.setSystemId(this.getSystemId());
		inst.setNotes(this.getNotes());
		inst.setVoucher(this.getVoucher());
		inst.setIp(this.getIp());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setLabel(this.getLabel());
		inst.setVersion(this.getVersion());
		inst.setHostname(this.getHostname());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setIpv6(this.getIpv6());
		inst.setHostDesc(this.getHostDesc());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setVip(this.getVip());
		if(all) {
			inst.setInfoSystem(this.getInfoSystem());
			inst.setCiphertextBoxData(this.getCiphertextBoxData());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public HostEnvInfo clone(boolean deep) {
		return EntityContext.clone(HostEnvInfo.class,this,deep);
	}

	/**
	 * 将 Map 转换成 HostEnvInfo
	 * @param hostEnvInfoMap 包含实体信息的 Map 对象
	 * @return HostEnvInfo , 转换好的的 HostEnvInfo 对象
	*/
	@Transient
	public static HostEnvInfo createFrom(Map<String,Object> hostEnvInfoMap) {
		if(hostEnvInfoMap==null) return null;
		HostEnvInfo po = create();
		EntityContext.copyProperties(po,hostEnvInfoMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 HostEnvInfo
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return HostEnvInfo , 转换好的的 HostEnvInfo 对象
	*/
	@Transient
	public static HostEnvInfo createFrom(Object pojo) {
		if(pojo==null) return null;
		HostEnvInfo po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 HostEnvInfo，等同于 new
	 * @return HostEnvInfo 对象
	*/
	@Transient
	public static HostEnvInfo create() {
		return new com.dt.platform.domain.ops.meta.HostEnvInfoMeta.$$proxy$$();
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
			this.setSystemId(DataParser.parse(String.class, map.get(HostEnvInfoMeta.SYSTEM_ID)));
			this.setNotes(DataParser.parse(String.class, map.get(HostEnvInfoMeta.NOTES)));
			this.setVoucher(DataParser.parse(String.class, map.get(HostEnvInfoMeta.VOUCHER)));
			this.setIp(DataParser.parse(String.class, map.get(HostEnvInfoMeta.IP)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(HostEnvInfoMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, map.get(HostEnvInfoMeta.LABEL)));
			this.setVersion(DataParser.parse(Integer.class, map.get(HostEnvInfoMeta.VERSION)));
			this.setHostname(DataParser.parse(String.class, map.get(HostEnvInfoMeta.HOSTNAME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(HostEnvInfoMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(HostEnvInfoMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(HostEnvInfoMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(HostEnvInfoMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(HostEnvInfoMeta.DELETE_TIME)));
			this.setIpv6(DataParser.parse(String.class, map.get(HostEnvInfoMeta.IPV6)));
			this.setHostDesc(DataParser.parse(String.class, map.get(HostEnvInfoMeta.HOST_DESC)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(HostEnvInfoMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(HostEnvInfoMeta.ID)));
			this.setVip(DataParser.parse(String.class, map.get(HostEnvInfoMeta.VIP)));
			// others
			this.setInfoSystem(DataParser.parse(InformationSystem.class, map.get(HostEnvInfoMeta.INFO_SYSTEM)));
			this.setCiphertextBoxData(DataParser.parse(CiphertextBoxData.class, map.get(HostEnvInfoMeta.CIPHERTEXT_BOX_DATA)));
			return true;
		} else {
			try {
				this.setSystemId( (String)map.get(HostEnvInfoMeta.SYSTEM_ID));
				this.setNotes( (String)map.get(HostEnvInfoMeta.NOTES));
				this.setVoucher( (String)map.get(HostEnvInfoMeta.VOUCHER));
				this.setIp( (String)map.get(HostEnvInfoMeta.IP));
				this.setUpdateTime( (Date)map.get(HostEnvInfoMeta.UPDATE_TIME));
				this.setLabel( (String)map.get(HostEnvInfoMeta.LABEL));
				this.setVersion( (Integer)map.get(HostEnvInfoMeta.VERSION));
				this.setHostname( (String)map.get(HostEnvInfoMeta.HOSTNAME));
				this.setCreateBy( (String)map.get(HostEnvInfoMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(HostEnvInfoMeta.DELETED));
				this.setCreateTime( (Date)map.get(HostEnvInfoMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(HostEnvInfoMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(HostEnvInfoMeta.DELETE_TIME));
				this.setIpv6( (String)map.get(HostEnvInfoMeta.IPV6));
				this.setHostDesc( (String)map.get(HostEnvInfoMeta.HOST_DESC));
				this.setDeleteBy( (String)map.get(HostEnvInfoMeta.DELETE_BY));
				this.setId( (String)map.get(HostEnvInfoMeta.ID));
				this.setVip( (String)map.get(HostEnvInfoMeta.VIP));
				// others
				this.setInfoSystem( (InformationSystem)map.get(HostEnvInfoMeta.INFO_SYSTEM));
				this.setCiphertextBoxData( (CiphertextBoxData)map.get(HostEnvInfoMeta.CIPHERTEXT_BOX_DATA));
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
			this.setSystemId(DataParser.parse(String.class, r.getValue(HostEnvInfoMeta.SYSTEM_ID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(HostEnvInfoMeta.NOTES)));
			this.setVoucher(DataParser.parse(String.class, r.getValue(HostEnvInfoMeta.VOUCHER)));
			this.setIp(DataParser.parse(String.class, r.getValue(HostEnvInfoMeta.IP)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(HostEnvInfoMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, r.getValue(HostEnvInfoMeta.LABEL)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(HostEnvInfoMeta.VERSION)));
			this.setHostname(DataParser.parse(String.class, r.getValue(HostEnvInfoMeta.HOSTNAME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(HostEnvInfoMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(HostEnvInfoMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(HostEnvInfoMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(HostEnvInfoMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(HostEnvInfoMeta.DELETE_TIME)));
			this.setIpv6(DataParser.parse(String.class, r.getValue(HostEnvInfoMeta.IPV6)));
			this.setHostDesc(DataParser.parse(String.class, r.getValue(HostEnvInfoMeta.HOST_DESC)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(HostEnvInfoMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(HostEnvInfoMeta.ID)));
			this.setVip(DataParser.parse(String.class, r.getValue(HostEnvInfoMeta.VIP)));
			return true;
		} else {
			try {
				this.setSystemId( (String)r.getValue(HostEnvInfoMeta.SYSTEM_ID));
				this.setNotes( (String)r.getValue(HostEnvInfoMeta.NOTES));
				this.setVoucher( (String)r.getValue(HostEnvInfoMeta.VOUCHER));
				this.setIp( (String)r.getValue(HostEnvInfoMeta.IP));
				this.setUpdateTime( (Date)r.getValue(HostEnvInfoMeta.UPDATE_TIME));
				this.setLabel( (String)r.getValue(HostEnvInfoMeta.LABEL));
				this.setVersion( (Integer)r.getValue(HostEnvInfoMeta.VERSION));
				this.setHostname( (String)r.getValue(HostEnvInfoMeta.HOSTNAME));
				this.setCreateBy( (String)r.getValue(HostEnvInfoMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(HostEnvInfoMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(HostEnvInfoMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(HostEnvInfoMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(HostEnvInfoMeta.DELETE_TIME));
				this.setIpv6( (String)r.getValue(HostEnvInfoMeta.IPV6));
				this.setHostDesc( (String)r.getValue(HostEnvInfoMeta.HOST_DESC));
				this.setDeleteBy( (String)r.getValue(HostEnvInfoMeta.DELETE_BY));
				this.setId( (String)r.getValue(HostEnvInfoMeta.ID));
				this.setVip( (String)r.getValue(HostEnvInfoMeta.VIP));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}