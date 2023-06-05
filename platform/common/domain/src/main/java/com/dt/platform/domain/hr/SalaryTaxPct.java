package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_SALARY_TAX_PCT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Transient;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.SalaryTaxPctMeta;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 薪酬税率
 * <p>薪酬税率 , 数据表 hr_salary_tax_pct 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-04 15:41:55
 * @sign 209B807E9904EDD648668DBD8CFE5845
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_salary_tax_pct")
@ApiModel(description = "薪酬税率 ; 薪酬税率 , 数据表 hr_salary_tax_pct 的PO类型")
public class SalaryTaxPct extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_SALARY_TAX_PCT.$TABLE;
	
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
	private String name;
	
	/**
	 * 最小：最小
	*/
	@ApiModelProperty(required = false,value="最小" , notes = "最小")
	private String min;
	
	/**
	 * 最小包含：最小包含
	*/
	@ApiModelProperty(required = false,value="最小包含" , notes = "最小包含")
	private String minInclude;
	
	/**
	 * 最大：最大
	*/
	@ApiModelProperty(required = false,value="最大" , notes = "最大")
	private BigDecimal max;
	
	/**
	 * 最大包含：最大包含
	*/
	@ApiModelProperty(required = false,value="最大包含" , notes = "最大包含")
	private String maxInclude;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 顺序：顺序
	*/
	@ApiModelProperty(required = false,value="顺序" , notes = "顺序")
	private Integer sort;
	
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
	public SalaryTaxPct setId(String id) {
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
	public SalaryTaxPct setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 最小<br>
	 * 最小
	 * @return 最小
	*/
	public String getMin() {
		return min;
	}
	
	/**
	 * 设置 最小
	 * @param min 最小
	 * @return 当前对象
	*/
	public SalaryTaxPct setMin(String min) {
		this.min=min;
		return this;
	}
	
	/**
	 * 获得 最小包含<br>
	 * 最小包含
	 * @return 最小包含
	*/
	public String getMinInclude() {
		return minInclude;
	}
	
	/**
	 * 设置 最小包含
	 * @param minInclude 最小包含
	 * @return 当前对象
	*/
	public SalaryTaxPct setMinInclude(String minInclude) {
		this.minInclude=minInclude;
		return this;
	}
	
	/**
	 * 获得 最大<br>
	 * 最大
	 * @return 最大
	*/
	public BigDecimal getMax() {
		return max;
	}
	
	/**
	 * 设置 最大
	 * @param max 最大
	 * @return 当前对象
	*/
	public SalaryTaxPct setMax(BigDecimal max) {
		this.max=max;
		return this;
	}
	
	/**
	 * 获得 最大包含<br>
	 * 最大包含
	 * @return 最大包含
	*/
	public String getMaxInclude() {
		return maxInclude;
	}
	
	/**
	 * 设置 最大包含
	 * @param maxInclude 最大包含
	 * @return 当前对象
	*/
	public SalaryTaxPct setMaxInclude(String maxInclude) {
		this.maxInclude=maxInclude;
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
	public SalaryTaxPct setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 顺序<br>
	 * 顺序
	 * @return 顺序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 顺序
	 * @param sort 顺序
	 * @return 当前对象
	*/
	public SalaryTaxPct setSort(Integer sort) {
		this.sort=sort;
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
	public SalaryTaxPct setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SalaryTaxPct , 转换好的 SalaryTaxPct 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SalaryTaxPct , 转换好的 PoJo 对象
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
	public SalaryTaxPct clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SalaryTaxPct duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.SalaryTaxPctMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.SalaryTaxPctMeta.$$proxy$$();
		inst.setMin(this.getMin());
		inst.setNotes(this.getNotes());
		inst.setMax(this.getMax());
		inst.setMaxInclude(this.getMaxInclude());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setId(this.getId());
		inst.setSort(this.getSort());
		inst.setMinInclude(this.getMinInclude());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SalaryTaxPct clone(boolean deep) {
		return EntityContext.clone(SalaryTaxPct.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SalaryTaxPct
	 * @param salaryTaxPctMap 包含实体信息的 Map 对象
	 * @return SalaryTaxPct , 转换好的的 SalaryTaxPct 对象
	*/
	@Transient
	public static SalaryTaxPct createFrom(Map<String,Object> salaryTaxPctMap) {
		if(salaryTaxPctMap==null) return null;
		SalaryTaxPct po = create();
		EntityContext.copyProperties(po,salaryTaxPctMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 SalaryTaxPct
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SalaryTaxPct , 转换好的的 SalaryTaxPct 对象
	*/
	@Transient
	public static SalaryTaxPct createFrom(Object pojo) {
		if(pojo==null) return null;
		SalaryTaxPct po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 SalaryTaxPct，等同于 new
	 * @return SalaryTaxPct 对象
	*/
	@Transient
	public static SalaryTaxPct create() {
		return new com.dt.platform.domain.hr.meta.SalaryTaxPctMeta.$$proxy$$();
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
			this.setMin(DataParser.parse(String.class, map.get(SalaryTaxPctMeta.MIN)));
			this.setNotes(DataParser.parse(String.class, map.get(SalaryTaxPctMeta.NOTES)));
			this.setMax(DataParser.parse(BigDecimal.class, map.get(SalaryTaxPctMeta.MAX)));
			this.setMaxInclude(DataParser.parse(String.class, map.get(SalaryTaxPctMeta.MAX_INCLUDE)));
			this.setName(DataParser.parse(String.class, map.get(SalaryTaxPctMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(SalaryTaxPctMeta.TENANT_ID)));
			this.setId(DataParser.parse(String.class, map.get(SalaryTaxPctMeta.ID)));
			this.setSort(DataParser.parse(Integer.class, map.get(SalaryTaxPctMeta.SORT)));
			this.setMinInclude(DataParser.parse(String.class, map.get(SalaryTaxPctMeta.MIN_INCLUDE)));
			// others
			return true;
		} else {
			try {
				this.setMin( (String)map.get(SalaryTaxPctMeta.MIN));
				this.setNotes( (String)map.get(SalaryTaxPctMeta.NOTES));
				this.setMax( (BigDecimal)map.get(SalaryTaxPctMeta.MAX));
				this.setMaxInclude( (String)map.get(SalaryTaxPctMeta.MAX_INCLUDE));
				this.setName( (String)map.get(SalaryTaxPctMeta.NAME));
				this.setTenantId( (String)map.get(SalaryTaxPctMeta.TENANT_ID));
				this.setId( (String)map.get(SalaryTaxPctMeta.ID));
				this.setSort( (Integer)map.get(SalaryTaxPctMeta.SORT));
				this.setMinInclude( (String)map.get(SalaryTaxPctMeta.MIN_INCLUDE));
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
			this.setMin(DataParser.parse(String.class, r.getValue(SalaryTaxPctMeta.MIN)));
			this.setNotes(DataParser.parse(String.class, r.getValue(SalaryTaxPctMeta.NOTES)));
			this.setMax(DataParser.parse(BigDecimal.class, r.getValue(SalaryTaxPctMeta.MAX)));
			this.setMaxInclude(DataParser.parse(String.class, r.getValue(SalaryTaxPctMeta.MAX_INCLUDE)));
			this.setName(DataParser.parse(String.class, r.getValue(SalaryTaxPctMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SalaryTaxPctMeta.TENANT_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(SalaryTaxPctMeta.ID)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(SalaryTaxPctMeta.SORT)));
			this.setMinInclude(DataParser.parse(String.class, r.getValue(SalaryTaxPctMeta.MIN_INCLUDE)));
			return true;
		} else {
			try {
				this.setMin( (String)r.getValue(SalaryTaxPctMeta.MIN));
				this.setNotes( (String)r.getValue(SalaryTaxPctMeta.NOTES));
				this.setMax( (BigDecimal)r.getValue(SalaryTaxPctMeta.MAX));
				this.setMaxInclude( (String)r.getValue(SalaryTaxPctMeta.MAX_INCLUDE));
				this.setName( (String)r.getValue(SalaryTaxPctMeta.NAME));
				this.setTenantId( (String)r.getValue(SalaryTaxPctMeta.TENANT_ID));
				this.setId( (String)r.getValue(SalaryTaxPctMeta.ID));
				this.setSort( (Integer)r.getValue(SalaryTaxPctMeta.SORT));
				this.setMinInclude( (String)r.getValue(SalaryTaxPctMeta.MIN_INCLUDE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}