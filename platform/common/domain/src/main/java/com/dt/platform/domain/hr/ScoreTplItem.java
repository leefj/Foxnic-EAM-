package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_SCORE_TPL_ITEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.ScoreTplItemMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 评分项目
 * <p>评分项目 , 数据表 hr_score_tpl_item 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 12:57:42
 * @sign 8B8BA0C9CDBD35B88145F86530173CE1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_score_tpl_item")
@ApiModel(description = "评分项目 ; 评分项目 , 数据表 hr_score_tpl_item 的PO类型")
public class ScoreTplItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_SCORE_TPL_ITEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "809712898338193408")
	private String id;
	
	/**
	 * 模版：模版
	*/
	@ApiModelProperty(required = false,value="模版" , notes = "模版")
	private String tplId;
	
	/**
	 * 组件类型：组件类型
	*/
	@ApiModelProperty(required = false,value="组件类型" , notes = "组件类型" , example = "number")
	private String itemType;
	
	/**
	 * 题目：题目
	*/
	@ApiModelProperty(required = false,value="题目" , notes = "题目" , example = "12121212")
	private String itemName;
	
	/**
	 * 指标：指标
	*/
	@ApiModelProperty(required = false,value="指标" , notes = "指标" , example = "809523698477301760")
	private String groupId;
	
	/**
	 * 最小分：最小分
	*/
	@ApiModelProperty(required = false,value="最小分" , notes = "最小分" , example = "10")
	private BigDecimal minScore;
	
	/**
	 * 最大分：最大分
	*/
	@ApiModelProperty(required = false,value="最大分" , notes = "最大分" , example = "1")
	private BigDecimal maxScore;
	
	/**
	 * 默认分：默认分
	*/
	@ApiModelProperty(required = false,value="默认分" , notes = "默认分" , example = "1")
	private BigDecimal defScore;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序" , example = "1")
	private Integer sn;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-13 09:09:59")
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * scoreIndicator：scoreIndicator
	*/
	@ApiModelProperty(required = false,value="scoreIndicator" , notes = "scoreIndicator")
	private ScoreIndicator scoreIndicator;
	
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
	public ScoreTplItem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 模版<br>
	 * 模版
	 * @return 模版
	*/
	public String getTplId() {
		return tplId;
	}
	
	/**
	 * 设置 模版
	 * @param tplId 模版
	 * @return 当前对象
	*/
	public ScoreTplItem setTplId(String tplId) {
		this.tplId=tplId;
		return this;
	}
	
	/**
	 * 获得 组件类型<br>
	 * 组件类型
	 * @return 组件类型
	*/
	public String getItemType() {
		return itemType;
	}
	
	/**
	 * 设置 组件类型
	 * @param itemType 组件类型
	 * @return 当前对象
	*/
	public ScoreTplItem setItemType(String itemType) {
		this.itemType=itemType;
		return this;
	}
	
	/**
	 * 获得 题目<br>
	 * 题目
	 * @return 题目
	*/
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * 设置 题目
	 * @param itemName 题目
	 * @return 当前对象
	*/
	public ScoreTplItem setItemName(String itemName) {
		this.itemName=itemName;
		return this;
	}
	
	/**
	 * 获得 指标<br>
	 * 指标
	 * @return 指标
	*/
	public String getGroupId() {
		return groupId;
	}
	
	/**
	 * 设置 指标
	 * @param groupId 指标
	 * @return 当前对象
	*/
	public ScoreTplItem setGroupId(String groupId) {
		this.groupId=groupId;
		return this;
	}
	
	/**
	 * 获得 最小分<br>
	 * 最小分
	 * @return 最小分
	*/
	public BigDecimal getMinScore() {
		return minScore;
	}
	
	/**
	 * 设置 最小分
	 * @param minScore 最小分
	 * @return 当前对象
	*/
	public ScoreTplItem setMinScore(BigDecimal minScore) {
		this.minScore=minScore;
		return this;
	}
	
	/**
	 * 获得 最大分<br>
	 * 最大分
	 * @return 最大分
	*/
	public BigDecimal getMaxScore() {
		return maxScore;
	}
	
	/**
	 * 设置 最大分
	 * @param maxScore 最大分
	 * @return 当前对象
	*/
	public ScoreTplItem setMaxScore(BigDecimal maxScore) {
		this.maxScore=maxScore;
		return this;
	}
	
	/**
	 * 获得 默认分<br>
	 * 默认分
	 * @return 默认分
	*/
	public BigDecimal getDefScore() {
		return defScore;
	}
	
	/**
	 * 设置 默认分
	 * @param defScore 默认分
	 * @return 当前对象
	*/
	public ScoreTplItem setDefScore(BigDecimal defScore) {
		this.defScore=defScore;
		return this;
	}
	
	/**
	 * 获得 排序<br>
	 * 排序
	 * @return 排序
	*/
	public Integer getSn() {
		return sn;
	}
	
	/**
	 * 设置 排序
	 * @param sn 排序
	 * @return 当前对象
	*/
	public ScoreTplItem setSn(Integer sn) {
		this.sn=sn;
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
	public ScoreTplItem setNotes(String notes) {
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
	public ScoreTplItem setCreateBy(String createBy) {
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
	public ScoreTplItem setCreateTime(Date createTime) {
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
	public ScoreTplItem setUpdateBy(String updateBy) {
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
	public ScoreTplItem setUpdateTime(Date updateTime) {
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
	public ScoreTplItem setDeleted(Integer deleted) {
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
	public ScoreTplItem setDeleted(Boolean deletedBool) {
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
	public ScoreTplItem setDeleteBy(String deleteBy) {
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
	public ScoreTplItem setDeleteTime(Date deleteTime) {
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
	public ScoreTplItem setVersion(Integer version) {
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
	public ScoreTplItem setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 scoreIndicator<br>
	 * scoreIndicator
	 * @return scoreIndicator
	*/
	public ScoreIndicator getScoreIndicator() {
		return scoreIndicator;
	}
	
	/**
	 * 设置 scoreIndicator
	 * @param scoreIndicator scoreIndicator
	 * @return 当前对象
	*/
	public ScoreTplItem setScoreIndicator(ScoreIndicator scoreIndicator) {
		this.scoreIndicator=scoreIndicator;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ScoreTplItem , 转换好的 ScoreTplItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ScoreTplItem , 转换好的 PoJo 对象
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
	public ScoreTplItem clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ScoreTplItem duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.ScoreTplItemMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.ScoreTplItemMeta.$$proxy$$();
		inst.setItemType(this.getItemType());
		inst.setMinScore(this.getMinScore());
		inst.setNotes(this.getNotes());
		inst.setGroupId(this.getGroupId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setMaxScore(this.getMaxScore());
		inst.setVersion(this.getVersion());
		inst.setItemName(this.getItemName());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setDefScore(this.getDefScore());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setSn(this.getSn());
		inst.setTplId(this.getTplId());
		if(all) {
			inst.setScoreIndicator(this.getScoreIndicator());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ScoreTplItem clone(boolean deep) {
		return EntityContext.clone(ScoreTplItem.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ScoreTplItem
	 * @param scoreTplItemMap 包含实体信息的 Map 对象
	 * @return ScoreTplItem , 转换好的的 ScoreTplItem 对象
	*/
	@Transient
	public static ScoreTplItem createFrom(Map<String,Object> scoreTplItemMap) {
		if(scoreTplItemMap==null) return null;
		ScoreTplItem po = create();
		EntityContext.copyProperties(po,scoreTplItemMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ScoreTplItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ScoreTplItem , 转换好的的 ScoreTplItem 对象
	*/
	@Transient
	public static ScoreTplItem createFrom(Object pojo) {
		if(pojo==null) return null;
		ScoreTplItem po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ScoreTplItem，等同于 new
	 * @return ScoreTplItem 对象
	*/
	@Transient
	public static ScoreTplItem create() {
		return new com.dt.platform.domain.hr.meta.ScoreTplItemMeta.$$proxy$$();
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
			this.setItemType(DataParser.parse(String.class, map.get(ScoreTplItemMeta.ITEM_TYPE)));
			this.setMinScore(DataParser.parse(BigDecimal.class, map.get(ScoreTplItemMeta.MIN_SCORE)));
			this.setNotes(DataParser.parse(String.class, map.get(ScoreTplItemMeta.NOTES)));
			this.setGroupId(DataParser.parse(String.class, map.get(ScoreTplItemMeta.GROUP_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ScoreTplItemMeta.UPDATE_TIME)));
			this.setMaxScore(DataParser.parse(BigDecimal.class, map.get(ScoreTplItemMeta.MAX_SCORE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ScoreTplItemMeta.VERSION)));
			this.setItemName(DataParser.parse(String.class, map.get(ScoreTplItemMeta.ITEM_NAME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ScoreTplItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ScoreTplItemMeta.DELETED)));
			this.setDefScore(DataParser.parse(BigDecimal.class, map.get(ScoreTplItemMeta.DEF_SCORE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ScoreTplItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ScoreTplItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ScoreTplItemMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ScoreTplItemMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ScoreTplItemMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ScoreTplItemMeta.ID)));
			this.setSn(DataParser.parse(Integer.class, map.get(ScoreTplItemMeta.SN)));
			this.setTplId(DataParser.parse(String.class, map.get(ScoreTplItemMeta.TPL_ID)));
			// others
			this.setScoreIndicator(DataParser.parse(ScoreIndicator.class, map.get(ScoreTplItemMeta.SCORE_INDICATOR)));
			return true;
		} else {
			try {
				this.setItemType( (String)map.get(ScoreTplItemMeta.ITEM_TYPE));
				this.setMinScore( (BigDecimal)map.get(ScoreTplItemMeta.MIN_SCORE));
				this.setNotes( (String)map.get(ScoreTplItemMeta.NOTES));
				this.setGroupId( (String)map.get(ScoreTplItemMeta.GROUP_ID));
				this.setUpdateTime( (Date)map.get(ScoreTplItemMeta.UPDATE_TIME));
				this.setMaxScore( (BigDecimal)map.get(ScoreTplItemMeta.MAX_SCORE));
				this.setVersion( (Integer)map.get(ScoreTplItemMeta.VERSION));
				this.setItemName( (String)map.get(ScoreTplItemMeta.ITEM_NAME));
				this.setCreateBy( (String)map.get(ScoreTplItemMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ScoreTplItemMeta.DELETED));
				this.setDefScore( (BigDecimal)map.get(ScoreTplItemMeta.DEF_SCORE));
				this.setCreateTime( (Date)map.get(ScoreTplItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ScoreTplItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ScoreTplItemMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(ScoreTplItemMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ScoreTplItemMeta.DELETE_BY));
				this.setId( (String)map.get(ScoreTplItemMeta.ID));
				this.setSn( (Integer)map.get(ScoreTplItemMeta.SN));
				this.setTplId( (String)map.get(ScoreTplItemMeta.TPL_ID));
				// others
				this.setScoreIndicator( (ScoreIndicator)map.get(ScoreTplItemMeta.SCORE_INDICATOR));
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
			this.setItemType(DataParser.parse(String.class, r.getValue(ScoreTplItemMeta.ITEM_TYPE)));
			this.setMinScore(DataParser.parse(BigDecimal.class, r.getValue(ScoreTplItemMeta.MIN_SCORE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(ScoreTplItemMeta.NOTES)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(ScoreTplItemMeta.GROUP_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ScoreTplItemMeta.UPDATE_TIME)));
			this.setMaxScore(DataParser.parse(BigDecimal.class, r.getValue(ScoreTplItemMeta.MAX_SCORE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ScoreTplItemMeta.VERSION)));
			this.setItemName(DataParser.parse(String.class, r.getValue(ScoreTplItemMeta.ITEM_NAME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ScoreTplItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ScoreTplItemMeta.DELETED)));
			this.setDefScore(DataParser.parse(BigDecimal.class, r.getValue(ScoreTplItemMeta.DEF_SCORE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ScoreTplItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ScoreTplItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ScoreTplItemMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ScoreTplItemMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ScoreTplItemMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ScoreTplItemMeta.ID)));
			this.setSn(DataParser.parse(Integer.class, r.getValue(ScoreTplItemMeta.SN)));
			this.setTplId(DataParser.parse(String.class, r.getValue(ScoreTplItemMeta.TPL_ID)));
			return true;
		} else {
			try {
				this.setItemType( (String)r.getValue(ScoreTplItemMeta.ITEM_TYPE));
				this.setMinScore( (BigDecimal)r.getValue(ScoreTplItemMeta.MIN_SCORE));
				this.setNotes( (String)r.getValue(ScoreTplItemMeta.NOTES));
				this.setGroupId( (String)r.getValue(ScoreTplItemMeta.GROUP_ID));
				this.setUpdateTime( (Date)r.getValue(ScoreTplItemMeta.UPDATE_TIME));
				this.setMaxScore( (BigDecimal)r.getValue(ScoreTplItemMeta.MAX_SCORE));
				this.setVersion( (Integer)r.getValue(ScoreTplItemMeta.VERSION));
				this.setItemName( (String)r.getValue(ScoreTplItemMeta.ITEM_NAME));
				this.setCreateBy( (String)r.getValue(ScoreTplItemMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ScoreTplItemMeta.DELETED));
				this.setDefScore( (BigDecimal)r.getValue(ScoreTplItemMeta.DEF_SCORE));
				this.setCreateTime( (Date)r.getValue(ScoreTplItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ScoreTplItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ScoreTplItemMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(ScoreTplItemMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ScoreTplItemMeta.DELETE_BY));
				this.setId( (String)r.getValue(ScoreTplItemMeta.ID));
				this.setSn( (Integer)r.getValue(ScoreTplItemMeta.SN));
				this.setTplId( (String)r.getValue(ScoreTplItemMeta.TPL_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}