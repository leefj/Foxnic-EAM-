package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_LEAVE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.PersonLeaveMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 员工离职
 * <p>员工离职 , 数据表 hr_person_leave 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-14 12:58:41
 * @sign 8AFE03487904E3E51D842E834DD0E38B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_leave")
@ApiModel(description = "员工离职 ; 员工离职 , 数据表 hr_person_leave 的PO类型")
public class PersonLeave extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_LEAVE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 编号：编号
	*/
	@ApiModelProperty(required = false,value="编号" , notes = "编号")
	private String businessCode;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 离职人员：离职人员
	*/
	@ApiModelProperty(required = false,value="离职人员" , notes = "离职人员")
	private String personId;
	
	/**
	 * 交接人：交接人
	*/
	@ApiModelProperty(required = false,value="交接人" , notes = "交接人")
	private String handoverId;
	
	/**
	 * 离职日期：离职日期
	*/
	@ApiModelProperty(required = false,value="离职日期" , notes = "离职日期")
	private Date leaveDate;
	
	/**
	 * 原因：原因
	*/
	@ApiModelProperty(required = false,value="原因" , notes = "原因")
	private String content;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String fileIds;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String note;
	
	/**
	 * 操作人：操作人
	*/
	@ApiModelProperty(required = false,value="操作人" , notes = "操作人")
	private String operUserId;
	
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
	 * handover：handover
	*/
	@ApiModelProperty(required = false,value="handover" , notes = "handover")
	private Person handover;
	
	/**
	 * 历史流程清单：历史流程清单
	*/
	@ApiModelProperty(required = false,value="历史流程清单" , notes = "历史流程清单")
	private List<ProcessInstance> historicProcessList;
	
	/**
	 * 在批的流程清单：在批的流程清单
	*/
	@ApiModelProperty(required = false,value="在批的流程清单" , notes = "在批的流程清单")
	private List<ProcessInstance> currentProcessList;
	
	/**
	 * 默认流程：优先取在批的流程
	*/
	@ApiModelProperty(required = false,value="默认流程" , notes = "优先取在批的流程")
	private ProcessInstance defaultProcess;
	
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
	public PersonLeave setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编号<br>
	 * 编号
	 * @return 编号
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 编号
	 * @param businessCode 编号
	 * @return 当前对象
	*/
	public PersonLeave setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
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
	public PersonLeave setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 离职人员<br>
	 * 离职人员
	 * @return 离职人员
	*/
	public String getPersonId() {
		return personId;
	}
	
	/**
	 * 设置 离职人员
	 * @param personId 离职人员
	 * @return 当前对象
	*/
	public PersonLeave setPersonId(String personId) {
		this.personId=personId;
		return this;
	}
	
	/**
	 * 获得 交接人<br>
	 * 交接人
	 * @return 交接人
	*/
	public String getHandoverId() {
		return handoverId;
	}
	
	/**
	 * 设置 交接人
	 * @param handoverId 交接人
	 * @return 当前对象
	*/
	public PersonLeave setHandoverId(String handoverId) {
		this.handoverId=handoverId;
		return this;
	}
	
	/**
	 * 获得 离职日期<br>
	 * 离职日期
	 * @return 离职日期
	*/
	public Date getLeaveDate() {
		return leaveDate;
	}
	
	/**
	 * 设置 离职日期
	 * @param leaveDate 离职日期
	 * @return 当前对象
	*/
	public PersonLeave setLeaveDate(Date leaveDate) {
		this.leaveDate=leaveDate;
		return this;
	}
	
	/**
	 * 获得 原因<br>
	 * 原因
	 * @return 原因
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 原因
	 * @param content 原因
	 * @return 当前对象
	*/
	public PersonLeave setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getFileIds() {
		return fileIds;
	}
	
	/**
	 * 设置 附件
	 * @param fileIds 附件
	 * @return 当前对象
	*/
	public PersonLeave setFileIds(String fileIds) {
		this.fileIds=fileIds;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNote() {
		return note;
	}
	
	/**
	 * 设置 备注
	 * @param note 备注
	 * @return 当前对象
	*/
	public PersonLeave setNote(String note) {
		this.note=note;
		return this;
	}
	
	/**
	 * 获得 操作人<br>
	 * 操作人
	 * @return 操作人
	*/
	public String getOperUserId() {
		return operUserId;
	}
	
	/**
	 * 设置 操作人
	 * @param operUserId 操作人
	 * @return 当前对象
	*/
	public PersonLeave setOperUserId(String operUserId) {
		this.operUserId=operUserId;
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
	public PersonLeave setCreateBy(String createBy) {
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
	public PersonLeave setCreateTime(Date createTime) {
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
	public PersonLeave setUpdateBy(String updateBy) {
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
	public PersonLeave setUpdateTime(Date updateTime) {
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
	public PersonLeave setDeleted(Integer deleted) {
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
	public PersonLeave setDeleted(Boolean deletedBool) {
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
	public PersonLeave setDeleteBy(String deleteBy) {
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
	public PersonLeave setDeleteTime(Date deleteTime) {
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
	public PersonLeave setVersion(Integer version) {
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
	public PersonLeave setTenantId(String tenantId) {
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
	public PersonLeave setPerson(Person person) {
		this.person=person;
		return this;
	}
	
	/**
	 * 获得 handover<br>
	 * handover
	 * @return handover
	*/
	public Person getHandover() {
		return handover;
	}
	
	/**
	 * 设置 handover
	 * @param handover handover
	 * @return 当前对象
	*/
	public PersonLeave setHandover(Person handover) {
		this.handover=handover;
		return this;
	}
	
	/**
	 * 获得 历史流程清单<br>
	 * 历史流程清单
	 * @return 历史流程清单
	*/
	public List<ProcessInstance> getHistoricProcessList() {
		return historicProcessList;
	}
	
	/**
	 * 设置 历史流程清单
	 * @param historicProcessList 历史流程清单
	 * @return 当前对象
	*/
	public PersonLeave setHistoricProcessList(List<ProcessInstance> historicProcessList) {
		this.historicProcessList=historicProcessList;
		return this;
	}
	
	/**
	 * 添加 历史流程清单
	 * @param historicProcess 历史流程清单
	 * @return 当前对象
	*/
	public PersonLeave addHistoricProcess(ProcessInstance... historicProcess) {
		if(this.historicProcessList==null) historicProcessList=new ArrayList<>();
		this.historicProcessList.addAll(Arrays.asList(historicProcess));
		return this;
	}
	
	/**
	 * 获得 在批的流程清单<br>
	 * 在批的流程清单
	 * @return 在批的流程清单
	*/
	public List<ProcessInstance> getCurrentProcessList() {
		return currentProcessList;
	}
	
	/**
	 * 设置 在批的流程清单
	 * @param currentProcessList 在批的流程清单
	 * @return 当前对象
	*/
	public PersonLeave setCurrentProcessList(List<ProcessInstance> currentProcessList) {
		this.currentProcessList=currentProcessList;
		return this;
	}
	
	/**
	 * 添加 在批的流程清单
	 * @param currentProcess 在批的流程清单
	 * @return 当前对象
	*/
	public PersonLeave addCurrentProcess(ProcessInstance... currentProcess) {
		if(this.currentProcessList==null) currentProcessList=new ArrayList<>();
		this.currentProcessList.addAll(Arrays.asList(currentProcess));
		return this;
	}
	
	/**
	 * 获得 默认流程<br>
	 * 优先取在批的流程
	 * @return 默认流程
	*/
	public ProcessInstance getDefaultProcess() {
		return defaultProcess;
	}
	
	/**
	 * 设置 默认流程
	 * @param defaultProcess 默认流程
	 * @return 当前对象
	*/
	public PersonLeave setDefaultProcess(ProcessInstance defaultProcess) {
		this.defaultProcess=defaultProcess;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonLeave , 转换好的 PersonLeave 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonLeave , 转换好的 PoJo 对象
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
	public PersonLeave clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonLeave duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonLeaveMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonLeaveMeta.$$proxy$$();
		inst.setNote(this.getNote());
		inst.setOperUserId(this.getOperUserId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setHandoverId(this.getHandoverId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setFileIds(this.getFileIds());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setLeaveDate(this.getLeaveDate());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setHandover(this.getHandover());
			inst.setPerson(this.getPerson());
			inst.setHistoricProcessList(this.getHistoricProcessList());
			inst.setCurrentProcessList(this.getCurrentProcessList());
			inst.setDefaultProcess(this.getDefaultProcess());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonLeave clone(boolean deep) {
		return EntityContext.clone(PersonLeave.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonLeave
	 * @param personLeaveMap 包含实体信息的 Map 对象
	 * @return PersonLeave , 转换好的的 PersonLeave 对象
	*/
	@Transient
	public static PersonLeave createFrom(Map<String,Object> personLeaveMap) {
		if(personLeaveMap==null) return null;
		PersonLeave po = create();
		EntityContext.copyProperties(po,personLeaveMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonLeave
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonLeave , 转换好的的 PersonLeave 对象
	*/
	@Transient
	public static PersonLeave createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonLeave po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonLeave，等同于 new
	 * @return PersonLeave 对象
	*/
	@Transient
	public static PersonLeave create() {
		return new com.dt.platform.domain.hr.meta.PersonLeaveMeta.$$proxy$$();
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
			this.setNote(DataParser.parse(String.class, map.get(PersonLeaveMeta.NOTE)));
			this.setOperUserId(DataParser.parse(String.class, map.get(PersonLeaveMeta.OPER_USER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonLeaveMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonLeaveMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(PersonLeaveMeta.CONTENT)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(PersonLeaveMeta.BUSINESS_CODE)));
			this.setHandoverId(DataParser.parse(String.class, map.get(PersonLeaveMeta.HANDOVER_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonLeaveMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonLeaveMeta.DELETED)));
			this.setFileIds(DataParser.parse(String.class, map.get(PersonLeaveMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonLeaveMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonLeaveMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonLeaveMeta.DELETE_TIME)));
			this.setLeaveDate(DataParser.parse(Date.class, map.get(PersonLeaveMeta.LEAVE_DATE)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonLeaveMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonLeaveMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(PersonLeaveMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(PersonLeaveMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonLeaveMeta.STATUS)));
			// others
			this.setHandover(DataParser.parse(Person.class, map.get(PersonLeaveMeta.HANDOVER)));
			this.setPerson(DataParser.parse(Person.class, map.get(PersonLeaveMeta.PERSON)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(PersonLeaveMeta.DEFAULT_PROCESS)));
			return true;
		} else {
			try {
				this.setNote( (String)map.get(PersonLeaveMeta.NOTE));
				this.setOperUserId( (String)map.get(PersonLeaveMeta.OPER_USER_ID));
				this.setUpdateTime( (Date)map.get(PersonLeaveMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PersonLeaveMeta.VERSION));
				this.setContent( (String)map.get(PersonLeaveMeta.CONTENT));
				this.setBusinessCode( (String)map.get(PersonLeaveMeta.BUSINESS_CODE));
				this.setHandoverId( (String)map.get(PersonLeaveMeta.HANDOVER_ID));
				this.setCreateBy( (String)map.get(PersonLeaveMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonLeaveMeta.DELETED));
				this.setFileIds( (String)map.get(PersonLeaveMeta.FILE_IDS));
				this.setCreateTime( (Date)map.get(PersonLeaveMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonLeaveMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonLeaveMeta.DELETE_TIME));
				this.setLeaveDate( (Date)map.get(PersonLeaveMeta.LEAVE_DATE));
				this.setTenantId( (String)map.get(PersonLeaveMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonLeaveMeta.DELETE_BY));
				this.setPersonId( (String)map.get(PersonLeaveMeta.PERSON_ID));
				this.setId( (String)map.get(PersonLeaveMeta.ID));
				this.setStatus( (String)map.get(PersonLeaveMeta.STATUS));
				// others
				this.setHandover( (Person)map.get(PersonLeaveMeta.HANDOVER));
				this.setPerson( (Person)map.get(PersonLeaveMeta.PERSON));
				this.setDefaultProcess( (ProcessInstance)map.get(PersonLeaveMeta.DEFAULT_PROCESS));
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
			this.setNote(DataParser.parse(String.class, r.getValue(PersonLeaveMeta.NOTE)));
			this.setOperUserId(DataParser.parse(String.class, r.getValue(PersonLeaveMeta.OPER_USER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonLeaveMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonLeaveMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(PersonLeaveMeta.CONTENT)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(PersonLeaveMeta.BUSINESS_CODE)));
			this.setHandoverId(DataParser.parse(String.class, r.getValue(PersonLeaveMeta.HANDOVER_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonLeaveMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonLeaveMeta.DELETED)));
			this.setFileIds(DataParser.parse(String.class, r.getValue(PersonLeaveMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonLeaveMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonLeaveMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonLeaveMeta.DELETE_TIME)));
			this.setLeaveDate(DataParser.parse(Date.class, r.getValue(PersonLeaveMeta.LEAVE_DATE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonLeaveMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonLeaveMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(PersonLeaveMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonLeaveMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonLeaveMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNote( (String)r.getValue(PersonLeaveMeta.NOTE));
				this.setOperUserId( (String)r.getValue(PersonLeaveMeta.OPER_USER_ID));
				this.setUpdateTime( (Date)r.getValue(PersonLeaveMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PersonLeaveMeta.VERSION));
				this.setContent( (String)r.getValue(PersonLeaveMeta.CONTENT));
				this.setBusinessCode( (String)r.getValue(PersonLeaveMeta.BUSINESS_CODE));
				this.setHandoverId( (String)r.getValue(PersonLeaveMeta.HANDOVER_ID));
				this.setCreateBy( (String)r.getValue(PersonLeaveMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonLeaveMeta.DELETED));
				this.setFileIds( (String)r.getValue(PersonLeaveMeta.FILE_IDS));
				this.setCreateTime( (Date)r.getValue(PersonLeaveMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonLeaveMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonLeaveMeta.DELETE_TIME));
				this.setLeaveDate( (Date)r.getValue(PersonLeaveMeta.LEAVE_DATE));
				this.setTenantId( (String)r.getValue(PersonLeaveMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonLeaveMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(PersonLeaveMeta.PERSON_ID));
				this.setId( (String)r.getValue(PersonLeaveMeta.ID));
				this.setStatus( (String)r.getValue(PersonLeaveMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}