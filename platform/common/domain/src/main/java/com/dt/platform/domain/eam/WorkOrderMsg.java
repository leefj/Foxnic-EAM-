package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_WORK_ORDER_MSG;
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
import com.dt.platform.domain.eam.meta.WorkOrderMsgMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 工单消息
 * <p>工单消息 , 数据表 eam_work_order_msg 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-14 10:36:55
 * @sign 03C40421C1E136F45B46823E3F24BF7C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_work_order_msg")
@ApiModel(description = "工单消息 ; 工单消息 , 数据表 eam_work_order_msg 的PO类型")
public class WorkOrderMsg extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_WORK_ORDER_MSG.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 工单：工单
	*/
	@ApiModelProperty(required = false,value="工单" , notes = "工单")
	private String orderId;
	
	/**
	 * 问题：问题
	*/
	@ApiModelProperty(required = false,value="问题" , notes = "问题")
	private String content;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String fileIds;
	
	/**
	 * 用户：用户
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "用户")
	private String userId;
	
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
	 * user：user
	*/
	@ApiModelProperty(required = false,value="user" , notes = "user")
	private Employee user;
	
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
	public WorkOrderMsg setId(String id) {
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
	public WorkOrderMsg setStatus(String status) {
		this.status=status;
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
	public WorkOrderMsg setOrderId(String orderId) {
		this.orderId=orderId;
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
	public WorkOrderMsg setContent(String content) {
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
	public WorkOrderMsg setFileIds(String fileIds) {
		this.fileIds=fileIds;
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
	public WorkOrderMsg setUserId(String userId) {
		this.userId=userId;
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
	public WorkOrderMsg setCreateBy(String createBy) {
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
	public WorkOrderMsg setCreateTime(Date createTime) {
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
	public WorkOrderMsg setUpdateBy(String updateBy) {
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
	public WorkOrderMsg setUpdateTime(Date updateTime) {
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
	public WorkOrderMsg setDeleted(Integer deleted) {
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
	public WorkOrderMsg setDeleted(Boolean deletedBool) {
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
	public WorkOrderMsg setDeleteBy(String deleteBy) {
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
	public WorkOrderMsg setDeleteTime(Date deleteTime) {
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
	public WorkOrderMsg setVersion(Integer version) {
		this.version=version;
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
	public WorkOrderMsg setUser(Employee user) {
		this.user=user;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return WorkOrderMsg , 转换好的 WorkOrderMsg 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return WorkOrderMsg , 转换好的 PoJo 对象
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
	public WorkOrderMsg clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public WorkOrderMsg duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.WorkOrderMsgMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.WorkOrderMsgMeta.$$proxy$$();
		inst.setOrderId(this.getOrderId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setFileIds(this.getFileIds());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setUser(this.getUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public WorkOrderMsg clone(boolean deep) {
		return EntityContext.clone(WorkOrderMsg.class,this,deep);
	}

	/**
	 * 将 Map 转换成 WorkOrderMsg
	 * @param workOrderMsgMap 包含实体信息的 Map 对象
	 * @return WorkOrderMsg , 转换好的的 WorkOrderMsg 对象
	*/
	@Transient
	public static WorkOrderMsg createFrom(Map<String,Object> workOrderMsgMap) {
		if(workOrderMsgMap==null) return null;
		WorkOrderMsg po = create();
		EntityContext.copyProperties(po,workOrderMsgMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 WorkOrderMsg
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return WorkOrderMsg , 转换好的的 WorkOrderMsg 对象
	*/
	@Transient
	public static WorkOrderMsg createFrom(Object pojo) {
		if(pojo==null) return null;
		WorkOrderMsg po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 WorkOrderMsg，等同于 new
	 * @return WorkOrderMsg 对象
	*/
	@Transient
	public static WorkOrderMsg create() {
		return new com.dt.platform.domain.eam.meta.WorkOrderMsgMeta.$$proxy$$();
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
			this.setOrderId(DataParser.parse(String.class, map.get(WorkOrderMsgMeta.ORDER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(WorkOrderMsgMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(WorkOrderMsgMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(WorkOrderMsgMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(WorkOrderMsgMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(WorkOrderMsgMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(WorkOrderMsgMeta.DELETED)));
			this.setFileIds(DataParser.parse(String.class, map.get(WorkOrderMsgMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(WorkOrderMsgMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(WorkOrderMsgMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(WorkOrderMsgMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(WorkOrderMsgMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(WorkOrderMsgMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(WorkOrderMsgMeta.STATUS)));
			// others
			this.setUser(DataParser.parse(Employee.class, map.get(WorkOrderMsgMeta.USER)));
			return true;
		} else {
			try {
				this.setOrderId( (String)map.get(WorkOrderMsgMeta.ORDER_ID));
				this.setUpdateTime( (Date)map.get(WorkOrderMsgMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(WorkOrderMsgMeta.USER_ID));
				this.setVersion( (Integer)map.get(WorkOrderMsgMeta.VERSION));
				this.setContent( (String)map.get(WorkOrderMsgMeta.CONTENT));
				this.setCreateBy( (String)map.get(WorkOrderMsgMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(WorkOrderMsgMeta.DELETED));
				this.setFileIds( (String)map.get(WorkOrderMsgMeta.FILE_IDS));
				this.setCreateTime( (Date)map.get(WorkOrderMsgMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(WorkOrderMsgMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(WorkOrderMsgMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(WorkOrderMsgMeta.DELETE_BY));
				this.setId( (String)map.get(WorkOrderMsgMeta.ID));
				this.setStatus( (String)map.get(WorkOrderMsgMeta.STATUS));
				// others
				this.setUser( (Employee)map.get(WorkOrderMsgMeta.USER));
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
			this.setOrderId(DataParser.parse(String.class, r.getValue(WorkOrderMsgMeta.ORDER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(WorkOrderMsgMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(WorkOrderMsgMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(WorkOrderMsgMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(WorkOrderMsgMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(WorkOrderMsgMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(WorkOrderMsgMeta.DELETED)));
			this.setFileIds(DataParser.parse(String.class, r.getValue(WorkOrderMsgMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(WorkOrderMsgMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(WorkOrderMsgMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(WorkOrderMsgMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(WorkOrderMsgMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(WorkOrderMsgMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(WorkOrderMsgMeta.STATUS)));
			return true;
		} else {
			try {
				this.setOrderId( (String)r.getValue(WorkOrderMsgMeta.ORDER_ID));
				this.setUpdateTime( (Date)r.getValue(WorkOrderMsgMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(WorkOrderMsgMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(WorkOrderMsgMeta.VERSION));
				this.setContent( (String)r.getValue(WorkOrderMsgMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(WorkOrderMsgMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(WorkOrderMsgMeta.DELETED));
				this.setFileIds( (String)r.getValue(WorkOrderMsgMeta.FILE_IDS));
				this.setCreateTime( (Date)r.getValue(WorkOrderMsgMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(WorkOrderMsgMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(WorkOrderMsgMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(WorkOrderMsgMeta.DELETE_BY));
				this.setId( (String)r.getValue(WorkOrderMsgMeta.ID));
				this.setStatus( (String)r.getValue(WorkOrderMsgMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}