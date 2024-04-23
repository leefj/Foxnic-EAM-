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
import com.dt.platform.domain.eam.meta.AssetStockGoodsInVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 库存物品单VO类型
 * <p>库存物品单 , 数据表 eam_asset_stock_goods_in 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-23 15:54:35
 * @sign FE3193EC29D18D5528C94A90715AD9B6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "库存物品单VO类型 ; 库存物品单 , 数据表 eam_asset_stock_goods_in 的通用VO类型" , parent = AssetStockGoodsIn.class)
public class AssetStockGoodsInVO extends AssetStockGoodsIn {

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
	public AssetStockGoodsInVO setPageIndex(Integer pageIndex) {
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
	public AssetStockGoodsInVO setPageSize(Integer pageSize) {
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
	public AssetStockGoodsInVO setSearchField(String searchField) {
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
	public AssetStockGoodsInVO setFuzzyField(String fuzzyField) {
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
	public AssetStockGoodsInVO setSearchValue(String searchValue) {
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
	public AssetStockGoodsInVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetStockGoodsInVO addDirtyField(String... dirtyField) {
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
	public AssetStockGoodsInVO setSortField(String sortField) {
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
	public AssetStockGoodsInVO setSortType(String sortType) {
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
	public AssetStockGoodsInVO setDataOrigin(String dataOrigin) {
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
	public AssetStockGoodsInVO setQueryLogic(String queryLogic) {
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
	public AssetStockGoodsInVO setRequestAction(String requestAction) {
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
	public AssetStockGoodsInVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetStockGoodsInVO addId(String... id) {
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
	 * @return AssetStockGoodsInVO , 转换好的 AssetStockGoodsInVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetStockGoodsInVO , 转换好的 PoJo 对象
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
	public AssetStockGoodsInVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetStockGoodsInVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetStockGoodsInVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetStockGoodsInVOMeta.$$proxy$$();
		inst.setOwnerType(this.getOwnerType());
		inst.setSourceId(this.getSourceId());
		inst.setPurchaseDate(this.getPurchaseDate());
		inst.setChsVersion(this.getChsVersion());
		inst.setNotes(this.getNotes());
		inst.setProcId(this.getProcId());
		inst.setLatestApproverName(this.getLatestApproverName());
		inst.setChangeInstanceId(this.getChangeInstanceId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setNextApproverIds(this.getNextApproverIds());
		inst.setApprovalOpinion(this.getApprovalOpinion());
		inst.setChsStatus(this.getChsStatus());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setAttachId(this.getAttachId());
		inst.setSupplierName(this.getSupplierName());
		inst.setSummary(this.getSummary());
		inst.setNextApproverNames(this.getNextApproverNames());
		inst.setAmount(this.getAmount());
		inst.setLatestApproverId(this.getLatestApproverId());
		inst.setStockType(this.getStockType());
		inst.setBatchCode(this.getBatchCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setManagerId(this.getManagerId());
		inst.setVersion(this.getVersion());
		inst.setReceiverUserName(this.getReceiverUserName());
		inst.setOwnCompanyId(this.getOwnCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setWarehouseId(this.getWarehouseId());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setChsType(this.getChsType());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setOwnerCompany(this.getOwnerCompany());
			inst.setManager(this.getManager());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setGoodsList(this.getGoodsList());
			inst.setPageSize(this.getPageSize());
			inst.setSource(this.getSource());
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
	public AssetStockGoodsInVO clone(boolean deep) {
		return EntityContext.clone(AssetStockGoodsInVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetStockGoodsInVO
	 * @param assetStockGoodsInMap 包含实体信息的 Map 对象
	 * @return AssetStockGoodsInVO , 转换好的的 AssetStockGoodsIn 对象
	*/
	@Transient
	public static AssetStockGoodsInVO createFrom(Map<String,Object> assetStockGoodsInMap) {
		if(assetStockGoodsInMap==null) return null;
		AssetStockGoodsInVO vo = create();
		EntityContext.copyProperties(vo,assetStockGoodsInMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetStockGoodsInVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetStockGoodsInVO , 转换好的的 AssetStockGoodsIn 对象
	*/
	@Transient
	public static AssetStockGoodsInVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetStockGoodsInVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetStockGoodsInVO，等同于 new
	 * @return AssetStockGoodsInVO 对象
	*/
	@Transient
	public static AssetStockGoodsInVO create() {
		return new com.dt.platform.domain.eam.meta.AssetStockGoodsInVOMeta.$$proxy$$();
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
			this.setOwnerType(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.OWNER_TYPE)));
			this.setSourceId(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.SOURCE_ID)));
			this.setPurchaseDate(DataParser.parse(Date.class, map.get(AssetStockGoodsInVOMeta.PURCHASE_DATE)));
			this.setChsVersion(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.CHS_VERSION)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.NOTES)));
			this.setProcId(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.CHANGE_INSTANCE_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.SELECTED_CODE)));
			this.setNextApproverIds(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.APPROVAL_OPINION)));
			this.setChsStatus(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.CHS_STATUS)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(AssetStockGoodsInVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.ORIGINATOR_ID)));
			this.setAttachId(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.ATTACH_ID)));
			this.setSupplierName(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.SUPPLIER_NAME)));
			this.setSummary(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.NEXT_APPROVER_NAMES)));
			this.setAmount(DataParser.parse(BigDecimal.class, map.get(AssetStockGoodsInVOMeta.AMOUNT)));
			this.setLatestApproverId(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.LATEST_APPROVER_ID)));
			this.setStockType(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.STOCK_TYPE)));
			this.setBatchCode(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.BATCH_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetStockGoodsInVOMeta.UPDATE_TIME)));
			this.setManagerId(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.MANAGER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetStockGoodsInVOMeta.VERSION)));
			this.setReceiverUserName(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.RECEIVER_USER_NAME)));
			this.setOwnCompanyId(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetStockGoodsInVOMeta.DELETED)));
			this.setWarehouseId(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.WAREHOUSE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetStockGoodsInVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetStockGoodsInVOMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.STATUS)));
			// others
			this.setOwnerCompany(DataParser.parse(Organization.class, map.get(AssetStockGoodsInVOMeta.OWNER_COMPANY)));
			this.setManager(DataParser.parse(Employee.class, map.get(AssetStockGoodsInVOMeta.MANAGER)));
			this.setSearchField(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetStockGoodsInVOMeta.PAGE_SIZE)));
			this.setSource(DataParser.parse(DictItem.class, map.get(AssetStockGoodsInVOMeta.SOURCE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetStockGoodsInVOMeta.ORIGINATOR)));
			this.setWarehouse(DataParser.parse(Warehouse.class, map.get(AssetStockGoodsInVOMeta.WAREHOUSE)));
			this.setStockTypeDict(DataParser.parse(DictItem.class, map.get(AssetStockGoodsInVOMeta.STOCK_TYPE_DICT)));
			this.setUseOrganization(DataParser.parse(Organization.class, map.get(AssetStockGoodsInVOMeta.USE_ORGANIZATION)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetStockGoodsInVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetStockGoodsInVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)map.get(AssetStockGoodsInVOMeta.OWNER_TYPE));
				this.setSourceId( (String)map.get(AssetStockGoodsInVOMeta.SOURCE_ID));
				this.setPurchaseDate( (Date)map.get(AssetStockGoodsInVOMeta.PURCHASE_DATE));
				this.setChsVersion( (String)map.get(AssetStockGoodsInVOMeta.CHS_VERSION));
				this.setNotes( (String)map.get(AssetStockGoodsInVOMeta.NOTES));
				this.setProcId( (String)map.get(AssetStockGoodsInVOMeta.PROC_ID));
				this.setLatestApproverName( (String)map.get(AssetStockGoodsInVOMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)map.get(AssetStockGoodsInVOMeta.CHANGE_INSTANCE_ID));
				this.setSelectedCode( (String)map.get(AssetStockGoodsInVOMeta.SELECTED_CODE));
				this.setNextApproverIds( (String)map.get(AssetStockGoodsInVOMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)map.get(AssetStockGoodsInVOMeta.APPROVAL_OPINION));
				this.setChsStatus( (String)map.get(AssetStockGoodsInVOMeta.CHS_STATUS));
				this.setBusinessDate( (Date)map.get(AssetStockGoodsInVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(AssetStockGoodsInVOMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)map.get(AssetStockGoodsInVOMeta.UPDATE_BY));
				this.setId( (String)map.get(AssetStockGoodsInVOMeta.ID));
				this.setOriginatorId( (String)map.get(AssetStockGoodsInVOMeta.ORIGINATOR_ID));
				this.setAttachId( (String)map.get(AssetStockGoodsInVOMeta.ATTACH_ID));
				this.setSupplierName( (String)map.get(AssetStockGoodsInVOMeta.SUPPLIER_NAME));
				this.setSummary( (String)map.get(AssetStockGoodsInVOMeta.SUMMARY));
				this.setNextApproverNames( (String)map.get(AssetStockGoodsInVOMeta.NEXT_APPROVER_NAMES));
				this.setAmount( (BigDecimal)map.get(AssetStockGoodsInVOMeta.AMOUNT));
				this.setLatestApproverId( (String)map.get(AssetStockGoodsInVOMeta.LATEST_APPROVER_ID));
				this.setStockType( (String)map.get(AssetStockGoodsInVOMeta.STOCK_TYPE));
				this.setBatchCode( (String)map.get(AssetStockGoodsInVOMeta.BATCH_CODE));
				this.setUpdateTime( (Date)map.get(AssetStockGoodsInVOMeta.UPDATE_TIME));
				this.setManagerId( (String)map.get(AssetStockGoodsInVOMeta.MANAGER_ID));
				this.setVersion( (Integer)map.get(AssetStockGoodsInVOMeta.VERSION));
				this.setReceiverUserName( (String)map.get(AssetStockGoodsInVOMeta.RECEIVER_USER_NAME));
				this.setOwnCompanyId( (String)map.get(AssetStockGoodsInVOMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)map.get(AssetStockGoodsInVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetStockGoodsInVOMeta.DELETED));
				this.setWarehouseId( (String)map.get(AssetStockGoodsInVOMeta.WAREHOUSE_ID));
				this.setCreateTime( (Date)map.get(AssetStockGoodsInVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetStockGoodsInVOMeta.DELETE_TIME));
				this.setChsType( (String)map.get(AssetStockGoodsInVOMeta.CHS_TYPE));
				this.setName( (String)map.get(AssetStockGoodsInVOMeta.NAME));
				this.setTenantId( (String)map.get(AssetStockGoodsInVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetStockGoodsInVOMeta.DELETE_BY));
				this.setStatus( (String)map.get(AssetStockGoodsInVOMeta.STATUS));
				// others
				this.setOwnerCompany( (Organization)map.get(AssetStockGoodsInVOMeta.OWNER_COMPANY));
				this.setManager( (Employee)map.get(AssetStockGoodsInVOMeta.MANAGER));
				this.setSearchField( (String)map.get(AssetStockGoodsInVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(AssetStockGoodsInVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(AssetStockGoodsInVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssetStockGoodsInVOMeta.PAGE_SIZE));
				this.setSource( (DictItem)map.get(AssetStockGoodsInVOMeta.SOURCE));
				this.setOriginator( (Employee)map.get(AssetStockGoodsInVOMeta.ORIGINATOR));
				this.setWarehouse( (Warehouse)map.get(AssetStockGoodsInVOMeta.WAREHOUSE));
				this.setStockTypeDict( (DictItem)map.get(AssetStockGoodsInVOMeta.STOCK_TYPE_DICT));
				this.setUseOrganization( (Organization)map.get(AssetStockGoodsInVOMeta.USE_ORGANIZATION));
				this.setPageIndex( (Integer)map.get(AssetStockGoodsInVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetStockGoodsInVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(AssetStockGoodsInVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(AssetStockGoodsInVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(AssetStockGoodsInVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(AssetStockGoodsInVOMeta.SEARCH_VALUE));
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
			this.setOwnerType(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.OWNER_TYPE)));
			this.setSourceId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.SOURCE_ID)));
			this.setPurchaseDate(DataParser.parse(Date.class, r.getValue(AssetStockGoodsInVOMeta.PURCHASE_DATE)));
			this.setChsVersion(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.CHS_VERSION)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.NOTES)));
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.CHANGE_INSTANCE_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.SELECTED_CODE)));
			this.setNextApproverIds(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.APPROVAL_OPINION)));
			this.setChsStatus(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.CHS_STATUS)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(AssetStockGoodsInVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.ORIGINATOR_ID)));
			this.setAttachId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.ATTACH_ID)));
			this.setSupplierName(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.SUPPLIER_NAME)));
			this.setSummary(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.NEXT_APPROVER_NAMES)));
			this.setAmount(DataParser.parse(BigDecimal.class, r.getValue(AssetStockGoodsInVOMeta.AMOUNT)));
			this.setLatestApproverId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.LATEST_APPROVER_ID)));
			this.setStockType(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.STOCK_TYPE)));
			this.setBatchCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.BATCH_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsInVOMeta.UPDATE_TIME)));
			this.setManagerId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.MANAGER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetStockGoodsInVOMeta.VERSION)));
			this.setReceiverUserName(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.RECEIVER_USER_NAME)));
			this.setOwnCompanyId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetStockGoodsInVOMeta.DELETED)));
			this.setWarehouseId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.WAREHOUSE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsInVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsInVOMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetStockGoodsInVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)r.getValue(AssetStockGoodsInVOMeta.OWNER_TYPE));
				this.setSourceId( (String)r.getValue(AssetStockGoodsInVOMeta.SOURCE_ID));
				this.setPurchaseDate( (Date)r.getValue(AssetStockGoodsInVOMeta.PURCHASE_DATE));
				this.setChsVersion( (String)r.getValue(AssetStockGoodsInVOMeta.CHS_VERSION));
				this.setNotes( (String)r.getValue(AssetStockGoodsInVOMeta.NOTES));
				this.setProcId( (String)r.getValue(AssetStockGoodsInVOMeta.PROC_ID));
				this.setLatestApproverName( (String)r.getValue(AssetStockGoodsInVOMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)r.getValue(AssetStockGoodsInVOMeta.CHANGE_INSTANCE_ID));
				this.setSelectedCode( (String)r.getValue(AssetStockGoodsInVOMeta.SELECTED_CODE));
				this.setNextApproverIds( (String)r.getValue(AssetStockGoodsInVOMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)r.getValue(AssetStockGoodsInVOMeta.APPROVAL_OPINION));
				this.setChsStatus( (String)r.getValue(AssetStockGoodsInVOMeta.CHS_STATUS));
				this.setBusinessDate( (Date)r.getValue(AssetStockGoodsInVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(AssetStockGoodsInVOMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)r.getValue(AssetStockGoodsInVOMeta.UPDATE_BY));
				this.setId( (String)r.getValue(AssetStockGoodsInVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetStockGoodsInVOMeta.ORIGINATOR_ID));
				this.setAttachId( (String)r.getValue(AssetStockGoodsInVOMeta.ATTACH_ID));
				this.setSupplierName( (String)r.getValue(AssetStockGoodsInVOMeta.SUPPLIER_NAME));
				this.setSummary( (String)r.getValue(AssetStockGoodsInVOMeta.SUMMARY));
				this.setNextApproverNames( (String)r.getValue(AssetStockGoodsInVOMeta.NEXT_APPROVER_NAMES));
				this.setAmount( (BigDecimal)r.getValue(AssetStockGoodsInVOMeta.AMOUNT));
				this.setLatestApproverId( (String)r.getValue(AssetStockGoodsInVOMeta.LATEST_APPROVER_ID));
				this.setStockType( (String)r.getValue(AssetStockGoodsInVOMeta.STOCK_TYPE));
				this.setBatchCode( (String)r.getValue(AssetStockGoodsInVOMeta.BATCH_CODE));
				this.setUpdateTime( (Date)r.getValue(AssetStockGoodsInVOMeta.UPDATE_TIME));
				this.setManagerId( (String)r.getValue(AssetStockGoodsInVOMeta.MANAGER_ID));
				this.setVersion( (Integer)r.getValue(AssetStockGoodsInVOMeta.VERSION));
				this.setReceiverUserName( (String)r.getValue(AssetStockGoodsInVOMeta.RECEIVER_USER_NAME));
				this.setOwnCompanyId( (String)r.getValue(AssetStockGoodsInVOMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)r.getValue(AssetStockGoodsInVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetStockGoodsInVOMeta.DELETED));
				this.setWarehouseId( (String)r.getValue(AssetStockGoodsInVOMeta.WAREHOUSE_ID));
				this.setCreateTime( (Date)r.getValue(AssetStockGoodsInVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetStockGoodsInVOMeta.DELETE_TIME));
				this.setChsType( (String)r.getValue(AssetStockGoodsInVOMeta.CHS_TYPE));
				this.setName( (String)r.getValue(AssetStockGoodsInVOMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetStockGoodsInVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetStockGoodsInVOMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(AssetStockGoodsInVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}