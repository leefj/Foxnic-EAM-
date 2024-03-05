package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ATTENDANCE_DATE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.AttendanceDateMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考勤日期
 * <p>考勤日期 , 数据表 hr_attendance_date 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-27 16:27:27
 * @sign E7ACEF21127D06093406E3E5B17D616E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_attendance_date")
@ApiModel(description = "考勤日期 ; 考勤日期 , 数据表 hr_attendance_date 的PO类型")
public class AttendanceDate extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ATTENDANCE_DATE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "810494341070979072")
	private String id;
	
	/**
	 * 年份：年份
	*/
	@ApiModelProperty(required = false,value="年份" , notes = "年份" , example = "2024")
	private String year;
	
	/**
	 * 日期：日期
	*/
	@ApiModelProperty(required = false,value="日期" , notes = "日期" , example = "2024-02-15")
	private String dateStr;
	
	/**
	 * 周：周
	*/
	@ApiModelProperty(required = false,value="周" , notes = "周" , example = "w4")
	private String week;
	
	/**
	 * 法定假日：法定假日
	*/
	@ApiModelProperty(required = false,value="法定假日" , notes = "法定假日" , example = "yes")
	private String statutoryHoliday;
	
	/**
	 * 节日：节日
	*/
	@ApiModelProperty(required = false,value="节日" , notes = "节日" , example = "春节")
	private String holiday;
	
	/**
	 * 考勤签到：考勤签到
	*/
	@ApiModelProperty(required = false,value="考勤签到" , notes = "考勤签到" , example = "no")
	private String attendancSign;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-15 12:55:09")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-02-25 02:22:07")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "3")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * confSDate：confSDate
	*/
	@ApiModelProperty(required = false,value="confSDate" , notes = "confSDate")
	private Date confSDate;
	
	/**
	 * confEDate：confEDate
	*/
	@ApiModelProperty(required = false,value="confEDate" , notes = "confEDate")
	private Date confEDate;
	
	/**
	 * confCreateDate：confCreateDate
	*/
	@ApiModelProperty(required = false,value="confCreateDate" , notes = "confCreateDate")
	private String confCreateDate;
	
	/**
	 * attendanceTplList：attendanceTplList
	*/
	@ApiModelProperty(required = false,value="attendanceTplList" , notes = "attendanceTplList")
	private List<AttendanceTpl> attendanceTplList;
	
	/**
	 * attendanceTplIdsList：attendanceTplIdsList
	*/
	@ApiModelProperty(required = false,value="attendanceTplIdsList" , notes = "attendanceTplIdsList")
	private List<String> attendanceTplIdsList;
	
	/**
	 * attendanceTplList2：attendanceTplList2
	*/
	@ApiModelProperty(required = false,value="attendanceTplList2" , notes = "attendanceTplList2")
	private List<AttendanceTpl> attendanceTplList2;
	
	/**
	 * attendanceTplIdsList2：attendanceTplIdsList2
	*/
	@ApiModelProperty(required = false,value="attendanceTplIdsList2" , notes = "attendanceTplIdsList2")
	private List<String> attendanceTplIdsList2;
	
	/**
	 * attendanceTplList3：attendanceTplList3
	*/
	@ApiModelProperty(required = false,value="attendanceTplList3" , notes = "attendanceTplList3")
	private List<AttendanceTpl> attendanceTplList3;
	
	/**
	 * attendanceTplIdsList3：attendanceTplIdsList3
	*/
	@ApiModelProperty(required = false,value="attendanceTplIdsList3" , notes = "attendanceTplIdsList3")
	private List<String> attendanceTplIdsList3;
	
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
	public AttendanceDate setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 年份<br>
	 * 年份
	 * @return 年份
	*/
	public String getYear() {
		return year;
	}
	
	/**
	 * 设置 年份
	 * @param year 年份
	 * @return 当前对象
	*/
	public AttendanceDate setYear(String year) {
		this.year=year;
		return this;
	}
	
	/**
	 * 获得 日期<br>
	 * 日期
	 * @return 日期
	*/
	public String getDateStr() {
		return dateStr;
	}
	
	/**
	 * 设置 日期
	 * @param dateStr 日期
	 * @return 当前对象
	*/
	public AttendanceDate setDateStr(String dateStr) {
		this.dateStr=dateStr;
		return this;
	}
	
	/**
	 * 获得 周<br>
	 * 周
	 * @return 周
	*/
	public String getWeek() {
		return week;
	}
	
	/**
	 * 设置 周
	 * @param week 周
	 * @return 当前对象
	*/
	public AttendanceDate setWeek(String week) {
		this.week=week;
		return this;
	}
	
	/**
	 * 获得 法定假日<br>
	 * 法定假日
	 * @return 法定假日
	*/
	public String getStatutoryHoliday() {
		return statutoryHoliday;
	}
	
	/**
	 * 设置 法定假日
	 * @param statutoryHoliday 法定假日
	 * @return 当前对象
	*/
	public AttendanceDate setStatutoryHoliday(String statutoryHoliday) {
		this.statutoryHoliday=statutoryHoliday;
		return this;
	}
	
	/**
	 * 获得 节日<br>
	 * 节日
	 * @return 节日
	*/
	public String getHoliday() {
		return holiday;
	}
	
	/**
	 * 设置 节日
	 * @param holiday 节日
	 * @return 当前对象
	*/
	public AttendanceDate setHoliday(String holiday) {
		this.holiday=holiday;
		return this;
	}
	
	/**
	 * 获得 考勤签到<br>
	 * 考勤签到
	 * @return 考勤签到
	*/
	public String getAttendancSign() {
		return attendancSign;
	}
	
	/**
	 * 设置 考勤签到
	 * @param attendancSign 考勤签到
	 * @return 当前对象
	*/
	public AttendanceDate setAttendancSign(String attendancSign) {
		this.attendancSign=attendancSign;
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
	public AttendanceDate setCreateBy(String createBy) {
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
	public AttendanceDate setCreateTime(Date createTime) {
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
	public AttendanceDate setUpdateBy(String updateBy) {
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
	public AttendanceDate setUpdateTime(Date updateTime) {
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
	public AttendanceDate setDeleted(Integer deleted) {
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
	public AttendanceDate setDeleted(Boolean deletedBool) {
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
	public AttendanceDate setDeleteBy(String deleteBy) {
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
	public AttendanceDate setDeleteTime(Date deleteTime) {
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
	public AttendanceDate setVersion(Integer version) {
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
	public AttendanceDate setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 confSDate<br>
	 * confSDate
	 * @return confSDate
	*/
	public Date getConfSDate() {
		return confSDate;
	}
	
	/**
	 * 设置 confSDate
	 * @param confSDate confSDate
	 * @return 当前对象
	*/
	public AttendanceDate setConfSDate(Date confSDate) {
		this.confSDate=confSDate;
		return this;
	}
	
	/**
	 * 获得 confEDate<br>
	 * confEDate
	 * @return confEDate
	*/
	public Date getConfEDate() {
		return confEDate;
	}
	
	/**
	 * 设置 confEDate
	 * @param confEDate confEDate
	 * @return 当前对象
	*/
	public AttendanceDate setConfEDate(Date confEDate) {
		this.confEDate=confEDate;
		return this;
	}
	
	/**
	 * 获得 confCreateDate<br>
	 * confCreateDate
	 * @return confCreateDate
	*/
	public String getConfCreateDate() {
		return confCreateDate;
	}
	
	/**
	 * 设置 confCreateDate
	 * @param confCreateDate confCreateDate
	 * @return 当前对象
	*/
	public AttendanceDate setConfCreateDate(String confCreateDate) {
		this.confCreateDate=confCreateDate;
		return this;
	}
	
	/**
	 * 获得 attendanceTplList<br>
	 * attendanceTplList
	 * @return attendanceTplList
	*/
	public List<AttendanceTpl> getAttendanceTplList() {
		return attendanceTplList;
	}
	
	/**
	 * 设置 attendanceTplList
	 * @param attendanceTplList attendanceTplList
	 * @return 当前对象
	*/
	public AttendanceDate setAttendanceTplList(List<AttendanceTpl> attendanceTplList) {
		this.attendanceTplList=attendanceTplList;
		return this;
	}
	
	/**
	 * 添加 attendanceTplList
	 * @param attendanceTpl attendanceTplList
	 * @return 当前对象
	*/
	public AttendanceDate addAttendanceTpl(AttendanceTpl... attendanceTpl) {
		if(this.attendanceTplList==null) attendanceTplList=new ArrayList<>();
		this.attendanceTplList.addAll(Arrays.asList(attendanceTpl));
		return this;
	}
	
	/**
	 * 获得 attendanceTplIdsList<br>
	 * attendanceTplIdsList
	 * @return attendanceTplIdsList
	*/
	public List<String> getAttendanceTplIdsList() {
		return attendanceTplIdsList;
	}
	
	/**
	 * 设置 attendanceTplIdsList
	 * @param attendanceTplIdsList attendanceTplIdsList
	 * @return 当前对象
	*/
	public AttendanceDate setAttendanceTplIdsList(List<String> attendanceTplIdsList) {
		this.attendanceTplIdsList=attendanceTplIdsList;
		return this;
	}
	
	/**
	 * 添加 attendanceTplIdsList
	 * @param attendanceTplIds attendanceTplIdsList
	 * @return 当前对象
	*/
	public AttendanceDate addAttendanceTplIds(String... attendanceTplIds) {
		if(this.attendanceTplIdsList==null) attendanceTplIdsList=new ArrayList<>();
		this.attendanceTplIdsList.addAll(Arrays.asList(attendanceTplIds));
		return this;
	}
	
	/**
	 * 获得 attendanceTplList2<br>
	 * attendanceTplList2
	 * @return attendanceTplList2
	*/
	public List<AttendanceTpl> getAttendanceTplList2() {
		return attendanceTplList2;
	}
	
	/**
	 * 设置 attendanceTplList2
	 * @param attendanceTplList2 attendanceTplList2
	 * @return 当前对象
	*/
	public AttendanceDate setAttendanceTplList2(List<AttendanceTpl> attendanceTplList2) {
		this.attendanceTplList2=attendanceTplList2;
		return this;
	}
	
	/**
	 * 添加 attendanceTplList2
	 * @param entity attendanceTplList2
	 * @return 当前对象
	*/
	public AttendanceDate addAttendanceTplList2(AttendanceTpl... entity) {
		if(this.attendanceTplList2==null) attendanceTplList2=new ArrayList<>();
		this.attendanceTplList2.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 attendanceTplIdsList2<br>
	 * attendanceTplIdsList2
	 * @return attendanceTplIdsList2
	*/
	public List<String> getAttendanceTplIdsList2() {
		return attendanceTplIdsList2;
	}
	
	/**
	 * 设置 attendanceTplIdsList2
	 * @param attendanceTplIdsList2 attendanceTplIdsList2
	 * @return 当前对象
	*/
	public AttendanceDate setAttendanceTplIdsList2(List<String> attendanceTplIdsList2) {
		this.attendanceTplIdsList2=attendanceTplIdsList2;
		return this;
	}
	
	/**
	 * 添加 attendanceTplIdsList2
	 * @param entity attendanceTplIdsList2
	 * @return 当前对象
	*/
	public AttendanceDate addAttendanceTplIdsList2(String... entity) {
		if(this.attendanceTplIdsList2==null) attendanceTplIdsList2=new ArrayList<>();
		this.attendanceTplIdsList2.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 attendanceTplList3<br>
	 * attendanceTplList3
	 * @return attendanceTplList3
	*/
	public List<AttendanceTpl> getAttendanceTplList3() {
		return attendanceTplList3;
	}
	
	/**
	 * 设置 attendanceTplList3
	 * @param attendanceTplList3 attendanceTplList3
	 * @return 当前对象
	*/
	public AttendanceDate setAttendanceTplList3(List<AttendanceTpl> attendanceTplList3) {
		this.attendanceTplList3=attendanceTplList3;
		return this;
	}
	
	/**
	 * 添加 attendanceTplList3
	 * @param entity attendanceTplList3
	 * @return 当前对象
	*/
	public AttendanceDate addAttendanceTplList3(AttendanceTpl... entity) {
		if(this.attendanceTplList3==null) attendanceTplList3=new ArrayList<>();
		this.attendanceTplList3.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 attendanceTplIdsList3<br>
	 * attendanceTplIdsList3
	 * @return attendanceTplIdsList3
	*/
	public List<String> getAttendanceTplIdsList3() {
		return attendanceTplIdsList3;
	}
	
	/**
	 * 设置 attendanceTplIdsList3
	 * @param attendanceTplIdsList3 attendanceTplIdsList3
	 * @return 当前对象
	*/
	public AttendanceDate setAttendanceTplIdsList3(List<String> attendanceTplIdsList3) {
		this.attendanceTplIdsList3=attendanceTplIdsList3;
		return this;
	}
	
	/**
	 * 添加 attendanceTplIdsList3
	 * @param entity attendanceTplIdsList3
	 * @return 当前对象
	*/
	public AttendanceDate addAttendanceTplIdsList3(String... entity) {
		if(this.attendanceTplIdsList3==null) attendanceTplIdsList3=new ArrayList<>();
		this.attendanceTplIdsList3.addAll(Arrays.asList(entity));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AttendanceDate , 转换好的 AttendanceDate 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AttendanceDate , 转换好的 PoJo 对象
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
	public AttendanceDate clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AttendanceDate duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AttendanceDateMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AttendanceDateMeta.$$proxy$$();
		inst.setWeek(this.getWeek());
		inst.setDateStr(this.getDateStr());
		inst.setYear(this.getYear());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setHoliday(this.getHoliday());
		inst.setVersion(this.getVersion());
		inst.setStatutoryHoliday(this.getStatutoryHoliday());
		inst.setAttendancSign(this.getAttendancSign());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
			inst.setAttendanceTplIdsList3(this.getAttendanceTplIdsList3());
			inst.setAttendanceTplList(this.getAttendanceTplList());
			inst.setAttendanceTplIdsList(this.getAttendanceTplIdsList());
			inst.setAttendanceTplIdsList2(this.getAttendanceTplIdsList2());
			inst.setAttendanceTplList3(this.getAttendanceTplList3());
			inst.setConfSDate(this.getConfSDate());
			inst.setAttendanceTplList2(this.getAttendanceTplList2());
			inst.setConfEDate(this.getConfEDate());
			inst.setConfCreateDate(this.getConfCreateDate());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AttendanceDate clone(boolean deep) {
		return EntityContext.clone(AttendanceDate.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AttendanceDate
	 * @param attendanceDateMap 包含实体信息的 Map 对象
	 * @return AttendanceDate , 转换好的的 AttendanceDate 对象
	*/
	@Transient
	public static AttendanceDate createFrom(Map<String,Object> attendanceDateMap) {
		if(attendanceDateMap==null) return null;
		AttendanceDate po = create();
		EntityContext.copyProperties(po,attendanceDateMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AttendanceDate
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AttendanceDate , 转换好的的 AttendanceDate 对象
	*/
	@Transient
	public static AttendanceDate createFrom(Object pojo) {
		if(pojo==null) return null;
		AttendanceDate po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AttendanceDate，等同于 new
	 * @return AttendanceDate 对象
	*/
	@Transient
	public static AttendanceDate create() {
		return new com.dt.platform.domain.hr.meta.AttendanceDateMeta.$$proxy$$();
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
			this.setWeek(DataParser.parse(String.class, map.get(AttendanceDateMeta.WEEK)));
			this.setDateStr(DataParser.parse(String.class, map.get(AttendanceDateMeta.DATE_STR)));
			this.setYear(DataParser.parse(String.class, map.get(AttendanceDateMeta.YEAR)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AttendanceDateMeta.UPDATE_TIME)));
			this.setHoliday(DataParser.parse(String.class, map.get(AttendanceDateMeta.HOLIDAY)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AttendanceDateMeta.VERSION)));
			this.setStatutoryHoliday(DataParser.parse(String.class, map.get(AttendanceDateMeta.STATUTORY_HOLIDAY)));
			this.setAttendancSign(DataParser.parse(String.class, map.get(AttendanceDateMeta.ATTENDANC_SIGN)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AttendanceDateMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AttendanceDateMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AttendanceDateMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AttendanceDateMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AttendanceDateMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AttendanceDateMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AttendanceDateMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AttendanceDateMeta.ID)));
			// others
			this.setConfSDate(DataParser.parse(Date.class, map.get(AttendanceDateMeta.CONF_S_DATE)));
			this.setConfEDate(DataParser.parse(Date.class, map.get(AttendanceDateMeta.CONF_E_DATE)));
			this.setConfCreateDate(DataParser.parse(String.class, map.get(AttendanceDateMeta.CONF_CREATE_DATE)));
			return true;
		} else {
			try {
				this.setWeek( (String)map.get(AttendanceDateMeta.WEEK));
				this.setDateStr( (String)map.get(AttendanceDateMeta.DATE_STR));
				this.setYear( (String)map.get(AttendanceDateMeta.YEAR));
				this.setUpdateTime( (Date)map.get(AttendanceDateMeta.UPDATE_TIME));
				this.setHoliday( (String)map.get(AttendanceDateMeta.HOLIDAY));
				this.setVersion( (Integer)map.get(AttendanceDateMeta.VERSION));
				this.setStatutoryHoliday( (String)map.get(AttendanceDateMeta.STATUTORY_HOLIDAY));
				this.setAttendancSign( (String)map.get(AttendanceDateMeta.ATTENDANC_SIGN));
				this.setCreateBy( (String)map.get(AttendanceDateMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AttendanceDateMeta.DELETED));
				this.setCreateTime( (Date)map.get(AttendanceDateMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AttendanceDateMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AttendanceDateMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(AttendanceDateMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AttendanceDateMeta.DELETE_BY));
				this.setId( (String)map.get(AttendanceDateMeta.ID));
				// others
				this.setConfSDate( (Date)map.get(AttendanceDateMeta.CONF_S_DATE));
				this.setConfEDate( (Date)map.get(AttendanceDateMeta.CONF_E_DATE));
				this.setConfCreateDate( (String)map.get(AttendanceDateMeta.CONF_CREATE_DATE));
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
			this.setWeek(DataParser.parse(String.class, r.getValue(AttendanceDateMeta.WEEK)));
			this.setDateStr(DataParser.parse(String.class, r.getValue(AttendanceDateMeta.DATE_STR)));
			this.setYear(DataParser.parse(String.class, r.getValue(AttendanceDateMeta.YEAR)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AttendanceDateMeta.UPDATE_TIME)));
			this.setHoliday(DataParser.parse(String.class, r.getValue(AttendanceDateMeta.HOLIDAY)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AttendanceDateMeta.VERSION)));
			this.setStatutoryHoliday(DataParser.parse(String.class, r.getValue(AttendanceDateMeta.STATUTORY_HOLIDAY)));
			this.setAttendancSign(DataParser.parse(String.class, r.getValue(AttendanceDateMeta.ATTENDANC_SIGN)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AttendanceDateMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AttendanceDateMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AttendanceDateMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AttendanceDateMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AttendanceDateMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AttendanceDateMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AttendanceDateMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AttendanceDateMeta.ID)));
			return true;
		} else {
			try {
				this.setWeek( (String)r.getValue(AttendanceDateMeta.WEEK));
				this.setDateStr( (String)r.getValue(AttendanceDateMeta.DATE_STR));
				this.setYear( (String)r.getValue(AttendanceDateMeta.YEAR));
				this.setUpdateTime( (Date)r.getValue(AttendanceDateMeta.UPDATE_TIME));
				this.setHoliday( (String)r.getValue(AttendanceDateMeta.HOLIDAY));
				this.setVersion( (Integer)r.getValue(AttendanceDateMeta.VERSION));
				this.setStatutoryHoliday( (String)r.getValue(AttendanceDateMeta.STATUTORY_HOLIDAY));
				this.setAttendancSign( (String)r.getValue(AttendanceDateMeta.ATTENDANC_SIGN));
				this.setCreateBy( (String)r.getValue(AttendanceDateMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AttendanceDateMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AttendanceDateMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AttendanceDateMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AttendanceDateMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(AttendanceDateMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AttendanceDateMeta.DELETE_BY));
				this.setId( (String)r.getValue(AttendanceDateMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}