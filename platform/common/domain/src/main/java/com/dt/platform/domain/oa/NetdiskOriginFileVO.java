package com.dt.platform.domain.oa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.github.foxnic.api.model.CompositeParameter;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import java.util.Map;
import com.dt.platform.domain.oa.meta.NetdiskOriginFileVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 源文件VO类型
 * <p>源文件 , 数据表 oa_netdisk_origin_file 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-22 18:17:17
 * @sign 2EE3B153B0A602229A9D1E11C362FCCB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "源文件VO类型 ; 源文件 , 数据表 oa_netdisk_origin_file 的通用VO类型" , parent = NetdiskOriginFile.class)
public class NetdiskOriginFileVO extends NetdiskOriginFile {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 页码
	*/
	@ApiModelProperty(required = false,value="页码" , notes = "")
	private Integer pageIndex;
	
	/**
	 * 分页大小
	*/
	@ApiModelProperty(required = false,value="分页大小" , notes = "")
	private Integer pageSize;
	
	/**
	 * 搜索字段
	*/
	@ApiModelProperty(required = false,value="搜索字段" , notes = "")
	private String searchField;
	
	/**
	 * 模糊搜索字段
	*/
	@ApiModelProperty(required = false,value="模糊搜索字段" , notes = "")
	private String fuzzyField;
	
	/**
	 * 搜索的值
	*/
	@ApiModelProperty(required = false,value="搜索的值" , notes = "")
	private String searchValue;
	
	/**
	 * 已修改字段
	*/
	@ApiModelProperty(required = false,value="已修改字段" , notes = "")
	private List<String> dirtyFields;
	
	/**
	 * 排序字段
	*/
	@ApiModelProperty(required = false,value="排序字段" , notes = "")
	private String sortField;
	
	/**
	 * 排序方式
	*/
	@ApiModelProperty(required = false,value="排序方式" , notes = "")
	private String sortType;
	
	/**
	 * 数据来源：前端指定不同的来源，后端可按来源执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "前端指定不同的来源，后端可按来源执行不同的逻辑")
	private String dataOrigin;
	
	/**
	 * 查询逻辑：默认and，可指定 or 
	*/
	@ApiModelProperty(required = false,value="查询逻辑" , notes = "默认and，可指定 or ")
	private String queryLogic;
	
	/**
	 * 请求动作：前端指定不同的Action，后端可Action执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="请求动作" , notes = "前端指定不同的Action，后端可Action执行不同的逻辑")
	private String requestAction;
	
	/**
	 * 主键清单：用于接收批量主键参数
	*/
	@ApiModelProperty(required = false,value="主键清单" , notes = "用于接收批量主键参数")
	private List<String> ids;
	
	/**
	 * 获得 页码<br>
	 * @return 页码
	*/
	public Integer getPageIndex() {
		return pageIndex;
	}
	
	/**
	 * 设置 页码
	 * @param pageIndex 页码
	 * @return 当前对象
	*/
	public NetdiskOriginFileVO setPageIndex(Integer pageIndex) {
		this.pageIndex=pageIndex;
		return this;
	}
	
	/**
	 * 获得 分页大小<br>
	 * @return 分页大小
	*/
	public Integer getPageSize() {
		return pageSize;
	}
	
	/**
	 * 设置 分页大小
	 * @param pageSize 分页大小
	 * @return 当前对象
	*/
	public NetdiskOriginFileVO setPageSize(Integer pageSize) {
		this.pageSize=pageSize;
		return this;
	}
	
	/**
	 * 获得 搜索字段<br>
	 * @return 搜索字段
	*/
	public String getSearchField() {
		return searchField;
	}
	
	/**
	 * 设置 搜索字段
	 * @param searchField 搜索字段
	 * @return 当前对象
	*/
	public NetdiskOriginFileVO setSearchField(String searchField) {
		this.searchField=searchField;
		return this;
	}
	
	/**
	 * 获得 模糊搜索字段<br>
	 * @return 模糊搜索字段
	*/
	public String getFuzzyField() {
		return fuzzyField;
	}
	
	/**
	 * 设置 模糊搜索字段
	 * @param fuzzyField 模糊搜索字段
	 * @return 当前对象
	*/
	public NetdiskOriginFileVO setFuzzyField(String fuzzyField) {
		this.fuzzyField=fuzzyField;
		return this;
	}
	
	/**
	 * 获得 搜索的值<br>
	 * @return 搜索的值
	*/
	public String getSearchValue() {
		return searchValue;
	}
	
	/**
	 * 设置 搜索的值
	 * @param searchValue 搜索的值
	 * @return 当前对象
	*/
	public NetdiskOriginFileVO setSearchValue(String searchValue) {
		this.searchValue=searchValue;
		return this;
	}
	
	/**
	 * 获得 已修改字段<br>
	 * @return 已修改字段
	*/
	public List<String> getDirtyFields() {
		return dirtyFields;
	}
	
	/**
	 * 设置 已修改字段
	 * @param dirtyFields 已修改字段
	 * @return 当前对象
	*/
	public NetdiskOriginFileVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public NetdiskOriginFileVO addDirtyField(String... dirtyField) {
		if(this.dirtyFields==null) dirtyFields=new ArrayList<>();
		this.dirtyFields.addAll(Arrays.asList(dirtyField));
		return this;
	}
	
	/**
	 * 获得 排序字段<br>
	 * @return 排序字段
	*/
	public String getSortField() {
		return sortField;
	}
	
	/**
	 * 设置 排序字段
	 * @param sortField 排序字段
	 * @return 当前对象
	*/
	public NetdiskOriginFileVO setSortField(String sortField) {
		this.sortField=sortField;
		return this;
	}
	
	/**
	 * 获得 排序方式<br>
	 * @return 排序方式
	*/
	public String getSortType() {
		return sortType;
	}
	
	/**
	 * 设置 排序方式
	 * @param sortType 排序方式
	 * @return 当前对象
	*/
	public NetdiskOriginFileVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 前端指定不同的来源，后端可按来源执行不同的逻辑
	 * @return 数据来源
	*/
	public String getDataOrigin() {
		return dataOrigin;
	}
	
	/**
	 * 设置 数据来源
	 * @param dataOrigin 数据来源
	 * @return 当前对象
	*/
	public NetdiskOriginFileVO setDataOrigin(String dataOrigin) {
		this.dataOrigin=dataOrigin;
		return this;
	}
	
	/**
	 * 获得 查询逻辑<br>
	 * 默认and，可指定 or 
	 * @return 查询逻辑
	*/
	public String getQueryLogic() {
		return queryLogic;
	}
	
	/**
	 * 设置 查询逻辑
	 * @param queryLogic 查询逻辑
	 * @return 当前对象
	*/
	public NetdiskOriginFileVO setQueryLogic(String queryLogic) {
		this.queryLogic=queryLogic;
		return this;
	}
	
	/**
	 * 获得 请求动作<br>
	 * 前端指定不同的Action，后端可Action执行不同的逻辑
	 * @return 请求动作
	*/
	public String getRequestAction() {
		return requestAction;
	}
	
	/**
	 * 设置 请求动作
	 * @param requestAction 请求动作
	 * @return 当前对象
	*/
	public NetdiskOriginFileVO setRequestAction(String requestAction) {
		this.requestAction=requestAction;
		return this;
	}
	
	/**
	 * 获得 主键清单<br>
	 * 用于接收批量主键参数
	 * @return 主键清单
	*/
	public List<String> getIds() {
		return ids;
	}
	
	/**
	 * 设置 主键清单
	 * @param ids 主键清单
	 * @return 当前对象
	*/
	public NetdiskOriginFileVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public NetdiskOriginFileVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	@Transient
	private transient CompositeParameter $compositeParameter;
	/**
	 * 获得解析后的复合查询参数
	 */
	@Transient
	public CompositeParameter getCompositeParameter() {
		if($compositeParameter!=null) return  $compositeParameter;
		$compositeParameter=new CompositeParameter(this.getSearchValue(),BeanUtil.toMap(this));
		return  $compositeParameter;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return NetdiskOriginFileVO , 转换好的 NetdiskOriginFileVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return NetdiskOriginFileVO , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public NetdiskOriginFileVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public NetdiskOriginFileVO duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.NetdiskOriginFileVOMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.NetdiskOriginFileVOMeta.$$proxy$$();
		inst.setFileName(this.getFileName());
		inst.setDownloadUrl(this.getDownloadUrl());
		inst.setExtValue(this.getExtValue());
		inst.setLastVisitTime(this.getLastVisitTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setStorageStoreId(this.getStorageStoreId());
		inst.setMediaType(this.getMediaType());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setEncrypted(this.getEncrypted());
		inst.setFileSize(this.getFileSize());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setReferenceCount(this.getReferenceCount());
		inst.setTenantId(this.getTenantId());
		inst.setStorageType(this.getStorageType());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setLocation(this.getLocation());
		inst.setMd5Value(this.getMd5Value());
		inst.setFileType(this.getFileType());
		inst.setDownloadCount(this.getDownloadCount());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
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

	/**
	 * 克隆当前对象
	*/
	@Transient
	public NetdiskOriginFileVO clone(boolean deep) {
		return EntityContext.clone(NetdiskOriginFileVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 NetdiskOriginFileVO
	 * @param netdiskOriginFileMap 包含实体信息的 Map 对象
	 * @return NetdiskOriginFileVO , 转换好的的 NetdiskOriginFile 对象
	*/
	@Transient
	public static NetdiskOriginFileVO createFrom(Map<String,Object> netdiskOriginFileMap) {
		if(netdiskOriginFileMap==null) return null;
		NetdiskOriginFileVO vo = create();
		EntityContext.copyProperties(vo,netdiskOriginFileMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 NetdiskOriginFileVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return NetdiskOriginFileVO , 转换好的的 NetdiskOriginFile 对象
	*/
	@Transient
	public static NetdiskOriginFileVO createFrom(Object pojo) {
		if(pojo==null) return null;
		NetdiskOriginFileVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 NetdiskOriginFileVO，等同于 new
	 * @return NetdiskOriginFileVO 对象
	*/
	@Transient
	public static NetdiskOriginFileVO create() {
		return new com.dt.platform.domain.oa.meta.NetdiskOriginFileVOMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setFileName(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.FILE_NAME)));
			this.setDownloadUrl(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.DOWNLOAD_URL)));
			this.setExtValue(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.EXT_VALUE)));
			this.setLastVisitTime(DataParser.parse(Date.class, map.get(NetdiskOriginFileVOMeta.LAST_VISIT_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.ID)));
			this.setStorageStoreId(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.STORAGE_STORE_ID)));
			this.setMediaType(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.MEDIA_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(NetdiskOriginFileVOMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(NetdiskOriginFileVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(NetdiskOriginFileVOMeta.DELETED)));
			this.setEncrypted(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.ENCRYPTED)));
			this.setFileSize(DataParser.parse(Long.class, map.get(NetdiskOriginFileVOMeta.FILE_SIZE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(NetdiskOriginFileVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(NetdiskOriginFileVOMeta.DELETE_TIME)));
			this.setReferenceCount(DataParser.parse(Integer.class, map.get(NetdiskOriginFileVOMeta.REFERENCE_COUNT)));
			this.setTenantId(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.TENANT_ID)));
			this.setStorageType(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.STORAGE_TYPE)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.DELETE_BY)));
			this.setLocation(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.LOCATION)));
			this.setMd5Value(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.MD5_VALUE)));
			this.setFileType(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.FILE_TYPE)));
			this.setDownloadCount(DataParser.parse(Long.class, map.get(NetdiskOriginFileVOMeta.DOWNLOAD_COUNT)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(NetdiskOriginFileVOMeta.PAGE_SIZE)));
			this.setOwnerUser(DataParser.parse(Employee.class, map.get(NetdiskOriginFileVOMeta.OWNER_USER)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(NetdiskOriginFileVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(NetdiskOriginFileVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setFileName( (String)map.get(NetdiskOriginFileVOMeta.FILE_NAME));
				this.setDownloadUrl( (String)map.get(NetdiskOriginFileVOMeta.DOWNLOAD_URL));
				this.setExtValue( (String)map.get(NetdiskOriginFileVOMeta.EXT_VALUE));
				this.setLastVisitTime( (Date)map.get(NetdiskOriginFileVOMeta.LAST_VISIT_TIME));
				this.setUpdateBy( (String)map.get(NetdiskOriginFileVOMeta.UPDATE_BY));
				this.setId( (String)map.get(NetdiskOriginFileVOMeta.ID));
				this.setStorageStoreId( (String)map.get(NetdiskOriginFileVOMeta.STORAGE_STORE_ID));
				this.setMediaType( (String)map.get(NetdiskOriginFileVOMeta.MEDIA_TYPE));
				this.setUpdateTime( (Date)map.get(NetdiskOriginFileVOMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(NetdiskOriginFileVOMeta.USER_ID));
				this.setVersion( (Integer)map.get(NetdiskOriginFileVOMeta.VERSION));
				this.setCreateBy( (String)map.get(NetdiskOriginFileVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(NetdiskOriginFileVOMeta.DELETED));
				this.setEncrypted( (String)map.get(NetdiskOriginFileVOMeta.ENCRYPTED));
				this.setFileSize( (Long)map.get(NetdiskOriginFileVOMeta.FILE_SIZE));
				this.setCreateTime( (Date)map.get(NetdiskOriginFileVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(NetdiskOriginFileVOMeta.DELETE_TIME));
				this.setReferenceCount( (Integer)map.get(NetdiskOriginFileVOMeta.REFERENCE_COUNT));
				this.setTenantId( (String)map.get(NetdiskOriginFileVOMeta.TENANT_ID));
				this.setStorageType( (String)map.get(NetdiskOriginFileVOMeta.STORAGE_TYPE));
				this.setDeleteBy( (String)map.get(NetdiskOriginFileVOMeta.DELETE_BY));
				this.setLocation( (String)map.get(NetdiskOriginFileVOMeta.LOCATION));
				this.setMd5Value( (String)map.get(NetdiskOriginFileVOMeta.MD5_VALUE));
				this.setFileType( (String)map.get(NetdiskOriginFileVOMeta.FILE_TYPE));
				this.setDownloadCount( (Long)map.get(NetdiskOriginFileVOMeta.DOWNLOAD_COUNT));
				// others
				this.setSearchField( (String)map.get(NetdiskOriginFileVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(NetdiskOriginFileVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(NetdiskOriginFileVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(NetdiskOriginFileVOMeta.PAGE_SIZE));
				this.setOwnerUser( (Employee)map.get(NetdiskOriginFileVOMeta.OWNER_USER));
				this.setPageIndex( (Integer)map.get(NetdiskOriginFileVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(NetdiskOriginFileVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(NetdiskOriginFileVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(NetdiskOriginFileVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(NetdiskOriginFileVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(NetdiskOriginFileVOMeta.SEARCH_VALUE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setFileName(DataParser.parse(String.class, r.getValue(NetdiskOriginFileVOMeta.FILE_NAME)));
			this.setDownloadUrl(DataParser.parse(String.class, r.getValue(NetdiskOriginFileVOMeta.DOWNLOAD_URL)));
			this.setExtValue(DataParser.parse(String.class, r.getValue(NetdiskOriginFileVOMeta.EXT_VALUE)));
			this.setLastVisitTime(DataParser.parse(Date.class, r.getValue(NetdiskOriginFileVOMeta.LAST_VISIT_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(NetdiskOriginFileVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(NetdiskOriginFileVOMeta.ID)));
			this.setStorageStoreId(DataParser.parse(String.class, r.getValue(NetdiskOriginFileVOMeta.STORAGE_STORE_ID)));
			this.setMediaType(DataParser.parse(String.class, r.getValue(NetdiskOriginFileVOMeta.MEDIA_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(NetdiskOriginFileVOMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(NetdiskOriginFileVOMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(NetdiskOriginFileVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(NetdiskOriginFileVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(NetdiskOriginFileVOMeta.DELETED)));
			this.setEncrypted(DataParser.parse(String.class, r.getValue(NetdiskOriginFileVOMeta.ENCRYPTED)));
			this.setFileSize(DataParser.parse(Long.class, r.getValue(NetdiskOriginFileVOMeta.FILE_SIZE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(NetdiskOriginFileVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(NetdiskOriginFileVOMeta.DELETE_TIME)));
			this.setReferenceCount(DataParser.parse(Integer.class, r.getValue(NetdiskOriginFileVOMeta.REFERENCE_COUNT)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(NetdiskOriginFileVOMeta.TENANT_ID)));
			this.setStorageType(DataParser.parse(String.class, r.getValue(NetdiskOriginFileVOMeta.STORAGE_TYPE)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(NetdiskOriginFileVOMeta.DELETE_BY)));
			this.setLocation(DataParser.parse(String.class, r.getValue(NetdiskOriginFileVOMeta.LOCATION)));
			this.setMd5Value(DataParser.parse(String.class, r.getValue(NetdiskOriginFileVOMeta.MD5_VALUE)));
			this.setFileType(DataParser.parse(String.class, r.getValue(NetdiskOriginFileVOMeta.FILE_TYPE)));
			this.setDownloadCount(DataParser.parse(Long.class, r.getValue(NetdiskOriginFileVOMeta.DOWNLOAD_COUNT)));
			return true;
		} else {
			try {
				this.setFileName( (String)r.getValue(NetdiskOriginFileVOMeta.FILE_NAME));
				this.setDownloadUrl( (String)r.getValue(NetdiskOriginFileVOMeta.DOWNLOAD_URL));
				this.setExtValue( (String)r.getValue(NetdiskOriginFileVOMeta.EXT_VALUE));
				this.setLastVisitTime( (Date)r.getValue(NetdiskOriginFileVOMeta.LAST_VISIT_TIME));
				this.setUpdateBy( (String)r.getValue(NetdiskOriginFileVOMeta.UPDATE_BY));
				this.setId( (String)r.getValue(NetdiskOriginFileVOMeta.ID));
				this.setStorageStoreId( (String)r.getValue(NetdiskOriginFileVOMeta.STORAGE_STORE_ID));
				this.setMediaType( (String)r.getValue(NetdiskOriginFileVOMeta.MEDIA_TYPE));
				this.setUpdateTime( (Date)r.getValue(NetdiskOriginFileVOMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(NetdiskOriginFileVOMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(NetdiskOriginFileVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(NetdiskOriginFileVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(NetdiskOriginFileVOMeta.DELETED));
				this.setEncrypted( (String)r.getValue(NetdiskOriginFileVOMeta.ENCRYPTED));
				this.setFileSize( (Long)r.getValue(NetdiskOriginFileVOMeta.FILE_SIZE));
				this.setCreateTime( (Date)r.getValue(NetdiskOriginFileVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(NetdiskOriginFileVOMeta.DELETE_TIME));
				this.setReferenceCount( (Integer)r.getValue(NetdiskOriginFileVOMeta.REFERENCE_COUNT));
				this.setTenantId( (String)r.getValue(NetdiskOriginFileVOMeta.TENANT_ID));
				this.setStorageType( (String)r.getValue(NetdiskOriginFileVOMeta.STORAGE_TYPE));
				this.setDeleteBy( (String)r.getValue(NetdiskOriginFileVOMeta.DELETE_BY));
				this.setLocation( (String)r.getValue(NetdiskOriginFileVOMeta.LOCATION));
				this.setMd5Value( (String)r.getValue(NetdiskOriginFileVOMeta.MD5_VALUE));
				this.setFileType( (String)r.getValue(NetdiskOriginFileVOMeta.FILE_TYPE));
				this.setDownloadCount( (Long)r.getValue(NetdiskOriginFileVOMeta.DOWNLOAD_COUNT));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}