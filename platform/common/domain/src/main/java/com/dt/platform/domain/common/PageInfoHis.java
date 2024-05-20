package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_PAGE_INFO_HIS;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.PageInfoHisMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 页面历史
 * <p>页面历史 , 数据表 sys_page_info_his 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-20 08:15:37
 * @sign CA96C56698E4B69C93F20BE899E0ABF0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_page_info_his")
@ApiModel(description = "页面历史 ; 页面历史 , 数据表 sys_page_info_his 的PO类型")
public class PageInfoHis extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_PAGE_INFO_HIS.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String pageId;
	
	/**
	 * 定义：定义
	*/
	@ApiModelProperty(required = false,value="定义" , notes = "定义")
	private String defJson;
	
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
	@ApiModelProperty(required = false,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * pageInfo：pageInfo
	*/
	@ApiModelProperty(required = false,value="pageInfo" , notes = "pageInfo")
	private PageInfo pageInfo;
	
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
	public PageInfoHis setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getPageId() {
		return pageId;
	}
	
	/**
	 * 设置 名称
	 * @param pageId 名称
	 * @return 当前对象
	*/
	public PageInfoHis setPageId(String pageId) {
		this.pageId=pageId;
		return this;
	}
	
	/**
	 * 获得 定义<br>
	 * 定义
	 * @return 定义
	*/
	public String getDefJson() {
		return defJson;
	}
	
	/**
	 * 设置 定义
	 * @param defJson 定义
	 * @return 当前对象
	*/
	public PageInfoHis setDefJson(String defJson) {
		this.defJson=defJson;
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
	public PageInfoHis setCreateBy(String createBy) {
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
	public PageInfoHis setCreateTime(Date createTime) {
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
	public PageInfoHis setUpdateBy(String updateBy) {
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
	public PageInfoHis setUpdateTime(Date updateTime) {
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
	public PageInfoHis setDeleted(Integer deleted) {
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
	public PageInfoHis setDeleted(Boolean deletedBool) {
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
	public PageInfoHis setDeleteBy(String deleteBy) {
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
	public PageInfoHis setDeleteTime(Date deleteTime) {
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
	public PageInfoHis setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 pageInfo<br>
	 * pageInfo
	 * @return pageInfo
	*/
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	
	/**
	 * 设置 pageInfo
	 * @param pageInfo pageInfo
	 * @return 当前对象
	*/
	public PageInfoHis setPageInfo(PageInfo pageInfo) {
		this.pageInfo=pageInfo;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PageInfoHis , 转换好的 PageInfoHis 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PageInfoHis , 转换好的 PoJo 对象
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
	public PageInfoHis clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PageInfoHis duplicate(boolean all) {
		com.dt.platform.domain.common.meta.PageInfoHisMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.PageInfoHisMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setDefJson(this.getDefJson());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setPageId(this.getPageId());
		inst.setVersion(this.getVersion());
		if(all) {
			inst.setPageInfo(this.getPageInfo());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PageInfoHis clone(boolean deep) {
		return EntityContext.clone(PageInfoHis.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PageInfoHis
	 * @param pageInfoHisMap 包含实体信息的 Map 对象
	 * @return PageInfoHis , 转换好的的 PageInfoHis 对象
	*/
	@Transient
	public static PageInfoHis createFrom(Map<String,Object> pageInfoHisMap) {
		if(pageInfoHisMap==null) return null;
		PageInfoHis po = create();
		EntityContext.copyProperties(po,pageInfoHisMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PageInfoHis
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PageInfoHis , 转换好的的 PageInfoHis 对象
	*/
	@Transient
	public static PageInfoHis createFrom(Object pojo) {
		if(pojo==null) return null;
		PageInfoHis po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PageInfoHis，等同于 new
	 * @return PageInfoHis 对象
	*/
	@Transient
	public static PageInfoHis create() {
		return new com.dt.platform.domain.common.meta.PageInfoHisMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(PageInfoHisMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PageInfoHisMeta.DELETED)));
			this.setDefJson(DataParser.parse(String.class, map.get(PageInfoHisMeta.DEF_JSON)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PageInfoHisMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PageInfoHisMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PageInfoHisMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PageInfoHisMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PageInfoHisMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(PageInfoHisMeta.ID)));
			this.setPageId(DataParser.parse(String.class, map.get(PageInfoHisMeta.PAGE_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PageInfoHisMeta.VERSION)));
			// others
			this.setPageInfo(DataParser.parse(PageInfo.class, map.get(PageInfoHisMeta.PAGE_INFO)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(PageInfoHisMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PageInfoHisMeta.DELETED));
				this.setDefJson( (String)map.get(PageInfoHisMeta.DEF_JSON));
				this.setCreateTime( (Date)map.get(PageInfoHisMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PageInfoHisMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PageInfoHisMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(PageInfoHisMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(PageInfoHisMeta.UPDATE_TIME));
				this.setId( (String)map.get(PageInfoHisMeta.ID));
				this.setPageId( (String)map.get(PageInfoHisMeta.PAGE_ID));
				this.setVersion( (Integer)map.get(PageInfoHisMeta.VERSION));
				// others
				this.setPageInfo( (PageInfo)map.get(PageInfoHisMeta.PAGE_INFO));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PageInfoHisMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PageInfoHisMeta.DELETED)));
			this.setDefJson(DataParser.parse(String.class, r.getValue(PageInfoHisMeta.DEF_JSON)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PageInfoHisMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PageInfoHisMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PageInfoHisMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PageInfoHisMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PageInfoHisMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(PageInfoHisMeta.ID)));
			this.setPageId(DataParser.parse(String.class, r.getValue(PageInfoHisMeta.PAGE_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PageInfoHisMeta.VERSION)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(PageInfoHisMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PageInfoHisMeta.DELETED));
				this.setDefJson( (String)r.getValue(PageInfoHisMeta.DEF_JSON));
				this.setCreateTime( (Date)r.getValue(PageInfoHisMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PageInfoHisMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PageInfoHisMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(PageInfoHisMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(PageInfoHisMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(PageInfoHisMeta.ID));
				this.setPageId( (String)r.getValue(PageInfoHisMeta.PAGE_ID));
				this.setVersion( (Integer)r.getValue(PageInfoHisMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}