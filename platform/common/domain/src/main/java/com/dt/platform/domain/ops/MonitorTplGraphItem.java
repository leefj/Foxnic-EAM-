package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_MONITOR_TPL_GRAPH_ITEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.MonitorTplGraphItemMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 图形指标
 * <p>图形指标 , 数据表 ops_monitor_tpl_graph_item 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-04 09:22:11
 * @sign 8E110BDD11E3044E08767FEF6A2A1945
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_tpl_graph_item")
@ApiModel(description = "图形指标 ; 图形指标 , 数据表 ops_monitor_tpl_graph_item 的PO类型")
public class MonitorTplGraphItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_TPL_GRAPH_ITEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "1")
	private String id;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 图形：图形
	*/
	@ApiModelProperty(required = false,value="图形" , notes = "图形" , example = "1")
	private String graphId;
	
	/**
	 * 指标：指标
	*/
	@ApiModelProperty(required = false,value="指标" , notes = "指标" , example = "os.cpu")
	private String indicatorCode;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "CPU用户使用率")
	private String name;
	
	/**
	 * 数据：数据
	*/
	@ApiModelProperty(required = false,value="数据" , notes = "数据" , example = "cpu_user")
	private String route;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
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
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本" , example = "1")
	private Integer version;
	
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
	public MonitorTplGraphItem setId(String id) {
		this.id=id;
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
	public MonitorTplGraphItem setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 图形<br>
	 * 图形
	 * @return 图形
	*/
	public String getGraphId() {
		return graphId;
	}
	
	/**
	 * 设置 图形
	 * @param graphId 图形
	 * @return 当前对象
	*/
	public MonitorTplGraphItem setGraphId(String graphId) {
		this.graphId=graphId;
		return this;
	}
	
	/**
	 * 获得 指标<br>
	 * 指标
	 * @return 指标
	*/
	public String getIndicatorCode() {
		return indicatorCode;
	}
	
	/**
	 * 设置 指标
	 * @param indicatorCode 指标
	 * @return 当前对象
	*/
	public MonitorTplGraphItem setIndicatorCode(String indicatorCode) {
		this.indicatorCode=indicatorCode;
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
	public MonitorTplGraphItem setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 数据<br>
	 * 数据
	 * @return 数据
	*/
	public String getRoute() {
		return route;
	}
	
	/**
	 * 设置 数据
	 * @param route 数据
	 * @return 当前对象
	*/
	public MonitorTplGraphItem setRoute(String route) {
		this.route=route;
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
	public MonitorTplGraphItem setCreateBy(String createBy) {
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
	public MonitorTplGraphItem setCreateTime(Date createTime) {
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
	public MonitorTplGraphItem setUpdateBy(String updateBy) {
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
	public MonitorTplGraphItem setUpdateTime(Date updateTime) {
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
	public MonitorTplGraphItem setDeleted(Integer deleted) {
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
	public MonitorTplGraphItem setDeleted(Boolean deletedBool) {
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
	public MonitorTplGraphItem setDeleteBy(String deleteBy) {
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
	public MonitorTplGraphItem setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 版本
	 * @param version 版本
	 * @return 当前对象
	*/
	public MonitorTplGraphItem setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorTplGraphItem , 转换好的 MonitorTplGraphItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorTplGraphItem , 转换好的 PoJo 对象
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
	public MonitorTplGraphItem clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MonitorTplGraphItem duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.MonitorTplGraphItemMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.MonitorTplGraphItemMeta.$$proxy$$();
		inst.setIndicatorCode(this.getIndicatorCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setRoute(this.getRoute());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setGraphId(this.getGraphId());
		inst.setStatus(this.getStatus());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MonitorTplGraphItem clone(boolean deep) {
		return EntityContext.clone(MonitorTplGraphItem.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MonitorTplGraphItem
	 * @param monitorTplGraphItemMap 包含实体信息的 Map 对象
	 * @return MonitorTplGraphItem , 转换好的的 MonitorTplGraphItem 对象
	*/
	@Transient
	public static MonitorTplGraphItem createFrom(Map<String,Object> monitorTplGraphItemMap) {
		if(monitorTplGraphItemMap==null) return null;
		MonitorTplGraphItem po = create();
		EntityContext.copyProperties(po,monitorTplGraphItemMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorTplGraphItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorTplGraphItem , 转换好的的 MonitorTplGraphItem 对象
	*/
	@Transient
	public static MonitorTplGraphItem createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorTplGraphItem po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 MonitorTplGraphItem，等同于 new
	 * @return MonitorTplGraphItem 对象
	*/
	@Transient
	public static MonitorTplGraphItem create() {
		return new com.dt.platform.domain.ops.meta.MonitorTplGraphItemMeta.$$proxy$$();
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
			this.setIndicatorCode(DataParser.parse(String.class, map.get(MonitorTplGraphItemMeta.INDICATOR_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MonitorTplGraphItemMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MonitorTplGraphItemMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MonitorTplGraphItemMeta.CREATE_BY)));
			this.setRoute(DataParser.parse(String.class, map.get(MonitorTplGraphItemMeta.ROUTE)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MonitorTplGraphItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MonitorTplGraphItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MonitorTplGraphItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MonitorTplGraphItemMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(MonitorTplGraphItemMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MonitorTplGraphItemMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(MonitorTplGraphItemMeta.ID)));
			this.setGraphId(DataParser.parse(String.class, map.get(MonitorTplGraphItemMeta.GRAPH_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(MonitorTplGraphItemMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setIndicatorCode( (String)map.get(MonitorTplGraphItemMeta.INDICATOR_CODE));
				this.setUpdateTime( (Date)map.get(MonitorTplGraphItemMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(MonitorTplGraphItemMeta.VERSION));
				this.setCreateBy( (String)map.get(MonitorTplGraphItemMeta.CREATE_BY));
				this.setRoute( (String)map.get(MonitorTplGraphItemMeta.ROUTE));
				this.setDeleted( (Integer)map.get(MonitorTplGraphItemMeta.DELETED));
				this.setCreateTime( (Date)map.get(MonitorTplGraphItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(MonitorTplGraphItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(MonitorTplGraphItemMeta.DELETE_TIME));
				this.setName( (String)map.get(MonitorTplGraphItemMeta.NAME));
				this.setDeleteBy( (String)map.get(MonitorTplGraphItemMeta.DELETE_BY));
				this.setId( (String)map.get(MonitorTplGraphItemMeta.ID));
				this.setGraphId( (String)map.get(MonitorTplGraphItemMeta.GRAPH_ID));
				this.setStatus( (String)map.get(MonitorTplGraphItemMeta.STATUS));
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
			this.setIndicatorCode(DataParser.parse(String.class, r.getValue(MonitorTplGraphItemMeta.INDICATOR_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MonitorTplGraphItemMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MonitorTplGraphItemMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MonitorTplGraphItemMeta.CREATE_BY)));
			this.setRoute(DataParser.parse(String.class, r.getValue(MonitorTplGraphItemMeta.ROUTE)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MonitorTplGraphItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MonitorTplGraphItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MonitorTplGraphItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MonitorTplGraphItemMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(MonitorTplGraphItemMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MonitorTplGraphItemMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(MonitorTplGraphItemMeta.ID)));
			this.setGraphId(DataParser.parse(String.class, r.getValue(MonitorTplGraphItemMeta.GRAPH_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(MonitorTplGraphItemMeta.STATUS)));
			return true;
		} else {
			try {
				this.setIndicatorCode( (String)r.getValue(MonitorTplGraphItemMeta.INDICATOR_CODE));
				this.setUpdateTime( (Date)r.getValue(MonitorTplGraphItemMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(MonitorTplGraphItemMeta.VERSION));
				this.setCreateBy( (String)r.getValue(MonitorTplGraphItemMeta.CREATE_BY));
				this.setRoute( (String)r.getValue(MonitorTplGraphItemMeta.ROUTE));
				this.setDeleted( (Integer)r.getValue(MonitorTplGraphItemMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(MonitorTplGraphItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(MonitorTplGraphItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(MonitorTplGraphItemMeta.DELETE_TIME));
				this.setName( (String)r.getValue(MonitorTplGraphItemMeta.NAME));
				this.setDeleteBy( (String)r.getValue(MonitorTplGraphItemMeta.DELETE_BY));
				this.setId( (String)r.getValue(MonitorTplGraphItemMeta.ID));
				this.setGraphId( (String)r.getValue(MonitorTplGraphItemMeta.GRAPH_ID));
				this.setStatus( (String)r.getValue(MonitorTplGraphItemMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}