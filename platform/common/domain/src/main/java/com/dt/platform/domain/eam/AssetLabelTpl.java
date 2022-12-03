package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_LABEL_TPL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetLabelTplMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 标签模版
 * <p>标签模版 , 数据表 eam_asset_label_tpl 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-02 20:48:43
 * @sign CADACBDD190E61315D4C7F934A1BA558
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_label_tpl")
@ApiModel(description = "标签模版 ; 标签模版 , 数据表 eam_asset_label_tpl 的PO类型")
public class AssetLabelTpl extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_LABEL_TPL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "581518887695155200")
	private String id;
	
	/**
	 * 类型：默认为1
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "默认为1" , example = "1")
	private String type;
	
	/**
	 * 是否自定义：是否自定义
	*/
	@ApiModelProperty(required = false,value="是否自定义" , notes = "是否自定义" , example = "1")
	private String isCustom;
	
	/**
	 * 字段：字段
	*/
	@ApiModelProperty(required = false,value="字段" , notes = "字段" , example = "[]")
	private String colIds;
	
	/**
	 * 位置:u：d
	*/
	@ApiModelProperty(required = false,value="位置:u" , notes = "d" , example = "d")
	private String imagePosition;
	
	/**
	 * 图像：图像
	*/
	@ApiModelProperty(required = false,value="图像" , notes = "图像")
	private String imageColId;
	
	/**
	 * 图像显示：图像显示
	*/
	@ApiModelProperty(required = false,value="图像显示" , notes = "图像显示" , example = "1")
	private String imageShow;
	
	/**
	 * 图像label显示：图像label显示
	*/
	@ApiModelProperty(required = false,value="图像label显示" , notes = "图像label显示" , example = "1")
	private String imageLabelShow;
	
	/**
	 * 图像类型txm：rwm
	*/
	@ApiModelProperty(required = false,value="图像类型txm" , notes = "rwm" , example = "txm")
	private String imageType;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private String labelFormatContent;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-05-24 04:28:27")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-05-24 04:36:24")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "1")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID" , example = "110588348101165911")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间" , example = "2022-05-24 04:36:24")
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
	 * Item：Item
	*/
	@ApiModelProperty(required = false,value="Item" , notes = "Item")
	private List<AssetLabelTplItem> assetLabelItemList;
	
	/**
	 * Column：Column
	*/
	@ApiModelProperty(required = false,value="Column" , notes = "Column")
	private List<AssetLabelCol> assetLabelColumnlList;
	
	/**
	 * assetLabelLayout：assetLabelLayout
	*/
	@ApiModelProperty(required = false,value="assetLabelLayout" , notes = "assetLabelLayout")
	private List<AssetLabelLayout> assetLabelLayoutList;
	
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
	public AssetLabelTpl setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 默认为1
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public AssetLabelTpl setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 是否自定义<br>
	 * 是否自定义
	 * @return 是否自定义
	*/
	public String getIsCustom() {
		return isCustom;
	}
	
	/**
	 * 设置 是否自定义
	 * @param isCustom 是否自定义
	 * @return 当前对象
	*/
	public AssetLabelTpl setIsCustom(String isCustom) {
		this.isCustom=isCustom;
		return this;
	}
	
	/**
	 * 获得 字段<br>
	 * 字段
	 * @return 字段
	*/
	public String getColIds() {
		return colIds;
	}
	
	/**
	 * 设置 字段
	 * @param colIds 字段
	 * @return 当前对象
	*/
	public AssetLabelTpl setColIds(String colIds) {
		this.colIds=colIds;
		return this;
	}
	
	/**
	 * 获得 位置:u<br>
	 * d
	 * @return 位置:u
	*/
	public String getImagePosition() {
		return imagePosition;
	}
	
	/**
	 * 设置 位置:u
	 * @param imagePosition 位置:u
	 * @return 当前对象
	*/
	public AssetLabelTpl setImagePosition(String imagePosition) {
		this.imagePosition=imagePosition;
		return this;
	}
	
	/**
	 * 获得 图像<br>
	 * 图像
	 * @return 图像
	*/
	public String getImageColId() {
		return imageColId;
	}
	
	/**
	 * 设置 图像
	 * @param imageColId 图像
	 * @return 当前对象
	*/
	public AssetLabelTpl setImageColId(String imageColId) {
		this.imageColId=imageColId;
		return this;
	}
	
	/**
	 * 获得 图像显示<br>
	 * 图像显示
	 * @return 图像显示
	*/
	public String getImageShow() {
		return imageShow;
	}
	
	/**
	 * 设置 图像显示
	 * @param imageShow 图像显示
	 * @return 当前对象
	*/
	public AssetLabelTpl setImageShow(String imageShow) {
		this.imageShow=imageShow;
		return this;
	}
	
	/**
	 * 获得 图像label显示<br>
	 * 图像label显示
	 * @return 图像label显示
	*/
	public String getImageLabelShow() {
		return imageLabelShow;
	}
	
	/**
	 * 设置 图像label显示
	 * @param imageLabelShow 图像label显示
	 * @return 当前对象
	*/
	public AssetLabelTpl setImageLabelShow(String imageLabelShow) {
		this.imageLabelShow=imageLabelShow;
		return this;
	}
	
	/**
	 * 获得 图像类型txm<br>
	 * rwm
	 * @return 图像类型txm
	*/
	public String getImageType() {
		return imageType;
	}
	
	/**
	 * 设置 图像类型txm
	 * @param imageType 图像类型txm
	 * @return 当前对象
	*/
	public AssetLabelTpl setImageType(String imageType) {
		this.imageType=imageType;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getLabelFormatContent() {
		return labelFormatContent;
	}
	
	/**
	 * 设置 类型
	 * @param labelFormatContent 类型
	 * @return 当前对象
	*/
	public AssetLabelTpl setLabelFormatContent(String labelFormatContent) {
		this.labelFormatContent=labelFormatContent;
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
	public AssetLabelTpl setNotes(String notes) {
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
	public AssetLabelTpl setCreateBy(String createBy) {
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
	public AssetLabelTpl setCreateTime(Date createTime) {
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
	public AssetLabelTpl setUpdateBy(String updateBy) {
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
	public AssetLabelTpl setUpdateTime(Date updateTime) {
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
	public AssetLabelTpl setDeleted(Integer deleted) {
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
	public AssetLabelTpl setDeleted(Boolean deletedBool) {
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
	public AssetLabelTpl setDeleteBy(String deleteBy) {
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
	public AssetLabelTpl setDeleteTime(Date deleteTime) {
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
	public AssetLabelTpl setVersion(Integer version) {
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
	public AssetLabelTpl setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 Item<br>
	 * Item
	 * @return Item
	*/
	public List<AssetLabelTplItem> getAssetLabelItemList() {
		return assetLabelItemList;
	}
	
	/**
	 * 设置 Item
	 * @param assetLabelItemList Item
	 * @return 当前对象
	*/
	public AssetLabelTpl setAssetLabelItemList(List<AssetLabelTplItem> assetLabelItemList) {
		this.assetLabelItemList=assetLabelItemList;
		return this;
	}
	
	/**
	 * 添加 Item
	 * @param assetLabelItem Item
	 * @return 当前对象
	*/
	public AssetLabelTpl addAssetLabelItem(AssetLabelTplItem... assetLabelItem) {
		if(this.assetLabelItemList==null) assetLabelItemList=new ArrayList<>();
		this.assetLabelItemList.addAll(Arrays.asList(assetLabelItem));
		return this;
	}
	
	/**
	 * 获得 Column<br>
	 * Column
	 * @return Column
	*/
	public List<AssetLabelCol> getAssetLabelColumnlList() {
		return assetLabelColumnlList;
	}
	
	/**
	 * 设置 Column
	 * @param assetLabelColumnlList Column
	 * @return 当前对象
	*/
	public AssetLabelTpl setAssetLabelColumnlList(List<AssetLabelCol> assetLabelColumnlList) {
		this.assetLabelColumnlList=assetLabelColumnlList;
		return this;
	}
	
	/**
	 * 添加 Column
	 * @param assetLabelColumnl Column
	 * @return 当前对象
	*/
	public AssetLabelTpl addAssetLabelColumnl(AssetLabelCol... assetLabelColumnl) {
		if(this.assetLabelColumnlList==null) assetLabelColumnlList=new ArrayList<>();
		this.assetLabelColumnlList.addAll(Arrays.asList(assetLabelColumnl));
		return this;
	}
	
	/**
	 * 获得 assetLabelLayout<br>
	 * assetLabelLayout
	 * @return assetLabelLayout
	*/
	public List<AssetLabelLayout> getAssetLabelLayoutList() {
		return assetLabelLayoutList;
	}
	
	/**
	 * 设置 assetLabelLayout
	 * @param assetLabelLayoutList assetLabelLayout
	 * @return 当前对象
	*/
	public AssetLabelTpl setAssetLabelLayoutList(List<AssetLabelLayout> assetLabelLayoutList) {
		this.assetLabelLayoutList=assetLabelLayoutList;
		return this;
	}
	
	/**
	 * 添加 assetLabelLayout
	 * @param assetLabelLayout assetLabelLayout
	 * @return 当前对象
	*/
	public AssetLabelTpl addAssetLabelLayout(AssetLabelLayout... assetLabelLayout) {
		if(this.assetLabelLayoutList==null) assetLabelLayoutList=new ArrayList<>();
		this.assetLabelLayoutList.addAll(Arrays.asList(assetLabelLayout));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetLabelTpl , 转换好的 AssetLabelTpl 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetLabelTpl , 转换好的 PoJo 对象
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
	public AssetLabelTpl clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetLabelTpl duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetLabelTplMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetLabelTplMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setColIds(this.getColIds());
		inst.setImagePosition(this.getImagePosition());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setLabelFormatContent(this.getLabelFormatContent());
		inst.setImageLabelShow(this.getImageLabelShow());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setImageColId(this.getImageColId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setIsCustom(this.getIsCustom());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setImageType(this.getImageType());
		inst.setImageShow(this.getImageShow());
		if(all) {
			inst.setAssetLabelColumnlList(this.getAssetLabelColumnlList());
			inst.setAssetLabelItemList(this.getAssetLabelItemList());
			inst.setAssetLabelLayoutList(this.getAssetLabelLayoutList());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetLabelTpl clone(boolean deep) {
		return EntityContext.clone(AssetLabelTpl.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetLabelTpl
	 * @param assetLabelTplMap 包含实体信息的 Map 对象
	 * @return AssetLabelTpl , 转换好的的 AssetLabelTpl 对象
	*/
	@Transient
	public static AssetLabelTpl createFrom(Map<String,Object> assetLabelTplMap) {
		if(assetLabelTplMap==null) return null;
		AssetLabelTpl po = create();
		EntityContext.copyProperties(po,assetLabelTplMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetLabelTpl
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetLabelTpl , 转换好的的 AssetLabelTpl 对象
	*/
	@Transient
	public static AssetLabelTpl createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetLabelTpl po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetLabelTpl，等同于 new
	 * @return AssetLabelTpl 对象
	*/
	@Transient
	public static AssetLabelTpl create() {
		return new com.dt.platform.domain.eam.meta.AssetLabelTplMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AssetLabelTplMeta.NOTES)));
			this.setColIds(DataParser.parse(String.class, map.get(AssetLabelTplMeta.COL_IDS)));
			this.setImagePosition(DataParser.parse(String.class, map.get(AssetLabelTplMeta.IMAGE_POSITION)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetLabelTplMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(AssetLabelTplMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetLabelTplMeta.VERSION)));
			this.setLabelFormatContent(DataParser.parse(String.class, map.get(AssetLabelTplMeta.LABEL_FORMAT_CONTENT)));
			this.setImageLabelShow(DataParser.parse(String.class, map.get(AssetLabelTplMeta.IMAGE_LABEL_SHOW)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetLabelTplMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetLabelTplMeta.DELETED)));
			this.setImageColId(DataParser.parse(String.class, map.get(AssetLabelTplMeta.IMAGE_COL_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetLabelTplMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetLabelTplMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetLabelTplMeta.DELETE_TIME)));
			this.setIsCustom(DataParser.parse(String.class, map.get(AssetLabelTplMeta.IS_CUSTOM)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetLabelTplMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetLabelTplMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetLabelTplMeta.ID)));
			this.setImageType(DataParser.parse(String.class, map.get(AssetLabelTplMeta.IMAGE_TYPE)));
			this.setImageShow(DataParser.parse(String.class, map.get(AssetLabelTplMeta.IMAGE_SHOW)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AssetLabelTplMeta.NOTES));
				this.setColIds( (String)map.get(AssetLabelTplMeta.COL_IDS));
				this.setImagePosition( (String)map.get(AssetLabelTplMeta.IMAGE_POSITION));
				this.setUpdateTime( (Date)map.get(AssetLabelTplMeta.UPDATE_TIME));
				this.setType( (String)map.get(AssetLabelTplMeta.TYPE));
				this.setVersion( (Integer)map.get(AssetLabelTplMeta.VERSION));
				this.setLabelFormatContent( (String)map.get(AssetLabelTplMeta.LABEL_FORMAT_CONTENT));
				this.setImageLabelShow( (String)map.get(AssetLabelTplMeta.IMAGE_LABEL_SHOW));
				this.setCreateBy( (String)map.get(AssetLabelTplMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetLabelTplMeta.DELETED));
				this.setImageColId( (String)map.get(AssetLabelTplMeta.IMAGE_COL_ID));
				this.setCreateTime( (Date)map.get(AssetLabelTplMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetLabelTplMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetLabelTplMeta.DELETE_TIME));
				this.setIsCustom( (String)map.get(AssetLabelTplMeta.IS_CUSTOM));
				this.setTenantId( (String)map.get(AssetLabelTplMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetLabelTplMeta.DELETE_BY));
				this.setId( (String)map.get(AssetLabelTplMeta.ID));
				this.setImageType( (String)map.get(AssetLabelTplMeta.IMAGE_TYPE));
				this.setImageShow( (String)map.get(AssetLabelTplMeta.IMAGE_SHOW));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetLabelTplMeta.NOTES)));
			this.setColIds(DataParser.parse(String.class, r.getValue(AssetLabelTplMeta.COL_IDS)));
			this.setImagePosition(DataParser.parse(String.class, r.getValue(AssetLabelTplMeta.IMAGE_POSITION)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetLabelTplMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(AssetLabelTplMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetLabelTplMeta.VERSION)));
			this.setLabelFormatContent(DataParser.parse(String.class, r.getValue(AssetLabelTplMeta.LABEL_FORMAT_CONTENT)));
			this.setImageLabelShow(DataParser.parse(String.class, r.getValue(AssetLabelTplMeta.IMAGE_LABEL_SHOW)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetLabelTplMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetLabelTplMeta.DELETED)));
			this.setImageColId(DataParser.parse(String.class, r.getValue(AssetLabelTplMeta.IMAGE_COL_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetLabelTplMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetLabelTplMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetLabelTplMeta.DELETE_TIME)));
			this.setIsCustom(DataParser.parse(String.class, r.getValue(AssetLabelTplMeta.IS_CUSTOM)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetLabelTplMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetLabelTplMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetLabelTplMeta.ID)));
			this.setImageType(DataParser.parse(String.class, r.getValue(AssetLabelTplMeta.IMAGE_TYPE)));
			this.setImageShow(DataParser.parse(String.class, r.getValue(AssetLabelTplMeta.IMAGE_SHOW)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AssetLabelTplMeta.NOTES));
				this.setColIds( (String)r.getValue(AssetLabelTplMeta.COL_IDS));
				this.setImagePosition( (String)r.getValue(AssetLabelTplMeta.IMAGE_POSITION));
				this.setUpdateTime( (Date)r.getValue(AssetLabelTplMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(AssetLabelTplMeta.TYPE));
				this.setVersion( (Integer)r.getValue(AssetLabelTplMeta.VERSION));
				this.setLabelFormatContent( (String)r.getValue(AssetLabelTplMeta.LABEL_FORMAT_CONTENT));
				this.setImageLabelShow( (String)r.getValue(AssetLabelTplMeta.IMAGE_LABEL_SHOW));
				this.setCreateBy( (String)r.getValue(AssetLabelTplMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetLabelTplMeta.DELETED));
				this.setImageColId( (String)r.getValue(AssetLabelTplMeta.IMAGE_COL_ID));
				this.setCreateTime( (Date)r.getValue(AssetLabelTplMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetLabelTplMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetLabelTplMeta.DELETE_TIME));
				this.setIsCustom( (String)r.getValue(AssetLabelTplMeta.IS_CUSTOM));
				this.setTenantId( (String)r.getValue(AssetLabelTplMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetLabelTplMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetLabelTplMeta.ID));
				this.setImageType( (String)r.getValue(AssetLabelTplMeta.IMAGE_TYPE));
				this.setImageShow( (String)r.getValue(AssetLabelTplMeta.IMAGE_SHOW));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}