package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.DeviceSpRcd;
import java.util.Date;
import com.dt.platform.domain.eam.DeviceSp;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-17 12:21:54
 * @sign 494C3047ABC4B9BF7DB05C56C1ECFF61
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DeviceSpRcdMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSpRcd,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSpRcd.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 备件 , 类型: java.lang.String
	*/
	public static final String SP_ID="spId";
	
	/**
	 * 备件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSpRcd,java.lang.String> SP_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSpRcd.class ,SP_ID, java.lang.String.class, "备件", "备件", java.lang.String.class, null);
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final String SP_CODE="spCode";
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSpRcd,java.lang.String> SP_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSpRcd.class ,SP_CODE, java.lang.String.class, "编号", "编号", java.lang.String.class, null);
	
	/**
	 * 使用人 , 类型: java.lang.String
	*/
	public static final String OPER_ID="operId";
	
	/**
	 * 使用人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSpRcd,java.lang.String> OPER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSpRcd.class ,OPER_ID, java.lang.String.class, "使用人", "使用人", java.lang.String.class, null);
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final String OPER_TIME="operTime";
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSpRcd,java.util.Date> OPER_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSpRcd.class ,OPER_TIME, java.util.Date.class, "操作时间", "操作时间", java.util.Date.class, null);
	
	/**
	 * 操作内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 操作内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSpRcd,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSpRcd.class ,CONTENT, java.lang.String.class, "操作内容", "操作内容", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSpRcd,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSpRcd.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSpRcd,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSpRcd.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSpRcd,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSpRcd.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSpRcd,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSpRcd.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSpRcd,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSpRcd.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSpRcd,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSpRcd.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSpRcd,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSpRcd.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSpRcd,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSpRcd.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * deviceSp , 类型: com.dt.platform.domain.eam.DeviceSp
	*/
	public static final String DEVICE_SP="deviceSp";
	
	/**
	 * deviceSp , 类型: com.dt.platform.domain.eam.DeviceSp
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSpRcd,com.dt.platform.domain.eam.DeviceSp> DEVICE_SP_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSpRcd.class ,DEVICE_SP, com.dt.platform.domain.eam.DeviceSp.class, "deviceSp", "deviceSp", com.dt.platform.domain.eam.DeviceSp.class, null);
	
	/**
	 * operUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String OPER_USER="operUser";
	
	/**
	 * operUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSpRcd,org.github.foxnic.web.domain.hrm.Employee> OPER_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSpRcd.class ,OPER_USER, org.github.foxnic.web.domain.hrm.Employee.class, "operUser", "operUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , SP_ID , SP_CODE , OPER_ID , OPER_TIME , CONTENT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , DEVICE_SP , OPER_USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.DeviceSpRcd {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public DeviceSpRcd setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 备件
		 * @param spId 备件
		 * @return 当前对象
		*/
		public DeviceSpRcd setSpId(String spId) {
			super.change(SP_ID,super.getSpId(),spId);
			super.setSpId(spId);
			return this;
		}
		
		/**
		 * 设置 编号
		 * @param spCode 编号
		 * @return 当前对象
		*/
		public DeviceSpRcd setSpCode(String spCode) {
			super.change(SP_CODE,super.getSpCode(),spCode);
			super.setSpCode(spCode);
			return this;
		}
		
		/**
		 * 设置 使用人
		 * @param operId 使用人
		 * @return 当前对象
		*/
		public DeviceSpRcd setOperId(String operId) {
			super.change(OPER_ID,super.getOperId(),operId);
			super.setOperId(operId);
			return this;
		}
		
		/**
		 * 设置 操作时间
		 * @param operTime 操作时间
		 * @return 当前对象
		*/
		public DeviceSpRcd setOperTime(Date operTime) {
			super.change(OPER_TIME,super.getOperTime(),operTime);
			super.setOperTime(operTime);
			return this;
		}
		
		/**
		 * 设置 操作内容
		 * @param content 操作内容
		 * @return 当前对象
		*/
		public DeviceSpRcd setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public DeviceSpRcd setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public DeviceSpRcd setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public DeviceSpRcd setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public DeviceSpRcd setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public DeviceSpRcd setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public DeviceSpRcd setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public DeviceSpRcd setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public DeviceSpRcd setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 deviceSp
		 * @param deviceSp deviceSp
		 * @return 当前对象
		*/
		public DeviceSpRcd setDeviceSp(DeviceSp deviceSp) {
			super.change(DEVICE_SP,super.getDeviceSp(),deviceSp);
			super.setDeviceSp(deviceSp);
			return this;
		}
		
		/**
		 * 设置 operUser
		 * @param operUser operUser
		 * @return 当前对象
		*/
		public DeviceSpRcd setOperUser(Employee operUser) {
			super.change(OPER_USER,super.getOperUser(),operUser);
			super.setOperUser(operUser);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public DeviceSpRcd clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public DeviceSpRcd duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setOperId(this.getOperId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setSpId(this.getSpId());
			inst.setSpCode(this.getSpCode());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setOperTime(this.getOperTime());
			if(all) {
				inst.setOperUser(this.getOperUser());
				inst.setDeviceSp(this.getDeviceSp());
			}
			inst.clearModifies();
			return inst;
		}

	}
}