package com.dt.platform.domain.workorder.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.workorder.ServerInfoVO;
import java.util.List;
import com.dt.platform.domain.workorder.ServerInfo;
import java.util.Date;
import com.dt.platform.domain.workorder.ServerOsType;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-14 07:39:58
 * @sign BCC6C3F0252D453B2B6D3C09068FAAC2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ServerInfoVOMeta extends ServerInfoMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final String OWNER_ID="ownerId";
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> OWNER_ID_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,OWNER_ID, java.lang.String.class, "所属", "所属", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 服务器类型 , 类型: java.lang.String
	*/
	public static final String SERVER_TYPE="serverType";
	
	/**
	 * 服务器类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> SERVER_TYPE_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,SERVER_TYPE, java.lang.String.class, "服务器类型", "服务器类型", java.lang.String.class, null);
	
	/**
	 * 系统版本 , 类型: java.lang.String
	*/
	public static final String OS_VERSION="osVersion";
	
	/**
	 * 系统版本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> OS_VERSION_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,OS_VERSION, java.lang.String.class, "系统版本", "系统版本", java.lang.String.class, null);
	
	/**
	 * IP地址 , 类型: java.lang.String
	*/
	public static final String IP="ip";
	
	/**
	 * IP地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> IP_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,IP, java.lang.String.class, "IP地址", "IP地址", java.lang.String.class, null);
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final String DATABASE_VERSION="databaseVersion";
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> DATABASE_VERSION_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,DATABASE_VERSION, java.lang.String.class, "数据库", "数据库", java.lang.String.class, null);
	
	/**
	 * 中间件 , 类型: java.lang.String
	*/
	public static final String MIDDLEWARE_VERSION="middlewareVersion";
	
	/**
	 * 中间件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> MIDDLEWARE_VERSION_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,MIDDLEWARE_VERSION, java.lang.String.class, "中间件", "中间件", java.lang.String.class, null);
	
	/**
	 * CPU数 , 类型: java.lang.Integer
	*/
	public static final String CPU="cpu";
	
	/**
	 * CPU数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.Integer> CPU_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,CPU, java.lang.Integer.class, "CPU数", "CPU数", java.lang.Integer.class, null);
	
	/**
	 * 内存(G) , 类型: java.lang.Integer
	*/
	public static final String MEMORY="memory";
	
	/**
	 * 内存(G) , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.Integer> MEMORY_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,MEMORY, java.lang.Integer.class, "内存(G)", "内存(G)", java.lang.Integer.class, null);
	
	/**
	 * 空间(G) , 类型: java.lang.Integer
	*/
	public static final String SPACE_SIZE="spaceSize";
	
	/**
	 * 空间(G) , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.Integer> SPACE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,SPACE_SIZE, java.lang.Integer.class, "空间(G)", "空间(G)", java.lang.Integer.class, null);
	
	/**
	 * 数量 , 类型: java.lang.Integer
	*/
	public static final String SERVER_NUMBER="serverNumber";
	
	/**
	 * 数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.Integer> SERVER_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,SERVER_NUMBER, java.lang.Integer.class, "数量", "数量", java.lang.Integer.class, null);
	
	/**
	 * 用户列表 , 类型: java.lang.String
	*/
	public static final String USERLIST="userlist";
	
	/**
	 * 用户列表 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> USERLIST_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,USERLIST, java.lang.String.class, "用户列表", "用户列表", java.lang.String.class, null);
	
	/**
	 * 端口列表 , 类型: java.lang.String
	*/
	public static final String PORTLIST="portlist";
	
	/**
	 * 端口列表 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> PORTLIST_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,PORTLIST, java.lang.String.class, "端口列表", "端口列表", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * serverOsType , 类型: com.dt.platform.domain.workorder.ServerOsType
	*/
	public static final String SERVER_OS_TYPE="serverOsType";
	
	/**
	 * serverOsType , 类型: com.dt.platform.domain.workorder.ServerOsType
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.ServerInfoVO,com.dt.platform.domain.workorder.ServerOsType> SERVER_OS_TYPE_PROP = new BeanProperty(com.dt.platform.domain.workorder.ServerInfoVO.class ,SERVER_OS_TYPE, com.dt.platform.domain.workorder.ServerOsType.class, "serverOsType", "serverOsType", com.dt.platform.domain.workorder.ServerOsType.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , OWNER_ID , NAME , SERVER_TYPE , OS_VERSION , IP , DATABASE_VERSION , MIDDLEWARE_VERSION , CPU , MEMORY , SPACE_SIZE , SERVER_NUMBER , USERLIST , PORTLIST , NOTES , SELECTED_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , SERVER_OS_TYPE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.workorder.ServerInfoVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public ServerInfoVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public ServerInfoVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public ServerInfoVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public ServerInfoVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public ServerInfoVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public ServerInfoVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public ServerInfoVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public ServerInfoVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public ServerInfoVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public ServerInfo setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 所属
		 * @param ownerId 所属
		 * @return 当前对象
		*/
		public ServerInfo setOwnerId(String ownerId) {
			super.change(OWNER_ID,super.getOwnerId(),ownerId);
			super.setOwnerId(ownerId);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public ServerInfo setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 服务器类型
		 * @param serverType 服务器类型
		 * @return 当前对象
		*/
		public ServerInfo setServerType(String serverType) {
			super.change(SERVER_TYPE,super.getServerType(),serverType);
			super.setServerType(serverType);
			return this;
		}
		
		/**
		 * 设置 系统版本
		 * @param osVersion 系统版本
		 * @return 当前对象
		*/
		public ServerInfo setOsVersion(String osVersion) {
			super.change(OS_VERSION,super.getOsVersion(),osVersion);
			super.setOsVersion(osVersion);
			return this;
		}
		
		/**
		 * 设置 IP地址
		 * @param ip IP地址
		 * @return 当前对象
		*/
		public ServerInfo setIp(String ip) {
			super.change(IP,super.getIp(),ip);
			super.setIp(ip);
			return this;
		}
		
		/**
		 * 设置 数据库
		 * @param databaseVersion 数据库
		 * @return 当前对象
		*/
		public ServerInfo setDatabaseVersion(String databaseVersion) {
			super.change(DATABASE_VERSION,super.getDatabaseVersion(),databaseVersion);
			super.setDatabaseVersion(databaseVersion);
			return this;
		}
		
		/**
		 * 设置 中间件
		 * @param middlewareVersion 中间件
		 * @return 当前对象
		*/
		public ServerInfo setMiddlewareVersion(String middlewareVersion) {
			super.change(MIDDLEWARE_VERSION,super.getMiddlewareVersion(),middlewareVersion);
			super.setMiddlewareVersion(middlewareVersion);
			return this;
		}
		
		/**
		 * 设置 CPU数
		 * @param cpu CPU数
		 * @return 当前对象
		*/
		public ServerInfo setCpu(Integer cpu) {
			super.change(CPU,super.getCpu(),cpu);
			super.setCpu(cpu);
			return this;
		}
		
		/**
		 * 设置 内存(G)
		 * @param memory 内存(G)
		 * @return 当前对象
		*/
		public ServerInfo setMemory(Integer memory) {
			super.change(MEMORY,super.getMemory(),memory);
			super.setMemory(memory);
			return this;
		}
		
		/**
		 * 设置 空间(G)
		 * @param spaceSize 空间(G)
		 * @return 当前对象
		*/
		public ServerInfo setSpaceSize(Integer spaceSize) {
			super.change(SPACE_SIZE,super.getSpaceSize(),spaceSize);
			super.setSpaceSize(spaceSize);
			return this;
		}
		
		/**
		 * 设置 数量
		 * @param serverNumber 数量
		 * @return 当前对象
		*/
		public ServerInfo setServerNumber(Integer serverNumber) {
			super.change(SERVER_NUMBER,super.getServerNumber(),serverNumber);
			super.setServerNumber(serverNumber);
			return this;
		}
		
		/**
		 * 设置 用户列表
		 * @param userlist 用户列表
		 * @return 当前对象
		*/
		public ServerInfo setUserlist(String userlist) {
			super.change(USERLIST,super.getUserlist(),userlist);
			super.setUserlist(userlist);
			return this;
		}
		
		/**
		 * 设置 端口列表
		 * @param portlist 端口列表
		 * @return 当前对象
		*/
		public ServerInfo setPortlist(String portlist) {
			super.change(PORTLIST,super.getPortlist(),portlist);
			super.setPortlist(portlist);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public ServerInfo setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public ServerInfo setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public ServerInfo setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public ServerInfo setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public ServerInfo setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public ServerInfo setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public ServerInfo setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public ServerInfo setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public ServerInfo setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public ServerInfo setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 serverOsType
		 * @param serverOsType serverOsType
		 * @return 当前对象
		*/
		public ServerInfo setServerOsType(ServerOsType serverOsType) {
			super.change(SERVER_OS_TYPE,super.getServerOsType(),serverOsType);
			super.setServerOsType(serverOsType);
			return this;
		}
	}
}