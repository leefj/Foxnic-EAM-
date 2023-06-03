package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_FILE_OUT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.PersonFileOutMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 档案调出
 * <p>档案调出 , 数据表 hr_person_file_out 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 21:38:28
 * @sign E5C78C08811C3CE8430F0998CC26A4CA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_file_out")
@ApiModel(description = "档案调出 ; 档案调出 , 数据表 hr_person_file_out 的PO类型")
public class PersonFileOut extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_FILE_OUT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "717468232000208896")
	private String id;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 档案：档案
	*/
	@ApiModelProperty(required = false,value="档案" , notes = "档案")
	private String fileId;
	
	/**
	 * 调出时间：调出时间
	*/
	@ApiModelProperty(required = false,value="调出时间" , notes = "调出时间" , example = "2023-00-29")
	private String outDate;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容" , example = "12")
	private String content;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "12")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-06-03 08:02:36")
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
	public PersonFileOut setId(String id) {
		this.id=id;
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
	public PersonFileOut setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 档案<br>
	 * 档案
	 * @return 档案
	*/
	public String getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 档案
	 * @param fileId 档案
	 * @return 当前对象
	*/
	public PersonFileOut setFileId(String fileId) {
		this.fileId=fileId;
		return this;
	}
	
	/**
	 * 获得 调出时间<br>
	 * 调出时间
	 * @return 调出时间
	*/
	public String getOutDate() {
		return outDate;
	}
	
	/**
	 * 设置 调出时间
	 * @param outDate 调出时间
	 * @return 当前对象
	*/
	public PersonFileOut setOutDate(String outDate) {
		this.outDate=outDate;
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
	public PersonFileOut setContent(String content) {
		this.content=content;
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
	public PersonFileOut setNotes(String notes) {
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
	public PersonFileOut setCreateBy(String createBy) {
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
	public PersonFileOut setCreateTime(Date createTime) {
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
	public PersonFileOut setUpdateBy(String updateBy) {
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
	public PersonFileOut setUpdateTime(Date updateTime) {
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
	public PersonFileOut setDeleted(Integer deleted) {
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
	public PersonFileOut setDeleted(Boolean deletedBool) {
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
	public PersonFileOut setDeleteBy(String deleteBy) {
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
	public PersonFileOut setDeleteTime(Date deleteTime) {
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
	public PersonFileOut setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonFileOut , 转换好的 PersonFileOut 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonFileOut , 转换好的 PoJo 对象
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
	public PersonFileOut clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonFileOut duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonFileOutMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonFileOutMeta.$$proxy$$();
		inst.setOutDate(this.getOutDate());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		inst.setFileId(this.getFileId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonFileOut clone(boolean deep) {
		return EntityContext.clone(PersonFileOut.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonFileOut
	 * @param personFileOutMap 包含实体信息的 Map 对象
	 * @return PersonFileOut , 转换好的的 PersonFileOut 对象
	*/
	@Transient
	public static PersonFileOut createFrom(Map<String,Object> personFileOutMap) {
		if(personFileOutMap==null) return null;
		PersonFileOut po = create();
		EntityContext.copyProperties(po,personFileOutMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonFileOut
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonFileOut , 转换好的的 PersonFileOut 对象
	*/
	@Transient
	public static PersonFileOut createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonFileOut po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonFileOut，等同于 new
	 * @return PersonFileOut 对象
	*/
	@Transient
	public static PersonFileOut create() {
		return new com.dt.platform.domain.hr.meta.PersonFileOutMeta.$$proxy$$();
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
			this.setOutDate(DataParser.parse(String.class, map.get(PersonFileOutMeta.OUT_DATE)));
			this.setNotes(DataParser.parse(String.class, map.get(PersonFileOutMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonFileOutMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonFileOutMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(PersonFileOutMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonFileOutMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonFileOutMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonFileOutMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonFileOutMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonFileOutMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonFileOutMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PersonFileOutMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonFileOutMeta.STATUS)));
			this.setFileId(DataParser.parse(String.class, map.get(PersonFileOutMeta.FILE_ID)));
			// others
			return true;
		} else {
			try {
				this.setOutDate( (String)map.get(PersonFileOutMeta.OUT_DATE));
				this.setNotes( (String)map.get(PersonFileOutMeta.NOTES));
				this.setUpdateTime( (Date)map.get(PersonFileOutMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(PersonFileOutMeta.VERSION));
				this.setContent( (String)map.get(PersonFileOutMeta.CONTENT));
				this.setCreateBy( (String)map.get(PersonFileOutMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonFileOutMeta.DELETED));
				this.setCreateTime( (Date)map.get(PersonFileOutMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonFileOutMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonFileOutMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(PersonFileOutMeta.DELETE_BY));
				this.setId( (String)map.get(PersonFileOutMeta.ID));
				this.setStatus( (String)map.get(PersonFileOutMeta.STATUS));
				this.setFileId( (String)map.get(PersonFileOutMeta.FILE_ID));
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
			this.setOutDate(DataParser.parse(String.class, r.getValue(PersonFileOutMeta.OUT_DATE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(PersonFileOutMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonFileOutMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonFileOutMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(PersonFileOutMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonFileOutMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonFileOutMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonFileOutMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonFileOutMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonFileOutMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonFileOutMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonFileOutMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonFileOutMeta.STATUS)));
			this.setFileId(DataParser.parse(String.class, r.getValue(PersonFileOutMeta.FILE_ID)));
			return true;
		} else {
			try {
				this.setOutDate( (String)r.getValue(PersonFileOutMeta.OUT_DATE));
				this.setNotes( (String)r.getValue(PersonFileOutMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(PersonFileOutMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(PersonFileOutMeta.VERSION));
				this.setContent( (String)r.getValue(PersonFileOutMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(PersonFileOutMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonFileOutMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PersonFileOutMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonFileOutMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonFileOutMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(PersonFileOutMeta.DELETE_BY));
				this.setId( (String)r.getValue(PersonFileOutMeta.ID));
				this.setStatus( (String)r.getValue(PersonFileOutMeta.STATUS));
				this.setFileId( (String)r.getValue(PersonFileOutMeta.FILE_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}