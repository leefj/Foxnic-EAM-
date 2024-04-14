package com.dt.platform.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2024-04-08 07:38:50
 * @author 金杰 , maillank@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class IotTables {
	
	/**
	 * 设备列表
	*/
	public static class IOT_EQUIPMENT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "iot_equipment";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 产品
		*/
		public static final DBField PRODUCT_ID = new DBField(DBDataType.STRING , "product_id","productId","产品","产品",false,false,true);
		
		/**
		 * 设备DN
		*/
		public static final DBField DN = new DBField(DBDataType.STRING , "dn","dn","设备DN","设备DN",false,false,true);
		
		/**
		 * 设备编码
		*/
		public static final DBField EQUIPMENT_CODE = new DBField(DBDataType.STRING , "equipment_code","equipmentCode","设备编码","设备编码",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 分组
		*/
		public static final DBField GROUP_CODE = new DBField(DBDataType.STRING , "group_code","groupCode","分组","分组",false,false,true);
		
		/**
		 * 设备密钥
		*/
		public static final DBField EQUIPMENT_KEY = new DBField(DBDataType.STRING , "equipment_key","equipmentKey","设备密钥","设备密钥",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public IOT_EQUIPMENT() {
			this.init($NAME,"设备列表" , ID , PRODUCT_ID , DN , EQUIPMENT_CODE , STATUS , GROUP_CODE , EQUIPMENT_KEY , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final IOT_EQUIPMENT $TABLE=new IOT_EQUIPMENT();
	}
	
	/**
	 * 设备标签
	*/
	public static class IOT_EQUIPMENT_LABEL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "iot_equipment_label";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所属
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所属","所属",false,false,true);
		
		/**
		 * 标签名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","标签名称","标签名称",false,false,true);
		
		/**
		 * 标识符
		*/
		public static final DBField IDENTIFIER = new DBField(DBDataType.STRING , "identifier","identifier","标识符","标识符",false,false,true);
		
		/**
		 * 标签值
		*/
		public static final DBField VALUE = new DBField(DBDataType.STRING , "value","value","标签值","标签值",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public IOT_EQUIPMENT_LABEL() {
			this.init($NAME,"设备标签" , ID , OWNER_ID , NAME , IDENTIFIER , VALUE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final IOT_EQUIPMENT_LABEL $TABLE=new IOT_EQUIPMENT_LABEL();
	}
	
	/**
	 * 设备日志
	*/
	public static class IOT_EQUIPMENT_LOG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "iot_equipment_log";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所属
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所属","所属",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 标识符
		*/
		public static final DBField IDENTIFIER = new DBField(DBDataType.STRING , "identifier","identifier","标识符","标识符",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 记录时间
		*/
		public static final DBField RCD_TIME = new DBField(DBDataType.DATE , "rcd_time","rcdTime","记录时间","记录时间",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public IOT_EQUIPMENT_LOG() {
			this.init($NAME,"设备日志" , ID , OWNER_ID , TYPE , IDENTIFIER , CONTENT , RCD_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final IOT_EQUIPMENT_LOG $TABLE=new IOT_EQUIPMENT_LOG();
	}
	
	/**
	 * 产品管理
	*/
	public static class IOT_PRODUCT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "iot_product";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 产品Key
		*/
		public static final DBField PRODUCT_KEY = new DBField(DBDataType.STRING , "product_key","productKey","产品Key","产品Key",false,false,true);
		
		/**
		 * 产品名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","产品名称","产品名称",false,false,true);
		
		/**
		 * 品类
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","品类","品类",false,false,true);
		
		/**
		 * 节点类型
		*/
		public static final DBField PRODUCT_TYPE = new DBField(DBDataType.STRING , "product_type","productType","节点类型","节点类型",false,false,true);
		
		/**
		 * 透传设备
		*/
		public static final DBField PRODUCT_TRANSPARENT = new DBField(DBDataType.STRING , "product_transparent","productTransparent","透传设备","透传设备",false,false,true);
		
		/**
		 * 设备定位
		*/
		public static final DBField LOCATION_STATUS = new DBField(DBDataType.STRING , "location_status","locationStatus","设备定位","设备定位",false,false,true);
		
		/**
		 * 定位方式
		*/
		public static final DBField LOCATION_METHOD = new DBField(DBDataType.STRING , "location_method","locationMethod","定位方式","定位方式",false,false,true);
		
		/**
		 * 图片
		*/
		public static final DBField IMAGE_ID = new DBField(DBDataType.STRING , "image_id","imageId","图片","图片",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public IOT_PRODUCT() {
			this.init($NAME,"产品管理" , ID , PRODUCT_KEY , NAME , CATEGORY_ID , PRODUCT_TYPE , PRODUCT_TRANSPARENT , LOCATION_STATUS , LOCATION_METHOD , IMAGE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final IOT_PRODUCT $TABLE=new IOT_PRODUCT();
	}
	
	/**
	 * 设备内容
	*/
	public static class IOT_PRODUCT_CONTENT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "iot_product_content";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 产品
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","产品","产品",false,false,true);
		
		/**
		 * 配置
		*/
		public static final DBField CONF = new DBField(DBDataType.STRING , "conf","conf","配置","配置",false,false,true);
		
		/**
		 * TSL
		*/
		public static final DBField TSL = new DBField(DBDataType.STRING , "tsl","tsl","TSL","TSL",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public IOT_PRODUCT_CONTENT() {
			this.init($NAME,"设备内容" , ID , OWNER_ID , CONF , TSL , TYPE , CONTENT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final IOT_PRODUCT_CONTENT $TABLE=new IOT_PRODUCT_CONTENT();
	}
	
	/**
	 * 功能
	*/
	public static class IOT_PRODUCT_FUNCTION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "iot_product_function";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 功能类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","功能类型","功能类型",false,false,true);
		
		/**
		 * 产品
		*/
		public static final DBField PRODUCT_ID = new DBField(DBDataType.STRING , "product_id","productId","产品","产品",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 标识符
		*/
		public static final DBField IDENTIFIER = new DBField(DBDataType.STRING , "identifier","identifier","标识符","标识符",false,false,true);
		
		/**
		 * 描述
		*/
		public static final DBField FUNCTION_DESC = new DBField(DBDataType.STRING , "function_desc","functionDesc","描述","描述",false,false,true);
		
		/**
		 * 单位
		*/
		public static final DBField FUNCTION_UNIT = new DBField(DBDataType.STRING , "function_unit","functionUnit","单位","单位",false,false,true);
		
		/**
		 * 数据类型
		*/
		public static final DBField DATA_TYPE = new DBField(DBDataType.STRING , "data_type","dataType","数据类型","数据类型",false,false,true);
		
		/**
		 * 内容定义
		*/
		public static final DBField DATA_VALUE = new DBField(DBDataType.STRING , "data_value","dataValue","内容定义","内容定义",false,false,true);
		
		/**
		 * 读写
		*/
		public static final DBField ACL = new DBField(DBDataType.STRING , "acl","acl","读写","读写",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public IOT_PRODUCT_FUNCTION() {
			this.init($NAME,"功能" , ID , TYPE , PRODUCT_ID , NAME , IDENTIFIER , FUNCTION_DESC , FUNCTION_UNIT , DATA_TYPE , DATA_VALUE , ACL , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final IOT_PRODUCT_FUNCTION $TABLE=new IOT_PRODUCT_FUNCTION();
	}
	
	/**
	 * 内容
	*/
	public static class IOT_PRODUCT_FUNCTION_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "iot_product_function_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所属
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所属","所属",false,false,true);
		
		/**
		 * 类型,input,output
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","input,output",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 标识符
		*/
		public static final DBField IDENTIFIER = new DBField(DBDataType.STRING , "identifier","identifier","标识符","标识符",false,false,true);
		
		/**
		 * 描述
		*/
		public static final DBField FUNCTION_DESC = new DBField(DBDataType.STRING , "function_desc","functionDesc","描述","描述",false,false,true);
		
		/**
		 * 单位
		*/
		public static final DBField FUNCTION_UNIT = new DBField(DBDataType.STRING , "function_unit","functionUnit","单位","单位",false,false,true);
		
		/**
		 * 数据类型
		*/
		public static final DBField DATA_TYPE = new DBField(DBDataType.STRING , "data_type","dataType","数据类型","数据类型",false,false,true);
		
		/**
		 * 内容定义
		*/
		public static final DBField DATA_VALUE = new DBField(DBDataType.STRING , "data_value","dataValue","内容定义","内容定义",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public IOT_PRODUCT_FUNCTION_ITEM() {
			this.init($NAME,"内容" , ID , OWNER_ID , TYPE , NAME , IDENTIFIER , FUNCTION_DESC , FUNCTION_UNIT , DATA_TYPE , DATA_VALUE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final IOT_PRODUCT_FUNCTION_ITEM $TABLE=new IOT_PRODUCT_FUNCTION_ITEM();
	}
	
	/**
	 * 虚拟设备
	*/
	public static class IOT_VIRT_EQUIPMENT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "iot_virt_equipment";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 所属产品
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所属产品","所属产品",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 触发方式
		*/
		public static final DBField TRIGGER_TYPE = new DBField(DBDataType.STRING , "trigger_type","triggerType","触发方式","触发方式",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * crontab表达式
		*/
		public static final DBField CRONTAB_VALUE = new DBField(DBDataType.STRING , "crontab_value","crontabValue","crontab表达式","crontab表达式",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public IOT_VIRT_EQUIPMENT() {
			this.init($NAME,"虚拟设备" , ID , NAME , OWNER_ID , TYPE , TRIGGER_TYPE , STATUS , CRONTAB_VALUE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final IOT_VIRT_EQUIPMENT $TABLE=new IOT_VIRT_EQUIPMENT();
	}
}