package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_REPAIR_ORDER_ACT_SP;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.RepairOrderActSpMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 维修备件
 * <p>维修备件 , 数据表 eam_repair_order_act_sp 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-17 15:16:56
 * @sign B387864FAC39FCD61CA74D77388FA93B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_repair_order_act_sp")
@ApiModel(description = "维修备件 ; 维修备件 , 数据表 eam_repair_order_act_sp 的PO类型")
public class RepairOrderActSp extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_REPAIR_ORDER_ACT_SP.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 维修工单：维修工单
	*/
	@ApiModelProperty(required = false,value="维修工单" , notes = "维修工单")
	private String actId;
	
	/**
	 * 备件：备件
	*/
	@ApiModelProperty(required = false,value="备件" , notes = "备件")
	private String spId;
	
	/**
	 * 备件名称：备件名称
	*/
	@ApiModelProperty(required = false,value="备件名称" , notes = "备件名称")
	private String spName;
	
	/**
	 * 备件编码：备件编码
	*/
	@ApiModelProperty(required = false,value="备件编码" , notes = "备件编码")
	private String spCode;
	
	/**
	 * 备件序列：备件序列
	*/
	@ApiModelProperty(required = false,value="备件序列" , notes = "备件序列")
	private String spSn;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String spNotes;
	
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
	 * 选择数据：选择数据
	*/
	@ApiModelProperty(required = false,value="选择数据" , notes = "选择数据")
	private String selectedCode;
	
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
	public RepairOrderActSp setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 维修工单<br>
	 * 维修工单
	 * @return 维修工单
	*/
	public String getActId() {
		return actId;
	}
	
	/**
	 * 设置 维修工单
	 * @param actId 维修工单
	 * @return 当前对象
	*/
	public RepairOrderActSp setActId(String actId) {
		this.actId=actId;
		return this;
	}
	
	/**
	 * 获得 备件<br>
	 * 备件
	 * @return 备件
	*/
	public String getSpId() {
		return spId;
	}
	
	/**
	 * 设置 备件
	 * @param spId 备件
	 * @return 当前对象
	*/
	public RepairOrderActSp setSpId(String spId) {
		this.spId=spId;
		return this;
	}
	
	/**
	 * 获得 备件名称<br>
	 * 备件名称
	 * @return 备件名称
	*/
	public String getSpName() {
		return spName;
	}
	
	/**
	 * 设置 备件名称
	 * @param spName 备件名称
	 * @return 当前对象
	*/
	public RepairOrderActSp setSpName(String spName) {
		this.spName=spName;
		return this;
	}
	
	/**
	 * 获得 备件编码<br>
	 * 备件编码
	 * @return 备件编码
	*/
	public String getSpCode() {
		return spCode;
	}
	
	/**
	 * 设置 备件编码
	 * @param spCode 备件编码
	 * @return 当前对象
	*/
	public RepairOrderActSp setSpCode(String spCode) {
		this.spCode=spCode;
		return this;
	}
	
	/**
	 * 获得 备件序列<br>
	 * 备件序列
	 * @return 备件序列
	*/
	public String getSpSn() {
		return spSn;
	}
	
	/**
	 * 设置 备件序列
	 * @param spSn 备件序列
	 * @return 当前对象
	*/
	public RepairOrderActSp setSpSn(String spSn) {
		this.spSn=spSn;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getSpNotes() {
		return spNotes;
	}
	
	/**
	 * 设置 备注
	 * @param spNotes 备注
	 * @return 当前对象
	*/
	public RepairOrderActSp setSpNotes(String spNotes) {
		this.spNotes=spNotes;
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
	public RepairOrderActSp setCreateBy(String createBy) {
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
	public RepairOrderActSp setCreateTime(Date createTime) {
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
	public RepairOrderActSp setUpdateBy(String updateBy) {
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
	public RepairOrderActSp setUpdateTime(Date updateTime) {
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
	public RepairOrderActSp setDeleted(Integer deleted) {
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
	public RepairOrderActSp setDeleted(Boolean deletedBool) {
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
	public RepairOrderActSp setDeleteBy(String deleteBy) {
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
	public RepairOrderActSp setDeleteTime(Date deleteTime) {
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
	public RepairOrderActSp setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 选择数据<br>
	 * 选择数据
	 * @return 选择数据
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择数据
	 * @param selectedCode 选择数据
	 * @return 当前对象
	*/
	public RepairOrderActSp setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return RepairOrderActSp , 转换好的 RepairOrderActSp 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RepairOrderActSp , 转换好的 PoJo 对象
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
	public RepairOrderActSp clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public RepairOrderActSp duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.RepairOrderActSpMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.RepairOrderActSpMeta.$$proxy$$();
		inst.setSpName(this.getSpName());
		inst.setActId(this.getActId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSpId(this.getSpId());
		inst.setSpCode(this.getSpCode());
		inst.setSpSn(this.getSpSn());
		inst.setVersion(this.getVersion());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setSpNotes(this.getSpNotes());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public RepairOrderActSp clone(boolean deep) {
		return EntityContext.clone(RepairOrderActSp.class,this,deep);
	}

	/**
	 * 将 Map 转换成 RepairOrderActSp
	 * @param repairOrderActSpMap 包含实体信息的 Map 对象
	 * @return RepairOrderActSp , 转换好的的 RepairOrderActSp 对象
	*/
	@Transient
	public static RepairOrderActSp createFrom(Map<String,Object> repairOrderActSpMap) {
		if(repairOrderActSpMap==null) return null;
		RepairOrderActSp po = create();
		EntityContext.copyProperties(po,repairOrderActSpMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 RepairOrderActSp
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RepairOrderActSp , 转换好的的 RepairOrderActSp 对象
	*/
	@Transient
	public static RepairOrderActSp createFrom(Object pojo) {
		if(pojo==null) return null;
		RepairOrderActSp po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 RepairOrderActSp，等同于 new
	 * @return RepairOrderActSp 对象
	*/
	@Transient
	public static RepairOrderActSp create() {
		return new com.dt.platform.domain.eam.meta.RepairOrderActSpMeta.$$proxy$$();
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
			this.setSpName(DataParser.parse(String.class, map.get(RepairOrderActSpMeta.SP_NAME)));
			this.setActId(DataParser.parse(String.class, map.get(RepairOrderActSpMeta.ACT_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(RepairOrderActSpMeta.UPDATE_TIME)));
			this.setSpId(DataParser.parse(String.class, map.get(RepairOrderActSpMeta.SP_ID)));
			this.setSpCode(DataParser.parse(String.class, map.get(RepairOrderActSpMeta.SP_CODE)));
			this.setSpSn(DataParser.parse(String.class, map.get(RepairOrderActSpMeta.SP_SN)));
			this.setVersion(DataParser.parse(Integer.class, map.get(RepairOrderActSpMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(RepairOrderActSpMeta.SELECTED_CODE)));
			this.setSpNotes(DataParser.parse(String.class, map.get(RepairOrderActSpMeta.SP_NOTES)));
			this.setCreateBy(DataParser.parse(String.class, map.get(RepairOrderActSpMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(RepairOrderActSpMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(RepairOrderActSpMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(RepairOrderActSpMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(RepairOrderActSpMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(RepairOrderActSpMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(RepairOrderActSpMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setSpName( (String)map.get(RepairOrderActSpMeta.SP_NAME));
				this.setActId( (String)map.get(RepairOrderActSpMeta.ACT_ID));
				this.setUpdateTime( (Date)map.get(RepairOrderActSpMeta.UPDATE_TIME));
				this.setSpId( (String)map.get(RepairOrderActSpMeta.SP_ID));
				this.setSpCode( (String)map.get(RepairOrderActSpMeta.SP_CODE));
				this.setSpSn( (String)map.get(RepairOrderActSpMeta.SP_SN));
				this.setVersion( (Integer)map.get(RepairOrderActSpMeta.VERSION));
				this.setSelectedCode( (String)map.get(RepairOrderActSpMeta.SELECTED_CODE));
				this.setSpNotes( (String)map.get(RepairOrderActSpMeta.SP_NOTES));
				this.setCreateBy( (String)map.get(RepairOrderActSpMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(RepairOrderActSpMeta.DELETED));
				this.setCreateTime( (Date)map.get(RepairOrderActSpMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(RepairOrderActSpMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(RepairOrderActSpMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(RepairOrderActSpMeta.DELETE_BY));
				this.setId( (String)map.get(RepairOrderActSpMeta.ID));
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
			this.setSpName(DataParser.parse(String.class, r.getValue(RepairOrderActSpMeta.SP_NAME)));
			this.setActId(DataParser.parse(String.class, r.getValue(RepairOrderActSpMeta.ACT_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(RepairOrderActSpMeta.UPDATE_TIME)));
			this.setSpId(DataParser.parse(String.class, r.getValue(RepairOrderActSpMeta.SP_ID)));
			this.setSpCode(DataParser.parse(String.class, r.getValue(RepairOrderActSpMeta.SP_CODE)));
			this.setSpSn(DataParser.parse(String.class, r.getValue(RepairOrderActSpMeta.SP_SN)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(RepairOrderActSpMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(RepairOrderActSpMeta.SELECTED_CODE)));
			this.setSpNotes(DataParser.parse(String.class, r.getValue(RepairOrderActSpMeta.SP_NOTES)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(RepairOrderActSpMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(RepairOrderActSpMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(RepairOrderActSpMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(RepairOrderActSpMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(RepairOrderActSpMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(RepairOrderActSpMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(RepairOrderActSpMeta.ID)));
			return true;
		} else {
			try {
				this.setSpName( (String)r.getValue(RepairOrderActSpMeta.SP_NAME));
				this.setActId( (String)r.getValue(RepairOrderActSpMeta.ACT_ID));
				this.setUpdateTime( (Date)r.getValue(RepairOrderActSpMeta.UPDATE_TIME));
				this.setSpId( (String)r.getValue(RepairOrderActSpMeta.SP_ID));
				this.setSpCode( (String)r.getValue(RepairOrderActSpMeta.SP_CODE));
				this.setSpSn( (String)r.getValue(RepairOrderActSpMeta.SP_SN));
				this.setVersion( (Integer)r.getValue(RepairOrderActSpMeta.VERSION));
				this.setSelectedCode( (String)r.getValue(RepairOrderActSpMeta.SELECTED_CODE));
				this.setSpNotes( (String)r.getValue(RepairOrderActSpMeta.SP_NOTES));
				this.setCreateBy( (String)r.getValue(RepairOrderActSpMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(RepairOrderActSpMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(RepairOrderActSpMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(RepairOrderActSpMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(RepairOrderActSpMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(RepairOrderActSpMeta.DELETE_BY));
				this.setId( (String)r.getValue(RepairOrderActSpMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}