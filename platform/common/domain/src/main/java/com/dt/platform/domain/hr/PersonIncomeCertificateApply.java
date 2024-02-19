package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.PersonIncomeCertificateApplyMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 收入证明申请
 * <p>收入证明申请 , 数据表 hr_person_income_certificate_apply 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-19 20:14:36
 * @sign 4EC1C38BC401994DA5D100AE70562547
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_income_certificate_apply")
@ApiModel(description = "收入证明申请 ; 收入证明申请 , 数据表 hr_person_income_certificate_apply 的PO类型")
public class PersonIncomeCertificateApply extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_INCOME_CERTIFICATE_APPLY.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "812048675378298880")
	private String id;
	
	/**
	 * 编号：编号
	*/
	@ApiModelProperty(required = false,value="编号" , notes = "编号" , example = "EO202451191951579")
	private String businessCode;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态" , example = "incomplete")
	private String status;
	
	/**
	 * 申请部门：申请部门
	*/
	@ApiModelProperty(required = false,value="申请部门" , notes = "申请部门" , example = "788871090188320766")
	private String orgId;
	
	/**
	 * 申请人员：申请人员
	*/
	@ApiModelProperty(required = false,value="申请人员" , notes = "申请人员" , example = "617107757929070592")
	private String personId;
	
	/**
	 * 申请日期：申请日期
	*/
	@ApiModelProperty(required = false,value="申请日期" , notes = "申请日期" , example = "2024-02-14 12:00:00")
	private Date confirmDate;
	
	/**
	 * 身份证：身份证
	*/
	@ApiModelProperty(required = false,value="身份证" , notes = "身份证" , example = "1212")
	private String card;
	
	/**
	 * 证明有效期：证明有效期
	*/
	@ApiModelProperty(required = false,value="证明有效期" , notes = "证明有效期" , example = "12")
	private String period;
	
	/**
	 * 原因：原因
	*/
	@ApiModelProperty(required = false,value="原因" , notes = "原因" , example = "121212")
	private String content;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String fileId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String note;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-19 07:51:31")
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * organization：organization
	*/
	@ApiModelProperty(required = false,value="organization" , notes = "organization")
	private Organization organization;
	
	/**
	 * person：person
	*/
	@ApiModelProperty(required = false,value="person" , notes = "person")
	private Employee person;
	
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
	public PersonIncomeCertificateApply setId(String id) {
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
	public PersonIncomeCertificateApply setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 办理状态<br>
	 * 办理状态
	 * @return 办理状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 办理状态
	 * @param status 办理状态
	 * @return 当前对象
	*/
	public PersonIncomeCertificateApply setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 申请部门<br>
	 * 申请部门
	 * @return 申请部门
	*/
	public String getOrgId() {
		return orgId;
	}
	
	/**
	 * 设置 申请部门
	 * @param orgId 申请部门
	 * @return 当前对象
	*/
	public PersonIncomeCertificateApply setOrgId(String orgId) {
		this.orgId=orgId;
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
	public PersonIncomeCertificateApply setPersonId(String personId) {
		this.personId=personId;
		return this;
	}
	
	/**
	 * 获得 申请日期<br>
	 * 申请日期
	 * @return 申请日期
	*/
	public Date getConfirmDate() {
		return confirmDate;
	}
	
	/**
	 * 设置 申请日期
	 * @param confirmDate 申请日期
	 * @return 当前对象
	*/
	public PersonIncomeCertificateApply setConfirmDate(Date confirmDate) {
		this.confirmDate=confirmDate;
		return this;
	}
	
	/**
	 * 获得 身份证<br>
	 * 身份证
	 * @return 身份证
	*/
	public String getCard() {
		return card;
	}
	
	/**
	 * 设置 身份证
	 * @param card 身份证
	 * @return 当前对象
	*/
	public PersonIncomeCertificateApply setCard(String card) {
		this.card=card;
		return this;
	}
	
	/**
	 * 获得 证明有效期<br>
	 * 证明有效期
	 * @return 证明有效期
	*/
	public String getPeriod() {
		return period;
	}
	
	/**
	 * 设置 证明有效期
	 * @param period 证明有效期
	 * @return 当前对象
	*/
	public PersonIncomeCertificateApply setPeriod(String period) {
		this.period=period;
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
	public PersonIncomeCertificateApply setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 附件
	 * @param fileId 附件
	 * @return 当前对象
	*/
	public PersonIncomeCertificateApply setFileId(String fileId) {
		this.fileId=fileId;
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
	public PersonIncomeCertificateApply setNote(String note) {
		this.note=note;
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
	public PersonIncomeCertificateApply setCreateBy(String createBy) {
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
	public PersonIncomeCertificateApply setCreateTime(Date createTime) {
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
	public PersonIncomeCertificateApply setUpdateBy(String updateBy) {
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
	public PersonIncomeCertificateApply setUpdateTime(Date updateTime) {
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
	public PersonIncomeCertificateApply setDeleted(Integer deleted) {
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
	public PersonIncomeCertificateApply setDeleted(Boolean deletedBool) {
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
	public PersonIncomeCertificateApply setDeleteBy(String deleteBy) {
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
	public PersonIncomeCertificateApply setDeleteTime(Date deleteTime) {
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
	public PersonIncomeCertificateApply setVersion(Integer version) {
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
	public PersonIncomeCertificateApply setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 organization<br>
	 * organization
	 * @return organization
	*/
	public Organization getOrganization() {
		return organization;
	}
	
	/**
	 * 设置 organization
	 * @param organization organization
	 * @return 当前对象
	*/
	public PersonIncomeCertificateApply setOrganization(Organization organization) {
		this.organization=organization;
		return this;
	}
	
	/**
	 * 获得 person<br>
	 * person
	 * @return person
	*/
	public Employee getPerson() {
		return person;
	}
	
	/**
	 * 设置 person
	 * @param person person
	 * @return 当前对象
	*/
	public PersonIncomeCertificateApply setPerson(Employee person) {
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
	public PersonIncomeCertificateApply setHistoricProcessList(List<ProcessInstance> historicProcessList) {
		this.historicProcessList=historicProcessList;
		return this;
	}
	
	/**
	 * 添加 历史流程清单
	 * @param historicProcess 历史流程清单
	 * @return 当前对象
	*/
	public PersonIncomeCertificateApply addHistoricProcess(ProcessInstance... historicProcess) {
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
	public PersonIncomeCertificateApply setCurrentProcessList(List<ProcessInstance> currentProcessList) {
		this.currentProcessList=currentProcessList;
		return this;
	}
	
	/**
	 * 添加 在批的流程清单
	 * @param currentProcess 在批的流程清单
	 * @return 当前对象
	*/
	public PersonIncomeCertificateApply addCurrentProcess(ProcessInstance... currentProcess) {
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
	public PersonIncomeCertificateApply setDefaultProcess(ProcessInstance defaultProcess) {
		this.defaultProcess=defaultProcess;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonIncomeCertificateApply , 转换好的 PersonIncomeCertificateApply 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonIncomeCertificateApply , 转换好的 PoJo 对象
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
	public PersonIncomeCertificateApply clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonIncomeCertificateApply duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonIncomeCertificateApplyMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonIncomeCertificateApplyMeta.$$proxy$$();
		inst.setNote(this.getNote());
		inst.setPeriod(this.getPeriod());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setOrgId(this.getOrgId());
		inst.setContent(this.getContent());
		inst.setConfirmDate(this.getConfirmDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setId(this.getId());
		inst.setCard(this.getCard());
		inst.setStatus(this.getStatus());
		inst.setFileId(this.getFileId());
		if(all) {
			inst.setPerson(this.getPerson());
			inst.setOrganization(this.getOrganization());
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
	public PersonIncomeCertificateApply clone(boolean deep) {
		return EntityContext.clone(PersonIncomeCertificateApply.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonIncomeCertificateApply
	 * @param personIncomeCertificateApplyMap 包含实体信息的 Map 对象
	 * @return PersonIncomeCertificateApply , 转换好的的 PersonIncomeCertificateApply 对象
	*/
	@Transient
	public static PersonIncomeCertificateApply createFrom(Map<String,Object> personIncomeCertificateApplyMap) {
		if(personIncomeCertificateApplyMap==null) return null;
		PersonIncomeCertificateApply po = create();
		EntityContext.copyProperties(po,personIncomeCertificateApplyMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonIncomeCertificateApply
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonIncomeCertificateApply , 转换好的的 PersonIncomeCertificateApply 对象
	*/
	@Transient
	public static PersonIncomeCertificateApply createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonIncomeCertificateApply po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonIncomeCertificateApply，等同于 new
	 * @return PersonIncomeCertificateApply 对象
	*/
	@Transient
	public static PersonIncomeCertificateApply create() {
		return new com.dt.platform.domain.hr.meta.PersonIncomeCertificateApplyMeta.$$proxy$$();
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
			this.setNote(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyMeta.NOTE)));
			this.setPeriod(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyMeta.PERIOD)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonIncomeCertificateApplyMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonIncomeCertificateApplyMeta.VERSION)));
			this.setOrgId(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyMeta.ORG_ID)));
			this.setContent(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyMeta.CONTENT)));
			this.setConfirmDate(DataParser.parse(Date.class, map.get(PersonIncomeCertificateApplyMeta.CONFIRM_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonIncomeCertificateApplyMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonIncomeCertificateApplyMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonIncomeCertificateApplyMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyMeta.ID)));
			this.setCard(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyMeta.CARD)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyMeta.STATUS)));
			this.setFileId(DataParser.parse(String.class, map.get(PersonIncomeCertificateApplyMeta.FILE_ID)));
			// others
			this.setPerson(DataParser.parse(Employee.class, map.get(PersonIncomeCertificateApplyMeta.PERSON)));
			this.setOrganization(DataParser.parse(Organization.class, map.get(PersonIncomeCertificateApplyMeta.ORGANIZATION)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(PersonIncomeCertificateApplyMeta.DEFAULT_PROCESS)));
			return true;
		} else {
			try {
				this.setNote( (String)map.get(PersonIncomeCertificateApplyMeta.NOTE));
				this.setPeriod( (String)map.get(PersonIncomeCertificateApplyMeta.PERIOD));
				this.setUpdateTime( (Date)map.get(PersonIncomeCertificateApplyMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PersonIncomeCertificateApplyMeta.VERSION));
				this.setOrgId( (String)map.get(PersonIncomeCertificateApplyMeta.ORG_ID));
				this.setContent( (String)map.get(PersonIncomeCertificateApplyMeta.CONTENT));
				this.setConfirmDate( (Date)map.get(PersonIncomeCertificateApplyMeta.CONFIRM_DATE));
				this.setBusinessCode( (String)map.get(PersonIncomeCertificateApplyMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(PersonIncomeCertificateApplyMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonIncomeCertificateApplyMeta.DELETED));
				this.setCreateTime( (Date)map.get(PersonIncomeCertificateApplyMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonIncomeCertificateApplyMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonIncomeCertificateApplyMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(PersonIncomeCertificateApplyMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonIncomeCertificateApplyMeta.DELETE_BY));
				this.setPersonId( (String)map.get(PersonIncomeCertificateApplyMeta.PERSON_ID));
				this.setId( (String)map.get(PersonIncomeCertificateApplyMeta.ID));
				this.setCard( (String)map.get(PersonIncomeCertificateApplyMeta.CARD));
				this.setStatus( (String)map.get(PersonIncomeCertificateApplyMeta.STATUS));
				this.setFileId( (String)map.get(PersonIncomeCertificateApplyMeta.FILE_ID));
				// others
				this.setPerson( (Employee)map.get(PersonIncomeCertificateApplyMeta.PERSON));
				this.setOrganization( (Organization)map.get(PersonIncomeCertificateApplyMeta.ORGANIZATION));
				this.setDefaultProcess( (ProcessInstance)map.get(PersonIncomeCertificateApplyMeta.DEFAULT_PROCESS));
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
			this.setNote(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyMeta.NOTE)));
			this.setPeriod(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyMeta.PERIOD)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonIncomeCertificateApplyMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonIncomeCertificateApplyMeta.VERSION)));
			this.setOrgId(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyMeta.ORG_ID)));
			this.setContent(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyMeta.CONTENT)));
			this.setConfirmDate(DataParser.parse(Date.class, r.getValue(PersonIncomeCertificateApplyMeta.CONFIRM_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonIncomeCertificateApplyMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonIncomeCertificateApplyMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonIncomeCertificateApplyMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyMeta.PERSON_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyMeta.ID)));
			this.setCard(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyMeta.CARD)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyMeta.STATUS)));
			this.setFileId(DataParser.parse(String.class, r.getValue(PersonIncomeCertificateApplyMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setNote( (String)r.getValue(PersonIncomeCertificateApplyMeta.NOTE));
				this.setPeriod( (String)r.getValue(PersonIncomeCertificateApplyMeta.PERIOD));
				this.setUpdateTime( (Date)r.getValue(PersonIncomeCertificateApplyMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PersonIncomeCertificateApplyMeta.VERSION));
				this.setOrgId( (String)r.getValue(PersonIncomeCertificateApplyMeta.ORG_ID));
				this.setContent( (String)r.getValue(PersonIncomeCertificateApplyMeta.CONTENT));
				this.setConfirmDate( (Date)r.getValue(PersonIncomeCertificateApplyMeta.CONFIRM_DATE));
				this.setBusinessCode( (String)r.getValue(PersonIncomeCertificateApplyMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(PersonIncomeCertificateApplyMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonIncomeCertificateApplyMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PersonIncomeCertificateApplyMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonIncomeCertificateApplyMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonIncomeCertificateApplyMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(PersonIncomeCertificateApplyMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonIncomeCertificateApplyMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(PersonIncomeCertificateApplyMeta.PERSON_ID));
				this.setId( (String)r.getValue(PersonIncomeCertificateApplyMeta.ID));
				this.setCard( (String)r.getValue(PersonIncomeCertificateApplyMeta.CARD));
				this.setStatus( (String)r.getValue(PersonIncomeCertificateApplyMeta.STATUS));
				this.setFileId( (String)r.getValue(PersonIncomeCertificateApplyMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}