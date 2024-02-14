package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ATTENDANCE_YEAR_DAY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.AttendanceYearDayMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 年假记录
 * <p>年假记录 , 数据表 hr_attendance_year_day 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-13 23:07:05
 * @sign 6A0999DC271A6DC40ACDBF48B10A5D56
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_attendance_year_day")
@ApiModel(description = "年假记录 ; 年假记录 , 数据表 hr_attendance_year_day 的PO类型")
public class AttendanceYearDay extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ATTENDANCE_YEAR_DAY.$TABLE;
	
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
	 * 开始日期：开始日期
	*/
	@ApiModelProperty(required = false,value="开始日期" , notes = "开始日期")
	private Date sdate;
	
	/**
	 * 结束日期：结束日期
	*/
	@ApiModelProperty(required = false,value="结束日期" , notes = "结束日期")
	private String edate;
	
	/**
	 * 本周期：本周期
	*/
	@ApiModelProperty(required = false,value="本周期" , notes = "本周期")
	private BigDecimal days;
	
	/**
	 * 上一周期：上一周期
	*/
	@ApiModelProperty(required = false,value="上一周期" , notes = "上一周期")
	private BigDecimal lastDays;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 批次号：批次号
	*/
	@ApiModelProperty(required = false,value="批次号" , notes = "批次号")
	private String batchCode;
	
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
	public AttendanceYearDay setId(String id) {
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
	public AttendanceYearDay setPersonId(String personId) {
		this.personId=personId;
		return this;
	}
	
	/**
	 * 获得 开始日期<br>
	 * 开始日期
	 * @return 开始日期
	*/
	public Date getSdate() {
		return sdate;
	}
	
	/**
	 * 设置 开始日期
	 * @param sdate 开始日期
	 * @return 当前对象
	*/
	public AttendanceYearDay setSdate(Date sdate) {
		this.sdate=sdate;
		return this;
	}
	
	/**
	 * 获得 结束日期<br>
	 * 结束日期
	 * @return 结束日期
	*/
	public String getEdate() {
		return edate;
	}
	
	/**
	 * 设置 结束日期
	 * @param edate 结束日期
	 * @return 当前对象
	*/
	public AttendanceYearDay setEdate(String edate) {
		this.edate=edate;
		return this;
	}
	
	/**
	 * 获得 本周期<br>
	 * 本周期
	 * @return 本周期
	*/
	public BigDecimal getDays() {
		return days;
	}
	
	/**
	 * 设置 本周期
	 * @param days 本周期
	 * @return 当前对象
	*/
	public AttendanceYearDay setDays(BigDecimal days) {
		this.days=days;
		return this;
	}
	
	/**
	 * 获得 上一周期<br>
	 * 上一周期
	 * @return 上一周期
	*/
	public BigDecimal getLastDays() {
		return lastDays;
	}
	
	/**
	 * 设置 上一周期
	 * @param lastDays 上一周期
	 * @return 当前对象
	*/
	public AttendanceYearDay setLastDays(BigDecimal lastDays) {
		this.lastDays=lastDays;
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
	public AttendanceYearDay setNotes(String notes) {
		this.notes=notes;
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
	public AttendanceYearDay setBatchCode(String batchCode) {
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
	public AttendanceYearDay setCreateBy(String createBy) {
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
	public AttendanceYearDay setCreateTime(Date createTime) {
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
	public AttendanceYearDay setUpdateBy(String updateBy) {
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
	public AttendanceYearDay setUpdateTime(Date updateTime) {
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
	public AttendanceYearDay setDeleted(Integer deleted) {
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
	public AttendanceYearDay setDeleted(Boolean deletedBool) {
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
	public AttendanceYearDay setDeleteBy(String deleteBy) {
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
	public AttendanceYearDay setDeleteTime(Date deleteTime) {
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
	public AttendanceYearDay setVersion(Integer version) {
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
	public AttendanceYearDay setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public AttendanceYearDay setPerson(Person person) {
		this.person=person;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AttendanceYearDay , 转换好的 AttendanceYearDay 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AttendanceYearDay , 转换好的 PoJo 对象
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
	public AttendanceYearDay clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AttendanceYearDay duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AttendanceYearDayMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AttendanceYearDayMeta.$$proxy$$();
		inst.setSdate(this.getSdate());
		inst.setNotes(this.getNotes());
		inst.setBatchCode(this.getBatchCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setEdate(this.getEdate());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setLastDays(this.getLastDays());
		inst.setTenantId(this.getTenantId());
		inst.setDays(this.getDays());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setId(this.getId());
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
	public AttendanceYearDay clone(boolean deep) {
		return EntityContext.clone(AttendanceYearDay.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AttendanceYearDay
	 * @param attendanceYearDayMap 包含实体信息的 Map 对象
	 * @return AttendanceYearDay , 转换好的的 AttendanceYearDay 对象
	*/
	@Transient
	public static AttendanceYearDay createFrom(Map<String,Object> attendanceYearDayMap) {
		if(attendanceYearDayMap==null) return null;
		AttendanceYearDay po = create();
		EntityContext.copyProperties(po,attendanceYearDayMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AttendanceYearDay
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AttendanceYearDay , 转换好的的 AttendanceYearDay 对象
	*/
	@Transient
	public static AttendanceYearDay createFrom(Object pojo) {
		if(pojo==null) return null;
		AttendanceYearDay po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AttendanceYearDay，等同于 new
	 * @return AttendanceYearDay 对象
	*/
	@Transient
	public static AttendanceYearDay create() {
		return new com.dt.platform.domain.hr.meta.AttendanceYearDayMeta.$$proxy$$();
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
			this.setSdate(DataParser.parse(Date.class, map.get(AttendanceYearDayMeta.SDATE)));
			this.setNotes(DataParser.parse(String.class, map.get(AttendanceYearDayMeta.NOTES)));
			this.setBatchCode(DataParser.parse(String.class, map.get(AttendanceYearDayMeta.BATCH_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AttendanceYearDayMeta.UPDATE_TIME)));
			this.setEdate(DataParser.parse(String.class, map.get(AttendanceYearDayMeta.EDATE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AttendanceYearDayMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AttendanceYearDayMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AttendanceYearDayMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AttendanceYearDayMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AttendanceYearDayMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AttendanceYearDayMeta.DELETE_TIME)));
			this.setLastDays(DataParser.parse(BigDecimal.class, map.get(AttendanceYearDayMeta.LAST_DAYS)));
			this.setTenantId(DataParser.parse(String.class, map.get(AttendanceYearDayMeta.TENANT_ID)));
			this.setDays(DataParser.parse(BigDecimal.class, map.get(AttendanceYearDayMeta.DAYS)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AttendanceYearDayMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(AttendanceYearDayMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(AttendanceYearDayMeta.ID)));
			// others
			this.setPerson(DataParser.parse(Person.class, map.get(AttendanceYearDayMeta.PERSON)));
			return true;
		} else {
			try {
				this.setSdate( (Date)map.get(AttendanceYearDayMeta.SDATE));
				this.setNotes( (String)map.get(AttendanceYearDayMeta.NOTES));
				this.setBatchCode( (String)map.get(AttendanceYearDayMeta.BATCH_CODE));
				this.setUpdateTime( (Date)map.get(AttendanceYearDayMeta.UPDATE_TIME));
				this.setEdate( (String)map.get(AttendanceYearDayMeta.EDATE));
				this.setVersion( (Integer)map.get(AttendanceYearDayMeta.VERSION));
				this.setCreateBy( (String)map.get(AttendanceYearDayMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AttendanceYearDayMeta.DELETED));
				this.setCreateTime( (Date)map.get(AttendanceYearDayMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AttendanceYearDayMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AttendanceYearDayMeta.DELETE_TIME));
				this.setLastDays( (BigDecimal)map.get(AttendanceYearDayMeta.LAST_DAYS));
				this.setTenantId( (String)map.get(AttendanceYearDayMeta.TENANT_ID));
				this.setDays( (BigDecimal)map.get(AttendanceYearDayMeta.DAYS));
				this.setDeleteBy( (String)map.get(AttendanceYearDayMeta.DELETE_BY));
				this.setPersonId( (String)map.get(AttendanceYearDayMeta.PERSON_ID));
				this.setId( (String)map.get(AttendanceYearDayMeta.ID));
				// others
				this.setPerson( (Person)map.get(AttendanceYearDayMeta.PERSON));
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
			this.setSdate(DataParser.parse(Date.class, r.getValue(AttendanceYearDayMeta.SDATE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AttendanceYearDayMeta.NOTES)));
			this.setBatchCode(DataParser.parse(String.class, r.getValue(AttendanceYearDayMeta.BATCH_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AttendanceYearDayMeta.UPDATE_TIME)));
			this.setEdate(DataParser.parse(String.class, r.getValue(AttendanceYearDayMeta.EDATE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AttendanceYearDayMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AttendanceYearDayMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AttendanceYearDayMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AttendanceYearDayMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AttendanceYearDayMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AttendanceYearDayMeta.DELETE_TIME)));
			this.setLastDays(DataParser.parse(BigDecimal.class, r.getValue(AttendanceYearDayMeta.LAST_DAYS)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AttendanceYearDayMeta.TENANT_ID)));
			this.setDays(DataParser.parse(BigDecimal.class, r.getValue(AttendanceYearDayMeta.DAYS)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AttendanceYearDayMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(AttendanceYearDayMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(AttendanceYearDayMeta.ID)));
			return true;
		} else {
			try {
				this.setSdate( (Date)r.getValue(AttendanceYearDayMeta.SDATE));
				this.setNotes( (String)r.getValue(AttendanceYearDayMeta.NOTES));
				this.setBatchCode( (String)r.getValue(AttendanceYearDayMeta.BATCH_CODE));
				this.setUpdateTime( (Date)r.getValue(AttendanceYearDayMeta.UPDATE_TIME));
				this.setEdate( (String)r.getValue(AttendanceYearDayMeta.EDATE));
				this.setVersion( (Integer)r.getValue(AttendanceYearDayMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AttendanceYearDayMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AttendanceYearDayMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AttendanceYearDayMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AttendanceYearDayMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AttendanceYearDayMeta.DELETE_TIME));
				this.setLastDays( (BigDecimal)r.getValue(AttendanceYearDayMeta.LAST_DAYS));
				this.setTenantId( (String)r.getValue(AttendanceYearDayMeta.TENANT_ID));
				this.setDays( (BigDecimal)r.getValue(AttendanceYearDayMeta.DAYS));
				this.setDeleteBy( (String)r.getValue(AttendanceYearDayMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(AttendanceYearDayMeta.PERSON_ID));
				this.setId( (String)r.getValue(AttendanceYearDayMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}