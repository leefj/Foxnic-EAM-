package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_TRANSFER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Organization;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.PersonTransferMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 员工调动
 * <p>员工调动 , 数据表 hr_person_transfer 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-23 20:44:23
 * @sign 31ABD7D567CBEA893175F77379392F44
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_transfer")
@ApiModel(description = "员工调动 ; 员工调动 , 数据表 hr_person_transfer 的PO类型")
public class PersonTransfer extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_TRANSFER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "801816370407800832")
	private String id;
	
	/**
	 * 编号：编号
	*/
	@ApiModelProperty(required = false,value="编号" , notes = "编号")
	private String businessCode;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 调动日期：调动日期
	*/
	@ApiModelProperty(required = false,value="调动日期" , notes = "调动日期" , example = "2024-01-10 12:00:00")
	private Date transferDate;
	
	/**
	 * 原因：原因
	*/
	@ApiModelProperty(required = false,value="原因" , notes = "原因" , example = "12")
	private String content;
	
	/**
	 * 部门：部门
	*/
	@ApiModelProperty(required = false,value="部门" , notes = "部门" , example = "788871090188320766")
	private String orgId;
	
	/**
	 * 岗位：岗位
	*/
	@ApiModelProperty(required = false,value="岗位" , notes = "岗位")
	private String positionCode;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String fileIds;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "121212")
	private String note;
	
	/**
	 * 操作人：操作人
	*/
	@ApiModelProperty(required = false,value="操作人" , notes = "操作人")
	private String operUserId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-01-22 02:12:00")
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
	 * personList：personList
	*/
	@ApiModelProperty(required = false,value="personList" , notes = "personList")
	private List<Person> personList;
	
	/**
	 * personIds：personIds
	*/
	@ApiModelProperty(required = false,value="personIds" , notes = "personIds")
	private List<String> personIds;
	
	/**
	 * position：position
	*/
	@ApiModelProperty(required = false,value="position" , notes = "position")
	private Position position;
	
	/**
	 * 所在部门：所在部门
	*/
	@ApiModelProperty(required = false,value="所在部门" , notes = "所在部门")
	private Organization organization;
	
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
	public PersonTransfer setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编号<br>
	 * 编号
	 * @return 编号
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 编号
	 * @param businessCode 编号
	 * @return 当前对象
	*/
	public PersonTransfer setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
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
	public PersonTransfer setStatus(String status) {
		this.status=status;
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
	public PersonTransfer setTransferDate(Date transferDate) {
		this.transferDate=transferDate;
		return this;
	}
	
	/**
	 * 获得 原因<br>
	 * 原因
	 * @return 原因
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 原因
	 * @param content 原因
	 * @return 当前对象
	*/
	public PersonTransfer setContent(String content) {
		this.content=content;
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
	public PersonTransfer setOrgId(String orgId) {
		this.orgId=orgId;
		return this;
	}
	
	/**
	 * 获得 岗位<br>
	 * 岗位
	 * @return 岗位
	*/
	public String getPositionCode() {
		return positionCode;
	}
	
	/**
	 * 设置 岗位
	 * @param positionCode 岗位
	 * @return 当前对象
	*/
	public PersonTransfer setPositionCode(String positionCode) {
		this.positionCode=positionCode;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getFileIds() {
		return fileIds;
	}
	
	/**
	 * 设置 附件
	 * @param fileIds 附件
	 * @return 当前对象
	*/
	public PersonTransfer setFileIds(String fileIds) {
		this.fileIds=fileIds;
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
	public PersonTransfer setNote(String note) {
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
	public PersonTransfer setOperUserId(String operUserId) {
		this.operUserId=operUserId;
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
	public PersonTransfer setCreateBy(String createBy) {
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
	public PersonTransfer setCreateTime(Date createTime) {
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
	public PersonTransfer setUpdateBy(String updateBy) {
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
	public PersonTransfer setUpdateTime(Date updateTime) {
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
	public PersonTransfer setDeleted(Integer deleted) {
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
	public PersonTransfer setDeleted(Boolean deletedBool) {
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
	public PersonTransfer setDeleteBy(String deleteBy) {
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
	public PersonTransfer setDeleteTime(Date deleteTime) {
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
	public PersonTransfer setVersion(Integer version) {
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
	public PersonTransfer setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 personList<br>
	 * personList
	 * @return personList
	*/
	public List<Person> getPersonList() {
		return personList;
	}
	
	/**
	 * 设置 personList
	 * @param personList personList
	 * @return 当前对象
	*/
	public PersonTransfer setPersonList(List<Person> personList) {
		this.personList=personList;
		return this;
	}
	
	/**
	 * 添加 personList
	 * @param person personList
	 * @return 当前对象
	*/
	public PersonTransfer addPerson(Person... person) {
		if(this.personList==null) personList=new ArrayList<>();
		this.personList.addAll(Arrays.asList(person));
		return this;
	}
	
	/**
	 * 获得 personIds<br>
	 * personIds
	 * @return personIds
	*/
	public List<String> getPersonIds() {
		return personIds;
	}
	
	/**
	 * 设置 personIds
	 * @param personIds personIds
	 * @return 当前对象
	*/
	public PersonTransfer setPersonIds(List<String> personIds) {
		this.personIds=personIds;
		return this;
	}
	
	/**
	 * 添加 personIds
	 * @param personId personIds
	 * @return 当前对象
	*/
	public PersonTransfer addPersonId(String... personId) {
		if(this.personIds==null) personIds=new ArrayList<>();
		this.personIds.addAll(Arrays.asList(personId));
		return this;
	}
	
	/**
	 * 获得 position<br>
	 * position
	 * @return position
	*/
	public Position getPosition() {
		return position;
	}
	
	/**
	 * 设置 position
	 * @param position position
	 * @return 当前对象
	*/
	public PersonTransfer setPosition(Position position) {
		this.position=position;
		return this;
	}
	
	/**
	 * 获得 所在部门<br>
	 * 所在部门
	 * @return 所在部门
	*/
	public Organization getOrganization() {
		return organization;
	}
	
	/**
	 * 设置 所在部门
	 * @param organization 所在部门
	 * @return 当前对象
	*/
	public PersonTransfer setOrganization(Organization organization) {
		this.organization=organization;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonTransfer , 转换好的 PersonTransfer 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonTransfer , 转换好的 PoJo 对象
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
	public PersonTransfer clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonTransfer duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonTransferMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonTransferMeta.$$proxy$$();
		inst.setNote(this.getNote());
		inst.setOperUserId(this.getOperUserId());
		inst.setPositionCode(this.getPositionCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setTransferDate(this.getTransferDate());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setOrgId(this.getOrgId());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setFileIds(this.getFileIds());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setPersonList(this.getPersonList());
			inst.setOrganization(this.getOrganization());
			inst.setPersonIds(this.getPersonIds());
			inst.setPosition(this.getPosition());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonTransfer clone(boolean deep) {
		return EntityContext.clone(PersonTransfer.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonTransfer
	 * @param personTransferMap 包含实体信息的 Map 对象
	 * @return PersonTransfer , 转换好的的 PersonTransfer 对象
	*/
	@Transient
	public static PersonTransfer createFrom(Map<String,Object> personTransferMap) {
		if(personTransferMap==null) return null;
		PersonTransfer po = create();
		EntityContext.copyProperties(po,personTransferMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonTransfer
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonTransfer , 转换好的的 PersonTransfer 对象
	*/
	@Transient
	public static PersonTransfer createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonTransfer po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonTransfer，等同于 new
	 * @return PersonTransfer 对象
	*/
	@Transient
	public static PersonTransfer create() {
		return new com.dt.platform.domain.hr.meta.PersonTransferMeta.$$proxy$$();
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
			this.setNote(DataParser.parse(String.class, map.get(PersonTransferMeta.NOTE)));
			this.setOperUserId(DataParser.parse(String.class, map.get(PersonTransferMeta.OPER_USER_ID)));
			this.setPositionCode(DataParser.parse(String.class, map.get(PersonTransferMeta.POSITION_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonTransferMeta.UPDATE_TIME)));
			this.setTransferDate(DataParser.parse(Date.class, map.get(PersonTransferMeta.TRANSFER_DATE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonTransferMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(PersonTransferMeta.CONTENT)));
			this.setOrgId(DataParser.parse(String.class, map.get(PersonTransferMeta.ORG_ID)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(PersonTransferMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonTransferMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonTransferMeta.DELETED)));
			this.setFileIds(DataParser.parse(String.class, map.get(PersonTransferMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonTransferMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonTransferMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonTransferMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonTransferMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonTransferMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PersonTransferMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonTransferMeta.STATUS)));
			// others
			this.setOrganization(DataParser.parse(Organization.class, map.get(PersonTransferMeta.ORGANIZATION)));
			this.setPosition(DataParser.parse(Position.class, map.get(PersonTransferMeta.POSITION)));
			return true;
		} else {
			try {
				this.setNote( (String)map.get(PersonTransferMeta.NOTE));
				this.setOperUserId( (String)map.get(PersonTransferMeta.OPER_USER_ID));
				this.setPositionCode( (String)map.get(PersonTransferMeta.POSITION_CODE));
				this.setUpdateTime( (Date)map.get(PersonTransferMeta.UPDATE_TIME));
				this.setTransferDate( (Date)map.get(PersonTransferMeta.TRANSFER_DATE));
				this.setVersion( (Integer)map.get(PersonTransferMeta.VERSION));
				this.setContent( (String)map.get(PersonTransferMeta.CONTENT));
				this.setOrgId( (String)map.get(PersonTransferMeta.ORG_ID));
				this.setBusinessCode( (String)map.get(PersonTransferMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(PersonTransferMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonTransferMeta.DELETED));
				this.setFileIds( (String)map.get(PersonTransferMeta.FILE_IDS));
				this.setCreateTime( (Date)map.get(PersonTransferMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonTransferMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonTransferMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(PersonTransferMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonTransferMeta.DELETE_BY));
				this.setId( (String)map.get(PersonTransferMeta.ID));
				this.setStatus( (String)map.get(PersonTransferMeta.STATUS));
				// others
				this.setOrganization( (Organization)map.get(PersonTransferMeta.ORGANIZATION));
				this.setPosition( (Position)map.get(PersonTransferMeta.POSITION));
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
			this.setNote(DataParser.parse(String.class, r.getValue(PersonTransferMeta.NOTE)));
			this.setOperUserId(DataParser.parse(String.class, r.getValue(PersonTransferMeta.OPER_USER_ID)));
			this.setPositionCode(DataParser.parse(String.class, r.getValue(PersonTransferMeta.POSITION_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonTransferMeta.UPDATE_TIME)));
			this.setTransferDate(DataParser.parse(Date.class, r.getValue(PersonTransferMeta.TRANSFER_DATE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonTransferMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(PersonTransferMeta.CONTENT)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(PersonTransferMeta.ORG_ID)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(PersonTransferMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonTransferMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonTransferMeta.DELETED)));
			this.setFileIds(DataParser.parse(String.class, r.getValue(PersonTransferMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonTransferMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonTransferMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonTransferMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonTransferMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonTransferMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonTransferMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonTransferMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNote( (String)r.getValue(PersonTransferMeta.NOTE));
				this.setOperUserId( (String)r.getValue(PersonTransferMeta.OPER_USER_ID));
				this.setPositionCode( (String)r.getValue(PersonTransferMeta.POSITION_CODE));
				this.setUpdateTime( (Date)r.getValue(PersonTransferMeta.UPDATE_TIME));
				this.setTransferDate( (Date)r.getValue(PersonTransferMeta.TRANSFER_DATE));
				this.setVersion( (Integer)r.getValue(PersonTransferMeta.VERSION));
				this.setContent( (String)r.getValue(PersonTransferMeta.CONTENT));
				this.setOrgId( (String)r.getValue(PersonTransferMeta.ORG_ID));
				this.setBusinessCode( (String)r.getValue(PersonTransferMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(PersonTransferMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonTransferMeta.DELETED));
				this.setFileIds( (String)r.getValue(PersonTransferMeta.FILE_IDS));
				this.setCreateTime( (Date)r.getValue(PersonTransferMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonTransferMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonTransferMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(PersonTransferMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonTransferMeta.DELETE_BY));
				this.setId( (String)r.getValue(PersonTransferMeta.ID));
				this.setStatus( (String)r.getValue(PersonTransferMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}