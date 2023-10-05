package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_MONITOR_TPL_GRAPH;
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
import com.dt.platform.domain.ops.meta.MonitorTplGraphMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 模版图形
 * <p>模版图形 , 数据表 ops_monitor_tpl_graph 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-10-04 09:11:42
 * @sign EF3733ADD8856336630003DE9FBA5FDC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_monitor_tpl_graph")
@ApiModel(description = "模版图形 ; 模版图形 , 数据表 ops_monitor_tpl_graph 的PO类型")
public class MonitorTplGraph extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_MONITOR_TPL_GRAPH.$TABLE;
	
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
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "CPU使用情况")
	private String name;
	
	/**
	 * 模版：模版
	*/
	@ApiModelProperty(required = false,value="模版" , notes = "模版" , example = "tpl_host_linux_script")
	private String tplCode;
	
	/**
	 * 宽度：宽度
	*/
	@ApiModelProperty(required = false,value="宽度" , notes = "宽度" , example = "900")
	private Integer graphWidth;
	
	/**
	 * 高度：高度
	*/
	@ApiModelProperty(required = false,value="高度" , notes = "高度" , example = "200")
	private Integer graphHeight;
	
	/**
	 * 图形类别：图形类别
	*/
	@ApiModelProperty(required = false,value="图形类别" , notes = "图形类别" , example = "line")
	private String graphType;
	
	/**
	 * 图形设置：图形设置
	*/
	@ApiModelProperty(required = false,value="图形设置" , notes = "图形设置")
	private String content;
	
	/**
	 * 数据来源：数据来源
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "数据来源")
	private String ds;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签")
	private String label;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序" , example = "800")
	private Integer sort;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-02-17 03:14:57")
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
	@ApiModelProperty(required = true,value="版本" , notes = "版本" , example = "3")
	private Integer version;
	
	/**
	 * 节点模版：节点模版
	*/
	@ApiModelProperty(required = false,value="节点模版" , notes = "节点模版")
	private MonitorTpl tpl;
	
	/**
	 * 指标：指标
	*/
	@ApiModelProperty(required = false,value="指标" , notes = "指标")
	private List<MonitorTplGraphItem> graphItem;
	
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
	public MonitorTplGraph setId(String id) {
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
	public MonitorTplGraph setStatus(String status) {
		this.status=status;
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
	public MonitorTplGraph setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 模版<br>
	 * 模版
	 * @return 模版
	*/
	public String getTplCode() {
		return tplCode;
	}
	
	/**
	 * 设置 模版
	 * @param tplCode 模版
	 * @return 当前对象
	*/
	public MonitorTplGraph setTplCode(String tplCode) {
		this.tplCode=tplCode;
		return this;
	}
	
	/**
	 * 获得 宽度<br>
	 * 宽度
	 * @return 宽度
	*/
	public Integer getGraphWidth() {
		return graphWidth;
	}
	
	/**
	 * 设置 宽度
	 * @param graphWidth 宽度
	 * @return 当前对象
	*/
	public MonitorTplGraph setGraphWidth(Integer graphWidth) {
		this.graphWidth=graphWidth;
		return this;
	}
	
	/**
	 * 获得 高度<br>
	 * 高度
	 * @return 高度
	*/
	public Integer getGraphHeight() {
		return graphHeight;
	}
	
	/**
	 * 设置 高度
	 * @param graphHeight 高度
	 * @return 当前对象
	*/
	public MonitorTplGraph setGraphHeight(Integer graphHeight) {
		this.graphHeight=graphHeight;
		return this;
	}
	
	/**
	 * 获得 图形类别<br>
	 * 图形类别
	 * @return 图形类别
	*/
	public String getGraphType() {
		return graphType;
	}
	
	/**
	 * 设置 图形类别
	 * @param graphType 图形类别
	 * @return 当前对象
	*/
	public MonitorTplGraph setGraphType(String graphType) {
		this.graphType=graphType;
		return this;
	}
	
	/**
	 * 获得 图形设置<br>
	 * 图形设置
	 * @return 图形设置
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 图形设置
	 * @param content 图形设置
	 * @return 当前对象
	*/
	public MonitorTplGraph setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 数据来源
	 * @return 数据来源
	*/
	public String getDs() {
		return ds;
	}
	
	/**
	 * 设置 数据来源
	 * @param ds 数据来源
	 * @return 当前对象
	*/
	public MonitorTplGraph setDs(String ds) {
		this.ds=ds;
		return this;
	}
	
	/**
	 * 获得 标签<br>
	 * 标签
	 * @return 标签
	*/
	public String getLabel() {
		return label;
	}
	
	/**
	 * 设置 标签
	 * @param label 标签
	 * @return 当前对象
	*/
	public MonitorTplGraph setLabel(String label) {
		this.label=label;
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
	public MonitorTplGraph setSort(Integer sort) {
		this.sort=sort;
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
	public MonitorTplGraph setNotes(String notes) {
		this.notes=notes;
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
	public MonitorTplGraph setCreateBy(String createBy) {
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
	public MonitorTplGraph setCreateTime(Date createTime) {
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
	public MonitorTplGraph setUpdateBy(String updateBy) {
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
	public MonitorTplGraph setUpdateTime(Date updateTime) {
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
	public MonitorTplGraph setDeleted(Integer deleted) {
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
	public MonitorTplGraph setDeleted(Boolean deletedBool) {
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
	public MonitorTplGraph setDeleteBy(String deleteBy) {
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
	public MonitorTplGraph setDeleteTime(Date deleteTime) {
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
	public MonitorTplGraph setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 节点模版<br>
	 * 节点模版
	 * @return 节点模版
	*/
	public MonitorTpl getTpl() {
		return tpl;
	}
	
	/**
	 * 设置 节点模版
	 * @param tpl 节点模版
	 * @return 当前对象
	*/
	public MonitorTplGraph setTpl(MonitorTpl tpl) {
		this.tpl=tpl;
		return this;
	}
	
	/**
	 * 获得 指标<br>
	 * 指标
	 * @return 指标
	*/
	public List<MonitorTplGraphItem> getGraphItem() {
		return graphItem;
	}
	
	/**
	 * 设置 指标
	 * @param graphItem 指标
	 * @return 当前对象
	*/
	public MonitorTplGraph setGraphItem(List<MonitorTplGraphItem> graphItem) {
		this.graphItem=graphItem;
		return this;
	}
	
	/**
	 * 添加 指标
	 * @param entity 指标
	 * @return 当前对象
	*/
	public MonitorTplGraph addGraphItem(MonitorTplGraphItem... entity) {
		if(this.graphItem==null) graphItem=new ArrayList<>();
		this.graphItem.addAll(Arrays.asList(entity));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MonitorTplGraph , 转换好的 MonitorTplGraph 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MonitorTplGraph , 转换好的 PoJo 对象
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
	public MonitorTplGraph clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MonitorTplGraph duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.MonitorTplGraphMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.MonitorTplGraphMeta.$$proxy$$();
		inst.setGraphType(this.getGraphType());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setLabel(this.getLabel());
		inst.setSort(this.getSort());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setDs(this.getDs());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setGraphHeight(this.getGraphHeight());
		inst.setId(this.getId());
		inst.setGraphWidth(this.getGraphWidth());
		inst.setTplCode(this.getTplCode());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setTpl(this.getTpl());
			inst.setGraphItem(this.getGraphItem());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MonitorTplGraph clone(boolean deep) {
		return EntityContext.clone(MonitorTplGraph.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MonitorTplGraph
	 * @param monitorTplGraphMap 包含实体信息的 Map 对象
	 * @return MonitorTplGraph , 转换好的的 MonitorTplGraph 对象
	*/
	@Transient
	public static MonitorTplGraph createFrom(Map<String,Object> monitorTplGraphMap) {
		if(monitorTplGraphMap==null) return null;
		MonitorTplGraph po = create();
		EntityContext.copyProperties(po,monitorTplGraphMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 MonitorTplGraph
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MonitorTplGraph , 转换好的的 MonitorTplGraph 对象
	*/
	@Transient
	public static MonitorTplGraph createFrom(Object pojo) {
		if(pojo==null) return null;
		MonitorTplGraph po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 MonitorTplGraph，等同于 new
	 * @return MonitorTplGraph 对象
	*/
	@Transient
	public static MonitorTplGraph create() {
		return new com.dt.platform.domain.ops.meta.MonitorTplGraphMeta.$$proxy$$();
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
			this.setGraphType(DataParser.parse(String.class, map.get(MonitorTplGraphMeta.GRAPH_TYPE)));
			this.setNotes(DataParser.parse(String.class, map.get(MonitorTplGraphMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MonitorTplGraphMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, map.get(MonitorTplGraphMeta.LABEL)));
			this.setSort(DataParser.parse(Integer.class, map.get(MonitorTplGraphMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MonitorTplGraphMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(MonitorTplGraphMeta.CONTENT)));
			this.setDs(DataParser.parse(String.class, map.get(MonitorTplGraphMeta.DS)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MonitorTplGraphMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MonitorTplGraphMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MonitorTplGraphMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MonitorTplGraphMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MonitorTplGraphMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(MonitorTplGraphMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MonitorTplGraphMeta.DELETE_BY)));
			this.setGraphHeight(DataParser.parse(Integer.class, map.get(MonitorTplGraphMeta.GRAPH_HEIGHT)));
			this.setId(DataParser.parse(String.class, map.get(MonitorTplGraphMeta.ID)));
			this.setGraphWidth(DataParser.parse(Integer.class, map.get(MonitorTplGraphMeta.GRAPH_WIDTH)));
			this.setTplCode(DataParser.parse(String.class, map.get(MonitorTplGraphMeta.TPL_CODE)));
			this.setStatus(DataParser.parse(String.class, map.get(MonitorTplGraphMeta.STATUS)));
			// others
			this.setTpl(DataParser.parse(MonitorTpl.class, map.get(MonitorTplGraphMeta.TPL)));
			return true;
		} else {
			try {
				this.setGraphType( (String)map.get(MonitorTplGraphMeta.GRAPH_TYPE));
				this.setNotes( (String)map.get(MonitorTplGraphMeta.NOTES));
				this.setUpdateTime( (Date)map.get(MonitorTplGraphMeta.UPDATE_TIME));
				this.setLabel( (String)map.get(MonitorTplGraphMeta.LABEL));
				this.setSort( (Integer)map.get(MonitorTplGraphMeta.SORT));
				this.setVersion( (Integer)map.get(MonitorTplGraphMeta.VERSION));
				this.setContent( (String)map.get(MonitorTplGraphMeta.CONTENT));
				this.setDs( (String)map.get(MonitorTplGraphMeta.DS));
				this.setCreateBy( (String)map.get(MonitorTplGraphMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MonitorTplGraphMeta.DELETED));
				this.setCreateTime( (Date)map.get(MonitorTplGraphMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(MonitorTplGraphMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(MonitorTplGraphMeta.DELETE_TIME));
				this.setName( (String)map.get(MonitorTplGraphMeta.NAME));
				this.setDeleteBy( (String)map.get(MonitorTplGraphMeta.DELETE_BY));
				this.setGraphHeight( (Integer)map.get(MonitorTplGraphMeta.GRAPH_HEIGHT));
				this.setId( (String)map.get(MonitorTplGraphMeta.ID));
				this.setGraphWidth( (Integer)map.get(MonitorTplGraphMeta.GRAPH_WIDTH));
				this.setTplCode( (String)map.get(MonitorTplGraphMeta.TPL_CODE));
				this.setStatus( (String)map.get(MonitorTplGraphMeta.STATUS));
				// others
				this.setTpl( (MonitorTpl)map.get(MonitorTplGraphMeta.TPL));
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
			this.setGraphType(DataParser.parse(String.class, r.getValue(MonitorTplGraphMeta.GRAPH_TYPE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(MonitorTplGraphMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MonitorTplGraphMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, r.getValue(MonitorTplGraphMeta.LABEL)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(MonitorTplGraphMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MonitorTplGraphMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(MonitorTplGraphMeta.CONTENT)));
			this.setDs(DataParser.parse(String.class, r.getValue(MonitorTplGraphMeta.DS)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MonitorTplGraphMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MonitorTplGraphMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MonitorTplGraphMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MonitorTplGraphMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MonitorTplGraphMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(MonitorTplGraphMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MonitorTplGraphMeta.DELETE_BY)));
			this.setGraphHeight(DataParser.parse(Integer.class, r.getValue(MonitorTplGraphMeta.GRAPH_HEIGHT)));
			this.setId(DataParser.parse(String.class, r.getValue(MonitorTplGraphMeta.ID)));
			this.setGraphWidth(DataParser.parse(Integer.class, r.getValue(MonitorTplGraphMeta.GRAPH_WIDTH)));
			this.setTplCode(DataParser.parse(String.class, r.getValue(MonitorTplGraphMeta.TPL_CODE)));
			this.setStatus(DataParser.parse(String.class, r.getValue(MonitorTplGraphMeta.STATUS)));
			return true;
		} else {
			try {
				this.setGraphType( (String)r.getValue(MonitorTplGraphMeta.GRAPH_TYPE));
				this.setNotes( (String)r.getValue(MonitorTplGraphMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(MonitorTplGraphMeta.UPDATE_TIME));
				this.setLabel( (String)r.getValue(MonitorTplGraphMeta.LABEL));
				this.setSort( (Integer)r.getValue(MonitorTplGraphMeta.SORT));
				this.setVersion( (Integer)r.getValue(MonitorTplGraphMeta.VERSION));
				this.setContent( (String)r.getValue(MonitorTplGraphMeta.CONTENT));
				this.setDs( (String)r.getValue(MonitorTplGraphMeta.DS));
				this.setCreateBy( (String)r.getValue(MonitorTplGraphMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MonitorTplGraphMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(MonitorTplGraphMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(MonitorTplGraphMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(MonitorTplGraphMeta.DELETE_TIME));
				this.setName( (String)r.getValue(MonitorTplGraphMeta.NAME));
				this.setDeleteBy( (String)r.getValue(MonitorTplGraphMeta.DELETE_BY));
				this.setGraphHeight( (Integer)r.getValue(MonitorTplGraphMeta.GRAPH_HEIGHT));
				this.setId( (String)r.getValue(MonitorTplGraphMeta.ID));
				this.setGraphWidth( (Integer)r.getValue(MonitorTplGraphMeta.GRAPH_WIDTH));
				this.setTplCode( (String)r.getValue(MonitorTplGraphMeta.TPL_CODE));
				this.setStatus( (String)r.getValue(MonitorTplGraphMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}