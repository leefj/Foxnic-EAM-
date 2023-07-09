package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_DEMO_C2;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.DemoC2Meta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * demo
 * <p>demo , 数据表 eam_demo_c2 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-08 08:04:40
 * @sign 018A83BDA97E741396FEE06A9E224439
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_demo_c2")
@ApiModel(description = "demo ; demo , 数据表 eam_demo_c2 的PO类型")
public class DemoC2 extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_DEMO_C2.$TABLE;
	
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
	private String title;
	
	/**
	 * 价格：价格
	*/
	@ApiModelProperty(required = false,value="价格" , notes = "价格")
	private BigDecimal price;
	
	/**
	 * 是否有效：是否有效
	*/
	@ApiModelProperty(required = true,value="是否有效" , notes = "是否有效")
	private Integer valid;
	
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
	public DemoC2 setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 标题<br>
	 * 标题
	 * @return 标题
	*/
	public String getTitle() {
		return title;
	}
	
	/**
	 * 设置 标题
	 * @param title 标题
	 * @return 当前对象
	*/
	public DemoC2 setTitle(String title) {
		this.title=title;
		return this;
	}
	
	/**
	 * 获得 价格<br>
	 * 价格
	 * @return 价格
	*/
	public BigDecimal getPrice() {
		return price;
	}
	
	/**
	 * 设置 价格
	 * @param price 价格
	 * @return 当前对象
	*/
	public DemoC2 setPrice(BigDecimal price) {
		this.price=price;
		return this;
	}
	
	/**
	 * 获得 是否有效<br>
	 * 是否有效
	 * @return 是否有效
	*/
	public Integer getValid() {
		return valid;
	}
	
	/**
	 * 设置 是否有效
	 * @param valid 是否有效
	 * @return 当前对象
	*/
	public DemoC2 setValid(Integer valid) {
		this.valid=valid;
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
	public DemoC2 setCreateBy(String createBy) {
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
	public DemoC2 setCreateTime(Date createTime) {
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
	public DemoC2 setUpdateBy(String updateBy) {
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
	public DemoC2 setUpdateTime(Date updateTime) {
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
	public DemoC2 setDeleted(Integer deleted) {
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
	public DemoC2 setDeleted(Boolean deletedBool) {
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
	public DemoC2 setDeleteBy(String deleteBy) {
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
	public DemoC2 setDeleteTime(Date deleteTime) {
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
	public DemoC2 setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DemoC2 , 转换好的 DemoC2 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DemoC2 , 转换好的 PoJo 对象
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
	public DemoC2 clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DemoC2 duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.DemoC2Meta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.DemoC2Meta.$$proxy$$();
		inst.setValid(this.getValid());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setPrice(this.getPrice());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setTitle(this.getTitle());
		inst.setVersion(this.getVersion());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DemoC2 clone(boolean deep) {
		return EntityContext.clone(DemoC2.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DemoC2
	 * @param demoC2Map 包含实体信息的 Map 对象
	 * @return DemoC2 , 转换好的的 DemoC2 对象
	*/
	@Transient
	public static DemoC2 createFrom(Map<String,Object> demoC2Map) {
		if(demoC2Map==null) return null;
		DemoC2 po = create();
		EntityContext.copyProperties(po,demoC2Map);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DemoC2
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DemoC2 , 转换好的的 DemoC2 对象
	*/
	@Transient
	public static DemoC2 createFrom(Object pojo) {
		if(pojo==null) return null;
		DemoC2 po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DemoC2，等同于 new
	 * @return DemoC2 对象
	*/
	@Transient
	public static DemoC2 create() {
		return new com.dt.platform.domain.eam.meta.DemoC2Meta.$$proxy$$();
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
			this.setValid(DataParser.parse(Integer.class, map.get(DemoC2Meta.VALID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DemoC2Meta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DemoC2Meta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DemoC2Meta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DemoC2Meta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DemoC2Meta.DELETE_TIME)));
			this.setPrice(DataParser.parse(BigDecimal.class, map.get(DemoC2Meta.PRICE)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DemoC2Meta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DemoC2Meta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(DemoC2Meta.ID)));
			this.setTitle(DataParser.parse(String.class, map.get(DemoC2Meta.TITLE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DemoC2Meta.VERSION)));
			// others
			return true;
		} else {
			try {
				this.setValid( (Integer)map.get(DemoC2Meta.VALID));
				this.setCreateBy( (String)map.get(DemoC2Meta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DemoC2Meta.DELETED));
				this.setCreateTime( (Date)map.get(DemoC2Meta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(DemoC2Meta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DemoC2Meta.DELETE_TIME));
				this.setPrice( (BigDecimal)map.get(DemoC2Meta.PRICE));
				this.setDeleteBy( (String)map.get(DemoC2Meta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(DemoC2Meta.UPDATE_TIME));
				this.setId( (String)map.get(DemoC2Meta.ID));
				this.setTitle( (String)map.get(DemoC2Meta.TITLE));
				this.setVersion( (Integer)map.get(DemoC2Meta.VERSION));
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
			this.setValid(DataParser.parse(Integer.class, r.getValue(DemoC2Meta.VALID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DemoC2Meta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DemoC2Meta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DemoC2Meta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DemoC2Meta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DemoC2Meta.DELETE_TIME)));
			this.setPrice(DataParser.parse(BigDecimal.class, r.getValue(DemoC2Meta.PRICE)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DemoC2Meta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DemoC2Meta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(DemoC2Meta.ID)));
			this.setTitle(DataParser.parse(String.class, r.getValue(DemoC2Meta.TITLE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DemoC2Meta.VERSION)));
			return true;
		} else {
			try {
				this.setValid( (Integer)r.getValue(DemoC2Meta.VALID));
				this.setCreateBy( (String)r.getValue(DemoC2Meta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DemoC2Meta.DELETED));
				this.setCreateTime( (Date)r.getValue(DemoC2Meta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(DemoC2Meta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DemoC2Meta.DELETE_TIME));
				this.setPrice( (BigDecimal)r.getValue(DemoC2Meta.PRICE));
				this.setDeleteBy( (String)r.getValue(DemoC2Meta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(DemoC2Meta.UPDATE_TIME));
				this.setId( (String)r.getValue(DemoC2Meta.ID));
				this.setTitle( (String)r.getValue(DemoC2Meta.TITLE));
				this.setVersion( (Integer)r.getValue(DemoC2Meta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}