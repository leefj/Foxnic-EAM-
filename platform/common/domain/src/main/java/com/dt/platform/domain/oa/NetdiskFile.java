package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_NETDISK_FILE;
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
import com.dt.platform.domain.oa.meta.NetdiskFileMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 文件
 * <p>文件 , 数据表 oa_netdisk_file 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-23 07:46:34
 * @sign F7554909F995A13A33688B47A593E0A0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_netdisk_file")
@ApiModel(description = "文件 ; 文件 , 数据表 oa_netdisk_file 的PO类型")
public class NetdiskFile extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_NETDISK_FILE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "757720426016145408")
	private String id;
	
	/**
	 * 文件：文件
	*/
	@ApiModelProperty(required = false,value="文件" , notes = "文件" , example = "757720421012340736")
	private String originFileId;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "91dc69b54a0a2e2b2e5bc213192bb517.jpeg")
	private String fileName;
	
	/**
	 * 大小：大小
	*/
	@ApiModelProperty(required = false,value="大小" , notes = "大小" , example = "13534")
	private String fileSize;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private String fileType;
	
	/**
	 * 是否收藏：是否收藏
	*/
	@ApiModelProperty(required = false,value="是否收藏" , notes = "是否收藏")
	private String isFavourite;
	
	/**
	 * 回收站：回收站
	*/
	@ApiModelProperty(required = false,value="回收站" , notes = "回收站" , example = "N")
	private String inRecycle;
	
	/**
	 * 用户：用户
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "用户" , example = "E001")
	private String userId;
	
	/**
	 * 文件夹：文件夹
	*/
	@ApiModelProperty(required = false,value="文件夹" , notes = "文件夹" , example = "space")
	private String folderId;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本" , example = "1")
	private Integer version;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-09-22 09:50:27")
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
	 * netdiskOriginFile：netdiskOriginFile
	*/
	@ApiModelProperty(required = false,value="netdiskOriginFile" , notes = "netdiskOriginFile")
	private NetdiskOriginFile netdiskOriginFile;
	
	/**
	 * netdiskFolder：netdiskFolder
	*/
	@ApiModelProperty(required = false,value="netdiskFolder" , notes = "netdiskFolder")
	private NetdiskFolder netdiskFolder;
	
	/**
	 * ownerUser：ownerUser
	*/
	@ApiModelProperty(required = false,value="ownerUser" , notes = "ownerUser")
	private Employee ownerUser;
	
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
	public NetdiskFile setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 文件<br>
	 * 文件
	 * @return 文件
	*/
	public String getOriginFileId() {
		return originFileId;
	}
	
	/**
	 * 设置 文件
	 * @param originFileId 文件
	 * @return 当前对象
	*/
	public NetdiskFile setOriginFileId(String originFileId) {
		this.originFileId=originFileId;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * 设置 名称
	 * @param fileName 名称
	 * @return 当前对象
	*/
	public NetdiskFile setFileName(String fileName) {
		this.fileName=fileName;
		return this;
	}
	
	/**
	 * 获得 大小<br>
	 * 大小
	 * @return 大小
	*/
	public String getFileSize() {
		return fileSize;
	}
	
	/**
	 * 设置 大小
	 * @param fileSize 大小
	 * @return 当前对象
	*/
	public NetdiskFile setFileSize(String fileSize) {
		this.fileSize=fileSize;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getFileType() {
		return fileType;
	}
	
	/**
	 * 设置 类型
	 * @param fileType 类型
	 * @return 当前对象
	*/
	public NetdiskFile setFileType(String fileType) {
		this.fileType=fileType;
		return this;
	}
	
	/**
	 * 获得 是否收藏<br>
	 * 是否收藏
	 * @return 是否收藏
	*/
	public String getIsFavourite() {
		return isFavourite;
	}
	
	/**
	 * 设置 是否收藏
	 * @param isFavourite 是否收藏
	 * @return 当前对象
	*/
	public NetdiskFile setIsFavourite(String isFavourite) {
		this.isFavourite=isFavourite;
		return this;
	}
	
	/**
	 * 获得 回收站<br>
	 * 回收站
	 * @return 回收站
	*/
	public String getInRecycle() {
		return inRecycle;
	}
	
	/**
	 * 设置 回收站
	 * @param inRecycle 回收站
	 * @return 当前对象
	*/
	public NetdiskFile setInRecycle(String inRecycle) {
		this.inRecycle=inRecycle;
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
	public NetdiskFile setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 文件夹<br>
	 * 文件夹
	 * @return 文件夹
	*/
	public String getFolderId() {
		return folderId;
	}
	
	/**
	 * 设置 文件夹
	 * @param folderId 文件夹
	 * @return 当前对象
	*/
	public NetdiskFile setFolderId(String folderId) {
		this.folderId=folderId;
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
	public NetdiskFile setVersion(Integer version) {
		this.version=version;
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
	public NetdiskFile setCreateBy(String createBy) {
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
	public NetdiskFile setCreateTime(Date createTime) {
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
	public NetdiskFile setUpdateBy(String updateBy) {
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
	public NetdiskFile setUpdateTime(Date updateTime) {
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
	public NetdiskFile setDeleted(Integer deleted) {
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
	public NetdiskFile setDeleted(Boolean deletedBool) {
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
	public NetdiskFile setDeleteBy(String deleteBy) {
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
	public NetdiskFile setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 netdiskOriginFile<br>
	 * netdiskOriginFile
	 * @return netdiskOriginFile
	*/
	public NetdiskOriginFile getNetdiskOriginFile() {
		return netdiskOriginFile;
	}
	
	/**
	 * 设置 netdiskOriginFile
	 * @param netdiskOriginFile netdiskOriginFile
	 * @return 当前对象
	*/
	public NetdiskFile setNetdiskOriginFile(NetdiskOriginFile netdiskOriginFile) {
		this.netdiskOriginFile=netdiskOriginFile;
		return this;
	}
	
	/**
	 * 获得 netdiskFolder<br>
	 * netdiskFolder
	 * @return netdiskFolder
	*/
	public NetdiskFolder getNetdiskFolder() {
		return netdiskFolder;
	}
	
	/**
	 * 设置 netdiskFolder
	 * @param netdiskFolder netdiskFolder
	 * @return 当前对象
	*/
	public NetdiskFile setNetdiskFolder(NetdiskFolder netdiskFolder) {
		this.netdiskFolder=netdiskFolder;
		return this;
	}
	
	/**
	 * 获得 ownerUser<br>
	 * ownerUser
	 * @return ownerUser
	*/
	public Employee getOwnerUser() {
		return ownerUser;
	}
	
	/**
	 * 设置 ownerUser
	 * @param ownerUser ownerUser
	 * @return 当前对象
	*/
	public NetdiskFile setOwnerUser(Employee ownerUser) {
		this.ownerUser=ownerUser;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return NetdiskFile , 转换好的 NetdiskFile 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return NetdiskFile , 转换好的 PoJo 对象
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
	public NetdiskFile clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public NetdiskFile duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.NetdiskFileMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.NetdiskFileMeta.$$proxy$$();
		inst.setOriginFileId(this.getOriginFileId());
		inst.setFileName(this.getFileName());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setFolderId(this.getFolderId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setFileSize(this.getFileSize());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setInRecycle(this.getInRecycle());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setIsFavourite(this.getIsFavourite());
		inst.setFileType(this.getFileType());
		if(all) {
			inst.setNetdiskFolder(this.getNetdiskFolder());
			inst.setOwnerUser(this.getOwnerUser());
			inst.setNetdiskOriginFile(this.getNetdiskOriginFile());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public NetdiskFile clone(boolean deep) {
		return EntityContext.clone(NetdiskFile.class,this,deep);
	}

	/**
	 * 将 Map 转换成 NetdiskFile
	 * @param netdiskFileMap 包含实体信息的 Map 对象
	 * @return NetdiskFile , 转换好的的 NetdiskFile 对象
	*/
	@Transient
	public static NetdiskFile createFrom(Map<String,Object> netdiskFileMap) {
		if(netdiskFileMap==null) return null;
		NetdiskFile po = create();
		EntityContext.copyProperties(po,netdiskFileMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 NetdiskFile
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return NetdiskFile , 转换好的的 NetdiskFile 对象
	*/
	@Transient
	public static NetdiskFile createFrom(Object pojo) {
		if(pojo==null) return null;
		NetdiskFile po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 NetdiskFile，等同于 new
	 * @return NetdiskFile 对象
	*/
	@Transient
	public static NetdiskFile create() {
		return new com.dt.platform.domain.oa.meta.NetdiskFileMeta.$$proxy$$();
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
			this.setOriginFileId(DataParser.parse(String.class, map.get(NetdiskFileMeta.ORIGIN_FILE_ID)));
			this.setFileName(DataParser.parse(String.class, map.get(NetdiskFileMeta.FILE_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(NetdiskFileMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(NetdiskFileMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(NetdiskFileMeta.VERSION)));
			this.setFolderId(DataParser.parse(String.class, map.get(NetdiskFileMeta.FOLDER_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(NetdiskFileMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(NetdiskFileMeta.DELETED)));
			this.setFileSize(DataParser.parse(String.class, map.get(NetdiskFileMeta.FILE_SIZE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(NetdiskFileMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(NetdiskFileMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(NetdiskFileMeta.DELETE_TIME)));
			this.setInRecycle(DataParser.parse(String.class, map.get(NetdiskFileMeta.IN_RECYCLE)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(NetdiskFileMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(NetdiskFileMeta.ID)));
			this.setIsFavourite(DataParser.parse(String.class, map.get(NetdiskFileMeta.IS_FAVOURITE)));
			this.setFileType(DataParser.parse(String.class, map.get(NetdiskFileMeta.FILE_TYPE)));
			// others
			this.setNetdiskFolder(DataParser.parse(NetdiskFolder.class, map.get(NetdiskFileMeta.NETDISK_FOLDER)));
			this.setOwnerUser(DataParser.parse(Employee.class, map.get(NetdiskFileMeta.OWNER_USER)));
			this.setNetdiskOriginFile(DataParser.parse(NetdiskOriginFile.class, map.get(NetdiskFileMeta.NETDISK_ORIGIN_FILE)));
			return true;
		} else {
			try {
				this.setOriginFileId( (String)map.get(NetdiskFileMeta.ORIGIN_FILE_ID));
				this.setFileName( (String)map.get(NetdiskFileMeta.FILE_NAME));
				this.setUpdateTime( (Date)map.get(NetdiskFileMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(NetdiskFileMeta.USER_ID));
				this.setVersion( (Integer)map.get(NetdiskFileMeta.VERSION));
				this.setFolderId( (String)map.get(NetdiskFileMeta.FOLDER_ID));
				this.setCreateBy( (String)map.get(NetdiskFileMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(NetdiskFileMeta.DELETED));
				this.setFileSize( (String)map.get(NetdiskFileMeta.FILE_SIZE));
				this.setCreateTime( (Date)map.get(NetdiskFileMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(NetdiskFileMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(NetdiskFileMeta.DELETE_TIME));
				this.setInRecycle( (String)map.get(NetdiskFileMeta.IN_RECYCLE));
				this.setDeleteBy( (String)map.get(NetdiskFileMeta.DELETE_BY));
				this.setId( (String)map.get(NetdiskFileMeta.ID));
				this.setIsFavourite( (String)map.get(NetdiskFileMeta.IS_FAVOURITE));
				this.setFileType( (String)map.get(NetdiskFileMeta.FILE_TYPE));
				// others
				this.setNetdiskFolder( (NetdiskFolder)map.get(NetdiskFileMeta.NETDISK_FOLDER));
				this.setOwnerUser( (Employee)map.get(NetdiskFileMeta.OWNER_USER));
				this.setNetdiskOriginFile( (NetdiskOriginFile)map.get(NetdiskFileMeta.NETDISK_ORIGIN_FILE));
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
			this.setOriginFileId(DataParser.parse(String.class, r.getValue(NetdiskFileMeta.ORIGIN_FILE_ID)));
			this.setFileName(DataParser.parse(String.class, r.getValue(NetdiskFileMeta.FILE_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(NetdiskFileMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(NetdiskFileMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(NetdiskFileMeta.VERSION)));
			this.setFolderId(DataParser.parse(String.class, r.getValue(NetdiskFileMeta.FOLDER_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(NetdiskFileMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(NetdiskFileMeta.DELETED)));
			this.setFileSize(DataParser.parse(String.class, r.getValue(NetdiskFileMeta.FILE_SIZE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(NetdiskFileMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(NetdiskFileMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(NetdiskFileMeta.DELETE_TIME)));
			this.setInRecycle(DataParser.parse(String.class, r.getValue(NetdiskFileMeta.IN_RECYCLE)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(NetdiskFileMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(NetdiskFileMeta.ID)));
			this.setIsFavourite(DataParser.parse(String.class, r.getValue(NetdiskFileMeta.IS_FAVOURITE)));
			this.setFileType(DataParser.parse(String.class, r.getValue(NetdiskFileMeta.FILE_TYPE)));
			return true;
		} else {
			try {
				this.setOriginFileId( (String)r.getValue(NetdiskFileMeta.ORIGIN_FILE_ID));
				this.setFileName( (String)r.getValue(NetdiskFileMeta.FILE_NAME));
				this.setUpdateTime( (Date)r.getValue(NetdiskFileMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(NetdiskFileMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(NetdiskFileMeta.VERSION));
				this.setFolderId( (String)r.getValue(NetdiskFileMeta.FOLDER_ID));
				this.setCreateBy( (String)r.getValue(NetdiskFileMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(NetdiskFileMeta.DELETED));
				this.setFileSize( (String)r.getValue(NetdiskFileMeta.FILE_SIZE));
				this.setCreateTime( (Date)r.getValue(NetdiskFileMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(NetdiskFileMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(NetdiskFileMeta.DELETE_TIME));
				this.setInRecycle( (String)r.getValue(NetdiskFileMeta.IN_RECYCLE));
				this.setDeleteBy( (String)r.getValue(NetdiskFileMeta.DELETE_BY));
				this.setId( (String)r.getValue(NetdiskFileMeta.ID));
				this.setIsFavourite( (String)r.getValue(NetdiskFileMeta.IS_FAVOURITE));
				this.setFileType( (String)r.getValue(NetdiskFileMeta.FILE_TYPE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}