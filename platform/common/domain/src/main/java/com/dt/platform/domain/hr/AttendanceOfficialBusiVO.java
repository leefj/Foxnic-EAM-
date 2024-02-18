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
import com.dt.platform.domain.hr.meta.AttendanceOfficialBusiVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.system.DictItem;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 出差管理VO类型
 * <p>出差管理 , 数据表 hr_attendance_official_busi 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-16 20:52:52
 * @sign 17BFE193110714FC09695FEE8AD75544
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "出差管理VO类型 ; 出差管理 , 数据表 hr_attendance_official_busi 的通用VO类型" , parent = AttendanceOfficialBusi.class)
public class AttendanceOfficialBusiVO extends AttendanceOfficialBusi {

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
	public AttendanceOfficialBusiVO setPageIndex(Integer pageIndex) {
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
	public AttendanceOfficialBusiVO setPageSize(Integer pageSize) {
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
	public AttendanceOfficialBusiVO setSearchField(String searchField) {
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
	public AttendanceOfficialBusiVO setFuzzyField(String fuzzyField) {
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
	public AttendanceOfficialBusiVO setSearchValue(String searchValue) {
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
	public AttendanceOfficialBusiVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AttendanceOfficialBusiVO addDirtyField(String... dirtyField) {
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
	public AttendanceOfficialBusiVO setSortField(String sortField) {
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
	public AttendanceOfficialBusiVO setSortType(String sortType) {
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
	public AttendanceOfficialBusiVO setDataOrigin(String dataOrigin) {
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
	public AttendanceOfficialBusiVO setQueryLogic(String queryLogic) {
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
	public AttendanceOfficialBusiVO setRequestAction(String requestAction) {
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
	public AttendanceOfficialBusiVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AttendanceOfficialBusiVO addId(String... id) {
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
	 * @return AttendanceOfficialBusiVO , 转换好的 AttendanceOfficialBusiVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AttendanceOfficialBusiVO , 转换好的 PoJo 对象
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
	public AttendanceOfficialBusiVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AttendanceOfficialBusiVO duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AttendanceOfficialBusiVOMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AttendanceOfficialBusiVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setActionSTime(this.getActionSTime());
		inst.setBatchCode(this.getBatchCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setActionType(this.getActionType());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setActionDays(this.getActionDays());
		inst.setActionETime(this.getActionETime());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setId(this.getId());
		inst.setActionDate(this.getActionDate());
		inst.setFileId(this.getFileId());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setSOrgId(this.getSOrgId());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setPerson(this.getPerson());
			inst.setTypeDict(this.getTypeDict());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setPersonJobNumber(this.getPersonJobNumber());
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
	public AttendanceOfficialBusiVO clone(boolean deep) {
		return EntityContext.clone(AttendanceOfficialBusiVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AttendanceOfficialBusiVO
	 * @param attendanceOfficialBusiMap 包含实体信息的 Map 对象
	 * @return AttendanceOfficialBusiVO , 转换好的的 AttendanceOfficialBusi 对象
	*/
	@Transient
	public static AttendanceOfficialBusiVO createFrom(Map<String,Object> attendanceOfficialBusiMap) {
		if(attendanceOfficialBusiMap==null) return null;
		AttendanceOfficialBusiVO vo = create();
		EntityContext.copyProperties(vo,attendanceOfficialBusiMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AttendanceOfficialBusiVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AttendanceOfficialBusiVO , 转换好的的 AttendanceOfficialBusi 对象
	*/
	@Transient
	public static AttendanceOfficialBusiVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AttendanceOfficialBusiVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AttendanceOfficialBusiVO，等同于 new
	 * @return AttendanceOfficialBusiVO 对象
	*/
	@Transient
	public static AttendanceOfficialBusiVO create() {
		return new com.dt.platform.domain.hr.meta.AttendanceOfficialBusiVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.NOTES)));
			this.setActionSTime(DataParser.parse(Date.class, map.get(AttendanceOfficialBusiVOMeta.ACTION_S_TIME)));
			this.setBatchCode(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.BATCH_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AttendanceOfficialBusiVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AttendanceOfficialBusiVOMeta.VERSION)));
			this.setActionType(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.ACTION_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AttendanceOfficialBusiVOMeta.DELETED)));
			this.setActionDays(DataParser.parse(BigDecimal.class, map.get(AttendanceOfficialBusiVOMeta.ACTION_DAYS)));
			this.setActionETime(DataParser.parse(Date.class, map.get(AttendanceOfficialBusiVOMeta.ACTION_E_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AttendanceOfficialBusiVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AttendanceOfficialBusiVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.ID)));
			this.setActionDate(DataParser.parse(Date.class, map.get(AttendanceOfficialBusiVOMeta.ACTION_DATE)));
			this.setFileId(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.FILE_ID)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.REQUEST_ACTION)));
			this.setSOrgId(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.S_ORG_ID)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AttendanceOfficialBusiVOMeta.PAGE_SIZE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AttendanceOfficialBusiVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.SORT_TYPE)));
			this.setPerson(DataParser.parse(Person.class, map.get(AttendanceOfficialBusiVOMeta.PERSON)));
			this.setTypeDict(DataParser.parse(DictItem.class, map.get(AttendanceOfficialBusiVOMeta.TYPE_DICT)));
			this.setSortField(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.SORT_FIELD)));
			this.setPersonJobNumber(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.PERSON_JOB_NUMBER)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AttendanceOfficialBusiVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AttendanceOfficialBusiVOMeta.NOTES));
				this.setActionSTime( (Date)map.get(AttendanceOfficialBusiVOMeta.ACTION_S_TIME));
				this.setBatchCode( (String)map.get(AttendanceOfficialBusiVOMeta.BATCH_CODE));
				this.setUpdateTime( (Date)map.get(AttendanceOfficialBusiVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AttendanceOfficialBusiVOMeta.VERSION));
				this.setActionType( (String)map.get(AttendanceOfficialBusiVOMeta.ACTION_TYPE));
				this.setCreateBy( (String)map.get(AttendanceOfficialBusiVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AttendanceOfficialBusiVOMeta.DELETED));
				this.setActionDays( (BigDecimal)map.get(AttendanceOfficialBusiVOMeta.ACTION_DAYS));
				this.setActionETime( (Date)map.get(AttendanceOfficialBusiVOMeta.ACTION_E_TIME));
				this.setCreateTime( (Date)map.get(AttendanceOfficialBusiVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AttendanceOfficialBusiVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AttendanceOfficialBusiVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(AttendanceOfficialBusiVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AttendanceOfficialBusiVOMeta.DELETE_BY));
				this.setPersonId( (String)map.get(AttendanceOfficialBusiVOMeta.PERSON_ID));
				this.setId( (String)map.get(AttendanceOfficialBusiVOMeta.ID));
				this.setActionDate( (Date)map.get(AttendanceOfficialBusiVOMeta.ACTION_DATE));
				this.setFileId( (String)map.get(AttendanceOfficialBusiVOMeta.FILE_ID));
				// others
				this.setSearchField( (String)map.get(AttendanceOfficialBusiVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(AttendanceOfficialBusiVOMeta.REQUEST_ACTION));
				this.setSOrgId( (String)map.get(AttendanceOfficialBusiVOMeta.S_ORG_ID));
				this.setFuzzyField( (String)map.get(AttendanceOfficialBusiVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AttendanceOfficialBusiVOMeta.PAGE_SIZE));
				this.setPageIndex( (Integer)map.get(AttendanceOfficialBusiVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AttendanceOfficialBusiVOMeta.SORT_TYPE));
				this.setPerson( (Person)map.get(AttendanceOfficialBusiVOMeta.PERSON));
				this.setTypeDict( (DictItem)map.get(AttendanceOfficialBusiVOMeta.TYPE_DICT));
				this.setSortField( (String)map.get(AttendanceOfficialBusiVOMeta.SORT_FIELD));
				this.setPersonJobNumber( (String)map.get(AttendanceOfficialBusiVOMeta.PERSON_JOB_NUMBER));
				this.setDataOrigin( (String)map.get(AttendanceOfficialBusiVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(AttendanceOfficialBusiVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(AttendanceOfficialBusiVOMeta.SEARCH_VALUE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AttendanceOfficialBusiVOMeta.NOTES)));
			this.setActionSTime(DataParser.parse(Date.class, r.getValue(AttendanceOfficialBusiVOMeta.ACTION_S_TIME)));
			this.setBatchCode(DataParser.parse(String.class, r.getValue(AttendanceOfficialBusiVOMeta.BATCH_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AttendanceOfficialBusiVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AttendanceOfficialBusiVOMeta.VERSION)));
			this.setActionType(DataParser.parse(String.class, r.getValue(AttendanceOfficialBusiVOMeta.ACTION_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AttendanceOfficialBusiVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AttendanceOfficialBusiVOMeta.DELETED)));
			this.setActionDays(DataParser.parse(BigDecimal.class, r.getValue(AttendanceOfficialBusiVOMeta.ACTION_DAYS)));
			this.setActionETime(DataParser.parse(Date.class, r.getValue(AttendanceOfficialBusiVOMeta.ACTION_E_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AttendanceOfficialBusiVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AttendanceOfficialBusiVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AttendanceOfficialBusiVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AttendanceOfficialBusiVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AttendanceOfficialBusiVOMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(AttendanceOfficialBusiVOMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(AttendanceOfficialBusiVOMeta.ID)));
			this.setActionDate(DataParser.parse(Date.class, r.getValue(AttendanceOfficialBusiVOMeta.ACTION_DATE)));
			this.setFileId(DataParser.parse(String.class, r.getValue(AttendanceOfficialBusiVOMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AttendanceOfficialBusiVOMeta.NOTES));
				this.setActionSTime( (Date)r.getValue(AttendanceOfficialBusiVOMeta.ACTION_S_TIME));
				this.setBatchCode( (String)r.getValue(AttendanceOfficialBusiVOMeta.BATCH_CODE));
				this.setUpdateTime( (Date)r.getValue(AttendanceOfficialBusiVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AttendanceOfficialBusiVOMeta.VERSION));
				this.setActionType( (String)r.getValue(AttendanceOfficialBusiVOMeta.ACTION_TYPE));
				this.setCreateBy( (String)r.getValue(AttendanceOfficialBusiVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AttendanceOfficialBusiVOMeta.DELETED));
				this.setActionDays( (BigDecimal)r.getValue(AttendanceOfficialBusiVOMeta.ACTION_DAYS));
				this.setActionETime( (Date)r.getValue(AttendanceOfficialBusiVOMeta.ACTION_E_TIME));
				this.setCreateTime( (Date)r.getValue(AttendanceOfficialBusiVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AttendanceOfficialBusiVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AttendanceOfficialBusiVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(AttendanceOfficialBusiVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AttendanceOfficialBusiVOMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(AttendanceOfficialBusiVOMeta.PERSON_ID));
				this.setId( (String)r.getValue(AttendanceOfficialBusiVOMeta.ID));
				this.setActionDate( (Date)r.getValue(AttendanceOfficialBusiVOMeta.ACTION_DATE));
				this.setFileId( (String)r.getValue(AttendanceOfficialBusiVOMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}