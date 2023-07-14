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
import com.dt.platform.domain.ops.meta.HostEnvInfoVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 主机环境VO类型
 * <p>主机环境 , 数据表 ops_host_env_info 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-14 20:34:43
 * @sign 70A017C6704AD53DBA27C06FE97096B3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "主机环境VO类型 ; 主机环境 , 数据表 ops_host_env_info 的通用VO类型" , parent = HostEnvInfo.class)
public class HostEnvInfoVO extends HostEnvInfo {

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
	public HostEnvInfoVO setPageIndex(Integer pageIndex) {
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
	public HostEnvInfoVO setPageSize(Integer pageSize) {
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
	public HostEnvInfoVO setSearchField(String searchField) {
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
	public HostEnvInfoVO setFuzzyField(String fuzzyField) {
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
	public HostEnvInfoVO setSearchValue(String searchValue) {
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
	public HostEnvInfoVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public HostEnvInfoVO addDirtyField(String... dirtyField) {
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
	public HostEnvInfoVO setSortField(String sortField) {
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
	public HostEnvInfoVO setSortType(String sortType) {
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
	public HostEnvInfoVO setDataOrigin(String dataOrigin) {
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
	public HostEnvInfoVO setQueryLogic(String queryLogic) {
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
	public HostEnvInfoVO setRequestAction(String requestAction) {
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
	public HostEnvInfoVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public HostEnvInfoVO addId(String... id) {
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
	 * @return HostEnvInfoVO , 转换好的 HostEnvInfoVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return HostEnvInfoVO , 转换好的 PoJo 对象
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
	public HostEnvInfoVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public HostEnvInfoVO duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.HostEnvInfoVOMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.HostEnvInfoVOMeta.$$proxy$$();
		inst.setSystemId(this.getSystemId());
		inst.setNotes(this.getNotes());
		inst.setVoucher(this.getVoucher());
		inst.setIp(this.getIp());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setLabel(this.getLabel());
		inst.setVersion(this.getVersion());
		inst.setHostname(this.getHostname());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setIpv6(this.getIpv6());
		inst.setHostDesc(this.getHostDesc());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setVip(this.getVip());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setInfoSystem(this.getInfoSystem());
			inst.setPageSize(this.getPageSize());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSearchValue(this.getSearchValue());
			inst.setCiphertextBoxData(this.getCiphertextBoxData());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public HostEnvInfoVO clone(boolean deep) {
		return EntityContext.clone(HostEnvInfoVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 HostEnvInfoVO
	 * @param hostEnvInfoMap 包含实体信息的 Map 对象
	 * @return HostEnvInfoVO , 转换好的的 HostEnvInfo 对象
	*/
	@Transient
	public static HostEnvInfoVO createFrom(Map<String,Object> hostEnvInfoMap) {
		if(hostEnvInfoMap==null) return null;
		HostEnvInfoVO vo = create();
		EntityContext.copyProperties(vo,hostEnvInfoMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 HostEnvInfoVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return HostEnvInfoVO , 转换好的的 HostEnvInfo 对象
	*/
	@Transient
	public static HostEnvInfoVO createFrom(Object pojo) {
		if(pojo==null) return null;
		HostEnvInfoVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 HostEnvInfoVO，等同于 new
	 * @return HostEnvInfoVO 对象
	*/
	@Transient
	public static HostEnvInfoVO create() {
		return new com.dt.platform.domain.ops.meta.HostEnvInfoVOMeta.$$proxy$$();
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
			this.setSystemId(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.SYSTEM_ID)));
			this.setNotes(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.NOTES)));
			this.setVoucher(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.VOUCHER)));
			this.setIp(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.IP)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(HostEnvInfoVOMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.LABEL)));
			this.setVersion(DataParser.parse(Integer.class, map.get(HostEnvInfoVOMeta.VERSION)));
			this.setHostname(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.HOSTNAME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(HostEnvInfoVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(HostEnvInfoVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(HostEnvInfoVOMeta.DELETE_TIME)));
			this.setIpv6(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.IPV6)));
			this.setHostDesc(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.HOST_DESC)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.ID)));
			this.setVip(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.VIP)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.FUZZY_FIELD)));
			this.setInfoSystem(DataParser.parse(InformationSystem.class, map.get(HostEnvInfoVOMeta.INFO_SYSTEM)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(HostEnvInfoVOMeta.PAGE_SIZE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(HostEnvInfoVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(HostEnvInfoVOMeta.SEARCH_VALUE)));
			this.setCiphertextBoxData(DataParser.parse(CiphertextBoxData.class, map.get(HostEnvInfoVOMeta.CIPHERTEXT_BOX_DATA)));
			return true;
		} else {
			try {
				this.setSystemId( (String)map.get(HostEnvInfoVOMeta.SYSTEM_ID));
				this.setNotes( (String)map.get(HostEnvInfoVOMeta.NOTES));
				this.setVoucher( (String)map.get(HostEnvInfoVOMeta.VOUCHER));
				this.setIp( (String)map.get(HostEnvInfoVOMeta.IP));
				this.setUpdateTime( (Date)map.get(HostEnvInfoVOMeta.UPDATE_TIME));
				this.setLabel( (String)map.get(HostEnvInfoVOMeta.LABEL));
				this.setVersion( (Integer)map.get(HostEnvInfoVOMeta.VERSION));
				this.setHostname( (String)map.get(HostEnvInfoVOMeta.HOSTNAME));
				this.setCreateBy( (String)map.get(HostEnvInfoVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(HostEnvInfoVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(HostEnvInfoVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(HostEnvInfoVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(HostEnvInfoVOMeta.DELETE_TIME));
				this.setIpv6( (String)map.get(HostEnvInfoVOMeta.IPV6));
				this.setHostDesc( (String)map.get(HostEnvInfoVOMeta.HOST_DESC));
				this.setDeleteBy( (String)map.get(HostEnvInfoVOMeta.DELETE_BY));
				this.setId( (String)map.get(HostEnvInfoVOMeta.ID));
				this.setVip( (String)map.get(HostEnvInfoVOMeta.VIP));
				// others
				this.setSearchField( (String)map.get(HostEnvInfoVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(HostEnvInfoVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(HostEnvInfoVOMeta.FUZZY_FIELD));
				this.setInfoSystem( (InformationSystem)map.get(HostEnvInfoVOMeta.INFO_SYSTEM));
				this.setPageSize( (Integer)map.get(HostEnvInfoVOMeta.PAGE_SIZE));
				this.setPageIndex( (Integer)map.get(HostEnvInfoVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(HostEnvInfoVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(HostEnvInfoVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(HostEnvInfoVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(HostEnvInfoVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(HostEnvInfoVOMeta.SEARCH_VALUE));
				this.setCiphertextBoxData( (CiphertextBoxData)map.get(HostEnvInfoVOMeta.CIPHERTEXT_BOX_DATA));
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
			this.setSystemId(DataParser.parse(String.class, r.getValue(HostEnvInfoVOMeta.SYSTEM_ID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(HostEnvInfoVOMeta.NOTES)));
			this.setVoucher(DataParser.parse(String.class, r.getValue(HostEnvInfoVOMeta.VOUCHER)));
			this.setIp(DataParser.parse(String.class, r.getValue(HostEnvInfoVOMeta.IP)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(HostEnvInfoVOMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, r.getValue(HostEnvInfoVOMeta.LABEL)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(HostEnvInfoVOMeta.VERSION)));
			this.setHostname(DataParser.parse(String.class, r.getValue(HostEnvInfoVOMeta.HOSTNAME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(HostEnvInfoVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(HostEnvInfoVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(HostEnvInfoVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(HostEnvInfoVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(HostEnvInfoVOMeta.DELETE_TIME)));
			this.setIpv6(DataParser.parse(String.class, r.getValue(HostEnvInfoVOMeta.IPV6)));
			this.setHostDesc(DataParser.parse(String.class, r.getValue(HostEnvInfoVOMeta.HOST_DESC)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(HostEnvInfoVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(HostEnvInfoVOMeta.ID)));
			this.setVip(DataParser.parse(String.class, r.getValue(HostEnvInfoVOMeta.VIP)));
			return true;
		} else {
			try {
				this.setSystemId( (String)r.getValue(HostEnvInfoVOMeta.SYSTEM_ID));
				this.setNotes( (String)r.getValue(HostEnvInfoVOMeta.NOTES));
				this.setVoucher( (String)r.getValue(HostEnvInfoVOMeta.VOUCHER));
				this.setIp( (String)r.getValue(HostEnvInfoVOMeta.IP));
				this.setUpdateTime( (Date)r.getValue(HostEnvInfoVOMeta.UPDATE_TIME));
				this.setLabel( (String)r.getValue(HostEnvInfoVOMeta.LABEL));
				this.setVersion( (Integer)r.getValue(HostEnvInfoVOMeta.VERSION));
				this.setHostname( (String)r.getValue(HostEnvInfoVOMeta.HOSTNAME));
				this.setCreateBy( (String)r.getValue(HostEnvInfoVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(HostEnvInfoVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(HostEnvInfoVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(HostEnvInfoVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(HostEnvInfoVOMeta.DELETE_TIME));
				this.setIpv6( (String)r.getValue(HostEnvInfoVOMeta.IPV6));
				this.setHostDesc( (String)r.getValue(HostEnvInfoVOMeta.HOST_DESC));
				this.setDeleteBy( (String)r.getValue(HostEnvInfoVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(HostEnvInfoVOMeta.ID));
				this.setVip( (String)r.getValue(HostEnvInfoVOMeta.VIP));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}