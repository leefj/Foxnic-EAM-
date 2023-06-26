package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_WORK_RPT;
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
import com.dt.platform.domain.oa.meta.WorkRptMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 工作报告
 * <p>工作报告 , 数据表 oa_work_rpt 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-26 10:12:26
 * @sign 268E3B42C561C5925C07964EC81743B5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_work_rpt")
@ApiModel(description = "工作报告 ; 工作报告 , 数据表 oa_work_rpt 的PO类型")
public class WorkRpt extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_WORK_RPT.$TABLE;
	
	/**
	 * ID：ID
	*/
	@Id
	@ApiModelProperty(required = true,value="ID" , notes = "ID" , example = "725653172302905344")
	private String id;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间" , example = "2022-12-13 12:00:00")
	private Date fTime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间" , example = "2022-12-14 12:00:00")
	private Date tTime;
	
	/**
	 * 本周：本周
	*/
	@ApiModelProperty(required = false,value="本周" , notes = "本周" , example = "水淀粉撒的")
	private String content;
	
	/**
	 * 下周：下周
	*/
	@ApiModelProperty(required = false,value="下周" , notes = "下周" , example = "阿斯顿发水淀粉")
	private String nextContent;
	
	/**
	 * 其他事项：其他事项
	*/
	@ApiModelProperty(required = false,value="其他事项" , notes = "其他事项" , example = "大法师的饭")
	private String other;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String fileId;
	
	/**
	 * 报告人：报告人
	*/
	@ApiModelProperty(required = false,value="报告人" , notes = "报告人")
	private String userId;
	
	/**
	 * 接收人：接收人
	*/
	@ApiModelProperty(required = false,value="接收人" , notes = "接收人")
	private String receiverId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-06-26 10:06:38")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-06-26 10:11:45")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "2")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * reportUser：reportUser
	*/
	@ApiModelProperty(required = false,value="reportUser" , notes = "reportUser")
	private Employee reportUser;
	
	/**
	 * receiver：receiver
	*/
	@ApiModelProperty(required = false,value="receiver" , notes = "receiver")
	private Employee receiver;
	
	/**
	 * 获得 ID<br>
	 * ID
	 * @return ID
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 ID
	 * @param id ID
	 * @return 当前对象
	*/
	public WorkRpt setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getFTime() {
		return fTime;
	}
	
	/**
	 * 设置 开始时间
	 * @param fTime 开始时间
	 * @return 当前对象
	*/
	public WorkRpt setFTime(Date fTime) {
		this.fTime=fTime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getTTime() {
		return tTime;
	}
	
	/**
	 * 设置 结束时间
	 * @param tTime 结束时间
	 * @return 当前对象
	*/
	public WorkRpt setTTime(Date tTime) {
		this.tTime=tTime;
		return this;
	}
	
	/**
	 * 获得 本周<br>
	 * 本周
	 * @return 本周
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 本周
	 * @param content 本周
	 * @return 当前对象
	*/
	public WorkRpt setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 下周<br>
	 * 下周
	 * @return 下周
	*/
	public String getNextContent() {
		return nextContent;
	}
	
	/**
	 * 设置 下周
	 * @param nextContent 下周
	 * @return 当前对象
	*/
	public WorkRpt setNextContent(String nextContent) {
		this.nextContent=nextContent;
		return this;
	}
	
	/**
	 * 获得 其他事项<br>
	 * 其他事项
	 * @return 其他事项
	*/
	public String getOther() {
		return other;
	}
	
	/**
	 * 设置 其他事项
	 * @param other 其他事项
	 * @return 当前对象
	*/
	public WorkRpt setOther(String other) {
		this.other=other;
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
	public WorkRpt setFileId(String fileId) {
		this.fileId=fileId;
		return this;
	}
	
	/**
	 * 获得 报告人<br>
	 * 报告人
	 * @return 报告人
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 报告人
	 * @param userId 报告人
	 * @return 当前对象
	*/
	public WorkRpt setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 接收人<br>
	 * 接收人
	 * @return 接收人
	*/
	public String getReceiverId() {
		return receiverId;
	}
	
	/**
	 * 设置 接收人
	 * @param receiverId 接收人
	 * @return 当前对象
	*/
	public WorkRpt setReceiverId(String receiverId) {
		this.receiverId=receiverId;
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
	public WorkRpt setCreateBy(String createBy) {
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
	public WorkRpt setCreateTime(Date createTime) {
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
	public WorkRpt setUpdateBy(String updateBy) {
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
	public WorkRpt setUpdateTime(Date updateTime) {
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
	public WorkRpt setDeleted(Integer deleted) {
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
	public WorkRpt setDeleted(Boolean deletedBool) {
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
	public WorkRpt setDeleteBy(String deleteBy) {
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
	public WorkRpt setDeleteTime(Date deleteTime) {
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
	public WorkRpt setVersion(Integer version) {
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
	public WorkRpt setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 reportUser<br>
	 * reportUser
	 * @return reportUser
	*/
	public Employee getReportUser() {
		return reportUser;
	}
	
	/**
	 * 设置 reportUser
	 * @param reportUser reportUser
	 * @return 当前对象
	*/
	public WorkRpt setReportUser(Employee reportUser) {
		this.reportUser=reportUser;
		return this;
	}
	
	/**
	 * 获得 receiver<br>
	 * receiver
	 * @return receiver
	*/
	public Employee getReceiver() {
		return receiver;
	}
	
	/**
	 * 设置 receiver
	 * @param receiver receiver
	 * @return 当前对象
	*/
	public WorkRpt setReceiver(Employee receiver) {
		this.receiver=receiver;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return WorkRpt , 转换好的 WorkRpt 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return WorkRpt , 转换好的 PoJo 对象
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
	public WorkRpt clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public WorkRpt duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.WorkRptMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.WorkRptMeta.$$proxy$$();
		inst.setOther(this.getOther());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setTTime(this.getTTime());
		inst.setNextContent(this.getNextContent());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setReceiverId(this.getReceiverId());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setFTime(this.getFTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setFileId(this.getFileId());
		if(all) {
			inst.setReportUser(this.getReportUser());
			inst.setReceiver(this.getReceiver());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public WorkRpt clone(boolean deep) {
		return EntityContext.clone(WorkRpt.class,this,deep);
	}

	/**
	 * 将 Map 转换成 WorkRpt
	 * @param workRptMap 包含实体信息的 Map 对象
	 * @return WorkRpt , 转换好的的 WorkRpt 对象
	*/
	@Transient
	public static WorkRpt createFrom(Map<String,Object> workRptMap) {
		if(workRptMap==null) return null;
		WorkRpt po = create();
		EntityContext.copyProperties(po,workRptMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 WorkRpt
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return WorkRpt , 转换好的的 WorkRpt 对象
	*/
	@Transient
	public static WorkRpt createFrom(Object pojo) {
		if(pojo==null) return null;
		WorkRpt po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 WorkRpt，等同于 new
	 * @return WorkRpt 对象
	*/
	@Transient
	public static WorkRpt create() {
		return new com.dt.platform.domain.oa.meta.WorkRptMeta.$$proxy$$();
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
			this.setOther(DataParser.parse(String.class, map.get(WorkRptMeta.OTHER)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(WorkRptMeta.UPDATE_TIME)));
			this.setTTime(DataParser.parse(Date.class, map.get(WorkRptMeta.T_TIME)));
			this.setNextContent(DataParser.parse(String.class, map.get(WorkRptMeta.NEXT_CONTENT)));
			this.setUserId(DataParser.parse(String.class, map.get(WorkRptMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(WorkRptMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(WorkRptMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(WorkRptMeta.CREATE_BY)));
			this.setReceiverId(DataParser.parse(String.class, map.get(WorkRptMeta.RECEIVER_ID)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(WorkRptMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(WorkRptMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(WorkRptMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(WorkRptMeta.DELETE_TIME)));
			this.setFTime(DataParser.parse(Date.class, map.get(WorkRptMeta.F_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(WorkRptMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(WorkRptMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(WorkRptMeta.ID)));
			this.setFileId(DataParser.parse(String.class, map.get(WorkRptMeta.FILE_ID)));
			// others
			this.setReportUser(DataParser.parse(Employee.class, map.get(WorkRptMeta.REPORT_USER)));
			this.setReceiver(DataParser.parse(Employee.class, map.get(WorkRptMeta.RECEIVER)));
			return true;
		} else {
			try {
				this.setOther( (String)map.get(WorkRptMeta.OTHER));
				this.setUpdateTime( (Date)map.get(WorkRptMeta.UPDATE_TIME));
				this.setTTime( (Date)map.get(WorkRptMeta.T_TIME));
				this.setNextContent( (String)map.get(WorkRptMeta.NEXT_CONTENT));
				this.setUserId( (String)map.get(WorkRptMeta.USER_ID));
				this.setVersion( (Integer)map.get(WorkRptMeta.VERSION));
				this.setContent( (String)map.get(WorkRptMeta.CONTENT));
				this.setCreateBy( (String)map.get(WorkRptMeta.CREATE_BY));
				this.setReceiverId( (String)map.get(WorkRptMeta.RECEIVER_ID));
				this.setDeleted( (Integer)map.get(WorkRptMeta.DELETED));
				this.setCreateTime( (Date)map.get(WorkRptMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(WorkRptMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(WorkRptMeta.DELETE_TIME));
				this.setFTime( (Date)map.get(WorkRptMeta.F_TIME));
				this.setTenantId( (String)map.get(WorkRptMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(WorkRptMeta.DELETE_BY));
				this.setId( (String)map.get(WorkRptMeta.ID));
				this.setFileId( (String)map.get(WorkRptMeta.FILE_ID));
				// others
				this.setReportUser( (Employee)map.get(WorkRptMeta.REPORT_USER));
				this.setReceiver( (Employee)map.get(WorkRptMeta.RECEIVER));
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
			this.setOther(DataParser.parse(String.class, r.getValue(WorkRptMeta.OTHER)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(WorkRptMeta.UPDATE_TIME)));
			this.setTTime(DataParser.parse(Date.class, r.getValue(WorkRptMeta.T_TIME)));
			this.setNextContent(DataParser.parse(String.class, r.getValue(WorkRptMeta.NEXT_CONTENT)));
			this.setUserId(DataParser.parse(String.class, r.getValue(WorkRptMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(WorkRptMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(WorkRptMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(WorkRptMeta.CREATE_BY)));
			this.setReceiverId(DataParser.parse(String.class, r.getValue(WorkRptMeta.RECEIVER_ID)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(WorkRptMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(WorkRptMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(WorkRptMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(WorkRptMeta.DELETE_TIME)));
			this.setFTime(DataParser.parse(Date.class, r.getValue(WorkRptMeta.F_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(WorkRptMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(WorkRptMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(WorkRptMeta.ID)));
			this.setFileId(DataParser.parse(String.class, r.getValue(WorkRptMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setOther( (String)r.getValue(WorkRptMeta.OTHER));
				this.setUpdateTime( (Date)r.getValue(WorkRptMeta.UPDATE_TIME));
				this.setTTime( (Date)r.getValue(WorkRptMeta.T_TIME));
				this.setNextContent( (String)r.getValue(WorkRptMeta.NEXT_CONTENT));
				this.setUserId( (String)r.getValue(WorkRptMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(WorkRptMeta.VERSION));
				this.setContent( (String)r.getValue(WorkRptMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(WorkRptMeta.CREATE_BY));
				this.setReceiverId( (String)r.getValue(WorkRptMeta.RECEIVER_ID));
				this.setDeleted( (Integer)r.getValue(WorkRptMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(WorkRptMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(WorkRptMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(WorkRptMeta.DELETE_TIME));
				this.setFTime( (Date)r.getValue(WorkRptMeta.F_TIME));
				this.setTenantId( (String)r.getValue(WorkRptMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(WorkRptMeta.DELETE_BY));
				this.setId( (String)r.getValue(WorkRptMeta.ID));
				this.setFileId( (String)r.getValue(WorkRptMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}