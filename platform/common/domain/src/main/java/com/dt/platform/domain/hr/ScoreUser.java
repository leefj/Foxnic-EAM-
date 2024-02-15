package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_SCORE_USER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.ScoreUserMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考评用户
 * <p>考评用户 , 数据表 hr_score_user 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-14 17:36:10
 * @sign 183B3903179B8C96E40F8577E9E8998A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_score_user")
@ApiModel(description = "考评用户 ; 考评用户 , 数据表 hr_score_user 的PO类型")
public class ScoreUser extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_SCORE_USER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 任务：任务
	*/
	@ApiModelProperty(required = false,value="任务" , notes = "任务")
	private String instId;
	
	/**
	 * 部门：部门
	*/
	@ApiModelProperty(required = false,value="部门" , notes = "部门")
	private String orgId;
	
	/**
	 * 关系：关系
	*/
	@ApiModelProperty(required = false,value="关系" , notes = "关系")
	private String relationship;
	
	/**
	 * 考评卷：考评卷
	*/
	@ApiModelProperty(required = false,value="考评卷" , notes = "考评卷")
	private String tplId;
	
	/**
	 * 评价人：评价人
	*/
	@ApiModelProperty(required = false,value="评价人" , notes = "评价人")
	private String raterId;
	
	/**
	 * 被评价人：被评价人
	*/
	@ApiModelProperty(required = false,value="被评价人" , notes = "被评价人")
	private String ratedId;
	
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
	 * organization：organization
	*/
	@ApiModelProperty(required = false,value="organization" , notes = "organization")
	private Organization organization;
	
	/**
	 * raterUser：raterUser
	*/
	@ApiModelProperty(required = false,value="raterUser" , notes = "raterUser")
	private Person raterUser;
	
	/**
	 * ratedUser：ratedUser
	*/
	@ApiModelProperty(required = false,value="ratedUser" , notes = "ratedUser")
	private Person ratedUser;
	
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
	public ScoreUser setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 任务<br>
	 * 任务
	 * @return 任务
	*/
	public String getInstId() {
		return instId;
	}
	
	/**
	 * 设置 任务
	 * @param instId 任务
	 * @return 当前对象
	*/
	public ScoreUser setInstId(String instId) {
		this.instId=instId;
		return this;
	}
	
	/**
	 * 获得 部门<br>
	 * 部门
	 * @return 部门
	*/
	public String getOrgId() {
		return orgId;
	}
	
	/**
	 * 设置 部门
	 * @param orgId 部门
	 * @return 当前对象
	*/
	public ScoreUser setOrgId(String orgId) {
		this.orgId=orgId;
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
	public ScoreUser setRelationship(String relationship) {
		this.relationship=relationship;
		return this;
	}
	
	/**
	 * 获得 考评卷<br>
	 * 考评卷
	 * @return 考评卷
	*/
	public String getTplId() {
		return tplId;
	}
	
	/**
	 * 设置 考评卷
	 * @param tplId 考评卷
	 * @return 当前对象
	*/
	public ScoreUser setTplId(String tplId) {
		this.tplId=tplId;
		return this;
	}
	
	/**
	 * 获得 评价人<br>
	 * 评价人
	 * @return 评价人
	*/
	public String getRaterId() {
		return raterId;
	}
	
	/**
	 * 设置 评价人
	 * @param raterId 评价人
	 * @return 当前对象
	*/
	public ScoreUser setRaterId(String raterId) {
		this.raterId=raterId;
		return this;
	}
	
	/**
	 * 获得 被评价人<br>
	 * 被评价人
	 * @return 被评价人
	*/
	public String getRatedId() {
		return ratedId;
	}
	
	/**
	 * 设置 被评价人
	 * @param ratedId 被评价人
	 * @return 当前对象
	*/
	public ScoreUser setRatedId(String ratedId) {
		this.ratedId=ratedId;
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
	public ScoreUser setNotes(String notes) {
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
	public ScoreUser setCreateBy(String createBy) {
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
	public ScoreUser setCreateTime(Date createTime) {
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
	public ScoreUser setUpdateBy(String updateBy) {
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
	public ScoreUser setUpdateTime(Date updateTime) {
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
	public ScoreUser setDeleted(Integer deleted) {
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
	public ScoreUser setDeleted(Boolean deletedBool) {
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
	public ScoreUser setDeleteBy(String deleteBy) {
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
	public ScoreUser setDeleteTime(Date deleteTime) {
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
	public ScoreUser setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 organization<br>
	 * organization
	 * @return organization
	*/
	public Organization getOrganization() {
		return organization;
	}
	
	/**
	 * 设置 organization
	 * @param organization organization
	 * @return 当前对象
	*/
	public ScoreUser setOrganization(Organization organization) {
		this.organization=organization;
		return this;
	}
	
	/**
	 * 获得 raterUser<br>
	 * raterUser
	 * @return raterUser
	*/
	public Person getRaterUser() {
		return raterUser;
	}
	
	/**
	 * 设置 raterUser
	 * @param raterUser raterUser
	 * @return 当前对象
	*/
	public ScoreUser setRaterUser(Person raterUser) {
		this.raterUser=raterUser;
		return this;
	}
	
	/**
	 * 获得 ratedUser<br>
	 * ratedUser
	 * @return ratedUser
	*/
	public Person getRatedUser() {
		return ratedUser;
	}
	
	/**
	 * 设置 ratedUser
	 * @param ratedUser ratedUser
	 * @return 当前对象
	*/
	public ScoreUser setRatedUser(Person ratedUser) {
		this.ratedUser=ratedUser;
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
	public ScoreUser setScoreTpl(ScoreTpl scoreTpl) {
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
	public ScoreUser setEvaluationRelation(EvaluationRelation evaluationRelation) {
		this.evaluationRelation=evaluationRelation;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ScoreUser , 转换好的 ScoreUser 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ScoreUser , 转换好的 PoJo 对象
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
	public ScoreUser clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ScoreUser duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.ScoreUserMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.ScoreUserMeta.$$proxy$$();
		inst.setRatedId(this.getRatedId());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setOrgId(this.getOrgId());
		inst.setInstId(this.getInstId());
		inst.setCreateBy(this.getCreateBy());
		inst.setRaterId(this.getRaterId());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setRelationship(this.getRelationship());
		inst.setTplId(this.getTplId());
		if(all) {
			inst.setScoreTpl(this.getScoreTpl());
			inst.setEvaluationRelation(this.getEvaluationRelation());
			inst.setOrganization(this.getOrganization());
			inst.setRaterUser(this.getRaterUser());
			inst.setRatedUser(this.getRatedUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ScoreUser clone(boolean deep) {
		return EntityContext.clone(ScoreUser.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ScoreUser
	 * @param scoreUserMap 包含实体信息的 Map 对象
	 * @return ScoreUser , 转换好的的 ScoreUser 对象
	*/
	@Transient
	public static ScoreUser createFrom(Map<String,Object> scoreUserMap) {
		if(scoreUserMap==null) return null;
		ScoreUser po = create();
		EntityContext.copyProperties(po,scoreUserMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ScoreUser
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ScoreUser , 转换好的的 ScoreUser 对象
	*/
	@Transient
	public static ScoreUser createFrom(Object pojo) {
		if(pojo==null) return null;
		ScoreUser po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ScoreUser，等同于 new
	 * @return ScoreUser 对象
	*/
	@Transient
	public static ScoreUser create() {
		return new com.dt.platform.domain.hr.meta.ScoreUserMeta.$$proxy$$();
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
			this.setRatedId(DataParser.parse(String.class, map.get(ScoreUserMeta.RATED_ID)));
			this.setNotes(DataParser.parse(String.class, map.get(ScoreUserMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ScoreUserMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ScoreUserMeta.VERSION)));
			this.setOrgId(DataParser.parse(String.class, map.get(ScoreUserMeta.ORG_ID)));
			this.setInstId(DataParser.parse(String.class, map.get(ScoreUserMeta.INST_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ScoreUserMeta.CREATE_BY)));
			this.setRaterId(DataParser.parse(String.class, map.get(ScoreUserMeta.RATER_ID)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ScoreUserMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ScoreUserMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ScoreUserMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ScoreUserMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ScoreUserMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ScoreUserMeta.ID)));
			this.setRelationship(DataParser.parse(String.class, map.get(ScoreUserMeta.RELATIONSHIP)));
			this.setTplId(DataParser.parse(String.class, map.get(ScoreUserMeta.TPL_ID)));
			// others
			this.setScoreTpl(DataParser.parse(ScoreTpl.class, map.get(ScoreUserMeta.SCORE_TPL)));
			this.setEvaluationRelation(DataParser.parse(EvaluationRelation.class, map.get(ScoreUserMeta.EVALUATION_RELATION)));
			this.setOrganization(DataParser.parse(Organization.class, map.get(ScoreUserMeta.ORGANIZATION)));
			this.setRaterUser(DataParser.parse(Person.class, map.get(ScoreUserMeta.RATER_USER)));
			this.setRatedUser(DataParser.parse(Person.class, map.get(ScoreUserMeta.RATED_USER)));
			return true;
		} else {
			try {
				this.setRatedId( (String)map.get(ScoreUserMeta.RATED_ID));
				this.setNotes( (String)map.get(ScoreUserMeta.NOTES));
				this.setUpdateTime( (Date)map.get(ScoreUserMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(ScoreUserMeta.VERSION));
				this.setOrgId( (String)map.get(ScoreUserMeta.ORG_ID));
				this.setInstId( (String)map.get(ScoreUserMeta.INST_ID));
				this.setCreateBy( (String)map.get(ScoreUserMeta.CREATE_BY));
				this.setRaterId( (String)map.get(ScoreUserMeta.RATER_ID));
				this.setDeleted( (Integer)map.get(ScoreUserMeta.DELETED));
				this.setCreateTime( (Date)map.get(ScoreUserMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ScoreUserMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ScoreUserMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(ScoreUserMeta.DELETE_BY));
				this.setId( (String)map.get(ScoreUserMeta.ID));
				this.setRelationship( (String)map.get(ScoreUserMeta.RELATIONSHIP));
				this.setTplId( (String)map.get(ScoreUserMeta.TPL_ID));
				// others
				this.setScoreTpl( (ScoreTpl)map.get(ScoreUserMeta.SCORE_TPL));
				this.setEvaluationRelation( (EvaluationRelation)map.get(ScoreUserMeta.EVALUATION_RELATION));
				this.setOrganization( (Organization)map.get(ScoreUserMeta.ORGANIZATION));
				this.setRaterUser( (Person)map.get(ScoreUserMeta.RATER_USER));
				this.setRatedUser( (Person)map.get(ScoreUserMeta.RATED_USER));
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
			this.setRatedId(DataParser.parse(String.class, r.getValue(ScoreUserMeta.RATED_ID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(ScoreUserMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ScoreUserMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ScoreUserMeta.VERSION)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(ScoreUserMeta.ORG_ID)));
			this.setInstId(DataParser.parse(String.class, r.getValue(ScoreUserMeta.INST_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ScoreUserMeta.CREATE_BY)));
			this.setRaterId(DataParser.parse(String.class, r.getValue(ScoreUserMeta.RATER_ID)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ScoreUserMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ScoreUserMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ScoreUserMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ScoreUserMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ScoreUserMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ScoreUserMeta.ID)));
			this.setRelationship(DataParser.parse(String.class, r.getValue(ScoreUserMeta.RELATIONSHIP)));
			this.setTplId(DataParser.parse(String.class, r.getValue(ScoreUserMeta.TPL_ID)));
			return true;
		} else {
			try {
				this.setRatedId( (String)r.getValue(ScoreUserMeta.RATED_ID));
				this.setNotes( (String)r.getValue(ScoreUserMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(ScoreUserMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(ScoreUserMeta.VERSION));
				this.setOrgId( (String)r.getValue(ScoreUserMeta.ORG_ID));
				this.setInstId( (String)r.getValue(ScoreUserMeta.INST_ID));
				this.setCreateBy( (String)r.getValue(ScoreUserMeta.CREATE_BY));
				this.setRaterId( (String)r.getValue(ScoreUserMeta.RATER_ID));
				this.setDeleted( (Integer)r.getValue(ScoreUserMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ScoreUserMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ScoreUserMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ScoreUserMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(ScoreUserMeta.DELETE_BY));
				this.setId( (String)r.getValue(ScoreUserMeta.ID));
				this.setRelationship( (String)r.getValue(ScoreUserMeta.RELATIONSHIP));
				this.setTplId( (String)r.getValue(ScoreUserMeta.TPL_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}