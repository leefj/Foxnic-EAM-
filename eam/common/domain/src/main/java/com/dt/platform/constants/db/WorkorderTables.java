package com.dt.platform.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2022-07-03 21:03:00
 * @author 金杰 , maillank@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class WorkorderTables {
	
	/**
	 * 工单类型
	*/
	public static class WO_CATEGORY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wo_category";
		
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
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
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
		
		public WO_CATEGORY() {
			this.init($NAME,"工单类型" , ID , NAME , NOTES , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final WO_CATEGORY $TABLE=new WO_CATEGORY();
	}
	
	/**
	 * 网络策略申请
	*/
	public static class WO_NETWORK_STRATEGY_APPLY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wo_network_strategy_apply";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 类型
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","类型","类型",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 项目
		*/
		public static final DBField PROJECT = new DBField(DBDataType.STRING , "project","project","项目","项目",false,false,true);
		
		/**
		 * 运行环境
		*/
		public static final DBField ENVIRONMENT_ID = new DBField(DBDataType.STRING , "environment_id","environmentId","运行环境","运行环境",false,false,true);
		
		/**
		 * 有效期
		*/
		public static final DBField PERIOD_TYPE = new DBField(DBDataType.STRING , "period_type","periodType","有效期","有效期",false,false,true);
		
		/**
		 * 过期日期
		*/
		public static final DBField EXPIRATION_DATE = new DBField(DBDataType.DATE , "expiration_date","expirationDate","过期日期","过期日期",false,false,true);
		
		/**
		 * 申请日期
		*/
		public static final DBField APPLY_DATE = new DBField(DBDataType.DATE , "apply_date","applyDate","申请日期","申请日期",false,false,true);
		
		/**
		 * 期望日期
		*/
		public static final DBField EXPECTED_COMPLETION_DATE = new DBField(DBDataType.DATE , "expected_completion_date","expectedCompletionDate","期望日期","期望日期",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 完成日期
		*/
		public static final DBField COMPLETION_DATE = new DBField(DBDataType.DATE , "completion_date","completionDate","完成日期","完成日期",false,false,true);
		
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
		
		public WO_NETWORK_STRATEGY_APPLY() {
			this.init($NAME,"网络策略申请" , ID , CATEGORY_ID , STATUS , NAME , PROJECT , ENVIRONMENT_ID , PERIOD_TYPE , EXPIRATION_DATE , APPLY_DATE , EXPECTED_COMPLETION_DATE , CONTENT , FILE_ID , NOTES , COMPLETION_DATE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final WO_NETWORK_STRATEGY_APPLY $TABLE=new WO_NETWORK_STRATEGY_APPLY();
	}
	
	/**
	 * 网络策略
	*/
	public static class WO_NETWORK_STRATEGY_INFO extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wo_network_strategy_info";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 源名称
		*/
		public static final DBField SOURCE_NAME = new DBField(DBDataType.STRING , "source_name","sourceName","源名称","源名称",false,false,true);
		
		/**
		 * 源IP
		*/
		public static final DBField SOURCE_IP = new DBField(DBDataType.STRING , "source_ip","sourceIp","源IP","源IP",false,false,true);
		
		/**
		 * 目标名称
		*/
		public static final DBField TARGET_NAME = new DBField(DBDataType.STRING , "target_name","targetName","目标名称","目标名称",false,false,true);
		
		/**
		 * 目标IP
		*/
		public static final DBField TARGET_IP = new DBField(DBDataType.STRING , "target_ip","targetIp","目标IP","目标IP",false,false,true);
		
		/**
		 * 使用协议
		*/
		public static final DBField USED_PROTOCOL_TYPE = new DBField(DBDataType.STRING , "used_protocol_type","usedProtocolType","使用协议","使用协议",false,false,true);
		
		/**
		 * 连接类型
		*/
		public static final DBField SESSION_TYPE = new DBField(DBDataType.STRING , "session_type","sessionType","连接类型","连接类型",false,false,true);
		
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
		
		public WO_NETWORK_STRATEGY_INFO() {
			this.init($NAME,"网络策略" , ID , SOURCE_NAME , SOURCE_IP , TARGET_NAME , TARGET_IP , USED_PROTOCOL_TYPE , SESSION_TYPE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final WO_NETWORK_STRATEGY_INFO $TABLE=new WO_NETWORK_STRATEGY_INFO();
	}
	
	/**
	 * 服务器资源申请
	*/
	public static class WO_SERVER_APPLY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wo_server_apply";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 类型
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","类型","类型",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 项目
		*/
		public static final DBField PROJECT = new DBField(DBDataType.STRING , "project","project","项目","项目",false,false,true);
		
		/**
		 * 运行环境
		*/
		public static final DBField ENVIRONMENT_ID = new DBField(DBDataType.STRING , "environment_id","environmentId","运行环境","运行环境",false,false,true);
		
		/**
		 * 有效期
		*/
		public static final DBField PERIOD_TYPE = new DBField(DBDataType.STRING , "period_type","periodType","有效期","有效期",false,false,true);
		
		/**
		 * 过期日期
		*/
		public static final DBField EXPIRATION_DATE = new DBField(DBDataType.DATE , "expiration_date","expirationDate","过期日期","过期日期",false,false,true);
		
		/**
		 * 申请日期
		*/
		public static final DBField APPLY_DATE = new DBField(DBDataType.DATE , "apply_date","applyDate","申请日期","申请日期",false,false,true);
		
		/**
		 * 期望日期
		*/
		public static final DBField EXPECTED_COMPLETION_DATE = new DBField(DBDataType.DATE , "expected_completion_date","expectedCompletionDate","期望日期","期望日期",false,false,true);
		
		/**
		 * 资源描述
		*/
		public static final DBField DESCRIPTION = new DBField(DBDataType.STRING , "description","description","资源描述","资源描述",false,false,true);
		
		/**
		 * 域名
		*/
		public static final DBField DOMAIN_NAME = new DBField(DBDataType.STRING , "domain_name","domainName","域名","域名",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 完成日期
		*/
		public static final DBField COMPLETION_DATE = new DBField(DBDataType.DATE , "completion_date","completionDate","完成日期","完成日期",false,false,true);
		
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
		
		public WO_SERVER_APPLY() {
			this.init($NAME,"服务器资源申请" , ID , CATEGORY_ID , STATUS , NAME , PROJECT , ENVIRONMENT_ID , PERIOD_TYPE , EXPIRATION_DATE , APPLY_DATE , EXPECTED_COMPLETION_DATE , DESCRIPTION , DOMAIN_NAME , CONTENT , FILE_ID , NOTES , COMPLETION_DATE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final WO_SERVER_APPLY $TABLE=new WO_SERVER_APPLY();
	}
	
	/**
	 * 服务器资源
	*/
	public static class WO_SERVER_INFO extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wo_server_info";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 服务器类型
		*/
		public static final DBField SERVER_TYPE = new DBField(DBDataType.STRING , "server_type","serverType","服务器类型","服务器类型",false,false,true);
		
		/**
		 * 系统版本
		*/
		public static final DBField OS_VERSION = new DBField(DBDataType.STRING , "os_version","osVersion","系统版本","系统版本",false,false,true);
		
		/**
		 * 数据库
		*/
		public static final DBField DATABASE_VERSION = new DBField(DBDataType.STRING , "database_version","databaseVersion","数据库","数据库",false,false,true);
		
		/**
		 * 中间件
		*/
		public static final DBField MIDDLEWARE_VERSION = new DBField(DBDataType.STRING , "middleware_version","middlewareVersion","中间件","中间件",false,false,true);
		
		/**
		 * CPU数
		*/
		public static final DBField CPU = new DBField(DBDataType.INTEGER , "cpu","cpu","CPU数","CPU数",false,false,true);
		
		/**
		 * 内存(G)
		*/
		public static final DBField MEMORY = new DBField(DBDataType.INTEGER , "memory","memory","内存(G)","内存(G)",false,false,true);
		
		/**
		 * 用户列表
		*/
		public static final DBField USERLIST = new DBField(DBDataType.STRING , "userList","userlist","用户列表","用户列表",false,false,true);
		
		/**
		 * 端口列表
		*/
		public static final DBField PORTLIST = new DBField(DBDataType.STRING , "portList","portlist","端口列表","端口列表",false,false,true);
		
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
		
		public WO_SERVER_INFO() {
			this.init($NAME,"服务器资源" , ID , NAME , SERVER_TYPE , OS_VERSION , DATABASE_VERSION , MIDDLEWARE_VERSION , CPU , MEMORY , USERLIST , PORTLIST , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final WO_SERVER_INFO $TABLE=new WO_SERVER_INFO();
	}
	
	/**
	 * 负载策略申请
	*/
	public static class WO_SLB_STRATEGY_APPLY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wo_slb_strategy_apply";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 类型
		*/
		public static final DBField CATEGORY_ID = new DBField(DBDataType.STRING , "category_id","categoryId","类型","类型",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 项目
		*/
		public static final DBField PROJECT = new DBField(DBDataType.STRING , "project","project","项目","项目",false,false,true);
		
		/**
		 * 运行环境
		*/
		public static final DBField ENVIRONMENT_ID = new DBField(DBDataType.STRING , "environment_id","environmentId","运行环境","运行环境",false,false,true);
		
		/**
		 * 有效期
		*/
		public static final DBField PERIOD_TYPE = new DBField(DBDataType.STRING , "period_type","periodType","有效期","有效期",false,false,true);
		
		/**
		 * 过期日期
		*/
		public static final DBField EXPIRATION_DATE = new DBField(DBDataType.DATE , "expiration_date","expirationDate","过期日期","过期日期",false,false,true);
		
		/**
		 * 申请日期
		*/
		public static final DBField APPLY_DATE = new DBField(DBDataType.DATE , "apply_date","applyDate","申请日期","申请日期",false,false,true);
		
		/**
		 * 期望日期
		*/
		public static final DBField EXPECTED_COMPLETION_DATE = new DBField(DBDataType.DATE , "expected_completion_date","expectedCompletionDate","期望日期","期望日期",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 完成日期
		*/
		public static final DBField COMPLETION_DATE = new DBField(DBDataType.DATE , "completion_date","completionDate","完成日期","完成日期",false,false,true);
		
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
		
		public WO_SLB_STRATEGY_APPLY() {
			this.init($NAME,"负载策略申请" , ID , CATEGORY_ID , STATUS , NAME , PROJECT , ENVIRONMENT_ID , PERIOD_TYPE , EXPIRATION_DATE , APPLY_DATE , EXPECTED_COMPLETION_DATE , CONTENT , FILE_ID , NOTES , COMPLETION_DATE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final WO_SLB_STRATEGY_APPLY $TABLE=new WO_SLB_STRATEGY_APPLY();
	}
	
	/**
	 * 负载策略
	*/
	public static class WO_SLB_STRATEGY_INFO extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wo_slb_strategy_info";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 源名称
		*/
		public static final DBField SOURCE_NAME = new DBField(DBDataType.STRING , "source_name","sourceName","源名称","源名称",false,false,true);
		
		/**
		 * 源IP
		*/
		public static final DBField SOURCE_IP = new DBField(DBDataType.STRING , "source_ip","sourceIp","源IP","源IP",false,false,true);
		
		/**
		 * 目标名称
		*/
		public static final DBField TARGET_NAME = new DBField(DBDataType.STRING , "target_name","targetName","目标名称","目标名称",false,false,true);
		
		/**
		 * 目标IP
		*/
		public static final DBField TARGET_IP = new DBField(DBDataType.STRING , "target_ip","targetIp","目标IP","目标IP",false,false,true);
		
		/**
		 * 使用协议
		*/
		public static final DBField USED_PROTOCOL_TYPE = new DBField(DBDataType.STRING , "used_protocol_type","usedProtocolType","使用协议","使用协议",false,false,true);
		
		/**
		 * 连接类型
		*/
		public static final DBField SESSION_TYPE = new DBField(DBDataType.STRING , "session_type","sessionType","连接类型","连接类型",false,false,true);
		
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
		
		public WO_SLB_STRATEGY_INFO() {
			this.init($NAME,"负载策略" , ID , SOURCE_NAME , SOURCE_IP , TARGET_NAME , TARGET_IP , USED_PROTOCOL_TYPE , SESSION_TYPE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final WO_SLB_STRATEGY_INFO $TABLE=new WO_SLB_STRATEGY_INFO();
	}
}