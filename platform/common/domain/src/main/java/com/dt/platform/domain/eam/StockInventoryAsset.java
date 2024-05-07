package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_STOCK_INVENTORY_ASSET;
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
import com.dt.platform.domain.eam.meta.StockInventoryAssetMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 库存资产
 * <p>库存资产 , 数据表 eam_stock_inventory_asset 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-06 09:57:49
 * @sign AED8557FA8A50AB4DC6E4FCAA5B93416
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_stock_inventory_asset")
@ApiModel(description = "库存资产 ; 库存资产 , 数据表 eam_stock_inventory_asset 的PO类型")
public class StockInventoryAsset extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_STOCK_INVENTORY_ASSET.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "839639770786168832")
	private String id;
	
	/**
	 * 任务：任务
	*/
	@ApiModelProperty(required = false,value="任务" , notes = "任务" , example = "839639701747924992")
	private String taskId;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private String assetId;
	
	/**
	 * 盘点状态：盘点状态
	*/
	@ApiModelProperty(required = false,value="盘点状态" , notes = "盘点状态" , example = "not_counted")
	private String inventoryStatus;
	
	/**
	 * 盘点备注：盘点备注
	*/
	@ApiModelProperty(required = false,value="盘点备注" , notes = "盘点备注")
	private String inventoryNotes;
	
	/**
	 * 差异数量：差异数量
	*/
	@ApiModelProperty(required = false,value="差异数量" , notes = "差异数量")
	private Integer assetNumber;
	
	/**
	 * 盘点人员：盘点人员
	*/
	@ApiModelProperty(required = false,value="盘点人员" , notes = "盘点人员")
	private String operId;
	
	/**
	 * 盘点时间：盘点时间
	*/
	@ApiModelProperty(required = false,value="盘点时间" , notes = "盘点时间")
	private Date operTime;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-05-05 11:08:41")
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "1")
	private Integer version;
	
	/**
	 * goodsStockAsset：goodsStockAsset
	*/
	@ApiModelProperty(required = false,value="goodsStockAsset" , notes = "goodsStockAsset")
	private GoodsStock goodsStockAsset;
	
	/**
	 * 操作人员：操作人员
	*/
	@ApiModelProperty(required = false,value="操作人员" , notes = "操作人员")
	private Employee operUser;
	
	/**
	 * withGoodsStockType：withGoodsStockType
	*/
	@ApiModelProperty(required = false,value="withGoodsStockType" , notes = "withGoodsStockType")
	private String withGoodsStockType;
	
	/**
	 * withWarehouse：withWarehouse
	*/
	@ApiModelProperty(required = false,value="withWarehouse" , notes = "withWarehouse")
	private String withWarehouse;
	
	/**
	 * withPosition：withPosition
	*/
	@ApiModelProperty(required = false,value="withPosition" , notes = "withPosition")
	private String withPosition;
	
	/**
	 * withName：withName
	*/
	@ApiModelProperty(required = false,value="withName" , notes = "withName")
	private String withName;
	
	/**
	 * withCode：withCode
	*/
	@ApiModelProperty(required = false,value="withCode" , notes = "withCode")
	private String withCode;
	
	/**
	 * withModel：withModel
	*/
	@ApiModelProperty(required = false,value="withModel" , notes = "withModel")
	private String withModel;
	
	/**
	 * withBrand：withBrand
	*/
	@ApiModelProperty(required = false,value="withBrand" , notes = "withBrand")
	private String withBrand;
	
	/**
	 * withManufacturer：withManufacturer
	*/
	@ApiModelProperty(required = false,value="withManufacturer" , notes = "withManufacturer")
	private String withManufacturer;
	
	/**
	 * withNumber：withNumber
	*/
	@ApiModelProperty(required = false,value="withNumber" , notes = "withNumber")
	private String withNumber;
	
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
	public StockInventoryAsset setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 任务<br>
	 * 任务
	 * @return 任务
	*/
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 设置 任务
	 * @param taskId 任务
	 * @return 当前对象
	*/
	public StockInventoryAsset setTaskId(String taskId) {
		this.taskId=taskId;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public String getAssetId() {
		return assetId;
	}
	
	/**
	 * 设置 资产
	 * @param assetId 资产
	 * @return 当前对象
	*/
	public StockInventoryAsset setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 盘点状态<br>
	 * 盘点状态
	 * @return 盘点状态
	*/
	public String getInventoryStatus() {
		return inventoryStatus;
	}
	
	/**
	 * 设置 盘点状态
	 * @param inventoryStatus 盘点状态
	 * @return 当前对象
	*/
	public StockInventoryAsset setInventoryStatus(String inventoryStatus) {
		this.inventoryStatus=inventoryStatus;
		return this;
	}
	
	/**
	 * 获得 盘点备注<br>
	 * 盘点备注
	 * @return 盘点备注
	*/
	public String getInventoryNotes() {
		return inventoryNotes;
	}
	
	/**
	 * 设置 盘点备注
	 * @param inventoryNotes 盘点备注
	 * @return 当前对象
	*/
	public StockInventoryAsset setInventoryNotes(String inventoryNotes) {
		this.inventoryNotes=inventoryNotes;
		return this;
	}
	
	/**
	 * 获得 差异数量<br>
	 * 差异数量
	 * @return 差异数量
	*/
	public Integer getAssetNumber() {
		return assetNumber;
	}
	
	/**
	 * 设置 差异数量
	 * @param assetNumber 差异数量
	 * @return 当前对象
	*/
	public StockInventoryAsset setAssetNumber(Integer assetNumber) {
		this.assetNumber=assetNumber;
		return this;
	}
	
	/**
	 * 获得 盘点人员<br>
	 * 盘点人员
	 * @return 盘点人员
	*/
	public String getOperId() {
		return operId;
	}
	
	/**
	 * 设置 盘点人员
	 * @param operId 盘点人员
	 * @return 当前对象
	*/
	public StockInventoryAsset setOperId(String operId) {
		this.operId=operId;
		return this;
	}
	
	/**
	 * 获得 盘点时间<br>
	 * 盘点时间
	 * @return 盘点时间
	*/
	public Date getOperTime() {
		return operTime;
	}
	
	/**
	 * 设置 盘点时间
	 * @param operTime 盘点时间
	 * @return 当前对象
	*/
	public StockInventoryAsset setOperTime(Date operTime) {
		this.operTime=operTime;
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
	public StockInventoryAsset setCreateBy(String createBy) {
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
	public StockInventoryAsset setCreateTime(Date createTime) {
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
	public StockInventoryAsset setUpdateBy(String updateBy) {
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
	public StockInventoryAsset setUpdateTime(Date updateTime) {
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
	public StockInventoryAsset setDeleted(Integer deleted) {
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
	public StockInventoryAsset setDeleted(Boolean deletedBool) {
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
	public StockInventoryAsset setDeleteBy(String deleteBy) {
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
	public StockInventoryAsset setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public StockInventoryAsset setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 goodsStockAsset<br>
	 * goodsStockAsset
	 * @return goodsStockAsset
	*/
	public GoodsStock getGoodsStockAsset() {
		return goodsStockAsset;
	}
	
	/**
	 * 设置 goodsStockAsset
	 * @param goodsStockAsset goodsStockAsset
	 * @return 当前对象
	*/
	public StockInventoryAsset setGoodsStockAsset(GoodsStock goodsStockAsset) {
		this.goodsStockAsset=goodsStockAsset;
		return this;
	}
	
	/**
	 * 获得 操作人员<br>
	 * 操作人员
	 * @return 操作人员
	*/
	public Employee getOperUser() {
		return operUser;
	}
	
	/**
	 * 设置 操作人员
	 * @param operUser 操作人员
	 * @return 当前对象
	*/
	public StockInventoryAsset setOperUser(Employee operUser) {
		this.operUser=operUser;
		return this;
	}
	
	/**
	 * 获得 withGoodsStockType<br>
	 * withGoodsStockType
	 * @return withGoodsStockType
	*/
	public String getWithGoodsStockType() {
		return withGoodsStockType;
	}
	
	/**
	 * 设置 withGoodsStockType
	 * @param withGoodsStockType withGoodsStockType
	 * @return 当前对象
	*/
	public StockInventoryAsset setWithGoodsStockType(String withGoodsStockType) {
		this.withGoodsStockType=withGoodsStockType;
		return this;
	}
	
	/**
	 * 获得 withWarehouse<br>
	 * withWarehouse
	 * @return withWarehouse
	*/
	public String getWithWarehouse() {
		return withWarehouse;
	}
	
	/**
	 * 设置 withWarehouse
	 * @param withWarehouse withWarehouse
	 * @return 当前对象
	*/
	public StockInventoryAsset setWithWarehouse(String withWarehouse) {
		this.withWarehouse=withWarehouse;
		return this;
	}
	
	/**
	 * 获得 withPosition<br>
	 * withPosition
	 * @return withPosition
	*/
	public String getWithPosition() {
		return withPosition;
	}
	
	/**
	 * 设置 withPosition
	 * @param withPosition withPosition
	 * @return 当前对象
	*/
	public StockInventoryAsset setWithPosition(String withPosition) {
		this.withPosition=withPosition;
		return this;
	}
	
	/**
	 * 获得 withName<br>
	 * withName
	 * @return withName
	*/
	public String getWithName() {
		return withName;
	}
	
	/**
	 * 设置 withName
	 * @param withName withName
	 * @return 当前对象
	*/
	public StockInventoryAsset setWithName(String withName) {
		this.withName=withName;
		return this;
	}
	
	/**
	 * 获得 withCode<br>
	 * withCode
	 * @return withCode
	*/
	public String getWithCode() {
		return withCode;
	}
	
	/**
	 * 设置 withCode
	 * @param withCode withCode
	 * @return 当前对象
	*/
	public StockInventoryAsset setWithCode(String withCode) {
		this.withCode=withCode;
		return this;
	}
	
	/**
	 * 获得 withModel<br>
	 * withModel
	 * @return withModel
	*/
	public String getWithModel() {
		return withModel;
	}
	
	/**
	 * 设置 withModel
	 * @param withModel withModel
	 * @return 当前对象
	*/
	public StockInventoryAsset setWithModel(String withModel) {
		this.withModel=withModel;
		return this;
	}
	
	/**
	 * 获得 withBrand<br>
	 * withBrand
	 * @return withBrand
	*/
	public String getWithBrand() {
		return withBrand;
	}
	
	/**
	 * 设置 withBrand
	 * @param withBrand withBrand
	 * @return 当前对象
	*/
	public StockInventoryAsset setWithBrand(String withBrand) {
		this.withBrand=withBrand;
		return this;
	}
	
	/**
	 * 获得 withManufacturer<br>
	 * withManufacturer
	 * @return withManufacturer
	*/
	public String getWithManufacturer() {
		return withManufacturer;
	}
	
	/**
	 * 设置 withManufacturer
	 * @param withManufacturer withManufacturer
	 * @return 当前对象
	*/
	public StockInventoryAsset setWithManufacturer(String withManufacturer) {
		this.withManufacturer=withManufacturer;
		return this;
	}
	
	/**
	 * 获得 withNumber<br>
	 * withNumber
	 * @return withNumber
	*/
	public String getWithNumber() {
		return withNumber;
	}
	
	/**
	 * 设置 withNumber
	 * @param withNumber withNumber
	 * @return 当前对象
	*/
	public StockInventoryAsset setWithNumber(String withNumber) {
		this.withNumber=withNumber;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return StockInventoryAsset , 转换好的 StockInventoryAsset 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return StockInventoryAsset , 转换好的 PoJo 对象
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
	public StockInventoryAsset clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public StockInventoryAsset duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.StockInventoryAssetMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.StockInventoryAssetMeta.$$proxy$$();
		inst.setInventoryStatus(this.getInventoryStatus());
		inst.setOperId(this.getOperId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setInventoryNotes(this.getInventoryNotes());
		inst.setCreateBy(this.getCreateBy());
		inst.setAssetNumber(this.getAssetNumber());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssetId(this.getAssetId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTaskId(this.getTaskId());
		inst.setOperTime(this.getOperTime());
		if(all) {
			inst.setGoodsStockAsset(this.getGoodsStockAsset());
			inst.setWithWarehouse(this.getWithWarehouse());
			inst.setWithModel(this.getWithModel());
			inst.setWithCode(this.getWithCode());
			inst.setWithManufacturer(this.getWithManufacturer());
			inst.setWithName(this.getWithName());
			inst.setWithGoodsStockType(this.getWithGoodsStockType());
			inst.setWithBrand(this.getWithBrand());
			inst.setWithNumber(this.getWithNumber());
			inst.setOperUser(this.getOperUser());
			inst.setWithPosition(this.getWithPosition());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public StockInventoryAsset clone(boolean deep) {
		return EntityContext.clone(StockInventoryAsset.class,this,deep);
	}

	/**
	 * 将 Map 转换成 StockInventoryAsset
	 * @param stockInventoryAssetMap 包含实体信息的 Map 对象
	 * @return StockInventoryAsset , 转换好的的 StockInventoryAsset 对象
	*/
	@Transient
	public static StockInventoryAsset createFrom(Map<String,Object> stockInventoryAssetMap) {
		if(stockInventoryAssetMap==null) return null;
		StockInventoryAsset po = create();
		EntityContext.copyProperties(po,stockInventoryAssetMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 StockInventoryAsset
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return StockInventoryAsset , 转换好的的 StockInventoryAsset 对象
	*/
	@Transient
	public static StockInventoryAsset createFrom(Object pojo) {
		if(pojo==null) return null;
		StockInventoryAsset po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 StockInventoryAsset，等同于 new
	 * @return StockInventoryAsset 对象
	*/
	@Transient
	public static StockInventoryAsset create() {
		return new com.dt.platform.domain.eam.meta.StockInventoryAssetMeta.$$proxy$$();
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
			this.setInventoryStatus(DataParser.parse(String.class, map.get(StockInventoryAssetMeta.INVENTORY_STATUS)));
			this.setOperId(DataParser.parse(String.class, map.get(StockInventoryAssetMeta.OPER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(StockInventoryAssetMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(StockInventoryAssetMeta.VERSION)));
			this.setInventoryNotes(DataParser.parse(String.class, map.get(StockInventoryAssetMeta.INVENTORY_NOTES)));
			this.setCreateBy(DataParser.parse(String.class, map.get(StockInventoryAssetMeta.CREATE_BY)));
			this.setAssetNumber(DataParser.parse(Integer.class, map.get(StockInventoryAssetMeta.ASSET_NUMBER)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(StockInventoryAssetMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(StockInventoryAssetMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(StockInventoryAssetMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(StockInventoryAssetMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, map.get(StockInventoryAssetMeta.ASSET_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(StockInventoryAssetMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(StockInventoryAssetMeta.ID)));
			this.setTaskId(DataParser.parse(String.class, map.get(StockInventoryAssetMeta.TASK_ID)));
			this.setOperTime(DataParser.parse(Date.class, map.get(StockInventoryAssetMeta.OPER_TIME)));
			// others
			this.setGoodsStockAsset(DataParser.parse(GoodsStock.class, map.get(StockInventoryAssetMeta.GOODS_STOCK_ASSET)));
			this.setWithWarehouse(DataParser.parse(String.class, map.get(StockInventoryAssetMeta.WITH_WAREHOUSE)));
			this.setWithModel(DataParser.parse(String.class, map.get(StockInventoryAssetMeta.WITH_MODEL)));
			this.setWithCode(DataParser.parse(String.class, map.get(StockInventoryAssetMeta.WITH_CODE)));
			this.setWithManufacturer(DataParser.parse(String.class, map.get(StockInventoryAssetMeta.WITH_MANUFACTURER)));
			this.setWithName(DataParser.parse(String.class, map.get(StockInventoryAssetMeta.WITH_NAME)));
			this.setWithGoodsStockType(DataParser.parse(String.class, map.get(StockInventoryAssetMeta.WITH_GOODS_STOCK_TYPE)));
			this.setWithBrand(DataParser.parse(String.class, map.get(StockInventoryAssetMeta.WITH_BRAND)));
			this.setWithNumber(DataParser.parse(String.class, map.get(StockInventoryAssetMeta.WITH_NUMBER)));
			this.setOperUser(DataParser.parse(Employee.class, map.get(StockInventoryAssetMeta.OPER_USER)));
			this.setWithPosition(DataParser.parse(String.class, map.get(StockInventoryAssetMeta.WITH_POSITION)));
			return true;
		} else {
			try {
				this.setInventoryStatus( (String)map.get(StockInventoryAssetMeta.INVENTORY_STATUS));
				this.setOperId( (String)map.get(StockInventoryAssetMeta.OPER_ID));
				this.setUpdateTime( (Date)map.get(StockInventoryAssetMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(StockInventoryAssetMeta.VERSION));
				this.setInventoryNotes( (String)map.get(StockInventoryAssetMeta.INVENTORY_NOTES));
				this.setCreateBy( (String)map.get(StockInventoryAssetMeta.CREATE_BY));
				this.setAssetNumber( (Integer)map.get(StockInventoryAssetMeta.ASSET_NUMBER));
				this.setDeleted( (Integer)map.get(StockInventoryAssetMeta.DELETED));
				this.setCreateTime( (Date)map.get(StockInventoryAssetMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(StockInventoryAssetMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(StockInventoryAssetMeta.DELETE_TIME));
				this.setAssetId( (String)map.get(StockInventoryAssetMeta.ASSET_ID));
				this.setDeleteBy( (String)map.get(StockInventoryAssetMeta.DELETE_BY));
				this.setId( (String)map.get(StockInventoryAssetMeta.ID));
				this.setTaskId( (String)map.get(StockInventoryAssetMeta.TASK_ID));
				this.setOperTime( (Date)map.get(StockInventoryAssetMeta.OPER_TIME));
				// others
				this.setGoodsStockAsset( (GoodsStock)map.get(StockInventoryAssetMeta.GOODS_STOCK_ASSET));
				this.setWithWarehouse( (String)map.get(StockInventoryAssetMeta.WITH_WAREHOUSE));
				this.setWithModel( (String)map.get(StockInventoryAssetMeta.WITH_MODEL));
				this.setWithCode( (String)map.get(StockInventoryAssetMeta.WITH_CODE));
				this.setWithManufacturer( (String)map.get(StockInventoryAssetMeta.WITH_MANUFACTURER));
				this.setWithName( (String)map.get(StockInventoryAssetMeta.WITH_NAME));
				this.setWithGoodsStockType( (String)map.get(StockInventoryAssetMeta.WITH_GOODS_STOCK_TYPE));
				this.setWithBrand( (String)map.get(StockInventoryAssetMeta.WITH_BRAND));
				this.setWithNumber( (String)map.get(StockInventoryAssetMeta.WITH_NUMBER));
				this.setOperUser( (Employee)map.get(StockInventoryAssetMeta.OPER_USER));
				this.setWithPosition( (String)map.get(StockInventoryAssetMeta.WITH_POSITION));
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
			this.setInventoryStatus(DataParser.parse(String.class, r.getValue(StockInventoryAssetMeta.INVENTORY_STATUS)));
			this.setOperId(DataParser.parse(String.class, r.getValue(StockInventoryAssetMeta.OPER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(StockInventoryAssetMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(StockInventoryAssetMeta.VERSION)));
			this.setInventoryNotes(DataParser.parse(String.class, r.getValue(StockInventoryAssetMeta.INVENTORY_NOTES)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(StockInventoryAssetMeta.CREATE_BY)));
			this.setAssetNumber(DataParser.parse(Integer.class, r.getValue(StockInventoryAssetMeta.ASSET_NUMBER)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(StockInventoryAssetMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(StockInventoryAssetMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(StockInventoryAssetMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(StockInventoryAssetMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(StockInventoryAssetMeta.ASSET_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(StockInventoryAssetMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(StockInventoryAssetMeta.ID)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(StockInventoryAssetMeta.TASK_ID)));
			this.setOperTime(DataParser.parse(Date.class, r.getValue(StockInventoryAssetMeta.OPER_TIME)));
			return true;
		} else {
			try {
				this.setInventoryStatus( (String)r.getValue(StockInventoryAssetMeta.INVENTORY_STATUS));
				this.setOperId( (String)r.getValue(StockInventoryAssetMeta.OPER_ID));
				this.setUpdateTime( (Date)r.getValue(StockInventoryAssetMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(StockInventoryAssetMeta.VERSION));
				this.setInventoryNotes( (String)r.getValue(StockInventoryAssetMeta.INVENTORY_NOTES));
				this.setCreateBy( (String)r.getValue(StockInventoryAssetMeta.CREATE_BY));
				this.setAssetNumber( (Integer)r.getValue(StockInventoryAssetMeta.ASSET_NUMBER));
				this.setDeleted( (Integer)r.getValue(StockInventoryAssetMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(StockInventoryAssetMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(StockInventoryAssetMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(StockInventoryAssetMeta.DELETE_TIME));
				this.setAssetId( (String)r.getValue(StockInventoryAssetMeta.ASSET_ID));
				this.setDeleteBy( (String)r.getValue(StockInventoryAssetMeta.DELETE_BY));
				this.setId( (String)r.getValue(StockInventoryAssetMeta.ID));
				this.setTaskId( (String)r.getValue(StockInventoryAssetMeta.TASK_ID));
				this.setOperTime( (Date)r.getValue(StockInventoryAssetMeta.OPER_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}