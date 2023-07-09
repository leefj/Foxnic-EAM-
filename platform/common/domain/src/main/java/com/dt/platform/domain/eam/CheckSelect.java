package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_CHECK_SELECT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.CheckSelectMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 检查项选择
 * <p>检查项选择 , 数据表 eam_check_select 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-07 10:52:29
 * @sign 45A38C90D8DEE577C098CA90879E2E95
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_check_select")
@ApiModel(description = "检查项选择 ; 检查项选择 , 数据表 eam_check_select 的PO类型")
public class CheckSelect extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_CHECK_SELECT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "729623362745139200")
	private String id;
	
	/**
	 * 任务：任务
	*/
	@ApiModelProperty(required = false,value="任务" , notes = "任务" , example = "729623361553956864")
	private String taskId;
	
	/**
	 * 巡检点位：巡检点位
	*/
	@ApiModelProperty(required = false,value="巡检点位" , notes = "巡检点位" , example = "729623362577367040")
	private String taskPointId;
	
	/**
	 * 巡检点位：巡检点位
	*/
	@ApiModelProperty(required = false,value="巡检点位" , notes = "巡检点位" , example = "729333314053210112")
	private String pointId;
	
	/**
	 * 是否检查：是否检查
	*/
	@ApiModelProperty(required = false,value="是否检查" , notes = "是否检查" , example = "no")
	private String ifCheck;
	
	/**
	 * 组件类型：组件类型
	*/
	@ApiModelProperty(required = false,value="组件类型" , notes = "组件类型" , example = "number_range")
	private String type;
	
	/**
	 * 检查项：检查项
	*/
	@ApiModelProperty(required = false,value="检查项" , notes = "检查项" , example = "728972981300101120")
	private String itemId;
	
	/**
	 * 检查项编码：检查项编码
	*/
	@ApiModelProperty(required = false,value="检查项编码" , notes = "检查项编码" , example = "C000002")
	private String itemCode;
	
	/**
	 * 检查项：检查项
	*/
	@ApiModelProperty(required = false,value="检查项" , notes = "检查项")
	private String itemName;
	
	/**
	 * 检查项描述：检查项描述
	*/
	@ApiModelProperty(required = false,value="检查项描述" , notes = "检查项描述")
	private String itemDesc;
	
	/**
	 * 检查结果：检查结果
	*/
	@ApiModelProperty(required = false,value="检查结果" , notes = "检查结果")
	private String result;
	
	/**
	 * 内容元数据：内容元数据
	*/
	@ApiModelProperty(required = false,value="内容元数据" , notes = "内容元数据" , example = "10")
	private String resultMetaData;
	
	/**
	 * 配置项：配置项
	*/
	@ApiModelProperty(required = false,value="配置项" , notes = "配置项" , example = "{max:100,min:4}  ")
	private String config;
	
	/**
	 * 默认值：默认值
	*/
	@ApiModelProperty(required = false,value="默认值" , notes = "默认值" , example = "10")
	private String configDefValue;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序" , example = "0")
	private Integer sort;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-07-07 09:02:45")
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
	 * checkItem：checkItem
	*/
	@ApiModelProperty(required = false,value="checkItem" , notes = "checkItem")
	private CheckItem checkItem;
	
	/**
	 * inspectionTask：inspectionTask
	*/
	@ApiModelProperty(required = false,value="inspectionTask" , notes = "inspectionTask")
	private InspectionTask inspectionTask;
	
	/**
	 * inspectionPoint：inspectionPoint
	*/
	@ApiModelProperty(required = false,value="inspectionPoint" , notes = "inspectionPoint")
	private InspectionPoint inspectionPoint;
	
	/**
	 * inspectionTaskPoint：inspectionTaskPoint
	*/
	@ApiModelProperty(required = false,value="inspectionTaskPoint" , notes = "inspectionTaskPoint")
	private InspectionTaskPoint inspectionTaskPoint;
	
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
	public CheckSelect setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 任务<br>
	 * 任务
	 * @return 任务
	*/
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 设置 任务
	 * @param taskId 任务
	 * @return 当前对象
	*/
	public CheckSelect setTaskId(String taskId) {
		this.taskId=taskId;
		return this;
	}
	
	/**
	 * 获得 巡检点位<br>
	 * 巡检点位
	 * @return 巡检点位
	*/
	public String getTaskPointId() {
		return taskPointId;
	}
	
	/**
	 * 设置 巡检点位
	 * @param taskPointId 巡检点位
	 * @return 当前对象
	*/
	public CheckSelect setTaskPointId(String taskPointId) {
		this.taskPointId=taskPointId;
		return this;
	}
	
	/**
	 * 获得 巡检点位<br>
	 * 巡检点位
	 * @return 巡检点位
	*/
	public String getPointId() {
		return pointId;
	}
	
	/**
	 * 设置 巡检点位
	 * @param pointId 巡检点位
	 * @return 当前对象
	*/
	public CheckSelect setPointId(String pointId) {
		this.pointId=pointId;
		return this;
	}
	
	/**
	 * 获得 是否检查<br>
	 * 是否检查
	 * @return 是否检查
	*/
	public String getIfCheck() {
		return ifCheck;
	}
	
	/**
	 * 设置 是否检查
	 * @param ifCheck 是否检查
	 * @return 当前对象
	*/
	public CheckSelect setIfCheck(String ifCheck) {
		this.ifCheck=ifCheck;
		return this;
	}
	
	/**
	 * 获得 组件类型<br>
	 * 组件类型
	 * @return 组件类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 组件类型
	 * @param type 组件类型
	 * @return 当前对象
	*/
	public CheckSelect setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 检查项<br>
	 * 检查项
	 * @return 检查项
	*/
	public String getItemId() {
		return itemId;
	}
	
	/**
	 * 设置 检查项
	 * @param itemId 检查项
	 * @return 当前对象
	*/
	public CheckSelect setItemId(String itemId) {
		this.itemId=itemId;
		return this;
	}
	
	/**
	 * 获得 检查项编码<br>
	 * 检查项编码
	 * @return 检查项编码
	*/
	public String getItemCode() {
		return itemCode;
	}
	
	/**
	 * 设置 检查项编码
	 * @param itemCode 检查项编码
	 * @return 当前对象
	*/
	public CheckSelect setItemCode(String itemCode) {
		this.itemCode=itemCode;
		return this;
	}
	
	/**
	 * 获得 检查项<br>
	 * 检查项
	 * @return 检查项
	*/
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * 设置 检查项
	 * @param itemName 检查项
	 * @return 当前对象
	*/
	public CheckSelect setItemName(String itemName) {
		this.itemName=itemName;
		return this;
	}
	
	/**
	 * 获得 检查项描述<br>
	 * 检查项描述
	 * @return 检查项描述
	*/
	public String getItemDesc() {
		return itemDesc;
	}
	
	/**
	 * 设置 检查项描述
	 * @param itemDesc 检查项描述
	 * @return 当前对象
	*/
	public CheckSelect setItemDesc(String itemDesc) {
		this.itemDesc=itemDesc;
		return this;
	}
	
	/**
	 * 获得 检查结果<br>
	 * 检查结果
	 * @return 检查结果
	*/
	public String getResult() {
		return result;
	}
	
	/**
	 * 设置 检查结果
	 * @param result 检查结果
	 * @return 当前对象
	*/
	public CheckSelect setResult(String result) {
		this.result=result;
		return this;
	}
	
	/**
	 * 获得 内容元数据<br>
	 * 内容元数据
	 * @return 内容元数据
	*/
	public String getResultMetaData() {
		return resultMetaData;
	}
	
	/**
	 * 设置 内容元数据
	 * @param resultMetaData 内容元数据
	 * @return 当前对象
	*/
	public CheckSelect setResultMetaData(String resultMetaData) {
		this.resultMetaData=resultMetaData;
		return this;
	}
	
	/**
	 * 获得 配置项<br>
	 * 配置项
	 * @return 配置项
	*/
	public String getConfig() {
		return config;
	}
	
	/**
	 * 设置 配置项
	 * @param config 配置项
	 * @return 当前对象
	*/
	public CheckSelect setConfig(String config) {
		this.config=config;
		return this;
	}
	
	/**
	 * 获得 默认值<br>
	 * 默认值
	 * @return 默认值
	*/
	public String getConfigDefValue() {
		return configDefValue;
	}
	
	/**
	 * 设置 默认值
	 * @param configDefValue 默认值
	 * @return 当前对象
	*/
	public CheckSelect setConfigDefValue(String configDefValue) {
		this.configDefValue=configDefValue;
		return this;
	}
	
	/**
	 * 获得 排序<br>
	 * 排序
	 * @return 排序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 排序
	 * @param sort 排序
	 * @return 当前对象
	*/
	public CheckSelect setSort(Integer sort) {
		this.sort=sort;
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
	public CheckSelect setCreateBy(String createBy) {
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
	public CheckSelect setCreateTime(Date createTime) {
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
	public CheckSelect setUpdateBy(String updateBy) {
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
	public CheckSelect setUpdateTime(Date updateTime) {
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
	public CheckSelect setDeleted(Integer deleted) {
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
	public CheckSelect setDeleted(Boolean deletedBool) {
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
	public CheckSelect setDeleteBy(String deleteBy) {
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
	public CheckSelect setDeleteTime(Date deleteTime) {
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
	public CheckSelect setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 checkItem<br>
	 * checkItem
	 * @return checkItem
	*/
	public CheckItem getCheckItem() {
		return checkItem;
	}
	
	/**
	 * 设置 checkItem
	 * @param checkItem checkItem
	 * @return 当前对象
	*/
	public CheckSelect setCheckItem(CheckItem checkItem) {
		this.checkItem=checkItem;
		return this;
	}
	
	/**
	 * 获得 inspectionTask<br>
	 * inspectionTask
	 * @return inspectionTask
	*/
	public InspectionTask getInspectionTask() {
		return inspectionTask;
	}
	
	/**
	 * 设置 inspectionTask
	 * @param inspectionTask inspectionTask
	 * @return 当前对象
	*/
	public CheckSelect setInspectionTask(InspectionTask inspectionTask) {
		this.inspectionTask=inspectionTask;
		return this;
	}
	
	/**
	 * 获得 inspectionPoint<br>
	 * inspectionPoint
	 * @return inspectionPoint
	*/
	public InspectionPoint getInspectionPoint() {
		return inspectionPoint;
	}
	
	/**
	 * 设置 inspectionPoint
	 * @param inspectionPoint inspectionPoint
	 * @return 当前对象
	*/
	public CheckSelect setInspectionPoint(InspectionPoint inspectionPoint) {
		this.inspectionPoint=inspectionPoint;
		return this;
	}
	
	/**
	 * 获得 inspectionTaskPoint<br>
	 * inspectionTaskPoint
	 * @return inspectionTaskPoint
	*/
	public InspectionTaskPoint getInspectionTaskPoint() {
		return inspectionTaskPoint;
	}
	
	/**
	 * 设置 inspectionTaskPoint
	 * @param inspectionTaskPoint inspectionTaskPoint
	 * @return 当前对象
	*/
	public CheckSelect setInspectionTaskPoint(InspectionTaskPoint inspectionTaskPoint) {
		this.inspectionTaskPoint=inspectionTaskPoint;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CheckSelect , 转换好的 CheckSelect 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CheckSelect , 转换好的 PoJo 对象
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
	public CheckSelect clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CheckSelect duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.CheckSelectMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.CheckSelectMeta.$$proxy$$();
		inst.setConfigDefValue(this.getConfigDefValue());
		inst.setItemCode(this.getItemCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setType(this.getType());
		inst.setItemDesc(this.getItemDesc());
		inst.setVersion(this.getVersion());
		inst.setTaskPointId(this.getTaskPointId());
		inst.setResult(this.getResult());
		inst.setItemId(this.getItemId());
		inst.setItemName(this.getItemName());
		inst.setCreateBy(this.getCreateBy());
		inst.setResultMetaData(this.getResultMetaData());
		inst.setDeleted(this.getDeleted());
		inst.setPointId(this.getPointId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setIfCheck(this.getIfCheck());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setConfig(this.getConfig());
		inst.setTaskId(this.getTaskId());
		if(all) {
			inst.setCheckItem(this.getCheckItem());
			inst.setInspectionTaskPoint(this.getInspectionTaskPoint());
			inst.setInspectionPoint(this.getInspectionPoint());
			inst.setInspectionTask(this.getInspectionTask());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CheckSelect clone(boolean deep) {
		return EntityContext.clone(CheckSelect.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CheckSelect
	 * @param checkSelectMap 包含实体信息的 Map 对象
	 * @return CheckSelect , 转换好的的 CheckSelect 对象
	*/
	@Transient
	public static CheckSelect createFrom(Map<String,Object> checkSelectMap) {
		if(checkSelectMap==null) return null;
		CheckSelect po = create();
		EntityContext.copyProperties(po,checkSelectMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CheckSelect
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CheckSelect , 转换好的的 CheckSelect 对象
	*/
	@Transient
	public static CheckSelect createFrom(Object pojo) {
		if(pojo==null) return null;
		CheckSelect po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CheckSelect，等同于 new
	 * @return CheckSelect 对象
	*/
	@Transient
	public static CheckSelect create() {
		return new com.dt.platform.domain.eam.meta.CheckSelectMeta.$$proxy$$();
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
			this.setConfigDefValue(DataParser.parse(String.class, map.get(CheckSelectMeta.CONFIG_DEF_VALUE)));
			this.setItemCode(DataParser.parse(String.class, map.get(CheckSelectMeta.ITEM_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CheckSelectMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(CheckSelectMeta.SORT)));
			this.setType(DataParser.parse(String.class, map.get(CheckSelectMeta.TYPE)));
			this.setItemDesc(DataParser.parse(String.class, map.get(CheckSelectMeta.ITEM_DESC)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CheckSelectMeta.VERSION)));
			this.setTaskPointId(DataParser.parse(String.class, map.get(CheckSelectMeta.TASK_POINT_ID)));
			this.setResult(DataParser.parse(String.class, map.get(CheckSelectMeta.RESULT)));
			this.setItemId(DataParser.parse(String.class, map.get(CheckSelectMeta.ITEM_ID)));
			this.setItemName(DataParser.parse(String.class, map.get(CheckSelectMeta.ITEM_NAME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CheckSelectMeta.CREATE_BY)));
			this.setResultMetaData(DataParser.parse(String.class, map.get(CheckSelectMeta.RESULT_META_DATA)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CheckSelectMeta.DELETED)));
			this.setPointId(DataParser.parse(String.class, map.get(CheckSelectMeta.POINT_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CheckSelectMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CheckSelectMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CheckSelectMeta.DELETE_TIME)));
			this.setIfCheck(DataParser.parse(String.class, map.get(CheckSelectMeta.IF_CHECK)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CheckSelectMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CheckSelectMeta.ID)));
			this.setConfig(DataParser.parse(String.class, map.get(CheckSelectMeta.CONFIG)));
			this.setTaskId(DataParser.parse(String.class, map.get(CheckSelectMeta.TASK_ID)));
			// others
			this.setCheckItem(DataParser.parse(CheckItem.class, map.get(CheckSelectMeta.CHECK_ITEM)));
			this.setInspectionTaskPoint(DataParser.parse(InspectionTaskPoint.class, map.get(CheckSelectMeta.INSPECTION_TASK_POINT)));
			this.setInspectionPoint(DataParser.parse(InspectionPoint.class, map.get(CheckSelectMeta.INSPECTION_POINT)));
			this.setInspectionTask(DataParser.parse(InspectionTask.class, map.get(CheckSelectMeta.INSPECTION_TASK)));
			return true;
		} else {
			try {
				this.setConfigDefValue( (String)map.get(CheckSelectMeta.CONFIG_DEF_VALUE));
				this.setItemCode( (String)map.get(CheckSelectMeta.ITEM_CODE));
				this.setUpdateTime( (Date)map.get(CheckSelectMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(CheckSelectMeta.SORT));
				this.setType( (String)map.get(CheckSelectMeta.TYPE));
				this.setItemDesc( (String)map.get(CheckSelectMeta.ITEM_DESC));
				this.setVersion( (Integer)map.get(CheckSelectMeta.VERSION));
				this.setTaskPointId( (String)map.get(CheckSelectMeta.TASK_POINT_ID));
				this.setResult( (String)map.get(CheckSelectMeta.RESULT));
				this.setItemId( (String)map.get(CheckSelectMeta.ITEM_ID));
				this.setItemName( (String)map.get(CheckSelectMeta.ITEM_NAME));
				this.setCreateBy( (String)map.get(CheckSelectMeta.CREATE_BY));
				this.setResultMetaData( (String)map.get(CheckSelectMeta.RESULT_META_DATA));
				this.setDeleted( (Integer)map.get(CheckSelectMeta.DELETED));
				this.setPointId( (String)map.get(CheckSelectMeta.POINT_ID));
				this.setCreateTime( (Date)map.get(CheckSelectMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CheckSelectMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CheckSelectMeta.DELETE_TIME));
				this.setIfCheck( (String)map.get(CheckSelectMeta.IF_CHECK));
				this.setDeleteBy( (String)map.get(CheckSelectMeta.DELETE_BY));
				this.setId( (String)map.get(CheckSelectMeta.ID));
				this.setConfig( (String)map.get(CheckSelectMeta.CONFIG));
				this.setTaskId( (String)map.get(CheckSelectMeta.TASK_ID));
				// others
				this.setCheckItem( (CheckItem)map.get(CheckSelectMeta.CHECK_ITEM));
				this.setInspectionTaskPoint( (InspectionTaskPoint)map.get(CheckSelectMeta.INSPECTION_TASK_POINT));
				this.setInspectionPoint( (InspectionPoint)map.get(CheckSelectMeta.INSPECTION_POINT));
				this.setInspectionTask( (InspectionTask)map.get(CheckSelectMeta.INSPECTION_TASK));
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
			this.setConfigDefValue(DataParser.parse(String.class, r.getValue(CheckSelectMeta.CONFIG_DEF_VALUE)));
			this.setItemCode(DataParser.parse(String.class, r.getValue(CheckSelectMeta.ITEM_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CheckSelectMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(CheckSelectMeta.SORT)));
			this.setType(DataParser.parse(String.class, r.getValue(CheckSelectMeta.TYPE)));
			this.setItemDesc(DataParser.parse(String.class, r.getValue(CheckSelectMeta.ITEM_DESC)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CheckSelectMeta.VERSION)));
			this.setTaskPointId(DataParser.parse(String.class, r.getValue(CheckSelectMeta.TASK_POINT_ID)));
			this.setResult(DataParser.parse(String.class, r.getValue(CheckSelectMeta.RESULT)));
			this.setItemId(DataParser.parse(String.class, r.getValue(CheckSelectMeta.ITEM_ID)));
			this.setItemName(DataParser.parse(String.class, r.getValue(CheckSelectMeta.ITEM_NAME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CheckSelectMeta.CREATE_BY)));
			this.setResultMetaData(DataParser.parse(String.class, r.getValue(CheckSelectMeta.RESULT_META_DATA)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CheckSelectMeta.DELETED)));
			this.setPointId(DataParser.parse(String.class, r.getValue(CheckSelectMeta.POINT_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CheckSelectMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CheckSelectMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CheckSelectMeta.DELETE_TIME)));
			this.setIfCheck(DataParser.parse(String.class, r.getValue(CheckSelectMeta.IF_CHECK)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CheckSelectMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CheckSelectMeta.ID)));
			this.setConfig(DataParser.parse(String.class, r.getValue(CheckSelectMeta.CONFIG)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(CheckSelectMeta.TASK_ID)));
			return true;
		} else {
			try {
				this.setConfigDefValue( (String)r.getValue(CheckSelectMeta.CONFIG_DEF_VALUE));
				this.setItemCode( (String)r.getValue(CheckSelectMeta.ITEM_CODE));
				this.setUpdateTime( (Date)r.getValue(CheckSelectMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(CheckSelectMeta.SORT));
				this.setType( (String)r.getValue(CheckSelectMeta.TYPE));
				this.setItemDesc( (String)r.getValue(CheckSelectMeta.ITEM_DESC));
				this.setVersion( (Integer)r.getValue(CheckSelectMeta.VERSION));
				this.setTaskPointId( (String)r.getValue(CheckSelectMeta.TASK_POINT_ID));
				this.setResult( (String)r.getValue(CheckSelectMeta.RESULT));
				this.setItemId( (String)r.getValue(CheckSelectMeta.ITEM_ID));
				this.setItemName( (String)r.getValue(CheckSelectMeta.ITEM_NAME));
				this.setCreateBy( (String)r.getValue(CheckSelectMeta.CREATE_BY));
				this.setResultMetaData( (String)r.getValue(CheckSelectMeta.RESULT_META_DATA));
				this.setDeleted( (Integer)r.getValue(CheckSelectMeta.DELETED));
				this.setPointId( (String)r.getValue(CheckSelectMeta.POINT_ID));
				this.setCreateTime( (Date)r.getValue(CheckSelectMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CheckSelectMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CheckSelectMeta.DELETE_TIME));
				this.setIfCheck( (String)r.getValue(CheckSelectMeta.IF_CHECK));
				this.setDeleteBy( (String)r.getValue(CheckSelectMeta.DELETE_BY));
				this.setId( (String)r.getValue(CheckSelectMeta.ID));
				this.setConfig( (String)r.getValue(CheckSelectMeta.CONFIG));
				this.setTaskId( (String)r.getValue(CheckSelectMeta.TASK_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}