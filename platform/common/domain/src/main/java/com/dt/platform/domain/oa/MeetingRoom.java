package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_MEETING_ROOM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.oa.meta.MeetingRoomMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 会议室
 * <p>会议室 , 数据表 oa_meeting_room 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-28 22:10:52
 * @sign 94E02EE7631925FE40E03C048C03D2AB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_meeting_room")
@ApiModel(description = "会议室 ; 会议室 , 数据表 oa_meeting_room 的PO类型")
public class MeetingRoom extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_MEETING_ROOM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "726536153796182016")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "会议室一")
	private String name;
	
	/**
	 * 容纳人数：容纳人数
	*/
	@ApiModelProperty(required = false,value="容纳人数" , notes = "容纳人数")
	private Integer personNumber;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "available")
	private String status;
	
	/**
	 * 位置：位置
	*/
	@ApiModelProperty(required = false,value="位置" , notes = "位置" , example = "726535420753477632")
	private String positionId;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-06-28 08:35:17")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * meetingRoomPosition：meetingRoomPosition
	*/
	@ApiModelProperty(required = false,value="meetingRoomPosition" , notes = "meetingRoomPosition")
	private MeetingRoomPosition meetingRoomPosition;
	
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
	public MeetingRoom setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public MeetingRoom setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 容纳人数<br>
	 * 容纳人数
	 * @return 容纳人数
	*/
	public Integer getPersonNumber() {
		return personNumber;
	}
	
	/**
	 * 设置 容纳人数
	 * @param personNumber 容纳人数
	 * @return 当前对象
	*/
	public MeetingRoom setPersonNumber(Integer personNumber) {
		this.personNumber=personNumber;
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
	public MeetingRoom setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 位置<br>
	 * 位置
	 * @return 位置
	*/
	public String getPositionId() {
		return positionId;
	}
	
	/**
	 * 设置 位置
	 * @param positionId 位置
	 * @return 当前对象
	*/
	public MeetingRoom setPositionId(String positionId) {
		this.positionId=positionId;
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
	public MeetingRoom setNotes(String notes) {
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
	public MeetingRoom setCreateBy(String createBy) {
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
	public MeetingRoom setCreateTime(Date createTime) {
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
	public MeetingRoom setUpdateBy(String updateBy) {
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
	public MeetingRoom setUpdateTime(Date updateTime) {
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
	public MeetingRoom setDeleted(Integer deleted) {
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
	public MeetingRoom setDeleted(Boolean deletedBool) {
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
	public MeetingRoom setDeleteBy(String deleteBy) {
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
	public MeetingRoom setDeleteTime(Date deleteTime) {
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
	public MeetingRoom setVersion(Integer version) {
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
	public MeetingRoom setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 meetingRoomPosition<br>
	 * meetingRoomPosition
	 * @return meetingRoomPosition
	*/
	public MeetingRoomPosition getMeetingRoomPosition() {
		return meetingRoomPosition;
	}
	
	/**
	 * 设置 meetingRoomPosition
	 * @param meetingRoomPosition meetingRoomPosition
	 * @return 当前对象
	*/
	public MeetingRoom setMeetingRoomPosition(MeetingRoomPosition meetingRoomPosition) {
		this.meetingRoomPosition=meetingRoomPosition;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MeetingRoom , 转换好的 MeetingRoom 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MeetingRoom , 转换好的 PoJo 对象
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
	public MeetingRoom clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MeetingRoom duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.MeetingRoomMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.MeetingRoomMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setPersonNumber(this.getPersonNumber());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPositionId(this.getPositionId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setMeetingRoomPosition(this.getMeetingRoomPosition());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MeetingRoom clone(boolean deep) {
		return EntityContext.clone(MeetingRoom.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MeetingRoom
	 * @param meetingRoomMap 包含实体信息的 Map 对象
	 * @return MeetingRoom , 转换好的的 MeetingRoom 对象
	*/
	@Transient
	public static MeetingRoom createFrom(Map<String,Object> meetingRoomMap) {
		if(meetingRoomMap==null) return null;
		MeetingRoom po = create();
		EntityContext.copyProperties(po,meetingRoomMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 MeetingRoom
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MeetingRoom , 转换好的的 MeetingRoom 对象
	*/
	@Transient
	public static MeetingRoom createFrom(Object pojo) {
		if(pojo==null) return null;
		MeetingRoom po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 MeetingRoom，等同于 new
	 * @return MeetingRoom 对象
	*/
	@Transient
	public static MeetingRoom create() {
		return new com.dt.platform.domain.oa.meta.MeetingRoomMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(MeetingRoomMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MeetingRoomMeta.UPDATE_TIME)));
			this.setPersonNumber(DataParser.parse(Integer.class, map.get(MeetingRoomMeta.PERSON_NUMBER)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MeetingRoomMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MeetingRoomMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MeetingRoomMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, map.get(MeetingRoomMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MeetingRoomMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MeetingRoomMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MeetingRoomMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(MeetingRoomMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(MeetingRoomMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MeetingRoomMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(MeetingRoomMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(MeetingRoomMeta.STATUS)));
			// others
			this.setMeetingRoomPosition(DataParser.parse(MeetingRoomPosition.class, map.get(MeetingRoomMeta.MEETING_ROOM_POSITION)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(MeetingRoomMeta.NOTES));
				this.setUpdateTime( (Date)map.get(MeetingRoomMeta.UPDATE_TIME));
				this.setPersonNumber( (Integer)map.get(MeetingRoomMeta.PERSON_NUMBER));
				this.setVersion( (Integer)map.get(MeetingRoomMeta.VERSION));
				this.setCreateBy( (String)map.get(MeetingRoomMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MeetingRoomMeta.DELETED));
				this.setPositionId( (String)map.get(MeetingRoomMeta.POSITION_ID));
				this.setCreateTime( (Date)map.get(MeetingRoomMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(MeetingRoomMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(MeetingRoomMeta.DELETE_TIME));
				this.setName( (String)map.get(MeetingRoomMeta.NAME));
				this.setTenantId( (String)map.get(MeetingRoomMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(MeetingRoomMeta.DELETE_BY));
				this.setId( (String)map.get(MeetingRoomMeta.ID));
				this.setStatus( (String)map.get(MeetingRoomMeta.STATUS));
				// others
				this.setMeetingRoomPosition( (MeetingRoomPosition)map.get(MeetingRoomMeta.MEETING_ROOM_POSITION));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(MeetingRoomMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MeetingRoomMeta.UPDATE_TIME)));
			this.setPersonNumber(DataParser.parse(Integer.class, r.getValue(MeetingRoomMeta.PERSON_NUMBER)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MeetingRoomMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MeetingRoomMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MeetingRoomMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, r.getValue(MeetingRoomMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MeetingRoomMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MeetingRoomMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MeetingRoomMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(MeetingRoomMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(MeetingRoomMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MeetingRoomMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(MeetingRoomMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(MeetingRoomMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(MeetingRoomMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(MeetingRoomMeta.UPDATE_TIME));
				this.setPersonNumber( (Integer)r.getValue(MeetingRoomMeta.PERSON_NUMBER));
				this.setVersion( (Integer)r.getValue(MeetingRoomMeta.VERSION));
				this.setCreateBy( (String)r.getValue(MeetingRoomMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MeetingRoomMeta.DELETED));
				this.setPositionId( (String)r.getValue(MeetingRoomMeta.POSITION_ID));
				this.setCreateTime( (Date)r.getValue(MeetingRoomMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(MeetingRoomMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(MeetingRoomMeta.DELETE_TIME));
				this.setName( (String)r.getValue(MeetingRoomMeta.NAME));
				this.setTenantId( (String)r.getValue(MeetingRoomMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(MeetingRoomMeta.DELETE_BY));
				this.setId( (String)r.getValue(MeetingRoomMeta.ID));
				this.setStatus( (String)r.getValue(MeetingRoomMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}