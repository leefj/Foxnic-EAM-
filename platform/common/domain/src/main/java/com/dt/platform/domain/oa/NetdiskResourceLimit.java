package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_NETDISK_RESOURCE_LIMIT;
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
import com.dt.platform.domain.oa.meta.NetdiskResourceLimitMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资源限制
 * <p>资源限制 , 数据表 oa_netdisk_resource_limit 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-27 22:40:34
 * @sign C9A4BCC8EC22D5B638799E1360CE504F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_netdisk_resource_limit")
@ApiModel(description = "资源限制 ; 资源限制 , 数据表 oa_netdisk_resource_limit 的PO类型")
public class NetdiskResourceLimit extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_NETDISK_RESOURCE_LIMIT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "1")
	private String id;
	
	/**
	 * 用户：用户
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "用户" , example = "default")
	private String userId;
	
	/**
	 * 最大容量：M）
	*/
	@ApiModelProperty(required = false,value="最大容量" , notes = "M）" , example = "5120")
	private Long capacitySizeM;
	
	/**
	 * 当前容量：B）
	*/
	@ApiModelProperty(required = false,value="当前容量" , notes = "B）" , example = "0")
	private Long currentSizeB;
	
	/**
	 * 上传大小：M）
	*/
	@ApiModelProperty(required = false,value="上传大小" , notes = "M）" , example = "1024")
	private Long uploadMaxSizeM;
	
	/**
	 * 文件类型：文件类型
	*/
	@ApiModelProperty(required = false,value="文件类型" , notes = "文件类型" , example = "*")
	private String uploadFileType;
	
	/**
	 * 视频播放：视频播放
	*/
	@ApiModelProperty(required = false,value="视频播放" , notes = "视频播放" , example = "y")
	private String playVideoValid;
	
	/**
	 * 音频播放：音频播放
	*/
	@ApiModelProperty(required = false,value="音频播放" , notes = "音频播放" , example = "y")
	private String playMusicValid;
	
	/**
	 * 图片预览：图片预览
	*/
	@ApiModelProperty(required = false,value="图片预览" , notes = "图片预览" , example = "y")
	private String viewPhotoValid;
	
	/**
	 * 文档预览：文档预览
	*/
	@ApiModelProperty(required = false,value="文档预览" , notes = "文档预览" , example = "y")
	private String viewDocValid;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本" , example = "2")
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
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-09-27 08:42:17")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * user：user
	*/
	@ApiModelProperty(required = false,value="user" , notes = "user")
	private Employee user;
	
	/**
	 * capacitySizeValue：capacitySizeValue
	*/
	@ApiModelProperty(required = false,value="capacitySizeValue" , notes = "capacitySizeValue")
	private String capacitySizeValue;
	
	/**
	 * currentSizeValue：currentSizeValue
	*/
	@ApiModelProperty(required = false,value="currentSizeValue" , notes = "currentSizeValue")
	private String currentSizeValue;
	
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
	public NetdiskResourceLimit setId(String id) {
		this.id=id;
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
	public NetdiskResourceLimit setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 最大容量<br>
	 * M）
	 * @return 最大容量
	*/
	public Long getCapacitySizeM() {
		return capacitySizeM;
	}
	
	/**
	 * 设置 最大容量
	 * @param capacitySizeM 最大容量
	 * @return 当前对象
	*/
	public NetdiskResourceLimit setCapacitySizeM(Long capacitySizeM) {
		this.capacitySizeM=capacitySizeM;
		return this;
	}
	
	/**
	 * 获得 当前容量<br>
	 * B）
	 * @return 当前容量
	*/
	public Long getCurrentSizeB() {
		return currentSizeB;
	}
	
	/**
	 * 设置 当前容量
	 * @param currentSizeB 当前容量
	 * @return 当前对象
	*/
	public NetdiskResourceLimit setCurrentSizeB(Long currentSizeB) {
		this.currentSizeB=currentSizeB;
		return this;
	}
	
	/**
	 * 获得 上传大小<br>
	 * M）
	 * @return 上传大小
	*/
	public Long getUploadMaxSizeM() {
		return uploadMaxSizeM;
	}
	
	/**
	 * 设置 上传大小
	 * @param uploadMaxSizeM 上传大小
	 * @return 当前对象
	*/
	public NetdiskResourceLimit setUploadMaxSizeM(Long uploadMaxSizeM) {
		this.uploadMaxSizeM=uploadMaxSizeM;
		return this;
	}
	
	/**
	 * 获得 文件类型<br>
	 * 文件类型
	 * @return 文件类型
	*/
	public String getUploadFileType() {
		return uploadFileType;
	}
	
	/**
	 * 设置 文件类型
	 * @param uploadFileType 文件类型
	 * @return 当前对象
	*/
	public NetdiskResourceLimit setUploadFileType(String uploadFileType) {
		this.uploadFileType=uploadFileType;
		return this;
	}
	
	/**
	 * 获得 视频播放<br>
	 * 视频播放
	 * @return 视频播放
	*/
	public String getPlayVideoValid() {
		return playVideoValid;
	}
	
	/**
	 * 设置 视频播放
	 * @param playVideoValid 视频播放
	 * @return 当前对象
	*/
	public NetdiskResourceLimit setPlayVideoValid(String playVideoValid) {
		this.playVideoValid=playVideoValid;
		return this;
	}
	
	/**
	 * 获得 音频播放<br>
	 * 音频播放
	 * @return 音频播放
	*/
	public String getPlayMusicValid() {
		return playMusicValid;
	}
	
	/**
	 * 设置 音频播放
	 * @param playMusicValid 音频播放
	 * @return 当前对象
	*/
	public NetdiskResourceLimit setPlayMusicValid(String playMusicValid) {
		this.playMusicValid=playMusicValid;
		return this;
	}
	
	/**
	 * 获得 图片预览<br>
	 * 图片预览
	 * @return 图片预览
	*/
	public String getViewPhotoValid() {
		return viewPhotoValid;
	}
	
	/**
	 * 设置 图片预览
	 * @param viewPhotoValid 图片预览
	 * @return 当前对象
	*/
	public NetdiskResourceLimit setViewPhotoValid(String viewPhotoValid) {
		this.viewPhotoValid=viewPhotoValid;
		return this;
	}
	
	/**
	 * 获得 文档预览<br>
	 * 文档预览
	 * @return 文档预览
	*/
	public String getViewDocValid() {
		return viewDocValid;
	}
	
	/**
	 * 设置 文档预览
	 * @param viewDocValid 文档预览
	 * @return 当前对象
	*/
	public NetdiskResourceLimit setViewDocValid(String viewDocValid) {
		this.viewDocValid=viewDocValid;
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
	public NetdiskResourceLimit setVersion(Integer version) {
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
	public NetdiskResourceLimit setCreateBy(String createBy) {
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
	public NetdiskResourceLimit setCreateTime(Date createTime) {
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
	public NetdiskResourceLimit setUpdateBy(String updateBy) {
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
	public NetdiskResourceLimit setUpdateTime(Date updateTime) {
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
	public NetdiskResourceLimit setDeleted(Integer deleted) {
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
	public NetdiskResourceLimit setDeleted(Boolean deletedBool) {
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
	public NetdiskResourceLimit setDeleteBy(String deleteBy) {
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
	public NetdiskResourceLimit setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public NetdiskResourceLimit setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 user<br>
	 * user
	 * @return user
	*/
	public Employee getUser() {
		return user;
	}
	
	/**
	 * 设置 user
	 * @param user user
	 * @return 当前对象
	*/
	public NetdiskResourceLimit setUser(Employee user) {
		this.user=user;
		return this;
	}
	
	/**
	 * 获得 capacitySizeValue<br>
	 * capacitySizeValue
	 * @return capacitySizeValue
	*/
	public String getCapacitySizeValue() {
		return capacitySizeValue;
	}
	
	/**
	 * 设置 capacitySizeValue
	 * @param capacitySizeValue capacitySizeValue
	 * @return 当前对象
	*/
	public NetdiskResourceLimit setCapacitySizeValue(String capacitySizeValue) {
		this.capacitySizeValue=capacitySizeValue;
		return this;
	}
	
	/**
	 * 获得 currentSizeValue<br>
	 * currentSizeValue
	 * @return currentSizeValue
	*/
	public String getCurrentSizeValue() {
		return currentSizeValue;
	}
	
	/**
	 * 设置 currentSizeValue
	 * @param currentSizeValue currentSizeValue
	 * @return 当前对象
	*/
	public NetdiskResourceLimit setCurrentSizeValue(String currentSizeValue) {
		this.currentSizeValue=currentSizeValue;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return NetdiskResourceLimit , 转换好的 NetdiskResourceLimit 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return NetdiskResourceLimit , 转换好的 PoJo 对象
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
	public NetdiskResourceLimit clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public NetdiskResourceLimit duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.NetdiskResourceLimitMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.NetdiskResourceLimitMeta.$$proxy$$();
		inst.setPlayVideoValid(this.getPlayVideoValid());
		inst.setPlayMusicValid(this.getPlayMusicValid());
		inst.setViewPhotoValid(this.getViewPhotoValid());
		inst.setUploadFileType(this.getUploadFileType());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserId(this.getUserId());
		inst.setCapacitySizeM(this.getCapacitySizeM());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setUploadMaxSizeM(this.getUploadMaxSizeM());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCurrentSizeB(this.getCurrentSizeB());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setViewDocValid(this.getViewDocValid());
		if(all) {
			inst.setCurrentSizeValue(this.getCurrentSizeValue());
			inst.setCapacitySizeValue(this.getCapacitySizeValue());
			inst.setUser(this.getUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public NetdiskResourceLimit clone(boolean deep) {
		return EntityContext.clone(NetdiskResourceLimit.class,this,deep);
	}

	/**
	 * 将 Map 转换成 NetdiskResourceLimit
	 * @param netdiskResourceLimitMap 包含实体信息的 Map 对象
	 * @return NetdiskResourceLimit , 转换好的的 NetdiskResourceLimit 对象
	*/
	@Transient
	public static NetdiskResourceLimit createFrom(Map<String,Object> netdiskResourceLimitMap) {
		if(netdiskResourceLimitMap==null) return null;
		NetdiskResourceLimit po = create();
		EntityContext.copyProperties(po,netdiskResourceLimitMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 NetdiskResourceLimit
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return NetdiskResourceLimit , 转换好的的 NetdiskResourceLimit 对象
	*/
	@Transient
	public static NetdiskResourceLimit createFrom(Object pojo) {
		if(pojo==null) return null;
		NetdiskResourceLimit po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 NetdiskResourceLimit，等同于 new
	 * @return NetdiskResourceLimit 对象
	*/
	@Transient
	public static NetdiskResourceLimit create() {
		return new com.dt.platform.domain.oa.meta.NetdiskResourceLimitMeta.$$proxy$$();
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
			this.setPlayVideoValid(DataParser.parse(String.class, map.get(NetdiskResourceLimitMeta.PLAY_VIDEO_VALID)));
			this.setPlayMusicValid(DataParser.parse(String.class, map.get(NetdiskResourceLimitMeta.PLAY_MUSIC_VALID)));
			this.setViewPhotoValid(DataParser.parse(String.class, map.get(NetdiskResourceLimitMeta.VIEW_PHOTO_VALID)));
			this.setUploadFileType(DataParser.parse(String.class, map.get(NetdiskResourceLimitMeta.UPLOAD_FILE_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(NetdiskResourceLimitMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(NetdiskResourceLimitMeta.USER_ID)));
			this.setCapacitySizeM(DataParser.parse(Long.class, map.get(NetdiskResourceLimitMeta.CAPACITY_SIZE_M)));
			this.setVersion(DataParser.parse(Integer.class, map.get(NetdiskResourceLimitMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(NetdiskResourceLimitMeta.CREATE_BY)));
			this.setUploadMaxSizeM(DataParser.parse(Long.class, map.get(NetdiskResourceLimitMeta.UPLOAD_MAX_SIZE_M)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(NetdiskResourceLimitMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(NetdiskResourceLimitMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(NetdiskResourceLimitMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(NetdiskResourceLimitMeta.DELETE_TIME)));
			this.setCurrentSizeB(DataParser.parse(Long.class, map.get(NetdiskResourceLimitMeta.CURRENT_SIZE_B)));
			this.setTenantId(DataParser.parse(String.class, map.get(NetdiskResourceLimitMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(NetdiskResourceLimitMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(NetdiskResourceLimitMeta.ID)));
			this.setViewDocValid(DataParser.parse(String.class, map.get(NetdiskResourceLimitMeta.VIEW_DOC_VALID)));
			// others
			this.setCurrentSizeValue(DataParser.parse(String.class, map.get(NetdiskResourceLimitMeta.CURRENT_SIZE_VALUE)));
			this.setCapacitySizeValue(DataParser.parse(String.class, map.get(NetdiskResourceLimitMeta.CAPACITY_SIZE_VALUE)));
			this.setUser(DataParser.parse(Employee.class, map.get(NetdiskResourceLimitMeta.USER)));
			return true;
		} else {
			try {
				this.setPlayVideoValid( (String)map.get(NetdiskResourceLimitMeta.PLAY_VIDEO_VALID));
				this.setPlayMusicValid( (String)map.get(NetdiskResourceLimitMeta.PLAY_MUSIC_VALID));
				this.setViewPhotoValid( (String)map.get(NetdiskResourceLimitMeta.VIEW_PHOTO_VALID));
				this.setUploadFileType( (String)map.get(NetdiskResourceLimitMeta.UPLOAD_FILE_TYPE));
				this.setUpdateTime( (Date)map.get(NetdiskResourceLimitMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(NetdiskResourceLimitMeta.USER_ID));
				this.setCapacitySizeM( (Long)map.get(NetdiskResourceLimitMeta.CAPACITY_SIZE_M));
				this.setVersion( (Integer)map.get(NetdiskResourceLimitMeta.VERSION));
				this.setCreateBy( (String)map.get(NetdiskResourceLimitMeta.CREATE_BY));
				this.setUploadMaxSizeM( (Long)map.get(NetdiskResourceLimitMeta.UPLOAD_MAX_SIZE_M));
				this.setDeleted( (Integer)map.get(NetdiskResourceLimitMeta.DELETED));
				this.setCreateTime( (Date)map.get(NetdiskResourceLimitMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(NetdiskResourceLimitMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(NetdiskResourceLimitMeta.DELETE_TIME));
				this.setCurrentSizeB( (Long)map.get(NetdiskResourceLimitMeta.CURRENT_SIZE_B));
				this.setTenantId( (String)map.get(NetdiskResourceLimitMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(NetdiskResourceLimitMeta.DELETE_BY));
				this.setId( (String)map.get(NetdiskResourceLimitMeta.ID));
				this.setViewDocValid( (String)map.get(NetdiskResourceLimitMeta.VIEW_DOC_VALID));
				// others
				this.setCurrentSizeValue( (String)map.get(NetdiskResourceLimitMeta.CURRENT_SIZE_VALUE));
				this.setCapacitySizeValue( (String)map.get(NetdiskResourceLimitMeta.CAPACITY_SIZE_VALUE));
				this.setUser( (Employee)map.get(NetdiskResourceLimitMeta.USER));
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
			this.setPlayVideoValid(DataParser.parse(String.class, r.getValue(NetdiskResourceLimitMeta.PLAY_VIDEO_VALID)));
			this.setPlayMusicValid(DataParser.parse(String.class, r.getValue(NetdiskResourceLimitMeta.PLAY_MUSIC_VALID)));
			this.setViewPhotoValid(DataParser.parse(String.class, r.getValue(NetdiskResourceLimitMeta.VIEW_PHOTO_VALID)));
			this.setUploadFileType(DataParser.parse(String.class, r.getValue(NetdiskResourceLimitMeta.UPLOAD_FILE_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(NetdiskResourceLimitMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(NetdiskResourceLimitMeta.USER_ID)));
			this.setCapacitySizeM(DataParser.parse(Long.class, r.getValue(NetdiskResourceLimitMeta.CAPACITY_SIZE_M)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(NetdiskResourceLimitMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(NetdiskResourceLimitMeta.CREATE_BY)));
			this.setUploadMaxSizeM(DataParser.parse(Long.class, r.getValue(NetdiskResourceLimitMeta.UPLOAD_MAX_SIZE_M)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(NetdiskResourceLimitMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(NetdiskResourceLimitMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(NetdiskResourceLimitMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(NetdiskResourceLimitMeta.DELETE_TIME)));
			this.setCurrentSizeB(DataParser.parse(Long.class, r.getValue(NetdiskResourceLimitMeta.CURRENT_SIZE_B)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(NetdiskResourceLimitMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(NetdiskResourceLimitMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(NetdiskResourceLimitMeta.ID)));
			this.setViewDocValid(DataParser.parse(String.class, r.getValue(NetdiskResourceLimitMeta.VIEW_DOC_VALID)));
			return true;
		} else {
			try {
				this.setPlayVideoValid( (String)r.getValue(NetdiskResourceLimitMeta.PLAY_VIDEO_VALID));
				this.setPlayMusicValid( (String)r.getValue(NetdiskResourceLimitMeta.PLAY_MUSIC_VALID));
				this.setViewPhotoValid( (String)r.getValue(NetdiskResourceLimitMeta.VIEW_PHOTO_VALID));
				this.setUploadFileType( (String)r.getValue(NetdiskResourceLimitMeta.UPLOAD_FILE_TYPE));
				this.setUpdateTime( (Date)r.getValue(NetdiskResourceLimitMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(NetdiskResourceLimitMeta.USER_ID));
				this.setCapacitySizeM( (Long)r.getValue(NetdiskResourceLimitMeta.CAPACITY_SIZE_M));
				this.setVersion( (Integer)r.getValue(NetdiskResourceLimitMeta.VERSION));
				this.setCreateBy( (String)r.getValue(NetdiskResourceLimitMeta.CREATE_BY));
				this.setUploadMaxSizeM( (Long)r.getValue(NetdiskResourceLimitMeta.UPLOAD_MAX_SIZE_M));
				this.setDeleted( (Integer)r.getValue(NetdiskResourceLimitMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(NetdiskResourceLimitMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(NetdiskResourceLimitMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(NetdiskResourceLimitMeta.DELETE_TIME));
				this.setCurrentSizeB( (Long)r.getValue(NetdiskResourceLimitMeta.CURRENT_SIZE_B));
				this.setTenantId( (String)r.getValue(NetdiskResourceLimitMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(NetdiskResourceLimitMeta.DELETE_BY));
				this.setId( (String)r.getValue(NetdiskResourceLimitMeta.ID));
				this.setViewDocValid( (String)r.getValue(NetdiskResourceLimitMeta.VIEW_DOC_VALID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}