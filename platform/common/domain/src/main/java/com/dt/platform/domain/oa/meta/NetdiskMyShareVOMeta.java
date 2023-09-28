package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.NetdiskMyShareVO;
import java.util.List;
import com.dt.platform.domain.oa.NetdiskMyShare;
import java.util.Date;
import com.dt.platform.domain.oa.NetdiskFile;
import com.dt.platform.domain.oa.NetdiskOriginFile;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-28 13:31:43
 * @sign C29190DDDFFE56E5369150C0E2CD7B95
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class NetdiskMyShareVOMeta extends NetdiskMyShareMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,USER_ID, java.lang.String.class, "用户", "用户", java.lang.String.class, null);
	
	/**
	 * 文件 , 类型: java.lang.String
	*/
	public static final String FILE_ID="fileId";
	
	/**
	 * 文件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> FILE_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,FILE_ID, java.lang.String.class, "文件", "文件", java.lang.String.class, null);
	
	/**
	 * 链接 , 类型: java.lang.String
	*/
	public static final String FILE_URL="fileUrl";
	
	/**
	 * 链接 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> FILE_URL_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,FILE_URL, java.lang.String.class, "链接", "链接", java.lang.String.class, null);
	
	/**
	 * 文件 , 类型: java.lang.String
	*/
	public static final String FD_ID="fdId";
	
	/**
	 * 文件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> FD_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,FD_ID, java.lang.String.class, "文件", "文件", java.lang.String.class, null);
	
	/**
	 * 文件类型 , 类型: java.lang.String
	*/
	public static final String FD_TYPE="fdType";
	
	/**
	 * 文件类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> FD_TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,FD_TYPE, java.lang.String.class, "文件类型", "文件类型", java.lang.String.class, null);
	
	/**
	 * 过期时间 , 类型: java.util.Date
	*/
	public static final String EXPIRATION_TIME="expirationTime";
	
	/**
	 * 过期时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.util.Date> EXPIRATION_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,EXPIRATION_TIME, java.util.Date.class, "过期时间", "过期时间", java.util.Date.class, null);
	
	/**
	 * 过期方式 , 类型: java.lang.String
	*/
	public static final String EXPIRATION_METHOD="expirationMethod";
	
	/**
	 * 过期方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> EXPIRATION_METHOD_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,EXPIRATION_METHOD, java.lang.String.class, "过期方式", "过期方式", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 状态 , valid|expired|delete , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , valid|expired|delete , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,STATUS, java.lang.String.class, "状态", "valid|expired|delete", java.lang.String.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * netdiskFile , 类型: com.dt.platform.domain.oa.NetdiskFile
	*/
	public static final String NETDISK_FILE="netdiskFile";
	
	/**
	 * netdiskFile , 类型: com.dt.platform.domain.oa.NetdiskFile
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,com.dt.platform.domain.oa.NetdiskFile> NETDISK_FILE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,NETDISK_FILE, com.dt.platform.domain.oa.NetdiskFile.class, "netdiskFile", "netdiskFile", com.dt.platform.domain.oa.NetdiskFile.class, null);
	
	/**
	 * netdiskOriginFile , 类型: com.dt.platform.domain.oa.NetdiskOriginFile
	*/
	public static final String NETDISK_ORIGIN_FILE="netdiskOriginFile";
	
	/**
	 * netdiskOriginFile , 类型: com.dt.platform.domain.oa.NetdiskOriginFile
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,com.dt.platform.domain.oa.NetdiskOriginFile> NETDISK_ORIGIN_FILE_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,NETDISK_ORIGIN_FILE, com.dt.platform.domain.oa.NetdiskOriginFile.class, "netdiskOriginFile", "netdiskOriginFile", com.dt.platform.domain.oa.NetdiskOriginFile.class, null);
	
	/**
	 * ownerUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String OWNER_USER="ownerUser";
	
	/**
	 * ownerUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.NetdiskMyShareVO,org.github.foxnic.web.domain.hrm.Employee> OWNER_USER_PROP = new BeanProperty(com.dt.platform.domain.oa.NetdiskMyShareVO.class ,OWNER_USER, org.github.foxnic.web.domain.hrm.Employee.class, "ownerUser", "ownerUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , USER_ID , FILE_ID , FILE_URL , FD_ID , FD_TYPE , EXPIRATION_TIME , EXPIRATION_METHOD , TYPE , STATUS , VERSION , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , NETDISK_FILE , NETDISK_ORIGIN_FILE , OWNER_USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.NetdiskMyShareVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public NetdiskMyShareVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public NetdiskMyShareVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public NetdiskMyShareVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public NetdiskMyShareVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public NetdiskMyShareVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public NetdiskMyShareVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public NetdiskMyShareVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public NetdiskMyShareVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public NetdiskMyShareVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public NetdiskMyShareVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public NetdiskMyShareVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public NetdiskMyShareVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public NetdiskMyShare setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 用户
		 * @param userId 用户
		 * @return 当前对象
		*/
		public NetdiskMyShare setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 文件
		 * @param fileId 文件
		 * @return 当前对象
		*/
		public NetdiskMyShare setFileId(String fileId) {
			super.change(FILE_ID,super.getFileId(),fileId);
			super.setFileId(fileId);
			return this;
		}
		
		/**
		 * 设置 链接
		 * @param fileUrl 链接
		 * @return 当前对象
		*/
		public NetdiskMyShare setFileUrl(String fileUrl) {
			super.change(FILE_URL,super.getFileUrl(),fileUrl);
			super.setFileUrl(fileUrl);
			return this;
		}
		
		/**
		 * 设置 文件
		 * @param fdId 文件
		 * @return 当前对象
		*/
		public NetdiskMyShare setFdId(String fdId) {
			super.change(FD_ID,super.getFdId(),fdId);
			super.setFdId(fdId);
			return this;
		}
		
		/**
		 * 设置 文件类型
		 * @param fdType 文件类型
		 * @return 当前对象
		*/
		public NetdiskMyShare setFdType(String fdType) {
			super.change(FD_TYPE,super.getFdType(),fdType);
			super.setFdType(fdType);
			return this;
		}
		
		/**
		 * 设置 过期时间
		 * @param expirationTime 过期时间
		 * @return 当前对象
		*/
		public NetdiskMyShare setExpirationTime(Date expirationTime) {
			super.change(EXPIRATION_TIME,super.getExpirationTime(),expirationTime);
			super.setExpirationTime(expirationTime);
			return this;
		}
		
		/**
		 * 设置 过期方式
		 * @param expirationMethod 过期方式
		 * @return 当前对象
		*/
		public NetdiskMyShare setExpirationMethod(String expirationMethod) {
			super.change(EXPIRATION_METHOD,super.getExpirationMethod(),expirationMethod);
			super.setExpirationMethod(expirationMethod);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public NetdiskMyShare setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public NetdiskMyShare setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public NetdiskMyShare setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public NetdiskMyShare setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public NetdiskMyShare setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public NetdiskMyShare setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public NetdiskMyShare setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public NetdiskMyShare setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public NetdiskMyShare setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public NetdiskMyShare setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public NetdiskMyShare setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 netdiskFile
		 * @param netdiskFile netdiskFile
		 * @return 当前对象
		*/
		public NetdiskMyShare setNetdiskFile(NetdiskFile netdiskFile) {
			super.change(NETDISK_FILE,super.getNetdiskFile(),netdiskFile);
			super.setNetdiskFile(netdiskFile);
			return this;
		}
		
		/**
		 * 设置 netdiskOriginFile
		 * @param netdiskOriginFile netdiskOriginFile
		 * @return 当前对象
		*/
		public NetdiskMyShare setNetdiskOriginFile(NetdiskOriginFile netdiskOriginFile) {
			super.change(NETDISK_ORIGIN_FILE,super.getNetdiskOriginFile(),netdiskOriginFile);
			super.setNetdiskOriginFile(netdiskOriginFile);
			return this;
		}
		
		/**
		 * 设置 ownerUser
		 * @param ownerUser ownerUser
		 * @return 当前对象
		*/
		public NetdiskMyShare setOwnerUser(Employee ownerUser) {
			super.change(OWNER_USER,super.getOwnerUser(),ownerUser);
			super.setOwnerUser(ownerUser);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public NetdiskMyShareVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public NetdiskMyShareVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setUpdateTime(this.getUpdateTime());
			inst.setType(this.getType());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			inst.setFdType(this.getFdType());
			inst.setCreateBy(this.getCreateBy());
			inst.setExpirationMethod(this.getExpirationMethod());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setFdId(this.getFdId());
			inst.setExpirationTime(this.getExpirationTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setFileUrl(this.getFileUrl());
			inst.setId(this.getId());
			inst.setFileId(this.getFileId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setNetdiskOriginFile(this.getNetdiskOriginFile());
				inst.setNetdiskFile(this.getNetdiskFile());
				inst.setOwnerUser(this.getOwnerUser());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
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