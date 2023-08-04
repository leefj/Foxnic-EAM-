package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_REPAIR_ORDER_PROCESS;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.RepairOrderProcessMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 流转过程
 * <p>流转过程 , 数据表 eam_repair_order_process 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-04 06:54:31
 * @sign 0E75F76A7DD27BED97455018C1FE9A39
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_repair_order_process")
@ApiModel(description = "流转过程 ; 流转过程 , 数据表 eam_repair_order_process 的PO类型")
public class RepairOrderProcess extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_REPAIR_ORDER_PROCESS.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 工单：工单
	*/
	@ApiModelProperty(required = false,value="工单" , notes = "工单")
	private String orderId;
	
	/**
	 * 维修单：维修单
	*/
	@ApiModelProperty(required = false,value="维修单" , notes = "维修单")
	private String actId;
	
	/**
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员")
	private String userId;
	
	/**
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员")
	private String userName;
	
	/**
	 * 执行过程：执行过程
	*/
	@ApiModelProperty(required = false,value="执行过程" , notes = "执行过程")
	private String processContent;
	
	/**
	 * 操作时间：操作时间
	*/
	@ApiModelProperty(required = false,value="操作时间" , notes = "操作时间")
	private Date rcdTime;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	public RepairOrderProcess setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 工单<br>
	 * 工单
	 * @return 工单
	*/
	public String getOrderId() {
		return orderId;
	}
	
	/**
	 * 设置 工单
	 * @param orderId 工单
	 * @return 当前对象
	*/
	public RepairOrderProcess setOrderId(String orderId) {
		this.orderId=orderId;
		return this;
	}
	
	/**
	 * 获得 维修单<br>
	 * 维修单
	 * @return 维修单
	*/
	public String getActId() {
		return actId;
	}
	
	/**
	 * 设置 维修单
	 * @param actId 维修单
	 * @return 当前对象
	*/
	public RepairOrderProcess setActId(String actId) {
		this.actId=actId;
		return this;
	}
	
	/**
	 * 获得 人员<br>
	 * 人员
	 * @return 人员
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 人员
	 * @param userId 人员
	 * @return 当前对象
	*/
	public RepairOrderProcess setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 人员<br>
	 * 人员
	 * @return 人员
	*/
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 设置 人员
	 * @param userName 人员
	 * @return 当前对象
	*/
	public RepairOrderProcess setUserName(String userName) {
		this.userName=userName;
		return this;
	}
	
	/**
	 * 获得 执行过程<br>
	 * 执行过程
	 * @return 执行过程
	*/
	public String getProcessContent() {
		return processContent;
	}
	
	/**
	 * 设置 执行过程
	 * @param processContent 执行过程
	 * @return 当前对象
	*/
	public RepairOrderProcess setProcessContent(String processContent) {
		this.processContent=processContent;
		return this;
	}
	
	/**
	 * 获得 操作时间<br>
	 * 操作时间
	 * @return 操作时间
	*/
	public Date getRcdTime() {
		return rcdTime;
	}
	
	/**
	 * 设置 操作时间
	 * @param rcdTime 操作时间
	 * @return 当前对象
	*/
	public RepairOrderProcess setRcdTime(Date rcdTime) {
		this.rcdTime=rcdTime;
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
	public RepairOrderProcess setNotes(String notes) {
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
	public RepairOrderProcess setCreateBy(String createBy) {
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
	public RepairOrderProcess setCreateTime(Date createTime) {
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
	public RepairOrderProcess setUpdateBy(String updateBy) {
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
	public RepairOrderProcess setUpdateTime(Date updateTime) {
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
	public RepairOrderProcess setDeleted(Integer deleted) {
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
	public RepairOrderProcess setDeleted(Boolean deletedBool) {
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
	public RepairOrderProcess setDeleteBy(String deleteBy) {
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
	public RepairOrderProcess setDeleteTime(Date deleteTime) {
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
	public RepairOrderProcess setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return RepairOrderProcess , 转换好的 RepairOrderProcess 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RepairOrderProcess , 转换好的 PoJo 对象
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
	public RepairOrderProcess clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public RepairOrderProcess duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.RepairOrderProcessMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.RepairOrderProcessMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setOrderId(this.getOrderId());
		inst.setActId(this.getActId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserName(this.getUserName());
		inst.setUserId(this.getUserId());
		inst.setProcessContent(this.getProcessContent());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setRcdTime(this.getRcdTime());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public RepairOrderProcess clone(boolean deep) {
		return EntityContext.clone(RepairOrderProcess.class,this,deep);
	}

	/**
	 * 将 Map 转换成 RepairOrderProcess
	 * @param repairOrderProcessMap 包含实体信息的 Map 对象
	 * @return RepairOrderProcess , 转换好的的 RepairOrderProcess 对象
	*/
	@Transient
	public static RepairOrderProcess createFrom(Map<String,Object> repairOrderProcessMap) {
		if(repairOrderProcessMap==null) return null;
		RepairOrderProcess po = create();
		EntityContext.copyProperties(po,repairOrderProcessMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 RepairOrderProcess
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RepairOrderProcess , 转换好的的 RepairOrderProcess 对象
	*/
	@Transient
	public static RepairOrderProcess createFrom(Object pojo) {
		if(pojo==null) return null;
		RepairOrderProcess po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 RepairOrderProcess，等同于 new
	 * @return RepairOrderProcess 对象
	*/
	@Transient
	public static RepairOrderProcess create() {
		return new com.dt.platform.domain.eam.meta.RepairOrderProcessMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(RepairOrderProcessMeta.NOTES)));
			this.setOrderId(DataParser.parse(String.class, map.get(RepairOrderProcessMeta.ORDER_ID)));
			this.setActId(DataParser.parse(String.class, map.get(RepairOrderProcessMeta.ACT_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(RepairOrderProcessMeta.UPDATE_TIME)));
			this.setUserName(DataParser.parse(String.class, map.get(RepairOrderProcessMeta.USER_NAME)));
			this.setUserId(DataParser.parse(String.class, map.get(RepairOrderProcessMeta.USER_ID)));
			this.setProcessContent(DataParser.parse(String.class, map.get(RepairOrderProcessMeta.PROCESS_CONTENT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(RepairOrderProcessMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(RepairOrderProcessMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(RepairOrderProcessMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(RepairOrderProcessMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(RepairOrderProcessMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(RepairOrderProcessMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(RepairOrderProcessMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(RepairOrderProcessMeta.ID)));
			this.setRcdTime(DataParser.parse(Date.class, map.get(RepairOrderProcessMeta.RCD_TIME)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(RepairOrderProcessMeta.NOTES));
				this.setOrderId( (String)map.get(RepairOrderProcessMeta.ORDER_ID));
				this.setActId( (String)map.get(RepairOrderProcessMeta.ACT_ID));
				this.setUpdateTime( (Date)map.get(RepairOrderProcessMeta.UPDATE_TIME));
				this.setUserName( (String)map.get(RepairOrderProcessMeta.USER_NAME));
				this.setUserId( (String)map.get(RepairOrderProcessMeta.USER_ID));
				this.setProcessContent( (String)map.get(RepairOrderProcessMeta.PROCESS_CONTENT));
				this.setVersion( (Integer)map.get(RepairOrderProcessMeta.VERSION));
				this.setCreateBy( (String)map.get(RepairOrderProcessMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(RepairOrderProcessMeta.DELETED));
				this.setCreateTime( (Date)map.get(RepairOrderProcessMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(RepairOrderProcessMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(RepairOrderProcessMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(RepairOrderProcessMeta.DELETE_BY));
				this.setId( (String)map.get(RepairOrderProcessMeta.ID));
				this.setRcdTime( (Date)map.get(RepairOrderProcessMeta.RCD_TIME));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(RepairOrderProcessMeta.NOTES)));
			this.setOrderId(DataParser.parse(String.class, r.getValue(RepairOrderProcessMeta.ORDER_ID)));
			this.setActId(DataParser.parse(String.class, r.getValue(RepairOrderProcessMeta.ACT_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(RepairOrderProcessMeta.UPDATE_TIME)));
			this.setUserName(DataParser.parse(String.class, r.getValue(RepairOrderProcessMeta.USER_NAME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(RepairOrderProcessMeta.USER_ID)));
			this.setProcessContent(DataParser.parse(String.class, r.getValue(RepairOrderProcessMeta.PROCESS_CONTENT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(RepairOrderProcessMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(RepairOrderProcessMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(RepairOrderProcessMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(RepairOrderProcessMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(RepairOrderProcessMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(RepairOrderProcessMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(RepairOrderProcessMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(RepairOrderProcessMeta.ID)));
			this.setRcdTime(DataParser.parse(Date.class, r.getValue(RepairOrderProcessMeta.RCD_TIME)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(RepairOrderProcessMeta.NOTES));
				this.setOrderId( (String)r.getValue(RepairOrderProcessMeta.ORDER_ID));
				this.setActId( (String)r.getValue(RepairOrderProcessMeta.ACT_ID));
				this.setUpdateTime( (Date)r.getValue(RepairOrderProcessMeta.UPDATE_TIME));
				this.setUserName( (String)r.getValue(RepairOrderProcessMeta.USER_NAME));
				this.setUserId( (String)r.getValue(RepairOrderProcessMeta.USER_ID));
				this.setProcessContent( (String)r.getValue(RepairOrderProcessMeta.PROCESS_CONTENT));
				this.setVersion( (Integer)r.getValue(RepairOrderProcessMeta.VERSION));
				this.setCreateBy( (String)r.getValue(RepairOrderProcessMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(RepairOrderProcessMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(RepairOrderProcessMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(RepairOrderProcessMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(RepairOrderProcessMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(RepairOrderProcessMeta.DELETE_BY));
				this.setId( (String)r.getValue(RepairOrderProcessMeta.ID));
				this.setRcdTime( (Date)r.getValue(RepairOrderProcessMeta.RCD_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}