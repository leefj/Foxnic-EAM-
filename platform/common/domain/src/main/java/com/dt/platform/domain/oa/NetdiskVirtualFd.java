package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_NETDISK_VIRTUAL_FD;
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
import com.dt.platform.domain.oa.meta.NetdiskVirtualFdMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 虚拟文件
 * <p>虚拟文件 , 数据表 oa_netdisk_virtual_fd 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-22 21:55:06
 * @sign 88C139F935CFF0FF364A97D55FB5F38E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_netdisk_virtual_fd")
@ApiModel(description = "虚拟文件 ; 虚拟文件 , 数据表 oa_netdisk_virtual_fd 的PO类型")
public class NetdiskVirtualFd extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_NETDISK_VIRTUAL_FD.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "11")
	private String id;
	
	/**
	 * 文件：文件
	*/
	@ApiModelProperty(required = false,value="文件" , notes = "文件")
	private String fdId;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String fdName;
	
	/**
	 * 大小：大小
	*/
	@ApiModelProperty(required = false,value="大小" , notes = "大小")
	private String fdSize;
	
	/**
	 * 文件类型：文件类型
	*/
	@ApiModelProperty(required = false,value="文件类型" , notes = "文件类型")
	private String fdFileType;
	
	/**
	 * 路径编号：路径编号
	*/
	@ApiModelProperty(required = false,value="路径编号" , notes = "路径编号")
	private String fdHierarchy;
	
	/**
	 * 路径名称：路径名称
	*/
	@ApiModelProperty(required = false,value="路径名称" , notes = "路径名称")
	private String fdHierarchyName;
	
	/**
	 * 是否收藏：是否收藏
	*/
	@ApiModelProperty(required = false,value="是否收藏" , notes = "是否收藏")
	private String isFavourite;
	
	/**
	 * 文件夹：文件夹
	*/
	@ApiModelProperty(required = false,value="文件夹" , notes = "文件夹")
	private String folderId;
	
	/**
	 * fd类型：fd类型
	*/
	@ApiModelProperty(required = false,value="fd类型" , notes = "fd类型")
	private String fdType;
	
	/**
	 * 用户：用户
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "用户")
	private String userId;
	
	/**
	 * 父节点：父节点
	*/
	@ApiModelProperty(required = false,value="父节点" , notes = "父节点")
	private String parentId;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本" , example = "1")
	private Integer version;
	
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
	 * netdiskFile：netdiskFile
	*/
	@ApiModelProperty(required = false,value="netdiskFile" , notes = "netdiskFile")
	private NetdiskFile netdiskFile;
	
	/**
	 * netdiskOriginFile：netdiskOriginFile
	*/
	@ApiModelProperty(required = false,value="netdiskOriginFile" , notes = "netdiskOriginFile")
	private NetdiskOriginFile netdiskOriginFile;
	
	/**
	 * searchFolderId：searchFolderId
	*/
	@ApiModelProperty(required = false,value="searchFolderId" , notes = "searchFolderId")
	private String searchFolderId;
	
	/**
	 * searchFavourite：searchFavourite
	*/
	@ApiModelProperty(required = false,value="searchFavourite" , notes = "searchFavourite")
	private String searchFavourite;
	
	/**
	 * searchRecycle：searchRecycle
	*/
	@ApiModelProperty(required = false,value="searchRecycle" , notes = "searchRecycle")
	private String searchRecycle;
	
	/**
	 * searchFileType：searchFileType
	*/
	@ApiModelProperty(required = false,value="searchFileType" , notes = "searchFileType")
	private String searchFileType;
	
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
	public NetdiskVirtualFd setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 文件<br>
	 * 文件
	 * @return 文件
	*/
	public String getFdId() {
		return fdId;
	}
	
	/**
	 * 设置 文件
	 * @param fdId 文件
	 * @return 当前对象
	*/
	public NetdiskVirtualFd setFdId(String fdId) {
		this.fdId=fdId;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getFdName() {
		return fdName;
	}
	
	/**
	 * 设置 名称
	 * @param fdName 名称
	 * @return 当前对象
	*/
	public NetdiskVirtualFd setFdName(String fdName) {
		this.fdName=fdName;
		return this;
	}
	
	/**
	 * 获得 大小<br>
	 * 大小
	 * @return 大小
	*/
	public String getFdSize() {
		return fdSize;
	}
	
	/**
	 * 设置 大小
	 * @param fdSize 大小
	 * @return 当前对象
	*/
	public NetdiskVirtualFd setFdSize(String fdSize) {
		this.fdSize=fdSize;
		return this;
	}
	
	/**
	 * 获得 文件类型<br>
	 * 文件类型
	 * @return 文件类型
	*/
	public String getFdFileType() {
		return fdFileType;
	}
	
	/**
	 * 设置 文件类型
	 * @param fdFileType 文件类型
	 * @return 当前对象
	*/
	public NetdiskVirtualFd setFdFileType(String fdFileType) {
		this.fdFileType=fdFileType;
		return this;
	}
	
	/**
	 * 获得 路径编号<br>
	 * 路径编号
	 * @return 路径编号
	*/
	public String getFdHierarchy() {
		return fdHierarchy;
	}
	
	/**
	 * 设置 路径编号
	 * @param fdHierarchy 路径编号
	 * @return 当前对象
	*/
	public NetdiskVirtualFd setFdHierarchy(String fdHierarchy) {
		this.fdHierarchy=fdHierarchy;
		return this;
	}
	
	/**
	 * 获得 路径名称<br>
	 * 路径名称
	 * @return 路径名称
	*/
	public String getFdHierarchyName() {
		return fdHierarchyName;
	}
	
	/**
	 * 设置 路径名称
	 * @param fdHierarchyName 路径名称
	 * @return 当前对象
	*/
	public NetdiskVirtualFd setFdHierarchyName(String fdHierarchyName) {
		this.fdHierarchyName=fdHierarchyName;
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
	public NetdiskVirtualFd setIsFavourite(String isFavourite) {
		this.isFavourite=isFavourite;
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
	public NetdiskVirtualFd setFolderId(String folderId) {
		this.folderId=folderId;
		return this;
	}
	
	/**
	 * 获得 fd类型<br>
	 * fd类型
	 * @return fd类型
	*/
	public String getFdType() {
		return fdType;
	}
	
	/**
	 * 设置 fd类型
	 * @param fdType fd类型
	 * @return 当前对象
	*/
	public NetdiskVirtualFd setFdType(String fdType) {
		this.fdType=fdType;
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
	public NetdiskVirtualFd setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 父节点<br>
	 * 父节点
	 * @return 父节点
	*/
	public String getParentId() {
		return parentId;
	}
	
	/**
	 * 设置 父节点
	 * @param parentId 父节点
	 * @return 当前对象
	*/
	public NetdiskVirtualFd setParentId(String parentId) {
		this.parentId=parentId;
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
	public NetdiskVirtualFd setVersion(Integer version) {
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
	public NetdiskVirtualFd setCreateBy(String createBy) {
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
	public NetdiskVirtualFd setCreateTime(Date createTime) {
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
	public NetdiskVirtualFd setUpdateBy(String updateBy) {
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
	public NetdiskVirtualFd setUpdateTime(Date updateTime) {
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
	public NetdiskVirtualFd setDeleted(Integer deleted) {
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
	public NetdiskVirtualFd setDeleted(Boolean deletedBool) {
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
	public NetdiskVirtualFd setDeleteBy(String deleteBy) {
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
	public NetdiskVirtualFd setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 netdiskFile<br>
	 * netdiskFile
	 * @return netdiskFile
	*/
	public NetdiskFile getNetdiskFile() {
		return netdiskFile;
	}
	
	/**
	 * 设置 netdiskFile
	 * @param netdiskFile netdiskFile
	 * @return 当前对象
	*/
	public NetdiskVirtualFd setNetdiskFile(NetdiskFile netdiskFile) {
		this.netdiskFile=netdiskFile;
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
	public NetdiskVirtualFd setNetdiskOriginFile(NetdiskOriginFile netdiskOriginFile) {
		this.netdiskOriginFile=netdiskOriginFile;
		return this;
	}
	
	/**
	 * 获得 searchFolderId<br>
	 * searchFolderId
	 * @return searchFolderId
	*/
	public String getSearchFolderId() {
		return searchFolderId;
	}
	
	/**
	 * 设置 searchFolderId
	 * @param searchFolderId searchFolderId
	 * @return 当前对象
	*/
	public NetdiskVirtualFd setSearchFolderId(String searchFolderId) {
		this.searchFolderId=searchFolderId;
		return this;
	}
	
	/**
	 * 获得 searchFavourite<br>
	 * searchFavourite
	 * @return searchFavourite
	*/
	public String getSearchFavourite() {
		return searchFavourite;
	}
	
	/**
	 * 设置 searchFavourite
	 * @param searchFavourite searchFavourite
	 * @return 当前对象
	*/
	public NetdiskVirtualFd setSearchFavourite(String searchFavourite) {
		this.searchFavourite=searchFavourite;
		return this;
	}
	
	/**
	 * 获得 searchRecycle<br>
	 * searchRecycle
	 * @return searchRecycle
	*/
	public String getSearchRecycle() {
		return searchRecycle;
	}
	
	/**
	 * 设置 searchRecycle
	 * @param searchRecycle searchRecycle
	 * @return 当前对象
	*/
	public NetdiskVirtualFd setSearchRecycle(String searchRecycle) {
		this.searchRecycle=searchRecycle;
		return this;
	}
	
	/**
	 * 获得 searchFileType<br>
	 * searchFileType
	 * @return searchFileType
	*/
	public String getSearchFileType() {
		return searchFileType;
	}
	
	/**
	 * 设置 searchFileType
	 * @param searchFileType searchFileType
	 * @return 当前对象
	*/
	public NetdiskVirtualFd setSearchFileType(String searchFileType) {
		this.searchFileType=searchFileType;
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
	public NetdiskVirtualFd setOwnerUser(Employee ownerUser) {
		this.ownerUser=ownerUser;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return NetdiskVirtualFd , 转换好的 NetdiskVirtualFd 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return NetdiskVirtualFd , 转换好的 PoJo 对象
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
	public NetdiskVirtualFd clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public NetdiskVirtualFd duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.NetdiskVirtualFdMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.NetdiskVirtualFdMeta.$$proxy$$();
		inst.setFdHierarchy(this.getFdHierarchy());
		inst.setFdSize(this.getFdSize());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setFolderId(this.getFolderId());
		inst.setParentId(this.getParentId());
		inst.setFdType(this.getFdType());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setFdFileType(this.getFdFileType());
		inst.setFdHierarchyName(this.getFdHierarchyName());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setFdId(this.getFdId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setFdName(this.getFdName());
		inst.setIsFavourite(this.getIsFavourite());
		if(all) {
			inst.setSearchFavourite(this.getSearchFavourite());
			inst.setNetdiskFile(this.getNetdiskFile());
			inst.setSearchFolderId(this.getSearchFolderId());
			inst.setOwnerUser(this.getOwnerUser());
			inst.setSearchRecycle(this.getSearchRecycle());
			inst.setNetdiskOriginFile(this.getNetdiskOriginFile());
			inst.setSearchFileType(this.getSearchFileType());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public NetdiskVirtualFd clone(boolean deep) {
		return EntityContext.clone(NetdiskVirtualFd.class,this,deep);
	}

	/**
	 * 将 Map 转换成 NetdiskVirtualFd
	 * @param netdiskVirtualFdMap 包含实体信息的 Map 对象
	 * @return NetdiskVirtualFd , 转换好的的 NetdiskVirtualFd 对象
	*/
	@Transient
	public static NetdiskVirtualFd createFrom(Map<String,Object> netdiskVirtualFdMap) {
		if(netdiskVirtualFdMap==null) return null;
		NetdiskVirtualFd po = create();
		EntityContext.copyProperties(po,netdiskVirtualFdMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 NetdiskVirtualFd
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return NetdiskVirtualFd , 转换好的的 NetdiskVirtualFd 对象
	*/
	@Transient
	public static NetdiskVirtualFd createFrom(Object pojo) {
		if(pojo==null) return null;
		NetdiskVirtualFd po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 NetdiskVirtualFd，等同于 new
	 * @return NetdiskVirtualFd 对象
	*/
	@Transient
	public static NetdiskVirtualFd create() {
		return new com.dt.platform.domain.oa.meta.NetdiskVirtualFdMeta.$$proxy$$();
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
			this.setFdHierarchy(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.FD_HIERARCHY)));
			this.setFdSize(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.FD_SIZE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(NetdiskVirtualFdMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(NetdiskVirtualFdMeta.VERSION)));
			this.setFolderId(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.FOLDER_ID)));
			this.setParentId(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.PARENT_ID)));
			this.setFdType(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.FD_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(NetdiskVirtualFdMeta.DELETED)));
			this.setFdFileType(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.FD_FILE_TYPE)));
			this.setFdHierarchyName(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.FD_HIERARCHY_NAME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(NetdiskVirtualFdMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(NetdiskVirtualFdMeta.DELETE_TIME)));
			this.setFdId(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.FD_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.ID)));
			this.setFdName(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.FD_NAME)));
			this.setIsFavourite(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.IS_FAVOURITE)));
			// others
			this.setSearchFavourite(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.SEARCH_FAVOURITE)));
			this.setNetdiskFile(DataParser.parse(NetdiskFile.class, map.get(NetdiskVirtualFdMeta.NETDISK_FILE)));
			this.setSearchFolderId(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.SEARCH_FOLDER_ID)));
			this.setOwnerUser(DataParser.parse(Employee.class, map.get(NetdiskVirtualFdMeta.OWNER_USER)));
			this.setSearchRecycle(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.SEARCH_RECYCLE)));
			this.setNetdiskOriginFile(DataParser.parse(NetdiskOriginFile.class, map.get(NetdiskVirtualFdMeta.NETDISK_ORIGIN_FILE)));
			this.setSearchFileType(DataParser.parse(String.class, map.get(NetdiskVirtualFdMeta.SEARCH_FILE_TYPE)));
			return true;
		} else {
			try {
				this.setFdHierarchy( (String)map.get(NetdiskVirtualFdMeta.FD_HIERARCHY));
				this.setFdSize( (String)map.get(NetdiskVirtualFdMeta.FD_SIZE));
				this.setUpdateTime( (Date)map.get(NetdiskVirtualFdMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(NetdiskVirtualFdMeta.USER_ID));
				this.setVersion( (Integer)map.get(NetdiskVirtualFdMeta.VERSION));
				this.setFolderId( (String)map.get(NetdiskVirtualFdMeta.FOLDER_ID));
				this.setParentId( (String)map.get(NetdiskVirtualFdMeta.PARENT_ID));
				this.setFdType( (String)map.get(NetdiskVirtualFdMeta.FD_TYPE));
				this.setCreateBy( (String)map.get(NetdiskVirtualFdMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(NetdiskVirtualFdMeta.DELETED));
				this.setFdFileType( (String)map.get(NetdiskVirtualFdMeta.FD_FILE_TYPE));
				this.setFdHierarchyName( (String)map.get(NetdiskVirtualFdMeta.FD_HIERARCHY_NAME));
				this.setCreateTime( (Date)map.get(NetdiskVirtualFdMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(NetdiskVirtualFdMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(NetdiskVirtualFdMeta.DELETE_TIME));
				this.setFdId( (String)map.get(NetdiskVirtualFdMeta.FD_ID));
				this.setDeleteBy( (String)map.get(NetdiskVirtualFdMeta.DELETE_BY));
				this.setId( (String)map.get(NetdiskVirtualFdMeta.ID));
				this.setFdName( (String)map.get(NetdiskVirtualFdMeta.FD_NAME));
				this.setIsFavourite( (String)map.get(NetdiskVirtualFdMeta.IS_FAVOURITE));
				// others
				this.setSearchFavourite( (String)map.get(NetdiskVirtualFdMeta.SEARCH_FAVOURITE));
				this.setNetdiskFile( (NetdiskFile)map.get(NetdiskVirtualFdMeta.NETDISK_FILE));
				this.setSearchFolderId( (String)map.get(NetdiskVirtualFdMeta.SEARCH_FOLDER_ID));
				this.setOwnerUser( (Employee)map.get(NetdiskVirtualFdMeta.OWNER_USER));
				this.setSearchRecycle( (String)map.get(NetdiskVirtualFdMeta.SEARCH_RECYCLE));
				this.setNetdiskOriginFile( (NetdiskOriginFile)map.get(NetdiskVirtualFdMeta.NETDISK_ORIGIN_FILE));
				this.setSearchFileType( (String)map.get(NetdiskVirtualFdMeta.SEARCH_FILE_TYPE));
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
			this.setFdHierarchy(DataParser.parse(String.class, r.getValue(NetdiskVirtualFdMeta.FD_HIERARCHY)));
			this.setFdSize(DataParser.parse(String.class, r.getValue(NetdiskVirtualFdMeta.FD_SIZE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(NetdiskVirtualFdMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(NetdiskVirtualFdMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(NetdiskVirtualFdMeta.VERSION)));
			this.setFolderId(DataParser.parse(String.class, r.getValue(NetdiskVirtualFdMeta.FOLDER_ID)));
			this.setParentId(DataParser.parse(String.class, r.getValue(NetdiskVirtualFdMeta.PARENT_ID)));
			this.setFdType(DataParser.parse(String.class, r.getValue(NetdiskVirtualFdMeta.FD_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(NetdiskVirtualFdMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(NetdiskVirtualFdMeta.DELETED)));
			this.setFdFileType(DataParser.parse(String.class, r.getValue(NetdiskVirtualFdMeta.FD_FILE_TYPE)));
			this.setFdHierarchyName(DataParser.parse(String.class, r.getValue(NetdiskVirtualFdMeta.FD_HIERARCHY_NAME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(NetdiskVirtualFdMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(NetdiskVirtualFdMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(NetdiskVirtualFdMeta.DELETE_TIME)));
			this.setFdId(DataParser.parse(String.class, r.getValue(NetdiskVirtualFdMeta.FD_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(NetdiskVirtualFdMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(NetdiskVirtualFdMeta.ID)));
			this.setFdName(DataParser.parse(String.class, r.getValue(NetdiskVirtualFdMeta.FD_NAME)));
			this.setIsFavourite(DataParser.parse(String.class, r.getValue(NetdiskVirtualFdMeta.IS_FAVOURITE)));
			return true;
		} else {
			try {
				this.setFdHierarchy( (String)r.getValue(NetdiskVirtualFdMeta.FD_HIERARCHY));
				this.setFdSize( (String)r.getValue(NetdiskVirtualFdMeta.FD_SIZE));
				this.setUpdateTime( (Date)r.getValue(NetdiskVirtualFdMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(NetdiskVirtualFdMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(NetdiskVirtualFdMeta.VERSION));
				this.setFolderId( (String)r.getValue(NetdiskVirtualFdMeta.FOLDER_ID));
				this.setParentId( (String)r.getValue(NetdiskVirtualFdMeta.PARENT_ID));
				this.setFdType( (String)r.getValue(NetdiskVirtualFdMeta.FD_TYPE));
				this.setCreateBy( (String)r.getValue(NetdiskVirtualFdMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(NetdiskVirtualFdMeta.DELETED));
				this.setFdFileType( (String)r.getValue(NetdiskVirtualFdMeta.FD_FILE_TYPE));
				this.setFdHierarchyName( (String)r.getValue(NetdiskVirtualFdMeta.FD_HIERARCHY_NAME));
				this.setCreateTime( (Date)r.getValue(NetdiskVirtualFdMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(NetdiskVirtualFdMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(NetdiskVirtualFdMeta.DELETE_TIME));
				this.setFdId( (String)r.getValue(NetdiskVirtualFdMeta.FD_ID));
				this.setDeleteBy( (String)r.getValue(NetdiskVirtualFdMeta.DELETE_BY));
				this.setId( (String)r.getValue(NetdiskVirtualFdMeta.ID));
				this.setFdName( (String)r.getValue(NetdiskVirtualFdMeta.FD_NAME));
				this.setIsFavourite( (String)r.getValue(NetdiskVirtualFdMeta.IS_FAVOURITE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}