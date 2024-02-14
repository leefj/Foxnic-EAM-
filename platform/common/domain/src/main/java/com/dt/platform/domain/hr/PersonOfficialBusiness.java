package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_OFFICIAL_BUSINESS;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
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
import com.dt.platform.domain.hr.meta.PersonOfficialBusinessMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 出差申请
 * <p>出差申请 , 数据表 hr_person_official_business 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-14 12:58:00
 * @sign F42AD5D7D23945DD6F80A9510C01F382
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_official_business")
@ApiModel(description = "出差申请 ; 出差申请 , 数据表 hr_person_official_business 的PO类型")
public class PersonOfficialBusiness extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_OFFICIAL_BUSINESS.$TABLE;
	
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
	 * 出差日期：出差日期
	*/
	@ApiModelProperty(required = false,value="出差日期" , notes = "出差日期")
	private Date leaveDate;
	
	/**
	 * 原因：原因
	*/
	@ApiModelProperty(required = false,value="原因" , notes = "原因")
	private String content;
	
	/**
	 * 地点：地点
	*/
	@ApiModelProperty(required = false,value="地点" , notes = "地点")
	private String location;
	
	/**
	 * 天数：天数
	*/
	@ApiModelProperty(required = false,value="天数" , notes = "天数")
	private BigDecimal days;
	
	/**
	 * 申请费用：申请费用
	*/
	@ApiModelProperty(required = false,value="申请费用" , notes = "申请费用")
	private BigDecimal money;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	public PersonOfficialBusiness setId(String id) {
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
	public PersonOfficialBusiness setBusinessCode(String businessCode) {
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
	public PersonOfficialBusiness setStatus(String status) {
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
	public PersonOfficialBusiness setPersonId(String personId) {
		this.personId=personId;
		return this;
	}
	
	/**
	 * 获得 出差日期<br>
	 * 出差日期
	 * @return 出差日期
	*/
	public Date getLeaveDate() {
		return leaveDate;
	}
	
	/**
	 * 设置 出差日期
	 * @param leaveDate 出差日期
	 * @return 当前对象
	*/
	public PersonOfficialBusiness setLeaveDate(Date leaveDate) {
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
	public PersonOfficialBusiness setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 地点<br>
	 * 地点
	 * @return 地点
	*/
	public String getLocation() {
		return location;
	}
	
	/**
	 * 设置 地点
	 * @param location 地点
	 * @return 当前对象
	*/
	public PersonOfficialBusiness setLocation(String location) {
		this.location=location;
		return this;
	}
	
	/**
	 * 获得 天数<br>
	 * 天数
	 * @return 天数
	*/
	public BigDecimal getDays() {
		return days;
	}
	
	/**
	 * 设置 天数
	 * @param days 天数
	 * @return 当前对象
	*/
	public PersonOfficialBusiness setDays(BigDecimal days) {
		this.days=days;
		return this;
	}
	
	/**
	 * 获得 申请费用<br>
	 * 申请费用
	 * @return 申请费用
	*/
	public BigDecimal getMoney() {
		return money;
	}
	
	/**
	 * 设置 申请费用
	 * @param money 申请费用
	 * @return 当前对象
	*/
	public PersonOfficialBusiness setMoney(BigDecimal money) {
		this.money=money;
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
	public PersonOfficialBusiness setNotes(String notes) {
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
	public PersonOfficialBusiness setCreateBy(String createBy) {
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
	public PersonOfficialBusiness setCreateTime(Date createTime) {
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
	public PersonOfficialBusiness setUpdateBy(String updateBy) {
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
	public PersonOfficialBusiness setUpdateTime(Date updateTime) {
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
	public PersonOfficialBusiness setDeleted(Integer deleted) {
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
	public PersonOfficialBusiness setDeleted(Boolean deletedBool) {
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
	public PersonOfficialBusiness setDeleteBy(String deleteBy) {
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
	public PersonOfficialBusiness setDeleteTime(Date deleteTime) {
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
	public PersonOfficialBusiness setVersion(Integer version) {
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
	public PersonOfficialBusiness setTenantId(String tenantId) {
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
	public PersonOfficialBusiness setPerson(Person person) {
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
	public PersonOfficialBusiness setHistoricProcessList(List<ProcessInstance> historicProcessList) {
		this.historicProcessList=historicProcessList;
		return this;
	}
	
	/**
	 * 添加 历史流程清单
	 * @param historicProcess 历史流程清单
	 * @return 当前对象
	*/
	public PersonOfficialBusiness addHistoricProcess(ProcessInstance... historicProcess) {
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
	public PersonOfficialBusiness setCurrentProcessList(List<ProcessInstance> currentProcessList) {
		this.currentProcessList=currentProcessList;
		return this;
	}
	
	/**
	 * 添加 在批的流程清单
	 * @param currentProcess 在批的流程清单
	 * @return 当前对象
	*/
	public PersonOfficialBusiness addCurrentProcess(ProcessInstance... currentProcess) {
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
	public PersonOfficialBusiness setDefaultProcess(ProcessInstance defaultProcess) {
		this.defaultProcess=defaultProcess;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonOfficialBusiness , 转换好的 PersonOfficialBusiness 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonOfficialBusiness , 转换好的 PoJo 对象
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
	public PersonOfficialBusiness clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonOfficialBusiness duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonOfficialBusinessMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonOfficialBusinessMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setMoney(this.getMoney());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setLeaveDate(this.getLeaveDate());
		inst.setTenantId(this.getTenantId());
		inst.setDays(this.getDays());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setLocation(this.getLocation());
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
	public PersonOfficialBusiness clone(boolean deep) {
		return EntityContext.clone(PersonOfficialBusiness.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonOfficialBusiness
	 * @param personOfficialBusinessMap 包含实体信息的 Map 对象
	 * @return PersonOfficialBusiness , 转换好的的 PersonOfficialBusiness 对象
	*/
	@Transient
	public static PersonOfficialBusiness createFrom(Map<String,Object> personOfficialBusinessMap) {
		if(personOfficialBusinessMap==null) return null;
		PersonOfficialBusiness po = create();
		EntityContext.copyProperties(po,personOfficialBusinessMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonOfficialBusiness
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonOfficialBusiness , 转换好的的 PersonOfficialBusiness 对象
	*/
	@Transient
	public static PersonOfficialBusiness createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonOfficialBusiness po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonOfficialBusiness，等同于 new
	 * @return PersonOfficialBusiness 对象
	*/
	@Transient
	public static PersonOfficialBusiness create() {
		return new com.dt.platform.domain.hr.meta.PersonOfficialBusinessMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(PersonOfficialBusinessMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonOfficialBusinessMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonOfficialBusinessMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(PersonOfficialBusinessMeta.CONTENT)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(PersonOfficialBusinessMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonOfficialBusinessMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonOfficialBusinessMeta.DELETED)));
			this.setMoney(DataParser.parse(BigDecimal.class, map.get(PersonOfficialBusinessMeta.MONEY)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonOfficialBusinessMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonOfficialBusinessMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonOfficialBusinessMeta.DELETE_TIME)));
			this.setLeaveDate(DataParser.parse(Date.class, map.get(PersonOfficialBusinessMeta.LEAVE_DATE)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonOfficialBusinessMeta.TENANT_ID)));
			this.setDays(DataParser.parse(BigDecimal.class, map.get(PersonOfficialBusinessMeta.DAYS)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonOfficialBusinessMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(PersonOfficialBusinessMeta.PERSON_ID)));
			this.setLocation(DataParser.parse(String.class, map.get(PersonOfficialBusinessMeta.LOCATION)));
			this.setId(DataParser.parse(String.class, map.get(PersonOfficialBusinessMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonOfficialBusinessMeta.STATUS)));
			// others
			this.setPerson(DataParser.parse(Person.class, map.get(PersonOfficialBusinessMeta.PERSON)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(PersonOfficialBusinessMeta.DEFAULT_PROCESS)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(PersonOfficialBusinessMeta.NOTES));
				this.setUpdateTime( (Date)map.get(PersonOfficialBusinessMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PersonOfficialBusinessMeta.VERSION));
				this.setContent( (String)map.get(PersonOfficialBusinessMeta.CONTENT));
				this.setBusinessCode( (String)map.get(PersonOfficialBusinessMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(PersonOfficialBusinessMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonOfficialBusinessMeta.DELETED));
				this.setMoney( (BigDecimal)map.get(PersonOfficialBusinessMeta.MONEY));
				this.setCreateTime( (Date)map.get(PersonOfficialBusinessMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonOfficialBusinessMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonOfficialBusinessMeta.DELETE_TIME));
				this.setLeaveDate( (Date)map.get(PersonOfficialBusinessMeta.LEAVE_DATE));
				this.setTenantId( (String)map.get(PersonOfficialBusinessMeta.TENANT_ID));
				this.setDays( (BigDecimal)map.get(PersonOfficialBusinessMeta.DAYS));
				this.setDeleteBy( (String)map.get(PersonOfficialBusinessMeta.DELETE_BY));
				this.setPersonId( (String)map.get(PersonOfficialBusinessMeta.PERSON_ID));
				this.setLocation( (String)map.get(PersonOfficialBusinessMeta.LOCATION));
				this.setId( (String)map.get(PersonOfficialBusinessMeta.ID));
				this.setStatus( (String)map.get(PersonOfficialBusinessMeta.STATUS));
				// others
				this.setPerson( (Person)map.get(PersonOfficialBusinessMeta.PERSON));
				this.setDefaultProcess( (ProcessInstance)map.get(PersonOfficialBusinessMeta.DEFAULT_PROCESS));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(PersonOfficialBusinessMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonOfficialBusinessMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonOfficialBusinessMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(PersonOfficialBusinessMeta.CONTENT)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(PersonOfficialBusinessMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonOfficialBusinessMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonOfficialBusinessMeta.DELETED)));
			this.setMoney(DataParser.parse(BigDecimal.class, r.getValue(PersonOfficialBusinessMeta.MONEY)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonOfficialBusinessMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonOfficialBusinessMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonOfficialBusinessMeta.DELETE_TIME)));
			this.setLeaveDate(DataParser.parse(Date.class, r.getValue(PersonOfficialBusinessMeta.LEAVE_DATE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonOfficialBusinessMeta.TENANT_ID)));
			this.setDays(DataParser.parse(BigDecimal.class, r.getValue(PersonOfficialBusinessMeta.DAYS)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonOfficialBusinessMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(PersonOfficialBusinessMeta.PERSON_ID)));
			this.setLocation(DataParser.parse(String.class, r.getValue(PersonOfficialBusinessMeta.LOCATION)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonOfficialBusinessMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonOfficialBusinessMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(PersonOfficialBusinessMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(PersonOfficialBusinessMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PersonOfficialBusinessMeta.VERSION));
				this.setContent( (String)r.getValue(PersonOfficialBusinessMeta.CONTENT));
				this.setBusinessCode( (String)r.getValue(PersonOfficialBusinessMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(PersonOfficialBusinessMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonOfficialBusinessMeta.DELETED));
				this.setMoney( (BigDecimal)r.getValue(PersonOfficialBusinessMeta.MONEY));
				this.setCreateTime( (Date)r.getValue(PersonOfficialBusinessMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonOfficialBusinessMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonOfficialBusinessMeta.DELETE_TIME));
				this.setLeaveDate( (Date)r.getValue(PersonOfficialBusinessMeta.LEAVE_DATE));
				this.setTenantId( (String)r.getValue(PersonOfficialBusinessMeta.TENANT_ID));
				this.setDays( (BigDecimal)r.getValue(PersonOfficialBusinessMeta.DAYS));
				this.setDeleteBy( (String)r.getValue(PersonOfficialBusinessMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(PersonOfficialBusinessMeta.PERSON_ID));
				this.setLocation( (String)r.getValue(PersonOfficialBusinessMeta.LOCATION));
				this.setId( (String)r.getValue(PersonOfficialBusinessMeta.ID));
				this.setStatus( (String)r.getValue(PersonOfficialBusinessMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}