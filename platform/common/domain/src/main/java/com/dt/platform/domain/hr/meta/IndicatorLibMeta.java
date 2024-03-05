package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.IndicatorLib;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-29 16:32:19
 * @sign 13CDD639DB5E02E31731FC97A0DA7383
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class IndicatorLibMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.IndicatorLib,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.IndicatorLib.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 指标分类 , 类型: java.lang.String
	*/
	public static final String TYPE_CODE="typeCode";
	
	/**
	 * 指标分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.IndicatorLib,java.lang.String> TYPE_CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.IndicatorLib.class ,TYPE_CODE, java.lang.String.class, "指标分类", "指标分类", java.lang.String.class, null);
	
	/**
	 * 指标名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 指标名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.IndicatorLib,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.IndicatorLib.class ,NAME, java.lang.String.class, "指标名称", "指标名称", java.lang.String.class, null);
	
	/**
	 * 定性/定量指标 , 类型: java.lang.String
	*/
	public static final String PROPERTY="property";
	
	/**
	 * 定性/定量指标 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.IndicatorLib,java.lang.String> PROPERTY_PROP = new BeanProperty(com.dt.platform.domain.hr.IndicatorLib.class ,PROPERTY, java.lang.String.class, "定性/定量指标", "定性/定量指标", java.lang.String.class, null);
	
	/**
	 * 计量单位 , 类型: java.lang.String
	*/
	public static final String UNIT="unit";
	
	/**
	 * 计量单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.IndicatorLib,java.lang.String> UNIT_PROP = new BeanProperty(com.dt.platform.domain.hr.IndicatorLib.class ,UNIT, java.lang.String.class, "计量单位", "计量单位", java.lang.String.class, null);
	
	/**
	 * 指标定义 , 类型: java.lang.String
	*/
	public static final String DEF="def";
	
	/**
	 * 指标定义 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.IndicatorLib,java.lang.String> DEF_PROP = new BeanProperty(com.dt.platform.domain.hr.IndicatorLib.class ,DEF, java.lang.String.class, "指标定义", "指标定义", java.lang.String.class, null);
	
	/**
	 * 评分标准 , 类型: java.lang.String
	*/
	public static final String SCORING_BASE="scoringBase";
	
	/**
	 * 评分标准 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.IndicatorLib,java.lang.String> SCORING_BASE_PROP = new BeanProperty(com.dt.platform.domain.hr.IndicatorLib.class ,SCORING_BASE, java.lang.String.class, "评分标准", "评分标准", java.lang.String.class, null);
	
	/**
	 * 评分依据 , 类型: java.lang.String
	*/
	public static final String SCORING_BY="scoringBy";
	
	/**
	 * 评分依据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.IndicatorLib,java.lang.String> SCORING_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.IndicatorLib.class ,SCORING_BY, java.lang.String.class, "评分依据", "评分依据", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.IndicatorLib,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.IndicatorLib.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.IndicatorLib,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.IndicatorLib.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.IndicatorLib,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.IndicatorLib.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.IndicatorLib,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.IndicatorLib.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.IndicatorLib,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.IndicatorLib.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.IndicatorLib,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.IndicatorLib.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.IndicatorLib,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.IndicatorLib.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.IndicatorLib,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.IndicatorLib.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.IndicatorLib,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.IndicatorLib.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * typeDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String TYPE_DICT="typeDict";
	
	/**
	 * typeDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.IndicatorLib,org.github.foxnic.web.domain.system.DictItem> TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.hr.IndicatorLib.class ,TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "typeDict", "typeDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TYPE_CODE , NAME , PROPERTY , UNIT , DEF , SCORING_BASE , SCORING_BY , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , TYPE_DICT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.IndicatorLib {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public IndicatorLib setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 指标分类
		 * @param typeCode 指标分类
		 * @return 当前对象
		*/
		public IndicatorLib setTypeCode(String typeCode) {
			super.change(TYPE_CODE,super.getTypeCode(),typeCode);
			super.setTypeCode(typeCode);
			return this;
		}
		
		/**
		 * 设置 指标名称
		 * @param name 指标名称
		 * @return 当前对象
		*/
		public IndicatorLib setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 定性/定量指标
		 * @param property 定性/定量指标
		 * @return 当前对象
		*/
		public IndicatorLib setProperty(String property) {
			super.change(PROPERTY,super.getProperty(),property);
			super.setProperty(property);
			return this;
		}
		
		/**
		 * 设置 计量单位
		 * @param unit 计量单位
		 * @return 当前对象
		*/
		public IndicatorLib setUnit(String unit) {
			super.change(UNIT,super.getUnit(),unit);
			super.setUnit(unit);
			return this;
		}
		
		/**
		 * 设置 指标定义
		 * @param def 指标定义
		 * @return 当前对象
		*/
		public IndicatorLib setDef(String def) {
			super.change(DEF,super.getDef(),def);
			super.setDef(def);
			return this;
		}
		
		/**
		 * 设置 评分标准
		 * @param scoringBase 评分标准
		 * @return 当前对象
		*/
		public IndicatorLib setScoringBase(String scoringBase) {
			super.change(SCORING_BASE,super.getScoringBase(),scoringBase);
			super.setScoringBase(scoringBase);
			return this;
		}
		
		/**
		 * 设置 评分依据
		 * @param scoringBy 评分依据
		 * @return 当前对象
		*/
		public IndicatorLib setScoringBy(String scoringBy) {
			super.change(SCORING_BY,super.getScoringBy(),scoringBy);
			super.setScoringBy(scoringBy);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public IndicatorLib setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public IndicatorLib setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public IndicatorLib setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public IndicatorLib setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public IndicatorLib setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public IndicatorLib setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public IndicatorLib setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public IndicatorLib setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public IndicatorLib setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 typeDict
		 * @param typeDict typeDict
		 * @return 当前对象
		*/
		public IndicatorLib setTypeDict(DictItem typeDict) {
			super.change(TYPE_DICT,super.getTypeDict(),typeDict);
			super.setTypeDict(typeDict);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public IndicatorLib clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public IndicatorLib duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setScoringBase(this.getScoringBase());
			inst.setDef(this.getDef());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setTypeCode(this.getTypeCode());
			inst.setScoringBy(this.getScoringBy());
			inst.setUnit(this.getUnit());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setProperty(this.getProperty());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			if(all) {
				inst.setTypeDict(this.getTypeDict());
			}
			inst.clearModifies();
			return inst;
		}

	}
}