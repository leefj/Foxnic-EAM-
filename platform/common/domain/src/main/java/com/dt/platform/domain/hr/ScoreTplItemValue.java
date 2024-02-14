package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_SCORE_TPL_ITEM_VALUE;
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
import com.dt.platform.domain.hr.meta.ScoreTplItemValueMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 评分明细
 * <p>评分明细 , 数据表 hr_score_tpl_item_value 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-11 23:55:06
 * @sign DA29F33F0FE66CF667A2BB0176B97782
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_score_tpl_item_value")
@ApiModel(description = "评分明细 ; 评分明细 , 数据表 hr_score_tpl_item_value 的PO类型")
public class ScoreTplItemValue extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_SCORE_TPL_ITEM_VALUE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 所属：所属
	*/
	@ApiModelProperty(required = false,value="所属" , notes = "所属")
	private String taskId;
	
	/**
	 * 模版：模版
	*/
	@ApiModelProperty(required = false,value="模版" , notes = "模版")
	private String tplId;
	
	/**
	 * 评分项：评分项
	*/
	@ApiModelProperty(required = false,value="评分项" , notes = "评分项")
	private String tplItemId;
	
	/**
	 * 组件类型：组件类型
	*/
	@ApiModelProperty(required = false,value="组件类型" , notes = "组件类型")
	private String itemType;
	
	/**
	 * 说明：说明
	*/
	@ApiModelProperty(required = false,value="说明" , notes = "说明")
	private String itemName;
	
	/**
	 * 评分组：评分组
	*/
	@ApiModelProperty(required = false,value="评分组" , notes = "评分组")
	private String groupId;
	
	/**
	 * 评分组：评分组
	*/
	@ApiModelProperty(required = false,value="评分组" , notes = "评分组")
	private String groupName;
	
	/**
	 * 最小分：最小分
	*/
	@ApiModelProperty(required = false,value="最小分" , notes = "最小分")
	private BigDecimal minScore;
	
	/**
	 * 最大分：最大分
	*/
	@ApiModelProperty(required = false,value="最大分" , notes = "最大分")
	private BigDecimal maxScore;
	
	/**
	 * 默认分：默认分
	*/
	@ApiModelProperty(required = false,value="默认分" , notes = "默认分")
	private BigDecimal defScore;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序")
	private Integer sn;
	
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
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
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
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * scoreGroup：scoreGroup
	*/
	@ApiModelProperty(required = false,value="scoreGroup" , notes = "scoreGroup")
	private DictItem scoreGroup;
	
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
	public ScoreTplItemValue setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 所属<br>
	 * 所属
	 * @return 所属
	*/
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 设置 所属
	 * @param taskId 所属
	 * @return 当前对象
	*/
	public ScoreTplItemValue setTaskId(String taskId) {
		this.taskId=taskId;
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
	public ScoreTplItemValue setTplId(String tplId) {
		this.tplId=tplId;
		return this;
	}
	
	/**
	 * 获得 评分项<br>
	 * 评分项
	 * @return 评分项
	*/
	public String getTplItemId() {
		return tplItemId;
	}
	
	/**
	 * 设置 评分项
	 * @param tplItemId 评分项
	 * @return 当前对象
	*/
	public ScoreTplItemValue setTplItemId(String tplItemId) {
		this.tplItemId=tplItemId;
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
	public ScoreTplItemValue setItemType(String itemType) {
		this.itemType=itemType;
		return this;
	}
	
	/**
	 * 获得 说明<br>
	 * 说明
	 * @return 说明
	*/
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * 设置 说明
	 * @param itemName 说明
	 * @return 当前对象
	*/
	public ScoreTplItemValue setItemName(String itemName) {
		this.itemName=itemName;
		return this;
	}
	
	/**
	 * 获得 评分组<br>
	 * 评分组
	 * @return 评分组
	*/
	public String getGroupId() {
		return groupId;
	}
	
	/**
	 * 设置 评分组
	 * @param groupId 评分组
	 * @return 当前对象
	*/
	public ScoreTplItemValue setGroupId(String groupId) {
		this.groupId=groupId;
		return this;
	}
	
	/**
	 * 获得 评分组<br>
	 * 评分组
	 * @return 评分组
	*/
	public String getGroupName() {
		return groupName;
	}
	
	/**
	 * 设置 评分组
	 * @param groupName 评分组
	 * @return 当前对象
	*/
	public ScoreTplItemValue setGroupName(String groupName) {
		this.groupName=groupName;
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
	public ScoreTplItemValue setMinScore(BigDecimal minScore) {
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
	public ScoreTplItemValue setMaxScore(BigDecimal maxScore) {
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
	public ScoreTplItemValue setDefScore(BigDecimal defScore) {
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
	public ScoreTplItemValue setSn(Integer sn) {
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
	public ScoreTplItemValue setNotes(String notes) {
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
	public ScoreTplItemValue setCreateBy(String createBy) {
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
	public ScoreTplItemValue setCreateTime(Date createTime) {
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
	public ScoreTplItemValue setUpdateBy(String updateBy) {
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
	public ScoreTplItemValue setUpdateTime(Date updateTime) {
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
	public ScoreTplItemValue setDeleted(Integer deleted) {
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
	public ScoreTplItemValue setDeleted(Boolean deletedBool) {
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
	public ScoreTplItemValue setDeleteBy(String deleteBy) {
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
	public ScoreTplItemValue setDeleteTime(Date deleteTime) {
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
	public ScoreTplItemValue setVersion(Integer version) {
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
	public ScoreTplItemValue setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 scoreGroup<br>
	 * scoreGroup
	 * @return scoreGroup
	*/
	public DictItem getScoreGroup() {
		return scoreGroup;
	}
	
	/**
	 * 设置 scoreGroup
	 * @param scoreGroup scoreGroup
	 * @return 当前对象
	*/
	public ScoreTplItemValue setScoreGroup(DictItem scoreGroup) {
		this.scoreGroup=scoreGroup;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ScoreTplItemValue , 转换好的 ScoreTplItemValue 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ScoreTplItemValue , 转换好的 PoJo 对象
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
	public ScoreTplItemValue clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ScoreTplItemValue duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.ScoreTplItemValueMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.ScoreTplItemValueMeta.$$proxy$$();
		inst.setItemType(this.getItemType());
		inst.setMinScore(this.getMinScore());
		inst.setNotes(this.getNotes());
		inst.setGroupId(this.getGroupId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setMaxScore(this.getMaxScore());
		inst.setVersion(this.getVersion());
		inst.setItemName(this.getItemName());
		inst.setGroupName(this.getGroupName());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setTplItemId(this.getTplItemId());
		inst.setDefScore(this.getDefScore());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setSn(this.getSn());
		inst.setTplId(this.getTplId());
		inst.setTaskId(this.getTaskId());
		if(all) {
			inst.setScoreGroup(this.getScoreGroup());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ScoreTplItemValue clone(boolean deep) {
		return EntityContext.clone(ScoreTplItemValue.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ScoreTplItemValue
	 * @param scoreTplItemValueMap 包含实体信息的 Map 对象
	 * @return ScoreTplItemValue , 转换好的的 ScoreTplItemValue 对象
	*/
	@Transient
	public static ScoreTplItemValue createFrom(Map<String,Object> scoreTplItemValueMap) {
		if(scoreTplItemValueMap==null) return null;
		ScoreTplItemValue po = create();
		EntityContext.copyProperties(po,scoreTplItemValueMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ScoreTplItemValue
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ScoreTplItemValue , 转换好的的 ScoreTplItemValue 对象
	*/
	@Transient
	public static ScoreTplItemValue createFrom(Object pojo) {
		if(pojo==null) return null;
		ScoreTplItemValue po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ScoreTplItemValue，等同于 new
	 * @return ScoreTplItemValue 对象
	*/
	@Transient
	public static ScoreTplItemValue create() {
		return new com.dt.platform.domain.hr.meta.ScoreTplItemValueMeta.$$proxy$$();
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
			this.setItemType(DataParser.parse(String.class, map.get(ScoreTplItemValueMeta.ITEM_TYPE)));
			this.setMinScore(DataParser.parse(BigDecimal.class, map.get(ScoreTplItemValueMeta.MIN_SCORE)));
			this.setNotes(DataParser.parse(String.class, map.get(ScoreTplItemValueMeta.NOTES)));
			this.setGroupId(DataParser.parse(String.class, map.get(ScoreTplItemValueMeta.GROUP_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ScoreTplItemValueMeta.UPDATE_TIME)));
			this.setMaxScore(DataParser.parse(BigDecimal.class, map.get(ScoreTplItemValueMeta.MAX_SCORE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ScoreTplItemValueMeta.VERSION)));
			this.setItemName(DataParser.parse(String.class, map.get(ScoreTplItemValueMeta.ITEM_NAME)));
			this.setGroupName(DataParser.parse(String.class, map.get(ScoreTplItemValueMeta.GROUP_NAME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ScoreTplItemValueMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ScoreTplItemValueMeta.DELETED)));
			this.setTplItemId(DataParser.parse(String.class, map.get(ScoreTplItemValueMeta.TPL_ITEM_ID)));
			this.setDefScore(DataParser.parse(BigDecimal.class, map.get(ScoreTplItemValueMeta.DEF_SCORE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ScoreTplItemValueMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ScoreTplItemValueMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ScoreTplItemValueMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ScoreTplItemValueMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ScoreTplItemValueMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ScoreTplItemValueMeta.ID)));
			this.setSn(DataParser.parse(Integer.class, map.get(ScoreTplItemValueMeta.SN)));
			this.setTplId(DataParser.parse(String.class, map.get(ScoreTplItemValueMeta.TPL_ID)));
			this.setTaskId(DataParser.parse(String.class, map.get(ScoreTplItemValueMeta.TASK_ID)));
			// others
			this.setScoreGroup(DataParser.parse(DictItem.class, map.get(ScoreTplItemValueMeta.SCORE_GROUP)));
			return true;
		} else {
			try {
				this.setItemType( (String)map.get(ScoreTplItemValueMeta.ITEM_TYPE));
				this.setMinScore( (BigDecimal)map.get(ScoreTplItemValueMeta.MIN_SCORE));
				this.setNotes( (String)map.get(ScoreTplItemValueMeta.NOTES));
				this.setGroupId( (String)map.get(ScoreTplItemValueMeta.GROUP_ID));
				this.setUpdateTime( (Date)map.get(ScoreTplItemValueMeta.UPDATE_TIME));
				this.setMaxScore( (BigDecimal)map.get(ScoreTplItemValueMeta.MAX_SCORE));
				this.setVersion( (Integer)map.get(ScoreTplItemValueMeta.VERSION));
				this.setItemName( (String)map.get(ScoreTplItemValueMeta.ITEM_NAME));
				this.setGroupName( (String)map.get(ScoreTplItemValueMeta.GROUP_NAME));
				this.setCreateBy( (String)map.get(ScoreTplItemValueMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ScoreTplItemValueMeta.DELETED));
				this.setTplItemId( (String)map.get(ScoreTplItemValueMeta.TPL_ITEM_ID));
				this.setDefScore( (BigDecimal)map.get(ScoreTplItemValueMeta.DEF_SCORE));
				this.setCreateTime( (Date)map.get(ScoreTplItemValueMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ScoreTplItemValueMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ScoreTplItemValueMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(ScoreTplItemValueMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ScoreTplItemValueMeta.DELETE_BY));
				this.setId( (String)map.get(ScoreTplItemValueMeta.ID));
				this.setSn( (Integer)map.get(ScoreTplItemValueMeta.SN));
				this.setTplId( (String)map.get(ScoreTplItemValueMeta.TPL_ID));
				this.setTaskId( (String)map.get(ScoreTplItemValueMeta.TASK_ID));
				// others
				this.setScoreGroup( (DictItem)map.get(ScoreTplItemValueMeta.SCORE_GROUP));
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
			this.setItemType(DataParser.parse(String.class, r.getValue(ScoreTplItemValueMeta.ITEM_TYPE)));
			this.setMinScore(DataParser.parse(BigDecimal.class, r.getValue(ScoreTplItemValueMeta.MIN_SCORE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(ScoreTplItemValueMeta.NOTES)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(ScoreTplItemValueMeta.GROUP_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ScoreTplItemValueMeta.UPDATE_TIME)));
			this.setMaxScore(DataParser.parse(BigDecimal.class, r.getValue(ScoreTplItemValueMeta.MAX_SCORE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ScoreTplItemValueMeta.VERSION)));
			this.setItemName(DataParser.parse(String.class, r.getValue(ScoreTplItemValueMeta.ITEM_NAME)));
			this.setGroupName(DataParser.parse(String.class, r.getValue(ScoreTplItemValueMeta.GROUP_NAME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ScoreTplItemValueMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ScoreTplItemValueMeta.DELETED)));
			this.setTplItemId(DataParser.parse(String.class, r.getValue(ScoreTplItemValueMeta.TPL_ITEM_ID)));
			this.setDefScore(DataParser.parse(BigDecimal.class, r.getValue(ScoreTplItemValueMeta.DEF_SCORE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ScoreTplItemValueMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ScoreTplItemValueMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ScoreTplItemValueMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ScoreTplItemValueMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ScoreTplItemValueMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ScoreTplItemValueMeta.ID)));
			this.setSn(DataParser.parse(Integer.class, r.getValue(ScoreTplItemValueMeta.SN)));
			this.setTplId(DataParser.parse(String.class, r.getValue(ScoreTplItemValueMeta.TPL_ID)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(ScoreTplItemValueMeta.TASK_ID)));
			return true;
		} else {
			try {
				this.setItemType( (String)r.getValue(ScoreTplItemValueMeta.ITEM_TYPE));
				this.setMinScore( (BigDecimal)r.getValue(ScoreTplItemValueMeta.MIN_SCORE));
				this.setNotes( (String)r.getValue(ScoreTplItemValueMeta.NOTES));
				this.setGroupId( (String)r.getValue(ScoreTplItemValueMeta.GROUP_ID));
				this.setUpdateTime( (Date)r.getValue(ScoreTplItemValueMeta.UPDATE_TIME));
				this.setMaxScore( (BigDecimal)r.getValue(ScoreTplItemValueMeta.MAX_SCORE));
				this.setVersion( (Integer)r.getValue(ScoreTplItemValueMeta.VERSION));
				this.setItemName( (String)r.getValue(ScoreTplItemValueMeta.ITEM_NAME));
				this.setGroupName( (String)r.getValue(ScoreTplItemValueMeta.GROUP_NAME));
				this.setCreateBy( (String)r.getValue(ScoreTplItemValueMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ScoreTplItemValueMeta.DELETED));
				this.setTplItemId( (String)r.getValue(ScoreTplItemValueMeta.TPL_ITEM_ID));
				this.setDefScore( (BigDecimal)r.getValue(ScoreTplItemValueMeta.DEF_SCORE));
				this.setCreateTime( (Date)r.getValue(ScoreTplItemValueMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ScoreTplItemValueMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ScoreTplItemValueMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(ScoreTplItemValueMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ScoreTplItemValueMeta.DELETE_BY));
				this.setId( (String)r.getValue(ScoreTplItemValueMeta.ID));
				this.setSn( (Integer)r.getValue(ScoreTplItemValueMeta.SN));
				this.setTplId( (String)r.getValue(ScoreTplItemValueMeta.TPL_ID));
				this.setTaskId( (String)r.getValue(ScoreTplItemValueMeta.TASK_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}