package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_DEVICE_SP_RCD;
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
import com.dt.platform.domain.eam.meta.DeviceSpRcdMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 备件记录
 * <p>备件记录 , 数据表 eam_device_sp_rcd 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-23 19:36:25
 * @sign 494C3047ABC4B9BF7DB05C56C1ECFF61
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_device_sp_rcd")
@ApiModel(description = "备件记录 ; 备件记录 , 数据表 eam_device_sp_rcd 的PO类型")
public class DeviceSpRcd extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_DEVICE_SP_RCD.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "733252021959786496")
	private String id;
	
	/**
	 * 备件：备件
	*/
	@ApiModelProperty(required = false,value="备件" , notes = "备件" , example = "733251985435787264")
	private String spId;
	
	/**
	 * 编号：编号
	*/
	@ApiModelProperty(required = false,value="编号" , notes = "编号" , example = "C126246")
	private String spCode;
	
	/**
	 * 使用人：使用人
	*/
	@ApiModelProperty(required = false,value="使用人" , notes = "使用人" , example = "E001")
	private String operId;
	
	/**
	 * 操作时间：操作时间
	*/
	@ApiModelProperty(required = false,value="操作时间" , notes = "操作时间" , example = "2023-07-17 09:21:45")
	private Date operTime;
	
	/**
	 * 操作内容：操作内容
	*/
	@ApiModelProperty(required = false,value="操作内容" , notes = "操作内容" , example = "当前确认资产入库")
	private String content;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-07-17 09:21:45")
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
	 * deviceSp：deviceSp
	*/
	@ApiModelProperty(required = false,value="deviceSp" , notes = "deviceSp")
	private DeviceSp deviceSp;
	
	/**
	 * operUser：operUser
	*/
	@ApiModelProperty(required = false,value="operUser" , notes = "operUser")
	private Employee operUser;
	
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
	public DeviceSpRcd setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 备件<br>
	 * 备件
	 * @return 备件
	*/
	public String getSpId() {
		return spId;
	}
	
	/**
	 * 设置 备件
	 * @param spId 备件
	 * @return 当前对象
	*/
	public DeviceSpRcd setSpId(String spId) {
		this.spId=spId;
		return this;
	}
	
	/**
	 * 获得 编号<br>
	 * 编号
	 * @return 编号
	*/
	public String getSpCode() {
		return spCode;
	}
	
	/**
	 * 设置 编号
	 * @param spCode 编号
	 * @return 当前对象
	*/
	public DeviceSpRcd setSpCode(String spCode) {
		this.spCode=spCode;
		return this;
	}
	
	/**
	 * 获得 使用人<br>
	 * 使用人
	 * @return 使用人
	*/
	public String getOperId() {
		return operId;
	}
	
	/**
	 * 设置 使用人
	 * @param operId 使用人
	 * @return 当前对象
	*/
	public DeviceSpRcd setOperId(String operId) {
		this.operId=operId;
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
	public DeviceSpRcd setOperTime(Date operTime) {
		this.operTime=operTime;
		return this;
	}
	
	/**
	 * 获得 操作内容<br>
	 * 操作内容
	 * @return 操作内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 操作内容
	 * @param content 操作内容
	 * @return 当前对象
	*/
	public DeviceSpRcd setContent(String content) {
		this.content=content;
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
	public DeviceSpRcd setCreateBy(String createBy) {
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
	public DeviceSpRcd setCreateTime(Date createTime) {
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
	public DeviceSpRcd setUpdateBy(String updateBy) {
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
	public DeviceSpRcd setUpdateTime(Date updateTime) {
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
	public DeviceSpRcd setDeleted(Integer deleted) {
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
	public DeviceSpRcd setDeleted(Boolean deletedBool) {
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
	public DeviceSpRcd setDeleteBy(String deleteBy) {
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
	public DeviceSpRcd setDeleteTime(Date deleteTime) {
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
	public DeviceSpRcd setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 deviceSp<br>
	 * deviceSp
	 * @return deviceSp
	*/
	public DeviceSp getDeviceSp() {
		return deviceSp;
	}
	
	/**
	 * 设置 deviceSp
	 * @param deviceSp deviceSp
	 * @return 当前对象
	*/
	public DeviceSpRcd setDeviceSp(DeviceSp deviceSp) {
		this.deviceSp=deviceSp;
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
	public DeviceSpRcd setOperUser(Employee operUser) {
		this.operUser=operUser;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DeviceSpRcd , 转换好的 DeviceSpRcd 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DeviceSpRcd , 转换好的 PoJo 对象
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
	public DeviceSpRcd clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DeviceSpRcd duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.DeviceSpRcdMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.DeviceSpRcdMeta.$$proxy$$();
		inst.setOperId(this.getOperId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSpId(this.getSpId());
		inst.setSpCode(this.getSpCode());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setOperTime(this.getOperTime());
		if(all) {
			inst.setOperUser(this.getOperUser());
			inst.setDeviceSp(this.getDeviceSp());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DeviceSpRcd clone(boolean deep) {
		return EntityContext.clone(DeviceSpRcd.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DeviceSpRcd
	 * @param deviceSpRcdMap 包含实体信息的 Map 对象
	 * @return DeviceSpRcd , 转换好的的 DeviceSpRcd 对象
	*/
	@Transient
	public static DeviceSpRcd createFrom(Map<String,Object> deviceSpRcdMap) {
		if(deviceSpRcdMap==null) return null;
		DeviceSpRcd po = create();
		EntityContext.copyProperties(po,deviceSpRcdMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DeviceSpRcd
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DeviceSpRcd , 转换好的的 DeviceSpRcd 对象
	*/
	@Transient
	public static DeviceSpRcd createFrom(Object pojo) {
		if(pojo==null) return null;
		DeviceSpRcd po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DeviceSpRcd，等同于 new
	 * @return DeviceSpRcd 对象
	*/
	@Transient
	public static DeviceSpRcd create() {
		return new com.dt.platform.domain.eam.meta.DeviceSpRcdMeta.$$proxy$$();
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
			this.setOperId(DataParser.parse(String.class, map.get(DeviceSpRcdMeta.OPER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DeviceSpRcdMeta.UPDATE_TIME)));
			this.setSpId(DataParser.parse(String.class, map.get(DeviceSpRcdMeta.SP_ID)));
			this.setSpCode(DataParser.parse(String.class, map.get(DeviceSpRcdMeta.SP_CODE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DeviceSpRcdMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(DeviceSpRcdMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DeviceSpRcdMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DeviceSpRcdMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DeviceSpRcdMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DeviceSpRcdMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DeviceSpRcdMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DeviceSpRcdMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(DeviceSpRcdMeta.ID)));
			this.setOperTime(DataParser.parse(Date.class, map.get(DeviceSpRcdMeta.OPER_TIME)));
			// others
			this.setOperUser(DataParser.parse(Employee.class, map.get(DeviceSpRcdMeta.OPER_USER)));
			this.setDeviceSp(DataParser.parse(DeviceSp.class, map.get(DeviceSpRcdMeta.DEVICE_SP)));
			return true;
		} else {
			try {
				this.setOperId( (String)map.get(DeviceSpRcdMeta.OPER_ID));
				this.setUpdateTime( (Date)map.get(DeviceSpRcdMeta.UPDATE_TIME));
				this.setSpId( (String)map.get(DeviceSpRcdMeta.SP_ID));
				this.setSpCode( (String)map.get(DeviceSpRcdMeta.SP_CODE));
				this.setVersion( (Integer)map.get(DeviceSpRcdMeta.VERSION));
				this.setContent( (String)map.get(DeviceSpRcdMeta.CONTENT));
				this.setCreateBy( (String)map.get(DeviceSpRcdMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DeviceSpRcdMeta.DELETED));
				this.setCreateTime( (Date)map.get(DeviceSpRcdMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(DeviceSpRcdMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DeviceSpRcdMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(DeviceSpRcdMeta.DELETE_BY));
				this.setId( (String)map.get(DeviceSpRcdMeta.ID));
				this.setOperTime( (Date)map.get(DeviceSpRcdMeta.OPER_TIME));
				// others
				this.setOperUser( (Employee)map.get(DeviceSpRcdMeta.OPER_USER));
				this.setDeviceSp( (DeviceSp)map.get(DeviceSpRcdMeta.DEVICE_SP));
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
			this.setOperId(DataParser.parse(String.class, r.getValue(DeviceSpRcdMeta.OPER_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DeviceSpRcdMeta.UPDATE_TIME)));
			this.setSpId(DataParser.parse(String.class, r.getValue(DeviceSpRcdMeta.SP_ID)));
			this.setSpCode(DataParser.parse(String.class, r.getValue(DeviceSpRcdMeta.SP_CODE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DeviceSpRcdMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(DeviceSpRcdMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DeviceSpRcdMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DeviceSpRcdMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DeviceSpRcdMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DeviceSpRcdMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DeviceSpRcdMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DeviceSpRcdMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(DeviceSpRcdMeta.ID)));
			this.setOperTime(DataParser.parse(Date.class, r.getValue(DeviceSpRcdMeta.OPER_TIME)));
			return true;
		} else {
			try {
				this.setOperId( (String)r.getValue(DeviceSpRcdMeta.OPER_ID));
				this.setUpdateTime( (Date)r.getValue(DeviceSpRcdMeta.UPDATE_TIME));
				this.setSpId( (String)r.getValue(DeviceSpRcdMeta.SP_ID));
				this.setSpCode( (String)r.getValue(DeviceSpRcdMeta.SP_CODE));
				this.setVersion( (Integer)r.getValue(DeviceSpRcdMeta.VERSION));
				this.setContent( (String)r.getValue(DeviceSpRcdMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(DeviceSpRcdMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DeviceSpRcdMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(DeviceSpRcdMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(DeviceSpRcdMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DeviceSpRcdMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(DeviceSpRcdMeta.DELETE_BY));
				this.setId( (String)r.getValue(DeviceSpRcdMeta.ID));
				this.setOperTime( (Date)r.getValue(DeviceSpRcdMeta.OPER_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}