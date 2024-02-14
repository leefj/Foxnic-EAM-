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
import com.dt.platform.domain.hr.meta.ScoreTaskDtlVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 任务单明细VO类型
 * <p>任务单明细 , 数据表 hr_score_task_dtl 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-12 00:04:02
 * @sign AD1FDBFEFD79EF5F7BB9EC4D6E884BE7
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "任务单明细VO类型 ; 任务单明细 , 数据表 hr_score_task_dtl 的通用VO类型" , parent = ScoreTaskDtl.class)
public class ScoreTaskDtlVO extends ScoreTaskDtl {

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
	public ScoreTaskDtlVO setPageIndex(Integer pageIndex) {
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
	public ScoreTaskDtlVO setPageSize(Integer pageSize) {
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
	public ScoreTaskDtlVO setSearchField(String searchField) {
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
	public ScoreTaskDtlVO setFuzzyField(String fuzzyField) {
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
	public ScoreTaskDtlVO setSearchValue(String searchValue) {
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
	public ScoreTaskDtlVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public ScoreTaskDtlVO addDirtyField(String... dirtyField) {
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
	public ScoreTaskDtlVO setSortField(String sortField) {
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
	public ScoreTaskDtlVO setSortType(String sortType) {
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
	public ScoreTaskDtlVO setDataOrigin(String dataOrigin) {
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
	public ScoreTaskDtlVO setQueryLogic(String queryLogic) {
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
	public ScoreTaskDtlVO setRequestAction(String requestAction) {
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
	public ScoreTaskDtlVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public ScoreTaskDtlVO addId(String... id) {
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
	 * @return ScoreTaskDtlVO , 转换好的 ScoreTaskDtlVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ScoreTaskDtlVO , 转换好的 PoJo 对象
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
	public ScoreTaskDtlVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ScoreTaskDtlVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.ScoreTaskDtlVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.ScoreTaskDtlVOMeta.$$proxy$$();
		inst.setRatedId(this.getRatedId());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setTotalScore(this.getTotalScore());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setRaterId(this.getRaterId());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTplId(this.getTplId());
		inst.setTaskId(this.getTaskId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setPageSize(this.getPageSize());
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
	public ScoreTaskDtlVO clone(boolean deep) {
		return EntityContext.clone(ScoreTaskDtlVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ScoreTaskDtlVO
	 * @param scoreTaskDtlMap 包含实体信息的 Map 对象
	 * @return ScoreTaskDtlVO , 转换好的的 ScoreTaskDtl 对象
	*/
	@Transient
	public static ScoreTaskDtlVO createFrom(Map<String,Object> scoreTaskDtlMap) {
		if(scoreTaskDtlMap==null) return null;
		ScoreTaskDtlVO vo = create();
		EntityContext.copyProperties(vo,scoreTaskDtlMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 ScoreTaskDtlVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ScoreTaskDtlVO , 转换好的的 ScoreTaskDtl 对象
	*/
	@Transient
	public static ScoreTaskDtlVO createFrom(Object pojo) {
		if(pojo==null) return null;
		ScoreTaskDtlVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 ScoreTaskDtlVO，等同于 new
	 * @return ScoreTaskDtlVO 对象
	*/
	@Transient
	public static ScoreTaskDtlVO create() {
		return new com.dt.platform.domain.hr.meta.ScoreTaskDtlVOMeta.$$proxy$$();
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
			this.setRatedId(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.RATED_ID)));
			this.setNotes(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ScoreTaskDtlVOMeta.UPDATE_TIME)));
			this.setTotalScore(DataParser.parse(BigDecimal.class, map.get(ScoreTaskDtlVOMeta.TOTAL_SCORE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ScoreTaskDtlVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.CREATE_BY)));
			this.setRaterId(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.RATER_ID)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ScoreTaskDtlVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ScoreTaskDtlVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ScoreTaskDtlVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.ID)));
			this.setTplId(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.TPL_ID)));
			this.setTaskId(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.TASK_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(ScoreTaskDtlVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.SORT_TYPE)));
			this.setRequestAction(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(ScoreTaskDtlVOMeta.PAGE_SIZE)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(ScoreTaskDtlVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setRatedId( (String)map.get(ScoreTaskDtlVOMeta.RATED_ID));
				this.setNotes( (String)map.get(ScoreTaskDtlVOMeta.NOTES));
				this.setUpdateTime( (Date)map.get(ScoreTaskDtlVOMeta.UPDATE_TIME));
				this.setTotalScore( (BigDecimal)map.get(ScoreTaskDtlVOMeta.TOTAL_SCORE));
				this.setVersion( (Integer)map.get(ScoreTaskDtlVOMeta.VERSION));
				this.setCreateBy( (String)map.get(ScoreTaskDtlVOMeta.CREATE_BY));
				this.setRaterId( (String)map.get(ScoreTaskDtlVOMeta.RATER_ID));
				this.setDeleted( (Integer)map.get(ScoreTaskDtlVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(ScoreTaskDtlVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ScoreTaskDtlVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ScoreTaskDtlVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(ScoreTaskDtlVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ScoreTaskDtlVOMeta.DELETE_BY));
				this.setId( (String)map.get(ScoreTaskDtlVOMeta.ID));
				this.setTplId( (String)map.get(ScoreTaskDtlVOMeta.TPL_ID));
				this.setTaskId( (String)map.get(ScoreTaskDtlVOMeta.TASK_ID));
				this.setStatus( (String)map.get(ScoreTaskDtlVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(ScoreTaskDtlVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(ScoreTaskDtlVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(ScoreTaskDtlVOMeta.SORT_TYPE));
				this.setRequestAction( (String)map.get(ScoreTaskDtlVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(ScoreTaskDtlVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(ScoreTaskDtlVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(ScoreTaskDtlVOMeta.PAGE_SIZE));
				this.setDataOrigin( (String)map.get(ScoreTaskDtlVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(ScoreTaskDtlVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(ScoreTaskDtlVOMeta.SEARCH_VALUE));
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
			this.setRatedId(DataParser.parse(String.class, r.getValue(ScoreTaskDtlVOMeta.RATED_ID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(ScoreTaskDtlVOMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ScoreTaskDtlVOMeta.UPDATE_TIME)));
			this.setTotalScore(DataParser.parse(BigDecimal.class, r.getValue(ScoreTaskDtlVOMeta.TOTAL_SCORE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ScoreTaskDtlVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ScoreTaskDtlVOMeta.CREATE_BY)));
			this.setRaterId(DataParser.parse(String.class, r.getValue(ScoreTaskDtlVOMeta.RATER_ID)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ScoreTaskDtlVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ScoreTaskDtlVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ScoreTaskDtlVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ScoreTaskDtlVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ScoreTaskDtlVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ScoreTaskDtlVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ScoreTaskDtlVOMeta.ID)));
			this.setTplId(DataParser.parse(String.class, r.getValue(ScoreTaskDtlVOMeta.TPL_ID)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(ScoreTaskDtlVOMeta.TASK_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(ScoreTaskDtlVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setRatedId( (String)r.getValue(ScoreTaskDtlVOMeta.RATED_ID));
				this.setNotes( (String)r.getValue(ScoreTaskDtlVOMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(ScoreTaskDtlVOMeta.UPDATE_TIME));
				this.setTotalScore( (BigDecimal)r.getValue(ScoreTaskDtlVOMeta.TOTAL_SCORE));
				this.setVersion( (Integer)r.getValue(ScoreTaskDtlVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(ScoreTaskDtlVOMeta.CREATE_BY));
				this.setRaterId( (String)r.getValue(ScoreTaskDtlVOMeta.RATER_ID));
				this.setDeleted( (Integer)r.getValue(ScoreTaskDtlVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ScoreTaskDtlVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ScoreTaskDtlVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ScoreTaskDtlVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(ScoreTaskDtlVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ScoreTaskDtlVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(ScoreTaskDtlVOMeta.ID));
				this.setTplId( (String)r.getValue(ScoreTaskDtlVOMeta.TPL_ID));
				this.setTaskId( (String)r.getValue(ScoreTaskDtlVOMeta.TASK_ID));
				this.setStatus( (String)r.getValue(ScoreTaskDtlVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}