package com.dt.platform.domain.oa;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OaTables.OA_NOTICE;
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
import com.dt.platform.domain.oa.meta.NoticeMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 通知公告
 * <p>通知公告 , 数据表 oa_notice 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-05-11 13:29:34
 * @sign 541058C8E8B1530009C72925E13879A0
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "oa_notice")
@ApiModel(description = "通知公告 ; 通知公告 , 数据表 oa_notice 的PO类型")
public class Notice extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OA_NOTICE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "708211477789540352")
	private String id;
	
	/**
	 * 文号：文号
	*/
	@ApiModelProperty(required = false,value="文号" , notes = "文号" , example = "12121212")
	private String number;
	
	/**
	 * 标题：标题
	*/
	@ApiModelProperty(required = false,value="标题" , notes = "标题" , example = "1212")
	private String title;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 分类：分类
	*/
	@ApiModelProperty(required = false,value="分类" , notes = "分类" , example = "notice")
	private String type;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容" , example = "<p>1212</p>")
	private String content;
	
	/**
	 * 是否置顶：是否置顶
	*/
	@ApiModelProperty(required = false,value="是否置顶" , notes = "是否置顶" , example = "N")
	private String iftop;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attach;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-05-09 06:59:34")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-05-11 12:25:24")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "3")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private DictItem typeData;
	
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
	public Notice setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 文号<br>
	 * 文号
	 * @return 文号
	*/
	public String getNumber() {
		return number;
	}
	
	/**
	 * 设置 文号
	 * @param number 文号
	 * @return 当前对象
	*/
	public Notice setNumber(String number) {
		this.number=number;
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
	public Notice setTitle(String title) {
		this.title=title;
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
	public Notice setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 分类<br>
	 * 分类
	 * @return 分类
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 分类
	 * @param type 分类
	 * @return 当前对象
	*/
	public Notice setType(String type) {
		this.type=type;
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
	public Notice setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 是否置顶<br>
	 * 是否置顶
	 * @return 是否置顶
	*/
	public String getIftop() {
		return iftop;
	}
	
	/**
	 * 设置 是否置顶
	 * @param iftop 是否置顶
	 * @return 当前对象
	*/
	public Notice setIftop(String iftop) {
		this.iftop=iftop;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getAttach() {
		return attach;
	}
	
	/**
	 * 设置 附件
	 * @param attach 附件
	 * @return 当前对象
	*/
	public Notice setAttach(String attach) {
		this.attach=attach;
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
	public Notice setCreateBy(String createBy) {
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
	public Notice setCreateTime(Date createTime) {
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
	public Notice setUpdateBy(String updateBy) {
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
	public Notice setUpdateTime(Date updateTime) {
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
	public Notice setDeleted(Integer deleted) {
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
	public Notice setDeleted(Boolean deletedBool) {
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
	public Notice setDeleteBy(String deleteBy) {
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
	public Notice setDeleteTime(Date deleteTime) {
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
	public Notice setVersion(Integer version) {
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
	public Notice setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public DictItem getTypeData() {
		return typeData;
	}
	
	/**
	 * 设置 类型
	 * @param typeData 类型
	 * @return 当前对象
	*/
	public Notice setTypeData(DictItem typeData) {
		this.typeData=typeData;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Notice , 转换好的 Notice 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Notice , 转换好的 PoJo 对象
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
	public Notice clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Notice duplicate(boolean all) {
		com.dt.platform.domain.oa.meta.NoticeMeta.$$proxy$$ inst = new com.dt.platform.domain.oa.meta.NoticeMeta.$$proxy$$();
		inst.setUpdateTime(this.getUpdateTime());
		inst.setTitle(this.getTitle());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setIftop(this.getIftop());
		inst.setNumber(this.getNumber());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setAttach(this.getAttach());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setTypeData(this.getTypeData());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Notice clone(boolean deep) {
		return EntityContext.clone(Notice.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Notice
	 * @param noticeMap 包含实体信息的 Map 对象
	 * @return Notice , 转换好的的 Notice 对象
	*/
	@Transient
	public static Notice createFrom(Map<String,Object> noticeMap) {
		if(noticeMap==null) return null;
		Notice po = create();
		EntityContext.copyProperties(po,noticeMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Notice
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Notice , 转换好的的 Notice 对象
	*/
	@Transient
	public static Notice createFrom(Object pojo) {
		if(pojo==null) return null;
		Notice po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Notice，等同于 new
	 * @return Notice 对象
	*/
	@Transient
	public static Notice create() {
		return new com.dt.platform.domain.oa.meta.NoticeMeta.$$proxy$$();
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
			this.setUpdateTime(DataParser.parse(Date.class, map.get(NoticeMeta.UPDATE_TIME)));
			this.setTitle(DataParser.parse(String.class, map.get(NoticeMeta.TITLE)));
			this.setType(DataParser.parse(String.class, map.get(NoticeMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(NoticeMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(NoticeMeta.CONTENT)));
			this.setIftop(DataParser.parse(String.class, map.get(NoticeMeta.IFTOP)));
			this.setNumber(DataParser.parse(String.class, map.get(NoticeMeta.NUMBER)));
			this.setCreateBy(DataParser.parse(String.class, map.get(NoticeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(NoticeMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(NoticeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(NoticeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(NoticeMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(NoticeMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(NoticeMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(NoticeMeta.ID)));
			this.setAttach(DataParser.parse(String.class, map.get(NoticeMeta.ATTACH)));
			this.setStatus(DataParser.parse(String.class, map.get(NoticeMeta.STATUS)));
			// others
			this.setTypeData(DataParser.parse(DictItem.class, map.get(NoticeMeta.TYPE_DATA)));
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)map.get(NoticeMeta.UPDATE_TIME));
				this.setTitle( (String)map.get(NoticeMeta.TITLE));
				this.setType( (String)map.get(NoticeMeta.TYPE));
				this.setVersion( (Integer)map.get(NoticeMeta.VERSION));
				this.setContent( (String)map.get(NoticeMeta.CONTENT));
				this.setIftop( (String)map.get(NoticeMeta.IFTOP));
				this.setNumber( (String)map.get(NoticeMeta.NUMBER));
				this.setCreateBy( (String)map.get(NoticeMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(NoticeMeta.DELETED));
				this.setCreateTime( (Date)map.get(NoticeMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(NoticeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(NoticeMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(NoticeMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(NoticeMeta.DELETE_BY));
				this.setId( (String)map.get(NoticeMeta.ID));
				this.setAttach( (String)map.get(NoticeMeta.ATTACH));
				this.setStatus( (String)map.get(NoticeMeta.STATUS));
				// others
				this.setTypeData( (DictItem)map.get(NoticeMeta.TYPE_DATA));
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
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(NoticeMeta.UPDATE_TIME)));
			this.setTitle(DataParser.parse(String.class, r.getValue(NoticeMeta.TITLE)));
			this.setType(DataParser.parse(String.class, r.getValue(NoticeMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(NoticeMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(NoticeMeta.CONTENT)));
			this.setIftop(DataParser.parse(String.class, r.getValue(NoticeMeta.IFTOP)));
			this.setNumber(DataParser.parse(String.class, r.getValue(NoticeMeta.NUMBER)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(NoticeMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(NoticeMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(NoticeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(NoticeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(NoticeMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(NoticeMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(NoticeMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(NoticeMeta.ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(NoticeMeta.ATTACH)));
			this.setStatus(DataParser.parse(String.class, r.getValue(NoticeMeta.STATUS)));
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)r.getValue(NoticeMeta.UPDATE_TIME));
				this.setTitle( (String)r.getValue(NoticeMeta.TITLE));
				this.setType( (String)r.getValue(NoticeMeta.TYPE));
				this.setVersion( (Integer)r.getValue(NoticeMeta.VERSION));
				this.setContent( (String)r.getValue(NoticeMeta.CONTENT));
				this.setIftop( (String)r.getValue(NoticeMeta.IFTOP));
				this.setNumber( (String)r.getValue(NoticeMeta.NUMBER));
				this.setCreateBy( (String)r.getValue(NoticeMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(NoticeMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(NoticeMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(NoticeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(NoticeMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(NoticeMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(NoticeMeta.DELETE_BY));
				this.setId( (String)r.getValue(NoticeMeta.ID));
				this.setAttach( (String)r.getValue(NoticeMeta.ATTACH));
				this.setStatus( (String)r.getValue(NoticeMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}