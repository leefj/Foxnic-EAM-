package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ATTENDANCE_PROCESS;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Organization;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.AttendanceProcessMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考勤跑批
 * <p>考勤跑批 , 数据表 hr_attendance_process 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-26 09:26:55
 * @sign 2182BA6100C450EF9E6B9E76520C5E10
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_attendance_process")
@ApiModel(description = "考勤跑批 ; 考勤跑批 , 数据表 hr_attendance_process 的PO类型")
public class AttendanceProcess extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ATTENDANCE_PROCESS.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "814198828914704384")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "测试")
	private String name;
	
	/**
	 * 所有人员：所有人员
	*/
	@ApiModelProperty(required = false,value="所有人员" , notes = "所有人员" , example = "yes")
	private String isAllPerson;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间" , example = "2024-02-01 12:00:00")
	private Date sdate;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间" , example = "2024-02-29 12:00:00")
	private Date edate;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "测试")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-25 06:15:28")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-02-26 09:24:10")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "14")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * personList：personList
	*/
	@ApiModelProperty(required = false,value="personList" , notes = "personList")
	private List<Person> personList;
	
	/**
	 * personIds：personIds
	*/
	@ApiModelProperty(required = false,value="personIds" , notes = "personIds")
	private List<String> personIds;
	
	/**
	 * organizationList：organizationList
	*/
	@ApiModelProperty(required = false,value="organizationList" , notes = "organizationList")
	private List<Organization> organizationList;
	
	/**
	 * organizationIds：organizationIds
	*/
	@ApiModelProperty(required = false,value="organizationIds" , notes = "organizationIds")
	private List<String> organizationIds;
	
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
	public AttendanceProcess setId(String id) {
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
	public AttendanceProcess setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 所有人员<br>
	 * 所有人员
	 * @return 所有人员
	*/
	public String getIsAllPerson() {
		return isAllPerson;
	}
	
	/**
	 * 设置 所有人员
	 * @param isAllPerson 所有人员
	 * @return 当前对象
	*/
	public AttendanceProcess setIsAllPerson(String isAllPerson) {
		this.isAllPerson=isAllPerson;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getSdate() {
		return sdate;
	}
	
	/**
	 * 设置 开始时间
	 * @param sdate 开始时间
	 * @return 当前对象
	*/
	public AttendanceProcess setSdate(Date sdate) {
		this.sdate=sdate;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getEdate() {
		return edate;
	}
	
	/**
	 * 设置 开始时间
	 * @param edate 开始时间
	 * @return 当前对象
	*/
	public AttendanceProcess setEdate(Date edate) {
		this.edate=edate;
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
	public AttendanceProcess setNotes(String notes) {
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
	public AttendanceProcess setCreateBy(String createBy) {
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
	public AttendanceProcess setCreateTime(Date createTime) {
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
	public AttendanceProcess setUpdateBy(String updateBy) {
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
	public AttendanceProcess setUpdateTime(Date updateTime) {
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
	public AttendanceProcess setDeleted(Integer deleted) {
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
	public AttendanceProcess setDeleted(Boolean deletedBool) {
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
	public AttendanceProcess setDeleteBy(String deleteBy) {
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
	public AttendanceProcess setDeleteTime(Date deleteTime) {
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
	public AttendanceProcess setVersion(Integer version) {
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
	public AttendanceProcess setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 personList<br>
	 * personList
	 * @return personList
	*/
	public List<Person> getPersonList() {
		return personList;
	}
	
	/**
	 * 设置 personList
	 * @param personList personList
	 * @return 当前对象
	*/
	public AttendanceProcess setPersonList(List<Person> personList) {
		this.personList=personList;
		return this;
	}
	
	/**
	 * 添加 personList
	 * @param person personList
	 * @return 当前对象
	*/
	public AttendanceProcess addPerson(Person... person) {
		if(this.personList==null) personList=new ArrayList<>();
		this.personList.addAll(Arrays.asList(person));
		return this;
	}
	
	/**
	 * 获得 personIds<br>
	 * personIds
	 * @return personIds
	*/
	public List<String> getPersonIds() {
		return personIds;
	}
	
	/**
	 * 设置 personIds
	 * @param personIds personIds
	 * @return 当前对象
	*/
	public AttendanceProcess setPersonIds(List<String> personIds) {
		this.personIds=personIds;
		return this;
	}
	
	/**
	 * 添加 personIds
	 * @param personId personIds
	 * @return 当前对象
	*/
	public AttendanceProcess addPersonId(String... personId) {
		if(this.personIds==null) personIds=new ArrayList<>();
		this.personIds.addAll(Arrays.asList(personId));
		return this;
	}
	
	/**
	 * 获得 organizationList<br>
	 * organizationList
	 * @return organizationList
	*/
	public List<Organization> getOrganizationList() {
		return organizationList;
	}
	
	/**
	 * 设置 organizationList
	 * @param organizationList organizationList
	 * @return 当前对象
	*/
	public AttendanceProcess setOrganizationList(List<Organization> organizationList) {
		this.organizationList=organizationList;
		return this;
	}
	
	/**
	 * 添加 organizationList
	 * @param organization organizationList
	 * @return 当前对象
	*/
	public AttendanceProcess addOrganization(Organization... organization) {
		if(this.organizationList==null) organizationList=new ArrayList<>();
		this.organizationList.addAll(Arrays.asList(organization));
		return this;
	}
	
	/**
	 * 获得 organizationIds<br>
	 * organizationIds
	 * @return organizationIds
	*/
	public List<String> getOrganizationIds() {
		return organizationIds;
	}
	
	/**
	 * 设置 organizationIds
	 * @param organizationIds organizationIds
	 * @return 当前对象
	*/
	public AttendanceProcess setOrganizationIds(List<String> organizationIds) {
		this.organizationIds=organizationIds;
		return this;
	}
	
	/**
	 * 添加 organizationIds
	 * @param organizationId organizationIds
	 * @return 当前对象
	*/
	public AttendanceProcess addOrganizationId(String... organizationId) {
		if(this.organizationIds==null) organizationIds=new ArrayList<>();
		this.organizationIds.addAll(Arrays.asList(organizationId));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AttendanceProcess , 转换好的 AttendanceProcess 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AttendanceProcess , 转换好的 PoJo 对象
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
	public AttendanceProcess clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AttendanceProcess duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AttendanceProcessMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AttendanceProcessMeta.$$proxy$$();
		inst.setSdate(this.getSdate());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setEdate(this.getEdate());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setIsAllPerson(this.getIsAllPerson());
		if(all) {
			inst.setPersonList(this.getPersonList());
			inst.setOrganizationIds(this.getOrganizationIds());
			inst.setOrganizationList(this.getOrganizationList());
			inst.setPersonIds(this.getPersonIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AttendanceProcess clone(boolean deep) {
		return EntityContext.clone(AttendanceProcess.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AttendanceProcess
	 * @param attendanceProcessMap 包含实体信息的 Map 对象
	 * @return AttendanceProcess , 转换好的的 AttendanceProcess 对象
	*/
	@Transient
	public static AttendanceProcess createFrom(Map<String,Object> attendanceProcessMap) {
		if(attendanceProcessMap==null) return null;
		AttendanceProcess po = create();
		EntityContext.copyProperties(po,attendanceProcessMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AttendanceProcess
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AttendanceProcess , 转换好的的 AttendanceProcess 对象
	*/
	@Transient
	public static AttendanceProcess createFrom(Object pojo) {
		if(pojo==null) return null;
		AttendanceProcess po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AttendanceProcess，等同于 new
	 * @return AttendanceProcess 对象
	*/
	@Transient
	public static AttendanceProcess create() {
		return new com.dt.platform.domain.hr.meta.AttendanceProcessMeta.$$proxy$$();
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
			this.setSdate(DataParser.parse(Date.class, map.get(AttendanceProcessMeta.SDATE)));
			this.setNotes(DataParser.parse(String.class, map.get(AttendanceProcessMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AttendanceProcessMeta.UPDATE_TIME)));
			this.setEdate(DataParser.parse(Date.class, map.get(AttendanceProcessMeta.EDATE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AttendanceProcessMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AttendanceProcessMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AttendanceProcessMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AttendanceProcessMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AttendanceProcessMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AttendanceProcessMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AttendanceProcessMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AttendanceProcessMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AttendanceProcessMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AttendanceProcessMeta.ID)));
			this.setIsAllPerson(DataParser.parse(String.class, map.get(AttendanceProcessMeta.IS_ALL_PERSON)));
			// others
			return true;
		} else {
			try {
				this.setSdate( (Date)map.get(AttendanceProcessMeta.SDATE));
				this.setNotes( (String)map.get(AttendanceProcessMeta.NOTES));
				this.setUpdateTime( (Date)map.get(AttendanceProcessMeta.UPDATE_TIME));
				this.setEdate( (Date)map.get(AttendanceProcessMeta.EDATE));
				this.setVersion( (Integer)map.get(AttendanceProcessMeta.VERSION));
				this.setCreateBy( (String)map.get(AttendanceProcessMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AttendanceProcessMeta.DELETED));
				this.setCreateTime( (Date)map.get(AttendanceProcessMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AttendanceProcessMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AttendanceProcessMeta.DELETE_TIME));
				this.setName( (String)map.get(AttendanceProcessMeta.NAME));
				this.setTenantId( (String)map.get(AttendanceProcessMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AttendanceProcessMeta.DELETE_BY));
				this.setId( (String)map.get(AttendanceProcessMeta.ID));
				this.setIsAllPerson( (String)map.get(AttendanceProcessMeta.IS_ALL_PERSON));
				// others
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
			this.setSdate(DataParser.parse(Date.class, r.getValue(AttendanceProcessMeta.SDATE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AttendanceProcessMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AttendanceProcessMeta.UPDATE_TIME)));
			this.setEdate(DataParser.parse(Date.class, r.getValue(AttendanceProcessMeta.EDATE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AttendanceProcessMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AttendanceProcessMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AttendanceProcessMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AttendanceProcessMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AttendanceProcessMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AttendanceProcessMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AttendanceProcessMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AttendanceProcessMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AttendanceProcessMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AttendanceProcessMeta.ID)));
			this.setIsAllPerson(DataParser.parse(String.class, r.getValue(AttendanceProcessMeta.IS_ALL_PERSON)));
			return true;
		} else {
			try {
				this.setSdate( (Date)r.getValue(AttendanceProcessMeta.SDATE));
				this.setNotes( (String)r.getValue(AttendanceProcessMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(AttendanceProcessMeta.UPDATE_TIME));
				this.setEdate( (Date)r.getValue(AttendanceProcessMeta.EDATE));
				this.setVersion( (Integer)r.getValue(AttendanceProcessMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AttendanceProcessMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AttendanceProcessMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AttendanceProcessMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AttendanceProcessMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AttendanceProcessMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AttendanceProcessMeta.NAME));
				this.setTenantId( (String)r.getValue(AttendanceProcessMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AttendanceProcessMeta.DELETE_BY));
				this.setId( (String)r.getValue(AttendanceProcessMeta.ID));
				this.setIsAllPerson( (String)r.getValue(AttendanceProcessMeta.IS_ALL_PERSON));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}