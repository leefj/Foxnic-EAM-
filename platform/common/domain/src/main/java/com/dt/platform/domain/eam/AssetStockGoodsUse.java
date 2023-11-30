package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_STOCK_GOODS_USE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetStockGoodsUseMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 库存领用
 * <p>库存领用 , 数据表 eam_asset_stock_goods_use 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-11-30 22:08:59
 * @sign 326003D22D944CF052A4EE325E4E6CBC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_stock_goods_use")
@ApiModel(description = "库存领用 ; 库存领用 , 数据表 eam_asset_stock_goods_use 的PO类型")
public class AssetStockGoodsUse extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_STOCK_GOODS_USE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "782718387955433472")
	private String id;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号")
	private String businessCode;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态")
	private String status;
	
	/**
	 * 库存所属：库存所属
	*/
	@ApiModelProperty(required = false,value="库存所属" , notes = "库存所属" , example = "stock")
	private String ownerType;
	
	/**
	 * 业务名称：业务名称
	*/
	@ApiModelProperty(required = false,value="业务名称" , notes = "业务名称" , example = "，lll")
	private String name;
	
	/**
	 * 业务日期：业务日期
	*/
	@ApiModelProperty(required = false,value="业务日期" , notes = "业务日期" , example = "2023-11-22 12:00:00")
	private Date businessDate;
	
	/**
	 * 领用说明：领用说明
	*/
	@ApiModelProperty(required = false,value="领用说明" , notes = "领用说明" , example = "jhh")
	private String content;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attachId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-11-30 09:23:26")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-11-30 09:38:47")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "4")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * assetStockGoodsList：assetStockGoodsList
	*/
	@ApiModelProperty(required = false,value="assetStockGoodsList" , notes = "assetStockGoodsList")
	private List<GoodsStock> assetStockGoodsList;
	
	/**
	 * selectedCode：selectedCode
	*/
	@ApiModelProperty(required = false,value="selectedCode" , notes = "selectedCode")
	private String selectedCode;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 历史流程清单：历史流程清单
	*/
	@ApiModelProperty(required = false,value="历史流程清单" , notes = "历史流程清单")
	private List<ProcessInstance> historicProcessList;
	
	/**
	 * 在批的流程清单：在批的流程清单
	*/
	@ApiModelProperty(required = false,value="在批的流程清单" , notes = "在批的流程清单")
	private List<ProcessInstance> currentProcessList;
	
	/**
	 * 默认流程：优先取在批的流程
	*/
	@ApiModelProperty(required = false,value="默认流程" , notes = "优先取在批的流程")
	private ProcessInstance defaultProcess;
	
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
	public AssetStockGoodsUse setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 业务编号<br>
	 * 业务编号
	 * @return 业务编号
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 业务编号
	 * @param businessCode 业务编号
	 * @return 当前对象
	*/
	public AssetStockGoodsUse setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 办理状态<br>
	 * 办理状态
	 * @return 办理状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 办理状态
	 * @param status 办理状态
	 * @return 当前对象
	*/
	public AssetStockGoodsUse setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 库存所属<br>
	 * 库存所属
	 * @return 库存所属
	*/
	public String getOwnerType() {
		return ownerType;
	}
	
	/**
	 * 设置 库存所属
	 * @param ownerType 库存所属
	 * @return 当前对象
	*/
	public AssetStockGoodsUse setOwnerType(String ownerType) {
		this.ownerType=ownerType;
		return this;
	}
	
	/**
	 * 获得 业务名称<br>
	 * 业务名称
	 * @return 业务名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 业务名称
	 * @param name 业务名称
	 * @return 当前对象
	*/
	public AssetStockGoodsUse setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 业务日期<br>
	 * 业务日期
	 * @return 业务日期
	*/
	public Date getBusinessDate() {
		return businessDate;
	}
	
	/**
	 * 设置 业务日期
	 * @param businessDate 业务日期
	 * @return 当前对象
	*/
	public AssetStockGoodsUse setBusinessDate(Date businessDate) {
		this.businessDate=businessDate;
		return this;
	}
	
	/**
	 * 获得 领用说明<br>
	 * 领用说明
	 * @return 领用说明
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 领用说明
	 * @param content 领用说明
	 * @return 当前对象
	*/
	public AssetStockGoodsUse setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public String getOriginatorId() {
		return originatorId;
	}
	
	/**
	 * 设置 制单人
	 * @param originatorId 制单人
	 * @return 当前对象
	*/
	public AssetStockGoodsUse setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getAttachId() {
		return attachId;
	}
	
	/**
	 * 设置 附件
	 * @param attachId 附件
	 * @return 当前对象
	*/
	public AssetStockGoodsUse setAttachId(String attachId) {
		this.attachId=attachId;
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
	public AssetStockGoodsUse setCreateBy(String createBy) {
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
	public AssetStockGoodsUse setCreateTime(Date createTime) {
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
	public AssetStockGoodsUse setUpdateBy(String updateBy) {
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
	public AssetStockGoodsUse setUpdateTime(Date updateTime) {
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
	public AssetStockGoodsUse setDeleted(Integer deleted) {
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
	public AssetStockGoodsUse setDeleted(Boolean deletedBool) {
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
	public AssetStockGoodsUse setDeleteBy(String deleteBy) {
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
	public AssetStockGoodsUse setDeleteTime(Date deleteTime) {
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
	public AssetStockGoodsUse setVersion(Integer version) {
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
	public AssetStockGoodsUse setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 assetStockGoodsList<br>
	 * assetStockGoodsList
	 * @return assetStockGoodsList
	*/
	public List<GoodsStock> getAssetStockGoodsList() {
		return assetStockGoodsList;
	}
	
	/**
	 * 设置 assetStockGoodsList
	 * @param assetStockGoodsList assetStockGoodsList
	 * @return 当前对象
	*/
	public AssetStockGoodsUse setAssetStockGoodsList(List<GoodsStock> assetStockGoodsList) {
		this.assetStockGoodsList=assetStockGoodsList;
		return this;
	}
	
	/**
	 * 添加 assetStockGoodsList
	 * @param assetStockGoods assetStockGoodsList
	 * @return 当前对象
	*/
	public AssetStockGoodsUse addAssetStockGoods(GoodsStock... assetStockGoods) {
		if(this.assetStockGoodsList==null) assetStockGoodsList=new ArrayList<>();
		this.assetStockGoodsList.addAll(Arrays.asList(assetStockGoods));
		return this;
	}
	
	/**
	 * 获得 selectedCode<br>
	 * selectedCode
	 * @return selectedCode
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 selectedCode
	 * @param selectedCode selectedCode
	 * @return 当前对象
	*/
	public AssetStockGoodsUse setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public Employee getOriginator() {
		return originator;
	}
	
	/**
	 * 设置 制单人
	 * @param originator 制单人
	 * @return 当前对象
	*/
	public AssetStockGoodsUse setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 历史流程清单<br>
	 * 历史流程清单
	 * @return 历史流程清单
	*/
	public List<ProcessInstance> getHistoricProcessList() {
		return historicProcessList;
	}
	
	/**
	 * 设置 历史流程清单
	 * @param historicProcessList 历史流程清单
	 * @return 当前对象
	*/
	public AssetStockGoodsUse setHistoricProcessList(List<ProcessInstance> historicProcessList) {
		this.historicProcessList=historicProcessList;
		return this;
	}
	
	/**
	 * 添加 历史流程清单
	 * @param historicProcess 历史流程清单
	 * @return 当前对象
	*/
	public AssetStockGoodsUse addHistoricProcess(ProcessInstance... historicProcess) {
		if(this.historicProcessList==null) historicProcessList=new ArrayList<>();
		this.historicProcessList.addAll(Arrays.asList(historicProcess));
		return this;
	}
	
	/**
	 * 获得 在批的流程清单<br>
	 * 在批的流程清单
	 * @return 在批的流程清单
	*/
	public List<ProcessInstance> getCurrentProcessList() {
		return currentProcessList;
	}
	
	/**
	 * 设置 在批的流程清单
	 * @param currentProcessList 在批的流程清单
	 * @return 当前对象
	*/
	public AssetStockGoodsUse setCurrentProcessList(List<ProcessInstance> currentProcessList) {
		this.currentProcessList=currentProcessList;
		return this;
	}
	
	/**
	 * 添加 在批的流程清单
	 * @param currentProcess 在批的流程清单
	 * @return 当前对象
	*/
	public AssetStockGoodsUse addCurrentProcess(ProcessInstance... currentProcess) {
		if(this.currentProcessList==null) currentProcessList=new ArrayList<>();
		this.currentProcessList.addAll(Arrays.asList(currentProcess));
		return this;
	}
	
	/**
	 * 获得 默认流程<br>
	 * 优先取在批的流程
	 * @return 默认流程
	*/
	public ProcessInstance getDefaultProcess() {
		return defaultProcess;
	}
	
	/**
	 * 设置 默认流程
	 * @param defaultProcess 默认流程
	 * @return 当前对象
	*/
	public AssetStockGoodsUse setDefaultProcess(ProcessInstance defaultProcess) {
		this.defaultProcess=defaultProcess;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetStockGoodsUse , 转换好的 AssetStockGoodsUse 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetStockGoodsUse , 转换好的 PoJo 对象
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
	public AssetStockGoodsUse clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetStockGoodsUse duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetStockGoodsUseMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetStockGoodsUseMeta.$$proxy$$();
		inst.setOwnerType(this.getOwnerType());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setAttachId(this.getAttachId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setAssetStockGoodsList(this.getAssetStockGoodsList());
			inst.setHistoricProcessList(this.getHistoricProcessList());
			inst.setOriginator(this.getOriginator());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setCurrentProcessList(this.getCurrentProcessList());
			inst.setDefaultProcess(this.getDefaultProcess());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetStockGoodsUse clone(boolean deep) {
		return EntityContext.clone(AssetStockGoodsUse.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetStockGoodsUse
	 * @param assetStockGoodsUseMap 包含实体信息的 Map 对象
	 * @return AssetStockGoodsUse , 转换好的的 AssetStockGoodsUse 对象
	*/
	@Transient
	public static AssetStockGoodsUse createFrom(Map<String,Object> assetStockGoodsUseMap) {
		if(assetStockGoodsUseMap==null) return null;
		AssetStockGoodsUse po = create();
		EntityContext.copyProperties(po,assetStockGoodsUseMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetStockGoodsUse
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetStockGoodsUse , 转换好的的 AssetStockGoodsUse 对象
	*/
	@Transient
	public static AssetStockGoodsUse createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetStockGoodsUse po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetStockGoodsUse，等同于 new
	 * @return AssetStockGoodsUse 对象
	*/
	@Transient
	public static AssetStockGoodsUse create() {
		return new com.dt.platform.domain.eam.meta.AssetStockGoodsUseMeta.$$proxy$$();
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
			this.setOwnerType(DataParser.parse(String.class, map.get(AssetStockGoodsUseMeta.OWNER_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetStockGoodsUseMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetStockGoodsUseMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(AssetStockGoodsUseMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(AssetStockGoodsUseMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetStockGoodsUseMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetStockGoodsUseMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetStockGoodsUseMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetStockGoodsUseMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetStockGoodsUseMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetStockGoodsUseMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssetStockGoodsUseMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetStockGoodsUseMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetStockGoodsUseMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetStockGoodsUseMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetStockGoodsUseMeta.ORIGINATOR_ID)));
			this.setAttachId(DataParser.parse(String.class, map.get(AssetStockGoodsUseMeta.ATTACH_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetStockGoodsUseMeta.STATUS)));
			// others
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetStockGoodsUseMeta.ORIGINATOR)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetStockGoodsUseMeta.SELECTED_CODE)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(AssetStockGoodsUseMeta.DEFAULT_PROCESS)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)map.get(AssetStockGoodsUseMeta.OWNER_TYPE));
				this.setUpdateTime( (Date)map.get(AssetStockGoodsUseMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetStockGoodsUseMeta.VERSION));
				this.setContent( (String)map.get(AssetStockGoodsUseMeta.CONTENT));
				this.setBusinessDate( (Date)map.get(AssetStockGoodsUseMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(AssetStockGoodsUseMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(AssetStockGoodsUseMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetStockGoodsUseMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetStockGoodsUseMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetStockGoodsUseMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetStockGoodsUseMeta.DELETE_TIME));
				this.setName( (String)map.get(AssetStockGoodsUseMeta.NAME));
				this.setTenantId( (String)map.get(AssetStockGoodsUseMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetStockGoodsUseMeta.DELETE_BY));
				this.setId( (String)map.get(AssetStockGoodsUseMeta.ID));
				this.setOriginatorId( (String)map.get(AssetStockGoodsUseMeta.ORIGINATOR_ID));
				this.setAttachId( (String)map.get(AssetStockGoodsUseMeta.ATTACH_ID));
				this.setStatus( (String)map.get(AssetStockGoodsUseMeta.STATUS));
				// others
				this.setOriginator( (Employee)map.get(AssetStockGoodsUseMeta.ORIGINATOR));
				this.setSelectedCode( (String)map.get(AssetStockGoodsUseMeta.SELECTED_CODE));
				this.setDefaultProcess( (ProcessInstance)map.get(AssetStockGoodsUseMeta.DEFAULT_PROCESS));
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
			this.setOwnerType(DataParser.parse(String.class, r.getValue(AssetStockGoodsUseMeta.OWNER_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsUseMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetStockGoodsUseMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetStockGoodsUseMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(AssetStockGoodsUseMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsUseMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsUseMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetStockGoodsUseMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsUseMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsUseMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsUseMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetStockGoodsUseMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetStockGoodsUseMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsUseMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetStockGoodsUseMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetStockGoodsUseMeta.ORIGINATOR_ID)));
			this.setAttachId(DataParser.parse(String.class, r.getValue(AssetStockGoodsUseMeta.ATTACH_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetStockGoodsUseMeta.STATUS)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)r.getValue(AssetStockGoodsUseMeta.OWNER_TYPE));
				this.setUpdateTime( (Date)r.getValue(AssetStockGoodsUseMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetStockGoodsUseMeta.VERSION));
				this.setContent( (String)r.getValue(AssetStockGoodsUseMeta.CONTENT));
				this.setBusinessDate( (Date)r.getValue(AssetStockGoodsUseMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(AssetStockGoodsUseMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(AssetStockGoodsUseMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetStockGoodsUseMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetStockGoodsUseMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetStockGoodsUseMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetStockGoodsUseMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssetStockGoodsUseMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetStockGoodsUseMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetStockGoodsUseMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetStockGoodsUseMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetStockGoodsUseMeta.ORIGINATOR_ID));
				this.setAttachId( (String)r.getValue(AssetStockGoodsUseMeta.ATTACH_ID));
				this.setStatus( (String)r.getValue(AssetStockGoodsUseMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}