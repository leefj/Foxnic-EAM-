package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.MeetingRoomBookRcd;
import java.util.Date;
import com.dt.platform.domain.oa.MeetingRoom;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-29 11:22:48
 * @sign 93220BA938D843D703FDD0ED8D355451
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MeetingRoomBookRcdMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 会议室 , 类型: java.lang.String
	*/
	public static final String ROOM_ID="roomId";
	
	/**
	 * 会议室 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.lang.String> ROOM_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,ROOM_ID, java.lang.String.class, "会议室", "会议室", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 预定部门 , 类型: java.lang.String
	*/
	public static final String ORG_ID="orgId";
	
	/**
	 * 预定部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.lang.String> ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,ORG_ID, java.lang.String.class, "预定部门", "预定部门", java.lang.String.class, null);
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final String CONTACT_INFORMATION="contactInformation";
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.lang.String> CONTACT_INFORMATION_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,CONTACT_INFORMATION, java.lang.String.class, "联系方式", "联系方式", java.lang.String.class, null);
	
	/**
	 * 预定人 , 类型: java.lang.String
	*/
	public static final String BOOKER_ID="bookerId";
	
	/**
	 * 预定人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.lang.String> BOOKER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,BOOKER_ID, java.lang.String.class, "预定人", "预定人", java.lang.String.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String START_TIME="startTime";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.util.Date> START_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,START_TIME, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final String END_TIME="endTime";
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.util.Date> END_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,END_TIME, java.util.Date.class, "结束时间", "结束时间", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 发起人 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 发起人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,USER_ID, java.lang.String.class, "发起人", "发起人", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * meetingRoom , 类型: com.dt.platform.domain.oa.MeetingRoom
	*/
	public static final String MEETING_ROOM="meetingRoom";
	
	/**
	 * meetingRoom , 类型: com.dt.platform.domain.oa.MeetingRoom
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,com.dt.platform.domain.oa.MeetingRoom> MEETING_ROOM_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,MEETING_ROOM, com.dt.platform.domain.oa.MeetingRoom.class, "meetingRoom", "meetingRoom", com.dt.platform.domain.oa.MeetingRoom.class, null);
	
	/**
	 * 组织部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String ORG="org";
	
	/**
	 * 组织部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,org.github.foxnic.web.domain.hrm.Organization> ORG_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,ORG, org.github.foxnic.web.domain.hrm.Organization.class, "组织部门", "组织部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * booker , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String BOOKER="booker";
	
	/**
	 * booker , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,org.github.foxnic.web.domain.hrm.Employee> BOOKER_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,BOOKER, org.github.foxnic.web.domain.hrm.Employee.class, "booker", "booker", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * user , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USER="user";
	
	/**
	 * user , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.MeetingRoomBookRcd,org.github.foxnic.web.domain.hrm.Employee> USER_PROP = new BeanProperty(com.dt.platform.domain.oa.MeetingRoomBookRcd.class ,USER, org.github.foxnic.web.domain.hrm.Employee.class, "user", "user", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , ROOM_ID , STATUS , ORG_ID , CONTACT_INFORMATION , BOOKER_ID , START_TIME , END_TIME , NOTES , USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , MEETING_ROOM , ORG , BOOKER , USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.MeetingRoomBookRcd {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 会议室
		 * @param roomId 会议室
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setRoomId(String roomId) {
			super.change(ROOM_ID,super.getRoomId(),roomId);
			super.setRoomId(roomId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 预定部门
		 * @param orgId 预定部门
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setOrgId(String orgId) {
			super.change(ORG_ID,super.getOrgId(),orgId);
			super.setOrgId(orgId);
			return this;
		}
		
		/**
		 * 设置 联系方式
		 * @param contactInformation 联系方式
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setContactInformation(String contactInformation) {
			super.change(CONTACT_INFORMATION,super.getContactInformation(),contactInformation);
			super.setContactInformation(contactInformation);
			return this;
		}
		
		/**
		 * 设置 预定人
		 * @param bookerId 预定人
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setBookerId(String bookerId) {
			super.change(BOOKER_ID,super.getBookerId(),bookerId);
			super.setBookerId(bookerId);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param startTime 开始时间
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setStartTime(Date startTime) {
			super.change(START_TIME,super.getStartTime(),startTime);
			super.setStartTime(startTime);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param endTime 结束时间
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setEndTime(Date endTime) {
			super.change(END_TIME,super.getEndTime(),endTime);
			super.setEndTime(endTime);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 发起人
		 * @param userId 发起人
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 meetingRoom
		 * @param meetingRoom meetingRoom
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setMeetingRoom(MeetingRoom meetingRoom) {
			super.change(MEETING_ROOM,super.getMeetingRoom(),meetingRoom);
			super.setMeetingRoom(meetingRoom);
			return this;
		}
		
		/**
		 * 设置 组织部门
		 * @param org 组织部门
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setOrg(Organization org) {
			super.change(ORG,super.getOrg(),org);
			super.setOrg(org);
			return this;
		}
		
		/**
		 * 设置 booker
		 * @param booker booker
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setBooker(Employee booker) {
			super.change(BOOKER,super.getBooker(),booker);
			super.setBooker(booker);
			return this;
		}
		
		/**
		 * 设置 user
		 * @param user user
		 * @return 当前对象
		*/
		public MeetingRoomBookRcd setUser(Employee user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
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
			$$proxy$$ inst=new $$proxy$$();
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

	}
}