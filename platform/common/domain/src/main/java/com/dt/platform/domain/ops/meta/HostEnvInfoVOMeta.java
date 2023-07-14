package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.HostEnvInfoVO;
import java.util.List;
import com.dt.platform.domain.ops.HostEnvInfo;
import java.util.Date;
import com.dt.platform.domain.ops.CiphertextBoxData;
import com.dt.platform.domain.ops.InformationSystem;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-14 20:34:43
 * @sign 70A017C6704AD53DBA27C06FE97096B3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class HostEnvInfoVOMeta extends HostEnvInfoMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final String LABEL="label";
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> LABEL_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,LABEL, java.lang.String.class, "标签", "标签", java.lang.String.class, null);
	
	/**
	 * 信息系统 , 类型: java.lang.String
	*/
	public static final String SYSTEM_ID="systemId";
	
	/**
	 * 信息系统 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> SYSTEM_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,SYSTEM_ID, java.lang.String.class, "信息系统", "信息系统", java.lang.String.class, null);
	
	/**
	 * 主机名称 , 类型: java.lang.String
	*/
	public static final String HOSTNAME="hostname";
	
	/**
	 * 主机名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> HOSTNAME_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,HOSTNAME, java.lang.String.class, "主机名称", "主机名称", java.lang.String.class, null);
	
	/**
	 * 物理IP , 类型: java.lang.String
	*/
	public static final String IP="ip";
	
	/**
	 * 物理IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> IP_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,IP, java.lang.String.class, "物理IP", "物理IP", java.lang.String.class, null);
	
	/**
	 * IPv6 , 类型: java.lang.String
	*/
	public static final String IPV6="ipv6";
	
	/**
	 * IPv6 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> IPV6_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,IPV6, java.lang.String.class, "IPv6", "IPv6", java.lang.String.class, null);
	
	/**
	 * VIP , 类型: java.lang.String
	*/
	public static final String VIP="vip";
	
	/**
	 * VIP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> VIP_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,VIP, java.lang.String.class, "VIP", "VIP", java.lang.String.class, null);
	
	/**
	 * 描述 , 类型: java.lang.String
	*/
	public static final String HOST_DESC="hostDesc";
	
	/**
	 * 描述 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> HOST_DESC_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,HOST_DESC, java.lang.String.class, "描述", "描述", java.lang.String.class, null);
	
	/**
	 * 凭证 , 类型: java.lang.String
	*/
	public static final String VOUCHER="voucher";
	
	/**
	 * 凭证 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> VOUCHER_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,VOUCHER, java.lang.String.class, "凭证", "凭证", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * ciphertextBoxData , 类型: com.dt.platform.domain.ops.CiphertextBoxData
	*/
	public static final String CIPHERTEXT_BOX_DATA="ciphertextBoxData";
	
	/**
	 * ciphertextBoxData , 类型: com.dt.platform.domain.ops.CiphertextBoxData
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,com.dt.platform.domain.ops.CiphertextBoxData> CIPHERTEXT_BOX_DATA_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,CIPHERTEXT_BOX_DATA, com.dt.platform.domain.ops.CiphertextBoxData.class, "ciphertextBoxData", "ciphertextBoxData", com.dt.platform.domain.ops.CiphertextBoxData.class, null);
	
	/**
	 * 信息系统 , 类型: com.dt.platform.domain.ops.InformationSystem
	*/
	public static final String INFO_SYSTEM="infoSystem";
	
	/**
	 * 信息系统 , 类型: com.dt.platform.domain.ops.InformationSystem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostEnvInfoVO,com.dt.platform.domain.ops.InformationSystem> INFO_SYSTEM_PROP = new BeanProperty(com.dt.platform.domain.ops.HostEnvInfoVO.class ,INFO_SYSTEM, com.dt.platform.domain.ops.InformationSystem.class, "信息系统", "信息系统", com.dt.platform.domain.ops.InformationSystem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , LABEL , SYSTEM_ID , HOSTNAME , IP , IPV6 , VIP , HOST_DESC , VOUCHER , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , CIPHERTEXT_BOX_DATA , INFO_SYSTEM };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.HostEnvInfoVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public HostEnvInfoVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public HostEnvInfoVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public HostEnvInfoVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public HostEnvInfoVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public HostEnvInfoVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public HostEnvInfoVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public HostEnvInfoVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public HostEnvInfoVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public HostEnvInfoVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public HostEnvInfoVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public HostEnvInfoVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public HostEnvInfoVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public HostEnvInfo setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 标签
		 * @param label 标签
		 * @return 当前对象
		*/
		public HostEnvInfo setLabel(String label) {
			super.change(LABEL,super.getLabel(),label);
			super.setLabel(label);
			return this;
		}
		
		/**
		 * 设置 信息系统
		 * @param systemId 信息系统
		 * @return 当前对象
		*/
		public HostEnvInfo setSystemId(String systemId) {
			super.change(SYSTEM_ID,super.getSystemId(),systemId);
			super.setSystemId(systemId);
			return this;
		}
		
		/**
		 * 设置 主机名称
		 * @param hostname 主机名称
		 * @return 当前对象
		*/
		public HostEnvInfo setHostname(String hostname) {
			super.change(HOSTNAME,super.getHostname(),hostname);
			super.setHostname(hostname);
			return this;
		}
		
		/**
		 * 设置 物理IP
		 * @param ip 物理IP
		 * @return 当前对象
		*/
		public HostEnvInfo setIp(String ip) {
			super.change(IP,super.getIp(),ip);
			super.setIp(ip);
			return this;
		}
		
		/**
		 * 设置 IPv6
		 * @param ipv6 IPv6
		 * @return 当前对象
		*/
		public HostEnvInfo setIpv6(String ipv6) {
			super.change(IPV6,super.getIpv6(),ipv6);
			super.setIpv6(ipv6);
			return this;
		}
		
		/**
		 * 设置 VIP
		 * @param vip VIP
		 * @return 当前对象
		*/
		public HostEnvInfo setVip(String vip) {
			super.change(VIP,super.getVip(),vip);
			super.setVip(vip);
			return this;
		}
		
		/**
		 * 设置 描述
		 * @param hostDesc 描述
		 * @return 当前对象
		*/
		public HostEnvInfo setHostDesc(String hostDesc) {
			super.change(HOST_DESC,super.getHostDesc(),hostDesc);
			super.setHostDesc(hostDesc);
			return this;
		}
		
		/**
		 * 设置 凭证
		 * @param voucher 凭证
		 * @return 当前对象
		*/
		public HostEnvInfo setVoucher(String voucher) {
			super.change(VOUCHER,super.getVoucher(),voucher);
			super.setVoucher(voucher);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public HostEnvInfo setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public HostEnvInfo setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public HostEnvInfo setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public HostEnvInfo setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public HostEnvInfo setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public HostEnvInfo setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public HostEnvInfo setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public HostEnvInfo setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public HostEnvInfo setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 ciphertextBoxData
		 * @param ciphertextBoxData ciphertextBoxData
		 * @return 当前对象
		*/
		public HostEnvInfo setCiphertextBoxData(CiphertextBoxData ciphertextBoxData) {
			super.change(CIPHERTEXT_BOX_DATA,super.getCiphertextBoxData(),ciphertextBoxData);
			super.setCiphertextBoxData(ciphertextBoxData);
			return this;
		}
		
		/**
		 * 设置 信息系统
		 * @param infoSystem 信息系统
		 * @return 当前对象
		*/
		public HostEnvInfo setInfoSystem(InformationSystem infoSystem) {
			super.change(INFO_SYSTEM,super.getInfoSystem(),infoSystem);
			super.setInfoSystem(infoSystem);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public HostEnvInfoVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public HostEnvInfoVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setSystemId(this.getSystemId());
			inst.setNotes(this.getNotes());
			inst.setVoucher(this.getVoucher());
			inst.setIp(this.getIp());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setLabel(this.getLabel());
			inst.setVersion(this.getVersion());
			inst.setHostname(this.getHostname());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setIpv6(this.getIpv6());
			inst.setHostDesc(this.getHostDesc());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setVip(this.getVip());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setInfoSystem(this.getInfoSystem());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setSearchValue(this.getSearchValue());
				inst.setCiphertextBoxData(this.getCiphertextBoxData());
			}
			inst.clearModifies();
			return inst;
		}

	}
}