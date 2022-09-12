package com.dt.platform.domain.ops;

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



/**
 * 主机
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-11 20:19:45
 * @sign 4A61AD62FCD184D8234182AAF95C61FB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class HostVO extends Host {

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
	public HostVO setPageIndex(Integer pageIndex) {
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
	public HostVO setPageSize(Integer pageSize) {
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
	public HostVO setSearchField(String searchField) {
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
	public HostVO setFuzzyField(String fuzzyField) {
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
	public HostVO setSearchValue(String searchValue) {
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
	public HostVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public HostVO addDirtyField(String... dirtyField) {
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
	public HostVO setSortField(String sortField) {
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
	public HostVO setSortType(String sortType) {
		this.sortType=sortType;
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
	public HostVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public HostVO addId(String... id) {
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
	 * @return HostVO , 转换好的 HostVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return HostVO , 转换好的 PoJo 对象
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
	public HostVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public HostVO duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.HostVOMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.HostVOMeta.$$proxy$$();
		inst.setHostName(this.getHostName());
		inst.setUserDbUsed(this.getUserDbUsed());
		inst.setUserDbAdmin(this.getUserDbAdmin());
		inst.setPasswordStrategyId(this.getPasswordStrategyId());
		inst.setDirectorUsername(this.getDirectorUsername());
		inst.setUserOsAdmin(this.getUserOsAdmin());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setHostType(this.getHostType());
		inst.setOnlineTime(this.getOnlineTime());
		inst.setOfflineTime(this.getOfflineTime());
		inst.setId(this.getId());
		inst.setHostCpu(this.getHostCpu());
		inst.setUserAppUsed(this.getUserAppUsed());
		inst.setUserOther(this.getUserOther());
		inst.setHostBackupInfo(this.getHostBackupInfo());
		inst.setSystemId(this.getSystemId());
		inst.setHostConf(this.getHostConf());
		inst.setHostBackupMethod(this.getHostBackupMethod());
		inst.setHostIp(this.getHostIp());
		inst.setHostVip(this.getHostVip());
		inst.setHostMemory(this.getHostMemory());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setLabels(this.getLabels());
		inst.setEnvironment(this.getEnvironment());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPositionId(this.getPositionId());
		inst.setHostNotes(this.getHostNotes());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUserOpsOper(this.getUserOpsOper());
		inst.setArch(this.getArch());
		inst.setMonitorStatus(this.getMonitorStatus());
		inst.setStatus(this.getStatus());
		inst.setHostIpv6(this.getHostIpv6());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setVoucherList(this.getVoucherList());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setHostDbIds(this.getHostDbIds());
			inst.setInfoSystem(this.getInfoSystem());
			inst.setHostOsList(this.getHostOsList());
			inst.setPageSize(this.getPageSize());
			inst.setHostDbList(this.getHostDbList());
			inst.setHostMiddlewareIds(this.getHostMiddlewareIds());
			inst.setHostOsIds(this.getHostOsIds());
			inst.setHostMiddlewareList(this.getHostMiddlewareList());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setIds(this.getIds());
			inst.setPosition(this.getPosition());
			inst.setBackupMethod(this.getBackupMethod());
			inst.setSearchValue(this.getSearchValue());
			inst.setVoucherIds(this.getVoucherIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public HostVO clone(boolean deep) {
		return EntityContext.clone(HostVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 HostVO
	 * @param hostMap 包含实体信息的 Map 对象
	 * @return HostVO , 转换好的的 Host 对象
	*/
	@Transient
	public static HostVO createFrom(Map<String,Object> hostMap) {
		if(hostMap==null) return null;
		HostVO vo = create();
		EntityContext.copyProperties(vo,hostMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 HostVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return HostVO , 转换好的的 Host 对象
	*/
	@Transient
	public static HostVO createFrom(Object pojo) {
		if(pojo==null) return null;
		HostVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 HostVO，等同于 new
	 * @return HostVO 对象
	*/
	@Transient
	public static HostVO create() {
		return new com.dt.platform.domain.ops.meta.HostVOMeta.$$proxy$$();
	}
}