package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ATTENDANCE_OVERTIME;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.AttendanceOvertimeMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 加班管理
 * <p>加班管理 , 数据表 hr_attendance_overtime 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-16 20:54:15
 * @sign 24670E306472D8E54B6D48389E11BC0B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_attendance_overtime")
@ApiModel(description = "加班管理 ; 加班管理 , 数据表 hr_attendance_overtime 的PO类型")
public class AttendanceOvertime extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ATTENDANCE_OVERTIME.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "810966884433264640")
	private String id;
	
	/**
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员" , example = "808426740073365504")
	private String personId;
	
	/**
	 * 加班日期：加班日期
	*/
	@ApiModelProperty(required = false,value="加班日期" , notes = "加班日期" , example = "2024-02-16 12:00:00")
	private Date actionDate;
	
	/**
	 * 加班类型：加班类型
	*/
	@ApiModelProperty(required = false,value="加班类型" , notes = "加班类型" , example = "jjr")
	private String actionType;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间" , example = "2024-02-16 12:00:00")
	private Date actionSTime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间" , example = "2024-02-23 12:00:00")
	private Date actionETime;
	
	/**
	 * 加班小时：加班小时
	*/
	@ApiModelProperty(required = false,value="加班小时" , notes = "加班小时" , example = "0.00")
	private BigDecimal actionHour;
	
	/**
	 * 加班备注：加班备注
	*/
	@ApiModelProperty(required = false,value="加班备注" , notes = "加班备注" , example = "121212")
	private String notes;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String fileId;
	
	/**
	 * 批次号：批次号
	*/
	@ApiModelProperty(required = false,value="批次号" , notes = "批次号")
	private String batchCode;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-16 08:12:52")
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "1")
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
	 * person：person
	*/
	@ApiModelProperty(required = false,value="person" , notes = "person")
	private Person person;
	
	/**
	 * personJobNumber：personJobNumber
	*/
	@ApiModelProperty(required = false,value="personJobNumber" , notes = "personJobNumber")
	private String personJobNumber;
	
	/**
	 * sOrgId：sOrgId
	*/
	@ApiModelProperty(required = false,value="sOrgId" , notes = "sOrgId")
	private String sOrgId;
	
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
	public AttendanceOvertime setId(String id) {
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
	public AttendanceOvertime setPersonId(String personId) {
		this.personId=personId;
		return this;
	}
	
	/**
	 * 获得 加班日期<br>
	 * 加班日期
	 * @return 加班日期
	*/
	public Date getActionDate() {
		return actionDate;
	}
	
	/**
	 * 设置 加班日期
	 * @param actionDate 加班日期
	 * @return 当前对象
	*/
	public AttendanceOvertime setActionDate(Date actionDate) {
		this.actionDate=actionDate;
		return this;
	}
	
	/**
	 * 获得 加班类型<br>
	 * 加班类型
	 * @return 加班类型
	*/
	public String getActionType() {
		return actionType;
	}
	
	/**
	 * 设置 加班类型
	 * @param actionType 加班类型
	 * @return 当前对象
	*/
	public AttendanceOvertime setActionType(String actionType) {
		this.actionType=actionType;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getActionSTime() {
		return actionSTime;
	}
	
	/**
	 * 设置 开始时间
	 * @param actionSTime 开始时间
	 * @return 当前对象
	*/
	public AttendanceOvertime setActionSTime(Date actionSTime) {
		this.actionSTime=actionSTime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getActionETime() {
		return actionETime;
	}
	
	/**
	 * 设置 结束时间
	 * @param actionETime 结束时间
	 * @return 当前对象
	*/
	public AttendanceOvertime setActionETime(Date actionETime) {
		this.actionETime=actionETime;
		return this;
	}
	
	/**
	 * 获得 加班小时<br>
	 * 加班小时
	 * @return 加班小时
	*/
	public BigDecimal getActionHour() {
		return actionHour;
	}
	
	/**
	 * 设置 加班小时
	 * @param actionHour 加班小时
	 * @return 当前对象
	*/
	public AttendanceOvertime setActionHour(BigDecimal actionHour) {
		this.actionHour=actionHour;
		return this;
	}
	
	/**
	 * 获得 加班备注<br>
	 * 加班备注
	 * @return 加班备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 加班备注
	 * @param notes 加班备注
	 * @return 当前对象
	*/
	public AttendanceOvertime setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 附件
	 * @param fileId 附件
	 * @return 当前对象
	*/
	public AttendanceOvertime setFileId(String fileId) {
		this.fileId=fileId;
		return this;
	}
	
	/**
	 * 获得 批次号<br>
	 * 批次号
	 * @return 批次号
	*/
	public String getBatchCode() {
		return batchCode;
	}
	
	/**
	 * 设置 批次号
	 * @param batchCode 批次号
	 * @return 当前对象
	*/
	public AttendanceOvertime setBatchCode(String batchCode) {
		this.batchCode=batchCode;
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
	public AttendanceOvertime setCreateBy(String createBy) {
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
	public AttendanceOvertime setCreateTime(Date createTime) {
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
	public AttendanceOvertime setUpdateBy(String updateBy) {
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
	public AttendanceOvertime setUpdateTime(Date updateTime) {
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
	public AttendanceOvertime setDeleted(Integer deleted) {
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
	public AttendanceOvertime setDeleted(Boolean deletedBool) {
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
	public AttendanceOvertime setDeleteBy(String deleteBy) {
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
	public AttendanceOvertime setDeleteTime(Date deleteTime) {
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
	public AttendanceOvertime setVersion(Integer version) {
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
	public AttendanceOvertime setTenantId(String tenantId) {
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
	public AttendanceOvertime setTypeDict(DictItem typeDict) {
		this.typeDict=typeDict;
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
	public AttendanceOvertime setPerson(Person person) {
		this.person=person;
		return this;
	}
	
	/**
	 * 获得 personJobNumber<br>
	 * personJobNumber
	 * @return personJobNumber
	*/
	public String getPersonJobNumber() {
		return personJobNumber;
	}
	
	/**
	 * 设置 personJobNumber
	 * @param personJobNumber personJobNumber
	 * @return 当前对象
	*/
	public AttendanceOvertime setPersonJobNumber(String personJobNumber) {
		this.personJobNumber=personJobNumber;
		return this;
	}
	
	/**
	 * 获得 sOrgId<br>
	 * sOrgId
	 * @return sOrgId
	*/
	public String getSOrgId() {
		return sOrgId;
	}
	
	/**
	 * 设置 sOrgId
	 * @param sOrgId sOrgId
	 * @return 当前对象
	*/
	public AttendanceOvertime setSOrgId(String sOrgId) {
		this.sOrgId=sOrgId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AttendanceOvertime , 转换好的 AttendanceOvertime 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AttendanceOvertime , 转换好的 PoJo 对象
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
	public AttendanceOvertime clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AttendanceOvertime duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AttendanceOvertimeMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AttendanceOvertimeMeta.$$proxy$$();
		inst.setActionHour(this.getActionHour());
		inst.setNotes(this.getNotes());
		inst.setActionSTime(this.getActionSTime());
		inst.setBatchCode(this.getBatchCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setActionType(this.getActionType());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setActionETime(this.getActionETime());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setId(this.getId());
		inst.setActionDate(this.getActionDate());
		inst.setFileId(this.getFileId());
		if(all) {
			inst.setPerson(this.getPerson());
			inst.setSOrgId(this.getSOrgId());
			inst.setTypeDict(this.getTypeDict());
			inst.setPersonJobNumber(this.getPersonJobNumber());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AttendanceOvertime clone(boolean deep) {
		return EntityContext.clone(AttendanceOvertime.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AttendanceOvertime
	 * @param attendanceOvertimeMap 包含实体信息的 Map 对象
	 * @return AttendanceOvertime , 转换好的的 AttendanceOvertime 对象
	*/
	@Transient
	public static AttendanceOvertime createFrom(Map<String,Object> attendanceOvertimeMap) {
		if(attendanceOvertimeMap==null) return null;
		AttendanceOvertime po = create();
		EntityContext.copyProperties(po,attendanceOvertimeMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AttendanceOvertime
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AttendanceOvertime , 转换好的的 AttendanceOvertime 对象
	*/
	@Transient
	public static AttendanceOvertime createFrom(Object pojo) {
		if(pojo==null) return null;
		AttendanceOvertime po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AttendanceOvertime，等同于 new
	 * @return AttendanceOvertime 对象
	*/
	@Transient
	public static AttendanceOvertime create() {
		return new com.dt.platform.domain.hr.meta.AttendanceOvertimeMeta.$$proxy$$();
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
			this.setActionHour(DataParser.parse(BigDecimal.class, map.get(AttendanceOvertimeMeta.ACTION_HOUR)));
			this.setNotes(DataParser.parse(String.class, map.get(AttendanceOvertimeMeta.NOTES)));
			this.setActionSTime(DataParser.parse(Date.class, map.get(AttendanceOvertimeMeta.ACTION_S_TIME)));
			this.setBatchCode(DataParser.parse(String.class, map.get(AttendanceOvertimeMeta.BATCH_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AttendanceOvertimeMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AttendanceOvertimeMeta.VERSION)));
			this.setActionType(DataParser.parse(String.class, map.get(AttendanceOvertimeMeta.ACTION_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AttendanceOvertimeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AttendanceOvertimeMeta.DELETED)));
			this.setActionETime(DataParser.parse(Date.class, map.get(AttendanceOvertimeMeta.ACTION_E_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AttendanceOvertimeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AttendanceOvertimeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AttendanceOvertimeMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AttendanceOvertimeMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AttendanceOvertimeMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(AttendanceOvertimeMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(AttendanceOvertimeMeta.ID)));
			this.setActionDate(DataParser.parse(Date.class, map.get(AttendanceOvertimeMeta.ACTION_DATE)));
			this.setFileId(DataParser.parse(String.class, map.get(AttendanceOvertimeMeta.FILE_ID)));
			// others
			this.setPerson(DataParser.parse(Person.class, map.get(AttendanceOvertimeMeta.PERSON)));
			this.setSOrgId(DataParser.parse(String.class, map.get(AttendanceOvertimeMeta.S_ORG_ID)));
			this.setTypeDict(DataParser.parse(DictItem.class, map.get(AttendanceOvertimeMeta.TYPE_DICT)));
			this.setPersonJobNumber(DataParser.parse(String.class, map.get(AttendanceOvertimeMeta.PERSON_JOB_NUMBER)));
			return true;
		} else {
			try {
				this.setActionHour( (BigDecimal)map.get(AttendanceOvertimeMeta.ACTION_HOUR));
				this.setNotes( (String)map.get(AttendanceOvertimeMeta.NOTES));
				this.setActionSTime( (Date)map.get(AttendanceOvertimeMeta.ACTION_S_TIME));
				this.setBatchCode( (String)map.get(AttendanceOvertimeMeta.BATCH_CODE));
				this.setUpdateTime( (Date)map.get(AttendanceOvertimeMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AttendanceOvertimeMeta.VERSION));
				this.setActionType( (String)map.get(AttendanceOvertimeMeta.ACTION_TYPE));
				this.setCreateBy( (String)map.get(AttendanceOvertimeMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AttendanceOvertimeMeta.DELETED));
				this.setActionETime( (Date)map.get(AttendanceOvertimeMeta.ACTION_E_TIME));
				this.setCreateTime( (Date)map.get(AttendanceOvertimeMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AttendanceOvertimeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AttendanceOvertimeMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(AttendanceOvertimeMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AttendanceOvertimeMeta.DELETE_BY));
				this.setPersonId( (String)map.get(AttendanceOvertimeMeta.PERSON_ID));
				this.setId( (String)map.get(AttendanceOvertimeMeta.ID));
				this.setActionDate( (Date)map.get(AttendanceOvertimeMeta.ACTION_DATE));
				this.setFileId( (String)map.get(AttendanceOvertimeMeta.FILE_ID));
				// others
				this.setPerson( (Person)map.get(AttendanceOvertimeMeta.PERSON));
				this.setSOrgId( (String)map.get(AttendanceOvertimeMeta.S_ORG_ID));
				this.setTypeDict( (DictItem)map.get(AttendanceOvertimeMeta.TYPE_DICT));
				this.setPersonJobNumber( (String)map.get(AttendanceOvertimeMeta.PERSON_JOB_NUMBER));
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
			this.setActionHour(DataParser.parse(BigDecimal.class, r.getValue(AttendanceOvertimeMeta.ACTION_HOUR)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AttendanceOvertimeMeta.NOTES)));
			this.setActionSTime(DataParser.parse(Date.class, r.getValue(AttendanceOvertimeMeta.ACTION_S_TIME)));
			this.setBatchCode(DataParser.parse(String.class, r.getValue(AttendanceOvertimeMeta.BATCH_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AttendanceOvertimeMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AttendanceOvertimeMeta.VERSION)));
			this.setActionType(DataParser.parse(String.class, r.getValue(AttendanceOvertimeMeta.ACTION_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AttendanceOvertimeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AttendanceOvertimeMeta.DELETED)));
			this.setActionETime(DataParser.parse(Date.class, r.getValue(AttendanceOvertimeMeta.ACTION_E_TIME)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AttendanceOvertimeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AttendanceOvertimeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AttendanceOvertimeMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AttendanceOvertimeMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AttendanceOvertimeMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(AttendanceOvertimeMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(AttendanceOvertimeMeta.ID)));
			this.setActionDate(DataParser.parse(Date.class, r.getValue(AttendanceOvertimeMeta.ACTION_DATE)));
			this.setFileId(DataParser.parse(String.class, r.getValue(AttendanceOvertimeMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setActionHour( (BigDecimal)r.getValue(AttendanceOvertimeMeta.ACTION_HOUR));
				this.setNotes( (String)r.getValue(AttendanceOvertimeMeta.NOTES));
				this.setActionSTime( (Date)r.getValue(AttendanceOvertimeMeta.ACTION_S_TIME));
				this.setBatchCode( (String)r.getValue(AttendanceOvertimeMeta.BATCH_CODE));
				this.setUpdateTime( (Date)r.getValue(AttendanceOvertimeMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AttendanceOvertimeMeta.VERSION));
				this.setActionType( (String)r.getValue(AttendanceOvertimeMeta.ACTION_TYPE));
				this.setCreateBy( (String)r.getValue(AttendanceOvertimeMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AttendanceOvertimeMeta.DELETED));
				this.setActionETime( (Date)r.getValue(AttendanceOvertimeMeta.ACTION_E_TIME));
				this.setCreateTime( (Date)r.getValue(AttendanceOvertimeMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AttendanceOvertimeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AttendanceOvertimeMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(AttendanceOvertimeMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AttendanceOvertimeMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(AttendanceOvertimeMeta.PERSON_ID));
				this.setId( (String)r.getValue(AttendanceOvertimeMeta.ID));
				this.setActionDate( (Date)r.getValue(AttendanceOvertimeMeta.ACTION_DATE));
				this.setFileId( (String)r.getValue(AttendanceOvertimeMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}