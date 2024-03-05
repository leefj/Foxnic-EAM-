package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AttendanceTplDtl;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.hr.AttendanceTplGroup;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-27 13:36:25
 * @sign 7C4A796BFA8D1A3915771F1772E37E6D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AttendanceTplDtlMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String OWNER_ID="ownerId";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,java.lang.String> OWNER_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,OWNER_ID, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 周 , 类型: java.lang.String
	*/
	public static final String WEEK="week";
	
	/**
	 * 周 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,java.lang.String> WEEK_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,WEEK, java.lang.String.class, "周", "周", java.lang.String.class, null);
	
	/**
	 * 是否上班 , 类型: java.lang.String
	*/
	public static final String IS_WORK_DAY="isWorkDay";
	
	/**
	 * 是否上班 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,java.lang.String> IS_WORK_DAY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,IS_WORK_DAY, java.lang.String.class, "是否上班", "是否上班", java.lang.String.class, null);
	
	/**
	 * 上班类型 , 类型: java.lang.String
	*/
	public static final String DAY_TYPE="dayType";
	
	/**
	 * 上班类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,java.lang.String> DAY_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,DAY_TYPE, java.lang.String.class, "上班类型", "上班类型", java.lang.String.class, null);
	
	/**
	 * 1天1次 , 类型: java.lang.String
	*/
	public static final String FIRST_WORK="firstWork";
	
	/**
	 * 1天1次 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,java.lang.String> FIRST_WORK_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,FIRST_WORK, java.lang.String.class, "1天1次", "1天1次", java.lang.String.class, null);
	
	/**
	 * 1天2次 , 类型: java.lang.String
	*/
	public static final String SECOND_WORK="secondWork";
	
	/**
	 * 1天2次 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,java.lang.String> SECOND_WORK_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,SECOND_WORK, java.lang.String.class, "1天2次", "1天2次", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * weekDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String WEEK_DICT="weekDict";
	
	/**
	 * weekDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,org.github.foxnic.web.domain.system.DictItem> WEEK_DICT_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,WEEK_DICT, org.github.foxnic.web.domain.system.DictItem.class, "weekDict", "weekDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * firstGroup , 类型: com.dt.platform.domain.hr.AttendanceTplGroup
	*/
	public static final String FIRST_GROUP="firstGroup";
	
	/**
	 * firstGroup , 类型: com.dt.platform.domain.hr.AttendanceTplGroup
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,com.dt.platform.domain.hr.AttendanceTplGroup> FIRST_GROUP_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,FIRST_GROUP, com.dt.platform.domain.hr.AttendanceTplGroup.class, "firstGroup", "firstGroup", com.dt.platform.domain.hr.AttendanceTplGroup.class, null);
	
	/**
	 * secondGroup , 类型: com.dt.platform.domain.hr.AttendanceTplGroup
	*/
	public static final String SECOND_GROUP="secondGroup";
	
	/**
	 * secondGroup , 类型: com.dt.platform.domain.hr.AttendanceTplGroup
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplDtl,com.dt.platform.domain.hr.AttendanceTplGroup> SECOND_GROUP_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplDtl.class ,SECOND_GROUP, com.dt.platform.domain.hr.AttendanceTplGroup.class, "secondGroup", "secondGroup", com.dt.platform.domain.hr.AttendanceTplGroup.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , OWNER_ID , WEEK , IS_WORK_DAY , DAY_TYPE , FIRST_WORK , SECOND_WORK , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , WEEK_DICT , FIRST_GROUP , SECOND_GROUP };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AttendanceTplDtl {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AttendanceTplDtl setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param ownerId 编码
		 * @return 当前对象
		*/
		public AttendanceTplDtl setOwnerId(String ownerId) {
			super.change(OWNER_ID,super.getOwnerId(),ownerId);
			super.setOwnerId(ownerId);
			return this;
		}
		
		/**
		 * 设置 周
		 * @param week 周
		 * @return 当前对象
		*/
		public AttendanceTplDtl setWeek(String week) {
			super.change(WEEK,super.getWeek(),week);
			super.setWeek(week);
			return this;
		}
		
		/**
		 * 设置 是否上班
		 * @param isWorkDay 是否上班
		 * @return 当前对象
		*/
		public AttendanceTplDtl setIsWorkDay(String isWorkDay) {
			super.change(IS_WORK_DAY,super.getIsWorkDay(),isWorkDay);
			super.setIsWorkDay(isWorkDay);
			return this;
		}
		
		/**
		 * 设置 上班类型
		 * @param dayType 上班类型
		 * @return 当前对象
		*/
		public AttendanceTplDtl setDayType(String dayType) {
			super.change(DAY_TYPE,super.getDayType(),dayType);
			super.setDayType(dayType);
			return this;
		}
		
		/**
		 * 设置 1天1次
		 * @param firstWork 1天1次
		 * @return 当前对象
		*/
		public AttendanceTplDtl setFirstWork(String firstWork) {
			super.change(FIRST_WORK,super.getFirstWork(),firstWork);
			super.setFirstWork(firstWork);
			return this;
		}
		
		/**
		 * 设置 1天2次
		 * @param secondWork 1天2次
		 * @return 当前对象
		*/
		public AttendanceTplDtl setSecondWork(String secondWork) {
			super.change(SECOND_WORK,super.getSecondWork(),secondWork);
			super.setSecondWork(secondWork);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AttendanceTplDtl setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AttendanceTplDtl setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AttendanceTplDtl setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AttendanceTplDtl setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AttendanceTplDtl setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AttendanceTplDtl setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AttendanceTplDtl setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AttendanceTplDtl setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AttendanceTplDtl setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 weekDict
		 * @param weekDict weekDict
		 * @return 当前对象
		*/
		public AttendanceTplDtl setWeekDict(DictItem weekDict) {
			super.change(WEEK_DICT,super.getWeekDict(),weekDict);
			super.setWeekDict(weekDict);
			return this;
		}
		
		/**
		 * 设置 firstGroup
		 * @param firstGroup firstGroup
		 * @return 当前对象
		*/
		public AttendanceTplDtl setFirstGroup(AttendanceTplGroup firstGroup) {
			super.change(FIRST_GROUP,super.getFirstGroup(),firstGroup);
			super.setFirstGroup(firstGroup);
			return this;
		}
		
		/**
		 * 设置 secondGroup
		 * @param secondGroup secondGroup
		 * @return 当前对象
		*/
		public AttendanceTplDtl setSecondGroup(AttendanceTplGroup secondGroup) {
			super.change(SECOND_GROUP,super.getSecondGroup(),secondGroup);
			super.setSecondGroup(secondGroup);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AttendanceTplDtl clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AttendanceTplDtl duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setSecondWork(this.getSecondWork());
			inst.setWeek(this.getWeek());
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setOwnerId(this.getOwnerId());
			inst.setVersion(this.getVersion());
			inst.setFirstWork(this.getFirstWork());
			inst.setDayType(this.getDayType());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setIsWorkDay(this.getIsWorkDay());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			if(all) {
				inst.setSecondGroup(this.getSecondGroup());
				inst.setWeekDict(this.getWeekDict());
				inst.setFirstGroup(this.getFirstGroup());
			}
			inst.clearModifies();
			return inst;
		}

	}
}