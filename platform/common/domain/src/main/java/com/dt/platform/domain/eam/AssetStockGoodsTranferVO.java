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
import com.dt.platform.domain.eam.meta.AssetStockGoodsTranferVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 库存调拨VO类型
 * <p>库存调拨 , 数据表 eam_asset_stock_goods_tranfer 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-23 11:16:30
 * @sign AFCF75255E780A794A3AB0B59533A8C2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "库存调拨VO类型 ; 库存调拨 , 数据表 eam_asset_stock_goods_tranfer 的通用VO类型" , parent = AssetStockGoodsTranfer.class)
public class AssetStockGoodsTranferVO extends AssetStockGoodsTranfer {

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
	public AssetStockGoodsTranferVO setPageIndex(Integer pageIndex) {
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
	public AssetStockGoodsTranferVO setPageSize(Integer pageSize) {
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
	public AssetStockGoodsTranferVO setSearchField(String searchField) {
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
	public AssetStockGoodsTranferVO setFuzzyField(String fuzzyField) {
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
	public AssetStockGoodsTranferVO setSearchValue(String searchValue) {
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
	public AssetStockGoodsTranferVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetStockGoodsTranferVO addDirtyField(String... dirtyField) {
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
	public AssetStockGoodsTranferVO setSortField(String sortField) {
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
	public AssetStockGoodsTranferVO setSortType(String sortType) {
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
	public AssetStockGoodsTranferVO setDataOrigin(String dataOrigin) {
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
	public AssetStockGoodsTranferVO setQueryLogic(String queryLogic) {
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
	public AssetStockGoodsTranferVO setRequestAction(String requestAction) {
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
	public AssetStockGoodsTranferVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetStockGoodsTranferVO addId(String... id) {
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
	 * @return AssetStockGoodsTranferVO , 转换好的 AssetStockGoodsTranferVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetStockGoodsTranferVO , 转换好的 PoJo 对象
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
	public AssetStockGoodsTranferVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetStockGoodsTranferVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetStockGoodsTranferVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetStockGoodsTranferVOMeta.$$proxy$$();
		inst.setOwnerType(this.getOwnerType());
		inst.setChsVersion(this.getChsVersion());
		inst.setProcId(this.getProcId());
		inst.setLatestApproverName(this.getLatestApproverName());
		inst.setChangeInstanceId(this.getChangeInstanceId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setNextApproverIds(this.getNextApproverIds());
		inst.setApprovalOpinion(this.getApprovalOpinion());
		inst.setWarehouseOutId(this.getWarehouseOutId());
		inst.setChsStatus(this.getChsStatus());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setAttachId(this.getAttachId());
		inst.setSummary(this.getSummary());
		inst.setNextApproverNames(this.getNextApproverNames());
		inst.setWarehouseInId(this.getWarehouseInId());
		inst.setLatestApproverId(this.getLatestApproverId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setPositionInId(this.getPositionInId());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setChsType(this.getChsType());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setWarehouseOut(this.getWarehouseOut());
			inst.setWarehouseIn(this.getWarehouseIn());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setGoodsList(this.getGoodsList());
			inst.setPageSize(this.getPageSize());
			inst.setOriginator(this.getOriginator());
			inst.setWarehousePosition(this.getWarehousePosition());
			inst.setGoodsIds(this.getGoodsIds());
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
	public AssetStockGoodsTranferVO clone(boolean deep) {
		return EntityContext.clone(AssetStockGoodsTranferVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetStockGoodsTranferVO
	 * @param assetStockGoodsTranferMap 包含实体信息的 Map 对象
	 * @return AssetStockGoodsTranferVO , 转换好的的 AssetStockGoodsTranfer 对象
	*/
	@Transient
	public static AssetStockGoodsTranferVO createFrom(Map<String,Object> assetStockGoodsTranferMap) {
		if(assetStockGoodsTranferMap==null) return null;
		AssetStockGoodsTranferVO vo = create();
		EntityContext.copyProperties(vo,assetStockGoodsTranferMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetStockGoodsTranferVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetStockGoodsTranferVO , 转换好的的 AssetStockGoodsTranfer 对象
	*/
	@Transient
	public static AssetStockGoodsTranferVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetStockGoodsTranferVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetStockGoodsTranferVO，等同于 new
	 * @return AssetStockGoodsTranferVO 对象
	*/
	@Transient
	public static AssetStockGoodsTranferVO create() {
		return new com.dt.platform.domain.eam.meta.AssetStockGoodsTranferVOMeta.$$proxy$$();
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
			this.setOwnerType(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.OWNER_TYPE)));
			this.setChsVersion(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.CHS_VERSION)));
			this.setProcId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.CHANGE_INSTANCE_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.CONTENT)));
			this.setNextApproverIds(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.APPROVAL_OPINION)));
			this.setWarehouseOutId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.WAREHOUSE_OUT_ID)));
			this.setChsStatus(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.CHS_STATUS)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(AssetStockGoodsTranferVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.ORIGINATOR_ID)));
			this.setAttachId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.ATTACH_ID)));
			this.setSummary(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.NEXT_APPROVER_NAMES)));
			this.setWarehouseInId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.WAREHOUSE_IN_ID)));
			this.setLatestApproverId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.LATEST_APPROVER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetStockGoodsTranferVOMeta.UPDATE_TIME)));
			this.setPositionInId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.POSITION_IN_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetStockGoodsTranferVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetStockGoodsTranferVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetStockGoodsTranferVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetStockGoodsTranferVOMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.STATUS)));
			// others
			this.setWarehouseOut(DataParser.parse(Warehouse.class, map.get(AssetStockGoodsTranferVOMeta.WAREHOUSE_OUT)));
			this.setWarehouseIn(DataParser.parse(Warehouse.class, map.get(AssetStockGoodsTranferVOMeta.WAREHOUSE_IN)));
			this.setSearchField(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetStockGoodsTranferVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetStockGoodsTranferVOMeta.ORIGINATOR)));
			this.setWarehousePosition(DataParser.parse(WarehousePosition.class, map.get(AssetStockGoodsTranferVOMeta.WAREHOUSE_POSITION)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetStockGoodsTranferVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetStockGoodsTranferVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)map.get(AssetStockGoodsTranferVOMeta.OWNER_TYPE));
				this.setChsVersion( (String)map.get(AssetStockGoodsTranferVOMeta.CHS_VERSION));
				this.setProcId( (String)map.get(AssetStockGoodsTranferVOMeta.PROC_ID));
				this.setLatestApproverName( (String)map.get(AssetStockGoodsTranferVOMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)map.get(AssetStockGoodsTranferVOMeta.CHANGE_INSTANCE_ID));
				this.setSelectedCode( (String)map.get(AssetStockGoodsTranferVOMeta.SELECTED_CODE));
				this.setContent( (String)map.get(AssetStockGoodsTranferVOMeta.CONTENT));
				this.setNextApproverIds( (String)map.get(AssetStockGoodsTranferVOMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)map.get(AssetStockGoodsTranferVOMeta.APPROVAL_OPINION));
				this.setWarehouseOutId( (String)map.get(AssetStockGoodsTranferVOMeta.WAREHOUSE_OUT_ID));
				this.setChsStatus( (String)map.get(AssetStockGoodsTranferVOMeta.CHS_STATUS));
				this.setBusinessDate( (Date)map.get(AssetStockGoodsTranferVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(AssetStockGoodsTranferVOMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)map.get(AssetStockGoodsTranferVOMeta.UPDATE_BY));
				this.setId( (String)map.get(AssetStockGoodsTranferVOMeta.ID));
				this.setOriginatorId( (String)map.get(AssetStockGoodsTranferVOMeta.ORIGINATOR_ID));
				this.setAttachId( (String)map.get(AssetStockGoodsTranferVOMeta.ATTACH_ID));
				this.setSummary( (String)map.get(AssetStockGoodsTranferVOMeta.SUMMARY));
				this.setNextApproverNames( (String)map.get(AssetStockGoodsTranferVOMeta.NEXT_APPROVER_NAMES));
				this.setWarehouseInId( (String)map.get(AssetStockGoodsTranferVOMeta.WAREHOUSE_IN_ID));
				this.setLatestApproverId( (String)map.get(AssetStockGoodsTranferVOMeta.LATEST_APPROVER_ID));
				this.setUpdateTime( (Date)map.get(AssetStockGoodsTranferVOMeta.UPDATE_TIME));
				this.setPositionInId( (String)map.get(AssetStockGoodsTranferVOMeta.POSITION_IN_ID));
				this.setVersion( (Integer)map.get(AssetStockGoodsTranferVOMeta.VERSION));
				this.setCreateBy( (String)map.get(AssetStockGoodsTranferVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetStockGoodsTranferVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetStockGoodsTranferVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetStockGoodsTranferVOMeta.DELETE_TIME));
				this.setChsType( (String)map.get(AssetStockGoodsTranferVOMeta.CHS_TYPE));
				this.setName( (String)map.get(AssetStockGoodsTranferVOMeta.NAME));
				this.setTenantId( (String)map.get(AssetStockGoodsTranferVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetStockGoodsTranferVOMeta.DELETE_BY));
				this.setStatus( (String)map.get(AssetStockGoodsTranferVOMeta.STATUS));
				// others
				this.setWarehouseOut( (Warehouse)map.get(AssetStockGoodsTranferVOMeta.WAREHOUSE_OUT));
				this.setWarehouseIn( (Warehouse)map.get(AssetStockGoodsTranferVOMeta.WAREHOUSE_IN));
				this.setSearchField( (String)map.get(AssetStockGoodsTranferVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(AssetStockGoodsTranferVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(AssetStockGoodsTranferVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssetStockGoodsTranferVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(AssetStockGoodsTranferVOMeta.ORIGINATOR));
				this.setWarehousePosition( (WarehousePosition)map.get(AssetStockGoodsTranferVOMeta.WAREHOUSE_POSITION));
				this.setPageIndex( (Integer)map.get(AssetStockGoodsTranferVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetStockGoodsTranferVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(AssetStockGoodsTranferVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(AssetStockGoodsTranferVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(AssetStockGoodsTranferVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(AssetStockGoodsTranferVOMeta.SEARCH_VALUE));
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
			this.setOwnerType(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.OWNER_TYPE)));
			this.setChsVersion(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.CHS_VERSION)));
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.CHANGE_INSTANCE_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.CONTENT)));
			this.setNextApproverIds(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.APPROVAL_OPINION)));
			this.setWarehouseOutId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.WAREHOUSE_OUT_ID)));
			this.setChsStatus(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.CHS_STATUS)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(AssetStockGoodsTranferVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.ORIGINATOR_ID)));
			this.setAttachId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.ATTACH_ID)));
			this.setSummary(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.NEXT_APPROVER_NAMES)));
			this.setWarehouseInId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.WAREHOUSE_IN_ID)));
			this.setLatestApproverId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.LATEST_APPROVER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsTranferVOMeta.UPDATE_TIME)));
			this.setPositionInId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.POSITION_IN_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetStockGoodsTranferVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetStockGoodsTranferVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsTranferVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetStockGoodsTranferVOMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetStockGoodsTranferVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setOwnerType( (String)r.getValue(AssetStockGoodsTranferVOMeta.OWNER_TYPE));
				this.setChsVersion( (String)r.getValue(AssetStockGoodsTranferVOMeta.CHS_VERSION));
				this.setProcId( (String)r.getValue(AssetStockGoodsTranferVOMeta.PROC_ID));
				this.setLatestApproverName( (String)r.getValue(AssetStockGoodsTranferVOMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)r.getValue(AssetStockGoodsTranferVOMeta.CHANGE_INSTANCE_ID));
				this.setSelectedCode( (String)r.getValue(AssetStockGoodsTranferVOMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(AssetStockGoodsTranferVOMeta.CONTENT));
				this.setNextApproverIds( (String)r.getValue(AssetStockGoodsTranferVOMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)r.getValue(AssetStockGoodsTranferVOMeta.APPROVAL_OPINION));
				this.setWarehouseOutId( (String)r.getValue(AssetStockGoodsTranferVOMeta.WAREHOUSE_OUT_ID));
				this.setChsStatus( (String)r.getValue(AssetStockGoodsTranferVOMeta.CHS_STATUS));
				this.setBusinessDate( (Date)r.getValue(AssetStockGoodsTranferVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(AssetStockGoodsTranferVOMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)r.getValue(AssetStockGoodsTranferVOMeta.UPDATE_BY));
				this.setId( (String)r.getValue(AssetStockGoodsTranferVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetStockGoodsTranferVOMeta.ORIGINATOR_ID));
				this.setAttachId( (String)r.getValue(AssetStockGoodsTranferVOMeta.ATTACH_ID));
				this.setSummary( (String)r.getValue(AssetStockGoodsTranferVOMeta.SUMMARY));
				this.setNextApproverNames( (String)r.getValue(AssetStockGoodsTranferVOMeta.NEXT_APPROVER_NAMES));
				this.setWarehouseInId( (String)r.getValue(AssetStockGoodsTranferVOMeta.WAREHOUSE_IN_ID));
				this.setLatestApproverId( (String)r.getValue(AssetStockGoodsTranferVOMeta.LATEST_APPROVER_ID));
				this.setUpdateTime( (Date)r.getValue(AssetStockGoodsTranferVOMeta.UPDATE_TIME));
				this.setPositionInId( (String)r.getValue(AssetStockGoodsTranferVOMeta.POSITION_IN_ID));
				this.setVersion( (Integer)r.getValue(AssetStockGoodsTranferVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AssetStockGoodsTranferVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetStockGoodsTranferVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetStockGoodsTranferVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetStockGoodsTranferVOMeta.DELETE_TIME));
				this.setChsType( (String)r.getValue(AssetStockGoodsTranferVOMeta.CHS_TYPE));
				this.setName( (String)r.getValue(AssetStockGoodsTranferVOMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetStockGoodsTranferVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetStockGoodsTranferVOMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(AssetStockGoodsTranferVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}