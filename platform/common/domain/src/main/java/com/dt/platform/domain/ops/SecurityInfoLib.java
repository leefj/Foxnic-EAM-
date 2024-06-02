package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_SECURITY_INFO_LIB;
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
import com.dt.platform.domain.ops.meta.SecurityInfoLibMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 安全漏洞信息库
 * <p>安全漏洞信息库 , 数据表 ops_security_info_lib 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-05-31 09:59:02
 * @sign E50D273BC80951418D27F156C2AF956C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_security_info_lib")
@ApiModel(description = "安全漏洞信息库 ; 安全漏洞信息库 , 数据表 ops_security_info_lib 的PO类型")
public class SecurityInfoLib extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_SECURITY_INFO_LIB.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "848577244291923968")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "1212")
	private String name;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private String type;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "来源")
	private String source;
	
	/**
	 * 来源说明：来源说明
	*/
	@ApiModelProperty(required = false,value="来源说明" , notes = "来源说明")
	private String sourceName;
	
	/**
	 * 风险等级：风险等级
	*/
	@ApiModelProperty(required = false,value="风险等级" , notes = "风险等级")
	private String secLevel;
	
	/**
	 * 影响范围：影响范围
	*/
	@ApiModelProperty(required = false,value="影响范围" , notes = "影响范围" , example = "12121212")
	private String dataScore;
	
	/**
	 * 处理方式：处理方式
	*/
	@ApiModelProperty(required = false,value="处理方式" , notes = "处理方式")
	private String processCt;
	
	/**
	 * 发现时间：发现时间
	*/
	@ApiModelProperty(required = false,value="发现时间" , notes = "发现时间" , example = "2024-05-15 12:00:00")
	private Date businessData;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-05-30 03:03:01")
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
	@ApiModelProperty(required = false,value="version" , notes = "version" , example = "1")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * typeDict：typeDict
	*/
	@ApiModelProperty(required = false,value="typeDict" , notes = "typeDict")
	private DictItem typeDict;
	
	/**
	 * sourceDict：sourceDict
	*/
	@ApiModelProperty(required = false,value="sourceDict" , notes = "sourceDict")
	private DictItem sourceDict;
	
	/**
	 * levelDict：levelDict
	*/
	@ApiModelProperty(required = false,value="levelDict" , notes = "levelDict")
	private DictItem levelDict;
	
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
	public SecurityInfoLib setId(String id) {
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
	public SecurityInfoLib setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public SecurityInfoLib setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 来源<br>
	 * 来源
	 * @return 来源
	*/
	public String getSource() {
		return source;
	}
	
	/**
	 * 设置 来源
	 * @param source 来源
	 * @return 当前对象
	*/
	public SecurityInfoLib setSource(String source) {
		this.source=source;
		return this;
	}
	
	/**
	 * 获得 来源说明<br>
	 * 来源说明
	 * @return 来源说明
	*/
	public String getSourceName() {
		return sourceName;
	}
	
	/**
	 * 设置 来源说明
	 * @param sourceName 来源说明
	 * @return 当前对象
	*/
	public SecurityInfoLib setSourceName(String sourceName) {
		this.sourceName=sourceName;
		return this;
	}
	
	/**
	 * 获得 风险等级<br>
	 * 风险等级
	 * @return 风险等级
	*/
	public String getSecLevel() {
		return secLevel;
	}
	
	/**
	 * 设置 风险等级
	 * @param secLevel 风险等级
	 * @return 当前对象
	*/
	public SecurityInfoLib setSecLevel(String secLevel) {
		this.secLevel=secLevel;
		return this;
	}
	
	/**
	 * 获得 影响范围<br>
	 * 影响范围
	 * @return 影响范围
	*/
	public String getDataScore() {
		return dataScore;
	}
	
	/**
	 * 设置 影响范围
	 * @param dataScore 影响范围
	 * @return 当前对象
	*/
	public SecurityInfoLib setDataScore(String dataScore) {
		this.dataScore=dataScore;
		return this;
	}
	
	/**
	 * 获得 处理方式<br>
	 * 处理方式
	 * @return 处理方式
	*/
	public String getProcessCt() {
		return processCt;
	}
	
	/**
	 * 设置 处理方式
	 * @param processCt 处理方式
	 * @return 当前对象
	*/
	public SecurityInfoLib setProcessCt(String processCt) {
		this.processCt=processCt;
		return this;
	}
	
	/**
	 * 获得 发现时间<br>
	 * 发现时间
	 * @return 发现时间
	*/
	public Date getBusinessData() {
		return businessData;
	}
	
	/**
	 * 设置 发现时间
	 * @param businessData 发现时间
	 * @return 当前对象
	*/
	public SecurityInfoLib setBusinessData(Date businessData) {
		this.businessData=businessData;
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
	public SecurityInfoLib setNotes(String notes) {
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
	public SecurityInfoLib setCreateBy(String createBy) {
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
	public SecurityInfoLib setCreateTime(Date createTime) {
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
	public SecurityInfoLib setUpdateBy(String updateBy) {
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
	public SecurityInfoLib setUpdateTime(Date updateTime) {
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
	public SecurityInfoLib setDeleted(Integer deleted) {
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
	public SecurityInfoLib setDeleted(Boolean deletedBool) {
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
	public SecurityInfoLib setDeleteBy(String deleteBy) {
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
	public SecurityInfoLib setDeleteTime(Date deleteTime) {
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
	public SecurityInfoLib setVersion(Integer version) {
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
	public SecurityInfoLib setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 typeDict<br>
	 * typeDict
	 * @return typeDict
	*/
	public DictItem getTypeDict() {
		return typeDict;
	}
	
	/**
	 * 设置 typeDict
	 * @param typeDict typeDict
	 * @return 当前对象
	*/
	public SecurityInfoLib setTypeDict(DictItem typeDict) {
		this.typeDict=typeDict;
		return this;
	}
	
	/**
	 * 获得 sourceDict<br>
	 * sourceDict
	 * @return sourceDict
	*/
	public DictItem getSourceDict() {
		return sourceDict;
	}
	
	/**
	 * 设置 sourceDict
	 * @param sourceDict sourceDict
	 * @return 当前对象
	*/
	public SecurityInfoLib setSourceDict(DictItem sourceDict) {
		this.sourceDict=sourceDict;
		return this;
	}
	
	/**
	 * 获得 levelDict<br>
	 * levelDict
	 * @return levelDict
	*/
	public DictItem getLevelDict() {
		return levelDict;
	}
	
	/**
	 * 设置 levelDict
	 * @param levelDict levelDict
	 * @return 当前对象
	*/
	public SecurityInfoLib setLevelDict(DictItem levelDict) {
		this.levelDict=levelDict;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SecurityInfoLib , 转换好的 SecurityInfoLib 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SecurityInfoLib , 转换好的 PoJo 对象
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
	public SecurityInfoLib clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SecurityInfoLib duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.SecurityInfoLibMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.SecurityInfoLibMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSource(this.getSource());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setDataScore(this.getDataScore());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setBusinessData(this.getBusinessData());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setSecLevel(this.getSecLevel());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setSourceName(this.getSourceName());
		inst.setProcessCt(this.getProcessCt());
		if(all) {
			inst.setTypeDict(this.getTypeDict());
			inst.setSourceDict(this.getSourceDict());
			inst.setLevelDict(this.getLevelDict());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SecurityInfoLib clone(boolean deep) {
		return EntityContext.clone(SecurityInfoLib.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SecurityInfoLib
	 * @param securityInfoLibMap 包含实体信息的 Map 对象
	 * @return SecurityInfoLib , 转换好的的 SecurityInfoLib 对象
	*/
	@Transient
	public static SecurityInfoLib createFrom(Map<String,Object> securityInfoLibMap) {
		if(securityInfoLibMap==null) return null;
		SecurityInfoLib po = create();
		EntityContext.copyProperties(po,securityInfoLibMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 SecurityInfoLib
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SecurityInfoLib , 转换好的的 SecurityInfoLib 对象
	*/
	@Transient
	public static SecurityInfoLib createFrom(Object pojo) {
		if(pojo==null) return null;
		SecurityInfoLib po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 SecurityInfoLib，等同于 new
	 * @return SecurityInfoLib 对象
	*/
	@Transient
	public static SecurityInfoLib create() {
		return new com.dt.platform.domain.ops.meta.SecurityInfoLibMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(SecurityInfoLibMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SecurityInfoLibMeta.UPDATE_TIME)));
			this.setSource(DataParser.parse(String.class, map.get(SecurityInfoLibMeta.SOURCE)));
			this.setType(DataParser.parse(String.class, map.get(SecurityInfoLibMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SecurityInfoLibMeta.VERSION)));
			this.setDataScore(DataParser.parse(String.class, map.get(SecurityInfoLibMeta.DATA_SCORE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SecurityInfoLibMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SecurityInfoLibMeta.DELETED)));
			this.setBusinessData(DataParser.parse(Date.class, map.get(SecurityInfoLibMeta.BUSINESS_DATA)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SecurityInfoLibMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SecurityInfoLibMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SecurityInfoLibMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(SecurityInfoLibMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(SecurityInfoLibMeta.TENANT_ID)));
			this.setSecLevel(DataParser.parse(String.class, map.get(SecurityInfoLibMeta.SEC_LEVEL)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SecurityInfoLibMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(SecurityInfoLibMeta.ID)));
			this.setSourceName(DataParser.parse(String.class, map.get(SecurityInfoLibMeta.SOURCE_NAME)));
			this.setProcessCt(DataParser.parse(String.class, map.get(SecurityInfoLibMeta.PROCESS_CT)));
			// others
			this.setTypeDict(DataParser.parse(DictItem.class, map.get(SecurityInfoLibMeta.TYPE_DICT)));
			this.setSourceDict(DataParser.parse(DictItem.class, map.get(SecurityInfoLibMeta.SOURCE_DICT)));
			this.setLevelDict(DataParser.parse(DictItem.class, map.get(SecurityInfoLibMeta.LEVEL_DICT)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(SecurityInfoLibMeta.NOTES));
				this.setUpdateTime( (Date)map.get(SecurityInfoLibMeta.UPDATE_TIME));
				this.setSource( (String)map.get(SecurityInfoLibMeta.SOURCE));
				this.setType( (String)map.get(SecurityInfoLibMeta.TYPE));
				this.setVersion( (Integer)map.get(SecurityInfoLibMeta.VERSION));
				this.setDataScore( (String)map.get(SecurityInfoLibMeta.DATA_SCORE));
				this.setCreateBy( (String)map.get(SecurityInfoLibMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(SecurityInfoLibMeta.DELETED));
				this.setBusinessData( (Date)map.get(SecurityInfoLibMeta.BUSINESS_DATA));
				this.setCreateTime( (Date)map.get(SecurityInfoLibMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SecurityInfoLibMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SecurityInfoLibMeta.DELETE_TIME));
				this.setName( (String)map.get(SecurityInfoLibMeta.NAME));
				this.setTenantId( (String)map.get(SecurityInfoLibMeta.TENANT_ID));
				this.setSecLevel( (String)map.get(SecurityInfoLibMeta.SEC_LEVEL));
				this.setDeleteBy( (String)map.get(SecurityInfoLibMeta.DELETE_BY));
				this.setId( (String)map.get(SecurityInfoLibMeta.ID));
				this.setSourceName( (String)map.get(SecurityInfoLibMeta.SOURCE_NAME));
				this.setProcessCt( (String)map.get(SecurityInfoLibMeta.PROCESS_CT));
				// others
				this.setTypeDict( (DictItem)map.get(SecurityInfoLibMeta.TYPE_DICT));
				this.setSourceDict( (DictItem)map.get(SecurityInfoLibMeta.SOURCE_DICT));
				this.setLevelDict( (DictItem)map.get(SecurityInfoLibMeta.LEVEL_DICT));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(SecurityInfoLibMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SecurityInfoLibMeta.UPDATE_TIME)));
			this.setSource(DataParser.parse(String.class, r.getValue(SecurityInfoLibMeta.SOURCE)));
			this.setType(DataParser.parse(String.class, r.getValue(SecurityInfoLibMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SecurityInfoLibMeta.VERSION)));
			this.setDataScore(DataParser.parse(String.class, r.getValue(SecurityInfoLibMeta.DATA_SCORE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SecurityInfoLibMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SecurityInfoLibMeta.DELETED)));
			this.setBusinessData(DataParser.parse(Date.class, r.getValue(SecurityInfoLibMeta.BUSINESS_DATA)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SecurityInfoLibMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SecurityInfoLibMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SecurityInfoLibMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(SecurityInfoLibMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SecurityInfoLibMeta.TENANT_ID)));
			this.setSecLevel(DataParser.parse(String.class, r.getValue(SecurityInfoLibMeta.SEC_LEVEL)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SecurityInfoLibMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(SecurityInfoLibMeta.ID)));
			this.setSourceName(DataParser.parse(String.class, r.getValue(SecurityInfoLibMeta.SOURCE_NAME)));
			this.setProcessCt(DataParser.parse(String.class, r.getValue(SecurityInfoLibMeta.PROCESS_CT)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(SecurityInfoLibMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(SecurityInfoLibMeta.UPDATE_TIME));
				this.setSource( (String)r.getValue(SecurityInfoLibMeta.SOURCE));
				this.setType( (String)r.getValue(SecurityInfoLibMeta.TYPE));
				this.setVersion( (Integer)r.getValue(SecurityInfoLibMeta.VERSION));
				this.setDataScore( (String)r.getValue(SecurityInfoLibMeta.DATA_SCORE));
				this.setCreateBy( (String)r.getValue(SecurityInfoLibMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(SecurityInfoLibMeta.DELETED));
				this.setBusinessData( (Date)r.getValue(SecurityInfoLibMeta.BUSINESS_DATA));
				this.setCreateTime( (Date)r.getValue(SecurityInfoLibMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SecurityInfoLibMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SecurityInfoLibMeta.DELETE_TIME));
				this.setName( (String)r.getValue(SecurityInfoLibMeta.NAME));
				this.setTenantId( (String)r.getValue(SecurityInfoLibMeta.TENANT_ID));
				this.setSecLevel( (String)r.getValue(SecurityInfoLibMeta.SEC_LEVEL));
				this.setDeleteBy( (String)r.getValue(SecurityInfoLibMeta.DELETE_BY));
				this.setId( (String)r.getValue(SecurityInfoLibMeta.ID));
				this.setSourceName( (String)r.getValue(SecurityInfoLibMeta.SOURCE_NAME));
				this.setProcessCt( (String)r.getValue(SecurityInfoLibMeta.PROCESS_CT));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}