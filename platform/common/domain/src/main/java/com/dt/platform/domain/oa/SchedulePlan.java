package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_SCHEDULE_PLAN;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.oa.meta.SchedulePlanMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 日程安排
 * <p>日程安排 , 数据表 oa_schedule_plan 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-26 06:47:16
 * @sign 63DDF9775CC1BC19895B6DB05C9A4AD3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_schedule_plan")
@ApiModel(description = "日程安排 ; 日程安排 , 数据表 oa_schedule_plan 的PO类型")
public class SchedulePlan extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_SCHEDULE_PLAN.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID" , example = "725047309544456192")
	private String id;
	
	/**
	 * 优先级：优先级
	*/
	@ApiModelProperty(required = false,value="优先级" , notes = "优先级" , example = "important")
	private String rank;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间" , example = "2023-06-07 12:00:00")
	private Date fTime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间" , example = "2023-06-19 12:01:00")
	private Date tTime;
	
	/**
	 * 提醒：提醒
	*/
	@ApiModelProperty(required = false,value="提醒" , notes = "提醒" , example = "time_5")
	private String remind;
	
	/**
	 * 提醒时间：提醒时间
	*/
	@ApiModelProperty(required = false,value="提醒时间" , notes = "提醒时间")
	private Date remindTime;
	
	/**
	 * 日程内容：日程内容
	*/
	@ApiModelProperty(required = false,value="日程内容" , notes = "日程内容" , example = "1212")
	private String content;
	
	/**
	 * 详细描述：详细描述
	*/
	@ApiModelProperty(required = false,value="详细描述" , notes = "详细描述" , example = "kjn")
	private String detail;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "12")
	private String notes;
	
	/**
	 * 用户：用户
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "用户")
	private String userId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-06-24 05:59:09")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-06-25 10:32:00")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "4")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * scheduleRemind：scheduleRemind
	*/
	@ApiModelProperty(required = false,value="scheduleRemind" , notes = "scheduleRemind")
	private DictItem scheduleRemind;
	
	/**
	 * 获得 ID<br>
	 * ID
	 * @return ID
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 ID
	 * @param id ID
	 * @return 当前对象
	*/
	public SchedulePlan setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 优先级<br>
	 * 优先级
	 * @return 优先级
	*/
	public String getRank() {
		return rank;
	}
	
	/**
	 * 设置 优先级
	 * @param rank 优先级
	 * @return 当前对象
	*/
	public SchedulePlan setRank(String rank) {
		this.rank=rank;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getFTime() {
		return fTime;
	}
	
	/**
	 * 设置 开始时间
	 * @param fTime 开始时间
	 * @return 当前对象
	*/
	public SchedulePlan setFTime(Date fTime) {
		this.fTime=fTime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getTTime() {
		return tTime;
	}
	
	/**
	 * 设置 结束时间
	 * @param tTime 结束时间
	 * @return 当前对象
	*/
	public SchedulePlan setTTime(Date tTime) {
		this.tTime=tTime;
		return this;
	}
	
	/**
	 * 获得 提醒<br>
	 * 提醒
	 * @return 提醒
	*/
	public String getRemind() {
		return remind;
	}
	
	/**
	 * 设置 提醒
	 * @param remind 提醒
	 * @return 当前对象
	*/
	public SchedulePlan setRemind(String remind) {
		this.remind=remind;
		return this;
	}
	
	/**
	 * 获得 提醒时间<br>
	 * 提醒时间
	 * @return 提醒时间
	*/
	public Date getRemindTime() {
		return remindTime;
	}
	
	/**
	 * 设置 提醒时间
	 * @param remindTime 提醒时间
	 * @return 当前对象
	*/
	public SchedulePlan setRemindTime(Date remindTime) {
		this.remindTime=remindTime;
		return this;
	}
	
	/**
	 * 获得 日程内容<br>
	 * 日程内容
	 * @return 日程内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 日程内容
	 * @param content 日程内容
	 * @return 当前对象
	*/
	public SchedulePlan setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 详细描述<br>
	 * 详细描述
	 * @return 详细描述
	*/
	public String getDetail() {
		return detail;
	}
	
	/**
	 * 设置 详细描述
	 * @param detail 详细描述
	 * @return 当前对象
	*/
	public SchedulePlan setDetail(String detail) {
		this.detail=detail;
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
	public SchedulePlan setNotes(String notes) {
		this.notes=notes;
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
	public SchedulePlan setUserId(String userId) {
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
	public SchedulePlan setCreateBy(String createBy) {
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
	public SchedulePlan setCreateTime(Date createTime) {
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
	public SchedulePlan setUpdateBy(String updateBy) {
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
	public SchedulePlan setUpdateTime(Date updateTime) {
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
	public SchedulePlan setDeleted(Integer deleted) {
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
	public SchedulePlan setDeleted(Boolean deletedBool) {
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
	public SchedulePlan setDeleteBy(String deleteBy) {
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
	public SchedulePlan setDeleteTime(Date deleteTime) {
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
	public SchedulePlan setVersion(Integer version) {
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
	public SchedulePlan setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 scheduleRemind<br>
	 * scheduleRemind
	 * @return scheduleRemind
	*/
	public DictItem getScheduleRemind() {
		return scheduleRemind;
	}
	
	/**
	 * 设置 scheduleRemind
	 * @param scheduleRemind scheduleRemind
	 * @return 当前对象
	*/
	public SchedulePlan setScheduleRemind(DictItem scheduleRemind) {
		this.scheduleRemind=scheduleRemind;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SchedulePlan , 转换好的 SchedulePlan 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SchedulePlan , 转换好的 PoJo 对象
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
	public SchedulePlan clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SchedulePlan duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.SchedulePlanMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.SchedulePlanMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setTTime(this.getTTime());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setRemind(this.getRemind());
		inst.setRemindTime(this.getRemindTime());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setFTime(this.getFTime());
		inst.setTenantId(this.getTenantId());
		inst.setRank(this.getRank());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setDetail(this.getDetail());
		if(all) {
			inst.setScheduleRemind(this.getScheduleRemind());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SchedulePlan clone(boolean deep) {
		return EntityContext.clone(SchedulePlan.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SchedulePlan
	 * @param schedulePlanMap 包含实体信息的 Map 对象
	 * @return SchedulePlan , 转换好的的 SchedulePlan 对象
	*/
	@Transient
	public static SchedulePlan createFrom(Map<String,Object> schedulePlanMap) {
		if(schedulePlanMap==null) return null;
		SchedulePlan po = create();
		EntityContext.copyProperties(po,schedulePlanMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 SchedulePlan
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SchedulePlan , 转换好的的 SchedulePlan 对象
	*/
	@Transient
	public static SchedulePlan createFrom(Object pojo) {
		if(pojo==null) return null;
		SchedulePlan po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 SchedulePlan，等同于 new
	 * @return SchedulePlan 对象
	*/
	@Transient
	public static SchedulePlan create() {
		return new com.dt.platform.domain.oa.meta.SchedulePlanMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(SchedulePlanMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SchedulePlanMeta.UPDATE_TIME)));
			this.setTTime(DataParser.parse(Date.class, map.get(SchedulePlanMeta.T_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(SchedulePlanMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SchedulePlanMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(SchedulePlanMeta.CONTENT)));
			this.setRemind(DataParser.parse(String.class, map.get(SchedulePlanMeta.REMIND)));
			this.setRemindTime(DataParser.parse(Date.class, map.get(SchedulePlanMeta.REMIND_TIME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SchedulePlanMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SchedulePlanMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SchedulePlanMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SchedulePlanMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SchedulePlanMeta.DELETE_TIME)));
			this.setFTime(DataParser.parse(Date.class, map.get(SchedulePlanMeta.F_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(SchedulePlanMeta.TENANT_ID)));
			this.setRank(DataParser.parse(String.class, map.get(SchedulePlanMeta.RANK)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SchedulePlanMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(SchedulePlanMeta.ID)));
			this.setDetail(DataParser.parse(String.class, map.get(SchedulePlanMeta.DETAIL)));
			// others
			this.setScheduleRemind(DataParser.parse(DictItem.class, map.get(SchedulePlanMeta.SCHEDULE_REMIND)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(SchedulePlanMeta.NOTES));
				this.setUpdateTime( (Date)map.get(SchedulePlanMeta.UPDATE_TIME));
				this.setTTime( (Date)map.get(SchedulePlanMeta.T_TIME));
				this.setUserId( (String)map.get(SchedulePlanMeta.USER_ID));
				this.setVersion( (Integer)map.get(SchedulePlanMeta.VERSION));
				this.setContent( (String)map.get(SchedulePlanMeta.CONTENT));
				this.setRemind( (String)map.get(SchedulePlanMeta.REMIND));
				this.setRemindTime( (Date)map.get(SchedulePlanMeta.REMIND_TIME));
				this.setCreateBy( (String)map.get(SchedulePlanMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(SchedulePlanMeta.DELETED));
				this.setCreateTime( (Date)map.get(SchedulePlanMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SchedulePlanMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SchedulePlanMeta.DELETE_TIME));
				this.setFTime( (Date)map.get(SchedulePlanMeta.F_TIME));
				this.setTenantId( (String)map.get(SchedulePlanMeta.TENANT_ID));
				this.setRank( (String)map.get(SchedulePlanMeta.RANK));
				this.setDeleteBy( (String)map.get(SchedulePlanMeta.DELETE_BY));
				this.setId( (String)map.get(SchedulePlanMeta.ID));
				this.setDetail( (String)map.get(SchedulePlanMeta.DETAIL));
				// others
				this.setScheduleRemind( (DictItem)map.get(SchedulePlanMeta.SCHEDULE_REMIND));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(SchedulePlanMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SchedulePlanMeta.UPDATE_TIME)));
			this.setTTime(DataParser.parse(Date.class, r.getValue(SchedulePlanMeta.T_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(SchedulePlanMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SchedulePlanMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(SchedulePlanMeta.CONTENT)));
			this.setRemind(DataParser.parse(String.class, r.getValue(SchedulePlanMeta.REMIND)));
			this.setRemindTime(DataParser.parse(Date.class, r.getValue(SchedulePlanMeta.REMIND_TIME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SchedulePlanMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SchedulePlanMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SchedulePlanMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SchedulePlanMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SchedulePlanMeta.DELETE_TIME)));
			this.setFTime(DataParser.parse(Date.class, r.getValue(SchedulePlanMeta.F_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SchedulePlanMeta.TENANT_ID)));
			this.setRank(DataParser.parse(String.class, r.getValue(SchedulePlanMeta.RANK)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SchedulePlanMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(SchedulePlanMeta.ID)));
			this.setDetail(DataParser.parse(String.class, r.getValue(SchedulePlanMeta.DETAIL)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(SchedulePlanMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(SchedulePlanMeta.UPDATE_TIME));
				this.setTTime( (Date)r.getValue(SchedulePlanMeta.T_TIME));
				this.setUserId( (String)r.getValue(SchedulePlanMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(SchedulePlanMeta.VERSION));
				this.setContent( (String)r.getValue(SchedulePlanMeta.CONTENT));
				this.setRemind( (String)r.getValue(SchedulePlanMeta.REMIND));
				this.setRemindTime( (Date)r.getValue(SchedulePlanMeta.REMIND_TIME));
				this.setCreateBy( (String)r.getValue(SchedulePlanMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(SchedulePlanMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(SchedulePlanMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SchedulePlanMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SchedulePlanMeta.DELETE_TIME));
				this.setFTime( (Date)r.getValue(SchedulePlanMeta.F_TIME));
				this.setTenantId( (String)r.getValue(SchedulePlanMeta.TENANT_ID));
				this.setRank( (String)r.getValue(SchedulePlanMeta.RANK));
				this.setDeleteBy( (String)r.getValue(SchedulePlanMeta.DELETE_BY));
				this.setId( (String)r.getValue(SchedulePlanMeta.ID));
				this.setDetail( (String)r.getValue(SchedulePlanMeta.DETAIL));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}