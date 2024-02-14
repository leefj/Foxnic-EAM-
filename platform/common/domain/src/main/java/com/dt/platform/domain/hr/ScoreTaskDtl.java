package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_SCORE_TASK_DTL;
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
import com.dt.platform.domain.hr.meta.ScoreTaskDtlMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 任务单明细
 * <p>任务单明细 , 数据表 hr_score_task_dtl 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-02-12 00:04:02
 * @sign 52D3E423C6C087035BBD8AA23C325AC2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_score_task_dtl")
@ApiModel(description = "任务单明细 ; 任务单明细 , 数据表 hr_score_task_dtl 的PO类型")
public class ScoreTaskDtl extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_SCORE_TASK_DTL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 任务单：任务单
	*/
	@ApiModelProperty(required = false,value="任务单" , notes = "任务单")
	private String taskId;
	
	/**
	 * 模版：模版
	*/
	@ApiModelProperty(required = false,value="模版" , notes = "模版")
	private String tplId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 评分人：评分人
	*/
	@ApiModelProperty(required = false,value="评分人" , notes = "评分人")
	private String raterId;
	
	/**
	 * 被评分人：被评分人
	*/
	@ApiModelProperty(required = false,value="被评分人" , notes = "被评分人")
	private String ratedId;
	
	/**
	 * 总分：总分
	*/
	@ApiModelProperty(required = false,value="总分" , notes = "总分")
	private BigDecimal totalScore;
	
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
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
	public ScoreTaskDtl setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 任务单<br>
	 * 任务单
	 * @return 任务单
	*/
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 设置 任务单
	 * @param taskId 任务单
	 * @return 当前对象
	*/
	public ScoreTaskDtl setTaskId(String taskId) {
		this.taskId=taskId;
		return this;
	}
	
	/**
	 * 获得 模版<br>
	 * 模版
	 * @return 模版
	*/
	public String getTplId() {
		return tplId;
	}
	
	/**
	 * 设置 模版
	 * @param tplId 模版
	 * @return 当前对象
	*/
	public ScoreTaskDtl setTplId(String tplId) {
		this.tplId=tplId;
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
	public ScoreTaskDtl setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 评分人<br>
	 * 评分人
	 * @return 评分人
	*/
	public String getRaterId() {
		return raterId;
	}
	
	/**
	 * 设置 评分人
	 * @param raterId 评分人
	 * @return 当前对象
	*/
	public ScoreTaskDtl setRaterId(String raterId) {
		this.raterId=raterId;
		return this;
	}
	
	/**
	 * 获得 被评分人<br>
	 * 被评分人
	 * @return 被评分人
	*/
	public String getRatedId() {
		return ratedId;
	}
	
	/**
	 * 设置 被评分人
	 * @param ratedId 被评分人
	 * @return 当前对象
	*/
	public ScoreTaskDtl setRatedId(String ratedId) {
		this.ratedId=ratedId;
		return this;
	}
	
	/**
	 * 获得 总分<br>
	 * 总分
	 * @return 总分
	*/
	public BigDecimal getTotalScore() {
		return totalScore;
	}
	
	/**
	 * 设置 总分
	 * @param totalScore 总分
	 * @return 当前对象
	*/
	public ScoreTaskDtl setTotalScore(BigDecimal totalScore) {
		this.totalScore=totalScore;
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
	public ScoreTaskDtl setNotes(String notes) {
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
	public ScoreTaskDtl setCreateBy(String createBy) {
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
	public ScoreTaskDtl setCreateTime(Date createTime) {
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
	public ScoreTaskDtl setUpdateBy(String updateBy) {
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
	public ScoreTaskDtl setUpdateTime(Date updateTime) {
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
	public ScoreTaskDtl setDeleted(Integer deleted) {
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
	public ScoreTaskDtl setDeleted(Boolean deletedBool) {
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
	public ScoreTaskDtl setDeleteBy(String deleteBy) {
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
	public ScoreTaskDtl setDeleteTime(Date deleteTime) {
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
	public ScoreTaskDtl setVersion(Integer version) {
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
	public ScoreTaskDtl setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ScoreTaskDtl , 转换好的 ScoreTaskDtl 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ScoreTaskDtl , 转换好的 PoJo 对象
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
	public ScoreTaskDtl clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ScoreTaskDtl duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.ScoreTaskDtlMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.ScoreTaskDtlMeta.$$proxy$$();
		inst.setRatedId(this.getRatedId());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setTotalScore(this.getTotalScore());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setRaterId(this.getRaterId());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTplId(this.getTplId());
		inst.setTaskId(this.getTaskId());
		inst.setStatus(this.getStatus());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ScoreTaskDtl clone(boolean deep) {
		return EntityContext.clone(ScoreTaskDtl.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ScoreTaskDtl
	 * @param scoreTaskDtlMap 包含实体信息的 Map 对象
	 * @return ScoreTaskDtl , 转换好的的 ScoreTaskDtl 对象
	*/
	@Transient
	public static ScoreTaskDtl createFrom(Map<String,Object> scoreTaskDtlMap) {
		if(scoreTaskDtlMap==null) return null;
		ScoreTaskDtl po = create();
		EntityContext.copyProperties(po,scoreTaskDtlMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ScoreTaskDtl
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ScoreTaskDtl , 转换好的的 ScoreTaskDtl 对象
	*/
	@Transient
	public static ScoreTaskDtl createFrom(Object pojo) {
		if(pojo==null) return null;
		ScoreTaskDtl po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ScoreTaskDtl，等同于 new
	 * @return ScoreTaskDtl 对象
	*/
	@Transient
	public static ScoreTaskDtl create() {
		return new com.dt.platform.domain.hr.meta.ScoreTaskDtlMeta.$$proxy$$();
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
			this.setRatedId(DataParser.parse(String.class, map.get(ScoreTaskDtlMeta.RATED_ID)));
			this.setNotes(DataParser.parse(String.class, map.get(ScoreTaskDtlMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ScoreTaskDtlMeta.UPDATE_TIME)));
			this.setTotalScore(DataParser.parse(BigDecimal.class, map.get(ScoreTaskDtlMeta.TOTAL_SCORE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ScoreTaskDtlMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ScoreTaskDtlMeta.CREATE_BY)));
			this.setRaterId(DataParser.parse(String.class, map.get(ScoreTaskDtlMeta.RATER_ID)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ScoreTaskDtlMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ScoreTaskDtlMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ScoreTaskDtlMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ScoreTaskDtlMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ScoreTaskDtlMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ScoreTaskDtlMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ScoreTaskDtlMeta.ID)));
			this.setTplId(DataParser.parse(String.class, map.get(ScoreTaskDtlMeta.TPL_ID)));
			this.setTaskId(DataParser.parse(String.class, map.get(ScoreTaskDtlMeta.TASK_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(ScoreTaskDtlMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setRatedId( (String)map.get(ScoreTaskDtlMeta.RATED_ID));
				this.setNotes( (String)map.get(ScoreTaskDtlMeta.NOTES));
				this.setUpdateTime( (Date)map.get(ScoreTaskDtlMeta.UPDATE_TIME));
				this.setTotalScore( (BigDecimal)map.get(ScoreTaskDtlMeta.TOTAL_SCORE));
				this.setVersion( (Integer)map.get(ScoreTaskDtlMeta.VERSION));
				this.setCreateBy( (String)map.get(ScoreTaskDtlMeta.CREATE_BY));
				this.setRaterId( (String)map.get(ScoreTaskDtlMeta.RATER_ID));
				this.setDeleted( (Integer)map.get(ScoreTaskDtlMeta.DELETED));
				this.setCreateTime( (Date)map.get(ScoreTaskDtlMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ScoreTaskDtlMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ScoreTaskDtlMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(ScoreTaskDtlMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ScoreTaskDtlMeta.DELETE_BY));
				this.setId( (String)map.get(ScoreTaskDtlMeta.ID));
				this.setTplId( (String)map.get(ScoreTaskDtlMeta.TPL_ID));
				this.setTaskId( (String)map.get(ScoreTaskDtlMeta.TASK_ID));
				this.setStatus( (String)map.get(ScoreTaskDtlMeta.STATUS));
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
			this.setRatedId(DataParser.parse(String.class, r.getValue(ScoreTaskDtlMeta.RATED_ID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(ScoreTaskDtlMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ScoreTaskDtlMeta.UPDATE_TIME)));
			this.setTotalScore(DataParser.parse(BigDecimal.class, r.getValue(ScoreTaskDtlMeta.TOTAL_SCORE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ScoreTaskDtlMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ScoreTaskDtlMeta.CREATE_BY)));
			this.setRaterId(DataParser.parse(String.class, r.getValue(ScoreTaskDtlMeta.RATER_ID)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ScoreTaskDtlMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ScoreTaskDtlMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ScoreTaskDtlMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ScoreTaskDtlMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ScoreTaskDtlMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ScoreTaskDtlMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ScoreTaskDtlMeta.ID)));
			this.setTplId(DataParser.parse(String.class, r.getValue(ScoreTaskDtlMeta.TPL_ID)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(ScoreTaskDtlMeta.TASK_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(ScoreTaskDtlMeta.STATUS)));
			return true;
		} else {
			try {
				this.setRatedId( (String)r.getValue(ScoreTaskDtlMeta.RATED_ID));
				this.setNotes( (String)r.getValue(ScoreTaskDtlMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(ScoreTaskDtlMeta.UPDATE_TIME));
				this.setTotalScore( (BigDecimal)r.getValue(ScoreTaskDtlMeta.TOTAL_SCORE));
				this.setVersion( (Integer)r.getValue(ScoreTaskDtlMeta.VERSION));
				this.setCreateBy( (String)r.getValue(ScoreTaskDtlMeta.CREATE_BY));
				this.setRaterId( (String)r.getValue(ScoreTaskDtlMeta.RATER_ID));
				this.setDeleted( (Integer)r.getValue(ScoreTaskDtlMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ScoreTaskDtlMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ScoreTaskDtlMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ScoreTaskDtlMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(ScoreTaskDtlMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ScoreTaskDtlMeta.DELETE_BY));
				this.setId( (String)r.getValue(ScoreTaskDtlMeta.ID));
				this.setTplId( (String)r.getValue(ScoreTaskDtlMeta.TPL_ID));
				this.setTaskId( (String)r.getValue(ScoreTaskDtlMeta.TASK_ID));
				this.setStatus( (String)r.getValue(ScoreTaskDtlMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}