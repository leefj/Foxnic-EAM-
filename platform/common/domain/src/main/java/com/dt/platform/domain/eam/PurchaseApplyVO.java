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
import com.dt.platform.domain.eam.meta.PurchaseApplyVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 采购申请VO类型
 * <p>采购申请 , 数据表 eam_purchase_apply 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-07 19:46:41
 * @sign 901BAD23D88C64D31FBF0F78680C4544
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "采购申请VO类型 ; 采购申请 , 数据表 eam_purchase_apply 的通用VO类型" , parent = PurchaseApply.class)
public class PurchaseApplyVO extends PurchaseApply {

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
	public PurchaseApplyVO setPageIndex(Integer pageIndex) {
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
	public PurchaseApplyVO setPageSize(Integer pageSize) {
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
	public PurchaseApplyVO setSearchField(String searchField) {
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
	public PurchaseApplyVO setFuzzyField(String fuzzyField) {
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
	public PurchaseApplyVO setSearchValue(String searchValue) {
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
	public PurchaseApplyVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public PurchaseApplyVO addDirtyField(String... dirtyField) {
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
	public PurchaseApplyVO setSortField(String sortField) {
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
	public PurchaseApplyVO setSortType(String sortType) {
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
	public PurchaseApplyVO setDataOrigin(String dataOrigin) {
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
	public PurchaseApplyVO setQueryLogic(String queryLogic) {
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
	public PurchaseApplyVO setRequestAction(String requestAction) {
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
	public PurchaseApplyVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public PurchaseApplyVO addId(String... id) {
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
	 * @return PurchaseApplyVO , 转换好的 PurchaseApplyVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PurchaseApplyVO , 转换好的 PoJo 对象
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
	public PurchaseApplyVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PurchaseApplyVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.PurchaseApplyVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.PurchaseApplyVOMeta.$$proxy$$();
		inst.setChsVersion(this.getChsVersion());
		inst.setSupplierId(this.getSupplierId());
		inst.setNotes(this.getNotes());
		inst.setProcId(this.getProcId());
		inst.setLatestApproverName(this.getLatestApproverName());
		inst.setChangeInstanceId(this.getChangeInstanceId());
		inst.setNextApproverIds(this.getNextApproverIds());
		inst.setApprovalOpinion(this.getApprovalOpinion());
		inst.setChsStatus(this.getChsStatus());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setExpectedArrivalDate(this.getExpectedArrivalDate());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setApplyContent(this.getApplyContent());
		inst.setAssetCheck(this.getAssetCheck());
		inst.setId(this.getId());
		inst.setAttach(this.getAttach());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setPurchaseUserId(this.getPurchaseUserId());
		inst.setSummary(this.getSummary());
		inst.setNextApproverNames(this.getNextApproverNames());
		inst.setApplyOrgId(this.getApplyOrgId());
		inst.setLatestApproverId(this.getLatestApproverId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setChsType(this.getChsType());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setApplyDate(this.getApplyDate());
		inst.setApplyStatus(this.getApplyStatus());
		inst.setCheckId(this.getCheckId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setApplyOrg(this.getApplyOrg());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setOrderList(this.getOrderList());
			inst.setPageSize(this.getPageSize());
			inst.setHistoricProcessList(this.getHistoricProcessList());
			inst.setOriginator(this.getOriginator());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setCurrentProcessList(this.getCurrentProcessList());
			inst.setDefaultProcess(this.getDefaultProcess());
			inst.setChangeInstance(this.getChangeInstance());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setSupplier(this.getSupplier());
			inst.setPurchaseUser(this.getPurchaseUser());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setOrderIds(this.getOrderIds());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PurchaseApplyVO clone(boolean deep) {
		return EntityContext.clone(PurchaseApplyVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PurchaseApplyVO
	 * @param purchaseApplyMap 包含实体信息的 Map 对象
	 * @return PurchaseApplyVO , 转换好的的 PurchaseApply 对象
	*/
	@Transient
	public static PurchaseApplyVO createFrom(Map<String,Object> purchaseApplyMap) {
		if(purchaseApplyMap==null) return null;
		PurchaseApplyVO vo = create();
		EntityContext.copyProperties(vo,purchaseApplyMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 PurchaseApplyVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PurchaseApplyVO , 转换好的的 PurchaseApply 对象
	*/
	@Transient
	public static PurchaseApplyVO createFrom(Object pojo) {
		if(pojo==null) return null;
		PurchaseApplyVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 PurchaseApplyVO，等同于 new
	 * @return PurchaseApplyVO 对象
	*/
	@Transient
	public static PurchaseApplyVO create() {
		return new com.dt.platform.domain.eam.meta.PurchaseApplyVOMeta.$$proxy$$();
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
			this.setChsVersion(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.CHS_VERSION)));
			this.setSupplierId(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.SUPPLIER_ID)));
			this.setNotes(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.NOTES)));
			this.setProcId(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.CHANGE_INSTANCE_ID)));
			this.setNextApproverIds(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.APPROVAL_OPINION)));
			this.setChsStatus(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.CHS_STATUS)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.BUSINESS_CODE)));
			this.setExpectedArrivalDate(DataParser.parse(Date.class, map.get(PurchaseApplyVOMeta.EXPECTED_ARRIVAL_DATE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.UPDATE_BY)));
			this.setApplyContent(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.APPLY_CONTENT)));
			this.setAssetCheck(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.ASSET_CHECK)));
			this.setId(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.ID)));
			this.setAttach(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.ATTACH)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.ORIGINATOR_ID)));
			this.setPurchaseUserId(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.PURCHASE_USER_ID)));
			this.setSummary(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.NEXT_APPROVER_NAMES)));
			this.setApplyOrgId(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.APPLY_ORG_ID)));
			this.setLatestApproverId(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.LATEST_APPROVER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PurchaseApplyVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PurchaseApplyVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PurchaseApplyVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PurchaseApplyVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PurchaseApplyVOMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.DELETE_BY)));
			this.setApplyDate(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.APPLY_DATE)));
			this.setApplyStatus(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.APPLY_STATUS)));
			this.setCheckId(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.CHECK_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.STATUS)));
			// others
			this.setApplyOrg(DataParser.parse(Organization.class, map.get(PurchaseApplyVOMeta.APPLY_ORG)));
			this.setSearchField(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(PurchaseApplyVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(PurchaseApplyVOMeta.ORIGINATOR)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.SELECTED_CODE)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(PurchaseApplyVOMeta.DEFAULT_PROCESS)));
			this.setChangeInstance(DataParser.parse(ChangeInstance.class, map.get(PurchaseApplyVOMeta.CHANGE_INSTANCE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(PurchaseApplyVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.SORT_TYPE)));
			this.setSupplier(DataParser.parse(Supplier.class, map.get(PurchaseApplyVOMeta.SUPPLIER)));
			this.setPurchaseUser(DataParser.parse(Employee.class, map.get(PurchaseApplyVOMeta.PURCHASE_USER)));
			this.setSortField(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(PurchaseApplyVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setChsVersion( (String)map.get(PurchaseApplyVOMeta.CHS_VERSION));
				this.setSupplierId( (String)map.get(PurchaseApplyVOMeta.SUPPLIER_ID));
				this.setNotes( (String)map.get(PurchaseApplyVOMeta.NOTES));
				this.setProcId( (String)map.get(PurchaseApplyVOMeta.PROC_ID));
				this.setLatestApproverName( (String)map.get(PurchaseApplyVOMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)map.get(PurchaseApplyVOMeta.CHANGE_INSTANCE_ID));
				this.setNextApproverIds( (String)map.get(PurchaseApplyVOMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)map.get(PurchaseApplyVOMeta.APPROVAL_OPINION));
				this.setChsStatus( (String)map.get(PurchaseApplyVOMeta.CHS_STATUS));
				this.setBusinessCode( (String)map.get(PurchaseApplyVOMeta.BUSINESS_CODE));
				this.setExpectedArrivalDate( (Date)map.get(PurchaseApplyVOMeta.EXPECTED_ARRIVAL_DATE));
				this.setUpdateBy( (String)map.get(PurchaseApplyVOMeta.UPDATE_BY));
				this.setApplyContent( (String)map.get(PurchaseApplyVOMeta.APPLY_CONTENT));
				this.setAssetCheck( (String)map.get(PurchaseApplyVOMeta.ASSET_CHECK));
				this.setId( (String)map.get(PurchaseApplyVOMeta.ID));
				this.setAttach( (String)map.get(PurchaseApplyVOMeta.ATTACH));
				this.setOriginatorId( (String)map.get(PurchaseApplyVOMeta.ORIGINATOR_ID));
				this.setPurchaseUserId( (String)map.get(PurchaseApplyVOMeta.PURCHASE_USER_ID));
				this.setSummary( (String)map.get(PurchaseApplyVOMeta.SUMMARY));
				this.setNextApproverNames( (String)map.get(PurchaseApplyVOMeta.NEXT_APPROVER_NAMES));
				this.setApplyOrgId( (String)map.get(PurchaseApplyVOMeta.APPLY_ORG_ID));
				this.setLatestApproverId( (String)map.get(PurchaseApplyVOMeta.LATEST_APPROVER_ID));
				this.setUpdateTime( (Date)map.get(PurchaseApplyVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PurchaseApplyVOMeta.VERSION));
				this.setCreateBy( (String)map.get(PurchaseApplyVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PurchaseApplyVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(PurchaseApplyVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(PurchaseApplyVOMeta.DELETE_TIME));
				this.setChsType( (String)map.get(PurchaseApplyVOMeta.CHS_TYPE));
				this.setName( (String)map.get(PurchaseApplyVOMeta.NAME));
				this.setTenantId( (String)map.get(PurchaseApplyVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PurchaseApplyVOMeta.DELETE_BY));
				this.setApplyDate( (String)map.get(PurchaseApplyVOMeta.APPLY_DATE));
				this.setApplyStatus( (String)map.get(PurchaseApplyVOMeta.APPLY_STATUS));
				this.setCheckId( (String)map.get(PurchaseApplyVOMeta.CHECK_ID));
				this.setStatus( (String)map.get(PurchaseApplyVOMeta.STATUS));
				// others
				this.setApplyOrg( (Organization)map.get(PurchaseApplyVOMeta.APPLY_ORG));
				this.setSearchField( (String)map.get(PurchaseApplyVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(PurchaseApplyVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(PurchaseApplyVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(PurchaseApplyVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(PurchaseApplyVOMeta.ORIGINATOR));
				this.setSelectedCode( (String)map.get(PurchaseApplyVOMeta.SELECTED_CODE));
				this.setDefaultProcess( (ProcessInstance)map.get(PurchaseApplyVOMeta.DEFAULT_PROCESS));
				this.setChangeInstance( (ChangeInstance)map.get(PurchaseApplyVOMeta.CHANGE_INSTANCE));
				this.setPageIndex( (Integer)map.get(PurchaseApplyVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(PurchaseApplyVOMeta.SORT_TYPE));
				this.setSupplier( (Supplier)map.get(PurchaseApplyVOMeta.SUPPLIER));
				this.setPurchaseUser( (Employee)map.get(PurchaseApplyVOMeta.PURCHASE_USER));
				this.setSortField( (String)map.get(PurchaseApplyVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(PurchaseApplyVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(PurchaseApplyVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(PurchaseApplyVOMeta.SEARCH_VALUE));
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
			this.setChsVersion(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.CHS_VERSION)));
			this.setSupplierId(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.SUPPLIER_ID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.NOTES)));
			this.setProcId(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.CHANGE_INSTANCE_ID)));
			this.setNextApproverIds(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.APPROVAL_OPINION)));
			this.setChsStatus(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.CHS_STATUS)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.BUSINESS_CODE)));
			this.setExpectedArrivalDate(DataParser.parse(Date.class, r.getValue(PurchaseApplyVOMeta.EXPECTED_ARRIVAL_DATE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.UPDATE_BY)));
			this.setApplyContent(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.APPLY_CONTENT)));
			this.setAssetCheck(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.ASSET_CHECK)));
			this.setId(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.ATTACH)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.ORIGINATOR_ID)));
			this.setPurchaseUserId(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.PURCHASE_USER_ID)));
			this.setSummary(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.NEXT_APPROVER_NAMES)));
			this.setApplyOrgId(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.APPLY_ORG_ID)));
			this.setLatestApproverId(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.LATEST_APPROVER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PurchaseApplyVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PurchaseApplyVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PurchaseApplyVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PurchaseApplyVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PurchaseApplyVOMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.DELETE_BY)));
			this.setApplyDate(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.APPLY_DATE)));
			this.setApplyStatus(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.APPLY_STATUS)));
			this.setCheckId(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.CHECK_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PurchaseApplyVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setChsVersion( (String)r.getValue(PurchaseApplyVOMeta.CHS_VERSION));
				this.setSupplierId( (String)r.getValue(PurchaseApplyVOMeta.SUPPLIER_ID));
				this.setNotes( (String)r.getValue(PurchaseApplyVOMeta.NOTES));
				this.setProcId( (String)r.getValue(PurchaseApplyVOMeta.PROC_ID));
				this.setLatestApproverName( (String)r.getValue(PurchaseApplyVOMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)r.getValue(PurchaseApplyVOMeta.CHANGE_INSTANCE_ID));
				this.setNextApproverIds( (String)r.getValue(PurchaseApplyVOMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)r.getValue(PurchaseApplyVOMeta.APPROVAL_OPINION));
				this.setChsStatus( (String)r.getValue(PurchaseApplyVOMeta.CHS_STATUS));
				this.setBusinessCode( (String)r.getValue(PurchaseApplyVOMeta.BUSINESS_CODE));
				this.setExpectedArrivalDate( (Date)r.getValue(PurchaseApplyVOMeta.EXPECTED_ARRIVAL_DATE));
				this.setUpdateBy( (String)r.getValue(PurchaseApplyVOMeta.UPDATE_BY));
				this.setApplyContent( (String)r.getValue(PurchaseApplyVOMeta.APPLY_CONTENT));
				this.setAssetCheck( (String)r.getValue(PurchaseApplyVOMeta.ASSET_CHECK));
				this.setId( (String)r.getValue(PurchaseApplyVOMeta.ID));
				this.setAttach( (String)r.getValue(PurchaseApplyVOMeta.ATTACH));
				this.setOriginatorId( (String)r.getValue(PurchaseApplyVOMeta.ORIGINATOR_ID));
				this.setPurchaseUserId( (String)r.getValue(PurchaseApplyVOMeta.PURCHASE_USER_ID));
				this.setSummary( (String)r.getValue(PurchaseApplyVOMeta.SUMMARY));
				this.setNextApproverNames( (String)r.getValue(PurchaseApplyVOMeta.NEXT_APPROVER_NAMES));
				this.setApplyOrgId( (String)r.getValue(PurchaseApplyVOMeta.APPLY_ORG_ID));
				this.setLatestApproverId( (String)r.getValue(PurchaseApplyVOMeta.LATEST_APPROVER_ID));
				this.setUpdateTime( (Date)r.getValue(PurchaseApplyVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PurchaseApplyVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(PurchaseApplyVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PurchaseApplyVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PurchaseApplyVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(PurchaseApplyVOMeta.DELETE_TIME));
				this.setChsType( (String)r.getValue(PurchaseApplyVOMeta.CHS_TYPE));
				this.setName( (String)r.getValue(PurchaseApplyVOMeta.NAME));
				this.setTenantId( (String)r.getValue(PurchaseApplyVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PurchaseApplyVOMeta.DELETE_BY));
				this.setApplyDate( (String)r.getValue(PurchaseApplyVOMeta.APPLY_DATE));
				this.setApplyStatus( (String)r.getValue(PurchaseApplyVOMeta.APPLY_STATUS));
				this.setCheckId( (String)r.getValue(PurchaseApplyVOMeta.CHECK_ID));
				this.setStatus( (String)r.getValue(PurchaseApplyVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}