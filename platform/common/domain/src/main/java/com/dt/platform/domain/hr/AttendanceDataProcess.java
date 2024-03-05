package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ATTENDANCE_DATA_PROCESS;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.AttendanceDataProcessMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 处理记录
 * <p>处理记录 , 数据表 hr_attendance_data_process 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-26 09:54:30
 * @sign CAE21C30DFFB91021D59B83EE3271F47
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_attendance_data_process")
@ApiModel(description = "处理记录 ; 处理记录 , 数据表 hr_attendance_data_process 的PO类型")
public class AttendanceDataProcess extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ATTENDANCE_DATA_PROCESS.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "814413143928209408")
	private String id;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "process_failed")
	private String status;
	
	/**
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员" , example = "801565609459449857")
	private String personId;
	
	/**
	 * 考勤日期：考勤日期
	*/
	@ApiModelProperty(required = false,value="考勤日期" , notes = "考勤日期")
	private Date kqRq;
	
	/**
	 * 处理时间：处理时间
	*/
	@ApiModelProperty(required = false,value="处理时间" , notes = "处理时间" , example = "2024-02-26 08:27:05")
	private Date processDate;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "失败,没有配置考勤组。")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-26 08:27:05")
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
	public AttendanceDataProcess setId(String id) {
		this.id=id;
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
	public AttendanceDataProcess setStatus(String status) {
		this.status=status;
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
	public AttendanceDataProcess setPersonId(String personId) {
		this.personId=personId;
		return this;
	}
	
	/**
	 * 获得 考勤日期<br>
	 * 考勤日期
	 * @return 考勤日期
	*/
	public Date getKqRq() {
		return kqRq;
	}
	
	/**
	 * 设置 考勤日期
	 * @param kqRq 考勤日期
	 * @return 当前对象
	*/
	public AttendanceDataProcess setKqRq(Date kqRq) {
		this.kqRq=kqRq;
		return this;
	}
	
	/**
	 * 获得 处理时间<br>
	 * 处理时间
	 * @return 处理时间
	*/
	public Date getProcessDate() {
		return processDate;
	}
	
	/**
	 * 设置 处理时间
	 * @param processDate 处理时间
	 * @return 当前对象
	*/
	public AttendanceDataProcess setProcessDate(Date processDate) {
		this.processDate=processDate;
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
	public AttendanceDataProcess setNotes(String notes) {
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
	public AttendanceDataProcess setCreateBy(String createBy) {
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
	public AttendanceDataProcess setCreateTime(Date createTime) {
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
	public AttendanceDataProcess setUpdateBy(String updateBy) {
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
	public AttendanceDataProcess setUpdateTime(Date updateTime) {
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
	public AttendanceDataProcess setDeleted(Integer deleted) {
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
	public AttendanceDataProcess setDeleted(Boolean deletedBool) {
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
	public AttendanceDataProcess setDeleteBy(String deleteBy) {
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
	public AttendanceDataProcess setDeleteTime(Date deleteTime) {
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
	public AttendanceDataProcess setVersion(Integer version) {
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
	public AttendanceDataProcess setPerson(Person person) {
		this.person=person;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AttendanceDataProcess , 转换好的 AttendanceDataProcess 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AttendanceDataProcess , 转换好的 PoJo 对象
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
	public AttendanceDataProcess clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AttendanceDataProcess duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AttendanceDataProcessMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AttendanceDataProcessMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setKqRq(this.getKqRq());
		inst.setProcessDate(this.getProcessDate());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
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
	public AttendanceDataProcess clone(boolean deep) {
		return EntityContext.clone(AttendanceDataProcess.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AttendanceDataProcess
	 * @param attendanceDataProcessMap 包含实体信息的 Map 对象
	 * @return AttendanceDataProcess , 转换好的的 AttendanceDataProcess 对象
	*/
	@Transient
	public static AttendanceDataProcess createFrom(Map<String,Object> attendanceDataProcessMap) {
		if(attendanceDataProcessMap==null) return null;
		AttendanceDataProcess po = create();
		EntityContext.copyProperties(po,attendanceDataProcessMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AttendanceDataProcess
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AttendanceDataProcess , 转换好的的 AttendanceDataProcess 对象
	*/
	@Transient
	public static AttendanceDataProcess createFrom(Object pojo) {
		if(pojo==null) return null;
		AttendanceDataProcess po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AttendanceDataProcess，等同于 new
	 * @return AttendanceDataProcess 对象
	*/
	@Transient
	public static AttendanceDataProcess create() {
		return new com.dt.platform.domain.hr.meta.AttendanceDataProcessMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AttendanceDataProcessMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AttendanceDataProcessMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AttendanceDataProcessMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AttendanceDataProcessMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AttendanceDataProcessMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AttendanceDataProcessMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AttendanceDataProcessMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AttendanceDataProcessMeta.DELETE_TIME)));
			this.setKqRq(DataParser.parse(Date.class, map.get(AttendanceDataProcessMeta.KQ_RQ)));
			this.setProcessDate(DataParser.parse(Date.class, map.get(AttendanceDataProcessMeta.PROCESS_DATE)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AttendanceDataProcessMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(AttendanceDataProcessMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(AttendanceDataProcessMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AttendanceDataProcessMeta.STATUS)));
			// others
			this.setPerson(DataParser.parse(Person.class, map.get(AttendanceDataProcessMeta.PERSON)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AttendanceDataProcessMeta.NOTES));
				this.setUpdateTime( (Date)map.get(AttendanceDataProcessMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AttendanceDataProcessMeta.VERSION));
				this.setCreateBy( (String)map.get(AttendanceDataProcessMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AttendanceDataProcessMeta.DELETED));
				this.setCreateTime( (Date)map.get(AttendanceDataProcessMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AttendanceDataProcessMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AttendanceDataProcessMeta.DELETE_TIME));
				this.setKqRq( (Date)map.get(AttendanceDataProcessMeta.KQ_RQ));
				this.setProcessDate( (Date)map.get(AttendanceDataProcessMeta.PROCESS_DATE));
				this.setDeleteBy( (String)map.get(AttendanceDataProcessMeta.DELETE_BY));
				this.setPersonId( (String)map.get(AttendanceDataProcessMeta.PERSON_ID));
				this.setId( (String)map.get(AttendanceDataProcessMeta.ID));
				this.setStatus( (String)map.get(AttendanceDataProcessMeta.STATUS));
				// others
				this.setPerson( (Person)map.get(AttendanceDataProcessMeta.PERSON));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AttendanceDataProcessMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AttendanceDataProcessMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AttendanceDataProcessMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AttendanceDataProcessMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AttendanceDataProcessMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AttendanceDataProcessMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AttendanceDataProcessMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AttendanceDataProcessMeta.DELETE_TIME)));
			this.setKqRq(DataParser.parse(Date.class, r.getValue(AttendanceDataProcessMeta.KQ_RQ)));
			this.setProcessDate(DataParser.parse(Date.class, r.getValue(AttendanceDataProcessMeta.PROCESS_DATE)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AttendanceDataProcessMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(AttendanceDataProcessMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(AttendanceDataProcessMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AttendanceDataProcessMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AttendanceDataProcessMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(AttendanceDataProcessMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AttendanceDataProcessMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AttendanceDataProcessMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AttendanceDataProcessMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AttendanceDataProcessMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AttendanceDataProcessMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AttendanceDataProcessMeta.DELETE_TIME));
				this.setKqRq( (Date)r.getValue(AttendanceDataProcessMeta.KQ_RQ));
				this.setProcessDate( (Date)r.getValue(AttendanceDataProcessMeta.PROCESS_DATE));
				this.setDeleteBy( (String)r.getValue(AttendanceDataProcessMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(AttendanceDataProcessMeta.PERSON_ID));
				this.setId( (String)r.getValue(AttendanceDataProcessMeta.ID));
				this.setStatus( (String)r.getValue(AttendanceDataProcessMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}