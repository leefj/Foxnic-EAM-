package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_DOWNLOAD_LOG;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.oa.meta.DownloadLogMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 下载日志
 * <p>下载日志 , 数据表 oa_download_log 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-15 12:00:48
 * @sign 9824454B661FA2FE6884810CBEE9A1EA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_download_log")
@ApiModel(description = "下载日志 ; 下载日志 , 数据表 oa_download_log 的PO类型")
public class DownloadLog extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_DOWNLOAD_LOG.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 文件：文件
	*/
	@ApiModelProperty(required = false,value="文件" , notes = "文件")
	private String recId;
	
	/**
	 * 用户：用户
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "用户")
	private String userId;
	
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
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
	public DownloadLog setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 文件<br>
	 * 文件
	 * @return 文件
	*/
	public String getRecId() {
		return recId;
	}
	
	/**
	 * 设置 文件
	 * @param recId 文件
	 * @return 当前对象
	*/
	public DownloadLog setRecId(String recId) {
		this.recId=recId;
		return this;
	}
	
	/**
	 * 获得 用户<br>
	 * 用户
	 * @return 用户
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 用户
	 * @param userId 用户
	 * @return 当前对象
	*/
	public DownloadLog setUserId(String userId) {
		this.userId=userId;
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
	public DownloadLog setCreateBy(String createBy) {
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
	public DownloadLog setCreateTime(Date createTime) {
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
	public DownloadLog setUpdateBy(String updateBy) {
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
	public DownloadLog setUpdateTime(Date updateTime) {
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
	public DownloadLog setDeleted(Integer deleted) {
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
	public DownloadLog setDeleted(Boolean deletedBool) {
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
	public DownloadLog setDeleteBy(String deleteBy) {
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
	public DownloadLog setDeleteTime(Date deleteTime) {
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
	public DownloadLog setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DownloadLog , 转换好的 DownloadLog 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DownloadLog , 转换好的 PoJo 对象
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
	public DownloadLog clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DownloadLog duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.DownloadLogMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.DownloadLogMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setRecId(this.getRecId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DownloadLog clone(boolean deep) {
		return EntityContext.clone(DownloadLog.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DownloadLog
	 * @param downloadLogMap 包含实体信息的 Map 对象
	 * @return DownloadLog , 转换好的的 DownloadLog 对象
	*/
	@Transient
	public static DownloadLog createFrom(Map<String,Object> downloadLogMap) {
		if(downloadLogMap==null) return null;
		DownloadLog po = create();
		EntityContext.copyProperties(po,downloadLogMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DownloadLog
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DownloadLog , 转换好的的 DownloadLog 对象
	*/
	@Transient
	public static DownloadLog createFrom(Object pojo) {
		if(pojo==null) return null;
		DownloadLog po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DownloadLog，等同于 new
	 * @return DownloadLog 对象
	*/
	@Transient
	public static DownloadLog create() {
		return new com.dt.platform.domain.oa.meta.DownloadLogMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(DownloadLogMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DownloadLogMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DownloadLogMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DownloadLogMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DownloadLogMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DownloadLogMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DownloadLogMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(DownloadLogMeta.ID)));
			this.setUserId(DataParser.parse(String.class, map.get(DownloadLogMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DownloadLogMeta.VERSION)));
			this.setRecId(DataParser.parse(String.class, map.get(DownloadLogMeta.REC_ID)));
			// others
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(DownloadLogMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DownloadLogMeta.DELETED));
				this.setCreateTime( (Date)map.get(DownloadLogMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(DownloadLogMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DownloadLogMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(DownloadLogMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(DownloadLogMeta.UPDATE_TIME));
				this.setId( (String)map.get(DownloadLogMeta.ID));
				this.setUserId( (String)map.get(DownloadLogMeta.USER_ID));
				this.setVersion( (Integer)map.get(DownloadLogMeta.VERSION));
				this.setRecId( (String)map.get(DownloadLogMeta.REC_ID));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DownloadLogMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DownloadLogMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DownloadLogMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DownloadLogMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DownloadLogMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DownloadLogMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DownloadLogMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(DownloadLogMeta.ID)));
			this.setUserId(DataParser.parse(String.class, r.getValue(DownloadLogMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DownloadLogMeta.VERSION)));
			this.setRecId(DataParser.parse(String.class, r.getValue(DownloadLogMeta.REC_ID)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(DownloadLogMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DownloadLogMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(DownloadLogMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(DownloadLogMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DownloadLogMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(DownloadLogMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(DownloadLogMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(DownloadLogMeta.ID));
				this.setUserId( (String)r.getValue(DownloadLogMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(DownloadLogMeta.VERSION));
				this.setRecId( (String)r.getValue(DownloadLogMeta.REC_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}