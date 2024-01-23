package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_TRANSFER_RCD;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.PersonTransferRcdMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 员工调动记录
 * <p>员工调动记录 , 数据表 hr_person_transfer_rcd 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-22 09:35:13
 * @sign F614C060D702F71EF332C72C6C9B3CEA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_transfer_rcd")
@ApiModel(description = "员工调动记录 ; 员工调动记录 , 数据表 hr_person_transfer_rcd 的PO类型")
public class PersonTransferRcd extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_TRANSFER_RCD.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 调动单：调动单
	*/
	@ApiModelProperty(required = false,value="调动单" , notes = "调动单")
	private String transferId;
	
	/**
	 * 员工：员工
	*/
	@ApiModelProperty(required = false,value="员工" , notes = "员工")
	private String personId;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String content;
	
	/**
	 * 调动日期：调动日期
	*/
	@ApiModelProperty(required = false,value="调动日期" , notes = "调动日期")
	private Date transferDate;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String note;
	
	/**
	 * 操作人：操作人
	*/
	@ApiModelProperty(required = false,value="操作人" , notes = "操作人")
	private String operUserId;
	
	/**
	 * 操作时间：操作时间
	*/
	@ApiModelProperty(required = false,value="操作时间" , notes = "操作时间")
	private Date operTime;
	
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
	public PersonTransferRcd setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 调动单<br>
	 * 调动单
	 * @return 调动单
	*/
	public String getTransferId() {
		return transferId;
	}
	
	/**
	 * 设置 调动单
	 * @param transferId 调动单
	 * @return 当前对象
	*/
	public PersonTransferRcd setTransferId(String transferId) {
		this.transferId=transferId;
		return this;
	}
	
	/**
	 * 获得 员工<br>
	 * 员工
	 * @return 员工
	*/
	public String getPersonId() {
		return personId;
	}
	
	/**
	 * 设置 员工
	 * @param personId 员工
	 * @return 当前对象
	*/
	public PersonTransferRcd setPersonId(String personId) {
		this.personId=personId;
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
	public PersonTransferRcd setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 调动日期<br>
	 * 调动日期
	 * @return 调动日期
	*/
	public Date getTransferDate() {
		return transferDate;
	}
	
	/**
	 * 设置 调动日期
	 * @param transferDate 调动日期
	 * @return 当前对象
	*/
	public PersonTransferRcd setTransferDate(Date transferDate) {
		this.transferDate=transferDate;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNote() {
		return note;
	}
	
	/**
	 * 设置 备注
	 * @param note 备注
	 * @return 当前对象
	*/
	public PersonTransferRcd setNote(String note) {
		this.note=note;
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
	public PersonTransferRcd setOperUserId(String operUserId) {
		this.operUserId=operUserId;
		return this;
	}
	
	/**
	 * 获得 操作时间<br>
	 * 操作时间
	 * @return 操作时间
	*/
	public Date getOperTime() {
		return operTime;
	}
	
	/**
	 * 设置 操作时间
	 * @param operTime 操作时间
	 * @return 当前对象
	*/
	public PersonTransferRcd setOperTime(Date operTime) {
		this.operTime=operTime;
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
	public PersonTransferRcd setCreateBy(String createBy) {
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
	public PersonTransferRcd setCreateTime(Date createTime) {
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
	public PersonTransferRcd setUpdateBy(String updateBy) {
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
	public PersonTransferRcd setUpdateTime(Date updateTime) {
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
	public PersonTransferRcd setDeleted(Integer deleted) {
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
	public PersonTransferRcd setDeleted(Boolean deletedBool) {
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
	public PersonTransferRcd setDeleteBy(String deleteBy) {
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
	public PersonTransferRcd setDeleteTime(Date deleteTime) {
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
	public PersonTransferRcd setVersion(Integer version) {
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
	public PersonTransferRcd setPerson(Person person) {
		this.person=person;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonTransferRcd , 转换好的 PersonTransferRcd 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonTransferRcd , 转换好的 PoJo 对象
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
	public PersonTransferRcd clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonTransferRcd duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonTransferRcdMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonTransferRcdMeta.$$proxy$$();
		inst.setNote(this.getNote());
		inst.setOperUserId(this.getOperUserId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setTransferId(this.getTransferId());
		inst.setTransferDate(this.getTransferDate());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setId(this.getId());
		inst.setOperTime(this.getOperTime());
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
	public PersonTransferRcd clone(boolean deep) {
		return EntityContext.clone(PersonTransferRcd.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonTransferRcd
	 * @param personTransferRcdMap 包含实体信息的 Map 对象
	 * @return PersonTransferRcd , 转换好的的 PersonTransferRcd 对象
	*/
	@Transient
	public static PersonTransferRcd createFrom(Map<String,Object> personTransferRcdMap) {
		if(personTransferRcdMap==null) return null;
		PersonTransferRcd po = create();
		EntityContext.copyProperties(po,personTransferRcdMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonTransferRcd
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonTransferRcd , 转换好的的 PersonTransferRcd 对象
	*/
	@Transient
	public static PersonTransferRcd createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonTransferRcd po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonTransferRcd，等同于 new
	 * @return PersonTransferRcd 对象
	*/
	@Transient
	public static PersonTransferRcd create() {
		return new com.dt.platform.domain.hr.meta.PersonTransferRcdMeta.$$proxy$$();
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
			this.setNote(DataParser.parse(String.class, map.get(PersonTransferRcdMeta.NOTE)));
			this.setOperUserId(DataParser.parse(String.class, map.get(PersonTransferRcdMeta.OPER_USER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonTransferRcdMeta.UPDATE_TIME)));
			this.setTransferId(DataParser.parse(String.class, map.get(PersonTransferRcdMeta.TRANSFER_ID)));
			this.setTransferDate(DataParser.parse(Date.class, map.get(PersonTransferRcdMeta.TRANSFER_DATE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonTransferRcdMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(PersonTransferRcdMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonTransferRcdMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonTransferRcdMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonTransferRcdMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonTransferRcdMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonTransferRcdMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonTransferRcdMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(PersonTransferRcdMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(PersonTransferRcdMeta.ID)));
			this.setOperTime(DataParser.parse(Date.class, map.get(PersonTransferRcdMeta.OPER_TIME)));
			// others
			this.setPerson(DataParser.parse(Person.class, map.get(PersonTransferRcdMeta.PERSON)));
			return true;
		} else {
			try {
				this.setNote( (String)map.get(PersonTransferRcdMeta.NOTE));
				this.setOperUserId( (String)map.get(PersonTransferRcdMeta.OPER_USER_ID));
				this.setUpdateTime( (Date)map.get(PersonTransferRcdMeta.UPDATE_TIME));
				this.setTransferId( (String)map.get(PersonTransferRcdMeta.TRANSFER_ID));
				this.setTransferDate( (Date)map.get(PersonTransferRcdMeta.TRANSFER_DATE));
				this.setVersion( (Integer)map.get(PersonTransferRcdMeta.VERSION));
				this.setContent( (String)map.get(PersonTransferRcdMeta.CONTENT));
				this.setCreateBy( (String)map.get(PersonTransferRcdMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonTransferRcdMeta.DELETED));
				this.setCreateTime( (Date)map.get(PersonTransferRcdMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonTransferRcdMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonTransferRcdMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(PersonTransferRcdMeta.DELETE_BY));
				this.setPersonId( (String)map.get(PersonTransferRcdMeta.PERSON_ID));
				this.setId( (String)map.get(PersonTransferRcdMeta.ID));
				this.setOperTime( (Date)map.get(PersonTransferRcdMeta.OPER_TIME));
				// others
				this.setPerson( (Person)map.get(PersonTransferRcdMeta.PERSON));
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
			this.setNote(DataParser.parse(String.class, r.getValue(PersonTransferRcdMeta.NOTE)));
			this.setOperUserId(DataParser.parse(String.class, r.getValue(PersonTransferRcdMeta.OPER_USER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonTransferRcdMeta.UPDATE_TIME)));
			this.setTransferId(DataParser.parse(String.class, r.getValue(PersonTransferRcdMeta.TRANSFER_ID)));
			this.setTransferDate(DataParser.parse(Date.class, r.getValue(PersonTransferRcdMeta.TRANSFER_DATE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonTransferRcdMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(PersonTransferRcdMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonTransferRcdMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonTransferRcdMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonTransferRcdMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonTransferRcdMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonTransferRcdMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonTransferRcdMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(PersonTransferRcdMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonTransferRcdMeta.ID)));
			this.setOperTime(DataParser.parse(Date.class, r.getValue(PersonTransferRcdMeta.OPER_TIME)));
			return true;
		} else {
			try {
				this.setNote( (String)r.getValue(PersonTransferRcdMeta.NOTE));
				this.setOperUserId( (String)r.getValue(PersonTransferRcdMeta.OPER_USER_ID));
				this.setUpdateTime( (Date)r.getValue(PersonTransferRcdMeta.UPDATE_TIME));
				this.setTransferId( (String)r.getValue(PersonTransferRcdMeta.TRANSFER_ID));
				this.setTransferDate( (Date)r.getValue(PersonTransferRcdMeta.TRANSFER_DATE));
				this.setVersion( (Integer)r.getValue(PersonTransferRcdMeta.VERSION));
				this.setContent( (String)r.getValue(PersonTransferRcdMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(PersonTransferRcdMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonTransferRcdMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PersonTransferRcdMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonTransferRcdMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonTransferRcdMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(PersonTransferRcdMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(PersonTransferRcdMeta.PERSON_ID));
				this.setId( (String)r.getValue(PersonTransferRcdMeta.ID));
				this.setOperTime( (Date)r.getValue(PersonTransferRcdMeta.OPER_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}