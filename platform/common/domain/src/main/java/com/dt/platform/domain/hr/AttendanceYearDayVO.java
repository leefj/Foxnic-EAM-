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
import com.dt.platform.domain.hr.meta.AttendanceYearDayVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.hrm.Person;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 年假记录VO类型
 * <p>年假记录 , 数据表 hr_attendance_year_day 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 23:07:05
 * @sign 1F68D52296C6500FA15BC80E09D7954A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "年假记录VO类型 ; 年假记录 , 数据表 hr_attendance_year_day 的通用VO类型" , parent = AttendanceYearDay.class)
public class AttendanceYearDayVO extends AttendanceYearDay {

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
	public AttendanceYearDayVO setPageIndex(Integer pageIndex) {
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
	public AttendanceYearDayVO setPageSize(Integer pageSize) {
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
	public AttendanceYearDayVO setSearchField(String searchField) {
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
	public AttendanceYearDayVO setFuzzyField(String fuzzyField) {
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
	public AttendanceYearDayVO setSearchValue(String searchValue) {
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
	public AttendanceYearDayVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AttendanceYearDayVO addDirtyField(String... dirtyField) {
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
	public AttendanceYearDayVO setSortField(String sortField) {
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
	public AttendanceYearDayVO setSortType(String sortType) {
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
	public AttendanceYearDayVO setDataOrigin(String dataOrigin) {
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
	public AttendanceYearDayVO setQueryLogic(String queryLogic) {
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
	public AttendanceYearDayVO setRequestAction(String requestAction) {
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
	public AttendanceYearDayVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AttendanceYearDayVO addId(String... id) {
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
	 * @return AttendanceYearDayVO , 转换好的 AttendanceYearDayVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AttendanceYearDayVO , 转换好的 PoJo 对象
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
	public AttendanceYearDayVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AttendanceYearDayVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AttendanceYearDayVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AttendanceYearDayVOMeta.$$proxy$$();
		inst.setSdate(this.getSdate());
		inst.setNotes(this.getNotes());
		inst.setBatchCode(this.getBatchCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setEdate(this.getEdate());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setLastDays(this.getLastDays());
		inst.setTenantId(this.getTenantId());
		inst.setDays(this.getDays());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setId(this.getId());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setPerson(this.getPerson());
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
	public AttendanceYearDayVO clone(boolean deep) {
		return EntityContext.clone(AttendanceYearDayVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AttendanceYearDayVO
	 * @param attendanceYearDayMap 包含实体信息的 Map 对象
	 * @return AttendanceYearDayVO , 转换好的的 AttendanceYearDay 对象
	*/
	@Transient
	public static AttendanceYearDayVO createFrom(Map<String,Object> attendanceYearDayMap) {
		if(attendanceYearDayMap==null) return null;
		AttendanceYearDayVO vo = create();
		EntityContext.copyProperties(vo,attendanceYearDayMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AttendanceYearDayVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AttendanceYearDayVO , 转换好的的 AttendanceYearDay 对象
	*/
	@Transient
	public static AttendanceYearDayVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AttendanceYearDayVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AttendanceYearDayVO，等同于 new
	 * @return AttendanceYearDayVO 对象
	*/
	@Transient
	public static AttendanceYearDayVO create() {
		return new com.dt.platform.domain.hr.meta.AttendanceYearDayVOMeta.$$proxy$$();
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
			this.setSdate(DataParser.parse(Date.class, map.get(AttendanceYearDayVOMeta.SDATE)));
			this.setNotes(DataParser.parse(String.class, map.get(AttendanceYearDayVOMeta.NOTES)));
			this.setBatchCode(DataParser.parse(String.class, map.get(AttendanceYearDayVOMeta.BATCH_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AttendanceYearDayVOMeta.UPDATE_TIME)));
			this.setEdate(DataParser.parse(String.class, map.get(AttendanceYearDayVOMeta.EDATE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AttendanceYearDayVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AttendanceYearDayVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AttendanceYearDayVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AttendanceYearDayVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AttendanceYearDayVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AttendanceYearDayVOMeta.DELETE_TIME)));
			this.setLastDays(DataParser.parse(BigDecimal.class, map.get(AttendanceYearDayVOMeta.LAST_DAYS)));
			this.setTenantId(DataParser.parse(String.class, map.get(AttendanceYearDayVOMeta.TENANT_ID)));
			this.setDays(DataParser.parse(BigDecimal.class, map.get(AttendanceYearDayVOMeta.DAYS)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AttendanceYearDayVOMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(AttendanceYearDayVOMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(AttendanceYearDayVOMeta.ID)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AttendanceYearDayVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AttendanceYearDayVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AttendanceYearDayVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AttendanceYearDayVOMeta.PAGE_SIZE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AttendanceYearDayVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AttendanceYearDayVOMeta.SORT_TYPE)));
			this.setPerson(DataParser.parse(Person.class, map.get(AttendanceYearDayVOMeta.PERSON)));
			this.setSortField(DataParser.parse(String.class, map.get(AttendanceYearDayVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AttendanceYearDayVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AttendanceYearDayVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AttendanceYearDayVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setSdate( (Date)map.get(AttendanceYearDayVOMeta.SDATE));
				this.setNotes( (String)map.get(AttendanceYearDayVOMeta.NOTES));
				this.setBatchCode( (String)map.get(AttendanceYearDayVOMeta.BATCH_CODE));
				this.setUpdateTime( (Date)map.get(AttendanceYearDayVOMeta.UPDATE_TIME));
				this.setEdate( (String)map.get(AttendanceYearDayVOMeta.EDATE));
				this.setVersion( (Integer)map.get(AttendanceYearDayVOMeta.VERSION));
				this.setCreateBy( (String)map.get(AttendanceYearDayVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AttendanceYearDayVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AttendanceYearDayVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AttendanceYearDayVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AttendanceYearDayVOMeta.DELETE_TIME));
				this.setLastDays( (BigDecimal)map.get(AttendanceYearDayVOMeta.LAST_DAYS));
				this.setTenantId( (String)map.get(AttendanceYearDayVOMeta.TENANT_ID));
				this.setDays( (BigDecimal)map.get(AttendanceYearDayVOMeta.DAYS));
				this.setDeleteBy( (String)map.get(AttendanceYearDayVOMeta.DELETE_BY));
				this.setPersonId( (String)map.get(AttendanceYearDayVOMeta.PERSON_ID));
				this.setId( (String)map.get(AttendanceYearDayVOMeta.ID));
				// others
				this.setSearchField( (String)map.get(AttendanceYearDayVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(AttendanceYearDayVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(AttendanceYearDayVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AttendanceYearDayVOMeta.PAGE_SIZE));
				this.setPageIndex( (Integer)map.get(AttendanceYearDayVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AttendanceYearDayVOMeta.SORT_TYPE));
				this.setPerson( (Person)map.get(AttendanceYearDayVOMeta.PERSON));
				this.setSortField( (String)map.get(AttendanceYearDayVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(AttendanceYearDayVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(AttendanceYearDayVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(AttendanceYearDayVOMeta.SEARCH_VALUE));
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
			this.setSdate(DataParser.parse(Date.class, r.getValue(AttendanceYearDayVOMeta.SDATE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AttendanceYearDayVOMeta.NOTES)));
			this.setBatchCode(DataParser.parse(String.class, r.getValue(AttendanceYearDayVOMeta.BATCH_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AttendanceYearDayVOMeta.UPDATE_TIME)));
			this.setEdate(DataParser.parse(String.class, r.getValue(AttendanceYearDayVOMeta.EDATE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AttendanceYearDayVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AttendanceYearDayVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AttendanceYearDayVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AttendanceYearDayVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AttendanceYearDayVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AttendanceYearDayVOMeta.DELETE_TIME)));
			this.setLastDays(DataParser.parse(BigDecimal.class, r.getValue(AttendanceYearDayVOMeta.LAST_DAYS)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AttendanceYearDayVOMeta.TENANT_ID)));
			this.setDays(DataParser.parse(BigDecimal.class, r.getValue(AttendanceYearDayVOMeta.DAYS)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AttendanceYearDayVOMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(AttendanceYearDayVOMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(AttendanceYearDayVOMeta.ID)));
			return true;
		} else {
			try {
				this.setSdate( (Date)r.getValue(AttendanceYearDayVOMeta.SDATE));
				this.setNotes( (String)r.getValue(AttendanceYearDayVOMeta.NOTES));
				this.setBatchCode( (String)r.getValue(AttendanceYearDayVOMeta.BATCH_CODE));
				this.setUpdateTime( (Date)r.getValue(AttendanceYearDayVOMeta.UPDATE_TIME));
				this.setEdate( (String)r.getValue(AttendanceYearDayVOMeta.EDATE));
				this.setVersion( (Integer)r.getValue(AttendanceYearDayVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AttendanceYearDayVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AttendanceYearDayVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AttendanceYearDayVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AttendanceYearDayVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AttendanceYearDayVOMeta.DELETE_TIME));
				this.setLastDays( (BigDecimal)r.getValue(AttendanceYearDayVOMeta.LAST_DAYS));
				this.setTenantId( (String)r.getValue(AttendanceYearDayVOMeta.TENANT_ID));
				this.setDays( (BigDecimal)r.getValue(AttendanceYearDayVOMeta.DAYS));
				this.setDeleteBy( (String)r.getValue(AttendanceYearDayVOMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(AttendanceYearDayVOMeta.PERSON_ID));
				this.setId( (String)r.getValue(AttendanceYearDayVOMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}