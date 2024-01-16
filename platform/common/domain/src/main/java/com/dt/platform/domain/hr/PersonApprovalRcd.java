package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_APPROVAL_RCD;
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
import com.dt.platform.domain.hr.meta.PersonApprovalRcdMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 审批记录
 * <p>审批记录 , 数据表 hr_person_approval_rcd 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-15 19:14:44
 * @sign 0F6EEAAE70267A397082C0C3CC0AD9C1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_approval_rcd")
@ApiModel(description = "审批记录 ; 审批记录 , 数据表 hr_person_approval_rcd 的PO类型")
public class PersonApprovalRcd extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_APPROVAL_RCD.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "799327854008467456")
	private String id;
	
	/**
	 * 信息：信息
	*/
	@ApiModelProperty(required = false,value="信息" , notes = "信息")
	private String pid;
	
	/**
	 * 结果：结果
	*/
	@ApiModelProperty(required = false,value="结果" , notes = "结果" , example = "agree")
	private String result;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容" , example = "1212121")
	private String content;
	
	/**
	 * 操作人员：操作人员
	*/
	@ApiModelProperty(required = false,value="操作人员" , notes = "操作人员")
	private String operUserId;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private String type;
	
	/**
	 * 操作时间：操作时间
	*/
	@ApiModelProperty(required = false,value="操作时间" , notes = "操作时间")
	private Date operTime;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-01-15 05:23:31")
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
	 * operUser：operUser
	*/
	@ApiModelProperty(required = false,value="operUser" , notes = "operUser")
	private Employee operUser;
	
	/**
	 * itemIds：itemIds
	*/
	@ApiModelProperty(required = false,value="itemIds" , notes = "itemIds")
	private List<String> itemIds;
	
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
	public PersonApprovalRcd setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 信息<br>
	 * 信息
	 * @return 信息
	*/
	public String getPid() {
		return pid;
	}
	
	/**
	 * 设置 信息
	 * @param pid 信息
	 * @return 当前对象
	*/
	public PersonApprovalRcd setPid(String pid) {
		this.pid=pid;
		return this;
	}
	
	/**
	 * 获得 结果<br>
	 * 结果
	 * @return 结果
	*/
	public String getResult() {
		return result;
	}
	
	/**
	 * 设置 结果
	 * @param result 结果
	 * @return 当前对象
	*/
	public PersonApprovalRcd setResult(String result) {
		this.result=result;
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
	public PersonApprovalRcd setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 操作人员<br>
	 * 操作人员
	 * @return 操作人员
	*/
	public String getOperUserId() {
		return operUserId;
	}
	
	/**
	 * 设置 操作人员
	 * @param operUserId 操作人员
	 * @return 当前对象
	*/
	public PersonApprovalRcd setOperUserId(String operUserId) {
		this.operUserId=operUserId;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public PersonApprovalRcd setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 操作时间<br>
	 * 操作时间
	 * @return 操作时间
	*/
	public Date getOperTime() {
		return operTime;
	}
	
	/**
	 * 设置 操作时间
	 * @param operTime 操作时间
	 * @return 当前对象
	*/
	public PersonApprovalRcd setOperTime(Date operTime) {
		this.operTime=operTime;
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
	public PersonApprovalRcd setCreateBy(String createBy) {
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
	public PersonApprovalRcd setCreateTime(Date createTime) {
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
	public PersonApprovalRcd setUpdateBy(String updateBy) {
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
	public PersonApprovalRcd setUpdateTime(Date updateTime) {
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
	public PersonApprovalRcd setDeleted(Integer deleted) {
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
	public PersonApprovalRcd setDeleted(Boolean deletedBool) {
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
	public PersonApprovalRcd setDeleteBy(String deleteBy) {
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
	public PersonApprovalRcd setDeleteTime(Date deleteTime) {
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
	public PersonApprovalRcd setVersion(Integer version) {
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
	public PersonApprovalRcd setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 operUser<br>
	 * operUser
	 * @return operUser
	*/
	public Employee getOperUser() {
		return operUser;
	}
	
	/**
	 * 设置 operUser
	 * @param operUser operUser
	 * @return 当前对象
	*/
	public PersonApprovalRcd setOperUser(Employee operUser) {
		this.operUser=operUser;
		return this;
	}
	
	/**
	 * 获得 itemIds<br>
	 * itemIds
	 * @return itemIds
	*/
	public List<String> getItemIds() {
		return itemIds;
	}
	
	/**
	 * 设置 itemIds
	 * @param itemIds itemIds
	 * @return 当前对象
	*/
	public PersonApprovalRcd setItemIds(List<String> itemIds) {
		this.itemIds=itemIds;
		return this;
	}
	
	/**
	 * 添加 itemIds
	 * @param itemId itemIds
	 * @return 当前对象
	*/
	public PersonApprovalRcd addItemId(String... itemId) {
		if(this.itemIds==null) itemIds=new ArrayList<>();
		this.itemIds.addAll(Arrays.asList(itemId));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonApprovalRcd , 转换好的 PersonApprovalRcd 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonApprovalRcd , 转换好的 PoJo 对象
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
	public PersonApprovalRcd clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonApprovalRcd duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonApprovalRcdMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonApprovalRcdMeta.$$proxy$$();
		inst.setOperUserId(this.getOperUserId());
		inst.setPid(this.getPid());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setResult(this.getResult());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setOperTime(this.getOperTime());
		if(all) {
			inst.setItemIds(this.getItemIds());
			inst.setOperUser(this.getOperUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonApprovalRcd clone(boolean deep) {
		return EntityContext.clone(PersonApprovalRcd.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonApprovalRcd
	 * @param personApprovalRcdMap 包含实体信息的 Map 对象
	 * @return PersonApprovalRcd , 转换好的的 PersonApprovalRcd 对象
	*/
	@Transient
	public static PersonApprovalRcd createFrom(Map<String,Object> personApprovalRcdMap) {
		if(personApprovalRcdMap==null) return null;
		PersonApprovalRcd po = create();
		EntityContext.copyProperties(po,personApprovalRcdMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonApprovalRcd
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonApprovalRcd , 转换好的的 PersonApprovalRcd 对象
	*/
	@Transient
	public static PersonApprovalRcd createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonApprovalRcd po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonApprovalRcd，等同于 new
	 * @return PersonApprovalRcd 对象
	*/
	@Transient
	public static PersonApprovalRcd create() {
		return new com.dt.platform.domain.hr.meta.PersonApprovalRcdMeta.$$proxy$$();
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
			this.setOperUserId(DataParser.parse(String.class, map.get(PersonApprovalRcdMeta.OPER_USER_ID)));
			this.setPid(DataParser.parse(String.class, map.get(PersonApprovalRcdMeta.PID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonApprovalRcdMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, map.get(PersonApprovalRcdMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonApprovalRcdMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(PersonApprovalRcdMeta.CONTENT)));
			this.setResult(DataParser.parse(String.class, map.get(PersonApprovalRcdMeta.RESULT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonApprovalRcdMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonApprovalRcdMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonApprovalRcdMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonApprovalRcdMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonApprovalRcdMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonApprovalRcdMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonApprovalRcdMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PersonApprovalRcdMeta.ID)));
			this.setOperTime(DataParser.parse(Date.class, map.get(PersonApprovalRcdMeta.OPER_TIME)));
			// others
			this.setOperUser(DataParser.parse(Employee.class, map.get(PersonApprovalRcdMeta.OPER_USER)));
			return true;
		} else {
			try {
				this.setOperUserId( (String)map.get(PersonApprovalRcdMeta.OPER_USER_ID));
				this.setPid( (String)map.get(PersonApprovalRcdMeta.PID));
				this.setUpdateTime( (Date)map.get(PersonApprovalRcdMeta.UPDATE_TIME));
				this.setType( (String)map.get(PersonApprovalRcdMeta.TYPE));
				this.setVersion( (Integer)map.get(PersonApprovalRcdMeta.VERSION));
				this.setContent( (String)map.get(PersonApprovalRcdMeta.CONTENT));
				this.setResult( (String)map.get(PersonApprovalRcdMeta.RESULT));
				this.setCreateBy( (String)map.get(PersonApprovalRcdMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonApprovalRcdMeta.DELETED));
				this.setCreateTime( (Date)map.get(PersonApprovalRcdMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonApprovalRcdMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonApprovalRcdMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(PersonApprovalRcdMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonApprovalRcdMeta.DELETE_BY));
				this.setId( (String)map.get(PersonApprovalRcdMeta.ID));
				this.setOperTime( (Date)map.get(PersonApprovalRcdMeta.OPER_TIME));
				// others
				this.setOperUser( (Employee)map.get(PersonApprovalRcdMeta.OPER_USER));
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
			this.setOperUserId(DataParser.parse(String.class, r.getValue(PersonApprovalRcdMeta.OPER_USER_ID)));
			this.setPid(DataParser.parse(String.class, r.getValue(PersonApprovalRcdMeta.PID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonApprovalRcdMeta.UPDATE_TIME)));
			this.setType(DataParser.parse(String.class, r.getValue(PersonApprovalRcdMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonApprovalRcdMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(PersonApprovalRcdMeta.CONTENT)));
			this.setResult(DataParser.parse(String.class, r.getValue(PersonApprovalRcdMeta.RESULT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonApprovalRcdMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonApprovalRcdMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonApprovalRcdMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonApprovalRcdMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonApprovalRcdMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonApprovalRcdMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonApprovalRcdMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonApprovalRcdMeta.ID)));
			this.setOperTime(DataParser.parse(Date.class, r.getValue(PersonApprovalRcdMeta.OPER_TIME)));
			return true;
		} else {
			try {
				this.setOperUserId( (String)r.getValue(PersonApprovalRcdMeta.OPER_USER_ID));
				this.setPid( (String)r.getValue(PersonApprovalRcdMeta.PID));
				this.setUpdateTime( (Date)r.getValue(PersonApprovalRcdMeta.UPDATE_TIME));
				this.setType( (String)r.getValue(PersonApprovalRcdMeta.TYPE));
				this.setVersion( (Integer)r.getValue(PersonApprovalRcdMeta.VERSION));
				this.setContent( (String)r.getValue(PersonApprovalRcdMeta.CONTENT));
				this.setResult( (String)r.getValue(PersonApprovalRcdMeta.RESULT));
				this.setCreateBy( (String)r.getValue(PersonApprovalRcdMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonApprovalRcdMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PersonApprovalRcdMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonApprovalRcdMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonApprovalRcdMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(PersonApprovalRcdMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonApprovalRcdMeta.DELETE_BY));
				this.setId( (String)r.getValue(PersonApprovalRcdMeta.ID));
				this.setOperTime( (Date)r.getValue(PersonApprovalRcdMeta.OPER_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}