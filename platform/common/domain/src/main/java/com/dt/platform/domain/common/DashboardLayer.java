package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_DASHBOARD_LAYER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.DashboardLayerMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 面板层
 * <p>面板层 , 数据表 sys_dashboard_layer 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-23 15:37:14
 * @sign 768FF799094050F3D03BC84D908D61CA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_dashboard_layer")
@ApiModel(description = "面板层 ; 面板层 , 数据表 sys_dashboard_layer 的PO类型")
public class DashboardLayer extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_DASHBOARD_LAYER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "768750314323968000")
	private String id;
	
	/**
	 * 面板：面板
	*/
	@ApiModelProperty(required = false,value="面板" , notes = "面板" , example = "768578249050554368")
	private String dashboardId;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "列6")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 列数：列数
	*/
	@ApiModelProperty(required = false,value="列数" , notes = "列数" , example = "six")
	private String colType;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序" , example = "0")
	private Integer sort;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-10-23 08:19:18")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-10-23 08:35:39")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = false,value="version" , notes = "version" , example = "2")
	private Integer version;
	
	/**
	 * dashboardLayerEle：dashboardLayerEle
	*/
	@ApiModelProperty(required = false,value="dashboardLayerEle" , notes = "dashboardLayerEle")
	private List<DashboardLayer> dashboardLayerEle;
	
	/**
	 * dashboardLayerEleValid：dashboardLayerEleValid
	*/
	@ApiModelProperty(required = false,value="dashboardLayerEleValid" , notes = "dashboardLayerEleValid")
	private List<DashboardLayerEle> dashboardLayerEleValid;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public DashboardLayer setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 面板<br>
	 * 面板
	 * @return 面板
	*/
	public String getDashboardId() {
		return dashboardId;
	}
	
	/**
	 * 设置 面板
	 * @param dashboardId 面板
	 * @return 当前对象
	*/
	public DashboardLayer setDashboardId(String dashboardId) {
		this.dashboardId=dashboardId;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public DashboardLayer setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public DashboardLayer setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 列数<br>
	 * 列数
	 * @return 列数
	*/
	public String getColType() {
		return colType;
	}
	
	/**
	 * 设置 列数
	 * @param colType 列数
	 * @return 当前对象
	*/
	public DashboardLayer setColType(String colType) {
		this.colType=colType;
		return this;
	}
	
	/**
	 * 获得 排序<br>
	 * 排序
	 * @return 排序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 排序
	 * @param sort 排序
	 * @return 当前对象
	*/
	public DashboardLayer setSort(Integer sort) {
		this.sort=sort;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public DashboardLayer setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public DashboardLayer setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public DashboardLayer setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public DashboardLayer setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	@JsonProperty("deleted")
	public DashboardLayer setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public DashboardLayer setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public DashboardLayer setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public DashboardLayer setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public DashboardLayer setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 dashboardLayerEle<br>
	 * dashboardLayerEle
	 * @return dashboardLayerEle
	*/
	public List<DashboardLayer> getDashboardLayerEle() {
		return dashboardLayerEle;
	}
	
	/**
	 * 设置 dashboardLayerEle
	 * @param dashboardLayerEle dashboardLayerEle
	 * @return 当前对象
	*/
	public DashboardLayer setDashboardLayerEle(List<DashboardLayer> dashboardLayerEle) {
		this.dashboardLayerEle=dashboardLayerEle;
		return this;
	}
	
	/**
	 * 添加 dashboardLayerEle
	 * @param entity dashboardLayerEle
	 * @return 当前对象
	*/
	public DashboardLayer addDashboardLayerEle(DashboardLayer... entity) {
		if(this.dashboardLayerEle==null) dashboardLayerEle=new ArrayList<>();
		this.dashboardLayerEle.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 dashboardLayerEleValid<br>
	 * dashboardLayerEleValid
	 * @return dashboardLayerEleValid
	*/
	public List<DashboardLayerEle> getDashboardLayerEleValid() {
		return dashboardLayerEleValid;
	}
	
	/**
	 * 设置 dashboardLayerEleValid
	 * @param dashboardLayerEleValid dashboardLayerEleValid
	 * @return 当前对象
	*/
	public DashboardLayer setDashboardLayerEleValid(List<DashboardLayerEle> dashboardLayerEleValid) {
		this.dashboardLayerEleValid=dashboardLayerEleValid;
		return this;
	}
	
	/**
	 * 添加 dashboardLayerEleValid
	 * @param entity dashboardLayerEleValid
	 * @return 当前对象
	*/
	public DashboardLayer addDashboardLayerEleValid(DashboardLayerEle... entity) {
		if(this.dashboardLayerEleValid==null) dashboardLayerEleValid=new ArrayList<>();
		this.dashboardLayerEleValid.addAll(Arrays.asList(entity));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DashboardLayer , 转换好的 DashboardLayer 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DashboardLayer , 转换好的 PoJo 对象
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
	public DashboardLayer clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DashboardLayer duplicate(boolean all) {
		com.dt.platform.domain.common.meta.DashboardLayerMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.DashboardLayerMeta.$$proxy$$();
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setDashboardId(this.getDashboardId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setColType(this.getColType());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setDashboardLayerEle(this.getDashboardLayerEle());
			inst.setDashboardLayerEleValid(this.getDashboardLayerEleValid());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DashboardLayer clone(boolean deep) {
		return EntityContext.clone(DashboardLayer.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DashboardLayer
	 * @param dashboardLayerMap 包含实体信息的 Map 对象
	 * @return DashboardLayer , 转换好的的 DashboardLayer 对象
	*/
	@Transient
	public static DashboardLayer createFrom(Map<String,Object> dashboardLayerMap) {
		if(dashboardLayerMap==null) return null;
		DashboardLayer po = create();
		EntityContext.copyProperties(po,dashboardLayerMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DashboardLayer
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DashboardLayer , 转换好的的 DashboardLayer 对象
	*/
	@Transient
	public static DashboardLayer createFrom(Object pojo) {
		if(pojo==null) return null;
		DashboardLayer po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DashboardLayer，等同于 new
	 * @return DashboardLayer 对象
	*/
	@Transient
	public static DashboardLayer create() {
		return new com.dt.platform.domain.common.meta.DashboardLayerMeta.$$proxy$$();
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
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DashboardLayerMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(DashboardLayerMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DashboardLayerMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DashboardLayerMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DashboardLayerMeta.DELETED)));
			this.setDashboardId(DataParser.parse(String.class, map.get(DashboardLayerMeta.DASHBOARD_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DashboardLayerMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DashboardLayerMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DashboardLayerMeta.DELETE_TIME)));
			this.setColType(DataParser.parse(String.class, map.get(DashboardLayerMeta.COL_TYPE)));
			this.setName(DataParser.parse(String.class, map.get(DashboardLayerMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DashboardLayerMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(DashboardLayerMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(DashboardLayerMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)map.get(DashboardLayerMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(DashboardLayerMeta.SORT));
				this.setVersion( (Integer)map.get(DashboardLayerMeta.VERSION));
				this.setCreateBy( (String)map.get(DashboardLayerMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DashboardLayerMeta.DELETED));
				this.setDashboardId( (String)map.get(DashboardLayerMeta.DASHBOARD_ID));
				this.setCreateTime( (Date)map.get(DashboardLayerMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(DashboardLayerMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DashboardLayerMeta.DELETE_TIME));
				this.setColType( (String)map.get(DashboardLayerMeta.COL_TYPE));
				this.setName( (String)map.get(DashboardLayerMeta.NAME));
				this.setDeleteBy( (String)map.get(DashboardLayerMeta.DELETE_BY));
				this.setId( (String)map.get(DashboardLayerMeta.ID));
				this.setStatus( (String)map.get(DashboardLayerMeta.STATUS));
				// others
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
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DashboardLayerMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(DashboardLayerMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DashboardLayerMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DashboardLayerMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DashboardLayerMeta.DELETED)));
			this.setDashboardId(DataParser.parse(String.class, r.getValue(DashboardLayerMeta.DASHBOARD_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DashboardLayerMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DashboardLayerMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DashboardLayerMeta.DELETE_TIME)));
			this.setColType(DataParser.parse(String.class, r.getValue(DashboardLayerMeta.COL_TYPE)));
			this.setName(DataParser.parse(String.class, r.getValue(DashboardLayerMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DashboardLayerMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(DashboardLayerMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(DashboardLayerMeta.STATUS)));
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)r.getValue(DashboardLayerMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(DashboardLayerMeta.SORT));
				this.setVersion( (Integer)r.getValue(DashboardLayerMeta.VERSION));
				this.setCreateBy( (String)r.getValue(DashboardLayerMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DashboardLayerMeta.DELETED));
				this.setDashboardId( (String)r.getValue(DashboardLayerMeta.DASHBOARD_ID));
				this.setCreateTime( (Date)r.getValue(DashboardLayerMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(DashboardLayerMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DashboardLayerMeta.DELETE_TIME));
				this.setColType( (String)r.getValue(DashboardLayerMeta.COL_TYPE));
				this.setName( (String)r.getValue(DashboardLayerMeta.NAME));
				this.setDeleteBy( (String)r.getValue(DashboardLayerMeta.DELETE_BY));
				this.setId( (String)r.getValue(DashboardLayerMeta.ID));
				this.setStatus( (String)r.getValue(DashboardLayerMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}