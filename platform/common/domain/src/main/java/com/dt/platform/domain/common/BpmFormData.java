package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_BPM_FORM_DATA;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.BpmFormDataMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 流程表单
 * <p>流程表单 , 数据表 sys_bpm_form_data 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-06-03 06:56:20
 * @sign 8367169854F837ED240688C19E002E08
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_bpm_form_data")
@ApiModel(description = "流程表单 ; 流程表单 , 数据表 sys_bpm_form_data 的PO类型")
public class BpmFormData extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_BPM_FORM_DATA.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "714139812184981504")
	private String id;
	
	/**
	 * 表单：表单
	*/
	@ApiModelProperty(required = false,value="表单" , notes = "表单")
	private String formId;
	
	/**
	 * 数据：数据
	*/
	@ApiModelProperty(required = false,value="数据" , notes = "数据" , example = "714139760699899904")
	private String formDataId;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-05-25 03:36:39")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-05-25 03:39:24")
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
	@ApiModelProperty(required = false,value="version" , notes = "version" , example = "4")
	private Integer version;
	
	/**
	 * formData：formData
	*/
	@ApiModelProperty(required = false,value="formData" , notes = "formData")
	private FormData formData;
	
	/**
	 * formDataExt：formDataExt
	*/
	@ApiModelProperty(required = false,value="formDataExt" , notes = "formDataExt")
	private FormDataExt formDataExt;
	
	/**
	 * 历史流程清单：历史流程清单
	*/
	@ApiModelProperty(required = false,value="历史流程清单" , notes = "历史流程清单")
	private List<ProcessInstance> historicProcessList;
	
	/**
	 * 在批的流程清单：在批的流程清单
	*/
	@ApiModelProperty(required = false,value="在批的流程清单" , notes = "在批的流程清单")
	private List<ProcessInstance> currentProcessList;
	
	/**
	 * 默认流程：优先取在批的流程
	*/
	@ApiModelProperty(required = false,value="默认流程" , notes = "优先取在批的流程")
	private ProcessInstance defaultProcess;
	
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
	public BpmFormData setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 表单<br>
	 * 表单
	 * @return 表单
	*/
	public String getFormId() {
		return formId;
	}
	
	/**
	 * 设置 表单
	 * @param formId 表单
	 * @return 当前对象
	*/
	public BpmFormData setFormId(String formId) {
		this.formId=formId;
		return this;
	}
	
	/**
	 * 获得 数据<br>
	 * 数据
	 * @return 数据
	*/
	public String getFormDataId() {
		return formDataId;
	}
	
	/**
	 * 设置 数据
	 * @param formDataId 数据
	 * @return 当前对象
	*/
	public BpmFormData setFormDataId(String formDataId) {
		this.formDataId=formDataId;
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
	public BpmFormData setNotes(String notes) {
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
	public BpmFormData setCreateBy(String createBy) {
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
	public BpmFormData setCreateTime(Date createTime) {
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
	public BpmFormData setUpdateBy(String updateBy) {
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
	public BpmFormData setUpdateTime(Date updateTime) {
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
	public BpmFormData setDeleted(Integer deleted) {
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
	public BpmFormData setDeleted(Boolean deletedBool) {
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
	public BpmFormData setDeleteBy(String deleteBy) {
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
	public BpmFormData setDeleteTime(Date deleteTime) {
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
	public BpmFormData setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 formData<br>
	 * formData
	 * @return formData
	*/
	public FormData getFormData() {
		return formData;
	}
	
	/**
	 * 设置 formData
	 * @param formData formData
	 * @return 当前对象
	*/
	public BpmFormData setFormData(FormData formData) {
		this.formData=formData;
		return this;
	}
	
	/**
	 * 获得 formDataExt<br>
	 * formDataExt
	 * @return formDataExt
	*/
	public FormDataExt getFormDataExt() {
		return formDataExt;
	}
	
	/**
	 * 设置 formDataExt
	 * @param formDataExt formDataExt
	 * @return 当前对象
	*/
	public BpmFormData setFormDataExt(FormDataExt formDataExt) {
		this.formDataExt=formDataExt;
		return this;
	}
	
	/**
	 * 获得 历史流程清单<br>
	 * 历史流程清单
	 * @return 历史流程清单
	*/
	public List<ProcessInstance> getHistoricProcessList() {
		return historicProcessList;
	}
	
	/**
	 * 设置 历史流程清单
	 * @param historicProcessList 历史流程清单
	 * @return 当前对象
	*/
	public BpmFormData setHistoricProcessList(List<ProcessInstance> historicProcessList) {
		this.historicProcessList=historicProcessList;
		return this;
	}
	
	/**
	 * 添加 历史流程清单
	 * @param historicProcess 历史流程清单
	 * @return 当前对象
	*/
	public BpmFormData addHistoricProcess(ProcessInstance... historicProcess) {
		if(this.historicProcessList==null) historicProcessList=new ArrayList<>();
		this.historicProcessList.addAll(Arrays.asList(historicProcess));
		return this;
	}
	
	/**
	 * 获得 在批的流程清单<br>
	 * 在批的流程清单
	 * @return 在批的流程清单
	*/
	public List<ProcessInstance> getCurrentProcessList() {
		return currentProcessList;
	}
	
	/**
	 * 设置 在批的流程清单
	 * @param currentProcessList 在批的流程清单
	 * @return 当前对象
	*/
	public BpmFormData setCurrentProcessList(List<ProcessInstance> currentProcessList) {
		this.currentProcessList=currentProcessList;
		return this;
	}
	
	/**
	 * 添加 在批的流程清单
	 * @param currentProcess 在批的流程清单
	 * @return 当前对象
	*/
	public BpmFormData addCurrentProcess(ProcessInstance... currentProcess) {
		if(this.currentProcessList==null) currentProcessList=new ArrayList<>();
		this.currentProcessList.addAll(Arrays.asList(currentProcess));
		return this;
	}
	
	/**
	 * 获得 默认流程<br>
	 * 优先取在批的流程
	 * @return 默认流程
	*/
	public ProcessInstance getDefaultProcess() {
		return defaultProcess;
	}
	
	/**
	 * 设置 默认流程
	 * @param defaultProcess 默认流程
	 * @return 当前对象
	*/
	public BpmFormData setDefaultProcess(ProcessInstance defaultProcess) {
		this.defaultProcess=defaultProcess;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return BpmFormData , 转换好的 BpmFormData 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return BpmFormData , 转换好的 PoJo 对象
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
	public BpmFormData clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public BpmFormData duplicate(boolean all) {
		com.dt.platform.domain.common.meta.BpmFormDataMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.BpmFormDataMeta.$$proxy$$();
		inst.setFormId(this.getFormId());
		inst.setCreateBy(this.getCreateBy());
		inst.setNotes(this.getNotes());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setFormDataId(this.getFormDataId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setVersion(this.getVersion());
		if(all) {
			inst.setFormData(this.getFormData());
			inst.setHistoricProcessList(this.getHistoricProcessList());
			inst.setFormDataExt(this.getFormDataExt());
			inst.setCurrentProcessList(this.getCurrentProcessList());
			inst.setDefaultProcess(this.getDefaultProcess());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public BpmFormData clone(boolean deep) {
		return EntityContext.clone(BpmFormData.class,this,deep);
	}

	/**
	 * 将 Map 转换成 BpmFormData
	 * @param bpmFormDataMap 包含实体信息的 Map 对象
	 * @return BpmFormData , 转换好的的 BpmFormData 对象
	*/
	@Transient
	public static BpmFormData createFrom(Map<String,Object> bpmFormDataMap) {
		if(bpmFormDataMap==null) return null;
		BpmFormData po = create();
		EntityContext.copyProperties(po,bpmFormDataMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 BpmFormData
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return BpmFormData , 转换好的的 BpmFormData 对象
	*/
	@Transient
	public static BpmFormData createFrom(Object pojo) {
		if(pojo==null) return null;
		BpmFormData po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 BpmFormData，等同于 new
	 * @return BpmFormData 对象
	*/
	@Transient
	public static BpmFormData create() {
		return new com.dt.platform.domain.common.meta.BpmFormDataMeta.$$proxy$$();
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
			this.setFormId(DataParser.parse(String.class, map.get(BpmFormDataMeta.FORM_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(BpmFormDataMeta.CREATE_BY)));
			this.setNotes(DataParser.parse(String.class, map.get(BpmFormDataMeta.NOTES)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(BpmFormDataMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(BpmFormDataMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(BpmFormDataMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(BpmFormDataMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(BpmFormDataMeta.DELETE_BY)));
			this.setFormDataId(DataParser.parse(String.class, map.get(BpmFormDataMeta.FORM_DATA_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(BpmFormDataMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(BpmFormDataMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(BpmFormDataMeta.VERSION)));
			// others
			this.setFormData(DataParser.parse(FormData.class, map.get(BpmFormDataMeta.FORM_DATA)));
			this.setFormDataExt(DataParser.parse(FormDataExt.class, map.get(BpmFormDataMeta.FORM_DATA_EXT)));
			this.setDefaultProcess(DataParser.parse(ProcessInstance.class, map.get(BpmFormDataMeta.DEFAULT_PROCESS)));
			return true;
		} else {
			try {
				this.setFormId( (String)map.get(BpmFormDataMeta.FORM_ID));
				this.setCreateBy( (String)map.get(BpmFormDataMeta.CREATE_BY));
				this.setNotes( (String)map.get(BpmFormDataMeta.NOTES));
				this.setDeleted( (Integer)map.get(BpmFormDataMeta.DELETED));
				this.setCreateTime( (Date)map.get(BpmFormDataMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(BpmFormDataMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(BpmFormDataMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(BpmFormDataMeta.DELETE_BY));
				this.setFormDataId( (String)map.get(BpmFormDataMeta.FORM_DATA_ID));
				this.setUpdateTime( (Date)map.get(BpmFormDataMeta.UPDATE_TIME));
				this.setId( (String)map.get(BpmFormDataMeta.ID));
				this.setVersion( (Integer)map.get(BpmFormDataMeta.VERSION));
				// others
				this.setFormData( (FormData)map.get(BpmFormDataMeta.FORM_DATA));
				this.setFormDataExt( (FormDataExt)map.get(BpmFormDataMeta.FORM_DATA_EXT));
				this.setDefaultProcess( (ProcessInstance)map.get(BpmFormDataMeta.DEFAULT_PROCESS));
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
			this.setFormId(DataParser.parse(String.class, r.getValue(BpmFormDataMeta.FORM_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(BpmFormDataMeta.CREATE_BY)));
			this.setNotes(DataParser.parse(String.class, r.getValue(BpmFormDataMeta.NOTES)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(BpmFormDataMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(BpmFormDataMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(BpmFormDataMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(BpmFormDataMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(BpmFormDataMeta.DELETE_BY)));
			this.setFormDataId(DataParser.parse(String.class, r.getValue(BpmFormDataMeta.FORM_DATA_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(BpmFormDataMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(BpmFormDataMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(BpmFormDataMeta.VERSION)));
			return true;
		} else {
			try {
				this.setFormId( (String)r.getValue(BpmFormDataMeta.FORM_ID));
				this.setCreateBy( (String)r.getValue(BpmFormDataMeta.CREATE_BY));
				this.setNotes( (String)r.getValue(BpmFormDataMeta.NOTES));
				this.setDeleted( (Integer)r.getValue(BpmFormDataMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(BpmFormDataMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(BpmFormDataMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(BpmFormDataMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(BpmFormDataMeta.DELETE_BY));
				this.setFormDataId( (String)r.getValue(BpmFormDataMeta.FORM_DATA_ID));
				this.setUpdateTime( (Date)r.getValue(BpmFormDataMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(BpmFormDataMeta.ID));
				this.setVersion( (Integer)r.getValue(BpmFormDataMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}