package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_SCORE_TASK_INST;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.ScoreTaskInstMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 任务配置记录
 * <p>任务配置记录 , 数据表 hr_score_task_inst 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-14 20:23:39
 * @sign 8AC2A3B49AA8017740CEA28551EA1C40
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_score_task_inst")
@ApiModel(description = "任务配置记录 ; 任务配置记录 , 数据表 hr_score_task_inst 的PO类型")
public class ScoreTaskInst extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_SCORE_TASK_INST.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "810204985697501184")
	private String id;
	
	/**
	 * 任务：任务
	*/
	@ApiModelProperty(required = false,value="任务" , notes = "任务")
	private String confId;
	
	/**
	 * 评分卷：评分卷
	*/
	@ApiModelProperty(required = false,value="评分卷" , notes = "评分卷" , example = "809164670802853888")
	private String tplId;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "12")
	private String name;
	
	/**
	 * 关系：关系
	*/
	@ApiModelProperty(required = false,value="关系" , notes = "关系" , example = "same_level,higher_level,lower_level")
	private String relationship;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-14 05:45:21")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-02-14 05:45:35")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "2")
	private Integer version;
	
	/**
	 * scoreTpl：scoreTpl
	*/
	@ApiModelProperty(required = false,value="scoreTpl" , notes = "scoreTpl")
	private ScoreTpl scoreTpl;
	
	/**
	 * evaluationRelation：evaluationRelation
	*/
	@ApiModelProperty(required = false,value="evaluationRelation" , notes = "evaluationRelation")
	private EvaluationRelation evaluationRelation;
	
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
	public ScoreTaskInst setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 任务<br>
	 * 任务
	 * @return 任务
	*/
	public String getConfId() {
		return confId;
	}
	
	/**
	 * 设置 任务
	 * @param confId 任务
	 * @return 当前对象
	*/
	public ScoreTaskInst setConfId(String confId) {
		this.confId=confId;
		return this;
	}
	
	/**
	 * 获得 评分卷<br>
	 * 评分卷
	 * @return 评分卷
	*/
	public String getTplId() {
		return tplId;
	}
	
	/**
	 * 设置 评分卷
	 * @param tplId 评分卷
	 * @return 当前对象
	*/
	public ScoreTaskInst setTplId(String tplId) {
		this.tplId=tplId;
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
	public ScoreTaskInst setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 关系<br>
	 * 关系
	 * @return 关系
	*/
	public String getRelationship() {
		return relationship;
	}
	
	/**
	 * 设置 关系
	 * @param relationship 关系
	 * @return 当前对象
	*/
	public ScoreTaskInst setRelationship(String relationship) {
		this.relationship=relationship;
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
	public ScoreTaskInst setNotes(String notes) {
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
	public ScoreTaskInst setCreateBy(String createBy) {
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
	public ScoreTaskInst setCreateTime(Date createTime) {
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
	public ScoreTaskInst setUpdateBy(String updateBy) {
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
	public ScoreTaskInst setUpdateTime(Date updateTime) {
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
	public ScoreTaskInst setDeleted(Integer deleted) {
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
	public ScoreTaskInst setDeleted(Boolean deletedBool) {
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
	public ScoreTaskInst setDeleteBy(String deleteBy) {
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
	public ScoreTaskInst setDeleteTime(Date deleteTime) {
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
	public ScoreTaskInst setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 scoreTpl<br>
	 * scoreTpl
	 * @return scoreTpl
	*/
	public ScoreTpl getScoreTpl() {
		return scoreTpl;
	}
	
	/**
	 * 设置 scoreTpl
	 * @param scoreTpl scoreTpl
	 * @return 当前对象
	*/
	public ScoreTaskInst setScoreTpl(ScoreTpl scoreTpl) {
		this.scoreTpl=scoreTpl;
		return this;
	}
	
	/**
	 * 获得 evaluationRelation<br>
	 * evaluationRelation
	 * @return evaluationRelation
	*/
	public EvaluationRelation getEvaluationRelation() {
		return evaluationRelation;
	}
	
	/**
	 * 设置 evaluationRelation
	 * @param evaluationRelation evaluationRelation
	 * @return 当前对象
	*/
	public ScoreTaskInst setEvaluationRelation(EvaluationRelation evaluationRelation) {
		this.evaluationRelation=evaluationRelation;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ScoreTaskInst , 转换好的 ScoreTaskInst 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ScoreTaskInst , 转换好的 PoJo 对象
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
	public ScoreTaskInst clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ScoreTaskInst duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.ScoreTaskInstMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.ScoreTaskInstMeta.$$proxy$$();
		inst.setConfId(this.getConfId());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTplId(this.getTplId());
		inst.setRelationship(this.getRelationship());
		if(all) {
			inst.setScoreTpl(this.getScoreTpl());
			inst.setEvaluationRelation(this.getEvaluationRelation());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ScoreTaskInst clone(boolean deep) {
		return EntityContext.clone(ScoreTaskInst.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ScoreTaskInst
	 * @param scoreTaskInstMap 包含实体信息的 Map 对象
	 * @return ScoreTaskInst , 转换好的的 ScoreTaskInst 对象
	*/
	@Transient
	public static ScoreTaskInst createFrom(Map<String,Object> scoreTaskInstMap) {
		if(scoreTaskInstMap==null) return null;
		ScoreTaskInst po = create();
		EntityContext.copyProperties(po,scoreTaskInstMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ScoreTaskInst
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ScoreTaskInst , 转换好的的 ScoreTaskInst 对象
	*/
	@Transient
	public static ScoreTaskInst createFrom(Object pojo) {
		if(pojo==null) return null;
		ScoreTaskInst po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ScoreTaskInst，等同于 new
	 * @return ScoreTaskInst 对象
	*/
	@Transient
	public static ScoreTaskInst create() {
		return new com.dt.platform.domain.hr.meta.ScoreTaskInstMeta.$$proxy$$();
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
			this.setConfId(DataParser.parse(String.class, map.get(ScoreTaskInstMeta.CONF_ID)));
			this.setNotes(DataParser.parse(String.class, map.get(ScoreTaskInstMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ScoreTaskInstMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ScoreTaskInstMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ScoreTaskInstMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ScoreTaskInstMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ScoreTaskInstMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ScoreTaskInstMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ScoreTaskInstMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(ScoreTaskInstMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ScoreTaskInstMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ScoreTaskInstMeta.ID)));
			this.setTplId(DataParser.parse(String.class, map.get(ScoreTaskInstMeta.TPL_ID)));
			this.setRelationship(DataParser.parse(String.class, map.get(ScoreTaskInstMeta.RELATIONSHIP)));
			// others
			this.setScoreTpl(DataParser.parse(ScoreTpl.class, map.get(ScoreTaskInstMeta.SCORE_TPL)));
			this.setEvaluationRelation(DataParser.parse(EvaluationRelation.class, map.get(ScoreTaskInstMeta.EVALUATION_RELATION)));
			return true;
		} else {
			try {
				this.setConfId( (String)map.get(ScoreTaskInstMeta.CONF_ID));
				this.setNotes( (String)map.get(ScoreTaskInstMeta.NOTES));
				this.setUpdateTime( (Date)map.get(ScoreTaskInstMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(ScoreTaskInstMeta.VERSION));
				this.setCreateBy( (String)map.get(ScoreTaskInstMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ScoreTaskInstMeta.DELETED));
				this.setCreateTime( (Date)map.get(ScoreTaskInstMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ScoreTaskInstMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ScoreTaskInstMeta.DELETE_TIME));
				this.setName( (String)map.get(ScoreTaskInstMeta.NAME));
				this.setDeleteBy( (String)map.get(ScoreTaskInstMeta.DELETE_BY));
				this.setId( (String)map.get(ScoreTaskInstMeta.ID));
				this.setTplId( (String)map.get(ScoreTaskInstMeta.TPL_ID));
				this.setRelationship( (String)map.get(ScoreTaskInstMeta.RELATIONSHIP));
				// others
				this.setScoreTpl( (ScoreTpl)map.get(ScoreTaskInstMeta.SCORE_TPL));
				this.setEvaluationRelation( (EvaluationRelation)map.get(ScoreTaskInstMeta.EVALUATION_RELATION));
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
			this.setConfId(DataParser.parse(String.class, r.getValue(ScoreTaskInstMeta.CONF_ID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(ScoreTaskInstMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ScoreTaskInstMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ScoreTaskInstMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ScoreTaskInstMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ScoreTaskInstMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ScoreTaskInstMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ScoreTaskInstMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ScoreTaskInstMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(ScoreTaskInstMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ScoreTaskInstMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ScoreTaskInstMeta.ID)));
			this.setTplId(DataParser.parse(String.class, r.getValue(ScoreTaskInstMeta.TPL_ID)));
			this.setRelationship(DataParser.parse(String.class, r.getValue(ScoreTaskInstMeta.RELATIONSHIP)));
			return true;
		} else {
			try {
				this.setConfId( (String)r.getValue(ScoreTaskInstMeta.CONF_ID));
				this.setNotes( (String)r.getValue(ScoreTaskInstMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(ScoreTaskInstMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(ScoreTaskInstMeta.VERSION));
				this.setCreateBy( (String)r.getValue(ScoreTaskInstMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ScoreTaskInstMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ScoreTaskInstMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ScoreTaskInstMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ScoreTaskInstMeta.DELETE_TIME));
				this.setName( (String)r.getValue(ScoreTaskInstMeta.NAME));
				this.setDeleteBy( (String)r.getValue(ScoreTaskInstMeta.DELETE_BY));
				this.setId( (String)r.getValue(ScoreTaskInstMeta.ID));
				this.setTplId( (String)r.getValue(ScoreTaskInstMeta.TPL_ID));
				this.setRelationship( (String)r.getValue(ScoreTaskInstMeta.RELATIONSHIP));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}