package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_INTERVIEW;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.InterviewMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 招聘面试
 * <p>招聘面试 , 数据表 hr_interview 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-19 13:27:03
 * @sign A07A134F96D929913BB83B4C90489844
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_interview")
@ApiModel(description = "招聘面试 ; 招聘面试 , 数据表 hr_interview 的PO类型")
public class Interview extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_INTERVIEW.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 标题：标题
	*/
	@ApiModelProperty(required = false,value="标题" , notes = "标题")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 面试日期：面试日期
	*/
	@ApiModelProperty(required = false,value="面试日期" , notes = "面试日期")
	private Date interviewDate;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
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
	private String notes;
	
	/**
	 * 登记人：登记人
	*/
	@ApiModelProperty(required = false,value="登记人" , notes = "登记人")
	private String userId;
	
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
	 * employee：employee
	*/
	@ApiModelProperty(required = false,value="employee" , notes = "employee")
	private Employee employee;
	
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
	public Interview setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 标题<br>
	 * 标题
	 * @return 标题
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 标题
	 * @param name 标题
	 * @return 当前对象
	*/
	public Interview setName(String name) {
		this.name=name;
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
	public Interview setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 面试日期<br>
	 * 面试日期
	 * @return 面试日期
	*/
	public Date getInterviewDate() {
		return interviewDate;
	}
	
	/**
	 * 设置 面试日期
	 * @param interviewDate 面试日期
	 * @return 当前对象
	*/
	public Interview setInterviewDate(Date interviewDate) {
		this.interviewDate=interviewDate;
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
	public Interview setContent(String content) {
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
	public Interview setFileId(String fileId) {
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
	public Interview setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 登记人<br>
	 * 登记人
	 * @return 登记人
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 登记人
	 * @param userId 登记人
	 * @return 当前对象
	*/
	public Interview setUserId(String userId) {
		this.userId=userId;
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
	public Interview setCreateBy(String createBy) {
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
	public Interview setCreateTime(Date createTime) {
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
	public Interview setUpdateBy(String updateBy) {
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
	public Interview setUpdateTime(Date updateTime) {
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
	public Interview setDeleted(Integer deleted) {
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
	public Interview setDeleted(Boolean deletedBool) {
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
	public Interview setDeleteBy(String deleteBy) {
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
	public Interview setDeleteTime(Date deleteTime) {
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
	public Interview setVersion(Integer version) {
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
	public Interview setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 employee<br>
	 * employee
	 * @return employee
	*/
	public Employee getEmployee() {
		return employee;
	}
	
	/**
	 * 设置 employee
	 * @param employee employee
	 * @return 当前对象
	*/
	public Interview setEmployee(Employee employee) {
		this.employee=employee;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Interview , 转换好的 Interview 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Interview , 转换好的 PoJo 对象
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
	public Interview clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Interview duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.InterviewMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.InterviewMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setInterviewDate(this.getInterviewDate());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		inst.setFileId(this.getFileId());
		if(all) {
			inst.setEmployee(this.getEmployee());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Interview clone(boolean deep) {
		return EntityContext.clone(Interview.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Interview
	 * @param interviewMap 包含实体信息的 Map 对象
	 * @return Interview , 转换好的的 Interview 对象
	*/
	@Transient
	public static Interview createFrom(Map<String,Object> interviewMap) {
		if(interviewMap==null) return null;
		Interview po = create();
		EntityContext.copyProperties(po,interviewMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Interview
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Interview , 转换好的的 Interview 对象
	*/
	@Transient
	public static Interview createFrom(Object pojo) {
		if(pojo==null) return null;
		Interview po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Interview，等同于 new
	 * @return Interview 对象
	*/
	@Transient
	public static Interview create() {
		return new com.dt.platform.domain.hr.meta.InterviewMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(InterviewMeta.NOTES)));
			this.setInterviewDate(DataParser.parse(Date.class, map.get(InterviewMeta.INTERVIEW_DATE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InterviewMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(InterviewMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InterviewMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(InterviewMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InterviewMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InterviewMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InterviewMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InterviewMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InterviewMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(InterviewMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(InterviewMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InterviewMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(InterviewMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(InterviewMeta.STATUS)));
			this.setFileId(DataParser.parse(String.class, map.get(InterviewMeta.FILE_ID)));
			// others
			this.setEmployee(DataParser.parse(Employee.class, map.get(InterviewMeta.EMPLOYEE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(InterviewMeta.NOTES));
				this.setInterviewDate( (Date)map.get(InterviewMeta.INTERVIEW_DATE));
				this.setUpdateTime( (Date)map.get(InterviewMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(InterviewMeta.USER_ID));
				this.setVersion( (Integer)map.get(InterviewMeta.VERSION));
				this.setContent( (String)map.get(InterviewMeta.CONTENT));
				this.setCreateBy( (String)map.get(InterviewMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(InterviewMeta.DELETED));
				this.setCreateTime( (Date)map.get(InterviewMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(InterviewMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(InterviewMeta.DELETE_TIME));
				this.setName( (String)map.get(InterviewMeta.NAME));
				this.setTenantId( (String)map.get(InterviewMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(InterviewMeta.DELETE_BY));
				this.setId( (String)map.get(InterviewMeta.ID));
				this.setStatus( (String)map.get(InterviewMeta.STATUS));
				this.setFileId( (String)map.get(InterviewMeta.FILE_ID));
				// others
				this.setEmployee( (Employee)map.get(InterviewMeta.EMPLOYEE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(InterviewMeta.NOTES)));
			this.setInterviewDate(DataParser.parse(Date.class, r.getValue(InterviewMeta.INTERVIEW_DATE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InterviewMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(InterviewMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InterviewMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(InterviewMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InterviewMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InterviewMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InterviewMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InterviewMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InterviewMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(InterviewMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(InterviewMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InterviewMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(InterviewMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(InterviewMeta.STATUS)));
			this.setFileId(DataParser.parse(String.class, r.getValue(InterviewMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(InterviewMeta.NOTES));
				this.setInterviewDate( (Date)r.getValue(InterviewMeta.INTERVIEW_DATE));
				this.setUpdateTime( (Date)r.getValue(InterviewMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(InterviewMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(InterviewMeta.VERSION));
				this.setContent( (String)r.getValue(InterviewMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(InterviewMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(InterviewMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(InterviewMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(InterviewMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(InterviewMeta.DELETE_TIME));
				this.setName( (String)r.getValue(InterviewMeta.NAME));
				this.setTenantId( (String)r.getValue(InterviewMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(InterviewMeta.DELETE_BY));
				this.setId( (String)r.getValue(InterviewMeta.ID));
				this.setStatus( (String)r.getValue(InterviewMeta.STATUS));
				this.setFileId( (String)r.getValue(InterviewMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}