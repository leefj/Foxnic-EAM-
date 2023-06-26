package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_RFID_LABEL;
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
import com.dt.platform.domain.eam.meta.RfidLabelMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * RFID标签
 * <p>RFID标签 , 数据表 eam_rfid_label 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-23 20:46:11
 * @sign 62AF274B4AC9C1017836DE9E84792DB4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_rfid_label")
@ApiModel(description = "RFID标签 ; RFID标签 , 数据表 eam_rfid_label 的PO类型")
public class RfidLabel extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_RFID_LABEL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "724716005309284352")
	private String id;
	
	/**
	 * RFID发卡：RFID发卡
	*/
	@ApiModelProperty(required = false,value="RFID发卡" , notes = "RFID发卡")
	private String releaseId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产" , example = "714558755877945344")
	private String assetId;
	
	/**
	 * 资产编码：资产编码
	*/
	@ApiModelProperty(required = false,value="资产编码" , notes = "资产编码")
	private String assetCode;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签" , example = "12")
	private String label;
	
	/**
	 * 发卡时间：发卡时间
	*/
	@ApiModelProperty(required = false,value="发卡时间" , notes = "发卡时间" , example = "2023-05-20 12:00:00")
	private Date operTime;
	
	/**
	 * 操作人员：操作人员
	*/
	@ApiModelProperty(required = false,value="操作人员" , notes = "操作人员")
	private String operUserId;
	
	/**
	 * 发卡结果：发卡结果
	*/
	@ApiModelProperty(required = false,value="发卡结果" , notes = "发卡结果")
	private String operResult;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "1212")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-06-23 08:02:40")
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private Asset asset;
	
	/**
	 * operUser：operUser
	*/
	@ApiModelProperty(required = false,value="operUser" , notes = "operUser")
	private Employee operUser;
	
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
	public RfidLabel setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 RFID发卡<br>
	 * RFID发卡
	 * @return RFID发卡
	*/
	public String getReleaseId() {
		return releaseId;
	}
	
	/**
	 * 设置 RFID发卡
	 * @param releaseId RFID发卡
	 * @return 当前对象
	*/
	public RfidLabel setReleaseId(String releaseId) {
		this.releaseId=releaseId;
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
	public RfidLabel setStatus(String status) {
		this.status=status;
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
	public RfidLabel setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 资产编码<br>
	 * 资产编码
	 * @return 资产编码
	*/
	public String getAssetCode() {
		return assetCode;
	}
	
	/**
	 * 设置 资产编码
	 * @param assetCode 资产编码
	 * @return 当前对象
	*/
	public RfidLabel setAssetCode(String assetCode) {
		this.assetCode=assetCode;
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
	public RfidLabel setLabel(String label) {
		this.label=label;
		return this;
	}
	
	/**
	 * 获得 发卡时间<br>
	 * 发卡时间
	 * @return 发卡时间
	*/
	public Date getOperTime() {
		return operTime;
	}
	
	/**
	 * 设置 发卡时间
	 * @param operTime 发卡时间
	 * @return 当前对象
	*/
	public RfidLabel setOperTime(Date operTime) {
		this.operTime=operTime;
		return this;
	}
	
	/**
	 * 获得 操作人员<br>
	 * 操作人员
	 * @return 操作人员
	*/
	public String getOperUserId() {
		return operUserId;
	}
	
	/**
	 * 设置 操作人员
	 * @param operUserId 操作人员
	 * @return 当前对象
	*/
	public RfidLabel setOperUserId(String operUserId) {
		this.operUserId=operUserId;
		return this;
	}
	
	/**
	 * 获得 发卡结果<br>
	 * 发卡结果
	 * @return 发卡结果
	*/
	public String getOperResult() {
		return operResult;
	}
	
	/**
	 * 设置 发卡结果
	 * @param operResult 发卡结果
	 * @return 当前对象
	*/
	public RfidLabel setOperResult(String operResult) {
		this.operResult=operResult;
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
	public RfidLabel setNotes(String notes) {
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
	public RfidLabel setCreateBy(String createBy) {
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
	public RfidLabel setCreateTime(Date createTime) {
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
	public RfidLabel setUpdateBy(String updateBy) {
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
	public RfidLabel setUpdateTime(Date updateTime) {
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
	public RfidLabel setDeleted(Integer deleted) {
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
	public RfidLabel setDeleted(Boolean deletedBool) {
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
	public RfidLabel setDeleteBy(String deleteBy) {
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
	public RfidLabel setDeleteTime(Date deleteTime) {
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
	public RfidLabel setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public Asset getAsset() {
		return asset;
	}
	
	/**
	 * 设置 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public RfidLabel setAsset(Asset asset) {
		this.asset=asset;
		return this;
	}
	
	/**
	 * 获得 operUser<br>
	 * operUser
	 * @return operUser
	*/
	public Employee getOperUser() {
		return operUser;
	}
	
	/**
	 * 设置 operUser
	 * @param operUser operUser
	 * @return 当前对象
	*/
	public RfidLabel setOperUser(Employee operUser) {
		this.operUser=operUser;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return RfidLabel , 转换好的 RfidLabel 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RfidLabel , 转换好的 PoJo 对象
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
	public RfidLabel clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public RfidLabel duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.RfidLabelMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.RfidLabelMeta.$$proxy$$();
		inst.setOperUserId(this.getOperUserId());
		inst.setAssetCode(this.getAssetCode());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setLabel(this.getLabel());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setOperResult(this.getOperResult());
		inst.setDeleted(this.getDeleted());
		inst.setReleaseId(this.getReleaseId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssetId(this.getAssetId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		inst.setOperTime(this.getOperTime());
		if(all) {
			inst.setAsset(this.getAsset());
			inst.setOperUser(this.getOperUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public RfidLabel clone(boolean deep) {
		return EntityContext.clone(RfidLabel.class,this,deep);
	}

	/**
	 * 将 Map 转换成 RfidLabel
	 * @param rfidLabelMap 包含实体信息的 Map 对象
	 * @return RfidLabel , 转换好的的 RfidLabel 对象
	*/
	@Transient
	public static RfidLabel createFrom(Map<String,Object> rfidLabelMap) {
		if(rfidLabelMap==null) return null;
		RfidLabel po = create();
		EntityContext.copyProperties(po,rfidLabelMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 RfidLabel
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RfidLabel , 转换好的的 RfidLabel 对象
	*/
	@Transient
	public static RfidLabel createFrom(Object pojo) {
		if(pojo==null) return null;
		RfidLabel po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 RfidLabel，等同于 new
	 * @return RfidLabel 对象
	*/
	@Transient
	public static RfidLabel create() {
		return new com.dt.platform.domain.eam.meta.RfidLabelMeta.$$proxy$$();
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
			this.setOperUserId(DataParser.parse(String.class, map.get(RfidLabelMeta.OPER_USER_ID)));
			this.setAssetCode(DataParser.parse(String.class, map.get(RfidLabelMeta.ASSET_CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(RfidLabelMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(RfidLabelMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, map.get(RfidLabelMeta.LABEL)));
			this.setVersion(DataParser.parse(Integer.class, map.get(RfidLabelMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(RfidLabelMeta.CREATE_BY)));
			this.setOperResult(DataParser.parse(String.class, map.get(RfidLabelMeta.OPER_RESULT)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(RfidLabelMeta.DELETED)));
			this.setReleaseId(DataParser.parse(String.class, map.get(RfidLabelMeta.RELEASE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(RfidLabelMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(RfidLabelMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(RfidLabelMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, map.get(RfidLabelMeta.ASSET_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(RfidLabelMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(RfidLabelMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(RfidLabelMeta.STATUS)));
			this.setOperTime(DataParser.parse(Date.class, map.get(RfidLabelMeta.OPER_TIME)));
			// others
			this.setAsset(DataParser.parse(Asset.class, map.get(RfidLabelMeta.ASSET)));
			this.setOperUser(DataParser.parse(Employee.class, map.get(RfidLabelMeta.OPER_USER)));
			return true;
		} else {
			try {
				this.setOperUserId( (String)map.get(RfidLabelMeta.OPER_USER_ID));
				this.setAssetCode( (String)map.get(RfidLabelMeta.ASSET_CODE));
				this.setNotes( (String)map.get(RfidLabelMeta.NOTES));
				this.setUpdateTime( (Date)map.get(RfidLabelMeta.UPDATE_TIME));
				this.setLabel( (String)map.get(RfidLabelMeta.LABEL));
				this.setVersion( (Integer)map.get(RfidLabelMeta.VERSION));
				this.setCreateBy( (String)map.get(RfidLabelMeta.CREATE_BY));
				this.setOperResult( (String)map.get(RfidLabelMeta.OPER_RESULT));
				this.setDeleted( (Integer)map.get(RfidLabelMeta.DELETED));
				this.setReleaseId( (String)map.get(RfidLabelMeta.RELEASE_ID));
				this.setCreateTime( (Date)map.get(RfidLabelMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(RfidLabelMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(RfidLabelMeta.DELETE_TIME));
				this.setAssetId( (String)map.get(RfidLabelMeta.ASSET_ID));
				this.setDeleteBy( (String)map.get(RfidLabelMeta.DELETE_BY));
				this.setId( (String)map.get(RfidLabelMeta.ID));
				this.setStatus( (String)map.get(RfidLabelMeta.STATUS));
				this.setOperTime( (Date)map.get(RfidLabelMeta.OPER_TIME));
				// others
				this.setAsset( (Asset)map.get(RfidLabelMeta.ASSET));
				this.setOperUser( (Employee)map.get(RfidLabelMeta.OPER_USER));
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
			this.setOperUserId(DataParser.parse(String.class, r.getValue(RfidLabelMeta.OPER_USER_ID)));
			this.setAssetCode(DataParser.parse(String.class, r.getValue(RfidLabelMeta.ASSET_CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(RfidLabelMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(RfidLabelMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, r.getValue(RfidLabelMeta.LABEL)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(RfidLabelMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(RfidLabelMeta.CREATE_BY)));
			this.setOperResult(DataParser.parse(String.class, r.getValue(RfidLabelMeta.OPER_RESULT)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(RfidLabelMeta.DELETED)));
			this.setReleaseId(DataParser.parse(String.class, r.getValue(RfidLabelMeta.RELEASE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(RfidLabelMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(RfidLabelMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(RfidLabelMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(RfidLabelMeta.ASSET_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(RfidLabelMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(RfidLabelMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(RfidLabelMeta.STATUS)));
			this.setOperTime(DataParser.parse(Date.class, r.getValue(RfidLabelMeta.OPER_TIME)));
			return true;
		} else {
			try {
				this.setOperUserId( (String)r.getValue(RfidLabelMeta.OPER_USER_ID));
				this.setAssetCode( (String)r.getValue(RfidLabelMeta.ASSET_CODE));
				this.setNotes( (String)r.getValue(RfidLabelMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(RfidLabelMeta.UPDATE_TIME));
				this.setLabel( (String)r.getValue(RfidLabelMeta.LABEL));
				this.setVersion( (Integer)r.getValue(RfidLabelMeta.VERSION));
				this.setCreateBy( (String)r.getValue(RfidLabelMeta.CREATE_BY));
				this.setOperResult( (String)r.getValue(RfidLabelMeta.OPER_RESULT));
				this.setDeleted( (Integer)r.getValue(RfidLabelMeta.DELETED));
				this.setReleaseId( (String)r.getValue(RfidLabelMeta.RELEASE_ID));
				this.setCreateTime( (Date)r.getValue(RfidLabelMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(RfidLabelMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(RfidLabelMeta.DELETE_TIME));
				this.setAssetId( (String)r.getValue(RfidLabelMeta.ASSET_ID));
				this.setDeleteBy( (String)r.getValue(RfidLabelMeta.DELETE_BY));
				this.setId( (String)r.getValue(RfidLabelMeta.ID));
				this.setStatus( (String)r.getValue(RfidLabelMeta.STATUS));
				this.setOperTime( (Date)r.getValue(RfidLabelMeta.OPER_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}