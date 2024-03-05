package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.AttendanceTplGroup;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-27 13:25:42
 * @sign 54AB5166DC34132C29318C8130234A87
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AttendanceTplGroupMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 上班时间 , 类型: java.util.Date
	*/
	public static final String ON_WORK_TIME="onWorkTime";
	
	/**
	 * 上班时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.util.Date> ON_WORK_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,ON_WORK_TIME, java.util.Date.class, "上班时间", "上班时间", java.util.Date.class, null);
	
	/**
	 * 上班打卡上限 , 类型: java.util.Date
	*/
	public static final String ON_WORK_TIME_UP="onWorkTimeUp";
	
	/**
	 * 上班打卡上限 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.util.Date> ON_WORK_TIME_UP_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,ON_WORK_TIME_UP, java.util.Date.class, "上班打卡上限", "上班打卡上限", java.util.Date.class, null);
	
	/**
	 * 上班打卡下限 , 类型: java.util.Date
	*/
	public static final String ON_WORK_TIME_DOWN="onWorkTimeDown";
	
	/**
	 * 上班打卡下限 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.util.Date> ON_WORK_TIME_DOWN_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,ON_WORK_TIME_DOWN, java.util.Date.class, "上班打卡下限", "上班打卡下限", java.util.Date.class, null);
	
	/**
	 * 下班时间 , 类型: java.util.Date
	*/
	public static final String OFF_WORK_TIME="offWorkTime";
	
	/**
	 * 下班时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.util.Date> OFF_WORK_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,OFF_WORK_TIME, java.util.Date.class, "下班时间", "下班时间", java.util.Date.class, null);
	
	/**
	 * 下班打卡上限 , 类型: java.util.Date
	*/
	public static final String OFF_WORK_TIME_UP="offWorkTimeUp";
	
	/**
	 * 下班打卡上限 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.util.Date> OFF_WORK_TIME_UP_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,OFF_WORK_TIME_UP, java.util.Date.class, "下班打卡上限", "下班打卡上限", java.util.Date.class, null);
	
	/**
	 * 下班打卡下限 , 类型: java.util.Date
	*/
	public static final String OFF_WORK_TIME_DOWN="offWorkTimeDown";
	
	/**
	 * 下班打卡下限 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.util.Date> OFF_WORK_TIME_DOWN_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,OFF_WORK_TIME_DOWN, java.util.Date.class, "下班打卡下限", "下班打卡下限", java.util.Date.class, null);
	
	/**
	 * 上班打卡 , 类型: java.lang.String
	*/
	public static final String HALF_WORK_UP="halfWorkUp";
	
	/**
	 * 上班打卡 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.lang.String> HALF_WORK_UP_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,HALF_WORK_UP, java.lang.String.class, "上班打卡", "上班打卡", java.lang.String.class, null);
	
	/**
	 * 下班打卡 , 类型: java.lang.String
	*/
	public static final String HALF_WORK_DOWN="halfWorkDown";
	
	/**
	 * 下班打卡 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.lang.String> HALF_WORK_DOWN_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,HALF_WORK_DOWN, java.lang.String.class, "下班打卡", "下班打卡", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.AttendanceTplGroup,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.AttendanceTplGroup.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , ON_WORK_TIME , ON_WORK_TIME_UP , ON_WORK_TIME_DOWN , OFF_WORK_TIME , OFF_WORK_TIME_UP , OFF_WORK_TIME_DOWN , HALF_WORK_UP , HALF_WORK_DOWN , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.AttendanceTplGroup {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AttendanceTplGroup setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public AttendanceTplGroup setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 上班时间
		 * @param onWorkTime 上班时间
		 * @return 当前对象
		*/
		public AttendanceTplGroup setOnWorkTime(Date onWorkTime) {
			super.change(ON_WORK_TIME,super.getOnWorkTime(),onWorkTime);
			super.setOnWorkTime(onWorkTime);
			return this;
		}
		
		/**
		 * 设置 上班打卡上限
		 * @param onWorkTimeUp 上班打卡上限
		 * @return 当前对象
		*/
		public AttendanceTplGroup setOnWorkTimeUp(Date onWorkTimeUp) {
			super.change(ON_WORK_TIME_UP,super.getOnWorkTimeUp(),onWorkTimeUp);
			super.setOnWorkTimeUp(onWorkTimeUp);
			return this;
		}
		
		/**
		 * 设置 上班打卡下限
		 * @param onWorkTimeDown 上班打卡下限
		 * @return 当前对象
		*/
		public AttendanceTplGroup setOnWorkTimeDown(Date onWorkTimeDown) {
			super.change(ON_WORK_TIME_DOWN,super.getOnWorkTimeDown(),onWorkTimeDown);
			super.setOnWorkTimeDown(onWorkTimeDown);
			return this;
		}
		
		/**
		 * 设置 下班时间
		 * @param offWorkTime 下班时间
		 * @return 当前对象
		*/
		public AttendanceTplGroup setOffWorkTime(Date offWorkTime) {
			super.change(OFF_WORK_TIME,super.getOffWorkTime(),offWorkTime);
			super.setOffWorkTime(offWorkTime);
			return this;
		}
		
		/**
		 * 设置 下班打卡上限
		 * @param offWorkTimeUp 下班打卡上限
		 * @return 当前对象
		*/
		public AttendanceTplGroup setOffWorkTimeUp(Date offWorkTimeUp) {
			super.change(OFF_WORK_TIME_UP,super.getOffWorkTimeUp(),offWorkTimeUp);
			super.setOffWorkTimeUp(offWorkTimeUp);
			return this;
		}
		
		/**
		 * 设置 下班打卡下限
		 * @param offWorkTimeDown 下班打卡下限
		 * @return 当前对象
		*/
		public AttendanceTplGroup setOffWorkTimeDown(Date offWorkTimeDown) {
			super.change(OFF_WORK_TIME_DOWN,super.getOffWorkTimeDown(),offWorkTimeDown);
			super.setOffWorkTimeDown(offWorkTimeDown);
			return this;
		}
		
		/**
		 * 设置 上班打卡
		 * @param halfWorkUp 上班打卡
		 * @return 当前对象
		*/
		public AttendanceTplGroup setHalfWorkUp(String halfWorkUp) {
			super.change(HALF_WORK_UP,super.getHalfWorkUp(),halfWorkUp);
			super.setHalfWorkUp(halfWorkUp);
			return this;
		}
		
		/**
		 * 设置 下班打卡
		 * @param halfWorkDown 下班打卡
		 * @return 当前对象
		*/
		public AttendanceTplGroup setHalfWorkDown(String halfWorkDown) {
			super.change(HALF_WORK_DOWN,super.getHalfWorkDown(),halfWorkDown);
			super.setHalfWorkDown(halfWorkDown);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AttendanceTplGroup setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AttendanceTplGroup setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AttendanceTplGroup setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AttendanceTplGroup setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AttendanceTplGroup setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AttendanceTplGroup setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AttendanceTplGroup setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AttendanceTplGroup setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AttendanceTplGroup setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AttendanceTplGroup setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AttendanceTplGroup clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AttendanceTplGroup duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setOffWorkTimeDown(this.getOffWorkTimeDown());
			inst.setOffWorkTimeUp(this.getOffWorkTimeUp());
			inst.setNotes(this.getNotes());
			inst.setOnWorkTimeUp(this.getOnWorkTimeUp());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setOnWorkTime(this.getOnWorkTime());
			inst.setOnWorkTimeDown(this.getOnWorkTimeDown());
			inst.setCreateBy(this.getCreateBy());
			inst.setOffWorkTime(this.getOffWorkTime());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setHalfWorkUp(this.getHalfWorkUp());
			inst.setId(this.getId());
			inst.setHalfWorkDown(this.getHalfWorkDown());
			inst.clearModifies();
			return inst;
		}

	}
}