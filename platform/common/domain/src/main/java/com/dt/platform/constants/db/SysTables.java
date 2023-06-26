package com.dt.platform.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2023-06-18 19:13:24
 * @author 金杰 , maillank@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class SysTables {
	
	/**
	 * 模块角色
	*/
	public static class SYS_AUTO_MODULE_ROLE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_auto_module_role";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 模块
		*/
		public static final DBField MODULE = new DBField(DBDataType.STRING , "module","module","模块","模块",false,false,true);
		
		/**
		 * 类型,role|data_role|busi_role
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","role|data_role|busi_role",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_AUTO_MODULE_ROLE() {
			this.init($NAME,"模块角色" , ID , NAME , STATUS , MODULE , TYPE , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_AUTO_MODULE_ROLE $TABLE=new SYS_AUTO_MODULE_ROLE();
	}
	
	/**
	 * 赋权明细
	*/
	public static class SYS_AUTO_MODULE_ROLE_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_auto_module_role_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 模块
		*/
		public static final DBField MODULE_ROLE_ID = new DBField(DBDataType.STRING , "module_role_id","moduleRoleId","模块","模块",false,false,true);
		
		/**
		 * 角色
		*/
		public static final DBField ROLE_ID = new DBField(DBDataType.STRING , "role_id","roleId","角色","角色",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField ROLE_NAME = new DBField(DBDataType.STRING , "role_name","roleName","名称","名称",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_AUTO_MODULE_ROLE_ITEM() {
			this.init($NAME,"赋权明细" , ID , MODULE_ROLE_ID , ROLE_ID , ROLE_NAME , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_AUTO_MODULE_ROLE_ITEM $TABLE=new SYS_AUTO_MODULE_ROLE_ITEM();
	}
	
	/**
	 * 操作日志
	*/
	public static class SYS_AUTO_ROLE_GRANT_RCD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_auto_role_grant_rcd";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 模块
		*/
		public static final DBField MODULE_ROLE_ID = new DBField(DBDataType.STRING , "module_role_id","moduleRoleId","模块","模块",false,false,true);
		
		/**
		 * 角色
		*/
		public static final DBField ROLE_ID = new DBField(DBDataType.STRING , "role_id","roleId","角色","角色",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","用户","用户",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_AUTO_ROLE_GRANT_RCD() {
			this.init($NAME,"操作日志" , ID , MODULE_ROLE_ID , ROLE_ID , USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_AUTO_ROLE_GRANT_RCD $TABLE=new SYS_AUTO_ROLE_GRANT_RCD();
	}
	
	/**
	 * 预定用户
	*/
	public static class SYS_AUTO_USER_PREDEFINED extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_auto_user_predefined";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 用户
		*/
		public static final DBField ACCOUNT = new DBField(DBDataType.STRING , "account","account","用户","用户",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_AUTO_USER_PREDEFINED() {
			this.init($NAME,"预定用户" , ID , ACCOUNT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_AUTO_USER_PREDEFINED $TABLE=new SYS_AUTO_USER_PREDEFINED();
	}
	
	/**
	 * 备份记录
	*/
	public static class SYS_BACKUP_DB extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_backup_db";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField DB_NAME = new DBField(DBDataType.STRING , "db_name","dbName","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 备份文件
		*/
		public static final DBField FILE_ROUTE = new DBField(DBDataType.STRING , "file_route","fileRoute","备份文件","备份文件",false,false,true);
		
		/**
		 * 大小
		*/
		public static final DBField FILE_SIZE = new DBField(DBDataType.DECIMAL , "file_size","fileSize","大小","大小",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField START_TIME = new DBField(DBDataType.DATE , "start_time","startTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField END_TIME = new DBField(DBDataType.DATE , "end_time","endTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 失效日期
		*/
		public static final DBField INVALID_TIME = new DBField(DBDataType.DATE , "invalid_time","invalidTime","失效日期","失效日期",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
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
		
		public SYS_BACKUP_DB() {
			this.init($NAME,"备份记录" , ID , DB_NAME , STATUS , FILE_ROUTE , FILE_SIZE , START_TIME , END_TIME , INVALID_TIME , CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_BACKUP_DB $TABLE=new SYS_BACKUP_DB();
	}
	
	/**
	 * 备份策略
	*/
	public static class SYS_BACKUP_DB_STRATEGY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_backup_db_strategy";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 启用状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","启用状态","启用状态",false,false,true);
		
		/**
		 * 备份路径
		*/
		public static final DBField DATA_PATH = new DBField(DBDataType.STRING , "data_path","dataPath","备份路径","备份路径",false,false,true);
		
		/**
		 * 备份保留
		*/
		public static final DBField DATA_KEEP = new DBField(DBDataType.INTEGER , "data_keep","dataKeep","备份保留","备份保留",false,false,true);
		
		/**
		 * 备份周期
		*/
		public static final DBField CRONTAB = new DBField(DBDataType.STRING , "crontab","crontab","备份周期","备份周期",false,false,true);
		
		/**
		 * 邮件
		*/
		public static final DBField MAIL = new DBField(DBDataType.STRING , "mail","mail","邮件","邮件",false,false,true);
		
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
		
		public SYS_BACKUP_DB_STRATEGY() {
			this.init($NAME,"备份策略" , ID , STATUS , DATA_PATH , DATA_KEEP , CRONTAB , MAIL , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_BACKUP_DB_STRATEGY $TABLE=new SYS_BACKUP_DB_STRATEGY();
	}
	
	/**
	 * 流程表单
	*/
	public static class SYS_BPM_FORM_DATA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_bpm_form_data";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 表单
		*/
		public static final DBField FORM_ID = new DBField(DBDataType.STRING , "form_id","formId","表单","表单",false,false,true);
		
		/**
		 * 数据
		*/
		public static final DBField FORM_DATA_ID = new DBField(DBDataType.STRING , "form_data_id","formDataId","数据","数据",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		public SYS_BPM_FORM_DATA() {
			this.init($NAME,"流程表单" , ID , FORM_ID , FORM_DATA_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_BPM_FORM_DATA $TABLE=new SYS_BPM_FORM_DATA();
	}
	
	/**
	 * 类目管理
	*/
	public static class SYS_CATEGORY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_category";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所属
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所属","所属",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField CATEGORY_NAME = new DBField(DBDataType.STRING , "category_name","categoryName","名称","名称",false,false,true);
		
		/**
		 * 全称
		*/
		public static final DBField CATEGORY_FULLNAME = new DBField(DBDataType.STRING , "category_fullname","categoryFullname","全称","全称",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CATEGORY_CODE = new DBField(DBDataType.STRING , "category_code","categoryCode","编码","编码",false,false,true);
		
		/**
		 * 父节点
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","父节点","父节点",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 节点路径
		*/
		public static final DBField HIERARCHY = new DBField(DBDataType.STRING , "hierarchy","hierarchy","节点路径","节点路径",false,false,true);
		
		/**
		 * 节点路径名称
		*/
		public static final DBField HIERARCHY_NAME = new DBField(DBDataType.STRING , "hierarchy_name","hierarchyName","节点路径名称","节点路径名称",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public SYS_CATEGORY() {
			this.init($NAME,"类目管理" , ID , OWNER_ID , STATUS , CATEGORY_NAME , CATEGORY_FULLNAME , CATEGORY_CODE , PARENT_ID , SORT , HIERARCHY , HIERARCHY_NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final SYS_CATEGORY $TABLE=new SYS_CATEGORY();
	}
	
	/**
	 * 测试
	*/
	public static class SYS_DEMO_TEST extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_demo_test";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所属
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所属","所属",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField CATEGORY_NAME = new DBField(DBDataType.STRING , "category_name","categoryName","名称","名称",false,false,true);
		
		/**
		 * 全称
		*/
		public static final DBField CATEGORY_FULLNAME = new DBField(DBDataType.STRING , "category_fullname","categoryFullname","全称","全称",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CATEGORY_CODE = new DBField(DBDataType.STRING , "category_code","categoryCode","编码","编码",false,false,true);
		
		/**
		 * 父节点
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","父节点","父节点",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 节点路径
		*/
		public static final DBField HIERARCHY = new DBField(DBDataType.STRING , "hierarchy","hierarchy","节点路径","节点路径",false,false,true);
		
		/**
		 * 节点路径名称
		*/
		public static final DBField HIERARCHY_NAME = new DBField(DBDataType.STRING , "hierarchy_name","hierarchyName","节点路径名称","节点路径名称",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public SYS_DEMO_TEST() {
			this.init($NAME,"测试" , ID , OWNER_ID , STATUS , CATEGORY_NAME , CATEGORY_FULLNAME , CATEGORY_CODE , PARENT_ID , SORT , HIERARCHY , HIERARCHY_NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final SYS_DEMO_TEST $TABLE=new SYS_DEMO_TEST();
	}
	
	/**
	 * 表单类型
	*/
	public static class SYS_FORM_CATEGORY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_form_category";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 父节点
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","父节点","父节点",false,false,true);
		
		/**
		 * 节点路径
		*/
		public static final DBField HIERARCHY = new DBField(DBDataType.STRING , "hierarchy","hierarchy","节点路径","节点路径",false,false,true);
		
		/**
		 * 节点路径名称
		*/
		public static final DBField HIERARCHY_NAME = new DBField(DBDataType.STRING , "hierarchy_name","hierarchyName","节点路径名称","节点路径名称",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
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
		
		public SYS_FORM_CATEGORY() {
			this.init($NAME,"表单类型" , ID , CODE , NAME , STATUS , PARENT_ID , HIERARCHY , HIERARCHY_NAME , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final SYS_FORM_CATEGORY $TABLE=new SYS_FORM_CATEGORY();
	}
	
	/**
	 * 字段映射
	*/
	public static class SYS_FORM_COL_MAP extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_form_col_map";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 表单
		*/
		public static final DBField FORM_ID = new DBField(DBDataType.STRING , "form_id","formId","表单","表单",false,false,true);
		
		/**
		 * 表单数据
		*/
		public static final DBField FORM_DATA_ID = new DBField(DBDataType.STRING , "form_data_id","formDataId","表单数据","表单数据",false,false,true);
		
		/**
		 * 字段
		*/
		public static final DBField COL_NAME = new DBField(DBDataType.STRING , "col_name","colName","字段","字段",false,false,true);
		
		/**
		 * 别名
		*/
		public static final DBField COL_ALIAS = new DBField(DBDataType.STRING , "col_alias","colAlias","别名","别名",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		public SYS_FORM_COL_MAP() {
			this.init($NAME,"字段映射" , ID , FORM_ID , FORM_DATA_ID , COL_NAME , COL_ALIAS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_FORM_COL_MAP $TABLE=new SYS_FORM_COL_MAP();
	}
	
	/**
	 * 表单数据
	*/
	public static class SYS_FORM_DATA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_form_data";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 业务归属
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","业务归属","业务归属",false,false,true);
		
		/**
		 * 表单定义
		*/
		public static final DBField DEF_ID = new DBField(DBDataType.STRING , "def_id","defId","表单定义","表单定义",false,false,true);
		
		/**
		 * 表单
		*/
		public static final DBField FORM_ID = new DBField(DBDataType.STRING , "form_id","formId","表单","表单",false,false,true);
		
		/**
		 * 设计
		*/
		public static final DBField DESIGNER_DATA = new DBField(DBDataType.STRING , "designer_data","designerData","设计","设计",false,false,true);
		
		/**
		 * 数据
		*/
		public static final DBField DATA = new DBField(DBDataType.STRING , "data","data","数据","数据",false,false,true);
		
		/**
		 * 表单状态
		*/
		public static final DBField FORM_STATUS = new DBField(DBDataType.STRING , "form_status","formStatus","表单状态","表单状态",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		public SYS_FORM_DATA() {
			this.init($NAME,"表单数据" , ID , OWNER_ID , DEF_ID , FORM_ID , DESIGNER_DATA , DATA , FORM_STATUS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_FORM_DATA $TABLE=new SYS_FORM_DATA();
	}
	
	/**
	 * 数据字段
	*/
	public static class SYS_FORM_DATA_COL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_form_data_col";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 字段
		*/
		public static final DBField COL = new DBField(DBDataType.STRING , "col","col","字段","字段",false,false,true);
		
		/**
		 * 字段类型
		*/
		public static final DBField COL_TYPE = new DBField(DBDataType.STRING , "col_type","colType","字段类型","字段类型",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		public SYS_FORM_DATA_COL() {
			this.init($NAME,"数据字段" , ID , COL , COL_TYPE , STATUS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_FORM_DATA_COL $TABLE=new SYS_FORM_DATA_COL();
	}
	
	/**
	 * 数据扩展
	*/
	public static class SYS_FORM_DATA_EXT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_form_data_ext";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 数据
		*/
		public static final DBField DATA_ID = new DBField(DBDataType.STRING , "data_id","dataId","数据","数据",false,false,true);
		
		/**
		 * 字符串1
		*/
		public static final DBField SS1 = new DBField(DBDataType.STRING , "ss1","ss1","字符串1","字符串1",false,false,true);
		
		/**
		 * 字符串2
		*/
		public static final DBField SS2 = new DBField(DBDataType.STRING , "ss2","ss2","字符串2","字符串2",false,false,true);
		
		/**
		 * 字符串3
		*/
		public static final DBField SS3 = new DBField(DBDataType.STRING , "ss3","ss3","字符串3","字符串3",false,false,true);
		
		/**
		 * 字符串4
		*/
		public static final DBField SS4 = new DBField(DBDataType.STRING , "ss4","ss4","字符串4","字符串4",false,false,true);
		
		/**
		 * 字符串5
		*/
		public static final DBField SS5 = new DBField(DBDataType.STRING , "ss5","ss5","字符串5","字符串5",false,false,true);
		
		/**
		 * 字符串6
		*/
		public static final DBField SS6 = new DBField(DBDataType.STRING , "ss6","ss6","字符串6","字符串6",false,false,true);
		
		/**
		 * 字符串7
		*/
		public static final DBField SS7 = new DBField(DBDataType.STRING , "ss7","ss7","字符串7","字符串7",false,false,true);
		
		/**
		 * 字符串8
		*/
		public static final DBField SS8 = new DBField(DBDataType.STRING , "ss8","ss8","字符串8","字符串8",false,false,true);
		
		/**
		 * 字符串9
		*/
		public static final DBField SS9 = new DBField(DBDataType.STRING , "ss9","ss9","字符串9","字符串9",false,false,true);
		
		/**
		 * 字符串10
		*/
		public static final DBField SS10 = new DBField(DBDataType.STRING , "ss10","ss10","字符串10","字符串10",false,false,true);
		
		/**
		 * 字符串11
		*/
		public static final DBField S11 = new DBField(DBDataType.STRING , "s11","s11","字符串11","字符串11",false,false,true);
		
		/**
		 * 字符串12
		*/
		public static final DBField S12 = new DBField(DBDataType.STRING , "s12","s12","字符串12","字符串12",false,false,true);
		
		/**
		 * 字符串13
		*/
		public static final DBField S13 = new DBField(DBDataType.STRING , "s13","s13","字符串13","字符串13",false,false,true);
		
		/**
		 * 字符串14
		*/
		public static final DBField S14 = new DBField(DBDataType.STRING , "s14","s14","字符串14","字符串14",false,false,true);
		
		/**
		 * 字符串15
		*/
		public static final DBField S15 = new DBField(DBDataType.STRING , "s15","s15","字符串15","字符串15",false,false,true);
		
		/**
		 * 字符串16
		*/
		public static final DBField S16 = new DBField(DBDataType.STRING , "s16","s16","字符串16","字符串16",false,false,true);
		
		/**
		 * 字符串17
		*/
		public static final DBField S17 = new DBField(DBDataType.STRING , "s17","s17","字符串17","字符串17",false,false,true);
		
		/**
		 * 字符串18
		*/
		public static final DBField S18 = new DBField(DBDataType.STRING , "s18","s18","字符串18","字符串18",false,false,true);
		
		/**
		 * 字符串19
		*/
		public static final DBField S19 = new DBField(DBDataType.STRING , "s19","s19","字符串19","字符串19",false,false,true);
		
		/**
		 * 字符串20
		*/
		public static final DBField S20 = new DBField(DBDataType.STRING , "s20","s20","字符串20","字符串20",false,false,true);
		
		/**
		 * 长字符串1
		*/
		public static final DBField LS1 = new DBField(DBDataType.STRING , "ls1","ls1","长字符串1","长字符串1",false,false,true);
		
		/**
		 * 长字符串1
		*/
		public static final DBField LS2 = new DBField(DBDataType.STRING , "ls2","ls2","长字符串1","长字符串1",false,false,true);
		
		/**
		 * 长字符串1
		*/
		public static final DBField LS3 = new DBField(DBDataType.STRING , "ls3","ls3","长字符串1","长字符串1",false,false,true);
		
		/**
		 * 长字符串1
		*/
		public static final DBField LS4 = new DBField(DBDataType.STRING , "ls4","ls4","长字符串1","长字符串1",false,false,true);
		
		/**
		 * 长字符串1
		*/
		public static final DBField LS5 = new DBField(DBDataType.STRING , "ls5","ls5","长字符串1","长字符串1",false,false,true);
		
		/**
		 * 文本
		*/
		public static final DBField TS1 = new DBField(DBDataType.STRING , "ts1","ts1","文本","文本",false,false,true);
		
		/**
		 * 文本
		*/
		public static final DBField TS2 = new DBField(DBDataType.STRING , "ts2","ts2","文本","文本",false,false,true);
		
		/**
		 * 文本
		*/
		public static final DBField TS3 = new DBField(DBDataType.STRING , "ts3","ts3","文本","文本",false,false,true);
		
		/**
		 * 文本
		*/
		public static final DBField TS4 = new DBField(DBDataType.STRING , "ts4","ts4","文本","文本",false,false,true);
		
		/**
		 * 时间1
		*/
		public static final DBField D1 = new DBField(DBDataType.DATE , "d1","d1","时间1","时间1",false,false,true);
		
		/**
		 * 时间2
		*/
		public static final DBField D2 = new DBField(DBDataType.DATE , "d2","d2","时间2","时间2",false,false,true);
		
		/**
		 * 时间3
		*/
		public static final DBField D3 = new DBField(DBDataType.DATE , "d3","d3","时间3","时间3",false,false,true);
		
		/**
		 * 时间4
		*/
		public static final DBField D4 = new DBField(DBDataType.DATE , "d4","d4","时间4","时间4",false,false,true);
		
		/**
		 * 时间5
		*/
		public static final DBField D5 = new DBField(DBDataType.DATE , "d5","d5","时间5","时间5",false,false,true);
		
		/**
		 * 时间6
		*/
		public static final DBField D6 = new DBField(DBDataType.DATE , "d6","d6","时间6","时间6",false,false,true);
		
		/**
		 * 整形1
		*/
		public static final DBField I1 = new DBField(DBDataType.INTEGER , "i1","i1","整形1","整形1",false,false,true);
		
		/**
		 * 整形2
		*/
		public static final DBField I2 = new DBField(DBDataType.INTEGER , "i2","i2","整形2","整形2",false,false,true);
		
		/**
		 * 整形3
		*/
		public static final DBField I3 = new DBField(DBDataType.INTEGER , "i3","i3","整形3","整形3",false,false,true);
		
		/**
		 * 整形4
		*/
		public static final DBField I4 = new DBField(DBDataType.INTEGER , "i4","i4","整形4","整形4",false,false,true);
		
		/**
		 * 整形5
		*/
		public static final DBField I5 = new DBField(DBDataType.INTEGER , "i5","i5","整形5","整形5",false,false,true);
		
		/**
		 * 浮点1
		*/
		public static final DBField F1 = new DBField(DBDataType.DECIMAL , "f1","f1","浮点1","浮点1",false,false,true);
		
		/**
		 * 浮点2
		*/
		public static final DBField F2 = new DBField(DBDataType.DECIMAL , "f2","f2","浮点2","浮点2",false,false,true);
		
		/**
		 * 浮点3
		*/
		public static final DBField F3 = new DBField(DBDataType.DECIMAL , "f3","f3","浮点3","浮点3",false,false,true);
		
		/**
		 * 浮点4
		*/
		public static final DBField F4 = new DBField(DBDataType.DECIMAL , "f4","f4","浮点4","浮点4",false,false,true);
		
		/**
		 * 浮点5
		*/
		public static final DBField F5 = new DBField(DBDataType.DECIMAL , "f5","f5","浮点5","浮点5",false,false,true);
		
		/**
		 * 浮点6
		*/
		public static final DBField F6 = new DBField(DBDataType.DECIMAL , "f6","f6","浮点6","浮点6",false,false,true);
		
		/**
		 * 浮点7
		*/
		public static final DBField F7 = new DBField(DBDataType.DECIMAL , "f7","f7","浮点7","浮点7",false,false,true);
		
		/**
		 * 浮点8
		*/
		public static final DBField F8 = new DBField(DBDataType.DECIMAL , "f8","f8","浮点8","浮点8",false,false,true);
		
		/**
		 * 浮点9
		*/
		public static final DBField F9 = new DBField(DBDataType.DECIMAL , "f9","f9","浮点9","浮点9",false,false,true);
		
		/**
		 * 浮点10
		*/
		public static final DBField F10 = new DBField(DBDataType.DECIMAL , "f10","f10","浮点10","浮点10",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		public SYS_FORM_DATA_EXT() {
			this.init($NAME,"数据扩展" , ID , DATA_ID , SS1 , SS2 , SS3 , SS4 , SS5 , SS6 , SS7 , SS8 , SS9 , SS10 , S11 , S12 , S13 , S14 , S15 , S16 , S17 , S18 , S19 , S20 , LS1 , LS2 , LS3 , LS4 , LS5 , TS1 , TS2 , TS3 , TS4 , D1 , D2 , D3 , D4 , D5 , D6 , I1 , I2 , I3 , I4 , I5 , F1 , F2 , F3 , F4 , F5 , F6 , F7 , F8 , F9 , F10 , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_FORM_DATA_EXT $TABLE=new SYS_FORM_DATA_EXT();
	}
	
	/**
	 * 表单定义
	*/
	public static class SYS_FORM_DEF extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_form_def";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 表单
		*/
		public static final DBField FORM_ID = new DBField(DBDataType.STRING , "form_id","formId","表单","表单",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 定义
		*/
		public static final DBField DESIGNER_DATA = new DBField(DBDataType.STRING , "designer_data","designerData","定义","定义",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		public SYS_FORM_DEF() {
			this.init($NAME,"表单定义" , ID , FORM_ID , STATUS , DESIGNER_DATA , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_FORM_DEF $TABLE=new SYS_FORM_DEF();
	}
	
	/**
	 * 表单信息
	*/
	public static class SYS_FORM_INFO extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_form_info";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 分类
		*/
		public static final DBField CATALOG_ID = new DBField(DBDataType.STRING , "catalog_id","catalogId","分类","分类",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 路径
		*/
		public static final DBField ROUTE = new DBField(DBDataType.STRING , "route","route","路径","路径",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 存储
		*/
		public static final DBField STORAGE = new DBField(DBDataType.STRING , "storage","storage","存储","存储",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public SYS_FORM_INFO() {
			this.init($NAME,"表单信息" , ID , CODE , CATALOG_ID , NAME , STATUS , ROUTE , NOTES , STORAGE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final SYS_FORM_INFO $TABLE=new SYS_FORM_INFO();
	}
	
	/**
	 * 调用统计日志
	*/
	public static class SYS_INVOKE_LOG extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_invoke_log";
		
		/**
		 * ID
		*/
		public static final DBField ID = new DBField(DBDataType.LONG , "id","id","ID","ID",true,true,false);
		
		/**
		 * 应用名称
		*/
		public static final DBField APPLICATION = new DBField(DBDataType.STRING , "application","application","应用名称","应用名称",false,false,true);
		
		/**
		 * 主机名称
		*/
		public static final DBField HOST_NAME = new DBField(DBDataType.STRING , "host_name","hostName","主机名称","主机名称",false,false,true);
		
		/**
		 * 目标名称
		*/
		public static final DBField SUBJECT = new DBField(DBDataType.STRING , "subject","subject","目标名称","目标名称",false,false,true);
		
		/**
		 * 请求的URI
		*/
		public static final DBField URI = new DBField(DBDataType.STRING , "uri","uri","请求的URI","请求的URI",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * UserAgent
		*/
		public static final DBField USER_AGENT = new DBField(DBDataType.STRING , "user_agent","userAgent","UserAgent","UserAgent",false,false,true);
		
		/**
		 * 客户端IP
		*/
		public static final DBField CLIENT_IP = new DBField(DBDataType.STRING , "client_ip","clientIp","客户端IP","客户端IP",false,false,true);
		
		/**
		 * token值
		*/
		public static final DBField TOKEN = new DBField(DBDataType.STRING , "token","token","token值","token值",false,false,true);
		
		/**
		 * 会话ID
		*/
		public static final DBField SESSION_ID = new DBField(DBDataType.STRING , "session_id","sessionId","会话ID","会话ID",false,false,true);
		
		/**
		 * 用户ID
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","用户ID","用户ID",false,false,true);
		
		/**
		 * 用户姓名
		*/
		public static final DBField USER_NAME = new DBField(DBDataType.STRING , "user_name","userName","用户姓名","用户姓名",false,false,true);
		
		/**
		 * 日志跟踪ID
		*/
		public static final DBField TID = new DBField(DBDataType.STRING , "tid","tid","日志跟踪ID","日志跟踪ID",false,false,true);
		
		/**
		 * 请求参数
		*/
		public static final DBField PARAMETER = new DBField(DBDataType.STRING , "parameter","parameter","请求参数","请求参数",false,false,true);
		
		/**
		 * 响应数据
		*/
		public static final DBField RESPONSE = new DBField(DBDataType.STRING , "response","response","响应数据","响应数据",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField START_TIME = new DBField(DBDataType.TIMESTAMP , "start_time","startTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField END_TIME = new DBField(DBDataType.TIMESTAMP , "end_time","endTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 异常信息
		*/
		public static final DBField EXCEPTION = new DBField(DBDataType.STRING , "exception","exception","异常信息","异常信息",false,false,true);
		
		/**
		 * 请求类型
		*/
		public static final DBField HTTP_METHOD = new DBField(DBDataType.STRING , "http_method","httpMethod","请求类型","请求类型",false,false,true);
		
		public SYS_INVOKE_LOG() {
			this.init($NAME,"调用统计日志" , ID , APPLICATION , HOST_NAME , SUBJECT , URI , TYPE , USER_AGENT , CLIENT_IP , TOKEN , SESSION_ID , USER_ID , USER_NAME , TID , PARAMETER , RESPONSE , START_TIME , END_TIME , EXCEPTION , HTTP_METHOD);
		}
		public static final SYS_INVOKE_LOG $TABLE=new SYS_INVOKE_LOG();
	}
	
	/**
	 * 菜单键值
	*/
	public static class SYS_KEY_CODE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_key_code";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 键值
		*/
		public static final DBField KEY = new DBField(DBDataType.STRING , "key","key","键值","键值",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		public SYS_KEY_CODE() {
			this.init($NAME,"菜单键值" , ID , KEY , STATUS , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_KEY_CODE $TABLE=new SYS_KEY_CODE();
	}
	
	/**
	 * 版本切换
	*/
	public static class SYS_LICENCE_SWITCH extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_licence_switch";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 许可版本
		*/
		public static final DBField LICENCE_TAB = new DBField(DBDataType.STRING , "licence_tab","licenceTab","许可版本","许可版本",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 动作
		*/
		public static final DBField ACTION_CONTENT = new DBField(DBDataType.STRING , "action_content","actionContent","动作","动作",false,false,true);
		
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
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public SYS_LICENCE_SWITCH() {
			this.init($NAME,"版本切换" , ID , LICENCE_TAB , STATUS , ACTION_CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_LICENCE_SWITCH $TABLE=new SYS_LICENCE_SWITCH();
	}
	
	/**
	 * 日志收集
	*/
	public static class SYS_LOG_COLLECT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_log_collect";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 范围
		*/
		public static final DBField COLLECT_RANGE = new DBField(DBDataType.STRING , "collect_range","collectRange","范围","范围",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 文件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","文件","文件",false,false,true);
		
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
		
		public SYS_LOG_COLLECT() {
			this.init($NAME,"日志收集" , ID , COLLECT_RANGE , STATUS , FILE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_LOG_COLLECT $TABLE=new SYS_LOG_COLLECT();
	}
	
	/**
	 * 素材资源
	*/
	public static class SYS_MATERIAL_RESOURCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_material_resource";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 访问地址
		*/
		public static final DBField ACCESS_URL = new DBField(DBDataType.STRING , "access_url","accessUrl","访问地址","访问地址",false,false,true);
		
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
		
		public SYS_MATERIAL_RESOURCE() {
			this.init($NAME,"素材资源" , ID , NAME , FILE_ID , ACCESS_URL , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final SYS_MATERIAL_RESOURCE $TABLE=new SYS_MATERIAL_RESOURCE();
	}
	
	/**
	 * 节点负载
	*/
	public static class SYS_NODE_LOAD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_node_load";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 节点
		*/
		public static final DBField NODE = new DBField(DBDataType.STRING , "node","node","节点","节点",false,false,true);
		
		/**
		 * IP
		*/
		public static final DBField IP = new DBField(DBDataType.STRING , "ip","ip","IP","IP",false,false,true);
		
		/**
		 * 用户使用率
		*/
		public static final DBField USER = new DBField(DBDataType.DECIMAL , "user","user","用户使用率","用户使用率",false,false,true);
		
		/**
		 * 系统使用率
		*/
		public static final DBField SYS = new DBField(DBDataType.DECIMAL , "sys","sys","系统使用率","系统使用率",false,false,true);
		
		/**
		 * 空闲使用率
		*/
		public static final DBField IDLE = new DBField(DBDataType.DECIMAL , "idle","idle","空闲使用率","空闲使用率",false,false,true);
		
		/**
		 * wio
		*/
		public static final DBField WIO = new DBField(DBDataType.DECIMAL , "wio","wio","wio","wio",false,false,true);
		
		/**
		 * load1
		*/
		public static final DBField LOAD1 = new DBField(DBDataType.DECIMAL , "load1","load1","load1","load1",false,false,true);
		
		/**
		 * load5
		*/
		public static final DBField LOAD5 = new DBField(DBDataType.DECIMAL , "load5","load5","load5","load5",false,false,true);
		
		/**
		 * load15
		*/
		public static final DBField LOAD15 = new DBField(DBDataType.DECIMAL , "load15","load15","load15","load15",false,false,true);
		
		/**
		 * 内存使用
		*/
		public static final DBField MEMORY_USED = new DBField(DBDataType.DECIMAL , "memory_used","memoryUsed","内存使用","内存使用",false,false,true);
		
		/**
		 * 内存使用率
		*/
		public static final DBField MEMORY_USED_PCT = new DBField(DBDataType.DECIMAL , "memory_used_pct","memoryUsedPct","内存使用率","内存使用率",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_NODE_LOAD() {
			this.init($NAME,"节点负载" , ID , NODE , IP , USER , SYS , IDLE , WIO , LOAD1 , LOAD5 , LOAD15 , MEMORY_USED , MEMORY_USED_PCT , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_NODE_LOAD $TABLE=new SYS_NODE_LOAD();
	}
	
	/**
	 * 报表列表
	*/
	public static class SYS_REPORT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_report";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 分类
		*/
		public static final DBField CATALOG_ID = new DBField(DBDataType.STRING , "catalog_id","catalogId","分类","分类",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 路径
		*/
		public static final DBField ROUTE = new DBField(DBDataType.STRING , "route","route","路径","路径",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 模版
		*/
		public static final DBField REPORT_TPL_ID = new DBField(DBDataType.STRING , "report_tpl_id","reportTplId","模版","模版",false,false,true);
		
		/**
		 * 报表设计
		*/
		public static final DBField REPORT_TPL_DEF_ID = new DBField(DBDataType.STRING , "report_tpl_def_id","reportTplDefId","报表设计","报表设计",false,false,true);
		
		/**
		 * 来源
		*/
		public static final DBField REPORT_SOURCE = new DBField(DBDataType.STRING , "report_source","reportSource","来源","来源",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public SYS_REPORT() {
			this.init($NAME,"报表列表" , ID , CODE , CATALOG_ID , NAME , STATUS , ROUTE , NOTES , REPORT_TPL_ID , REPORT_TPL_DEF_ID , REPORT_SOURCE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final SYS_REPORT $TABLE=new SYS_REPORT();
	}
	
	/**
	 * 报表类型
	*/
	public static class SYS_REPORT_CATEGORY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_report_category";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 父节点
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","父节点","父节点",false,false,true);
		
		/**
		 * 节点路径
		*/
		public static final DBField HIERARCHY = new DBField(DBDataType.STRING , "hierarchy","hierarchy","节点路径","节点路径",false,false,true);
		
		/**
		 * 节点路径名称
		*/
		public static final DBField HIERARCHY_NAME = new DBField(DBDataType.STRING , "hierarchy_name","hierarchyName","节点路径名称","节点路径名称",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
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
		
		public SYS_REPORT_CATEGORY() {
			this.init($NAME,"报表类型" , ID , CODE , NAME , STATUS , PARENT_ID , HIERARCHY , HIERARCHY_NAME , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final SYS_REPORT_CATEGORY $TABLE=new SYS_REPORT_CATEGORY();
	}
	
	/**
	 * 报表定义
	*/
	public static class SYS_REPORT_U_DEF extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_report_u_def";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所属类型
		*/
		public static final DBField OWNER_TYPE = new DBField(DBDataType.STRING , "owner_type","ownerType","所属类型","所属类型",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField FILE_NAME = new DBField(DBDataType.STRING , "file_name","fileName","名称","名称",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		public SYS_REPORT_U_DEF() {
			this.init($NAME,"报表定义" , ID , OWNER_TYPE , FILE_NAME , CONTENT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_REPORT_U_DEF $TABLE=new SYS_REPORT_U_DEF();
	}
	
	/**
	 * 大屏
	*/
	public static class SYS_SCREEN extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_screen";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编号","编号",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 大屏定义
		*/
		public static final DBField JSON_DATA = new DBField(DBDataType.STRING , "json_data","jsonData","大屏定义","大屏定义",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public SYS_SCREEN() {
			this.init($NAME,"大屏" , ID , CODE , NAME , STATUS , NOTES , JSON_DATA , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final SYS_SCREEN $TABLE=new SYS_SCREEN();
	}
	
	/**
	 * 项目
	*/
	public static class SYS_SCREEN_PROJECT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_screen_project";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 项目
		*/
		public static final DBField PROJECT_NAME = new DBField(DBDataType.STRING , "project_name","projectName","项目","项目",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATE = new DBField(DBDataType.STRING , "state","state","状态","状态",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField INDEX_IMAGE = new DBField(DBDataType.STRING , "index_image","indexImage","备注","备注",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField REMARKS = new DBField(DBDataType.STRING , "remarks","remarks","备注","备注",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public SYS_SCREEN_PROJECT() {
			this.init($NAME,"项目" , ID , PROJECT_NAME , STATE , INDEX_IMAGE , REMARKS , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final SYS_SCREEN_PROJECT $TABLE=new SYS_SCREEN_PROJECT();
	}
	
	/**
	 * 项目数据
	*/
	public static class SYS_SCREEN_PROJECT_DATA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_screen_project_data";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 项目
		*/
		public static final DBField PROJECT_ID = new DBField(DBDataType.STRING , "project_id","projectId","项目","项目",false,false,true);
		
		/**
		 * 数据
		*/
		public static final DBField CONTENT_DATA = new DBField(DBDataType.STRING , "content_data","contentData","数据","数据",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		public SYS_SCREEN_PROJECT_DATA() {
			this.init($NAME,"项目数据" , ID , PROJECT_ID , CONTENT_DATA , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_SCREEN_PROJECT_DATA $TABLE=new SYS_SCREEN_PROJECT_DATA();
	}
	
	/**
	 * 车辆保险公司
	*/
	public static class SYS_TEST extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_test";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public SYS_TEST() {
			this.init($NAME,"车辆保险公司" , ID , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final SYS_TEST $TABLE=new SYS_TEST();
	}
	
	/**
	 * 员工导入
	*/
	public static class SYS_USER_IMPORT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_user_import";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 导入批次
		*/
		public static final DBField ACTION_CODE = new DBField(DBDataType.STRING , "action_code","actionCode","导入批次","导入批次",false,false,true);
		
		/**
		 * 操作时间
		*/
		public static final DBField ACTION_OPER_TIME = new DBField(DBDataType.DATE , "action_oper_time","actionOperTime","操作时间","操作时间",false,false,true);
		
		/**
		 * 导入状态
		*/
		public static final DBField ACTION_STATUS = new DBField(DBDataType.STRING , "action_status","actionStatus","导入状态","导入状态",false,false,true);
		
		/**
		 * 导入结果
		*/
		public static final DBField ACTION_MSG = new DBField(DBDataType.STRING , "action_msg","actionMsg","导入结果","导入结果",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField USER_NAME = new DBField(DBDataType.STRING , "user_name","userName","姓名","姓名",false,false,true);
		
		/**
		 * 工号
		*/
		public static final DBField BADGE = new DBField(DBDataType.STRING , "badge","badge","工号","工号",false,false,true);
		
		/**
		 * 性别
		*/
		public static final DBField SEX = new DBField(DBDataType.STRING , "sex","sex","性别","性别",false,false,true);
		
		/**
		 * 性别编码
		*/
		public static final DBField SEX_CODE = new DBField(DBDataType.STRING , "sex_code","sexCode","性别编码","性别编码",false,false,true);
		
		/**
		 * 手机号
		*/
		public static final DBField PHONE = new DBField(DBDataType.STRING , "phone","phone","手机号","手机号",false,false,true);
		
		/**
		 * 组织
		*/
		public static final DBField COMPANY_NAME = new DBField(DBDataType.STRING , "company_name","companyName","组织","组织",false,false,true);
		
		/**
		 * 组织ID
		*/
		public static final DBField COMPANY_ID = new DBField(DBDataType.STRING , "company_id","companyId","组织ID","组织ID",false,false,true);
		
		/**
		 * 主岗
		*/
		public static final DBField MASTER_POST = new DBField(DBDataType.STRING , "master_post","masterPost","主岗","主岗",false,false,true);
		
		/**
		 * 主岗ID
		*/
		public static final DBField MASTER_POST_ID = new DBField(DBDataType.STRING , "master_post_id","masterPostId","主岗ID","主岗ID",false,false,true);
		
		/**
		 * 身份证
		*/
		public static final DBField ID_CARD = new DBField(DBDataType.STRING , "id_card","idCard","身份证","身份证",false,false,true);
		
		/**
		 * 状态，字典代码：employee_status
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","字典代码：employee_status",false,false,true);
		
		/**
		 * 状态编码
		*/
		public static final DBField STATUS_CODE = new DBField(DBDataType.STRING , "status_code","statusCode","状态编码","状态编码",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_USER_IMPORT() {
			this.init($NAME,"员工导入" , ID , ACTION_CODE , ACTION_OPER_TIME , ACTION_STATUS , ACTION_MSG , USER_NAME , BADGE , SEX , SEX_CODE , PHONE , COMPANY_NAME , COMPANY_ID , MASTER_POST , MASTER_POST_ID , ID_CARD , STATUS , STATUS_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_USER_IMPORT $TABLE=new SYS_USER_IMPORT();
	}
}