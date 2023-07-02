package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_MEETING_ROOM_BOOK_RCD;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.oa.meta.MeetingRoomBookRcdMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 会议室预定
 * <p>会议室预定 , 数据表 oa_meeting_room_book_rcd 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-29 11:22:48
 * @sign 93220BA938D843D703FDD0ED8D355451
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_meeting_room_book_rcd")
@ApiModel(description = "会议室预定 ; 会议室预定 , 数据表 oa_meeting_room_book_rcd 的PO类型")
public class MeetingRoomBookRcd extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_MEETING_ROOM_BOOK_RCD.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "726747245327679488")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "12")
	private String name;
	
	/**
	 * 会议室：会议室
	*/
	@ApiModelProperty(required = false,value="会议室" , notes = "会议室" , example = "726536200571060224")
	private String roomId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "finish")
	private String status;
	
	/**
	 * 预定部门：预定部门
	*/
	@ApiModelProperty(required = false,value="预定部门" , notes = "预定部门" , example = "2")
	private String orgId;
	
	/**
	 * 联系方式：联系方式
	*/
	@ApiModelProperty(required = false,value="联系方式" , notes = "联系方式")
	private String contactInformation;
	
	/**
	 * 预定人：预定人
	*/
	@ApiModelProperty(required = false,value="预定人" , notes = "预定人" , example = "586966688780517376")
	private String bookerId;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间" , example = "2023-06-08 12:03:00")
	private Date startTime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间" , example = "2023-06-13 12:03:00")
	private Date endTime;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "1212")
	private String notes;
	
	/**
	 * 发起人：发起人
	*/
	@ApiModelProperty(required = false,value="发起人" , notes = "发起人")
	private String userId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-06-29 10:34:06")
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
	 * meetingRoom：meetingRoom
	*/
	@ApiModelProperty(required = false,value="meetingRoom" , notes = "meetingRoom")
	private MeetingRoom meetingRoom;
	
	/**
	 * 组织部门：组织部门
	*/
	@ApiModelProperty(required = false,value="组织部门" , notes = "组织部门")
	private Organization org;
	
	/**
	 * booker：booker
	*/
	@ApiModelProperty(required = false,value="booker" , notes = "booker")
	private Employee booker;
	
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
	public MeetingRoomBookRcd setId(String id) {
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
	public MeetingRoomBookRcd setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 会议室<br>
	 * 会议室
	 * @return 会议室
	*/
	public String getRoomId() {
		return roomId;
	}
	
	/**
	 * 设置 会议室
	 * @param roomId 会议室
	 * @return 当前对象
	*/
	public MeetingRoomBookRcd setRoomId(String roomId) {
		this.roomId=roomId;
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
	public MeetingRoomBookRcd setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 预定部门<br>
	 * 预定部门
	 * @return 预定部门
	*/
	public String getOrgId() {
		return orgId;
	}
	
	/**
	 * 设置 预定部门
	 * @param orgId 预定部门
	 * @return 当前对象
	*/
	public MeetingRoomBookRcd setOrgId(String orgId) {
		this.orgId=orgId;
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
	public MeetingRoomBookRcd setContactInformation(String contactInformation) {
		this.contactInformation=contactInformation;
		return this;
	}
	
	/**
	 * 获得 预定人<br>
	 * 预定人
	 * @return 预定人
	*/
	public String getBookerId() {
		return bookerId;
	}
	
	/**
	 * 设置 预定人
	 * @param bookerId 预定人
	 * @return 当前对象
	*/
	public MeetingRoomBookRcd setBookerId(String bookerId) {
		this.bookerId=bookerId;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getStartTime() {
		return startTime;
	}
	
	/**
	 * 设置 开始时间
	 * @param startTime 开始时间
	 * @return 当前对象
	*/
	public MeetingRoomBookRcd setStartTime(Date startTime) {
		this.startTime=startTime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getEndTime() {
		return endTime;
	}
	
	/**
	 * 设置 结束时间
	 * @param endTime 结束时间
	 * @return 当前对象
	*/
	public MeetingRoomBookRcd setEndTime(Date endTime) {
		this.endTime=endTime;
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
	public MeetingRoomBookRcd setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 发起人<br>
	 * 发起人
	 * @return 发起人
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 发起人
	 * @param userId 发起人
	 * @return 当前对象
	*/
	public MeetingRoomBookRcd setUserId(String userId) {
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
	public MeetingRoomBookRcd setCreateBy(String createBy) {
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
	public MeetingRoomBookRcd setCreateTime(Date createTime) {
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
	public MeetingRoomBookRcd setUpdateBy(String updateBy) {
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
	public MeetingRoomBookRcd setUpdateTime(Date updateTime) {
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
	public MeetingRoomBookRcd setDeleted(Integer deleted) {
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
	public MeetingRoomBookRcd setDeleted(Boolean deletedBool) {
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
	public MeetingRoomBookRcd setDeleteBy(String deleteBy) {
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
	public MeetingRoomBookRcd setDeleteTime(Date deleteTime) {
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
	public MeetingRoomBookRcd setVersion(Integer version) {
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
	public MeetingRoomBookRcd setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 meetingRoom<br>
	 * meetingRoom
	 * @return meetingRoom
	*/
	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}
	
	/**
	 * 设置 meetingRoom
	 * @param meetingRoom meetingRoom
	 * @return 当前对象
	*/
	public MeetingRoomBookRcd setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom=meetingRoom;
		return this;
	}
	
	/**
	 * 获得 组织部门<br>
	 * 组织部门
	 * @return 组织部门
	*/
	public Organization getOrg() {
		return org;
	}
	
	/**
	 * 设置 组织部门
	 * @param org 组织部门
	 * @return 当前对象
	*/
	public MeetingRoomBookRcd setOrg(Organization org) {
		this.org=org;
		return this;
	}
	
	/**
	 * 获得 booker<br>
	 * booker
	 * @return booker
	*/
	public Employee getBooker() {
		return booker;
	}
	
	/**
	 * 设置 booker
	 * @param booker booker
	 * @return 当前对象
	*/
	public MeetingRoomBookRcd setBooker(Employee booker) {
		this.booker=booker;
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
	public MeetingRoomBookRcd setUser(Employee user) {
		this.user=user;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MeetingRoomBookRcd , 转换好的 MeetingRoomBookRcd 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MeetingRoomBookRcd , 转换好的 PoJo 对象
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
	public MeetingRoomBookRcd clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MeetingRoomBookRcd duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.MeetingRoomBookRcdMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.MeetingRoomBookRcdMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setRoomId(this.getRoomId());
		inst.setOrgId(this.getOrgId());
		inst.setCreateBy(this.getCreateBy());
		inst.setContactInformation(this.getContactInformation());
		inst.setDeleted(this.getDeleted());
		inst.setBookerId(this.getBookerId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStartTime(this.getStartTime());
		inst.setId(this.getId());
		inst.setEndTime(this.getEndTime());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setMeetingRoom(this.getMeetingRoom());
			inst.setOrg(this.getOrg());
			inst.setBooker(this.getBooker());
			inst.setUser(this.getUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MeetingRoomBookRcd clone(boolean deep) {
		return EntityContext.clone(MeetingRoomBookRcd.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MeetingRoomBookRcd
	 * @param meetingRoomBookRcdMap 包含实体信息的 Map 对象
	 * @return MeetingRoomBookRcd , 转换好的的 MeetingRoomBookRcd 对象
	*/
	@Transient
	public static MeetingRoomBookRcd createFrom(Map<String,Object> meetingRoomBookRcdMap) {
		if(meetingRoomBookRcdMap==null) return null;
		MeetingRoomBookRcd po = create();
		EntityContext.copyProperties(po,meetingRoomBookRcdMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 MeetingRoomBookRcd
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MeetingRoomBookRcd , 转换好的的 MeetingRoomBookRcd 对象
	*/
	@Transient
	public static MeetingRoomBookRcd createFrom(Object pojo) {
		if(pojo==null) return null;
		MeetingRoomBookRcd po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 MeetingRoomBookRcd，等同于 new
	 * @return MeetingRoomBookRcd 对象
	*/
	@Transient
	public static MeetingRoomBookRcd create() {
		return new com.dt.platform.domain.oa.meta.MeetingRoomBookRcdMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(MeetingRoomBookRcdMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MeetingRoomBookRcdMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(MeetingRoomBookRcdMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MeetingRoomBookRcdMeta.VERSION)));
			this.setRoomId(DataParser.parse(String.class, map.get(MeetingRoomBookRcdMeta.ROOM_ID)));
			this.setOrgId(DataParser.parse(String.class, map.get(MeetingRoomBookRcdMeta.ORG_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MeetingRoomBookRcdMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, map.get(MeetingRoomBookRcdMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MeetingRoomBookRcdMeta.DELETED)));
			this.setBookerId(DataParser.parse(String.class, map.get(MeetingRoomBookRcdMeta.BOOKER_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MeetingRoomBookRcdMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MeetingRoomBookRcdMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MeetingRoomBookRcdMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(MeetingRoomBookRcdMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(MeetingRoomBookRcdMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MeetingRoomBookRcdMeta.DELETE_BY)));
			this.setStartTime(DataParser.parse(Date.class, map.get(MeetingRoomBookRcdMeta.START_TIME)));
			this.setId(DataParser.parse(String.class, map.get(MeetingRoomBookRcdMeta.ID)));
			this.setEndTime(DataParser.parse(Date.class, map.get(MeetingRoomBookRcdMeta.END_TIME)));
			this.setStatus(DataParser.parse(String.class, map.get(MeetingRoomBookRcdMeta.STATUS)));
			// others
			this.setMeetingRoom(DataParser.parse(MeetingRoom.class, map.get(MeetingRoomBookRcdMeta.MEETING_ROOM)));
			this.setOrg(DataParser.parse(Organization.class, map.get(MeetingRoomBookRcdMeta.ORG)));
			this.setBooker(DataParser.parse(Employee.class, map.get(MeetingRoomBookRcdMeta.BOOKER)));
			this.setUser(DataParser.parse(Employee.class, map.get(MeetingRoomBookRcdMeta.USER)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(MeetingRoomBookRcdMeta.NOTES));
				this.setUpdateTime( (Date)map.get(MeetingRoomBookRcdMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(MeetingRoomBookRcdMeta.USER_ID));
				this.setVersion( (Integer)map.get(MeetingRoomBookRcdMeta.VERSION));
				this.setRoomId( (String)map.get(MeetingRoomBookRcdMeta.ROOM_ID));
				this.setOrgId( (String)map.get(MeetingRoomBookRcdMeta.ORG_ID));
				this.setCreateBy( (String)map.get(MeetingRoomBookRcdMeta.CREATE_BY));
				this.setContactInformation( (String)map.get(MeetingRoomBookRcdMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)map.get(MeetingRoomBookRcdMeta.DELETED));
				this.setBookerId( (String)map.get(MeetingRoomBookRcdMeta.BOOKER_ID));
				this.setCreateTime( (Date)map.get(MeetingRoomBookRcdMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(MeetingRoomBookRcdMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(MeetingRoomBookRcdMeta.DELETE_TIME));
				this.setName( (String)map.get(MeetingRoomBookRcdMeta.NAME));
				this.setTenantId( (String)map.get(MeetingRoomBookRcdMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(MeetingRoomBookRcdMeta.DELETE_BY));
				this.setStartTime( (Date)map.get(MeetingRoomBookRcdMeta.START_TIME));
				this.setId( (String)map.get(MeetingRoomBookRcdMeta.ID));
				this.setEndTime( (Date)map.get(MeetingRoomBookRcdMeta.END_TIME));
				this.setStatus( (String)map.get(MeetingRoomBookRcdMeta.STATUS));
				// others
				this.setMeetingRoom( (MeetingRoom)map.get(MeetingRoomBookRcdMeta.MEETING_ROOM));
				this.setOrg( (Organization)map.get(MeetingRoomBookRcdMeta.ORG));
				this.setBooker( (Employee)map.get(MeetingRoomBookRcdMeta.BOOKER));
				this.setUser( (Employee)map.get(MeetingRoomBookRcdMeta.USER));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(MeetingRoomBookRcdMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MeetingRoomBookRcdMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(MeetingRoomBookRcdMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MeetingRoomBookRcdMeta.VERSION)));
			this.setRoomId(DataParser.parse(String.class, r.getValue(MeetingRoomBookRcdMeta.ROOM_ID)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(MeetingRoomBookRcdMeta.ORG_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MeetingRoomBookRcdMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, r.getValue(MeetingRoomBookRcdMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MeetingRoomBookRcdMeta.DELETED)));
			this.setBookerId(DataParser.parse(String.class, r.getValue(MeetingRoomBookRcdMeta.BOOKER_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MeetingRoomBookRcdMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MeetingRoomBookRcdMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MeetingRoomBookRcdMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(MeetingRoomBookRcdMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(MeetingRoomBookRcdMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MeetingRoomBookRcdMeta.DELETE_BY)));
			this.setStartTime(DataParser.parse(Date.class, r.getValue(MeetingRoomBookRcdMeta.START_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(MeetingRoomBookRcdMeta.ID)));
			this.setEndTime(DataParser.parse(Date.class, r.getValue(MeetingRoomBookRcdMeta.END_TIME)));
			this.setStatus(DataParser.parse(String.class, r.getValue(MeetingRoomBookRcdMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(MeetingRoomBookRcdMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(MeetingRoomBookRcdMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(MeetingRoomBookRcdMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(MeetingRoomBookRcdMeta.VERSION));
				this.setRoomId( (String)r.getValue(MeetingRoomBookRcdMeta.ROOM_ID));
				this.setOrgId( (String)r.getValue(MeetingRoomBookRcdMeta.ORG_ID));
				this.setCreateBy( (String)r.getValue(MeetingRoomBookRcdMeta.CREATE_BY));
				this.setContactInformation( (String)r.getValue(MeetingRoomBookRcdMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)r.getValue(MeetingRoomBookRcdMeta.DELETED));
				this.setBookerId( (String)r.getValue(MeetingRoomBookRcdMeta.BOOKER_ID));
				this.setCreateTime( (Date)r.getValue(MeetingRoomBookRcdMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(MeetingRoomBookRcdMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(MeetingRoomBookRcdMeta.DELETE_TIME));
				this.setName( (String)r.getValue(MeetingRoomBookRcdMeta.NAME));
				this.setTenantId( (String)r.getValue(MeetingRoomBookRcdMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(MeetingRoomBookRcdMeta.DELETE_BY));
				this.setStartTime( (Date)r.getValue(MeetingRoomBookRcdMeta.START_TIME));
				this.setId( (String)r.getValue(MeetingRoomBookRcdMeta.ID));
				this.setEndTime( (Date)r.getValue(MeetingRoomBookRcdMeta.END_TIME));
				this.setStatus( (String)r.getValue(MeetingRoomBookRcdMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}