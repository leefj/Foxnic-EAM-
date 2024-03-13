package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ASSESSMENT_BILL_TASK;
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
import com.dt.platform.domain.hr.meta.AssessmentBillTaskMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 单据任务
 * <p>单据任务 , 数据表 hr_assessment_bill_task 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-12 13:15:01
 * @sign 40D0C176B40BE2F942BC14CDB7D72026
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_assessment_bill_task")
@ApiModel(description = "单据任务 ; 单据任务 , 数据表 hr_assessment_bill_task 的PO类型")
public class AssessmentBillTask extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ASSESSMENT_BILL_TASK.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "819858900948877312")
	private String id;
	
	/**
	 * 单据：单据
	*/
	@ApiModelProperty(required = false,value="单据" , notes = "单据" , example = "819286495167774720")
	private String billId;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 考核人：考核人
	*/
	@ApiModelProperty(required = false,value="考核人" , notes = "考核人" , example = "590511680593592320")
	private String assessorId;
	
	/**
	 * 记录时间：记录时间
	*/
	@ApiModelProperty(required = false,value="记录时间" , notes = "记录时间" , example = "2024-03-12 09:06:34")
	private Date rcdTime;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-03-12 09:06:34")
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
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "1")
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
	 * sOrgId：sOrgId
	*/
	@ApiModelProperty(required = false,value="sOrgId" , notes = "sOrgId")
	private String sOrgId;
	
	/**
	 * assessor：assessor
	*/
	@ApiModelProperty(required = false,value="assessor" , notes = "assessor")
	private Employee assessor;
	
	/**
	 * assessmentTask：assessmentTask
	*/
	@ApiModelProperty(required = false,value="assessmentTask" , notes = "assessmentTask")
	private AssessmentTask assessmentTask;
	
	/**
	 * assessmentDataTask：assessmentDataTask
	*/
	@ApiModelProperty(required = false,value="assessmentDataTask" , notes = "assessmentDataTask")
	private AssessmentTask assessmentDataTask;
	
	/**
	 * withLeaderList：withLeaderList
	*/
	@ApiModelProperty(required = false,value="withLeaderList" , notes = "withLeaderList")
	private List<Employee> withLeaderList;
	
	/**
	 * withSecondLeaderList：withSecondLeaderList
	*/
	@ApiModelProperty(required = false,value="withSecondLeaderList" , notes = "withSecondLeaderList")
	private List<Employee> withSecondLeaderList;
	
	/**
	 * withSameUserList：withSameUserList
	*/
	@ApiModelProperty(required = false,value="withSameUserList" , notes = "withSameUserList")
	private List<Employee> withSameUserList;
	
	/**
	 * assessmentBill：assessmentBill
	*/
	@ApiModelProperty(required = false,value="assessmentBill" , notes = "assessmentBill")
	private AssessmentBill assessmentBill;
	
	/**
	 * nameStr：nameStr
	*/
	@ApiModelProperty(required = false,value="nameStr" , notes = "nameStr")
	private String nameStr;
	
	/**
	 * stimeStr：stimeStr
	*/
	@ApiModelProperty(required = false,value="stimeStr" , notes = "stimeStr")
	private String stimeStr;
	
	/**
	 * etimeStr：etimeStr
	*/
	@ApiModelProperty(required = false,value="etimeStr" , notes = "etimeStr")
	private String etimeStr;
	
	/**
	 * sRole：sRole
	*/
	@ApiModelProperty(required = false,value="sRole" , notes = "sRole")
	private String sRole;
	
	/**
	 * assessmentBillTaskDtlList：assessmentBillTaskDtlList
	*/
	@ApiModelProperty(required = false,value="assessmentBillTaskDtlList" , notes = "assessmentBillTaskDtlList")
	private List<AssessmentBillTaskDtl> assessmentBillTaskDtlList;
	
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
	public AssessmentBillTask setId(String id) {
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
	public AssessmentBillTask setBillId(String billId) {
		this.billId=billId;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public AssessmentBillTask setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 考核人<br>
	 * 考核人
	 * @return 考核人
	*/
	public String getAssessorId() {
		return assessorId;
	}
	
	/**
	 * 设置 考核人
	 * @param assessorId 考核人
	 * @return 当前对象
	*/
	public AssessmentBillTask setAssessorId(String assessorId) {
		this.assessorId=assessorId;
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
	public AssessmentBillTask setRcdTime(Date rcdTime) {
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
	public AssessmentBillTask setCreateBy(String createBy) {
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
	public AssessmentBillTask setCreateTime(Date createTime) {
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
	public AssessmentBillTask setUpdateBy(String updateBy) {
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
	public AssessmentBillTask setUpdateTime(Date updateTime) {
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
	public AssessmentBillTask setDeleted(Integer deleted) {
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
	public AssessmentBillTask setDeleted(Boolean deletedBool) {
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
	public AssessmentBillTask setDeleteBy(String deleteBy) {
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
	public AssessmentBillTask setDeleteTime(Date deleteTime) {
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
	public AssessmentBillTask setVersion(Integer version) {
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
	public AssessmentBillTask setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public AssessmentBillTask setSOrgId(String sOrgId) {
		this.sOrgId=sOrgId;
		return this;
	}
	
	/**
	 * 获得 assessor<br>
	 * assessor
	 * @return assessor
	*/
	public Employee getAssessor() {
		return assessor;
	}
	
	/**
	 * 设置 assessor
	 * @param assessor assessor
	 * @return 当前对象
	*/
	public AssessmentBillTask setAssessor(Employee assessor) {
		this.assessor=assessor;
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
	public AssessmentBillTask setAssessmentTask(AssessmentTask assessmentTask) {
		this.assessmentTask=assessmentTask;
		return this;
	}
	
	/**
	 * 获得 assessmentDataTask<br>
	 * assessmentDataTask
	 * @return assessmentDataTask
	*/
	public AssessmentTask getAssessmentDataTask() {
		return assessmentDataTask;
	}
	
	/**
	 * 设置 assessmentDataTask
	 * @param assessmentDataTask assessmentDataTask
	 * @return 当前对象
	*/
	public AssessmentBillTask setAssessmentDataTask(AssessmentTask assessmentDataTask) {
		this.assessmentDataTask=assessmentDataTask;
		return this;
	}
	
	/**
	 * 获得 withLeaderList<br>
	 * withLeaderList
	 * @return withLeaderList
	*/
	public List<Employee> getWithLeaderList() {
		return withLeaderList;
	}
	
	/**
	 * 设置 withLeaderList
	 * @param withLeaderList withLeaderList
	 * @return 当前对象
	*/
	public AssessmentBillTask setWithLeaderList(List<Employee> withLeaderList) {
		this.withLeaderList=withLeaderList;
		return this;
	}
	
	/**
	 * 添加 withLeaderList
	 * @param withLeader withLeaderList
	 * @return 当前对象
	*/
	public AssessmentBillTask addWithLeader(Employee... withLeader) {
		if(this.withLeaderList==null) withLeaderList=new ArrayList<>();
		this.withLeaderList.addAll(Arrays.asList(withLeader));
		return this;
	}
	
	/**
	 * 获得 withSecondLeaderList<br>
	 * withSecondLeaderList
	 * @return withSecondLeaderList
	*/
	public List<Employee> getWithSecondLeaderList() {
		return withSecondLeaderList;
	}
	
	/**
	 * 设置 withSecondLeaderList
	 * @param withSecondLeaderList withSecondLeaderList
	 * @return 当前对象
	*/
	public AssessmentBillTask setWithSecondLeaderList(List<Employee> withSecondLeaderList) {
		this.withSecondLeaderList=withSecondLeaderList;
		return this;
	}
	
	/**
	 * 添加 withSecondLeaderList
	 * @param withSecondLeader withSecondLeaderList
	 * @return 当前对象
	*/
	public AssessmentBillTask addWithSecondLeader(Employee... withSecondLeader) {
		if(this.withSecondLeaderList==null) withSecondLeaderList=new ArrayList<>();
		this.withSecondLeaderList.addAll(Arrays.asList(withSecondLeader));
		return this;
	}
	
	/**
	 * 获得 withSameUserList<br>
	 * withSameUserList
	 * @return withSameUserList
	*/
	public List<Employee> getWithSameUserList() {
		return withSameUserList;
	}
	
	/**
	 * 设置 withSameUserList
	 * @param withSameUserList withSameUserList
	 * @return 当前对象
	*/
	public AssessmentBillTask setWithSameUserList(List<Employee> withSameUserList) {
		this.withSameUserList=withSameUserList;
		return this;
	}
	
	/**
	 * 添加 withSameUserList
	 * @param withSameUser withSameUserList
	 * @return 当前对象
	*/
	public AssessmentBillTask addWithSameUser(Employee... withSameUser) {
		if(this.withSameUserList==null) withSameUserList=new ArrayList<>();
		this.withSameUserList.addAll(Arrays.asList(withSameUser));
		return this;
	}
	
	/**
	 * 获得 assessmentBill<br>
	 * assessmentBill
	 * @return assessmentBill
	*/
	public AssessmentBill getAssessmentBill() {
		return assessmentBill;
	}
	
	/**
	 * 设置 assessmentBill
	 * @param assessmentBill assessmentBill
	 * @return 当前对象
	*/
	public AssessmentBillTask setAssessmentBill(AssessmentBill assessmentBill) {
		this.assessmentBill=assessmentBill;
		return this;
	}
	
	/**
	 * 获得 nameStr<br>
	 * nameStr
	 * @return nameStr
	*/
	public String getNameStr() {
		return nameStr;
	}
	
	/**
	 * 设置 nameStr
	 * @param nameStr nameStr
	 * @return 当前对象
	*/
	public AssessmentBillTask setNameStr(String nameStr) {
		this.nameStr=nameStr;
		return this;
	}
	
	/**
	 * 获得 stimeStr<br>
	 * stimeStr
	 * @return stimeStr
	*/
	public String getStimeStr() {
		return stimeStr;
	}
	
	/**
	 * 设置 stimeStr
	 * @param stimeStr stimeStr
	 * @return 当前对象
	*/
	public AssessmentBillTask setStimeStr(String stimeStr) {
		this.stimeStr=stimeStr;
		return this;
	}
	
	/**
	 * 获得 etimeStr<br>
	 * etimeStr
	 * @return etimeStr
	*/
	public String getEtimeStr() {
		return etimeStr;
	}
	
	/**
	 * 设置 etimeStr
	 * @param etimeStr etimeStr
	 * @return 当前对象
	*/
	public AssessmentBillTask setEtimeStr(String etimeStr) {
		this.etimeStr=etimeStr;
		return this;
	}
	
	/**
	 * 获得 sRole<br>
	 * sRole
	 * @return sRole
	*/
	public String getSRole() {
		return sRole;
	}
	
	/**
	 * 设置 sRole
	 * @param sRole sRole
	 * @return 当前对象
	*/
	public AssessmentBillTask setSRole(String sRole) {
		this.sRole=sRole;
		return this;
	}
	
	/**
	 * 获得 assessmentBillTaskDtlList<br>
	 * assessmentBillTaskDtlList
	 * @return assessmentBillTaskDtlList
	*/
	public List<AssessmentBillTaskDtl> getAssessmentBillTaskDtlList() {
		return assessmentBillTaskDtlList;
	}
	
	/**
	 * 设置 assessmentBillTaskDtlList
	 * @param assessmentBillTaskDtlList assessmentBillTaskDtlList
	 * @return 当前对象
	*/
	public AssessmentBillTask setAssessmentBillTaskDtlList(List<AssessmentBillTaskDtl> assessmentBillTaskDtlList) {
		this.assessmentBillTaskDtlList=assessmentBillTaskDtlList;
		return this;
	}
	
	/**
	 * 添加 assessmentBillTaskDtlList
	 * @param assessmentBillTaskDtl assessmentBillTaskDtlList
	 * @return 当前对象
	*/
	public AssessmentBillTask addAssessmentBillTaskDtl(AssessmentBillTaskDtl... assessmentBillTaskDtl) {
		if(this.assessmentBillTaskDtlList==null) assessmentBillTaskDtlList=new ArrayList<>();
		this.assessmentBillTaskDtlList.addAll(Arrays.asList(assessmentBillTaskDtl));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssessmentBillTask , 转换好的 AssessmentBillTask 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssessmentBillTask , 转换好的 PoJo 对象
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
	public AssessmentBillTask clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssessmentBillTask duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AssessmentBillTaskMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AssessmentBillTaskMeta.$$proxy$$();
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssessorId(this.getAssessorId());
		inst.setBillId(this.getBillId());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setRcdTime(this.getRcdTime());
		if(all) {
			inst.setAssessmentBillTaskDtlList(this.getAssessmentBillTaskDtlList());
			inst.setNameStr(this.getNameStr());
			inst.setAssessor(this.getAssessor());
			inst.setWithSecondLeaderList(this.getWithSecondLeaderList());
			inst.setSOrgId(this.getSOrgId());
			inst.setAssessmentDataTask(this.getAssessmentDataTask());
			inst.setStimeStr(this.getStimeStr());
			inst.setSRole(this.getSRole());
			inst.setWithSameUserList(this.getWithSameUserList());
			inst.setAssessmentTask(this.getAssessmentTask());
			inst.setEtimeStr(this.getEtimeStr());
			inst.setAssessmentBill(this.getAssessmentBill());
			inst.setWithLeaderList(this.getWithLeaderList());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssessmentBillTask clone(boolean deep) {
		return EntityContext.clone(AssessmentBillTask.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssessmentBillTask
	 * @param assessmentBillTaskMap 包含实体信息的 Map 对象
	 * @return AssessmentBillTask , 转换好的的 AssessmentBillTask 对象
	*/
	@Transient
	public static AssessmentBillTask createFrom(Map<String,Object> assessmentBillTaskMap) {
		if(assessmentBillTaskMap==null) return null;
		AssessmentBillTask po = create();
		EntityContext.copyProperties(po,assessmentBillTaskMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssessmentBillTask
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssessmentBillTask , 转换好的的 AssessmentBillTask 对象
	*/
	@Transient
	public static AssessmentBillTask createFrom(Object pojo) {
		if(pojo==null) return null;
		AssessmentBillTask po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssessmentBillTask，等同于 new
	 * @return AssessmentBillTask 对象
	*/
	@Transient
	public static AssessmentBillTask create() {
		return new com.dt.platform.domain.hr.meta.AssessmentBillTaskMeta.$$proxy$$();
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
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentBillTaskMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssessmentBillTaskMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssessmentBillTaskMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssessmentBillTaskMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssessmentBillTaskMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssessmentBillTaskMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssessmentBillTaskMeta.DELETE_TIME)));
			this.setAssessorId(DataParser.parse(String.class, map.get(AssessmentBillTaskMeta.ASSESSOR_ID)));
			this.setBillId(DataParser.parse(String.class, map.get(AssessmentBillTaskMeta.BILL_ID)));
			this.setName(DataParser.parse(String.class, map.get(AssessmentBillTaskMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssessmentBillTaskMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssessmentBillTaskMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssessmentBillTaskMeta.ID)));
			this.setRcdTime(DataParser.parse(Date.class, map.get(AssessmentBillTaskMeta.RCD_TIME)));
			// others
			this.setNameStr(DataParser.parse(String.class, map.get(AssessmentBillTaskMeta.NAME_STR)));
			this.setAssessor(DataParser.parse(Employee.class, map.get(AssessmentBillTaskMeta.ASSESSOR)));
			this.setSOrgId(DataParser.parse(String.class, map.get(AssessmentBillTaskMeta.S_ORG_ID)));
			this.setAssessmentDataTask(DataParser.parse(AssessmentTask.class, map.get(AssessmentBillTaskMeta.ASSESSMENT_DATA_TASK)));
			this.setStimeStr(DataParser.parse(String.class, map.get(AssessmentBillTaskMeta.STIME_STR)));
			this.setSRole(DataParser.parse(String.class, map.get(AssessmentBillTaskMeta.S_ROLE)));
			this.setAssessmentTask(DataParser.parse(AssessmentTask.class, map.get(AssessmentBillTaskMeta.ASSESSMENT_TASK)));
			this.setEtimeStr(DataParser.parse(String.class, map.get(AssessmentBillTaskMeta.ETIME_STR)));
			this.setAssessmentBill(DataParser.parse(AssessmentBill.class, map.get(AssessmentBillTaskMeta.ASSESSMENT_BILL)));
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)map.get(AssessmentBillTaskMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssessmentBillTaskMeta.VERSION));
				this.setCreateBy( (String)map.get(AssessmentBillTaskMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssessmentBillTaskMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssessmentBillTaskMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssessmentBillTaskMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssessmentBillTaskMeta.DELETE_TIME));
				this.setAssessorId( (String)map.get(AssessmentBillTaskMeta.ASSESSOR_ID));
				this.setBillId( (String)map.get(AssessmentBillTaskMeta.BILL_ID));
				this.setName( (String)map.get(AssessmentBillTaskMeta.NAME));
				this.setTenantId( (String)map.get(AssessmentBillTaskMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssessmentBillTaskMeta.DELETE_BY));
				this.setId( (String)map.get(AssessmentBillTaskMeta.ID));
				this.setRcdTime( (Date)map.get(AssessmentBillTaskMeta.RCD_TIME));
				// others
				this.setNameStr( (String)map.get(AssessmentBillTaskMeta.NAME_STR));
				this.setAssessor( (Employee)map.get(AssessmentBillTaskMeta.ASSESSOR));
				this.setSOrgId( (String)map.get(AssessmentBillTaskMeta.S_ORG_ID));
				this.setAssessmentDataTask( (AssessmentTask)map.get(AssessmentBillTaskMeta.ASSESSMENT_DATA_TASK));
				this.setStimeStr( (String)map.get(AssessmentBillTaskMeta.STIME_STR));
				this.setSRole( (String)map.get(AssessmentBillTaskMeta.S_ROLE));
				this.setAssessmentTask( (AssessmentTask)map.get(AssessmentBillTaskMeta.ASSESSMENT_TASK));
				this.setEtimeStr( (String)map.get(AssessmentBillTaskMeta.ETIME_STR));
				this.setAssessmentBill( (AssessmentBill)map.get(AssessmentBillTaskMeta.ASSESSMENT_BILL));
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
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentBillTaskMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssessmentBillTaskMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssessmentBillTaskMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssessmentBillTaskMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssessmentBillTaskMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssessmentBillTaskMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssessmentBillTaskMeta.DELETE_TIME)));
			this.setAssessorId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskMeta.ASSESSOR_ID)));
			this.setBillId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskMeta.BILL_ID)));
			this.setName(DataParser.parse(String.class, r.getValue(AssessmentBillTaskMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssessmentBillTaskMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskMeta.ID)));
			this.setRcdTime(DataParser.parse(Date.class, r.getValue(AssessmentBillTaskMeta.RCD_TIME)));
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)r.getValue(AssessmentBillTaskMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssessmentBillTaskMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AssessmentBillTaskMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssessmentBillTaskMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssessmentBillTaskMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssessmentBillTaskMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssessmentBillTaskMeta.DELETE_TIME));
				this.setAssessorId( (String)r.getValue(AssessmentBillTaskMeta.ASSESSOR_ID));
				this.setBillId( (String)r.getValue(AssessmentBillTaskMeta.BILL_ID));
				this.setName( (String)r.getValue(AssessmentBillTaskMeta.NAME));
				this.setTenantId( (String)r.getValue(AssessmentBillTaskMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssessmentBillTaskMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssessmentBillTaskMeta.ID));
				this.setRcdTime( (Date)r.getValue(AssessmentBillTaskMeta.RCD_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}