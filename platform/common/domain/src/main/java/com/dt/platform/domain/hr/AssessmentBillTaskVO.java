package com.dt.platform.domain.hr;

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
import com.dt.platform.domain.hr.meta.AssessmentBillTaskVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 单据任务VO类型
 * <p>单据任务 , 数据表 hr_assessment_bill_task 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-12 13:15:01
 * @sign 50FEA3A81C1639C49BFB04C21599F5B1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "单据任务VO类型 ; 单据任务 , 数据表 hr_assessment_bill_task 的通用VO类型" , parent = AssessmentBillTask.class)
public class AssessmentBillTaskVO extends AssessmentBillTask {

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
	public AssessmentBillTaskVO setPageIndex(Integer pageIndex) {
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
	public AssessmentBillTaskVO setPageSize(Integer pageSize) {
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
	public AssessmentBillTaskVO setSearchField(String searchField) {
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
	public AssessmentBillTaskVO setFuzzyField(String fuzzyField) {
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
	public AssessmentBillTaskVO setSearchValue(String searchValue) {
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
	public AssessmentBillTaskVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssessmentBillTaskVO addDirtyField(String... dirtyField) {
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
	public AssessmentBillTaskVO setSortField(String sortField) {
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
	public AssessmentBillTaskVO setSortType(String sortType) {
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
	public AssessmentBillTaskVO setDataOrigin(String dataOrigin) {
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
	public AssessmentBillTaskVO setQueryLogic(String queryLogic) {
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
	public AssessmentBillTaskVO setRequestAction(String requestAction) {
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
	public AssessmentBillTaskVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssessmentBillTaskVO addId(String... id) {
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
	 * @return AssessmentBillTaskVO , 转换好的 AssessmentBillTaskVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssessmentBillTaskVO , 转换好的 PoJo 对象
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
	public AssessmentBillTaskVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssessmentBillTaskVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AssessmentBillTaskVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AssessmentBillTaskVOMeta.$$proxy$$();
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssessorId(this.getAssessorId());
		inst.setBillId(this.getBillId());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setRcdTime(this.getRcdTime());
		if(all) {
			inst.setNameStr(this.getNameStr());
			inst.setSearchField(this.getSearchField());
			inst.setAssessor(this.getAssessor());
			inst.setStimeStr(this.getStimeStr());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setEtimeStr(this.getEtimeStr());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setAssessmentBillTaskDtlList(this.getAssessmentBillTaskDtlList());
			inst.setRequestAction(this.getRequestAction());
			inst.setWithSecondLeaderList(this.getWithSecondLeaderList());
			inst.setSOrgId(this.getSOrgId());
			inst.setAssessmentDataTask(this.getAssessmentDataTask());
			inst.setSRole(this.getSRole());
			inst.setWithSameUserList(this.getWithSameUserList());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setIds(this.getIds());
			inst.setAssessmentTask(this.getAssessmentTask());
			inst.setAssessmentBill(this.getAssessmentBill());
			inst.setWithLeaderList(this.getWithLeaderList());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssessmentBillTaskVO clone(boolean deep) {
		return EntityContext.clone(AssessmentBillTaskVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssessmentBillTaskVO
	 * @param assessmentBillTaskMap 包含实体信息的 Map 对象
	 * @return AssessmentBillTaskVO , 转换好的的 AssessmentBillTask 对象
	*/
	@Transient
	public static AssessmentBillTaskVO createFrom(Map<String,Object> assessmentBillTaskMap) {
		if(assessmentBillTaskMap==null) return null;
		AssessmentBillTaskVO vo = create();
		EntityContext.copyProperties(vo,assessmentBillTaskMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssessmentBillTaskVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssessmentBillTaskVO , 转换好的的 AssessmentBillTask 对象
	*/
	@Transient
	public static AssessmentBillTaskVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssessmentBillTaskVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssessmentBillTaskVO，等同于 new
	 * @return AssessmentBillTaskVO 对象
	*/
	@Transient
	public static AssessmentBillTaskVO create() {
		return new com.dt.platform.domain.hr.meta.AssessmentBillTaskVOMeta.$$proxy$$();
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
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentBillTaskVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssessmentBillTaskVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssessmentBillTaskVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssessmentBillTaskVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssessmentBillTaskVOMeta.DELETE_TIME)));
			this.setAssessorId(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.ASSESSOR_ID)));
			this.setBillId(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.BILL_ID)));
			this.setName(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.ID)));
			this.setRcdTime(DataParser.parse(Date.class, map.get(AssessmentBillTaskVOMeta.RCD_TIME)));
			// others
			this.setNameStr(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.NAME_STR)));
			this.setSearchField(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.SEARCH_FIELD)));
			this.setAssessor(DataParser.parse(Employee.class, map.get(AssessmentBillTaskVOMeta.ASSESSOR)));
			this.setStimeStr(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.STIME_STR)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssessmentBillTaskVOMeta.PAGE_SIZE)));
			this.setSortField(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.DATA_ORIGIN)));
			this.setEtimeStr(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.ETIME_STR)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.QUERY_LOGIC)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.REQUEST_ACTION)));
			this.setSOrgId(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.S_ORG_ID)));
			this.setAssessmentDataTask(DataParser.parse(AssessmentTask.class, map.get(AssessmentBillTaskVOMeta.ASSESSMENT_DATA_TASK)));
			this.setSRole(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.S_ROLE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssessmentBillTaskVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.SORT_TYPE)));
			this.setAssessmentTask(DataParser.parse(AssessmentTask.class, map.get(AssessmentBillTaskVOMeta.ASSESSMENT_TASK)));
			this.setAssessmentBill(DataParser.parse(AssessmentBill.class, map.get(AssessmentBillTaskVOMeta.ASSESSMENT_BILL)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssessmentBillTaskVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)map.get(AssessmentBillTaskVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssessmentBillTaskVOMeta.VERSION));
				this.setCreateBy( (String)map.get(AssessmentBillTaskVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssessmentBillTaskVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssessmentBillTaskVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssessmentBillTaskVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssessmentBillTaskVOMeta.DELETE_TIME));
				this.setAssessorId( (String)map.get(AssessmentBillTaskVOMeta.ASSESSOR_ID));
				this.setBillId( (String)map.get(AssessmentBillTaskVOMeta.BILL_ID));
				this.setName( (String)map.get(AssessmentBillTaskVOMeta.NAME));
				this.setTenantId( (String)map.get(AssessmentBillTaskVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssessmentBillTaskVOMeta.DELETE_BY));
				this.setId( (String)map.get(AssessmentBillTaskVOMeta.ID));
				this.setRcdTime( (Date)map.get(AssessmentBillTaskVOMeta.RCD_TIME));
				// others
				this.setNameStr( (String)map.get(AssessmentBillTaskVOMeta.NAME_STR));
				this.setSearchField( (String)map.get(AssessmentBillTaskVOMeta.SEARCH_FIELD));
				this.setAssessor( (Employee)map.get(AssessmentBillTaskVOMeta.ASSESSOR));
				this.setStimeStr( (String)map.get(AssessmentBillTaskVOMeta.STIME_STR));
				this.setFuzzyField( (String)map.get(AssessmentBillTaskVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssessmentBillTaskVOMeta.PAGE_SIZE));
				this.setSortField( (String)map.get(AssessmentBillTaskVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(AssessmentBillTaskVOMeta.DATA_ORIGIN));
				this.setEtimeStr( (String)map.get(AssessmentBillTaskVOMeta.ETIME_STR));
				this.setQueryLogic( (String)map.get(AssessmentBillTaskVOMeta.QUERY_LOGIC));
				this.setRequestAction( (String)map.get(AssessmentBillTaskVOMeta.REQUEST_ACTION));
				this.setSOrgId( (String)map.get(AssessmentBillTaskVOMeta.S_ORG_ID));
				this.setAssessmentDataTask( (AssessmentTask)map.get(AssessmentBillTaskVOMeta.ASSESSMENT_DATA_TASK));
				this.setSRole( (String)map.get(AssessmentBillTaskVOMeta.S_ROLE));
				this.setPageIndex( (Integer)map.get(AssessmentBillTaskVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssessmentBillTaskVOMeta.SORT_TYPE));
				this.setAssessmentTask( (AssessmentTask)map.get(AssessmentBillTaskVOMeta.ASSESSMENT_TASK));
				this.setAssessmentBill( (AssessmentBill)map.get(AssessmentBillTaskVOMeta.ASSESSMENT_BILL));
				this.setSearchValue( (String)map.get(AssessmentBillTaskVOMeta.SEARCH_VALUE));
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
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentBillTaskVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssessmentBillTaskVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssessmentBillTaskVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssessmentBillTaskVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssessmentBillTaskVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssessmentBillTaskVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssessmentBillTaskVOMeta.DELETE_TIME)));
			this.setAssessorId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskVOMeta.ASSESSOR_ID)));
			this.setBillId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskVOMeta.BILL_ID)));
			this.setName(DataParser.parse(String.class, r.getValue(AssessmentBillTaskVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssessmentBillTaskVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskVOMeta.ID)));
			this.setRcdTime(DataParser.parse(Date.class, r.getValue(AssessmentBillTaskVOMeta.RCD_TIME)));
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)r.getValue(AssessmentBillTaskVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssessmentBillTaskVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AssessmentBillTaskVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssessmentBillTaskVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssessmentBillTaskVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssessmentBillTaskVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssessmentBillTaskVOMeta.DELETE_TIME));
				this.setAssessorId( (String)r.getValue(AssessmentBillTaskVOMeta.ASSESSOR_ID));
				this.setBillId( (String)r.getValue(AssessmentBillTaskVOMeta.BILL_ID));
				this.setName( (String)r.getValue(AssessmentBillTaskVOMeta.NAME));
				this.setTenantId( (String)r.getValue(AssessmentBillTaskVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssessmentBillTaskVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssessmentBillTaskVOMeta.ID));
				this.setRcdTime( (Date)r.getValue(AssessmentBillTaskVOMeta.RCD_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}