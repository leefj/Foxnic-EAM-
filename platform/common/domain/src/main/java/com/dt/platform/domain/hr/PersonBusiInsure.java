package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_BUSI_INSURE;
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
import com.dt.platform.domain.hr.meta.PersonBusiInsureMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 商业保险
 * <p>商业保险 , 数据表 hr_person_busi_insure 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-08 08:52:37
 * @sign 79EF666795C2DD537A7B022D1B937AA2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_busi_insure")
@ApiModel(description = "商业保险 ; 商业保险 , 数据表 hr_person_busi_insure 的PO类型")
public class PersonBusiInsure extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_BUSI_INSURE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "807651759542501376")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 姓名：姓名
	*/
	@ApiModelProperty(required = false,value="姓名" , notes = "姓名" , example = "801825620114800641")
	private String personId;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型" , example = "tb")
	private String typeCode;
	
	/**
	 * 保险单号：保险单号
	*/
	@ApiModelProperty(required = false,value="保险单号" , notes = "保险单号" , example = "1234561111")
	private String billCode;
	
	/**
	 * 登记时间：登记时间
	*/
	@ApiModelProperty(required = false,value="登记时间" , notes = "登记时间" , example = "2023-02-08 12:00:00")
	private Date rcdTime;
	
	/**
	 * 保险金额：保险金额
	*/
	@ApiModelProperty(required = false,value="保险金额" , notes = "保险金额" , example = "5.00")
	private BigDecimal pay;
	
	/**
	 * 个人支付：个人支付
	*/
	@ApiModelProperty(required = false,value="个人支付" , notes = "个人支付" , example = "1.00")
	private BigDecimal personPay;
	
	/**
	 * 公司支付：公司支付
	*/
	@ApiModelProperty(required = false,value="公司支付" , notes = "公司支付" , example = "2.00")
	private BigDecimal companyPay;
	
	/**
	 * 生效时间：生效时间
	*/
	@ApiModelProperty(required = false,value="生效时间" , notes = "生效时间" , example = "2023-02-21 12:00:00")
	private Date startTime;
	
	/**
	 * 失效时间：失效时间
	*/
	@ApiModelProperty(required = false,value="失效时间" , notes = "失效时间" , example = "2023-01-30 12:00:00")
	private Date endTime;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String fileIds;
	
	/**
	 * 批次号：批次号
	*/
	@ApiModelProperty(required = false,value="批次号" , notes = "批次号")
	private String batchCode;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "abc")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-07 04:39:45")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-02-08 08:49:42")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "4")
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
	 * personBusiInsureType：personBusiInsureType
	*/
	@ApiModelProperty(required = false,value="personBusiInsureType" , notes = "personBusiInsureType")
	private PersonBusiInsureType personBusiInsureType;
	
	/**
	 * personJobNumber：personJobNumber
	*/
	@ApiModelProperty(required = false,value="personJobNumber" , notes = "personJobNumber")
	private String personJobNumber;
	
	/**
	 * personCardNumber：personCardNumber
	*/
	@ApiModelProperty(required = false,value="personCardNumber" , notes = "personCardNumber")
	private String personCardNumber;
	
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
	public PersonBusiInsure setId(String id) {
		this.id=id;
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
	public PersonBusiInsure setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 姓名<br>
	 * 姓名
	 * @return 姓名
	*/
	public String getPersonId() {
		return personId;
	}
	
	/**
	 * 设置 姓名
	 * @param personId 姓名
	 * @return 当前对象
	*/
	public PersonBusiInsure setPersonId(String personId) {
		this.personId=personId;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getTypeCode() {
		return typeCode;
	}
	
	/**
	 * 设置 类型
	 * @param typeCode 类型
	 * @return 当前对象
	*/
	public PersonBusiInsure setTypeCode(String typeCode) {
		this.typeCode=typeCode;
		return this;
	}
	
	/**
	 * 获得 保险单号<br>
	 * 保险单号
	 * @return 保险单号
	*/
	public String getBillCode() {
		return billCode;
	}
	
	/**
	 * 设置 保险单号
	 * @param billCode 保险单号
	 * @return 当前对象
	*/
	public PersonBusiInsure setBillCode(String billCode) {
		this.billCode=billCode;
		return this;
	}
	
	/**
	 * 获得 登记时间<br>
	 * 登记时间
	 * @return 登记时间
	*/
	public Date getRcdTime() {
		return rcdTime;
	}
	
	/**
	 * 设置 登记时间
	 * @param rcdTime 登记时间
	 * @return 当前对象
	*/
	public PersonBusiInsure setRcdTime(Date rcdTime) {
		this.rcdTime=rcdTime;
		return this;
	}
	
	/**
	 * 获得 保险金额<br>
	 * 保险金额
	 * @return 保险金额
	*/
	public BigDecimal getPay() {
		return pay;
	}
	
	/**
	 * 设置 保险金额
	 * @param pay 保险金额
	 * @return 当前对象
	*/
	public PersonBusiInsure setPay(BigDecimal pay) {
		this.pay=pay;
		return this;
	}
	
	/**
	 * 获得 个人支付<br>
	 * 个人支付
	 * @return 个人支付
	*/
	public BigDecimal getPersonPay() {
		return personPay;
	}
	
	/**
	 * 设置 个人支付
	 * @param personPay 个人支付
	 * @return 当前对象
	*/
	public PersonBusiInsure setPersonPay(BigDecimal personPay) {
		this.personPay=personPay;
		return this;
	}
	
	/**
	 * 获得 公司支付<br>
	 * 公司支付
	 * @return 公司支付
	*/
	public BigDecimal getCompanyPay() {
		return companyPay;
	}
	
	/**
	 * 设置 公司支付
	 * @param companyPay 公司支付
	 * @return 当前对象
	*/
	public PersonBusiInsure setCompanyPay(BigDecimal companyPay) {
		this.companyPay=companyPay;
		return this;
	}
	
	/**
	 * 获得 生效时间<br>
	 * 生效时间
	 * @return 生效时间
	*/
	public Date getStartTime() {
		return startTime;
	}
	
	/**
	 * 设置 生效时间
	 * @param startTime 生效时间
	 * @return 当前对象
	*/
	public PersonBusiInsure setStartTime(Date startTime) {
		this.startTime=startTime;
		return this;
	}
	
	/**
	 * 获得 失效时间<br>
	 * 失效时间
	 * @return 失效时间
	*/
	public Date getEndTime() {
		return endTime;
	}
	
	/**
	 * 设置 失效时间
	 * @param endTime 失效时间
	 * @return 当前对象
	*/
	public PersonBusiInsure setEndTime(Date endTime) {
		this.endTime=endTime;
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
	public PersonBusiInsure setFileIds(String fileIds) {
		this.fileIds=fileIds;
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
	public PersonBusiInsure setBatchCode(String batchCode) {
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
	public PersonBusiInsure setNotes(String notes) {
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
	public PersonBusiInsure setCreateBy(String createBy) {
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
	public PersonBusiInsure setCreateTime(Date createTime) {
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
	public PersonBusiInsure setUpdateBy(String updateBy) {
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
	public PersonBusiInsure setUpdateTime(Date updateTime) {
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
	public PersonBusiInsure setDeleted(Integer deleted) {
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
	public PersonBusiInsure setDeleted(Boolean deletedBool) {
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
	public PersonBusiInsure setDeleteBy(String deleteBy) {
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
	public PersonBusiInsure setDeleteTime(Date deleteTime) {
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
	public PersonBusiInsure setVersion(Integer version) {
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
	public PersonBusiInsure setTenantId(String tenantId) {
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
	public PersonBusiInsure setPerson(Person person) {
		this.person=person;
		return this;
	}
	
	/**
	 * 获得 personBusiInsureType<br>
	 * personBusiInsureType
	 * @return personBusiInsureType
	*/
	public PersonBusiInsureType getPersonBusiInsureType() {
		return personBusiInsureType;
	}
	
	/**
	 * 设置 personBusiInsureType
	 * @param personBusiInsureType personBusiInsureType
	 * @return 当前对象
	*/
	public PersonBusiInsure setPersonBusiInsureType(PersonBusiInsureType personBusiInsureType) {
		this.personBusiInsureType=personBusiInsureType;
		return this;
	}
	
	/**
	 * 获得 personJobNumber<br>
	 * personJobNumber
	 * @return personJobNumber
	*/
	public String getPersonJobNumber() {
		return personJobNumber;
	}
	
	/**
	 * 设置 personJobNumber
	 * @param personJobNumber personJobNumber
	 * @return 当前对象
	*/
	public PersonBusiInsure setPersonJobNumber(String personJobNumber) {
		this.personJobNumber=personJobNumber;
		return this;
	}
	
	/**
	 * 获得 personCardNumber<br>
	 * personCardNumber
	 * @return personCardNumber
	*/
	public String getPersonCardNumber() {
		return personCardNumber;
	}
	
	/**
	 * 设置 personCardNumber
	 * @param personCardNumber personCardNumber
	 * @return 当前对象
	*/
	public PersonBusiInsure setPersonCardNumber(String personCardNumber) {
		this.personCardNumber=personCardNumber;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonBusiInsure , 转换好的 PersonBusiInsure 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonBusiInsure , 转换好的 PoJo 对象
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
	public PersonBusiInsure clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonBusiInsure duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonBusiInsureMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonBusiInsureMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setBatchCode(this.getBatchCode());
		inst.setPay(this.getPay());
		inst.setPersonPay(this.getPersonPay());
		inst.setBillCode(this.getBillCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setTypeCode(this.getTypeCode());
		inst.setCompanyPay(this.getCompanyPay());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setFileIds(this.getFileIds());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setStartTime(this.getStartTime());
		inst.setId(this.getId());
		inst.setEndTime(this.getEndTime());
		inst.setRcdTime(this.getRcdTime());
		if(all) {
			inst.setPersonBusiInsureType(this.getPersonBusiInsureType());
			inst.setPerson(this.getPerson());
			inst.setPersonCardNumber(this.getPersonCardNumber());
			inst.setPersonJobNumber(this.getPersonJobNumber());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonBusiInsure clone(boolean deep) {
		return EntityContext.clone(PersonBusiInsure.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonBusiInsure
	 * @param personBusiInsureMap 包含实体信息的 Map 对象
	 * @return PersonBusiInsure , 转换好的的 PersonBusiInsure 对象
	*/
	@Transient
	public static PersonBusiInsure createFrom(Map<String,Object> personBusiInsureMap) {
		if(personBusiInsureMap==null) return null;
		PersonBusiInsure po = create();
		EntityContext.copyProperties(po,personBusiInsureMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonBusiInsure
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonBusiInsure , 转换好的的 PersonBusiInsure 对象
	*/
	@Transient
	public static PersonBusiInsure createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonBusiInsure po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonBusiInsure，等同于 new
	 * @return PersonBusiInsure 对象
	*/
	@Transient
	public static PersonBusiInsure create() {
		return new com.dt.platform.domain.hr.meta.PersonBusiInsureMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(PersonBusiInsureMeta.NOTES)));
			this.setBatchCode(DataParser.parse(String.class, map.get(PersonBusiInsureMeta.BATCH_CODE)));
			this.setPay(DataParser.parse(BigDecimal.class, map.get(PersonBusiInsureMeta.PAY)));
			this.setPersonPay(DataParser.parse(BigDecimal.class, map.get(PersonBusiInsureMeta.PERSON_PAY)));
			this.setBillCode(DataParser.parse(String.class, map.get(PersonBusiInsureMeta.BILL_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonBusiInsureMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonBusiInsureMeta.VERSION)));
			this.setTypeCode(DataParser.parse(String.class, map.get(PersonBusiInsureMeta.TYPE_CODE)));
			this.setCompanyPay(DataParser.parse(BigDecimal.class, map.get(PersonBusiInsureMeta.COMPANY_PAY)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonBusiInsureMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonBusiInsureMeta.DELETED)));
			this.setFileIds(DataParser.parse(String.class, map.get(PersonBusiInsureMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonBusiInsureMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonBusiInsureMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonBusiInsureMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(PersonBusiInsureMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonBusiInsureMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonBusiInsureMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(PersonBusiInsureMeta.PERSON_ID)));
			this.setStartTime(DataParser.parse(Date.class, map.get(PersonBusiInsureMeta.START_TIME)));
			this.setId(DataParser.parse(String.class, map.get(PersonBusiInsureMeta.ID)));
			this.setEndTime(DataParser.parse(Date.class, map.get(PersonBusiInsureMeta.END_TIME)));
			this.setRcdTime(DataParser.parse(Date.class, map.get(PersonBusiInsureMeta.RCD_TIME)));
			// others
			this.setPersonBusiInsureType(DataParser.parse(PersonBusiInsureType.class, map.get(PersonBusiInsureMeta.PERSON_BUSI_INSURE_TYPE)));
			this.setPerson(DataParser.parse(Person.class, map.get(PersonBusiInsureMeta.PERSON)));
			this.setPersonCardNumber(DataParser.parse(String.class, map.get(PersonBusiInsureMeta.PERSON_CARD_NUMBER)));
			this.setPersonJobNumber(DataParser.parse(String.class, map.get(PersonBusiInsureMeta.PERSON_JOB_NUMBER)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(PersonBusiInsureMeta.NOTES));
				this.setBatchCode( (String)map.get(PersonBusiInsureMeta.BATCH_CODE));
				this.setPay( (BigDecimal)map.get(PersonBusiInsureMeta.PAY));
				this.setPersonPay( (BigDecimal)map.get(PersonBusiInsureMeta.PERSON_PAY));
				this.setBillCode( (String)map.get(PersonBusiInsureMeta.BILL_CODE));
				this.setUpdateTime( (Date)map.get(PersonBusiInsureMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PersonBusiInsureMeta.VERSION));
				this.setTypeCode( (String)map.get(PersonBusiInsureMeta.TYPE_CODE));
				this.setCompanyPay( (BigDecimal)map.get(PersonBusiInsureMeta.COMPANY_PAY));
				this.setCreateBy( (String)map.get(PersonBusiInsureMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonBusiInsureMeta.DELETED));
				this.setFileIds( (String)map.get(PersonBusiInsureMeta.FILE_IDS));
				this.setCreateTime( (Date)map.get(PersonBusiInsureMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonBusiInsureMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonBusiInsureMeta.DELETE_TIME));
				this.setName( (String)map.get(PersonBusiInsureMeta.NAME));
				this.setTenantId( (String)map.get(PersonBusiInsureMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonBusiInsureMeta.DELETE_BY));
				this.setPersonId( (String)map.get(PersonBusiInsureMeta.PERSON_ID));
				this.setStartTime( (Date)map.get(PersonBusiInsureMeta.START_TIME));
				this.setId( (String)map.get(PersonBusiInsureMeta.ID));
				this.setEndTime( (Date)map.get(PersonBusiInsureMeta.END_TIME));
				this.setRcdTime( (Date)map.get(PersonBusiInsureMeta.RCD_TIME));
				// others
				this.setPersonBusiInsureType( (PersonBusiInsureType)map.get(PersonBusiInsureMeta.PERSON_BUSI_INSURE_TYPE));
				this.setPerson( (Person)map.get(PersonBusiInsureMeta.PERSON));
				this.setPersonCardNumber( (String)map.get(PersonBusiInsureMeta.PERSON_CARD_NUMBER));
				this.setPersonJobNumber( (String)map.get(PersonBusiInsureMeta.PERSON_JOB_NUMBER));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(PersonBusiInsureMeta.NOTES)));
			this.setBatchCode(DataParser.parse(String.class, r.getValue(PersonBusiInsureMeta.BATCH_CODE)));
			this.setPay(DataParser.parse(BigDecimal.class, r.getValue(PersonBusiInsureMeta.PAY)));
			this.setPersonPay(DataParser.parse(BigDecimal.class, r.getValue(PersonBusiInsureMeta.PERSON_PAY)));
			this.setBillCode(DataParser.parse(String.class, r.getValue(PersonBusiInsureMeta.BILL_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonBusiInsureMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonBusiInsureMeta.VERSION)));
			this.setTypeCode(DataParser.parse(String.class, r.getValue(PersonBusiInsureMeta.TYPE_CODE)));
			this.setCompanyPay(DataParser.parse(BigDecimal.class, r.getValue(PersonBusiInsureMeta.COMPANY_PAY)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonBusiInsureMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonBusiInsureMeta.DELETED)));
			this.setFileIds(DataParser.parse(String.class, r.getValue(PersonBusiInsureMeta.FILE_IDS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonBusiInsureMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonBusiInsureMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonBusiInsureMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(PersonBusiInsureMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonBusiInsureMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonBusiInsureMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(PersonBusiInsureMeta.PERSON_ID)));
			this.setStartTime(DataParser.parse(Date.class, r.getValue(PersonBusiInsureMeta.START_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonBusiInsureMeta.ID)));
			this.setEndTime(DataParser.parse(Date.class, r.getValue(PersonBusiInsureMeta.END_TIME)));
			this.setRcdTime(DataParser.parse(Date.class, r.getValue(PersonBusiInsureMeta.RCD_TIME)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(PersonBusiInsureMeta.NOTES));
				this.setBatchCode( (String)r.getValue(PersonBusiInsureMeta.BATCH_CODE));
				this.setPay( (BigDecimal)r.getValue(PersonBusiInsureMeta.PAY));
				this.setPersonPay( (BigDecimal)r.getValue(PersonBusiInsureMeta.PERSON_PAY));
				this.setBillCode( (String)r.getValue(PersonBusiInsureMeta.BILL_CODE));
				this.setUpdateTime( (Date)r.getValue(PersonBusiInsureMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PersonBusiInsureMeta.VERSION));
				this.setTypeCode( (String)r.getValue(PersonBusiInsureMeta.TYPE_CODE));
				this.setCompanyPay( (BigDecimal)r.getValue(PersonBusiInsureMeta.COMPANY_PAY));
				this.setCreateBy( (String)r.getValue(PersonBusiInsureMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonBusiInsureMeta.DELETED));
				this.setFileIds( (String)r.getValue(PersonBusiInsureMeta.FILE_IDS));
				this.setCreateTime( (Date)r.getValue(PersonBusiInsureMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonBusiInsureMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonBusiInsureMeta.DELETE_TIME));
				this.setName( (String)r.getValue(PersonBusiInsureMeta.NAME));
				this.setTenantId( (String)r.getValue(PersonBusiInsureMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonBusiInsureMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(PersonBusiInsureMeta.PERSON_ID));
				this.setStartTime( (Date)r.getValue(PersonBusiInsureMeta.START_TIME));
				this.setId( (String)r.getValue(PersonBusiInsureMeta.ID));
				this.setEndTime( (Date)r.getValue(PersonBusiInsureMeta.END_TIME));
				this.setRcdTime( (Date)r.getValue(PersonBusiInsureMeta.RCD_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}