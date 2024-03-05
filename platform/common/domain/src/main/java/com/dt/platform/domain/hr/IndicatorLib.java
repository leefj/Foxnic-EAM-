package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_INDICATOR_LIB;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.IndicatorLibMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 指标库
 * <p>指标库 , 数据表 hr_indicator_lib 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-29 16:32:19
 * @sign 13CDD639DB5E02E31731FC97A0DA7383
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_indicator_lib")
@ApiModel(description = "指标库 ; 指标库 , 数据表 hr_indicator_lib 的PO类型")
public class IndicatorLib extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_INDICATOR_LIB.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "815199131050967040")
	private String id;
	
	/**
	 * 指标分类：指标分类
	*/
	@ApiModelProperty(required = false,value="指标分类" , notes = "指标分类" , example = "rs")
	private String typeCode;
	
	/**
	 * 指标名称：指标名称
	*/
	@ApiModelProperty(required = false,value="指标名称" , notes = "指标名称" , example = "采购达成率")
	private String name;
	
	/**
	 * 定性/定量指标：定性/定量指标
	*/
	@ApiModelProperty(required = false,value="定性/定量指标" , notes = "定性/定量指标" , example = "定量")
	private String property;
	
	/**
	 * 计量单位：计量单位
	*/
	@ApiModelProperty(required = false,value="计量单位" , notes = "计量单位" , example = "%")
	private String unit;
	
	/**
	 * 指标定义：指标定义
	*/
	@ApiModelProperty(required = false,value="指标定义" , notes = "指标定义" , example = "采购达成率")
	private String def;
	
	/**
	 * 评分标准：评分标准
	*/
	@ApiModelProperty(required = false,value="评分标准" , notes = "评分标准")
	private String scoringBase;
	
	/**
	 * 评分依据：评分依据
	*/
	@ApiModelProperty(required = false,value="评分依据" , notes = "评分依据")
	private String scoringBy;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-28 12:30:19")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-02-29 03:07:07")
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "2")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * typeDict：typeDict
	*/
	@ApiModelProperty(required = false,value="typeDict" , notes = "typeDict")
	private DictItem typeDict;
	
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
	public IndicatorLib setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 指标分类<br>
	 * 指标分类
	 * @return 指标分类
	*/
	public String getTypeCode() {
		return typeCode;
	}
	
	/**
	 * 设置 指标分类
	 * @param typeCode 指标分类
	 * @return 当前对象
	*/
	public IndicatorLib setTypeCode(String typeCode) {
		this.typeCode=typeCode;
		return this;
	}
	
	/**
	 * 获得 指标名称<br>
	 * 指标名称
	 * @return 指标名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 指标名称
	 * @param name 指标名称
	 * @return 当前对象
	*/
	public IndicatorLib setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 定性/定量指标<br>
	 * 定性/定量指标
	 * @return 定性/定量指标
	*/
	public String getProperty() {
		return property;
	}
	
	/**
	 * 设置 定性/定量指标
	 * @param property 定性/定量指标
	 * @return 当前对象
	*/
	public IndicatorLib setProperty(String property) {
		this.property=property;
		return this;
	}
	
	/**
	 * 获得 计量单位<br>
	 * 计量单位
	 * @return 计量单位
	*/
	public String getUnit() {
		return unit;
	}
	
	/**
	 * 设置 计量单位
	 * @param unit 计量单位
	 * @return 当前对象
	*/
	public IndicatorLib setUnit(String unit) {
		this.unit=unit;
		return this;
	}
	
	/**
	 * 获得 指标定义<br>
	 * 指标定义
	 * @return 指标定义
	*/
	public String getDef() {
		return def;
	}
	
	/**
	 * 设置 指标定义
	 * @param def 指标定义
	 * @return 当前对象
	*/
	public IndicatorLib setDef(String def) {
		this.def=def;
		return this;
	}
	
	/**
	 * 获得 评分标准<br>
	 * 评分标准
	 * @return 评分标准
	*/
	public String getScoringBase() {
		return scoringBase;
	}
	
	/**
	 * 设置 评分标准
	 * @param scoringBase 评分标准
	 * @return 当前对象
	*/
	public IndicatorLib setScoringBase(String scoringBase) {
		this.scoringBase=scoringBase;
		return this;
	}
	
	/**
	 * 获得 评分依据<br>
	 * 评分依据
	 * @return 评分依据
	*/
	public String getScoringBy() {
		return scoringBy;
	}
	
	/**
	 * 设置 评分依据
	 * @param scoringBy 评分依据
	 * @return 当前对象
	*/
	public IndicatorLib setScoringBy(String scoringBy) {
		this.scoringBy=scoringBy;
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
	public IndicatorLib setCreateBy(String createBy) {
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
	public IndicatorLib setCreateTime(Date createTime) {
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
	public IndicatorLib setUpdateBy(String updateBy) {
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
	public IndicatorLib setUpdateTime(Date updateTime) {
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
	public IndicatorLib setDeleted(Integer deleted) {
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
	public IndicatorLib setDeleted(Boolean deletedBool) {
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
	public IndicatorLib setDeleteBy(String deleteBy) {
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
	public IndicatorLib setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public IndicatorLib setVersion(Integer version) {
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
	public IndicatorLib setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 typeDict<br>
	 * typeDict
	 * @return typeDict
	*/
	public DictItem getTypeDict() {
		return typeDict;
	}
	
	/**
	 * 设置 typeDict
	 * @param typeDict typeDict
	 * @return 当前对象
	*/
	public IndicatorLib setTypeDict(DictItem typeDict) {
		this.typeDict=typeDict;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return IndicatorLib , 转换好的 IndicatorLib 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return IndicatorLib , 转换好的 PoJo 对象
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
	public IndicatorLib clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public IndicatorLib duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.IndicatorLibMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.IndicatorLibMeta.$$proxy$$();
		inst.setScoringBase(this.getScoringBase());
		inst.setDef(this.getDef());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setTypeCode(this.getTypeCode());
		inst.setScoringBy(this.getScoringBy());
		inst.setUnit(this.getUnit());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setProperty(this.getProperty());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
			inst.setTypeDict(this.getTypeDict());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public IndicatorLib clone(boolean deep) {
		return EntityContext.clone(IndicatorLib.class,this,deep);
	}

	/**
	 * 将 Map 转换成 IndicatorLib
	 * @param indicatorLibMap 包含实体信息的 Map 对象
	 * @return IndicatorLib , 转换好的的 IndicatorLib 对象
	*/
	@Transient
	public static IndicatorLib createFrom(Map<String,Object> indicatorLibMap) {
		if(indicatorLibMap==null) return null;
		IndicatorLib po = create();
		EntityContext.copyProperties(po,indicatorLibMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 IndicatorLib
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return IndicatorLib , 转换好的的 IndicatorLib 对象
	*/
	@Transient
	public static IndicatorLib createFrom(Object pojo) {
		if(pojo==null) return null;
		IndicatorLib po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 IndicatorLib，等同于 new
	 * @return IndicatorLib 对象
	*/
	@Transient
	public static IndicatorLib create() {
		return new com.dt.platform.domain.hr.meta.IndicatorLibMeta.$$proxy$$();
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
			this.setScoringBase(DataParser.parse(String.class, map.get(IndicatorLibMeta.SCORING_BASE)));
			this.setDef(DataParser.parse(String.class, map.get(IndicatorLibMeta.DEF)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(IndicatorLibMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(IndicatorLibMeta.VERSION)));
			this.setTypeCode(DataParser.parse(String.class, map.get(IndicatorLibMeta.TYPE_CODE)));
			this.setScoringBy(DataParser.parse(String.class, map.get(IndicatorLibMeta.SCORING_BY)));
			this.setUnit(DataParser.parse(String.class, map.get(IndicatorLibMeta.UNIT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(IndicatorLibMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(IndicatorLibMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(IndicatorLibMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(IndicatorLibMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(IndicatorLibMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(IndicatorLibMeta.NAME)));
			this.setProperty(DataParser.parse(String.class, map.get(IndicatorLibMeta.PROPERTY)));
			this.setTenantId(DataParser.parse(String.class, map.get(IndicatorLibMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(IndicatorLibMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(IndicatorLibMeta.ID)));
			// others
			this.setTypeDict(DataParser.parse(DictItem.class, map.get(IndicatorLibMeta.TYPE_DICT)));
			return true;
		} else {
			try {
				this.setScoringBase( (String)map.get(IndicatorLibMeta.SCORING_BASE));
				this.setDef( (String)map.get(IndicatorLibMeta.DEF));
				this.setUpdateTime( (Date)map.get(IndicatorLibMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(IndicatorLibMeta.VERSION));
				this.setTypeCode( (String)map.get(IndicatorLibMeta.TYPE_CODE));
				this.setScoringBy( (String)map.get(IndicatorLibMeta.SCORING_BY));
				this.setUnit( (String)map.get(IndicatorLibMeta.UNIT));
				this.setCreateBy( (String)map.get(IndicatorLibMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(IndicatorLibMeta.DELETED));
				this.setCreateTime( (Date)map.get(IndicatorLibMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(IndicatorLibMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(IndicatorLibMeta.DELETE_TIME));
				this.setName( (String)map.get(IndicatorLibMeta.NAME));
				this.setProperty( (String)map.get(IndicatorLibMeta.PROPERTY));
				this.setTenantId( (String)map.get(IndicatorLibMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(IndicatorLibMeta.DELETE_BY));
				this.setId( (String)map.get(IndicatorLibMeta.ID));
				// others
				this.setTypeDict( (DictItem)map.get(IndicatorLibMeta.TYPE_DICT));
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
			this.setScoringBase(DataParser.parse(String.class, r.getValue(IndicatorLibMeta.SCORING_BASE)));
			this.setDef(DataParser.parse(String.class, r.getValue(IndicatorLibMeta.DEF)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(IndicatorLibMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(IndicatorLibMeta.VERSION)));
			this.setTypeCode(DataParser.parse(String.class, r.getValue(IndicatorLibMeta.TYPE_CODE)));
			this.setScoringBy(DataParser.parse(String.class, r.getValue(IndicatorLibMeta.SCORING_BY)));
			this.setUnit(DataParser.parse(String.class, r.getValue(IndicatorLibMeta.UNIT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(IndicatorLibMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(IndicatorLibMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(IndicatorLibMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(IndicatorLibMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(IndicatorLibMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(IndicatorLibMeta.NAME)));
			this.setProperty(DataParser.parse(String.class, r.getValue(IndicatorLibMeta.PROPERTY)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(IndicatorLibMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(IndicatorLibMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(IndicatorLibMeta.ID)));
			return true;
		} else {
			try {
				this.setScoringBase( (String)r.getValue(IndicatorLibMeta.SCORING_BASE));
				this.setDef( (String)r.getValue(IndicatorLibMeta.DEF));
				this.setUpdateTime( (Date)r.getValue(IndicatorLibMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(IndicatorLibMeta.VERSION));
				this.setTypeCode( (String)r.getValue(IndicatorLibMeta.TYPE_CODE));
				this.setScoringBy( (String)r.getValue(IndicatorLibMeta.SCORING_BY));
				this.setUnit( (String)r.getValue(IndicatorLibMeta.UNIT));
				this.setCreateBy( (String)r.getValue(IndicatorLibMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(IndicatorLibMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(IndicatorLibMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(IndicatorLibMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(IndicatorLibMeta.DELETE_TIME));
				this.setName( (String)r.getValue(IndicatorLibMeta.NAME));
				this.setProperty( (String)r.getValue(IndicatorLibMeta.PROPERTY));
				this.setTenantId( (String)r.getValue(IndicatorLibMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(IndicatorLibMeta.DELETE_BY));
				this.setId( (String)r.getValue(IndicatorLibMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}