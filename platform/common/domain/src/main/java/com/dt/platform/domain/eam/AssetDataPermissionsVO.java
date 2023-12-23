package com.dt.platform.domain.eam;

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
import com.dt.platform.domain.eam.meta.AssetDataPermissionsVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.system.BusiRole;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产数据权限VO类型
 * <p>资产数据权限 , 数据表 eam_asset_data_permissions 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-12-23 09:55:55
 * @sign 9BA19E91DBAE3B7687BCCF24F1CA6D57
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "资产数据权限VO类型 ; 资产数据权限 , 数据表 eam_asset_data_permissions 的通用VO类型" , parent = AssetDataPermissions.class)
public class AssetDataPermissionsVO extends AssetDataPermissions {

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
	public AssetDataPermissionsVO setPageIndex(Integer pageIndex) {
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
	public AssetDataPermissionsVO setPageSize(Integer pageSize) {
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
	public AssetDataPermissionsVO setSearchField(String searchField) {
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
	public AssetDataPermissionsVO setFuzzyField(String fuzzyField) {
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
	public AssetDataPermissionsVO setSearchValue(String searchValue) {
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
	public AssetDataPermissionsVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetDataPermissionsVO addDirtyField(String... dirtyField) {
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
	public AssetDataPermissionsVO setSortField(String sortField) {
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
	public AssetDataPermissionsVO setSortType(String sortType) {
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
	public AssetDataPermissionsVO setDataOrigin(String dataOrigin) {
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
	public AssetDataPermissionsVO setQueryLogic(String queryLogic) {
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
	public AssetDataPermissionsVO setRequestAction(String requestAction) {
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
	public AssetDataPermissionsVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetDataPermissionsVO addId(String... id) {
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
	 * @return AssetDataPermissionsVO , 转换好的 AssetDataPermissionsVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetDataPermissionsVO , 转换好的 PoJo 对象
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
	public AssetDataPermissionsVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetDataPermissionsVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetDataPermissionsVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetDataPermissionsVOMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setPositionNotes(this.getPositionNotes());
		inst.setNotes(this.getNotes());
		inst.setOwnerCode(this.getOwnerCode());
		inst.setCatalogCascadeEnable(this.getCatalogCascadeEnable());
		inst.setCatalogNotes(this.getCatalogNotes());
		inst.setOwnOrgLocalEnable(this.getOwnOrgLocalEnable());
		inst.setWarehouseAuthorityEnable(this.getWarehouseAuthorityEnable());
		inst.setOrgAuthorityEnable(this.getOrgAuthorityEnable());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setOrgNotes(this.getOrgNotes());
		inst.setRoleCode(this.getRoleCode());
		inst.setOrgLocalEnable(this.getOrgLocalEnable());
		inst.setOwnOrgNotes(this.getOwnOrgNotes());
		inst.setCatalogAuthorityEnable(this.getCatalogAuthorityEnable());
		inst.setId(this.getId());
		inst.setOwnOrgCascadeEnable(this.getOwnOrgCascadeEnable());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setPriority(this.getPriority());
		inst.setVersion(this.getVersion());
		inst.setOrgCascadeEnable(this.getOrgCascadeEnable());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setOwnOrgAuthorityEnable(this.getOwnOrgAuthorityEnable());
		inst.setName(this.getName());
		inst.setPositionAuthorityEnable(this.getPositionAuthorityEnable());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setWarehouseNotes(this.getWarehouseNotes());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setOwnOrganization(this.getOwnOrganization());
			inst.setPositionIds(this.getPositionIds());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setBusiRole(this.getBusiRole());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setWarehouse(this.getWarehouse());
			inst.setCategoryIds(this.getCategoryIds());
			inst.setOrganizationIds(this.getOrganizationIds());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setOrganization(this.getOrganization());
			inst.setOwnOrganizationIds(this.getOwnOrganizationIds());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setPosition(this.getPosition());
			inst.setCategory(this.getCategory());
			inst.setWarehouseIds(this.getWarehouseIds());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetDataPermissionsVO clone(boolean deep) {
		return EntityContext.clone(AssetDataPermissionsVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetDataPermissionsVO
	 * @param assetDataPermissionsMap 包含实体信息的 Map 对象
	 * @return AssetDataPermissionsVO , 转换好的的 AssetDataPermissions 对象
	*/
	@Transient
	public static AssetDataPermissionsVO createFrom(Map<String,Object> assetDataPermissionsMap) {
		if(assetDataPermissionsMap==null) return null;
		AssetDataPermissionsVO vo = create();
		EntityContext.copyProperties(vo,assetDataPermissionsMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetDataPermissionsVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetDataPermissionsVO , 转换好的的 AssetDataPermissions 对象
	*/
	@Transient
	public static AssetDataPermissionsVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetDataPermissionsVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetDataPermissionsVO，等同于 new
	 * @return AssetDataPermissionsVO 对象
	*/
	@Transient
	public static AssetDataPermissionsVO create() {
		return new com.dt.platform.domain.eam.meta.AssetDataPermissionsVOMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.CODE)));
			this.setPositionNotes(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.POSITION_NOTES)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.NOTES)));
			this.setOwnerCode(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.OWNER_CODE)));
			this.setCatalogCascadeEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.CATALOG_CASCADE_ENABLE)));
			this.setCatalogNotes(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.CATALOG_NOTES)));
			this.setOwnOrgLocalEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.OWN_ORG_LOCAL_ENABLE)));
			this.setWarehouseAuthorityEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.WAREHOUSE_AUTHORITY_ENABLE)));
			this.setOrgAuthorityEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.ORG_AUTHORITY_ENABLE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.UPDATE_BY)));
			this.setOrgNotes(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.ORG_NOTES)));
			this.setRoleCode(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.ROLE_CODE)));
			this.setOrgLocalEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.ORG_LOCAL_ENABLE)));
			this.setOwnOrgNotes(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.OWN_ORG_NOTES)));
			this.setCatalogAuthorityEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.CATALOG_AUTHORITY_ENABLE)));
			this.setId(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.ID)));
			this.setOwnOrgCascadeEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.OWN_ORG_CASCADE_ENABLE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetDataPermissionsVOMeta.UPDATE_TIME)));
			this.setPriority(DataParser.parse(Integer.class, map.get(AssetDataPermissionsVOMeta.PRIORITY)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetDataPermissionsVOMeta.VERSION)));
			this.setOrgCascadeEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.ORG_CASCADE_ENABLE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetDataPermissionsVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetDataPermissionsVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetDataPermissionsVOMeta.DELETE_TIME)));
			this.setOwnOrgAuthorityEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.OWN_ORG_AUTHORITY_ENABLE)));
			this.setName(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.NAME)));
			this.setPositionAuthorityEnable(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.POSITION_AUTHORITY_ENABLE)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.DELETE_BY)));
			this.setWarehouseNotes(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.WAREHOUSE_NOTES)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.REQUEST_ACTION)));
			this.setBusiRole(DataParser.parse(BusiRole.class, map.get(AssetDataPermissionsVOMeta.BUSI_ROLE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetDataPermissionsVOMeta.PAGE_SIZE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetDataPermissionsVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetDataPermissionsVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(AssetDataPermissionsVOMeta.CODE));
				this.setPositionNotes( (String)map.get(AssetDataPermissionsVOMeta.POSITION_NOTES));
				this.setNotes( (String)map.get(AssetDataPermissionsVOMeta.NOTES));
				this.setOwnerCode( (String)map.get(AssetDataPermissionsVOMeta.OWNER_CODE));
				this.setCatalogCascadeEnable( (String)map.get(AssetDataPermissionsVOMeta.CATALOG_CASCADE_ENABLE));
				this.setCatalogNotes( (String)map.get(AssetDataPermissionsVOMeta.CATALOG_NOTES));
				this.setOwnOrgLocalEnable( (String)map.get(AssetDataPermissionsVOMeta.OWN_ORG_LOCAL_ENABLE));
				this.setWarehouseAuthorityEnable( (String)map.get(AssetDataPermissionsVOMeta.WAREHOUSE_AUTHORITY_ENABLE));
				this.setOrgAuthorityEnable( (String)map.get(AssetDataPermissionsVOMeta.ORG_AUTHORITY_ENABLE));
				this.setUpdateBy( (String)map.get(AssetDataPermissionsVOMeta.UPDATE_BY));
				this.setOrgNotes( (String)map.get(AssetDataPermissionsVOMeta.ORG_NOTES));
				this.setRoleCode( (String)map.get(AssetDataPermissionsVOMeta.ROLE_CODE));
				this.setOrgLocalEnable( (String)map.get(AssetDataPermissionsVOMeta.ORG_LOCAL_ENABLE));
				this.setOwnOrgNotes( (String)map.get(AssetDataPermissionsVOMeta.OWN_ORG_NOTES));
				this.setCatalogAuthorityEnable( (String)map.get(AssetDataPermissionsVOMeta.CATALOG_AUTHORITY_ENABLE));
				this.setId( (String)map.get(AssetDataPermissionsVOMeta.ID));
				this.setOwnOrgCascadeEnable( (String)map.get(AssetDataPermissionsVOMeta.OWN_ORG_CASCADE_ENABLE));
				this.setUpdateTime( (Date)map.get(AssetDataPermissionsVOMeta.UPDATE_TIME));
				this.setPriority( (Integer)map.get(AssetDataPermissionsVOMeta.PRIORITY));
				this.setVersion( (Integer)map.get(AssetDataPermissionsVOMeta.VERSION));
				this.setOrgCascadeEnable( (String)map.get(AssetDataPermissionsVOMeta.ORG_CASCADE_ENABLE));
				this.setCreateBy( (String)map.get(AssetDataPermissionsVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetDataPermissionsVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetDataPermissionsVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetDataPermissionsVOMeta.DELETE_TIME));
				this.setOwnOrgAuthorityEnable( (String)map.get(AssetDataPermissionsVOMeta.OWN_ORG_AUTHORITY_ENABLE));
				this.setName( (String)map.get(AssetDataPermissionsVOMeta.NAME));
				this.setPositionAuthorityEnable( (String)map.get(AssetDataPermissionsVOMeta.POSITION_AUTHORITY_ENABLE));
				this.setTenantId( (String)map.get(AssetDataPermissionsVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetDataPermissionsVOMeta.DELETE_BY));
				this.setWarehouseNotes( (String)map.get(AssetDataPermissionsVOMeta.WAREHOUSE_NOTES));
				this.setStatus( (String)map.get(AssetDataPermissionsVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(AssetDataPermissionsVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(AssetDataPermissionsVOMeta.REQUEST_ACTION));
				this.setBusiRole( (BusiRole)map.get(AssetDataPermissionsVOMeta.BUSI_ROLE));
				this.setFuzzyField( (String)map.get(AssetDataPermissionsVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssetDataPermissionsVOMeta.PAGE_SIZE));
				this.setPageIndex( (Integer)map.get(AssetDataPermissionsVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetDataPermissionsVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(AssetDataPermissionsVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(AssetDataPermissionsVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(AssetDataPermissionsVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(AssetDataPermissionsVOMeta.SEARCH_VALUE));
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
			this.setCode(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.CODE)));
			this.setPositionNotes(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.POSITION_NOTES)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.NOTES)));
			this.setOwnerCode(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.OWNER_CODE)));
			this.setCatalogCascadeEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.CATALOG_CASCADE_ENABLE)));
			this.setCatalogNotes(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.CATALOG_NOTES)));
			this.setOwnOrgLocalEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.OWN_ORG_LOCAL_ENABLE)));
			this.setWarehouseAuthorityEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.WAREHOUSE_AUTHORITY_ENABLE)));
			this.setOrgAuthorityEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.ORG_AUTHORITY_ENABLE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.UPDATE_BY)));
			this.setOrgNotes(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.ORG_NOTES)));
			this.setRoleCode(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.ROLE_CODE)));
			this.setOrgLocalEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.ORG_LOCAL_ENABLE)));
			this.setOwnOrgNotes(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.OWN_ORG_NOTES)));
			this.setCatalogAuthorityEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.CATALOG_AUTHORITY_ENABLE)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.ID)));
			this.setOwnOrgCascadeEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.OWN_ORG_CASCADE_ENABLE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetDataPermissionsVOMeta.UPDATE_TIME)));
			this.setPriority(DataParser.parse(Integer.class, r.getValue(AssetDataPermissionsVOMeta.PRIORITY)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetDataPermissionsVOMeta.VERSION)));
			this.setOrgCascadeEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.ORG_CASCADE_ENABLE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetDataPermissionsVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetDataPermissionsVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetDataPermissionsVOMeta.DELETE_TIME)));
			this.setOwnOrgAuthorityEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.OWN_ORG_AUTHORITY_ENABLE)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.NAME)));
			this.setPositionAuthorityEnable(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.POSITION_AUTHORITY_ENABLE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.DELETE_BY)));
			this.setWarehouseNotes(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.WAREHOUSE_NOTES)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetDataPermissionsVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(AssetDataPermissionsVOMeta.CODE));
				this.setPositionNotes( (String)r.getValue(AssetDataPermissionsVOMeta.POSITION_NOTES));
				this.setNotes( (String)r.getValue(AssetDataPermissionsVOMeta.NOTES));
				this.setOwnerCode( (String)r.getValue(AssetDataPermissionsVOMeta.OWNER_CODE));
				this.setCatalogCascadeEnable( (String)r.getValue(AssetDataPermissionsVOMeta.CATALOG_CASCADE_ENABLE));
				this.setCatalogNotes( (String)r.getValue(AssetDataPermissionsVOMeta.CATALOG_NOTES));
				this.setOwnOrgLocalEnable( (String)r.getValue(AssetDataPermissionsVOMeta.OWN_ORG_LOCAL_ENABLE));
				this.setWarehouseAuthorityEnable( (String)r.getValue(AssetDataPermissionsVOMeta.WAREHOUSE_AUTHORITY_ENABLE));
				this.setOrgAuthorityEnable( (String)r.getValue(AssetDataPermissionsVOMeta.ORG_AUTHORITY_ENABLE));
				this.setUpdateBy( (String)r.getValue(AssetDataPermissionsVOMeta.UPDATE_BY));
				this.setOrgNotes( (String)r.getValue(AssetDataPermissionsVOMeta.ORG_NOTES));
				this.setRoleCode( (String)r.getValue(AssetDataPermissionsVOMeta.ROLE_CODE));
				this.setOrgLocalEnable( (String)r.getValue(AssetDataPermissionsVOMeta.ORG_LOCAL_ENABLE));
				this.setOwnOrgNotes( (String)r.getValue(AssetDataPermissionsVOMeta.OWN_ORG_NOTES));
				this.setCatalogAuthorityEnable( (String)r.getValue(AssetDataPermissionsVOMeta.CATALOG_AUTHORITY_ENABLE));
				this.setId( (String)r.getValue(AssetDataPermissionsVOMeta.ID));
				this.setOwnOrgCascadeEnable( (String)r.getValue(AssetDataPermissionsVOMeta.OWN_ORG_CASCADE_ENABLE));
				this.setUpdateTime( (Date)r.getValue(AssetDataPermissionsVOMeta.UPDATE_TIME));
				this.setPriority( (Integer)r.getValue(AssetDataPermissionsVOMeta.PRIORITY));
				this.setVersion( (Integer)r.getValue(AssetDataPermissionsVOMeta.VERSION));
				this.setOrgCascadeEnable( (String)r.getValue(AssetDataPermissionsVOMeta.ORG_CASCADE_ENABLE));
				this.setCreateBy( (String)r.getValue(AssetDataPermissionsVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetDataPermissionsVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetDataPermissionsVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetDataPermissionsVOMeta.DELETE_TIME));
				this.setOwnOrgAuthorityEnable( (String)r.getValue(AssetDataPermissionsVOMeta.OWN_ORG_AUTHORITY_ENABLE));
				this.setName( (String)r.getValue(AssetDataPermissionsVOMeta.NAME));
				this.setPositionAuthorityEnable( (String)r.getValue(AssetDataPermissionsVOMeta.POSITION_AUTHORITY_ENABLE));
				this.setTenantId( (String)r.getValue(AssetDataPermissionsVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetDataPermissionsVOMeta.DELETE_BY));
				this.setWarehouseNotes( (String)r.getValue(AssetDataPermissionsVOMeta.WAREHOUSE_NOTES));
				this.setStatus( (String)r.getValue(AssetDataPermissionsVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}