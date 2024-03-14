package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ASSESSMENT_BILL;
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
import com.dt.platform.domain.hr.meta.AssessmentBillMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考核单据
 * <p>考核单据 , 数据表 hr_assessment_bill 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-03-14 07:40:16
 * @sign C171DFB2B86B882DBDC4D060513F38AA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_assessment_bill")
@ApiModel(description = "考核单据 ; 考核单据 , 数据表 hr_assessment_bill 的PO类型")
public class AssessmentBill extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ASSESSMENT_BILL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "820392766063247360")
	private String id;
	
	/**
	 * 考核：考核
	*/
	@ApiModelProperty(required = false,value="考核" , notes = "考核" , example = "820392317524377600")
	private String taskId;
	
	/**
	 * 考核任务：考核任务
	*/
	@ApiModelProperty(required = false,value="考核任务" , notes = "考核任务" , example = "820393586116788224")
	private String taskDataId;
	
	/**
	 * 考核名称：考核名称
	*/
	@ApiModelProperty(required = false,value="考核名称" , notes = "考核名称" , example = "abcde")
	private String taskName;
	
	/**
	 * 状态：待下发，考评中，考评结束，取消
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "待下发，考评中，考评结束，取消" , example = "wait")
	private String status;
	
	/**
	 * 是否可见：是否可见
	*/
	@ApiModelProperty(required = false,value="是否可见" , notes = "是否可见" , example = "no")
	private String isShow;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间" , example = "2024-03-13 08:27:59")
	private Date stime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间" , example = "2024-03-13 08:27:59")
	private Date etime;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-03-13 08:27:59")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-03-13 08:31:05")
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
	 * assessmentBillTaskList：assessmentBillTaskList
	*/
	@ApiModelProperty(required = false,value="assessmentBillTaskList" , notes = "assessmentBillTaskList")
	private List<AssessmentBillTask> assessmentBillTaskList;
	
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
	public AssessmentBill setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 考核<br>
	 * 考核
	 * @return 考核
	*/
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 设置 考核
	 * @param taskId 考核
	 * @return 当前对象
	*/
	public AssessmentBill setTaskId(String taskId) {
		this.taskId=taskId;
		return this;
	}
	
	/**
	 * 获得 考核任务<br>
	 * 考核任务
	 * @return 考核任务
	*/
	public String getTaskDataId() {
		return taskDataId;
	}
	
	/**
	 * 设置 考核任务
	 * @param taskDataId 考核任务
	 * @return 当前对象
	*/
	public AssessmentBill setTaskDataId(String taskDataId) {
		this.taskDataId=taskDataId;
		return this;
	}
	
	/**
	 * 获得 考核名称<br>
	 * 考核名称
	 * @return 考核名称
	*/
	public String getTaskName() {
		return taskName;
	}
	
	/**
	 * 设置 考核名称
	 * @param taskName 考核名称
	 * @return 当前对象
	*/
	public AssessmentBill setTaskName(String taskName) {
		this.taskName=taskName;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 待下发，考评中，考评结束，取消
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
	public AssessmentBill setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 是否可见<br>
	 * 是否可见
	 * @return 是否可见
	*/
	public String getIsShow() {
		return isShow;
	}
	
	/**
	 * 设置 是否可见
	 * @param isShow 是否可见
	 * @return 当前对象
	*/
	public AssessmentBill setIsShow(String isShow) {
		this.isShow=isShow;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getStime() {
		return stime;
	}
	
	/**
	 * 设置 开始时间
	 * @param stime 开始时间
	 * @return 当前对象
	*/
	public AssessmentBill setStime(Date stime) {
		this.stime=stime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getEtime() {
		return etime;
	}
	
	/**
	 * 设置 结束时间
	 * @param etime 结束时间
	 * @return 当前对象
	*/
	public AssessmentBill setEtime(Date etime) {
		this.etime=etime;
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
	public AssessmentBill setNotes(String notes) {
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
	public AssessmentBill setCreateBy(String createBy) {
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
	public AssessmentBill setCreateTime(Date createTime) {
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
	public AssessmentBill setUpdateBy(String updateBy) {
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
	public AssessmentBill setUpdateTime(Date updateTime) {
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
	public AssessmentBill setDeleted(Integer deleted) {
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
	public AssessmentBill setDeleted(Boolean deletedBool) {
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
	public AssessmentBill setDeleteBy(String deleteBy) {
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
	public AssessmentBill setDeleteTime(Date deleteTime) {
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
	public AssessmentBill setVersion(Integer version) {
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
	public AssessmentBill setAssessmentTask(AssessmentTask assessmentTask) {
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
	public AssessmentBill setAssessmentDataTask(AssessmentTask assessmentDataTask) {
		this.assessmentDataTask=assessmentDataTask;
		return this;
	}
	
	/**
	 * 获得 assessmentBillTaskList<br>
	 * assessmentBillTaskList
	 * @return assessmentBillTaskList
	*/
	public List<AssessmentBillTask> getAssessmentBillTaskList() {
		return assessmentBillTaskList;
	}
	
	/**
	 * 设置 assessmentBillTaskList
	 * @param assessmentBillTaskList assessmentBillTaskList
	 * @return 当前对象
	*/
	public AssessmentBill setAssessmentBillTaskList(List<AssessmentBillTask> assessmentBillTaskList) {
		this.assessmentBillTaskList=assessmentBillTaskList;
		return this;
	}
	
	/**
	 * 添加 assessmentBillTaskList
	 * @param assessmentBillTask assessmentBillTaskList
	 * @return 当前对象
	*/
	public AssessmentBill addAssessmentBillTask(AssessmentBillTask... assessmentBillTask) {
		if(this.assessmentBillTaskList==null) assessmentBillTaskList=new ArrayList<>();
		this.assessmentBillTaskList.addAll(Arrays.asList(assessmentBillTask));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssessmentBill , 转换好的 AssessmentBill 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssessmentBill , 转换好的 PoJo 对象
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
	public AssessmentBill clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssessmentBill duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AssessmentBillMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AssessmentBillMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setTaskDataId(this.getTaskDataId());
		inst.setStime(this.getStime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setIsShow(this.getIsShow());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setEtime(this.getEtime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setTaskName(this.getTaskName());
		inst.setId(this.getId());
		inst.setTaskId(this.getTaskId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setAssessmentDataTask(this.getAssessmentDataTask());
			inst.setAssessmentTask(this.getAssessmentTask());
			inst.setAssessmentBillTaskList(this.getAssessmentBillTaskList());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssessmentBill clone(boolean deep) {
		return EntityContext.clone(AssessmentBill.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssessmentBill
	 * @param assessmentBillMap 包含实体信息的 Map 对象
	 * @return AssessmentBill , 转换好的的 AssessmentBill 对象
	*/
	@Transient
	public static AssessmentBill createFrom(Map<String,Object> assessmentBillMap) {
		if(assessmentBillMap==null) return null;
		AssessmentBill po = create();
		EntityContext.copyProperties(po,assessmentBillMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssessmentBill
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssessmentBill , 转换好的的 AssessmentBill 对象
	*/
	@Transient
	public static AssessmentBill createFrom(Object pojo) {
		if(pojo==null) return null;
		AssessmentBill po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssessmentBill，等同于 new
	 * @return AssessmentBill 对象
	*/
	@Transient
	public static AssessmentBill create() {
		return new com.dt.platform.domain.hr.meta.AssessmentBillMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AssessmentBillMeta.NOTES)));
			this.setTaskDataId(DataParser.parse(String.class, map.get(AssessmentBillMeta.TASK_DATA_ID)));
			this.setStime(DataParser.parse(Date.class, map.get(AssessmentBillMeta.STIME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssessmentBillMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssessmentBillMeta.VERSION)));
			this.setIsShow(DataParser.parse(String.class, map.get(AssessmentBillMeta.IS_SHOW)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssessmentBillMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssessmentBillMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssessmentBillMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssessmentBillMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssessmentBillMeta.DELETE_TIME)));
			this.setEtime(DataParser.parse(Date.class, map.get(AssessmentBillMeta.ETIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssessmentBillMeta.DELETE_BY)));
			this.setTaskName(DataParser.parse(String.class, map.get(AssessmentBillMeta.TASK_NAME)));
			this.setId(DataParser.parse(String.class, map.get(AssessmentBillMeta.ID)));
			this.setTaskId(DataParser.parse(String.class, map.get(AssessmentBillMeta.TASK_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssessmentBillMeta.STATUS)));
			// others
			this.setAssessmentDataTask(DataParser.parse(AssessmentTask.class, map.get(AssessmentBillMeta.ASSESSMENT_DATA_TASK)));
			this.setAssessmentTask(DataParser.parse(AssessmentTask.class, map.get(AssessmentBillMeta.ASSESSMENT_TASK)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AssessmentBillMeta.NOTES));
				this.setTaskDataId( (String)map.get(AssessmentBillMeta.TASK_DATA_ID));
				this.setStime( (Date)map.get(AssessmentBillMeta.STIME));
				this.setUpdateTime( (Date)map.get(AssessmentBillMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssessmentBillMeta.VERSION));
				this.setIsShow( (String)map.get(AssessmentBillMeta.IS_SHOW));
				this.setCreateBy( (String)map.get(AssessmentBillMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssessmentBillMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssessmentBillMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssessmentBillMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssessmentBillMeta.DELETE_TIME));
				this.setEtime( (Date)map.get(AssessmentBillMeta.ETIME));
				this.setDeleteBy( (String)map.get(AssessmentBillMeta.DELETE_BY));
				this.setTaskName( (String)map.get(AssessmentBillMeta.TASK_NAME));
				this.setId( (String)map.get(AssessmentBillMeta.ID));
				this.setTaskId( (String)map.get(AssessmentBillMeta.TASK_ID));
				this.setStatus( (String)map.get(AssessmentBillMeta.STATUS));
				// others
				this.setAssessmentDataTask( (AssessmentTask)map.get(AssessmentBillMeta.ASSESSMENT_DATA_TASK));
				this.setAssessmentTask( (AssessmentTask)map.get(AssessmentBillMeta.ASSESSMENT_TASK));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AssessmentBillMeta.NOTES)));
			this.setTaskDataId(DataParser.parse(String.class, r.getValue(AssessmentBillMeta.TASK_DATA_ID)));
			this.setStime(DataParser.parse(Date.class, r.getValue(AssessmentBillMeta.STIME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssessmentBillMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssessmentBillMeta.VERSION)));
			this.setIsShow(DataParser.parse(String.class, r.getValue(AssessmentBillMeta.IS_SHOW)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssessmentBillMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssessmentBillMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssessmentBillMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssessmentBillMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssessmentBillMeta.DELETE_TIME)));
			this.setEtime(DataParser.parse(Date.class, r.getValue(AssessmentBillMeta.ETIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssessmentBillMeta.DELETE_BY)));
			this.setTaskName(DataParser.parse(String.class, r.getValue(AssessmentBillMeta.TASK_NAME)));
			this.setId(DataParser.parse(String.class, r.getValue(AssessmentBillMeta.ID)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(AssessmentBillMeta.TASK_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssessmentBillMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AssessmentBillMeta.NOTES));
				this.setTaskDataId( (String)r.getValue(AssessmentBillMeta.TASK_DATA_ID));
				this.setStime( (Date)r.getValue(AssessmentBillMeta.STIME));
				this.setUpdateTime( (Date)r.getValue(AssessmentBillMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssessmentBillMeta.VERSION));
				this.setIsShow( (String)r.getValue(AssessmentBillMeta.IS_SHOW));
				this.setCreateBy( (String)r.getValue(AssessmentBillMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssessmentBillMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssessmentBillMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssessmentBillMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssessmentBillMeta.DELETE_TIME));
				this.setEtime( (Date)r.getValue(AssessmentBillMeta.ETIME));
				this.setDeleteBy( (String)r.getValue(AssessmentBillMeta.DELETE_BY));
				this.setTaskName( (String)r.getValue(AssessmentBillMeta.TASK_NAME));
				this.setId( (String)r.getValue(AssessmentBillMeta.ID));
				this.setTaskId( (String)r.getValue(AssessmentBillMeta.TASK_ID));
				this.setStatus( (String)r.getValue(AssessmentBillMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}