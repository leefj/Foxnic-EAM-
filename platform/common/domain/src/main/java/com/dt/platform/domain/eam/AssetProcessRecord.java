package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_PROCESS_RECORD;
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
import com.dt.platform.domain.eam.meta.AssetProcessRecordMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产处理记录
 * <p>资产处理记录 , 数据表 eam_asset_process_record 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-01 09:45:39
 * @sign 02C1D716DC9AB714BABB9DF14A289B7B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_process_record")
@ApiModel(description = "资产处理记录 ; 资产处理记录 , 数据表 eam_asset_process_record 的PO类型")
public class AssetProcessRecord extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_PROCESS_RECORD.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "788842097154195456")
	private String id;
	
	/**
	 * 资产名称：资产名称
	*/
	@ApiModelProperty(required = false,value="资产名称" , notes = "资产名称" , example = "788842079307431936")
	private String assetId;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号" , example = "788842096814456832")
	private String businessCode;
	
	/**
	 * 操作类型：操作类型
	*/
	@ApiModelProperty(required = false,value="操作类型" , notes = "操作类型" , example = "eam_asset_insert")
	private String processType;
	
	/**
	 * 操作内容：操作内容
	*/
	@ApiModelProperty(required = false,value="操作内容" , notes = "操作内容" , example = "资产入库")
	private String content;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 使用人：使用人
	*/
	@ApiModelProperty(required = false,value="使用人" , notes = "使用人")
	private String useUserId;
	
	/**
	 * 操作人员：操作人员
	*/
	@ApiModelProperty(required = false,value="操作人员" , notes = "操作人员" , example = "E001")
	private String processUserId;
	
	/**
	 * 操作时间：操作时间
	*/
	@ApiModelProperty(required = false,value="操作时间" , notes = "操作时间" , example = "2023-12-17 06:56:52")
	private Date processdTime;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-12-17 06:56:52")
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
	public AssetProcessRecord setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 资产名称<br>
	 * 资产名称
	 * @return 资产名称
	*/
	public String getAssetId() {
		return assetId;
	}
	
	/**
	 * 设置 资产名称
	 * @param assetId 资产名称
	 * @return 当前对象
	*/
	public AssetProcessRecord setAssetId(String assetId) {
		this.assetId=assetId;
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
	public AssetProcessRecord setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 操作类型<br>
	 * 操作类型
	 * @return 操作类型
	*/
	public String getProcessType() {
		return processType;
	}
	
	/**
	 * 设置 操作类型
	 * @param processType 操作类型
	 * @return 当前对象
	*/
	public AssetProcessRecord setProcessType(String processType) {
		this.processType=processType;
		return this;
	}
	
	/**
	 * 获得 操作内容<br>
	 * 操作内容
	 * @return 操作内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 操作内容
	 * @param content 操作内容
	 * @return 当前对象
	*/
	public AssetProcessRecord setContent(String content) {
		this.content=content;
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
	public AssetProcessRecord setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 使用人<br>
	 * 使用人
	 * @return 使用人
	*/
	public String getUseUserId() {
		return useUserId;
	}
	
	/**
	 * 设置 使用人
	 * @param useUserId 使用人
	 * @return 当前对象
	*/
	public AssetProcessRecord setUseUserId(String useUserId) {
		this.useUserId=useUserId;
		return this;
	}
	
	/**
	 * 获得 操作人员<br>
	 * 操作人员
	 * @return 操作人员
	*/
	public String getProcessUserId() {
		return processUserId;
	}
	
	/**
	 * 设置 操作人员
	 * @param processUserId 操作人员
	 * @return 当前对象
	*/
	public AssetProcessRecord setProcessUserId(String processUserId) {
		this.processUserId=processUserId;
		return this;
	}
	
	/**
	 * 获得 操作时间<br>
	 * 操作时间
	 * @return 操作时间
	*/
	public Date getProcessdTime() {
		return processdTime;
	}
	
	/**
	 * 设置 操作时间
	 * @param processdTime 操作时间
	 * @return 当前对象
	*/
	public AssetProcessRecord setProcessdTime(Date processdTime) {
		this.processdTime=processdTime;
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
	public AssetProcessRecord setCreateBy(String createBy) {
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
	public AssetProcessRecord setCreateTime(Date createTime) {
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
	public AssetProcessRecord setUpdateBy(String updateBy) {
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
	public AssetProcessRecord setUpdateTime(Date updateTime) {
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
	public AssetProcessRecord setDeleted(Integer deleted) {
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
	public AssetProcessRecord setDeleted(Boolean deletedBool) {
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
	public AssetProcessRecord setDeleteBy(String deleteBy) {
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
	public AssetProcessRecord setDeleteTime(Date deleteTime) {
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
	public AssetProcessRecord setVersion(Integer version) {
		this.version=version;
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
	public AssetProcessRecord setOperUser(Employee operUser) {
		this.operUser=operUser;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetProcessRecord , 转换好的 AssetProcessRecord 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetProcessRecord , 转换好的 PoJo 对象
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
	public AssetProcessRecord clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetProcessRecord duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetProcessRecordMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetProcessRecordMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setProcessdTime(this.getProcessdTime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssetId(this.getAssetId());
		inst.setProcessUserId(this.getProcessUserId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setProcessType(this.getProcessType());
		inst.setUseUserId(this.getUseUserId());
		if(all) {
			inst.setOperUser(this.getOperUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetProcessRecord clone(boolean deep) {
		return EntityContext.clone(AssetProcessRecord.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetProcessRecord
	 * @param assetProcessRecordMap 包含实体信息的 Map 对象
	 * @return AssetProcessRecord , 转换好的的 AssetProcessRecord 对象
	*/
	@Transient
	public static AssetProcessRecord createFrom(Map<String,Object> assetProcessRecordMap) {
		if(assetProcessRecordMap==null) return null;
		AssetProcessRecord po = create();
		EntityContext.copyProperties(po,assetProcessRecordMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetProcessRecord
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetProcessRecord , 转换好的的 AssetProcessRecord 对象
	*/
	@Transient
	public static AssetProcessRecord createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetProcessRecord po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetProcessRecord，等同于 new
	 * @return AssetProcessRecord 对象
	*/
	@Transient
	public static AssetProcessRecord create() {
		return new com.dt.platform.domain.eam.meta.AssetProcessRecordMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AssetProcessRecordMeta.NOTES)));
			this.setProcessdTime(DataParser.parse(Date.class, map.get(AssetProcessRecordMeta.PROCESSD_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetProcessRecordMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetProcessRecordMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(AssetProcessRecordMeta.CONTENT)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetProcessRecordMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetProcessRecordMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetProcessRecordMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetProcessRecordMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetProcessRecordMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetProcessRecordMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, map.get(AssetProcessRecordMeta.ASSET_ID)));
			this.setProcessUserId(DataParser.parse(String.class, map.get(AssetProcessRecordMeta.PROCESS_USER_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetProcessRecordMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetProcessRecordMeta.ID)));
			this.setProcessType(DataParser.parse(String.class, map.get(AssetProcessRecordMeta.PROCESS_TYPE)));
			this.setUseUserId(DataParser.parse(String.class, map.get(AssetProcessRecordMeta.USE_USER_ID)));
			// others
			this.setOperUser(DataParser.parse(Employee.class, map.get(AssetProcessRecordMeta.OPER_USER)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AssetProcessRecordMeta.NOTES));
				this.setProcessdTime( (Date)map.get(AssetProcessRecordMeta.PROCESSD_TIME));
				this.setUpdateTime( (Date)map.get(AssetProcessRecordMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetProcessRecordMeta.VERSION));
				this.setContent( (String)map.get(AssetProcessRecordMeta.CONTENT));
				this.setBusinessCode( (String)map.get(AssetProcessRecordMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(AssetProcessRecordMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetProcessRecordMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetProcessRecordMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetProcessRecordMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetProcessRecordMeta.DELETE_TIME));
				this.setAssetId( (String)map.get(AssetProcessRecordMeta.ASSET_ID));
				this.setProcessUserId( (String)map.get(AssetProcessRecordMeta.PROCESS_USER_ID));
				this.setDeleteBy( (String)map.get(AssetProcessRecordMeta.DELETE_BY));
				this.setId( (String)map.get(AssetProcessRecordMeta.ID));
				this.setProcessType( (String)map.get(AssetProcessRecordMeta.PROCESS_TYPE));
				this.setUseUserId( (String)map.get(AssetProcessRecordMeta.USE_USER_ID));
				// others
				this.setOperUser( (Employee)map.get(AssetProcessRecordMeta.OPER_USER));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetProcessRecordMeta.NOTES)));
			this.setProcessdTime(DataParser.parse(Date.class, r.getValue(AssetProcessRecordMeta.PROCESSD_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetProcessRecordMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetProcessRecordMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetProcessRecordMeta.CONTENT)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetProcessRecordMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetProcessRecordMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetProcessRecordMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetProcessRecordMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetProcessRecordMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetProcessRecordMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(AssetProcessRecordMeta.ASSET_ID)));
			this.setProcessUserId(DataParser.parse(String.class, r.getValue(AssetProcessRecordMeta.PROCESS_USER_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetProcessRecordMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetProcessRecordMeta.ID)));
			this.setProcessType(DataParser.parse(String.class, r.getValue(AssetProcessRecordMeta.PROCESS_TYPE)));
			this.setUseUserId(DataParser.parse(String.class, r.getValue(AssetProcessRecordMeta.USE_USER_ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AssetProcessRecordMeta.NOTES));
				this.setProcessdTime( (Date)r.getValue(AssetProcessRecordMeta.PROCESSD_TIME));
				this.setUpdateTime( (Date)r.getValue(AssetProcessRecordMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetProcessRecordMeta.VERSION));
				this.setContent( (String)r.getValue(AssetProcessRecordMeta.CONTENT));
				this.setBusinessCode( (String)r.getValue(AssetProcessRecordMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(AssetProcessRecordMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetProcessRecordMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetProcessRecordMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetProcessRecordMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetProcessRecordMeta.DELETE_TIME));
				this.setAssetId( (String)r.getValue(AssetProcessRecordMeta.ASSET_ID));
				this.setProcessUserId( (String)r.getValue(AssetProcessRecordMeta.PROCESS_USER_ID));
				this.setDeleteBy( (String)r.getValue(AssetProcessRecordMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetProcessRecordMeta.ID));
				this.setProcessType( (String)r.getValue(AssetProcessRecordMeta.PROCESS_TYPE));
				this.setUseUserId( (String)r.getValue(AssetProcessRecordMeta.USE_USER_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}