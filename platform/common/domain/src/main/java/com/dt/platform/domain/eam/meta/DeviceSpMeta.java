package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.DeviceSp;
import java.util.Date;
import com.dt.platform.domain.eam.Goods;
import com.dt.platform.domain.eam.DeviceSpType;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.Position;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.Asset;
import java.util.List;
import com.dt.platform.domain.eam.DeviceAssociate;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-07-24 06:47:50
 * @sign 4837F1F6DF7E7FA7B4AFF0404847C18A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DeviceSpMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 备件编号 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 备件编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,CODE, java.lang.String.class, "备件编号", "备件编号", java.lang.String.class, null);
	
	/**
	 * 物品 , 类型: java.lang.String
	*/
	public static final String GOOD_ID="goodId";
	
	/**
	 * 物品 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> GOOD_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,GOOD_ID, java.lang.String.class, "物品", "物品", java.lang.String.class, null);
	
	/**
	 * 备件分类 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 备件分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,TYPE, java.lang.String.class, "备件分类", "备件分类", java.lang.String.class, null);
	
	/**
	 * 备件状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 备件状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,STATUS, java.lang.String.class, "备件状态", "备件状态", java.lang.String.class, null);
	
	/**
	 * 备件名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 备件名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,NAME, java.lang.String.class, "备件名称", "备件名称", java.lang.String.class, null);
	
	/**
	 * 规格型号 , 类型: java.lang.String
	*/
	public static final String MODEL="model";
	
	/**
	 * 规格型号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> MODEL_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,MODEL, java.lang.String.class, "规格型号", "规格型号", java.lang.String.class, null);
	
	/**
	 * 备件序列 , 类型: java.lang.String
	*/
	public static final String SN="sn";
	
	/**
	 * 备件序列 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> SN_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,SN, java.lang.String.class, "备件序列", "备件序列", java.lang.String.class, null);
	
	/**
	 * 使用场景 , 类型: java.lang.String
	*/
	public static final String USAGE_RANGE="usageRange";
	
	/**
	 * 使用场景 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> USAGE_RANGE_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,USAGE_RANGE, java.lang.String.class, "使用场景", "使用场景", java.lang.String.class, null);
	
	/**
	 * 存放位置 , 类型: java.lang.String
	*/
	public static final String LOC_ID="locId";
	
	/**
	 * 存放位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> LOC_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,LOC_ID, java.lang.String.class, "存放位置", "存放位置", java.lang.String.class, null);
	
	/**
	 * 适配设备 , 类型: java.lang.String
	*/
	public static final String ADAPTING_DEVICE="adaptingDevice";
	
	/**
	 * 适配设备 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> ADAPTING_DEVICE_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,ADAPTING_DEVICE, java.lang.String.class, "适配设备", "适配设备", java.lang.String.class, null);
	
	/**
	 * 来源描述 , 类型: java.lang.String
	*/
	public static final String SOURCE_DESC="sourceDesc";
	
	/**
	 * 来源描述 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> SOURCE_DESC_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,SOURCE_DESC, java.lang.String.class, "来源描述", "来源描述", java.lang.String.class, null);
	
	/**
	 * 供应厂商 , 类型: java.lang.String
	*/
	public static final String SUPPLIER="supplier";
	
	/**
	 * 供应厂商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> SUPPLIER_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,SUPPLIER, java.lang.String.class, "供应厂商", "供应厂商", java.lang.String.class, null);
	
	/**
	 * 保管人员 , 类型: java.lang.String
	*/
	public static final String MANAGER_USER_ID="managerUserId";
	
	/**
	 * 保管人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> MANAGER_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,MANAGER_USER_ID, java.lang.String.class, "保管人员", "保管人员", java.lang.String.class, null);
	
	/**
	 * 入库时间 , 类型: java.util.Date
	*/
	public static final String INSERT_TIME="insertTime";
	
	/**
	 * 入库时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.util.Date> INSERT_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,INSERT_TIME, java.util.Date.class, "入库时间", "入库时间", java.util.Date.class, null);
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,PICTURE_ID, java.lang.String.class, "图片", "图片", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 是否锁定 , 类型: java.lang.String
	*/
	public static final String LOCKED="locked";
	
	/**
	 * 是否锁定 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> LOCKED_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,LOCKED, java.lang.String.class, "是否锁定", "是否锁定", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * goods , 类型: com.dt.platform.domain.eam.Goods
	*/
	public static final String GOODS="goods";
	
	/**
	 * goods , 类型: com.dt.platform.domain.eam.Goods
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,com.dt.platform.domain.eam.Goods> GOODS_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,GOODS, com.dt.platform.domain.eam.Goods.class, "goods", "goods", com.dt.platform.domain.eam.Goods.class, null);
	
	/**
	 * deviceSpType , 类型: com.dt.platform.domain.eam.DeviceSpType
	*/
	public static final String DEVICE_SP_TYPE="deviceSpType";
	
	/**
	 * deviceSpType , 类型: com.dt.platform.domain.eam.DeviceSpType
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,com.dt.platform.domain.eam.DeviceSpType> DEVICE_SP_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,DEVICE_SP_TYPE, com.dt.platform.domain.eam.DeviceSpType.class, "deviceSpType", "deviceSpType", com.dt.platform.domain.eam.DeviceSpType.class, null);
	
	/**
	 * manager , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String MANAGER="manager";
	
	/**
	 * manager , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,org.github.foxnic.web.domain.hrm.Employee> MANAGER_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,MANAGER, org.github.foxnic.web.domain.hrm.Employee.class, "manager", "manager", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 存放位置 , 类型: com.dt.platform.domain.eam.Position
	*/
	public static final String POSITION="position";
	
	/**
	 * 存放位置 , 类型: com.dt.platform.domain.eam.Position
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,com.dt.platform.domain.eam.Position> POSITION_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,POSITION, com.dt.platform.domain.eam.Position.class, "存放位置", "存放位置", com.dt.platform.domain.eam.Position.class, null);
	
	/**
	 * usage , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String USAGE="usage";
	
	/**
	 * usage , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,org.github.foxnic.web.domain.system.DictItem> USAGE_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,USAGE, org.github.foxnic.web.domain.system.DictItem.class, "usage", "usage", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * assetList , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET_LIST="assetList";
	
	/**
	 * assetList , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,com.dt.platform.domain.eam.Asset> ASSET_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,ASSET_LIST, java.util.List.class, "assetList", "assetList", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * deviceAssociate , 集合类型: LIST , 类型: com.dt.platform.domain.eam.DeviceAssociate
	*/
	public static final String DEVICE_ASSOCIATE="deviceAssociate";
	
	/**
	 * deviceAssociate , 集合类型: LIST , 类型: com.dt.platform.domain.eam.DeviceAssociate
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,com.dt.platform.domain.eam.DeviceAssociate> DEVICE_ASSOCIATE_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,DEVICE_ASSOCIATE, java.util.List.class, "deviceAssociate", "deviceAssociate", com.dt.platform.domain.eam.DeviceAssociate.class, null);
	
	/**
	 * ownerType , 类型: java.lang.String
	*/
	public static final String OWNER_TYPE="ownerType";
	
	/**
	 * ownerType , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> OWNER_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,OWNER_TYPE, java.lang.String.class, "ownerType", "ownerType", java.lang.String.class, null);
	
	/**
	 * selectedCode , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * selectedCode , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,SELECTED_CODE, java.lang.String.class, "selectedCode", "selectedCode", java.lang.String.class, null);
	
	/**
	 * ownerId , 类型: java.lang.String
	*/
	public static final String OWNER_ID="ownerId";
	
	/**
	 * ownerId , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> OWNER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,OWNER_ID, java.lang.String.class, "ownerId", "ownerId", java.lang.String.class, null);
	
	/**
	 * psCategoryId , 类型: java.lang.String
	*/
	public static final String PS_CATEGORY_ID="psCategoryId";
	
	/**
	 * psCategoryId , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.DeviceSp,java.lang.String> PS_CATEGORY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.DeviceSp.class ,PS_CATEGORY_ID, java.lang.String.class, "psCategoryId", "psCategoryId", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , GOOD_ID , TYPE , STATUS , NAME , MODEL , SN , USAGE_RANGE , LOC_ID , ADAPTING_DEVICE , SOURCE_DESC , SUPPLIER , MANAGER_USER_ID , INSERT_TIME , PICTURE_ID , NOTES , LOCKED , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , GOODS , DEVICE_SP_TYPE , MANAGER , POSITION , USAGE , ASSET_LIST , DEVICE_ASSOCIATE , OWNER_TYPE , SELECTED_CODE , OWNER_ID , PS_CATEGORY_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.DeviceSp {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public DeviceSp setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 备件编号
		 * @param code 备件编号
		 * @return 当前对象
		*/
		public DeviceSp setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 物品
		 * @param goodId 物品
		 * @return 当前对象
		*/
		public DeviceSp setGoodId(String goodId) {
			super.change(GOOD_ID,super.getGoodId(),goodId);
			super.setGoodId(goodId);
			return this;
		}
		
		/**
		 * 设置 备件分类
		 * @param type 备件分类
		 * @return 当前对象
		*/
		public DeviceSp setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 备件状态
		 * @param status 备件状态
		 * @return 当前对象
		*/
		public DeviceSp setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 备件名称
		 * @param name 备件名称
		 * @return 当前对象
		*/
		public DeviceSp setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 规格型号
		 * @param model 规格型号
		 * @return 当前对象
		*/
		public DeviceSp setModel(String model) {
			super.change(MODEL,super.getModel(),model);
			super.setModel(model);
			return this;
		}
		
		/**
		 * 设置 备件序列
		 * @param sn 备件序列
		 * @return 当前对象
		*/
		public DeviceSp setSn(String sn) {
			super.change(SN,super.getSn(),sn);
			super.setSn(sn);
			return this;
		}
		
		/**
		 * 设置 使用场景
		 * @param usageRange 使用场景
		 * @return 当前对象
		*/
		public DeviceSp setUsageRange(String usageRange) {
			super.change(USAGE_RANGE,super.getUsageRange(),usageRange);
			super.setUsageRange(usageRange);
			return this;
		}
		
		/**
		 * 设置 存放位置
		 * @param locId 存放位置
		 * @return 当前对象
		*/
		public DeviceSp setLocId(String locId) {
			super.change(LOC_ID,super.getLocId(),locId);
			super.setLocId(locId);
			return this;
		}
		
		/**
		 * 设置 适配设备
		 * @param adaptingDevice 适配设备
		 * @return 当前对象
		*/
		public DeviceSp setAdaptingDevice(String adaptingDevice) {
			super.change(ADAPTING_DEVICE,super.getAdaptingDevice(),adaptingDevice);
			super.setAdaptingDevice(adaptingDevice);
			return this;
		}
		
		/**
		 * 设置 来源描述
		 * @param sourceDesc 来源描述
		 * @return 当前对象
		*/
		public DeviceSp setSourceDesc(String sourceDesc) {
			super.change(SOURCE_DESC,super.getSourceDesc(),sourceDesc);
			super.setSourceDesc(sourceDesc);
			return this;
		}
		
		/**
		 * 设置 供应厂商
		 * @param supplier 供应厂商
		 * @return 当前对象
		*/
		public DeviceSp setSupplier(String supplier) {
			super.change(SUPPLIER,super.getSupplier(),supplier);
			super.setSupplier(supplier);
			return this;
		}
		
		/**
		 * 设置 保管人员
		 * @param managerUserId 保管人员
		 * @return 当前对象
		*/
		public DeviceSp setManagerUserId(String managerUserId) {
			super.change(MANAGER_USER_ID,super.getManagerUserId(),managerUserId);
			super.setManagerUserId(managerUserId);
			return this;
		}
		
		/**
		 * 设置 入库时间
		 * @param insertTime 入库时间
		 * @return 当前对象
		*/
		public DeviceSp setInsertTime(Date insertTime) {
			super.change(INSERT_TIME,super.getInsertTime(),insertTime);
			super.setInsertTime(insertTime);
			return this;
		}
		
		/**
		 * 设置 图片
		 * @param pictureId 图片
		 * @return 当前对象
		*/
		public DeviceSp setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public DeviceSp setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 是否锁定
		 * @param locked 是否锁定
		 * @return 当前对象
		*/
		public DeviceSp setLocked(String locked) {
			super.change(LOCKED,super.getLocked(),locked);
			super.setLocked(locked);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public DeviceSp setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public DeviceSp setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public DeviceSp setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public DeviceSp setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public DeviceSp setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public DeviceSp setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public DeviceSp setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public DeviceSp setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public DeviceSp setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 goods
		 * @param goods goods
		 * @return 当前对象
		*/
		public DeviceSp setGoods(Goods goods) {
			super.change(GOODS,super.getGoods(),goods);
			super.setGoods(goods);
			return this;
		}
		
		/**
		 * 设置 deviceSpType
		 * @param deviceSpType deviceSpType
		 * @return 当前对象
		*/
		public DeviceSp setDeviceSpType(DeviceSpType deviceSpType) {
			super.change(DEVICE_SP_TYPE,super.getDeviceSpType(),deviceSpType);
			super.setDeviceSpType(deviceSpType);
			return this;
		}
		
		/**
		 * 设置 manager
		 * @param manager manager
		 * @return 当前对象
		*/
		public DeviceSp setManager(Employee manager) {
			super.change(MANAGER,super.getManager(),manager);
			super.setManager(manager);
			return this;
		}
		
		/**
		 * 设置 存放位置
		 * @param position 存放位置
		 * @return 当前对象
		*/
		public DeviceSp setPosition(Position position) {
			super.change(POSITION,super.getPosition(),position);
			super.setPosition(position);
			return this;
		}
		
		/**
		 * 设置 usage
		 * @param usage usage
		 * @return 当前对象
		*/
		public DeviceSp setUsage(DictItem usage) {
			super.change(USAGE,super.getUsage(),usage);
			super.setUsage(usage);
			return this;
		}
		
		/**
		 * 设置 assetList
		 * @param assetList assetList
		 * @return 当前对象
		*/
		public DeviceSp setAssetList(List<Asset> assetList) {
			super.change(ASSET_LIST,super.getAssetList(),assetList);
			super.setAssetList(assetList);
			return this;
		}
		
		/**
		 * 设置 deviceAssociate
		 * @param deviceAssociate deviceAssociate
		 * @return 当前对象
		*/
		public DeviceSp setDeviceAssociate(List<DeviceAssociate> deviceAssociate) {
			super.change(DEVICE_ASSOCIATE,super.getDeviceAssociate(),deviceAssociate);
			super.setDeviceAssociate(deviceAssociate);
			return this;
		}
		
		/**
		 * 设置 ownerType
		 * @param ownerType ownerType
		 * @return 当前对象
		*/
		public DeviceSp setOwnerType(String ownerType) {
			super.change(OWNER_TYPE,super.getOwnerType(),ownerType);
			super.setOwnerType(ownerType);
			return this;
		}
		
		/**
		 * 设置 selectedCode
		 * @param selectedCode selectedCode
		 * @return 当前对象
		*/
		public DeviceSp setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 ownerId
		 * @param ownerId ownerId
		 * @return 当前对象
		*/
		public DeviceSp setOwnerId(String ownerId) {
			super.change(OWNER_ID,super.getOwnerId(),ownerId);
			super.setOwnerId(ownerId);
			return this;
		}
		
		/**
		 * 设置 psCategoryId
		 * @param psCategoryId psCategoryId
		 * @return 当前对象
		*/
		public DeviceSp setPsCategoryId(String psCategoryId) {
			super.change(PS_CATEGORY_ID,super.getPsCategoryId(),psCategoryId);
			super.setPsCategoryId(psCategoryId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public DeviceSp clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public DeviceSp duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCode(this.getCode());
			inst.setNotes(this.getNotes());
			inst.setType(this.getType());
			inst.setUsageRange(this.getUsageRange());
			inst.setPictureId(this.getPictureId());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setAdaptingDevice(this.getAdaptingDevice());
			inst.setSupplier(this.getSupplier());
			inst.setModel(this.getModel());
			inst.setId(this.getId());
			inst.setSn(this.getSn());
			inst.setLocked(this.getLocked());
			inst.setLocId(this.getLocId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setGoodId(this.getGoodId());
			inst.setVersion(this.getVersion());
			inst.setInsertTime(this.getInsertTime());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setManagerUserId(this.getManagerUserId());
			inst.setSourceDesc(this.getSourceDesc());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setOwnerType(this.getOwnerType());
				inst.setPsCategoryId(this.getPsCategoryId());
				inst.setDeviceSpType(this.getDeviceSpType());
				inst.setManager(this.getManager());
				inst.setUsage(this.getUsage());
				inst.setGoods(this.getGoods());
				inst.setPosition(this.getPosition());
				inst.setAssetList(this.getAssetList());
				inst.setDeviceAssociate(this.getDeviceAssociate());
				inst.setOwnerId(this.getOwnerId());
				inst.setSelectedCode(this.getSelectedCode());
			}
			inst.clearModifies();
			return inst;
		}

	}
}