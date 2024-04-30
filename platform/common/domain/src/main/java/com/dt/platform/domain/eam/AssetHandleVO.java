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
import com.dt.platform.domain.eam.meta.AssetHandleVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产处置VO类型
 * <p>资产处置 , 数据表 eam_asset_handle 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-04-30 14:22:53
 * @sign 83DF4E470A2648DFAAF2835CBA0DD56B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "资产处置VO类型 ; 资产处置 , 数据表 eam_asset_handle 的通用VO类型" , parent = AssetHandle.class)
public class AssetHandleVO extends AssetHandle {

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
	public AssetHandleVO setPageIndex(Integer pageIndex) {
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
	public AssetHandleVO setPageSize(Integer pageSize) {
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
	public AssetHandleVO setSearchField(String searchField) {
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
	public AssetHandleVO setFuzzyField(String fuzzyField) {
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
	public AssetHandleVO setSearchValue(String searchValue) {
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
	public AssetHandleVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetHandleVO addDirtyField(String... dirtyField) {
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
	public AssetHandleVO setSortField(String sortField) {
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
	public AssetHandleVO setSortType(String sortType) {
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
	public AssetHandleVO setDataOrigin(String dataOrigin) {
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
	public AssetHandleVO setQueryLogic(String queryLogic) {
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
	public AssetHandleVO setRequestAction(String requestAction) {
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
	public AssetHandleVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetHandleVO addId(String... id) {
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
	 * @return AssetHandleVO , 转换好的 AssetHandleVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetHandleVO , 转换好的 PoJo 对象
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
	public AssetHandleVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetHandleVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetHandleVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetHandleVOMeta.$$proxy$$();
		inst.setChsVersion(this.getChsVersion());
		inst.setNotes(this.getNotes());
		inst.setProcId(this.getProcId());
		inst.setLatestApproverName(this.getLatestApproverName());
		inst.setChangeInstanceId(this.getChangeInstanceId());
		inst.setType(this.getType());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setNextApproverIds(this.getNextApproverIds());
		inst.setApprovalOpinion(this.getApprovalOpinion());
		inst.setChsStatus(this.getChsStatus());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setSummary(this.getSummary());
		inst.setNextApproverNames(this.getNextApproverNames());
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
		inst.setPlanFinishDate(this.getPlanFinishDate());
		inst.setStatus(this.getStatus());
		inst.setFileId(this.getFileId());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setAssetIds(this.getAssetIds());
			inst.setPageSize(this.getPageSize());
			inst.setHistoricProcessList(this.getHistoricProcessList());
			inst.setOriginator(this.getOriginator());
			inst.setAssetList(this.getAssetList());
			inst.setCurrentProcessList(this.getCurrentProcessList());
			inst.setDefaultProcess(this.getDefaultProcess());
			inst.setAssetHandleType(this.getAssetHandleType());
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
	public AssetHandleVO clone(boolean deep) {
		return EntityContext.clone(AssetHandleVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetHandleVO
	 * @param assetHandleMap 包含实体信息的 Map 对象
	 * @return AssetHandleVO , 转换好的的 AssetHandle 对象
	*/
	@Transient
	public static AssetHandleVO createFrom(Map<String,Object> assetHandleMap) {
		if(assetHandleMap==null) return null;
		AssetHandleVO vo = create();
		EntityContext.copyProperties(vo,assetHandleMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetHandleVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetHandleVO , 转换好的的 AssetHandle 对象
	*/
	@Transient
	public static AssetHandleVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetHandleVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetHandleVO，等同于 new
	 * @return AssetHandleVO 对象
	*/
	@Transient
	public static AssetHandleVO create() {
		return new com.dt.platform.domain.eam.meta.AssetHandleVOMeta.$$proxy$$();
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
			this.setChsVersion(DataParser.parse(String.class, map.get(AssetHandleVOMeta.CHS_VERSION)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetHandleVOMeta.NOTES)));
			this.setProcId(DataParser.parse(String.class, map.get(AssetHandleVOMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, map.get(AssetHandleVOMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, map.get(AssetHandleVOMeta.CHANGE_INSTANCE_ID)));
			this.setType(DataParser.parse(String.class, map.get(AssetHandleVOMeta.TYPE)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetHandleVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(AssetHandleVOMeta.CONTENT)));
			this.setNextApproverIds(DataParser.parse(String.class, map.get(AssetHandleVOMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, map.get(AssetHandleVOMeta.APPROVAL_OPINION)));
			this.setChsStatus(DataParser.parse(String.class, map.get(AssetHandleVOMeta.CHS_STATUS)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetHandleVOMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetHandleVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetHandleVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetHandleVOMeta.ORIGINATOR_ID)));
			this.setSummary(DataParser.parse(String.class, map.get(AssetHandleVOMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, map.get(AssetHandleVOMeta.NEXT_APPROVER_NAMES)));
			this.setLatestApproverId(DataParser.parse(String.class, map.get(AssetHandleVOMeta.LATEST_APPROVER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetHandleVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetHandleVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetHandleVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetHandleVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetHandleVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetHandleVOMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, map.get(AssetHandleVOMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, map.get(AssetHandleVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetHandleVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetHandleVOMeta.DELETE_BY)));
			this.setPlanFinishDate(DataParser.parse(Date.class, map.get(AssetHandleVOMeta.PLAN_FINISH_DATE)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetHandleVOMeta.STATUS)));
			this.setFileId(DataParser.parse(String.class, map.get(AssetHandleVOMeta.FILE_ID)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AssetHandleVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AssetHandleVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetHandleVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetHandleVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetHandleVOMeta.ORIGINATOR)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(AssetHandleVOMeta.DEFAULT_PROCESS)));
			this.setAssetHandleType(DataParser.parse(AssetHandleType.class, map.get(AssetHandleVOMeta.ASSET_HANDLE_TYPE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetHandleVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetHandleVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetHandleVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AssetHandleVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AssetHandleVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetHandleVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setChsVersion( (String)map.get(AssetHandleVOMeta.CHS_VERSION));
				this.setNotes( (String)map.get(AssetHandleVOMeta.NOTES));
				this.setProcId( (String)map.get(AssetHandleVOMeta.PROC_ID));
				this.setLatestApproverName( (String)map.get(AssetHandleVOMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)map.get(AssetHandleVOMeta.CHANGE_INSTANCE_ID));
				this.setType( (String)map.get(AssetHandleVOMeta.TYPE));
				this.setSelectedCode( (String)map.get(AssetHandleVOMeta.SELECTED_CODE));
				this.setContent( (String)map.get(AssetHandleVOMeta.CONTENT));
				this.setNextApproverIds( (String)map.get(AssetHandleVOMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)map.get(AssetHandleVOMeta.APPROVAL_OPINION));
				this.setChsStatus( (String)map.get(AssetHandleVOMeta.CHS_STATUS));
				this.setBusinessCode( (String)map.get(AssetHandleVOMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)map.get(AssetHandleVOMeta.UPDATE_BY));
				this.setId( (String)map.get(AssetHandleVOMeta.ID));
				this.setOriginatorId( (String)map.get(AssetHandleVOMeta.ORIGINATOR_ID));
				this.setSummary( (String)map.get(AssetHandleVOMeta.SUMMARY));
				this.setNextApproverNames( (String)map.get(AssetHandleVOMeta.NEXT_APPROVER_NAMES));
				this.setLatestApproverId( (String)map.get(AssetHandleVOMeta.LATEST_APPROVER_ID));
				this.setUpdateTime( (Date)map.get(AssetHandleVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetHandleVOMeta.VERSION));
				this.setCreateBy( (String)map.get(AssetHandleVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetHandleVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetHandleVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetHandleVOMeta.DELETE_TIME));
				this.setChsType( (String)map.get(AssetHandleVOMeta.CHS_TYPE));
				this.setName( (String)map.get(AssetHandleVOMeta.NAME));
				this.setTenantId( (String)map.get(AssetHandleVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetHandleVOMeta.DELETE_BY));
				this.setPlanFinishDate( (Date)map.get(AssetHandleVOMeta.PLAN_FINISH_DATE));
				this.setStatus( (String)map.get(AssetHandleVOMeta.STATUS));
				this.setFileId( (String)map.get(AssetHandleVOMeta.FILE_ID));
				// others
				this.setSearchField( (String)map.get(AssetHandleVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(AssetHandleVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(AssetHandleVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssetHandleVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(AssetHandleVOMeta.ORIGINATOR));
				this.setDefaultProcess( (ProcessInstance)map.get(AssetHandleVOMeta.DEFAULT_PROCESS));
				this.setAssetHandleType( (AssetHandleType)map.get(AssetHandleVOMeta.ASSET_HANDLE_TYPE));
				this.setPageIndex( (Integer)map.get(AssetHandleVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetHandleVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(AssetHandleVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(AssetHandleVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(AssetHandleVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(AssetHandleVOMeta.SEARCH_VALUE));
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
			this.setChsVersion(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.CHS_VERSION)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.NOTES)));
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.PROC_ID)));
			this.setLatestApproverName(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.LATEST_APPROVER_NAME)));
			this.setChangeInstanceId(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.CHANGE_INSTANCE_ID)));
			this.setType(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.TYPE)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.CONTENT)));
			this.setNextApproverIds(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.NEXT_APPROVER_IDS)));
			this.setApprovalOpinion(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.APPROVAL_OPINION)));
			this.setChsStatus(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.CHS_STATUS)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.ORIGINATOR_ID)));
			this.setSummary(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.SUMMARY)));
			this.setNextApproverNames(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.NEXT_APPROVER_NAMES)));
			this.setLatestApproverId(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.LATEST_APPROVER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetHandleVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetHandleVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetHandleVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetHandleVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetHandleVOMeta.DELETE_TIME)));
			this.setChsType(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.CHS_TYPE)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.DELETE_BY)));
			this.setPlanFinishDate(DataParser.parse(Date.class, r.getValue(AssetHandleVOMeta.PLAN_FINISH_DATE)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.STATUS)));
			this.setFileId(DataParser.parse(String.class, r.getValue(AssetHandleVOMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setChsVersion( (String)r.getValue(AssetHandleVOMeta.CHS_VERSION));
				this.setNotes( (String)r.getValue(AssetHandleVOMeta.NOTES));
				this.setProcId( (String)r.getValue(AssetHandleVOMeta.PROC_ID));
				this.setLatestApproverName( (String)r.getValue(AssetHandleVOMeta.LATEST_APPROVER_NAME));
				this.setChangeInstanceId( (String)r.getValue(AssetHandleVOMeta.CHANGE_INSTANCE_ID));
				this.setType( (String)r.getValue(AssetHandleVOMeta.TYPE));
				this.setSelectedCode( (String)r.getValue(AssetHandleVOMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(AssetHandleVOMeta.CONTENT));
				this.setNextApproverIds( (String)r.getValue(AssetHandleVOMeta.NEXT_APPROVER_IDS));
				this.setApprovalOpinion( (String)r.getValue(AssetHandleVOMeta.APPROVAL_OPINION));
				this.setChsStatus( (String)r.getValue(AssetHandleVOMeta.CHS_STATUS));
				this.setBusinessCode( (String)r.getValue(AssetHandleVOMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)r.getValue(AssetHandleVOMeta.UPDATE_BY));
				this.setId( (String)r.getValue(AssetHandleVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetHandleVOMeta.ORIGINATOR_ID));
				this.setSummary( (String)r.getValue(AssetHandleVOMeta.SUMMARY));
				this.setNextApproverNames( (String)r.getValue(AssetHandleVOMeta.NEXT_APPROVER_NAMES));
				this.setLatestApproverId( (String)r.getValue(AssetHandleVOMeta.LATEST_APPROVER_ID));
				this.setUpdateTime( (Date)r.getValue(AssetHandleVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetHandleVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AssetHandleVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetHandleVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetHandleVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetHandleVOMeta.DELETE_TIME));
				this.setChsType( (String)r.getValue(AssetHandleVOMeta.CHS_TYPE));
				this.setName( (String)r.getValue(AssetHandleVOMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetHandleVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetHandleVOMeta.DELETE_BY));
				this.setPlanFinishDate( (Date)r.getValue(AssetHandleVOMeta.PLAN_FINISH_DATE));
				this.setStatus( (String)r.getValue(AssetHandleVOMeta.STATUS));
				this.setFileId( (String)r.getValue(AssetHandleVOMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}