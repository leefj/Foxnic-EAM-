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
import com.dt.platform.domain.ops.meta.DbChangeApplyVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 数据库变更申请VO类型
 * <p>数据库变更申请 , 数据表 ops_db_change_apply 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-31 18:26:51
 * @sign 2C7DA3DDEA1402913D0BE1E6AD52BEC4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "数据库变更申请VO类型 ; 数据库变更申请 , 数据表 ops_db_change_apply 的通用VO类型" , parent = DbChangeApply.class)
public class DbChangeApplyVO extends DbChangeApply {

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
	public DbChangeApplyVO setPageIndex(Integer pageIndex) {
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
	public DbChangeApplyVO setPageSize(Integer pageSize) {
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
	public DbChangeApplyVO setSearchField(String searchField) {
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
	public DbChangeApplyVO setFuzzyField(String fuzzyField) {
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
	public DbChangeApplyVO setSearchValue(String searchValue) {
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
	public DbChangeApplyVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public DbChangeApplyVO addDirtyField(String... dirtyField) {
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
	public DbChangeApplyVO setSortField(String sortField) {
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
	public DbChangeApplyVO setSortType(String sortType) {
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
	public DbChangeApplyVO setDataOrigin(String dataOrigin) {
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
	public DbChangeApplyVO setQueryLogic(String queryLogic) {
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
	public DbChangeApplyVO setRequestAction(String requestAction) {
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
	public DbChangeApplyVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public DbChangeApplyVO addId(String... id) {
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
	 * @return DbChangeApplyVO , 转换好的 DbChangeApplyVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbChangeApplyVO , 转换好的 PoJo 对象
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
	public DbChangeApplyVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DbChangeApplyVO duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DbChangeApplyVOMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DbChangeApplyVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setOrderId(this.getOrderId());
		inst.setItemCode(this.getItemCode());
		inst.setDbName(this.getDbName());
		inst.setDbFullName(this.getDbFullName());
		inst.setCheckResult(this.getCheckResult());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setApplyUserId(this.getApplyUserId());
		inst.setItemName(this.getItemName());
		inst.setPushOrderStatus(this.getPushOrderStatus());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDbId(this.getDbId());
		inst.setDbUser(this.getDbUser());
		inst.setId(this.getId());
		inst.setPushResult(this.getPushResult());
		inst.setSqlArea(this.getSqlArea());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setDbIp(this.getDbIp());
		inst.setVersion(this.getVersion());
		inst.setDbPort(this.getDbPort());
		inst.setAssociatedSystem(this.getAssociatedSystem());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCreateTime(this.getCreateTime());
		inst.setRbResult(this.getRbResult());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setButtonRBDetail(this.getButtonRBDetail());
			inst.setDbInfoApply(this.getDbInfoApply());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setButtonCheck(this.getButtonCheck());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setApplyUser(this.getApplyUser());
			inst.setRequestOrder(this.getRequestOrder());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setButtonCheckDetail(this.getButtonCheckDetail());
			inst.setButtonRB(this.getButtonRB());
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
	public DbChangeApplyVO clone(boolean deep) {
		return EntityContext.clone(DbChangeApplyVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbChangeApplyVO
	 * @param dbChangeApplyMap 包含实体信息的 Map 对象
	 * @return DbChangeApplyVO , 转换好的的 DbChangeApply 对象
	*/
	@Transient
	public static DbChangeApplyVO createFrom(Map<String,Object> dbChangeApplyMap) {
		if(dbChangeApplyMap==null) return null;
		DbChangeApplyVO vo = create();
		EntityContext.copyProperties(vo,dbChangeApplyMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 DbChangeApplyVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbChangeApplyVO , 转换好的的 DbChangeApply 对象
	*/
	@Transient
	public static DbChangeApplyVO createFrom(Object pojo) {
		if(pojo==null) return null;
		DbChangeApplyVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 DbChangeApplyVO，等同于 new
	 * @return DbChangeApplyVO 对象
	*/
	@Transient
	public static DbChangeApplyVO create() {
		return new com.dt.platform.domain.ops.meta.DbChangeApplyVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.NOTES)));
			this.setOrderId(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.ORDER_ID)));
			this.setItemCode(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.ITEM_CODE)));
			this.setDbName(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.DB_NAME)));
			this.setDbFullName(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.DB_FULL_NAME)));
			this.setCheckResult(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.CHECK_RESULT)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.CONTENT)));
			this.setApplyUserId(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.APPLY_USER_ID)));
			this.setItemName(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.ITEM_NAME)));
			this.setPushOrderStatus(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.PUSH_ORDER_STATUS)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.UPDATE_BY)));
			this.setDbId(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.DB_ID)));
			this.setDbUser(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.DB_USER)));
			this.setId(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.ID)));
			this.setPushResult(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.PUSH_RESULT)));
			this.setSqlArea(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.SQL_AREA)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DbChangeApplyVOMeta.UPDATE_TIME)));
			this.setDbIp(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.DB_IP)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DbChangeApplyVOMeta.VERSION)));
			this.setDbPort(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.DB_PORT)));
			this.setAssociatedSystem(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.ASSOCIATED_SYSTEM)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DbChangeApplyVOMeta.DELETED)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DbChangeApplyVOMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DbChangeApplyVOMeta.CREATE_TIME)));
			this.setRbResult(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.RB_RESULT)));
			this.setTenantId(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.STATUS)));
			// others
			this.setButtonRBDetail(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.BUTTON_RB_DETAIL)));
			this.setDbInfoApply(DataParser.parse(DbInfoApply.class, map.get(DbChangeApplyVOMeta.DB_INFO_APPLY)));
			this.setSearchField(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.REQUEST_ACTION)));
			this.setButtonCheck(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.BUTTON_CHECK)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(DbChangeApplyVOMeta.PAGE_SIZE)));
			this.setApplyUser(DataParser.parse(Employee.class, map.get(DbChangeApplyVOMeta.APPLY_USER)));
			this.setRequestOrder(DataParser.parse(DbApplyExecute.class, map.get(DbChangeApplyVOMeta.REQUEST_ORDER)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(DbChangeApplyVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.SORT_TYPE)));
			this.setButtonCheckDetail(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.BUTTON_CHECK_DETAIL)));
			this.setButtonRB(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.BUTTON_RB)));
			this.setSortField(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(DbChangeApplyVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(DbChangeApplyVOMeta.NOTES));
				this.setOrderId( (String)map.get(DbChangeApplyVOMeta.ORDER_ID));
				this.setItemCode( (String)map.get(DbChangeApplyVOMeta.ITEM_CODE));
				this.setDbName( (String)map.get(DbChangeApplyVOMeta.DB_NAME));
				this.setDbFullName( (String)map.get(DbChangeApplyVOMeta.DB_FULL_NAME));
				this.setCheckResult( (String)map.get(DbChangeApplyVOMeta.CHECK_RESULT));
				this.setSelectedCode( (String)map.get(DbChangeApplyVOMeta.SELECTED_CODE));
				this.setContent( (String)map.get(DbChangeApplyVOMeta.CONTENT));
				this.setApplyUserId( (String)map.get(DbChangeApplyVOMeta.APPLY_USER_ID));
				this.setItemName( (String)map.get(DbChangeApplyVOMeta.ITEM_NAME));
				this.setPushOrderStatus( (String)map.get(DbChangeApplyVOMeta.PUSH_ORDER_STATUS));
				this.setUpdateBy( (String)map.get(DbChangeApplyVOMeta.UPDATE_BY));
				this.setDbId( (String)map.get(DbChangeApplyVOMeta.DB_ID));
				this.setDbUser( (String)map.get(DbChangeApplyVOMeta.DB_USER));
				this.setId( (String)map.get(DbChangeApplyVOMeta.ID));
				this.setPushResult( (String)map.get(DbChangeApplyVOMeta.PUSH_RESULT));
				this.setSqlArea( (String)map.get(DbChangeApplyVOMeta.SQL_AREA));
				this.setUpdateTime( (Date)map.get(DbChangeApplyVOMeta.UPDATE_TIME));
				this.setDbIp( (String)map.get(DbChangeApplyVOMeta.DB_IP));
				this.setVersion( (Integer)map.get(DbChangeApplyVOMeta.VERSION));
				this.setDbPort( (String)map.get(DbChangeApplyVOMeta.DB_PORT));
				this.setAssociatedSystem( (String)map.get(DbChangeApplyVOMeta.ASSOCIATED_SYSTEM));
				this.setCreateBy( (String)map.get(DbChangeApplyVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DbChangeApplyVOMeta.DELETED));
				this.setDeleteTime( (Date)map.get(DbChangeApplyVOMeta.DELETE_TIME));
				this.setCreateTime( (Date)map.get(DbChangeApplyVOMeta.CREATE_TIME));
				this.setRbResult( (String)map.get(DbChangeApplyVOMeta.RB_RESULT));
				this.setTenantId( (String)map.get(DbChangeApplyVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(DbChangeApplyVOMeta.DELETE_BY));
				this.setStatus( (String)map.get(DbChangeApplyVOMeta.STATUS));
				// others
				this.setButtonRBDetail( (String)map.get(DbChangeApplyVOMeta.BUTTON_RB_DETAIL));
				this.setDbInfoApply( (DbInfoApply)map.get(DbChangeApplyVOMeta.DB_INFO_APPLY));
				this.setSearchField( (String)map.get(DbChangeApplyVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(DbChangeApplyVOMeta.REQUEST_ACTION));
				this.setButtonCheck( (String)map.get(DbChangeApplyVOMeta.BUTTON_CHECK));
				this.setFuzzyField( (String)map.get(DbChangeApplyVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(DbChangeApplyVOMeta.PAGE_SIZE));
				this.setApplyUser( (Employee)map.get(DbChangeApplyVOMeta.APPLY_USER));
				this.setRequestOrder( (DbApplyExecute)map.get(DbChangeApplyVOMeta.REQUEST_ORDER));
				this.setPageIndex( (Integer)map.get(DbChangeApplyVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(DbChangeApplyVOMeta.SORT_TYPE));
				this.setButtonCheckDetail( (String)map.get(DbChangeApplyVOMeta.BUTTON_CHECK_DETAIL));
				this.setButtonRB( (String)map.get(DbChangeApplyVOMeta.BUTTON_RB));
				this.setSortField( (String)map.get(DbChangeApplyVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(DbChangeApplyVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(DbChangeApplyVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(DbChangeApplyVOMeta.SEARCH_VALUE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.NOTES)));
			this.setOrderId(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.ORDER_ID)));
			this.setItemCode(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.ITEM_CODE)));
			this.setDbName(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.DB_NAME)));
			this.setDbFullName(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.DB_FULL_NAME)));
			this.setCheckResult(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.CHECK_RESULT)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.CONTENT)));
			this.setApplyUserId(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.APPLY_USER_ID)));
			this.setItemName(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.ITEM_NAME)));
			this.setPushOrderStatus(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.PUSH_ORDER_STATUS)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.UPDATE_BY)));
			this.setDbId(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.DB_ID)));
			this.setDbUser(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.DB_USER)));
			this.setId(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.ID)));
			this.setPushResult(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.PUSH_RESULT)));
			this.setSqlArea(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.SQL_AREA)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DbChangeApplyVOMeta.UPDATE_TIME)));
			this.setDbIp(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.DB_IP)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DbChangeApplyVOMeta.VERSION)));
			this.setDbPort(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.DB_PORT)));
			this.setAssociatedSystem(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.ASSOCIATED_SYSTEM)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DbChangeApplyVOMeta.DELETED)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DbChangeApplyVOMeta.DELETE_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DbChangeApplyVOMeta.CREATE_TIME)));
			this.setRbResult(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.RB_RESULT)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(DbChangeApplyVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(DbChangeApplyVOMeta.NOTES));
				this.setOrderId( (String)r.getValue(DbChangeApplyVOMeta.ORDER_ID));
				this.setItemCode( (String)r.getValue(DbChangeApplyVOMeta.ITEM_CODE));
				this.setDbName( (String)r.getValue(DbChangeApplyVOMeta.DB_NAME));
				this.setDbFullName( (String)r.getValue(DbChangeApplyVOMeta.DB_FULL_NAME));
				this.setCheckResult( (String)r.getValue(DbChangeApplyVOMeta.CHECK_RESULT));
				this.setSelectedCode( (String)r.getValue(DbChangeApplyVOMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(DbChangeApplyVOMeta.CONTENT));
				this.setApplyUserId( (String)r.getValue(DbChangeApplyVOMeta.APPLY_USER_ID));
				this.setItemName( (String)r.getValue(DbChangeApplyVOMeta.ITEM_NAME));
				this.setPushOrderStatus( (String)r.getValue(DbChangeApplyVOMeta.PUSH_ORDER_STATUS));
				this.setUpdateBy( (String)r.getValue(DbChangeApplyVOMeta.UPDATE_BY));
				this.setDbId( (String)r.getValue(DbChangeApplyVOMeta.DB_ID));
				this.setDbUser( (String)r.getValue(DbChangeApplyVOMeta.DB_USER));
				this.setId( (String)r.getValue(DbChangeApplyVOMeta.ID));
				this.setPushResult( (String)r.getValue(DbChangeApplyVOMeta.PUSH_RESULT));
				this.setSqlArea( (String)r.getValue(DbChangeApplyVOMeta.SQL_AREA));
				this.setUpdateTime( (Date)r.getValue(DbChangeApplyVOMeta.UPDATE_TIME));
				this.setDbIp( (String)r.getValue(DbChangeApplyVOMeta.DB_IP));
				this.setVersion( (Integer)r.getValue(DbChangeApplyVOMeta.VERSION));
				this.setDbPort( (String)r.getValue(DbChangeApplyVOMeta.DB_PORT));
				this.setAssociatedSystem( (String)r.getValue(DbChangeApplyVOMeta.ASSOCIATED_SYSTEM));
				this.setCreateBy( (String)r.getValue(DbChangeApplyVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DbChangeApplyVOMeta.DELETED));
				this.setDeleteTime( (Date)r.getValue(DbChangeApplyVOMeta.DELETE_TIME));
				this.setCreateTime( (Date)r.getValue(DbChangeApplyVOMeta.CREATE_TIME));
				this.setRbResult( (String)r.getValue(DbChangeApplyVOMeta.RB_RESULT));
				this.setTenantId( (String)r.getValue(DbChangeApplyVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(DbChangeApplyVOMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(DbChangeApplyVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}