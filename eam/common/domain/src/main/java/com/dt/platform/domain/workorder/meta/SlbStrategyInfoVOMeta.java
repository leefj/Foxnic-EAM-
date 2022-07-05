package com.dt.platform.domain.workorder.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.workorder.SlbStrategyInfoVO;
import java.util.List;
import com.dt.platform.domain.workorder.SlbStrategyInfo;
import java.util.Date;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-04 21:04:50
 * @sign 8EE25508031CA449944455E7B9206078
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SlbStrategyInfoVOMeta extends SlbStrategyInfoMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final String OWNER_ID="ownerId";
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> OWNER_ID_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,OWNER_ID, java.lang.String.class, "所属", "所属", java.lang.String.class, null);
	
	/**
	 * 源名称 , 类型: java.lang.String
	*/
	public static final String SOURCE_NAME="sourceName";
	
	/**
	 * 源名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> SOURCE_NAME_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,SOURCE_NAME, java.lang.String.class, "源名称", "源名称", java.lang.String.class, null);
	
	/**
	 * 源IP , 类型: java.lang.String
	*/
	public static final String SOURCE_IP="sourceIp";
	
	/**
	 * 源IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> SOURCE_IP_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,SOURCE_IP, java.lang.String.class, "源IP", "源IP", java.lang.String.class, null);
	
	/**
	 * 目标名称 , 类型: java.lang.String
	*/
	public static final String TARGET_NAME="targetName";
	
	/**
	 * 目标名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> TARGET_NAME_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,TARGET_NAME, java.lang.String.class, "目标名称", "目标名称", java.lang.String.class, null);
	
	/**
	 * 目标IP , 类型: java.lang.String
	*/
	public static final String TARGET_IP="targetIp";
	
	/**
	 * 目标IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> TARGET_IP_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,TARGET_IP, java.lang.String.class, "目标IP", "目标IP", java.lang.String.class, null);
	
	/**
	 * 使用协议 , 类型: java.lang.String
	*/
	public static final String USED_PROTOCOL_TYPE="usedProtocolType";
	
	/**
	 * 使用协议 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> USED_PROTOCOL_TYPE_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,USED_PROTOCOL_TYPE, java.lang.String.class, "使用协议", "使用协议", java.lang.String.class, null);
	
	/**
	 * 连接类型 , 类型: java.lang.String
	*/
	public static final String SESSION_TYPE="sessionType";
	
	/**
	 * 连接类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> SESSION_TYPE_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,SESSION_TYPE, java.lang.String.class, "连接类型", "连接类型", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.workorder.SlbStrategyInfoVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.workorder.SlbStrategyInfoVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , OWNER_ID , SOURCE_NAME , SOURCE_IP , TARGET_NAME , TARGET_IP , USED_PROTOCOL_TYPE , SESSION_TYPE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.workorder.SlbStrategyInfoVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public SlbStrategyInfoVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public SlbStrategyInfoVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public SlbStrategyInfoVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public SlbStrategyInfoVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public SlbStrategyInfoVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public SlbStrategyInfoVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public SlbStrategyInfoVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public SlbStrategyInfoVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public SlbStrategyInfoVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public SlbStrategyInfo setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 所属
		 * @param ownerId 所属
		 * @return 当前对象
		*/
		public SlbStrategyInfo setOwnerId(String ownerId) {
			super.change(OWNER_ID,super.getOwnerId(),ownerId);
			super.setOwnerId(ownerId);
			return this;
		}
		
		/**
		 * 设置 源名称
		 * @param sourceName 源名称
		 * @return 当前对象
		*/
		public SlbStrategyInfo setSourceName(String sourceName) {
			super.change(SOURCE_NAME,super.getSourceName(),sourceName);
			super.setSourceName(sourceName);
			return this;
		}
		
		/**
		 * 设置 源IP
		 * @param sourceIp 源IP
		 * @return 当前对象
		*/
		public SlbStrategyInfo setSourceIp(String sourceIp) {
			super.change(SOURCE_IP,super.getSourceIp(),sourceIp);
			super.setSourceIp(sourceIp);
			return this;
		}
		
		/**
		 * 设置 目标名称
		 * @param targetName 目标名称
		 * @return 当前对象
		*/
		public SlbStrategyInfo setTargetName(String targetName) {
			super.change(TARGET_NAME,super.getTargetName(),targetName);
			super.setTargetName(targetName);
			return this;
		}
		
		/**
		 * 设置 目标IP
		 * @param targetIp 目标IP
		 * @return 当前对象
		*/
		public SlbStrategyInfo setTargetIp(String targetIp) {
			super.change(TARGET_IP,super.getTargetIp(),targetIp);
			super.setTargetIp(targetIp);
			return this;
		}
		
		/**
		 * 设置 使用协议
		 * @param usedProtocolType 使用协议
		 * @return 当前对象
		*/
		public SlbStrategyInfo setUsedProtocolType(String usedProtocolType) {
			super.change(USED_PROTOCOL_TYPE,super.getUsedProtocolType(),usedProtocolType);
			super.setUsedProtocolType(usedProtocolType);
			return this;
		}
		
		/**
		 * 设置 连接类型
		 * @param sessionType 连接类型
		 * @return 当前对象
		*/
		public SlbStrategyInfo setSessionType(String sessionType) {
			super.change(SESSION_TYPE,super.getSessionType(),sessionType);
			super.setSessionType(sessionType);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public SlbStrategyInfo setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SlbStrategyInfo setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SlbStrategyInfo setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SlbStrategyInfo setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SlbStrategyInfo setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SlbStrategyInfo setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SlbStrategyInfo setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SlbStrategyInfo setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public SlbStrategyInfo setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}