package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_WORK_ORDER;
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
import com.dt.platform.domain.eam.meta.WorkOrderMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 问题工单
 * <p>问题工单 , 数据表 eam_work_order 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-14 10:33:12
 * @sign 4039727C9DEAD76DB9CB37359D65C1F0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_work_order")
@ApiModel(description = "问题工单 ; 问题工单 , 数据表 eam_work_order 的PO类型")
public class WorkOrder extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_WORK_ORDER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "798656224722681856")
	private String id;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "cancel")
	private String status;
	
	/**
	 * 标题：标题
	*/
	@ApiModelProperty(required = false,value="标题" , notes = "标题" , example = "kj")
	private String title;
	
	/**
	 * 问题：问题
	*/
	@ApiModelProperty(required = false,value="问题" , notes = "问题" , example = "jh")
	private String content;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String fileIds;
	
	/**
	 * 联系方式：联系方式
	*/
	@ApiModelProperty(required = false,value="联系方式" , notes = "联系方式" , example = "h")
	private String contactInformation;
	
	/**
	 * 操作人：操作人
	*/
	@ApiModelProperty(required = false,value="操作人" , notes = "操作人")
	private String rcdUserId;
	
	/**
	 * 操作时间：操作时间
	*/
	@ApiModelProperty(required = false,value="操作时间" , notes = "操作时间")
	private Date rcdTime;
	
	/**
	 * 回复时间：回复时间
	*/
	@ApiModelProperty(required = false,value="回复时间" , notes = "回复时间")
	private Date lastTime;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-01-13 08:54:42")
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
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
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
	public WorkOrder setId(String id) {
		this.id=id;
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
	public WorkOrder setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 标题<br>
	 * 标题
	 * @return 标题
	*/
	public String getTitle() {
		return title;
	}
	
	/**
	 * 设置 标题
	 * @param title 标题
	 * @return 当前对象
	*/
	public WorkOrder setTitle(String title) {
		this.title=title;
		return this;
	}
	
	/**
	 * 获得 问题<br>
	 * 问题
	 * @return 问题
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 问题
	 * @param content 问题
	 * @return 当前对象
	*/
	public WorkOrder setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getFileIds() {
		return fileIds;
	}
	
	/**
	 * 设置 附件
	 * @param fileIds 附件
	 * @return 当前对象
	*/
	public WorkOrder setFileIds(String fileIds) {
		this.fileIds=fileIds;
		return this;
	}
	
	/**
	 * 获得 联系方式<br>
	 * 联系方式
	 * @return 联系方式
	*/
	public String getContactInformation() {
		return contactInformation;
	}
	
	/**
	 * 设置 联系方式
	 * @param contactInformation 联系方式
	 * @return 当前对象
	*/
	public WorkOrder setContactInformation(String contactInformation) {
		this.contactInformation=contactInformation;
		return this;
	}
	
	/**
	 * 获得 操作人<br>
	 * 操作人
	 * @return 操作人
	*/
	public String getRcdUserId() {
		return rcdUserId;
	}
	
	/**
	 * 设置 操作人
	 * @param rcdUserId 操作人
	 * @return 当前对象
	*/
	public WorkOrder setRcdUserId(String rcdUserId) {
		this.rcdUserId=rcdUserId;
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
	public WorkOrder setRcdTime(Date rcdTime) {
		this.rcdTime=rcdTime;
		return this;
	}
	
	/**
	 * 获得 回复时间<br>
	 * 回复时间
	 * @return 回复时间
	*/
	public Date getLastTime() {
		return lastTime;
	}
	
	/**
	 * 设置 回复时间
	 * @param lastTime 回复时间
	 * @return 当前对象
	*/
	public WorkOrder setLastTime(Date lastTime) {
		this.lastTime=lastTime;
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
	public WorkOrder setCreateBy(String createBy) {
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
	public WorkOrder setCreateTime(Date createTime) {
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
	public WorkOrder setUpdateBy(String updateBy) {
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
	public WorkOrder setUpdateTime(Date updateTime) {
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
	public WorkOrder setDeleted(Integer deleted) {
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
	public WorkOrder setDeleted(Boolean deletedBool) {
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
	public WorkOrder setDeleteBy(String deleteBy) {
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
	public WorkOrder setDeleteTime(Date deleteTime) {
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
	public WorkOrder setVersion(Integer version) {
		this.version=version;
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
	public WorkOrder setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return WorkOrder , 转换好的 WorkOrder 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return WorkOrder , 转换好的 PoJo 对象
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
	public WorkOrder clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public WorkOrder duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.WorkOrderMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.WorkOrderMeta.$$proxy$$();
		inst.setLastTime(this.getLastTime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setTitle(this.getTitle());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setContactInformation(this.getContactInformation());
		inst.setDeleted(this.getDeleted());
		inst.setRcdUserId(this.getRcdUserId());
		inst.setFileIds(this.getFileIds());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		inst.setRcdTime(this.getRcdTime());
		if(all) {
			inst.setOriginator(this.getOriginator());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public WorkOrder clone(boolean deep) {
		return EntityContext.clone(WorkOrder.class,this,deep);
	}

	/**
	 * 将 Map 转换成 WorkOrder
	 * @param workOrderMap 包含实体信息的 Map 对象
	 * @return WorkOrder , 转换好的的 WorkOrder 对象
	*/
	@Transient
	public static WorkOrder createFrom(Map<String,Object> workOrderMap) {
		if(workOrderMap==null) return null;
		WorkOrder po = create();
		EntityContext.copyProperties(po,workOrderMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 WorkOrder
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return WorkOrder , 转换好的的 WorkOrder 对象
	*/
	@Transient
	public static WorkOrder createFrom(Object pojo) {
		if(pojo==null) return null;
		WorkOrder po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 WorkOrder，等同于 new
	 * @return WorkOrder 对象
	*/
	@Transient
	public static WorkOrder create() {
		return new com.dt.platform.domain.eam.meta.WorkOrderMeta.$$proxy$$();
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
			this.setLastTime(DataParser.parse(Date.class, map.get(WorkOrderMeta.LAST_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(WorkOrderMeta.UPDATE_TIME)));
			this.setTitle(DataParser.parse(String.class, map.get(WorkOrderMeta.TITLE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(WorkOrderMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(WorkOrderMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(WorkOrderMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, map.get(WorkOrderMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(WorkOrderMeta.DELETED)));
			this.setRcdUserId(DataParser.parse(String.class, map.get(WorkOrderMeta.RCD_USER_ID)));
			this.setFileIds(DataParser.parse(String.class, map.get(WorkOrderMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(WorkOrderMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(WorkOrderMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(WorkOrderMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(WorkOrderMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(WorkOrderMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(WorkOrderMeta.STATUS)));
			this.setRcdTime(DataParser.parse(Date.class, map.get(WorkOrderMeta.RCD_TIME)));
			// others
			this.setOriginator(DataParser.parse(Employee.class, map.get(WorkOrderMeta.ORIGINATOR)));
			return true;
		} else {
			try {
				this.setLastTime( (Date)map.get(WorkOrderMeta.LAST_TIME));
				this.setUpdateTime( (Date)map.get(WorkOrderMeta.UPDATE_TIME));
				this.setTitle( (String)map.get(WorkOrderMeta.TITLE));
				this.setVersion( (Integer)map.get(WorkOrderMeta.VERSION));
				this.setContent( (String)map.get(WorkOrderMeta.CONTENT));
				this.setCreateBy( (String)map.get(WorkOrderMeta.CREATE_BY));
				this.setContactInformation( (String)map.get(WorkOrderMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)map.get(WorkOrderMeta.DELETED));
				this.setRcdUserId( (String)map.get(WorkOrderMeta.RCD_USER_ID));
				this.setFileIds( (String)map.get(WorkOrderMeta.FILE_IDS));
				this.setCreateTime( (Date)map.get(WorkOrderMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(WorkOrderMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(WorkOrderMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(WorkOrderMeta.DELETE_BY));
				this.setId( (String)map.get(WorkOrderMeta.ID));
				this.setStatus( (String)map.get(WorkOrderMeta.STATUS));
				this.setRcdTime( (Date)map.get(WorkOrderMeta.RCD_TIME));
				// others
				this.setOriginator( (Employee)map.get(WorkOrderMeta.ORIGINATOR));
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
			this.setLastTime(DataParser.parse(Date.class, r.getValue(WorkOrderMeta.LAST_TIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(WorkOrderMeta.UPDATE_TIME)));
			this.setTitle(DataParser.parse(String.class, r.getValue(WorkOrderMeta.TITLE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(WorkOrderMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(WorkOrderMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(WorkOrderMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, r.getValue(WorkOrderMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(WorkOrderMeta.DELETED)));
			this.setRcdUserId(DataParser.parse(String.class, r.getValue(WorkOrderMeta.RCD_USER_ID)));
			this.setFileIds(DataParser.parse(String.class, r.getValue(WorkOrderMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(WorkOrderMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(WorkOrderMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(WorkOrderMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(WorkOrderMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(WorkOrderMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(WorkOrderMeta.STATUS)));
			this.setRcdTime(DataParser.parse(Date.class, r.getValue(WorkOrderMeta.RCD_TIME)));
			return true;
		} else {
			try {
				this.setLastTime( (Date)r.getValue(WorkOrderMeta.LAST_TIME));
				this.setUpdateTime( (Date)r.getValue(WorkOrderMeta.UPDATE_TIME));
				this.setTitle( (String)r.getValue(WorkOrderMeta.TITLE));
				this.setVersion( (Integer)r.getValue(WorkOrderMeta.VERSION));
				this.setContent( (String)r.getValue(WorkOrderMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(WorkOrderMeta.CREATE_BY));
				this.setContactInformation( (String)r.getValue(WorkOrderMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)r.getValue(WorkOrderMeta.DELETED));
				this.setRcdUserId( (String)r.getValue(WorkOrderMeta.RCD_USER_ID));
				this.setFileIds( (String)r.getValue(WorkOrderMeta.FILE_IDS));
				this.setCreateTime( (Date)r.getValue(WorkOrderMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(WorkOrderMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(WorkOrderMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(WorkOrderMeta.DELETE_BY));
				this.setId( (String)r.getValue(WorkOrderMeta.ID));
				this.setStatus( (String)r.getValue(WorkOrderMeta.STATUS));
				this.setRcdTime( (Date)r.getValue(WorkOrderMeta.RCD_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}