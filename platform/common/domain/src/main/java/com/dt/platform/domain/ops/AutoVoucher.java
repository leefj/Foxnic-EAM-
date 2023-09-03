package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_AUTO_VOUCHER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.AutoVoucherMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 自动化凭证
 * <p>自动化凭证 , 数据表 ops_auto_voucher 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-31 18:20:41
 * @sign AE11B48A699479E258047CF6BA32B0DC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_auto_voucher")
@ApiModel(description = "自动化凭证 ; 自动化凭证 , 数据表 ops_auto_voucher 的PO类型")
public class AutoVoucher extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_AUTO_VOUCHER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 账户：账户
	*/
	@ApiModelProperty(required = false,value="账户" , notes = "账户")
	private String account;
	
	/**
	 * 凭证：凭证
	*/
	@ApiModelProperty(required = false,value="凭证" , notes = "凭证")
	private String voucher;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本")
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
	public AutoVoucher setId(String id) {
		this.id=id;
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
	public AutoVoucher setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 账户<br>
	 * 账户
	 * @return 账户
	*/
	public String getAccount() {
		return account;
	}
	
	/**
	 * 设置 账户
	 * @param account 账户
	 * @return 当前对象
	*/
	public AutoVoucher setAccount(String account) {
		this.account=account;
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
	public AutoVoucher setVoucher(String voucher) {
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
	public AutoVoucher setNotes(String notes) {
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
	public AutoVoucher setCreateBy(String createBy) {
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
	public AutoVoucher setCreateTime(Date createTime) {
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
	public AutoVoucher setUpdateBy(String updateBy) {
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
	public AutoVoucher setUpdateTime(Date updateTime) {
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
	public AutoVoucher setDeleted(Integer deleted) {
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
	public AutoVoucher setDeleted(Boolean deletedBool) {
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
	public AutoVoucher setDeleteBy(String deleteBy) {
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
	public AutoVoucher setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 版本
	 * @param version 版本
	 * @return 当前对象
	*/
	public AutoVoucher setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AutoVoucher , 转换好的 AutoVoucher 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AutoVoucher , 转换好的 PoJo 对象
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
	public AutoVoucher clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AutoVoucher duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.AutoVoucherMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.AutoVoucherMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setVoucher(this.getVoucher());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setAccount(this.getAccount());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AutoVoucher clone(boolean deep) {
		return EntityContext.clone(AutoVoucher.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AutoVoucher
	 * @param autoVoucherMap 包含实体信息的 Map 对象
	 * @return AutoVoucher , 转换好的的 AutoVoucher 对象
	*/
	@Transient
	public static AutoVoucher createFrom(Map<String,Object> autoVoucherMap) {
		if(autoVoucherMap==null) return null;
		AutoVoucher po = create();
		EntityContext.copyProperties(po,autoVoucherMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AutoVoucher
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AutoVoucher , 转换好的的 AutoVoucher 对象
	*/
	@Transient
	public static AutoVoucher createFrom(Object pojo) {
		if(pojo==null) return null;
		AutoVoucher po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AutoVoucher，等同于 new
	 * @return AutoVoucher 对象
	*/
	@Transient
	public static AutoVoucher create() {
		return new com.dt.platform.domain.ops.meta.AutoVoucherMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AutoVoucherMeta.NOTES)));
			this.setVoucher(DataParser.parse(String.class, map.get(AutoVoucherMeta.VOUCHER)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AutoVoucherMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AutoVoucherMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AutoVoucherMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AutoVoucherMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AutoVoucherMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AutoVoucherMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AutoVoucherMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AutoVoucherMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AutoVoucherMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AutoVoucherMeta.ID)));
			this.setAccount(DataParser.parse(String.class, map.get(AutoVoucherMeta.ACCOUNT)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AutoVoucherMeta.NOTES));
				this.setVoucher( (String)map.get(AutoVoucherMeta.VOUCHER));
				this.setUpdateTime( (Date)map.get(AutoVoucherMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AutoVoucherMeta.VERSION));
				this.setCreateBy( (String)map.get(AutoVoucherMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AutoVoucherMeta.DELETED));
				this.setCreateTime( (Date)map.get(AutoVoucherMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AutoVoucherMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AutoVoucherMeta.DELETE_TIME));
				this.setName( (String)map.get(AutoVoucherMeta.NAME));
				this.setDeleteBy( (String)map.get(AutoVoucherMeta.DELETE_BY));
				this.setId( (String)map.get(AutoVoucherMeta.ID));
				this.setAccount( (String)map.get(AutoVoucherMeta.ACCOUNT));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AutoVoucherMeta.NOTES)));
			this.setVoucher(DataParser.parse(String.class, r.getValue(AutoVoucherMeta.VOUCHER)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AutoVoucherMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AutoVoucherMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AutoVoucherMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AutoVoucherMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AutoVoucherMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AutoVoucherMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AutoVoucherMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AutoVoucherMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AutoVoucherMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AutoVoucherMeta.ID)));
			this.setAccount(DataParser.parse(String.class, r.getValue(AutoVoucherMeta.ACCOUNT)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AutoVoucherMeta.NOTES));
				this.setVoucher( (String)r.getValue(AutoVoucherMeta.VOUCHER));
				this.setUpdateTime( (Date)r.getValue(AutoVoucherMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AutoVoucherMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AutoVoucherMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AutoVoucherMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AutoVoucherMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AutoVoucherMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AutoVoucherMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AutoVoucherMeta.NAME));
				this.setDeleteBy( (String)r.getValue(AutoVoucherMeta.DELETE_BY));
				this.setId( (String)r.getValue(AutoVoucherMeta.ID));
				this.setAccount( (String)r.getValue(AutoVoucherMeta.ACCOUNT));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}