package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ATTENDANCE_TPL_GROUP;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.AttendanceTplGroupMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考勤班组
 * <p>考勤班组 , 数据表 hr_attendance_tpl_group 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-27 13:25:42
 * @sign 54AB5166DC34132C29318C8130234A87
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_attendance_tpl_group")
@ApiModel(description = "考勤班组 ; 考勤班组 , 数据表 hr_attendance_tpl_group 的PO类型")
public class AttendanceTplGroup extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ATTENDANCE_TPL_GROUP.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = true,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 上班时间：上班时间
	*/
	@ApiModelProperty(required = true,value="上班时间" , notes = "上班时间")
	private Date onWorkTime;
	
	/**
	 * 上班打卡上限：上班打卡上限
	*/
	@ApiModelProperty(required = true,value="上班打卡上限" , notes = "上班打卡上限")
	private Date onWorkTimeUp;
	
	/**
	 * 上班打卡下限：上班打卡下限
	*/
	@ApiModelProperty(required = true,value="上班打卡下限" , notes = "上班打卡下限")
	private Date onWorkTimeDown;
	
	/**
	 * 下班时间：下班时间
	*/
	@ApiModelProperty(required = true,value="下班时间" , notes = "下班时间")
	private Date offWorkTime;
	
	/**
	 * 下班打卡上限：下班打卡上限
	*/
	@ApiModelProperty(required = true,value="下班打卡上限" , notes = "下班打卡上限")
	private Date offWorkTimeUp;
	
	/**
	 * 下班打卡下限：下班打卡下限
	*/
	@ApiModelProperty(required = true,value="下班打卡下限" , notes = "下班打卡下限")
	private Date offWorkTimeDown;
	
	/**
	 * 上班打卡：上班打卡
	*/
	@ApiModelProperty(required = false,value="上班打卡" , notes = "上班打卡")
	private String halfWorkUp;
	
	/**
	 * 下班打卡：下班打卡
	*/
	@ApiModelProperty(required = false,value="下班打卡" , notes = "下班打卡")
	private String halfWorkDown;
	
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
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
	public AttendanceTplGroup setId(String id) {
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
	public AttendanceTplGroup setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 上班时间<br>
	 * 上班时间
	 * @return 上班时间
	*/
	public Date getOnWorkTime() {
		return onWorkTime;
	}
	
	/**
	 * 设置 上班时间
	 * @param onWorkTime 上班时间
	 * @return 当前对象
	*/
	public AttendanceTplGroup setOnWorkTime(Date onWorkTime) {
		this.onWorkTime=onWorkTime;
		return this;
	}
	
	/**
	 * 获得 上班打卡上限<br>
	 * 上班打卡上限
	 * @return 上班打卡上限
	*/
	public Date getOnWorkTimeUp() {
		return onWorkTimeUp;
	}
	
	/**
	 * 设置 上班打卡上限
	 * @param onWorkTimeUp 上班打卡上限
	 * @return 当前对象
	*/
	public AttendanceTplGroup setOnWorkTimeUp(Date onWorkTimeUp) {
		this.onWorkTimeUp=onWorkTimeUp;
		return this;
	}
	
	/**
	 * 获得 上班打卡下限<br>
	 * 上班打卡下限
	 * @return 上班打卡下限
	*/
	public Date getOnWorkTimeDown() {
		return onWorkTimeDown;
	}
	
	/**
	 * 设置 上班打卡下限
	 * @param onWorkTimeDown 上班打卡下限
	 * @return 当前对象
	*/
	public AttendanceTplGroup setOnWorkTimeDown(Date onWorkTimeDown) {
		this.onWorkTimeDown=onWorkTimeDown;
		return this;
	}
	
	/**
	 * 获得 下班时间<br>
	 * 下班时间
	 * @return 下班时间
	*/
	public Date getOffWorkTime() {
		return offWorkTime;
	}
	
	/**
	 * 设置 下班时间
	 * @param offWorkTime 下班时间
	 * @return 当前对象
	*/
	public AttendanceTplGroup setOffWorkTime(Date offWorkTime) {
		this.offWorkTime=offWorkTime;
		return this;
	}
	
	/**
	 * 获得 下班打卡上限<br>
	 * 下班打卡上限
	 * @return 下班打卡上限
	*/
	public Date getOffWorkTimeUp() {
		return offWorkTimeUp;
	}
	
	/**
	 * 设置 下班打卡上限
	 * @param offWorkTimeUp 下班打卡上限
	 * @return 当前对象
	*/
	public AttendanceTplGroup setOffWorkTimeUp(Date offWorkTimeUp) {
		this.offWorkTimeUp=offWorkTimeUp;
		return this;
	}
	
	/**
	 * 获得 下班打卡下限<br>
	 * 下班打卡下限
	 * @return 下班打卡下限
	*/
	public Date getOffWorkTimeDown() {
		return offWorkTimeDown;
	}
	
	/**
	 * 设置 下班打卡下限
	 * @param offWorkTimeDown 下班打卡下限
	 * @return 当前对象
	*/
	public AttendanceTplGroup setOffWorkTimeDown(Date offWorkTimeDown) {
		this.offWorkTimeDown=offWorkTimeDown;
		return this;
	}
	
	/**
	 * 获得 上班打卡<br>
	 * 上班打卡
	 * @return 上班打卡
	*/
	public String getHalfWorkUp() {
		return halfWorkUp;
	}
	
	/**
	 * 设置 上班打卡
	 * @param halfWorkUp 上班打卡
	 * @return 当前对象
	*/
	public AttendanceTplGroup setHalfWorkUp(String halfWorkUp) {
		this.halfWorkUp=halfWorkUp;
		return this;
	}
	
	/**
	 * 获得 下班打卡<br>
	 * 下班打卡
	 * @return 下班打卡
	*/
	public String getHalfWorkDown() {
		return halfWorkDown;
	}
	
	/**
	 * 设置 下班打卡
	 * @param halfWorkDown 下班打卡
	 * @return 当前对象
	*/
	public AttendanceTplGroup setHalfWorkDown(String halfWorkDown) {
		this.halfWorkDown=halfWorkDown;
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
	public AttendanceTplGroup setNotes(String notes) {
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
	public AttendanceTplGroup setCreateBy(String createBy) {
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
	public AttendanceTplGroup setCreateTime(Date createTime) {
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
	public AttendanceTplGroup setUpdateBy(String updateBy) {
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
	public AttendanceTplGroup setUpdateTime(Date updateTime) {
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
	public AttendanceTplGroup setDeleted(Integer deleted) {
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
	public AttendanceTplGroup setDeleted(Boolean deletedBool) {
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
	public AttendanceTplGroup setDeleteBy(String deleteBy) {
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
	public AttendanceTplGroup setDeleteTime(Date deleteTime) {
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
	public AttendanceTplGroup setVersion(Integer version) {
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
	public AttendanceTplGroup setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AttendanceTplGroup , 转换好的 AttendanceTplGroup 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AttendanceTplGroup , 转换好的 PoJo 对象
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
	public AttendanceTplGroup clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AttendanceTplGroup duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AttendanceTplGroupMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AttendanceTplGroupMeta.$$proxy$$();
		inst.setOffWorkTimeDown(this.getOffWorkTimeDown());
		inst.setOffWorkTimeUp(this.getOffWorkTimeUp());
		inst.setNotes(this.getNotes());
		inst.setOnWorkTimeUp(this.getOnWorkTimeUp());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setOnWorkTime(this.getOnWorkTime());
		inst.setOnWorkTimeDown(this.getOnWorkTimeDown());
		inst.setCreateBy(this.getCreateBy());
		inst.setOffWorkTime(this.getOffWorkTime());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setHalfWorkUp(this.getHalfWorkUp());
		inst.setId(this.getId());
		inst.setHalfWorkDown(this.getHalfWorkDown());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AttendanceTplGroup clone(boolean deep) {
		return EntityContext.clone(AttendanceTplGroup.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AttendanceTplGroup
	 * @param attendanceTplGroupMap 包含实体信息的 Map 对象
	 * @return AttendanceTplGroup , 转换好的的 AttendanceTplGroup 对象
	*/
	@Transient
	public static AttendanceTplGroup createFrom(Map<String,Object> attendanceTplGroupMap) {
		if(attendanceTplGroupMap==null) return null;
		AttendanceTplGroup po = create();
		EntityContext.copyProperties(po,attendanceTplGroupMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AttendanceTplGroup
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AttendanceTplGroup , 转换好的的 AttendanceTplGroup 对象
	*/
	@Transient
	public static AttendanceTplGroup createFrom(Object pojo) {
		if(pojo==null) return null;
		AttendanceTplGroup po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AttendanceTplGroup，等同于 new
	 * @return AttendanceTplGroup 对象
	*/
	@Transient
	public static AttendanceTplGroup create() {
		return new com.dt.platform.domain.hr.meta.AttendanceTplGroupMeta.$$proxy$$();
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
			this.setOffWorkTimeDown(DataParser.parse(Date.class, map.get(AttendanceTplGroupMeta.OFF_WORK_TIME_DOWN)));
			this.setOffWorkTimeUp(DataParser.parse(Date.class, map.get(AttendanceTplGroupMeta.OFF_WORK_TIME_UP)));
			this.setNotes(DataParser.parse(String.class, map.get(AttendanceTplGroupMeta.NOTES)));
			this.setOnWorkTimeUp(DataParser.parse(Date.class, map.get(AttendanceTplGroupMeta.ON_WORK_TIME_UP)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AttendanceTplGroupMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AttendanceTplGroupMeta.VERSION)));
			this.setOnWorkTime(DataParser.parse(Date.class, map.get(AttendanceTplGroupMeta.ON_WORK_TIME)));
			this.setOnWorkTimeDown(DataParser.parse(Date.class, map.get(AttendanceTplGroupMeta.ON_WORK_TIME_DOWN)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AttendanceTplGroupMeta.CREATE_BY)));
			this.setOffWorkTime(DataParser.parse(Date.class, map.get(AttendanceTplGroupMeta.OFF_WORK_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AttendanceTplGroupMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AttendanceTplGroupMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AttendanceTplGroupMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AttendanceTplGroupMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AttendanceTplGroupMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AttendanceTplGroupMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AttendanceTplGroupMeta.DELETE_BY)));
			this.setHalfWorkUp(DataParser.parse(String.class, map.get(AttendanceTplGroupMeta.HALF_WORK_UP)));
			this.setId(DataParser.parse(String.class, map.get(AttendanceTplGroupMeta.ID)));
			this.setHalfWorkDown(DataParser.parse(String.class, map.get(AttendanceTplGroupMeta.HALF_WORK_DOWN)));
			// others
			return true;
		} else {
			try {
				this.setOffWorkTimeDown( (Date)map.get(AttendanceTplGroupMeta.OFF_WORK_TIME_DOWN));
				this.setOffWorkTimeUp( (Date)map.get(AttendanceTplGroupMeta.OFF_WORK_TIME_UP));
				this.setNotes( (String)map.get(AttendanceTplGroupMeta.NOTES));
				this.setOnWorkTimeUp( (Date)map.get(AttendanceTplGroupMeta.ON_WORK_TIME_UP));
				this.setUpdateTime( (Date)map.get(AttendanceTplGroupMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AttendanceTplGroupMeta.VERSION));
				this.setOnWorkTime( (Date)map.get(AttendanceTplGroupMeta.ON_WORK_TIME));
				this.setOnWorkTimeDown( (Date)map.get(AttendanceTplGroupMeta.ON_WORK_TIME_DOWN));
				this.setCreateBy( (String)map.get(AttendanceTplGroupMeta.CREATE_BY));
				this.setOffWorkTime( (Date)map.get(AttendanceTplGroupMeta.OFF_WORK_TIME));
				this.setDeleted( (Integer)map.get(AttendanceTplGroupMeta.DELETED));
				this.setCreateTime( (Date)map.get(AttendanceTplGroupMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AttendanceTplGroupMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AttendanceTplGroupMeta.DELETE_TIME));
				this.setName( (String)map.get(AttendanceTplGroupMeta.NAME));
				this.setTenantId( (String)map.get(AttendanceTplGroupMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AttendanceTplGroupMeta.DELETE_BY));
				this.setHalfWorkUp( (String)map.get(AttendanceTplGroupMeta.HALF_WORK_UP));
				this.setId( (String)map.get(AttendanceTplGroupMeta.ID));
				this.setHalfWorkDown( (String)map.get(AttendanceTplGroupMeta.HALF_WORK_DOWN));
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
			this.setOffWorkTimeDown(DataParser.parse(Date.class, r.getValue(AttendanceTplGroupMeta.OFF_WORK_TIME_DOWN)));
			this.setOffWorkTimeUp(DataParser.parse(Date.class, r.getValue(AttendanceTplGroupMeta.OFF_WORK_TIME_UP)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AttendanceTplGroupMeta.NOTES)));
			this.setOnWorkTimeUp(DataParser.parse(Date.class, r.getValue(AttendanceTplGroupMeta.ON_WORK_TIME_UP)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AttendanceTplGroupMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AttendanceTplGroupMeta.VERSION)));
			this.setOnWorkTime(DataParser.parse(Date.class, r.getValue(AttendanceTplGroupMeta.ON_WORK_TIME)));
			this.setOnWorkTimeDown(DataParser.parse(Date.class, r.getValue(AttendanceTplGroupMeta.ON_WORK_TIME_DOWN)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AttendanceTplGroupMeta.CREATE_BY)));
			this.setOffWorkTime(DataParser.parse(Date.class, r.getValue(AttendanceTplGroupMeta.OFF_WORK_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AttendanceTplGroupMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AttendanceTplGroupMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AttendanceTplGroupMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AttendanceTplGroupMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AttendanceTplGroupMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AttendanceTplGroupMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AttendanceTplGroupMeta.DELETE_BY)));
			this.setHalfWorkUp(DataParser.parse(String.class, r.getValue(AttendanceTplGroupMeta.HALF_WORK_UP)));
			this.setId(DataParser.parse(String.class, r.getValue(AttendanceTplGroupMeta.ID)));
			this.setHalfWorkDown(DataParser.parse(String.class, r.getValue(AttendanceTplGroupMeta.HALF_WORK_DOWN)));
			return true;
		} else {
			try {
				this.setOffWorkTimeDown( (Date)r.getValue(AttendanceTplGroupMeta.OFF_WORK_TIME_DOWN));
				this.setOffWorkTimeUp( (Date)r.getValue(AttendanceTplGroupMeta.OFF_WORK_TIME_UP));
				this.setNotes( (String)r.getValue(AttendanceTplGroupMeta.NOTES));
				this.setOnWorkTimeUp( (Date)r.getValue(AttendanceTplGroupMeta.ON_WORK_TIME_UP));
				this.setUpdateTime( (Date)r.getValue(AttendanceTplGroupMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AttendanceTplGroupMeta.VERSION));
				this.setOnWorkTime( (Date)r.getValue(AttendanceTplGroupMeta.ON_WORK_TIME));
				this.setOnWorkTimeDown( (Date)r.getValue(AttendanceTplGroupMeta.ON_WORK_TIME_DOWN));
				this.setCreateBy( (String)r.getValue(AttendanceTplGroupMeta.CREATE_BY));
				this.setOffWorkTime( (Date)r.getValue(AttendanceTplGroupMeta.OFF_WORK_TIME));
				this.setDeleted( (Integer)r.getValue(AttendanceTplGroupMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AttendanceTplGroupMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AttendanceTplGroupMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AttendanceTplGroupMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AttendanceTplGroupMeta.NAME));
				this.setTenantId( (String)r.getValue(AttendanceTplGroupMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AttendanceTplGroupMeta.DELETE_BY));
				this.setHalfWorkUp( (String)r.getValue(AttendanceTplGroupMeta.HALF_WORK_UP));
				this.setId( (String)r.getValue(AttendanceTplGroupMeta.ID));
				this.setHalfWorkDown( (String)r.getValue(AttendanceTplGroupMeta.HALF_WORK_DOWN));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}