package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_DASHBOARD_LAYER_ELE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.DashboardLayerEleMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 组件
 * <p>组件 , 数据表 sys_dashboard_layer_ele 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-24 07:43:40
 * @sign 66234C043AD96CD5879AEB9B7D28D717
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_dashboard_layer_ele")
@ApiModel(description = "组件 ; 组件 , 数据表 sys_dashboard_layer_ele 的PO类型")
public class DashboardLayerEle extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_DASHBOARD_LAYER_ELE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "768757500123021312")
	private String id;
	
	/**
	 * 面板：面板
	*/
	@ApiModelProperty(required = false,value="面板" , notes = "面板" , example = "768750314323968000")
	private String layerId;
	
	/**
	 * 面板分层：面板分层
	*/
	@ApiModelProperty(required = false,value="面板分层" , notes = "面板分层" , example = "768578249050554368")
	private String dashboardId;
	
	/**
	 * 标题：标题
	*/
	@ApiModelProperty(required = false,value="标题" , notes = "标题" , example = "资产总数")
	private String title;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型" , example = "card")
	private String type;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "来源" , example = "768760001861779457")
	private String source;
	
	/**
	 * 配置：配置
	*/
	@ApiModelProperty(required = false,value="配置" , notes = "配置" , example = "{ }")
	private String json;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-10-23 08:47:51")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-10-23 04:34:05")
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
	@ApiModelProperty(required = false,value="version" , notes = "version" , example = "8")
	private Integer version;
	
	/**
	 * dashboardLayer：dashboardLayer
	*/
	@ApiModelProperty(required = false,value="dashboardLayer" , notes = "dashboardLayer")
	private DashboardLayer dashboardLayer;
	
	/**
	 * reportChart：reportChart
	*/
	@ApiModelProperty(required = false,value="reportChart" , notes = "reportChart")
	private Report reportChart;
	
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
	public DashboardLayerEle setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 面板<br>
	 * 面板
	 * @return 面板
	*/
	public String getLayerId() {
		return layerId;
	}
	
	/**
	 * 设置 面板
	 * @param layerId 面板
	 * @return 当前对象
	*/
	public DashboardLayerEle setLayerId(String layerId) {
		this.layerId=layerId;
		return this;
	}
	
	/**
	 * 获得 面板分层<br>
	 * 面板分层
	 * @return 面板分层
	*/
	public String getDashboardId() {
		return dashboardId;
	}
	
	/**
	 * 设置 面板分层
	 * @param dashboardId 面板分层
	 * @return 当前对象
	*/
	public DashboardLayerEle setDashboardId(String dashboardId) {
		this.dashboardId=dashboardId;
		return this;
	}
	
	/**
	 * 获得 标题<br>
	 * 标题
	 * @return 标题
	*/
	public String getTitle() {
		return title;
	}
	
	/**
	 * 设置 标题
	 * @param title 标题
	 * @return 当前对象
	*/
	public DashboardLayerEle setTitle(String title) {
		this.title=title;
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
	public DashboardLayerEle setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public DashboardLayerEle setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 来源<br>
	 * 来源
	 * @return 来源
	*/
	public String getSource() {
		return source;
	}
	
	/**
	 * 设置 来源
	 * @param source 来源
	 * @return 当前对象
	*/
	public DashboardLayerEle setSource(String source) {
		this.source=source;
		return this;
	}
	
	/**
	 * 获得 配置<br>
	 * 配置
	 * @return 配置
	*/
	public String getJson() {
		return json;
	}
	
	/**
	 * 设置 配置
	 * @param json 配置
	 * @return 当前对象
	*/
	public DashboardLayerEle setJson(String json) {
		this.json=json;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public DashboardLayerEle setNotes(String notes) {
		this.notes=notes;
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
	public DashboardLayerEle setSort(Integer sort) {
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
	public DashboardLayerEle setCreateBy(String createBy) {
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
	public DashboardLayerEle setCreateTime(Date createTime) {
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
	public DashboardLayerEle setUpdateBy(String updateBy) {
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
	public DashboardLayerEle setUpdateTime(Date updateTime) {
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
	public DashboardLayerEle setDeleted(Integer deleted) {
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
	public DashboardLayerEle setDeleted(Boolean deletedBool) {
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
	public DashboardLayerEle setDeleteBy(String deleteBy) {
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
	public DashboardLayerEle setDeleteTime(Date deleteTime) {
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
	public DashboardLayerEle setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 dashboardLayer<br>
	 * dashboardLayer
	 * @return dashboardLayer
	*/
	public DashboardLayer getDashboardLayer() {
		return dashboardLayer;
	}
	
	/**
	 * 设置 dashboardLayer
	 * @param dashboardLayer dashboardLayer
	 * @return 当前对象
	*/
	public DashboardLayerEle setDashboardLayer(DashboardLayer dashboardLayer) {
		this.dashboardLayer=dashboardLayer;
		return this;
	}
	
	/**
	 * 获得 reportChart<br>
	 * reportChart
	 * @return reportChart
	*/
	public Report getReportChart() {
		return reportChart;
	}
	
	/**
	 * 设置 reportChart
	 * @param reportChart reportChart
	 * @return 当前对象
	*/
	public DashboardLayerEle setReportChart(Report reportChart) {
		this.reportChart=reportChart;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DashboardLayerEle , 转换好的 DashboardLayerEle 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DashboardLayerEle , 转换好的 PoJo 对象
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
	public DashboardLayerEle clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DashboardLayerEle duplicate(boolean all) {
		com.dt.platform.domain.common.meta.DashboardLayerEleMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.DashboardLayerEleMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSource(this.getSource());
		inst.setSort(this.getSort());
		inst.setTitle(this.getTitle());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setLayerId(this.getLayerId());
		inst.setDeleted(this.getDeleted());
		inst.setDashboardId(this.getDashboardId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setJson(this.getJson());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setReportChart(this.getReportChart());
			inst.setDashboardLayer(this.getDashboardLayer());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DashboardLayerEle clone(boolean deep) {
		return EntityContext.clone(DashboardLayerEle.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DashboardLayerEle
	 * @param dashboardLayerEleMap 包含实体信息的 Map 对象
	 * @return DashboardLayerEle , 转换好的的 DashboardLayerEle 对象
	*/
	@Transient
	public static DashboardLayerEle createFrom(Map<String,Object> dashboardLayerEleMap) {
		if(dashboardLayerEleMap==null) return null;
		DashboardLayerEle po = create();
		EntityContext.copyProperties(po,dashboardLayerEleMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DashboardLayerEle
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DashboardLayerEle , 转换好的的 DashboardLayerEle 对象
	*/
	@Transient
	public static DashboardLayerEle createFrom(Object pojo) {
		if(pojo==null) return null;
		DashboardLayerEle po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DashboardLayerEle，等同于 new
	 * @return DashboardLayerEle 对象
	*/
	@Transient
	public static DashboardLayerEle create() {
		return new com.dt.platform.domain.common.meta.DashboardLayerEleMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(DashboardLayerEleMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DashboardLayerEleMeta.UPDATE_TIME)));
			this.setSource(DataParser.parse(String.class, map.get(DashboardLayerEleMeta.SOURCE)));
			this.setSort(DataParser.parse(Integer.class, map.get(DashboardLayerEleMeta.SORT)));
			this.setTitle(DataParser.parse(String.class, map.get(DashboardLayerEleMeta.TITLE)));
			this.setType(DataParser.parse(String.class, map.get(DashboardLayerEleMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DashboardLayerEleMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DashboardLayerEleMeta.CREATE_BY)));
			this.setLayerId(DataParser.parse(String.class, map.get(DashboardLayerEleMeta.LAYER_ID)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DashboardLayerEleMeta.DELETED)));
			this.setDashboardId(DataParser.parse(String.class, map.get(DashboardLayerEleMeta.DASHBOARD_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DashboardLayerEleMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DashboardLayerEleMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DashboardLayerEleMeta.DELETE_TIME)));
			this.setJson(DataParser.parse(String.class, map.get(DashboardLayerEleMeta.JSON)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DashboardLayerEleMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(DashboardLayerEleMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(DashboardLayerEleMeta.STATUS)));
			// others
			this.setReportChart(DataParser.parse(Report.class, map.get(DashboardLayerEleMeta.REPORT_CHART)));
			this.setDashboardLayer(DataParser.parse(DashboardLayer.class, map.get(DashboardLayerEleMeta.DASHBOARD_LAYER)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(DashboardLayerEleMeta.NOTES));
				this.setUpdateTime( (Date)map.get(DashboardLayerEleMeta.UPDATE_TIME));
				this.setSource( (String)map.get(DashboardLayerEleMeta.SOURCE));
				this.setSort( (Integer)map.get(DashboardLayerEleMeta.SORT));
				this.setTitle( (String)map.get(DashboardLayerEleMeta.TITLE));
				this.setType( (String)map.get(DashboardLayerEleMeta.TYPE));
				this.setVersion( (Integer)map.get(DashboardLayerEleMeta.VERSION));
				this.setCreateBy( (String)map.get(DashboardLayerEleMeta.CREATE_BY));
				this.setLayerId( (String)map.get(DashboardLayerEleMeta.LAYER_ID));
				this.setDeleted( (Integer)map.get(DashboardLayerEleMeta.DELETED));
				this.setDashboardId( (String)map.get(DashboardLayerEleMeta.DASHBOARD_ID));
				this.setCreateTime( (Date)map.get(DashboardLayerEleMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(DashboardLayerEleMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DashboardLayerEleMeta.DELETE_TIME));
				this.setJson( (String)map.get(DashboardLayerEleMeta.JSON));
				this.setDeleteBy( (String)map.get(DashboardLayerEleMeta.DELETE_BY));
				this.setId( (String)map.get(DashboardLayerEleMeta.ID));
				this.setStatus( (String)map.get(DashboardLayerEleMeta.STATUS));
				// others
				this.setReportChart( (Report)map.get(DashboardLayerEleMeta.REPORT_CHART));
				this.setDashboardLayer( (DashboardLayer)map.get(DashboardLayerEleMeta.DASHBOARD_LAYER));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(DashboardLayerEleMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DashboardLayerEleMeta.UPDATE_TIME)));
			this.setSource(DataParser.parse(String.class, r.getValue(DashboardLayerEleMeta.SOURCE)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(DashboardLayerEleMeta.SORT)));
			this.setTitle(DataParser.parse(String.class, r.getValue(DashboardLayerEleMeta.TITLE)));
			this.setType(DataParser.parse(String.class, r.getValue(DashboardLayerEleMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DashboardLayerEleMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DashboardLayerEleMeta.CREATE_BY)));
			this.setLayerId(DataParser.parse(String.class, r.getValue(DashboardLayerEleMeta.LAYER_ID)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DashboardLayerEleMeta.DELETED)));
			this.setDashboardId(DataParser.parse(String.class, r.getValue(DashboardLayerEleMeta.DASHBOARD_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DashboardLayerEleMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DashboardLayerEleMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DashboardLayerEleMeta.DELETE_TIME)));
			this.setJson(DataParser.parse(String.class, r.getValue(DashboardLayerEleMeta.JSON)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DashboardLayerEleMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(DashboardLayerEleMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(DashboardLayerEleMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(DashboardLayerEleMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(DashboardLayerEleMeta.UPDATE_TIME));
				this.setSource( (String)r.getValue(DashboardLayerEleMeta.SOURCE));
				this.setSort( (Integer)r.getValue(DashboardLayerEleMeta.SORT));
				this.setTitle( (String)r.getValue(DashboardLayerEleMeta.TITLE));
				this.setType( (String)r.getValue(DashboardLayerEleMeta.TYPE));
				this.setVersion( (Integer)r.getValue(DashboardLayerEleMeta.VERSION));
				this.setCreateBy( (String)r.getValue(DashboardLayerEleMeta.CREATE_BY));
				this.setLayerId( (String)r.getValue(DashboardLayerEleMeta.LAYER_ID));
				this.setDeleted( (Integer)r.getValue(DashboardLayerEleMeta.DELETED));
				this.setDashboardId( (String)r.getValue(DashboardLayerEleMeta.DASHBOARD_ID));
				this.setCreateTime( (Date)r.getValue(DashboardLayerEleMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(DashboardLayerEleMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DashboardLayerEleMeta.DELETE_TIME));
				this.setJson( (String)r.getValue(DashboardLayerEleMeta.JSON));
				this.setDeleteBy( (String)r.getValue(DashboardLayerEleMeta.DELETE_BY));
				this.setId( (String)r.getValue(DashboardLayerEleMeta.ID));
				this.setStatus( (String)r.getValue(DashboardLayerEleMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}