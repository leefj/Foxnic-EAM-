package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_CRM_CUSTOMER_REVIEW;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.oa.meta.CrmCustomerReviewMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 回访
 * <p>回访 , 数据表 oa_crm_customer_review 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-09-16 22:52:01
 * @sign AD71533C5BD1C98CB7C304E40F581211
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_crm_customer_review")
@ApiModel(description = "回访 ; 回访 , 数据表 oa_crm_customer_review 的PO类型")
public class CrmCustomerReview extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_CRM_CUSTOMER_REVIEW.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "754655516394782720")
	private String id;
	
	/**
	 * 客户：客户
	*/
	@ApiModelProperty(required = false,value="客户" , notes = "客户" , example = "754655093655076864")
	private String customerId;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "12")
	private String name;
	
	/**
	 * 回访人：回访人
	*/
	@ApiModelProperty(required = false,value="回访人" , notes = "回访人" , example = "581798649571311616")
	private String reviewUserId;
	
	/**
	 * 回访时间：回访时间
	*/
	@ApiModelProperty(required = false,value="回访时间" , notes = "回访时间" , example = "2023-09-19 12:00:00")
	private Date reviewDate;
	
	/**
	 * 回访形式：回访形式
	*/
	@ApiModelProperty(required = false,value="回访形式" , notes = "回访形式" , example = "other")
	private String methodId;
	
	/**
	 * 客户满意度：客户满意度
	*/
	@ApiModelProperty(required = false,value="客户满意度" , notes = "客户满意度" , example = "general_satisfaction")
	private String satisfactionId;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String fileId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "1212")
	private String notes;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = true,value="版本" , notes = "版本" , example = "2")
	private Integer version;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-09-14 10:51:36")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-09-14 04:43:50")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * crmCustomer：crmCustomer
	*/
	@ApiModelProperty(required = false,value="crmCustomer" , notes = "crmCustomer")
	private CrmCustomer crmCustomer;
	
	/**
	 * originator：originator
	*/
	@ApiModelProperty(required = false,value="originator" , notes = "originator")
	private Employee originator;
	
	/**
	 * reviewUser：reviewUser
	*/
	@ApiModelProperty(required = false,value="reviewUser" , notes = "reviewUser")
	private Employee reviewUser;
	
	/**
	 * reviewMethod：reviewMethod
	*/
	@ApiModelProperty(required = false,value="reviewMethod" , notes = "reviewMethod")
	private DictItem reviewMethod;
	
	/**
	 * satisfaction：satisfaction
	*/
	@ApiModelProperty(required = false,value="satisfaction" , notes = "satisfaction")
	private DictItem satisfaction;
	
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
	public CrmCustomerReview setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 客户<br>
	 * 客户
	 * @return 客户
	*/
	public String getCustomerId() {
		return customerId;
	}
	
	/**
	 * 设置 客户
	 * @param customerId 客户
	 * @return 当前对象
	*/
	public CrmCustomerReview setCustomerId(String customerId) {
		this.customerId=customerId;
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
	public CrmCustomerReview setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 回访人<br>
	 * 回访人
	 * @return 回访人
	*/
	public String getReviewUserId() {
		return reviewUserId;
	}
	
	/**
	 * 设置 回访人
	 * @param reviewUserId 回访人
	 * @return 当前对象
	*/
	public CrmCustomerReview setReviewUserId(String reviewUserId) {
		this.reviewUserId=reviewUserId;
		return this;
	}
	
	/**
	 * 获得 回访时间<br>
	 * 回访时间
	 * @return 回访时间
	*/
	public Date getReviewDate() {
		return reviewDate;
	}
	
	/**
	 * 设置 回访时间
	 * @param reviewDate 回访时间
	 * @return 当前对象
	*/
	public CrmCustomerReview setReviewDate(Date reviewDate) {
		this.reviewDate=reviewDate;
		return this;
	}
	
	/**
	 * 获得 回访形式<br>
	 * 回访形式
	 * @return 回访形式
	*/
	public String getMethodId() {
		return methodId;
	}
	
	/**
	 * 设置 回访形式
	 * @param methodId 回访形式
	 * @return 当前对象
	*/
	public CrmCustomerReview setMethodId(String methodId) {
		this.methodId=methodId;
		return this;
	}
	
	/**
	 * 获得 客户满意度<br>
	 * 客户满意度
	 * @return 客户满意度
	*/
	public String getSatisfactionId() {
		return satisfactionId;
	}
	
	/**
	 * 设置 客户满意度
	 * @param satisfactionId 客户满意度
	 * @return 当前对象
	*/
	public CrmCustomerReview setSatisfactionId(String satisfactionId) {
		this.satisfactionId=satisfactionId;
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
	public CrmCustomerReview setFileId(String fileId) {
		this.fileId=fileId;
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
	public CrmCustomerReview setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public String getOriginatorId() {
		return originatorId;
	}
	
	/**
	 * 设置 制单人
	 * @param originatorId 制单人
	 * @return 当前对象
	*/
	public CrmCustomerReview setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 版本
	 * @param version 版本
	 * @return 当前对象
	*/
	public CrmCustomerReview setVersion(Integer version) {
		this.version=version;
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
	public CrmCustomerReview setCreateBy(String createBy) {
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
	public CrmCustomerReview setCreateTime(Date createTime) {
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
	public CrmCustomerReview setUpdateBy(String updateBy) {
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
	public CrmCustomerReview setUpdateTime(Date updateTime) {
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
	public CrmCustomerReview setDeleted(Integer deleted) {
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
	public CrmCustomerReview setDeleted(Boolean deletedBool) {
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
	public CrmCustomerReview setDeleteBy(String deleteBy) {
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
	public CrmCustomerReview setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public CrmCustomerReview setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 crmCustomer<br>
	 * crmCustomer
	 * @return crmCustomer
	*/
	public CrmCustomer getCrmCustomer() {
		return crmCustomer;
	}
	
	/**
	 * 设置 crmCustomer
	 * @param crmCustomer crmCustomer
	 * @return 当前对象
	*/
	public CrmCustomerReview setCrmCustomer(CrmCustomer crmCustomer) {
		this.crmCustomer=crmCustomer;
		return this;
	}
	
	/**
	 * 获得 originator<br>
	 * originator
	 * @return originator
	*/
	public Employee getOriginator() {
		return originator;
	}
	
	/**
	 * 设置 originator
	 * @param originator originator
	 * @return 当前对象
	*/
	public CrmCustomerReview setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 reviewUser<br>
	 * reviewUser
	 * @return reviewUser
	*/
	public Employee getReviewUser() {
		return reviewUser;
	}
	
	/**
	 * 设置 reviewUser
	 * @param reviewUser reviewUser
	 * @return 当前对象
	*/
	public CrmCustomerReview setReviewUser(Employee reviewUser) {
		this.reviewUser=reviewUser;
		return this;
	}
	
	/**
	 * 获得 reviewMethod<br>
	 * reviewMethod
	 * @return reviewMethod
	*/
	public DictItem getReviewMethod() {
		return reviewMethod;
	}
	
	/**
	 * 设置 reviewMethod
	 * @param reviewMethod reviewMethod
	 * @return 当前对象
	*/
	public CrmCustomerReview setReviewMethod(DictItem reviewMethod) {
		this.reviewMethod=reviewMethod;
		return this;
	}
	
	/**
	 * 获得 satisfaction<br>
	 * satisfaction
	 * @return satisfaction
	*/
	public DictItem getSatisfaction() {
		return satisfaction;
	}
	
	/**
	 * 设置 satisfaction
	 * @param satisfaction satisfaction
	 * @return 当前对象
	*/
	public CrmCustomerReview setSatisfaction(DictItem satisfaction) {
		this.satisfaction=satisfaction;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CrmCustomerReview , 转换好的 CrmCustomerReview 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CrmCustomerReview , 转换好的 PoJo 对象
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
	public CrmCustomerReview clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CrmCustomerReview duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.CrmCustomerReviewMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.CrmCustomerReviewMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setMethodId(this.getMethodId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setReviewUserId(this.getReviewUserId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setReviewDate(this.getReviewDate());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setCustomerId(this.getCustomerId());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setSatisfactionId(this.getSatisfactionId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setFileId(this.getFileId());
		if(all) {
			inst.setReviewMethod(this.getReviewMethod());
			inst.setCrmCustomer(this.getCrmCustomer());
			inst.setReviewUser(this.getReviewUser());
			inst.setOriginator(this.getOriginator());
			inst.setSatisfaction(this.getSatisfaction());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CrmCustomerReview clone(boolean deep) {
		return EntityContext.clone(CrmCustomerReview.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CrmCustomerReview
	 * @param crmCustomerReviewMap 包含实体信息的 Map 对象
	 * @return CrmCustomerReview , 转换好的的 CrmCustomerReview 对象
	*/
	@Transient
	public static CrmCustomerReview createFrom(Map<String,Object> crmCustomerReviewMap) {
		if(crmCustomerReviewMap==null) return null;
		CrmCustomerReview po = create();
		EntityContext.copyProperties(po,crmCustomerReviewMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CrmCustomerReview
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CrmCustomerReview , 转换好的的 CrmCustomerReview 对象
	*/
	@Transient
	public static CrmCustomerReview createFrom(Object pojo) {
		if(pojo==null) return null;
		CrmCustomerReview po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CrmCustomerReview，等同于 new
	 * @return CrmCustomerReview 对象
	*/
	@Transient
	public static CrmCustomerReview create() {
		return new com.dt.platform.domain.oa.meta.CrmCustomerReviewMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(CrmCustomerReviewMeta.NOTES)));
			this.setMethodId(DataParser.parse(String.class, map.get(CrmCustomerReviewMeta.METHOD_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CrmCustomerReviewMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CrmCustomerReviewMeta.VERSION)));
			this.setReviewUserId(DataParser.parse(String.class, map.get(CrmCustomerReviewMeta.REVIEW_USER_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CrmCustomerReviewMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CrmCustomerReviewMeta.DELETED)));
			this.setReviewDate(DataParser.parse(Date.class, map.get(CrmCustomerReviewMeta.REVIEW_DATE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CrmCustomerReviewMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CrmCustomerReviewMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CrmCustomerReviewMeta.DELETE_TIME)));
			this.setCustomerId(DataParser.parse(String.class, map.get(CrmCustomerReviewMeta.CUSTOMER_ID)));
			this.setName(DataParser.parse(String.class, map.get(CrmCustomerReviewMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(CrmCustomerReviewMeta.TENANT_ID)));
			this.setSatisfactionId(DataParser.parse(String.class, map.get(CrmCustomerReviewMeta.SATISFACTION_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CrmCustomerReviewMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CrmCustomerReviewMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(CrmCustomerReviewMeta.ORIGINATOR_ID)));
			this.setFileId(DataParser.parse(String.class, map.get(CrmCustomerReviewMeta.FILE_ID)));
			// others
			this.setReviewMethod(DataParser.parse(DictItem.class, map.get(CrmCustomerReviewMeta.REVIEW_METHOD)));
			this.setCrmCustomer(DataParser.parse(CrmCustomer.class, map.get(CrmCustomerReviewMeta.CRM_CUSTOMER)));
			this.setReviewUser(DataParser.parse(Employee.class, map.get(CrmCustomerReviewMeta.REVIEW_USER)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(CrmCustomerReviewMeta.ORIGINATOR)));
			this.setSatisfaction(DataParser.parse(DictItem.class, map.get(CrmCustomerReviewMeta.SATISFACTION)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(CrmCustomerReviewMeta.NOTES));
				this.setMethodId( (String)map.get(CrmCustomerReviewMeta.METHOD_ID));
				this.setUpdateTime( (Date)map.get(CrmCustomerReviewMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(CrmCustomerReviewMeta.VERSION));
				this.setReviewUserId( (String)map.get(CrmCustomerReviewMeta.REVIEW_USER_ID));
				this.setCreateBy( (String)map.get(CrmCustomerReviewMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CrmCustomerReviewMeta.DELETED));
				this.setReviewDate( (Date)map.get(CrmCustomerReviewMeta.REVIEW_DATE));
				this.setCreateTime( (Date)map.get(CrmCustomerReviewMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CrmCustomerReviewMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CrmCustomerReviewMeta.DELETE_TIME));
				this.setCustomerId( (String)map.get(CrmCustomerReviewMeta.CUSTOMER_ID));
				this.setName( (String)map.get(CrmCustomerReviewMeta.NAME));
				this.setTenantId( (String)map.get(CrmCustomerReviewMeta.TENANT_ID));
				this.setSatisfactionId( (String)map.get(CrmCustomerReviewMeta.SATISFACTION_ID));
				this.setDeleteBy( (String)map.get(CrmCustomerReviewMeta.DELETE_BY));
				this.setId( (String)map.get(CrmCustomerReviewMeta.ID));
				this.setOriginatorId( (String)map.get(CrmCustomerReviewMeta.ORIGINATOR_ID));
				this.setFileId( (String)map.get(CrmCustomerReviewMeta.FILE_ID));
				// others
				this.setReviewMethod( (DictItem)map.get(CrmCustomerReviewMeta.REVIEW_METHOD));
				this.setCrmCustomer( (CrmCustomer)map.get(CrmCustomerReviewMeta.CRM_CUSTOMER));
				this.setReviewUser( (Employee)map.get(CrmCustomerReviewMeta.REVIEW_USER));
				this.setOriginator( (Employee)map.get(CrmCustomerReviewMeta.ORIGINATOR));
				this.setSatisfaction( (DictItem)map.get(CrmCustomerReviewMeta.SATISFACTION));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(CrmCustomerReviewMeta.NOTES)));
			this.setMethodId(DataParser.parse(String.class, r.getValue(CrmCustomerReviewMeta.METHOD_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CrmCustomerReviewMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CrmCustomerReviewMeta.VERSION)));
			this.setReviewUserId(DataParser.parse(String.class, r.getValue(CrmCustomerReviewMeta.REVIEW_USER_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CrmCustomerReviewMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CrmCustomerReviewMeta.DELETED)));
			this.setReviewDate(DataParser.parse(Date.class, r.getValue(CrmCustomerReviewMeta.REVIEW_DATE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CrmCustomerReviewMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CrmCustomerReviewMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CrmCustomerReviewMeta.DELETE_TIME)));
			this.setCustomerId(DataParser.parse(String.class, r.getValue(CrmCustomerReviewMeta.CUSTOMER_ID)));
			this.setName(DataParser.parse(String.class, r.getValue(CrmCustomerReviewMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CrmCustomerReviewMeta.TENANT_ID)));
			this.setSatisfactionId(DataParser.parse(String.class, r.getValue(CrmCustomerReviewMeta.SATISFACTION_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CrmCustomerReviewMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CrmCustomerReviewMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(CrmCustomerReviewMeta.ORIGINATOR_ID)));
			this.setFileId(DataParser.parse(String.class, r.getValue(CrmCustomerReviewMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(CrmCustomerReviewMeta.NOTES));
				this.setMethodId( (String)r.getValue(CrmCustomerReviewMeta.METHOD_ID));
				this.setUpdateTime( (Date)r.getValue(CrmCustomerReviewMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(CrmCustomerReviewMeta.VERSION));
				this.setReviewUserId( (String)r.getValue(CrmCustomerReviewMeta.REVIEW_USER_ID));
				this.setCreateBy( (String)r.getValue(CrmCustomerReviewMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CrmCustomerReviewMeta.DELETED));
				this.setReviewDate( (Date)r.getValue(CrmCustomerReviewMeta.REVIEW_DATE));
				this.setCreateTime( (Date)r.getValue(CrmCustomerReviewMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CrmCustomerReviewMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CrmCustomerReviewMeta.DELETE_TIME));
				this.setCustomerId( (String)r.getValue(CrmCustomerReviewMeta.CUSTOMER_ID));
				this.setName( (String)r.getValue(CrmCustomerReviewMeta.NAME));
				this.setTenantId( (String)r.getValue(CrmCustomerReviewMeta.TENANT_ID));
				this.setSatisfactionId( (String)r.getValue(CrmCustomerReviewMeta.SATISFACTION_ID));
				this.setDeleteBy( (String)r.getValue(CrmCustomerReviewMeta.DELETE_BY));
				this.setId( (String)r.getValue(CrmCustomerReviewMeta.ID));
				this.setOriginatorId( (String)r.getValue(CrmCustomerReviewMeta.ORIGINATOR_ID));
				this.setFileId( (String)r.getValue(CrmCustomerReviewMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}