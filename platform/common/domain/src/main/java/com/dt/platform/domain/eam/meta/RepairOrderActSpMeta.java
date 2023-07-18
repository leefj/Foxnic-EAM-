package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.RepairOrderActSp;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-18 12:04:26
 * @sign 1B4BD4EA0A7508B3CA690F98A8F78BCB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class RepairOrderActSpMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderActSp,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderActSp.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 维修工单 , 类型: java.lang.String
	*/
	public static final String ACT_ID="actId";
	
	/**
	 * 维修工单 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderActSp,java.lang.String> ACT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderActSp.class ,ACT_ID, java.lang.String.class, "维修工单", "维修工单", java.lang.String.class, null);
	
	/**
	 * 备件 , 类型: java.lang.String
	*/
	public static final String SP_ID="spId";
	
	/**
	 * 备件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderActSp,java.lang.String> SP_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderActSp.class ,SP_ID, java.lang.String.class, "备件", "备件", java.lang.String.class, null);
	
	/**
	 * 备件名称 , 类型: java.lang.String
	*/
	public static final String SP_NAME="spName";
	
	/**
	 * 备件名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderActSp,java.lang.String> SP_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderActSp.class ,SP_NAME, java.lang.String.class, "备件名称", "备件名称", java.lang.String.class, null);
	
	/**
	 * 备件编码 , 类型: java.lang.String
	*/
	public static final String SP_CODE="spCode";
	
	/**
	 * 备件编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderActSp,java.lang.String> SP_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderActSp.class ,SP_CODE, java.lang.String.class, "备件编码", "备件编码", java.lang.String.class, null);
	
	/**
	 * 备件序列 , 类型: java.lang.String
	*/
	public static final String SP_SN="spSn";
	
	/**
	 * 备件序列 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderActSp,java.lang.String> SP_SN_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderActSp.class ,SP_SN, java.lang.String.class, "备件序列", "备件序列", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String SP_NOTES="spNotes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderActSp,java.lang.String> SP_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderActSp.class ,SP_NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderActSp,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderActSp.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderActSp,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderActSp.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderActSp,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderActSp.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderActSp,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderActSp.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderActSp,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderActSp.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderActSp,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderActSp.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderActSp,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderActSp.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderActSp,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderActSp.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderActSp,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderActSp.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * ownerId , 类型: java.lang.String
	*/
	public static final String OWNER_ID="ownerId";
	
	/**
	 * ownerId , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderActSp,java.lang.String> OWNER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderActSp.class ,OWNER_ID, java.lang.String.class, "ownerId", "ownerId", java.lang.String.class, null);
	
	/**
	 * ownerType , 类型: java.lang.String
	*/
	public static final String OWNER_TYPE="ownerType";
	
	/**
	 * ownerType , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.RepairOrderActSp,java.lang.String> OWNER_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.RepairOrderActSp.class ,OWNER_TYPE, java.lang.String.class, "ownerType", "ownerType", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ACT_ID , SP_ID , SP_NAME , SP_CODE , SP_SN , SP_NOTES , SELECTED_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , OWNER_ID , OWNER_TYPE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.RepairOrderActSp {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public RepairOrderActSp setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 维修工单
		 * @param actId 维修工单
		 * @return 当前对象
		*/
		public RepairOrderActSp setActId(String actId) {
			super.change(ACT_ID,super.getActId(),actId);
			super.setActId(actId);
			return this;
		}
		
		/**
		 * 设置 备件
		 * @param spId 备件
		 * @return 当前对象
		*/
		public RepairOrderActSp setSpId(String spId) {
			super.change(SP_ID,super.getSpId(),spId);
			super.setSpId(spId);
			return this;
		}
		
		/**
		 * 设置 备件名称
		 * @param spName 备件名称
		 * @return 当前对象
		*/
		public RepairOrderActSp setSpName(String spName) {
			super.change(SP_NAME,super.getSpName(),spName);
			super.setSpName(spName);
			return this;
		}
		
		/**
		 * 设置 备件编码
		 * @param spCode 备件编码
		 * @return 当前对象
		*/
		public RepairOrderActSp setSpCode(String spCode) {
			super.change(SP_CODE,super.getSpCode(),spCode);
			super.setSpCode(spCode);
			return this;
		}
		
		/**
		 * 设置 备件序列
		 * @param spSn 备件序列
		 * @return 当前对象
		*/
		public RepairOrderActSp setSpSn(String spSn) {
			super.change(SP_SN,super.getSpSn(),spSn);
			super.setSpSn(spSn);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param spNotes 备注
		 * @return 当前对象
		*/
		public RepairOrderActSp setSpNotes(String spNotes) {
			super.change(SP_NOTES,super.getSpNotes(),spNotes);
			super.setSpNotes(spNotes);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public RepairOrderActSp setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public RepairOrderActSp setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public RepairOrderActSp setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public RepairOrderActSp setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public RepairOrderActSp setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public RepairOrderActSp setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public RepairOrderActSp setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public RepairOrderActSp setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public RepairOrderActSp setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 ownerId
		 * @param ownerId ownerId
		 * @return 当前对象
		*/
		public RepairOrderActSp setOwnerId(String ownerId) {
			super.change(OWNER_ID,super.getOwnerId(),ownerId);
			super.setOwnerId(ownerId);
			return this;
		}
		
		/**
		 * 设置 ownerType
		 * @param ownerType ownerType
		 * @return 当前对象
		*/
		public RepairOrderActSp setOwnerType(String ownerType) {
			super.change(OWNER_TYPE,super.getOwnerType(),ownerType);
			super.setOwnerType(ownerType);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public RepairOrderActSp clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public RepairOrderActSp duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setSpName(this.getSpName());
			inst.setActId(this.getActId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setSpId(this.getSpId());
			inst.setSpCode(this.getSpCode());
			inst.setSpSn(this.getSpSn());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setVersion(this.getVersion());
			inst.setSpNotes(this.getSpNotes());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			if(all) {
				inst.setOwnerType(this.getOwnerType());
				inst.setOwnerId(this.getOwnerId());
			}
			inst.clearModifies();
			return inst;
		}

	}
}