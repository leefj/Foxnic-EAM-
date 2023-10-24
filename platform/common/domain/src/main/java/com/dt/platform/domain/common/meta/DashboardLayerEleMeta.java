package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.DashboardLayerEle;
import java.util.Date;
import com.dt.platform.domain.common.DashboardLayer;
import com.dt.platform.domain.common.Report;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-24 07:43:40
 * @sign 66234C043AD96CD5879AEB9B7D28D717
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DashboardLayerEleMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 面板 , 类型: java.lang.String
	*/
	public static final String LAYER_ID="layerId";
	
	/**
	 * 面板 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,java.lang.String> LAYER_ID_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,LAYER_ID, java.lang.String.class, "面板", "面板", java.lang.String.class, null);
	
	/**
	 * 面板分层 , 类型: java.lang.String
	*/
	public static final String DASHBOARD_ID="dashboardId";
	
	/**
	 * 面板分层 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,java.lang.String> DASHBOARD_ID_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,DASHBOARD_ID, java.lang.String.class, "面板分层", "面板分层", java.lang.String.class, null);
	
	/**
	 * 标题 , 类型: java.lang.String
	*/
	public static final String TITLE="title";
	
	/**
	 * 标题 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,java.lang.String> TITLE_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,TITLE, java.lang.String.class, "标题", "标题", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final String SOURCE="source";
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,java.lang.String> SOURCE_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,SOURCE, java.lang.String.class, "来源", "来源", java.lang.String.class, null);
	
	/**
	 * 配置 , 类型: java.lang.String
	*/
	public static final String JSON="json";
	
	/**
	 * 配置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,java.lang.String> JSON_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,JSON, java.lang.String.class, "配置", "配置", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,java.lang.Integer> SORT_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,SORT, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * dashboardLayer , 类型: com.dt.platform.domain.common.DashboardLayer
	*/
	public static final String DASHBOARD_LAYER="dashboardLayer";
	
	/**
	 * dashboardLayer , 类型: com.dt.platform.domain.common.DashboardLayer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,com.dt.platform.domain.common.DashboardLayer> DASHBOARD_LAYER_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,DASHBOARD_LAYER, com.dt.platform.domain.common.DashboardLayer.class, "dashboardLayer", "dashboardLayer", com.dt.platform.domain.common.DashboardLayer.class, null);
	
	/**
	 * reportChart , 类型: com.dt.platform.domain.common.Report
	*/
	public static final String REPORT_CHART="reportChart";
	
	/**
	 * reportChart , 类型: com.dt.platform.domain.common.Report
	*/
	public static final BeanProperty<com.dt.platform.domain.common.DashboardLayerEle,com.dt.platform.domain.common.Report> REPORT_CHART_PROP = new BeanProperty(com.dt.platform.domain.common.DashboardLayerEle.class ,REPORT_CHART, com.dt.platform.domain.common.Report.class, "reportChart", "reportChart", com.dt.platform.domain.common.Report.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , LAYER_ID , DASHBOARD_ID , TITLE , STATUS , TYPE , SOURCE , JSON , NOTES , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , DASHBOARD_LAYER , REPORT_CHART };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.DashboardLayerEle {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public DashboardLayerEle setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 面板
		 * @param layerId 面板
		 * @return 当前对象
		*/
		public DashboardLayerEle setLayerId(String layerId) {
			super.change(LAYER_ID,super.getLayerId(),layerId);
			super.setLayerId(layerId);
			return this;
		}
		
		/**
		 * 设置 面板分层
		 * @param dashboardId 面板分层
		 * @return 当前对象
		*/
		public DashboardLayerEle setDashboardId(String dashboardId) {
			super.change(DASHBOARD_ID,super.getDashboardId(),dashboardId);
			super.setDashboardId(dashboardId);
			return this;
		}
		
		/**
		 * 设置 标题
		 * @param title 标题
		 * @return 当前对象
		*/
		public DashboardLayerEle setTitle(String title) {
			super.change(TITLE,super.getTitle(),title);
			super.setTitle(title);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public DashboardLayerEle setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public DashboardLayerEle setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param source 来源
		 * @return 当前对象
		*/
		public DashboardLayerEle setSource(String source) {
			super.change(SOURCE,super.getSource(),source);
			super.setSource(source);
			return this;
		}
		
		/**
		 * 设置 配置
		 * @param json 配置
		 * @return 当前对象
		*/
		public DashboardLayerEle setJson(String json) {
			super.change(JSON,super.getJson(),json);
			super.setJson(json);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public DashboardLayerEle setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sort 排序
		 * @return 当前对象
		*/
		public DashboardLayerEle setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public DashboardLayerEle setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public DashboardLayerEle setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public DashboardLayerEle setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public DashboardLayerEle setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public DashboardLayerEle setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public DashboardLayerEle setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public DashboardLayerEle setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public DashboardLayerEle setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 dashboardLayer
		 * @param dashboardLayer dashboardLayer
		 * @return 当前对象
		*/
		public DashboardLayerEle setDashboardLayer(DashboardLayer dashboardLayer) {
			super.change(DASHBOARD_LAYER,super.getDashboardLayer(),dashboardLayer);
			super.setDashboardLayer(dashboardLayer);
			return this;
		}
		
		/**
		 * 设置 reportChart
		 * @param reportChart reportChart
		 * @return 当前对象
		*/
		public DashboardLayerEle setReportChart(Report reportChart) {
			super.change(REPORT_CHART,super.getReportChart(),reportChart);
			super.setReportChart(reportChart);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public DashboardLayerEle clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public DashboardLayerEle duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setSource(this.getSource());
			inst.setSort(this.getSort());
			inst.setTitle(this.getTitle());
			inst.setType(this.getType());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setLayerId(this.getLayerId());
			inst.setDeleted(this.getDeleted());
			inst.setDashboardId(this.getDashboardId());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setJson(this.getJson());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setReportChart(this.getReportChart());
				inst.setDashboardLayer(this.getDashboardLayer());
			}
			inst.clearModifies();
			return inst;
		}

	}
}