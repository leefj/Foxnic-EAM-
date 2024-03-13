package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ASSESSMENT_BILL_USER_MAP;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.AssessmentBillUserMapMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 人员映射
 * <p>人员映射 , 数据表 hr_assessment_bill_user_map 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-13 10:58:35
 * @sign 23558D4CD977ACEC07849DE22C5B4AC4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_assessment_bill_user_map")
@ApiModel(description = "人员映射 ; 人员映射 , 数据表 hr_assessment_bill_user_map 的PO类型")
public class AssessmentBillUserMap extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ASSESSMENT_BILL_USER_MAP.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "819278441642721280")
	private String id;
	
	/**
	 * 单据：单据
	*/
	@ApiModelProperty(required = false,value="单据" , notes = "单据" , example = "819278440770306048")
	private String billId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 部门：部门
	*/
	@ApiModelProperty(required = false,value="部门" , notes = "部门")
	private String orgId;
	
	/**
	 * 被考核人：被考核人
	*/
	@ApiModelProperty(required = false,value="被考核人" , notes = "被考核人" , example = "590511680593592320")
	private String assesseeId;
	
	/**
	 * 直属领导：直属领导
	*/
	@ApiModelProperty(required = false,value="直属领导" , notes = "直属领导")
	private String leaderId;
	
	/**
	 * 上上级领导：上上级领导
	*/
	@ApiModelProperty(required = false,value="上上级领导" , notes = "上上级领导")
	private String secondLeaderId;
	
	/**
	 * HR复核人：HR复核人
	*/
	@ApiModelProperty(required = false,value="HR复核人" , notes = "HR复核人" , example = "617107757929070592")
	private String hrUserId;
	
	/**
	 * 生成状态：生成状态
	*/
	@ApiModelProperty(required = false,value="生成状态" , notes = "生成状态" , example = "success")
	private String result;
	
	/**
	 * 生成结果：生成结果
	*/
	@ApiModelProperty(required = false,value="生成结果" , notes = "生成结果")
	private String message;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-03-10 06:40:02")
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
	 * assessmentTask：assessmentTask
	*/
	@ApiModelProperty(required = false,value="assessmentTask" , notes = "assessmentTask")
	private AssessmentTask assessmentTask;
	
	/**
	 * assesseeUser：assesseeUser
	*/
	@ApiModelProperty(required = false,value="assesseeUser" , notes = "assesseeUser")
	private Employee assesseeUser;
	
	/**
	 * sameUserList：sameUserList
	*/
	@ApiModelProperty(required = false,value="sameUserList" , notes = "sameUserList")
	private List<Employee> sameUserList;
	
	/**
	 * sameUserIds：sameUserIds
	*/
	@ApiModelProperty(required = false,value="sameUserIds" , notes = "sameUserIds")
	private List<String> sameUserIds;
	
	/**
	 * leaderUser：leaderUser
	*/
	@ApiModelProperty(required = false,value="leaderUser" , notes = "leaderUser")
	private Employee leaderUser;
	
	/**
	 * secondLeaderUser：secondLeaderUser
	*/
	@ApiModelProperty(required = false,value="secondLeaderUser" , notes = "secondLeaderUser")
	private Employee secondLeaderUser;
	
	/**
	 * hrUser：hrUser
	*/
	@ApiModelProperty(required = false,value="hrUser" , notes = "hrUser")
	private Employee hrUser;
	
	/**
	 * sameUserListRel：sameUserListRel
	*/
	@ApiModelProperty(required = false,value="sameUserListRel" , notes = "sameUserListRel")
	private List<Employee> sameUserListRel;
	
	/**
	 * sameUserIdsRel：sameUserIdsRel
	*/
	@ApiModelProperty(required = false,value="sameUserIdsRel" , notes = "sameUserIdsRel")
	private List<String> sameUserIdsRel;
	
	/**
	 * leaderUserRel：leaderUserRel
	*/
	@ApiModelProperty(required = false,value="leaderUserRel" , notes = "leaderUserRel")
	private Employee leaderUserRel;
	
	/**
	 * leaderUserIdRel：leaderUserIdRel
	*/
	@ApiModelProperty(required = false,value="leaderUserIdRel" , notes = "leaderUserIdRel")
	private String leaderUserIdRel;
	
	/**
	 * secondLeaderUserRel：secondLeaderUserRel
	*/
	@ApiModelProperty(required = false,value="secondLeaderUserRel" , notes = "secondLeaderUserRel")
	private Employee secondLeaderUserRel;
	
	/**
	 * secondLeaderUserIdRel：secondLeaderUserIdRel
	*/
	@ApiModelProperty(required = false,value="secondLeaderUserIdRel" , notes = "secondLeaderUserIdRel")
	private String secondLeaderUserIdRel;
	
	/**
	 * assessmentBillTaskList：assessmentBillTaskList
	*/
	@ApiModelProperty(required = false,value="assessmentBillTaskList" , notes = "assessmentBillTaskList")
	private AssessmentBillTask assessmentBillTaskList;
	
	/**
	 * selfScoreValue：selfScoreValue
	*/
	@ApiModelProperty(required = false,value="selfScoreValue" , notes = "selfScoreValue")
	private String selfScoreValue;
	
	/**
	 * sameUserAvgScoreValue：sameUserAvgScoreValue
	*/
	@ApiModelProperty(required = false,value="sameUserAvgScoreValue" , notes = "sameUserAvgScoreValue")
	private String sameUserAvgScoreValue;
	
	/**
	 * sameUserNeedCount：sameUserNeedCount
	*/
	@ApiModelProperty(required = false,value="sameUserNeedCount" , notes = "sameUserNeedCount")
	private String sameUserNeedCount;
	
	/**
	 * sameUserFinishCount：sameUserFinishCount
	*/
	@ApiModelProperty(required = false,value="sameUserFinishCount" , notes = "sameUserFinishCount")
	private String sameUserFinishCount;
	
	/**
	 * leaderScoreValue：sameUserScoreValue
	*/
	@ApiModelProperty(required = false,value="leaderScoreValue" , notes = "sameUserScoreValue")
	private String leaderScoreValue;
	
	/**
	 * secondLeaderScoreValue：secondLeaderScoreValue
	*/
	@ApiModelProperty(required = false,value="secondLeaderScoreValue" , notes = "secondLeaderScoreValue")
	private String secondLeaderScoreValue;
	
	/**
	 * ifHrConfirm：ifHrConfirm
	*/
	@ApiModelProperty(required = false,value="ifHrConfirm" , notes = "ifHrConfirm")
	private String ifHrConfirm;
	
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
	public AssessmentBillUserMap setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 单据<br>
	 * 单据
	 * @return 单据
	*/
	public String getBillId() {
		return billId;
	}
	
	/**
	 * 设置 单据
	 * @param billId 单据
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setBillId(String billId) {
		this.billId=billId;
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
	public AssessmentBillUserMap setStatus(String status) {
		this.status=status;
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
	public AssessmentBillUserMap setOrgId(String orgId) {
		this.orgId=orgId;
		return this;
	}
	
	/**
	 * 获得 被考核人<br>
	 * 被考核人
	 * @return 被考核人
	*/
	public String getAssesseeId() {
		return assesseeId;
	}
	
	/**
	 * 设置 被考核人
	 * @param assesseeId 被考核人
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setAssesseeId(String assesseeId) {
		this.assesseeId=assesseeId;
		return this;
	}
	
	/**
	 * 获得 直属领导<br>
	 * 直属领导
	 * @return 直属领导
	*/
	public String getLeaderId() {
		return leaderId;
	}
	
	/**
	 * 设置 直属领导
	 * @param leaderId 直属领导
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setLeaderId(String leaderId) {
		this.leaderId=leaderId;
		return this;
	}
	
	/**
	 * 获得 上上级领导<br>
	 * 上上级领导
	 * @return 上上级领导
	*/
	public String getSecondLeaderId() {
		return secondLeaderId;
	}
	
	/**
	 * 设置 上上级领导
	 * @param secondLeaderId 上上级领导
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setSecondLeaderId(String secondLeaderId) {
		this.secondLeaderId=secondLeaderId;
		return this;
	}
	
	/**
	 * 获得 HR复核人<br>
	 * HR复核人
	 * @return HR复核人
	*/
	public String getHrUserId() {
		return hrUserId;
	}
	
	/**
	 * 设置 HR复核人
	 * @param hrUserId HR复核人
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setHrUserId(String hrUserId) {
		this.hrUserId=hrUserId;
		return this;
	}
	
	/**
	 * 获得 生成状态<br>
	 * 生成状态
	 * @return 生成状态
	*/
	public String getResult() {
		return result;
	}
	
	/**
	 * 设置 生成状态
	 * @param result 生成状态
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setResult(String result) {
		this.result=result;
		return this;
	}
	
	/**
	 * 获得 生成结果<br>
	 * 生成结果
	 * @return 生成结果
	*/
	public String getMessage() {
		return message;
	}
	
	/**
	 * 设置 生成结果
	 * @param message 生成结果
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setMessage(String message) {
		this.message=message;
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
	public AssessmentBillUserMap setCreateBy(String createBy) {
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
	public AssessmentBillUserMap setCreateTime(Date createTime) {
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
	public AssessmentBillUserMap setUpdateBy(String updateBy) {
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
	public AssessmentBillUserMap setUpdateTime(Date updateTime) {
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
	public AssessmentBillUserMap setDeleted(Integer deleted) {
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
	public AssessmentBillUserMap setDeleted(Boolean deletedBool) {
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
	public AssessmentBillUserMap setDeleteBy(String deleteBy) {
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
	public AssessmentBillUserMap setDeleteTime(Date deleteTime) {
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
	public AssessmentBillUserMap setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 assessmentTask<br>
	 * assessmentTask
	 * @return assessmentTask
	*/
	public AssessmentTask getAssessmentTask() {
		return assessmentTask;
	}
	
	/**
	 * 设置 assessmentTask
	 * @param assessmentTask assessmentTask
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setAssessmentTask(AssessmentTask assessmentTask) {
		this.assessmentTask=assessmentTask;
		return this;
	}
	
	/**
	 * 获得 assesseeUser<br>
	 * assesseeUser
	 * @return assesseeUser
	*/
	public Employee getAssesseeUser() {
		return assesseeUser;
	}
	
	/**
	 * 设置 assesseeUser
	 * @param assesseeUser assesseeUser
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setAssesseeUser(Employee assesseeUser) {
		this.assesseeUser=assesseeUser;
		return this;
	}
	
	/**
	 * 获得 sameUserList<br>
	 * sameUserList
	 * @return sameUserList
	*/
	public List<Employee> getSameUserList() {
		return sameUserList;
	}
	
	/**
	 * 设置 sameUserList
	 * @param sameUserList sameUserList
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setSameUserList(List<Employee> sameUserList) {
		this.sameUserList=sameUserList;
		return this;
	}
	
	/**
	 * 添加 sameUserList
	 * @param sameUser sameUserList
	 * @return 当前对象
	*/
	public AssessmentBillUserMap addSameUser(Employee... sameUser) {
		if(this.sameUserList==null) sameUserList=new ArrayList<>();
		this.sameUserList.addAll(Arrays.asList(sameUser));
		return this;
	}
	
	/**
	 * 获得 sameUserIds<br>
	 * sameUserIds
	 * @return sameUserIds
	*/
	public List<String> getSameUserIds() {
		return sameUserIds;
	}
	
	/**
	 * 设置 sameUserIds
	 * @param sameUserIds sameUserIds
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setSameUserIds(List<String> sameUserIds) {
		this.sameUserIds=sameUserIds;
		return this;
	}
	
	/**
	 * 添加 sameUserIds
	 * @param sameUserId sameUserIds
	 * @return 当前对象
	*/
	public AssessmentBillUserMap addSameUserId(String... sameUserId) {
		if(this.sameUserIds==null) sameUserIds=new ArrayList<>();
		this.sameUserIds.addAll(Arrays.asList(sameUserId));
		return this;
	}
	
	/**
	 * 获得 leaderUser<br>
	 * leaderUser
	 * @return leaderUser
	*/
	public Employee getLeaderUser() {
		return leaderUser;
	}
	
	/**
	 * 设置 leaderUser
	 * @param leaderUser leaderUser
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setLeaderUser(Employee leaderUser) {
		this.leaderUser=leaderUser;
		return this;
	}
	
	/**
	 * 获得 secondLeaderUser<br>
	 * secondLeaderUser
	 * @return secondLeaderUser
	*/
	public Employee getSecondLeaderUser() {
		return secondLeaderUser;
	}
	
	/**
	 * 设置 secondLeaderUser
	 * @param secondLeaderUser secondLeaderUser
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setSecondLeaderUser(Employee secondLeaderUser) {
		this.secondLeaderUser=secondLeaderUser;
		return this;
	}
	
	/**
	 * 获得 hrUser<br>
	 * hrUser
	 * @return hrUser
	*/
	public Employee getHrUser() {
		return hrUser;
	}
	
	/**
	 * 设置 hrUser
	 * @param hrUser hrUser
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setHrUser(Employee hrUser) {
		this.hrUser=hrUser;
		return this;
	}
	
	/**
	 * 获得 sameUserListRel<br>
	 * sameUserListRel
	 * @return sameUserListRel
	*/
	public List<Employee> getSameUserListRel() {
		return sameUserListRel;
	}
	
	/**
	 * 设置 sameUserListRel
	 * @param sameUserListRel sameUserListRel
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setSameUserListRel(List<Employee> sameUserListRel) {
		this.sameUserListRel=sameUserListRel;
		return this;
	}
	
	/**
	 * 添加 sameUserListRel
	 * @param entity sameUserListRel
	 * @return 当前对象
	*/
	public AssessmentBillUserMap addSameUserListRel(Employee... entity) {
		if(this.sameUserListRel==null) sameUserListRel=new ArrayList<>();
		this.sameUserListRel.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 sameUserIdsRel<br>
	 * sameUserIdsRel
	 * @return sameUserIdsRel
	*/
	public List<String> getSameUserIdsRel() {
		return sameUserIdsRel;
	}
	
	/**
	 * 设置 sameUserIdsRel
	 * @param sameUserIdsRel sameUserIdsRel
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setSameUserIdsRel(List<String> sameUserIdsRel) {
		this.sameUserIdsRel=sameUserIdsRel;
		return this;
	}
	
	/**
	 * 添加 sameUserIdsRel
	 * @param entity sameUserIdsRel
	 * @return 当前对象
	*/
	public AssessmentBillUserMap addSameUserIdsRel(String... entity) {
		if(this.sameUserIdsRel==null) sameUserIdsRel=new ArrayList<>();
		this.sameUserIdsRel.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 leaderUserRel<br>
	 * leaderUserRel
	 * @return leaderUserRel
	*/
	public Employee getLeaderUserRel() {
		return leaderUserRel;
	}
	
	/**
	 * 设置 leaderUserRel
	 * @param leaderUserRel leaderUserRel
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setLeaderUserRel(Employee leaderUserRel) {
		this.leaderUserRel=leaderUserRel;
		return this;
	}
	
	/**
	 * 获得 leaderUserIdRel<br>
	 * leaderUserIdRel
	 * @return leaderUserIdRel
	*/
	public String getLeaderUserIdRel() {
		return leaderUserIdRel;
	}
	
	/**
	 * 设置 leaderUserIdRel
	 * @param leaderUserIdRel leaderUserIdRel
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setLeaderUserIdRel(String leaderUserIdRel) {
		this.leaderUserIdRel=leaderUserIdRel;
		return this;
	}
	
	/**
	 * 获得 secondLeaderUserRel<br>
	 * secondLeaderUserRel
	 * @return secondLeaderUserRel
	*/
	public Employee getSecondLeaderUserRel() {
		return secondLeaderUserRel;
	}
	
	/**
	 * 设置 secondLeaderUserRel
	 * @param secondLeaderUserRel secondLeaderUserRel
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setSecondLeaderUserRel(Employee secondLeaderUserRel) {
		this.secondLeaderUserRel=secondLeaderUserRel;
		return this;
	}
	
	/**
	 * 获得 secondLeaderUserIdRel<br>
	 * secondLeaderUserIdRel
	 * @return secondLeaderUserIdRel
	*/
	public String getSecondLeaderUserIdRel() {
		return secondLeaderUserIdRel;
	}
	
	/**
	 * 设置 secondLeaderUserIdRel
	 * @param secondLeaderUserIdRel secondLeaderUserIdRel
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setSecondLeaderUserIdRel(String secondLeaderUserIdRel) {
		this.secondLeaderUserIdRel=secondLeaderUserIdRel;
		return this;
	}
	
	/**
	 * 获得 assessmentBillTaskList<br>
	 * assessmentBillTaskList
	 * @return assessmentBillTaskList
	*/
	public AssessmentBillTask getAssessmentBillTaskList() {
		return assessmentBillTaskList;
	}
	
	/**
	 * 设置 assessmentBillTaskList
	 * @param assessmentBillTaskList assessmentBillTaskList
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setAssessmentBillTaskList(AssessmentBillTask assessmentBillTaskList) {
		this.assessmentBillTaskList=assessmentBillTaskList;
		return this;
	}
	
	/**
	 * 获得 selfScoreValue<br>
	 * selfScoreValue
	 * @return selfScoreValue
	*/
	public String getSelfScoreValue() {
		return selfScoreValue;
	}
	
	/**
	 * 设置 selfScoreValue
	 * @param selfScoreValue selfScoreValue
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setSelfScoreValue(String selfScoreValue) {
		this.selfScoreValue=selfScoreValue;
		return this;
	}
	
	/**
	 * 获得 sameUserAvgScoreValue<br>
	 * sameUserAvgScoreValue
	 * @return sameUserAvgScoreValue
	*/
	public String getSameUserAvgScoreValue() {
		return sameUserAvgScoreValue;
	}
	
	/**
	 * 设置 sameUserAvgScoreValue
	 * @param sameUserAvgScoreValue sameUserAvgScoreValue
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setSameUserAvgScoreValue(String sameUserAvgScoreValue) {
		this.sameUserAvgScoreValue=sameUserAvgScoreValue;
		return this;
	}
	
	/**
	 * 获得 sameUserNeedCount<br>
	 * sameUserNeedCount
	 * @return sameUserNeedCount
	*/
	public String getSameUserNeedCount() {
		return sameUserNeedCount;
	}
	
	/**
	 * 设置 sameUserNeedCount
	 * @param sameUserNeedCount sameUserNeedCount
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setSameUserNeedCount(String sameUserNeedCount) {
		this.sameUserNeedCount=sameUserNeedCount;
		return this;
	}
	
	/**
	 * 获得 sameUserFinishCount<br>
	 * sameUserFinishCount
	 * @return sameUserFinishCount
	*/
	public String getSameUserFinishCount() {
		return sameUserFinishCount;
	}
	
	/**
	 * 设置 sameUserFinishCount
	 * @param sameUserFinishCount sameUserFinishCount
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setSameUserFinishCount(String sameUserFinishCount) {
		this.sameUserFinishCount=sameUserFinishCount;
		return this;
	}
	
	/**
	 * 获得 leaderScoreValue<br>
	 * sameUserScoreValue
	 * @return leaderScoreValue
	*/
	public String getLeaderScoreValue() {
		return leaderScoreValue;
	}
	
	/**
	 * 设置 leaderScoreValue
	 * @param leaderScoreValue leaderScoreValue
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setLeaderScoreValue(String leaderScoreValue) {
		this.leaderScoreValue=leaderScoreValue;
		return this;
	}
	
	/**
	 * 获得 secondLeaderScoreValue<br>
	 * secondLeaderScoreValue
	 * @return secondLeaderScoreValue
	*/
	public String getSecondLeaderScoreValue() {
		return secondLeaderScoreValue;
	}
	
	/**
	 * 设置 secondLeaderScoreValue
	 * @param secondLeaderScoreValue secondLeaderScoreValue
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setSecondLeaderScoreValue(String secondLeaderScoreValue) {
		this.secondLeaderScoreValue=secondLeaderScoreValue;
		return this;
	}
	
	/**
	 * 获得 ifHrConfirm<br>
	 * ifHrConfirm
	 * @return ifHrConfirm
	*/
	public String getIfHrConfirm() {
		return ifHrConfirm;
	}
	
	/**
	 * 设置 ifHrConfirm
	 * @param ifHrConfirm ifHrConfirm
	 * @return 当前对象
	*/
	public AssessmentBillUserMap setIfHrConfirm(String ifHrConfirm) {
		this.ifHrConfirm=ifHrConfirm;
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
	public AssessmentBillUserMap setSOrgId(String sOrgId) {
		this.sOrgId=sOrgId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssessmentBillUserMap , 转换好的 AssessmentBillUserMap 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssessmentBillUserMap , 转换好的 PoJo 对象
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
	public AssessmentBillUserMap clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssessmentBillUserMap duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AssessmentBillUserMapMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AssessmentBillUserMapMeta.$$proxy$$();
		inst.setHrUserId(this.getHrUserId());
		inst.setSecondLeaderId(this.getSecondLeaderId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setMessage(this.getMessage());
		inst.setVersion(this.getVersion());
		inst.setOrgId(this.getOrgId());
		inst.setLeaderId(this.getLeaderId());
		inst.setAssesseeId(this.getAssesseeId());
		inst.setResult(this.getResult());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setBillId(this.getBillId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setAssesseeUser(this.getAssesseeUser());
			inst.setSameUserList(this.getSameUserList());
			inst.setSameUserAvgScoreValue(this.getSameUserAvgScoreValue());
			inst.setSameUserNeedCount(this.getSameUserNeedCount());
			inst.setSameUserFinishCount(this.getSameUserFinishCount());
			inst.setSecondLeaderUser(this.getSecondLeaderUser());
			inst.setIfHrConfirm(this.getIfHrConfirm());
			inst.setSOrgId(this.getSOrgId());
			inst.setLeaderUserRel(this.getLeaderUserRel());
			inst.setSecondLeaderUserIdRel(this.getSecondLeaderUserIdRel());
			inst.setSecondLeaderUserRel(this.getSecondLeaderUserRel());
			inst.setLeaderUser(this.getLeaderUser());
			inst.setLeaderUserIdRel(this.getLeaderUserIdRel());
			inst.setHrUser(this.getHrUser());
			inst.setSameUserListRel(this.getSameUserListRel());
			inst.setSameUserIdsRel(this.getSameUserIdsRel());
			inst.setAssessmentTask(this.getAssessmentTask());
			inst.setSameUserIds(this.getSameUserIds());
			inst.setAssessmentBillTaskList(this.getAssessmentBillTaskList());
			inst.setLeaderScoreValue(this.getLeaderScoreValue());
			inst.setSelfScoreValue(this.getSelfScoreValue());
			inst.setSecondLeaderScoreValue(this.getSecondLeaderScoreValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssessmentBillUserMap clone(boolean deep) {
		return EntityContext.clone(AssessmentBillUserMap.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssessmentBillUserMap
	 * @param assessmentBillUserMapMap 包含实体信息的 Map 对象
	 * @return AssessmentBillUserMap , 转换好的的 AssessmentBillUserMap 对象
	*/
	@Transient
	public static AssessmentBillUserMap createFrom(Map<String,Object> assessmentBillUserMapMap) {
		if(assessmentBillUserMapMap==null) return null;
		AssessmentBillUserMap po = create();
		EntityContext.copyProperties(po,assessmentBillUserMapMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssessmentBillUserMap
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssessmentBillUserMap , 转换好的的 AssessmentBillUserMap 对象
	*/
	@Transient
	public static AssessmentBillUserMap createFrom(Object pojo) {
		if(pojo==null) return null;
		AssessmentBillUserMap po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssessmentBillUserMap，等同于 new
	 * @return AssessmentBillUserMap 对象
	*/
	@Transient
	public static AssessmentBillUserMap create() {
		return new com.dt.platform.domain.hr.meta.AssessmentBillUserMapMeta.$$proxy$$();
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
			this.setHrUserId(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.HR_USER_ID)));
			this.setSecondLeaderId(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.SECOND_LEADER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentBillUserMapMeta.UPDATE_TIME)));
			this.setMessage(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.MESSAGE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssessmentBillUserMapMeta.VERSION)));
			this.setOrgId(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.ORG_ID)));
			this.setLeaderId(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.LEADER_ID)));
			this.setAssesseeId(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.ASSESSEE_ID)));
			this.setResult(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.RESULT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssessmentBillUserMapMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssessmentBillUserMapMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssessmentBillUserMapMeta.DELETE_TIME)));
			this.setBillId(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.BILL_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.STATUS)));
			// others
			this.setAssesseeUser(DataParser.parse(Employee.class, map.get(AssessmentBillUserMapMeta.ASSESSEE_USER)));
			this.setSameUserAvgScoreValue(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.SAME_USER_AVG_SCORE_VALUE)));
			this.setSameUserNeedCount(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.SAME_USER_NEED_COUNT)));
			this.setSameUserFinishCount(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.SAME_USER_FINISH_COUNT)));
			this.setSecondLeaderUser(DataParser.parse(Employee.class, map.get(AssessmentBillUserMapMeta.SECOND_LEADER_USER)));
			this.setIfHrConfirm(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.IF_HR_CONFIRM)));
			this.setSOrgId(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.S_ORG_ID)));
			this.setLeaderUserRel(DataParser.parse(Employee.class, map.get(AssessmentBillUserMapMeta.LEADER_USER_REL)));
			this.setSecondLeaderUserIdRel(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.SECOND_LEADER_USER_ID_REL)));
			this.setSecondLeaderUserRel(DataParser.parse(Employee.class, map.get(AssessmentBillUserMapMeta.SECOND_LEADER_USER_REL)));
			this.setLeaderUser(DataParser.parse(Employee.class, map.get(AssessmentBillUserMapMeta.LEADER_USER)));
			this.setLeaderUserIdRel(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.LEADER_USER_ID_REL)));
			this.setHrUser(DataParser.parse(Employee.class, map.get(AssessmentBillUserMapMeta.HR_USER)));
			this.setAssessmentTask(DataParser.parse(AssessmentTask.class, map.get(AssessmentBillUserMapMeta.ASSESSMENT_TASK)));
			this.setAssessmentBillTaskList(DataParser.parse(AssessmentBillTask.class, map.get(AssessmentBillUserMapMeta.ASSESSMENT_BILL_TASK_LIST)));
			this.setLeaderScoreValue(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.LEADER_SCORE_VALUE)));
			this.setSelfScoreValue(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.SELF_SCORE_VALUE)));
			this.setSecondLeaderScoreValue(DataParser.parse(String.class, map.get(AssessmentBillUserMapMeta.SECOND_LEADER_SCORE_VALUE)));
			return true;
		} else {
			try {
				this.setHrUserId( (String)map.get(AssessmentBillUserMapMeta.HR_USER_ID));
				this.setSecondLeaderId( (String)map.get(AssessmentBillUserMapMeta.SECOND_LEADER_ID));
				this.setUpdateTime( (Date)map.get(AssessmentBillUserMapMeta.UPDATE_TIME));
				this.setMessage( (String)map.get(AssessmentBillUserMapMeta.MESSAGE));
				this.setVersion( (Integer)map.get(AssessmentBillUserMapMeta.VERSION));
				this.setOrgId( (String)map.get(AssessmentBillUserMapMeta.ORG_ID));
				this.setLeaderId( (String)map.get(AssessmentBillUserMapMeta.LEADER_ID));
				this.setAssesseeId( (String)map.get(AssessmentBillUserMapMeta.ASSESSEE_ID));
				this.setResult( (String)map.get(AssessmentBillUserMapMeta.RESULT));
				this.setCreateBy( (String)map.get(AssessmentBillUserMapMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssessmentBillUserMapMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssessmentBillUserMapMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssessmentBillUserMapMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssessmentBillUserMapMeta.DELETE_TIME));
				this.setBillId( (String)map.get(AssessmentBillUserMapMeta.BILL_ID));
				this.setDeleteBy( (String)map.get(AssessmentBillUserMapMeta.DELETE_BY));
				this.setId( (String)map.get(AssessmentBillUserMapMeta.ID));
				this.setStatus( (String)map.get(AssessmentBillUserMapMeta.STATUS));
				// others
				this.setAssesseeUser( (Employee)map.get(AssessmentBillUserMapMeta.ASSESSEE_USER));
				this.setSameUserAvgScoreValue( (String)map.get(AssessmentBillUserMapMeta.SAME_USER_AVG_SCORE_VALUE));
				this.setSameUserNeedCount( (String)map.get(AssessmentBillUserMapMeta.SAME_USER_NEED_COUNT));
				this.setSameUserFinishCount( (String)map.get(AssessmentBillUserMapMeta.SAME_USER_FINISH_COUNT));
				this.setSecondLeaderUser( (Employee)map.get(AssessmentBillUserMapMeta.SECOND_LEADER_USER));
				this.setIfHrConfirm( (String)map.get(AssessmentBillUserMapMeta.IF_HR_CONFIRM));
				this.setSOrgId( (String)map.get(AssessmentBillUserMapMeta.S_ORG_ID));
				this.setLeaderUserRel( (Employee)map.get(AssessmentBillUserMapMeta.LEADER_USER_REL));
				this.setSecondLeaderUserIdRel( (String)map.get(AssessmentBillUserMapMeta.SECOND_LEADER_USER_ID_REL));
				this.setSecondLeaderUserRel( (Employee)map.get(AssessmentBillUserMapMeta.SECOND_LEADER_USER_REL));
				this.setLeaderUser( (Employee)map.get(AssessmentBillUserMapMeta.LEADER_USER));
				this.setLeaderUserIdRel( (String)map.get(AssessmentBillUserMapMeta.LEADER_USER_ID_REL));
				this.setHrUser( (Employee)map.get(AssessmentBillUserMapMeta.HR_USER));
				this.setAssessmentTask( (AssessmentTask)map.get(AssessmentBillUserMapMeta.ASSESSMENT_TASK));
				this.setAssessmentBillTaskList( (AssessmentBillTask)map.get(AssessmentBillUserMapMeta.ASSESSMENT_BILL_TASK_LIST));
				this.setLeaderScoreValue( (String)map.get(AssessmentBillUserMapMeta.LEADER_SCORE_VALUE));
				this.setSelfScoreValue( (String)map.get(AssessmentBillUserMapMeta.SELF_SCORE_VALUE));
				this.setSecondLeaderScoreValue( (String)map.get(AssessmentBillUserMapMeta.SECOND_LEADER_SCORE_VALUE));
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
			this.setHrUserId(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapMeta.HR_USER_ID)));
			this.setSecondLeaderId(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapMeta.SECOND_LEADER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentBillUserMapMeta.UPDATE_TIME)));
			this.setMessage(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapMeta.MESSAGE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssessmentBillUserMapMeta.VERSION)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapMeta.ORG_ID)));
			this.setLeaderId(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapMeta.LEADER_ID)));
			this.setAssesseeId(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapMeta.ASSESSEE_ID)));
			this.setResult(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapMeta.RESULT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssessmentBillUserMapMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssessmentBillUserMapMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssessmentBillUserMapMeta.DELETE_TIME)));
			this.setBillId(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapMeta.BILL_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssessmentBillUserMapMeta.STATUS)));
			return true;
		} else {
			try {
				this.setHrUserId( (String)r.getValue(AssessmentBillUserMapMeta.HR_USER_ID));
				this.setSecondLeaderId( (String)r.getValue(AssessmentBillUserMapMeta.SECOND_LEADER_ID));
				this.setUpdateTime( (Date)r.getValue(AssessmentBillUserMapMeta.UPDATE_TIME));
				this.setMessage( (String)r.getValue(AssessmentBillUserMapMeta.MESSAGE));
				this.setVersion( (Integer)r.getValue(AssessmentBillUserMapMeta.VERSION));
				this.setOrgId( (String)r.getValue(AssessmentBillUserMapMeta.ORG_ID));
				this.setLeaderId( (String)r.getValue(AssessmentBillUserMapMeta.LEADER_ID));
				this.setAssesseeId( (String)r.getValue(AssessmentBillUserMapMeta.ASSESSEE_ID));
				this.setResult( (String)r.getValue(AssessmentBillUserMapMeta.RESULT));
				this.setCreateBy( (String)r.getValue(AssessmentBillUserMapMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssessmentBillUserMapMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssessmentBillUserMapMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssessmentBillUserMapMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssessmentBillUserMapMeta.DELETE_TIME));
				this.setBillId( (String)r.getValue(AssessmentBillUserMapMeta.BILL_ID));
				this.setDeleteBy( (String)r.getValue(AssessmentBillUserMapMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssessmentBillUserMapMeta.ID));
				this.setStatus( (String)r.getValue(AssessmentBillUserMapMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}