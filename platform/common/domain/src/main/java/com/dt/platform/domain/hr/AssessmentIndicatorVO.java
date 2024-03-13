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
import com.dt.platform.domain.hr.meta.AssessmentIndicatorVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.math.BigDecimal;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考核指标VO类型
 * <p>考核指标 , 数据表 hr_assessment_indicator 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-13 20:35:52
 * @sign 93A6886A9E8CEF3CD1F4844E3086978F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "考核指标VO类型 ; 考核指标 , 数据表 hr_assessment_indicator 的通用VO类型" , parent = AssessmentIndicator.class)
public class AssessmentIndicatorVO extends AssessmentIndicator {

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
	public AssessmentIndicatorVO setPageIndex(Integer pageIndex) {
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
	public AssessmentIndicatorVO setPageSize(Integer pageSize) {
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
	public AssessmentIndicatorVO setSearchField(String searchField) {
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
	public AssessmentIndicatorVO setFuzzyField(String fuzzyField) {
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
	public AssessmentIndicatorVO setSearchValue(String searchValue) {
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
	public AssessmentIndicatorVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssessmentIndicatorVO addDirtyField(String... dirtyField) {
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
	public AssessmentIndicatorVO setSortField(String sortField) {
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
	public AssessmentIndicatorVO setSortType(String sortType) {
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
	public AssessmentIndicatorVO setDataOrigin(String dataOrigin) {
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
	public AssessmentIndicatorVO setQueryLogic(String queryLogic) {
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
	public AssessmentIndicatorVO setRequestAction(String requestAction) {
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
	public AssessmentIndicatorVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssessmentIndicatorVO addId(String... id) {
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
	 * @return AssessmentIndicatorVO , 转换好的 AssessmentIndicatorVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssessmentIndicatorVO , 转换好的 PoJo 对象
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
	public AssessmentIndicatorVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssessmentIndicatorVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AssessmentIndicatorVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AssessmentIndicatorVOMeta.$$proxy$$();
		inst.setScoringBase(this.getScoringBase());
		inst.setDef(this.getDef());
		inst.setDefaultValue(this.getDefaultValue());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setProperty(this.getProperty());
		inst.setId(this.getId());
		inst.setSn(this.getSn());
		inst.setAssessmentId(this.getAssessmentId());
		inst.setOwner(this.getOwner());
		inst.setWeight(this.getWeight());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setGroupname(this.getGroupname());
		inst.setVersion(this.getVersion());
		inst.setScoringBy(this.getScoringBy());
		inst.setUnit(this.getUnit());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTargetMinValue(this.getTargetMinValue());
		inst.setName(this.getName());
		inst.setTargetMaxValue(this.getTargetMaxValue());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setTplIndicatorId(this.getTplIndicatorId());
		if(all) {
			inst.setIndicatorLib(this.getIndicatorLib());
			inst.setSelfAssessmentValue(this.getSelfAssessmentValue());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setLeaderAssessmentValue(this.getLeaderAssessmentValue());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSearchValue(this.getSearchValue());
			inst.setSameAssessmentValue(this.getSameAssessmentValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssessmentIndicatorVO clone(boolean deep) {
		return EntityContext.clone(AssessmentIndicatorVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssessmentIndicatorVO
	 * @param assessmentIndicatorMap 包含实体信息的 Map 对象
	 * @return AssessmentIndicatorVO , 转换好的的 AssessmentIndicator 对象
	*/
	@Transient
	public static AssessmentIndicatorVO createFrom(Map<String,Object> assessmentIndicatorMap) {
		if(assessmentIndicatorMap==null) return null;
		AssessmentIndicatorVO vo = create();
		EntityContext.copyProperties(vo,assessmentIndicatorMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssessmentIndicatorVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssessmentIndicatorVO , 转换好的的 AssessmentIndicator 对象
	*/
	@Transient
	public static AssessmentIndicatorVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssessmentIndicatorVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssessmentIndicatorVO，等同于 new
	 * @return AssessmentIndicatorVO 对象
	*/
	@Transient
	public static AssessmentIndicatorVO create() {
		return new com.dt.platform.domain.hr.meta.AssessmentIndicatorVOMeta.$$proxy$$();
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
			this.setScoringBase(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.SCORING_BASE)));
			this.setDef(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.DEF)));
			this.setDefaultValue(DataParser.parse(BigDecimal.class, map.get(AssessmentIndicatorVOMeta.DEFAULT_VALUE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.UPDATE_BY)));
			this.setProperty(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.PROPERTY)));
			this.setId(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.ID)));
			this.setSn(DataParser.parse(Integer.class, map.get(AssessmentIndicatorVOMeta.SN)));
			this.setAssessmentId(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.ASSESSMENT_ID)));
			this.setOwner(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.OWNER)));
			this.setWeight(DataParser.parse(BigDecimal.class, map.get(AssessmentIndicatorVOMeta.WEIGHT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentIndicatorVOMeta.UPDATE_TIME)));
			this.setGroupname(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.GROUPNAME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssessmentIndicatorVOMeta.VERSION)));
			this.setScoringBy(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.SCORING_BY)));
			this.setUnit(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.UNIT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssessmentIndicatorVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssessmentIndicatorVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssessmentIndicatorVOMeta.DELETE_TIME)));
			this.setTargetMinValue(DataParser.parse(BigDecimal.class, map.get(AssessmentIndicatorVOMeta.TARGET_MIN_VALUE)));
			this.setName(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.NAME)));
			this.setTargetMaxValue(DataParser.parse(BigDecimal.class, map.get(AssessmentIndicatorVOMeta.TARGET_MAX_VALUE)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.DELETE_BY)));
			this.setTplIndicatorId(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.TPL_INDICATOR_ID)));
			// others
			this.setSelfAssessmentValue(DataParser.parse(AssessmentIndicatorValue.class, map.get(AssessmentIndicatorVOMeta.SELF_ASSESSMENT_VALUE)));
			this.setSearchField(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssessmentIndicatorVOMeta.PAGE_SIZE)));
			this.setLeaderAssessmentValue(DataParser.parse(AssessmentIndicatorValue.class, map.get(AssessmentIndicatorVOMeta.LEADER_ASSESSMENT_VALUE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssessmentIndicatorVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssessmentIndicatorVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setScoringBase( (String)map.get(AssessmentIndicatorVOMeta.SCORING_BASE));
				this.setDef( (String)map.get(AssessmentIndicatorVOMeta.DEF));
				this.setDefaultValue( (BigDecimal)map.get(AssessmentIndicatorVOMeta.DEFAULT_VALUE));
				this.setUpdateBy( (String)map.get(AssessmentIndicatorVOMeta.UPDATE_BY));
				this.setProperty( (String)map.get(AssessmentIndicatorVOMeta.PROPERTY));
				this.setId( (String)map.get(AssessmentIndicatorVOMeta.ID));
				this.setSn( (Integer)map.get(AssessmentIndicatorVOMeta.SN));
				this.setAssessmentId( (String)map.get(AssessmentIndicatorVOMeta.ASSESSMENT_ID));
				this.setOwner( (String)map.get(AssessmentIndicatorVOMeta.OWNER));
				this.setWeight( (BigDecimal)map.get(AssessmentIndicatorVOMeta.WEIGHT));
				this.setUpdateTime( (Date)map.get(AssessmentIndicatorVOMeta.UPDATE_TIME));
				this.setGroupname( (String)map.get(AssessmentIndicatorVOMeta.GROUPNAME));
				this.setVersion( (Integer)map.get(AssessmentIndicatorVOMeta.VERSION));
				this.setScoringBy( (String)map.get(AssessmentIndicatorVOMeta.SCORING_BY));
				this.setUnit( (String)map.get(AssessmentIndicatorVOMeta.UNIT));
				this.setCreateBy( (String)map.get(AssessmentIndicatorVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssessmentIndicatorVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssessmentIndicatorVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssessmentIndicatorVOMeta.DELETE_TIME));
				this.setTargetMinValue( (BigDecimal)map.get(AssessmentIndicatorVOMeta.TARGET_MIN_VALUE));
				this.setName( (String)map.get(AssessmentIndicatorVOMeta.NAME));
				this.setTargetMaxValue( (BigDecimal)map.get(AssessmentIndicatorVOMeta.TARGET_MAX_VALUE));
				this.setTenantId( (String)map.get(AssessmentIndicatorVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssessmentIndicatorVOMeta.DELETE_BY));
				this.setTplIndicatorId( (String)map.get(AssessmentIndicatorVOMeta.TPL_INDICATOR_ID));
				// others
				this.setSelfAssessmentValue( (AssessmentIndicatorValue)map.get(AssessmentIndicatorVOMeta.SELF_ASSESSMENT_VALUE));
				this.setSearchField( (String)map.get(AssessmentIndicatorVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(AssessmentIndicatorVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(AssessmentIndicatorVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssessmentIndicatorVOMeta.PAGE_SIZE));
				this.setLeaderAssessmentValue( (AssessmentIndicatorValue)map.get(AssessmentIndicatorVOMeta.LEADER_ASSESSMENT_VALUE));
				this.setPageIndex( (Integer)map.get(AssessmentIndicatorVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssessmentIndicatorVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(AssessmentIndicatorVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(AssessmentIndicatorVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(AssessmentIndicatorVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(AssessmentIndicatorVOMeta.SEARCH_VALUE));
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
			this.setScoringBase(DataParser.parse(String.class, r.getValue(AssessmentIndicatorVOMeta.SCORING_BASE)));
			this.setDef(DataParser.parse(String.class, r.getValue(AssessmentIndicatorVOMeta.DEF)));
			this.setDefaultValue(DataParser.parse(BigDecimal.class, r.getValue(AssessmentIndicatorVOMeta.DEFAULT_VALUE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssessmentIndicatorVOMeta.UPDATE_BY)));
			this.setProperty(DataParser.parse(String.class, r.getValue(AssessmentIndicatorVOMeta.PROPERTY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssessmentIndicatorVOMeta.ID)));
			this.setSn(DataParser.parse(Integer.class, r.getValue(AssessmentIndicatorVOMeta.SN)));
			this.setAssessmentId(DataParser.parse(String.class, r.getValue(AssessmentIndicatorVOMeta.ASSESSMENT_ID)));
			this.setOwner(DataParser.parse(String.class, r.getValue(AssessmentIndicatorVOMeta.OWNER)));
			this.setWeight(DataParser.parse(BigDecimal.class, r.getValue(AssessmentIndicatorVOMeta.WEIGHT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentIndicatorVOMeta.UPDATE_TIME)));
			this.setGroupname(DataParser.parse(String.class, r.getValue(AssessmentIndicatorVOMeta.GROUPNAME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssessmentIndicatorVOMeta.VERSION)));
			this.setScoringBy(DataParser.parse(String.class, r.getValue(AssessmentIndicatorVOMeta.SCORING_BY)));
			this.setUnit(DataParser.parse(String.class, r.getValue(AssessmentIndicatorVOMeta.UNIT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssessmentIndicatorVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssessmentIndicatorVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssessmentIndicatorVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssessmentIndicatorVOMeta.DELETE_TIME)));
			this.setTargetMinValue(DataParser.parse(BigDecimal.class, r.getValue(AssessmentIndicatorVOMeta.TARGET_MIN_VALUE)));
			this.setName(DataParser.parse(String.class, r.getValue(AssessmentIndicatorVOMeta.NAME)));
			this.setTargetMaxValue(DataParser.parse(BigDecimal.class, r.getValue(AssessmentIndicatorVOMeta.TARGET_MAX_VALUE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssessmentIndicatorVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssessmentIndicatorVOMeta.DELETE_BY)));
			this.setTplIndicatorId(DataParser.parse(String.class, r.getValue(AssessmentIndicatorVOMeta.TPL_INDICATOR_ID)));
			return true;
		} else {
			try {
				this.setScoringBase( (String)r.getValue(AssessmentIndicatorVOMeta.SCORING_BASE));
				this.setDef( (String)r.getValue(AssessmentIndicatorVOMeta.DEF));
				this.setDefaultValue( (BigDecimal)r.getValue(AssessmentIndicatorVOMeta.DEFAULT_VALUE));
				this.setUpdateBy( (String)r.getValue(AssessmentIndicatorVOMeta.UPDATE_BY));
				this.setProperty( (String)r.getValue(AssessmentIndicatorVOMeta.PROPERTY));
				this.setId( (String)r.getValue(AssessmentIndicatorVOMeta.ID));
				this.setSn( (Integer)r.getValue(AssessmentIndicatorVOMeta.SN));
				this.setAssessmentId( (String)r.getValue(AssessmentIndicatorVOMeta.ASSESSMENT_ID));
				this.setOwner( (String)r.getValue(AssessmentIndicatorVOMeta.OWNER));
				this.setWeight( (BigDecimal)r.getValue(AssessmentIndicatorVOMeta.WEIGHT));
				this.setUpdateTime( (Date)r.getValue(AssessmentIndicatorVOMeta.UPDATE_TIME));
				this.setGroupname( (String)r.getValue(AssessmentIndicatorVOMeta.GROUPNAME));
				this.setVersion( (Integer)r.getValue(AssessmentIndicatorVOMeta.VERSION));
				this.setScoringBy( (String)r.getValue(AssessmentIndicatorVOMeta.SCORING_BY));
				this.setUnit( (String)r.getValue(AssessmentIndicatorVOMeta.UNIT));
				this.setCreateBy( (String)r.getValue(AssessmentIndicatorVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssessmentIndicatorVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssessmentIndicatorVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssessmentIndicatorVOMeta.DELETE_TIME));
				this.setTargetMinValue( (BigDecimal)r.getValue(AssessmentIndicatorVOMeta.TARGET_MIN_VALUE));
				this.setName( (String)r.getValue(AssessmentIndicatorVOMeta.NAME));
				this.setTargetMaxValue( (BigDecimal)r.getValue(AssessmentIndicatorVOMeta.TARGET_MAX_VALUE));
				this.setTenantId( (String)r.getValue(AssessmentIndicatorVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssessmentIndicatorVOMeta.DELETE_BY));
				this.setTplIndicatorId( (String)r.getValue(AssessmentIndicatorVOMeta.TPL_INDICATOR_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}