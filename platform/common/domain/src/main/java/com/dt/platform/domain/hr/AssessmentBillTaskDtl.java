package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ASSESSMENT_BILL_TASK_DTL;
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
import com.dt.platform.domain.hr.meta.AssessmentBillTaskDtlMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 任务明细单
 * <p>任务明细单 , 数据表 hr_assessment_bill_task_dtl 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-14 21:33:43
 * @sign 485DADC1467D320F7DFC22833169E46F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_assessment_bill_task_dtl")
@ApiModel(description = "任务明细单 ; 任务明细单 , 数据表 hr_assessment_bill_task_dtl 的PO类型")
public class AssessmentBillTaskDtl extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ASSESSMENT_BILL_TASK_DTL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "819953141876260864")
	private String id;
	
	/**
	 * 任务：任务
	*/
	@ApiModelProperty(required = false,value="任务" , notes = "任务")
	private String billId;
	
	/**
	 * 单据：单据
	*/
	@ApiModelProperty(required = false,value="单据" , notes = "单据" , example = "819953138105581568")
	private String billTaskId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "wait")
	private String status;
	
	/**
	 * 考核方式：考核方式
	*/
	@ApiModelProperty(required = false,value="考核方式" , notes = "考核方式" , example = "self")
	private String relationship;
	
	/**
	 * 操作时间：操作时间
	*/
	@ApiModelProperty(required = false,value="操作时间" , notes = "操作时间" , example = "2024-03-12 03:21:03")
	private Date rcdTime;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-03-12 03:21:03")
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
	 * assessor：assessor
	*/
	@ApiModelProperty(required = false,value="assessor" , notes = "assessor")
	private Employee assessor;
	
	/**
	 * assessmentBill：assessmentBill
	*/
	@ApiModelProperty(required = false,value="assessmentBill" , notes = "assessmentBill")
	private AssessmentBill assessmentBill;
	
	/**
	 * AssessmentBillTask：AssessmentBillTask
	*/
	@ApiModelProperty(required = false,value="AssessmentBillTask" , notes = "AssessmentBillTask")
	private AssessmentBillTask AssessmentBillTask;
	
	/**
	 * assesseeStr：assesseeStr
	*/
	@ApiModelProperty(required = false,value="assesseeStr" , notes = "assesseeStr")
	private String assesseeStr;
	
	/**
	 * assessorStr：assessorStr
	*/
	@ApiModelProperty(required = false,value="assessorStr" , notes = "assessorStr")
	private String assessorStr;
	
	/**
	 * withSelfUser：withSelfUser
	*/
	@ApiModelProperty(required = false,value="withSelfUser" , notes = "withSelfUser")
	private Employee withSelfUser;
	
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
	public AssessmentBillTaskDtl setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 任务<br>
	 * 任务
	 * @return 任务
	*/
	public String getBillId() {
		return billId;
	}
	
	/**
	 * 设置 任务
	 * @param billId 任务
	 * @return 当前对象
	*/
	public AssessmentBillTaskDtl setBillId(String billId) {
		this.billId=billId;
		return this;
	}
	
	/**
	 * 获得 单据<br>
	 * 单据
	 * @return 单据
	*/
	public String getBillTaskId() {
		return billTaskId;
	}
	
	/**
	 * 设置 单据
	 * @param billTaskId 单据
	 * @return 当前对象
	*/
	public AssessmentBillTaskDtl setBillTaskId(String billTaskId) {
		this.billTaskId=billTaskId;
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
	public AssessmentBillTaskDtl setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 考核方式<br>
	 * 考核方式
	 * @return 考核方式
	*/
	public String getRelationship() {
		return relationship;
	}
	
	/**
	 * 设置 考核方式
	 * @param relationship 考核方式
	 * @return 当前对象
	*/
	public AssessmentBillTaskDtl setRelationship(String relationship) {
		this.relationship=relationship;
		return this;
	}
	
	/**
	 * 获得 操作时间<br>
	 * 操作时间
	 * @return 操作时间
	*/
	public Date getRcdTime() {
		return rcdTime;
	}
	
	/**
	 * 设置 操作时间
	 * @param rcdTime 操作时间
	 * @return 当前对象
	*/
	public AssessmentBillTaskDtl setRcdTime(Date rcdTime) {
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
	public AssessmentBillTaskDtl setCreateBy(String createBy) {
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
	public AssessmentBillTaskDtl setCreateTime(Date createTime) {
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
	public AssessmentBillTaskDtl setUpdateBy(String updateBy) {
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
	public AssessmentBillTaskDtl setUpdateTime(Date updateTime) {
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
	public AssessmentBillTaskDtl setDeleted(Integer deleted) {
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
	public AssessmentBillTaskDtl setDeleted(Boolean deletedBool) {
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
	public AssessmentBillTaskDtl setDeleteBy(String deleteBy) {
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
	public AssessmentBillTaskDtl setDeleteTime(Date deleteTime) {
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
	public AssessmentBillTaskDtl setVersion(Integer version) {
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
	public AssessmentBillTaskDtl setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public AssessmentBillTaskDtl setAssessor(Employee assessor) {
		this.assessor=assessor;
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
	public AssessmentBillTaskDtl setAssessmentBill(AssessmentBill assessmentBill) {
		this.assessmentBill=assessmentBill;
		return this;
	}
	
	/**
	 * 获得 AssessmentBillTask<br>
	 * AssessmentBillTask
	 * @return AssessmentBillTask
	*/
	public AssessmentBillTask getAssessmentBillTask() {
		return AssessmentBillTask;
	}
	
	/**
	 * 设置 AssessmentBillTask
	 * @param AssessmentBillTask AssessmentBillTask
	 * @return 当前对象
	*/
	public AssessmentBillTaskDtl setAssessmentBillTask(AssessmentBillTask AssessmentBillTask) {
		this.AssessmentBillTask=AssessmentBillTask;
		return this;
	}
	
	/**
	 * 获得 assesseeStr<br>
	 * assesseeStr
	 * @return assesseeStr
	*/
	public String getAssesseeStr() {
		return assesseeStr;
	}
	
	/**
	 * 设置 assesseeStr
	 * @param assesseeStr assesseeStr
	 * @return 当前对象
	*/
	public AssessmentBillTaskDtl setAssesseeStr(String assesseeStr) {
		this.assesseeStr=assesseeStr;
		return this;
	}
	
	/**
	 * 获得 assessorStr<br>
	 * assessorStr
	 * @return assessorStr
	*/
	public String getAssessorStr() {
		return assessorStr;
	}
	
	/**
	 * 设置 assessorStr
	 * @param assessorStr assessorStr
	 * @return 当前对象
	*/
	public AssessmentBillTaskDtl setAssessorStr(String assessorStr) {
		this.assessorStr=assessorStr;
		return this;
	}
	
	/**
	 * 获得 withSelfUser<br>
	 * withSelfUser
	 * @return withSelfUser
	*/
	public Employee getWithSelfUser() {
		return withSelfUser;
	}
	
	/**
	 * 设置 withSelfUser
	 * @param withSelfUser withSelfUser
	 * @return 当前对象
	*/
	public AssessmentBillTaskDtl setWithSelfUser(Employee withSelfUser) {
		this.withSelfUser=withSelfUser;
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
	public AssessmentBillTaskDtl setWithLeaderList(List<Employee> withLeaderList) {
		this.withLeaderList=withLeaderList;
		return this;
	}
	
	/**
	 * 添加 withLeaderList
	 * @param withLeader withLeaderList
	 * @return 当前对象
	*/
	public AssessmentBillTaskDtl addWithLeader(Employee... withLeader) {
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
	public AssessmentBillTaskDtl setWithSecondLeaderList(List<Employee> withSecondLeaderList) {
		this.withSecondLeaderList=withSecondLeaderList;
		return this;
	}
	
	/**
	 * 添加 withSecondLeaderList
	 * @param withSecondLeader withSecondLeaderList
	 * @return 当前对象
	*/
	public AssessmentBillTaskDtl addWithSecondLeader(Employee... withSecondLeader) {
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
	public AssessmentBillTaskDtl setWithSameUserList(List<Employee> withSameUserList) {
		this.withSameUserList=withSameUserList;
		return this;
	}
	
	/**
	 * 添加 withSameUserList
	 * @param withSameUser withSameUserList
	 * @return 当前对象
	*/
	public AssessmentBillTaskDtl addWithSameUser(Employee... withSameUser) {
		if(this.withSameUserList==null) withSameUserList=new ArrayList<>();
		this.withSameUserList.addAll(Arrays.asList(withSameUser));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssessmentBillTaskDtl , 转换好的 AssessmentBillTaskDtl 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssessmentBillTaskDtl , 转换好的 PoJo 对象
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
	public AssessmentBillTaskDtl clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssessmentBillTaskDtl duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AssessmentBillTaskDtlMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AssessmentBillTaskDtlMeta.$$proxy$$();
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setBillTaskId(this.getBillTaskId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setBillId(this.getBillId());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setRelationship(this.getRelationship());
		inst.setStatus(this.getStatus());
		inst.setRcdTime(this.getRcdTime());
		if(all) {
			inst.setWithSelfUser(this.getWithSelfUser());
			inst.setAssessmentBillTask(this.getAssessmentBillTask());
			inst.setWithSameUserList(this.getWithSameUserList());
			inst.setAssessor(this.getAssessor());
			inst.setWithSecondLeaderList(this.getWithSecondLeaderList());
			inst.setAssessmentBill(this.getAssessmentBill());
			inst.setWithLeaderList(this.getWithLeaderList());
			inst.setAssesseeStr(this.getAssesseeStr());
			inst.setAssessorStr(this.getAssessorStr());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssessmentBillTaskDtl clone(boolean deep) {
		return EntityContext.clone(AssessmentBillTaskDtl.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssessmentBillTaskDtl
	 * @param assessmentBillTaskDtlMap 包含实体信息的 Map 对象
	 * @return AssessmentBillTaskDtl , 转换好的的 AssessmentBillTaskDtl 对象
	*/
	@Transient
	public static AssessmentBillTaskDtl createFrom(Map<String,Object> assessmentBillTaskDtlMap) {
		if(assessmentBillTaskDtlMap==null) return null;
		AssessmentBillTaskDtl po = create();
		EntityContext.copyProperties(po,assessmentBillTaskDtlMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssessmentBillTaskDtl
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssessmentBillTaskDtl , 转换好的的 AssessmentBillTaskDtl 对象
	*/
	@Transient
	public static AssessmentBillTaskDtl createFrom(Object pojo) {
		if(pojo==null) return null;
		AssessmentBillTaskDtl po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssessmentBillTaskDtl，等同于 new
	 * @return AssessmentBillTaskDtl 对象
	*/
	@Transient
	public static AssessmentBillTaskDtl create() {
		return new com.dt.platform.domain.hr.meta.AssessmentBillTaskDtlMeta.$$proxy$$();
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
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentBillTaskDtlMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssessmentBillTaskDtlMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssessmentBillTaskDtlMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssessmentBillTaskDtlMeta.DELETED)));
			this.setBillTaskId(DataParser.parse(String.class, map.get(AssessmentBillTaskDtlMeta.BILL_TASK_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssessmentBillTaskDtlMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssessmentBillTaskDtlMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssessmentBillTaskDtlMeta.DELETE_TIME)));
			this.setBillId(DataParser.parse(String.class, map.get(AssessmentBillTaskDtlMeta.BILL_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssessmentBillTaskDtlMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssessmentBillTaskDtlMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssessmentBillTaskDtlMeta.ID)));
			this.setRelationship(DataParser.parse(String.class, map.get(AssessmentBillTaskDtlMeta.RELATIONSHIP)));
			this.setStatus(DataParser.parse(String.class, map.get(AssessmentBillTaskDtlMeta.STATUS)));
			this.setRcdTime(DataParser.parse(Date.class, map.get(AssessmentBillTaskDtlMeta.RCD_TIME)));
			// others
			this.setWithSelfUser(DataParser.parse(Employee.class, map.get(AssessmentBillTaskDtlMeta.WITH_SELF_USER)));
			this.setAssessmentBillTask(DataParser.parse(AssessmentBillTask.class, map.get(AssessmentBillTaskDtlMeta.ASSESSMENT_BILL_TASK)));
			this.setAssessor(DataParser.parse(Employee.class, map.get(AssessmentBillTaskDtlMeta.ASSESSOR)));
			this.setAssessmentBill(DataParser.parse(AssessmentBill.class, map.get(AssessmentBillTaskDtlMeta.ASSESSMENT_BILL)));
			this.setAssesseeStr(DataParser.parse(String.class, map.get(AssessmentBillTaskDtlMeta.ASSESSEE_STR)));
			this.setAssessorStr(DataParser.parse(String.class, map.get(AssessmentBillTaskDtlMeta.ASSESSOR_STR)));
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)map.get(AssessmentBillTaskDtlMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssessmentBillTaskDtlMeta.VERSION));
				this.setCreateBy( (String)map.get(AssessmentBillTaskDtlMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssessmentBillTaskDtlMeta.DELETED));
				this.setBillTaskId( (String)map.get(AssessmentBillTaskDtlMeta.BILL_TASK_ID));
				this.setCreateTime( (Date)map.get(AssessmentBillTaskDtlMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssessmentBillTaskDtlMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssessmentBillTaskDtlMeta.DELETE_TIME));
				this.setBillId( (String)map.get(AssessmentBillTaskDtlMeta.BILL_ID));
				this.setTenantId( (String)map.get(AssessmentBillTaskDtlMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssessmentBillTaskDtlMeta.DELETE_BY));
				this.setId( (String)map.get(AssessmentBillTaskDtlMeta.ID));
				this.setRelationship( (String)map.get(AssessmentBillTaskDtlMeta.RELATIONSHIP));
				this.setStatus( (String)map.get(AssessmentBillTaskDtlMeta.STATUS));
				this.setRcdTime( (Date)map.get(AssessmentBillTaskDtlMeta.RCD_TIME));
				// others
				this.setWithSelfUser( (Employee)map.get(AssessmentBillTaskDtlMeta.WITH_SELF_USER));
				this.setAssessmentBillTask( (AssessmentBillTask)map.get(AssessmentBillTaskDtlMeta.ASSESSMENT_BILL_TASK));
				this.setAssessor( (Employee)map.get(AssessmentBillTaskDtlMeta.ASSESSOR));
				this.setAssessmentBill( (AssessmentBill)map.get(AssessmentBillTaskDtlMeta.ASSESSMENT_BILL));
				this.setAssesseeStr( (String)map.get(AssessmentBillTaskDtlMeta.ASSESSEE_STR));
				this.setAssessorStr( (String)map.get(AssessmentBillTaskDtlMeta.ASSESSOR_STR));
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
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentBillTaskDtlMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssessmentBillTaskDtlMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssessmentBillTaskDtlMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssessmentBillTaskDtlMeta.DELETED)));
			this.setBillTaskId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskDtlMeta.BILL_TASK_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssessmentBillTaskDtlMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssessmentBillTaskDtlMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssessmentBillTaskDtlMeta.DELETE_TIME)));
			this.setBillId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskDtlMeta.BILL_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskDtlMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssessmentBillTaskDtlMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssessmentBillTaskDtlMeta.ID)));
			this.setRelationship(DataParser.parse(String.class, r.getValue(AssessmentBillTaskDtlMeta.RELATIONSHIP)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssessmentBillTaskDtlMeta.STATUS)));
			this.setRcdTime(DataParser.parse(Date.class, r.getValue(AssessmentBillTaskDtlMeta.RCD_TIME)));
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)r.getValue(AssessmentBillTaskDtlMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssessmentBillTaskDtlMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AssessmentBillTaskDtlMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssessmentBillTaskDtlMeta.DELETED));
				this.setBillTaskId( (String)r.getValue(AssessmentBillTaskDtlMeta.BILL_TASK_ID));
				this.setCreateTime( (Date)r.getValue(AssessmentBillTaskDtlMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssessmentBillTaskDtlMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssessmentBillTaskDtlMeta.DELETE_TIME));
				this.setBillId( (String)r.getValue(AssessmentBillTaskDtlMeta.BILL_ID));
				this.setTenantId( (String)r.getValue(AssessmentBillTaskDtlMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssessmentBillTaskDtlMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssessmentBillTaskDtlMeta.ID));
				this.setRelationship( (String)r.getValue(AssessmentBillTaskDtlMeta.RELATIONSHIP));
				this.setStatus( (String)r.getValue(AssessmentBillTaskDtlMeta.STATUS));
				this.setRcdTime( (Date)r.getValue(AssessmentBillTaskDtlMeta.RCD_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}