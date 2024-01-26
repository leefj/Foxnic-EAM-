package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.SalaryTplVO;
import java.util.List;
import com.dt.platform.domain.hr.SalaryTpl;
import java.util.Date;
import com.dt.platform.domain.hr.SalaryTplItem;
import com.dt.platform.domain.hr.SalaryDetail;
import com.dt.platform.domain.hr.Person;
import java.math.BigDecimal;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-26 23:28:02
 * @sign E9A4577E510BAAF3C8CD5EBD445BE499
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SalaryTplVOMeta extends SalaryTplMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,CODE, java.lang.String.class, "编号", "编号", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 开始上月 , 类型: java.lang.Integer
	*/
	public static final String START_M_DAY="startMDay";
	
	/**
	 * 开始上月 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.Integer> START_M_DAY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,START_M_DAY, java.lang.Integer.class, "开始上月", "开始上月", java.lang.Integer.class, null);
	
	/**
	 * 结束本月 , 类型: java.lang.Integer
	*/
	public static final String END_M_DAY="endMDay";
	
	/**
	 * 结束本月 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.Integer> END_M_DAY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,END_M_DAY, java.lang.Integer.class, "结束本月", "结束本月", java.lang.Integer.class, null);
	
	/**
	 * 计算公式 , 类型: java.lang.String
	*/
	public static final String METHOD="method";
	
	/**
	 * 计算公式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> METHOD_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,METHOD, java.lang.String.class, "计算公式", "计算公式", java.lang.String.class, null);
	
	/**
	 * 计算公式 , 类型: java.lang.String
	*/
	public static final String METHOD_SCRIPT="methodScript";
	
	/**
	 * 计算公式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> METHOD_SCRIPT_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,METHOD_SCRIPT, java.lang.String.class, "计算公式", "计算公式", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * salaryTplItem , 集合类型: LIST , 类型: com.dt.platform.domain.hr.SalaryTplItem
	*/
	public static final String SALARY_TPL_ITEM="salaryTplItem";
	
	/**
	 * salaryTplItem , 集合类型: LIST , 类型: com.dt.platform.domain.hr.SalaryTplItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,com.dt.platform.domain.hr.SalaryTplItem> SALARY_TPL_ITEM_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,SALARY_TPL_ITEM, java.util.List.class, "salaryTplItem", "salaryTplItem", com.dt.platform.domain.hr.SalaryTplItem.class, null);
	
	/**
	 * validSalaryTplItem , 集合类型: LIST , 类型: com.dt.platform.domain.hr.SalaryTplItem
	*/
	public static final String VALID_SALARY_TPL_ITEM="validSalaryTplItem";
	
	/**
	 * validSalaryTplItem , 集合类型: LIST , 类型: com.dt.platform.domain.hr.SalaryTplItem
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,com.dt.platform.domain.hr.SalaryTplItem> VALID_SALARY_TPL_ITEM_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,VALID_SALARY_TPL_ITEM, java.util.List.class, "validSalaryTplItem", "validSalaryTplItem", com.dt.platform.domain.hr.SalaryTplItem.class, null);
	
	/**
	 * SalaryDetailList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.SalaryDetail
	*/
	public static final String SALARY_DETAIL_LIST="SalaryDetailList";
	
	/**
	 * SalaryDetailList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.SalaryDetail
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,com.dt.platform.domain.hr.SalaryDetail> SALARY_DETAIL_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,SALARY_DETAIL_LIST, java.util.List.class, "SalaryDetailList", "SalaryDetailList", com.dt.platform.domain.hr.SalaryDetail.class, null);
	
	/**
	 * personList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final String PERSON_LIST="personList";
	
	/**
	 * personList , 集合类型: LIST , 类型: com.dt.platform.domain.hr.Person
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,com.dt.platform.domain.hr.Person> PERSON_LIST_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,PERSON_LIST, java.util.List.class, "personList", "personList", com.dt.platform.domain.hr.Person.class, null);
	
	/**
	 * confNonConversionRatio , 类型: java.math.BigDecimal
	*/
	public static final String CONF_NON_CONVERSION_RATIO="confNonConversionRatio";
	
	/**
	 * confNonConversionRatio , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.SalaryTplVO,java.math.BigDecimal> CONF_NON_CONVERSION_RATIO_PROP = new BeanProperty(com.dt.platform.domain.hr.SalaryTplVO.class ,CONF_NON_CONVERSION_RATIO, java.math.BigDecimal.class, "confNonConversionRatio", "confNonConversionRatio", java.math.BigDecimal.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , CODE , NAME , START_M_DAY , END_M_DAY , METHOD , METHOD_SCRIPT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SALARY_TPL_ITEM , VALID_SALARY_TPL_ITEM , SALARY_DETAIL_LIST , PERSON_LIST , CONF_NON_CONVERSION_RATIO };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.SalaryTplVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public SalaryTplVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public SalaryTplVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public SalaryTplVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public SalaryTplVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public SalaryTplVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public SalaryTplVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public SalaryTplVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public SalaryTplVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public SalaryTplVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public SalaryTplVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public SalaryTplVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public SalaryTplVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public SalaryTpl setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编号
		 * @param code 编号
		 * @return 当前对象
		*/
		public SalaryTpl setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public SalaryTpl setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 开始上月
		 * @param startMDay 开始上月
		 * @return 当前对象
		*/
		public SalaryTpl setStartMDay(Integer startMDay) {
			super.change(START_M_DAY,super.getStartMDay(),startMDay);
			super.setStartMDay(startMDay);
			return this;
		}
		
		/**
		 * 设置 结束本月
		 * @param endMDay 结束本月
		 * @return 当前对象
		*/
		public SalaryTpl setEndMDay(Integer endMDay) {
			super.change(END_M_DAY,super.getEndMDay(),endMDay);
			super.setEndMDay(endMDay);
			return this;
		}
		
		/**
		 * 设置 计算公式
		 * @param method 计算公式
		 * @return 当前对象
		*/
		public SalaryTpl setMethod(String method) {
			super.change(METHOD,super.getMethod(),method);
			super.setMethod(method);
			return this;
		}
		
		/**
		 * 设置 计算公式
		 * @param methodScript 计算公式
		 * @return 当前对象
		*/
		public SalaryTpl setMethodScript(String methodScript) {
			super.change(METHOD_SCRIPT,super.getMethodScript(),methodScript);
			super.setMethodScript(methodScript);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public SalaryTpl setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SalaryTpl setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SalaryTpl setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SalaryTpl setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SalaryTpl setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SalaryTpl setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SalaryTpl setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SalaryTpl setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public SalaryTpl setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public SalaryTpl setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 salaryTplItem
		 * @param salaryTplItem salaryTplItem
		 * @return 当前对象
		*/
		public SalaryTpl setSalaryTplItem(List<SalaryTplItem> salaryTplItem) {
			super.change(SALARY_TPL_ITEM,super.getSalaryTplItem(),salaryTplItem);
			super.setSalaryTplItem(salaryTplItem);
			return this;
		}
		
		/**
		 * 设置 validSalaryTplItem
		 * @param validSalaryTplItem validSalaryTplItem
		 * @return 当前对象
		*/
		public SalaryTpl setValidSalaryTplItem(List<SalaryTplItem> validSalaryTplItem) {
			super.change(VALID_SALARY_TPL_ITEM,super.getValidSalaryTplItem(),validSalaryTplItem);
			super.setValidSalaryTplItem(validSalaryTplItem);
			return this;
		}
		
		/**
		 * 设置 SalaryDetailList
		 * @param SalaryDetailList SalaryDetailList
		 * @return 当前对象
		*/
		public SalaryTpl setSalaryDetailList(List<SalaryDetail> SalaryDetailList) {
			super.change(SALARY_DETAIL_LIST,super.getSalaryDetailList(),SalaryDetailList);
			super.setSalaryDetailList(SalaryDetailList);
			return this;
		}
		
		/**
		 * 设置 personList
		 * @param personList personList
		 * @return 当前对象
		*/
		public SalaryTpl setPersonList(List<Person> personList) {
			super.change(PERSON_LIST,super.getPersonList(),personList);
			super.setPersonList(personList);
			return this;
		}
		
		/**
		 * 设置 confNonConversionRatio
		 * @param confNonConversionRatio confNonConversionRatio
		 * @return 当前对象
		*/
		public SalaryTpl setConfNonConversionRatio(BigDecimal confNonConversionRatio) {
			super.change(CONF_NON_CONVERSION_RATIO,super.getConfNonConversionRatio(),confNonConversionRatio);
			super.setConfNonConversionRatio(confNonConversionRatio);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public SalaryTplVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public SalaryTplVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setStartMDay(this.getStartMDay());
			inst.setMethodScript(this.getMethodScript());
			inst.setCode(this.getCode());
			inst.setNotes(this.getNotes());
			inst.setMethod(this.getMethod());
			inst.setEndMDay(this.getEndMDay());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			if(all) {
				inst.setPersonList(this.getPersonList());
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setConfNonConversionRatio(this.getConfNonConversionRatio());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setSalaryTplItem(this.getSalaryTplItem());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setValidSalaryTplItem(this.getValidSalaryTplItem());
				inst.setSalaryDetailList(this.getSalaryDetailList());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}