package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ATTENDANCE_DATA;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
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
 * @since 2024-02-25 21:45:45
 * @sign 1801815E431C2452EC3B027947A26E54
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
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "814250826699636736")
	private String id;
	
	/**
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员" , example = "799379402461806592")
	private String personId;
	
	/**
	 * 考勤组：考勤组
	*/
	@ApiModelProperty(required = false,value="考勤组" , notes = "考勤组" , example = "default")
	private String attendanceTplCode;
	
	/**
	 * 是否工作日：是否工作日
	*/
	@ApiModelProperty(required = false,value="是否工作日" , notes = "是否工作日" , example = "yes")
	private String isWorkDay;
	
	/**
	 * 考勤日期：考勤日期
	*/
	@ApiModelProperty(required = false,value="考勤日期" , notes = "考勤日期" , example = "2024-01-29 12:00:00")
	private Date attendanceDate;
	
	/**
	 * 考勤日期：考勤日期
	*/
	@ApiModelProperty(required = false,value="考勤日期" , notes = "考勤日期" , example = "2024-01-29")
	private String attendanceDateStr;
	
	/**
	 * 结果：结果
	*/
	@ApiModelProperty(required = false,value="结果" , notes = "结果" , example = " 矿工")
	private String result;
	
	/**
	 * 上班天数：上班天数
	*/
	@ApiModelProperty(required = false,value="上班天数" , notes = "上班天数" , example = "0.00")
	private BigDecimal normalDay;
	
	/**
	 * 应上班天数：应上班天数
	*/
	@ApiModelProperty(required = false,value="应上班天数" , notes = "应上班天数" , example = "1.00")
	private BigDecimal needDay;
	
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
	@ApiModelProperty(required = false,value="下班打卡" , notes = "下班打卡")
	private Date offWorkTime;
	
	/**
	 * 最晚打卡：最晚打卡
	*/
	@ApiModelProperty(required = false,value="最晚打卡" , notes = "最晚打卡")
	private Date offWorkTime2;
	
	/**
	 * 迟到：次)
	*/
	@ApiModelProperty(required = false,value="迟到" , notes = "次)" , example = "0")
	private Integer leaveEarly;
	
	/**
	 * 迟到：分)
	*/
	@ApiModelProperty(required = false,value="迟到" , notes = "分)" , example = "0.00")
	private BigDecimal leaveEarlyTime;
	
	/**
	 * 早退：次)
	*/
	@ApiModelProperty(required = false,value="早退" , notes = "次)" , example = "0")
	private Integer leaveLate;
	
	/**
	 * 早退：分)
	*/
	@ApiModelProperty(required = false,value="早退" , notes = "分)" , example = "0.00")
	private BigDecimal leaveLateTime;
	
	/**
	 * 上班缺卡：次)
	*/
	@ApiModelProperty(required = false,value="上班缺卡" , notes = "次)" , example = "1")
	private Integer lossEarly;
	
	/**
	 * 下班却卡：次)
	*/
	@ApiModelProperty(required = false,value="下班却卡" , notes = "次)" , example = "1")
	private Integer lossLate;
	
	/**
	 * 缺卡处理：次)
	*/
	@ApiModelProperty(required = false,value="缺卡处理" , notes = "次)" , example = "0")
	private Integer lossProcess;
	
	/**
	 * 工作日加班：小时)
	*/
	@ApiModelProperty(required = false,value="工作日加班" , notes = "小时)" , example = "0.00")
	private BigDecimal jbGzr;
	
	/**
	 * 休息日加班：小时)
	*/
	@ApiModelProperty(required = false,value="休息日加班" , notes = "小时)" , example = "0.00")
	private BigDecimal jbXxr;
	
	/**
	 * 节假日加班：小时)
	*/
	@ApiModelProperty(required = false,value="节假日加班" , notes = "小时)" , example = "0.00")
	private BigDecimal jbJjr;
	
	/**
	 * 出差：天)
	*/
	@ApiModelProperty(required = false,value="出差" , notes = "天)" , example = "0.00")
	private BigDecimal cc;
	
	/**
	 * 年假：天)
	*/
	@ApiModelProperty(required = false,value="年假" , notes = "天)" , example = "0.00")
	private BigDecimal qjNj;
	
	/**
	 * 工伤假：天)
	*/
	@ApiModelProperty(required = false,value="工伤假" , notes = "天)" , example = "0.00")
	private BigDecimal qjGsj;
	
	/**
	 * 产假：天)
	*/
	@ApiModelProperty(required = false,value="产假" , notes = "天)" , example = "0.00")
	private BigDecimal qjCj;
	
	/**
	 * 婚假：天)
	*/
	@ApiModelProperty(required = false,value="婚假" , notes = "天)" , example = "0.00")
	private BigDecimal qjHj;
	
	/**
	 * 病假：天)
	*/
	@ApiModelProperty(required = false,value="病假" , notes = "天)" , example = "0.00")
	private BigDecimal qjBj;
	
	/**
	 * 事假：天)
	*/
	@ApiModelProperty(required = false,value="事假" , notes = "天)" , example = "0.00")
	private BigDecimal qjSj;
	
	/**
	 * 调休假：天)
	*/
	@ApiModelProperty(required = false,value="调休假" , notes = "天)" , example = "0.00")
	private BigDecimal qjTxj;
	
	/**
	 * 哺乳假：天)
	*/
	@ApiModelProperty(required = false,value="哺乳假" , notes = "天)" , example = "0.00")
	private BigDecimal qjPlj;
	
	/**
	 * 批次号：批次号
	*/
	@ApiModelProperty(required = false,value="批次号" , notes = "批次号")
	private String batchCode;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 关联：关联
	*/
	@ApiModelProperty(required = false,value="关联" , notes = "关联")
	private String relId;
	
	/**
	 * 说明：说明
	*/
	@ApiModelProperty(required = false,value="说明" , notes = "说明")
	private String dayInfo;
	
	/**
	 * 记录时间：记录时间
	*/
	@ApiModelProperty(required = false,value="记录时间" , notes = "记录时间" , example = "2024-02-25 09:42:05")
	private Date rcdTime;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-25 09:42:05")
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
	 * sJobNumber：sJobNumber
	*/
	@ApiModelProperty(required = false,value="sJobNumber" , notes = "sJobNumber")
	private String sJobNumber;
	
	/**
	 * rq：rq
	*/
	@ApiModelProperty(required = false,value="rq" , notes = "rq")
	private String rq;
	
	/**
	 * days：days
	*/
	@ApiModelProperty(required = false,value="days" , notes = "days")
	private String days;
	
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
	 * 获得 考勤组<br>
	 * 考勤组
	 * @return 考勤组
	*/
	public String getAttendanceTplCode() {
		return attendanceTplCode;
	}
	
	/**
	 * 设置 考勤组
	 * @param attendanceTplCode 考勤组
	 * @return 当前对象
	*/
	public AttendanceData setAttendanceTplCode(String attendanceTplCode) {
		this.attendanceTplCode=attendanceTplCode;
		return this;
	}
	
	/**
	 * 获得 是否工作日<br>
	 * 是否工作日
	 * @return 是否工作日
	*/
	public String getIsWorkDay() {
		return isWorkDay;
	}
	
	/**
	 * 设置 是否工作日
	 * @param isWorkDay 是否工作日
	 * @return 当前对象
	*/
	public AttendanceData setIsWorkDay(String isWorkDay) {
		this.isWorkDay=isWorkDay;
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
	 * 获得 考勤日期<br>
	 * 考勤日期
	 * @return 考勤日期
	*/
	public String getAttendanceDateStr() {
		return attendanceDateStr;
	}
	
	/**
	 * 设置 考勤日期
	 * @param attendanceDateStr 考勤日期
	 * @return 当前对象
	*/
	public AttendanceData setAttendanceDateStr(String attendanceDateStr) {
		this.attendanceDateStr=attendanceDateStr;
		return this;
	}
	
	/**
	 * 获得 结果<br>
	 * 结果
	 * @return 结果
	*/
	public String getResult() {
		return result;
	}
	
	/**
	 * 设置 结果
	 * @param result 结果
	 * @return 当前对象
	*/
	public AttendanceData setResult(String result) {
		this.result=result;
		return this;
	}
	
	/**
	 * 获得 上班天数<br>
	 * 上班天数
	 * @return 上班天数
	*/
	public BigDecimal getNormalDay() {
		return normalDay;
	}
	
	/**
	 * 设置 上班天数
	 * @param normalDay 上班天数
	 * @return 当前对象
	*/
	public AttendanceData setNormalDay(BigDecimal normalDay) {
		this.normalDay=normalDay;
		return this;
	}
	
	/**
	 * 获得 应上班天数<br>
	 * 应上班天数
	 * @return 应上班天数
	*/
	public BigDecimal getNeedDay() {
		return needDay;
	}
	
	/**
	 * 设置 应上班天数
	 * @param needDay 应上班天数
	 * @return 当前对象
	*/
	public AttendanceData setNeedDay(BigDecimal needDay) {
		this.needDay=needDay;
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
	 * 获得 迟到<br>
	 * 次)
	 * @return 迟到
	*/
	public Integer getLeaveEarly() {
		return leaveEarly;
	}
	
	/**
	 * 设置 迟到
	 * @param leaveEarly 迟到
	 * @return 当前对象
	*/
	public AttendanceData setLeaveEarly(Integer leaveEarly) {
		this.leaveEarly=leaveEarly;
		return this;
	}
	
	/**
	 * 获得 迟到<br>
	 * 分)
	 * @return 迟到
	*/
	public BigDecimal getLeaveEarlyTime() {
		return leaveEarlyTime;
	}
	
	/**
	 * 设置 迟到
	 * @param leaveEarlyTime 迟到
	 * @return 当前对象
	*/
	public AttendanceData setLeaveEarlyTime(BigDecimal leaveEarlyTime) {
		this.leaveEarlyTime=leaveEarlyTime;
		return this;
	}
	
	/**
	 * 获得 早退<br>
	 * 次)
	 * @return 早退
	*/
	public Integer getLeaveLate() {
		return leaveLate;
	}
	
	/**
	 * 设置 早退
	 * @param leaveLate 早退
	 * @return 当前对象
	*/
	public AttendanceData setLeaveLate(Integer leaveLate) {
		this.leaveLate=leaveLate;
		return this;
	}
	
	/**
	 * 获得 早退<br>
	 * 分)
	 * @return 早退
	*/
	public BigDecimal getLeaveLateTime() {
		return leaveLateTime;
	}
	
	/**
	 * 设置 早退
	 * @param leaveLateTime 早退
	 * @return 当前对象
	*/
	public AttendanceData setLeaveLateTime(BigDecimal leaveLateTime) {
		this.leaveLateTime=leaveLateTime;
		return this;
	}
	
	/**
	 * 获得 上班缺卡<br>
	 * 次)
	 * @return 上班缺卡
	*/
	public Integer getLossEarly() {
		return lossEarly;
	}
	
	/**
	 * 设置 上班缺卡
	 * @param lossEarly 上班缺卡
	 * @return 当前对象
	*/
	public AttendanceData setLossEarly(Integer lossEarly) {
		this.lossEarly=lossEarly;
		return this;
	}
	
	/**
	 * 获得 下班却卡<br>
	 * 次)
	 * @return 下班却卡
	*/
	public Integer getLossLate() {
		return lossLate;
	}
	
	/**
	 * 设置 下班却卡
	 * @param lossLate 下班却卡
	 * @return 当前对象
	*/
	public AttendanceData setLossLate(Integer lossLate) {
		this.lossLate=lossLate;
		return this;
	}
	
	/**
	 * 获得 缺卡处理<br>
	 * 次)
	 * @return 缺卡处理
	*/
	public Integer getLossProcess() {
		return lossProcess;
	}
	
	/**
	 * 设置 缺卡处理
	 * @param lossProcess 缺卡处理
	 * @return 当前对象
	*/
	public AttendanceData setLossProcess(Integer lossProcess) {
		this.lossProcess=lossProcess;
		return this;
	}
	
	/**
	 * 获得 工作日加班<br>
	 * 小时)
	 * @return 工作日加班
	*/
	public BigDecimal getJbGzr() {
		return jbGzr;
	}
	
	/**
	 * 设置 工作日加班
	 * @param jbGzr 工作日加班
	 * @return 当前对象
	*/
	public AttendanceData setJbGzr(BigDecimal jbGzr) {
		this.jbGzr=jbGzr;
		return this;
	}
	
	/**
	 * 获得 休息日加班<br>
	 * 小时)
	 * @return 休息日加班
	*/
	public BigDecimal getJbXxr() {
		return jbXxr;
	}
	
	/**
	 * 设置 休息日加班
	 * @param jbXxr 休息日加班
	 * @return 当前对象
	*/
	public AttendanceData setJbXxr(BigDecimal jbXxr) {
		this.jbXxr=jbXxr;
		return this;
	}
	
	/**
	 * 获得 节假日加班<br>
	 * 小时)
	 * @return 节假日加班
	*/
	public BigDecimal getJbJjr() {
		return jbJjr;
	}
	
	/**
	 * 设置 节假日加班
	 * @param jbJjr 节假日加班
	 * @return 当前对象
	*/
	public AttendanceData setJbJjr(BigDecimal jbJjr) {
		this.jbJjr=jbJjr;
		return this;
	}
	
	/**
	 * 获得 出差<br>
	 * 天)
	 * @return 出差
	*/
	public BigDecimal getCc() {
		return cc;
	}
	
	/**
	 * 设置 出差
	 * @param cc 出差
	 * @return 当前对象
	*/
	public AttendanceData setCc(BigDecimal cc) {
		this.cc=cc;
		return this;
	}
	
	/**
	 * 获得 年假<br>
	 * 天)
	 * @return 年假
	*/
	public BigDecimal getQjNj() {
		return qjNj;
	}
	
	/**
	 * 设置 年假
	 * @param qjNj 年假
	 * @return 当前对象
	*/
	public AttendanceData setQjNj(BigDecimal qjNj) {
		this.qjNj=qjNj;
		return this;
	}
	
	/**
	 * 获得 工伤假<br>
	 * 天)
	 * @return 工伤假
	*/
	public BigDecimal getQjGsj() {
		return qjGsj;
	}
	
	/**
	 * 设置 工伤假
	 * @param qjGsj 工伤假
	 * @return 当前对象
	*/
	public AttendanceData setQjGsj(BigDecimal qjGsj) {
		this.qjGsj=qjGsj;
		return this;
	}
	
	/**
	 * 获得 产假<br>
	 * 天)
	 * @return 产假
	*/
	public BigDecimal getQjCj() {
		return qjCj;
	}
	
	/**
	 * 设置 产假
	 * @param qjCj 产假
	 * @return 当前对象
	*/
	public AttendanceData setQjCj(BigDecimal qjCj) {
		this.qjCj=qjCj;
		return this;
	}
	
	/**
	 * 获得 婚假<br>
	 * 天)
	 * @return 婚假
	*/
	public BigDecimal getQjHj() {
		return qjHj;
	}
	
	/**
	 * 设置 婚假
	 * @param qjHj 婚假
	 * @return 当前对象
	*/
	public AttendanceData setQjHj(BigDecimal qjHj) {
		this.qjHj=qjHj;
		return this;
	}
	
	/**
	 * 获得 病假<br>
	 * 天)
	 * @return 病假
	*/
	public BigDecimal getQjBj() {
		return qjBj;
	}
	
	/**
	 * 设置 病假
	 * @param qjBj 病假
	 * @return 当前对象
	*/
	public AttendanceData setQjBj(BigDecimal qjBj) {
		this.qjBj=qjBj;
		return this;
	}
	
	/**
	 * 获得 事假<br>
	 * 天)
	 * @return 事假
	*/
	public BigDecimal getQjSj() {
		return qjSj;
	}
	
	/**
	 * 设置 事假
	 * @param qjSj 事假
	 * @return 当前对象
	*/
	public AttendanceData setQjSj(BigDecimal qjSj) {
		this.qjSj=qjSj;
		return this;
	}
	
	/**
	 * 获得 调休假<br>
	 * 天)
	 * @return 调休假
	*/
	public BigDecimal getQjTxj() {
		return qjTxj;
	}
	
	/**
	 * 设置 调休假
	 * @param qjTxj 调休假
	 * @return 当前对象
	*/
	public AttendanceData setQjTxj(BigDecimal qjTxj) {
		this.qjTxj=qjTxj;
		return this;
	}
	
	/**
	 * 获得 哺乳假<br>
	 * 天)
	 * @return 哺乳假
	*/
	public BigDecimal getQjPlj() {
		return qjPlj;
	}
	
	/**
	 * 设置 哺乳假
	 * @param qjPlj 哺乳假
	 * @return 当前对象
	*/
	public AttendanceData setQjPlj(BigDecimal qjPlj) {
		this.qjPlj=qjPlj;
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
	public AttendanceData setBatchCode(String batchCode) {
		this.batchCode=batchCode;
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
	 * 获得 关联<br>
	 * 关联
	 * @return 关联
	*/
	public String getRelId() {
		return relId;
	}
	
	/**
	 * 设置 关联
	 * @param relId 关联
	 * @return 当前对象
	*/
	public AttendanceData setRelId(String relId) {
		this.relId=relId;
		return this;
	}
	
	/**
	 * 获得 说明<br>
	 * 说明
	 * @return 说明
	*/
	public String getDayInfo() {
		return dayInfo;
	}
	
	/**
	 * 设置 说明
	 * @param dayInfo 说明
	 * @return 当前对象
	*/
	public AttendanceData setDayInfo(String dayInfo) {
		this.dayInfo=dayInfo;
		return this;
	}
	
	/**
	 * 获得 记录时间<br>
	 * 记录时间
	 * @return 记录时间
	*/
	public Date getRcdTime() {
		return rcdTime;
	}
	
	/**
	 * 设置 记录时间
	 * @param rcdTime 记录时间
	 * @return 当前对象
	*/
	public AttendanceData setRcdTime(Date rcdTime) {
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
	 * 获得 sJobNumber<br>
	 * sJobNumber
	 * @return sJobNumber
	*/
	public String getSJobNumber() {
		return sJobNumber;
	}
	
	/**
	 * 设置 sJobNumber
	 * @param sJobNumber sJobNumber
	 * @return 当前对象
	*/
	public AttendanceData setSJobNumber(String sJobNumber) {
		this.sJobNumber=sJobNumber;
		return this;
	}
	
	/**
	 * 获得 rq<br>
	 * rq
	 * @return rq
	*/
	public String getRq() {
		return rq;
	}
	
	/**
	 * 设置 rq
	 * @param rq rq
	 * @return 当前对象
	*/
	public AttendanceData setRq(String rq) {
		this.rq=rq;
		return this;
	}
	
	/**
	 * 获得 days<br>
	 * days
	 * @return days
	*/
	public String getDays() {
		return days;
	}
	
	/**
	 * 设置 days
	 * @param days days
	 * @return 当前对象
	*/
	public AttendanceData setDays(String days) {
		this.days=days;
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
		inst.setQjNj(this.getQjNj());
		inst.setNotes(this.getNotes());
		inst.setJbGzr(this.getJbGzr());
		inst.setLeaveEarlyTime(this.getLeaveEarlyTime());
		inst.setAttendanceTplCode(this.getAttendanceTplCode());
		inst.setQjGsj(this.getQjGsj());
		inst.setQjHj(this.getQjHj());
		inst.setResult(this.getResult());
		inst.setOnWorkTime(this.getOnWorkTime());
		inst.setOffWorkTime(this.getOffWorkTime());
		inst.setQjCj(this.getQjCj());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setIsWorkDay(this.getIsWorkDay());
		inst.setJbXxr(this.getJbXxr());
		inst.setJbJjr(this.getJbJjr());
		inst.setId(this.getId());
		inst.setOnWorkTime2(this.getOnWorkTime2());
		inst.setRcdTime(this.getRcdTime());
		inst.setCc(this.getCc());
		inst.setLossLate(this.getLossLate());
		inst.setRelId(this.getRelId());
		inst.setNeedDay(this.getNeedDay());
		inst.setQjSj(this.getQjSj());
		inst.setQjTxj(this.getQjTxj());
		inst.setLossEarly(this.getLossEarly());
		inst.setBatchCode(this.getBatchCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setDayInfo(this.getDayInfo());
		inst.setNormalDay(this.getNormalDay());
		inst.setLeaveEarly(this.getLeaveEarly());
		inst.setAttendanceDateStr(this.getAttendanceDateStr());
		inst.setVersion(this.getVersion());
		inst.setLossProcess(this.getLossProcess());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setQjBj(this.getQjBj());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setLeaveLateTime(this.getLeaveLateTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setLeaveLate(this.getLeaveLate());
		inst.setQjPlj(this.getQjPlj());
		inst.setAttendanceDate(this.getAttendanceDate());
		inst.setOffWorkTime2(this.getOffWorkTime2());
		if(all) {
			inst.setPerson(this.getPerson());
			inst.setAttendanceTpl(this.getAttendanceTpl());
			inst.setDays(this.getDays());
			inst.setSJobNumber(this.getSJobNumber());
			inst.setPersonJobName(this.getPersonJobName());
			inst.setRq(this.getRq());
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
			this.setQjNj(DataParser.parse(BigDecimal.class, map.get(AttendanceDataMeta.QJ_NJ)));
			this.setNotes(DataParser.parse(String.class, map.get(AttendanceDataMeta.NOTES)));
			this.setJbGzr(DataParser.parse(BigDecimal.class, map.get(AttendanceDataMeta.JB_GZR)));
			this.setLeaveEarlyTime(DataParser.parse(BigDecimal.class, map.get(AttendanceDataMeta.LEAVE_EARLY_TIME)));
			this.setAttendanceTplCode(DataParser.parse(String.class, map.get(AttendanceDataMeta.ATTENDANCE_TPL_CODE)));
			this.setQjGsj(DataParser.parse(BigDecimal.class, map.get(AttendanceDataMeta.QJ_GSJ)));
			this.setQjHj(DataParser.parse(BigDecimal.class, map.get(AttendanceDataMeta.QJ_HJ)));
			this.setResult(DataParser.parse(String.class, map.get(AttendanceDataMeta.RESULT)));
			this.setOnWorkTime(DataParser.parse(Date.class, map.get(AttendanceDataMeta.ON_WORK_TIME)));
			this.setOffWorkTime(DataParser.parse(Date.class, map.get(AttendanceDataMeta.OFF_WORK_TIME)));
			this.setQjCj(DataParser.parse(BigDecimal.class, map.get(AttendanceDataMeta.QJ_CJ)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AttendanceDataMeta.UPDATE_BY)));
			this.setIsWorkDay(DataParser.parse(String.class, map.get(AttendanceDataMeta.IS_WORK_DAY)));
			this.setJbXxr(DataParser.parse(BigDecimal.class, map.get(AttendanceDataMeta.JB_XXR)));
			this.setJbJjr(DataParser.parse(BigDecimal.class, map.get(AttendanceDataMeta.JB_JJR)));
			this.setId(DataParser.parse(String.class, map.get(AttendanceDataMeta.ID)));
			this.setOnWorkTime2(DataParser.parse(Date.class, map.get(AttendanceDataMeta.ON_WORK_TIME2)));
			this.setRcdTime(DataParser.parse(Date.class, map.get(AttendanceDataMeta.RCD_TIME)));
			this.setCc(DataParser.parse(BigDecimal.class, map.get(AttendanceDataMeta.CC)));
			this.setLossLate(DataParser.parse(Integer.class, map.get(AttendanceDataMeta.LOSS_LATE)));
			this.setRelId(DataParser.parse(String.class, map.get(AttendanceDataMeta.REL_ID)));
			this.setNeedDay(DataParser.parse(BigDecimal.class, map.get(AttendanceDataMeta.NEED_DAY)));
			this.setQjSj(DataParser.parse(BigDecimal.class, map.get(AttendanceDataMeta.QJ_SJ)));
			this.setQjTxj(DataParser.parse(BigDecimal.class, map.get(AttendanceDataMeta.QJ_TXJ)));
			this.setLossEarly(DataParser.parse(Integer.class, map.get(AttendanceDataMeta.LOSS_EARLY)));
			this.setBatchCode(DataParser.parse(String.class, map.get(AttendanceDataMeta.BATCH_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AttendanceDataMeta.UPDATE_TIME)));
			this.setDayInfo(DataParser.parse(String.class, map.get(AttendanceDataMeta.DAY_INFO)));
			this.setNormalDay(DataParser.parse(BigDecimal.class, map.get(AttendanceDataMeta.NORMAL_DAY)));
			this.setLeaveEarly(DataParser.parse(Integer.class, map.get(AttendanceDataMeta.LEAVE_EARLY)));
			this.setAttendanceDateStr(DataParser.parse(String.class, map.get(AttendanceDataMeta.ATTENDANCE_DATE_STR)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AttendanceDataMeta.VERSION)));
			this.setLossProcess(DataParser.parse(Integer.class, map.get(AttendanceDataMeta.LOSS_PROCESS)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AttendanceDataMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AttendanceDataMeta.DELETED)));
			this.setQjBj(DataParser.parse(BigDecimal.class, map.get(AttendanceDataMeta.QJ_BJ)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AttendanceDataMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AttendanceDataMeta.DELETE_TIME)));
			this.setLeaveLateTime(DataParser.parse(BigDecimal.class, map.get(AttendanceDataMeta.LEAVE_LATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AttendanceDataMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AttendanceDataMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(AttendanceDataMeta.PERSON_ID)));
			this.setLeaveLate(DataParser.parse(Integer.class, map.get(AttendanceDataMeta.LEAVE_LATE)));
			this.setQjPlj(DataParser.parse(BigDecimal.class, map.get(AttendanceDataMeta.QJ_PLJ)));
			this.setAttendanceDate(DataParser.parse(Date.class, map.get(AttendanceDataMeta.ATTENDANCE_DATE)));
			this.setOffWorkTime2(DataParser.parse(Date.class, map.get(AttendanceDataMeta.OFF_WORK_TIME2)));
			// others
			this.setPerson(DataParser.parse(Person.class, map.get(AttendanceDataMeta.PERSON)));
			this.setAttendanceTpl(DataParser.parse(AttendanceTpl.class, map.get(AttendanceDataMeta.ATTENDANCE_TPL)));
			this.setDays(DataParser.parse(String.class, map.get(AttendanceDataMeta.DAYS)));
			this.setSJobNumber(DataParser.parse(String.class, map.get(AttendanceDataMeta.S_JOB_NUMBER)));
			this.setPersonJobName(DataParser.parse(String.class, map.get(AttendanceDataMeta.PERSON_JOB_NAME)));
			this.setRq(DataParser.parse(String.class, map.get(AttendanceDataMeta.RQ)));
			return true;
		} else {
			try {
				this.setQjNj( (BigDecimal)map.get(AttendanceDataMeta.QJ_NJ));
				this.setNotes( (String)map.get(AttendanceDataMeta.NOTES));
				this.setJbGzr( (BigDecimal)map.get(AttendanceDataMeta.JB_GZR));
				this.setLeaveEarlyTime( (BigDecimal)map.get(AttendanceDataMeta.LEAVE_EARLY_TIME));
				this.setAttendanceTplCode( (String)map.get(AttendanceDataMeta.ATTENDANCE_TPL_CODE));
				this.setQjGsj( (BigDecimal)map.get(AttendanceDataMeta.QJ_GSJ));
				this.setQjHj( (BigDecimal)map.get(AttendanceDataMeta.QJ_HJ));
				this.setResult( (String)map.get(AttendanceDataMeta.RESULT));
				this.setOnWorkTime( (Date)map.get(AttendanceDataMeta.ON_WORK_TIME));
				this.setOffWorkTime( (Date)map.get(AttendanceDataMeta.OFF_WORK_TIME));
				this.setQjCj( (BigDecimal)map.get(AttendanceDataMeta.QJ_CJ));
				this.setUpdateBy( (String)map.get(AttendanceDataMeta.UPDATE_BY));
				this.setIsWorkDay( (String)map.get(AttendanceDataMeta.IS_WORK_DAY));
				this.setJbXxr( (BigDecimal)map.get(AttendanceDataMeta.JB_XXR));
				this.setJbJjr( (BigDecimal)map.get(AttendanceDataMeta.JB_JJR));
				this.setId( (String)map.get(AttendanceDataMeta.ID));
				this.setOnWorkTime2( (Date)map.get(AttendanceDataMeta.ON_WORK_TIME2));
				this.setRcdTime( (Date)map.get(AttendanceDataMeta.RCD_TIME));
				this.setCc( (BigDecimal)map.get(AttendanceDataMeta.CC));
				this.setLossLate( (Integer)map.get(AttendanceDataMeta.LOSS_LATE));
				this.setRelId( (String)map.get(AttendanceDataMeta.REL_ID));
				this.setNeedDay( (BigDecimal)map.get(AttendanceDataMeta.NEED_DAY));
				this.setQjSj( (BigDecimal)map.get(AttendanceDataMeta.QJ_SJ));
				this.setQjTxj( (BigDecimal)map.get(AttendanceDataMeta.QJ_TXJ));
				this.setLossEarly( (Integer)map.get(AttendanceDataMeta.LOSS_EARLY));
				this.setBatchCode( (String)map.get(AttendanceDataMeta.BATCH_CODE));
				this.setUpdateTime( (Date)map.get(AttendanceDataMeta.UPDATE_TIME));
				this.setDayInfo( (String)map.get(AttendanceDataMeta.DAY_INFO));
				this.setNormalDay( (BigDecimal)map.get(AttendanceDataMeta.NORMAL_DAY));
				this.setLeaveEarly( (Integer)map.get(AttendanceDataMeta.LEAVE_EARLY));
				this.setAttendanceDateStr( (String)map.get(AttendanceDataMeta.ATTENDANCE_DATE_STR));
				this.setVersion( (Integer)map.get(AttendanceDataMeta.VERSION));
				this.setLossProcess( (Integer)map.get(AttendanceDataMeta.LOSS_PROCESS));
				this.setCreateBy( (String)map.get(AttendanceDataMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AttendanceDataMeta.DELETED));
				this.setQjBj( (BigDecimal)map.get(AttendanceDataMeta.QJ_BJ));
				this.setCreateTime( (Date)map.get(AttendanceDataMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AttendanceDataMeta.DELETE_TIME));
				this.setLeaveLateTime( (BigDecimal)map.get(AttendanceDataMeta.LEAVE_LATE_TIME));
				this.setTenantId( (String)map.get(AttendanceDataMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AttendanceDataMeta.DELETE_BY));
				this.setPersonId( (String)map.get(AttendanceDataMeta.PERSON_ID));
				this.setLeaveLate( (Integer)map.get(AttendanceDataMeta.LEAVE_LATE));
				this.setQjPlj( (BigDecimal)map.get(AttendanceDataMeta.QJ_PLJ));
				this.setAttendanceDate( (Date)map.get(AttendanceDataMeta.ATTENDANCE_DATE));
				this.setOffWorkTime2( (Date)map.get(AttendanceDataMeta.OFF_WORK_TIME2));
				// others
				this.setPerson( (Person)map.get(AttendanceDataMeta.PERSON));
				this.setAttendanceTpl( (AttendanceTpl)map.get(AttendanceDataMeta.ATTENDANCE_TPL));
				this.setDays( (String)map.get(AttendanceDataMeta.DAYS));
				this.setSJobNumber( (String)map.get(AttendanceDataMeta.S_JOB_NUMBER));
				this.setPersonJobName( (String)map.get(AttendanceDataMeta.PERSON_JOB_NAME));
				this.setRq( (String)map.get(AttendanceDataMeta.RQ));
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
			this.setQjNj(DataParser.parse(BigDecimal.class, r.getValue(AttendanceDataMeta.QJ_NJ)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.NOTES)));
			this.setJbGzr(DataParser.parse(BigDecimal.class, r.getValue(AttendanceDataMeta.JB_GZR)));
			this.setLeaveEarlyTime(DataParser.parse(BigDecimal.class, r.getValue(AttendanceDataMeta.LEAVE_EARLY_TIME)));
			this.setAttendanceTplCode(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.ATTENDANCE_TPL_CODE)));
			this.setQjGsj(DataParser.parse(BigDecimal.class, r.getValue(AttendanceDataMeta.QJ_GSJ)));
			this.setQjHj(DataParser.parse(BigDecimal.class, r.getValue(AttendanceDataMeta.QJ_HJ)));
			this.setResult(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.RESULT)));
			this.setOnWorkTime(DataParser.parse(Date.class, r.getValue(AttendanceDataMeta.ON_WORK_TIME)));
			this.setOffWorkTime(DataParser.parse(Date.class, r.getValue(AttendanceDataMeta.OFF_WORK_TIME)));
			this.setQjCj(DataParser.parse(BigDecimal.class, r.getValue(AttendanceDataMeta.QJ_CJ)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.UPDATE_BY)));
			this.setIsWorkDay(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.IS_WORK_DAY)));
			this.setJbXxr(DataParser.parse(BigDecimal.class, r.getValue(AttendanceDataMeta.JB_XXR)));
			this.setJbJjr(DataParser.parse(BigDecimal.class, r.getValue(AttendanceDataMeta.JB_JJR)));
			this.setId(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.ID)));
			this.setOnWorkTime2(DataParser.parse(Date.class, r.getValue(AttendanceDataMeta.ON_WORK_TIME2)));
			this.setRcdTime(DataParser.parse(Date.class, r.getValue(AttendanceDataMeta.RCD_TIME)));
			this.setCc(DataParser.parse(BigDecimal.class, r.getValue(AttendanceDataMeta.CC)));
			this.setLossLate(DataParser.parse(Integer.class, r.getValue(AttendanceDataMeta.LOSS_LATE)));
			this.setRelId(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.REL_ID)));
			this.setNeedDay(DataParser.parse(BigDecimal.class, r.getValue(AttendanceDataMeta.NEED_DAY)));
			this.setQjSj(DataParser.parse(BigDecimal.class, r.getValue(AttendanceDataMeta.QJ_SJ)));
			this.setQjTxj(DataParser.parse(BigDecimal.class, r.getValue(AttendanceDataMeta.QJ_TXJ)));
			this.setLossEarly(DataParser.parse(Integer.class, r.getValue(AttendanceDataMeta.LOSS_EARLY)));
			this.setBatchCode(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.BATCH_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AttendanceDataMeta.UPDATE_TIME)));
			this.setDayInfo(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.DAY_INFO)));
			this.setNormalDay(DataParser.parse(BigDecimal.class, r.getValue(AttendanceDataMeta.NORMAL_DAY)));
			this.setLeaveEarly(DataParser.parse(Integer.class, r.getValue(AttendanceDataMeta.LEAVE_EARLY)));
			this.setAttendanceDateStr(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.ATTENDANCE_DATE_STR)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AttendanceDataMeta.VERSION)));
			this.setLossProcess(DataParser.parse(Integer.class, r.getValue(AttendanceDataMeta.LOSS_PROCESS)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AttendanceDataMeta.DELETED)));
			this.setQjBj(DataParser.parse(BigDecimal.class, r.getValue(AttendanceDataMeta.QJ_BJ)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AttendanceDataMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AttendanceDataMeta.DELETE_TIME)));
			this.setLeaveLateTime(DataParser.parse(BigDecimal.class, r.getValue(AttendanceDataMeta.LEAVE_LATE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(AttendanceDataMeta.PERSON_ID)));
			this.setLeaveLate(DataParser.parse(Integer.class, r.getValue(AttendanceDataMeta.LEAVE_LATE)));
			this.setQjPlj(DataParser.parse(BigDecimal.class, r.getValue(AttendanceDataMeta.QJ_PLJ)));
			this.setAttendanceDate(DataParser.parse(Date.class, r.getValue(AttendanceDataMeta.ATTENDANCE_DATE)));
			this.setOffWorkTime2(DataParser.parse(Date.class, r.getValue(AttendanceDataMeta.OFF_WORK_TIME2)));
			return true;
		} else {
			try {
				this.setQjNj( (BigDecimal)r.getValue(AttendanceDataMeta.QJ_NJ));
				this.setNotes( (String)r.getValue(AttendanceDataMeta.NOTES));
				this.setJbGzr( (BigDecimal)r.getValue(AttendanceDataMeta.JB_GZR));
				this.setLeaveEarlyTime( (BigDecimal)r.getValue(AttendanceDataMeta.LEAVE_EARLY_TIME));
				this.setAttendanceTplCode( (String)r.getValue(AttendanceDataMeta.ATTENDANCE_TPL_CODE));
				this.setQjGsj( (BigDecimal)r.getValue(AttendanceDataMeta.QJ_GSJ));
				this.setQjHj( (BigDecimal)r.getValue(AttendanceDataMeta.QJ_HJ));
				this.setResult( (String)r.getValue(AttendanceDataMeta.RESULT));
				this.setOnWorkTime( (Date)r.getValue(AttendanceDataMeta.ON_WORK_TIME));
				this.setOffWorkTime( (Date)r.getValue(AttendanceDataMeta.OFF_WORK_TIME));
				this.setQjCj( (BigDecimal)r.getValue(AttendanceDataMeta.QJ_CJ));
				this.setUpdateBy( (String)r.getValue(AttendanceDataMeta.UPDATE_BY));
				this.setIsWorkDay( (String)r.getValue(AttendanceDataMeta.IS_WORK_DAY));
				this.setJbXxr( (BigDecimal)r.getValue(AttendanceDataMeta.JB_XXR));
				this.setJbJjr( (BigDecimal)r.getValue(AttendanceDataMeta.JB_JJR));
				this.setId( (String)r.getValue(AttendanceDataMeta.ID));
				this.setOnWorkTime2( (Date)r.getValue(AttendanceDataMeta.ON_WORK_TIME2));
				this.setRcdTime( (Date)r.getValue(AttendanceDataMeta.RCD_TIME));
				this.setCc( (BigDecimal)r.getValue(AttendanceDataMeta.CC));
				this.setLossLate( (Integer)r.getValue(AttendanceDataMeta.LOSS_LATE));
				this.setRelId( (String)r.getValue(AttendanceDataMeta.REL_ID));
				this.setNeedDay( (BigDecimal)r.getValue(AttendanceDataMeta.NEED_DAY));
				this.setQjSj( (BigDecimal)r.getValue(AttendanceDataMeta.QJ_SJ));
				this.setQjTxj( (BigDecimal)r.getValue(AttendanceDataMeta.QJ_TXJ));
				this.setLossEarly( (Integer)r.getValue(AttendanceDataMeta.LOSS_EARLY));
				this.setBatchCode( (String)r.getValue(AttendanceDataMeta.BATCH_CODE));
				this.setUpdateTime( (Date)r.getValue(AttendanceDataMeta.UPDATE_TIME));
				this.setDayInfo( (String)r.getValue(AttendanceDataMeta.DAY_INFO));
				this.setNormalDay( (BigDecimal)r.getValue(AttendanceDataMeta.NORMAL_DAY));
				this.setLeaveEarly( (Integer)r.getValue(AttendanceDataMeta.LEAVE_EARLY));
				this.setAttendanceDateStr( (String)r.getValue(AttendanceDataMeta.ATTENDANCE_DATE_STR));
				this.setVersion( (Integer)r.getValue(AttendanceDataMeta.VERSION));
				this.setLossProcess( (Integer)r.getValue(AttendanceDataMeta.LOSS_PROCESS));
				this.setCreateBy( (String)r.getValue(AttendanceDataMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AttendanceDataMeta.DELETED));
				this.setQjBj( (BigDecimal)r.getValue(AttendanceDataMeta.QJ_BJ));
				this.setCreateTime( (Date)r.getValue(AttendanceDataMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AttendanceDataMeta.DELETE_TIME));
				this.setLeaveLateTime( (BigDecimal)r.getValue(AttendanceDataMeta.LEAVE_LATE_TIME));
				this.setTenantId( (String)r.getValue(AttendanceDataMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AttendanceDataMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(AttendanceDataMeta.PERSON_ID));
				this.setLeaveLate( (Integer)r.getValue(AttendanceDataMeta.LEAVE_LATE));
				this.setQjPlj( (BigDecimal)r.getValue(AttendanceDataMeta.QJ_PLJ));
				this.setAttendanceDate( (Date)r.getValue(AttendanceDataMeta.ATTENDANCE_DATE));
				this.setOffWorkTime2( (Date)r.getValue(AttendanceDataMeta.OFF_WORK_TIME2));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}