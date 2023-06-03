package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_REPORT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.ReportMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 报表列
 * <p>报表列 , 数据表 sys_report 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 06:55:25
 * @sign 1FA3507F7CDFB8AA4AF8CBAACD1997A8
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_report")
@ApiModel(description = "报表列 ; 报表列 , 数据表 sys_report 的PO类型")
public class Report extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_REPORT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "711914370904358912")
	private String id;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码" , example = "711935534460567552")
	private String code;
	
	/**
	 * 分类：分类
	*/
	@ApiModelProperty(required = false,value="分类" , notes = "分类" , example = "711932989134602240")
	private String catalogId;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "资产显示")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 路径：路径
	*/
	@ApiModelProperty(required = false,value="路径" , notes = "路径" , example = "/ureport/preview?_u=db:712240054507929600.ureport.xml")
	private String route;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "测试")
	private String notes;
	
	/**
	 * 模版：模版
	*/
	@ApiModelProperty(required = false,value="模版" , notes = "模版" , example = "712399636991574016")
	private String reportTplId;
	
	/**
	 * 报表设计：报表设计
	*/
	@ApiModelProperty(required = false,value="报表设计" , notes = "报表设计" , example = "712240054507929600")
	private String reportTplDefId;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "来源" , example = "ureport")
	private String reportSource;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-05-19 12:13:33")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-05-20 09:30:24")
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
	@ApiModelProperty(required = false,value="version" , notes = "version" , example = "11")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * reportCategory：reportCategory
	*/
	@ApiModelProperty(required = false,value="reportCategory" , notes = "reportCategory")
	private ReportCategory reportCategory;
	
	/**
	 * reportTpl：reportTpl
	*/
	@ApiModelProperty(required = false,value="reportTpl" , notes = "reportTpl")
	private ReportUDef reportTpl;
	
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
	public Report setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编码
	 * @param code 编码
	 * @return 当前对象
	*/
	public Report setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 分类<br>
	 * 分类
	 * @return 分类
	*/
	public String getCatalogId() {
		return catalogId;
	}
	
	/**
	 * 设置 分类
	 * @param catalogId 分类
	 * @return 当前对象
	*/
	public Report setCatalogId(String catalogId) {
		this.catalogId=catalogId;
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
	public Report setName(String name) {
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
	public Report setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 路径<br>
	 * 路径
	 * @return 路径
	*/
	public String getRoute() {
		return route;
	}
	
	/**
	 * 设置 路径
	 * @param route 路径
	 * @return 当前对象
	*/
	public Report setRoute(String route) {
		this.route=route;
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
	public Report setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 模版<br>
	 * 模版
	 * @return 模版
	*/
	public String getReportTplId() {
		return reportTplId;
	}
	
	/**
	 * 设置 模版
	 * @param reportTplId 模版
	 * @return 当前对象
	*/
	public Report setReportTplId(String reportTplId) {
		this.reportTplId=reportTplId;
		return this;
	}
	
	/**
	 * 获得 报表设计<br>
	 * 报表设计
	 * @return 报表设计
	*/
	public String getReportTplDefId() {
		return reportTplDefId;
	}
	
	/**
	 * 设置 报表设计
	 * @param reportTplDefId 报表设计
	 * @return 当前对象
	*/
	public Report setReportTplDefId(String reportTplDefId) {
		this.reportTplDefId=reportTplDefId;
		return this;
	}
	
	/**
	 * 获得 来源<br>
	 * 来源
	 * @return 来源
	*/
	public String getReportSource() {
		return reportSource;
	}
	
	/**
	 * 设置 来源
	 * @param reportSource 来源
	 * @return 当前对象
	*/
	public Report setReportSource(String reportSource) {
		this.reportSource=reportSource;
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
	public Report setCreateBy(String createBy) {
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
	public Report setCreateTime(Date createTime) {
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
	public Report setUpdateBy(String updateBy) {
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
	public Report setUpdateTime(Date updateTime) {
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
	public Report setDeleted(Integer deleted) {
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
	public Report setDeleted(Boolean deletedBool) {
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
	public Report setDeleteBy(String deleteBy) {
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
	public Report setDeleteTime(Date deleteTime) {
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
	public Report setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 租户<br>
	 * 租户
	 * @return 租户
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户
	 * @param tenantId 租户
	 * @return 当前对象
	*/
	public Report setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 reportCategory<br>
	 * reportCategory
	 * @return reportCategory
	*/
	public ReportCategory getReportCategory() {
		return reportCategory;
	}
	
	/**
	 * 设置 reportCategory
	 * @param reportCategory reportCategory
	 * @return 当前对象
	*/
	public Report setReportCategory(ReportCategory reportCategory) {
		this.reportCategory=reportCategory;
		return this;
	}
	
	/**
	 * 获得 reportTpl<br>
	 * reportTpl
	 * @return reportTpl
	*/
	public ReportUDef getReportTpl() {
		return reportTpl;
	}
	
	/**
	 * 设置 reportTpl
	 * @param reportTpl reportTpl
	 * @return 当前对象
	*/
	public Report setReportTpl(ReportUDef reportTpl) {
		this.reportTpl=reportTpl;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Report , 转换好的 Report 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Report , 转换好的 PoJo 对象
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
	public Report clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Report duplicate(boolean all) {
		com.dt.platform.domain.common.meta.ReportMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.ReportMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setReportTplId(this.getReportTplId());
		inst.setReportTplDefId(this.getReportTplDefId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setCatalogId(this.getCatalogId());
		inst.setRoute(this.getRoute());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setReportSource(this.getReportSource());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setReportCategory(this.getReportCategory());
			inst.setReportTpl(this.getReportTpl());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Report clone(boolean deep) {
		return EntityContext.clone(Report.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Report
	 * @param reportMap 包含实体信息的 Map 对象
	 * @return Report , 转换好的的 Report 对象
	*/
	@Transient
	public static Report createFrom(Map<String,Object> reportMap) {
		if(reportMap==null) return null;
		Report po = create();
		EntityContext.copyProperties(po,reportMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Report
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Report , 转换好的的 Report 对象
	*/
	@Transient
	public static Report createFrom(Object pojo) {
		if(pojo==null) return null;
		Report po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Report，等同于 new
	 * @return Report 对象
	*/
	@Transient
	public static Report create() {
		return new com.dt.platform.domain.common.meta.ReportMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(ReportMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(ReportMeta.NOTES)));
			this.setReportTplId(DataParser.parse(String.class, map.get(ReportMeta.REPORT_TPL_ID)));
			this.setReportTplDefId(DataParser.parse(String.class, map.get(ReportMeta.REPORT_TPL_DEF_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ReportMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ReportMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ReportMeta.CREATE_BY)));
			this.setCatalogId(DataParser.parse(String.class, map.get(ReportMeta.CATALOG_ID)));
			this.setRoute(DataParser.parse(String.class, map.get(ReportMeta.ROUTE)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ReportMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ReportMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ReportMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ReportMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(ReportMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ReportMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ReportMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ReportMeta.ID)));
			this.setReportSource(DataParser.parse(String.class, map.get(ReportMeta.REPORT_SOURCE)));
			this.setStatus(DataParser.parse(String.class, map.get(ReportMeta.STATUS)));
			// others
			this.setReportCategory(DataParser.parse(ReportCategory.class, map.get(ReportMeta.REPORT_CATEGORY)));
			this.setReportTpl(DataParser.parse(ReportUDef.class, map.get(ReportMeta.REPORT_TPL)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(ReportMeta.CODE));
				this.setNotes( (String)map.get(ReportMeta.NOTES));
				this.setReportTplId( (String)map.get(ReportMeta.REPORT_TPL_ID));
				this.setReportTplDefId( (String)map.get(ReportMeta.REPORT_TPL_DEF_ID));
				this.setUpdateTime( (Date)map.get(ReportMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(ReportMeta.VERSION));
				this.setCreateBy( (String)map.get(ReportMeta.CREATE_BY));
				this.setCatalogId( (String)map.get(ReportMeta.CATALOG_ID));
				this.setRoute( (String)map.get(ReportMeta.ROUTE));
				this.setDeleted( (Integer)map.get(ReportMeta.DELETED));
				this.setCreateTime( (Date)map.get(ReportMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ReportMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ReportMeta.DELETE_TIME));
				this.setName( (String)map.get(ReportMeta.NAME));
				this.setTenantId( (String)map.get(ReportMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ReportMeta.DELETE_BY));
				this.setId( (String)map.get(ReportMeta.ID));
				this.setReportSource( (String)map.get(ReportMeta.REPORT_SOURCE));
				this.setStatus( (String)map.get(ReportMeta.STATUS));
				// others
				this.setReportCategory( (ReportCategory)map.get(ReportMeta.REPORT_CATEGORY));
				this.setReportTpl( (ReportUDef)map.get(ReportMeta.REPORT_TPL));
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
			this.setCode(DataParser.parse(String.class, r.getValue(ReportMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(ReportMeta.NOTES)));
			this.setReportTplId(DataParser.parse(String.class, r.getValue(ReportMeta.REPORT_TPL_ID)));
			this.setReportTplDefId(DataParser.parse(String.class, r.getValue(ReportMeta.REPORT_TPL_DEF_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ReportMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ReportMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ReportMeta.CREATE_BY)));
			this.setCatalogId(DataParser.parse(String.class, r.getValue(ReportMeta.CATALOG_ID)));
			this.setRoute(DataParser.parse(String.class, r.getValue(ReportMeta.ROUTE)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ReportMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ReportMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ReportMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ReportMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(ReportMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ReportMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ReportMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ReportMeta.ID)));
			this.setReportSource(DataParser.parse(String.class, r.getValue(ReportMeta.REPORT_SOURCE)));
			this.setStatus(DataParser.parse(String.class, r.getValue(ReportMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(ReportMeta.CODE));
				this.setNotes( (String)r.getValue(ReportMeta.NOTES));
				this.setReportTplId( (String)r.getValue(ReportMeta.REPORT_TPL_ID));
				this.setReportTplDefId( (String)r.getValue(ReportMeta.REPORT_TPL_DEF_ID));
				this.setUpdateTime( (Date)r.getValue(ReportMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(ReportMeta.VERSION));
				this.setCreateBy( (String)r.getValue(ReportMeta.CREATE_BY));
				this.setCatalogId( (String)r.getValue(ReportMeta.CATALOG_ID));
				this.setRoute( (String)r.getValue(ReportMeta.ROUTE));
				this.setDeleted( (Integer)r.getValue(ReportMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ReportMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ReportMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ReportMeta.DELETE_TIME));
				this.setName( (String)r.getValue(ReportMeta.NAME));
				this.setTenantId( (String)r.getValue(ReportMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ReportMeta.DELETE_BY));
				this.setId( (String)r.getValue(ReportMeta.ID));
				this.setReportSource( (String)r.getValue(ReportMeta.REPORT_SOURCE));
				this.setStatus( (String)r.getValue(ReportMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}