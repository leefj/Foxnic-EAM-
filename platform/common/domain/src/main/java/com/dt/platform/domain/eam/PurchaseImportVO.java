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
import com.dt.platform.domain.eam.meta.PurchaseImportVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 采购单导入资产VO类型
 * <p>采购单导入资产 , 数据表 eam_purchase_import 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-11-28 21:41:30
 * @sign 416EDC26CECD3892724FFBF05E0E2802
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "采购单导入资产VO类型 ; 采购单导入资产 , 数据表 eam_purchase_import 的通用VO类型" , parent = PurchaseImport.class)
public class PurchaseImportVO extends PurchaseImport {

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
	public PurchaseImportVO setPageIndex(Integer pageIndex) {
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
	public PurchaseImportVO setPageSize(Integer pageSize) {
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
	public PurchaseImportVO setSearchField(String searchField) {
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
	public PurchaseImportVO setFuzzyField(String fuzzyField) {
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
	public PurchaseImportVO setSearchValue(String searchValue) {
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
	public PurchaseImportVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public PurchaseImportVO addDirtyField(String... dirtyField) {
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
	public PurchaseImportVO setSortField(String sortField) {
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
	public PurchaseImportVO setSortType(String sortType) {
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
	public PurchaseImportVO setDataOrigin(String dataOrigin) {
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
	public PurchaseImportVO setQueryLogic(String queryLogic) {
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
	public PurchaseImportVO setRequestAction(String requestAction) {
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
	public PurchaseImportVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public PurchaseImportVO addId(String... id) {
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
	 * @return PurchaseImportVO , 转换好的 PurchaseImportVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PurchaseImportVO , 转换好的 PoJo 对象
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
	public PurchaseImportVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PurchaseImportVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.PurchaseImportVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.PurchaseImportVOMeta.$$proxy$$();
		inst.setOperUserId(this.getOperUserId());
		inst.setPurchaseDate(this.getPurchaseDate());
		inst.setNotes(this.getNotes());
		inst.setOrderId(this.getOrderId());
		inst.setAssetNotes(this.getAssetNotes());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setOrderName(this.getOrderName());
		inst.setImportToType(this.getImportToType());
		inst.setUseOrgId(this.getUseOrgId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setManagerId(this.getManagerId());
		inst.setVersion(this.getVersion());
		inst.setOwnCompanyId(this.getOwnCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPositionId(this.getPositionId());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setOrderCode(this.getOrderCode());
		inst.setUseUserId(this.getUseUserId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setOwnerCompany(this.getOwnerCompany());
			inst.setPurchaseApply(this.getPurchaseApply());
			inst.setManager(this.getManager());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setAssetList(this.getAssetList());
			inst.setFill(this.getFill());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setUseOrganization(this.getUseOrganization());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setPosition(this.getPosition());
			inst.setUseUser(this.getUseUser());
			inst.setOperUser(this.getOperUser());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PurchaseImportVO clone(boolean deep) {
		return EntityContext.clone(PurchaseImportVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PurchaseImportVO
	 * @param purchaseImportMap 包含实体信息的 Map 对象
	 * @return PurchaseImportVO , 转换好的的 PurchaseImport 对象
	*/
	@Transient
	public static PurchaseImportVO createFrom(Map<String,Object> purchaseImportMap) {
		if(purchaseImportMap==null) return null;
		PurchaseImportVO vo = create();
		EntityContext.copyProperties(vo,purchaseImportMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 PurchaseImportVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PurchaseImportVO , 转换好的的 PurchaseImport 对象
	*/
	@Transient
	public static PurchaseImportVO createFrom(Object pojo) {
		if(pojo==null) return null;
		PurchaseImportVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 PurchaseImportVO，等同于 new
	 * @return PurchaseImportVO 对象
	*/
	@Transient
	public static PurchaseImportVO create() {
		return new com.dt.platform.domain.eam.meta.PurchaseImportVOMeta.$$proxy$$();
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
			this.setOperUserId(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.OPER_USER_ID)));
			this.setPurchaseDate(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.PURCHASE_DATE)));
			this.setNotes(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.NOTES)));
			this.setOrderId(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.ORDER_ID)));
			this.setAssetNotes(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.ASSET_NOTES)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.ID)));
			this.setOrderName(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.ORDER_NAME)));
			this.setImportToType(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.IMPORT_TO_TYPE)));
			this.setUseOrgId(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.USE_ORG_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PurchaseImportVOMeta.UPDATE_TIME)));
			this.setManagerId(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.MANAGER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PurchaseImportVOMeta.VERSION)));
			this.setOwnCompanyId(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PurchaseImportVOMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PurchaseImportVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PurchaseImportVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.DELETE_BY)));
			this.setOrderCode(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.ORDER_CODE)));
			this.setUseUserId(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.USE_USER_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.STATUS)));
			// others
			this.setOwnerCompany(DataParser.parse(Organization.class, map.get(PurchaseImportVOMeta.OWNER_COMPANY)));
			this.setPurchaseApply(DataParser.parse(PurchaseApply.class, map.get(PurchaseImportVOMeta.PURCHASE_APPLY)));
			this.setManager(DataParser.parse(Employee.class, map.get(PurchaseImportVOMeta.MANAGER)));
			this.setSearchField(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(PurchaseImportVOMeta.PAGE_SIZE)));
			this.setFill(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.FILL)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.SELECTED_CODE)));
			this.setUseOrganization(DataParser.parse(Organization.class, map.get(PurchaseImportVOMeta.USE_ORGANIZATION)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(PurchaseImportVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.QUERY_LOGIC)));
			this.setPosition(DataParser.parse(Position.class, map.get(PurchaseImportVOMeta.POSITION)));
			this.setUseUser(DataParser.parse(Employee.class, map.get(PurchaseImportVOMeta.USE_USER)));
			this.setOperUser(DataParser.parse(Employee.class, map.get(PurchaseImportVOMeta.OPER_USER)));
			this.setSearchValue(DataParser.parse(String.class, map.get(PurchaseImportVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setOperUserId( (String)map.get(PurchaseImportVOMeta.OPER_USER_ID));
				this.setPurchaseDate( (String)map.get(PurchaseImportVOMeta.PURCHASE_DATE));
				this.setNotes( (String)map.get(PurchaseImportVOMeta.NOTES));
				this.setOrderId( (String)map.get(PurchaseImportVOMeta.ORDER_ID));
				this.setAssetNotes( (String)map.get(PurchaseImportVOMeta.ASSET_NOTES));
				this.setUpdateBy( (String)map.get(PurchaseImportVOMeta.UPDATE_BY));
				this.setId( (String)map.get(PurchaseImportVOMeta.ID));
				this.setOrderName( (String)map.get(PurchaseImportVOMeta.ORDER_NAME));
				this.setImportToType( (String)map.get(PurchaseImportVOMeta.IMPORT_TO_TYPE));
				this.setUseOrgId( (String)map.get(PurchaseImportVOMeta.USE_ORG_ID));
				this.setUpdateTime( (Date)map.get(PurchaseImportVOMeta.UPDATE_TIME));
				this.setManagerId( (String)map.get(PurchaseImportVOMeta.MANAGER_ID));
				this.setVersion( (Integer)map.get(PurchaseImportVOMeta.VERSION));
				this.setOwnCompanyId( (String)map.get(PurchaseImportVOMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)map.get(PurchaseImportVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PurchaseImportVOMeta.DELETED));
				this.setPositionId( (String)map.get(PurchaseImportVOMeta.POSITION_ID));
				this.setCreateTime( (Date)map.get(PurchaseImportVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(PurchaseImportVOMeta.DELETE_TIME));
				this.setName( (String)map.get(PurchaseImportVOMeta.NAME));
				this.setTenantId( (String)map.get(PurchaseImportVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PurchaseImportVOMeta.DELETE_BY));
				this.setOrderCode( (String)map.get(PurchaseImportVOMeta.ORDER_CODE));
				this.setUseUserId( (String)map.get(PurchaseImportVOMeta.USE_USER_ID));
				this.setStatus( (String)map.get(PurchaseImportVOMeta.STATUS));
				// others
				this.setOwnerCompany( (Organization)map.get(PurchaseImportVOMeta.OWNER_COMPANY));
				this.setPurchaseApply( (PurchaseApply)map.get(PurchaseImportVOMeta.PURCHASE_APPLY));
				this.setManager( (Employee)map.get(PurchaseImportVOMeta.MANAGER));
				this.setSearchField( (String)map.get(PurchaseImportVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(PurchaseImportVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(PurchaseImportVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(PurchaseImportVOMeta.PAGE_SIZE));
				this.setFill( (String)map.get(PurchaseImportVOMeta.FILL));
				this.setSelectedCode( (String)map.get(PurchaseImportVOMeta.SELECTED_CODE));
				this.setUseOrganization( (Organization)map.get(PurchaseImportVOMeta.USE_ORGANIZATION));
				this.setPageIndex( (Integer)map.get(PurchaseImportVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(PurchaseImportVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(PurchaseImportVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(PurchaseImportVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(PurchaseImportVOMeta.QUERY_LOGIC));
				this.setPosition( (Position)map.get(PurchaseImportVOMeta.POSITION));
				this.setUseUser( (Employee)map.get(PurchaseImportVOMeta.USE_USER));
				this.setOperUser( (Employee)map.get(PurchaseImportVOMeta.OPER_USER));
				this.setSearchValue( (String)map.get(PurchaseImportVOMeta.SEARCH_VALUE));
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
			this.setOperUserId(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.OPER_USER_ID)));
			this.setPurchaseDate(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.PURCHASE_DATE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.NOTES)));
			this.setOrderId(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.ORDER_ID)));
			this.setAssetNotes(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.ASSET_NOTES)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.ID)));
			this.setOrderName(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.ORDER_NAME)));
			this.setImportToType(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.IMPORT_TO_TYPE)));
			this.setUseOrgId(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.USE_ORG_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PurchaseImportVOMeta.UPDATE_TIME)));
			this.setManagerId(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.MANAGER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PurchaseImportVOMeta.VERSION)));
			this.setOwnCompanyId(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PurchaseImportVOMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PurchaseImportVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PurchaseImportVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.DELETE_BY)));
			this.setOrderCode(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.ORDER_CODE)));
			this.setUseUserId(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.USE_USER_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PurchaseImportVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setOperUserId( (String)r.getValue(PurchaseImportVOMeta.OPER_USER_ID));
				this.setPurchaseDate( (String)r.getValue(PurchaseImportVOMeta.PURCHASE_DATE));
				this.setNotes( (String)r.getValue(PurchaseImportVOMeta.NOTES));
				this.setOrderId( (String)r.getValue(PurchaseImportVOMeta.ORDER_ID));
				this.setAssetNotes( (String)r.getValue(PurchaseImportVOMeta.ASSET_NOTES));
				this.setUpdateBy( (String)r.getValue(PurchaseImportVOMeta.UPDATE_BY));
				this.setId( (String)r.getValue(PurchaseImportVOMeta.ID));
				this.setOrderName( (String)r.getValue(PurchaseImportVOMeta.ORDER_NAME));
				this.setImportToType( (String)r.getValue(PurchaseImportVOMeta.IMPORT_TO_TYPE));
				this.setUseOrgId( (String)r.getValue(PurchaseImportVOMeta.USE_ORG_ID));
				this.setUpdateTime( (Date)r.getValue(PurchaseImportVOMeta.UPDATE_TIME));
				this.setManagerId( (String)r.getValue(PurchaseImportVOMeta.MANAGER_ID));
				this.setVersion( (Integer)r.getValue(PurchaseImportVOMeta.VERSION));
				this.setOwnCompanyId( (String)r.getValue(PurchaseImportVOMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)r.getValue(PurchaseImportVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PurchaseImportVOMeta.DELETED));
				this.setPositionId( (String)r.getValue(PurchaseImportVOMeta.POSITION_ID));
				this.setCreateTime( (Date)r.getValue(PurchaseImportVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(PurchaseImportVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(PurchaseImportVOMeta.NAME));
				this.setTenantId( (String)r.getValue(PurchaseImportVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PurchaseImportVOMeta.DELETE_BY));
				this.setOrderCode( (String)r.getValue(PurchaseImportVOMeta.ORDER_CODE));
				this.setUseUserId( (String)r.getValue(PurchaseImportVOMeta.USE_USER_ID));
				this.setStatus( (String)r.getValue(PurchaseImportVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}