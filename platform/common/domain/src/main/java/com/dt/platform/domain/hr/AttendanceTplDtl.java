package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_ATTENDANCE_TPL_DTL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.AttendanceTplDtlMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 考勤组
 * <p>考勤组 , 数据表 hr_attendance_tpl_dtl 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-27 13:36:25
 * @sign 7C4A796BFA8D1A3915771F1772E37E6D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_attendance_tpl_dtl")
@ApiModel(description = "考勤组 ; 考勤组 , 数据表 hr_attendance_tpl_dtl 的PO类型")
public class AttendanceTplDtl extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_ATTENDANCE_TPL_DTL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "814224996120395701")
	private String id;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码" , example = "default")
	private String ownerId;
	
	/**
	 * 周：周
	*/
	@ApiModelProperty(required = false,value="周" , notes = "周" , example = "w1")
	private String week;
	
	/**
	 * 是否上班：是否上班
	*/
	@ApiModelProperty(required = false,value="是否上班" , notes = "是否上班" , example = "yes")
	private String isWorkDay;
	
	/**
	 * 上班类型：上班类型
	*/
	@ApiModelProperty(required = false,value="上班类型" , notes = "上班类型" , example = "day_full")
	private String dayType;
	
	/**
	 * 1天1次：1天1次
	*/
	@ApiModelProperty(required = false,value="1天1次" , notes = "1天1次" , example = "814851231850692608")
	private String firstWork;
	
	/**
	 * 1天2次：1天2次
	*/
	@ApiModelProperty(required = false,value="1天2次" , notes = "1天2次")
	private String secondWork;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-02-25 07:59:27")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2024-02-27 01:35:28")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "3")
	private Integer version;
	
	/**
	 * weekDict：weekDict
	*/
	@ApiModelProperty(required = false,value="weekDict" , notes = "weekDict")
	private DictItem weekDict;
	
	/**
	 * firstGroup：firstGroup
	*/
	@ApiModelProperty(required = false,value="firstGroup" , notes = "firstGroup")
	private AttendanceTplGroup firstGroup;
	
	/**
	 * secondGroup：secondGroup
	*/
	@ApiModelProperty(required = false,value="secondGroup" , notes = "secondGroup")
	private AttendanceTplGroup secondGroup;
	
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
	public AttendanceTplDtl setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 编码
	 * @param ownerId 编码
	 * @return 当前对象
	*/
	public AttendanceTplDtl setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 周<br>
	 * 周
	 * @return 周
	*/
	public String getWeek() {
		return week;
	}
	
	/**
	 * 设置 周
	 * @param week 周
	 * @return 当前对象
	*/
	public AttendanceTplDtl setWeek(String week) {
		this.week=week;
		return this;
	}
	
	/**
	 * 获得 是否上班<br>
	 * 是否上班
	 * @return 是否上班
	*/
	public String getIsWorkDay() {
		return isWorkDay;
	}
	
	/**
	 * 设置 是否上班
	 * @param isWorkDay 是否上班
	 * @return 当前对象
	*/
	public AttendanceTplDtl setIsWorkDay(String isWorkDay) {
		this.isWorkDay=isWorkDay;
		return this;
	}
	
	/**
	 * 获得 上班类型<br>
	 * 上班类型
	 * @return 上班类型
	*/
	public String getDayType() {
		return dayType;
	}
	
	/**
	 * 设置 上班类型
	 * @param dayType 上班类型
	 * @return 当前对象
	*/
	public AttendanceTplDtl setDayType(String dayType) {
		this.dayType=dayType;
		return this;
	}
	
	/**
	 * 获得 1天1次<br>
	 * 1天1次
	 * @return 1天1次
	*/
	public String getFirstWork() {
		return firstWork;
	}
	
	/**
	 * 设置 1天1次
	 * @param firstWork 1天1次
	 * @return 当前对象
	*/
	public AttendanceTplDtl setFirstWork(String firstWork) {
		this.firstWork=firstWork;
		return this;
	}
	
	/**
	 * 获得 1天2次<br>
	 * 1天2次
	 * @return 1天2次
	*/
	public String getSecondWork() {
		return secondWork;
	}
	
	/**
	 * 设置 1天2次
	 * @param secondWork 1天2次
	 * @return 当前对象
	*/
	public AttendanceTplDtl setSecondWork(String secondWork) {
		this.secondWork=secondWork;
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
	public AttendanceTplDtl setNotes(String notes) {
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
	public AttendanceTplDtl setCreateBy(String createBy) {
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
	public AttendanceTplDtl setCreateTime(Date createTime) {
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
	public AttendanceTplDtl setUpdateBy(String updateBy) {
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
	public AttendanceTplDtl setUpdateTime(Date updateTime) {
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
	public AttendanceTplDtl setDeleted(Integer deleted) {
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
	public AttendanceTplDtl setDeleted(Boolean deletedBool) {
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
	public AttendanceTplDtl setDeleteBy(String deleteBy) {
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
	public AttendanceTplDtl setDeleteTime(Date deleteTime) {
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
	public AttendanceTplDtl setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 weekDict<br>
	 * weekDict
	 * @return weekDict
	*/
	public DictItem getWeekDict() {
		return weekDict;
	}
	
	/**
	 * 设置 weekDict
	 * @param weekDict weekDict
	 * @return 当前对象
	*/
	public AttendanceTplDtl setWeekDict(DictItem weekDict) {
		this.weekDict=weekDict;
		return this;
	}
	
	/**
	 * 获得 firstGroup<br>
	 * firstGroup
	 * @return firstGroup
	*/
	public AttendanceTplGroup getFirstGroup() {
		return firstGroup;
	}
	
	/**
	 * 设置 firstGroup
	 * @param firstGroup firstGroup
	 * @return 当前对象
	*/
	public AttendanceTplDtl setFirstGroup(AttendanceTplGroup firstGroup) {
		this.firstGroup=firstGroup;
		return this;
	}
	
	/**
	 * 获得 secondGroup<br>
	 * secondGroup
	 * @return secondGroup
	*/
	public AttendanceTplGroup getSecondGroup() {
		return secondGroup;
	}
	
	/**
	 * 设置 secondGroup
	 * @param secondGroup secondGroup
	 * @return 当前对象
	*/
	public AttendanceTplDtl setSecondGroup(AttendanceTplGroup secondGroup) {
		this.secondGroup=secondGroup;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AttendanceTplDtl , 转换好的 AttendanceTplDtl 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AttendanceTplDtl , 转换好的 PoJo 对象
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
	public AttendanceTplDtl clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AttendanceTplDtl duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.AttendanceTplDtlMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.AttendanceTplDtlMeta.$$proxy$$();
		inst.setSecondWork(this.getSecondWork());
		inst.setWeek(this.getWeek());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setOwnerId(this.getOwnerId());
		inst.setVersion(this.getVersion());
		inst.setFirstWork(this.getFirstWork());
		inst.setDayType(this.getDayType());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setIsWorkDay(this.getIsWorkDay());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
			inst.setSecondGroup(this.getSecondGroup());
			inst.setWeekDict(this.getWeekDict());
			inst.setFirstGroup(this.getFirstGroup());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AttendanceTplDtl clone(boolean deep) {
		return EntityContext.clone(AttendanceTplDtl.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AttendanceTplDtl
	 * @param attendanceTplDtlMap 包含实体信息的 Map 对象
	 * @return AttendanceTplDtl , 转换好的的 AttendanceTplDtl 对象
	*/
	@Transient
	public static AttendanceTplDtl createFrom(Map<String,Object> attendanceTplDtlMap) {
		if(attendanceTplDtlMap==null) return null;
		AttendanceTplDtl po = create();
		EntityContext.copyProperties(po,attendanceTplDtlMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AttendanceTplDtl
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AttendanceTplDtl , 转换好的的 AttendanceTplDtl 对象
	*/
	@Transient
	public static AttendanceTplDtl createFrom(Object pojo) {
		if(pojo==null) return null;
		AttendanceTplDtl po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AttendanceTplDtl，等同于 new
	 * @return AttendanceTplDtl 对象
	*/
	@Transient
	public static AttendanceTplDtl create() {
		return new com.dt.platform.domain.hr.meta.AttendanceTplDtlMeta.$$proxy$$();
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
			this.setSecondWork(DataParser.parse(String.class, map.get(AttendanceTplDtlMeta.SECOND_WORK)));
			this.setWeek(DataParser.parse(String.class, map.get(AttendanceTplDtlMeta.WEEK)));
			this.setNotes(DataParser.parse(String.class, map.get(AttendanceTplDtlMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AttendanceTplDtlMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, map.get(AttendanceTplDtlMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AttendanceTplDtlMeta.VERSION)));
			this.setFirstWork(DataParser.parse(String.class, map.get(AttendanceTplDtlMeta.FIRST_WORK)));
			this.setDayType(DataParser.parse(String.class, map.get(AttendanceTplDtlMeta.DAY_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AttendanceTplDtlMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AttendanceTplDtlMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AttendanceTplDtlMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AttendanceTplDtlMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AttendanceTplDtlMeta.DELETE_TIME)));
			this.setIsWorkDay(DataParser.parse(String.class, map.get(AttendanceTplDtlMeta.IS_WORK_DAY)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AttendanceTplDtlMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AttendanceTplDtlMeta.ID)));
			// others
			this.setSecondGroup(DataParser.parse(AttendanceTplGroup.class, map.get(AttendanceTplDtlMeta.SECOND_GROUP)));
			this.setWeekDict(DataParser.parse(DictItem.class, map.get(AttendanceTplDtlMeta.WEEK_DICT)));
			this.setFirstGroup(DataParser.parse(AttendanceTplGroup.class, map.get(AttendanceTplDtlMeta.FIRST_GROUP)));
			return true;
		} else {
			try {
				this.setSecondWork( (String)map.get(AttendanceTplDtlMeta.SECOND_WORK));
				this.setWeek( (String)map.get(AttendanceTplDtlMeta.WEEK));
				this.setNotes( (String)map.get(AttendanceTplDtlMeta.NOTES));
				this.setUpdateTime( (Date)map.get(AttendanceTplDtlMeta.UPDATE_TIME));
				this.setOwnerId( (String)map.get(AttendanceTplDtlMeta.OWNER_ID));
				this.setVersion( (Integer)map.get(AttendanceTplDtlMeta.VERSION));
				this.setFirstWork( (String)map.get(AttendanceTplDtlMeta.FIRST_WORK));
				this.setDayType( (String)map.get(AttendanceTplDtlMeta.DAY_TYPE));
				this.setCreateBy( (String)map.get(AttendanceTplDtlMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AttendanceTplDtlMeta.DELETED));
				this.setCreateTime( (Date)map.get(AttendanceTplDtlMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AttendanceTplDtlMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AttendanceTplDtlMeta.DELETE_TIME));
				this.setIsWorkDay( (String)map.get(AttendanceTplDtlMeta.IS_WORK_DAY));
				this.setDeleteBy( (String)map.get(AttendanceTplDtlMeta.DELETE_BY));
				this.setId( (String)map.get(AttendanceTplDtlMeta.ID));
				// others
				this.setSecondGroup( (AttendanceTplGroup)map.get(AttendanceTplDtlMeta.SECOND_GROUP));
				this.setWeekDict( (DictItem)map.get(AttendanceTplDtlMeta.WEEK_DICT));
				this.setFirstGroup( (AttendanceTplGroup)map.get(AttendanceTplDtlMeta.FIRST_GROUP));
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
			this.setSecondWork(DataParser.parse(String.class, r.getValue(AttendanceTplDtlMeta.SECOND_WORK)));
			this.setWeek(DataParser.parse(String.class, r.getValue(AttendanceTplDtlMeta.WEEK)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AttendanceTplDtlMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AttendanceTplDtlMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(AttendanceTplDtlMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AttendanceTplDtlMeta.VERSION)));
			this.setFirstWork(DataParser.parse(String.class, r.getValue(AttendanceTplDtlMeta.FIRST_WORK)));
			this.setDayType(DataParser.parse(String.class, r.getValue(AttendanceTplDtlMeta.DAY_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AttendanceTplDtlMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AttendanceTplDtlMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AttendanceTplDtlMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AttendanceTplDtlMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AttendanceTplDtlMeta.DELETE_TIME)));
			this.setIsWorkDay(DataParser.parse(String.class, r.getValue(AttendanceTplDtlMeta.IS_WORK_DAY)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AttendanceTplDtlMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AttendanceTplDtlMeta.ID)));
			return true;
		} else {
			try {
				this.setSecondWork( (String)r.getValue(AttendanceTplDtlMeta.SECOND_WORK));
				this.setWeek( (String)r.getValue(AttendanceTplDtlMeta.WEEK));
				this.setNotes( (String)r.getValue(AttendanceTplDtlMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(AttendanceTplDtlMeta.UPDATE_TIME));
				this.setOwnerId( (String)r.getValue(AttendanceTplDtlMeta.OWNER_ID));
				this.setVersion( (Integer)r.getValue(AttendanceTplDtlMeta.VERSION));
				this.setFirstWork( (String)r.getValue(AttendanceTplDtlMeta.FIRST_WORK));
				this.setDayType( (String)r.getValue(AttendanceTplDtlMeta.DAY_TYPE));
				this.setCreateBy( (String)r.getValue(AttendanceTplDtlMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AttendanceTplDtlMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AttendanceTplDtlMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AttendanceTplDtlMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AttendanceTplDtlMeta.DELETE_TIME));
				this.setIsWorkDay( (String)r.getValue(AttendanceTplDtlMeta.IS_WORK_DAY));
				this.setDeleteBy( (String)r.getValue(AttendanceTplDtlMeta.DELETE_BY));
				this.setId( (String)r.getValue(AttendanceTplDtlMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}