package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_SCORE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.PersonScoreMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 积分明细
 * <p>积分明细 , 数据表 hr_person_score 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-22 09:34:36
 * @sign 8612D8E65E75A479D43226C7D52A023B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_score")
@ApiModel(description = "积分明细 ; 积分明细 , 数据表 hr_person_score 的PO类型")
public class PersonScore extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_SCORE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员")
	private String personId;
	
	/**
	 * 操作：操作
	*/
	@ApiModelProperty(required = false,value="操作" , notes = "操作")
	private String operTypeId;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private String type;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String content;
	
	/**
	 * 积分：积分
	*/
	@ApiModelProperty(required = false,value="积分" , notes = "积分")
	private Integer score;
	
	/**
	 * 操作人：操作人
	*/
	@ApiModelProperty(required = false,value="操作人" , notes = "操作人")
	private String operUserId;
	
	/**
	 * 操作时间：操作时间
	*/
	@ApiModelProperty(required = false,value="操作时间" , notes = "操作时间")
	private Date rcdTime;
	
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
	 * person：person
	*/
	@ApiModelProperty(required = false,value="person" , notes = "person")
	private Person person;
	
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
	public PersonScore setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 人员<br>
	 * 人员
	 * @return 人员
	*/
	public String getPersonId() {
		return personId;
	}
	
	/**
	 * 设置 人员
	 * @param personId 人员
	 * @return 当前对象
	*/
	public PersonScore setPersonId(String personId) {
		this.personId=personId;
		return this;
	}
	
	/**
	 * 获得 操作<br>
	 * 操作
	 * @return 操作
	*/
	public String getOperTypeId() {
		return operTypeId;
	}
	
	/**
	 * 设置 操作
	 * @param operTypeId 操作
	 * @return 当前对象
	*/
	public PersonScore setOperTypeId(String operTypeId) {
		this.operTypeId=operTypeId;
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
	public PersonScore setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 内容
	 * @param content 内容
	 * @return 当前对象
	*/
	public PersonScore setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 积分<br>
	 * 积分
	 * @return 积分
	*/
	public Integer getScore() {
		return score;
	}
	
	/**
	 * 设置 积分
	 * @param score 积分
	 * @return 当前对象
	*/
	public PersonScore setScore(Integer score) {
		this.score=score;
		return this;
	}
	
	/**
	 * 获得 操作人<br>
	 * 操作人
	 * @return 操作人
	*/
	public String getOperUserId() {
		return operUserId;
	}
	
	/**
	 * 设置 操作人
	 * @param operUserId 操作人
	 * @return 当前对象
	*/
	public PersonScore setOperUserId(String operUserId) {
		this.operUserId=operUserId;
		return this;
	}
	
	/**
	 * 获得 操作时间<br>
	 * 操作时间
	 * @return 操作时间
	*/
	public Date getRcdTime() {
		return rcdTime;
	}
	
	/**
	 * 设置 操作时间
	 * @param rcdTime 操作时间
	 * @return 当前对象
	*/
	public PersonScore setRcdTime(Date rcdTime) {
		this.rcdTime=rcdTime;
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
	public PersonScore setCreateBy(String createBy) {
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
	public PersonScore setCreateTime(Date createTime) {
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
	public PersonScore setUpdateBy(String updateBy) {
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
	public PersonScore setUpdateTime(Date updateTime) {
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
	public PersonScore setDeleted(Integer deleted) {
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
	public PersonScore setDeleted(Boolean deletedBool) {
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
	public PersonScore setDeleteBy(String deleteBy) {
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
	public PersonScore setDeleteTime(Date deleteTime) {
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
	public PersonScore setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 person<br>
	 * person
	 * @return person
	*/
	public Person getPerson() {
		return person;
	}
	
	/**
	 * 设置 person
	 * @param person person
	 * @return 当前对象
	*/
	public PersonScore setPerson(Person person) {
		this.person=person;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonScore , 转换好的 PersonScore 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonScore , 转换好的 PoJo 对象
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
	public PersonScore clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonScore duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonScoreMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonScoreMeta.$$proxy$$();
		inst.setOperUserId(this.getOperUserId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setScore(this.getScore());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setOperTypeId(this.getOperTypeId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setId(this.getId());
		inst.setRcdTime(this.getRcdTime());
		if(all) {
			inst.setPerson(this.getPerson());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonScore clone(boolean deep) {
		return EntityContext.clone(PersonScore.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonScore
	 * @param personScoreMap 包含实体信息的 Map 对象
	 * @return PersonScore , 转换好的的 PersonScore 对象
	*/
	@Transient
	public static PersonScore createFrom(Map<String,Object> personScoreMap) {
		if(personScoreMap==null) return null;
		PersonScore po = create();
		EntityContext.copyProperties(po,personScoreMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonScore
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonScore , 转换好的的 PersonScore 对象
	*/
	@Transient
	public static PersonScore createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonScore po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonScore，等同于 new
	 * @return PersonScore 对象
	*/
	@Transient
	public static PersonScore create() {
		return new com.dt.platform.domain.hr.meta.PersonScoreMeta.$$proxy$$();
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
			this.setOperUserId(DataParser.parse(String.class, map.get(PersonScoreMeta.OPER_USER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonScoreMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(PersonScoreMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonScoreMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(PersonScoreMeta.CONTENT)));
			this.setScore(DataParser.parse(Integer.class, map.get(PersonScoreMeta.SCORE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonScoreMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonScoreMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonScoreMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonScoreMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonScoreMeta.DELETE_TIME)));
			this.setOperTypeId(DataParser.parse(String.class, map.get(PersonScoreMeta.OPER_TYPE_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonScoreMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(PersonScoreMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(PersonScoreMeta.ID)));
			this.setRcdTime(DataParser.parse(Date.class, map.get(PersonScoreMeta.RCD_TIME)));
			// others
			this.setPerson(DataParser.parse(Person.class, map.get(PersonScoreMeta.PERSON)));
			return true;
		} else {
			try {
				this.setOperUserId( (String)map.get(PersonScoreMeta.OPER_USER_ID));
				this.setUpdateTime( (Date)map.get(PersonScoreMeta.UPDATE_TIME));
				this.setType( (String)map.get(PersonScoreMeta.TYPE));
				this.setVersion( (Integer)map.get(PersonScoreMeta.VERSION));
				this.setContent( (String)map.get(PersonScoreMeta.CONTENT));
				this.setScore( (Integer)map.get(PersonScoreMeta.SCORE));
				this.setCreateBy( (String)map.get(PersonScoreMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonScoreMeta.DELETED));
				this.setCreateTime( (Date)map.get(PersonScoreMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonScoreMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonScoreMeta.DELETE_TIME));
				this.setOperTypeId( (String)map.get(PersonScoreMeta.OPER_TYPE_ID));
				this.setDeleteBy( (String)map.get(PersonScoreMeta.DELETE_BY));
				this.setPersonId( (String)map.get(PersonScoreMeta.PERSON_ID));
				this.setId( (String)map.get(PersonScoreMeta.ID));
				this.setRcdTime( (Date)map.get(PersonScoreMeta.RCD_TIME));
				// others
				this.setPerson( (Person)map.get(PersonScoreMeta.PERSON));
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
			this.setOperUserId(DataParser.parse(String.class, r.getValue(PersonScoreMeta.OPER_USER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonScoreMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(PersonScoreMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonScoreMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(PersonScoreMeta.CONTENT)));
			this.setScore(DataParser.parse(Integer.class, r.getValue(PersonScoreMeta.SCORE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonScoreMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonScoreMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonScoreMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonScoreMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonScoreMeta.DELETE_TIME)));
			this.setOperTypeId(DataParser.parse(String.class, r.getValue(PersonScoreMeta.OPER_TYPE_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonScoreMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(PersonScoreMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonScoreMeta.ID)));
			this.setRcdTime(DataParser.parse(Date.class, r.getValue(PersonScoreMeta.RCD_TIME)));
			return true;
		} else {
			try {
				this.setOperUserId( (String)r.getValue(PersonScoreMeta.OPER_USER_ID));
				this.setUpdateTime( (Date)r.getValue(PersonScoreMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(PersonScoreMeta.TYPE));
				this.setVersion( (Integer)r.getValue(PersonScoreMeta.VERSION));
				this.setContent( (String)r.getValue(PersonScoreMeta.CONTENT));
				this.setScore( (Integer)r.getValue(PersonScoreMeta.SCORE));
				this.setCreateBy( (String)r.getValue(PersonScoreMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonScoreMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PersonScoreMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonScoreMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonScoreMeta.DELETE_TIME));
				this.setOperTypeId( (String)r.getValue(PersonScoreMeta.OPER_TYPE_ID));
				this.setDeleteBy( (String)r.getValue(PersonScoreMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(PersonScoreMeta.PERSON_ID));
				this.setId( (String)r.getValue(PersonScoreMeta.ID));
				this.setRcdTime( (Date)r.getValue(PersonScoreMeta.RCD_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}