package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.CheckSelect;
import java.util.Date;
import com.dt.platform.domain.eam.CheckItem;
import com.dt.platform.domain.eam.InspectionTask;
import com.dt.platform.domain.eam.InspectionPoint;
import com.dt.platform.domain.eam.InspectionTaskPoint;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-07 10:52:29
 * @sign 45A38C90D8DEE577C098CA90879E2E95
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CheckSelectMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final String TASK_ID="taskId";
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.String> TASK_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,TASK_ID, java.lang.String.class, "任务", "任务", java.lang.String.class, null);
	
	/**
	 * 巡检点位 , 类型: java.lang.String
	*/
	public static final String TASK_POINT_ID="taskPointId";
	
	/**
	 * 巡检点位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.String> TASK_POINT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,TASK_POINT_ID, java.lang.String.class, "巡检点位", "巡检点位", java.lang.String.class, null);
	
	/**
	 * 巡检点位 , 类型: java.lang.String
	*/
	public static final String POINT_ID="pointId";
	
	/**
	 * 巡检点位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.String> POINT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,POINT_ID, java.lang.String.class, "巡检点位", "巡检点位", java.lang.String.class, null);
	
	/**
	 * 是否检查 , 类型: java.lang.String
	*/
	public static final String IF_CHECK="ifCheck";
	
	/**
	 * 是否检查 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.String> IF_CHECK_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,IF_CHECK, java.lang.String.class, "是否检查", "是否检查", java.lang.String.class, null);
	
	/**
	 * 组件类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 组件类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,TYPE, java.lang.String.class, "组件类型", "组件类型", java.lang.String.class, null);
	
	/**
	 * 检查项 , 类型: java.lang.String
	*/
	public static final String ITEM_ID="itemId";
	
	/**
	 * 检查项 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.String> ITEM_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,ITEM_ID, java.lang.String.class, "检查项", "检查项", java.lang.String.class, null);
	
	/**
	 * 检查项编码 , 类型: java.lang.String
	*/
	public static final String ITEM_CODE="itemCode";
	
	/**
	 * 检查项编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.String> ITEM_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,ITEM_CODE, java.lang.String.class, "检查项编码", "检查项编码", java.lang.String.class, null);
	
	/**
	 * 检查项 , 类型: java.lang.String
	*/
	public static final String ITEM_NAME="itemName";
	
	/**
	 * 检查项 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.String> ITEM_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,ITEM_NAME, java.lang.String.class, "检查项", "检查项", java.lang.String.class, null);
	
	/**
	 * 检查项描述 , 类型: java.lang.String
	*/
	public static final String ITEM_DESC="itemDesc";
	
	/**
	 * 检查项描述 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.String> ITEM_DESC_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,ITEM_DESC, java.lang.String.class, "检查项描述", "检查项描述", java.lang.String.class, null);
	
	/**
	 * 检查结果 , 类型: java.lang.String
	*/
	public static final String RESULT="result";
	
	/**
	 * 检查结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.String> RESULT_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,RESULT, java.lang.String.class, "检查结果", "检查结果", java.lang.String.class, null);
	
	/**
	 * 内容元数据 , 类型: java.lang.String
	*/
	public static final String RESULT_META_DATA="resultMetaData";
	
	/**
	 * 内容元数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.String> RESULT_META_DATA_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,RESULT_META_DATA, java.lang.String.class, "内容元数据", "内容元数据", java.lang.String.class, null);
	
	/**
	 * 配置项 , 类型: java.lang.String
	*/
	public static final String CONFIG="config";
	
	/**
	 * 配置项 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.String> CONFIG_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,CONFIG, java.lang.String.class, "配置项", "配置项", java.lang.String.class, null);
	
	/**
	 * 默认值 , 类型: java.lang.String
	*/
	public static final String CONFIG_DEF_VALUE="configDefValue";
	
	/**
	 * 默认值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.String> CONFIG_DEF_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,CONFIG_DEF_VALUE, java.lang.String.class, "默认值", "默认值", java.lang.String.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.Integer> SORT_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,SORT, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * checkItem , 类型: com.dt.platform.domain.eam.CheckItem
	*/
	public static final String CHECK_ITEM="checkItem";
	
	/**
	 * checkItem , 类型: com.dt.platform.domain.eam.CheckItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,com.dt.platform.domain.eam.CheckItem> CHECK_ITEM_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,CHECK_ITEM, com.dt.platform.domain.eam.CheckItem.class, "checkItem", "checkItem", com.dt.platform.domain.eam.CheckItem.class, null);
	
	/**
	 * inspectionTask , 类型: com.dt.platform.domain.eam.InspectionTask
	*/
	public static final String INSPECTION_TASK="inspectionTask";
	
	/**
	 * inspectionTask , 类型: com.dt.platform.domain.eam.InspectionTask
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,com.dt.platform.domain.eam.InspectionTask> INSPECTION_TASK_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,INSPECTION_TASK, com.dt.platform.domain.eam.InspectionTask.class, "inspectionTask", "inspectionTask", com.dt.platform.domain.eam.InspectionTask.class, null);
	
	/**
	 * inspectionPoint , 类型: com.dt.platform.domain.eam.InspectionPoint
	*/
	public static final String INSPECTION_POINT="inspectionPoint";
	
	/**
	 * inspectionPoint , 类型: com.dt.platform.domain.eam.InspectionPoint
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,com.dt.platform.domain.eam.InspectionPoint> INSPECTION_POINT_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,INSPECTION_POINT, com.dt.platform.domain.eam.InspectionPoint.class, "inspectionPoint", "inspectionPoint", com.dt.platform.domain.eam.InspectionPoint.class, null);
	
	/**
	 * inspectionTaskPoint , 类型: com.dt.platform.domain.eam.InspectionTaskPoint
	*/
	public static final String INSPECTION_TASK_POINT="inspectionTaskPoint";
	
	/**
	 * inspectionTaskPoint , 类型: com.dt.platform.domain.eam.InspectionTaskPoint
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CheckSelect,com.dt.platform.domain.eam.InspectionTaskPoint> INSPECTION_TASK_POINT_PROP = new BeanProperty(com.dt.platform.domain.eam.CheckSelect.class ,INSPECTION_TASK_POINT, com.dt.platform.domain.eam.InspectionTaskPoint.class, "inspectionTaskPoint", "inspectionTaskPoint", com.dt.platform.domain.eam.InspectionTaskPoint.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TASK_ID , TASK_POINT_ID , POINT_ID , IF_CHECK , TYPE , ITEM_ID , ITEM_CODE , ITEM_NAME , ITEM_DESC , RESULT , RESULT_META_DATA , CONFIG , CONFIG_DEF_VALUE , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , CHECK_ITEM , INSPECTION_TASK , INSPECTION_POINT , INSPECTION_TASK_POINT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.CheckSelect {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CheckSelect setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 任务
		 * @param taskId 任务
		 * @return 当前对象
		*/
		public CheckSelect setTaskId(String taskId) {
			super.change(TASK_ID,super.getTaskId(),taskId);
			super.setTaskId(taskId);
			return this;
		}
		
		/**
		 * 设置 巡检点位
		 * @param taskPointId 巡检点位
		 * @return 当前对象
		*/
		public CheckSelect setTaskPointId(String taskPointId) {
			super.change(TASK_POINT_ID,super.getTaskPointId(),taskPointId);
			super.setTaskPointId(taskPointId);
			return this;
		}
		
		/**
		 * 设置 巡检点位
		 * @param pointId 巡检点位
		 * @return 当前对象
		*/
		public CheckSelect setPointId(String pointId) {
			super.change(POINT_ID,super.getPointId(),pointId);
			super.setPointId(pointId);
			return this;
		}
		
		/**
		 * 设置 是否检查
		 * @param ifCheck 是否检查
		 * @return 当前对象
		*/
		public CheckSelect setIfCheck(String ifCheck) {
			super.change(IF_CHECK,super.getIfCheck(),ifCheck);
			super.setIfCheck(ifCheck);
			return this;
		}
		
		/**
		 * 设置 组件类型
		 * @param type 组件类型
		 * @return 当前对象
		*/
		public CheckSelect setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 检查项
		 * @param itemId 检查项
		 * @return 当前对象
		*/
		public CheckSelect setItemId(String itemId) {
			super.change(ITEM_ID,super.getItemId(),itemId);
			super.setItemId(itemId);
			return this;
		}
		
		/**
		 * 设置 检查项编码
		 * @param itemCode 检查项编码
		 * @return 当前对象
		*/
		public CheckSelect setItemCode(String itemCode) {
			super.change(ITEM_CODE,super.getItemCode(),itemCode);
			super.setItemCode(itemCode);
			return this;
		}
		
		/**
		 * 设置 检查项
		 * @param itemName 检查项
		 * @return 当前对象
		*/
		public CheckSelect setItemName(String itemName) {
			super.change(ITEM_NAME,super.getItemName(),itemName);
			super.setItemName(itemName);
			return this;
		}
		
		/**
		 * 设置 检查项描述
		 * @param itemDesc 检查项描述
		 * @return 当前对象
		*/
		public CheckSelect setItemDesc(String itemDesc) {
			super.change(ITEM_DESC,super.getItemDesc(),itemDesc);
			super.setItemDesc(itemDesc);
			return this;
		}
		
		/**
		 * 设置 检查结果
		 * @param result 检查结果
		 * @return 当前对象
		*/
		public CheckSelect setResult(String result) {
			super.change(RESULT,super.getResult(),result);
			super.setResult(result);
			return this;
		}
		
		/**
		 * 设置 内容元数据
		 * @param resultMetaData 内容元数据
		 * @return 当前对象
		*/
		public CheckSelect setResultMetaData(String resultMetaData) {
			super.change(RESULT_META_DATA,super.getResultMetaData(),resultMetaData);
			super.setResultMetaData(resultMetaData);
			return this;
		}
		
		/**
		 * 设置 配置项
		 * @param config 配置项
		 * @return 当前对象
		*/
		public CheckSelect setConfig(String config) {
			super.change(CONFIG,super.getConfig(),config);
			super.setConfig(config);
			return this;
		}
		
		/**
		 * 设置 默认值
		 * @param configDefValue 默认值
		 * @return 当前对象
		*/
		public CheckSelect setConfigDefValue(String configDefValue) {
			super.change(CONFIG_DEF_VALUE,super.getConfigDefValue(),configDefValue);
			super.setConfigDefValue(configDefValue);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sort 排序
		 * @return 当前对象
		*/
		public CheckSelect setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CheckSelect setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CheckSelect setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CheckSelect setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CheckSelect setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CheckSelect setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CheckSelect setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CheckSelect setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public CheckSelect setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 checkItem
		 * @param checkItem checkItem
		 * @return 当前对象
		*/
		public CheckSelect setCheckItem(CheckItem checkItem) {
			super.change(CHECK_ITEM,super.getCheckItem(),checkItem);
			super.setCheckItem(checkItem);
			return this;
		}
		
		/**
		 * 设置 inspectionTask
		 * @param inspectionTask inspectionTask
		 * @return 当前对象
		*/
		public CheckSelect setInspectionTask(InspectionTask inspectionTask) {
			super.change(INSPECTION_TASK,super.getInspectionTask(),inspectionTask);
			super.setInspectionTask(inspectionTask);
			return this;
		}
		
		/**
		 * 设置 inspectionPoint
		 * @param inspectionPoint inspectionPoint
		 * @return 当前对象
		*/
		public CheckSelect setInspectionPoint(InspectionPoint inspectionPoint) {
			super.change(INSPECTION_POINT,super.getInspectionPoint(),inspectionPoint);
			super.setInspectionPoint(inspectionPoint);
			return this;
		}
		
		/**
		 * 设置 inspectionTaskPoint
		 * @param inspectionTaskPoint inspectionTaskPoint
		 * @return 当前对象
		*/
		public CheckSelect setInspectionTaskPoint(InspectionTaskPoint inspectionTaskPoint) {
			super.change(INSPECTION_TASK_POINT,super.getInspectionTaskPoint(),inspectionTaskPoint);
			super.setInspectionTaskPoint(inspectionTaskPoint);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CheckSelect clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CheckSelect duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setConfigDefValue(this.getConfigDefValue());
			inst.setItemCode(this.getItemCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setSort(this.getSort());
			inst.setType(this.getType());
			inst.setItemDesc(this.getItemDesc());
			inst.setVersion(this.getVersion());
			inst.setTaskPointId(this.getTaskPointId());
			inst.setResult(this.getResult());
			inst.setItemId(this.getItemId());
			inst.setItemName(this.getItemName());
			inst.setCreateBy(this.getCreateBy());
			inst.setResultMetaData(this.getResultMetaData());
			inst.setDeleted(this.getDeleted());
			inst.setPointId(this.getPointId());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setIfCheck(this.getIfCheck());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setConfig(this.getConfig());
			inst.setTaskId(this.getTaskId());
			if(all) {
				inst.setCheckItem(this.getCheckItem());
				inst.setInspectionTaskPoint(this.getInspectionTaskPoint());
				inst.setInspectionPoint(this.getInspectionPoint());
				inst.setInspectionTask(this.getInspectionTask());
			}
			inst.clearModifies();
			return inst;
		}

	}
}