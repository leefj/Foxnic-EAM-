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
import com.dt.platform.domain.eam.meta.AssetScrapVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产报废VO类型
 * <p>资产报废 , 数据表 eam_asset_scrap 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-12-01 13:09:54
 * @sign C914A8DEB0C0974A724E1E878028E6EF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "资产报废VO类型 ; 资产报废 , 数据表 eam_asset_scrap 的通用VO类型" , parent = AssetScrap.class)
public class AssetScrapVO extends AssetScrap {

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
	public AssetScrapVO setPageIndex(Integer pageIndex) {
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
	public AssetScrapVO setPageSize(Integer pageSize) {
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
	public AssetScrapVO setSearchField(String searchField) {
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
	public AssetScrapVO setFuzzyField(String fuzzyField) {
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
	public AssetScrapVO setSearchValue(String searchValue) {
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
	public AssetScrapVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetScrapVO addDirtyField(String... dirtyField) {
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
	public AssetScrapVO setSortField(String sortField) {
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
	public AssetScrapVO setSortType(String sortType) {
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
	public AssetScrapVO setDataOrigin(String dataOrigin) {
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
	public AssetScrapVO setQueryLogic(String queryLogic) {
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
	public AssetScrapVO setRequestAction(String requestAction) {
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
	public AssetScrapVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetScrapVO addId(String... id) {
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
	 * @return AssetScrapVO , 转换好的 AssetScrapVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetScrapVO , 转换好的 PoJo 对象
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
	public AssetScrapVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetScrapVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetScrapVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetScrapVOMeta.$$proxy$$();
		inst.setChsVersion(this.getChsVersion());
		inst.setCleanStatus(this.getCleanStatus());
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
		inst.setAttach(this.getAttach());
		inst.setSummary(this.getSummary());
		inst.setNextApproverNames(this.getNextApproverNames());
		inst.setLatestApproverId(this.getLatestApproverId());
		inst.setMethod(this.getMethod());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setChsType(this.getChsType());
		inst.setScrapDate(this.getScrapDate());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setAssetIds(this.getAssetIds());
			inst.setPageSize(this.getPageSize());
			inst.setHistoricProcessList(this.getHistoricProcessList());
			inst.setOriginator(this.getOriginator());
			inst.setAssetList(this.getAssetList());
			inst.setOriginatorUserName(this.getOriginatorUserName());
			inst.setCurrentProcessList(this.getCurrentProcessList());
			inst.setDefaultProcess(this.getDefaultProcess());
			inst.setChangeInstance(this.getChangeInstance());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setMethodDict(this.getMethodDict());
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
	public AssetScrapVO clone(boolean deep) {
		return EntityContext.clone(AssetScrapVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetScrapVO
	 * @param assetScrapMap 包含实体信息的 Map 对象
	 * @return AssetScrapVO , 转换好的的 AssetScrap 对象
	*/
	@Transient
	public static AssetScrapVO createFrom(Map<String,Object> assetScrapMap) {
		if(assetScrapMap==null) return null;
		AssetScrapVO vo = create();
		EntityContext.copyProperties(vo,assetScrapMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetScrapVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetScrapVO , 转换好的的 AssetScrap 对象
	*/
	@Transient
	public static AssetScrapVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetScrapVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetScrapVO，等同于 new
	 * @return AssetScrapVO 对象
	*/
	@Transient
	public static AssetScrapVO create() {
		return new com.dt.platform.domain.eam.meta.AssetScrapVOMeta.$$proxy$$();
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
			this.setChsVersion(DataParser.parse(String.class, map.get(AssetScrapVOMeta.CHS_VERSION)));
			this.setCleanStatus(DataParser.parse(String.class, map.get(AssetScrapVOMeta.CLEAN_STATUS)));
			this.setProcId(DataParser.parse(String.class, map.get(AssetScrapVOMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, map.get(AssetScrapVOMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, map.get(AssetScrapVOMeta.CHANGE_INSTANCE_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetScrapVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(AssetScrapVOMeta.CONTENT)));
			this.setNextApproverIds(DataParser.parse(String.class, map.get(AssetScrapVOMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, map.get(AssetScrapVOMeta.APPROVAL_OPINION)));
			this.setChsStatus(DataParser.parse(String.class, map.get(AssetScrapVOMeta.CHS_STATUS)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(AssetScrapVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetScrapVOMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetScrapVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetScrapVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetScrapVOMeta.ORIGINATOR_ID)));
			this.setAttach(DataParser.parse(String.class, map.get(AssetScrapVOMeta.ATTACH)));
			this.setSummary(DataParser.parse(String.class, map.get(AssetScrapVOMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, map.get(AssetScrapVOMeta.NEXT_APPROVER_NAMES)));
			this.setLatestApproverId(DataParser.parse(String.class, map.get(AssetScrapVOMeta.LATEST_APPROVER_ID)));
			this.setMethod(DataParser.parse(String.class, map.get(AssetScrapVOMeta.METHOD)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetScrapVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetScrapVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetScrapVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetScrapVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetScrapVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetScrapVOMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, map.get(AssetScrapVOMeta.CHS_TYPE)));
			this.setScrapDate(DataParser.parse(String.class, map.get(AssetScrapVOMeta.SCRAP_DATE)));
			this.setName(DataParser.parse(String.class, map.get(AssetScrapVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetScrapVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetScrapVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetScrapVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AssetScrapVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AssetScrapVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetScrapVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetScrapVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetScrapVOMeta.ORIGINATOR)));
			this.setOriginatorUserName(DataParser.parse(String.class, map.get(AssetScrapVOMeta.ORIGINATOR_USER_NAME)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(AssetScrapVOMeta.DEFAULT_PROCESS)));
			this.setChangeInstance(DataParser.parse(ChangeInstance.class, map.get(AssetScrapVOMeta.CHANGE_INSTANCE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetScrapVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetScrapVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetScrapVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AssetScrapVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AssetScrapVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetScrapVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setChsVersion( (String)map.get(AssetScrapVOMeta.CHS_VERSION));
				this.setCleanStatus( (String)map.get(AssetScrapVOMeta.CLEAN_STATUS));
				this.setProcId( (String)map.get(AssetScrapVOMeta.PROC_ID));
				this.setLatestApproverName( (String)map.get(AssetScrapVOMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)map.get(AssetScrapVOMeta.CHANGE_INSTANCE_ID));
				this.setSelectedCode( (String)map.get(AssetScrapVOMeta.SELECTED_CODE));
				this.setContent( (String)map.get(AssetScrapVOMeta.CONTENT));
				this.setNextApproverIds( (String)map.get(AssetScrapVOMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)map.get(AssetScrapVOMeta.APPROVAL_OPINION));
				this.setChsStatus( (String)map.get(AssetScrapVOMeta.CHS_STATUS));
				this.setBusinessDate( (Date)map.get(AssetScrapVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(AssetScrapVOMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)map.get(AssetScrapVOMeta.UPDATE_BY));
				this.setId( (String)map.get(AssetScrapVOMeta.ID));
				this.setOriginatorId( (String)map.get(AssetScrapVOMeta.ORIGINATOR_ID));
				this.setAttach( (String)map.get(AssetScrapVOMeta.ATTACH));
				this.setSummary( (String)map.get(AssetScrapVOMeta.SUMMARY));
				this.setNextApproverNames( (String)map.get(AssetScrapVOMeta.NEXT_APPROVER_NAMES));
				this.setLatestApproverId( (String)map.get(AssetScrapVOMeta.LATEST_APPROVER_ID));
				this.setMethod( (String)map.get(AssetScrapVOMeta.METHOD));
				this.setUpdateTime( (Date)map.get(AssetScrapVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetScrapVOMeta.VERSION));
				this.setCreateBy( (String)map.get(AssetScrapVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetScrapVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetScrapVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetScrapVOMeta.DELETE_TIME));
				this.setChsType( (String)map.get(AssetScrapVOMeta.CHS_TYPE));
				this.setScrapDate( (String)map.get(AssetScrapVOMeta.SCRAP_DATE));
				this.setName( (String)map.get(AssetScrapVOMeta.NAME));
				this.setTenantId( (String)map.get(AssetScrapVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetScrapVOMeta.DELETE_BY));
				this.setStatus( (String)map.get(AssetScrapVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(AssetScrapVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(AssetScrapVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(AssetScrapVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssetScrapVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(AssetScrapVOMeta.ORIGINATOR));
				this.setOriginatorUserName( (String)map.get(AssetScrapVOMeta.ORIGINATOR_USER_NAME));
				this.setDefaultProcess( (ProcessInstance)map.get(AssetScrapVOMeta.DEFAULT_PROCESS));
				this.setChangeInstance( (ChangeInstance)map.get(AssetScrapVOMeta.CHANGE_INSTANCE));
				this.setPageIndex( (Integer)map.get(AssetScrapVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetScrapVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(AssetScrapVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(AssetScrapVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(AssetScrapVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(AssetScrapVOMeta.SEARCH_VALUE));
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
			this.setChsVersion(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.CHS_VERSION)));
			this.setCleanStatus(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.CLEAN_STATUS)));
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.CHANGE_INSTANCE_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.CONTENT)));
			this.setNextApproverIds(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.APPROVAL_OPINION)));
			this.setChsStatus(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.CHS_STATUS)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(AssetScrapVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.ORIGINATOR_ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.ATTACH)));
			this.setSummary(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.NEXT_APPROVER_NAMES)));
			this.setLatestApproverId(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.LATEST_APPROVER_ID)));
			this.setMethod(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.METHOD)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetScrapVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetScrapVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetScrapVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetScrapVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetScrapVOMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.CHS_TYPE)));
			this.setScrapDate(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.SCRAP_DATE)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetScrapVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setChsVersion( (String)r.getValue(AssetScrapVOMeta.CHS_VERSION));
				this.setCleanStatus( (String)r.getValue(AssetScrapVOMeta.CLEAN_STATUS));
				this.setProcId( (String)r.getValue(AssetScrapVOMeta.PROC_ID));
				this.setLatestApproverName( (String)r.getValue(AssetScrapVOMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)r.getValue(AssetScrapVOMeta.CHANGE_INSTANCE_ID));
				this.setSelectedCode( (String)r.getValue(AssetScrapVOMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(AssetScrapVOMeta.CONTENT));
				this.setNextApproverIds( (String)r.getValue(AssetScrapVOMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)r.getValue(AssetScrapVOMeta.APPROVAL_OPINION));
				this.setChsStatus( (String)r.getValue(AssetScrapVOMeta.CHS_STATUS));
				this.setBusinessDate( (Date)r.getValue(AssetScrapVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(AssetScrapVOMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)r.getValue(AssetScrapVOMeta.UPDATE_BY));
				this.setId( (String)r.getValue(AssetScrapVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetScrapVOMeta.ORIGINATOR_ID));
				this.setAttach( (String)r.getValue(AssetScrapVOMeta.ATTACH));
				this.setSummary( (String)r.getValue(AssetScrapVOMeta.SUMMARY));
				this.setNextApproverNames( (String)r.getValue(AssetScrapVOMeta.NEXT_APPROVER_NAMES));
				this.setLatestApproverId( (String)r.getValue(AssetScrapVOMeta.LATEST_APPROVER_ID));
				this.setMethod( (String)r.getValue(AssetScrapVOMeta.METHOD));
				this.setUpdateTime( (Date)r.getValue(AssetScrapVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetScrapVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AssetScrapVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetScrapVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetScrapVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetScrapVOMeta.DELETE_TIME));
				this.setChsType( (String)r.getValue(AssetScrapVOMeta.CHS_TYPE));
				this.setScrapDate( (String)r.getValue(AssetScrapVOMeta.SCRAP_DATE));
				this.setName( (String)r.getValue(AssetScrapVOMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetScrapVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetScrapVOMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(AssetScrapVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}