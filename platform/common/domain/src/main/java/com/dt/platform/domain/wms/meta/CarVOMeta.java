package com.dt.platform.domain.wms.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.wms.CarVO;
import java.util.List;
import com.dt.platform.domain.wms.Car;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 15:01:45
 * @sign DE0A22158B7A9322643D6B00CC62DBF3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CarVOMeta extends CarMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 车号 , 类型: java.lang.String
	*/
	public static final String CAR_NUMBER="carNumber";
	
	/**
	 * 车号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> CAR_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,CAR_NUMBER, java.lang.String.class, "车号", "车号", java.lang.String.class, null);
	
	/**
	 * 车型 , 类型: java.lang.String
	*/
	public static final String CAR_MODEL="carModel";
	
	/**
	 * 车型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> CAR_MODEL_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,CAR_MODEL, java.lang.String.class, "车型", "车型", java.lang.String.class, null);
	
	/**
	 * 最大载重 , 类型: java.math.BigDecimal
	*/
	public static final String MAX_WEIGHT="maxWeight";
	
	/**
	 * 最大载重 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.math.BigDecimal> MAX_WEIGHT_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,MAX_WEIGHT, java.math.BigDecimal.class, "最大载重", "最大载重", java.math.BigDecimal.class, null);
	
	/**
	 * 最大体积 , 类型: java.math.BigDecimal
	*/
	public static final String MAX_VOLUMN="maxVolumn";
	
	/**
	 * 最大体积 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.math.BigDecimal> MAX_VOLUMN_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,MAX_VOLUMN, java.math.BigDecimal.class, "最大体积", "最大体积", java.math.BigDecimal.class, null);
	
	/**
	 * 载人数 , 类型: java.math.BigDecimal
	*/
	public static final String MAX_PEOPLE="maxPeople";
	
	/**
	 * 载人数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.math.BigDecimal> MAX_PEOPLE_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,MAX_PEOPLE, java.math.BigDecimal.class, "载人数", "载人数", java.math.BigDecimal.class, null);
	
	/**
	 * 驾照 , 类型: java.lang.String
	*/
	public static final String DRIVE_NUMBER="driveNumber";
	
	/**
	 * 驾照 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> DRIVE_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,DRIVE_NUMBER, java.lang.String.class, "驾照", "驾照", java.lang.String.class, null);
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final String USER="user";
	
	/**
	 * 姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> USER_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,USER, java.lang.String.class, "姓名", "姓名", java.lang.String.class, null);
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final String MOBILE="mobile";
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> MOBILE_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,MOBILE, java.lang.String.class, "联系方式", "联系方式", java.lang.String.class, null);
	
	/**
	 * 车牌 , 类型: java.lang.String
	*/
	public static final String CAR_VALUE="carValue";
	
	/**
	 * 车牌 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> CAR_VALUE_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,CAR_VALUE, java.lang.String.class, "车牌", "车牌", java.lang.String.class, null);
	
	/**
	 * 区域 , 类型: java.lang.String
	*/
	public static final String AREA="area";
	
	/**
	 * 区域 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> AREA_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,AREA, java.lang.String.class, "区域", "区域", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.CarVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.wms.CarVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , CAR_NUMBER , CAR_MODEL , MAX_WEIGHT , MAX_VOLUMN , MAX_PEOPLE , DRIVE_NUMBER , USER , MOBILE , CAR_VALUE , AREA , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.wms.CarVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public CarVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public CarVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public CarVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public CarVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public CarVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public CarVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public CarVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public CarVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public CarVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public CarVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public CarVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public CarVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Car setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 车号
		 * @param carNumber 车号
		 * @return 当前对象
		*/
		public Car setCarNumber(String carNumber) {
			super.change(CAR_NUMBER,super.getCarNumber(),carNumber);
			super.setCarNumber(carNumber);
			return this;
		}
		
		/**
		 * 设置 车型
		 * @param carModel 车型
		 * @return 当前对象
		*/
		public Car setCarModel(String carModel) {
			super.change(CAR_MODEL,super.getCarModel(),carModel);
			super.setCarModel(carModel);
			return this;
		}
		
		/**
		 * 设置 最大载重
		 * @param maxWeight 最大载重
		 * @return 当前对象
		*/
		public Car setMaxWeight(BigDecimal maxWeight) {
			super.change(MAX_WEIGHT,super.getMaxWeight(),maxWeight);
			super.setMaxWeight(maxWeight);
			return this;
		}
		
		/**
		 * 设置 最大体积
		 * @param maxVolumn 最大体积
		 * @return 当前对象
		*/
		public Car setMaxVolumn(BigDecimal maxVolumn) {
			super.change(MAX_VOLUMN,super.getMaxVolumn(),maxVolumn);
			super.setMaxVolumn(maxVolumn);
			return this;
		}
		
		/**
		 * 设置 载人数
		 * @param maxPeople 载人数
		 * @return 当前对象
		*/
		public Car setMaxPeople(BigDecimal maxPeople) {
			super.change(MAX_PEOPLE,super.getMaxPeople(),maxPeople);
			super.setMaxPeople(maxPeople);
			return this;
		}
		
		/**
		 * 设置 驾照
		 * @param driveNumber 驾照
		 * @return 当前对象
		*/
		public Car setDriveNumber(String driveNumber) {
			super.change(DRIVE_NUMBER,super.getDriveNumber(),driveNumber);
			super.setDriveNumber(driveNumber);
			return this;
		}
		
		/**
		 * 设置 姓名
		 * @param user 姓名
		 * @return 当前对象
		*/
		public Car setUser(String user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
		}
		
		/**
		 * 设置 联系方式
		 * @param mobile 联系方式
		 * @return 当前对象
		*/
		public Car setMobile(String mobile) {
			super.change(MOBILE,super.getMobile(),mobile);
			super.setMobile(mobile);
			return this;
		}
		
		/**
		 * 设置 车牌
		 * @param carValue 车牌
		 * @return 当前对象
		*/
		public Car setCarValue(String carValue) {
			super.change(CAR_VALUE,super.getCarValue(),carValue);
			super.setCarValue(carValue);
			return this;
		}
		
		/**
		 * 设置 区域
		 * @param area 区域
		 * @return 当前对象
		*/
		public Car setArea(String area) {
			super.change(AREA,super.getArea(),area);
			super.setArea(area);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public Car setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Car setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Car setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Car setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Car setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Car setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Car setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Car setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Car setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Car setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CarVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CarVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setArea(this.getArea());
			inst.setNotes(this.getNotes());
			inst.setMobile(this.getMobile());
			inst.setDriveNumber(this.getDriveNumber());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setMaxWeight(this.getMaxWeight());
			inst.setVersion(this.getVersion());
			inst.setCarNumber(this.getCarNumber());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setMaxVolumn(this.getMaxVolumn());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setMaxPeople(this.getMaxPeople());
			inst.setUser(this.getUser());
			inst.setCarModel(this.getCarModel());
			inst.setCarValue(this.getCarValue());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setPageSize(this.getPageSize());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}