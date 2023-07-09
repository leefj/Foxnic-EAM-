package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_MAINTAIN_PROJECT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.MaintainProjectMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 保养项目
 * <p>保养项目 , 数据表 eam_maintain_project 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-07 18:15:14
 * @sign E651BB049433A39E7BCBF8E9F6046C25
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_maintain_project")
@ApiModel(description = "保养项目 ; 保养项目 , 数据表 eam_maintain_project 的PO类型")
public class MaintainProject extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_MAINTAIN_PROJECT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "698150690282799104")
	private String id;
	
	/**
	 * 项目编号：项目编号
	*/
	@ApiModelProperty(required = false,value="项目编号" , notes = "项目编号" , example = "MPJ202304111204372")
	private String code;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 项目名称：项目名称
	*/
	@ApiModelProperty(required = false,value="项目名称" , notes = "项目名称" , example = "保养项目1")
	private String name;
	
	/**
	 * 保养内容：保养内容
	*/
	@ApiModelProperty(required = false,value="保养内容" , notes = "保养内容")
	private String content;
	
	/**
	 * 保养类型：保养类型
	*/
	@ApiModelProperty(required = false,value="保养类型" , notes = "保养类型" , example = "default")
	private String maintainType;
	
	/**
	 * 标准工时：小时)
	*/
	@ApiModelProperty(required = false,value="标准工时" , notes = "小时)" , example = "1.00")
	private BigDecimal baseCost;
	
	/**
	 * 保养周期：保养周期
	*/
	@ApiModelProperty(required = false,value="保养周期" , notes = "保养周期" , example = "698150684763095040")
	private String actionCycleId;
	
	/**
	 * 保养手册：保养手册
	*/
	@ApiModelProperty(required = false,value="保养手册" , notes = "保养手册")
	private String attachId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "保养项目111")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-04-11 12:41:36")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-07-06 05:28:19")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "2")
	private Integer version;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private DictItem maintainTypeDict;
	
	/**
	 * 周期：周期
	*/
	@ApiModelProperty(required = false,value="周期" , notes = "周期")
	private ActionCrontab actionCrontab;
	
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
	public MaintainProject setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 项目编号<br>
	 * 项目编号
	 * @return 项目编号
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 项目编号
	 * @param code 项目编号
	 * @return 当前对象
	*/
	public MaintainProject setCode(String code) {
		this.code=code;
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
	public MaintainProject setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 项目名称<br>
	 * 项目名称
	 * @return 项目名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 项目名称
	 * @param name 项目名称
	 * @return 当前对象
	*/
	public MaintainProject setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 保养内容<br>
	 * 保养内容
	 * @return 保养内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 保养内容
	 * @param content 保养内容
	 * @return 当前对象
	*/
	public MaintainProject setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 保养类型<br>
	 * 保养类型
	 * @return 保养类型
	*/
	public String getMaintainType() {
		return maintainType;
	}
	
	/**
	 * 设置 保养类型
	 * @param maintainType 保养类型
	 * @return 当前对象
	*/
	public MaintainProject setMaintainType(String maintainType) {
		this.maintainType=maintainType;
		return this;
	}
	
	/**
	 * 获得 标准工时<br>
	 * 小时)
	 * @return 标准工时
	*/
	public BigDecimal getBaseCost() {
		return baseCost;
	}
	
	/**
	 * 设置 标准工时
	 * @param baseCost 标准工时
	 * @return 当前对象
	*/
	public MaintainProject setBaseCost(BigDecimal baseCost) {
		this.baseCost=baseCost;
		return this;
	}
	
	/**
	 * 获得 保养周期<br>
	 * 保养周期
	 * @return 保养周期
	*/
	public String getActionCycleId() {
		return actionCycleId;
	}
	
	/**
	 * 设置 保养周期
	 * @param actionCycleId 保养周期
	 * @return 当前对象
	*/
	public MaintainProject setActionCycleId(String actionCycleId) {
		this.actionCycleId=actionCycleId;
		return this;
	}
	
	/**
	 * 获得 保养手册<br>
	 * 保养手册
	 * @return 保养手册
	*/
	public String getAttachId() {
		return attachId;
	}
	
	/**
	 * 设置 保养手册
	 * @param attachId 保养手册
	 * @return 当前对象
	*/
	public MaintainProject setAttachId(String attachId) {
		this.attachId=attachId;
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
	public MaintainProject setNotes(String notes) {
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
	public MaintainProject setCreateBy(String createBy) {
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
	public MaintainProject setCreateTime(Date createTime) {
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
	public MaintainProject setUpdateBy(String updateBy) {
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
	public MaintainProject setUpdateTime(Date updateTime) {
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
	public MaintainProject setDeleted(Integer deleted) {
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
	public MaintainProject setDeleted(Boolean deletedBool) {
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
	public MaintainProject setDeleteBy(String deleteBy) {
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
	public MaintainProject setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public MaintainProject setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 选择<br>
	 * 选择
	 * @return 选择
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择
	 * @param selectedCode 选择
	 * @return 当前对象
	*/
	public MaintainProject setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public MaintainProject setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public DictItem getMaintainTypeDict() {
		return maintainTypeDict;
	}
	
	/**
	 * 设置 类型
	 * @param maintainTypeDict 类型
	 * @return 当前对象
	*/
	public MaintainProject setMaintainTypeDict(DictItem maintainTypeDict) {
		this.maintainTypeDict=maintainTypeDict;
		return this;
	}
	
	/**
	 * 获得 周期<br>
	 * 周期
	 * @return 周期
	*/
	public ActionCrontab getActionCrontab() {
		return actionCrontab;
	}
	
	/**
	 * 设置 周期
	 * @param actionCrontab 周期
	 * @return 当前对象
	*/
	public MaintainProject setActionCrontab(ActionCrontab actionCrontab) {
		this.actionCrontab=actionCrontab;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MaintainProject , 转换好的 MaintainProject 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MaintainProject , 转换好的 PoJo 对象
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
	public MaintainProject clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MaintainProject duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.MaintainProjectMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.MaintainProjectMeta.$$proxy$$();
		inst.setBaseCost(this.getBaseCost());
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setActionCycleId(this.getActionCycleId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setMaintainType(this.getMaintainType());
		inst.setAttachId(this.getAttachId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setActionCrontab(this.getActionCrontab());
			inst.setMaintainTypeDict(this.getMaintainTypeDict());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MaintainProject clone(boolean deep) {
		return EntityContext.clone(MaintainProject.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MaintainProject
	 * @param maintainProjectMap 包含实体信息的 Map 对象
	 * @return MaintainProject , 转换好的的 MaintainProject 对象
	*/
	@Transient
	public static MaintainProject createFrom(Map<String,Object> maintainProjectMap) {
		if(maintainProjectMap==null) return null;
		MaintainProject po = create();
		EntityContext.copyProperties(po,maintainProjectMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 MaintainProject
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MaintainProject , 转换好的的 MaintainProject 对象
	*/
	@Transient
	public static MaintainProject createFrom(Object pojo) {
		if(pojo==null) return null;
		MaintainProject po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 MaintainProject，等同于 new
	 * @return MaintainProject 对象
	*/
	@Transient
	public static MaintainProject create() {
		return new com.dt.platform.domain.eam.meta.MaintainProjectMeta.$$proxy$$();
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
			this.setBaseCost(DataParser.parse(BigDecimal.class, map.get(MaintainProjectMeta.BASE_COST)));
			this.setCode(DataParser.parse(String.class, map.get(MaintainProjectMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(MaintainProjectMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MaintainProjectMeta.UPDATE_TIME)));
			this.setActionCycleId(DataParser.parse(String.class, map.get(MaintainProjectMeta.ACTION_CYCLE_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(MaintainProjectMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MaintainProjectMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(MaintainProjectMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MaintainProjectMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MaintainProjectMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MaintainProjectMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MaintainProjectMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MaintainProjectMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(MaintainProjectMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(MaintainProjectMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MaintainProjectMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(MaintainProjectMeta.ID)));
			this.setMaintainType(DataParser.parse(String.class, map.get(MaintainProjectMeta.MAINTAIN_TYPE)));
			this.setAttachId(DataParser.parse(String.class, map.get(MaintainProjectMeta.ATTACH_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(MaintainProjectMeta.STATUS)));
			// others
			this.setActionCrontab(DataParser.parse(ActionCrontab.class, map.get(MaintainProjectMeta.ACTION_CRONTAB)));
			this.setMaintainTypeDict(DataParser.parse(DictItem.class, map.get(MaintainProjectMeta.MAINTAIN_TYPE_DICT)));
			return true;
		} else {
			try {
				this.setBaseCost( (BigDecimal)map.get(MaintainProjectMeta.BASE_COST));
				this.setCode( (String)map.get(MaintainProjectMeta.CODE));
				this.setNotes( (String)map.get(MaintainProjectMeta.NOTES));
				this.setUpdateTime( (Date)map.get(MaintainProjectMeta.UPDATE_TIME));
				this.setActionCycleId( (String)map.get(MaintainProjectMeta.ACTION_CYCLE_ID));
				this.setSelectedCode( (String)map.get(MaintainProjectMeta.SELECTED_CODE));
				this.setVersion( (Integer)map.get(MaintainProjectMeta.VERSION));
				this.setContent( (String)map.get(MaintainProjectMeta.CONTENT));
				this.setCreateBy( (String)map.get(MaintainProjectMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MaintainProjectMeta.DELETED));
				this.setCreateTime( (Date)map.get(MaintainProjectMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(MaintainProjectMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(MaintainProjectMeta.DELETE_TIME));
				this.setName( (String)map.get(MaintainProjectMeta.NAME));
				this.setTenantId( (String)map.get(MaintainProjectMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(MaintainProjectMeta.DELETE_BY));
				this.setId( (String)map.get(MaintainProjectMeta.ID));
				this.setMaintainType( (String)map.get(MaintainProjectMeta.MAINTAIN_TYPE));
				this.setAttachId( (String)map.get(MaintainProjectMeta.ATTACH_ID));
				this.setStatus( (String)map.get(MaintainProjectMeta.STATUS));
				// others
				this.setActionCrontab( (ActionCrontab)map.get(MaintainProjectMeta.ACTION_CRONTAB));
				this.setMaintainTypeDict( (DictItem)map.get(MaintainProjectMeta.MAINTAIN_TYPE_DICT));
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
			this.setBaseCost(DataParser.parse(BigDecimal.class, r.getValue(MaintainProjectMeta.BASE_COST)));
			this.setCode(DataParser.parse(String.class, r.getValue(MaintainProjectMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(MaintainProjectMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MaintainProjectMeta.UPDATE_TIME)));
			this.setActionCycleId(DataParser.parse(String.class, r.getValue(MaintainProjectMeta.ACTION_CYCLE_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(MaintainProjectMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MaintainProjectMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(MaintainProjectMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MaintainProjectMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MaintainProjectMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MaintainProjectMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MaintainProjectMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MaintainProjectMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(MaintainProjectMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(MaintainProjectMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MaintainProjectMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(MaintainProjectMeta.ID)));
			this.setMaintainType(DataParser.parse(String.class, r.getValue(MaintainProjectMeta.MAINTAIN_TYPE)));
			this.setAttachId(DataParser.parse(String.class, r.getValue(MaintainProjectMeta.ATTACH_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(MaintainProjectMeta.STATUS)));
			return true;
		} else {
			try {
				this.setBaseCost( (BigDecimal)r.getValue(MaintainProjectMeta.BASE_COST));
				this.setCode( (String)r.getValue(MaintainProjectMeta.CODE));
				this.setNotes( (String)r.getValue(MaintainProjectMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(MaintainProjectMeta.UPDATE_TIME));
				this.setActionCycleId( (String)r.getValue(MaintainProjectMeta.ACTION_CYCLE_ID));
				this.setSelectedCode( (String)r.getValue(MaintainProjectMeta.SELECTED_CODE));
				this.setVersion( (Integer)r.getValue(MaintainProjectMeta.VERSION));
				this.setContent( (String)r.getValue(MaintainProjectMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(MaintainProjectMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MaintainProjectMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(MaintainProjectMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(MaintainProjectMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(MaintainProjectMeta.DELETE_TIME));
				this.setName( (String)r.getValue(MaintainProjectMeta.NAME));
				this.setTenantId( (String)r.getValue(MaintainProjectMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(MaintainProjectMeta.DELETE_BY));
				this.setId( (String)r.getValue(MaintainProjectMeta.ID));
				this.setMaintainType( (String)r.getValue(MaintainProjectMeta.MAINTAIN_TYPE));
				this.setAttachId( (String)r.getValue(MaintainProjectMeta.ATTACH_ID));
				this.setStatus( (String)r.getValue(MaintainProjectMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}