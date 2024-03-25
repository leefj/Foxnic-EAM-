package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.InspectionRcd;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-24 08:15:44
 * @sign 0A90F504491B062ABB8A97E84A4E97ED
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InspectionRcdMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionRcd,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionRcd.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 单据 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 单据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionRcd,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionRcd.class ,BUSINESS_CODE, java.lang.String.class, "单据", "单据", java.lang.String.class, null);
	
	/**
	 * 设备 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 设备 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionRcd,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionRcd.class ,ASSET_ID, java.lang.String.class, "设备", "设备", java.lang.String.class, null);
	
	/**
	 * 结果 , 类型: java.lang.String
	*/
	public static final String RESULT_CODE="resultCode";
	
	/**
	 * 结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionRcd,java.lang.String> RESULT_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionRcd.class ,RESULT_CODE, java.lang.String.class, "结果", "结果", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionRcd,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionRcd.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 操作日期 , 类型: java.util.Date
	*/
	public static final String RCD_TIME="rcdTime";
	
	/**
	 * 操作日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionRcd,java.util.Date> RCD_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionRcd.class ,RCD_TIME, java.util.Date.class, "操作日期", "操作日期", java.util.Date.class, null);
	
	/**
	 * 操作人员 , 类型: java.lang.String
	*/
	public static final String OPER_USER_ID="operUserId";
	
	/**
	 * 操作人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionRcd,java.lang.String> OPER_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionRcd.class ,OPER_USER_ID, java.lang.String.class, "操作人员", "操作人员", java.lang.String.class, null);
	
	/**
	 * 操作人员 , 类型: java.lang.String
	*/
	public static final String OPER_USER_NAME="operUserName";
	
	/**
	 * 操作人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionRcd,java.lang.String> OPER_USER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionRcd.class ,OPER_USER_NAME, java.lang.String.class, "操作人员", "操作人员", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionRcd,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionRcd.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionRcd,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionRcd.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionRcd,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionRcd.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionRcd,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionRcd.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionRcd,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionRcd.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionRcd,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionRcd.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionRcd,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionRcd.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionRcd,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionRcd.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BUSINESS_CODE , ASSET_ID , RESULT_CODE , CONTENT , RCD_TIME , OPER_USER_ID , OPER_USER_NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.InspectionRcd {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public InspectionRcd setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 单据
		 * @param businessCode 单据
		 * @return 当前对象
		*/
		public InspectionRcd setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 设备
		 * @param assetId 设备
		 * @return 当前对象
		*/
		public InspectionRcd setAssetId(String assetId) {
			super.change(ASSET_ID,super.getAssetId(),assetId);
			super.setAssetId(assetId);
			return this;
		}
		
		/**
		 * 设置 结果
		 * @param resultCode 结果
		 * @return 当前对象
		*/
		public InspectionRcd setResultCode(String resultCode) {
			super.change(RESULT_CODE,super.getResultCode(),resultCode);
			super.setResultCode(resultCode);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public InspectionRcd setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 操作日期
		 * @param rcdTime 操作日期
		 * @return 当前对象
		*/
		public InspectionRcd setRcdTime(Date rcdTime) {
			super.change(RCD_TIME,super.getRcdTime(),rcdTime);
			super.setRcdTime(rcdTime);
			return this;
		}
		
		/**
		 * 设置 操作人员
		 * @param operUserId 操作人员
		 * @return 当前对象
		*/
		public InspectionRcd setOperUserId(String operUserId) {
			super.change(OPER_USER_ID,super.getOperUserId(),operUserId);
			super.setOperUserId(operUserId);
			return this;
		}
		
		/**
		 * 设置 操作人员
		 * @param operUserName 操作人员
		 * @return 当前对象
		*/
		public InspectionRcd setOperUserName(String operUserName) {
			super.change(OPER_USER_NAME,super.getOperUserName(),operUserName);
			super.setOperUserName(operUserName);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public InspectionRcd setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public InspectionRcd setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public InspectionRcd setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public InspectionRcd setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public InspectionRcd setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public InspectionRcd setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public InspectionRcd setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public InspectionRcd setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public InspectionRcd clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public InspectionRcd duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setOperUserId(this.getOperUserId());
			inst.setResultCode(this.getResultCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setBusinessCode(this.getBusinessCode());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setAssetId(this.getAssetId());
			inst.setOperUserName(this.getOperUserName());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setRcdTime(this.getRcdTime());
			inst.clearModifies();
			return inst;
		}

	}
}