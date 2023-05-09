package com.dt.platform.domain.vehicle.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.vehicle.LeMaintenance;
import java.util.Date;
import java.math.BigDecimal;
import com.dt.platform.domain.vehicle.Info;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-09 12:43:09
 * @sign FE199AF8C35BE9FE00BABA679D045883
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class LeMaintenanceMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,NAME, java.lang.String.class, "业务名称", "业务名称", java.lang.String.class, null);
	
	/**
	 * 维修状态 , 类型: java.lang.String
	*/
	public static final String REPAIR_STATUS="repairStatus";
	
	/**
	 * 维修状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.String> REPAIR_STATUS_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,REPAIR_STATUS, java.lang.String.class, "维修状态", "维修状态", java.lang.String.class, null);
	
	/**
	 * 报修类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 报修类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,TYPE, java.lang.String.class, "报修类型", "报修类型", java.lang.String.class, null);
	
	/**
	 * 计划完成日期 , 类型: java.util.Date
	*/
	public static final String PLAN_FINISH_DATE="planFinishDate";
	
	/**
	 * 计划完成日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.util.Date> PLAN_FINISH_DATE_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,PLAN_FINISH_DATE, java.util.Date.class, "计划完成日期", "计划完成日期", java.util.Date.class, null);
	
	/**
	 * 实际完成日期 , 类型: java.util.Date
	*/
	public static final String ACTUAL_FINISH_DATE="actualFinishDate";
	
	/**
	 * 实际完成日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.util.Date> ACTUAL_FINISH_DATE_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,ACTUAL_FINISH_DATE, java.util.Date.class, "实际完成日期", "实际完成日期", java.util.Date.class, null);
	
	/**
	 * 费用 , 类型: java.math.BigDecimal
	*/
	public static final String COST="cost";
	
	/**
	 * 费用 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.math.BigDecimal> COST_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,COST, java.math.BigDecimal.class, "费用", "费用", java.math.BigDecimal.class, null);
	
	/**
	 * 报修内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 报修内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,CONTENT, java.lang.String.class, "报修内容", "报修内容", java.lang.String.class, null);
	
	/**
	 * 报修人 , 类型: java.lang.String
	*/
	public static final String REPORT_USER_ID="reportUserId";
	
	/**
	 * 报修人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.String> REPORT_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,REPORT_USER_ID, java.lang.String.class, "报修人", "报修人", java.lang.String.class, null);
	
	/**
	 * 报修人 , 类型: java.lang.String
	*/
	public static final String REPORT_USER_NAME="reportUserName";
	
	/**
	 * 报修人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.String> REPORT_USER_NAME_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,REPORT_USER_NAME, java.lang.String.class, "报修人", "报修人", java.lang.String.class, null);
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,PICTURE_ID, java.lang.String.class, "图片", "图片", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final String BUSINESS_DATE="businessDate";
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.util.Date> BUSINESS_DATE_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,BUSINESS_DATE, java.util.Date.class, "业务日期", "业务日期", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,SELECTED_CODE, java.lang.String.class, "选择数据", "选择数据", java.lang.String.class, null);
	
	/**
	 * 车辆 , 集合类型: LIST , 类型: com.dt.platform.domain.vehicle.Info
	*/
	public static final String VEHICLE_INFO_LIST="vehicleInfoList";
	
	/**
	 * 车辆 , 集合类型: LIST , 类型: com.dt.platform.domain.vehicle.Info
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,com.dt.platform.domain.vehicle.Info> VEHICLE_INFO_LIST_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,VEHICLE_INFO_LIST, java.util.List.class, "车辆", "车辆", com.dt.platform.domain.vehicle.Info.class, null);
	
	/**
	 * 车辆列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String VEHICLE_INFO_IDS="vehicleInfoIds";
	
	/**
	 * 车辆列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,java.lang.String> VEHICLE_INFO_IDS_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,VEHICLE_INFO_IDS, java.util.List.class, "车辆列表", "车辆列表", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 报修类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String MAINTENANCE_DICT="maintenanceDict";
	
	/**
	 * 报修类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.vehicle.LeMaintenance,org.github.foxnic.web.domain.system.DictItem> MAINTENANCE_DICT_PROP = new BeanProperty(com.dt.platform.domain.vehicle.LeMaintenance.class ,MAINTENANCE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "报修类型", "报修类型", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BUSINESS_CODE , STATUS , PROC_ID , NAME , REPAIR_STATUS , TYPE , PLAN_FINISH_DATE , ACTUAL_FINISH_DATE , COST , CONTENT , REPORT_USER_ID , REPORT_USER_NAME , PICTURE_ID , ORIGINATOR_ID , BUSINESS_DATE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , VEHICLE_INFO_LIST , VEHICLE_INFO_IDS , ORIGINATOR , MAINTENANCE_DICT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.vehicle.LeMaintenance {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public LeMaintenance setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public LeMaintenance setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public LeMaintenance setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 流程
		 * @param procId 流程
		 * @return 当前对象
		*/
		public LeMaintenance setProcId(String procId) {
			super.change(PROC_ID,super.getProcId(),procId);
			super.setProcId(procId);
			return this;
		}
		
		/**
		 * 设置 业务名称
		 * @param name 业务名称
		 * @return 当前对象
		*/
		public LeMaintenance setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 维修状态
		 * @param repairStatus 维修状态
		 * @return 当前对象
		*/
		public LeMaintenance setRepairStatus(String repairStatus) {
			super.change(REPAIR_STATUS,super.getRepairStatus(),repairStatus);
			super.setRepairStatus(repairStatus);
			return this;
		}
		
		/**
		 * 设置 报修类型
		 * @param type 报修类型
		 * @return 当前对象
		*/
		public LeMaintenance setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 计划完成日期
		 * @param planFinishDate 计划完成日期
		 * @return 当前对象
		*/
		public LeMaintenance setPlanFinishDate(Date planFinishDate) {
			super.change(PLAN_FINISH_DATE,super.getPlanFinishDate(),planFinishDate);
			super.setPlanFinishDate(planFinishDate);
			return this;
		}
		
		/**
		 * 设置 实际完成日期
		 * @param actualFinishDate 实际完成日期
		 * @return 当前对象
		*/
		public LeMaintenance setActualFinishDate(Date actualFinishDate) {
			super.change(ACTUAL_FINISH_DATE,super.getActualFinishDate(),actualFinishDate);
			super.setActualFinishDate(actualFinishDate);
			return this;
		}
		
		/**
		 * 设置 费用
		 * @param cost 费用
		 * @return 当前对象
		*/
		public LeMaintenance setCost(BigDecimal cost) {
			super.change(COST,super.getCost(),cost);
			super.setCost(cost);
			return this;
		}
		
		/**
		 * 设置 报修内容
		 * @param content 报修内容
		 * @return 当前对象
		*/
		public LeMaintenance setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 报修人
		 * @param reportUserId 报修人
		 * @return 当前对象
		*/
		public LeMaintenance setReportUserId(String reportUserId) {
			super.change(REPORT_USER_ID,super.getReportUserId(),reportUserId);
			super.setReportUserId(reportUserId);
			return this;
		}
		
		/**
		 * 设置 报修人
		 * @param reportUserName 报修人
		 * @return 当前对象
		*/
		public LeMaintenance setReportUserName(String reportUserName) {
			super.change(REPORT_USER_NAME,super.getReportUserName(),reportUserName);
			super.setReportUserName(reportUserName);
			return this;
		}
		
		/**
		 * 设置 图片
		 * @param pictureId 图片
		 * @return 当前对象
		*/
		public LeMaintenance setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public LeMaintenance setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 业务日期
		 * @param businessDate 业务日期
		 * @return 当前对象
		*/
		public LeMaintenance setBusinessDate(Date businessDate) {
			super.change(BUSINESS_DATE,super.getBusinessDate(),businessDate);
			super.setBusinessDate(businessDate);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public LeMaintenance setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public LeMaintenance setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public LeMaintenance setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public LeMaintenance setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public LeMaintenance setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public LeMaintenance setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public LeMaintenance setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public LeMaintenance setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public LeMaintenance setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 选择数据
		 * @param selectedCode 选择数据
		 * @return 当前对象
		*/
		public LeMaintenance setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 车辆
		 * @param vehicleInfoList 车辆
		 * @return 当前对象
		*/
		public LeMaintenance setVehicleInfoList(List<Info> vehicleInfoList) {
			super.change(VEHICLE_INFO_LIST,super.getVehicleInfoList(),vehicleInfoList);
			super.setVehicleInfoList(vehicleInfoList);
			return this;
		}
		
		/**
		 * 设置 车辆列表
		 * @param vehicleInfoIds 车辆列表
		 * @return 当前对象
		*/
		public LeMaintenance setVehicleInfoIds(List<String> vehicleInfoIds) {
			super.change(VEHICLE_INFO_IDS,super.getVehicleInfoIds(),vehicleInfoIds);
			super.setVehicleInfoIds(vehicleInfoIds);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public LeMaintenance setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 报修类型
		 * @param maintenanceDict 报修类型
		 * @return 当前对象
		*/
		public LeMaintenance setMaintenanceDict(DictItem maintenanceDict) {
			super.change(MAINTENANCE_DICT,super.getMaintenanceDict(),maintenanceDict);
			super.setMaintenanceDict(maintenanceDict);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public LeMaintenance clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public LeMaintenance duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setProcId(this.getProcId());
			inst.setReportUserName(this.getReportUserName());
			inst.setType(this.getType());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setContent(this.getContent());
			inst.setBusinessDate(this.getBusinessDate());
			inst.setBusinessCode(this.getBusinessCode());
			inst.setPictureId(this.getPictureId());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setReportUserId(this.getReportUserId());
			inst.setId(this.getId());
			inst.setOriginatorId(this.getOriginatorId());
			inst.setCost(this.getCost());
			inst.setRepairStatus(this.getRepairStatus());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setActualFinishDate(this.getActualFinishDate());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setPlanFinishDate(this.getPlanFinishDate());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setVehicleInfoIds(this.getVehicleInfoIds());
				inst.setMaintenanceDict(this.getMaintenanceDict());
				inst.setVehicleInfoList(this.getVehicleInfoList());
				inst.setOriginator(this.getOriginator());
			}
			inst.clearModifies();
			return inst;
		}

	}
}