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
import com.dt.platform.domain.eam.meta.AssetStockGoodsOutVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Organization;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 库存出库VO类型
 * <p>库存出库 , 数据表 eam_asset_stock_goods_out 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-17 20:50:13
 * @sign 0C0A781202DE6AE5613049D067FC053C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "库存出库VO类型 ; 库存出库 , 数据表 eam_asset_stock_goods_out 的通用VO类型" , parent = AssetStockGoodsOut.class)
public class AssetStockGoodsOutVO extends AssetStockGoodsOut {

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
	public AssetStockGoodsOutVO setPageIndex(Integer pageIndex) {
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
	public AssetStockGoodsOutVO setPageSize(Integer pageSize) {
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
	public AssetStockGoodsOutVO setSearchField(String searchField) {
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
	public AssetStockGoodsOutVO setFuzzyField(String fuzzyField) {
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
	public AssetStockGoodsOutVO setSearchValue(String searchValue) {
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
	public AssetStockGoodsOutVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetStockGoodsOutVO addDirtyField(String... dirtyField) {
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
	public AssetStockGoodsOutVO setSortField(String sortField) {
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
	public AssetStockGoodsOutVO setSortType(String sortType) {
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
	public AssetStockGoodsOutVO setDataOrigin(String dataOrigin) {
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
	public AssetStockGoodsOutVO setQueryLogic(String queryLogic) {
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
	public AssetStockGoodsOutVO setRequestAction(String requestAction) {
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
	public AssetStockGoodsOutVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetStockGoodsOutVO addId(String... id) {
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
	 * @return AssetStockGoodsOutVO , 转换好的 AssetStockGoodsOutVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetStockGoodsOutVO , 转换好的 PoJo 对象
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
	public AssetStockGoodsOutVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetStockGoodsOutVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetStockGoodsOutVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetStockGoodsOutVOMeta.$$proxy$$();
		inst.setOwnerType(this.getOwnerType());
		inst.setChsVersion(this.getChsVersion());
		inst.setProcId(this.getProcId());
		inst.setLatestApproverName(this.getLatestApproverName());
		inst.setChangeInstanceId(this.getChangeInstanceId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setNextApproverIds(this.getNextApproverIds());
		inst.setApprovalOpinion(this.getApprovalOpinion());
		inst.setChsStatus(this.getChsStatus());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setAttachId(this.getAttachId());
		inst.setSummary(this.getSummary());
		inst.setNextApproverNames(this.getNextApproverNames());
		inst.setLatestApproverId(this.getLatestApproverId());
		inst.setStockType(this.getStockType());
		inst.setUseOrganizationId(this.getUseOrganizationId());
		inst.setToBook(this.getToBook());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setCollectionDate(this.getCollectionDate());
		inst.setVersion(this.getVersion());
		inst.setPositionDetail(this.getPositionDetail());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setWarehouseId(this.getWarehouseId());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setChsType(this.getChsType());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUseUserId(this.getUseUserId());
		inst.setStatus(this.getStatus());
		inst.setUseOwnCompanyId(this.getUseOwnCompanyId());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setGoodsList(this.getGoodsList());
			inst.setPageSize(this.getPageSize());
			inst.setOriginator(this.getOriginator());
			inst.setWarehouse(this.getWarehouse());
			inst.setStockTypeDict(this.getStockTypeDict());
			inst.setGoodsIds(this.getGoodsIds());
			inst.setUseOrganization(this.getUseOrganization());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setUseOwnCompany(this.getUseOwnCompany());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setUseUser(this.getUseUser());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetStockGoodsOutVO clone(boolean deep) {
		return EntityContext.clone(AssetStockGoodsOutVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetStockGoodsOutVO
	 * @param assetStockGoodsOutMap 包含实体信息的 Map 对象
	 * @return AssetStockGoodsOutVO , 转换好的的 AssetStockGoodsOut 对象
	*/
	@Transient
	public static AssetStockGoodsOutVO createFrom(Map<String,Object> assetStockGoodsOutMap) {
		if(assetStockGoodsOutMap==null) return null;
		AssetStockGoodsOutVO vo = create();
		EntityContext.copyProperties(vo,assetStockGoodsOutMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetStockGoodsOutVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetStockGoodsOutVO , 转换好的的 AssetStockGoodsOut 对象
	*/
	@Transient
	public static AssetStockGoodsOutVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetStockGoodsOutVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetStockGoodsOutVO，等同于 new
	 * @return AssetStockGoodsOutVO 对象
	*/
	@Transient
	public static AssetStockGoodsOutVO create() {
		return new com.dt.platform.domain.eam.meta.AssetStockGoodsOutVOMeta.$$proxy$$();
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
			this.setOwnerType(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.OWNER_TYPE)));
			this.setChsVersion(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.CHS_VERSION)));
			this.setProcId(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.CHANGE_INSTANCE_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.CONTENT)));
			this.setNextApproverIds(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.APPROVAL_OPINION)));
			this.setChsStatus(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.CHS_STATUS)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(AssetStockGoodsOutVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.ORIGINATOR_ID)));
			this.setAttachId(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.ATTACH_ID)));
			this.setSummary(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.NEXT_APPROVER_NAMES)));
			this.setLatestApproverId(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.LATEST_APPROVER_ID)));
			this.setStockType(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.STOCK_TYPE)));
			this.setUseOrganizationId(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.USE_ORGANIZATION_ID)));
			this.setToBook(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.TO_BOOK)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetStockGoodsOutVOMeta.UPDATE_TIME)));
			this.setCollectionDate(DataParser.parse(Date.class, map.get(AssetStockGoodsOutVOMeta.COLLECTION_DATE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetStockGoodsOutVOMeta.VERSION)));
			this.setPositionDetail(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.POSITION_DETAIL)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetStockGoodsOutVOMeta.DELETED)));
			this.setWarehouseId(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.WAREHOUSE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetStockGoodsOutVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetStockGoodsOutVOMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.DELETE_BY)));
			this.setUseUserId(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.USE_USER_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.STATUS)));
			this.setUseOwnCompanyId(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.USE_OWN_COMPANY_ID)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetStockGoodsOutVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetStockGoodsOutVOMeta.ORIGINATOR)));
			this.setWarehouse(DataParser.parse(Warehouse.class, map.get(AssetStockGoodsOutVOMeta.WAREHOUSE)));
			this.setStockTypeDict(DataParser.parse(DictItem.class, map.get(AssetStockGoodsOutVOMeta.STOCK_TYPE_DICT)));
			this.setUseOrganization(DataParser.parse(Organization.class, map.get(AssetStockGoodsOutVOMeta.USE_ORGANIZATION)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetStockGoodsOutVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.DATA_ORIGIN)));
			this.setUseOwnCompany(DataParser.parse(Organization.class, map.get(AssetStockGoodsOutVOMeta.USE_OWN_COMPANY)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.QUERY_LOGIC)));
			this.setUseUser(DataParser.parse(Employee.class, map.get(AssetStockGoodsOutVOMeta.USE_USER)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetStockGoodsOutVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)map.get(AssetStockGoodsOutVOMeta.OWNER_TYPE));
				this.setChsVersion( (String)map.get(AssetStockGoodsOutVOMeta.CHS_VERSION));
				this.setProcId( (String)map.get(AssetStockGoodsOutVOMeta.PROC_ID));
				this.setLatestApproverName( (String)map.get(AssetStockGoodsOutVOMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)map.get(AssetStockGoodsOutVOMeta.CHANGE_INSTANCE_ID));
				this.setSelectedCode( (String)map.get(AssetStockGoodsOutVOMeta.SELECTED_CODE));
				this.setContent( (String)map.get(AssetStockGoodsOutVOMeta.CONTENT));
				this.setNextApproverIds( (String)map.get(AssetStockGoodsOutVOMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)map.get(AssetStockGoodsOutVOMeta.APPROVAL_OPINION));
				this.setChsStatus( (String)map.get(AssetStockGoodsOutVOMeta.CHS_STATUS));
				this.setBusinessDate( (Date)map.get(AssetStockGoodsOutVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(AssetStockGoodsOutVOMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)map.get(AssetStockGoodsOutVOMeta.UPDATE_BY));
				this.setId( (String)map.get(AssetStockGoodsOutVOMeta.ID));
				this.setOriginatorId( (String)map.get(AssetStockGoodsOutVOMeta.ORIGINATOR_ID));
				this.setAttachId( (String)map.get(AssetStockGoodsOutVOMeta.ATTACH_ID));
				this.setSummary( (String)map.get(AssetStockGoodsOutVOMeta.SUMMARY));
				this.setNextApproverNames( (String)map.get(AssetStockGoodsOutVOMeta.NEXT_APPROVER_NAMES));
				this.setLatestApproverId( (String)map.get(AssetStockGoodsOutVOMeta.LATEST_APPROVER_ID));
				this.setStockType( (String)map.get(AssetStockGoodsOutVOMeta.STOCK_TYPE));
				this.setUseOrganizationId( (String)map.get(AssetStockGoodsOutVOMeta.USE_ORGANIZATION_ID));
				this.setToBook( (String)map.get(AssetStockGoodsOutVOMeta.TO_BOOK));
				this.setUpdateTime( (Date)map.get(AssetStockGoodsOutVOMeta.UPDATE_TIME));
				this.setCollectionDate( (Date)map.get(AssetStockGoodsOutVOMeta.COLLECTION_DATE));
				this.setVersion( (Integer)map.get(AssetStockGoodsOutVOMeta.VERSION));
				this.setPositionDetail( (String)map.get(AssetStockGoodsOutVOMeta.POSITION_DETAIL));
				this.setCreateBy( (String)map.get(AssetStockGoodsOutVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetStockGoodsOutVOMeta.DELETED));
				this.setWarehouseId( (String)map.get(AssetStockGoodsOutVOMeta.WAREHOUSE_ID));
				this.setCreateTime( (Date)map.get(AssetStockGoodsOutVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetStockGoodsOutVOMeta.DELETE_TIME));
				this.setChsType( (String)map.get(AssetStockGoodsOutVOMeta.CHS_TYPE));
				this.setName( (String)map.get(AssetStockGoodsOutVOMeta.NAME));
				this.setTenantId( (String)map.get(AssetStockGoodsOutVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetStockGoodsOutVOMeta.DELETE_BY));
				this.setUseUserId( (String)map.get(AssetStockGoodsOutVOMeta.USE_USER_ID));
				this.setStatus( (String)map.get(AssetStockGoodsOutVOMeta.STATUS));
				this.setUseOwnCompanyId( (String)map.get(AssetStockGoodsOutVOMeta.USE_OWN_COMPANY_ID));
				// others
				this.setSearchField( (String)map.get(AssetStockGoodsOutVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(AssetStockGoodsOutVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(AssetStockGoodsOutVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssetStockGoodsOutVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(AssetStockGoodsOutVOMeta.ORIGINATOR));
				this.setWarehouse( (Warehouse)map.get(AssetStockGoodsOutVOMeta.WAREHOUSE));
				this.setStockTypeDict( (DictItem)map.get(AssetStockGoodsOutVOMeta.STOCK_TYPE_DICT));
				this.setUseOrganization( (Organization)map.get(AssetStockGoodsOutVOMeta.USE_ORGANIZATION));
				this.setPageIndex( (Integer)map.get(AssetStockGoodsOutVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetStockGoodsOutVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(AssetStockGoodsOutVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(AssetStockGoodsOutVOMeta.DATA_ORIGIN));
				this.setUseOwnCompany( (Organization)map.get(AssetStockGoodsOutVOMeta.USE_OWN_COMPANY));
				this.setQueryLogic( (String)map.get(AssetStockGoodsOutVOMeta.QUERY_LOGIC));
				this.setUseUser( (Employee)map.get(AssetStockGoodsOutVOMeta.USE_USER));
				this.setSearchValue( (String)map.get(AssetStockGoodsOutVOMeta.SEARCH_VALUE));
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
			this.setOwnerType(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.OWNER_TYPE)));
			this.setChsVersion(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.CHS_VERSION)));
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.CHANGE_INSTANCE_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.CONTENT)));
			this.setNextApproverIds(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.APPROVAL_OPINION)));
			this.setChsStatus(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.CHS_STATUS)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(AssetStockGoodsOutVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.ORIGINATOR_ID)));
			this.setAttachId(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.ATTACH_ID)));
			this.setSummary(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.NEXT_APPROVER_NAMES)));
			this.setLatestApproverId(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.LATEST_APPROVER_ID)));
			this.setStockType(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.STOCK_TYPE)));
			this.setUseOrganizationId(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.USE_ORGANIZATION_ID)));
			this.setToBook(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.TO_BOOK)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsOutVOMeta.UPDATE_TIME)));
			this.setCollectionDate(DataParser.parse(Date.class, r.getValue(AssetStockGoodsOutVOMeta.COLLECTION_DATE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetStockGoodsOutVOMeta.VERSION)));
			this.setPositionDetail(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.POSITION_DETAIL)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetStockGoodsOutVOMeta.DELETED)));
			this.setWarehouseId(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.WAREHOUSE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsOutVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsOutVOMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.DELETE_BY)));
			this.setUseUserId(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.USE_USER_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.STATUS)));
			this.setUseOwnCompanyId(DataParser.parse(String.class, r.getValue(AssetStockGoodsOutVOMeta.USE_OWN_COMPANY_ID)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)r.getValue(AssetStockGoodsOutVOMeta.OWNER_TYPE));
				this.setChsVersion( (String)r.getValue(AssetStockGoodsOutVOMeta.CHS_VERSION));
				this.setProcId( (String)r.getValue(AssetStockGoodsOutVOMeta.PROC_ID));
				this.setLatestApproverName( (String)r.getValue(AssetStockGoodsOutVOMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)r.getValue(AssetStockGoodsOutVOMeta.CHANGE_INSTANCE_ID));
				this.setSelectedCode( (String)r.getValue(AssetStockGoodsOutVOMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(AssetStockGoodsOutVOMeta.CONTENT));
				this.setNextApproverIds( (String)r.getValue(AssetStockGoodsOutVOMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)r.getValue(AssetStockGoodsOutVOMeta.APPROVAL_OPINION));
				this.setChsStatus( (String)r.getValue(AssetStockGoodsOutVOMeta.CHS_STATUS));
				this.setBusinessDate( (Date)r.getValue(AssetStockGoodsOutVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(AssetStockGoodsOutVOMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)r.getValue(AssetStockGoodsOutVOMeta.UPDATE_BY));
				this.setId( (String)r.getValue(AssetStockGoodsOutVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetStockGoodsOutVOMeta.ORIGINATOR_ID));
				this.setAttachId( (String)r.getValue(AssetStockGoodsOutVOMeta.ATTACH_ID));
				this.setSummary( (String)r.getValue(AssetStockGoodsOutVOMeta.SUMMARY));
				this.setNextApproverNames( (String)r.getValue(AssetStockGoodsOutVOMeta.NEXT_APPROVER_NAMES));
				this.setLatestApproverId( (String)r.getValue(AssetStockGoodsOutVOMeta.LATEST_APPROVER_ID));
				this.setStockType( (String)r.getValue(AssetStockGoodsOutVOMeta.STOCK_TYPE));
				this.setUseOrganizationId( (String)r.getValue(AssetStockGoodsOutVOMeta.USE_ORGANIZATION_ID));
				this.setToBook( (String)r.getValue(AssetStockGoodsOutVOMeta.TO_BOOK));
				this.setUpdateTime( (Date)r.getValue(AssetStockGoodsOutVOMeta.UPDATE_TIME));
				this.setCollectionDate( (Date)r.getValue(AssetStockGoodsOutVOMeta.COLLECTION_DATE));
				this.setVersion( (Integer)r.getValue(AssetStockGoodsOutVOMeta.VERSION));
				this.setPositionDetail( (String)r.getValue(AssetStockGoodsOutVOMeta.POSITION_DETAIL));
				this.setCreateBy( (String)r.getValue(AssetStockGoodsOutVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetStockGoodsOutVOMeta.DELETED));
				this.setWarehouseId( (String)r.getValue(AssetStockGoodsOutVOMeta.WAREHOUSE_ID));
				this.setCreateTime( (Date)r.getValue(AssetStockGoodsOutVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetStockGoodsOutVOMeta.DELETE_TIME));
				this.setChsType( (String)r.getValue(AssetStockGoodsOutVOMeta.CHS_TYPE));
				this.setName( (String)r.getValue(AssetStockGoodsOutVOMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetStockGoodsOutVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetStockGoodsOutVOMeta.DELETE_BY));
				this.setUseUserId( (String)r.getValue(AssetStockGoodsOutVOMeta.USE_USER_ID));
				this.setStatus( (String)r.getValue(AssetStockGoodsOutVOMeta.STATUS));
				this.setUseOwnCompanyId( (String)r.getValue(AssetStockGoodsOutVOMeta.USE_OWN_COMPANY_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}