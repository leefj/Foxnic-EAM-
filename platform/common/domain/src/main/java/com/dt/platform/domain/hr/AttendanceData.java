package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ATTENDANCE_DATA;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.AttendanceDataMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考勤汇总
 * <p>考勤汇总 , 数据表 hr_attendance_data 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-15 15:15:15
 * @sign 6965955D9B44788B65ED8107099861BB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_attendance_data")
@ApiModel(description = "考勤汇总 ; 考勤汇总 , 数据表 hr_attendance_data 的PO类型")
public class AttendanceData extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ATTENDANCE_DATA.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "810527595941593088")
	private String id;
	
	/**
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员" , example = "808428146557714432")
	private String personId;
	
	/**
	 * 考勤模版：考勤模版
	*/
	@ApiModelProperty(required = false,value="考勤模版" , notes = "考勤模版" , example = "default")
	private String attendanceTplCode;
	
	/**
	 * 工号：工号
	*/
	@ApiModelProperty(required = false,value="工号" , notes = "工号")
	private String jobNumber;
	
	/**
	 * 考勤日期：考勤日期
	*/
	@ApiModelProperty(required = false,value="考勤日期" , notes = "考勤日期")
	private Date attendanceDate;
	
	/**
	 * 上班打卡：上班打卡
	*/
	@ApiModelProperty(required = false,value="上班打卡" , notes = "上班打卡")
	private Date onWorkTime;
	
	/**
	 * 最早打卡：最早打卡
	*/
	@ApiModelProperty(required = false,value="最早打卡" , notes = "最早打卡")
	private Date onWorkTime2;
	
	/**
	 * 下班打卡：下班打卡
	*/
	@ApiModelProperty(required = false,value="下班打卡" , notes = "下班打卡" , example = "2024-02-13 12:00:04")
	private Date offWorkTime;
	
	/**
	 * 最晚打卡：最晚打卡
	*/
	@ApiModelProperty(required = false,value="最晚打卡" , notes = "最晚打卡")
	private Date offWorkTime2;
	
	/**
	 * 早退：早退
	*/
	@ApiModelProperty(required = false,value="早退" , notes = "早退" , example = "12")
	private String leaveEarly;
	
	/**
	 * 晚退：晚退
	*/
	@ApiModelProperty(required = false,value="晚退" , notes = "晚退" , example = "12")
	private String leaveLate;
	
	/**
	 * 矿工：矿工
	*/
	@ApiModelProperty(required = false,value="矿工" , notes = "矿工" , example = "12")
	private String skipWork;
	
	/**
	 * 补签：补签
	*/
	@ApiModelProperty(required = false,value="补签" , notes = "补签" , example = "12")
	private String bq;
	
	/**
	 * 请假：请假
	*/
	@ApiModelProperty(required = false,value="请假" , notes = "请假" , example = "12")
	private String qj;
	
	/**
	 * 出差：出差
	*/
	@ApiModelProperty(required = false,value="出差" , notes = "出差" , example = "1212")
	private String cc;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "12")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-15 03:07:18")
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
	 * person：person
	*/
	@ApiModelProperty(required = false,value="person" , notes = "person")
	private Person person;
	
	/**
	 * attendanceTpl：attendanceTpl
	*/
	@ApiModelProperty(required = false,value="attendanceTpl" , notes = "attendanceTpl")
	private AttendanceTpl attendanceTpl;
	
	/**
	 * personJobName：personJobName
	*/
	@ApiModelProperty(required = false,value="personJobName" , notes = "personJobName")
	private String personJobName;
	
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
	public AttendanceData setId(String id) {
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
	public AttendanceData setPersonId(String personId) {
		this.personId=personId;
		return this;
	}
	
	/**
	 * 获得 考勤模版<br>
	 * 考勤模版
	 * @return 考勤模版
	*/
	public String getAttendanceTplCode() {
		return attendanceTplCode;
	}
	
	/**
	 * 设置 考勤模版
	 * @param attendanceTplCode 考勤模版
	 * @return 当前对象
	*/
	public AttendanceData setAttendanceTplCode(String attendanceTplCode) {
		this.attendanceTplCode=attendanceTplCode;
		return this;
	}
	
	/**
	 * 获得 工号<br>
	 * 工号
	 * @return 工号
	*/
	public String getJobNumber() {
		return jobNumber;
	}
	
	/**
	 * 设置 工号
	 * @param jobNumber 工号
	 * @return 当前对象
	*/
	public AttendanceData setJobNumber(String jobNumber) {
		this.jobNumber=jobNumber;
		return this;
	}
	
	/**
	 * 获得 考勤日期<br>
	 * 考勤日期
	 * @return 考勤日期
	*/
	public Date getAttendanceDate() {
		return attendanceDate;
	}
	
	/**
	 * 设置 考勤日期
	 * @param attendanceDate 考勤日期
	 * @return 当前对象
	*/
	public AttendanceData setAttendanceDate(Date attendanceDate) {
		this.attendanceDate=attendanceDate;
		return this;
	}
	
	/**
	 * 获得 上班打卡<br>
	 * 上班打卡
	 * @return 上班打卡
	*/
	public Date getOnWorkTime() {
		return onWorkTime;
	}
	
	/**
	 * 设置 上班打卡
	 * @param onWorkTime 上班打卡
	 * @return 当前对象
	*/
	public AttendanceData setOnWorkTime(Date onWorkTime) {
		this.onWorkTime=onWorkTime;
		return this;
	}
	
	/**
	 * 获得 最早打卡<br>
	 * 最早打卡
	 * @return 最早打卡
	*/
	public Date getOnWorkTime2() {
		return onWorkTime2;
	}
	
	/**
	 * 设置 最早打卡
	 * @param onWorkTime2 最早打卡
	 * @return 当前对象
	*/
	public AttendanceData setOnWorkTime2(Date onWorkTime2) {
		this.onWorkTime2=onWorkTime2;
		return this;
	}
	
	/**
	 * 获得 下班打卡<br>
	 * 下班打卡
	 * @return 下班打卡
	*/
	public Date getOffWorkTime() {
		return offWorkTime;
	}
	
	/**
	 * 设置 下班打卡
	 * @param offWorkTime 下班打卡
	 * @return 当前对象
	*/
	public AttendanceData setOffWorkTime(Date offWorkTime) {
		this.offWorkTime=offWorkTime;
		return this;
	}
	
	/**
	 * 获得 最晚打卡<br>
	 * 最晚打卡
	 * @return 最晚打卡
	*/
	public Date getOffWorkTime2() {
		return offWorkTime2;
	}
	
	/**
	 * 设置 最晚打卡
	 * @param offWorkTime2 最晚打卡
	 * @return 当前对象
	*/
	public AttendanceData setOffWorkTime2(Date offWorkTime2) {
		this.offWorkTime2=offWorkTime2;
		return this;
	}
	
	/**
	 * 获得 早退<br>
	 * 早退
	 * @return 早退
	*/
	public String getLeaveEarly() {
		return leaveEarly;
	}
	
	/**
	 * 设置 早退
	 * @param leaveEarly 早退
	 * @return 当前对象
	*/
	public AttendanceData setLeaveEarly(String leaveEarly) {
		this.leaveEarly=leaveEarly;
		return this;
	}
	
	/**
	 * 获得 晚退<br>
	 * 晚退
	 * @return 晚退
	*/
	public String getLeaveLate() {
		return leaveLate;
	}
	
	/**
	 * 设置 晚退
	 * @param leaveLate 晚退
	 * @return 当前对象
	*/
	public AttendanceData setLeaveLate(String leaveLate) {
		this.leaveLate=leaveLate;
		return this;
	}
	
	/**
	 * 获得 矿工<br>
	 * 矿工
	 * @return 矿工
	*/
	public String getSkipWork() {
		return skipWork;
	}
	
	/**
	 * 设置 矿工
	 * @param skipWork 矿工
	 * @return 当前对象
	*/
	public AttendanceData setSkipWork(String skipWork) {
		this.skipWork=skipWork;
		return this;
	}
	
	/**
	 * 获得 补签<br>
	 * 补签
	 * @return 补签
	*/
	public String getBq() {
		return bq;
	}
	
	/**
	 * 设置 补签
	 * @param bq 补签
	 * @return 当前对象
	*/
	public AttendanceData setBq(String bq) {
		this.bq=bq;
		return this;
	}
	
	/**
	 * 获得 请假<br>
	 * 请假
	 * @return 请假
	*/
	public String getQj() {
		return qj;
	}
	
	/**
	 * 设置 请假
	 * @param qj 请假
	 * @return 当前对象
	*/
	public AttendanceData setQj(String qj) {
		this.qj=qj;
		return this;
	}
	
	/**
	 * 获得 出差<br>
	 * 出差
	 * @return 出差
	*/
	public String getCc() {
		return cc;
	}
	
	/**
	 * 设置 出差
	 * @param cc 出差
	 * @return 当前对象
	*/
	public AttendanceData setCc(String cc) {
		this.cc=cc;
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
	public AttendanceData setNotes(String notes) {
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
	public AttendanceData setCreateBy(String createBy) {
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
	public AttendanceData setCreateTime(Date createTime) {
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
	public AttendanceData setUpdateBy(String updateBy) {
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
	public AttendanceData setUpdateTime(Date updateTime) {
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
	public AttendanceData setDeleted(Integer deleted) {
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
	public AttendanceData setDeleted(Boolean deletedBool) {
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
	public AttendanceData setDeleteBy(String deleteBy) {
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
	public AttendanceData setDeleteTime(Date deleteTime) {
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
	public AttendanceData setVersion(Integer version) {
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
	public AttendanceData setTenantId(String tenantId) {
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
	public AttendanceData setPerson(Person person) {
		this.person=person;
		return this;
	}
	
	/**
	 * 获得 attendanceTpl<br>
	 * attendanceTpl
	 * @return attendanceTpl
	*/
	public AttendanceTpl getAttendanceTpl() {
		return attendanceTpl;
	}
	
	/**
	 * 设置 attendanceTpl
	 * @param attendanceTpl attendanceTpl
	 * @return 当前对象
	*/
	public AttendanceData setAttendanceTpl(AttendanceTpl attendanceTpl) {
		this.attendanceTpl=attendanceTpl;
		return this;
	}
	
	/**
	 * 获得 personJobName<br>
	 * personJobName
	 * @return personJobName
	*/
	public String getPersonJobName() {
		return personJobName;
	}
	
	/**
	 * 设置 personJobName
	 * @param personJobName personJobName
	 * @return 当前对象
	*/
	public AttendanceData setPersonJobName(String personJobName) {
		this.personJobName=personJobName;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AttendanceData , 转换好的 AttendanceData 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AttendanceData , 转换好的 PoJo 对象
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
	public AttendanceData clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AttendanceData duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AttendanceDataMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AttendanceDataMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setAttendanceTplCode(this.getAttendanceTplCode());
		inst.setBq(this.getBq());
		inst.setOnWorkTime(this.getOnWorkTime());
		inst.setSkipWork(this.getSkipWork());
		inst.setOffWorkTime(this.getOffWorkTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setQj(this.getQj());
		inst.setId(this.getId());
		inst.setOnWorkTime2(this.getOnWorkTime2());
		inst.setCc(this.getCc());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setLeaveEarly(this.getLeaveEarly());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setLeaveLate(this.getLeaveLate());
		inst.setAttendanceDate(this.getAttendanceDate());
		inst.setJobNumber(this.getJobNumber());
		inst.setOffWorkTime2(this.getOffWorkTime2());
		if(all) {
			inst.setPerson(this.getPerson());
			inst.setAttendanceTpl(this.getAttendanceTpl());
			inst.setPersonJobName(this.getPersonJobName());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AttendanceData clone(boolean deep) {
		return EntityContext.clone(AttendanceData.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AttendanceData
	 * @param attendanceDataMap 包含实体信息的 Map 对象
	 * @return AttendanceData , 转换好的的 AttendanceData 对象
	*/
	@Transient
	public static AttendanceData createFrom(Map<String,Object> attendanceDataMap) {
		if(attendanceDataMap==null) return null;
		AttendanceData po = create();
		EntityContext.copyProperties(po,attendanceDataMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AttendanceData
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AttendanceData , 转换好的的 AttendanceData 对象
	*/
	@Transient
	public static AttendanceData createFrom(Object pojo) {
		if(pojo==null) return null;
		AttendanceData po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AttendanceData，等同于 new
	 * @return AttendanceData 对象
	*/
	@Transient
	public static AttendanceData create() {
		return new com.dt.platform.domain.hr.meta.AttendanceDataMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AttendanceDataMeta.NOTES)));
			this.setAttendanceTplCode(DataParser.parse(String.class, map.get(AttendanceDataMeta.ATTENDANCE_TPL_CODE)));
			this.setBq(DataParser.parse(String.class, map.get(AttendanceDataMeta.BQ)));
			this.setOnWorkTime(DataParser.parse(Date.class, map.get(AttendanceDataMeta.ON_WORK_TIME)));
			this.setSkipWork(DataParser.parse(String.class, map.get(AttendanceDataMeta.SKIP_WORK)));
			this.setOffWorkTime(DataParser.parse(Date.class, map.get(AttendanceDataMeta.OFF_WORK_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AttendanceDataMeta.UPDATE_BY)));
			this.setQj(DataParser.parse(String.class, map.get(AttendanceDataMeta.QJ)));
			this.setId(DataParser.parse(String.class, map.get(AttendanceDataMeta.ID)));
			this.setOnWorkTime2(DataParser.parse(Date.class, map.get(AttendanceDataMeta.ON_WORK_TIME2)));
			this.setCc(DataParser.parse(String.class, map.get(AttendanceDataMeta.CC)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AttendanceDataMeta.UPDATE_TIME)));
			this.setLeaveEarly(DataParser.parse(String.class, map.get(AttendanceDataMeta.LEAVE_EARLY)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AttendanceDataMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AttendanceDataMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AttendanceDataMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AttendanceDataMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AttendanceDataMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AttendanceDataMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AttendanceDataMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(AttendanceDataMeta.PERSON_ID)));
			this.setLeaveLate(DataParser.parse(String.class, map.get(AttendanceDataMeta.LEAVE_LATE)));
			this.setAttendanceDate(DataParser.parse(Date.class, map.get(AttendanceDataMeta.ATTENDANCE_DATE)));
			this.setJobNumber(DataParser.parse(String.class, map.get(AttendanceDataMeta.JOB_NUMBER)));
			this.setOffWorkTime2(DataParser.parse(Date.class, map.get(AttendanceDataMeta.OFF_WORK_TIME2)));
			// others
			this.setPerson(DataParser.parse(Person.class, map.get(AttendanceDataMeta.PERSON)));
			this.setAttendanceTpl(DataParser.parse(AttendanceTpl.class, map.get(AttendanceDataMeta.ATTENDANCE_TPL)));
			this.setPersonJobName(DataParser.parse(String.class, map.get(AttendanceDataMeta.PERSON_JOB_NAME)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AttendanceDataMeta.NOTES));
				this.setAttendanceTplCode( (String)map.get(AttendanceDataMeta.ATTENDANCE_TPL_CODE));
				this.setBq( (String)map.get(AttendanceDataMeta.BQ));
				this.setOnWorkTime( (Date)map.get(AttendanceDataMeta.ON_WORK_TIME));
				this.setSkipWork( (String)map.get(AttendanceDataMeta.SKIP_WORK));
				this.setOffWorkTime( (Date)map.get(AttendanceDataMeta.OFF_WORK_TIME));
				this.setUpdateBy( (String)map.get(AttendanceDataMeta.UPDATE_BY));
				this.setQj( (String)map.get(AttendanceDataMeta.QJ));
				this.setId( (String)map.get(AttendanceDataMeta.ID));
				this.setOnWorkTime2( (Date)map.get(AttendanceDataMeta.ON_WORK_TIME2));
				this.setCc( (String)map.get(AttendanceDataMeta.CC));
				this.setUpdateTime( (Date)map.get(AttendanceDataMeta.UPDATE_TIME));
				this.setLeaveEarly( (String)map.get(AttendanceDataMeta.LEAVE_EARLY));
				this.setVersion( (Integer)map.get(AttendanceDataMeta.VERSION));
				this.setCreateBy( (String)map.get(AttendanceDataMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AttendanceDataMeta.DELETED));
				this.setCreateTime( (Date)map.get(AttendanceDataMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AttendanceDataMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(AttendanceDataMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AttendanceDataMeta.DELETE_BY));
				this.setPersonId( (String)map.get(AttendanceDataMeta.PERSON_ID));
				this.setLeaveLate( (String)map.get(AttendanceDataMeta.LEAVE_LATE));
				this.setAttendanceDate( (Date)map.get(AttendanceDataMeta.ATTENDANCE_DATE));
				this.setJobNumber( (String)map.get(AttendanceDataMeta.JOB_NUMBER));
				this.setOffWorkTime2( (Date)map.get(AttendanceDataMeta.OFF_WORK_TIME2));
				// others
				this.setPerson( (Person)map.get(AttendanceDataMeta.PERSON));
				this.setAttendanceTpl( (AttendanceTpl)map.get(AttendanceDataMeta.ATTENDANCE_TPL));
				this.setPersonJobName( (String)map.get(AttendanceDataMeta.PERSON_JOB_NAME));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.NOTES)));
			this.setAttendanceTplCode(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.ATTENDANCE_TPL_CODE)));
			this.setBq(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.BQ)));
			this.setOnWorkTime(DataParser.parse(Date.class, r.getValue(AttendanceDataMeta.ON_WORK_TIME)));
			this.setSkipWork(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.SKIP_WORK)));
			this.setOffWorkTime(DataParser.parse(Date.class, r.getValue(AttendanceDataMeta.OFF_WORK_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.UPDATE_BY)));
			this.setQj(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.QJ)));
			this.setId(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.ID)));
			this.setOnWorkTime2(DataParser.parse(Date.class, r.getValue(AttendanceDataMeta.ON_WORK_TIME2)));
			this.setCc(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.CC)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AttendanceDataMeta.UPDATE_TIME)));
			this.setLeaveEarly(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.LEAVE_EARLY)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AttendanceDataMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AttendanceDataMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AttendanceDataMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AttendanceDataMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.PERSON_ID)));
			this.setLeaveLate(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.LEAVE_LATE)));
			this.setAttendanceDate(DataParser.parse(Date.class, r.getValue(AttendanceDataMeta.ATTENDANCE_DATE)));
			this.setJobNumber(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.JOB_NUMBER)));
			this.setOffWorkTime2(DataParser.parse(Date.class, r.getValue(AttendanceDataMeta.OFF_WORK_TIME2)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AttendanceDataMeta.NOTES));
				this.setAttendanceTplCode( (String)r.getValue(AttendanceDataMeta.ATTENDANCE_TPL_CODE));
				this.setBq( (String)r.getValue(AttendanceDataMeta.BQ));
				this.setOnWorkTime( (Date)r.getValue(AttendanceDataMeta.ON_WORK_TIME));
				this.setSkipWork( (String)r.getValue(AttendanceDataMeta.SKIP_WORK));
				this.setOffWorkTime( (Date)r.getValue(AttendanceDataMeta.OFF_WORK_TIME));
				this.setUpdateBy( (String)r.getValue(AttendanceDataMeta.UPDATE_BY));
				this.setQj( (String)r.getValue(AttendanceDataMeta.QJ));
				this.setId( (String)r.getValue(AttendanceDataMeta.ID));
				this.setOnWorkTime2( (Date)r.getValue(AttendanceDataMeta.ON_WORK_TIME2));
				this.setCc( (String)r.getValue(AttendanceDataMeta.CC));
				this.setUpdateTime( (Date)r.getValue(AttendanceDataMeta.UPDATE_TIME));
				this.setLeaveEarly( (String)r.getValue(AttendanceDataMeta.LEAVE_EARLY));
				this.setVersion( (Integer)r.getValue(AttendanceDataMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AttendanceDataMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AttendanceDataMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AttendanceDataMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AttendanceDataMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(AttendanceDataMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AttendanceDataMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(AttendanceDataMeta.PERSON_ID));
				this.setLeaveLate( (String)r.getValue(AttendanceDataMeta.LEAVE_LATE));
				this.setAttendanceDate( (Date)r.getValue(AttendanceDataMeta.ATTENDANCE_DATE));
				this.setJobNumber( (String)r.getValue(AttendanceDataMeta.JOB_NUMBER));
				this.setOffWorkTime2( (Date)r.getValue(AttendanceDataMeta.OFF_WORK_TIME2));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}