package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.InspectionPlanVO;
import java.util.List;
import com.dt.platform.domain.eam.InspectionPlan;
import java.util.Date;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.InspectionGroup;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.InspectionPlanPoint;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-27 21:17:17
 * @sign C12E698818D76C7C0BE49CF3827624B6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InspectionPlanVOMeta extends InspectionPlanMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 计划编号 , 类型: java.lang.String
	*/
	public static final String PLAN_CODE="planCode";
	
	/**
	 * 计划编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> PLAN_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,PLAN_CODE, java.lang.String.class, "计划编号", "计划编号", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String PLAN_STATUS="planStatus";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> PLAN_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,PLAN_STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 计划类型 , 类型: java.lang.String
	*/
	public static final String PLAN_TYPE="planType";
	
	/**
	 * 计划类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> PLAN_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,PLAN_TYPE, java.lang.String.class, "计划类型", "计划类型", java.lang.String.class, null);
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final String LEADER_ID="leaderId";
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> LEADER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,LEADER_ID, java.lang.String.class, "负责人", "负责人", java.lang.String.class, null);
	
	/**
	 * 班组 , 类型: java.lang.String
	*/
	public static final String GROUP_ID="groupId";
	
	/**
	 * 班组 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> GROUP_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,GROUP_ID, java.lang.String.class, "班组", "班组", java.lang.String.class, null);
	
	/**
	 * 开始日期 , 类型: java.util.Date
	*/
	public static final String START_DATE="startDate";
	
	/**
	 * 开始日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.util.Date> START_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,START_DATE, java.util.Date.class, "开始日期", "开始日期", java.util.Date.class, null);
	
	/**
	 * 截止日期 , 类型: java.util.Date
	*/
	public static final String END_DATE="endDate";
	
	/**
	 * 截止日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.util.Date> END_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,END_DATE, java.util.Date.class, "截止日期", "截止日期", java.util.Date.class, null);
	
	/**
	 * 巡检顺序 , 类型: java.lang.String
	*/
	public static final String INSPECTION_METHOD="inspectionMethod";
	
	/**
	 * 巡检顺序 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> INSPECTION_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,INSPECTION_METHOD, java.lang.String.class, "巡检顺序", "巡检顺序", java.lang.String.class, null);
	
	/**
	 * 巡检类型 , 类型: java.lang.String
	*/
	public static final String INSPECTION_TYPE="inspectionType";
	
	/**
	 * 巡检类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> INSPECTION_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,INSPECTION_TYPE, java.lang.String.class, "巡检类型", "巡检类型", java.lang.String.class, null);
	
	/**
	 * 时间要求 , 类型: java.math.BigDecimal
	*/
	public static final String COMPLETION_TIME="completionTime";
	
	/**
	 * 时间要求 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.math.BigDecimal> COMPLETION_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,COMPLETION_TIME, java.math.BigDecimal.class, "时间要求", "时间要求", java.math.BigDecimal.class, null);
	
	/**
	 * 超时处理 , 类型: java.lang.String
	*/
	public static final String OVERTIME_METHOD="overtimeMethod";
	
	/**
	 * 超时处理 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> OVERTIME_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,OVERTIME_METHOD, java.lang.String.class, "超时处理", "超时处理", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 班组 , 类型: com.dt.platform.domain.eam.InspectionGroup
	*/
	public static final String INSPECTION_GROUP="inspectionGroup";
	
	/**
	 * 班组 , 类型: com.dt.platform.domain.eam.InspectionGroup
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,com.dt.platform.domain.eam.InspectionGroup> INSPECTION_GROUP_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,INSPECTION_GROUP, com.dt.platform.domain.eam.InspectionGroup.class, "班组", "班组", com.dt.platform.domain.eam.InspectionGroup.class, null);
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String INSPECTION_TYPE_DICT="inspectionTypeDict";
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,org.github.foxnic.web.domain.system.DictItem> INSPECTION_TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,INSPECTION_TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "类型", "类型", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 巡检点 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.InspectionPlanPoint
	*/
	public static final String INSPECTION_PLAN_POINT_LIST="inspectionPlanPointList";
	
	/**
	 * 巡检点 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.InspectionPlanPoint
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,com.dt.platform.domain.eam.InspectionPlanPoint> INSPECTION_PLAN_POINT_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,INSPECTION_PLAN_POINT_LIST, java.util.List.class, "巡检点", "巡检点", com.dt.platform.domain.eam.InspectionPlanPoint.class, null);
	
	/**
	 * 巡检点 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String INSPECTION_PLAN_POINT_IDS="inspectionPlanPointIds";
	
	/**
	 * 巡检点 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionPlanVO,java.lang.String> INSPECTION_PLAN_POINT_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionPlanVO.class ,INSPECTION_PLAN_POINT_IDS, java.util.List.class, "巡检点", "巡检点", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , PLAN_CODE , NAME , STATUS , PLAN_STATUS , PLAN_TYPE , LEADER_ID , GROUP_ID , START_DATE , END_DATE , INSPECTION_METHOD , INSPECTION_TYPE , COMPLETION_TIME , OVERTIME_METHOD , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION , INSPECTION_GROUP , INSPECTION_TYPE_DICT , INSPECTION_PLAN_POINT_LIST , INSPECTION_PLAN_POINT_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.InspectionPlanVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public InspectionPlanVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public InspectionPlanVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public InspectionPlanVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public InspectionPlanVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public InspectionPlanVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public InspectionPlanVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public InspectionPlanVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public InspectionPlanVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public InspectionPlanVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public InspectionPlan setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 计划编号
		 * @param planCode 计划编号
		 * @return 当前对象
		*/
		public InspectionPlan setPlanCode(String planCode) {
			super.change(PLAN_CODE,super.getPlanCode(),planCode);
			super.setPlanCode(planCode);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public InspectionPlan setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public InspectionPlan setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param planStatus 状态
		 * @return 当前对象
		*/
		public InspectionPlan setPlanStatus(String planStatus) {
			super.change(PLAN_STATUS,super.getPlanStatus(),planStatus);
			super.setPlanStatus(planStatus);
			return this;
		}
		
		/**
		 * 设置 计划类型
		 * @param planType 计划类型
		 * @return 当前对象
		*/
		public InspectionPlan setPlanType(String planType) {
			super.change(PLAN_TYPE,super.getPlanType(),planType);
			super.setPlanType(planType);
			return this;
		}
		
		/**
		 * 设置 负责人
		 * @param leaderId 负责人
		 * @return 当前对象
		*/
		public InspectionPlan setLeaderId(String leaderId) {
			super.change(LEADER_ID,super.getLeaderId(),leaderId);
			super.setLeaderId(leaderId);
			return this;
		}
		
		/**
		 * 设置 班组
		 * @param groupId 班组
		 * @return 当前对象
		*/
		public InspectionPlan setGroupId(String groupId) {
			super.change(GROUP_ID,super.getGroupId(),groupId);
			super.setGroupId(groupId);
			return this;
		}
		
		/**
		 * 设置 开始日期
		 * @param startDate 开始日期
		 * @return 当前对象
		*/
		public InspectionPlan setStartDate(Date startDate) {
			super.change(START_DATE,super.getStartDate(),startDate);
			super.setStartDate(startDate);
			return this;
		}
		
		/**
		 * 设置 截止日期
		 * @param endDate 截止日期
		 * @return 当前对象
		*/
		public InspectionPlan setEndDate(Date endDate) {
			super.change(END_DATE,super.getEndDate(),endDate);
			super.setEndDate(endDate);
			return this;
		}
		
		/**
		 * 设置 巡检顺序
		 * @param inspectionMethod 巡检顺序
		 * @return 当前对象
		*/
		public InspectionPlan setInspectionMethod(String inspectionMethod) {
			super.change(INSPECTION_METHOD,super.getInspectionMethod(),inspectionMethod);
			super.setInspectionMethod(inspectionMethod);
			return this;
		}
		
		/**
		 * 设置 巡检类型
		 * @param inspectionType 巡检类型
		 * @return 当前对象
		*/
		public InspectionPlan setInspectionType(String inspectionType) {
			super.change(INSPECTION_TYPE,super.getInspectionType(),inspectionType);
			super.setInspectionType(inspectionType);
			return this;
		}
		
		/**
		 * 设置 时间要求
		 * @param completionTime 时间要求
		 * @return 当前对象
		*/
		public InspectionPlan setCompletionTime(BigDecimal completionTime) {
			super.change(COMPLETION_TIME,super.getCompletionTime(),completionTime);
			super.setCompletionTime(completionTime);
			return this;
		}
		
		/**
		 * 设置 超时处理
		 * @param overtimeMethod 超时处理
		 * @return 当前对象
		*/
		public InspectionPlan setOvertimeMethod(String overtimeMethod) {
			super.change(OVERTIME_METHOD,super.getOvertimeMethod(),overtimeMethod);
			super.setOvertimeMethod(overtimeMethod);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public InspectionPlan setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public InspectionPlan setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public InspectionPlan setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public InspectionPlan setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public InspectionPlan setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public InspectionPlan setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public InspectionPlan setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public InspectionPlan setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public InspectionPlan setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public InspectionPlan setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 班组
		 * @param inspectionGroup 班组
		 * @return 当前对象
		*/
		public InspectionPlan setInspectionGroup(InspectionGroup inspectionGroup) {
			super.change(INSPECTION_GROUP,super.getInspectionGroup(),inspectionGroup);
			super.setInspectionGroup(inspectionGroup);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param inspectionTypeDict 类型
		 * @return 当前对象
		*/
		public InspectionPlan setInspectionTypeDict(DictItem inspectionTypeDict) {
			super.change(INSPECTION_TYPE_DICT,super.getInspectionTypeDict(),inspectionTypeDict);
			super.setInspectionTypeDict(inspectionTypeDict);
			return this;
		}
		
		/**
		 * 设置 巡检点
		 * @param inspectionPlanPointList 巡检点
		 * @return 当前对象
		*/
		public InspectionPlan setInspectionPlanPointList(List<InspectionPlanPoint> inspectionPlanPointList) {
			super.change(INSPECTION_PLAN_POINT_LIST,super.getInspectionPlanPointList(),inspectionPlanPointList);
			super.setInspectionPlanPointList(inspectionPlanPointList);
			return this;
		}
		
		/**
		 * 设置 巡检点
		 * @param inspectionPlanPointIds 巡检点
		 * @return 当前对象
		*/
		public InspectionPlan setInspectionPlanPointIds(List<String> inspectionPlanPointIds) {
			super.change(INSPECTION_PLAN_POINT_IDS,super.getInspectionPlanPointIds(),inspectionPlanPointIds);
			super.setInspectionPlanPointIds(inspectionPlanPointIds);
			return this;
		}
	}
}