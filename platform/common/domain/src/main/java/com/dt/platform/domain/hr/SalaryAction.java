package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_SALARY_ACTION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.SalaryActionMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 薪酬发放
 * <p>薪酬发放 , 数据表 hr_salary_action 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2024-01-28 11:51:19
 * @sign 0E6B7E2EE7118202FC6A92C23E8769F2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_salary_action")
@ApiModel(description = "薪酬发放 ; 薪酬发放 , 数据表 hr_salary_action 的PO类型")
public class SalaryAction extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_SALARY_ACTION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "801523704080105472")
	private String id;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "finish")
	private String status;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签" , example = "salary")
	private String label;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "1212")
	private String name;
	
	/**
	 * 开始日期：开始日期
	*/
	@ApiModelProperty(required = false,value="开始日期" , notes = "开始日期")
	private Date start;
	
	/**
	 * 结束日期：结束日期
	*/
	@ApiModelProperty(required = false,value="结束日期" , notes = "结束日期")
	private Date end;
	
	/**
	 * 月份：月份
	*/
	@ApiModelProperty(required = false,value="月份" , notes = "月份" , example = "2028-09")
	private String actionMonth;
	
	/**
	 * 模版：模版
	*/
	@ApiModelProperty(required = false,value="模版" , notes = "模版" , example = "717722780455403520")
	private String tplId;
	
	/**
	 * 跟随模版：跟随模版
	*/
	@ApiModelProperty(required = false,value="跟随模版" , notes = "跟随模版")
	private String withTpl;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "121212")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2024-01-21 06:49:03")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * SalaryDetailList：SalaryDetailList
	*/
	@ApiModelProperty(required = false,value="SalaryDetailList" , notes = "SalaryDetailList")
	private List<SalaryDetail> SalaryDetailList;
	
	/**
	 * salaryTpl：salaryTpl
	*/
	@ApiModelProperty(required = false,value="salaryTpl" , notes = "salaryTpl")
	private SalaryTpl salaryTpl;
	
	/**
	 * salaryMonth：salaryMonth
	*/
	@ApiModelProperty(required = false,value="salaryMonth" , notes = "salaryMonth")
	private SalaryMonth salaryMonth;
	
	/**
	 * personList：personList
	*/
	@ApiModelProperty(required = false,value="personList" , notes = "personList")
	private List<Person> personList;
	
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
	public SalaryAction setId(String id) {
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
	public SalaryAction setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 标签<br>
	 * 标签
	 * @return 标签
	*/
	public String getLabel() {
		return label;
	}
	
	/**
	 * 设置 标签
	 * @param label 标签
	 * @return 当前对象
	*/
	public SalaryAction setLabel(String label) {
		this.label=label;
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
	public SalaryAction setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 开始日期<br>
	 * 开始日期
	 * @return 开始日期
	*/
	public Date getStart() {
		return start;
	}
	
	/**
	 * 设置 开始日期
	 * @param start 开始日期
	 * @return 当前对象
	*/
	public SalaryAction setStart(Date start) {
		this.start=start;
		return this;
	}
	
	/**
	 * 获得 结束日期<br>
	 * 结束日期
	 * @return 结束日期
	*/
	public Date getEnd() {
		return end;
	}
	
	/**
	 * 设置 结束日期
	 * @param end 结束日期
	 * @return 当前对象
	*/
	public SalaryAction setEnd(Date end) {
		this.end=end;
		return this;
	}
	
	/**
	 * 获得 月份<br>
	 * 月份
	 * @return 月份
	*/
	public String getActionMonth() {
		return actionMonth;
	}
	
	/**
	 * 设置 月份
	 * @param actionMonth 月份
	 * @return 当前对象
	*/
	public SalaryAction setActionMonth(String actionMonth) {
		this.actionMonth=actionMonth;
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
	public SalaryAction setTplId(String tplId) {
		this.tplId=tplId;
		return this;
	}
	
	/**
	 * 获得 跟随模版<br>
	 * 跟随模版
	 * @return 跟随模版
	*/
	public String getWithTpl() {
		return withTpl;
	}
	
	/**
	 * 设置 跟随模版
	 * @param withTpl 跟随模版
	 * @return 当前对象
	*/
	public SalaryAction setWithTpl(String withTpl) {
		this.withTpl=withTpl;
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
	public SalaryAction setNotes(String notes) {
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
	public SalaryAction setCreateBy(String createBy) {
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
	public SalaryAction setCreateTime(Date createTime) {
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
	public SalaryAction setUpdateBy(String updateBy) {
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
	public SalaryAction setUpdateTime(Date updateTime) {
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
	public SalaryAction setDeleted(Integer deleted) {
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
	public SalaryAction setDeleted(Boolean deletedBool) {
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
	public SalaryAction setDeleteBy(String deleteBy) {
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
	public SalaryAction setDeleteTime(Date deleteTime) {
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
	public SalaryAction setVersion(Integer version) {
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
	public SalaryAction setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 SalaryDetailList<br>
	 * SalaryDetailList
	 * @return SalaryDetailList
	*/
	public List<SalaryDetail> getSalaryDetailList() {
		return SalaryDetailList;
	}
	
	/**
	 * 设置 SalaryDetailList
	 * @param SalaryDetailList SalaryDetailList
	 * @return 当前对象
	*/
	public SalaryAction setSalaryDetailList(List<SalaryDetail> SalaryDetailList) {
		this.SalaryDetailList=SalaryDetailList;
		return this;
	}
	
	/**
	 * 添加 SalaryDetailList
	 * @param SalaryDetail SalaryDetailList
	 * @return 当前对象
	*/
	public SalaryAction addSalaryDetail(SalaryDetail... SalaryDetail) {
		if(this.SalaryDetailList==null) SalaryDetailList=new ArrayList<>();
		this.SalaryDetailList.addAll(Arrays.asList(SalaryDetail));
		return this;
	}
	
	/**
	 * 获得 salaryTpl<br>
	 * salaryTpl
	 * @return salaryTpl
	*/
	public SalaryTpl getSalaryTpl() {
		return salaryTpl;
	}
	
	/**
	 * 设置 salaryTpl
	 * @param salaryTpl salaryTpl
	 * @return 当前对象
	*/
	public SalaryAction setSalaryTpl(SalaryTpl salaryTpl) {
		this.salaryTpl=salaryTpl;
		return this;
	}
	
	/**
	 * 获得 salaryMonth<br>
	 * salaryMonth
	 * @return salaryMonth
	*/
	public SalaryMonth getSalaryMonth() {
		return salaryMonth;
	}
	
	/**
	 * 设置 salaryMonth
	 * @param salaryMonth salaryMonth
	 * @return 当前对象
	*/
	public SalaryAction setSalaryMonth(SalaryMonth salaryMonth) {
		this.salaryMonth=salaryMonth;
		return this;
	}
	
	/**
	 * 获得 personList<br>
	 * personList
	 * @return personList
	*/
	public List<Person> getPersonList() {
		return personList;
	}
	
	/**
	 * 设置 personList
	 * @param personList personList
	 * @return 当前对象
	*/
	public SalaryAction setPersonList(List<Person> personList) {
		this.personList=personList;
		return this;
	}
	
	/**
	 * 添加 personList
	 * @param person personList
	 * @return 当前对象
	*/
	public SalaryAction addPerson(Person... person) {
		if(this.personList==null) personList=new ArrayList<>();
		this.personList.addAll(Arrays.asList(person));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SalaryAction , 转换好的 SalaryAction 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SalaryAction , 转换好的 PoJo 对象
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
	public SalaryAction clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SalaryAction duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.SalaryActionMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.SalaryActionMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setStart(this.getStart());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setLabel(this.getLabel());
		inst.setActionMonth(this.getActionMonth());
		inst.setVersion(this.getVersion());
		inst.setWithTpl(this.getWithTpl());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setEnd(this.getEnd());
		inst.setId(this.getId());
		inst.setTplId(this.getTplId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSalaryTpl(this.getSalaryTpl());
			inst.setPersonList(this.getPersonList());
			inst.setSalaryMonth(this.getSalaryMonth());
			inst.setSalaryDetailList(this.getSalaryDetailList());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SalaryAction clone(boolean deep) {
		return EntityContext.clone(SalaryAction.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SalaryAction
	 * @param salaryActionMap 包含实体信息的 Map 对象
	 * @return SalaryAction , 转换好的的 SalaryAction 对象
	*/
	@Transient
	public static SalaryAction createFrom(Map<String,Object> salaryActionMap) {
		if(salaryActionMap==null) return null;
		SalaryAction po = create();
		EntityContext.copyProperties(po,salaryActionMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 SalaryAction
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SalaryAction , 转换好的的 SalaryAction 对象
	*/
	@Transient
	public static SalaryAction createFrom(Object pojo) {
		if(pojo==null) return null;
		SalaryAction po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 SalaryAction，等同于 new
	 * @return SalaryAction 对象
	*/
	@Transient
	public static SalaryAction create() {
		return new com.dt.platform.domain.hr.meta.SalaryActionMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(SalaryActionMeta.NOTES)));
			this.setStart(DataParser.parse(Date.class, map.get(SalaryActionMeta.START)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SalaryActionMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, map.get(SalaryActionMeta.LABEL)));
			this.setActionMonth(DataParser.parse(String.class, map.get(SalaryActionMeta.ACTION_MONTH)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SalaryActionMeta.VERSION)));
			this.setWithTpl(DataParser.parse(String.class, map.get(SalaryActionMeta.WITH_TPL)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SalaryActionMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SalaryActionMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SalaryActionMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SalaryActionMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SalaryActionMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(SalaryActionMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(SalaryActionMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SalaryActionMeta.DELETE_BY)));
			this.setEnd(DataParser.parse(Date.class, map.get(SalaryActionMeta.END)));
			this.setId(DataParser.parse(String.class, map.get(SalaryActionMeta.ID)));
			this.setTplId(DataParser.parse(String.class, map.get(SalaryActionMeta.TPL_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(SalaryActionMeta.STATUS)));
			// others
			this.setSalaryTpl(DataParser.parse(SalaryTpl.class, map.get(SalaryActionMeta.SALARY_TPL)));
			this.setSalaryMonth(DataParser.parse(SalaryMonth.class, map.get(SalaryActionMeta.SALARY_MONTH)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(SalaryActionMeta.NOTES));
				this.setStart( (Date)map.get(SalaryActionMeta.START));
				this.setUpdateTime( (Date)map.get(SalaryActionMeta.UPDATE_TIME));
				this.setLabel( (String)map.get(SalaryActionMeta.LABEL));
				this.setActionMonth( (String)map.get(SalaryActionMeta.ACTION_MONTH));
				this.setVersion( (Integer)map.get(SalaryActionMeta.VERSION));
				this.setWithTpl( (String)map.get(SalaryActionMeta.WITH_TPL));
				this.setCreateBy( (String)map.get(SalaryActionMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(SalaryActionMeta.DELETED));
				this.setCreateTime( (Date)map.get(SalaryActionMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SalaryActionMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SalaryActionMeta.DELETE_TIME));
				this.setName( (String)map.get(SalaryActionMeta.NAME));
				this.setTenantId( (String)map.get(SalaryActionMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(SalaryActionMeta.DELETE_BY));
				this.setEnd( (Date)map.get(SalaryActionMeta.END));
				this.setId( (String)map.get(SalaryActionMeta.ID));
				this.setTplId( (String)map.get(SalaryActionMeta.TPL_ID));
				this.setStatus( (String)map.get(SalaryActionMeta.STATUS));
				// others
				this.setSalaryTpl( (SalaryTpl)map.get(SalaryActionMeta.SALARY_TPL));
				this.setSalaryMonth( (SalaryMonth)map.get(SalaryActionMeta.SALARY_MONTH));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(SalaryActionMeta.NOTES)));
			this.setStart(DataParser.parse(Date.class, r.getValue(SalaryActionMeta.START)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SalaryActionMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, r.getValue(SalaryActionMeta.LABEL)));
			this.setActionMonth(DataParser.parse(String.class, r.getValue(SalaryActionMeta.ACTION_MONTH)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SalaryActionMeta.VERSION)));
			this.setWithTpl(DataParser.parse(String.class, r.getValue(SalaryActionMeta.WITH_TPL)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SalaryActionMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SalaryActionMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SalaryActionMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SalaryActionMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SalaryActionMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(SalaryActionMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SalaryActionMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SalaryActionMeta.DELETE_BY)));
			this.setEnd(DataParser.parse(Date.class, r.getValue(SalaryActionMeta.END)));
			this.setId(DataParser.parse(String.class, r.getValue(SalaryActionMeta.ID)));
			this.setTplId(DataParser.parse(String.class, r.getValue(SalaryActionMeta.TPL_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(SalaryActionMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(SalaryActionMeta.NOTES));
				this.setStart( (Date)r.getValue(SalaryActionMeta.START));
				this.setUpdateTime( (Date)r.getValue(SalaryActionMeta.UPDATE_TIME));
				this.setLabel( (String)r.getValue(SalaryActionMeta.LABEL));
				this.setActionMonth( (String)r.getValue(SalaryActionMeta.ACTION_MONTH));
				this.setVersion( (Integer)r.getValue(SalaryActionMeta.VERSION));
				this.setWithTpl( (String)r.getValue(SalaryActionMeta.WITH_TPL));
				this.setCreateBy( (String)r.getValue(SalaryActionMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(SalaryActionMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(SalaryActionMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SalaryActionMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SalaryActionMeta.DELETE_TIME));
				this.setName( (String)r.getValue(SalaryActionMeta.NAME));
				this.setTenantId( (String)r.getValue(SalaryActionMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(SalaryActionMeta.DELETE_BY));
				this.setEnd( (Date)r.getValue(SalaryActionMeta.END));
				this.setId( (String)r.getValue(SalaryActionMeta.ID));
				this.setTplId( (String)r.getValue(SalaryActionMeta.TPL_ID));
				this.setStatus( (String)r.getValue(SalaryActionMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}