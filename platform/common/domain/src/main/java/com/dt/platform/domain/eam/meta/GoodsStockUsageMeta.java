package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.GoodsStockUsage;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-10 22:43:44
 * @sign 929AB0F10897B854B35277978AB37E82
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class GoodsStockUsageMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final String OWNER_ID="ownerId";
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,java.lang.String> OWNER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,OWNER_ID, java.lang.String.class, "所属", "所属", java.lang.String.class, null);
	
	/**
	 * 单据编码 , 类型: java.lang.String
	*/
	public static final String BILL_CODE="billCode";
	
	/**
	 * 单据编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,java.lang.String> BILL_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,BILL_CODE, java.lang.String.class, "单据编码", "单据编码", java.lang.String.class, null);
	
	/**
	 * 操作标签 , 类型: java.lang.String
	*/
	public static final String LABEL="label";
	
	/**
	 * 操作标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,java.lang.String> LABEL_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,LABEL, java.lang.String.class, "操作标签", "操作标签", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 数量 , 类型: java.lang.String
	*/
	public static final String OPER_NUMBER="operNumber";
	
	/**
	 * 数量 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,java.lang.String> OPER_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,OPER_NUMBER, java.lang.String.class, "数量", "数量", java.lang.String.class, null);
	
	/**
	 * 操作 , 类型: java.lang.String
	*/
	public static final String OPER="oper";
	
	/**
	 * 操作 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,java.lang.String> OPER_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,OPER, java.lang.String.class, "操作", "操作", java.lang.String.class, null);
	
	/**
	 * 操作人员 , 类型: java.lang.String
	*/
	public static final String OPER_USER_ID="operUserId";
	
	/**
	 * 操作人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,java.lang.String> OPER_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,OPER_USER_ID, java.lang.String.class, "操作人员", "操作人员", java.lang.String.class, null);
	
	/**
	 * 操作人员 , 类型: java.lang.String
	*/
	public static final String OPER_USER_NAME="operUserName";
	
	/**
	 * 操作人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,java.lang.String> OPER_USER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,OPER_USER_NAME, java.lang.String.class, "操作人员", "操作人员", java.lang.String.class, null);
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final String REC_TIME="recTime";
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,java.util.Date> REC_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,REC_TIME, java.util.Date.class, "记录时间", "记录时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * opsUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String OPS_USER="opsUser";
	
	/**
	 * opsUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.GoodsStockUsage,org.github.foxnic.web.domain.hrm.Employee> OPS_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.GoodsStockUsage.class ,OPS_USER, org.github.foxnic.web.domain.hrm.Employee.class, "opsUser", "opsUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , OWNER_ID , BILL_CODE , LABEL , CONTENT , OPER_NUMBER , OPER , OPER_USER_ID , OPER_USER_NAME , REC_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , OPS_USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.GoodsStockUsage {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public GoodsStockUsage setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 所属
		 * @param ownerId 所属
		 * @return 当前对象
		*/
		public GoodsStockUsage setOwnerId(String ownerId) {
			super.change(OWNER_ID,super.getOwnerId(),ownerId);
			super.setOwnerId(ownerId);
			return this;
		}
		
		/**
		 * 设置 单据编码
		 * @param billCode 单据编码
		 * @return 当前对象
		*/
		public GoodsStockUsage setBillCode(String billCode) {
			super.change(BILL_CODE,super.getBillCode(),billCode);
			super.setBillCode(billCode);
			return this;
		}
		
		/**
		 * 设置 操作标签
		 * @param label 操作标签
		 * @return 当前对象
		*/
		public GoodsStockUsage setLabel(String label) {
			super.change(LABEL,super.getLabel(),label);
			super.setLabel(label);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public GoodsStockUsage setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 数量
		 * @param operNumber 数量
		 * @return 当前对象
		*/
		public GoodsStockUsage setOperNumber(String operNumber) {
			super.change(OPER_NUMBER,super.getOperNumber(),operNumber);
			super.setOperNumber(operNumber);
			return this;
		}
		
		/**
		 * 设置 操作
		 * @param oper 操作
		 * @return 当前对象
		*/
		public GoodsStockUsage setOper(String oper) {
			super.change(OPER,super.getOper(),oper);
			super.setOper(oper);
			return this;
		}
		
		/**
		 * 设置 操作人员
		 * @param operUserId 操作人员
		 * @return 当前对象
		*/
		public GoodsStockUsage setOperUserId(String operUserId) {
			super.change(OPER_USER_ID,super.getOperUserId(),operUserId);
			super.setOperUserId(operUserId);
			return this;
		}
		
		/**
		 * 设置 操作人员
		 * @param operUserName 操作人员
		 * @return 当前对象
		*/
		public GoodsStockUsage setOperUserName(String operUserName) {
			super.change(OPER_USER_NAME,super.getOperUserName(),operUserName);
			super.setOperUserName(operUserName);
			return this;
		}
		
		/**
		 * 设置 记录时间
		 * @param recTime 记录时间
		 * @return 当前对象
		*/
		public GoodsStockUsage setRecTime(Date recTime) {
			super.change(REC_TIME,super.getRecTime(),recTime);
			super.setRecTime(recTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public GoodsStockUsage setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public GoodsStockUsage setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public GoodsStockUsage setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public GoodsStockUsage setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public GoodsStockUsage setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public GoodsStockUsage setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public GoodsStockUsage setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public GoodsStockUsage setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 opsUser
		 * @param opsUser opsUser
		 * @return 当前对象
		*/
		public GoodsStockUsage setOpsUser(Employee opsUser) {
			super.change(OPS_USER,super.getOpsUser(),opsUser);
			super.setOpsUser(opsUser);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public GoodsStockUsage clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public GoodsStockUsage duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setOperUserId(this.getOperUserId());
			inst.setRecTime(this.getRecTime());
			inst.setBillCode(this.getBillCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setLabel(this.getLabel());
			inst.setOwnerId(this.getOwnerId());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setOperNumber(this.getOperNumber());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setOperUserName(this.getOperUserName());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setOper(this.getOper());
			inst.setId(this.getId());
			if(all) {
				inst.setOpsUser(this.getOpsUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}