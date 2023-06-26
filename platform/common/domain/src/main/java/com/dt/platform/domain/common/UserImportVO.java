package com.dt.platform.domain.common;

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
import com.dt.platform.domain.common.meta.UserImportVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 员工导入VO类型
 * <p>员工导入 , 数据表 sys_user_import 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-18 19:13:37
 * @sign 108675BC94CD650688663AB2624DE715
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "员工导入VO类型 ; 员工导入 , 数据表 sys_user_import 的通用VO类型" , parent = UserImport.class)
public class UserImportVO extends UserImport {

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
	public UserImportVO setPageIndex(Integer pageIndex) {
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
	public UserImportVO setPageSize(Integer pageSize) {
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
	public UserImportVO setSearchField(String searchField) {
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
	public UserImportVO setFuzzyField(String fuzzyField) {
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
	public UserImportVO setSearchValue(String searchValue) {
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
	public UserImportVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public UserImportVO addDirtyField(String... dirtyField) {
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
	public UserImportVO setSortField(String sortField) {
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
	public UserImportVO setSortType(String sortType) {
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
	public UserImportVO setDataOrigin(String dataOrigin) {
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
	public UserImportVO setQueryLogic(String queryLogic) {
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
	public UserImportVO setRequestAction(String requestAction) {
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
	public UserImportVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public UserImportVO addId(String... id) {
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
	 * @return UserImportVO , 转换好的 UserImportVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return UserImportVO , 转换好的 PoJo 对象
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
	public UserImportVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public UserImportVO duplicate(boolean all) {
		com.dt.platform.domain.common.meta.UserImportVOMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.UserImportVOMeta.$$proxy$$();
		inst.setIdCard(this.getIdCard());
		inst.setCompanyName(this.getCompanyName());
		inst.setMasterPost(this.getMasterPost());
		inst.setActionStatus(this.getActionStatus());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setActionCode(this.getActionCode());
		inst.setId(this.getId());
		inst.setMasterPostId(this.getMasterPostId());
		inst.setSex(this.getSex());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserName(this.getUserName());
		inst.setVersion(this.getVersion());
		inst.setActionOperTime(this.getActionOperTime());
		inst.setBadge(this.getBadge());
		inst.setSexCode(this.getSexCode());
		inst.setCompanyId(this.getCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPhone(this.getPhone());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setActionMsg(this.getActionMsg());
		inst.setStatus(this.getStatus());
		inst.setStatusCode(this.getStatusCode());
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
	public UserImportVO clone(boolean deep) {
		return EntityContext.clone(UserImportVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 UserImportVO
	 * @param userImportMap 包含实体信息的 Map 对象
	 * @return UserImportVO , 转换好的的 UserImport 对象
	*/
	@Transient
	public static UserImportVO createFrom(Map<String,Object> userImportMap) {
		if(userImportMap==null) return null;
		UserImportVO vo = create();
		EntityContext.copyProperties(vo,userImportMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 UserImportVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return UserImportVO , 转换好的的 UserImport 对象
	*/
	@Transient
	public static UserImportVO createFrom(Object pojo) {
		if(pojo==null) return null;
		UserImportVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 UserImportVO，等同于 new
	 * @return UserImportVO 对象
	*/
	@Transient
	public static UserImportVO create() {
		return new com.dt.platform.domain.common.meta.UserImportVOMeta.$$proxy$$();
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
			this.setIdCard(DataParser.parse(String.class, map.get(UserImportVOMeta.ID_CARD)));
			this.setCompanyName(DataParser.parse(String.class, map.get(UserImportVOMeta.COMPANY_NAME)));
			this.setMasterPost(DataParser.parse(String.class, map.get(UserImportVOMeta.MASTER_POST)));
			this.setActionStatus(DataParser.parse(String.class, map.get(UserImportVOMeta.ACTION_STATUS)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(UserImportVOMeta.UPDATE_BY)));
			this.setActionCode(DataParser.parse(String.class, map.get(UserImportVOMeta.ACTION_CODE)));
			this.setId(DataParser.parse(String.class, map.get(UserImportVOMeta.ID)));
			this.setMasterPostId(DataParser.parse(String.class, map.get(UserImportVOMeta.MASTER_POST_ID)));
			this.setSex(DataParser.parse(String.class, map.get(UserImportVOMeta.SEX)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(UserImportVOMeta.UPDATE_TIME)));
			this.setUserName(DataParser.parse(String.class, map.get(UserImportVOMeta.USER_NAME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(UserImportVOMeta.VERSION)));
			this.setActionOperTime(DataParser.parse(Date.class, map.get(UserImportVOMeta.ACTION_OPER_TIME)));
			this.setBadge(DataParser.parse(String.class, map.get(UserImportVOMeta.BADGE)));
			this.setSexCode(DataParser.parse(String.class, map.get(UserImportVOMeta.SEX_CODE)));
			this.setCompanyId(DataParser.parse(String.class, map.get(UserImportVOMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(UserImportVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(UserImportVOMeta.DELETED)));
			this.setPhone(DataParser.parse(String.class, map.get(UserImportVOMeta.PHONE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(UserImportVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(UserImportVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(UserImportVOMeta.DELETE_BY)));
			this.setActionMsg(DataParser.parse(String.class, map.get(UserImportVOMeta.ACTION_MSG)));
			this.setStatus(DataParser.parse(String.class, map.get(UserImportVOMeta.STATUS)));
			this.setStatusCode(DataParser.parse(String.class, map.get(UserImportVOMeta.STATUS_CODE)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(UserImportVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(UserImportVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(UserImportVOMeta.SORT_TYPE)));
			this.setRequestAction(DataParser.parse(String.class, map.get(UserImportVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(UserImportVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(UserImportVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(UserImportVOMeta.PAGE_SIZE)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(UserImportVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(UserImportVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(UserImportVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setIdCard( (String)map.get(UserImportVOMeta.ID_CARD));
				this.setCompanyName( (String)map.get(UserImportVOMeta.COMPANY_NAME));
				this.setMasterPost( (String)map.get(UserImportVOMeta.MASTER_POST));
				this.setActionStatus( (String)map.get(UserImportVOMeta.ACTION_STATUS));
				this.setUpdateBy( (String)map.get(UserImportVOMeta.UPDATE_BY));
				this.setActionCode( (String)map.get(UserImportVOMeta.ACTION_CODE));
				this.setId( (String)map.get(UserImportVOMeta.ID));
				this.setMasterPostId( (String)map.get(UserImportVOMeta.MASTER_POST_ID));
				this.setSex( (String)map.get(UserImportVOMeta.SEX));
				this.setUpdateTime( (Date)map.get(UserImportVOMeta.UPDATE_TIME));
				this.setUserName( (String)map.get(UserImportVOMeta.USER_NAME));
				this.setVersion( (Integer)map.get(UserImportVOMeta.VERSION));
				this.setActionOperTime( (Date)map.get(UserImportVOMeta.ACTION_OPER_TIME));
				this.setBadge( (String)map.get(UserImportVOMeta.BADGE));
				this.setSexCode( (String)map.get(UserImportVOMeta.SEX_CODE));
				this.setCompanyId( (String)map.get(UserImportVOMeta.COMPANY_ID));
				this.setCreateBy( (String)map.get(UserImportVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(UserImportVOMeta.DELETED));
				this.setPhone( (String)map.get(UserImportVOMeta.PHONE));
				this.setCreateTime( (Date)map.get(UserImportVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(UserImportVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(UserImportVOMeta.DELETE_BY));
				this.setActionMsg( (String)map.get(UserImportVOMeta.ACTION_MSG));
				this.setStatus( (String)map.get(UserImportVOMeta.STATUS));
				this.setStatusCode( (String)map.get(UserImportVOMeta.STATUS_CODE));
				// others
				this.setSearchField( (String)map.get(UserImportVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(UserImportVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(UserImportVOMeta.SORT_TYPE));
				this.setRequestAction( (String)map.get(UserImportVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(UserImportVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(UserImportVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(UserImportVOMeta.PAGE_SIZE));
				this.setDataOrigin( (String)map.get(UserImportVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(UserImportVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(UserImportVOMeta.SEARCH_VALUE));
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
			this.setIdCard(DataParser.parse(String.class, r.getValue(UserImportVOMeta.ID_CARD)));
			this.setCompanyName(DataParser.parse(String.class, r.getValue(UserImportVOMeta.COMPANY_NAME)));
			this.setMasterPost(DataParser.parse(String.class, r.getValue(UserImportVOMeta.MASTER_POST)));
			this.setActionStatus(DataParser.parse(String.class, r.getValue(UserImportVOMeta.ACTION_STATUS)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(UserImportVOMeta.UPDATE_BY)));
			this.setActionCode(DataParser.parse(String.class, r.getValue(UserImportVOMeta.ACTION_CODE)));
			this.setId(DataParser.parse(String.class, r.getValue(UserImportVOMeta.ID)));
			this.setMasterPostId(DataParser.parse(String.class, r.getValue(UserImportVOMeta.MASTER_POST_ID)));
			this.setSex(DataParser.parse(String.class, r.getValue(UserImportVOMeta.SEX)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(UserImportVOMeta.UPDATE_TIME)));
			this.setUserName(DataParser.parse(String.class, r.getValue(UserImportVOMeta.USER_NAME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(UserImportVOMeta.VERSION)));
			this.setActionOperTime(DataParser.parse(Date.class, r.getValue(UserImportVOMeta.ACTION_OPER_TIME)));
			this.setBadge(DataParser.parse(String.class, r.getValue(UserImportVOMeta.BADGE)));
			this.setSexCode(DataParser.parse(String.class, r.getValue(UserImportVOMeta.SEX_CODE)));
			this.setCompanyId(DataParser.parse(String.class, r.getValue(UserImportVOMeta.COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(UserImportVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(UserImportVOMeta.DELETED)));
			this.setPhone(DataParser.parse(String.class, r.getValue(UserImportVOMeta.PHONE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(UserImportVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(UserImportVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(UserImportVOMeta.DELETE_BY)));
			this.setActionMsg(DataParser.parse(String.class, r.getValue(UserImportVOMeta.ACTION_MSG)));
			this.setStatus(DataParser.parse(String.class, r.getValue(UserImportVOMeta.STATUS)));
			this.setStatusCode(DataParser.parse(String.class, r.getValue(UserImportVOMeta.STATUS_CODE)));
			return true;
		} else {
			try {
				this.setIdCard( (String)r.getValue(UserImportVOMeta.ID_CARD));
				this.setCompanyName( (String)r.getValue(UserImportVOMeta.COMPANY_NAME));
				this.setMasterPost( (String)r.getValue(UserImportVOMeta.MASTER_POST));
				this.setActionStatus( (String)r.getValue(UserImportVOMeta.ACTION_STATUS));
				this.setUpdateBy( (String)r.getValue(UserImportVOMeta.UPDATE_BY));
				this.setActionCode( (String)r.getValue(UserImportVOMeta.ACTION_CODE));
				this.setId( (String)r.getValue(UserImportVOMeta.ID));
				this.setMasterPostId( (String)r.getValue(UserImportVOMeta.MASTER_POST_ID));
				this.setSex( (String)r.getValue(UserImportVOMeta.SEX));
				this.setUpdateTime( (Date)r.getValue(UserImportVOMeta.UPDATE_TIME));
				this.setUserName( (String)r.getValue(UserImportVOMeta.USER_NAME));
				this.setVersion( (Integer)r.getValue(UserImportVOMeta.VERSION));
				this.setActionOperTime( (Date)r.getValue(UserImportVOMeta.ACTION_OPER_TIME));
				this.setBadge( (String)r.getValue(UserImportVOMeta.BADGE));
				this.setSexCode( (String)r.getValue(UserImportVOMeta.SEX_CODE));
				this.setCompanyId( (String)r.getValue(UserImportVOMeta.COMPANY_ID));
				this.setCreateBy( (String)r.getValue(UserImportVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(UserImportVOMeta.DELETED));
				this.setPhone( (String)r.getValue(UserImportVOMeta.PHONE));
				this.setCreateTime( (Date)r.getValue(UserImportVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(UserImportVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(UserImportVOMeta.DELETE_BY));
				this.setActionMsg( (String)r.getValue(UserImportVOMeta.ACTION_MSG));
				this.setStatus( (String)r.getValue(UserImportVOMeta.STATUS));
				this.setStatusCode( (String)r.getValue(UserImportVOMeta.STATUS_CODE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}