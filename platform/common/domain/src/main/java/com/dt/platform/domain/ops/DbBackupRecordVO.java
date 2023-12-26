package com.dt.platform.domain.ops;

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
import com.dt.platform.domain.ops.meta.DbBackupRecordVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 数据库备份记录VO类型
 * <p>数据库备份记录 , 数据表 ops_db_backup_record 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-12-26 12:29:45
 * @sign 798FCB60A7BA0C5F5F1DE270617FFB78
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "数据库备份记录VO类型 ; 数据库备份记录 , 数据表 ops_db_backup_record 的通用VO类型" , parent = DbBackupRecord.class)
public class DbBackupRecordVO extends DbBackupRecord {

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
	public DbBackupRecordVO setPageIndex(Integer pageIndex) {
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
	public DbBackupRecordVO setPageSize(Integer pageSize) {
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
	public DbBackupRecordVO setSearchField(String searchField) {
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
	public DbBackupRecordVO setFuzzyField(String fuzzyField) {
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
	public DbBackupRecordVO setSearchValue(String searchValue) {
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
	public DbBackupRecordVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public DbBackupRecordVO addDirtyField(String... dirtyField) {
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
	public DbBackupRecordVO setSortField(String sortField) {
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
	public DbBackupRecordVO setSortType(String sortType) {
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
	public DbBackupRecordVO setDataOrigin(String dataOrigin) {
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
	public DbBackupRecordVO setQueryLogic(String queryLogic) {
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
	public DbBackupRecordVO setRequestAction(String requestAction) {
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
	public DbBackupRecordVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public DbBackupRecordVO addId(String... id) {
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
	 * @return DbBackupRecordVO , 转换好的 DbBackupRecordVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbBackupRecordVO , 转换好的 PoJo 对象
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
	public DbBackupRecordVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DbBackupRecordVO duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DbBackupRecordVOMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DbBackupRecordVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setDbName(this.getDbName());
		inst.setBackupStime(this.getBackupStime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setDbBkId(this.getDbBkId());
		inst.setVersion(this.getVersion());
		inst.setBackupSize(this.getBackupSize());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDbId(this.getDbId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStrategy(this.getStrategy());
		inst.setBackupResultCt(this.getBackupResultCt());
		inst.setRetention(this.getRetention());
		inst.setBackupResult(this.getBackupResult());
		inst.setBackupSource(this.getBackupSource());
		inst.setBackupEtime(this.getBackupEtime());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setDbType(this.getDbType());
			inst.setPageSize(this.getPageSize());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setHost(this.getHost());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSearchValue(this.getSearchValue());
			inst.setDb(this.getDb());
			inst.setBackupInfo(this.getBackupInfo());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DbBackupRecordVO clone(boolean deep) {
		return EntityContext.clone(DbBackupRecordVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbBackupRecordVO
	 * @param dbBackupRecordMap 包含实体信息的 Map 对象
	 * @return DbBackupRecordVO , 转换好的的 DbBackupRecord 对象
	*/
	@Transient
	public static DbBackupRecordVO createFrom(Map<String,Object> dbBackupRecordMap) {
		if(dbBackupRecordMap==null) return null;
		DbBackupRecordVO vo = create();
		EntityContext.copyProperties(vo,dbBackupRecordMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 DbBackupRecordVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbBackupRecordVO , 转换好的的 DbBackupRecord 对象
	*/
	@Transient
	public static DbBackupRecordVO createFrom(Object pojo) {
		if(pojo==null) return null;
		DbBackupRecordVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 DbBackupRecordVO，等同于 new
	 * @return DbBackupRecordVO 对象
	*/
	@Transient
	public static DbBackupRecordVO create() {
		return new com.dt.platform.domain.ops.meta.DbBackupRecordVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.NOTES)));
			this.setDbName(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.DB_NAME)));
			this.setBackupStime(DataParser.parse(Date.class, map.get(DbBackupRecordVOMeta.BACKUP_STIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DbBackupRecordVOMeta.UPDATE_TIME)));
			this.setDbBkId(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.DB_BK_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DbBackupRecordVOMeta.VERSION)));
			this.setBackupSize(DataParser.parse(BigDecimal.class, map.get(DbBackupRecordVOMeta.BACKUP_SIZE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DbBackupRecordVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DbBackupRecordVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DbBackupRecordVOMeta.DELETE_TIME)));
			this.setDbId(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.DB_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.ID)));
			this.setStrategy(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.STRATEGY)));
			this.setBackupResultCt(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.BACKUP_RESULT_CT)));
			this.setRetention(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.RETENTION)));
			this.setBackupResult(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.BACKUP_RESULT)));
			this.setBackupSource(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.BACKUP_SOURCE)));
			this.setBackupEtime(DataParser.parse(Date.class, map.get(DbBackupRecordVOMeta.BACKUP_ETIME)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.FUZZY_FIELD)));
			this.setDbType(DataParser.parse(ServiceInfo.class, map.get(DbBackupRecordVOMeta.DB_TYPE)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(DbBackupRecordVOMeta.PAGE_SIZE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(DbBackupRecordVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.SORT_TYPE)));
			this.setHost(DataParser.parse(Host.class, map.get(DbBackupRecordVOMeta.HOST)));
			this.setSortField(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(DbBackupRecordVOMeta.SEARCH_VALUE)));
			this.setDb(DataParser.parse(DbInfo.class, map.get(DbBackupRecordVOMeta.DB)));
			this.setBackupInfo(DataParser.parse(DbBackupInfo.class, map.get(DbBackupRecordVOMeta.BACKUP_INFO)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(DbBackupRecordVOMeta.NOTES));
				this.setDbName( (String)map.get(DbBackupRecordVOMeta.DB_NAME));
				this.setBackupStime( (Date)map.get(DbBackupRecordVOMeta.BACKUP_STIME));
				this.setUpdateTime( (Date)map.get(DbBackupRecordVOMeta.UPDATE_TIME));
				this.setDbBkId( (String)map.get(DbBackupRecordVOMeta.DB_BK_ID));
				this.setVersion( (Integer)map.get(DbBackupRecordVOMeta.VERSION));
				this.setBackupSize( (BigDecimal)map.get(DbBackupRecordVOMeta.BACKUP_SIZE));
				this.setCreateBy( (String)map.get(DbBackupRecordVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DbBackupRecordVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(DbBackupRecordVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(DbBackupRecordVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DbBackupRecordVOMeta.DELETE_TIME));
				this.setDbId( (String)map.get(DbBackupRecordVOMeta.DB_ID));
				this.setDeleteBy( (String)map.get(DbBackupRecordVOMeta.DELETE_BY));
				this.setId( (String)map.get(DbBackupRecordVOMeta.ID));
				this.setStrategy( (String)map.get(DbBackupRecordVOMeta.STRATEGY));
				this.setBackupResultCt( (String)map.get(DbBackupRecordVOMeta.BACKUP_RESULT_CT));
				this.setRetention( (String)map.get(DbBackupRecordVOMeta.RETENTION));
				this.setBackupResult( (String)map.get(DbBackupRecordVOMeta.BACKUP_RESULT));
				this.setBackupSource( (String)map.get(DbBackupRecordVOMeta.BACKUP_SOURCE));
				this.setBackupEtime( (Date)map.get(DbBackupRecordVOMeta.BACKUP_ETIME));
				// others
				this.setSearchField( (String)map.get(DbBackupRecordVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(DbBackupRecordVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(DbBackupRecordVOMeta.FUZZY_FIELD));
				this.setDbType( (ServiceInfo)map.get(DbBackupRecordVOMeta.DB_TYPE));
				this.setPageSize( (Integer)map.get(DbBackupRecordVOMeta.PAGE_SIZE));
				this.setPageIndex( (Integer)map.get(DbBackupRecordVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(DbBackupRecordVOMeta.SORT_TYPE));
				this.setHost( (Host)map.get(DbBackupRecordVOMeta.HOST));
				this.setSortField( (String)map.get(DbBackupRecordVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(DbBackupRecordVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(DbBackupRecordVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(DbBackupRecordVOMeta.SEARCH_VALUE));
				this.setDb( (DbInfo)map.get(DbBackupRecordVOMeta.DB));
				this.setBackupInfo( (DbBackupInfo)map.get(DbBackupRecordVOMeta.BACKUP_INFO));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(DbBackupRecordVOMeta.NOTES)));
			this.setDbName(DataParser.parse(String.class, r.getValue(DbBackupRecordVOMeta.DB_NAME)));
			this.setBackupStime(DataParser.parse(Date.class, r.getValue(DbBackupRecordVOMeta.BACKUP_STIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DbBackupRecordVOMeta.UPDATE_TIME)));
			this.setDbBkId(DataParser.parse(String.class, r.getValue(DbBackupRecordVOMeta.DB_BK_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DbBackupRecordVOMeta.VERSION)));
			this.setBackupSize(DataParser.parse(BigDecimal.class, r.getValue(DbBackupRecordVOMeta.BACKUP_SIZE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DbBackupRecordVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DbBackupRecordVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DbBackupRecordVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DbBackupRecordVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DbBackupRecordVOMeta.DELETE_TIME)));
			this.setDbId(DataParser.parse(String.class, r.getValue(DbBackupRecordVOMeta.DB_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DbBackupRecordVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(DbBackupRecordVOMeta.ID)));
			this.setStrategy(DataParser.parse(String.class, r.getValue(DbBackupRecordVOMeta.STRATEGY)));
			this.setBackupResultCt(DataParser.parse(String.class, r.getValue(DbBackupRecordVOMeta.BACKUP_RESULT_CT)));
			this.setRetention(DataParser.parse(String.class, r.getValue(DbBackupRecordVOMeta.RETENTION)));
			this.setBackupResult(DataParser.parse(String.class, r.getValue(DbBackupRecordVOMeta.BACKUP_RESULT)));
			this.setBackupSource(DataParser.parse(String.class, r.getValue(DbBackupRecordVOMeta.BACKUP_SOURCE)));
			this.setBackupEtime(DataParser.parse(Date.class, r.getValue(DbBackupRecordVOMeta.BACKUP_ETIME)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(DbBackupRecordVOMeta.NOTES));
				this.setDbName( (String)r.getValue(DbBackupRecordVOMeta.DB_NAME));
				this.setBackupStime( (Date)r.getValue(DbBackupRecordVOMeta.BACKUP_STIME));
				this.setUpdateTime( (Date)r.getValue(DbBackupRecordVOMeta.UPDATE_TIME));
				this.setDbBkId( (String)r.getValue(DbBackupRecordVOMeta.DB_BK_ID));
				this.setVersion( (Integer)r.getValue(DbBackupRecordVOMeta.VERSION));
				this.setBackupSize( (BigDecimal)r.getValue(DbBackupRecordVOMeta.BACKUP_SIZE));
				this.setCreateBy( (String)r.getValue(DbBackupRecordVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DbBackupRecordVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(DbBackupRecordVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(DbBackupRecordVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DbBackupRecordVOMeta.DELETE_TIME));
				this.setDbId( (String)r.getValue(DbBackupRecordVOMeta.DB_ID));
				this.setDeleteBy( (String)r.getValue(DbBackupRecordVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(DbBackupRecordVOMeta.ID));
				this.setStrategy( (String)r.getValue(DbBackupRecordVOMeta.STRATEGY));
				this.setBackupResultCt( (String)r.getValue(DbBackupRecordVOMeta.BACKUP_RESULT_CT));
				this.setRetention( (String)r.getValue(DbBackupRecordVOMeta.RETENTION));
				this.setBackupResult( (String)r.getValue(DbBackupRecordVOMeta.BACKUP_RESULT));
				this.setBackupSource( (String)r.getValue(DbBackupRecordVOMeta.BACKUP_SOURCE));
				this.setBackupEtime( (Date)r.getValue(DbBackupRecordVOMeta.BACKUP_ETIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}