package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_CONFIRM_APPLY;
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
import com.dt.platform.domain.hr.meta.PersonConfirmApplyMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 转正申请
 * <p>转正申请 , 数据表 hr_person_confirm_apply 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-14 12:58:58
 * @sign 15D9C56BA4755CDAE237DF65693E02F5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_confirm_apply")
@ApiModel(description = "转正申请 ; 转正申请 , 数据表 hr_person_confirm_apply 的PO类型")
public class PersonConfirmApply extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_CONFIRM_APPLY.$TABLE;
	
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
	 * 申请人员：申请人员
	*/
	@ApiModelProperty(required = false,value="申请人员" , notes = "申请人员")
	private String personId;
	
	/**
	 * 转正日期：转正日期
	*/
	@ApiModelProperty(required = false,value="转正日期" , notes = "转正日期")
	private Date confirmDate;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
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
	public PersonConfirmApply setId(String id) {
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
	public PersonConfirmApply setBusinessCode(String businessCode) {
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
	public PersonConfirmApply setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 申请人员<br>
	 * 申请人员
	 * @return 申请人员
	*/
	public String getPersonId() {
		return personId;
	}
	
	/**
	 * 设置 申请人员
	 * @param personId 申请人员
	 * @return 当前对象
	*/
	public PersonConfirmApply setPersonId(String personId) {
		this.personId=personId;
		return this;
	}
	
	/**
	 * 获得 转正日期<br>
	 * 转正日期
	 * @return 转正日期
	*/
	public Date getConfirmDate() {
		return confirmDate;
	}
	
	/**
	 * 设置 转正日期
	 * @param confirmDate 转正日期
	 * @return 当前对象
	*/
	public PersonConfirmApply setConfirmDate(Date confirmDate) {
		this.confirmDate=confirmDate;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 内容
	 * @param content 内容
	 * @return 当前对象
	*/
	public PersonConfirmApply setContent(String content) {
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
	public PersonConfirmApply setFileIds(String fileIds) {
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
	public PersonConfirmApply setNote(String note) {
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
	public PersonConfirmApply setOperUserId(String operUserId) {
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
	public PersonConfirmApply setCreateBy(String createBy) {
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
	public PersonConfirmApply setCreateTime(Date createTime) {
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
	public PersonConfirmApply setUpdateBy(String updateBy) {
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
	public PersonConfirmApply setUpdateTime(Date updateTime) {
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
	public PersonConfirmApply setDeleted(Integer deleted) {
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
	public PersonConfirmApply setDeleted(Boolean deletedBool) {
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
	public PersonConfirmApply setDeleteBy(String deleteBy) {
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
	public PersonConfirmApply setDeleteTime(Date deleteTime) {
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
	public PersonConfirmApply setVersion(Integer version) {
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
	public PersonConfirmApply setTenantId(String tenantId) {
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
	public PersonConfirmApply setPerson(Person person) {
		this.person=person;
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
	public PersonConfirmApply setHistoricProcessList(List<ProcessInstance> historicProcessList) {
		this.historicProcessList=historicProcessList;
		return this;
	}
	
	/**
	 * 添加 历史流程清单
	 * @param historicProcess 历史流程清单
	 * @return 当前对象
	*/
	public PersonConfirmApply addHistoricProcess(ProcessInstance... historicProcess) {
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
	public PersonConfirmApply setCurrentProcessList(List<ProcessInstance> currentProcessList) {
		this.currentProcessList=currentProcessList;
		return this;
	}
	
	/**
	 * 添加 在批的流程清单
	 * @param currentProcess 在批的流程清单
	 * @return 当前对象
	*/
	public PersonConfirmApply addCurrentProcess(ProcessInstance... currentProcess) {
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
	public PersonConfirmApply setDefaultProcess(ProcessInstance defaultProcess) {
		this.defaultProcess=defaultProcess;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonConfirmApply , 转换好的 PersonConfirmApply 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonConfirmApply , 转换好的 PoJo 对象
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
	public PersonConfirmApply clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonConfirmApply duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonConfirmApplyMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonConfirmApplyMeta.$$proxy$$();
		inst.setNote(this.getNote());
		inst.setOperUserId(this.getOperUserId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setConfirmDate(this.getConfirmDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setFileIds(this.getFileIds());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
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
	public PersonConfirmApply clone(boolean deep) {
		return EntityContext.clone(PersonConfirmApply.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonConfirmApply
	 * @param personConfirmApplyMap 包含实体信息的 Map 对象
	 * @return PersonConfirmApply , 转换好的的 PersonConfirmApply 对象
	*/
	@Transient
	public static PersonConfirmApply createFrom(Map<String,Object> personConfirmApplyMap) {
		if(personConfirmApplyMap==null) return null;
		PersonConfirmApply po = create();
		EntityContext.copyProperties(po,personConfirmApplyMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonConfirmApply
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonConfirmApply , 转换好的的 PersonConfirmApply 对象
	*/
	@Transient
	public static PersonConfirmApply createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonConfirmApply po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonConfirmApply，等同于 new
	 * @return PersonConfirmApply 对象
	*/
	@Transient
	public static PersonConfirmApply create() {
		return new com.dt.platform.domain.hr.meta.PersonConfirmApplyMeta.$$proxy$$();
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
			this.setNote(DataParser.parse(String.class, map.get(PersonConfirmApplyMeta.NOTE)));
			this.setOperUserId(DataParser.parse(String.class, map.get(PersonConfirmApplyMeta.OPER_USER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonConfirmApplyMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonConfirmApplyMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(PersonConfirmApplyMeta.CONTENT)));
			this.setConfirmDate(DataParser.parse(Date.class, map.get(PersonConfirmApplyMeta.CONFIRM_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(PersonConfirmApplyMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonConfirmApplyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonConfirmApplyMeta.DELETED)));
			this.setFileIds(DataParser.parse(String.class, map.get(PersonConfirmApplyMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonConfirmApplyMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonConfirmApplyMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonConfirmApplyMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonConfirmApplyMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonConfirmApplyMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(PersonConfirmApplyMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(PersonConfirmApplyMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonConfirmApplyMeta.STATUS)));
			// others
			this.setPerson(DataParser.parse(Person.class, map.get(PersonConfirmApplyMeta.PERSON)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(PersonConfirmApplyMeta.DEFAULT_PROCESS)));
			return true;
		} else {
			try {
				this.setNote( (String)map.get(PersonConfirmApplyMeta.NOTE));
				this.setOperUserId( (String)map.get(PersonConfirmApplyMeta.OPER_USER_ID));
				this.setUpdateTime( (Date)map.get(PersonConfirmApplyMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PersonConfirmApplyMeta.VERSION));
				this.setContent( (String)map.get(PersonConfirmApplyMeta.CONTENT));
				this.setConfirmDate( (Date)map.get(PersonConfirmApplyMeta.CONFIRM_DATE));
				this.setBusinessCode( (String)map.get(PersonConfirmApplyMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(PersonConfirmApplyMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonConfirmApplyMeta.DELETED));
				this.setFileIds( (String)map.get(PersonConfirmApplyMeta.FILE_IDS));
				this.setCreateTime( (Date)map.get(PersonConfirmApplyMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonConfirmApplyMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonConfirmApplyMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(PersonConfirmApplyMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonConfirmApplyMeta.DELETE_BY));
				this.setPersonId( (String)map.get(PersonConfirmApplyMeta.PERSON_ID));
				this.setId( (String)map.get(PersonConfirmApplyMeta.ID));
				this.setStatus( (String)map.get(PersonConfirmApplyMeta.STATUS));
				// others
				this.setPerson( (Person)map.get(PersonConfirmApplyMeta.PERSON));
				this.setDefaultProcess( (ProcessInstance)map.get(PersonConfirmApplyMeta.DEFAULT_PROCESS));
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
			this.setNote(DataParser.parse(String.class, r.getValue(PersonConfirmApplyMeta.NOTE)));
			this.setOperUserId(DataParser.parse(String.class, r.getValue(PersonConfirmApplyMeta.OPER_USER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonConfirmApplyMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonConfirmApplyMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(PersonConfirmApplyMeta.CONTENT)));
			this.setConfirmDate(DataParser.parse(Date.class, r.getValue(PersonConfirmApplyMeta.CONFIRM_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(PersonConfirmApplyMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonConfirmApplyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonConfirmApplyMeta.DELETED)));
			this.setFileIds(DataParser.parse(String.class, r.getValue(PersonConfirmApplyMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonConfirmApplyMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonConfirmApplyMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonConfirmApplyMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonConfirmApplyMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonConfirmApplyMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(PersonConfirmApplyMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonConfirmApplyMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonConfirmApplyMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNote( (String)r.getValue(PersonConfirmApplyMeta.NOTE));
				this.setOperUserId( (String)r.getValue(PersonConfirmApplyMeta.OPER_USER_ID));
				this.setUpdateTime( (Date)r.getValue(PersonConfirmApplyMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PersonConfirmApplyMeta.VERSION));
				this.setContent( (String)r.getValue(PersonConfirmApplyMeta.CONTENT));
				this.setConfirmDate( (Date)r.getValue(PersonConfirmApplyMeta.CONFIRM_DATE));
				this.setBusinessCode( (String)r.getValue(PersonConfirmApplyMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(PersonConfirmApplyMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonConfirmApplyMeta.DELETED));
				this.setFileIds( (String)r.getValue(PersonConfirmApplyMeta.FILE_IDS));
				this.setCreateTime( (Date)r.getValue(PersonConfirmApplyMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonConfirmApplyMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonConfirmApplyMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(PersonConfirmApplyMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonConfirmApplyMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(PersonConfirmApplyMeta.PERSON_ID));
				this.setId( (String)r.getValue(PersonConfirmApplyMeta.ID));
				this.setStatus( (String)r.getValue(PersonConfirmApplyMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}