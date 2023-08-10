package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_GOODS_STOCK_USAGE;
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
import com.dt.platform.domain.eam.meta.GoodsStockUsageMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 使用情况
 * <p>使用情况 , 数据表 eam_goods_stock_usage 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-08-10 22:43:44
 * @sign 929AB0F10897B854B35277978AB37E82
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_goods_stock_usage")
@ApiModel(description = "使用情况 ; 使用情况 , 数据表 eam_goods_stock_usage 的PO类型")
public class GoodsStockUsage extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_GOODS_STOCK_USAGE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "742148400140517376")
	private String id;
	
	/**
	 * 所属：所属
	*/
	@ApiModelProperty(required = false,value="所属" , notes = "所属" , example = "742148400027271168")
	private String ownerId;
	
	/**
	 * 单据编码：单据编码
	*/
	@ApiModelProperty(required = false,value="单据编码" , notes = "单据编码" , example = "PI202332102232372")
	private String billCode;
	
	/**
	 * 操作标签：操作标签
	*/
	@ApiModelProperty(required = false,value="操作标签" , notes = "操作标签" , example = "入库")
	private String label;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容" , example = "资产入库完成")
	private String content;
	
	/**
	 * 数量：数量
	*/
	@ApiModelProperty(required = false,value="数量" , notes = "数量" , example = "1")
	private String operNumber;
	
	/**
	 * 操作：操作
	*/
	@ApiModelProperty(required = false,value="操作" , notes = "操作" , example = "in")
	private String oper;
	
	/**
	 * 操作人员：操作人员
	*/
	@ApiModelProperty(required = false,value="操作人员" , notes = "操作人员" , example = "E001")
	private String operUserId;
	
	/**
	 * 操作人员：操作人员
	*/
	@ApiModelProperty(required = false,value="操作人员" , notes = "操作人员" , example = "管理员")
	private String operUserName;
	
	/**
	 * 记录时间：记录时间
	*/
	@ApiModelProperty(required = false,value="记录时间" , notes = "记录时间" , example = "2023-08-10 10:32:47")
	private Date recTime;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-08-10 10:32:47")
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
	 * opsUser：opsUser
	*/
	@ApiModelProperty(required = false,value="opsUser" , notes = "opsUser")
	private Employee opsUser;
	
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
	public GoodsStockUsage setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 所属<br>
	 * 所属
	 * @return 所属
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 所属
	 * @param ownerId 所属
	 * @return 当前对象
	*/
	public GoodsStockUsage setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 单据编码<br>
	 * 单据编码
	 * @return 单据编码
	*/
	public String getBillCode() {
		return billCode;
	}
	
	/**
	 * 设置 单据编码
	 * @param billCode 单据编码
	 * @return 当前对象
	*/
	public GoodsStockUsage setBillCode(String billCode) {
		this.billCode=billCode;
		return this;
	}
	
	/**
	 * 获得 操作标签<br>
	 * 操作标签
	 * @return 操作标签
	*/
	public String getLabel() {
		return label;
	}
	
	/**
	 * 设置 操作标签
	 * @param label 操作标签
	 * @return 当前对象
	*/
	public GoodsStockUsage setLabel(String label) {
		this.label=label;
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
	public GoodsStockUsage setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 数量<br>
	 * 数量
	 * @return 数量
	*/
	public String getOperNumber() {
		return operNumber;
	}
	
	/**
	 * 设置 数量
	 * @param operNumber 数量
	 * @return 当前对象
	*/
	public GoodsStockUsage setOperNumber(String operNumber) {
		this.operNumber=operNumber;
		return this;
	}
	
	/**
	 * 获得 操作<br>
	 * 操作
	 * @return 操作
	*/
	public String getOper() {
		return oper;
	}
	
	/**
	 * 设置 操作
	 * @param oper 操作
	 * @return 当前对象
	*/
	public GoodsStockUsage setOper(String oper) {
		this.oper=oper;
		return this;
	}
	
	/**
	 * 获得 操作人员<br>
	 * 操作人员
	 * @return 操作人员
	*/
	public String getOperUserId() {
		return operUserId;
	}
	
	/**
	 * 设置 操作人员
	 * @param operUserId 操作人员
	 * @return 当前对象
	*/
	public GoodsStockUsage setOperUserId(String operUserId) {
		this.operUserId=operUserId;
		return this;
	}
	
	/**
	 * 获得 操作人员<br>
	 * 操作人员
	 * @return 操作人员
	*/
	public String getOperUserName() {
		return operUserName;
	}
	
	/**
	 * 设置 操作人员
	 * @param operUserName 操作人员
	 * @return 当前对象
	*/
	public GoodsStockUsage setOperUserName(String operUserName) {
		this.operUserName=operUserName;
		return this;
	}
	
	/**
	 * 获得 记录时间<br>
	 * 记录时间
	 * @return 记录时间
	*/
	public Date getRecTime() {
		return recTime;
	}
	
	/**
	 * 设置 记录时间
	 * @param recTime 记录时间
	 * @return 当前对象
	*/
	public GoodsStockUsage setRecTime(Date recTime) {
		this.recTime=recTime;
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
	public GoodsStockUsage setCreateBy(String createBy) {
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
	public GoodsStockUsage setCreateTime(Date createTime) {
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
	public GoodsStockUsage setUpdateBy(String updateBy) {
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
	public GoodsStockUsage setUpdateTime(Date updateTime) {
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
	public GoodsStockUsage setDeleted(Integer deleted) {
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
	public GoodsStockUsage setDeleted(Boolean deletedBool) {
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
	public GoodsStockUsage setDeleteBy(String deleteBy) {
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
	public GoodsStockUsage setDeleteTime(Date deleteTime) {
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
	public GoodsStockUsage setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 opsUser<br>
	 * opsUser
	 * @return opsUser
	*/
	public Employee getOpsUser() {
		return opsUser;
	}
	
	/**
	 * 设置 opsUser
	 * @param opsUser opsUser
	 * @return 当前对象
	*/
	public GoodsStockUsage setOpsUser(Employee opsUser) {
		this.opsUser=opsUser;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return GoodsStockUsage , 转换好的 GoodsStockUsage 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return GoodsStockUsage , 转换好的 PoJo 对象
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
	public GoodsStockUsage clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public GoodsStockUsage duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.GoodsStockUsageMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.GoodsStockUsageMeta.$$proxy$$();
		inst.setOperUserId(this.getOperUserId());
		inst.setRecTime(this.getRecTime());
		inst.setBillCode(this.getBillCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setLabel(this.getLabel());
		inst.setOwnerId(this.getOwnerId());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setOperNumber(this.getOperNumber());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setOperUserName(this.getOperUserName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setOper(this.getOper());
		inst.setId(this.getId());
		if(all) {
			inst.setOpsUser(this.getOpsUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public GoodsStockUsage clone(boolean deep) {
		return EntityContext.clone(GoodsStockUsage.class,this,deep);
	}

	/**
	 * 将 Map 转换成 GoodsStockUsage
	 * @param goodsStockUsageMap 包含实体信息的 Map 对象
	 * @return GoodsStockUsage , 转换好的的 GoodsStockUsage 对象
	*/
	@Transient
	public static GoodsStockUsage createFrom(Map<String,Object> goodsStockUsageMap) {
		if(goodsStockUsageMap==null) return null;
		GoodsStockUsage po = create();
		EntityContext.copyProperties(po,goodsStockUsageMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 GoodsStockUsage
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return GoodsStockUsage , 转换好的的 GoodsStockUsage 对象
	*/
	@Transient
	public static GoodsStockUsage createFrom(Object pojo) {
		if(pojo==null) return null;
		GoodsStockUsage po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 GoodsStockUsage，等同于 new
	 * @return GoodsStockUsage 对象
	*/
	@Transient
	public static GoodsStockUsage create() {
		return new com.dt.platform.domain.eam.meta.GoodsStockUsageMeta.$$proxy$$();
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
			this.setOperUserId(DataParser.parse(String.class, map.get(GoodsStockUsageMeta.OPER_USER_ID)));
			this.setRecTime(DataParser.parse(Date.class, map.get(GoodsStockUsageMeta.REC_TIME)));
			this.setBillCode(DataParser.parse(String.class, map.get(GoodsStockUsageMeta.BILL_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(GoodsStockUsageMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, map.get(GoodsStockUsageMeta.LABEL)));
			this.setOwnerId(DataParser.parse(String.class, map.get(GoodsStockUsageMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(GoodsStockUsageMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(GoodsStockUsageMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(GoodsStockUsageMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(GoodsStockUsageMeta.DELETED)));
			this.setOperNumber(DataParser.parse(String.class, map.get(GoodsStockUsageMeta.OPER_NUMBER)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(GoodsStockUsageMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(GoodsStockUsageMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(GoodsStockUsageMeta.DELETE_TIME)));
			this.setOperUserName(DataParser.parse(String.class, map.get(GoodsStockUsageMeta.OPER_USER_NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(GoodsStockUsageMeta.DELETE_BY)));
			this.setOper(DataParser.parse(String.class, map.get(GoodsStockUsageMeta.OPER)));
			this.setId(DataParser.parse(String.class, map.get(GoodsStockUsageMeta.ID)));
			// others
			this.setOpsUser(DataParser.parse(Employee.class, map.get(GoodsStockUsageMeta.OPS_USER)));
			return true;
		} else {
			try {
				this.setOperUserId( (String)map.get(GoodsStockUsageMeta.OPER_USER_ID));
				this.setRecTime( (Date)map.get(GoodsStockUsageMeta.REC_TIME));
				this.setBillCode( (String)map.get(GoodsStockUsageMeta.BILL_CODE));
				this.setUpdateTime( (Date)map.get(GoodsStockUsageMeta.UPDATE_TIME));
				this.setLabel( (String)map.get(GoodsStockUsageMeta.LABEL));
				this.setOwnerId( (String)map.get(GoodsStockUsageMeta.OWNER_ID));
				this.setVersion( (Integer)map.get(GoodsStockUsageMeta.VERSION));
				this.setContent( (String)map.get(GoodsStockUsageMeta.CONTENT));
				this.setCreateBy( (String)map.get(GoodsStockUsageMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(GoodsStockUsageMeta.DELETED));
				this.setOperNumber( (String)map.get(GoodsStockUsageMeta.OPER_NUMBER));
				this.setCreateTime( (Date)map.get(GoodsStockUsageMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(GoodsStockUsageMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(GoodsStockUsageMeta.DELETE_TIME));
				this.setOperUserName( (String)map.get(GoodsStockUsageMeta.OPER_USER_NAME));
				this.setDeleteBy( (String)map.get(GoodsStockUsageMeta.DELETE_BY));
				this.setOper( (String)map.get(GoodsStockUsageMeta.OPER));
				this.setId( (String)map.get(GoodsStockUsageMeta.ID));
				// others
				this.setOpsUser( (Employee)map.get(GoodsStockUsageMeta.OPS_USER));
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
			this.setOperUserId(DataParser.parse(String.class, r.getValue(GoodsStockUsageMeta.OPER_USER_ID)));
			this.setRecTime(DataParser.parse(Date.class, r.getValue(GoodsStockUsageMeta.REC_TIME)));
			this.setBillCode(DataParser.parse(String.class, r.getValue(GoodsStockUsageMeta.BILL_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(GoodsStockUsageMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, r.getValue(GoodsStockUsageMeta.LABEL)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(GoodsStockUsageMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(GoodsStockUsageMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(GoodsStockUsageMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(GoodsStockUsageMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(GoodsStockUsageMeta.DELETED)));
			this.setOperNumber(DataParser.parse(String.class, r.getValue(GoodsStockUsageMeta.OPER_NUMBER)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(GoodsStockUsageMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(GoodsStockUsageMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(GoodsStockUsageMeta.DELETE_TIME)));
			this.setOperUserName(DataParser.parse(String.class, r.getValue(GoodsStockUsageMeta.OPER_USER_NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(GoodsStockUsageMeta.DELETE_BY)));
			this.setOper(DataParser.parse(String.class, r.getValue(GoodsStockUsageMeta.OPER)));
			this.setId(DataParser.parse(String.class, r.getValue(GoodsStockUsageMeta.ID)));
			return true;
		} else {
			try {
				this.setOperUserId( (String)r.getValue(GoodsStockUsageMeta.OPER_USER_ID));
				this.setRecTime( (Date)r.getValue(GoodsStockUsageMeta.REC_TIME));
				this.setBillCode( (String)r.getValue(GoodsStockUsageMeta.BILL_CODE));
				this.setUpdateTime( (Date)r.getValue(GoodsStockUsageMeta.UPDATE_TIME));
				this.setLabel( (String)r.getValue(GoodsStockUsageMeta.LABEL));
				this.setOwnerId( (String)r.getValue(GoodsStockUsageMeta.OWNER_ID));
				this.setVersion( (Integer)r.getValue(GoodsStockUsageMeta.VERSION));
				this.setContent( (String)r.getValue(GoodsStockUsageMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(GoodsStockUsageMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(GoodsStockUsageMeta.DELETED));
				this.setOperNumber( (String)r.getValue(GoodsStockUsageMeta.OPER_NUMBER));
				this.setCreateTime( (Date)r.getValue(GoodsStockUsageMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(GoodsStockUsageMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(GoodsStockUsageMeta.DELETE_TIME));
				this.setOperUserName( (String)r.getValue(GoodsStockUsageMeta.OPER_USER_NAME));
				this.setDeleteBy( (String)r.getValue(GoodsStockUsageMeta.DELETE_BY));
				this.setOper( (String)r.getValue(GoodsStockUsageMeta.OPER));
				this.setId( (String)r.getValue(GoodsStockUsageMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}